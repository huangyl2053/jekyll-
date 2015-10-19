/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.db.basic;

import jp.co.ndensan.reams.db.dbe.persistence.db.basic.GogitaiJohoDac;
import jp.co.ndensan.reams.db.dbe.definition.core.valueobject.GogitaiNo;
import jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5103GogitaiJohoEntity;
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
 * 合議体Dacのテストです。
 *
 * @author n8178 城間篤人
 */
@RunWith(Enclosed.class)
public class GogitaiJohoDacTest {

    private static GogitaiJohoDac sut;

    @BeforeClass
    public static void setUpClass() {
        sut = InstanceProvider.create(GogitaiJohoDac.class);
    }

    public static class select_合議体を渡したときのテスト extends DbeTestDacBase {

        @Before
        public void setUp() {
            sut.insert(create合議体Entity(1, "19991212", "20011212", "合議体01"));
            sut.insert(create合議体Entity(2, "20011012", "20021012", "合議体02"));
            sut.insert(create合議体Entity(2, "20080228", "20090228", "合議体02"));
            sut.insert(create合議体Entity(1, "20040102", "20060102", "合議体01"));
            sut.insert(create合議体Entity(1, "20070908", "20090908", "合議体01"));
        }

        @Test
        public void 合議体番号に1を指定したとき_3件のリストが返る() {
            assertThat(sut.select(new GogitaiNo(1)).size(), is(3));
        }

        @Test
        public void 合議体番号に2を指定したとき_2件のリストが返る() {
            assertThat(sut.select(new GogitaiNo(2)).size(), is(2));
        }
    }

    public static class select_年月日を渡したときのテスト extends DbeTestDacBase {

        @Before
        public void setUp() {
            sut.insert(create合議体Entity(1, "19990101", "20010101", "合議体01"));
            sut.insert(create合議体Entity(2, "20000101", "20020101", "合議体02"));
            sut.insert(create合議体Entity(2, "20080101", "20120101", "合議体02"));
            sut.insert(create合議体Entity(1, "20050101", "20090101", "合議体01"));
            sut.insert(create合議体Entity(1, "20100101", "20120101", "合議体01"));
        }

        @Test
        public void 年月日に2000_01_01を指定したとき_2件のリストが返る() {
            assertThat(sut.select(new FlexibleDate("20000101")).size(), is(2));
        }

        @Test
        public void 年月日に2008_05_01を指定したとき_2件のリストが返る() {
            assertThat(sut.select(new FlexibleDate("20080501")).size(), is(2));
        }

        @Test
        public void 年月日に2011_01_01を指定したとき_2件のリストが返る() {
            assertThat(sut.select(new FlexibleDate("20110101")).size(), is(2));
        }
    }

    public static class select_合議体番号と基準年月日を渡したときのテスト extends DbeTestDacBase {

        @Before
        public void setUp() {
            sut.insert(create合議体Entity(1, "19990101", "19991231", "合議体01"));
            sut.insert(create合議体Entity(1, "20000101", "20001231", "合議体01"));
            sut.insert(create合議体Entity(1, "20010101", "20011231", "合議体01"));
            sut.insert(create合議体Entity(1, "20020101", "20021231", "合議体01"));
            sut.insert(create合議体Entity(1, "20030101", "20031231", "合議体01"));
        }

        @Test
        public void 合議体番号に1_年月日19991231を指定したとき_有効期間開始年月日が19990101の合議体が返る() {
            DbT5103GogitaiJohoEntity result = sut.select(new GogitaiNo(1), new FlexibleDate("19991231"));
            assertThat(result.getGogitaiYukoKikanKaishiYMD(), is(new FlexibleDate("19990101")));
        }

        @Test
        public void 合議体番号に1_年月日20000101を指定したとき_有効期間開始年月日が20000101の合議体が返る() {
            DbT5103GogitaiJohoEntity result = sut.select(new GogitaiNo(1), new FlexibleDate("20000101"));
            assertThat(result.getGogitaiYukoKikanKaishiYMD(), is(new FlexibleDate("20000101")));
        }
    }

    //TODO n8178 城間篤人 insertOrUpdate実装が完了後に改めてテスト 2014年3月末
//    public static class insertOrUpdateのテスト {
//    }
    public static class insertのテスト extends DbeTestDacBase {

        @Test
        public void insertに成功し_1が返る() {
            int result = sut.insert(create合議体Entity(1, "19990101", "20010101", "合議体01"));
            assertThat(result, is(1));
        }
    }

    public static class updateのテスト extends DbeTestDacBase {

        @Test
        public void updateに成功し_1が返る() {
            sut.insert(create合議体Entity(1, "19990101", "99999999", "合議体01"));
            int result = sut.update(create合議体Entity(1, "19990101", "20010101", "合議体01"));
            assertThat(result, is(1));
        }

        @Test
        public void updateに成功し_selectで取得した合議体の終了年月日が_20010101に変更される() {
            sut.insert(create合議体Entity(1, "19990101", "99999999", "合議体01"));
            sut.update(create合議体Entity(1, "19990101", "20010101", "合議体01"));
            assertThat(sut.select(new GogitaiNo(1)).get(0).getGogitaiYukoKikanShuryoYMD(), is(new FlexibleDate("20010101")));
        }
    }

    public static class deleteのテスト extends DbeTestDacBase {

        @Test
        public void deleteに成功した場合_1が返る() {
            sut.insert(create合議体Entity(1, "19990101", "99999999", "合議体01"));
            int result = sut.delete(create合議体Entity(1, "19990101", "99999999", "合議体01"));
            assertThat(result, is(1));
        }

        @Test
        public void deleteに成功した場合_selectで取得できない() {
            sut.insert(create合議体Entity(1, "19990101", "99999999", "合議体01"));
            sut.delete(create合議体Entity(1, "19990101", "99999999", "合議体01"));
            assertThat(sut.select(new GogitaiNo(1)).size(), is(0));
        }
    }

    private static DbT5103GogitaiJohoEntity create合議体Entity(int 合議体番号, String 開始年月日, String 終了年月日, String 合議体名称) {
        DbT5103GogitaiJohoEntity entity = new DbT5103GogitaiJohoEntity();
        entity.setGogitaiNo(合議体番号);
        entity.setGogitaiMei(new RString(合議体名称));
        entity.setGogitaiYukoKikanKaishiYMD(new FlexibleDate(開始年月日));
        entity.setGogitaiYukoKikanShuryoYMD(new FlexibleDate(終了年月日));
        entity.setGogitaiKaishiYoteiTime(new RString("0830"));
        entity.setGogitaiShuryoYoteiTime(new RString("0830"));
        entity.setShinsakaiKaisaiBashoCode(new RString("A001"));
        entity.setShinsakaiYoteiTeiin(5);
        entity.setShinsakaiJidoWariateTeiin(6);
        entity.setShinsakaiIinTeiin(7);
        entity.setGogitaiSeishinkaSonzaiFlag(true);
        entity.setGogitaiDummyFlag(false);
        return entity;
    }
}
