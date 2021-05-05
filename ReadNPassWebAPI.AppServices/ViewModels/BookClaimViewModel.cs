using System;
using System.ComponentModel;
using System.ComponentModel.DataAnnotations;

namespace ReadNPassWebAPI.AppServices.ViewModels
{
    public class BookClaimViewModel
    {
        [Key]
        public Guid Id { get; set; }

        [Required(ErrorMessage = "Kitap Id zorunludur.")]
        [DisplayName("Kitap Id")]
        public Guid BookId { get; set; }

        [Required(ErrorMessage = "Kullanıcı Id zorunludur.")]
        [DisplayName("Kullanıcı Id")]
        public Guid UserId { get; set; }

        //TODO Enum olarak tanımalanan valueler burada takas ya da kiralama olarak işlenecel ve veri tabanınan o şekilde kayit edilecek.
    }
}
