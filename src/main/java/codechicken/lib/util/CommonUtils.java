package codechicken.lib.util;

import net.minecraft.world.World;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.relauncher.FMLInjectionData;

import java.io.File;

public class CommonUtils {

    public static boolean isClientWorld(World world) {
        return world.isRemote;
    }

    public static boolean isServerWorld(World world) {
        return !world.isRemote;
    }

    public static boolean isClient() {
        return FMLCommonHandler.instance().getSide().isClient();
    }

    public static File getSaveLocation(World world) {
        File base = DimensionManager.getCurrentSaveRootDirectory();
        return world.provider.getDimension() == 0 ? base : new File(base, world.provider.getSaveFolder());
    }

    public static File getSaveLocation(int dim) {
        return getSaveLocation(DimensionManager.getWorld(dim));
    }

    public static String getWorldName(World world) {
        return world.getWorldInfo().getWorldName();
    }

    public static int getDimension(World world) {
        return world.provider.getDimension();
    }

    public static File getMinecraftDir() {
        return (File) FMLInjectionData.data()[6];
    }

    public static String getRelativePath(File parent, File child) {
        if (parent.isFile() || !child.getPath().startsWith(parent.getPath())) {
            return null;
        }
        return child.getPath().substring(parent.getPath().length() + 1);
    }
}
