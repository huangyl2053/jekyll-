package jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0800011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * HokenshaJoho のクラスファイル 
 * 
 * @author 自動生成
 */
public class HokenshaJohoDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtHokenshaNo")
    private TextBoxCode txtHokenshaNo;
    @JsonProperty("txtHokenshaName")
    private TextBox txtHokenshaName;
    @JsonProperty("imgYubinNo")
    private StaticImage imgYubinNo;
    @JsonProperty("txtHokenshaYubinNo")
    private TextBoxYubinNo txtHokenshaYubinNo;
    @JsonProperty("txtHokenshaJusho")
    private TextBoxJusho txtHokenshaJusho;
    @JsonProperty("txtHokenshaTelNo")
    private TextBoxTelNo txtHokenshaTelNo;
    @JsonProperty("btnKakutei")
    private Button btnKakutei;
    @JsonProperty("btnTorikeshi")
    private Button btnTorikeshi;
    @JsonProperty("hdnJotai")
    private RString hdnJotai;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtHokenshaNo
     * @return txtHokenshaNo
     */
    @JsonProperty("txtHokenshaNo")
    public TextBoxCode getTxtHokenshaNo() {
        return txtHokenshaNo;
    }

    /*
     * settxtHokenshaNo
     * @param txtHokenshaNo txtHokenshaNo
     */
    @JsonProperty("txtHokenshaNo")
    public void setTxtHokenshaNo(TextBoxCode txtHokenshaNo) {
        this.txtHokenshaNo = txtHokenshaNo;
    }

    /*
     * gettxtHokenshaName
     * @return txtHokenshaName
     */
    @JsonProperty("txtHokenshaName")
    public TextBox getTxtHokenshaName() {
        return txtHokenshaName;
    }

    /*
     * settxtHokenshaName
     * @param txtHokenshaName txtHokenshaName
     */
    @JsonProperty("txtHokenshaName")
    public void setTxtHokenshaName(TextBox txtHokenshaName) {
        this.txtHokenshaName = txtHokenshaName;
    }

    /*
     * getimgYubinNo
     * @return imgYubinNo
     */
    @JsonProperty("imgYubinNo")
    public StaticImage getImgYubinNo() {
        return imgYubinNo;
    }

    /*
     * setimgYubinNo
     * @param imgYubinNo imgYubinNo
     */
    @JsonProperty("imgYubinNo")
    public void setImgYubinNo(StaticImage imgYubinNo) {
        this.imgYubinNo = imgYubinNo;
    }

    /*
     * gettxtHokenshaYubinNo
     * @return txtHokenshaYubinNo
     */
    @JsonProperty("txtHokenshaYubinNo")
    public TextBoxYubinNo getTxtHokenshaYubinNo() {
        return txtHokenshaYubinNo;
    }

    /*
     * settxtHokenshaYubinNo
     * @param txtHokenshaYubinNo txtHokenshaYubinNo
     */
    @JsonProperty("txtHokenshaYubinNo")
    public void setTxtHokenshaYubinNo(TextBoxYubinNo txtHokenshaYubinNo) {
        this.txtHokenshaYubinNo = txtHokenshaYubinNo;
    }

    /*
     * gettxtHokenshaJusho
     * @return txtHokenshaJusho
     */
    @JsonProperty("txtHokenshaJusho")
    public TextBoxJusho getTxtHokenshaJusho() {
        return txtHokenshaJusho;
    }

    /*
     * settxtHokenshaJusho
     * @param txtHokenshaJusho txtHokenshaJusho
     */
    @JsonProperty("txtHokenshaJusho")
    public void setTxtHokenshaJusho(TextBoxJusho txtHokenshaJusho) {
        this.txtHokenshaJusho = txtHokenshaJusho;
    }

    /*
     * gettxtHokenshaTelNo
     * @return txtHokenshaTelNo
     */
    @JsonProperty("txtHokenshaTelNo")
    public TextBoxTelNo getTxtHokenshaTelNo() {
        return txtHokenshaTelNo;
    }

    /*
     * settxtHokenshaTelNo
     * @param txtHokenshaTelNo txtHokenshaTelNo
     */
    @JsonProperty("txtHokenshaTelNo")
    public void setTxtHokenshaTelNo(TextBoxTelNo txtHokenshaTelNo) {
        this.txtHokenshaTelNo = txtHokenshaTelNo;
    }

    /*
     * getbtnKakutei
     * @return btnKakutei
     */
    @JsonProperty("btnKakutei")
    public Button getBtnKakutei() {
        return btnKakutei;
    }

    /*
     * setbtnKakutei
     * @param btnKakutei btnKakutei
     */
    @JsonProperty("btnKakutei")
    public void setBtnKakutei(Button btnKakutei) {
        this.btnKakutei = btnKakutei;
    }

    /*
     * getbtnTorikeshi
     * @return btnTorikeshi
     */
    @JsonProperty("btnTorikeshi")
    public Button getBtnTorikeshi() {
        return btnTorikeshi;
    }

    /*
     * setbtnTorikeshi
     * @param btnTorikeshi btnTorikeshi
     */
    @JsonProperty("btnTorikeshi")
    public void setBtnTorikeshi(Button btnTorikeshi) {
        this.btnTorikeshi = btnTorikeshi;
    }

    /*
     * gethdnJotai
     * @return hdnJotai
     */
    @JsonProperty("hdnJotai")
    public RString getHdnJotai() {
        return hdnJotai;
    }

    /*
     * sethdnJotai
     * @param hdnJotai hdnJotai
     */
    @JsonProperty("hdnJotai")
    public void setHdnJotai(RString hdnJotai) {
        this.hdnJotai = hdnJotai;
    }

    // </editor-fold>
}
