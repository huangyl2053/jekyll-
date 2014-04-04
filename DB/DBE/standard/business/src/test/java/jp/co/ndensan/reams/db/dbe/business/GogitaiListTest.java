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
import jp.co.ndensan.reams.db.dbe.definition.valueobject.GogitaiYukoKikanKaishiYMD;
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
 * 合議体リストのテストです。
 *
 * @author n8178 城間篤人
 */
@RunWith(Enclosed.class)
public class GogitaiListTest {

    private static GogitaiList sut;

    public static class コンストラクタのテスト {

        @Test(expected = NullPointerException.class)
        public void 合議体Listにnullが渡されたとき_NullPointerExceptionが発生する() {
            sut = new GogitaiList(null);
        }
    }

    public static class GogitaiListのテスト extends DbeTestBase {

        @Before
        public void setUp() {
            sut = new GogitaiList(createList());
        }

        @Test
        public void 合議体番号に1_年月日に19991212_を持つ合議体情報を引数に渡したとき_戻り値の合議体が持つ合議体番号は1になる() {
            assertThat(sut.get合議体(new GogitaiNo(1), new GogitaiYukoKikanKaishiYMD("19991212")).get合議体情報().get合議体番号(),
                    is(new GogitaiNo(1)));
        }

        @Test
        public void 合議体番号に1_年月日に19991212_を持つ合議体情報を引数に渡したとき_戻り値の合議体が持つ合議体有効期間開始年月日は19991212になる() {
            assertThat(sut.get合議体(new GogitaiNo(1), new GogitaiYukoKikanKaishiYMD("19991212")).get合議体情報().get有効期間開始年月日(),
                    is(new GogitaiYukoKikanKaishiYMD("19991212")));
        }

        @Test(expected = IllegalArgumentException.class)
        public void 合議体番号に4_年月日に2028_12_12を指定して_該当する合議体が存在しないとき_IllegalArgumentExceptionが返る() {
            sut.get合議体(new GogitaiNo(4), new GogitaiYukoKikanKaishiYMD("20281212"));
        }

        private List<Gogitai> createList() {
            List<Gogitai> list = new ArrayList<>();
            list.add(createGogitai(1, "19991212"));
            list.add(createGogitai(2, "20000101"));
            list.add(createGogitai(3, "20040123"));
            return list;
        }

        private Gogitai createGogitai(int 合議体番号, String 有効期間開始年月日) {

            GogitaiDetail 合議体情報 = createGogitaiInfo(合議体番号, 有効期間開始年月日);
            Gogitai 合議体 = mock(Gogitai.class);
            when(合議体.get合議体情報()).thenReturn(合議体情報);
            return 合議体;
        }

        private GogitaiDetail createGogitaiInfo(int 合議体番号, String 有効期間開始年月日) {
            return new GogitaiDetail(new GogitaiNo(合議体番号), RString.EMPTY, new GogitaiYukoKikanKaishiYMD(有効期間開始年月日),
                    FlexibleDate.MAX, mock(Range.class), mock(ShinsakaiKaisaiBasho.class), 3, 4, 5,
                    GogitaiSeishinkaIshiSonzaiKubun.存在, GogitaiDummyKubun.ダミー);
        }
    }

    public static class isEmptyのテスト extends DbeTestBase {

        @Test
        public void 合議体Listが空であるとき_trueが返る() {
            sut = new GogitaiList(Collections.EMPTY_LIST);
            assertThat(sut.isEmpty(), is(true));
        }

        @Test
        public void 合議体Listが空でないとき_falseが返る() {
            sut = new GogitaiList(createMockList(3));
            assertThat(sut.isEmpty(), is(false));
        }
    }

    public static class sizeのテスト extends DbeTestBase {

        @Test
        public void 合議体Listが3件の情報を持っている場合_3が返る() {
            sut = new GogitaiList(createMockList(3));
            assertThat(sut.size(), is(3));
        }
    }

    private static List<Gogitai> createMockList(int 件数) {
        List<Gogitai> list = new ArrayList<>();
        for (int i = 0; i < 件数; i++) {
            list.add(mock(Gogitai.class));
        }
        return list;
    }
}
