/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.service.report.gemgengnintskettsucskobthakko;

import java.util.List;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import org.junit.Test;

/**
 *
 * @author wangchao
 */
public class GenmenGengakuNinteishoKetteiTsuchishoKobetsuHakkoTest {

    private final RString 折り返す符号 = new RString("\r\n");
    private final RString 通知書定型文 = new RString("　先に申請のありました、食費・居住費に係る負担限度額、利用者負担額減額・免除認定については\n"
            + "下記のとおり決定しましたので通知します。");

    /**
     * Test of createInstance method, of class GenmenGengakuNinteishoKetteiTsuchishoKobetsuHakko.
     */
    @Test
    public void testCreateInstance() {
        System.out.println("qqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqq");
        List<RString> 通知書定型文List = 通知書定型文.split(折り返す符号.toString());
        System.out.println(通知書定型文List.get(0));
        System.out.println(通知書定型文List.get(1));
        // TODO review the generated test code and remove the default call to fail.
    }
}
