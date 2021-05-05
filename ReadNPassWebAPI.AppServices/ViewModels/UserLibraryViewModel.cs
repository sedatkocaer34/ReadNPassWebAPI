using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.ComponentModel.DataAnnotations;
using System.Text;

namespace ReadNPassWebAPI.AppServices.ViewModels
{
    public class UserLibraryViewModel
    {
        [Key]
        public Guid Id { get; set; }
        
        [Required(ErrorMessage = "Kütüphane ismi zorunludur.")]
        [DisplayName("Kütühpane ismi")]
        public string LibraryName { get; set; }
        
        [Required(ErrorMessage = "UserId is required.")]
        [DisplayName("UserId")]
        public Guid UserId { get; set; }

    }
}
