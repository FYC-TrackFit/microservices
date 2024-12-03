using FycRestApi.Mapper;
using FycRestApi.Repository;
using FycRestApi.Service;
using FycRestApi.Service.Interface;
using Microsoft.EntityFrameworkCore;

var builder = WebApplication.CreateBuilder(args);

// Add services to the container.

builder.Services.AddControllers();
// Learn more about configuring Swagger/OpenAPI at https://aka.ms/aspnetcore/swashbuckle
builder.Services.AddEndpointsApiExplorer();
builder.Services.AddSwaggerGen();

builder.Services.AddDbContext<ApplicationDbContext>();

builder.Services.AddScoped<CategorieExerciceRepository>();
builder.Services.AddScoped<ExerciceRepository>();
builder.Services.AddScoped<SeanceRepository>();
builder.Services.AddScoped<SportifRepository>();
builder.Services.AddScoped<TypeExerciceRepository>();

builder.Services.AddScoped<ISportifService, SportifService>();
builder.Services.AddScoped<ICategorieExerciceService, CategorieExerciceService>();
builder.Services.AddScoped<ITypeExerciceService, TypeExerciceService>();
builder.Services.AddScoped<ISeanceService, SeanceService>();
builder.Services.AddScoped<IExerciceService, ExerciceService>();

builder.Services.AddScoped<SeanceMapper>();
builder.Services.AddScoped<TypeExerciceMapper>();
builder.Services.AddScoped<ExerciceMapper>();
builder.Services.AddAutoMapper(typeof(Program));

var app = builder.Build();

using (var scope = app.Services.CreateScope())
{
    var dbContext = scope.ServiceProvider.GetRequiredService<ApplicationDbContext>();
    dbContext.Database.Migrate();
}


// Configure the HTTP request pipeline.
if (app.Environment.IsDevelopment())
{
    app.UseSwagger();
    app.UseSwaggerUI();
}

app.UseHttpsRedirection();

app.UseAuthorization();

app.MapControllers();

app.Run();