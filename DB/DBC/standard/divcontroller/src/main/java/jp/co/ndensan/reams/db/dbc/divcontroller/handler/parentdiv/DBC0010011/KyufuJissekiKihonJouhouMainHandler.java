/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0010011;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.basic.KyufujissekiKihon;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShikibetsuNoKanri;
import jp.co.ndensan.reams.db.dbc.business.core.kyufujissekishokai.KyufuJissekiHedajyoho2;
import jp.co.ndensan.reams.db.dbc.business.core.kyufujissekishokai.KyufuJissekiKihonShukeiRelate;
import jp.co.ndensan.reams.db.dbc.definition.core.jukyushaido.JukyushaIF_KeikakuSakuseiKubunCode;
import jp.co.ndensan.reams.db.dbc.definition.core.keikoku.KeikokuKubun;
import jp.co.ndensan.reams.db.dbc.definition.core.kyufusakuseikubun.KyufuSakuseiKubun;
import jp.co.ndensan.reams.db.dbc.definition.core.kyusochisha.KyuSochiNyushoshaTokureiCode;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0010011.KyufuJissekiKihonJouhouMainDiv;
import jp.co.ndensan.reams.db.dbc.service.core.kyufujissekishokai.KyufuJissekiShokaiFinder;
import jp.co.ndensan.reams.db.dbx.definition.core.codeshubetsu.DBCCodeShubetsu;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenKyufuRitsu;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.NyuryokuShikibetsuNo;
import jp.co.ndensan.reams.db.dbz.definition.core.YokaigoJotaiKubunSupport;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.CodeShubetsu;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.code.CodeMaster;

/**
 * 給付実績照会_基本情報画面
 *
 * @reamsid_L DBC-2970-030 linghuhang
 */
public class KyufuJissekiKihonJouhouMainHandler {

    private final KyufuJissekiKihonJouhouMainDiv div;
    private static final int INT_ZERO = 0;
    private static final int INT_ITI = 1;
    private static final RString 設定不可 = new RString("0");
    private static final RString 総合事業 = new RString("5");
    private static final FlexibleYearMonth 平成２０年４月 = new FlexibleYearMonth("200804");
    private static final FlexibleYearMonth 平成２０年５月 = new FlexibleYearMonth("200805");
    private static final FlexibleYearMonth 平成２０年６月 = new FlexibleYearMonth("200806");
    private static final FlexibleYearMonth 平成２０年７月 = new FlexibleYearMonth("200807");
    private static final FlexibleYearMonth 平成２０年８月 = new FlexibleYearMonth("200808");
    private static final FlexibleYearMonth 平成２１年４月 = new FlexibleYearMonth("200904");

    /**
     * コンストラクタです。
     *
     * @param div 給付実績照会基本情報画面Div
     */
    public KyufuJissekiKihonJouhouMainHandler(KyufuJissekiKihonJouhouMainDiv div) {
        this.div = div;
    }

    /**
     * 画面の初期化メソッドです。
     *
     * @param サービス提供年月 サービス提供年月
     * @param 識別番号検索キー 識別番号検索キー
     * @param 識別番号管理データ 識別番号管理データ
     * @param 給付実績基本情報 給付実績基本情報
     * @param 事業者番号リスト 事業者番号リスト
     * @param 給付実績基本 給付実績基本
     * @param 事業所名称 事業所名称
     * @param 給付分類区分 給付分類区分
     * @param 整理番号 整理番号
     */
    public void onLoad(KyufuJissekiKihonShukeiRelate 実績基本集計データ) {
        if (実績基本集計データ.get識別番号管理() != null) {
            set各ボタン活性非活性設定(実績基本集計データ.get識別番号管理());
        }
        div.getCcdKyufuJissekiHeader().set被保情報2(実績基本集計データ);
        KyufujissekiKihon 給付実績基本 = 実績基本集計データ.get給付実績基本データ();
        if (給付実績基本 != null) {
            set申請内容エリア(給付実績基本);
            set合計内容エリア(給付実績基本);
        }
        set表示制御(給付実績基本.getサービス提供年月(), 給付実績基本.get入力識別番号());
        //set月ボタン(getサービス提供年月リスト(給付実績基本情報), サービス提供年月);
        //set事業者ボタン(事業者番号リスト, 整理番号, サービス提供年月);
    }

    private RString get事業所名称(KyufujissekiKihon 給付実績基本, FlexibleYearMonth サービス提供年月) {
        if (給付実績基本 == null) {
            return RString.EMPTY;
        }
        return KyufuJissekiShokaiFinder.createInstance().getJikyoshaName(給付実績基本.get事業者番号(), サービス提供年月);
    }

    private RString get給付分類区分(KyufujissekiKihon 給付実績基本, FlexibleYearMonth サービス提供年月) {
        if (給付実績基本 == null) {
            return RString.EMPTY;
        }
        return KyufuJissekiShokaiFinder.createInstance().get給付分類区分(給付実績基本.get入力識別番号(), サービス提供年月);
    }

    /**
     * 「前事業者」ボタンを押下する場合、画面を表示する。
     *
     * @param 該当給付実績基本集計データ 該当給付実績基本集計データ
     */
    public void setデータ(KyufuJissekiKihonShukeiRelate 該当給付実績基本集計データ) {
        KyufujissekiKihon 給付実績基本 = 該当給付実績基本集計データ.get給付実績基本データ();
        div.getCcdKyufuJissekiHeader().set被保情報2(該当給付実績基本集計データ);
        if (給付実績基本 != null) {
            set申請内容エリア(給付実績基本);
            set合計内容エリア(給付実績基本);
        }
        set合計エリア閉();
    }

    /**
     * 「後事業者」ボタンを押下する場合、画面を表示する。
     *
     * @param 給付実績ヘッダ情報2 給付実績ヘッダ情報2
     * @param サービス提供年月 サービス提供年月
     * @param 事業所番号 事業所番号
     * @param 後整理番号 後整理番号
     * @param 識別番号 識別番号
     * @param 給付実績区分コード 給付実績区分コード
     * @param 事業者名称 事業者名称
     * @param 識別番号名称 識別番号名称
     * @param 給付実績基本 給付実績基本
     * @param 事業所名称 事業所名称
     * @param 給付分類区分 給付分類区分
     * @param 給付実績基本情報 給付実績基本情報
     * @param 給付実績ヘッダ情報２ 給付実績ヘッダ情報２
     */
    public void onClick_Jigyosha(KyufuJissekiHedajyoho2 給付実績ヘッダ情報2, FlexibleYearMonth サービス提供年月,
            JigyoshaNo 事業所番号, RString 後整理番号, RString 識別番号, RString 給付実績区分コード,
            RString 事業者名称, RString 識別番号名称, KyufujissekiKihon 給付実績基本,
            RString 事業所名称, RString 給付分類区分,
            List<KyufujissekiKihon> 給付実績基本情報, List<KyufuJissekiHedajyoho2> 給付実績ヘッダ情報２) {
        div.getBtnMaeJigyosha().setDisabled(false);
        div.getCcdKyufuJissekiHeader().set事業者名称(事業者名称);
        div.getCcdKyufuJissekiHeader().set実績区分(給付実績区分コード);
        div.getCcdKyufuJissekiHeader().set整理番号(後整理番号);
        div.getCcdKyufuJissekiHeader().set識別番号名称(識別番号名称);
        div.getCcdKyufuJissekiHeader().set事業者番号(事業所番号.value());
        div.getCcdKyufuJissekiHeader().set様式番号(識別番号);
        if (給付実績基本 != null) {
            set申請内容エリア(給付実績基本);
            set合計内容エリア(給付実績基本);
        }
        set合計エリア閉();
        set事業者ボタン(給付実績ヘッダ情報２, 後整理番号, サービス提供年月);
    }

    /**
     * 「前月」ボタンを押下する場合、画面を表示します。
     *
     * @param サービス提供年月 サービス提供年月
     * @param 給付実績基本 給付実績基本
     * @param 被保険者番号 被保険者番号
     * @param 識別番号検索キー 識別番号検索キー
     * @param 整理番号 整理番号
     * @param 事業所名称 事業所名称
     * @param 給付分類区分 給付分類区分
     * @param 給付実績基本情報 給付実績基本情報
     * @param 給付実績ヘッダ情報２ 給付実績ヘッダ情報２
     * @param サービス提供年月リスト サービス提供年月リスト
     */
    public void onClick_Zengetsu(FlexibleYearMonth サービス提供年月, KyufujissekiKihon 給付実績基本,
            HihokenshaNo 被保険者番号, RString 整理番号, NyuryokuShikibetsuNo 識別番号検索キー, RString 事業所名称,
            RString 給付分類区分, List<KyufujissekiKihon> 給付実績基本情報, List<KyufuJissekiHedajyoho2> 給付実績ヘッダ情報２,
            List<FlexibleYearMonth> サービス提供年月リスト) {
        div.getBtnJigetsu().setDisabled(false);
        if (給付実績基本 != null) {
            set申請内容エリア(給付実績基本);
            set合計内容エリア(給付実績基本);
        }
        set合計エリア閉();
        set月ボタン(サービス提供年月リスト, サービス提供年月);
        set事業者ボタン(給付実績ヘッダ情報２, 整理番号, サービス提供年月);
    }

    /**
     * 次月ボタンを押下する場合、画面を表示します。
     *
     * @param サービス提供年月 サービス提供年月
     * @param 給付実績基本 給付実績基本
     * @param 被保険者番号 被保険者番号
     * @param 識別番号検索キー 識別番号検索キー
     * @param 整理番号 整理番号
     * @param 事業所名称 事業所名称
     * @param 給付分類区分 給付分類区分
     * @param 給付実績基本情報 給付実績基本情報
     * @param 給付実績ヘッダ情報２ 給付実績ヘッダ情報２
     * @param サービス提供年月リスト サービス提供年月リスト
     */
    public void onClick_Jigetsu(FlexibleYearMonth サービス提供年月, KyufujissekiKihon 給付実績基本,
            HihokenshaNo 被保険者番号, RString 整理番号, NyuryokuShikibetsuNo 識別番号検索キー, RString 事業所名称,
            RString 給付分類区分, List<KyufujissekiKihon> 給付実績基本情報, List<KyufuJissekiHedajyoho2> 給付実績ヘッダ情報２,
            List<FlexibleYearMonth> サービス提供年月リスト) {
        div.getBtnZengetsu().setDisabled(false);
        if (給付実績基本 != null) {
            set申請内容エリア(給付実績基本);
            set合計内容エリア(給付実績基本);
        }
        set合計エリア閉();
        set月ボタン(サービス提供年月リスト, サービス提供年月);
        set事業者ボタン(給付実績ヘッダ情報２, 整理番号, サービス提供年月);
    }

    private void set各ボタン活性非活性設定(ShikibetsuNoKanri 識別番号管理データ) {
        div.getBtnMeisaiShukei().setDisabled(false);
        div.getBtnKinkyujiShisetsuRyoyo().setDisabled(false);
        div.getBtnShoteiShikkanShisetsuRyoyo().setDisabled(false);
        div.getBtnShokuji().setDisabled(false);
        div.getBtnFukushiYoguKonyu().setDisabled(false);
        div.getBtnTokuteiNyushosha().setDisabled(false);
        div.getBtnKogakuKaigoService().setDisabled(false);
        div.getBtnTokuteiShinryo().setDisabled(false);
        div.getBtnKyotakuServiceKeikaku().setDisabled(false);
        div.getBtnJutakuKaishu().setDisabled(false);
        div.getBtnCareManagement().setDisabled(false);
        div.getBtnShafukuKeigen().setDisabled(false);
        if (設定不可.equals(識別番号管理データ.get明細設定区分())) {
            div.getBtnMeisaiShukei().setDisabled(true);
        }
        if (設定不可.equals(識別番号管理データ.get所定疾患施設療養設定区分())) {
            div.getBtnShoteiShikkanShisetsuRyoyo().setDisabled(true);
        }
        if (設定不可.equals(識別番号管理データ.get食事費用設定区分())) {
            div.getBtnShokuji().setDisabled(true);
        }
        if (設定不可.equals(識別番号管理データ.get福祉用具購入費設定区分())) {
            div.getBtnFukushiYoguKonyu().setDisabled(true);
        }
        if (設定不可.equals(識別番号管理データ.get特定入所者設定区分())) {
            div.getBtnTokuteiNyushosha().setDisabled(true);
        }
        if (設定不可.equals(識別番号管理データ.get高額介護サービス費設定区分())) {
            div.getBtnKogakuKaigoService().setDisabled(true);
        }
        if (設定不可.equals(識別番号管理データ.get特定診療費設定区分())) {
            div.getBtnTokuteiShinryo().setDisabled(true);
        }
        if (設定不可.equals(識別番号管理データ.get居宅計画費設定区分())) {
            div.getBtnKyotakuServiceKeikaku().setDisabled(true);
        }
        if (設定不可.equals(識別番号管理データ.get住宅改修費設定区分())) {
            div.getBtnJutakuKaishu().setDisabled(true);
        }
        if (設定不可.equals(識別番号管理データ.getケアマネジメント設定区分())) {
            div.getBtnCareManagement().setDisabled(true);
        }
        if (設定不可.equals(識別番号管理データ.get社会福祉法人軽減設定区分())) {
            div.getBtnShafukuKeigen().setDisabled(true);
        }
        if (設定不可.equals(識別番号管理データ.get緊急時施設療養設定区分())) {
            div.getBtnKinkyujiShisetsuRyoyo().setDisabled(true);
        }
    }

    private void set表示制御(FlexibleYearMonth サービス提供年月, NyuryokuShikibetsuNo 識別番号検索キー) {
        div.getTxtKyufuJissekiKihonChushiRiyu().setVisible(true);
        div.getTxtKyufuJissekiKihonNyushoMaeJokyo().setVisible(true);
        if (平成２１年４月.isBeforeOrEquals(サービス提供年月) && get識別番号リスト().contains(識別番号検索キー)) {
            div.getTxtKyufuJissekiKihonChushiRiyu().setVisible(false);
        }
        if (サービス提供年月.isBefore(平成２１年４月)
                || (平成２１年４月.isBeforeOrEquals(サービス提供年月) && !get識別番号リスト().contains(識別番号検索キー))) {
            div.getTxtKyufuJissekiKihonNyushoMaeJokyo().setVisible(false);
        }
    }

    private List<NyuryokuShikibetsuNo> get識別番号リスト() {
        List<NyuryokuShikibetsuNo> 識別番号リスト = new ArrayList<>();
        識別番号リスト.add(new NyuryokuShikibetsuNo(new RString("2171")));
        識別番号リスト.add(new NyuryokuShikibetsuNo(new RString("2172")));
        識別番号リスト.add(new NyuryokuShikibetsuNo(new RString("2173")));
        識別番号リスト.add(new NyuryokuShikibetsuNo(new RString("2174")));
        識別番号リスト.add(new NyuryokuShikibetsuNo(new RString("2181")));
        識別番号リスト.add(new NyuryokuShikibetsuNo(new RString("2182")));
        識別番号リスト.add(new NyuryokuShikibetsuNo(new RString("2183")));
        識別番号リスト.add(new NyuryokuShikibetsuNo(new RString("2191")));
        識別番号リスト.add(new NyuryokuShikibetsuNo(new RString("2192")));
        識別番号リスト.add(new NyuryokuShikibetsuNo(new RString("2193")));
        識別番号リスト.add(new NyuryokuShikibetsuNo(new RString("2194")));
        識別番号リスト.add(new NyuryokuShikibetsuNo(new RString("2195")));
        識別番号リスト.add(new NyuryokuShikibetsuNo(new RString("21A1")));
        識別番号リスト.add(new NyuryokuShikibetsuNo(new RString("21A2")));
        識別番号リスト.add(new NyuryokuShikibetsuNo(new RString("21A3")));
        return 識別番号リスト;
    }

    private void set申請内容エリア(KyufujissekiKihon 給付実績基本情報) {
        div.getTxtKyufuJissekiKihonSakuseiKubun().setValue(get作成区分(給付実績基本情報.get給付実績情報作成区分コード()));
        if (!RString.isNullOrEmpty(給付実績基本情報.get要介護状態区分コード())) {
            div.getTxtKyufuJissekiKihonYokaigodo().setValue(YokaigoJotaiKubunSupport.toValue(給付実績基本情報.getサービス提供年月(),
                    給付実績基本情報.get要介護状態区分コード()).getName());
        }
        if (給付実績基本情報.get認定有効期間_開始年月日() != null && 給付実績基本情報.get認定有効期間_開始年月日().isWareki()) {
            div.getTxtYukoKaishiYMD().setValue(new RDate(給付実績基本情報.get認定有効期間_開始年月日().toString()));
        }
        if (給付実績基本情報.get認定有功期間_終了年月日() != null && 給付実績基本情報.get認定有功期間_終了年月日().isWareki()) {
            div.getTxtYukoShuryoYMD().setValue(new RDate(給付実績基本情報.get認定有功期間_終了年月日().toString()));
        }
        if (給付実績基本情報.get審査年月() != null && 給付実績基本情報.get審査年月().isWareki()) {
            div.getTxtKyufuJissekiKihonShinsaYM().setValue(new RDate(給付実績基本情報.get審査年月().toString()));
        }
        div.getTxtKyufuJissekiKihonKeikokuKubun().setValue(get警告区分(給付実績基本情報.get警告区分コード()));
        div.getTxtKyufuJissekiKihonKyusochiNyushoshaTokurei().setValue(
                get旧措置入所者特例(給付実績基本情報.get旧措置入所者特例コード()));
        if (INT_ZERO != 給付実績基本情報.get後_保険_サービス単位数()) {
            div.getTxtServiceTankasu().setValue(new Decimal(給付実績基本情報.get後_保険_サービス単位数()));
        }
        if (給付実績基本情報.get後_保険_請求額() != null && INT_ZERO != 給付実績基本情報.get後_保険_請求額().intValue()) {
            div.getTxtHokenryoSeikyuGaku().setValue(給付実績基本情報.get後_保険_請求額());
        }
        if (INT_ZERO != 給付実績基本情報.get後_保険_利用者負担額()) {
            div.getTxtRiyoshaFutanGaku().setValue(new Decimal(給付実績基本情報.get後_保険_利用者負担額()));
        }
        set被保険者エリア(給付実績基本情報);
        set後期高齢と国保エリア(給付実績基本情報, 給付実績基本情報.getサービス提供年月());
        set居宅サービス計画エリア(給付実績基本情報);
        setサービス期間エリア(給付実績基本情報);
        set施設入退所_院エリア(給付実績基本情報);
        set給付率と公費エリア(給付実績基本情報);
    }

    private void set合計内容エリア(KyufujissekiKihon 給付実績基本情報) {
        div.getTxtMaeHokenServiceTanisu().setValue(new Decimal(給付実績基本情報.get前_保険_サービス単位数()));
        div.getTxtGoHokenServiceTanisu().setValue(new Decimal(給付実績基本情報.get後_保険_サービス単位数()));
        div.getTxtMaeKohi1ServiceTanisu().setValue(new Decimal(給付実績基本情報.get前_公費１_サービス単位数()));
        div.getTxtGoKohi1ServiceTanisu().setValue(new Decimal(給付実績基本情報.get後_公費１_サービス単位数()));
        div.getTxtMaeKohi2ServiceTanisu().setValue(new Decimal(給付実績基本情報.get前_公費２_サービス単位数()));
        div.getTxtGoKohi2ServiceTanisu().setValue(new Decimal(給付実績基本情報.get後_公費２_サービス単位数()));
        div.getTxtMaeKohi3ServiceTanisu().setValue(new Decimal(給付実績基本情報.get前_公費３_サービス単位数()));
        div.getTxtGoKohi3ServiceTanisu().setValue(new Decimal(給付実績基本情報.get後_公費３_サービス単位数()));
        div.getTxtMaeHokenHokenSeikyugaku().setValue(給付実績基本情報.get前_保険_請求額());
        div.getTxtGoHokenHokenSeikyugaku().setValue(給付実績基本情報.get後_保険_請求額());
        div.getTxtMaeKohi1HokenSeikyugaku().setValue(new Decimal(給付実績基本情報.get前_公費１_請求額()));
        div.getTxtGoKohi1HokenSeikyugaku().setValue(new Decimal(給付実績基本情報.get後_公費１_請求額()));
        div.getTxtMaeKohi2HokenSeikyugaku().setValue(new Decimal(給付実績基本情報.get前_公費２_請求額()));
        div.getTxtGoKohi2HokenSeikyugaku().setValue(new Decimal(給付実績基本情報.get後_公費２_請求額()));
        div.getTxtMaeKohi3HokenSeikyugaku().setValue(new Decimal(給付実績基本情報.get前_公費３_請求額()));
        div.getTxtGoKohi3HokenSeikyugaku().setValue(new Decimal(給付実績基本情報.get後_公費３_請求額()));
        div.getTxtMaeHokenRiyoshaFutangaku().setValue(new Decimal(給付実績基本情報.get前_保険_利用者負担額()));
        div.getTxtGoHokenRiyoshaFutangaku().setValue(new Decimal(給付実績基本情報.get後_保険_利用者負担額()));
        div.getTxtMaeKohi1RiyoshaFutangaku().setValue(new Decimal(給付実績基本情報.get前_公費１_本人負担額()));
        div.getTxtGoKohi1RiyoshaFutangaku().setValue(new Decimal(給付実績基本情報.get後_公費１_本人負担額()));
        div.getTxtMaeKohi2RiyoshaFutangaku().setValue(new Decimal(給付実績基本情報.get前_公費２_本人負担額()));
        div.getTxtGoKohi2RiyoshaFutangaku().setValue(new Decimal(給付実績基本情報.get後_公費２_利用者負担額()));
        div.getTxtMaeKohi3RiyoshaFutangaku().setValue(new Decimal(給付実績基本情報.get前_公費３_本人負担額()));
        div.getTxtGoKohi3RiyoshaFutangaku().setValue(new Decimal(給付実績基本情報.get後_公費３_利用者負担額()));
        div.getTxtMaeHokenKinkyujiShisetsuRyoyohi().setValue(給付実績基本情報.get前_保険_緊急時施設療養費請求額());
        div.getTxtGoHokenKinkyujiShisetsuRyoyohi().setValue(給付実績基本情報.get後_緊急時施設療養費請求額());
        div.getTxtMaeKohi1KinkyujiShisetsuRyoyohi().setValue(new Decimal(給付実績基本情報.get前_公費１_緊急時施設療養費請求額()));
        div.getTxtGoKohi1KinkyujiShisetsuRyoyohi().setValue(new Decimal(給付実績基本情報.get後_公費１_緊急時施設療養費請求額()));
        div.getTxtMaeKohi2KinkyujiShisetsuRyoyohi().setValue(new Decimal(給付実績基本情報.get前_公費２_緊急時施設療養費請求額()));
        div.getTxtGoKohi2KinkyujiShisetsuRyoyohi().setValue(new Decimal(給付実績基本情報.get後_公費２_緊急時施設療養費請求額()));
        div.getTxtMaeKohi3KinkyujiShisetsuRyoyohi().setValue(new Decimal(給付実績基本情報.get前_公費３_緊急時施設療養費請求額()));
        div.getTxtGoKohi3KinkyujiShisetsuRyoyohi().setValue(new Decimal(給付実績基本情報.get後_公費３_緊急時施設療養費請求額()));
        div.getTxtMaeHokenTokuteiShinryohi().setValue(給付実績基本情報.get前_保険_特定診療費請求額());
        div.getTxtGoHokenTokuteiShinryohi().setValue(給付実績基本情報.get後_保険_特定診療費請求額());
        div.getTxtMaeKohi1TokuteiShinryohi().setValue(new Decimal(給付実績基本情報.get前_公費１_特定診療費請求額()));
        div.getTxtGoKohi1TokuteiShinryohi().setValue(new Decimal(給付実績基本情報.get後_公費１_特定診療費請求額()));
        div.getTxtMaeKohi2TokuteiShinryohi().setValue(new Decimal(給付実績基本情報.get前_公費２_特定診療費請求額()));
        div.getTxtGoKohi2TokuteiShinryohi().setValue(new Decimal(給付実績基本情報.get後_公費２_特定診療費請求額()));
        div.getTxtMaeKohi3TokuteiShinryohi().setValue(new Decimal(給付実績基本情報.get前_公費３_特定診療費請求額()));
        div.getTxtGoKohi3TokuteiShinryohi().setValue(new Decimal(給付実績基本情報.get後_公費３_緊急時施設療養費請求額()));
        div.getTxtMaeHokenTokuteiNyushosha().setValue(new Decimal(給付実績基本情報.get前_保険_特定入所者介護サービス費等請求額()));
        div.getTxtGoHokenTokuteiNyushosha().setValue(new Decimal(給付実績基本情報.get後_保険_特定入所者介護サービス費等請求額()));
        div.getTxtMaeKohi1TokuteiNyushosha().setValue(new Decimal(給付実績基本情報.get前_公費１_特定入所者介護サービス費等請求額()));
        div.getTxtGoKohi1TokuteiNyushosha().setValue(new Decimal(給付実績基本情報.get後_公費１_特定入所者介護サービス費等請求額()));
        div.getTxtMaeKohi2TokuteiNyushosha().setValue(new Decimal(給付実績基本情報.get前_公費２_特定入所者介護サービス費等請求額()));
        div.getTxtGoKohi2TokuteiNyushosha().setValue(new Decimal(給付実績基本情報.get後_公費２_特定入所者介護サービス費等請求額()));
        div.getTxtMaeKohi3TokuteiNyushosha().setValue(new Decimal(給付実績基本情報.get前_公費３_特定入所者介護サービス費等請求額()));
        div.getTxtGoKohi3TokuteiNyushosha().setValue(new Decimal(給付実績基本情報.get後_公費３_特定入所者介護サービス費等請求額()));
    }

    private void set被保険者エリア(KyufujissekiKihon 給付実績基本情報) {
        div.getTxtKyufuJissekiKihonRojinHokenShichosonNo().setValue(給付実績基本情報.get老人保健市町村番号());
        div.getTxtKyufuJissekiKihonRojinHokenJukyushaNo().setValue(給付実績基本情報.get老人保健受給者番号());
    }

    private void set後期高齢と国保エリア(KyufujissekiKihon 給付実績基本情報, FlexibleYearMonth サービス提供年月) {
        if (平成２０年４月.isBeforeOrEquals(サービス提供年月)) {
            div.getTxtKyufuJissekiKihonKokiKoreiHokenshaNo().setValue(給付実績基本情報.get保険者番号_後期());
        }
        if (平成２０年５月.isBeforeOrEquals(サービス提供年月)) {
            div.getTxtKyufuJissekiKihonKokiKoreiHihokenshaNo().setValue(給付実績基本情報.get被保険者番号_後期());
        }
        if (平成２０年６月.isBeforeOrEquals(サービス提供年月)) {
            div.getTxtKyufuJissekiKihonKokuhoHokenshaNo().setValue(給付実績基本情報.get保険者番号_国保());
        }
        if (平成２０年７月.isBeforeOrEquals(サービス提供年月)) {
            div.getTxtKyufuJissekiKihonKokuhoHihokenshashoNo().setValue(給付実績基本情報.get被保険者証番号_国保());
        }
        if (平成２０年８月.isBeforeOrEquals(サービス提供年月)) {
            div.getTxtKyufuJissekiKihonKokuhoKojinNo().setValue(給付実績基本情報.get個人番号_国保());
        }
    }

    private void set居宅サービス計画エリア(KyufujissekiKihon 給付実績基本情報) {
        div.getTxtKyufuJissekiKihonKyotakuServiceKeikakuSakuseiKubun().setValue(
                get計画作成区分(給付実績基本情報.get居宅サービス計画作成区分コード()));
        div.getTxtKyufuJissekiKihonJigyoshoNo().setValue(
                get居宅介護支援事業所番号(給付実績基本情報.get居宅介護支援事業所番号()));
        div.getTxtKyufuJissekiKihonJigyoshoName().setValue(get事業所名称(給付実績基本情報, 給付実績基本情報.getサービス提供年月()));
    }

    private void setサービス期間エリア(KyufujissekiKihon 給付実績基本情報) {
        if (給付実績基本情報.get開始年月日() != null && 給付実績基本情報.get開始年月日().isWareki()) {
            div.getTxtKyufuJissekiKihonKaishiYMD().setValue(new RDate(給付実績基本情報.get開始年月日().toString()));
        }
        if (給付実績基本情報.get中止年月日() != null && 給付実績基本情報.get中止年月日().isWareki()) {
            div.getTxtKyufuJissekiKihonChushiYMD().setValue(new RDate(給付実績基本情報.get中止年月日().toString()));
        }
        div.getTxtKyufuJissekiKihonChushiRiyu().setValue(get中止理由(DBCCodeShubetsu.中止理由コード.getコード(),
                給付実績基本情報.get中止理由_入所_院_前の状況コード()));
    }

    private void set施設入退所_院エリア(KyufujissekiKihon 給付実績基本情報) {
        if (給付実績基本情報.get入所_院_年月日() != null && 給付実績基本情報.get入所_院_年月日().isWareki()) {
            div.getTxtKyufuJissekiKihonNyushoYMD().setValue(new RDate(給付実績基本情報.get入所_院_年月日().toString()));
        }
        div.getTxtKyufuJissekiKihonNyushoJitsuNissu().setValue(new RString(給付実績基本情報.get入所_院_実日数()));
        if (給付実績基本情報.get退所_院_年月日() != null && 給付実績基本情報.get退所_院_年月日().isWareki()) {
            div.getTxtKyufuJissekiKihonTaishoYMD().setValue(new RDate(給付実績基本情報.get退所_院_年月日().toString()));
        }
        div.getTxtKyufuJissekiKihonGaihakuNissu().setValue(new RString(給付実績基本情報.get外泊日数()));

        div.getTxtKyufuJissekiKihonNyushoMaeJokyo().setValue(get中止理由(DBCCodeShubetsu.入所_院_前の状況コード.getコード(),
                給付実績基本情報.get中止理由_入所_院_前の状況コード()));
        div.getTxtKyufuJissekiKihonNyushoAtoJokyo().setValue(get中止理由(DBCCodeShubetsu.退所_院_後の状態コード.getコード(),
                給付実績基本情報.get退所_院_後の状態コード()));
    }

    private void set給付率と公費エリア(KyufujissekiKihon 給付実績基本情報) {
        div.getTxtKyufuJissekiKihonHokenKyufuRitsu().setValue(get給付率(給付実績基本情報.get保険給付率()));
        div.getTxtKyufuJissekiKihonKohi1KyufuRitsu().setValue(get給付率(給付実績基本情報.get公費１給付率()));
        div.getTxtKyufuJissekiKihonKohi2KyufuRitsu().setValue(get給付率(給付実績基本情報.get公費２給付率()));
        div.getTxtKyufuJissekiKihonKohi3KyufuRitsu().setValue(get給付率(給付実績基本情報.get公費３給付率()));
        div.getTxtKyufuJissekiKihonKohiFutanshaNo1().setValue(給付実績基本情報.get公費１_負担者番号());
        div.getTxtKyufuJissekiKihonKohiJukyushaNo1().setValue(給付実績基本情報.get公費１_受給者番号());
        div.getTxtKyufuJissekiKihonKohiFutanshaNo2().setValue(給付実績基本情報.get公費２_負担者番号());
        div.getTxtKyufuJissekiKihonKohiJukyushaNo2().setValue(給付実績基本情報.get公費２_受給者番号());
        div.getTxtKyufuJissekiKihonKohiFutanshaNo3().setValue(給付実績基本情報.get公費３_負担者番号());
        div.getTxtKyufuJissekiKihonKohiJukyushaNo3().setValue(給付実績基本情報.get公費３_受給者番号());
        RString 給付分類区分 = get給付分類区分(給付実績基本情報, 給付実績基本情報.getサービス提供年月());
        if (!RString.isNullOrEmpty(給付分類区分) && 総合事業.equals(給付分類区分)) {
            div.getTxtKyufuJissekiKihonHokenKyufuRitsu().setLabelLText(new RString("事業"));
        }
    }

    private RString get作成区分(RString 給付実績情報作成区分コード) {
        if (!RString.isNullOrEmpty(給付実績情報作成区分コード)) {
            return KyufuSakuseiKubun.toValue(給付実績情報作成区分コード).get名称();
        }
        return RString.EMPTY;
    }

    private RString get警告区分(RString 警告区分コード) {
        if (!RString.isNullOrEmpty(警告区分コード)) {
            return KeikokuKubun.toValue(警告区分コード).get名称();
        }
        return RString.EMPTY;
    }

    private RString get旧措置入所者特例(RString 旧措置入所者特例コード) {
        if (!RString.isNullOrEmpty(旧措置入所者特例コード)) {
            return KyuSochiNyushoshaTokureiCode.toValue(旧措置入所者特例コード).get名称();
        }
        return RString.EMPTY;
    }

    private RString get計画作成区分(RString 居宅サービス計画作成区分コード) {
        if (!RString.isNullOrEmpty(居宅サービス計画作成区分コード) && !設定不可.equals(居宅サービス計画作成区分コード)) {
            return JukyushaIF_KeikakuSakuseiKubunCode.toValue(居宅サービス計画作成区分コード).get名称();
        }
        return RString.EMPTY;
    }

    private RString get居宅介護支援事業所番号(JigyoshaNo 居宅介護支援事業所番号) {
        if (居宅介護支援事業所番号 != null && !居宅介護支援事業所番号.isEmpty()) {
            return 居宅介護支援事業所番号.value();
        }
        return RString.EMPTY;
    }

    private RString get中止理由(CodeShubetsu コード種別, RString 中止理由コード) {
        if (!RString.isNullOrEmpty(中止理由コード)) {
            return CodeMaster.getCodeMeisho(コード種別, new Code(中止理由コード), new FlexibleDate(RDate.getNowDate().toDateString()));
        }
        return RString.EMPTY;
    }

    private RString get給付率(HokenKyufuRitsu 給付率) {
        if (給付率 != null && 給付率.value() != null) {
            return new RString(給付率.value().intValue());
        }
        return RString.EMPTY;
    }

    private void set合計エリア閉() {
        if (div.getKyufuJissekiKihonGokeiPanel().isIsOpen()) {
            div.getKyufuJissekiKihonGokeiPanel().setIsOpen(false);
        }
    }

    private int get事業者番号の位置(List<KyufuJissekiHedajyoho2> 事業者番号リスト,
            RString 整理番号, RString 事業者番号, RString 様式番号, FlexibleYearMonth サービス提供年月, RString 実績区分コード) {
        for (int index = 0; index < 事業者番号リスト.size(); index++) {
            if (事業者番号.equals(事業者番号リスト.get(index).get事業所番号().value())
                    && 整理番号.equals(事業者番号リスト.get(index).get整理番号())
                    && 様式番号.equals(事業者番号リスト.get(index).get識別番号())
                    && サービス提供年月.equals(事業者番号リスト.get(index).getサービス提供年月())
                    && 実績区分コード.equals(事業者番号リスト.get(index).get給付実績区分コード())) {
                return index;
            }
        }
        return INT_ZERO;
    }

    private void set事業者ボタン(List<KyufuJissekiHedajyoho2> 事業者番号リスト,
            RString 整理番号, FlexibleYearMonth サービス提供年月) {
        RString 事業者番号 = div.getCcdKyufuJissekiHeader().get事業者番号();
        RString 様式番号 = div.getCcdKyufuJissekiHeader().get様式番号();
        RString 実績区分コード = div.getCcdKyufuJissekiHeader().get実績区分コード();
        div.getBtnMaeJigyosha().setDisabled(true);
        div.getBtnAtoJigyosha().setDisabled(true);
        if (!事業者番号リスト.isEmpty()) {
            int index = get事業者番号の位置(事業者番号リスト, 整理番号, 事業者番号, 様式番号, サービス提供年月, 実績区分コード);
            if (0 < index) {
                div.getBtnMaeJigyosha().setDisabled(false);
            }
            if (index + INT_ITI < 事業者番号リスト.size()) {
                div.getBtnAtoJigyosha().setDisabled(false);
            }
        }
    }

    private void set月ボタン(List<FlexibleYearMonth> サービス提供年月リスト, FlexibleYearMonth サービス提供年月) {
        div.getBtnZengetsu().setDisabled(true);
        div.getBtnJigetsu().setDisabled(true);
        if (サービス提供年月リスト != null && !サービス提供年月リスト.isEmpty()) {
            Collections.sort(サービス提供年月リスト, new DateComparatorServiceTeikyoYM());
            if (!サービス提供年月.isBeforeOrEquals(サービス提供年月リスト.get(サービス提供年月リスト.size() - 1))) {
                div.getBtnZengetsu().setDisabled(false);
            }
            if (!サービス提供年月リスト.get(INT_ZERO).isBeforeOrEquals(サービス提供年月)) {
                div.getBtnJigetsu().setDisabled(false);
            }
        }
    }

    private List<FlexibleYearMonth> getサービス提供年月リスト(List<KyufujissekiKihon> 給付実績基本情報) {
        List<FlexibleYearMonth> 提供年月リスト = new ArrayList<>();
        for (KyufujissekiKihon 給付実績基本 : 給付実績基本情報) {
            FlexibleYearMonth 提供年月 = 給付実績基本.getサービス提供年月();
            if (!提供年月リスト.contains(提供年月)) {
                提供年月リスト.add(提供年月);
            }
        }
        return 提供年月リスト;
    }

    private static class DateComparatorServiceTeikyoYM implements Comparator<FlexibleYearMonth>, Serializable {

        @Override
        public int compare(FlexibleYearMonth o1, FlexibleYearMonth o2) {
            return o2.compareTo(o1);
        }
    }
}
