package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.NinteiShinsakaiIinGuide.NinteiShinsakaiIinGuide;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.hokenshalist.HokenshaList.HokenshaListDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.hokenshalist.HokenshaList.IHokenshaListDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * pnlShosaiJoken のクラスファイル 
 * 
 * @author 自動生成
 */
public class pnlShosaiJokenDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2017-02-28_12-26-08">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ccdHokensha")
    private HokenshaListDiv ccdHokensha;
    @JsonProperty("txtChosaItakusakiCode")
    private TextBox txtChosaItakusakiCode;
    @JsonProperty("btnChosaItakusaki")
    private ButtonDialog btnChosaItakusaki;
    @JsonProperty("txtChosaItakusakiName")
    private TextBox txtChosaItakusakiName;
    @JsonProperty("txtIryoKikanCode")
    private TextBox txtIryoKikanCode;
    @JsonProperty("btnIryoKikan")
    private ButtonDialog btnIryoKikan;
    @JsonProperty("txtIryoKikanName")
    private TextBox txtIryoKikanName;
    @JsonProperty("txtSonotaJigyoshaCode")
    private TextBox txtSonotaJigyoshaCode;
    @JsonProperty("btnSonotaJigyosha")
    private ButtonDialog btnSonotaJigyosha;
    @JsonProperty("txtSonotaJigyoshaName")
    private TextBox txtSonotaJigyoshaName;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getccdHokensha
     * @return ccdHokensha
     */
    @JsonProperty("ccdHokensha")
    public IHokenshaListDiv getCcdHokensha() {
        return ccdHokensha;
    }

    /*
     * gettxtChosaItakusakiCode
     * @return txtChosaItakusakiCode
     */
    @JsonProperty("txtChosaItakusakiCode")
    public TextBox getTxtChosaItakusakiCode() {
        return txtChosaItakusakiCode;
    }

    /*
     * settxtChosaItakusakiCode
     * @param txtChosaItakusakiCode txtChosaItakusakiCode
     */
    @JsonProperty("txtChosaItakusakiCode")
    public void setTxtChosaItakusakiCode(TextBox txtChosaItakusakiCode) {
        this.txtChosaItakusakiCode = txtChosaItakusakiCode;
    }

    /*
     * getbtnChosaItakusaki
     * @return btnChosaItakusaki
     */
    @JsonProperty("btnChosaItakusaki")
    public ButtonDialog getBtnChosaItakusaki() {
        return btnChosaItakusaki;
    }

    /*
     * setbtnChosaItakusaki
     * @param btnChosaItakusaki btnChosaItakusaki
     */
    @JsonProperty("btnChosaItakusaki")
    public void setBtnChosaItakusaki(ButtonDialog btnChosaItakusaki) {
        this.btnChosaItakusaki = btnChosaItakusaki;
    }

    /*
     * gettxtChosaItakusakiName
     * @return txtChosaItakusakiName
     */
    @JsonProperty("txtChosaItakusakiName")
    public TextBox getTxtChosaItakusakiName() {
        return txtChosaItakusakiName;
    }

    /*
     * settxtChosaItakusakiName
     * @param txtChosaItakusakiName txtChosaItakusakiName
     */
    @JsonProperty("txtChosaItakusakiName")
    public void setTxtChosaItakusakiName(TextBox txtChosaItakusakiName) {
        this.txtChosaItakusakiName = txtChosaItakusakiName;
    }

    /*
     * gettxtIryoKikanCode
     * @return txtIryoKikanCode
     */
    @JsonProperty("txtIryoKikanCode")
    public TextBox getTxtIryoKikanCode() {
        return txtIryoKikanCode;
    }

    /*
     * settxtIryoKikanCode
     * @param txtIryoKikanCode txtIryoKikanCode
     */
    @JsonProperty("txtIryoKikanCode")
    public void setTxtIryoKikanCode(TextBox txtIryoKikanCode) {
        this.txtIryoKikanCode = txtIryoKikanCode;
    }

    /*
     * getbtnIryoKikan
     * @return btnIryoKikan
     */
    @JsonProperty("btnIryoKikan")
    public ButtonDialog getBtnIryoKikan() {
        return btnIryoKikan;
    }

    /*
     * setbtnIryoKikan
     * @param btnIryoKikan btnIryoKikan
     */
    @JsonProperty("btnIryoKikan")
    public void setBtnIryoKikan(ButtonDialog btnIryoKikan) {
        this.btnIryoKikan = btnIryoKikan;
    }

    /*
     * gettxtIryoKikanName
     * @return txtIryoKikanName
     */
    @JsonProperty("txtIryoKikanName")
    public TextBox getTxtIryoKikanName() {
        return txtIryoKikanName;
    }

    /*
     * settxtIryoKikanName
     * @param txtIryoKikanName txtIryoKikanName
     */
    @JsonProperty("txtIryoKikanName")
    public void setTxtIryoKikanName(TextBox txtIryoKikanName) {
        this.txtIryoKikanName = txtIryoKikanName;
    }

    /*
     * gettxtSonotaJigyoshaCode
     * @return txtSonotaJigyoshaCode
     */
    @JsonProperty("txtSonotaJigyoshaCode")
    public TextBox getTxtSonotaJigyoshaCode() {
        return txtSonotaJigyoshaCode;
    }

    /*
     * settxtSonotaJigyoshaCode
     * @param txtSonotaJigyoshaCode txtSonotaJigyoshaCode
     */
    @JsonProperty("txtSonotaJigyoshaCode")
    public void setTxtSonotaJigyoshaCode(TextBox txtSonotaJigyoshaCode) {
        this.txtSonotaJigyoshaCode = txtSonotaJigyoshaCode;
    }

    /*
     * getbtnSonotaJigyosha
     * @return btnSonotaJigyosha
     */
    @JsonProperty("btnSonotaJigyosha")
    public ButtonDialog getBtnSonotaJigyosha() {
        return btnSonotaJigyosha;
    }

    /*
     * setbtnSonotaJigyosha
     * @param btnSonotaJigyosha btnSonotaJigyosha
     */
    @JsonProperty("btnSonotaJigyosha")
    public void setBtnSonotaJigyosha(ButtonDialog btnSonotaJigyosha) {
        this.btnSonotaJigyosha = btnSonotaJigyosha;
    }

    /*
     * gettxtSonotaJigyoshaName
     * @return txtSonotaJigyoshaName
     */
    @JsonProperty("txtSonotaJigyoshaName")
    public TextBox getTxtSonotaJigyoshaName() {
        return txtSonotaJigyoshaName;
    }

    /*
     * settxtSonotaJigyoshaName
     * @param txtSonotaJigyoshaName txtSonotaJigyoshaName
     */
    @JsonProperty("txtSonotaJigyoshaName")
    public void setTxtSonotaJigyoshaName(TextBox txtSonotaJigyoshaName) {
        this.txtSonotaJigyoshaName = txtSonotaJigyoshaName;
    }

    // </editor-fold>
}
