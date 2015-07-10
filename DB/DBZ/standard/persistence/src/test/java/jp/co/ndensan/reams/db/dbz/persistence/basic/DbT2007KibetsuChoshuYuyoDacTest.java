/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.basic;

import java.util.Collections;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.TsuchishoNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT2007KibetsuChoshuYuyoEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT2007KibetsuChoshuYuyoEntityGenerator;
import static jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT2007KibetsuChoshuYuyoEntityGenerator.DEFAULT_処理日時;
import static jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT2007KibetsuChoshuYuyoEntityGenerator.DEFAULT_徴収方法;
import static jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT2007KibetsuChoshuYuyoEntityGenerator.DEFAULT_期;
import static jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT2007KibetsuChoshuYuyoEntityGenerator.DEFAULT_調定年度;
import static jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT2007KibetsuChoshuYuyoEntityGenerator.DEFAULT_賦課年度;
import static jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT2007KibetsuChoshuYuyoEntityGenerator.DEFAULT_通知書番号;
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
 * {@link DbT2007KibetsuChoshuYuyoDac}のテストです。
 *
 * @author LDNS 鄭雪双
 */
@RunWith(Enclosed.class)
public class DbT2007KibetsuChoshuYuyoDacTest extends DbzTestDacBase {

    private static final RString キー_01 = new RString("01");
    private static final RString キー_02 = new RString("02");
    private static final RString キー_03 = new RString("03");
    private static final FlexibleYear 調定年度2012 = new FlexibleYear("2012");
    private static final FlexibleYear 調定年度2013 = new FlexibleYear("2013");
    private static DbT2007KibetsuChoshuYuyoDac sut;

    @BeforeClass
    public static void setUpClass() {
        sut = InstanceProvider.create(DbT2007KibetsuChoshuYuyoDac.class);
    }

    public static class selectByKeyのテスト extends DbzTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_調定年度,
                    DEFAULT_賦課年度,
                    DEFAULT_通知書番号,
                    DEFAULT_処理日時,
                    DEFAULT_徴収方法,
                    DEFAULT_期);
            TestSupport.insert(
                    調定年度2012,
                    DEFAULT_賦課年度,
                    DEFAULT_通知書番号,
                    DEFAULT_処理日時,
                    DEFAULT_徴収方法,
                    DEFAULT_期);
        }

        @Test(expected = NullPointerException.class)
        public void 調定年度がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    null,
                    DEFAULT_賦課年度,
                    DEFAULT_通知書番号,
                    DEFAULT_処理日時,
                    DEFAULT_徴収方法,
                    DEFAULT_期);
        }

        @Test(expected = NullPointerException.class)
        public void 賦課年度がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_調定年度,
                    null,
                    DEFAULT_通知書番号,
                    DEFAULT_処理日時,
                    DEFAULT_徴収方法,
                    DEFAULT_期);
        }

        @Test(expected = NullPointerException.class)
        public void 通知書番号がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_調定年度,
                    DEFAULT_賦課年度,
                    null,
                    DEFAULT_処理日時,
                    DEFAULT_徴収方法,
                    DEFAULT_期);
        }

        @Test(expected = NullPointerException.class)
        public void 処理日時がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_調定年度,
                    DEFAULT_賦課年度,
                    DEFAULT_通知書番号,
                    null,
                    DEFAULT_徴収方法,
                    DEFAULT_期);
        }

        @Test(expected = NullPointerException.class)
        public void 徴収方法がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_調定年度,
                    DEFAULT_賦課年度,
                    DEFAULT_通知書番号,
                    DEFAULT_処理日時,
                    null,
                    DEFAULT_期);
        }

        @Test
        public void 存在する主キーを渡すと_selectByKeyは_該当のエンティティを返す() {
            DbT2007KibetsuChoshuYuyoEntity insertedRecord = sut.selectByKey(
                    DEFAULT_調定年度,
                    DEFAULT_賦課年度,
                    DEFAULT_通知書番号,
                    DEFAULT_処理日時,
                    DEFAULT_徴収方法,
                    DEFAULT_期);
            assertThat(insertedRecord, is(notNullValue()));
        }

        @Test
        public void 存在しない主キーを渡すと_selectByKeyは_nullを返す() {
            DbT2007KibetsuChoshuYuyoEntity insertedRecord = sut.selectByKey(
                    調定年度2013,
                    DEFAULT_賦課年度,
                    DEFAULT_通知書番号,
                    DEFAULT_処理日時,
                    DEFAULT_徴収方法,
                    DEFAULT_期);
            assertThat(insertedRecord, is(nullValue()));
        }
    }

    public static class selectAllのテスト extends DbzTestDacBase {

        @Test
        public void 介護期別徴収猶予が存在する場合_selectAllは_全件を返す() {
            TestSupport.insert(
                    DEFAULT_調定年度,
                    DEFAULT_賦課年度,
                    DEFAULT_通知書番号,
                    DEFAULT_処理日時,
                    DEFAULT_徴収方法,
                    DEFAULT_期);
            TestSupport.insert(
                    調定年度2012,
                    DEFAULT_賦課年度,
                    DEFAULT_通知書番号,
                    DEFAULT_処理日時,
                    DEFAULT_徴収方法,
                    DEFAULT_期);
            assertThat(sut.selectAll().size(), is(2));
        }

        @Test
        public void 介護期別徴収猶予が存在しない場合_selectAllは_空のリストを返す() {
            assertThat(sut.selectAll(), is(Collections.EMPTY_LIST));
        }
    }

    public static class insertのテスト extends DbzTestDacBase {

        @Test
        public void 介護期別徴収猶予エンティティを渡すと_insertは_介護期別徴収猶予を追加する() {
            TestSupport.insert(
                    DEFAULT_調定年度,
                    DEFAULT_賦課年度,
                    DEFAULT_通知書番号,
                    DEFAULT_処理日時,
                    DEFAULT_徴収方法,
                    DEFAULT_期);

            assertThat(sut.selectByKey(
                    DEFAULT_調定年度,
                    DEFAULT_賦課年度,
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
                    DEFAULT_調定年度,
                    DEFAULT_賦課年度,
                    DEFAULT_通知書番号,
                    DEFAULT_処理日時,
                    DEFAULT_徴収方法,
                    DEFAULT_期);
        }

        @Test
        public void 介護期別徴収猶予エンティティを渡すと_updateは_介護期別徴収猶予を更新する() {
            DbT2007KibetsuChoshuYuyoEntity updateRecord = DbT2007KibetsuChoshuYuyoEntityGenerator.createDbT2007KibetsuChoshuYuyoEntity();
            // TODO 主キー以外の項目を変更してください
//            updateRecord.set変更したい項目(75);

            sut.update(updateRecord);

            DbT2007KibetsuChoshuYuyoEntity updatedRecord = sut.selectByKey(
                    DEFAULT_調定年度,
                    DEFAULT_賦課年度,
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
                    DEFAULT_調定年度,
                    DEFAULT_賦課年度,
                    DEFAULT_通知書番号,
                    DEFAULT_処理日時,
                    DEFAULT_徴収方法,
                    DEFAULT_期);
        }

        @Test
        public void 介護期別徴収猶予エンティティを渡すと_deleteは_介護期別徴収猶予を削除する() {
            sut.delete(sut.selectByKey(
                    DEFAULT_調定年度,
                    DEFAULT_賦課年度,
                    DEFAULT_通知書番号,
                    DEFAULT_処理日時,
                    DEFAULT_徴収方法,
                    DEFAULT_期));
            assertThat(sut.selectByKey(
                    DEFAULT_調定年度,
                    DEFAULT_賦課年度,
                    DEFAULT_通知書番号,
                    DEFAULT_処理日時,
                    DEFAULT_徴収方法,
                    DEFAULT_期), is(nullValue()));
        }
    }

    private static class TestSupport {

        public static void insert(
                FlexibleYear 調定年度,
                FlexibleYear 賦課年度,
                TsuchishoNo 通知書番号,
                RDateTime 処理日時,
                RString 徴収方法,
                int 期) {
            DbT2007KibetsuChoshuYuyoEntity entity = DbT2007KibetsuChoshuYuyoEntityGenerator.createDbT2007KibetsuChoshuYuyoEntity();
            entity.setChoteiNendo(調定年度);
            entity.setFukaNendo(賦課年度);
            entity.setTsuchishoNo(通知書番号);
            entity.setShoriTimestamp(処理日時);
            entity.setChoshuHoho(徴収方法);
            entity.setKi(期);
            sut.insert(entity);
        }
    }
}
