--1
Select SUBSTRING(Nome, 1, CHARINDEX(' ', Nome) - 1) AS FirstName 
From Associado;

--2
Select Nome, ( year(getdate()) - year(DataNascimento) ) as Idade
From Associado;

--3
Select NomeEmpregado, DATEDIFF(month, DataAdmissao, convert(datetime, '31/12/2000', 103)) as MesesTrabalhados
From Empregado
Where DataAdmissao Between convert(datetime, '01/05/1980', 103) and convert(datetime, '20/01/1982', 103);

--4
Select top 1 --WITH TIES para trazer registros com o mesmo valor
	cargo,
	COUNT(1) as Total_Empregados
from Empregado
group by Cargo
order by Total_Empregados Desc;

--5
select top 1 Nome
from Associado
order by len(Nome) desc;

--6
Select 
	Nome,
	DateAdd(year, 50, DataNascimento) as DataEmQueFez50Anos,
	DATENAME(WEEKDAY, DateAdd(year, 50, DataNascimento))
from Associado;

--7
Select UF,
	   count(1) as QuantidadeCidades
From Cidade
Group by UF;

--8
Select Nome
From Cidade
Group by Nome, UF
having Count(*) > 1;

--9
Select ( max(IDAssociado) + 1 ) as ProximoID from Associado;

--10
truncate table CidadeAux
Select * From CidadeAux;

insert into CidadeAux (IDCidade, Nome, UF)
Select MIN(IDCidade) MenorIDCidade,
	   Nome,
	   UF
From Cidade
Group by Nome, UF;

--11
begin transaction

UPDATE Cidade
SET Nome = '*' + Nome
Where IDCidade IN (Select MAX(IDCidade)
			 From Cidade
			 Group by Nome, UF
			 having Count(*) > 1);

select * from Cidade

commit
rollback

--12
Select Nome, 
       (CASE WHEN Sexo = 'M' THEN 'Masculino'
		WHEN Sexo = 'F' THEN 'Feminino'
		ELSE 'Outro'
		END) AS Genero
from Associado;

--13
Select NomeEmpregado,
	   Salario,
	   (CASE WHEN Salario > 2326.00 THEN (Salario*0.275)
		WHEN Salario between 1164.01 and 2326.00 THEN (Salario*0.15)
		ELSE 0 END) as ValorASerDescontado
from Empregado;


--14
begin transaction

Delete from Cidade
Where SUBSTRING(Nome, 1, 1) = '*';

commit
rollback

--15
alter table cidade add constraint uk_nome_uf unique(Nome, Uf);

--teste
insert into Cidade (IDCidade, Nome, UF)
   values (27, 'Rio de Janeiro', 'RJ');