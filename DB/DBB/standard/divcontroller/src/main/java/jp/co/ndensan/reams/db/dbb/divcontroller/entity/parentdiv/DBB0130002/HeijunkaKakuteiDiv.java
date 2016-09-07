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
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.Space;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxNum;

/**
 * HeijunkaKakutei のクラスファイル
 *
 * @reamsid_L DBB-0830-010 wangkanglei
 */
public class HeijunkaKakuteiDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("HeijunkaKakuteiBatchParameter")
    private HeijunkaKakuteiBatchParameterDiv HeijunkaKakuteiBatchParameter;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getHeijunkaKakuteiBatchParameter
     * @return HeijunkaKakuteiBatchParameter
     */
    @JsonProperty("HeijunkaKakuteiBatchParameter")
    public HeijunkaKakuteiBatchParameterDiv getHeijunkaKakuteiBatchParameter() {
        return HeijunkaKakuteiBatchParameter;
    }

    /*
     * setHeijunkaKakuteiBatchParameter
     * @param HeijunkaKakuteiBatchParameter HeijunkaKakuteiBatchParameter
     */
    @JsonProperty("HeijunkaKakuteiBatchParameter")
    public void setHeijunkaKakuteiBatchParameter(HeijunkaKakuteiBatchParameterDiv HeijunkaKakuteiBatchParameter) {
        this.HeijunkaKakuteiBatchParameter = HeijunkaKakuteiBatchParameter;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public Label getLblHeijunkaMsg1() {
        return this.getHeijunkaKakuteiBatchParameter().getLblHeijunkaMsg1();
    }

    @JsonIgnore
    public void setLblHeijunkaMsg1(Label lblHeijunkaMsg1) {
        this.getHeijunkaKakuteiBatchParameter().setLblHeijunkaMsg1(lblHeijunkaMsg1);
    }

    @JsonIgnore
    public HeijunkaKakuteiShoriNaiyoDiv getHeijunkaKakuteiShoriNaiyo() {
        return this.getHeijunkaKakuteiBatchParameter().getHeijunkaKakuteiShoriNaiyo();
    }

    @JsonIgnore
    public void setHeijunkaKakuteiShoriNaiyo(HeijunkaKakuteiShoriNaiyoDiv HeijunkaKakuteiShoriNaiyo) {
        this.getHeijunkaKakuteiBatchParameter().setHeijunkaKakuteiShoriNaiyo(HeijunkaKakuteiShoriNaiyo);
    }

    @JsonIgnore
    public HeijunkaSagakuKakuninDiv getHeijunkaSagakuKakunin() {
        return this.getHeijunkaKakuteiBatchParameter().getHeijunkaSagakuKakunin();
    }

    @JsonIgnore
    public void setHeijunkaSagakuKakunin(HeijunkaSagakuKakuninDiv HeijunkaSagakuKakunin) {
        this.getHeijunkaKakuteiBatchParameter().setHeijunkaSagakuKakunin(HeijunkaSagakuKakunin);
    }

    @JsonIgnore
    public Label getLblHeijunkaMsg2() {
        return this.getHeijunkaKakuteiBatchParameter().getHeijunkaSagakuKakunin().getLblHeijunkaMsg2();
    }

    @JsonIgnore
    public void setLblHeijunkaMsg2(Label lblHeijunkaMsg2) {
        this.getHeijunkaKakuteiBatchParameter().getHeijunkaSagakuKakunin().setLblHeijunkaMsg2(lblHeijunkaMsg2);
    }

    @JsonIgnore
    public Label getLblHeijunkaMsg3() {
        return this.getHeijunkaKakuteiBatchParameter().getHeijunkaSagakuKakunin().getLblHeijunkaMsg3();
    }

    @JsonIgnore
    public void setLblHeijunkaMsg3(Label lblHeijunkaMsg3) {
        this.getHeijunkaKakuteiBatchParameter().getHeijunkaSagakuKakunin().setLblHeijunkaMsg3(lblHeijunkaMsg3);
    }

    @JsonIgnore
    public Label getLblHeijunkaMsg4() {
        return this.getHeijunkaKakuteiBatchParameter().getHeijunkaSagakuKakunin().getLblHeijunkaMsg4();
    }

    @JsonIgnore
    public void setLblHeijunkaMsg4(Label lblHeijunkaMsg4) {
        this.getHeijunkaKakuteiBatchParameter().getHeijunkaSagakuKakunin().setLblHeijunkaMsg4(lblHeijunkaMsg4);
    }

    @JsonIgnore
    public Label getLblHeijunkaMsg5() {
        return this.getHeijunkaKakuteiBatchParameter().getHeijunkaSagakuKakunin().getLblHeijunkaMsg5();
    }

    @JsonIgnore
    public void setLblHeijunkaMsg5(Label lblHeijunkaMsg5) {
        this.getHeijunkaKakuteiBatchParameter().getHeijunkaSagakuKakunin().setLblHeijunkaMsg5(lblHeijunkaMsg5);
    }

    @JsonIgnore
    public Space getSpaHeijunka1() {
        return this.getHeijunkaKakuteiBatchParameter().getHeijunkaSagakuKakunin().getSpaHeijunka1();
    }

    @JsonIgnore
    public void setSpaHeijunka1(Space spaHeijunka1) {
        this.getHeijunkaKakuteiBatchParameter().getHeijunkaSagakuKakunin().setSpaHeijunka1(spaHeijunka1);
    }

    @JsonIgnore
    public TextBoxNum getTxtSagaku() {
        return this.getHeijunkaKakuteiBatchParameter().getHeijunkaSagakuKakunin().getTxtSagaku();
    }

    @JsonIgnore
    public void setTxtSagaku(TextBoxNum txtSagaku) {
        this.getHeijunkaKakuteiBatchParameter().getHeijunkaSagakuKakunin().setTxtSagaku(txtSagaku);
    }

    @JsonIgnore
    public Button getBtnSagakuSettei() {
        return this.getHeijunkaKakuteiBatchParameter().getHeijunkaSagakuKakunin().getBtnSagakuSettei();
    }

    @JsonIgnore
    public void setBtnSagakuSettei(Button btnSagakuSettei) {
        this.getHeijunkaKakuteiBatchParameter().getHeijunkaSagakuKakunin().setBtnSagakuSettei(btnSagakuSettei);
    }

    @JsonIgnore
    public Button getBtnTaishoGaiKensuSanshutsu() {
        return this.getHeijunkaKakuteiBatchParameter().getHeijunkaSagakuKakunin().getBtnTaishoGaiKensuSanshutsu();
    }

    @JsonIgnore
    public void setBtnTaishoGaiKensuSanshutsu(Button btnTaishoGaiKensuSanshutsu) {
        this.getHeijunkaKakuteiBatchParameter().getHeijunkaSagakuKakunin().setBtnTaishoGaiKensuSanshutsu(btnTaishoGaiKensuSanshutsu);
    }

    @JsonIgnore
    public DataGrid<dgHeijunkaKakutei_Row> getDgHeijunkaKakutei() {
        return this.getHeijunkaKakuteiBatchParameter().getHeijunkaSagakuKakunin().getDgHeijunkaKakutei();
    }

    @JsonIgnore
    public void setDgHeijunkaKakutei(DataGrid<dgHeijunkaKakutei_Row> dgHeijunkaKakutei) {
        this.getHeijunkaKakuteiBatchParameter().getHeijunkaSagakuKakunin().setDgHeijunkaKakutei(dgHeijunkaKakutei);
    }

    // </editor-fold>
}
