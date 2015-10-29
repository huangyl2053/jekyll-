/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.basic;

import java.util.Collections;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3116KijunShunyugakuTekiyoKanriEntity;
import jp.co.ndensan.reams.db.dbc.entity.basic.helper.DbT3116KijunShunyugakuTekiyoKanriEntityGenerator;
import static jp.co.ndensan.reams.db.dbc.entity.basic.helper.DbT3116KijunShunyugakuTekiyoKanriEntityGenerator.*;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbz.testhelper.DbcTestDacBase;
import jp.co.ndensan.reams.uz.uza.biz.SetaiCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.nullValue;
import org.junit.Test;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link DbT3116KijunShunyugakuTekiyoKanriDac}のテストです。
 */
@RunWith(Enclosed.class)
@Ignore
public class DbT3116KijunShunyugakuTekiyoKanriDacTest extends DbcTestDacBase {

    private static final RString キー_02 = new RString("02");
    private static final RString キー_03 = new RString("03");
    private static DbT3116KijunShunyugakuTekiyoKanriDac sut;

    @BeforeClass
    public static void setUpClass() {
        sut = InstanceProvider.create(DbT3116KijunShunyugakuTekiyoKanriDac.class);
    }

    public static class selectByKeyのテスト extends DbcTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_世帯コード,
                    DEFAULT_年度,
                    DEFAULT_履歴番号,
                    DEFAULT_被保険者番号);
            TestSupport.insert(
                    DEFAULT_世帯コード,
                    DEFAULT_年度,
                    DEFAULT_履歴番号,
                    DEFAULT_被保険者番号);
        }

        @Test(expected = NullPointerException.class)
        public void 世帯コードがnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_世帯コード,
                    DEFAULT_年度,
                    DEFAULT_履歴番号,
                    DEFAULT_被保険者番号);
        }

        @Test(expected = NullPointerException.class)
        public void 年度がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_世帯コード,
                    DEFAULT_年度,
                    DEFAULT_履歴番号,
                    DEFAULT_被保険者番号);
        }

        @Test(expected = NullPointerException.class)
        public void 履歴番号がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_世帯コード,
                    DEFAULT_年度,
                    DEFAULT_履歴番号,
                    DEFAULT_被保険者番号);
        }

        @Test(expected = NullPointerException.class)
        public void 被保険者番号がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_世帯コード,
                    DEFAULT_年度,
                    DEFAULT_履歴番号,
                    DEFAULT_被保険者番号);
        }

        @Test
        public void 存在する主キーを渡すと_selectByKeyは_該当のエンティティを返す() {
            DbT3116KijunShunyugakuTekiyoKanriEntity insertedRecord = sut.selectByKey(
                    DEFAULT_世帯コード,
                    DEFAULT_年度,
                    DEFAULT_履歴番号,
                    DEFAULT_被保険者番号);
            assertThat(insertedRecord, is(notNullValue()));
        }

        @Test
        public void 存在しない主キーを渡すと_selectByKeyは_nullを返す() {
            DbT3116KijunShunyugakuTekiyoKanriEntity insertedRecord = sut.selectByKey(
                    DEFAULT_世帯コード,
                    DEFAULT_年度,
                    DEFAULT_履歴番号,
                    DEFAULT_被保険者番号);
            assertThat(insertedRecord, is(nullValue()));
        }
    }

    public static class selectAllのテスト extends DbcTestDacBase {

        @Test
        public void 基準収入額適用管理が存在する場合_selectAllは_全件を返す() {
            TestSupport.insert(
                    DEFAULT_世帯コード,
                    DEFAULT_年度,
                    DEFAULT_履歴番号,
                    DEFAULT_被保険者番号);
            TestSupport.insert(
                    DEFAULT_世帯コード,
                    DEFAULT_年度,
                    DEFAULT_履歴番号,
                    DEFAULT_被保険者番号);
            assertThat(sut.selectAll().size(), is(2));
        }

        @Test
        public void 基準収入額適用管理が存在しない場合_selectAllは_空のリストを返す() {
            assertThat(sut.selectAll(), is(Collections.EMPTY_LIST));
        }
    }

    public static class insertのテスト extends DbcTestDacBase {

        @Test
        public void 基準収入額適用管理エンティティを渡すと_insertは_基準収入額適用管理を追加する() {
            TestSupport.insert(
                    DEFAULT_世帯コード,
                    DEFAULT_年度,
                    DEFAULT_履歴番号,
                    DEFAULT_被保険者番号);

            assertThat(sut.selectByKey(
                    DEFAULT_世帯コード,
                    DEFAULT_年度,
                    DEFAULT_履歴番号,
                    DEFAULT_被保険者番号), is(notNullValue()));
        }
    }

    public static class updateのテスト extends DbcTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_世帯コード,
                    DEFAULT_年度,
                    DEFAULT_履歴番号,
                    DEFAULT_被保険者番号);
        }

        @Test
        public void 基準収入額適用管理エンティティを渡すと_updateは_基準収入額適用管理を更新する() {
            DbT3116KijunShunyugakuTekiyoKanriEntity updateRecord = sut.selectByKey(
                    DEFAULT_世帯コード,
                    DEFAULT_年度,
                    DEFAULT_履歴番号,
                    DEFAULT_被保険者番号);
            updateRecord.setNendo(new FlexibleYear("2020"));

            sut.save(updateRecord);

            DbT3116KijunShunyugakuTekiyoKanriEntity updatedRecord = sut.selectByKey(
                    DEFAULT_世帯コード,
                    DEFAULT_年度,
                    DEFAULT_履歴番号,
                    DEFAULT_被保険者番号);

            assertThat(updateRecord.getNendo(), is(updatedRecord.getNendo()));
        }
    }

    public static class deleteのテスト extends DbcTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_世帯コード,
                    DEFAULT_年度,
                    DEFAULT_履歴番号,
                    DEFAULT_被保険者番号);
        }

        @Test
        public void 基準収入額適用管理エンティティを渡すと_deleteは_基準収入額適用管理を削除する() {
            DbT3116KijunShunyugakuTekiyoKanriEntity deletedEntity = sut.selectByKey(
                    DEFAULT_世帯コード,
                    DEFAULT_年度,
                    DEFAULT_履歴番号,
                    DEFAULT_被保険者番号);
            deletedEntity.setState(EntityDataState.Deleted);

            sut.save(deletedEntity);

            assertThat(sut.selectByKey(
                    DEFAULT_世帯コード,
                    DEFAULT_年度,
                    DEFAULT_履歴番号,
                    DEFAULT_被保険者番号), is(nullValue()));
        }
    }

    private static class TestSupport {

        public static void insert(
                SetaiCode 世帯コード,
                FlexibleYear 年度,
                Decimal 履歴番号,
                HokenshaNo 被保険者番号) {
            DbT3116KijunShunyugakuTekiyoKanriEntity entity = DbT3116KijunShunyugakuTekiyoKanriEntityGenerator.createDbT3116KijunShunyugakuTekiyoKanriEntity();
            entity.setSetaiCode(世帯コード);
            entity.setNendo(年度);
            entity.setRirekiNo(履歴番号);
            entity.setHihokenshaNo(被保険者番号);
            sut.save(entity);
        }
    }
}
