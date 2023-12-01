package model.main;

import java.io.File;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import dao.DAO;
import dao.imp.GeneroDAOImp;
import dao.imp.PeliculaDAOImp;
import dominio.domain.Genero;
import dominio.domain.Pelicula;
import model.util.GestorPeliculas;

public class PrincipalDAO {
	
	public static void main(String[] args) {
		
		int opcion=0;
		while(opcion!=3) {
			opcion = getOpcion();
			procesarOpcion(opcion);
		}
	}
	
	public static int getOpcion() {
		Scanner scanner = new Scanner(System.in);
		boolean esOpcionValida = true;
		int opcion=0;
		do {
			System.out.println("----------MENU----------");
			System.out.println("Bienvenido a la app de Peliculas");
			System.out.println("1-Administrar Peliculas");
			System.out.println("2-Buscardor de Peliculas");
			System.out.println("3-Salir");
			System.out.println("\nIngrese una opción: ");
			String opcionString = scanner.next();
			try {
				opcion = Integer.parseInt(opcionString);
				if(opcion != 1 && opcion!=2 && opcion!=3) {
					System.err.println("Debe ingresar una opción válida");
					esOpcionValida = false;
				}else {
					esOpcionValida=true;
				}
			}catch(Exception ex) {
				System.err.println("Debe ingresar una opción válida");
				esOpcionValida=false;
			}
			
		}while(esOpcionValida!=true);
		
		return opcion;
	}
	
	public static void procesarOpcion(int opcion) {
		switch(opcion) {
			case 1:{
				administradorDePeliculas();
				break;
			}
			case 2:{
				buscadorDePeliculas();
				break;
			}
			case 3:{
				System.out.println("Gracias por usar la aplicación.");
				break;
			}
		}
	}
	
	public static void administradorDePeliculas() {
		
		Scanner scanner = new Scanner(System.in);
		boolean esOpcionValida = true;
		int opcion=0;
		do {
			System.out.println("----------MENU----------");
			System.out.println("1-Registrar nueva pelicula");
			System.out.println("2-Modificar pelicula");
			System.out.println("3-Eliminar pelicula");
			System.out.println("4-Salir");
			System.out.println("\nIngrese una opción: ");
			String opcionString = scanner.next();
			try {
				opcion = Integer.parseInt(opcionString);
				if(opcion != 1 && opcion!=2 && opcion!=3 && opcion!=4) {
					System.err.println("Debe ingresar una opción válida");
					esOpcionValida = false;
				}else {
					esOpcionValida=true;
				}
			}catch(Exception ex) {
				System.err.println("Debe ingresar una opción válida");
				esOpcionValida=false;
			}
			
		}while(esOpcionValida!=true);
		
		switch(opcion) {
			case 1:{
				DAO<Pelicula, Integer> peliculaDAO = new PeliculaDAOImp();
				// Solicitud de titulo de la pelicula
				String nombrePelicula;
				Pelicula pelicula = null;
				boolean esNombreValido;
				do {
			        System.out.print("Ingresar el título de la película: ");
			        scanner.nextLine();
			        
			        nombrePelicula = scanner.nextLine().trim();
			        if (nombrePelicula == null || nombrePelicula.isEmpty()) {
			            esNombreValido = false;
			            System.err.println("Debe ingresar un título de película");
			        } else {
			            if (nombrePelicula.length() > 1) {
			                nombrePelicula = nombrePelicula.substring(0, 1).toUpperCase() + nombrePelicula.substring(1).toLowerCase();
			            } else {
			                nombrePelicula = nombrePelicula.toUpperCase();
			            }

			            esNombreValido = true;
			            System.out.println("El Titulo es valido");
		                System.out.println();
			        }
			    } while (esNombreValido!=true);
				
				//Solicitud de codigo de pelicula
				int codigoPelicula = 0;
				boolean esCodigoValido;
				
				do {
					try {
					System.out.print("Ingrese el codigo de la pelicula: ");
					codigoPelicula = scanner.nextInt();
					if(codigoPelicula<0) {
						esCodigoValido=false;
						System.out.println("Debe ingresar un codigo valido para la pelicula");
						
					}else {
						boolean codigoExiste = peliculaDAO.verificarCodigo(codigoPelicula);
						if (codigoExiste) {
			                esCodigoValido = false;
			                System.out.println("El código ya existe. Ingrese un código único.");
			            } else {
			                esCodigoValido = true;
			                System.out.println("El codigo es aceptado");
			                System.out.println();
			            }
					}
					}catch (NumberFormatException e) {
						System.err.println("El codigo no puede ser un numero negativo: ");
						esCodigoValido=false;
					}
				}while(esCodigoValido!=true);
				
				//Pedimos la imagen promocional de la pelicula
				
				String nombreImagen;
				File imagenFile = null;
				Pelicula imagen = null;
				boolean esImagenValida;
			
				do {
				    System.out.print("Ingrese la ruta de la imagen de la película: ");
				    scanner.nextLine();
				    nombreImagen = scanner.nextLine().trim();
				    imagenFile = new File(nombreImagen);

				    if (!imagenFile.exists() || imagenFile.isDirectory()) {
				        esImagenValida = false;
				        System.err.println("Error: La ruta de la imagen no es válida. Por favor, ingrese una ruta de imagen válida.");
				    } else {
				        esImagenValida = true;
				        System.out.println("La imagen es correcta");
		                System.out.println();
				    }

				} while (!esImagenValida);
				
				//Creacion de la URL de la pelicula
				
				String urlPelicula;
				boolean esUrlValida;
				
				do {
					System.out.print("Ingresar la URL de la pelicula: ");
					urlPelicula = scanner.nextLine().trim();
					if(urlPelicula==null || urlPelicula.isEmpty()==true) {
						esUrlValida=false;
						System.err.println("Debe ingresar una URL de pelicula");
					}else {
						esUrlValida=true;
						System.out.println("La URL es correcta");
		                System.out.println();
					}
				}while(esUrlValida!=true);
				
				//Solicitud de genero de pelicula
				boolean esGeneroValido;
				String nombreGenero;
				
				do {
					System.out.print("Ingrese el genero de la pelicula: ");
					nombreGenero = scanner.nextLine().trim();
					if(nombreGenero==null || nombreGenero.isEmpty()==true) {
						esGeneroValido=false;
						System.out.println("Debe ingresar un genero para la pelicula");
					}else {
						if (nombreGenero.length() > 1) {
							nombreGenero = nombreGenero.substring(0, 1).toUpperCase() + nombreGenero.substring(1).toLowerCase();
			            } else {
			            	nombreGenero = nombreGenero.toUpperCase();
			            }
						esGeneroValido=true;
					}
				}while(esGeneroValido!=true);
				

				//Se crea la pelicula
				DAO<Genero, Integer> generoDAO = new GeneroDAOImp();
				try {
					Genero genero = generoDAO.obtenerOInsertarGenero(nombreGenero);
					pelicula = new Pelicula(nombrePelicula, imagenFile, codigoPelicula, urlPelicula, genero);
					peliculaDAO.insertar(pelicula);
					System.out.println("Pelicula registrada en la base de datos");
					System.out.println("Presione una tecla para continuar");
					String tecla = scanner.next();
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				break;
			}
			case 2:{
				Pelicula pelicula;
				int codActualizar = 0;
				boolean esCodigoValido;
				DAO<Pelicula, Integer> peliculaDAO = new PeliculaDAOImp();
				//Pedimos el codigo de la pelicula a actualizar
				do {
					try {
						System.out.println("Ingrese el codigo de la pelicula a actualizar: ");
						scanner.nextLine();
						codActualizar = scanner.nextInt();
						if(peliculaDAO.buscarPorCodigo(codActualizar) != null) {
							esCodigoValido=true;
							System.out.println("La pelicula fue encontrada");
						}else {
							System.out.println("La pelicula no existe con ese codigo");
							esCodigoValido=false;
						}
						
					}catch (NumberFormatException e) {
				        System.err.println("Por favor, ingrese solo numeros.");
				        scanner.nextLine();
				        esCodigoValido=false;
				    }
				}while(esCodigoValido!=true);
				
				//Cambio de titulo
				String nombrePelicula;
				
				boolean esNombreValido;
				do {
			        System.out.print("Ingrese el nuevo título de la película: ");
			        scanner.nextLine();
			        
			        nombrePelicula = scanner.nextLine().trim();
			        if (nombrePelicula == null || nombrePelicula.isEmpty()) {
			            esNombreValido = false;
			            System.err.println("Debe ingresar un título de película");
			        } else {
			            if (nombrePelicula.length() > 1) {
			                nombrePelicula = nombrePelicula.substring(0, 1).toUpperCase() + nombrePelicula.substring(1).toLowerCase();
			            } else {
			                nombrePelicula = nombrePelicula.toUpperCase();
			            }

			            esNombreValido = true;
			            System.out.println("Se cambio el titulo de la pelicula");
			            System.out.println();
			        }
			    } while (esNombreValido!=true);
				
				//Cambio de codigo
//				int codigoPelicula = 0;
//				boolean esCodigoValido2;
//				
//				do {
//					try {
//					System.out.print("Ingrese el nuevo codigo de la pelicula: ");
//					codigoPelicula = scanner.nextInt();
//					if(codigoPelicula<0) {
//						esCodigoValido2=false;
//						System.out.println("Debe ingresar un codigo valido para la pelicula");
//						
//					}else {
//						boolean codigoExiste = peliculaDAO.verificarCodigo(codigoPelicula);
//						if (codigoExiste) {
//			                esCodigoValido2 = false;
//			                System.out.println("El código ya existe. Ingrese un código único.");
//			            } else {
//			                esCodigoValido2 = true;
//			                System.out.println("Se cambió el código de la película");
//			                System.out.println();
//			            }
//					}
//					}catch (InputMismatchException  e) {
//						System.err.println("El codigo no puede ser un numero negativo: ");
//						esCodigoValido2=false;
//						scanner.next();
//					}
//				}while(esCodigoValido2!=true);
				
				//Cambio de imagen
				
				String nombreImagen;
				File imagenFile = null;
				Pelicula imagen = null;
				boolean esImagenValida;
			
				do {
				    System.out.print("Ingrese la ruta de la imagen de la película: ");
				    scanner.nextLine();
				    nombreImagen = scanner.nextLine().trim();
				    imagenFile = new File(nombreImagen);

				    if (!imagenFile.exists() || imagenFile.isDirectory()) {
				        esImagenValida = false;
				        System.err.println("Error: La ruta de la imagen no es válida. Por favor, ingrese una ruta de imagen válida.");
				    } else {
				        esImagenValida = true;
				        System.out.println("Se cambio la imagen de la pelicula");
						System.out.println();
				    }

				} while (!esImagenValida);
				
				//Cambio de URL
				String urlPelicula;
				boolean esUrlValida;
				
				do {
					System.out.print("Ingrese la nueva URL de la pelicula: ");
					urlPelicula = scanner.nextLine().trim();
					if(urlPelicula==null || urlPelicula.isEmpty()==true) {
						esUrlValida=false;
						System.err.println("Debe ingresar una URL de pelicula");
					}else {
						esUrlValida=true;
						System.out.println("Se cambio la URL de la pelicula");
						System.out.println();
					}
				}while(esUrlValida!=true);
				
				//Nuevo genero de pelicula
				boolean esGeneroValido;
				String nombreGenero;
				
				do {
					System.out.print("Ingrese el nuevo genero de la pelicula: ");
					nombreGenero = scanner.nextLine().trim();
					if(nombreGenero==null || nombreGenero.isEmpty()==true) {
						esGeneroValido=false;
						System.out.println("Debe ingresar un genero para la pelicula");
					}else {
						if (nombreGenero.length() > 1) {
							nombreGenero = nombreGenero.substring(0, 1).toUpperCase() + nombreGenero.substring(1).toLowerCase();
			            } else {
			            	nombreGenero = nombreGenero.toUpperCase();
			            }
						esGeneroValido=true;
						System.out.println("Se cambio el genero de la pelicula");
						System.out.println();
					}
				}while(esGeneroValido!=true);
				
				//--- Se actualiza la pelicula
				DAO<Genero, Integer> generoDAO = new GeneroDAOImp();
				try {
					Genero genero = generoDAO.obtenerOInsertarGenero(nombreGenero);
					pelicula = new Pelicula(nombrePelicula, imagenFile, codActualizar, urlPelicula, genero);
					peliculaDAO.actualizar(pelicula);
					System.out.println("Pelicula actualizada en la base de datos");
					System.out.println("Presione una tecla para continuar");
					String tecla = scanner.next();
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				break;
			}
			case 3: {
				Pelicula pelicula;
				String nombrePelicula;
				DAO<Pelicula, Integer> peliculaDAO = new PeliculaDAOImp();
				int codActualizar = 0;
				boolean esCodigoValido;
				// Ingresamos el codigo de la pelicula a eliminar
				do {
					try {
					System.out.print("Ingrese el codigo de la pelicula: ");
					codActualizar = scanner.nextInt();
					if(codActualizar<0) {
						esCodigoValido=false;
						System.out.println("Debe ingresar un codigo valido de pelicula");
						System.out.println("Debe ser mayor que cero");
						
						}else {
							esCodigoValido=true;
						}
						
					}catch (InputMismatchException e) {
				        System.err.println("Por favor, ingrese solo numeros.");
				        scanner.nextLine();
				        esCodigoValido=false;
				    }
				}while(esCodigoValido!=true);

				//Eliminamos la pelicula
				pelicula = new Pelicula(codActualizar);
				peliculaDAO.eliminar(pelicula);
				break;
			}
		}
	}
	
	public static void buscadorDePeliculas() {
		Scanner scanner = new Scanner(System.in);
		boolean esOpcionValida = true;
		int opcion=0;
		do {
			System.out.println("----------MENU----------");
			System.out.println("Buscador de Peliculas");
			System.out.println("1-Por codigo");
			System.out.println("2-Por titulo");
			System.out.println("3-Por genero");
			System.out.println("4-Salir");
			System.out.println("\nIngrese una opción: ");
			String opcionString = scanner.next();
			try {
				opcion = Integer.parseInt(opcionString);
				if(opcion != 1 && opcion!=2 && opcion!=3 && opcion!=4) {
					System.err.println("Debe ingresar una opción válida");
					esOpcionValida = false;
				}else {
					esOpcionValida=true;
				}
			}catch(Exception ex) {
				System.err.println("Debe ingresar una opción válida");
				esOpcionValida=false;
			}
			
		}while(esOpcionValida!=true);
		
		switch(opcion) {
		case 1:{
			//Ingresamos el codigo de la pelicula a buscar
			System.out.println("Ingrese el codigo a buscar");
			int codigo = scanner.nextInt();
			DAO<Pelicula, Integer> peliculaDAO = new PeliculaDAOImp();
			Pelicula peliculaBuscada = peliculaDAO.buscarPorCodigo(codigo);
			if(peliculaBuscada!=null) {
				System.out.println(peliculaBuscada.MostrarPelicula());
				
				boolean esCodigoValido=true;
				int codigoInfoDetalle = 0;
				//Preguntamos si desea ver el detalle de la pelicula
				do {
					try {
						System.out.println("Desea ver la informacion de la pelicula completa? Ingrese el codigo 2023: ");
						System.out.println("Si no ingrese cualquier otro codigo: ");
						codigoInfoDetalle = scanner.nextInt();
						if(codigoInfoDetalle==2023) {
							esCodigoValido=true;
							System.out.println(peliculaBuscada.peliculaDetallada());
							System.out.println("Presione una tecla para continuar");
							String tecla = scanner.next();
							
						}else {
							esCodigoValido=true;
							System.out.println("Volviendo al menu principal");
						}
					}catch (InputMismatchException e) {
				        System.err.println("Por favor, ingrese solo numeros.");
				        scanner.nextLine();
				        esCodigoValido = false;
				    }
				}while(esCodigoValido!=true);
			}else {
				System.out.println("La pelicula no existe con ese codigo");
			}
			break;
		}
		case 2:{
			//Ingresamos el titulo a buscar
				System.out.println("Ingrese el titulo a buscar");
				scanner.nextLine();
				String titulo = scanner.nextLine().toUpperCase();
				DAO<Pelicula, Integer> peliculaDAO = new PeliculaDAOImp();
				Pelicula peliculaBuscada = peliculaDAO.buscarPorTitulo(titulo);
				if(peliculaBuscada!=null) {
					System.out.println(peliculaBuscada.MostrarPelicula());
					
					boolean esCodigoValido=true;
					int codigoInfoDetalle = 0;
					//Preguntamos si desea ver el detalle de pelicula
					do {
						try {
							System.out.println("Desea ver la informacion de la pelicula completa? Ingrese el codigo 2023: ");
							System.out.println("Si no ingrese cualquier otro codigo: ");
							codigoInfoDetalle = scanner.nextInt();
							if(codigoInfoDetalle==2023) {
								esCodigoValido=true;
								System.out.println(peliculaBuscada.peliculaDetallada());
								System.out.println("Presione una tecla para continuar");
								String tecla = scanner.next();
								
							}else {
								esCodigoValido=true;
								System.out.println("Volviendo al menu principal");
							}
						}catch (InputMismatchException e) {
					        System.err.println("Por favor, ingrese solo numeros.");
					        scanner.nextLine();
					        esCodigoValido = false;
					    }
					}while(esCodigoValido!=true);
				}else {
					System.out.println("La pelicula no existe con ese titulo");
				}
			
			break;
		}
		case 3:{
			//Ingresamos el genero a buscar
			System.out.println("Ingrese el genero a buscar");
			String genero = scanner.next();
			DAO<Pelicula, Integer> peliculaDAO = new PeliculaDAOImp();
			Pelicula generoBuscado = peliculaDAO.buscarPorGenero(genero);
			if(generoBuscado!=null) {
				System.out.println(generoBuscado.MostrarPelicula());
				
				boolean esCodigoValido=true;
				int codigoInfoDetalle = 0;
				//Preguntamos si desea ver el detalle
				do {
					try {
						System.out.println("Desea ver la informacion de la pelicula completa? Ingrese el codigo 2023: ");
						System.out.println("Si no ingrese cualquier otro codigo: ");
						codigoInfoDetalle = scanner.nextInt();
						if(codigoInfoDetalle==2023) {
							esCodigoValido=true;
							System.out.println(generoBuscado.peliculaDetallada());
							System.out.println("Presione una tecla para continuar");
							String tecla = scanner.next();
							
						}else {
							esCodigoValido=true;
							System.out.println("Volviendo al menu principal");
						}
					}catch (InputMismatchException e) {
				        System.err.println("Por favor, ingrese solo numeros.");
				        scanner.nextLine();
				        esCodigoValido = false;
				    }
				}while(esCodigoValido!=true);
			}else {
				System.out.println("La pelicula no existe con ese genero");
			}
			break;
		}
	}
	}
		
}
	
