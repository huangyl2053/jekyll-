/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.db.basic;

import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT4305IkenshoImageJohoDac;
import java.util.Collections;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4305IkenshoImageJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT4305IkenshoImageJohoEntityGenerator;
import static jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT4305IkenshoImageJohoEntityGenerator.DEFAULT_マスキングデータ区分;
import static jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT4305IkenshoImageJohoEntityGenerator.DEFAULT_主治医意見書作成依頼履歴番号;
import static jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT4305IkenshoImageJohoEntityGenerator.DEFAULT_取込みページ番号;
import static jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT4305IkenshoImageJohoEntityGenerator.DEFAULT_帳票ID;
import static jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT4305IkenshoImageJohoEntityGenerator.DEFAULT_申請書管理番号;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestDacBase;
import jp.co.ndensan.reams.uz.uza.biz.Code;
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
 * {@link DbT4305IkenshoImageJohoDac}のテストです。
 */
@Ignore
@RunWith(Enclosed.class)
public class DbT4305IkenshoImageJohoDacTest extends DbzTestDacBase {

    private static final RString キー_01 = new RString("01");
    private static final RString キー_02 = new RString("02");
    private static final RString キー_03 = new RString("03");
    private static DbT4305IkenshoImageJohoDac sut;

    @BeforeClass
    public static void setUpClass() {
        sut = InstanceProvider.create(DbT4305IkenshoImageJohoDac.class);
    }

    public static class selectByKeyのテスト extends DbzTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_申請書管理番号,
                    DEFAULT_主治医意見書作成依頼履歴番号,
                    DEFAULT_帳票ID,
                    DEFAULT_マスキングデータ区分,
                    DEFAULT_取込みページ番号);
            TestSupport.insert(
                    DEFAULT_申請書管理番号,
                    DEFAULT_主治医意見書作成依頼履歴番号,
                    DEFAULT_帳票ID,
                    DEFAULT_マスキングデータ区分,
                    DEFAULT_取込みページ番号);
        }

        @Test(expected = NullPointerException.class)
        public void 申請書管理番号がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_申請書管理番号,
                    DEFAULT_主治医意見書作成依頼履歴番号,
                    DEFAULT_帳票ID,
                    DEFAULT_マスキングデータ区分,
                    DEFAULT_取込みページ番号);
        }

        @Test(expected = NullPointerException.class)
        public void 主治医意見書作成依頼履歴番号がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_申請書管理番号,
                    DEFAULT_主治医意見書作成依頼履歴番号,
                    DEFAULT_帳票ID,
                    DEFAULT_マスキングデータ区分,
                    DEFAULT_取込みページ番号);
        }

        @Test(expected = NullPointerException.class)
        public void 帳票IDがnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_申請書管理番号,
                    DEFAULT_主治医意見書作成依頼履歴番号,
                    DEFAULT_帳票ID,
                    DEFAULT_マスキングデータ区分,
                    DEFAULT_取込みページ番号);
        }

        @Test(expected = NullPointerException.class)
        public void マスキングデータ区分がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_申請書管理番号,
                    DEFAULT_主治医意見書作成依頼履歴番号,
                    DEFAULT_帳票ID,
                    DEFAULT_マスキングデータ区分,
                    DEFAULT_取込みページ番号);
        }

        @Test(expected = NullPointerException.class)
        public void 取込みページ番号がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_申請書管理番号,
                    DEFAULT_主治医意見書作成依頼履歴番号,
                    DEFAULT_帳票ID,
                    DEFAULT_マスキングデータ区分,
                    DEFAULT_取込みページ番号);
        }

        @Test
        public void 存在する主キーを渡すと_selectByKeyは_該当のエンティティを返す() {
            DbT4305IkenshoImageJohoEntity insertedRecord = sut.selectByKey(
                    DEFAULT_申請書管理番号,
                    DEFAULT_主治医意見書作成依頼履歴番号,
                    DEFAULT_帳票ID,
                    DEFAULT_マスキングデータ区分,
                    DEFAULT_取込みページ番号);
            assertThat(insertedRecord, is(notNullValue()));
        }

        @Test
        public void 存在しない主キーを渡すと_selectByKeyは_nullを返す() {
            DbT4305IkenshoImageJohoEntity insertedRecord = sut.selectByKey(
                    DEFAULT_申請書管理番号,
                    DEFAULT_主治医意見書作成依頼履歴番号,
                    DEFAULT_帳票ID,
                    DEFAULT_マスキングデータ区分,
                    DEFAULT_取込みページ番号);
            assertThat(insertedRecord, is(nullValue()));
        }
    }

    public static class selectAllのテスト extends DbzTestDacBase {

        @Test
        public void 要介護認定意見書イメージ情報が存在する場合_selectAllは_全件を返す() {
            TestSupport.insert(
                    DEFAULT_申請書管理番号,
                    DEFAULT_主治医意見書作成依頼履歴番号,
                    DEFAULT_帳票ID,
                    DEFAULT_マスキングデータ区分,
                    DEFAULT_取込みページ番号);
            TestSupport.insert(
                    DEFAULT_申請書管理番号,
                    DEFAULT_主治医意見書作成依頼履歴番号,
                    DEFAULT_帳票ID,
                    DEFAULT_マスキングデータ区分,
                    DEFAULT_取込みページ番号);
            assertThat(sut.selectAll().size(), is(2));
        }

        @Test
        public void 要介護認定意見書イメージ情報が存在しない場合_selectAllは_空のリストを返す() {
            assertThat(sut.selectAll(), is(Collections.EMPTY_LIST));
        }
    }

    public static class insertのテスト extends DbzTestDacBase {

        @Test
        public void 要介護認定意見書イメージ情報エンティティを渡すと_insertは_要介護認定意見書イメージ情報を追加する() {
            TestSupport.insert(
                    DEFAULT_申請書管理番号,
                    DEFAULT_主治医意見書作成依頼履歴番号,
                    DEFAULT_帳票ID,
                    DEFAULT_マスキングデータ区分,
                    DEFAULT_取込みページ番号);

            assertThat(sut.selectByKey(
                    DEFAULT_申請書管理番号,
                    DEFAULT_主治医意見書作成依頼履歴番号,
                    DEFAULT_帳票ID,
                    DEFAULT_マスキングデータ区分,
                    DEFAULT_取込みページ番号), is(notNullValue()));
        }
    }

    public static class updateのテスト extends DbzTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_申請書管理番号,
                    DEFAULT_主治医意見書作成依頼履歴番号,
                    DEFAULT_帳票ID,
                    DEFAULT_マスキングデータ区分,
                    DEFAULT_取込みページ番号);
        }

        @Test
        public void 要介護認定意見書イメージ情報エンティティを渡すと_updateは_要介護認定意見書イメージ情報を更新する() {
            DbT4305IkenshoImageJohoEntity updateRecord = sut.selectByKey(
                    DEFAULT_申請書管理番号,
                    DEFAULT_主治医意見書作成依頼履歴番号,
                    DEFAULT_帳票ID,
                    DEFAULT_マスキングデータ区分,
                    DEFAULT_取込みページ番号);
            // TODO  主キー以外の項目を変更してください
            // updateRecord.set変更したい項目(75);

            sut.save(updateRecord);

            DbT4305IkenshoImageJohoEntity updatedRecord = sut.selectByKey(
                    DEFAULT_申請書管理番号,
                    DEFAULT_主治医意見書作成依頼履歴番号,
                    DEFAULT_帳票ID,
                    DEFAULT_マスキングデータ区分,
                    DEFAULT_取込みページ番号);

            // TODO  主キー以外の項目を変更してください
            // assertThat(updateRecord.get変更したい項目(), is(updatedRecord.get変更したい項目()));
        }
    }

    public static class deleteのテスト extends DbzTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_申請書管理番号,
                    DEFAULT_主治医意見書作成依頼履歴番号,
                    DEFAULT_帳票ID,
                    DEFAULT_マスキングデータ区分,
                    DEFAULT_取込みページ番号);
        }

        @Test
        public void 要介護認定意見書イメージ情報エンティティを渡すと_deleteは_要介護認定意見書イメージ情報を削除する() {
            DbT4305IkenshoImageJohoEntity deletedEntity = sut.selectByKey(
                    DEFAULT_申請書管理番号,
                    DEFAULT_主治医意見書作成依頼履歴番号,
                    DEFAULT_帳票ID,
                    DEFAULT_マスキングデータ区分,
                    DEFAULT_取込みページ番号);
            deletedEntity.setState(EntityDataState.Deleted);

            sut.save(deletedEntity);

            assertThat(sut.selectByKey(
                    DEFAULT_申請書管理番号,
                    DEFAULT_主治医意見書作成依頼履歴番号,
                    DEFAULT_帳票ID,
                    DEFAULT_マスキングデータ区分,
                    DEFAULT_取込みページ番号), is(nullValue()));
        }
    }

    private static class TestSupport {

        public static void insert(
                ShinseishoKanriNo 申請書管理番号,
                int 主治医意見書作成依頼履歴番号,
                Code 帳票ID,
                RString マスキングデータ区分,
                int 取込みページ番号) {
            DbT4305IkenshoImageJohoEntity entity = DbT4305IkenshoImageJohoEntityGenerator.createDbT4305IkenshoImageJohoEntity();
            entity.setShinseishoKanriNo(申請書管理番号);
            entity.setIraiRirekiNo(主治医意見書作成依頼履歴番号);
            entity.setChoyoID(帳票ID);
            entity.setGenponMaskKubun(マスキングデータ区分);
//            entity.setTorikomiPageNo(取込みページ番号);
            sut.save(entity);
        }
    }
}
