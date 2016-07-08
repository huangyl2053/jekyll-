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
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-06-27_21-36-36">
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
    @JsonProperty("AtenaChushutsuJoken")
    private AtenaChushutsuJokenDiv AtenaChushutsuJoken;
    @JsonProperty("DvCsvHenshuHoho")
    private DvCsvHenshuHohoDiv DvCsvHenshuHoho;
    @JsonProperty("ccdKogakuShutsuryokujun")
    private ChohyoShutsuryokujunDiv ccdKogakuShutsuryokujun;
    @JsonProperty("ccdKogakuShutsuryokuKomoku")
    private ChohyoShutsuryokuKomokuDiv ccdKogakuShutsuryokuKomoku;

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
     * getAtenaChushutsuJoken
     * @return AtenaChushutsuJoken
     */
    @JsonProperty("AtenaChushutsuJoken")
    public AtenaChushutsuJokenDiv getAtenaChushutsuJoken() {
        return AtenaChushutsuJoken;
    }

    /*
     * setAtenaChushutsuJoken
     * @param AtenaChushutsuJoken AtenaChushutsuJoken
     */
    @JsonProperty("AtenaChushutsuJoken")
    public void setAtenaChushutsuJoken(AtenaChushutsuJokenDiv AtenaChushutsuJoken) {
        this.AtenaChushutsuJoken = AtenaChushutsuJoken;
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
     * getccdKogakuShutsuryokujun
     * @return ccdKogakuShutsuryokujun
     */
    @JsonProperty("ccdKogakuShutsuryokujun")
    public IChohyoShutsuryokujunDiv getCcdKogakuShutsuryokujun() {
        return ccdKogakuShutsuryokujun;
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
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public ButtonBatchParameterSave getBtnParamSave() {
        return this.getDvJikenFukugenHozon().getBtnParamSave();
    }

    @JsonIgnore
    public void  setBtnParamSave(ButtonBatchParameterSave btnParamSave) {
        this.getDvJikenFukugenHozon().setBtnParamSave(btnParamSave);
    }

    @JsonIgnore
    public ButtonBatchParameterRestore getBtnParamRestore() {
        return this.getDvJikenFukugenHozon().getBtnParamRestore();
    }

    @JsonIgnore
    public void  setBtnParamRestore(ButtonBatchParameterRestore btnParamRestore) {
        this.getDvJikenFukugenHozon().setBtnParamRestore(btnParamRestore);
    }

    @JsonIgnore
    public RadioButton getRadChushutsuChokkin() {
        return this.getDvChushutsuJoken().getRadChushutsuChokkin();
    }

    @JsonIgnore
    public void  setRadChushutsuChokkin(RadioButton radChushutsuChokkin) {
        this.getDvChushutsuJoken().setRadChushutsuChokkin(radChushutsuChokkin);
    }

    @JsonIgnore
    public RadioButton getRadChushutsuKijunBi() {
        return this.getDvChushutsuJoken().getRadChushutsuKijunBi();
    }

    @JsonIgnore
    public void  setRadChushutsuKijunBi(RadioButton radChushutsuKijunBi) {
        this.getDvChushutsuJoken().setRadChushutsuKijunBi(radChushutsuKijunBi);
    }

    @JsonIgnore
    public RadioButton getRadKijunbiDateKind() {
        return this.getDvChushutsuJoken().getRadKijunbiDateKind();
    }

    @JsonIgnore
    public void  setRadKijunbiDateKind(RadioButton radKijunbiDateKind) {
        this.getDvChushutsuJoken().setRadKijunbiDateKind(radKijunbiDateKind);
    }

    @JsonIgnore
    public TextBoxDate getTxtKijunDate() {
        return this.getDvChushutsuJoken().getTxtKijunDate();
    }

    @JsonIgnore
    public void  setTxtKijunDate(TextBoxDate txtKijunDate) {
        this.getDvChushutsuJoken().setTxtKijunDate(txtKijunDate);
    }

    @JsonIgnore
    public CheckBoxList getChkKijunDateNozoku() {
        return this.getDvChushutsuJoken().getChkKijunDateNozoku();
    }

    @JsonIgnore
    public void  setChkKijunDateNozoku(CheckBoxList chkKijunDateNozoku) {
        this.getDvChushutsuJoken().setChkKijunDateNozoku(chkKijunDateNozoku);
    }

    @JsonIgnore
    public RadioButton getRadChushutsuHani() {
        return this.getDvChushutsuJoken().getRadChushutsuHani();
    }

    @JsonIgnore
    public void  setRadChushutsuHani(RadioButton radChushutsuHani) {
        this.getDvChushutsuJoken().setRadChushutsuHani(radChushutsuHani);
    }

    @JsonIgnore
    public RadioButton getRadHani() {
        return this.getDvChushutsuJoken().getRadHani();
    }

    @JsonIgnore
    public void  setRadHani(RadioButton radHani) {
        this.getDvChushutsuJoken().setRadHani(radHani);
    }

    @JsonIgnore
    public TextBoxDateRange getTxtChushutsuHani() {
        return this.getDvChushutsuJoken().getTxtChushutsuHani();
    }

    @JsonIgnore
    public void  setTxtChushutsuHani(TextBoxDateRange txtChushutsuHani) {
        this.getDvChushutsuJoken().setTxtChushutsuHani(txtChushutsuHani);
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
    public RadioButton getRadShikakuJokyo() {
        return this.getDvChushutsuJoken().getRadShikakuJokyo();
    }

    @JsonIgnore
    public void  setRadShikakuJokyo(RadioButton radShikakuJokyo) {
        this.getDvChushutsuJoken().setRadShikakuJokyo(radShikakuJokyo);
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
    public IHanyoListAtenaSelectDiv getCcdHanyoListAtenaSelect() {
        return this.getAtenaChushutsuJoken().getCcdHanyoListAtenaSelect();
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
