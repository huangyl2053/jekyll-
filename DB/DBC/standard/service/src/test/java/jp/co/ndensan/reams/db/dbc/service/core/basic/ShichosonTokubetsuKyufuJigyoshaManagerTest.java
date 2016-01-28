/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.basic;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShichosonTokubetsuKyufuJigyosha;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3065ShichosonTokubetsuKyufuJigyoshaEntity;
import jp.co.ndensan.reams.db.dbc.entity.basic.helper.DbT3065ShichosonTokubetsuKyufuJigyoshaEntityGenerator;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3065ShichosonTokubetsuKyufuJigyoshaDac;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceCode;
import jp.co.ndensan.reams.db.dbz.testhelper.DbcTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import org.junit.Test;
import org.junit.Ignore;
import static org.junit.Assert.*;
import org.junit.BeforeClass;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * {link ShichosonTokubetsuKyufuJigyoshaManager}のテストクラスです。
 */
@RunWith(Enclosed.class)
@Ignore
public class ShichosonTokubetsuKyufuJigyoshaManagerTest {

    private static DbT3065ShichosonTokubetsuKyufuJigyoshaDac dac;
    private static ShichosonTokubetsuKyufuJigyoshaManager sut;

    @BeforeClass
    public static void test() {
        dac = mock(DbT3065ShichosonTokubetsuKyufuJigyoshaDac.class);
        sut = new ShichosonTokubetsuKyufuJigyoshaManager(dac);
    }

    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
    public static class get市町村特別給付サービス事業者 extends DbcTestBase {

        // TODO メソッドの引数の数に合わせて、NullPointerExceptionのテストケースを増減してください。
        @Test(expected = NullPointerException.class)
        public void 引数の主キー型1にnullを指定した場合_NullPointerExceptionが発生する() {
            ServiceCode 主キー2 = DbT3065ShichosonTokubetsuKyufuJigyoshaEntityGenerator.DEFAULT_市町村特別給付用サービスコード;
            int 主キー3 = DbT3065ShichosonTokubetsuKyufuJigyoshaEntityGenerator.DEFAULT_履歴番号;
            sut.get市町村特別給付サービス事業者(null, 主キー2, 主キー3);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の主キー型2にnullを指定した場合_NullPointerExceptionが発生する() {
            JigyoshaNo 主キー1 = DbT3065ShichosonTokubetsuKyufuJigyoshaEntityGenerator.DEFAULT_市町村特別給付用事業者番号;
            int 主キー3 = DbT3065ShichosonTokubetsuKyufuJigyoshaEntityGenerator.DEFAULT_履歴番号;
            sut.get市町村特別給付サービス事業者(主キー1, null, 主キー3);
        }

        @Ignore //主キー3はintになったため、nullが指定できない。
        @Test(expected = NullPointerException.class)
        public void 引数の主キー型3にnullを指定した場合_NullPointerExceptionが発生する() {
            JigyoshaNo 主キー1 = DbT3065ShichosonTokubetsuKyufuJigyoshaEntityGenerator.DEFAULT_市町村特別給付用事業者番号;
            ServiceCode 主キー2 = DbT3065ShichosonTokubetsuKyufuJigyoshaEntityGenerator.DEFAULT_市町村特別給付用サービスコード;
            //sut.get市町村特別給付サービス事業者(主キー1, 主キー2, null);
        }

        // TODO メソッドの引数の数に合わせて、mock処理とメソッド呼び出しを見直してください。
        @Test
        public void 検索結果がnullの場合() {
            when(dac.selectByKey(any(JigyoshaNo.class), any(ServiceCode.class), any(Integer.class))).thenReturn(null);

            JigyoshaNo 主キー1 = DbT3065ShichosonTokubetsuKyufuJigyoshaEntityGenerator.DEFAULT_市町村特別給付用事業者番号;
            ServiceCode 主キー2 = DbT3065ShichosonTokubetsuKyufuJigyoshaEntityGenerator.DEFAULT_市町村特別給付用サービスコード;
            int 主キー3 = DbT3065ShichosonTokubetsuKyufuJigyoshaEntityGenerator.DEFAULT_履歴番号;
            ShichosonTokubetsuKyufuJigyosha result = sut.get市町村特別給付サービス事業者(主キー1, 主キー2, 主キー3);

            assertThat(result, is(nullValue()));
        }

        @Test
        public void 検索結果が存在する場合() {
            DbT3065ShichosonTokubetsuKyufuJigyoshaEntity entity = DbT3065ShichosonTokubetsuKyufuJigyoshaEntityGenerator.createDbT3065ShichosonTokubetsuKyufuJigyoshaEntity();
            when(dac.selectByKey(any(JigyoshaNo.class), any(ServiceCode.class), any(Integer.class))).thenReturn(entity);

            JigyoshaNo 主キー1 = DbT3065ShichosonTokubetsuKyufuJigyoshaEntityGenerator.DEFAULT_市町村特別給付用事業者番号;
            ServiceCode 主キー2 = DbT3065ShichosonTokubetsuKyufuJigyoshaEntityGenerator.DEFAULT_市町村特別給付用サービスコード;
            int 主キー3 = DbT3065ShichosonTokubetsuKyufuJigyoshaEntityGenerator.DEFAULT_履歴番号;
            ShichosonTokubetsuKyufuJigyosha result = sut.get市町村特別給付サービス事業者(主キー1, 主キー2, 主キー3);

            assertThat(result.get市町村特別給付用事業者番号().value(), is(DbT3065ShichosonTokubetsuKyufuJigyoshaEntityGenerator.DEFAULT_市町村特別給付用事業者番号.value()));
        }
    }

    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
    public static class get市町村特別給付サービス事業者一覧 extends DbcTestBase {

        @Test
        public void 検索結果が空の場合() {
            when(dac.selectAll()).thenReturn(Collections.EMPTY_LIST);

            List<ShichosonTokubetsuKyufuJigyosha> result = sut.get市町村特別給付サービス事業者一覧();

            assertThat(result.isEmpty(), is(true));
        }

        @Test
        public void 検索結果が存在する場合() {
            List<DbT3065ShichosonTokubetsuKyufuJigyoshaEntity> entityList = Arrays.asList(DbT3065ShichosonTokubetsuKyufuJigyoshaEntityGenerator.createDbT3065ShichosonTokubetsuKyufuJigyoshaEntity());
            when(dac.selectAll()).thenReturn(entityList);

            List<ShichosonTokubetsuKyufuJigyosha> result = sut.get市町村特別給付サービス事業者一覧();

            assertThat(result.size(), is(1));
            assertThat(result.get(0).get市町村特別給付用事業者番号().value(), is(DbT3065ShichosonTokubetsuKyufuJigyoshaEntityGenerator.DEFAULT_市町村特別給付用事業者番号.value()));
        }
    }

    public static class save市町村特別給付サービス事業者 extends DbcTestBase {

        @Test
        public void insertに成功するとtrueが返る() {
            when(dac.save(any(DbT3065ShichosonTokubetsuKyufuJigyoshaEntity.class))).thenReturn(1);

            DbT3065ShichosonTokubetsuKyufuJigyoshaEntity entity = DbT3065ShichosonTokubetsuKyufuJigyoshaEntityGenerator.createDbT3065ShichosonTokubetsuKyufuJigyoshaEntity();
            ShichosonTokubetsuKyufuJigyosha 市町村特別給付サービス事業者 = new ShichosonTokubetsuKyufuJigyosha(entity);

            assertThat(sut.save市町村特別給付サービス事業者(市町村特別給付サービス事業者), is(true));
        }

        @Test
        public void insertに失敗するとfalseが返る() {
            when(dac.save(any(DbT3065ShichosonTokubetsuKyufuJigyoshaEntity.class))).thenReturn(0);

            DbT3065ShichosonTokubetsuKyufuJigyoshaEntity entity = DbT3065ShichosonTokubetsuKyufuJigyoshaEntityGenerator.createDbT3065ShichosonTokubetsuKyufuJigyoshaEntity();
            ShichosonTokubetsuKyufuJigyosha 市町村特別給付サービス事業者 = new ShichosonTokubetsuKyufuJigyosha(entity);

            assertThat(sut.save市町村特別給付サービス事業者(市町村特別給付サービス事業者), is(false));
        }

        @Test
        public void updateに成功するとtrueが返る() {
            when(dac.save(any(DbT3065ShichosonTokubetsuKyufuJigyoshaEntity.class))).thenReturn(1);

            DbT3065ShichosonTokubetsuKyufuJigyoshaEntity entity = DbT3065ShichosonTokubetsuKyufuJigyoshaEntityGenerator.createDbT3065ShichosonTokubetsuKyufuJigyoshaEntity();
            entity.initializeMd5();
            ShichosonTokubetsuKyufuJigyosha 市町村特別給付サービス事業者 = new ShichosonTokubetsuKyufuJigyosha(entity);
            市町村特別給付サービス事業者 = 市町村特別給付サービス事業者.createBuilderForEdit().setサービス事業所住所(new RString("任意項目1を変更")).build();

            assertThat(sut.save市町村特別給付サービス事業者(市町村特別給付サービス事業者), is(true));
        }

        @Test
        public void updateに失敗するとfalseが返る() {
            when(dac.save(any(DbT3065ShichosonTokubetsuKyufuJigyoshaEntity.class))).thenReturn(0);

            DbT3065ShichosonTokubetsuKyufuJigyoshaEntity entity = DbT3065ShichosonTokubetsuKyufuJigyoshaEntityGenerator.createDbT3065ShichosonTokubetsuKyufuJigyoshaEntity();
            entity.initializeMd5();
            ShichosonTokubetsuKyufuJigyosha 市町村特別給付サービス事業者 = new ShichosonTokubetsuKyufuJigyosha(entity);
            市町村特別給付サービス事業者 = 市町村特別給付サービス事業者.createBuilderForEdit().setサービス事業所住所(new RString("任意項目1を変更")).build();

            assertThat(sut.save市町村特別給付サービス事業者(市町村特別給付サービス事業者), is(false));
        }

        @Test
        public void deleteに成功するとtrueが返る() {
            when(dac.save(any(DbT3065ShichosonTokubetsuKyufuJigyoshaEntity.class))).thenReturn(1);

            DbT3065ShichosonTokubetsuKyufuJigyoshaEntity entity = DbT3065ShichosonTokubetsuKyufuJigyoshaEntityGenerator.createDbT3065ShichosonTokubetsuKyufuJigyoshaEntity();
            entity.initializeMd5();
            ShichosonTokubetsuKyufuJigyosha 市町村特別給付サービス事業者 = new ShichosonTokubetsuKyufuJigyosha(entity);
            市町村特別給付サービス事業者 = 市町村特別給付サービス事業者.deleted();

            assertThat(sut.save市町村特別給付サービス事業者(市町村特別給付サービス事業者), is(true));
        }

        @Test
        public void deleteに失敗するとfalseが返る() {
            when(dac.save(any(DbT3065ShichosonTokubetsuKyufuJigyoshaEntity.class))).thenReturn(0);

            DbT3065ShichosonTokubetsuKyufuJigyoshaEntity entity = DbT3065ShichosonTokubetsuKyufuJigyoshaEntityGenerator.createDbT3065ShichosonTokubetsuKyufuJigyoshaEntity();
            entity.initializeMd5();
            ShichosonTokubetsuKyufuJigyosha 市町村特別給付サービス事業者 = new ShichosonTokubetsuKyufuJigyosha(entity);
            市町村特別給付サービス事業者 = 市町村特別給付サービス事業者.deleted();

            assertThat(sut.save市町村特別給付サービス事業者(市町村特別給付サービス事業者), is(false));
        }

        public void 何も変更せずにsaveを呼び出すとfalseが返る() {
            DbT3065ShichosonTokubetsuKyufuJigyoshaEntity entity = DbT3065ShichosonTokubetsuKyufuJigyoshaEntityGenerator.createDbT3065ShichosonTokubetsuKyufuJigyoshaEntity();
            entity.initializeMd5();
            ShichosonTokubetsuKyufuJigyosha 市町村特別給付サービス事業者 = new ShichosonTokubetsuKyufuJigyosha(entity);

            assertThat(sut.save市町村特別給付サービス事業者(市町村特別給付サービス事業者), is(false));
        }
    }
}
