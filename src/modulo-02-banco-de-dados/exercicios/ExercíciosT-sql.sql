BEGIN
	DECLARE @Nome VarChar(30)
	SET @Nome = 'CWI Software'
	Print @Nome
	Print getdate()
END

BEGIN
	DECLARE @vIDCliente int
	Select @vIDCliente = IDCliente
	From Cliente
	Where Nome = 'Mariana Ventura Che'
	Print 'Mariana possui o código ' +
	Cast(@vIDCliente AS VarChar(10))
END

BEGIN
	DECLARE ListaCidade CURSOR
		Local
		Fast_Forward
		FOR Select Nome, Uf
			From Cidade
			Group by Nome, Uf
			Having COUNT(1) > 1;
	
	DECLARE @vNome varchar(50),
	        @vUF varchar(2)
	
	OPEN ListaCidade;
	FETCH NEXT FROM ListaCidade INTO @vNome, @vUF
	
	WHILE (@@FETCH_STATUS=0) BEGIN
		Print @vNome + '/'+@vUF;
		FETCH NEXT FROM ListaCidade INTO @vNome, @vUF
	END
	
	CLOSE ListaCidade;
	DEALLOCATE ListaCidade;
END

--1
Begin
	Set Nocount on
	Declare @vID int

	Select top 1 @vID = IDProduto
	from PedidoItem 
	group by IDProduto
	order by 1 desc;

	Select IDProduto,
	       Nome
	from Produto
	Where IDProduto = @vID;

	Set Nocount off
End

--2
Begin
Set Nocount on
	Declare ListaCidades Cursor
		Local
		Fast_Forward
		For Select cid.UF, cid.Nome, count(1)
		From Cidade cid
		 inner join Cliente cli on cid.IDCidade = cli.IDCidade
		group by cid.UF, cid.Nome
		having count(1) > 1;

		Select UF, Nome
		from Cidade
		group by UF, Nome
		having count(1) > 1;

	Declare @vNome varchar(50),
	        @vUF varchar(2)
	
	Open ListaCidades;
	Fetch Next From ListaCidade Into 


Set Nocount off
End