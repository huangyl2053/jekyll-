package jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0610011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.hokenshalist.HokenshaList.HokenshaListDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.hokenshalist.HokenshaList.IHokenshaListDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * KijunYMD のクラスファイル 
 * 
 * @author 自動生成
 */
public class KijunYMDDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("lblKijunYMD")
    private Label lblKijunYMD;
    @JsonProperty("txtKijunYMD")
    private TextBoxDate txtKijunYMD;
    @JsonProperty("lblGenzai")
    private Label lblGenzai;
    @JsonProperty("btnShukei")
    private Button btnShukei;
    @JsonProperty("lin1")
    private HorizontalLine lin1;
    @JsonProperty("tblAll")
    private tblAllDiv tblAll;
    @JsonProperty("ccdCitySelect")
    private HokenshaListDiv ccdCitySelect;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getlblKijunYMD
     * @return lblKijunYMD
     */
    @JsonProperty("lblKijunYMD")
    public Label getLblKijunYMD() {
        return lblKijunYMD;
    }

    /*
     * setlblKijunYMD
     * @param lblKijunYMD lblKijunYMD
     */
    @JsonProperty("lblKijunYMD")
    public void setLblKijunYMD(Label lblKijunYMD) {
        this.lblKijunYMD = lblKijunYMD;
    }

    /*
     * gettxtKijunYMD
     * @return txtKijunYMD
     */
    @JsonProperty("txtKijunYMD")
    public TextBoxDate getTxtKijunYMD() {
        return txtKijunYMD;
    }

    /*
     * settxtKijunYMD
     * @param txtKijunYMD txtKijunYMD
     */
    @JsonProperty("txtKijunYMD")
    public void setTxtKijunYMD(TextBoxDate txtKijunYMD) {
        this.txtKijunYMD = txtKijunYMD;
    }

    /*
     * getlblGenzai
     * @return lblGenzai
     */
    @JsonProperty("lblGenzai")
    public Label getLblGenzai() {
        return lblGenzai;
    }

    /*
     * setlblGenzai
     * @param lblGenzai lblGenzai
     */
    @JsonProperty("lblGenzai")
    public void setLblGenzai(Label lblGenzai) {
        this.lblGenzai = lblGenzai;
    }

    /*
     * getbtnShukei
     * @return btnShukei
     */
    @JsonProperty("btnShukei")
    public Button getBtnShukei() {
        return btnShukei;
    }

    /*
     * setbtnShukei
     * @param btnShukei btnShukei
     */
    @JsonProperty("btnShukei")
    public void setBtnShukei(Button btnShukei) {
        this.btnShukei = btnShukei;
    }

    /*
     * getlin1
     * @return lin1
     */
    @JsonProperty("lin1")
    public HorizontalLine getLin1() {
        return lin1;
    }

    /*
     * setlin1
     * @param lin1 lin1
     */
    @JsonProperty("lin1")
    public void setLin1(HorizontalLine lin1) {
        this.lin1 = lin1;
    }

    /*
     * gettblAll
     * @return tblAll
     */
    @JsonProperty("tblAll")
    public tblAllDiv getTblAll() {
        return tblAll;
    }

    /*
     * settblAll
     * @param tblAll tblAll
     */
    @JsonProperty("tblAll")
    public void setTblAll(tblAllDiv tblAll) {
        this.tblAll = tblAll;
    }

    /*
     * getccdCitySelect
     * @return ccdCitySelect
     */
    @JsonProperty("ccdCitySelect")
    public IHokenshaListDiv getCcdCitySelect() {
        return ccdCitySelect;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public tblShikakuDiv getTblShikaku() {
        return this.getTblAll().getTblShikaku();
    }

    @JsonIgnore
    public ShikakuTitle1Div getShikakuTitle1() {
        return this.getTblAll().getTblShikaku().getShikakuTitle1();
    }

    @JsonIgnore
    public Label getLblShikakuTitle1() {
        return this.getTblAll().getTblShikaku().getShikakuTitle1().getLblShikakuTitle1();
    }

    @JsonIgnore
    public void  setLblShikakuTitle1(Label lblShikakuTitle1) {
        this.getTblAll().getTblShikaku().getShikakuTitle1().setLblShikakuTitle1(lblShikakuTitle1);
    }

    @JsonIgnore
    public TextBoxNum getTxtShikaku1() {
        return this.getTblAll().getTblShikaku().getTxtShikaku1();
    }

    @JsonIgnore
    public Label getLblTani1() {
        return this.getTblAll().getTblShikaku().getLblTani1();
    }

    @JsonIgnore
    public TextBoxNum getTxtJutoku1() {
        return this.getTblAll().getTblShikaku().getTxtJutoku1();
    }

    @JsonIgnore
    public Label getLblTani2() {
        return this.getTblAll().getTblShikaku().getLblTani2();
    }

    @JsonIgnore
    public ShikakuTitle2Div getShikakuTitle2() {
        return this.getTblAll().getTblShikaku().getShikakuTitle2();
    }

    @JsonIgnore
    public Label getLblShikakuTitle2() {
        return this.getTblAll().getTblShikaku().getShikakuTitle2().getLblShikakuTitle2();
    }

    @JsonIgnore
    public void  setLblShikakuTitle2(Label lblShikakuTitle2) {
        this.getTblAll().getTblShikaku().getShikakuTitle2().setLblShikakuTitle2(lblShikakuTitle2);
    }

    @JsonIgnore
    public TextBoxNum getTxtShikaku2() {
        return this.getTblAll().getTblShikaku().getTxtShikaku2();
    }

    @JsonIgnore
    public Label getLblTani3() {
        return this.getTblAll().getTblShikaku().getLblTani3();
    }

    @JsonIgnore
    public TextBoxNum getTxtJutoku2() {
        return this.getTblAll().getTblShikaku().getTxtJutoku2();
    }

    @JsonIgnore
    public Label getLblTani4() {
        return this.getTblAll().getTblShikaku().getLblTani4();
    }

    @JsonIgnore
    public ShikakuTitle3Div getShikakuTitle3() {
        return this.getTblAll().getTblShikaku().getShikakuTitle3();
    }

    @JsonIgnore
    public Label getLblShikakuTitle3() {
        return this.getTblAll().getTblShikaku().getShikakuTitle3().getLblShikakuTitle3();
    }

    @JsonIgnore
    public void  setLblShikakuTitle3(Label lblShikakuTitle3) {
        this.getTblAll().getTblShikaku().getShikakuTitle3().setLblShikakuTitle3(lblShikakuTitle3);
    }

    @JsonIgnore
    public TextBoxNum getTxtShikaku3() {
        return this.getTblAll().getTblShikaku().getTxtShikaku3();
    }

    @JsonIgnore
    public Label getLblTani5() {
        return this.getTblAll().getTblShikaku().getLblTani5();
    }

    @JsonIgnore
    public TextBoxNum getTxtJutoku3() {
        return this.getTblAll().getTblShikaku().getTxtJutoku3();
    }

    @JsonIgnore
    public Label getLblTani6() {
        return this.getTblAll().getTblShikaku().getLblTani6();
    }

    @JsonIgnore
    public Label getLblShikakuTitle5() {
        return this.getTblAll().getTblShikaku().getLblShikakuTitle5();
    }

    @JsonIgnore
    public TextBoxNum getTxtJogai() {
        return this.getTblAll().getTblShikaku().getTxtJogai();
    }

    @JsonIgnore
    public Label getLblTani7() {
        return this.getTblAll().getTblShikaku().getLblTani7();
    }

    @JsonIgnore
    public Label getLblShikakuTitle6() {
        return this.getTblAll().getTblShikaku().getLblShikakuTitle6();
    }

    @JsonIgnore
    public TextBoxNum getTxtTatoku() {
        return this.getTblAll().getTblShikaku().getTxtTatoku();
    }

    @JsonIgnore
    public Label getLblTani8() {
        return this.getTblAll().getTblShikaku().getLblTani8();
    }

    @JsonIgnore
    public tblJukyuDiv getTblJukyu() {
        return this.getTblAll().getTblJukyu();
    }

    @JsonIgnore
    public Label getLblJukyuTitle1() {
        return this.getTblAll().getTblJukyu().getLblJukyuTitle1();
    }

    @JsonIgnore
    public TextBoxNum getTxtJukyu1() {
        return this.getTblAll().getTblJukyu().getTxtJukyu1();
    }

    @JsonIgnore
    public Label getLblJukyuTani1() {
        return this.getTblAll().getTblJukyu().getLblJukyuTani1();
    }

    @JsonIgnore
    public Label getLblJukyuTitle2() {
        return this.getTblAll().getTblJukyu().getLblJukyuTitle2();
    }

    @JsonIgnore
    public TextBoxNum getTxtJukyu2() {
        return this.getTblAll().getTblJukyu().getTxtJukyu2();
    }

    @JsonIgnore
    public Label getLblJukyuTani2() {
        return this.getTblAll().getTblJukyu().getLblJukyuTani2();
    }

    @JsonIgnore
    public Label getLblJukyuTitle3() {
        return this.getTblAll().getTblJukyu().getLblJukyuTitle3();
    }

    @JsonIgnore
    public TextBoxNum getTxtJukyu3() {
        return this.getTblAll().getTblJukyu().getTxtJukyu3();
    }

    @JsonIgnore
    public Label getLblJukyuTani3() {
        return this.getTblAll().getTblJukyu().getLblJukyuTani3();
    }

    @JsonIgnore
    public Label getLblJukyuTitle4() {
        return this.getTblAll().getTblJukyu().getLblJukyuTitle4();
    }

    @JsonIgnore
    public TextBoxNum getTxtJukyu4() {
        return this.getTblAll().getTblJukyu().getTxtJukyu4();
    }

    @JsonIgnore
    public Label getLblJukyuTani4() {
        return this.getTblAll().getTblJukyu().getLblJukyuTani4();
    }

    @JsonIgnore
    public Label getLblJukyuTitle5() {
        return this.getTblAll().getTblJukyu().getLblJukyuTitle5();
    }

    @JsonIgnore
    public TextBoxNum getTxtJukyu5() {
        return this.getTblAll().getTblJukyu().getTxtJukyu5();
    }

    @JsonIgnore
    public Label getLblJukyuTani5() {
        return this.getTblAll().getTblJukyu().getLblJukyuTani5();
    }

    @JsonIgnore
    public Label getLblJukyuTitle6() {
        return this.getTblAll().getTblJukyu().getLblJukyuTitle6();
    }

    @JsonIgnore
    public TextBoxNum getTxtJukyu6() {
        return this.getTblAll().getTblJukyu().getTxtJukyu6();
    }

    @JsonIgnore
    public Label getLblJukyuTani6() {
        return this.getTblAll().getTblJukyu().getLblJukyuTani6();
    }

    @JsonIgnore
    public Label getLblJukyuTitle7() {
        return this.getTblAll().getTblJukyu().getLblJukyuTitle7();
    }

    @JsonIgnore
    public TextBoxNum getTxtJukyu7() {
        return this.getTblAll().getTblJukyu().getTxtJukyu7();
    }

    @JsonIgnore
    public Label getLblJukyuTani7() {
        return this.getTblAll().getTblJukyu().getLblJukyuTani7();
    }

    @JsonIgnore
    public Label getLblJukyuTitle8() {
        return this.getTblAll().getTblJukyu().getLblJukyuTitle8();
    }

    @JsonIgnore
    public TextBoxNum getTxtJukyu8() {
        return this.getTblAll().getTblJukyu().getTxtJukyu8();
    }

    @JsonIgnore
    public Label getLblJukyuTani8() {
        return this.getTblAll().getTblJukyu().getLblJukyuTani8();
    }

    @JsonIgnore
    public Label getLblJukyuTitle9() {
        return this.getTblAll().getTblJukyu().getLblJukyuTitle9();
    }

    @JsonIgnore
    public TextBoxNum getTxtJukyu9() {
        return this.getTblAll().getTblJukyu().getTxtJukyu9();
    }

    @JsonIgnore
    public Label getLblJukyuTani9() {
        return this.getTblAll().getTblJukyu().getLblJukyuTani9();
    }

    @JsonIgnore
    public Label getLblJukyuTitle10() {
        return this.getTblAll().getTblJukyu().getLblJukyuTitle10();
    }

    @JsonIgnore
    public TextBoxNum getTxtJukyu10() {
        return this.getTblAll().getTblJukyu().getTxtJukyu10();
    }

    @JsonIgnore
    public Label getLblJukyuTani10() {
        return this.getTblAll().getTblJukyu().getLblJukyuTani10();
    }

    @JsonIgnore
    public HorizontalLine getLin2() {
        return this.getTblAll().getLin2();
    }

    @JsonIgnore
    public tblFukaDiv getTblFuka() {
        return this.getTblAll().getTblFuka();
    }

    @JsonIgnore
    public Label getLblFukaTitle1() {
        return this.getTblAll().getTblFuka().getLblFukaTitle1();
    }

    @JsonIgnore
    public TextBoxNum getTxtFuka1() {
        return this.getTblAll().getTblFuka().getTxtFuka1();
    }

    @JsonIgnore
    public Label getLblFukaTani1() {
        return this.getTblAll().getTblFuka().getLblFukaTani1();
    }

    @JsonIgnore
    public Label getLblFukaTitle2() {
        return this.getTblAll().getTblFuka().getLblFukaTitle2();
    }

    @JsonIgnore
    public TextBoxNum getTxtFuka2() {
        return this.getTblAll().getTblFuka().getTxtFuka2();
    }

    @JsonIgnore
    public Label getLblFukaTani2() {
        return this.getTblAll().getTblFuka().getLblFukaTani2();
    }

    @JsonIgnore
    public Label getLblFukaTitle3() {
        return this.getTblAll().getTblFuka().getLblFukaTitle3();
    }

    @JsonIgnore
    public TextBoxNum getTxtFuka3() {
        return this.getTblAll().getTblFuka().getTxtFuka3();
    }

    @JsonIgnore
    public Label getLblFukaTani3() {
        return this.getTblAll().getTblFuka().getLblFukaTani3();
    }

    @JsonIgnore
    public Label getLblFukaTitle4() {
        return this.getTblAll().getTblFuka().getLblFukaTitle4();
    }

    @JsonIgnore
    public TextBoxNum getTxtFuka4() {
        return this.getTblAll().getTblFuka().getTxtFuka4();
    }

    @JsonIgnore
    public Label getLblFukaTani4() {
        return this.getTblAll().getTblFuka().getLblFukaTani4();
    }

    // </editor-fold>
}
