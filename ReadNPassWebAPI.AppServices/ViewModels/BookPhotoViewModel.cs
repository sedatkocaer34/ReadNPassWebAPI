using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.ComponentModel.DataAnnotations;
using System.Text;

namespace ReadNPassWebAPI.AppServices.ViewModels
{
    public class BookPhotoViewModel
    {
        [Key]
        public Guid Id { get; set; }

        [Required(ErrorMessage = "BookId is required.")]
        [DisplayName("BookId")]
        public Guid BookId { get; set; }
        // Buraya ne yazacağımı bulamadım 
        [Required(ErrorMessage = "Fotoğraf zorunludur.")]
        [DisplayName("Fotoğraf")]
        public string BookPhotoUrl { get; set; }
    }
}
