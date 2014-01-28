/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.definition.valueobject;

import jp.co.ndensan.reams.db.dba.definition.valueobject.ShikakuHenkoJiyu;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.testhelper.TestBase;
import org.junit.Test;

/**
 * 資格変更事由のテストクラスです。
 *
 * @author N3327 三浦 凌
 */
public class ShikakuHenkoJiyuTest extends TestBase {

    private ShikakuHenkoJiyu sut;

    @Test(expected = NullPointerException.class)
    public void コンストラクタのcodeにnullを指定したとき_NullPointerExceptionを返す() {
        sut = new ShikakuHenkoJiyu(null, new RString("name"));
    }

    @Test(expected = NullPointerException.class)
    public void コンストラクタのnameにnullを指定したとき_NullPointerExceptionを返す() {
        sut = new ShikakuHenkoJiyu(new RString("code"), null);
    }
}
