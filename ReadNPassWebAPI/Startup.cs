using Microsoft.AspNetCore.Builder;
using Microsoft.AspNetCore.Hosting;
using Microsoft.AspNetCore.HttpsPolicy;
using Microsoft.AspNetCore.Mvc;
using Microsoft.EntityFrameworkCore;
using Microsoft.Extensions.Configuration;
using Microsoft.Extensions.DependencyInjection;
using Microsoft.Extensions.Hosting;
using Microsoft.Extensions.Logging;
using ReadNPass.Application.AutoMapper;
using ReadNPassWebAPI.AppServices.Concrete;
using ReadNPassWebAPI.AppServices.Interfaces;
using ReadNPassWebAPI.Core.Security;
using ReadNPassWebAPI.Data.Concrete;
using ReadNPassWebAPI.Data.Interfaces;
using ReadNPassWebAPI.Data.SystemDataContext;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace ReadNPassWebAPI
{
    public class Startup
    {
        public Startup(IConfiguration configuration)
        {
            Configuration = configuration;
        }

        public IConfiguration Configuration { get; }

        // This method gets called by the runtime. Use this method to add services to the container.
        public void ConfigureServices(IServiceCollection services)
        {
            services.AddControllers();

            services.AddScoped<IBookClaimService,BookClaimService>();
            services.AddScoped<IBookClaimRepository, BookClaimRepository>();

            services.AddScoped<IBookDetailService, BookDetailService>();
            services.AddScoped<IBookDetailRepository, BookDetailRepository>();

            services.AddScoped<IBookPhotoService, BookPhotoService>();
            services.AddScoped<IBookPhotoRepository, BookPhotoRepository>();

            services.AddScoped<IBookService, BookService>();
            services.AddScoped<IBookRepository, BookRepository>();

            services.AddScoped<IUserLibraryService, UserLibraryService>();
            services.AddScoped<IUserLibraryRepository, UserLibraryRepository>();

            services.AddScoped<IUserService, UserService>();
            services.AddScoped<IUserRepository, UserRepository>();

            services.AddScoped<ReadNPassWebAPIDataContext>();

            services.AddScoped<IPasswordHash, PasswordHash>();

            services.AddDbContext<ReadNPassWebAPIDataContext>(options => options.UseSqlServer("DefaultConnection"));

            services.AddAutoMapper(typeof(ModelToViewModelMap), typeof(ViewModelToModelMap));
        }

        // This method gets called by the runtime. Use this method to configure the HTTP request pipeline.
        public void Configure(IApplicationBuilder app, IWebHostEnvironment env)
        {
            if (env.IsDevelopment())
            {
                app.UseDeveloperExceptionPage();
            }

            //app.UseHttpsRedirection();

            app.UseRouting();

            app.UseAuthorization();

            app.UseEndpoints(endpoints =>
            {
                endpoints.MapControllers();
            });
        }
    }
}
