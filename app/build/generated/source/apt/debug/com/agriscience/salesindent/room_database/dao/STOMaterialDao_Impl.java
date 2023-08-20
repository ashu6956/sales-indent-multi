package com.agriscience.salesindent.room_database.dao;

import android.database.Cursor;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.agriscience.salesindent.model.STOMaterialDetailsResponse;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@SuppressWarnings({"unchecked", "deprecation"})
public final class STOMaterialDao_Impl implements STOMaterialDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<STOMaterialDetailsResponse> __insertionAdapterOfSTOMaterialDetailsResponse;

  private final SharedSQLiteStatement __preparedStmtOfDeleteMaterialDetailsByMaterialName;

  private final SharedSQLiteStatement __preparedStmtOfDeleteAllMaterialDetails;

  public STOMaterialDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfSTOMaterialDetailsResponse = new EntityInsertionAdapter<STOMaterialDetailsResponse>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `sto_material` (`id`,`varietyName`,`cropCode`,`cropName`,`varietyCode`,`packingQuantity`,`baseUom`,`message`,`materialName`,`status`,`materialCode`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, STOMaterialDetailsResponse value) {
        stmt.bindLong(1, value.getId());
        if (value.getVarietyName() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getVarietyName());
        }
        if (value.getCropCode() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getCropCode());
        }
        if (value.getCropName() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getCropName());
        }
        if (value.getVarietyCode() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getVarietyCode());
        }
        if (value.getPackingQuantity() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getPackingQuantity());
        }
        if (value.getBaseUom() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getBaseUom());
        }
        if (value.getMessage() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getMessage());
        }
        if (value.getMaterialName() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, value.getMaterialName());
        }
        if (value.getStatus() == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindString(10, value.getStatus());
        }
        if (value.getMaterialCode() == null) {
          stmt.bindNull(11);
        } else {
          stmt.bindString(11, value.getMaterialCode());
        }
      }
    };
    this.__preparedStmtOfDeleteMaterialDetailsByMaterialName = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "Delete from sto_material where materialName = ?";
        return _query;
      }
    };
    this.__preparedStmtOfDeleteAllMaterialDetails = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "Delete from sto_material";
        return _query;
      }
    };
  }

  @Override
  public void insertAll(final STOMaterialDetailsResponse... materialDetailsResponses) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfSTOMaterialDetailsResponse.insert(materialDetailsResponses);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void deleteMaterialDetailsByMaterialName(final String materialName) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteMaterialDetailsByMaterialName.acquire();
    int _argIndex = 1;
    if (materialName == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, materialName);
    }
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfDeleteMaterialDetailsByMaterialName.release(_stmt);
    }
  }

  @Override
  public void deleteAllMaterialDetails() {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteAllMaterialDetails.acquire();
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfDeleteAllMaterialDetails.release(_stmt);
    }
  }

  @Override
  public List<STOMaterialDetailsResponse> getAllSTOMaterialDetails() {
    final String _sql = "Select * from sto_material";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfVarietyName = CursorUtil.getColumnIndexOrThrow(_cursor, "varietyName");
      final int _cursorIndexOfCropCode = CursorUtil.getColumnIndexOrThrow(_cursor, "cropCode");
      final int _cursorIndexOfCropName = CursorUtil.getColumnIndexOrThrow(_cursor, "cropName");
      final int _cursorIndexOfVarietyCode = CursorUtil.getColumnIndexOrThrow(_cursor, "varietyCode");
      final int _cursorIndexOfPackingQuantity = CursorUtil.getColumnIndexOrThrow(_cursor, "packingQuantity");
      final int _cursorIndexOfBaseUom = CursorUtil.getColumnIndexOrThrow(_cursor, "baseUom");
      final int _cursorIndexOfMessage = CursorUtil.getColumnIndexOrThrow(_cursor, "message");
      final int _cursorIndexOfMaterialName = CursorUtil.getColumnIndexOrThrow(_cursor, "materialName");
      final int _cursorIndexOfStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "status");
      final int _cursorIndexOfMaterialCode = CursorUtil.getColumnIndexOrThrow(_cursor, "materialCode");
      final List<STOMaterialDetailsResponse> _result = new ArrayList<STOMaterialDetailsResponse>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final STOMaterialDetailsResponse _item;
        _item = new STOMaterialDetailsResponse();
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        _item.setId(_tmpId);
        final String _tmpVarietyName;
        if (_cursor.isNull(_cursorIndexOfVarietyName)) {
          _tmpVarietyName = null;
        } else {
          _tmpVarietyName = _cursor.getString(_cursorIndexOfVarietyName);
        }
        _item.setVarietyName(_tmpVarietyName);
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
        final String _tmpVarietyCode;
        if (_cursor.isNull(_cursorIndexOfVarietyCode)) {
          _tmpVarietyCode = null;
        } else {
          _tmpVarietyCode = _cursor.getString(_cursorIndexOfVarietyCode);
        }
        _item.setVarietyCode(_tmpVarietyCode);
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
        final String _tmpMessage;
        if (_cursor.isNull(_cursorIndexOfMessage)) {
          _tmpMessage = null;
        } else {
          _tmpMessage = _cursor.getString(_cursorIndexOfMessage);
        }
        _item.setMessage(_tmpMessage);
        final String _tmpMaterialName;
        if (_cursor.isNull(_cursorIndexOfMaterialName)) {
          _tmpMaterialName = null;
        } else {
          _tmpMaterialName = _cursor.getString(_cursorIndexOfMaterialName);
        }
        _item.setMaterialName(_tmpMaterialName);
        final String _tmpStatus;
        if (_cursor.isNull(_cursorIndexOfStatus)) {
          _tmpStatus = null;
        } else {
          _tmpStatus = _cursor.getString(_cursorIndexOfStatus);
        }
        _item.setStatus(_tmpStatus);
        final String _tmpMaterialCode;
        if (_cursor.isNull(_cursorIndexOfMaterialCode)) {
          _tmpMaterialCode = null;
        } else {
          _tmpMaterialCode = _cursor.getString(_cursorIndexOfMaterialCode);
        }
        _item.setMaterialCode(_tmpMaterialCode);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<STOMaterialDetailsResponse> getAllVarietyDetailsByCropName(final String cropName) {
    final String _sql = "Select * from sto_material where cropName=?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (cropName == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, cropName);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfVarietyName = CursorUtil.getColumnIndexOrThrow(_cursor, "varietyName");
      final int _cursorIndexOfCropCode = CursorUtil.getColumnIndexOrThrow(_cursor, "cropCode");
      final int _cursorIndexOfCropName = CursorUtil.getColumnIndexOrThrow(_cursor, "cropName");
      final int _cursorIndexOfVarietyCode = CursorUtil.getColumnIndexOrThrow(_cursor, "varietyCode");
      final int _cursorIndexOfPackingQuantity = CursorUtil.getColumnIndexOrThrow(_cursor, "packingQuantity");
      final int _cursorIndexOfBaseUom = CursorUtil.getColumnIndexOrThrow(_cursor, "baseUom");
      final int _cursorIndexOfMessage = CursorUtil.getColumnIndexOrThrow(_cursor, "message");
      final int _cursorIndexOfMaterialName = CursorUtil.getColumnIndexOrThrow(_cursor, "materialName");
      final int _cursorIndexOfStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "status");
      final int _cursorIndexOfMaterialCode = CursorUtil.getColumnIndexOrThrow(_cursor, "materialCode");
      final List<STOMaterialDetailsResponse> _result = new ArrayList<STOMaterialDetailsResponse>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final STOMaterialDetailsResponse _item;
        _item = new STOMaterialDetailsResponse();
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        _item.setId(_tmpId);
        final String _tmpVarietyName;
        if (_cursor.isNull(_cursorIndexOfVarietyName)) {
          _tmpVarietyName = null;
        } else {
          _tmpVarietyName = _cursor.getString(_cursorIndexOfVarietyName);
        }
        _item.setVarietyName(_tmpVarietyName);
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
        final String _tmpVarietyCode;
        if (_cursor.isNull(_cursorIndexOfVarietyCode)) {
          _tmpVarietyCode = null;
        } else {
          _tmpVarietyCode = _cursor.getString(_cursorIndexOfVarietyCode);
        }
        _item.setVarietyCode(_tmpVarietyCode);
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
        final String _tmpMessage;
        if (_cursor.isNull(_cursorIndexOfMessage)) {
          _tmpMessage = null;
        } else {
          _tmpMessage = _cursor.getString(_cursorIndexOfMessage);
        }
        _item.setMessage(_tmpMessage);
        final String _tmpMaterialName;
        if (_cursor.isNull(_cursorIndexOfMaterialName)) {
          _tmpMaterialName = null;
        } else {
          _tmpMaterialName = _cursor.getString(_cursorIndexOfMaterialName);
        }
        _item.setMaterialName(_tmpMaterialName);
        final String _tmpStatus;
        if (_cursor.isNull(_cursorIndexOfStatus)) {
          _tmpStatus = null;
        } else {
          _tmpStatus = _cursor.getString(_cursorIndexOfStatus);
        }
        _item.setStatus(_tmpStatus);
        final String _tmpMaterialCode;
        if (_cursor.isNull(_cursorIndexOfMaterialCode)) {
          _tmpMaterialCode = null;
        } else {
          _tmpMaterialCode = _cursor.getString(_cursorIndexOfMaterialCode);
        }
        _item.setMaterialCode(_tmpMaterialCode);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<STOMaterialDetailsResponse> getAllItemNameDetails(final String cropName,
      final String varietyName) {
    final String _sql = "Select * from sto_material where cropName=? and varietyName=?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    if (cropName == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, cropName);
    }
    _argIndex = 2;
    if (varietyName == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, varietyName);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfVarietyName = CursorUtil.getColumnIndexOrThrow(_cursor, "varietyName");
      final int _cursorIndexOfCropCode = CursorUtil.getColumnIndexOrThrow(_cursor, "cropCode");
      final int _cursorIndexOfCropName = CursorUtil.getColumnIndexOrThrow(_cursor, "cropName");
      final int _cursorIndexOfVarietyCode = CursorUtil.getColumnIndexOrThrow(_cursor, "varietyCode");
      final int _cursorIndexOfPackingQuantity = CursorUtil.getColumnIndexOrThrow(_cursor, "packingQuantity");
      final int _cursorIndexOfBaseUom = CursorUtil.getColumnIndexOrThrow(_cursor, "baseUom");
      final int _cursorIndexOfMessage = CursorUtil.getColumnIndexOrThrow(_cursor, "message");
      final int _cursorIndexOfMaterialName = CursorUtil.getColumnIndexOrThrow(_cursor, "materialName");
      final int _cursorIndexOfStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "status");
      final int _cursorIndexOfMaterialCode = CursorUtil.getColumnIndexOrThrow(_cursor, "materialCode");
      final List<STOMaterialDetailsResponse> _result = new ArrayList<STOMaterialDetailsResponse>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final STOMaterialDetailsResponse _item;
        _item = new STOMaterialDetailsResponse();
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        _item.setId(_tmpId);
        final String _tmpVarietyName;
        if (_cursor.isNull(_cursorIndexOfVarietyName)) {
          _tmpVarietyName = null;
        } else {
          _tmpVarietyName = _cursor.getString(_cursorIndexOfVarietyName);
        }
        _item.setVarietyName(_tmpVarietyName);
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
        final String _tmpVarietyCode;
        if (_cursor.isNull(_cursorIndexOfVarietyCode)) {
          _tmpVarietyCode = null;
        } else {
          _tmpVarietyCode = _cursor.getString(_cursorIndexOfVarietyCode);
        }
        _item.setVarietyCode(_tmpVarietyCode);
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
        final String _tmpMessage;
        if (_cursor.isNull(_cursorIndexOfMessage)) {
          _tmpMessage = null;
        } else {
          _tmpMessage = _cursor.getString(_cursorIndexOfMessage);
        }
        _item.setMessage(_tmpMessage);
        final String _tmpMaterialName;
        if (_cursor.isNull(_cursorIndexOfMaterialName)) {
          _tmpMaterialName = null;
        } else {
          _tmpMaterialName = _cursor.getString(_cursorIndexOfMaterialName);
        }
        _item.setMaterialName(_tmpMaterialName);
        final String _tmpStatus;
        if (_cursor.isNull(_cursorIndexOfStatus)) {
          _tmpStatus = null;
        } else {
          _tmpStatus = _cursor.getString(_cursorIndexOfStatus);
        }
        _item.setStatus(_tmpStatus);
        final String _tmpMaterialCode;
        if (_cursor.isNull(_cursorIndexOfMaterialCode)) {
          _tmpMaterialCode = null;
        } else {
          _tmpMaterialCode = _cursor.getString(_cursorIndexOfMaterialCode);
        }
        _item.setMaterialCode(_tmpMaterialCode);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public STOMaterialDetailsResponse getMaterialEntityDetails(final String materialName) {
    final String _sql = "Select * from sto_material where materialName =?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (materialName == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, materialName);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfVarietyName = CursorUtil.getColumnIndexOrThrow(_cursor, "varietyName");
      final int _cursorIndexOfCropCode = CursorUtil.getColumnIndexOrThrow(_cursor, "cropCode");
      final int _cursorIndexOfCropName = CursorUtil.getColumnIndexOrThrow(_cursor, "cropName");
      final int _cursorIndexOfVarietyCode = CursorUtil.getColumnIndexOrThrow(_cursor, "varietyCode");
      final int _cursorIndexOfPackingQuantity = CursorUtil.getColumnIndexOrThrow(_cursor, "packingQuantity");
      final int _cursorIndexOfBaseUom = CursorUtil.getColumnIndexOrThrow(_cursor, "baseUom");
      final int _cursorIndexOfMessage = CursorUtil.getColumnIndexOrThrow(_cursor, "message");
      final int _cursorIndexOfMaterialName = CursorUtil.getColumnIndexOrThrow(_cursor, "materialName");
      final int _cursorIndexOfStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "status");
      final int _cursorIndexOfMaterialCode = CursorUtil.getColumnIndexOrThrow(_cursor, "materialCode");
      final STOMaterialDetailsResponse _result;
      if(_cursor.moveToFirst()) {
        _result = new STOMaterialDetailsResponse();
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        _result.setId(_tmpId);
        final String _tmpVarietyName;
        if (_cursor.isNull(_cursorIndexOfVarietyName)) {
          _tmpVarietyName = null;
        } else {
          _tmpVarietyName = _cursor.getString(_cursorIndexOfVarietyName);
        }
        _result.setVarietyName(_tmpVarietyName);
        final String _tmpCropCode;
        if (_cursor.isNull(_cursorIndexOfCropCode)) {
          _tmpCropCode = null;
        } else {
          _tmpCropCode = _cursor.getString(_cursorIndexOfCropCode);
        }
        _result.setCropCode(_tmpCropCode);
        final String _tmpCropName;
        if (_cursor.isNull(_cursorIndexOfCropName)) {
          _tmpCropName = null;
        } else {
          _tmpCropName = _cursor.getString(_cursorIndexOfCropName);
        }
        _result.setCropName(_tmpCropName);
        final String _tmpVarietyCode;
        if (_cursor.isNull(_cursorIndexOfVarietyCode)) {
          _tmpVarietyCode = null;
        } else {
          _tmpVarietyCode = _cursor.getString(_cursorIndexOfVarietyCode);
        }
        _result.setVarietyCode(_tmpVarietyCode);
        final String _tmpPackingQuantity;
        if (_cursor.isNull(_cursorIndexOfPackingQuantity)) {
          _tmpPackingQuantity = null;
        } else {
          _tmpPackingQuantity = _cursor.getString(_cursorIndexOfPackingQuantity);
        }
        _result.setPackingQuantity(_tmpPackingQuantity);
        final String _tmpBaseUom;
        if (_cursor.isNull(_cursorIndexOfBaseUom)) {
          _tmpBaseUom = null;
        } else {
          _tmpBaseUom = _cursor.getString(_cursorIndexOfBaseUom);
        }
        _result.setBaseUom(_tmpBaseUom);
        final String _tmpMessage;
        if (_cursor.isNull(_cursorIndexOfMessage)) {
          _tmpMessage = null;
        } else {
          _tmpMessage = _cursor.getString(_cursorIndexOfMessage);
        }
        _result.setMessage(_tmpMessage);
        final String _tmpMaterialName;
        if (_cursor.isNull(_cursorIndexOfMaterialName)) {
          _tmpMaterialName = null;
        } else {
          _tmpMaterialName = _cursor.getString(_cursorIndexOfMaterialName);
        }
        _result.setMaterialName(_tmpMaterialName);
        final String _tmpStatus;
        if (_cursor.isNull(_cursorIndexOfStatus)) {
          _tmpStatus = null;
        } else {
          _tmpStatus = _cursor.getString(_cursorIndexOfStatus);
        }
        _result.setStatus(_tmpStatus);
        final String _tmpMaterialCode;
        if (_cursor.isNull(_cursorIndexOfMaterialCode)) {
          _tmpMaterialCode = null;
        } else {
          _tmpMaterialCode = _cursor.getString(_cursorIndexOfMaterialCode);
        }
        _result.setMaterialCode(_tmpMaterialCode);
      } else {
        _result = null;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public String getVarietyCodeByVarietyName(final String varietyName) {
    final String _sql = "Select DISTINCT varietyCode from sto_material where varietyName = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (varietyName == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, varietyName);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final String _result;
      if(_cursor.moveToFirst()) {
        if (_cursor.isNull(0)) {
          _result = null;
        } else {
          _result = _cursor.getString(0);
        }
      } else {
        _result = null;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public String getCropCodeByCropName(final String cropName) {
    final String _sql = "Select DISTINCT cropCode from sto_material where cropName = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (cropName == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, cropName);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final String _result;
      if(_cursor.moveToFirst()) {
        if (_cursor.isNull(0)) {
          _result = null;
        } else {
          _result = _cursor.getString(0);
        }
      } else {
        _result = null;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public String getItemCodeByItemName(final String materialName) {
    final String _sql = "Select DISTINCT materialCode from sto_material where materialName = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (materialName == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, materialName);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final String _result;
      if(_cursor.moveToFirst()) {
        if (_cursor.isNull(0)) {
          _result = null;
        } else {
          _result = _cursor.getString(0);
        }
      } else {
        _result = null;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public String getBaseUOMByItemName(final String materialName) {
    final String _sql = "Select DISTINCT baseUom from sto_material where materialName = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (materialName == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, materialName);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final String _result;
      if(_cursor.moveToFirst()) {
        if (_cursor.isNull(0)) {
          _result = null;
        } else {
          _result = _cursor.getString(0);
        }
      } else {
        _result = null;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public String getPackingQuantityByItemName(final String materialName) {
    final String _sql = "Select DISTINCT packingQuantity from sto_material where materialName = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (materialName == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, materialName);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final String _result;
      if(_cursor.moveToFirst()) {
        if (_cursor.isNull(0)) {
          _result = null;
        } else {
          _result = _cursor.getString(0);
        }
      } else {
        _result = null;
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
