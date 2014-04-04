/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.GogitaiDummyKubun;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.GogitaiSeishinkaIshiSonzaiKubun;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.GogitaiNo;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.GogitaiYukoKikanKaishiDate;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.ShinsakaiIinCode;
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
import static org.mockito.Mockito.when;

/**
 * 合議体割当委員Listのテストです。
 *
 * @author n8178 城間篤人
 */
@RunWith(Enclosed.class)
public class GogitaiWariateIinListTest {

    private static GogitaiWariateIinList sut;

    public static class コンストラクタのテスト extends DbeTestBase {

        @Test(expected = NullPointerException.class)
        public void 引数にNullが渡されたとき_NullPointerExceptionが発生する() {
            new GogitaiWariateIinList(null);
        }
    }

    public static class get合議体割当委員のテスト extends DbeTestBase {

        @Before
        public void setUp() {
            List<GogitaiWariateIin> 合議体割当委員List = new ArrayList<>();
            合議体割当委員List.add(create合議体割当委員("0001", create合議体情報(1, "19990101")));
            合議体割当委員List.add(create合議体割当委員("0002", create合議体情報(2, "20010204")));
            合議体割当委員List.add(create合議体割当委員("0003", create合議体情報(3, "20050508")));
            sut = new GogitaiWariateIinList(合議体割当委員List);
        }

        @Test
        public void 合議体番号1_有効期間開始年月日19990101を持つ合議体情報と_審査委員コード0001を指定したとき_対応する合議体割当委員が取得できる() {
            GogitaiWariateIin result = sut.get合議体割当委員(new GogitaiNo(1), new GogitaiYukoKikanKaishiDate("19990101"), create委員コード("0001"));
            assertThat(result.get委員情報().get委員コード(), is(create委員コード("0001")));
        }

        @Test(expected = IllegalArgumentException.class)
        public void 指定した審査会委員コードに対応する合議体割当委員が存在しないとき_IllegalArgumentExceptionが発生する() {
            GogitaiWariateIin result = sut.get合議体割当委員(new GogitaiNo(33), new GogitaiYukoKikanKaishiDate("26641212"), create委員コード("9999"));
        }

        private GogitaiWariateIin create合議体割当委員(String str, GogitaiDetail 合議体情報) {
            ShinsakaiIin 審査会委員 = mock(ShinsakaiIin.class);
            ShinsakaiIinCode shinsakaiIinCode = create委員コード(str);
            when(審査会委員.get委員コード()).thenReturn(shinsakaiIinCode);

            GogitaiWariateIin 割当委員 = mock(GogitaiWariateIin.class);
            when(割当委員.get委員情報()).thenReturn(審査会委員);
            when(割当委員.get合議体情報()).thenReturn(合議体情報);
            return 割当委員;
        }

        private GogitaiDetail create合議体情報(int 合議体番号, String 開始年月日) {
            return new GogitaiDetail(new GogitaiNo(合議体番号), RString.EMPTY, new GogitaiYukoKikanKaishiDate(開始年月日),
                    FlexibleDate.MAX, mock(Range.class), mock(ShinsakaiKaisaiBasho.class), 1, 2, 3,
                    GogitaiSeishinkaIshiSonzaiKubun.存在, GogitaiDummyKubun.ダミー);
        }

        private ShinsakaiIinCode create委員コード(String str) {
            return new ShinsakaiIinCode(new RString(str));
        }
    }

    public static class sizeのテスト {

        @Test
        public void 要素数が3のリストを持つ場合_3が返る() {
            sut = new GogitaiWariateIinList(createMockList(3));
            assertThat(sut.size(), is(3));
        }
    }

    public static class isEmptyのテスト {

        @Test
        public void 空のリストを持つ場合_trueが返る() {
            sut = new GogitaiWariateIinList(Collections.EMPTY_LIST);
            assertThat(sut.isEmpty(), is(true));
        }

        @Test
        public void 空ではないリストを持つ場合_falseが返る() {
            sut = new GogitaiWariateIinList(createMockList(3));
            assertThat(sut.isEmpty(), is(false));
        }
    }

    private static List<GogitaiWariateIin> createMockList(int 要素数) {
        List<GogitaiWariateIin> retList = new ArrayList<>();
        for (int i = 0; i < 要素数; i++) {
            retList.add(mock(GogitaiWariateIin.class));
        }
        return retList;
    }
}
