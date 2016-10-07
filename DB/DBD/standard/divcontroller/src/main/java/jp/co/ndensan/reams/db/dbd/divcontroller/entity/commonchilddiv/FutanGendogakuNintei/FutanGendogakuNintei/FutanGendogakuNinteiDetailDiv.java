package jp.co.ndensan.reams.db.dbd.divcontroller.entity.commonchilddiv.FutanGendogakuNintei.FutanGendogakuNintei;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * FutanGendogakuNinteiDetail のクラスファイル 
 * 
 * @author 自動生成
 */
public class FutanGendogakuNinteiDetailDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-07-28_11-34-20">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtShinseiDate")
    private TextBoxFlexibleDate txtShinseiDate;
    @JsonProperty("txtShinseiRiyu")
    private TextBox txtShinseiRiyu;
    @JsonProperty("izokuNenkinJukyuShinkoku")
    private CheckBoxList izokuNenkinJukyuShinkoku;
    @JsonProperty("shogaiNenkinJukyuShinkoku")
    private CheckBoxList shogaiNenkinJukyuShinkoku;
    @JsonProperty("HiKazeiNenkinjoho")
    private TextBox HiKazeiNenkinjoho;
    @JsonProperty("FutanGendogakuNinteiRiyoshaFutan")
    private FutanGendogakuNinteiRiyoshaFutanDiv FutanGendogakuNinteiRiyoshaFutan;
    @JsonProperty("haigushaJoho")
    private haigushaJohoDiv haigushaJoho;
    @JsonProperty("yochokinjoho")
    private yochokinjohoDiv yochokinjoho;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtShinseiDate
     * @return txtShinseiDate
     */
    @JsonProperty("txtShinseiDate")
    public TextBoxFlexibleDate getTxtShinseiDate() {
        return txtShinseiDate;
    }

    /*
     * settxtShinseiDate
     * @param txtShinseiDate txtShinseiDate
     */
    @JsonProperty("txtShinseiDate")
    public void setTxtShinseiDate(TextBoxFlexibleDate txtShinseiDate) {
        this.txtShinseiDate = txtShinseiDate;
    }

    /*
     * gettxtShinseiRiyu
     * @return txtShinseiRiyu
     */
    @JsonProperty("txtShinseiRiyu")
    public TextBox getTxtShinseiRiyu() {
        return txtShinseiRiyu;
    }

    /*
     * settxtShinseiRiyu
     * @param txtShinseiRiyu txtShinseiRiyu
     */
    @JsonProperty("txtShinseiRiyu")
    public void setTxtShinseiRiyu(TextBox txtShinseiRiyu) {
        this.txtShinseiRiyu = txtShinseiRiyu;
    }

    /*
     * getizokuNenkinJukyuShinkoku
     * @return izokuNenkinJukyuShinkoku
     */
    @JsonProperty("izokuNenkinJukyuShinkoku")
    public CheckBoxList getIzokuNenkinJukyuShinkoku() {
        return izokuNenkinJukyuShinkoku;
    }

    /*
     * setizokuNenkinJukyuShinkoku
     * @param izokuNenkinJukyuShinkoku izokuNenkinJukyuShinkoku
     */
    @JsonProperty("izokuNenkinJukyuShinkoku")
    public void setIzokuNenkinJukyuShinkoku(CheckBoxList izokuNenkinJukyuShinkoku) {
        this.izokuNenkinJukyuShinkoku = izokuNenkinJukyuShinkoku;
    }

    /*
     * getshogaiNenkinJukyuShinkoku
     * @return shogaiNenkinJukyuShinkoku
     */
    @JsonProperty("shogaiNenkinJukyuShinkoku")
    public CheckBoxList getShogaiNenkinJukyuShinkoku() {
        return shogaiNenkinJukyuShinkoku;
    }

    /*
     * setshogaiNenkinJukyuShinkoku
     * @param shogaiNenkinJukyuShinkoku shogaiNenkinJukyuShinkoku
     */
    @JsonProperty("shogaiNenkinJukyuShinkoku")
    public void setShogaiNenkinJukyuShinkoku(CheckBoxList shogaiNenkinJukyuShinkoku) {
        this.shogaiNenkinJukyuShinkoku = shogaiNenkinJukyuShinkoku;
    }

    /*
     * getHiKazeiNenkinjoho
     * @return HiKazeiNenkinjoho
     */
    @JsonProperty("HiKazeiNenkinjoho")
    public TextBox getHiKazeiNenkinjoho() {
        return HiKazeiNenkinjoho;
    }

    /*
     * setHiKazeiNenkinjoho
     * @param HiKazeiNenkinjoho HiKazeiNenkinjoho
     */
    @JsonProperty("HiKazeiNenkinjoho")
    public void setHiKazeiNenkinjoho(TextBox HiKazeiNenkinjoho) {
        this.HiKazeiNenkinjoho = HiKazeiNenkinjoho;
    }

    /*
     * getFutanGendogakuNinteiRiyoshaFutan
     * @return FutanGendogakuNinteiRiyoshaFutan
     */
    @JsonProperty("FutanGendogakuNinteiRiyoshaFutan")
    public FutanGendogakuNinteiRiyoshaFutanDiv getFutanGendogakuNinteiRiyoshaFutan() {
        return FutanGendogakuNinteiRiyoshaFutan;
    }

    /*
     * setFutanGendogakuNinteiRiyoshaFutan
     * @param FutanGendogakuNinteiRiyoshaFutan FutanGendogakuNinteiRiyoshaFutan
     */
    @JsonProperty("FutanGendogakuNinteiRiyoshaFutan")
    public void setFutanGendogakuNinteiRiyoshaFutan(FutanGendogakuNinteiRiyoshaFutanDiv FutanGendogakuNinteiRiyoshaFutan) {
        this.FutanGendogakuNinteiRiyoshaFutan = FutanGendogakuNinteiRiyoshaFutan;
    }

    /*
     * gethaigushaJoho
     * @return haigushaJoho
     */
    @JsonProperty("haigushaJoho")
    public haigushaJohoDiv getHaigushaJoho() {
        return haigushaJoho;
    }

    /*
     * sethaigushaJoho
     * @param haigushaJoho haigushaJoho
     */
    @JsonProperty("haigushaJoho")
    public void setHaigushaJoho(haigushaJohoDiv haigushaJoho) {
        this.haigushaJoho = haigushaJoho;
    }

    /*
     * getyochokinjoho
     * @return yochokinjoho
     */
    @JsonProperty("yochokinjoho")
    public yochokinjohoDiv getYochokinjoho() {
        return yochokinjoho;
    }

    /*
     * setyochokinjoho
     * @param yochokinjoho yochokinjoho
     */
    @JsonProperty("yochokinjoho")
    public void setYochokinjoho(yochokinjohoDiv yochokinjoho) {
        this.yochokinjoho = yochokinjoho;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public RadioButton getRadHaigushaUmu() {
        return this.getHaigushaJoho().getRadHaigushaUmu();
    }

    @JsonIgnore
    public void  setRadHaigushaUmu(RadioButton radHaigushaUmu) {
        this.getHaigushaJoho().setRadHaigushaUmu(radHaigushaUmu);
    }

    @JsonIgnore
    public TextBoxShikibetsuCode getTxtShikibetsuCode() {
        return this.getHaigushaJoho().getTxtShikibetsuCode();
    }

    @JsonIgnore
    public void  setTxtShikibetsuCode(TextBoxShikibetsuCode txtShikibetsuCode) {
        this.getHaigushaJoho().setTxtShikibetsuCode(txtShikibetsuCode);
    }

    @JsonIgnore
    public TextBox getTxtShimeiKana() {
        return this.getHaigushaJoho().getTxtShimeiKana();
    }

    @JsonIgnore
    public void  setTxtShimeiKana(TextBox txtShimeiKana) {
        this.getHaigushaJoho().setTxtShimeiKana(txtShimeiKana);
    }

    @JsonIgnore
    public TextBox getTxtShimei() {
        return this.getHaigushaJoho().getTxtShimei();
    }

    @JsonIgnore
    public void  setTxtShimei(TextBox txtShimei) {
        this.getHaigushaJoho().setTxtShimei(txtShimei);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtBirthday() {
        return this.getHaigushaJoho().getTxtBirthday();
    }

    @JsonIgnore
    public void  setTxtBirthday(TextBoxFlexibleDate txtBirthday) {
        this.getHaigushaJoho().setTxtBirthday(txtBirthday);
    }

    @JsonIgnore
    public TextBoxTelNo getTxtRenrakusaki() {
        return this.getHaigushaJoho().getTxtRenrakusaki();
    }

    @JsonIgnore
    public void  setTxtRenrakusaki(TextBoxTelNo txtRenrakusaki) {
        this.getHaigushaJoho().setTxtRenrakusaki(txtRenrakusaki);
    }

    @JsonIgnore
    public TextBoxJusho getTxtJusho1() {
        return this.getHaigushaJoho().getTxtJusho1();
    }

    @JsonIgnore
    public void  setTxtJusho1(TextBoxJusho txtJusho1) {
        this.getHaigushaJoho().setTxtJusho1(txtJusho1);
    }

    @JsonIgnore
    public Label getLblGenjusho1() {
        return this.getHaigushaJoho().getLblGenjusho1();
    }

    @JsonIgnore
    public void  setLblGenjusho1(Label lblGenjusho1) {
        this.getHaigushaJoho().setLblGenjusho1(lblGenjusho1);
    }

    @JsonIgnore
    public TextBoxJusho getTxtGenjusho() {
        return this.getHaigushaJoho().getTxtGenjusho();
    }

    @JsonIgnore
    public void  setTxtGenjusho(TextBoxJusho txtGenjusho) {
        this.getHaigushaJoho().setTxtGenjusho(txtGenjusho);
    }

    @JsonIgnore
    public RadioButton getRadKazeiKubun() {
        return this.getHaigushaJoho().getRadKazeiKubun();
    }

    @JsonIgnore
    public void  setRadKazeiKubun(RadioButton radKazeiKubun) {
        this.getHaigushaJoho().setRadKazeiKubun(radKazeiKubun);
    }

    @JsonIgnore
    public CheckBoxList getChkYochokin() {
        return this.getYochokinjoho().getChkYochokin();
    }

    @JsonIgnore
    public void  setChkYochokin(CheckBoxList chkYochokin) {
        this.getYochokinjoho().setChkYochokin(chkYochokin);
    }

    @JsonIgnore
    public TextBoxNum getTxtYochokin() {
        return this.getYochokinjoho().getTxtYochokin();
    }

    @JsonIgnore
    public void  setTxtYochokin(TextBoxNum txtYochokin) {
        this.getYochokinjoho().setTxtYochokin(txtYochokin);
    }

    @JsonIgnore
    public TextBoxNum getTxtYukaShoken() {
        return this.getYochokinjoho().getTxtYukaShoken();
    }

    @JsonIgnore
    public void  setTxtYukaShoken(TextBoxNum txtYukaShoken) {
        this.getYochokinjoho().setTxtYukaShoken(txtYukaShoken);
    }

    @JsonIgnore
    public TextBoxNum getTxtSonota() {
        return this.getYochokinjoho().getTxtSonota();
    }

    @JsonIgnore
    public void  setTxtSonota(TextBoxNum txtSonota) {
        this.getYochokinjoho().setTxtSonota(txtSonota);
    }

    // </editor-fold>
}
