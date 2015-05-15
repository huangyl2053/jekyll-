/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.basic;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.entity.basic.DbT3104KokuhorenInterfaceKanriEntity;
import jp.co.ndensan.reams.db.dbz.testhelper.DbcTestDacBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RYearMonth;
import jp.co.ndensan.reams.uz.uza.lang._SQLObjectNotFoundException;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.nullValue;
import org.junit.Test;
import static org.junit.Assert.assertThat;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link KokuhorenInterfaceKanriDac}のテストです。
 *
 * @author n2810 久保里史
 */
@RunWith(Enclosed.class)
public class KokuhorenInterfaceKanriDacTest extends DbcTestDacBase {

    // private static final RYearMonth DEFAULT_処理年月 = new RYearMonth("201403");
    private static final RYearMonth DEFAULT_処理年月 = new RYearMonth("201411");
    private static final RYearMonth DEFAULT_存在しない処理年月 = new RYearMonth("201504");
    private static final RYearMonth DEFAULT_最大処理年月 = new RYearMonth("201505");
    //private static final RYearMonth DEFAULT_最大処理年月 = new RYearMonth("201411");
    private static final RString DEFAULT_交換情報識別番号 = new RString("112");
    private static final RString DEFAULT_送付取込区分 = new RString("1");
    private static final RString DEFAULT_処理状態区分 = new RString("1");

    private static KokuhorenInterfaceKanriDac sut;

    @BeforeClass
    public static void setUpClass() {
        sut = InstanceProvider.create(KokuhorenInterfaceKanriDac.class);
    }

    public static class getMaxShoriYMのテスト extends DbcTestDacBase {

        @BeforeClass
        public static void setUp() {
            TestSupport.insert(
                    DEFAULT_処理年月,
                    DEFAULT_交換情報識別番号,
                    DEFAULT_送付取込区分,
                    DEFAULT_処理状態区分);
        }

        @Test
        public void 最大処理年月を返す() throws SQLException, Exception {
            DbT3104KokuhorenInterfaceKanriEntity result;
            try {
                result = sut.getMaxShoriYM();
            } catch (NullPointerException e) {
                throw new NullPointerException();
            } catch (_SQLObjectNotFoundException e) {
                throw new _SQLObjectNotFoundException(e);
            } catch (Exception e) {
                throw new Exception();
            }
            assertThat(result.getShoriYM(), is(DEFAULT_最大処理年月));
        }
    }

    public static class selectByKeyのテスト extends DbcTestDacBase {

        @BeforeClass
        public static void setUp() throws SQLException, Exception {
            try {
                TestSupport.insert(
                        DEFAULT_処理年月,
                        DEFAULT_交換情報識別番号,
                        DEFAULT_送付取込区分,
                        DEFAULT_処理状態区分);
            } catch (Exception e) {
                throw new Exception();
            }
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
                    DEFAULT_処理年月,
                    null);
        }

        @Test
        public void 存在する主キーを渡すと_selectByKeyは_該当のエンティティを返す() {
            DbT3104KokuhorenInterfaceKanriEntity insertedRecord = sut.selectByKey(
                    DEFAULT_処理年月,
                    DEFAULT_交換情報識別番号);
            assertThat(insertedRecord, is(notNullValue()));
        }

        @Test
        public void 存在しない主キーを渡すと_selectByKeyは_nullを返す() {
            DbT3104KokuhorenInterfaceKanriEntity insertedRecord = sut.selectByKey(
                    DEFAULT_存在しない処理年月,
                    DEFAULT_交換情報識別番号);
            assertThat(insertedRecord, is(nullValue()));
        }

    }

    public static class selectAllのテスト extends DbcTestDacBase {

        @Test
        public void 国保連インターフェース管理が存在する場合_selectAllは_全件を返す() {
            TestSupport.insert(
                    DEFAULT_処理年月,
                    DEFAULT_交換情報識別番号,
                    DEFAULT_送付取込区分,
                    DEFAULT_処理状態区分);
            assertThat(sut.selectAll().size(), is(4));
        }

        @Test
        public void 国保連インターフェース管理が存在しない場合_selectAllは_空のリストを返す() {
            assertThat(sut.selectAll(), is(Collections.EMPTY_LIST));
        }
    }

    public static class insertのテスト extends DbcTestDacBase {

        @Test
        public void 国保連インターフェース管理エンティティを渡すと_insertは_国保連インターフェース管理を追加する() {
            TestSupport.insert(
                    DEFAULT_処理年月,
                    DEFAULT_交換情報識別番号,
                    DEFAULT_送付取込区分,
                    DEFAULT_処理状態区分);

            assertThat(sut.selectByKey(
                    DEFAULT_処理年月,
                    DEFAULT_交換情報識別番号), is(notNullValue()));
        }
    }

    public static class updateのテスト extends DbcTestDacBase {

        @BeforeClass
        public static void setUp() {
            TestSupport.insert(
                    DEFAULT_処理年月,
                    DEFAULT_交換情報識別番号,
                    DEFAULT_送付取込区分,
                    DEFAULT_処理状態区分);
        }

        @Test
        public void 国保連インターフェース管理エンティティを渡すと_updateは_国保連インターフェース管理を更新する() {

            DbT3104KokuhorenInterfaceKanriEntity updateRecord = sut.selectByKey(
                    DEFAULT_処理年月,
                    DEFAULT_交換情報識別番号);
            updateRecord.setShoriJotaiKubun(new RString("2"));

            sut.update(updateRecord);

            DbT3104KokuhorenInterfaceKanriEntity updatedRecord = sut.selectByKey(
                    DEFAULT_処理年月,
                    DEFAULT_交換情報識別番号);

            assertThat(updateRecord.getShoriJotaiKubun(), is(updatedRecord.getShoriJotaiKubun()));
        }
    }

    public static class deleteのテスト extends DbcTestDacBase {

        @BeforeClass
        public static void setUp() {
            TestSupport.insert(
                    DEFAULT_処理年月,
                    DEFAULT_交換情報識別番号,
                    DEFAULT_送付取込区分,
                    DEFAULT_処理状態区分);
        }

        @Test
        public void 国保連インターフェース管理エンティティを渡すと_deleteは_国保連インターフェース管理を削除する() {
            sut.delete(sut.selectByKey(
                    DEFAULT_処理年月,
                    DEFAULT_交換情報識別番号));
            assertThat(sut.selectByKey(
                    DEFAULT_処理年月,
                    DEFAULT_交換情報識別番号), is(nullValue()));
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
            sut.insert(entity);
        }
    }
}
