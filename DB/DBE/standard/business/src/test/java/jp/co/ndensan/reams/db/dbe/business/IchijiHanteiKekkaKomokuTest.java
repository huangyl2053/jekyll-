/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business;

import jp.co.ndensan.reams.db.dbe.definition.valueobject.IchijiHanteiKekkaCode;
import jp.co.ndensan.reams.db.dbz.testhelper.DbeTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.Before;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * 一次判定結果項目のテストです。
 *
 * @author n8178 城間篤人
 */
@RunWith(Enclosed.class)
public class IchijiHanteiKekkaKomokuTest {

    private static IchijiHanteiKekkaKomoku sut;

    public static class get一次判定結果コードのテスト extends DbeTestBase {

        @Before
        public void setUp() {
            sut = new IchijiHanteiKekkaKomoku(new IchijiHanteiKekkaCode(new RString("001")), new RString("名称"));
        }

        @Test
        public void get一次判定結果コードと_getCodeの内容が同一になる() {
            assertThat(sut.get一次判定結果コード().value(), is(sut.getCode().value()));
        }
    }
}
