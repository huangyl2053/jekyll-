package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.hihokenshashikakuhakko.HihokenshaShikakuHakko;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.ui.binding.CheckBoxList;
import jp.co.ndensan.reams.uz.uza.ui.binding.DropDownList;
import jp.co.ndensan.reams.uz.uza.ui.binding.Label;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBox;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDateRange;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxFlexibleDate;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxMultiLine;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxNum;

/**
 * HihokenshaShikakuHakko のクラスファイル
 *
 * @author 自動生成
 */
public class HihokenshaShikakuHakkoDiv extends Panel implements IHihokenshaShikakuHakkoDiv {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-03-22_14-06-37">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("YukoKigenInfo")
    private YukoKigenInfoDiv YukoKigenInfo;
    @JsonProperty("NinteiInfo")
    private NinteiInfoDiv NinteiInfo;
    @JsonProperty("tabHihokenshaShikakuShosai")
    private tabHihokenshaShikakuShosaiDiv tabHihokenshaShikakuShosai;
    @JsonProperty("hidden入所施設コード１")
    private RString hidden入所施設コード１;
    @JsonProperty("hidden入所施設種類１")
    private RString hidden入所施設種類１;
    @JsonProperty("hidden入所施設コード２")
    private RString hidden入所施設コード２;
    @JsonProperty("hidden入所施設種類２")
    private RString hidden入所施設種類２;
    @JsonProperty("hidden入所施設コード３")
    private RString hidden入所施設コード３;
    @JsonProperty("hidden入所施設種類３")
    private RString hidden入所施設種類３;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getYukoKigenInfo
     * @return YukoKigenInfo
     */
    @JsonProperty("YukoKigenInfo")
    public YukoKigenInfoDiv getYukoKigenInfo() {
        return YukoKigenInfo;
    }

    /*
     * setYukoKigenInfo
     * @param YukoKigenInfo YukoKigenInfo
     */
    @JsonProperty("YukoKigenInfo")
    public void setYukoKigenInfo(YukoKigenInfoDiv YukoKigenInfo) {
        this.YukoKigenInfo = YukoKigenInfo;
    }

    /*
     * getNinteiInfo
     * @return NinteiInfo
     */
    @JsonProperty("NinteiInfo")
    public NinteiInfoDiv getNinteiInfo() {
        return NinteiInfo;
    }

    /*
     * setNinteiInfo
     * @param NinteiInfo NinteiInfo
     */
    @JsonProperty("NinteiInfo")
    public void setNinteiInfo(NinteiInfoDiv NinteiInfo) {
        this.NinteiInfo = NinteiInfo;
    }

    /*
     * gettabHihokenshaShikakuShosai
     * @return tabHihokenshaShikakuShosai
     */
    @JsonProperty("tabHihokenshaShikakuShosai")
    public tabHihokenshaShikakuShosaiDiv getTabHihokenshaShikakuShosai() {
        return tabHihokenshaShikakuShosai;
    }

    /*
     * settabHihokenshaShikakuShosai
     * @param tabHihokenshaShikakuShosai tabHihokenshaShikakuShosai
     */
    @JsonProperty("tabHihokenshaShikakuShosai")
    public void setTabHihokenshaShikakuShosai(tabHihokenshaShikakuShosaiDiv tabHihokenshaShikakuShosai) {
        this.tabHihokenshaShikakuShosai = tabHihokenshaShikakuShosai;
    }

    /*
     * gethidden入所施設コード１
     * @return hidden入所施設コード１
     */
    @JsonProperty("hidden入所施設コード１")
    public RString getHidden入所施設コード１() {
        return hidden入所施設コード１;
    }

    /*
     * sethidden入所施設コード１
     * @param hidden入所施設コード１ hidden入所施設コード１
     */
    @JsonProperty("hidden入所施設コード１")
    public void setHidden入所施設コード１(RString hidden入所施設コード１) {
        this.hidden入所施設コード１ = hidden入所施設コード１;
    }

    /*
     * gethidden入所施設種類１
     * @return hidden入所施設種類１
     */
    @JsonProperty("hidden入所施設種類１")
    public RString getHidden入所施設種類１() {
        return hidden入所施設種類１;
    }

    /*
     * sethidden入所施設種類１
     * @param hidden入所施設種類１ hidden入所施設種類１
     */
    @JsonProperty("hidden入所施設種類１")
    public void setHidden入所施設種類１(RString hidden入所施設種類１) {
        this.hidden入所施設種類１ = hidden入所施設種類１;
    }

    /*
     * gethidden入所施設コード２
     * @return hidden入所施設コード２
     */
    @JsonProperty("hidden入所施設コード２")
    public RString getHidden入所施設コード２() {
        return hidden入所施設コード２;
    }

    /*
     * sethidden入所施設コード２
     * @param hidden入所施設コード２ hidden入所施設コード２
     */
    @JsonProperty("hidden入所施設コード２")
    public void setHidden入所施設コード２(RString hidden入所施設コード２) {
        this.hidden入所施設コード２ = hidden入所施設コード２;
    }

    /*
     * gethidden入所施設種類２
     * @return hidden入所施設種類２
     */
    @JsonProperty("hidden入所施設種類２")
    public RString getHidden入所施設種類２() {
        return hidden入所施設種類２;
    }

    /*
     * sethidden入所施設種類２
     * @param hidden入所施設種類２ hidden入所施設種類２
     */
    @JsonProperty("hidden入所施設種類２")
    public void setHidden入所施設種類２(RString hidden入所施設種類２) {
        this.hidden入所施設種類２ = hidden入所施設種類２;
    }

    /*
     * gethidden入所施設コード３
     * @return hidden入所施設コード３
     */
    @JsonProperty("hidden入所施設コード３")
    public RString getHidden入所施設コード３() {
        return hidden入所施設コード３;
    }

    /*
     * sethidden入所施設コード３
     * @param hidden入所施設コード３ hidden入所施設コード３
     */
    @JsonProperty("hidden入所施設コード３")
    public void setHidden入所施設コード３(RString hidden入所施設コード３) {
        this.hidden入所施設コード３ = hidden入所施設コード３;
    }

    /*
     * gethidden入所施設種類３
     * @return hidden入所施設種類３
     */
    @JsonProperty("hidden入所施設種類３")
    public RString getHidden入所施設種類３() {
        return hidden入所施設種類３;
    }

    /*
     * sethidden入所施設種類３
     * @param hidden入所施設種類３ hidden入所施設種類３
     */
    @JsonProperty("hidden入所施設種類３")
    public void setHidden入所施設種類３(RString hidden入所施設種類３) {
        this.hidden入所施設種類３ = hidden入所施設種類３;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public TextBoxDate getTxtYukoKigen() {
        return this.getYukoKigenInfo().getTxtYukoKigen();
    }

    @JsonIgnore
    public void setTxtYukoKigen(TextBoxDate txtYukoKigen) {
        this.getYukoKigenInfo().setTxtYukoKigen(txtYukoKigen);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtKofuDate() {
        return this.getYukoKigenInfo().getTxtKofuDate();
    }

    @JsonIgnore
    public void setTxtKofuDate(TextBoxFlexibleDate txtKofuDate) {
        this.getYukoKigenInfo().setTxtKofuDate(txtKofuDate);
    }

    @JsonIgnore
    public TextBox getTxtHokensha() {
        return this.getYukoKigenInfo().getTxtHokensha();
    }

    @JsonIgnore
    public void setTxtHokensha(TextBox txtHokensha) {
        this.getYukoKigenInfo().setTxtHokensha(txtHokensha);
    }

    @JsonIgnore
    public DropDownList getDdlKofuJiyu() {
        return this.getYukoKigenInfo().getDdlKofuJiyu();
    }

    @JsonIgnore
    public void setDdlKofuJiyu(DropDownList ddlKofuJiyu) {
        this.getYukoKigenInfo().setDdlKofuJiyu(ddlKofuJiyu);
    }

    @JsonIgnore
    public TextBox getTxtYokaigodo() {
        return this.getNinteiInfo().getTxtYokaigodo();
    }

    @JsonIgnore
    public void setTxtYokaigodo(TextBox txtYokaigodo) {
        this.getNinteiInfo().setTxtYokaigodo(txtYokaigodo);
    }

    @JsonIgnore
    public TextBoxDate getTxtNinteiYMD() {
        return this.getNinteiInfo().getTxtNinteiYMD();
    }

    @JsonIgnore
    public void setTxtNinteiYMD(TextBoxDate txtNinteiYMD) {
        this.getNinteiInfo().setTxtNinteiYMD(txtNinteiYMD);
    }

    @JsonIgnore
    public TextBoxDate getTxtNinteiYukoFromYMD() {
        return this.getNinteiInfo().getTxtNinteiYukoFromYMD();
    }

    @JsonIgnore
    public void setTxtNinteiYukoFromYMD(TextBoxDate txtNinteiYukoFromYMD) {
        this.getNinteiInfo().setTxtNinteiYukoFromYMD(txtNinteiYukoFromYMD);
    }

    @JsonIgnore
    public Label getLblKara1() {
        return this.getNinteiInfo().getLblKara1();
    }

    @JsonIgnore
    public void setLblKara1(Label lblKara1) {
        this.getNinteiInfo().setLblKara1(lblKara1);
    }

    @JsonIgnore
    public TextBoxDate getTxtNinteiYukoToYMD() {
        return this.getNinteiInfo().getTxtNinteiYukoToYMD();
    }

    @JsonIgnore
    public void setTxtNinteiYukoToYMD(TextBoxDate txtNinteiYukoToYMD) {
        this.getNinteiInfo().setTxtNinteiYukoToYMD(txtNinteiYukoToYMD);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtShinseiDate() {
        return this.getNinteiInfo().getTxtShinseiDate();
    }

    @JsonIgnore
    public void setTxtShinseiDate(TextBoxFlexibleDate txtShinseiDate) {
        this.getNinteiInfo().setTxtShinseiDate(txtShinseiDate);
    }

    @JsonIgnore
    public CheckBoxList getChkSeidoitsuseiShogai() {
        return this.getNinteiInfo().getChkSeidoitsuseiShogai();
    }

    @JsonIgnore
    public void setChkSeidoitsuseiShogai(CheckBoxList chkSeidoitsuseiShogai) {
        this.getNinteiInfo().setChkSeidoitsuseiShogai(chkSeidoitsuseiShogai);
    }

    @JsonIgnore
    public tplGendoGakuDiv getTplGendoGaku() {
        return this.getTabHihokenshaShikakuShosai().getTplGendoGaku();
    }

    @JsonIgnore
    public void setTplGendoGaku(tplGendoGakuDiv tplGendoGaku) {
        this.getTabHihokenshaShikakuShosai().setTplGendoGaku(tplGendoGaku);
    }

    @JsonIgnore
    public tblGendoGakuDiv getTblGendoGaku() {
        return this.getTabHihokenshaShikakuShosai().getTplGendoGaku().getTblGendoGaku();
    }

    @JsonIgnore
    public void setTblGendoGaku(tblGendoGakuDiv tblGendoGaku) {
        this.getTabHihokenshaShikakuShosai().getTplGendoGaku().setTblGendoGaku(tblGendoGaku);
    }

    @JsonIgnore
    public KubunGendoGakuDiv getKubunGendoGaku() {
        return this.getTabHihokenshaShikakuShosai().getTplGendoGaku().getTblGendoGaku().getKubunGendoGaku();
    }

    @JsonIgnore
    public TextBoxNum getTxtKubunShikyuGendoKijunGaku() {
        return this.getTabHihokenshaShikakuShosai().getTplGendoGaku().getTblGendoGaku().getKubunGendoGaku().getTxtKubunShikyuGendoKijunGaku();
    }

    @JsonIgnore
    public void setTxtKubunShikyuGendoKijunGaku(TextBoxNum txtKubunShikyuGendoKijunGaku) {
        this.getTabHihokenshaShikakuShosai().getTplGendoGaku().getTblGendoGaku().getKubunGendoGaku().setTxtKubunShikyuGendoKijunGaku(txtKubunShikyuGendoKijunGaku);
    }

    @JsonIgnore
    public TextBoxDate getTxtYukoFromYMD() {
        return this.getTabHihokenshaShikakuShosai().getTplGendoGaku().getTblGendoGaku().getKubunGendoGaku().getTxtYukoFromYMD();
    }

    @JsonIgnore
    public void setTxtYukoFromYMD(TextBoxDate txtYukoFromYMD) {
        this.getTabHihokenshaShikakuShosai().getTplGendoGaku().getTblGendoGaku().getKubunGendoGaku().setTxtYukoFromYMD(txtYukoFromYMD);
    }

    @JsonIgnore
    public Label getLblKara() {
        return this.getTabHihokenshaShikakuShosai().getTplGendoGaku().getTblGendoGaku().getKubunGendoGaku().getLblKara();
    }

    @JsonIgnore
    public void setLblKara(Label lblKara) {
        this.getTabHihokenshaShikakuShosai().getTplGendoGaku().getTblGendoGaku().getKubunGendoGaku().setLblKara(lblKara);
    }

    @JsonIgnore
    public TextBoxDate getTxtYukoToYMD() {
        return this.getTabHihokenshaShikakuShosai().getTplGendoGaku().getTblGendoGaku().getKubunGendoGaku().getTxtYukoToYMD();
    }

    @JsonIgnore
    public void setTxtYukoToYMD(TextBoxDate txtYukoToYMD) {
        this.getTabHihokenshaShikakuShosai().getTplGendoGaku().getTblGendoGaku().getKubunGendoGaku().setTxtYukoToYMD(txtYukoToYMD);
    }

    @JsonIgnore
    public ShuruiShikyuGendoKijungakuDiv getShuruiShikyuGendoKijungaku() {
        return this.getTabHihokenshaShikakuShosai().getTplGendoGaku().getTblGendoGaku().getShuruiShikyuGendoKijungaku();
    }

    @JsonIgnore
    public tplShinsakaiIkenDiv getTplShinsakaiIken() {
        return this.getTabHihokenshaShikakuShosai().getTplShinsakaiIken();
    }

    @JsonIgnore
    public void setTplShinsakaiIken(tplShinsakaiIkenDiv tplShinsakaiIken) {
        this.getTabHihokenshaShikakuShosai().setTplShinsakaiIken(tplShinsakaiIken);
    }

    @JsonIgnore
    public Label getLblShinsakaiIken() {
        return this.getTabHihokenshaShikakuShosai().getTplShinsakaiIken().getLblShinsakaiIken();
    }

    @JsonIgnore
    public void setLblShinsakaiIken(Label lblShinsakaiIken) {
        this.getTabHihokenshaShikakuShosai().getTplShinsakaiIken().setLblShinsakaiIken(lblShinsakaiIken);
    }

    @JsonIgnore
    public TextBoxMultiLine getTxtShinsakaiIken() {
        return this.getTabHihokenshaShikakuShosai().getTplShinsakaiIken().getTxtShinsakaiIken();
    }

    @JsonIgnore
    public void setTxtShinsakaiIken(TextBoxMultiLine txtShinsakaiIken) {
        this.getTabHihokenshaShikakuShosai().getTplShinsakaiIken().setTxtShinsakaiIken(txtShinsakaiIken);
    }

    @JsonIgnore
    public tplKyufuSeigenDiv getTplKyufuSeigen() {
        return this.getTabHihokenshaShikakuShosai().getTplKyufuSeigen();
    }

    @JsonIgnore
    public void setTplKyufuSeigen(tplKyufuSeigenDiv tplKyufuSeigen) {
        this.getTabHihokenshaShikakuShosai().setTplKyufuSeigen(tplKyufuSeigen);
    }

    @JsonIgnore
    public Label getLblKyufuSeigen() {
        return this.getTabHihokenshaShikakuShosai().getTplKyufuSeigen().getLblKyufuSeigen();
    }

    @JsonIgnore
    public void setLblKyufuSeigen(Label lblKyufuSeigen) {
        this.getTabHihokenshaShikakuShosai().getTplKyufuSeigen().setLblKyufuSeigen(lblKyufuSeigen);
    }

    @JsonIgnore
    public tblKyuhuSeigenDiv getTblKyuhuSeigen() {
        return this.getTabHihokenshaShikakuShosai().getTplKyufuSeigen().getTblKyuhuSeigen();
    }

    @JsonIgnore
    public void setTblKyuhuSeigen(tblKyuhuSeigenDiv tblKyuhuSeigen) {
        this.getTabHihokenshaShikakuShosai().getTplKyufuSeigen().setTblKyuhuSeigen(tblKyuhuSeigen);
    }

    @JsonIgnore
    public Label getLblKyufuSeigenNaiyo() {
        return this.getTabHihokenshaShikakuShosai().getTplKyufuSeigen().getTblKyuhuSeigen().getLblKyufuSeigenNaiyo();
    }

    @JsonIgnore
    public Label getLblKyufuSeigenKikan() {
        return this.getTabHihokenshaShikakuShosai().getTplKyufuSeigen().getTblKyuhuSeigen().getLblKyufuSeigenKikan();
    }

    @JsonIgnore
    public TextBox getTxtKyufuSeigenNaiyo1() {
        return this.getTabHihokenshaShikakuShosai().getTplKyufuSeigen().getTblKyuhuSeigen().getTxtKyufuSeigenNaiyo1();
    }

    @JsonIgnore
    public TextBoxDateRange getTxtKyufuSeigenKikan1() {
        return this.getTabHihokenshaShikakuShosai().getTplKyufuSeigen().getTblKyuhuSeigen().getTxtKyufuSeigenKikan1();
    }

    @JsonIgnore
    public TextBox getTxtKyufuSeigenNaiyo2() {
        return this.getTabHihokenshaShikakuShosai().getTplKyufuSeigen().getTblKyuhuSeigen().getTxtKyufuSeigenNaiyo2();
    }

    @JsonIgnore
    public TextBoxDateRange getTxtKyufuSeigenKikan2() {
        return this.getTabHihokenshaShikakuShosai().getTplKyufuSeigen().getTblKyuhuSeigen().getTxtKyufuSeigenKikan2();
    }

    @JsonIgnore
    public TextBox getTxtKyufuSeigenNaiyo3() {
        return this.getTabHihokenshaShikakuShosai().getTplKyufuSeigen().getTblKyuhuSeigen().getTxtKyufuSeigenNaiyo3();
    }

    @JsonIgnore
    public TextBoxDateRange getTxtKyufuSeigenKikan3() {
        return this.getTabHihokenshaShikakuShosai().getTplKyufuSeigen().getTblKyuhuSeigen().getTxtKyufuSeigenKikan3();
    }

    @JsonIgnore
    public tplShienJigyoshaDiv getTplShienJigyosha() {
        return this.getTabHihokenshaShikakuShosai().getTplShienJigyosha();
    }

    @JsonIgnore
    public void setTplShienJigyosha(tplShienJigyoshaDiv tplShienJigyosha) {
        this.getTabHihokenshaShikakuShosai().setTplShienJigyosha(tplShienJigyosha);
    }

    @JsonIgnore
    public Label getLblShienJigyosha() {
        return this.getTabHihokenshaShikakuShosai().getTplShienJigyosha().getLblShienJigyosha();
    }

    @JsonIgnore
    public void setLblShienJigyosha(Label lblShienJigyosha) {
        this.getTabHihokenshaShikakuShosai().getTplShienJigyosha().setLblShienJigyosha(lblShienJigyosha);
    }

    @JsonIgnore
    public tblJigyoshaDiv getTblJigyosha() {
        return this.getTabHihokenshaShikakuShosai().getTplShienJigyosha().getTblJigyosha();
    }

    @JsonIgnore
    public void setTblJigyosha(tblJigyoshaDiv tblJigyosha) {
        this.getTabHihokenshaShikakuShosai().getTplShienJigyosha().setTblJigyosha(tblJigyosha);
    }

    @JsonIgnore
    public Label getLblJigyosha() {
        return this.getTabHihokenshaShikakuShosai().getTplShienJigyosha().getTblJigyosha().getLblJigyosha();
    }

    @JsonIgnore
    public Label getLblTodokedeDate() {
        return this.getTabHihokenshaShikakuShosai().getTplShienJigyosha().getTblJigyosha().getLblTodokedeDate();
    }

    @JsonIgnore
    public Label getLblTekiyoStYMD() {
        return this.getTabHihokenshaShikakuShosai().getTplShienJigyosha().getTblJigyosha().getLblTekiyoStYMD();
    }

    @JsonIgnore
    public TextBox getTxtJigyosha1() {
        return this.getTabHihokenshaShikakuShosai().getTplShienJigyosha().getTblJigyosha().getTxtJigyosha1();
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtTodokedeYMD1() {
        return this.getTabHihokenshaShikakuShosai().getTplShienJigyosha().getTblJigyosha().getTxtTodokedeYMD1();
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtTekiyoStYMD1() {
        return this.getTabHihokenshaShikakuShosai().getTplShienJigyosha().getTblJigyosha().getTxtTekiyoStYMD1();
    }

    @JsonIgnore
    public TextBox getTxtJigyosha2() {
        return this.getTabHihokenshaShikakuShosai().getTplShienJigyosha().getTblJigyosha().getTxtJigyosha2();
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtTodokedeYMD2() {
        return this.getTabHihokenshaShikakuShosai().getTplShienJigyosha().getTblJigyosha().getTxtTodokedeYMD2();
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtTekiyoStYMD2() {
        return this.getTabHihokenshaShikakuShosai().getTplShienJigyosha().getTblJigyosha().getTxtTekiyoStYMD2();
    }

    @JsonIgnore
    public TextBox getTxtJigyosha3() {
        return this.getTabHihokenshaShikakuShosai().getTplShienJigyosha().getTblJigyosha().getTxtJigyosha3();
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtTodokedeYMD3() {
        return this.getTabHihokenshaShikakuShosai().getTplShienJigyosha().getTblJigyosha().getTxtTodokedeYMD3();
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtTekiyoStYMD3() {
        return this.getTabHihokenshaShikakuShosai().getTplShienJigyosha().getTblJigyosha().getTxtTekiyoStYMD3();
    }

    @JsonIgnore
    public tplShisetsuNyutaishoDiv getTplShisetsuNyutaisho() {
        return this.getTabHihokenshaShikakuShosai().getTplShisetsuNyutaisho();
    }

    @JsonIgnore
    public void setTplShisetsuNyutaisho(tplShisetsuNyutaishoDiv tplShisetsuNyutaisho) {
        this.getTabHihokenshaShikakuShosai().setTplShisetsuNyutaisho(tplShisetsuNyutaisho);
    }

    @JsonIgnore
    public Label getLblKaigoHokensha() {
        return this.getTabHihokenshaShikakuShosai().getTplShisetsuNyutaisho().getLblKaigoHokensha();
    }

    @JsonIgnore
    public void setLblKaigoHokensha(Label lblKaigoHokensha) {
        this.getTabHihokenshaShikakuShosai().getTplShisetsuNyutaisho().setLblKaigoHokensha(lblKaigoHokensha);
    }

    @JsonIgnore
    public tblShisetsuNyutaishoDiv getTblShisetsuNyutaisho() {
        return this.getTabHihokenshaShikakuShosai().getTplShisetsuNyutaisho().getTblShisetsuNyutaisho();
    }

    @JsonIgnore
    public void setTblShisetsuNyutaisho(tblShisetsuNyutaishoDiv tblShisetsuNyutaisho) {
        this.getTabHihokenshaShikakuShosai().getTplShisetsuNyutaisho().setTblShisetsuNyutaisho(tblShisetsuNyutaisho);
    }

    @JsonIgnore
    public Label getLblNyushoShisetsu() {
        return this.getTabHihokenshaShikakuShosai().getTplShisetsuNyutaisho().getTblShisetsuNyutaisho().getLblNyushoShisetsu();
    }

    @JsonIgnore
    public Label getLblShisetsuNyushoDate() {
        return this.getTabHihokenshaShikakuShosai().getTplShisetsuNyutaisho().getTblShisetsuNyutaisho().getLblShisetsuNyushoDate();
    }

    @JsonIgnore
    public Label getLblShisetsuTaishoDate() {
        return this.getTabHihokenshaShikakuShosai().getTplShisetsuNyutaisho().getTblShisetsuNyutaisho().getLblShisetsuTaishoDate();
    }

    @JsonIgnore
    public TextBox getTxtNyushoShisetsu1() {
        return this.getTabHihokenshaShikakuShosai().getTplShisetsuNyutaisho().getTblShisetsuNyutaisho().getTxtNyushoShisetsu1();
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtShisetsuNyushoDate1() {
        return this.getTabHihokenshaShikakuShosai().getTplShisetsuNyutaisho().getTblShisetsuNyutaisho().getTxtShisetsuNyushoDate1();
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtShisetsuTaishoDate1() {
        return this.getTabHihokenshaShikakuShosai().getTplShisetsuNyutaisho().getTblShisetsuNyutaisho().getTxtShisetsuTaishoDate1();
    }

    @JsonIgnore
    public TextBox getTxtNyushoShisetsu2() {
        return this.getTabHihokenshaShikakuShosai().getTplShisetsuNyutaisho().getTblShisetsuNyutaisho().getTxtNyushoShisetsu2();
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtShisetsuNyushoDate2() {
        return this.getTabHihokenshaShikakuShosai().getTplShisetsuNyutaisho().getTblShisetsuNyutaisho().getTxtShisetsuNyushoDate2();
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtShisetsuTaishoDate2() {
        return this.getTabHihokenshaShikakuShosai().getTplShisetsuNyutaisho().getTblShisetsuNyutaisho().getTxtShisetsuTaishoDate2();
    }

    @JsonIgnore
    public TextBox getTxtNyushoShisetsu3() {
        return this.getTabHihokenshaShikakuShosai().getTplShisetsuNyutaisho().getTblShisetsuNyutaisho().getTxtNyushoShisetsu3();
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtShisetsuNyushoDate3() {
        return this.getTabHihokenshaShikakuShosai().getTplShisetsuNyutaisho().getTblShisetsuNyutaisho().getTxtShisetsuNyushoDate3();
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtShisetsuTaishoDate3() {
        return this.getTabHihokenshaShikakuShosai().getTplShisetsuNyutaisho().getTblShisetsuNyutaisho().getTxtShisetsuTaishoDate3();
    }

    // </editor-fold>
    //--------------- この行より下にコードを追加してください -------------------
    @Override
    public void initialize(HihokenshaNo 被保険者番号, RString メニューID) {
        HihokenshaShikakuHakkoHandler handler = new HihokenshaShikakuHakkoHandler(this);
        handler.initialize(被保険者番号, メニューID);
    }
}
