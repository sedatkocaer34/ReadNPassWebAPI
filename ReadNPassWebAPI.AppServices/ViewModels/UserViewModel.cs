using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.ComponentModel.DataAnnotations;
using System.Text;

namespace ReadNPassWebAPI.AppServices.ViewModels
{
    public class UserViewModel
    {
        [Key]
        public Guid Id { get; set; }

        [Required(ErrorMessage = "Ad zorunludur.")]
        [DisplayName("Ad")]
        public string Name { get; set; }

        [Required(ErrorMessage = "Soyad zorunludur.")]
        [DisplayName("Soyad")]
        public string SurName { get; set; }

        [Required(ErrorMessage = "Şifre zorunludur.")]
        [DisplayName("Şifre")]
        public string Password { get; set; }

        [Required(ErrorMessage = "Email zorunludur.")]
        [DisplayName("Email")]
        public string Email { get; set; }
        // Bu kısıma ne yazacağımı bulamadım
        [Required(ErrorMessage = "Kitap ismi zorunludur.")]
        [DisplayName("Kitap ismi")]
        public string DefaultUserProfiePhoto { get; set; }
        public double locationLatidute { get; set; }
        public double longitudeLatidute { get; set; }
    }
}
