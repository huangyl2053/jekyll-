/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.basic;

import java.util.Collections;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT3099TandokuJoseiShuruiEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT3099TandokuJoseiShuruiEntityGenerator;
import static jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT3099TandokuJoseiShuruiEntityGenerator.DEFAULT_処理日時;
import static jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT3099TandokuJoseiShuruiEntityGenerator.DEFAULT_助成サービス種類コード;
import static jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT3099TandokuJoseiShuruiEntityGenerator.DEFAULT_市町村単独助成種類;
import static jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT3099TandokuJoseiShuruiEntityGenerator.DEFAULT_適用開始年月;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestDacBase;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
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
 * {@link DbT3099TandokuJoseiShuruiDac}のテストです。
 *
 * @author LDNS 宋昕沢
 */
@RunWith(Enclosed.class)
public class DbT3099TandokuJoseiShuruiDacTest extends DbzTestDacBase {

    private static final RString キー_01 = new RString("01");
    private static final RString キー_02 = new RString("02");
    private static final RString キー_03 = new RString("03");
    private static DbT3099TandokuJoseiShuruiDac sut;

    @BeforeClass
    public static void setUpClass() {
        sut = InstanceProvider.create(DbT3099TandokuJoseiShuruiDac.class);
    }

    public static class selectByKeyのテスト extends DbzTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    new RString("01"),
                    DEFAULT_助成サービス種類コード,
                    DEFAULT_適用開始年月,
                    DEFAULT_処理日時);
            TestSupport.insert(
                    DEFAULT_市町村単独助成種類,
                    DEFAULT_助成サービス種類コード,
                    DEFAULT_適用開始年月,
                    DEFAULT_処理日時);
        }

        @Test(expected = NullPointerException.class)
        public void 市町村単独助成種類がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    null,
                    DEFAULT_助成サービス種類コード,
                    DEFAULT_適用開始年月,
                    DEFAULT_処理日時);
        }

        @Test(expected = NullPointerException.class)
        public void 助成サービス種類コードがnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_市町村単独助成種類,
                    null,
                    DEFAULT_適用開始年月,
                    DEFAULT_処理日時);
        }

        @Test(expected = NullPointerException.class)
        public void 適用開始年月がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_市町村単独助成種類,
                    DEFAULT_助成サービス種類コード,
                    null,
                    DEFAULT_処理日時);
        }

        @Test(expected = NullPointerException.class)
        public void 処理日時がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_市町村単独助成種類,
                    DEFAULT_助成サービス種類コード,
                    DEFAULT_適用開始年月,
                    null);
        }

        @Test
        public void 存在する主キーを渡すと_selectByKeyは_該当のエンティティを返す() {
            DbT3099TandokuJoseiShuruiEntity insertedRecord = sut.selectByKey(
                    DEFAULT_市町村単独助成種類,
                    DEFAULT_助成サービス種類コード,
                    DEFAULT_適用開始年月,
                    DEFAULT_処理日時);
            assertThat(insertedRecord, is(notNullValue()));
        }

        @Test
        public void 存在しない主キーを渡すと_selectByKeyは_nullを返す() {
            DbT3099TandokuJoseiShuruiEntity insertedRecord = sut.selectByKey(
                    new RString("05"),
                    DEFAULT_助成サービス種類コード,
                    DEFAULT_適用開始年月,
                    DEFAULT_処理日時);
            assertThat(insertedRecord, is(nullValue()));
        }
    }

    public static class selectAllのテスト extends DbzTestDacBase {

        @Test
        public void 市町村単独助成種類が存在する場合_selectAllは_全件を返す() {
            TestSupport.insert(
                    new RString("45"),
                    DEFAULT_助成サービス種類コード,
                    DEFAULT_適用開始年月,
                    DEFAULT_処理日時);
            TestSupport.insert(
                    DEFAULT_市町村単独助成種類,
                    DEFAULT_助成サービス種類コード,
                    DEFAULT_適用開始年月,
                    DEFAULT_処理日時);
            assertThat(sut.selectAll().size(), is(2));
        }

        @Test
        public void 市町村単独助成種類が存在しない場合_selectAllは_空のリストを返す() {
            assertThat(sut.selectAll(), is(Collections.EMPTY_LIST));
        }
    }

    public static class insertのテスト extends DbzTestDacBase {

        @Test
        public void 市町村単独助成種類エンティティを渡すと_insertは_市町村単独助成種類を追加する() {
            TestSupport.insert(
                    DEFAULT_市町村単独助成種類,
                    DEFAULT_助成サービス種類コード,
                    DEFAULT_適用開始年月,
                    DEFAULT_処理日時);

            assertThat(sut.selectByKey(
                    DEFAULT_市町村単独助成種類,
                    DEFAULT_助成サービス種類コード,
                    DEFAULT_適用開始年月,
                    DEFAULT_処理日時), is(notNullValue()));
        }
    }

    public static class updateのテスト extends DbzTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_市町村単独助成種類,
                    DEFAULT_助成サービス種類コード,
                    DEFAULT_適用開始年月,
                    DEFAULT_処理日時);
        }

        @Test
        public void 市町村単独助成種類エンティティを渡すと_updateは_市町村単独助成種類を更新する() {
            DbT3099TandokuJoseiShuruiEntity updateRecord = DbT3099TandokuJoseiShuruiEntityGenerator.createDbT3099TandokuJoseiShuruiEntity();
            //TODO  主キー以外の項目を変更してください
//      updateRecord.set変更したい項目(75);

            sut.update(updateRecord);

            DbT3099TandokuJoseiShuruiEntity updatedRecord = sut.selectByKey(
                    DEFAULT_市町村単独助成種類,
                    DEFAULT_助成サービス種類コード,
                    DEFAULT_適用開始年月,
                    DEFAULT_処理日時);

            //TODO  主キー以外の項目を変更してください
//    assertThat(updateRecord.get変更したい項目(), is(updatedRecord.get変更したい項目()));
        }
    }

    public static class deleteのテスト extends DbzTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_市町村単独助成種類,
                    DEFAULT_助成サービス種類コード,
                    DEFAULT_適用開始年月,
                    DEFAULT_処理日時);
        }

        @Test
        public void 市町村単独助成種類エンティティを渡すと_deleteは_市町村単独助成種類を削除する() {
            sut.delete(sut.selectByKey(
                    DEFAULT_市町村単独助成種類,
                    DEFAULT_助成サービス種類コード,
                    DEFAULT_適用開始年月,
                    DEFAULT_処理日時));
            assertThat(sut.selectByKey(
                    DEFAULT_市町村単独助成種類,
                    DEFAULT_助成サービス種類コード,
                    DEFAULT_適用開始年月,
                    DEFAULT_処理日時), is(nullValue()));
        }
    }

    private static class TestSupport {

        public static void insert(
                RString 市町村単独助成種類,
                ServiceShuruiCode 助成サービス種類コード,
                FlexibleYearMonth 適用開始年月,
                YMDHMS 処理日時) {
            DbT3099TandokuJoseiShuruiEntity entity = DbT3099TandokuJoseiShuruiEntityGenerator.createDbT3099TandokuJoseiShuruiEntity();
            entity.setTandokuJoseiShuruiCode(市町村単独助成種類);
            entity.setJoseiServiceShuruiCode(助成サービス種類コード);
            entity.setTekiyoKaishiYM(適用開始年月);
            entity.setShoriTimestamp(処理日時);
            sut.insert(entity);
        }
    }
}
