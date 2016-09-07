package jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB0130002;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGrid;
import jp.co.ndensan.reams.uz.uza.ui.binding.Label;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.Space;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxNum;

/**
 * HeijunkaSagakuKakunin のクラスファイル
 *
 * @reamsid_L DBB-0830-010 wangkanglei
 */
public class HeijunkaSagakuKakuninDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("lblHeijunkaMsg2")
    private Label lblHeijunkaMsg2;
    @JsonProperty("lblHeijunkaMsg3")
    private Label lblHeijunkaMsg3;
    @JsonProperty("lblHeijunkaMsg4")
    private Label lblHeijunkaMsg4;
    @JsonProperty("lblHeijunkaMsg5")
    private Label lblHeijunkaMsg5;
    @JsonProperty("spaHeijunka1")
    private Space spaHeijunka1;
    @JsonProperty("txtSagaku")
    private TextBoxNum txtSagaku;
    @JsonProperty("btnSagakuSettei")
    private Button btnSagakuSettei;
    @JsonProperty("btnTaishoGaiKensuSanshutsu")
    private Button btnTaishoGaiKensuSanshutsu;
    @JsonProperty("dgHeijunkaKakutei")
    private DataGrid<dgHeijunkaKakutei_Row> dgHeijunkaKakutei;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getlblHeijunkaMsg2
     * @return lblHeijunkaMsg2
     */
    @JsonProperty("lblHeijunkaMsg2")
    public Label getLblHeijunkaMsg2() {
        return lblHeijunkaMsg2;
    }

    /*
     * setlblHeijunkaMsg2
     * @param lblHeijunkaMsg2 lblHeijunkaMsg2
     */
    @JsonProperty("lblHeijunkaMsg2")
    public void setLblHeijunkaMsg2(Label lblHeijunkaMsg2) {
        this.lblHeijunkaMsg2 = lblHeijunkaMsg2;
    }

    /*
     * getlblHeijunkaMsg3
     * @return lblHeijunkaMsg3
     */
    @JsonProperty("lblHeijunkaMsg3")
    public Label getLblHeijunkaMsg3() {
        return lblHeijunkaMsg3;
    }

    /*
     * setlblHeijunkaMsg3
     * @param lblHeijunkaMsg3 lblHeijunkaMsg3
     */
    @JsonProperty("lblHeijunkaMsg3")
    public void setLblHeijunkaMsg3(Label lblHeijunkaMsg3) {
        this.lblHeijunkaMsg3 = lblHeijunkaMsg3;
    }

    /*
     * getlblHeijunkaMsg4
     * @return lblHeijunkaMsg4
     */
    @JsonProperty("lblHeijunkaMsg4")
    public Label getLblHeijunkaMsg4() {
        return lblHeijunkaMsg4;
    }

    /*
     * setlblHeijunkaMsg4
     * @param lblHeijunkaMsg4 lblHeijunkaMsg4
     */
    @JsonProperty("lblHeijunkaMsg4")
    public void setLblHeijunkaMsg4(Label lblHeijunkaMsg4) {
        this.lblHeijunkaMsg4 = lblHeijunkaMsg4;
    }

    /*
     * getlblHeijunkaMsg5
     * @return lblHeijunkaMsg5
     */
    @JsonProperty("lblHeijunkaMsg5")
    public Label getLblHeijunkaMsg5() {
        return lblHeijunkaMsg5;
    }

    /*
     * setlblHeijunkaMsg5
     * @param lblHeijunkaMsg5 lblHeijunkaMsg5
     */
    @JsonProperty("lblHeijunkaMsg5")
    public void setLblHeijunkaMsg5(Label lblHeijunkaMsg5) {
        this.lblHeijunkaMsg5 = lblHeijunkaMsg5;
    }

    /*
     * getspaHeijunka1
     * @return spaHeijunka1
     */
    @JsonProperty("spaHeijunka1")
    public Space getSpaHeijunka1() {
        return spaHeijunka1;
    }

    /*
     * setspaHeijunka1
     * @param spaHeijunka1 spaHeijunka1
     */
    @JsonProperty("spaHeijunka1")
    public void setSpaHeijunka1(Space spaHeijunka1) {
        this.spaHeijunka1 = spaHeijunka1;
    }

    /*
     * gettxtSagaku
     * @return txtSagaku
     */
    @JsonProperty("txtSagaku")
    public TextBoxNum getTxtSagaku() {
        return txtSagaku;
    }

    /*
     * settxtSagaku
     * @param txtSagaku txtSagaku
     */
    @JsonProperty("txtSagaku")
    public void setTxtSagaku(TextBoxNum txtSagaku) {
        this.txtSagaku = txtSagaku;
    }

    /*
     * getbtnSagakuSettei
     * @return btnSagakuSettei
     */
    @JsonProperty("btnSagakuSettei")
    public Button getBtnSagakuSettei() {
        return btnSagakuSettei;
    }

    /*
     * setbtnSagakuSettei
     * @param btnSagakuSettei btnSagakuSettei
     */
    @JsonProperty("btnSagakuSettei")
    public void setBtnSagakuSettei(Button btnSagakuSettei) {
        this.btnSagakuSettei = btnSagakuSettei;
    }

    /*
     * getbtnTaishoGaiKensuSanshutsu
     * @return btnTaishoGaiKensuSanshutsu
     */
    @JsonProperty("btnTaishoGaiKensuSanshutsu")
    public Button getBtnTaishoGaiKensuSanshutsu() {
        return btnTaishoGaiKensuSanshutsu;
    }

    /*
     * setbtnTaishoGaiKensuSanshutsu
     * @param btnTaishoGaiKensuSanshutsu btnTaishoGaiKensuSanshutsu
     */
    @JsonProperty("btnTaishoGaiKensuSanshutsu")
    public void setBtnTaishoGaiKensuSanshutsu(Button btnTaishoGaiKensuSanshutsu) {
        this.btnTaishoGaiKensuSanshutsu = btnTaishoGaiKensuSanshutsu;
    }

    /*
     * getdgHeijunkaKakutei
     * @return dgHeijunkaKakutei
     */
    @JsonProperty("dgHeijunkaKakutei")
    public DataGrid<dgHeijunkaKakutei_Row> getDgHeijunkaKakutei() {
        return dgHeijunkaKakutei;
    }

    /*
     * setdgHeijunkaKakutei
     * @param dgHeijunkaKakutei dgHeijunkaKakutei
     */
    @JsonProperty("dgHeijunkaKakutei")
    public void setDgHeijunkaKakutei(DataGrid<dgHeijunkaKakutei_Row> dgHeijunkaKakutei) {
        this.dgHeijunkaKakutei = dgHeijunkaKakutei;
    }

    // </editor-fold>
}
