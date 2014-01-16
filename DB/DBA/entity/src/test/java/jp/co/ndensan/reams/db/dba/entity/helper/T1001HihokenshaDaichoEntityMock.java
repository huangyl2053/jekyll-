/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.entity.helper;

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
        entity.setShikibetsuCode(new RString("012345678912345"));
        entity.setShikakuIdouKubunCode(new RString("資格取得"));
        entity.setShikakuShutokuTodokedeDate(new RDate("20140116"));
        entity.setShikakuShutokuJiyuCode(new RString("000"));
        entity.setShikakuShutokuDate(new RDate("20140116"));
        entity.setIchigoHihokenshaNenreiTotatsuDate(new RDate("20140116"));
        entity.setHihokennshaKubunCode(new RString("第1号被保険者"));
        entity.setShikakuSoshitsuJiyuCode(RString.EMPTY);
        entity.setShikakuSoshitsuTodokedeDate(RDate.MAX);
        entity.setShikakuSoshitsuDate(RDate.MAX);
        entity.setShikakuHenkoJiyuCode(RString.EMPTY);
        entity.setShikakuHenkoTodokedeDate(RDate.MAX);
        entity.setShikakuHenkoDate(RDate.MAX);
        entity.setJushochiTokureiTekiyoJiyuCode(RString.EMPTY);
        entity.setTekiyoTodokedeDate(RDate.MAX);
        entity.setTekiyoDate(RDate.MAX);
        entity.setJushochiTokureikaijoJiyuCode(RString.EMPTY);
        entity.setKaijoTodokedeDate(RDate.MAX);
        entity.setKaijoDate(RDate.MAX);
        entity.setJushochiTokureiFlag(false);
        entity.setKoikinaiJushochiTokureiFlag(false);
        entity.setKoikinaiTokureiSochimotoShichosonCd(RString.EMPTY);
        entity.setSaikofuKubun(false);
        entity.setSaikofuJiyuCode(RString.EMPTY);

        return spy(entity);
    }
}
