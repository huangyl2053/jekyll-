package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.JogaiShinsainJoho.JogaiShinsainJoho;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * ShinsakaiIinJoho のクラスファイル 
 * 
 * @author 自動生成
 */
public class ShinsakaiIinJohoDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-10-31_08-44-29">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtShinsakaiIinCode")
    private TextBox txtShinsakaiIinCode;
    @JsonProperty("btnShinsakaiIinGuide")
    private ButtonDialog btnShinsakaiIinGuide;
    @JsonProperty("txtShinsakaiIinName")
    private TextBox txtShinsakaiIinName;
    @JsonProperty("dgShozokuKikanIchiran")
    private DataGrid<dgShozokuKikanIchiran_Row> dgShozokuKikanIchiran;
    @JsonProperty("lblShozokuKikan")
    private Label lblShozokuKikan;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtShinsakaiIinCode
     * @return txtShinsakaiIinCode
     */
    @JsonProperty("txtShinsakaiIinCode")
    public TextBox getTxtShinsakaiIinCode() {
        return txtShinsakaiIinCode;
    }

    /*
     * settxtShinsakaiIinCode
     * @param txtShinsakaiIinCode txtShinsakaiIinCode
     */
    @JsonProperty("txtShinsakaiIinCode")
    public void setTxtShinsakaiIinCode(TextBox txtShinsakaiIinCode) {
        this.txtShinsakaiIinCode = txtShinsakaiIinCode;
    }

    /*
     * getbtnShinsakaiIinGuide
     * @return btnShinsakaiIinGuide
     */
    @JsonProperty("btnShinsakaiIinGuide")
    public ButtonDialog getBtnShinsakaiIinGuide() {
        return btnShinsakaiIinGuide;
    }

    /*
     * setbtnShinsakaiIinGuide
     * @param btnShinsakaiIinGuide btnShinsakaiIinGuide
     */
    @JsonProperty("btnShinsakaiIinGuide")
    public void setBtnShinsakaiIinGuide(ButtonDialog btnShinsakaiIinGuide) {
        this.btnShinsakaiIinGuide = btnShinsakaiIinGuide;
    }

    /*
     * gettxtShinsakaiIinName
     * @return txtShinsakaiIinName
     */
    @JsonProperty("txtShinsakaiIinName")
    public TextBox getTxtShinsakaiIinName() {
        return txtShinsakaiIinName;
    }

    /*
     * settxtShinsakaiIinName
     * @param txtShinsakaiIinName txtShinsakaiIinName
     */
    @JsonProperty("txtShinsakaiIinName")
    public void setTxtShinsakaiIinName(TextBox txtShinsakaiIinName) {
        this.txtShinsakaiIinName = txtShinsakaiIinName;
    }

    /*
     * getdgShozokuKikanIchiran
     * @return dgShozokuKikanIchiran
     */
    @JsonProperty("dgShozokuKikanIchiran")
    public DataGrid<dgShozokuKikanIchiran_Row> getDgShozokuKikanIchiran() {
        return dgShozokuKikanIchiran;
    }

    /*
     * setdgShozokuKikanIchiran
     * @param dgShozokuKikanIchiran dgShozokuKikanIchiran
     */
    @JsonProperty("dgShozokuKikanIchiran")
    public void setDgShozokuKikanIchiran(DataGrid<dgShozokuKikanIchiran_Row> dgShozokuKikanIchiran) {
        this.dgShozokuKikanIchiran = dgShozokuKikanIchiran;
    }

    /*
     * getlblShozokuKikan
     * @return lblShozokuKikan
     */
    @JsonProperty("lblShozokuKikan")
    public Label getLblShozokuKikan() {
        return lblShozokuKikan;
    }

    /*
     * setlblShozokuKikan
     * @param lblShozokuKikan lblShozokuKikan
     */
    @JsonProperty("lblShozokuKikan")
    public void setLblShozokuKikan(Label lblShozokuKikan) {
        this.lblShozokuKikan = lblShozokuKikan;
    }

    // </editor-fold>
}
