/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT7117SogoJigyoKubunShikyuGendoGakuEntity;
import jp.co.ndensan.reams.db.dbc.entity.basic.helper.DbT7117SogoJigyoKubunShikyuGendoGakuEntityGenerator;
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
 * {@link SogoJigyoKubunShikyuGendoGaku}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class SogoJigyoKubunShikyuGendoGakuTest extends DbcTestBase {

    private static DbT7117SogoJigyoKubunShikyuGendoGakuEntity SogoJigyoKubunShikyuGendoGakuEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static RString 主キー名1;
    private static FlexibleYearMonth 主キー名2;
    private static int 主キー名3;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        主キー名1 = DbT7117SogoJigyoKubunShikyuGendoGakuEntityGenerator.DEFAULT_要介護状態区分;
        主キー名2 = DbT7117SogoJigyoKubunShikyuGendoGakuEntityGenerator.DEFAULT_適用開始年月;
        主キー名3 = DbT7117SogoJigyoKubunShikyuGendoGakuEntityGenerator.DEFAULT_履歴番号;
    }

    public static class 主キーコンストラクタテスト extends DbcTestBase {

        private static SogoJigyoKubunShikyuGendoGaku sut;

        @Before
        public void setUp() {
            SogoJigyoKubunShikyuGendoGakuEntity = DbT7117SogoJigyoKubunShikyuGendoGakuEntityGenerator.createDbT7117SogoJigyoKubunShikyuGendoGakuEntity();
            SogoJigyoKubunShikyuGendoGakuEntity.setYoKaigoJotaiKubun(主キー名1);
            SogoJigyoKubunShikyuGendoGakuEntity.setTekiyoKaishiYM(主キー名2);
            SogoJigyoKubunShikyuGendoGakuEntity.setRirekiNo(主キー名3);
        }

//TODO 主キー名を置換してください
        @Test(expected = NullPointerException.class)
        public void 主キー名1がnullである場合に_NullPointerExceptionが発生する() {
            sut = new SogoJigyoKubunShikyuGendoGaku(null, 主キー名2, 主キー名3);
        }

        @Test(expected = NullPointerException.class)
        public void 主キー名2がnullである場合に_NullPointerExceptionが発生する() {
            sut = new SogoJigyoKubunShikyuGendoGaku(主キー名1, null, 主キー名3);
        }

        @Test
        public void 指定したキーが保持するDbT7117SogoJigyoKubunShikyuGendoGakuEntityにセットされている() {
            sut = new SogoJigyoKubunShikyuGendoGaku(主キー名1, 主キー名2, 主キー名3);
            assertThat(sut.get要介護状態区分(), is(主キー名1));
            assertThat(sut.get適用開始年月(), is(主キー名2));
        }

        @Test
        public void 指定したキーが保持するSogoJigyoKubunShikyuGendoGakuIdentifierにセットされている() {
            sut = new SogoJigyoKubunShikyuGendoGaku(主キー名1, 主キー名2, 主キー名3);
            assertThat(sut.identifier().get要介護状態区分(), is(主キー名1));
            assertThat(sut.identifier().get適用開始年月(), is(主キー名2));
        }
    }

    public static class Entityコンストラクタテスト extends DbcTestBase {

        private static SogoJigyoKubunShikyuGendoGaku sut;

        @Before
        public void setUp() {
            SogoJigyoKubunShikyuGendoGakuEntity = DbT7117SogoJigyoKubunShikyuGendoGakuEntityGenerator.createDbT7117SogoJigyoKubunShikyuGendoGakuEntity();
            SogoJigyoKubunShikyuGendoGakuEntity.setYoKaigoJotaiKubun(主キー名1);
            SogoJigyoKubunShikyuGendoGakuEntity.setTekiyoKaishiYM(主キー名2);
            SogoJigyoKubunShikyuGendoGakuEntity.setRirekiNo(主キー名3);
        }

        @Test(expected = NullPointerException.class)
        public void 指定したEntityがnullである場合_NullPointerExceptionとなる() {
            sut = new SogoJigyoKubunShikyuGendoGaku(null);
        }

        @Test
        public void 指定したDbT7117SogoJigyoKubunShikyuGendoGakuEntityのキー情報を識別子が持つ() {

            sut = new SogoJigyoKubunShikyuGendoGaku(SogoJigyoKubunShikyuGendoGakuEntity);

            assertThat(sut.identifier().get要介護状態区分(), is(主キー名1));
            assertThat(sut.identifier().get適用開始年月(), is(主キー名2));
        }
    }

    public static class getterテスト extends DbcTestBase {

        private static SogoJigyoKubunShikyuGendoGaku sut;

        @Before
        public void setUp() {
            SogoJigyoKubunShikyuGendoGakuEntity = DbT7117SogoJigyoKubunShikyuGendoGakuEntityGenerator.createDbT7117SogoJigyoKubunShikyuGendoGakuEntity();
            SogoJigyoKubunShikyuGendoGakuEntity.setYoKaigoJotaiKubun(主キー名1);
            SogoJigyoKubunShikyuGendoGakuEntity.setTekiyoKaishiYM(主キー名2);
            SogoJigyoKubunShikyuGendoGakuEntity.setRirekiNo(主キー名3);

            sut = new SogoJigyoKubunShikyuGendoGaku(SogoJigyoKubunShikyuGendoGakuEntity);
        }

        @Test
        public void get要介護状態区分は_entityが持つ要介護状態区分を返す() {
            assertThat(sut.get要介護状態区分(), is(SogoJigyoKubunShikyuGendoGakuEntity.getYoKaigoJotaiKubun()));
        }

        @Test
        public void get適用開始年月は_entityが持つ適用開始年月を返す() {
            assertThat(sut.get適用開始年月(), is(SogoJigyoKubunShikyuGendoGakuEntity.getTekiyoKaishiYM()));
        }

        @Test
        public void get履歴番号は_entityが持つ履歴番号を返す() {
            assertThat(sut.get履歴番号(), is(SogoJigyoKubunShikyuGendoGakuEntity.getRirekiNo()));
        }

        @Test
        public void get適用終了年月は_entityが持つ適用終了年月を返す() {
            assertThat(sut.get適用終了年月(), is(SogoJigyoKubunShikyuGendoGakuEntity.getTekiyoShuryoYM()));
        }

        @Test
        public void get支給限度単位数は_entityが持つ支給限度単位数を返す() {
            assertThat(sut.get支給限度単位数(), is(SogoJigyoKubunShikyuGendoGakuEntity.getShikyuGendoTaniSu()));
        }
    }

    public static class toEntityテスト extends DbcTestBase {

        private static SogoJigyoKubunShikyuGendoGaku sut;

        @Before
        public void setUp() {
            SogoJigyoKubunShikyuGendoGakuEntity = DbT7117SogoJigyoKubunShikyuGendoGakuEntityGenerator.createDbT7117SogoJigyoKubunShikyuGendoGakuEntity();
            SogoJigyoKubunShikyuGendoGakuEntity.setYoKaigoJotaiKubun(主キー名1);
            SogoJigyoKubunShikyuGendoGakuEntity.setTekiyoKaishiYM(主キー名2);
            SogoJigyoKubunShikyuGendoGakuEntity.setRirekiNo(主キー名3);

            sut = new SogoJigyoKubunShikyuGendoGaku(SogoJigyoKubunShikyuGendoGakuEntity);
        }

        @Test
        public void toEntityはコンストラクタで設定したentityと異なるインスタンスを返す() {
            assertThat(sut.toEntity(), not(SogoJigyoKubunShikyuGendoGakuEntity));
        }
    }

    public static class SerializationProxyテスト extends DbcTestBase {

        private static SogoJigyoKubunShikyuGendoGaku sut;

        @Before
        public void setUp() {
            SogoJigyoKubunShikyuGendoGakuEntity = DbT7117SogoJigyoKubunShikyuGendoGakuEntityGenerator.createDbT7117SogoJigyoKubunShikyuGendoGakuEntity();
            SogoJigyoKubunShikyuGendoGakuEntity.setYoKaigoJotaiKubun(主キー名1);
            SogoJigyoKubunShikyuGendoGakuEntity.setTekiyoKaishiYM(主キー名2);
            SogoJigyoKubunShikyuGendoGakuEntity.setRirekiNo(主キー名3);

            sut = new SogoJigyoKubunShikyuGendoGaku(SogoJigyoKubunShikyuGendoGakuEntity);
        }

        @Test
        public void シリアライズできる() {
            assertThat(sut, is(serializable()));
        }
    }

    public static class deletedテスト extends DbcTestBase {

        private static SogoJigyoKubunShikyuGendoGaku sut;
        private static SogoJigyoKubunShikyuGendoGaku result;

        @Before
        public void setUp() {
            SogoJigyoKubunShikyuGendoGakuEntity = DbT7117SogoJigyoKubunShikyuGendoGakuEntityGenerator.createDbT7117SogoJigyoKubunShikyuGendoGakuEntity();
            SogoJigyoKubunShikyuGendoGakuEntity.setYoKaigoJotaiKubun(主キー名1);
            SogoJigyoKubunShikyuGendoGakuEntity.setTekiyoKaishiYM(主キー名2);
            SogoJigyoKubunShikyuGendoGakuEntity.setRirekiNo(主キー名3);

        }

        @Test
        public void SogoJigyoKubunShikyuGendoGakuが保持するDbT7117SogoJigyoKubunShikyuGendoGakuEntityのEntityDataStateがUnchangedである場合_deletedメソッド_によりSogoJigyoKubunShikyuGendoGakuが保持するDbT7117SogoJigyoKubunShikyuGendoGakuEntityのEntityDataStateがDeletedに指定されたSogoJigyoKubunShikyuGendoGakuが返る() {
            sut = TestSupport.setStateSogoJigyoKubunShikyuGendoGaku(EntityDataState.Unchanged);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void SogoJigyoKubunShikyuGendoGakuが保持するDbT7117SogoJigyoKubunShikyuGendoGakuEntityのEntityDataStateがModifiedである場合_deletedメソッド_によりSogoJigyoKubunShikyuGendoGakuが保持するDbT7117SogoJigyoKubunShikyuGendoGakuEntityのEntityDataStateがDeletedに指定されたSogoJigyoKubunShikyuGendoGakuが返る() {
            sut = TestSupport.setStateSogoJigyoKubunShikyuGendoGaku(EntityDataState.Modified);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void SogoJigyoKubunShikyuGendoGakuが保持するDbT7117SogoJigyoKubunShikyuGendoGakuEntityのEntityDataStateがDeletedである場合_deletedメソッド_によりSogoJigyoKubunShikyuGendoGakuが保持するDbT7117SogoJigyoKubunShikyuGendoGakuEntityのEntityDataStateがDeletedに指定されたSogoJigyoKubunShikyuGendoGakuが返る() {
            sut = TestSupport.setStateSogoJigyoKubunShikyuGendoGaku(EntityDataState.Deleted);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test(expected = IllegalStateException.class)
        public void SogoJigyoKubunShikyuGendoGakuが保持するDbT7117SogoJigyoKubunShikyuGendoGakuEntityのEntityDataStateがAddedである場合_deletedメソッド_により_IllegalStateExceptionが発火する() {
            sut = TestSupport.setStateSogoJigyoKubunShikyuGendoGaku(EntityDataState.Added);
            result = sut.deleted();
        }
    }

    private static class TestSupport {

        public static SogoJigyoKubunShikyuGendoGaku setStateSogoJigyoKubunShikyuGendoGaku(EntityDataState parentState) {
            SogoJigyoKubunShikyuGendoGakuEntity.setState(parentState);
            return new SogoJigyoKubunShikyuGendoGaku(SogoJigyoKubunShikyuGendoGakuEntity);
        }
    }
}
