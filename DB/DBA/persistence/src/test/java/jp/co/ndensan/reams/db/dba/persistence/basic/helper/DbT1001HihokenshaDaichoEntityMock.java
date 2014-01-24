/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.persistence.basic.helper;

import jp.co.ndensan.reams.db.dba.definition.enumeratedtype.ShikakuIdoKubun;
import jp.co.ndensan.reams.db.dba.entity.basic.DbT1001HihokenshaDaichoEntity;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.mockito.Mockito.*;

/**
 * T1001HihokenshaDaichoEntityのMockクラスです。
 *
 * @author N3327 三浦 凌
 */
public class DbT1001HihokenshaDaichoEntityMock {

    public static DbT1001HihokenshaDaichoEntity getSpiedInstance() {

        DbT1001HihokenshaDaichoEntity entity = new DbT1001HihokenshaDaichoEntity();

        entity.setShichosonCd(new RString("12345"));
        entity.setHihokenshaNo(new RString("0123456789"));
        entity.setShikibetsuCode(ShikibetsuCodeMock.createInstance(new RString("012345678912345")));
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

    public static DbT1001HihokenshaDaichoEntity getSpiedInstance(RString 市町村コード, RString 被保険者番号, RString 識別コード) {
        DbT1001HihokenshaDaichoEntity entity = getSpiedInstance();
        when(entity.getShichosonCd()).thenReturn(市町村コード);
        when(entity.getHihokenshaNo()).thenReturn(被保険者番号);
        when(entity.getShikibetsuCode()).thenReturn(ShikibetsuCodeMock.createInstance(識別コード));
        return entity;
    }
}
