package jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB0210031;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * ShotokuDankaibetsuHihokenshaSuIchiran のクラスファイル 
 * 
 * @author 自動生成
 */
public class ShotokuDankaibetsuHihokenshaSuIchiranDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-07-28_11-34-20">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ShotokuDankaibetsuHihokenshaSuIchiranBatchParameter")
    private ShotokuDankaibetsuHihokenshaSuIchiranBatchParameterDiv ShotokuDankaibetsuHihokenshaSuIchiranBatchParameter;
    @JsonProperty("kyuShichoson")
    private RString kyuShichoson;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getShotokuDankaibetsuHihokenshaSuIchiranBatchParameter
     * @return ShotokuDankaibetsuHihokenshaSuIchiranBatchParameter
     */
    @JsonProperty("ShotokuDankaibetsuHihokenshaSuIchiranBatchParameter")
    public ShotokuDankaibetsuHihokenshaSuIchiranBatchParameterDiv getShotokuDankaibetsuHihokenshaSuIchiranBatchParameter() {
        return ShotokuDankaibetsuHihokenshaSuIchiranBatchParameter;
    }

    /*
     * setShotokuDankaibetsuHihokenshaSuIchiranBatchParameter
     * @param ShotokuDankaibetsuHihokenshaSuIchiranBatchParameter ShotokuDankaibetsuHihokenshaSuIchiranBatchParameter
     */
    @JsonProperty("ShotokuDankaibetsuHihokenshaSuIchiranBatchParameter")
    public void setShotokuDankaibetsuHihokenshaSuIchiranBatchParameter(ShotokuDankaibetsuHihokenshaSuIchiranBatchParameterDiv ShotokuDankaibetsuHihokenshaSuIchiranBatchParameter) {
        this.ShotokuDankaibetsuHihokenshaSuIchiranBatchParameter = ShotokuDankaibetsuHihokenshaSuIchiranBatchParameter;
    }

    /*
     * getkyuShichoson
     * @return kyuShichoson
     */
    @JsonProperty("kyuShichoson")
    public RString getKyuShichoson() {
        return kyuShichoson;
    }

    /*
     * setkyuShichoson
     * @param kyuShichoson kyuShichoson
     */
    @JsonProperty("kyuShichoson")
    public void setKyuShichoson(RString kyuShichoson) {
        this.kyuShichoson = kyuShichoson;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public ShotokuDankaibetsuHihokenshaSuIchiranShoriNaiyoDiv getShotokuDankaibetsuHihokenshaSuIchiranShoriNaiyo() {
        return this.getShotokuDankaibetsuHihokenshaSuIchiranBatchParameter().getShotokuDankaibetsuHihokenshaSuIchiranShoriNaiyo();
    }

    @JsonIgnore
    public void  setShotokuDankaibetsuHihokenshaSuIchiranShoriNaiyo(ShotokuDankaibetsuHihokenshaSuIchiranShoriNaiyoDiv ShotokuDankaibetsuHihokenshaSuIchiranShoriNaiyo) {
        this.getShotokuDankaibetsuHihokenshaSuIchiranBatchParameter().setShotokuDankaibetsuHihokenshaSuIchiranShoriNaiyo(ShotokuDankaibetsuHihokenshaSuIchiranShoriNaiyo);
    }

    @JsonIgnore
    public DropDownList getDdlChoteiNendo() {
        return this.getShotokuDankaibetsuHihokenshaSuIchiranBatchParameter().getShotokuDankaibetsuHihokenshaSuIchiranShoriNaiyo().getDdlChoteiNendo();
    }

    @JsonIgnore
    public void  setDdlChoteiNendo(DropDownList ddlChoteiNendo) {
        this.getShotokuDankaibetsuHihokenshaSuIchiranBatchParameter().getShotokuDankaibetsuHihokenshaSuIchiranShoriNaiyo().setDdlChoteiNendo(ddlChoteiNendo);
    }

    @JsonIgnore
    public TextBoxDate getTxtHonsanteiShoriYMD() {
        return this.getShotokuDankaibetsuHihokenshaSuIchiranBatchParameter().getShotokuDankaibetsuHihokenshaSuIchiranShoriNaiyo().getTxtHonsanteiShoriYMD();
    }

    @JsonIgnore
    public void  setTxtHonsanteiShoriYMD(TextBoxDate txtHonsanteiShoriYMD) {
        this.getShotokuDankaibetsuHihokenshaSuIchiranBatchParameter().getShotokuDankaibetsuHihokenshaSuIchiranShoriNaiyo().setTxtHonsanteiShoriYMD(txtHonsanteiShoriYMD);
    }

    @JsonIgnore
    public ShichoshonSelectDiv getShichoshonSelect() {
        return this.getShotokuDankaibetsuHihokenshaSuIchiranBatchParameter().getShichoshonSelect();
    }

    @JsonIgnore
    public void  setShichoshonSelect(ShichoshonSelectDiv ShichoshonSelect) {
        this.getShotokuDankaibetsuHihokenshaSuIchiranBatchParameter().setShichoshonSelect(ShichoshonSelect);
    }

    @JsonIgnore
    public RadioButton getRadShichoson() {
        return this.getShotokuDankaibetsuHihokenshaSuIchiranBatchParameter().getShichoshonSelect().getRadShichoson();
    }

    @JsonIgnore
    public void  setRadShichoson(RadioButton radShichoson) {
        this.getShotokuDankaibetsuHihokenshaSuIchiranBatchParameter().getShichoshonSelect().setRadShichoson(radShichoson);
    }

    @JsonIgnore
    public ButtonDialog getBtnShichosonSelect() {
        return this.getShotokuDankaibetsuHihokenshaSuIchiranBatchParameter().getShichoshonSelect().getBtnShichosonSelect();
    }

    @JsonIgnore
    public void  setBtnShichosonSelect(ButtonDialog btnShichosonSelect) {
        this.getShotokuDankaibetsuHihokenshaSuIchiranBatchParameter().getShichoshonSelect().setBtnShichosonSelect(btnShichosonSelect);
    }

    @JsonIgnore
    public TextBox getTxtHidden() {
        return this.getShotokuDankaibetsuHihokenshaSuIchiranBatchParameter().getShichoshonSelect().getTxtHidden();
    }

    @JsonIgnore
    public void  setTxtHidden(TextBox txtHidden) {
        this.getShotokuDankaibetsuHihokenshaSuIchiranBatchParameter().getShichoshonSelect().setTxtHidden(txtHidden);
    }

    @JsonIgnore
    public ChushutsuJokenDiv getChushutsuJoken() {
        return this.getShotokuDankaibetsuHihokenshaSuIchiranBatchParameter().getChushutsuJoken();
    }

    @JsonIgnore
    public void  setChushutsuJoken(ChushutsuJokenDiv ChushutsuJoken) {
        this.getShotokuDankaibetsuHihokenshaSuIchiranBatchParameter().setChushutsuJoken(ChushutsuJoken);
    }

    @JsonIgnore
    public CheckBoxList getChkChosaJoken() {
        return this.getShotokuDankaibetsuHihokenshaSuIchiranBatchParameter().getChushutsuJoken().getChkChosaJoken();
    }

    @JsonIgnore
    public void  setChkChosaJoken(CheckBoxList chkChosaJoken) {
        this.getShotokuDankaibetsuHihokenshaSuIchiranBatchParameter().getChushutsuJoken().setChkChosaJoken(chkChosaJoken);
    }

    @JsonIgnore
    public TextBoxDate getTxtShikakuKijunYMD() {
        return this.getShotokuDankaibetsuHihokenshaSuIchiranBatchParameter().getChushutsuJoken().getTxtShikakuKijunYMD();
    }

    @JsonIgnore
    public void  setTxtShikakuKijunYMD(TextBoxDate txtShikakuKijunYMD) {
        this.getShotokuDankaibetsuHihokenshaSuIchiranBatchParameter().getChushutsuJoken().setTxtShikakuKijunYMD(txtShikakuKijunYMD);
    }

    @JsonIgnore
    public TextBoxDate getTxtChoteiKijunYMD() {
        return this.getShotokuDankaibetsuHihokenshaSuIchiranBatchParameter().getChushutsuJoken().getTxtChoteiKijunYMD();
    }

    @JsonIgnore
    public void  setTxtChoteiKijunYMD(TextBoxDate txtChoteiKijunYMD) {
        this.getShotokuDankaibetsuHihokenshaSuIchiranBatchParameter().getChushutsuJoken().setTxtChoteiKijunYMD(txtChoteiKijunYMD);
    }

    // </editor-fold>
}
