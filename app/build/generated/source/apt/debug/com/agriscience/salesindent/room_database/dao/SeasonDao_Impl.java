package com.agriscience.salesindent.room_database.dao;

import android.database.Cursor;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.agriscience.salesindent.room_database.entity.SeasonEntity;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@SuppressWarnings({"unchecked", "deprecation"})
public final class SeasonDao_Impl implements SeasonDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<SeasonEntity> __insertionAdapterOfSeasonEntity;

  private final SharedSQLiteStatement __preparedStmtOfDeleteAllSeasonDetails;

  public SeasonDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfSeasonEntity = new EntityInsertionAdapter<SeasonEntity>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `season_entity` (`season_start_date`,`id`,`season_code`,`message`,`season_end_date`,`status`,`crop_code`,`season_name`,`crop_name`,`active`,`return_cut_off_date`,`description`,`state`) VALUES (?,nullif(?, 0),?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, SeasonEntity value) {
        if (value.getSeasonStartDate() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getSeasonStartDate());
        }
        stmt.bindLong(2, value.getId());
        if (value.getSeasonCode() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getSeasonCode());
        }
        if (value.getMessage() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getMessage());
        }
        if (value.getSeasonEndDate() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getSeasonEndDate());
        }
        if (value.getStatus() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getStatus());
        }
        if (value.getCropCode() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getCropCode());
        }
        if (value.getSeasonName() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getSeasonName());
        }
        if (value.getCropName() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, value.getCropName());
        }
        if (value.getActive() == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindString(10, value.getActive());
        }
        if (value.getReturnCutOffDate() == null) {
          stmt.bindNull(11);
        } else {
          stmt.bindString(11, value.getReturnCutOffDate());
        }
        if (value.getDescription() == null) {
          stmt.bindNull(12);
        } else {
          stmt.bindString(12, value.getDescription());
        }
        if (value.getState() == null) {
          stmt.bindNull(13);
        } else {
          stmt.bindString(13, value.getState());
        }
      }
    };
    this.__preparedStmtOfDeleteAllSeasonDetails = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "Delete from season_entity";
        return _query;
      }
    };
  }

  @Override
  public void insertAll(final SeasonEntity... seasonEntities) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfSeasonEntity.insert(seasonEntities);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void deleteAllSeasonDetails() {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteAllSeasonDetails.acquire();
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfDeleteAllSeasonDetails.release(_stmt);
    }
  }

  @Override
  public List<SeasonEntity> getAllSeasons() {
    final String _sql = "Select * from season_entity";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfSeasonStartDate = CursorUtil.getColumnIndexOrThrow(_cursor, "season_start_date");
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfSeasonCode = CursorUtil.getColumnIndexOrThrow(_cursor, "season_code");
      final int _cursorIndexOfMessage = CursorUtil.getColumnIndexOrThrow(_cursor, "message");
      final int _cursorIndexOfSeasonEndDate = CursorUtil.getColumnIndexOrThrow(_cursor, "season_end_date");
      final int _cursorIndexOfStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "status");
      final int _cursorIndexOfCropCode = CursorUtil.getColumnIndexOrThrow(_cursor, "crop_code");
      final int _cursorIndexOfSeasonName = CursorUtil.getColumnIndexOrThrow(_cursor, "season_name");
      final int _cursorIndexOfCropName = CursorUtil.getColumnIndexOrThrow(_cursor, "crop_name");
      final int _cursorIndexOfActive = CursorUtil.getColumnIndexOrThrow(_cursor, "active");
      final int _cursorIndexOfReturnCutOffDate = CursorUtil.getColumnIndexOrThrow(_cursor, "return_cut_off_date");
      final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "description");
      final int _cursorIndexOfState = CursorUtil.getColumnIndexOrThrow(_cursor, "state");
      final List<SeasonEntity> _result = new ArrayList<SeasonEntity>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final SeasonEntity _item;
        _item = new SeasonEntity();
        final String _tmpSeasonStartDate;
        if (_cursor.isNull(_cursorIndexOfSeasonStartDate)) {
          _tmpSeasonStartDate = null;
        } else {
          _tmpSeasonStartDate = _cursor.getString(_cursorIndexOfSeasonStartDate);
        }
        _item.setSeasonStartDate(_tmpSeasonStartDate);
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        _item.setId(_tmpId);
        final String _tmpSeasonCode;
        if (_cursor.isNull(_cursorIndexOfSeasonCode)) {
          _tmpSeasonCode = null;
        } else {
          _tmpSeasonCode = _cursor.getString(_cursorIndexOfSeasonCode);
        }
        _item.setSeasonCode(_tmpSeasonCode);
        final String _tmpMessage;
        if (_cursor.isNull(_cursorIndexOfMessage)) {
          _tmpMessage = null;
        } else {
          _tmpMessage = _cursor.getString(_cursorIndexOfMessage);
        }
        _item.setMessage(_tmpMessage);
        final String _tmpSeasonEndDate;
        if (_cursor.isNull(_cursorIndexOfSeasonEndDate)) {
          _tmpSeasonEndDate = null;
        } else {
          _tmpSeasonEndDate = _cursor.getString(_cursorIndexOfSeasonEndDate);
        }
        _item.setSeasonEndDate(_tmpSeasonEndDate);
        final String _tmpStatus;
        if (_cursor.isNull(_cursorIndexOfStatus)) {
          _tmpStatus = null;
        } else {
          _tmpStatus = _cursor.getString(_cursorIndexOfStatus);
        }
        _item.setStatus(_tmpStatus);
        final String _tmpCropCode;
        if (_cursor.isNull(_cursorIndexOfCropCode)) {
          _tmpCropCode = null;
        } else {
          _tmpCropCode = _cursor.getString(_cursorIndexOfCropCode);
        }
        _item.setCropCode(_tmpCropCode);
        final String _tmpSeasonName;
        if (_cursor.isNull(_cursorIndexOfSeasonName)) {
          _tmpSeasonName = null;
        } else {
          _tmpSeasonName = _cursor.getString(_cursorIndexOfSeasonName);
        }
        _item.setSeasonName(_tmpSeasonName);
        final String _tmpCropName;
        if (_cursor.isNull(_cursorIndexOfCropName)) {
          _tmpCropName = null;
        } else {
          _tmpCropName = _cursor.getString(_cursorIndexOfCropName);
        }
        _item.setCropName(_tmpCropName);
        final String _tmpActive;
        if (_cursor.isNull(_cursorIndexOfActive)) {
          _tmpActive = null;
        } else {
          _tmpActive = _cursor.getString(_cursorIndexOfActive);
        }
        _item.setActive(_tmpActive);
        final String _tmpReturnCutOffDate;
        if (_cursor.isNull(_cursorIndexOfReturnCutOffDate)) {
          _tmpReturnCutOffDate = null;
        } else {
          _tmpReturnCutOffDate = _cursor.getString(_cursorIndexOfReturnCutOffDate);
        }
        _item.setReturnCutOffDate(_tmpReturnCutOffDate);
        final String _tmpDescription;
        if (_cursor.isNull(_cursorIndexOfDescription)) {
          _tmpDescription = null;
        } else {
          _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
        }
        _item.setDescription(_tmpDescription);
        final String _tmpState;
        if (_cursor.isNull(_cursorIndexOfState)) {
          _tmpState = null;
        } else {
          _tmpState = _cursor.getString(_cursorIndexOfState);
        }
        _item.setState(_tmpState);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public SeasonEntity getSeasonBySeasonCode(final String seasonCode, final String cropCode,
      final String stateId) {
    final String _sql = "Select * from season_entity where season_code = ? and crop_code=? and state=?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 3);
    int _argIndex = 1;
    if (seasonCode == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, seasonCode);
    }
    _argIndex = 2;
    if (cropCode == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, cropCode);
    }
    _argIndex = 3;
    if (stateId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, stateId);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfSeasonStartDate = CursorUtil.getColumnIndexOrThrow(_cursor, "season_start_date");
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfSeasonCode = CursorUtil.getColumnIndexOrThrow(_cursor, "season_code");
      final int _cursorIndexOfMessage = CursorUtil.getColumnIndexOrThrow(_cursor, "message");
      final int _cursorIndexOfSeasonEndDate = CursorUtil.getColumnIndexOrThrow(_cursor, "season_end_date");
      final int _cursorIndexOfStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "status");
      final int _cursorIndexOfCropCode = CursorUtil.getColumnIndexOrThrow(_cursor, "crop_code");
      final int _cursorIndexOfSeasonName = CursorUtil.getColumnIndexOrThrow(_cursor, "season_name");
      final int _cursorIndexOfCropName = CursorUtil.getColumnIndexOrThrow(_cursor, "crop_name");
      final int _cursorIndexOfActive = CursorUtil.getColumnIndexOrThrow(_cursor, "active");
      final int _cursorIndexOfReturnCutOffDate = CursorUtil.getColumnIndexOrThrow(_cursor, "return_cut_off_date");
      final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "description");
      final int _cursorIndexOfState = CursorUtil.getColumnIndexOrThrow(_cursor, "state");
      final SeasonEntity _result;
      if(_cursor.moveToFirst()) {
        _result = new SeasonEntity();
        final String _tmpSeasonStartDate;
        if (_cursor.isNull(_cursorIndexOfSeasonStartDate)) {
          _tmpSeasonStartDate = null;
        } else {
          _tmpSeasonStartDate = _cursor.getString(_cursorIndexOfSeasonStartDate);
        }
        _result.setSeasonStartDate(_tmpSeasonStartDate);
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        _result.setId(_tmpId);
        final String _tmpSeasonCode;
        if (_cursor.isNull(_cursorIndexOfSeasonCode)) {
          _tmpSeasonCode = null;
        } else {
          _tmpSeasonCode = _cursor.getString(_cursorIndexOfSeasonCode);
        }
        _result.setSeasonCode(_tmpSeasonCode);
        final String _tmpMessage;
        if (_cursor.isNull(_cursorIndexOfMessage)) {
          _tmpMessage = null;
        } else {
          _tmpMessage = _cursor.getString(_cursorIndexOfMessage);
        }
        _result.setMessage(_tmpMessage);
        final String _tmpSeasonEndDate;
        if (_cursor.isNull(_cursorIndexOfSeasonEndDate)) {
          _tmpSeasonEndDate = null;
        } else {
          _tmpSeasonEndDate = _cursor.getString(_cursorIndexOfSeasonEndDate);
        }
        _result.setSeasonEndDate(_tmpSeasonEndDate);
        final String _tmpStatus;
        if (_cursor.isNull(_cursorIndexOfStatus)) {
          _tmpStatus = null;
        } else {
          _tmpStatus = _cursor.getString(_cursorIndexOfStatus);
        }
        _result.setStatus(_tmpStatus);
        final String _tmpCropCode;
        if (_cursor.isNull(_cursorIndexOfCropCode)) {
          _tmpCropCode = null;
        } else {
          _tmpCropCode = _cursor.getString(_cursorIndexOfCropCode);
        }
        _result.setCropCode(_tmpCropCode);
        final String _tmpSeasonName;
        if (_cursor.isNull(_cursorIndexOfSeasonName)) {
          _tmpSeasonName = null;
        } else {
          _tmpSeasonName = _cursor.getString(_cursorIndexOfSeasonName);
        }
        _result.setSeasonName(_tmpSeasonName);
        final String _tmpCropName;
        if (_cursor.isNull(_cursorIndexOfCropName)) {
          _tmpCropName = null;
        } else {
          _tmpCropName = _cursor.getString(_cursorIndexOfCropName);
        }
        _result.setCropName(_tmpCropName);
        final String _tmpActive;
        if (_cursor.isNull(_cursorIndexOfActive)) {
          _tmpActive = null;
        } else {
          _tmpActive = _cursor.getString(_cursorIndexOfActive);
        }
        _result.setActive(_tmpActive);
        final String _tmpReturnCutOffDate;
        if (_cursor.isNull(_cursorIndexOfReturnCutOffDate)) {
          _tmpReturnCutOffDate = null;
        } else {
          _tmpReturnCutOffDate = _cursor.getString(_cursorIndexOfReturnCutOffDate);
        }
        _result.setReturnCutOffDate(_tmpReturnCutOffDate);
        final String _tmpDescription;
        if (_cursor.isNull(_cursorIndexOfDescription)) {
          _tmpDescription = null;
        } else {
          _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
        }
        _result.setDescription(_tmpDescription);
        final String _tmpState;
        if (_cursor.isNull(_cursorIndexOfState)) {
          _tmpState = null;
        } else {
          _tmpState = _cursor.getString(_cursorIndexOfState);
        }
        _result.setState(_tmpState);
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
  public List<SeasonEntity> getAllSeasonDetailsFilterByCropCodeAndStateId(final String cropCode,
      final String stateId) {
    final String _sql = "Select * from season_entity where crop_code =? and state=?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    if (cropCode == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, cropCode);
    }
    _argIndex = 2;
    if (stateId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, stateId);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfSeasonStartDate = CursorUtil.getColumnIndexOrThrow(_cursor, "season_start_date");
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfSeasonCode = CursorUtil.getColumnIndexOrThrow(_cursor, "season_code");
      final int _cursorIndexOfMessage = CursorUtil.getColumnIndexOrThrow(_cursor, "message");
      final int _cursorIndexOfSeasonEndDate = CursorUtil.getColumnIndexOrThrow(_cursor, "season_end_date");
      final int _cursorIndexOfStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "status");
      final int _cursorIndexOfCropCode = CursorUtil.getColumnIndexOrThrow(_cursor, "crop_code");
      final int _cursorIndexOfSeasonName = CursorUtil.getColumnIndexOrThrow(_cursor, "season_name");
      final int _cursorIndexOfCropName = CursorUtil.getColumnIndexOrThrow(_cursor, "crop_name");
      final int _cursorIndexOfActive = CursorUtil.getColumnIndexOrThrow(_cursor, "active");
      final int _cursorIndexOfReturnCutOffDate = CursorUtil.getColumnIndexOrThrow(_cursor, "return_cut_off_date");
      final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "description");
      final int _cursorIndexOfState = CursorUtil.getColumnIndexOrThrow(_cursor, "state");
      final List<SeasonEntity> _result = new ArrayList<SeasonEntity>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final SeasonEntity _item;
        _item = new SeasonEntity();
        final String _tmpSeasonStartDate;
        if (_cursor.isNull(_cursorIndexOfSeasonStartDate)) {
          _tmpSeasonStartDate = null;
        } else {
          _tmpSeasonStartDate = _cursor.getString(_cursorIndexOfSeasonStartDate);
        }
        _item.setSeasonStartDate(_tmpSeasonStartDate);
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        _item.setId(_tmpId);
        final String _tmpSeasonCode;
        if (_cursor.isNull(_cursorIndexOfSeasonCode)) {
          _tmpSeasonCode = null;
        } else {
          _tmpSeasonCode = _cursor.getString(_cursorIndexOfSeasonCode);
        }
        _item.setSeasonCode(_tmpSeasonCode);
        final String _tmpMessage;
        if (_cursor.isNull(_cursorIndexOfMessage)) {
          _tmpMessage = null;
        } else {
          _tmpMessage = _cursor.getString(_cursorIndexOfMessage);
        }
        _item.setMessage(_tmpMessage);
        final String _tmpSeasonEndDate;
        if (_cursor.isNull(_cursorIndexOfSeasonEndDate)) {
          _tmpSeasonEndDate = null;
        } else {
          _tmpSeasonEndDate = _cursor.getString(_cursorIndexOfSeasonEndDate);
        }
        _item.setSeasonEndDate(_tmpSeasonEndDate);
        final String _tmpStatus;
        if (_cursor.isNull(_cursorIndexOfStatus)) {
          _tmpStatus = null;
        } else {
          _tmpStatus = _cursor.getString(_cursorIndexOfStatus);
        }
        _item.setStatus(_tmpStatus);
        final String _tmpCropCode;
        if (_cursor.isNull(_cursorIndexOfCropCode)) {
          _tmpCropCode = null;
        } else {
          _tmpCropCode = _cursor.getString(_cursorIndexOfCropCode);
        }
        _item.setCropCode(_tmpCropCode);
        final String _tmpSeasonName;
        if (_cursor.isNull(_cursorIndexOfSeasonName)) {
          _tmpSeasonName = null;
        } else {
          _tmpSeasonName = _cursor.getString(_cursorIndexOfSeasonName);
        }
        _item.setSeasonName(_tmpSeasonName);
        final String _tmpCropName;
        if (_cursor.isNull(_cursorIndexOfCropName)) {
          _tmpCropName = null;
        } else {
          _tmpCropName = _cursor.getString(_cursorIndexOfCropName);
        }
        _item.setCropName(_tmpCropName);
        final String _tmpActive;
        if (_cursor.isNull(_cursorIndexOfActive)) {
          _tmpActive = null;
        } else {
          _tmpActive = _cursor.getString(_cursorIndexOfActive);
        }
        _item.setActive(_tmpActive);
        final String _tmpReturnCutOffDate;
        if (_cursor.isNull(_cursorIndexOfReturnCutOffDate)) {
          _tmpReturnCutOffDate = null;
        } else {
          _tmpReturnCutOffDate = _cursor.getString(_cursorIndexOfReturnCutOffDate);
        }
        _item.setReturnCutOffDate(_tmpReturnCutOffDate);
        final String _tmpDescription;
        if (_cursor.isNull(_cursorIndexOfDescription)) {
          _tmpDescription = null;
        } else {
          _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
        }
        _item.setDescription(_tmpDescription);
        final String _tmpState;
        if (_cursor.isNull(_cursorIndexOfState)) {
          _tmpState = null;
        } else {
          _tmpState = _cursor.getString(_cursorIndexOfState);
        }
        _item.setState(_tmpState);
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
