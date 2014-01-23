/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.definition.valueobject;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import org.junit.Test;

/**
 * 再交付事由のテストクラスです。
 *
 * @author N3327 三浦 凌
 */
public class SaikofuJiyuTest {

    private SaikofuJiyu sut;

    @Test(expected = NullPointerException.class)
    public void コンストラクタのcodeにnullを指定したとき_NullPointerExceptionを返す() {
        sut = new SaikofuJiyu(null, new RString("name"));
    }

    @Test(expected = NullPointerException.class)
    public void コンストラクタのnameにnullを指定したとき_NullPointerExceptionを返す() {
        sut = new SaikofuJiyu(new RString("code"), null);
    }
}
