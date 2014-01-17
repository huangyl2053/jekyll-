/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.persistence.basic.helper;

import jp.co.ndensan.reams.db.dba.definition.ShikakuIdoKubun;
import jp.co.ndensan.reams.db.dba.entity.T1001HihokenshaDaichoEntity;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.mockito.Mockito.*;

/**
 * T1001HihokenshaDaichoEntityのMockクラスです。
 *
 * @author N3327 三浦 凌
 */
public class T1001HihokenshaDaichoEntityMock {

    public static T1001HihokenshaDaichoEntity getSpiedInstance() {

        T1001HihokenshaDaichoEntity entity = new T1001HihokenshaDaichoEntity();

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
        entity.setJushochiTokureiTekiyoJiyuCode(RString.EMPTY);
        entity.setTekiyoTodokedeDate(null);
        entity.setTekiyoDate(null);
        entity.setJushochiTokureikaijoJiyuCode(RString.EMPTY);
        entity.setKaijoTodokedeDate(null);
        entity.setKaijoDate(null);
        entity.setJushochiTokureiFlag(false);
        entity.setKoikinaiJushochiTokureiFlag(false);
        entity.setKoikinaiTokureiSochimotoShichosonCd(RString.EMPTY);
        entity.setSaikofuKubun(false);
        entity.setSaikofuJiyuCode(RString.EMPTY);

        return spy(entity);
    }

    public static T1001HihokenshaDaichoEntity createInstance(RString 市町村コード, RString 被保険者番号, RString 識別コード) {
        T1001HihokenshaDaichoEntity entity = getSpiedInstance();
        when(entity.getShichosonCd()).thenReturn(市町村コード);
        when(entity.getHihokenshaNo()).thenReturn(被保険者番号);
        when(entity.getShikibetsuCode()).thenReturn(ShikibetsuCodeMock.createInstance(識別コード));
        return entity;
    }
}
