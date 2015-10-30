/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3072KogakuGassanShikyuGakuKeisanKekkaEntity;
import jp.co.ndensan.reams.db.dbc.entity.basic.helper.DbT3072KogakuGassanShikyuGakuKeisanKekkaEntityGenerator;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import static jp.co.ndensan.reams.db.dbx.testhelper.matcher.IsSerializable.serializable;
import jp.co.ndensan.reams.db.dbz.testhelper.DbcTestBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
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
import org.junit.Ignore;

/**
 * {@link KogakuGassanShikyuGakuKeisanKekka}のテストクラスです。
 */
@RunWith(Enclosed.class)
@Ignore
public class KogakuGassanShikyuGakuKeisanKekkaTest extends DbcTestBase {

    private static DbT3072KogakuGassanShikyuGakuKeisanKekkaEntity KogakuGassanShikyuGakuKeisanKekkaEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static HihokenshaNo 主キー名1;
    private static FlexibleYear 主キー名2;
    private static HokenshaNo 主キー名3;
    private static RString 主キー名4;
    private static Decimal 主キー名5;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        主キー名1 = DbT3072KogakuGassanShikyuGakuKeisanKekkaEntityGenerator.DEFAULT_被保険者番号;
        主キー名2 = DbT3072KogakuGassanShikyuGakuKeisanKekkaEntityGenerator.DEFAULT_対象年度;
        主キー名3 = DbT3072KogakuGassanShikyuGakuKeisanKekkaEntityGenerator.DEFAULT_証記載保険者番号;
        主キー名4 = DbT3072KogakuGassanShikyuGakuKeisanKekkaEntityGenerator.DEFAULT_支給申請書整理番号;
        主キー名5 = DbT3072KogakuGassanShikyuGakuKeisanKekkaEntityGenerator.DEFAULT_履歴番号;
    }

    public static class 主キーコンストラクタテスト extends DbcTestBase {

        private static KogakuGassanShikyuGakuKeisanKekka sut;

        @Before
        public void setUp() {
            KogakuGassanShikyuGakuKeisanKekkaEntity = DbT3072KogakuGassanShikyuGakuKeisanKekkaEntityGenerator.createDbT3072KogakuGassanShikyuGakuKeisanKekkaEntity();
            KogakuGassanShikyuGakuKeisanKekkaEntity.setHihokenshaNo(主キー名1);
            KogakuGassanShikyuGakuKeisanKekkaEntity.setTaishoNendo(主キー名2);
        }

//TODO 主キー名を置換してください
        @Test(expected = NullPointerException.class)
        public void 主キー名1がnullである場合に_NullPointerExceptionが発生する() {
            sut = new KogakuGassanShikyuGakuKeisanKekka(null, 主キー名2, 主キー名3, 主キー名4, 主キー名5);
        }

        @Test(expected = NullPointerException.class)
        public void 主キー名2がnullである場合に_NullPointerExceptionが発生する() {
            sut = new KogakuGassanShikyuGakuKeisanKekka(主キー名1, null, 主キー名3, 主キー名4, 主キー名5);
        }

        @Test
        public void 指定したキーが保持するDbT3072KogakuGassanShikyuGakuKeisanKekkaEntityにセットされている() {
            sut = new KogakuGassanShikyuGakuKeisanKekka(主キー名1, 主キー名2, 主キー名3, 主キー名4, 主キー名5);
            assertThat(sut.get被保険者番号(), is(主キー名1));
            assertThat(sut.get対象年度(), is(主キー名2));
        }

        @Test
        public void 指定したキーが保持するKogakuGassanShikyuGakuKeisanKekkaIdentifierにセットされている() {
            sut = new KogakuGassanShikyuGakuKeisanKekka(主キー名1, 主キー名2, 主キー名3, 主キー名4, 主キー名5);
            assertThat(sut.identifier().get被保険者番号(), is(主キー名1));
            assertThat(sut.identifier().get対象年度(), is(主キー名2));
        }
    }

    public static class Entityコンストラクタテスト extends DbcTestBase {

        private static KogakuGassanShikyuGakuKeisanKekka sut;

        @Before
        public void setUp() {
            KogakuGassanShikyuGakuKeisanKekkaEntity = DbT3072KogakuGassanShikyuGakuKeisanKekkaEntityGenerator.createDbT3072KogakuGassanShikyuGakuKeisanKekkaEntity();
            KogakuGassanShikyuGakuKeisanKekkaEntity.setHihokenshaNo(主キー名1);
            KogakuGassanShikyuGakuKeisanKekkaEntity.setTaishoNendo(主キー名2);
        }

        @Test(expected = NullPointerException.class)
        public void 指定したEntityがnullである場合_NullPointerExceptionとなる() {
            sut = new KogakuGassanShikyuGakuKeisanKekka(null);
        }

        @Test
        public void 指定したDbT3072KogakuGassanShikyuGakuKeisanKekkaEntityのキー情報を識別子が持つ() {

            sut = new KogakuGassanShikyuGakuKeisanKekka(KogakuGassanShikyuGakuKeisanKekkaEntity);

            assertThat(sut.identifier().get被保険者番号(), is(主キー名1));
            assertThat(sut.identifier().get対象年度(), is(主キー名2));
        }
    }

    public static class getterテスト extends DbcTestBase {

        private static KogakuGassanShikyuGakuKeisanKekka sut;

        @Before
        public void setUp() {
            KogakuGassanShikyuGakuKeisanKekkaEntity = DbT3072KogakuGassanShikyuGakuKeisanKekkaEntityGenerator.createDbT3072KogakuGassanShikyuGakuKeisanKekkaEntity();
            KogakuGassanShikyuGakuKeisanKekkaEntity.setHihokenshaNo(主キー名1);
            KogakuGassanShikyuGakuKeisanKekkaEntity.setTaishoNendo(主キー名2);

            sut = new KogakuGassanShikyuGakuKeisanKekka(KogakuGassanShikyuGakuKeisanKekkaEntity);
        }

        @Test
        public void get被保険者番号は_entityが持つ被保険者番号を返す() {
            assertThat(sut.get被保険者番号(), is(KogakuGassanShikyuGakuKeisanKekkaEntity.getHihokenshaNo()));
        }

        @Test
        public void get対象年度は_entityが持つ対象年度を返す() {
            assertThat(sut.get対象年度(), is(KogakuGassanShikyuGakuKeisanKekkaEntity.getTaishoNendo()));
        }

        @Test
        public void get証記載保険者番号は_entityが持つ証記載保険者番号を返す() {
            assertThat(sut.get証記載保険者番号(), is(KogakuGassanShikyuGakuKeisanKekkaEntity.getShoKisaiHokenshaNo()));
        }

        @Test
        public void get支給申請書整理番号は_entityが持つ支給申請書整理番号を返す() {
            assertThat(sut.get支給申請書整理番号(), is(KogakuGassanShikyuGakuKeisanKekkaEntity.getShikyuShinseishoSeiriNo()));
        }

        @Test
        public void get履歴番号は_entityが持つ履歴番号を返す() {
            assertThat(sut.get履歴番号(), is(KogakuGassanShikyuGakuKeisanKekkaEntity.getRirekiNo()));
        }

        @Test
        public void get保険制度コードは_entityが持つ保険制度コードを返す() {
            assertThat(sut.get保険制度コード(), is(KogakuGassanShikyuGakuKeisanKekkaEntity.getHokenSeidoCode()));
        }

        @Test
        public void get自己負担額証明書整理番号は_entityが持つ自己負担額証明書整理番号を返す() {
            assertThat(sut.get自己負担額証明書整理番号(), is(KogakuGassanShikyuGakuKeisanKekkaEntity.getJikoFutanSeiriNo()));
        }

        @Test
        public void get対象計算期間開始年月日は_entityが持つ対象計算期間開始年月日を返す() {
            assertThat(sut.get対象計算期間開始年月日(), is(KogakuGassanShikyuGakuKeisanKekkaEntity.getTaishoKeisanKaishiYMD()));
        }

        @Test
        public void get対象計算期間終了年月日は_entityが持つ対象計算期間終了年月日を返す() {
            assertThat(sut.get対象計算期間終了年月日(), is(KogakuGassanShikyuGakuKeisanKekkaEntity.getTaishoKeisanShuryoYMD()));
        }

        @Test
        public void get世帯負担総額は_entityが持つ世帯負担総額を返す() {
            assertThat(sut.get世帯負担総額(), is(KogakuGassanShikyuGakuKeisanKekkaEntity.getSetaiFutanSogaku()));
        }

        @Test
        public void get介護等合算一部負担金等世帯合算額は_entityが持つ介護等合算一部負担金等世帯合算額を返す() {
            assertThat(sut.get介護等合算一部負担金等世帯合算額(), is(KogakuGassanShikyuGakuKeisanKekkaEntity.getSetaiGassanGaku()));
        }

        @Test
        public void get70歳以上介護等合算一部負担金等世帯合算額は_entityが持つ70歳以上介護等合算一部負担金等世帯合算額を返す() {
            assertThat(sut.get70歳以上介護等合算一部負担金等世帯合算額(), is(KogakuGassanShikyuGakuKeisanKekkaEntity.getOver70_SetaiGassanGaku()));
        }

        @Test
        public void get所得区分は_entityが持つ所得区分を返す() {
            assertThat(sut.get所得区分(), is(KogakuGassanShikyuGakuKeisanKekkaEntity.getShotokuKubun()));
        }

        @Test
        public void get70歳以上の者に係る所得区分は_entityが持つ70歳以上の者に係る所得区分を返す() {
            assertThat(sut.get70歳以上の者に係る所得区分(), is(KogakuGassanShikyuGakuKeisanKekkaEntity.getOver70_ShotokuKubun()));
        }

        @Test
        public void get介護等合算算定基準額は_entityが持つ介護等合算算定基準額を返す() {
            assertThat(sut.get介護等合算算定基準額(), is(KogakuGassanShikyuGakuKeisanKekkaEntity.getSanteiKijunGaku()));
        }

        @Test
        public void get70歳以上介護等合算算定基準額は_entityが持つ70歳以上介護等合算算定基準額を返す() {
            assertThat(sut.get70歳以上介護等合算算定基準額(), is(KogakuGassanShikyuGakuKeisanKekkaEntity.getOver70_SanteiKijyunGaku()));
        }

        @Test
        public void get世帯支給総額は_entityが持つ世帯支給総額を返す() {
            assertThat(sut.get世帯支給総額(), is(KogakuGassanShikyuGakuKeisanKekkaEntity.getSetaiShikyuSogaku()));
        }

        @Test
        public void getうち70歳以上分世帯支給総額は_entityが持つうち70歳以上分世帯支給総額を返す() {
            assertThat(sut.getうち70歳以上分世帯支給総額(), is(KogakuGassanShikyuGakuKeisanKekkaEntity.getOver70_SetaiShikyuSogaku()));
        }

        @Test
        public void get按分後支給額は_entityが持つ按分後支給額を返す() {
            assertThat(sut.get按分後支給額(), is(KogakuGassanShikyuGakuKeisanKekkaEntity.getHonninShikyugaku()));
        }

        @Test
        public void getうち70歳以上分按分後支給額は_entityが持つうち70歳以上分按分後支給額を返す() {
            assertThat(sut.getうち70歳以上分按分後支給額(), is(KogakuGassanShikyuGakuKeisanKekkaEntity.getOver70_honninShikyugaku()));
        }

        @Test
        public void get介護低所得者Ⅰ再計算実施の有無は_entityが持つ介護低所得者Ⅰ再計算実施の有無を返す() {
            assertThat(sut.get介護低所得者Ⅰ再計算実施の有無(), is(KogakuGassanShikyuGakuKeisanKekkaEntity.getTeiShotoku_1_SaiKeisanUmu()));
        }

        @Test
        public void get備考は_entityが持つ備考を返す() {
            assertThat(sut.get備考(), is(KogakuGassanShikyuGakuKeisanKekkaEntity.getBiko()));
        }

        @Test
        public void get支給額計算結果連絡先郵便番号は_entityが持つ支給額計算結果連絡先郵便番号を返す() {
            assertThat(sut.get支給額計算結果連絡先郵便番号(), is(KogakuGassanShikyuGakuKeisanKekkaEntity.getKekkaRenrakusakiYubinNo()));
        }

        @Test
        public void get支給額計算結果連絡先住所は_entityが持つ支給額計算結果連絡先住所を返す() {
            assertThat(sut.get支給額計算結果連絡先住所(), is(KogakuGassanShikyuGakuKeisanKekkaEntity.getKekkaRenrakusakiJusho()));
        }

        @Test
        public void get支給額計算結果連絡先名称1は_entityが持つ支給額計算結果連絡先名称1を返す() {
            assertThat(sut.get支給額計算結果連絡先名称1(), is(KogakuGassanShikyuGakuKeisanKekkaEntity.getKetteRenrakusakiMeisho1()));
        }

        @Test
        public void get支給額計算結果連絡先名称2は_entityが持つ支給額計算結果連絡先名称2を返す() {
            assertThat(sut.get支給額計算結果連絡先名称2(), is(KogakuGassanShikyuGakuKeisanKekkaEntity.getKekkaRenrakusakiMeisho2()));
        }

        @Test
        public void get通知年月日は_entityが持つ通知年月日を返す() {
            assertThat(sut.get通知年月日(), is(KogakuGassanShikyuGakuKeisanKekkaEntity.getTsuchiYMD()));
        }

        @Test
        public void get連絡票発行者名は_entityが持つ連絡票発行者名を返す() {
            assertThat(sut.get連絡票発行者名(), is(KogakuGassanShikyuGakuKeisanKekkaEntity.getRenrakuhyoHakkoshaMei()));
        }

        @Test
        public void get連絡票発行者郵便番号は_entityが持つ連絡票発行者郵便番号を返す() {
            assertThat(sut.get連絡票発行者郵便番号(), is(KogakuGassanShikyuGakuKeisanKekkaEntity.getRenrakuhyoHakkoshaYubinNo()));
        }

        @Test
        public void get連絡票発行者住所は_entityが持つ連絡票発行者住所を返す() {
            assertThat(sut.get連絡票発行者住所(), is(KogakuGassanShikyuGakuKeisanKekkaEntity.getRenrakuhyoHakkoshaJusho()));
        }

        @Test
        public void get問い合わせ先郵便番号は_entityが持つ問い合わせ先郵便番号を返す() {
            assertThat(sut.get問い合わせ先郵便番号(), is(KogakuGassanShikyuGakuKeisanKekkaEntity.getToiawasesakiYobinNo()));
        }

        @Test
        public void get問い合わせ先住所は_entityが持つ問い合わせ先住所を返す() {
            assertThat(sut.get問い合わせ先住所(), is(KogakuGassanShikyuGakuKeisanKekkaEntity.getToiawasesakiJusho()));
        }

        @Test
        public void get問い合わせ先名称1は_entityが持つ問い合わせ先名称1を返す() {
            assertThat(sut.get問い合わせ先名称1(), is(KogakuGassanShikyuGakuKeisanKekkaEntity.getToiawasesakiMeisho1()));
        }

        @Test
        public void get問い合わせ先名称2は_entityが持つ問い合わせ先名称2を返す() {
            assertThat(sut.get問い合わせ先名称2(), is(KogakuGassanShikyuGakuKeisanKekkaEntity.getToiawasesakiMeisho2()));
        }

        @Test
        public void get問い合わせ先電話番号は_entityが持つ問い合わせ先電話番号を返す() {
            assertThat(sut.get問い合わせ先電話番号(), is(KogakuGassanShikyuGakuKeisanKekkaEntity.getToiawasesakiTelNo()));
        }

        @Test
        public void get70歳以上負担額合計は_entityが持つ70歳以上負担額合計を返す() {
            assertThat(sut.get70歳以上負担額合計(), is(KogakuGassanShikyuGakuKeisanKekkaEntity.getOver70_FutangakuGokei()));
        }

        @Test
        public void get70歳以上支給額合計は_entityが持つ70歳以上支給額合計を返す() {
            assertThat(sut.get70歳以上支給額合計(), is(KogakuGassanShikyuGakuKeisanKekkaEntity.getOver70_ShikyugakuGokei()));
        }

        @Test
        public void get70歳未満負担額合計は_entityが持つ70歳未満負担額合計を返す() {
            assertThat(sut.get70歳未満負担額合計(), is(KogakuGassanShikyuGakuKeisanKekkaEntity.getUnder70_FutangakuGokei()));
        }

        @Test
        public void get負担額の合計額は_entityが持つ負担額の合計額を返す() {
            assertThat(sut.get負担額の合計額(), is(KogakuGassanShikyuGakuKeisanKekkaEntity.getFutangakuGokei()));
        }

        @Test
        public void get70歳未満支給額合計は_entityが持つ70歳未満支給額合計を返す() {
            assertThat(sut.get70歳未満支給額合計(), is(KogakuGassanShikyuGakuKeisanKekkaEntity.getUnder70_ShikyugakuGokei()));
        }

        @Test
        public void get支給額合計額は_entityが持つ支給額合計額を返す() {
            assertThat(sut.get支給額合計額(), is(KogakuGassanShikyuGakuKeisanKekkaEntity.getShikyugakuGokei()));
        }

        @Test
        public void getデータ区分は_entityが持つデータ区分を返す() {
            assertThat(sut.getデータ区分(), is(KogakuGassanShikyuGakuKeisanKekkaEntity.getDataKubun()));
        }

        @Test
        public void get受取年月は_entityが持つ受取年月を返す() {
            assertThat(sut.get受取年月(), is(KogakuGassanShikyuGakuKeisanKekkaEntity.getUketoriYM()));
        }

        @Test
        public void get送付年月は_entityが持つ送付年月を返す() {
            assertThat(sut.get送付年月(), is(KogakuGassanShikyuGakuKeisanKekkaEntity.getSofuYM()));
        }
    }

    public static class toEntityテスト extends DbcTestBase {

        private static KogakuGassanShikyuGakuKeisanKekka sut;

        @Before
        public void setUp() {
            KogakuGassanShikyuGakuKeisanKekkaEntity = DbT3072KogakuGassanShikyuGakuKeisanKekkaEntityGenerator.createDbT3072KogakuGassanShikyuGakuKeisanKekkaEntity();
            KogakuGassanShikyuGakuKeisanKekkaEntity.setHihokenshaNo(主キー名1);
            KogakuGassanShikyuGakuKeisanKekkaEntity.setTaishoNendo(主キー名2);

            sut = new KogakuGassanShikyuGakuKeisanKekka(KogakuGassanShikyuGakuKeisanKekkaEntity);
        }

        @Test
        public void toEntityはコンストラクタで設定したentityと異なるインスタンスを返す() {
            assertThat(sut.toEntity(), not(KogakuGassanShikyuGakuKeisanKekkaEntity));
        }
    }

    public static class SerializationProxyテスト extends DbcTestBase {

        private static KogakuGassanShikyuGakuKeisanKekka sut;

        @Before
        public void setUp() {
            KogakuGassanShikyuGakuKeisanKekkaEntity = DbT3072KogakuGassanShikyuGakuKeisanKekkaEntityGenerator.createDbT3072KogakuGassanShikyuGakuKeisanKekkaEntity();
            KogakuGassanShikyuGakuKeisanKekkaEntity.setHihokenshaNo(主キー名1);
            KogakuGassanShikyuGakuKeisanKekkaEntity.setTaishoNendo(主キー名2);

            sut = new KogakuGassanShikyuGakuKeisanKekka(KogakuGassanShikyuGakuKeisanKekkaEntity);
        }

        @Test
        public void シリアライズできる() {
            assertThat(sut, is(serializable()));
        }
    }

    public static class deletedテスト extends DbcTestBase {

        private static KogakuGassanShikyuGakuKeisanKekka sut;
        private static KogakuGassanShikyuGakuKeisanKekka result;

        @Before
        public void setUp() {
            KogakuGassanShikyuGakuKeisanKekkaEntity = DbT3072KogakuGassanShikyuGakuKeisanKekkaEntityGenerator.createDbT3072KogakuGassanShikyuGakuKeisanKekkaEntity();
            KogakuGassanShikyuGakuKeisanKekkaEntity.setHihokenshaNo(主キー名1);
            KogakuGassanShikyuGakuKeisanKekkaEntity.setTaishoNendo(主キー名2);

        }

        @Test
        public void KogakuGassanShikyuGakuKeisanKekkaが保持するDbT3072KogakuGassanShikyuGakuKeisanKekkaEntityのEntityDataStateがUnchangedである場合_deletedメソッド_によりKogakuGassanShikyuGakuKeisanKekkaが保持するDbT3072KogakuGassanShikyuGakuKeisanKekkaEntityのEntityDataStateがDeletedに指定されたKogakuGassanShikyuGakuKeisanKekkaが返る() {
            sut = TestSupport.setStateKogakuGassanShikyuGakuKeisanKekka(EntityDataState.Unchanged);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void KogakuGassanShikyuGakuKeisanKekkaが保持するDbT3072KogakuGassanShikyuGakuKeisanKekkaEntityのEntityDataStateがModifiedである場合_deletedメソッド_によりKogakuGassanShikyuGakuKeisanKekkaが保持するDbT3072KogakuGassanShikyuGakuKeisanKekkaEntityのEntityDataStateがDeletedに指定されたKogakuGassanShikyuGakuKeisanKekkaが返る() {
            sut = TestSupport.setStateKogakuGassanShikyuGakuKeisanKekka(EntityDataState.Modified);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void KogakuGassanShikyuGakuKeisanKekkaが保持するDbT3072KogakuGassanShikyuGakuKeisanKekkaEntityのEntityDataStateがDeletedである場合_deletedメソッド_によりKogakuGassanShikyuGakuKeisanKekkaが保持するDbT3072KogakuGassanShikyuGakuKeisanKekkaEntityのEntityDataStateがDeletedに指定されたKogakuGassanShikyuGakuKeisanKekkaが返る() {
            sut = TestSupport.setStateKogakuGassanShikyuGakuKeisanKekka(EntityDataState.Deleted);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test(expected = IllegalStateException.class)
        public void KogakuGassanShikyuGakuKeisanKekkaが保持するDbT3072KogakuGassanShikyuGakuKeisanKekkaEntityのEntityDataStateがAddedである場合_deletedメソッド_により_IllegalStateExceptionが発火する() {
            sut = TestSupport.setStateKogakuGassanShikyuGakuKeisanKekka(EntityDataState.Added);
            result = sut.deleted();
        }
    }

    private static class TestSupport {

        public static KogakuGassanShikyuGakuKeisanKekka setStateKogakuGassanShikyuGakuKeisanKekka(EntityDataState parentState) {
            KogakuGassanShikyuGakuKeisanKekkaEntity.setState(parentState);
            return new KogakuGassanShikyuGakuKeisanKekka(KogakuGassanShikyuGakuKeisanKekkaEntity);
        }
    }
}
