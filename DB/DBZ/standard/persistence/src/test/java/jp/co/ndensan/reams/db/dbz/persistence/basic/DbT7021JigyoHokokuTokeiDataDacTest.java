/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.basic;

import java.util.Collections;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7021JigyoHokokuTokeiDataEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT7021JigyoHokokuTokeiDataEntityGenerator;
import static jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT7021JigyoHokokuTokeiDataEntityGenerator.DEFAULT_処理日時;
import static jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT7021JigyoHokokuTokeiDataEntityGenerator.DEFAULT_報告年;
import static jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT7021JigyoHokokuTokeiDataEntityGenerator.DEFAULT_報告月;
import static jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT7021JigyoHokokuTokeiDataEntityGenerator.DEFAULT_市町村コード;
import static jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT7021JigyoHokokuTokeiDataEntityGenerator.DEFAULT_横番号;
import static jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT7021JigyoHokokuTokeiDataEntityGenerator.DEFAULT_統計対象区分;
import static jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT7021JigyoHokokuTokeiDataEntityGenerator.DEFAULT_縦番号;
import static jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT7021JigyoHokokuTokeiDataEntityGenerator.DEFAULT_表番号;
import static jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT7021JigyoHokokuTokeiDataEntityGenerator.DEFAULT_集計単位;
import static jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT7021JigyoHokokuTokeiDataEntityGenerator.DEFAULT_集計対象年;
import static jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT7021JigyoHokokuTokeiDataEntityGenerator.DEFAULT_集計対象月;
import static jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT7021JigyoHokokuTokeiDataEntityGenerator.DEFAULT_集計番号;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestDacBase;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
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
 * {@link DbT7021JigyoHokokuTokeiDataDac}のテストです。
 *
 * @author LDNS 宋昕沢
 */
@RunWith(Enclosed.class)
public class DbT7021JigyoHokokuTokeiDataDacTest extends DbzTestDacBase {

    private static final RString キー_01 = new RString("01");
    private static final RString キー_02 = new RString("02");
    private static final RString キー_03 = new RString("03");
    private static DbT7021JigyoHokokuTokeiDataDac sut;

    @BeforeClass
    public static void setUpClass() {
        sut = InstanceProvider.create(DbT7021JigyoHokokuTokeiDataDac.class);
    }

    public static class selectByKeyのテスト extends DbzTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    new FlexibleYear("2012"),
                    DEFAULT_報告月,
                    DEFAULT_集計対象年,
                    DEFAULT_集計対象月,
                    DEFAULT_統計対象区分,
                    DEFAULT_市町村コード,
                    DEFAULT_表番号,
                    DEFAULT_集計番号,
                    DEFAULT_集計単位,
                    DEFAULT_縦番号,
                    DEFAULT_横番号,
                    DEFAULT_処理日時);
            TestSupport.insert(
                    DEFAULT_報告年,
                    DEFAULT_報告月,
                    DEFAULT_集計対象年,
                    DEFAULT_集計対象月,
                    DEFAULT_統計対象区分,
                    DEFAULT_市町村コード,
                    DEFAULT_表番号,
                    DEFAULT_集計番号,
                    DEFAULT_集計単位,
                    DEFAULT_縦番号,
                    DEFAULT_横番号,
                    DEFAULT_処理日時);
        }

        @Test(expected = NullPointerException.class)
        public void 報告年がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    null,
                    DEFAULT_報告月,
                    DEFAULT_集計対象年,
                    DEFAULT_集計対象月,
                    DEFAULT_統計対象区分,
                    DEFAULT_市町村コード,
                    DEFAULT_表番号,
                    DEFAULT_集計番号,
                    DEFAULT_集計単位,
                    DEFAULT_縦番号,
                    DEFAULT_横番号,
                    DEFAULT_処理日時);
        }

        @Test(expected = NullPointerException.class)
        public void 報告月がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_報告年,
                    null,
                    DEFAULT_集計対象年,
                    DEFAULT_集計対象月,
                    DEFAULT_統計対象区分,
                    DEFAULT_市町村コード,
                    DEFAULT_表番号,
                    DEFAULT_集計番号,
                    DEFAULT_集計単位,
                    DEFAULT_縦番号,
                    DEFAULT_横番号,
                    DEFAULT_処理日時);
        }

        @Test(expected = NullPointerException.class)
        public void 集計対象年がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_報告年,
                    DEFAULT_報告月,
                    null,
                    DEFAULT_集計対象月,
                    DEFAULT_統計対象区分,
                    DEFAULT_市町村コード,
                    DEFAULT_表番号,
                    DEFAULT_集計番号,
                    DEFAULT_集計単位,
                    DEFAULT_縦番号,
                    DEFAULT_横番号,
                    DEFAULT_処理日時);
        }

        @Test(expected = NullPointerException.class)
        public void 集計対象月がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_報告年,
                    DEFAULT_報告月,
                    DEFAULT_集計対象年,
                    null,
                    DEFAULT_統計対象区分,
                    DEFAULT_市町村コード,
                    DEFAULT_表番号,
                    DEFAULT_集計番号,
                    DEFAULT_集計単位,
                    DEFAULT_縦番号,
                    DEFAULT_横番号,
                    DEFAULT_処理日時);
        }

        @Test(expected = NullPointerException.class)
        public void 統計対象区分がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_報告年,
                    DEFAULT_報告月,
                    DEFAULT_集計対象年,
                    DEFAULT_集計対象月,
                    null,
                    DEFAULT_市町村コード,
                    DEFAULT_表番号,
                    DEFAULT_集計番号,
                    DEFAULT_集計単位,
                    DEFAULT_縦番号,
                    DEFAULT_横番号,
                    DEFAULT_処理日時);
        }

        @Test(expected = NullPointerException.class)
        public void 市町村コードがnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_報告年,
                    DEFAULT_報告月,
                    DEFAULT_集計対象年,
                    DEFAULT_集計対象月,
                    DEFAULT_統計対象区分,
                    null,
                    DEFAULT_表番号,
                    DEFAULT_集計番号,
                    DEFAULT_集計単位,
                    DEFAULT_縦番号,
                    DEFAULT_横番号,
                    DEFAULT_処理日時);
        }

        @Test(expected = NullPointerException.class)
        public void 表番号がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_報告年,
                    DEFAULT_報告月,
                    DEFAULT_集計対象年,
                    DEFAULT_集計対象月,
                    DEFAULT_統計対象区分,
                    DEFAULT_市町村コード,
                    null,
                    DEFAULT_集計番号,
                    DEFAULT_集計単位,
                    DEFAULT_縦番号,
                    DEFAULT_横番号,
                    DEFAULT_処理日時);
        }

        @Test(expected = NullPointerException.class)
        public void 集計番号がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_報告年,
                    DEFAULT_報告月,
                    DEFAULT_集計対象年,
                    DEFAULT_集計対象月,
                    DEFAULT_統計対象区分,
                    DEFAULT_市町村コード,
                    DEFAULT_表番号,
                    null,
                    DEFAULT_集計単位,
                    DEFAULT_縦番号,
                    DEFAULT_横番号,
                    DEFAULT_処理日時);
        }

        @Test(expected = NullPointerException.class)
        public void 集計単位がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_報告年,
                    DEFAULT_報告月,
                    DEFAULT_集計対象年,
                    DEFAULT_集計対象月,
                    DEFAULT_統計対象区分,
                    DEFAULT_市町村コード,
                    DEFAULT_表番号,
                    DEFAULT_集計番号,
                    null,
                    DEFAULT_縦番号,
                    DEFAULT_横番号,
                    DEFAULT_処理日時);
        }

        @Test(expected = NullPointerException.class)
        public void 縦番号がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_報告年,
                    DEFAULT_報告月,
                    DEFAULT_集計対象年,
                    DEFAULT_集計対象月,
                    DEFAULT_統計対象区分,
                    DEFAULT_市町村コード,
                    DEFAULT_表番号,
                    DEFAULT_集計番号,
                    DEFAULT_集計単位,
                    null,
                    DEFAULT_横番号,
                    DEFAULT_処理日時);
        }

        @Test(expected = NullPointerException.class)
        public void 横番号がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_報告年,
                    DEFAULT_報告月,
                    DEFAULT_集計対象年,
                    DEFAULT_集計対象月,
                    DEFAULT_統計対象区分,
                    DEFAULT_市町村コード,
                    DEFAULT_表番号,
                    DEFAULT_集計番号,
                    DEFAULT_集計単位,
                    DEFAULT_縦番号,
                    null,
                    DEFAULT_処理日時);
        }

        @Test(expected = NullPointerException.class)
        public void 処理日時がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_報告年,
                    DEFAULT_報告月,
                    DEFAULT_集計対象年,
                    DEFAULT_集計対象月,
                    DEFAULT_統計対象区分,
                    DEFAULT_市町村コード,
                    DEFAULT_表番号,
                    DEFAULT_集計番号,
                    DEFAULT_集計単位,
                    DEFAULT_縦番号,
                    DEFAULT_横番号,
                    null);
        }

        @Test
        public void 存在する主キーを渡すと_selectByKeyは_該当のエンティティを返す() {
            DbT7021JigyoHokokuTokeiDataEntity insertedRecord = sut.selectByKey(
                    DEFAULT_報告年,
                    DEFAULT_報告月,
                    DEFAULT_集計対象年,
                    DEFAULT_集計対象月,
                    DEFAULT_統計対象区分,
                    DEFAULT_市町村コード,
                    DEFAULT_表番号,
                    DEFAULT_集計番号,
                    DEFAULT_集計単位,
                    DEFAULT_縦番号,
                    DEFAULT_横番号,
                    DEFAULT_処理日時);
            assertThat(insertedRecord, is(notNullValue()));
        }

        @Test
        public void 存在しない主キーを渡すと_selectByKeyは_nullを返す() {
            DbT7021JigyoHokokuTokeiDataEntity insertedRecord = sut.selectByKey(
                    new FlexibleYear("2000"),
                    DEFAULT_報告月,
                    DEFAULT_集計対象年,
                    DEFAULT_集計対象月,
                    DEFAULT_統計対象区分,
                    DEFAULT_市町村コード,
                    DEFAULT_表番号,
                    DEFAULT_集計番号,
                    DEFAULT_集計単位,
                    DEFAULT_縦番号,
                    DEFAULT_横番号,
                    DEFAULT_処理日時);
            assertThat(insertedRecord, is(nullValue()));
        }
    }

    public static class selectAllのテスト extends DbzTestDacBase {

        @Test
        public void 事業報告統計データが存在する場合_selectAllは_全件を返す() {
            TestSupport.insert(
                    new FlexibleYear("2017"),
                    DEFAULT_報告月,
                    DEFAULT_集計対象年,
                    DEFAULT_集計対象月,
                    DEFAULT_統計対象区分,
                    DEFAULT_市町村コード,
                    DEFAULT_表番号,
                    DEFAULT_集計番号,
                    DEFAULT_集計単位,
                    DEFAULT_縦番号,
                    DEFAULT_横番号,
                    DEFAULT_処理日時);
            TestSupport.insert(
                    DEFAULT_報告年,
                    DEFAULT_報告月,
                    DEFAULT_集計対象年,
                    DEFAULT_集計対象月,
                    DEFAULT_統計対象区分,
                    DEFAULT_市町村コード,
                    DEFAULT_表番号,
                    DEFAULT_集計番号,
                    DEFAULT_集計単位,
                    DEFAULT_縦番号,
                    DEFAULT_横番号,
                    DEFAULT_処理日時);
            assertThat(sut.selectAll().size(), is(2));
        }

        @Test
        public void 事業報告統計データが存在しない場合_selectAllは_空のリストを返す() {
            assertThat(sut.selectAll(), is(Collections.EMPTY_LIST));
        }
    }

    public static class insertのテスト extends DbzTestDacBase {

        @Test
        public void 事業報告統計データエンティティを渡すと_insertは_事業報告統計データを追加する() {
            TestSupport.insert(
                    DEFAULT_報告年,
                    DEFAULT_報告月,
                    DEFAULT_集計対象年,
                    DEFAULT_集計対象月,
                    DEFAULT_統計対象区分,
                    DEFAULT_市町村コード,
                    DEFAULT_表番号,
                    DEFAULT_集計番号,
                    DEFAULT_集計単位,
                    DEFAULT_縦番号,
                    DEFAULT_横番号,
                    DEFAULT_処理日時);

            assertThat(sut.selectByKey(
                    DEFAULT_報告年,
                    DEFAULT_報告月,
                    DEFAULT_集計対象年,
                    DEFAULT_集計対象月,
                    DEFAULT_統計対象区分,
                    DEFAULT_市町村コード,
                    DEFAULT_表番号,
                    DEFAULT_集計番号,
                    DEFAULT_集計単位,
                    DEFAULT_縦番号,
                    DEFAULT_横番号,
                    DEFAULT_処理日時), is(notNullValue()));
        }
    }

    public static class updateのテスト extends DbzTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_報告年,
                    DEFAULT_報告月,
                    DEFAULT_集計対象年,
                    DEFAULT_集計対象月,
                    DEFAULT_統計対象区分,
                    DEFAULT_市町村コード,
                    DEFAULT_表番号,
                    DEFAULT_集計番号,
                    DEFAULT_集計単位,
                    DEFAULT_縦番号,
                    DEFAULT_横番号,
                    DEFAULT_処理日時);
        }

        @Test
        public void 事業報告統計データエンティティを渡すと_updateは_事業報告統計データを更新する() {
            DbT7021JigyoHokokuTokeiDataEntity updateRecord = DbT7021JigyoHokokuTokeiDataEntityGenerator.createDbT7021JigyoHokokuTokeiDataEntity();
            //TODO  主キー以外の項目を変更してください
//  updateRecord.set変更したい項目(75);

            sut.update(updateRecord);

            DbT7021JigyoHokokuTokeiDataEntity updatedRecord = sut.selectByKey(
                    DEFAULT_報告年,
                    DEFAULT_報告月,
                    DEFAULT_集計対象年,
                    DEFAULT_集計対象月,
                    DEFAULT_統計対象区分,
                    DEFAULT_市町村コード,
                    DEFAULT_表番号,
                    DEFAULT_集計番号,
                    DEFAULT_集計単位,
                    DEFAULT_縦番号,
                    DEFAULT_横番号,
                    DEFAULT_処理日時);

            //TODO  主キー以外の項目を変更してください
//    assertThat(updateRecord.get変更したい項目(), is(updatedRecord.get変更したい項目()));
        }
    }

    public static class deleteのテスト extends DbzTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_報告年,
                    DEFAULT_報告月,
                    DEFAULT_集計対象年,
                    DEFAULT_集計対象月,
                    DEFAULT_統計対象区分,
                    DEFAULT_市町村コード,
                    DEFAULT_表番号,
                    DEFAULT_集計番号,
                    DEFAULT_集計単位,
                    DEFAULT_縦番号,
                    DEFAULT_横番号,
                    DEFAULT_処理日時);
        }

        @Test
        public void 事業報告統計データエンティティを渡すと_deleteは_事業報告統計データを削除する() {
            sut.delete(sut.selectByKey(
                    DEFAULT_報告年,
                    DEFAULT_報告月,
                    DEFAULT_集計対象年,
                    DEFAULT_集計対象月,
                    DEFAULT_統計対象区分,
                    DEFAULT_市町村コード,
                    DEFAULT_表番号,
                    DEFAULT_集計番号,
                    DEFAULT_集計単位,
                    DEFAULT_縦番号,
                    DEFAULT_横番号,
                    DEFAULT_処理日時));
            assertThat(sut.selectByKey(
                    DEFAULT_報告年,
                    DEFAULT_報告月,
                    DEFAULT_集計対象年,
                    DEFAULT_集計対象月,
                    DEFAULT_統計対象区分,
                    DEFAULT_市町村コード,
                    DEFAULT_表番号,
                    DEFAULT_集計番号,
                    DEFAULT_集計単位,
                    DEFAULT_縦番号,
                    DEFAULT_横番号,
                    DEFAULT_処理日時), is(nullValue()));
        }
    }

    private static class TestSupport {

        public static void insert(
                FlexibleYear 報告年,
                RString 報告月,
                FlexibleYear 集計対象年,
                RString 集計対象月,
                RString 統計対象区分,
                LasdecCode 市町村コード,
                Code 表番号,
                Code 集計番号,
                Code 集計単位,
                Decimal 縦番号,
                Decimal 横番号,
                RDateTime 処理日時) {
            DbT7021JigyoHokokuTokeiDataEntity entity = DbT7021JigyoHokokuTokeiDataEntityGenerator.createDbT7021JigyoHokokuTokeiDataEntity();
            entity.setHokokuYSeireki(報告年);
            entity.setHokokuM(報告月);
            entity.setShukeiTaishoYSeireki(集計対象年);
            entity.setShukeiTaishoM(集計対象月);
            entity.setToukeiTaishoKubun(統計対象区分);
            entity.setShichosonCode(市町村コード);
            entity.setHyoNo(表番号);
            entity.setShukeiNo(集計番号);
            entity.setShukeiTani(集計単位);
            entity.setTateNo(縦番号);
            entity.setYokoNo(横番号);
            entity.setShoriTimestamp(処理日時);
            sut.insert(entity);
        }
    }
}
