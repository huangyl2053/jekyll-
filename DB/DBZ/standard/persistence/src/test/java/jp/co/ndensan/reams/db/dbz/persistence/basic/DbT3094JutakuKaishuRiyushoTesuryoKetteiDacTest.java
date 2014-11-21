/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.basic;

import java.util.Collections;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT3094JutakuKaishuRiyushoTesuryoKetteiEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT3094JutakuKaishuRiyushoTesuryoKetteiEntityGenerator;
import static jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT3094JutakuKaishuRiyushoTesuryoKetteiEntityGenerator.DEFAULT_介護住宅改修理由書作成事業者番号;
import static jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT3094JutakuKaishuRiyushoTesuryoKetteiEntityGenerator.DEFAULT_処理日時;
import static jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT3094JutakuKaishuRiyushoTesuryoKetteiEntityGenerator.DEFAULT_決定年月日;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestDacBase;
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
 * {@link DbT3094JutakuKaishuRiyushoTesuryoKetteiDac}のテストです。
 *
 * @author LDNS 宋昕沢
 */
@RunWith(Enclosed.class)
public class DbT3094JutakuKaishuRiyushoTesuryoKetteiDacTest extends DbzTestDacBase {

    private static final RString キー_01 = new RString("01");
    private static final RString キー_02 = new RString("02");
    private static final RString キー_03 = new RString("03");
    private static DbT3094JutakuKaishuRiyushoTesuryoKetteiDac sut;

    @BeforeClass
    public static void setUpClass() {
        sut = InstanceProvider.create(DbT3094JutakuKaishuRiyushoTesuryoKetteiDac.class);
    }

    public static class selectByKeyのテスト extends DbzTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    new JigyoshaNo(キー_01),
                    DEFAULT_決定年月日,
                    DEFAULT_処理日時);
            TestSupport.insert(
                    DEFAULT_介護住宅改修理由書作成事業者番号,
                    DEFAULT_決定年月日,
                    DEFAULT_処理日時);
        }

        @Test(expected = NullPointerException.class)
        public void 介護住宅改修理由書作成事業者番号がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    null,
                    DEFAULT_決定年月日,
                    DEFAULT_処理日時);
        }

        @Test(expected = NullPointerException.class)
        public void 決定年月日がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_介護住宅改修理由書作成事業者番号,
                    null,
                    DEFAULT_処理日時);
        }

        @Test(expected = NullPointerException.class)
        public void 処理日時がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_介護住宅改修理由書作成事業者番号,
                    DEFAULT_決定年月日,
                    null);
        }

        @Test
        public void 存在する主キーを渡すと_selectByKeyは_該当のエンティティを返す() {
            DbT3094JutakuKaishuRiyushoTesuryoKetteiEntity insertedRecord = sut.selectByKey(
                    DEFAULT_介護住宅改修理由書作成事業者番号,
                    DEFAULT_決定年月日,
                    DEFAULT_処理日時);
            assertThat(insertedRecord, is(notNullValue()));
        }

        @Test
        public void 存在しない主キーを渡すと_selectByKeyは_nullを返す() {
            DbT3094JutakuKaishuRiyushoTesuryoKetteiEntity insertedRecord = sut.selectByKey(
                    new JigyoshaNo(キー_03),
                    DEFAULT_決定年月日,
                    DEFAULT_処理日時);
            assertThat(insertedRecord, is(nullValue()));
        }
    }

    public static class selectAllのテスト extends DbzTestDacBase {

        @Test
        public void 住宅改修理由書作成手数料請求決定が存在する場合_selectAllは_全件を返す() {
            TestSupport.insert(
                    new JigyoshaNo(キー_01),
                    DEFAULT_決定年月日,
                    DEFAULT_処理日時);
            TestSupport.insert(
                    DEFAULT_介護住宅改修理由書作成事業者番号,
                    DEFAULT_決定年月日,
                    DEFAULT_処理日時);
            assertThat(sut.selectAll().size(), is(2));
        }

        @Test
        public void 住宅改修理由書作成手数料請求決定が存在しない場合_selectAllは_空のリストを返す() {
            assertThat(sut.selectAll(), is(Collections.EMPTY_LIST));
        }
    }

    public static class insertのテスト extends DbzTestDacBase {

        @Test
        public void 住宅改修理由書作成手数料請求決定エンティティを渡すと_insertは_住宅改修理由書作成手数料請求決定を追加する() {
            TestSupport.insert(
                    DEFAULT_介護住宅改修理由書作成事業者番号,
                    DEFAULT_決定年月日,
                    DEFAULT_処理日時);

            assertThat(sut.selectByKey(
                    DEFAULT_介護住宅改修理由書作成事業者番号,
                    DEFAULT_決定年月日,
                    DEFAULT_処理日時), is(notNullValue()));
        }
    }

    public static class updateのテスト extends DbzTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_介護住宅改修理由書作成事業者番号,
                    DEFAULT_決定年月日,
                    DEFAULT_処理日時);
        }

        @Test
        public void 住宅改修理由書作成手数料請求決定エンティティを渡すと_updateは_住宅改修理由書作成手数料請求決定を更新する() {
            DbT3094JutakuKaishuRiyushoTesuryoKetteiEntity updateRecord = DbT3094JutakuKaishuRiyushoTesuryoKetteiEntityGenerator.createDbT3094JutakuKaishuRiyushoTesuryoKetteiEntity();
            //TODO  主キー以外の項目を変更してください
//       updateRecord.set変更したい項目(75);

            sut.update(updateRecord);

            DbT3094JutakuKaishuRiyushoTesuryoKetteiEntity updatedRecord = sut.selectByKey(
                    DEFAULT_介護住宅改修理由書作成事業者番号,
                    DEFAULT_決定年月日,
                    DEFAULT_処理日時);

            //TODO  主キー以外の項目を変更してください
// assertThat(updateRecord.get変更したい項目(), is(updatedRecord.get変更したい項目()));
        }
    }

    public static class deleteのテスト extends DbzTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_介護住宅改修理由書作成事業者番号,
                    DEFAULT_決定年月日,
                    DEFAULT_処理日時);
        }

        @Test
        public void 住宅改修理由書作成手数料請求決定エンティティを渡すと_deleteは_住宅改修理由書作成手数料請求決定を削除する() {
            sut.delete(sut.selectByKey(
                    DEFAULT_介護住宅改修理由書作成事業者番号,
                    DEFAULT_決定年月日,
                    DEFAULT_処理日時));
            assertThat(sut.selectByKey(
                    DEFAULT_介護住宅改修理由書作成事業者番号,
                    DEFAULT_決定年月日,
                    DEFAULT_処理日時), is(nullValue()));
        }
    }

    private static class TestSupport {

        public static void insert(
                JigyoshaNo 介護住宅改修理由書作成事業者番号,
                FlexibleDate 決定年月日,
                YMDHMS 処理日時) {
            DbT3094JutakuKaishuRiyushoTesuryoKetteiEntity entity = DbT3094JutakuKaishuRiyushoTesuryoKetteiEntityGenerator.createDbT3094JutakuKaishuRiyushoTesuryoKetteiEntity();
            entity.setRiyushoSakuseiJigyoshaNo(介護住宅改修理由書作成事業者番号);
            entity.setKetteiYMD(決定年月日);
            entity.setShoriTimestamp(処理日時);
            sut.insert(entity);
        }
    }
}
