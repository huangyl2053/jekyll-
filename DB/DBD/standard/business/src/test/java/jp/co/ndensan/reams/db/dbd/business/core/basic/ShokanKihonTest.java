/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.core.basic;

import jp.co.ndensan.reams.db.dbd.business.core.basic.ShokanKihon;
import jp.co.ndensan.reams.db.dbd.business.core.basic.ShokanKihon;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.helper.DbT3038ShokanKihonEntityGenerator;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT3038ShokanKihonEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
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
import org.junit.Ignore;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link ShokanKihon}のテストクラスです。
 */
@RunWith(Enclosed.class)
@Ignore
public class ShokanKihonTest extends DbcTestBase {

    private static DbT3038ShokanKihonEntity ShokanKihonEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static HihokenshaNo 主キー名1;
    private static FlexibleYearMonth 主キー名2;
    private static RString 主キー名3;
    private static JigyoshaNo 主キー名4;
    private static RString 主キー名5;
    private static RString 主キー名6;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        主キー名1 = DbT3038ShokanKihonEntityGenerator.DEFAULT_被保険者番号;
        主キー名2 = DbT3038ShokanKihonEntityGenerator.DEFAULT_サービス提供年月;
        主キー名3 = DbT3038ShokanKihonEntityGenerator.DEFAULT_整理番号;
        主キー名4 = DbT3038ShokanKihonEntityGenerator.DEFAULT_事業者番号;
        主キー名5 = DbT3038ShokanKihonEntityGenerator.DEFAULT_様式番号;
        主キー名6 = DbT3038ShokanKihonEntityGenerator.DEFAULT_明細番号;
    }

    public static class 主キーコンストラクタテスト extends DbcTestBase {

        private static ShokanKihon sut;

        @Before
        public void setUp() {
            ShokanKihonEntity = DbT3038ShokanKihonEntityGenerator.createDbT3038ShokanKihonEntity();
            ShokanKihonEntity.setHiHokenshaNo(主キー名1);
            ShokanKihonEntity.setServiceTeikyoYM(主キー名2);
        }

//TODO 主キー名を置換してください
        @Test(expected = NullPointerException.class)
        public void 主キー名1がnullである場合に_NullPointerExceptionが発生する() {
            sut = new ShokanKihon(null, 主キー名2, 主キー名3, 主キー名4, 主キー名5, 主キー名6);
        }

        @Test(expected = NullPointerException.class)
        public void 主キー名2がnullである場合に_NullPointerExceptionが発生する() {
            sut = new ShokanKihon(主キー名1, null, 主キー名3, 主キー名4, 主キー名5, 主キー名6);
        }

        @Test
        public void 指定したキーが保持するDbT3038ShokanKihonEntityにセットされている() {
            sut = new ShokanKihon(主キー名1, 主キー名2, 主キー名3, 主キー名4, 主キー名5, 主キー名6);
            assertThat(sut.get被保険者番号(), is(主キー名1));
            assertThat(sut.getサービス提供年月(), is(主キー名2));
        }

        @Test
        public void 指定したキーが保持するShokanKihonIdentifierにセットされている() {
            sut = new ShokanKihon(主キー名1, 主キー名2, 主キー名3, 主キー名4, 主キー名5, 主キー名6);
            assertThat(sut.identifier().get被保険者番号(), is(主キー名1));
            assertThat(sut.identifier().getサービス提供年月(), is(主キー名2));
        }
    }

    public static class Entityコンストラクタテスト extends DbcTestBase {

        private static ShokanKihon sut;

        @Before
        public void setUp() {
            ShokanKihonEntity = DbT3038ShokanKihonEntityGenerator.createDbT3038ShokanKihonEntity();
            ShokanKihonEntity.setHiHokenshaNo(主キー名1);
            ShokanKihonEntity.setServiceTeikyoYM(主キー名2);
        }

        @Test(expected = NullPointerException.class)
        public void 指定したEntityがnullである場合_NullPointerExceptionとなる() {
            sut = new ShokanKihon(null);
        }

        @Test
        public void 指定したDbT3038ShokanKihonEntityのキー情報を識別子が持つ() {

            sut = new ShokanKihon(ShokanKihonEntity);

            assertThat(sut.identifier().get被保険者番号(), is(主キー名1));
            assertThat(sut.identifier().getサービス提供年月(), is(主キー名2));
        }
    }

    public static class getterテスト extends DbcTestBase {

        private static ShokanKihon sut;

        @Before
        public void setUp() {
            ShokanKihonEntity = DbT3038ShokanKihonEntityGenerator.createDbT3038ShokanKihonEntity();
            ShokanKihonEntity.setHiHokenshaNo(主キー名1);
            ShokanKihonEntity.setServiceTeikyoYM(主キー名2);

            sut = new ShokanKihon(ShokanKihonEntity);
        }

        @Test
        public void get被保険者番号は_entityが持つ被保険者番号を返す() {
            assertThat(sut.get被保険者番号(), is(ShokanKihonEntity.getHiHokenshaNo()));
        }

        @Test
        public void getサービス提供年月は_entityが持つサービス提供年月を返す() {
            assertThat(sut.getサービス提供年月(), is(ShokanKihonEntity.getServiceTeikyoYM()));
        }

        @Test
        public void get整理番号は_entityが持つ整理番号を返す() {
            assertThat(sut.get整理番号(), is(ShokanKihonEntity.getSeiriNo()));
        }

        @Test
        public void get事業者番号は_entityが持つ事業者番号を返す() {
            assertThat(sut.get事業者番号(), is(ShokanKihonEntity.getJigyoshaNo()));
        }

        @Test
        public void get様式番号は_entityが持つ様式番号を返す() {
            assertThat(sut.get様式番号(), is(ShokanKihonEntity.getYoshikiNo()));
        }

        @Test
        public void get明細番号は_entityが持つ明細番号を返す() {
            assertThat(sut.get明細番号(), is(ShokanKihonEntity.getMeisaiNo()));
        }

        @Test
        public void get旧措置入所者特例コードは_entityが持つ旧措置入所者特例コードを返す() {
            assertThat(sut.get旧措置入所者特例コード(), is(ShokanKihonEntity.getKyuSochiNyushoshaTokureiCode()));
        }

        @Test
        public void get居宅サービス計画作成区分コードは_entityが持つ居宅サービス計画作成区分コードを返す() {
            assertThat(sut.get居宅サービス計画作成区分コード(), is(ShokanKihonEntity.getKyotakuServiceSakuseiKubunCode()));
        }

        @Test
        public void get居宅サービス計画事業者番号は_entityが持つ居宅サービス計画事業者番号を返す() {
            assertThat(sut.get居宅サービス計画事業者番号(), is(ShokanKihonEntity.getKyotakuserviceJigyoshaNo()));
        }

        @Test
        public void get開始年月日は_entityが持つ開始年月日を返す() {
            assertThat(sut.get開始年月日(), is(ShokanKihonEntity.getKaishiYMD()));
        }

        @Test
        public void get中止年月日は_entityが持つ中止年月日を返す() {
            assertThat(sut.get中止年月日(), is(ShokanKihonEntity.getChushiYMD()));
        }

        @Test
        public void get中止理由_入所_院前の状況コードは_entityが持つ中止理由_入所_院前の状況コードを返す() {
            assertThat(sut.get中止理由_入所_院前の状況コード(), is(ShokanKihonEntity.getChushiRiyuNyushomaeJyokyoCode()));
        }

        @Test
        public void get入所_院年月日は_entityが持つ入所_院年月日を返す() {
            assertThat(sut.get入所_院年月日(), is(ShokanKihonEntity.getNyushoYMD()));
        }

        @Test
        public void get退所_院年月日は_entityが持つ退所_院年月日を返す() {
            assertThat(sut.get退所_院年月日(), is(ShokanKihonEntity.getTaishoYMD()));
        }

        @Test
        public void get入所_院実日数は_entityが持つ入所_院実日数を返す() {
            assertThat(sut.get入所_院実日数(), is(ShokanKihonEntity.getNyushoJitsuNissu()));
        }

        @Test
        public void get外泊日数は_entityが持つ外泊日数を返す() {
            assertThat(sut.get外泊日数(), is(ShokanKihonEntity.getGaihakuNissu()));
        }

        @Test
        public void get退所_院後の状態コードは_entityが持つ退所_院後の状態コードを返す() {
            assertThat(sut.get退所_院後の状態コード(), is(ShokanKihonEntity.getTaishogoJotaiCode()));
        }

        @Test
        public void get保険給付率は_entityが持つ保険給付率を返す() {
            assertThat(sut.get保険給付率(), is(ShokanKihonEntity.getHokenKyufuritsu()));
        }

        @Test
        public void getサービス単位数は_entityが持つサービス単位数を返す() {
            assertThat(sut.getサービス単位数(), is(ShokanKihonEntity.getServiceTanisu()));
        }

        @Test
        public void get保険請求額は_entityが持つ保険請求額を返す() {
            assertThat(sut.get保険請求額(), is(ShokanKihonEntity.getHokenSeikyugaku()));
        }

        @Test
        public void get利用者負担額は_entityが持つ利用者負担額を返す() {
            assertThat(sut.get利用者負担額(), is(ShokanKihonEntity.getRiyoshaFutangaku()));
        }

        @Test
        public void get緊急時施設療養費請求額は_entityが持つ緊急時施設療養費請求額を返す() {
            assertThat(sut.get緊急時施設療養費請求額(), is(ShokanKihonEntity.getKinkyuShisetsuRyoyoSeikyugaku()));
        }

        @Test
        public void get特定診療費請求額は_entityが持つ特定診療費請求額を返す() {
            assertThat(sut.get特定診療費請求額(), is(ShokanKihonEntity.getTokuteiShinryoSeikyugaku()));
        }

        @Test
        public void get特定入所者介護サービス費等請求額は_entityが持つ特定入所者介護サービス費等請求額を返す() {
            assertThat(sut.get特定入所者介護サービス費等請求額(), is(ShokanKihonEntity.getTokuteiNyushoshaKaigoServiceSeikyugaku()));
        }
    }

    public static class toEntityテスト extends DbcTestBase {

        private static ShokanKihon sut;

        @Before
        public void setUp() {
            ShokanKihonEntity = DbT3038ShokanKihonEntityGenerator.createDbT3038ShokanKihonEntity();
            ShokanKihonEntity.setHiHokenshaNo(主キー名1);
            ShokanKihonEntity.setServiceTeikyoYM(主キー名2);

            sut = new ShokanKihon(ShokanKihonEntity);
        }

        @Test
        public void toEntityはコンストラクタで設定したentityと異なるインスタンスを返す() {
            assertThat(sut.toEntity(), not(ShokanKihonEntity));
        }
    }

    public static class SerializationProxyテスト extends DbcTestBase {

        private static ShokanKihon sut;

        @Before
        public void setUp() {
            ShokanKihonEntity = DbT3038ShokanKihonEntityGenerator.createDbT3038ShokanKihonEntity();
            ShokanKihonEntity.setHiHokenshaNo(主キー名1);
            ShokanKihonEntity.setServiceTeikyoYM(主キー名2);

            sut = new ShokanKihon(ShokanKihonEntity);
        }

        @Test
        public void シリアライズできる() {
            assertThat(sut, is(serializable()));
        }
    }

    public static class deletedテスト extends DbcTestBase {

        private static ShokanKihon sut;
        private static ShokanKihon result;

        @Before
        public void setUp() {
            ShokanKihonEntity = DbT3038ShokanKihonEntityGenerator.createDbT3038ShokanKihonEntity();
            ShokanKihonEntity.setHiHokenshaNo(主キー名1);
            ShokanKihonEntity.setServiceTeikyoYM(主キー名2);

        }

        @Test
        public void ShokanKihonが保持するDbT3038ShokanKihonEntityのEntityDataStateがUnchangedである場合_deletedメソッド_によりShokanKihonが保持するDbT3038ShokanKihonEntityのEntityDataStateがDeletedに指定されたShokanKihonが返る() {
            sut = TestSupport.setStateShokanKihon(EntityDataState.Unchanged);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void ShokanKihonが保持するDbT3038ShokanKihonEntityのEntityDataStateがModifiedである場合_deletedメソッド_によりShokanKihonが保持するDbT3038ShokanKihonEntityのEntityDataStateがDeletedに指定されたShokanKihonが返る() {
            sut = TestSupport.setStateShokanKihon(EntityDataState.Modified);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void ShokanKihonが保持するDbT3038ShokanKihonEntityのEntityDataStateがDeletedである場合_deletedメソッド_によりShokanKihonが保持するDbT3038ShokanKihonEntityのEntityDataStateがDeletedに指定されたShokanKihonが返る() {
            sut = TestSupport.setStateShokanKihon(EntityDataState.Deleted);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test(expected = IllegalStateException.class)
        public void ShokanKihonが保持するDbT3038ShokanKihonEntityのEntityDataStateがAddedである場合_deletedメソッド_により_IllegalStateExceptionが発火する() {
            sut = TestSupport.setStateShokanKihon(EntityDataState.Added);
            result = sut.deleted();
        }
    }

    private static class TestSupport {

        public static ShokanKihon setStateShokanKihon(EntityDataState parentState) {
            ShokanKihonEntity.setState(parentState);
            return new ShokanKihon(ShokanKihonEntity);
        }
    }
}
