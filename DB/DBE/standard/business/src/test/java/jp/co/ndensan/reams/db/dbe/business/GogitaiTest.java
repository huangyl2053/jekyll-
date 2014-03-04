/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business;

import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.GogitaiDummyFlag;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.GogitaiSeishinkaIshiSonzai;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.GogitaiMeisho;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.GogitaiNo;
import jp.co.ndensan.reams.db.dbz.testhelper.DbeTestBase;
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
 * 合議体のテストです。
 *
 * @author n8178 城間篤人
 */
@RunWith(Enclosed.class)
public class GogitaiTest {

    private static Gogitai sut;

    public static class コンストラクタのテスト extends DbeTestBase {

        private GogitaiNo 合議体番号;
        private GogitaiMeisho 合議体名称;
        private Range<FlexibleDate> 有効期間;
        private Range<RString> 開始終了予定時刻;
        private ShinsakaiKaisaiBasho 審査会開催場所;
        private int 審査会予定定員;
        private int 審査会自動割当定員;
        private int 審査会委員定員;
        private GogitaiWariateIinList 合議体割当審査会委員List;
        private GogitaiSeishinkaIshiSonzai 精神科医師存在;
        private GogitaiDummyFlag 合議体ダミー;

        @Before
        public void setUp() {
            合議体番号 = new GogitaiNo(1);
            合議体名称 = new GogitaiMeisho(RString.EMPTY);
            有効期間 = mock(Range.class);
            開始終了予定時刻 = mock(Range.class);
            審査会開催場所 = mock(ShinsakaiKaisaiBasho.class);
            審査会予定定員 = 5;
            審査会自動割当定員 = 4;
            審査会委員定員 = 6;
            合議体割当審査会委員List = mock(GogitaiWariateIinList.class);
            精神科医師存在 = GogitaiSeishinkaIshiSonzai.存在;
            合議体ダミー = GogitaiDummyFlag.NO;
        }

        @Test
        public void 必要項目が引数に渡されているとき_インスタンスが生成される() {
            sut = new Gogitai(合議体番号, 合議体名称, 有効期間, 開始終了予定時刻, 審査会開催場所,
                    0, 0, 0, null, null, null);
            assertThat(sut, is(instanceOf(Gogitai.class)));
        }

        @Test(expected = NullPointerException.class)
        public void 合議体番号にnullが渡されたとき_NullPointerExceptionが発生する() {
            sut = new Gogitai(null, 合議体名称, 有効期間, 開始終了予定時刻, 審査会開催場所,
                    審査会予定定員, 審査会自動割当定員, 審査会委員定員, 合議体割当審査会委員List,
                    精神科医師存在, 合議体ダミー);
        }

        @Test(expected = NullPointerException.class)
        public void 合議体名称にnullが渡されたとき_NullPointerExceptionが発生する() {
            sut = new Gogitai(合議体番号, null, 有効期間, 開始終了予定時刻, 審査会開催場所,
                    審査会予定定員, 審査会自動割当定員, 審査会委員定員, 合議体割当審査会委員List,
                    精神科医師存在, 合議体ダミー);
        }

        @Test(expected = NullPointerException.class)
        public void 有効期間にnullが渡されたとき_NullPointerExceptionが発生する() {
            sut = new Gogitai(合議体番号, 合議体名称, null, 開始終了予定時刻, 審査会開催場所,
                    審査会予定定員, 審査会自動割当定員, 審査会委員定員, 合議体割当審査会委員List,
                    精神科医師存在, 合議体ダミー);
        }

        @Test(expected = NullPointerException.class)
        public void 開始終了予定時刻にnullが渡されたとき_NullPointerExceptionが発生する() {
            sut = new Gogitai(合議体番号, 合議体名称, 有効期間, null, 審査会開催場所,
                    審査会予定定員, 審査会自動割当定員, 審査会委員定員, 合議体割当審査会委員List,
                    精神科医師存在, 合議体ダミー);
        }

        @Test(expected = NullPointerException.class)
        public void 審査会開催場所にnullが渡されたとき_NullPointerExceptionが発生する() {
            sut = new Gogitai(合議体番号, 合議体名称, 有効期間, 開始終了予定時刻, null,
                    審査会予定定員, 審査会自動割当定員, 審査会委員定員, 合議体割当審査会委員List,
                    精神科医師存在, 合議体ダミー);
        }
    }
}
