/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0820031;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShikibetsuNoKanri;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShokanShakaiFukushiHojinKeigengaku;
import jp.co.ndensan.reams.db.dbc.business.core.shokanbaraijyokyoshokai.ShokanShakaiFukushiHojinKeigengakuResult;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0820031.ShafukuKeigenGakuPanelDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0820031.dgdShafukukeigenngaku_Row;
import jp.co.ndensan.reams.db.dbc.divcontroller.viewbox.shoukanharaihishinseikensaku.ShoukanharaihishinseimeisaikensakuParameter;
import jp.co.ndensan.reams.db.dbc.service.core.syokanbaraihishikyushinseikette.SyokanbaraihiShikyuShinseiKetteManager;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.SaibanHanyokeyName;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.binding.RowState;
import jp.co.ndensan.reams.uz.uza.ui.binding.propertyenum.IconName;
import jp.co.ndensan.reams.uz.uza.util.Saiban;

/**
 * 償還払い費支給申請決定_サービス提供証明書(社福軽減額）のクラスです。
 *
 * @reamsid_L DBC-1030-080 xuhao
 */
public final class ShafukuKeigenGakuPanelHandler {

    private final ShafukuKeigenGakuPanelDiv div;
    private static final RString 設定不可 = new RString("0");
    private static final RString 設定可必須 = new RString("1");
    private static final RString 設定可任意 = new RString("2");
    private static final RString 修正 = new RString("修正");
    private static final RString 削除 = new RString("削除");
    private static final RString 登録 = new RString("登録");

    private ShafukuKeigenGakuPanelHandler(ShafukuKeigenGakuPanelDiv div) {
        this.div = div;
    }

    /**
     * ShafukuKeigenGakuPanelHandler
     *
     * @param div 画面DIV
     * @return 画面DIV
     */
    public static ShafukuKeigenGakuPanelHandler of(ShafukuKeigenGakuPanelDiv div) {
        return new ShafukuKeigenGakuPanelHandler(div);
    }

    /**
     * initialize
     *
     * @param hojinKeigengakuEntityList hojinKeigengakuEntityList
     */
    public void initialize(List<ShokanShakaiFukushiHojinKeigengakuResult> hojinKeigengakuEntityList) {
        List<dgdShafukukeigenngaku_Row> rowList = new ArrayList<>();
        for (ShokanShakaiFukushiHojinKeigengakuResult shafukuKeigenGaku : hojinKeigengakuEntityList) {
            dgdShafukukeigenngaku_Row row = new dgdShafukukeigenngaku_Row();
            row.setDefaultDataName1(shafukuKeigenGaku.getShokanShakai()
                    .getサービス種類コード().value());
            row.setDefaultDataName2(new RString(shafukuKeigenGaku.getShokanShakai()
                    .get軽減率().toString()));
            row.getDefaultDataName3().setValue(new Decimal(shafukuKeigenGaku.getShokanShakai()
                    .get受領すべき利用者負担の総額()));
            row.getDefaultDataName4().setValue(new Decimal(shafukuKeigenGaku.getShokanShakai()
                    .get軽減額()));
            row.getDefaultDataName5().setValue(new Decimal(shafukuKeigenGaku.getShokanShakai()
                    .get軽減後利用者負担額()));
            row.setDefaultDataName6(shafukuKeigenGaku.getShokanShakai().get備考());
            row.setDefaultDataName7(shafukuKeigenGaku.getShokanShakai().get連番());
            rowList.add(row);
        }
        div.getPanelShafukukenngengaku().getDgdShafukukeigenngaku().setDataSource(rowList);
    }

    /**
     * getボタンを制御
     *
     * @param entity entity
     * @param meisaiPar ShoukanharaihishinseimeisaikensakuParameter
     */
    public void getボタンを制御(ShikibetsuNoKanri entity, ShoukanharaihishinseimeisaikensakuParameter meisaiPar) {
        HihokenshaNo 被保険者番号 = meisaiPar.get被保険者番号();
        FlexibleYearMonth サービス年月 = meisaiPar.getサービス年月();
        RString 整理番号 = meisaiPar.get整理番号();
        JigyoshaNo 事業者番号 = meisaiPar.get事業者番号();
        RString 様式番号 = meisaiPar.get様式番号();
        RString 明細番号 = meisaiPar.get明細番号();
        set基本設定(entity, 被保険者番号, サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号);
        set明細設定(entity, 被保険者番号, サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号);
        set特定診療費(entity, 被保険者番号, サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号);
        set居宅計画費(entity, 被保険者番号, サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号);
        set特定入所者(entity, 被保険者番号, サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号);
        div.getPanelHead().getBtnGoukeiInfo().setDisabled(false);
        set給付費明細_住特(entity, 被保険者番号, サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号);
        set緊急時_所定疾患(entity, 被保険者番号, サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号);
        set緊急時施設療養費(entity, 被保険者番号, サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号);
        set食事費用(entity, 被保険者番号, サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号);
        set請求額集計(entity, 被保険者番号, サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号);
    }

    private void set請求額集計(ShikibetsuNoKanri entity, HihokenshaNo 被保険者番号, FlexibleYearMonth サービス年月,
            RString 整理番号, JigyoshaNo 事業者番号, RString 様式番号, RString 明細番号) {
        if (設定不可.equals(entity.get集計設定区分())) {
            div.getPanelHead().getBtnSeikyugakuShukei().setDisabled(true);
        } else if (設定可必須.equals(entity.get集計設定区分())) {
            int count10 = SyokanbaraihiShikyuShinseiKetteManager.createInstance().updShokanShukei(被保険者番号,
                    サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号);
            if (count10 != 0) {
                div.getPanelHead().getBtnSeikyugakuShukei().setIconNameEnum(IconName.Incomplete);
            } else {
                div.getPanelHead().getBtnSeikyugakuShukei().setIconNameEnum(IconName.Complete);
            }
        } else if (設定可任意.equals(entity.get集計設定区分())) {
            div.getPanelHead().getBtnSeikyugakuShukei().setIconNameEnum(IconName.NONE);
        }
    }

    private void set食事費用(ShikibetsuNoKanri entity, HihokenshaNo 被保険者番号, FlexibleYearMonth サービス年月,
            RString 整理番号, JigyoshaNo 事業者番号, RString 様式番号, RString 明細番号) {
        if (設定不可.equals(entity.get食事費用設定区分())) {
            div.getPanelHead().getBtnShokujiHiyo().setDisabled(true);
        } else if (設定可必須.equals(entity.get食事費用設定区分())) {
            int count9 = SyokanbaraihiShikyuShinseiKetteManager.createInstance().updShokanShokujiHiyo(
                    被保険者番号, サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号);
            if (count9 != 0) {
                div.getPanelHead().getBtnShokujiHiyo().setIconNameEnum(IconName.Incomplete);
            } else {
                div.getPanelHead().getBtnShokujiHiyo().setIconNameEnum(IconName.Complete);
            }
        } else if (設定可任意.equals(entity.get食事費用設定区分())) {
            div.getPanelHead().getBtnShokujiHiyo().setIconNameEnum(IconName.NONE);
        }
    }

    private void set緊急時施設療養費(ShikibetsuNoKanri entity, HihokenshaNo 被保険者番号, FlexibleYearMonth サービス年月,
            RString 整理番号, JigyoshaNo 事業者番号, RString 様式番号, RString 明細番号) {
        if (設定不可.equals(entity.get緊急時施設療養設定区分())) {
            div.getPanelHead().getBtnKinkyujiShisetsuRyoyo().setDisabled(true);
        } else if (設定可必須.equals(entity.get緊急時施設療養設定区分())) {
            int count8 = SyokanbaraihiShikyuShinseiKetteManager.createInstance().updShokanKinkyuShisetsuRyoyo(
                    被保険者番号, サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号);
            if (count8 != 0) {
                div.getPanelHead().getBtnKinkyujiShisetsuRyoyo().setIconNameEnum(IconName.Incomplete);
            } else {
                div.getPanelHead().getBtnKinkyujiShisetsuRyoyo().setIconNameEnum(IconName.Complete);
            }
        } else if (設定可任意.equals(entity.get緊急時施設療養設定区分())) {
            div.getPanelHead().getBtnKinkyujiShisetsuRyoyo().setIconNameEnum(IconName.NONE);
        }
    }

    private void set緊急時_所定疾患(ShikibetsuNoKanri entity, HihokenshaNo 被保険者番号, FlexibleYearMonth サービス年月,
            RString 整理番号, JigyoshaNo 事業者番号, RString 様式番号, RString 明細番号) {
        if (設定不可.equals(entity.get所定疾患施設療養設定区分())) {
            div.getPanelHead().getBtnKinkyujiShoteiShikan().setDisabled(true);
        } else if (設定可必須.equals(entity.get所定疾患施設療養設定区分())) {
            int count7 = SyokanbaraihiShikyuShinseiKetteManager.createInstance().updShokanShoteiShikkanShisetsuRyoyo(
                    被保険者番号, サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号);
            if (count7 != 0) {
                div.getPanelHead().getBtnKinkyujiShoteiShikan().setIconNameEnum(IconName.Incomplete);
            } else {
                div.getPanelHead().getBtnKinkyujiShoteiShikan().setIconNameEnum(IconName.Complete);
            }
        } else if (設定可任意.equals(entity.get所定疾患施設療養設定区分())) {
            div.getPanelHead().getBtnKinkyujiShoteiShikan().setIconNameEnum(IconName.NONE);
        }
    }

    private void set給付費明細_住特(ShikibetsuNoKanri entity, HihokenshaNo 被保険者番号, FlexibleYearMonth サービス年月,
            RString 整理番号, JigyoshaNo 事業者番号, RString 様式番号, RString 明細番号) {
        if (設定不可.equals(entity.get明細住所地特例設定区分())) {
            div.getPanelHead().getBtnKyufuhiMeisaiJyuchi().setDisabled(true);
        } else if (設定可必須.equals(entity.get明細住所地特例設定区分())) {
            int count6 = SyokanbaraihiShikyuShinseiKetteManager.createInstance().getShokanMeisaiJushochiTokureiCount(
                    被保険者番号, サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号);
            if (count6 != 0) {
                div.getPanelHead().getBtnKyufuhiMeisaiJyuchi().setIconNameEnum(IconName.Incomplete);
            } else {
                div.getPanelHead().getBtnKyufuhiMeisaiJyuchi().setIconNameEnum(IconName.Complete);
            }
        } else if (設定可任意.equals(entity.get明細住所地特例設定区分())) {
            div.getPanelHead().getBtnKyufuhiMeisaiJyuchi().setIconNameEnum(IconName.NONE);
        }
    }

    private void set特定入所者(ShikibetsuNoKanri entity, HihokenshaNo 被保険者番号, FlexibleYearMonth サービス年月,
            RString 整理番号, JigyoshaNo 事業者番号, RString 様式番号, RString 明細番号) {
        if (設定不可.equals(entity.get特定入所者設定区分())) {
            div.getPanelHead().getBtnTokuteiNyushosya().setDisabled(true);
        } else if (設定可必須.equals(entity.get特定入所者設定区分())) {
            int count5 = SyokanbaraihiShikyuShinseiKetteManager.createInstance()
                    .updShokanTokuteiNyushoshaKaigoServiceHiyo(被保険者番号, サービス年月, 整理番号,
                            事業者番号, 様式番号, 明細番号);
            if (count5 != 0) {
                div.getPanelHead().getBtnTokuteiNyushosya().setIconNameEnum(IconName.Incomplete);
            } else {
                div.getPanelHead().getBtnTokuteiNyushosya().setIconNameEnum(IconName.Complete);
            }
        } else if (設定可任意.equals(entity.get特定入所者設定区分())) {
            div.getPanelHead().getBtnTokuteiNyushosya().setIconNameEnum(IconName.NONE);
        }
    }

    private void set居宅計画費(ShikibetsuNoKanri entity, HihokenshaNo 被保険者番号, FlexibleYearMonth サービス年月,
            RString 整理番号, JigyoshaNo 事業者番号, RString 様式番号, RString 明細番号) {
        if (設定不可.equals(entity.get居宅計画費設定区分())) {
            div.getPanelHead().getBtnServiceKeikakuhi().setDisabled(true);
        } else if (設定可必須.equals(entity.get居宅計画費設定区分())) {
            int count4 = SyokanbaraihiShikyuShinseiKetteManager.createInstance().updShokanServicePlan(被保険者番号,
                    サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号);
            if (count4 != 0) {
                div.getPanelHead().getBtnServiceKeikakuhi().setIconNameEnum(IconName.Incomplete);
            } else {
                div.getPanelHead().getBtnServiceKeikakuhi().setIconNameEnum(IconName.Complete);
            }
        } else if (設定可任意.equals(entity.get居宅計画費設定区分())) {
            div.getPanelHead().getBtnServiceKeikakuhi().setIconNameEnum(IconName.NONE);
        }
    }

    private void set特定診療費(ShikibetsuNoKanri entity, HihokenshaNo 被保険者番号, FlexibleYearMonth サービス年月,
            RString 整理番号, JigyoshaNo 事業者番号, RString 様式番号, RString 明細番号) {
        if (設定不可.equals(entity.get特定診療費設定区分())) {
            div.getPanelHead().getBtnTokuteiShinryohi().setDisabled(true);
        } else if (設定可必須.equals(entity.get特定診療費設定区分())) {
            int count3 = SyokanbaraihiShikyuShinseiKetteManager.createInstance().updShokanTokuteiShinryohi(被保険者番号,
                    サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号);
            if (count3 != 0) {
                div.getPanelHead().getBtnTokuteiShinryohi().setIconNameEnum(IconName.Incomplete);
            } else {
                div.getPanelHead().getBtnTokuteiShinryohi().setIconNameEnum(IconName.Complete);
            }
        } else if (設定可任意.equals(entity.get特定診療費設定区分())) {
            div.getPanelHead().getBtnTokuteiShinryohi().setIconNameEnum(IconName.NONE);
        }
    }

    private void set明細設定(ShikibetsuNoKanri entity, HihokenshaNo 被保険者番号, FlexibleYearMonth サービス年月,
            RString 整理番号, JigyoshaNo 事業者番号, RString 様式番号, RString 明細番号) {
        if (設定不可.equals(entity.get明細設定区分())) {
            div.getPanelHead().getBtnKyufuhiMeisai().setDisabled(true);
        } else if (設定可必須.equals(entity.get明細設定区分())) {
            int count2 = SyokanbaraihiShikyuShinseiKetteManager.createInstance().delShokanMeisaiCount(被保険者番号,
                    サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号);
            if (count2 != 0) {
                div.getPanelHead().getBtnKyufuhiMeisai().setIconNameEnum(IconName.Incomplete);
            } else {
                div.getPanelHead().getBtnKyufuhiMeisai().setIconNameEnum(IconName.Complete);
            }
        } else if (設定可任意.equals(entity.get明細設定区分())) {
            div.getPanelHead().getBtnKyufuhiMeisai().setIconNameEnum(IconName.NONE);
        }
    }

    private void set基本設定(ShikibetsuNoKanri entity, HihokenshaNo 被保険者番号, FlexibleYearMonth サービス年月,
            RString 整理番号, JigyoshaNo 事業者番号, RString 様式番号, RString 明細番号) {
        if (設定不可.equals(entity.get基本設定区分())) {
            div.getPanelHead().getBtnKihonInfo().setDisabled(true);
        } else if (設定可必須.equals(entity.get基本設定区分())) {
            int count1 = SyokanbaraihiShikyuShinseiKetteManager.createInstance().getShokanKihonCount(被保険者番号,
                    サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号);
            if (count1 != 0) {
                div.getPanelHead().getBtnKihonInfo().setIconNameEnum(IconName.Incomplete);
            } else {
                div.getPanelHead().getBtnKihonInfo().setIconNameEnum(IconName.Complete);
            }
        } else if (設定可任意.equals(entity.get基本設定区分())) {
            div.getPanelHead().getBtnKihonInfo().setIconNameEnum(IconName.NONE);
        }
    }

    /**
     * initializeByModify
     */
    public void initializeByModify() {
        dgdShafukukeigenngaku_Row row = div.getPanelShafukukenngengaku().getDgdShafukukeigenngaku().getClickedItem();
        set選択行(row);
        setNotReadOnly();
    }

    private void set選択行(dgdShafukukeigenngaku_Row row) {
        div.getPanelShafukukenngengaku().getPanelShakaiFukushiShokai().getDdlServiceShurui()
                .setSelectedValue(row.getDefaultDataName1());
        div.getPanelShafukukenngengaku().getPanelShakaiFukushiShokai().getDdlKengenritsu()
                .setSelectedValue(row.getDefaultDataName2());
        div.getPanelShafukukenngengaku().getPanelShakaiFukushiShokai().getTxtRiyoshaFutangakuTotal()
                .setValue(row.getDefaultDataName3().getValue());
        div.getPanelShafukukenngengaku().getPanelShakaiFukushiShokai().getTxtKengengaku()
                .setValue(row.getDefaultDataName4().getValue());
        div.getPanelShafukukenngengaku().getPanelShakaiFukushiShokai().getTxtKeigengoRiyoshaFutangaku()
                .setValue(row.getDefaultDataName5().getValue());
        div.getPanelShafukukenngengaku().getPanelShakaiFukushiShokai().getTxtBikou()
                .setValue(row.getDefaultDataName6());
        div.getPanelShafukukenngengaku().getRowId().setValue(new Decimal(row.getId()));
    }

    /**
     * initializeByDelete
     */
    public void initializeByDelete() {
        dgdShafukukeigenngaku_Row row = div.getPanelShafukukenngengaku().getDgdShafukukeigenngaku().getClickedItem();
        set選択行(row);
        setReadOnly();
    }

    /**
     * initializeByCalculation
     */
    public void initializeByCalculation() {
        Decimal kengengakuData = new Decimal(new Decimal(div.getPanelShafukukenngengaku().getPanelShakaiFukushiShokai()
                .getDdlKengenritsu().getSelectedValue().toString())
                .multiply(div.getPanelShafukukenngengaku().getPanelShakaiFukushiShokai().getTxtRiyoshaFutangakuTotal()
                        .getValue()).intValue());
        div.getPanelShafukukenngengaku().getPanelShakaiFukushiShokai().getTxtKengengaku().setValue(kengengakuData);
        Decimal keigengoRiyoshaFutangakuData = new Decimal(((div.getPanelShafukukenngengaku().getPanelShakaiFukushiShokai()
                .getTxtRiyoshaFutangakuTotal().getValue())
                .subtract(div.getPanelShafukukenngengaku().getPanelShakaiFukushiShokai().getTxtKengengaku().getValue()))
                .intValue());
        div.getPanelShafukukenngengaku().getPanelShakaiFukushiShokai().getTxtKeigengoRiyoshaFutangaku()
                .setValue(keigengoRiyoshaFutangakuData);
    }

    /**
     * initializeByClean
     */
    public void initializeByClean() {
        div.getPanelShafukukenngengaku().getPanelShakaiFukushiShokai().getDdlServiceShurui()
                .setSelectedIndex(0);
        div.getPanelShafukukenngengaku().getPanelShakaiFukushiShokai().getDdlKengenritsu()
                .setSelectedIndex(0);
        div.getPanelShafukukenngengaku().getPanelShakaiFukushiShokai().getTxtRiyoshaFutangakuTotal().clearValue();
        div.getPanelShafukukenngengaku().getPanelShakaiFukushiShokai().getTxtKengengaku().clearValue();
        div.getPanelShafukukenngengaku().getPanelShakaiFukushiShokai().getTxtKeigengoRiyoshaFutangaku().clearValue();
        div.getPanelShafukukenngengaku().getPanelShakaiFukushiShokai().getTxtBikou().clearValue();
    }

    /**
     * initializeByCancel
     */
    public void initializeByCancel() {
        div.getPanelShafukukenngengaku().getPanelShakaiFukushiShokai().getDdlServiceShurui()
                .setSelectedIndex(0);
        div.getPanelShafukukenngengaku().getPanelShakaiFukushiShokai().getDdlKengenritsu()
                .setSelectedIndex(0);
        div.getPanelShafukukenngengaku().getPanelShakaiFukushiShokai().getTxtRiyoshaFutangakuTotal().clearValue();
        div.getPanelShafukukenngengaku().getPanelShakaiFukushiShokai().getTxtKengengaku().clearValue();
        div.getPanelShafukukenngengaku().getPanelShakaiFukushiShokai().getTxtKeigengoRiyoshaFutangaku().clearValue();
        div.getPanelShafukukenngengaku().getPanelShakaiFukushiShokai().getTxtBikou().clearValue();
        div.getPanelShafukukenngengaku().getPanelShakaiFukushiShokai().setVisible(false);
    }

    /**
     * getSelectedRow
     *
     * @return dgdShafukukeigenngaku_Row row
     */
    public dgdShafukukeigenngaku_Row getSelectedRow() {
        return div.getPanelShafukukenngengaku().getDgdShafukukeigenngaku().getDataSource()
                .get(Integer.parseInt(div.getPanelShafukukenngengaku().getRowId().getValue().toString()));
    }

    /**
     * initializeByConfirm
     *
     * @param state RString
     */
    public void initializeByConfirm(RString state) {
        Boolean checkFlag = false;
        if (修正.equals(state)) {
            checkFlag = serviceChange(checkFlag);
            if (checkFlag) {
                RString selectValue = div.getPanelShafukukenngengaku().getDdlServiceShurui().getSelectedValue();
                throw new ApplicationException(UrErrorMessages.既に登録済.getMessage().replace(selectValue.toString()));
            }
            dgdShafukukeigenngaku_Row row = getSelectedRow();
            Boolean 変更チェックFlag = 変更チェック(row);
            dgdShafukukeigenngaku修正(変更チェックFlag, row);
            initializeByClean();
            div.getPanelShafukukenngengaku().getPanelShakaiFukushiShokai().setVisible(false);
        } else if (削除.equals(state)) {
            dgdShafukukeigenngaku_Row row = getSelectedRow();
            if (RowState.Added.equals(row.getRowState())) {
                div.getPanelShafukukenngengaku().getDgdShafukukeigenngaku().getDataSource().remove(row);
            } else {
                dgdShafukukeigenngaku削除(row);
            }
            initializeByClean();
            div.getPanelShafukukenngengaku().getPanelShakaiFukushiShokai().setVisible(false);
        } else if (登録.equals(state)) {
            RString serviceValue = div.getPanelShafukukenngengaku().getDdlServiceShurui().getSelectedValue();
            for (dgdShafukukeigenngaku_Row row : div.getPanelShafukukenngengaku().getDgdShafukukeigenngaku()
                    .getDataSource()) {
                if (serviceValue.equals(row.getDefaultDataName1())) {
                    checkFlag = true;
                    break;
                }
            }
            if (checkFlag) {
                throw new ApplicationException(UrErrorMessages.既に登録済.getMessage().replace(serviceValue.toString()));
            }
            dgdShafukukeigenngaku_Row newRow = new dgdShafukukeigenngaku_Row();
            newRow.setRowState(RowState.Added);
            newRow.setDefaultDataName1(div.getPanelShafukukenngengaku().getPanelShakaiFukushiShokai()
                    .getDdlServiceShurui().getSelectedValue());
            newRow.setDefaultDataName2(div.getPanelShafukukenngengaku().getPanelShakaiFukushiShokai()
                    .getDdlKengenritsu().getSelectedValue());
            newRow.getDefaultDataName3().setValue(div.getPanelShafukukenngengaku().getPanelShakaiFukushiShokai()
                    .getTxtRiyoshaFutangakuTotal().getValue());
            newRow.getDefaultDataName4().setValue(div.getPanelShafukukenngengaku().getPanelShakaiFukushiShokai()
                    .getTxtKengengaku().getValue());
            newRow.getDefaultDataName5().setValue(div.getPanelShafukukenngengaku().getPanelShakaiFukushiShokai()
                    .getTxtKeigengoRiyoshaFutangaku().getValue());
            newRow.setDefaultDataName6(div.getPanelShafukukenngengaku().getPanelShakaiFukushiShokai()
                    .getTxtBikou().getValue());
            div.getPanelShafukukenngengaku().getDgdShafukukeigenngaku().getDataSource().add(newRow);
            initializeByClean();
            div.getPanelShafukukenngengaku().getPanelShakaiFukushiShokai().setVisible(false);
        }
    }

    private void dgdShafukukeigenngaku削除(dgdShafukukeigenngaku_Row row) {
        if (RowState.Added.equals(row.getRowState())) {
            row.setRowState(RowState.Added);
        } else {
            row.setRowState(RowState.Deleted);
        }
    }

    private void dgdShafukukeigenngaku修正(Boolean 変更チェックFlag, dgdShafukukeigenngaku_Row row) {
        if (変更チェックFlag) {
            if (RowState.Added.equals(row.getRowState())) {
                row.setRowState(RowState.Added);
                row.setDefaultDataName1(div.getPanelShafukukenngengaku().getPanelShakaiFukushiShokai()
                        .getDdlServiceShurui().getSelectedValue());
                row.setDefaultDataName2(div.getPanelShafukukenngengaku().getPanelShakaiFukushiShokai()
                        .getDdlKengenritsu().getSelectedValue());
                row.getDefaultDataName3().setValue(div.getPanelShafukukenngengaku().getPanelShakaiFukushiShokai()
                        .getTxtRiyoshaFutangakuTotal().getValue());
                row.getDefaultDataName4().setValue(div.getPanelShafukukenngengaku().getPanelShakaiFukushiShokai()
                        .getTxtKengengaku().getValue());
                row.getDefaultDataName5().setValue(div.getPanelShafukukenngengaku().getPanelShakaiFukushiShokai()
                        .getTxtKeigengoRiyoshaFutangaku().getValue());
                row.setDefaultDataName6(div.getPanelShafukukenngengaku().getPanelShakaiFukushiShokai()
                        .getTxtBikou().getValue());
            } else {
                row.setRowState(RowState.Modified);
                row.setDefaultDataName1(div.getPanelShafukukenngengaku().getPanelShakaiFukushiShokai()
                        .getDdlServiceShurui().getSelectedValue());
                row.setDefaultDataName2(div.getPanelShafukukenngengaku().getPanelShakaiFukushiShokai()
                        .getDdlKengenritsu().getSelectedValue());
                row.getDefaultDataName3().setValue(div.getPanelShafukukenngengaku().getPanelShakaiFukushiShokai()
                        .getTxtRiyoshaFutangakuTotal().getValue());
                row.getDefaultDataName4().setValue(div.getPanelShafukukenngengaku().getPanelShakaiFukushiShokai()
                        .getTxtKengengaku().getValue());
                row.getDefaultDataName5().setValue(div.getPanelShafukukenngengaku().getPanelShakaiFukushiShokai()
                        .getTxtKeigengoRiyoshaFutangaku().getValue());
                row.setDefaultDataName6(div.getPanelShafukukenngengaku().getPanelShakaiFukushiShokai()
                        .getTxtBikou().getValue());
            }
        }
    }

    private Boolean serviceChange(Boolean checkFlag) {
        Integer id = div.getPanelShafukukenngengaku().getRowId().getValue().intValue();
        RString serviceValue = div.getPanelShafukukenngengaku().getDdlServiceShurui().getSelectedValue();
        for (dgdShafukukeigenngaku_Row row : div.getPanelShafukukenngengaku().getDgdShafukukeigenngaku()
                .getDataSource()) {
            if (id != row.getId() && serviceValue.equals(row.getDefaultDataName1())) {
                checkFlag = true;
                break;
            }
        }
        return checkFlag;
    }

    /**
     * get内容変更状態
     *
     * @return boolean
     */
    public boolean is内容変更状態() {
        for (dgdShafukukeigenngaku_Row ddgList : div.getPanelShafukukenngengaku().getDgdShafukukeigenngaku()
                .getDataSource()) {
            if (RowState.Modified.equals(ddgList.getRowState())
                    || RowState.Added.equals(ddgList.getRowState())
                    || RowState.Deleted.equals(ddgList.getRowState())) {
                return true;
            }
        }
        return false;
    }

    /**
     * 内容の破棄
     *
     * @param list List<ShokanShakaiFukushiHojinKeigengakuResult>
     */
    public void 内容の破棄(List<ShokanShakaiFukushiHojinKeigengakuResult> list) {
        initialize(list);
    }

    /**
     * 削除Save
     *
     * @param meisaiPar ShoukanharaihishinseimeisaikensakuParameter
     */
    public void 削除Save(ShoukanharaihishinseimeisaikensakuParameter meisaiPar) {
        HihokenshaNo 被保険者番号 = meisaiPar.get被保険者番号();
        FlexibleYearMonth サービス年月 = meisaiPar.getサービス年月();
        RString 整理番号 = meisaiPar.get整理番号();
        JigyoshaNo 事業者番号 = meisaiPar.get事業者番号();
        RString 様式番号 = meisaiPar.get様式番号();
        RString 明細番号 = meisaiPar.get明細番号();
        SyokanbaraihiShikyuShinseiKetteManager.createInstance().delShokanSyomeisyo(被保険者番号, サービス年月,
                整理番号, 事業者番号, 様式番号, 明細番号);
    }

    /**
     * 登録Save
     *
     * @param meisaiPar ShoukanharaihishinseimeisaikensakuParameter
     * @param hojinKeigengakuEntityList List<ShokanShakaiFukushiHojinKeigengakuResult>
     */
    public void 登録Save(ShoukanharaihishinseimeisaikensakuParameter meisaiPar,
            List<ShokanShakaiFukushiHojinKeigengakuResult> hojinKeigengakuEntityList) {
        HihokenshaNo 被保険者番号 = meisaiPar.get被保険者番号();
        FlexibleYearMonth サービス年月 = meisaiPar.getサービス年月();
        JigyoshaNo 事業者番号 = meisaiPar.get事業者番号();
        RString 様式番号 = meisaiPar.get様式番号();
        RString 明細番号 = meisaiPar.get明細番号();
        int max連番 = 0;
        List<ShokanShakaiFukushiHojinKeigengaku> entityList1 = new ArrayList<>();
        Map<RString, ShokanShakaiFukushiHojinKeigengaku> map = new HashMap<>();
        for (ShokanShakaiFukushiHojinKeigengakuResult entityModified : hojinKeigengakuEntityList) {
            map.put(entityModified.getShokanShakai().get連番(),
                    entityModified.getShokanShakai());
            if (max連番 < Integer.valueOf(entityModified.getShokanShakai().get連番().toString())) {
                max連番 = Integer.valueOf(entityModified.getShokanShakai().get連番().toString());
            }
        }
        for (dgdShafukukeigenngaku_Row row : div.getPanelShafukukenngengaku().getDgdShafukukeigenngaku()
                .getDataSource()) {
            if (RowState.Modified.equals(row.getRowState())) {
                ShokanShakaiFukushiHojinKeigengaku entityModified = map.get(row.getDefaultDataName7());
                entityModified = buildModified(entityModified, row);
                entityList1.add(entityModified.modifiedModel());
            } else if (RowState.Deleted.equals(row.getRowState())) {
                ShokanShakaiFukushiHojinKeigengaku entityDeleted = map.get(row.getDefaultDataName7());
                entityDeleted = entityDeleted.deleted();
                entityList1.add(entityDeleted);
            } else if (RowState.Added.equals(row.getRowState())) {
                max連番 = max連番 + 1;
                RString 整理番号 = Saiban.get(SubGyomuCode.DBC介護給付, SaibanHanyokeyName.償還整理番号.getコード()).
                        nextString();
                ShokanShakaiFukushiHojinKeigengaku entityAdded = new ShokanShakaiFukushiHojinKeigengaku(
                        被保険者番号,
                        サービス年月,
                        整理番号,
                        事業者番号,
                        様式番号,
                        明細番号,
                        new RString(String.valueOf(max連番)).padZeroToLeft(2)).createBuilderForEdit().build();
                entityAdded = buildAdded(entityAdded, row);
                entityList1.add(entityAdded);
            }
        }
        SyokanbaraihiShikyuShinseiKetteManager.createInstance().updShokanShakaiFukushiHojinKeigengaku(entityList1);

    }

    private ShokanShakaiFukushiHojinKeigengaku buildModified(ShokanShakaiFukushiHojinKeigengaku entity,
            dgdShafukukeigenngaku_Row row) {
        entity = entity.createBuilderForEdit()
                .setサービス種類コード(new ServiceShuruiCode(row.getDefaultDataName1()))
                .set軽減率(new Decimal(row.getDefaultDataName2().toString()))
                .set受領すべき利用者負担の総額(row.getDefaultDataName3().getValue().intValue())
                .set軽減額(row.getDefaultDataName4().getValue().intValue())
                .set軽減後利用者負担額(row.getDefaultDataName5().getValue().intValue())
                .set備考(row.getDefaultDataName6())
                .build();
        return entity;
    }

    private ShokanShakaiFukushiHojinKeigengaku buildAdded(ShokanShakaiFukushiHojinKeigengaku entity,
            dgdShafukukeigenngaku_Row row) {
        if (!row.getDefaultDataName1().isEmpty()) {
            entity = entity.createBuilderForEdit()
                    .setサービス種類コード(new ServiceShuruiCode(row.getDefaultDataName1())).build();
        }
        if (!row.getDefaultDataName2().isEmpty()) {
            entity = entity.createBuilderForEdit()
                    .set軽減率(new Decimal(row.getDefaultDataName2().toString())).build();
        }
        if (row.getDefaultDataName3().getValue() != null) {
            entity = entity.createBuilderForEdit()
                    .set受領すべき利用者負担の総額(row.getDefaultDataName3().getValue().intValue()).build();
        }
        if (row.getDefaultDataName4().getValue() != null) {
            entity = entity.createBuilderForEdit()
                    .set軽減額(row.getDefaultDataName4().getValue().intValue()).build();
        }
        if (row.getDefaultDataName5().getValue() != null) {
            entity = entity.createBuilderForEdit()
                    .set軽減後利用者負担額(row.getDefaultDataName5().getValue().intValue()).build();
        }
        if (!row.getDefaultDataName6().isEmpty()) {
            entity = entity.createBuilderForEdit()
                    .set備考(row.getDefaultDataName6()).build();
        }
        return entity;
    }

    private Boolean 変更チェック(dgdShafukukeigenngaku_Row row) {
        Boolean flag = false;
        if (!row.getDefaultDataName1().equals(div.getPanelShafukukenngengaku().getDdlServiceShurui().getSelectedValue())) {
            flag = true;
        }
        if (!row.getDefaultDataName2().equals(div.getPanelShafukukenngengaku().getDdlKengenritsu().getSelectedValue())) {
            flag = true;
        }
        if (!row.getDefaultDataName3().getValue().equals(div.getTxtRiyoshaFutangakuTotal().getValue())) {
            flag = true;
        }
        if (!row.getDefaultDataName4().getValue().equals(div.getTxtKengengaku().getValue())) {
            flag = true;
        }
        if (!row.getDefaultDataName5().getValue().equals(div.getTxtKeigengoRiyoshaFutangaku().getValue())) {
            flag = true;
        }
        if (!row.getDefaultDataName6().equals(div.getTxtBikou().getValue())) {
            flag = true;
        }
        return flag;
    }

    private void setReadOnly() {
        div.getDdlServiceShurui().setReadOnly(true);
        div.getDdlKengenritsu().setReadOnly(true);
        div.getTxtRiyoshaFutangakuTotal().setReadOnly(true);
        div.getTxtKengengaku().setReadOnly(true);
        div.getTxtKeigengoRiyoshaFutangaku().setReadOnly(true);
        div.getTxtBikou().setReadOnly(true);
    }

    private void setNotReadOnly() {
        div.getDdlServiceShurui().setReadOnly(false);
        div.getDdlKengenritsu().setReadOnly(false);
        div.getTxtRiyoshaFutangakuTotal().setReadOnly(false);
        div.getTxtKengengaku().setReadOnly(false);
        div.getTxtKeigengoRiyoshaFutangaku().setReadOnly(false);
        div.getTxtBikou().setReadOnly(false);
    }
}
