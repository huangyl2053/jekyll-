/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.db.basic;

import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT1004ShisetsuNyutaishoDac;
import java.util.Collections;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1004ShisetsuNyutaishoEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT1004ShisetsuNyutaishoEntityGenerator;
import static jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT1004ShisetsuNyutaishoEntityGenerator.*;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestDacBase;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.nullValue;
import org.junit.Test;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link DbT1004ShisetsuNyutaishoDac}のテストです。
 */
@Ignore
@RunWith(Enclosed.class)
public class DbT1004ShisetsuNyutaishoDacTest extends DbzTestDacBase {

    private static final RString キー_02 = new RString("02");
    private static final RString キー_03 = new RString("03");
    private static DbT1004ShisetsuNyutaishoDac sut;

    @BeforeClass
    public static void setUpClass() {
        sut = InstanceProvider.create(DbT1004ShisetsuNyutaishoDac.class);
    }

    public static class selectByKeyのテスト extends DbzTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_識別コード,
                    DEFAULT_履歴番号);
            TestSupport.insert(
                    DEFAULT_識別コード,
                    DEFAULT_履歴番号);
        }

        @Test(expected = NullPointerException.class)
        public void 識別コードがnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_識別コード,
                    DEFAULT_履歴番号);
        }

        @Test(expected = NullPointerException.class)
        public void 履歴番号がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_識別コード,
                    DEFAULT_履歴番号);
        }

        @Test
        public void 存在する主キーを渡すと_selectByKeyは_該当のエンティティを返す() {
            DbT1004ShisetsuNyutaishoEntity insertedRecord = sut.selectByKey(
                    DEFAULT_識別コード,
                    DEFAULT_履歴番号);
            assertThat(insertedRecord, is(notNullValue()));
        }

        @Test
        public void 存在しない主キーを渡すと_selectByKeyは_nullを返す() {
            DbT1004ShisetsuNyutaishoEntity insertedRecord = sut.selectByKey(
                    DEFAULT_識別コード,
                    DEFAULT_履歴番号);
            assertThat(insertedRecord, is(nullValue()));
        }
    }

    public static class selectAllのテスト extends DbzTestDacBase {

        @Test
        public void 介護保険施設入退所が存在する場合_selectAllは_全件を返す() {
            TestSupport.insert(
                    DEFAULT_識別コード,
                    DEFAULT_履歴番号);
            TestSupport.insert(
                    DEFAULT_識別コード,
                    DEFAULT_履歴番号);
            assertThat(sut.selectAll().size(), is(2));
        }

        @Test
        public void 介護保険施設入退所が存在しない場合_selectAllは_空のリストを返す() {
            assertThat(sut.selectAll(), is(Collections.EMPTY_LIST));
        }
    }

    public static class insertのテスト extends DbzTestDacBase {

        @Test
        public void 介護保険施設入退所エンティティを渡すと_insertは_介護保険施設入退所を追加する() {
            TestSupport.insert(
                    DEFAULT_識別コード,
                    DEFAULT_履歴番号);

            assertThat(sut.selectByKey(
                    DEFAULT_識別コード,
                    DEFAULT_履歴番号), is(notNullValue()));
        }
    }

    public static class updateのテスト extends DbzTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_識別コード,
                    DEFAULT_履歴番号);
        }

        @Test
        public void 介護保険施設入退所エンティティを渡すと_updateは_介護保険施設入退所を更新する() {
            DbT1004ShisetsuNyutaishoEntity updateRecord = sut.selectByKey(
                    DEFAULT_識別コード,
                    DEFAULT_履歴番号);
            updateRecord.setTaishoYMD(new FlexibleDate("20150810"));

            sut.save(updateRecord);

            DbT1004ShisetsuNyutaishoEntity updatedRecord = sut.selectByKey(
                    DEFAULT_識別コード,
                    DEFAULT_履歴番号);

            assertThat(updateRecord.getTaishoYMD(), is(updatedRecord.getTaishoYMD()));
        }
    }

    public static class deleteのテスト extends DbzTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_識別コード,
                    DEFAULT_履歴番号);
        }

        @Test
        public void 介護保険施設入退所エンティティを渡すと_deleteは_介護保険施設入退所を削除する() {
            DbT1004ShisetsuNyutaishoEntity deletedEntity = sut.selectByKey(
                    DEFAULT_識別コード,
                    DEFAULT_履歴番号);
            deletedEntity.setState(EntityDataState.Deleted);

            sut.save(deletedEntity);

            assertThat(sut.selectByKey(
                    DEFAULT_識別コード,
                    DEFAULT_履歴番号), is(nullValue()));
        }
    }

    private static class TestSupport {

        public static void insert(
                ShikibetsuCode 識別コード,
                int 履歴番号) {
            DbT1004ShisetsuNyutaishoEntity entity = DbT1004ShisetsuNyutaishoEntityGenerator.createDbT1004ShisetsuNyutaishoEntity();
            entity.setShikibetsuCode(識別コード);
            entity.setRirekiNo(履歴番号);
            sut.save(entity);
        }
    }
}
