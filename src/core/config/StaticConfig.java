package core.config;

public class StaticConfig {

	    
	/*******************************************************************************
	 * SQL Connection Data Declaration
	 ******************************************************************************/
	    /*
	    public String sqlHost = "89.107.186.15";
	    public String sqlDB = "web2_db4";
	    public String sqlTable = "proAPV_staff_data";
	    public String sqlUser = "web2_4";
	    public String sqlPass = "4102=vSQL9";
	    */
	    private final String sqlHost;
	    private final String sqlDB;
	    private final String sqlTableProducts;
	    private final String sqlTableBrands;
	    private final String sqlTableAttributes;
	    private final String sqlUser;
	    private final String sqlPass;

	/*******************************************************************************
	 * FTP Connection Data Declaration
	 ******************************************************************************/
	    private final String ftpHost;
	    private final String ftpPort;
	    private final String ftpUser;
	    private final String ftpPass;

	    
	/*******************************************************************************
	 ******************************* LOCAL PATHS **********************************/
	/*******************************************************************************
	 * Relative local path for all media (live images & videos)
	 ******************************************************************************/
	    public static final String LOCAL_MEDIA_PATH = ".\\media\\";
	    
	/*******************************************************************************
	 * Relative local path for products images
	 ******************************************************************************/
	    public static final String LOCAL_PRODUCTS_IMG_PATH = ".\\img_products\\";

	/*******************************************************************************
	 * Relative local path for brand logos)
	 ******************************************************************************/
	    public static final String LOCAL_BRAND_LOGOS_IMG_PATH = ".\\img_brandLogos\\";
	    
	    
	/*******************************************************************************
	 ****************************** REMOTE PATHS **********************************/    
	/*******************************************************************************
	 * Relative remote path for all media (live images & videos)
	 ******************************************************************************/
	    public static final String REMOTE_MAGE_MEDIA_PATH = "promeda/";

	/*******************************************************************************
	 * Relative remote path for products images
	 ******************************************************************************/
	    public static final String REMOTE_MAGE_PRODUCTS_IMG_PATH = "img_products/";

	/*******************************************************************************
	 * Relative remote path for brand logos)
	 ******************************************************************************/
	    public static final String REMOTE_MAGE_BRAND_LOGOS_IMG_PATH = "img_brandLogos/";
	    
	/*******************************************************************************
	 * Relative remote path for all media (live images & videos)
	 ******************************************************************************/
	    public static final String REMOTE_WS_MEDIA_PATH = "promeda/";

	/*******************************************************************************
	 * Relative remote path for products images
	 ******************************************************************************/
	    public static final String REMOTE_WS_PRODUCTS_IMG_PATH = "img_products/";

	/*******************************************************************************
	 * Relative remote path for brand logos)
	 ******************************************************************************/
	    public static final String REMOTE_WS_BRAND_LOGOS_IMG_PATH = "img_brandLogos/";
	    
	    
	/*******************************************************************************
	 * CONSTRUCTOR
	 ******************************************************************************/
	    public StaticConfig() {
	        
	/*******************************************************************************
	 * SQL Connection Data Initializing
	 ******************************************************************************/
	        this.sqlHost = "uptags.net";
	        this.sqlDB = "xd122_db11";
	        this.sqlTableProducts = "export";
	        this.sqlTableBrands = "pro_brands";
	        this.sqlTableAttributes = "groessen";
	        this.sqlUser = "xd122_11";
	        this.sqlPass = "Weltfrieden1337#";
	        /*
	        this.sqlHost = "192.168.25.17";
	        this.sqlDB = "sv_artikel_update";
	        this.sqlTable = "export";
	        this.sqlUser = "root";
	        this.sqlPass = "";
	        */
	        /*
	        public String sqlHost = "89.107.186.15";
	        public String sqlDB = "web2_db4";
	        public String sqlTable = "proAPV_staff_data";
	        public String sqlUser = "web2_4";
	        public String sqlPass = "4102=vSQL9";
	        */
	        
	/*******************************************************************************
	 * FTP Connection Data Initializing
	 ******************************************************************************/
	        ftpHost = "xd1.serverdomain.org";
	        ftpPort = "21";
	        //ftpHost = ftpHost + ":" + ftpPort;
	        ftpUser = "xd122";
	        ftpPass = "-N*cygHrfLme#";
	        /*
	        ftpHost = "promondo-produkte.de";
	        ftpPort = "21";
	        ftpHost = ftpHost + ":" + ftpPort;
	        ftpUser = "web2";
	        ftpPwd = "4102=vodnomorP9";
	        */
	    }
	    
	    public String getSqlHost() {
	        return this.sqlHost;
	    }
	    public String getSqlDB() {
	        return this.sqlDB;
	    }
	    public String getSqlTable(String table) {
	        String returnTable;
	        switch(table) {
	            case "products": returnTable = this.sqlTableProducts;break;
	            case "brands": returnTable = this.sqlTableBrands;break;
	            case "attributes": returnTable = this.sqlTableAttributes;break;
	            default: returnTable = this.sqlTableProducts;break;
	        }
	        return returnTable;
	    }
	    public String getSqlUser() {
	        return this.sqlUser;
	    }
	    public String getSqlPass() {
	        return this.sqlPass;
	    }
	    
	    public String getFtpHost() {
	        return this.ftpHost;

	    }
	    public String getFtpUser() {
	        return this.ftpUser;
	    }
	    public String getFtpPass() {
	        return this.ftpPass;
	    }

}
