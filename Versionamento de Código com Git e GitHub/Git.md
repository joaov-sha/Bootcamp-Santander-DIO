# Git e GitHub

### Oque é ?

- Git: É uma ferramenta para controle de versão de código
- GitHub: É uma de muitas plataformas utilizadas como servidor de arquivos para versionamento de código em conjunto com o Git


### Fluxo básico
- Git pull: Serve para buscar o código armazenado no servidor
- Git push: Serve para enviar o código criado/gerado para o servidor

### Fluxo comum de instalação

Após concluída a instalação normal do aplicativo
- Configure o nome de usuário com: `git config --global user.name "nomeDeUsuario"`
- Configure o email de usuário com: `git config --global user.email "email@email.com"`

Para verificar se as configurações foram realizadas corretamente
- Utilize o comando `git config user.nome` para visualizar o nome
- Utilize o comando `git config user.email` para visualizar o email
- Pode-se utilizar também o comando `git config --global --list`

 ##### *Obs.:* O nome e o e-mail configurados nesta etapa serão os que aparecerão futuramente nos *commits* realizados na plataforma do GitHub.

Para alterarmos a configuração realizada na etapa de instalação do software na máquina:

- Utilizaremos o comando: `git config init.defaultBranch nomeDaBranch`

### Fluxo de autenticação via token no GitHub

Perfil -> Configurações -> Configurações do Desenvolvedor -> Tokens de acesso Pessoal -> Tokens (classic) -> Gerar novo token (classic)

Os tokens podem ser tanto gerados por necessidade, quanto, salvos para reutilização na máquina local. 

Para salvarmos locamente os tokens na máquina existem duas opções:

- Utilizando o comando: `git config --global credential.helper cache`

*Este que salva temporariamente uma cópia do token na máquina do usuário, melhor utilizado em máquinas compartilhadas*

- Utilizando o comando: `git config --global credential.helper store`

*Este que salva permanentemente uma cópia do token na máquina do usuário, melhor utilizado em máquinas privadas*

Para verificar onde está sendo salvo o arquivo podemos utilizar o seguinte comando:

- `git config --global --show-origin credential.helper`

*Feito isto será exibido no console o caminho do arquivo por exemplo: file:C/Users/nomeDeUsuário/.gitconfig*

Para verificar o conteúdo do arquivo, após navegarmos até o local onde está o mesmo, podemos utilizar o seguinte comando:

- `cat .gitconfig`

### Fluxo de autenticação via chave SSH

Perfil -> Configurações -> Chaves SSH e GPG 

Para gerar a chave pode se utilizar o seguinte comando:

- `ssh-keygen -t ed25519 -C "seu_email@exemplo.com"`

ou

- `ssh-keygen -t rsa -b 4096 -C "seu_email@exemplo.com"`

Sendo o primeiro o mais atual e por isso pode ser incompatível com máquinas mais antigas que não possuem o suporte ao sistema de criptografia ed25519 como específicado no comando

Para salvar este tipo de chave utiliza-se outro processo, este sendo iniciado através do seguinte comando:

- `eval "$(ssh-agent -s)"`

Iniciado o processo, então utiliza-se o seguinte comando:

- `ssh-add ~/.ssh/id_ed25519`

Perfil -> Configurações -> Chaves SSH e GPG -> Nova chave SSH

Após navegarmos até onde está localizado o arquivo, devemos visualizar o conteúdo deste através do seguinte comando:

- `cat id_ed25519.pub`

e então copiar e colar o conteúdo deste arquivo no painel descrito como chave na plataforma.

### Criar e clonar repositórios no Git

Através da interface do S.O.

 - Criar nova pasta > entrar na pasta > git init

Através do console do git

- mkdir nomeDaPasta > cd nomeDaPasta > git init

##### *Obs.: O resultado dos comandos anteriores é a criação de um repositório local do git*

Feito isso, devemos utilizar o seguinte comando:

- `git remote add origin url_do_repositório_no_github`

Para então vincularmos o repositório criado localmente com o repositório remoto

Para clonar um repositório do servidor remoto (GitHub) para a máquina local utiliza-se o seguinte comando:

- `git clone url_do_repositório`

Para renomear o repositório ao cloná-lo pode ser utilizado o comando da seguinte forma:

- `git clone url_do_repositório nomeLocalDaPasta`

Para verificarmos se o repositório local está conectado a algum repositório remoto podemos utilizar o seguinte comando:

- `git remote -v`

### Fluxo de trabalho para criação e alteração de arquivos no repositório remoto

Ao criarmos arquivos de código ou outro tipo de arquivo, para salvarmos os mesmos no repositório remoto devemos:

- Adicionar os arquivos através do comando `git add .`

*O ponto refere-se a adicionar todos*

Para verificarmos a situação das alterações do repositório, podemos utilizar o seguinte comando:

- `git status`

Ao salvarmos os arquivos para serem enviados ao repositório remoto, pode acontecer de não querermos que algo seja salvo (por exemplo: senhas, chaves de api, etc.)

Nestes casos, podemos utilizar o seguinte arquivo, para adicionarmos as instruções de quais arquivos não devem ser salvos no projeto disponível no GitHub:

- `.gitignore`

Salvando as instruções da seguinte forma dentro deste arquivo:

- `diretorioExemplo/`

Fará com que a pasta mencionada não seja salva, porém, é possível também realizar o contrário, onde ao criarmos um diretório, e deixá-lo vazio, queremos que seja salvo, podemos dar as mesmas instruções dentro do arquivo:

- `.gitkeep`

E por fim, para salvarmos as alterações no repositório remoto utilizamos o seguinte comando:

- `git commit -m "Mensagem explicativa"`

onde a mensagem deve explicar quais foram as alterações realizadas pelo usuário em determinados arquivos.

### Fluxo de trabalho para desfazer alterações criadas

Para retornarmos a um diretório padrão, deixando de ser um repositório git, podemos utilizar o seguinte comando no console:

- `rm -rf .git`

Para reverter alterações realizadas em arquivos locais, podemos utilizar o seguinte comando:

- `git restore nomeDoArquivo`

Para alterar mensagens de commit, podemos utilizar o seguinte comando:

- `git commit --amend -m "Nova mensagem explicativa"`

Para desfazermos alterações de modo a voltar a versões anteriores dos projetos no repositório remoto, podemos utilizar o seguinte comando:

- `git reset --soft hashDoCommitAoQualRetornaremos`

*Obs.: Esta versão do comando já adiciona os arquivos presentes no commit à área de preparação, onde então deveremos executar apenas o fluxo de salvamento de arquivo novamente.*

Já o comando da seguinte forma:

- `git reset --mixed`

É o comando em sua versão padrão, podendo ser executado também da seguinte forma:

- `git reset`

*Obs.: Esta versão do comando, não adiciona os arquivos presentes na área de preparação, fazendo assim com que precisemos adicionar os arquivos na área de preparação, e então salvá-los.*

Já desta seguinte forma:

- `git reset --hard`

O comando também desfaz as alterações criadas pelo usuário, por exemplo: removendo arquivos criados pelo usuário do diretório.

Já para removermos arquivos adicionados à área de preparação, podemos utilizar os seguintes comandos:

- `git reset nomeDoArquivo`  
ou
- `git restore --staged nomeDoArquivo`

Para atualizarmos o repositório local com os arquivos do repositório remoto, podemos utilizar o seguinte comando:

- `git pull`

### Fluxo de utilização de branches

Para realizar a troca de branch, utiliza-se o comando:

- `git checkout -b nomeExemplo`

Para retornar à branch main, utiliza-se o comando:

- `git checkout main`

Para mesclar alterações criadas em branches diferentes, utiliza-se o seguinte comando:

- `git merge nomeExemplo`

Para removermos uma branch, utilizamos o seguinte comando:

- `git branch -d nomeExemplo`

### Fluxo de resolução de conflitos

Para solucionarmos conflitos de envio e recebimento de alterações nos arquivos, primeiro utilizamos o comando

- `git pull`

Depois verificamos os arquivos, para visualizar onde estão os conflitos, realizadas as alterações no arquivo para refletir oque deve ser salvo, salvamos os arquivos e então realizamos um novo

- `git push origin main`

### Comandos úteis

Para visualizar alterações no repositório remoto sem salvá-las no nosso repositório local, podemos utilizar o seguinte comando:

- `git fetch`

Este que apenas nos traz uma cópia do arquivo remoto.

E que caso desejemos salvá-lo em nossa máquina local, poderemos utilizar o comando:

- `git merge origin/main`

Para clonar branch específica de repositório, podemos utilizar o seguinte comando:

git clone url_do_repositorio_remoto --branch branchASerClonada --single-branch

Para arquivar modificações em branches específicas, podemos utilizar o seguinte comando:

- `git stash`

Para verificar as modificações arquivadas na branch, utiliza-se o seguinte comando:

- `git stash list`

Para excluir as últimas modificações arquivadas, utiliza-se o seguinte comando:

- `git stash pop`

Para efetivar as últimas modificações arquivadas, utiliza-se o seguinte comando:

- `git stash apply`

## Referências
- [Git](https://git-scm.com "Link para a ferramenta Git")
- [GitHub](https://docs.github.com "Link para a documentação do GitHub")
- [GitHubBlog](https://github.blog "Link para o blog do GitHub")