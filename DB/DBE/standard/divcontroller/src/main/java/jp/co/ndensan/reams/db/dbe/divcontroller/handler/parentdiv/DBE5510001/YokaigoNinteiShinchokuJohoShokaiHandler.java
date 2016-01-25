/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE5510001;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.yokaigoninteishinchokujohoshokai.YokaigoNinteiShinchokuJoho;
import jp.co.ndensan.reams.db.dbe.business.report.dbe521002.NiteiGyomuShinchokuJokyoIchiranhyoBodyItem;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5510001.YokaigoNinteiShinchokuJohoShokaiDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5510001.dgShinseiJoho_Row;
import jp.co.ndensan.reams.db.dbz.definition.core.seibetsu.Seibetsu;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigojotaikubun.YokaigoJotaiKubun09;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPair;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;

/**
 *
 * 要介護認定進捗状況照会のハンドラークラスです。
 */
public class YokaigoNinteiShinchokuJohoShokaiHandler {

    private static final RString DATE_SOURCE_KEY0 = new RString("key0");
    private static final RString DATE_SOURCE_KEY1 = new RString("key1");
    private static final List<RString> CHK_BOX_NASI = new ArrayList<>();
    private final YokaigoNinteiShinchokuJohoShokaiDiv div;

    /**
     * コンストラクタです。
     *
     * @param div 画面情報
     */
    public YokaigoNinteiShinchokuJohoShokaiHandler(YokaigoNinteiShinchokuJohoShokaiDiv div) {
        this.div = div;
    }

    /**
     * 画面初期化処理です。
     */
    public void onload() {
        div.getCcdHokenshaList().loadHokenshaList();
        div.getRadKensakuHoho().setSelectedKey(DATE_SOURCE_KEY0);
        div.getRadMatchType().setSelectedKey(DATE_SOURCE_KEY0);
        div.getRadHizukeHani().setSelectedKey(DATE_SOURCE_KEY0);
        div.getTxtShiteiHizukeForm().setDisabled(true);
        div.getTxtShiteiHizukeTo().setDisabled(true);
        div.getSerchFromHohokensha().setDisplayNone(false);
        div.getSerchFromShinchokuJokyo().setDisplayNone(true);
        setDisable();
    }

    /**
     * 検索する場合、選択変更します。
     */
    public void radKensakuHohoChange() {
        if (DATE_SOURCE_KEY0.equals(div.getRadKensakuHoho().getSelectedKey())) {
            div.getSerchFromHohokensha().setDisplayNone(false);
            div.getSerchFromShinchokuJokyo().setDisplayNone(true);
        } else if (DATE_SOURCE_KEY1.equals(div.getRadKensakuHoho().getSelectedKey())) {
            div.getSerchFromHohokensha().setDisplayNone(true);
            div.getSerchFromShinchokuJokyo().setDisplayNone(false);
        }
    }

    /**
     * 日付範囲、選択変更します。
     */
    public void radHizukeHaniChange() {
        if (DATE_SOURCE_KEY0.equals(div.getRadHizukeHani().getSelectedKey())) {
            div.getTxtShiteiHizukeForm().setDisabled(true);
            div.getTxtShiteiHizukeTo().setDisabled(true);
            div.getTxtShiteiHizukeForm().clearValue();
            div.getTxtShiteiHizukeTo().clearValue();
        } else {
            div.getTxtShiteiHizukeForm().setDisabled(false);
            div.getTxtShiteiHizukeTo().setDisabled(false);
        }
    }

    /**
     * 条件をクリアするボタン押下します。
     */
    public void btnConditionClear() {
        clearBotton();
    }

    /**
     * 「検索する」ボタン押下します。
     *
     * @param serchResult 要介護認定進捗状況照会情報
     */
    public void btnKensaku(SearchResult<YokaigoNinteiShinchokuJoho> serchResult) {
        div.getDgShinseiJoho().getDataSource().clear();
        List<dgShinseiJoho_Row> dg_row = new ArrayList<>();
        for (YokaigoNinteiShinchokuJoho joho : serchResult.records()) {
            dg_row.add(setRow(joho));
        }
        div.getDgShinseiJoho().setDataSource(dg_row);
    }

    /**
     * 「進捗状況一覧表を発行する」ボタン押下の場合、入力チェック実行します。
     *
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs btnPrintCheck() {
        ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
        validationMessages.add(new ValidationMessageControlPair(
                YokaigoNinteiShinchokuJohoShokaiMessages.データが存在しない));
        return validationMessages;

    }

    /**
     * 帳票印刷用パラメータを設定します。
     *
     * @return List<NiteiGyomuShinchokuJokyoIchiranhyoBodyItem>
     */
    public List<NiteiGyomuShinchokuJokyoIchiranhyoBodyItem> createBodyItem() {
        return bodyItem();
    }

    private List<NiteiGyomuShinchokuJokyoIchiranhyoBodyItem> bodyItem() {
        List<NiteiGyomuShinchokuJokyoIchiranhyoBodyItem> list = new ArrayList<>();
        List<dgShinseiJoho_Row> dg_row = div.getDgShinseiJoho().getDataSource();
        for (int i = 0; i < dg_row.size(); i++) {
            dgShinseiJoho_Row row = dg_row.get(i);
            NiteiGyomuShinchokuJokyoIchiranhyoBodyItem item = new NiteiGyomuShinchokuJokyoIchiranhyoBodyItem(
                    row.getChosaIrai(),
                    row.getShujiiIkenshoIrai(),
                    row.getChosaJisshi(),
                    row.getShujiiIkenshoJuryo(),
                    row.getIchijiHantei(),
                    row.getShinsakaiWaritsuke(),
                    row.getShinsakaiJisshi(),
                    row.getHokensha(),
                    row.getShinseiDay() == null ? RString.EMPTY : row.getShinseiDay().getValue().toDateString(),
                    row.getShimei(),
                    row.getHihokenshaBirthDay() == null ? RString.EMPTY : row.getHihokenshaBirthDay().getValue().toDateString(),
                    row.getHihokenshaSeibetsu(),
                    row.getHihokenshaNo(),
                    row.getNinteiChosaItakusaki(),
                    row.getNinteiChosain(),
                    row.getKaigoNinteiShinsakaiYoteiDay() == null ? RString.EMPTY : row.getKaigoNinteiShinsakaiYoteiDay().getValue().toDateString(),
                    row.getHihokenshaJusho(),
                    row.getShujiiIryoKikan(),
                    row.getShujiiName());
            list.add(item);
        }
        return list;
    }

    private dgShinseiJoho_Row setRow(YokaigoNinteiShinchokuJoho joho) {
        dgShinseiJoho_Row row = new dgShinseiJoho_Row();
        row.setHokensha(nullToEmpty(joho.get市町村名称()));
        row.setHihokenshaNo(joho.get被保険者番号() == null ? RString.EMPTY : joho.get被保険者番号().getColumnValue());
        row.setShimei(nullToEmpty(joho.get被保険者氏名()));
        row.setHihoKubun(nullToEmpty(joho.get被保険者区分コード()));
        if (joho.get認定申請年月日() == null || joho.get認定申請年月日().isEmpty()) {
            row.setShinseiDay(new TextBoxDate());
        } else {
            row.getShinseiDay().setValue(new RDate(joho.get認定申請年月日().toString()));
        }
        row.setShinseiKubun(nullToEmpty(joho.get認定申請区分申請時コード()));
        row.setChosaIrai(flexibleDateToRString(joho.get認定調査依頼完了年月日()));
        row.setChosaJisshi(flexibleDateToRString(joho.get認定調査完了年月日()));
        row.setChosaTokki(nullToEmpty(joho.get認定調査特記()));
        row.setShujiiIkenshoIrai(flexibleDateToRString(joho.get主治医意見書作成依頼完了年月日()));
        row.setShujiiIkenshoJuryo(flexibleDateToRString(joho.get主治医意見書登録完了年月日()));
        row.setIchijiHantei(flexibleDateToRString(joho.get要介護認定一次判定完了年月日()));
        row.setMaskingKanryo(flexibleDateToRString(joho.getマスキング完了年月日()));
        row.setShinsakaiWaritsuke(flexibleDateToRString(joho.get認定審査会割当完了年月日()));
        row.setShinsakaiJisshi(flexibleDateToRString(joho.get認定審査会完了年月日()));
        if (joho.get認定調査依頼年月日() == null || joho.get認定調査依頼年月日().isEmpty()) {
            row.setNinteiChosaIraiDay(new TextBoxDate());
        } else {
            row.getNinteiChosaIraiDay().setValue(flexibleDateToRDate(joho.get認定調査依頼年月日()));
        }
        if (joho.get認定調査受領年月日() == null || joho.get認定調査受領年月日().isEmpty()) {
            row.setNinteiChosaJuryoDay(new TextBoxDate());
        } else {
            row.getNinteiChosaJuryoDay().setValue(flexibleDateToRDate(joho.get認定調査受領年月日()));
        }
        row.setNinteiChosaItakusaki(nullToEmpty(joho.get事業者名称()));
        row.setNinteiChosain(nullToEmpty(joho.get調査員氏名()));
        if (joho.get主治医意見書作成依頼年月日() == null || joho.get主治医意見書作成依頼年月日().isEmpty()) {
            row.setShujiiIkenshoIraiDay(new TextBoxDate());
        } else {
            row.getShujiiIkenshoIraiDay().setValue(flexibleDateToRDate(joho.get主治医意見書作成依頼年月日()));
        }
        if (joho.get主治医意見書受領年月日() == null || joho.get主治医意見書受領年月日().isEmpty()) {
            row.setShujiiJuryoDay(new TextBoxDate());
        } else {
            row.getShujiiJuryoDay().setValue(flexibleDateToRDate(joho.get主治医意見書受領年月日()));
        }
        row.setShujiiIryoKikan(nullToEmpty(joho.get医療機関名称()));
        row.setShujiiName(nullToEmpty(joho.get主治医氏名()));
        if (joho.get要介護認定一次判定年月日() == null || joho.get要介護認定一次判定年月日().isEmpty()) {
            row.setIchijiHanteiDay(new TextBoxDate());
        } else {
            row.getIchijiHanteiDay().setValue(flexibleDateToRDate(joho.get要介護認定一次判定年月日()));
        }
        if (joho.get要介護認定一次判定完了年月日() == null || joho.get要介護認定一次判定完了年月日().isEmpty()) {
            row.setIchijiHanteiKanryouDay(new TextBoxDate());
        } else {
            row.getIchijiHanteiKanryouDay().setValue(flexibleDateToRDate(joho.get要介護認定一次判定完了年月日()));
        }
        // TODO 董亜彬 QA 533
        row.setIchijiHanteiKekka(nullToEmpty(joho.get要介護認定一次判定結果コード()));
        if (joho.get認定審査会割当完了年月日() == null || joho.get認定審査会割当完了年月日().isEmpty()) {
            row.setKaigoNinteiShinsakaiWaritsukeDay(new TextBoxDate());
        } else {
            row.getKaigoNinteiShinsakaiWaritsukeDay().setValue(flexibleDateToRDate(joho.get認定審査会割当完了年月日()));
        }
        row.setKaigoNinteiShinsakaiShiryo(joho.get介護認定審査会資料作成年月日() == null ? RString.EMPTY : joho
                .get介護認定審査会資料作成年月日().wareki().eraType(EraType.ALPHABET)
                .firstYear(FirstYear.GAN_NEN).separator(Separator.PERIOD)
                .fillType(FillType.ZERO).toDateString());
        if (joho.get介護認定審査会開催予定年月日() == null || joho.get介護認定審査会開催予定年月日().isEmpty()) {
            row.setKaigoNinteiShinsakaiYoteiDay(new TextBoxDate());
        } else {
            row.getKaigoNinteiShinsakaiYoteiDay().setValue(flexibleDateToRDate(joho.get介護認定審査会開催予定年月日()));
        }
        if (joho.get介護認定審査会開催年月日() == null || joho.get介護認定審査会開催年月日().isEmpty()) {
            row.setKaigoNinteiShinsakaiKaisaiDay(new TextBoxDate());
        } else {
            row.getKaigoNinteiShinsakaiKaisaiDay().setValue(flexibleDateToRDate(joho.get介護認定審査会開催年月日()));
        }
        row.setKaigoNinteiShinsakaiKaisaiNo(nullToEmpty(joho.get介護認定審査会開催番号()));
        row.setKaigoNinteiShinsakaiGogitai(new RString(String.valueOf(joho.get合議体番号())));
        row.setKaigoNinteiShinsakaiYokaigodo(YokaigoJotaiKubun09.toValue(joho.get二次判定要介護状態区分コード()).get名称());
        row.setHihokenshaYubinNo(nullToEmpty(joho.get郵便番号()));
        row.setHihokenshaJusho(nullToEmpty(joho.get住所()));
        row.setHihokenshaSeibetsu(Seibetsu.toValue(joho.get性別()).get名称());
        if (joho.get生年月日() == null || joho.get生年月日().isEmpty()) {
            row.setHihokenshaBirthDay(new TextBoxDate());
        } else {
            row.getHihokenshaBirthDay().setValue(flexibleDateToRDate(joho.get生年月日()));
        }
        row.setHihokenshaNenrei(new RString(String.valueOf(joho.get年齢())));
        return row;
    }

    private RString flexibleDateToRString(FlexibleDate date) {
        if (date != null && !date.isEmpty()) {
            return new RString("●");
        }
        return RString.EMPTY;
    }

    private RDate flexibleDateToRDate(FlexibleDate date) {
        return new RDate(date.wareki().eraType(EraType.ALPHABET)
            .firstYear(FirstYear.GAN_NEN).separator(Separator.PERIOD)
            .fillType(FillType.ZERO).toDateString().toString());
    }
    
    private RString nullToEmpty(Object obj) {
        return obj == null ? RString.EMPTY : new RString(obj.toString());
    }

    private void setDisable() {
        div.getDgShinseiJoho().getGridSetting().getColumn("shinseiDay").getCellDetails().setDisabled(true);
        div.getDgShinseiJoho().getGridSetting().getColumn("ninteiChosaIraiDay").getCellDetails().setDisabled(true);
        div.getDgShinseiJoho().getGridSetting().getColumn("ninteiChosaJuryoDay").getCellDetails().setDisabled(true);
        div.getDgShinseiJoho().getGridSetting().getColumn("shujiiIkenshoIraiDay").getCellDetails().setDisabled(true);
        div.getDgShinseiJoho().getGridSetting().getColumn("shujiiJuryoDay").getCellDetails().setDisabled(true);
        div.getDgShinseiJoho().getGridSetting().getColumn("ichijiHanteiDay").getCellDetails().setDisabled(true);
        div.getDgShinseiJoho().getGridSetting().getColumn("ichijiHanteiKanryouDay").getCellDetails().setDisabled(true);
        div.getDgShinseiJoho().getGridSetting().getColumn("kaigoNinteiShinsakaiWaritsukeDay").getCellDetails().setDisabled(true);
        div.getDgShinseiJoho().getGridSetting().getColumn("kaigoNinteiShinsakaiYoteiDay").getCellDetails().setDisabled(true);
        div.getDgShinseiJoho().getGridSetting().getColumn("kaigoNinteiShinsakaiKaisaiDay").getCellDetails().setDisabled(true);
        div.getDgShinseiJoho().getGridSetting().getColumn("hihokenshaBirthDay").getCellDetails().setDisabled(true);
    }

    private void clearBotton() {
        onload();
        div.getTxtHihokenshaNo().clearValue();
        div.getTxtShikibetsuCode().clearValue();
        div.getTxtShimei().clearValue();
        div.getTxtShiteiHizukeForm().clearValue();
        div.getTxtShiteiHizukeTo().clearValue();
        div.getChkNinteiChosaIrai().setSelectedItemsByKey(CHK_BOX_NASI);
        div.getChkNinteiChosaJisshi().setSelectedItemsByKey(CHK_BOX_NASI);
        div.getChkNinteiChosaTokki().setSelectedItemsByKey(CHK_BOX_NASI);
        div.getChkShujiiIkenshoIrai().setSelectedItemsByKey(CHK_BOX_NASI);
        div.getChkShujiiIkenshoJuryo().setSelectedItemsByKey(CHK_BOX_NASI);
        div.getChkIchijiHanteiKanryo().setSelectedItemsByKey(CHK_BOX_NASI);
        div.getChkMaskingKanryo().setSelectedItemsByKey(CHK_BOX_NASI);
        div.getChkShinsakaiWaritsuke().setSelectedItemsByKey(CHK_BOX_NASI);
        div.getChkShinsakaiJisshi().setSelectedItemsByKey(CHK_BOX_NASI);
        div.getChkKensakuOption().setSelectedItemsByKey(CHK_BOX_NASI);
        div.getTxtMaximumDisplayNumber().clearValue();
    }

    private static enum YokaigoNinteiShinchokuJohoShokaiMessages implements IValidationMessage {

        データが存在しない(UrErrorMessages.データが存在しない);

        private final Message message;

        private YokaigoNinteiShinchokuJohoShokaiMessages(IMessageGettable message, String... replacements) {
            this.message = message.getMessage().replace(replacements);
        }

        @Override
        public Message getMessage() {
            return message;
        }
    }
}
