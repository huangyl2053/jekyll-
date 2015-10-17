/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.business.core.basic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7060KaigoJigyoshaEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.helper.DbT7060KaigoJigyoshaEntityGenerator;
import jp.co.ndensan.reams.db.dbx.testhelper.DbxTestBase;
import static jp.co.ndensan.reams.db.dbx.testhelper.matcher.IsSerializable.serializable;
import jp.co.ndensan.reams.uz.uza.biz.KaigoJigyoshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
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
 * {@link KaigoJigyosha}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class KaigoJigyoshaTest extends DbxTestBase {

    private static DbT7060KaigoJigyoshaEntity KaigoJigyoshaEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static KaigoJigyoshaNo 主キー名1;
    private static FlexibleDate 主キー名2;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        主キー名1 = DbT7060KaigoJigyoshaEntityGenerator.DEFAULT_事業者番号;
        主キー名2 = DbT7060KaigoJigyoshaEntityGenerator.DEFAULT_有効開始日;
    }

    public static class 主キーコンストラクタテスト extends DbxTestBase {

        private static KaigoJigyosha sut;

        @Before
        public void setUp() {
            KaigoJigyoshaEntity = DbT7060KaigoJigyoshaEntityGenerator.createDbT7060KaigoJigyoshaEntity();
            KaigoJigyoshaEntity.setJigyoshaNo(主キー名1);
            KaigoJigyoshaEntity.setYukoKaishiYMD(主キー名2);
        }

//TODO 主キー名を置換してください
        @Test(expected = NullPointerException.class)
        public void 主キー名1がnullである場合に_NullPointerExceptionが発生する() {
            sut = new KaigoJigyosha(null, 主キー名2);
        }

        @Test(expected = NullPointerException.class)
        public void 主キー名2がnullである場合に_NullPointerExceptionが発生する() {
            sut = new KaigoJigyosha(主キー名1, null);
        }

        @Test
        public void 指定したキーが保持するDbT7060KaigoJigyoshaEntityにセットされている() {
            sut = new KaigoJigyosha(主キー名1, 主キー名2);
            assertThat(sut.get事業者番号(), is(主キー名1));
            assertThat(sut.get有効開始日(), is(主キー名2));
        }

        @Test
        public void 指定したキーが保持するKaigoJigyoshaIdentifierにセットされている() {
            sut = new KaigoJigyosha(主キー名1, 主キー名2);
            assertThat(sut.identifier().get事業者番号(), is(主キー名1));
            assertThat(sut.identifier().get有効開始日(), is(主キー名2));
        }
    }

    public static class Entityコンストラクタテスト extends DbxTestBase {

        private static KaigoJigyosha sut;

        @Before
        public void setUp() {
            KaigoJigyoshaEntity = DbT7060KaigoJigyoshaEntityGenerator.createDbT7060KaigoJigyoshaEntity();
            KaigoJigyoshaEntity.setJigyoshaNo(主キー名1);
            KaigoJigyoshaEntity.setYukoKaishiYMD(主キー名2);
        }

        @Test(expected = NullPointerException.class)
        public void 指定したEntityがnullである場合_NullPointerExceptionとなる() {
            sut = new KaigoJigyosha(null);
        }

        @Test
        public void 指定したDbT7060KaigoJigyoshaEntityのキー情報を識別子が持つ() {

            sut = new KaigoJigyosha(KaigoJigyoshaEntity);
            assertThat(sut.identifier().get事業者番号(), is(主キー名1));
            assertThat(sut.identifier().get有効開始日(), is(主キー名2));
        }
    }

    public static class getterテスト extends DbxTestBase {

        private static KaigoJigyosha sut;

        @Before
        public void setUp() {
            KaigoJigyoshaEntity = DbT7060KaigoJigyoshaEntityGenerator.createDbT7060KaigoJigyoshaEntity();
            KaigoJigyoshaEntity.setJigyoshaNo(主キー名1);
            KaigoJigyoshaEntity.setYukoKaishiYMD(主キー名2);

            sut = new KaigoJigyosha(KaigoJigyoshaEntity);
        }

        @Test
        public void get事業者番号は_entityが持つ事業者番号を返す() {
            assertThat(sut.get事業者番号(), is(KaigoJigyoshaEntity.getJigyoshaNo()));
        }

        @Test
        public void get有効開始日は_entityが持つ有効開始日を返す() {
            assertThat(sut.get有効開始日(), is(KaigoJigyoshaEntity.getYukoKaishiYMD()));
        }

        @Test
        public void get有効終了日は_entityが持つ有効終了日を返す() {
            assertThat(sut.get有効終了日(), is(KaigoJigyoshaEntity.getYukoShuryoYMD()));
        }

        @Test
        public void get異動日は_entityが持つ異動日を返す() {
            assertThat(sut.get異動日(), is(KaigoJigyoshaEntity.getIdoYMD()));
        }

        @Test
        public void get異動事由は_entityが持つ異動事由を返す() {
            assertThat(sut.get異動事由(), is(KaigoJigyoshaEntity.getIdoJiyuCode()));
        }

        @Test
        public void get事業開始日は_entityが持つ事業開始日を返す() {
            assertThat(sut.get事業開始日(), is(KaigoJigyoshaEntity.getJigyoKaishiYMD()));
        }

        @Test
        public void get事業休止日は_entityが持つ事業休止日を返す() {
            assertThat(sut.get事業休止日(), is(KaigoJigyoshaEntity.getJigyoKyushiYMD()));
        }

        @Test
        public void get事業再開日は_entityが持つ事業再開日を返す() {
            assertThat(sut.get事業再開日(), is(KaigoJigyoshaEntity.getJigyoSaikaiYMD()));
        }

        @Test
        public void get事業廃止日は_entityが持つ事業廃止日を返す() {
            assertThat(sut.get事業廃止日(), is(KaigoJigyoshaEntity.getJigyoHaishiYMD()));
        }

        @Test
        public void get事業者名称は_entityが持つ事業者名称を返す() {
            assertThat(sut.get事業者名称(), is(KaigoJigyoshaEntity.getJigyoshaName()));
        }

        @Test
        public void get事業者名称カナは_entityが持つ事業者名称カナを返す() {
            assertThat(sut.get事業者名称カナ(), is(KaigoJigyoshaEntity.getJigyoshaNameKana()));
        }

        @Test
        public void get郵便番号は_entityが持つ郵便番号を返す() {
            assertThat(sut.get郵便番号(), is(KaigoJigyoshaEntity.getYubinNo()));
        }

        @Test
        public void get事業者住所は_entityが持つ事業者住所を返す() {
            assertThat(sut.get事業者住所(), is(KaigoJigyoshaEntity.getJigyoshaAddress()));
        }

        @Test
        public void get事業者住所カナは_entityが持つ事業者住所カナを返す() {
            assertThat(sut.get事業者住所カナ(), is(KaigoJigyoshaEntity.getJigyoshaKanaAddress()));
        }

        @Test
        public void get電話番号は_entityが持つ電話番号を返す() {
            assertThat(sut.get電話番号(), is(KaigoJigyoshaEntity.getTelNo()));
        }

        @Test
        public void getFAX番号は_entityが持つFAX番号を返す() {
            assertThat(sut.getFAX番号(), is(KaigoJigyoshaEntity.getFaxNo()));
        }

        @Test
        public void get宛先部署は_entityが持つ宛先部署を返す() {
            assertThat(sut.get宛先部署(), is(KaigoJigyoshaEntity.getAtesakiBusho()));
        }

        @Test
        public void get宛先人名は_entityが持つ宛先人名を返す() {
            assertThat(sut.get宛先人名(), is(KaigoJigyoshaEntity.getAtesakininName()));
        }

        @Test
        public void get宛先人名カナは_entityが持つ宛先人名カナを返す() {
            assertThat(sut.get宛先人名カナ(), is(KaigoJigyoshaEntity.getAtesakininNamekana()));
        }

        @Test
        public void get指定_基準該当等事業所区分は_entityが持つ指定_基準該当等事業所区分を返す() {
            assertThat(sut.get指定_基準該当等事業所区分(), is(KaigoJigyoshaEntity.getShiteiKijungaitoJigyoshaKubun()));
        }

        @Test
        public void get所在市町村は_entityが持つ所在市町村を返す() {
            assertThat(sut.get所在市町村(), is(KaigoJigyoshaEntity.getShozaiShichoson()));
        }

        @Test
        public void getサービス実施地域は_entityが持つサービス実施地域を返す() {
            assertThat(sut.getサービス実施地域(), is(KaigoJigyoshaEntity.getServiceJisshiChiiki()));
        }

        @Test
        public void get法人等種別は_entityが持つ法人等種別を返す() {
            assertThat(sut.get法人等種別(), is(KaigoJigyoshaEntity.getHojinShubetsu()));
        }

        @Test
        public void getベッド数は_entityが持つベッド数を返す() {
            assertThat(sut.getベッド数(), is(KaigoJigyoshaEntity.getBedSu()));
        }

        @Test
        public void get所属人数は_entityが持つ所属人数を返す() {
            assertThat(sut.get所属人数(), is(KaigoJigyoshaEntity.getShozokuNinzu()));
        }

        @Test
        public void get利用者数は_entityが持つ利用者数を返す() {
            assertThat(sut.get利用者数(), is(KaigoJigyoshaEntity.getRiyoshaSu()));
        }

        @Test
        public void get備考は_entityが持つ備考を返す() {
            assertThat(sut.get備考(), is(KaigoJigyoshaEntity.getBiko()));
        }
    }

    public static class toEntityテスト extends DbxTestBase {

        private static KaigoJigyosha sut;

        @Before
        public void setUp() {
            KaigoJigyoshaEntity = DbT7060KaigoJigyoshaEntityGenerator.createDbT7060KaigoJigyoshaEntity();
            KaigoJigyoshaEntity.setJigyoshaNo(主キー名1);
            KaigoJigyoshaEntity.setYukoKaishiYMD(主キー名2);

            sut = new KaigoJigyosha(KaigoJigyoshaEntity);
        }

        @Test
        public void toEntityはコンストラクタで設定したentityと異なるインスタンスを返す() {
            assertThat(sut.toEntity(), not(KaigoJigyoshaEntity));
        }
    }

    public static class SerializationProxyテスト extends DbxTestBase {

        private static KaigoJigyosha sut;

        @Before
        public void setUp() {
            KaigoJigyoshaEntity = DbT7060KaigoJigyoshaEntityGenerator.createDbT7060KaigoJigyoshaEntity();
            KaigoJigyoshaEntity.setJigyoshaNo(主キー名1);
            KaigoJigyoshaEntity.setYukoKaishiYMD(主キー名2);

            sut = new KaigoJigyosha(KaigoJigyoshaEntity);
        }

        @Test
        public void シリアライズできる() {
            assertThat(sut, is(serializable()));
        }
    }

    public static class deletedテスト extends DbxTestBase {

        private static KaigoJigyosha sut;
        private static KaigoJigyosha result;

        @Before
        public void setUp() {
            KaigoJigyoshaEntity = DbT7060KaigoJigyoshaEntityGenerator.createDbT7060KaigoJigyoshaEntity();
            KaigoJigyoshaEntity.setJigyoshaNo(主キー名1);
            KaigoJigyoshaEntity.setYukoKaishiYMD(主キー名2);
        }

        @Test
        public void KaigoJigyoshaが保持するDbT7060KaigoJigyoshaEntityのEntityDataStateがUnchangedである場合_deletedメソッド_によりKaigoJigyoshaが保持するDbT7060KaigoJigyoshaEntityのEntityDataStateがDeletedに指定されたKaigoJigyoshaが返る() {
            sut = TestSupport.setStateKaigoJigyosha(EntityDataState.Unchanged);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void KaigoJigyoshaが保持するDbT7060KaigoJigyoshaEntityのEntityDataStateがModifiedである場合_deletedメソッド_によりKaigoJigyoshaが保持するDbT7060KaigoJigyoshaEntityのEntityDataStateがDeletedに指定されたKaigoJigyoshaが返る() {
            sut = TestSupport.setStateKaigoJigyosha(EntityDataState.Modified);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void KaigoJigyoshaが保持するDbT7060KaigoJigyoshaEntityのEntityDataStateがDeletedである場合_deletedメソッド_によりKaigoJigyoshaが保持するDbT7060KaigoJigyoshaEntityのEntityDataStateがDeletedに指定されたKaigoJigyoshaが返る() {
            sut = TestSupport.setStateKaigoJigyosha(EntityDataState.Deleted);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test(expected = IllegalStateException.class)
        public void KaigoJigyoshaが保持するDbT7060KaigoJigyoshaEntityのEntityDataStateがAddedである場合_deletedメソッド_により_IllegalStateExceptionが発火する() {
            sut = TestSupport.setStateKaigoJigyosha(EntityDataState.Added);
            result = sut.deleted();
        }
    }

    private static class TestSupport {

        public static KaigoJigyosha setStateKaigoJigyosha(EntityDataState parentState) {
            KaigoJigyoshaEntity.setState(parentState);
            return new KaigoJigyosha(KaigoJigyoshaEntity);
        }
    }
}
