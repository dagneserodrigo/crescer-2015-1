Select NomeEmpregado as Nome
From Empregado
Order by DataAdmissao;

Select NomeEmpregado, (Salario * 12)
From Empregado
Where Cargo = 'Atendente'
or (Salario * 12) < 18500.00;

Select IDCidade from Cidade
Where nome = 'Uberlândia';


Select IDCidade, Nome from Cidade
Where UF = 'RS';