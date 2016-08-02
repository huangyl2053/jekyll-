/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0820025;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShikibetsuNoKanri;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShokanTokuteiNyushoshaKaigoServiceHiyo;
import jp.co.ndensan.reams.db.dbc.business.core.syokanbaraihishikyushinseikette.ShokanKihonParameter;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0820025.TokuteiNyushoshaHiyoPanelDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0820025.dgdTokuteiYichiran_Row;
import jp.co.ndensan.reams.db.dbc.divcontroller.viewbox.ViewStateKeys;
import jp.co.ndensan.reams.db.dbc.divcontroller.viewbox.shoukanharaihishinseikensaku.ShoukanharaihishinseikensakuParameter;
import jp.co.ndensan.reams.db.dbc.divcontroller.viewbox.shoukanharaihishinseikensaku.ShoukanharaihishinseimeisaikensakuParameter;
import jp.co.ndensan.reams.db.dbc.service.core.syokanbaraihishikyushinseikette.SyokanbaraihiShikyuShinseiKetteManager;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceKomokuCode;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.binding.RowState;
import jp.co.ndensan.reams.uz.uza.ui.binding.propertyenum.IconName;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 償還払い費支給申請決定_サービス提供証明書(特定入所者費用）のハンドラクラスです。
 *
 * @reamsid_L DBC-1030-120 wangkanglei
 */
public class TokuteiNyushoshaHiyoPanelHandler {

    private final TokuteiNyushoshaHiyoPanelDiv div;
    private static final RString 設定不可 = new RString("0");
    private static final RString 設定可必須 = new RString("1");
    private static final RString 設定可任意 = new RString("2");
    private static final RString 修正 = new RString("修正");
    private static final RString 削除 = new RString("削除");
    private static final RString 登録 = new RString("登録");
    private static final int SIX = 6;
    private static final RString FORMAT = new RString("%02d");

    /**
     * コンストラクタです。
     *
     * @param div TokuteiNyushoshaHiyoPanelDiv
     */
    public TokuteiNyushoshaHiyoPanelHandler(TokuteiNyushoshaHiyoPanelDiv div) {
        this.div = div;
    }

    /**
     * 申請共通エリアのメソッドます。
     *
     * @param サービス年月 FlexibleYearMonth
     * @param 事業者番号 JigyoshaNo
     * @param 申請日 RDate
     * @param 明細番号 RString
     * @param 証明書 RString
     */
    public void set申請共通エリア(
            FlexibleYearMonth サービス年月,
            JigyoshaNo 事業者番号,
            RDate 申請日,
            RString 明細番号,
            RString 証明書) {
        div.getPanelHead().getTxtServiceTeikyoYM().setValue(new RDate(サービス年月.toString()));
        div.getPanelHead().getTxtShinseiYMD().setValue(申請日);
        div.getPanelHead().getTxtJigyoshaBango().setValue(事業者番号.getColumnValue());
        div.getPanelHead().getTxtMeisaiBango().setValue(明細番号);
        div.getPanelHead().getTxtShomeisho().setValue(証明書);
    }

    /**
     * ボタンを制御のメソッドます。
     *
     * @param shikibetsuNoKanri ShikibetsuNoKanri
     */
    public void getボタンを制御(ShikibetsuNoKanri shikibetsuNoKanri) {

        ShoukanharaihishinseimeisaikensakuParameter meisaiPar = ViewStateHolder.get(ViewStateKeys.償還払費申請明細検索キー,
                ShoukanharaihishinseimeisaikensakuParameter.class);
        HihokenshaNo 被保険者番号 = meisaiPar.get被保険者番号();
        FlexibleYearMonth サービス年月 = meisaiPar.getサービス年月();
        RString 整理番号 = meisaiPar.get整理番号();
        JigyoshaNo 事業者番号 = meisaiPar.get事業者番号();
        RString 様式番号 = meisaiPar.get様式番号();
        RString 明細番号 = meisaiPar.get明細番号();
        set基本情報ボタン制御(shikibetsuNoKanri, 被保険者番号, サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号);
        set給付費明細ボタン制御(shikibetsuNoKanri, 被保険者番号, サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号);
        set特定診療費ボタン制御(shikibetsuNoKanri, 被保険者番号, サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号);
        setサービス計画費ボタン制御(shikibetsuNoKanri, 被保険者番号, サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号);
        div.getPanelHead().getBtnTokuteiNyushosya().setDisabled(true);
        div.getPanelHead().getBtnGoukeiInfo().setDisabled(false);
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
            div.getPanelHead().getBtnKihonInfo().setDisabled(true);
        } else if (設定可必須.equals(shikibetsuNoKanri.get基本設定区分())) {
            int count1 = SyokanbaraihiShikyuShinseiKetteManager.createInstance().getShokanKihonCount(被保険者番号,
                    サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号);
            if (count1 != 0) {
                div.getPanelHead().getBtnKihonInfo().setIconNameEnum(IconName.Incomplete);
            } else {
                div.getPanelHead().getBtnKihonInfo().setIconNameEnum(IconName.Complete);
            }
        } else if (設定可任意.equals(shikibetsuNoKanri.get基本設定区分())) {
            div.getPanelHead().getBtnKihonInfo().setIconNameEnum(IconName.NONE);
        }
    }

    private void set給付費明細ボタン制御(ShikibetsuNoKanri shikibetsuNoKanri, HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス年月, RString 整理番号, JigyoshaNo 事業者番号, RString 様式番号, RString 明細番号) {
        if (設定不可.equals(shikibetsuNoKanri.get明細設定区分())) {
            div.getPanelHead().getBtnKyufuhiMeisai().setDisabled(true);
        } else if (設定可必須.equals(shikibetsuNoKanri.get明細設定区分())) {
            int count2 = SyokanbaraihiShikyuShinseiKetteManager.createInstance().delShokanMeisaiCount(被保険者番号,
                    サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号);
            if (count2 != 0) {
                div.getPanelHead().getBtnKyufuhiMeisai().setIconNameEnum(IconName.Incomplete);
            } else {
                div.getPanelHead().getBtnKyufuhiMeisai().setIconNameEnum(IconName.Complete);
            }
        } else if (設定可任意.equals(shikibetsuNoKanri.get明細設定区分())) {
            div.getPanelHead().getBtnKyufuhiMeisai().setIconNameEnum(IconName.NONE);
        }
    }

    private void setサービス計画費ボタン制御(ShikibetsuNoKanri shikibetsuNoKanri, HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス年月, RString 整理番号, JigyoshaNo 事業者番号, RString 様式番号, RString 明細番号) {
        if (設定不可.equals(shikibetsuNoKanri.get居宅計画費設定区分())) {
            div.getPanelHead().getBtnServiceKeikakuhi().setDisabled(true);
        } else if (設定可必須.equals(shikibetsuNoKanri.get居宅計画費設定区分())) {
            int count4 = SyokanbaraihiShikyuShinseiKetteManager.createInstance().updShokanServicePlan(被保険者番号,
                    サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号);
            if (count4 != 0) {
                div.getPanelHead().getBtnServiceKeikakuhi().setIconNameEnum(IconName.Incomplete);
            } else {
                div.getPanelHead().getBtnServiceKeikakuhi().setIconNameEnum(IconName.Complete);
            }
        } else if (設定可任意.equals(shikibetsuNoKanri.get居宅計画費設定区分())) {
            div.getPanelHead().getBtnServiceKeikakuhi().setIconNameEnum(IconName.NONE);
        }
    }

    private void set特定診療費ボタン制御(ShikibetsuNoKanri shikibetsuNoKanri, HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス年月, RString 整理番号, JigyoshaNo 事業者番号, RString 様式番号, RString 明細番号) {
        if (設定不可.equals(shikibetsuNoKanri.get特定診療費設定区分())) {
            div.getPanelHead().getBtnTokuteiShinryouhi().setDisabled(true);
        } else if (設定可必須.equals(shikibetsuNoKanri.get特定診療費設定区分())) {
            int count3 = SyokanbaraihiShikyuShinseiKetteManager.createInstance().updShokanTokuteiShinryohi(被保険者番号,
                    サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号);
            if (count3 != 0) {
                div.getPanelHead().getBtnTokuteiShinryouhi().setIconNameEnum(IconName.Incomplete);
            } else {
                div.getPanelHead().getBtnTokuteiShinryouhi().setIconNameEnum(IconName.Complete);
            }
        } else if (設定可任意.equals(shikibetsuNoKanri.get特定診療費設定区分())) {
            div.getPanelHead().getBtnTokuteiShinryouhi().setIconNameEnum(IconName.NONE);
        }
    }

    private void set給付費明細_住特ボタン制御(ShikibetsuNoKanri shikibetsuNoKanri, HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス年月, RString 整理番号, JigyoshaNo 事業者番号, RString 様式番号, RString 明細番号) {
        if (設定不可.equals(shikibetsuNoKanri.get明細住所地特例設定区分())) {
            div.getPanelHead().getBtnKyufuhiMeisaiJyuchi().setDisabled(true);
        } else if (設定可必須.equals(shikibetsuNoKanri.get明細住所地特例設定区分())) {
            int count6 = SyokanbaraihiShikyuShinseiKetteManager.createInstance().getShokanMeisaiJushochiTokureiCount(
                    被保険者番号, サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号);
            if (count6 != 0) {
                div.getPanelHead().getBtnKyufuhiMeisaiJyuchi().setIconNameEnum(IconName.Incomplete);
            } else {
                div.getPanelHead().getBtnKyufuhiMeisaiJyuchi().setIconNameEnum(IconName.Complete);
            }
        } else if (設定可任意.equals(shikibetsuNoKanri.get明細住所地特例設定区分())) {
            div.getPanelHead().getBtnKyufuhiMeisaiJyuchi().setIconNameEnum(IconName.NONE);
        }
    }

    private void set緊急時_所定疾患ボタン制御(ShikibetsuNoKanri shikibetsuNoKanri, HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス年月, RString 整理番号, JigyoshaNo 事業者番号, RString 様式番号, RString 明細番号) {
        if (設定不可.equals(shikibetsuNoKanri.get所定疾患施設療養設定区分())) {
            div.getPanelHead().getBtnKinkyujiShoteiShikan().setDisabled(true);
        } else if (設定可必須.equals(shikibetsuNoKanri.get所定疾患施設療養設定区分())) {
            int count7 = SyokanbaraihiShikyuShinseiKetteManager.createInstance().updShokanShoteiShikkanShisetsuRyoyo(
                    被保険者番号, サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号);
            if (count7 != 0) {
                div.getPanelHead().getBtnKinkyujiShoteiShikan().setIconNameEnum(IconName.Incomplete);
            } else {
                div.getPanelHead().getBtnKinkyujiShoteiShikan().setIconNameEnum(IconName.Complete);
            }
        } else if (設定可任意.equals(shikibetsuNoKanri.get所定疾患施設療養設定区分())) {
            div.getPanelHead().getBtnKinkyujiShoteiShikan().setIconNameEnum(IconName.NONE);
        }
    }

    private void set緊急時施設療養費ボタン制御(ShikibetsuNoKanri shikibetsuNoKanri, HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス年月, RString 整理番号, JigyoshaNo 事業者番号, RString 様式番号, RString 明細番号) {
        if (設定不可.equals(shikibetsuNoKanri.get緊急時施設療養設定区分())) {
            div.getPanelHead().getBtnKinkyujiShisetsuRyoyo().setDisabled(true);
        } else if (設定可必須.equals(shikibetsuNoKanri.get緊急時施設療養設定区分())) {
            int count8 = SyokanbaraihiShikyuShinseiKetteManager.createInstance().updShokanKinkyuShisetsuRyoyo(
                    被保険者番号, サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号);
            if (count8 != 0) {
                div.getPanelHead().getBtnKinkyujiShisetsuRyoyo().setIconNameEnum(IconName.Incomplete);
            } else {
                div.getPanelHead().getBtnKinkyujiShisetsuRyoyo().setIconNameEnum(IconName.Complete);
            }
        } else if (設定可任意.equals(shikibetsuNoKanri.get緊急時施設療養設定区分())) {
            div.getPanelHead().getBtnKinkyujiShisetsuRyoyo().setIconNameEnum(IconName.NONE);
        }
    }

    private void set食事費用ボタン制御(ShikibetsuNoKanri shikibetsuNoKanri, HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス年月, RString 整理番号, JigyoshaNo 事業者番号, RString 様式番号, RString 明細番号) {
        if (設定不可.equals(shikibetsuNoKanri.get食事費用設定区分())) {
            div.getPanelHead().getBtnShokujiHiyo().setDisabled(true);
        } else if (設定可必須.equals(shikibetsuNoKanri.get食事費用設定区分())) {
            int count9 = SyokanbaraihiShikyuShinseiKetteManager.createInstance().updShokanShokujiHiyo(
                    被保険者番号, サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号);
            if (count9 != 0) {
                div.getPanelHead().getBtnShokujiHiyo().setIconNameEnum(IconName.Incomplete);
            } else {
                div.getPanelHead().getBtnShokujiHiyo().setIconNameEnum(IconName.Complete);
            }
        } else if (設定可任意.equals(shikibetsuNoKanri.get食事費用設定区分())) {
            div.getPanelHead().getBtnShokujiHiyo().setIconNameEnum(IconName.NONE);
        }
    }

    private void set請求額集計ボタン制御(ShikibetsuNoKanri shikibetsuNoKanri, HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス年月, RString 整理番号, JigyoshaNo 事業者番号, RString 様式番号, RString 明細番号) {
        if (設定不可.equals(shikibetsuNoKanri.get集計設定区分())) {
            div.getPanelHead().getBtnSeikyugakuShukei().setDisabled(true);
        } else if (設定可必須.equals(shikibetsuNoKanri.get集計設定区分())) {
            int count10 = SyokanbaraihiShikyuShinseiKetteManager.createInstance().updShokanShukei(被保険者番号,
                    サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号);
            if (count10 != 0) {
                div.getPanelHead().getBtnSeikyugakuShukei().setIconNameEnum(IconName.Incomplete);
            } else {
                div.getPanelHead().getBtnSeikyugakuShukei().setIconNameEnum(IconName.Complete);
            }
        } else if (設定可任意.equals(shikibetsuNoKanri.get集計設定区分())) {
            div.getPanelHead().getBtnSeikyugakuShukei().setIconNameEnum(IconName.NONE);
        }
    }

    private void set社福軽減額ボタン制御(ShikibetsuNoKanri shikibetsuNoKanri, HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス年月, RString 整理番号, JigyoshaNo 事業者番号, RString 様式番号, RString 明細番号) {
        if (設定不可.equals(shikibetsuNoKanri.get社会福祉法人軽減設定区分())) {
            div.getPanelHead().getBtnShafukukeigengaku().setDisabled(true);
        } else if (設定可必須.equals(shikibetsuNoKanri.get社会福祉法人軽減設定区分())) {
            int count11 = SyokanbaraihiShikyuShinseiKetteManager.createInstance().updShokanShakaiFukushiHojinKeigengaku(
                    被保険者番号, サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号);
            if (count11 != 0) {
                div.getPanelHead().getBtnShafukukeigengaku().setIconNameEnum(IconName.Incomplete);
            } else {
                div.getPanelHead().getBtnShafukukeigengaku().setIconNameEnum(IconName.Complete);
            }
        } else if (設定可任意.equals(shikibetsuNoKanri.get社会福祉法人軽減設定区分())) {
            div.getPanelHead().getBtnShafukukeigengaku().setIconNameEnum(IconName.NONE);
        }
    }

    /**
     * 特定入所者費用一覧グリッド設定のメソッドます。
     *
     * @param list List<ShokanTokuteiNyushoshaKaigoServiceHiyo>
     */
    public void set特定入所者費用一覧グリッド(List<ShokanTokuteiNyushoshaKaigoServiceHiyo> list) {
        List<dgdTokuteiYichiran_Row> dataSource = new ArrayList<>();
        for (ShokanTokuteiNyushoshaKaigoServiceHiyo entity : list) {
            dgdTokuteiYichiran_Row row = new dgdTokuteiYichiran_Row();
            RStringBuilder builder = new RStringBuilder();
            if (entity.getサービス種類コード() != null) {
                builder.append(entity.getサービス種類コード().value());
            }
            if (entity.getサービス項目コード() != null) {
                builder.append(entity.getサービス項目コード().value());
            }
            row.setDefaultDataName1(builder.toRString());
            row.getDefaultDataName2().setValue(new Decimal(entity.get費用単価()));
            row.getDefaultDataName3().setValue(new Decimal(entity.get負担限度額()));
            row.getDefaultDataName4().setValue(new Decimal(entity.get日数()));
            row.getDefaultDataName5().setValue(new Decimal(entity.get費用額()));
            row.getDefaultDataName6().setValue(new Decimal(entity.get保険分請求額()));
            row.getDefaultDataName7().setValue(new Decimal(entity.get利用者負担額()));
            row.setNumber(entity.get連番());
            dataSource.add(row);
        }
        div.getPanelTokutei().getDgdTokuteiYichiran().setDataSource(dataSource);
        set特定入所者費用一覧の合計エリア();
    }

    /**
     * 特定入所者費用一覧の合計エリア設定のメソッドます。
     */
    public void set特定入所者費用一覧の合計エリア() {
        List<dgdTokuteiYichiran_Row> rowList = div.getPanelTokutei().getDgdTokuteiYichiran().getDataSource();
        Decimal 費用額合計 = Decimal.ZERO;
        Decimal 保険分請求額合計 = Decimal.ZERO;
        Decimal 利用者負担額合計 = Decimal.ZERO;
        for (dgdTokuteiYichiran_Row row : rowList) {
            if (!RowState.Deleted.equals(row.getRowState())) {
                費用額合計 = 費用額合計(row, 費用額合計);
                保険分請求額合計 = 保険分請求額合計(row, 保険分請求額合計);
                利用者負担額合計 = 利用者負担額合計(row, 利用者負担額合計);
            }
        }
        div.getPanelTokutei().getTxtHiyogakuTotal().setValue(費用額合計);
        div.getPanelTokutei().getTxtHokenbunTotal().setValue(保険分請求額合計);
        div.getPanelTokutei().getTxtRiyoshaFutangakuTotal().setValue(利用者負担額合計);
    }

    private Decimal 費用額合計(dgdTokuteiYichiran_Row row, Decimal 費用額合計) {
        if (row.getDefaultDataName5().getValue() != null) {
            費用額合計 = 費用額合計.add(row.getDefaultDataName5().getValue());
        }
        return 費用額合計;
    }

    private Decimal 保険分請求額合計(dgdTokuteiYichiran_Row row, Decimal 保険分請求額合計) {
        if (row.getDefaultDataName6().getValue() != null) {
            保険分請求額合計 = 保険分請求額合計.add(row.getDefaultDataName6().getValue());
        }
        return 保険分請求額合計;
    }

    private Decimal 利用者負担額合計(dgdTokuteiYichiran_Row row, Decimal 利用者負担額合計) {
        if (row.getDefaultDataName7().getValue() != null) {
            利用者負担額合計 = 利用者負担額合計.add(row.getDefaultDataName7().getValue());
        }
        return 利用者負担額合計;
    }

    /**
     * 特定入所者費登録エリア設定のメソッドます。
     *
     * @param row dgdTokuteiYichiran_Row
     */
    public void set特定入所者費登録エリア(dgdTokuteiYichiran_Row row) {
        if (!row.getDefaultDataName1().isEmpty() && row.getDefaultDataName1().length() == SIX) {
            RString serviceCodeShuruyi = new RString(row.getDefaultDataName1().substring(0, 2).toString());
            RString serviceCodeKoumoku = new RString(row.getDefaultDataName1().substring(2, SIX).toString());
            div.getPanelTokutei().getPanelMeisai().getCcdServiceCodeInput().setサービス種類コード(serviceCodeShuruyi);
            div.getPanelTokutei().getPanelMeisai().getCcdServiceCodeInput().setサービス項目コード(serviceCodeKoumoku);
        }
        div.getPanelTokutei().getPanelMeisai().getTxtHyojyuntanka().setValue(row.getDefaultDataName2().getValue());
        div.getPanelTokutei().getPanelMeisai().getTxtFutangenndogaku().setValue(row.getDefaultDataName3().getValue());
        div.getPanelTokutei().getPanelMeisai().getTxtNisu().setValue(row.getDefaultDataName4().getValue());
        div.getPanelTokutei().getPanelMeisai().getTxtHiyogaku().setValue(row.getDefaultDataName5().getValue());
        div.getPanelTokutei().getPanelMeisai().getTxtHokenbun().setValue(row.getDefaultDataName6().getValue());
        div.getPanelTokutei().getPanelMeisai().getTxtRiyoshafutangaku().setValue(row.getDefaultDataName7().getValue());
        div.setRowId(new RString(String.valueOf(row.getId())));
    }

    /**
     * 特定入所者費登録エリアclearのメソッドます。
     */
    public void clear特定入所者費登録エリア() {
        div.getPanelTokutei().getPanelMeisai().getCcdServiceCodeInput().setサービス種類コード(RString.EMPTY);
        div.getPanelTokutei().getPanelMeisai().getCcdServiceCodeInput().setサービス項目コード(RString.EMPTY);
        div.getPanelTokutei().getPanelMeisai().getCcdServiceCodeInput().setサービス名称(RString.EMPTY);
        div.getPanelTokutei().getPanelMeisai().getTxtHyojyuntanka().clearValue();
        div.getPanelTokutei().getPanelMeisai().getTxtFutangenndogaku().clearValue();
        div.getPanelTokutei().getPanelMeisai().getTxtNisu().clearValue();
        div.getPanelTokutei().getPanelMeisai().getTxtHiyogaku().clearValue();
        div.getPanelTokutei().getPanelMeisai().getTxtHokenbun().clearValue();
        div.getPanelTokutei().getPanelMeisai().getTxtRiyoshafutangaku().clearValue();
    }

    /**
     * 特定入所者費登録エリアcancelのメソッドます。
     */
    public void cancel特定入所者費登録エリア() {
        clear特定入所者費登録エリア();
        div.getPanelTokutei().getPanelMeisai().setVisible(false);
    }

    /**
     * 計算結果のメソッドます。
     */
    public void click計算結果() {
        if (div.getPanelTokutei().getPanelMeisai().getTxtHyojyuntanka().getValue() != null
                && div.getPanelTokutei().getPanelMeisai().getTxtNisu().getValue() != null) {
            Decimal data = div.getPanelTokutei().getPanelMeisai().getTxtHyojyuntanka().getValue().multiply(
                    div.getPanelTokutei().getPanelMeisai().getTxtNisu().getValue());
            div.getPanelTokutei().getPanelMeisai().getTxtHiyogaku().setValue(data);
        } else {
            div.getPanelTokutei().getPanelMeisai().getTxtHiyogaku().setValue(Decimal.ZERO);
        }
    }

    /**
     * 選択行のデータのメソッドます。
     *
     * @return dgdTokuteiYichiran_Row
     */
    public dgdTokuteiYichiran_Row getSelectedRow() {
        return div.getPanelTokutei().getDgdTokuteiYichiran().getDataSource().get(Integer.parseInt(
                div.getRowId().toString()));
    }

    /**
     * 特定入所者費登録エリアの「確定する」ボタンのメソッドます。
     *
     * @param dgdRow dgdTokuteiYichiran_Row
     */
    public void modifyRow(dgdTokuteiYichiran_Row dgdRow) {
        RString state = ViewStateHolder.get(ViewStateKeys.状態, RString.class);
        if (修正.equals(state)) {
            if (RowState.Added.equals(dgdRow.getRowState())) {
                dgdRow.setRowState(RowState.Added);
                setDgdTokuteiYichiran_Row(dgdRow);
            } else {
                modifiedDgdTokuteiYichiran(dgdRow);
            }
        } else if (削除.equals(state)) {
            if (RowState.Added.equals(dgdRow.getRowState())) {
                div.getPanelTokutei().getDgdTokuteiYichiran().getDataSource().remove(Integer.parseInt(
                        div.getRowId().toString()));
                cancel特定入所者費登録エリア();
            } else {
                dgdRow.setRowState(RowState.Deleted);
                cancel特定入所者費登録エリア();
                set特定入所者費用一覧の合計エリア();
            }
        } else if (登録.equals(state)) {
            dgdRow.setRowState(RowState.Added);
            setDgdTokuteiYichiran_Row(dgdRow);
        }
    }

    private void modifiedDgdTokuteiYichiran(dgdTokuteiYichiran_Row dgdRow) {
        boolean flag = modifiedCheck(dgdRow);
        if (flag) {
            dgdRow.setRowState(RowState.Modified);
            setDgdTokuteiYichiran_Row(dgdRow);
        }
    }

    private boolean modifiedCheck(dgdTokuteiYichiran_Row dgdRow) {
        RString サービス種類コード = div.getPanelTokutei().getPanelMeisai().getCcdServiceCodeInput().getサービスコード1();
        RString サービス項目コード = div.getPanelTokutei().getPanelMeisai().getCcdServiceCodeInput().getサービスコード2();
        RStringBuilder builder = new RStringBuilder();
        builder.append(サービス種類コード).append(サービス項目コード);
        if (!dgdRow.getDefaultDataName1().equals(builder.toRString())) {
            return true;
        }
        if (!dgdRow.getDefaultDataName2().getValue().equals(div.getPanelTokutei().getPanelMeisai()
                .getTxtHyojyuntanka().getValue())) {
            return true;
        }
        if (!dgdRow.getDefaultDataName3().getValue().equals(div.getPanelTokutei().getPanelMeisai()
                .getTxtFutangenndogaku().getValue())) {
            return true;
        }
        if (!dgdRow.getDefaultDataName4().getValue().equals(div.getPanelTokutei().getPanelMeisai()
                .getTxtNisu().getValue())) {
            return true;
        }
        if (!dgdRow.getDefaultDataName5().getValue().equals(div.getPanelTokutei().getPanelMeisai()
                .getTxtHiyogaku().getValue())) {
            return true;
        }
        if (!dgdRow.getDefaultDataName6().getValue().equals(div.getPanelTokutei().getPanelMeisai()
                .getTxtHokenbun().getValue())) {
            return true;
        }
        return (!dgdRow.getDefaultDataName7().getValue().equals(div.getPanelTokutei().getPanelMeisai()
                .getTxtRiyoshafutangaku().getValue()));
    }

    private void setDgdTokuteiYichiran_Row(dgdTokuteiYichiran_Row dgdRow) {
        RString サービス種類コード = div.getPanelTokutei().getPanelMeisai().getCcdServiceCodeInput().getサービスコード1();
        RString サービス項目コード = div.getPanelTokutei().getPanelMeisai().getCcdServiceCodeInput().getサービスコード2();
        RStringBuilder builder = new RStringBuilder();
        builder.append(サービス種類コード).append(サービス項目コード);
        dgdRow.setDefaultDataName1(builder.toRString());
        if (div.getPanelTokutei().getPanelMeisai().getTxtHyojyuntanka().getValue() != null) {
            dgdRow.getDefaultDataName2().setValue(div.getPanelTokutei().getPanelMeisai()
                    .getTxtHyojyuntanka().getValue());
        }
        if (div.getPanelTokutei().getPanelMeisai().getTxtFutangenndogaku().getValue() != null) {
            dgdRow.getDefaultDataName3().setValue(div.getPanelTokutei().getPanelMeisai()
                    .getTxtFutangenndogaku().getValue());
        }
        if (div.getPanelTokutei().getPanelMeisai().getTxtNisu().getValue() != null) {
            dgdRow.getDefaultDataName4().setValue(div.getPanelTokutei().getPanelMeisai().getTxtNisu().getValue());
        }
        if (div.getPanelTokutei().getPanelMeisai().getTxtHiyogaku().getValue() != null) {
            dgdRow.getDefaultDataName5().setValue(div.getPanelTokutei().getPanelMeisai().getTxtHiyogaku().getValue());
        }
        if (div.getPanelTokutei().getPanelMeisai().getTxtHokenbun().getValue() != null) {
            dgdRow.getDefaultDataName6().setValue(div.getPanelTokutei().getPanelMeisai().getTxtHokenbun().getValue());
        }
        if (div.getPanelTokutei().getPanelMeisai().getTxtRiyoshafutangaku().getValue() != null) {
            dgdRow.getDefaultDataName7().setValue(div.getPanelTokutei().getPanelMeisai()
                    .getTxtRiyoshafutangaku().getValue());
        }
        if (登録.equals(ViewStateHolder.get(ViewStateKeys.状態, RString.class))) {
            List<dgdTokuteiYichiran_Row> list = div.getPanelTokutei().getDgdTokuteiYichiran().getDataSource();
            list.add(dgdRow);
        }
        cancel特定入所者費登録エリア();
        set特定入所者費用一覧の合計エリア();
    }

    /**
     * 内容変更状態のメソッドます。
     *
     * @return boolean
     */
    public boolean isChange() {
        for (dgdTokuteiYichiran_Row dgdRow : div.getPanelTokutei().getDgdTokuteiYichiran().getDataSource()) {
            if (RowState.Modified.equals(dgdRow.getRowState())
                    || RowState.Added.equals(dgdRow.getRowState())
                    || RowState.Deleted.equals(dgdRow.getRowState())) {
                return true;
            }
        }
        return false;
    }

    /**
     * 「申請を保存する」ボタンのメソッドます。
     */
    public void 保存処理() {
        ShoukanharaihishinseimeisaikensakuParameter meisaiPar = ViewStateHolder.get(ViewStateKeys.償還払費申請明細検索キー,
                ShoukanharaihishinseimeisaikensakuParameter.class);
        HihokenshaNo 被保険者番号 = meisaiPar.get被保険者番号();
        FlexibleYearMonth サービス年月 = meisaiPar.getサービス年月();
        RString 整理番号 = meisaiPar.get整理番号();
        JigyoshaNo 事業者番号 = meisaiPar.get事業者番号();
        RString 様式番号 = meisaiPar.get様式番号();
        RString 明細番号 = meisaiPar.get明細番号();
        if (削除.equals(ViewStateHolder.get(ViewStateKeys.処理モード, RString.class))) {
            SyokanbaraihiShikyuShinseiKetteManager.createInstance().delShokanSyomeisyo(被保険者番号,
                    サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号);
        } else {
            Map<RString, ShokanTokuteiNyushoshaKaigoServiceHiyo> map = new HashMap<>();
            List<ShokanTokuteiNyushoshaKaigoServiceHiyo> 特定入所者費用List = new ArrayList<>();
            int 連番 = 0;
            List<ShokanTokuteiNyushoshaKaigoServiceHiyo> serviceHiyoList = ViewStateHolder.get(
                    ViewStateKeys.償還払請求特定入所者介護サービス費用データ, List.class);
            for (ShokanTokuteiNyushoshaKaigoServiceHiyo entity : serviceHiyoList) {
                map.put(entity.get連番(), entity);
                if (連番 < Integer.valueOf(entity.get連番().toString())) {
                    連番 = Integer.valueOf(entity.get連番().toString());
                }
            }
            特定入所者費用List = save特定入所者費用(map, 特定入所者費用List, 被保険者番号, サービス年月, 事業者番号, 整理番号,
                    様式番号, 明細番号, 連番);
            int 合計 = div.getPanelTokutei().getTxtHiyogakuTotal().getValue().intValue();
            ShokanKihonParameter parameter = ShokanKihonParameter.createSelectByKeyParam(
                    被保険者番号, サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号, 合計);
            SyokanbaraihiShikyuShinseiKetteManager.createInstance().updShokanTokuteiNyushoshaKaigoServiceHiyo(
                    parameter, 特定入所者費用List);
        }
    }

    private List<ShokanTokuteiNyushoshaKaigoServiceHiyo> save特定入所者費用(
            Map<RString, ShokanTokuteiNyushoshaKaigoServiceHiyo> map,
            List<ShokanTokuteiNyushoshaKaigoServiceHiyo> 特定入所者費用List,
            HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス年月,
            JigyoshaNo 事業者番号,
            RString 整理番号,
            RString 様式番号,
            RString 明細番号,
            int 連番) {
        for (dgdTokuteiYichiran_Row dgdRow : div.getPanelTokutei().getDgdTokuteiYichiran().getDataSource()) {
            if (RowState.Modified.equals(dgdRow.getRowState())) {
                ShokanTokuteiNyushoshaKaigoServiceHiyo entityModified = map.get(dgdRow.getNumber());
                entityModified = buildShokanTokuteiNyushoshaKaigoServiceHiyo(entityModified, dgdRow);
                特定入所者費用List.add(entityModified);
            } else if (RowState.Deleted.equals(dgdRow.getRowState())) {
                ShokanTokuteiNyushoshaKaigoServiceHiyo entityDeleted = map.get(dgdRow.getNumber());
                entityDeleted = entityDeleted.deleted();
                特定入所者費用List.add(entityDeleted);
            } else if (RowState.Added.equals(dgdRow.getRowState())) {
                連番 = 連番 + 1;
                ShokanTokuteiNyushoshaKaigoServiceHiyo entityAdded = new ShokanTokuteiNyushoshaKaigoServiceHiyo(
                        被保険者番号,
                        サービス年月,
                        整理番号,
                        事業者番号,
                        様式番号,
                        明細番号,
                        new RString(String.format(FORMAT.toString(), 連番))).createBuilderForEdit().build();
                entityAdded = buildShokanTokuteiNyushoshaKaigoServiceHiyo(entityAdded, dgdRow);
                特定入所者費用List.add(entityAdded);
            }
        }
        return 特定入所者費用List;
    }

    private ShokanTokuteiNyushoshaKaigoServiceHiyo buildShokanTokuteiNyushoshaKaigoServiceHiyo(
            ShokanTokuteiNyushoshaKaigoServiceHiyo entity, dgdTokuteiYichiran_Row dgdRow) {
        if (!dgdRow.getDefaultDataName1().isEmpty() && dgdRow.getDefaultDataName1().length() == SIX) {
            RString code1 = dgdRow.getDefaultDataName1().substring(0, 2);
            RString code2 = dgdRow.getDefaultDataName1().substring(2, SIX);
            entity = entity.createBuilderForEdit()
                    .setサービス種類コード(new ServiceShuruiCode(code1))
                    .setサービス項目コード(new ServiceKomokuCode(code2)).build();
        }
        if (dgdRow.getDefaultDataName2().getValue() != null) {
            entity = entity.createBuilderForEdit().set費用単価(dgdRow.getDefaultDataName2()
                    .getValue().intValue()).build();
        } else {
            entity = entity.createBuilderForEdit().set費用単価(0).build();
        }
        if (dgdRow.getDefaultDataName3().getValue() != null) {
            entity = entity.createBuilderForEdit().set負担限度額(dgdRow.getDefaultDataName3()
                    .getValue().intValue()).build();
        } else {
            entity = entity.createBuilderForEdit().set負担限度額(0).build();
        }
        if (dgdRow.getDefaultDataName4().getValue() != null) {
            entity = entity.createBuilderForEdit().set日数(dgdRow.getDefaultDataName4().getValue().intValue()).build();
        } else {
            entity = entity.createBuilderForEdit().set日数(0).build();
        }
        if (dgdRow.getDefaultDataName5().getValue() != null) {
            entity = entity.createBuilderForEdit().set費用額(dgdRow.getDefaultDataName5().getValue().intValue()).build();
        } else {
            entity = entity.createBuilderForEdit().set費用額(0).build();
        }
        if (dgdRow.getDefaultDataName6().getValue() != null) {
            entity = entity.createBuilderForEdit().set保険分請求額(dgdRow.getDefaultDataName6()
                    .getValue().intValue()).build();
        }
        if (dgdRow.getDefaultDataName7().getValue() != null) {
            entity = entity.createBuilderForEdit().set利用者負担額(dgdRow.getDefaultDataName7()
                    .getValue().intValue()).build();
        } else {
            entity = entity.createBuilderForEdit().set利用者負担額(0).build();
        }
        if (div.getPanelTokutei().getTxtHiyogakuTotal().getValue() != null) {
            entity = entity.createBuilderForEdit().set費用額合計(div.getPanelTokutei().getTxtHiyogakuTotal().getValue()
                    .intValue()).build();
        } else {
            entity = entity.createBuilderForEdit().set費用額合計(0).build();
        }
        if (div.getPanelTokutei().getTxtHokenbunTotal().getValue() != null) {
            entity = entity.createBuilderForEdit().set保険分請求額合計(div.getPanelTokutei()
                    .getTxtHokenbunTotal().getValue().intValue()).build();
        } else {
            entity = entity.createBuilderForEdit().set保険分請求額合計(0).build();
        }
        if (div.getPanelTokutei().getTxtRiyoshaFutangakuTotal().getValue() != null) {
            entity = entity.createBuilderForEdit().set利用者負担額合計(div.getPanelTokutei().getTxtRiyoshaFutangakuTotal()
                    .getValue().intValue()).build();
        } else {
            entity = entity.createBuilderForEdit().set利用者負担額合計(0).build();
        }
        return entity;
    }

    /**
     * パラメータ設定のメソッドます。
     */
    public void putViewState() {
        ViewStateHolder.put(ViewStateKeys.処理モード, ViewStateHolder.get(ViewStateKeys.処理モード, RString.class));
        ViewStateHolder.put(ViewStateKeys.申請日, div.getPanelHead().getTxtShinseiYMD().getValue());
        ShoukanharaihishinseikensakuParameter paramter = new ShoukanharaihishinseikensakuParameter(
                ViewStateHolder.get(ViewStateKeys.被保険者番号, HihokenshaNo.class),
                ViewStateHolder.get(ViewStateKeys.サービス年月, FlexibleYearMonth.class),
                ViewStateHolder.get(ViewStateKeys.整理番号, RString.class),
                new JigyoshaNo(div.getPanelHead().getTxtJigyoshaBango().getValue()),
                div.getPanelHead().getTxtShomeisho().getValue(),
                div.getPanelHead().getTxtMeisaiBango().getValue(),
                null);
        ViewStateHolder.put(ViewStateKeys.償還払費申請検索キー, paramter);
    }

    /**
     * readOnly特定入所者費登録エリアのメソッドます。
     *
     * @param flag boolean
     */
    public void readOnly特定入所者費登録エリア(boolean flag) {
        div.getPanelTokutei().getPanelMeisai().getCcdServiceCodeInput().setReadOnly(flag);
        div.getPanelTokutei().getPanelMeisai().getTxtHyojyuntanka().setReadOnly(flag);
        div.getPanelTokutei().getPanelMeisai().getTxtFutangenndogaku().setReadOnly(flag);
        div.getPanelTokutei().getPanelMeisai().getTxtNisu().setReadOnly(flag);
        div.getPanelTokutei().getPanelMeisai().getTxtHiyogaku().setReadOnly(flag);
        div.getPanelTokutei().getPanelMeisai().getTxtHokenbun().setReadOnly(flag);
        div.getPanelTokutei().getPanelMeisai().getTxtRiyoshafutangaku().setReadOnly(flag);
        div.getPanelTokutei().getPanelMeisai().getBtnKeisan().setDisabled(flag);
    }
}
