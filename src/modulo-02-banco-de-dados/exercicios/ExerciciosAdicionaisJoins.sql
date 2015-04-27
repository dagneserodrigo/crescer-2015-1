--1
Select Distinct Situacao as ValoresDiferentes
from Produto
group by Situacao;

--2
Select Nome,
       RazaoSocial 
From Cliente
Where Nome Like '%LTDA%'
Or RazaoSocial Like '%LTDA%';

--3
begin transaction
go

Insert Into Produto (Nome, DataCadastro, PrecoCusto, PrecoVenda, Situacao)
Values('Galocha Maragato', Convert(datetime, getdate() ,103), 35.67, 77.95, 'A');

commit

--4
Select p.Nome
from Produto p
where  Not Exists (Select i.IDProduto
				   from PedidoItem i
				   where p.IDProduto = i.IDProduto);

--5
