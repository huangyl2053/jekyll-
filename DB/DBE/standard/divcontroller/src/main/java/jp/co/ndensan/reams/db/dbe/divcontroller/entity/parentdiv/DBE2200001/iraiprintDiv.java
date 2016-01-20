package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2200001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * iraiprint のクラスファイル 
 * 
 * @author 自動生成
 */
public class iraiprintDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2015-11-30_08-54-50">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("Chkirai")
    private CheckBoxList Chkirai;
    @JsonProperty("txthokkoymd")
    private TextBox txthokkoymd;
    @JsonProperty("radkigen")
    private RadioButton radkigen;
    @JsonProperty("txtkigenymd")
    private TextBox txtkigenymd;
    @JsonProperty("SP")
    private Space SP;
    @JsonProperty("Chkchosa")
    private CheckBoxList Chkchosa;
    @JsonProperty("ChkchosaOcr")
    private CheckBoxList ChkchosaOcr;
    @JsonProperty("ChkchosaSonota")
    private CheckBoxList ChkchosaSonota;
    @JsonProperty("BtnPrint")
    private ButtonPrint BtnPrint;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getChkirai
     * @return Chkirai
     */
    @JsonProperty("Chkirai")
    public CheckBoxList getChkirai() {
        return Chkirai;
    }

    /*
     * setChkirai
     * @param Chkirai Chkirai
     */
    @JsonProperty("Chkirai")
    public void setChkirai(CheckBoxList Chkirai) {
        this.Chkirai = Chkirai;
    }

    /*
     * gettxthokkoymd
     * @return txthokkoymd
     */
    @JsonProperty("txthokkoymd")
    public TextBox getTxthokkoymd() {
        return txthokkoymd;
    }

    /*
     * settxthokkoymd
     * @param txthokkoymd txthokkoymd
     */
    @JsonProperty("txthokkoymd")
    public void setTxthokkoymd(TextBox txthokkoymd) {
        this.txthokkoymd = txthokkoymd;
    }

    /*
     * getradkigen
     * @return radkigen
     */
    @JsonProperty("radkigen")
    public RadioButton getRadkigen() {
        return radkigen;
    }

    /*
     * setradkigen
     * @param radkigen radkigen
     */
    @JsonProperty("radkigen")
    public void setRadkigen(RadioButton radkigen) {
        this.radkigen = radkigen;
    }

    /*
     * gettxtkigenymd
     * @return txtkigenymd
     */
    @JsonProperty("txtkigenymd")
    public TextBox getTxtkigenymd() {
        return txtkigenymd;
    }

    /*
     * settxtkigenymd
     * @param txtkigenymd txtkigenymd
     */
    @JsonProperty("txtkigenymd")
    public void setTxtkigenymd(TextBox txtkigenymd) {
        this.txtkigenymd = txtkigenymd;
    }

    /*
     * getSP
     * @return SP
     */
    @JsonProperty("SP")
    public Space getSP() {
        return SP;
    }

    /*
     * setSP
     * @param SP SP
     */
    @JsonProperty("SP")
    public void setSP(Space SP) {
        this.SP = SP;
    }

    /*
     * getChkchosa
     * @return Chkchosa
     */
    @JsonProperty("Chkchosa")
    public CheckBoxList getChkchosa() {
        return Chkchosa;
    }

    /*
     * setChkchosa
     * @param Chkchosa Chkchosa
     */
    @JsonProperty("Chkchosa")
    public void setChkchosa(CheckBoxList Chkchosa) {
        this.Chkchosa = Chkchosa;
    }

    /*
     * getChkchosaOcr
     * @return ChkchosaOcr
     */
    @JsonProperty("ChkchosaOcr")
    public CheckBoxList getChkchosaOcr() {
        return ChkchosaOcr;
    }

    /*
     * setChkchosaOcr
     * @param ChkchosaOcr ChkchosaOcr
     */
    @JsonProperty("ChkchosaOcr")
    public void setChkchosaOcr(CheckBoxList ChkchosaOcr) {
        this.ChkchosaOcr = ChkchosaOcr;
    }

    /*
     * getChkchosaSonota
     * @return ChkchosaSonota
     */
    @JsonProperty("ChkchosaSonota")
    public CheckBoxList getChkchosaSonota() {
        return ChkchosaSonota;
    }

    /*
     * setChkchosaSonota
     * @param ChkchosaSonota ChkchosaSonota
     */
    @JsonProperty("ChkchosaSonota")
    public void setChkchosaSonota(CheckBoxList ChkchosaSonota) {
        this.ChkchosaSonota = ChkchosaSonota;
    }

    /*
     * getBtnPrint
     * @return BtnPrint
     */
    @JsonProperty("BtnPrint")
    public ButtonPrint getBtnPrint() {
        return BtnPrint;
    }

    /*
     * setBtnPrint
     * @param BtnPrint BtnPrint
     */
    @JsonProperty("BtnPrint")
    public void setBtnPrint(ButtonPrint BtnPrint) {
        this.BtnPrint = BtnPrint;
    }

    // </editor-fold>
}
