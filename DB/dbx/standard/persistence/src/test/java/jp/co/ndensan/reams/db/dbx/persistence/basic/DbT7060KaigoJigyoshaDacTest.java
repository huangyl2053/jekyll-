/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.persistence.basic;

import java.util.Collections;
import jp.co.ndensan.reams.db.dbx.entity.basic.DbT7060KaigoJigyoshaEntity;
import jp.co.ndensan.reams.db.dbx.entity.basic.helper.DbT7060KaigoJigyoshaEntityGenerator;
import static jp.co.ndensan.reams.db.dbx.entity.basic.helper.DbT7060KaigoJigyoshaEntityGenerator.*;
import jp.co.ndensan.reams.db.dbx.testhelper.DbxTestDacBase;
import jp.co.ndensan.reams.db.dbx.testhelper.helper.CSVDataUtilForUseSession;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.KaigoJigyoshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link DbT7060KaigoJigyoshaDac}のテストです。
 *
 * @author n3317 塚田萌
 */
@RunWith(Enclosed.class)
public class DbT7060KaigoJigyoshaDacTest extends DbxTestDacBase {

    private static DbT7060KaigoJigyoshaDac sut;

    @BeforeClass
    public static void setUpClass() {
        sut = InstanceProvider.create(DbT7060KaigoJigyoshaDac.class);
    }

    public static class selectByKeyのテスト extends DbxTestDacBase {

        @Before
        public void setUp() {
            TestSupport.deleteData();
            TestSupport.insert(
                    DEFAULT_事業者番号,
                    DEFAULT_有効開始日);
            TestSupport.insert(
                    new KaigoJigyoshaNo("1234567891"),
                    DEFAULT_有効開始日);
        }

        @Test(expected = NullPointerException.class)
        public void 事業者番号がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    null,
                    DEFAULT_有効開始日);
        }

        @Test(expected = NullPointerException.class)
        public void 有効開始日がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_事業者番号,
                    null);
        }

        @Test
        public void 存在する主キーを渡すと_selectByKeyは_該当のエンティティを返す() {
            DbT7060KaigoJigyoshaEntity insertedRecord = sut.selectByKey(
                    DEFAULT_事業者番号,
                    DEFAULT_有効開始日);
            assertThat(insertedRecord, is(notNullValue()));
        }

        @Test
        public void 存在しない主キーを渡すと_selectByKeyは_nullを返す() {
            DbT7060KaigoJigyoshaEntity insertedRecord = sut.selectByKey(
                    new KaigoJigyoshaNo("1234567892"),
                    DEFAULT_有効開始日);
            assertThat(insertedRecord, is(nullValue()));
        }
    }

    @RunWith(Enclosed.class)
    public static class selectActive介護事業者BykeyTest extends DbxTestDacBase {

        private static final FlexibleDate 有効開始日1 = DEFAULT_有効開始日;
        private static final FlexibleDate 有効開始日2 = new FlexibleDate("20160401");
        private static final FlexibleDate 有効終了日1 = DEFAULT_有効終了日;

        public static class 一度終了したサービスを同一の事業所がもう一度始めて現在も有効なとき {

            @Before
            public void setUp() {
                TestSupport.deleteData();
                TestSupport.insert(DEFAULT_事業者番号, 有効開始日1, 有効終了日1);
                TestSupport.insert(DEFAULT_事業者番号, 有効開始日2, new FlexibleDate(""));
            }

            @Test(expected = NullPointerException.class)
            public void 引数の事業者番号にnullを指定した場合_NullPointerExceptionが発生する() {
                sut.selectActive介護事業者Bykey(
                        null,
                        有効開始日1);
            }

            @Test(expected = NullPointerException.class)
            public void 引数の基準日にnullを指定した場合_NullPointerExceptionを発生させる() {
                sut.selectActive介護事業者Bykey(
                        DEFAULT_事業者番号,
                        null);
            }

            @Test
            public void データが見つかない検索条件を渡すと_nullを返す() {
                DbT7060KaigoJigyoshaEntity result = sut.selectActive介護事業者Bykey(
                        new KaigoJigyoshaNo("0000000000"),
                        有効開始日1);
                assertThat(result, is(nullValue()));
            }

            @Test
            public void 事業者番号が一致し_引数の基準日が有効開始日1より前の日の場合_nullを返す() {
                DbT7060KaigoJigyoshaEntity result = sut.selectActive介護事業者Bykey(
                        DEFAULT_事業者番号,
                        有効開始日1.minusDay(1));
                assertThat(result, is(nullValue()));
            }

            @Test
            public void 事業者番号が一致し_引数の基準日が有効開始日1の場合_該当のエンティティを返す() {
                DbT7060KaigoJigyoshaEntity result = sut.selectActive介護事業者Bykey(
                        DEFAULT_事業者番号,
                        有効開始日1);
                assertThat(result.getJigyoshaNo(), is(DEFAULT_事業者番号));
                assertThat(result.getYukoKaishiYMD(), is(有効開始日1));
            }

            @Test
            public void 事業者番号が一致し_引数の基準日が有効開始日1と終了日1の間の場合_該当のエンティティを返す() {
                DbT7060KaigoJigyoshaEntity result = sut.selectActive介護事業者Bykey(
                        DEFAULT_事業者番号,
                        有効開始日1.plusDay(1));
                assertThat(result.getJigyoshaNo(), is(DEFAULT_事業者番号));
                assertThat(result.getYukoKaishiYMD(), is(有効開始日1));
            }

            @Test
            public void 事業者番号が一致し_引数の基準日が有効終了日1の場合_該当のエンティティを返す() {
                DbT7060KaigoJigyoshaEntity result = sut.selectActive介護事業者Bykey(
                        DEFAULT_事業者番号,
                        有効終了日1);
                assertThat(result.getJigyoshaNo(), is(DEFAULT_事業者番号));
                assertThat(result.getYukoKaishiYMD(), is(有効開始日1));
            }

            @Test
            public void 事業者番号が一致し_引数の基準日が有効終了日1より後の日かつ有効開始日2より前の日の場合_nullを返す() {
                DbT7060KaigoJigyoshaEntity result = sut.selectActive介護事業者Bykey(
                        DEFAULT_事業者番号,
                        有効終了日1.plusDay(1));
                assertThat(result, is(nullValue()));
            }

            @Test
            public void 事業者番号が一致し_引数の基準日が有効開始日2の場合_該当のエンティティを返す() {
                DbT7060KaigoJigyoshaEntity result = sut.selectActive介護事業者Bykey(
                        DEFAULT_事業者番号,
                        有効開始日2);
                assertThat(result.getJigyoshaNo(), is(DEFAULT_事業者番号));
                assertThat(result.getYukoKaishiYMD(), is(有効開始日2));
            }

            @Test
            public void 事業者番号が一致し_引数の基準日が有効開始日2より後の日の場合_該当のエンティティを返す() {
                DbT7060KaigoJigyoshaEntity result = sut.selectActive介護事業者Bykey(
                        DEFAULT_事業者番号,
                        有効開始日2.plusDay(1));
                assertThat(result.getJigyoshaNo(), is(DEFAULT_事業者番号));
                assertThat(result.getYukoKaishiYMD(), is(有効開始日2));
            }
        }

        public static class 現在有効なサービスの有効終了日にnullが設定されている時 {

            @Before
            public void setUp() {
                TestSupport.deleteData();
                TestSupport.insert(DEFAULT_事業者番号, 有効開始日1, 有効終了日1);
                TestSupport.insert(DEFAULT_事業者番号, 有効開始日2, null);
            }

            @Test
            public void 事業者番号が一致し_引数の基準日が有効終了日1より後の日かつ有効開始日2より前の日の場合_nullを返す() {
                DbT7060KaigoJigyoshaEntity result = sut.selectActive介護事業者Bykey(
                        DEFAULT_事業者番号,
                        有効終了日1.plusDay(1));
                assertThat(result, is(nullValue()));
            }

            @Test
            public void 事業者番号が一致し_引数の基準日が有効開始日2の場合_該当のエンティティを返す() {
                DbT7060KaigoJigyoshaEntity result = sut.selectActive介護事業者Bykey(
                        DEFAULT_事業者番号,
                        有効開始日2);
                assertThat(result.getJigyoshaNo(), is(DEFAULT_事業者番号));
                assertThat(result.getYukoKaishiYMD(), is(有効開始日2));
            }

            @Test
            public void 事業者番号が一致し引数の基準日が有効開始日2より後の日の場合_該当のエンティティを返す() {
                DbT7060KaigoJigyoshaEntity result = sut.selectActive介護事業者Bykey(
                        DEFAULT_事業者番号,
                        有効開始日2.plusDay(1));
                assertThat(result.getJigyoshaNo(), is(DEFAULT_事業者番号));
                assertThat(result.getYukoKaishiYMD(), is(有効開始日2));
            }
        }
    }

    public static class selectAllのテスト extends DbxTestDacBase {

        @Test
        public void 介護事業者が存在する場合_selectAllは_全件を返す() {
            TestSupport.deleteData();
            TestSupport.insert(
                    DEFAULT_事業者番号,
                    DEFAULT_有効開始日);
            TestSupport.insert(
                    new KaigoJigyoshaNo("1234567891"),
                    DEFAULT_有効開始日);
            assertThat(sut.selectAll().size(), is(2));
        }

        @Test
        public void 介護事業者が存在しない場合_selectAllは_空のリストを返す() {
            assertThat(sut.selectAll(), is(Collections.EMPTY_LIST));
        }
    }

    public static class insertのテスト extends DbxTestDacBase {

        @Test
        public void 介護事業者エンティティを渡すと_insertは_介護事業者を追加する() {
            TestSupport.deleteData();
            TestSupport.insert(
                    DEFAULT_事業者番号,
                    DEFAULT_有効開始日);

            assertThat(sut.selectByKey(
                    DEFAULT_事業者番号,
                    DEFAULT_有効開始日), is(notNullValue()));
        }
    }

    public static class updateのテスト extends DbxTestDacBase {

        @Before
        public void setUp() {
            TestSupport.deleteData();
            TestSupport.insert(
                    DEFAULT_事業者番号,
                    DEFAULT_有効開始日);
        }

        @Test
        public void 介護事業者エンティティを渡すと_updateは_介護事業者を更新する() {
            DbT7060KaigoJigyoshaEntity updateRecord = DbT7060KaigoJigyoshaEntityGenerator.createDbT7060KaigoJigyoshaEntity();
            updateRecord.setJigyoshaName(new AtenaMeisho("テスト"));

            sut.update(updateRecord);

            DbT7060KaigoJigyoshaEntity updatedRecord = sut.selectByKey(
                    DEFAULT_事業者番号,
                    DEFAULT_有効開始日);

            assertThat(updateRecord.getJigyoshaName(), is(updatedRecord.getJigyoshaName()));
        }
    }

    public static class deleteのテスト extends DbxTestDacBase {

        @Before
        public void setUp() {
            TestSupport.deleteData();
            TestSupport.insert(
                    DEFAULT_事業者番号,
                    DEFAULT_有効開始日);
        }

        @Test
        public void 介護事業者エンティティを渡すと_deleteは_介護事業者を削除する() {
            sut.delete(sut.selectByKey(
                    DEFAULT_事業者番号,
                    DEFAULT_有効開始日));
            assertThat(sut.selectByKey(
                    DEFAULT_事業者番号,
                    DEFAULT_有効開始日), is(nullValue()));
        }
    }

    private static class TestSupport {

        public static void insert(
                KaigoJigyoshaNo 事業者番号,
                FlexibleDate 有効開始日) {
            DbT7060KaigoJigyoshaEntity entity = DbT7060KaigoJigyoshaEntityGenerator.createDbT7060KaigoJigyoshaEntity();
            entity.setJigyoshaNo(事業者番号);
            entity.setYukoKaishiYMD(有効開始日);
            sut.insert(entity);
        }

        public static void insert(
                KaigoJigyoshaNo 事業者番号,
                FlexibleDate 有効開始日,
                FlexibleDate 有効終了日) {
            DbT7060KaigoJigyoshaEntity entity = DbT7060KaigoJigyoshaEntityGenerator.createDbT7060KaigoJigyoshaEntity();
            entity.setJigyoshaNo(事業者番号);
            entity.setYukoKaishiYMD(有効開始日);
            entity.setYukoShuryoYMD(有効終了日);
            sut.insert(entity);
        }

        public static void deleteData() {
            CSVDataUtilForUseSession utilForUseSession = new CSVDataUtilForUseSession();
            utilForUseSession.clearTable(sqlSession, DbT7060KaigoJigyoshaEntity.TABLE_NAME.toString());
        }
    }
}
