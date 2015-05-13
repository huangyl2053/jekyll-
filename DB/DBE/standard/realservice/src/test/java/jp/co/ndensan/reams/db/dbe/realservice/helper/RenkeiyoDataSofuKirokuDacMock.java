/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.realservice.helper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.HikiwatashiKubun;
import jp.co.ndensan.reams.db.dbe.definition.NinteiShinseijiKubun;
import jp.co.ndensan.reams.db.dbe.definition.SaiChousaSoufuKubun;
import jp.co.ndensan.reams.db.dbe.definition.SaiIkenshoSoufuKubun;
import jp.co.ndensan.reams.db.dbe.definition.SaiSoufuKubun;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5022RenkeiyoDataSofuKirokuEntity;
import jp.co.ndensan.reams.db.dbe.persistence.basic.IRenkeiyoDataSofuKirokuDac;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.mockito.Mockito.*;

/**
 * DbT5022RenkeiyoDataSofuKirokuEntityのMockクラスです。
 *
 * @author n8107 千秋雄
 */
public class RenkeiyoDataSofuKirokuDacMock implements IRenkeiyoDataSofuKirokuDac {

    public static RString 検索不可な申請書管理番号 = new RString("検索不可");
    public static RString 検索不可な被保険者番号 = new RString("検索不可");
    public static RString 削除可能な申請書管理番号 = new RString("削除可能");
    public static RString 登録可能な申請書管理番号 = new RString("更新可能");
    public static ShinseishoKanriNo shinseishokanriNo;
    public static HihokenshaNo hihokennshaNo;
    public static YMDHMS shoriTimestamp;

    public static DbT5022RenkeiyoDataSofuKirokuEntity getSpiedInstance() {

        DbT5022RenkeiyoDataSofuKirokuEntity entity = new DbT5022RenkeiyoDataSofuKirokuEntity();

        shinseishokanriNo = mock(ShinseishoKanriNo.class);
        shinseishokanriNo = new ShinseishoKanriNo(new RString("100000001"));

        shoriTimestamp = mock(YMDHMS.class);
        shoriTimestamp = new YMDHMS(new RString("20140808102030"));

        hihokennshaNo = mock(HihokenshaNo.class);
        hihokennshaNo = new HihokenshaNo(new RString("1234567890"));

        entity.setShinseishoKanriNo(new ShinseishoKanriNo(new RString("100000001")));
        entity.setShoriTimestamp(new YMDHMS(new RString("20140808102030")));
        entity.setHihokenshaNo(new HihokenshaNo(new RString("1234567890")));
        entity.setNinteiShinseiShinseijiKubun(new RString("01"));
        entity.setHikiwatashiKubun(new RString("0"));
        entity.setHikiwatashiNichiji(RDateTime.of(2014, 03, 14, 18, 45, 05));
        entity.setSaiSoufuKubun(new RString("01"));
        entity.setSaiChousaSoufuKubun(new RString("0"));
        entity.setSaiIkenshoSoufuKubun(new RString("0"));

        return spy(entity);
    }

    private DbT5022RenkeiyoDataSofuKirokuEntity creatInstance(RString 申請書管理番号) {
        DbT5022RenkeiyoDataSofuKirokuEntity entity = getSpiedInstance();
        return entity;
    }

    @Override
    public DbT5022RenkeiyoDataSofuKirokuEntity select(RString 申請書管理番号) {
        if (申請書管理番号.equals(検索不可な申請書管理番号)) {
            return null;
        }
        return creatInstance(申請書管理番号);
    }

    @Override
    public List<DbT5022RenkeiyoDataSofuKirokuEntity> selectAll(RString 被保険者番号) {
        if (被保険者番号.equals(検索不可な被保険者番号)) {
            return Collections.EMPTY_LIST;
        }
        List<DbT5022RenkeiyoDataSofuKirokuEntity> entities = new ArrayList<>();
        entities.add(creatInstance(new RString("H000000001")));
        entities.add(creatInstance(new RString("H000000001")));
        return entities;
    }

    @Override
    public List<DbT5022RenkeiyoDataSofuKirokuEntity> selectAll(NinteiShinseijiKubun 認定申請時区分) {

        List<DbT5022RenkeiyoDataSofuKirokuEntity> entities = new ArrayList<>();
        entities.add(creatInstance(new RString("01")));
        return entities;
    }

    @Override
    public List<DbT5022RenkeiyoDataSofuKirokuEntity> selectAll(HikiwatashiKubun 引渡し区分) {

        List<DbT5022RenkeiyoDataSofuKirokuEntity> entities = new ArrayList<>();
        entities.add(creatInstance(new RString("0")));
        return entities;
    }

    @Override
    public List<DbT5022RenkeiyoDataSofuKirokuEntity> selectAll(RDateTime 引渡し日時) {

        List<DbT5022RenkeiyoDataSofuKirokuEntity> entities = new ArrayList<>();
        entities.add(creatInstance(new RString("2014, 03, 14, 18, 45, 05")));
        return entities;
    }

    @Override
    public List<DbT5022RenkeiyoDataSofuKirokuEntity> selectAll(SaiSoufuKubun 再送付区分) {

        List<DbT5022RenkeiyoDataSofuKirokuEntity> entities = new ArrayList<>();
        entities.add(creatInstance(new RString("01")));
        return entities;
    }

    @Override
    public List<DbT5022RenkeiyoDataSofuKirokuEntity> selectAll(SaiChousaSoufuKubun 再調査送付区分) {

        List<DbT5022RenkeiyoDataSofuKirokuEntity> entities = new ArrayList<>();
        entities.add(creatInstance(new RString("0")));
        return entities;
    }

    @Override
    public List<DbT5022RenkeiyoDataSofuKirokuEntity> selectAll(SaiIkenshoSoufuKubun 再意見書送付区分) {

        List<DbT5022RenkeiyoDataSofuKirokuEntity> entities = new ArrayList<>();
        entities.add(creatInstance(new RString("0")));
        return entities;
    }

    @Override
    public int delete(DbT5022RenkeiyoDataSofuKirokuEntity data) {
        if (data.getShinseishoKanriNo().getColumnValue().equals(削除可能な申請書管理番号)) {
            return 1;
        }
        return 0;
    }

    @Override
    public int insertOrUpdate(DbT5022RenkeiyoDataSofuKirokuEntity entity) {
        if (entity.getShinseishoKanriNo().getColumnValue().equals(登録可能な申請書管理番号)) {
            return 1;
        }
        return 0;
    }

//    @Override
    public int insert(DbT5022RenkeiyoDataSofuKirokuEntity entity) {
        if (entity.getShinseishoKanriNo().getColumnValue().equals(登録可能な申請書管理番号)) {
            return 1;
        }
        return 0;
    }

//    @Override
    public int update(DbT5022RenkeiyoDataSofuKirokuEntity entity) {
        if (entity.getShinseishoKanriNo().getColumnValue().equals(登録可能な申請書管理番号)) {
            return 1;
        }
        return 0;
    }
}
