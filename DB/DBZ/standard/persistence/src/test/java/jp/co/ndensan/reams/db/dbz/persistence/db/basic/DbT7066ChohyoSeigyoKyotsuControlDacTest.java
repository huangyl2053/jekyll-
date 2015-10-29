/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.db.basic;

import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT7066ChohyoSeigyoKyotsuControlDac;
import java.util.Collections;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7066ChohyoSeigyoKyotsuControlEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT7066ChohyoSeigyoKyotsuControlEntityGenerator;
import static jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT7066ChohyoSeigyoKyotsuControlEntityGenerator.*;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestDacBase;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RYear;
import jp.co.ndensan.reams.uz.uza.lang.RYearMonth;
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
 * {@link DbT7066ChohyoSeigyoKyotsuControlDac}のテストです。
 */
@Ignore
@RunWith(Enclosed.class)
public class DbT7066ChohyoSeigyoKyotsuControlDacTest extends DbzTestDacBase {

    private static final RString キー_01 = RString.EMPTY;
    private static final RString キー_02 = new RString("02");
    private static final RString キー_03 = new RString("03");
    private static DbT7066ChohyoSeigyoKyotsuControlDac sut;

    @BeforeClass
    public static void setUpClass() {
        sut = InstanceProvider.create(DbT7066ChohyoSeigyoKyotsuControlDac.class);
    }

    public static class selectByKeyのテスト extends DbzTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_サブ業務コード,
                    DEFAULT_帳票分類ID);
            TestSupport.insert(
                    DEFAULT_サブ業務コード,
                    DEFAULT_帳票分類ID);
        }

        @Test(expected = NullPointerException.class)
        public void サブ業務コードがnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_サブ業務コード,
                    DEFAULT_帳票分類ID);
        }

        @Test(expected = NullPointerException.class)
        public void 帳票分類IDがnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_サブ業務コード,
                    DEFAULT_帳票分類ID);
        }

        @Test
        public void 存在する主キーを渡すと_selectByKeyは_該当のエンティティを返す() {
            DbT7066ChohyoSeigyoKyotsuControlEntity insertedRecord = sut.selectByKey(
                    DEFAULT_サブ業務コード,
                    DEFAULT_帳票分類ID);
            assertThat(insertedRecord, is(notNullValue()));
        }

        @Test
        public void 存在しない主キーを渡すと_selectByKeyは_nullを返す() {
            DbT7066ChohyoSeigyoKyotsuControlEntity insertedRecord = sut.selectByKey(
                    DEFAULT_サブ業務コード,
                    DEFAULT_帳票分類ID);
            assertThat(insertedRecord, is(nullValue()));
        }
    }

    public static class selectAllのテスト extends DbzTestDacBase {

        @Test
        public void 帳票制御共通コントロールが存在する場合_selectAllは_全件を返す() {
            TestSupport.insert(
                    DEFAULT_サブ業務コード,
                    DEFAULT_帳票分類ID);
            TestSupport.insert(
                    DEFAULT_サブ業務コード,
                    DEFAULT_帳票分類ID);
            assertThat(sut.selectAll().size(), is(2));
        }

        @Test
        public void 帳票制御共通コントロールが存在しない場合_selectAllは_空のリストを返す() {
            assertThat(sut.selectAll(), is(Collections.EMPTY_LIST));
        }
    }

    public static class insertのテスト extends DbzTestDacBase {

        @Test
        public void 帳票制御共通コントロールエンティティを渡すと_insertは_帳票制御共通コントロールを追加する() {
            TestSupport.insert(
                    DEFAULT_サブ業務コード,
                    DEFAULT_帳票分類ID);

            assertThat(sut.selectByKey(
                    DEFAULT_サブ業務コード,
                    DEFAULT_帳票分類ID), is(notNullValue()));
        }
    }

    public static class updateのテスト extends DbzTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_サブ業務コード,
                    DEFAULT_帳票分類ID);
        }

        @Test
        public void 帳票制御共通コントロールエンティティを渡すと_updateは_帳票制御共通コントロールを更新する() {
            DbT7066ChohyoSeigyoKyotsuControlEntity updateRecord = sut.selectByKey(
                    DEFAULT_サブ業務コード,
                    DEFAULT_帳票分類ID);
            updateRecord.setNinshoshaShiyoKubun(new RString("02"));

            sut.save(updateRecord);

            DbT7066ChohyoSeigyoKyotsuControlEntity updatedRecord = sut.selectByKey(
                    DEFAULT_サブ業務コード,
                    DEFAULT_帳票分類ID);

            assertThat(updateRecord.getNinshoshaShiyoKubun(), is(updatedRecord.getNinshoshaShiyoKubun()));
        }
    }

    public static class deleteのテスト extends DbzTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_サブ業務コード,
                    DEFAULT_帳票分類ID);
        }

        @Test
        public void 帳票制御共通コントロールエンティティを渡すと_deleteは_帳票制御共通コントロールを削除する() {
            DbT7066ChohyoSeigyoKyotsuControlEntity deletedEntity = sut.selectByKey(
                    DEFAULT_サブ業務コード,
                    DEFAULT_帳票分類ID);
            deletedEntity.setState(EntityDataState.Deleted);

            sut.save(deletedEntity);

            assertThat(sut.selectByKey(
                    DEFAULT_サブ業務コード,
                    DEFAULT_帳票分類ID), is(nullValue()));
        }
    }

    private static class TestSupport {

        public static void insert(
                SubGyomuCode サブ業務コード,
                ReportId 帳票分類ID) {
            DbT7066ChohyoSeigyoKyotsuControlEntity entity = DbT7066ChohyoSeigyoKyotsuControlEntityGenerator.createDbT7066ChohyoSeigyoKyotsuControlEntity();
            entity.setSubGyomuCode(サブ業務コード);
            entity.setChohyoBunruiID(帳票分類ID);
            sut.save(entity);
        }
    }
}
