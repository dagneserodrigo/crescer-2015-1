Select SUBSTRING(Nome, 1, CHARINDEX(' ', Nome) - 1) AS FirstName 
From Associado;

Select Nome, ( year(getdate()) - year(DataNascimento) ) as Idade
From Associado;

Select NomeEmpregado, DATEDIFF(month, DataAdmissao, convert(datetime, '31/12/2000', 103)) as MesesTrabalhados
From Empregado
Where DataAdmissao Between convert(datetime, '01/05/1980', 103) and convert(datetime, '20/01/1982', 103);

Select top 1 cargo from Empregado;

select Nome from Associado
having max(len(Nome));

select top 1 Nome
from Associado
order by len(Nome) desc;

Select Nome, DateAdd(year, 50, DataNascimento) as DataEmQueFez50Anos  from Associado;

Select count(1), UF
From Cidade
Group by UF;

Select Nome
From Cidade
Group by Nome, UF
having Count(*) > 1;

Select ( max(IDAssociado) + 1 ) from Associado;

truncate table CidadeAux

Select * From CidadeAux;

Insert into CidadeAux
Select Distinct Nome, UF from Cidade;

select * from Cidade;