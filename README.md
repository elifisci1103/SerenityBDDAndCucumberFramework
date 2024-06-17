Test Automation Framework With Cucumber And Serenity BDD 
Giriş
Bu proje, Cucumber ve Serenity BDD kullanarak test süreçlerini kolaylaştırmak için tasarlanmış bir test otomasyon framework'üdür. Web ve API fonksiyonları için otomatik testlerin kolay yazılması, yürütülmesi ve raporlanmasını sağlar.
Proje Yapısı
plaintext
Kodu kopyala
testAutomationFrameworkWithCucumberAndSerenityBDD
│
├── configuration.properties
├── en yeni.zip
├── pom.xml
├── serenity.properties
├── .idea
│   ├── .gitignore
│   ├── compiler.xml
│   ├── encodings.xml
│   ├── jarRepositories.xml
│   ├── misc.xml
│   ├── uiDesigner.xml
│   └── workspace.xml
├── src
│   ├── main
│   │   └── java
│   │       └── org
│   │           └── example
│   │               └── App.java
│   └── test
│       ├── java
│       │   ├── hooks
│       │   │   └── HooksAPI.java
│       │   ├── pages
│       │   │   └── UiPage.java
│       │   ├── runners
│       │   │   ├── ApiRunnerTest.java
│       │   │   └── UiRunnerTest.java
│       │   ├── stepdefinitions
│       │   │   ├── ApiStepDefinitions.java
│       │   │   └── UiStepDefinitions.java
│       │   ├── utilities
│       │   │   ├── ApiUtils.java
│       │   │   ├── ConfigReader.java
│       │   │   ├── Driver.java
│       │   │   └── ReusableMethods.java
│       └── resources
│           └── features
│               ├── ApiTest.feature
│               └── UiTest.feature
________________________________________
Kurulum ve Kullanım Talimatları
Gereksinimler
•	Java Development Kit (JDK): 11+
•	Maven: Proje bağımlılıklarını yönetmek için
•	Jenkins:CI/CD süreçleri için
•	Gerekli bağımlılıklar (Pom.xml)
Kurulum
1.	Java JDK 11 veya daha üst bir sürümü indirin ve yükleyin
2.	Apache Maven indirin ve yükleyin.
3.	Projeyi Githubdan klonlayın veya proje dosyalarını indirin ve çıkartın.
4.	Bağımlılıkları yükleyin.Terminal veya komut satırında proje dizinine gidin ve “mvn clean install” komutunu çalıştırın.
 Kullanım
1.	Testleri Tekli Çalıştırma:Ui testlerini tek başına çalıştırmak için “UiRunnerTest” classını ,Api testlerini tek başına çalıştırmak için  “ApiRunnerTest” classını kullanın.Çalıştırmak istediğiniz testleri Runner classlarındaki @tag lar ile belirleyebilirsiniz.
2.	Testleri Raporlu Çalıştırma:Çalıştırılan testlerden rapor almak için ise terminal veya komut satırında proje dizinine gidin ve “mvn clean verify” komutunu çalıştırın.
3.	Testleri Çapraz Browser Çalıştırma:Testleri birden tarayıcıda arka arkaya çalıştırmak için Terminal veya komut satırında proje dizinine gidin ve “mvn clean verify -Dbrowser=firefox && mvn clean verify -Dbrowser=edge” komutunu çalıştırın.
4.	Testleri Paralel Çalıştırma:Paralel çalıştırmak için ise runners paketinin altında kaç tane testi aynı anda çalıştırmak istiyorsanız o kadar paralel run classı oluşturup gerekli ayarlamaları yaparak testleri terminalden aynı anda çalıştırın.
  Proje haritası
 1.Hooks=Api veya ui testleri için önceden çalıştırılıp gerekli ayarların yapılmasına olanak sağlayan metodların yer aldığı classların bulunduğu paket.
 2.Runners=Runner classlarının yer aldığı testlerin tag lar aracılığı ile çalıştırıldığı paket.
 3.Pages=Webelementlerin locatelerinin yer aldığı classların bulunduğu paket.
4.StepDefinitions=Kaynak kodların yer aldığı classların bulunduğu paket.
5.Utilities
a.ApiUtils= Ortak API test görevleri (GET, POST, PUT, DELETE) için yeniden kullanılabilir metodların yer aldığı class.
b.Driver=Ui testlerinin çalışması için WebdriverManager ın driver ayarlarını yaptığı metodların bulunduğu class.
c.ConfigReader=Configüration properties dosyasından test datalarını çekmemizi sağlayan metodun bulunduğu class.
d.ReusableMethods=Ui testleri için ortak oluşturulan yeniden kullanılabilir metodların bulunduğu class.
6.Resources=Gherkin dilinde yazılmış test senaryolarının bulunduğu features dosyalarının bulunduğu paket.
7.Target=Test raporlarının bulunduğu klasör.Burada Site/Serenity klasörü altında “screenshoots”dosyasının içinde test adımlarının ekran fotoğrafları,” index.xml “dosyasında ise test adımlarının ayrıntılı raporları yer alır.
   Cucumber ve Serenity ile Test Yazma Örnekleri
   API Testi Yazma
  @api
  Scenario: User should not be able to log in with invalid credentials
  Given API user sets "/api/users" path parameters
  When User sends a login request with "invalidUsername" and"invalidPassword"
  Then User should receive a login failure response
UI Testi Yazma
@ui
 Scenario: User should be able to login with valid credentials
  Given User is on the login page
  When User enters valid username and password
  Then User should be redirected to the homepage
________________________________________
Framework'ü Genişletme ve Yeni Testler Ekleme Rehberi
Yeni Bir API Testi Eklemek
1.	Yeni Bir Feature Dosyası Oluşturun: src/test/resources/features dizininde yeni bir feature dosyası oluşturun.
2.	Step Definitions Dosyasını Güncelleyin: src/test/java/stepdefinitions dizininde ilgili step definitions dosyasını güncelleyerek yeni adımları ekleyin.
3.	Runner Dosyasını Güncelleyin: src/test/java/runners dizininde yeni testleri çalıştıracak bir runner dosyası oluşturun veya mevcut runner dosyasını güncelleyerek yeni feature dosyasını dahil edin.
Yeni Bir UI Testi Eklemek
1.	Yeni Bir Page Object Oluşturun: src/test/java/pages dizininde yeni bir page object dosyası oluşturun.
2.	Feature Dosyasını Oluşturun: src/test/resources/features dizininde yeni bir feature dosyası oluşturun.
3.	Step Definitions Dosyasını Güncelleyin: src/test/java/stepdefinitions dizininde ilgili step definitions dosyasını güncelleyerek yeni adımları ekleyin.
4.	Runner Dosyasını Güncelleyin: src/test/java/runners dizininde yeni testleri çalıştıracak bir runner dosyası oluşturun veya mevcut runner dosyasını güncelleyerek yeni feature dosyasını dahil edin.
________________________________________
İletişim
Herhangi bir soru, öneri veya geri bildirim için benimle iletişime geçmekten çekinmeyin. Size yardımcı olmaktan mutluluk duyarım.
E-posta
Kişisel E-posta: elifisci1103@gmail.com

