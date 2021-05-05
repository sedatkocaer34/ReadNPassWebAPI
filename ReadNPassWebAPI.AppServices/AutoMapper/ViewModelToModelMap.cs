using AutoMapper;
using ReadNPassWebAPI.AppServices.ViewModels;
using ReadNPassWebAPI.Domain.Entity;

namespace ReadNPass.Application.AutoMapper
{
    public class ViewModelToModelMap:Profile
    {
        public ViewModelToModelMap()
        {
            CreateMap<BookViewModel, Book>();
            CreateMap<BookClaimViewModel, BookClaim>();
            CreateMap<BookPhotoViewModel, BookPhoto>();
            CreateMap<BookDetailViewModel, BookDetail>();
            CreateMap<UserLibraryViewModel, UserLibrary>();
            CreateMap<UserViewModel, User>();
        }
    }
}
