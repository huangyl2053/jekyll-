/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.basic;

import java.util.Collections;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbV3104KokuhorenTorikomiJohoEntity;
import jp.co.ndensan.reams.db.dbc.entity.basic.helper.DbV3104KokuhorenTorikomiJohoEntityGenerator;
import jp.co.ndensan.reams.db.dbc.persistence.basic.DbV3104KokuhorenTorikomiJohoDac;
import static jp.co.ndensan.reams.db.dbc.entity.basic.helper.DbV3104KokuhorenTorikomiJohoEntityGenerator.DEFAULT_交換情報識別番号;
import static jp.co.ndensan.reams.db.dbc.entity.basic.helper.DbV3104KokuhorenTorikomiJohoEntityGenerator.DEFAULT_処理年月;
import jp.co.ndensan.reams.db.dbz.testhelper.DbcTestDacBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link DbV3104KokuhorenTorikomiJohoDac}のテストです。
 */
@RunWith(Enclosed.class)
@Ignore
public class DbV3104KokuhorenTorikomiJohoDacTest extends DbcTestDacBase {

    private static final RString キー_01 = new RString("01");
    private static final RString キー_02 = new RString("02");
    private static final RString キー_03 = new RString("03");
    private static DbV3104KokuhorenTorikomiJohoDac sut;

    @BeforeClass
    public static void setUpClass() {
        sut = InstanceProvider.create(DbV3104KokuhorenTorikomiJohoDac.class);
    }

    public static class selectByKeyのテスト extends DbcTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_処理年月,
                    DEFAULT_交換情報識別番号);
            TestSupport.insert(
                    DEFAULT_処理年月,
                    DEFAULT_交換情報識別番号);
        }

        @Test(expected = NullPointerException.class)
        public void 処理年月がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_処理年月,
                    DEFAULT_交換情報識別番号);
        }

        @Test(expected = NullPointerException.class)
        public void 交換情報識別番号がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_処理年月,
                    DEFAULT_交換情報識別番号);
        }

        @Test
        public void 存在する主キーを渡すと_selectByKeyは_該当のエンティティを返す() {
            DbV3104KokuhorenTorikomiJohoEntity insertedRecord = sut.selectByKey(
                    DEFAULT_処理年月,
                    DEFAULT_交換情報識別番号);
            assertThat(insertedRecord, is(notNullValue()));
        }

        @Test
        public void 存在しない主キーを渡すと_selectByKeyは_nullを返す() {
            DbV3104KokuhorenTorikomiJohoEntity insertedRecord = sut.selectByKey(
                    DEFAULT_処理年月,
                    DEFAULT_交換情報識別番号);
            assertThat(insertedRecord, is(nullValue()));
        }
    }

    public static class selectAllのテスト extends DbcTestDacBase {

        @Test
        public void 国保連取り込み情報が存在する場合_selectAllは_全件を返す() {
            TestSupport.insert(
                    DEFAULT_処理年月,
                    DEFAULT_交換情報識別番号);
            TestSupport.insert(
                    DEFAULT_処理年月,
                    DEFAULT_交換情報識別番号);
            assertThat(sut.selectAll().size(), is(2));
        }

        @Test
        public void 国保連取り込み情報が存在しない場合_selectAllは_空のリストを返す() {
            assertThat(sut.selectAll(), is(Collections.EMPTY_LIST));
        }
    }

    public static class insertのテスト extends DbcTestDacBase {

        @Test
        public void 国保連取り込み情報エンティティを渡すと_insertは_国保連取り込み情報を追加する() {
            TestSupport.insert(
                    DEFAULT_処理年月,
                    DEFAULT_交換情報識別番号);

            assertThat(sut.selectByKey(
                    DEFAULT_処理年月,
                    DEFAULT_交換情報識別番号), is(notNullValue()));
        }
    }

    public static class updateのテスト extends DbcTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_処理年月,
                    DEFAULT_交換情報識別番号);
        }

        @Test
        public void 国保連取り込み情報エンティティを渡すと_updateは_国保連取り込み情報を更新する() {
            DbV3104KokuhorenTorikomiJohoEntity updateRecord = sut.selectByKey(
                    DEFAULT_処理年月,
                    DEFAULT_交換情報識別番号);
            // TODO  主キー以外の項目を変更してください
            //updateRecord.set変更したい項目(75);

            sut.save(updateRecord);

            DbV3104KokuhorenTorikomiJohoEntity updatedRecord = sut.selectByKey(
                    DEFAULT_処理年月,
                    DEFAULT_交換情報識別番号);

            // TODO  主キー以外の項目を変更してください
            //assertThat(updateRecord.get変更したい項目(), is(updatedRecord.get変更したい項目()));
        }
    }

    public static class deleteのテスト extends DbcTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_処理年月,
                    DEFAULT_交換情報識別番号);
        }

        @Test
        public void 国保連取り込み情報エンティティを渡すと_deleteは_国保連取り込み情報を削除する() {
            DbV3104KokuhorenTorikomiJohoEntity deletedEntity = sut.selectByKey(
                    DEFAULT_処理年月,
                    DEFAULT_交換情報識別番号);
            deletedEntity.setState(EntityDataState.Deleted);

            sut.save(deletedEntity);

            assertThat(sut.selectByKey(
                    DEFAULT_処理年月,
                    DEFAULT_交換情報識別番号), is(nullValue()));
        }
    }

    private static class TestSupport {

        public static void insert(
                FlexibleYearMonth 処理年月,
                RString 交換情報識別番号) {
            DbV3104KokuhorenTorikomiJohoEntity entity = DbV3104KokuhorenTorikomiJohoEntityGenerator.createDbV3104KokuhorenTorikomiJohoEntity();
            entity.setShoriYM(処理年月);
            entity.setKokanShikibetsuNo(交換情報識別番号);
            sut.save(entity);
        }
    }
}
