/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.util;

import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link jp.co.ndensan.reams.db.dbz.divcontroller.util.ViewExecutionStatus}のテストです。
 *
 * @author n8178 城間篤人
 */
@RunWith(Enclosed.class)
public class ViewExecutionStatusTest {

    public static ViewExecutionStatus sut;

    public static class toValue extends DbzTestBase {

        @Test
        public void 引数に_文字列Addが渡されたとき_戻り値にAddが返る() {
            sut = ViewExecutionStatus.toValue(new RString("Add"));
            assertThat(sut == ViewExecutionStatus.Add, is(true));
        }

        @Test
        public void 引数に_文字列Modifyが渡されたとき_戻り値にModifyが返る() {
            sut = ViewExecutionStatus.toValue(new RString("Modify"));
            assertThat(sut == ViewExecutionStatus.Modify, is(true));
        }

        @Test
        public void 引数に文字列Deleteが渡されたとき_戻り値にDeleteが返る() {
            sut = ViewExecutionStatus.toValue(new RString("Delete"));
            assertThat(sut == ViewExecutionStatus.Delete, is(true));
        }

        @Test
        public void 引数に_文字列Noneが渡されたとき_戻り値にNoneが返る() {
            sut = ViewExecutionStatus.toValue(new RString("None"));
            assertThat(sut == ViewExecutionStatus.None, is(true));
        }

        @Test(expected = IllegalArgumentException.class)
        public void 引数に_対応するステータスが存在しない文字列が渡されたとき_IllegalArgumentExceptionが発生する() {
            sut = ViewExecutionStatus.toValue(new RString("更新するふり"));
            fail();
        }
    }

}
