/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.basic;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.ShinsakaiKaisaiBashoJokyo;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.ShinsakaiKaisaiBashoChikuCode;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.ShinsakaiKaisaiBashoCode;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5104ShinsakaiKaisaiBashoJohoEntity;
import jp.co.ndensan.reams.db.dbe.persistence.basic.helper.IShinsakaiKaisaiBashoDacMock;
import jp.co.ndensan.reams.db.dbz.testhelper.DbeTestDacBase;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.testhelper.TestDacBase;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceCreator;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * 審査会開催場所情報Dacのテストクラスです。
 *
 * @author N1013 松本直樹
 */
@RunWith(Enclosed.class)
public class ShinsakaiKaisaiBashoDacTest extends DbeTestDacBase {

    private static IShinsakaiKaisaiBashoDacMock inserter;
    private static IShinsakaiKaisaiBashoDac sut;
    private static ShinsakaiKaisaiBashoJokyo ShinsakaiKaisaiBashoJokyo;

    @BeforeClass
    public static void setUpClass() {
        inserter = InstanceCreator.create(IShinsakaiKaisaiBashoDacMock.class);
        sut = InstanceCreator.create(IShinsakaiKaisaiBashoDac.class);
    }

    public static class insertのテスト extends DbeTestDacBase {

        private ShinsakaiKaisaiBashoCode 開催場所コード;
        private RString 開催場所名称;
        private ShinsakaiKaisaiBashoChikuCode 開催場所地区コード;
        private AtenaJusho 開催場所住所;
        private TelNo 開催場所電話番号;
        private boolean 開催場所状況;
        private DbT5104ShinsakaiKaisaiBashoJohoEntity 更新用entity;

        @Before
        public void setUp() {
            開催場所コード = new ShinsakaiKaisaiBashoCode(new RString("00001"));
            開催場所名称 = new RString("市役所会議室");
            開催場所地区コード = new ShinsakaiKaisaiBashoChikuCode(new RString("00002"));
            開催場所住所 = new AtenaJusho(new RString("長野市鶴賀"));
            開催場所電話番号 = new TelNo(new RString("026-263-5555"));
            開催場所状況 = true;

            更新用entity = create審査会開催場所情報Entity(開催場所コード, 開催場所名称, 開催場所地区コード,
                    開催場所住所, 開催場所電話番号, 開催場所状況);

            setDummyControlData(new RString("DBE"));
            openMainSession();
        }

        @Test
        public void データ追加後の開催場所名が_引数から渡した開催場所名と同一になる() {
            //sut.delete(更新用entity);
            sut.insertOrUpdate(更新用entity);
            assertThat(sut.select(開催場所コード).getShinsakaiKaisaiBashoMei(), is(開催場所名称));
        }

        @Test
        public void データ追加後の開催場所住所が_引数から渡した開催場所住所と同一になる() {
            //sut.delete(更新用entity);
            sut.insertOrUpdate(更新用entity);
            assertThat(sut.select(開催場所コード).getShinsakaiKaisaiBashoJusho(), is(開催場所住所));
        }

        @Test
        public void データ追加後の開催場所地区コードが_引数から渡した開催場所地区コードと同一になる() {
            //sut.delete(更新用entity);
            sut.insertOrUpdate(更新用entity);
            assertThat(sut.select(開催場所コード).getShinsakaiKaisaiChikuCode(), is(開催場所地区コード));
        }

        @Test
        public void データ追加後の開催場所電話番号が_引数から渡した開催場所電話番号と同一になる() {
            //sut.delete(更新用entity);
            sut.insertOrUpdate(更新用entity);
            assertThat(sut.select(開催場所コード).getShinsakaiKaisaiBashoTelNo(), is(開催場所電話番号));
        }

        @Test
        public void データ追加後の開催場所状況が_引数から渡した開催場所状況と同一になる() {
            //sut.delete(更新用entity);
            sut.insertOrUpdate(更新用entity);
            assertThat(sut.select(開催場所コード).getShinsakaiKaisaiBashoJokyo(), is(開催場所状況));
        }

        @After
        public void tearDownClassTest() {
            rollBackAndCloseSession();
        }
    }

    public static class selectのテスト extends DbeTestDacBase {

        private ShinsakaiKaisaiBashoCode 開催場所コード;
        private RString 開催場所名称;
        private ShinsakaiKaisaiBashoChikuCode 開催場所地区コード;
        private AtenaJusho 開催場所住所;
        private TelNo 開催場所電話番号;
        private boolean 開催場所状況;
        private DbT5104ShinsakaiKaisaiBashoJohoEntity 更新用entity;

        @Before
        public void setUp() {
            開催場所コード = new ShinsakaiKaisaiBashoCode(new RString("00001"));
            開催場所名称 = new RString("市役所会議室");
            開催場所地区コード = new ShinsakaiKaisaiBashoChikuCode(new RString("00002"));
            開催場所住所 = new AtenaJusho(new RString("長野市鶴賀"));
            開催場所電話番号 = new TelNo(new RString("026-263-5555"));
            開催場所状況 = true;

            更新用entity = create審査会開催場所情報Entity(開催場所コード, 開催場所名称, 開催場所地区コード,
                    開催場所住所, 開催場所電話番号, 開催場所状況);
            sut.insertOrUpdate(更新用entity);

        }

        @Test
        public void 審査会開催場所コードに00001を指定したとき＿検索結果が得られ＿その審査会開催場所コードは00001となる() {
            ShinsakaiKaisaiBashoCode 開催場所コード = new ShinsakaiKaisaiBashoCode(new RString("00001"));
            DbT5104ShinsakaiKaisaiBashoJohoEntity result = sut.select(開催場所コード);
            assertThat(result.getShinsakaiKaisaiBashoCode(), is(開催場所コード));
        }

        @Test
        public void 審査会開催場所コードに00001を指定し且つ現在有効審査会開催場所の取得指示をしたとき＿検索結果が得られ＿その審査会開催場所はコードが00001で有効な情報である() {
            ShinsakaiKaisaiBashoCode 開催場所コード = new ShinsakaiKaisaiBashoCode(new RString("00001"));
            DbT5104ShinsakaiKaisaiBashoJohoEntity result = sut.select(開催場所コード, ShinsakaiKaisaiBashoJokyo.有効);
            assertThat(result.getShinsakaiKaisaiBashoCode(), is(開催場所コード));
            assertThat(result.getShinsakaiKaisaiBashoJokyo(), is(true));
        }
    }

    public static class selectAllのテスト extends DbeTestDacBase {

        private ShinsakaiKaisaiBashoCode 開催場所コード;
        private ShinsakaiKaisaiBashoChikuCode 開催場所地区コード;

        @Before
        public void setUp() {
        }

        @Test
        public void 開催場所情報が_全件取得できる() {
            開催場所コード = new ShinsakaiKaisaiBashoCode(new RString("00002"));
            開催場所地区コード = new ShinsakaiKaisaiBashoChikuCode(new RString("00001"));
            inserter.insert(create審査会開催場所情報Entity(開催場所コード, new RString("開催場所名２"),
                    開催場所地区コード, new AtenaJusho(new RString("開催場所住所２")), new TelNo(new RString("開催場所電話番号２")), false));
            開催場所コード = new ShinsakaiKaisaiBashoCode(new RString("00003"));
            inserter.insert(create審査会開催場所情報Entity(開催場所コード, new RString("開催場所名３"),
                    開催場所地区コード, new AtenaJusho(new RString("開催場所住所３")), new TelNo(new RString("開催場所電話番号３")), true));
            開催場所コード = new ShinsakaiKaisaiBashoCode(new RString("00004"));
            inserter.insert(create審査会開催場所情報Entity(開催場所コード, new RString("開催場所名４"),
                    開催場所地区コード, new AtenaJusho(new RString("開催場所住所４")), new TelNo(new RString("開催場所電話番号４")), false));
            List<DbT5104ShinsakaiKaisaiBashoJohoEntity> results = sut.selectAll();
            assertThat(results.size(), is(3));
        }

        @Test
        public void 有効な開催場所情報が_全件取得できる() {
            List<DbT5104ShinsakaiKaisaiBashoJohoEntity> results = sut.selectAll(ShinsakaiKaisaiBashoJokyo.有効);
            assertThat(results.size(), is(1));
        }
    }

    public static class updateのテスト extends DbeTestDacBase {

        private ShinsakaiKaisaiBashoCode 開催場所コード;
        private RString 開催場所名称;
        private ShinsakaiKaisaiBashoChikuCode 開催場所地区コード;
        private AtenaJusho 開催場所住所;
        private TelNo 開催場所電話番号;
        private boolean 開催場所状況;
        private DbT5104ShinsakaiKaisaiBashoJohoEntity 更新用entity;

        @Before
        public void setUp() {
            開催場所コード = new ShinsakaiKaisaiBashoCode(new RString("00001"));
//            開催場所地区コード = new ShinsakaiKaisaiBashoChikuCode(new RString("00001"));

            開催場所名称 = new RString("市役所会議室");
            開催場所地区コード = new ShinsakaiKaisaiBashoChikuCode(new RString("00002"));
            開催場所住所 = new AtenaJusho(new RString("長野市鶴賀"));
            開催場所電話番号 = new TelNo(new RString("026-263-5555"));
            開催場所状況 = true;

            更新用entity = create審査会開催場所情報Entity(開催場所コード, 開催場所名称, 開催場所地区コード,
                    開催場所住所, 開催場所電話番号, 開催場所状況);

            setDummyControlData(new RString("DBE"));
            openMainSession();
        }

        @Test
        public void 更新後の開催場所名が_引数から渡した開催場所名と同一になる() {
            sut.insertOrUpdate(更新用entity);
            assertThat(sut.select(開催場所コード).getShinsakaiKaisaiBashoMei(), is(開催場所名称));
        }

        @Test
        public void 更新後の開催場所住所が_引数から渡した開催場所住所と同一になる() {
            sut.insertOrUpdate(更新用entity);
            assertThat(sut.select(開催場所コード).getShinsakaiKaisaiBashoJusho(), is(開催場所住所));
        }

        @Test
        public void 更新後の開催場所地区コードが_引数から渡した開催場所地区コードと同一になる() {
            sut.insertOrUpdate(更新用entity);
            assertThat(sut.select(開催場所コード).getShinsakaiKaisaiChikuCode(), is(開催場所地区コード));
        }

        @Test
        public void 更新後の開催場所電話番号が_引数から渡した開催場所電話番号と同一になる() {
            sut.insertOrUpdate(更新用entity);
            assertThat(sut.select(開催場所コード).getShinsakaiKaisaiBashoTelNo(), is(開催場所電話番号));
        }

        @Test
        public void 更新後の開催場所状況が_引数から渡した開催場所状況と同一になる() {
            sut.insertOrUpdate(更新用entity);
            assertThat(sut.select(開催場所コード).getShinsakaiKaisaiBashoJokyo(), is(開催場所状況));
        }

        @After
        public void tearDownClassTest() {
            rollBackAndCloseSession();
        }
    }

    public static class deleteのテスト extends DbeTestDacBase {

        private ShinsakaiKaisaiBashoCode 開催場所コード;
        private RString 開催場所名称;
        private ShinsakaiKaisaiBashoChikuCode 開催場所地区コード;
        private AtenaJusho 開催場所住所;
        private TelNo 開催場所電話番号;
        private boolean 開催場所状況;
        private DbT5104ShinsakaiKaisaiBashoJohoEntity 更新用entity;

        @Before
        public void setUp() {
            開催場所地区コード = new ShinsakaiKaisaiBashoChikuCode(new RString("00001"));
            開催場所コード = new ShinsakaiKaisaiBashoCode(new RString("00001"));
            inserter.insert(create審査会開催場所情報Entity(開催場所コード, new RString("開催場所名"), 開催場所地区コード,
                    new AtenaJusho(new RString("開催場所住所")), new TelNo(new RString("開催場所電話番号")), false));

            更新用entity = create審査会開催場所情報Entity(開催場所コード, new RString("開催場所名"), 開催場所地区コード,
                    new AtenaJusho(new RString("開催場所住所")), new TelNo(new RString("開催場所電話番号")), false);

        }

        @Test
        public void 削除後の更新件数は1件が返る() {
            int count = sut.delete(更新用entity);
            assertThat(count, is(1));
        }
    }

    private static DbT5104ShinsakaiKaisaiBashoJohoEntity create審査会開催場所情報Entity(ShinsakaiKaisaiBashoCode 開催場所コード, RString 開催場所名称,
            ShinsakaiKaisaiBashoChikuCode 開催場所地区コード, AtenaJusho 開催場所住所,
            TelNo 開催場所電話番号, boolean 開催場所状況) {
        DbT5104ShinsakaiKaisaiBashoJohoEntity entity = new DbT5104ShinsakaiKaisaiBashoJohoEntity();
        entity.setInsertDantaiCd(new RString("000000001"));
        entity.setIsDeleted(false);
        entity.setLastUpdateReamsLoginId(new RString("0001"));
        entity.setShinsakaiKaisaiBashoCode(開催場所コード);
        entity.setShinsakaiKaisaiBashoMei(開催場所名称);
        entity.setShinsakaiKaisaiChikuCode(開催場所地区コード);
        entity.setShinsakaiKaisaiBashoJusho(開催場所住所);
        entity.setShinsakaiKaisaiBashoTelNo(開催場所電話番号);
        entity.setShinsakaiKaisaiBashoJokyo(開催場所状況);
        return entity;
    }
}
