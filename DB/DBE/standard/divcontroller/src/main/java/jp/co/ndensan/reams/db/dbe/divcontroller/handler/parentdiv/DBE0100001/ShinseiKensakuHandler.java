/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE0100001;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.shinseikensaku.ShinseiKensakuBusiness;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.shinseikensaku.ShinseiKensakuMapperParameter;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE0100001.ShinseiKensakuDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE0100001.dgShinseiJoho_Row;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBU;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.definition.core.seibetsu.Seibetsu;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.NinteiShinseiShinseijiKubunCode;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.NinteiShinseishaFinder.NinteiShinseishaFinder.NinteiShinseishaFinderDiv;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxNum;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;

/**
 * 要介護認定申請検索のハンドラークラスです。
 *
 * @reamsid_L DBE-1370-010 sunhaidi
 */
public class ShinseiKensakuHandler {

    private static final RString KEY0 = new RString("key0");
    private static final RString KEY1 = new RString("key1");
    private static final RString KEY2 = new RString("key2");
    private static final RString KEY3 = new RString("key3");
    private final ShinseiKensakuDiv div;

    /**
     * コンストラクタです。
     *
     * @param div 要介護認定申請検索Div
     */
    public ShinseiKensakuHandler(ShinseiKensakuDiv div) {
        this.div = div;
    }

    /**
     * 画面初期化処理です。
     */
    public void load() {
        RString 検索制御_最大取得件数上限 = DbBusinessConfig.get(ConfigNameDBU.検索制御_最大取得件数上限, RDate.getNowDate(), SubGyomuCode.DBU介護統計報告);
        RString 検索制御_最大取得件数 = DbBusinessConfig.get(ConfigNameDBU.検索制御_最大取得件数, RDate.getNowDate(), SubGyomuCode.DBU介護統計報告);
        div.getTxtMaxDisp().setMaxValue(new Decimal(検索制御_最大取得件数上限.toString()));
        div.getTxtMaxDisp().setValue(new Decimal(検索制御_最大取得件数.toString()));
        List<dgShinseiJoho_Row> dataSource = new ArrayList<>();
        div.getDgShinseiJoho().setDataSource(dataSource);
        div.getBtnModoru().setDisabled(true);
    }

    /**
     * 検索条件を作成します。
     *
     * @param hihokenshaNo 被保険者番号
     * @return 検索条件 検索条件
     */
    public ShinseiKensakuMapperParameter createParameter(RString hihokenshaNo) {
        return createParameter(hihokenshaNo, null);
    }

    public ShinseiKensakuMapperParameter createParameter(List<ShinseishoKanriNo> shinseishoKanriNos) {
        return createParameter(RString.EMPTY, shinseishoKanriNos);
    }

    private ShinseiKensakuMapperParameter createParameter(RString hihokenshaNo, List<ShinseishoKanriNo> shinseishoKanriNos) {
        ShinseiKensakuMapperParameter parameter = new ShinseiKensakuMapperParameter();
        parameter.setLimitCount(get最大表示件数());
        NinteiShinseishaFinderDiv finderDiv = div.getCcdNinteishinseishaFinder().getNinteiShinseishaFinderDiv();
        editShosaiJokenForParameter(finderDiv, parameter, hihokenshaNo);
        editNinteiChosaForParameter(finderDiv, parameter);
        editShujiiJohoForParameter(finderDiv, parameter);
        editShinsakaiJohoForParameter(finderDiv, parameter);
        editZenkaiJohoForParameter(finderDiv, parameter);
        editNowPhaseForParameter(finderDiv, parameter);
        editChkForParameter(finderDiv, parameter);
        parameter.setShinseishoKanriNos(shinseishoKanriNos);
        return parameter;
    }

    private int get最大表示件数() {
        return Integer.parseInt(div.getTxtMaxDisp().getValue().toString());
    }

    private void editShinsakaiJohoForParameter(NinteiShinseishaFinderDiv finderDiv, ShinseiKensakuMapperParameter parameter) {
        boolean useNinteiKekkaJoho = false;
        RString 二次判定要介護状態区分コード = finderDiv.getDdlNijiHanteiKekka().getSelectedKey();
        if (!RString.isNullOrEmpty(二次判定要介護状態区分コード)) {
            parameter.setNijiHanteiYokaigoJotaiKubun(二次判定要介護状態区分コード);
            parameter.setUseNijiHanteiYokaigoJotaiKubun(true);
            useNinteiKekkaJoho = true;
        }
        RString 認定有効期間 = finderDiv.getTxtNinteiYukoKikan().getValue();
        if (!RString.isNullOrEmpty(認定有効期間)) {
            parameter.setNijiHanteiNinteiYukoKikan(Integer.parseInt(認定有効期間.toString()));
            parameter.setUseNijiHanteiNinteiYukoKikan(true);
            useNinteiKekkaJoho = true;
        }
        RDate 認定有効な申請時点 = finderDiv.getTxtCheckDay().getValue();
        if (認定有効な申請時点 != null) {
            parameter.setYokaiYMD(認定有効な申請時点.toDateString());
            parameter.setUseYokaiYMD(true);
            useNinteiKekkaJoho = true;
        }
        RDate 認定有効開始日FROM = finderDiv.getTxtNinteiYukoKaishiDateRange().getFromValue();
        if (認定有効開始日FROM != null) {
            parameter.setNinteiYukoKaishiYMDFrom(new FlexibleDate(認定有効開始日FROM.toDateString()));
            parameter.setUseNinteiYukoKaishiYMDFrom(true);
            useNinteiKekkaJoho = true;
        }
        RDate 認定有効開始日To = finderDiv.getTxtNinteiYukoKaishiDateRange().getToValue();
        if (認定有効開始日To != null) {
            parameter.setNinteiYukoKaishiYMDTo(new FlexibleDate(認定有効開始日To.toDateString()));
            parameter.setUseNinteiYukoKaishiYMDTo(true);
            useNinteiKekkaJoho = true;
        }

        RDate 認定有効終了日FROM = finderDiv.getTxtNinteiYukoShuryoDateRange().getFromValue();
        if (認定有効終了日FROM != null) {
            parameter.setNinteiYukoShuryoYMDFrom(new FlexibleDate(認定有効終了日FROM.toDateString()));
            parameter.setUseNinteiYukoShuryoYMDFrom(true);
            useNinteiKekkaJoho = true;
        }
        RDate 認定有効終了日To = finderDiv.getTxtNinteiYukoShuryoDateRange().getToValue();
        if (認定有効終了日To != null) {
            parameter.setNinteiYukoShuryoYMDTo(new FlexibleDate(認定有効終了日To.toDateString()));
            parameter.setUseNinteiYukoShuryoYMDTo(true);
            useNinteiKekkaJoho = true;
        }
        RDate 二次判定日FROM = finderDiv.getTxtNijiHanteiDateRange().getFromValue();
        if (二次判定日FROM != null) {
            parameter.setNijiHanteiYMDFrom(new FlexibleDate(二次判定日FROM.toDateString()));
            parameter.setUseNijiHanteiYMDFrom(true);
            useNinteiKekkaJoho = true;
        }
        RDate 二次判定日To = finderDiv.getTxtNijiHanteiDateRange().getToValue();
        if (二次判定日To != null) {
            parameter.setNijiHanteiYMDTo(new FlexibleDate(二次判定日To.toDateString()));
            parameter.setUseNijiHanteiYMDTo(true);
            useNinteiKekkaJoho = true;
        }
        RString 開催番号FROM = finderDiv.getTxtKaisaiNumberStart().getValue();
        if (!RString.isNullOrEmpty(開催番号FROM)) {
            parameter.setShinsakaiKaisaiNoFrom(開催番号FROM);
            parameter.setUseShinsakaiKaisaiNoFrom(true);
            useNinteiKekkaJoho = true;
        }
        RString 開催番号To = finderDiv.getTxtKaisaiNumberEnd().getValue();
        if (!RString.isNullOrEmpty(開催番号To)) {
            parameter.setShinsakaiKaisaiNoTo(開催番号To);
            parameter.setUseShinsakaiKaisaiNoTo(true);
            useNinteiKekkaJoho = true;
        }

        parameter.setUseNinteiKekkaJoho(useNinteiKekkaJoho);
        editKaisaiDateForParameter(finderDiv, parameter);
    }

    private void editKaisaiDateForParameter(NinteiShinseishaFinderDiv finderDiv, ShinseiKensakuMapperParameter parameter) {
        boolean useShinsakaiKaisaiKekkaJoho = false;
        RDate 開催日FROM = finderDiv.getTxtKaisaiDateRange().getFromValue();
        if (開催日FROM != null) {
            parameter.setShinsakaiKaisaiYMDFrom(new FlexibleDate(開催日FROM.toDateString()));
            parameter.setUseShinsakaiKaisaiYMDFrom(true);
            useShinsakaiKaisaiKekkaJoho = true;
        }
        RDate 開催日To = finderDiv.getTxtKaisaiDateRange().getToValue();
        if (開催日To != null) {
            parameter.setShinsakaiKaisaiYMDTo(new FlexibleDate(開催日To.toDateString()));
            parameter.setUseShinsakaiKaisaiYMDTo(true);
            useShinsakaiKaisaiKekkaJoho = true;
        }
        parameter.setUseShinsakaiKaisaiKekkaJoho(useShinsakaiKaisaiKekkaJoho);
    }

    private void editZenkaiJohoForParameter(NinteiShinseishaFinderDiv finderDiv, ShinseiKensakuMapperParameter parameter) {
        RString 前回認定調査委託先 = finderDiv.getTxtZenkaiNinteiChosaItakusakiName().getValue();
        if (!RString.isNullOrEmpty(前回認定調査委託先)) {
            parameter.setZenkaiNinteiChosaItakusaki(finderDiv.getHdnZenkaiChosaItakusakiCode());
            parameter.setUseZenkaiNinteiChosaItakusaki(true);
        }
        RString 前回主治医医療機関 = finderDiv.getTxtZenkaiShujiiIryokikanName().getValue();
        if (!RString.isNullOrEmpty(前回主治医医療機関)) {
            parameter.setZenkaiShujiiIryokikanCode(finderDiv.getHdnZenkaiShujiiIryokikanCode());
            parameter.setUseZenkaiShujiiIryokikanCode(true);
        }

        RString 前回二次判定結果コード = finderDiv.getDdlZenkaiNijiHanteiKekka().getSelectedKey();
        if (!RString.isNullOrEmpty(前回二次判定結果コード)) {
            parameter.setZenkaiJotaiKubunCode(前回二次判定結果コード);
            parameter.setUseZenkaiJotaiKubunCode(true);
        }

        RString 前回認定有効期間 = finderDiv.getTxtZenkaiNinteiYukoKikan().getValue();
        if (!RString.isNullOrEmpty(前回認定有効期間)) {
            parameter.setZenkaiYukoKikan(Integer.parseInt(前回認定有効期間.toString()));
            parameter.setUseZenkaiYukoKikan(true);
        }

        RDate 設定有効開始日FROM = finderDiv.getTxtZenkaiYukoKaishiDateRange().getFromValue();
        if (設定有効開始日FROM != null) {
            parameter.setZenkaiYukoKikanStartFrom(new FlexibleDate(設定有効開始日FROM.toDateString()));
            parameter.setUseZenkaiYukoKikanStartFrom(true);
        }
        RDate 設定有効開始日To = finderDiv.getTxtZenkaiYukoKaishiDateRange().getToValue();
        if (設定有効開始日To != null) {
            parameter.setZenkaiYukoKikanStartTo(new FlexibleDate(設定有効開始日To.toDateString()));
            parameter.setUseZenkaiYukoKikanStartTo(true);
        }
// <<<<<<< HEAD
        RString 原因疾患 = finderDiv.getCcdGeninShikkan().getCode().value();
        if (!RString.isNullOrEmpty(原因疾患)) {
            parameter.setGeninShikkanCode(原因疾患);
// =======
//      Code 原因疾患 = finderDiv.getCdlGeninShikkanCode().getCode();
//      if (原因疾患 != null && !RString.isNullOrEmpty(原因疾患.value())) {
//          parameter.setGeninShikkanCode(原因疾患.value());
// >>>>>>> origin/sync
            parameter.setUseGeninShikkanCode(true);
            parameter.setUseGeninShikkan(true);
        }
        Decimal 申請経過日数FROM = finderDiv.getTxtShinseiKeikaNissu().getFromValue();
        FlexibleDate nowDate = FlexibleDate.getNowDate();
        if (申請経過日数FROM != null) {
            parameter.setShinseiKeikaDaysForm(nowDate.minusDay(申請経過日数FROM.intValue()));
            parameter.setUseShinseiKeikaDaysForm(true);
        }
        Decimal 申請経過日数To = finderDiv.getTxtShinseiKeikaNissu().getToValue();
        if (申請経過日数To != null) {
            parameter.setShinseiKeikaDaysTo(nowDate.minusDay(申請経過日数To.intValue()));
            parameter.setUseShinseiKeikaDaysTo(true);
        }
    }

    private void editShujiiJohoForParameter(NinteiShinseishaFinderDiv finderDiv, ShinseiKensakuMapperParameter parameter) {
        RString 主治医医療機関 = finderDiv.getTxtShujiiIryokikanName().getValue();
        if (!RString.isNullOrEmpty(主治医医療機関)) {
            parameter.setShujiiIryokikanCode(finderDiv.getHdnShujiiIryokikanCode());
            parameter.setUseShujiiIryokikanCode(true);
            parameter.setShujiiShichosonCode(finderDiv.getHdnShujiiShichosonCode());
            parameter.setUseShujiiShichosonCode(true);
        }
        RString 主治医氏名 = finderDiv.getTxtShujiiName().getValue();
        if (!RString.isNullOrEmpty(主治医氏名)) {
            parameter.setShujiiCode(finderDiv.getHdnShujiiCode());
            parameter.setUseShujiiCode(true);
        }

        RString 医師区分コード = finderDiv.getDdlShujiIkubun().getSelectedKey();
        if (!RString.isNullOrEmpty(医師区分コード)) {
            parameter.setIshiKubunCode(医師区分コード);
            parameter.setUseIshiKubunCode(true);
            parameter.setUseShujiiIkenshoIraiJoho(true);
        }
        boolean useShujiiIkenshoJoho = false;
        RDate 意見書受領日FROM = finderDiv.getTxtIkenshoKinyuDateRange().getFromValue();
        if (意見書受領日FROM != null) {
            parameter.setIkenshoJuryoYMDFrom(new FlexibleDate(意見書受領日FROM.toDateString()));
            parameter.setUseIkenshoJuryoYMDFrom(true);
            useShujiiIkenshoJoho = true;
        }
        RDate 意見書受領日To = finderDiv.getTxtIkenshoKinyuDateRange().getToValue();
        if (意見書受領日To != null) {
            parameter.setIkenshoJuryoYMDTo(new FlexibleDate(意見書受領日To.toDateString()));
            useShujiiIkenshoJoho = true;
        }
        parameter.setUseShujiiIkenshoJoho(useShujiiIkenshoJoho);
        boolean useShujiiIkenshoIkenItem = false;
        RString 意見項目13 = finderDiv.getDdlShujiJohoNetakirido().getSelectedKey();
        if (!RString.isNullOrEmpty(意見項目13)) {
            parameter.setIkenItem13(意見項目13);
            parameter.setUseIkenItem13(true);
            useShujiiIkenshoIkenItem = true;
        }
        RString 意見項目14 = finderDiv.getDdlShujiJohoNinchido().getSelectedKey();
        if (!RString.isNullOrEmpty(意見項目14)) {
            parameter.setIkenItem14(意見項目14);
            parameter.setUseIkenItem14(true);
            useShujiiIkenshoIkenItem = true;
        }
        parameter.setUseShujiiIkenshoIkenItem(useShujiiIkenshoIkenItem);
        boolean useIchijiHanteiKekkaJoho = false;
        RDate 一次判定日FROM = finderDiv.getTxtIchijiHanteiDateRange().getFromValue();
        if (一次判定日FROM != null) {
            parameter.setIchijiHanteiYMDFrom(new FlexibleDate(一次判定日FROM.toDateString()));
            parameter.setUseIchijiHanteiYMDFrom(true);
            useIchijiHanteiKekkaJoho = true;
        }
        RDate 一次判定日To = finderDiv.getTxtIchijiHanteiDateRange().getToValue();
        if (一次判定日To != null) {
            parameter.setIchijiHanteiYMDTo(new FlexibleDate(一次判定日To.toDateString()));
            parameter.setUseIchijiHanteiYMDTo(true);
            useIchijiHanteiKekkaJoho = true;
        }
        RString 一次判定結果コード = finderDiv.getDdlIchijiHanteiKekka().getSelectedKey();
        if (!RString.isNullOrEmpty(一次判定結果コード)) {
            parameter.setIchijiHanteiKekkaCode(一次判定結果コード);
            parameter.setUseIchijiHanteiKekkaCode(true);
            useIchijiHanteiKekkaJoho = true;
        }
        parameter.setUseIchijiHanteiKekkaJoho(useIchijiHanteiKekkaJoho);
        editIchiGohanteiForParameter(finderDiv, parameter);
    }

    private void editIchiGohanteiForParameter(NinteiShinseishaFinderDiv finderDiv, ShinseiKensakuMapperParameter parameter) {
        boolean useIchiGojiHanteiKekkaJoho = false;
        RDate ichiGoHanteiDateFrom = finderDiv.getTxtIchiGoHanteiDateRange().getFromValue();
        if (ichiGoHanteiDateFrom != null) {
            parameter.setIchiGojiHanteiYMDFrom(new FlexibleDate(ichiGoHanteiDateFrom.toDateString()));
            parameter.setUseIchiGojiHanteiYMDFrom(true);
            useIchiGojiHanteiKekkaJoho = true;
        }
        RDate ichiGoHanteiDateTo = finderDiv.getTxtIchiGoHanteiDateRange().getToValue();
        if (ichiGoHanteiDateTo != null) {
            parameter.setIchiGojiHanteiYMDTo(new FlexibleDate(ichiGoHanteiDateTo.toDateString()));
            parameter.setUseIchiGojiHanteiYMDTo(true);
            useIchiGojiHanteiKekkaJoho = true;
        }
        RString ichiGohanteiKekka = finderDiv.getDdlIchiGohanteiKekka().getSelectedKey();
        if (!RString.isNullOrEmpty(ichiGohanteiKekka)) {
            parameter.setIchiGojiHanteiKekkaCode(ichiGohanteiKekka);
            parameter.setUseIchiGojiHanteiKekkaCode(true);
            useIchiGojiHanteiKekkaJoho = true;
        }
        parameter.setUseIchiGojiHanteiKekkaJoho(useIchiGojiHanteiKekkaJoho);
    }

    private void editNinteiChosaForParameter(NinteiShinseishaFinderDiv finderDiv, ShinseiKensakuMapperParameter parameter) {
        RString 被保険者区分コード = finderDiv.getDdlHihokenshaKubun().getSelectedKey();
        if (!RString.isNullOrEmpty(被保険者区分コード)) {
            parameter.setHihokenshaKubunCode(被保険者区分コード);
            parameter.setUseHihokenshaKubunCode(true);
        }
        RString 認定申請区分法令コード = finderDiv.getDdlHoreiShinseiji().getSelectedKey();
        if (!RString.isNullOrEmpty(認定申請区分法令コード)) {
            parameter.setNinteiShinseiHoreiKubunCode(認定申請区分法令コード);
            parameter.setUseNinteiShinseiHoreiKubunCode(true);
        }
        RString 処理状態区分 = finderDiv.getDdlShoriKubun().getSelectedKey();
        if (!RString.isNullOrEmpty(処理状態区分)) {
            parameter.setShoriJotaiKubun(処理状態区分);
            parameter.setUseShoriJotaiKubun(true);
        }
        RString 厚労省IF識別コード = finderDiv.getDdlKoroshoShikibetsuCode().getSelectedKey();
        if (!RString.isNullOrEmpty(厚労省IF識別コード)) {
            parameter.setKoroshoIfShikibetsuCode(厚労省IF識別コード);
            parameter.setUseKoroshoIfShikibetsuCode(true);
        }
        RString 郵便番号 = finderDiv.getTxtYubinNo().getValue().value();
        if (!RString.isNullOrEmpty(郵便番号)) {
            parameter.setYubinNo(郵便番号);
            parameter.setUseYubinNo(true);
        }
        RString 地区コード = finderDiv.getDdlChiku().getSelectedKey();
        if (!RString.isNullOrEmpty(地区コード)) {
            parameter.setChikuCode(地区コード);
            parameter.setUseChikuCode(true);
        }
        List<RString> 施設入所の有無List = finderDiv.getChkShisetsuNyusho().getSelectedKeys();
        boolean isAllSelectableOrNoSelected = finderDiv.getChkShisetsuNyusho().isAllSelected() || 施設入所の有無List.isEmpty();
        if (!isAllSelectableOrNoSelected) {
            RString 施設入所の有無 = 施設入所の有無List.get(0);
            if (KEY0.equals(施設入所の有無)) {
                parameter.setShisetsuNyushoFlag(true);
            }
            if (KEY1.equals(施設入所の有無)) {
                parameter.setShisetsuNyushoFlag(false);
            }
            parameter.setIgnoreShisetsuNyusho(false);
        } else {
            parameter.setShisetsuNyushoFlag(false);
            parameter.setIgnoreShisetsuNyusho(true);
        }

        RString 認定調査委託先コード = finderDiv.getTxtNinteiChosaItakusakiName().getValue();
        if (!RString.isNullOrEmpty(認定調査委託先コード)) {
            parameter.setNinteiChosaItakusakiCode(finderDiv.getHdnChosaItakusakiCode());
            parameter.setUseNinteiChosaItakusakiCode(true);
            parameter.setChosaShichosonCode(finderDiv.getHdnChosaShichosonCode());
            parameter.setUseChosaShichosonCode(true);
        }

        RString 認定調査員氏名 = finderDiv.getTxtNinteiChosainName().getValue();
        if (!RString.isNullOrEmpty(認定調査員氏名)) {
            parameter.setNinteiChosainCode(finderDiv.getHdnChosainCode());
            parameter.setUseNinteiChosainCode(true);
        }
        boolean useNinteichosahyoGaikyoChosa = false;
        RString 認定調査実施場所コード = finderDiv.getDdlChosaJisshiBasho().getSelectedKey();
        if (!RString.isNullOrEmpty(認定調査実施場所コード)) {
            parameter.setChosaJisshiBashoCode(認定調査実施場所コード);
            parameter.setUseChosaJisshiBashoCode(true);
            useNinteichosahyoGaikyoChosa = true;
        }
        RString 認定調査区分コード = finderDiv.getDdlChosaKubun().getSelectedKey();
        if (!RString.isNullOrEmpty(認定調査区分コード)) {
            parameter.setNinteiChosaKubunCode(認定調査区分コード);
            parameter.setUseNinteiChosaKubunCode(true);
            useNinteichosahyoGaikyoChosa = true;
        }
        RDate 調査実施日FROM = finderDiv.getTxtChosaJisshiDateRange().getFromValue();
        if (調査実施日FROM != null) {
            parameter.setNinteichosaJisshiYMDFrom(new FlexibleDate(調査実施日FROM.toDateString()));
            parameter.setUseNinteichosaJisshiYMDFrom(true);
            useNinteichosahyoGaikyoChosa = true;
        }
        RDate 調査実施日TO = finderDiv.getTxtChosaJisshiDateRange().getToValue();
        if (調査実施日TO != null) {
            parameter.setNinteichosaJisshiYMDTo(new FlexibleDate(調査実施日TO.toDateString()));
            parameter.setUseNinteichosaJisshiYMDTo(true);
            useNinteichosahyoGaikyoChosa = true;
        }
        parameter.setUseNinteichosahyoGaikyoChosa(useNinteichosahyoGaikyoChosa);
        boolean useNinteichosahyoKihonChosa = false;
        RString 寝きたり度 = finderDiv.getDdlNinteiChosaNetakirido().getSelectedKey();
        if (!RString.isNullOrEmpty(寝きたり度)) {
            parameter.setNichijoSeikatsuJiritsudoCode(寝きたり度);
            parameter.setUseNichijoSeikatsuJiritsudoCd(true);
            useNinteichosahyoKihonChosa = true;
        }
        RString 認知度 = finderDiv.getDdlNinteiChosaNinchido().getSelectedKey();
        if (!RString.isNullOrEmpty(認知度)) {
            parameter.setNichijoSeikatsuJiritsudo(認知度);
            parameter.setUseNichijoSeikatsuJiritsudo(true);
            useNinteichosahyoKihonChosa = true;
        }
        parameter.setUseNinteichosahyoKihonChosa(useNinteichosahyoKihonChosa);
    }

    private void editShosaiJokenForParameter(NinteiShinseishaFinderDiv finderDiv, ShinseiKensakuMapperParameter parameter, RString 被保険者番号) {
        if (!RString.isNullOrEmpty(被保険者番号)) {
            parameter.setHihokenshaNo(被保険者番号);
            parameter.setUseHihokenshaNo(true);
        }
        RString 証記載保険者番号 = finderDiv.getDdlHokenshaNumber().getSelectedItem().get証記載保険者番号().value();
        if (!RString.isNullOrEmpty(証記載保険者番号)) {
            parameter.setShoKisaiHokenshaNo(証記載保険者番号);
            parameter.setUseShoKisaiHokenshaNo(true);
        }

        RString 支所コード = finderDiv.getDdlShichosonCode().getSelectedKey();
        if (!RString.isNullOrEmpty(支所コード)) {
            parameter.setShishoCode(支所コード);
            parameter.setUseShishoCode(true);
        }

        RString 被保険者氏名 = finderDiv.getTxtHihokenshaName().getValue().replace(RString.FULL_SPACE, RString.EMPTY);
        if (!RString.isNullOrEmpty(被保険者氏名)) {
            RString hihokenshaNameMatchType = finderDiv.getDdlHihokenshaNameMatchType().getSelectedKey();
            if (KEY0.equals(hihokenshaNameMatchType)) {
                parameter.set前方一致(true);
            } else if (KEY1.equals(hihokenshaNameMatchType)) {
                parameter.set完全一致(true);
            } else if (KEY2.equals(hihokenshaNameMatchType)) {
                parameter.set部分一致(true);
            } else if (KEY3.equals(hihokenshaNameMatchType)) {
                parameter.set後方一致(true);
            }
            parameter.set被保険者名(被保険者氏名);
        }
        List<KeyValueDataSource> みなし２号申請 = finderDiv.getChkMinashiFlag().getSelectedItems();
        if (みなし２号申請.isEmpty()) {
            //parameter.setMinashiNigoEtcTaishoFlag(false);
        } else {
            parameter.setMinashiNigoEtcTaishoFlag(true);
        }
        RDate 認定申請日FROM = finderDiv.getTxtNinteiShinseiDateRange().getFromValue();
        if (認定申請日FROM != null) {
            parameter.setNinteiShinseiYMDFrom(new FlexibleDate(認定申請日FROM.toDateString()));
            parameter.setUseNinteiShinseiYMDFrom(true);
        }

        RDate 認定申請日To = finderDiv.getTxtNinteiShinseiDateRange().getToValue();
        if (認定申請日To != null) {
            parameter.setNinteiShinseiYMDTo(new FlexibleDate(認定申請日To.toDateString()));
            parameter.setUseNinteiShinseiYMDTo(true);
        }
        RDate 生年月日From = finderDiv.getTxtBirthDateRange().getFromValue();
        if (生年月日From != null) {
            parameter.setSeinengappiYMDFrom(new FlexibleDate(生年月日From.toDateString()));
            parameter.setUseSeinengappiYMDFrom(true);
        }
        RDate 生年月日To = finderDiv.getTxtBirthDateRange().getToValue();
        if (生年月日To != null) {
            parameter.setSeinengappiYMDTo(new FlexibleDate(生年月日To.toDateString()));
            parameter.setUseSeinengappiYMDTo(true);
        }
        RString 認定申請区分申請時コード = finderDiv.getDdlShinseijiShinseiKubun().getSelectedKey();
        if (!RString.isNullOrEmpty(認定申請区分申請時コード)) {
            parameter.setNinteiShinseiShinseijiKubun(認定申請区分申請時コード);
            parameter.setUseNinteiShinseiShinseijiKubun(true);
        }
        if (finderDiv.getChkTennyu().getSelectedKeys().contains(KEY0)) {
            parameter.setUseChkTennyu(true);
        }
        edit性別ForParameter(finderDiv, parameter);
    }

    private void edit性別ForParameter(NinteiShinseishaFinderDiv finderDiv, ShinseiKensakuMapperParameter parameter) {
        List<KeyValueDataSource> 性別 = finderDiv.getChkSeibetsu().getSelectedItems();
        for (KeyValueDataSource keyValueDataSource : 性別) {
            if (KEY0.equals(keyValueDataSource.getKey())) {
                parameter.setMan(true);
            }
            if (KEY1.equals(keyValueDataSource.getKey())) {
                parameter.setWoman(true);
            }
        }
    }

    private void editChkForParameter(NinteiShinseishaFinderDiv finderDiv, ShinseiKensakuMapperParameter parameter) {
        boolean useNinteiKanryoJoho = false;
        List<KeyValueDataSource> 申請受付処理状態CHK = finderDiv.getChkShinseiUketsuke().getSelectedItems();
        for (KeyValueDataSource keyValueDataSource : 申請受付処理状態CHK) {
            if (KEY0.equals(keyValueDataSource.getKey())) {
                parameter.setShinseiUketsukeKanryo(true);
                useNinteiKanryoJoho = true;
            }
            if (KEY1.equals(keyValueDataSource.getKey())) {
                parameter.setShinseiUketsukeMiKanryo(true);
                useNinteiKanryoJoho = true;
            }
        }

        List<KeyValueDataSource> 調査依頼処理状態CHK = finderDiv.getChkChosaIrai().getSelectedItems();
        for (KeyValueDataSource keyValueDataSource : 調査依頼処理状態CHK) {
            if (KEY0.equals(keyValueDataSource.getKey())) {
                parameter.setChosaIraiKanryo(true);
                useNinteiKanryoJoho = true;
            }
            if (KEY1.equals(keyValueDataSource.getKey())) {
                parameter.setChosaIraiMiKanryo(true);
                useNinteiKanryoJoho = true;
            }
        }
        List<KeyValueDataSource> 意見書依頼処理状態CHK = finderDiv.getChkIkenshoIrai().getSelectedItems();
        for (KeyValueDataSource keyValueDataSource : 意見書依頼処理状態CHK) {
            if (KEY0.equals(keyValueDataSource.getKey())) {
                parameter.setIkenshoIraiKanryo(true);
                useNinteiKanryoJoho = true;
            }
            if (KEY1.equals(keyValueDataSource.getKey())) {
                parameter.setIkenshoIraiMiKanryo(true);
                useNinteiKanryoJoho = true;
            }
        }
        List<KeyValueDataSource> 調査入手処理状態CHK = finderDiv.getChkChosaNyushu().getSelectedItems();
        for (KeyValueDataSource keyValueDataSource : 調査入手処理状態CHK) {
            if (KEY0.equals(keyValueDataSource.getKey())) {
                parameter.setChosaNyushuKanryo(true);
                useNinteiKanryoJoho = true;
            }
            if (KEY1.equals(keyValueDataSource.getKey())) {
                parameter.setChosaNyushuMiKanryo(true);
                useNinteiKanryoJoho = true;
            }
        }
        List<KeyValueDataSource> 意見書入手処理状態CHK = finderDiv.getChkIkenshoNyushu().getSelectedItems();
        for (KeyValueDataSource keyValueDataSource : 意見書入手処理状態CHK) {
            if (KEY0.equals(keyValueDataSource.getKey())) {
                parameter.setIkenshoNyushuKanryo(true);
                useNinteiKanryoJoho = true;
            }
            if (KEY1.equals(keyValueDataSource.getKey())) {
                parameter.setIkenshoNyushuMiKanryo(true);
                useNinteiKanryoJoho = true;
            }
        }
        List<KeyValueDataSource> 一次判定処理状態CHK = finderDiv.getChkIchijiHantei().getSelectedItems();
        for (KeyValueDataSource keyValueDataSource : 一次判定処理状態CHK) {
            if (KEY0.equals(keyValueDataSource.getKey())) {
                parameter.setIchijiHanteiKanryo(true);
                useNinteiKanryoJoho = true;
            }
            if (KEY1.equals(keyValueDataSource.getKey())) {
                parameter.setIchijiHanteiMiKanryo(true);
                useNinteiKanryoJoho = true;
            }
        }
        parameter.setUseNinteiKanryoJoho(useNinteiKanryoJoho);
        editChkForParameter2(finderDiv, parameter);
    }

    private void editChkForParameter2(NinteiShinseishaFinderDiv finderDiv, ShinseiKensakuMapperParameter parameter) {
        boolean useNinteiKanryoJoho = parameter.isUseNinteiKanryoJoho();
        List<KeyValueDataSource> マスキング処理状態CHK = finderDiv.getChkMasking().getSelectedItems();
        for (KeyValueDataSource keyValueDataSource : マスキング処理状態CHK) {
            if (KEY0.equals(keyValueDataSource.getKey())) {
                parameter.setMaskingKanryo(true);
                useNinteiKanryoJoho = true;
            }
            if (KEY1.equals(keyValueDataSource.getKey())) {
                parameter.setMaskingMiKanryo(true);
                useNinteiKanryoJoho = true;
            }
        }
        List<KeyValueDataSource> 審査会登録処理状態CHK = finderDiv.getChkShinsakaiToroku().getSelectedItems();
        for (KeyValueDataSource keyValueDataSource : 審査会登録処理状態CHK) {
            if (KEY0.equals(keyValueDataSource.getKey())) {
                parameter.setShinsakaiTorokuKanryo(true);
                useNinteiKanryoJoho = true;
            }
            if (KEY1.equals(keyValueDataSource.getKey())) {
                parameter.setShinsakaiTorokuMiKanryo(true);
                useNinteiKanryoJoho = true;
            }
        }
        List<KeyValueDataSource> 二次判定処理状態CHK = finderDiv.getChkNijiHantei().getSelectedItems();
        for (KeyValueDataSource keyValueDataSource : 二次判定処理状態CHK) {
            if (KEY0.equals(keyValueDataSource.getKey())) {
                parameter.setNijiHanteiKanryo(true);
                useNinteiKanryoJoho = true;
            }
            if (KEY1.equals(keyValueDataSource.getKey())) {
                parameter.setNijiHanteiMiKanryo(true);
                useNinteiKanryoJoho = true;
            }
        }
        List<KeyValueDataSource> 月例処理処理状態CHK = finderDiv.getChkGetsureiShori().getSelectedItems();
        for (KeyValueDataSource keyValueDataSource : 月例処理処理状態CHK) {
            if (KEY0.equals(keyValueDataSource.getKey())) {
                parameter.setGetsureiShoriKanryo(true);
                useNinteiKanryoJoho = true;
            }
            if (KEY1.equals(keyValueDataSource.getKey())) {
                parameter.setGetsureiShoriMiKanryo(true);
                useNinteiKanryoJoho = true;
            }
        }
        parameter.setUseNinteiKanryoJoho(useNinteiKanryoJoho);
    }

    private void editNowPhaseForParameter(NinteiShinseishaFinderDiv finderDiv, ShinseiKensakuMapperParameter parameter) {
        parameter.setNowPhaseBlank(true);
    }

    /**
     * 申請一覧Gridにデータを設定します。
     *
     * @param searchResult 検索結果
     */
    public void setShinseiJohoIchiran(SearchResult<ShinseiKensakuBusiness> searchResult) {
        List<dgShinseiJoho_Row> dataSource = new ArrayList<>();
        for (ShinseiKensakuBusiness business : searchResult.records()) {
            dgShinseiJoho_Row row = new dgShinseiJoho_Row();
            row.setHokensha(nullToEmpty(business.get市町村名称()));
            row.setHihokenshaNo(nullToEmpty(business.get被保険者番号()));
            AtenaMeisho 被保険者氏名 = business.get被保険者氏名();
            if (被保険者氏名 != null) {
                row.setShimei(nullToEmpty(被保険者氏名.getColumnValue()));
            }
            FlexibleDate 生年月日 = business.get生年月日();
            if (生年月日 != null && !生年月日.isEmpty()) {
                TextBoxDate hihokenshaBirthDay = new TextBoxDate();
                hihokenshaBirthDay.setValue(new RDate(生年月日.toString()));
                row.setHihokenshaBirthDay(hihokenshaBirthDay);
            }

            row.setHihokenshaNenrei(createTextBoxNum(new Decimal(business.get年齢())));
            Code 性別 = business.get性別();
            if (性別 != null) {
                row.setHihokenshaSeibetsu(Seibetsu.toValue(性別.value()).get名称());
            }
            FlexibleDate 認定申請年月日 = business.get認定申請年月日();
            if (認定申請年月日 != null && !認定申請年月日.isEmpty()) {
                TextBoxDate shinseiDay = new TextBoxDate();
                shinseiDay.setValue(new RDate(認定申請年月日.toString()));
                row.setShinseiDay(shinseiDay);
            }
            Code 申請時_コード = business.get認定申請区分_申請時_コード();
            if (申請時_コード != null) {
                row.setShinseikubunshinseiji(NinteiShinseiShinseijiKubunCode.toValue(申請時_コード.value()).get名称());
            }
            YubinNo 郵便番号 = business.get郵便番号();
            if (郵便番号 != null) {
                row.setYubinno(郵便番号.getEditedYubinNo());
            }
            TelNo 電話番号 = business.get電話番号();
            if (電話番号 != null) {
                row.setTelno(電話番号.value());
            }
            AtenaJusho 住所 = business.get住所();
            if (住所 != null) {
                row.setJyusho(住所.getColumnValue());
            }
            ShinseishoKanriNo 申請書管理番号 = business.get申請書管理番号();
            if (申請書管理番号 != null) {
                row.setShinseishoKanriNo(申請書管理番号.value());
            }
            row.setShoKisaiHokenshaNo(nullToEmpty(business.get証記載保険者番号()));
            row.setIkenshoIraiRirekiNo(new RString(String.valueOf(business.get主治医意見書作成依頼履歴番号())));
            row.setNinteichosaIraiRirekiNo(new RString(String.valueOf(business.get認定調査依頼履歴番号())));
            dataSource.add(row);
        }
        div.getDgShinseiJoho().setDataSource(dataSource);
        div.getDgShinseiJoho().getGridSetting().setLimitRowCount(get最大表示件数());
        div.getDgShinseiJoho().getGridSetting().setSelectedRowCount(searchResult.totalCount());
    }

    private RString nullToEmpty(RString obj) {
        if (obj == null) {
            return RString.EMPTY;
        } else {
            return obj;
        }
    }

    private TextBoxNum createTextBoxNum(Decimal num) {
        TextBoxNum textBoxNum = new TextBoxNum();
        textBoxNum.setValue(num);
        return textBoxNum;
    }
}
