package com.agriscience.salesindent.room_database.dao;

import android.database.Cursor;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.agriscience.salesindent.room_database.entity.STOIndentTmpEntity;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@SuppressWarnings({"unchecked", "deprecation"})
public final class STOIndentTmpDao_Impl implements STOIndentTmpDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<STOIndentTmpEntity> __insertionAdapterOfSTOIndentTmpEntity;

  private final SharedSQLiteStatement __preparedStmtOfDeleteAllSTOIndentTmpDetails;

  public STOIndentTmpDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfSTOIndentTmpEntity = new EntityInsertionAdapter<STOIndentTmpEntity>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `STOIndentTmpEntity` (`STO_indent_no`,`indent_date`,`Indent_time`,`Sending_plant`,`Receiving_plant`,`Line_no`,`Division`,`Crop_name`,`Crop_code`,`Variety_code`,`Variety_name`,`Material_code`,`Material_description`,`Final_status`,`Final_quantity`,`final_item_weight`,`final_no_of_pac`,`Req_date`,`Sales_region`,`sales_region_name`,`RBM`,`rbm_name`,`rbm_qty`,`Rbm_item_weight`,`Rbm_no_of_pac`,`rbm_remarks`,`sales_division`,`sales_division_name`,`dbm`,`dbm_name`,`dbm_remarks`,`dbm_qty`,`dbm_item_weight`,`dbm_no_of_pac`,`packingQuantity`,`baseUom`,`dbm_approval_status`,`dbm_approval_date`,`dbm_approval_time`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, STOIndentTmpEntity value) {
        if (value.getSTO_indent_no() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getSTO_indent_no());
        }
        if (value.getIndent_date() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getIndent_date());
        }
        if (value.getIndent_time() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getIndent_time());
        }
        if (value.getSending_plant() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getSending_plant());
        }
        if (value.getReceiving_plant() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getReceiving_plant());
        }
        if (value.getLine_no() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getLine_no());
        }
        if (value.getDivision() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getDivision());
        }
        if (value.getCrop_name() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getCrop_name());
        }
        if (value.getCrop_code() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, value.getCrop_code());
        }
        if (value.getVariety_code() == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindString(10, value.getVariety_code());
        }
        if (value.getVariety_name() == null) {
          stmt.bindNull(11);
        } else {
          stmt.bindString(11, value.getVariety_name());
        }
        if (value.getMaterial_code() == null) {
          stmt.bindNull(12);
        } else {
          stmt.bindString(12, value.getMaterial_code());
        }
        if (value.getMaterial_description() == null) {
          stmt.bindNull(13);
        } else {
          stmt.bindString(13, value.getMaterial_description());
        }
        if (value.getFinal_status() == null) {
          stmt.bindNull(14);
        } else {
          stmt.bindString(14, value.getFinal_status());
        }
        if (value.getFinal_quantity() == null) {
          stmt.bindNull(15);
        } else {
          stmt.bindString(15, value.getFinal_quantity());
        }
        if (value.getFinal_item_weight() == null) {
          stmt.bindNull(16);
        } else {
          stmt.bindString(16, value.getFinal_item_weight());
        }
        if (value.getFinal_no_of_pac() == null) {
          stmt.bindNull(17);
        } else {
          stmt.bindString(17, value.getFinal_no_of_pac());
        }
        if (value.getReq_date() == null) {
          stmt.bindNull(18);
        } else {
          stmt.bindString(18, value.getReq_date());
        }
        if (value.getSales_region() == null) {
          stmt.bindNull(19);
        } else {
          stmt.bindString(19, value.getSales_region());
        }
        if (value.getSales_region_name() == null) {
          stmt.bindNull(20);
        } else {
          stmt.bindString(20, value.getSales_region_name());
        }
        if (value.getRBM() == null) {
          stmt.bindNull(21);
        } else {
          stmt.bindString(21, value.getRBM());
        }
        if (value.getRbm_name() == null) {
          stmt.bindNull(22);
        } else {
          stmt.bindString(22, value.getRbm_name());
        }
        if (value.getRbm_qty() == null) {
          stmt.bindNull(23);
        } else {
          stmt.bindString(23, value.getRbm_qty());
        }
        if (value.getRbm_item_weight() == null) {
          stmt.bindNull(24);
        } else {
          stmt.bindString(24, value.getRbm_item_weight());
        }
        if (value.getRbm_no_of_pac() == null) {
          stmt.bindNull(25);
        } else {
          stmt.bindString(25, value.getRbm_no_of_pac());
        }
        if (value.getRbm_remarks() == null) {
          stmt.bindNull(26);
        } else {
          stmt.bindString(26, value.getRbm_remarks());
        }
        if (value.getSales_division() == null) {
          stmt.bindNull(27);
        } else {
          stmt.bindString(27, value.getSales_division());
        }
        if (value.getSales_division_name() == null) {
          stmt.bindNull(28);
        } else {
          stmt.bindString(28, value.getSales_division_name());
        }
        if (value.getDbm() == null) {
          stmt.bindNull(29);
        } else {
          stmt.bindString(29, value.getDbm());
        }
        if (value.getDbm_name() == null) {
          stmt.bindNull(30);
        } else {
          stmt.bindString(30, value.getDbm_name());
        }
        if (value.getDbm_remarks() == null) {
          stmt.bindNull(31);
        } else {
          stmt.bindString(31, value.getDbm_remarks());
        }
        if (value.getDbm_qty() == null) {
          stmt.bindNull(32);
        } else {
          stmt.bindString(32, value.getDbm_qty());
        }
        if (value.getDbm_item_weight() == null) {
          stmt.bindNull(33);
        } else {
          stmt.bindString(33, value.getDbm_item_weight());
        }
        if (value.getDbm_no_of_pac() == null) {
          stmt.bindNull(34);
        } else {
          stmt.bindString(34, value.getDbm_no_of_pac());
        }
        if (value.getPackingQuantity() == null) {
          stmt.bindNull(35);
        } else {
          stmt.bindString(35, value.getPackingQuantity());
        }
        if (value.getBaseUom() == null) {
          stmt.bindNull(36);
        } else {
          stmt.bindString(36, value.getBaseUom());
        }
        if (value.getDbm_approval_status() == null) {
          stmt.bindNull(37);
        } else {
          stmt.bindString(37, value.getDbm_approval_status());
        }
        if (value.getDbm_approval_date() == null) {
          stmt.bindNull(38);
        } else {
          stmt.bindString(38, value.getDbm_approval_date());
        }
        if (value.getDbm_approval_time() == null) {
          stmt.bindNull(39);
        } else {
          stmt.bindString(39, value.getDbm_approval_time());
        }
      }
    };
    this.__preparedStmtOfDeleteAllSTOIndentTmpDetails = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "Delete from STOIndentTmpEntity";
        return _query;
      }
    };
  }

  @Override
  public void insertAll(final STOIndentTmpEntity... stoIndentTmpEntities) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfSTOIndentTmpEntity.insert(stoIndentTmpEntities);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void deleteAllSTOIndentTmpDetails() {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteAllSTOIndentTmpDetails.acquire();
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfDeleteAllSTOIndentTmpDetails.release(_stmt);
    }
  }

  @Override
  public List<STOIndentTmpEntity> getAllSTOIndentTmp() {
    final String _sql = "Select * from STOIndentTmpEntity";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfSTOIndentNo = CursorUtil.getColumnIndexOrThrow(_cursor, "STO_indent_no");
      final int _cursorIndexOfIndentDate = CursorUtil.getColumnIndexOrThrow(_cursor, "indent_date");
      final int _cursorIndexOfIndentTime = CursorUtil.getColumnIndexOrThrow(_cursor, "Indent_time");
      final int _cursorIndexOfSendingPlant = CursorUtil.getColumnIndexOrThrow(_cursor, "Sending_plant");
      final int _cursorIndexOfReceivingPlant = CursorUtil.getColumnIndexOrThrow(_cursor, "Receiving_plant");
      final int _cursorIndexOfLineNo = CursorUtil.getColumnIndexOrThrow(_cursor, "Line_no");
      final int _cursorIndexOfDivision = CursorUtil.getColumnIndexOrThrow(_cursor, "Division");
      final int _cursorIndexOfCropName = CursorUtil.getColumnIndexOrThrow(_cursor, "Crop_name");
      final int _cursorIndexOfCropCode = CursorUtil.getColumnIndexOrThrow(_cursor, "Crop_code");
      final int _cursorIndexOfVarietyCode = CursorUtil.getColumnIndexOrThrow(_cursor, "Variety_code");
      final int _cursorIndexOfVarietyName = CursorUtil.getColumnIndexOrThrow(_cursor, "Variety_name");
      final int _cursorIndexOfMaterialCode = CursorUtil.getColumnIndexOrThrow(_cursor, "Material_code");
      final int _cursorIndexOfMaterialDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "Material_description");
      final int _cursorIndexOfFinalStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "Final_status");
      final int _cursorIndexOfFinalQuantity = CursorUtil.getColumnIndexOrThrow(_cursor, "Final_quantity");
      final int _cursorIndexOfFinalItemWeight = CursorUtil.getColumnIndexOrThrow(_cursor, "final_item_weight");
      final int _cursorIndexOfFinalNoOfPac = CursorUtil.getColumnIndexOrThrow(_cursor, "final_no_of_pac");
      final int _cursorIndexOfReqDate = CursorUtil.getColumnIndexOrThrow(_cursor, "Req_date");
      final int _cursorIndexOfSalesRegion = CursorUtil.getColumnIndexOrThrow(_cursor, "Sales_region");
      final int _cursorIndexOfSalesRegionName = CursorUtil.getColumnIndexOrThrow(_cursor, "sales_region_name");
      final int _cursorIndexOfRBM = CursorUtil.getColumnIndexOrThrow(_cursor, "RBM");
      final int _cursorIndexOfRbmName = CursorUtil.getColumnIndexOrThrow(_cursor, "rbm_name");
      final int _cursorIndexOfRbmQty = CursorUtil.getColumnIndexOrThrow(_cursor, "rbm_qty");
      final int _cursorIndexOfRbmItemWeight = CursorUtil.getColumnIndexOrThrow(_cursor, "Rbm_item_weight");
      final int _cursorIndexOfRbmNoOfPac = CursorUtil.getColumnIndexOrThrow(_cursor, "Rbm_no_of_pac");
      final int _cursorIndexOfRbmRemarks = CursorUtil.getColumnIndexOrThrow(_cursor, "rbm_remarks");
      final int _cursorIndexOfSalesDivision = CursorUtil.getColumnIndexOrThrow(_cursor, "sales_division");
      final int _cursorIndexOfSalesDivisionName = CursorUtil.getColumnIndexOrThrow(_cursor, "sales_division_name");
      final int _cursorIndexOfDbm = CursorUtil.getColumnIndexOrThrow(_cursor, "dbm");
      final int _cursorIndexOfDbmName = CursorUtil.getColumnIndexOrThrow(_cursor, "dbm_name");
      final int _cursorIndexOfDbmRemarks = CursorUtil.getColumnIndexOrThrow(_cursor, "dbm_remarks");
      final int _cursorIndexOfDbmQty = CursorUtil.getColumnIndexOrThrow(_cursor, "dbm_qty");
      final int _cursorIndexOfDbmItemWeight = CursorUtil.getColumnIndexOrThrow(_cursor, "dbm_item_weight");
      final int _cursorIndexOfDbmNoOfPac = CursorUtil.getColumnIndexOrThrow(_cursor, "dbm_no_of_pac");
      final int _cursorIndexOfPackingQuantity = CursorUtil.getColumnIndexOrThrow(_cursor, "packingQuantity");
      final int _cursorIndexOfBaseUom = CursorUtil.getColumnIndexOrThrow(_cursor, "baseUom");
      final int _cursorIndexOfDbmApprovalStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "dbm_approval_status");
      final int _cursorIndexOfDbmApprovalDate = CursorUtil.getColumnIndexOrThrow(_cursor, "dbm_approval_date");
      final int _cursorIndexOfDbmApprovalTime = CursorUtil.getColumnIndexOrThrow(_cursor, "dbm_approval_time");
      final List<STOIndentTmpEntity> _result = new ArrayList<STOIndentTmpEntity>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final STOIndentTmpEntity _item;
        _item = new STOIndentTmpEntity();
        final String _tmpSTO_indent_no;
        if (_cursor.isNull(_cursorIndexOfSTOIndentNo)) {
          _tmpSTO_indent_no = null;
        } else {
          _tmpSTO_indent_no = _cursor.getString(_cursorIndexOfSTOIndentNo);
        }
        _item.setSTO_indent_no(_tmpSTO_indent_no);
        final String _tmpIndent_date;
        if (_cursor.isNull(_cursorIndexOfIndentDate)) {
          _tmpIndent_date = null;
        } else {
          _tmpIndent_date = _cursor.getString(_cursorIndexOfIndentDate);
        }
        _item.setIndent_date(_tmpIndent_date);
        final String _tmpIndent_time;
        if (_cursor.isNull(_cursorIndexOfIndentTime)) {
          _tmpIndent_time = null;
        } else {
          _tmpIndent_time = _cursor.getString(_cursorIndexOfIndentTime);
        }
        _item.setIndent_time(_tmpIndent_time);
        final String _tmpSending_plant;
        if (_cursor.isNull(_cursorIndexOfSendingPlant)) {
          _tmpSending_plant = null;
        } else {
          _tmpSending_plant = _cursor.getString(_cursorIndexOfSendingPlant);
        }
        _item.setSending_plant(_tmpSending_plant);
        final String _tmpReceiving_plant;
        if (_cursor.isNull(_cursorIndexOfReceivingPlant)) {
          _tmpReceiving_plant = null;
        } else {
          _tmpReceiving_plant = _cursor.getString(_cursorIndexOfReceivingPlant);
        }
        _item.setReceiving_plant(_tmpReceiving_plant);
        final String _tmpLine_no;
        if (_cursor.isNull(_cursorIndexOfLineNo)) {
          _tmpLine_no = null;
        } else {
          _tmpLine_no = _cursor.getString(_cursorIndexOfLineNo);
        }
        _item.setLine_no(_tmpLine_no);
        final String _tmpDivision;
        if (_cursor.isNull(_cursorIndexOfDivision)) {
          _tmpDivision = null;
        } else {
          _tmpDivision = _cursor.getString(_cursorIndexOfDivision);
        }
        _item.setDivision(_tmpDivision);
        final String _tmpCrop_name;
        if (_cursor.isNull(_cursorIndexOfCropName)) {
          _tmpCrop_name = null;
        } else {
          _tmpCrop_name = _cursor.getString(_cursorIndexOfCropName);
        }
        _item.setCrop_name(_tmpCrop_name);
        final String _tmpCrop_code;
        if (_cursor.isNull(_cursorIndexOfCropCode)) {
          _tmpCrop_code = null;
        } else {
          _tmpCrop_code = _cursor.getString(_cursorIndexOfCropCode);
        }
        _item.setCrop_code(_tmpCrop_code);
        final String _tmpVariety_code;
        if (_cursor.isNull(_cursorIndexOfVarietyCode)) {
          _tmpVariety_code = null;
        } else {
          _tmpVariety_code = _cursor.getString(_cursorIndexOfVarietyCode);
        }
        _item.setVariety_code(_tmpVariety_code);
        final String _tmpVariety_name;
        if (_cursor.isNull(_cursorIndexOfVarietyName)) {
          _tmpVariety_name = null;
        } else {
          _tmpVariety_name = _cursor.getString(_cursorIndexOfVarietyName);
        }
        _item.setVariety_name(_tmpVariety_name);
        final String _tmpMaterial_code;
        if (_cursor.isNull(_cursorIndexOfMaterialCode)) {
          _tmpMaterial_code = null;
        } else {
          _tmpMaterial_code = _cursor.getString(_cursorIndexOfMaterialCode);
        }
        _item.setMaterial_code(_tmpMaterial_code);
        final String _tmpMaterial_description;
        if (_cursor.isNull(_cursorIndexOfMaterialDescription)) {
          _tmpMaterial_description = null;
        } else {
          _tmpMaterial_description = _cursor.getString(_cursorIndexOfMaterialDescription);
        }
        _item.setMaterial_description(_tmpMaterial_description);
        final String _tmpFinal_status;
        if (_cursor.isNull(_cursorIndexOfFinalStatus)) {
          _tmpFinal_status = null;
        } else {
          _tmpFinal_status = _cursor.getString(_cursorIndexOfFinalStatus);
        }
        _item.setFinal_status(_tmpFinal_status);
        final String _tmpFinal_quantity;
        if (_cursor.isNull(_cursorIndexOfFinalQuantity)) {
          _tmpFinal_quantity = null;
        } else {
          _tmpFinal_quantity = _cursor.getString(_cursorIndexOfFinalQuantity);
        }
        _item.setFinal_quantity(_tmpFinal_quantity);
        final String _tmpFinal_item_weight;
        if (_cursor.isNull(_cursorIndexOfFinalItemWeight)) {
          _tmpFinal_item_weight = null;
        } else {
          _tmpFinal_item_weight = _cursor.getString(_cursorIndexOfFinalItemWeight);
        }
        _item.setFinal_item_weight(_tmpFinal_item_weight);
        final String _tmpFinal_no_of_pac;
        if (_cursor.isNull(_cursorIndexOfFinalNoOfPac)) {
          _tmpFinal_no_of_pac = null;
        } else {
          _tmpFinal_no_of_pac = _cursor.getString(_cursorIndexOfFinalNoOfPac);
        }
        _item.setFinal_no_of_pac(_tmpFinal_no_of_pac);
        final String _tmpReq_date;
        if (_cursor.isNull(_cursorIndexOfReqDate)) {
          _tmpReq_date = null;
        } else {
          _tmpReq_date = _cursor.getString(_cursorIndexOfReqDate);
        }
        _item.setReq_date(_tmpReq_date);
        final String _tmpSales_region;
        if (_cursor.isNull(_cursorIndexOfSalesRegion)) {
          _tmpSales_region = null;
        } else {
          _tmpSales_region = _cursor.getString(_cursorIndexOfSalesRegion);
        }
        _item.setSales_region(_tmpSales_region);
        final String _tmpSales_region_name;
        if (_cursor.isNull(_cursorIndexOfSalesRegionName)) {
          _tmpSales_region_name = null;
        } else {
          _tmpSales_region_name = _cursor.getString(_cursorIndexOfSalesRegionName);
        }
        _item.setSales_region_name(_tmpSales_region_name);
        final String _tmpRBM;
        if (_cursor.isNull(_cursorIndexOfRBM)) {
          _tmpRBM = null;
        } else {
          _tmpRBM = _cursor.getString(_cursorIndexOfRBM);
        }
        _item.setRBM(_tmpRBM);
        final String _tmpRbm_name;
        if (_cursor.isNull(_cursorIndexOfRbmName)) {
          _tmpRbm_name = null;
        } else {
          _tmpRbm_name = _cursor.getString(_cursorIndexOfRbmName);
        }
        _item.setRbm_name(_tmpRbm_name);
        final String _tmpRbm_qty;
        if (_cursor.isNull(_cursorIndexOfRbmQty)) {
          _tmpRbm_qty = null;
        } else {
          _tmpRbm_qty = _cursor.getString(_cursorIndexOfRbmQty);
        }
        _item.setRbm_qty(_tmpRbm_qty);
        final String _tmpRbm_item_weight;
        if (_cursor.isNull(_cursorIndexOfRbmItemWeight)) {
          _tmpRbm_item_weight = null;
        } else {
          _tmpRbm_item_weight = _cursor.getString(_cursorIndexOfRbmItemWeight);
        }
        _item.setRbm_item_weight(_tmpRbm_item_weight);
        final String _tmpRbm_no_of_pac;
        if (_cursor.isNull(_cursorIndexOfRbmNoOfPac)) {
          _tmpRbm_no_of_pac = null;
        } else {
          _tmpRbm_no_of_pac = _cursor.getString(_cursorIndexOfRbmNoOfPac);
        }
        _item.setRbm_no_of_pac(_tmpRbm_no_of_pac);
        final String _tmpRbm_remarks;
        if (_cursor.isNull(_cursorIndexOfRbmRemarks)) {
          _tmpRbm_remarks = null;
        } else {
          _tmpRbm_remarks = _cursor.getString(_cursorIndexOfRbmRemarks);
        }
        _item.setRbm_remarks(_tmpRbm_remarks);
        final String _tmpSales_division;
        if (_cursor.isNull(_cursorIndexOfSalesDivision)) {
          _tmpSales_division = null;
        } else {
          _tmpSales_division = _cursor.getString(_cursorIndexOfSalesDivision);
        }
        _item.setSales_division(_tmpSales_division);
        final String _tmpSales_division_name;
        if (_cursor.isNull(_cursorIndexOfSalesDivisionName)) {
          _tmpSales_division_name = null;
        } else {
          _tmpSales_division_name = _cursor.getString(_cursorIndexOfSalesDivisionName);
        }
        _item.setSales_division_name(_tmpSales_division_name);
        final String _tmpDbm;
        if (_cursor.isNull(_cursorIndexOfDbm)) {
          _tmpDbm = null;
        } else {
          _tmpDbm = _cursor.getString(_cursorIndexOfDbm);
        }
        _item.setDbm(_tmpDbm);
        final String _tmpDbm_name;
        if (_cursor.isNull(_cursorIndexOfDbmName)) {
          _tmpDbm_name = null;
        } else {
          _tmpDbm_name = _cursor.getString(_cursorIndexOfDbmName);
        }
        _item.setDbm_name(_tmpDbm_name);
        final String _tmpDbm_remarks;
        if (_cursor.isNull(_cursorIndexOfDbmRemarks)) {
          _tmpDbm_remarks = null;
        } else {
          _tmpDbm_remarks = _cursor.getString(_cursorIndexOfDbmRemarks);
        }
        _item.setDbm_remarks(_tmpDbm_remarks);
        final String _tmpDbm_qty;
        if (_cursor.isNull(_cursorIndexOfDbmQty)) {
          _tmpDbm_qty = null;
        } else {
          _tmpDbm_qty = _cursor.getString(_cursorIndexOfDbmQty);
        }
        _item.setDbm_qty(_tmpDbm_qty);
        final String _tmpDbm_item_weight;
        if (_cursor.isNull(_cursorIndexOfDbmItemWeight)) {
          _tmpDbm_item_weight = null;
        } else {
          _tmpDbm_item_weight = _cursor.getString(_cursorIndexOfDbmItemWeight);
        }
        _item.setDbm_item_weight(_tmpDbm_item_weight);
        final String _tmpDbm_no_of_pac;
        if (_cursor.isNull(_cursorIndexOfDbmNoOfPac)) {
          _tmpDbm_no_of_pac = null;
        } else {
          _tmpDbm_no_of_pac = _cursor.getString(_cursorIndexOfDbmNoOfPac);
        }
        _item.setDbm_no_of_pac(_tmpDbm_no_of_pac);
        final String _tmpPackingQuantity;
        if (_cursor.isNull(_cursorIndexOfPackingQuantity)) {
          _tmpPackingQuantity = null;
        } else {
          _tmpPackingQuantity = _cursor.getString(_cursorIndexOfPackingQuantity);
        }
        _item.setPackingQuantity(_tmpPackingQuantity);
        final String _tmpBaseUom;
        if (_cursor.isNull(_cursorIndexOfBaseUom)) {
          _tmpBaseUom = null;
        } else {
          _tmpBaseUom = _cursor.getString(_cursorIndexOfBaseUom);
        }
        _item.setBaseUom(_tmpBaseUom);
        final String _tmpDbm_approval_status;
        if (_cursor.isNull(_cursorIndexOfDbmApprovalStatus)) {
          _tmpDbm_approval_status = null;
        } else {
          _tmpDbm_approval_status = _cursor.getString(_cursorIndexOfDbmApprovalStatus);
        }
        _item.setDbm_approval_status(_tmpDbm_approval_status);
        final String _tmpDbm_approval_date;
        if (_cursor.isNull(_cursorIndexOfDbmApprovalDate)) {
          _tmpDbm_approval_date = null;
        } else {
          _tmpDbm_approval_date = _cursor.getString(_cursorIndexOfDbmApprovalDate);
        }
        _item.setDbm_approval_date(_tmpDbm_approval_date);
        final String _tmpDbm_approval_time;
        if (_cursor.isNull(_cursorIndexOfDbmApprovalTime)) {
          _tmpDbm_approval_time = null;
        } else {
          _tmpDbm_approval_time = _cursor.getString(_cursorIndexOfDbmApprovalTime);
        }
        _item.setDbm_approval_time(_tmpDbm_approval_time);
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
