/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.helper.ShinsakaiMockBusinessCreator;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.ShinsakaiIinCode;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.ShinsakaiKaisaiNo;
import jp.co.ndensan.reams.db.dbz.testhelper.DbeTestBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.Before;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * 審査会割当委員Listのテストです。
 *
 * @author n8178 城間篤人
 */
@RunWith(Enclosed.class)
public class ShinsakaiWariateIinListTest {

    private static ShinsakaiWariateIinList sut;
    private ShinsakaiWariateIin result;
    private ShinsakaiIinCode 委員コード;
    private ShinsakaiKaisaiNo 開催番号;
    private FlexibleDate 開催年月日;

    @Before
    public void setUp() {
        委員コード = new ShinsakaiIinCode(new RString("00000001"));
        開催番号 = new ShinsakaiKaisaiNo(1);
        開催年月日 = new FlexibleDate("19990101");

        List<ShinsakaiWariateIin> list = new ArrayList<>();
        list.add(ShinsakaiMockBusinessCreator.create審査会割当委員(1, "19990101", "00000001"));
        list.add(ShinsakaiMockBusinessCreator.create審査会割当委員(2, "20010101", "00000001"));
        list.add(ShinsakaiMockBusinessCreator.create審査会割当委員(3, "20100101", "00000001"));
        sut = new ShinsakaiWariateIinList(list);
    }

    @Test
    public void 審査会開催番号1_審査会委員コードA001を指定したとき_審査会開催番号に1を持つ審査会割当委員が返る() {
        result = sut.get審査会割当委員(開催番号, 委員コード);
        assertThat(result.get審査会情報().get審査会開催番号(), is(開催番号));
    }

    @Test
    public void 審査会開催番号1_審査会委員コードA001を指定したとき_委員コードにA001を持つ審査会割当委員が返る() {
        result = sut.get審査会割当委員(開催番号, 委員コード);
        assertThat(result.get審査会委員情報().get審査会委員コード(), is(委員コード));
    }

    public static class isEmptyのテスト extends DbeTestBase {

        @Test
        public void listが空のとき_trueが返る() {
            sut = createList(0);
            assertThat(sut.isEmpty(), is(true));
        }

        @Test
        public void listが空でないとき_falseが返る() {
            sut = createList(4);
            assertThat(sut.isEmpty(), is(false));
        }
    }

    public static class sizeのテスト extends DbeTestBase {

        @Test
        public void listが4件の要素を持っているとき_4が返る() {
            sut = createList(4);
            assertThat(sut.size(), is(4));
        }
    }

    private static ShinsakaiWariateIinList createList(int 件数) {
        List<ShinsakaiWariateIin> list = new ArrayList<>();
        for (int i = 0; i < 件数; i++) {
            list.add(ShinsakaiMockBusinessCreator.create審査会割当委員(i, "20100101", "00000001"));
        }
        return new ShinsakaiWariateIinList(list);
    }
}
