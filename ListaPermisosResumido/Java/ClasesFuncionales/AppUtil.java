package com.example.android7ed.listapermisos.ClasesFuncionales;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.PermissionGroupInfo;
import android.content.pm.PermissionInfo;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by android7Ed on 19/07/2017.
 */

public class AppUtil {

    public static List<Permisos> todosPermisos(Context ctx){
        List<Permisos> listaPermisos = new ArrayList<>();
        PackageManager pm = ctx.getPackageManager();
        CharSequence csPermissionGroupLabel;
        CharSequence csPermissionLabel;

        List<PermissionGroupInfo> lstGroups = pm.getAllPermissionGroups(0);
        for (PermissionGroupInfo pgi : lstGroups) {
            csPermissionGroupLabel = pgi.loadLabel(pm);
            Log.e("perm", pgi.name + ": " + csPermissionGroupLabel.toString());

            try {
                List<PermissionInfo> lstPermissions = pm.queryPermissionsByGroup(pgi.name, 0);
                for (PermissionInfo pi : lstPermissions) {
                    csPermissionLabel = pi.loadLabel(pm);
                    Log.e("perm", "   " + pi.name + ": " + csPermissionLabel.toString());
                    listaPermisos.add(new Permisos(pi.name,csPermissionLabel.toString()));
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

        return listaPermisos;
    }

}
