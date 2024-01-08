import React, { useState } from 'react';
import { useHistory } from 'react-router-dom';

const Login = ({ onLogin }) => {
    const [email, setEmail] = useState('');
    const [password, setPassword] = useState('');

    const handleSubmit = async (e) => {
        e.preventDefault();

        // Aquí deberías realizar una solicitud a tu API para autenticar al usuario
        // Puedes usar fetch() u otra biblioteca como axios

        try {
            const response = await fetch('http://localhost:8080/api/login', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json',
                },
                body: JSON.stringify({ email, password }),
            });

            const data = await response.json();

            // Verifica si la autenticación fue exitosa
            if (response.ok) {
                // Llama a la función proporcionada por el componente padre
                // para manejar el inicio de sesión exitoso
                onLogin(data.token); // Puedes pasar el token u otra información según tus necesidades

                history.push('/otro-formulario');
            } else {
                // Maneja errores de autenticación
                console.error('Error en la autenticación:', data.error);
            }
        } catch (error) {
            console.error('Error en la solicitud:', error);
        }
    };

    return (
        <div class='login'>
            <h2>Iniciar Sesión</h2>
            <form onSubmit={handleSubmit}>
                <label htmlFor="email">Correo:</label>
                <input
                    type="text"
                    id="email"
                    value={email}
                    onChange={(e) => setEmail(e.target.value)}
                    required
                />

                <br />

                <label htmlFor="password">Contraseña:</label>
                <input
                    type="password"
                    id="password"
                    value={password}
                    onChange={(e) => setPassword(e.target.value)}
                    required
                />

                <br />

                <button type="submit">Iniciar Sesión</button>
            </form>
        </div>
    );
};

export default Login;
