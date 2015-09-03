/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import jp.co.ndensan.reams.db.dbc.entity.basic.DbT7110TankiNyushoShikyuGendoGakuEntity;
import jp.co.ndensan.reams.db.dbc.entity.basic.helper.DbT7110TankiNyushoShikyuGendoGakuEntityGenerator;
import jp.co.ndensan.reams.db.dbx.testhelper.matcher.IsSerializable;
import jp.co.ndensan.reams.db.dbz.testhelper.DbcTestBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link TankiNyushoShikyuGendoGaku}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class TankiNyushoShikyuGendoGakuTest extends DbcTestBase {

    private static DbT7110TankiNyushoShikyuGendoGakuEntity TankiNyushoShikyuGendoGakuEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static RString 主キー名1;
    private static FlexibleYearMonth 主キー名2;
    private static int 主キー名3;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        主キー名1 = DbT7110TankiNyushoShikyuGendoGakuEntityGenerator.DEFAULT_要介護状態区分;
        主キー名2 = DbT7110TankiNyushoShikyuGendoGakuEntityGenerator.DEFAULT_適用開始年月;
    }

    public static class 主キーコンストラクタテスト extends DbcTestBase {

        private static TankiNyushoShikyuGendoGaku sut;

        @Before
        public void setUp() {
            TankiNyushoShikyuGendoGakuEntity = DbT7110TankiNyushoShikyuGendoGakuEntityGenerator.createDbT7110TankiNyushoShikyuGendoGakuEntity();
            TankiNyushoShikyuGendoGakuEntity.setYoKaigoJotaiKubun(主キー名1);
            TankiNyushoShikyuGendoGakuEntity.setTekiyoKaishiYM(主キー名2);
        }

//TODO 主キー名を置換してください
        @Test(expected = NullPointerException.class)
        public void 主キー名1がnullである場合に_NullPointerExceptionが発生する() {
            sut = new TankiNyushoShikyuGendoGaku(null, 主キー名2, 主キー名3);
        }

        @Test(expected = NullPointerException.class)
        public void 主キー名2がnullである場合に_NullPointerExceptionが発生する() {
            sut = new TankiNyushoShikyuGendoGaku(主キー名1, null, 主キー名3);
        }

        @Test
        public void 指定したキーが保持するDbT7110TankiNyushoShikyuGendoGakuEntityにセットされている() {
            sut = new TankiNyushoShikyuGendoGaku(主キー名1, 主キー名2, 主キー名3);
            assertThat(sut.get要介護状態区分(), is(主キー名1));
            assertThat(sut.get適用開始年月(), is(主キー名2));
        }

        @Test
        public void 指定したキーが保持するTankiNyushoShikyuGendoGakuIdentifierにセットされている() {
            sut = new TankiNyushoShikyuGendoGaku(主キー名1, 主キー名2, 主キー名3);
            assertThat(sut.identifier().get要介護状態区分(), is(主キー名1));
            assertThat(sut.identifier().get適用開始年月(), is(主キー名2));
        }
    }

    public static class Entityコンストラクタテスト extends DbcTestBase {

        private static TankiNyushoShikyuGendoGaku sut;

        @Before
        public void setUp() {
            TankiNyushoShikyuGendoGakuEntity = DbT7110TankiNyushoShikyuGendoGakuEntityGenerator.createDbT7110TankiNyushoShikyuGendoGakuEntity();
            TankiNyushoShikyuGendoGakuEntity.setYoKaigoJotaiKubun(主キー名1);
            TankiNyushoShikyuGendoGakuEntity.setTekiyoKaishiYM(主キー名2);
        }

        @Test(expected = NullPointerException.class)
        public void 指定したEntityがnullである場合_NullPointerExceptionとなる() {
            sut = new TankiNyushoShikyuGendoGaku(null);
        }

        @Test
        public void 指定したDbT7110TankiNyushoShikyuGendoGakuEntityのキー情報を識別子が持つ() {

            sut = new TankiNyushoShikyuGendoGaku(TankiNyushoShikyuGendoGakuEntity);

            assertThat(sut.identifier().get要介護状態区分(), is(主キー名1));
            assertThat(sut.identifier().get適用開始年月(), is(主キー名2));
        }
    }

    public static class getterテスト extends DbcTestBase {

        private static TankiNyushoShikyuGendoGaku sut;

        @Before
        public void setUp() {
            TankiNyushoShikyuGendoGakuEntity = DbT7110TankiNyushoShikyuGendoGakuEntityGenerator.createDbT7110TankiNyushoShikyuGendoGakuEntity();
            TankiNyushoShikyuGendoGakuEntity.setYoKaigoJotaiKubun(主キー名1);
            TankiNyushoShikyuGendoGakuEntity.setTekiyoKaishiYM(主キー名2);

            sut = new TankiNyushoShikyuGendoGaku(TankiNyushoShikyuGendoGakuEntity);
        }

        @Test
        public void get要介護状態区分は_entityが持つ要介護状態区分を返す() {
            assertThat(sut.get要介護状態区分(), is(TankiNyushoShikyuGendoGakuEntity.getYoKaigoJotaiKubun()));
        }

        @Test
        public void get適用開始年月は_entityが持つ適用開始年月を返す() {
            assertThat(sut.get適用開始年月(), is(TankiNyushoShikyuGendoGakuEntity.getTekiyoKaishiYM()));
        }

        @Test
        public void get履歴番号は_entityが持つ履歴番号を返す() {
            assertThat(sut.get履歴番号(), is(TankiNyushoShikyuGendoGakuEntity.getRirekiNo()));
        }

        @Test
        public void get適用終了年月は_entityが持つ適用終了年月を返す() {
            assertThat(sut.get適用終了年月(), is(TankiNyushoShikyuGendoGakuEntity.getTekiyoShuryoYM()));
        }

        @Test
        public void get支給限度単位数は_entityが持つ支給限度単位数を返す() {
            assertThat(sut.get支給限度単位数(), is(TankiNyushoShikyuGendoGakuEntity.getShikyuGendoNissu()));
        }
    }

    public static class toEntityテスト extends DbcTestBase {

        private static TankiNyushoShikyuGendoGaku sut;

        @Before
        public void setUp() {
            TankiNyushoShikyuGendoGakuEntity = DbT7110TankiNyushoShikyuGendoGakuEntityGenerator.createDbT7110TankiNyushoShikyuGendoGakuEntity();
            TankiNyushoShikyuGendoGakuEntity.setYoKaigoJotaiKubun(主キー名1);
            TankiNyushoShikyuGendoGakuEntity.setTekiyoKaishiYM(主キー名2);

            sut = new TankiNyushoShikyuGendoGaku(TankiNyushoShikyuGendoGakuEntity);
        }

        @Test
        public void toEntityはコンストラクタで設定したentityと異なるインスタンスを返す() {
            assertThat(sut.toEntity(), not(TankiNyushoShikyuGendoGakuEntity));
        }
    }

    public static class SerializationProxyテスト extends DbcTestBase {

        private static TankiNyushoShikyuGendoGaku sut;

        @Before
        public void setUp() {
            TankiNyushoShikyuGendoGakuEntity = DbT7110TankiNyushoShikyuGendoGakuEntityGenerator.createDbT7110TankiNyushoShikyuGendoGakuEntity();
            TankiNyushoShikyuGendoGakuEntity.setYoKaigoJotaiKubun(主キー名1);
            TankiNyushoShikyuGendoGakuEntity.setTekiyoKaishiYM(主キー名2);

            sut = new TankiNyushoShikyuGendoGaku(TankiNyushoShikyuGendoGakuEntity);
        }

        @Test
        public void シリアライズできる() {
            assertThat(sut, is(IsSerializable.serializable()));
        }
    }

    public static class deletedテスト extends DbcTestBase {

        private static TankiNyushoShikyuGendoGaku sut;
        private static TankiNyushoShikyuGendoGaku result;

        @Before
        public void setUp() {
            TankiNyushoShikyuGendoGakuEntity = DbT7110TankiNyushoShikyuGendoGakuEntityGenerator.createDbT7110TankiNyushoShikyuGendoGakuEntity();
            TankiNyushoShikyuGendoGakuEntity.setYoKaigoJotaiKubun(主キー名1);
            TankiNyushoShikyuGendoGakuEntity.setTekiyoKaishiYM(主キー名2);

        }

        @Test
        public void TankiNyushoShikyuGendoGakuが保持するDbT7110TankiNyushoShikyuGendoGakuEntityのEntityDataStateがUnchangedである場合_deletedメソッド_によりTankiNyushoShikyuGendoGakuが保持するDbT7110TankiNyushoShikyuGendoGakuEntityのEntityDataStateがDeletedに指定されたTankiNyushoShikyuGendoGakuが返る() {
            sut = TestSupport.setStateTankiNyushoShikyuGendoGaku(EntityDataState.Unchanged);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void TankiNyushoShikyuGendoGakuが保持するDbT7110TankiNyushoShikyuGendoGakuEntityのEntityDataStateがModifiedである場合_deletedメソッド_によりTankiNyushoShikyuGendoGakuが保持するDbT7110TankiNyushoShikyuGendoGakuEntityのEntityDataStateがDeletedに指定されたTankiNyushoShikyuGendoGakuが返る() {
            sut = TestSupport.setStateTankiNyushoShikyuGendoGaku(EntityDataState.Modified);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void TankiNyushoShikyuGendoGakuが保持するDbT7110TankiNyushoShikyuGendoGakuEntityのEntityDataStateがDeletedである場合_deletedメソッド_によりTankiNyushoShikyuGendoGakuが保持するDbT7110TankiNyushoShikyuGendoGakuEntityのEntityDataStateがDeletedに指定されたTankiNyushoShikyuGendoGakuが返る() {
            sut = TestSupport.setStateTankiNyushoShikyuGendoGaku(EntityDataState.Deleted);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test(expected = IllegalStateException.class)
        public void TankiNyushoShikyuGendoGakuが保持するDbT7110TankiNyushoShikyuGendoGakuEntityのEntityDataStateがAddedである場合_deletedメソッド_により_IllegalStateExceptionが発火する() {
            sut = TestSupport.setStateTankiNyushoShikyuGendoGaku(EntityDataState.Added);
            result = sut.deleted();
        }
    }

    private static class TestSupport {

        public static TankiNyushoShikyuGendoGaku setStateTankiNyushoShikyuGendoGaku(EntityDataState parentState) {
            TankiNyushoShikyuGendoGakuEntity.setState(parentState);
            return new TankiNyushoShikyuGendoGaku(TankiNyushoShikyuGendoGakuEntity);
        }
    }
}
