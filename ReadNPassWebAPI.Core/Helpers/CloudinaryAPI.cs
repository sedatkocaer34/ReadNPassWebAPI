using CloudinaryDotNet;
using CloudinaryDotNet.Actions;
using Microsoft.AspNetCore.Http;
using System;
using System.Collections.Generic;
using System.IO;
using System.Text;
using System.Threading.Tasks;

namespace ReadNPassWebAPI.Core.Helpers
{
    public class CloudinaryAPI : ICloudinaryAPI
    {
                    
        public const string CLOUD_NAME = "";
        public const string API_KEY = "";
        public const string API_SECRET = "";
        public static Cloudinary cloudinary;
        public CloudinaryAPI()
        {
            Account account = new Account(CLOUD_NAME, API_KEY, API_SECRET);
            cloudinary = new Cloudinary(account);
        }

        public async Task<string> uploadImage(IFormFile image)
        {
            string url = null;
            try
            {
                List<string> urlList = new List<string>();
                ImageUploadParams uploadParams = new ImageUploadParams();

                using (var memoryStream = new MemoryStream())
                {
                    await image.CopyToAsync(memoryStream);

                    memoryStream.Position = 0; // set cursor to the beginning of the stream.

                    uploadParams.File = new FileDescription(image.FileName, memoryStream);
                    uploadParams.EagerTransforms = new List<Transformation>
                    {
                         new EagerTransformation().Width(200).Height(150).Crop("scale"),
                         new EagerTransformation().Width(500).Height(200).Crop("scale")
                     };

                    ImageUploadResult result = await cloudinary.UploadAsync(uploadParams);
                    url = result.Url.AbsolutePath;
                   return url;

                }
            }
            catch (Exception e)
            {
                Console.WriteLine(e.Message);
                return url;
            }
        }
    }
}
