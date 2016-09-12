package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE6910001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.TabContainer;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * tabHoshuMasutaKoshin のクラスファイル 
 * 
 * @author 自動生成
 */
public class tabHoshuMasutaKoshinDiv extends TabContainer {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("tblIkenShohoshuTanka")
    private tblIkenShohoshuTankaDiv tblIkenShohoshuTanka;
    @JsonProperty("tabChosainhoshuTanka")
    private tabChosainhoshuTankaDiv tabChosainhoshuTanka;
    @JsonProperty("tabHomonChosahoshuTanka")
    private tabHomonChosahoshuTankaDiv tabHomonChosahoshuTanka;
    @JsonProperty("tbShinsakaiIinBetuTanka")
    private tbShinsakaiIinBetuTankaDiv tbShinsakaiIinBetuTanka;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettblIkenShohoshuTanka
     * @return tblIkenShohoshuTanka
     */
    @JsonProperty("tblIkenShohoshuTanka")
    public tblIkenShohoshuTankaDiv getTblIkenShohoshuTanka() {
        return tblIkenShohoshuTanka;
    }

    /*
     * settblIkenShohoshuTanka
     * @param tblIkenShohoshuTanka tblIkenShohoshuTanka
     */
    @JsonProperty("tblIkenShohoshuTanka")
    public void setTblIkenShohoshuTanka(tblIkenShohoshuTankaDiv tblIkenShohoshuTanka) {
        this.tblIkenShohoshuTanka = tblIkenShohoshuTanka;
    }

    /*
     * gettabChosainhoshuTanka
     * @return tabChosainhoshuTanka
     */
    @JsonProperty("tabChosainhoshuTanka")
    public tabChosainhoshuTankaDiv getTabChosainhoshuTanka() {
        return tabChosainhoshuTanka;
    }

    /*
     * settabChosainhoshuTanka
     * @param tabChosainhoshuTanka tabChosainhoshuTanka
     */
    @JsonProperty("tabChosainhoshuTanka")
    public void setTabChosainhoshuTanka(tabChosainhoshuTankaDiv tabChosainhoshuTanka) {
        this.tabChosainhoshuTanka = tabChosainhoshuTanka;
    }

    /*
     * gettabHomonChosahoshuTanka
     * @return tabHomonChosahoshuTanka
     */
    @JsonProperty("tabHomonChosahoshuTanka")
    public tabHomonChosahoshuTankaDiv getTabHomonChosahoshuTanka() {
        return tabHomonChosahoshuTanka;
    }

    /*
     * settabHomonChosahoshuTanka
     * @param tabHomonChosahoshuTanka tabHomonChosahoshuTanka
     */
    @JsonProperty("tabHomonChosahoshuTanka")
    public void setTabHomonChosahoshuTanka(tabHomonChosahoshuTankaDiv tabHomonChosahoshuTanka) {
        this.tabHomonChosahoshuTanka = tabHomonChosahoshuTanka;
    }

    /*
     * gettbShinsakaiIinBetuTanka
     * @return tbShinsakaiIinBetuTanka
     */
    @JsonProperty("tbShinsakaiIinBetuTanka")
    public tbShinsakaiIinBetuTankaDiv getTbShinsakaiIinBetuTanka() {
        return tbShinsakaiIinBetuTanka;
    }

    /*
     * settbShinsakaiIinBetuTanka
     * @param tbShinsakaiIinBetuTanka tbShinsakaiIinBetuTanka
     */
    @JsonProperty("tbShinsakaiIinBetuTanka")
    public void setTbShinsakaiIinBetuTanka(tbShinsakaiIinBetuTankaDiv tbShinsakaiIinBetuTanka) {
        this.tbShinsakaiIinBetuTanka = tbShinsakaiIinBetuTanka;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public Button getBtnIkenTsuika() {
        return this.getTblIkenShohoshuTanka().getBtnIkenTsuika();
    }

    @JsonIgnore
    public void  setBtnIkenTsuika(Button btnIkenTsuika) {
        this.getTblIkenShohoshuTanka().setBtnIkenTsuika(btnIkenTsuika);
    }

    @JsonIgnore
    public DataGrid<dgIkenShohoshuTankaIchiran_Row> getDgIkenShohoshuTankaIchiran() {
        return this.getTblIkenShohoshuTanka().getDgIkenShohoshuTankaIchiran();
    }

    @JsonIgnore
    public void  setDgIkenShohoshuTankaIchiran(DataGrid<dgIkenShohoshuTankaIchiran_Row> dgIkenShohoshuTankaIchiran) {
        this.getTblIkenShohoshuTanka().setDgIkenShohoshuTankaIchiran(dgIkenShohoshuTankaIchiran);
    }

    @JsonIgnore
    public IkenShohoshuTankaNyuryokuDiv getIkenShohoshuTankaNyuryoku() {
        return this.getTblIkenShohoshuTanka().getIkenShohoshuTankaNyuryoku();
    }

    @JsonIgnore
    public void  setIkenShohoshuTankaNyuryoku(IkenShohoshuTankaNyuryokuDiv IkenShohoshuTankaNyuryoku) {
        this.getTblIkenShohoshuTanka().setIkenShohoshuTankaNyuryoku(IkenShohoshuTankaNyuryoku);
    }

    @JsonIgnore
    public Button getBtnChoTsuika() {
        return this.getTabChosainhoshuTanka().getBtnChoTsuika();
    }

    @JsonIgnore
    public void  setBtnChoTsuika(Button btnChoTsuika) {
        this.getTabChosainhoshuTanka().setBtnChoTsuika(btnChoTsuika);
    }

    @JsonIgnore
    public DataGrid<dgChosainhoshuTankaIchiran_Row> getDgChosainhoshuTankaIchiran() {
        return this.getTabChosainhoshuTanka().getDgChosainhoshuTankaIchiran();
    }

    @JsonIgnore
    public void  setDgChosainhoshuTankaIchiran(DataGrid<dgChosainhoshuTankaIchiran_Row> dgChosainhoshuTankaIchiran) {
        this.getTabChosainhoshuTanka().setDgChosainhoshuTankaIchiran(dgChosainhoshuTankaIchiran);
    }

    @JsonIgnore
    public ChosainhoshuTankaNyuryokuDiv getChosainhoshuTankaNyuryoku() {
        return this.getTabChosainhoshuTanka().getChosainhoshuTankaNyuryoku();
    }

    @JsonIgnore
    public void  setChosainhoshuTankaNyuryoku(ChosainhoshuTankaNyuryokuDiv ChosainhoshuTankaNyuryoku) {
        this.getTabChosainhoshuTanka().setChosainhoshuTankaNyuryoku(ChosainhoshuTankaNyuryoku);
    }

    @JsonIgnore
    public TextBoxFlexibleYearMonth getTxtChoKaishiYM() {
        return this.getTabChosainhoshuTanka().getChosainhoshuTankaNyuryoku().getTxtChoKaishiYM();
    }

    @JsonIgnore
    public void  setTxtChoKaishiYM(TextBoxFlexibleYearMonth txtChoKaishiYM) {
        this.getTabChosainhoshuTanka().getChosainhoshuTankaNyuryoku().setTxtChoKaishiYM(txtChoKaishiYM);
    }

    @JsonIgnore
    public TextBoxFlexibleYearMonth getTxtChoShuryoYM() {
        return this.getTabChosainhoshuTanka().getChosainhoshuTankaNyuryoku().getTxtChoShuryoYM();
    }

    @JsonIgnore
    public void  setTxtChoShuryoYM(TextBoxFlexibleYearMonth txtChoShuryoYM) {
        this.getTabChosainhoshuTanka().getChosainhoshuTankaNyuryoku().setTxtChoShuryoYM(txtChoShuryoYM);
    }

    @JsonIgnore
    public DropDownList getDdlKaigoNinteiShinsaIinShubetsu() {
        return this.getTabChosainhoshuTanka().getChosainhoshuTankaNyuryoku().getDdlKaigoNinteiShinsaIinShubetsu();
    }

    @JsonIgnore
    public void  setDdlKaigoNinteiShinsaIinShubetsu(DropDownList ddlKaigoNinteiShinsaIinShubetsu) {
        this.getTabChosainhoshuTanka().getChosainhoshuTankaNyuryoku().setDdlKaigoNinteiShinsaIinShubetsu(ddlKaigoNinteiShinsaIinShubetsu);
    }

    @JsonIgnore
    public TextBoxNum getTxtChoTanka() {
        return this.getTabChosainhoshuTanka().getChosainhoshuTankaNyuryoku().getTxtChoTanka();
    }

    @JsonIgnore
    public void  setTxtChoTanka(TextBoxNum txtChoTanka) {
        this.getTabChosainhoshuTanka().getChosainhoshuTankaNyuryoku().setTxtChoTanka(txtChoTanka);
    }

    @JsonIgnore
    public Button getBtnChoKousin() {
        return this.getTabChosainhoshuTanka().getChosainhoshuTankaNyuryoku().getBtnChoKousin();
    }

    @JsonIgnore
    public void  setBtnChoKousin(Button btnChoKousin) {
        this.getTabChosainhoshuTanka().getChosainhoshuTankaNyuryoku().setBtnChoKousin(btnChoKousin);
    }

    @JsonIgnore
    public Button getBtnChoTorikesu() {
        return this.getTabChosainhoshuTanka().getChosainhoshuTankaNyuryoku().getBtnChoTorikesu();
    }

    @JsonIgnore
    public void  setBtnChoTorikesu(Button btnChoTorikesu) {
        this.getTabChosainhoshuTanka().getChosainhoshuTankaNyuryoku().setBtnChoTorikesu(btnChoTorikesu);
    }

    @JsonIgnore
    public Button getBtnHomTsuika() {
        return this.getTabHomonChosahoshuTanka().getBtnHomTsuika();
    }

    @JsonIgnore
    public void  setBtnHomTsuika(Button btnHomTsuika) {
        this.getTabHomonChosahoshuTanka().setBtnHomTsuika(btnHomTsuika);
    }

    @JsonIgnore
    public DataGrid<dgHomonChosahoshuTankaIchiran_Row> getDgHomonChosahoshuTankaIchiran() {
        return this.getTabHomonChosahoshuTanka().getDgHomonChosahoshuTankaIchiran();
    }

    @JsonIgnore
    public void  setDgHomonChosahoshuTankaIchiran(DataGrid<dgHomonChosahoshuTankaIchiran_Row> dgHomonChosahoshuTankaIchiran) {
        this.getTabHomonChosahoshuTanka().setDgHomonChosahoshuTankaIchiran(dgHomonChosahoshuTankaIchiran);
    }

    @JsonIgnore
    public HomonChosahoshuTankaNyuryokuDiv getHomonChosahoshuTankaNyuryoku() {
        return this.getTabHomonChosahoshuTanka().getHomonChosahoshuTankaNyuryoku();
    }

    @JsonIgnore
    public void  setHomonChosahoshuTankaNyuryoku(HomonChosahoshuTankaNyuryokuDiv HomonChosahoshuTankaNyuryoku) {
        this.getTabHomonChosahoshuTanka().setHomonChosahoshuTankaNyuryoku(HomonChosahoshuTankaNyuryoku);
    }

    @JsonIgnore
    public Button getBtnBetuTsuika() {
        return this.getTbShinsakaiIinBetuTanka().getBtnBetuTsuika();
    }

    @JsonIgnore
    public void  setBtnBetuTsuika(Button btnBetuTsuika) {
        this.getTbShinsakaiIinBetuTanka().setBtnBetuTsuika(btnBetuTsuika);
    }

    @JsonIgnore
    public DataGrid<dgShinsakaiIinBetuTanka_Row> getDgShinsakaiIinBetuTanka() {
        return this.getTbShinsakaiIinBetuTanka().getDgShinsakaiIinBetuTanka();
    }

    @JsonIgnore
    public void  setDgShinsakaiIinBetuTanka(DataGrid<dgShinsakaiIinBetuTanka_Row> dgShinsakaiIinBetuTanka) {
        this.getTbShinsakaiIinBetuTanka().setDgShinsakaiIinBetuTanka(dgShinsakaiIinBetuTanka);
    }

    @JsonIgnore
    public shinsakaiIinBetuTankaMeisaiDiv getShinsakaiIinBetuTankaMeisai() {
        return this.getTbShinsakaiIinBetuTanka().getShinsakaiIinBetuTankaMeisai();
    }

    @JsonIgnore
    public void  setShinsakaiIinBetuTankaMeisai(shinsakaiIinBetuTankaMeisaiDiv shinsakaiIinBetuTankaMeisai) {
        this.getTbShinsakaiIinBetuTanka().setShinsakaiIinBetuTankaMeisai(shinsakaiIinBetuTankaMeisai);
    }

    @JsonIgnore
    public TextBoxFlexibleYearMonth getTxtBetuKaishiYM() {
        return this.getTbShinsakaiIinBetuTanka().getShinsakaiIinBetuTankaMeisai().getTxtBetuKaishiYM();
    }

    @JsonIgnore
    public void  setTxtBetuKaishiYM(TextBoxFlexibleYearMonth txtBetuKaishiYM) {
        this.getTbShinsakaiIinBetuTanka().getShinsakaiIinBetuTankaMeisai().setTxtBetuKaishiYM(txtBetuKaishiYM);
    }

    @JsonIgnore
    public TextBoxFlexibleYearMonth getTxtBetuShuryoYM() {
        return this.getTbShinsakaiIinBetuTanka().getShinsakaiIinBetuTankaMeisai().getTxtBetuShuryoYM();
    }

    @JsonIgnore
    public void  setTxtBetuShuryoYM(TextBoxFlexibleYearMonth txtBetuShuryoYM) {
        this.getTbShinsakaiIinBetuTanka().getShinsakaiIinBetuTankaMeisai().setTxtBetuShuryoYM(txtBetuShuryoYM);
    }

    @JsonIgnore
    public TextBox getTxtShinsaIinKodo() {
        return this.getTbShinsakaiIinBetuTanka().getShinsakaiIinBetuTankaMeisai().getTxtShinsaIinKodo();
    }

    @JsonIgnore
    public void  setTxtShinsaIinKodo(TextBox txtShinsaIinKodo) {
        this.getTbShinsakaiIinBetuTanka().getShinsakaiIinBetuTankaMeisai().setTxtShinsaIinKodo(txtShinsaIinKodo);
    }

    @JsonIgnore
    public TextBoxNum getTxtBetuTanka() {
        return this.getTbShinsakaiIinBetuTanka().getShinsakaiIinBetuTankaMeisai().getTxtBetuTanka();
    }

    @JsonIgnore
    public void  setTxtBetuTanka(TextBoxNum txtBetuTanka) {
        this.getTbShinsakaiIinBetuTanka().getShinsakaiIinBetuTankaMeisai().setTxtBetuTanka(txtBetuTanka);
    }

    @JsonIgnore
    public TextBoxNum getTxtBetuSonotaTanka() {
        return this.getTbShinsakaiIinBetuTanka().getShinsakaiIinBetuTankaMeisai().getTxtBetuSonotaTanka();
    }

    @JsonIgnore
    public void  setTxtBetuSonotaTanka(TextBoxNum txtBetuSonotaTanka) {
        this.getTbShinsakaiIinBetuTanka().getShinsakaiIinBetuTankaMeisai().setTxtBetuSonotaTanka(txtBetuSonotaTanka);
    }

    @JsonIgnore
    public Button getBtnBetuKousin() {
        return this.getTbShinsakaiIinBetuTanka().getShinsakaiIinBetuTankaMeisai().getBtnBetuKousin();
    }

    @JsonIgnore
    public void  setBtnBetuKousin(Button btnBetuKousin) {
        this.getTbShinsakaiIinBetuTanka().getShinsakaiIinBetuTankaMeisai().setBtnBetuKousin(btnBetuKousin);
    }

    @JsonIgnore
    public Button getBtnBetuTorikesu() {
        return this.getTbShinsakaiIinBetuTanka().getShinsakaiIinBetuTankaMeisai().getBtnBetuTorikesu();
    }

    @JsonIgnore
    public void  setBtnBetuTorikesu(Button btnBetuTorikesu) {
        this.getTbShinsakaiIinBetuTanka().getShinsakaiIinBetuTankaMeisai().setBtnBetuTorikesu(btnBetuTorikesu);
    }

    // </editor-fold>
}
