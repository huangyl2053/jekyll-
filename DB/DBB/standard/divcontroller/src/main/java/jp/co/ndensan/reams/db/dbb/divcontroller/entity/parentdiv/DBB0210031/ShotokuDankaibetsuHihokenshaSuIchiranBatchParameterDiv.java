package jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB0210031;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.PanelBatchParameter;

/**
 * ShotokuDankaibetsuHihokenshaSuIchiranBatchParameter のクラスファイル 
 * 
 * @author 自動生成
 */
public class ShotokuDankaibetsuHihokenshaSuIchiranBatchParameterDiv extends PanelBatchParameter {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-07-28_11-34-20">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ShotokuDankaibetsuHihokenshaSuIchiranShoriNaiyo")
    private ShotokuDankaibetsuHihokenshaSuIchiranShoriNaiyoDiv ShotokuDankaibetsuHihokenshaSuIchiranShoriNaiyo;
    @JsonProperty("ShichoshonSelect")
    private ShichoshonSelectDiv ShichoshonSelect;
    @JsonProperty("ChushutsuJoken")
    private ChushutsuJokenDiv ChushutsuJoken;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getShotokuDankaibetsuHihokenshaSuIchiranShoriNaiyo
     * @return ShotokuDankaibetsuHihokenshaSuIchiranShoriNaiyo
     */
    @JsonProperty("ShotokuDankaibetsuHihokenshaSuIchiranShoriNaiyo")
    public ShotokuDankaibetsuHihokenshaSuIchiranShoriNaiyoDiv getShotokuDankaibetsuHihokenshaSuIchiranShoriNaiyo() {
        return ShotokuDankaibetsuHihokenshaSuIchiranShoriNaiyo;
    }

    /*
     * setShotokuDankaibetsuHihokenshaSuIchiranShoriNaiyo
     * @param ShotokuDankaibetsuHihokenshaSuIchiranShoriNaiyo ShotokuDankaibetsuHihokenshaSuIchiranShoriNaiyo
     */
    @JsonProperty("ShotokuDankaibetsuHihokenshaSuIchiranShoriNaiyo")
    public void setShotokuDankaibetsuHihokenshaSuIchiranShoriNaiyo(ShotokuDankaibetsuHihokenshaSuIchiranShoriNaiyoDiv ShotokuDankaibetsuHihokenshaSuIchiranShoriNaiyo) {
        this.ShotokuDankaibetsuHihokenshaSuIchiranShoriNaiyo = ShotokuDankaibetsuHihokenshaSuIchiranShoriNaiyo;
    }

    /*
     * getShichoshonSelect
     * @return ShichoshonSelect
     */
    @JsonProperty("ShichoshonSelect")
    public ShichoshonSelectDiv getShichoshonSelect() {
        return ShichoshonSelect;
    }

    /*
     * setShichoshonSelect
     * @param ShichoshonSelect ShichoshonSelect
     */
    @JsonProperty("ShichoshonSelect")
    public void setShichoshonSelect(ShichoshonSelectDiv ShichoshonSelect) {
        this.ShichoshonSelect = ShichoshonSelect;
    }

    /*
     * getChushutsuJoken
     * @return ChushutsuJoken
     */
    @JsonProperty("ChushutsuJoken")
    public ChushutsuJokenDiv getChushutsuJoken() {
        return ChushutsuJoken;
    }

    /*
     * setChushutsuJoken
     * @param ChushutsuJoken ChushutsuJoken
     */
    @JsonProperty("ChushutsuJoken")
    public void setChushutsuJoken(ChushutsuJokenDiv ChushutsuJoken) {
        this.ChushutsuJoken = ChushutsuJoken;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public DropDownList getDdlChoteiNendo() {
        return this.getShotokuDankaibetsuHihokenshaSuIchiranShoriNaiyo().getDdlChoteiNendo();
    }

    @JsonIgnore
    public void  setDdlChoteiNendo(DropDownList ddlChoteiNendo) {
        this.getShotokuDankaibetsuHihokenshaSuIchiranShoriNaiyo().setDdlChoteiNendo(ddlChoteiNendo);
    }

    @JsonIgnore
    public TextBoxDate getTxtHonsanteiShoriYMD() {
        return this.getShotokuDankaibetsuHihokenshaSuIchiranShoriNaiyo().getTxtHonsanteiShoriYMD();
    }

    @JsonIgnore
    public void  setTxtHonsanteiShoriYMD(TextBoxDate txtHonsanteiShoriYMD) {
        this.getShotokuDankaibetsuHihokenshaSuIchiranShoriNaiyo().setTxtHonsanteiShoriYMD(txtHonsanteiShoriYMD);
    }

    @JsonIgnore
    public RadioButton getRadShichoson() {
        return this.getShichoshonSelect().getRadShichoson();
    }

    @JsonIgnore
    public void  setRadShichoson(RadioButton radShichoson) {
        this.getShichoshonSelect().setRadShichoson(radShichoson);
    }

    @JsonIgnore
    public ButtonDialog getBtnShichosonSelect() {
        return this.getShichoshonSelect().getBtnShichosonSelect();
    }

    @JsonIgnore
    public void  setBtnShichosonSelect(ButtonDialog btnShichosonSelect) {
        this.getShichoshonSelect().setBtnShichosonSelect(btnShichosonSelect);
    }

    @JsonIgnore
    public TextBox getTxtHidden() {
        return this.getShichoshonSelect().getTxtHidden();
    }

    @JsonIgnore
    public void  setTxtHidden(TextBox txtHidden) {
        this.getShichoshonSelect().setTxtHidden(txtHidden);
    }

    @JsonIgnore
    public CheckBoxList getChkChosaJoken() {
        return this.getChushutsuJoken().getChkChosaJoken();
    }

    @JsonIgnore
    public void  setChkChosaJoken(CheckBoxList chkChosaJoken) {
        this.getChushutsuJoken().setChkChosaJoken(chkChosaJoken);
    }

    @JsonIgnore
    public TextBoxDate getTxtShikakuKijunYMD() {
        return this.getChushutsuJoken().getTxtShikakuKijunYMD();
    }

    @JsonIgnore
    public void  setTxtShikakuKijunYMD(TextBoxDate txtShikakuKijunYMD) {
        this.getChushutsuJoken().setTxtShikakuKijunYMD(txtShikakuKijunYMD);
    }

    @JsonIgnore
    public TextBoxDate getTxtChoteiKijunYMD() {
        return this.getChushutsuJoken().getTxtChoteiKijunYMD();
    }

    @JsonIgnore
    public void  setTxtChoteiKijunYMD(TextBoxDate txtChoteiKijunYMD) {
        this.getChushutsuJoken().setTxtChoteiKijunYMD(txtChoteiKijunYMD);
    }

    // </editor-fold>
}
