/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business;

import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.ShinsakaiIinShukketsuKubun;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.TimeString;
import jp.co.ndensan.reams.db.dbz.testhelper.DbeTestBase;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Range;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.Before;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import static org.mockito.Mockito.mock;

/**
 * 審査会割当委員のテストです。
 *
 * @author n8178 城間篤人
 */
@RunWith(Enclosed.class)
public class ShinsakaiWariateIinTest {

    private static ShinsakaiWariateIin sut;

    public static class コンストラクタのテスト extends DbeTestBase {

        private ShinsakaiDetail 審査会情報;
        private ShinsakaiIin 委員情報;
        private ShinsainKubun 認定審査員区分;
        private GogitaichoKubun 合議体長区分;
        private Range<TimeString> 審査時間;
        private ShinsakaiIinShukketsuKubun 出欠区分;

        @Before
        public void setUp() {
            審査会情報 = mock(ShinsakaiDetail.class);
            委員情報 = mock(ShinsakaiIin.class);
            認定審査員区分 = new ShinsainKubun(new Code("A001"), RString.EMPTY, RString.EMPTY);
            合議体長区分 = new GogitaichoKubun(new Code("A001"), RString.EMPTY, RString.EMPTY);
            審査時間 = new Range(FlexibleDate.MIN, FlexibleDate.MAX);
            出欠区分 = ShinsakaiIinShukketsuKubun.遅刻;
        }

        @Test(expected = NullPointerException.class)
        public void 審査会情報にnullが渡されたとき_NullPointerExceptionが発生する() {
            sut = new ShinsakaiWariateIin(null, 委員情報, 認定審査員区分, 合議体長区分, 審査時間, 出欠区分);
        }

        @Test(expected = NullPointerException.class)
        public void 委員情報にnullが渡されたとき_NullPointerExceptionが発生する() {
            sut = new ShinsakaiWariateIin(審査会情報, null, 認定審査員区分, 合議体長区分, 審査時間, 出欠区分);
        }

        @Test
        public void 必須項目が渡されたとき_インスタンスが生成される() {
            sut = new ShinsakaiWariateIin(審査会情報, 委員情報, null, null, null, null);
            assertThat(sut, is(instanceOf(ShinsakaiWariateIin.class)));
        }
    }
}
