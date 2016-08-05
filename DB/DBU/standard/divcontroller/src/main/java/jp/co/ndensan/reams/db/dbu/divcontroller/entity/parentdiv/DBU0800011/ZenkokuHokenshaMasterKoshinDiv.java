package jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0800011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.KaigoKanryoMessage.KaigoKanryoMessage.IKaigoKanryoMessageDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.KaigoKanryoMessage.KaigoKanryoMessage.KaigoKanryoMessageDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * ZenkokuHokenshaMasterKoshin のクラスファイル 
 * 
 * @author 自動生成
 */
public class ZenkokuHokenshaMasterKoshinDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("HokenshaIchiran")
    private HokenshaIchiranDiv HokenshaIchiran;
    @JsonProperty("HokenshaJoho")
    private HokenshaJohoDiv HokenshaJoho;
    @JsonProperty("ccdKanryoMessage")
    private KaigoKanryoMessageDiv ccdKanryoMessage;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getHokenshaIchiran
     * @return HokenshaIchiran
     */
    @JsonProperty("HokenshaIchiran")
    public HokenshaIchiranDiv getHokenshaIchiran() {
        return HokenshaIchiran;
    }

    /*
     * setHokenshaIchiran
     * @param HokenshaIchiran HokenshaIchiran
     */
    @JsonProperty("HokenshaIchiran")
    public void setHokenshaIchiran(HokenshaIchiranDiv HokenshaIchiran) {
        this.HokenshaIchiran = HokenshaIchiran;
    }

    /*
     * getHokenshaJoho
     * @return HokenshaJoho
     */
    @JsonProperty("HokenshaJoho")
    public HokenshaJohoDiv getHokenshaJoho() {
        return HokenshaJoho;
    }

    /*
     * setHokenshaJoho
     * @param HokenshaJoho HokenshaJoho
     */
    @JsonProperty("HokenshaJoho")
    public void setHokenshaJoho(HokenshaJohoDiv HokenshaJoho) {
        this.HokenshaJoho = HokenshaJoho;
    }

    /*
     * getccdKanryoMessage
     * @return ccdKanryoMessage
     */
    @JsonProperty("ccdKanryoMessage")
    public IKaigoKanryoMessageDiv getCcdKanryoMessage() {
        return ccdKanryoMessage;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public DropDownList getDdlTodofuken() {
        return this.getHokenshaIchiran().getDdlTodofuken();
    }

    @JsonIgnore
    public void  setDdlTodofuken(DropDownList ddlTodofuken) {
        this.getHokenshaIchiran().setDdlTodofuken(ddlTodofuken);
    }

    @JsonIgnore
    public Button getBtnAddHokensha() {
        return this.getHokenshaIchiran().getBtnAddHokensha();
    }

    @JsonIgnore
    public void  setBtnAddHokensha(Button btnAddHokensha) {
        this.getHokenshaIchiran().setBtnAddHokensha(btnAddHokensha);
    }

    @JsonIgnore
    public DataGrid<dgHokenshas_Row> getDgHokenshas() {
        return this.getHokenshaIchiran().getDgHokenshas();
    }

    @JsonIgnore
    public void  setDgHokenshas(DataGrid<dgHokenshas_Row> dgHokenshas) {
        this.getHokenshaIchiran().setDgHokenshas(dgHokenshas);
    }

    @JsonIgnore
    public TextBoxCode getTxtHokenshaNo() {
        return this.getHokenshaJoho().getTxtHokenshaNo();
    }

    @JsonIgnore
    public void  setTxtHokenshaNo(TextBoxCode txtHokenshaNo) {
        this.getHokenshaJoho().setTxtHokenshaNo(txtHokenshaNo);
    }

    @JsonIgnore
    public TextBox getTxtHokenshaName() {
        return this.getHokenshaJoho().getTxtHokenshaName();
    }

    @JsonIgnore
    public void  setTxtHokenshaName(TextBox txtHokenshaName) {
        this.getHokenshaJoho().setTxtHokenshaName(txtHokenshaName);
    }

    @JsonIgnore
    public StaticImage getImgYubinNo() {
        return this.getHokenshaJoho().getImgYubinNo();
    }

    @JsonIgnore
    public void  setImgYubinNo(StaticImage imgYubinNo) {
        this.getHokenshaJoho().setImgYubinNo(imgYubinNo);
    }

    @JsonIgnore
    public TextBoxYubinNo getTxtHokenshaYubinNo() {
        return this.getHokenshaJoho().getTxtHokenshaYubinNo();
    }

    @JsonIgnore
    public void  setTxtHokenshaYubinNo(TextBoxYubinNo txtHokenshaYubinNo) {
        this.getHokenshaJoho().setTxtHokenshaYubinNo(txtHokenshaYubinNo);
    }

    @JsonIgnore
    public TextBoxJusho getTxtHokenshaJusho() {
        return this.getHokenshaJoho().getTxtHokenshaJusho();
    }

    @JsonIgnore
    public void  setTxtHokenshaJusho(TextBoxJusho txtHokenshaJusho) {
        this.getHokenshaJoho().setTxtHokenshaJusho(txtHokenshaJusho);
    }

    @JsonIgnore
    public TextBoxTelNo getTxtHokenshaTelNo() {
        return this.getHokenshaJoho().getTxtHokenshaTelNo();
    }

    @JsonIgnore
    public void  setTxtHokenshaTelNo(TextBoxTelNo txtHokenshaTelNo) {
        this.getHokenshaJoho().setTxtHokenshaTelNo(txtHokenshaTelNo);
    }

    @JsonIgnore
    public Button getBtnKakutei() {
        return this.getHokenshaJoho().getBtnKakutei();
    }

    @JsonIgnore
    public void  setBtnKakutei(Button btnKakutei) {
        this.getHokenshaJoho().setBtnKakutei(btnKakutei);
    }

    @JsonIgnore
    public Button getBtnTorikeshi() {
        return this.getHokenshaJoho().getBtnTorikeshi();
    }

    @JsonIgnore
    public void  setBtnTorikeshi(Button btnTorikeshi) {
        this.getHokenshaJoho().setBtnTorikeshi(btnTorikeshi);
    }

    // </editor-fold>
}
