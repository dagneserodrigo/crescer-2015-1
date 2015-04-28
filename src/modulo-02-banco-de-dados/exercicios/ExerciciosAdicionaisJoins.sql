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
Select d.UF as EstadosComMaiorNumero
from Cidade d
where IDCidade = (Select top 1 IDCidade
				  From Cliente c
			      group by c.IDCidade
			      order by count(c.IDCidade) desc)
Union All   
Select d.UF
from Cidade d
where IDCidade = (Select top 1 IDCidade
				   From Cliente c
			       group by c.IDCidade
			       order by count(c.IDCidade) asc);

--6
Select count(distinct d.Nome) as TotalCidadesDistintas
from Cidade d
inner join Cliente c on d.IDCidade = c.IDCidade
inner join Pedido p on c.IDCliente = p.IDCliente;


--7
Select p.Nome
from Produto p
left join ProdutoMaterial m on p.IDProduto = m.IDProduto
Where m.IDProduto is null;

--8
Select p.IDProduto, p.Nome, p.PrecoCusto, sum(m.PrecoCusto) as PreçoCustoMateriais
from Produto p
inner join ProdutoMaterial pm on p.IDProduto = pm.IDProduto
inner join Material m on pm.IDMaterial = m.IDMaterial
group by p.IDProduto, p.Nome, p.PrecoCusto;


--9


--10
Select Nome
from Cliente
group by Nome
Having count(Nome) > 1

--11
Select top 1 SUBSTRING(Nome, 1, CHARINDEX(' ', Nome) - 1) AS PrimeiroNomeMaisPoupular
From Cliente
group by SUBSTRING(Nome, 1, CHARINDEX(' ', Nome) - 1)
order by PrimeiroNomeMaisPoupular desc;

--12
Select Top 1 p.IDProduto, p.Nome, Sum(i.Quantidade) as QuantidadeTotal
from Produto p
inner join PedidoItem i on p.IDProduto = i.IDProduto
group by p.IDProduto, p.Nome
order by QuantidadeTotal desc;