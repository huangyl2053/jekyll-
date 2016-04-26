package jp.co.ndensan.reams.db.dba.divcontroller.entity.parentdiv.DBA7010001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.hanyolistatenaselect.HanyoListAtenaSelect.HanyoListAtenaSelectDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.hanyolistatenaselect.HanyoListAtenaSelect.IHanyoListAtenaSelectDiv;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.chohyoshutsuryokujun.ChohyoShutsuryokujun.ChohyoShutsuryokujunDiv;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.chohyoshutsuryokujun.ChohyoShutsuryokujun.IChohyoShutsuryokujunDiv;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.chohyoshutsuryokukomoku.ChohyoShutsuryokuKomoku.ChohyoShutsuryokuKomokuDiv;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.chohyoshutsuryokukomoku.ChohyoShutsuryokuKomoku.IChohyoShutsuryokuKomokuDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * DvHikokenshaDaicho のクラスファイル 
 * 
 * @author 自動生成
 */
public class DvHikokenshaDaichoDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-03-22_14-06-37">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("DvHihokenshaDaichoParam")
    private DvHihokenshaDaichoParamDiv DvHihokenshaDaichoParam;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getDvHihokenshaDaichoParam
     * @return DvHihokenshaDaichoParam
     */
    @JsonProperty("DvHihokenshaDaichoParam")
    public DvHihokenshaDaichoParamDiv getDvHihokenshaDaichoParam() {
        return DvHihokenshaDaichoParam;
    }

    /*
     * setDvHihokenshaDaichoParam
     * @param DvHihokenshaDaichoParam DvHihokenshaDaichoParam
     */
    @JsonProperty("DvHihokenshaDaichoParam")
    public void setDvHihokenshaDaichoParam(DvHihokenshaDaichoParamDiv DvHihokenshaDaichoParam) {
        this.DvHihokenshaDaichoParam = DvHihokenshaDaichoParam;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public DvJikenFukugenHozonDiv getDvJikenFukugenHozon() {
        return this.getDvHihokenshaDaichoParam().getDvJikenFukugenHozon();
    }

    @JsonIgnore
    public void  setDvJikenFukugenHozon(DvJikenFukugenHozonDiv DvJikenFukugenHozon) {
        this.getDvHihokenshaDaichoParam().setDvJikenFukugenHozon(DvJikenFukugenHozon);
    }

    @JsonIgnore
    public ButtonBatchParameterSave getBtnKogakuParamSave() {
        return this.getDvHihokenshaDaichoParam().getDvJikenFukugenHozon().getBtnKogakuParamSave();
    }

    @JsonIgnore
    public void  setBtnKogakuParamSave(ButtonBatchParameterSave btnKogakuParamSave) {
        this.getDvHihokenshaDaichoParam().getDvJikenFukugenHozon().setBtnKogakuParamSave(btnKogakuParamSave);
    }

    @JsonIgnore
    public ButtonBatchParameterRestore getBtnKogakuParamRestore() {
        return this.getDvHihokenshaDaichoParam().getDvJikenFukugenHozon().getBtnKogakuParamRestore();
    }

    @JsonIgnore
    public void  setBtnKogakuParamRestore(ButtonBatchParameterRestore btnKogakuParamRestore) {
        this.getDvHihokenshaDaichoParam().getDvJikenFukugenHozon().setBtnKogakuParamRestore(btnKogakuParamRestore);
    }

    @JsonIgnore
    public DvChushutsuJokenDiv getDvChushutsuJoken() {
        return this.getDvHihokenshaDaichoParam().getDvChushutsuJoken();
    }

    @JsonIgnore
    public void  setDvChushutsuJoken(DvChushutsuJokenDiv DvChushutsuJoken) {
        this.getDvHihokenshaDaichoParam().setDvChushutsuJoken(DvChushutsuJoken);
    }

    @JsonIgnore
    public DvChushutsuDiv getDvChushutsu() {
        return this.getDvHihokenshaDaichoParam().getDvChushutsuJoken().getDvChushutsu();
    }

    @JsonIgnore
    public void  setDvChushutsu(DvChushutsuDiv DvChushutsu) {
        this.getDvHihokenshaDaichoParam().getDvChushutsuJoken().setDvChushutsu(DvChushutsu);
    }

    @JsonIgnore
    public RadioButton getRadChushutsu() {
        return this.getDvHihokenshaDaichoParam().getDvChushutsuJoken().getDvChushutsu().getRadChushutsu();
    }

    @JsonIgnore
    public void  setRadChushutsu(RadioButton radChushutsu) {
        this.getDvHihokenshaDaichoParam().getDvChushutsuJoken().getDvChushutsu().setRadChushutsu(radChushutsu);
    }

    @JsonIgnore
    public DvChushutsuShosaiDiv getDvChushutsuShosai() {
        return this.getDvHihokenshaDaichoParam().getDvChushutsuJoken().getDvChushutsuShosai();
    }

    @JsonIgnore
    public void  setDvChushutsuShosai(DvChushutsuShosaiDiv DvChushutsuShosai) {
        this.getDvHihokenshaDaichoParam().getDvChushutsuJoken().setDvChushutsuShosai(DvChushutsuShosai);
    }

    @JsonIgnore
    public Label getLblKuhaku() {
        return this.getDvHihokenshaDaichoParam().getDvChushutsuJoken().getDvChushutsuShosai().getLblKuhaku();
    }

    @JsonIgnore
    public void  setLblKuhaku(Label lblKuhaku) {
        this.getDvHihokenshaDaichoParam().getDvChushutsuJoken().getDvChushutsuShosai().setLblKuhaku(lblKuhaku);
    }

    @JsonIgnore
    public RadioButton getRadKijunbiDate() {
        return this.getDvHihokenshaDaichoParam().getDvChushutsuJoken().getDvChushutsuShosai().getRadKijunbiDate();
    }

    @JsonIgnore
    public void  setRadKijunbiDate(RadioButton radKijunbiDate) {
        this.getDvHihokenshaDaichoParam().getDvChushutsuJoken().getDvChushutsuShosai().setRadKijunbiDate(radKijunbiDate);
    }

    @JsonIgnore
    public TextBoxDateRange getTxtIryokikan() {
        return this.getDvHihokenshaDaichoParam().getDvChushutsuJoken().getDvChushutsuShosai().getTxtIryokikan();
    }

    @JsonIgnore
    public void  setTxtIryokikan(TextBoxDateRange txtIryokikan) {
        this.getDvHihokenshaDaichoParam().getDvChushutsuJoken().getDvChushutsuShosai().setTxtIryokikan(txtIryokikan);
    }

    @JsonIgnore
    public TextBoxDate getTxtKijunDate() {
        return this.getDvHihokenshaDaichoParam().getDvChushutsuJoken().getDvChushutsuShosai().getTxtKijunDate();
    }

    @JsonIgnore
    public void  setTxtKijunDate(TextBoxDate txtKijunDate) {
        this.getDvHihokenshaDaichoParam().getDvChushutsuJoken().getDvChushutsuShosai().setTxtKijunDate(txtKijunDate);
    }

    @JsonIgnore
    public CheckBoxList getChkKijunDateNozoku() {
        return this.getDvHihokenshaDaichoParam().getDvChushutsuJoken().getDvChushutsuShosai().getChkKijunDateNozoku();
    }

    @JsonIgnore
    public void  setChkKijunDateNozoku(CheckBoxList chkKijunDateNozoku) {
        this.getDvHihokenshaDaichoParam().getDvChushutsuJoken().getDvChushutsuShosai().setChkKijunDateNozoku(chkKijunDateNozoku);
    }

    @JsonIgnore
    public RadioButton getRadHani() {
        return this.getDvHihokenshaDaichoParam().getDvChushutsuJoken().getDvChushutsuShosai().getRadHani();
    }

    @JsonIgnore
    public void  setRadHani(RadioButton radHani) {
        this.getDvHihokenshaDaichoParam().getDvChushutsuJoken().getDvChushutsuShosai().setRadHani(radHani);
    }

    @JsonIgnore
    public TextBoxDateRange getTxtChushutsuHani() {
        return this.getDvHihokenshaDaichoParam().getDvChushutsuJoken().getDvChushutsuShosai().getTxtChushutsuHani();
    }

    @JsonIgnore
    public void  setTxtChushutsuHani(TextBoxDateRange txtChushutsuHani) {
        this.getDvHihokenshaDaichoParam().getDvChushutsuJoken().getDvChushutsuShosai().setTxtChushutsuHani(txtChushutsuHani);
    }

    @JsonIgnore
    public HorizontalLine getLinLine1() {
        return this.getDvHihokenshaDaichoParam().getDvChushutsuJoken().getLinLine1();
    }

    @JsonIgnore
    public void  setLinLine1(HorizontalLine linLine1) {
        this.getDvHihokenshaDaichoParam().getDvChushutsuJoken().setLinLine1(linLine1);
    }

    @JsonIgnore
    public CheckBoxList getChkHihokenshaJoho() {
        return this.getDvHihokenshaDaichoParam().getDvChushutsuJoken().getChkHihokenshaJoho();
    }

    @JsonIgnore
    public void  setChkHihokenshaJoho(CheckBoxList chkHihokenshaJoho) {
        this.getDvHihokenshaDaichoParam().getDvChushutsuJoken().setChkHihokenshaJoho(chkHihokenshaJoho);
    }

    @JsonIgnore
    public HorizontalLine getLinLine2() {
        return this.getDvHihokenshaDaichoParam().getDvChushutsuJoken().getLinLine2();
    }

    @JsonIgnore
    public void  setLinLine2(HorizontalLine linLine2) {
        this.getDvHihokenshaDaichoParam().getDvChushutsuJoken().setLinLine2(linLine2);
    }

    @JsonIgnore
    public RadioButton getRadChushutsuKijun() {
        return this.getDvHihokenshaDaichoParam().getDvChushutsuJoken().getRadChushutsuKijun();
    }

    @JsonIgnore
    public void  setRadChushutsuKijun(RadioButton radChushutsuKijun) {
        this.getDvHihokenshaDaichoParam().getDvChushutsuJoken().setRadChushutsuKijun(radChushutsuKijun);
    }

    @JsonIgnore
    public CheckBoxList getChkShutokuJiyu() {
        return this.getDvHihokenshaDaichoParam().getDvChushutsuJoken().getChkShutokuJiyu();
    }

    @JsonIgnore
    public void  setChkShutokuJiyu(CheckBoxList chkShutokuJiyu) {
        this.getDvHihokenshaDaichoParam().getDvChushutsuJoken().setChkShutokuJiyu(chkShutokuJiyu);
    }

    @JsonIgnore
    public CheckBoxList getChkSoshitsuJiyu() {
        return this.getDvHihokenshaDaichoParam().getDvChushutsuJoken().getChkSoshitsuJiyu();
    }

    @JsonIgnore
    public void  setChkSoshitsuJiyu(CheckBoxList chkSoshitsuJiyu) {
        this.getDvHihokenshaDaichoParam().getDvChushutsuJoken().setChkSoshitsuJiyu(chkSoshitsuJiyu);
    }

    @JsonIgnore
    public DvCsvHenshuHohoDiv getDvCsvHenshuHoho() {
        return this.getDvHihokenshaDaichoParam().getDvCsvHenshuHoho();
    }

    @JsonIgnore
    public void  setDvCsvHenshuHoho(DvCsvHenshuHohoDiv DvCsvHenshuHoho) {
        this.getDvHihokenshaDaichoParam().setDvCsvHenshuHoho(DvCsvHenshuHoho);
    }

    @JsonIgnore
    public CheckBoxList getChkCsvHenshuHoho() {
        return this.getDvHihokenshaDaichoParam().getDvCsvHenshuHoho().getChkCsvHenshuHoho();
    }

    @JsonIgnore
    public void  setChkCsvHenshuHoho(CheckBoxList chkCsvHenshuHoho) {
        this.getDvHihokenshaDaichoParam().getDvCsvHenshuHoho().setChkCsvHenshuHoho(chkCsvHenshuHoho);
    }

    @JsonIgnore
    public IChohyoShutsuryokujunDiv getCcdKogakuShutsuryokujun() {
        return this.getDvHihokenshaDaichoParam().getCcdKogakuShutsuryokujun();
    }

    @JsonIgnore
    public IChohyoShutsuryokuKomokuDiv getCcdKogakuShutsuryokuKomoku() {
        return this.getDvHihokenshaDaichoParam().getCcdKogakuShutsuryokuKomoku();
    }

    @JsonIgnore
    public IHanyoListAtenaSelectDiv getCcdHanyoListAtenaSelect() {
        return this.getDvHihokenshaDaichoParam().getCcdHanyoListAtenaSelect();
    }

    // </editor-fold>
}
