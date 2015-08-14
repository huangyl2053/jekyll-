/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import jp.co.ndensan.reams.db.dbz.business.core.TennyushutsuHoryuTaishosha;
import jp.co.ndensan.reams.db.dbz.business.helper.IsSerializable;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT1010TennyushutsuHoryuTaishoshaEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT1010TennyushutsuHoryuTaishoshaEntityGenerator;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
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
 * {@link TennyushutsuHoryuTaishosha}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class TennyushutsuHoryuTaishoshaTest extends DbzTestBase {

    private static DbT1010TennyushutsuHoryuTaishoshaEntity TennyushutsuHoryuTaishoshaEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static ShikibetsuCode 識別コード;
    private static Decimal 履歴番号;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        識別コード = DbT1010TennyushutsuHoryuTaishoshaEntityGenerator.DEFAULT_識別コード;
        履歴番号 = DbT1010TennyushutsuHoryuTaishoshaEntityGenerator.DEFAULT_履歴番号;
    }

    public static class 主キーコンストラクタテスト extends DbzTestBase {

        private static TennyushutsuHoryuTaishosha sut;

        @Before
        public void setUp() {
            TennyushutsuHoryuTaishoshaEntity = DbT1010TennyushutsuHoryuTaishoshaEntityGenerator.createDbT1010TennyushutsuHoryuTaishoshaEntity();
            TennyushutsuHoryuTaishoshaEntity.setShikibetsuCode(識別コード);
            TennyushutsuHoryuTaishoshaEntity.setRirekiNo(履歴番号);
        }

//TODO 主キー名を置換してください
        @Test(expected = NullPointerException.class)
        public void 主キー名1がnullである場合に_NullPointerExceptionが発生する() {
            sut = new TennyushutsuHoryuTaishosha(null, 履歴番号);
        }

        @Test(expected = NullPointerException.class)
        public void 主キー名2がnullである場合に_NullPointerExceptionが発生する() {
            sut = new TennyushutsuHoryuTaishosha(識別コード, null);
        }

        @Test
        public void 指定したキーが保持するDbT1010TennyushutsuHoryuTaishoshaEntityにセットされている() {
            sut = new TennyushutsuHoryuTaishosha(識別コード, 履歴番号);
            assertThat(sut.get識別コード(), is(識別コード));
            assertThat(sut.get履歴番号(), is(履歴番号));
        }

        @Test
        public void 指定したキーが保持するTennyushutsuHoryuTaishoshaIdentifierにセットされている() {
            sut = new TennyushutsuHoryuTaishosha(識別コード, 履歴番号);
//            assertThat(sut.identifier().get識別コード(), is(識別コード));
//            assertThat(sut.identifier().get履歴番号(), is(履歴番号));
        }
    }

    public static class Entityコンストラクタテスト extends DbzTestBase {

        private static TennyushutsuHoryuTaishosha sut;

        @Before
        public void setUp() {
            TennyushutsuHoryuTaishoshaEntity = DbT1010TennyushutsuHoryuTaishoshaEntityGenerator.createDbT1010TennyushutsuHoryuTaishoshaEntity();
            TennyushutsuHoryuTaishoshaEntity.setShikibetsuCode(識別コード);
            TennyushutsuHoryuTaishoshaEntity.setRirekiNo(履歴番号);
        }

        @Test(expected = NullPointerException.class)
        public void 指定したEntityがnullである場合_NullPointerExceptionとなる() {
            sut = new TennyushutsuHoryuTaishosha(null);
        }

        @Test
        public void 指定したDbT1010TennyushutsuHoryuTaishoshaEntityのキー情報を識別子が持つ() {

            sut = new TennyushutsuHoryuTaishosha(TennyushutsuHoryuTaishoshaEntity);

//            assertThat(sut.identifier().get識別コード(), is(識別コード));
//            assertThat(sut.identifier().get履歴番号(), is(履歴番号));
        }
    }

    public static class getterテスト extends DbzTestBase {

        private static TennyushutsuHoryuTaishosha sut;

        @Before
        public void setUp() {
            TennyushutsuHoryuTaishoshaEntity = DbT1010TennyushutsuHoryuTaishoshaEntityGenerator.createDbT1010TennyushutsuHoryuTaishoshaEntity();
            TennyushutsuHoryuTaishoshaEntity.setShikibetsuCode(識別コード);
            TennyushutsuHoryuTaishoshaEntity.setRirekiNo(履歴番号);

            sut = new TennyushutsuHoryuTaishosha(TennyushutsuHoryuTaishoshaEntity);
        }

        @Test
        public void get識別コードは_entityが持つ識別コードを返す() {
            assertThat(sut.get識別コード(), is(TennyushutsuHoryuTaishoshaEntity.getShikibetsuCode()));
        }

        @Test
        public void get履歴番号は_entityが持つ履歴番号を返す() {
            assertThat(sut.get履歴番号(), is(TennyushutsuHoryuTaishoshaEntity.getRirekiNo()));
        }

        @Test
        public void get市町村コードは_entityが持つ市町村コードを返す() {
            assertThat(sut.get市町村コード(), is(TennyushutsuHoryuTaishoshaEntity.getShichosonCode()));
        }

        @Test
        public void get作成事由コードは_entityが持つ作成事由コードを返す() {
            assertThat(sut.get作成事由コード(), is(TennyushutsuHoryuTaishoshaEntity.getSakuseiJiyuCode()));
        }

        @Test
        public void get世帯コードは_entityが持つ世帯コードを返す() {
            assertThat(sut.get世帯コード(), is(TennyushutsuHoryuTaishoshaEntity.getSetaiCode()));
        }

        @Test
        public void get住民種別コードは_entityが持つ住民種別コードを返す() {
            assertThat(sut.get住民種別コード(), is(TennyushutsuHoryuTaishoshaEntity.getJuminShubetsuCode()));
        }

        @Test
        public void get住民状態コードは_entityが持つ住民状態コードを返す() {
            assertThat(sut.get住民状態コード(), is(TennyushutsuHoryuTaishoshaEntity.getJuminJotaiCode()));
        }

        @Test
        public void get宛名氏名は_entityが持つ宛名氏名を返す() {
            assertThat(sut.get宛名氏名(), is(TennyushutsuHoryuTaishoshaEntity.getAtenaShimei()));
        }

        @Test
        public void get宛名カナ氏名は_entityが持つ宛名カナ氏名を返す() {
            assertThat(sut.get宛名カナ氏名(), is(TennyushutsuHoryuTaishoshaEntity.getAtenaKanaShimei()));
        }

        @Test
        public void get生年月日は_entityが持つ生年月日を返す() {
            assertThat(sut.get生年月日(), is(TennyushutsuHoryuTaishoshaEntity.getSeinengappiYMD()));
        }

        @Test
        public void get性別コードは_entityが持つ性別コードを返す() {
            assertThat(sut.get性別コード(), is(TennyushutsuHoryuTaishoshaEntity.getSeibetsuCode()));
        }

        @Test
        public void get異動事由コードは_entityが持つ異動事由コードを返す() {
            assertThat(sut.get異動事由コード(), is(TennyushutsuHoryuTaishoshaEntity.getIdoJiyuCode()));
        }

        @Test
        public void get登録異動年月日は_entityが持つ登録異動年月日を返す() {
            assertThat(sut.get登録異動年月日(), is(TennyushutsuHoryuTaishoshaEntity.getTorokuIdoYMD()));
        }

        @Test
        public void get登録届出年月日は_entityが持つ登録届出年月日を返す() {
            assertThat(sut.get登録届出年月日(), is(TennyushutsuHoryuTaishoshaEntity.getTorokuTodokedeYMD()));
        }

        @Test
        public void get消除異動年月日は_entityが持つ消除異動年月日を返す() {
            assertThat(sut.get消除異動年月日(), is(TennyushutsuHoryuTaishoshaEntity.getShojoIdoYMD()));
        }

        @Test
        public void get消除届出年月日は_entityが持つ消除届出年月日を返す() {
            assertThat(sut.get消除届出年月日(), is(TennyushutsuHoryuTaishoshaEntity.getShojoIdoTodokedeYMD()));
        }

        @Test
        public void get転出予定異動年月日は_entityが持つ転出予定異動年月日を返す() {
            assertThat(sut.get転出予定異動年月日(), is(TennyushutsuHoryuTaishoshaEntity.getTenshutsuYoteiIdoYMD()));
        }

        @Test
        public void get転出確定異動年月日は_entityが持つ転出確定異動年月日を返す() {
            assertThat(sut.get転出確定異動年月日(), is(TennyushutsuHoryuTaishoshaEntity.getTenshutsuKakuteiIdoYMD()));
        }

        @Test
        public void get転出確定異動通知年月日は_entityが持つ転出確定異動通知年月日を返す() {
            assertThat(sut.get転出確定異動通知年月日(), is(TennyushutsuHoryuTaishoshaEntity.getTenshutsuKakuteiIdoTsuchiYMD()));
        }

        @Test
        public void get全国住所コードは_entityが持つ全国住所コードを返す() {
            assertThat(sut.get全国住所コード(), is(TennyushutsuHoryuTaishoshaEntity.getZenkokuJushoCode()));
        }

        @Test
        public void get住所は_entityが持つ住所を返す() {
            assertThat(sut.get住所(), is(TennyushutsuHoryuTaishoshaEntity.getJusho()));
        }

        @Test
        public void get番地は_entityが持つ番地を返す() {
            assertThat(sut.get番地(), is(TennyushutsuHoryuTaishoshaEntity.getBanchi()));
        }

        @Test
        public void get方書は_entityが持つ方書を返す() {
            assertThat(sut.get方書(), is(TennyushutsuHoryuTaishoshaEntity.getKatagaki()));
        }

        @Test
        public void get転出予定全国住所コードは_entityが持つ転出予定全国住所コードを返す() {
            assertThat(sut.get転出予定全国住所コード(), is(TennyushutsuHoryuTaishoshaEntity.getTenshutsuYoteiZenkokuJushoCode()));
        }

        @Test
        public void get転出予定住所は_entityが持つ転出予定住所を返す() {
            assertThat(sut.get転出予定住所(), is(TennyushutsuHoryuTaishoshaEntity.getTenshutsuYoteiJusho()));
        }

        @Test
        public void get転出予定番地は_entityが持つ転出予定番地を返す() {
            assertThat(sut.get転出予定番地(), is(TennyushutsuHoryuTaishoshaEntity.getTenshutsuYoteiBanchi()));
        }

        @Test
        public void get転出予定方書は_entityが持つ転出予定方書を返す() {
            assertThat(sut.get転出予定方書(), is(TennyushutsuHoryuTaishoshaEntity.getTenshutsuYoteiKatagaki()));
        }

        @Test
        public void get転出確定全国住所コードは_entityが持つ転出確定全国住所コードを返す() {
            assertThat(sut.get転出確定全国住所コード(), is(TennyushutsuHoryuTaishoshaEntity.getTenshutsuKakuteiZenkokuJushoCode()));
        }

        @Test
        public void get転出確定住所は_entityが持つ転出確定住所を返す() {
            assertThat(sut.get転出確定住所(), is(TennyushutsuHoryuTaishoshaEntity.getTenshutsuKakuteiJusho()));
        }

        @Test
        public void get転出確定番地は_entityが持つ転出確定番地を返す() {
            assertThat(sut.get転出確定番地(), is(TennyushutsuHoryuTaishoshaEntity.getTenshutsuKakuteiBanchi()));
        }

        @Test
        public void get転出確定方書は_entityが持つ転出確定方書を返す() {
            assertThat(sut.get転出確定方書(), is(TennyushutsuHoryuTaishoshaEntity.getTenshutsuKakuteiKatagaki()));
        }
    }

    public static class toEntityテスト extends DbzTestBase {

        private static TennyushutsuHoryuTaishosha sut;

        @Before
        public void setUp() {
            TennyushutsuHoryuTaishoshaEntity = DbT1010TennyushutsuHoryuTaishoshaEntityGenerator.createDbT1010TennyushutsuHoryuTaishoshaEntity();
            TennyushutsuHoryuTaishoshaEntity.setShikibetsuCode(識別コード);
            TennyushutsuHoryuTaishoshaEntity.setRirekiNo(履歴番号);

            sut = new TennyushutsuHoryuTaishosha(TennyushutsuHoryuTaishoshaEntity);
        }

        @Test
        public void toEntityはコンストラクタで設定したentityと異なるインスタンスを返す() {
            assertThat(sut.toEntity(), not(TennyushutsuHoryuTaishoshaEntity));
        }
    }

    public static class SerializationProxyテスト extends DbzTestBase {

        private static TennyushutsuHoryuTaishosha sut;

        @Before
        public void setUp() {
            TennyushutsuHoryuTaishoshaEntity = DbT1010TennyushutsuHoryuTaishoshaEntityGenerator.createDbT1010TennyushutsuHoryuTaishoshaEntity();
            TennyushutsuHoryuTaishoshaEntity.setShikibetsuCode(識別コード);
            TennyushutsuHoryuTaishoshaEntity.setRirekiNo(履歴番号);

            sut = new TennyushutsuHoryuTaishosha(TennyushutsuHoryuTaishoshaEntity);
        }

        @Test
        public void シリアライズできる() {
            assertThat(sut, is(IsSerializable.serializable()));
        }
    }

    public static class deletedテスト extends DbzTestBase {

        private static TennyushutsuHoryuTaishosha sut;
        private static TennyushutsuHoryuTaishosha result;

        @Before
        public void setUp() {
            TennyushutsuHoryuTaishoshaEntity = DbT1010TennyushutsuHoryuTaishoshaEntityGenerator.createDbT1010TennyushutsuHoryuTaishoshaEntity();
            TennyushutsuHoryuTaishoshaEntity.setShikibetsuCode(識別コード);
            TennyushutsuHoryuTaishoshaEntity.setRirekiNo(履歴番号);

        }

        @Test
        public void TennyushutsuHoryuTaishoshaが保持するDbT1010TennyushutsuHoryuTaishoshaEntityのEntityDataStateがUnchangedである場合_deletedメソッド_によりTennyushutsuHoryuTaishoshaが保持するDbT1010TennyushutsuHoryuTaishoshaEntityのEntityDataStateがDeletedに指定されたTennyushutsuHoryuTaishoshaが返る() {
            sut = TestSupport.setStateTennyushutsuHoryuTaishosha(EntityDataState.Unchanged);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void TennyushutsuHoryuTaishoshaが保持するDbT1010TennyushutsuHoryuTaishoshaEntityのEntityDataStateがModifiedである場合_deletedメソッド_によりTennyushutsuHoryuTaishoshaが保持するDbT1010TennyushutsuHoryuTaishoshaEntityのEntityDataStateがDeletedに指定されたTennyushutsuHoryuTaishoshaが返る() {
            sut = TestSupport.setStateTennyushutsuHoryuTaishosha(EntityDataState.Modified);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void TennyushutsuHoryuTaishoshaが保持するDbT1010TennyushutsuHoryuTaishoshaEntityのEntityDataStateがDeletedである場合_deletedメソッド_によりTennyushutsuHoryuTaishoshaが保持するDbT1010TennyushutsuHoryuTaishoshaEntityのEntityDataStateがDeletedに指定されたTennyushutsuHoryuTaishoshaが返る() {
            sut = TestSupport.setStateTennyushutsuHoryuTaishosha(EntityDataState.Deleted);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test(expected = IllegalStateException.class)
        public void TennyushutsuHoryuTaishoshaが保持するDbT1010TennyushutsuHoryuTaishoshaEntityのEntityDataStateがAddedである場合_deletedメソッド_により_IllegalStateExceptionが発火する() {
            sut = TestSupport.setStateTennyushutsuHoryuTaishosha(EntityDataState.Added);
            result = sut.deleted();
        }
    }

    private static class TestSupport {

        public static TennyushutsuHoryuTaishosha setStateTennyushutsuHoryuTaishosha(EntityDataState parentState) {
            TennyushutsuHoryuTaishoshaEntity.setState(parentState);
            return new TennyushutsuHoryuTaishosha(TennyushutsuHoryuTaishoshaEntity);
        }
    }
}
