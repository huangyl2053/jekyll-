package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5130001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.CodeInput.ICodeInputDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * ShinsakaiIinJohoToroku のクラスファイル
 *
 * @author 自動生成
 */
public class ShinsakaiIinJohoTorokuDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2015-11-30_08-54-50">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("KensakuJoken")
    private KensakuJokenDiv KensakuJoken;
    @JsonProperty("ShinsakaiIinJohoIchiran")
    private ShinsakaiIinJohoIchiranDiv ShinsakaiIinJohoIchiran;
    @JsonProperty("ShinsakaiIinJoho")
    private ShinsakaiIinJohoDiv ShinsakaiIinJoho;
    @JsonProperty("ShozokuKikanIchiran")
    private ShozokuKikanIchiranDiv ShozokuKikanIchiran;
    @JsonProperty("RenrakusakiKinyuKikan")
    private RenrakusakiKinyuKikanDiv RenrakusakiKinyuKikan;
    @JsonProperty("btnToroku")
    private Button btnToroku;
    @JsonProperty("btnDelete")
    private Button btnDelete;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getKensakuJoken
     * @return KensakuJoken
     */
    @JsonProperty("KensakuJoken")
    public KensakuJokenDiv getKensakuJoken() {
        return KensakuJoken;
    }

    /*
     * setKensakuJoken
     * @param KensakuJoken KensakuJoken
     */
    @JsonProperty("KensakuJoken")
    public void setKensakuJoken(KensakuJokenDiv KensakuJoken) {
        this.KensakuJoken = KensakuJoken;
    }

    /*
     * getShinsakaiIinJohoIchiran
     * @return ShinsakaiIinJohoIchiran
     */
    @JsonProperty("ShinsakaiIinJohoIchiran")
    public ShinsakaiIinJohoIchiranDiv getShinsakaiIinJohoIchiran() {
        return ShinsakaiIinJohoIchiran;
    }

    /*
     * setShinsakaiIinJohoIchiran
     * @param ShinsakaiIinJohoIchiran ShinsakaiIinJohoIchiran
     */
    @JsonProperty("ShinsakaiIinJohoIchiran")
    public void setShinsakaiIinJohoIchiran(ShinsakaiIinJohoIchiranDiv ShinsakaiIinJohoIchiran) {
        this.ShinsakaiIinJohoIchiran = ShinsakaiIinJohoIchiran;
    }

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
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public Button getBtnKensaku() {
        return this.getKensakuJoken().getBtnKensaku();
    }

    @JsonIgnore
    public void setBtnKensaku(Button btnKensaku) {
        this.getKensakuJoken().setBtnKensaku(btnKensaku);
    }

    @JsonIgnore
    public RadioButton getRadHyojiJoken() {
        return this.getKensakuJoken().getRadHyojiJoken();
    }

    @JsonIgnore
    public void setRadHyojiJoken(RadioButton radHyojiJoken) {
        this.getKensakuJoken().setRadHyojiJoken(radHyojiJoken);
    }

    @JsonIgnore
    public Button getBtnShinsakaiIinAdd() {
        return this.getShinsakaiIinJohoIchiran().getBtnShinsakaiIinAdd();
    }

    @JsonIgnore
    public void setBtnShinsakaiIinAdd(Button btnShinsakaiIinAdd) {
        this.getShinsakaiIinJohoIchiran().setBtnShinsakaiIinAdd(btnShinsakaiIinAdd);
    }

    @JsonIgnore
    public DataGrid<dgShinsaInJohoIchiran_Row> getDgShinsaInJohoIchiran() {
        return this.getShinsakaiIinJohoIchiran().getDgShinsaInJohoIchiran();
    }

    @JsonIgnore
    public void setDgShinsaInJohoIchiran(DataGrid<dgShinsaInJohoIchiran_Row> dgShinsaInJohoIchiran) {
        this.getShinsakaiIinJohoIchiran().setDgShinsaInJohoIchiran(dgShinsaInJohoIchiran);
    }

    @JsonIgnore
    public TextBox getTxtShinsainCode() {
        return this.getShinsakaiIinJoho().getTxtShinsainCode();
    }

    @JsonIgnore
    public void setTxtShinsainCode(TextBox txtShinsainCode) {
        this.getShinsakaiIinJoho().setTxtShinsainCode(txtShinsainCode);
    }

    @JsonIgnore
    public TextBoxDate getTxtShinsaIinYMDFrom() {
        return this.getShinsakaiIinJoho().getTxtShinsaIinYMDFrom();
    }

    @JsonIgnore
    public void setTxtShinsaIinYMDFrom(TextBoxDate txtShinsaIinYMDFrom) {
        this.getShinsakaiIinJoho().setTxtShinsaIinYMDFrom(txtShinsaIinYMDFrom);
    }

    @JsonIgnore
    public TextBoxDate getTxtShinsaIinYMDTo() {
        return this.getShinsakaiIinJoho().getTxtShinsaIinYMDTo();
    }

    @JsonIgnore
    public void setTxtShinsaIinYMDTo(TextBoxDate txtShinsaIinYMDTo) {
        this.getShinsakaiIinJoho().setTxtShinsaIinYMDTo(txtShinsaIinYMDTo);
    }

    @JsonIgnore
    public TextBox getTxtShimei() {
        return this.getShinsakaiIinJoho().getTxtShimei();
    }

    @JsonIgnore
    public void setTxtShimei(TextBox txtShimei) {
        this.getShinsakaiIinJoho().setTxtShimei(txtShimei);
    }

    @JsonIgnore
    public TextBox getTxtKanaShimei() {
        return this.getShinsakaiIinJoho().getTxtKanaShimei();
    }

    @JsonIgnore
    public void setTxtKanaShimei(TextBox txtKanaShimei) {
        this.getShinsakaiIinJoho().setTxtKanaShimei(txtKanaShimei);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtBirthYMD() {
        return this.getShinsakaiIinJoho().getTxtBirthYMD();
    }

    @JsonIgnore
    public void setTxtBirthYMD(TextBoxFlexibleDate txtBirthYMD) {
        this.getShinsakaiIinJoho().setTxtBirthYMD(txtBirthYMD);
    }

    @JsonIgnore
    public RadioButton getRadSeibetsu() {
        return this.getShinsakaiIinJoho().getRadSeibetsu();
    }

    @JsonIgnore
    public void setRadSeibetsu(RadioButton radSeibetsu) {
        this.getShinsakaiIinJoho().setRadSeibetsu(radSeibetsu);
    }

    @JsonIgnore
    public DropDownList getDdlShikakuCode() {
        return this.getShinsakaiIinJoho().getDdlShikakuCode();
    }

    @JsonIgnore
    public void setDdlShikakuCode(DropDownList ddlShikakuCode) {
        this.getShinsakaiIinJoho().setDdlShikakuCode(ddlShikakuCode);
    }

    @JsonIgnore
    public TextBox getTxtBiko() {
        return this.getShinsakaiIinJoho().getTxtBiko();
    }

    @JsonIgnore
    public void setTxtBiko(TextBox txtBiko) {
        this.getShinsakaiIinJoho().setTxtBiko(txtBiko);
    }

    @JsonIgnore
    public ICodeInputDiv getCcdshinsakaiChikuCode() {
        return this.getShinsakaiIinJoho().getCcdshinsakaiChikuCode();
    }

    @JsonIgnore
    public Button getBtnShozokuKikanAdd() {
        return this.getShozokuKikanIchiran().getBtnShozokuKikanAdd();
    }

    @JsonIgnore
    public void setBtnShozokuKikanAdd(Button btnShozokuKikanAdd) {
        this.getShozokuKikanIchiran().setBtnShozokuKikanAdd(btnShozokuKikanAdd);
    }

    @JsonIgnore
    public DataGrid<dgShozokuKikanIchiran_Row> getDgShozokuKikanIchiran() {
        return this.getShozokuKikanIchiran().getDgShozokuKikanIchiran();
    }

    @JsonIgnore
    public void setDgShozokuKikanIchiran(DataGrid<dgShozokuKikanIchiran_Row> dgShozokuKikanIchiran) {
        this.getShozokuKikanIchiran().setDgShozokuKikanIchiran(dgShozokuKikanIchiran);
    }

    @JsonIgnore
    public TextBoxYubinNo getTxtYubinNo() {
        return this.getRenrakusakiKinyuKikan().getTxtYubinNo();
    }

    @JsonIgnore
    public void setTxtYubinNo(TextBoxYubinNo txtYubinNo) {
        this.getRenrakusakiKinyuKikan().setTxtYubinNo(txtYubinNo);
    }

    @JsonIgnore
    public DropDownList getDdlYusoKubun() {
        return this.getRenrakusakiKinyuKikan().getDdlYusoKubun();
    }

    @JsonIgnore
    public void setDdlYusoKubun(DropDownList ddlYusoKubun) {
        this.getRenrakusakiKinyuKikan().setDdlYusoKubun(ddlYusoKubun);
    }

    @JsonIgnore
    public TextBoxJusho getTxtJusho() {
        return this.getRenrakusakiKinyuKikan().getTxtJusho();
    }

    @JsonIgnore
    public void setTxtJusho(TextBoxJusho txtJusho) {
        this.getRenrakusakiKinyuKikan().setTxtJusho(txtJusho);
    }

    @JsonIgnore
    public DropDownList getDdlHaishiFlag() {
        return this.getRenrakusakiKinyuKikan().getDdlHaishiFlag();
    }

    @JsonIgnore
    public void setDdlHaishiFlag(DropDownList ddlHaishiFlag) {
        this.getRenrakusakiKinyuKikan().setDdlHaishiFlag(ddlHaishiFlag);
    }

    @JsonIgnore
    public TextBoxDate getTxtHaishiYMD() {
        return this.getRenrakusakiKinyuKikan().getTxtHaishiYMD();
    }

    @JsonIgnore
    public void setTxtHaishiYMD(TextBoxDate txtHaishiYMD) {
        this.getRenrakusakiKinyuKikan().setTxtHaishiYMD(txtHaishiYMD);
    }

    @JsonIgnore
    public TextBoxTelNo getTxtTelNo1() {
        return this.getRenrakusakiKinyuKikan().getTxtTelNo1();
    }

    @JsonIgnore
    public void setTxtTelNo1(TextBoxTelNo txtTelNo1) {
        this.getRenrakusakiKinyuKikan().setTxtTelNo1(txtTelNo1);
    }

    @JsonIgnore
    public TextBoxTelNo getTxtFaxNo() {
        return this.getRenrakusakiKinyuKikan().getTxtFaxNo();
    }

    @JsonIgnore
    public void setTxtFaxNo(TextBoxTelNo txtFaxNo) {
        this.getRenrakusakiKinyuKikan().setTxtFaxNo(txtFaxNo);
    }

    @JsonIgnore
    public ButtonDialog getBtnKozaJohoToroku() {
        return this.getRenrakusakiKinyuKikan().getBtnKozaJohoToroku();
    }

    @JsonIgnore
    public void setBtnKozaJohoToroku(ButtonDialog btnKozaJohoToroku) {
        this.getRenrakusakiKinyuKikan().setBtnKozaJohoToroku(btnKozaJohoToroku);
    }

    // </editor-fold>
}
