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
import jp.co.ndensan.reams.uz.uza.ui.binding.PanelBatchParameter;

/**
 * DvHihokenshaDaichoParam のクラスファイル 
 * 
 * @author 自動生成
 */
public class DvHihokenshaDaichoParamDiv extends PanelBatchParameter {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-03-22_14-06-37">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("DvJikenFukugenHozon")
    private DvJikenFukugenHozonDiv DvJikenFukugenHozon;
    @JsonProperty("DvChushutsuJoken")
    private DvChushutsuJokenDiv DvChushutsuJoken;
    @JsonProperty("DvCsvHenshuHoho")
    private DvCsvHenshuHohoDiv DvCsvHenshuHoho;
    @JsonProperty("ccdKogakuShutsuryokuKomoku")
    private ChohyoShutsuryokuKomokuDiv ccdKogakuShutsuryokuKomoku;
    @JsonProperty("ccdKogakuShutsuryokujun")
    private ChohyoShutsuryokujunDiv ccdKogakuShutsuryokujun;
    @JsonProperty("ccdHanyoListAtenaSelect")
    private HanyoListAtenaSelectDiv ccdHanyoListAtenaSelect;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getDvJikenFukugenHozon
     * @return DvJikenFukugenHozon
     */
    @JsonProperty("DvJikenFukugenHozon")
    public DvJikenFukugenHozonDiv getDvJikenFukugenHozon() {
        return DvJikenFukugenHozon;
    }

    /*
     * setDvJikenFukugenHozon
     * @param DvJikenFukugenHozon DvJikenFukugenHozon
     */
    @JsonProperty("DvJikenFukugenHozon")
    public void setDvJikenFukugenHozon(DvJikenFukugenHozonDiv DvJikenFukugenHozon) {
        this.DvJikenFukugenHozon = DvJikenFukugenHozon;
    }

    /*
     * getDvChushutsuJoken
     * @return DvChushutsuJoken
     */
    @JsonProperty("DvChushutsuJoken")
    public DvChushutsuJokenDiv getDvChushutsuJoken() {
        return DvChushutsuJoken;
    }

    /*
     * setDvChushutsuJoken
     * @param DvChushutsuJoken DvChushutsuJoken
     */
    @JsonProperty("DvChushutsuJoken")
    public void setDvChushutsuJoken(DvChushutsuJokenDiv DvChushutsuJoken) {
        this.DvChushutsuJoken = DvChushutsuJoken;
    }

    /*
     * getDvCsvHenshuHoho
     * @return DvCsvHenshuHoho
     */
    @JsonProperty("DvCsvHenshuHoho")
    public DvCsvHenshuHohoDiv getDvCsvHenshuHoho() {
        return DvCsvHenshuHoho;
    }

    /*
     * setDvCsvHenshuHoho
     * @param DvCsvHenshuHoho DvCsvHenshuHoho
     */
    @JsonProperty("DvCsvHenshuHoho")
    public void setDvCsvHenshuHoho(DvCsvHenshuHohoDiv DvCsvHenshuHoho) {
        this.DvCsvHenshuHoho = DvCsvHenshuHoho;
    }

    /*
     * getccdKogakuShutsuryokuKomoku
     * @return ccdKogakuShutsuryokuKomoku
     */
    @JsonProperty("ccdKogakuShutsuryokuKomoku")
    public IChohyoShutsuryokuKomokuDiv getCcdKogakuShutsuryokuKomoku() {
        return ccdKogakuShutsuryokuKomoku;
    }

    /*
     * getccdKogakuShutsuryokujun
     * @return ccdKogakuShutsuryokujun
     */
    @JsonProperty("ccdKogakuShutsuryokujun")
    public IChohyoShutsuryokujunDiv getCcdKogakuShutsuryokujun() {
        return ccdKogakuShutsuryokujun;
    }

    /*
     * getccdHanyoListAtenaSelect
     * @return ccdHanyoListAtenaSelect
     */
    @JsonProperty("ccdHanyoListAtenaSelect")
    public IHanyoListAtenaSelectDiv getCcdHanyoListAtenaSelect() {
        return ccdHanyoListAtenaSelect;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public ButtonBatchParameterSave getBtnKogakuParamSave() {
        return this.getDvJikenFukugenHozon().getBtnKogakuParamSave();
    }

    @JsonIgnore
    public void  setBtnKogakuParamSave(ButtonBatchParameterSave btnKogakuParamSave) {
        this.getDvJikenFukugenHozon().setBtnKogakuParamSave(btnKogakuParamSave);
    }

    @JsonIgnore
    public ButtonBatchParameterRestore getBtnKogakuParamRestore() {
        return this.getDvJikenFukugenHozon().getBtnKogakuParamRestore();
    }

    @JsonIgnore
    public void  setBtnKogakuParamRestore(ButtonBatchParameterRestore btnKogakuParamRestore) {
        this.getDvJikenFukugenHozon().setBtnKogakuParamRestore(btnKogakuParamRestore);
    }

    @JsonIgnore
    public DvChushutsuDiv getDvChushutsu() {
        return this.getDvChushutsuJoken().getDvChushutsu();
    }

    @JsonIgnore
    public void  setDvChushutsu(DvChushutsuDiv DvChushutsu) {
        this.getDvChushutsuJoken().setDvChushutsu(DvChushutsu);
    }

    @JsonIgnore
    public RadioButton getRadChushutsu() {
        return this.getDvChushutsuJoken().getDvChushutsu().getRadChushutsu();
    }

    @JsonIgnore
    public void  setRadChushutsu(RadioButton radChushutsu) {
        this.getDvChushutsuJoken().getDvChushutsu().setRadChushutsu(radChushutsu);
    }

    @JsonIgnore
    public DvChushutsuShosaiDiv getDvChushutsuShosai() {
        return this.getDvChushutsuJoken().getDvChushutsuShosai();
    }

    @JsonIgnore
    public void  setDvChushutsuShosai(DvChushutsuShosaiDiv DvChushutsuShosai) {
        this.getDvChushutsuJoken().setDvChushutsuShosai(DvChushutsuShosai);
    }

    @JsonIgnore
    public Label getLblKuhaku() {
        return this.getDvChushutsuJoken().getDvChushutsuShosai().getLblKuhaku();
    }

    @JsonIgnore
    public void  setLblKuhaku(Label lblKuhaku) {
        this.getDvChushutsuJoken().getDvChushutsuShosai().setLblKuhaku(lblKuhaku);
    }

    @JsonIgnore
    public RadioButton getRadKijunbiDate() {
        return this.getDvChushutsuJoken().getDvChushutsuShosai().getRadKijunbiDate();
    }

    @JsonIgnore
    public void  setRadKijunbiDate(RadioButton radKijunbiDate) {
        this.getDvChushutsuJoken().getDvChushutsuShosai().setRadKijunbiDate(radKijunbiDate);
    }

    @JsonIgnore
    public TextBoxDateRange getTxtIryokikan() {
        return this.getDvChushutsuJoken().getDvChushutsuShosai().getTxtIryokikan();
    }

    @JsonIgnore
    public void  setTxtIryokikan(TextBoxDateRange txtIryokikan) {
        this.getDvChushutsuJoken().getDvChushutsuShosai().setTxtIryokikan(txtIryokikan);
    }

    @JsonIgnore
    public TextBoxDate getTxtKijunDate() {
        return this.getDvChushutsuJoken().getDvChushutsuShosai().getTxtKijunDate();
    }

    @JsonIgnore
    public void  setTxtKijunDate(TextBoxDate txtKijunDate) {
        this.getDvChushutsuJoken().getDvChushutsuShosai().setTxtKijunDate(txtKijunDate);
    }

    @JsonIgnore
    public CheckBoxList getChkKijunDateNozoku() {
        return this.getDvChushutsuJoken().getDvChushutsuShosai().getChkKijunDateNozoku();
    }

    @JsonIgnore
    public void  setChkKijunDateNozoku(CheckBoxList chkKijunDateNozoku) {
        this.getDvChushutsuJoken().getDvChushutsuShosai().setChkKijunDateNozoku(chkKijunDateNozoku);
    }

    @JsonIgnore
    public RadioButton getRadHani() {
        return this.getDvChushutsuJoken().getDvChushutsuShosai().getRadHani();
    }

    @JsonIgnore
    public void  setRadHani(RadioButton radHani) {
        this.getDvChushutsuJoken().getDvChushutsuShosai().setRadHani(radHani);
    }

    @JsonIgnore
    public TextBoxDateRange getTxtChushutsuHani() {
        return this.getDvChushutsuJoken().getDvChushutsuShosai().getTxtChushutsuHani();
    }

    @JsonIgnore
    public void  setTxtChushutsuHani(TextBoxDateRange txtChushutsuHani) {
        this.getDvChushutsuJoken().getDvChushutsuShosai().setTxtChushutsuHani(txtChushutsuHani);
    }

    @JsonIgnore
    public HorizontalLine getLinLine1() {
        return this.getDvChushutsuJoken().getLinLine1();
    }

    @JsonIgnore
    public void  setLinLine1(HorizontalLine linLine1) {
        this.getDvChushutsuJoken().setLinLine1(linLine1);
    }

    @JsonIgnore
    public CheckBoxList getChkHihokenshaJoho() {
        return this.getDvChushutsuJoken().getChkHihokenshaJoho();
    }

    @JsonIgnore
    public void  setChkHihokenshaJoho(CheckBoxList chkHihokenshaJoho) {
        this.getDvChushutsuJoken().setChkHihokenshaJoho(chkHihokenshaJoho);
    }

    @JsonIgnore
    public HorizontalLine getLinLine2() {
        return this.getDvChushutsuJoken().getLinLine2();
    }

    @JsonIgnore
    public void  setLinLine2(HorizontalLine linLine2) {
        this.getDvChushutsuJoken().setLinLine2(linLine2);
    }

    @JsonIgnore
    public RadioButton getRadChushutsuKijun() {
        return this.getDvChushutsuJoken().getRadChushutsuKijun();
    }

    @JsonIgnore
    public void  setRadChushutsuKijun(RadioButton radChushutsuKijun) {
        this.getDvChushutsuJoken().setRadChushutsuKijun(radChushutsuKijun);
    }

    @JsonIgnore
    public CheckBoxList getChkShutokuJiyu() {
        return this.getDvChushutsuJoken().getChkShutokuJiyu();
    }

    @JsonIgnore
    public void  setChkShutokuJiyu(CheckBoxList chkShutokuJiyu) {
        this.getDvChushutsuJoken().setChkShutokuJiyu(chkShutokuJiyu);
    }

    @JsonIgnore
    public CheckBoxList getChkSoshitsuJiyu() {
        return this.getDvChushutsuJoken().getChkSoshitsuJiyu();
    }

    @JsonIgnore
    public void  setChkSoshitsuJiyu(CheckBoxList chkSoshitsuJiyu) {
        this.getDvChushutsuJoken().setChkSoshitsuJiyu(chkSoshitsuJiyu);
    }

    @JsonIgnore
    public CheckBoxList getChkCsvHenshuHoho() {
        return this.getDvCsvHenshuHoho().getChkCsvHenshuHoho();
    }

    @JsonIgnore
    public void  setChkCsvHenshuHoho(CheckBoxList chkCsvHenshuHoho) {
        this.getDvCsvHenshuHoho().setChkCsvHenshuHoho(chkCsvHenshuHoho);
    }

    // </editor-fold>
}
