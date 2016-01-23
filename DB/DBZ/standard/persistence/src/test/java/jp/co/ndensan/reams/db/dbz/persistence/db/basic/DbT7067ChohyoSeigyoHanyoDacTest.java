/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.db.basic;

import java.util.Collections;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT7067ChohyoSeigyoHanyoEntityGenerator;
import static jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT7067ChohyoSeigyoHanyoEntityGenerator.DEFAULT_サブ業務コード;
import static jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT7067ChohyoSeigyoHanyoEntityGenerator.DEFAULT_帳票分類ID;
import static jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT7067ChohyoSeigyoHanyoEntityGenerator.DEFAULT_管理年度;
import static jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT7067ChohyoSeigyoHanyoEntityGenerator.DEFAULT_項目名;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7067ChohyoSeigyoHanyoEntity;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestDacBase;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link DbT7067ChohyoSeigyoHanyoDac}のテストです。
 */
@Ignore
@RunWith(Enclosed.class)
public class DbT7067ChohyoSeigyoHanyoDacTest extends DbzTestDacBase {

    private static final RString キー_01 = DEFAULT_項目名;
    private static final RString キー_02 = new RString("02");
    private static final RString キー_03 = new RString("03");
    private static DbT7067ChohyoSeigyoHanyoDac sut;

    @BeforeClass
    public static void setUpClass() {
        sut = InstanceProvider.create(DbT7067ChohyoSeigyoHanyoDac.class);
    }

    public static class selectByKeyのテスト extends DbzTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_サブ業務コード,
                    DEFAULT_帳票分類ID,
                    DEFAULT_管理年度,
                    DEFAULT_項目名);
            TestSupport.insert(
                    DEFAULT_サブ業務コード,
                    DEFAULT_帳票分類ID,
                    DEFAULT_管理年度,
                    DEFAULT_項目名);
        }

        @Test(expected = NullPointerException.class)
        public void サブ業務コードがnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_サブ業務コード,
                    DEFAULT_帳票分類ID,
                    DEFAULT_管理年度,
                    DEFAULT_項目名);
        }

        @Test(expected = NullPointerException.class)
        public void 帳票分類IDがnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_サブ業務コード,
                    DEFAULT_帳票分類ID,
                    DEFAULT_管理年度,
                    DEFAULT_項目名);
        }

        @Test(expected = NullPointerException.class)
        public void 項目名がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_サブ業務コード,
                    DEFAULT_帳票分類ID,
                    DEFAULT_管理年度,
                    DEFAULT_項目名);
        }

        @Test
        public void 存在する主キーを渡すと_selectByKeyは_該当のエンティティを返す() {
            DbT7067ChohyoSeigyoHanyoEntity insertedRecord = sut.selectByKey(
                    DEFAULT_サブ業務コード,
                    DEFAULT_帳票分類ID,
                    DEFAULT_管理年度,
                    DEFAULT_項目名);
            assertThat(insertedRecord, is(notNullValue()));
        }

        @Test
        public void 存在しない主キーを渡すと_selectByKeyは_nullを返す() {
            DbT7067ChohyoSeigyoHanyoEntity insertedRecord = sut.selectByKey(
                    DEFAULT_サブ業務コード,
                    DEFAULT_帳票分類ID,
                    DEFAULT_管理年度,
                    DEFAULT_項目名);
            assertThat(insertedRecord, is(nullValue()));
        }
    }

    public static class selectAllのテスト extends DbzTestDacBase {

        @Test
        public void 帳票制御汎用が存在する場合_selectAllは_全件を返す() {
            TestSupport.insert(
                    DEFAULT_サブ業務コード,
                    DEFAULT_帳票分類ID,
                    DEFAULT_管理年度,
                    DEFAULT_項目名);
            TestSupport.insert(
                    DEFAULT_サブ業務コード,
                    DEFAULT_帳票分類ID,
                    DEFAULT_管理年度,
                    DEFAULT_項目名);
            assertThat(sut.selectAll().size(), is(2));
        }

        @Test
        public void 帳票制御汎用が存在しない場合_selectAllは_空のリストを返す() {
            assertThat(sut.selectAll(), is(Collections.EMPTY_LIST));
        }
    }

    public static class insertのテスト extends DbzTestDacBase {

        @Test
        public void 帳票制御汎用エンティティを渡すと_insertは_帳票制御汎用を追加する() {
            TestSupport.insert(
                    DEFAULT_サブ業務コード,
                    DEFAULT_帳票分類ID,
                    DEFAULT_管理年度,
                    DEFAULT_項目名);

            assertThat(sut.selectByKey(
                    DEFAULT_サブ業務コード,
                    DEFAULT_帳票分類ID,
                    DEFAULT_管理年度,
                    DEFAULT_項目名), is(notNullValue()));
        }
    }

    public static class updateのテスト extends DbzTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_サブ業務コード,
                    DEFAULT_帳票分類ID,
                    DEFAULT_管理年度,
                    DEFAULT_項目名);
        }

        @Test
        public void 帳票制御汎用エンティティを渡すと_updateは_帳票制御汎用を更新する() {
            DbT7067ChohyoSeigyoHanyoEntity updateRecord = sut.selectByKey(
                    DEFAULT_サブ業務コード,
                    DEFAULT_帳票分類ID,
                    DEFAULT_管理年度,
                    DEFAULT_項目名);
            updateRecord.setKomokuValue(new RString("new komokuName"));

            sut.save(updateRecord);

            DbT7067ChohyoSeigyoHanyoEntity updatedRecord = sut.selectByKey(
                    DEFAULT_サブ業務コード,
                    DEFAULT_帳票分類ID,
                    DEFAULT_管理年度,
                    DEFAULT_項目名);

            assertThat(updateRecord.getKomokuValue(), is(updatedRecord.getKomokuValue()));
        }
    }

    public static class deleteのテスト extends DbzTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_サブ業務コード,
                    DEFAULT_帳票分類ID,
                    DEFAULT_管理年度,
                    DEFAULT_項目名);
        }

        @Test
        public void 帳票制御汎用エンティティを渡すと_deleteは_帳票制御汎用を削除する() {
            DbT7067ChohyoSeigyoHanyoEntity deletedEntity = sut.selectByKey(
                    DEFAULT_サブ業務コード,
                    DEFAULT_帳票分類ID,
                    DEFAULT_管理年度,
                    DEFAULT_項目名);
            deletedEntity.setState(EntityDataState.Deleted);

            sut.save(deletedEntity);

            assertThat(sut.selectByKey(
                    DEFAULT_サブ業務コード,
                    DEFAULT_帳票分類ID,
                    DEFAULT_管理年度,
                    DEFAULT_項目名), is(nullValue()));
        }
    }

    private static class TestSupport {

        public static void insert(
                SubGyomuCode サブ業務コード,
                ReportId 帳票分類ID,
                FlexibleYear 管理年度,
                RString 項目名) {
            DbT7067ChohyoSeigyoHanyoEntity entity = DbT7067ChohyoSeigyoHanyoEntityGenerator.createDbT7067ChohyoSeigyoHanyoEntity();
            entity.setSubGyomuCode(サブ業務コード);
            entity.setChohyoBunruiID(帳票分類ID);
            entity.setKanriNendo(管理年度);
            entity.setKomokuName(項目名);
            sut.save(entity);
        }
    }
}
