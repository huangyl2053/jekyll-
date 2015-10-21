/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.db.relate;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.core.valueobject.GogitaiNo;
import jp.co.ndensan.reams.db.dbe.definition.core.valueobject.gogitaiyukokikankaishidate.GogitaiYukoKikanKaishiDate;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.GogitaiWariateShinsakaiIinEntity;
import jp.co.ndensan.reams.db.dbe.persistence.db.basic.GogitaiJohoDac;
import jp.co.ndensan.reams.db.dbe.persistence.db.basic.GogitaiWariateDac;
import jp.co.ndensan.reams.db.dbe.persistence.db.basic.ShinsakaiKaisaiBashoDac;
import jp.co.ndensan.reams.db.dbe.persistence.db.relate.helper.ShinsakaiIinDacMock;
import jp.co.ndensan.reams.db.dbz.testhelper.DbeTestDacBase;
import jp.co.ndensan.reams.db.dbe.entity.helper.GogitaiMockEntityCreator;
import jp.co.ndensan.reams.db.dbe.entity.helper.ShinsakaiMockEntityCreator;
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
 * 合議体割当審査会委員Dacのテストです。
 *
 * @author n8178 城間篤人
 */
@RunWith(Enclosed.class)
public class GogitaiWariateShinsakaiIinDacTest {

    private static GogitaiWariateShinsakaiIinDac sut;
    private static ShinsakaiIinDacMock shinsakaiInserter;
    private static GogitaiWariateDac wariateInserter;
    private static GogitaiJohoDac gogitaiJohoInserter;
    private static ShinsakaiKaisaiBashoDac kaisaiBashoInserter;

    @BeforeClass
    public static void setUpClass() {
        sut = InstanceProvider.create(GogitaiWariateShinsakaiIinDac.class);
        shinsakaiInserter = InstanceProvider.create(ShinsakaiIinDacMock.class);
        wariateInserter = InstanceProvider.create(GogitaiWariateDac.class);
        gogitaiJohoInserter = InstanceProvider.create(GogitaiJohoDac.class);
        kaisaiBashoInserter = InstanceProvider.create(ShinsakaiKaisaiBashoDac.class);
    }

    public static class relateしたエンティティを取得できているかのテスト extends DbeTestDacBase {

        @Before
        public void setUp() {
            gogitaiJohoInserter.insert(GogitaiMockEntityCreator.create合議体情報Entity(1, "19990101", "20001231", "basho01"));
            kaisaiBashoInserter.insert(GogitaiMockEntityCreator.create開催場所Entity("basho01"));
            wariateIinInsert(1, "19990101", "20011231", "iin01", "19800101");
        }

        @Test
        public void 取得した合議体割当Entityが持つ_合議体番号が1になる() {
            List<GogitaiWariateShinsakaiIinEntity> result = sut.select(new GogitaiNo(1), new GogitaiYukoKikanKaishiDate("19990101"));
            assertThat(result.get(0).get合議体割当Entity().getGogitaiNo(), is(1));
        }

        @Test
        public void 取得した審査会委員Entityが持つ_委員コードが_iin01になる() {
            List<GogitaiWariateShinsakaiIinEntity> result = sut.select(new GogitaiNo(1), new GogitaiYukoKikanKaishiDate("19990101"));
            assertThat(result.get(0).get審査会委員Entity().getShinsakaiIinCode(), is(new RString("iin01")));
        }

        @Test
        public void 取得した合議体情報Entityが持つ_合議体番号が1になる() {
            List<GogitaiWariateShinsakaiIinEntity> result = sut.select(new GogitaiNo(1), new GogitaiYukoKikanKaishiDate("19990101"));
            assertThat(result.get(0).get合議体情報Entity().getGogitaiNo(), is(1));
        }

        @Test
        public void 取得した開催場所Entityが持つ_合議体番号が1になる() {
            List<GogitaiWariateShinsakaiIinEntity> result = sut.select(new GogitaiNo(1), new GogitaiYukoKikanKaishiDate("19990101"));
            assertThat(result.get(0).get開催場所Entity().getShinsakaiKaisaiBashoCode(), is(new RString("basho01")));
        }
    }

    public static class select_引数指定なしの全件取得の場合のテスト extends DbeTestDacBase {

        @Before
        public void setUp() {
            gogitaiJohoInserter.insert(GogitaiMockEntityCreator.create合議体情報Entity(1, "19990101", "20001231", "basho01"));
            kaisaiBashoInserter.insert(GogitaiMockEntityCreator.create開催場所Entity("basho01"));
            wariateIinInsert(1, "19990101", "20011231", "iin01", "19800101");
            wariateIinInsert(1, "19990101", "20011231", "iin02", "19801201");

            gogitaiJohoInserter.insert(GogitaiMockEntityCreator.create合議体情報Entity(2, "19990101", "20001231", "basho02"));
            kaisaiBashoInserter.insert(GogitaiMockEntityCreator.create開催場所Entity("basho02"));
            wariateIinInsert(2, "19990101", "20011231", "iin03", "19890101");
            wariateIinInsert(2, "20000101", "20011231", "iin04", "19800101");

            gogitaiJohoInserter.insert(GogitaiMockEntityCreator.create合議体情報Entity(1, "20010101", "20021231", "basho1"));
            wariateIinInsert(1, "20010101", "20021231", "iin05", "19990909");
            wariateIinInsert(1, "20010101", "20021231", "iin06", "19870123");
            wariateIinInsert(1, "20010101", "20021231", "iin07", "19880315");
        }

        @Test
        public void 検索した結果_7件のリストが取得できる() {
            List<GogitaiWariateShinsakaiIinEntity> result = sut.select();
            assertThat(result.size(), is(7));
        }
    }

    public static class select_引数に合議体番号を渡す場合のテスト extends DbeTestDacBase {

        @Before
        public void setUp() {
            gogitaiJohoInserter.insert(GogitaiMockEntityCreator.create合議体情報Entity(1, "19990101", "20001231", "basho01"));
            kaisaiBashoInserter.insert(GogitaiMockEntityCreator.create開催場所Entity("basho01"));
            wariateIinInsert(1, "19990101", "20011231", "iin01", "19800101");
            wariateIinInsert(1, "19990101", "20011231", "iin02", "19801201");

            gogitaiJohoInserter.insert(GogitaiMockEntityCreator.create合議体情報Entity(2, "19990101", "20001231", "basho02"));
            kaisaiBashoInserter.insert(GogitaiMockEntityCreator.create開催場所Entity("basho02"));
            wariateIinInsert(2, "19990101", "20011231", "iin03", "19890101");
            wariateIinInsert(2, "20000101", "20011231", "iin04", "19800101");

            gogitaiJohoInserter.insert(GogitaiMockEntityCreator.create合議体情報Entity(1, "20010101", "20021231", "basho1"));
            wariateIinInsert(1, "20010101", "20021231", "iin05", "19990909");
            wariateIinInsert(1, "20010101", "20021231", "iin06", "19870123");
        }

        @Test
        public void 引数に合議体番号1を指定した場合_4件のリストが取得できる() {
            List<GogitaiWariateShinsakaiIinEntity> result = sut.select(new GogitaiNo(1));
            assertThat(result.size(), is(4));
        }

        @Test
        public void 引数に合議体番号2を指定した場合_2件のリストが取得できる() {
            List<GogitaiWariateShinsakaiIinEntity> result = sut.select(new GogitaiNo(2));
            assertThat(result.size(), is(2));
        }
    }

    public static class select_引数に有効期間開始年月日を渡す場合のテスト extends DbeTestDacBase {

        @Before
        public void setUp() {
            gogitaiJohoInserter.insert(GogitaiMockEntityCreator.create合議体情報Entity(1, "19990101", "20001231", "basho01"));
            kaisaiBashoInserter.insert(GogitaiMockEntityCreator.create開催場所Entity("basho01"));
            wariateIinInsert(1, "19990101", "20011231", "iin01", "19800101");
            wariateIinInsert(1, "19990101", "20011231", "iin02", "19801201");

            gogitaiJohoInserter.insert(GogitaiMockEntityCreator.create合議体情報Entity(2, "19990101", "20001231", "basho02"));
            kaisaiBashoInserter.insert(GogitaiMockEntityCreator.create開催場所Entity("basho02"));
            wariateIinInsert(2, "19990101", "20011231", "iin03", "19890101");
            wariateIinInsert(2, "19990101", "20011231", "iin04", "19800101");

            gogitaiJohoInserter.insert(GogitaiMockEntityCreator.create合議体情報Entity(1, "20010101", "20021231", "basho1"));
            wariateIinInsert(1, "20010101", "20021231", "iin05", "19990909");
            wariateIinInsert(1, "20010101", "20021231", "iin06", "19870123");
        }

        @Test
        public void 引数に19990214を指定した場合_4件のリストが取得できる() {
            List<GogitaiWariateShinsakaiIinEntity> result = sut.select(new GogitaiYukoKikanKaishiDate("19990214"));
            assertThat(result.size(), is(4));
        }

        @Test
        public void 引数に20020314を指定した場合_2件のリストが取得できる() {
            List<GogitaiWariateShinsakaiIinEntity> result = sut.select(new GogitaiYukoKikanKaishiDate("20020314"));
            assertThat(result.size(), is(2));
        }
    }

    public static class select_引数に合議体番号と有効開始年月日を渡す場合のテスト extends DbeTestDacBase {

        @Before
        public void setUp() {
            gogitaiJohoInserter.insert(GogitaiMockEntityCreator.create合議体情報Entity(1, "19990101", "20001231", "basho01"));
            kaisaiBashoInserter.insert(GogitaiMockEntityCreator.create開催場所Entity("basho01"));
            wariateIinInsert(1, "19990101", "20011231", "iin01", "19800101");
            wariateIinInsert(1, "19990101", "20011231", "iin02", "19801201");
            wariateIinInsert(1, "19990101", "20011231", "iin03", "19890101");

            gogitaiJohoInserter.insert(GogitaiMockEntityCreator.create合議体情報Entity(2, "20000101", "20011231", "basho2"));
            kaisaiBashoInserter.insert(GogitaiMockEntityCreator.create開催場所Entity("basho02"));
            wariateIinInsert(2, "20000101", "20011231", "iin04", "19800101");
        }

        @Test
        public void 引数に合議体番号1_開始年月日に19990101を指定した場合_3件のリストが取得できる() {
            List<GogitaiWariateShinsakaiIinEntity> result = sut.select(new GogitaiNo(1), new GogitaiYukoKikanKaishiDate("19990101"));
            assertThat(result.size(), is(3));
        }

        @Test
        public void 引数に合議体番号2_開始年月日に20000101を指定した場合_1件のリストが取得できる() {
            List<GogitaiWariateShinsakaiIinEntity> result = sut.select(new GogitaiNo(2), new GogitaiYukoKikanKaishiDate("20000101"));
            assertThat(result.size(), is(1));
        }
    }

    private static void wariateIinInsert(int 合議体番号, String 合議体開始年月日, String 合議体終了年月日,
            String 委員コード, String 審査会委員開始年月日) {
        shinsakaiInserter.insert(ShinsakaiMockEntityCreator.create審査会委員Entity(委員コード));
        wariateInserter.insert(GogitaiMockEntityCreator.create合議体割当Entity(合議体番号, 委員コード, 合議体開始年月日, 合議体終了年月日));
    }
}
