package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5130001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.CodeInput.CodeInputDiv;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.CodeInput.ICodeInputDiv;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * ShinsakaiIinJohoTorokuInput のクラスファイル 
 * 
 * @author 自動生成
 */
public class ShinsakaiIinJohoTorokuInputDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-12-15_08-21-11">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ShinsakaiIinJoho")
    private ShinsakaiIinJohoDiv ShinsakaiIinJoho;
    @JsonProperty("RenrakusakiKinyuKikan")
    private RenrakusakiKinyuKikanDiv RenrakusakiKinyuKikan;
    @JsonProperty("ShozokuKikanIchiran")
    private ShozokuKikanIchiranDiv ShozokuKikanIchiran;
    @JsonProperty("btnToroku")
    private Button btnToroku;
    @JsonProperty("btnDelete")
    private Button btnDelete;
    @JsonProperty("status")
    private RString status;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getShinsakaiIinJoho
     * @return ShinsakaiIinJoho
     */
    @JsonProperty("ShinsakaiIinJoho")
    public ShinsakaiIinJohoDiv getShinsakaiIinJoho() {
        return ShinsakaiIinJoho;
    }

    /*
     * setShinsakaiIinJoho
     * @param ShinsakaiIinJoho ShinsakaiIinJoho
     */
    @JsonProperty("ShinsakaiIinJoho")
    public void setShinsakaiIinJoho(ShinsakaiIinJohoDiv ShinsakaiIinJoho) {
        this.ShinsakaiIinJoho = ShinsakaiIinJoho;
    }

    /*
     * getRenrakusakiKinyuKikan
     * @return RenrakusakiKinyuKikan
     */
    @JsonProperty("RenrakusakiKinyuKikan")
    public RenrakusakiKinyuKikanDiv getRenrakusakiKinyuKikan() {
        return RenrakusakiKinyuKikan;
    }

    /*
     * setRenrakusakiKinyuKikan
     * @param RenrakusakiKinyuKikan RenrakusakiKinyuKikan
     */
    @JsonProperty("RenrakusakiKinyuKikan")
    public void setRenrakusakiKinyuKikan(RenrakusakiKinyuKikanDiv RenrakusakiKinyuKikan) {
        this.RenrakusakiKinyuKikan = RenrakusakiKinyuKikan;
    }

    /*
     * getShozokuKikanIchiran
     * @return ShozokuKikanIchiran
     */
    @JsonProperty("ShozokuKikanIchiran")
    public ShozokuKikanIchiranDiv getShozokuKikanIchiran() {
        return ShozokuKikanIchiran;
    }

    /*
     * setShozokuKikanIchiran
     * @param ShozokuKikanIchiran ShozokuKikanIchiran
     */
    @JsonProperty("ShozokuKikanIchiran")
    public void setShozokuKikanIchiran(ShozokuKikanIchiranDiv ShozokuKikanIchiran) {
        this.ShozokuKikanIchiran = ShozokuKikanIchiran;
    }

    /*
     * getbtnToroku
     * @return btnToroku
     */
    @JsonProperty("btnToroku")
    public Button getBtnToroku() {
        return btnToroku;
    }

    /*
     * setbtnToroku
     * @param btnToroku btnToroku
     */
    @JsonProperty("btnToroku")
    public void setBtnToroku(Button btnToroku) {
        this.btnToroku = btnToroku;
    }

    /*
     * getbtnDelete
     * @return btnDelete
     */
    @JsonProperty("btnDelete")
    public Button getBtnDelete() {
        return btnDelete;
    }

    /*
     * setbtnDelete
     * @param btnDelete btnDelete
     */
    @JsonProperty("btnDelete")
    public void setBtnDelete(Button btnDelete) {
        this.btnDelete = btnDelete;
    }

    /*
     * getstatus
     * @return status
     */
    @JsonProperty("status")
    public RString getStatus() {
        return status;
    }

    /*
     * setstatus
     * @param status status
     */
    @JsonProperty("status")
    public void setStatus(RString status) {
        this.status = status;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public TextBoxCode getTxtShinsainCode() {
        return this.getShinsakaiIinJoho().getTxtShinsainCode();
    }

    @JsonIgnore
    public void  setTxtShinsainCode(TextBoxCode txtShinsainCode) {
        this.getShinsakaiIinJoho().setTxtShinsainCode(txtShinsainCode);
    }

    @JsonIgnore
    public TextBoxDate getTxtShinsaIinYMDFrom() {
        return this.getShinsakaiIinJoho().getTxtShinsaIinYMDFrom();
    }

    @JsonIgnore
    public void  setTxtShinsaIinYMDFrom(TextBoxDate txtShinsaIinYMDFrom) {
        this.getShinsakaiIinJoho().setTxtShinsaIinYMDFrom(txtShinsaIinYMDFrom);
    }

    @JsonIgnore
    public TextBoxDate getTxtShinsaIinYMDTo() {
        return this.getShinsakaiIinJoho().getTxtShinsaIinYMDTo();
    }

    @JsonIgnore
    public void  setTxtShinsaIinYMDTo(TextBoxDate txtShinsaIinYMDTo) {
        this.getShinsakaiIinJoho().setTxtShinsaIinYMDTo(txtShinsaIinYMDTo);
    }

    @JsonIgnore
    public TextBox getTxtShimei() {
        return this.getShinsakaiIinJoho().getTxtShimei();
    }

    @JsonIgnore
    public void  setTxtShimei(TextBox txtShimei) {
        this.getShinsakaiIinJoho().setTxtShimei(txtShimei);
    }

    @JsonIgnore
    public TextBox getTxtKanaShimei() {
        return this.getShinsakaiIinJoho().getTxtKanaShimei();
    }

    @JsonIgnore
    public void  setTxtKanaShimei(TextBox txtKanaShimei) {
        this.getShinsakaiIinJoho().setTxtKanaShimei(txtKanaShimei);
    }

    @JsonIgnore
    public RadioButton getRadSeibetsu() {
        return this.getShinsakaiIinJoho().getRadSeibetsu();
    }

    @JsonIgnore
    public void  setRadSeibetsu(RadioButton radSeibetsu) {
        this.getShinsakaiIinJoho().setRadSeibetsu(radSeibetsu);
    }

    @JsonIgnore
    public TextBoxDate getTxtBirthYMD() {
        return this.getShinsakaiIinJoho().getTxtBirthYMD();
    }

    @JsonIgnore
    public void  setTxtBirthYMD(TextBoxDate txtBirthYMD) {
        this.getShinsakaiIinJoho().setTxtBirthYMD(txtBirthYMD);
    }

    @JsonIgnore
    public DropDownList getDdlShikakuCode() {
        return this.getShinsakaiIinJoho().getDdlShikakuCode();
    }

    @JsonIgnore
    public void  setDdlShikakuCode(DropDownList ddlShikakuCode) {
        this.getShinsakaiIinJoho().setDdlShikakuCode(ddlShikakuCode);
    }

    @JsonIgnore
    public TextBox getTxtBiko() {
        return this.getShinsakaiIinJoho().getTxtBiko();
    }

    @JsonIgnore
    public void  setTxtBiko(TextBox txtBiko) {
        this.getShinsakaiIinJoho().setTxtBiko(txtBiko);
    }

    @JsonIgnore
    public ICodeInputDiv getCcdshinsakaiChikuCode() {
        return this.getShinsakaiIinJoho().getCcdshinsakaiChikuCode();
    }

    @JsonIgnore
    public TextBoxYubinNo getTxtYubinNo() {
        return this.getRenrakusakiKinyuKikan().getTxtYubinNo();
    }

    @JsonIgnore
    public void  setTxtYubinNo(TextBoxYubinNo txtYubinNo) {
        this.getRenrakusakiKinyuKikan().setTxtYubinNo(txtYubinNo);
    }

    @JsonIgnore
    public TextBoxJusho getTxtJusho() {
        return this.getRenrakusakiKinyuKikan().getTxtJusho();
    }

    @JsonIgnore
    public void  setTxtJusho(TextBoxJusho txtJusho) {
        this.getRenrakusakiKinyuKikan().setTxtJusho(txtJusho);
    }

    @JsonIgnore
    public TextBoxTelNo getTxtTelNo1() {
        return this.getRenrakusakiKinyuKikan().getTxtTelNo1();
    }

    @JsonIgnore
    public void  setTxtTelNo1(TextBoxTelNo txtTelNo1) {
        this.getRenrakusakiKinyuKikan().setTxtTelNo1(txtTelNo1);
    }

    @JsonIgnore
    public TextBoxTelNo getTxtFaxNo() {
        return this.getRenrakusakiKinyuKikan().getTxtFaxNo();
    }

    @JsonIgnore
    public void  setTxtFaxNo(TextBoxTelNo txtFaxNo) {
        this.getRenrakusakiKinyuKikan().setTxtFaxNo(txtFaxNo);
    }

    @JsonIgnore
    public DropDownList getDdlYusoKubun() {
        return this.getRenrakusakiKinyuKikan().getDdlYusoKubun();
    }

    @JsonIgnore
    public void  setDdlYusoKubun(DropDownList ddlYusoKubun) {
        this.getRenrakusakiKinyuKikan().setDdlYusoKubun(ddlYusoKubun);
    }

    @JsonIgnore
    public DropDownList getDdlHaishiFlag() {
        return this.getRenrakusakiKinyuKikan().getDdlHaishiFlag();
    }

    @JsonIgnore
    public void  setDdlHaishiFlag(DropDownList ddlHaishiFlag) {
        this.getRenrakusakiKinyuKikan().setDdlHaishiFlag(ddlHaishiFlag);
    }

    @JsonIgnore
    public TextBoxDate getTxtHaishiYMD() {
        return this.getRenrakusakiKinyuKikan().getTxtHaishiYMD();
    }

    @JsonIgnore
    public void  setTxtHaishiYMD(TextBoxDate txtHaishiYMD) {
        this.getRenrakusakiKinyuKikan().setTxtHaishiYMD(txtHaishiYMD);
    }

    @JsonIgnore
    public KozaJohoDiv getKozaJoho() {
        return this.getRenrakusakiKinyuKikan().getKozaJoho();
    }

    @JsonIgnore
    public void  setKozaJoho(KozaJohoDiv KozaJoho) {
        this.getRenrakusakiKinyuKikan().setKozaJoho(KozaJoho);
    }

    @JsonIgnore
    public Button getBtnShozokuKikanAdd() {
        return this.getShozokuKikanIchiran().getBtnShozokuKikanAdd();
    }

    @JsonIgnore
    public void  setBtnShozokuKikanAdd(Button btnShozokuKikanAdd) {
        this.getShozokuKikanIchiran().setBtnShozokuKikanAdd(btnShozokuKikanAdd);
    }

    @JsonIgnore
    public DataGrid<dgShozokuKikanIchiran_Row> getDgShozokuKikanIchiran() {
        return this.getShozokuKikanIchiran().getDgShozokuKikanIchiran();
    }

    @JsonIgnore
    public void  setDgShozokuKikanIchiran(DataGrid<dgShozokuKikanIchiran_Row> dgShozokuKikanIchiran) {
        this.getShozokuKikanIchiran().setDgShozokuKikanIchiran(dgShozokuKikanIchiran);
    }

    // </editor-fold>
}
