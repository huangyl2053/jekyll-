/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.db.basic;

import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT7014KaigoSetaiDac;
import java.util.Collections;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7014KaigoSetaiEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT7014KaigoSetaiEntityGenerator;
import static jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT7014KaigoSetaiEntityGenerator.DEFAULT_世帯員管理連番;
import static jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT7014KaigoSetaiEntityGenerator.DEFAULT_世帯員識別コード;
import static jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT7014KaigoSetaiEntityGenerator.DEFAULT_世帯把握基準年月日;
import static jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT7014KaigoSetaiEntityGenerator.DEFAULT_本人区分;
import static jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT7014KaigoSetaiEntityGenerator.DEFAULT_管理識別区分;
import static jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT7014KaigoSetaiEntityGenerator.DEFAULT_被保険者番号;
import static jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT7014KaigoSetaiEntityGenerator.DEFAULT_課税年度;
import static jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT7014KaigoSetaiEntityGenerator.DEFAULT_課税非課税区分;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestDacBase;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
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
 * {@link DbT7014KaigoSetaiDac}のテストです。
 */
@Ignore
@RunWith(Enclosed.class)
public class DbT7014KaigoSetaiDacTest extends DbzTestDacBase {

    private static final RString キー_01 = new RString("01");
    private static final RString キー_02 = new RString("02");
    private static final RString キー_03 = new RString("03");
    private static DbT7014KaigoSetaiDac sut;

    @BeforeClass
    public static void setUpClass() {
        sut = InstanceProvider.create(DbT7014KaigoSetaiDac.class);
    }

    public static class selectByKeyのテスト extends DbzTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_被保険者番号,
                    DEFAULT_管理識別区分,
                    DEFAULT_世帯把握基準年月日,
                    DEFAULT_世帯員管理連番,
                    DEFAULT_世帯員識別コード,
                    DEFAULT_本人区分,
                    DEFAULT_課税年度,
                    DEFAULT_課税非課税区分);
            TestSupport.insert(
                    DEFAULT_被保険者番号,
                    DEFAULT_管理識別区分,
                    DEFAULT_世帯把握基準年月日,
                    DEFAULT_世帯員管理連番,
                    DEFAULT_世帯員識別コード,
                    DEFAULT_本人区分,
                    DEFAULT_課税年度,
                    DEFAULT_課税非課税区分);
        }

        @Test(expected = NullPointerException.class)
        public void 被保険者番号がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_被保険者番号,
                    DEFAULT_管理識別区分,
                    DEFAULT_世帯把握基準年月日,
                    DEFAULT_世帯員管理連番,
                    DEFAULT_世帯員識別コード,
                    DEFAULT_本人区分,
                    DEFAULT_課税年度,
                    DEFAULT_課税非課税区分);
        }

        @Test(expected = NullPointerException.class)
        public void 管理識別区分がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_被保険者番号,
                    DEFAULT_管理識別区分,
                    DEFAULT_世帯把握基準年月日,
                    DEFAULT_世帯員管理連番,
                    DEFAULT_世帯員識別コード,
                    DEFAULT_本人区分,
                    DEFAULT_課税年度,
                    DEFAULT_課税非課税区分);
        }

        @Test(expected = NullPointerException.class)
        public void 世帯把握基準年月日がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_被保険者番号,
                    DEFAULT_管理識別区分,
                    DEFAULT_世帯把握基準年月日,
                    DEFAULT_世帯員管理連番,
                    DEFAULT_世帯員識別コード,
                    DEFAULT_本人区分,
                    DEFAULT_課税年度,
                    DEFAULT_課税非課税区分);
        }

        @Test(expected = NullPointerException.class)
        public void 世帯員管理連番がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_被保険者番号,
                    DEFAULT_管理識別区分,
                    DEFAULT_世帯把握基準年月日,
                    DEFAULT_世帯員管理連番,
                    DEFAULT_世帯員識別コード,
                    DEFAULT_本人区分,
                    DEFAULT_課税年度,
                    DEFAULT_課税非課税区分);
        }

        @Test(expected = NullPointerException.class)
        public void 世帯員識別コードがnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_被保険者番号,
                    DEFAULT_管理識別区分,
                    DEFAULT_世帯把握基準年月日,
                    DEFAULT_世帯員管理連番,
                    DEFAULT_世帯員識別コード,
                    DEFAULT_本人区分,
                    DEFAULT_課税年度,
                    DEFAULT_課税非課税区分);
        }

        @Test(expected = NullPointerException.class)
        public void 本人区分がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_被保険者番号,
                    DEFAULT_管理識別区分,
                    DEFAULT_世帯把握基準年月日,
                    DEFAULT_世帯員管理連番,
                    DEFAULT_世帯員識別コード,
                    DEFAULT_本人区分,
                    DEFAULT_課税年度,
                    DEFAULT_課税非課税区分);
        }

        @Test(expected = NullPointerException.class)
        public void 課税年度がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_被保険者番号,
                    DEFAULT_管理識別区分,
                    DEFAULT_世帯把握基準年月日,
                    DEFAULT_世帯員管理連番,
                    DEFAULT_世帯員識別コード,
                    DEFAULT_本人区分,
                    DEFAULT_課税年度,
                    DEFAULT_課税非課税区分);
        }

        @Test(expected = NullPointerException.class)
        public void 課税非課税区分がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_被保険者番号,
                    DEFAULT_管理識別区分,
                    DEFAULT_世帯把握基準年月日,
                    DEFAULT_世帯員管理連番,
                    DEFAULT_世帯員識別コード,
                    DEFAULT_本人区分,
                    DEFAULT_課税年度,
                    DEFAULT_課税非課税区分);
        }

        @Test
        public void 存在する主キーを渡すと_selectByKeyは_該当のエンティティを返す() {
            DbT7014KaigoSetaiEntity insertedRecord = sut.selectByKey(
                    DEFAULT_被保険者番号,
                    DEFAULT_管理識別区分,
                    DEFAULT_世帯把握基準年月日,
                    DEFAULT_世帯員管理連番,
                    DEFAULT_世帯員識別コード,
                    DEFAULT_本人区分,
                    DEFAULT_課税年度,
                    DEFAULT_課税非課税区分);
            assertThat(insertedRecord, is(notNullValue()));
        }

        @Test
        public void 存在しない主キーを渡すと_selectByKeyは_nullを返す() {
            DbT7014KaigoSetaiEntity insertedRecord = sut.selectByKey(
                    DEFAULT_被保険者番号,
                    DEFAULT_管理識別区分,
                    DEFAULT_世帯把握基準年月日,
                    DEFAULT_世帯員管理連番,
                    DEFAULT_世帯員識別コード,
                    DEFAULT_本人区分,
                    DEFAULT_課税年度,
                    DEFAULT_課税非課税区分);
            assertThat(insertedRecord, is(nullValue()));
        }
    }

    public static class selectAllのテスト extends DbzTestDacBase {

        @Test
        public void 介護世帯が存在する場合_selectAllは_全件を返す() {
            TestSupport.insert(
                    DEFAULT_被保険者番号,
                    DEFAULT_管理識別区分,
                    DEFAULT_世帯把握基準年月日,
                    DEFAULT_世帯員管理連番,
                    DEFAULT_世帯員識別コード,
                    DEFAULT_本人区分,
                    DEFAULT_課税年度,
                    DEFAULT_課税非課税区分);
            TestSupport.insert(
                    DEFAULT_被保険者番号,
                    DEFAULT_管理識別区分,
                    DEFAULT_世帯把握基準年月日,
                    DEFAULT_世帯員管理連番,
                    DEFAULT_世帯員識別コード,
                    DEFAULT_本人区分,
                    DEFAULT_課税年度,
                    DEFAULT_課税非課税区分);
            assertThat(sut.selectAll().size(), is(2));
        }

        @Test
        public void 介護世帯が存在しない場合_selectAllは_空のリストを返す() {
            assertThat(sut.selectAll(), is(Collections.EMPTY_LIST));
        }
    }

    public static class insertのテスト extends DbzTestDacBase {

        @Test
        public void 介護世帯エンティティを渡すと_insertは_介護世帯を追加する() {
            TestSupport.insert(
                    DEFAULT_被保険者番号,
                    DEFAULT_管理識別区分,
                    DEFAULT_世帯把握基準年月日,
                    DEFAULT_世帯員管理連番,
                    DEFAULT_世帯員識別コード,
                    DEFAULT_本人区分,
                    DEFAULT_課税年度,
                    DEFAULT_課税非課税区分);

            assertThat(sut.selectByKey(
                    DEFAULT_被保険者番号,
                    DEFAULT_管理識別区分,
                    DEFAULT_世帯把握基準年月日,
                    DEFAULT_世帯員管理連番,
                    DEFAULT_世帯員識別コード,
                    DEFAULT_本人区分,
                    DEFAULT_課税年度,
                    DEFAULT_課税非課税区分), is(notNullValue()));
        }
    }

    public static class updateのテスト extends DbzTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_被保険者番号,
                    DEFAULT_管理識別区分,
                    DEFAULT_世帯把握基準年月日,
                    DEFAULT_世帯員管理連番,
                    DEFAULT_世帯員識別コード,
                    DEFAULT_本人区分,
                    DEFAULT_課税年度,
                    DEFAULT_課税非課税区分);
        }

        @Test
        public void 介護世帯エンティティを渡すと_updateは_介護世帯を更新する() {
            DbT7014KaigoSetaiEntity updateRecord = sut.selectByKey(
                    DEFAULT_被保険者番号,
                    DEFAULT_管理識別区分,
                    DEFAULT_世帯把握基準年月日,
                    DEFAULT_世帯員管理連番,
                    DEFAULT_世帯員識別コード,
                    DEFAULT_本人区分,
                    DEFAULT_課税年度,
                    DEFAULT_課税非課税区分);
            // TODO  主キー以外の項目を変更してください
            // updateRecord.set変更したい項目(75);

            sut.save(updateRecord);

            DbT7014KaigoSetaiEntity updatedRecord = sut.selectByKey(
                    DEFAULT_被保険者番号,
                    DEFAULT_管理識別区分,
                    DEFAULT_世帯把握基準年月日,
                    DEFAULT_世帯員管理連番,
                    DEFAULT_世帯員識別コード,
                    DEFAULT_本人区分,
                    DEFAULT_課税年度,
                    DEFAULT_課税非課税区分);

            // TODO  主キー以外の項目を変更してください
            // assertThat(updateRecord.get変更したい項目(), is(updatedRecord.get変更したい項目()));
        }
    }

    public static class deleteのテスト extends DbzTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_被保険者番号,
                    DEFAULT_管理識別区分,
                    DEFAULT_世帯把握基準年月日,
                    DEFAULT_世帯員管理連番,
                    DEFAULT_世帯員識別コード,
                    DEFAULT_本人区分,
                    DEFAULT_課税年度,
                    DEFAULT_課税非課税区分);
        }

        @Test
        public void 介護世帯エンティティを渡すと_deleteは_介護世帯を削除する() {
            DbT7014KaigoSetaiEntity deletedEntity = sut.selectByKey(
                    DEFAULT_被保険者番号,
                    DEFAULT_管理識別区分,
                    DEFAULT_世帯把握基準年月日,
                    DEFAULT_世帯員管理連番,
                    DEFAULT_世帯員識別コード,
                    DEFAULT_本人区分,
                    DEFAULT_課税年度,
                    DEFAULT_課税非課税区分);
            deletedEntity.setState(EntityDataState.Deleted);

            sut.save(deletedEntity);

            assertThat(sut.selectByKey(
                    DEFAULT_被保険者番号,
                    DEFAULT_管理識別区分,
                    DEFAULT_世帯把握基準年月日,
                    DEFAULT_世帯員管理連番,
                    DEFAULT_世帯員識別コード,
                    DEFAULT_本人区分,
                    DEFAULT_課税年度,
                    DEFAULT_課税非課税区分), is(nullValue()));
        }
    }

    private static class TestSupport {

        public static void insert(
                HihokenshaNo 被保険者番号,
                RString 管理識別区分,
                FlexibleDate 世帯把握基準年月日,
                int 世帯員管理連番,
                ShikibetsuCode 世帯員識別コード,
                RString 本人区分,
                FlexibleYear 課税年度,
                RString 課税非課税区分) {
            DbT7014KaigoSetaiEntity entity = DbT7014KaigoSetaiEntityGenerator.createDbT7014KaigoSetaiEntity();
            entity.setHihokenshaNo(被保険者番号);
            entity.setKanriShikibetsuKubun(管理識別区分);
            entity.setSetaiHaakuKijunYMD(世帯把握基準年月日);
            entity.setSetaiInkanriRenban(世帯員管理連番);
            entity.setSetaiInshikibetsuCode(世帯員識別コード);
            entity.setHonninKubun(本人区分);
            entity.setKazeiNendo(課税年度);
            entity.setKazeiHikazeiKubun(課税非課税区分);
            sut.save(entity);
        }
    }
}
