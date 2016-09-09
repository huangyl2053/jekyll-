package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1100011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.DropDownList;
import jp.co.ndensan.reams.uz.uza.ui.binding.TabPanel;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBox;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDateRange;

/**
 * tabShinseiTorokuPanel2 のクラスファイル
 *
 * @reamsid_L DBC-2040-030 huzongcheng
 */
public class tabShinseiTorokuPanel2Div extends TabPanel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("KokuhoShikakuJohoPanel")
    private KokuhoShikakuJohoPanelDiv KokuhoShikakuJohoPanel;
    @JsonProperty("KokiShikakuJohoPanel")
    private KokiShikakuJohoPanelDiv KokiShikakuJohoPanel;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getKokuhoShikakuJohoPanel
     * @return KokuhoShikakuJohoPanel
     */
    @JsonProperty("KokuhoShikakuJohoPanel")
    public KokuhoShikakuJohoPanelDiv getKokuhoShikakuJohoPanel() {
        return KokuhoShikakuJohoPanel;
    }

    /*
     * setKokuhoShikakuJohoPanel
     * @param KokuhoShikakuJohoPanel KokuhoShikakuJohoPanel
     */
    @JsonProperty("KokuhoShikakuJohoPanel")
    public void setKokuhoShikakuJohoPanel(KokuhoShikakuJohoPanelDiv KokuhoShikakuJohoPanel) {
        this.KokuhoShikakuJohoPanel = KokuhoShikakuJohoPanel;
    }

    /*
     * getKokiShikakuJohoPanel
     * @return KokiShikakuJohoPanel
     */
    @JsonProperty("KokiShikakuJohoPanel")
    public KokiShikakuJohoPanelDiv getKokiShikakuJohoPanel() {
        return KokiShikakuJohoPanel;
    }

    /*
     * setKokiShikakuJohoPanel
     * @param KokiShikakuJohoPanel KokiShikakuJohoPanel
     */
    @JsonProperty("KokiShikakuJohoPanel")
    public void setKokiShikakuJohoPanel(KokiShikakuJohoPanelDiv KokiShikakuJohoPanel) {
        this.KokiShikakuJohoPanel = KokiShikakuJohoPanel;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public TextBox getTxtKokuhoShikakuHokensyaBango() {
        return this.getKokuhoShikakuJohoPanel().getTxtKokuhoShikakuHokensyaBango();
    }

    @JsonIgnore
    public void setTxtKokuhoShikakuHokensyaBango(TextBox txtKokuhoShikakuHokensyaBango) {
        this.getKokuhoShikakuJohoPanel().setTxtKokuhoShikakuHokensyaBango(txtKokuhoShikakuHokensyaBango);
    }

    @JsonIgnore
    public TextBox getTxtKokuhoShikakuHikonensyaSyoKigo() {
        return this.getKokuhoShikakuJohoPanel().getTxtKokuhoShikakuHikonensyaSyoKigo();
    }

    @JsonIgnore
    public void setTxtKokuhoShikakuHikonensyaSyoKigo(TextBox txtKokuhoShikakuHikonensyaSyoKigo) {
        this.getKokuhoShikakuJohoPanel().setTxtKokuhoShikakuHikonensyaSyoKigo(txtKokuhoShikakuHikonensyaSyoKigo);
    }

    @JsonIgnore
    public TextBox getTxtKokuhoShikakuHikonensyaSyoBango() {
        return this.getKokuhoShikakuJohoPanel().getTxtKokuhoShikakuHikonensyaSyoBango();
    }

    @JsonIgnore
    public void setTxtKokuhoShikakuHikonensyaSyoBango(TextBox txtKokuhoShikakuHikonensyaSyoBango) {
        this.getKokuhoShikakuJohoPanel().setTxtKokuhoShikakuHikonensyaSyoBango(txtKokuhoShikakuHikonensyaSyoBango);
    }

    @JsonIgnore
    public TextBox getTxtKokuhoShikaku1() {
        return this.getKokuhoShikakuJohoPanel().getTxtKokuhoShikaku1();
    }

    @JsonIgnore
    public void setTxtKokuhoShikaku1(TextBox txtKokuhoShikaku1) {
        this.getKokuhoShikakuJohoPanel().setTxtKokuhoShikaku1(txtKokuhoShikaku1);
    }

    @JsonIgnore
    public DropDownList getTxtKokuhoShikaku2() {
        return this.getKokuhoShikakuJohoPanel().getTxtKokuhoShikaku2();
    }

    @JsonIgnore
    public void setTxtKokuhoShikaku2(DropDownList txtKokuhoShikaku2) {
        this.getKokuhoShikakuJohoPanel().setTxtKokuhoShikaku2(txtKokuhoShikaku2);
    }

    @JsonIgnore
    public TextBox getTxtKokuhoShikaku3() {
        return this.getKokuhoShikakuJohoPanel().getTxtKokuhoShikaku3();
    }

    @JsonIgnore
    public void setTxtKokuhoShikaku3(TextBox txtKokuhoShikaku3) {
        this.getKokuhoShikakuJohoPanel().setTxtKokuhoShikaku3(txtKokuhoShikaku3);
    }

    @JsonIgnore
    public TextBoxDateRange getTxtKokuhoShikakuKanyuYMD() {
        return this.getKokuhoShikakuJohoPanel().getTxtKokuhoShikakuKanyuYMD();
    }

    @JsonIgnore
    public void setTxtKokuhoShikakuKanyuYMD(TextBoxDateRange txtKokuhoShikakuKanyuYMD) {
        this.getKokuhoShikakuJohoPanel().setTxtKokuhoShikakuKanyuYMD(txtKokuhoShikakuKanyuYMD);
    }

    @JsonIgnore
    public TextBox getTxtKokiShikaku() {
        return this.getKokiShikakuJohoPanel().getTxtKokiShikaku();
    }

    @JsonIgnore
    public void setTxtKokiShikaku(TextBox txtKokiShikaku) {
        this.getKokiShikakuJohoPanel().setTxtKokiShikaku(txtKokiShikaku);
    }

    @JsonIgnore
    public TextBox getTxtKokiShikaku2() {
        return this.getKokiShikakuJohoPanel().getTxtKokiShikaku2();
    }

    @JsonIgnore
    public void setTxtKokiShikaku2(TextBox txtKokiShikaku2) {
        this.getKokiShikakuJohoPanel().setTxtKokiShikaku2(txtKokiShikaku2);
    }

    @JsonIgnore
    public TextBox getTxtKokiShikaku3() {
        return this.getKokiShikakuJohoPanel().getTxtKokiShikaku3();
    }

    @JsonIgnore
    public void setTxtKokiShikaku3(TextBox txtKokiShikaku3) {
        this.getKokiShikakuJohoPanel().setTxtKokiShikaku3(txtKokiShikaku3);
    }

    @JsonIgnore
    public TextBoxDateRange getTxtKokiShikakuKanyuKikan() {
        return this.getKokiShikakuJohoPanel().getTxtKokiShikakuKanyuKikan();
    }

    @JsonIgnore
    public void setTxtKokiShikakuKanyuKikan(TextBoxDateRange txtKokiShikakuKanyuKikan) {
        this.getKokiShikakuJohoPanel().setTxtKokiShikakuKanyuKikan(txtKokiShikakuKanyuKikan);
    }

    // </editor-fold>
}
