package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE6080001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * ShinseiJoho のクラスファイル 
 * 
 * @author 自動生成
 */
public class ShinseiJohoDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtIryoKikanCode")
    private TextBoxCode txtIryoKikanCode;
    @JsonProperty("txtIryoKikanName")
    private TextBox txtIryoKikanName;
    @JsonProperty("txtShujiiCode")
    private TextBoxCode txtShujiiCode;
    @JsonProperty("txtShujiiName")
    private TextBox txtShujiiName;
    @JsonProperty("dgShinsakaiIin")
    private DataGrid<dgShinsakaiIin_Row> dgShinsakaiIin;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtIryoKikanCode
     * @return txtIryoKikanCode
     */
    @JsonProperty("txtIryoKikanCode")
    public TextBoxCode getTxtIryoKikanCode() {
        return txtIryoKikanCode;
    }

    /*
     * settxtIryoKikanCode
     * @param txtIryoKikanCode txtIryoKikanCode
     */
    @JsonProperty("txtIryoKikanCode")
    public void setTxtIryoKikanCode(TextBoxCode txtIryoKikanCode) {
        this.txtIryoKikanCode = txtIryoKikanCode;
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
     * gettxtShujiiCode
     * @return txtShujiiCode
     */
    @JsonProperty("txtShujiiCode")
    public TextBoxCode getTxtShujiiCode() {
        return txtShujiiCode;
    }

    /*
     * settxtShujiiCode
     * @param txtShujiiCode txtShujiiCode
     */
    @JsonProperty("txtShujiiCode")
    public void setTxtShujiiCode(TextBoxCode txtShujiiCode) {
        this.txtShujiiCode = txtShujiiCode;
    }

    /*
     * gettxtShujiiName
     * @return txtShujiiName
     */
    @JsonProperty("txtShujiiName")
    public TextBox getTxtShujiiName() {
        return txtShujiiName;
    }

    /*
     * settxtShujiiName
     * @param txtShujiiName txtShujiiName
     */
    @JsonProperty("txtShujiiName")
    public void setTxtShujiiName(TextBox txtShujiiName) {
        this.txtShujiiName = txtShujiiName;
    }

    /*
     * getdgShinsakaiIin
     * @return dgShinsakaiIin
     */
    @JsonProperty("dgShinsakaiIin")
    public DataGrid<dgShinsakaiIin_Row> getDgShinsakaiIin() {
        return dgShinsakaiIin;
    }

    /*
     * setdgShinsakaiIin
     * @param dgShinsakaiIin dgShinsakaiIin
     */
    @JsonProperty("dgShinsakaiIin")
    public void setDgShinsakaiIin(DataGrid<dgShinsakaiIin_Row> dgShinsakaiIin) {
        this.dgShinsakaiIin = dgShinsakaiIin;
    }

    // </editor-fold>
}
