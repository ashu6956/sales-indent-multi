package com.agriscience.salesindent.room_database.dao;

import android.database.Cursor;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.agriscience.salesindent.room_database.entity.SalesIndentRequestDetailsEntity;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@SuppressWarnings({"unchecked", "deprecation"})
public final class SalesIndentDetailsDao_Impl implements SalesIndentDetailsDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<SalesIndentRequestDetailsEntity> __insertionAdapterOfSalesIndentRequestDetailsEntity;

  private final SharedSQLiteStatement __preparedStmtOfDeleteAllSalesIndentRequestDetails;

  public SalesIndentDetailsDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfSalesIndentRequestDetailsEntity = new EntityInsertionAdapter<SalesIndentRequestDetailsEntity>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `SalesIndentRequestDetailsEntity` (`indent_no`,`indent_date`,`indent_time`,`sale_organization`,`distribution_channel`,`division`,`sales_office`,`customer_code`,`customer_name`,`customer_state_id`,`crop_code`,`crop_name`,`season_code`,`season_starting_date`,`season_end_date`,`return_cut_off_date`,`varity_code`,`varity_name`,`line_item_no`,`material_code`,`material_name`,`plant`,`base_uom`,`packing_quantity`,`quantity_in_kgs_or_packets`,`required_quantity_in_kgs`,`no_of_packets_required`,`indent_overall_status`,`territory_id`,`territory_name`,`ti_id`,`ti_name`,`ti_quantity`,`ti_remarks`,`sales_region_id`,`sales_region_name`,`rbm_id`,`dbm_id`,`rbm_name`,`dbm_name`,`rbm_quantity`,`rbm_approval_status`,`am_approval_status`,`am_id`,`am_name`,`am_qty`,`am_remarks`,`dbm_approval_status`,`rbm_approved_date`,`rbm_approved_time`,`rbm_remarks`,`sales_division_id`,`sales_division_name`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, SalesIndentRequestDetailsEntity value) {
        if (value.getIndentNo() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getIndentNo());
        }
        if (value.getIndentDate() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getIndentDate());
        }
        if (value.getIndentTime() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getIndentTime());
        }
        if (value.getSaleOrganization() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getSaleOrganization());
        }
        if (value.getDistributionChannel() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getDistributionChannel());
        }
        if (value.getDivision() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getDivision());
        }
        if (value.getSalesOffice() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getSalesOffice());
        }
        if (value.getCustomerCode() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getCustomerCode());
        }
        if (value.getCustomerName() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, value.getCustomerName());
        }
        if (value.getCustomerStateId() == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindString(10, value.getCustomerStateId());
        }
        if (value.getCropCode() == null) {
          stmt.bindNull(11);
        } else {
          stmt.bindString(11, value.getCropCode());
        }
        if (value.getCropName() == null) {
          stmt.bindNull(12);
        } else {
          stmt.bindString(12, value.getCropName());
        }
        if (value.getSeasonCode() == null) {
          stmt.bindNull(13);
        } else {
          stmt.bindString(13, value.getSeasonCode());
        }
        if (value.getSeasonStartingDate() == null) {
          stmt.bindNull(14);
        } else {
          stmt.bindString(14, value.getSeasonStartingDate());
        }
        if (value.getSeasonEndDate() == null) {
          stmt.bindNull(15);
        } else {
          stmt.bindString(15, value.getSeasonEndDate());
        }
        if (value.getReturnCutOffDate() == null) {
          stmt.bindNull(16);
        } else {
          stmt.bindString(16, value.getReturnCutOffDate());
        }
        if (value.getVarietyCode() == null) {
          stmt.bindNull(17);
        } else {
          stmt.bindString(17, value.getVarietyCode());
        }
        if (value.getVarietyName() == null) {
          stmt.bindNull(18);
        } else {
          stmt.bindString(18, value.getVarietyName());
        }
        if (value.getLineItemNo() == null) {
          stmt.bindNull(19);
        } else {
          stmt.bindString(19, value.getLineItemNo());
        }
        if (value.getMaterialCode() == null) {
          stmt.bindNull(20);
        } else {
          stmt.bindString(20, value.getMaterialCode());
        }
        if (value.getMaterialName() == null) {
          stmt.bindNull(21);
        } else {
          stmt.bindString(21, value.getMaterialName());
        }
        if (value.getPlant() == null) {
          stmt.bindNull(22);
        } else {
          stmt.bindString(22, value.getPlant());
        }
        if (value.getBaseUom() == null) {
          stmt.bindNull(23);
        } else {
          stmt.bindString(23, value.getBaseUom());
        }
        if (value.getPackingQuantity() == null) {
          stmt.bindNull(24);
        } else {
          stmt.bindString(24, value.getPackingQuantity());
        }
        if (value.getQuantityInKgsOrPackets() == null) {
          stmt.bindNull(25);
        } else {
          stmt.bindString(25, value.getQuantityInKgsOrPackets());
        }
        if (value.getRequiredQuantityInKgs() == null) {
          stmt.bindNull(26);
        } else {
          stmt.bindString(26, value.getRequiredQuantityInKgs());
        }
        if (value.getNoOfPacketsRequired() == null) {
          stmt.bindNull(27);
        } else {
          stmt.bindString(27, value.getNoOfPacketsRequired());
        }
        if (value.getIndentOverAllStatus() == null) {
          stmt.bindNull(28);
        } else {
          stmt.bindString(28, value.getIndentOverAllStatus());
        }
        if (value.getTerritoryId() == null) {
          stmt.bindNull(29);
        } else {
          stmt.bindString(29, value.getTerritoryId());
        }
        if (value.getTerritoryName() == null) {
          stmt.bindNull(30);
        } else {
          stmt.bindString(30, value.getTerritoryName());
        }
        if (value.getTiId() == null) {
          stmt.bindNull(31);
        } else {
          stmt.bindString(31, value.getTiId());
        }
        if (value.getTiName() == null) {
          stmt.bindNull(32);
        } else {
          stmt.bindString(32, value.getTiName());
        }
        if (value.getTiQuantity() == null) {
          stmt.bindNull(33);
        } else {
          stmt.bindString(33, value.getTiQuantity());
        }
        if (value.getTiRemarks() == null) {
          stmt.bindNull(34);
        } else {
          stmt.bindString(34, value.getTiRemarks());
        }
        if (value.getSalesRegionId() == null) {
          stmt.bindNull(35);
        } else {
          stmt.bindString(35, value.getSalesRegionId());
        }
        if (value.getSalesRegionName() == null) {
          stmt.bindNull(36);
        } else {
          stmt.bindString(36, value.getSalesRegionName());
        }
        if (value.getRbmId() == null) {
          stmt.bindNull(37);
        } else {
          stmt.bindString(37, value.getRbmId());
        }
        if (value.getDbmId() == null) {
          stmt.bindNull(38);
        } else {
          stmt.bindString(38, value.getDbmId());
        }
        if (value.getRbmName() == null) {
          stmt.bindNull(39);
        } else {
          stmt.bindString(39, value.getRbmName());
        }
        if (value.getDbmName() == null) {
          stmt.bindNull(40);
        } else {
          stmt.bindString(40, value.getDbmName());
        }
        if (value.getRbmQuantity() == null) {
          stmt.bindNull(41);
        } else {
          stmt.bindString(41, value.getRbmQuantity());
        }
        if (value.getRbmApprovalStatus() == null) {
          stmt.bindNull(42);
        } else {
          stmt.bindString(42, value.getRbmApprovalStatus());
        }
        if (value.getAmApprovalStatus() == null) {
          stmt.bindNull(43);
        } else {
          stmt.bindString(43, value.getAmApprovalStatus());
        }
        if (value.getAmId() == null) {
          stmt.bindNull(44);
        } else {
          stmt.bindString(44, value.getAmId());
        }
        if (value.getAmName() == null) {
          stmt.bindNull(45);
        } else {
          stmt.bindString(45, value.getAmName());
        }
        if (value.getAmQty() == null) {
          stmt.bindNull(46);
        } else {
          stmt.bindString(46, value.getAmQty());
        }
        if (value.getAmRemarks() == null) {
          stmt.bindNull(47);
        } else {
          stmt.bindString(47, value.getAmRemarks());
        }
        if (value.getDbmApprovalStatus() == null) {
          stmt.bindNull(48);
        } else {
          stmt.bindString(48, value.getDbmApprovalStatus());
        }
        if (value.getRbmApprovedDate() == null) {
          stmt.bindNull(49);
        } else {
          stmt.bindString(49, value.getRbmApprovedDate());
        }
        if (value.getRbmApprovedTime() == null) {
          stmt.bindNull(50);
        } else {
          stmt.bindString(50, value.getRbmApprovedTime());
        }
        if (value.getRbmRemarks() == null) {
          stmt.bindNull(51);
        } else {
          stmt.bindString(51, value.getRbmRemarks());
        }
        if (value.getSalesDivisionId() == null) {
          stmt.bindNull(52);
        } else {
          stmt.bindString(52, value.getSalesDivisionId());
        }
        if (value.getSalesDivisionName() == null) {
          stmt.bindNull(53);
        } else {
          stmt.bindString(53, value.getSalesDivisionName());
        }
      }
    };
    this.__preparedStmtOfDeleteAllSalesIndentRequestDetails = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "Delete from SalesIndentRequestDetailsEntity";
        return _query;
      }
    };
  }

  @Override
  public void insertAll(
      final SalesIndentRequestDetailsEntity... salesIndentRequestDetailsEntities) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfSalesIndentRequestDetailsEntity.insert(salesIndentRequestDetailsEntities);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void deleteAllSalesIndentRequestDetails() {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteAllSalesIndentRequestDetails.acquire();
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfDeleteAllSalesIndentRequestDetails.release(_stmt);
    }
  }

  @Override
  public List<SalesIndentRequestDetailsEntity> getAllSalesIndentRequestDetails() {
    final String _sql = "Select * from SalesIndentRequestDetailsEntity";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfIndentNo = CursorUtil.getColumnIndexOrThrow(_cursor, "indent_no");
      final int _cursorIndexOfIndentDate = CursorUtil.getColumnIndexOrThrow(_cursor, "indent_date");
      final int _cursorIndexOfIndentTime = CursorUtil.getColumnIndexOrThrow(_cursor, "indent_time");
      final int _cursorIndexOfSaleOrganization = CursorUtil.getColumnIndexOrThrow(_cursor, "sale_organization");
      final int _cursorIndexOfDistributionChannel = CursorUtil.getColumnIndexOrThrow(_cursor, "distribution_channel");
      final int _cursorIndexOfDivision = CursorUtil.getColumnIndexOrThrow(_cursor, "division");
      final int _cursorIndexOfSalesOffice = CursorUtil.getColumnIndexOrThrow(_cursor, "sales_office");
      final int _cursorIndexOfCustomerCode = CursorUtil.getColumnIndexOrThrow(_cursor, "customer_code");
      final int _cursorIndexOfCustomerName = CursorUtil.getColumnIndexOrThrow(_cursor, "customer_name");
      final int _cursorIndexOfCustomerStateId = CursorUtil.getColumnIndexOrThrow(_cursor, "customer_state_id");
      final int _cursorIndexOfCropCode = CursorUtil.getColumnIndexOrThrow(_cursor, "crop_code");
      final int _cursorIndexOfCropName = CursorUtil.getColumnIndexOrThrow(_cursor, "crop_name");
      final int _cursorIndexOfSeasonCode = CursorUtil.getColumnIndexOrThrow(_cursor, "season_code");
      final int _cursorIndexOfSeasonStartingDate = CursorUtil.getColumnIndexOrThrow(_cursor, "season_starting_date");
      final int _cursorIndexOfSeasonEndDate = CursorUtil.getColumnIndexOrThrow(_cursor, "season_end_date");
      final int _cursorIndexOfReturnCutOffDate = CursorUtil.getColumnIndexOrThrow(_cursor, "return_cut_off_date");
      final int _cursorIndexOfVarietyCode = CursorUtil.getColumnIndexOrThrow(_cursor, "varity_code");
      final int _cursorIndexOfVarietyName = CursorUtil.getColumnIndexOrThrow(_cursor, "varity_name");
      final int _cursorIndexOfLineItemNo = CursorUtil.getColumnIndexOrThrow(_cursor, "line_item_no");
      final int _cursorIndexOfMaterialCode = CursorUtil.getColumnIndexOrThrow(_cursor, "material_code");
      final int _cursorIndexOfMaterialName = CursorUtil.getColumnIndexOrThrow(_cursor, "material_name");
      final int _cursorIndexOfPlant = CursorUtil.getColumnIndexOrThrow(_cursor, "plant");
      final int _cursorIndexOfBaseUom = CursorUtil.getColumnIndexOrThrow(_cursor, "base_uom");
      final int _cursorIndexOfPackingQuantity = CursorUtil.getColumnIndexOrThrow(_cursor, "packing_quantity");
      final int _cursorIndexOfQuantityInKgsOrPackets = CursorUtil.getColumnIndexOrThrow(_cursor, "quantity_in_kgs_or_packets");
      final int _cursorIndexOfRequiredQuantityInKgs = CursorUtil.getColumnIndexOrThrow(_cursor, "required_quantity_in_kgs");
      final int _cursorIndexOfNoOfPacketsRequired = CursorUtil.getColumnIndexOrThrow(_cursor, "no_of_packets_required");
      final int _cursorIndexOfIndentOverAllStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "indent_overall_status");
      final int _cursorIndexOfTerritoryId = CursorUtil.getColumnIndexOrThrow(_cursor, "territory_id");
      final int _cursorIndexOfTerritoryName = CursorUtil.getColumnIndexOrThrow(_cursor, "territory_name");
      final int _cursorIndexOfTiId = CursorUtil.getColumnIndexOrThrow(_cursor, "ti_id");
      final int _cursorIndexOfTiName = CursorUtil.getColumnIndexOrThrow(_cursor, "ti_name");
      final int _cursorIndexOfTiQuantity = CursorUtil.getColumnIndexOrThrow(_cursor, "ti_quantity");
      final int _cursorIndexOfTiRemarks = CursorUtil.getColumnIndexOrThrow(_cursor, "ti_remarks");
      final int _cursorIndexOfSalesRegionId = CursorUtil.getColumnIndexOrThrow(_cursor, "sales_region_id");
      final int _cursorIndexOfSalesRegionName = CursorUtil.getColumnIndexOrThrow(_cursor, "sales_region_name");
      final int _cursorIndexOfRbmId = CursorUtil.getColumnIndexOrThrow(_cursor, "rbm_id");
      final int _cursorIndexOfDbmId = CursorUtil.getColumnIndexOrThrow(_cursor, "dbm_id");
      final int _cursorIndexOfRbmName = CursorUtil.getColumnIndexOrThrow(_cursor, "rbm_name");
      final int _cursorIndexOfDbmName = CursorUtil.getColumnIndexOrThrow(_cursor, "dbm_name");
      final int _cursorIndexOfRbmQuantity = CursorUtil.getColumnIndexOrThrow(_cursor, "rbm_quantity");
      final int _cursorIndexOfRbmApprovalStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "rbm_approval_status");
      final int _cursorIndexOfAmApprovalStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "am_approval_status");
      final int _cursorIndexOfAmId = CursorUtil.getColumnIndexOrThrow(_cursor, "am_id");
      final int _cursorIndexOfAmName = CursorUtil.getColumnIndexOrThrow(_cursor, "am_name");
      final int _cursorIndexOfAmQty = CursorUtil.getColumnIndexOrThrow(_cursor, "am_qty");
      final int _cursorIndexOfAmRemarks = CursorUtil.getColumnIndexOrThrow(_cursor, "am_remarks");
      final int _cursorIndexOfDbmApprovalStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "dbm_approval_status");
      final int _cursorIndexOfRbmApprovedDate = CursorUtil.getColumnIndexOrThrow(_cursor, "rbm_approved_date");
      final int _cursorIndexOfRbmApprovedTime = CursorUtil.getColumnIndexOrThrow(_cursor, "rbm_approved_time");
      final int _cursorIndexOfRbmRemarks = CursorUtil.getColumnIndexOrThrow(_cursor, "rbm_remarks");
      final int _cursorIndexOfSalesDivisionId = CursorUtil.getColumnIndexOrThrow(_cursor, "sales_division_id");
      final int _cursorIndexOfSalesDivisionName = CursorUtil.getColumnIndexOrThrow(_cursor, "sales_division_name");
      final List<SalesIndentRequestDetailsEntity> _result = new ArrayList<SalesIndentRequestDetailsEntity>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final SalesIndentRequestDetailsEntity _item;
        _item = new SalesIndentRequestDetailsEntity();
        final String _tmpIndentNo;
        if (_cursor.isNull(_cursorIndexOfIndentNo)) {
          _tmpIndentNo = null;
        } else {
          _tmpIndentNo = _cursor.getString(_cursorIndexOfIndentNo);
        }
        _item.setIndentNo(_tmpIndentNo);
        final String _tmpIndentDate;
        if (_cursor.isNull(_cursorIndexOfIndentDate)) {
          _tmpIndentDate = null;
        } else {
          _tmpIndentDate = _cursor.getString(_cursorIndexOfIndentDate);
        }
        _item.setIndentDate(_tmpIndentDate);
        final String _tmpIndentTime;
        if (_cursor.isNull(_cursorIndexOfIndentTime)) {
          _tmpIndentTime = null;
        } else {
          _tmpIndentTime = _cursor.getString(_cursorIndexOfIndentTime);
        }
        _item.setIndentTime(_tmpIndentTime);
        final String _tmpSaleOrganization;
        if (_cursor.isNull(_cursorIndexOfSaleOrganization)) {
          _tmpSaleOrganization = null;
        } else {
          _tmpSaleOrganization = _cursor.getString(_cursorIndexOfSaleOrganization);
        }
        _item.setSaleOrganization(_tmpSaleOrganization);
        final String _tmpDistributionChannel;
        if (_cursor.isNull(_cursorIndexOfDistributionChannel)) {
          _tmpDistributionChannel = null;
        } else {
          _tmpDistributionChannel = _cursor.getString(_cursorIndexOfDistributionChannel);
        }
        _item.setDistributionChannel(_tmpDistributionChannel);
        final String _tmpDivision;
        if (_cursor.isNull(_cursorIndexOfDivision)) {
          _tmpDivision = null;
        } else {
          _tmpDivision = _cursor.getString(_cursorIndexOfDivision);
        }
        _item.setDivision(_tmpDivision);
        final String _tmpSalesOffice;
        if (_cursor.isNull(_cursorIndexOfSalesOffice)) {
          _tmpSalesOffice = null;
        } else {
          _tmpSalesOffice = _cursor.getString(_cursorIndexOfSalesOffice);
        }
        _item.setSalesOffice(_tmpSalesOffice);
        final String _tmpCustomerCode;
        if (_cursor.isNull(_cursorIndexOfCustomerCode)) {
          _tmpCustomerCode = null;
        } else {
          _tmpCustomerCode = _cursor.getString(_cursorIndexOfCustomerCode);
        }
        _item.setCustomerCode(_tmpCustomerCode);
        final String _tmpCustomerName;
        if (_cursor.isNull(_cursorIndexOfCustomerName)) {
          _tmpCustomerName = null;
        } else {
          _tmpCustomerName = _cursor.getString(_cursorIndexOfCustomerName);
        }
        _item.setCustomerName(_tmpCustomerName);
        final String _tmpCustomerStateId;
        if (_cursor.isNull(_cursorIndexOfCustomerStateId)) {
          _tmpCustomerStateId = null;
        } else {
          _tmpCustomerStateId = _cursor.getString(_cursorIndexOfCustomerStateId);
        }
        _item.setCustomerStateId(_tmpCustomerStateId);
        final String _tmpCropCode;
        if (_cursor.isNull(_cursorIndexOfCropCode)) {
          _tmpCropCode = null;
        } else {
          _tmpCropCode = _cursor.getString(_cursorIndexOfCropCode);
        }
        _item.setCropCode(_tmpCropCode);
        final String _tmpCropName;
        if (_cursor.isNull(_cursorIndexOfCropName)) {
          _tmpCropName = null;
        } else {
          _tmpCropName = _cursor.getString(_cursorIndexOfCropName);
        }
        _item.setCropName(_tmpCropName);
        final String _tmpSeasonCode;
        if (_cursor.isNull(_cursorIndexOfSeasonCode)) {
          _tmpSeasonCode = null;
        } else {
          _tmpSeasonCode = _cursor.getString(_cursorIndexOfSeasonCode);
        }
        _item.setSeasonCode(_tmpSeasonCode);
        final String _tmpSeasonStartingDate;
        if (_cursor.isNull(_cursorIndexOfSeasonStartingDate)) {
          _tmpSeasonStartingDate = null;
        } else {
          _tmpSeasonStartingDate = _cursor.getString(_cursorIndexOfSeasonStartingDate);
        }
        _item.setSeasonStartingDate(_tmpSeasonStartingDate);
        final String _tmpSeasonEndDate;
        if (_cursor.isNull(_cursorIndexOfSeasonEndDate)) {
          _tmpSeasonEndDate = null;
        } else {
          _tmpSeasonEndDate = _cursor.getString(_cursorIndexOfSeasonEndDate);
        }
        _item.setSeasonEndDate(_tmpSeasonEndDate);
        final String _tmpReturnCutOffDate;
        if (_cursor.isNull(_cursorIndexOfReturnCutOffDate)) {
          _tmpReturnCutOffDate = null;
        } else {
          _tmpReturnCutOffDate = _cursor.getString(_cursorIndexOfReturnCutOffDate);
        }
        _item.setReturnCutOffDate(_tmpReturnCutOffDate);
        final String _tmpVarietyCode;
        if (_cursor.isNull(_cursorIndexOfVarietyCode)) {
          _tmpVarietyCode = null;
        } else {
          _tmpVarietyCode = _cursor.getString(_cursorIndexOfVarietyCode);
        }
        _item.setVarietyCode(_tmpVarietyCode);
        final String _tmpVarietyName;
        if (_cursor.isNull(_cursorIndexOfVarietyName)) {
          _tmpVarietyName = null;
        } else {
          _tmpVarietyName = _cursor.getString(_cursorIndexOfVarietyName);
        }
        _item.setVarietyName(_tmpVarietyName);
        final String _tmpLineItemNo;
        if (_cursor.isNull(_cursorIndexOfLineItemNo)) {
          _tmpLineItemNo = null;
        } else {
          _tmpLineItemNo = _cursor.getString(_cursorIndexOfLineItemNo);
        }
        _item.setLineItemNo(_tmpLineItemNo);
        final String _tmpMaterialCode;
        if (_cursor.isNull(_cursorIndexOfMaterialCode)) {
          _tmpMaterialCode = null;
        } else {
          _tmpMaterialCode = _cursor.getString(_cursorIndexOfMaterialCode);
        }
        _item.setMaterialCode(_tmpMaterialCode);
        final String _tmpMaterialName;
        if (_cursor.isNull(_cursorIndexOfMaterialName)) {
          _tmpMaterialName = null;
        } else {
          _tmpMaterialName = _cursor.getString(_cursorIndexOfMaterialName);
        }
        _item.setMaterialName(_tmpMaterialName);
        final String _tmpPlant;
        if (_cursor.isNull(_cursorIndexOfPlant)) {
          _tmpPlant = null;
        } else {
          _tmpPlant = _cursor.getString(_cursorIndexOfPlant);
        }
        _item.setPlant(_tmpPlant);
        final String _tmpBaseUom;
        if (_cursor.isNull(_cursorIndexOfBaseUom)) {
          _tmpBaseUom = null;
        } else {
          _tmpBaseUom = _cursor.getString(_cursorIndexOfBaseUom);
        }
        _item.setBaseUom(_tmpBaseUom);
        final String _tmpPackingQuantity;
        if (_cursor.isNull(_cursorIndexOfPackingQuantity)) {
          _tmpPackingQuantity = null;
        } else {
          _tmpPackingQuantity = _cursor.getString(_cursorIndexOfPackingQuantity);
        }
        _item.setPackingQuantity(_tmpPackingQuantity);
        final String _tmpQuantityInKgsOrPackets;
        if (_cursor.isNull(_cursorIndexOfQuantityInKgsOrPackets)) {
          _tmpQuantityInKgsOrPackets = null;
        } else {
          _tmpQuantityInKgsOrPackets = _cursor.getString(_cursorIndexOfQuantityInKgsOrPackets);
        }
        _item.setQuantityInKgsOrPackets(_tmpQuantityInKgsOrPackets);
        final String _tmpRequiredQuantityInKgs;
        if (_cursor.isNull(_cursorIndexOfRequiredQuantityInKgs)) {
          _tmpRequiredQuantityInKgs = null;
        } else {
          _tmpRequiredQuantityInKgs = _cursor.getString(_cursorIndexOfRequiredQuantityInKgs);
        }
        _item.setRequiredQuantityInKgs(_tmpRequiredQuantityInKgs);
        final String _tmpNoOfPacketsRequired;
        if (_cursor.isNull(_cursorIndexOfNoOfPacketsRequired)) {
          _tmpNoOfPacketsRequired = null;
        } else {
          _tmpNoOfPacketsRequired = _cursor.getString(_cursorIndexOfNoOfPacketsRequired);
        }
        _item.setNoOfPacketsRequired(_tmpNoOfPacketsRequired);
        final String _tmpIndentOverAllStatus;
        if (_cursor.isNull(_cursorIndexOfIndentOverAllStatus)) {
          _tmpIndentOverAllStatus = null;
        } else {
          _tmpIndentOverAllStatus = _cursor.getString(_cursorIndexOfIndentOverAllStatus);
        }
        _item.setIndentOverAllStatus(_tmpIndentOverAllStatus);
        final String _tmpTerritoryId;
        if (_cursor.isNull(_cursorIndexOfTerritoryId)) {
          _tmpTerritoryId = null;
        } else {
          _tmpTerritoryId = _cursor.getString(_cursorIndexOfTerritoryId);
        }
        _item.setTerritoryId(_tmpTerritoryId);
        final String _tmpTerritoryName;
        if (_cursor.isNull(_cursorIndexOfTerritoryName)) {
          _tmpTerritoryName = null;
        } else {
          _tmpTerritoryName = _cursor.getString(_cursorIndexOfTerritoryName);
        }
        _item.setTerritoryName(_tmpTerritoryName);
        final String _tmpTiId;
        if (_cursor.isNull(_cursorIndexOfTiId)) {
          _tmpTiId = null;
        } else {
          _tmpTiId = _cursor.getString(_cursorIndexOfTiId);
        }
        _item.setTiId(_tmpTiId);
        final String _tmpTiName;
        if (_cursor.isNull(_cursorIndexOfTiName)) {
          _tmpTiName = null;
        } else {
          _tmpTiName = _cursor.getString(_cursorIndexOfTiName);
        }
        _item.setTiName(_tmpTiName);
        final String _tmpTiQuantity;
        if (_cursor.isNull(_cursorIndexOfTiQuantity)) {
          _tmpTiQuantity = null;
        } else {
          _tmpTiQuantity = _cursor.getString(_cursorIndexOfTiQuantity);
        }
        _item.setTiQuantity(_tmpTiQuantity);
        final String _tmpTiRemarks;
        if (_cursor.isNull(_cursorIndexOfTiRemarks)) {
          _tmpTiRemarks = null;
        } else {
          _tmpTiRemarks = _cursor.getString(_cursorIndexOfTiRemarks);
        }
        _item.setTiRemarks(_tmpTiRemarks);
        final String _tmpSalesRegionId;
        if (_cursor.isNull(_cursorIndexOfSalesRegionId)) {
          _tmpSalesRegionId = null;
        } else {
          _tmpSalesRegionId = _cursor.getString(_cursorIndexOfSalesRegionId);
        }
        _item.setSalesRegionId(_tmpSalesRegionId);
        final String _tmpSalesRegionName;
        if (_cursor.isNull(_cursorIndexOfSalesRegionName)) {
          _tmpSalesRegionName = null;
        } else {
          _tmpSalesRegionName = _cursor.getString(_cursorIndexOfSalesRegionName);
        }
        _item.setSalesRegionName(_tmpSalesRegionName);
        final String _tmpRbmId;
        if (_cursor.isNull(_cursorIndexOfRbmId)) {
          _tmpRbmId = null;
        } else {
          _tmpRbmId = _cursor.getString(_cursorIndexOfRbmId);
        }
        _item.setRbmId(_tmpRbmId);
        final String _tmpDbmId;
        if (_cursor.isNull(_cursorIndexOfDbmId)) {
          _tmpDbmId = null;
        } else {
          _tmpDbmId = _cursor.getString(_cursorIndexOfDbmId);
        }
        _item.setDbmId(_tmpDbmId);
        final String _tmpRbmName;
        if (_cursor.isNull(_cursorIndexOfRbmName)) {
          _tmpRbmName = null;
        } else {
          _tmpRbmName = _cursor.getString(_cursorIndexOfRbmName);
        }
        _item.setRbmName(_tmpRbmName);
        final String _tmpDbmName;
        if (_cursor.isNull(_cursorIndexOfDbmName)) {
          _tmpDbmName = null;
        } else {
          _tmpDbmName = _cursor.getString(_cursorIndexOfDbmName);
        }
        _item.setDbmName(_tmpDbmName);
        final String _tmpRbmQuantity;
        if (_cursor.isNull(_cursorIndexOfRbmQuantity)) {
          _tmpRbmQuantity = null;
        } else {
          _tmpRbmQuantity = _cursor.getString(_cursorIndexOfRbmQuantity);
        }
        _item.setRbmQuantity(_tmpRbmQuantity);
        final String _tmpRbmApprovalStatus;
        if (_cursor.isNull(_cursorIndexOfRbmApprovalStatus)) {
          _tmpRbmApprovalStatus = null;
        } else {
          _tmpRbmApprovalStatus = _cursor.getString(_cursorIndexOfRbmApprovalStatus);
        }
        _item.setRbmApprovalStatus(_tmpRbmApprovalStatus);
        final String _tmpAmApprovalStatus;
        if (_cursor.isNull(_cursorIndexOfAmApprovalStatus)) {
          _tmpAmApprovalStatus = null;
        } else {
          _tmpAmApprovalStatus = _cursor.getString(_cursorIndexOfAmApprovalStatus);
        }
        _item.setAmApprovalStatus(_tmpAmApprovalStatus);
        final String _tmpAmId;
        if (_cursor.isNull(_cursorIndexOfAmId)) {
          _tmpAmId = null;
        } else {
          _tmpAmId = _cursor.getString(_cursorIndexOfAmId);
        }
        _item.setAmId(_tmpAmId);
        final String _tmpAmName;
        if (_cursor.isNull(_cursorIndexOfAmName)) {
          _tmpAmName = null;
        } else {
          _tmpAmName = _cursor.getString(_cursorIndexOfAmName);
        }
        _item.setAmName(_tmpAmName);
        final String _tmpAmQty;
        if (_cursor.isNull(_cursorIndexOfAmQty)) {
          _tmpAmQty = null;
        } else {
          _tmpAmQty = _cursor.getString(_cursorIndexOfAmQty);
        }
        _item.setAmQty(_tmpAmQty);
        final String _tmpAmRemarks;
        if (_cursor.isNull(_cursorIndexOfAmRemarks)) {
          _tmpAmRemarks = null;
        } else {
          _tmpAmRemarks = _cursor.getString(_cursorIndexOfAmRemarks);
        }
        _item.setAmRemarks(_tmpAmRemarks);
        final String _tmpDbmApprovalStatus;
        if (_cursor.isNull(_cursorIndexOfDbmApprovalStatus)) {
          _tmpDbmApprovalStatus = null;
        } else {
          _tmpDbmApprovalStatus = _cursor.getString(_cursorIndexOfDbmApprovalStatus);
        }
        _item.setDbmApprovalStatus(_tmpDbmApprovalStatus);
        final String _tmpRbmApprovedDate;
        if (_cursor.isNull(_cursorIndexOfRbmApprovedDate)) {
          _tmpRbmApprovedDate = null;
        } else {
          _tmpRbmApprovedDate = _cursor.getString(_cursorIndexOfRbmApprovedDate);
        }
        _item.setRbmApprovedDate(_tmpRbmApprovedDate);
        final String _tmpRbmApprovedTime;
        if (_cursor.isNull(_cursorIndexOfRbmApprovedTime)) {
          _tmpRbmApprovedTime = null;
        } else {
          _tmpRbmApprovedTime = _cursor.getString(_cursorIndexOfRbmApprovedTime);
        }
        _item.setRbmApprovedTime(_tmpRbmApprovedTime);
        final String _tmpRbmRemarks;
        if (_cursor.isNull(_cursorIndexOfRbmRemarks)) {
          _tmpRbmRemarks = null;
        } else {
          _tmpRbmRemarks = _cursor.getString(_cursorIndexOfRbmRemarks);
        }
        _item.setRbmRemarks(_tmpRbmRemarks);
        final String _tmpSalesDivisionId;
        if (_cursor.isNull(_cursorIndexOfSalesDivisionId)) {
          _tmpSalesDivisionId = null;
        } else {
          _tmpSalesDivisionId = _cursor.getString(_cursorIndexOfSalesDivisionId);
        }
        _item.setSalesDivisionId(_tmpSalesDivisionId);
        final String _tmpSalesDivisionName;
        if (_cursor.isNull(_cursorIndexOfSalesDivisionName)) {
          _tmpSalesDivisionName = null;
        } else {
          _tmpSalesDivisionName = _cursor.getString(_cursorIndexOfSalesDivisionName);
        }
        _item.setSalesDivisionName(_tmpSalesDivisionName);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
