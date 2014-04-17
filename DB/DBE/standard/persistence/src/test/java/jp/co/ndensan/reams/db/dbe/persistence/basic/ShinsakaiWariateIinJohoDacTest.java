/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.basic;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.ShinsakaiKaisaiNo;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5106ShinsakaiWariateIinJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.helper.ShinsakaiTestEntityCreator;
import jp.co.ndensan.reams.db.dbz.testhelper.DbeTestDacBase;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * 審査会割当委員情報Dacのテストです。
 *
 * @author n8178 城間篤人
 */
@RunWith(Enclosed.class)
public class ShinsakaiWariateIinJohoDacTest {

    private static ShinsakaiWariateIinJohoDac sut;
    private static ShinsakaiKaisaiNo 開催番号;
    private static FlexibleDate 開催年月日;

    @BeforeClass
    public static void setUpClass() {
        sut = InstanceProvider.create(ShinsakaiWariateIinJohoDac.class);
    }

    public static class select_開催番号と開催年月日を指定する場合のテスト extends DbeTestDacBase {

        @Before
        public void setUp() {
            sut.insert(ShinsakaiTestEntityCreator.create審査会割当委員情報Entity(1, "19990101", "iin01"));
            sut.insert(ShinsakaiTestEntityCreator.create審査会割当委員情報Entity(1, "19990101", "iin02"));
            sut.insert(ShinsakaiTestEntityCreator.create審査会割当委員情報Entity(2, "20010101", "iin03"));
            sut.insert(ShinsakaiTestEntityCreator.create審査会割当委員情報Entity(1, "19990101", "iin04"));
            sut.insert(ShinsakaiTestEntityCreator.create審査会割当委員情報Entity(2, "20010101", "iin05"));
            sut.insert(ShinsakaiTestEntityCreator.create審査会割当委員情報Entity(1, "19990101", "iin06"));
        }

        @Test
        public void 審査会開催番号に1_審査会開催年月日に19990101が指定されたとき_4件の情報を取得できる() {
            開催番号 = new ShinsakaiKaisaiNo(1);
            開催年月日 = new FlexibleDate("19990101");
            List<DbT5106ShinsakaiWariateIinJohoEntity> result = sut.select(開催番号, 開催年月日);
            assertThat(result.size(), is(4));
        }

        @Test
        public void 審査会開催番号に2_審査会開催年月日に20010101が指定されたとき_2件の情報を取得できる() {
            開催番号 = new ShinsakaiKaisaiNo(2);
            開催年月日 = new FlexibleDate("20010101");
            List<DbT5106ShinsakaiWariateIinJohoEntity> result = sut.select(開催番号, 開催年月日);
            assertThat(result.size(), is(2));
        }
    }

    public static class select_開催年月日を指定する場合のテスト extends DbeTestDacBase {

        @Before
        public void setUp() {
            sut.insert(ShinsakaiTestEntityCreator.create審査会割当委員情報Entity(1, "19990101", "iin01"));
            sut.insert(ShinsakaiTestEntityCreator.create審査会割当委員情報Entity(1, "20000101", "iin02"));
            sut.insert(ShinsakaiTestEntityCreator.create審査会割当委員情報Entity(2, "20010101", "iin03"));
            sut.insert(ShinsakaiTestEntityCreator.create審査会割当委員情報Entity(1, "19990101", "iin04"));
            sut.insert(ShinsakaiTestEntityCreator.create審査会割当委員情報Entity(1, "20010101", "iin05"));
            sut.insert(ShinsakaiTestEntityCreator.create審査会割当委員情報Entity(2, "19990101", "iin06"));
        }

        @Test
        public void 審査会開催年月日に19990101が指定されたとき_3件の情報を取得できる() {
            開催年月日 = new FlexibleDate("19990101");
            List<DbT5106ShinsakaiWariateIinJohoEntity> result = sut.select(開催年月日);
            assertThat(result.size(), is(3));
        }

        @Test
        public void 審査会開催年月日に20000101が指定されたとき_1件の情報を取得できる() {
            開催年月日 = new FlexibleDate("20000101");
            List<DbT5106ShinsakaiWariateIinJohoEntity> result = sut.select(開催年月日);
            assertThat(result.size(), is(1));
        }

        @Test
        public void 審査会開催年月日に20010101が指定されたとき_2件の情報を取得できる() {
            開催年月日 = new FlexibleDate("20010101");
            List<DbT5106ShinsakaiWariateIinJohoEntity> result = sut.select(開催年月日);
            assertThat(result.size(), is(2));
        }
    }

    public static class select_Allのテスト extends DbeTestDacBase {

        @Before
        public void setUp() {
            sut.insert(ShinsakaiTestEntityCreator.create審査会割当委員情報Entity(1, "19990101", "iin01"));
            sut.insert(ShinsakaiTestEntityCreator.create審査会割当委員情報Entity(2, "20000101", "iin02"));
            sut.insert(ShinsakaiTestEntityCreator.create審査会割当委員情報Entity(3, "20010101", "iin03"));
        }

        @Test
        public void すべての情報を取得できる() {
            List<DbT5106ShinsakaiWariateIinJohoEntity> result = sut.selectAll();
            assertThat(result.size(), is(3));
        }
    }

    public static class insertのテスト extends DbeTestDacBase {

        @Test
        public void 保存したデータを取得できる() {
            sut.insert(ShinsakaiTestEntityCreator.create審査会割当委員情報Entity(1, "19990101", "iin01"));

            開催番号 = new ShinsakaiKaisaiNo(1);
            開催年月日 = new FlexibleDate("19990101");
            List<DbT5106ShinsakaiWariateIinJohoEntity> result = sut.select(開催番号, 開催年月日);
            assertThat(result.get(0).getShinsakaiKaisaiNo(), is(1));
        }
    }

    public static class updateのテスト extends DbeTestDacBase {

        @Test
        public void 更新したデータを取得できる() {
            sut.insert(ShinsakaiTestEntityCreator.create審査会割当委員情報Entity(1, "19990101", "iin01", new Code("shinsainKubun01")));
            sut.update(ShinsakaiTestEntityCreator.create審査会割当委員情報Entity(1, "19990101", "iin01", new Code("shinsainKubun02")));

            開催番号 = new ShinsakaiKaisaiNo(1);
            開催年月日 = new FlexibleDate("19990101");
            List<DbT5106ShinsakaiWariateIinJohoEntity> result = sut.select(開催番号, 開催年月日);
            assertThat(result.get(0).getShinsainKubunCode(), is(new Code("shinsainKubun02")));
        }
    }

    public static class deleteのテスト extends DbeTestDacBase {

        @Test
        public void 削除された情報は取得できない() {
            sut.insert(ShinsakaiTestEntityCreator.create審査会割当委員情報Entity(1, "19990101", "iin01"));
            sut.delete(ShinsakaiTestEntityCreator.create審査会割当委員情報Entity(1, "19990101", "iin01"));

            開催番号 = new ShinsakaiKaisaiNo(1);
            開催年月日 = new FlexibleDate("19990101");
            List<DbT5106ShinsakaiWariateIinJohoEntity> result = sut.select(開催番号, 開催年月日);
            assertThat(result.isEmpty(), is(true));
        }
    }

    public static class insertOrUpdateのテスト extends DbeTestDacBase {

        @Test
        public void test() {
            //TODO n8178 城間篤人 insertOrUpdateの実装法が確定した後に作成予定 2014年4月
        }
    }
}
