/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.dbc0820023;

import java.util.ArrayList;
import java.util.List;
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
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.binding.RowState;
import jp.co.ndensan.reams.uz.uza.ui.binding.propertyenum.IconName;
import jp.co.ndensan.reams.uz.uza.ui.servlets.CommonButtonHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
import jp.co.ndensan.reams.uz.uza.util.code.CodeMaster;
import jp.co.ndensan.reams.uz.uza.util.code.entity.UzT0007CodeEntity;
import jp.co.ndensan.reams.uz.uza.util.editor.DecimalFormatter;

/**
 *
 * @author wangkanglei
 */
public class TokuteiShinryohiPanelHandler {

    private final TokuteiShinryohiPanelDiv div;
    private static final RString 設定不可 = new RString("0");
    private static final RString 設定可必須 = new RString("1");
    private static final RString 設定可任意 = new RString("2");
    private static final RString 修正 = new RString("修正");
    private static final RString 削除 = new RString("削除");
    private static final RString 登録 = new RString("登録");
    private static final RString 登録_削除 = new RString("登録_削除");
    private static final RString 単位 = new RString("単位");
    private static final RString 回まで = new RString("回まで");
    private static final RString 改行 = new RString("\n");
    private static final FlexibleYearMonth 平成１５年３月 = new FlexibleYearMonth("200303");
    private static final FlexibleYearMonth 平成１５年４月 = new FlexibleYearMonth("200304");
    private static final RString 申請を保存する = new RString("Element3");

    public TokuteiShinryohiPanelHandler(TokuteiShinryohiPanelDiv div) {
        this.div = div;
    }

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

    public void getボタンを制御(ShikibetsuNoKanri shikibetsuNoKanri) {

        SyokanbaraihishikyushinseiketteParameter paramter = ViewStateHolder.get(ViewStateKeys.償還払費申請検索キー,
                SyokanbaraihishikyushinseiketteParameter.class);
        HihokenshaNo 被保険者番号 = paramter.getHiHokenshaNo();
        FlexibleYearMonth サービス年月 = paramter.getServiceTeikyoYM();
        RString 整理番号 = paramter.getSeiriNp();
        JigyoshaNo 事業者番号 = paramter.getJigyoshaNo();
        RString 様式番号 = paramter.getYoshikiNo();
        RString 明細番号 = paramter.getMeisaiNo();
        // 基本情報
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
        // 給付費明細
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
        // 特定診療費
        div.getPanelTwo().getBtnTokuteiShiryohi().setDisabled(true);
//        if (設定不可.equals(entity.getTokuteiShinryoSetteiKubun())) {
//            div.getPanelTwo().getBtnTokuteiShiryohi().setDisabled(true);
//        } else if (設定可必須.equals(entity.getTokuteiShinryoSetteiKubun())) {
//            int count3 = SyokanbaraihiShikyuShinseiKetteManager.createInstance().updShokanTokuteiShinryohi(被保険者番号,
//                    サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号);
//            if (count3 == 1) {
//                div.getPanelTwo().getBtnTokuteiShiryohi().setIconNameEnum(IconName.Incomplete);
//            } else {
//                div.getPanelTwo().getBtnTokuteiShiryohi().setIconNameEnum(IconName.Complete);
//            }
//        } else if (設定可任意.equals(entity.getTokuteiShinryoSetteiKubun())) {
//            div.getPanelTwo().getBtnTokuteiShiryohi().setIconNameEnum(IconName.NONE);
//        }
        // サービス計画費
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
        // 特定入所者費用
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
        // 合計情報
        div.getPanelTwo().getBtnGokeiinfo().setDisabled(false);
        // 給付費明細（住特）
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
        // 緊急時・所定疾患
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
        // 緊急時施設療養費
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
        // 食事費用
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
        // 請求額集計
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
        // 社福軽減額
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

    public void set特定診療費一覧グリッド(List<ShokanTokuteiShinryohi> shokanTokuteiShinryohiList) {
        List<ddgToteishinryoTokubetushinryo_Row> dataSource = new ArrayList<>();
        for (ShokanTokuteiShinryohi entity : shokanTokuteiShinryohiList) {
            ddgToteishinryoTokubetushinryo_Row row = new ddgToteishinryoTokubetushinryo_Row();
            row.setShobyouName(entity.get傷病名());
            row.setShidouKanri(DecimalFormatter.toコンマ区切りRString(new Decimal(entity.get指導管理料等単位数()), 0));
            row.setRihabiri(DecimalFormatter.toコンマ区切りRString(new Decimal(entity.getリハビリテーション単位数()), 0));
            row.setSeishinka(DecimalFormatter.toコンマ区切りRString(new Decimal(entity.get精神科専門療法単位数()), 0));
            row.setXLine(DecimalFormatter.toコンマ区切りRString(new Decimal(entity.get単純エックス線単位数()), 0));
            row.setSochi(DecimalFormatter.toコンマ区切りRString(new Decimal(entity.get措置単位数()), 0));
            row.setTejyutsu(DecimalFormatter.toコンマ区切りRString(new Decimal(entity.get手術単位数()), 0));
            row.setGoukeyiTanyi(DecimalFormatter.toコンマ区切りRString(new Decimal(entity.get合計単位数()), 0));
            RStringBuilder builder = new RStringBuilder();
            builder.append(entity.get摘要１()).append(改行);
            builder.append(entity.get摘要２()).append(改行);
            builder.append(entity.get摘要３()).append(改行);
            builder.append(entity.get摘要４()).append(改行);
            builder.append(entity.get摘要５()).append(改行);
            builder.append(entity.get摘要６()).append(改行);
            builder.append(entity.get摘要７()).append(改行);
            builder.append(entity.get摘要８()).append(改行);
            builder.append(entity.get摘要９()).append(改行);
            builder.append(entity.get摘要１０()).append(改行);
            builder.append(entity.get摘要１１()).append(改行);
            builder.append(entity.get摘要１２()).append(改行);
            builder.append(entity.get摘要１３()).append(改行);
            builder.append(entity.get摘要１４()).append(改行);
            builder.append(entity.get摘要１５()).append(改行);
            builder.append(entity.get摘要１６()).append(改行);
            builder.append(entity.get摘要１７()).append(改行);
            builder.append(entity.get摘要１８()).append(改行);
            builder.append(entity.get摘要１９()).append(改行);
            builder.append(entity.get摘要２０());
            row.setMutiTekiyo(builder.toRString());
            row.setNumber(entity.get連番());
            dataSource.add(row);
        }
        div.getDdgToteishinryoTokubetushinryo().setDataSource(dataSource);
    }

    public void set特定診療費登録(ddgToteishinryoTokubetushinryo_Row row) {
        div.getTxtShobyoMei().setValue(row.getShobyouName());
        div.getTxtShidouKanri().setValue(new Decimal(row.getShidouKanri().toString()));
        div.getTxtRibabiriteishon().setValue(new Decimal(row.getRihabiri().toString()));
        div.getTxtSeishinkaSenmon().setValue(new Decimal(row.getSeishinka().toString()));
        div.getTxtTanjyunXline().setValue(new Decimal(row.getXLine().toString()));
        div.getTxtSochi().setValue(new Decimal(row.getSochi().toString()));
        div.getTxtTejyutsu().setValue(new Decimal(row.getTejyutsu().toString()));
        div.getTxtGoukei().setValue(new Decimal(row.getGoukeyiTanyi().toString()));
        div.getTxtMutiTekiyo().setValue(row.getMutiTekiyo());
        div.getRowId().setValue(new RString(String.valueOf(row.getId())));
    }

    public void click計算結果() {
        Decimal data = div.getTxtShidouKanri().getValue()
                .add(div.getTxtRibabiriteishon().getValue())
                .add(div.getTxtSeishinkaSenmon().getValue())
                .add(div.getTxtTanjyunXline().getValue())
                .add(div.getTxtSochi().getValue())
                .add(div.getTxtTejyutsu().getValue());
        div.getTxtGoukei().setValue(data);
    }

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

    public ddgToteishinryoTokubetushinryo_Row getSelectedRow() {
        return div.getDdgToteishinryoTokubetushinryo().getDataSource().get(Integer.parseInt(
                div.getRowId().getValue().toString()));
    }

    public void modifyRow(ddgToteishinryoTokubetushinryo_Row ddgRow) {
        RString state = ViewStateHolder.get(ViewStateKeys.状態, RString.class);
        if (修正.equals(state)) {
            ddgRow.setRowState(RowState.Modified);
            setDdgToteishinryoTokubetushinryo_Row(ddgRow);
            CommonButtonHolder.setDisabledByCommonButtonFieldName(申請を保存する, false);
        } else if (削除.equals(state)) {
            ddgRow.setRowState(RowState.Deleted);
            setDdgToteishinryoTokubetushinryo_Row(ddgRow);
            CommonButtonHolder.setDisabledByCommonButtonFieldName(申請を保存する, false);
        } else if (登録.equals(state)) {
            ddgRow.setRowState(RowState.Added);
            setDdgToteishinryoTokubetushinryo_Row(ddgRow);
            CommonButtonHolder.setDisabledByCommonButtonFieldName(申請を保存する, false);
        } else if (登録_削除.equals(state)) {
            div.getDdgToteishinryoTokubetushinryo().getDataSource().remove(Integer.parseInt(
                    div.getRowId().getValue().toString()));
        }
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
            ddgRow.setXLine(DecimalFormatter.toコンマ区切りRString(div.getTxtTanjyunXline().getValue(), 0));
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
        clear特定診療費登録();
        div.getPanelFour().setVisible(false);
    }

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

    public void set特定診療費_特別診療費登録(dgdTokuteiShinryohi_Row row) {
        TokuteiShinryoServiceCode serviceCode = ShokanbaraiJyokyoShokai.createInstance()
                .getTokuteiShinryoServiceCodeInfo(
                        new ShikibetsuCode(row.getDefaultDataName2()),
                        ViewStateHolder.get(ViewStateKeys.サービス年月, FlexibleYearMonth.class),
                        ViewStateHolder.get(ViewStateKeys.様式番号, RString.class));
        div.getTxtShobyoMeiDown().setValue(row.getDefaultDataName1());
        div.getTxtShikibetsuCode().setValue(row.getDefaultDataName2());
        if (serviceCode != null) {
            div.getTxtName().setValue(serviceCode.toEntity().getServiceMeisho());
            div.getTxtTanyi().setValue(new RString(serviceCode.toEntity().getTaniSu().toString()));
            UzT0007CodeEntity code1 = CodeMaster.getCode(SubGyomuCode.DBC介護給付, new CodeShubetsu(new RString("0025")),
                    new Code(serviceCode.toEntity().getSanteiTani()));
            RStringBuilder builder1 = new RStringBuilder();
            builder1.append(code1.getコード名称());
            builder1.append(serviceCode.toEntity().getTaniSu());
            builder1.append(単位);
            div.getLblComment1().setText(builder1.toRString());
            UzT0007CodeEntity code2 = CodeMaster.getCode(SubGyomuCode.DBC介護給付, new CodeShubetsu(new RString("0026")),
                    new Code(serviceCode.toEntity().getSanteiSeiyakuKikan()));
            RStringBuilder builder2 = new RStringBuilder();
            builder2.append(code2.getコード名称());
            builder2.append(serviceCode.toEntity().getSanteiSeiyakuKaisu());
            builder2.append(回まで);
            div.getLblComment2().setText(builder2.toRString());
        }
        div.getTxtKaiyisuNisu().setValue(new Decimal(row.getDefaultDataName4().toString()));
        div.getTxtGoukeiTanyi().setValue(new Decimal(row.getDefaultDataName5().toString()));
        div.getTxtTekiyoDown().setValue(row.getDefaultDataName6());
        div.getRowId().setValue(new RString(String.valueOf(row.getId())));
    }

    public void click計算結果2() {
        Decimal data = null;
        if (!div.getTxtTanyi().getValue().isEmpty()) {
            data = new Decimal(div.getTxtTanyi().getValue().toString())
                    .multiply(div.getTxtKaiyisuNisu().getValue());
        }
        div.getPanelFive().getTxtGoukeiTanyi().setValue(data);
    }

    public void clear特定診療費_特別診療費登録() {
        div.getTxtShobyoMeiDown().clearValue();
        div.getTxtShikibetsuCode().clearValue();
        div.getTxtName().clearValue();
        div.getLblComment1().setText(new RString("コメント１"));
        div.getLblComment2().setText(new RString("コメント2"));
        div.getTxtTanyi().clearValue();
        div.getTxtKaiyisuNisu().clearValue();
        div.getTxtGoukeiTanyi().clearValue();
        div.getTxtTekiyoDown().clearValue();
    }

    public dgdTokuteiShinryohi_Row getSelectedRow2() {
        return div.getDgdTokuteiShinryohi().getDataSource().get(Integer.parseInt(div.getRowId().getValue().toString()));
    }

    public void modifyRow2(dgdTokuteiShinryohi_Row row) {
        RString state = ViewStateHolder.get(ViewStateKeys.状態, RString.class);
        if (修正.equals(state)) {
            row.setRowState(RowState.Modified);
            setDgdTokuteiShinryohi_Row(row);
            CommonButtonHolder.setDisabledByCommonButtonFieldName(申請を保存する, false);
        } else if (削除.equals(state)) {
            row.setRowState(RowState.Deleted);
            setDgdTokuteiShinryohi_Row(row);
            CommonButtonHolder.setDisabledByCommonButtonFieldName(申請を保存する, false);
        } else if (登録.equals(state)) {
            row.setRowState(RowState.Added);
            setDgdTokuteiShinryohi_Row(row);
            CommonButtonHolder.setDisabledByCommonButtonFieldName(申請を保存する, false);
        } else if (登録_削除.equals(state)) {
            div.getDgdTokuteiShinryohi().getDataSource().remove(Integer.parseInt(
                    div.getRowId().getValue().toString()));
        }
    }

    private void setDgdTokuteiShinryohi_Row(dgdTokuteiShinryohi_Row row) {
        row.setDefaultDataName1(div.getTxtShobyoMeiDown().getValue());
        row.setDefaultDataName2(div.getTxtShikibetsuCode().getValue());
        if (!div.getTxtTanyi().getValue().isEmpty()) {
            row.setDefaultDataName3(DecimalFormatter.toコンマ区切りRString(new Decimal(div.getTxtTanyi().getValue().toString()), 0));
        }
        if (div.getTxtKaiyisuNisu().getValue() != null) {
            row.setDefaultDataName4(DecimalFormatter.toコンマ区切りRString(div.getTxtKaiyisuNisu().getValue(), 0));
        }
        if (div.getTxtGoukeiTanyi().getValue() != null) {
            row.setDefaultDataName5(DecimalFormatter.toコンマ区切りRString(div.getTxtGoukeiTanyi().getValue(), 0));
        }
        row.setDefaultDataName6(div.getTxtTekiyoDown().getValue());
        clear特定診療費_特別診療費登録();
        div.getPanelFive().setVisible(false);
    }

    public boolean get内容変更状態(FlexibleYearMonth サービス年月) {
        if (サービス年月.isBeforeOrEquals(平成１５年３月)) {
            for (ddgToteishinryoTokubetushinryo_Row ddgList : div.getDdgToteishinryoTokubetushinryo().getDataSource()) {
                if (RowState.Modified.equals(ddgList.getRowState())
                        || RowState.Added.equals(ddgList.getRowState())
                        || RowState.Deleted.equals(ddgList.getRowState())) {
                    return true;
                }
            }
        }
        if (平成１５年４月.isBeforeOrEquals(サービス年月)) {
            for (dgdTokuteiShinryohi_Row dgdRow : div.getDgdTokuteiShinryohi().getDataSource()) {
                if (RowState.Modified.equals(dgdRow.getRowState())
                        || RowState.Added.equals(dgdRow.getRowState())
                        || RowState.Deleted.equals(dgdRow.getRowState())) {
                    return true;
                }
            }
        }
        return false;
    }

    public void 保存処理() {
        SyokanbaraihishikyushinseiketteParameter paramter = ViewStateHolder.get(ViewStateKeys.償還払費申請検索キー,
                SyokanbaraihishikyushinseiketteParameter.class);
        HihokenshaNo 被保険者番号 = paramter.getHiHokenshaNo();
        FlexibleYearMonth サービス年月 = paramter.getServiceTeikyoYM();
        RString 整理番号 = paramter.getSeiriNp();
        JigyoshaNo 事業者番号 = paramter.getJigyoshaNo();
        RString 様式番号 = paramter.getYoshikiNo();
        RString 明細番号 = paramter.getMeisaiNo();
        List<ShokanTokuteiShinryohi> entityList1 = new ArrayList<>();
        List<ShokanTokuteiShinryoTokubetsuRyoyo> entityList2 = new ArrayList<>();
        ShokanKihonParameter parameter = ShokanKihonParameter.createSelectByKeyParam(
                被保険者番号, サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号, 0);
        if (削除.equals(ViewStateHolder.get(ViewStateKeys.処理モード, RString.class))) {
            SyokanbaraihiShikyuShinseiKetteManager.createInstance().delShokanSyomeisyo(被保険者番号,
                    サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号);
        } else {
            if (サービス年月.isBeforeOrEquals(平成１５年３月)) {
                int max連番 = SyokanbaraihiShikyuShinseiKetteManager.createInstance().DbT3041Max連番(
                        被保険者番号, サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号);
                List<ShokanTokuteiShinryohi> shokanTokuteiShinryohiList = ViewStateHolder.get(
                        ViewStateKeys.償還払請求特定診療費データ, List.class);
                for (ddgToteishinryoTokubetushinryo_Row ddg : div.getDdgToteishinryoTokubetushinryo().getDataSource()) {
                    if (RowState.Modified.equals(ddg.getRowState())) {
                        for (ShokanTokuteiShinryohi entityModified : shokanTokuteiShinryohiList) {
                            if (!entityModified.get連番().isEmpty() && entityModified.get連番().equals(ddg.getNumber())) {
                                entityModified = entityModified.createBuilderForEdit()
                                        .set傷病名(ddg.getShobyouName())
                                        .set指導管理料等単位数(Integer.parseInt(ddg.getShidouKanri().toString()))
                                        .set単純エックス線単位数(Integer.parseInt(ddg.getXLine().toString()))
                                        .setリハビリテーション単位数(Integer.parseInt(ddg.getRihabiri().toString()))
                                        .set精神科専門療法単位数(Integer.parseInt(ddg.getSeishinka().toString()))
                                        .set措置単位数(Integer.parseInt(ddg.getSochi().toString()))
                                        .set手術単位数(Integer.parseInt(ddg.getTejyutsu().toString()))
                                        .set合計単位数(Integer.parseInt(ddg.getGoukeyiTanyi().toString()))
                                        .build();
                                RString 摘要 = ddg.getMutiTekiyo();
                                if (!摘要.isEmpty()) {
                                    entityModified = build摘要(entityModified, 摘要);
                                }
                                entityList1.add(entityModified);
                            }
                        }
                    } else if (RowState.Deleted.equals(ddg.getRowState())) {
                        for (ShokanTokuteiShinryohi entityDeleted : shokanTokuteiShinryohiList) {
                            if (!entityDeleted.get連番().isEmpty() && entityDeleted.get連番().equals(ddg.getNumber())) {
                                entityDeleted = entityDeleted.deleted();
                                entityList1.add(entityDeleted);
                            }
                        }
                    } else if (RowState.Added.equals(ddg.getRowState())) {
                        max連番 = max連番 + 1;
                        ShokanTokuteiShinryohi shokanTokuteiShinryohinew = new ShokanTokuteiShinryohi(
                                被保険者番号,
                                サービス年月,
                                整理番号,
                                事業者番号,
                                様式番号,
                                明細番号,
                                new RString(String.valueOf(max連番))).createBuilderForEdit()
                                .set傷病名(ddg.getShobyouName())
                                .set指導管理料等単位数(Integer.parseInt(ddg.getShidouKanri().toString()))
                                .set単純エックス線単位数(Integer.parseInt(ddg.getXLine().toString()))
                                .setリハビリテーション単位数(Integer.parseInt(ddg.getRihabiri().toString()))
                                .set精神科専門療法単位数(Integer.parseInt(ddg.getSeishinka().toString()))
                                .set措置単位数(Integer.parseInt(ddg.getSochi().toString()))
                                .set手術単位数(Integer.parseInt(ddg.getTejyutsu().toString()))
                                .set合計単位数(Integer.parseInt(ddg.getGoukeyiTanyi().toString()))
                                .build();
                        RString 摘要 = ddg.getMutiTekiyo();
                        if (!摘要.isEmpty()) {
                            shokanTokuteiShinryohinew = build摘要(shokanTokuteiShinryohinew, 摘要);
                        }
                        entityList1.add(shokanTokuteiShinryohinew);
                    } else {
                        for (ShokanTokuteiShinryohi entityUnchanged : shokanTokuteiShinryohiList) {
                            if (!entityUnchanged.get連番().isEmpty() && entityUnchanged.get連番().equals(ddg.getNumber())) {
                                entityList1.add(entityUnchanged);
                            }
                        }
                    }
                }
            } else if (平成１５年４月.isBeforeOrEquals(サービス年月)) {
                int max連番 = SyokanbaraihiShikyuShinseiKetteManager.createInstance().DbT3042Max連番(
                        被保険者番号, サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号);
                List<ShokanTokuteiShinryoTokubetsuRyoyo> shokanTokuteiShinryoTokubetsuRyoyoList = ViewStateHolder.get(
                        ViewStateKeys.償還払請求特定診療費_特別療養費一覧, List.class);
                for (dgdTokuteiShinryohi_Row dgdRow : div.getDgdTokuteiShinryohi().getDataSource()) {
                    if (RowState.Modified.equals(dgdRow.getRowState())) {
                        for (ShokanTokuteiShinryoTokubetsuRyoyo entityModified : shokanTokuteiShinryoTokubetsuRyoyoList) {
                            if (!dgdRow.getDefaultDataName7().isEmpty() && entityModified.get連番().equals(dgdRow.getDefaultDataName7())) {
                                entityModified = entityModified.createBuilderForEdit()
                                        .set傷病名(dgdRow.getDefaultDataName1())
                                        .set識別番号(dgdRow.getDefaultDataName2())
                                        .set単位数(Integer.parseInt(dgdRow.getDefaultDataName3().toString()))
                                        .set回数(Integer.parseInt(dgdRow.getDefaultDataName4().toString()))
                                        .set合計単位数(Integer.parseInt(dgdRow.getDefaultDataName5().toString()))
                                        .set摘要(dgdRow.getDefaultDataName6()).build();
                                entityList2.add(entityModified);
                            }
                        }
                    } else if (RowState.Deleted.equals(dgdRow.getRowState())) {
                        for (ShokanTokuteiShinryoTokubetsuRyoyo entityDeleted : shokanTokuteiShinryoTokubetsuRyoyoList) {
                            if (!dgdRow.getDefaultDataName7().isEmpty() && entityDeleted.get連番().equals(dgdRow.getDefaultDataName7())) {
                                entityDeleted = entityDeleted.deleted();
                                entityList2.add(entityDeleted);
                            }
                        }
                    } else if (RowState.Added.equals(dgdRow.getRowState())) {
                        max連番 = max連番 + 1;
                        ShokanTokuteiShinryoTokubetsuRyoyo shokanTokuteiShinryoTokubetsuRyoyo = new ShokanTokuteiShinryoTokubetsuRyoyo(
                                被保険者番号,
                                サービス年月,
                                整理番号,
                                事業者番号,
                                様式番号,
                                明細番号,
                                new RString(String.valueOf(max連番))).createBuilderForEdit()
                                .set傷病名(dgdRow.getDefaultDataName1())
                                .set識別番号(dgdRow.getDefaultDataName2())
                                .set単位数(Integer.parseInt(dgdRow.getDefaultDataName3().toString()))
                                .set回数(Integer.parseInt(dgdRow.getDefaultDataName4().toString()))
                                .set合計単位数(Integer.parseInt(dgdRow.getDefaultDataName5().toString()))
                                .set摘要(dgdRow.getDefaultDataName6())
                                .build();
                        entityList2.add(shokanTokuteiShinryoTokubetsuRyoyo);
                    } else {
                        for (ShokanTokuteiShinryoTokubetsuRyoyo entityUnchanged : shokanTokuteiShinryoTokubetsuRyoyoList) {
                            if (!dgdRow.getDefaultDataName7().isEmpty() && entityUnchanged.get連番().equals(dgdRow.getDefaultDataName7())) {
                                entityList2.add(entityUnchanged);
                            }
                        }
                    }
                }
            }
            SyokanbaraihiShikyuShinseiKetteManager.createInstance().updShokanTokuteiShinryohi(entityList1,
                    entityList2, parameter);
        }

    }

    private ShokanTokuteiShinryohi build摘要(ShokanTokuteiShinryohi entityModified, RString 摘要) {
        int length = 摘要.length();
        if (length <= 32) {
            entityModified = entityModified.createBuilderForEdit()
                    .set摘要１(摘要)
                    .build();
        }
        if (length > 32 && length <= 64) {
            entityModified = entityModified.createBuilderForEdit()
                    .set摘要１(摘要.substring(0, 32))
                    .set摘要２(摘要.substring(32, length))
                    .build();
        }
        if (length > 64 && length <= 96) {
            entityModified = entityModified.createBuilderForEdit()
                    .set摘要１(摘要.substring(0, 32))
                    .set摘要２(摘要.substring(32, 64))
                    .set摘要３(摘要.substring(64, length))
                    .build();
        }
        if (length > 96 && length <= 128) {
            entityModified = entityModified.createBuilderForEdit()
                    .set摘要１(摘要.substring(0, 32))
                    .set摘要２(摘要.substring(32, 64))
                    .set摘要３(摘要.substring(64, 96))
                    .set摘要４(摘要.substring(96, length))
                    .build();
        }
        if (length > 128 && length <= 160) {
            entityModified = entityModified.createBuilderForEdit()
                    .set摘要１(摘要.substring(0, 32))
                    .set摘要２(摘要.substring(32, 64))
                    .set摘要３(摘要.substring(64, 96))
                    .set摘要４(摘要.substring(96, 128))
                    .set摘要５(摘要.substring(128, length))
                    .build();
        }
        if (length > 160 && length <= 192) {
            entityModified = entityModified.createBuilderForEdit()
                    .set摘要１(摘要.substring(0, 32))
                    .set摘要２(摘要.substring(32, 64))
                    .set摘要３(摘要.substring(64, 96))
                    .set摘要４(摘要.substring(96, 128))
                    .set摘要５(摘要.substring(128, 160))
                    .set摘要６(摘要.substring(160, length))
                    .build();
        }
        if (length > 192 && length <= 224) {
            entityModified = entityModified.createBuilderForEdit()
                    .set摘要１(摘要.substring(0, 32))
                    .set摘要２(摘要.substring(32, 64))
                    .set摘要３(摘要.substring(64, 96))
                    .set摘要４(摘要.substring(96, 128))
                    .set摘要５(摘要.substring(128, 160))
                    .set摘要６(摘要.substring(160, 192))
                    .set摘要７(摘要.substring(192, length))
                    .build();
        }
        if (length > 224 && length <= 256) {
            entityModified = entityModified.createBuilderForEdit()
                    .set摘要１(摘要.substring(0, 32))
                    .set摘要２(摘要.substring(32, 64))
                    .set摘要３(摘要.substring(64, 96))
                    .set摘要４(摘要.substring(96, 128))
                    .set摘要５(摘要.substring(128, 160))
                    .set摘要６(摘要.substring(160, 192))
                    .set摘要７(摘要.substring(192, 224))
                    .set摘要８(摘要.substring(224, length))
                    .build();
        }
        if (length > 256 && length <= 288) {
            entityModified = entityModified.createBuilderForEdit()
                    .set摘要１(摘要.substring(0, 32))
                    .set摘要２(摘要.substring(32, 64))
                    .set摘要３(摘要.substring(64, 96))
                    .set摘要４(摘要.substring(96, 128))
                    .set摘要５(摘要.substring(128, 160))
                    .set摘要６(摘要.substring(160, 192))
                    .set摘要７(摘要.substring(192, 224))
                    .set摘要８(摘要.substring(224, 256))
                    .set摘要９(摘要.substring(256, length))
                    .build();
        }
        if (length > 288 && length <= 320) {
            entityModified = entityModified.createBuilderForEdit()
                    .set摘要１(摘要.substring(0, 32))
                    .set摘要２(摘要.substring(32, 64))
                    .set摘要３(摘要.substring(64, 96))
                    .set摘要４(摘要.substring(96, 128))
                    .set摘要５(摘要.substring(128, 160))
                    .set摘要６(摘要.substring(160, 192))
                    .set摘要７(摘要.substring(192, 224))
                    .set摘要８(摘要.substring(224, 256))
                    .set摘要９(摘要.substring(256, 288))
                    .set摘要１０(摘要.substring(288, length))
                    .build();
        }
        if (length > 320 && length <= 352) {
            entityModified = entityModified.createBuilderForEdit()
                    .set摘要１(摘要.substring(0, 32))
                    .set摘要２(摘要.substring(32, 64))
                    .set摘要３(摘要.substring(64, 96))
                    .set摘要４(摘要.substring(96, 128))
                    .set摘要５(摘要.substring(128, 160))
                    .set摘要６(摘要.substring(160, 192))
                    .set摘要７(摘要.substring(192, 224))
                    .set摘要８(摘要.substring(224, 256))
                    .set摘要９(摘要.substring(256, 288))
                    .set摘要１０(摘要.substring(288, 320))
                    .set摘要１１(摘要.substring(320, length))
                    .build();
        }
        if (length > 352 && length <= 384) {
            entityModified = entityModified.createBuilderForEdit()
                    .set摘要１(摘要.substring(0, 32))
                    .set摘要２(摘要.substring(32, 64))
                    .set摘要３(摘要.substring(64, 96))
                    .set摘要４(摘要.substring(96, 128))
                    .set摘要５(摘要.substring(128, 160))
                    .set摘要６(摘要.substring(160, 192))
                    .set摘要７(摘要.substring(192, 224))
                    .set摘要８(摘要.substring(224, 256))
                    .set摘要９(摘要.substring(256, 288))
                    .set摘要１０(摘要.substring(288, 320))
                    .set摘要１１(摘要.substring(320, 352))
                    .set摘要１２(摘要.substring(352, length))
                    .build();
        }
        if (length > 384 && length <= 416) {
            entityModified = entityModified.createBuilderForEdit()
                    .set摘要１(摘要.substring(0, 32))
                    .set摘要２(摘要.substring(32, 64))
                    .set摘要３(摘要.substring(64, 96))
                    .set摘要４(摘要.substring(96, 128))
                    .set摘要５(摘要.substring(128, 160))
                    .set摘要６(摘要.substring(160, 192))
                    .set摘要７(摘要.substring(192, 224))
                    .set摘要８(摘要.substring(224, 256))
                    .set摘要９(摘要.substring(256, 288))
                    .set摘要１０(摘要.substring(288, 320))
                    .set摘要１１(摘要.substring(320, 352))
                    .set摘要１２(摘要.substring(352, 384))
                    .set摘要１３(摘要.substring(384, length))
                    .build();
        }
        if (length > 416 && length <= 448) {
            entityModified = entityModified.createBuilderForEdit()
                    .set摘要１(摘要.substring(0, 32))
                    .set摘要２(摘要.substring(32, 64))
                    .set摘要３(摘要.substring(64, 96))
                    .set摘要４(摘要.substring(96, 128))
                    .set摘要５(摘要.substring(128, 160))
                    .set摘要６(摘要.substring(160, 192))
                    .set摘要７(摘要.substring(192, 224))
                    .set摘要８(摘要.substring(224, 256))
                    .set摘要９(摘要.substring(256, 288))
                    .set摘要１０(摘要.substring(288, 320))
                    .set摘要１１(摘要.substring(320, 352))
                    .set摘要１２(摘要.substring(352, 384))
                    .set摘要１３(摘要.substring(384, 416))
                    .set摘要１４(摘要.substring(416, length))
                    .build();
        }
        if (length > 448 && length <= 480) {
            entityModified = entityModified.createBuilderForEdit()
                    .set摘要１(摘要.substring(0, 32))
                    .set摘要２(摘要.substring(32, 64))
                    .set摘要３(摘要.substring(64, 96))
                    .set摘要４(摘要.substring(96, 128))
                    .set摘要５(摘要.substring(128, 160))
                    .set摘要６(摘要.substring(160, 192))
                    .set摘要７(摘要.substring(192, 224))
                    .set摘要８(摘要.substring(224, 256))
                    .set摘要９(摘要.substring(256, 288))
                    .set摘要１０(摘要.substring(288, 320))
                    .set摘要１１(摘要.substring(320, 352))
                    .set摘要１２(摘要.substring(352, 384))
                    .set摘要１３(摘要.substring(384, 416))
                    .set摘要１４(摘要.substring(416, 448))
                    .set摘要１５(摘要.substring(448, length))
                    .build();
        }
        if (length > 480 && length <= 512) {
            entityModified = entityModified.createBuilderForEdit()
                    .set摘要１(摘要.substring(0, 32))
                    .set摘要２(摘要.substring(32, 64))
                    .set摘要３(摘要.substring(64, 96))
                    .set摘要４(摘要.substring(96, 128))
                    .set摘要５(摘要.substring(128, 160))
                    .set摘要６(摘要.substring(160, 192))
                    .set摘要７(摘要.substring(192, 224))
                    .set摘要８(摘要.substring(224, 256))
                    .set摘要９(摘要.substring(256, 288))
                    .set摘要１０(摘要.substring(288, 320))
                    .set摘要１１(摘要.substring(320, 352))
                    .set摘要１２(摘要.substring(352, 384))
                    .set摘要１３(摘要.substring(384, 416))
                    .set摘要１４(摘要.substring(416, 448))
                    .set摘要１５(摘要.substring(448, 480))
                    .set摘要１６(摘要.substring(480, length))
                    .build();
        }
        if (length > 512 && length <= 544) {
            entityModified = entityModified.createBuilderForEdit()
                    .set摘要１(摘要.substring(0, 32))
                    .set摘要２(摘要.substring(32, 64))
                    .set摘要３(摘要.substring(64, 96))
                    .set摘要４(摘要.substring(96, 128))
                    .set摘要５(摘要.substring(128, 160))
                    .set摘要６(摘要.substring(160, 192))
                    .set摘要７(摘要.substring(192, 224))
                    .set摘要８(摘要.substring(224, 256))
                    .set摘要９(摘要.substring(256, 288))
                    .set摘要１０(摘要.substring(288, 320))
                    .set摘要１１(摘要.substring(320, 352))
                    .set摘要１２(摘要.substring(352, 384))
                    .set摘要１３(摘要.substring(384, 416))
                    .set摘要１４(摘要.substring(416, 448))
                    .set摘要１５(摘要.substring(448, 480))
                    .set摘要１６(摘要.substring(480, 512))
                    .set摘要１７(摘要.substring(512, length))
                    .build();
        }
        if (length > 544 && length <= 576) {
            entityModified = entityModified.createBuilderForEdit()
                    .set摘要１(摘要.substring(0, 32))
                    .set摘要２(摘要.substring(32, 64))
                    .set摘要３(摘要.substring(64, 96))
                    .set摘要４(摘要.substring(96, 128))
                    .set摘要５(摘要.substring(128, 160))
                    .set摘要６(摘要.substring(160, 192))
                    .set摘要７(摘要.substring(192, 224))
                    .set摘要８(摘要.substring(224, 256))
                    .set摘要９(摘要.substring(256, 288))
                    .set摘要１０(摘要.substring(288, 320))
                    .set摘要１１(摘要.substring(320, 352))
                    .set摘要１２(摘要.substring(352, 384))
                    .set摘要１３(摘要.substring(384, 416))
                    .set摘要１４(摘要.substring(416, 448))
                    .set摘要１５(摘要.substring(448, 480))
                    .set摘要１６(摘要.substring(480, 512))
                    .set摘要１７(摘要.substring(512, 544))
                    .set摘要１８(摘要.substring(544, length))
                    .build();
        }
        if (length > 576 && length <= 608) {
            entityModified = entityModified.createBuilderForEdit()
                    .set摘要１(摘要.substring(0, 32))
                    .set摘要２(摘要.substring(32, 64))
                    .set摘要３(摘要.substring(64, 96))
                    .set摘要４(摘要.substring(96, 128))
                    .set摘要５(摘要.substring(128, 160))
                    .set摘要６(摘要.substring(160, 192))
                    .set摘要７(摘要.substring(192, 224))
                    .set摘要８(摘要.substring(224, 256))
                    .set摘要９(摘要.substring(256, 288))
                    .set摘要１０(摘要.substring(288, 320))
                    .set摘要１１(摘要.substring(320, 352))
                    .set摘要１２(摘要.substring(352, 384))
                    .set摘要１３(摘要.substring(384, 416))
                    .set摘要１４(摘要.substring(416, 448))
                    .set摘要１５(摘要.substring(448, 480))
                    .set摘要１６(摘要.substring(480, 512))
                    .set摘要１７(摘要.substring(512, 544))
                    .set摘要１８(摘要.substring(544, 576))
                    .set摘要１９(摘要.substring(576, length))
                    .build();
        }
        if (length > 608 && length <= 640) {
            entityModified = entityModified.createBuilderForEdit()
                    .set摘要１(摘要.substring(0, 32))
                    .set摘要２(摘要.substring(32, 64))
                    .set摘要３(摘要.substring(64, 96))
                    .set摘要４(摘要.substring(96, 128))
                    .set摘要５(摘要.substring(128, 160))
                    .set摘要６(摘要.substring(160, 192))
                    .set摘要７(摘要.substring(192, 224))
                    .set摘要８(摘要.substring(224, 256))
                    .set摘要９(摘要.substring(256, 288))
                    .set摘要１０(摘要.substring(288, 320))
                    .set摘要１１(摘要.substring(320, 352))
                    .set摘要１２(摘要.substring(352, 384))
                    .set摘要１３(摘要.substring(384, 416))
                    .set摘要１４(摘要.substring(416, 448))
                    .set摘要１５(摘要.substring(448, 480))
                    .set摘要１６(摘要.substring(480, 512))
                    .set摘要１７(摘要.substring(512, 544))
                    .set摘要１８(摘要.substring(544, 576))
                    .set摘要１９(摘要.substring(576, 608))
                    .set摘要２０(摘要.substring(608, length))
                    .build();
        }
        if (length > 640) {
            entityModified = entityModified.createBuilderForEdit()
                    .set摘要１(摘要.substring(0, 32))
                    .set摘要２(摘要.substring(32, 64))
                    .set摘要３(摘要.substring(64, 96))
                    .set摘要４(摘要.substring(96, 128))
                    .set摘要５(摘要.substring(128, 160))
                    .set摘要６(摘要.substring(160, 192))
                    .set摘要７(摘要.substring(192, 224))
                    .set摘要８(摘要.substring(224, 256))
                    .set摘要９(摘要.substring(256, 288))
                    .set摘要１０(摘要.substring(288, 320))
                    .set摘要１１(摘要.substring(320, 352))
                    .set摘要１２(摘要.substring(352, 384))
                    .set摘要１３(摘要.substring(384, 416))
                    .set摘要１４(摘要.substring(416, 448))
                    .set摘要１５(摘要.substring(448, 480))
                    .set摘要１６(摘要.substring(480, 512))
                    .set摘要１７(摘要.substring(512, 544))
                    .set摘要１８(摘要.substring(544, 576))
                    .set摘要１９(摘要.substring(576, 608))
                    .set摘要２０(摘要.substring(608, 640))
                    .build();
        }

        return entityModified;
    }

    public void putViewState() {
        // TODO 支給申請画面のモード　
        ViewStateHolder.put(ViewStateKeys.処理モード, ViewStateHolder.get(ViewStateKeys.処理モード, RString.class));
        ViewStateHolder.put(ViewStateKeys.申請日, div.getPanelTwo().getTxtShinseiYMD().getValue());
        SyokanbaraihishikyushinseiketteParameter paramter = new SyokanbaraihishikyushinseiketteParameter(
                ViewStateHolder.get(ViewStateKeys.被保険者番号, HihokenshaNo.class),
                new FlexibleYearMonth(div.getPanelTwo().getTxtServiceTeikyoYM().getValue().toDateString()),
                ViewStateHolder.get(ViewStateKeys.整理番号, RString.class),
                new JigyoshaNo(div.getPanelTwo().getTxtJigyoshaBango().getValue()),
                div.getPanelTwo().getTxtShomeisho().getValue(),
                div.getPanelTwo().getTxtMeisaibango().getValue(),
                null);
        ViewStateHolder.put(ViewStateKeys.償還払費申請検索キー, paramter);
    }
}
