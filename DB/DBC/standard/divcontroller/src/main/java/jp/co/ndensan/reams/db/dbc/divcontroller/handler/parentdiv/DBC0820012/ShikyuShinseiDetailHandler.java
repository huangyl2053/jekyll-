/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0820012;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbd.business.core.basic.ShokanHanteiKekka;
import jp.co.ndensan.reams.db.dbd.business.core.basic.ShokanShinsei;
import jp.co.ndensan.reams.db.dbc.business.core.syokanbaraihishikyushinseikette.KyufujissekiKihonResult;
import jp.co.ndensan.reams.db.dbc.definition.core.kyufujissekikubun.KyufuJissekiKubun;
import jp.co.ndensan.reams.db.dbc.definition.core.shikyufushikyukubun.ShikyuFushikyuKubun;
import jp.co.ndensan.reams.db.dbc.definition.core.shikyushinseishinsa.ShikyushinseiShinsaKubun;
import jp.co.ndensan.reams.db.dbc.definition.core.shinsahoho.ShinsaHohoKubun;
import jp.co.ndensan.reams.db.dbc.definition.core.shinseisha.ShinseishaKubun;
import jp.co.ndensan.reams.db.dbc.definition.message.DbcErrorMessages;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0820012.ShikyuShinseiDetailDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0820012.pnlShinseiDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.viewbox.dbc0820012.ShikyuShinseiDetailParameter;
import jp.co.ndensan.reams.db.dbc.service.core.shokanbaraijyokyoshokai.ShokanbaraiJyokyoShokai;
import jp.co.ndensan.reams.db.dbc.service.core.syokanbaraihishikyushinseikette.SyokanbaraihiShikyuShinseiKetteFath;
import jp.co.ndensan.reams.db.dbc.service.core.syokanbaraihishikyushinseikette.SyokanbaraihiShikyuShinseiKetteManager;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBC;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RYearMonth;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 償還払支給申請の支給申請を登録する画面のHandler
 *
 * @reamsid_L DBC-1030-160 xupeng
 */
public final class ShikyuShinseiDetailHandler {

    private final ShikyuShinseiDetailDiv div;
    private static final RString MODEL_ADD = new RString("新規");
    private static final RString 登録モード = new RString("登録");
    private static final RString MODEL_UPD = new RString("修正");
    private static final RString MODEL_DEL = new RString("削除");
    private static final RString 受託あり = new RString("2");
    private static final RString 受託なし = new RString("1");
    private static final RString 整理番号_ADD = new RString("0000");
    private static final RString 証記載保険者番号 = new RString("000011");

    /**
     * コンストラクタです。
     *
     * @param div 償還払支給申請の支給申請Div
     */
    private ShikyuShinseiDetailHandler(ShikyuShinseiDetailDiv div) {
        this.div = div;
    }

    /**
     * 生成されたインタフェースを返します
     *
     * @param div 償還払支給申請の支給申請Div
     * @return ShikyuShinseiDetailHandler
     */
    public static ShikyuShinseiDetailHandler of(ShikyuShinseiDetailDiv div) {
        return new ShikyuShinseiDetailHandler(div);
    }

    /**
     * 介護宛名情報のデータをロードする。
     *
     * @param 識別コード ShikibetsuCode
     */
    public void load介護宛名情報(ShikibetsuCode 識別コード) {
        div.getPanelUp().getCcdKaigoAtenaInfo().initialize(識別コード);
    }

    /**
     * 介護資格系基本情報のデータをロードする。
     *
     * @param 識別コード ShikibetsuCode
     */
    public void load介護資格系基本情報(ShikibetsuCode 識別コード) {
        div.getPanelUp().getCcdKaigoShikakuKihon().initialize(識別コード);
    }

    /**
     * 支給申請一覧情報をロードする。
     *
     * @param 被保険者番号 被保険者番号
     * @param サービス年月 サービス年月
     * @param 整理番号 整理番号
     * @param 画面モード 画面モード
     * @param 国保連共同処理受託区分_償還 RString
     * @return ShokanShinsei 支給申請一覧情報
     */
    public ShokanShinsei load支給申請一覧情報(
            HihokenshaNo 被保険者番号, FlexibleYearMonth サービス年月,
            RString 整理番号, RString 画面モード, RString 国保連共同処理受託区分_償還) {
        div.getPanelHead().getTxtShoriMode().setValue(画面モード);

        if (MODEL_ADD.equals(画面モード)) {
            if (受託なし.equals(国保連共同処理受託区分_償還)) {
                div.getPanelHead().getBtnShokanBaraiKeteiInfo().setDisabled(false);
            } else if (受託あり.equals(国保連共同処理受託区分_償還)) {
                div.getPanelHead().getBtnShokanBaraiKeteiInfo().setDisabled(true);
            }
            div.getPanelHead().getTxtSeiribango().setValue(整理番号);
            div.getPanelHead().getTxtServiceTeikyoYM().setValue(new RDate(サービス年月.toString()));
            //TODO ビジネス設計_DBCKD00007_(共有子Div)受給者異動連絡票（画面）.xlsx の[証記載保険者番号と広域保険者番号取得]シート機能未開発
            div.getPnlShinsei().getTxtKisaiHokensyaBango().setValue(証記載保険者番号);
            div.getPnlShinsei().getChkKokuhorenSaiso().setVisible(false);
            return null;
        }

        List<ShokanShinsei> 支給申請一覧情報リスト = InstanceProvider.create(ShokanbaraiJyokyoShokai.class)
                .getShokanbaraiShinseiJyohoDetail(被保険者番号, サービス年月, 整理番号);
        if (支給申請一覧情報リスト.isEmpty()) {
            return new ShokanShinsei(被保険者番号, サービス年月, 整理番号);
        }
        return 支給申請一覧情報リスト.get(0);
    }

    /**
     * 支給申請一覧情報をロードする。
     *
     * @param 被保険者番号 被保険者番号
     * @param サービス年月 サービス年月
     * @param 整理番号 整理番号
     * @param 画面モード 画面モード
     * @param 国保連共同処理受託区分_償還 RString
     * @param 償還払支給申請 ShokanShinsei
     */
    public void set支給申請一覧情報(HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス年月, RString 整理番号,
            RString 画面モード, ShokanShinsei 償還払支給申請, RString 国保連共同処理受託区分_償還) {
        set申請共通エリア(償還払支給申請);
        if (MODEL_DEL.equals(画面モード)) {
            div.getPnlShinsei().getChkKokuhorenSaiso().setVisible(false);
            div.getPnlShinsei().setDisabled(true);
        }
        set申請明細エリア(償還払支給申請, 画面モード);

        if (!受託あり.equals(国保連共同処理受託区分_償還)) {
            return;
        }
        if (null != 償還払支給申請.get送付年月() && !償還払支給申請.get送付年月().isEmpty()) {
            ShokanHanteiKekka 償還払支給判定結果 = SyokanbaraihiShikyuShinseiKetteManager.createInstance().
                    getSyokanbaraiketteKekka(被保険者番号, サービス年月, 整理番号);
            if (null != 償還払支給判定結果) {
                個別設定(償還払支給判定結果, 被保険者番号, サービス年月, 整理番号, 償還払支給申請);
            } else {
                set登録(Boolean.TRUE);
                div.getPanelHead().getBtnKouzaInfo().setDisabled(false);
                div.getPanelHead().getBtnServerteikyoShomeisyo().setDisabled(false);
                div.getPanelHead().getBtnShokanBaraiKeteiInfo().setDisabled(true);
            }
        } else {
            div.getPanelHead().getBtnKouzaInfo().setDisabled(false);
            div.getPanelHead().getBtnServerteikyoShomeisyo().setDisabled(false);
            div.getPanelHead().getBtnShokanBaraiKeteiInfo().setDisabled(true);
        }
    }

    private void 個別設定(ShokanHanteiKekka 償還払支給判定結果, HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス年月,
            RString 整理番号, ShokanShinsei 償還払支給申請) {
        if (償還払支給判定結果.get支給_不支給決定区分().equals(ShikyuFushikyuKubun.不支給.getコード())) {
            div.getPanelHead().getBtnKouzaInfo().setDisabled(false);
            div.getPanelHead().getBtnServerteikyoShomeisyo().setDisabled(false);
            div.getPanelHead().getBtnShokanBaraiKeteiInfo().setDisabled(false);
        } else if (償還払支給判定結果.get支給_不支給決定区分().equals(ShikyuFushikyuKubun.支給.getコード())) {
            List<KyufujissekiKihonResult> 給付実績基本情報リスト = SyokanbaraihiShikyuShinseiKetteFath.createInstance().
                    getKyufuJissekiKihonJohoList(new HokenshaNo(div.getPnlShinsei().getTxtKisaiHokensyaBango().getValue()),
                            被保険者番号, サービス年月, 整理番号, KyufuJissekiKubun.償還.getコード());
            if (null == 給付実績基本情報リスト) {
                set登録(Boolean.TRUE);
                div.getPnlShinsei().getChkKokuhorenSaiso().setDisabled(true);
                div.getPanelHead().getBtnKouzaInfo().setDisabled(false);
                div.getPanelHead().getBtnServerteikyoShomeisyo().setDisabled(false);
                div.getPanelHead().getBtnShokanBaraiKeteiInfo().setDisabled(false);
            } else {
                個別設定_給付実績(給付実績基本情報リスト, 償還払支給申請);
            }
        }
    }

    private void 個別設定_給付実績(List<KyufujissekiKihonResult> 給付実績基本情報リスト, ShokanShinsei 償還払支給申請) {
        if (給付実績基本情報リスト.size() == 1) {
            if (new Decimal(償還払支給申請.get保険給付額()).equals(給付実績基本情報リスト.get(0).
                    getEntity().get後保険請求額())) {
                div.getPanelHead().getBtnKouzaInfo().setDisabled(false);
                div.getPanelHead().getBtnServerteikyoShomeisyo().setDisabled(false);
                div.getPanelHead().getBtnShokanBaraiKeteiInfo().setDisabled(false);
            } else {
                set登録(Boolean.TRUE);
                div.getPnlShinsei().getChkKokuhorenSaiso().setDisabled(true);
                div.getPanelHead().getBtnKouzaInfo().setDisabled(false);
                div.getPanelHead().getBtnServerteikyoShomeisyo().setDisabled(false);
                div.getPanelHead().getBtnShokanBaraiKeteiInfo().setDisabled(false);
            }
        } else {
            throw new ApplicationException(DbcErrorMessages.給付実績複数件取得.getMessage());
        }

    }

    private void set登録(boolean flag) {
        div.getPnlShinsei().getTxtShinseiYMD().setDisabled(flag);
        div.getPnlShinsei().getTxtUketsukeYMD().setDisabled(flag);
        div.getPnlShinsei().getRdoShinseisyaKubun().setDisabled(flag);
        div.getPnlShinsei().getTxtShimeikana().setDisabled(flag);
        div.getPnlShinsei().getTxtShimeiKanji().setDisabled(flag);
        div.getPnlShinsei().getTxtTelNo().setDisabled(flag);
        div.getPnlShinsei().getTxtMulShinseiRiyu().setDisabled(flag);
        div.getPnlShinsei().getTxtNumShiharaKingakuGk().setDisabled(flag);
    }

    /**
     * 支給申請を登録する。
     *
     * @param 画面モード RString
     * @param 償還払支給申請 ShokanShinsei
     * @return boolean 整理番号
     */
    public RString insert(RString 画面モード, ShokanShinsei 償還払支給申請) {
        RString 整理番号 = InstanceProvider.create(SyokanbaraihiShikyuShinseiKetteManager.class).
                insDbT3034ShokanShinsei(get画面データ(画面モード, 償還払支給申請));
        if (null != 整理番号 && !整理番号.isEmpty()) {
            div.getPanelHead().getTxtSeiribango().setValue(整理番号);
        }
        return 整理番号;
    }

    /**
     * 支給申請を更新する。
     *
     * @param 画面モード RString
     * @param 償還払支給申請 ShokanShinsei
     * @return boolean 更新結果
     */
    public boolean update(RString 画面モード, ShokanShinsei 償還払支給申請) {
        int i = InstanceProvider.create(SyokanbaraihiShikyuShinseiKetteManager.class).
                updDbT3034ShokanShinsei(get画面データ(画面モード, 償還払支給申請));
        return i != 0;
    }

    /**
     * 支給申請を削除する。
     *
     * @param 識別コード ShikibetsuCode
     * @return boolean 削除結果
     */
    public boolean delete(ShikibetsuCode 識別コード) {
        HihokenshaNo 被保険者番号 = new HihokenshaNo(div.getPanelUp().getCcdKaigoShikakuKihon().get被保険者番号());
        FlexibleYearMonth サービス年月 = new FlexibleYearMonth(div.getPanelHead().
                getTxtServiceTeikyoYM().getValue().getYearMonth().toString());
        RString 整理番号 = div.getPanelHead().getTxtSeiribango().getValue();
        int i = InstanceProvider.create(SyokanbaraihiShikyuShinseiKetteManager.class).
                delDbT3034ShokanShinsei(被保険者番号, サービス年月, 整理番号, 識別コード);
        return i != 0;
    }

    /**
     * 変更チェック処理()
     *
     * @param 償還払支給申請 ShokanShinsei
     * @return boolean
     */
    public boolean is変更あり(ShokanShinsei 償還払支給申請) {
        if (償還払支給申請.get申請年月日() != null && !償還払支給申請.get申請年月日().isEmpty()) {
            if (div.getPnlShinsei().getTxtShinseiYMD().getValue() == null) {
                return true;
            } else if (!償還払支給申請.get申請年月日().equals(new FlexibleDate(div.getPnlShinsei().
                    getTxtShinseiYMD().getValue().toString()))) {
                return true;
            }
        } else {
            if (div.getPnlShinsei().getTxtShinseiYMD().getValue() != null) {
                return true;
            }
        }

        if (償還払支給申請.get受付年月日() != null && !償還払支給申請.get受付年月日().isEmpty()) {
            if (div.getPnlShinsei().getTxtUketsukeYMD().getValue() == null) {
                return true;
            } else if (!償還払支給申請.get受付年月日().equals(new FlexibleDate(div.getPnlShinsei().
                    getTxtUketsukeYMD().getValue().toString()))) {
                return true;
            }
        } else {
            if (div.getPnlShinsei().getTxtUketsukeYMD().getValue() != null) {
                return true;
            }
        }

        if (ShinseishaKubun.本人.get名称().equals(div.getPnlShinsei().getRdoShinseisyaKubun().getSelectedValue())
                && !償還払支給申請.get申請者区分().equals(ShinseishaKubun.本人.getコード())) {
            return true;
        }

        if (ShinseishaKubun.代理人.get名称().equals(div.getPnlShinsei().getRdoShinseisyaKubun().getSelectedValue())
                && !償還払支給申請.get申請者区分().equals(ShinseishaKubun.代理人.getコード())) {
            return true;
        }

        return is変更あり_UPD(償還払支給申請);
    }

    private boolean is変更あり_UPD(ShokanShinsei 償還払支給申請) {

        if (償還払支給申請.is国保連再送付フラグ()) {
            if (div.getPnlShinsei().getChkKokuhorenSaiso().getSelectedItems().isEmpty()) {
                return true;
            }
        } else {
            if (!div.getPnlShinsei().getChkKokuhorenSaiso().getSelectedItems().isEmpty()) {
                return true;
            }
        }

        if (償還払支給申請.get申請者氏名() != null && !償還払支給申請.get申請者氏名().isEmpty()) {
            if (div.getPnlShinsei().getTxtShimeiKanji().getDomain() == null
                    || div.getPnlShinsei().getTxtShimeiKanji().getDomain().isEmpty()) {
                return true;
            } else if (!償還払支給申請.get申請者氏名().equals(div.getPnlShinsei().getTxtShimeiKanji().getDomain().value())) {
                return true;
            }
        } else {
            if (div.getPnlShinsei().getTxtShimeiKanji().getDomain() != null
                    && !div.getPnlShinsei().getTxtShimeiKanji().getDomain().isEmpty()) {
                return true;
            }
        }

        return is変更あり_UPD2(償還払支給申請);
    }

    private boolean is変更あり_UPD2(ShokanShinsei 償還払支給申請) {
        if (償還払支給申請.get申請者氏名カナ() != null && !償還払支給申請.get申請者氏名カナ().isEmpty()) {
            if (div.getPnlShinsei().getTxtShimeikana().getDomain() == null
                    || div.getPnlShinsei().getTxtShimeikana().getDomain().isEmpty()) {
                return true;
            } else if (!償還払支給申請.get申請者氏名カナ().equals(div.getPnlShinsei().getTxtShimeikana().getDomain().value())) {
                return true;
            }
        } else {
            if (div.getPnlShinsei().getTxtShimeikana().getDomain() != null
                    && !div.getPnlShinsei().getTxtShimeikana().getDomain().isEmpty()) {
                return true;
            }
        }

        if (償還払支給申請.get申請者電話番号() != null && !償還払支給申請.get申請者電話番号().isEmpty()) {
            if (div.getPnlShinsei().getTxtTelNo().getDomain() == null || div.getPnlShinsei().getTxtTelNo().getDomain().isEmpty()) {
                return true;
            } else if (!償還払支給申請.get申請者電話番号().value().equals(div.getPnlShinsei().getTxtTelNo().getDomain().value())) {
                return true;
            }
        } else {
            if (div.getPnlShinsei().getTxtTelNo().getDomain() != null
                    && !div.getPnlShinsei().getTxtTelNo().getDomain().isEmpty()) {
                return true;
            }
        }

        return is変更あり_UPD3(償還払支給申請);
    }

    private boolean is変更あり_UPD3(ShokanShinsei 償還払支給申請) {
        if (償還払支給申請.get申請理由() != null && !償還払支給申請.get申請理由().isEmpty()) {
            if (div.getPnlShinsei().getTxtMulShinseiRiyu().getValue() == null
                    || div.getPnlShinsei().getTxtMulShinseiRiyu().getValue().isEmpty()) {
                return true;
            } else if (!償還払支給申請.get申請理由().equals(div.getPnlShinsei().getTxtMulShinseiRiyu().getValue())) {
                return true;
            }
        } else {
            if (div.getPnlShinsei().getTxtMulShinseiRiyu().getValue() != null
                    && !div.getPnlShinsei().getTxtMulShinseiRiyu().getValue().isEmpty()) {
                return true;
            }
        }

        if (償還払支給申請.get支払金額合計() != null) {
            if (div.getPnlShinsei().getTxtNumShiharaKingakuGk().getValue() == null) {
                return true;
            } else if (!償還払支給申請.get支払金額合計().equals(div.getPnlShinsei().getTxtNumShiharaKingakuGk().getValue())) {
                return true;
            }
        } else {
            if (div.getPnlShinsei().getTxtNumShiharaKingakuGk().getValue() != null) {
                return true;
            }
        }
        return false;
    }

    /**
     * 変更チェック処理ADD()
     *
     * @return boolean
     */
    public boolean is変更あり_ADD() {
        pnlShinseiDiv pnlDiv = div.getPnlShinsei();
        if (pnlDiv.getTxtUketsukeYMD().getValue() != null) {
            return true;
        }
        if (pnlDiv.getTxtShinseiYMD().getValue() != null) {
            return true;
        }
        if (!ShinseishaKubun.本人.get名称().equals(pnlDiv.getRdoShinseisyaKubun().getSelectedValue())) {
            return true;
        }
        if (pnlDiv.getTxtKisaiHokensyaBango().getValue() != null && !pnlDiv.getTxtKisaiHokensyaBango().getValue().isEmpty()) {
            return true;
        }
        if (pnlDiv.getTxtShimeikana().getDomain() != null && !pnlDiv.getTxtShimeikana().getDomain().isEmpty()) {
            return true;
        }
        if (pnlDiv.getTxtShimeiKanji().getDomain() != null && !pnlDiv.getTxtShimeiKanji().getDomain().isEmpty()) {
            return true;
        }
        if (pnlDiv.getTxtTelNo().getDomain() != null && !pnlDiv.getTxtTelNo().getDomain().isEmpty()) {
            return true;
        }
        if (pnlDiv.getTxtMulShinseiRiyu().getValue() != null && !pnlDiv.getTxtMulShinseiRiyu().getValue().isEmpty()) {
            return true;
        }
        return pnlDiv.getTxtNumShiharaKingakuGk().getValue() != null;
    }

    private void set申請共通エリア(ShokanShinsei 償還払支給申請) {
        div.getPanelHead().getTxtSeiribango().setValue(償還払支給申請.get整理番号());
        div.getPanelHead().getTxtServiceTeikyoYM().setValue(new RDate(償還払支給申請.getサービス提供年月().toString()));
    }

    private void set申請明細エリア(ShokanShinsei 償還払支給申請, RString 画面モード) {
        if (償還払支給申請.get申請年月日() != null && !償還払支給申請.get申請年月日().isEmpty()) {
            div.getPnlShinsei().getTxtShinseiYMD().setValue(new RDate(償還払支給申請.get申請年月日().toString()));
        }
        if (償還払支給申請.get受付年月日() != null && !償還払支給申請.get受付年月日().isEmpty()) {
            div.getPnlShinsei().getTxtUketsukeYMD().setValue(new RDate(償還払支給申請.get受付年月日().toString()));
        }
        if (ShinseishaKubun.本人.getコード().equals(償還払支給申請.get申請者区分())) {
            div.getPnlShinsei().getRdoShinseisyaKubun().setSelectedValue(ShinseishaKubun.本人.get名称());
        } else if (ShinseishaKubun.代理人.getコード().equals(償還払支給申請.get申請者区分())) {
            div.getPnlShinsei().getRdoShinseisyaKubun().setSelectedValue(ShinseishaKubun.代理人.get名称());
        }
        if (償還払支給申請.get証記載保険者番号() != null && !償還払支給申請.get証記載保険者番号().isEmpty()) {
            div.getPnlShinsei().getTxtKisaiHokensyaBango().setValue(償還払支給申請.get証記載保険者番号().value());
        }
        if (償還払支給申請.get申請者氏名カナ() != null && !償還払支給申請.get申請者氏名カナ().isEmpty()) {
            div.getPnlShinsei().getTxtShimeikana().setDomain(new AtenaKanaMeisho(償還払支給申請.get申請者氏名カナ()));
        }
        if (償還払支給申請.get申請者氏名() != null && !償還払支給申請.get申請者氏名().isEmpty()) {
            div.getPnlShinsei().getTxtShimeiKanji().setDomain(new AtenaMeisho(償還払支給申請.get申請者氏名()));
        }
        div.getPnlShinsei().getTxtTelNo().setDomain(償還払支給申請.get申請者電話番号());
        div.getPnlShinsei().getTxtMulShinseiRiyu().setValue(償還払支給申請.get申請理由());
        div.getPnlShinsei().getTxtNumShiharaKingakuGk().setValue(償還払支給申請.get支払金額合計());
        div.getPnlShinsei().getTxtNumHokentaisyoHiyouGaku().setValue(new Decimal(償還払支給申請.get保険給付額()));
        div.getPnlShinsei().getTxtNumHokenKyufuGaku().setValue(new Decimal(償還払支給申請.get利用者負担額()));
        div.getPnlShinsei().getChkKokuhorenSaiso().setDisabled(false);
        if (償還払支給申請.is国保連再送付フラグ()) {
            List<KeyValueDataSource> items = div.getPnlShinsei().getChkKokuhorenSaiso().getDataSource();
            div.getPnlShinsei().getChkKokuhorenSaiso().setSelectedItems(items);
        } else {
            List<KeyValueDataSource> items = new ArrayList<>();
            div.getPnlShinsei().getChkKokuhorenSaiso().setSelectedItems(items);
        }

        if (MODEL_UPD.equals(画面モード) && !償還払支給申請.is国保連再送付フラグ()
                && null != 償還払支給申請.get送付年月() && !償還払支給申請.get送付年月().isEmpty()) {
            div.getPnlShinsei().getChkKokuhorenSaiso().setVisible(true);
        } else {
            div.getPnlShinsei().getChkKokuhorenSaiso().setVisible(false);
        }
    }

    private ShokanShinsei get画面データ(RString 画面モード, ShokanShinsei 償還払支給申請) {
        HihokenshaNo 被保険者番号 = new HihokenshaNo(div.getPanelUp().getCcdKaigoShikakuKihon().get被保険者番号());
        if (MODEL_ADD.equals(画面モード)) {
            償還払支給申請 = new ShokanShinsei(被保険者番号,
                    new FlexibleYearMonth(div.getPanelHead().getTxtServiceTeikyoYM().getValue().getYearMonth().toString()), 整理番号_ADD);
        }
        償還払支給申請 = 償還払支給申請.createBuilderForEdit().
                set証記載保険者番号(new ShoKisaiHokenshaNo(div.getPnlShinsei().getTxtKisaiHokensyaBango().getValue())).
                set申請理由(div.getPnlShinsei().getTxtMulShinseiRiyu().getValue()).
                set申請者氏名(div.getPnlShinsei().getTxtShimeiKanji().getDomain().value()).
                set申請者氏名カナ(div.getPnlShinsei().getTxtShimeikana().getDomain().value()).
                set支払金額合計(div.getPnlShinsei().getTxtNumShiharaKingakuGk().getValue()).
                set保険対象費用額(div.getPnlShinsei().getTxtNumShiharaKingakuGk().getValue()).build();

        if (div.getPnlShinsei().getTxtShinseiYMD().getValue() != null) {
            償還払支給申請 = 償還払支給申請.createBuilderForEdit().set申請年月日(new FlexibleDate(
                    div.getPnlShinsei().getTxtShinseiYMD().getValue().toString())).build();
        } else {
            償還払支給申請 = 償還払支給申請.createBuilderForEdit().set申請年月日(FlexibleDate.EMPTY).build();
        }

        if (div.getPnlShinsei().getTxtUketsukeYMD().getValue() != null) {
            償還払支給申請 = 償還払支給申請.createBuilderForEdit().set受付年月日(new FlexibleDate(
                    div.getPnlShinsei().getTxtUketsukeYMD().getValue().toString())).build();
        } else {
            償還払支給申請 = 償還払支給申請.createBuilderForEdit().set受付年月日(FlexibleDate.EMPTY).build();
        }

        if (ShinseishaKubun.本人.get名称().equals(div.getPnlShinsei().getRdoShinseisyaKubun().getSelectedValue())) {
            償還払支給申請 = 償還払支給申請.createBuilderForEdit().set申請者区分(ShinseishaKubun.本人.getコード()).build();
        } else if (ShinseishaKubun.代理人.get名称().equals(div.getPnlShinsei().getRdoShinseisyaKubun().getSelectedValue())) {
            償還払支給申請 = 償還払支給申請.createBuilderForEdit().set申請者区分(ShinseishaKubun.代理人.getコード()).build();
        }

        if (div.getPnlShinsei().getTxtTelNo().getDomain() != null && !div.getPnlShinsei().getTxtTelNo().getDomain().isEmpty()) {
            償還払支給申請 = 償還払支給申請.createBuilderForEdit().set申請者電話番号(
                    div.getPnlShinsei().getTxtTelNo().getDomain()).build();
        } else {
            償還払支給申請 = 償還払支給申請.createBuilderForEdit().set申請者電話番号(TelNo.EMPTY).build();
        }

        if (div.getPnlShinsei().getTxtNumHokentaisyoHiyouGaku().getValue() != null) {
            償還払支給申請 = 償還払支給申請.createBuilderForEdit().set保険給付額(Integer.valueOf(
                    div.getPnlShinsei().getTxtNumHokentaisyoHiyouGaku().getValue().toString())).build();
        } else {
            償還払支給申請 = 償還払支給申請.createBuilderForEdit().set保険給付額(0).build();
        }

        if (div.getPnlShinsei().getTxtNumHokenKyufuGaku().getValue() != null) {
            償還払支給申請 = 償還払支給申請.createBuilderForEdit().set利用者負担額(Integer.valueOf(
                    div.getPnlShinsei().getTxtNumHokenKyufuGaku().getValue().toString())).build();
        } else {
            償還払支給申請 = 償還払支給申請.createBuilderForEdit().set利用者負担額(0).build();
        }

        RString config = DbBusinessConfig.get(ConfigNameDBC.国保連共同処理受託区分_償還,
                RDate.getNowDate(), SubGyomuCode.DBC介護給付);
        RString 審査方法区分 = null;
        if (受託なし.equals(config)) {
            審査方法区分 = ShinsaHohoKubun.審査済み.getコード();
        } else if (受託あり.equals(config)) {
            審査方法区分 = ShinsaHohoKubun.審査依頼.getコード();
        }

        if (MODEL_ADD.equals(画面モード)) {
            return 償還払支給申請.createBuilderForEdit().
                    set支給申請審査区分(ShikyushinseiShinsaKubun.未審査.getコード()).
                    set審査方法区分(審査方法区分).set国保連再送付フラグ(false).
                    build();
        }
        return 償還払支給申請;
    }

    /**
     * Parameterに以下の情報を設定する
     *
     * @return ShokanShinsei 支給申請一覧情報
     */
    public ShikyuShinseiDetailParameter setParameter() {
        RString 処理モード;
        if (MODEL_ADD.equals(div.getPanelHead().getTxtShoriMode().getValue())) {
            処理モード = 登録モード;
        } else {
            処理モード = div.getPanelHead().getTxtShoriMode().getValue();
        }
        RYearMonth サービス提供年月 = div.getPanelHead().getTxtServiceTeikyoYM().getValue().getYearMonth();
        RString 整理番号 = div.getPanelHead().getTxtSeiribango().getValue();
        RString 申請日 = div.getPnlShinsei().getTxtShinseiYMD().getValue().toDateString();
        ShikyuShinseiDetailParameter parameter = new ShikyuShinseiDetailParameter(
                処理モード, null, サービス提供年月, 整理番号, 申請日);
        return parameter;
    }

    /**
     * 「取消する」Parameterに以下の情報を設定する
     *
     * @return ShokanShinsei 支給申請一覧情報
     */
    public ShikyuShinseiDetailParameter btnCancel_SetParameter() {
        RString 処理モード = div.getPanelHead().getTxtShoriMode().getValue();
        RYearMonth サービス提供年月 = div.getPanelHead().getTxtServiceTeikyoYM().getValue().getYearMonth();
        RString 整理番号 = div.getPanelHead().getTxtSeiribango().getValue();
        ShikyuShinseiDetailParameter parameter = new ShikyuShinseiDetailParameter(
                処理モード, null, サービス提供年月, 整理番号, null);
        return parameter;
    }
}
