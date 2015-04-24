--1
Select e.NomeEmpregado,
	   d.NomeDepartamento
from Empregado e
inner join Departamento d on e.IDDepartamento = d.IDDepartamento;

--2
Select a.Nome,
	   c.Nome
from Associado a
left join Cidade c on a.IDCidade = c.IDCidade; 

--3
Select UF,
	   Count(1) As TotalDeCidades
from Cidade c
Where not exists (Select IDCidade
				  from Associado a
				  Where a.IDCidade = c.IDCidade)
group by UF;
	   	  
--4
--create view vw_Cidade_Regiao as
(Select a.Nome, 
		c.IDCidade,
		(Case When c.UF in ('RS', 'SC', 'PR') then '***'
			  Else null
			  End) RegiaoSul
from Associado a
inner join Cidade c on c.IDCidade = a.IDCidade);

--utilizando view
select * from vw_Cidade_Regiao

--5
Select e.NomeEmpregado,
	   d.NomeDepartamento as departamentoEmpregado,
	   g.NomeEmpregado,
	   dep.NomeDepartamento as departamentoGerente
from Empregado e
inner join Empregado g on e.IDGerente = g.IDGerente
inner join Departamento d on e.IDDepartamento = d.IDDepartamento
inner join Departamento dep on e.IDDepartamento = dep.IDDepartamento 

--6
begin transaction
go

select * 
into EmpregadoCopy
from Empregado;

Update Empregado
Set Salario = (Salario + (Salario*0.145))
Where IDDepartamento in (Select IDDepartamento
					  from Departamento d
                      Where d.Localizacao = 'SAO PAULO');
rollback
commit

--7
Select SUM(EmpregadoCopy.Salario) as TotalSalarioAnterior,
	   SUM(Empregado.Salario) as TotalSalarioAtual,
       (SUM(Empregado.Salario) - SUM(EmpregadoCopy.Salario)) as DiferencaSalarial
from Empregado
join EmpregadoCopy on Empregado.IDEmpregado = EmpregadoCopy.IDEmpregado;

--8
Select d.NomeDepartamento
from Departamento d
Where d.IDDepartamento IN (Select top 1 e.IDDepartamento
						   From EmpregadoCopy e
						   group by e.IDDepartamento
						   order by 1 desc);

--9
Select a.Nome,
	   c.Nome
from Associado a
inner join Cidade c on a.IDCidade = c.IDCidade
Union
Select e.NomeEmpregado,
	   d.Localizacao
from Empregado e
inner join Departamento d on e.IDDepartamento = d.IDDepartamento;

--10
Select c.Nome
From Cidade c
Where EXISTS (Select 1
		      From Associado a
			  where a.IDCidade = c.IDCidade);