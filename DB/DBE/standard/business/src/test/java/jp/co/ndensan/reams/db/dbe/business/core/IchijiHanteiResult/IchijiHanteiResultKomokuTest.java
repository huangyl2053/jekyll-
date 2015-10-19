/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.IchijiHanteiResult;

import jp.co.ndensan.reams.db.dbe.business.core.IchijiHanteiResult.IchijiHanteiResultKomoku;
import jp.co.ndensan.reams.db.dbz.testhelper.DbeTestBase;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * 一次判定結果項目のテストです。
 *
 * @author n8178 城間篤人
 */
@RunWith(Enclosed.class)
public class IchijiHanteiResultKomokuTest {

    private static IchijiHanteiResultKomoku sut;

    public static class get一次判定結果コードのテスト extends DbeTestBase {

        @Before
        public void setUp() {
            sut = new IchijiHanteiResultKomoku(new Code(new RString("001")), new RString("名称"), new RString("略称"));
        }

        @Test
        public void get一次判定結果コードと_getCodeの内容が同一になる() {
            assertThat(sut.get一次判定結果コード().value(), is(sut.get一次判定結果コード().asCode().value()));
        }
    }
}
