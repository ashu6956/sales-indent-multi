package com.agriscience.salesindent.room_database;

import androidx.annotation.NonNull;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomOpenHelper;
import androidx.room.RoomOpenHelper.Delegate;
import androidx.room.RoomOpenHelper.ValidationResult;
import androidx.room.migration.AutoMigrationSpec;
import androidx.room.migration.Migration;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.room.util.TableInfo.Column;
import androidx.room.util.TableInfo.ForeignKey;
import androidx.room.util.TableInfo.Index;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Callback;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Configuration;
import com.agriscience.salesindent.room_database.dao.CustomerDao;
import com.agriscience.salesindent.room_database.dao.CustomerDao_Impl;
import com.agriscience.salesindent.room_database.dao.MaterialDao;
import com.agriscience.salesindent.room_database.dao.MaterialDao_Impl;
import com.agriscience.salesindent.room_database.dao.PlantDao;
import com.agriscience.salesindent.room_database.dao.PlantDao_Impl;
import com.agriscience.salesindent.room_database.dao.STOIndentTmpDao;
import com.agriscience.salesindent.room_database.dao.STOIndentTmpDao_Impl;
import com.agriscience.salesindent.room_database.dao.STOMaterialDao;
import com.agriscience.salesindent.room_database.dao.STOMaterialDao_Impl;
import com.agriscience.salesindent.room_database.dao.SalesIndentDetailsDao;
import com.agriscience.salesindent.room_database.dao.SalesIndentDetailsDao_Impl;
import com.agriscience.salesindent.room_database.dao.SalesIndentTmpDao;
import com.agriscience.salesindent.room_database.dao.SalesIndentTmpDao_Impl;
import com.agriscience.salesindent.room_database.dao.SeasonDao;
import com.agriscience.salesindent.room_database.dao.SeasonDao_Impl;
import com.agriscience.salesindent.room_database.dao.ZOrganogramDetailsDao;
import com.agriscience.salesindent.room_database.dao.ZOrganogramDetailsDao_Impl;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@SuppressWarnings({"unchecked", "deprecation"})
public final class SalesIndentDataBase_Impl extends SalesIndentDataBase {
  private volatile CustomerDao _customerDao;

  private volatile MaterialDao _materialDao;

  private volatile SeasonDao _seasonDao;

  private volatile SalesIndentDetailsDao _salesIndentDetailsDao;

  private volatile SalesIndentTmpDao _salesIndentTmpDao;

  private volatile ZOrganogramDetailsDao _zOrganogramDetailsDao;

  private volatile PlantDao _plantDao;

  private volatile STOMaterialDao _sTOMaterialDao;

  private volatile STOIndentTmpDao _sTOIndentTmpDao;

  @Override
  protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration configuration) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(configuration, new RoomOpenHelper.Delegate(1) {
      @Override
      public void createAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("CREATE TABLE IF NOT EXISTS `customer_entity` (`sales_organization` TEXT, `division` TEXT, `distribution_channel` TEXT, `customer_name` TEXT, `customer_code` TEXT NOT NULL, `territory_id` TEXT, `sales_office` TEXT, `status` TEXT, `state_id` TEXT, PRIMARY KEY(`customer_code`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `material_entity` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `packing_quantity` TEXT, `message` TEXT, `base_uom` TEXT, `material_name` TEXT, `variety_code` TEXT, `variety_name` TEXT, `crop_code` TEXT, `crop_name` TEXT, `status` TEXT, `material_code` TEXT)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `season_entity` (`season_start_date` TEXT, `id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `season_code` TEXT, `message` TEXT, `season_end_date` TEXT, `status` TEXT, `crop_code` TEXT, `season_name` TEXT, `crop_name` TEXT, `active` TEXT, `return_cut_off_date` TEXT, `description` TEXT, `state` TEXT)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `SalesIndentDetailsTmpEntity` (`indent_no` TEXT, `SlNo` TEXT, `indent_date` TEXT, `indent_time` TEXT NOT NULL, `sale_organization` TEXT, `distribution_channel` TEXT, `division` TEXT, `sales_office` TEXT, `customer_code` TEXT, `customer_name` TEXT, `customer_state_id` TEXT, `crop_code` TEXT, `crop_name` TEXT, `season_code` TEXT, `season_starting_date` TEXT, `season_end_date` TEXT, `return_cut-off_date` TEXT, `variety_code` TEXT, `variety_name` TEXT, `line_item_no` TEXT, `material_code` TEXT, `material_name` TEXT, `plant` TEXT, `base_uom` TEXT, `packing_quantity` TEXT, `quantity_in_kgs_or_packets` TEXT, `required_quantity_in_kgs` TEXT, `no_of_packets_required` TEXT, `indent_overall_status` TEXT, `territory_id` TEXT, `territory_name` TEXT, `ti_id` TEXT, `ti_name` TEXT, `ti_quantity` TEXT, `ti_remarks` TEXT, `sales_region_id` TEXT, `sales_region_name` TEXT, `rbm_id` TEXT, `rbm_name` TEXT, `rbm_quantity` TEXT, `rbm_approval_status` TEXT, `rbm_approved_date` TEXT, `rbm_approved_time` TEXT, `rbm_remarks` TEXT, `sales_division_id` TEXT, `sales_division_name` TEXT, PRIMARY KEY(`indent_time`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `SalesIndentRequestDetailsEntity` (`indent_no` TEXT, `indent_date` TEXT, `indent_time` TEXT NOT NULL, `sale_organization` TEXT, `distribution_channel` TEXT, `division` TEXT, `sales_office` TEXT, `customer_code` TEXT, `customer_name` TEXT, `customer_state_id` TEXT, `crop_code` TEXT, `crop_name` TEXT, `season_code` TEXT, `season_starting_date` TEXT, `season_end_date` TEXT, `return_cut_off_date` TEXT, `varity_code` TEXT, `varity_name` TEXT, `line_item_no` TEXT, `material_code` TEXT, `material_name` TEXT, `plant` TEXT, `base_uom` TEXT, `packing_quantity` TEXT, `quantity_in_kgs_or_packets` TEXT, `required_quantity_in_kgs` TEXT, `no_of_packets_required` TEXT, `indent_overall_status` TEXT, `territory_id` TEXT, `territory_name` TEXT, `ti_id` TEXT, `ti_name` TEXT, `ti_quantity` TEXT, `ti_remarks` TEXT, `sales_region_id` TEXT, `sales_region_name` TEXT, `rbm_id` TEXT, `dbm_id` TEXT, `rbm_name` TEXT, `dbm_name` TEXT, `rbm_quantity` TEXT, `rbm_approval_status` TEXT, `am_approval_status` TEXT, `am_id` TEXT, `am_name` TEXT, `am_qty` TEXT, `am_remarks` TEXT, `dbm_approval_status` TEXT, `rbm_approved_date` TEXT, `rbm_approved_time` TEXT, `rbm_remarks` TEXT, `sales_division_id` TEXT, `sales_division_name` TEXT, PRIMARY KEY(`indent_time`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `ZOrganogramResponseDetails` (`salesDivisionName` TEXT, `territoryName` TEXT, `dataUpdatedInMobile` TEXT, `inChargeT` TEXT, `active` TEXT, `dbm` TEXT, `dataUpdatedInSap` TEXT, `division` TEXT, `salesDivision` TEXT, `plant` TEXT, `tiName` TEXT, `regionName` TEXT, `rbmName` TEXT, `region` TEXT, `rbm` TEXT, `dbmName` TEXT, `Plant_name` TEXT, `territoryId` TEXT NOT NULL, `status` TEXT, `areaManager` TEXT, `areaManagerName` TEXT, PRIMARY KEY(`territoryId`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `plant_details` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `sales` TEXT, `plantCode` TEXT, `plantName` TEXT, `processing` TEXT)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `sto_material` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `varietyName` TEXT, `cropCode` TEXT, `cropName` TEXT, `varietyCode` TEXT, `packingQuantity` TEXT, `baseUom` TEXT, `message` TEXT, `materialName` TEXT, `status` TEXT, `materialCode` TEXT)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `STOIndentTmpEntity` (`STO_indent_no` TEXT, `indent_date` TEXT, `Indent_time` TEXT, `Sending_plant` TEXT, `Receiving_plant` TEXT, `Line_no` TEXT NOT NULL, `Division` TEXT, `Crop_name` TEXT, `Crop_code` TEXT, `Variety_code` TEXT, `Variety_name` TEXT, `Material_code` TEXT, `Material_description` TEXT, `Final_status` TEXT, `Final_quantity` TEXT, `final_item_weight` TEXT, `final_no_of_pac` TEXT, `Req_date` TEXT, `Sales_region` TEXT, `sales_region_name` TEXT, `RBM` TEXT, `rbm_name` TEXT, `rbm_qty` TEXT, `Rbm_item_weight` TEXT, `Rbm_no_of_pac` TEXT, `rbm_remarks` TEXT, `sales_division` TEXT, `sales_division_name` TEXT, `dbm` TEXT, `dbm_name` TEXT, `dbm_remarks` TEXT, `dbm_qty` TEXT, `dbm_item_weight` TEXT, `dbm_no_of_pac` TEXT, `packingQuantity` TEXT, `baseUom` TEXT, `dbm_approval_status` TEXT, `dbm_approval_date` TEXT, `dbm_approval_time` TEXT, PRIMARY KEY(`Line_no`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        _db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '478450268c9337094e181a3d989cc67e')");
      }

      @Override
      public void dropAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("DROP TABLE IF EXISTS `customer_entity`");
        _db.execSQL("DROP TABLE IF EXISTS `material_entity`");
        _db.execSQL("DROP TABLE IF EXISTS `season_entity`");
        _db.execSQL("DROP TABLE IF EXISTS `SalesIndentDetailsTmpEntity`");
        _db.execSQL("DROP TABLE IF EXISTS `SalesIndentRequestDetailsEntity`");
        _db.execSQL("DROP TABLE IF EXISTS `ZOrganogramResponseDetails`");
        _db.execSQL("DROP TABLE IF EXISTS `plant_details`");
        _db.execSQL("DROP TABLE IF EXISTS `sto_material`");
        _db.execSQL("DROP TABLE IF EXISTS `STOIndentTmpEntity`");
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onDestructiveMigration(_db);
          }
        }
      }

      @Override
      public void onCreate(SupportSQLiteDatabase _db) {
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onCreate(_db);
          }
        }
      }

      @Override
      public void onOpen(SupportSQLiteDatabase _db) {
        mDatabase = _db;
        internalInitInvalidationTracker(_db);
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onOpen(_db);
          }
        }
      }

      @Override
      public void onPreMigrate(SupportSQLiteDatabase _db) {
        DBUtil.dropFtsSyncTriggers(_db);
      }

      @Override
      public void onPostMigrate(SupportSQLiteDatabase _db) {
      }

      @Override
      public RoomOpenHelper.ValidationResult onValidateSchema(SupportSQLiteDatabase _db) {
        final HashMap<String, TableInfo.Column> _columnsCustomerEntity = new HashMap<String, TableInfo.Column>(9);
        _columnsCustomerEntity.put("sales_organization", new TableInfo.Column("sales_organization", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCustomerEntity.put("division", new TableInfo.Column("division", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCustomerEntity.put("distribution_channel", new TableInfo.Column("distribution_channel", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCustomerEntity.put("customer_name", new TableInfo.Column("customer_name", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCustomerEntity.put("customer_code", new TableInfo.Column("customer_code", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCustomerEntity.put("territory_id", new TableInfo.Column("territory_id", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCustomerEntity.put("sales_office", new TableInfo.Column("sales_office", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCustomerEntity.put("status", new TableInfo.Column("status", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCustomerEntity.put("state_id", new TableInfo.Column("state_id", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysCustomerEntity = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesCustomerEntity = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoCustomerEntity = new TableInfo("customer_entity", _columnsCustomerEntity, _foreignKeysCustomerEntity, _indicesCustomerEntity);
        final TableInfo _existingCustomerEntity = TableInfo.read(_db, "customer_entity");
        if (! _infoCustomerEntity.equals(_existingCustomerEntity)) {
          return new RoomOpenHelper.ValidationResult(false, "customer_entity(com.agriscience.salesindent.room_database.entity.CustomerEntity).\n"
                  + " Expected:\n" + _infoCustomerEntity + "\n"
                  + " Found:\n" + _existingCustomerEntity);
        }
        final HashMap<String, TableInfo.Column> _columnsMaterialEntity = new HashMap<String, TableInfo.Column>(11);
        _columnsMaterialEntity.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMaterialEntity.put("packing_quantity", new TableInfo.Column("packing_quantity", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMaterialEntity.put("message", new TableInfo.Column("message", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMaterialEntity.put("base_uom", new TableInfo.Column("base_uom", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMaterialEntity.put("material_name", new TableInfo.Column("material_name", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMaterialEntity.put("variety_code", new TableInfo.Column("variety_code", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMaterialEntity.put("variety_name", new TableInfo.Column("variety_name", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMaterialEntity.put("crop_code", new TableInfo.Column("crop_code", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMaterialEntity.put("crop_name", new TableInfo.Column("crop_name", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMaterialEntity.put("status", new TableInfo.Column("status", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMaterialEntity.put("material_code", new TableInfo.Column("material_code", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysMaterialEntity = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesMaterialEntity = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoMaterialEntity = new TableInfo("material_entity", _columnsMaterialEntity, _foreignKeysMaterialEntity, _indicesMaterialEntity);
        final TableInfo _existingMaterialEntity = TableInfo.read(_db, "material_entity");
        if (! _infoMaterialEntity.equals(_existingMaterialEntity)) {
          return new RoomOpenHelper.ValidationResult(false, "material_entity(com.agriscience.salesindent.room_database.entity.MaterialEntity).\n"
                  + " Expected:\n" + _infoMaterialEntity + "\n"
                  + " Found:\n" + _existingMaterialEntity);
        }
        final HashMap<String, TableInfo.Column> _columnsSeasonEntity = new HashMap<String, TableInfo.Column>(13);
        _columnsSeasonEntity.put("season_start_date", new TableInfo.Column("season_start_date", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSeasonEntity.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSeasonEntity.put("season_code", new TableInfo.Column("season_code", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSeasonEntity.put("message", new TableInfo.Column("message", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSeasonEntity.put("season_end_date", new TableInfo.Column("season_end_date", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSeasonEntity.put("status", new TableInfo.Column("status", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSeasonEntity.put("crop_code", new TableInfo.Column("crop_code", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSeasonEntity.put("season_name", new TableInfo.Column("season_name", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSeasonEntity.put("crop_name", new TableInfo.Column("crop_name", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSeasonEntity.put("active", new TableInfo.Column("active", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSeasonEntity.put("return_cut_off_date", new TableInfo.Column("return_cut_off_date", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSeasonEntity.put("description", new TableInfo.Column("description", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSeasonEntity.put("state", new TableInfo.Column("state", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysSeasonEntity = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesSeasonEntity = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoSeasonEntity = new TableInfo("season_entity", _columnsSeasonEntity, _foreignKeysSeasonEntity, _indicesSeasonEntity);
        final TableInfo _existingSeasonEntity = TableInfo.read(_db, "season_entity");
        if (! _infoSeasonEntity.equals(_existingSeasonEntity)) {
          return new RoomOpenHelper.ValidationResult(false, "season_entity(com.agriscience.salesindent.room_database.entity.SeasonEntity).\n"
                  + " Expected:\n" + _infoSeasonEntity + "\n"
                  + " Found:\n" + _existingSeasonEntity);
        }
        final HashMap<String, TableInfo.Column> _columnsSalesIndentDetailsTmpEntity = new HashMap<String, TableInfo.Column>(46);
        _columnsSalesIndentDetailsTmpEntity.put("indent_no", new TableInfo.Column("indent_no", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSalesIndentDetailsTmpEntity.put("SlNo", new TableInfo.Column("SlNo", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSalesIndentDetailsTmpEntity.put("indent_date", new TableInfo.Column("indent_date", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSalesIndentDetailsTmpEntity.put("indent_time", new TableInfo.Column("indent_time", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSalesIndentDetailsTmpEntity.put("sale_organization", new TableInfo.Column("sale_organization", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSalesIndentDetailsTmpEntity.put("distribution_channel", new TableInfo.Column("distribution_channel", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSalesIndentDetailsTmpEntity.put("division", new TableInfo.Column("division", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSalesIndentDetailsTmpEntity.put("sales_office", new TableInfo.Column("sales_office", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSalesIndentDetailsTmpEntity.put("customer_code", new TableInfo.Column("customer_code", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSalesIndentDetailsTmpEntity.put("customer_name", new TableInfo.Column("customer_name", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSalesIndentDetailsTmpEntity.put("customer_state_id", new TableInfo.Column("customer_state_id", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSalesIndentDetailsTmpEntity.put("crop_code", new TableInfo.Column("crop_code", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSalesIndentDetailsTmpEntity.put("crop_name", new TableInfo.Column("crop_name", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSalesIndentDetailsTmpEntity.put("season_code", new TableInfo.Column("season_code", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSalesIndentDetailsTmpEntity.put("season_starting_date", new TableInfo.Column("season_starting_date", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSalesIndentDetailsTmpEntity.put("season_end_date", new TableInfo.Column("season_end_date", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSalesIndentDetailsTmpEntity.put("return_cut-off_date", new TableInfo.Column("return_cut-off_date", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSalesIndentDetailsTmpEntity.put("variety_code", new TableInfo.Column("variety_code", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSalesIndentDetailsTmpEntity.put("variety_name", new TableInfo.Column("variety_name", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSalesIndentDetailsTmpEntity.put("line_item_no", new TableInfo.Column("line_item_no", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSalesIndentDetailsTmpEntity.put("material_code", new TableInfo.Column("material_code", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSalesIndentDetailsTmpEntity.put("material_name", new TableInfo.Column("material_name", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSalesIndentDetailsTmpEntity.put("plant", new TableInfo.Column("plant", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSalesIndentDetailsTmpEntity.put("base_uom", new TableInfo.Column("base_uom", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSalesIndentDetailsTmpEntity.put("packing_quantity", new TableInfo.Column("packing_quantity", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSalesIndentDetailsTmpEntity.put("quantity_in_kgs_or_packets", new TableInfo.Column("quantity_in_kgs_or_packets", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSalesIndentDetailsTmpEntity.put("required_quantity_in_kgs", new TableInfo.Column("required_quantity_in_kgs", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSalesIndentDetailsTmpEntity.put("no_of_packets_required", new TableInfo.Column("no_of_packets_required", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSalesIndentDetailsTmpEntity.put("indent_overall_status", new TableInfo.Column("indent_overall_status", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSalesIndentDetailsTmpEntity.put("territory_id", new TableInfo.Column("territory_id", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSalesIndentDetailsTmpEntity.put("territory_name", new TableInfo.Column("territory_name", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSalesIndentDetailsTmpEntity.put("ti_id", new TableInfo.Column("ti_id", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSalesIndentDetailsTmpEntity.put("ti_name", new TableInfo.Column("ti_name", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSalesIndentDetailsTmpEntity.put("ti_quantity", new TableInfo.Column("ti_quantity", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSalesIndentDetailsTmpEntity.put("ti_remarks", new TableInfo.Column("ti_remarks", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSalesIndentDetailsTmpEntity.put("sales_region_id", new TableInfo.Column("sales_region_id", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSalesIndentDetailsTmpEntity.put("sales_region_name", new TableInfo.Column("sales_region_name", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSalesIndentDetailsTmpEntity.put("rbm_id", new TableInfo.Column("rbm_id", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSalesIndentDetailsTmpEntity.put("rbm_name", new TableInfo.Column("rbm_name", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSalesIndentDetailsTmpEntity.put("rbm_quantity", new TableInfo.Column("rbm_quantity", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSalesIndentDetailsTmpEntity.put("rbm_approval_status", new TableInfo.Column("rbm_approval_status", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSalesIndentDetailsTmpEntity.put("rbm_approved_date", new TableInfo.Column("rbm_approved_date", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSalesIndentDetailsTmpEntity.put("rbm_approved_time", new TableInfo.Column("rbm_approved_time", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSalesIndentDetailsTmpEntity.put("rbm_remarks", new TableInfo.Column("rbm_remarks", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSalesIndentDetailsTmpEntity.put("sales_division_id", new TableInfo.Column("sales_division_id", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSalesIndentDetailsTmpEntity.put("sales_division_name", new TableInfo.Column("sales_division_name", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysSalesIndentDetailsTmpEntity = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesSalesIndentDetailsTmpEntity = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoSalesIndentDetailsTmpEntity = new TableInfo("SalesIndentDetailsTmpEntity", _columnsSalesIndentDetailsTmpEntity, _foreignKeysSalesIndentDetailsTmpEntity, _indicesSalesIndentDetailsTmpEntity);
        final TableInfo _existingSalesIndentDetailsTmpEntity = TableInfo.read(_db, "SalesIndentDetailsTmpEntity");
        if (! _infoSalesIndentDetailsTmpEntity.equals(_existingSalesIndentDetailsTmpEntity)) {
          return new RoomOpenHelper.ValidationResult(false, "SalesIndentDetailsTmpEntity(com.agriscience.salesindent.room_database.entity.SalesIndentDetailsTmpEntity).\n"
                  + " Expected:\n" + _infoSalesIndentDetailsTmpEntity + "\n"
                  + " Found:\n" + _existingSalesIndentDetailsTmpEntity);
        }
        final HashMap<String, TableInfo.Column> _columnsSalesIndentRequestDetailsEntity = new HashMap<String, TableInfo.Column>(53);
        _columnsSalesIndentRequestDetailsEntity.put("indent_no", new TableInfo.Column("indent_no", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSalesIndentRequestDetailsEntity.put("indent_date", new TableInfo.Column("indent_date", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSalesIndentRequestDetailsEntity.put("indent_time", new TableInfo.Column("indent_time", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSalesIndentRequestDetailsEntity.put("sale_organization", new TableInfo.Column("sale_organization", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSalesIndentRequestDetailsEntity.put("distribution_channel", new TableInfo.Column("distribution_channel", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSalesIndentRequestDetailsEntity.put("division", new TableInfo.Column("division", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSalesIndentRequestDetailsEntity.put("sales_office", new TableInfo.Column("sales_office", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSalesIndentRequestDetailsEntity.put("customer_code", new TableInfo.Column("customer_code", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSalesIndentRequestDetailsEntity.put("customer_name", new TableInfo.Column("customer_name", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSalesIndentRequestDetailsEntity.put("customer_state_id", new TableInfo.Column("customer_state_id", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSalesIndentRequestDetailsEntity.put("crop_code", new TableInfo.Column("crop_code", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSalesIndentRequestDetailsEntity.put("crop_name", new TableInfo.Column("crop_name", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSalesIndentRequestDetailsEntity.put("season_code", new TableInfo.Column("season_code", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSalesIndentRequestDetailsEntity.put("season_starting_date", new TableInfo.Column("season_starting_date", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSalesIndentRequestDetailsEntity.put("season_end_date", new TableInfo.Column("season_end_date", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSalesIndentRequestDetailsEntity.put("return_cut_off_date", new TableInfo.Column("return_cut_off_date", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSalesIndentRequestDetailsEntity.put("varity_code", new TableInfo.Column("varity_code", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSalesIndentRequestDetailsEntity.put("varity_name", new TableInfo.Column("varity_name", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSalesIndentRequestDetailsEntity.put("line_item_no", new TableInfo.Column("line_item_no", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSalesIndentRequestDetailsEntity.put("material_code", new TableInfo.Column("material_code", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSalesIndentRequestDetailsEntity.put("material_name", new TableInfo.Column("material_name", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSalesIndentRequestDetailsEntity.put("plant", new TableInfo.Column("plant", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSalesIndentRequestDetailsEntity.put("base_uom", new TableInfo.Column("base_uom", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSalesIndentRequestDetailsEntity.put("packing_quantity", new TableInfo.Column("packing_quantity", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSalesIndentRequestDetailsEntity.put("quantity_in_kgs_or_packets", new TableInfo.Column("quantity_in_kgs_or_packets", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSalesIndentRequestDetailsEntity.put("required_quantity_in_kgs", new TableInfo.Column("required_quantity_in_kgs", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSalesIndentRequestDetailsEntity.put("no_of_packets_required", new TableInfo.Column("no_of_packets_required", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSalesIndentRequestDetailsEntity.put("indent_overall_status", new TableInfo.Column("indent_overall_status", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSalesIndentRequestDetailsEntity.put("territory_id", new TableInfo.Column("territory_id", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSalesIndentRequestDetailsEntity.put("territory_name", new TableInfo.Column("territory_name", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSalesIndentRequestDetailsEntity.put("ti_id", new TableInfo.Column("ti_id", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSalesIndentRequestDetailsEntity.put("ti_name", new TableInfo.Column("ti_name", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSalesIndentRequestDetailsEntity.put("ti_quantity", new TableInfo.Column("ti_quantity", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSalesIndentRequestDetailsEntity.put("ti_remarks", new TableInfo.Column("ti_remarks", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSalesIndentRequestDetailsEntity.put("sales_region_id", new TableInfo.Column("sales_region_id", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSalesIndentRequestDetailsEntity.put("sales_region_name", new TableInfo.Column("sales_region_name", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSalesIndentRequestDetailsEntity.put("rbm_id", new TableInfo.Column("rbm_id", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSalesIndentRequestDetailsEntity.put("dbm_id", new TableInfo.Column("dbm_id", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSalesIndentRequestDetailsEntity.put("rbm_name", new TableInfo.Column("rbm_name", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSalesIndentRequestDetailsEntity.put("dbm_name", new TableInfo.Column("dbm_name", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSalesIndentRequestDetailsEntity.put("rbm_quantity", new TableInfo.Column("rbm_quantity", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSalesIndentRequestDetailsEntity.put("rbm_approval_status", new TableInfo.Column("rbm_approval_status", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSalesIndentRequestDetailsEntity.put("am_approval_status", new TableInfo.Column("am_approval_status", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSalesIndentRequestDetailsEntity.put("am_id", new TableInfo.Column("am_id", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSalesIndentRequestDetailsEntity.put("am_name", new TableInfo.Column("am_name", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSalesIndentRequestDetailsEntity.put("am_qty", new TableInfo.Column("am_qty", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSalesIndentRequestDetailsEntity.put("am_remarks", new TableInfo.Column("am_remarks", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSalesIndentRequestDetailsEntity.put("dbm_approval_status", new TableInfo.Column("dbm_approval_status", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSalesIndentRequestDetailsEntity.put("rbm_approved_date", new TableInfo.Column("rbm_approved_date", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSalesIndentRequestDetailsEntity.put("rbm_approved_time", new TableInfo.Column("rbm_approved_time", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSalesIndentRequestDetailsEntity.put("rbm_remarks", new TableInfo.Column("rbm_remarks", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSalesIndentRequestDetailsEntity.put("sales_division_id", new TableInfo.Column("sales_division_id", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSalesIndentRequestDetailsEntity.put("sales_division_name", new TableInfo.Column("sales_division_name", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysSalesIndentRequestDetailsEntity = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesSalesIndentRequestDetailsEntity = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoSalesIndentRequestDetailsEntity = new TableInfo("SalesIndentRequestDetailsEntity", _columnsSalesIndentRequestDetailsEntity, _foreignKeysSalesIndentRequestDetailsEntity, _indicesSalesIndentRequestDetailsEntity);
        final TableInfo _existingSalesIndentRequestDetailsEntity = TableInfo.read(_db, "SalesIndentRequestDetailsEntity");
        if (! _infoSalesIndentRequestDetailsEntity.equals(_existingSalesIndentRequestDetailsEntity)) {
          return new RoomOpenHelper.ValidationResult(false, "SalesIndentRequestDetailsEntity(com.agriscience.salesindent.room_database.entity.SalesIndentRequestDetailsEntity).\n"
                  + " Expected:\n" + _infoSalesIndentRequestDetailsEntity + "\n"
                  + " Found:\n" + _existingSalesIndentRequestDetailsEntity);
        }
        final HashMap<String, TableInfo.Column> _columnsZOrganogramResponseDetails = new HashMap<String, TableInfo.Column>(21);
        _columnsZOrganogramResponseDetails.put("salesDivisionName", new TableInfo.Column("salesDivisionName", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsZOrganogramResponseDetails.put("territoryName", new TableInfo.Column("territoryName", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsZOrganogramResponseDetails.put("dataUpdatedInMobile", new TableInfo.Column("dataUpdatedInMobile", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsZOrganogramResponseDetails.put("inChargeT", new TableInfo.Column("inChargeT", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsZOrganogramResponseDetails.put("active", new TableInfo.Column("active", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsZOrganogramResponseDetails.put("dbm", new TableInfo.Column("dbm", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsZOrganogramResponseDetails.put("dataUpdatedInSap", new TableInfo.Column("dataUpdatedInSap", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsZOrganogramResponseDetails.put("division", new TableInfo.Column("division", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsZOrganogramResponseDetails.put("salesDivision", new TableInfo.Column("salesDivision", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsZOrganogramResponseDetails.put("plant", new TableInfo.Column("plant", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsZOrganogramResponseDetails.put("tiName", new TableInfo.Column("tiName", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsZOrganogramResponseDetails.put("regionName", new TableInfo.Column("regionName", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsZOrganogramResponseDetails.put("rbmName", new TableInfo.Column("rbmName", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsZOrganogramResponseDetails.put("region", new TableInfo.Column("region", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsZOrganogramResponseDetails.put("rbm", new TableInfo.Column("rbm", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsZOrganogramResponseDetails.put("dbmName", new TableInfo.Column("dbmName", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsZOrganogramResponseDetails.put("Plant_name", new TableInfo.Column("Plant_name", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsZOrganogramResponseDetails.put("territoryId", new TableInfo.Column("territoryId", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsZOrganogramResponseDetails.put("status", new TableInfo.Column("status", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsZOrganogramResponseDetails.put("areaManager", new TableInfo.Column("areaManager", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsZOrganogramResponseDetails.put("areaManagerName", new TableInfo.Column("areaManagerName", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysZOrganogramResponseDetails = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesZOrganogramResponseDetails = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoZOrganogramResponseDetails = new TableInfo("ZOrganogramResponseDetails", _columnsZOrganogramResponseDetails, _foreignKeysZOrganogramResponseDetails, _indicesZOrganogramResponseDetails);
        final TableInfo _existingZOrganogramResponseDetails = TableInfo.read(_db, "ZOrganogramResponseDetails");
        if (! _infoZOrganogramResponseDetails.equals(_existingZOrganogramResponseDetails)) {
          return new RoomOpenHelper.ValidationResult(false, "ZOrganogramResponseDetails(com.agriscience.salesindent.model.ZOrganogramResponseDetails).\n"
                  + " Expected:\n" + _infoZOrganogramResponseDetails + "\n"
                  + " Found:\n" + _existingZOrganogramResponseDetails);
        }
        final HashMap<String, TableInfo.Column> _columnsPlantDetails = new HashMap<String, TableInfo.Column>(5);
        _columnsPlantDetails.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPlantDetails.put("sales", new TableInfo.Column("sales", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPlantDetails.put("plantCode", new TableInfo.Column("plantCode", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPlantDetails.put("plantName", new TableInfo.Column("plantName", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPlantDetails.put("processing", new TableInfo.Column("processing", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysPlantDetails = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesPlantDetails = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoPlantDetails = new TableInfo("plant_details", _columnsPlantDetails, _foreignKeysPlantDetails, _indicesPlantDetails);
        final TableInfo _existingPlantDetails = TableInfo.read(_db, "plant_details");
        if (! _infoPlantDetails.equals(_existingPlantDetails)) {
          return new RoomOpenHelper.ValidationResult(false, "plant_details(com.agriscience.salesindent.model.PlantDetailsResponse).\n"
                  + " Expected:\n" + _infoPlantDetails + "\n"
                  + " Found:\n" + _existingPlantDetails);
        }
        final HashMap<String, TableInfo.Column> _columnsStoMaterial = new HashMap<String, TableInfo.Column>(11);
        _columnsStoMaterial.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsStoMaterial.put("varietyName", new TableInfo.Column("varietyName", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsStoMaterial.put("cropCode", new TableInfo.Column("cropCode", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsStoMaterial.put("cropName", new TableInfo.Column("cropName", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsStoMaterial.put("varietyCode", new TableInfo.Column("varietyCode", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsStoMaterial.put("packingQuantity", new TableInfo.Column("packingQuantity", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsStoMaterial.put("baseUom", new TableInfo.Column("baseUom", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsStoMaterial.put("message", new TableInfo.Column("message", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsStoMaterial.put("materialName", new TableInfo.Column("materialName", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsStoMaterial.put("status", new TableInfo.Column("status", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsStoMaterial.put("materialCode", new TableInfo.Column("materialCode", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysStoMaterial = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesStoMaterial = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoStoMaterial = new TableInfo("sto_material", _columnsStoMaterial, _foreignKeysStoMaterial, _indicesStoMaterial);
        final TableInfo _existingStoMaterial = TableInfo.read(_db, "sto_material");
        if (! _infoStoMaterial.equals(_existingStoMaterial)) {
          return new RoomOpenHelper.ValidationResult(false, "sto_material(com.agriscience.salesindent.model.STOMaterialDetailsResponse).\n"
                  + " Expected:\n" + _infoStoMaterial + "\n"
                  + " Found:\n" + _existingStoMaterial);
        }
        final HashMap<String, TableInfo.Column> _columnsSTOIndentTmpEntity = new HashMap<String, TableInfo.Column>(39);
        _columnsSTOIndentTmpEntity.put("STO_indent_no", new TableInfo.Column("STO_indent_no", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSTOIndentTmpEntity.put("indent_date", new TableInfo.Column("indent_date", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSTOIndentTmpEntity.put("Indent_time", new TableInfo.Column("Indent_time", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSTOIndentTmpEntity.put("Sending_plant", new TableInfo.Column("Sending_plant", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSTOIndentTmpEntity.put("Receiving_plant", new TableInfo.Column("Receiving_plant", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSTOIndentTmpEntity.put("Line_no", new TableInfo.Column("Line_no", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSTOIndentTmpEntity.put("Division", new TableInfo.Column("Division", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSTOIndentTmpEntity.put("Crop_name", new TableInfo.Column("Crop_name", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSTOIndentTmpEntity.put("Crop_code", new TableInfo.Column("Crop_code", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSTOIndentTmpEntity.put("Variety_code", new TableInfo.Column("Variety_code", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSTOIndentTmpEntity.put("Variety_name", new TableInfo.Column("Variety_name", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSTOIndentTmpEntity.put("Material_code", new TableInfo.Column("Material_code", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSTOIndentTmpEntity.put("Material_description", new TableInfo.Column("Material_description", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSTOIndentTmpEntity.put("Final_status", new TableInfo.Column("Final_status", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSTOIndentTmpEntity.put("Final_quantity", new TableInfo.Column("Final_quantity", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSTOIndentTmpEntity.put("final_item_weight", new TableInfo.Column("final_item_weight", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSTOIndentTmpEntity.put("final_no_of_pac", new TableInfo.Column("final_no_of_pac", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSTOIndentTmpEntity.put("Req_date", new TableInfo.Column("Req_date", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSTOIndentTmpEntity.put("Sales_region", new TableInfo.Column("Sales_region", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSTOIndentTmpEntity.put("sales_region_name", new TableInfo.Column("sales_region_name", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSTOIndentTmpEntity.put("RBM", new TableInfo.Column("RBM", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSTOIndentTmpEntity.put("rbm_name", new TableInfo.Column("rbm_name", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSTOIndentTmpEntity.put("rbm_qty", new TableInfo.Column("rbm_qty", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSTOIndentTmpEntity.put("Rbm_item_weight", new TableInfo.Column("Rbm_item_weight", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSTOIndentTmpEntity.put("Rbm_no_of_pac", new TableInfo.Column("Rbm_no_of_pac", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSTOIndentTmpEntity.put("rbm_remarks", new TableInfo.Column("rbm_remarks", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSTOIndentTmpEntity.put("sales_division", new TableInfo.Column("sales_division", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSTOIndentTmpEntity.put("sales_division_name", new TableInfo.Column("sales_division_name", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSTOIndentTmpEntity.put("dbm", new TableInfo.Column("dbm", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSTOIndentTmpEntity.put("dbm_name", new TableInfo.Column("dbm_name", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSTOIndentTmpEntity.put("dbm_remarks", new TableInfo.Column("dbm_remarks", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSTOIndentTmpEntity.put("dbm_qty", new TableInfo.Column("dbm_qty", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSTOIndentTmpEntity.put("dbm_item_weight", new TableInfo.Column("dbm_item_weight", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSTOIndentTmpEntity.put("dbm_no_of_pac", new TableInfo.Column("dbm_no_of_pac", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSTOIndentTmpEntity.put("packingQuantity", new TableInfo.Column("packingQuantity", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSTOIndentTmpEntity.put("baseUom", new TableInfo.Column("baseUom", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSTOIndentTmpEntity.put("dbm_approval_status", new TableInfo.Column("dbm_approval_status", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSTOIndentTmpEntity.put("dbm_approval_date", new TableInfo.Column("dbm_approval_date", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSTOIndentTmpEntity.put("dbm_approval_time", new TableInfo.Column("dbm_approval_time", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysSTOIndentTmpEntity = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesSTOIndentTmpEntity = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoSTOIndentTmpEntity = new TableInfo("STOIndentTmpEntity", _columnsSTOIndentTmpEntity, _foreignKeysSTOIndentTmpEntity, _indicesSTOIndentTmpEntity);
        final TableInfo _existingSTOIndentTmpEntity = TableInfo.read(_db, "STOIndentTmpEntity");
        if (! _infoSTOIndentTmpEntity.equals(_existingSTOIndentTmpEntity)) {
          return new RoomOpenHelper.ValidationResult(false, "STOIndentTmpEntity(com.agriscience.salesindent.room_database.entity.STOIndentTmpEntity).\n"
                  + " Expected:\n" + _infoSTOIndentTmpEntity + "\n"
                  + " Found:\n" + _existingSTOIndentTmpEntity);
        }
        return new RoomOpenHelper.ValidationResult(true, null);
      }
    }, "478450268c9337094e181a3d989cc67e", "8f3cfbe2a996a9f5a7fd6b51e6edc322");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(configuration.context)
        .name(configuration.name)
        .callback(_openCallback)
        .build();
    final SupportSQLiteOpenHelper _helper = configuration.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  protected InvalidationTracker createInvalidationTracker() {
    final HashMap<String, String> _shadowTablesMap = new HashMap<String, String>(0);
    HashMap<String, Set<String>> _viewTables = new HashMap<String, Set<String>>(0);
    return new InvalidationTracker(this, _shadowTablesMap, _viewTables, "customer_entity","material_entity","season_entity","SalesIndentDetailsTmpEntity","SalesIndentRequestDetailsEntity","ZOrganogramResponseDetails","plant_details","sto_material","STOIndentTmpEntity");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    try {
      super.beginTransaction();
      _db.execSQL("DELETE FROM `customer_entity`");
      _db.execSQL("DELETE FROM `material_entity`");
      _db.execSQL("DELETE FROM `season_entity`");
      _db.execSQL("DELETE FROM `SalesIndentDetailsTmpEntity`");
      _db.execSQL("DELETE FROM `SalesIndentRequestDetailsEntity`");
      _db.execSQL("DELETE FROM `ZOrganogramResponseDetails`");
      _db.execSQL("DELETE FROM `plant_details`");
      _db.execSQL("DELETE FROM `sto_material`");
      _db.execSQL("DELETE FROM `STOIndentTmpEntity`");
      super.setTransactionSuccessful();
    } finally {
      super.endTransaction();
      _db.query("PRAGMA wal_checkpoint(FULL)").close();
      if (!_db.inTransaction()) {
        _db.execSQL("VACUUM");
      }
    }
  }

  @Override
  protected Map<Class<?>, List<Class<?>>> getRequiredTypeConverters() {
    final HashMap<Class<?>, List<Class<?>>> _typeConvertersMap = new HashMap<Class<?>, List<Class<?>>>();
    _typeConvertersMap.put(CustomerDao.class, CustomerDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(MaterialDao.class, MaterialDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(SeasonDao.class, SeasonDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(SalesIndentDetailsDao.class, SalesIndentDetailsDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(SalesIndentTmpDao.class, SalesIndentTmpDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(ZOrganogramDetailsDao.class, ZOrganogramDetailsDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(PlantDao.class, PlantDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(STOMaterialDao.class, STOMaterialDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(STOIndentTmpDao.class, STOIndentTmpDao_Impl.getRequiredConverters());
    return _typeConvertersMap;
  }

  @Override
  public Set<Class<? extends AutoMigrationSpec>> getRequiredAutoMigrationSpecs() {
    final HashSet<Class<? extends AutoMigrationSpec>> _autoMigrationSpecsSet = new HashSet<Class<? extends AutoMigrationSpec>>();
    return _autoMigrationSpecsSet;
  }

  @Override
  public List<Migration> getAutoMigrations(
      @NonNull Map<Class<? extends AutoMigrationSpec>, AutoMigrationSpec> autoMigrationSpecsMap) {
    return Arrays.asList();
  }

  @Override
  public CustomerDao customerDao() {
    if (_customerDao != null) {
      return _customerDao;
    } else {
      synchronized(this) {
        if(_customerDao == null) {
          _customerDao = new CustomerDao_Impl(this);
        }
        return _customerDao;
      }
    }
  }

  @Override
  public MaterialDao materialDao() {
    if (_materialDao != null) {
      return _materialDao;
    } else {
      synchronized(this) {
        if(_materialDao == null) {
          _materialDao = new MaterialDao_Impl(this);
        }
        return _materialDao;
      }
    }
  }

  @Override
  public SeasonDao seasonDao() {
    if (_seasonDao != null) {
      return _seasonDao;
    } else {
      synchronized(this) {
        if(_seasonDao == null) {
          _seasonDao = new SeasonDao_Impl(this);
        }
        return _seasonDao;
      }
    }
  }

  @Override
  public SalesIndentDetailsDao salesIndentDetailsDao() {
    if (_salesIndentDetailsDao != null) {
      return _salesIndentDetailsDao;
    } else {
      synchronized(this) {
        if(_salesIndentDetailsDao == null) {
          _salesIndentDetailsDao = new SalesIndentDetailsDao_Impl(this);
        }
        return _salesIndentDetailsDao;
      }
    }
  }

  @Override
  public SalesIndentTmpDao salesIndentTmpDao() {
    if (_salesIndentTmpDao != null) {
      return _salesIndentTmpDao;
    } else {
      synchronized(this) {
        if(_salesIndentTmpDao == null) {
          _salesIndentTmpDao = new SalesIndentTmpDao_Impl(this);
        }
        return _salesIndentTmpDao;
      }
    }
  }

  @Override
  public ZOrganogramDetailsDao zOrganogramDetailsDao() {
    if (_zOrganogramDetailsDao != null) {
      return _zOrganogramDetailsDao;
    } else {
      synchronized(this) {
        if(_zOrganogramDetailsDao == null) {
          _zOrganogramDetailsDao = new ZOrganogramDetailsDao_Impl(this);
        }
        return _zOrganogramDetailsDao;
      }
    }
  }

  @Override
  public PlantDao plantDao() {
    if (_plantDao != null) {
      return _plantDao;
    } else {
      synchronized(this) {
        if(_plantDao == null) {
          _plantDao = new PlantDao_Impl(this);
        }
        return _plantDao;
      }
    }
  }

  @Override
  public STOMaterialDao stoMaterialDao() {
    if (_sTOMaterialDao != null) {
      return _sTOMaterialDao;
    } else {
      synchronized(this) {
        if(_sTOMaterialDao == null) {
          _sTOMaterialDao = new STOMaterialDao_Impl(this);
        }
        return _sTOMaterialDao;
      }
    }
  }

  @Override
  public STOIndentTmpDao stoIndentTmpDao() {
    if (_sTOIndentTmpDao != null) {
      return _sTOIndentTmpDao;
    } else {
      synchronized(this) {
        if(_sTOIndentTmpDao == null) {
          _sTOIndentTmpDao = new STOIndentTmpDao_Impl(this);
        }
        return _sTOIndentTmpDao;
      }
    }
  }
}
