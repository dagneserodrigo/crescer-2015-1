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
Select Nome,
	   UF
from Cidade c
Where not exists (Select IDCidade
				  from Associado a
				  Where a.IDCidade = c.IDCidade);
	   	  
--4
(Select a.Nome, 
		c.IDCidade,
		(Case When UF = 'RS' then '***'
			  When UF = 'SC' then '***'
			  When UF = 'PR' then '***'
			  Else null
			  End) UF
from Associado a
inner join Cidade c on c.IDCidade = a.IDCidade);

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
Where IDEmpregado in (Select e.IDEmpregado
					  from Empregado e
                      inner join Departamento d on e.IDDepartamento = d.IDDepartamento
                      Where d.Localizacao = 'SAO PAULO');

rollback
commit

--7


--8
Select d.NomeDepartamento
from Departamento d
Where EXISTS (Select MAX(e.IDDepartamento)
			  From Empregado e
			  where e.IDDepartamento = d.IDDepartamento);

--9

--10
Select c.Nome
From Cidade c
Where EXISTS (Select 1
		      From Associado a
			  where a.IDCidade = c.IDCidade);