package com.agriscience.salesindent.room_database.dao;

import android.database.Cursor;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.agriscience.salesindent.model.ZOrganogramResponseDetails;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@SuppressWarnings({"unchecked", "deprecation"})
public final class ZOrganogramDetailsDao_Impl implements ZOrganogramDetailsDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<ZOrganogramResponseDetails> __insertionAdapterOfZOrganogramResponseDetails;

  public ZOrganogramDetailsDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfZOrganogramResponseDetails = new EntityInsertionAdapter<ZOrganogramResponseDetails>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `ZOrganogramResponseDetails` (`salesDivisionName`,`territoryName`,`dataUpdatedInMobile`,`inChargeT`,`active`,`dbm`,`dataUpdatedInSap`,`division`,`salesDivision`,`plant`,`tiName`,`regionName`,`rbmName`,`region`,`rbm`,`dbmName`,`Plant_name`,`territoryId`,`status`,`areaManager`,`areaManagerName`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, ZOrganogramResponseDetails value) {
        if (value.getSalesDivisionName() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getSalesDivisionName());
        }
        if (value.getTerritoryName() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getTerritoryName());
        }
        if (value.getDataUpdatedInMobile() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getDataUpdatedInMobile());
        }
        if (value.getInChargeT() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getInChargeT());
        }
        if (value.getActive() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getActive());
        }
        if (value.getDbm() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getDbm());
        }
        if (value.getDataUpdatedInSap() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getDataUpdatedInSap());
        }
        if (value.getDivision() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getDivision());
        }
        if (value.getSalesDivision() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, value.getSalesDivision());
        }
        if (value.getPlant() == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindString(10, value.getPlant());
        }
        if (value.getTiName() == null) {
          stmt.bindNull(11);
        } else {
          stmt.bindString(11, value.getTiName());
        }
        if (value.getRegionName() == null) {
          stmt.bindNull(12);
        } else {
          stmt.bindString(12, value.getRegionName());
        }
        if (value.getRbmName() == null) {
          stmt.bindNull(13);
        } else {
          stmt.bindString(13, value.getRbmName());
        }
        if (value.getRegion() == null) {
          stmt.bindNull(14);
        } else {
          stmt.bindString(14, value.getRegion());
        }
        if (value.getRbm() == null) {
          stmt.bindNull(15);
        } else {
          stmt.bindString(15, value.getRbm());
        }
        if (value.getDbmName() == null) {
          stmt.bindNull(16);
        } else {
          stmt.bindString(16, value.getDbmName());
        }
        if (value.getPlant_name() == null) {
          stmt.bindNull(17);
        } else {
          stmt.bindString(17, value.getPlant_name());
        }
        if (value.getTerritoryId() == null) {
          stmt.bindNull(18);
        } else {
          stmt.bindString(18, value.getTerritoryId());
        }
        if (value.getStatus() == null) {
          stmt.bindNull(19);
        } else {
          stmt.bindString(19, value.getStatus());
        }
        if (value.getAreaManager() == null) {
          stmt.bindNull(20);
        } else {
          stmt.bindString(20, value.getAreaManager());
        }
        if (value.getAreaManagerName() == null) {
          stmt.bindNull(21);
        } else {
          stmt.bindString(21, value.getAreaManagerName());
        }
      }
    };
  }

  @Override
  public void insertAll(final ZOrganogramResponseDetails... responseDetails) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfZOrganogramResponseDetails.insert(responseDetails);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public List<ZOrganogramResponseDetails> getAllZOrganogramReponseDetails() {
    final String _sql = "Select * from ZOrganogramResponseDetails";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfSalesDivisionName = CursorUtil.getColumnIndexOrThrow(_cursor, "salesDivisionName");
      final int _cursorIndexOfTerritoryName = CursorUtil.getColumnIndexOrThrow(_cursor, "territoryName");
      final int _cursorIndexOfDataUpdatedInMobile = CursorUtil.getColumnIndexOrThrow(_cursor, "dataUpdatedInMobile");
      final int _cursorIndexOfInChargeT = CursorUtil.getColumnIndexOrThrow(_cursor, "inChargeT");
      final int _cursorIndexOfActive = CursorUtil.getColumnIndexOrThrow(_cursor, "active");
      final int _cursorIndexOfDbm = CursorUtil.getColumnIndexOrThrow(_cursor, "dbm");
      final int _cursorIndexOfDataUpdatedInSap = CursorUtil.getColumnIndexOrThrow(_cursor, "dataUpdatedInSap");
      final int _cursorIndexOfDivision = CursorUtil.getColumnIndexOrThrow(_cursor, "division");
      final int _cursorIndexOfSalesDivision = CursorUtil.getColumnIndexOrThrow(_cursor, "salesDivision");
      final int _cursorIndexOfPlant = CursorUtil.getColumnIndexOrThrow(_cursor, "plant");
      final int _cursorIndexOfTiName = CursorUtil.getColumnIndexOrThrow(_cursor, "tiName");
      final int _cursorIndexOfRegionName = CursorUtil.getColumnIndexOrThrow(_cursor, "regionName");
      final int _cursorIndexOfRbmName = CursorUtil.getColumnIndexOrThrow(_cursor, "rbmName");
      final int _cursorIndexOfRegion = CursorUtil.getColumnIndexOrThrow(_cursor, "region");
      final int _cursorIndexOfRbm = CursorUtil.getColumnIndexOrThrow(_cursor, "rbm");
      final int _cursorIndexOfDbmName = CursorUtil.getColumnIndexOrThrow(_cursor, "dbmName");
      final int _cursorIndexOfPlantName = CursorUtil.getColumnIndexOrThrow(_cursor, "Plant_name");
      final int _cursorIndexOfTerritoryId = CursorUtil.getColumnIndexOrThrow(_cursor, "territoryId");
      final int _cursorIndexOfStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "status");
      final int _cursorIndexOfAreaManager = CursorUtil.getColumnIndexOrThrow(_cursor, "areaManager");
      final int _cursorIndexOfAreaManagerName = CursorUtil.getColumnIndexOrThrow(_cursor, "areaManagerName");
      final List<ZOrganogramResponseDetails> _result = new ArrayList<ZOrganogramResponseDetails>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final ZOrganogramResponseDetails _item;
        _item = new ZOrganogramResponseDetails();
        final String _tmpSalesDivisionName;
        if (_cursor.isNull(_cursorIndexOfSalesDivisionName)) {
          _tmpSalesDivisionName = null;
        } else {
          _tmpSalesDivisionName = _cursor.getString(_cursorIndexOfSalesDivisionName);
        }
        _item.setSalesDivisionName(_tmpSalesDivisionName);
        final String _tmpTerritoryName;
        if (_cursor.isNull(_cursorIndexOfTerritoryName)) {
          _tmpTerritoryName = null;
        } else {
          _tmpTerritoryName = _cursor.getString(_cursorIndexOfTerritoryName);
        }
        _item.setTerritoryName(_tmpTerritoryName);
        final String _tmpDataUpdatedInMobile;
        if (_cursor.isNull(_cursorIndexOfDataUpdatedInMobile)) {
          _tmpDataUpdatedInMobile = null;
        } else {
          _tmpDataUpdatedInMobile = _cursor.getString(_cursorIndexOfDataUpdatedInMobile);
        }
        _item.setDataUpdatedInMobile(_tmpDataUpdatedInMobile);
        final String _tmpInChargeT;
        if (_cursor.isNull(_cursorIndexOfInChargeT)) {
          _tmpInChargeT = null;
        } else {
          _tmpInChargeT = _cursor.getString(_cursorIndexOfInChargeT);
        }
        _item.setInChargeT(_tmpInChargeT);
        final String _tmpActive;
        if (_cursor.isNull(_cursorIndexOfActive)) {
          _tmpActive = null;
        } else {
          _tmpActive = _cursor.getString(_cursorIndexOfActive);
        }
        _item.setActive(_tmpActive);
        final String _tmpDbm;
        if (_cursor.isNull(_cursorIndexOfDbm)) {
          _tmpDbm = null;
        } else {
          _tmpDbm = _cursor.getString(_cursorIndexOfDbm);
        }
        _item.setDbm(_tmpDbm);
        final String _tmpDataUpdatedInSap;
        if (_cursor.isNull(_cursorIndexOfDataUpdatedInSap)) {
          _tmpDataUpdatedInSap = null;
        } else {
          _tmpDataUpdatedInSap = _cursor.getString(_cursorIndexOfDataUpdatedInSap);
        }
        _item.setDataUpdatedInSap(_tmpDataUpdatedInSap);
        final String _tmpDivision;
        if (_cursor.isNull(_cursorIndexOfDivision)) {
          _tmpDivision = null;
        } else {
          _tmpDivision = _cursor.getString(_cursorIndexOfDivision);
        }
        _item.setDivision(_tmpDivision);
        final String _tmpSalesDivision;
        if (_cursor.isNull(_cursorIndexOfSalesDivision)) {
          _tmpSalesDivision = null;
        } else {
          _tmpSalesDivision = _cursor.getString(_cursorIndexOfSalesDivision);
        }
        _item.setSalesDivision(_tmpSalesDivision);
        final String _tmpPlant;
        if (_cursor.isNull(_cursorIndexOfPlant)) {
          _tmpPlant = null;
        } else {
          _tmpPlant = _cursor.getString(_cursorIndexOfPlant);
        }
        _item.setPlant(_tmpPlant);
        final String _tmpTiName;
        if (_cursor.isNull(_cursorIndexOfTiName)) {
          _tmpTiName = null;
        } else {
          _tmpTiName = _cursor.getString(_cursorIndexOfTiName);
        }
        _item.setTiName(_tmpTiName);
        final String _tmpRegionName;
        if (_cursor.isNull(_cursorIndexOfRegionName)) {
          _tmpRegionName = null;
        } else {
          _tmpRegionName = _cursor.getString(_cursorIndexOfRegionName);
        }
        _item.setRegionName(_tmpRegionName);
        final String _tmpRbmName;
        if (_cursor.isNull(_cursorIndexOfRbmName)) {
          _tmpRbmName = null;
        } else {
          _tmpRbmName = _cursor.getString(_cursorIndexOfRbmName);
        }
        _item.setRbmName(_tmpRbmName);
        final String _tmpRegion;
        if (_cursor.isNull(_cursorIndexOfRegion)) {
          _tmpRegion = null;
        } else {
          _tmpRegion = _cursor.getString(_cursorIndexOfRegion);
        }
        _item.setRegion(_tmpRegion);
        final String _tmpRbm;
        if (_cursor.isNull(_cursorIndexOfRbm)) {
          _tmpRbm = null;
        } else {
          _tmpRbm = _cursor.getString(_cursorIndexOfRbm);
        }
        _item.setRbm(_tmpRbm);
        final String _tmpDbmName;
        if (_cursor.isNull(_cursorIndexOfDbmName)) {
          _tmpDbmName = null;
        } else {
          _tmpDbmName = _cursor.getString(_cursorIndexOfDbmName);
        }
        _item.setDbmName(_tmpDbmName);
        final String _tmpPlant_name;
        if (_cursor.isNull(_cursorIndexOfPlantName)) {
          _tmpPlant_name = null;
        } else {
          _tmpPlant_name = _cursor.getString(_cursorIndexOfPlantName);
        }
        _item.setPlant_name(_tmpPlant_name);
        final String _tmpTerritoryId;
        if (_cursor.isNull(_cursorIndexOfTerritoryId)) {
          _tmpTerritoryId = null;
        } else {
          _tmpTerritoryId = _cursor.getString(_cursorIndexOfTerritoryId);
        }
        _item.setTerritoryId(_tmpTerritoryId);
        final String _tmpStatus;
        if (_cursor.isNull(_cursorIndexOfStatus)) {
          _tmpStatus = null;
        } else {
          _tmpStatus = _cursor.getString(_cursorIndexOfStatus);
        }
        _item.setStatus(_tmpStatus);
        final String _tmpAreaManager;
        if (_cursor.isNull(_cursorIndexOfAreaManager)) {
          _tmpAreaManager = null;
        } else {
          _tmpAreaManager = _cursor.getString(_cursorIndexOfAreaManager);
        }
        _item.setAreaManager(_tmpAreaManager);
        final String _tmpAreaManagerName;
        if (_cursor.isNull(_cursorIndexOfAreaManagerName)) {
          _tmpAreaManagerName = null;
        } else {
          _tmpAreaManagerName = _cursor.getString(_cursorIndexOfAreaManagerName);
        }
        _item.setAreaManagerName(_tmpAreaManagerName);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public ZOrganogramResponseDetails getZOrganogramDetailsByUserId(final String tInCharge) {
    final String _sql = "Select * from ZOrganogramResponseDetails where inChargeT =?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (tInCharge == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, tInCharge);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfSalesDivisionName = CursorUtil.getColumnIndexOrThrow(_cursor, "salesDivisionName");
      final int _cursorIndexOfTerritoryName = CursorUtil.getColumnIndexOrThrow(_cursor, "territoryName");
      final int _cursorIndexOfDataUpdatedInMobile = CursorUtil.getColumnIndexOrThrow(_cursor, "dataUpdatedInMobile");
      final int _cursorIndexOfInChargeT = CursorUtil.getColumnIndexOrThrow(_cursor, "inChargeT");
      final int _cursorIndexOfActive = CursorUtil.getColumnIndexOrThrow(_cursor, "active");
      final int _cursorIndexOfDbm = CursorUtil.getColumnIndexOrThrow(_cursor, "dbm");
      final int _cursorIndexOfDataUpdatedInSap = CursorUtil.getColumnIndexOrThrow(_cursor, "dataUpdatedInSap");
      final int _cursorIndexOfDivision = CursorUtil.getColumnIndexOrThrow(_cursor, "division");
      final int _cursorIndexOfSalesDivision = CursorUtil.getColumnIndexOrThrow(_cursor, "salesDivision");
      final int _cursorIndexOfPlant = CursorUtil.getColumnIndexOrThrow(_cursor, "plant");
      final int _cursorIndexOfTiName = CursorUtil.getColumnIndexOrThrow(_cursor, "tiName");
      final int _cursorIndexOfRegionName = CursorUtil.getColumnIndexOrThrow(_cursor, "regionName");
      final int _cursorIndexOfRbmName = CursorUtil.getColumnIndexOrThrow(_cursor, "rbmName");
      final int _cursorIndexOfRegion = CursorUtil.getColumnIndexOrThrow(_cursor, "region");
      final int _cursorIndexOfRbm = CursorUtil.getColumnIndexOrThrow(_cursor, "rbm");
      final int _cursorIndexOfDbmName = CursorUtil.getColumnIndexOrThrow(_cursor, "dbmName");
      final int _cursorIndexOfPlantName = CursorUtil.getColumnIndexOrThrow(_cursor, "Plant_name");
      final int _cursorIndexOfTerritoryId = CursorUtil.getColumnIndexOrThrow(_cursor, "territoryId");
      final int _cursorIndexOfStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "status");
      final int _cursorIndexOfAreaManager = CursorUtil.getColumnIndexOrThrow(_cursor, "areaManager");
      final int _cursorIndexOfAreaManagerName = CursorUtil.getColumnIndexOrThrow(_cursor, "areaManagerName");
      final ZOrganogramResponseDetails _result;
      if(_cursor.moveToFirst()) {
        _result = new ZOrganogramResponseDetails();
        final String _tmpSalesDivisionName;
        if (_cursor.isNull(_cursorIndexOfSalesDivisionName)) {
          _tmpSalesDivisionName = null;
        } else {
          _tmpSalesDivisionName = _cursor.getString(_cursorIndexOfSalesDivisionName);
        }
        _result.setSalesDivisionName(_tmpSalesDivisionName);
        final String _tmpTerritoryName;
        if (_cursor.isNull(_cursorIndexOfTerritoryName)) {
          _tmpTerritoryName = null;
        } else {
          _tmpTerritoryName = _cursor.getString(_cursorIndexOfTerritoryName);
        }
        _result.setTerritoryName(_tmpTerritoryName);
        final String _tmpDataUpdatedInMobile;
        if (_cursor.isNull(_cursorIndexOfDataUpdatedInMobile)) {
          _tmpDataUpdatedInMobile = null;
        } else {
          _tmpDataUpdatedInMobile = _cursor.getString(_cursorIndexOfDataUpdatedInMobile);
        }
        _result.setDataUpdatedInMobile(_tmpDataUpdatedInMobile);
        final String _tmpInChargeT;
        if (_cursor.isNull(_cursorIndexOfInChargeT)) {
          _tmpInChargeT = null;
        } else {
          _tmpInChargeT = _cursor.getString(_cursorIndexOfInChargeT);
        }
        _result.setInChargeT(_tmpInChargeT);
        final String _tmpActive;
        if (_cursor.isNull(_cursorIndexOfActive)) {
          _tmpActive = null;
        } else {
          _tmpActive = _cursor.getString(_cursorIndexOfActive);
        }
        _result.setActive(_tmpActive);
        final String _tmpDbm;
        if (_cursor.isNull(_cursorIndexOfDbm)) {
          _tmpDbm = null;
        } else {
          _tmpDbm = _cursor.getString(_cursorIndexOfDbm);
        }
        _result.setDbm(_tmpDbm);
        final String _tmpDataUpdatedInSap;
        if (_cursor.isNull(_cursorIndexOfDataUpdatedInSap)) {
          _tmpDataUpdatedInSap = null;
        } else {
          _tmpDataUpdatedInSap = _cursor.getString(_cursorIndexOfDataUpdatedInSap);
        }
        _result.setDataUpdatedInSap(_tmpDataUpdatedInSap);
        final String _tmpDivision;
        if (_cursor.isNull(_cursorIndexOfDivision)) {
          _tmpDivision = null;
        } else {
          _tmpDivision = _cursor.getString(_cursorIndexOfDivision);
        }
        _result.setDivision(_tmpDivision);
        final String _tmpSalesDivision;
        if (_cursor.isNull(_cursorIndexOfSalesDivision)) {
          _tmpSalesDivision = null;
        } else {
          _tmpSalesDivision = _cursor.getString(_cursorIndexOfSalesDivision);
        }
        _result.setSalesDivision(_tmpSalesDivision);
        final String _tmpPlant;
        if (_cursor.isNull(_cursorIndexOfPlant)) {
          _tmpPlant = null;
        } else {
          _tmpPlant = _cursor.getString(_cursorIndexOfPlant);
        }
        _result.setPlant(_tmpPlant);
        final String _tmpTiName;
        if (_cursor.isNull(_cursorIndexOfTiName)) {
          _tmpTiName = null;
        } else {
          _tmpTiName = _cursor.getString(_cursorIndexOfTiName);
        }
        _result.setTiName(_tmpTiName);
        final String _tmpRegionName;
        if (_cursor.isNull(_cursorIndexOfRegionName)) {
          _tmpRegionName = null;
        } else {
          _tmpRegionName = _cursor.getString(_cursorIndexOfRegionName);
        }
        _result.setRegionName(_tmpRegionName);
        final String _tmpRbmName;
        if (_cursor.isNull(_cursorIndexOfRbmName)) {
          _tmpRbmName = null;
        } else {
          _tmpRbmName = _cursor.getString(_cursorIndexOfRbmName);
        }
        _result.setRbmName(_tmpRbmName);
        final String _tmpRegion;
        if (_cursor.isNull(_cursorIndexOfRegion)) {
          _tmpRegion = null;
        } else {
          _tmpRegion = _cursor.getString(_cursorIndexOfRegion);
        }
        _result.setRegion(_tmpRegion);
        final String _tmpRbm;
        if (_cursor.isNull(_cursorIndexOfRbm)) {
          _tmpRbm = null;
        } else {
          _tmpRbm = _cursor.getString(_cursorIndexOfRbm);
        }
        _result.setRbm(_tmpRbm);
        final String _tmpDbmName;
        if (_cursor.isNull(_cursorIndexOfDbmName)) {
          _tmpDbmName = null;
        } else {
          _tmpDbmName = _cursor.getString(_cursorIndexOfDbmName);
        }
        _result.setDbmName(_tmpDbmName);
        final String _tmpPlant_name;
        if (_cursor.isNull(_cursorIndexOfPlantName)) {
          _tmpPlant_name = null;
        } else {
          _tmpPlant_name = _cursor.getString(_cursorIndexOfPlantName);
        }
        _result.setPlant_name(_tmpPlant_name);
        final String _tmpTerritoryId;
        if (_cursor.isNull(_cursorIndexOfTerritoryId)) {
          _tmpTerritoryId = null;
        } else {
          _tmpTerritoryId = _cursor.getString(_cursorIndexOfTerritoryId);
        }
        _result.setTerritoryId(_tmpTerritoryId);
        final String _tmpStatus;
        if (_cursor.isNull(_cursorIndexOfStatus)) {
          _tmpStatus = null;
        } else {
          _tmpStatus = _cursor.getString(_cursorIndexOfStatus);
        }
        _result.setStatus(_tmpStatus);
        final String _tmpAreaManager;
        if (_cursor.isNull(_cursorIndexOfAreaManager)) {
          _tmpAreaManager = null;
        } else {
          _tmpAreaManager = _cursor.getString(_cursorIndexOfAreaManager);
        }
        _result.setAreaManager(_tmpAreaManager);
        final String _tmpAreaManagerName;
        if (_cursor.isNull(_cursorIndexOfAreaManagerName)) {
          _tmpAreaManagerName = null;
        } else {
          _tmpAreaManagerName = _cursor.getString(_cursorIndexOfAreaManagerName);
        }
        _result.setAreaManagerName(_tmpAreaManagerName);
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
  public ZOrganogramResponseDetails getZOrganogramDetailsByRbmId(final String rbmId) {
    final String _sql = "Select * from ZOrganogramResponseDetails where rbm =?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (rbmId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, rbmId);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfSalesDivisionName = CursorUtil.getColumnIndexOrThrow(_cursor, "salesDivisionName");
      final int _cursorIndexOfTerritoryName = CursorUtil.getColumnIndexOrThrow(_cursor, "territoryName");
      final int _cursorIndexOfDataUpdatedInMobile = CursorUtil.getColumnIndexOrThrow(_cursor, "dataUpdatedInMobile");
      final int _cursorIndexOfInChargeT = CursorUtil.getColumnIndexOrThrow(_cursor, "inChargeT");
      final int _cursorIndexOfActive = CursorUtil.getColumnIndexOrThrow(_cursor, "active");
      final int _cursorIndexOfDbm = CursorUtil.getColumnIndexOrThrow(_cursor, "dbm");
      final int _cursorIndexOfDataUpdatedInSap = CursorUtil.getColumnIndexOrThrow(_cursor, "dataUpdatedInSap");
      final int _cursorIndexOfDivision = CursorUtil.getColumnIndexOrThrow(_cursor, "division");
      final int _cursorIndexOfSalesDivision = CursorUtil.getColumnIndexOrThrow(_cursor, "salesDivision");
      final int _cursorIndexOfPlant = CursorUtil.getColumnIndexOrThrow(_cursor, "plant");
      final int _cursorIndexOfTiName = CursorUtil.getColumnIndexOrThrow(_cursor, "tiName");
      final int _cursorIndexOfRegionName = CursorUtil.getColumnIndexOrThrow(_cursor, "regionName");
      final int _cursorIndexOfRbmName = CursorUtil.getColumnIndexOrThrow(_cursor, "rbmName");
      final int _cursorIndexOfRegion = CursorUtil.getColumnIndexOrThrow(_cursor, "region");
      final int _cursorIndexOfRbm = CursorUtil.getColumnIndexOrThrow(_cursor, "rbm");
      final int _cursorIndexOfDbmName = CursorUtil.getColumnIndexOrThrow(_cursor, "dbmName");
      final int _cursorIndexOfPlantName = CursorUtil.getColumnIndexOrThrow(_cursor, "Plant_name");
      final int _cursorIndexOfTerritoryId = CursorUtil.getColumnIndexOrThrow(_cursor, "territoryId");
      final int _cursorIndexOfStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "status");
      final int _cursorIndexOfAreaManager = CursorUtil.getColumnIndexOrThrow(_cursor, "areaManager");
      final int _cursorIndexOfAreaManagerName = CursorUtil.getColumnIndexOrThrow(_cursor, "areaManagerName");
      final ZOrganogramResponseDetails _result;
      if(_cursor.moveToFirst()) {
        _result = new ZOrganogramResponseDetails();
        final String _tmpSalesDivisionName;
        if (_cursor.isNull(_cursorIndexOfSalesDivisionName)) {
          _tmpSalesDivisionName = null;
        } else {
          _tmpSalesDivisionName = _cursor.getString(_cursorIndexOfSalesDivisionName);
        }
        _result.setSalesDivisionName(_tmpSalesDivisionName);
        final String _tmpTerritoryName;
        if (_cursor.isNull(_cursorIndexOfTerritoryName)) {
          _tmpTerritoryName = null;
        } else {
          _tmpTerritoryName = _cursor.getString(_cursorIndexOfTerritoryName);
        }
        _result.setTerritoryName(_tmpTerritoryName);
        final String _tmpDataUpdatedInMobile;
        if (_cursor.isNull(_cursorIndexOfDataUpdatedInMobile)) {
          _tmpDataUpdatedInMobile = null;
        } else {
          _tmpDataUpdatedInMobile = _cursor.getString(_cursorIndexOfDataUpdatedInMobile);
        }
        _result.setDataUpdatedInMobile(_tmpDataUpdatedInMobile);
        final String _tmpInChargeT;
        if (_cursor.isNull(_cursorIndexOfInChargeT)) {
          _tmpInChargeT = null;
        } else {
          _tmpInChargeT = _cursor.getString(_cursorIndexOfInChargeT);
        }
        _result.setInChargeT(_tmpInChargeT);
        final String _tmpActive;
        if (_cursor.isNull(_cursorIndexOfActive)) {
          _tmpActive = null;
        } else {
          _tmpActive = _cursor.getString(_cursorIndexOfActive);
        }
        _result.setActive(_tmpActive);
        final String _tmpDbm;
        if (_cursor.isNull(_cursorIndexOfDbm)) {
          _tmpDbm = null;
        } else {
          _tmpDbm = _cursor.getString(_cursorIndexOfDbm);
        }
        _result.setDbm(_tmpDbm);
        final String _tmpDataUpdatedInSap;
        if (_cursor.isNull(_cursorIndexOfDataUpdatedInSap)) {
          _tmpDataUpdatedInSap = null;
        } else {
          _tmpDataUpdatedInSap = _cursor.getString(_cursorIndexOfDataUpdatedInSap);
        }
        _result.setDataUpdatedInSap(_tmpDataUpdatedInSap);
        final String _tmpDivision;
        if (_cursor.isNull(_cursorIndexOfDivision)) {
          _tmpDivision = null;
        } else {
          _tmpDivision = _cursor.getString(_cursorIndexOfDivision);
        }
        _result.setDivision(_tmpDivision);
        final String _tmpSalesDivision;
        if (_cursor.isNull(_cursorIndexOfSalesDivision)) {
          _tmpSalesDivision = null;
        } else {
          _tmpSalesDivision = _cursor.getString(_cursorIndexOfSalesDivision);
        }
        _result.setSalesDivision(_tmpSalesDivision);
        final String _tmpPlant;
        if (_cursor.isNull(_cursorIndexOfPlant)) {
          _tmpPlant = null;
        } else {
          _tmpPlant = _cursor.getString(_cursorIndexOfPlant);
        }
        _result.setPlant(_tmpPlant);
        final String _tmpTiName;
        if (_cursor.isNull(_cursorIndexOfTiName)) {
          _tmpTiName = null;
        } else {
          _tmpTiName = _cursor.getString(_cursorIndexOfTiName);
        }
        _result.setTiName(_tmpTiName);
        final String _tmpRegionName;
        if (_cursor.isNull(_cursorIndexOfRegionName)) {
          _tmpRegionName = null;
        } else {
          _tmpRegionName = _cursor.getString(_cursorIndexOfRegionName);
        }
        _result.setRegionName(_tmpRegionName);
        final String _tmpRbmName;
        if (_cursor.isNull(_cursorIndexOfRbmName)) {
          _tmpRbmName = null;
        } else {
          _tmpRbmName = _cursor.getString(_cursorIndexOfRbmName);
        }
        _result.setRbmName(_tmpRbmName);
        final String _tmpRegion;
        if (_cursor.isNull(_cursorIndexOfRegion)) {
          _tmpRegion = null;
        } else {
          _tmpRegion = _cursor.getString(_cursorIndexOfRegion);
        }
        _result.setRegion(_tmpRegion);
        final String _tmpRbm;
        if (_cursor.isNull(_cursorIndexOfRbm)) {
          _tmpRbm = null;
        } else {
          _tmpRbm = _cursor.getString(_cursorIndexOfRbm);
        }
        _result.setRbm(_tmpRbm);
        final String _tmpDbmName;
        if (_cursor.isNull(_cursorIndexOfDbmName)) {
          _tmpDbmName = null;
        } else {
          _tmpDbmName = _cursor.getString(_cursorIndexOfDbmName);
        }
        _result.setDbmName(_tmpDbmName);
        final String _tmpPlant_name;
        if (_cursor.isNull(_cursorIndexOfPlantName)) {
          _tmpPlant_name = null;
        } else {
          _tmpPlant_name = _cursor.getString(_cursorIndexOfPlantName);
        }
        _result.setPlant_name(_tmpPlant_name);
        final String _tmpTerritoryId;
        if (_cursor.isNull(_cursorIndexOfTerritoryId)) {
          _tmpTerritoryId = null;
        } else {
          _tmpTerritoryId = _cursor.getString(_cursorIndexOfTerritoryId);
        }
        _result.setTerritoryId(_tmpTerritoryId);
        final String _tmpStatus;
        if (_cursor.isNull(_cursorIndexOfStatus)) {
          _tmpStatus = null;
        } else {
          _tmpStatus = _cursor.getString(_cursorIndexOfStatus);
        }
        _result.setStatus(_tmpStatus);
        final String _tmpAreaManager;
        if (_cursor.isNull(_cursorIndexOfAreaManager)) {
          _tmpAreaManager = null;
        } else {
          _tmpAreaManager = _cursor.getString(_cursorIndexOfAreaManager);
        }
        _result.setAreaManager(_tmpAreaManager);
        final String _tmpAreaManagerName;
        if (_cursor.isNull(_cursorIndexOfAreaManagerName)) {
          _tmpAreaManagerName = null;
        } else {
          _tmpAreaManagerName = _cursor.getString(_cursorIndexOfAreaManagerName);
        }
        _result.setAreaManagerName(_tmpAreaManagerName);
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
  public ZOrganogramResponseDetails getZOrganogramDetailsByDbmId(final String dbmId) {
    final String _sql = "Select * from ZOrganogramResponseDetails where dbm =?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (dbmId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, dbmId);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfSalesDivisionName = CursorUtil.getColumnIndexOrThrow(_cursor, "salesDivisionName");
      final int _cursorIndexOfTerritoryName = CursorUtil.getColumnIndexOrThrow(_cursor, "territoryName");
      final int _cursorIndexOfDataUpdatedInMobile = CursorUtil.getColumnIndexOrThrow(_cursor, "dataUpdatedInMobile");
      final int _cursorIndexOfInChargeT = CursorUtil.getColumnIndexOrThrow(_cursor, "inChargeT");
      final int _cursorIndexOfActive = CursorUtil.getColumnIndexOrThrow(_cursor, "active");
      final int _cursorIndexOfDbm = CursorUtil.getColumnIndexOrThrow(_cursor, "dbm");
      final int _cursorIndexOfDataUpdatedInSap = CursorUtil.getColumnIndexOrThrow(_cursor, "dataUpdatedInSap");
      final int _cursorIndexOfDivision = CursorUtil.getColumnIndexOrThrow(_cursor, "division");
      final int _cursorIndexOfSalesDivision = CursorUtil.getColumnIndexOrThrow(_cursor, "salesDivision");
      final int _cursorIndexOfPlant = CursorUtil.getColumnIndexOrThrow(_cursor, "plant");
      final int _cursorIndexOfTiName = CursorUtil.getColumnIndexOrThrow(_cursor, "tiName");
      final int _cursorIndexOfRegionName = CursorUtil.getColumnIndexOrThrow(_cursor, "regionName");
      final int _cursorIndexOfRbmName = CursorUtil.getColumnIndexOrThrow(_cursor, "rbmName");
      final int _cursorIndexOfRegion = CursorUtil.getColumnIndexOrThrow(_cursor, "region");
      final int _cursorIndexOfRbm = CursorUtil.getColumnIndexOrThrow(_cursor, "rbm");
      final int _cursorIndexOfDbmName = CursorUtil.getColumnIndexOrThrow(_cursor, "dbmName");
      final int _cursorIndexOfPlantName = CursorUtil.getColumnIndexOrThrow(_cursor, "Plant_name");
      final int _cursorIndexOfTerritoryId = CursorUtil.getColumnIndexOrThrow(_cursor, "territoryId");
      final int _cursorIndexOfStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "status");
      final int _cursorIndexOfAreaManager = CursorUtil.getColumnIndexOrThrow(_cursor, "areaManager");
      final int _cursorIndexOfAreaManagerName = CursorUtil.getColumnIndexOrThrow(_cursor, "areaManagerName");
      final ZOrganogramResponseDetails _result;
      if(_cursor.moveToFirst()) {
        _result = new ZOrganogramResponseDetails();
        final String _tmpSalesDivisionName;
        if (_cursor.isNull(_cursorIndexOfSalesDivisionName)) {
          _tmpSalesDivisionName = null;
        } else {
          _tmpSalesDivisionName = _cursor.getString(_cursorIndexOfSalesDivisionName);
        }
        _result.setSalesDivisionName(_tmpSalesDivisionName);
        final String _tmpTerritoryName;
        if (_cursor.isNull(_cursorIndexOfTerritoryName)) {
          _tmpTerritoryName = null;
        } else {
          _tmpTerritoryName = _cursor.getString(_cursorIndexOfTerritoryName);
        }
        _result.setTerritoryName(_tmpTerritoryName);
        final String _tmpDataUpdatedInMobile;
        if (_cursor.isNull(_cursorIndexOfDataUpdatedInMobile)) {
          _tmpDataUpdatedInMobile = null;
        } else {
          _tmpDataUpdatedInMobile = _cursor.getString(_cursorIndexOfDataUpdatedInMobile);
        }
        _result.setDataUpdatedInMobile(_tmpDataUpdatedInMobile);
        final String _tmpInChargeT;
        if (_cursor.isNull(_cursorIndexOfInChargeT)) {
          _tmpInChargeT = null;
        } else {
          _tmpInChargeT = _cursor.getString(_cursorIndexOfInChargeT);
        }
        _result.setInChargeT(_tmpInChargeT);
        final String _tmpActive;
        if (_cursor.isNull(_cursorIndexOfActive)) {
          _tmpActive = null;
        } else {
          _tmpActive = _cursor.getString(_cursorIndexOfActive);
        }
        _result.setActive(_tmpActive);
        final String _tmpDbm;
        if (_cursor.isNull(_cursorIndexOfDbm)) {
          _tmpDbm = null;
        } else {
          _tmpDbm = _cursor.getString(_cursorIndexOfDbm);
        }
        _result.setDbm(_tmpDbm);
        final String _tmpDataUpdatedInSap;
        if (_cursor.isNull(_cursorIndexOfDataUpdatedInSap)) {
          _tmpDataUpdatedInSap = null;
        } else {
          _tmpDataUpdatedInSap = _cursor.getString(_cursorIndexOfDataUpdatedInSap);
        }
        _result.setDataUpdatedInSap(_tmpDataUpdatedInSap);
        final String _tmpDivision;
        if (_cursor.isNull(_cursorIndexOfDivision)) {
          _tmpDivision = null;
        } else {
          _tmpDivision = _cursor.getString(_cursorIndexOfDivision);
        }
        _result.setDivision(_tmpDivision);
        final String _tmpSalesDivision;
        if (_cursor.isNull(_cursorIndexOfSalesDivision)) {
          _tmpSalesDivision = null;
        } else {
          _tmpSalesDivision = _cursor.getString(_cursorIndexOfSalesDivision);
        }
        _result.setSalesDivision(_tmpSalesDivision);
        final String _tmpPlant;
        if (_cursor.isNull(_cursorIndexOfPlant)) {
          _tmpPlant = null;
        } else {
          _tmpPlant = _cursor.getString(_cursorIndexOfPlant);
        }
        _result.setPlant(_tmpPlant);
        final String _tmpTiName;
        if (_cursor.isNull(_cursorIndexOfTiName)) {
          _tmpTiName = null;
        } else {
          _tmpTiName = _cursor.getString(_cursorIndexOfTiName);
        }
        _result.setTiName(_tmpTiName);
        final String _tmpRegionName;
        if (_cursor.isNull(_cursorIndexOfRegionName)) {
          _tmpRegionName = null;
        } else {
          _tmpRegionName = _cursor.getString(_cursorIndexOfRegionName);
        }
        _result.setRegionName(_tmpRegionName);
        final String _tmpRbmName;
        if (_cursor.isNull(_cursorIndexOfRbmName)) {
          _tmpRbmName = null;
        } else {
          _tmpRbmName = _cursor.getString(_cursorIndexOfRbmName);
        }
        _result.setRbmName(_tmpRbmName);
        final String _tmpRegion;
        if (_cursor.isNull(_cursorIndexOfRegion)) {
          _tmpRegion = null;
        } else {
          _tmpRegion = _cursor.getString(_cursorIndexOfRegion);
        }
        _result.setRegion(_tmpRegion);
        final String _tmpRbm;
        if (_cursor.isNull(_cursorIndexOfRbm)) {
          _tmpRbm = null;
        } else {
          _tmpRbm = _cursor.getString(_cursorIndexOfRbm);
        }
        _result.setRbm(_tmpRbm);
        final String _tmpDbmName;
        if (_cursor.isNull(_cursorIndexOfDbmName)) {
          _tmpDbmName = null;
        } else {
          _tmpDbmName = _cursor.getString(_cursorIndexOfDbmName);
        }
        _result.setDbmName(_tmpDbmName);
        final String _tmpPlant_name;
        if (_cursor.isNull(_cursorIndexOfPlantName)) {
          _tmpPlant_name = null;
        } else {
          _tmpPlant_name = _cursor.getString(_cursorIndexOfPlantName);
        }
        _result.setPlant_name(_tmpPlant_name);
        final String _tmpTerritoryId;
        if (_cursor.isNull(_cursorIndexOfTerritoryId)) {
          _tmpTerritoryId = null;
        } else {
          _tmpTerritoryId = _cursor.getString(_cursorIndexOfTerritoryId);
        }
        _result.setTerritoryId(_tmpTerritoryId);
        final String _tmpStatus;
        if (_cursor.isNull(_cursorIndexOfStatus)) {
          _tmpStatus = null;
        } else {
          _tmpStatus = _cursor.getString(_cursorIndexOfStatus);
        }
        _result.setStatus(_tmpStatus);
        final String _tmpAreaManager;
        if (_cursor.isNull(_cursorIndexOfAreaManager)) {
          _tmpAreaManager = null;
        } else {
          _tmpAreaManager = _cursor.getString(_cursorIndexOfAreaManager);
        }
        _result.setAreaManager(_tmpAreaManager);
        final String _tmpAreaManagerName;
        if (_cursor.isNull(_cursorIndexOfAreaManagerName)) {
          _tmpAreaManagerName = null;
        } else {
          _tmpAreaManagerName = _cursor.getString(_cursorIndexOfAreaManagerName);
        }
        _result.setAreaManagerName(_tmpAreaManagerName);
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
  public List<ZOrganogramResponseDetails> getAllZOrganogramReponseDetailsByRbmId(
      final String rbmId) {
    final String _sql = "Select * from ZOrganogramResponseDetails where rbm =?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (rbmId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, rbmId);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfSalesDivisionName = CursorUtil.getColumnIndexOrThrow(_cursor, "salesDivisionName");
      final int _cursorIndexOfTerritoryName = CursorUtil.getColumnIndexOrThrow(_cursor, "territoryName");
      final int _cursorIndexOfDataUpdatedInMobile = CursorUtil.getColumnIndexOrThrow(_cursor, "dataUpdatedInMobile");
      final int _cursorIndexOfInChargeT = CursorUtil.getColumnIndexOrThrow(_cursor, "inChargeT");
      final int _cursorIndexOfActive = CursorUtil.getColumnIndexOrThrow(_cursor, "active");
      final int _cursorIndexOfDbm = CursorUtil.getColumnIndexOrThrow(_cursor, "dbm");
      final int _cursorIndexOfDataUpdatedInSap = CursorUtil.getColumnIndexOrThrow(_cursor, "dataUpdatedInSap");
      final int _cursorIndexOfDivision = CursorUtil.getColumnIndexOrThrow(_cursor, "division");
      final int _cursorIndexOfSalesDivision = CursorUtil.getColumnIndexOrThrow(_cursor, "salesDivision");
      final int _cursorIndexOfPlant = CursorUtil.getColumnIndexOrThrow(_cursor, "plant");
      final int _cursorIndexOfTiName = CursorUtil.getColumnIndexOrThrow(_cursor, "tiName");
      final int _cursorIndexOfRegionName = CursorUtil.getColumnIndexOrThrow(_cursor, "regionName");
      final int _cursorIndexOfRbmName = CursorUtil.getColumnIndexOrThrow(_cursor, "rbmName");
      final int _cursorIndexOfRegion = CursorUtil.getColumnIndexOrThrow(_cursor, "region");
      final int _cursorIndexOfRbm = CursorUtil.getColumnIndexOrThrow(_cursor, "rbm");
      final int _cursorIndexOfDbmName = CursorUtil.getColumnIndexOrThrow(_cursor, "dbmName");
      final int _cursorIndexOfPlantName = CursorUtil.getColumnIndexOrThrow(_cursor, "Plant_name");
      final int _cursorIndexOfTerritoryId = CursorUtil.getColumnIndexOrThrow(_cursor, "territoryId");
      final int _cursorIndexOfStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "status");
      final int _cursorIndexOfAreaManager = CursorUtil.getColumnIndexOrThrow(_cursor, "areaManager");
      final int _cursorIndexOfAreaManagerName = CursorUtil.getColumnIndexOrThrow(_cursor, "areaManagerName");
      final List<ZOrganogramResponseDetails> _result = new ArrayList<ZOrganogramResponseDetails>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final ZOrganogramResponseDetails _item;
        _item = new ZOrganogramResponseDetails();
        final String _tmpSalesDivisionName;
        if (_cursor.isNull(_cursorIndexOfSalesDivisionName)) {
          _tmpSalesDivisionName = null;
        } else {
          _tmpSalesDivisionName = _cursor.getString(_cursorIndexOfSalesDivisionName);
        }
        _item.setSalesDivisionName(_tmpSalesDivisionName);
        final String _tmpTerritoryName;
        if (_cursor.isNull(_cursorIndexOfTerritoryName)) {
          _tmpTerritoryName = null;
        } else {
          _tmpTerritoryName = _cursor.getString(_cursorIndexOfTerritoryName);
        }
        _item.setTerritoryName(_tmpTerritoryName);
        final String _tmpDataUpdatedInMobile;
        if (_cursor.isNull(_cursorIndexOfDataUpdatedInMobile)) {
          _tmpDataUpdatedInMobile = null;
        } else {
          _tmpDataUpdatedInMobile = _cursor.getString(_cursorIndexOfDataUpdatedInMobile);
        }
        _item.setDataUpdatedInMobile(_tmpDataUpdatedInMobile);
        final String _tmpInChargeT;
        if (_cursor.isNull(_cursorIndexOfInChargeT)) {
          _tmpInChargeT = null;
        } else {
          _tmpInChargeT = _cursor.getString(_cursorIndexOfInChargeT);
        }
        _item.setInChargeT(_tmpInChargeT);
        final String _tmpActive;
        if (_cursor.isNull(_cursorIndexOfActive)) {
          _tmpActive = null;
        } else {
          _tmpActive = _cursor.getString(_cursorIndexOfActive);
        }
        _item.setActive(_tmpActive);
        final String _tmpDbm;
        if (_cursor.isNull(_cursorIndexOfDbm)) {
          _tmpDbm = null;
        } else {
          _tmpDbm = _cursor.getString(_cursorIndexOfDbm);
        }
        _item.setDbm(_tmpDbm);
        final String _tmpDataUpdatedInSap;
        if (_cursor.isNull(_cursorIndexOfDataUpdatedInSap)) {
          _tmpDataUpdatedInSap = null;
        } else {
          _tmpDataUpdatedInSap = _cursor.getString(_cursorIndexOfDataUpdatedInSap);
        }
        _item.setDataUpdatedInSap(_tmpDataUpdatedInSap);
        final String _tmpDivision;
        if (_cursor.isNull(_cursorIndexOfDivision)) {
          _tmpDivision = null;
        } else {
          _tmpDivision = _cursor.getString(_cursorIndexOfDivision);
        }
        _item.setDivision(_tmpDivision);
        final String _tmpSalesDivision;
        if (_cursor.isNull(_cursorIndexOfSalesDivision)) {
          _tmpSalesDivision = null;
        } else {
          _tmpSalesDivision = _cursor.getString(_cursorIndexOfSalesDivision);
        }
        _item.setSalesDivision(_tmpSalesDivision);
        final String _tmpPlant;
        if (_cursor.isNull(_cursorIndexOfPlant)) {
          _tmpPlant = null;
        } else {
          _tmpPlant = _cursor.getString(_cursorIndexOfPlant);
        }
        _item.setPlant(_tmpPlant);
        final String _tmpTiName;
        if (_cursor.isNull(_cursorIndexOfTiName)) {
          _tmpTiName = null;
        } else {
          _tmpTiName = _cursor.getString(_cursorIndexOfTiName);
        }
        _item.setTiName(_tmpTiName);
        final String _tmpRegionName;
        if (_cursor.isNull(_cursorIndexOfRegionName)) {
          _tmpRegionName = null;
        } else {
          _tmpRegionName = _cursor.getString(_cursorIndexOfRegionName);
        }
        _item.setRegionName(_tmpRegionName);
        final String _tmpRbmName;
        if (_cursor.isNull(_cursorIndexOfRbmName)) {
          _tmpRbmName = null;
        } else {
          _tmpRbmName = _cursor.getString(_cursorIndexOfRbmName);
        }
        _item.setRbmName(_tmpRbmName);
        final String _tmpRegion;
        if (_cursor.isNull(_cursorIndexOfRegion)) {
          _tmpRegion = null;
        } else {
          _tmpRegion = _cursor.getString(_cursorIndexOfRegion);
        }
        _item.setRegion(_tmpRegion);
        final String _tmpRbm;
        if (_cursor.isNull(_cursorIndexOfRbm)) {
          _tmpRbm = null;
        } else {
          _tmpRbm = _cursor.getString(_cursorIndexOfRbm);
        }
        _item.setRbm(_tmpRbm);
        final String _tmpDbmName;
        if (_cursor.isNull(_cursorIndexOfDbmName)) {
          _tmpDbmName = null;
        } else {
          _tmpDbmName = _cursor.getString(_cursorIndexOfDbmName);
        }
        _item.setDbmName(_tmpDbmName);
        final String _tmpPlant_name;
        if (_cursor.isNull(_cursorIndexOfPlantName)) {
          _tmpPlant_name = null;
        } else {
          _tmpPlant_name = _cursor.getString(_cursorIndexOfPlantName);
        }
        _item.setPlant_name(_tmpPlant_name);
        final String _tmpTerritoryId;
        if (_cursor.isNull(_cursorIndexOfTerritoryId)) {
          _tmpTerritoryId = null;
        } else {
          _tmpTerritoryId = _cursor.getString(_cursorIndexOfTerritoryId);
        }
        _item.setTerritoryId(_tmpTerritoryId);
        final String _tmpStatus;
        if (_cursor.isNull(_cursorIndexOfStatus)) {
          _tmpStatus = null;
        } else {
          _tmpStatus = _cursor.getString(_cursorIndexOfStatus);
        }
        _item.setStatus(_tmpStatus);
        final String _tmpAreaManager;
        if (_cursor.isNull(_cursorIndexOfAreaManager)) {
          _tmpAreaManager = null;
        } else {
          _tmpAreaManager = _cursor.getString(_cursorIndexOfAreaManager);
        }
        _item.setAreaManager(_tmpAreaManager);
        final String _tmpAreaManagerName;
        if (_cursor.isNull(_cursorIndexOfAreaManagerName)) {
          _tmpAreaManagerName = null;
        } else {
          _tmpAreaManagerName = _cursor.getString(_cursorIndexOfAreaManagerName);
        }
        _item.setAreaManagerName(_tmpAreaManagerName);
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
