package jp.co.ndensan.reams.db.dbd.divcontroller.entity.commonchilddiv.gemmemgengakushinsei.GemmenGengakuShinsei;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * Shinseisha のクラスファイル 
 * 
 * @author 自動生成
 */
public class ShinseishaDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtShinseishaShimeiKana")
    private TextBoxKana txtShinseishaShimeiKana;
    @JsonProperty("txtCopyHonnin")
    private Button txtCopyHonnin;
    @JsonProperty("txtShinseishaShimei")
    private TextBoxAtenaMeisho txtShinseishaShimei;
    @JsonProperty("txtShinseishaTsuzukigara")
    private TextBox txtShinseishaTsuzukigara;
    @JsonProperty("imgYubinNoLabel")
    private StaticImage imgYubinNoLabel;
    @JsonProperty("txtShinseishaYubinNo")
    private TextBoxYubinNo txtShinseishaYubinNo;
    @JsonProperty("txtShinseishaTelNo")
    private TextBoxTelNo txtShinseishaTelNo;
    @JsonProperty("txtShinseishaJusho")
    private TextBoxJusho txtShinseishaJusho;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtShinseishaShimeiKana
     * @return txtShinseishaShimeiKana
     */
    @JsonProperty("txtShinseishaShimeiKana")
    public TextBoxKana getTxtShinseishaShimeiKana() {
        return txtShinseishaShimeiKana;
    }

    /*
     * settxtShinseishaShimeiKana
     * @param txtShinseishaShimeiKana txtShinseishaShimeiKana
     */
    @JsonProperty("txtShinseishaShimeiKana")
    public void setTxtShinseishaShimeiKana(TextBoxKana txtShinseishaShimeiKana) {
        this.txtShinseishaShimeiKana = txtShinseishaShimeiKana;
    }

    /*
     * gettxtCopyHonnin
     * @return txtCopyHonnin
     */
    @JsonProperty("txtCopyHonnin")
    public Button getTxtCopyHonnin() {
        return txtCopyHonnin;
    }

    /*
     * settxtCopyHonnin
     * @param txtCopyHonnin txtCopyHonnin
     */
    @JsonProperty("txtCopyHonnin")
    public void setTxtCopyHonnin(Button txtCopyHonnin) {
        this.txtCopyHonnin = txtCopyHonnin;
    }

    /*
     * gettxtShinseishaShimei
     * @return txtShinseishaShimei
     */
    @JsonProperty("txtShinseishaShimei")
    public TextBoxAtenaMeisho getTxtShinseishaShimei() {
        return txtShinseishaShimei;
    }

    /*
     * settxtShinseishaShimei
     * @param txtShinseishaShimei txtShinseishaShimei
     */
    @JsonProperty("txtShinseishaShimei")
    public void setTxtShinseishaShimei(TextBoxAtenaMeisho txtShinseishaShimei) {
        this.txtShinseishaShimei = txtShinseishaShimei;
    }

    /*
     * gettxtShinseishaTsuzukigara
     * @return txtShinseishaTsuzukigara
     */
    @JsonProperty("txtShinseishaTsuzukigara")
    public TextBox getTxtShinseishaTsuzukigara() {
        return txtShinseishaTsuzukigara;
    }

    /*
     * settxtShinseishaTsuzukigara
     * @param txtShinseishaTsuzukigara txtShinseishaTsuzukigara
     */
    @JsonProperty("txtShinseishaTsuzukigara")
    public void setTxtShinseishaTsuzukigara(TextBox txtShinseishaTsuzukigara) {
        this.txtShinseishaTsuzukigara = txtShinseishaTsuzukigara;
    }

    /*
     * getimgYubinNoLabel
     * @return imgYubinNoLabel
     */
    @JsonProperty("imgYubinNoLabel")
    public StaticImage getImgYubinNoLabel() {
        return imgYubinNoLabel;
    }

    /*
     * setimgYubinNoLabel
     * @param imgYubinNoLabel imgYubinNoLabel
     */
    @JsonProperty("imgYubinNoLabel")
    public void setImgYubinNoLabel(StaticImage imgYubinNoLabel) {
        this.imgYubinNoLabel = imgYubinNoLabel;
    }

    /*
     * gettxtShinseishaYubinNo
     * @return txtShinseishaYubinNo
     */
    @JsonProperty("txtShinseishaYubinNo")
    public TextBoxYubinNo getTxtShinseishaYubinNo() {
        return txtShinseishaYubinNo;
    }

    /*
     * settxtShinseishaYubinNo
     * @param txtShinseishaYubinNo txtShinseishaYubinNo
     */
    @JsonProperty("txtShinseishaYubinNo")
    public void setTxtShinseishaYubinNo(TextBoxYubinNo txtShinseishaYubinNo) {
        this.txtShinseishaYubinNo = txtShinseishaYubinNo;
    }

    /*
     * gettxtShinseishaTelNo
     * @return txtShinseishaTelNo
     */
    @JsonProperty("txtShinseishaTelNo")
    public TextBoxTelNo getTxtShinseishaTelNo() {
        return txtShinseishaTelNo;
    }

    /*
     * settxtShinseishaTelNo
     * @param txtShinseishaTelNo txtShinseishaTelNo
     */
    @JsonProperty("txtShinseishaTelNo")
    public void setTxtShinseishaTelNo(TextBoxTelNo txtShinseishaTelNo) {
        this.txtShinseishaTelNo = txtShinseishaTelNo;
    }

    /*
     * gettxtShinseishaJusho
     * @return txtShinseishaJusho
     */
    @JsonProperty("txtShinseishaJusho")
    public TextBoxJusho getTxtShinseishaJusho() {
        return txtShinseishaJusho;
    }

    /*
     * settxtShinseishaJusho
     * @param txtShinseishaJusho txtShinseishaJusho
     */
    @JsonProperty("txtShinseishaJusho")
    public void setTxtShinseishaJusho(TextBoxJusho txtShinseishaJusho) {
        this.txtShinseishaJusho = txtShinseishaJusho;
    }

    // </editor-fold>
}
