/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.realservice;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.Shinsakai;
import jp.co.ndensan.reams.db.dbe.business.ShinsakaiDetail;
import jp.co.ndensan.reams.db.dbe.business.ShinsakaiIinList;
import jp.co.ndensan.reams.db.dbe.business.ShinsakaiList;
import jp.co.ndensan.reams.db.dbe.business.helper.ShinsakaiTestBusinessCreator;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.ShinsakaiKaisaiNo;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.ShinsakaiKaisaiDate;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5101ShinsakaiJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5106ShinsakaiWariateIinJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.helper.ShinsakaiTestEntityCreator;
import jp.co.ndensan.reams.db.dbe.persistence.basic.ShinsakaiWariateIinJohoDac;
import jp.co.ndensan.reams.db.dbe.persistence.relate.ShinsakaiAndShinskaiWariateIinDac;
import jp.co.ndensan.reams.db.dbz.testhelper.DbeTestBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.Before;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.any;

/**
 * 審査会Managerのテストです。
 *
 * @author n8178 城間篤人
 */
@RunWith(Enclosed.class)
public class ShinsakaiManagerTest {

    private static ShinsakaiManager sut;

    public static class get審査会のテスト extends DbeTestBase {

        @Before
        public void setUp() {
            sut = new ShinsakaiManager(create割当委員情報DacMock(), create審査会情報FinderMock(), create委員Manager(), null);
        }

        @Test
        public void 開催番号と開催年月日を指定して_審査会の情報を取得できる() {
            Shinsakai result = sut.get審査会(new ShinsakaiKaisaiNo(1), new ShinsakaiKaisaiDate(new FlexibleDate("19990101")));
            assertThat(result.get審査会情報().get審査会開催番号().value(), is(1));
        }

        private static ShinsakaiDetailFinder create審査会情報FinderMock() {
            ShinsakaiDetailFinder 審査会情報Finder = mock(ShinsakaiDetailFinder.class);
            ShinsakaiDetail 審査会情報 = ShinsakaiTestBusinessCreator.create審査会情報(1, "19990101");
            when(審査会情報Finder.get審査会情報(any(ShinsakaiKaisaiNo.class), any(ShinsakaiKaisaiDate.class))).thenReturn(審査会情報);
            return 審査会情報Finder;
        }
    }

    public static class get開催審査会Listのテスト extends DbeTestBase {

        @Before
        public void setUp() {
            sut = new ShinsakaiManager(create割当委員情報DacMock(), create審査会情報FinderMock(2), create委員Manager(), null);
        }

        @Test
        public void 開催年月日を指定して_その日に開催される審査会が2件取得できる() {
            ShinsakaiList result = sut.get開催審査会List(new ShinsakaiKaisaiDate(new FlexibleDate("19990101")));
            assertThat(result.size(), is(2));
        }

        private static ShinsakaiDetailFinder create審査会情報FinderMock(int 件数) {
            ShinsakaiDetailFinder 審査会情報Finder = mock(ShinsakaiDetailFinder.class);
            List<ShinsakaiDetail> 審査会情報 = create審査会割当委員List(件数);
            when(審査会情報Finder.get開催審査会情報(any(ShinsakaiKaisaiDate.class))).thenReturn(審査会情報);
            return 審査会情報Finder;
        }
    }

    public static class get開催予定審査会Listのテスト extends DbeTestBase {

        @Before
        public void setUp() {
            sut = new ShinsakaiManager(create割当委員情報DacMock(), create審査会情報FinderMock(8), create委員Manager(), null);
        }

        @Test
        public void 基準となる年月日を指定して_その日から後に開催される審査会が8件取得できる() {
            ShinsakaiList result = sut.get開催予定審査会List(new FlexibleDate("19990101"));
            assertThat(result.size(), is(8));
        }

        private static ShinsakaiDetailFinder create審査会情報FinderMock(int 件数) {
            ShinsakaiDetailFinder 審査会情報Finder = mock(ShinsakaiDetailFinder.class);
            List<ShinsakaiDetail> 審査会情報 = create審査会割当委員List(件数);
            when(審査会情報Finder.get開催予定審査会情報(any(FlexibleDate.class))).thenReturn(審査会情報);
            return 審査会情報Finder;
        }
    }

    public static class get審査会Allのテスト extends DbeTestBase {

        @Before
        public void setUp() {
            sut = new ShinsakaiManager(create割当委員情報DacMock(), create審査会情報FinderMock(14), create委員Manager(), null);
        }

        @Test
        public void 基準となる年月日を指定して_その日から後に開催される審査会が14件取得できる() {
            ShinsakaiList result = sut.get審査会All();
            assertThat(result.size(), is(14));
        }

        private static ShinsakaiDetailFinder create審査会情報FinderMock(int 件数) {
            ShinsakaiDetailFinder 審査会情報Finder = mock(ShinsakaiDetailFinder.class);
            List<ShinsakaiDetail> 審査会情報 = create審査会割当委員List(件数);
            when(審査会情報Finder.get審査会All()).thenReturn(審査会情報);
            return 審査会情報Finder;
        }
    }

    public static class saveのテスト extends DbeTestBase {

        @Test
        public void 審査会とそこに割り当てられている委員の情報について_1件以上の情報を更新した場合_trueが返る() {
            sut = new ShinsakaiManager(null, null, null, create審査会And割当委員Dac(4));
            Shinsakai 審査会 = ShinsakaiTestBusinessCreator.create審査会(1, "19990101");
            assertThat(sut.save(審査会), is(true));
        }

        @Test
        public void 審査会とそこに割り当てられている委員の情報について_更新できなかった場合_falseが返る() {
            sut = new ShinsakaiManager(null, null, null, create審査会And割当委員Dac(0));
            Shinsakai 審査会 = ShinsakaiTestBusinessCreator.create審査会(1, "19990101");
            assertThat(sut.save(審査会), is(false));
        }

        private ShinsakaiAndShinskaiWariateIinDac create審査会And割当委員Dac(int 総更新件数) {
            ShinsakaiAndShinskaiWariateIinDac dac = mock(ShinsakaiAndShinskaiWariateIinDac.class);
            when(dac.insertOrUpdate(any(DbT5101ShinsakaiJohoEntity.class), any(List.class))).thenReturn(総更新件数);
            return dac;
        }
    }

    public static class removeのテスト extends DbeTestBase {

        @Test
        public void 審査会とそこに割り当てられている委員の情報について_1件以上の情報を削除した場合_trueが返る() {
            sut = new ShinsakaiManager(null, null, null, create審査会And割当委員Dac(5));
            Shinsakai 審査会 = ShinsakaiTestBusinessCreator.create審査会(1, "19990101");
            assertThat(sut.remove(審査会), is(true));
        }

        @Test
        public void 審査会とそこに割り当てられている委員の情報について_削除できなかった場合_falseが返る() {
            sut = new ShinsakaiManager(null, null, null, create審査会And割当委員Dac(0));
            Shinsakai 審査会 = ShinsakaiTestBusinessCreator.create審査会(1, "19990101");
            assertThat(sut.remove(審査会), is(false));
        }

        private ShinsakaiAndShinskaiWariateIinDac create審査会And割当委員Dac(int 総更新件数) {
            ShinsakaiAndShinskaiWariateIinDac dac = mock(ShinsakaiAndShinskaiWariateIinDac.class);
            when(dac.delete(any(DbT5101ShinsakaiJohoEntity.class), any(List.class))).thenReturn(総更新件数);
            return dac;
        }
    }

    private static ShinsakaiIinManager create委員Manager() {
        ShinsakaiIinManager 委員Manager = mock(ShinsakaiIinManager.class);
        ShinsakaiIinList 審査会委員List = ShinsakaiTestBusinessCreator.create審査会委員List("iin01", "iin02", "iin03", "iin04");
        when(委員Manager.get審査会委員List(any(List.class))).thenReturn(審査会委員List);
        return 委員Manager;
    }

    private static List<ShinsakaiDetail> create審査会割当委員List(int 件数) {
        List<ShinsakaiDetail> list = new ArrayList<>();
        for (int i = 0; i < 件数; i++) {
            list.add(ShinsakaiTestBusinessCreator.create審査会情報(1, "19990101"));
        }
        return list;
    }

    private static ShinsakaiWariateIinJohoDac create割当委員情報DacMock() {
        ShinsakaiWariateIinJohoDac 割当委員情報Dac = mock(ShinsakaiWariateIinJohoDac.class);
        List<DbT5106ShinsakaiWariateIinJohoEntity> entityList =
                ShinsakaiTestEntityCreator.create審査会割当委員情報EntityListSpy(1, "19990101", "iin01", "iin02", "iin03", "iin04");
        when(割当委員情報Dac.select(any(ShinsakaiKaisaiNo.class), any(ShinsakaiKaisaiDate.class))).thenReturn(entityList);
        return 割当委員情報Dac;
    }
}
