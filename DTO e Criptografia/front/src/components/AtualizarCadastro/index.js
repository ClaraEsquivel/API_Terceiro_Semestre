import { useState } from "react";
import './styles.css';
import { useNavigate } from "react-router-dom";
import useMensagem from '../../hooks/useMensagem';
import MensagemFeedback from '../MensagemFeedback';
import logo from '../../assets/images/logo.png';
import axios from 'axios';

function AtualizarCadastro() {
    const [email, setEmail] = useState('');
    const [novoNome, setNovoNome] = useState('');
    const [novaSenha, setNovaSenha] = useState('');
    const navigate = useNavigate();
    const { exibirMensagem, mensagem, tipoMensagem, visivel, fecharMensagem } = useMensagem();

    const atualizarUsuario = async () => {
        if (!email) {
            exibirMensagem('O email é obrigatório.', 'erro');
            return;
        }

        try {
            console.log('Email enviado:', email); // Log para verificar o valor do email
            const response = await axios.put(`http://localhost:8080/usuarios/${email}`, {
                nome: novoNome,
                senha: novaSenha
            });

            exibirMensagem(response.data.mensagem || 'Usuário atualizado com sucesso!', 'sucesso');
            setEmail('');
            setNovoNome('');
            setNovaSenha('');
        } catch (error) {
            let erroMsg = 'Erro ao atualizar usuário.';
            if (error.response?.data) {
                erroMsg = error.response.data.mensagem;
                if (error.response.data.erros) {
                    erroMsg += ' ' + Object.values(error.response.data.erros).join(', ');
                }
            }
            exibirMensagem(erroMsg, 'erro');
        }
    };

    return (
        <div className="container">
            <img src={logo} alt="Logo da empresa" />
            <h2>Atualizar Usuário</h2>
            <form onSubmit={(e) => { e.preventDefault(); atualizarUsuario(); }}>
                <input 
                    type="email"
                    id="email"
                    placeholder="E-mail"
                    value={email}
                    onChange={(e) => setEmail(e.target.value)}
                    required
                />
                <input 
                    type="text"
                    id="nome"
                    placeholder="Novo Nome"
                    value={novoNome}
                    onChange={(e) => setNovoNome(e.target.value)}
                    required
                />
                <input 
                    type="password"
                    id="senha"
                    placeholder="Nova Senha (deixe em branco para não alterar)"
                    value={novaSenha}
                    onChange={(e) => setNovaSenha(e.target.value)}
                />
                <button type="submit">Atualizar</button>
            </form>

            <button onClick={() => navigate('/usuarios')} className="link-usuarios">
                Ver usuários cadastrados
            </button>

            <MensagemFeedback
                mensagem={mensagem}
                tipo={tipoMensagem}
                visivel={visivel}
                onclose={fecharMensagem}
            />
        </div>
    );
}

export default AtualizarCadastro;