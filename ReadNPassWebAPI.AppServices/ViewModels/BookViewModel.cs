using Microsoft.AspNetCore.Http;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.ComponentModel.DataAnnotations;
using System.Text;
using System.Text.Json.Serialization;

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

        [DisplayName("UserId")]
        public Guid UserId { get; set; }

        public bool Sales { get; set; }

        public bool Swap { get; set; }

        [DisplayName("BookPhoto")]
        public string BookPhoto { get; set; }

        public BookDetailViewModel BookDetailViewModel { get; set; }
        public List<BookPhotoViewModel> BookPhotos { get; set; }

        [JsonIgnore]
        public List<IFormFile> PhotoList { get; set; }
    }
}
