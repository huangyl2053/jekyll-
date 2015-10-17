/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT7116JukyushaGendoGakuKanriEntity;
import jp.co.ndensan.reams.db.dbc.entity.basic.helper.DbT7116JukyushaGendoGakuKanriEntityGenerator;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
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
 * {@link JukyushaGendoGakuKanri}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class JukyushaGendoGakuKanriTest extends DbcTestBase {

    private static DbT7116JukyushaGendoGakuKanriEntity JukyushaGendoGakuKanriEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static HihokenshaNo 主キー名1;
    private static RString 主キー名2;
    private static FlexibleYearMonth 主キー名3;
    private static int 主キー名4;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        主キー名1 = DbT7116JukyushaGendoGakuKanriEntityGenerator.DEFAULT_被保険者番号;
        主キー名2 = DbT7116JukyushaGendoGakuKanriEntityGenerator.DEFAULT_識別区分;
        主キー名3 = DbT7116JukyushaGendoGakuKanriEntityGenerator.DEFAULT_有効開始年月;
        主キー名4 = DbT7116JukyushaGendoGakuKanriEntityGenerator.DEFAULT_履歴番号;
    }

    public static class 主キーコンストラクタテスト extends DbcTestBase {

        private static JukyushaGendoGakuKanri sut;

        @Before
        public void setUp() {
            JukyushaGendoGakuKanriEntity = DbT7116JukyushaGendoGakuKanriEntityGenerator.createDbT7116JukyushaGendoGakuKanriEntity();
            JukyushaGendoGakuKanriEntity.setHihokenshaNo(主キー名1);
            JukyushaGendoGakuKanriEntity.setShikibetsuKubun(主キー名2);
        }

//TODO 主キー名を置換してください
        @Test(expected = NullPointerException.class)
        public void 主キー名1がnullである場合に_NullPointerExceptionが発生する() {
            sut = new JukyushaGendoGakuKanri(null, 主キー名2, 主キー名3, 主キー名4);
        }

        @Test(expected = NullPointerException.class)
        public void 主キー名2がnullである場合に_NullPointerExceptionが発生する() {
            sut = new JukyushaGendoGakuKanri(主キー名1, null, 主キー名3, 主キー名4);
        }

        @Test
        public void 指定したキーが保持するDbT7116JukyushaGendoGakuKanriEntityにセットされている() {
            sut = new JukyushaGendoGakuKanri(主キー名1, 主キー名2, 主キー名3, 主キー名4);
            assertThat(sut.get被保険者番号(), is(主キー名1));
            assertThat(sut.get識別区分(), is(主キー名2));
        }

        @Test
        public void 指定したキーが保持するJukyushaGendoGakuKanriIdentifierにセットされている() {
            sut = new JukyushaGendoGakuKanri(主キー名1, 主キー名2, 主キー名3, 主キー名4);
            assertThat(sut.identifier().get被保険者番号(), is(主キー名1));
            assertThat(sut.identifier().get識別区分(), is(主キー名2));
        }
    }

    public static class Entityコンストラクタテスト extends DbcTestBase {

        private static JukyushaGendoGakuKanri sut;

        @Before
        public void setUp() {
            JukyushaGendoGakuKanriEntity = DbT7116JukyushaGendoGakuKanriEntityGenerator.createDbT7116JukyushaGendoGakuKanriEntity();
            JukyushaGendoGakuKanriEntity.setHihokenshaNo(主キー名1);
            JukyushaGendoGakuKanriEntity.setShikibetsuKubun(主キー名2);
        }

        @Test(expected = NullPointerException.class)
        public void 指定したEntityがnullである場合_NullPointerExceptionとなる() {
            sut = new JukyushaGendoGakuKanri(null);
        }

        @Test
        public void 指定したDbT7116JukyushaGendoGakuKanriEntityのキー情報を識別子が持つ() {

            sut = new JukyushaGendoGakuKanri(JukyushaGendoGakuKanriEntity);

            assertThat(sut.identifier().get被保険者番号(), is(主キー名1));
            assertThat(sut.identifier().get識別区分(), is(主キー名2));
        }
    }

    public static class getterテスト extends DbcTestBase {

        private static JukyushaGendoGakuKanri sut;

        @Before
        public void setUp() {
            JukyushaGendoGakuKanriEntity = DbT7116JukyushaGendoGakuKanriEntityGenerator.createDbT7116JukyushaGendoGakuKanriEntity();
            JukyushaGendoGakuKanriEntity.setHihokenshaNo(主キー名1);
            JukyushaGendoGakuKanriEntity.setShikibetsuKubun(主キー名2);

            sut = new JukyushaGendoGakuKanri(JukyushaGendoGakuKanriEntity);
        }

        @Test
        public void get被保険者番号は_entityが持つ被保険者番号を返す() {
            assertThat(sut.get被保険者番号(), is(JukyushaGendoGakuKanriEntity.getHihokenshaNo()));
        }

        @Test
        public void get識別区分は_entityが持つ識別区分を返す() {
            assertThat(sut.get識別区分(), is(JukyushaGendoGakuKanriEntity.getShikibetsuKubun()));
        }

        @Test
        public void get有効開始年月は_entityが持つ有効開始年月を返す() {
            assertThat(sut.get有効開始年月(), is(JukyushaGendoGakuKanriEntity.getYukoKaishiYM()));
        }

        @Test
        public void get履歴番号は_entityが持つ履歴番号を返す() {
            assertThat(sut.get履歴番号(), is(JukyushaGendoGakuKanriEntity.getRirekiNo()));
        }

        @Test
        public void get有効終了年月は_entityが持つ有効終了年月を返す() {
            assertThat(sut.get有効終了年月(), is(JukyushaGendoGakuKanriEntity.getYukoShuryoYM()));
        }

        @Test
        public void get要介護状態区分は_entityが持つ要介護状態区分を返す() {
            assertThat(sut.get要介護状態区分(), is(JukyushaGendoGakuKanriEntity.getYoKaigoJotaiKubun()));
        }

        @Test
        public void get拡大倍数は_entityが持つ拡大倍数を返す() {
            assertThat(sut.get拡大倍数(), is(JukyushaGendoGakuKanriEntity.getKakudaiBaisu()));
        }

        @Test
        public void get切り分け単位数は_entityが持つ切り分け単位数を返す() {
            assertThat(sut.get切り分け単位数(), is(JukyushaGendoGakuKanriEntity.getKiriwakeTaniSu()));
        }

        @Test
        public void get登録年月日は_entityが持つ登録年月日を返す() {
            assertThat(sut.get登録年月日(), is(JukyushaGendoGakuKanriEntity.getTorokuYMD()));
        }

        @Test
        public void get変更年月日は_entityが持つ変更年月日を返す() {
            assertThat(sut.get変更年月日(), is(JukyushaGendoGakuKanriEntity.getHenkoYMD()));
        }

        @Test
        public void get限度額管理期間数は_entityが持つ限度額管理期間数を返す() {
            assertThat(sut.get限度額管理期間数(), is(JukyushaGendoGakuKanriEntity.getGendoGakuKanriKikanSu()));
        }

        @Test
        public void get新体系管理区分は_entityが持つ新体系管理区分を返す() {
            assertThat(sut.get新体系管理区分(), is(JukyushaGendoGakuKanriEntity.getShinTaikeiKanriKubun()));
        }

        @Test
        public void get新体系拡大適用有無は_entityが持つ新体系拡大適用有無を返す() {
            assertThat(sut.get新体系拡大適用有無(), is(JukyushaGendoGakuKanriEntity.getShinTaikeiKakudaiTekiyoUmu()));
        }
    }

    public static class toEntityテスト extends DbcTestBase {

        private static JukyushaGendoGakuKanri sut;

        @Before
        public void setUp() {
            JukyushaGendoGakuKanriEntity = DbT7116JukyushaGendoGakuKanriEntityGenerator.createDbT7116JukyushaGendoGakuKanriEntity();
            JukyushaGendoGakuKanriEntity.setHihokenshaNo(主キー名1);
            JukyushaGendoGakuKanriEntity.setShikibetsuKubun(主キー名2);

            sut = new JukyushaGendoGakuKanri(JukyushaGendoGakuKanriEntity);
        }

        @Test
        public void toEntityはコンストラクタで設定したentityと異なるインスタンスを返す() {
            assertThat(sut.toEntity(), not(JukyushaGendoGakuKanriEntity));
        }
    }

    public static class SerializationProxyテスト extends DbcTestBase {

        private static JukyushaGendoGakuKanri sut;

        @Before
        public void setUp() {
            JukyushaGendoGakuKanriEntity = DbT7116JukyushaGendoGakuKanriEntityGenerator.createDbT7116JukyushaGendoGakuKanriEntity();
            JukyushaGendoGakuKanriEntity.setHihokenshaNo(主キー名1);
            JukyushaGendoGakuKanriEntity.setShikibetsuKubun(主キー名2);

            sut = new JukyushaGendoGakuKanri(JukyushaGendoGakuKanriEntity);
        }

//        @Test
//        public void シリアライズできる() {
//            assertThat(sut, is(serializable()));
//        }
    }

    public static class deletedテスト extends DbcTestBase {

        private static JukyushaGendoGakuKanri sut;
        private static JukyushaGendoGakuKanri result;

        @Before
        public void setUp() {
            JukyushaGendoGakuKanriEntity = DbT7116JukyushaGendoGakuKanriEntityGenerator.createDbT7116JukyushaGendoGakuKanriEntity();
            JukyushaGendoGakuKanriEntity.setHihokenshaNo(主キー名1);
            JukyushaGendoGakuKanriEntity.setShikibetsuKubun(主キー名2);

        }

        @Test
        public void JukyushaGendoGakuKanriが保持するDbT7116JukyushaGendoGakuKanriEntityのEntityDataStateがUnchangedである場合_deletedメソッド_によりJukyushaGendoGakuKanriが保持するDbT7116JukyushaGendoGakuKanriEntityのEntityDataStateがDeletedに指定されたJukyushaGendoGakuKanriが返る() {
            sut = TestSupport.setStateJukyushaGendoGakuKanri(EntityDataState.Unchanged);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void JukyushaGendoGakuKanriが保持するDbT7116JukyushaGendoGakuKanriEntityのEntityDataStateがModifiedである場合_deletedメソッド_によりJukyushaGendoGakuKanriが保持するDbT7116JukyushaGendoGakuKanriEntityのEntityDataStateがDeletedに指定されたJukyushaGendoGakuKanriが返る() {
            sut = TestSupport.setStateJukyushaGendoGakuKanri(EntityDataState.Modified);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void JukyushaGendoGakuKanriが保持するDbT7116JukyushaGendoGakuKanriEntityのEntityDataStateがDeletedである場合_deletedメソッド_によりJukyushaGendoGakuKanriが保持するDbT7116JukyushaGendoGakuKanriEntityのEntityDataStateがDeletedに指定されたJukyushaGendoGakuKanriが返る() {
            sut = TestSupport.setStateJukyushaGendoGakuKanri(EntityDataState.Deleted);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test(expected = IllegalStateException.class)
        public void JukyushaGendoGakuKanriが保持するDbT7116JukyushaGendoGakuKanriEntityのEntityDataStateがAddedである場合_deletedメソッド_により_IllegalStateExceptionが発火する() {
            sut = TestSupport.setStateJukyushaGendoGakuKanri(EntityDataState.Added);
            result = sut.deleted();
        }
    }

    private static class TestSupport {

        public static JukyushaGendoGakuKanri setStateJukyushaGendoGakuKanri(EntityDataState parentState) {
            JukyushaGendoGakuKanriEntity.setState(parentState);
            return new JukyushaGendoGakuKanri(JukyushaGendoGakuKanriEntity);
        }
    }
}
