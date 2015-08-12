/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.testhelper.DbcTestBase;
import static jp.co.ndensan.reams.db.dbc.testhelper.matcher.IsSerializable.serializable;
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
 * {@link ShichosonTokubetsuKyufuJigyosha}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class ShichosonTokubetsuKyufuJigyoshaTest extends DbcTestBase {

    private static DbT3065ShichosonTokubetsuKyufuJigyoshaEntity ShichosonTokubetsuKyufuJigyoshaEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static 主キー型1 主キー名1;
    private static 主キー型2 主キー名2;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        主キー名1 = DbT3065ShichosonTokubetsuKyufuJigyoshaEntityGenerator.DEFAULT_主キー名1;
        主キー名2 = DbT3065ShichosonTokubetsuKyufuJigyoshaEntityGenerator.DEFAULT_主キー名2;
    }

    public static class 主キーコンストラクタテスト extends DbcTestBase {

        private static ShichosonTokubetsuKyufuJigyosha sut;

        @Before
        public void setUp() {
            ShichosonTokubetsuKyufuJigyoshaEntity = DbT3065ShichosonTokubetsuKyufuJigyoshaEntityGenerator.createDbT3065ShichosonTokubetsuKyufuJigyoshaEntity();
            ShichosonTokubetsuKyufuJigyoshaEntity.setXXX(主キー名1);
            ShichosonTokubetsuKyufuJigyoshaEntity.setXXX(主キー名2);
        }

//TODO 主キー名を置換してください
        @Test(expected = NullPointerException.class)
        public void 主キー名1がnullである場合に_NullPointerExceptionが発生する() {
            sut = new ShichosonTokubetsuKyufuJigyosha(null, 主キー名2);
        }

        @Test(expected = NullPointerException.class)
        public void 主キー名2がnullである場合に_NullPointerExceptionが発生する() {
            sut = new ShichosonTokubetsuKyufuJigyosha(主キー名1, null);
        }

        @Test
        public void 指定したキーが保持するDbT3065ShichosonTokubetsuKyufuJigyoshaEntityにセットされている() {
            sut = new ShichosonTokubetsuKyufuJigyosha(主キー名1, 主キー名2);
            assertThat(sut.get主キー名1(), is(主キー名1));
            assertThat(sut.get主キー名2(), is(主キー名2));
        }

        @Test
        public void 指定したキーが保持するShichosonTokubetsuKyufuJigyoshaIdentifierにセットされている() {
            sut = new ShichosonTokubetsuKyufuJigyosha(主キー名1, 主キー名2);
            assertThat(sut.identifier().getXXX(), is(主キー名1));
            assertThat(sut.identifier().getXXX(), is(主キー名2));
        }
    }

    public static class Entityコンストラクタテスト extends DbcTestBase {

        private static ShichosonTokubetsuKyufuJigyosha sut;

        @Before
        public void setUp() {
            ShichosonTokubetsuKyufuJigyoshaEntity = DbT3065ShichosonTokubetsuKyufuJigyoshaEntityGenerator.createDbT3065ShichosonTokubetsuKyufuJigyoshaEntity();
            ShichosonTokubetsuKyufuJigyoshaEntity.setXXX(主キー名1);
            ShichosonTokubetsuKyufuJigyoshaEntity.setXXX(主キー名2);
        }

        @Test(expected = NullPointerException.class)
        public void 指定したEntityがnullである場合_NullPointerExceptionとなる() {
            sut = new ShichosonTokubetsuKyufuJigyosha(null);
        }

        @Test
        public void 指定したDbT3065ShichosonTokubetsuKyufuJigyoshaEntityのキー情報を識別子が持つ() {

            sut = new ShichosonTokubetsuKyufuJigyosha(ShichosonTokubetsuKyufuJigyoshaEntity);

            assertThat(sut.identifier().getXXX(), is(主キー名1));
            assertThat(sut.identifier().getXXX(), is(主キー名2));
        }
    }

    public static class getterテスト extends DbcTestBase {

        private static ShichosonTokubetsuKyufuJigyosha sut;

        @Before
        public void setUp() {
            ShichosonTokubetsuKyufuJigyoshaEntity = DbT3065ShichosonTokubetsuKyufuJigyoshaEntityGenerator.createDbT3065ShichosonTokubetsuKyufuJigyoshaEntity();
            ShichosonTokubetsuKyufuJigyoshaEntity.setXXX(主キー名1);
            ShichosonTokubetsuKyufuJigyoshaEntity.setXXX(主キー名2);

            sut = new ShichosonTokubetsuKyufuJigyosha(ShichosonTokubetsuKyufuJigyoshaEntity);
        }

        @Test
        public void get市町村特別給付用事業者番号は_entityが持つ市町村特別給付用事業者番号を返す() {
            assertThat(sut.get市町村特別給付用事業者番号(), is(ShichosonTokubetsuKyufuJigyoshaEntity.getJigyoshaNo()));
        }

        @Test
        public void get市町村特別給付用サービスコードは_entityが持つ市町村特別給付用サービスコードを返す() {
            assertThat(sut.get市町村特別給付用サービスコード(), is(ShichosonTokubetsuKyufuJigyoshaEntity.getServiceCode()));
        }

        @Test
        public void get履歴番号は_entityが持つ履歴番号を返す() {
            assertThat(sut.get履歴番号(), is(ShichosonTokubetsuKyufuJigyoshaEntity.getRirekiNo()));
        }

        @Test
        public void get介護国保連ＩＦ異動区分は_entityが持つ介護国保連ＩＦ異動区分を返す() {
            assertThat(sut.get介護国保連ＩＦ異動区分(), is(ShichosonTokubetsuKyufuJigyoshaEntity.getIdoKubun()));
        }

        @Test
        public void get介護国保連ＩＦ異動年月日は_entityが持つ介護国保連ＩＦ異動年月日を返す() {
            assertThat(sut.get介護国保連ＩＦ異動年月日(), is(ShichosonTokubetsuKyufuJigyoshaEntity.getIdoYMD()));
        }

        @Test
        public void get介護国保連ＩＦ訂正区分は_entityが持つ介護国保連ＩＦ訂正区分を返す() {
            assertThat(sut.get介護国保連ＩＦ訂正区分(), is(ShichosonTokubetsuKyufuJigyoshaEntity.getTeiseiKubun()));
        }

        @Test
        public void get介護国保連ＩＦ訂正年月日は_entityが持つ介護国保連ＩＦ訂正年月日を返す() {
            assertThat(sut.get介護国保連ＩＦ訂正年月日(), is(ShichosonTokubetsuKyufuJigyoshaEntity.getTeiseiYMD()));
        }

        @Test
        public void get介護国保連ＩＦ法人種別は_entityが持つ介護国保連ＩＦ法人種別を返す() {
            assertThat(sut.get介護国保連ＩＦ法人種別(), is(ShichosonTokubetsuKyufuJigyoshaEntity.getHojinShubetsu()));
        }

        @Test
        public void get申請者氏名（漢字）は_entityが持つ申請者氏名（漢字）を返す() {
            assertThat(sut.get申請者氏名（漢字）(), is(ShichosonTokubetsuKyufuJigyoshaEntity.getShinseishaNameKanji()));
        }

        @Test
        public void get申請者氏名（カナ）は_entityが持つ申請者氏名（カナ）を返す() {
            assertThat(sut.get申請者氏名（カナ）(), is(ShichosonTokubetsuKyufuJigyoshaEntity.getShinseishaNameKana()));
        }

        @Test
        public void get申請者郵便番号は_entityが持つ申請者郵便番号を返す() {
            assertThat(sut.get申請者郵便番号(), is(ShichosonTokubetsuKyufuJigyoshaEntity.getShinseishaYubinNo()));
        }

        @Test
        public void get申請者住所は_entityが持つ申請者住所を返す() {
            assertThat(sut.get申請者住所(), is(ShichosonTokubetsuKyufuJigyoshaEntity.getShinseishaAddressKanji()));
        }

        @Test
        public void get申請者住所（カナ）は_entityが持つ申請者住所（カナ）を返す() {
            assertThat(sut.get申請者住所（カナ）(), is(ShichosonTokubetsuKyufuJigyoshaEntity.getShinseishaAddressKana()));
        }

        @Test
        public void get申請者電話番号は_entityが持つ申請者電話番号を返す() {
            assertThat(sut.get申請者電話番号(), is(ShichosonTokubetsuKyufuJigyoshaEntity.getShinseishaTelNo()));
        }

        @Test
        public void get申請者FAX番号は_entityが持つ申請者FAX番号を返す() {
            assertThat(sut.get申請者FAX番号(), is(ShichosonTokubetsuKyufuJigyoshaEntity.getShinseishaFaxNo()));
        }

        @Test
        public void get事業所代表者役職は_entityが持つ事業所代表者役職を返す() {
            assertThat(sut.get事業所代表者役職(), is(ShichosonTokubetsuKyufuJigyoshaEntity.getJigyoshoDaihyoshaYakushoku()));
        }

        @Test
        public void get事業所代表者氏名は_entityが持つ事業所代表者氏名を返す() {
            assertThat(sut.get事業所代表者氏名(), is(ShichosonTokubetsuKyufuJigyoshaEntity.getJigyoshoDaihyoshaNameKanji()));
        }

        @Test
        public void get事業所代表者氏名カナは_entityが持つ事業所代表者氏名カナを返す() {
            assertThat(sut.get事業所代表者氏名カナ(), is(ShichosonTokubetsuKyufuJigyoshaEntity.getJigyoshoDaihyoshaNameKana()));
        }

        @Test
        public void get事業所代表者郵便番号は_entityが持つ事業所代表者郵便番号を返す() {
            assertThat(sut.get事業所代表者郵便番号(), is(ShichosonTokubetsuKyufuJigyoshaEntity.getJigyoshoDaihyoshaYubinNo()));
        }

        @Test
        public void get事業所代表者住所は_entityが持つ事業所代表者住所を返す() {
            assertThat(sut.get事業所代表者住所(), is(ShichosonTokubetsuKyufuJigyoshaEntity.getJigyoshoDaihyoshaAddressKanji()));
        }

        @Test
        public void get事業所代表者住所カナは_entityが持つ事業所代表者住所カナを返す() {
            assertThat(sut.get事業所代表者住所カナ(), is(ShichosonTokubetsuKyufuJigyoshaEntity.getJigyoshoDaihyoshaAddressKana()));
        }

        @Test
        public void get事業所管理者氏名は_entityが持つ事業所管理者氏名を返す() {
            assertThat(sut.get事業所管理者氏名(), is(ShichosonTokubetsuKyufuJigyoshaEntity.getJigyoshoKanrishaNameKanji()));
        }

        @Test
        public void get事業所管理者氏名カナは_entityが持つ事業所管理者氏名カナを返す() {
            assertThat(sut.get事業所管理者氏名カナ(), is(ShichosonTokubetsuKyufuJigyoshaEntity.getJigyoshoKanrishaNameKana()));
        }

        @Test
        public void get事業所管理者郵便番号は_entityが持つ事業所管理者郵便番号を返す() {
            assertThat(sut.get事業所管理者郵便番号(), is(ShichosonTokubetsuKyufuJigyoshaEntity.getJigyoshoKanrishaYubinNo()));
        }

        @Test
        public void get事業所管理者住所は_entityが持つ事業所管理者住所を返す() {
            assertThat(sut.get事業所管理者住所(), is(ShichosonTokubetsuKyufuJigyoshaEntity.getJigyoshoKanrishaAddressKanji()));
        }

        @Test
        public void get事業所管理者住所カナは_entityが持つ事業所管理者住所カナを返す() {
            assertThat(sut.get事業所管理者住所カナ(), is(ShichosonTokubetsuKyufuJigyoshaEntity.getJigyoshoKanrishaAddressKana()));
        }

        @Test
        public void getサービス事業所名は_entityが持つサービス事業所名を返す() {
            assertThat(sut.getサービス事業所名(), is(ShichosonTokubetsuKyufuJigyoshaEntity.getServiceJigyoshoNameKanji()));
        }

        @Test
        public void getサービス事業所名カナは_entityが持つサービス事業所名カナを返す() {
            assertThat(sut.getサービス事業所名カナ(), is(ShichosonTokubetsuKyufuJigyoshaEntity.getServiceJigyoshoNameKana()));
        }

        @Test
        public void getサービス事業所郵便番号は_entityが持つサービス事業所郵便番号を返す() {
            assertThat(sut.getサービス事業所郵便番号(), is(ShichosonTokubetsuKyufuJigyoshaEntity.getServiceJigyoshoYubinNo()));
        }

        @Test
        public void getサービス事業所住所は_entityが持つサービス事業所住所を返す() {
            assertThat(sut.getサービス事業所住所(), is(ShichosonTokubetsuKyufuJigyoshaEntity.getServiceJigyoshoAddressKanji()));
        }

        @Test
        public void getサービス事業所住所カナは_entityが持つサービス事業所住所カナを返す() {
            assertThat(sut.getサービス事業所住所カナ(), is(ShichosonTokubetsuKyufuJigyoshaEntity.getServiceJigyoshoAddressKana()));
        }

        @Test
        public void getサービス事業所電話番号は_entityが持つサービス事業所電話番号を返す() {
            assertThat(sut.getサービス事業所電話番号(), is(ShichosonTokubetsuKyufuJigyoshaEntity.getServiceJigyoshoTelNo()));
        }

        @Test
        public void getサービス事業所FAX番号は_entityが持つサービス事業所FAX番号を返す() {
            assertThat(sut.getサービス事業所FAX番号(), is(ShichosonTokubetsuKyufuJigyoshaEntity.getServiceJigyoshoFaxNo()));
        }

        @Test
        public void getサービス事業所事業開始年月日は_entityが持つサービス事業所事業開始年月日を返す() {
            assertThat(sut.getサービス事業所事業開始年月日(), is(ShichosonTokubetsuKyufuJigyoshaEntity.getServiceJigyoshoJigyoKaisiYMD()));
        }

        @Test
        public void getサービス事業所事業休止年月日は_entityが持つサービス事業所事業休止年月日を返す() {
            assertThat(sut.getサービス事業所事業休止年月日(), is(ShichosonTokubetsuKyufuJigyoshaEntity.getServiceJigyoshoJigyoKyushiYMD()));
        }

        @Test
        public void getサービス事業所事業廃止年月日は_entityが持つサービス事業所事業廃止年月日を返す() {
            assertThat(sut.getサービス事業所事業廃止年月日(), is(ShichosonTokubetsuKyufuJigyoshaEntity.getServiceJigyoshoJigyoHaishiYMD()));
        }

        @Test
        public void getサービス事業所事業再開年月日は_entityが持つサービス事業所事業再開年月日を返す() {
            assertThat(sut.getサービス事業所事業再開年月日(), is(ShichosonTokubetsuKyufuJigyoshaEntity.getServiceJigyoshoJigyoSaikaiYMD()));
        }

        @Test
        public void get介護保険証記載保険者番号は_entityが持つ介護保険証記載保険者番号を返す() {
            assertThat(sut.get介護保険証記載保険者番号(), is(ShichosonTokubetsuKyufuJigyoshaEntity.getShokisaiHokenshaNo()));
        }

        @Test
        public void get受領委任区分は_entityが持つ受領委任区分を返す() {
            assertThat(sut.get受領委任区分(), is(ShichosonTokubetsuKyufuJigyoshaEntity.getJuryoIninKubu()));
        }

        @Test
        public void get市町村特別給付登録開始年月日は_entityが持つ市町村特別給付登録開始年月日を返す() {
            assertThat(sut.get市町村特別給付登録開始年月日(), is(ShichosonTokubetsuKyufuJigyoshaEntity.getTorokuKaishiYMD()));
        }

        @Test
        public void get市町村特別給付登録終了年月日は_entityが持つ市町村特別給付登録終了年月日を返す() {
            assertThat(sut.get市町村特別給付登録終了年月日(), is(ShichosonTokubetsuKyufuJigyoshaEntity.getTorokuShuryoYMD()));
        }

        @Test
        public void get生活保護法による指定の有は_entityが持つ生活保護法による指定の有を返す() {
            assertThat(sut.get生活保護法による指定の有(), is(ShichosonTokubetsuKyufuJigyoshaEntity.getSeikatsuhogoShiteiFlag()));
        }

        @Test
        public void get市町村コードは_entityが持つ市町村コードを返す() {
            assertThat(sut.get市町村コード(), is(ShichosonTokubetsuKyufuJigyoshaEntity.getShichosonCode()));
        }

        @Test
        public void get地域区分は_entityが持つ地域区分を返す() {
            assertThat(sut.get地域区分(), is(ShichosonTokubetsuKyufuJigyoshaEntity.getChiikiKubun()));
        }
    }

    public static class toEntityテスト extends DbcTestBase {

        private static ShichosonTokubetsuKyufuJigyosha sut;

        @Before
        public void setUp() {
            ShichosonTokubetsuKyufuJigyoshaEntity = DbT3065ShichosonTokubetsuKyufuJigyoshaEntityGenerator.createDbT3065ShichosonTokubetsuKyufuJigyoshaEntity();
            ShichosonTokubetsuKyufuJigyoshaEntity.setXXX(主キー名1);
            ShichosonTokubetsuKyufuJigyoshaEntity.setXXX(主キー名2);

            sut = new ShichosonTokubetsuKyufuJigyosha(ShichosonTokubetsuKyufuJigyoshaEntity);
        }

        @Test
        public void toEntityはコンストラクタで設定したentityと異なるインスタンスを返す() {
            assertThat(sut.toEntity(), not(ShichosonTokubetsuKyufuJigyoshaEntity));
        }
    }

    public static class SerializationProxyテスト extends DbcTestBase {

        private static ShichosonTokubetsuKyufuJigyosha sut;

        @Before
        public void setUp() {
            ShichosonTokubetsuKyufuJigyoshaEntity = DbT3065ShichosonTokubetsuKyufuJigyoshaEntityGenerator.createDbT3065ShichosonTokubetsuKyufuJigyoshaEntity();
            ShichosonTokubetsuKyufuJigyoshaEntity.setXXX(主キー名1);
            ShichosonTokubetsuKyufuJigyoshaEntity.setXXX(主キー名2);

            sut = new ShichosonTokubetsuKyufuJigyosha(ShichosonTokubetsuKyufuJigyoshaEntity);
        }

        @Test
        public void シリアライズできる() {
            assertThat(sut, is(serializable()));
        }
    }

    public static class deletedテスト extends DbcTestBase {

        private static ShichosonTokubetsuKyufuJigyosha sut;
        private static ShichosonTokubetsuKyufuJigyosha result;

        @Before
        public void setUp() {
            ShichosonTokubetsuKyufuJigyoshaEntity = DbT3065ShichosonTokubetsuKyufuJigyoshaEntityGenerator.createDbT3065ShichosonTokubetsuKyufuJigyoshaEntity();
            ShichosonTokubetsuKyufuJigyoshaEntity.setXXX(主キー名1);
            ShichosonTokubetsuKyufuJigyoshaEntity.setXXX(主キー名2);

        }

        @Test
        public void ShichosonTokubetsuKyufuJigyoshaが保持するDbT3065ShichosonTokubetsuKyufuJigyoshaEntityのEntityDataStateがUnchangedである場合_deletedメソッド_によりShichosonTokubetsuKyufuJigyoshaが保持するDbT3065ShichosonTokubetsuKyufuJigyoshaEntityのEntityDataStateがDeletedに指定されたShichosonTokubetsuKyufuJigyoshaが返る() {
            sut = TestSupport.setStateShichosonTokubetsuKyufuJigyosha(EntityDataState.Unchanged);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void ShichosonTokubetsuKyufuJigyoshaが保持するDbT3065ShichosonTokubetsuKyufuJigyoshaEntityのEntityDataStateがModifiedである場合_deletedメソッド_によりShichosonTokubetsuKyufuJigyoshaが保持するDbT3065ShichosonTokubetsuKyufuJigyoshaEntityのEntityDataStateがDeletedに指定されたShichosonTokubetsuKyufuJigyoshaが返る() {
            sut = TestSupport.setStateShichosonTokubetsuKyufuJigyosha(EntityDataState.Modified);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void ShichosonTokubetsuKyufuJigyoshaが保持するDbT3065ShichosonTokubetsuKyufuJigyoshaEntityのEntityDataStateがDeletedである場合_deletedメソッド_によりShichosonTokubetsuKyufuJigyoshaが保持するDbT3065ShichosonTokubetsuKyufuJigyoshaEntityのEntityDataStateがDeletedに指定されたShichosonTokubetsuKyufuJigyoshaが返る() {
            sut = TestSupport.setStateShichosonTokubetsuKyufuJigyosha(EntityDataState.Deleted);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test(expected = IllegalStateException.class)
        public void ShichosonTokubetsuKyufuJigyoshaが保持するDbT3065ShichosonTokubetsuKyufuJigyoshaEntityのEntityDataStateがAddedである場合_deletedメソッド_により_IllegalStateExceptionが発火する() {
            sut = TestSupport.setStateShichosonTokubetsuKyufuJigyosha(EntityDataState.Added);
            result = sut.deleted();
        }
    }

    private static class TestSupport {

        public static ShichosonTokubetsuKyufuJigyosha setStateShichosonTokubetsuKyufuJigyosha(EntityDataState parentState) {
            ShichosonTokubetsuKyufuJigyoshaEntity.setState(parentState);
            return new ShichosonTokubetsuKyufuJigyosha(ShichosonTokubetsuKyufuJigyoshaEntity);
        }
    }
}
