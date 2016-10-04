package jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD3020003;
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
 * JikoKisambi のクラスファイル 
 * 
 * @author 自動生成
 */
public class JikoKisambiDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("chkZengyoHyoji")
    private CheckBoxList chkZengyoHyoji;
    @JsonProperty("lblHokenryoTitle")
    private Label lblHokenryoTitle;
    @JsonProperty("dgJikoKisambi")
    private DataGrid<dgJikoKisambi_Row> dgJikoKisambi;
    @JsonProperty("JikoKisaibiFukusha")
    private JikoKisaibiFukushaDiv JikoKisaibiFukusha;
    @JsonProperty("tblHanrei")
    private tblHanreiDiv tblHanrei;
    @JsonProperty("btnKakutei")
    private Button btnKakutei;
    @JsonProperty("btnClear")
    private Button btnClear;
    @JsonProperty("btnTorikeshi")
    private Button btnTorikeshi;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getchkZengyoHyoji
     * @return chkZengyoHyoji
     */
    @JsonProperty("chkZengyoHyoji")
    public CheckBoxList getChkZengyoHyoji() {
        return chkZengyoHyoji;
    }

    /*
     * setchkZengyoHyoji
     * @param chkZengyoHyoji chkZengyoHyoji
     */
    @JsonProperty("chkZengyoHyoji")
    public void setChkZengyoHyoji(CheckBoxList chkZengyoHyoji) {
        this.chkZengyoHyoji = chkZengyoHyoji;
    }

    /*
     * getlblHokenryoTitle
     * @return lblHokenryoTitle
     */
    @JsonProperty("lblHokenryoTitle")
    public Label getLblHokenryoTitle() {
        return lblHokenryoTitle;
    }

    /*
     * setlblHokenryoTitle
     * @param lblHokenryoTitle lblHokenryoTitle
     */
    @JsonProperty("lblHokenryoTitle")
    public void setLblHokenryoTitle(Label lblHokenryoTitle) {
        this.lblHokenryoTitle = lblHokenryoTitle;
    }

    /*
     * getdgJikoKisambi
     * @return dgJikoKisambi
     */
    @JsonProperty("dgJikoKisambi")
    public DataGrid<dgJikoKisambi_Row> getDgJikoKisambi() {
        return dgJikoKisambi;
    }

    /*
     * setdgJikoKisambi
     * @param dgJikoKisambi dgJikoKisambi
     */
    @JsonProperty("dgJikoKisambi")
    public void setDgJikoKisambi(DataGrid<dgJikoKisambi_Row> dgJikoKisambi) {
        this.dgJikoKisambi = dgJikoKisambi;
    }

    /*
     * getJikoKisaibiFukusha
     * @return JikoKisaibiFukusha
     */
    @JsonProperty("JikoKisaibiFukusha")
    public JikoKisaibiFukushaDiv getJikoKisaibiFukusha() {
        return JikoKisaibiFukusha;
    }

    /*
     * setJikoKisaibiFukusha
     * @param JikoKisaibiFukusha JikoKisaibiFukusha
     */
    @JsonProperty("JikoKisaibiFukusha")
    public void setJikoKisaibiFukusha(JikoKisaibiFukushaDiv JikoKisaibiFukusha) {
        this.JikoKisaibiFukusha = JikoKisaibiFukusha;
    }

    /*
     * gettblHanrei
     * @return tblHanrei
     */
    @JsonProperty("tblHanrei")
    public tblHanreiDiv getTblHanrei() {
        return tblHanrei;
    }

    /*
     * settblHanrei
     * @param tblHanrei tblHanrei
     */
    @JsonProperty("tblHanrei")
    public void setTblHanrei(tblHanreiDiv tblHanrei) {
        this.tblHanrei = tblHanrei;
    }

    /*
     * getbtnKakutei
     * @return btnKakutei
     */
    @JsonProperty("btnKakutei")
    public Button getBtnKakutei() {
        return btnKakutei;
    }

    /*
     * setbtnKakutei
     * @param btnKakutei btnKakutei
     */
    @JsonProperty("btnKakutei")
    public void setBtnKakutei(Button btnKakutei) {
        this.btnKakutei = btnKakutei;
    }

    /*
     * getbtnClear
     * @return btnClear
     */
    @JsonProperty("btnClear")
    public Button getBtnClear() {
        return btnClear;
    }

    /*
     * setbtnClear
     * @param btnClear btnClear
     */
    @JsonProperty("btnClear")
    public void setBtnClear(Button btnClear) {
        this.btnClear = btnClear;
    }

    /*
     * getbtnTorikeshi
     * @return btnTorikeshi
     */
    @JsonProperty("btnTorikeshi")
    public Button getBtnTorikeshi() {
        return btnTorikeshi;
    }

    /*
     * setbtnTorikeshi
     * @param btnTorikeshi btnTorikeshi
     */
    @JsonProperty("btnTorikeshi")
    public void setBtnTorikeshi(Button btnTorikeshi) {
        this.btnTorikeshi = btnTorikeshi;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public TextBoxFlexibleDate getTxtTokushuJikoKisambi() {
        return this.getJikoKisaibiFukusha().getTxtTokushuJikoKisambi();
    }

    @JsonIgnore
    public void  setTxtTokushuJikoKisambi(TextBoxFlexibleDate txtTokushuJikoKisambi) {
        this.getJikoKisaibiFukusha().setTxtTokushuJikoKisambi(txtTokushuJikoKisambi);
    }

    @JsonIgnore
    public DropDownList getDdlFukushaJikoKisambiJiyu() {
        return this.getJikoKisaibiFukusha().getDdlFukushaJikoKisambiJiyu();
    }

    @JsonIgnore
    public void  setDdlFukushaJikoKisambiJiyu(DropDownList ddlFukushaJikoKisambiJiyu) {
        this.getJikoKisaibiFukusha().setDdlFukushaJikoKisambiJiyu(ddlFukushaJikoKisambiJiyu);
    }

    @JsonIgnore
    public Button getBtnIkkatsuFukusha() {
        return this.getJikoKisaibiFukusha().getBtnIkkatsuFukusha();
    }

    @JsonIgnore
    public void  setBtnIkkatsuFukusha(Button btnIkkatsuFukusha) {
        this.getJikoKisaibiFukusha().setBtnIkkatsuFukusha(btnIkkatsuFukusha);
    }

    @JsonIgnore
    public tblColorKannoDiv getTblColorKanno() {
        return this.getTblHanrei().getTblColorKanno();
    }

    @JsonIgnore
    public Label getLblDummyKanno() {
        return this.getTblHanrei().getTblColorKanno().getLblDummyKanno();
    }

    @JsonIgnore
    public Label getLblKanno() {
        return this.getTblHanrei().getLblKanno();
    }

    @JsonIgnore
    public tblColorMinoDiv getTblColorMino() {
        return this.getTblHanrei().getTblColorMino();
    }

    @JsonIgnore
    public Label getLblDummyMino() {
        return this.getTblHanrei().getTblColorMino().getLblDummyMino();
    }

    @JsonIgnore
    public Label getLblMino() {
        return this.getTblHanrei().getLblMino();
    }

    @JsonIgnore
    public tblColorJikoDiv getTblColorJiko() {
        return this.getTblHanrei().getTblColorJiko();
    }

    @JsonIgnore
    public Label getLblDummyJiko() {
        return this.getTblHanrei().getTblColorJiko().getLblDummyJiko();
    }

    @JsonIgnore
    public Label getLblJiko() {
        return this.getTblHanrei().getLblJiko();
    }

    @JsonIgnore
    public tblColorKanoDiv getTblColorKano() {
        return this.getTblHanrei().getTblColorKano();
    }

    @JsonIgnore
    public Label getLblDummyKano() {
        return this.getTblHanrei().getTblColorKano().getLblDummyKano();
    }

    @JsonIgnore
    public Label getLblKano() {
        return this.getTblHanrei().getLblKano();
    }

    @JsonIgnore
    public tblColorJikoTaishoGaiDiv getTblColorJikoTaishoGai() {
        return this.getTblHanrei().getTblColorJikoTaishoGai();
    }

    @JsonIgnore
    public Label getLblDummyJikoTaishoGai() {
        return this.getTblHanrei().getTblColorJikoTaishoGai().getLblDummyJikoTaishoGai();
    }

    @JsonIgnore
    public Label getLblJikoTaishoGai() {
        return this.getTblHanrei().getLblJikoTaishoGai();
    }

    // </editor-fold>
}
