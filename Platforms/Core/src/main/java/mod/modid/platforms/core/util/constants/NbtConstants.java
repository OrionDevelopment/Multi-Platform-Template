package mod.modid.platforms.core.util.constants;

public class NbtConstants
{

    public static final String VERSION = "version";
    public static final String SKYLIGHT_BLOCKING_BITS = "skylight_blocking_bits";
    public static final String HIGHEST_BIT = "highestBit";
    public static final String HIGHEST_BIT_FRICTION = "highestBitFriction";
    public static final String NONE_AIR_BITS = "none_air_bits";
    public static final String COLUMN_STATISTICS        = "column_statistics";
    public static final String CAN_PROPAGATE_SKYLIGHT_DOWN  = "can_propagate_skylight_down";
    public static final String LOWEST_BIT_CAN_SUSTAIN_GRASS = "lowest_bit_can_sustain_grass";

    private NbtConstants()
    {
        throw new IllegalStateException("Can not instantiate an instance of: NbtConstants. This is a utility class");
    }


    public static final String CHISEL_BLOCK_ENTITY_DATA = "chiselBlockData";
    public static final String COMPRESSED_STORAGE = "compressedStorage";
    public static final String DATA_IS_COMPRESSED = "isCompressed";
    public static final String COMPRESSED_DATA = "compressedData";
    public static final String PALETTE = "palette";
    public static final String BLOCK_STATES  = "blockStates";
    public static final String COLUMN_BLOCK_LIST = "columnBlockList";
    public static final String PRIMARY_STATE = "primaryState";
    public static final String BLOCK_STATE = "blockState";
    public static final String COUNT = "count";
    public static final String STATISTICS = "statistics";
    public static final String TOTAL_BLOCK_COUNT = "blockCount";
    public static final String TOTAL_SHOULD_CHECK_WEAK_POWER_COUNT = "blockShouldCheckWeakPowerCount";
    public static final String TOTAL_UPPER_LEVEL_SLIPPERINESS = "totalUpperLevelSlipperiness";
    public static final String TOTAL_LIGHT_LEVEL = "totalLightLevel";
    public static final String TOTAL_LIGHT_BLOCK_LEVEL = "totalLightBlockLevel";
    public static final String X_COORDINATE = "xCoordinate";
    public static final String Y_COORDINATE = "yCoordinate";
    public static final String COORDINATE = "coordinate";
    public static final String VALUE = "value";
    public static final String CHISEL_MODE = "chiselMode";
    public static final String MODIFICATION_MODE = "modificationMode";
    public static final String CHISELED_DATA = "chiseledData";
    public static final String INVENTORY = "Inventory";
    public static final String CONTENTS = "contents";
    public static final String BLOCK_ENTITY_DATA = "BlockEntityTag";
    public static final String COMPRESSED = "compressed";
    public static final String DATA = "data";
}
