package jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB0130002;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGrid;
import jp.co.ndensan.reams.uz.uza.ui.binding.Label;
import jp.co.ndensan.reams.uz.uza.ui.binding.PanelBatchParameter;
import jp.co.ndensan.reams.uz.uza.ui.binding.Space;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxNum;

/**
 * HeijunkaKakuteiBatchParameter のクラスファイル
 *
 * @reamsid_L DBB-0830-010 wangkanglei
 */
public class HeijunkaKakuteiBatchParameterDiv extends PanelBatchParameter {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("lblHeijunkaMsg1")
    private Label lblHeijunkaMsg1;
    @JsonProperty("HeijunkaKakuteiShoriNaiyo")
    private HeijunkaKakuteiShoriNaiyoDiv HeijunkaKakuteiShoriNaiyo;
    @JsonProperty("HeijunkaSagakuKakunin")
    private HeijunkaSagakuKakuninDiv HeijunkaSagakuKakunin;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getlblHeijunkaMsg1
     * @return lblHeijunkaMsg1
     */
    @JsonProperty("lblHeijunkaMsg1")
    public Label getLblHeijunkaMsg1() {
        return lblHeijunkaMsg1;
    }

    /*
     * setlblHeijunkaMsg1
     * @param lblHeijunkaMsg1 lblHeijunkaMsg1
     */
    @JsonProperty("lblHeijunkaMsg1")
    public void setLblHeijunkaMsg1(Label lblHeijunkaMsg1) {
        this.lblHeijunkaMsg1 = lblHeijunkaMsg1;
    }

    /*
     * getHeijunkaKakuteiShoriNaiyo
     * @return HeijunkaKakuteiShoriNaiyo
     */
    @JsonProperty("HeijunkaKakuteiShoriNaiyo")
    public HeijunkaKakuteiShoriNaiyoDiv getHeijunkaKakuteiShoriNaiyo() {
        return HeijunkaKakuteiShoriNaiyo;
    }

    /*
     * setHeijunkaKakuteiShoriNaiyo
     * @param HeijunkaKakuteiShoriNaiyo HeijunkaKakuteiShoriNaiyo
     */
    @JsonProperty("HeijunkaKakuteiShoriNaiyo")
    public void setHeijunkaKakuteiShoriNaiyo(HeijunkaKakuteiShoriNaiyoDiv HeijunkaKakuteiShoriNaiyo) {
        this.HeijunkaKakuteiShoriNaiyo = HeijunkaKakuteiShoriNaiyo;
    }

    /*
     * getHeijunkaSagakuKakunin
     * @return HeijunkaSagakuKakunin
     */
    @JsonProperty("HeijunkaSagakuKakunin")
    public HeijunkaSagakuKakuninDiv getHeijunkaSagakuKakunin() {
        return HeijunkaSagakuKakunin;
    }

    /*
     * setHeijunkaSagakuKakunin
     * @param HeijunkaSagakuKakunin HeijunkaSagakuKakunin
     */
    @JsonProperty("HeijunkaSagakuKakunin")
    public void setHeijunkaSagakuKakunin(HeijunkaSagakuKakuninDiv HeijunkaSagakuKakunin) {
        this.HeijunkaSagakuKakunin = HeijunkaSagakuKakunin;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public Label getLblHeijunkaMsg2() {
        return this.getHeijunkaSagakuKakunin().getLblHeijunkaMsg2();
    }

    @JsonIgnore
    public void setLblHeijunkaMsg2(Label lblHeijunkaMsg2) {
        this.getHeijunkaSagakuKakunin().setLblHeijunkaMsg2(lblHeijunkaMsg2);
    }

    @JsonIgnore
    public Label getLblHeijunkaMsg3() {
        return this.getHeijunkaSagakuKakunin().getLblHeijunkaMsg3();
    }

    @JsonIgnore
    public void setLblHeijunkaMsg3(Label lblHeijunkaMsg3) {
        this.getHeijunkaSagakuKakunin().setLblHeijunkaMsg3(lblHeijunkaMsg3);
    }

    @JsonIgnore
    public Label getLblHeijunkaMsg4() {
        return this.getHeijunkaSagakuKakunin().getLblHeijunkaMsg4();
    }

    @JsonIgnore
    public void setLblHeijunkaMsg4(Label lblHeijunkaMsg4) {
        this.getHeijunkaSagakuKakunin().setLblHeijunkaMsg4(lblHeijunkaMsg4);
    }

    @JsonIgnore
    public Label getLblHeijunkaMsg5() {
        return this.getHeijunkaSagakuKakunin().getLblHeijunkaMsg5();
    }

    @JsonIgnore
    public void setLblHeijunkaMsg5(Label lblHeijunkaMsg5) {
        this.getHeijunkaSagakuKakunin().setLblHeijunkaMsg5(lblHeijunkaMsg5);
    }

    @JsonIgnore
    public Space getSpaHeijunka1() {
        return this.getHeijunkaSagakuKakunin().getSpaHeijunka1();
    }

    @JsonIgnore
    public void setSpaHeijunka1(Space spaHeijunka1) {
        this.getHeijunkaSagakuKakunin().setSpaHeijunka1(spaHeijunka1);
    }

    @JsonIgnore
    public TextBoxNum getTxtSagaku() {
        return this.getHeijunkaSagakuKakunin().getTxtSagaku();
    }

    @JsonIgnore
    public void setTxtSagaku(TextBoxNum txtSagaku) {
        this.getHeijunkaSagakuKakunin().setTxtSagaku(txtSagaku);
    }

    @JsonIgnore
    public Button getBtnSagakuSettei() {
        return this.getHeijunkaSagakuKakunin().getBtnSagakuSettei();
    }

    @JsonIgnore
    public void setBtnSagakuSettei(Button btnSagakuSettei) {
        this.getHeijunkaSagakuKakunin().setBtnSagakuSettei(btnSagakuSettei);
    }

    @JsonIgnore
    public Button getBtnTaishoGaiKensuSanshutsu() {
        return this.getHeijunkaSagakuKakunin().getBtnTaishoGaiKensuSanshutsu();
    }

    @JsonIgnore
    public void setBtnTaishoGaiKensuSanshutsu(Button btnTaishoGaiKensuSanshutsu) {
        this.getHeijunkaSagakuKakunin().setBtnTaishoGaiKensuSanshutsu(btnTaishoGaiKensuSanshutsu);
    }

    @JsonIgnore
    public DataGrid<dgHeijunkaKakutei_Row> getDgHeijunkaKakutei() {
        return this.getHeijunkaSagakuKakunin().getDgHeijunkaKakutei();
    }

    @JsonIgnore
    public void setDgHeijunkaKakutei(DataGrid<dgHeijunkaKakutei_Row> dgHeijunkaKakutei) {
        this.getHeijunkaSagakuKakunin().setDgHeijunkaKakutei(dgHeijunkaKakutei);
    }

    // </editor-fold>
}
