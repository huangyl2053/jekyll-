package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0810032;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * KyufuShiharayiMeisaiJyuToku のクラスファイル 
 * 
 * @author 自動生成
 */
public class KyufuShiharayiMeisaiJyuTokuDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-01-15_09-59-03">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("panelOne")
    private panelOneDiv panelOne;
    @JsonProperty("panelTwo")
    private panelTwoDiv panelTwo;
    @JsonProperty("panelThree")
    private panelThreeDiv panelThree;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getpanelOne
     * @return panelOne
     */
    @JsonProperty("panelOne")
    public panelOneDiv getPanelOne() {
        return panelOne;
    }

    /*
     * setpanelOne
     * @param panelOne panelOne
     */
    @JsonProperty("panelOne")
    public void setPanelOne(panelOneDiv panelOne) {
        this.panelOne = panelOne;
    }

    /*
     * getpanelTwo
     * @return panelTwo
     */
    @JsonProperty("panelTwo")
    public panelTwoDiv getPanelTwo() {
        return panelTwo;
    }

    /*
     * setpanelTwo
     * @param panelTwo panelTwo
     */
    @JsonProperty("panelTwo")
    public void setPanelTwo(panelTwoDiv panelTwo) {
        this.panelTwo = panelTwo;
    }

    /*
     * getpanelThree
     * @return panelThree
     */
    @JsonProperty("panelThree")
    public panelThreeDiv getPanelThree() {
        return panelThree;
    }

    /*
     * setpanelThree
     * @param panelThree panelThree
     */
    @JsonProperty("panelThree")
    public void setPanelThree(panelThreeDiv panelThree) {
        this.panelThree = panelThree;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public DataGrid<dgdKyufuhiMeisai_Row> getDgdKyufuhiMeisai() {
        return this.getPanelThree().getDgdKyufuhiMeisai();
    }

    @JsonIgnore
    public void  setDgdKyufuhiMeisai(DataGrid<dgdKyufuhiMeisai_Row> dgdKyufuhiMeisai) {
        this.getPanelThree().setDgdKyufuhiMeisai(dgdKyufuhiMeisai);
    }

    @JsonIgnore
    public panelFourDiv getPanelFour() {
        return this.getPanelThree().getPanelFour();
    }

    @JsonIgnore
    public void  setPanelFour(panelFourDiv panelFour) {
        this.getPanelThree().setPanelFour(panelFour);
    }

    @JsonIgnore
    public TextBoxCode getTxtServiceShuruiCode() {
        return this.getPanelThree().getPanelFour().getTxtServiceShuruiCode();
    }

    @JsonIgnore
    public void  setTxtServiceShuruiCode(TextBoxCode txtServiceShuruiCode) {
        this.getPanelThree().getPanelFour().setTxtServiceShuruiCode(txtServiceShuruiCode);
    }

    @JsonIgnore
    public TextBoxCode getTxtServiceKoumokuCode() {
        return this.getPanelThree().getPanelFour().getTxtServiceKoumokuCode();
    }

    @JsonIgnore
    public void  setTxtServiceKoumokuCode(TextBoxCode txtServiceKoumokuCode) {
        this.getPanelThree().getPanelFour().setTxtServiceKoumokuCode(txtServiceKoumokuCode);
    }

    @JsonIgnore
    public TextBox getTxtServicename() {
        return this.getPanelThree().getPanelFour().getTxtServicename();
    }

    @JsonIgnore
    public void  setTxtServicename(TextBox txtServicename) {
        this.getPanelThree().getPanelFour().setTxtServicename(txtServicename);
    }

    @JsonIgnore
    public TextBoxNum getTxtTanyi() {
        return this.getPanelThree().getPanelFour().getTxtTanyi();
    }

    @JsonIgnore
    public void  setTxtTanyi(TextBoxNum txtTanyi) {
        this.getPanelThree().getPanelFour().setTxtTanyi(txtTanyi);
    }

    @JsonIgnore
    public TextBoxNum getTxtKaisu() {
        return this.getPanelThree().getPanelFour().getTxtKaisu();
    }

    @JsonIgnore
    public void  setTxtKaisu(TextBoxNum txtKaisu) {
        this.getPanelThree().getPanelFour().setTxtKaisu(txtKaisu);
    }

    @JsonIgnore
    public TextBoxNum getTxtServiceTanyi() {
        return this.getPanelThree().getPanelFour().getTxtServiceTanyi();
    }

    @JsonIgnore
    public void  setTxtServiceTanyi(TextBoxNum txtServiceTanyi) {
        this.getPanelThree().getPanelFour().setTxtServiceTanyi(txtServiceTanyi);
    }

    @JsonIgnore
    public TextBoxCode getTxtShisetsuHokenshaCode() {
        return this.getPanelThree().getPanelFour().getTxtShisetsuHokenshaCode();
    }

    @JsonIgnore
    public void  setTxtShisetsuHokenshaCode(TextBoxCode txtShisetsuHokenshaCode) {
        this.getPanelThree().getPanelFour().setTxtShisetsuHokenshaCode(txtShisetsuHokenshaCode);
    }

    @JsonIgnore
    public TextBox getTxtShisetsuHokenshaName() {
        return this.getPanelThree().getPanelFour().getTxtShisetsuHokenshaName();
    }

    @JsonIgnore
    public void  setTxtShisetsuHokenshaName(TextBox txtShisetsuHokenshaName) {
        this.getPanelThree().getPanelFour().setTxtShisetsuHokenshaName(txtShisetsuHokenshaName);
    }

    @JsonIgnore
    public TextBox getTxtTeikiyo() {
        return this.getPanelThree().getPanelFour().getTxtTeikiyo();
    }

    @JsonIgnore
    public void  setTxtTeikiyo(TextBox txtTeikiyo) {
        this.getPanelThree().getPanelFour().setTxtTeikiyo(txtTeikiyo);
    }

    @JsonIgnore
    public Button getBtnClose() {
        return this.getPanelThree().getPanelFour().getBtnClose();
    }

    @JsonIgnore
    public void  setBtnClose(Button btnClose) {
        this.getPanelThree().getPanelFour().setBtnClose(btnClose);
    }

    // </editor-fold>
}
