/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3070KogakuGassanJikoFutanGakuEntity;
import jp.co.ndensan.reams.db.dbc.entity.basic.helper.DbT3070KogakuGassanJikoFutanGakuEntityGenerator;
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

/**
 * {@link KogakuGassanJikoFutanGaku}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class KogakuGassanJikoFutanGakuTest extends DbcTestBase {

    private static DbT3070KogakuGassanJikoFutanGakuEntity KogakuGassanJikoFutanGakuEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
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
        主キー名1 = DbT3070KogakuGassanJikoFutanGakuEntityGenerator.DEFAULT_被保険者番号;
        主キー名2 = DbT3070KogakuGassanJikoFutanGakuEntityGenerator.DEFAULT_対象年度;
        主キー名3 = DbT3070KogakuGassanJikoFutanGakuEntityGenerator.DEFAULT_保険者番号;
        主キー名4 = DbT3070KogakuGassanJikoFutanGakuEntityGenerator.DEFAULT_支給申請書整理番号;
        主キー名5 = DbT3070KogakuGassanJikoFutanGakuEntityGenerator.DEFAULT_履歴番号;
    }

    public static class 主キーコンストラクタテスト extends DbcTestBase {

        private static KogakuGassanJikoFutanGaku sut;

        @Before
        public void setUp() {
            KogakuGassanJikoFutanGakuEntity = DbT3070KogakuGassanJikoFutanGakuEntityGenerator.createDbT3070KogakuGassanJikoFutanGakuEntity();
            KogakuGassanJikoFutanGakuEntity.setHihokenshaNo(主キー名1);
            KogakuGassanJikoFutanGakuEntity.setTaishoNendo(主キー名2);
        }

//TODO 主キー名を置換してください
        @Test(expected = NullPointerException.class)
        public void 主キー名1がnullである場合に_NullPointerExceptionが発生する() {
            sut = new KogakuGassanJikoFutanGaku(null, 主キー名2, 主キー名3, 主キー名4, 主キー名5);
        }

        @Test(expected = NullPointerException.class)
        public void 主キー名2がnullである場合に_NullPointerExceptionが発生する() {
            sut = new KogakuGassanJikoFutanGaku(主キー名1, null, 主キー名3, 主キー名4, 主キー名5);
        }

        @Test
        public void 指定したキーが保持するDbT3070KogakuGassanJikoFutanGakuEntityにセットされている() {
            sut = new KogakuGassanJikoFutanGaku(主キー名1, 主キー名2, 主キー名3, 主キー名4, 主キー名5);
            assertThat(sut.get被保険者番号(), is(主キー名1));
            assertThat(sut.get対象年度(), is(主キー名2));
        }

        @Test
        public void 指定したキーが保持するKogakuGassanJikoFutanGakuIdentifierにセットされている() {
            sut = new KogakuGassanJikoFutanGaku(主キー名1, 主キー名2, 主キー名3, 主キー名4, 主キー名5);
            assertThat(sut.identifier().get被保険者番号(), is(主キー名1));
            assertThat(sut.identifier().get対象年度(), is(主キー名2));
        }
    }

    public static class Entityコンストラクタテスト extends DbcTestBase {

        private static KogakuGassanJikoFutanGaku sut;

        @Before
        public void setUp() {
            KogakuGassanJikoFutanGakuEntity = DbT3070KogakuGassanJikoFutanGakuEntityGenerator.createDbT3070KogakuGassanJikoFutanGakuEntity();
            KogakuGassanJikoFutanGakuEntity.setHihokenshaNo(主キー名1);
            KogakuGassanJikoFutanGakuEntity.setTaishoNendo(主キー名2);
        }

        @Test(expected = NullPointerException.class)
        public void 指定したEntityがnullである場合_NullPointerExceptionとなる() {
            sut = new KogakuGassanJikoFutanGaku(null);
        }

        @Test
        public void 指定したDbT3070KogakuGassanJikoFutanGakuEntityのキー情報を識別子が持つ() {

            sut = new KogakuGassanJikoFutanGaku(KogakuGassanJikoFutanGakuEntity);

            assertThat(sut.identifier().get被保険者番号(), is(主キー名1));
            assertThat(sut.identifier().get対象年度(), is(主キー名2));
        }
    }

    public static class getterテスト extends DbcTestBase {

        private static KogakuGassanJikoFutanGaku sut;

        @Before
        public void setUp() {
            KogakuGassanJikoFutanGakuEntity = DbT3070KogakuGassanJikoFutanGakuEntityGenerator.createDbT3070KogakuGassanJikoFutanGakuEntity();
            KogakuGassanJikoFutanGakuEntity.setHihokenshaNo(主キー名1);
            KogakuGassanJikoFutanGakuEntity.setTaishoNendo(主キー名2);

            sut = new KogakuGassanJikoFutanGaku(KogakuGassanJikoFutanGakuEntity);
        }

        @Test
        public void get被保険者番号は_entityが持つ被保険者番号を返す() {
            assertThat(sut.get被保険者番号(), is(KogakuGassanJikoFutanGakuEntity.getHihokenshaNo()));
        }

        @Test
        public void get対象年度は_entityが持つ対象年度を返す() {
            assertThat(sut.get対象年度(), is(KogakuGassanJikoFutanGakuEntity.getTaishoNendo()));
        }

        @Test
        public void get保険者番号は_entityが持つ保険者番号を返す() {
            assertThat(sut.get保険者番号(), is(KogakuGassanJikoFutanGakuEntity.getHokenshaNo()));
        }

        @Test
        public void get支給申請書整理番号は_entityが持つ支給申請書整理番号を返す() {
            assertThat(sut.get支給申請書整理番号(), is(KogakuGassanJikoFutanGakuEntity.getShikyuShinseishoSeiriNo()));
        }

        @Test
        public void get履歴番号は_entityが持つ履歴番号を返す() {
            assertThat(sut.get履歴番号(), is(KogakuGassanJikoFutanGakuEntity.getRirekiNo()));
        }

        @Test
        public void get保険制度コードは_entityが持つ保険制度コードを返す() {
            assertThat(sut.get保険制度コード(), is(KogakuGassanJikoFutanGakuEntity.getHokenSeidoCode()));
        }

        @Test
        public void get保険者名は_entityが持つ保険者名を返す() {
            assertThat(sut.get保険者名(), is(KogakuGassanJikoFutanGakuEntity.getHokenshaMei()));
        }

        @Test
        public void get国保被保険者証記号は_entityが持つ国保被保険者証記号を返す() {
            assertThat(sut.get国保被保険者証記号(), is(KogakuGassanJikoFutanGakuEntity.getKokuho_HihokenshaShoKigo()));
        }

        @Test
        public void get被保険者氏名カナは_entityが持つ被保険者氏名カナを返す() {
            assertThat(sut.get被保険者氏名カナ(), is(KogakuGassanJikoFutanGakuEntity.getHihokenshaShimeiKana()));
        }

        @Test
        public void get被保険者氏名は_entityが持つ被保険者氏名を返す() {
            assertThat(sut.get被保険者氏名(), is(KogakuGassanJikoFutanGakuEntity.getHihokenshaShimei()));
        }

        @Test
        public void get生年月日は_entityが持つ生年月日を返す() {
            assertThat(sut.get生年月日(), is(KogakuGassanJikoFutanGakuEntity.getUmareYMD()));
        }

        @Test
        public void get性別は_entityが持つ性別を返す() {
            assertThat(sut.get性別(), is(KogakuGassanJikoFutanGakuEntity.getSeibetsuCode()));
        }

        @Test
        public void get所得区分は_entityが持つ所得区分を返す() {
            assertThat(sut.get所得区分(), is(KogakuGassanJikoFutanGakuEntity.getShotokuKubun()));
        }

        @Test
        public void get70歳以上の者に係る所得区分は_entityが持つ70歳以上の者に係る所得区分を返す() {
            assertThat(sut.get70歳以上の者に係る所得区分(), is(KogakuGassanJikoFutanGakuEntity.getOver70_ShotokuKubun()));
        }

        @Test
        public void get自己負担額証明書整理番号は_entityが持つ自己負担額証明書整理番号を返す() {
            assertThat(sut.get自己負担額証明書整理番号(), is(KogakuGassanJikoFutanGakuEntity.getJikoFutanSeiriNo()));
        }

        @Test
        public void get後期保険者番号は_entityが持つ後期保険者番号を返す() {
            assertThat(sut.get後期保険者番号(), is(KogakuGassanJikoFutanGakuEntity.getKoki_HokenshaNo()));
        }

        @Test
        public void get後期被保険者番号は_entityが持つ後期被保険者番号を返す() {
            assertThat(sut.get後期被保険者番号(), is(KogakuGassanJikoFutanGakuEntity.getKoki_HihokenshaNo()));
        }

        @Test
        public void get国保保険者番号は_entityが持つ国保保険者番号を返す() {
            assertThat(sut.get国保保険者番号(), is(KogakuGassanJikoFutanGakuEntity.getKokuho_HokenshaNo()));
        }

        @Test
        public void get国保被保険者証番号は_entityが持つ国保被保険者証番号を返す() {
            assertThat(sut.get国保被保険者証番号(), is(KogakuGassanJikoFutanGakuEntity.getKokuho_HihokenshaShoNo()));
        }

        @Test
        public void get国保個人番号は_entityが持つ国保個人番号を返す() {
            assertThat(sut.get国保個人番号(), is(KogakuGassanJikoFutanGakuEntity.getKokuho_KojinNo()));
        }

        @Test
        public void get異動区分は_entityが持つ異動区分を返す() {
            assertThat(sut.get異動区分(), is(KogakuGassanJikoFutanGakuEntity.getIdoKubun()));
        }

        @Test
        public void get補正済自己負担額送付区分は_entityが持つ補正済自己負担額送付区分を返す() {
            assertThat(sut.get補正済自己負担額送付区分(), is(KogakuGassanJikoFutanGakuEntity.getHoseiZumiSofuKubun()));
        }

        @Test
        public void get対象計算期間開始年月日は_entityが持つ対象計算期間開始年月日を返す() {
            assertThat(sut.get対象計算期間開始年月日(), is(KogakuGassanJikoFutanGakuEntity.getTaishoKeisanKaishiYMD()));
        }

        @Test
        public void get対象計算期間終了年月日は_entityが持つ対象計算期間終了年月日を返す() {
            assertThat(sut.get対象計算期間終了年月日(), is(KogakuGassanJikoFutanGakuEntity.getTaishoKeisanShuryoYMD()));
        }

        @Test
        public void get被保険者期間開始年月日は_entityが持つ被保険者期間開始年月日を返す() {
            assertThat(sut.get被保険者期間開始年月日(), is(KogakuGassanJikoFutanGakuEntity.getHihokenshaKaishiYMD()));
        }

        @Test
        public void get被保険者期間終了年月日は_entityが持つ被保険者期間終了年月日を返す() {
            assertThat(sut.get被保険者期間終了年月日(), is(KogakuGassanJikoFutanGakuEntity.getHihokenshaShuryoYMD()));
        }

        @Test
        public void get申請年月日は_entityが持つ申請年月日を返す() {
            assertThat(sut.get申請年月日(), is(KogakuGassanJikoFutanGakuEntity.getShinseiYMD()));
        }

        @Test
        public void get合計_自己負担額は_entityが持つ合計_自己負担額を返す() {
            assertThat(sut.get合計_自己負担額(), is(KogakuGassanJikoFutanGakuEntity.getGokei_JikoFutanGaku()));
        }

        @Test
        public void get合計_70_74自己負担額_内訳は_entityが持つ合計_70_74自己負担額_内訳を返す() {
            assertThat(sut.get合計_70_74自己負担額_内訳(), is(KogakuGassanJikoFutanGakuEntity.getGokei_70_74JikoFutanGaku()));
        }

        @Test
        public void get合計_70未満高額支給額は_entityが持つ合計_70未満高額支給額を返す() {
            assertThat(sut.get合計_70未満高額支給額(), is(KogakuGassanJikoFutanGakuEntity.getGokei_Under70KogakuShikyuGaku()));
        }

        @Test
        public void get合計_70_74高額支給額は_entityが持つ合計_70_74高額支給額を返す() {
            assertThat(sut.get合計_70_74高額支給額(), is(KogakuGassanJikoFutanGakuEntity.getGokei_70_74KogakuShikyuGaku()));
        }

        @Test
        public void get補正済_合計_自己負担額は_entityが持つ補正済_合計_自己負担額を返す() {
            assertThat(sut.get補正済_合計_自己負担額(), is(KogakuGassanJikoFutanGakuEntity.getSumi_Gokei_JikoFutanGaku()));
        }

        @Test
        public void get補正済_合計_70_74自己負担額_内訳は_entityが持つ補正済_合計_70_74自己負担額_内訳を返す() {
            assertThat(sut.get補正済_合計_70_74自己負担額_内訳(), is(KogakuGassanJikoFutanGakuEntity.getSumi_Gokei_70_74JikoFutanGaku()));
        }

        @Test
        public void get補正済_合計_70未満高額支給額は_entityが持つ補正済_合計_70未満高額支給額を返す() {
            assertThat(sut.get補正済_合計_70未満高額支給額(), is(KogakuGassanJikoFutanGakuEntity.getSumi_Gokei_Under70KogakuShikyuGaku()));
        }

        @Test
        public void get補正済_合計_70_74高額支給額は_entityが持つ補正済_合計_70_74高額支給額を返す() {
            assertThat(sut.get補正済_合計_70_74高額支給額(), is(KogakuGassanJikoFutanGakuEntity.getSumi_Gokei_70_74KogakuShikyuGaku()));
        }

        @Test
        public void get宛先氏名は_entityが持つ宛先氏名を返す() {
            assertThat(sut.get宛先氏名(), is(KogakuGassanJikoFutanGakuEntity.getAtesakiShimei()));
        }

        @Test
        public void get宛先郵便番号は_entityが持つ宛先郵便番号を返す() {
            assertThat(sut.get宛先郵便番号(), is(KogakuGassanJikoFutanGakuEntity.getAtesakiYubinNo()));
        }

        @Test
        public void get宛先住所は_entityが持つ宛先住所を返す() {
            assertThat(sut.get宛先住所(), is(KogakuGassanJikoFutanGakuEntity.getAtesakiJusho()));
        }

        @Test
        public void get窓口払対象者判定コードは_entityが持つ窓口払対象者判定コードを返す() {
            assertThat(sut.get窓口払対象者判定コード(), is(KogakuGassanJikoFutanGakuEntity.getMadoguchi_TaishoshaHanteiCode()));
        }

        @Test
        public void get支払場所は_entityが持つ支払場所を返す() {
            assertThat(sut.get支払場所(), is(KogakuGassanJikoFutanGakuEntity.getShiharaiBasho()));
        }

        @Test
        public void get支払期間開始年月日は_entityが持つ支払期間開始年月日を返す() {
            assertThat(sut.get支払期間開始年月日(), is(KogakuGassanJikoFutanGakuEntity.getShikaraiKaishiYMD()));
        }

        @Test
        public void get支払期間終了年月日は_entityが持つ支払期間終了年月日を返す() {
            assertThat(sut.get支払期間終了年月日(), is(KogakuGassanJikoFutanGakuEntity.getShiharaiShuryoYMD()));
        }

        @Test
        public void get閉庁内容は_entityが持つ閉庁内容を返す() {
            assertThat(sut.get閉庁内容(), is(KogakuGassanJikoFutanGakuEntity.getHeichoNaiyo()));
        }

        @Test
        public void get支払期間開始時間は_entityが持つ支払期間開始時間を返す() {
            assertThat(sut.get支払期間開始時間(), is(KogakuGassanJikoFutanGakuEntity.getShiharaiKaishiTime()));
        }

        @Test
        public void get支払期間終了時間は_entityが持つ支払期間終了時間を返す() {
            assertThat(sut.get支払期間終了時間(), is(KogakuGassanJikoFutanGakuEntity.getShiharaiShuryoTime()));
        }

        @Test
        public void get備考は_entityが持つ備考を返す() {
            assertThat(sut.get備考(), is(KogakuGassanJikoFutanGakuEntity.getBiko()));
        }

        @Test
        public void getデータ作成区分は_entityが持つデータ作成区分を返す() {
            assertThat(sut.getデータ作成区分(), is(KogakuGassanJikoFutanGakuEntity.getDataSakuseiKubun()));
        }

        @Test
        public void get自己負担額確認情報受取年月は_entityが持つ自己負担額確認情報受取年月を返す() {
            assertThat(sut.get自己負担額確認情報受取年月(), is(KogakuGassanJikoFutanGakuEntity.getKakunin_UketoriYM()));
        }

        @Test
        public void get補正済自己負担額情報送付年月は_entityが持つ補正済自己負担額情報送付年月を返す() {
            assertThat(sut.get補正済自己負担額情報送付年月(), is(KogakuGassanJikoFutanGakuEntity.getHoseiZumi_SofuYM()));
        }

        @Test
        public void get自己負担額証明書情報受取年月は_entityが持つ自己負担額証明書情報受取年月を返す() {
            assertThat(sut.get自己負担額証明書情報受取年月(), is(KogakuGassanJikoFutanGakuEntity.getShomeisho_UketoriYM()));
        }

        @Test
        public void get再送フラグは_entityが持つ再送フラグを返す() {
            assertThat(sut.get再送フラグ(), is(KogakuGassanJikoFutanGakuEntity.getSaisoFlag()));
        }

        @Test
        public void get送付対象外フラグは_entityが持つ送付対象外フラグを返す() {
            assertThat(sut.get送付対象外フラグ(), is(KogakuGassanJikoFutanGakuEntity.getSofuTaishoGaiFlag()));
        }

        @Test
        public void get自己負担額計算年月日は_entityが持つ自己負担額計算年月日を返す() {
            assertThat(sut.get自己負担額計算年月日(), is(KogakuGassanJikoFutanGakuEntity.getJikoFutanKeisanYMD()));
        }

        @Test
        public void get自己負担額証明書作成年月日は_entityが持つ自己負担額証明書作成年月日を返す() {
            assertThat(sut.get自己負担額証明書作成年月日(), is(KogakuGassanJikoFutanGakuEntity.getShomeiShoSakuseiYMD()));
        }

        @Test
        public void get後期_国保処理区分は_entityが持つ後期_国保処理区分を返す() {
            assertThat(sut.get後期_国保処理区分(), is(KogakuGassanJikoFutanGakuEntity.getKoki_KokuhoShoriKubun()));
        }
    }

    public static class toEntityテスト extends DbcTestBase {

        private static KogakuGassanJikoFutanGaku sut;

        @Before
        public void setUp() {
            KogakuGassanJikoFutanGakuEntity = DbT3070KogakuGassanJikoFutanGakuEntityGenerator.createDbT3070KogakuGassanJikoFutanGakuEntity();
            KogakuGassanJikoFutanGakuEntity.setHihokenshaNo(主キー名1);
            KogakuGassanJikoFutanGakuEntity.setTaishoNendo(主キー名2);

            sut = new KogakuGassanJikoFutanGaku(KogakuGassanJikoFutanGakuEntity);
        }

        @Test
        public void toEntityはコンストラクタで設定したentityと異なるインスタンスを返す() {
            assertThat(sut.toEntity(), not(KogakuGassanJikoFutanGakuEntity));
        }
    }

    public static class SerializationProxyテスト extends DbcTestBase {

        private static KogakuGassanJikoFutanGaku sut;

        @Before
        public void setUp() {
            KogakuGassanJikoFutanGakuEntity = DbT3070KogakuGassanJikoFutanGakuEntityGenerator.createDbT3070KogakuGassanJikoFutanGakuEntity();
            KogakuGassanJikoFutanGakuEntity.setHihokenshaNo(主キー名1);
            KogakuGassanJikoFutanGakuEntity.setTaishoNendo(主キー名2);

            sut = new KogakuGassanJikoFutanGaku(KogakuGassanJikoFutanGakuEntity);
        }

        @Test
        public void シリアライズできる() {
            assertThat(sut, is(serializable()));
        }
    }

    public static class deletedテスト extends DbcTestBase {

        private static KogakuGassanJikoFutanGaku sut;
        private static KogakuGassanJikoFutanGaku result;

        @Before
        public void setUp() {
            KogakuGassanJikoFutanGakuEntity = DbT3070KogakuGassanJikoFutanGakuEntityGenerator.createDbT3070KogakuGassanJikoFutanGakuEntity();
            KogakuGassanJikoFutanGakuEntity.setHihokenshaNo(主キー名1);
            KogakuGassanJikoFutanGakuEntity.setTaishoNendo(主キー名2);

        }

        @Test
        public void KogakuGassanJikoFutanGakuが保持するDbT3070KogakuGassanJikoFutanGakuEntityのEntityDataStateがUnchangedである場合_deletedメソッド_によりKogakuGassanJikoFutanGakuが保持するDbT3070KogakuGassanJikoFutanGakuEntityのEntityDataStateがDeletedに指定されたKogakuGassanJikoFutanGakuが返る() {
            sut = TestSupport.setStateKogakuGassanJikoFutanGaku(EntityDataState.Unchanged);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void KogakuGassanJikoFutanGakuが保持するDbT3070KogakuGassanJikoFutanGakuEntityのEntityDataStateがModifiedである場合_deletedメソッド_によりKogakuGassanJikoFutanGakuが保持するDbT3070KogakuGassanJikoFutanGakuEntityのEntityDataStateがDeletedに指定されたKogakuGassanJikoFutanGakuが返る() {
            sut = TestSupport.setStateKogakuGassanJikoFutanGaku(EntityDataState.Modified);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void KogakuGassanJikoFutanGakuが保持するDbT3070KogakuGassanJikoFutanGakuEntityのEntityDataStateがDeletedである場合_deletedメソッド_によりKogakuGassanJikoFutanGakuが保持するDbT3070KogakuGassanJikoFutanGakuEntityのEntityDataStateがDeletedに指定されたKogakuGassanJikoFutanGakuが返る() {
            sut = TestSupport.setStateKogakuGassanJikoFutanGaku(EntityDataState.Deleted);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test(expected = IllegalStateException.class)
        public void KogakuGassanJikoFutanGakuが保持するDbT3070KogakuGassanJikoFutanGakuEntityのEntityDataStateがAddedである場合_deletedメソッド_により_IllegalStateExceptionが発火する() {
            sut = TestSupport.setStateKogakuGassanJikoFutanGaku(EntityDataState.Added);
            result = sut.deleted();
        }
    }

    private static class TestSupport {

        public static KogakuGassanJikoFutanGaku setStateKogakuGassanJikoFutanGaku(EntityDataState parentState) {
            KogakuGassanJikoFutanGakuEntity.setState(parentState);
            return new KogakuGassanJikoFutanGaku(KogakuGassanJikoFutanGakuEntity);
        }
    }
}
