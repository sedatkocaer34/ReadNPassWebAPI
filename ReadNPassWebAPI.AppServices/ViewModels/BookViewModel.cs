using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.ComponentModel.DataAnnotations;
using System.Text;

namespace ReadNPassWebAPI.AppServices.ViewModels
{
    public class BookViewModel
    {
        [Key]
        public Guid Id { get; set; }

        [Required(ErrorMessage = "Kitap ismi zorunludur.")]
        [DisplayName("Kitap ismi")]
        public string BookName { get; set; }

        [Required(ErrorMessage = "UserLibraryId is required.")]
        [DisplayName("UserLibraryId")]
        public Guid UserLibraryId { get; set; }
    }
}
