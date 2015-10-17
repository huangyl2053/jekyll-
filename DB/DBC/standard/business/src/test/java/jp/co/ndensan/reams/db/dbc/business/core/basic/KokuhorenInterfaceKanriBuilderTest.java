/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3104KokuhorenInterfaceKanriEntity;
import jp.co.ndensan.reams.db.dbc.entity.basic.helper.DbT3104KokuhorenInterfaceKanriEntityGenerator;
import jp.co.ndensan.reams.db.dbz.testhelper.DbcTestBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link KokuhorenInterfaceKanriBuilder}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class KokuhorenInterfaceKanriBuilderTest extends DbcTestBase {

    private static DbT3104KokuhorenInterfaceKanriEntity KokuhorenInterfaceKanriEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static FlexibleYearMonth 主キー名1;
    private static RString 主キー名2;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        主キー名1 = DbT3104KokuhorenInterfaceKanriEntityGenerator.DEFAULT_処理年月;
        主キー名2 = DbT3104KokuhorenInterfaceKanriEntityGenerator.DEFAULT_交換情報識別番号;
    }

    public static class getterSetterTest extends DbcTestBase {

        private static KokuhorenInterfaceKanriBuilder sut;
        private static KokuhorenInterfaceKanri business;

        @Before
        public void setUp() {
            KokuhorenInterfaceKanriEntity = new DbT3104KokuhorenInterfaceKanriEntity();
            KokuhorenInterfaceKanriEntity.setShoriYM(主キー名1);
            KokuhorenInterfaceKanriEntity.setKokanShikibetsuNo(主キー名2);

            business = new KokuhorenInterfaceKanri(KokuhorenInterfaceKanriEntity);

            sut = business.createBuilderForEdit();
        }
//TODO Key項目のテストメソッドは削除して下さい。

        @Test
        public void 戻り値の処理年月は_設定した値と同じ処理年月を返す() {
            business = sut.set処理年月(DbT3104KokuhorenInterfaceKanriEntityGenerator.DEFAULT_処理年月).build();
            assertThat(business.get処理年月(), is(DbT3104KokuhorenInterfaceKanriEntityGenerator.DEFAULT_処理年月));
        }

        @Test
        public void 戻り値の交換情報識別番号は_設定した値と同じ交換情報識別番号を返す() {
            business = sut.set交換情報識別番号(DbT3104KokuhorenInterfaceKanriEntityGenerator.DEFAULT_交換情報識別番号).build();
            assertThat(business.get交換情報識別番号(), is(DbT3104KokuhorenInterfaceKanriEntityGenerator.DEFAULT_交換情報識別番号));
        }

        @Test
        public void 戻り値の送付取込区分は_設定した値と同じ送付取込区分を返す() {
            business = sut.set送付取込区分(DbT3104KokuhorenInterfaceKanriEntityGenerator.DEFAULT_送付取込区分).build();
            assertThat(business.get送付取込区分(), is(DbT3104KokuhorenInterfaceKanriEntityGenerator.DEFAULT_送付取込区分));
        }

        @Test
        public void 戻り値の処理状態区分は_設定した値と同じ処理状態区分を返す() {
            business = sut.set処理状態区分(DbT3104KokuhorenInterfaceKanriEntityGenerator.DEFAULT_処理状態区分).build();
            assertThat(business.get処理状態区分(), is(DbT3104KokuhorenInterfaceKanriEntityGenerator.DEFAULT_処理状態区分));
        }

        @Test
        public void 戻り値の処理実施日時は_設定した値と同じ処理実施日時を返す() {
            business = sut.set処理実施日時(DbT3104KokuhorenInterfaceKanriEntityGenerator.DEFAULT_処理実施日時).build();
            assertThat(business.get処理実施日時(), is(DbT3104KokuhorenInterfaceKanriEntityGenerator.DEFAULT_処理実施日時));
        }

        @Test
        public void 戻り値の抽出開始日時は_設定した値と同じ抽出開始日時を返す() {
            business = sut.set抽出開始日時(DbT3104KokuhorenInterfaceKanriEntityGenerator.DEFAULT_抽出開始日時).build();
            assertThat(business.get抽出開始日時(), is(DbT3104KokuhorenInterfaceKanriEntityGenerator.DEFAULT_抽出開始日時));
        }

        @Test
        public void 戻り値の抽出終了日時は_設定した値と同じ抽出終了日時を返す() {
            business = sut.set抽出終了日時(DbT3104KokuhorenInterfaceKanriEntityGenerator.DEFAULT_抽出終了日時).build();
            assertThat(business.get抽出終了日時(), is(DbT3104KokuhorenInterfaceKanriEntityGenerator.DEFAULT_抽出終了日時));
        }

        @Test
        public void 戻り値の再処理可能区分は_設定した値と同じ再処理可能区分を返す() {
            business = sut.set再処理可能区分(DbT3104KokuhorenInterfaceKanriEntityGenerator.DEFAULT_再処理可能区分).build();
            assertThat(business.get再処理可能区分(), is(DbT3104KokuhorenInterfaceKanriEntityGenerator.DEFAULT_再処理可能区分));
        }

        @Test
        public void 戻り値の処理実行回数は_設定した値と同じ処理実行回数を返す() {
            business = sut.set処理実行回数(DbT3104KokuhorenInterfaceKanriEntityGenerator.DEFAULT_処理実行回数).build();
            assertThat(business.get処理実行回数(), is(DbT3104KokuhorenInterfaceKanriEntityGenerator.DEFAULT_処理実行回数));
        }

        @Test
        public void 戻り値のファイル名称１は_設定した値と同じファイル名称１を返す() {
            business = sut.setファイル名称１(DbT3104KokuhorenInterfaceKanriEntityGenerator.DEFAULT_ファイル名称１).build();
            assertThat(business.getファイル名称１(), is(DbT3104KokuhorenInterfaceKanriEntityGenerator.DEFAULT_ファイル名称１));
        }

        @Test
        public void 戻り値のファイル名称２は_設定した値と同じファイル名称２を返す() {
            business = sut.setファイル名称２(DbT3104KokuhorenInterfaceKanriEntityGenerator.DEFAULT_ファイル名称２).build();
            assertThat(business.getファイル名称２(), is(DbT3104KokuhorenInterfaceKanriEntityGenerator.DEFAULT_ファイル名称２));
        }

        @Test
        public void 戻り値のファイル名称３は_設定した値と同じファイル名称３を返す() {
            business = sut.setファイル名称３(DbT3104KokuhorenInterfaceKanriEntityGenerator.DEFAULT_ファイル名称３).build();
            assertThat(business.getファイル名称３(), is(DbT3104KokuhorenInterfaceKanriEntityGenerator.DEFAULT_ファイル名称３));
        }

        @Test
        public void 戻り値のファイル名称４は_設定した値と同じファイル名称４を返す() {
            business = sut.setファイル名称４(DbT3104KokuhorenInterfaceKanriEntityGenerator.DEFAULT_ファイル名称４).build();
            assertThat(business.getファイル名称４(), is(DbT3104KokuhorenInterfaceKanriEntityGenerator.DEFAULT_ファイル名称４));
        }

        @Test
        public void 戻り値のファイル名称５は_設定した値と同じファイル名称５を返す() {
            business = sut.setファイル名称５(DbT3104KokuhorenInterfaceKanriEntityGenerator.DEFAULT_ファイル名称５).build();
            assertThat(business.getファイル名称５(), is(DbT3104KokuhorenInterfaceKanriEntityGenerator.DEFAULT_ファイル名称５));
        }

        @Test
        public void 戻り値のファイル件数１は_設定した値と同じファイル件数１を返す() {
            business = sut.setファイル件数１(DbT3104KokuhorenInterfaceKanriEntityGenerator.DEFAULT_ファイル件数１).build();
            assertThat(business.getファイル件数１(), is(DbT3104KokuhorenInterfaceKanriEntityGenerator.DEFAULT_ファイル件数１));
        }

        @Test
        public void 戻り値のファイル件数２は_設定した値と同じファイル件数２を返す() {
            business = sut.setファイル件数２(DbT3104KokuhorenInterfaceKanriEntityGenerator.DEFAULT_ファイル件数２).build();
            assertThat(business.getファイル件数２(), is(DbT3104KokuhorenInterfaceKanriEntityGenerator.DEFAULT_ファイル件数２));
        }

        @Test
        public void 戻り値のファイル件数３は_設定した値と同じファイル件数３を返す() {
            business = sut.setファイル件数３(DbT3104KokuhorenInterfaceKanriEntityGenerator.DEFAULT_ファイル件数３).build();
            assertThat(business.getファイル件数３(), is(DbT3104KokuhorenInterfaceKanriEntityGenerator.DEFAULT_ファイル件数３));
        }

        @Test
        public void 戻り値のファイル件数４は_設定した値と同じファイル件数４を返す() {
            business = sut.setファイル件数４(DbT3104KokuhorenInterfaceKanriEntityGenerator.DEFAULT_ファイル件数４).build();
            assertThat(business.getファイル件数４(), is(DbT3104KokuhorenInterfaceKanriEntityGenerator.DEFAULT_ファイル件数４));
        }

        @Test
        public void 戻り値のファイル件数５は_設定した値と同じファイル件数５を返す() {
            business = sut.setファイル件数５(DbT3104KokuhorenInterfaceKanriEntityGenerator.DEFAULT_ファイル件数５).build();
            assertThat(business.getファイル件数５(), is(DbT3104KokuhorenInterfaceKanriEntityGenerator.DEFAULT_ファイル件数５));
        }

        @Test
        public void 戻り値の再処理設定不可区分は_設定した値と同じ再処理設定不可区分を返す() {
            business = sut.set再処理設定不可区分(DbT3104KokuhorenInterfaceKanriEntityGenerator.DEFAULT_再処理設定不可区分).build();
            assertThat(business.get再処理設定不可区分(), is(DbT3104KokuhorenInterfaceKanriEntityGenerator.DEFAULT_再処理設定不可区分));
        }

        @Test
        public void 戻り値のコントロール上レコード件数は_設定した値と同じコントロール上レコード件数を返す() {
            business = sut.setコントロール上レコード件数(DbT3104KokuhorenInterfaceKanriEntityGenerator.DEFAULT_コントロール上レコード件数).build();
            assertThat(business.getコントロール上レコード件数(), is(DbT3104KokuhorenInterfaceKanriEntityGenerator.DEFAULT_コントロール上レコード件数));
        }

        @Test
        public void 戻り値のコントロール上処理年月は_設定した値と同じコントロール上処理年月を返す() {
            business = sut.setコントロール上処理年月(DbT3104KokuhorenInterfaceKanriEntityGenerator.DEFAULT_コントロール上処理年月).build();
            assertThat(business.getコントロール上処理年月(), is(DbT3104KokuhorenInterfaceKanriEntityGenerator.DEFAULT_コントロール上処理年月));
        }

        @Test
        public void 戻り値の過誤コントロール上レコード件数は_設定した値と同じ過誤コントロール上レコード件数を返す() {
            business = sut.set過誤コントロール上レコード件数(DbT3104KokuhorenInterfaceKanriEntityGenerator.DEFAULT_過誤コントロール上レコード件数).build();
            assertThat(business.get過誤コントロール上レコード件数(), is(DbT3104KokuhorenInterfaceKanriEntityGenerator.DEFAULT_過誤コントロール上レコード件数));
        }

        @Test
        public void 戻り値の過誤コントロール上処理年月は_設定した値と同じ過誤コントロール上処理年月を返す() {
            business = sut.set過誤コントロール上処理年月(DbT3104KokuhorenInterfaceKanriEntityGenerator.DEFAULT_過誤コントロール上処理年月).build();
            assertThat(business.get過誤コントロール上処理年月(), is(DbT3104KokuhorenInterfaceKanriEntityGenerator.DEFAULT_過誤コントロール上処理年月));
        }

        @Test
        public void 戻り値の実績データ上審査年月は_設定した値と同じ実績データ上審査年月を返す() {
            business = sut.set実績データ上審査年月(DbT3104KokuhorenInterfaceKanriEntityGenerator.DEFAULT_実績データ上審査年月).build();
            assertThat(business.get実績データ上審査年月(), is(DbT3104KokuhorenInterfaceKanriEntityGenerator.DEFAULT_実績データ上審査年月));
        }

    }
}
