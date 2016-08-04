package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2300001;
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
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("Chkirai")
    private CheckBoxList Chkirai;
    @JsonProperty("txtHakobi")
    private TextBoxDate txtHakobi;
    @JsonProperty("radkigen")
    private RadioButton radkigen;
    @JsonProperty("txtkigenymd")
    private TextBoxDate txtkigenymd;
    @JsonProperty("Sp")
    private Space Sp;
    @JsonProperty("Chkprint")
    private CheckBoxList Chkprint;

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
     * gettxtHakobi
     * @return txtHakobi
     */
    @JsonProperty("txtHakobi")
    public TextBoxDate getTxtHakobi() {
        return txtHakobi;
    }

    /*
     * settxtHakobi
     * @param txtHakobi txtHakobi
     */
    @JsonProperty("txtHakobi")
    public void setTxtHakobi(TextBoxDate txtHakobi) {
        this.txtHakobi = txtHakobi;
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
    public TextBoxDate getTxtkigenymd() {
        return txtkigenymd;
    }

    /*
     * settxtkigenymd
     * @param txtkigenymd txtkigenymd
     */
    @JsonProperty("txtkigenymd")
    public void setTxtkigenymd(TextBoxDate txtkigenymd) {
        this.txtkigenymd = txtkigenymd;
    }

    /*
     * getSp
     * @return Sp
     */
    @JsonProperty("Sp")
    public Space getSp() {
        return Sp;
    }

    /*
     * setSp
     * @param Sp Sp
     */
    @JsonProperty("Sp")
    public void setSp(Space Sp) {
        this.Sp = Sp;
    }

    /*
     * getChkprint
     * @return Chkprint
     */
    @JsonProperty("Chkprint")
    public CheckBoxList getChkprint() {
        return Chkprint;
    }

    /*
     * setChkprint
     * @param Chkprint Chkprint
     */
    @JsonProperty("Chkprint")
    public void setChkprint(CheckBoxList Chkprint) {
        this.Chkprint = Chkprint;
    }

    // </editor-fold>
}
