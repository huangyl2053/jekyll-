/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.service.core.view;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.business.core.view.KyufujissekiKihonAlive;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbV3017KyufujissekiKihonEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbV3017KyufujissekiKihonEntityGenerator;
import jp.co.ndensan.reams.db.dbz.persistence.basic.DbV3017KyufujissekiKihonAliveDac;
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
 * {link KyufujissekiKihonAliveManager}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class KyufujissekiKihonAliveManagerTest {

    private static DbV3017KyufujissekiKihonAliveDac dac;
    private static KyufujissekiKihonAliveManager sut;

    @BeforeClass
    public static void test() {
        dac = mock(DbV3017KyufujissekiKihonAliveDac.class);
        sut = new KyufujissekiKihonAliveManager(dac);
    }

    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
    public static class get給付実績基本Alive extends DbzTestBase {

        ShikibetsuCode 交換情報識別番号 = DbV3017KyufujissekiKihonEntityGenerator.DEFAULT_交換情報識別番号;
        ShikibetsuCode 入力識別番号 = DbV3017KyufujissekiKihonEntityGenerator.DEFAULT_入力識別番号;
        RString レコード種別コード = DbV3017KyufujissekiKihonEntityGenerator.DEFAULT_レコード種別コード;
        HokenshaNo 証記載保険者番号 = DbV3017KyufujissekiKihonEntityGenerator.DEFAULT_証記載保険者番号;
        HihokenshaNo 被保険者番号 = DbV3017KyufujissekiKihonEntityGenerator.DEFAULT_被保険者番号;
        FlexibleYearMonth サービス提供年月 = DbV3017KyufujissekiKihonEntityGenerator.DEFAULT_サービス提供年月;
        JigyoshaNo 事業所番号 = DbV3017KyufujissekiKihonEntityGenerator.DEFAULT_事業所番号;
        RString 給付実績情報作成区分コード = DbV3017KyufujissekiKihonEntityGenerator.DEFAULT_給付実績情報作成区分コード;
        RString 給付実績区分コード = DbV3017KyufujissekiKihonEntityGenerator.DEFAULT_給付実績区分コード;
        RString 通し番号 = DbV3017KyufujissekiKihonEntityGenerator.DEFAULT_通し番号;

        // TODO メソッドの引数の数に合わせて、NullPointerExceptionのテストケースを増減してください。
        @Test(expected = NullPointerException.class)
        public void 引数の主キー型1にnullを指定した場合_NullPointerExceptionが発生する() {
            sut.get給付実績基本Alive(null, 入力識別番号, レコード種別コード, 証記載保険者番号, 被保険者番号, サービス提供年月, 事業所番号, 給付実績情報作成区分コード, 給付実績区分コード, 通し番号);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の主キー型2にnullを指定した場合_NullPointerExceptionが発生する() {
            sut.get給付実績基本Alive(交換情報識別番号, null, レコード種別コード, 証記載保険者番号, 被保険者番号, サービス提供年月, 事業所番号, 給付実績情報作成区分コード, 給付実績区分コード, 通し番号);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の主キー型3にnullを指定した場合_NullPointerExceptionが発生する() {
            sut.get給付実績基本Alive(交換情報識別番号, 入力識別番号, null, 証記載保険者番号, 被保険者番号, サービス提供年月, 事業所番号, 給付実績情報作成区分コード, 給付実績区分コード, 通し番号);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の主キー型4にnullを指定した場合_NullPointerExceptionが発生する() {
            sut.get給付実績基本Alive(交換情報識別番号, 入力識別番号, レコード種別コード, null, 被保険者番号, サービス提供年月, 事業所番号, 給付実績情報作成区分コード, 給付実績区分コード, 通し番号);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の主キー型5にnullを指定した場合_NullPointerExceptionが発生する() {
            sut.get給付実績基本Alive(交換情報識別番号, 入力識別番号, レコード種別コード, 証記載保険者番号, null, サービス提供年月, 事業所番号, 給付実績情報作成区分コード, 給付実績区分コード, 通し番号);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の主キー型6にnullを指定した場合_NullPointerExceptionが発生する() {
            sut.get給付実績基本Alive(交換情報識別番号, 入力識別番号, レコード種別コード, 証記載保険者番号, 被保険者番号, null, 事業所番号, 給付実績情報作成区分コード, 給付実績区分コード, 通し番号);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の主キー型7にnullを指定した場合_NullPointerExceptionが発生する() {
            sut.get給付実績基本Alive(交換情報識別番号, 入力識別番号, レコード種別コード, 証記載保険者番号, 被保険者番号, サービス提供年月, null, 給付実績情報作成区分コード, 給付実績区分コード, 通し番号);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の主キー型8にnullを指定した場合_NullPointerExceptionが発生する() {
            sut.get給付実績基本Alive(交換情報識別番号, 入力識別番号, レコード種別コード, 証記載保険者番号, 被保険者番号, サービス提供年月, 事業所番号, null, 給付実績区分コード, 通し番号);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の主キー型9にnullを指定した場合_NullPointerExceptionが発生する() {
            sut.get給付実績基本Alive(交換情報識別番号, 入力識別番号, レコード種別コード, 証記載保険者番号, 被保険者番号, サービス提供年月, 事業所番号, 給付実績区分コード, null, 通し番号);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の主キー型10にnullを指定した場合_NullPointerExceptionが発生する() {
            sut.get給付実績基本Alive(交換情報識別番号, 入力識別番号, レコード種別コード, 証記載保険者番号, 被保険者番号, サービス提供年月, 事業所番号, 給付実績情報作成区分コード, 給付実績区分コード, null);
        }

        // TODO メソッドの引数の数に合わせて、mock処理とメソッド呼び出しを見直してください。
        @Test
        public void 検索結果がnullの場合() {
            when(dac.selectByKey(any(ShikibetsuCode.class), any(ShikibetsuCode.class), any(RString.class), any(HokenshaNo.class), any(HihokenshaNo.class), any(FlexibleYearMonth.class), any(JigyoshaNo.class), any(RString.class), any(RString.class), any(RString.class))).thenReturn(null);

            KyufujissekiKihonAlive result = sut.get給付実績基本Alive(交換情報識別番号, 入力識別番号, レコード種別コード, 証記載保険者番号, 被保険者番号, サービス提供年月, 事業所番号, 給付実績情報作成区分コード, 給付実績区分コード, 通し番号);

            assertThat(result, is(nullValue()));
        }

        @Test
        public void 検索結果が存在する場合() {
            DbV3017KyufujissekiKihonEntity entity = DbV3017KyufujissekiKihonEntityGenerator.createDbV3017KyufujissekiKihonEntity();
            when(dac.selectByKey(any(ShikibetsuCode.class), any(ShikibetsuCode.class), any(RString.class), any(HokenshaNo.class), any(HihokenshaNo.class), any(FlexibleYearMonth.class), any(JigyoshaNo.class), any(RString.class), any(RString.class), any(RString.class))).thenReturn(entity);

            KyufujissekiKihonAlive result = sut.get給付実績基本Alive(交換情報識別番号, 入力識別番号, レコード種別コード, 証記載保険者番号, 被保険者番号, サービス提供年月, 事業所番号, 給付実績情報作成区分コード, 給付実績区分コード, 通し番号);

            assertThat(result.get交換情報識別番号().value(), is(DbV3017KyufujissekiKihonEntityGenerator.DEFAULT_交換情報識別番号.value()));
        }
    }

    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
    public static class get給付実績基本Alive一覧 extends DbzTestBase {

        @Test
        public void 検索結果が空の場合() {
            when(dac.selectAll()).thenReturn(Collections.EMPTY_LIST);

            List<KyufujissekiKihonAlive> result = sut.get給付実績基本Alive一覧();

            assertThat(result.isEmpty(), is(true));
        }

        @Test
        public void 検索結果が存在する場合() {
            List<DbV3017KyufujissekiKihonEntity> entityList = Arrays.asList(DbV3017KyufujissekiKihonEntityGenerator.createDbV3017KyufujissekiKihonEntity());
            when(dac.selectAll()).thenReturn(entityList);

            List<KyufujissekiKihonAlive> result = sut.get給付実績基本Alive一覧();

            assertThat(result.size(), is(1));
            assertThat(result.get(0).get交換情報識別番号().value(), is(DbV3017KyufujissekiKihonEntityGenerator.DEFAULT_交換情報識別番号.value()));
        }
    }

    public static class save給付実績基本Alive extends DbzTestBase {

        @Test
        public void insertに成功するとtrueが返る() {
            when(dac.save(any(DbV3017KyufujissekiKihonEntity.class))).thenReturn(1);

            DbV3017KyufujissekiKihonEntity entity = DbV3017KyufujissekiKihonEntityGenerator.createDbV3017KyufujissekiKihonEntity();
            KyufujissekiKihonAlive 給付実績基本Alive = new KyufujissekiKihonAlive(entity);

            assertThat(sut.save給付実績基本Alive(給付実績基本Alive), is(true));
        }

        @Test
        public void insertに失敗するとfalseが返る() {
            when(dac.save(any(DbV3017KyufujissekiKihonEntity.class))).thenReturn(0);

            DbV3017KyufujissekiKihonEntity entity = DbV3017KyufujissekiKihonEntityGenerator.createDbV3017KyufujissekiKihonEntity();
            KyufujissekiKihonAlive 給付実績基本Alive = new KyufujissekiKihonAlive(entity);

            assertThat(sut.save給付実績基本Alive(給付実績基本Alive), is(false));
        }

        @Test
        public void updateに成功するとtrueが返る() {
            when(dac.save(any(DbV3017KyufujissekiKihonEntity.class))).thenReturn(1);

            DbV3017KyufujissekiKihonEntity entity = DbV3017KyufujissekiKihonEntityGenerator.createDbV3017KyufujissekiKihonEntity();
            entity.initializeMd5();
            KyufujissekiKihonAlive 給付実績基本Alive = new KyufujissekiKihonAlive(entity);
            給付実績基本Alive = 給付実績基本Alive.createBuilderForEdit().set通し番号(new RString("通し番号を変更")).build();

            assertThat(sut.save給付実績基本Alive(給付実績基本Alive), is(true));
        }

        @Test
        public void updateに失敗するとfalseが返る() {
            when(dac.save(any(DbV3017KyufujissekiKihonEntity.class))).thenReturn(0);

            DbV3017KyufujissekiKihonEntity entity = DbV3017KyufujissekiKihonEntityGenerator.createDbV3017KyufujissekiKihonEntity();
            entity.initializeMd5();
            KyufujissekiKihonAlive 給付実績基本Alive = new KyufujissekiKihonAlive(entity);
            給付実績基本Alive = 給付実績基本Alive.createBuilderForEdit().set通し番号(new RString("通し番号を変更")).build();

            assertThat(sut.save給付実績基本Alive(給付実績基本Alive), is(false));
        }

        @Test
        public void deleteに成功するとtrueが返る() {
            when(dac.save(any(DbV3017KyufujissekiKihonEntity.class))).thenReturn(1);

            DbV3017KyufujissekiKihonEntity entity = DbV3017KyufujissekiKihonEntityGenerator.createDbV3017KyufujissekiKihonEntity();
            entity.initializeMd5();
            KyufujissekiKihonAlive 給付実績基本Alive = new KyufujissekiKihonAlive(entity);
            給付実績基本Alive = 給付実績基本Alive.deleted();

            assertThat(sut.save給付実績基本Alive(給付実績基本Alive), is(true));
        }

        @Test
        public void deleteに失敗するとfalseが返る() {
            when(dac.save(any(DbV3017KyufujissekiKihonEntity.class))).thenReturn(0);

            DbV3017KyufujissekiKihonEntity entity = DbV3017KyufujissekiKihonEntityGenerator.createDbV3017KyufujissekiKihonEntity();
            entity.initializeMd5();
            KyufujissekiKihonAlive 給付実績基本Alive = new KyufujissekiKihonAlive(entity);
            給付実績基本Alive = 給付実績基本Alive.deleted();

            assertThat(sut.save給付実績基本Alive(給付実績基本Alive), is(false));
        }

        public void 何も変更せずにsaveを呼び出すとfalseが返る() {
            DbV3017KyufujissekiKihonEntity entity = DbV3017KyufujissekiKihonEntityGenerator.createDbV3017KyufujissekiKihonEntity();
            entity.initializeMd5();
            KyufujissekiKihonAlive 給付実績基本Alive = new KyufujissekiKihonAlive(entity);

            assertThat(sut.save給付実績基本Alive(給付実績基本Alive), is(false));
        }
    }
}
