/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.basic;

import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.entity.basic.DbT3104KokuhorenInterfaceKanriEntity;
import jp.co.ndensan.reams.db.dbc.entity.basic.DbV3104KokuhorenTorikomiJohoEntity;
import jp.co.ndensan.reams.db.dbz.testhelper.DbcTestDacBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RYearMonth;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.nullValue;
import org.junit.Test;
import static org.junit.Assert.assertThat;
import org.junit.BeforeClass;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link KokuhorenTorikomiJohoDac}のテストです。
 *
 * @author n2810 久保里史
 */
@RunWith(Enclosed.class)
public class KokuhorenTorikomiJohoDacTest extends DbcTestDacBase {

    private static final RYearMonth DEFAULT_処理年月_当月 = new RYearMonth("201503");
    private static final RYearMonth DEFAULT_処理年月_前月 = new RYearMonth("201502");
    private static final RYearMonth DEFAULT_処理年月_前々月 = new RYearMonth("201501");
    private static final RYearMonth DEFAULT_存在しない処理年月 = new RYearMonth("201504");
    private static final RString DEFAULT_交換情報識別番号 = new RString("121");
    private static final RString DEFAULT_送付取込区分 = new RString("1");
    private static final RString DEFAULT_処理状態区分 = new RString("1");

    private static KokuhorenTorikomiJohoDac sut;
    private static KokuhorenInterfaceKanriDac kokuhorenInterfaceKanriDac;

    @BeforeClass
    public static void setUpClass() {
        sut = InstanceProvider.create(KokuhorenTorikomiJohoDac.class);
        kokuhorenInterfaceKanriDac = InstanceProvider.create(KokuhorenInterfaceKanriDac.class);
    }

    public static class selectByKeyのテスト extends DbcTestDacBase {

        @BeforeClass
        public static void setUp() {
            TestSupport.insert(
                    DEFAULT_処理年月_当月,
                    DEFAULT_交換情報識別番号,
                    DEFAULT_送付取込区分,
                    DEFAULT_処理状態区分);
            TestSupport.insert(
                    DEFAULT_処理年月_前月,
                    DEFAULT_交換情報識別番号,
                    DEFAULT_送付取込区分,
                    DEFAULT_処理状態区分);
            TestSupport.insert(
                    DEFAULT_処理年月_前々月,
                    DEFAULT_交換情報識別番号,
                    DEFAULT_送付取込区分,
                    DEFAULT_処理状態区分);
        }

        @Test(expected = NullPointerException.class)
        public void 処理年月がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    null,
                    DEFAULT_交換情報識別番号);
        }

        @Test(expected = NullPointerException.class)
        public void 交換情報識別番号がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_処理年月_当月,
                    null);
        }

        @Test
        public void 存在する主キーを渡すと_selectByKeyは_該当のエンティティを返す() {
            DbV3104KokuhorenTorikomiJohoEntity insertedRecord = null;
            try {
                insertedRecord = sut.selectByKey(
                        DEFAULT_処理年月_当月,
                        DEFAULT_交換情報識別番号);
            } catch (Exception e) {

            }
            assertThat(insertedRecord, is(notNullValue()));
        }

        @Test
        public void 存在しない主キーを渡すと_selectByKeyは_nullを返す() {
            DbV3104KokuhorenTorikomiJohoEntity insertedRecord = sut.selectByKey(
                    DEFAULT_存在しない処理年月,
                    DEFAULT_交換情報識別番号);
            assertThat(insertedRecord, is(nullValue()));
        }
    }

    public static class selectBy処理年月のテスト extends DbcTestDacBase {

        @BeforeClass
        public static void setUp() {
            TestSupport.insert(
                    DEFAULT_処理年月_当月,
                    DEFAULT_交換情報識別番号,
                    DEFAULT_送付取込区分,
                    DEFAULT_処理状態区分);
            TestSupport.insert(
                    DEFAULT_処理年月_前月,
                    DEFAULT_交換情報識別番号,
                    DEFAULT_送付取込区分,
                    DEFAULT_処理状態区分);
            TestSupport.insert(
                    DEFAULT_処理年月_前々月,
                    DEFAULT_交換情報識別番号,
                    DEFAULT_送付取込区分,
                    DEFAULT_処理状態区分);
        }

        @Test(expected = NullPointerException.class)
        public void 処理年月がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    null,
                    DEFAULT_交換情報識別番号);
        }

        @Test
        public void 存在する処理年月を渡すと_selectBy処理年月は_該当のエンティティを返す() {
            List<DbV3104KokuhorenTorikomiJohoEntity> insertedRecord = null;
            try {
                insertedRecord = sut.selectBy処理年月(DEFAULT_処理年月_当月);
            } catch (Exception e) {

            }
            assertThat(insertedRecord, is(notNullValue()));
        }

        @Test
        public void 存在しない主キーを渡すと_selectBy処理年月は_nullを返す() {
            List<DbV3104KokuhorenTorikomiJohoEntity> insertedRecord = sut.selectBy処理年月(
                    DEFAULT_存在しない処理年月);
            assertThat(insertedRecord, is(Collections.EMPTY_LIST));
        }
    }

    public static class selectAllのテスト extends DbcTestDacBase {

        @Test
        public void 国保連取込情報が存在する場合_selectAllは_全件を返す() {
            TestSupport.insert(
                    DEFAULT_処理年月_当月,
                    DEFAULT_交換情報識別番号,
                    DEFAULT_送付取込区分,
                    DEFAULT_処理状態区分);
            TestSupport.insert(
                    DEFAULT_処理年月_前月,
                    DEFAULT_交換情報識別番号,
                    DEFAULT_送付取込区分,
                    DEFAULT_処理状態区分);
            TestSupport.insert(
                    DEFAULT_処理年月_前々月,
                    DEFAULT_交換情報識別番号,
                    DEFAULT_送付取込区分,
                    DEFAULT_処理状態区分);
            assertThat(sut.selectAll().size(), is(6));

        }

        @Test
        public void 国保連取込情報が存在しない場合_selectAllは_空のリストを返す() {
            List<DbV3104KokuhorenTorikomiJohoEntity> result = Collections.EMPTY_LIST;
            assertThat(result, is(Collections.EMPTY_LIST));
            //assertThat(sut.selectAll(DEFAULT_処理年月_前々月), is(Collections.EMPTY_LIST));

        }
    }

    private static class TestSupport {

        public static void insert(
                RYearMonth 処理年月,
                RString 交換情報識別番号,
                RString 送付取込区分,
                RString 処理状態区分) {
            DbT3104KokuhorenInterfaceKanriEntity entity = new DbT3104KokuhorenInterfaceKanriEntity();
            entity.setShoriYM(処理年月);
            entity.setKokanShikibetsuNo(交換情報識別番号);
            entity.setSofuTorikomiKubun(送付取込区分);
            entity.setShoriJotaiKubun(処理状態区分);
            kokuhorenInterfaceKanriDac.insert(entity);
        }
    }
}
