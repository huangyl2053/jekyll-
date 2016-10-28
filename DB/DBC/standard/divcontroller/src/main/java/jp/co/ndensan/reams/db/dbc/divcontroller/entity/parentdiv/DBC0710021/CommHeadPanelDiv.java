package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0710021;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.ShiharaiHohoJyoho.ShiharaiHohoJyoho.IShiharaiHohoJyohoDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.jyutakugaisyunaiyolist.JyutakugaisyunaiyoList.IJyutakugaisyunaiyoListDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * CommHeadPanel のクラスファイル
 *
 * @reamsid_L DBC-0992-120 yebangqiang
 */
public class CommHeadPanelDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-10-07_19-12-57">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("UpLine")
    private HorizontalLine UpLine;
    @JsonProperty("btnShinseiJyoho")
    private Button btnShinseiJyoho;
    @JsonProperty("btnShokanKetteiJyoho")
    private Button btnShokanKetteiJyoho;
    @JsonProperty("DownLine")
    private HorizontalLine DownLine;
    @JsonProperty("txtTeikyoYM")
    private TextBoxDate txtTeikyoYM;
    @JsonProperty("txtSeiriNo")
    private TextBoxCode txtSeiriNo;
    @JsonProperty("ddlSyomeisyo")
    private DropDownList ddlSyomeisyo;
    @JsonProperty("txtKyufuritsu")
    private TextBoxNum txtKyufuritsu;
    @JsonProperty("tabShinseiContents")
    private tabShinseiContentsDiv tabShinseiContents;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getUpLine
     * @return UpLine
     */
    @JsonProperty("UpLine")
    public HorizontalLine getUpLine() {
        return UpLine;
    }

    /*
     * setUpLine
     * @param UpLine UpLine
     */
    @JsonProperty("UpLine")
    public void setUpLine(HorizontalLine UpLine) {
        this.UpLine = UpLine;
    }

    /*
     * getbtnShinseiJyoho
     * @return btnShinseiJyoho
     */
    @JsonProperty("btnShinseiJyoho")
    public Button getBtnShinseiJyoho() {
        return btnShinseiJyoho;
    }

    /*
     * setbtnShinseiJyoho
     * @param btnShinseiJyoho btnShinseiJyoho
     */
    @JsonProperty("btnShinseiJyoho")
    public void setBtnShinseiJyoho(Button btnShinseiJyoho) {
        this.btnShinseiJyoho = btnShinseiJyoho;
    }

    /*
     * getbtnShokanKetteiJyoho
     * @return btnShokanKetteiJyoho
     */
    @JsonProperty("btnShokanKetteiJyoho")
    public Button getBtnShokanKetteiJyoho() {
        return btnShokanKetteiJyoho;
    }

    /*
     * setbtnShokanKetteiJyoho
     * @param btnShokanKetteiJyoho btnShokanKetteiJyoho
     */
    @JsonProperty("btnShokanKetteiJyoho")
    public void setBtnShokanKetteiJyoho(Button btnShokanKetteiJyoho) {
        this.btnShokanKetteiJyoho = btnShokanKetteiJyoho;
    }

    /*
     * getDownLine
     * @return DownLine
     */
    @JsonProperty("DownLine")
    public HorizontalLine getDownLine() {
        return DownLine;
    }

    /*
     * setDownLine
     * @param DownLine DownLine
     */
    @JsonProperty("DownLine")
    public void setDownLine(HorizontalLine DownLine) {
        this.DownLine = DownLine;
    }

    /*
     * gettxtTeikyoYM
     * @return txtTeikyoYM
     */
    @JsonProperty("txtTeikyoYM")
    public TextBoxDate getTxtTeikyoYM() {
        return txtTeikyoYM;
    }

    /*
     * settxtTeikyoYM
     * @param txtTeikyoYM txtTeikyoYM
     */
    @JsonProperty("txtTeikyoYM")
    public void setTxtTeikyoYM(TextBoxDate txtTeikyoYM) {
        this.txtTeikyoYM = txtTeikyoYM;
    }

    /*
     * gettxtSeiriNo
     * @return txtSeiriNo
     */
    @JsonProperty("txtSeiriNo")
    public TextBoxCode getTxtSeiriNo() {
        return txtSeiriNo;
    }

    /*
     * settxtSeiriNo
     * @param txtSeiriNo txtSeiriNo
     */
    @JsonProperty("txtSeiriNo")
    public void setTxtSeiriNo(TextBoxCode txtSeiriNo) {
        this.txtSeiriNo = txtSeiriNo;
    }

    /*
     * getddlSyomeisyo
     * @return ddlSyomeisyo
     */
    @JsonProperty("ddlSyomeisyo")
    public DropDownList getDdlSyomeisyo() {
        return ddlSyomeisyo;
    }

    /*
     * setddlSyomeisyo
     * @param ddlSyomeisyo ddlSyomeisyo
     */
    @JsonProperty("ddlSyomeisyo")
    public void setDdlSyomeisyo(DropDownList ddlSyomeisyo) {
        this.ddlSyomeisyo = ddlSyomeisyo;
    }

    /*
     * gettxtKyufuritsu
     * @return txtKyufuritsu
     */
    @JsonProperty("txtKyufuritsu")
    public TextBoxNum getTxtKyufuritsu() {
        return txtKyufuritsu;
    }

    /*
     * settxtKyufuritsu
     * @param txtKyufuritsu txtKyufuritsu
     */
    @JsonProperty("txtKyufuritsu")
    public void setTxtKyufuritsu(TextBoxNum txtKyufuritsu) {
        this.txtKyufuritsu = txtKyufuritsu;
    }

    /*
     * gettabShinseiContents
     * @return tabShinseiContents
     */
    @JsonProperty("tabShinseiContents")
    public tabShinseiContentsDiv getTabShinseiContents() {
        return tabShinseiContents;
    }

    /*
     * settabShinseiContents
     * @param tabShinseiContents tabShinseiContents
     */
    @JsonProperty("tabShinseiContents")
    public void setTabShinseiContents(tabShinseiContentsDiv tabShinseiContents) {
        this.tabShinseiContents = tabShinseiContents;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public tabShinseiJyohoDiv getTabShinseiJyoho() {
        return this.getTabShinseiContents().getTabShinseiJyoho();
    }

    @JsonIgnore
    public void setTabShinseiJyoho(tabShinseiJyohoDiv tabShinseiJyoho) {
        this.getTabShinseiContents().setTabShinseiJyoho(tabShinseiJyoho);
    }

    @JsonIgnore
    public JutakuKaishuShinseiContentsDiv getJutakuKaishuShinseiContents() {
        return this.getTabShinseiContents().getTabShinseiJyoho().getJutakuKaishuShinseiContents();
    }

    @JsonIgnore
    public void setJutakuKaishuShinseiContents(JutakuKaishuShinseiContentsDiv JutakuKaishuShinseiContents) {
        this.getTabShinseiContents().getTabShinseiJyoho().setJutakuKaishuShinseiContents(JutakuKaishuShinseiContents);
    }

    @JsonIgnore
    public tabKozaJyohoDiv getTabKozaJyoho() {
        return this.getTabShinseiContents().getTabKozaJyoho();
    }

    @JsonIgnore
    public void setTabKozaJyoho(tabKozaJyohoDiv tabKozaJyoho) {
        this.getTabShinseiContents().setTabKozaJyoho(tabKozaJyoho);
    }

    @JsonIgnore
    public IShiharaiHohoJyohoDiv getCcdShiharaiHohoJyoho() {
        return this.getTabShinseiContents().getTabKozaJyoho().getCcdShiharaiHohoJyoho();
    }

    @JsonIgnore
    public tabJutakuKaisyuJyohoDiv getTabJutakuKaisyuJyoho() {
        return this.getTabShinseiContents().getTabJutakuKaisyuJyoho();
    }

    @JsonIgnore
    public void setTabJutakuKaisyuJyoho(tabJutakuKaisyuJyohoDiv tabJutakuKaisyuJyoho) {
        this.getTabShinseiContents().setTabJutakuKaisyuJyoho(tabJutakuKaisyuJyoho);
    }

    @JsonIgnore
    public JutakuKaishuShinseiResetInfoDiv getJutakuKaishuShinseiResetInfo() {
        return this.getTabShinseiContents().getTabJutakuKaisyuJyoho().getJutakuKaishuShinseiResetInfo();
    }

    @JsonIgnore
    public void setJutakuKaishuShinseiResetInfo(JutakuKaishuShinseiResetInfoDiv JutakuKaishuShinseiResetInfo) {
        this.getTabShinseiContents().getTabJutakuKaisyuJyoho().setJutakuKaishuShinseiResetInfo(JutakuKaishuShinseiResetInfo);
    }

    @JsonIgnore
    public IJyutakugaisyunaiyoListDiv getCcdJutakugaisyunaiyoList() {
        return this.getTabShinseiContents().getTabJutakuKaisyuJyoho().getCcdJutakugaisyunaiyoList();
    }

    // </editor-fold>
}
