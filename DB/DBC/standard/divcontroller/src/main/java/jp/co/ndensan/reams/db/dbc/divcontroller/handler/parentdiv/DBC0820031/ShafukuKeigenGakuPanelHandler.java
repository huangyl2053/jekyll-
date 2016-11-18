/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0820031;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShikibetsuNoKanri;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShokanShakaiFukushiHojinKeigengaku;
import jp.co.ndensan.reams.db.dbc.business.core.shokanbaraijyokyoshokai.ShokanShakaiFukushiHojinKeigengakuResult;
import jp.co.ndensan.reams.db.dbc.business.core.syokanbaraihishikyushinseikette.ShafukukeigenServiceResult;
import jp.co.ndensan.reams.db.dbc.definition.core.shoukanharaihishinseikensaku.ShoukanharaihishinseimeisaikensakuParameter;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0820031.ShafukuKeigenGakuPanelDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0820031.dgdShafukukeigenngaku_Row;
import jp.co.ndensan.reams.db.dbc.service.core.syokanbaraihishikyushinseikette.SyokanbaraihiShikyuShinseiKetteManager;
import jp.co.ndensan.reams.db.dbd.business.core.basic.ShakaiFukushiHojinRiyoshaFutanKeigen;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;
import jp.co.ndensan.reams.uz.uza.ui.binding.RowState;
import jp.co.ndensan.reams.uz.uza.ui.binding.propertyenum.IconName;
import jp.co.ndensan.reams.uz.uza.ui.servlets.CommonButtonHolder;

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
    private static final RString 確定する = new RString("Element1");

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
     * @param 法人軽減額リスト List<ShokanShakaiFukushiHojinKeigengakuResult>
     * @param 識別コード 識別コード
     * @param 被保険者番号 被保険者番号
     * @param サービス年月 サービス年月
     * @param 申請日 申請日
     * @param 事業者番号 事業者番号
     * @param 様式番号 様式番号
     * @param 明細番号 明細番号
     */
    public void initialize(List<ShokanShakaiFukushiHojinKeigengakuResult> 法人軽減額リスト, ShikibetsuCode 識別コード,
            HihokenshaNo 被保険者番号, FlexibleYearMonth サービス年月, RDate 申請日, JigyoshaNo 事業者番号, RString 様式番号, RString 明細番号) {
        initialize法人軽減額リスト(法人軽減額リスト);

        div.getPanelCcd().getCcdKaigoShikakuKihon().initialize(被保険者番号);
        div.getPanelHead().getTxtServiceTeikyoYM().setValue(new RDate(サービス年月.getYearValue(), サービス年月.getMonthValue(), 1));
        div.getPanelHead().getTxtShinseiYMD().setValue(申請日);
        div.getPanelHead().getTxtJigyoshaBango().setValue(事業者番号.getColumnValue());
        div.getPanelHead().getTxtMeisaiBango().setValue(明細番号);
        div.getPanelHead().getTxtShomeisho().setValue(様式番号);
        div.getPanelCcd().getCcdKaigoAtenaInfo().initialize(識別コード);
        div.getPanelShafukukenngengaku().getPanelShakaiFukushiShokai().setIsOpen(false);
    }

    private void initialize法人軽減額リスト(List<ShokanShakaiFukushiHojinKeigengakuResult> 法人軽減額リスト) {
        if (法人軽減額リスト.isEmpty()) {
            return;
        }
        List<dgdShafukukeigenngaku_Row> rowList = new ArrayList<>();
        for (ShokanShakaiFukushiHojinKeigengakuResult hojinKeigengakuResult : 法人軽減額リスト) {
            ShokanShakaiFukushiHojinKeigengaku 法人軽減額 = hojinKeigengakuResult.getShokanShakai();
            dgdShafukukeigenngaku_Row row = new dgdShafukukeigenngaku_Row();
            if (null != 法人軽減額.toEntity().getState()) {
                switch (法人軽減額.toEntity().getState()) {
                    case Added:
                        row.setRowState(RowState.Added);
                        break;
                    case Modified:
                        row.setRowState(RowState.Modified);
                        break;
                    case Deleted:
                        row.setRowState(RowState.Deleted);
                        break;
                    default:
                        break;
                }
            }
            row.setDefaultDataName1(hojinKeigengakuResult.getServiceShuruiRyakusho());
            row.setDefaultDataName2(法人軽減額.get軽減率() == null ? RString.EMPTY : new RString(法人軽減額.get軽減率().toString()));
            row.getDefaultDataName3().setValue(new Decimal(法人軽減額.get受領すべき利用者負担の総額()));
            row.getDefaultDataName4().setValue(new Decimal(法人軽減額.get軽減額()));
            row.getDefaultDataName5().setValue(new Decimal(法人軽減額.get軽減後利用者負担額()));
            row.setDefaultDataName6(法人軽減額.get備考());
            row.setDefaultDataName7(法人軽減額.get連番());
            row.setServiceShuruiCode(法人軽減額.getサービス種類コード() == null ? RString.EMPTY : 法人軽減額.getサービス種類コード().value());
            rowList.add(row);
        }
        div.getPanelShafukukenngengaku().getDgdShafukukeigenngaku().setDataSource(rowList);
    }

    /**
     * 削除初期化
     */
    public void init_Delete() {
        div.getPanelShafukukenngengaku().getBtnAdd().setDisabled(true);
        div.getPanelShafukukenngengaku().getDgdShafukukeigenngaku().setReadOnly(true);
        div.getPanelShafukukenngengaku().getPanelShakaiFukushiShokai().setIsOpen(false);
        CommonButtonHolder.setDisplayNoneByCommonButtonFieldName(確定する, true);
    }

    /**
     * 法人軽減額リストを取得します。
     *
     * @param 被保険者番号 被保険者番号
     * @param サービス年月 サービス年月
     * @param 整理番号 整理番号
     * @param 申請日 申請日
     * @param 事業者番号 事業者番号
     * @param 様式番号 様式番号
     * @param 明細番号 明細番号
     * @return 法人軽減額リスト
     */
    public List<ShokanShakaiFukushiHojinKeigengakuResult> get法人軽減額リスト(HihokenshaNo 被保険者番号, FlexibleYearMonth サービス年月,
            RString 整理番号, RDate 申請日, JigyoshaNo 事業者番号, RString 様式番号, RString 明細番号) {
        List<ShokanShakaiFukushiHojinKeigengakuResult> 法人軽減額リスト = new ArrayList<>();
        for (dgdShafukukeigenngaku_Row row : div.getPanelShafukukenngengaku().getDgdShafukukeigenngaku().getDataSource()) {
            ShokanShakaiFukushiHojinKeigengaku 法人軽減額 = new ShokanShakaiFukushiHojinKeigengaku(
                    被保険者番号, サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号, row.getDefaultDataName7());
            法人軽減額 = 法人軽減額.createBuilderForEdit()
                    .setサービス種類コード(new ServiceShuruiCode(row.getServiceShuruiCode()))
                    .set軽減率(new Decimal(row.getDefaultDataName2().toString()))
                    .set受領すべき利用者負担の総額(row.getDefaultDataName3().getValue().intValue())
                    .set軽減額(row.getDefaultDataName4().getValue().intValue())
                    .set軽減後利用者負担額(row.getDefaultDataName5().getValue().intValue())
                    .set備考(row.getDefaultDataName6())
                    .build();
            if (null != row.getRowState()) {
                switch (row.getRowState()) {
                    case Added:
                        法人軽減額 = 法人軽減額.added();
                        break;
                    case Modified:
                        法人軽減額 = 法人軽減額.modifiedModel();
                        break;
                    case Deleted:
                        法人軽減額 = 法人軽減額.deleted();
                        break;
                    default:
                        break;
                }
            }
            ShokanShakaiFukushiHojinKeigengakuResult keigengakuResult
                    = new ShokanShakaiFukushiHojinKeigengakuResult(法人軽減額, row.getDefaultDataName1());
            法人軽減額リスト.add(keigengakuResult);
        }
        return 法人軽減額リスト;
    }

    /**
     * サービス種類DDLを設定する
     *
     * @param サービス種類リスト List<ShafukukeigenServiceResult>
     * @param 追加フラグ 追加フラグ
     */
    public void setサービス種類DDL(List<ShafukukeigenServiceResult> サービス種類リスト, boolean 追加フラグ) {
        List<KeyValueDataSource> サービス種類 = new ArrayList<>();
        if (追加フラグ) {
            サービス種類.add(new KeyValueDataSource(RString.EMPTY, RString.EMPTY));
        }
        for (ShafukukeigenServiceResult entity : サービス種類リスト) {
            サービス種類.add(new KeyValueDataSource(entity.getEntity().getServiceShuruiCode().getColumnValue(),
                    entity.getEntity().getServiceShuruiMeisho()));
        }
        div.getPanelShafukukenngengaku().getPanelShakaiFukushiShokai().getDdlServiceShurui().setDataSource(サービス種類);
    }

    /**
     * 軽減率DDLを設定する
     *
     * @param 軽減額リスト List<ShakaiFukushiHojinRiyoshaFutanKeigen>
     * @param 追加フラグ 追加フラグ
     */
    public void set軽減率DDL(List<ShakaiFukushiHojinRiyoshaFutanKeigen> 軽減額リスト, boolean 追加フラグ) {
        List<KeyValueDataSource> 軽減率リスト = new ArrayList<>();
        if (追加フラグ) {
            軽減率リスト.add(new KeyValueDataSource(RString.EMPTY, RString.EMPTY));
        }
        for (int i = 0; i < 軽減額リスト.size(); i++) {
            Decimal 軽減率分子 = 軽減額リスト.get(i).get軽減率分子();
            Decimal 軽減率分母 = 軽減額リスト.get(i).get軽減率分母();
            if (軽減率分子 != null && 軽減率分母 != null && !Decimal.ZERO.equals(軽減率分母)) {
                Decimal 軽減率 = 軽減率分子.divide(軽減率分母).roundHalfUpTo(1);
                軽減率リスト.add(new KeyValueDataSource(new RString(i), new RString(軽減率.toString())));
            }
        }
        div.getPanelShafukukenngengaku().getPanelShakaiFukushiShokai().getDdlKengenritsu().setDataSource(軽減率リスト);
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
    public void initializeByAdd() {
        div.getPanelShafukukenngengaku().getPanelShakaiFukushiShokai().setIsOpen(true);
        initializeByClean();
        setNotReadOnly();
    }

    /**
     * initializeByModify
     */
    public void initializeByModify() {
        set選択行();
        setNotReadOnly();
    }

    /**
     * initializeByDelete
     */
    public void initializeByDelete() {
        set選択行();
        setReadOnly();
    }

    private void set選択行() {
        div.getPanelShafukukenngengaku().getPanelShakaiFukushiShokai().setIsOpen(true);
        dgdShafukukeigenngaku_Row row = div.getPanelShafukukenngengaku().getDgdShafukukeigenngaku().getClickedItem();
        div.getPanelShafukukenngengaku().getPanelShakaiFukushiShokai().getDdlServiceShurui()
                .setSelectedKey(row.getServiceShuruiCode());
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
        div.getPanelShafukukenngengaku().getRowId().setValue(new Decimal(row.getDefaultDataName7().toString()));
    }

    /**
     * initializeByCalculation
     */
    public void initializeByCalculation() {
        if (!RString.isNullOrEmpty(div.getPanelShafukukenngengaku().getPanelShakaiFukushiShokai().getDdlKengenritsu().getSelectedValue())
                && div.getPanelShafukukenngengaku().getPanelShakaiFukushiShokai().getTxtRiyoshaFutangakuTotal().getValue() != null) {
            Decimal 軽減額 = div.getPanelShafukukenngengaku().getPanelShakaiFukushiShokai().getTxtRiyoshaFutangakuTotal().getValue()
                    .multiply(new Decimal(div.getPanelShafukukenngengaku().getPanelShakaiFukushiShokai()
                            .getDdlKengenritsu().getSelectedValue().toString()));
            div.getPanelShafukukenngengaku().getPanelShakaiFukushiShokai().getTxtKengengaku().setValue(軽減額);

            Decimal 軽減後利用者負担額 = div.getPanelShafukukenngengaku().getPanelShakaiFukushiShokai().getTxtRiyoshaFutangakuTotal().getValue()
                    .subtract(軽減額);
            div.getPanelShafukukenngengaku().getPanelShakaiFukushiShokai().getTxtKeigengoRiyoshaFutangaku().setValue(軽減後利用者負担額);
        } else {
            div.getPanelShafukukenngengaku().getPanelShakaiFukushiShokai().getTxtKengengaku().clearValue();
            div.getPanelShafukukenngengaku().getPanelShakaiFukushiShokai().getTxtKeigengoRiyoshaFutangaku().clearValue();
        }
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
        div.getPanelShafukukenngengaku().getPanelShakaiFukushiShokai().setIsOpen(false);
    }

    /**
     * initializeByConfirm
     *
     * @param state RString
     * @param 法人軽減額リスト List<ShokanShakaiFukushiHojinKeigengakuResult>
     * @param サービス種類リスト List<ShafukukeigenServiceResult>
     */
    public void initializeByConfirm(RString state, List<ShokanShakaiFukushiHojinKeigengakuResult> 法人軽減額リスト,
            List<ShafukukeigenServiceResult> サービス種類リスト) {
        if (修正.equals(state)) {
            checkサービス種類重複For修正();
            boolean 変更チェックFlag = 変更チェック(法人軽減額リスト);
            dgdShafukukeigenngaku修正(変更チェックFlag, サービス種類リスト);
        } else if (削除.equals(state)) {
            dgdShafukukeigenngaku削除();
        } else if (登録.equals(state)) {
            checkサービス種類重複For登録();
            dgdShafukukeigenngaku登録(サービス種類リスト);
        }
        initializeByClean();
        div.getPanelShafukukenngengaku().getPanelShakaiFukushiShokai().setIsOpen(false);
    }

    private void dgdShafukukeigenngaku削除() {
        dgdShafukukeigenngaku_Row row = getSelectedRow();
        if (RowState.Added == row.getRowState()) {
            div.getPanelShafukukenngengaku().getDgdShafukukeigenngaku().getDataSource().remove(row);
            reset連番();
        } else {
            row.setRowState(RowState.Deleted);
        }
    }

    private void reset連番() {
        List<dgdShafukukeigenngaku_Row> shafukukeigenngakuRows = div.getPanelShafukukenngengaku().getDgdShafukukeigenngaku().getDataSource();
        if (shafukukeigenngakuRows == null || shafukukeigenngakuRows.isEmpty()) {
            return;
        }
        for (int i = shafukukeigenngakuRows.size(); i > 0; i--) {
            dgdShafukukeigenngaku_Row row = shafukukeigenngakuRows.get(i - 1);
            if (RowState.Added == row.getRowState()) {
                row.setDefaultDataName7(new RString(shafukukeigenngakuRows.size() + 1 - i));
            }
        }
    }

    private void dgdShafukukeigenngaku修正(boolean 変更チェックFlag, List<ShafukukeigenServiceResult> サービス種類リスト) {
        dgdShafukukeigenngaku_Row row = getSelectedRow();
        if (変更チェックFlag) {
            if (RowState.Added != row.getRowState()) {
                row.setRowState(RowState.Modified);
            }
        } else {
            row.setRowState(RowState.Unchanged);
        }
        row.setDefaultDataName1(getサービス種類略称(サービス種類リスト));
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
        row.setServiceShuruiCode(div.getPanelShafukukenngengaku().getPanelShakaiFukushiShokai()
                .getDdlServiceShurui().getSelectedKey());
    }

    private void dgdShafukukeigenngaku登録(List<ShafukukeigenServiceResult> サービス種類リスト) {
        dgdShafukukeigenngaku_Row newRow = new dgdShafukukeigenngaku_Row();
        newRow.setRowState(RowState.Added);
        newRow.setDefaultDataName1(getサービス種類略称(サービス種類リスト));
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
        newRow.setDefaultDataName7(new RString(Integer.parseInt(div.getPanelShafukukenngengaku().getDgdShafukukeigenngaku()
                .getDataSource().get(0).getDefaultDataName7().toString()) + 1));
        newRow.setServiceShuruiCode(div.getPanelShafukukenngengaku().getPanelShakaiFukushiShokai()
                .getDdlServiceShurui().getSelectedKey());
        div.getPanelShafukukenngengaku().getDgdShafukukeigenngaku().getDataSource().add(0, newRow);
    }

    private RString getサービス種類略称(List<ShafukukeigenServiceResult> サービス種類リスト) {
        RString サービス種類コード = div.getPanelShafukukenngengaku().getPanelShakaiFukushiShokai()
                .getDdlServiceShurui().getSelectedKey();
        for (ShafukukeigenServiceResult serviceResult : サービス種類リスト) {
            if (サービス種類コード.equals(serviceResult.getEntity().getServiceShuruiCode().getColumnValue())) {
                return serviceResult.getEntity().getServiceShuruiRyakusho();
            }
        }
        return RString.EMPTY;
    }

    private void checkサービス種類重複For修正() {
        RString rowNo = new RString(div.getPanelShafukukenngengaku().getRowId().getValue().intValue());
        RString サービス種類コード = div.getPanelShafukukenngengaku().getDdlServiceShurui().getSelectedKey();
        for (dgdShafukukeigenngaku_Row row : div.getPanelShafukukenngengaku().getDgdShafukukeigenngaku().getDataSource()) {
            if (!row.getDefaultDataName7().equals(rowNo) && サービス種類コード.equals(row.getServiceShuruiCode())) {
                throw new ApplicationException(UrErrorMessages.既に登録済.getMessage().
                        replace(div.getPanelShafukukenngengaku().getDdlServiceShurui().getSelectedValue().toString()));
            }
        }
    }

    private void checkサービス種類重複For登録() {
        RString サービス種類コード = div.getPanelShafukukenngengaku().getDdlServiceShurui().getSelectedKey();
        for (dgdShafukukeigenngaku_Row row : div.getPanelShafukukenngengaku().getDgdShafukukeigenngaku().getDataSource()) {
            if (サービス種類コード.equals(row.getServiceShuruiCode())) {
                throw new ApplicationException(UrErrorMessages.既に登録済.getMessage().
                        replace(div.getPanelShafukukenngengaku().getDdlServiceShurui().getSelectedValue().toString()));
            }
        }
    }

    private dgdShafukukeigenngaku_Row getSelectedRow() {
        RString rowId = new RString(div.getPanelShafukukenngengaku().getRowId().getValue().toString());
        for (dgdShafukukeigenngaku_Row row : div.getPanelShafukukenngengaku().getDgdShafukukeigenngaku().getDataSource()) {
            if (rowId.equals(row.getDefaultDataName7())) {
                return row;
            }
        }
        return null;
    }

    /**
     * get内容変更状態
     *
     * @return boolean
     */
    public boolean is内容変更状態() {
        for (dgdShafukukeigenngaku_Row ddgList : div.getPanelShafukukenngengaku().getDgdShafukukeigenngaku()
                .getDataSource()) {
            if (RowState.Modified == ddgList.getRowState()
                    || RowState.Added == ddgList.getRowState()
                    || RowState.Deleted == ddgList.getRowState()) {
                return true;
            }
        }
        return false;
    }

    /**
     * 受領すべき利用者負担の総額の総額を設定します。
     *
     * @param サービス種類集計情報 List<ShafukukeigenServiceResult>
     */
    public void set受領すべき利用者負担の総額(List<ShafukukeigenServiceResult> サービス種類集計情報) {
        RString コード = div.getPanelShafukukenngengaku().getDdlServiceShurui().getSelectedKey();
        for (ShafukukeigenServiceResult entity : サービス種類集計情報) {
            if (コード.equals(entity.getEntity().getServiceShuruiCode().getColumnValue())) {
                div.getPanelShafukukenngengaku().getTxtRiyoshaFutangakuTotal()
                        .setValue(new Decimal(entity.getEntity().getRiyoshaFutangaku()));
                return;
            }
        }
        div.getPanelShafukukenngengaku().getTxtRiyoshaFutangakuTotal().clearValue();
    }

    private boolean 変更チェック(List<ShokanShakaiFukushiHojinKeigengakuResult> 法人軽減額リスト) {
        RString rowNo = new RString(div.getPanelShafukukenngengaku().getRowId().getValue().intValue());
        for (ShokanShakaiFukushiHojinKeigengakuResult hojinKeigengakuResult : 法人軽減額リスト) {
            ShokanShakaiFukushiHojinKeigengaku 法人軽減額 = hojinKeigengakuResult.getShokanShakai();
            if (法人軽減額.get連番().equals(rowNo)) {
                return !法人軽減額.getサービス種類コード().getColumnValue().equals(div.getPanelShafukukenngengaku().getDdlServiceShurui().getSelectedKey())
                        || !法人軽減額.get軽減率().equals(new Decimal(div.getPanelShafukukenngengaku().getDdlKengenritsu().getSelectedValue().toString()))
                        || !new Decimal(法人軽減額.get受領すべき利用者負担の総額()).equals(div.getTxtRiyoshaFutangakuTotal().getValue())
                        || !new Decimal(法人軽減額.get軽減額()).equals(div.getTxtKengengaku().getValue())
                        || !new Decimal(法人軽減額.get軽減後利用者負担額()).equals(div.getTxtKeigengoRiyoshaFutangaku().getValue())
                        || !法人軽減額.get備考().equals(div.getTxtBikou().getValue());
            }
        }
        return true;
    }

    private void setReadOnly() {
        div.getDdlServiceShurui().setReadOnly(true);
        div.getDdlKengenritsu().setReadOnly(true);
        div.getTxtKengengaku().setReadOnly(true);
        div.getTxtKeigengoRiyoshaFutangaku().setReadOnly(true);
        div.getTxtBikou().setReadOnly(true);
    }

    private void setNotReadOnly() {
        div.getDdlServiceShurui().setReadOnly(false);
        div.getDdlKengenritsu().setReadOnly(false);
        div.getTxtKengengaku().setReadOnly(false);
        div.getTxtKeigengoRiyoshaFutangaku().setReadOnly(false);
        div.getTxtBikou().setReadOnly(false);
    }

}
