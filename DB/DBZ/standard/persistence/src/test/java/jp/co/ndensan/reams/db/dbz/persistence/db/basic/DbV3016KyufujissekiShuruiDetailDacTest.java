/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.db.basic;

import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbV3016KyufujissekiShuruiDetailDac;
import java.util.Collections;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbV3016KyufujissekiShuruiDetailEntity;
import static jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT1006KyokaisoGaitoshaEntityGenerator.DEFAULT_被保険者番号;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbV3016KyufujissekiShuruiDetailEntityGenerator;
import static jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbV3016KyufujissekiShuruiDetailEntityGenerator.DEFAULT_サービス提供年月;
import static jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbV3016KyufujissekiShuruiDetailEntityGenerator.DEFAULT_レコード種別コード;
import static jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbV3016KyufujissekiShuruiDetailEntityGenerator.DEFAULT_事業所番号;
import static jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbV3016KyufujissekiShuruiDetailEntityGenerator.DEFAULT_交換情報識別番号;
import static jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbV3016KyufujissekiShuruiDetailEntityGenerator.DEFAULT_入力識別番号;
import static jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbV3016KyufujissekiShuruiDetailEntityGenerator.DEFAULT_証記載保険者番号;
import static jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbV3016KyufujissekiShuruiDetailEntityGenerator.DEFAULT_通し番号;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestDacBase;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
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
import org.junit.Ignore;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link DbV3016KyufujissekiShuruiDetailDac}のテストです。
 */
@Ignore
@RunWith(Enclosed.class)
public class DbV3016KyufujissekiShuruiDetailDacTest extends DbzTestDacBase {

    private static final RString キー_01 = new RString("01");
    private static final RString キー_02 = new RString("02");
    private static final RString キー_03 = new RString("03");
    private static DbV3016KyufujissekiShuruiDetailDac sut;

    @BeforeClass
    public static void setUpClass() {
        sut = InstanceProvider.create(DbV3016KyufujissekiShuruiDetailDac.class);
    }

    public static class selectByKeyのテスト extends DbzTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_交換情報識別番号,
                    DEFAULT_入力識別番号,
                    DEFAULT_レコード種別コード,
                    DEFAULT_証記載保険者番号,
                    DEFAULT_被保険者番号,
                    DEFAULT_サービス提供年月,
                    DEFAULT_事業所番号,
                    DEFAULT_通し番号);
            TestSupport.insert(
                    DEFAULT_交換情報識別番号,
                    DEFAULT_入力識別番号,
                    DEFAULT_レコード種別コード,
                    DEFAULT_証記載保険者番号,
                    DEFAULT_被保険者番号,
                    DEFAULT_サービス提供年月,
                    DEFAULT_事業所番号,
                    DEFAULT_通し番号);
        }

        @Test(expected = NullPointerException.class)
        public void 交換情報識別番号がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_交換情報識別番号,
                    DEFAULT_入力識別番号,
                    DEFAULT_レコード種別コード,
                    DEFAULT_証記載保険者番号,
                    DEFAULT_被保険者番号,
                    DEFAULT_サービス提供年月,
                    DEFAULT_事業所番号,
                    DEFAULT_通し番号);
        }

        @Test(expected = NullPointerException.class)
        public void 入力識別番号がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_交換情報識別番号,
                    DEFAULT_入力識別番号,
                    DEFAULT_レコード種別コード,
                    DEFAULT_証記載保険者番号,
                    DEFAULT_被保険者番号,
                    DEFAULT_サービス提供年月,
                    DEFAULT_事業所番号,
                    DEFAULT_通し番号);
        }

        @Test(expected = NullPointerException.class)
        public void レコード種別コードがnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_交換情報識別番号,
                    DEFAULT_入力識別番号,
                    DEFAULT_レコード種別コード,
                    DEFAULT_証記載保険者番号,
                    DEFAULT_被保険者番号,
                    DEFAULT_サービス提供年月,
                    DEFAULT_事業所番号,
                    DEFAULT_通し番号);
        }

        @Test(expected = NullPointerException.class)
        public void 証記載保険者番号がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_交換情報識別番号,
                    DEFAULT_入力識別番号,
                    DEFAULT_レコード種別コード,
                    DEFAULT_証記載保険者番号,
                    DEFAULT_被保険者番号,
                    DEFAULT_サービス提供年月,
                    DEFAULT_事業所番号,
                    DEFAULT_通し番号);
        }

        @Test(expected = NullPointerException.class)
        public void 被保険者番号がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_交換情報識別番号,
                    DEFAULT_入力識別番号,
                    DEFAULT_レコード種別コード,
                    DEFAULT_証記載保険者番号,
                    DEFAULT_被保険者番号,
                    DEFAULT_サービス提供年月,
                    DEFAULT_事業所番号,
                    DEFAULT_通し番号);
        }

        @Test(expected = NullPointerException.class)
        public void サービス提供年月がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_交換情報識別番号,
                    DEFAULT_入力識別番号,
                    DEFAULT_レコード種別コード,
                    DEFAULT_証記載保険者番号,
                    DEFAULT_被保険者番号,
                    DEFAULT_サービス提供年月,
                    DEFAULT_事業所番号,
                    DEFAULT_通し番号);
        }

        @Test(expected = NullPointerException.class)
        public void 事業所番号がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_交換情報識別番号,
                    DEFAULT_入力識別番号,
                    DEFAULT_レコード種別コード,
                    DEFAULT_証記載保険者番号,
                    DEFAULT_被保険者番号,
                    DEFAULT_サービス提供年月,
                    DEFAULT_事業所番号,
                    DEFAULT_通し番号);
        }

        @Test(expected = NullPointerException.class)
        public void 通し番号がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_交換情報識別番号,
                    DEFAULT_入力識別番号,
                    DEFAULT_レコード種別コード,
                    DEFAULT_証記載保険者番号,
                    DEFAULT_被保険者番号,
                    DEFAULT_サービス提供年月,
                    DEFAULT_事業所番号,
                    DEFAULT_通し番号);
        }

        @Test
        public void 存在する主キーを渡すと_selectByKeyは_該当のエンティティを返す() {
            DbV3016KyufujissekiShuruiDetailEntity insertedRecord = sut.selectByKey(
                    DEFAULT_交換情報識別番号,
                    DEFAULT_入力識別番号,
                    DEFAULT_レコード種別コード,
                    DEFAULT_証記載保険者番号,
                    DEFAULT_被保険者番号,
                    DEFAULT_サービス提供年月,
                    DEFAULT_事業所番号,
                    DEFAULT_通し番号);
            assertThat(insertedRecord, is(notNullValue()));
        }

        @Test
        public void 存在しない主キーを渡すと_selectByKeyは_nullを返す() {
            DbV3016KyufujissekiShuruiDetailEntity insertedRecord = sut.selectByKey(
                    DEFAULT_交換情報識別番号,
                    DEFAULT_入力識別番号,
                    DEFAULT_レコード種別コード,
                    DEFAULT_証記載保険者番号,
                    DEFAULT_被保険者番号,
                    DEFAULT_サービス提供年月,
                    DEFAULT_事業所番号,
                    DEFAULT_通し番号);
            assertThat(insertedRecord, is(nullValue()));
        }
    }

    public static class selectAllのテスト extends DbzTestDacBase {

        @Test
        public void 給付実績種類詳細が存在する場合_selectAllは_全件を返す() {
            TestSupport.insert(
                    DEFAULT_交換情報識別番号,
                    DEFAULT_入力識別番号,
                    DEFAULT_レコード種別コード,
                    DEFAULT_証記載保険者番号,
                    DEFAULT_被保険者番号,
                    DEFAULT_サービス提供年月,
                    DEFAULT_事業所番号,
                    DEFAULT_通し番号);
            TestSupport.insert(
                    DEFAULT_交換情報識別番号,
                    DEFAULT_入力識別番号,
                    DEFAULT_レコード種別コード,
                    DEFAULT_証記載保険者番号,
                    DEFAULT_被保険者番号,
                    DEFAULT_サービス提供年月,
                    DEFAULT_事業所番号,
                    DEFAULT_通し番号);
            assertThat(sut.selectAll().size(), is(2));
        }

        @Test
        public void 給付実績種類詳細が存在しない場合_selectAllは_空のリストを返す() {
            assertThat(sut.selectAll(), is(Collections.EMPTY_LIST));
        }
    }

    public static class insertのテスト extends DbzTestDacBase {

        @Test
        public void 給付実績種類詳細エンティティを渡すと_insertは_給付実績種類詳細を追加する() {
            TestSupport.insert(
                    DEFAULT_交換情報識別番号,
                    DEFAULT_入力識別番号,
                    DEFAULT_レコード種別コード,
                    DEFAULT_証記載保険者番号,
                    DEFAULT_被保険者番号,
                    DEFAULT_サービス提供年月,
                    DEFAULT_事業所番号,
                    DEFAULT_通し番号);

            assertThat(sut.selectByKey(
                    DEFAULT_交換情報識別番号,
                    DEFAULT_入力識別番号,
                    DEFAULT_レコード種別コード,
                    DEFAULT_証記載保険者番号,
                    DEFAULT_被保険者番号,
                    DEFAULT_サービス提供年月,
                    DEFAULT_事業所番号,
                    DEFAULT_通し番号), is(notNullValue()));
        }
    }

    public static class updateのテスト extends DbzTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_交換情報識別番号,
                    DEFAULT_入力識別番号,
                    DEFAULT_レコード種別コード,
                    DEFAULT_証記載保険者番号,
                    DEFAULT_被保険者番号,
                    DEFAULT_サービス提供年月,
                    DEFAULT_事業所番号,
                    DEFAULT_通し番号);
        }

        @Test
        public void 給付実績種類詳細エンティティを渡すと_updateは_給付実績種類詳細を更新する() {
            DbV3016KyufujissekiShuruiDetailEntity updateRecord = sut.selectByKey(
                    DEFAULT_交換情報識別番号,
                    DEFAULT_入力識別番号,
                    DEFAULT_レコード種別コード,
                    DEFAULT_証記載保険者番号,
                    DEFAULT_被保険者番号,
                    DEFAULT_サービス提供年月,
                    DEFAULT_事業所番号,
                    DEFAULT_通し番号);
            // TODO  主キー以外の項目を変更してください
            // updateRecord.set変更したい項目(75);

            sut.save(updateRecord);

            DbV3016KyufujissekiShuruiDetailEntity updatedRecord = sut.selectByKey(
                    DEFAULT_交換情報識別番号,
                    DEFAULT_入力識別番号,
                    DEFAULT_レコード種別コード,
                    DEFAULT_証記載保険者番号,
                    DEFAULT_被保険者番号,
                    DEFAULT_サービス提供年月,
                    DEFAULT_事業所番号,
                    DEFAULT_通し番号);

            // TODO  主キー以外の項目を変更してください
            // assertThat(updateRecord.get変更したい項目(), is(updatedRecord.get変更したい項目()));
        }
    }

    public static class deleteのテスト extends DbzTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_交換情報識別番号,
                    DEFAULT_入力識別番号,
                    DEFAULT_レコード種別コード,
                    DEFAULT_証記載保険者番号,
                    DEFAULT_被保険者番号,
                    DEFAULT_サービス提供年月,
                    DEFAULT_事業所番号,
                    DEFAULT_通し番号);
        }

        @Test
        public void 給付実績種類詳細エンティティを渡すと_deleteは_給付実績種類詳細を削除する() {
            DbV3016KyufujissekiShuruiDetailEntity deletedEntity = sut.selectByKey(
                    DEFAULT_交換情報識別番号,
                    DEFAULT_入力識別番号,
                    DEFAULT_レコード種別コード,
                    DEFAULT_証記載保険者番号,
                    DEFAULT_被保険者番号,
                    DEFAULT_サービス提供年月,
                    DEFAULT_事業所番号,
                    DEFAULT_通し番号);
            deletedEntity.setState(EntityDataState.Deleted);

            sut.save(deletedEntity);

            assertThat(sut.selectByKey(
                    DEFAULT_交換情報識別番号,
                    DEFAULT_入力識別番号,
                    DEFAULT_レコード種別コード,
                    DEFAULT_証記載保険者番号,
                    DEFAULT_被保険者番号,
                    DEFAULT_サービス提供年月,
                    DEFAULT_事業所番号,
                    DEFAULT_通し番号), is(nullValue()));
        }
    }

    private static class TestSupport {

        public static void insert(
                ShikibetsuCode 交換情報識別番号,
                ShikibetsuCode 入力識別番号,
                RString レコード種別コード,
                HokenshaNo 証記載保険者番号,
                HihokenshaNo 被保険者番号,
                FlexibleYearMonth サービス提供年月,
                JigyoshaNo 事業所番号,
                RString 通し番号) {
            DbV3016KyufujissekiShuruiDetailEntity entity = DbV3016KyufujissekiShuruiDetailEntityGenerator.createDbV3016KyufujissekiShuruiDetailEntity();
            entity.setKokanShikibetsuNo(交換情報識別番号);
            entity.setInputShikibetsuNo(入力識別番号);
            entity.setRecodeShubetsuCode(レコード種別コード);
            entity.setHokenshaNo(証記載保険者番号);
            entity.setHiHokenshaNo(被保険者番号);
            entity.setServiceTeikyoYM(サービス提供年月);
            entity.setJigyoshoNo(事業所番号);
            entity.setToshiNo(通し番号);
            sut.save(entity);
        }
    }
}
