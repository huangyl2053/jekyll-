/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.db.basic;

import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT7003BemmeishaJohoDac;
import java.util.Collections;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7003BemmeishaJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT7003BemmeishaJohoEntityGenerator;
import static jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT7003BemmeishaJohoEntityGenerator.DEFAULT_原処分被保険者番号;
import static jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT7003BemmeishaJohoEntityGenerator.DEFAULT_審査請求届出日;
import static jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT7003BemmeishaJohoEntityGenerator.DEFAULT_弁明書作成日;
import static jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT7003BemmeishaJohoEntityGenerator.DEFAULT_弁明者枝番;
import static jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT7003BemmeishaJohoEntityGenerator.DEFAULT_証記載保険者番号;
import static jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT7003BemmeishaJohoEntityGenerator.DEFAULT_識別コード;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestDacBase;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
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
 * {@link DbT7003BemmeishaJohoDac}のテストです。
 */
@Ignore
@RunWith(Enclosed.class)
public class DbT7003BemmeishaJohoDacTest extends DbzTestDacBase {

    private static final RString キー_01 = RString.EMPTY;
    private static final RString キー_02 = new RString("02");
    private static final RString キー_03 = new RString("03");
    private static DbT7003BemmeishaJohoDac sut;

    @BeforeClass
    public static void setUpClass() {
        sut = InstanceProvider.create(DbT7003BemmeishaJohoDac.class);
    }

    public static class selectByKeyのテスト extends DbzTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_証記載保険者番号,
                    DEFAULT_識別コード,
                    DEFAULT_原処分被保険者番号,
                    DEFAULT_審査請求届出日,
                    DEFAULT_弁明書作成日,
                    DEFAULT_弁明者枝番);
            TestSupport.insert(
                    DEFAULT_証記載保険者番号,
                    DEFAULT_識別コード,
                    DEFAULT_原処分被保険者番号,
                    DEFAULT_審査請求届出日,
                    DEFAULT_弁明書作成日,
                    DEFAULT_弁明者枝番);
        }

        @Test(expected = NullPointerException.class)
        public void 証記載保険者番号がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_証記載保険者番号,
                    DEFAULT_識別コード,
                    DEFAULT_原処分被保険者番号,
                    DEFAULT_審査請求届出日,
                    DEFAULT_弁明書作成日,
                    DEFAULT_弁明者枝番);
        }

        @Test(expected = NullPointerException.class)
        public void 識別コードがnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_証記載保険者番号,
                    DEFAULT_識別コード,
                    DEFAULT_原処分被保険者番号,
                    DEFAULT_審査請求届出日,
                    DEFAULT_弁明書作成日,
                    DEFAULT_弁明者枝番);
        }

        @Test(expected = NullPointerException.class)
        public void 原処分被保険者番号がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_証記載保険者番号,
                    DEFAULT_識別コード,
                    DEFAULT_原処分被保険者番号,
                    DEFAULT_審査請求届出日,
                    DEFAULT_弁明書作成日,
                    DEFAULT_弁明者枝番);
        }

        @Test(expected = NullPointerException.class)
        public void 審査請求届出日がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_証記載保険者番号,
                    DEFAULT_識別コード,
                    DEFAULT_原処分被保険者番号,
                    DEFAULT_審査請求届出日,
                    DEFAULT_弁明書作成日,
                    DEFAULT_弁明者枝番);
        }

        @Test(expected = NullPointerException.class)
        public void 弁明書作成日がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_証記載保険者番号,
                    DEFAULT_識別コード,
                    DEFAULT_原処分被保険者番号,
                    DEFAULT_審査請求届出日,
                    DEFAULT_弁明書作成日,
                    DEFAULT_弁明者枝番);
        }

        @Test(expected = NullPointerException.class)
        public void 弁明者枝番がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_証記載保険者番号,
                    DEFAULT_識別コード,
                    DEFAULT_原処分被保険者番号,
                    DEFAULT_審査請求届出日,
                    DEFAULT_弁明書作成日,
                    DEFAULT_弁明者枝番);
        }

        @Test
        public void 存在する主キーを渡すと_selectByKeyは_該当のエンティティを返す() {
            DbT7003BemmeishaJohoEntity insertedRecord = sut.selectByKey(
                    DEFAULT_証記載保険者番号,
                    DEFAULT_識別コード,
                    DEFAULT_原処分被保険者番号,
                    DEFAULT_審査請求届出日,
                    DEFAULT_弁明書作成日,
                    DEFAULT_弁明者枝番);
            assertThat(insertedRecord, is(notNullValue()));
        }

        @Test
        public void 存在しない主キーを渡すと_selectByKeyは_nullを返す() {
            DbT7003BemmeishaJohoEntity insertedRecord = sut.selectByKey(
                    DEFAULT_証記載保険者番号,
                    DEFAULT_識別コード,
                    DEFAULT_原処分被保険者番号,
                    DEFAULT_審査請求届出日,
                    DEFAULT_弁明書作成日,
                    DEFAULT_弁明者枝番);
            assertThat(insertedRecord, is(nullValue()));
        }
    }

    public static class selectAllのテスト extends DbzTestDacBase {

        @Test
        public void 弁明者情報が存在する場合_selectAllは_全件を返す() {
            TestSupport.insert(
                    DEFAULT_証記載保険者番号,
                    DEFAULT_識別コード,
                    DEFAULT_原処分被保険者番号,
                    DEFAULT_審査請求届出日,
                    DEFAULT_弁明書作成日,
                    DEFAULT_弁明者枝番);
            TestSupport.insert(
                    DEFAULT_証記載保険者番号,
                    DEFAULT_識別コード,
                    DEFAULT_原処分被保険者番号,
                    DEFAULT_審査請求届出日,
                    DEFAULT_弁明書作成日,
                    DEFAULT_弁明者枝番);
            assertThat(sut.selectAll().size(), is(2));
        }

        @Test
        public void 弁明者情報が存在しない場合_selectAllは_空のリストを返す() {
            assertThat(sut.selectAll(), is(Collections.EMPTY_LIST));
        }
    }

    public static class insertのテスト extends DbzTestDacBase {

        @Test
        public void 弁明者情報エンティティを渡すと_insertは_弁明者情報を追加する() {
            TestSupport.insert(
                    DEFAULT_証記載保険者番号,
                    DEFAULT_識別コード,
                    DEFAULT_原処分被保険者番号,
                    DEFAULT_審査請求届出日,
                    DEFAULT_弁明書作成日,
                    DEFAULT_弁明者枝番);

            assertThat(sut.selectByKey(
                    DEFAULT_証記載保険者番号,
                    DEFAULT_識別コード,
                    DEFAULT_原処分被保険者番号,
                    DEFAULT_審査請求届出日,
                    DEFAULT_弁明書作成日,
                    DEFAULT_弁明者枝番), is(notNullValue()));
        }
    }

    public static class updateのテスト extends DbzTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_証記載保険者番号,
                    DEFAULT_識別コード,
                    DEFAULT_原処分被保険者番号,
                    DEFAULT_審査請求届出日,
                    DEFAULT_弁明書作成日,
                    DEFAULT_弁明者枝番);
        }

        @Test
        public void 弁明者情報エンティティを渡すと_updateは_弁明者情報を更新する() {
            DbT7003BemmeishaJohoEntity updateRecord = sut.selectByKey(
                    DEFAULT_証記載保険者番号,
                    DEFAULT_識別コード,
                    DEFAULT_原処分被保険者番号,
                    DEFAULT_審査請求届出日,
                    DEFAULT_弁明書作成日,
                    DEFAULT_弁明者枝番);
            updateRecord.setYakushoskuName(new RString("役職"));

            sut.save(updateRecord);

            DbT7003BemmeishaJohoEntity updatedRecord = sut.selectByKey(
                    DEFAULT_証記載保険者番号,
                    DEFAULT_識別コード,
                    DEFAULT_原処分被保険者番号,
                    DEFAULT_審査請求届出日,
                    DEFAULT_弁明書作成日,
                    DEFAULT_弁明者枝番);

            assertThat(updateRecord.getYakushoskuName(), is(updatedRecord.getYakushoskuName()));
        }
    }

    public static class deleteのテスト extends DbzTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_証記載保険者番号,
                    DEFAULT_識別コード,
                    DEFAULT_原処分被保険者番号,
                    DEFAULT_審査請求届出日,
                    DEFAULT_弁明書作成日,
                    DEFAULT_弁明者枝番);
        }

        @Test
        public void 弁明者情報エンティティを渡すと_deleteは_弁明者情報を削除する() {
            DbT7003BemmeishaJohoEntity deletedEntity = sut.selectByKey(
                    DEFAULT_証記載保険者番号,
                    DEFAULT_識別コード,
                    DEFAULT_原処分被保険者番号,
                    DEFAULT_審査請求届出日,
                    DEFAULT_弁明書作成日,
                    DEFAULT_弁明者枝番);
            deletedEntity.setState(EntityDataState.Deleted);

            sut.save(deletedEntity);

            assertThat(sut.selectByKey(
                    DEFAULT_証記載保険者番号,
                    DEFAULT_識別コード,
                    DEFAULT_原処分被保険者番号,
                    DEFAULT_審査請求届出日,
                    DEFAULT_弁明書作成日,
                    DEFAULT_弁明者枝番), is(nullValue()));
        }
    }

    private static class TestSupport {

        public static void insert(
                ShoKisaiHokenshaNo 証記載保険者番号,
                ShikibetsuCode 識別コード,
                HihokenshaNo 原処分被保険者番号,
                FlexibleDate 審査請求届出日,
                FlexibleDate 弁明書作成日,
                Decimal 弁明者枝番) {
            DbT7003BemmeishaJohoEntity entity = DbT7003BemmeishaJohoEntityGenerator.createDbT7003BemmeishaJohoEntity();
            entity.setShoKisaiHokenshaNo(証記載保険者番号);
            entity.setShikibetsuCode(識別コード);
            entity.setGenshobunHihokenshaNo(原処分被保険者番号);
            entity.setShinsaseikyuTodokedeYMD(審査請求届出日);
            entity.setBemmeishoSakuseiYMD(弁明書作成日);
            entity.setBemmeishaEdaban(弁明者枝番.intValue());
            sut.save(entity);
        }
    }
}
