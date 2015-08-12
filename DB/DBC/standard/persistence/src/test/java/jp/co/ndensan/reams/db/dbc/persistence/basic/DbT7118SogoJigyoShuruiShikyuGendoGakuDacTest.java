/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.basic;

import java.util.Collections;
import jp.co.ndensan.reams.db.dbc.entity.basic.DbT7118SogoJigyoShuruiShikyuGendoGakuEntity;
import jp.co.ndensan.reams.db.dbc.entity.basic.helper.DbT7118SogoJigyoShuruiShikyuGendoGakuEntityGenerator;
import static jp.co.ndensan.reams.db.dbc.entity.basic.helper.DbT7118SogoJigyoShuruiShikyuGendoGakuEntityGenerator.DEFAULT_サービス種類コード;
import static jp.co.ndensan.reams.db.dbc.entity.basic.helper.DbT7118SogoJigyoShuruiShikyuGendoGakuEntityGenerator.DEFAULT_履歴番号;
import static jp.co.ndensan.reams.db.dbc.entity.basic.helper.DbT7118SogoJigyoShuruiShikyuGendoGakuEntityGenerator.DEFAULT_要介護状態区分;
import static jp.co.ndensan.reams.db.dbc.entity.basic.helper.DbT7118SogoJigyoShuruiShikyuGendoGakuEntityGenerator.DEFAULT_適用開始年月;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.db.dbz.testhelper.DbcTestDacBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
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
 * {@link DbT7118SogoJigyoShuruiShikyuGendoGakuDac}のテストです。
 */
@RunWith(Enclosed.class)
public class DbT7118SogoJigyoShuruiShikyuGendoGakuDacTest extends DbcTestDacBase {

    private static final RString キー_01 = new RString("01");
    private static final RString キー_02 = new RString("02");
    private static final RString キー_03 = new RString("03");
    private static DbT7118SogoJigyoShuruiShikyuGendoGakuDac sut;

    @BeforeClass
    public static void setUpClass() {
        sut = InstanceProvider.create(DbT7118SogoJigyoShuruiShikyuGendoGakuDac.class);
    }

    public static class selectByKeyのテスト extends DbcTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_サービス種類コード,
                    DEFAULT_要介護状態区分,
                    DEFAULT_適用開始年月,
                    DEFAULT_履歴番号);
            TestSupport.insert(
                    DEFAULT_サービス種類コード,
                    DEFAULT_要介護状態区分,
                    DEFAULT_適用開始年月,
                    DEFAULT_履歴番号);
        }

        @Test(expected = NullPointerException.class)
        public void サービス種類コードがnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_サービス種類コード,
                    DEFAULT_要介護状態区分,
                    DEFAULT_適用開始年月,
                    DEFAULT_履歴番号);
        }

        @Test(expected = NullPointerException.class)
        public void 要介護状態区分がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_サービス種類コード,
                    DEFAULT_要介護状態区分,
                    DEFAULT_適用開始年月,
                    DEFAULT_履歴番号);
        }

        @Test(expected = NullPointerException.class)
        public void 適用開始年月がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_サービス種類コード,
                    DEFAULT_要介護状態区分,
                    DEFAULT_適用開始年月,
                    DEFAULT_履歴番号);
        }

        @Test(expected = NullPointerException.class)
        public void 履歴番号がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_サービス種類コード,
                    DEFAULT_要介護状態区分,
                    DEFAULT_適用開始年月,
                    DEFAULT_履歴番号);
        }

        @Test
        public void 存在する主キーを渡すと_selectByKeyは_該当のエンティティを返す() {
            DbT7118SogoJigyoShuruiShikyuGendoGakuEntity insertedRecord = sut.selectByKey(
                    DEFAULT_サービス種類コード,
                    DEFAULT_要介護状態区分,
                    DEFAULT_適用開始年月,
                    DEFAULT_履歴番号);
            assertThat(insertedRecord, is(notNullValue()));
        }

        @Test
        public void 存在しない主キーを渡すと_selectByKeyは_nullを返す() {
            DbT7118SogoJigyoShuruiShikyuGendoGakuEntity insertedRecord = sut.selectByKey(
                    DEFAULT_サービス種類コード,
                    DEFAULT_要介護状態区分,
                    DEFAULT_適用開始年月,
                    DEFAULT_履歴番号);
            assertThat(insertedRecord, is(nullValue()));
        }
    }

    public static class selectAllのテスト extends DbcTestDacBase {

        @Test
        public void 介護予防_日常生活支援総合事業種類支給限度額が存在する場合_selectAllは_全件を返す() {
            TestSupport.insert(
                    DEFAULT_サービス種類コード,
                    DEFAULT_要介護状態区分,
                    DEFAULT_適用開始年月,
                    DEFAULT_履歴番号);
            TestSupport.insert(
                    DEFAULT_サービス種類コード,
                    DEFAULT_要介護状態区分,
                    DEFAULT_適用開始年月,
                    DEFAULT_履歴番号);
            assertThat(sut.selectAll().size(), is(2));
        }

        @Test
        public void 介護予防_日常生活支援総合事業種類支給限度額が存在しない場合_selectAllは_空のリストを返す() {
            assertThat(sut.selectAll(), is(Collections.EMPTY_LIST));
        }
    }

    public static class insertのテスト extends DbcTestDacBase {

        @Test
        public void 介護予防_日常生活支援総合事業種類支給限度額エンティティを渡すと_insertは_介護予防_日常生活支援総合事業種類支給限度額を追加する() {
            TestSupport.insert(
                    DEFAULT_サービス種類コード,
                    DEFAULT_要介護状態区分,
                    DEFAULT_適用開始年月,
                    DEFAULT_履歴番号);

            assertThat(sut.selectByKey(
                    DEFAULT_サービス種類コード,
                    DEFAULT_要介護状態区分,
                    DEFAULT_適用開始年月,
                    DEFAULT_履歴番号), is(notNullValue()));
        }
    }

    public static class updateのテスト extends DbcTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_サービス種類コード,
                    DEFAULT_要介護状態区分,
                    DEFAULT_適用開始年月,
                    DEFAULT_履歴番号);
        }

        @Test
        public void 介護予防_日常生活支援総合事業種類支給限度額エンティティを渡すと_updateは_介護予防_日常生活支援総合事業種類支給限度額を更新する() {
            DbT7118SogoJigyoShuruiShikyuGendoGakuEntity updateRecord = sut.selectByKey(
                    DEFAULT_サービス種類コード,
                    DEFAULT_要介護状態区分,
                    DEFAULT_適用開始年月,
                    DEFAULT_履歴番号);
            // TODO  主キー以外の項目を変更してください
            // updateRecord.set変更したい項目(75);

            sut.save(updateRecord);

            DbT7118SogoJigyoShuruiShikyuGendoGakuEntity updatedRecord = sut.selectByKey(
                    DEFAULT_サービス種類コード,
                    DEFAULT_要介護状態区分,
                    DEFAULT_適用開始年月,
                    DEFAULT_履歴番号);

            // TODO  主キー以外の項目を変更してください
            // assertThat(updateRecord.get変更したい項目(), is(updatedRecord.get変更したい項目()));
        }
    }

    public static class deleteのテスト extends DbcTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_サービス種類コード,
                    DEFAULT_要介護状態区分,
                    DEFAULT_適用開始年月,
                    DEFAULT_履歴番号);
        }

        @Test
        public void 介護予防_日常生活支援総合事業種類支給限度額エンティティを渡すと_deleteは_介護予防_日常生活支援総合事業種類支給限度額を削除する() {
            DbT7118SogoJigyoShuruiShikyuGendoGakuEntity deletedEntity = sut.selectByKey(
                    DEFAULT_サービス種類コード,
                    DEFAULT_要介護状態区分,
                    DEFAULT_適用開始年月,
                    DEFAULT_履歴番号);
            deletedEntity.setState(EntityDataState.Deleted);

            sut.save(deletedEntity);

            assertThat(sut.selectByKey(
                    DEFAULT_サービス種類コード,
                    DEFAULT_要介護状態区分,
                    DEFAULT_適用開始年月,
                    DEFAULT_履歴番号), is(nullValue()));
        }
    }

    private static class TestSupport {

        public static void insert(
                ServiceShuruiCode サービス種類コード,
                RString 要介護状態区分,
                FlexibleYearMonth 適用開始年月,
                int 履歴番号) {
            DbT7118SogoJigyoShuruiShikyuGendoGakuEntity entity = DbT7118SogoJigyoShuruiShikyuGendoGakuEntityGenerator.createDbT7118SogoJigyoShuruiShikyuGendoGakuEntity();
            entity.setServiceShuruiCode(サービス種類コード);
            entity.setYoKaigoJotaiKubun(要介護状態区分);
            entity.setTekiyoKaishiYM(適用開始年月);
            entity.setRirekiNo(履歴番号);
            sut.save(entity);
        }
    }
}
