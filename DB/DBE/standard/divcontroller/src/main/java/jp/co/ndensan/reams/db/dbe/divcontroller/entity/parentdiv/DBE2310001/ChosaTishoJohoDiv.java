package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2310001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * ChosaTishoJoho のクラスファイル 
 * 
 * @author 自動生成
 */
public class ChosaTishoJohoDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-01-15_09-59-03">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtSaishuShinryoYMD")
    private TextBoxDate txtSaishuShinryoYMD;
    @JsonProperty("radIkenshoSakuseiKaisu")
    private RadioButton radIkenshoSakuseiKaisu;
    @JsonProperty("radTakaShinryo")
    private RadioButton radTakaShinryo;
    @JsonProperty("chkTakaJushinSelect")
    private CheckBoxList chkTakaJushinSelect;
    @JsonProperty("chkSonota")
    private CheckBoxList chkSonota;
    @JsonProperty("txtSonotaNyuryoku")
    private TextBox txtSonotaNyuryoku;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtSaishuShinryoYMD
     * @return txtSaishuShinryoYMD
     */
    @JsonProperty("txtSaishuShinryoYMD")
    public TextBoxDate getTxtSaishuShinryoYMD() {
        return txtSaishuShinryoYMD;
    }

    /*
     * settxtSaishuShinryoYMD
     * @param txtSaishuShinryoYMD txtSaishuShinryoYMD
     */
    @JsonProperty("txtSaishuShinryoYMD")
    public void setTxtSaishuShinryoYMD(TextBoxDate txtSaishuShinryoYMD) {
        this.txtSaishuShinryoYMD = txtSaishuShinryoYMD;
    }

    /*
     * getradIkenshoSakuseiKaisu
     * @return radIkenshoSakuseiKaisu
     */
    @JsonProperty("radIkenshoSakuseiKaisu")
    public RadioButton getRadIkenshoSakuseiKaisu() {
        return radIkenshoSakuseiKaisu;
    }

    /*
     * setradIkenshoSakuseiKaisu
     * @param radIkenshoSakuseiKaisu radIkenshoSakuseiKaisu
     */
    @JsonProperty("radIkenshoSakuseiKaisu")
    public void setRadIkenshoSakuseiKaisu(RadioButton radIkenshoSakuseiKaisu) {
        this.radIkenshoSakuseiKaisu = radIkenshoSakuseiKaisu;
    }

    /*
     * getradTakaShinryo
     * @return radTakaShinryo
     */
    @JsonProperty("radTakaShinryo")
    public RadioButton getRadTakaShinryo() {
        return radTakaShinryo;
    }

    /*
     * setradTakaShinryo
     * @param radTakaShinryo radTakaShinryo
     */
    @JsonProperty("radTakaShinryo")
    public void setRadTakaShinryo(RadioButton radTakaShinryo) {
        this.radTakaShinryo = radTakaShinryo;
    }

    /*
     * getchkTakaJushinSelect
     * @return chkTakaJushinSelect
     */
    @JsonProperty("chkTakaJushinSelect")
    public CheckBoxList getChkTakaJushinSelect() {
        return chkTakaJushinSelect;
    }

    /*
     * setchkTakaJushinSelect
     * @param chkTakaJushinSelect chkTakaJushinSelect
     */
    @JsonProperty("chkTakaJushinSelect")
    public void setChkTakaJushinSelect(CheckBoxList chkTakaJushinSelect) {
        this.chkTakaJushinSelect = chkTakaJushinSelect;
    }

    /*
     * getchkSonota
     * @return chkSonota
     */
    @JsonProperty("chkSonota")
    public CheckBoxList getChkSonota() {
        return chkSonota;
    }

    /*
     * setchkSonota
     * @param chkSonota chkSonota
     */
    @JsonProperty("chkSonota")
    public void setChkSonota(CheckBoxList chkSonota) {
        this.chkSonota = chkSonota;
    }

    /*
     * gettxtSonotaNyuryoku
     * @return txtSonotaNyuryoku
     */
    @JsonProperty("txtSonotaNyuryoku")
    public TextBox getTxtSonotaNyuryoku() {
        return txtSonotaNyuryoku;
    }

    /*
     * settxtSonotaNyuryoku
     * @param txtSonotaNyuryoku txtSonotaNyuryoku
     */
    @JsonProperty("txtSonotaNyuryoku")
    public void setTxtSonotaNyuryoku(TextBox txtSonotaNyuryoku) {
        this.txtSonotaNyuryoku = txtSonotaNyuryoku;
    }

    // </editor-fold>
}
