/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.basic;

import java.util.Collections;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7001FufukuMoshitateEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.helper.DbT7001FufukuMoshitateEntityGenerator;
import static jp.co.ndensan.reams.db.dbz.entity.db.basic.helper.DbT7001FufukuMoshitateEntityGenerator.*;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestDacBase;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
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
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link DbT7001FufukuMoshitateDac}のテストです。
 */
@RunWith(Enclosed.class)
public class DbT7001FufukuMoshitateDacTest extends DbzTestDacBase {

    private static final RString キー_01 = RString.EMPTY;
    private static final RString キー_02 = new RString("02");
    private static final RString キー_03 = new RString("03");
    private static DbT7001FufukuMoshitateDac sut;

    @BeforeClass
    public static void setUpClass() {
        sut = InstanceProvider.create(DbT7001FufukuMoshitateDac.class);
    }

    public static class selectByKeyのテスト extends DbzTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_証記載保険者番号,
                    DEFAULT_識別コード,
                    DEFAULT_原処分被保険者番号,
                    DEFAULT_審査請求届出日);
            TestSupport.insert(
                    DEFAULT_証記載保険者番号,
                    DEFAULT_識別コード,
                    DEFAULT_原処分被保険者番号,
                    DEFAULT_審査請求届出日);
        }

        @Test(expected = NullPointerException.class)
        public void 証記載保険者番号がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_証記載保険者番号,
                    DEFAULT_識別コード,
                    DEFAULT_原処分被保険者番号,
                    DEFAULT_審査請求届出日);
        }

        @Test(expected = NullPointerException.class)
        public void 識別コードがnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_証記載保険者番号,
                    DEFAULT_識別コード,
                    DEFAULT_原処分被保険者番号,
                    DEFAULT_審査請求届出日);
        }

        @Test(expected = NullPointerException.class)
        public void 原処分被保険者番号がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_証記載保険者番号,
                    DEFAULT_識別コード,
                    DEFAULT_原処分被保険者番号,
                    DEFAULT_審査請求届出日);
        }

        @Test(expected = NullPointerException.class)
        public void 審査請求届出日がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_証記載保険者番号,
                    DEFAULT_識別コード,
                    DEFAULT_原処分被保険者番号,
                    DEFAULT_審査請求届出日);
        }

        @Test
        public void 存在する主キーを渡すと_selectByKeyは_該当のエンティティを返す() {
            DbT7001FufukuMoshitateEntity insertedRecord = sut.selectByKey(
                    DEFAULT_証記載保険者番号,
                    DEFAULT_識別コード,
                    DEFAULT_原処分被保険者番号,
                    DEFAULT_審査請求届出日);
            assertThat(insertedRecord, is(notNullValue()));
        }

        @Test
        public void 存在しない主キーを渡すと_selectByKeyは_nullを返す() {
            DbT7001FufukuMoshitateEntity insertedRecord = sut.selectByKey(
                    DEFAULT_証記載保険者番号,
                    DEFAULT_識別コード,
                    DEFAULT_原処分被保険者番号,
                    DEFAULT_審査請求届出日);
            assertThat(insertedRecord, is(nullValue()));
        }
    }

    public static class selectAllのテスト extends DbzTestDacBase {

        @Test
        public void 不服審査申立情報が存在する場合_selectAllは_全件を返す() {
            TestSupport.insert(
                    DEFAULT_証記載保険者番号,
                    DEFAULT_識別コード,
                    DEFAULT_原処分被保険者番号,
                    DEFAULT_審査請求届出日);
            TestSupport.insert(
                    DEFAULT_証記載保険者番号,
                    DEFAULT_識別コード,
                    DEFAULT_原処分被保険者番号,
                    DEFAULT_審査請求届出日);
            assertThat(sut.selectAll().size(), is(2));
        }

        @Test
        public void 不服審査申立情報が存在しない場合_selectAllは_空のリストを返す() {
            assertThat(sut.selectAll(), is(Collections.EMPTY_LIST));
        }
    }

    public static class insertのテスト extends DbzTestDacBase {

        @Test
        public void 不服審査申立情報エンティティを渡すと_insertは_不服審査申立情報を追加する() {
            TestSupport.insert(
                    DEFAULT_証記載保険者番号,
                    DEFAULT_識別コード,
                    DEFAULT_原処分被保険者番号,
                    DEFAULT_審査請求届出日);

            assertThat(sut.selectByKey(
                    DEFAULT_証記載保険者番号,
                    DEFAULT_識別コード,
                    DEFAULT_原処分被保険者番号,
                    DEFAULT_審査請求届出日), is(notNullValue()));
        }
    }

    public static class updateのテスト extends DbzTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_証記載保険者番号,
                    DEFAULT_識別コード,
                    DEFAULT_原処分被保険者番号,
                    DEFAULT_審査請求届出日);
        }

        @Test
        public void 不服審査申立情報エンティティを渡すと_updateは_不服審査申立情報を更新する() {
            DbT7001FufukuMoshitateEntity updateRecord = sut.selectByKey(
                    DEFAULT_証記載保険者番号,
                    DEFAULT_識別コード,
                    DEFAULT_原処分被保険者番号,
                    DEFAULT_審査請求届出日);
            updateRecord.setDairininShimei(new AtenaMeisho("代理人氏名"));

            sut.save(updateRecord);

            DbT7001FufukuMoshitateEntity updatedRecord = sut.selectByKey(
                    DEFAULT_証記載保険者番号,
                    DEFAULT_識別コード,
                    DEFAULT_原処分被保険者番号,
                    DEFAULT_審査請求届出日);

            assertThat(updateRecord.getDairininShimei(), is(updatedRecord.getDairininShimei()));
        }
    }

    public static class deleteのテスト extends DbzTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_証記載保険者番号,
                    DEFAULT_識別コード,
                    DEFAULT_原処分被保険者番号,
                    DEFAULT_審査請求届出日);
        }

        @Test
        public void 不服審査申立情報エンティティを渡すと_deleteは_不服審査申立情報を削除する() {
            DbT7001FufukuMoshitateEntity deletedEntity = sut.selectByKey(
                    DEFAULT_証記載保険者番号,
                    DEFAULT_識別コード,
                    DEFAULT_原処分被保険者番号,
                    DEFAULT_審査請求届出日);
            deletedEntity.setState(EntityDataState.Deleted);

            sut.save(deletedEntity);

            assertThat(sut.selectByKey(
                    DEFAULT_証記載保険者番号,
                    DEFAULT_識別コード,
                    DEFAULT_原処分被保険者番号,
                    DEFAULT_審査請求届出日), is(nullValue()));
        }
    }

    private static class TestSupport {

        public static void insert(
                ShoKisaiHokenshaNo 証記載保険者番号,
                ShikibetsuCode 識別コード,
                HihokenshaNo 原処分被保険者番号,
                FlexibleDate 審査請求届出日) {
            DbT7001FufukuMoshitateEntity entity = DbT7001FufukuMoshitateEntityGenerator.createDbT7001FufukuMoshitateEntity();
            entity.setShoKisaiHokenshaNo(証記載保険者番号);
            entity.setShikibetsuCode(識別コード);
            entity.setGenshobunsHihokennshaNo(原処分被保険者番号);
            entity.setShinsaSeikyuTodokedeYMD(審査請求届出日);
            sut.save(entity);
        }
    }
}
