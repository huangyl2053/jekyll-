/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.definition.valueobject;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.testhelper.TestBase;
import org.junit.Test;

/**
 * 被保険者区分のテストクラスです。
 *
 * @author N3327 三浦 凌
 */
public class HihokenshaKubunTest extends TestBase {

    private HihokenshaKubun sut;

    @Test(expected = NullPointerException.class)
    public void コンストラクタのcodeにnullを指定したとき_NullPointerExceptionを返す() {
        sut = new HihokenshaKubun(null, new RString("name"));
    }

    @Test(expected = NullPointerException.class)
    public void コンストラクタのnameにnullを指定したとき_NullPointerExceptionを返す() {
        sut = new HihokenshaKubun(new RString("code"), null);
    }
}
