/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.basic;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.ShinsakaiKaisaiNo;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5101ShinsakaiJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.helper.ShinsakaiTestEntityCreator;
import jp.co.ndensan.reams.db.dbz.testhelper.DbeTestDacBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * 審査会情報Dacのテストです。
 *
 * @author n8178 城間篤人
 */
@RunWith(Enclosed.class)
public class ShinsakaiJohoDacTest {

    private static ShinsakaiJohoDac sut;

    @BeforeClass
    public static void setUpClass() {
        sut = InstanceProvider.create(ShinsakaiJohoDac.class);
    }

    public static class selectのテスト extends DbeTestDacBase {

        private DbT5101ShinsakaiJohoEntity result;
        private ShinsakaiKaisaiNo 開催番号_1;
        private FlexibleDate 開催年月日_19990101;

        @Before
        public void setUp() {
            sut.insert(ShinsakaiTestEntityCreator.create審査会情報Entity(1, "19990101", 4, "0830", "basho01"));
            開催番号_1 = new ShinsakaiKaisaiNo(1);
            開催年月日_19990101 = new FlexibleDate("19990101");
        }

        @Test
        public void 開催番号に1_開催年月日に19990101を指定したとき_開催番号に1を持つ審査会Entityが取得できる() {
            result = sut.select(開催番号_1, 開催年月日_19990101);
            assertThat(result.getShinsakaiKaisaiNo(), is(開催番号_1.value()));
        }

        @Test
        public void 開催番号に1_開催年月日に19990101を指定したとき_開催年月日に19990101を持つ審査会Entityが取得できる() {
            result = sut.select(開催番号_1, 開催年月日_19990101);
            assertThat(result.getShinsakaiKaisaiYMD(), is(開催年月日_19990101));
        }
    }

    public static class select開催予定審査会のテスト extends DbeTestDacBase {

        private List<DbT5101ShinsakaiJohoEntity> result;

        @Before
        public void setUp() {
            sut.insert(ShinsakaiTestEntityCreator.create審査会情報Entity(1, "19990101", 4, "0830", "basho01"));
            sut.insert(ShinsakaiTestEntityCreator.create審査会情報Entity(2, "19990204", 6, "0830", "basho01"));
            sut.insert(ShinsakaiTestEntityCreator.create審査会情報Entity(3, "19990205", 4, "0830", "basho01"));
            sut.insert(ShinsakaiTestEntityCreator.create審査会情報Entity(4, "19990401", 6, "0830", "basho01"));
        }

        @Test
        public void 基準年月日に19990204を指定した場合_3件の要素が取得できる() {
            result = sut.select開催予定審査会(new FlexibleDate("19990204"));
            assertThat(result.size(), is(3));
        }

        @Test
        public void 基準年月日に19990205を指定した場合_2件の要素が取得できる() {
            result = sut.select開催予定審査会(new FlexibleDate("19990205"));
            assertThat(result.size(), is(2));
        }
    }

    public static class select開催審査会のテスト extends DbeTestDacBase {

        private List<DbT5101ShinsakaiJohoEntity> result;
        private FlexibleDate 開催年月日;

        @Before
        public void setUp() {
            sut.insert(ShinsakaiTestEntityCreator.create審査会情報Entity(1, "19990201", 6, "0830", "basho01"));
            sut.insert(ShinsakaiTestEntityCreator.create審査会情報Entity(2, "19990205", 4, "0830", "basho01"));
            sut.insert(ShinsakaiTestEntityCreator.create審査会情報Entity(3, "19990205", 6, "0830", "basho01"));
            sut.insert(ShinsakaiTestEntityCreator.create審査会情報Entity(4, "19990312", 4, "0830", "basho01"));
        }

        @Test
        public void 基準年月日に19990205を指定した場合_2件の要素が取得できる() {
            開催年月日 = new FlexibleDate("19990205");
            result = sut.select開催審査会(開催年月日);
            assertThat(result.size(), is(2));
        }

        @Test
        public void 基準年月日に19990312を指定した場合_1件の要素が取得できる() {
            開催年月日 = new FlexibleDate("19990312");
            result = sut.select開催審査会(開催年月日);
            assertThat(result.size(), is(1));
        }
    }

    public static class selectAllのテスト extends DbeTestDacBase {

        private List<DbT5101ShinsakaiJohoEntity> result;

        @Before
        public void setUp() {
            sut.insert(ShinsakaiTestEntityCreator.create審査会情報Entity(1, "19990201", 4, "0830", "basho01"));
            sut.insert(ShinsakaiTestEntityCreator.create審査会情報Entity(2, "19990205", 5, "0830", "basho01"));
            sut.insert(ShinsakaiTestEntityCreator.create審査会情報Entity(3, "19990208", 4, "0830", "basho01"));
            sut.insert(ShinsakaiTestEntityCreator.create審査会情報Entity(4, "19990312", 6, "0830", "basho01"));
        }

        @Test
        public void すべての要素が取得できる() {
            result = sut.selectAll();
            assertThat(result.size(), is(4));
        }
    }

    public static class insertのテスト extends DbeTestDacBase {

        @Test
        public void 挿入した値を取得できる() {
            sut.insert(ShinsakaiTestEntityCreator.create審査会情報Entity(1, "19990201", 4, "0830", "basho01"));

            ShinsakaiKaisaiNo 開催番号 = new ShinsakaiKaisaiNo(1);
            FlexibleDate 開催年月日 = new FlexibleDate("19990201");
            assertThat(sut.select(開催番号, 開催年月日).getShinsakaiKaisaiBashoCode(), is(new RString("basho01")));
        }
    }

    public static class updateのテスト extends DbeTestDacBase {

        @Test
        public void 更新した値を取得できる() {
            sut.insert(ShinsakaiTestEntityCreator.create審査会情報Entity(1, "19990201", 4, "0830", "basho01"));
            sut.update(ShinsakaiTestEntityCreator.create審査会情報Entity(1, "19990201", 4, "0830", "basho02"));

            ShinsakaiKaisaiNo 開催番号 = new ShinsakaiKaisaiNo(1);
            FlexibleDate 開催年月日 = new FlexibleDate("19990201");
            assertThat(sut.select(開催番号, 開催年月日).getShinsakaiKaisaiBashoCode(), is(new RString("basho02")));
        }
    }

    public static class deleteのテスト extends DbeTestDacBase {

        @Test
        public void 削除した値は取得できない() {
            sut.insert(ShinsakaiTestEntityCreator.create審査会情報Entity(1, "19990201", 4, "0830", "basho01"));
            sut.delete(ShinsakaiTestEntityCreator.create審査会情報Entity(1, "19990201", 4, "0830", "basho01"));

            ShinsakaiKaisaiNo 開催番号 = new ShinsakaiKaisaiNo(1);
            FlexibleDate 開催年月日 = new FlexibleDate("19990101");
            assertThat(sut.select(開催番号, 開催年月日), is(nullValue()));
        }
    }

    public static class insertOrUpdateのテスト extends DbeTestDacBase {

        @Test
        public void test() {
            //TODO n8178 城間篤人 insertOrUpdateの実装法が決定後にテストを作成する 2014年4月
        }
    }
}
