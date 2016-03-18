package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2310001;
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
 * IkenshoKihonJoho のクラスファイル 
 * 
 * @author 自動生成
 */
public class IkenshoKihonJohoDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-01-15_09-59-03">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ShujiiJoho")
    private ShujiiJohoDiv ShujiiJoho;
    @JsonProperty("ChosaTishoJoho")
    private ChosaTishoJohoDiv ChosaTishoJoho;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getShujiiJoho
     * @return ShujiiJoho
     */
    @JsonProperty("ShujiiJoho")
    public ShujiiJohoDiv getShujiiJoho() {
        return ShujiiJoho;
    }

    /*
     * setShujiiJoho
     * @param ShujiiJoho ShujiiJoho
     */
    @JsonProperty("ShujiiJoho")
    public void setShujiiJoho(ShujiiJohoDiv ShujiiJoho) {
        this.ShujiiJoho = ShujiiJoho;
    }

    /*
     * getChosaTishoJoho
     * @return ChosaTishoJoho
     */
    @JsonProperty("ChosaTishoJoho")
    public ChosaTishoJohoDiv getChosaTishoJoho() {
        return ChosaTishoJoho;
    }

    /*
     * setChosaTishoJoho
     * @param ChosaTishoJoho ChosaTishoJoho
     */
    @JsonProperty("ChosaTishoJoho")
    public void setChosaTishoJoho(ChosaTishoJohoDiv ChosaTishoJoho) {
        this.ChosaTishoJoho = ChosaTishoJoho;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public RadioButton getRadDoi() {
        return this.getShujiiJoho().getRadDoi();
    }

    @JsonIgnore
    public void  setRadDoi(RadioButton radDoi) {
        this.getShujiiJoho().setRadDoi(radDoi);
    }

    @JsonIgnore
    public TextBox getTxtShujiiShimei() {
        return this.getShujiiJoho().getTxtShujiiShimei();
    }

    @JsonIgnore
    public void  setTxtShujiiShimei(TextBox txtShujiiShimei) {
        this.getShujiiJoho().setTxtShujiiShimei(txtShujiiShimei);
    }

    @JsonIgnore
    public TextBoxDate getTxtKinyuYMD() {
        return this.getShujiiJoho().getTxtKinyuYMD();
    }

    @JsonIgnore
    public void  setTxtKinyuYMD(TextBoxDate txtKinyuYMD) {
        this.getShujiiJoho().setTxtKinyuYMD(txtKinyuYMD);
    }

    @JsonIgnore
    public TextBox getTxtIryoKikanMeisho() {
        return this.getShujiiJoho().getTxtIryoKikanMeisho();
    }

    @JsonIgnore
    public void  setTxtIryoKikanMeisho(TextBox txtIryoKikanMeisho) {
        this.getShujiiJoho().setTxtIryoKikanMeisho(txtIryoKikanMeisho);
    }

    @JsonIgnore
    public TextBoxTelNo getTxtShujiiIryoKikanTelNumber() {
        return this.getShujiiJoho().getTxtShujiiIryoKikanTelNumber();
    }

    @JsonIgnore
    public void  setTxtShujiiIryoKikanTelNumber(TextBoxTelNo txtShujiiIryoKikanTelNumber) {
        this.getShujiiJoho().setTxtShujiiIryoKikanTelNumber(txtShujiiIryoKikanTelNumber);
    }

    @JsonIgnore
    public TextBoxJusho getTxtShujiiIryoKikanShozaichi() {
        return this.getShujiiJoho().getTxtShujiiIryoKikanShozaichi();
    }

    @JsonIgnore
    public void  setTxtShujiiIryoKikanShozaichi(TextBoxJusho txtShujiiIryoKikanShozaichi) {
        this.getShujiiJoho().setTxtShujiiIryoKikanShozaichi(txtShujiiIryoKikanShozaichi);
    }

    @JsonIgnore
    public TextBoxTelNo getTxtShujiiIryoKikanFaxNumber() {
        return this.getShujiiJoho().getTxtShujiiIryoKikanFaxNumber();
    }

    @JsonIgnore
    public void  setTxtShujiiIryoKikanFaxNumber(TextBoxTelNo txtShujiiIryoKikanFaxNumber) {
        this.getShujiiJoho().setTxtShujiiIryoKikanFaxNumber(txtShujiiIryoKikanFaxNumber);
    }

    @JsonIgnore
    public TextBoxDate getTxtSaishuShinryoYMD() {
        return this.getChosaTishoJoho().getTxtSaishuShinryoYMD();
    }

    @JsonIgnore
    public void  setTxtSaishuShinryoYMD(TextBoxDate txtSaishuShinryoYMD) {
        this.getChosaTishoJoho().setTxtSaishuShinryoYMD(txtSaishuShinryoYMD);
    }

    @JsonIgnore
    public RadioButton getRadIkenshoSakuseiKaisu() {
        return this.getChosaTishoJoho().getRadIkenshoSakuseiKaisu();
    }

    @JsonIgnore
    public void  setRadIkenshoSakuseiKaisu(RadioButton radIkenshoSakuseiKaisu) {
        this.getChosaTishoJoho().setRadIkenshoSakuseiKaisu(radIkenshoSakuseiKaisu);
    }

    @JsonIgnore
    public RadioButton getRadTakaShinryo() {
        return this.getChosaTishoJoho().getRadTakaShinryo();
    }

    @JsonIgnore
    public void  setRadTakaShinryo(RadioButton radTakaShinryo) {
        this.getChosaTishoJoho().setRadTakaShinryo(radTakaShinryo);
    }

    @JsonIgnore
    public CheckBoxList getChkTakaJushinSelect() {
        return this.getChosaTishoJoho().getChkTakaJushinSelect();
    }

    @JsonIgnore
    public void  setChkTakaJushinSelect(CheckBoxList chkTakaJushinSelect) {
        this.getChosaTishoJoho().setChkTakaJushinSelect(chkTakaJushinSelect);
    }

    @JsonIgnore
    public CheckBoxList getChkSonota() {
        return this.getChosaTishoJoho().getChkSonota();
    }

    @JsonIgnore
    public void  setChkSonota(CheckBoxList chkSonota) {
        this.getChosaTishoJoho().setChkSonota(chkSonota);
    }

    @JsonIgnore
    public TextBox getTxtSonotaNyuryoku() {
        return this.getChosaTishoJoho().getTxtSonotaNyuryoku();
    }

    @JsonIgnore
    public void  setTxtSonotaNyuryoku(TextBox txtSonotaNyuryoku) {
        this.getChosaTishoJoho().setTxtSonotaNyuryoku(txtSonotaNyuryoku);
    }

    // </editor-fold>
}
