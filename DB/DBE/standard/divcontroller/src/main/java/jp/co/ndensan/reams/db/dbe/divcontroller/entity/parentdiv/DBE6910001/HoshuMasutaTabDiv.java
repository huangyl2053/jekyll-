package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE6910001;
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
 * HoshuMasutaTab のクラスファイル 
 * 
 * @author 自動生成
 */
public class HoshuMasutaTabDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("tabHoshuMasutaKoshin")
    private tabHoshuMasutaKoshinDiv tabHoshuMasutaKoshin;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettabHoshuMasutaKoshin
     * @return tabHoshuMasutaKoshin
     */
    @JsonProperty("tabHoshuMasutaKoshin")
    public tabHoshuMasutaKoshinDiv getTabHoshuMasutaKoshin() {
        return tabHoshuMasutaKoshin;
    }

    /*
     * settabHoshuMasutaKoshin
     * @param tabHoshuMasutaKoshin tabHoshuMasutaKoshin
     */
    @JsonProperty("tabHoshuMasutaKoshin")
    public void setTabHoshuMasutaKoshin(tabHoshuMasutaKoshinDiv tabHoshuMasutaKoshin) {
        this.tabHoshuMasutaKoshin = tabHoshuMasutaKoshin;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public tblIkenShohoshuTankaDiv getTblIkenShohoshuTanka() {
        return this.getTabHoshuMasutaKoshin().getTblIkenShohoshuTanka();
    }

    @JsonIgnore
    public void  setTblIkenShohoshuTanka(tblIkenShohoshuTankaDiv tblIkenShohoshuTanka) {
        this.getTabHoshuMasutaKoshin().setTblIkenShohoshuTanka(tblIkenShohoshuTanka);
    }

    @JsonIgnore
    public Button getBtnIkenTsuika() {
        return this.getTabHoshuMasutaKoshin().getTblIkenShohoshuTanka().getBtnIkenTsuika();
    }

    @JsonIgnore
    public void  setBtnIkenTsuika(Button btnIkenTsuika) {
        this.getTabHoshuMasutaKoshin().getTblIkenShohoshuTanka().setBtnIkenTsuika(btnIkenTsuika);
    }

    @JsonIgnore
    public DataGrid<dgIkenShohoshuTankaIchiran_Row> getDgIkenShohoshuTankaIchiran() {
        return this.getTabHoshuMasutaKoshin().getTblIkenShohoshuTanka().getDgIkenShohoshuTankaIchiran();
    }

    @JsonIgnore
    public void  setDgIkenShohoshuTankaIchiran(DataGrid<dgIkenShohoshuTankaIchiran_Row> dgIkenShohoshuTankaIchiran) {
        this.getTabHoshuMasutaKoshin().getTblIkenShohoshuTanka().setDgIkenShohoshuTankaIchiran(dgIkenShohoshuTankaIchiran);
    }

    @JsonIgnore
    public IkenShohoshuTankaNyuryokuDiv getIkenShohoshuTankaNyuryoku() {
        return this.getTabHoshuMasutaKoshin().getTblIkenShohoshuTanka().getIkenShohoshuTankaNyuryoku();
    }

    @JsonIgnore
    public void  setIkenShohoshuTankaNyuryoku(IkenShohoshuTankaNyuryokuDiv IkenShohoshuTankaNyuryoku) {
        this.getTabHoshuMasutaKoshin().getTblIkenShohoshuTanka().setIkenShohoshuTankaNyuryoku(IkenShohoshuTankaNyuryoku);
    }

    @JsonIgnore
    public tabChosainhoshuTankaDiv getTabChosainhoshuTanka() {
        return this.getTabHoshuMasutaKoshin().getTabChosainhoshuTanka();
    }

    @JsonIgnore
    public void  setTabChosainhoshuTanka(tabChosainhoshuTankaDiv tabChosainhoshuTanka) {
        this.getTabHoshuMasutaKoshin().setTabChosainhoshuTanka(tabChosainhoshuTanka);
    }

    @JsonIgnore
    public Button getBtnChoTsuika() {
        return this.getTabHoshuMasutaKoshin().getTabChosainhoshuTanka().getBtnChoTsuika();
    }

    @JsonIgnore
    public void  setBtnChoTsuika(Button btnChoTsuika) {
        this.getTabHoshuMasutaKoshin().getTabChosainhoshuTanka().setBtnChoTsuika(btnChoTsuika);
    }

    @JsonIgnore
    public DataGrid<dgChosainhoshuTankaIchiran_Row> getDgChosainhoshuTankaIchiran() {
        return this.getTabHoshuMasutaKoshin().getTabChosainhoshuTanka().getDgChosainhoshuTankaIchiran();
    }

    @JsonIgnore
    public void  setDgChosainhoshuTankaIchiran(DataGrid<dgChosainhoshuTankaIchiran_Row> dgChosainhoshuTankaIchiran) {
        this.getTabHoshuMasutaKoshin().getTabChosainhoshuTanka().setDgChosainhoshuTankaIchiran(dgChosainhoshuTankaIchiran);
    }

    @JsonIgnore
    public ChosainhoshuTankaNyuryokuDiv getChosainhoshuTankaNyuryoku() {
        return this.getTabHoshuMasutaKoshin().getTabChosainhoshuTanka().getChosainhoshuTankaNyuryoku();
    }

    @JsonIgnore
    public void  setChosainhoshuTankaNyuryoku(ChosainhoshuTankaNyuryokuDiv ChosainhoshuTankaNyuryoku) {
        this.getTabHoshuMasutaKoshin().getTabChosainhoshuTanka().setChosainhoshuTankaNyuryoku(ChosainhoshuTankaNyuryoku);
    }

    @JsonIgnore
    public TextBoxFlexibleYearMonth getTxtChoKaishiYM() {
        return this.getTabHoshuMasutaKoshin().getTabChosainhoshuTanka().getChosainhoshuTankaNyuryoku().getTxtChoKaishiYM();
    }

    @JsonIgnore
    public void  setTxtChoKaishiYM(TextBoxFlexibleYearMonth txtChoKaishiYM) {
        this.getTabHoshuMasutaKoshin().getTabChosainhoshuTanka().getChosainhoshuTankaNyuryoku().setTxtChoKaishiYM(txtChoKaishiYM);
    }

    @JsonIgnore
    public TextBoxFlexibleYearMonth getTxtChoShuryoYM() {
        return this.getTabHoshuMasutaKoshin().getTabChosainhoshuTanka().getChosainhoshuTankaNyuryoku().getTxtChoShuryoYM();
    }

    @JsonIgnore
    public void  setTxtChoShuryoYM(TextBoxFlexibleYearMonth txtChoShuryoYM) {
        this.getTabHoshuMasutaKoshin().getTabChosainhoshuTanka().getChosainhoshuTankaNyuryoku().setTxtChoShuryoYM(txtChoShuryoYM);
    }

    @JsonIgnore
    public DropDownList getDdlKaigoNinteiShinsaIinShubetsu() {
        return this.getTabHoshuMasutaKoshin().getTabChosainhoshuTanka().getChosainhoshuTankaNyuryoku().getDdlKaigoNinteiShinsaIinShubetsu();
    }

    @JsonIgnore
    public void  setDdlKaigoNinteiShinsaIinShubetsu(DropDownList ddlKaigoNinteiShinsaIinShubetsu) {
        this.getTabHoshuMasutaKoshin().getTabChosainhoshuTanka().getChosainhoshuTankaNyuryoku().setDdlKaigoNinteiShinsaIinShubetsu(ddlKaigoNinteiShinsaIinShubetsu);
    }

    @JsonIgnore
    public TextBoxNum getTxtChoTanka() {
        return this.getTabHoshuMasutaKoshin().getTabChosainhoshuTanka().getChosainhoshuTankaNyuryoku().getTxtChoTanka();
    }

    @JsonIgnore
    public void  setTxtChoTanka(TextBoxNum txtChoTanka) {
        this.getTabHoshuMasutaKoshin().getTabChosainhoshuTanka().getChosainhoshuTankaNyuryoku().setTxtChoTanka(txtChoTanka);
    }

    @JsonIgnore
    public Button getBtnChoKousin() {
        return this.getTabHoshuMasutaKoshin().getTabChosainhoshuTanka().getChosainhoshuTankaNyuryoku().getBtnChoKousin();
    }

    @JsonIgnore
    public void  setBtnChoKousin(Button btnChoKousin) {
        this.getTabHoshuMasutaKoshin().getTabChosainhoshuTanka().getChosainhoshuTankaNyuryoku().setBtnChoKousin(btnChoKousin);
    }

    @JsonIgnore
    public Button getBtnChoTorikesu() {
        return this.getTabHoshuMasutaKoshin().getTabChosainhoshuTanka().getChosainhoshuTankaNyuryoku().getBtnChoTorikesu();
    }

    @JsonIgnore
    public void  setBtnChoTorikesu(Button btnChoTorikesu) {
        this.getTabHoshuMasutaKoshin().getTabChosainhoshuTanka().getChosainhoshuTankaNyuryoku().setBtnChoTorikesu(btnChoTorikesu);
    }

    @JsonIgnore
    public tabHomonChosahoshuTankaDiv getTabHomonChosahoshuTanka() {
        return this.getTabHoshuMasutaKoshin().getTabHomonChosahoshuTanka();
    }

    @JsonIgnore
    public void  setTabHomonChosahoshuTanka(tabHomonChosahoshuTankaDiv tabHomonChosahoshuTanka) {
        this.getTabHoshuMasutaKoshin().setTabHomonChosahoshuTanka(tabHomonChosahoshuTanka);
    }

    @JsonIgnore
    public Button getBtnHomTsuika() {
        return this.getTabHoshuMasutaKoshin().getTabHomonChosahoshuTanka().getBtnHomTsuika();
    }

    @JsonIgnore
    public void  setBtnHomTsuika(Button btnHomTsuika) {
        this.getTabHoshuMasutaKoshin().getTabHomonChosahoshuTanka().setBtnHomTsuika(btnHomTsuika);
    }

    @JsonIgnore
    public DataGrid<dgHomonChosahoshuTankaIchiran_Row> getDgHomonChosahoshuTankaIchiran() {
        return this.getTabHoshuMasutaKoshin().getTabHomonChosahoshuTanka().getDgHomonChosahoshuTankaIchiran();
    }

    @JsonIgnore
    public void  setDgHomonChosahoshuTankaIchiran(DataGrid<dgHomonChosahoshuTankaIchiran_Row> dgHomonChosahoshuTankaIchiran) {
        this.getTabHoshuMasutaKoshin().getTabHomonChosahoshuTanka().setDgHomonChosahoshuTankaIchiran(dgHomonChosahoshuTankaIchiran);
    }

    @JsonIgnore
    public HomonChosahoshuTankaNyuryokuDiv getHomonChosahoshuTankaNyuryoku() {
        return this.getTabHoshuMasutaKoshin().getTabHomonChosahoshuTanka().getHomonChosahoshuTankaNyuryoku();
    }

    @JsonIgnore
    public void  setHomonChosahoshuTankaNyuryoku(HomonChosahoshuTankaNyuryokuDiv HomonChosahoshuTankaNyuryoku) {
        this.getTabHoshuMasutaKoshin().getTabHomonChosahoshuTanka().setHomonChosahoshuTankaNyuryoku(HomonChosahoshuTankaNyuryoku);
    }

    @JsonIgnore
    public tbShinsakaiIinBetuTankaDiv getTbShinsakaiIinBetuTanka() {
        return this.getTabHoshuMasutaKoshin().getTbShinsakaiIinBetuTanka();
    }

    @JsonIgnore
    public void  setTbShinsakaiIinBetuTanka(tbShinsakaiIinBetuTankaDiv tbShinsakaiIinBetuTanka) {
        this.getTabHoshuMasutaKoshin().setTbShinsakaiIinBetuTanka(tbShinsakaiIinBetuTanka);
    }

    @JsonIgnore
    public Button getBtnBetuTsuika() {
        return this.getTabHoshuMasutaKoshin().getTbShinsakaiIinBetuTanka().getBtnBetuTsuika();
    }

    @JsonIgnore
    public void  setBtnBetuTsuika(Button btnBetuTsuika) {
        this.getTabHoshuMasutaKoshin().getTbShinsakaiIinBetuTanka().setBtnBetuTsuika(btnBetuTsuika);
    }

    @JsonIgnore
    public DataGrid<dgShinsakaiIinBetuTanka_Row> getDgShinsakaiIinBetuTanka() {
        return this.getTabHoshuMasutaKoshin().getTbShinsakaiIinBetuTanka().getDgShinsakaiIinBetuTanka();
    }

    @JsonIgnore
    public void  setDgShinsakaiIinBetuTanka(DataGrid<dgShinsakaiIinBetuTanka_Row> dgShinsakaiIinBetuTanka) {
        this.getTabHoshuMasutaKoshin().getTbShinsakaiIinBetuTanka().setDgShinsakaiIinBetuTanka(dgShinsakaiIinBetuTanka);
    }

    @JsonIgnore
    public shinsakaiIinBetuTankaMeisaiDiv getShinsakaiIinBetuTankaMeisai() {
        return this.getTabHoshuMasutaKoshin().getTbShinsakaiIinBetuTanka().getShinsakaiIinBetuTankaMeisai();
    }

    @JsonIgnore
    public void  setShinsakaiIinBetuTankaMeisai(shinsakaiIinBetuTankaMeisaiDiv shinsakaiIinBetuTankaMeisai) {
        this.getTabHoshuMasutaKoshin().getTbShinsakaiIinBetuTanka().setShinsakaiIinBetuTankaMeisai(shinsakaiIinBetuTankaMeisai);
    }

    @JsonIgnore
    public TextBoxFlexibleYearMonth getTxtBetuKaishiYM() {
        return this.getTabHoshuMasutaKoshin().getTbShinsakaiIinBetuTanka().getShinsakaiIinBetuTankaMeisai().getTxtBetuKaishiYM();
    }

    @JsonIgnore
    public void  setTxtBetuKaishiYM(TextBoxFlexibleYearMonth txtBetuKaishiYM) {
        this.getTabHoshuMasutaKoshin().getTbShinsakaiIinBetuTanka().getShinsakaiIinBetuTankaMeisai().setTxtBetuKaishiYM(txtBetuKaishiYM);
    }

    @JsonIgnore
    public TextBoxFlexibleYearMonth getTxtBetuShuryoYM() {
        return this.getTabHoshuMasutaKoshin().getTbShinsakaiIinBetuTanka().getShinsakaiIinBetuTankaMeisai().getTxtBetuShuryoYM();
    }

    @JsonIgnore
    public void  setTxtBetuShuryoYM(TextBoxFlexibleYearMonth txtBetuShuryoYM) {
        this.getTabHoshuMasutaKoshin().getTbShinsakaiIinBetuTanka().getShinsakaiIinBetuTankaMeisai().setTxtBetuShuryoYM(txtBetuShuryoYM);
    }

    @JsonIgnore
    public TextBox getTxtShinsaIinKodo() {
        return this.getTabHoshuMasutaKoshin().getTbShinsakaiIinBetuTanka().getShinsakaiIinBetuTankaMeisai().getTxtShinsaIinKodo();
    }

    @JsonIgnore
    public void  setTxtShinsaIinKodo(TextBox txtShinsaIinKodo) {
        this.getTabHoshuMasutaKoshin().getTbShinsakaiIinBetuTanka().getShinsakaiIinBetuTankaMeisai().setTxtShinsaIinKodo(txtShinsaIinKodo);
    }

    @JsonIgnore
    public TextBoxNum getTxtBetuTanka() {
        return this.getTabHoshuMasutaKoshin().getTbShinsakaiIinBetuTanka().getShinsakaiIinBetuTankaMeisai().getTxtBetuTanka();
    }

    @JsonIgnore
    public void  setTxtBetuTanka(TextBoxNum txtBetuTanka) {
        this.getTabHoshuMasutaKoshin().getTbShinsakaiIinBetuTanka().getShinsakaiIinBetuTankaMeisai().setTxtBetuTanka(txtBetuTanka);
    }

    @JsonIgnore
    public TextBoxNum getTxtBetuSonotaTanka() {
        return this.getTabHoshuMasutaKoshin().getTbShinsakaiIinBetuTanka().getShinsakaiIinBetuTankaMeisai().getTxtBetuSonotaTanka();
    }

    @JsonIgnore
    public void  setTxtBetuSonotaTanka(TextBoxNum txtBetuSonotaTanka) {
        this.getTabHoshuMasutaKoshin().getTbShinsakaiIinBetuTanka().getShinsakaiIinBetuTankaMeisai().setTxtBetuSonotaTanka(txtBetuSonotaTanka);
    }

    @JsonIgnore
    public Button getBtnBetuKousin() {
        return this.getTabHoshuMasutaKoshin().getTbShinsakaiIinBetuTanka().getShinsakaiIinBetuTankaMeisai().getBtnBetuKousin();
    }

    @JsonIgnore
    public void  setBtnBetuKousin(Button btnBetuKousin) {
        this.getTabHoshuMasutaKoshin().getTbShinsakaiIinBetuTanka().getShinsakaiIinBetuTankaMeisai().setBtnBetuKousin(btnBetuKousin);
    }

    @JsonIgnore
    public Button getBtnBetuTorikesu() {
        return this.getTabHoshuMasutaKoshin().getTbShinsakaiIinBetuTanka().getShinsakaiIinBetuTankaMeisai().getBtnBetuTorikesu();
    }

    @JsonIgnore
    public void  setBtnBetuTorikesu(Button btnBetuTorikesu) {
        this.getTabHoshuMasutaKoshin().getTbShinsakaiIinBetuTanka().getShinsakaiIinBetuTankaMeisai().setBtnBetuTorikesu(btnBetuTorikesu);
    }

    // </editor-fold>
}
