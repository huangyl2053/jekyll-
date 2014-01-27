/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.standard.definition.valueobject;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.testhelper.TestBase;
import org.junit.Test;

/**
 * 住所地特例解除事由のテストクラスです。
 *
 * @author N3327 三浦 凌
 */
public class JushochitokureiKaijoJiyuTest extends TestBase {

    private JushochitokureiKaijoJiyu sut;

    @Test(expected = NullPointerException.class)
    public void コンストラクタのcodeにnullを指定したとき_NullPointerExceptionを返す() {
        sut = new JushochitokureiKaijoJiyu(null, new RString("name"));
    }

    @Test(expected = NullPointerException.class)
    public void コンストラクタのnameにnullを指定したとき_NullPointerExceptionを返す() {
        sut = new JushochitokureiKaijoJiyu(new RString("code"), null);
    }
}
