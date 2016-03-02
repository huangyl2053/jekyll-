/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.dbc0820023;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShikibetsuNoKanri;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShokanTokuteiShinryoTokubetsuRyoyo;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShokanTokuteiShinryohi;
import jp.co.ndensan.reams.db.dbc.business.core.basic.TokuteiShinryoServiceCode;
import jp.co.ndensan.reams.db.dbc.business.core.syokanbaraihishikyushinseikette.ShokanKihonParameter;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0820023.TokuteiShinryohiPanelDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0820023.ddgToteishinryoTokubetushinryo_Row;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0820023.dgdTokuteiShinryohi_Row;
import jp.co.ndensan.reams.db.dbc.divcontroller.viewbox.ViewStateKeys;
import jp.co.ndensan.reams.db.dbc.divcontroller.viewbox.syokanbaraihishikyushinseikette.SyokanbaraihishikyushinseiketteParameter;
import jp.co.ndensan.reams.db.dbc.service.core.shokanbaraijyokyoshokai.ShokanbaraiJyokyoShokai;
import jp.co.ndensan.reams.db.dbc.service.core.syokanbaraihishikyushinseikette.SyokanbaraihiShikyuShinseiKetteManager;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.CodeShubetsu;
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
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
import jp.co.ndensan.reams.uz.uza.util.code.CodeMaster;
import jp.co.ndensan.reams.uz.uza.util.code.entity.UzT0007CodeEntity;
import jp.co.ndensan.reams.uz.uza.util.editor.DecimalFormatter;

/**
 * 償還払い費支給申請決定_サービス提供証明書(特定診療費）のハンドラクラスです。
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
    private static final int NUMBER_０ = 0;
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

    /**
     * TokuteiShinryohiPanelHandler
     *
     * @param div TokuteiShinryohiPanelDiv
     */
    public TokuteiShinryohiPanelHandler(TokuteiShinryohiPanelDiv div) {
        this.div = div;
    }

    /**
     * 申請共通エリアの設定
     *
     * @param サービス年月 サービス年月
     * @param 事業者番号 事業者番号
     * @param 申請日 申請日
     * @param 明細番号 明細番号
     * @param 証明書 証明書
     */
    public void set申請共通エリア(
            FlexibleYearMonth サービス年月,
            JigyoshaNo 事業者番号,
            RString 申請日,
            RString 明細番号,
            RString 証明書) {
        div.getPanelTwo().getTxtServiceTeikyoYM().setValue(new RDate(サービス年月.toString()));
        div.getPanelTwo().getTxtShinseiYMD().setValue(new RDate(申請日.toString()));
        div.getPanelTwo().getTxtJigyoshaBango().setValue(事業者番号.getColumnValue());
        div.getPanelTwo().getTxtMeisaibango().setValue(明細番号);
        div.getPanelTwo().getTxtShomeisho().setValue(証明書);
    }

    /**
     * ボタンを制御の設定
     *
     * @param shikibetsuNoKanri ShikibetsuNoKanri
     */
    public void getボタンを制御(ShikibetsuNoKanri shikibetsuNoKanri) {

        SyokanbaraihishikyushinseiketteParameter paramter = ViewStateHolder.get(ViewStateKeys.償還払費申請検索キー,
                SyokanbaraihishikyushinseiketteParameter.class);
        HihokenshaNo 被保険者番号 = paramter.getHiHokenshaNo();
        FlexibleYearMonth サービス年月 = paramter.getServiceTeikyoYM();
        RString 整理番号 = paramter.getSeiriNp();
        JigyoshaNo 事業者番号 = paramter.getJigyoshaNo();
        RString 様式番号 = paramter.getYoshikiNo();
        RString 明細番号 = paramter.getMeisaiNo();
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
            if (count1 == 1) {
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
            if (count2 == 1) {
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
            if (count4 == 1) {
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
            if (count5 == 1) {
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
            if (count6 == 1) {
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
        if (設定不可.equals(shikibetsuNoKanri.get特定疾患施設療養設定区分())) {
            div.getPanelTwo().getBtnKinkyujiShoteiShikan().setDisabled(true);
        } else if (設定可必須.equals(shikibetsuNoKanri.get特定疾患施設療養設定区分())) {
            int count7 = SyokanbaraihiShikyuShinseiKetteManager.createInstance().updShokanShoteiShikkanShisetsuRyoyo(
                    被保険者番号, サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号);
            if (count7 == 1) {
                div.getPanelTwo().getBtnKinkyujiShoteiShikan().setIconNameEnum(IconName.Incomplete);
            } else {
                div.getPanelTwo().getBtnKinkyujiShoteiShikan().setIconNameEnum(IconName.Complete);
            }
        } else if (設定可任意.equals(shikibetsuNoKanri.get特定疾患施設療養設定区分())) {
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
            if (count8 == 1) {
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
            if (count9 == 1) {
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
            if (count10 == 1) {
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
            if (count11 == 1) {
                div.getPanelTwo().getBtnShafuku().setIconNameEnum(IconName.Incomplete);
            } else {
                div.getPanelTwo().getBtnShafuku().setIconNameEnum(IconName.Complete);
            }
        } else if (設定可任意.equals(shikibetsuNoKanri.get社会福祉法人軽減設定区分())) {
            div.getPanelTwo().getBtnShafuku().setIconNameEnum(IconName.NONE);
        }
    }

    /**
     * 特定診療費一覧グリッドの設定
     *
     * @param shokanTokuteiShinryohiList List<ShokanTokuteiShinryohi>
     */
    public void set特定診療費一覧グリッド(List<ShokanTokuteiShinryohi> shokanTokuteiShinryohiList) {
        List<ddgToteishinryoTokubetushinryo_Row> dataSource = new ArrayList<>();
        for (ShokanTokuteiShinryohi entity : shokanTokuteiShinryohiList) {
            ddgToteishinryoTokubetushinryo_Row row = new ddgToteishinryoTokubetushinryo_Row();
            row.setShobyouName(entity.get傷病名());
            row.setShidouKanri(DecimalFormatter.toコンマ区切りRString(new Decimal(entity.get指導管理料等単位数()), 0));
            row.setRihabiri(DecimalFormatter.toコンマ区切りRString(new Decimal(entity.getリハビリテーション単位数()), 0));
            row.setSeishinka(DecimalFormatter.toコンマ区切りRString(new Decimal(entity.get精神科専門療法単位数()), 0));
            row.setEkusuLine(DecimalFormatter.toコンマ区切りRString(new Decimal(entity.get単純エックス線単位数()), 0));
            row.setSochi(DecimalFormatter.toコンマ区切りRString(new Decimal(entity.get措置単位数()), 0));
            row.setTejyutsu(DecimalFormatter.toコンマ区切りRString(new Decimal(entity.get手術単位数()), 0));
            row.setGoukeyiTanyi(DecimalFormatter.toコンマ区切りRString(new Decimal(entity.get合計単位数()), 0));
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
        div.getDdgToteishinryoTokubetushinryo().setDataSource(dataSource);
    }

    /**
     * 特定診療費登録の設定
     *
     * @param row ddgToteishinryoTokubetushinryo_Row
     */
    public void set特定診療費登録(ddgToteishinryoTokubetushinryo_Row row) {
        clear特定診療費登録();
        div.getTxtShobyoMei().setValue(row.getShobyouName());
        if (!row.getShidouKanri().isEmpty()) {
            div.getTxtShidouKanri().setValue(new Decimal(row.getShidouKanri().toString()));
        }
        if (!row.getRihabiri().isEmpty()) {
            div.getTxtRibabiriteishon().setValue(new Decimal(row.getRihabiri().toString()));
        }
        if (!row.getSeishinka().isEmpty()) {
            div.getTxtSeishinkaSenmon().setValue(new Decimal(row.getSeishinka().toString()));
        }
        if (!row.getEkusuLine().isEmpty()) {
            div.getTxtTanjyunXline().setValue(new Decimal(row.getEkusuLine().toString()));
        }
        if (!row.getSochi().isEmpty()) {
            div.getTxtSochi().setValue(new Decimal(row.getSochi().toString()));
        }
        if (!row.getTejyutsu().isEmpty()) {
            div.getTxtTejyutsu().setValue(new Decimal(row.getTejyutsu().toString()));
        }
        if (!row.getGoukeyiTanyi().isEmpty()) {
            div.getTxtGoukei().setValue(new Decimal(row.getGoukeyiTanyi().toString()));
        }
        div.getTxtMutiTekiyo().setValue(row.getMutiTekiyo());
        div.setRowId(new RString(String.valueOf(row.getId())));
    }

    /**
     * 計算結果
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
     * 特定診療費登録のクリアする
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
     * 選択行のデータ
     *
     * @return row ddgToteishinryoTokubetushinryo_Row
     */
    public ddgToteishinryoTokubetushinryo_Row getSelectedRow() {
        return div.getDdgToteishinryoTokubetushinryo().getDataSource().get(Integer.parseInt(
                div.getRowId().toString()));
    }

    /**
     * 「確定する」ボタン
     *
     * @param ddgRow ddgToteishinryoTokubetushinryo_Row
     */
    public void modifyRow(ddgToteishinryoTokubetushinryo_Row ddgRow) {
        RString state = ViewStateHolder.get(ViewStateKeys.状態, RString.class);
        if (修正.equals(state)) {
            if (RowState.Added.equals(ddgRow.getRowState())) {
                ddgRow.setRowState(RowState.Added);
                setDdgToteishinryoTokubetushinryo_Row(ddgRow);
            } else {
                modifiedDdgToteishinryoTokubetushinryo(ddgRow);
            }
        } else if (削除.equals(state)) {
            if (RowState.Added.equals(ddgRow.getRowState())) {
                div.getDdgToteishinryoTokubetushinryo().getDataSource().remove(Integer.parseInt(
                        div.getRowId().toString()));
                clear特定診療費登録();
                div.getPanelFour().setVisible(false);
            } else {
                ddgRow.setRowState(RowState.Deleted);
                setDdgToteishinryoTokubetushinryo_Row(ddgRow);
            }
        } else if (登録.equals(state)) {
            ddgRow.setRowState(RowState.Added);
            setDdgToteishinryoTokubetushinryo_Row(ddgRow);
        }
    }

    private void modifiedDdgToteishinryoTokubetushinryo(ddgToteishinryoTokubetushinryo_Row ddgRow) {
        boolean flag = checkOfModified(ddgRow);
        if (flag) {
            ddgRow.setRowState(RowState.Modified);
            setDdgToteishinryoTokubetushinryo_Row(ddgRow);
        }
    }

    private boolean checkOfModified(ddgToteishinryoTokubetushinryo_Row ddgRow) {
        RString div傷病名 = div.getTxtShobyoMei().getValue().isEmpty() || div.getTxtShobyoMei().getValue() == null
                ? RString.EMPTY : div.getTxtShobyoMei().getValue();
        RString ddgRow傷病名 = ddgRow.getShobyouName().isEmpty() || ddgRow.getShobyouName() == null
                ? RString.EMPTY : ddgRow.getShobyouName();
        Decimal ddgRow指導管理科等単位数 = ddgRow.getShidouKanri().isEmpty() ? null : new Decimal(
                ddgRow.getShidouKanri().toString());
        Decimal ddgRowリハビリテーション単位数 = ddgRow.getRihabiri().isEmpty() ? null : new Decimal(
                ddgRow.getRihabiri().toString());
        Decimal ddgRow精神科専門療法単位数 = ddgRow.getSeishinka().isEmpty() ? null : new Decimal(
                ddgRow.getSeishinka().toString());
        Decimal ddgRow単純エックス線単位数 = ddgRow.getEkusuLine().isEmpty() ? null : new Decimal(
                ddgRow.getEkusuLine().toString());
        Decimal ddgRow措置単位数 = ddgRow.getSochi().isEmpty() ? null : new Decimal(ddgRow.getSochi().toString());
        Decimal ddgRow手術単位数 = ddgRow.getTejyutsu().isEmpty() ? null : new Decimal(ddgRow.getTejyutsu().toString());
        Decimal ddgRow合計単位数 = ddgRow.getGoukeyiTanyi().isEmpty() ? null : new Decimal(
                ddgRow.getGoukeyiTanyi().toString());
        RString ddgRow摘要 = ddgRow.getMutiTekiyo().isEmpty() || ddgRow.getMutiTekiyo() == null
                ? RString.EMPTY : ddgRow.getMutiTekiyo();
        RString div摘要 = div.getTxtMutiTekiyo().getValue().isEmpty() || div.getTxtMutiTekiyo().getValue() == null
                ? RString.EMPTY : div.getTxtMutiTekiyo().getValue();
        return check１(div傷病名, ddgRow傷病名, ddgRow指導管理科等単位数, ddgRowリハビリテーション単位数,
                ddgRow精神科専門療法単位数, ddgRow単純エックス線単位数, ddgRow措置単位数, ddgRow手術単位数,
                ddgRow合計単位数, ddgRow摘要, div摘要);
    }

    private boolean check１(RString div傷病名,
            RString ddgRow傷病名,
            Decimal ddgRow指導管理科等単位数,
            Decimal ddgRowリハビリテーション単位数,
            Decimal ddgRow精神科専門療法単位数,
            Decimal ddgRow単純エックス線単位数,
            Decimal ddgRow措置単位数,
            Decimal ddgRow手術単位数,
            Decimal ddgRow合計単位数,
            RString ddgRow摘要,
            RString div摘要) {
        if (!ddgRow傷病名.equals(div傷病名)) {
            return true;
        }
        if (ddgRow指導管理科等単位数 != div.getTxtShidouKanri().getValue()) {
            return true;
        }
        if (ddgRowリハビリテーション単位数 != div.getTxtRibabiriteishon().getValue()) {
            return true;
        }
        if (ddgRow精神科専門療法単位数 != div.getTxtSeishinkaSenmon().getValue()) {
            return true;
        }
        if (ddgRow単純エックス線単位数 != div.getTxtTanjyunXline().getValue()) {
            return true;
        }
        if (ddgRow措置単位数 != div.getTxtSochi().getValue()) {
            return true;
        }
        if (ddgRow手術単位数 != div.getTxtTejyutsu().getValue()) {
            return true;
        }
        if (ddgRow合計単位数 != div.getTxtGoukei().getValue()) {
            return true;
        }
        return !ddgRow摘要.equals(div摘要);
    }

    private void setDdgToteishinryoTokubetushinryo_Row(ddgToteishinryoTokubetushinryo_Row ddgRow) {
        ddgRow.setShobyouName(div.getTxtShobyoMei().getValue());
        if (div.getTxtShidouKanri().getValue() != null) {
            ddgRow.setShidouKanri(DecimalFormatter.toコンマ区切りRString(div.getTxtShidouKanri().getValue(), 0));
        }
        if (div.getTxtRibabiriteishon().getValue() != null) {
            ddgRow.setRihabiri(DecimalFormatter.toコンマ区切りRString(div.getTxtRibabiriteishon().getValue(), 0));
        }
        if (div.getTxtSeishinkaSenmon().getValue() != null) {
            ddgRow.setSeishinka(DecimalFormatter.toコンマ区切りRString(div.getTxtSeishinkaSenmon().getValue(), 0));
        }
        if (div.getTxtTanjyunXline().getValue() != null) {
            ddgRow.setEkusuLine(DecimalFormatter.toコンマ区切りRString(div.getTxtTanjyunXline().getValue(), 0));
        }
        if (div.getTxtSochi().getValue() != null) {
            ddgRow.setSochi(DecimalFormatter.toコンマ区切りRString(div.getTxtSochi().getValue(), 0));
        }
        if (div.getTxtTejyutsu().getValue() != null) {
            ddgRow.setTejyutsu(DecimalFormatter.toコンマ区切りRString(div.getTxtTejyutsu().getValue(), 0));
        }
        if (div.getTxtGoukei().getValue() != null) {
            ddgRow.setGoukeyiTanyi(DecimalFormatter.toコンマ区切りRString(div.getTxtGoukei().getValue(), 0));
        }
        ddgRow.setMutiTekiyo(div.getTxtMutiTekiyo().getValue());
        if (登録.equals(ViewStateHolder.get(ViewStateKeys.状態, RString.class))) {
            List<ddgToteishinryoTokubetushinryo_Row> list = div.getDdgToteishinryoTokubetushinryo().getDataSource();
            list.add(ddgRow);
        }
        clear特定診療費登録();
        div.getPanelFour().setVisible(false);
    }

    /**
     * 特定診療費_特別診療費一覧グリッド
     *
     * @param list List<ShokanTokuteiShinryoTokubetsuRyoyo>
     */
    public void set特定診療費_特別診療費一覧グリッド(List<ShokanTokuteiShinryoTokubetsuRyoyo> list) {
        List<dgdTokuteiShinryohi_Row> dataSource = new ArrayList<>();
        for (ShokanTokuteiShinryoTokubetsuRyoyo entity : list) {
            dgdTokuteiShinryohi_Row row = new dgdTokuteiShinryohi_Row();
            row.setDefaultDataName1(entity.get傷病名());
            row.setDefaultDataName2(entity.get識別番号());
            row.setDefaultDataName3(DecimalFormatter.toコンマ区切りRString(new Decimal(entity.get単位数()), 0));
            row.setDefaultDataName4(DecimalFormatter.toコンマ区切りRString(new Decimal(entity.get回数()), 0));
            row.setDefaultDataName5(DecimalFormatter.toコンマ区切りRString(new Decimal(entity.get合計単位数()), 0));
            row.setDefaultDataName6(entity.get摘要());
            row.setDefaultDataName7(entity.get連番());
            dataSource.add(row);
        }
        div.getPanelThree().getDgdTokuteiShinryohi().setDataSource(dataSource);
    }

    /**
     * 特定診療費_特別診療費登録
     *
     * @param row dgdTokuteiShinryohi_Row
     */
    public void set特定診療費_特別診療費登録(dgdTokuteiShinryohi_Row row) {
        clear特定診療費_特別診療費登録();
        div.getTxtShobyoMeiDown().setValue(row.getDefaultDataName1());
        div.getTxtShikibetsuCode().setValue(row.getDefaultDataName2());
        set識別項目(row.getDefaultDataName2());
        if (!row.getDefaultDataName4().isEmpty()) {
            div.getTxtKaiyisuNisu().setValue(new Decimal(row.getDefaultDataName4().toString()));
        }
        if (!row.getDefaultDataName5().isEmpty()) {
            div.getTxtGoukeiTanyi().setValue(new Decimal(row.getDefaultDataName5().toString()));
        }
        div.getTxtTekiyoDown().setValue(row.getDefaultDataName6());
        div.setRowId(new RString(String.valueOf(row.getId())));
    }

    /**
     * set識別項目
     *
     * @param hiddenSelectCode RString
     */
    public void set識別項目(RString hiddenSelectCode) {
        TokuteiShinryoServiceCode serviceCode = ShokanbaraiJyokyoShokai.createInstance()
                .getTokuteiShinryoServiceCodeInfo(
                        new ShikibetsuCode(hiddenSelectCode),
                        ViewStateHolder.get(ViewStateKeys.サービス年月, FlexibleYearMonth.class),
                        ViewStateHolder.get(ViewStateKeys.様式番号, RString.class));
        if (serviceCode != null) {
            div.getTxtName().setValue(serviceCode.toEntity().getServiceMeisho());
            div.getTxtTanyi().setValue(new RString(serviceCode.toEntity().getTaniSu().toString()));
            UzT0007CodeEntity code1 = CodeMaster.getCode(SubGyomuCode.DBC介護給付, new CodeShubetsu(new RString("0025")),
                    new Code(serviceCode.toEntity().getSanteiTani()), FlexibleDate.getNowDate());
            RStringBuilder builder1 = new RStringBuilder();
            builder1.append(code1.getコード名称());
            builder1.append(serviceCode.toEntity().getTaniSu());
            builder1.append(単位);
            div.getLblComment1().setText(builder1.toRString());
            UzT0007CodeEntity code2 = CodeMaster.getCode(SubGyomuCode.DBC介護給付, new CodeShubetsu(new RString("0026")),
                    new Code(serviceCode.toEntity().getSanteiSeiyakuKikan()), FlexibleDate.getNowDate());
            RStringBuilder builder2 = new RStringBuilder();
            builder2.append(code2.getコード名称());
            builder2.append(serviceCode.toEntity().getSanteiSeiyakuKaisu());
            builder2.append(回まで);
            div.getLblComment2().setText(builder2.toRString());
        }
    }

    /**
     * 計算結果2
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
     * 特定診療費_特別診療費登録
     */
    public void clear特定診療費_特別診療費登録() {
        div.getTxtShobyoMeiDown().clearValue();
        div.getTxtShikibetsuCode().clearValue();
        div.getTxtName().clearValue();
        div.getLblComment1().setText(new RString(""));
        div.getLblComment2().setText(new RString(""));
        div.getTxtTanyi().clearValue();
        div.getTxtKaiyisuNisu().clearValue();
        div.getTxtGoukeiTanyi().clearValue();
        div.getTxtTekiyoDown().clearValue();
    }

    /**
     * 選択行のデータ２
     *
     * @return row dgdTokuteiShinryohi_Row
     */
    public dgdTokuteiShinryohi_Row getSelectedRow2() {
        return div.getDgdTokuteiShinryohi().getDataSource().get(Integer.parseInt(div.getRowId().toString()));
    }

    /**
     * 「確定する」ボタン
     *
     * @param row dgdTokuteiShinryohi_Row
     */
    public void modifyRow2(dgdTokuteiShinryohi_Row row) {
        RString state = ViewStateHolder.get(ViewStateKeys.状態, RString.class);
        if (修正.equals(state)) {
            if (RowState.Added.equals(row.getRowState())) {
                row.setRowState(RowState.Added);
                setDgdTokuteiShinryohi_Row(row);
            } else {
                modifiedDgdTokuteiShinryohi(row);
            }
        } else if (削除.equals(state)) {
            if (RowState.Added.equals(row.getRowState())) {
                div.getDgdTokuteiShinryohi().getDataSource().remove(Integer.parseInt(div.getRowId().toString()));
                clear特定診療費_特別診療費登録();
                div.getPanelFive().setVisible(false);
            } else {
                row.setRowState(RowState.Deleted);
                setDgdTokuteiShinryohi_Row(row);
            }
        } else if (登録.equals(state)) {
            row.setRowState(RowState.Added);
            setDgdTokuteiShinryohi_Row(row);
        }
    }

    private void modifiedDgdTokuteiShinryohi(dgdTokuteiShinryohi_Row row) {
        boolean flag = checkOfModified2(row);
        if (flag) {
            row.setRowState(RowState.Modified);
            setDgdTokuteiShinryohi_Row(row);
        }
    }

    private boolean checkOfModified2(dgdTokuteiShinryohi_Row row) {
        RString div傷病名 = div.getTxtShobyoMeiDown().getValue().isEmpty() || div.getTxtShobyoMeiDown().getValue() == null
                ? RString.EMPTY : div.getTxtShobyoMeiDown().getValue();
        RString row傷病名 = row.getDefaultDataName1().isEmpty() || row.getDefaultDataName1() == null
                ? RString.EMPTY : row.getDefaultDataName1();
        RString div識別番号 = div.getTxtShikibetsuCode().getValue().isEmpty() || div.getTxtShikibetsuCode().getValue() == null
                ? RString.EMPTY : div.getTxtShikibetsuCode().getValue();
        RString row識別番号 = row.getDefaultDataName2().isEmpty() || row.getDefaultDataName2() == null
                ? RString.EMPTY : row.getDefaultDataName2();
        RString div単位数 = div.getTxtTanyi().getValue().isEmpty() || div.getTxtTanyi().getValue() == null
                ? RString.EMPTY : div.getTxtTanyi().getValue();
        RString row単位数 = row.getDefaultDataName3().isEmpty() || row.getDefaultDataName3() == null
                ? RString.EMPTY : row.getDefaultDataName3();
        RString div摘要 = div.getTxtTekiyoDown().getValue().isEmpty() || div.getTxtTekiyoDown().getValue() == null
                ? RString.EMPTY : div.getTxtTekiyoDown().getValue();
        RString row摘要 = row.getDefaultDataName6().isEmpty() || row.getDefaultDataName6() == null
                ? RString.EMPTY : row.getDefaultDataName6();
        return check２(div傷病名, row傷病名, div識別番号, row識別番号, div単位数, row単位数, div摘要, row摘要, row);
    }

    private boolean check２(RString div傷病名,
            RString row傷病名,
            RString div識別番号,
            RString row識別番号,
            RString div単位数,
            RString row単位数,
            RString div摘要,
            RString row摘要,
            dgdTokuteiShinryohi_Row row) {
        int div回数 = div.getTxtKaiyisuNisu().getValue() == null ? 0 : div.getTxtKaiyisuNisu().getValue().intValue();
        int row回数 = row.getDefaultDataName4().isEmpty() || row.getDefaultDataName4() == null
                ? 0 : Integer.valueOf(row.getDefaultDataName4().toString());
        int div合計単位数 = div.getTxtGoukeiTanyi().getValue() == null ? 0 : div.getTxtGoukeiTanyi().getValue().intValue();
        int row合計単位数 = row.getDefaultDataName5().isEmpty() || row.getDefaultDataName5() == null
                ? 0 : Integer.valueOf(row.getDefaultDataName5().toString());
        if (!row傷病名.equals(div傷病名)) {
            return true;
        }
        if (!row識別番号.equals(div識別番号)) {
            return true;
        }
        if (row単位数 != div単位数) {
            return true;
        }
        if (row回数 != div回数) {
            return true;
        }
        if (row合計単位数 != div合計単位数) {
            return true;
        }
        return !row摘要.equals(div摘要);
    }

    private void setDgdTokuteiShinryohi_Row(dgdTokuteiShinryohi_Row row) {
        row.setDefaultDataName1(div.getTxtShobyoMeiDown().getValue());
        row.setDefaultDataName2(div.getTxtShikibetsuCode().getValue());
        if (!div.getTxtTanyi().getValue().isEmpty()) {
            row.setDefaultDataName3(DecimalFormatter.toコンマ区切りRString(new Decimal(div.getTxtTanyi()
                    .getValue().toString()), 0));
        }
        if (div.getTxtKaiyisuNisu().getValue() != null) {
            row.setDefaultDataName4(DecimalFormatter.toコンマ区切りRString(div.getTxtKaiyisuNisu().getValue(), 0));
        }
        if (div.getTxtGoukeiTanyi().getValue() != null) {
            row.setDefaultDataName5(DecimalFormatter.toコンマ区切りRString(div.getTxtGoukeiTanyi().getValue(), 0));
        }
        row.setDefaultDataName6(div.getTxtTekiyoDown().getValue());
        if (登録.equals(ViewStateHolder.get(ViewStateKeys.状態, RString.class))) {
            List<dgdTokuteiShinryohi_Row> list = div.getDgdTokuteiShinryohi().getDataSource();
            list.add(row);
        }
        clear特定診療費_特別診療費登録();
        div.getPanelFive().setVisible(false);
    }

    /**
     * 内容変更状態
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
     * 保存処理
     *
     * @return RString
     */
    public RString 保存処理() {
        SyokanbaraihishikyushinseiketteParameter paramter = ViewStateHolder.get(ViewStateKeys.償還払費申請検索キー,
                SyokanbaraihishikyushinseiketteParameter.class);
        HihokenshaNo 被保険者番号 = paramter.getHiHokenshaNo();
        FlexibleYearMonth サービス年月 = paramter.getServiceTeikyoYM();
        RString 整理番号 = paramter.getSeiriNp();
        JigyoshaNo 事業者番号 = paramter.getJigyoshaNo();
        RString 様式番号 = paramter.getYoshikiNo();
        RString 明細番号 = paramter.getMeisaiNo();
        if (明細番号 == null || 明細番号.isEmpty()) {
            明細番号 = new RString("0001");
        }
        List<ShokanTokuteiShinryohi> entityList1 = new ArrayList<>();
        List<ShokanTokuteiShinryoTokubetsuRyoyo> entityList2 = new ArrayList<>();
        ShokanKihonParameter parameter = ShokanKihonParameter.createSelectByKeyParam(
                被保険者番号, サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号, 0);
        if (削除.equals(ViewStateHolder.get(ViewStateKeys.処理モード, RString.class))) {
            SyokanbaraihiShikyuShinseiKetteManager.createInstance().delShokanSyomeisyo(被保険者番号,
                    サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号);
        } else {
            if (サービス年月.isBeforeOrEquals(平成１５年３月)) {
                entityList1 = save特定診療費(entityList1, 被保険者番号, サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号);
            } else if (平成１５年４月.isBeforeOrEquals(サービス年月)) {
                entityList2 = save特定診療費_特別診療費(entityList2, 被保険者番号, サービス年月, 整理番号, 事業者番号,
                        様式番号, 明細番号);
            }
            SyokanbaraihiShikyuShinseiKetteManager.createInstance().updShokanTokuteiShinryohi(entityList1,
                    entityList2, parameter);
        }
        return 明細番号;
    }

    private List<ShokanTokuteiShinryohi> save特定診療費(List<ShokanTokuteiShinryohi> entityList1,
            HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス年月,
            RString 整理番号,
            JigyoshaNo 事業者番号,
            RString 様式番号,
            RString 明細番号) {
        int max連番 = 0;
        List<ShokanTokuteiShinryohi> shokanTokuteiShinryohiList = ViewStateHolder.get(
                ViewStateKeys.償還払請求特定診療費データ, List.class);
        Map<RString, ShokanTokuteiShinryohi> map = new HashMap<>();
        for (ShokanTokuteiShinryohi entity : shokanTokuteiShinryohiList) {
            map.put(entity.get連番(), entity);
            if (max連番 < Integer.valueOf(entity.get連番().toString())) {
                max連番 = Integer.valueOf(entity.get連番().toString());
            }
        }
        for (ddgToteishinryoTokubetushinryo_Row ddg : div.getDdgToteishinryoTokubetushinryo().getDataSource()) {
            if (RowState.Modified.equals(ddg.getRowState())) {
                ShokanTokuteiShinryohi entityModified = map.get(ddg.getNumber());
                entityModified = buildShokanTokuteiShinryohi(entityModified, ddg);
                entityList1.add(entityModified);
            } else if (RowState.Deleted.equals(ddg.getRowState())) {
                ShokanTokuteiShinryohi entityDeleted = map.get(ddg.getNumber());
                entityDeleted = entityDeleted.deleted();
                entityList1.add(entityDeleted);
            } else if (RowState.Added.equals(ddg.getRowState())) {
                max連番 = max連番 + 1;
                ShokanTokuteiShinryohi entityAdded = new ShokanTokuteiShinryohi(
                        被保険者番号,
                        サービス年月,
                        整理番号,
                        事業者番号,
                        様式番号,
                        明細番号,
                        new RString(String.valueOf(max連番))).createBuilderForEdit().build();
                entityAdded = buildShokanTokuteiShinryohi(entityAdded, ddg);
                entityList1.add(entityAdded);
            } else {
                ShokanTokuteiShinryohi entityUnchanged = map.get(ddg.getNumber());
                entityList1.add(entityUnchanged);
            }
        }
        return entityList1;
    }

    private List<ShokanTokuteiShinryoTokubetsuRyoyo> save特定診療費_特別診療費(
            List<ShokanTokuteiShinryoTokubetsuRyoyo> entityList2,
            HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス年月,
            RString 整理番号,
            JigyoshaNo 事業者番号,
            RString 様式番号,
            RString 明細番号) {
        int max連番 = 0;
        List<ShokanTokuteiShinryoTokubetsuRyoyo> shokanTokuteiShinryoTokubetsuRyoyoList = ViewStateHolder.get(
                ViewStateKeys.償還払請求特定診療費_特別療養費一覧, List.class);
        Map<RString, ShokanTokuteiShinryoTokubetsuRyoyo> map = new HashMap<>();
        for (ShokanTokuteiShinryoTokubetsuRyoyo entity : shokanTokuteiShinryoTokubetsuRyoyoList) {
            map.put(entity.get連番(), entity);
            if (max連番 < Integer.valueOf(entity.get連番().toString())) {
                max連番 = Integer.valueOf(entity.get連番().toString());
            }
        }
        for (dgdTokuteiShinryohi_Row dgdRow : div.getDgdTokuteiShinryohi().getDataSource()) {
            if (RowState.Modified.equals(dgdRow.getRowState())) {
                ShokanTokuteiShinryoTokubetsuRyoyo entityModified = map.get(dgdRow.getDefaultDataName7());
                entityModified = entityModified.createBuilderForEdit().build();
                entityModified = buildShokanTokuteiShinryoTokubetsuRyoyo(entityModified, dgdRow);
                entityList2.add(entityModified);
            } else if (RowState.Deleted.equals(dgdRow.getRowState())) {
                ShokanTokuteiShinryoTokubetsuRyoyo entityDeleted = map.get(dgdRow.getDefaultDataName7());
                entityDeleted = entityDeleted.deleted();
                entityList2.add(entityDeleted);
            } else if (RowState.Added.equals(dgdRow.getRowState())) {
                max連番 = max連番 + 1;
                ShokanTokuteiShinryoTokubetsuRyoyo entityAdded = new ShokanTokuteiShinryoTokubetsuRyoyo(
                        被保険者番号,
                        サービス年月,
                        整理番号,
                        事業者番号,
                        様式番号,
                        明細番号,
                        new RString(String.valueOf(max連番))).createBuilderForEdit().build();
                entityAdded = buildShokanTokuteiShinryoTokubetsuRyoyo(entityAdded, dgdRow);
                entityList2.add(entityAdded);
            } else {
                ShokanTokuteiShinryoTokubetsuRyoyo entityDeleted = map.get(dgdRow.getDefaultDataName7());
                entityList2.add(entityDeleted);
            }
        }
        return entityList2;
    }

    private ShokanTokuteiShinryoTokubetsuRyoyo buildShokanTokuteiShinryoTokubetsuRyoyo(
            ShokanTokuteiShinryoTokubetsuRyoyo entity,
            dgdTokuteiShinryohi_Row dgdRow) {
        entity = entity.createBuilderForEdit()
                .set傷病名(dgdRow.getDefaultDataName1())
                .set識別番号(dgdRow.getDefaultDataName2()).build();
        if (!dgdRow.getDefaultDataName3().isEmpty()) {
            entity = entity.createBuilderForEdit()
                    .set単位数(Integer.valueOf(dgdRow.getDefaultDataName3().toString())).build();
        }
        if (!dgdRow.getDefaultDataName4().isEmpty()) {
            entity = entity.createBuilderForEdit()
                    .set回数(Integer.valueOf(dgdRow.getDefaultDataName4().toString())).build();
        }
        if (!dgdRow.getDefaultDataName5().isEmpty()) {
            entity = entity.createBuilderForEdit()
                    .set合計単位数(Integer.valueOf(dgdRow.getDefaultDataName5().toString())).build();
        }
        if (!dgdRow.getDefaultDataName6().isEmpty()) {
            entity = entity.createBuilderForEdit()
                    .set摘要(dgdRow.getDefaultDataName6()).build();
        }
        return entity;
    }

    private ShokanTokuteiShinryohi buildShokanTokuteiShinryohi(
            ShokanTokuteiShinryohi entityModified,
            ddgToteishinryoTokubetushinryo_Row ddg) {
        entityModified = entityModified.createBuilderForEdit()
                .set傷病名(ddg.getShobyouName()).build();
        if (!ddg.getShidouKanri().isEmpty()) {
            entityModified = entityModified.createBuilderForEdit()
                    .set指導管理料等単位数(Integer.parseInt(ddg.getShidouKanri().toString())).build();
        }
        if (!ddg.getEkusuLine().isEmpty()) {
            entityModified = entityModified.createBuilderForEdit()
                    .set単純エックス線単位数(Integer.parseInt(ddg.getEkusuLine().toString())).build();
        }
        if (!ddg.getRihabiri().isEmpty()) {
            entityModified = entityModified.createBuilderForEdit()
                    .setリハビリテーション単位数(Integer.parseInt(ddg.getRihabiri().toString())).build();
        }
        if (!ddg.getSeishinka().isEmpty()) {
            entityModified = entityModified.createBuilderForEdit()
                    .set精神科専門療法単位数(Integer.parseInt(ddg.getSeishinka().toString())).build();
        }
        if (!ddg.getSochi().isEmpty()) {
            entityModified = entityModified.createBuilderForEdit()
                    .set措置単位数(Integer.parseInt(ddg.getSochi().toString())).build();
        }
        if (!ddg.getTejyutsu().isEmpty()) {
            entityModified = entityModified.createBuilderForEdit()
                    .set手術単位数(Integer.parseInt(ddg.getTejyutsu().toString())).build();
        }
        if (!ddg.getGoukeyiTanyi().isEmpty()) {
            entityModified = entityModified.createBuilderForEdit()
                    .set合計単位数(Integer.parseInt(ddg.getGoukeyiTanyi().toString())).build();
        }
        RString 摘要 = ddg.getMutiTekiyo();
        if (!摘要.isEmpty()) {
            entityModified = set摘要１(entityModified, 摘要);
        }
        return entityModified;
    }

    private ShokanTokuteiShinryohi set摘要１(ShokanTokuteiShinryohi entityModified, RString 摘要) {
        int length = 摘要.length();
        if (length <= NUMBER_３２) {
            entityModified = entityModified.createBuilderForEdit().set摘要１(摘要).build();
        }
        if (length > NUMBER_３２ && length <= NUMBER_６４) {
            entityModified = entityModified.createBuilderForEdit()
                    .set摘要１(摘要.substring(NUMBER_０, NUMBER_３２))
                    .set摘要２(摘要.substring(NUMBER_３２, length))
                    .build();
        }
        if (length > NUMBER_６４ && length <= NUMBER_９６) {
            entityModified = entityModified.createBuilderForEdit()
                    .set摘要１(摘要.substring(NUMBER_０, NUMBER_３２))
                    .set摘要２(摘要.substring(NUMBER_３２, NUMBER_６４))
                    .set摘要３(摘要.substring(NUMBER_６４, length))
                    .build();
        }
        if (length > NUMBER_９６ && length <= NUMBER_１２８) {
            entityModified = entityModified.createBuilderForEdit()
                    .set摘要１(摘要.substring(NUMBER_０, NUMBER_３２))
                    .set摘要２(摘要.substring(NUMBER_３２, NUMBER_６４))
                    .set摘要３(摘要.substring(NUMBER_６４, NUMBER_９６))
                    .set摘要４(摘要.substring(NUMBER_９６, length))
                    .build();
        }
        if (length > NUMBER_１２８ && length <= NUMBER_１６０) {
            entityModified = entityModified.createBuilderForEdit()
                    .set摘要１(摘要.substring(NUMBER_０, NUMBER_３２))
                    .set摘要２(摘要.substring(NUMBER_３２, NUMBER_６４))
                    .set摘要３(摘要.substring(NUMBER_６４, NUMBER_９６))
                    .set摘要４(摘要.substring(NUMBER_９６, NUMBER_１２８))
                    .set摘要５(摘要.substring(NUMBER_１２８, length))
                    .build();
        }
        if (length > NUMBER_１６０ && length <= NUMBER_１９２) {
            entityModified = entityModified.createBuilderForEdit()
                    .set摘要１(摘要.substring(NUMBER_０, NUMBER_３２))
                    .set摘要２(摘要.substring(NUMBER_３２, NUMBER_６４))
                    .set摘要３(摘要.substring(NUMBER_６４, NUMBER_９６))
                    .set摘要４(摘要.substring(NUMBER_９６, NUMBER_１２８))
                    .set摘要５(摘要.substring(NUMBER_１２８, NUMBER_１６０))
                    .set摘要６(摘要.substring(NUMBER_１６０, length))
                    .build();
        }
        if (length > NUMBER_１９２ && length <= NUMBER_２２４) {
            entityModified = entityModified.createBuilderForEdit()
                    .set摘要１(摘要.substring(NUMBER_０, NUMBER_３２))
                    .set摘要２(摘要.substring(NUMBER_３２, NUMBER_６４))
                    .set摘要３(摘要.substring(NUMBER_６４, NUMBER_９６))
                    .set摘要４(摘要.substring(NUMBER_９６, NUMBER_１２８))
                    .set摘要５(摘要.substring(NUMBER_１２８, NUMBER_１６０))
                    .set摘要６(摘要.substring(NUMBER_１６０, NUMBER_１９２))
                    .set摘要７(摘要.substring(NUMBER_１９２, length))
                    .build();
        } else {
            entityModified = set摘要２(entityModified, 摘要, length);
        }
        return entityModified;
    }

    private ShokanTokuteiShinryohi set摘要２(ShokanTokuteiShinryohi entityModified, RString 摘要, int length) {
        if (length > NUMBER_２２４ && length <= NUMBER_２５６) {
            entityModified = entityModified.createBuilderForEdit()
                    .set摘要１(摘要.substring(NUMBER_０, NUMBER_３２))
                    .set摘要２(摘要.substring(NUMBER_３２, NUMBER_６４))
                    .set摘要３(摘要.substring(NUMBER_６４, NUMBER_９６))
                    .set摘要４(摘要.substring(NUMBER_９６, NUMBER_１２８))
                    .set摘要５(摘要.substring(NUMBER_１２８, NUMBER_１６０))
                    .set摘要６(摘要.substring(NUMBER_１６０, NUMBER_１９２))
                    .set摘要７(摘要.substring(NUMBER_１９２, NUMBER_２２４))
                    .set摘要８(摘要.substring(NUMBER_２２４, length))
                    .build();
        }
        if (length > NUMBER_２５６ && length <= NUMBER_２８８) {
            entityModified = entityModified.createBuilderForEdit()
                    .set摘要１(摘要.substring(NUMBER_０, NUMBER_３２))
                    .set摘要２(摘要.substring(NUMBER_３２, NUMBER_６４))
                    .set摘要３(摘要.substring(NUMBER_６４, NUMBER_９６))
                    .set摘要４(摘要.substring(NUMBER_９６, NUMBER_１２８))
                    .set摘要５(摘要.substring(NUMBER_１２８, NUMBER_１６０))
                    .set摘要６(摘要.substring(NUMBER_１６０, NUMBER_１９２))
                    .set摘要７(摘要.substring(NUMBER_１９２, NUMBER_２２４))
                    .set摘要８(摘要.substring(NUMBER_２２４, NUMBER_２５６))
                    .set摘要９(摘要.substring(NUMBER_２５６, length))
                    .build();
        }
        if (length > NUMBER_２８８ && length <= NUMBER_３２０) {
            entityModified = entityModified.createBuilderForEdit()
                    .set摘要１(摘要.substring(NUMBER_０, NUMBER_３２))
                    .set摘要２(摘要.substring(NUMBER_３２, NUMBER_６４))
                    .set摘要３(摘要.substring(NUMBER_６４, NUMBER_９６))
                    .set摘要４(摘要.substring(NUMBER_９６, NUMBER_１２８))
                    .set摘要５(摘要.substring(NUMBER_１２８, NUMBER_１６０))
                    .set摘要６(摘要.substring(NUMBER_１６０, NUMBER_１９２))
                    .set摘要７(摘要.substring(NUMBER_１９２, NUMBER_２２４))
                    .set摘要８(摘要.substring(NUMBER_２２４, NUMBER_２５６))
                    .set摘要９(摘要.substring(NUMBER_２５６, NUMBER_２８８))
                    .set摘要１０(摘要.substring(NUMBER_２８８, length))
                    .build();
        }
        if (length > NUMBER_３２０ && length <= NUMBER_３５２) {
            entityModified = entityModified.createBuilderForEdit()
                    .set摘要１(摘要.substring(NUMBER_０, NUMBER_３２))
                    .set摘要２(摘要.substring(NUMBER_３２, NUMBER_６４))
                    .set摘要３(摘要.substring(NUMBER_６４, NUMBER_９６))
                    .set摘要４(摘要.substring(NUMBER_９６, NUMBER_１２８))
                    .set摘要５(摘要.substring(NUMBER_１２８, NUMBER_１６０))
                    .set摘要６(摘要.substring(NUMBER_１６０, NUMBER_１９２))
                    .set摘要７(摘要.substring(NUMBER_１９２, NUMBER_２２４))
                    .set摘要８(摘要.substring(NUMBER_２２４, NUMBER_２５６))
                    .set摘要９(摘要.substring(NUMBER_２５６, NUMBER_２８８))
                    .set摘要１０(摘要.substring(NUMBER_２８８, NUMBER_３２０))
                    .set摘要１１(摘要.substring(NUMBER_３２０, length))
                    .build();
        }
        if (length > NUMBER_３５２ && length <= NUMBER_３８４) {
            entityModified = entityModified.createBuilderForEdit()
                    .set摘要１(摘要.substring(NUMBER_０, NUMBER_３２))
                    .set摘要２(摘要.substring(NUMBER_３２, NUMBER_６４))
                    .set摘要３(摘要.substring(NUMBER_６４, NUMBER_９６))
                    .set摘要４(摘要.substring(NUMBER_９６, NUMBER_１２８))
                    .set摘要５(摘要.substring(NUMBER_１２８, NUMBER_１６０))
                    .set摘要６(摘要.substring(NUMBER_１６０, NUMBER_１９２))
                    .set摘要７(摘要.substring(NUMBER_１９２, NUMBER_２２４))
                    .set摘要８(摘要.substring(NUMBER_２２４, NUMBER_２５６))
                    .set摘要９(摘要.substring(NUMBER_２５６, NUMBER_２８８))
                    .set摘要１０(摘要.substring(NUMBER_２８８, NUMBER_３２０))
                    .set摘要１１(摘要.substring(NUMBER_３２０, NUMBER_３５２))
                    .set摘要１２(摘要.substring(NUMBER_３５２, length))
                    .build();
        }
        if (length > NUMBER_３８４ && length <= NUMBER_４１６) {
            entityModified = entityModified.createBuilderForEdit()
                    .set摘要１(摘要.substring(NUMBER_０, NUMBER_３２))
                    .set摘要２(摘要.substring(NUMBER_３２, NUMBER_６４))
                    .set摘要３(摘要.substring(NUMBER_６４, NUMBER_９６))
                    .set摘要４(摘要.substring(NUMBER_９６, NUMBER_１２８))
                    .set摘要５(摘要.substring(NUMBER_１２８, NUMBER_１６０))
                    .set摘要６(摘要.substring(NUMBER_１６０, NUMBER_１９２))
                    .set摘要７(摘要.substring(NUMBER_１９２, NUMBER_２２４))
                    .set摘要８(摘要.substring(NUMBER_２２４, NUMBER_２５６))
                    .set摘要９(摘要.substring(NUMBER_２５６, NUMBER_２８８))
                    .set摘要１０(摘要.substring(NUMBER_２８８, NUMBER_３２０))
                    .set摘要１１(摘要.substring(NUMBER_３２０, NUMBER_３５２))
                    .set摘要１２(摘要.substring(NUMBER_３５２, NUMBER_３８４))
                    .set摘要１３(摘要.substring(NUMBER_３８４, length))
                    .build();
        } else {
            entityModified = set摘要３(entityModified, 摘要, length);
        }
        return entityModified;
    }

    private ShokanTokuteiShinryohi set摘要３(ShokanTokuteiShinryohi entityModified, RString 摘要, int length) {
        if (length > NUMBER_４１６ && length <= NUMBER_４４８) {
            entityModified = entityModified.createBuilderForEdit()
                    .set摘要１(摘要.substring(NUMBER_０, NUMBER_３２))
                    .set摘要２(摘要.substring(NUMBER_３２, NUMBER_６４))
                    .set摘要３(摘要.substring(NUMBER_６４, NUMBER_９６))
                    .set摘要４(摘要.substring(NUMBER_９６, NUMBER_１２８))
                    .set摘要５(摘要.substring(NUMBER_１２８, NUMBER_１６０))
                    .set摘要６(摘要.substring(NUMBER_１６０, NUMBER_１９２))
                    .set摘要７(摘要.substring(NUMBER_１９２, NUMBER_２２４))
                    .set摘要８(摘要.substring(NUMBER_２２４, NUMBER_２５６))
                    .set摘要９(摘要.substring(NUMBER_２５６, NUMBER_２８８))
                    .set摘要１０(摘要.substring(NUMBER_２８８, NUMBER_３２０))
                    .set摘要１１(摘要.substring(NUMBER_３２０, NUMBER_３５２))
                    .set摘要１２(摘要.substring(NUMBER_３５２, NUMBER_３８４))
                    .set摘要１３(摘要.substring(NUMBER_３８４, NUMBER_４１６))
                    .set摘要１４(摘要.substring(NUMBER_４１６, length))
                    .build();
        }
        if (length > NUMBER_４４８ && length <= NUMBER_４８０) {
            entityModified = entityModified.createBuilderForEdit()
                    .set摘要１(摘要.substring(NUMBER_０, NUMBER_３２))
                    .set摘要２(摘要.substring(NUMBER_３２, NUMBER_６４))
                    .set摘要３(摘要.substring(NUMBER_６４, NUMBER_９６))
                    .set摘要４(摘要.substring(NUMBER_９６, NUMBER_１２８))
                    .set摘要５(摘要.substring(NUMBER_１２８, NUMBER_１６０))
                    .set摘要６(摘要.substring(NUMBER_１６０, NUMBER_１９２))
                    .set摘要７(摘要.substring(NUMBER_１９２, NUMBER_２２４))
                    .set摘要８(摘要.substring(NUMBER_２２４, NUMBER_２５６))
                    .set摘要９(摘要.substring(NUMBER_２５６, NUMBER_２８８))
                    .set摘要１０(摘要.substring(NUMBER_２８８, NUMBER_３２０))
                    .set摘要１１(摘要.substring(NUMBER_３２０, NUMBER_３５２))
                    .set摘要１２(摘要.substring(NUMBER_３５２, NUMBER_３８４))
                    .set摘要１３(摘要.substring(NUMBER_３８４, NUMBER_４１６))
                    .set摘要１４(摘要.substring(NUMBER_４１６, NUMBER_４４８))
                    .set摘要１５(摘要.substring(NUMBER_４４８, length))
                    .build();
        }
        if (length > NUMBER_４８０ && length <= NUMBER_５１２) {
            entityModified = entityModified.createBuilderForEdit()
                    .set摘要１(摘要.substring(NUMBER_０, NUMBER_３２))
                    .set摘要２(摘要.substring(NUMBER_３２, NUMBER_６４))
                    .set摘要３(摘要.substring(NUMBER_６４, NUMBER_９６))
                    .set摘要４(摘要.substring(NUMBER_９６, NUMBER_１２８))
                    .set摘要５(摘要.substring(NUMBER_１２８, NUMBER_１６０))
                    .set摘要６(摘要.substring(NUMBER_１６０, NUMBER_１９２))
                    .set摘要７(摘要.substring(NUMBER_１９２, NUMBER_２２４))
                    .set摘要８(摘要.substring(NUMBER_２２４, NUMBER_２５６))
                    .set摘要９(摘要.substring(NUMBER_２５６, NUMBER_２８８))
                    .set摘要１０(摘要.substring(NUMBER_２８８, NUMBER_３２０))
                    .set摘要１１(摘要.substring(NUMBER_３２０, NUMBER_３５２))
                    .set摘要１２(摘要.substring(NUMBER_３５２, NUMBER_３８４))
                    .set摘要１３(摘要.substring(NUMBER_３８４, NUMBER_４１６))
                    .set摘要１４(摘要.substring(NUMBER_４１６, NUMBER_４４８))
                    .set摘要１５(摘要.substring(NUMBER_４４８, NUMBER_４８０))
                    .set摘要１６(摘要.substring(NUMBER_４８０, length))
                    .build();
        }
        if (length > NUMBER_５１２ && length <= NUMBER_５４４) {
            entityModified = entityModified.createBuilderForEdit()
                    .set摘要１(摘要.substring(NUMBER_０, NUMBER_３２))
                    .set摘要２(摘要.substring(NUMBER_３２, NUMBER_６４))
                    .set摘要３(摘要.substring(NUMBER_６４, NUMBER_９６))
                    .set摘要４(摘要.substring(NUMBER_９６, NUMBER_１２８))
                    .set摘要５(摘要.substring(NUMBER_１２８, NUMBER_１６０))
                    .set摘要６(摘要.substring(NUMBER_１６０, NUMBER_１９２))
                    .set摘要７(摘要.substring(NUMBER_１９２, NUMBER_２２４))
                    .set摘要８(摘要.substring(NUMBER_２２４, NUMBER_２５６))
                    .set摘要９(摘要.substring(NUMBER_２５６, NUMBER_２８８))
                    .set摘要１０(摘要.substring(NUMBER_２８８, NUMBER_３２０))
                    .set摘要１１(摘要.substring(NUMBER_３２０, NUMBER_３５２))
                    .set摘要１２(摘要.substring(NUMBER_３５２, NUMBER_３８４))
                    .set摘要１３(摘要.substring(NUMBER_３８４, NUMBER_４１６))
                    .set摘要１４(摘要.substring(NUMBER_４１６, NUMBER_４４８))
                    .set摘要１５(摘要.substring(NUMBER_４４８, NUMBER_４８０))
                    .set摘要１６(摘要.substring(NUMBER_４８０, NUMBER_５１２))
                    .set摘要１７(摘要.substring(NUMBER_５１２, length))
                    .build();
        }
        if (length > NUMBER_５４４ && length <= NUMBER_５７６) {
            entityModified = entityModified.createBuilderForEdit()
                    .set摘要１(摘要.substring(NUMBER_０, NUMBER_３２))
                    .set摘要２(摘要.substring(NUMBER_３２, NUMBER_６４))
                    .set摘要３(摘要.substring(NUMBER_６４, NUMBER_９６))
                    .set摘要４(摘要.substring(NUMBER_９６, NUMBER_１２８))
                    .set摘要５(摘要.substring(NUMBER_１２８, NUMBER_１６０))
                    .set摘要６(摘要.substring(NUMBER_１６０, NUMBER_１９２))
                    .set摘要７(摘要.substring(NUMBER_１９２, NUMBER_２２４))
                    .set摘要８(摘要.substring(NUMBER_２２４, NUMBER_２５６))
                    .set摘要９(摘要.substring(NUMBER_２５６, NUMBER_２８８))
                    .set摘要１０(摘要.substring(NUMBER_２８８, NUMBER_３２０))
                    .set摘要１１(摘要.substring(NUMBER_３２０, NUMBER_３５２))
                    .set摘要１２(摘要.substring(NUMBER_３５２, NUMBER_３８４))
                    .set摘要１３(摘要.substring(NUMBER_３８４, NUMBER_４１６))
                    .set摘要１４(摘要.substring(NUMBER_４１６, NUMBER_４４８))
                    .set摘要１５(摘要.substring(NUMBER_４４８, NUMBER_４８０))
                    .set摘要１６(摘要.substring(NUMBER_４８０, NUMBER_５１２))
                    .set摘要１７(摘要.substring(NUMBER_５１２, NUMBER_５４４))
                    .set摘要１８(摘要.substring(NUMBER_５４４, length))
                    .build();
        }
        if (length > NUMBER_５７６ && length <= NUMBER_６０８) {
            entityModified = entityModified.createBuilderForEdit()
                    .set摘要１(摘要.substring(NUMBER_０, NUMBER_３２))
                    .set摘要２(摘要.substring(NUMBER_３２, NUMBER_６４))
                    .set摘要３(摘要.substring(NUMBER_６４, NUMBER_９６))
                    .set摘要４(摘要.substring(NUMBER_９６, NUMBER_１２８))
                    .set摘要５(摘要.substring(NUMBER_１２８, NUMBER_１６０))
                    .set摘要６(摘要.substring(NUMBER_１６０, NUMBER_１９２))
                    .set摘要７(摘要.substring(NUMBER_１９２, NUMBER_２２４))
                    .set摘要８(摘要.substring(NUMBER_２２４, NUMBER_２５６))
                    .set摘要９(摘要.substring(NUMBER_２５６, NUMBER_２８８))
                    .set摘要１０(摘要.substring(NUMBER_２８８, NUMBER_３２０))
                    .set摘要１１(摘要.substring(NUMBER_３２０, NUMBER_３５２))
                    .set摘要１２(摘要.substring(NUMBER_３５２, NUMBER_３８４))
                    .set摘要１３(摘要.substring(NUMBER_３８４, NUMBER_４１６))
                    .set摘要１４(摘要.substring(NUMBER_４１６, NUMBER_４４８))
                    .set摘要１５(摘要.substring(NUMBER_４４８, NUMBER_４８０))
                    .set摘要１６(摘要.substring(NUMBER_４８０, NUMBER_５１２))
                    .set摘要１７(摘要.substring(NUMBER_５１２, NUMBER_５４４))
                    .set摘要１８(摘要.substring(NUMBER_５４４, NUMBER_５７６))
                    .set摘要１９(摘要.substring(NUMBER_５７６, length))
                    .build();
        }
        if (length > NUMBER_６０８) {
            entityModified = entityModified.createBuilderForEdit()
                    .set摘要１(摘要.substring(NUMBER_０, NUMBER_３２))
                    .set摘要２(摘要.substring(NUMBER_３２, NUMBER_６４))
                    .set摘要３(摘要.substring(NUMBER_６４, NUMBER_９６))
                    .set摘要４(摘要.substring(NUMBER_９６, NUMBER_１２８))
                    .set摘要５(摘要.substring(NUMBER_１２８, NUMBER_１６０))
                    .set摘要６(摘要.substring(NUMBER_１６０, NUMBER_１９２))
                    .set摘要７(摘要.substring(NUMBER_１９２, NUMBER_２２４))
                    .set摘要８(摘要.substring(NUMBER_２２４, NUMBER_２５６))
                    .set摘要９(摘要.substring(NUMBER_２５６, NUMBER_２８８))
                    .set摘要１０(摘要.substring(NUMBER_２８８, NUMBER_３２０))
                    .set摘要１１(摘要.substring(NUMBER_３２０, NUMBER_３５２))
                    .set摘要１２(摘要.substring(NUMBER_３５２, NUMBER_３８４))
                    .set摘要１３(摘要.substring(NUMBER_３８４, NUMBER_４１６))
                    .set摘要１４(摘要.substring(NUMBER_４１６, NUMBER_４４８))
                    .set摘要１５(摘要.substring(NUMBER_４４８, NUMBER_４８０))
                    .set摘要１６(摘要.substring(NUMBER_４８０, NUMBER_５１２))
                    .set摘要１７(摘要.substring(NUMBER_５１２, NUMBER_５４４))
                    .set摘要１８(摘要.substring(NUMBER_５４４, NUMBER_５７６))
                    .set摘要１９(摘要.substring(NUMBER_５７６, NUMBER_６０８))
                    .set摘要２０(摘要.substring(NUMBER_６０８, length))
                    .build();
        }
        return entityModified;
    }

    /**
     * パラメータ設定
     */
    public void putViewState() {
        ViewStateHolder.put(ViewStateKeys.処理モード, ViewStateHolder.get(ViewStateKeys.処理モード, RString.class));
        ViewStateHolder.put(ViewStateKeys.申請日, div.getPanelTwo().getTxtShinseiYMD().getValue());
        SyokanbaraihishikyushinseiketteParameter paramter = new SyokanbaraihishikyushinseiketteParameter(
                ViewStateHolder.get(ViewStateKeys.被保険者番号, HihokenshaNo.class),
                ViewStateHolder.get(ViewStateKeys.サービス年月, FlexibleYearMonth.class),
                ViewStateHolder.get(ViewStateKeys.整理番号, RString.class),
                new JigyoshaNo(div.getPanelTwo().getTxtJigyoshaBango().getValue()),
                div.getPanelTwo().getTxtShomeisho().getValue(),
                div.getPanelTwo().getTxtMeisaibango().getValue(),
                null);
        ViewStateHolder.put(ViewStateKeys.償還払費申請検索キー, paramter);
    }
}
