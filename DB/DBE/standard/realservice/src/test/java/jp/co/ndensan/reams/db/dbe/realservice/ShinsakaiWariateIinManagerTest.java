/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.realservice;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.ShinsakaiDetail;
import jp.co.ndensan.reams.db.dbe.business.ShinsakaiIin;
import jp.co.ndensan.reams.db.dbe.business.ShinsakaiWariateIin;
import jp.co.ndensan.reams.db.dbe.business.ShinsakaiWariateIinList;
import jp.co.ndensan.reams.db.dbe.business.helper.ShinsakaiMockBusinessCreator;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.ShinsakaiIinCode;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.ShinsakaiKaisaiNo;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5106ShinsakaiWariateIinJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.helper.ShinsakaiMockEntityCreator;
import jp.co.ndensan.reams.db.dbe.persistence.basic.ShinsakaiWariateIinJohoDac;
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
 * 審査会割当委員Managerのテストです。
 *
 * @author n8178 城間篤人
 */
@RunWith(Enclosed.class)
public class ShinsakaiWariateIinManagerTest {

    private static ShinsakaiWariateIinManager sut;

    public static class get審査会参加割当委員Listのテスト extends DbeTestBase {

        @Before
        public void setUp() {
            sut = new ShinsakaiWariateIinManager(create割当委員情報DacMock(2), create審査会情報Finder(), create委員Manager());
        }

        @Test
        public void 開催年月日を指定して_その日に審査会に参加する委員を2件取得できる() {
            ShinsakaiWariateIinList result = sut.get審査会参加割当委員List(new FlexibleDate("19990101"));
            assertThat(result.size(), is(2));
        }

        private ShinsakaiWariateIinJohoDac create割当委員情報DacMock(int 件数) {
            ShinsakaiWariateIinJohoDac 割当委員Dac = mock(ShinsakaiWariateIinJohoDac.class);
            List<DbT5106ShinsakaiWariateIinJohoEntity> 審査会情報 = create審査会割当委員(件数);
            when(割当委員Dac.select(any(FlexibleDate.class))).thenReturn(審査会情報);
            return 割当委員Dac;
        }
    }

    public static class get審査会割当委員Allのテスト extends DbeTestBase {

        @Before
        public void setUp() {
            sut = new ShinsakaiWariateIinManager(create割当委員情報DacMock(7), create審査会情報Finder(), create委員Manager());
        }

        @Test
        public void すべての委員情報の取得を行い_委員を7件取得できる() {
            ShinsakaiWariateIinList result = sut.get審査会割当委員All();
            assertThat(result.size(), is(7));
        }

        private ShinsakaiWariateIinJohoDac create割当委員情報DacMock(int 件数) {
            ShinsakaiWariateIinJohoDac 割当委員Dac = mock(ShinsakaiWariateIinJohoDac.class);
            List<DbT5106ShinsakaiWariateIinJohoEntity> 審査会情報 = create審査会割当委員(件数);
            when(割当委員Dac.selectAll()).thenReturn(審査会情報);
            return 割当委員Dac;
        }
    }

    public static class saveのテスト extends DbeTestBase {

        @Test
        public void 情報を更新した場合_trueが返る() {
            sut = new ShinsakaiWariateIinManager(create割当委員情報DacMock(1), create審査会情報Finder(), create委員Manager());
            ShinsakaiWariateIin 割当委員 = ShinsakaiMockBusinessCreator.create審査会割当委員(1, "19990101", "00000001");
            assertThat(sut.save(割当委員), is(true));
        }

        @Test
        public void 更新件数が0件だった場合_falseが返る() {
            sut = new ShinsakaiWariateIinManager(create割当委員情報DacMock(0), create審査会情報Finder(), create委員Manager());
            ShinsakaiWariateIin 割当委員 = ShinsakaiMockBusinessCreator.create審査会割当委員(1, "19990101", "00000001");
            assertThat(sut.save(割当委員), is(false));
        }

        private ShinsakaiWariateIinJohoDac create割当委員情報DacMock(int 総更新件数) {
            ShinsakaiWariateIinJohoDac 割当委員Dac = mock(ShinsakaiWariateIinJohoDac.class);
            when(割当委員Dac.insertOrUpdate(any(DbT5106ShinsakaiWariateIinJohoEntity.class))).thenReturn(総更新件数);
            return 割当委員Dac;
        }
    }

    public static class removeのテスト extends DbeTestBase {

        @Test
        public void 情報を削除した場合_trueが返る() {
            sut = new ShinsakaiWariateIinManager(create割当委員情報DacMock(1), create審査会情報Finder(), create委員Manager());
            ShinsakaiWariateIin 割当委員 = ShinsakaiMockBusinessCreator.create審査会割当委員(1, "19990101", "00000001");
            assertThat(sut.remove(割当委員), is(true));
        }

        @Test
        public void 削除件数が0件だった場合_falseが返る() {
            sut = new ShinsakaiWariateIinManager(create割当委員情報DacMock(0), create審査会情報Finder(), create委員Manager());
            ShinsakaiWariateIin 割当委員 = ShinsakaiMockBusinessCreator.create審査会割当委員(1, "19990101", "00000001");
            assertThat(sut.remove(割当委員), is(false));
        }

        private ShinsakaiWariateIinJohoDac create割当委員情報DacMock(int 総削除件数) {
            ShinsakaiWariateIinJohoDac 割当委員Dac = mock(ShinsakaiWariateIinJohoDac.class);
            when(割当委員Dac.delete(any(DbT5106ShinsakaiWariateIinJohoEntity.class))).thenReturn(総削除件数);
            return 割当委員Dac;
        }
    }

    private static List<DbT5106ShinsakaiWariateIinJohoEntity> create審査会割当委員(int 件数) {
        List<DbT5106ShinsakaiWariateIinJohoEntity> list = new ArrayList<>();
        for (int i = 0; i < 件数; i++) {
            list.add(ShinsakaiMockEntityCreator.create審査会割当委員情報EntitySpy(1, "19990101", "00000001"));
        }
        return list;
    }

    private static ShinsakaiDetailFinder create審査会情報Finder() {
        ShinsakaiDetailFinder 審査会情報Finder = mock(ShinsakaiDetailFinder.class);
        ShinsakaiDetail 審査会情報 = ShinsakaiMockBusinessCreator.create審査会情報(1, "19990101");
        when(審査会情報Finder.get審査会情報(any(ShinsakaiKaisaiNo.class), any(FlexibleDate.class))).thenReturn(審査会情報);
        return 審査会情報Finder;
    }

    private static ShinsakaiIinManager create委員Manager() {
        ShinsakaiIinManager 委員Manager = mock(ShinsakaiIinManager.class);
        ShinsakaiIin 審査会情報 = ShinsakaiMockBusinessCreator.create審査会委員("00000001");
        when(委員Manager.get審査会委員(any(ShinsakaiIinCode.class))).thenReturn(審査会情報);
        return 委員Manager;
    }
}
