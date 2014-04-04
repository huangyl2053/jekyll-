/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.realservice;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.GogitaiDetail;
import jp.co.ndensan.reams.db.dbe.business.ShinsakaiDetail;
import jp.co.ndensan.reams.db.dbe.business.ShinsakaiKaisaiBasho;
import jp.co.ndensan.reams.db.dbe.business.helper.ShinsakaiTestBusinessCreator;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.GogitaiNo;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.ShinsakaiKaisaiBashoCode;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.ShinsakaiKaisaiNo;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.ShinsakaiKaisaiDate;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5101ShinsakaiJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.helper.ShinsakaiTestEntityCreator;
import jp.co.ndensan.reams.db.dbe.persistence.basic.ShinsakaiJohoDac;
import jp.co.ndensan.reams.db.dbz.testhelper.DbeTestBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.Before;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;

/**
 * 審査会情報Finderのテストです。
 *
 * @author n8178 城間篤人
 */
@RunWith(Enclosed.class)
public class ShinsakaiDetailFinderTest {

    private static ShinsakaiDetailFinder sut;

    public static class get審査会情報のテスト extends DbeTestBase {

        @Before
        public void setUp() {
            sut = new ShinsakaiDetailFinder(create審査会情報DacMock(), create開催場所ManagerMock(), create合議体情報FinderMock());
        }

        @Test
        public void 開催番号_開催年月日を指定して_審査会情報が取得できる() {
            ShinsakaiDetail result = sut.get審査会情報(new ShinsakaiKaisaiNo(1), new ShinsakaiKaisaiDate(new FlexibleDate("19990101")));
            assertThat(result.get審査会開催番号().value(), is(1));
        }

        private ShinsakaiJohoDac create審査会情報DacMock() {
            ShinsakaiJohoDac 審査会情報Dac = mock(ShinsakaiJohoDac.class);
            DbT5101ShinsakaiJohoEntity entity = ShinsakaiTestEntityCreator.create審査会情報Entity(1, "19990101");
            when(審査会情報Dac.select(any(ShinsakaiKaisaiNo.class), any(ShinsakaiKaisaiDate.class))).thenReturn(entity);
            return 審査会情報Dac;
        }
    }

    public static class get開催審査会情報のテスト extends DbeTestBase {

        @Before
        public void setUp() {
            sut = new ShinsakaiDetailFinder(create審査会情報DacMock(3), create開催場所ManagerMock(), create合議体情報FinderMock());
        }

        @Test
        public void 開催年月日を指定して_審査会情報を3件取得できる() {
            List<ShinsakaiDetail> result = sut.get開催審査会情報(new ShinsakaiKaisaiDate(new FlexibleDate("19990101")));
            assertThat(result.size(), is(3));
        }

        private ShinsakaiJohoDac create審査会情報DacMock(int 件数) {
            ShinsakaiJohoDac 審査会情報Dac = mock(ShinsakaiJohoDac.class);
            List<DbT5101ShinsakaiJohoEntity> entityList = create審査会情報EntityList(件数);
            when(審査会情報Dac.select開催審査会(any(ShinsakaiKaisaiDate.class))).thenReturn(entityList);
            return 審査会情報Dac;
        }
    }

    public static class get開催予定審査会情報のテスト extends DbeTestBase {

        @Before
        public void setUp() {
            sut = new ShinsakaiDetailFinder(create審査会情報DacMock(4), create開催場所ManagerMock(), create合議体情報FinderMock());
        }

        @Test
        public void 基準年月日を指定して_審査会情報を4件取得できる() {
            List<ShinsakaiDetail> result = sut.get開催予定審査会情報(new FlexibleDate("19990101"));
            assertThat(result.size(), is(4));
        }

        private ShinsakaiJohoDac create審査会情報DacMock(int 件数) {
            ShinsakaiJohoDac 審査会情報Dac = mock(ShinsakaiJohoDac.class);
            List<DbT5101ShinsakaiJohoEntity> entityList = create審査会情報EntityList(件数);
            when(審査会情報Dac.select開催予定審査会(any(FlexibleDate.class))).thenReturn(entityList);
            return 審査会情報Dac;
        }
    }

    public static class get審査会Allのテスト extends DbeTestBase {

        @Before
        public void setUp() {
            sut = new ShinsakaiDetailFinder(create審査会情報DacMock(6), create開催場所ManagerMock(), create合議体情報FinderMock());
        }

        @Test
        public void 条件指定なしで全件取得を行い_審査会情報を6件取得できる() {
            List<ShinsakaiDetail> result = sut.get審査会All();
            assertThat(result.size(), is(6));
        }

        private ShinsakaiJohoDac create審査会情報DacMock(int 件数) {
            ShinsakaiJohoDac 審査会情報Dac = mock(ShinsakaiJohoDac.class);
            List<DbT5101ShinsakaiJohoEntity> entityList = create審査会情報EntityList(件数);
            when(審査会情報Dac.selectAll()).thenReturn(entityList);
            return 審査会情報Dac;
        }
    }

    private static GogitaiDetailFinder create合議体情報FinderMock() {
        GogitaiDetailFinder 合議体情報Finder = mock(GogitaiDetailFinder.class);
        GogitaiDetail 合議体情報 = ShinsakaiTestBusinessCreator.create合議体情報(1);
        when(合議体情報Finder.get合議体情報(any(GogitaiNo.class), any(FlexibleDate.class))).thenReturn(合議体情報);
        return 合議体情報Finder;
    }

    private static ShinsakaiKaisaiBashoManager create開催場所ManagerMock() {
        ShinsakaiKaisaiBashoManager 開催場所Manager = mock(ShinsakaiKaisaiBashoManager.class);
        ShinsakaiKaisaiBasho 合議体情報 = ShinsakaiTestBusinessCreator.create審査会開催場所("basho01");
        when(開催場所Manager.get審査会開催場所(any(ShinsakaiKaisaiBashoCode.class))).thenReturn(合議体情報);
        return 開催場所Manager;
    }

    private static List<DbT5101ShinsakaiJohoEntity> create審査会情報EntityList(int 件数) {
        List<DbT5101ShinsakaiJohoEntity> list = new ArrayList<>();
        for (int i = 0; i < 件数; i++) {
            list.add(ShinsakaiTestEntityCreator.create審査会情報Entity(1, "19990101"));
        }
        return list;
    }
}
