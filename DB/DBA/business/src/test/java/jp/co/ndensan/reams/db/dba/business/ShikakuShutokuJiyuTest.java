/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.testhelper.TestBase;
import org.junit.Test;

/**
 * 資格取得事由のテストクラスです。
 *
 * @author N3327 三浦 凌
 */
public class ShikakuShutokuJiyuTest extends TestBase {

    private ShikakuShutokuJiyu sut;

    public ShikakuShutokuJiyuTest() {
    }

    @Test(expected = NullPointerException.class)
    public void コンストラクタのcodeにnullを指定したとき_NullPointerExceptionを返す() {
        sut = new ShikakuShutokuJiyu(null, new RString("てすと"));
    }

    @Test(expected = NullPointerException.class)
    public void コンストラクタのnameにnullを指定したとき_NullPointerExceptionを返す() {
        sut = new ShikakuShutokuJiyu(new RString("code"), null);
    }
}
