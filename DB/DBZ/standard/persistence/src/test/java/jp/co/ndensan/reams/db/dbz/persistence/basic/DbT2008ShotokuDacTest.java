/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.basic;

import java.util.Collections;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT2008ShotokuEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT2008ShotokuEntityGenerator;
import static jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT2008ShotokuEntityGenerator.DEFAULT_履歴番号;
import static jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT2008ShotokuEntityGenerator.DEFAULT_所得年度;
import static jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT2008ShotokuEntityGenerator.DEFAULT_識別コード;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestDacBase;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
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
 * {@link DbT2008ShotokuDac}のテストです。
 *
 * @author LDNS 鄭雪双
 */
@RunWith(Enclosed.class)
public class DbT2008ShotokuDacTest extends DbzTestDacBase {

    private static final RString キー_01 = new RString("01");
    private static final RString キー_02 = new RString("02");
    private static final RString キー_03 = new RString("03");
    private static final FlexibleYear 所得年度2012 = new FlexibleYear("2012");
    private static final FlexibleYear 所得年度2013 = new FlexibleYear("2013");
    private static DbT2008ShotokuDac sut;

    @BeforeClass
    public static void setUpClass() {
        sut = InstanceProvider.create(DbT2008ShotokuDac.class);
    }

    public static class selectByKeyのテスト extends DbzTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_所得年度,
                    DEFAULT_識別コード,
                    DEFAULT_履歴番号);
            TestSupport.insert(
                    所得年度2012,
                    DEFAULT_識別コード,
                    DEFAULT_履歴番号);
        }

        @Test(expected = NullPointerException.class)
        public void 所得年度がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    null,
                    DEFAULT_識別コード,
                    DEFAULT_履歴番号);
        }

        @Test(expected = NullPointerException.class)
        public void 識別コードがnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_所得年度,
                    null,
                    DEFAULT_履歴番号);
        }

        @Test
        public void 存在する主キーを渡すと_selectByKeyは_該当のエンティティを返す() {
            DbT2008ShotokuEntity insertedRecord = sut.selectByKey(
                    DEFAULT_所得年度,
                    DEFAULT_識別コード,
                    DEFAULT_履歴番号);
            assertThat(insertedRecord, is(notNullValue()));
        }

        @Test
        public void 存在しない主キーを渡すと_selectByKeyは_nullを返す() {
            DbT2008ShotokuEntity insertedRecord = sut.selectByKey(
                    所得年度2013,
                    DEFAULT_識別コード,
                    DEFAULT_履歴番号);
            assertThat(insertedRecord, is(nullValue()));
        }
    }

    public static class selectAllのテスト extends DbzTestDacBase {

        @Test
        public void 介護所得が存在する場合_selectAllは_全件を返す() {
            TestSupport.insert(
                    DEFAULT_所得年度,
                    DEFAULT_識別コード,
                    DEFAULT_履歴番号);
            TestSupport.insert(
                    所得年度2012,
                    DEFAULT_識別コード,
                    DEFAULT_履歴番号);
            assertThat(sut.selectAll().size(), is(2));
        }

        @Test
        public void 介護所得が存在しない場合_selectAllは_空のリストを返す() {
            assertThat(sut.selectAll(), is(Collections.EMPTY_LIST));
        }
    }

    public static class insertのテスト extends DbzTestDacBase {

        @Test
        public void 介護所得エンティティを渡すと_insertは_介護所得を追加する() {
            TestSupport.insert(
                    DEFAULT_所得年度,
                    DEFAULT_識別コード,
                    DEFAULT_履歴番号);

            assertThat(sut.selectByKey(
                    DEFAULT_所得年度,
                    DEFAULT_識別コード,
                    DEFAULT_履歴番号), is(notNullValue()));
        }
    }

    public static class updateのテスト extends DbzTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_所得年度,
                    DEFAULT_識別コード,
                    DEFAULT_履歴番号);
        }

        @Test
        public void 介護所得エンティティを渡すと_updateは_介護所得を更新する() {
            DbT2008ShotokuEntity updateRecord = DbT2008ShotokuEntityGenerator.createDbT2008ShotokuEntity();
            // TODO 主キー以外の項目を変更してください
//            updateRecord.set変更したい項目(75);

            sut.update(updateRecord);

            DbT2008ShotokuEntity updatedRecord = sut.selectByKey(
                    DEFAULT_所得年度,
                    DEFAULT_識別コード,
                    DEFAULT_履歴番号);

//            assertThat(updateRecord.get変更したい項目(), is(updatedRecord.get変更したい項目()));
        }
    }

    public static class deleteのテスト extends DbzTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_所得年度,
                    DEFAULT_識別コード,
                    DEFAULT_履歴番号);
        }

        @Test
        public void 介護所得エンティティを渡すと_deleteは_介護所得を削除する() {
            sut.delete(sut.selectByKey(
                    DEFAULT_所得年度,
                    DEFAULT_識別コード,
                    DEFAULT_履歴番号));
            assertThat(sut.selectByKey(
                    DEFAULT_所得年度,
                    DEFAULT_識別コード,
                    DEFAULT_履歴番号), is(nullValue()));
        }
    }

    private static class TestSupport {

        public static void insert(
                FlexibleYear 所得年度,
                ShikibetsuCode 識別コード,
                int 履歴番号) {
            DbT2008ShotokuEntity entity = DbT2008ShotokuEntityGenerator.createDbT2008ShotokuEntity();
            entity.setShotokuNendo(所得年度);
            entity.setShikibetsuCode(識別コード);
            entity.setRirekiNo(履歴番号);
            sut.insert(entity);
        }
    }
}
