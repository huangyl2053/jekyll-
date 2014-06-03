/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business;

import jp.co.ndensan.reams.db.dbz.testhelper.DbeTestBase;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * 一次判定警告のテストです。
 *
 * @author n8178 城間篤人
 */
@RunWith(Enclosed.class)
public class IchijiHanteiKeikokuTest {

    private static IchijiHanteiKeikoku sut;

    public static class get一次判定警告コードのテスト extends DbeTestBase {

        @Before
        public void setUp() {
            sut = new IchijiHanteiKeikoku(new Code(new RString("001")), new RString("名称"), new RString("略称"));
        }

        @Test
        public void get一次判定警告コードと_getCodeの内容が同一になる() {
            assertThat(sut.get一次判定警告コード().value(), is(sut.getCode().value()));
        }
    }
}
