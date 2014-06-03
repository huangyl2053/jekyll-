/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.realservice.helper;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.ShinsakaiKaisaiBashoJokyo;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.ShinsakaiKaisaiChiku;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.ShinsakaiKaisaiBashoCode;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5104ShinsakaiKaisaiBashoJohoEntity;
import jp.co.ndensan.reams.db.dbe.persistence.basic.ShinsakaiKaisaiBashoDac;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.mockito.Mockito.*;

/**
 * D5104ShinsakaiKaisaiBashoJohoEntityのMockクラスです
 *
 * @author N1013 松本直樹
 */
public class ShinsakaiKaisaiBashoDacMock extends ShinsakaiKaisaiBashoDac {

    public static RString 検索不可な開催場所コード = new RString("検索不可");
    private static ShinsakaiKaisaiBashoCode kaisaiBashoCode;
    private static ShinsakaiKaisaiChiku kaisaiBashoChikuCode;

    public static DbT5104ShinsakaiKaisaiBashoJohoEntity getSpiedInstance() {

        DbT5104ShinsakaiKaisaiBashoJohoEntity entity = new DbT5104ShinsakaiKaisaiBashoJohoEntity();
        kaisaiBashoCode = mock(ShinsakaiKaisaiBashoCode.class);
        kaisaiBashoCode = new ShinsakaiKaisaiBashoCode(new RString("00001"));
        kaisaiBashoChikuCode = mock(ShinsakaiKaisaiChiku.class);
        kaisaiBashoChikuCode = new ShinsakaiKaisaiChiku(new RString("00001"), new RString("地区名称"));

        entity.setShinsakaiKaisaiBashoCode(kaisaiBashoCode.value());
        entity.setShinsakaiKaisaiBashoMei(new RString("市役所会議室"));
        entity.setShinsakaiKaisaiChikuCode(new Code(new RString("00001")));
        entity.setShinsakaiKaisaiBashoJusho(new AtenaJusho(new RString("長野市鶴賀")));
        entity.setShinsakaiKaisaiBashoTelNo(new TelNo(new RString("026-222-3333")));
        entity.setShinsakaiKaisaiBashoJokyo(true);

        entity = spy(entity);
        doReturn(new RString("meisho")).when(entity).getShinsakaiKaisaiChikuCodeMeisho();
        doReturn(new RString("meisho")).when(entity).getShinsakaiKaisaiChikuCodeRyakusho();
        return entity;

    }

    private DbT5104ShinsakaiKaisaiBashoJohoEntity createInstance(ShinsakaiKaisaiBashoCode 開催場所コード, RString 開催場所名称) {
        DbT5104ShinsakaiKaisaiBashoJohoEntity entity = getSpiedInstance();
        return entity;
    }

    @Override
    public DbT5104ShinsakaiKaisaiBashoJohoEntity select(ShinsakaiKaisaiBashoCode 審査会開催場所) {
        if (審査会開催場所.value().equals(検索不可な開催場所コード)) {
            return null;
        }
        return createInstance(審査会開催場所, new RString("開催場所名称"));
    }

    @Override
    public DbT5104ShinsakaiKaisaiBashoJohoEntity select(ShinsakaiKaisaiBashoCode 審査会開催場所, ShinsakaiKaisaiBashoJokyo 開催場所状況) {
        if (審査会開催場所.value().equals(検索不可な開催場所コード)) {
            return null;
        }
        return createInstance(審査会開催場所, new RString("開催場所名称"));

    }

    @Override
    public List<DbT5104ShinsakaiKaisaiBashoJohoEntity> selectAll() {
        List<DbT5104ShinsakaiKaisaiBashoJohoEntity> entities = new ArrayList<>();
        entities.add(createInstance(new ShinsakaiKaisaiBashoCode(new RString("00001")), new RString("開催場所名称")));
        entities.add(createInstance(new ShinsakaiKaisaiBashoCode(new RString("00002")), new RString("開催場所名称")));
        return entities;
    }

    @Override
    public List<DbT5104ShinsakaiKaisaiBashoJohoEntity> selectAll(ShinsakaiKaisaiBashoJokyo 開催場所状況) {
        List<DbT5104ShinsakaiKaisaiBashoJohoEntity> entities = new ArrayList<>();
        entities.add(createInstance(new ShinsakaiKaisaiBashoCode(new RString("00001")), new RString("開催場所名称")));
        return entities;
    }

    @Override
    public int insertOrUpdate(DbT5104ShinsakaiKaisaiBashoJohoEntity entity) {
        return 1;
    }

    @Override
    public int delete(DbT5104ShinsakaiKaisaiBashoJohoEntity entity) {
        if (entity.getShinsakaiKaisaiBashoCode().equals(検索不可な開催場所コード)) {
            return 0;
        } else {
            return 1;
        }
    }

    @Override
    public int insert(DbT5104ShinsakaiKaisaiBashoJohoEntity data) {
        return 1;
    }

    @Override
    public int update(DbT5104ShinsakaiKaisaiBashoJohoEntity data) {
        return 1;
    }
}
