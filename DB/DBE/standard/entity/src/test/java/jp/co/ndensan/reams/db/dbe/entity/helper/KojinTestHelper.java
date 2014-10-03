/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.helper;

import jp.co.ndensan.reams.ur.urz.business.jusho.IJusho;
import jp.co.ndensan.reams.ur.urz.business.shikibetsutaisho.IKojin;
import jp.co.ndensan.reams.ur.urz.business.shikibetsutaisho.IName;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.biz.ZenkokuJushoCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.mockito.Mockito.*;

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
        when(kojin.get氏名()).thenReturn(name);
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
        YubinNo yubinNo = new YubinNo(new RString("382-0034"));
        RString value = new RString("町域");
        IJusho jusho = mock(IJusho.class);
        when(jusho.get全国住所コード()).thenReturn(jushoCd);
        when(jusho.get住所()).thenReturn(value);
        when(jusho.get郵便番号()).thenReturn(yubinNo);
        return jusho;
    }
}
