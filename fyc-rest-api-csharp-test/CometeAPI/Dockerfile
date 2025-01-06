# On utilise l'image officielle du SDK .NET Core pour build l'application
FROM mcr.microsoft.com/dotnet/sdk:7.0 AS build
WORKDIR /app

# On copie le fichier .csproj et on restaure les dépendances
COPY *.csproj ./
RUN dotnet restore

# On copie le reste des fichiers
COPY . .

# On compile l'application
RUN dotnet publish -c Release -o out

# On crée l'image de l'application
FROM mcr.microsoft.com/dotnet/aspnet:7.0 AS runtime
WORKDIR /app
COPY --from=build /app/out ./
EXPOSE 80

# On configure le point d'entrée pour démarrer l'application
ENTRYPOINT ["dotnet", "FycRestApi.dll"]


# Ancien Dockerfile

# # Étape 1 : Utiliser l'image SDK de .NET 7.0 comme base pour la construction de l'application
# FROM mcr.microsoft.com/dotnet/sdk:7.0 AS build-env
# WORKDIR /app

# # Étape 2 : Copier les fichiers de solution et de projet, puis restaurer les dépendances
# COPY FycRestApi.sln .
# COPY CometeAPI/FycRestApi.csproj CometeAPI/
# RUN dotnet restore CometeAPI/FycRestApi.csproj

# # Étape 3 : Copier tous les fichiers de l'application et compiler
# COPY CometeAPI/ CometeAPI/
# WORKDIR /app/CometeAPI
# RUN dotnet publish -c Debug -o out

# # Étape 4 : Utiliser l'image runtime de .NET 7.0 pour exécuter l'application
# FROM mcr.microsoft.com/dotnet/aspnet:7.0
# WORKDIR /app
# COPY --from=build-env /app/CometeAPI/out .

# EXPOSE 80

# # Étape 5 : Configurer le point d'entrée
# ENTRYPOINT ["dotnet", "FycRestApi.dll"]
