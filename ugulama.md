# Hastane Randevu Sistemi

1. Basit bir hastane randevu sistemi kurgulayacağız.
    * Bunun için bir database tasarımı yapalım. DrawSQL kullanarak öncelikle olması gereken
      tabloları ve tablo içindeki kolonları ve kolonlardaki veri tiplerini belirlemeye çalışalım. (20dk)


2. Dependencies ler doğru eklenmeli. (postgresql,hibernate,lombok)
3. Entityler, Repositoryler, Service katmanları olmalıdır. (lombok kullanılabilir)
4. Repository katmanında yardımcı interface'imiz ICrud ve RepositoryManager sınıfıları kullanılmalıdır.
5. Dummy Data Oluşturma
    * Oluşturduğumuz tablolara kayıtların bir önceki projedeki gibi utility altına DemoData sınıfı içindeki
      createDemoData() metodu benzeri bir şekilde eklenmeleri gereklidir.
    * Kayıt olarak
        * en az 20 hasta
        * en az 5 doktor
        * en az 10 branş
        * en az 100 randevu eklemelisiniz.


6. Aşağıdaki sorgulama işlemlerine karşılık verecek metodları uygun katmanda uygun şekilde yazınız. Burada
   repositorylerimiz yeterli geliyorsa kullanabilirsiniz. Yeterli gelmiyorsa metod içinde JPQL ile sorgular yazıp
   kullanabilirsiniz.
7. Sorgulamalar:
    * Adı verilen hastanın tüm randevularını listelesin.
    * Adı verilen hasta Hangi branştan kaç randevu almış, listelesin.
    * Adı verilen hasta Belirli bir tarih aralığında aldığı tüm randevuları listelensin.
    * Bir hastanın son ziyaret tarihini döndürün

    * Adı verilen doktor kaç hasta bakmıştır?
    * Bellirli bir branşta görev yapan doktorlar kimlerdir?
    * Bir doktorun belirli bir tarih aralığında kaç randevusu olduğunu listeleyin
    * Belirli bir tarih aralığında en çok randevu veren doktoru listeleyen bir metod.

    * En çok randevu alan 3 branşı listeleyin
    * Belirli bir branşta en çok randevuya sahip hastaları listeleyen bir metod.