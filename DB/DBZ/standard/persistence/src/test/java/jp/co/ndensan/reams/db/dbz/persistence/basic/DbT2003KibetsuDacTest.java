/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.basic;

import java.util.Collections;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ChoteiNendo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.FukaNendo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.TsuchishoNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT2003KibetsuEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT2003KibetsuEntityGenerator;
import static jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT2003KibetsuEntityGenerator.DEFAULT_処理日時;
import static jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT2003KibetsuEntityGenerator.DEFAULT_徴収方法;
import static jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT2003KibetsuEntityGenerator.DEFAULT_期;
import static jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT2003KibetsuEntityGenerator.DEFAULT_調定年度;
import static jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT2003KibetsuEntityGenerator.DEFAULT_賦課年度;
import static jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT2003KibetsuEntityGenerator.DEFAULT_通知書番号;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestDacBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
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
 * {@link DbT2003KibetsuDac}のテストです。
 *
 * @author LDNS 鄭雪双
 */
@RunWith(Enclosed.class)
public class DbT2003KibetsuDacTest extends DbzTestDacBase {

    private static final RString キー_01 = new RString("01");
    private static final RString キー_02 = new RString("02");
    private static final RString キー_03 = new RString("03");
    private static final ChoteiNendo 調定年度2012 = new ChoteiNendo("2012");
    private static final ChoteiNendo 調定年度2013 = new ChoteiNendo("2013");
    private static DbT2003KibetsuDac sut;

    @BeforeClass
    public static void setUpClass() {
        sut = InstanceProvider.create(DbT2003KibetsuDac.class);
    }

    public static class selectByKeyのテスト extends DbzTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    new ChoteiNendo(DEFAULT_調定年度),
                    new FukaNendo(DEFAULT_賦課年度),
                    DEFAULT_通知書番号,
                    DEFAULT_処理日時,
                    DEFAULT_徴収方法,
                    DEFAULT_期);
            TestSupport.insert(
                    調定年度2012,
                    new FukaNendo(DEFAULT_賦課年度),
                    DEFAULT_通知書番号,
                    DEFAULT_処理日時,
                    DEFAULT_徴収方法,
                    DEFAULT_期);
        }

        @Test(expected = NullPointerException.class)
        public void 調定年度がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    null,
                    new FukaNendo(DEFAULT_賦課年度),
                    DEFAULT_通知書番号,
                    DEFAULT_処理日時,
                    DEFAULT_徴収方法,
                    DEFAULT_期);
        }

        @Test(expected = NullPointerException.class)
        public void 賦課年度がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    new ChoteiNendo(DEFAULT_調定年度),
                    null,
                    DEFAULT_通知書番号,
                    DEFAULT_処理日時,
                    DEFAULT_徴収方法,
                    DEFAULT_期);
        }

        @Test(expected = NullPointerException.class)
        public void 通知書番号がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    new ChoteiNendo(DEFAULT_調定年度),
                    new FukaNendo(DEFAULT_賦課年度),
                    null,
                    DEFAULT_処理日時,
                    DEFAULT_徴収方法,
                    DEFAULT_期);
        }

        @Test(expected = NullPointerException.class)
        public void 処理日時がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    new ChoteiNendo(DEFAULT_調定年度),
                    new FukaNendo(DEFAULT_賦課年度),
                    DEFAULT_通知書番号,
                    null,
                    DEFAULT_徴収方法,
                    DEFAULT_期);
        }

        @Test(expected = NullPointerException.class)
        public void 徴収方法がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    new ChoteiNendo(DEFAULT_調定年度),
                    new FukaNendo(DEFAULT_賦課年度),
                    DEFAULT_通知書番号,
                    DEFAULT_処理日時,
                    null,
                    DEFAULT_期);
        }

        @Test
        public void 存在する主キーを渡すと_selectByKeyは_該当のエンティティを返す() {
            DbT2003KibetsuEntity insertedRecord = sut.selectByKey(
                    new ChoteiNendo(DEFAULT_調定年度),
                    new FukaNendo(DEFAULT_賦課年度),
                    DEFAULT_通知書番号,
                    DEFAULT_処理日時,
                    DEFAULT_徴収方法,
                    DEFAULT_期);
            assertThat(insertedRecord, is(notNullValue()));
        }

        @Test
        public void 存在しない主キーを渡すと_selectByKeyは_nullを返す() {
            DbT2003KibetsuEntity insertedRecord = sut.selectByKey(
                    調定年度2013,
                    new FukaNendo(DEFAULT_賦課年度),
                    DEFAULT_通知書番号,
                    DEFAULT_処理日時,
                    DEFAULT_徴収方法,
                    DEFAULT_期);
            assertThat(insertedRecord, is(nullValue()));
        }
    }

    public static class selectAllのテスト extends DbzTestDacBase {

        @Test
        public void 介護期別が存在する場合_selectAllは_全件を返す() {
            TestSupport.insert(
                    new ChoteiNendo(DEFAULT_調定年度),
                    new FukaNendo(DEFAULT_賦課年度),
                    DEFAULT_通知書番号,
                    DEFAULT_処理日時,
                    DEFAULT_徴収方法,
                    DEFAULT_期);
            TestSupport.insert(
                    調定年度2012,
                    new FukaNendo(DEFAULT_賦課年度),
                    DEFAULT_通知書番号,
                    DEFAULT_処理日時,
                    DEFAULT_徴収方法,
                    DEFAULT_期);
            assertThat(sut.selectAll().size(), is(2));
        }

        @Test
        public void 介護期別が存在しない場合_selectAllは_空のリストを返す() {
            assertThat(sut.selectAll(), is(Collections.EMPTY_LIST));
        }
    }

    public static class insertのテスト extends DbzTestDacBase {

        @Test
        public void 介護期別エンティティを渡すと_insertは_介護期別を追加する() {
            TestSupport.insert(
                    new ChoteiNendo(DEFAULT_調定年度),
                    new FukaNendo(DEFAULT_賦課年度),
                    DEFAULT_通知書番号,
                    DEFAULT_処理日時,
                    DEFAULT_徴収方法,
                    DEFAULT_期);

            assertThat(sut.selectByKey(
                    new ChoteiNendo(DEFAULT_調定年度),
                    new FukaNendo(DEFAULT_賦課年度),
                    DEFAULT_通知書番号,
                    DEFAULT_処理日時,
                    DEFAULT_徴収方法,
                    DEFAULT_期), is(notNullValue()));
        }
    }

    public static class updateのテスト extends DbzTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    new ChoteiNendo(DEFAULT_調定年度),
                    new FukaNendo(DEFAULT_賦課年度),
                    DEFAULT_通知書番号,
                    DEFAULT_処理日時,
                    DEFAULT_徴収方法,
                    DEFAULT_期);
        }

        @Test
        public void 介護期別エンティティを渡すと_updateは_介護期別を更新する() {
            DbT2003KibetsuEntity updateRecord = DbT2003KibetsuEntityGenerator.createDbT2003KibetsuEntity();
            // TODO 主キー以外の項目を変更してください
//            updateRecord.set変更したい項目(75);

            sut.update(updateRecord);

            DbT2003KibetsuEntity updatedRecord = sut.selectByKey(
                    new ChoteiNendo(DEFAULT_調定年度),
                    new FukaNendo(DEFAULT_賦課年度),
                    DEFAULT_通知書番号,
                    DEFAULT_処理日時,
                    DEFAULT_徴収方法,
                    DEFAULT_期);

//            assertThat(updateRecord.get変更したい項目(), is(updatedRecord.get変更したい項目()));
        }
    }

    public static class deleteのテスト extends DbzTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    new ChoteiNendo(DEFAULT_調定年度),
                    new FukaNendo(DEFAULT_賦課年度),
                    DEFAULT_通知書番号,
                    DEFAULT_処理日時,
                    DEFAULT_徴収方法,
                    DEFAULT_期);
        }

        @Test
        public void 介護期別エンティティを渡すと_deleteは_介護期別を削除する() {
            sut.delete(sut.selectByKey(
                    new ChoteiNendo(DEFAULT_調定年度),
                    new FukaNendo(DEFAULT_賦課年度),
                    DEFAULT_通知書番号,
                    DEFAULT_処理日時,
                    DEFAULT_徴収方法,
                    DEFAULT_期));
            assertThat(sut.selectByKey(
                    new ChoteiNendo(DEFAULT_調定年度),
                    new FukaNendo(DEFAULT_賦課年度),
                    DEFAULT_通知書番号,
                    DEFAULT_処理日時,
                    DEFAULT_徴収方法,
                    DEFAULT_期), is(nullValue()));
        }
    }

    private static class TestSupport {

        public static void insert(
                ChoteiNendo 調定年度,
                FukaNendo 賦課年度,
                TsuchishoNo 通知書番号,
                RDateTime 処理日時,
                RString 徴収方法,
                int 期) {
            DbT2003KibetsuEntity entity = DbT2003KibetsuEntityGenerator.createDbT2003KibetsuEntity();
            entity.setChoteiNendo(調定年度.value());
            entity.setFukaNendo(賦課年度.value());
            entity.setTsuchishoNo(通知書番号);
            entity.setShoriTimestamp(処理日時);
            entity.setChoshuHoho(徴収方法);
            entity.setKi(期);
            sut.insert(entity);
        }
    }
}
