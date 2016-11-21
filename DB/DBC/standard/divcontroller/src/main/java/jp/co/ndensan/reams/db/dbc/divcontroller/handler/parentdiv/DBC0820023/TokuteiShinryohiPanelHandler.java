/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0820023;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShikibetsuNoKanri;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShokanTokuteiShinryoTokubetsuRyoyo;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShokanTokuteiShinryoTokubetsuRyoyoBuilder;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShokanTokuteiShinryohi;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShokanTokuteiShinryohiBuilder;
import jp.co.ndensan.reams.db.dbc.business.core.basic.TokuteiShinryoServiceCode;
import jp.co.ndensan.reams.db.dbc.business.core.dbjoho.DbJohoViewState;
import jp.co.ndensan.reams.db.dbc.definition.core.shoukanharaihishinseikensaku.ShoukanharaihishinseimeisaikensakuParameter;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0820023.TokuteiShinryohiPanelDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0820023.ddgToteishinryoTokubetushinryo_Row;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0820023.dgdTokuteiShinryohi_Row;
import jp.co.ndensan.reams.db.dbc.service.core.shokanbaraijyokyoshokai.ShokanbaraiJyokyoShokai;
import jp.co.ndensan.reams.db.dbc.service.core.syokanbaraihishikyushinseikette.SyokanbaraihiShikyuShinseiKetteManager;
import jp.co.ndensan.reams.db.dbd.business.core.basic.ShokanKihon;
import jp.co.ndensan.reams.db.dbx.definition.core.codeshubetsu.DBCCodeShubetsu;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.binding.RowState;
import jp.co.ndensan.reams.uz.uza.ui.binding.propertyenum.IconName;
import jp.co.ndensan.reams.uz.uza.util.code.CodeMaster;
import jp.co.ndensan.reams.uz.uza.util.code.entity.UzT0007CodeEntity;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import jp.co.ndensan.reams.uz.uza.util.serialization.DataPassingConverter;

/**
 * 償還払い費支給申請決定_サービス提供証明書(特定診療費）のハンドラクラスです。
 *
 * @reamsid_L DBC-1030-110 wangkanglei
 */
public class TokuteiShinryohiPanelHandler {

    private final TokuteiShinryohiPanelDiv div;
    private static final RString 設定不可 = new RString("0");
    private static final RString 設定可必須 = new RString("1");
    private static final RString 設定可任意 = new RString("2");
    private static final RString 修正 = new RString("修正");
    private static final RString 削除 = new RString("削除");
    private static final RString 登録 = new RString("登録");
    private static final RString 単位 = new RString("単位");
    private static final RString 回まで = new RString("回まで");
    private static final FlexibleYearMonth 平成１５年３月 = new FlexibleYearMonth("200303");
    private static final FlexibleYearMonth 平成１５年４月 = new FlexibleYearMonth("200304");
    private static final int NUMBER_３２ = 32;
    private static final int NUMBER_６４ = 64;
    private static final int NUMBER_９６ = 96;
    private static final int NUMBER_１２８ = 128;
    private static final int NUMBER_１６０ = 160;
    private static final int NUMBER_１９２ = 192;
    private static final int NUMBER_２２４ = 224;
    private static final int NUMBER_２５６ = 256;
    private static final int NUMBER_２８８ = 288;
    private static final int NUMBER_３２０ = 320;
    private static final int NUMBER_３５２ = 352;
    private static final int NUMBER_３８４ = 384;
    private static final int NUMBER_４１６ = 416;
    private static final int NUMBER_４４８ = 448;
    private static final int NUMBER_４８０ = 480;
    private static final int NUMBER_５１２ = 512;
    private static final int NUMBER_５４４ = 544;
    private static final int NUMBER_５７６ = 576;
    private static final int NUMBER_６０８ = 608;
    private static final RString 登録_削除 = new RString("登録_削除");

    /**
     * コンストラクタです。
     *
     * @param div TokuteiShinryohiPanelDiv
     */
    public TokuteiShinryohiPanelHandler(TokuteiShinryohiPanelDiv div) {
        this.div = div;
    }

    /**
     * 申請共通エリア設定のメソッドます。
     *
     * @param サービス年月 FlexibleYearMonth
     * @param 事業者番号 JigyoshaNo
     * @param 申請日 RDate
     * @param 明細番号 RString
     * @param 証明書 RString
     * @param 被保険者番号 HihokenshaNo
     * @param 識別コード ShikibetsuCode
     */
    public void set申請共通エリア(
            FlexibleYearMonth サービス年月,
            JigyoshaNo 事業者番号,
            RDate 申請日,
            RString 明細番号,
            RString 証明書,
            HihokenshaNo 被保険者番号,
            ShikibetsuCode 識別コード) {
        div.getPanelTwo().getTxtServiceTeikyoYM().setValue(new RDate(サービス年月.toString()));
        div.getPanelTwo().getTxtShinseiYMD().setValue(申請日);
        div.getPanelTwo().getTxtJigyoshaBango().setValue(事業者番号.getColumnValue());
        div.getPanelTwo().getTxtMeisaibango().setValue(明細番号);
        div.getPanelTwo().getTxtShomeisho().setValue(証明書);
        div.getPanelOne().getCcdKaigoAtenaInfo().initialize(識別コード);
        if (!被保険者番号.isEmpty()) {
            div.getPanelOne().getCcdKaigoShikakuKihon().initialize(被保険者番号);
        } else {
            div.getPanelOne().getCcdKaigoShikakuKihon().setVisible(false);
        }
    }

    /**
     * ボタンを制御設定のメソッドます。
     *
     * @param shikibetsuNoKanri ShikibetsuNoKanri
     * @param meisaiPar 償還払費申請明細検索キー
     */
    public void getボタンを制御(ShikibetsuNoKanri shikibetsuNoKanri,
            ShoukanharaihishinseimeisaikensakuParameter meisaiPar) {

        HihokenshaNo 被保険者番号 = meisaiPar.get被保険者番号();
        FlexibleYearMonth サービス年月 = meisaiPar.getサービス年月();
        RString 整理番号 = meisaiPar.get整理番号();
        JigyoshaNo 事業者番号 = meisaiPar.get事業者番号();
        RString 様式番号 = meisaiPar.get様式番号();
        RString 明細番号 = meisaiPar.get明細番号();
        set基本情報ボタン制御(shikibetsuNoKanri, 被保険者番号, サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号);
        set給付費明細ボタン制御(shikibetsuNoKanri, 被保険者番号, サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号);
        div.getPanelTwo().getBtnTokuteiShiryohi().setDisabled(true);
        setサービス計画費ボタン制御(shikibetsuNoKanri, 被保険者番号, サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号);
        set特定入所者費用ボタン制御(shikibetsuNoKanri, 被保険者番号, サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号);
        div.getPanelTwo().getBtnGokeiinfo().setDisabled(false);
        set給付費明細_住特ボタン制御(shikibetsuNoKanri, 被保険者番号, サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号);
        set緊急時_所定疾患ボタン制御(shikibetsuNoKanri, 被保険者番号, サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号);
        set緊急時施設療養費ボタン制御(shikibetsuNoKanri, 被保険者番号, サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号);
        set食事費用ボタン制御(shikibetsuNoKanri, 被保険者番号, サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号);
        set請求額集計ボタン制御(shikibetsuNoKanri, 被保険者番号, サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号);
        set社福軽減額ボタン制御(shikibetsuNoKanri, 被保険者番号, サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号);
    }

    private void set基本情報ボタン制御(ShikibetsuNoKanri shikibetsuNoKanri, HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス年月, RString 整理番号, JigyoshaNo 事業者番号, RString 様式番号, RString 明細番号) {
        if (設定不可.equals(shikibetsuNoKanri.get基本設定区分())) {
            div.getPanelTwo().getBtnKihoninfo().setDisabled(true);
        } else if (設定可必須.equals(shikibetsuNoKanri.get基本設定区分())) {
            int count1 = SyokanbaraihiShikyuShinseiKetteManager.createInstance().getShokanKihonCount(被保険者番号,
                    サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号);
            if (count1 != 0) {
                div.getPanelTwo().getBtnKihoninfo().setIconNameEnum(IconName.Incomplete);
            } else {
                div.getPanelTwo().getBtnKihoninfo().setIconNameEnum(IconName.Complete);
            }
        } else if (設定可任意.equals(shikibetsuNoKanri.get基本設定区分())) {
            div.getPanelTwo().getBtnKihoninfo().setIconNameEnum(IconName.NONE);
        }
    }

    private void set給付費明細ボタン制御(ShikibetsuNoKanri shikibetsuNoKanri, HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス年月, RString 整理番号, JigyoshaNo 事業者番号, RString 様式番号, RString 明細番号) {
        if (設定不可.equals(shikibetsuNoKanri.get明細設定区分())) {
            div.getPanelTwo().getBtnKyufuMeisai().setDisabled(true);
        } else if (設定可必須.equals(shikibetsuNoKanri.get明細設定区分())) {
            int count2 = SyokanbaraihiShikyuShinseiKetteManager.createInstance().delShokanMeisaiCount(被保険者番号,
                    サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号);
            if (count2 != 0) {
                div.getPanelTwo().getBtnKyufuMeisai().setIconNameEnum(IconName.Incomplete);
            } else {
                div.getPanelTwo().getBtnKyufuMeisai().setIconNameEnum(IconName.Complete);
            }
        } else if (設定可任意.equals(shikibetsuNoKanri.get明細設定区分())) {
            div.getPanelTwo().getBtnKyufuMeisai().setIconNameEnum(IconName.NONE);
        }
    }

    private void setサービス計画費ボタン制御(ShikibetsuNoKanri shikibetsuNoKanri, HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス年月, RString 整理番号, JigyoshaNo 事業者番号, RString 様式番号, RString 明細番号) {
        if (設定不可.equals(shikibetsuNoKanri.get居宅計画費設定区分())) {
            div.getPanelTwo().getBtnServiceKeikakuhi().setDisabled(true);
        } else if (設定可必須.equals(shikibetsuNoKanri.get居宅計画費設定区分())) {
            int count4 = SyokanbaraihiShikyuShinseiKetteManager.createInstance().updShokanServicePlan(被保険者番号,
                    サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号);
            if (count4 != 0) {
                div.getPanelTwo().getBtnServiceKeikakuhi().setIconNameEnum(IconName.Incomplete);
            } else {
                div.getPanelTwo().getBtnServiceKeikakuhi().setIconNameEnum(IconName.Complete);
            }
        } else if (設定可任意.equals(shikibetsuNoKanri.get居宅計画費設定区分())) {
            div.getPanelTwo().getBtnServiceKeikakuhi().setIconNameEnum(IconName.NONE);
        }
    }

    private void set特定入所者費用ボタン制御(ShikibetsuNoKanri shikibetsuNoKanri, HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス年月, RString 整理番号, JigyoshaNo 事業者番号, RString 様式番号, RString 明細番号) {
        if (設定不可.equals(shikibetsuNoKanri.get特定入所者設定区分())) {
            div.getPanelTwo().getBtnTokuteinyushosha().setDisabled(true);
        } else if (設定可必須.equals(shikibetsuNoKanri.get特定入所者設定区分())) {
            int count5 = SyokanbaraihiShikyuShinseiKetteManager.createInstance()
                    .updShokanTokuteiNyushoshaKaigoServiceHiyo(被保険者番号, サービス年月, 整理番号,
                            事業者番号, 様式番号, 明細番号);
            if (count5 != 0) {
                div.getPanelTwo().getBtnTokuteinyushosha().setIconNameEnum(IconName.Incomplete);
            } else {
                div.getPanelTwo().getBtnTokuteinyushosha().setIconNameEnum(IconName.Complete);
            }
        } else if (設定可任意.equals(shikibetsuNoKanri.get特定入所者設定区分())) {
            div.getPanelTwo().getBtnTokuteinyushosha().setIconNameEnum(IconName.NONE);
        }
    }

    private void set給付費明細_住特ボタン制御(ShikibetsuNoKanri shikibetsuNoKanri, HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス年月, RString 整理番号, JigyoshaNo 事業者番号, RString 様式番号, RString 明細番号) {
        if (設定不可.equals(shikibetsuNoKanri.get明細住所地特例設定区分())) {
            div.getPanelTwo().getBtnKyufuhiMeisaiJutoku().setDisabled(true);
        } else if (設定可必須.equals(shikibetsuNoKanri.get明細住所地特例設定区分())) {
            int count6 = SyokanbaraihiShikyuShinseiKetteManager.createInstance().getShokanMeisaiJushochiTokureiCount(
                    被保険者番号, サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号);
            if (count6 != 0) {
                div.getPanelTwo().getBtnKyufuhiMeisaiJutoku().setIconNameEnum(IconName.Incomplete);
            } else {
                div.getPanelTwo().getBtnKyufuhiMeisaiJutoku().setIconNameEnum(IconName.Complete);
            }
        } else if (設定可任意.equals(shikibetsuNoKanri.get明細住所地特例設定区分())) {
            div.getPanelTwo().getBtnKyufuhiMeisaiJutoku().setIconNameEnum(IconName.NONE);
        }
    }

    private void set緊急時_所定疾患ボタン制御(ShikibetsuNoKanri shikibetsuNoKanri, HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス年月, RString 整理番号, JigyoshaNo 事業者番号, RString 様式番号, RString 明細番号) {
        if (設定不可.equals(shikibetsuNoKanri.get所定疾患施設療養設定区分())) {
            div.getPanelTwo().getBtnKinkyujiShoteiShikan().setDisabled(true);
        } else if (設定可必須.equals(shikibetsuNoKanri.get所定疾患施設療養設定区分())) {
            int count7 = SyokanbaraihiShikyuShinseiKetteManager.createInstance().updShokanShoteiShikkanShisetsuRyoyo(
                    被保険者番号, サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号);
            if (count7 != 0) {
                div.getPanelTwo().getBtnKinkyujiShoteiShikan().setIconNameEnum(IconName.Incomplete);
            } else {
                div.getPanelTwo().getBtnKinkyujiShoteiShikan().setIconNameEnum(IconName.Complete);
            }
        } else if (設定可任意.equals(shikibetsuNoKanri.get所定疾患施設療養設定区分())) {
            div.getPanelTwo().getBtnKinkyujiShoteiShikan().setIconNameEnum(IconName.NONE);
        }
    }

    private void set緊急時施設療養費ボタン制御(ShikibetsuNoKanri shikibetsuNoKanri, HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス年月, RString 整理番号, JigyoshaNo 事業者番号, RString 様式番号, RString 明細番号) {
        if (設定不可.equals(shikibetsuNoKanri.get緊急時施設療養設定区分())) {
            div.getPanelTwo().getBtnKinkyujiShisetsu().setDisabled(true);
        } else if (設定可必須.equals(shikibetsuNoKanri.get緊急時施設療養設定区分())) {
            int count8 = SyokanbaraihiShikyuShinseiKetteManager.createInstance().updShokanKinkyuShisetsuRyoyo(
                    被保険者番号, サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号);
            if (count8 != 0) {
                div.getPanelTwo().getBtnKinkyujiShisetsu().setIconNameEnum(IconName.Incomplete);
            } else {
                div.getPanelTwo().getBtnKinkyujiShisetsu().setIconNameEnum(IconName.Complete);
            }
        } else if (設定可任意.equals(shikibetsuNoKanri.get緊急時施設療養設定区分())) {
            div.getPanelTwo().getBtnKinkyujiShisetsu().setIconNameEnum(IconName.NONE);
        }
    }

    private void set食事費用ボタン制御(ShikibetsuNoKanri shikibetsuNoKanri, HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス年月, RString 整理番号, JigyoshaNo 事業者番号, RString 様式番号, RString 明細番号) {
        if (設定不可.equals(shikibetsuNoKanri.get食事費用設定区分())) {
            div.getPanelTwo().getBtnShokujihiyo().setDisabled(true);
        } else if (設定可必須.equals(shikibetsuNoKanri.get食事費用設定区分())) {
            int count9 = SyokanbaraihiShikyuShinseiKetteManager.createInstance().updShokanShokujiHiyo(
                    被保険者番号, サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号);
            if (count9 != 0) {
                div.getPanelTwo().getBtnShokujihiyo().setIconNameEnum(IconName.Incomplete);
            } else {
                div.getPanelTwo().getBtnShokujihiyo().setIconNameEnum(IconName.Complete);
            }
        } else if (設定可任意.equals(shikibetsuNoKanri.get食事費用設定区分())) {
            div.getPanelTwo().getBtnShokujihiyo().setIconNameEnum(IconName.NONE);
        }
    }

    private void set請求額集計ボタン制御(ShikibetsuNoKanri shikibetsuNoKanri, HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス年月, RString 整理番号, JigyoshaNo 事業者番号, RString 様式番号, RString 明細番号) {
        if (設定不可.equals(shikibetsuNoKanri.get集計設定区分())) {
            div.getPanelTwo().getBtnSeikyugaku().setDisabled(true);
        } else if (設定可必須.equals(shikibetsuNoKanri.get集計設定区分())) {
            int count10 = SyokanbaraihiShikyuShinseiKetteManager.createInstance().updShokanShukei(被保険者番号,
                    サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号);
            if (count10 != 0) {
                div.getPanelTwo().getBtnSeikyugaku().setIconNameEnum(IconName.Incomplete);
            } else {
                div.getPanelTwo().getBtnSeikyugaku().setIconNameEnum(IconName.Complete);
            }
        } else if (設定可任意.equals(shikibetsuNoKanri.get集計設定区分())) {
            div.getPanelTwo().getBtnSeikyugaku().setIconNameEnum(IconName.NONE);
        }
    }

    private void set社福軽減額ボタン制御(ShikibetsuNoKanri shikibetsuNoKanri, HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス年月, RString 整理番号, JigyoshaNo 事業者番号, RString 様式番号, RString 明細番号) {
        if (設定不可.equals(shikibetsuNoKanri.get社会福祉法人軽減設定区分())) {
            div.getPanelTwo().getBtnShafuku().setDisabled(true);
        } else if (設定可必須.equals(shikibetsuNoKanri.get社会福祉法人軽減設定区分())) {
            int count11 = SyokanbaraihiShikyuShinseiKetteManager.createInstance().updShokanShakaiFukushiHojinKeigengaku(
                    被保険者番号, サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号);
            if (count11 != 0) {
                div.getPanelTwo().getBtnShafuku().setIconNameEnum(IconName.Incomplete);
            } else {
                div.getPanelTwo().getBtnShafuku().setIconNameEnum(IconName.Complete);
            }
        } else if (設定可任意.equals(shikibetsuNoKanri.get社会福祉法人軽減設定区分())) {
            div.getPanelTwo().getBtnShafuku().setIconNameEnum(IconName.NONE);
        }
    }

    /**
     * 特定診療費一覧グリッド設定のメソッドます。
     *
     * @param shokanTokuteiShinryohiList List<ShokanTokuteiShinryohi>
     */
    public void set特定診療費一覧グリッド(List<ShokanTokuteiShinryohi> shokanTokuteiShinryohiList) {
        List<ddgToteishinryoTokubetushinryo_Row> dataSource = new ArrayList<>();
        if (!shokanTokuteiShinryohiList.isEmpty()) {
            for (ShokanTokuteiShinryohi entity : shokanTokuteiShinryohiList) {
                ddgToteishinryoTokubetushinryo_Row row = new ddgToteishinryoTokubetushinryo_Row();
                if (EntityDataState.Deleted.equals(entity.getState())) {
                    row.setRowState(RowState.Deleted);
                } else if (EntityDataState.Modified.equals(entity.getState())) {
                    row.setRowState(RowState.Modified);
                } else if (EntityDataState.Added.equals(entity.getState())) {
                    row.setRowState(RowState.Added);
                }
                row.setShobyouName(entity.get傷病名());
                row.getShidouKanri().setValue(new Decimal(entity.get指導管理料等単位数()));
                row.getRihabiri().setValue(new Decimal(entity.getリハビリテーション単位数()));
                row.getSeishinka().setValue(new Decimal(entity.get精神科専門療法単位数()));
                row.getEkusuLine().setValue(new Decimal(entity.get単純エックス線単位数()));
                row.getSochi().setValue(new Decimal(entity.get措置単位数()));
                row.getTejyutsu().setValue(new Decimal(entity.get手術単位数()));
                row.getGoukeyiTanyi().setValue(new Decimal(entity.get合計単位数()));
                RStringBuilder builder = new RStringBuilder();
                builder.append(entity.get摘要１());
                builder.append(entity.get摘要２());
                builder.append(entity.get摘要３());
                builder.append(entity.get摘要４());
                builder.append(entity.get摘要５());
                builder.append(entity.get摘要６());
                builder.append(entity.get摘要７());
                builder.append(entity.get摘要８());
                builder.append(entity.get摘要９());
                builder.append(entity.get摘要１０());
                builder.append(entity.get摘要１１());
                builder.append(entity.get摘要１２());
                builder.append(entity.get摘要１３());
                builder.append(entity.get摘要１４());
                builder.append(entity.get摘要１５());
                builder.append(entity.get摘要１６());
                builder.append(entity.get摘要１７());
                builder.append(entity.get摘要１８());
                builder.append(entity.get摘要１９());
                builder.append(entity.get摘要２０());
                row.setMutiTekiyo(builder.toRString());
                row.setNumber(entity.get連番());
                dataSource.add(row);
            }
        }
        Collections.sort(dataSource, new ToteishinryoTokubetushinryoRowComparator());
        div.getDdgToteishinryoTokubetushinryo().setDataSource(dataSource);
    }

    /**
     * 特定診療費登録設定のメソッドます。
     */
    public void set特定診療費登録() {
        ddgToteishinryoTokubetushinryo_Row row = div.getDdgToteishinryoTokubetushinryo().getClickedItem();
        clear特定診療費登録();
        div.getTxtShobyoMei().setValue(row.getShobyouName());
        if (row.getShidouKanri().getValue() != null) {
            div.getTxtShidouKanri().setValue(row.getShidouKanri().getValue());
        }
        if (row.getRihabiri().getValue() != null) {
            div.getTxtRibabiriteishon().setValue(row.getRihabiri().getValue());
        }
        if (row.getSeishinka().getValue() != null) {
            div.getTxtSeishinkaSenmon().setValue(row.getSeishinka().getValue());
        }
        if (row.getEkusuLine().getValue() != null) {
            div.getTxtTanjyunXline().setValue(row.getEkusuLine().getValue());
        }
        if (row.getSochi().getValue() != null) {
            div.getTxtSochi().setValue(row.getSochi().getValue());
        }
        if (row.getTejyutsu().getValue() != null) {
            div.getTxtTejyutsu().setValue(row.getTejyutsu().getValue());
        }
        if (row.getGoukeyiTanyi().getValue() != null) {
            div.getTxtGoukei().setValue(row.getGoukeyiTanyi().getValue());
        }
        div.getTxtMutiTekiyo().setValue(row.getMutiTekiyo());
        div.setRowId(new RString(String.valueOf(row.getId())));
        div.getPanelFour().setVisible(true);
    }

    /**
     * 計算結果のメソッドます。
     */
    public void click計算結果() {
        Decimal data = Decimal.ZERO;
        if (div.getTxtShidouKanri().getValue() != null) {
            data = data.add(div.getTxtShidouKanri().getValue());
        }
        if (div.getTxtRibabiriteishon().getValue() != null) {
            data = data.add(div.getTxtRibabiriteishon().getValue());
        }
        if (div.getTxtSeishinkaSenmon().getValue() != null) {
            data = data.add(div.getTxtSeishinkaSenmon().getValue());
        }
        if (div.getTxtTanjyunXline().getValue() != null) {
            data = data.add(div.getTxtTanjyunXline().getValue());
        }
        if (div.getTxtSochi().getValue() != null) {
            data = data.add(div.getTxtSochi().getValue());
        }
        if (div.getTxtTejyutsu().getValue() != null) {
            data = data.add(div.getTxtTejyutsu().getValue());
        }
        div.getTxtGoukei().setValue(data);
    }

    /**
     * 特定診療費登録のクリアするのメソッドます。
     */
    public void clear特定診療費登録() {
        div.getTxtShobyoMei().clearValue();
        div.getTxtShidouKanri().clearValue();
        div.getTxtRibabiriteishon().clearValue();
        div.getTxtSeishinkaSenmon().clearValue();
        div.getTxtTanjyunXline().clearValue();
        div.getTxtSochi().clearValue();
        div.getTxtTejyutsu().clearValue();
        div.getTxtGoukei().clearValue();
        div.getTxtMutiTekiyo().clearValue();
    }

    /**
     * 選択行のデータのメソッドます。
     *
     * @return row ddgToteishinryoTokubetushinryo_Row
     */
    public ddgToteishinryoTokubetushinryo_Row getSelectedRow() {
        return div.getDdgToteishinryoTokubetushinryo().getDataSource().get(Integer.parseInt(
                div.getRowId().toString()));
    }

    /**
     * 「確定する」ボタンのメソッドます。
     *
     * @param 初期の特定診療費登録List 初期の特定診療費登録List
     * @param ddgRow ddgToteishinryoTokubetushinryo_Row
     * @param state 状態
     * @param 明細検索キー 明細検索キー
     */
    public void modifyRow(List<ShokanTokuteiShinryohi> 初期の特定診療費登録List, ddgToteishinryoTokubetushinryo_Row ddgRow,
            RString state, ShoukanharaihishinseimeisaikensakuParameter 明細検索キー) {
        List<ddgToteishinryoTokubetushinryo_Row> list = div.getDdgToteishinryoTokubetushinryo().getDataSource();
        if (修正.equals(state)) {
            if (RowState.Added.equals(ddgRow.getRowState())) {
                ddgRow.setRowState(RowState.Added);
                setDdgToteishinryoTokubetushinryo_Row(ddgRow, state, 明細検索キー.getサービス年月());
            } else {
                modifiedDdgToteishinryoTokubetushinryo(初期の特定診療費登録List, ddgRow, state, 明細検索キー);
            }
        } else if (削除.equals(state)) {
            if (RowState.Added.equals(ddgRow.getRowState())) {
                div.getDdgToteishinryoTokubetushinryo().getDataSource().remove(Integer.parseInt(
                        div.getRowId().toString()));
                clear特定診療費登録();
                div.getPanelFour().setVisible(false);
            } else {
                ddgRow.setRowState(RowState.Deleted);
                setDdgToteishinryoTokubetushinryo_Row(ddgRow, state, 明細検索キー.getサービス年月());
            }
        } else if (登録.equals(state)) {
            ddgRow.setRowState(RowState.Added);
            setDdgToteishinryoTokubetushinryo_Row(ddgRow, state, 明細検索キー.getサービス年月());
        } else if (登録_削除.equals(state)) {
            list.remove(ddgRow.getId());
            resetRenban(ddgRow, list);
        }
    }

    private void resetRenban(ddgToteishinryoTokubetushinryo_Row row, List<ddgToteishinryoTokubetushinryo_Row> list) {
        int id = row.getId();
        if (id != 0) {
            RString deletedRenban = row.getNumber();
            RString mid;
            for (ddgToteishinryoTokubetushinryo_Row resetRow : list) {
                if (id - resetRow.getId() == 1) {
                    mid = resetRow.getNumber();
                    resetRow.setNumber(deletedRenban);
                    id = id - 1;
                    deletedRenban = mid;
                }
                if (id == 0) {
                    break;
                }
            }
        }
        clear特定診療費登録();
        div.getPanelFour().setVisible(false);
    }

    private void modifiedDdgToteishinryoTokubetushinryo(List<ShokanTokuteiShinryohi> 初期の特定診療費登録List,
            ddgToteishinryoTokubetushinryo_Row ddgRow, RString 状態,
            ShoukanharaihishinseimeisaikensakuParameter 明細検索キー) {
        ShokanTokuteiShinryohi dbData = get特定診療費の初期データ(明細検索キー, 初期の特定診療費登録List);
        boolean flag = 特定診療費hasChanged(dbData);
        if (flag) {
            ddgRow.setRowState(RowState.Modified);
        } else {
            ddgRow.setRowState(RowState.Unchanged);
        }
        setDdgToteishinryoTokubetushinryo_Row(ddgRow, 状態, 明細検索キー.getサービス年月());
    }

    private boolean checkOfModified(ddgToteishinryoTokubetushinryo_Row ddgRow) {
        RString ddgRow摘要 = ddgRow.getMutiTekiyo() == null || ddgRow.getMutiTekiyo().isEmpty()
                ? RString.EMPTY : ddgRow.getMutiTekiyo();
        RString div摘要 = div.getTxtMutiTekiyo().getValue() == null || div.getTxtMutiTekiyo().getValue().isEmpty()
                ? RString.EMPTY : div.getTxtMutiTekiyo().getValue();
        if (!ddgRow.getShobyouName().equals(div.getTxtShobyoMei().getValue())) {
            return true;
        }
        if (ddgRow.getShidouKanri().getValue().equals(div.getTxtShidouKanri().getValue())) {
            return true;
        }
        if (ddgRow.getRihabiri().getValue().equals(div.getTxtRibabiriteishon().getValue())) {
            return true;
        }
        if (ddgRow.getSeishinka().getValue().equals(div.getTxtSeishinkaSenmon().getValue())) {
            return true;
        }
        if (ddgRow.getEkusuLine().getValue().equals(div.getTxtTanjyunXline().getValue())) {
            return true;
        }
        if (ddgRow.getSochi().getValue().equals(div.getTxtSochi().getValue())) {
            return true;
        }
        if (ddgRow.getTejyutsu().getValue().equals(div.getTxtTejyutsu().getValue())) {
            return true;
        }
        if (ddgRow.getGoukeyiTanyi().getValue().equals(div.getTxtGoukei().getValue())) {
            return true;
        }
        return !ddgRow摘要.equals(div摘要);
    }

    private void setDdgToteishinryoTokubetushinryo_Row(ddgToteishinryoTokubetushinryo_Row ddgRow, RString 状態,
            FlexibleYearMonth サービス年月) {
        ddgRow.setShobyouName(div.getTxtShobyoMei().getValue());
        ddgRow.getShidouKanri().setValue(div.getTxtShidouKanri().getValue());
        ddgRow.getRihabiri().setValue(div.getTxtRibabiriteishon().getValue());
        ddgRow.getSeishinka().setValue(div.getTxtSeishinkaSenmon().getValue());
        ddgRow.getEkusuLine().setValue(div.getTxtTanjyunXline().getValue());
        ddgRow.getSochi().setValue(div.getTxtSochi().getValue());
        ddgRow.getTejyutsu().setValue(div.getTxtTejyutsu().getValue());
        ddgRow.getGoukeyiTanyi().setValue(div.getTxtGoukei().getValue());
        ddgRow.setMutiTekiyo(div.getTxtMutiTekiyo().getValue());
        if (登録.equals(状態)) {
            ddgRow.setNumber(new RString(getMax連番plus1(サービス年月)));
            List<ddgToteishinryoTokubetushinryo_Row> list = div.getDdgToteishinryoTokubetushinryo().getDataSource();
            list.add(ddgRow);
            Collections.sort(list, new ToteishinryoTokubetushinryoRowComparator());
        }
        clear特定診療費登録();
        div.getPanelFour().setVisible(false);
    }

    private int getMax連番plus1(FlexibleYearMonth サービス年月) {
        int max連番 = -1;
        if (サービス年月.isBeforeOrEquals(平成１５年３月)) {
            List<ddgToteishinryoTokubetushinryo_Row> rowList = div.getDdgToteishinryoTokubetushinryo().getDataSource();
            if (!rowList.isEmpty()) {
                for (ddgToteishinryoTokubetushinryo_Row row : rowList) {
                    max連番 = set平成15年月Max連番(max連番, row);
                }
            }
        } else {
            List<dgdTokuteiShinryohi_Row> rowList = div.getDgdTokuteiShinryohi().getDataSource();
            if (!rowList.isEmpty()) {
                for (dgdTokuteiShinryohi_Row row : rowList) {
                    max連番 = set平成15年月後Max連番(max連番, row);
                }
            }
        }
        return max連番 + 1;
    }

    /**
     * 特定診療費_特別診療費一覧グリッドのメソッドます。
     *
     * @param list List<ShokanTokuteiShinryoTokubetsuRyoyo>
     */
    public void set特定診療費_特別診療費一覧グリッド(List<ShokanTokuteiShinryoTokubetsuRyoyo> list) {
        List<dgdTokuteiShinryohi_Row> dataSource = new ArrayList<>();
        if (!list.isEmpty()) {
            for (ShokanTokuteiShinryoTokubetsuRyoyo entity : list) {
                dgdTokuteiShinryohi_Row row = new dgdTokuteiShinryohi_Row();
                if (EntityDataState.Deleted.equals(entity.getState())) {
                    row.setRowState(RowState.Deleted);
                } else if (EntityDataState.Modified.equals(entity.getState())) {
                    row.setRowState(RowState.Modified);
                } else if (EntityDataState.Added.equals(entity.getState())) {
                    row.setRowState(RowState.Added);
                }
                row.setDefaultDataName1(entity.get傷病名());
                row.setDefaultDataName2(entity.get識別番号());
                row.getDefaultDataName3().setValue(new Decimal(entity.get単位数()));
                row.getDefaultDataName4().setValue(new Decimal(entity.get回数()));
                row.getDefaultDataName5().setValue(new Decimal(entity.get合計単位数()));
                row.setDefaultDataName6(entity.get摘要());
                row.setDefaultDataName7(entity.get連番());
                dataSource.add(row);
            }
        }
        Collections.sort(dataSource, new TokuteiShinryohiRowComparator());
        div.getPanelThree().getDgdTokuteiShinryohi().setDataSource(dataSource);
    }

    /**
     * 特定診療費_特別診療費登録のメソッドます。
     *
     * @param サービス年月 FlexibleYearMonth
     * @param 様式番号 RString
     */
    public void set特定診療費_特別診療費登録(
            FlexibleYearMonth サービス年月,
            RString 様式番号) {
        dgdTokuteiShinryohi_Row row = div.getDgdTokuteiShinryohi().getClickedItem();
        clear特定診療費_特別診療費登録();
        div.getTxtShobyoMeiDown().setValue(row.getDefaultDataName1());
        div.getTxtShikibetsuCode().setValue(row.getDefaultDataName2());
        set識別項目(row.getDefaultDataName2(), サービス年月, 様式番号);
        if (row.getDefaultDataName3().getValue() != null) {
            div.getTxtTanyi().setValue(new RString(row.getDefaultDataName3().getValue().toString()));
        }
        div.getTxtKaiyisuNisu().setValue(row.getDefaultDataName4().getValue());
        div.getTxtGoukeiTanyi().setValue(row.getDefaultDataName5().getValue());
        div.getTxtTekiyoDown().setValue(row.getDefaultDataName6());
        div.setRowId(new RString(String.valueOf(row.getId())));
        div.getPanelFive().setVisible(true);
    }

    /**
     * set識別項目のメソッドます。
     *
     * @param hiddenSelectCode RString
     * @param サービス年月 FlexibleYearMonth
     * @param 様式番号 RString
     */
    public void set識別項目(RString hiddenSelectCode, FlexibleYearMonth サービス年月, RString 様式番号) {
        TokuteiShinryoServiceCode serviceCode = ShokanbaraiJyokyoShokai.createInstance()
                .getTokuteiShinryoServiceCodeInfo(
                        new ShikibetsuCode(hiddenSelectCode),
                        サービス年月, 様式番号);
        if (serviceCode != null && serviceCode.toEntity().getServiceMeisho() != null) {
            FlexibleDate date = new FlexibleDate(RDate.getNowDate().toDateString());
            div.getTxtName().setValue(serviceCode.toEntity().getServiceMeisho());
            if (serviceCode.toEntity().getTaniSu() != null) {
                div.getTxtTanyi().setValue(new RString(serviceCode.toEntity().getTaniSu().toString()));
            }
            if (serviceCode.toEntity().getSanteiTani() != null) {
                UzT0007CodeEntity code1 = CodeMaster.getCode(SubGyomuCode.DBC介護給付, DBCCodeShubetsu.算定単位.getコード(),
                        new Code(serviceCode.toEntity().getSanteiTani()), date);
                RStringBuilder builder1 = new RStringBuilder();
                builder1.append(code1 == null ? RString.EMPTY : code1.getコード名称());
                builder1.append(serviceCode.toEntity().getTaniSu());
                builder1.append(単位);
                div.getLblComment1().setText(builder1.toRString());
            } else {
                div.getLblComment1().setText(RString.EMPTY);
            }
            if (serviceCode.toEntity().getSanteiSeiyakuKikan() != null) {
                UzT0007CodeEntity code2 = CodeMaster.getCode(SubGyomuCode.DBC介護給付,
                        DBCCodeShubetsu.算定期間回数制限_期間_時期.getコード(),
                        new Code(serviceCode.toEntity().getSanteiSeiyakuKikan()), date);
                RStringBuilder builder2 = new RStringBuilder();
                builder2.append(code2 == null ? RString.EMPTY : code2.getコード名称());
                builder2.append(serviceCode.toEntity().getSanteiSeiyakuKaisu());
                builder2.append(回まで);
                div.getLblComment2().setText(builder2.toRString());
            } else {
                div.getLblComment2().setText(RString.EMPTY);
            }
        } else {
            div.getLblComment1().setText(RString.EMPTY);
            div.getLblComment2().setText(RString.EMPTY);
        }
    }

    /**
     * 計算結果2のメソッドます。
     */
    public void click計算結果2() {
        Decimal data = Decimal.ZERO;
        if (!div.getTxtTanyi().getValue().isEmpty() && div.getTxtKaiyisuNisu().getValue() != null) {
            data = new Decimal(div.getTxtTanyi().getValue().toString())
                    .multiply(div.getTxtKaiyisuNisu().getValue());
        }
        div.getPanelFive().getTxtGoukeiTanyi().setValue(data);
    }

    /**
     * 特定診療費_特別診療費登録のメソッドます。
     */
    public void clear特定診療費_特別診療費登録() {
        div.getTxtShobyoMeiDown().clearValue();
        div.getTxtShikibetsuCode().clearValue();
        div.getTxtName().clearValue();
        div.getLblComment1().setText(RString.EMPTY);
        div.getLblComment2().setText(RString.EMPTY);
        div.getTxtTanyi().clearValue();
        div.getTxtKaiyisuNisu().clearValue();
        div.getTxtGoukeiTanyi().clearValue();
        div.getTxtTekiyoDown().clearValue();
    }

    /**
     * 選択行のデータ２のメソッドます。
     *
     * @return row dgdTokuteiShinryohi_Row
     */
    public dgdTokuteiShinryohi_Row getSelectedRow2() {
        return div.getDgdTokuteiShinryohi().getDataSource().get(Integer.parseInt(div.getRowId().toString()));
    }

    /**
     * 「確定する」ボタンのメソッドます。
     *
     * @param 初期の特別診療費List 初期の特別診療費List
     * @param row dgdTokuteiShinryohi_Row
     * @param state 状態
     * @param 明細検索キー 明細検索キー
     */
    public void modifyRow2(List<ShokanTokuteiShinryoTokubetsuRyoyo> 初期の特別診療費List,
            dgdTokuteiShinryohi_Row row, RString state, ShoukanharaihishinseimeisaikensakuParameter 明細検索キー) {
        List<dgdTokuteiShinryohi_Row> list = div.getDgdTokuteiShinryohi().getDataSource();
        if (修正.equals(state)) {
            if (RowState.Added.equals(row.getRowState())) {
                row.setRowState(RowState.Added);
                setDgdTokuteiShinryohi_Row(row, state, 明細検索キー.getサービス年月());
            } else {
                modifiedDgdTokuteiShinryohi(初期の特別診療費List, row, state, 明細検索キー);
            }
        } else if (削除.equals(state)) {
            if (RowState.Added.equals(row.getRowState())) {
                div.getDgdTokuteiShinryohi().getDataSource().remove(Integer.parseInt(div.getRowId().toString()));
                clear特定診療費_特別診療費登録();
                div.getPanelFive().setVisible(false);
            } else {
                row.setRowState(RowState.Deleted);
                setDgdTokuteiShinryohi_Row(row, state, 明細検索キー.getサービス年月());
            }
        } else if (登録.equals(state)) {
            row.setRowState(RowState.Added);
            setDgdTokuteiShinryohi_Row(row, state, 明細検索キー.getサービス年月());
        } else if (登録_削除.equals(state)) {
            list.remove(row.getId());
            resetRenban2(row, list);
        }
    }

    private void resetRenban2(dgdTokuteiShinryohi_Row row, List<dgdTokuteiShinryohi_Row> list) {
        int id = row.getId();
        if (id != 0) {
            RString deletedRenban = row.getDefaultDataName7();
            RString mid;
            for (dgdTokuteiShinryohi_Row resetRow : list) {
                if (id - resetRow.getId() == 1) {
                    mid = resetRow.getDefaultDataName7();
                    resetRow.setDefaultDataName7(deletedRenban);
                    id = id - 1;
                    deletedRenban = mid;
                }
                if (id == 0) {
                    break;
                }
            }
        }
        clear特定診療費_特別診療費登録();
        div.getPanelFive().setVisible(false);
    }

    private void modifiedDgdTokuteiShinryohi(List<ShokanTokuteiShinryoTokubetsuRyoyo> 初期の特別診療費List,
            dgdTokuteiShinryohi_Row row, RString 状態, ShoukanharaihishinseimeisaikensakuParameter 明細検索キー) {
        ShokanTokuteiShinryoTokubetsuRyoyo dbData = get特別診療費の初期データ(明細検索キー, 初期の特別診療費List);
        boolean flag = 特別診療費hasChanged(dbData);
        if (flag) {
            row.setRowState(RowState.Modified);
        } else {
            row.setRowState(RowState.Unchanged);
        }
        setDgdTokuteiShinryohi_Row(row, 状態, 明細検索キー.getサービス年月());
    }

    private boolean checkOfModified2(dgdTokuteiShinryohi_Row row) {
        RString div傷病名 = div.getTxtShobyoMeiDown().getValue() == null || div.getTxtShobyoMeiDown().getValue()
                .isEmpty() ? RString.EMPTY : div.getTxtShobyoMeiDown().getValue();
        RString row傷病名 = row.getDefaultDataName1() == null || row.getDefaultDataName1().isEmpty()
                ? RString.EMPTY : row.getDefaultDataName1();
        RString div識別番号 = div.getTxtShikibetsuCode().getValue() == null || div.getTxtShikibetsuCode().getValue()
                .isEmpty() ? RString.EMPTY : div.getTxtShikibetsuCode().getValue();
        RString row識別番号 = row.getDefaultDataName2() == null || row.getDefaultDataName2().isEmpty()
                ? RString.EMPTY : row.getDefaultDataName2();
        Decimal div単位数 = div.getTxtTanyi().getValue() == null || div.getTxtTanyi().getValue().isEmpty()
                ? Decimal.ZERO : new Decimal(div.getTxtTanyi().getValue().toString());
        RString div摘要 = div.getTxtTekiyoDown().getValue() == null || div.getTxtTekiyoDown().getValue().isEmpty()
                ? RString.EMPTY : div.getTxtTekiyoDown().getValue();
        RString row摘要 = row.getDefaultDataName6() == null || row.getDefaultDataName6().isEmpty()
                ? RString.EMPTY : row.getDefaultDataName6();
        return check2(div傷病名, row傷病名, div識別番号, row識別番号, div単位数, div摘要, row摘要, row);
    }

    private boolean check2(RString div傷病名, RString row傷病名, RString div識別番号, RString row識別番号,
            Decimal div単位数, RString div摘要, RString row摘要, dgdTokuteiShinryohi_Row row) {
        if (!row傷病名.equals(div傷病名)) {
            return true;
        }
        if (!row識別番号.equals(div識別番号)) {
            return true;
        }
        if (row.getDefaultDataName3().getValue().equals(div単位数)) {
            return true;
        }
        if (row.getDefaultDataName4().getValue().equals(div.getTxtKaiyisuNisu().getValue())) {
            return true;
        }
        if (row.getDefaultDataName5().getValue().equals(div.getTxtGoukeiTanyi().getValue())) {
            return true;
        }
        return !row摘要.equals(div摘要);
    }

    private void setDgdTokuteiShinryohi_Row(dgdTokuteiShinryohi_Row row, RString 状態, FlexibleYearMonth サービス年月) {
        row.setDefaultDataName1(div.getTxtShobyoMeiDown().getValue());
        row.setDefaultDataName2(div.getTxtShikibetsuCode().getValue());
        if (!div.getTxtTanyi().getValue().isEmpty()) {
            row.getDefaultDataName3().setValue(new Decimal(div.getTxtTanyi().getValue().toString()));
        } else {
            row.getDefaultDataName3().setValue(null);
        }
        row.getDefaultDataName4().setValue(div.getTxtKaiyisuNisu().getValue());
        row.getDefaultDataName5().setValue(div.getTxtGoukeiTanyi().getValue());
        row.setDefaultDataName6(div.getTxtTekiyoDown().getValue());
        if (登録.equals(状態)) {
            row.setDefaultDataName7(new RString(getMax連番plus1(サービス年月)));
            List<dgdTokuteiShinryohi_Row> list = div.getDgdTokuteiShinryohi().getDataSource();
            list.add(row);
            Collections.sort(list, new TokuteiShinryohiRowComparator());
        }
        clear特定診療費_特別診療費登録();
        div.getPanelFive().setVisible(false);
    }

    /**
     * 内容変更状態のメソッドます。
     *
     * @param サービス年月 サービス年月
     * @return boolean
     */
    public boolean get内容変更状態(FlexibleYearMonth サービス年月) {
        if (サービス年月.isBeforeOrEquals(平成１５年３月)) {
            return 特定診療費変更状態();
        }
        if (平成１５年４月.isBeforeOrEquals(サービス年月)) {
            return 特定診療費_特別診療費変更状態();
        }
        return false;
    }

    private boolean 特定診療費変更状態() {
        for (ddgToteishinryoTokubetushinryo_Row ddgList : div.getDdgToteishinryoTokubetushinryo().getDataSource()) {
            if (RowState.Modified.equals(ddgList.getRowState())
                    || RowState.Added.equals(ddgList.getRowState())
                    || RowState.Deleted.equals(ddgList.getRowState())) {
                return true;
            }
        }
        return false;
    }

    private boolean 特定診療費_特別診療費変更状態() {
        for (dgdTokuteiShinryohi_Row dgdRow : div.getDgdTokuteiShinryohi().getDataSource()) {
            if (RowState.Modified.equals(dgdRow.getRowState())
                    || RowState.Added.equals(dgdRow.getRowState())
                    || RowState.Deleted.equals(dgdRow.getRowState())) {
                return true;
            }
        }
        return false;
    }

    /**
     * ViewStateにDB情報を保存します。
     *
     * @param サービス年月 サービス年月
     * @param viewStateDB viewStateDB
     * @param meisaiPar 明細検索キー
     */
    public void viewStateDBの編集(FlexibleYearMonth サービス年月,
            DbJohoViewState viewStateDB, ShoukanharaihishinseimeisaikensakuParameter meisaiPar) {

        if (サービス年月.isBeforeOrEquals(平成１５年３月)) {
            特定診療費ViewStateDBの編集(viewStateDB, meisaiPar);
        } else if (平成１５年４月.isBeforeOrEquals(サービス年月)) {
            特別診療費ViewStateDBの編集(viewStateDB, meisaiPar);
        }
        償還払請求基本ViewStateDBの編集(サービス年月, viewStateDB, meisaiPar);
    }

    private void 償還払請求基本ViewStateDBの編集(FlexibleYearMonth サービス年月,
            DbJohoViewState viewStateDB, ShoukanharaihishinseimeisaikensakuParameter meisaiPar) {
        ArrayList<ShokanKihon> 償還払請求基本List = viewStateDB.get償還払請求基本データList();
        if (償還払請求基本List == null) {
            償還払請求基本List = new ArrayList<>();
        }
        Decimal 合計 = Decimal.ZERO;
        if (サービス年月.isBeforeOrEquals(平成１５年３月)) {
            List<ddgToteishinryoTokubetushinryo_Row> rowList = div.getDdgToteishinryoTokubetushinryo().getDataSource();
            for (ddgToteishinryoTokubetushinryo_Row row : rowList) {
                if (row.getRowState() != RowState.Deleted && row.getGoukeyiTanyi().getValue() != null) {
                    合計 = 合計.add(row.getGoukeyiTanyi().getValue());
                }
            }
        } else if (平成１５年４月.isBeforeOrEquals(サービス年月)) {
            List<dgdTokuteiShinryohi_Row> rowList = div.getDgdTokuteiShinryohi().getDataSource();
            for (dgdTokuteiShinryohi_Row row : rowList) {
                if (row.getRowState() != RowState.Deleted && row.getDefaultDataName5().getValue() != null) {
                    合計 = 合計.add(row.getDefaultDataName5().getValue());
                }
            }
        }

        for (ShokanKihon joho : 償還払請求基本List) {
            if (meisaiPar.getサービス年月().equals(joho.getサービス提供年月())
                    && meisaiPar.get事業者番号().equals(joho.get事業者番号())
                    && meisaiPar.get被保険者番号().equals(joho.get被保険者番号())
                    && meisaiPar.get整理番号().equals(joho.get整理番号())
                    && meisaiPar.get明細番号().equals(joho.get明細番号())
                    && meisaiPar.get様式番号().equals(joho.get様式番号())) {
                償還払請求基本List.remove(joho);
                joho = joho.createBuilderForEdit().set特定診療費請求額(合計).build();
                償還払請求基本List.add(joho);
                break;
            }
        }
        viewStateDB.set償還払請求基本データList(償還払請求基本List);
    }

    private void 特定診療費ViewStateDBの編集(DbJohoViewState viewStateDB, ShoukanharaihishinseimeisaikensakuParameter meisaiPar) {
        ArrayList<ShokanTokuteiShinryohi> 特定診療費ViewDBList = viewStateDB.get償還払請求特定診療費データList();
        if (特定診療費ViewDBList == null) {
            特定診療費ViewDBList = new ArrayList<>();
        }

        List<ddgToteishinryoTokubetushinryo_Row> rowList = div.getDdgToteishinryoTokubetushinryo().getDataSource();
        boolean isViewDB存在;
        for (ddgToteishinryoTokubetushinryo_Row row : rowList) {
            isViewDB存在 = false;
            if (row.getRowState() == null || RowState.Unchanged.equals(row.getRowState())) {
                return;
            }
            for (ShokanTokuteiShinryohi 特定診療費ViewDB : 特定診療費ViewDBList) {
                if (meisaiPar.getサービス年月().equals(特定診療費ViewDB.getサービス提供年月())
                        && meisaiPar.get事業者番号().equals(特定診療費ViewDB.get事業者番号())
                        && meisaiPar.get被保険者番号().equals(特定診療費ViewDB.get被保険者番号())
                        && meisaiPar.get整理番号().equals(特定診療費ViewDB.get整理番号())
                        && meisaiPar.get明細番号().equals(特定診療費ViewDB.get明細番号())
                        && meisaiPar.get様式番号().equals(特定診療費ViewDB.get様式番号())
                        && row.getNumber().equals(特定診療費ViewDB.get連番())) {

                    isViewDB存在 = true;
                    特定診療費ViewDBList.remove(特定診療費ViewDB);

                    特定診療費ViewDBList.add(特定診療費builder編集(特定診療費ViewDB, row));
                    break;
                }
            }
            if (!isViewDB存在) {
                ShokanTokuteiShinryohi joho = new ShokanTokuteiShinryohi(meisaiPar.get被保険者番号(), meisaiPar.getサービス年月(),
                        meisaiPar.get整理番号(), meisaiPar.get事業者番号(), meisaiPar.get様式番号(), meisaiPar.get明細番号(), row.getNumber());
                特定診療費ViewDBList.add(特定診療費builder編集(joho, row));
            }
        }
        viewStateDB.set償還払請求特定診療費データList(特定診療費ViewDBList);
    }

    private void 特別診療費ViewStateDBの編集(DbJohoViewState viewStateDB, ShoukanharaihishinseimeisaikensakuParameter meisaiPar) {
        ArrayList<ShokanTokuteiShinryoTokubetsuRyoyo> 特別診療費ViewDBList = viewStateDB.get特別療養費データList();
        if (特別診療費ViewDBList == null) {
            特別診療費ViewDBList = new ArrayList<>();
        }

        List<dgdTokuteiShinryohi_Row> rowList = div.getDgdTokuteiShinryohi().getDataSource();

        boolean isViewDB存在;
        for (dgdTokuteiShinryohi_Row row : rowList) {
            isViewDB存在 = false;
            if (row.getRowState() == null || RowState.Unchanged.equals(row.getRowState())) {
                return;
            }
            for (ShokanTokuteiShinryoTokubetsuRyoyo 特別診療費ViewDB : 特別診療費ViewDBList) {
                if (meisaiPar.getサービス年月().equals(特別診療費ViewDB.getサービス提供年月())
                        && meisaiPar.get事業者番号().equals(特別診療費ViewDB.get事業者番号())
                        && meisaiPar.get被保険者番号().equals(特別診療費ViewDB.get被保険者番号())
                        && meisaiPar.get整理番号().equals(特別診療費ViewDB.get整理番号())
                        && meisaiPar.get明細番号().equals(特別診療費ViewDB.get明細番号())
                        && meisaiPar.get様式番号().equals(特別診療費ViewDB.get様式番号())
                        && row.getDefaultDataName7().equals(特別診療費ViewDB.get連番())) {

                    isViewDB存在 = true;
                    特別診療費ViewDBList.remove(特別診療費ViewDB);

                    特別診療費ViewDBList.add(特別診療費builder編集(特別診療費ViewDB, row));
                    break;
                }
            }
            if (!isViewDB存在) {
                ShokanTokuteiShinryoTokubetsuRyoyo joho = new ShokanTokuteiShinryoTokubetsuRyoyo(meisaiPar.get被保険者番号(), meisaiPar.getサービス年月(),
                        meisaiPar.get整理番号(), meisaiPar.get事業者番号(), meisaiPar.get様式番号(), meisaiPar.get明細番号(), row.getDefaultDataName7());
                特別診療費ViewDBList.add(特別診療費builder編集(joho, row));
            }
        }
        viewStateDB.set特別療養費データList(特別診療費ViewDBList);
    }

    private ShokanTokuteiShinryohi 特定診療費builder編集(ShokanTokuteiShinryohi 特定診療費ViewDB, ddgToteishinryoTokubetushinryo_Row row) {
        ShokanTokuteiShinryohiBuilder builder = 特定診療費ViewDB.createBuilderForEdit();
        if (RowState.Deleted.equals(row.getRowState())) {
            ShokanTokuteiShinryohi joho = builder.build().deleted();
            builder = joho.createBuilderForEdit();
        }
        builder.set傷病名(row.getShobyouName());
        if (row.getShidouKanri().getValue() != null) {
            builder.set指導管理料等単位数(row.getShidouKanri().getValue().intValue());
        } else {
            builder.set指導管理料等単位数(0);
        }
        if (row.getEkusuLine().getValue() != null) {
            builder.set単純エックス線単位数(row.getEkusuLine().getValue().intValue());
        } else {
            builder.set単純エックス線単位数(0);
        }
        if (row.getRihabiri().getValue() != null) {
            builder.setリハビリテーション単位数(row.getRihabiri().getValue().intValue());
        } else {
            builder.setリハビリテーション単位数(0);
        }
        if (row.getSeishinka().getValue() != null) {
            builder.set精神科専門療法単位数(row.getSeishinka().getValue().intValue());
        } else {
            builder.set精神科専門療法単位数(0);
        }
        if (row.getSochi().getValue() != null) {
            builder.set措置単位数(row.getSochi().getValue().intValue());
        } else {
            builder.set措置単位数(0);
        }
        if (row.getTejyutsu().getValue() != null) {
            builder.set手術単位数(row.getTejyutsu().getValue().intValue());
        } else {
            builder.set手術単位数(0);
        }
        if (row.getGoukeyiTanyi().getValue() != null) {
            builder.set合計単位数(row.getGoukeyiTanyi().getValue().intValue());
        } else {
            builder.set合計単位数(0);
        }
        builder.set摘要１(getLenStr(row.getMutiTekiyo(), 0, NUMBER_３２));
        builder.set摘要２(getLenStr(row.getMutiTekiyo(), NUMBER_３２, NUMBER_３２));
        builder.set摘要３(getLenStr(row.getMutiTekiyo(), NUMBER_６４, NUMBER_３２));
        builder.set摘要４(getLenStr(row.getMutiTekiyo(), NUMBER_９６, NUMBER_３２));
        builder.set摘要５(getLenStr(row.getMutiTekiyo(), NUMBER_１２８, NUMBER_３２));
        builder.set摘要６(getLenStr(row.getMutiTekiyo(), NUMBER_１６０, NUMBER_３２));
        builder.set摘要７(getLenStr(row.getMutiTekiyo(), NUMBER_１９２, NUMBER_３２));
        builder.set摘要８(getLenStr(row.getMutiTekiyo(), NUMBER_２２４, NUMBER_３２));
        builder.set摘要９(getLenStr(row.getMutiTekiyo(), NUMBER_２５６, NUMBER_３２));
        builder.set摘要１０(getLenStr(row.getMutiTekiyo(), NUMBER_２８８, NUMBER_３２));
        builder.set摘要１１(getLenStr(row.getMutiTekiyo(), NUMBER_３２０, NUMBER_３２));
        builder.set摘要１２(getLenStr(row.getMutiTekiyo(), NUMBER_３５２, NUMBER_３２));
        builder.set摘要１３(getLenStr(row.getMutiTekiyo(), NUMBER_３８４, NUMBER_３２));
        builder.set摘要１４(getLenStr(row.getMutiTekiyo(), NUMBER_４１６, NUMBER_３２));
        builder.set摘要１５(getLenStr(row.getMutiTekiyo(), NUMBER_４４８, NUMBER_３２));
        builder.set摘要１６(getLenStr(row.getMutiTekiyo(), NUMBER_４８０, NUMBER_３２));
        builder.set摘要１７(getLenStr(row.getMutiTekiyo(), NUMBER_５１２, NUMBER_３２));
        builder.set摘要１８(getLenStr(row.getMutiTekiyo(), NUMBER_５４４, NUMBER_３２));
        builder.set摘要１９(getLenStr(row.getMutiTekiyo(), NUMBER_５７６, NUMBER_３２));
        builder.set摘要２０(getLenStr(row.getMutiTekiyo(), NUMBER_６０８, NUMBER_３２));
        return builder.build();
    }

    private ShokanTokuteiShinryoTokubetsuRyoyo 特別診療費builder編集(ShokanTokuteiShinryoTokubetsuRyoyo 特別診療費ViewDB, dgdTokuteiShinryohi_Row row) {
        ShokanTokuteiShinryoTokubetsuRyoyoBuilder builder = 特別診療費ViewDB.createBuilderForEdit();
        if (RowState.Deleted.equals(row.getRowState())) {
            ShokanTokuteiShinryoTokubetsuRyoyo joho = builder.build().deleted();
            builder = joho.createBuilderForEdit();
        }
        builder.set傷病名(row.getDefaultDataName1());
        builder.set識別番号(row.getDefaultDataName2());
        if (row.getDefaultDataName3().getValue() != null) {
            builder.set単位数(row.getDefaultDataName3().getValue().intValue());
            builder.setサービス単位数(row.getDefaultDataName3().getValue().intValue());
        } else {
            builder.set単位数(0);
            builder.setサービス単位数(0);
        }
        builder.set回数(row.getDefaultDataName4().getValue().intValue());
        if (row.getDefaultDataName5().getValue() != null) {
            builder.set合計単位数(row.getDefaultDataName5().getValue().intValue());
        } else {
            builder.set合計単位数(0);
        }
        builder.set摘要(row.getDefaultDataName6());
        return builder.build();
    }

    private RString getLenStr(RString rstr, int startIndex, int len) {
        if (!RString.isNullOrEmpty(rstr)) {
            if (rstr.length() >= startIndex + len) {
                return rstr.substring(startIndex, startIndex + len);
            } else if (rstr.length() > startIndex) {
                return rstr.substring(startIndex);
            }
        }
        return RString.EMPTY;
    }

    /**
     * DBの特定診療費データを取得します。
     *
     * @param 明細検索キー 明細検索キー
     * @param 初期の特定診療費List 初期の特定診療費List
     * @return DBの特定診療費データ
     */
    public ShokanTokuteiShinryohi get特定診療費の初期データ(ShoukanharaihishinseimeisaikensakuParameter 明細検索キー,
            List<ShokanTokuteiShinryohi> 初期の特定診療費List) {
        ddgToteishinryoTokubetushinryo_Row row = div.getDdgToteishinryoTokubetushinryo().getActiveRow();
        if (初期の特定診療費List != null) {
            for (ShokanTokuteiShinryohi joho : 初期の特定診療費List) {
                if (joho.getサービス提供年月().equals(明細検索キー.getサービス年月())
                        && joho.get事業者番号().equals(明細検索キー.get事業者番号())
                        && joho.get被保険者番号().equals(明細検索キー.get被保険者番号())
                        && joho.get整理番号().equals(明細検索キー.get整理番号())
                        && joho.get明細番号().equals(明細検索キー.get明細番号())
                        && joho.get様式番号().equals(明細検索キー.get様式番号())
                        && joho.get連番().equals(row.getNumber())) {
                    return joho;
                }
            }
        }
        return null;
    }

    /**
     * DBの特別診療費データを取得します。
     *
     * @param 明細検索キー 明細検索キー
     * @param 初期の特別診療費List 初期の特別診療費List
     * @return DBの特別診療費データ
     */
    private ShokanTokuteiShinryoTokubetsuRyoyo get特別診療費の初期データ(ShoukanharaihishinseimeisaikensakuParameter 明細検索キー,
            List<ShokanTokuteiShinryoTokubetsuRyoyo> 初期の特別診療費List) {
        dgdTokuteiShinryohi_Row row = div.getDgdTokuteiShinryohi().getActiveRow();
        if (初期の特別診療費List != null) {
            for (ShokanTokuteiShinryoTokubetsuRyoyo joho : 初期の特別診療費List) {
                if (joho.getサービス提供年月().equals(明細検索キー.getサービス年月())
                        && joho.get事業者番号().equals(明細検索キー.get事業者番号())
                        && joho.get被保険者番号().equals(明細検索キー.get被保険者番号())
                        && joho.get整理番号().equals(明細検索キー.get整理番号())
                        && joho.get明細番号().equals(明細検索キー.get明細番号())
                        && joho.get様式番号().equals(明細検索キー.get様式番号())
                        && joho.get連番().equals(row.getDefaultDataName7())) {
                    return joho;
                }
            }
        }
        return null;
    }

    /**
     * ViewStateDBの特別診療費データListを取得します。
     *
     * @param 明細検索キー 明細検索キー
     * @param viewStateList viewStateDBList
     * @return 特別診療費データList
     */
    public ArrayList<ShokanTokuteiShinryohi> get当特定診療費ViewStateList(ShoukanharaihishinseimeisaikensakuParameter 明細検索キー,
            List<ShokanTokuteiShinryohi> viewStateList) {
        ArrayList<ShokanTokuteiShinryohi> johoList = new ArrayList<>();
        if (viewStateList != null) {
            for (ShokanTokuteiShinryohi joho : viewStateList) {
                if (明細検索キー.getサービス年月().equals(joho.getサービス提供年月())
                        && 明細検索キー.get事業者番号().equals(joho.get事業者番号())
                        && 明細検索キー.get被保険者番号().equals(joho.get被保険者番号())
                        && 明細検索キー.get整理番号().equals(joho.get整理番号())
                        && 明細検索キー.get明細番号().equals(joho.get明細番号())
                        && 明細検索キー.get様式番号().equals(joho.get様式番号())) {
                    johoList.add(joho);
                }
            }
        }
        return johoList;
    }

    /**
     * ViewStateDBの特別診療費データListを取得します。
     *
     * @param 明細検索キー 明細検索キー
     * @param viewStateList viewStateDBList
     * @return 特別診療費データList
     */
    public ArrayList<ShokanTokuteiShinryoTokubetsuRyoyo> get当特別診療費ViewStateList(ShoukanharaihishinseimeisaikensakuParameter 明細検索キー,
            List<ShokanTokuteiShinryoTokubetsuRyoyo> viewStateList) {
        ArrayList<ShokanTokuteiShinryoTokubetsuRyoyo> johoList = new ArrayList<>();
        if (viewStateList != null) {
            for (ShokanTokuteiShinryoTokubetsuRyoyo joho : viewStateList) {
                if (明細検索キー.getサービス年月().equals(joho.getサービス提供年月())
                        && 明細検索キー.get事業者番号().equals(joho.get事業者番号())
                        && 明細検索キー.get被保険者番号().equals(joho.get被保険者番号())
                        && 明細検索キー.get整理番号().equals(joho.get整理番号())
                        && 明細検索キー.get明細番号().equals(joho.get明細番号())
                        && 明細検索キー.get様式番号().equals(joho.get様式番号())) {
                    johoList.add(joho);
                }
            }
        }
        return johoList;
    }

    private boolean 特定診療費hasChanged(ShokanTokuteiShinryohi dbData) {
        RStringBuilder 摘要builder = new RStringBuilder();
        摘要builder.append(dbData.get摘要１());
        摘要builder.append(dbData.get摘要２());
        摘要builder.append(dbData.get摘要３());
        摘要builder.append(dbData.get摘要４());
        摘要builder.append(dbData.get摘要５());
        摘要builder.append(dbData.get摘要６());
        摘要builder.append(dbData.get摘要７());
        摘要builder.append(dbData.get摘要８());
        摘要builder.append(dbData.get摘要９());
        摘要builder.append(dbData.get摘要１０());
        摘要builder.append(dbData.get摘要１１());
        摘要builder.append(dbData.get摘要１２());
        摘要builder.append(dbData.get摘要１３());
        摘要builder.append(dbData.get摘要１４());
        摘要builder.append(dbData.get摘要１５());
        摘要builder.append(dbData.get摘要１６());
        摘要builder.append(dbData.get摘要１７());
        摘要builder.append(dbData.get摘要１８());
        摘要builder.append(dbData.get摘要１９());
        摘要builder.append(dbData.get摘要２０());

        return !div.getTxtShobyoMei().getValue().equals(dbData.get傷病名())
                || !isInt等しい(div.getTxtShidouKanri().getValue(), dbData.get指導管理料等単位数())
                || !isInt等しい(div.getTxtRibabiriteishon().getValue(), dbData.getリハビリテーション単位数())
                || !isInt等しい(div.getTxtSeishinkaSenmon().getValue(), dbData.get精神科専門療法単位数())
                || !isInt等しい(div.getTxtTanjyunXline().getValue(), dbData.get単純エックス線単位数())
                || !isInt等しい(div.getTxtSochi().getValue(), dbData.get措置単位数())
                || !isInt等しい(div.getTxtTejyutsu().getValue(), dbData.get手術単位数())
                || !isInt等しい(div.getTxtGoukei().getValue(), dbData.get合計単位数())
                || !isRStr等しい(div.getTxtMutiTekiyo().getValue(), 摘要builder.toRString());
    }

    private boolean 特別診療費hasChanged(ShokanTokuteiShinryoTokubetsuRyoyo dbData) {
        return !div.getTxtShobyoMeiDown().getValue().equals(dbData.get傷病名())
                || !div.getTxtShikibetsuCode().getValue().equals(dbData.get識別番号())
                || div.getTxtKaiyisuNisu().getValue().intValue() != dbData.get回数()
                || div.getTxtGoukeiTanyi().getValue().intValue() != dbData.get合計単位数()
                || !isRStr等しい(div.getTxtTekiyoDown().getValue(), dbData.get摘要());
    }

    private boolean isInt等しい(Decimal decimal, int inter) {
        if (decimal == null && inter == 0) {
            return true;
        } else if (decimal != null) {
            return decimal.intValue() == inter;
        }
        return false;
    }

    private boolean isRStr等しい(RString str1, RString str2) {
        if ((str1 == null || str1.isEmpty()) && (str2 == null || str2.isEmpty())) {
            return true;
        } else if (str1 != null) {
            return str1.equals(str2);
        }
        return str2.equals(str1);
    }

    /**
     * readOnly特定診療費登録のメソッドます。
     *
     * @param flag boolean
     */
    public void readOnly特定診療費登録(boolean flag) {
        div.getPanelFour().getTxtShobyoMei().setReadOnly(flag);
        div.getPanelFour().getTxtShidouKanri().setReadOnly(flag);
        div.getPanelFour().getTxtRibabiriteishon().setReadOnly(flag);
        div.getPanelFour().getTxtSeishinkaSenmon().setReadOnly(flag);
        div.getPanelFour().getTxtTanjyunXline().setReadOnly(flag);
        div.getPanelFour().getTxtSochi().setReadOnly(flag);
        div.getPanelFour().getTxtTejyutsu().setReadOnly(flag);
        div.getPanelFour().getBtnKeisan().setDisabled(flag);
        div.getPanelFour().getBtnClear().setDisabled(flag);
        div.getPanelFour().getTxtMutiTekiyo().setReadOnly(flag);
    }

    /**
     * readOnly特定診療費_特別診療費登録のメソッドます。
     *
     * @param flag boolean
     */
    public void readOnly特定診療費_特別診療費登録(boolean flag) {
        div.getPanelFive().getTxtShobyoMeiDown().setReadOnly(flag);
        div.getPanelFive().getTxtShikibetsuCode().setReadOnly(flag);
        div.getPanelFive().getBtnJigyosha().setDisabled(flag);
        div.getPanelFive().getBtnCal().setDisabled(flag);
        div.getPanelFive().getBtnClear2().setDisabled(flag);
        div.getPanelFive().getTxtKaiyisuNisu().setReadOnly(flag);
        div.getPanelFive().getTxtTekiyoDown().setReadOnly(flag);
    }

    /**
     * エリア制御のメソッドます。
     *
     * @param サービス年月 FlexibleYearMonth
     */
    public void setエリア制御(FlexibleYearMonth サービス年月) {
        if (サービス年月.isBeforeOrEquals(平成１５年３月)) {
            div.getDgdTokuteiShinryohi().setDisplayNone(true);
            div.getDdgToteishinryoTokubetushinryo().setVisible(true);
            div.getPanelFour().setVisible(false);
            div.getPanelFive().setDisplayNone(true);
        } else if (平成１５年４月.isBeforeOrEquals(サービス年月)) {
            div.getDgdTokuteiShinryohi().setVisible(true);
            div.getDdgToteishinryoTokubetushinryo().setDisplayNone(true);
            div.getPanelFour().setDisplayNone(true);
            div.getPanelFive().setVisible(false);
        }
    }

    /**
     * 削除モードの初期化のメソッドます。
     */
    public void set削除状態() {
        div.getPanelThree().setDisabled(true);
    }

    /**
     * 識別名称設定のメソッドます。
     *
     * @param サービス年月 FlexibleYearMonth
     * @param 様式番号 RString
     */
    public void set識別名称(FlexibleYearMonth サービス年月, RString 様式番号) {
        RString hiddenSelectCode = DataPassingConverter.deserialize(div.getHiddenSelectCode(), RString.class);
        RString hiddenSelectKoumoku = DataPassingConverter.deserialize(div.getHiddenSelectKoumoku(), RString.class);
        div.getPanelFive().getTxtShikibetsuCode().setValue(hiddenSelectCode);
        div.getPanelFive().getTxtName().setValue(hiddenSelectKoumoku);
        set識別項目(hiddenSelectCode, サービス年月, 様式番号);
    }

    /**
     * 識別コード入力補助ボタンのメソッドます。
     *
     * @param サービス年月 FlexibleYearMonth
     * @param 様式番号 RString
     */
    public void set識別コード(FlexibleYearMonth サービス年月, RString 様式番号) {
        RString 識別コード = div.getPanelFive().getTxtShikibetsuCode().getValue();
        div.setHiddenYoshikiNo(DataPassingConverter.serialize(様式番号));
        div.setHiddenServiceTeikyoYM(DataPassingConverter.serialize(new RString(サービス年月.toString())));
        div.setHiddenShikibetsuCode(DataPassingConverter.serialize(識別コード));
    }

    /**
     * 特定診療費登録設定のメソッドます。
     *
     * @param flag boolean
     */
    public void set特定診療費登録(boolean flag) {
        div.getPanelFour().setVisible(flag);
    }

    /**
     * 特定診療費登録設定のメソッドます。
     *
     * @param flag boolean
     */
    public void set特定診療費(boolean flag) {
        div.getPanelFive().setVisible(flag);
    }

    /**
     * 特定診療費グリッドデータのComparatorです。（「連番」の降順でソート）
     */
    private static class ToteishinryoTokubetushinryoRowComparator implements Comparator<ddgToteishinryoTokubetushinryo_Row> {

        @Override
        public int compare(ddgToteishinryoTokubetushinryo_Row row1, ddgToteishinryoTokubetushinryo_Row row2) {
            return row2.getNumber().compareTo(row1.getNumber());
        }
    }

    /**
     * 特定診療費・特別診療費グリッドデータのComparatorです。（「連番」の降順でソート）
     */
    private static class TokuteiShinryohiRowComparator implements Comparator<dgdTokuteiShinryohi_Row> {

        @Override
        public int compare(dgdTokuteiShinryohi_Row row1, dgdTokuteiShinryohi_Row row2) {
            return row2.getDefaultDataName7().compareTo(row1.getDefaultDataName7());
        }
    }

    private int set平成15年月Max連番(int max連番, ddgToteishinryoTokubetushinryo_Row row) {
        if (max連番 < Integer.valueOf(row.getNumber().toString())) {
            max連番 = Integer.valueOf(row.getNumber().toString());
        }
        return max連番;
    }

    private int set平成15年月後Max連番(int max連番, dgdTokuteiShinryohi_Row row) {
        if (max連番 < Integer.valueOf(row.getDefaultDataName7().toString())) {
            max連番 = Integer.valueOf(row.getDefaultDataName7().toString());
        }
        return max連番;
    }
}
