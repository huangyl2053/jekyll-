package jp.co.ndensan.reams.db.dbd.divcontroller.entity.commonchilddiv.FutanGendogakuNintei.FutanGendogakuNintei;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.ui.binding.CheckBoxList;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGrid;
import jp.co.ndensan.reams.uz.uza.ui.binding.Label;
import jp.co.ndensan.reams.uz.uza.ui.binding.RadioButton;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBox;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxFlexibleDate;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxNum;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.TextBoxJusho;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.TextBoxShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.TextBoxTelNo;

/**
 * FutanGendogakuNintei のクラスファイル
 *
 * @author 自動生成
 */
public class FutanGendogakuNinteiDiv extends Panel implements IFutanGendogakuNinteiDiv {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("dgFutanGendogakuNinteiList")
    private DataGrid<dgFutanGendogakuNinteiList_Row> dgFutanGendogakuNinteiList;
    @JsonProperty("FutanGendogakuNinteiDetail")
    private FutanGendogakuNinteiDetailDiv FutanGendogakuNinteiDetail;
    @JsonProperty("btnClose")
    private Button btnClose;
    @JsonProperty("txtHiddenHihokenshaNo")
    private RString txtHiddenHihokenshaNo;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getdgFutanGendogakuNinteiList
     * @return dgFutanGendogakuNinteiList
     */
    @JsonProperty("dgFutanGendogakuNinteiList")
    public DataGrid<dgFutanGendogakuNinteiList_Row> getDgFutanGendogakuNinteiList() {
        return dgFutanGendogakuNinteiList;
    }

    /*
     * setdgFutanGendogakuNinteiList
     * @param dgFutanGendogakuNinteiList dgFutanGendogakuNinteiList
     */
    @JsonProperty("dgFutanGendogakuNinteiList")
    public void setDgFutanGendogakuNinteiList(DataGrid<dgFutanGendogakuNinteiList_Row> dgFutanGendogakuNinteiList) {
        this.dgFutanGendogakuNinteiList = dgFutanGendogakuNinteiList;
    }

    /*
     * getFutanGendogakuNinteiDetail
     * @return FutanGendogakuNinteiDetail
     */
    @JsonProperty("FutanGendogakuNinteiDetail")
    public FutanGendogakuNinteiDetailDiv getFutanGendogakuNinteiDetail() {
        return FutanGendogakuNinteiDetail;
    }

    /*
     * setFutanGendogakuNinteiDetail
     * @param FutanGendogakuNinteiDetail FutanGendogakuNinteiDetail
     */
    @JsonProperty("FutanGendogakuNinteiDetail")
    public void setFutanGendogakuNinteiDetail(FutanGendogakuNinteiDetailDiv FutanGendogakuNinteiDetail) {
        this.FutanGendogakuNinteiDetail = FutanGendogakuNinteiDetail;
    }

    /*
     * getbtnClose
     * @return btnClose
     */
    @JsonProperty("btnClose")
    public Button getBtnClose() {
        return btnClose;
    }

    /*
     * setbtnClose
     * @param btnClose btnClose
     */
    @JsonProperty("btnClose")
    public void setBtnClose(Button btnClose) {
        this.btnClose = btnClose;
    }

    /*
     * gettxtHiddenHihokenshaNo
     * @return txtHiddenHihokenshaNo
     */
    @JsonProperty("txtHiddenHihokenshaNo")
    public RString getTxtHiddenHihokenshaNo() {
        return txtHiddenHihokenshaNo;
    }

    /*
     * settxtHiddenHihokenshaNo
     * @param txtHiddenHihokenshaNo txtHiddenHihokenshaNo
     */
    @JsonProperty("txtHiddenHihokenshaNo")
    public void setTxtHiddenHihokenshaNo(RString txtHiddenHihokenshaNo) {
        this.txtHiddenHihokenshaNo = txtHiddenHihokenshaNo;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public RadioButton getRadHaigushaUmu() {
        return this.getFutanGendogakuNinteiDetail().getHaigushaJoho().getRadHaigushaUmu();
    }

    @JsonIgnore
    public void  setRadHaigushaUmu(RadioButton radHaigushaUmu) {
        this.getFutanGendogakuNinteiDetail().getHaigushaJoho().setRadHaigushaUmu(radHaigushaUmu);
    }

    @JsonIgnore
    public TextBoxShikibetsuCode getTxtShikibetsuCode() {
        return this.getFutanGendogakuNinteiDetail().getHaigushaJoho().getTxtShikibetsuCode();
    }

    @JsonIgnore
    public void  setTxtShikibetsuCode(TextBoxShikibetsuCode txtShikibetsuCode) {
        this.getFutanGendogakuNinteiDetail().getHaigushaJoho().setTxtShikibetsuCode(txtShikibetsuCode);
    }

    @JsonIgnore
    public TextBox getTxtShimeiKana() {
        return this.getFutanGendogakuNinteiDetail().getHaigushaJoho().getTxtShimeiKana();
    }

    @JsonIgnore
    public void  setTxtShimeiKana(TextBox txtShimeiKana) {
        this.getFutanGendogakuNinteiDetail().getHaigushaJoho().setTxtShimeiKana(txtShimeiKana);
    }

    @JsonIgnore
    public TextBox getTxtShimei() {
        return this.getFutanGendogakuNinteiDetail().getHaigushaJoho().getTxtShimei();
    }

    @JsonIgnore
    public void  setTxtShimei(TextBox txtShimei) {
        this.getFutanGendogakuNinteiDetail().getHaigushaJoho().setTxtShimei(txtShimei);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtBirthday() {
        return this.getFutanGendogakuNinteiDetail().getHaigushaJoho().getTxtBirthday();
    }

    @JsonIgnore
    public void  setTxtBirthday(TextBoxFlexibleDate txtBirthday) {
        this.getFutanGendogakuNinteiDetail().getHaigushaJoho().setTxtBirthday(txtBirthday);
    }

    @JsonIgnore
    public TextBoxTelNo getTxtRenrakusaki() {
        return this.getFutanGendogakuNinteiDetail().getHaigushaJoho().getTxtRenrakusaki();
    }

    @JsonIgnore
    public void  setTxtRenrakusaki(TextBoxTelNo txtRenrakusaki) {
        this.getFutanGendogakuNinteiDetail().getHaigushaJoho().setTxtRenrakusaki(txtRenrakusaki);
    }

    @JsonIgnore
    public TextBoxJusho getTxtJusho1() {
        return this.getFutanGendogakuNinteiDetail().getHaigushaJoho().getTxtJusho1();
    }

    @JsonIgnore
    public void  setTxtJusho1(TextBoxJusho txtJusho1) {
        this.getFutanGendogakuNinteiDetail().getHaigushaJoho().setTxtJusho1(txtJusho1);
    }

    @JsonIgnore
    public Label getLblGenjusho1() {
        return this.getFutanGendogakuNinteiDetail().getHaigushaJoho().getLblGenjusho1();
    }

    @JsonIgnore
    public void  setLblGenjusho1(Label lblGenjusho1) {
        this.getFutanGendogakuNinteiDetail().getHaigushaJoho().setLblGenjusho1(lblGenjusho1);
    }

    @JsonIgnore
    public TextBoxJusho getTxtGenjusho() {
        return this.getFutanGendogakuNinteiDetail().getHaigushaJoho().getTxtGenjusho();
    }

    @JsonIgnore
    public void  setTxtGenjusho(TextBoxJusho txtGenjusho) {
        this.getFutanGendogakuNinteiDetail().getHaigushaJoho().setTxtGenjusho(txtGenjusho);
    }

    @JsonIgnore
    public RadioButton getRadKazeiKubun() {
        return this.getFutanGendogakuNinteiDetail().getHaigushaJoho().getRadKazeiKubun();
    }

    @JsonIgnore
    public void  setRadKazeiKubun(RadioButton radKazeiKubun) {
        this.getFutanGendogakuNinteiDetail().getHaigushaJoho().setRadKazeiKubun(radKazeiKubun);
    }

    @JsonIgnore
    public CheckBoxList getChkYochokin() {
        return this.getFutanGendogakuNinteiDetail().getYochokinjoho().getChkYochokin();
    }

    @JsonIgnore
    public void  setChkYochokin(CheckBoxList chkYochokin) {
        this.getFutanGendogakuNinteiDetail().getYochokinjoho().setChkYochokin(chkYochokin);
    }

    @JsonIgnore
    public TextBoxNum getTxtYochokin() {
        return this.getFutanGendogakuNinteiDetail().getYochokinjoho().getTxtYochokin();
    }

    @JsonIgnore
    public void  setTxtYochokin(TextBoxNum txtYochokin) {
        this.getFutanGendogakuNinteiDetail().getYochokinjoho().setTxtYochokin(txtYochokin);
    }

    @JsonIgnore
    public TextBoxNum getTxtYukaShoken() {
        return this.getFutanGendogakuNinteiDetail().getYochokinjoho().getTxtYukaShoken();
    }

    @JsonIgnore
    public void  setTxtYukaShoken(TextBoxNum txtYukaShoken) {
        this.getFutanGendogakuNinteiDetail().getYochokinjoho().setTxtYukaShoken(txtYukaShoken);
    }

    @JsonIgnore
    public TextBoxNum getTxtSonota() {
        return this.getFutanGendogakuNinteiDetail().getYochokinjoho().getTxtSonota();
    }

    @JsonIgnore
    public void  setTxtSonota(TextBoxNum txtSonota) {
        this.getFutanGendogakuNinteiDetail().getYochokinjoho().setTxtSonota(txtSonota);
    }

    // </editor-fold>
    //--------------- この行より下にコードを追加してください -------------------

}
