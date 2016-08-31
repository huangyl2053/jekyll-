package jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB3140001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.chikushichosonselect.ChikuShichosonSelect.ChikuShichosonSelectDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.chikushichosonselect.ChikuShichosonSelect.IChikuShichosonSelectDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * IkkatsuGenmen のクラスファイル 
 * 
 * @author 自動生成
 */
public class IkkatsuGenmenDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-07-28_11-34-20">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("IkkatsuGenmenBatchParameter")
    private IkkatsuGenmenBatchParameterDiv IkkatsuGenmenBatchParameter;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getIkkatsuGenmenBatchParameter
     * @return IkkatsuGenmenBatchParameter
     */
    @JsonProperty("IkkatsuGenmenBatchParameter")
    public IkkatsuGenmenBatchParameterDiv getIkkatsuGenmenBatchParameter() {
        return IkkatsuGenmenBatchParameter;
    }

    /*
     * setIkkatsuGenmenBatchParameter
     * @param IkkatsuGenmenBatchParameter IkkatsuGenmenBatchParameter
     */
    @JsonProperty("IkkatsuGenmenBatchParameter")
    public void setIkkatsuGenmenBatchParameter(IkkatsuGenmenBatchParameterDiv IkkatsuGenmenBatchParameter) {
        this.IkkatsuGenmenBatchParameter = IkkatsuGenmenBatchParameter;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public ShoriTaishoNendoDiv getShoriTaishoNendo() {
        return this.getIkkatsuGenmenBatchParameter().getShoriTaishoNendo();
    }

    @JsonIgnore
    public void  setShoriTaishoNendo(ShoriTaishoNendoDiv ShoriTaishoNendo) {
        this.getIkkatsuGenmenBatchParameter().setShoriTaishoNendo(ShoriTaishoNendo);
    }

    @JsonIgnore
    public TextBoxDate getTxtChoteiNendo() {
        return this.getIkkatsuGenmenBatchParameter().getShoriTaishoNendo().getTxtChoteiNendo();
    }

    @JsonIgnore
    public void  setTxtChoteiNendo(TextBoxDate txtChoteiNendo) {
        this.getIkkatsuGenmenBatchParameter().getShoriTaishoNendo().setTxtChoteiNendo(txtChoteiNendo);
    }

    @JsonIgnore
    public TextBoxDate getTxtFukaNendo() {
        return this.getIkkatsuGenmenBatchParameter().getShoriTaishoNendo().getTxtFukaNendo();
    }

    @JsonIgnore
    public void  setTxtFukaNendo(TextBoxDate txtFukaNendo) {
        this.getIkkatsuGenmenBatchParameter().getShoriTaishoNendo().setTxtFukaNendo(txtFukaNendo);
    }

    @JsonIgnore
    public ShoriJotaiDiv getShoriJotai() {
        return this.getIkkatsuGenmenBatchParameter().getShoriJotai();
    }

    @JsonIgnore
    public void  setShoriJotai(ShoriJotaiDiv ShoriJotai) {
        this.getIkkatsuGenmenBatchParameter().setShoriJotai(ShoriJotai);
    }

    @JsonIgnore
    public DataGrid<dgShoriJotai_Row> getDgShoriJotai() {
        return this.getIkkatsuGenmenBatchParameter().getShoriJotai().getDgShoriJotai();
    }

    @JsonIgnore
    public void  setDgShoriJotai(DataGrid<dgShoriJotai_Row> dgShoriJotai) {
        this.getIkkatsuGenmenBatchParameter().getShoriJotai().setDgShoriJotai(dgShoriJotai);
    }

    @JsonIgnore
    public HorizontalLine getLin1() {
        return this.getIkkatsuGenmenBatchParameter().getLin1();
    }

    @JsonIgnore
    public void  setLin1(HorizontalLine lin1) {
        this.getIkkatsuGenmenBatchParameter().setLin1(lin1);
    }

    @JsonIgnore
    public GenmenJohoDiv getGenmenJoho() {
        return this.getIkkatsuGenmenBatchParameter().getGenmenJoho();
    }

    @JsonIgnore
    public void  setGenmenJoho(GenmenJohoDiv GenmenJoho) {
        this.getIkkatsuGenmenBatchParameter().setGenmenJoho(GenmenJoho);
    }

    @JsonIgnore
    public TextBoxDate getTxtShinseiYMD() {
        return this.getIkkatsuGenmenBatchParameter().getGenmenJoho().getTxtShinseiYMD();
    }

    @JsonIgnore
    public void  setTxtShinseiYMD(TextBoxDate txtShinseiYMD) {
        this.getIkkatsuGenmenBatchParameter().getGenmenJoho().setTxtShinseiYMD(txtShinseiYMD);
    }

    @JsonIgnore
    public TextBoxDate getTxtUketsukeiYMD() {
        return this.getIkkatsuGenmenBatchParameter().getGenmenJoho().getTxtUketsukeiYMD();
    }

    @JsonIgnore
    public void  setTxtUketsukeiYMD(TextBoxDate txtUketsukeiYMD) {
        this.getIkkatsuGenmenBatchParameter().getGenmenJoho().setTxtUketsukeiYMD(txtUketsukeiYMD);
    }

    @JsonIgnore
    public Button getBtnGemmenShurui() {
        return this.getIkkatsuGenmenBatchParameter().getGenmenJoho().getBtnGemmenShurui();
    }

    @JsonIgnore
    public void  setBtnGemmenShurui(Button btnGemmenShurui) {
        this.getIkkatsuGenmenBatchParameter().getGenmenJoho().setBtnGemmenShurui(btnGemmenShurui);
    }

    @JsonIgnore
    public TextBox getTxtGemmenShurui() {
        return this.getIkkatsuGenmenBatchParameter().getGenmenJoho().getTxtGemmenShurui();
    }

    @JsonIgnore
    public void  setTxtGemmenShurui(TextBox txtGemmenShurui) {
        this.getIkkatsuGenmenBatchParameter().getGenmenJoho().setTxtGemmenShurui(txtGemmenShurui);
    }

    @JsonIgnore
    public TextBoxNum getTxtGenmenRitsu() {
        return this.getIkkatsuGenmenBatchParameter().getGenmenJoho().getTxtGenmenRitsu();
    }

    @JsonIgnore
    public void  setTxtGenmenRitsu(TextBoxNum txtGenmenRitsu) {
        this.getIkkatsuGenmenBatchParameter().getGenmenJoho().setTxtGenmenRitsu(txtGenmenRitsu);
    }

    @JsonIgnore
    public Label getLblPercent() {
        return this.getIkkatsuGenmenBatchParameter().getGenmenJoho().getLblPercent();
    }

    @JsonIgnore
    public void  setLblPercent(Label lblPercent) {
        this.getIkkatsuGenmenBatchParameter().getGenmenJoho().setLblPercent(lblPercent);
    }

    @JsonIgnore
    public TextBoxMultiLine getTxtShinseiRiyu() {
        return this.getIkkatsuGenmenBatchParameter().getGenmenJoho().getTxtShinseiRiyu();
    }

    @JsonIgnore
    public void  setTxtShinseiRiyu(TextBoxMultiLine txtShinseiRiyu) {
        this.getIkkatsuGenmenBatchParameter().getGenmenJoho().setTxtShinseiRiyu(txtShinseiRiyu);
    }

    @JsonIgnore
    public KetteiJohoDiv getKetteiJoho() {
        return this.getIkkatsuGenmenBatchParameter().getKetteiJoho();
    }

    @JsonIgnore
    public void  setKetteiJoho(KetteiJohoDiv KetteiJoho) {
        this.getIkkatsuGenmenBatchParameter().setKetteiJoho(KetteiJoho);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtKetteiYMD() {
        return this.getIkkatsuGenmenBatchParameter().getKetteiJoho().getTxtKetteiYMD();
    }

    @JsonIgnore
    public void  setTxtKetteiYMD(TextBoxFlexibleDate txtKetteiYMD) {
        this.getIkkatsuGenmenBatchParameter().getKetteiJoho().setTxtKetteiYMD(txtKetteiYMD);
    }

    @JsonIgnore
    public TextBoxMultiLine getTxtKetteiRiyu() {
        return this.getIkkatsuGenmenBatchParameter().getKetteiJoho().getTxtKetteiRiyu();
    }

    @JsonIgnore
    public void  setTxtKetteiRiyu(TextBoxMultiLine txtKetteiRiyu) {
        this.getIkkatsuGenmenBatchParameter().getKetteiJoho().setTxtKetteiRiyu(txtKetteiRiyu);
    }

    @JsonIgnore
    public IChikuShichosonSelectDiv getCcdChikuShichosonSelect() {
        return this.getIkkatsuGenmenBatchParameter().getCcdChikuShichosonSelect();
    }

    // </editor-fold>
}
