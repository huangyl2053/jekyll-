/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3104KokuhorenInterfaceKanriEntity;
import jp.co.ndensan.reams.db.dbc.entity.basic.helper.DbT3104KokuhorenInterfaceKanriEntityGenerator;
import static jp.co.ndensan.reams.db.dbx.testhelper.matcher.IsSerializable.serializable;
import jp.co.ndensan.reams.db.dbz.testhelper.DbcTestBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link KokuhorenInterfaceKanri}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class KokuhorenInterfaceKanriTest extends DbcTestBase {

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

    public static class 主キーコンストラクタテスト extends DbcTestBase {

        private static KokuhorenInterfaceKanri sut;

        @Before
        public void setUp() {
            KokuhorenInterfaceKanriEntity = DbT3104KokuhorenInterfaceKanriEntityGenerator.createDbT3104KokuhorenInterfaceKanriEntity();
            KokuhorenInterfaceKanriEntity.setShoriYM(主キー名1);
            KokuhorenInterfaceKanriEntity.setKokanShikibetsuNo(主キー名2);
        }

//TODO 主キー名を置換してください
        @Test(expected = NullPointerException.class)
        public void 主キー名1がnullである場合に_NullPointerExceptionが発生する() {
            sut = new KokuhorenInterfaceKanri(null, 主キー名2);
        }

        @Test(expected = NullPointerException.class)
        public void 主キー名2がnullである場合に_NullPointerExceptionが発生する() {
            sut = new KokuhorenInterfaceKanri(主キー名1, null);
        }

        @Test
        public void 指定したキーが保持するDbT3104KokuhorenInterfaceKanriEntityにセットされている() {
            sut = new KokuhorenInterfaceKanri(主キー名1, 主キー名2);
            assertThat(sut.get処理年月(), is(主キー名1));
            assertThat(sut.get交換情報識別番号(), is(主キー名2));
        }

        @Test
        public void 指定したキーが保持するKokuhorenInterfaceKanriIdentifierにセットされている() {
            sut = new KokuhorenInterfaceKanri(主キー名1, 主キー名2);
            assertThat(sut.identifier().get処理年月(), is(主キー名1));
            assertThat(sut.identifier().get交換情報識別番号(), is(主キー名2));
        }
    }

    public static class Entityコンストラクタテスト extends DbcTestBase {

        private static KokuhorenInterfaceKanri sut;

        @Before
        public void setUp() {
            KokuhorenInterfaceKanriEntity = DbT3104KokuhorenInterfaceKanriEntityGenerator.createDbT3104KokuhorenInterfaceKanriEntity();
            KokuhorenInterfaceKanriEntity.setShoriYM(主キー名1);
            KokuhorenInterfaceKanriEntity.setKokanShikibetsuNo(主キー名2);
        }

        @Test(expected = NullPointerException.class)
        public void 指定したEntityがnullである場合_NullPointerExceptionとなる() {
            sut = new KokuhorenInterfaceKanri(null);
        }

        @Test
        public void 指定したDbT3104KokuhorenInterfaceKanriEntityのキー情報を識別子が持つ() {

            sut = new KokuhorenInterfaceKanri(KokuhorenInterfaceKanriEntity);

            assertThat(sut.identifier().get処理年月(), is(主キー名1));
            assertThat(sut.identifier().get交換情報識別番号(), is(主キー名2));
        }
    }

    public static class getterテスト extends DbcTestBase {

        private static KokuhorenInterfaceKanri sut;

        @Before
        public void setUp() {
            KokuhorenInterfaceKanriEntity = DbT3104KokuhorenInterfaceKanriEntityGenerator.createDbT3104KokuhorenInterfaceKanriEntity();
            KokuhorenInterfaceKanriEntity.setShoriYM(主キー名1);
            KokuhorenInterfaceKanriEntity.setKokanShikibetsuNo(主キー名2);

            sut = new KokuhorenInterfaceKanri(KokuhorenInterfaceKanriEntity);
        }

        @Test
        public void get処理年月は_entityが持つ処理年月を返す() {
            assertThat(sut.get処理年月(), is(KokuhorenInterfaceKanriEntity.getShoriYM()));
        }

        @Test
        public void get交換情報識別番号は_entityが持つ交換情報識別番号を返す() {
            assertThat(sut.get交換情報識別番号(), is(KokuhorenInterfaceKanriEntity.getKokanShikibetsuNo()));
        }

        @Test
        public void get送付取込区分は_entityが持つ送付取込区分を返す() {
            assertThat(sut.get送付取込区分(), is(KokuhorenInterfaceKanriEntity.getSofuTorikomiKubun()));
        }

        @Test
        public void get処理状態区分は_entityが持つ処理状態区分を返す() {
            assertThat(sut.get処理状態区分(), is(KokuhorenInterfaceKanriEntity.getShoriJotaiKubun()));
        }

        @Test
        public void get処理実施日時は_entityが持つ処理実施日時を返す() {
            assertThat(sut.get処理実施日時(), is(KokuhorenInterfaceKanriEntity.getShoriJisshiTimestamp()));
        }

        @Test
        public void get抽出開始日時は_entityが持つ抽出開始日時を返す() {
            assertThat(sut.get抽出開始日時(), is(KokuhorenInterfaceKanriEntity.getChushutsuKaishiTimestamp()));
        }

        @Test
        public void get抽出終了日時は_entityが持つ抽出終了日時を返す() {
            assertThat(sut.get抽出終了日時(), is(KokuhorenInterfaceKanriEntity.getChushutsuShuryoTimestamp()));
        }

        @Test
        public void get再処理可能区分は_entityが持つ再処理可能区分を返す() {
            assertThat(sut.is再処理可能区分(), is(KokuhorenInterfaceKanriEntity.getSaiShoriKahiKubun()));
        }

        @Test
        public void get処理実行回数は_entityが持つ処理実行回数を返す() {
            assertThat(sut.get処理実行回数(), is(KokuhorenInterfaceKanriEntity.getShoriJikkoKaisu()));
        }

        @Test
        public void getファイル名称１は_entityが持つファイル名称１を返す() {
            assertThat(sut.getファイル名称１(), is(KokuhorenInterfaceKanriEntity.getFileName1()));
        }

        @Test
        public void getファイル名称２は_entityが持つファイル名称２を返す() {
            assertThat(sut.getファイル名称２(), is(KokuhorenInterfaceKanriEntity.getFileName2()));
        }

        @Test
        public void getファイル名称３は_entityが持つファイル名称３を返す() {
            assertThat(sut.getファイル名称３(), is(KokuhorenInterfaceKanriEntity.getFileName3()));
        }

        @Test
        public void getファイル名称４は_entityが持つファイル名称４を返す() {
            assertThat(sut.getファイル名称４(), is(KokuhorenInterfaceKanriEntity.getFileName4()));
        }

        @Test
        public void getファイル名称５は_entityが持つファイル名称５を返す() {
            assertThat(sut.getファイル名称５(), is(KokuhorenInterfaceKanriEntity.getFileName5()));
        }

        @Test
        public void getファイル件数１は_entityが持つファイル件数１を返す() {
            assertThat(sut.getファイル件数１(), is(KokuhorenInterfaceKanriEntity.getFileKensu1()));
        }

        @Test
        public void getファイル件数２は_entityが持つファイル件数２を返す() {
            assertThat(sut.getファイル件数２(), is(KokuhorenInterfaceKanriEntity.getFileKensu2()));
        }

        @Test
        public void getファイル件数３は_entityが持つファイル件数３を返す() {
            assertThat(sut.getファイル件数３(), is(KokuhorenInterfaceKanriEntity.getFileKensu3()));
        }

        @Test
        public void getファイル件数４は_entityが持つファイル件数４を返す() {
            assertThat(sut.getファイル件数４(), is(KokuhorenInterfaceKanriEntity.getFileKensu4()));
        }

        @Test
        public void getファイル件数５は_entityが持つファイル件数５を返す() {
            assertThat(sut.getファイル件数５(), is(KokuhorenInterfaceKanriEntity.getFileKensu5()));
        }

        @Test
        public void get再処理設定不可区分は_entityが持つ再処理設定不可区分を返す() {
            assertThat(sut.is再処理設定不可区分(), is(KokuhorenInterfaceKanriEntity.getSaiShoriFukaKubun()));
        }

        @Test
        public void getコントロール上レコード件数は_entityが持つコントロール上レコード件数を返す() {
            assertThat(sut.getコントロール上レコード件数(), is(KokuhorenInterfaceKanriEntity.getCtrlRecordKensu()));
        }

        @Test
        public void getコントロール上処理年月は_entityが持つコントロール上処理年月を返す() {
            assertThat(sut.getコントロール上処理年月(), is(KokuhorenInterfaceKanriEntity.getCtrlShoriYM()));
        }

        @Test
        public void get過誤コントロール上レコード件数は_entityが持つ過誤コントロール上レコード件数を返す() {
            assertThat(sut.get過誤コントロール上レコード件数(), is(KokuhorenInterfaceKanriEntity.getKagoCtrlRecordKensu()));
        }

        @Test
        public void get過誤コントロール上処理年月は_entityが持つ過誤コントロール上処理年月を返す() {
            assertThat(sut.get過誤コントロール上処理年月(), is(KokuhorenInterfaceKanriEntity.getKagoCtrlShoriYM()));
        }

        @Test
        public void get実績データ上審査年月は_entityが持つ実績データ上審査年月を返す() {
            assertThat(sut.get実績データ上審査年月(), is(KokuhorenInterfaceKanriEntity.getJissekiDataShinsaYM()));
        }
    }

    public static class toEntityテスト extends DbcTestBase {

        private static KokuhorenInterfaceKanri sut;

        @Before
        public void setUp() {
            KokuhorenInterfaceKanriEntity = DbT3104KokuhorenInterfaceKanriEntityGenerator.createDbT3104KokuhorenInterfaceKanriEntity();
            KokuhorenInterfaceKanriEntity.setShoriYM(主キー名1);
            KokuhorenInterfaceKanriEntity.setKokanShikibetsuNo(主キー名2);

            sut = new KokuhorenInterfaceKanri(KokuhorenInterfaceKanriEntity);
        }

        @Test
        public void toEntityはコンストラクタで設定したentityと異なるインスタンスを返す() {
            assertThat(sut.toEntity(), not(KokuhorenInterfaceKanriEntity));
        }
    }

    public static class SerializationProxyテスト extends DbcTestBase {

        private static KokuhorenInterfaceKanri sut;

        @Before
        public void setUp() {
            KokuhorenInterfaceKanriEntity = DbT3104KokuhorenInterfaceKanriEntityGenerator.createDbT3104KokuhorenInterfaceKanriEntity();
            KokuhorenInterfaceKanriEntity.setShoriYM(主キー名1);
            KokuhorenInterfaceKanriEntity.setKokanShikibetsuNo(主キー名2);

            sut = new KokuhorenInterfaceKanri(KokuhorenInterfaceKanriEntity);
        }

        @Test
        public void シリアライズできる() {
            assertThat(sut, is(serializable()));
        }
    }

    public static class deletedテスト extends DbcTestBase {

        private static KokuhorenInterfaceKanri sut;
        private static KokuhorenInterfaceKanri result;

        @Before
        public void setUp() {
            KokuhorenInterfaceKanriEntity = DbT3104KokuhorenInterfaceKanriEntityGenerator.createDbT3104KokuhorenInterfaceKanriEntity();
            KokuhorenInterfaceKanriEntity.setShoriYM(主キー名1);
            KokuhorenInterfaceKanriEntity.setKokanShikibetsuNo(主キー名2);

        }

        @Test
        public void KokuhorenInterfaceKanriが保持するDbT3104KokuhorenInterfaceKanriEntityのEntityDataStateがUnchangedである場合_deletedメソッド_によりKokuhorenInterfaceKanriが保持するDbT3104KokuhorenInterfaceKanriEntityのEntityDataStateがDeletedに指定されたKokuhorenInterfaceKanriが返る() {
            sut = TestSupport.setStateKokuhorenInterfaceKanri(EntityDataState.Unchanged);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void KokuhorenInterfaceKanriが保持するDbT3104KokuhorenInterfaceKanriEntityのEntityDataStateがModifiedである場合_deletedメソッド_によりKokuhorenInterfaceKanriが保持するDbT3104KokuhorenInterfaceKanriEntityのEntityDataStateがDeletedに指定されたKokuhorenInterfaceKanriが返る() {
            sut = TestSupport.setStateKokuhorenInterfaceKanri(EntityDataState.Modified);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void KokuhorenInterfaceKanriが保持するDbT3104KokuhorenInterfaceKanriEntityのEntityDataStateがDeletedである場合_deletedメソッド_によりKokuhorenInterfaceKanriが保持するDbT3104KokuhorenInterfaceKanriEntityのEntityDataStateがDeletedに指定されたKokuhorenInterfaceKanriが返る() {
            sut = TestSupport.setStateKokuhorenInterfaceKanri(EntityDataState.Deleted);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test(expected = IllegalStateException.class)
        public void KokuhorenInterfaceKanriが保持するDbT3104KokuhorenInterfaceKanriEntityのEntityDataStateがAddedである場合_deletedメソッド_により_IllegalStateExceptionが発火する() {
            sut = TestSupport.setStateKokuhorenInterfaceKanri(EntityDataState.Added);
            result = sut.deleted();
        }
    }

    private static class TestSupport {

        public static KokuhorenInterfaceKanri setStateKokuhorenInterfaceKanri(EntityDataState parentState) {
            KokuhorenInterfaceKanriEntity.setState(parentState);
            return new KokuhorenInterfaceKanri(KokuhorenInterfaceKanriEntity);
        }
    }
}
