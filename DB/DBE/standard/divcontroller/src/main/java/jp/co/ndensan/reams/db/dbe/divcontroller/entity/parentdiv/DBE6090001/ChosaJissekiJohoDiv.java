package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE6090001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * ChosaJissekiJoho のクラスファイル 
 * 
 * @author 自動生成
 */
public class ChosaJissekiJohoDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtItakusakiCode")
    private TextBoxCode txtItakusakiCode;
    @JsonProperty("txtItakusakiName")
    private TextBox txtItakusakiName;
    @JsonProperty("txtChousaInCode")
    private TextBoxCode txtChousaInCode;
    @JsonProperty("txtChousainName")
    private TextBox txtChousainName;
    @JsonProperty("dgShinsakaiIin")
    private DataGrid<dgShinsakaiIin_Row> dgShinsakaiIin;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtItakusakiCode
     * @return txtItakusakiCode
     */
    @JsonProperty("txtItakusakiCode")
    public TextBoxCode getTxtItakusakiCode() {
        return txtItakusakiCode;
    }

    /*
     * settxtItakusakiCode
     * @param txtItakusakiCode txtItakusakiCode
     */
    @JsonProperty("txtItakusakiCode")
    public void setTxtItakusakiCode(TextBoxCode txtItakusakiCode) {
        this.txtItakusakiCode = txtItakusakiCode;
    }

    /*
     * gettxtItakusakiName
     * @return txtItakusakiName
     */
    @JsonProperty("txtItakusakiName")
    public TextBox getTxtItakusakiName() {
        return txtItakusakiName;
    }

    /*
     * settxtItakusakiName
     * @param txtItakusakiName txtItakusakiName
     */
    @JsonProperty("txtItakusakiName")
    public void setTxtItakusakiName(TextBox txtItakusakiName) {
        this.txtItakusakiName = txtItakusakiName;
    }

    /*
     * gettxtChousaInCode
     * @return txtChousaInCode
     */
    @JsonProperty("txtChousaInCode")
    public TextBoxCode getTxtChousaInCode() {
        return txtChousaInCode;
    }

    /*
     * settxtChousaInCode
     * @param txtChousaInCode txtChousaInCode
     */
    @JsonProperty("txtChousaInCode")
    public void setTxtChousaInCode(TextBoxCode txtChousaInCode) {
        this.txtChousaInCode = txtChousaInCode;
    }

    /*
     * gettxtChousainName
     * @return txtChousainName
     */
    @JsonProperty("txtChousainName")
    public TextBox getTxtChousainName() {
        return txtChousainName;
    }

    /*
     * settxtChousainName
     * @param txtChousainName txtChousainName
     */
    @JsonProperty("txtChousainName")
    public void setTxtChousainName(TextBox txtChousainName) {
        this.txtChousainName = txtChousainName;
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
