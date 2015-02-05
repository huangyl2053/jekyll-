/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.basic;

import java.util.Collections;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT1004ShisetsuNyutaishoEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT1004ShisetsuNyutaishoEntityGenerator;
import static jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT1004ShisetsuNyutaishoEntityGenerator.DEFAULT_処理日時;
import static jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT1004ShisetsuNyutaishoEntityGenerator.DEFAULT_市町村コード;
import static jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT1004ShisetsuNyutaishoEntityGenerator.DEFAULT_識別コード;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestDacBase;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
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
 * {@link DbT1004ShisetsuNyutaishoDac}のテストです。
 *
 * @author LDNS 鄭雪双
 */
@RunWith(Enclosed.class)
public class DbT1004ShisetsuNyutaishoDacTest extends DbzTestDacBase {

    private static final RString キー_01 = new RString("01");
    private static final RString キー_02 = new RString("02");
    private static final RString キー_03 = new RString("03");
    private static final LasdecCode 市町村コード202012 = new LasdecCode("202012");
    private static final LasdecCode 市町村コード202013 = new LasdecCode("202013");
    private static final YMDHMS shoriTimestamp = new YMDHMS("20991231010101");
    private static DbT1004ShisetsuNyutaishoDac sut;

    @BeforeClass
    public static void setUpClass() {
        sut = InstanceProvider.create(DbT1004ShisetsuNyutaishoDac.class);
    }

    public static class selectByKeyのテスト extends DbzTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_市町村コード,
                    DEFAULT_識別コード,
                    shoriTimestamp);
            TestSupport.insert(
                    市町村コード202012,
                    DEFAULT_識別コード,
                    shoriTimestamp);
        }

        @Test(expected = NullPointerException.class)
        public void 市町村コードがnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    null,
                    DEFAULT_識別コード,
                    shoriTimestamp);
        }

        @Test(expected = NullPointerException.class)
        public void 識別コードがnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_市町村コード,
                    null,
                    shoriTimestamp);
        }

        @Test(expected = NullPointerException.class)
        public void 処理日時がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    市町村コード202012,
                    DEFAULT_識別コード,
                    null);
        }

        @Test
        public void 存在する主キーを渡すと_selectByKeyは_該当のエンティティを返す() {
            DbT1004ShisetsuNyutaishoEntity insertedRecord = sut.selectByKey(
                    DEFAULT_市町村コード,
                    DEFAULT_識別コード,
                    shoriTimestamp);
            assertThat(insertedRecord, is(notNullValue()));
        }

        @Test
        public void 存在しない主キーを渡すと_selectByKeyは_nullを返す() {
            DbT1004ShisetsuNyutaishoEntity insertedRecord = sut.selectByKey(
                    市町村コード202013,
                    DEFAULT_識別コード,
                    shoriTimestamp
            );
            assertThat(insertedRecord, is(nullValue()));
        }
    }

    public static class selectAllのテスト extends DbzTestDacBase {

        @Test
        public void 介護保険施設入退所が存在する場合_selectAllは_全件を返す() {
            TestSupport.insert(
                    DEFAULT_市町村コード,
                    DEFAULT_識別コード,
                    shoriTimestamp);
            TestSupport.insert(
                    市町村コード202012,
                    DEFAULT_識別コード,
                    shoriTimestamp);
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
                    DEFAULT_市町村コード,
                    DEFAULT_識別コード,
                    shoriTimestamp);

            assertThat(sut.selectByKey(
                    DEFAULT_市町村コード,
                    DEFAULT_識別コード,
                    shoriTimestamp
            ), is(notNullValue())
            );
        }
    }

    public static class updateのテスト extends DbzTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_市町村コード,
                    DEFAULT_識別コード,
                    shoriTimestamp);
        }

        @Test
        public void 介護保険施設入退所エンティティを渡すと_updateは_介護保険施設入退所を更新する() {
            DbT1004ShisetsuNyutaishoEntity updateRecord = DbT1004ShisetsuNyutaishoEntityGenerator.createDbT1004ShisetsuNyutaishoEntity();
            FlexibleDate updateDate = new FlexibleDate("20221103");
            updateRecord.setTaishoYMD(updateDate);
            sut.update(updateRecord);

            DbT1004ShisetsuNyutaishoEntity updatedRecord = sut.selectByKey(
                    DEFAULT_市町村コード,
                    DEFAULT_識別コード,
                    shoriTimestamp
            );

            assertThat(updateRecord.getTaishoYMD(), is(updateDate));
        }
    }

    public static class deleteのテスト extends DbzTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_市町村コード,
                    DEFAULT_識別コード,
                    shoriTimestamp);
        }

        @Test
        public void 介護保険施設入退所エンティティを渡すと_deleteは_介護保険施設入退所を削除する() {
            sut.delete(sut.selectByKey(
                    DEFAULT_市町村コード,
                    DEFAULT_識別コード,
                    shoriTimestamp
            ));
            assertThat(sut.selectByKey(
                    DEFAULT_市町村コード,
                    DEFAULT_識別コード,
                    shoriTimestamp),
                    is(nullValue()));
        }
    }

    private static class TestSupport {

        public static void insert(
                LasdecCode 市町村コード,
                ShikibetsuCode 識別コード,
                YMDHMS 処理日時) {
            DbT1004ShisetsuNyutaishoEntity entity = DbT1004ShisetsuNyutaishoEntityGenerator.createDbT1004ShisetsuNyutaishoEntity();
            entity.setShichosonCode(市町村コード);
            entity.setShikibetsuCode(識別コード);
            entity.setShoriTimestamp(処理日時);
            sut.insert(entity);
        }
    }
}
