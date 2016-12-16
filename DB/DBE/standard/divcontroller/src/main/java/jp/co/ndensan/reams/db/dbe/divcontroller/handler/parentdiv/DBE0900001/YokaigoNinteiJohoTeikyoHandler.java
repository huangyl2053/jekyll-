/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE0900001;

import java.util.ArrayList;
import jp.co.ndensan.reams.db.dbe.business.core.yokaigoninteijohoteikyo.HihokenshaJyuhouBusiness;
import jp.co.ndensan.reams.db.dbe.business.core.yokaigoninteijohoteikyo.NinnteiRiriBusiness;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE0900001.YokaigoNinteiJohoTeikyoDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE0900001.dgNinteiKekkaIchiran_Row;
import jp.co.ndensan.reams.db.dbe.service.core.yokaigoninteijohoteikyo.YokaigoNinteiJohoTeikyoFinder;
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
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 要介護認定情報提供Divを制御クラスです。
 *
 * @reamsid_L DBE-0230-010 zhangzhiming
 */
public class YokaigoNinteiJohoTeikyoHandler {

    private final YokaigoNinteiJohoTeikyoDiv div;
    private final RString キー_0 = new RString("key0");
    private final RString キー_1 = new RString("key1");
    private final RString キー_2 = new RString("key2");
    private final RString 月 = new RString("ヶ月");
    private final RString 線 = new RString("～");
    private final RString 検索へ戻る = new RString("btnToSearch");

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
        div.getNinteiKekkaShosai().setIsOpen(false);
        div.getHakkoChohyo().setIsOpen(false);
        div.getNInteiRirekiInfo().setIsOpen(true);
        CommonButtonHolder.setDisabledByCommonButtonFieldName(new RString("btnToSearch"), false);
        HihokenshaJyuhouBusiness 被保険者情報 = YokaigoNinteiJohoTeikyoFinder.createInstance().select被保険者情報(申請書管理番号);
        if (被保険者情報 != null) {
            div.getTxtHihokenshaNo().setValue(被保険者情報.get被保険者番号());
            div.getTxtHihokenshaKubun().setValue(HihokenshaKubunCode.toValue(被保険者情報.get区分コード()).get名称());
            div.getTxtHokenshaNo().setValue(new Decimal(被保険者情報.get証記載保険者番号().toString()));
            div.getTxtHokenshaName().setValue(被保険者情報.get市町村名称());
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
            }
            if (IsIkenshoDoiUmu.toValue(business.is意見書同意フラグ()).isしないする()) {
                div.getNinteiKekkaShosai().getRadShijiiJohoTeikyoDoi().setSelectedKey(キー_0);
            } else {
                div.getNinteiKekkaShosai().getRadShijiiJohoTeikyoDoi().setSelectedKey(キー_1);
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
            div.getCcdShujiiIryoKikanAndShujiiInput().initialize(new LasdecCode(business.get市町村コード()), ShinseishoKanriNo.EMPTY, SubGyomuCode.EMPTY,
                    business.get主治医医療機関コード(), business.get医療機関名称(), business.get主治医コード(), business.get主治医氏名());
            div.getNinteiKekkaShosai().getTxtShinsakaiYoteibi().setValue(getNull(business.get審査会開催予定日()));
            div.getNinteiKekkaShosai().getTxtShinsakaiKaisaibi().setValue(getNull(business.get審査会開催日()));
        }

//        List<NinnteiRiriBusiness> 認定履歴一覧 = YokaigoNinteiJohoTeikyoFinder.createInstance().select認定履歴一覧(被保険者番号).records();
//        List<dgNinteiKekkaIchiran_Row> ichiran_Row = new ArrayList<>();
//        if (認定履歴一覧 != null) {
//            for (NinnteiRiriBusiness business : 認定履歴一覧) {
//                dgNinteiKekkaIchiran_Row row = new dgNinteiKekkaIchiran_Row();
//                row.getNinteiShinseiDay().setValue(getNull(business.get認定申請日()));
//                row.setShinseiKubunShinseiji(NinteiShinseiShinseijiKubunCode.toValue(business.get申請区分_申請時().getKey()).get名称());
//                row.setShinseiKubunHorei(NinteiShinseiHoreiCode.toValue(business.get申請区分_法令().getKey()).get名称());
//                row.getShinseiTorisageDay().setValue(getNull(business.get取下年月日()));
//                row.getNinteiDay().setValue(getNull(business.get二次判定年月日()));
//                if (business.get二次判定区分コード() == null || business.get二次判定区分コード().isEmpty()
//                        || YokaigoJotaiKubun09.なし.getコード().equals(business.get二次判定区分コード().value())) {
//                    row.setYoKaigodo(RString.EMPTY);
//                } else {
//                    row.setYoKaigodo(YokaigoJotaiKubun09.toValue(business.get二次判定区分コード().getKey()).get名称());
//                }
//                RStringBuilder builder = new RStringBuilder();
//                builder.append(business.get二次判定認定有効期間());
//                builder.append(月);
//                row.setYukoKikan(builder.toRString());
//                RStringBuilder stringBuilder = new RStringBuilder();
//                if (business.get二次判定認定有効開始期間() != null) {
//                    stringBuilder.append(business.get二次判定認定有効開始期間().wareki().toDateString());
//                    stringBuilder.append(線);
//                }
//                if (business.get二次判定認定有効終了期間() != null) {
//                    stringBuilder.append(business.get二次判定認定有効終了期間().wareki().toDateString());
//                }
//                row.setYukoKikanStartEnd(stringBuilder.toRString());
//                row.getNinteiChosaJisshiDay().setValue(getNull(business.get認定調査実施年月日()));
//                row.getShujiiIkenshoJuryoDay().setValue(getNull(business.get主治医意見書受領年月日()));
//                row.getKaigoNinteiShinsakaiKaisaiDay().setValue(getNull(business.get審査会開催日()));
//                row.getJohoTeikyoShiryoShutsuryokuDay().setValue(getNull(business.get出力年月日()));
//                row.getNinteiShinsakaiKanryoYMD().setValue(getNull(business.get認定審査会完了年月日()));
//                row.getNinteichosaIraiYMD().setValue(getNull(business.get認定調査依頼年月日()));
//                row.getNinteichosaJuryoYMD().setValue(getNull(business.get認定調査受領年月日()));
//                row.setNinteiChosaItakusakiCode(business.get認定調査委託先コード());
//                row.setJigyoshaMeisho(business.get事業者名称());
//                row.setNinteiChosainCode(business.get認定調査員コード());
//                row.setChosainShimei(business.get調査員氏名());
//                row.getIkenshoSakuseiIraiYMD().setValue(getNull(business.get主治医意見書作成依頼年月日()));
//                row.setShujiiIryokikanCode(business.get主治医医療機関コード());
//                row.setIryoKikanMeisho(business.get医療機関名称());
//                row.setShujiiCode(business.get主治医コード());
//                row.setShujiiName(business.get主治医氏名());
//                row.getShinsakaiKaisaiYoteiYMD().setValue(getNull(business.get審査会開催予定日()));
//                row.setIkenshoDoiFlag(business.is意見書同意フラグ());
//                row.setJohoteikyoDoiFlag(business.is情報提供への同意有無());
//                row.setShinseishoKanriNo(business.get申請書管理番号());
//                row.setShichosonCode(business.get市町村コード());
//                ichiran_Row.add(row);
//            }
//        }
//        div.getNInteiRirekiInfo().getDgNinteiKekkaIchiran().setDataSource(ichiran_Row);
    }

    /**
     * 「選択」ボタン押下します。
     *
     */
    public void btn_Select() {
        CommonButtonHolder.setDisabledByCommonButtonFieldName(検索へ戻る, false);
        dgNinteiKekkaIchiran_Row row = div.getNInteiRirekiInfo().getDgNinteiKekkaIchiran().getSelectedItems().get(0);
        if (IsExistJohoTeikyoDoui.toValue(row.getJohoteikyoDoiFlag()).is同意する()) {
            div.getNinteiKekkaShosai().getRadHihokenshaJohoTeikyoDoi().setSelectedKey(キー_0);
        } else {
            div.getNinteiKekkaShosai().getRadHihokenshaJohoTeikyoDoi().setSelectedKey(キー_1);
        }
        if (IsIkenshoDoiUmu.toValue(row.getIkenshoDoiFlag()).isしないする()) {
            div.getNinteiKekkaShosai().getRadShijiiJohoTeikyoDoi().setSelectedKey(キー_0);
        } else {
            div.getNinteiKekkaShosai().getRadShijiiJohoTeikyoDoi().setSelectedKey(キー_1);
        }
        div.getNinteiKekkaShosai().getTxtShinseibi().setValue(row.getNinteiShinseiDay().getValue());
        div.getNinteiKekkaShosai().getTxtShinseiKubunShin().setValue(row.getShinseiKubunShinseiji());
        div.getNinteiKekkaShosai().getTxtShinseiKubun().setValue(row.getShinseiKubunHorei());
        div.getNinteiKekkaShosai().getTxtNinteiChosaIraibi().setValue(row.getNinteichosaIraiYMD().getValue());
        div.getNinteiKekkaShosai().getTxtNinteiChosaJisshibi().setValue(row.getNinteiChosaJisshiDay().getValue());
        div.getNinteiKekkaShosai().getTxtNinteiChosaJuryobi().setValue(row.getNinteichosaJuryoYMD().getValue());
        div.getCcdChosaItakusakiAndChosainInput().initialize(new RString(ChosaItakusakiAndChosainInputDiv.ShoriType.SimpleInputMode.toString()),
                row.getNinteiChosaItakusakiCode(), row.getJigyoshaMeisho(), row.getNinteiChosainCode(), row.getChosainShimei());
        div.getCcdChosaItakusakiAndChosainInput().setHdnShichosonCode(row.getShichosonCode());
        div.getCcdChosaItakusakiAndChosainInput().setHdnShinseishoKanriNo(RString.EMPTY);
        div.getNinteiKekkaShosai().getTxtIkenshoIraibi().setValue(row.getIkenshoSakuseiIraiYMD().getValue());
        div.getNinteiKekkaShosai().getTxtIkenshoJuryobi().setValue(row.getShujiiIkenshoJuryoDay().getValue());
        div.getCcdShujiiIryoKikanAndShujiiInput().initialize(new LasdecCode(row.getShichosonCode()), ShinseishoKanriNo.EMPTY, SubGyomuCode.EMPTY,
                row.getShujiiIryokikanCode(), row.getIryoKikanMeisho(), row.getShujiiCode(), row.getShujiiName());
        div.getNinteiKekkaShosai().getTxtShinsakaiYoteibi().setValue(row.getShinsakaiKaisaiYoteiYMD().getValue());
        div.getNinteiKekkaShosai().getTxtShinsakaiKaisaibi().setValue(row.getKaigoNinteiShinsakaiKaisaiDay().getValue());
    }

    /**
     * 「一覧へ戻る」ボタン押下します。
     *
     */
    public void btn_BackSearchResult() {
        div.getTxtShinseibi().clearValue();
        div.getTxtShinseiKubunShin().clearValue();
        div.getTxtShinseiKubun().clearValue();
        div.getTxtNinteiChosaIraibi().clearValue();
        div.getTxtNinteiChosaJisshibi().clearValue();
        div.getTxtNinteiChosaJuryobi().clearValue();
        div.getCcdChosaItakusakiAndChosainInput().clear();
        div.getTxtIkenshoIraibi().clearValue();
        div.getTxtIkenshoJuryobi().clearValue();
        div.getCcdShujiiIryoKikanAndShujiiInput().clear();
        div.getTxtShinsakaiYoteibi().clearValue();
        div.getTxtShinsakaiKaisaibi().clearValue();
        div.getChkNinteiChosahyo().setSelectedItemsByKey(new ArrayList<RString>());
        div.getChkTokkiJiko().setSelectedItemsByKey(new ArrayList<RString>());
        div.getChkShujiiIkensho().setSelectedItemsByKey(new ArrayList<RString>());
        div.getChkSonotaShiryo().setSelectedItemsByKey(new ArrayList<RString>());
        div.getChkIchijiHanteiKekka().setSelectedItemsByKey(new ArrayList<RString>());
        div.getRadTokkiJikoMasking().setSelectedKey(キー_0);
        div.getRadShujii().setSelectedKey(キー_0);
        div.getRadSohotaShiryoMasking().setSelectedKey(キー_0);
    }

    /**
     * 認定調査票チェックボックス変更します。
     *
     */
    public void chkNinteiChosahyo() {
        if (div.getHakkoChohyo().getChkNinteiChosahyo().getSelectedItems().isEmpty()) {
            div.getHakkoChohyo().getRadNinteiChosaMasking().setDisabled(true);
            div.getHakkoChohyo().getRadNinteiChosaMasking().setSelectedKey(キー_2);
        } else {
            div.getHakkoChohyo().getRadNinteiChosaMasking().setDisabled(false);
        }
    }

    /**
     * 特記事項チェックボックス変更します。
     *
     */
    public void chkTokkiJiko() {
        if (div.getHakkoChohyo().getChkTokkiJiko().getSelectedItems().isEmpty()) {
            div.getHakkoChohyo().getRadTokkiJikoMasking().setDisabled(true);
            div.getHakkoChohyo().getRadTokkiJikoMasking().setSelectedKey(キー_0);
        } else {
            div.getHakkoChohyo().getRadTokkiJikoMasking().setDisabled(false);
        }
    }

    /**
     * 主治医意見書チェックボックス変更します。
     *
     */
    public void chkShujiiIkensho() {
        if (div.getHakkoChohyo().getChkShujiiIkensho().getSelectedItems().isEmpty()) {
            div.getHakkoChohyo().getRadShujii().setDisabled(true);
            div.getHakkoChohyo().getRadShujii().setSelectedKey(キー_0);
        } else {
            div.getHakkoChohyo().getRadShujii().setDisabled(false);
        }
    }

    /**
     * その他資料チェックボックス変更します。
     *
     */
    public void chkSonotaShiryo() {
        if (div.getHakkoChohyo().getChkSonotaShiryo().getSelectedItems().isEmpty()) {
            div.getHakkoChohyo().getRadSohotaShiryoMasking().setDisabled(true);
            div.getHakkoChohyo().getRadSohotaShiryoMasking().setSelectedKey(キー_0);
        } else {
            div.getHakkoChohyo().getRadSohotaShiryoMasking().setDisabled(false);
        }
    }

    /**
     * 一次判定結果チェックボックス変更します。
     *
     */
    public void chkIchijiHanteikekka() {
        if (div.getHakkoChohyo().getChkIchijiHanteiKekka().getSelectedItems().isEmpty()) {
            div.getHakkoChohyo().getRadIchijiHanteiMasking().setDisabled(true);
            div.getHakkoChohyo().getRadIchijiHanteiMasking().setSelectedKey(キー_2);
        } else {
            div.getHakkoChohyo().getRadIchijiHanteiMasking().setDisabled(false);
        }
    }

    /**
     * 帳票発行処理ボタン押下の場合、チェック実行します。
     *
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs validateCheck() {
        return createValidationHandler(div).validateCheck();
    }

    private YokaigoNinteiJohoTeikyoValidationHandler createValidationHandler(YokaigoNinteiJohoTeikyoDiv div) {
        return new YokaigoNinteiJohoTeikyoValidationHandler(div);
    }

    private RDate getNull(FlexibleDate date) {
        if (date == null || date.isEmpty()) {
            return null;
        }
        return new RDate(date.toString());
    }
}
