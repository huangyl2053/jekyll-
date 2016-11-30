package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ShinsakaiJohoKojin.ShinsakaiJohoKojin;
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
import jp.co.ndensan.reams.db.dbz.divcontroller.handler.commonchilddiv.shinsakaijohokojin.ShinsakaiJohoKojinHandler;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGrid;
import jp.co.ndensan.reams.uz.uza.ui.binding.Label;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBox;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxCode;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxTime;

/**
 * ShinsakaiJohoKojin のクラスファイル
 *
 * @reamsid_L DBE-3000-070 zhengshukai
 */
public class ShinsakaiJohoKojinDiv extends Panel implements IShinsakaiJohoKojinDiv {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-09-23_20-45-52">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtShinsakaiNo")
    private TextBox txtShinsakaiNo;
    @JsonProperty("txtGogitaiName")
    private TextBox txtGogitaiName;
    @JsonProperty("txtShinsakaijoMeisho")
    private TextBox txtShinsakaijoMeisho;
    @JsonProperty("txtShinsakaijoChikuCode")
    private TextBoxCode txtShinsakaijoChikuCode;
    @JsonProperty("txtShinsakaijoChikuMeisho")
    private TextBox txtShinsakaijoChikuMeisho;
    @JsonProperty("txtShinsaKaishiDay")
    private TextBoxDate txtShinsaKaishiDay;
    @JsonProperty("txtShinsaKaishiTime")
    private TextBoxTime txtShinsaKaishiTime;
    @JsonProperty("txtShinsaShuryoTime")
    private TextBoxTime txtShinsaShuryoTime;
    @JsonProperty("txtShinsaTime")
    private TextBox txtShinsaTime;
    @JsonProperty("ShussekiIinJoho")
    private ShussekiIinJohoDiv ShussekiIinJoho;
    @JsonProperty("btnModoru")
    private Button btnModoru;
    @JsonProperty("hdnShinseishoKanriNo")
    private RString hdnShinseishoKanriNo;
    @JsonProperty("hdnShinsakaiKaisaiNo")
    private RString hdnShinsakaiKaisaiNo;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtShinsakaiNo
     * @return txtShinsakaiNo
     */
    @JsonProperty("txtShinsakaiNo")
    public TextBox getTxtShinsakaiNo() {
        return txtShinsakaiNo;
    }

    /*
     * settxtShinsakaiNo
     * @param txtShinsakaiNo txtShinsakaiNo
     */
    @JsonProperty("txtShinsakaiNo")
    public void setTxtShinsakaiNo(TextBox txtShinsakaiNo) {
        this.txtShinsakaiNo = txtShinsakaiNo;
    }

    /*
     * gettxtGogitaiName
     * @return txtGogitaiName
     */
    @JsonProperty("txtGogitaiName")
    public TextBox getTxtGogitaiName() {
        return txtGogitaiName;
    }

    /*
     * settxtGogitaiName
     * @param txtGogitaiName txtGogitaiName
     */
    @JsonProperty("txtGogitaiName")
    public void setTxtGogitaiName(TextBox txtGogitaiName) {
        this.txtGogitaiName = txtGogitaiName;
    }

    /*
     * gettxtShinsakaijoMeisho
     * @return txtShinsakaijoMeisho
     */
    @JsonProperty("txtShinsakaijoMeisho")
    public TextBox getTxtShinsakaijoMeisho() {
        return txtShinsakaijoMeisho;
    }

    /*
     * settxtShinsakaijoMeisho
     * @param txtShinsakaijoMeisho txtShinsakaijoMeisho
     */
    @JsonProperty("txtShinsakaijoMeisho")
    public void setTxtShinsakaijoMeisho(TextBox txtShinsakaijoMeisho) {
        this.txtShinsakaijoMeisho = txtShinsakaijoMeisho;
    }

    /*
     * gettxtShinsakaijoChikuCode
     * @return txtShinsakaijoChikuCode
     */
    @JsonProperty("txtShinsakaijoChikuCode")
    public TextBoxCode getTxtShinsakaijoChikuCode() {
        return txtShinsakaijoChikuCode;
    }

    /*
     * settxtShinsakaijoChikuCode
     * @param txtShinsakaijoChikuCode txtShinsakaijoChikuCode
     */
    @JsonProperty("txtShinsakaijoChikuCode")
    public void setTxtShinsakaijoChikuCode(TextBoxCode txtShinsakaijoChikuCode) {
        this.txtShinsakaijoChikuCode = txtShinsakaijoChikuCode;
    }

    /*
     * gettxtShinsakaijoChikuMeisho
     * @return txtShinsakaijoChikuMeisho
     */
    @JsonProperty("txtShinsakaijoChikuMeisho")
    public TextBox getTxtShinsakaijoChikuMeisho() {
        return txtShinsakaijoChikuMeisho;
    }

    /*
     * settxtShinsakaijoChikuMeisho
     * @param txtShinsakaijoChikuMeisho txtShinsakaijoChikuMeisho
     */
    @JsonProperty("txtShinsakaijoChikuMeisho")
    public void setTxtShinsakaijoChikuMeisho(TextBox txtShinsakaijoChikuMeisho) {
        this.txtShinsakaijoChikuMeisho = txtShinsakaijoChikuMeisho;
    }

    /*
     * gettxtShinsaKaishiDay
     * @return txtShinsaKaishiDay
     */
    @JsonProperty("txtShinsaKaishiDay")
    public TextBoxDate getTxtShinsaKaishiDay() {
        return txtShinsaKaishiDay;
    }

    /*
     * settxtShinsaKaishiDay
     * @param txtShinsaKaishiDay txtShinsaKaishiDay
     */
    @JsonProperty("txtShinsaKaishiDay")
    public void setTxtShinsaKaishiDay(TextBoxDate txtShinsaKaishiDay) {
        this.txtShinsaKaishiDay = txtShinsaKaishiDay;
    }

    /*
     * gettxtShinsaKaishiTime
     * @return txtShinsaKaishiTime
     */
    @JsonProperty("txtShinsaKaishiTime")
    public TextBoxTime getTxtShinsaKaishiTime() {
        return txtShinsaKaishiTime;
    }

    /*
     * settxtShinsaKaishiTime
     * @param txtShinsaKaishiTime txtShinsaKaishiTime
     */
    @JsonProperty("txtShinsaKaishiTime")
    public void setTxtShinsaKaishiTime(TextBoxTime txtShinsaKaishiTime) {
        this.txtShinsaKaishiTime = txtShinsaKaishiTime;
    }

    /*
     * gettxtShinsaShuryoTime
     * @return txtShinsaShuryoTime
     */
    @JsonProperty("txtShinsaShuryoTime")
    public TextBoxTime getTxtShinsaShuryoTime() {
        return txtShinsaShuryoTime;
    }

    /*
     * settxtShinsaShuryoTime
     * @param txtShinsaShuryoTime txtShinsaShuryoTime
     */
    @JsonProperty("txtShinsaShuryoTime")
    public void setTxtShinsaShuryoTime(TextBoxTime txtShinsaShuryoTime) {
        this.txtShinsaShuryoTime = txtShinsaShuryoTime;
    }

    /*
     * gettxtShinsaTime
     * @return txtShinsaTime
     */
    @JsonProperty("txtShinsaTime")
    public TextBox getTxtShinsaTime() {
        return txtShinsaTime;
    }

    /*
     * settxtShinsaTime
     * @param txtShinsaTime txtShinsaTime
     */
    @JsonProperty("txtShinsaTime")
    public void setTxtShinsaTime(TextBox txtShinsaTime) {
        this.txtShinsaTime = txtShinsaTime;
    }

    /*
     * getShussekiIinJoho
     * @return ShussekiIinJoho
     */
    @JsonProperty("ShussekiIinJoho")
    public ShussekiIinJohoDiv getShussekiIinJoho() {
        return ShussekiIinJoho;
    }

    /*
     * setShussekiIinJoho
     * @param ShussekiIinJoho ShussekiIinJoho
     */
    @JsonProperty("ShussekiIinJoho")
    public void setShussekiIinJoho(ShussekiIinJohoDiv ShussekiIinJoho) {
        this.ShussekiIinJoho = ShussekiIinJoho;
    }

    /*
     * getbtnModoru
     * @return btnModoru
     */
    @JsonProperty("btnModoru")
    public Button getBtnModoru() {
        return btnModoru;
    }

    /*
     * setbtnModoru
     * @param btnModoru btnModoru
     */
    @JsonProperty("btnModoru")
    public void setBtnModoru(Button btnModoru) {
        this.btnModoru = btnModoru;
    }

    /*
     * gethdnShinseishoKanriNo
     * @return hdnShinseishoKanriNo
     */
    @JsonProperty("hdnShinseishoKanriNo")
    public RString getHdnShinseishoKanriNo() {
        return hdnShinseishoKanriNo;
    }

    /*
     * sethdnShinseishoKanriNo
     * @param hdnShinseishoKanriNo hdnShinseishoKanriNo
     */
    @JsonProperty("hdnShinseishoKanriNo")
    public void setHdnShinseishoKanriNo(RString hdnShinseishoKanriNo) {
        this.hdnShinseishoKanriNo = hdnShinseishoKanriNo;
    }

    /*
     * gethdnShinsakaiKaisaiNo
     * @return hdnShinsakaiKaisaiNo
     */
    @JsonProperty("hdnShinsakaiKaisaiNo")
    public RString getHdnShinsakaiKaisaiNo() {
        return hdnShinsakaiKaisaiNo;
    }

    /*
     * sethdnShinsakaiKaisaiNo
     * @param hdnShinsakaiKaisaiNo hdnShinsakaiKaisaiNo
     */
    @JsonProperty("hdnShinsakaiKaisaiNo")
    public void setHdnShinsakaiKaisaiNo(RString hdnShinsakaiKaisaiNo) {
        this.hdnShinsakaiKaisaiNo = hdnShinsakaiKaisaiNo;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public Label getLblShinsakaiIin() {
        return this.getShussekiIinJoho().getLblShinsakaiIin();
    }

    @JsonIgnore
    public void  setLblShinsakaiIin(Label lblShinsakaiIin) {
        this.getShussekiIinJoho().setLblShinsakaiIin(lblShinsakaiIin);
    }

    @JsonIgnore
    public Label getLblHoketsuShinsakaiIin() {
        return this.getShussekiIinJoho().getLblHoketsuShinsakaiIin();
    }

    @JsonIgnore
    public void  setLblHoketsuShinsakaiIin(Label lblHoketsuShinsakaiIin) {
        this.getShussekiIinJoho().setLblHoketsuShinsakaiIin(lblHoketsuShinsakaiIin);
    }

    @JsonIgnore
    public DataGrid<dgShinsakaiIin_Row> getDgShinsakaiIin() {
        return this.getShussekiIinJoho().getDgShinsakaiIin();
    }

    @JsonIgnore
    public void  setDgShinsakaiIin(DataGrid<dgShinsakaiIin_Row> dgShinsakaiIin) {
        this.getShussekiIinJoho().setDgShinsakaiIin(dgShinsakaiIin);
    }

    @JsonIgnore
    public DataGrid<dgHoketsuShinsakai_Row> getDgHoketsuShinsakai() {
        return this.getShussekiIinJoho().getDgHoketsuShinsakai();
    }

    @JsonIgnore
    public void  setDgHoketsuShinsakai(DataGrid<dgHoketsuShinsakai_Row> dgHoketsuShinsakai) {
        this.getShussekiIinJoho().setDgHoketsuShinsakai(dgHoketsuShinsakai);
    }

    // </editor-fold>
    //--------------- この行より下にコードを追加してください -------------------
    private ShinsakaiJohoKojinHandler getHandler(ShinsakaiJohoKojinDiv requestDiv) {
        return new ShinsakaiJohoKojinHandler(requestDiv);
    }

    /**
     * 共通子DIVを初期化します。
     */
    @Override
    public void initialize() {
        getHandler(this).initialize();
    }

}
