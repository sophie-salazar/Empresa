/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.empresa;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Empresa {
    private String nombre;
    private String ruc;
    private String direccion;
    private String email;
    private List<Empleado> empleados;

    // Constructor
    public Empresa(String nombre, String ruc, String direccion, String email) {
        this.nombre = nombre;
        this.ruc = ruc;
        this.direccion = direccion;
        this.email = email;
        this.empleados = new ArrayList<>();
    }

    // Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Empleado> getEmpleados() {
        return empleados;
    }

    public void setEmpleados(List<Empleado> empleados) {
        this.empleados = empleados;
    }

    // Métodos para gestionar empleados
    public void agregarEmpleado(Empleado empleado) {
        empleados.add(empleado);
    }

    public void eliminarEmpleado(String cedula) {
        empleados.removeIf(empleado -> empleado.getCedula().equals(cedula));
    }

    public Empleado buscarEmpleadoPorCedula(String cedula) {
        for (Empleado empleado : empleados) {
            if (empleado.getCedula().equals(cedula)) {
                return empleado;
            }
        }
        return null; // Si no se encuentra
    }

    public Empleado buscarEmpleadoPorNombre(String nombre) {
        for (Empleado empleado : empleados) {
            if (empleado.getNombre().equalsIgnoreCase(nombre)) {
                return empleado;
            }
        }
        return null; // Si no se encuentra
    }

    public void mostrarEmpleados() {
        if (empleados.isEmpty()) {
            System.out.println("No hay empleados registrados.");
        } else {
            for (int i = 0; i < empleados.size(); i++) {
                System.out.println("Empleado " + (i + 1) + ": " + empleados.get(i).getNombre());
                System.out.println("  Cedula: " + empleados.get(i).getCedula());
                System.out.println("  Salario: " + empleados.get(i).getSalario());
            }
        }
    }

    public static void main(String[] args) {
      // Crear una instancia de la empresa
        try (Scanner scanner = new Scanner(System.in)) {
            // Crear una instancia de la empresa
            Empresa empresa = new Empresa("TechSolutions", "123456789", "Av. Siempre Viva 123", "contacto@techsolutions.com");
            
            // Menu de opciones
            int opcion = 0;
            while (opcion != 5) {
                System.out.println("\n--- Menú de Empresa ---");
                System.out.println("1. Agregar Empleado");
                System.out.println("2. Eliminar Empleado");
                System.out.println("3. Buscar Empleado por Cédula");
                System.out.println("4. Mostrar todos los Empleados");
                System.out.println("5. Salir");
                System.out.print("Seleccione una opción: ");
                opcion = scanner.nextInt();
                scanner.nextLine(); // Limpiar el buffer
                
                switch (opcion) {
                    case 1: // Agregar empleado
                        System.out.print("Ingrese el nombre del empleado: ");
                        String nombre = scanner.nextLine();
                        System.out.print("Ingrese la cédula del empleado: ");
                        String cedula = scanner.nextLine();
                        System.out.print("Ingrese el salario del empleado: ");
                        double salario = scanner.nextDouble();
                        scanner.nextLine(); // Limpiar el buffer
                        Empleado empleado = new Empleado(nombre, cedula, salario);
                        empresa.agregarEmpleado(empleado);
                        System.out.println("Empleado agregado con éxito.");
                        break;
                    case 2: // Eliminar empleado
                        System.out.print("Ingrese la cédula del empleado a eliminar: ");
                        String cedulaEliminar = scanner.nextLine();
                        empresa.eliminarEmpleado(cedulaEliminar);
                        System.out.println("Empleado eliminado.");
                        break;
                    case 3: // Buscar empleado
                        System.out.print("Ingrese la cédula del empleado a buscar: ");
                        String cedulaBuscar = scanner.nextLine();
                        Empleado empleadoBuscado = empresa.buscarEmpleadoPorCedula(cedulaBuscar);
                        if (empleadoBuscado != null) {
                            System.out.println("Empleado encontrado: ");
                            System.out.println("Nombre: " + empleadoBuscado.getNombre());
                            System.out.println("Cédula: " + empleadoBuscado.getCedula());
                            System.out.println("Salario: " + empleadoBuscado.getSalario());
                        } else {
                            System.out.println("Empleado no encontrado.");
                        }
                        break;
                    case 4: // Mostrar empleados
                        empresa.mostrarEmpleados();
                        break;
                    case 5:
                        System.out.println("Saliendo...");
                        break;
                    default:
                        System.out.println("Opción no válida.");
                }
            }
        }
    }
}

