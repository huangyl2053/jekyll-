/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.core;

import jp.co.ndensan.reams.db.dbx.definition.core.GaitoHigaitoKubun;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;

/**
 * GaitoHigaitoKubunのTestです。
 *
 * @author N3317 塚田 萌
 */
@RunWith(Enclosed.class)
public class GaitoHigaitoKubunTest extends DbzTestBase {

    public static class ToValue extends DbzTestBase {

        @Test
        public void toValueは_指定のコードに対応する列挙子があれば_それを返す() {
            GaitoHigaitoKubun sut = GaitoHigaitoKubun.該当;
            assertThat(GaitoHigaitoKubun.toValue(sut.getCode()), is(sut));
        }

        @Test(expected = IllegalArgumentException.class)
        public void toValueは_指定のコードに対応する列挙子がなければ_IllegalArgumentExceptionを返す() {
            GaitoHigaitoKubun sut = GaitoHigaitoKubun.toValue(new RString("9"));
        }
    }
}
