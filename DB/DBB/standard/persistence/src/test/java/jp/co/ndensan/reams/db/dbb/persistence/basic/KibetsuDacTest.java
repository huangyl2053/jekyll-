/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.persistence.basic;

import java.util.Collections;
import jp.co.ndensan.reams.db.dbb.entity.basic.DbT2003KibetsuEntity;
import jp.co.ndensan.reams.db.dbb.entity.basic.helper.DbT2003KibetsuEntityGenerator;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.TsuchishoNo;
import jp.co.ndensan.reams.db.dbz.testhelper.DbbTestDacBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import org.junit.Test;
import static jp.co.ndensan.reams.db.dbb.entity.basic.helper.DbT2003KibetsuEntityGenerator.*;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.*;

/**
 * {@link KibetsuDac}のテストクラスです。
 *
 * @author N8156 宮本 康
 */
@RunWith(Enclosed.class)
public class KibetsuDacTest extends DbbTestDacBase {

    private static KibetsuDac sut;

    @BeforeClass
    public static void setUpClass() {
        sut = InstanceProvider.create(KibetsuDac.class);
    }

    public static class selectByKeyのテスト extends DbbTestDacBase {

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
                    DEFAULT_調定年度,
                    DEFAULT_賦課年度,
                    DEFAULT_通知書番号,
                    DEFAULT_処理日時,
                    DEFAULT_徴収方法,
                    DEFAULT_期 + 1);
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
            DbT2003KibetsuEntity insertedRecord = sut.selectByKey(
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
            DbT2003KibetsuEntity insertedRecord = sut.selectByKey(
                    DEFAULT_調定年度,
                    DEFAULT_賦課年度,
                    DEFAULT_通知書番号,
                    DEFAULT_処理日時,
                    DEFAULT_徴収方法,
                    99);
            assertThat(insertedRecord, is(nullValue()));
        }
    }

    public static class selectAllのテスト extends DbbTestDacBase {

        @Test
        public void 介護期別が存在する場合_selectAllは_全件を返す() {
            TestSupport.insert(
                    DEFAULT_調定年度,
                    DEFAULT_賦課年度,
                    DEFAULT_通知書番号,
                    DEFAULT_処理日時,
                    DEFAULT_徴収方法,
                    DEFAULT_期);
            TestSupport.insert(
                    DEFAULT_調定年度,
                    DEFAULT_賦課年度,
                    DEFAULT_通知書番号,
                    DEFAULT_処理日時,
                    DEFAULT_徴収方法,
                    DEFAULT_期 + 1);
            assertThat(sut.selectAll().size(), is(2));
        }

        @Test
        public void 介護期別が存在しない場合_selectAllは_空のリストを返す() {
            assertThat(sut.selectAll(), is(Collections.EMPTY_LIST));
        }
    }

    public static class insertのテスト extends DbbTestDacBase {

        @Test
        public void 介護期別エンティティを渡すと_insertは_介護期別を追加する() {
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

    public static class updateのテスト extends DbbTestDacBase {

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
        public void 介護期別エンティティを渡すと_updateは_介護期別を更新する() {
            DbT2003KibetsuEntity updateRecord = DbT2003KibetsuEntityGenerator.createDbT2003KibetsuEntity();
            updateRecord.setChoteiId(99L);

            sut.update(updateRecord);

            DbT2003KibetsuEntity updatedRecord = sut.selectByKey(
                    DEFAULT_調定年度,
                    DEFAULT_賦課年度,
                    DEFAULT_通知書番号,
                    DEFAULT_処理日時,
                    DEFAULT_徴収方法,
                    DEFAULT_期);

            assertThat(updateRecord.getChoteiId(), is(updatedRecord.getChoteiId()));
        }
    }

    public static class deleteのテスト extends DbbTestDacBase {

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
        public void 介護期別エンティティを渡すと_deleteは_介護期別を削除する() {
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
                    DEFAULT_期),
                    is(nullValue()));
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
            DbT2003KibetsuEntity entity = DbT2003KibetsuEntityGenerator.createDbT2003KibetsuEntity();
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
