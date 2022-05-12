module.exports = {
    "invalid_cliente_request_body_missing_paramiter":  {
        'nome': 'Cliente - Test Automation',
        'telefone': '3030-2020',
        'email': 'auto_test@ufrpe.com'
      },
    "invalid_cpf_cliente_request_body_invalid_paramiter":  {
        'nome': 'Cliente - Test Automation',
        'cpf': 'invalido',
        'telefone': '3030-2020',
        'email': 'auto_test@ufrpe.com'
      },
      "invalid_telefone_cliente_request_body_invalid_paramiter":  {
        'nome': 'Cliente - Test Automation',
        'cpf': '111.222.333-44',
        'telefone': 'invalido',
        'email': 'auto_test@ufrpe.com'
      },
      "invalid_email_cliente_request_body_invalid_paramiter":  {
        'nome': 'Cliente - Test Automation',
        'cpf': '111.222.333-44',
        'telefone': '3030-2020',
        'email': 'invalido'
      },
    "invalid_cliente_request_body_null_paramiter":  {
        'nome': 'Cliente - Test Automation',
        'cpf': null,
        'telefone': '3030-2020',
        'email': 'auto_test@ufrpe.com'
      },
    "invalid_cliente_request_body_wrong_paramiter_name":  {
        'nome': 'Cliente - Test Automation',
        'wrong': '111.222.333-44',
        'telefone': '3030-2020',
        'email': 'auto_test@ufrpe.com'
      },
    "invalid_cliente_request_body_blank_space": {
        'nome': ' ',
        'cpf': '111.222.333-44',
        'telefone': '3030-2020',
        'email': 'auto_test@ufrpe.com'
      },
    "invalid_cliente_request_body_empty_paramiter": {
        'nome': '',
        'cpf': '111.222.333-44',
        'telefone': '3030-2020',
        'email': 'auto_test@ufrpe.com'
      }
}