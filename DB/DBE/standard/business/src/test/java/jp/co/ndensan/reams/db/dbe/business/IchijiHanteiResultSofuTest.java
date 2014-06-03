/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business;

import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.IchijiHanteiResultSofuKubun;
import jp.co.ndensan.reams.db.dbz.testhelper.DbeTestBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.cast._CastDataTypeFactory;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * 一次判定結果送付のテストです。
 *
 * @author n8178 城間篤人
 */
@RunWith(Enclosed.class)
public class IchijiHanteiResultSofuTest {

    public static class 未送付を表す定数のテスト extends DbeTestBase {

        @Test
        public void 送付区分は_未送付になる() {
            assertThat(IchijiHanteiResultSofu.MI_SOFU.get一次判定結果送付区分(), is(IchijiHanteiResultSofuKubun.未送付));
        }

        @Test
        public void 送付年月日は_日付の最小の値になる() {
            assertThat(IchijiHanteiResultSofu.MI_SOFU.get一次判定結果送付年月日(), is(FlexibleDate.MIN));
        }
    }

}
