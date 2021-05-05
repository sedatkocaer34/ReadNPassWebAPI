using AutoMapper;
using ReadNPassWebAPI.AppServices.ViewModels;
using ReadNPassWebAPI.Domain.Entity;

namespace ReadNPass.Application.AutoMapper
{
    public class ModelToViewModelMap: Profile
    {
        public ModelToViewModelMap()
        {
            CreateMap<Book, BookViewModel>();
            CreateMap<BookClaim, BookClaimViewModel>();
            CreateMap<BookDetail, BookDetailViewModel>();
            CreateMap<BookPhoto, BookPhotoViewModel>();
            CreateMap<UserLibrary, UserLibraryViewModel>();
            CreateMap<User, UserViewModel>();
        }
    }
}
