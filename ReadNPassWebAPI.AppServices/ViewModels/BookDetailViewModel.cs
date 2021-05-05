using System;
using System.ComponentModel;
using System.ComponentModel.DataAnnotations;

namespace ReadNPassWebAPI.AppServices.ViewModels
{
    public class BookDetailViewModel
    {
        [Key]
        public Guid Id { get; set; }
        public Guid BookId { get; set; }
        [Required(ErrorMessage = "Kitap Açıklaması zorunludur.")]
        [DisplayName("Kitap Açıklaması")]
        public string BookDescription { get; set; }

        [Required(ErrorMessage = "Yazar Adı zorunludur.")]
        [DisplayName("Yazar Adı")]
        public string WriterName { get; set; }

        [Required(ErrorMessage = "Kitap Türü zorunludur.")]
        [DisplayName("Kitap Tür")]
        public string BookKind { get; set; }

        [Required(ErrorMessage = "Kitap Fiyatı zorunludur.")]
        [DisplayName("Kitap Fiyatı")]
        public double BookPrice { get; set; }

        //TODO Enum olarak tanımalanan valueler burada takas ya da kiralama olarak işlenecel ve veri tabanınan o şekilde kayit edilecek.
    }
}
