/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.helper.ShinsakaiTestBusinessCreator;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.ShinsakaiKaisaiNo;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.ShinsakaiKaisaiYMD;
import jp.co.ndensan.reams.db.dbz.testhelper.DbeTestBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.Before;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * 審査会委員のテストです。
 *
 * @author n8178 城間篤人
 */
@RunWith(Enclosed.class)
public class ShinsakaiListTest {

    private static ShinsakaiList sut;

    public static class get審査会のテスト extends DbeTestBase {

        private ShinsakaiKaisaiNo 開催番号;
        private ShinsakaiKaisaiYMD 開催年月日;

        @Before
        public void setUp() {
            List<Shinsakai> list = new ArrayList<>();
            list.add(ShinsakaiTestBusinessCreator.create審査会(1, "19990101"));
            list.add(ShinsakaiTestBusinessCreator.create審査会(2, "20000101"));
            list.add(ShinsakaiTestBusinessCreator.create審査会(3, "20010101"));
            sut = new ShinsakaiList(list);
            開催番号 = new ShinsakaiKaisaiNo(2);
            開催年月日 = new ShinsakaiKaisaiYMD(new FlexibleDate("20000101"));
        }

        @Test
        public void 開催番号2_開催年月日20000101を指定したとき_開催番号に2を持つ審査会が返る() {
            assertThat(sut.get審査会(開催番号, 開催年月日).get審査会情報().get審査会開催番号(), is(開催番号));
        }

        @Test
        public void 開催番号2_開催年月日20000101を指定したとき_開催年月日に20000101を持つ審査会が返る() {
            assertThat(sut.get審査会(開催番号, 開催年月日).get審査会情報().get審査会開催年月日(), is(開催年月日));
        }
    }

    public static class isEmptyテスト extends DbeTestBase {

        @Test
        public void Listが空の場合_trueを返す() {
            sut = createList(0);
            assertThat(sut.isEmpty(), is(true));
        }

        @Test
        public void Listが空でない場合_falseを返す() {
            sut = createList(3);
            assertThat(sut.isEmpty(), is(false));
        }
    }

    public static class sizeのテスト extends DbeTestBase {

        @Test
        public void 要素を3つ持つ審査会Listの場合_3を返す() {
            sut = createList(3);
            assertThat(sut.size(), is(3));
        }
    }

    private static ShinsakaiList createList(int 件数) {
        List<Shinsakai> list = new ArrayList<>();
        for (int i = 0; i < 件数; i++) {
            list.add(ShinsakaiTestBusinessCreator.create審査会(1, "19990101"));
        }
        return new ShinsakaiList(list);
    }
}
