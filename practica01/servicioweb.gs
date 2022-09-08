  const doGet = (e = {}) => {
    const { parameter } = e;
    const { nombre = 'Ameyalli', apellido = 'Huerta', edad,estado } = parameter;
    const salida = `Hola ${nombre} ${apellido} tienes ${edad} a�os y est�s ${estado}`;
    return ContentService.createTextOutput(salida);
  };

// regresa de forma textual los par�metros leidos con post
  const doPost = (e = {}) => {
    const { parameter } = e;
    const { nombre = 'Ameyalli', apellido = 'Huerta', edad,estado } = parameter;
    const salida = `Hola ${nombre} ${apellido} tienes ${edad} a�os y est�s ${estado}`;
    return ContentService.createTextOutput(salida);
  };