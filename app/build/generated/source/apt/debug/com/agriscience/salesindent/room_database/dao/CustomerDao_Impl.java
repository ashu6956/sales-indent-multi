package com.agriscience.salesindent.room_database.dao;

import android.database.Cursor;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.agriscience.salesindent.room_database.entity.CustomerEntity;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@SuppressWarnings({"unchecked", "deprecation"})
public final class CustomerDao_Impl implements CustomerDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<CustomerEntity> __insertionAdapterOfCustomerEntity;

  private final SharedSQLiteStatement __preparedStmtOfDeleteCustomerByCustomerCode;

  private final SharedSQLiteStatement __preparedStmtOfDeleteAllCustomerData;

  public CustomerDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfCustomerEntity = new EntityInsertionAdapter<CustomerEntity>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `customer_entity` (`sales_organization`,`division`,`distribution_channel`,`customer_name`,`customer_code`,`territory_id`,`sales_office`,`status`,`state_id`) VALUES (?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, CustomerEntity value) {
        if (value.getSalesOrganization() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getSalesOrganization());
        }
        if (value.getDivision() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getDivision());
        }
        if (value.getDistributionChannel() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getDistributionChannel());
        }
        if (value.getCustomerName() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getCustomerName());
        }
        if (value.getCustomerCode() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getCustomerCode());
        }
        if (value.getTerritoryId() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getTerritoryId());
        }
        if (value.getSales_office() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getSales_office());
        }
        if (value.getStatus() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getStatus());
        }
        if (value.getStateId() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, value.getStateId());
        }
      }
    };
    this.__preparedStmtOfDeleteCustomerByCustomerCode = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "Delete from customer_entity where customer_code = ?";
        return _query;
      }
    };
    this.__preparedStmtOfDeleteAllCustomerData = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "Delete from customer_entity";
        return _query;
      }
    };
  }

  @Override
  public void insertAll(final CustomerEntity... customerEntities) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfCustomerEntity.insert(customerEntities);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void deleteCustomerByCustomerCode(final String customerCode) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteCustomerByCustomerCode.acquire();
    int _argIndex = 1;
    if (customerCode == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, customerCode);
    }
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfDeleteCustomerByCustomerCode.release(_stmt);
    }
  }

  @Override
  public void deleteAllCustomerData() {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteAllCustomerData.acquire();
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfDeleteAllCustomerData.release(_stmt);
    }
  }

  @Override
  public List<CustomerEntity> getAllCustomers() {
    final String _sql = "Select * from customer_entity";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfSalesOrganization = CursorUtil.getColumnIndexOrThrow(_cursor, "sales_organization");
      final int _cursorIndexOfDivision = CursorUtil.getColumnIndexOrThrow(_cursor, "division");
      final int _cursorIndexOfDistributionChannel = CursorUtil.getColumnIndexOrThrow(_cursor, "distribution_channel");
      final int _cursorIndexOfCustomerName = CursorUtil.getColumnIndexOrThrow(_cursor, "customer_name");
      final int _cursorIndexOfCustomerCode = CursorUtil.getColumnIndexOrThrow(_cursor, "customer_code");
      final int _cursorIndexOfTerritoryId = CursorUtil.getColumnIndexOrThrow(_cursor, "territory_id");
      final int _cursorIndexOfSalesOffice = CursorUtil.getColumnIndexOrThrow(_cursor, "sales_office");
      final int _cursorIndexOfStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "status");
      final int _cursorIndexOfStateId = CursorUtil.getColumnIndexOrThrow(_cursor, "state_id");
      final List<CustomerEntity> _result = new ArrayList<CustomerEntity>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final CustomerEntity _item;
        _item = new CustomerEntity();
        final String _tmpSalesOrganization;
        if (_cursor.isNull(_cursorIndexOfSalesOrganization)) {
          _tmpSalesOrganization = null;
        } else {
          _tmpSalesOrganization = _cursor.getString(_cursorIndexOfSalesOrganization);
        }
        _item.setSalesOrganization(_tmpSalesOrganization);
        final String _tmpDivision;
        if (_cursor.isNull(_cursorIndexOfDivision)) {
          _tmpDivision = null;
        } else {
          _tmpDivision = _cursor.getString(_cursorIndexOfDivision);
        }
        _item.setDivision(_tmpDivision);
        final String _tmpDistributionChannel;
        if (_cursor.isNull(_cursorIndexOfDistributionChannel)) {
          _tmpDistributionChannel = null;
        } else {
          _tmpDistributionChannel = _cursor.getString(_cursorIndexOfDistributionChannel);
        }
        _item.setDistributionChannel(_tmpDistributionChannel);
        final String _tmpCustomerName;
        if (_cursor.isNull(_cursorIndexOfCustomerName)) {
          _tmpCustomerName = null;
        } else {
          _tmpCustomerName = _cursor.getString(_cursorIndexOfCustomerName);
        }
        _item.setCustomerName(_tmpCustomerName);
        final String _tmpCustomerCode;
        if (_cursor.isNull(_cursorIndexOfCustomerCode)) {
          _tmpCustomerCode = null;
        } else {
          _tmpCustomerCode = _cursor.getString(_cursorIndexOfCustomerCode);
        }
        _item.setCustomerCode(_tmpCustomerCode);
        final String _tmpTerritoryId;
        if (_cursor.isNull(_cursorIndexOfTerritoryId)) {
          _tmpTerritoryId = null;
        } else {
          _tmpTerritoryId = _cursor.getString(_cursorIndexOfTerritoryId);
        }
        _item.setTerritoryId(_tmpTerritoryId);
        final String _tmpSales_office;
        if (_cursor.isNull(_cursorIndexOfSalesOffice)) {
          _tmpSales_office = null;
        } else {
          _tmpSales_office = _cursor.getString(_cursorIndexOfSalesOffice);
        }
        _item.setSales_office(_tmpSales_office);
        final String _tmpStatus;
        if (_cursor.isNull(_cursorIndexOfStatus)) {
          _tmpStatus = null;
        } else {
          _tmpStatus = _cursor.getString(_cursorIndexOfStatus);
        }
        _item.setStatus(_tmpStatus);
        final String _tmpStateId;
        if (_cursor.isNull(_cursorIndexOfStateId)) {
          _tmpStateId = null;
        } else {
          _tmpStateId = _cursor.getString(_cursorIndexOfStateId);
        }
        _item.setStateId(_tmpStateId);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public CustomerEntity getCustomerByCustomerCode(final String customerCode) {
    final String _sql = "Select * from customer_entity where customer_code = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (customerCode == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, customerCode);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfSalesOrganization = CursorUtil.getColumnIndexOrThrow(_cursor, "sales_organization");
      final int _cursorIndexOfDivision = CursorUtil.getColumnIndexOrThrow(_cursor, "division");
      final int _cursorIndexOfDistributionChannel = CursorUtil.getColumnIndexOrThrow(_cursor, "distribution_channel");
      final int _cursorIndexOfCustomerName = CursorUtil.getColumnIndexOrThrow(_cursor, "customer_name");
      final int _cursorIndexOfCustomerCode = CursorUtil.getColumnIndexOrThrow(_cursor, "customer_code");
      final int _cursorIndexOfTerritoryId = CursorUtil.getColumnIndexOrThrow(_cursor, "territory_id");
      final int _cursorIndexOfSalesOffice = CursorUtil.getColumnIndexOrThrow(_cursor, "sales_office");
      final int _cursorIndexOfStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "status");
      final int _cursorIndexOfStateId = CursorUtil.getColumnIndexOrThrow(_cursor, "state_id");
      final CustomerEntity _result;
      if(_cursor.moveToFirst()) {
        _result = new CustomerEntity();
        final String _tmpSalesOrganization;
        if (_cursor.isNull(_cursorIndexOfSalesOrganization)) {
          _tmpSalesOrganization = null;
        } else {
          _tmpSalesOrganization = _cursor.getString(_cursorIndexOfSalesOrganization);
        }
        _result.setSalesOrganization(_tmpSalesOrganization);
        final String _tmpDivision;
        if (_cursor.isNull(_cursorIndexOfDivision)) {
          _tmpDivision = null;
        } else {
          _tmpDivision = _cursor.getString(_cursorIndexOfDivision);
        }
        _result.setDivision(_tmpDivision);
        final String _tmpDistributionChannel;
        if (_cursor.isNull(_cursorIndexOfDistributionChannel)) {
          _tmpDistributionChannel = null;
        } else {
          _tmpDistributionChannel = _cursor.getString(_cursorIndexOfDistributionChannel);
        }
        _result.setDistributionChannel(_tmpDistributionChannel);
        final String _tmpCustomerName;
        if (_cursor.isNull(_cursorIndexOfCustomerName)) {
          _tmpCustomerName = null;
        } else {
          _tmpCustomerName = _cursor.getString(_cursorIndexOfCustomerName);
        }
        _result.setCustomerName(_tmpCustomerName);
        final String _tmpCustomerCode;
        if (_cursor.isNull(_cursorIndexOfCustomerCode)) {
          _tmpCustomerCode = null;
        } else {
          _tmpCustomerCode = _cursor.getString(_cursorIndexOfCustomerCode);
        }
        _result.setCustomerCode(_tmpCustomerCode);
        final String _tmpTerritoryId;
        if (_cursor.isNull(_cursorIndexOfTerritoryId)) {
          _tmpTerritoryId = null;
        } else {
          _tmpTerritoryId = _cursor.getString(_cursorIndexOfTerritoryId);
        }
        _result.setTerritoryId(_tmpTerritoryId);
        final String _tmpSales_office;
        if (_cursor.isNull(_cursorIndexOfSalesOffice)) {
          _tmpSales_office = null;
        } else {
          _tmpSales_office = _cursor.getString(_cursorIndexOfSalesOffice);
        }
        _result.setSales_office(_tmpSales_office);
        final String _tmpStatus;
        if (_cursor.isNull(_cursorIndexOfStatus)) {
          _tmpStatus = null;
        } else {
          _tmpStatus = _cursor.getString(_cursorIndexOfStatus);
        }
        _result.setStatus(_tmpStatus);
        final String _tmpStateId;
        if (_cursor.isNull(_cursorIndexOfStateId)) {
          _tmpStateId = null;
        } else {
          _tmpStateId = _cursor.getString(_cursorIndexOfStateId);
        }
        _result.setStateId(_tmpStateId);
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
