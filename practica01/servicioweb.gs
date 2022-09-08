  const doGet = (e = {}) => {
    const { parameter } = e;
    const { nombre = 'Ameyalli', apellido = 'Huerta', edad,estado } = parameter;
    const salida = `Hola ${nombre} ${apellido} tienes ${edad} años y estás ${estado}`;
    return ContentService.createTextOutput(salida);
  };

// regresa de forma textual los parámetros leidos con post
  const doPost = (e = {}) => {
    const { parameter } = e;
    const { nombre = 'Ameyalli', apellido = 'Huerta', edad,estado } = parameter;
    const salida = `Hola ${nombre} ${apellido} tienes ${edad} años y estás ${estado}`;
    return ContentService.createTextOutput(salida);
  };