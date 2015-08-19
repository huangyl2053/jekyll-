/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.helper;

import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.kojin.IKojin;
import jp.co.ndensan.reams.ur.urz.business.core.jusho.IJusho;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.IName;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.biz.ZenkokuJushoCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * 個人のテストヘルパーです。
 *
 * @author N8187 久保田 英男
 */
public final class KojinTestHelper {

    public static IKojin create個人() {
        IKojin kojin = mock(IKojin.class);
        IJusho jusho = createJusho();
        IName name = createName();
        when(kojin.get住所()).thenReturn(jusho);
        when(kojin.get名称()).thenReturn(name);
        return kojin;
    }

    private static IName createName() {
        AtenaMeisho meisho = new AtenaMeisho(new RString("電算太郎"));
        AtenaKanaMeisho kanaMeisho = new AtenaKanaMeisho(new RString("デンサンタロウ"));
        IName name = mock(IName.class);
        when(name.getName()).thenReturn(meisho);
        when(name.getKana()).thenReturn(kanaMeisho);
        return name;
    }

    private static IJusho createJusho() {
        ZenkokuJushoCode jushoCd = new ZenkokuJushoCode("00000000010");
        YubinNo yubinNo = new YubinNo("382-0034");
        RString value = new RString("町域");
        IJusho jusho = mock(IJusho.class);
        when(jusho.get全国住所コード()).thenReturn(jushoCd);
        when(jusho.get住所()).thenReturn(value);
        when(jusho.get郵便番号()).thenReturn(yubinNo);
        return jusho;
    }
}
