package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5140002;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * ShinsakaiIinWaritsuke のクラスファイル 
 * 
 * @author 自動生成
 */
public class ShinsakaiIinWaritsukeDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：バージョン情報無し">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtKaigoNinteiShinsakai")
    private TextBox txtKaigoNinteiShinsakai;
    @JsonProperty("txtGogitai")
    private TextBox txtGogitai;
    @JsonProperty("txtKaishiYoteiTime")
    private TextBoxTime txtKaishiYoteiTime;
    @JsonProperty("chkDummyKubun")
    private CheckBoxList chkDummyKubun;
    @JsonProperty("txtKaisaiYoteibi")
    private TextBoxDate txtKaisaiYoteibi;
    @JsonProperty("txtKaisaiBasho")
    private TextBox txtKaisaiBasho;
    @JsonProperty("txtShuryoYoteiTime")
    private TextBoxTime txtShuryoYoteiTime;
    @JsonProperty("txtYoteiTeiin")
    private TextBox txtYoteiTeiin;
    @JsonProperty("chkSeishinkai")
    private CheckBoxList chkSeishinkai;
    @JsonProperty("lblShinsakaiIinKoseiIchiran")
    private Label lblShinsakaiIinKoseiIchiran;
    @JsonProperty("dgShinsakaiIinKoseiIchiran")
    private DataGrid<dgShinsakaiIinKoseiIchiran_Row> dgShinsakaiIinKoseiIchiran;
    @JsonProperty("btnKoseiIchiranWaritsuke")
    private Button btnKoseiIchiranWaritsuke;
    @JsonProperty("btnKoseiIchiranKaijo")
    private Button btnKoseiIchiranKaijo;
    @JsonProperty("lblShinsakaiIinIchiran")
    private Label lblShinsakaiIinIchiran;
    @JsonProperty("btnZentaiHyoji")
    private Button btnZentaiHyoji;
    @JsonProperty("dgShinsakaiIinIchiran")
    private DataGrid<dgShinsakaiIinIchiran_Row> dgShinsakaiIinIchiran;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtKaigoNinteiShinsakai
     * @return txtKaigoNinteiShinsakai
     */
    @JsonProperty("txtKaigoNinteiShinsakai")
    public TextBox getTxtKaigoNinteiShinsakai() {
        return txtKaigoNinteiShinsakai;
    }

    /*
     * settxtKaigoNinteiShinsakai
     * @param txtKaigoNinteiShinsakai txtKaigoNinteiShinsakai
     */
    @JsonProperty("txtKaigoNinteiShinsakai")
    public void setTxtKaigoNinteiShinsakai(TextBox txtKaigoNinteiShinsakai) {
        this.txtKaigoNinteiShinsakai = txtKaigoNinteiShinsakai;
    }

    /*
     * gettxtGogitai
     * @return txtGogitai
     */
    @JsonProperty("txtGogitai")
    public TextBox getTxtGogitai() {
        return txtGogitai;
    }

    /*
     * settxtGogitai
     * @param txtGogitai txtGogitai
     */
    @JsonProperty("txtGogitai")
    public void setTxtGogitai(TextBox txtGogitai) {
        this.txtGogitai = txtGogitai;
    }

    /*
     * gettxtKaishiYoteiTime
     * @return txtKaishiYoteiTime
     */
    @JsonProperty("txtKaishiYoteiTime")
    public TextBoxTime getTxtKaishiYoteiTime() {
        return txtKaishiYoteiTime;
    }

    /*
     * settxtKaishiYoteiTime
     * @param txtKaishiYoteiTime txtKaishiYoteiTime
     */
    @JsonProperty("txtKaishiYoteiTime")
    public void setTxtKaishiYoteiTime(TextBoxTime txtKaishiYoteiTime) {
        this.txtKaishiYoteiTime = txtKaishiYoteiTime;
    }

    /*
     * getchkDummyKubun
     * @return chkDummyKubun
     */
    @JsonProperty("chkDummyKubun")
    public CheckBoxList getChkDummyKubun() {
        return chkDummyKubun;
    }

    /*
     * setchkDummyKubun
     * @param chkDummyKubun chkDummyKubun
     */
    @JsonProperty("chkDummyKubun")
    public void setChkDummyKubun(CheckBoxList chkDummyKubun) {
        this.chkDummyKubun = chkDummyKubun;
    }

    /*
     * gettxtKaisaiYoteibi
     * @return txtKaisaiYoteibi
     */
    @JsonProperty("txtKaisaiYoteibi")
    public TextBoxDate getTxtKaisaiYoteibi() {
        return txtKaisaiYoteibi;
    }

    /*
     * settxtKaisaiYoteibi
     * @param txtKaisaiYoteibi txtKaisaiYoteibi
     */
    @JsonProperty("txtKaisaiYoteibi")
    public void setTxtKaisaiYoteibi(TextBoxDate txtKaisaiYoteibi) {
        this.txtKaisaiYoteibi = txtKaisaiYoteibi;
    }

    /*
     * gettxtKaisaiBasho
     * @return txtKaisaiBasho
     */
    @JsonProperty("txtKaisaiBasho")
    public TextBox getTxtKaisaiBasho() {
        return txtKaisaiBasho;
    }

    /*
     * settxtKaisaiBasho
     * @param txtKaisaiBasho txtKaisaiBasho
     */
    @JsonProperty("txtKaisaiBasho")
    public void setTxtKaisaiBasho(TextBox txtKaisaiBasho) {
        this.txtKaisaiBasho = txtKaisaiBasho;
    }

    /*
     * gettxtShuryoYoteiTime
     * @return txtShuryoYoteiTime
     */
    @JsonProperty("txtShuryoYoteiTime")
    public TextBoxTime getTxtShuryoYoteiTime() {
        return txtShuryoYoteiTime;
    }

    /*
     * settxtShuryoYoteiTime
     * @param txtShuryoYoteiTime txtShuryoYoteiTime
     */
    @JsonProperty("txtShuryoYoteiTime")
    public void setTxtShuryoYoteiTime(TextBoxTime txtShuryoYoteiTime) {
        this.txtShuryoYoteiTime = txtShuryoYoteiTime;
    }

    /*
     * gettxtYoteiTeiin
     * @return txtYoteiTeiin
     */
    @JsonProperty("txtYoteiTeiin")
    public TextBox getTxtYoteiTeiin() {
        return txtYoteiTeiin;
    }

    /*
     * settxtYoteiTeiin
     * @param txtYoteiTeiin txtYoteiTeiin
     */
    @JsonProperty("txtYoteiTeiin")
    public void setTxtYoteiTeiin(TextBox txtYoteiTeiin) {
        this.txtYoteiTeiin = txtYoteiTeiin;
    }

    /*
     * getchkSeishinkai
     * @return chkSeishinkai
     */
    @JsonProperty("chkSeishinkai")
    public CheckBoxList getChkSeishinkai() {
        return chkSeishinkai;
    }

    /*
     * setchkSeishinkai
     * @param chkSeishinkai chkSeishinkai
     */
    @JsonProperty("chkSeishinkai")
    public void setChkSeishinkai(CheckBoxList chkSeishinkai) {
        this.chkSeishinkai = chkSeishinkai;
    }

    /*
     * getlblShinsakaiIinKoseiIchiran
     * @return lblShinsakaiIinKoseiIchiran
     */
    @JsonProperty("lblShinsakaiIinKoseiIchiran")
    public Label getLblShinsakaiIinKoseiIchiran() {
        return lblShinsakaiIinKoseiIchiran;
    }

    /*
     * setlblShinsakaiIinKoseiIchiran
     * @param lblShinsakaiIinKoseiIchiran lblShinsakaiIinKoseiIchiran
     */
    @JsonProperty("lblShinsakaiIinKoseiIchiran")
    public void setLblShinsakaiIinKoseiIchiran(Label lblShinsakaiIinKoseiIchiran) {
        this.lblShinsakaiIinKoseiIchiran = lblShinsakaiIinKoseiIchiran;
    }

    /*
     * getdgShinsakaiIinKoseiIchiran
     * @return dgShinsakaiIinKoseiIchiran
     */
    @JsonProperty("dgShinsakaiIinKoseiIchiran")
    public DataGrid<dgShinsakaiIinKoseiIchiran_Row> getDgShinsakaiIinKoseiIchiran() {
        return dgShinsakaiIinKoseiIchiran;
    }

    /*
     * setdgShinsakaiIinKoseiIchiran
     * @param dgShinsakaiIinKoseiIchiran dgShinsakaiIinKoseiIchiran
     */
    @JsonProperty("dgShinsakaiIinKoseiIchiran")
    public void setDgShinsakaiIinKoseiIchiran(DataGrid<dgShinsakaiIinKoseiIchiran_Row> dgShinsakaiIinKoseiIchiran) {
        this.dgShinsakaiIinKoseiIchiran = dgShinsakaiIinKoseiIchiran;
    }

    /*
     * getbtnKoseiIchiranWaritsuke
     * @return btnKoseiIchiranWaritsuke
     */
    @JsonProperty("btnKoseiIchiranWaritsuke")
    public Button getBtnKoseiIchiranWaritsuke() {
        return btnKoseiIchiranWaritsuke;
    }

    /*
     * setbtnKoseiIchiranWaritsuke
     * @param btnKoseiIchiranWaritsuke btnKoseiIchiranWaritsuke
     */
    @JsonProperty("btnKoseiIchiranWaritsuke")
    public void setBtnKoseiIchiranWaritsuke(Button btnKoseiIchiranWaritsuke) {
        this.btnKoseiIchiranWaritsuke = btnKoseiIchiranWaritsuke;
    }

    /*
     * getbtnKoseiIchiranKaijo
     * @return btnKoseiIchiranKaijo
     */
    @JsonProperty("btnKoseiIchiranKaijo")
    public Button getBtnKoseiIchiranKaijo() {
        return btnKoseiIchiranKaijo;
    }

    /*
     * setbtnKoseiIchiranKaijo
     * @param btnKoseiIchiranKaijo btnKoseiIchiranKaijo
     */
    @JsonProperty("btnKoseiIchiranKaijo")
    public void setBtnKoseiIchiranKaijo(Button btnKoseiIchiranKaijo) {
        this.btnKoseiIchiranKaijo = btnKoseiIchiranKaijo;
    }

    /*
     * getlblShinsakaiIinIchiran
     * @return lblShinsakaiIinIchiran
     */
    @JsonProperty("lblShinsakaiIinIchiran")
    public Label getLblShinsakaiIinIchiran() {
        return lblShinsakaiIinIchiran;
    }

    /*
     * setlblShinsakaiIinIchiran
     * @param lblShinsakaiIinIchiran lblShinsakaiIinIchiran
     */
    @JsonProperty("lblShinsakaiIinIchiran")
    public void setLblShinsakaiIinIchiran(Label lblShinsakaiIinIchiran) {
        this.lblShinsakaiIinIchiran = lblShinsakaiIinIchiran;
    }

    /*
     * getbtnZentaiHyoji
     * @return btnZentaiHyoji
     */
    @JsonProperty("btnZentaiHyoji")
    public Button getBtnZentaiHyoji() {
        return btnZentaiHyoji;
    }

    /*
     * setbtnZentaiHyoji
     * @param btnZentaiHyoji btnZentaiHyoji
     */
    @JsonProperty("btnZentaiHyoji")
    public void setBtnZentaiHyoji(Button btnZentaiHyoji) {
        this.btnZentaiHyoji = btnZentaiHyoji;
    }

    /*
     * getdgShinsakaiIinIchiran
     * @return dgShinsakaiIinIchiran
     */
    @JsonProperty("dgShinsakaiIinIchiran")
    public DataGrid<dgShinsakaiIinIchiran_Row> getDgShinsakaiIinIchiran() {
        return dgShinsakaiIinIchiran;
    }

    /*
     * setdgShinsakaiIinIchiran
     * @param dgShinsakaiIinIchiran dgShinsakaiIinIchiran
     */
    @JsonProperty("dgShinsakaiIinIchiran")
    public void setDgShinsakaiIinIchiran(DataGrid<dgShinsakaiIinIchiran_Row> dgShinsakaiIinIchiran) {
        this.dgShinsakaiIinIchiran = dgShinsakaiIinIchiran;
    }

    // </editor-fold>
}
