/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.GogitaiDummyKubun;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.GogitaiSeishinkaIshiSonzaiKubun;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.GogitaiNo;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.GogitaiYukoKikanKaishiYMD;
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
 * 合議体のテストです。
 *
 * @author n8178 城間篤人
 */
@RunWith(Enclosed.class)
public class GogitaiTest {

    private static Gogitai sut;

    public static class コンストラクタのテスト extends DbeTestBase {

        private GogitaiDetail 合議体情報;
        private GogitaiWariateIinList 割当委員List;
        private GogitaiWariateIinList 合議体情報不一致割当委員List;

        @Before
        public void setUp() {
            合議体情報 = create合議体情報(1, "19990101");
            割当委員List = create割当委員List_合議体情報一致();
            合議体情報不一致割当委員List = create割当委員List_合議体情報不一致();
        }

        @Test(expected = NullPointerException.class)
        public void 引数の合議体情報にnullが渡されたとき_NullPointerExceptionが発生する() {
            sut = new Gogitai(null, 割当委員List);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の割当委員Listにnullが渡されたとき_NullPointerExceptionが発生する() {
            sut = new Gogitai(合議体情報, null);
        }

        @Test(expected = IllegalArgumentException.class)
        public void 割当委員Listの要素それぞれが持つ合議体情報と_引数の合議体情報が不一致の場合_IllegalArgumentExceptionが発生する() {
            sut = new Gogitai(合議体情報, 合議体情報不一致割当委員List);
        }

        @Test
        public void 割当委員Listの要素それぞれが持つ合議体情報と_引数の合議体情報が一致する場合_インスタンスが生成される() {
            sut = new Gogitai(合議体情報, 割当委員List);
            assertThat(sut, is(instanceOf(Gogitai.class)));
        }
    }

    private static GogitaiDetail create合議体情報(int 合議体番号, String 開始年月日) {
        return new GogitaiDetail(new GogitaiNo(合議体番号), RString.EMPTY, new GogitaiYukoKikanKaishiYMD(開始年月日),
                FlexibleDate.MAX, mock(Range.class), mock(ShinsakaiKaisaiBasho.class), 1, 2, 3,
                GogitaiSeishinkaIshiSonzaiKubun.存在, GogitaiDummyKubun.ダミー);
    }

    private static GogitaiWariateIinList create割当委員List_合議体情報一致() {
        List<GogitaiWariateIin> wariateIinList = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            GogitaiDetail info = create合議体情報(1, "19990101");
            ShinsakaiIin shinsakaiIin = mock(ShinsakaiIin.class);
            ShinsakaiIinCode shinsakaiIinCode = new ShinsakaiIinCode(new RString("01"));
            when(shinsakaiIin.get委員コード()).thenReturn(shinsakaiIinCode);

            GogitaiWariateIin wariateIin = mock(GogitaiWariateIin.class);
            when(wariateIin.get合議体情報()).thenReturn(info);
            when(wariateIin.get委員情報()).thenReturn(shinsakaiIin);

            wariateIinList.add(wariateIin);
        }
        return new GogitaiWariateIinList(wariateIinList);
    }

    private static GogitaiWariateIinList create割当委員List_合議体情報不一致() {
        List<GogitaiWariateIin> wariateIinList = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            GogitaiDetail info = create合議体情報(i, "19990101");
            ShinsakaiIin shinsakaiIin = mock(ShinsakaiIin.class);
            ShinsakaiIinCode shinsakaiIinCode = new ShinsakaiIinCode(new RString("01"));
            when(shinsakaiIin.get委員コード()).thenReturn(shinsakaiIinCode);

            GogitaiWariateIin wariateIin = mock(GogitaiWariateIin.class);
            when(wariateIin.get合議体情報()).thenReturn(info);
            when(wariateIin.get委員情報()).thenReturn(shinsakaiIin);

            wariateIinList.add(wariateIin);
        }
        return new GogitaiWariateIinList(wariateIinList);
    }
}
