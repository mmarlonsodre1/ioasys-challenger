# ioasys-challenger
desafio ioasys Android

# Arquitetura
  * MVP ( View <=> Presenter <- DataProvider <- Domain )

# Bibliotecas
  * io.github.inflationx:calligraphy3 e io.github.inflationx:viewpump para mudar a fonte do texto
  * com.squareup.retrofit2:retrofit para fazer as chamadas a API
  * com.squareup.retrofit2:converter-gson para converter a resposta em um objeto
  * com.squareup.okhttp3:logging-interceptor interceptar a chamada e gerar o log
  * org.jetbrains.kotlinx:kotlinx-coroutines-android e androidx.lifecycle:lifecycle-runtime-ktx para a utilização de Coroutines
  * androidx.multidex:multidex por conta do tamanho do APK
  * androidx.navigation:navigation-fragment-ktx e androidx.navigation:navigation-ui-ktx para utilizar o navigation e utilizar ele também pela toolbar
  * com.github.bumptech.glide:glide e com.github.bumptech.glide:compiler para gerar imagens através de links na internet

# O que faria se tivesse mais tempo
Tive somente 7-8hrs de atuação neste desafio.
Caso tivesse mais tempo, faria:
  * Refatoração do código
  * Enviroment de build para release
  * Utilização do pro-guard
  * Criar variantes relacionadas com o enviroment de build (baseUrl ser gerada programaticamente de acordo com o enviroment)
  * teste unitário
  * MVVM + Modular
  * Animações
  * Utilizar mais do Jetpack (Compose, etc.)
  * Criar domains, invés de utilizar somente o DataProvider
  * Deixar a parte de rede mais genérica
  * Corrigir o layout, ainda faltaram algumas coisas que estava na SPEC
  * Verificar tempo do token e deslogar o usuário (Acabei esquecendo de implementar)
  * Fazer uma avaliação do código após um tempo para verificar o que poderia melhorar
  * Trabalhar com cache
  * Deixar layout responsivo

# Como rodar o projeto
  * Faça um clone do projeto
  * Abra o projeto pelo Android Studio 
  * Deixe no enviroment de DEBUG
  * Rode o projeto
