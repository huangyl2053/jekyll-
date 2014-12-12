/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.basic;

import java.util.Collections;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT3058KogakuShikyuShinsaKetteiEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT3058KogakuShikyuShinsaKetteiEntityGenerator;
import static jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT3058KogakuShikyuShinsaKetteiEntityGenerator.DEFAULT_サービス提供年月;
import static jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT3058KogakuShikyuShinsaKetteiEntityGenerator.DEFAULT_決定者受取年月;
import static jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT3058KogakuShikyuShinsaKetteiEntityGenerator.DEFAULT_被保険者番号;
import static jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT3058KogakuShikyuShinsaKetteiEntityGenerator.DEFAULT_証記載保険者番号;
import static jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT3058KogakuShikyuShinsaKetteiEntityGenerator.DEFAULT_通知書番号;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestDacBase;
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
 * {@link DbT3058KogakuShikyuShinsaKetteiDac}のテストです。
 *
 * @author LDNS 周杏月
 */
@RunWith(Enclosed.class)
public class DbT3058KogakuShikyuShinsaKetteiDacTest extends DbzTestDacBase {

    private static final RString キー_01 = new RString("01");
    private static final RString キー_02 = new RString("02");
    private static final RString キー_03 = new RString("03");
    private static DbT3058KogakuShikyuShinsaKetteiDac sut;
    private static final HihokenshaNo 被保険者番号_1 = new HihokenshaNo(new RString("3"));
    private static final HihokenshaNo 被保険者番号_2 = new HihokenshaNo(new RString("4"));

    @BeforeClass
    public static void setUpClass() {
        sut = InstanceProvider.create(DbT3058KogakuShikyuShinsaKetteiDac.class);
    }

    public static class selectByKeyのテスト extends DbzTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_決定者受取年月,
                    DEFAULT_証記載保険者番号,
                    被保険者番号_1,
                    DEFAULT_サービス提供年月,
                    DEFAULT_通知書番号);
            TestSupport.insert(
                    DEFAULT_決定者受取年月,
                    DEFAULT_証記載保険者番号,
                    DEFAULT_被保険者番号,
                    DEFAULT_サービス提供年月,
                    DEFAULT_通知書番号);
        }

        @Test(expected = NullPointerException.class)
        public void 決定者受取年月がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    null,
                    DEFAULT_証記載保険者番号,
                    DEFAULT_被保険者番号,
                    DEFAULT_サービス提供年月,
                    DEFAULT_通知書番号);
        }

        @Test(expected = NullPointerException.class)
        public void 証記載保険者番号がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_決定者受取年月,
                    null,
                    DEFAULT_被保険者番号,
                    DEFAULT_サービス提供年月,
                    DEFAULT_通知書番号);
        }

        @Test(expected = NullPointerException.class)
        public void 被保険者番号がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_決定者受取年月,
                    DEFAULT_証記載保険者番号,
                    null,
                    DEFAULT_サービス提供年月,
                    DEFAULT_通知書番号);
        }

        @Test(expected = NullPointerException.class)
        public void サービス提供年月がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_決定者受取年月,
                    DEFAULT_証記載保険者番号,
                    DEFAULT_被保険者番号,
                    null,
                    DEFAULT_通知書番号);
        }

        @Test(expected = NullPointerException.class)
        public void 通知書番号がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_決定者受取年月,
                    DEFAULT_証記載保険者番号,
                    DEFAULT_被保険者番号,
                    DEFAULT_サービス提供年月,
                    null);
        }

        @Test
        public void 存在する主キーを渡すと_selectByKeyは_該当のエンティティを返す() {
            DbT3058KogakuShikyuShinsaKetteiEntity insertedRecord = sut.selectByKey(
                    DEFAULT_決定者受取年月,
                    DEFAULT_証記載保険者番号,
                    DEFAULT_被保険者番号,
                    DEFAULT_サービス提供年月,
                    DEFAULT_通知書番号);
            assertThat(insertedRecord, is(notNullValue()));
        }

        @Test
        public void 存在しない主キーを渡すと_selectByKeyは_nullを返す() {
            DbT3058KogakuShikyuShinsaKetteiEntity insertedRecord = sut.selectByKey(
                    DEFAULT_決定者受取年月,
                    DEFAULT_証記載保険者番号,
                    被保険者番号_2,
                    DEFAULT_サービス提供年月,
                    DEFAULT_通知書番号);
            assertThat(insertedRecord, is(nullValue()));
        }
    }

    public static class selectAllのテスト extends DbzTestDacBase {

        @Test
        public void 高額介護サービス費支給審査決定が存在する場合_selectAllは_全件を返す() {
            TestSupport.insert(
                    DEFAULT_決定者受取年月,
                    DEFAULT_証記載保険者番号,
                    DEFAULT_被保険者番号,
                    DEFAULT_サービス提供年月,
                    DEFAULT_通知書番号);
            TestSupport.insert(
                    DEFAULT_決定者受取年月,
                    DEFAULT_証記載保険者番号,
                    被保険者番号_1,
                    DEFAULT_サービス提供年月,
                    DEFAULT_通知書番号);
            assertThat(sut.selectAll().size(), is(2));
        }

        @Test
        public void 高額介護サービス費支給審査決定が存在しない場合_selectAllは_空のリストを返す() {
            assertThat(sut.selectAll(), is(Collections.EMPTY_LIST));
        }
    }

    public static class insertのテスト extends DbzTestDacBase {

        @Test
        public void 高額介護サービス費支給審査決定エンティティを渡すと_insertは_高額介護サービス費支給審査決定を追加する() {
            TestSupport.insert(
                    DEFAULT_決定者受取年月,
                    DEFAULT_証記載保険者番号,
                    DEFAULT_被保険者番号,
                    DEFAULT_サービス提供年月,
                    DEFAULT_通知書番号);

            assertThat(sut.selectByKey(
                    DEFAULT_決定者受取年月,
                    DEFAULT_証記載保険者番号,
                    DEFAULT_被保険者番号,
                    DEFAULT_サービス提供年月,
                    DEFAULT_通知書番号), is(notNullValue()));
        }
    }

    public static class updateのテスト extends DbzTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_決定者受取年月,
                    DEFAULT_証記載保険者番号,
                    DEFAULT_被保険者番号,
                    DEFAULT_サービス提供年月,
                    DEFAULT_通知書番号);
        }

        @Test
        public void 高額介護サービス費支給審査決定エンティティを渡すと_updateは_高額介護サービス費支給審査決定を更新する() {
            DbT3058KogakuShikyuShinsaKetteiEntity updateRecord = DbT3058KogakuShikyuShinsaKetteiEntityGenerator.createDbT3058KogakuShikyuShinsaKetteiEntity();
            // TODO 主キー以外の項目を変更してください
            //updateRecord.set変更したい項目(75);

            sut.update(updateRecord);

            DbT3058KogakuShikyuShinsaKetteiEntity updatedRecord = sut.selectByKey(
                    DEFAULT_決定者受取年月,
                    DEFAULT_証記載保険者番号,
                    DEFAULT_被保険者番号,
                    DEFAULT_サービス提供年月,
                    DEFAULT_通知書番号);

            //assertThat(updateRecord.get変更したい項目(), is(updatedRecord.get変更したい項目()));
        }
    }

    public static class deleteのテスト extends DbzTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_決定者受取年月,
                    DEFAULT_証記載保険者番号,
                    DEFAULT_被保険者番号,
                    DEFAULT_サービス提供年月,
                    DEFAULT_通知書番号);
        }

        @Test
        public void 高額介護サービス費支給審査決定エンティティを渡すと_deleteは_高額介護サービス費支給審査決定を削除する() {
            sut.delete(sut.selectByKey(
                    DEFAULT_決定者受取年月,
                    DEFAULT_証記載保険者番号,
                    DEFAULT_被保険者番号,
                    DEFAULT_サービス提供年月,
                    DEFAULT_通知書番号));
            assertThat(sut.selectByKey(
                    DEFAULT_決定者受取年月,
                    DEFAULT_証記載保険者番号,
                    DEFAULT_被保険者番号,
                    DEFAULT_サービス提供年月,
                    DEFAULT_通知書番号), is(nullValue()));
        }
    }

    private static class TestSupport {

        public static void insert(
                FlexibleYearMonth 決定者受取年月,
                HokenshaNo 証記載保険者番号,
                HihokenshaNo 被保険者番号,
                FlexibleYearMonth サービス提供年月,
                RString 通知書番号) {
            DbT3058KogakuShikyuShinsaKetteiEntity entity = DbT3058KogakuShikyuShinsaKetteiEntityGenerator.createDbT3058KogakuShikyuShinsaKetteiEntity();
            entity.setKetteishaUketoriYM(決定者受取年月);
            entity.setShoKisaiHokenshaNo(証記載保険者番号);
            entity.setHihokenshaNo(被保険者番号);
            entity.setServiceTeikyoYM(サービス提供年月);
            entity.setTsuchishoNo(通知書番号);
            sut.insert(entity);
        }
    }
}
