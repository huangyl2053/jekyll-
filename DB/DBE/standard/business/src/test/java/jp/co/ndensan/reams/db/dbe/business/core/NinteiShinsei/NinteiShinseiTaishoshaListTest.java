/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.NinteiShinsei;

import jp.co.ndensan.reams.db.dbe.business.core.minashi2gosha.Minashi2GoshaList;
import jp.co.ndensan.reams.db.dbe.business.core.minashi2gosha.Minashi2Gosha;
import jp.co.ndensan.reams.db.dbe.business.core.ninteishinsei.NinteiShinseiTaishoshaList;
import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.business.core.Hihokensha;
import jp.co.ndensan.reams.db.dbz.business.core.HihokenshaList;
import jp.co.ndensan.reams.db.dbz.testhelper.DbeTestBase;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * 認定申請対象者Listのテストです。
 *
 * @author n8178 城間篤人
 */
@RunWith(Enclosed.class)
public class NinteiShinseiTaishoshaListTest {

    private static NinteiShinseiTaishoshaList sut;

    public static class Constructor extends DbeTestBase {

        @Test
        public void 全ての引数にnullが渡されたとき_要素を一つも持たないインスタンスが生成される() {
            sut = new NinteiShinseiTaishoshaList(null, null);
            assertThat(sut.isEmpty(), is(true));
        }
    }

    public static class Size extends DbeTestBase {

        @Test
        public void 要素を3件持つ被保険者Listと_要素を2つ持つみなし2号者Listがコンストラクタに渡された場合_5が返る() {
            sut = new NinteiShinseiTaishoshaList(createHihokenshaList(3), createMinashi2GoshaList(2));
            assertThat(sut.size(), is(5));
        }

        @Test
        public void 空の被保険者Listと_要素を2つ持つみなし2号者Listがコンストラクタに渡された場合_2が返る() {
            sut = new NinteiShinseiTaishoshaList(createHihokenshaList(0), createMinashi2GoshaList(2));
            assertThat(sut.size(), is(2));
        }

        @Test
        public void 要素を3件持つ被保険者Listと_空のみなし2号者Listがコンストラクタに渡された場合_3が返る() {
            sut = new NinteiShinseiTaishoshaList(createHihokenshaList(3), createMinashi2GoshaList(0));
            assertThat(sut.size(), is(3));
        }
    }

    public static class IsEmpty extends DbeTestBase {

        @Test
        public void 空の被保険者Listと_空のみなし2号者Listがコンストラクタに渡された場合_trueが返る() {
            sut = new NinteiShinseiTaishoshaList(createHihokenshaList(0), createMinashi2GoshaList(0));
            assertThat(sut.isEmpty(), is(true));
        }

        @Test
        public void 空の被保険者Listと_要素を持つみなし2号者Listがコンストラクタに渡された場合_falseが返る() {
            sut = new NinteiShinseiTaishoshaList(createHihokenshaList(0), createMinashi2GoshaList(2));
            assertThat(sut.isEmpty(), is(false));
        }

        @Test
        public void 要素を持つ被保険者Listと_空のみなし2号者Listがコンストラクタに渡された場合_falseが返る() {
            sut = new NinteiShinseiTaishoshaList(createHihokenshaList(3), createMinashi2GoshaList(0));
            assertThat(sut.isEmpty(), is(false));
        }

        @Test
        public void 要素を持つ被保険者Listと_要素を持つみなし2号者Listがコンストラクタに渡された場合_falseが返る() {

            sut = new NinteiShinseiTaishoshaList(createHihokenshaList(3), createMinashi2GoshaList(2));
            assertThat(sut.isEmpty(), is(false));
        }
    }

    private static Minashi2GoshaList createMinashi2GoshaList(int size) {
        List<Minashi2Gosha> list = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            list.add(mock(Minashi2Gosha.class));
        }
        return new Minashi2GoshaList(list);
    }

    private static HihokenshaList createHihokenshaList(int size) {
        List<Hihokensha> list = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            Hihokensha hihokensha = mock(Hihokensha.class);
            when(hihokensha.get市町村コード()).thenReturn(new LasdecCode(new RString("012345")));
            when(hihokensha.get識別コード()).thenReturn(new ShikibetsuCode("012345678900001"));
            when(hihokensha.get処理日時()).thenReturn(new YMDHMS("20110312012345"));
            list.add(hihokensha);
        }
        return new HihokenshaList(list);
    }

}
