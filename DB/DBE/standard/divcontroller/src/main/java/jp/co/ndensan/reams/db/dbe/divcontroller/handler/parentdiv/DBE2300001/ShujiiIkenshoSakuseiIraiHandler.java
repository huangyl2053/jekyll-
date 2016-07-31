/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE2300001;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.shujiiikenshosakuseiirai.Shujiiikenshosakuseiirai;
import jp.co.ndensan.reams.db.dbe.definition.core.ShujiiIkenshoIraiKubun;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.shujiiikenshosakuseiirai.ShujiiIkenshoSakuseiIraiParameter;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2300001.ShujiiIkenshoSakuseiIraiDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2300001.dgShinseishaIchiran_Row;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBE;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBU;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.definition.core.dokuji.KanryoInfoPhase;
import jp.co.ndensan.reams.db.dbz.definition.core.seibetsu.Seibetsu;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ikensho.IshiKubunCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.NinteiShinseiShinseijiKubunCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.ShoriJotaiKubun;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.NinteiShinseishaFinder.NinteiShinseishaFinder.NinteiShinseishaFinderDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.shujiiIryokikanandshujiiinput.ShujiiIryokikanAndShujiiInput.IShujiiIryokikanAndShujiiInputDiv;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;

/**
 * 主治医意見書作成依頼のHandlerクラスです。
 *
 * @reamsid_L DBE-0050-010 zuotao
 */
public class ShujiiIkenshoSakuseiIraiHandler {

    private static final RString 主治医意見書作成期限設定方法_2 = new RString("2");
    private static final RString 新規 = new RString("新規");
    private static final RString 修正 = new RString("修正");
    private static final RString 削除 = new RString("削除");
    private static final RString KEY0 = new RString("key0");
    private static final RString KEY1 = new RString("key1");
    private static final RString KEY2 = new RString("key2");
    private static final RString KEY3 = new RString("key3");
    private final ShujiiIkenshoSakuseiIraiDiv div;

    /**
     * コンストラクタです。
     *
     * @param div ShujiiIkenshoSakuseiIraiDiv
     */
    public ShujiiIkenshoSakuseiIraiHandler(ShujiiIkenshoSakuseiIraiDiv div) {
        this.div = div;
    }

    /**
     * 画面初期設定します。
     */
    public void load() {
        div.getCcdNinteishinseishaFinder().initialize();
        div.getCcdShujiiIryoKikanAndShujiiInput().initialize(
                div.getCcdNinteishinseishaFinder().getNinteiShinseishaFinderDiv().getDdlHokenshaNumber().getSelectedItem().get市町村コード(),
                ShinseishoKanriNo.EMPTY, SubGyomuCode.DBE認定支援);
        div.getDgShinseishaIchiran().setDataSource(Collections.<dgShinseishaIchiran_Row>emptyList());
        div.getTxtMaxDisp().setValue(new Decimal(DbBusinessConfig.get(ConfigNameDBU.検索制御_最大取得件数, RDate.getNowDate(),
                SubGyomuCode.DBU介護統計報告).toString()));
    }

    /**
     * 申請者一覧を設定します。
     *
     * @param 申請者情報一覧 申請者情報一覧
     */
    public void init(List<Shujiiikenshosakuseiirai> 申請者情報一覧) {
        set申請者一覧(申請者情報一覧);
        if (主治医意見書作成期限設定方法_2.equals(
                DbBusinessConfig.get(ConfigNameDBE.主治医意見書作成期限設定方法, RDate.getNowDate(), SubGyomuCode.DBE認定支援))) {
            div.getRadkigen().setDisabled(true);
            div.getTxtkigenymd().setDisabled(true);
        } else {
            div.getRadkigen().setDisabled(false);
            div.getTxtkigenymd().setDisabled(false);
        }
    }

    private void set申請者一覧(List<Shujiiikenshosakuseiirai> 申請者情報一覧) {
        List<dgShinseishaIchiran_Row> 申請者一覧 = new ArrayList<>();
        for (Shujiiikenshosakuseiirai 申請者 : 申請者情報一覧) {
            dgShinseishaIchiran_Row row = new dgShinseishaIchiran_Row();
            row.setHihokenshaNo(申請者.get被保険者番号());
            if (申請者.getTemp_被保険者氏名() != null) {
                row.setHihokennshaShimei(申請者.getTemp_被保険者氏名().value());
            }
            row.setSeibetsu(Seibetsu.toValue(申請者.getTemp_性別().value()).get名称());
            if (申請者.getTemp_認定申請日() != null) {
                row.getShinseiDay().setValue(new RDate(申請者.getTemp_認定申請日().toString()));
            }
            if (申請者.getTemp_申請区分() != null) {
                row.setShinseiKubunShinseiji(NinteiShinseiShinseijiKubunCode.toValue(申請者.getTemp_申請区分().getKey()).get名称());
            }
            if (申請者.getTemp_住所() != null) {
                row.setJusho(申請者.getTemp_住所().value());
            }
            row.setShujiiIryoKikan(申請者.getTemp_主治医医療機関());
            if (申請者.getTemp_主治医() != null) {
                row.setShujii(申請者.getTemp_主治医().value());
            }
            if (申請者.getTemp_主治医意見書作成依頼日() != null) {
                row.getShujiiIkenshoSakuseiIraiDay().setValue(new RDate(申請者.getTemp_主治医意見書作成依頼日().toString()));
            }
            if (!RString.isNullOrEmpty(申請者.getTemp_主治医意見書依頼区分())) {
                row.setIraiKubun(new RString(ShujiiIkenshoIraiKubun.toValue(申請者.getTemp_主治医意見書依頼区分()).name()));
            }
            row.setHokensha(申請者.getTemp_保険者名称());
            row.setZenkaiShujiiIryoKikan(申請者.getTemp_前回主治医医療機関());
            if (申請者.getTemp_前回主治医() != null) {
                row.setZenkaiShujii(申請者.getTemp_前回主治医().value());
            }
            if (!isEmpty(申請者.getTemp_依頼書出力年月日())) {
                row.getIraishoShutsuryokuDay().setValue(new RDate(申請者.getTemp_依頼書出力年月日().toString()));
            }
            if (!isEmpty(申請者.getTemp_意見書出力年月日())) {
                row.getIkenshoShutsuryokuDay().setValue(new RDate(申請者.getTemp_意見書出力年月日().toString()));
            }
            if (!isEmpty(申請者.getTemp_請求書出力年月日())) {
                row.getSeikyushoShutsuryokuDay().setValue(new RDate(申請者.getTemp_請求書出力年月日().toString()));
            }
            row.setShujiiIryoKikanCode(申請者.getTemp_主治医医療機関コード());
            row.setShujiiCode(申請者.getTemp_主治医コード());
            row.setRirekiNo(new RString(String.valueOf(申請者.getTemp_最大履歴番号())));
            row.setPreRirekiNo(new RString(String.valueOf(申請者.getTemp_前回最大履歴番号())));
            row.setSakujoKbn(Boolean.FALSE);
            row.setShiseishoKanriNo(申請者.getTemp_申請書管理番号().value());
            row.setKoroshoIfShikibetsuCode(申請者.getTemp_厚労省IF識別コード().getKey());
            row.setIryoukikanShozaichi(申請者.getTemp_医療機関所在地());
            row.setHokenshaNo(申請者.getTemp_保険者番号());
            row.setIryoKikanTelNo(申請者.getTemp_医療機関電話番号() == null ? RString.EMPTY : 申請者.getTemp_医療機関電話番号().value());
            if (申請者.getTemp_被保険者氏名カナ() != null) {
                row.setHihokenshaShimeiKana(申請者.getTemp_被保険者氏名カナ().value());
            }
            row.getBirthYMD().setValue(申請者.getTemp_生年月日());
            if (申請者.getTemp_郵便番号() != null) {
                row.setYubinNo(申請者.getTemp_郵便番号().value());
            }
            row.setShisetsuNyushoFlag(申請者.isTemp_施設利用フラグ());
            row.setTelNo(申請者.getTemp_電話番号() == null ? RString.EMPTY : 申請者.getTemp_電話番号().value());
            row.setAge(new RString(String.valueOf(申請者.getTemp_年齢())));
            row.setIryoKikanFaxNo(申請者.getTemp_医療機関所FAX());
            row.setShichosonCode(申請者.getTemp_市町村コード() == null ? RString.EMPTY : 申請者.getTemp_市町村コード().value());
            row.setIryoKikanYubinNo(申請者.getTemp_医療機関郵便番号() == null ? RString.EMPTY : 申請者.getTemp_医療機関郵便番号().value());
            row.setDaihyoshaName(申請者.getTemp_代表者名());
            申請者一覧.add(row);
        }
        div.getShinseishaIchiran().setIsOpen(true);
        div.getDgShinseishaIchiran().setDataSource(申請者一覧);
    }

    /**
     * 「依頼する」ボタン押下、指定主治医値をセットします。
     */
    public void set主治医() {
        IShujiiIryokikanAndShujiiInputDiv iryokikanAndShujiiInputDiv = div.getCcdShujiiIryoKikanAndShujiiInput();
        for (dgShinseishaIchiran_Row row : div.getDgShinseishaIchiran().getDataSource()) {
            if (row.getSelected() && !削除.equals(row.getStatus())) {
                row.setShujiiIryoKikan(iryokikanAndShujiiInputDiv.getIryoKikanName());
                row.getShujiiIkenshoSakuseiIraiDay().setValue(div.getTxtShujiiIkensahoSakuseiIraiDay().getValue());
                row.setShujii(iryokikanAndShujiiInputDiv.getShujiiName());
                row.setShujiiIryoKikanCode(iryokikanAndShujiiInputDiv.getIryoKikanCode());
                row.setShujiiCode(iryokikanAndShujiiInputDiv.getShujiiCode());
                if (RString.isNullOrEmpty(row.getIraiKubun())) {
                    row.setStatus(新規);
                } else {
                    row.setStatus(修正);
                }
                if (iryokikanAndShujiiInputDiv.hasShiteii()) {
                    row.setIshiKbnCode(IshiKubunCode.指定医.getコード());
                    row.setShiteiiFlag(Boolean.TRUE);
                } else {
                    row.setIshiKbnCode(IshiKubunCode.主治医.getコード());
                    row.setShiteiiFlag(Boolean.FALSE);
                }
            }
        }
    }

    /**
     * 検索条件を作成します。
     *
     * @return 検索条件パラメータ
     */
    public ShujiiIkenshoSakuseiIraiParameter createParameter() {
        ShujiiIkenshoSakuseiIraiParameter parameter = new ShujiiIkenshoSakuseiIraiParameter();
        parameter.setLimitCount(Integer.parseInt(div.getTxtMaxDisp().getValue().toString()));
        NinteiShinseishaFinderDiv finderDiv = div.getCcdNinteishinseishaFinder().getNinteiShinseishaFinderDiv();
        editShosaiJokenForParameter(finderDiv, parameter);
        editNinteiChosaForParameter(finderDiv, parameter);
        editShujiiJohoForParameter(finderDiv, parameter);
        editShinsakaiJohoForParameter(finderDiv, parameter);
        editZenkaiJohoForParameter(finderDiv, parameter);
        editNowPhaseForParameter(finderDiv, parameter);
        editChkForParameter(finderDiv, parameter);
        parameter.setShoriJotaiKubunTsujo(ShoriJotaiKubun.通常.getコード());
        parameter.setShoriJotaiKubunEnki(ShoriJotaiKubun.延期.getコード());
        return parameter;
    }

    private void editShinsakaiJohoForParameter(NinteiShinseishaFinderDiv finderDiv, ShujiiIkenshoSakuseiIraiParameter parameter) {
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
        FlexibleDate 認定有効開始日FROM = finderDiv.getTxtNinteiYukoKaishiDateFrom().getValue();
        if (認定有効開始日FROM != null && !FlexibleDate.EMPTY.equals(認定有効開始日FROM)) {
            parameter.setNinteiYukoKaishiYMDFrom(認定有効開始日FROM);
            parameter.setUseNinteiYukoKaishiYMDFrom(true);
            useNinteiKekkaJoho = true;
        }
        FlexibleDate 認定有効開始日To = finderDiv.getTxtNinteiYukoKaishiDateTo().getValue();
        if (認定有効開始日To != null && !FlexibleDate.EMPTY.equals(認定有効開始日To)) {
            parameter.setNinteiYukoKaishiYMDTo(認定有効開始日To);
            parameter.setUseNinteiYukoKaishiYMDTo(true);
            useNinteiKekkaJoho = true;
        }

        FlexibleDate 認定有効終了日FROM = finderDiv.getTxtNinteiYukoShuryoDateFrom().getValue();
        if (認定有効終了日FROM != null && !FlexibleDate.EMPTY.equals(認定有効終了日FROM)) {
            parameter.setNinteiYukoShuryoYMDFrom(認定有効終了日FROM);
            parameter.setUseNinteiYukoShuryoYMDFrom(true);
            useNinteiKekkaJoho = true;
        }
        FlexibleDate 認定有効終了日To = finderDiv.getTxtNinteiYukoShuryoDate().getValue();
        if (認定有効終了日To != null && !FlexibleDate.EMPTY.equals(認定有効終了日To)) {
            parameter.setNinteiYukoShuryoYMDTo(認定有効終了日To);
            parameter.setUseNinteiYukoShuryoYMDTo(true);
            useNinteiKekkaJoho = true;
        }
        FlexibleDate 二次判定日FROM = finderDiv.getTxtNijiHanteiDateFrom().getValue();
        if (二次判定日FROM != null && !FlexibleDate.EMPTY.equals(二次判定日FROM)) {
            parameter.setNijiHanteiYMDFrom(二次判定日FROM);
            parameter.setUseNijiHanteiYMDFrom(true);
            useNinteiKekkaJoho = true;
        }
        FlexibleDate 二次判定日To = finderDiv.getTxtNijiHnateiDateTo().getValue();
        if (二次判定日To != null && !FlexibleDate.EMPTY.equals(二次判定日To)) {
            parameter.setNijiHanteiYMDTo(二次判定日To);
            parameter.setUseNijiHanteiYMDTo(true);
            useNinteiKekkaJoho = true;
        }
        parameter.setUseNinteiKekkaJoho(useNinteiKekkaJoho);
        editKaisaiDateForParameter(finderDiv, parameter);
    }

    private void editKaisaiDateForParameter(NinteiShinseishaFinderDiv finderDiv, ShujiiIkenshoSakuseiIraiParameter parameter) {
        boolean useShinsakaiKaisaiKekkaJoho = false;
        boolean useNinteiKekkaJoho = parameter.isUseNinteiKekkaJoho();
        FlexibleDate 開催日FROM = finderDiv.getTxtKaisaiDateFrom().getValue();
        if (開催日FROM != null && !FlexibleDate.EMPTY.equals(開催日FROM)) {
            parameter.setShinsakaiKaisaiYMDFrom(開催日FROM);
            parameter.setUseShinsakaiKaisaiYMDFrom(true);
            useShinsakaiKaisaiKekkaJoho = true;
            useNinteiKekkaJoho = true;
        }
        FlexibleDate 開催日To = finderDiv.getTxtKaisaiDateTo().getValue();
        if (開催日To != null && !FlexibleDate.EMPTY.equals(開催日To)) {
            parameter.setShinsakaiKaisaiYMDTo(開催日To);
            parameter.setUseShinsakaiKaisaiYMDTo(true);
            useShinsakaiKaisaiKekkaJoho = true;
            useNinteiKekkaJoho = true;
        }
        RString 開催番号FROM = finderDiv.getTxtKaisaiNumberStart().getValue();
        if (!RString.isNullOrEmpty(開催番号FROM)) {
            parameter.setShinsakaiKaisaiNoFrom(開催番号FROM);
            parameter.setUseShinsakaiKaisaiNoFrom(true);
            useShinsakaiKaisaiKekkaJoho = true;
            useNinteiKekkaJoho = true;
        }
        RString 開催番号To = finderDiv.getTxtKaisaiNumberEnd().getValue();
        if (!RString.isNullOrEmpty(開催番号To)) {
            parameter.setShinsakaiKaisaiNoTo(開催番号To);
            parameter.setUseShinsakaiKaisaiNoTo(true);
            useShinsakaiKaisaiKekkaJoho = true;
            useNinteiKekkaJoho = true;
        }
        parameter.setUseNinteiKekkaJoho(useNinteiKekkaJoho);
        parameter.setUseShinsakaiKaisaiKekkaJoho(useShinsakaiKaisaiKekkaJoho);
    }

    private void editZenkaiJohoForParameter(NinteiShinseishaFinderDiv finderDiv, ShujiiIkenshoSakuseiIraiParameter parameter) {
        boolean useZenkaiNinteiShinseiJoho = false;
        RString 前回認定調査委託先 = finderDiv.getHdnZenkaiChosaItakusakiCode();
        if (!RString.isNullOrEmpty(前回認定調査委託先)) {
            parameter.setZenkaiNinteiChosaItakusaki(finderDiv.getHdnZenkaiChosaItakusakiCode());
            parameter.setUseZenkaiNinteiChosaItakusaki(true);
            useZenkaiNinteiShinseiJoho = true;
        }
        RString 前回主治医医療機関 = finderDiv.getHdnZenkaiShujiiIryokikanCode();
        if (!RString.isNullOrEmpty(前回主治医医療機関)) {
            parameter.setZenkaiShujiiIryokikanCode(finderDiv.getHdnZenkaiShujiiIryokikanCode());
            parameter.setUseZenkaiShujiiIryokikanCode(true);
            useZenkaiNinteiShinseiJoho = true;
        }

        RString 前回二次判定結果コード = finderDiv.getDdlZenkaiNijiHanteiKekka().getSelectedKey();
        if (!RString.isNullOrEmpty(前回二次判定結果コード)) {
            parameter.setZenkaiJotaiKubunCode(前回二次判定結果コード);
            parameter.setUseZenkaiJotaiKubunCode(true);
            useZenkaiNinteiShinseiJoho = true;
        }

        RString 前回認定有効期間 = finderDiv.getTxtZenkaiNinteiYukoKikan().getValue();
        if (!RString.isNullOrEmpty(前回認定有効期間)) {
            parameter.setZenkaiYukoKikan(Integer.parseInt(前回認定有効期間.toString()));
            parameter.setUseZenkaiYukoKikan(true);
            useZenkaiNinteiShinseiJoho = true;
        }

        FlexibleDate 設定有効開始日FROM = finderDiv.getTxtZenkaiYukoKaishiDateFrom().getValue();
        if (設定有効開始日FROM != null && !FlexibleDate.EMPTY.equals(設定有効開始日FROM)) {
            parameter.setZenkaiYukoKikanStartFrom(設定有効開始日FROM);
            parameter.setUseZenkaiYukoKikanStartFrom(true);
            useZenkaiNinteiShinseiJoho = true;
        }
        FlexibleDate 設定有効開始日To = finderDiv.getTxtZenkaiYukoKaishiDateTo().getValue();
        if (設定有効開始日To != null && !FlexibleDate.EMPTY.equals(設定有効開始日To)) {
            parameter.setZenkaiYukoKikanStartTo(設定有効開始日To);
            parameter.setUseZenkaiYukoKikanStartTo(true);
            useZenkaiNinteiShinseiJoho = true;
        }
        parameter.setUseZenkaiNinteiShinseiJoho(useZenkaiNinteiShinseiJoho);
        Code 原因疾患 = finderDiv.getCdlGeninShikkanCode().getCode();
        if (原因疾患 != null && !原因疾患.isEmpty()) {
            parameter.setGeninShikkanCode(原因疾患.value());
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

    private void editShujiiJohoForParameter(NinteiShinseishaFinderDiv finderDiv, ShujiiIkenshoSakuseiIraiParameter parameter) {
        RString 主治医医療機関 = finderDiv.getHdnShujiiIryokikanCode();
        if (!RString.isNullOrEmpty(主治医医療機関)) {
            parameter.setShujiiIryokikanCode(finderDiv.getHdnShujiiIryokikanCode());
            parameter.setUseShujiiIryokikanCode(true);
        }
        RString 主治医氏名 = finderDiv.getHdnShujiiCode();
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
        FlexibleDate 意見書受領日FROM = finderDiv.getTxtIkenshoKinyuDateFrom().getValue();
        if (意見書受領日FROM != null && !FlexibleDate.EMPTY.equals(意見書受領日FROM)) {
            parameter.setIkenshoJuryoYMDFrom(意見書受領日FROM);
            parameter.setUseIkenshoJuryoYMDFrom(true);
            useShujiiIkenshoJoho = true;
        }
        FlexibleDate 意見書受領日To = finderDiv.getTxtIkenshoKinyuDateTo().getValue();
        if (意見書受領日To != null && !FlexibleDate.EMPTY.equals(意見書受領日To)) {
            parameter.setIkenshoJuryoYMDTo(意見書受領日To);
            parameter.setUseIkenshoJuryoYMDTo(true);
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
        FlexibleDate 一次判定日FROM = finderDiv.getTxtIchijiHanteiDateFrom().getValue();
        if (一次判定日FROM != null && !FlexibleDate.EMPTY.equals(一次判定日FROM)) {
            parameter.setIchijiHanteiYMDFrom(一次判定日FROM);
            parameter.setUseIchijiHanteiYMDFrom(true);
            useIchijiHanteiKekkaJoho = true;
        }
        FlexibleDate 一次判定日To = finderDiv.getTxtIchijiHanteiDateTo().getValue();
        if (一次判定日To != null && !FlexibleDate.EMPTY.equals(一次判定日To)) {
            parameter.setIchijiHanteiYMDTo(一次判定日To);
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

    private void editIchiGohanteiForParameter(NinteiShinseishaFinderDiv finderDiv, ShujiiIkenshoSakuseiIraiParameter parameter) {
        boolean useIchiGojiHanteiKekkaJoho = false;
        FlexibleDate ichiGoHanteiDateFrom = finderDiv.getTxtIchiGoHanteiDateFrom().getValue();
        if (ichiGoHanteiDateFrom != null && !FlexibleDate.EMPTY.equals(ichiGoHanteiDateFrom)) {
            parameter.setIchiGojiHanteiYMDFrom(ichiGoHanteiDateFrom);
            parameter.setUseIchiGojiHanteiYMDFrom(true);
            useIchiGojiHanteiKekkaJoho = true;
        }
        FlexibleDate ichiGoHanteiDateTo = finderDiv.getTxtIchiGoHanteiDateTo().getValue();
        if (ichiGoHanteiDateTo != null && !FlexibleDate.EMPTY.equals(ichiGoHanteiDateTo)) {
            parameter.setIchiGojiHanteiYMDTo(ichiGoHanteiDateTo);
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

    private void editNinteiChosaForParameter(NinteiShinseishaFinderDiv finderDiv, ShujiiIkenshoSakuseiIraiParameter parameter) {
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
        RString 施設入所の有無 = finderDiv.getRadShisetsuNyusho().getSelectedKey();
        if (KEY0.equals(施設入所の有無)) {
            parameter.setShisetsuNyushoFlag(true);
        }
        if (KEY1.equals(施設入所の有無)) {
            parameter.setShisetsuNyushoFlag(false);
        }

        RString 認定調査委託先コード = finderDiv.getHdnChosaItakusakiCode();
        if (!RString.isNullOrEmpty(認定調査委託先コード)) {
            parameter.setNinteiChosaItakusakiCode(finderDiv.getHdnChosaItakusakiCode());
            parameter.setUseNinteiChosaItakusakiCode(true);
        }

        RString 認定調査員氏名 = finderDiv.getHdnChosainCode();
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
        FlexibleDate 調査実施日FROM = finderDiv.getTxtChosaJisshiDateFrom().getValue();
        if (調査実施日FROM != null && !FlexibleDate.EMPTY.equals(調査実施日FROM)) {
            parameter.setNinteichosaJisshiYMDFrom(調査実施日FROM);
            parameter.setUseNinteichosaJisshiYMDFrom(true);
            useNinteichosahyoGaikyoChosa = true;
        }
        FlexibleDate 調査実施日TO = finderDiv.getTxtChosaJisshiDateTo().getValue();
        if (調査実施日TO != null && !FlexibleDate.EMPTY.equals(調査実施日TO)) {
            parameter.setNinteichosaJisshiYMDTo(調査実施日TO);
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

    private void editShosaiJokenForParameter(NinteiShinseishaFinderDiv finderDiv, ShujiiIkenshoSakuseiIraiParameter parameter) {
        RString 被保険者番号 = finderDiv.getTxtHihokenshaNumber().getValue();
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

        RString 被保険者氏名 = finderDiv.getTxtHihokenshaName().getValue();
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
            parameter.setHihokenshaName(被保険者氏名);
            parameter.setUseHihokenshaName(true);
        }
        List<KeyValueDataSource> みなし２号申請 = finderDiv.getChkMinashiFlag().getSelectedItems();
        if (みなし２号申請.isEmpty()) {
            parameter.setMinashiNigoEtcTaishoFlag(false);
        } else {
            parameter.setMinashiNigoEtcTaishoFlag(true);
        }
        FlexibleDate 認定申請日FROM = finderDiv.getTxtNinteiShinseiDateFrom().getValue();
        if (認定申請日FROM != null && !FlexibleDate.EMPTY.equals(認定申請日FROM)) {
            parameter.setNinteiShinseiYMDFrom(認定申請日FROM);
            parameter.setUseNinteiShinseiYMDFrom(true);
        }

        FlexibleDate 認定申請日To = finderDiv.getTxtNinteiShinseiDateTo().getValue();
        if (認定申請日To != null && !FlexibleDate.EMPTY.equals(認定申請日To)) {
            parameter.setNinteiShinseiYMDTo(認定申請日To);
            parameter.setUseNinteiShinseiYMDTo(true);
        }
        FlexibleDate 生年月日From = finderDiv.getTxtBirthDateFrom().getValue();
        if (生年月日From != null && !FlexibleDate.EMPTY.equals(生年月日From)) {
            parameter.setSeinengappiYMDFrom(生年月日From);
            parameter.setUseSeinengappiYMDFrom(true);
        }
        FlexibleDate 生年月日To = finderDiv.getTxtBirthDateTO().getValue();
        if (生年月日To != null && !FlexibleDate.EMPTY.equals(生年月日To)) {
            parameter.setSeinengappiYMDTo(生年月日To);
            parameter.setUseSeinengappiYMDTo(true);
        }
        RString 認定申請区分申請時コード = finderDiv.getDdlShinseijiShinseiKubun().getSelectedKey();
        if (!RString.isNullOrEmpty(認定申請区分申請時コード)) {
            parameter.setNinteiShinseiShinseijiKubun(認定申請区分申請時コード);
            parameter.setUseNinteiShinseiShinseijiKubun(true);
        }
        edit性別ForParameter(finderDiv, parameter);
    }

    private void edit性別ForParameter(NinteiShinseishaFinderDiv finderDiv, ShujiiIkenshoSakuseiIraiParameter parameter) {
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

    private void editChkForParameter(NinteiShinseishaFinderDiv finderDiv, ShujiiIkenshoSakuseiIraiParameter parameter) {
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

    private void editChkForParameter2(NinteiShinseishaFinderDiv finderDiv, ShujiiIkenshoSakuseiIraiParameter parameter) {
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

    private void editNowPhaseForParameter(NinteiShinseishaFinderDiv finderDiv, ShujiiIkenshoSakuseiIraiParameter parameter) {
        RString 現在のフェーズ = finderDiv.getDdlNowPhase().getSelectedKey();
        if (RString.isNullOrEmpty(現在のフェーズ)) {
            parameter.setNowPhaseBlank(true);
        } else if (KanryoInfoPhase.申請受付.getコード().equals(現在のフェーズ)) {
            parameter.setNowPhaseShinseiUketsuke(true);
        } else if (KanryoInfoPhase.調査依頼.getコード().equals(現在のフェーズ)) {
            parameter.setNowPhaseChosaIrai(true);
        } else if (KanryoInfoPhase.意見書依頼.getコード().equals(現在のフェーズ)) {
            parameter.setNowPhaseIkenshoIrai(true);
        } else if (KanryoInfoPhase.意見書入手.getコード().equals(現在のフェーズ)) {
            parameter.setNowPhaseIkenshoNyushu(true);
        } else if (KanryoInfoPhase.一次判定.getコード().equals(現在のフェーズ)) {
            parameter.setNowPhaseIchijiHantei(true);
        } else if (KanryoInfoPhase.マスキング.getコード().equals(現在のフェーズ)) {
            parameter.setNowPhaseMasking(true);
        } else if (KanryoInfoPhase.審査会登録.getコード().equals(現在のフェーズ)) {
            parameter.setNowPhaseShinsakaiToroku(true);
        } else if (KanryoInfoPhase.二次判定.getコード().equals(現在のフェーズ)) {
            parameter.setNowPhaseNijiHantei(true);
        } else if (KanryoInfoPhase.月例処理.getコード().equals(現在のフェーズ)) {
            parameter.setNowPhaseGetsureiShori(true);
        } else if (KanryoInfoPhase.調査入手.getコード().equals(現在のフェーズ)) {
            parameter.setNowPhaseChosaNyushu(true);
        }
    }

    private boolean isEmpty(FlexibleDate date) {
        return date == null || date.isEmpty();
    }
}
