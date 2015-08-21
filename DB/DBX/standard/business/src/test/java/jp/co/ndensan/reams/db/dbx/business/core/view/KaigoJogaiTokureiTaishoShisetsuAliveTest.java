/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.business.core.view;

import jp.co.ndensan.reams.db.dbx.entity.basic.DbV1005KaigoJogaiTokureiTaishoShisetsuEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.helper.DbV1005KaigoJogaiTokureiTaishoShisetsuEntityGenerator;
import jp.co.ndensan.reams.db.dbx.testhelper.DbxTestBase;
import static jp.co.ndensan.reams.db.dbx.testhelper.matcher.IsSerializable.serializable;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
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
 * {@link KaigoJogaiTokureiTaishoShisetsuAlive}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class KaigoJogaiTokureiTaishoShisetsuAliveTest extends DbxTestBase {

    private static DbV1005KaigoJogaiTokureiTaishoShisetsuEntity KaigoJogaiTokureiTaishoShisetsuAliveEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static RString 主キー名1;
    private static RString 主キー名2;
    private static FlexibleDate yukoKaishiYMD;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        主キー名1 = DbV1005KaigoJogaiTokureiTaishoShisetsuEntityGenerator.DEFAULT_事業者種別;
        主キー名2 = DbV1005KaigoJogaiTokureiTaishoShisetsuEntityGenerator.DEFAULT_事業者番号;
    }

    public static class 主キーコンストラクタテスト extends DbxTestBase {

        private static KaigoJogaiTokureiTaishoShisetsuAlive sut;

        @Before
        public void setUp() {
            KaigoJogaiTokureiTaishoShisetsuAliveEntity = DbV1005KaigoJogaiTokureiTaishoShisetsuEntityGenerator.createDbV1005KaigoJogaiTokureiTaishoShisetsuEntity();
            KaigoJogaiTokureiTaishoShisetsuAliveEntity.setJigyoshaShubetsu(主キー名1);
            KaigoJogaiTokureiTaishoShisetsuAliveEntity.setJigyoshaNo(主キー名2);
        }

//TODO 主キー名を置換してください
        @Test(expected = NullPointerException.class)
        public void 主キー名1がnullである場合に_NullPointerExceptionが発生する() {
            sut = new KaigoJogaiTokureiTaishoShisetsuAlive(null, 主キー名2, yukoKaishiYMD);
        }

        @Test(expected = NullPointerException.class)
        public void 主キー名2がnullである場合に_NullPointerExceptionが発生する() {
            sut = new KaigoJogaiTokureiTaishoShisetsuAlive(主キー名1, null, yukoKaishiYMD);
        }

        @Test
        public void 指定したキーが保持するDbV1005KaigoJogaiTokureiTaishoShisetsuEntityにセットされている() {
            sut = new KaigoJogaiTokureiTaishoShisetsuAlive(主キー名1, 主キー名2, yukoKaishiYMD);
            assertThat(sut.get事業者種別(), is(主キー名1));
            assertThat(sut.get事業者番号(), is(主キー名2));
        }

        @Test
        public void 指定したキーが保持するKaigoJogaiTokureiTaishoShisetsuAliveIdentifierにセットされている() {
            sut = new KaigoJogaiTokureiTaishoShisetsuAlive(主キー名1, 主キー名2, yukoKaishiYMD);
            assertThat(sut.identifier().get事業者種別(), is(主キー名1));
            assertThat(sut.identifier().get事業者番号(), is(主キー名2));
        }
    }

    public static class Entityコンストラクタテスト extends DbxTestBase {

        private static KaigoJogaiTokureiTaishoShisetsuAlive sut;

        @Before
        public void setUp() {
            KaigoJogaiTokureiTaishoShisetsuAliveEntity = DbV1005KaigoJogaiTokureiTaishoShisetsuEntityGenerator.createDbV1005KaigoJogaiTokureiTaishoShisetsuEntity();
            KaigoJogaiTokureiTaishoShisetsuAliveEntity.setJigyoshaShubetsu(主キー名1);
            KaigoJogaiTokureiTaishoShisetsuAliveEntity.setJigyoshaNo(主キー名2);
        }

        @Test(expected = NullPointerException.class)
        public void 指定したEntityがnullである場合_NullPointerExceptionとなる() {
            sut = new KaigoJogaiTokureiTaishoShisetsuAlive(null);
        }

        @Test
        public void 指定したDbV1005KaigoJogaiTokureiTaishoShisetsuEntityのキー情報を識別子が持つ() {

            sut = new KaigoJogaiTokureiTaishoShisetsuAlive(KaigoJogaiTokureiTaishoShisetsuAliveEntity);

            assertThat(sut.identifier().get事業者種別(), is(主キー名1));
            assertThat(sut.identifier().get事業者番号(), is(主キー名2));
        }
    }

    public static class getterテスト extends DbxTestBase {

        private static KaigoJogaiTokureiTaishoShisetsuAlive sut;

        @Before
        public void setUp() {
            KaigoJogaiTokureiTaishoShisetsuAliveEntity = DbV1005KaigoJogaiTokureiTaishoShisetsuEntityGenerator.createDbV1005KaigoJogaiTokureiTaishoShisetsuEntity();
            KaigoJogaiTokureiTaishoShisetsuAliveEntity.setJigyoshaShubetsu(主キー名1);
            KaigoJogaiTokureiTaishoShisetsuAliveEntity.setJigyoshaNo(主キー名2);

            sut = new KaigoJogaiTokureiTaishoShisetsuAlive(KaigoJogaiTokureiTaishoShisetsuAliveEntity);
        }

        @Test
        public void get事業者種別は_entityが持つ事業者種別を返す() {
            assertThat(sut.get事業者種別(), is(KaigoJogaiTokureiTaishoShisetsuAliveEntity.getJigyoshaShubetsu()));
        }

        @Test
        public void get事業者番号は_entityが持つ事業者番号を返す() {
            assertThat(sut.get事業者番号(), is(KaigoJogaiTokureiTaishoShisetsuAliveEntity.getJigyoshaNo()));
        }

        @Test
        public void get有効開始年月日は_entityが持つ有効開始年月日を返す() {
            assertThat(sut.get有効開始年月日(), is(KaigoJogaiTokureiTaishoShisetsuAliveEntity.getYukoKaishiYMD()));
        }

        @Test
        public void get有効終了年月日は_entityが持つ有効終了年月日を返す() {
            assertThat(sut.get有効終了年月日(), is(KaigoJogaiTokureiTaishoShisetsuAliveEntity.getYukoShuryoYMD()));
        }

        @Test
        public void get管内管外区分は_entityが持つ管内管外区分を返す() {
            assertThat(sut.get管内管外区分(), is(KaigoJogaiTokureiTaishoShisetsuAliveEntity.getKannaiKangaiKubun()));
        }

        @Test
        public void get事業者名称は_entityが持つ事業者名称を返す() {
            assertThat(sut.get事業者名称(), is(KaigoJogaiTokureiTaishoShisetsuAliveEntity.getJigyoshaMeisho()));
        }

        @Test
        public void get事業者名称カナは_entityが持つ事業者名称カナを返す() {
            assertThat(sut.get事業者名称カナ(), is(KaigoJogaiTokureiTaishoShisetsuAliveEntity.getJigyoshaKanaMeisho()));
        }

        @Test
        public void get郵便番号は_entityが持つ郵便番号を返す() {
            assertThat(sut.get郵便番号(), is(KaigoJogaiTokureiTaishoShisetsuAliveEntity.getYubinNo()));
        }

        @Test
        public void get事業者住所は_entityが持つ事業者住所を返す() {
            assertThat(sut.get事業者住所(), is(KaigoJogaiTokureiTaishoShisetsuAliveEntity.getJigyoshaJusho()));
        }

        @Test
        public void get事業者住所カナは_entityが持つ事業者住所カナを返す() {
            assertThat(sut.get事業者住所カナ(), is(KaigoJogaiTokureiTaishoShisetsuAliveEntity.getJigyoshaKanaJusho()));
        }

        @Test
        public void get電話番号は_entityが持つ電話番号を返す() {
            assertThat(sut.get電話番号(), is(KaigoJogaiTokureiTaishoShisetsuAliveEntity.getTelNo()));
        }

        @Test
        public void getFAX番号は_entityが持つFAX番号を返す() {
            assertThat(sut.getFAX番号(), is(KaigoJogaiTokureiTaishoShisetsuAliveEntity.getFaxNo()));
        }

        @Test
        public void get異動事由は_entityが持つ異動事由を返す() {
            assertThat(sut.get異動事由(), is(KaigoJogaiTokureiTaishoShisetsuAliveEntity.getIdoJiyuCode()));
        }

        @Test
        public void get異動年月日は_entityが持つ異動年月日を返す() {
            assertThat(sut.get異動年月日(), is(KaigoJogaiTokureiTaishoShisetsuAliveEntity.getIdoYMD()));
        }

        @Test
        public void get代表者名称は_entityが持つ代表者名称を返す() {
            assertThat(sut.get代表者名称(), is(KaigoJogaiTokureiTaishoShisetsuAliveEntity.getDaihyoshaMeisho()));
        }

        @Test
        public void get代表者名称カナは_entityが持つ代表者名称カナを返す() {
            assertThat(sut.get代表者名称カナ(), is(KaigoJogaiTokureiTaishoShisetsuAliveEntity.getDaihyoshaKanaMeisho()));
        }

        @Test
        public void get役職は_entityが持つ役職を返す() {
            assertThat(sut.get役職(), is(KaigoJogaiTokureiTaishoShisetsuAliveEntity.getYakushoku()));
        }

        @Test
        public void get備考は_entityが持つ備考を返す() {
            assertThat(sut.get備考(), is(KaigoJogaiTokureiTaishoShisetsuAliveEntity.getBiko()));
        }

        @Test
        public void get事業開始年月日は_entityが持つ事業開始年月日を返す() {
            assertThat(sut.get事業開始年月日(), is(KaigoJogaiTokureiTaishoShisetsuAliveEntity.getJigyoKaishiYMD()));
        }

        @Test
        public void get事業休止年月日は_entityが持つ事業休止年月日を返す() {
            assertThat(sut.get事業休止年月日(), is(KaigoJogaiTokureiTaishoShisetsuAliveEntity.getJigyoKyushiYMD()));
        }

        @Test
        public void get事業廃止年月日は_entityが持つ事業廃止年月日を返す() {
            assertThat(sut.get事業廃止年月日(), is(KaigoJogaiTokureiTaishoShisetsuAliveEntity.getJigyoHaishiYMD()));
        }

        @Test
        public void get事業再開年月日は_entityが持つ事業再開年月日を返す() {
            assertThat(sut.get事業再開年月日(), is(KaigoJogaiTokureiTaishoShisetsuAliveEntity.getJigyoSaikaiYMD()));
        }
    }

    public static class toEntityテスト extends DbxTestBase {

        private static KaigoJogaiTokureiTaishoShisetsuAlive sut;

        @Before
        public void setUp() {
            KaigoJogaiTokureiTaishoShisetsuAliveEntity = DbV1005KaigoJogaiTokureiTaishoShisetsuEntityGenerator.createDbV1005KaigoJogaiTokureiTaishoShisetsuEntity();
            KaigoJogaiTokureiTaishoShisetsuAliveEntity.setJigyoshaShubetsu(主キー名1);
            KaigoJogaiTokureiTaishoShisetsuAliveEntity.setJigyoshaNo(主キー名2);

            sut = new KaigoJogaiTokureiTaishoShisetsuAlive(KaigoJogaiTokureiTaishoShisetsuAliveEntity);
        }

        @Test
        public void toEntityはコンストラクタで設定したentityと異なるインスタンスを返す() {
            assertThat(sut.toEntity(), not(KaigoJogaiTokureiTaishoShisetsuAliveEntity));
        }
    }

    public static class SerializationProxyテスト extends DbxTestBase {

        private static KaigoJogaiTokureiTaishoShisetsuAlive sut;

        @Before
        public void setUp() {
            KaigoJogaiTokureiTaishoShisetsuAliveEntity = DbV1005KaigoJogaiTokureiTaishoShisetsuEntityGenerator.createDbV1005KaigoJogaiTokureiTaishoShisetsuEntity();
            KaigoJogaiTokureiTaishoShisetsuAliveEntity.setJigyoshaShubetsu(主キー名1);
            KaigoJogaiTokureiTaishoShisetsuAliveEntity.setJigyoshaNo(主キー名2);

            sut = new KaigoJogaiTokureiTaishoShisetsuAlive(KaigoJogaiTokureiTaishoShisetsuAliveEntity);
        }

        @Test
        public void シリアライズできる() {
            assertThat(sut, is(serializable()));
        }
    }

    public static class deletedテスト extends DbxTestBase {

        private static KaigoJogaiTokureiTaishoShisetsuAlive sut;
        private static KaigoJogaiTokureiTaishoShisetsuAlive result;

        @Before
        public void setUp() {
            KaigoJogaiTokureiTaishoShisetsuAliveEntity = DbV1005KaigoJogaiTokureiTaishoShisetsuEntityGenerator.createDbV1005KaigoJogaiTokureiTaishoShisetsuEntity();
            KaigoJogaiTokureiTaishoShisetsuAliveEntity.setJigyoshaShubetsu(主キー名1);
            KaigoJogaiTokureiTaishoShisetsuAliveEntity.setJigyoshaNo(主キー名2);

        }

        @Test
        public void KaigoJogaiTokureiTaishoShisetsuAliveが保持するDbV1005KaigoJogaiTokureiTaishoShisetsuEntityのEntityDataStateがUnchangedである場合_deletedメソッド_によりKaigoJogaiTokureiTaishoShisetsuAliveが保持するDbV1005KaigoJogaiTokureiTaishoShisetsuEntityのEntityDataStateがDeletedに指定されたKaigoJogaiTokureiTaishoShisetsuAliveが返る() {
            sut = TestSupport.setStateKaigoJogaiTokureiTaishoShisetsuAlive(EntityDataState.Unchanged);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void KaigoJogaiTokureiTaishoShisetsuAliveが保持するDbV1005KaigoJogaiTokureiTaishoShisetsuEntityのEntityDataStateがModifiedである場合_deletedメソッド_によりKaigoJogaiTokureiTaishoShisetsuAliveが保持するDbV1005KaigoJogaiTokureiTaishoShisetsuEntityのEntityDataStateがDeletedに指定されたKaigoJogaiTokureiTaishoShisetsuAliveが返る() {
            sut = TestSupport.setStateKaigoJogaiTokureiTaishoShisetsuAlive(EntityDataState.Modified);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void KaigoJogaiTokureiTaishoShisetsuAliveが保持するDbV1005KaigoJogaiTokureiTaishoShisetsuEntityのEntityDataStateがDeletedである場合_deletedメソッド_によりKaigoJogaiTokureiTaishoShisetsuAliveが保持するDbV1005KaigoJogaiTokureiTaishoShisetsuEntityのEntityDataStateがDeletedに指定されたKaigoJogaiTokureiTaishoShisetsuAliveが返る() {
            sut = TestSupport.setStateKaigoJogaiTokureiTaishoShisetsuAlive(EntityDataState.Deleted);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test(expected = IllegalStateException.class)
        public void KaigoJogaiTokureiTaishoShisetsuAliveが保持するDbV1005KaigoJogaiTokureiTaishoShisetsuEntityのEntityDataStateがAddedである場合_deletedメソッド_により_IllegalStateExceptionが発火する() {
            sut = TestSupport.setStateKaigoJogaiTokureiTaishoShisetsuAlive(EntityDataState.Added);
            result = sut.deleted();
        }
    }

    private static class TestSupport {

        public static KaigoJogaiTokureiTaishoShisetsuAlive setStateKaigoJogaiTokureiTaishoShisetsuAlive(EntityDataState parentState) {
            KaigoJogaiTokureiTaishoShisetsuAliveEntity.setState(parentState);
            return new KaigoJogaiTokureiTaishoShisetsuAlive(KaigoJogaiTokureiTaishoShisetsuAliveEntity);
        }
    }
}
