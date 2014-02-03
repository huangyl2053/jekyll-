/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.realservice.helper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dba.definition.enumeratedtype.ShikakuIdoKubun;
import jp.co.ndensan.reams.db.dba.entity.basic.DbT1001HihokenshaDaichoEntity;
import jp.co.ndensan.reams.db.dba.standard.basic.IHihokenshaDaichoDac;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.KaigoHihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ShichosonCode;
import jp.co.ndensan.reams.ur.urz.business.shikibetsutaisho.IShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.mockito.Mockito.*;

/**
 * T1001HihokenshaDaichoEntityのMockクラスです。
 *
 * @author N3327 三浦 凌
 */
public class HihokenshaDaichoDacMock implements IHihokenshaDaichoDac {

    public static RString 検索不可な被保険者番号 = new RString("検索不可");
    public static RString 検索不可な識別コード = new RString("検索不可");
    public static RString 削除可能な市町村コード = new RString("deletable");
    public static RString 削除可能な被保険者番号 = new RString("deletable");

    public static DbT1001HihokenshaDaichoEntity getSpiedInstance() {

        DbT1001HihokenshaDaichoEntity entity = new DbT1001HihokenshaDaichoEntity();

        entity.setShichosonCd(new RString("12345"));
        entity.setHihokenshaNo(new RString("0123456789"));
        entity.setShikibetsuCode(ShikibetsuCodeMock.createInstance(new RString("100000000000000")));
        entity.setShikakuIdouKubunCode(ShikakuIdoKubun.資格取得.getCode());
        entity.setShikakuShutokuTodokedeDate(new RDate("20140116"));
        entity.setShikakuShutokuJiyuCode(new RString("年齢到達"));
        entity.setShikakuShutokuDate(new RDate("20140116"));
        entity.setIchigoHihokenshaNenreiTotatsuDate(new RDate("20140116"));
        entity.setHihokenshaKubunCode(new RString("第1号被保険者"));
        entity.setShikakuSoshitsuJiyuCode(RString.EMPTY);
        entity.setShikakuSoshitsuTodokedeDate(RDate.MAX);
        entity.setShikakuSoshitsuDate(RDate.MAX);
        entity.setShikakuHenkoJiyuCode(RString.EMPTY);
        entity.setShikakuHenkoTodokedeDate(null);
        entity.setShikakuHenkoDate(null);
        entity.setJushochitokureiTekiyoJiyuCode(RString.EMPTY);
        entity.setJushochitokureiTekiyoTodokedeDate(null);
        entity.setJushochitokureiTekiyoDate(null);
        entity.setJushochitokureiKaijoJiyuCode(RString.EMPTY);
        entity.setJushochitokureiKaijoTodokedeDate(null);
        entity.setJushochitokureiKaijoDate(null);
        entity.setJushochitokureiFlag(false);
        entity.setKoikinaiJushochitokureiFlag(false);
        entity.setKoikinaiTokureiSochimotoShichosonCd(RString.EMPTY);
        entity.setSaikofuKubun(false);
        entity.setSaikofuJiyuCode(RString.EMPTY);

        return spy(entity);
    }

    private DbT1001HihokenshaDaichoEntity createInstance(RString 市町村コード, RString 被保険者番号, RString 識別コード) {
        DbT1001HihokenshaDaichoEntity entity = getSpiedInstance();
        when(entity.getShichosonCd()).thenReturn(市町村コード);
        when(entity.getHihokenshaNo()).thenReturn(被保険者番号);
        when(entity.getShikibetsuCode()).thenReturn(ShikibetsuCodeMock.createInstance(識別コード));
        return entity;
    }

    @Override
    public DbT1001HihokenshaDaichoEntity select(ShichosonCode 市町村コード, KaigoHihokenshaNo 被保険者番号) {
        if (被保険者番号.getValue().equals(検索不可な被保険者番号)) {
            return null;
        }
        return createInstance(市町村コード.getValue(), 被保険者番号.getValue(), new RString("識別コード"));
    }

    @Override
    public List<DbT1001HihokenshaDaichoEntity> select(KaigoHihokenshaNo 被保険者番号) {
        if (被保険者番号.getValue().equals(検索不可な被保険者番号)) {
            return Collections.EMPTY_LIST;
        }
        List<DbT1001HihokenshaDaichoEntity> entities = new ArrayList<>();
        entities.add(createInstance(new RString("市町村コード"), 被保険者番号.getValue(), new RString("識別コード")));
        return entities;
    }

    @Override
    public List<DbT1001HihokenshaDaichoEntity> select(ShichosonCode 市町村コード, IShikibetsuCode 識別コード) {
        if (識別コード.getValue().equals(検索不可な識別コード)) {
            return Collections.EMPTY_LIST;
        }
        List<DbT1001HihokenshaDaichoEntity> entities = new ArrayList<>();
        entities.add(createInstance(市町村コード.getValue(), new RString("介護保険被保険者番号"), 識別コード.getValue()));
        return entities;
    }

    @Override
    public List<DbT1001HihokenshaDaichoEntity> select(IShikibetsuCode 識別コード) {
        if (識別コード.getValue().equals(検索不可な識別コード)) {
            return Collections.EMPTY_LIST;
        }
        List<DbT1001HihokenshaDaichoEntity> entities = new ArrayList<>();
        entities.add(createInstance(new RString("市町村コード"), new RString("介護保険被保険者番号"), 識別コード.getValue()));
        return entities;
    }

    @Override
    public int insert(DbT1001HihokenshaDaichoEntity data) {
        return 1;
    }

    @Override
    public int delete(DbT1001HihokenshaDaichoEntity data) {
        if (data.getShichosonCd().equals(削除可能な市町村コード) && data.getHihokenshaNo().equals(削除可能な被保険者番号)) {
            return 1;
        }
        return 0;
    }

    @Override
    public int update(DbT1001HihokenshaDaichoEntity data) {
        return 1;
    }

    @Override
    public int insertOrUpdate(DbT1001HihokenshaDaichoEntity entity) {
        return 1;
    }
}
