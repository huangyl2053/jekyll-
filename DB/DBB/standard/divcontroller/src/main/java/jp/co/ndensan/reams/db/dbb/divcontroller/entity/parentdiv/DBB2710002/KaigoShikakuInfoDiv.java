package jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB2710002;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * KaigoShikakuInfo のクラスファイル 
 * 
 * @author 自動生成
 */
public class KaigoShikakuInfoDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtHihokenshaNo")
    private TextBox txtHihokenshaNo;
    @JsonProperty("txtShutokuYMD")
    private TextBoxDate txtShutokuYMD;
    @JsonProperty("txtShutokuJiyu")
    private TextBox txtShutokuJiyu;
    @JsonProperty("txtSoshitsuYMD")
    private TextBoxDate txtSoshitsuYMD;
    @JsonProperty("txtSoshitsuJiyu")
    private TextBox txtSoshitsuJiyu;
    @JsonProperty("btnHihokenshaFinder")
    private ButtonDialog btnHihokenshaFinder;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtHihokenshaNo
     * @return txtHihokenshaNo
     */
    @JsonProperty("txtHihokenshaNo")
    public TextBox getTxtHihokenshaNo() {
        return txtHihokenshaNo;
    }

    /*
     * settxtHihokenshaNo
     * @param txtHihokenshaNo txtHihokenshaNo
     */
    @JsonProperty("txtHihokenshaNo")
    public void setTxtHihokenshaNo(TextBox txtHihokenshaNo) {
        this.txtHihokenshaNo = txtHihokenshaNo;
    }

    /*
     * gettxtShutokuYMD
     * @return txtShutokuYMD
     */
    @JsonProperty("txtShutokuYMD")
    public TextBoxDate getTxtShutokuYMD() {
        return txtShutokuYMD;
    }

    /*
     * settxtShutokuYMD
     * @param txtShutokuYMD txtShutokuYMD
     */
    @JsonProperty("txtShutokuYMD")
    public void setTxtShutokuYMD(TextBoxDate txtShutokuYMD) {
        this.txtShutokuYMD = txtShutokuYMD;
    }

    /*
     * gettxtShutokuJiyu
     * @return txtShutokuJiyu
     */
    @JsonProperty("txtShutokuJiyu")
    public TextBox getTxtShutokuJiyu() {
        return txtShutokuJiyu;
    }

    /*
     * settxtShutokuJiyu
     * @param txtShutokuJiyu txtShutokuJiyu
     */
    @JsonProperty("txtShutokuJiyu")
    public void setTxtShutokuJiyu(TextBox txtShutokuJiyu) {
        this.txtShutokuJiyu = txtShutokuJiyu;
    }

    /*
     * gettxtSoshitsuYMD
     * @return txtSoshitsuYMD
     */
    @JsonProperty("txtSoshitsuYMD")
    public TextBoxDate getTxtSoshitsuYMD() {
        return txtSoshitsuYMD;
    }

    /*
     * settxtSoshitsuYMD
     * @param txtSoshitsuYMD txtSoshitsuYMD
     */
    @JsonProperty("txtSoshitsuYMD")
    public void setTxtSoshitsuYMD(TextBoxDate txtSoshitsuYMD) {
        this.txtSoshitsuYMD = txtSoshitsuYMD;
    }

    /*
     * gettxtSoshitsuJiyu
     * @return txtSoshitsuJiyu
     */
    @JsonProperty("txtSoshitsuJiyu")
    public TextBox getTxtSoshitsuJiyu() {
        return txtSoshitsuJiyu;
    }

    /*
     * settxtSoshitsuJiyu
     * @param txtSoshitsuJiyu txtSoshitsuJiyu
     */
    @JsonProperty("txtSoshitsuJiyu")
    public void setTxtSoshitsuJiyu(TextBox txtSoshitsuJiyu) {
        this.txtSoshitsuJiyu = txtSoshitsuJiyu;
    }

    /*
     * getbtnHihokenshaFinder
     * @return btnHihokenshaFinder
     */
    @JsonProperty("btnHihokenshaFinder")
    public ButtonDialog getBtnHihokenshaFinder() {
        return btnHihokenshaFinder;
    }

    /*
     * setbtnHihokenshaFinder
     * @param btnHihokenshaFinder btnHihokenshaFinder
     */
    @JsonProperty("btnHihokenshaFinder")
    public void setBtnHihokenshaFinder(ButtonDialog btnHihokenshaFinder) {
        this.btnHihokenshaFinder = btnHihokenshaFinder;
    }

    // </editor-fold>
}
