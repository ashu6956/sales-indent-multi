package com.agriscience.salesindent.room_database.dao;

import android.database.Cursor;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.agriscience.salesindent.model.PlantDetailsResponse;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@SuppressWarnings({"unchecked", "deprecation"})
public final class PlantDao_Impl implements PlantDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<PlantDetailsResponse> __insertionAdapterOfPlantDetailsResponse;

  private final SharedSQLiteStatement __preparedStmtOfDeletePlantByPlantCode;

  private final SharedSQLiteStatement __preparedStmtOfDeleteAllPlantData;

  public PlantDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfPlantDetailsResponse = new EntityInsertionAdapter<PlantDetailsResponse>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `plant_details` (`id`,`sales`,`plantCode`,`plantName`,`processing`) VALUES (nullif(?, 0),?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, PlantDetailsResponse value) {
        stmt.bindLong(1, value.getId());
        if (value.getSales() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getSales());
        }
        if (value.getPlantCode() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getPlantCode());
        }
        if (value.getPlantName() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getPlantName());
        }
        if (value.getProcessing() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getProcessing());
        }
      }
    };
    this.__preparedStmtOfDeletePlantByPlantCode = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "Delete from plant_details where plantCode = ?";
        return _query;
      }
    };
    this.__preparedStmtOfDeleteAllPlantData = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "Delete from plant_details";
        return _query;
      }
    };
  }

  @Override
  public void insertAll(final PlantDetailsResponse... plantDetailsResponses) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfPlantDetailsResponse.insert(plantDetailsResponses);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void deletePlantByPlantCode(final String plantCode) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfDeletePlantByPlantCode.acquire();
    int _argIndex = 1;
    if (plantCode == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, plantCode);
    }
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfDeletePlantByPlantCode.release(_stmt);
    }
  }

  @Override
  public void deleteAllPlantData() {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteAllPlantData.acquire();
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfDeleteAllPlantData.release(_stmt);
    }
  }

  @Override
  public List<PlantDetailsResponse> getAllPlantDetails() {
    final String _sql = "Select * from plant_details";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfSales = CursorUtil.getColumnIndexOrThrow(_cursor, "sales");
      final int _cursorIndexOfPlantCode = CursorUtil.getColumnIndexOrThrow(_cursor, "plantCode");
      final int _cursorIndexOfPlantName = CursorUtil.getColumnIndexOrThrow(_cursor, "plantName");
      final int _cursorIndexOfProcessing = CursorUtil.getColumnIndexOrThrow(_cursor, "processing");
      final List<PlantDetailsResponse> _result = new ArrayList<PlantDetailsResponse>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final PlantDetailsResponse _item;
        _item = new PlantDetailsResponse();
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        _item.setId(_tmpId);
        final String _tmpSales;
        if (_cursor.isNull(_cursorIndexOfSales)) {
          _tmpSales = null;
        } else {
          _tmpSales = _cursor.getString(_cursorIndexOfSales);
        }
        _item.setSales(_tmpSales);
        final String _tmpPlantCode;
        if (_cursor.isNull(_cursorIndexOfPlantCode)) {
          _tmpPlantCode = null;
        } else {
          _tmpPlantCode = _cursor.getString(_cursorIndexOfPlantCode);
        }
        _item.setPlantCode(_tmpPlantCode);
        final String _tmpPlantName;
        if (_cursor.isNull(_cursorIndexOfPlantName)) {
          _tmpPlantName = null;
        } else {
          _tmpPlantName = _cursor.getString(_cursorIndexOfPlantName);
        }
        _item.setPlantName(_tmpPlantName);
        final String _tmpProcessing;
        if (_cursor.isNull(_cursorIndexOfProcessing)) {
          _tmpProcessing = null;
        } else {
          _tmpProcessing = _cursor.getString(_cursorIndexOfProcessing);
        }
        _item.setProcessing(_tmpProcessing);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public PlantDetailsResponse getPlantByPlantCode(final String plantCode) {
    final String _sql = "Select * from plant_details where plantCode = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (plantCode == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, plantCode);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfSales = CursorUtil.getColumnIndexOrThrow(_cursor, "sales");
      final int _cursorIndexOfPlantCode = CursorUtil.getColumnIndexOrThrow(_cursor, "plantCode");
      final int _cursorIndexOfPlantName = CursorUtil.getColumnIndexOrThrow(_cursor, "plantName");
      final int _cursorIndexOfProcessing = CursorUtil.getColumnIndexOrThrow(_cursor, "processing");
      final PlantDetailsResponse _result;
      if(_cursor.moveToFirst()) {
        _result = new PlantDetailsResponse();
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        _result.setId(_tmpId);
        final String _tmpSales;
        if (_cursor.isNull(_cursorIndexOfSales)) {
          _tmpSales = null;
        } else {
          _tmpSales = _cursor.getString(_cursorIndexOfSales);
        }
        _result.setSales(_tmpSales);
        final String _tmpPlantCode;
        if (_cursor.isNull(_cursorIndexOfPlantCode)) {
          _tmpPlantCode = null;
        } else {
          _tmpPlantCode = _cursor.getString(_cursorIndexOfPlantCode);
        }
        _result.setPlantCode(_tmpPlantCode);
        final String _tmpPlantName;
        if (_cursor.isNull(_cursorIndexOfPlantName)) {
          _tmpPlantName = null;
        } else {
          _tmpPlantName = _cursor.getString(_cursorIndexOfPlantName);
        }
        _result.setPlantName(_tmpPlantName);
        final String _tmpProcessing;
        if (_cursor.isNull(_cursorIndexOfProcessing)) {
          _tmpProcessing = null;
        } else {
          _tmpProcessing = _cursor.getString(_cursorIndexOfProcessing);
        }
        _result.setProcessing(_tmpProcessing);
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
