/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.view;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.view.KokuhorenTorikomiJoho;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbV3104KokuhorenTorikomiJohoEntity;
import jp.co.ndensan.reams.db.dbc.entity.basic.helper.DbV3104KokuhorenTorikomiJohoEntityGenerator;
import jp.co.ndensan.reams.db.dbc.persistence.basic.DbV3104KokuhorenTorikomiJohoDac;
import jp.co.ndensan.reams.db.dbz.testhelper.DbcTestBase;
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
 * {link KokuhorenTorikomiJohoManager}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class KokuhorenTorikomiJohoManagerTest {

    private static DbV3104KokuhorenTorikomiJohoDac dac;
    private static KokuhorenTorikomiJohoManager sut;

    @BeforeClass
    public static void test() {
        dac = mock(DbV3104KokuhorenTorikomiJohoDac.class);
        sut = new KokuhorenTorikomiJohoManager(dac);
    }

    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
    public static class get国保連取り込み情報 extends DbcTestBase {

        // TODO メソッドの引数の数に合わせて、NullPointerExceptionのテストケースを増減してください。
        @Test(expected = NullPointerException.class)
        public void 引数の主キー型1にnullを指定した場合_NullPointerExceptionが発生する() {
            RString 交換情報識別番号 = DbV3104KokuhorenTorikomiJohoEntityGenerator.DEFAULT_交換情報識別番号;
            sut.get国保連取り込み情報(null, 交換情報識別番号);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の主キー型2にnullを指定した場合_NullPointerExceptionが発生する() {
            FlexibleYearMonth 処理年月 = DbV3104KokuhorenTorikomiJohoEntityGenerator.DEFAULT_処理年月;
            sut.get国保連取り込み情報(処理年月, null);
        }

        // TODO メソッドの引数の数に合わせて、mock処理とメソッド呼び出しを見直してください。
        @Test
        public void 検索結果がnullの場合() {
            when(dac.selectByKey(any(FlexibleYearMonth.class), any(RString.class))).thenReturn(null);

            FlexibleYearMonth 処理年月 = DbV3104KokuhorenTorikomiJohoEntityGenerator.DEFAULT_処理年月;
            RString 交換情報識別番号 = DbV3104KokuhorenTorikomiJohoEntityGenerator.DEFAULT_交換情報識別番号;
            KokuhorenTorikomiJoho result = sut.get国保連取り込み情報(処理年月, 交換情報識別番号);

            assertThat(result, is(nullValue()));
        }

        @Test
        public void 検索結果が存在する場合() {
            DbV3104KokuhorenTorikomiJohoEntity entity = DbV3104KokuhorenTorikomiJohoEntityGenerator.createDbV3104KokuhorenTorikomiJohoEntity();
            when(dac.selectByKey(any(FlexibleYearMonth.class), any(RString.class))).thenReturn(entity);

            FlexibleYearMonth 処理年月 = DbV3104KokuhorenTorikomiJohoEntityGenerator.DEFAULT_処理年月;
            RString 交換情報識別番号 = DbV3104KokuhorenTorikomiJohoEntityGenerator.DEFAULT_交換情報識別番号;
            KokuhorenTorikomiJoho result = sut.get国保連取り込み情報(処理年月, 交換情報識別番号);

            assertThat(result.get処理年月().toString(), is(DbV3104KokuhorenTorikomiJohoEntityGenerator.DEFAULT_処理年月.toString()));
        }
    }

    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
    public static class get国保連取り込み情報一覧 extends DbcTestBase {

        @Test
        public void 検索結果が空の場合() {
            when(dac.selectAll()).thenReturn(Collections.EMPTY_LIST);

            List<KokuhorenTorikomiJoho> result = sut.get国保連取り込み情報一覧();

            assertThat(result.isEmpty(), is(true));
        }

        @Test
        public void 検索結果が存在する場合() {
            List<DbV3104KokuhorenTorikomiJohoEntity> entityList = Arrays.asList(DbV3104KokuhorenTorikomiJohoEntityGenerator.createDbV3104KokuhorenTorikomiJohoEntity());
            when(dac.selectAll()).thenReturn(entityList);

            List<KokuhorenTorikomiJoho> result = sut.get国保連取り込み情報一覧();

            assertThat(result.size(), is(1));
            assertThat(result.get(0).get処理年月().toString(), is(DbV3104KokuhorenTorikomiJohoEntityGenerator.DEFAULT_処理年月.toString()));
        }
    }

    public static class save国保連取り込み情報 extends DbcTestBase {

        @Test
        public void insertに成功するとtrueが返る() {
            when(dac.save(any(DbV3104KokuhorenTorikomiJohoEntity.class))).thenReturn(1);

            DbV3104KokuhorenTorikomiJohoEntity entity = DbV3104KokuhorenTorikomiJohoEntityGenerator.createDbV3104KokuhorenTorikomiJohoEntity();
            KokuhorenTorikomiJoho 国保連取り込み情報 = new KokuhorenTorikomiJoho(entity);

            assertThat(sut.save国保連取り込み情報(国保連取り込み情報), is(true));
        }

        @Test
        public void insertに失敗するとfalseが返る() {
            when(dac.save(any(DbV3104KokuhorenTorikomiJohoEntity.class))).thenReturn(0);

            DbV3104KokuhorenTorikomiJohoEntity entity = DbV3104KokuhorenTorikomiJohoEntityGenerator.createDbV3104KokuhorenTorikomiJohoEntity();
            KokuhorenTorikomiJoho 国保連取り込み情報 = new KokuhorenTorikomiJoho(entity);

            assertThat(sut.save国保連取り込み情報(国保連取り込み情報), is(false));
        }

        @Test
        public void updateに成功するとtrueが返る() {
            when(dac.save(any(DbV3104KokuhorenTorikomiJohoEntity.class))).thenReturn(1);

            DbV3104KokuhorenTorikomiJohoEntity entity = DbV3104KokuhorenTorikomiJohoEntityGenerator.createDbV3104KokuhorenTorikomiJohoEntity();
            entity.initializeMd5();
            KokuhorenTorikomiJoho 国保連取り込み情報 = new KokuhorenTorikomiJoho(entity);
            国保連取り込み情報 = 国保連取り込み情報.createBuilderForEdit().set交換情報識別番号(new RString("交換情報識別番号を変更")).build();

            assertThat(sut.save国保連取り込み情報(国保連取り込み情報), is(true));
        }

        @Test
        public void updateに失敗するとfalseが返る() {
            when(dac.save(any(DbV3104KokuhorenTorikomiJohoEntity.class))).thenReturn(0);

            DbV3104KokuhorenTorikomiJohoEntity entity = DbV3104KokuhorenTorikomiJohoEntityGenerator.createDbV3104KokuhorenTorikomiJohoEntity();
            entity.initializeMd5();
            KokuhorenTorikomiJoho 国保連取り込み情報 = new KokuhorenTorikomiJoho(entity);
            国保連取り込み情報 = 国保連取り込み情報.createBuilderForEdit().set交換情報識別番号(new RString("交換情報識別番号を変更")).build();

            assertThat(sut.save国保連取り込み情報(国保連取り込み情報), is(false));
        }

        @Test
        public void deleteに成功するとtrueが返る() {
            when(dac.save(any(DbV3104KokuhorenTorikomiJohoEntity.class))).thenReturn(1);

            DbV3104KokuhorenTorikomiJohoEntity entity = DbV3104KokuhorenTorikomiJohoEntityGenerator.createDbV3104KokuhorenTorikomiJohoEntity();
            entity.initializeMd5();
            KokuhorenTorikomiJoho 国保連取り込み情報 = new KokuhorenTorikomiJoho(entity);
            国保連取り込み情報 = 国保連取り込み情報.deleted();

            assertThat(sut.save国保連取り込み情報(国保連取り込み情報), is(true));
        }

        @Test
        public void deleteに失敗するとfalseが返る() {
            when(dac.save(any(DbV3104KokuhorenTorikomiJohoEntity.class))).thenReturn(0);

            DbV3104KokuhorenTorikomiJohoEntity entity = DbV3104KokuhorenTorikomiJohoEntityGenerator.createDbV3104KokuhorenTorikomiJohoEntity();
            entity.initializeMd5();
            KokuhorenTorikomiJoho 国保連取り込み情報 = new KokuhorenTorikomiJoho(entity);
            国保連取り込み情報 = 国保連取り込み情報.deleted();

            assertThat(sut.save国保連取り込み情報(国保連取り込み情報), is(false));
        }

        public void 何も変更せずにsaveを呼び出すとfalseが返る() {
            DbV3104KokuhorenTorikomiJohoEntity entity = DbV3104KokuhorenTorikomiJohoEntityGenerator.createDbV3104KokuhorenTorikomiJohoEntity();
            entity.initializeMd5();
            KokuhorenTorikomiJoho 国保連取り込み情報 = new KokuhorenTorikomiJoho(entity);

            assertThat(sut.save国保連取り込み情報(国保連取り込み情報), is(false));
        }
    }
}
