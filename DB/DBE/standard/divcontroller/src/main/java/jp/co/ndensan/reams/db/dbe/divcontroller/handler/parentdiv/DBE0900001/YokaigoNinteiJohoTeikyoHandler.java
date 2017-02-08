/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE0900001;

import jp.co.ndensan.reams.db.dbe.business.core.yokaigoninteijohoteikyo.HihokenshaJyuhouBusiness;
import jp.co.ndensan.reams.db.dbe.business.core.yokaigoninteijohoteikyo.NinnteiRiriBusiness;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE0900001.YokaigoNinteiJohoTeikyoDiv;
import jp.co.ndensan.reams.db.dbe.service.core.yokaigoninteijohoteikyo.YokaigoNinteiJohoTeikyoFinder;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBE;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.definition.core.seibetsu.Seibetsu;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ikensho.IsIkenshoDoiUmu;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.HihokenshaKubunCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.IsExistJohoTeikyoDoui;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.NinteiShinseiHoreiCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.NinteiShinseiShinseijiKubunCode;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.chosaitakusakiandchosaininput.ChosaItakusakiAndChosainInput.ChosaItakusakiAndChosainInputDiv;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.servlets.CommonButtonHolder;

/**
 * 要介護認定情報提供Divを制御クラスです。
 *
 * @reamsid_L DBE-0230-010 zhangzhiming
 */
public class YokaigoNinteiJohoTeikyoHandler {

    private final YokaigoNinteiJohoTeikyoDiv div;
    private final RString キー_0 = new RString("key0");
    private final RString キー_1 = new RString("key1");
    private final RString なし = new RString("0");
    private final RString あり = new RString("1");
    private final RString 検索へ戻るボタン名 = new RString("btnToSearch");
    private final RString 発行するボタン名 = new RString("btnPrint");

    /**
     * コンストラクタです。
     *
     * @param div YokaigoNinteiJohoTeikyoDiv
     */
    public YokaigoNinteiJohoTeikyoHandler(YokaigoNinteiJohoTeikyoDiv div) {
        this.div = div;
    }

    /**
     * 画面情報を設定します。
     *
     * @param 申請書管理番号 申請書管理番号
     * @param business 認定申請ビジネスクラス
     */
    public void onLoad(RString 申請書管理番号, NinnteiRiriBusiness business) {
        CommonButtonHolder.setDisabledByCommonButtonFieldName(検索へ戻るボタン名, false);
        HihokenshaJyuhouBusiness 被保険者情報 = YokaigoNinteiJohoTeikyoFinder.createInstance().select被保険者情報(申請書管理番号);
        if (被保険者情報 != null) {
            div.getTxtHihokenshaNo().setValue(被保険者情報.get被保険者番号());
            div.getTxtHihokenshaKubun().setValue(HihokenshaKubunCode.toValue(被保険者情報.get区分コード()).get名称());
            div.getTxtHokenshaNo().setValue(new Decimal(被保険者情報.get証記載保険者番号().toString()));
            RString 保険者名称;
            if (被保険者情報.get市町村名称() != null) {
                保険者名称 = 被保険者情報.get市町村名称();
            } else {
                RString 広域連合保険者番号 = DbBusinessConfig.get(ConfigNameDBE.広域連合保険者番号, RDate.getNowDate(), SubGyomuCode.DBE認定支援);
                保険者名称 = (広域連合保険者番号.equals(被保険者情報.get証記載保険者番号()))
                        ? DbBusinessConfig.get(ConfigNameDBE.広域連合名称, RDate.getNowDate(), SubGyomuCode.DBE認定支援)
                        : RString.EMPTY;
            }
            div.getTxtHokenshaName().setValue(保険者名称);
            div.getTxtHihokenshaName().setValue(被保険者情報.get被保険者氏名().getColumnValue());
            div.getTxtHihokenshaKana().setValue(被保険者情報.get被保険者氏名カナ().getColumnValue());
            if (被保険者情報.get生年月日() != null) {
                div.getTxtSeinenYmd().setValue(new RDate(被保険者情報.get生年月日().toString()));
            }
            div.getTxtNenrei().setValue(new Decimal(被保険者情報.get年齢()));
            div.getTxtSeibetsu().setValue(Seibetsu.toValue(被保険者情報.get性別().getColumnValue()).get名称());
            div.getTxtYubibNo().setValue(被保険者情報.get郵便番号());
            div.getTxtjusho().setValue(被保険者情報.get住所().getColumnValue());
            div.getTxtTelNo().setValue(被保険者情報.get電話番号().getColumnValue());
        }

        if (business != null) {
            if (IsExistJohoTeikyoDoui.toValue(business.is情報提供への同意有無()).is同意する()) {
                div.getNinteiKekkaShosai().getRadHihokenshaJohoTeikyoDoi().setSelectedKey(キー_0);
            } else {
                div.getNinteiKekkaShosai().getRadHihokenshaJohoTeikyoDoi().setSelectedKey(キー_1);
                CommonButtonHolder.setDisabledByCommonButtonFieldName(発行するボタン名, true);
            }
            if (IsIkenshoDoiUmu.toValue(business.is意見書同意フラグ()).isしないする()) {
                div.getNinteiKekkaShosai().getRadShijiiJohoTeikyoDoi().setSelectedKey(キー_0);
            } else {
                div.getNinteiKekkaShosai().getRadShijiiJohoTeikyoDoi().setSelectedKey(キー_1);
                div.getChkShujiiIkensho().setDisabled(true);
            }
            div.getNinteiKekkaShosai().getTxtShinseibi().setValue(getNull(business.get認定申請日()));
            div.getNinteiKekkaShosai().getTxtShinseiKubunShin().setValue(
                    business.get申請区分_申請時().isEmpty() ? RString.EMPTY
                    : NinteiShinseiShinseijiKubunCode.toValue(business.get申請区分_申請時().getKey()).get名称());
            div.getNinteiKekkaShosai().getTxtShinseiKubun().setValue(
                    business.get申請区分_法令().isEmpty() ? RString.EMPTY : NinteiShinseiHoreiCode.toValue(business.get申請区分_法令().getKey()).get名称());
            div.getNinteiKekkaShosai().getTxtNinteiChosaIraibi().setValue(getNull(business.get認定調査依頼年月日()));
            div.getNinteiKekkaShosai().getTxtNinteiChosaJisshibi().setValue(getNull(business.get認定調査実施年月日()));
            div.getNinteiKekkaShosai().getTxtNinteiChosaJuryobi().setValue(getNull(business.get認定調査受領年月日()));
            div.getCcdChosaItakusakiAndChosainInput().initialize(new RString(ChosaItakusakiAndChosainInputDiv.ShoriType.SimpleInputMode.toString()),
                    business.get認定調査委託先コード(), business.get事業者名称(), business.get認定調査員コード(), business.get調査員氏名());
            div.getCcdChosaItakusakiAndChosainInput().setHdnShichosonCode(business.get市町村コード());
            div.getCcdChosaItakusakiAndChosainInput().setHdnShinseishoKanriNo(RString.EMPTY);
            div.getNinteiKekkaShosai().getTxtIkenshoIraibi().setValue(getNull(business.get主治医意見書作成依頼年月日()));
            div.getNinteiKekkaShosai().getTxtIkenshoJuryobi().setValue(getNull(business.get主治医意見書受領年月日()));
            LasdecCode 市町村コード = (business.get市町村コード() != null) ? new LasdecCode(business.get市町村コード()) : LasdecCode.EMPTY;
            div.getCcdShujiiIryoKikanAndShujiiInput().initialize(市町村コード, ShinseishoKanriNo.EMPTY, SubGyomuCode.EMPTY,
                    business.get主治医医療機関コード(), business.get医療機関名称(), business.get主治医コード(), business.get主治医氏名());
            div.getNinteiKekkaShosai().getTxtShinsakaiYoteibi().setValue(getNull(business.get審査会開催予定日()));
            div.getNinteiKekkaShosai().getTxtShinsakaiKaisaibi().setValue(getNull(business.get審査会開催日()));
        }
    }

    /**
     * 認定調査票チェックボックス変更します。
     */
    public void chkNinteiChosahyo() {
        if (div.getHakkoChohyo().getChkNinteiChosahyo().getSelectedItems().isEmpty()) {
            div.getHakkoChohyo().getRadNinteiChosaMasking().setDisabled(true);
            div.getHakkoChohyo().getRadNinteiChosaMasking().setSelectedKey(なし);
        } else {
            div.getHakkoChohyo().getRadNinteiChosaMasking().setDisabled(false);
        }
    }

    /**
     * 特記事項チェックボックス変更します。
     */
    public void chkTokkiJiko() {
        if (div.getHakkoChohyo().getChkTokkiJiko().getSelectedItems().isEmpty()) {
            div.getHakkoChohyo().getRadTokkiJikoMasking().setDisabled(true);
            div.getHakkoChohyo().getRadTokkiJikoMasking().setSelectedKey(あり);
        } else {
            div.getHakkoChohyo().getRadTokkiJikoMasking().setDisabled(false);
        }
    }

    /**
     * 主治医意見書チェックボックス変更します。
     */
    public void chkShujiiIkensho() {
        if (div.getHakkoChohyo().getChkShujiiIkensho().getSelectedItems().isEmpty()) {
            div.getHakkoChohyo().getRadShujii().setDisabled(true);
            div.getHakkoChohyo().getRadShujii().setSelectedKey(あり);
        } else {
            div.getHakkoChohyo().getRadShujii().setDisabled(false);
        }
    }

    /**
     * その他資料チェックボックス変更します。
     */
    public void chkSonotaShiryo() {
        if (div.getHakkoChohyo().getChkSonotaShiryo().getSelectedItems().isEmpty()) {
            div.getHakkoChohyo().getRadSohotaShiryoMasking().setDisabled(true);
            div.getHakkoChohyo().getRadSohotaShiryoMasking().setSelectedKey(あり);
        } else {
            div.getHakkoChohyo().getRadSohotaShiryoMasking().setDisabled(false);
        }
    }

    /**
     * 一次判定結果チェックボックス変更します。
     */
    public void chkIchijiHanteikekka() {
        if (div.getHakkoChohyo().getChkIchijiHanteiKekka().getSelectedItems().isEmpty()) {
            div.getHakkoChohyo().getRadIchijiHanteiMasking().setDisabled(true);
            div.getHakkoChohyo().getRadIchijiHanteiMasking().setSelectedKey(なし);
        } else {
            div.getHakkoChohyo().getRadIchijiHanteiMasking().setDisabled(false);
        }
    }

    private RDate getNull(FlexibleDate date) {
        if (date == null || date.isEmpty()) {
            return null;
        }
        return new RDate(date.toString());
    }
}
