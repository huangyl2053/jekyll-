/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.service.core.view;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.business.core.view.KyufujissekiShuruiDetail;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbV3016KyufujissekiShuruiDetailEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbV3016KyufujissekiShuruiDetailEntityGenerator;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbV3016KyufujissekiShuruiDetailDac;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * {link KyufujissekiShuruiDetailManager}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class KyufujissekiShuruiDetailManagerTest {

    private static DbV3016KyufujissekiShuruiDetailDac dac;
    private static KyufujissekiShuruiDetailManager sut;

    @BeforeClass
    public static void test() {
        dac = mock(DbV3016KyufujissekiShuruiDetailDac.class);
        sut = new KyufujissekiShuruiDetailManager(dac);
    }

    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
    public static class get給付実績種類詳細 extends DbzTestBase {

        ShikibetsuCode 交換情報識別番号 = DbV3016KyufujissekiShuruiDetailEntityGenerator.DEFAULT_交換情報識別番号;
        ShikibetsuCode 入力識別番号 = DbV3016KyufujissekiShuruiDetailEntityGenerator.DEFAULT_入力識別番号;
        RString レコード種別コード = DbV3016KyufujissekiShuruiDetailEntityGenerator.DEFAULT_レコード種別コード;
        HokenshaNo 証記載保険者番号 = DbV3016KyufujissekiShuruiDetailEntityGenerator.DEFAULT_証記載保険者番号;
        HihokenshaNo 被保険者番号 = DbV3016KyufujissekiShuruiDetailEntityGenerator.DEFAULT_被保険者番号;
        FlexibleYearMonth サービス提供年月 = DbV3016KyufujissekiShuruiDetailEntityGenerator.DEFAULT_サービス提供年月;
        JigyoshaNo 事業所番号 = DbV3016KyufujissekiShuruiDetailEntityGenerator.DEFAULT_事業所番号;
        RString 通し番号 = DbV3016KyufujissekiShuruiDetailEntityGenerator.DEFAULT_通し番号;

        // TODO メソッドの引数の数に合わせて、NullPointerExceptionのテストケースを増減してください。
        @Test(expected = NullPointerException.class)
        public void 引数の主キー型1にnullを指定した場合_NullPointerExceptionが発生する() {
            sut.get給付実績種類詳細(null, 入力識別番号, レコード種別コード, 証記載保険者番号, 被保険者番号, サービス提供年月, 事業所番号, 通し番号);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の主キー型2にnullを指定した場合_NullPointerExceptionが発生する() {
            sut.get給付実績種類詳細(交換情報識別番号, null, レコード種別コード, 証記載保険者番号, 被保険者番号, サービス提供年月, 事業所番号, 通し番号);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の主キー型3にnullを指定した場合_NullPointerExceptionが発生する() {
            sut.get給付実績種類詳細(交換情報識別番号, 入力識別番号, null, 証記載保険者番号, 被保険者番号, サービス提供年月, 事業所番号, 通し番号);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の主キー型4にnullを指定した場合_NullPointerExceptionが発生する() {
            sut.get給付実績種類詳細(交換情報識別番号, 入力識別番号, レコード種別コード, null, 被保険者番号, サービス提供年月, 事業所番号, 通し番号);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の主キー型5にnullを指定した場合_NullPointerExceptionが発生する() {
            sut.get給付実績種類詳細(交換情報識別番号, 入力識別番号, レコード種別コード, 証記載保険者番号, null, サービス提供年月, 事業所番号, 通し番号);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の主キー型6にnullを指定した場合_NullPointerExceptionが発生する() {
            sut.get給付実績種類詳細(交換情報識別番号, 入力識別番号, レコード種別コード, 証記載保険者番号, 被保険者番号, null, 事業所番号, 通し番号);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の主キー型7にnullを指定した場合_NullPointerExceptionが発生する() {
            sut.get給付実績種類詳細(交換情報識別番号, 入力識別番号, レコード種別コード, 証記載保険者番号, 被保険者番号, サービス提供年月, null, 通し番号);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の主キー型8にnullを指定した場合_NullPointerExceptionが発生する() {
            sut.get給付実績種類詳細(交換情報識別番号, 入力識別番号, レコード種別コード, 証記載保険者番号, 被保険者番号, サービス提供年月, 事業所番号, null);
        }

        // TODO メソッドの引数の数に合わせて、mock処理とメソッド呼び出しを見直してください。
        @Test
        public void 検索結果がnullの場合() {
            when(dac.selectByKey(any(ShikibetsuCode.class), any(ShikibetsuCode.class), any(RString.class),
                    any(HokenshaNo.class), any(HihokenshaNo.class), any(FlexibleYearMonth.class), any(JigyoshaNo.class), any(RString.class))).thenReturn(null);

            KyufujissekiShuruiDetail result = sut.get給付実績種類詳細(交換情報識別番号, 入力識別番号, レコード種別コード, 証記載保険者番号, 被保険者番号, サービス提供年月, 事業所番号, 通し番号);

            assertThat(result, is(nullValue()));
        }

        @Test
        public void 検索結果が存在する場合() {
            DbV3016KyufujissekiShuruiDetailEntity entity = DbV3016KyufujissekiShuruiDetailEntityGenerator.createDbV3016KyufujissekiShuruiDetailEntity();
            when(dac.selectByKey(any(ShikibetsuCode.class), any(ShikibetsuCode.class), any(RString.class), any(HokenshaNo.class), any(HihokenshaNo.class), any(FlexibleYearMonth.class), any(JigyoshaNo.class), any(RString.class))).thenReturn(entity);

            KyufujissekiShuruiDetail result = sut.get給付実績種類詳細(交換情報識別番号, 入力識別番号, レコード種別コード, 証記載保険者番号, 被保険者番号, サービス提供年月, 事業所番号, 通し番号);

            assertThat(result.get交換情報識別番号().value(), is(DbV3016KyufujissekiShuruiDetailEntityGenerator.DEFAULT_交換情報識別番号.value()));
        }
    }

    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
    public static class get給付実績種類詳細一覧 extends DbzTestBase {

        @Test
        public void 検索結果が空の場合() {
            when(dac.selectAll()).thenReturn(Collections.EMPTY_LIST);

            List<KyufujissekiShuruiDetail> result = sut.get給付実績種類詳細一覧();

            assertThat(result.isEmpty(), is(true));
        }

        @Test
        public void 検索結果が存在する場合() {
            List<DbV3016KyufujissekiShuruiDetailEntity> entityList = Arrays.asList(DbV3016KyufujissekiShuruiDetailEntityGenerator.createDbV3016KyufujissekiShuruiDetailEntity());
            when(dac.selectAll()).thenReturn(entityList);

            List<KyufujissekiShuruiDetail> result = sut.get給付実績種類詳細一覧();

            assertThat(result.size(), is(1));
            assertThat(result.get(0).get交換情報識別番号().value(), is(DbV3016KyufujissekiShuruiDetailEntityGenerator.DEFAULT_交換情報識別番号.value()));
        }
    }

    public static class save給付実績種類詳細 extends DbzTestBase {

        @Test
        public void insertに成功するとtrueが返る() {
            when(dac.save(any(DbV3016KyufujissekiShuruiDetailEntity.class))).thenReturn(1);

            DbV3016KyufujissekiShuruiDetailEntity entity = DbV3016KyufujissekiShuruiDetailEntityGenerator.createDbV3016KyufujissekiShuruiDetailEntity();
            KyufujissekiShuruiDetail 給付実績種類詳細 = new KyufujissekiShuruiDetail(entity);

            assertThat(sut.save給付実績種類詳細(給付実績種類詳細), is(true));
        }

        @Test
        public void insertに失敗するとfalseが返る() {
            when(dac.save(any(DbV3016KyufujissekiShuruiDetailEntity.class))).thenReturn(0);

            DbV3016KyufujissekiShuruiDetailEntity entity = DbV3016KyufujissekiShuruiDetailEntityGenerator.createDbV3016KyufujissekiShuruiDetailEntity();
            KyufujissekiShuruiDetail 給付実績種類詳細 = new KyufujissekiShuruiDetail(entity);

            assertThat(sut.save給付実績種類詳細(給付実績種類詳細), is(false));
        }

        @Test
        public void updateに成功するとtrueが返る() {
            when(dac.save(any(DbV3016KyufujissekiShuruiDetailEntity.class))).thenReturn(1);

            DbV3016KyufujissekiShuruiDetailEntity entity = DbV3016KyufujissekiShuruiDetailEntityGenerator.createDbV3016KyufujissekiShuruiDetailEntity();
            entity.initializeMd5();
            KyufujissekiShuruiDetail 給付実績種類詳細 = new KyufujissekiShuruiDetail(entity);
            給付実績種類詳細 = 給付実績種類詳細.createBuilderForEdit().set通し番号(new RString("通し番号を変更")).build();

            assertThat(sut.save給付実績種類詳細(給付実績種類詳細), is(true));
        }

        @Test
        public void updateに失敗するとfalseが返る() {
            when(dac.save(any(DbV3016KyufujissekiShuruiDetailEntity.class))).thenReturn(0);

            DbV3016KyufujissekiShuruiDetailEntity entity = DbV3016KyufujissekiShuruiDetailEntityGenerator.createDbV3016KyufujissekiShuruiDetailEntity();
            entity.initializeMd5();
            KyufujissekiShuruiDetail 給付実績種類詳細 = new KyufujissekiShuruiDetail(entity);
            給付実績種類詳細 = 給付実績種類詳細.createBuilderForEdit().set通し番号(new RString("通し番号を変更")).build();

            assertThat(sut.save給付実績種類詳細(給付実績種類詳細), is(false));
        }

        @Test
        public void deleteに成功するとtrueが返る() {
            when(dac.save(any(DbV3016KyufujissekiShuruiDetailEntity.class))).thenReturn(1);

            DbV3016KyufujissekiShuruiDetailEntity entity = DbV3016KyufujissekiShuruiDetailEntityGenerator.createDbV3016KyufujissekiShuruiDetailEntity();
            entity.initializeMd5();
            KyufujissekiShuruiDetail 給付実績種類詳細 = new KyufujissekiShuruiDetail(entity);
            給付実績種類詳細 = 給付実績種類詳細.deleted();

            assertThat(sut.save給付実績種類詳細(給付実績種類詳細), is(true));
        }

        @Test
        public void deleteに失敗するとfalseが返る() {
            when(dac.save(any(DbV3016KyufujissekiShuruiDetailEntity.class))).thenReturn(0);

            DbV3016KyufujissekiShuruiDetailEntity entity = DbV3016KyufujissekiShuruiDetailEntityGenerator.createDbV3016KyufujissekiShuruiDetailEntity();
            entity.initializeMd5();
            KyufujissekiShuruiDetail 給付実績種類詳細 = new KyufujissekiShuruiDetail(entity);
            給付実績種類詳細 = 給付実績種類詳細.deleted();

            assertThat(sut.save給付実績種類詳細(給付実績種類詳細), is(false));
        }

        public void 何も変更せずにsaveを呼び出すとfalseが返る() {
            DbV3016KyufujissekiShuruiDetailEntity entity = DbV3016KyufujissekiShuruiDetailEntityGenerator.createDbV3016KyufujissekiShuruiDetailEntity();
            entity.initializeMd5();
            KyufujissekiShuruiDetail 給付実績種類詳細 = new KyufujissekiShuruiDetail(entity);

            assertThat(sut.save給付実績種類詳細(給付実績種類詳細), is(false));
        }
    }
}
