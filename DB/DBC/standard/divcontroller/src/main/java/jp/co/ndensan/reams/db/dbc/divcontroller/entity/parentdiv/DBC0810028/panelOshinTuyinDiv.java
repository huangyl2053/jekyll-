package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0810028;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * panelOshinTuyin のクラスファイル 
 * 
 * @author 自動生成
 */
public class panelOshinTuyinDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-01-15_09-59-03">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("lblOshin")
    private Label lblOshin;
    @JsonProperty("txtOshinNissu")
    private TextBoxNum txtOshinNissu;
    @JsonProperty("txtOshinIryoKikanName")
    private TextBox txtOshinIryoKikanName;
    @JsonProperty("lblTsuin")
    private Label lblTsuin;
    @JsonProperty("txtTsuyinNissu")
    private TextBoxNum txtTsuyinNissu;
    @JsonProperty("txtTsuinKikanName")
    private TextBox txtTsuinKikanName;
    @JsonProperty("txtTekiyou")
    private TextBoxMultiLine txtTekiyou;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getlblOshin
     * @return lblOshin
     */
    @JsonProperty("lblOshin")
    public Label getLblOshin() {
        return lblOshin;
    }

    /*
     * setlblOshin
     * @param lblOshin lblOshin
     */
    @JsonProperty("lblOshin")
    public void setLblOshin(Label lblOshin) {
        this.lblOshin = lblOshin;
    }

    /*
     * gettxtOshinNissu
     * @return txtOshinNissu
     */
    @JsonProperty("txtOshinNissu")
    public TextBoxNum getTxtOshinNissu() {
        return txtOshinNissu;
    }

    /*
     * settxtOshinNissu
     * @param txtOshinNissu txtOshinNissu
     */
    @JsonProperty("txtOshinNissu")
    public void setTxtOshinNissu(TextBoxNum txtOshinNissu) {
        this.txtOshinNissu = txtOshinNissu;
    }

    /*
     * gettxtOshinIryoKikanName
     * @return txtOshinIryoKikanName
     */
    @JsonProperty("txtOshinIryoKikanName")
    public TextBox getTxtOshinIryoKikanName() {
        return txtOshinIryoKikanName;
    }

    /*
     * settxtOshinIryoKikanName
     * @param txtOshinIryoKikanName txtOshinIryoKikanName
     */
    @JsonProperty("txtOshinIryoKikanName")
    public void setTxtOshinIryoKikanName(TextBox txtOshinIryoKikanName) {
        this.txtOshinIryoKikanName = txtOshinIryoKikanName;
    }

    /*
     * getlblTsuin
     * @return lblTsuin
     */
    @JsonProperty("lblTsuin")
    public Label getLblTsuin() {
        return lblTsuin;
    }

    /*
     * setlblTsuin
     * @param lblTsuin lblTsuin
     */
    @JsonProperty("lblTsuin")
    public void setLblTsuin(Label lblTsuin) {
        this.lblTsuin = lblTsuin;
    }

    /*
     * gettxtTsuyinNissu
     * @return txtTsuyinNissu
     */
    @JsonProperty("txtTsuyinNissu")
    public TextBoxNum getTxtTsuyinNissu() {
        return txtTsuyinNissu;
    }

    /*
     * settxtTsuyinNissu
     * @param txtTsuyinNissu txtTsuyinNissu
     */
    @JsonProperty("txtTsuyinNissu")
    public void setTxtTsuyinNissu(TextBoxNum txtTsuyinNissu) {
        this.txtTsuyinNissu = txtTsuyinNissu;
    }

    /*
     * gettxtTsuinKikanName
     * @return txtTsuinKikanName
     */
    @JsonProperty("txtTsuinKikanName")
    public TextBox getTxtTsuinKikanName() {
        return txtTsuinKikanName;
    }

    /*
     * settxtTsuinKikanName
     * @param txtTsuinKikanName txtTsuinKikanName
     */
    @JsonProperty("txtTsuinKikanName")
    public void setTxtTsuinKikanName(TextBox txtTsuinKikanName) {
        this.txtTsuinKikanName = txtTsuinKikanName;
    }

    /*
     * gettxtTekiyou
     * @return txtTekiyou
     */
    @JsonProperty("txtTekiyou")
    public TextBoxMultiLine getTxtTekiyou() {
        return txtTekiyou;
    }

    /*
     * settxtTekiyou
     * @param txtTekiyou txtTekiyou
     */
    @JsonProperty("txtTekiyou")
    public void setTxtTekiyou(TextBoxMultiLine txtTekiyou) {
        this.txtTekiyou = txtTekiyou;
    }

    // </editor-fold>
}
