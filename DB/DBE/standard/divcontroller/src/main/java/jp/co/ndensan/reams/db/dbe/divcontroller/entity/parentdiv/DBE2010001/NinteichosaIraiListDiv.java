package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2010001;
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
 * NinteichosaIraiList のクラスファイル 
 * 
 * @author 自動生成
 */
public class NinteichosaIraiListDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-11-29_19-09-25">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("chosairaitaishoshaichiran")
    private chosairaitaishoshaichiranDiv chosairaitaishoshaichiran;
    @JsonProperty("btndataoutput")
    private ButtonDownLoad btndataoutput;
    @JsonProperty("btniraiauto")
    private Button btniraiauto;
    @JsonProperty("btnTaOutput")
    private ButtonDialog btnTaOutput;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getchosairaitaishoshaichiran
     * @return chosairaitaishoshaichiran
     */
    @JsonProperty("chosairaitaishoshaichiran")
    public chosairaitaishoshaichiranDiv getChosairaitaishoshaichiran() {
        return chosairaitaishoshaichiran;
    }

    /*
     * setchosairaitaishoshaichiran
     * @param chosairaitaishoshaichiran chosairaitaishoshaichiran
     */
    @JsonProperty("chosairaitaishoshaichiran")
    public void setChosairaitaishoshaichiran(chosairaitaishoshaichiranDiv chosairaitaishoshaichiran) {
        this.chosairaitaishoshaichiran = chosairaitaishoshaichiran;
    }

    /*
     * getbtndataoutput
     * @return btndataoutput
     */
    @JsonProperty("btndataoutput")
    public ButtonDownLoad getBtndataoutput() {
        return btndataoutput;
    }

    /*
     * setbtndataoutput
     * @param btndataoutput btndataoutput
     */
    @JsonProperty("btndataoutput")
    public void setBtndataoutput(ButtonDownLoad btndataoutput) {
        this.btndataoutput = btndataoutput;
    }

    /*
     * getbtniraiauto
     * @return btniraiauto
     */
    @JsonProperty("btniraiauto")
    public Button getBtniraiauto() {
        return btniraiauto;
    }

    /*
     * setbtniraiauto
     * @param btniraiauto btniraiauto
     */
    @JsonProperty("btniraiauto")
    public void setBtniraiauto(Button btniraiauto) {
        this.btniraiauto = btniraiauto;
    }

    /*
     * getbtnTaOutput
     * @return btnTaOutput
     */
    @JsonProperty("btnTaOutput")
    public ButtonDialog getBtnTaOutput() {
        return btnTaOutput;
    }

    /*
     * setbtnTaOutput
     * @param btnTaOutput btnTaOutput
     */
    @JsonProperty("btnTaOutput")
    public void setBtnTaOutput(ButtonDialog btnTaOutput) {
        this.btnTaOutput = btnTaOutput;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public RadioButton getRadShoriJyotai() {
        return this.getChosairaitaishoshaichiran().getRadShoriJyotai();
    }

    @JsonIgnore
    public void  setRadShoriJyotai(RadioButton radShoriJyotai) {
        this.getChosairaitaishoshaichiran().setRadShoriJyotai(radShoriJyotai);
    }

    @JsonIgnore
    public TextBoxNum getTxtTotalCount() {
        return this.getChosairaitaishoshaichiran().getTxtTotalCount();
    }

    @JsonIgnore
    public void  setTxtTotalCount(TextBoxNum txtTotalCount) {
        this.getChosairaitaishoshaichiran().setTxtTotalCount(txtTotalCount);
    }

    @JsonIgnore
    public TextBoxNum getTxtCompleteCount() {
        return this.getChosairaitaishoshaichiran().getTxtCompleteCount();
    }

    @JsonIgnore
    public void  setTxtCompleteCount(TextBoxNum txtCompleteCount) {
        this.getChosairaitaishoshaichiran().setTxtCompleteCount(txtCompleteCount);
    }

    @JsonIgnore
    public TextBoxNum getTxtNoUpdate() {
        return this.getChosairaitaishoshaichiran().getTxtNoUpdate();
    }

    @JsonIgnore
    public void  setTxtNoUpdate(TextBoxNum txtNoUpdate) {
        this.getChosairaitaishoshaichiran().setTxtNoUpdate(txtNoUpdate);
    }

    @JsonIgnore
    public BatchParamPanelDiv getBatchParamPanel() {
        return this.getChosairaitaishoshaichiran().getBatchParamPanel();
    }

    @JsonIgnore
    public void  setBatchParamPanel(BatchParamPanelDiv BatchParamPanel) {
        this.getChosairaitaishoshaichiran().setBatchParamPanel(BatchParamPanel);
    }

    @JsonIgnore
    public DataGrid<dgNinteiTaskList_Row> getDgNinteiTaskList() {
        return this.getChosairaitaishoshaichiran().getBatchParamPanel().getDgNinteiTaskList();
    }

    @JsonIgnore
    public void  setDgNinteiTaskList(DataGrid<dgNinteiTaskList_Row> dgNinteiTaskList) {
        this.getChosairaitaishoshaichiran().getBatchParamPanel().setDgNinteiTaskList(dgNinteiTaskList);
    }

    @JsonIgnore
    public TextBoxNum getTxtMaxCount() {
        return this.getChosairaitaishoshaichiran().getTxtMaxCount();
    }

    @JsonIgnore
    public void  setTxtMaxCount(TextBoxNum txtMaxCount) {
        this.getChosairaitaishoshaichiran().setTxtMaxCount(txtMaxCount);
    }

    @JsonIgnore
    public IHokenshaListDiv getCcdHokenshaList() {
        return this.getChosairaitaishoshaichiran().getCcdHokenshaList();
    }

    // </editor-fold>
}
