package jp.co.ndensan.reams.db.dbz.divcontroller.entity.parentdiv.DBZA010001;
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
 * ShikakuFuseigoShuseiMain のクラスファイル 
 * 
 * @author 自動生成
 */
public class ShikakuFuseigoShuseiMainDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-03-22_14-06-37">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ShikakuFuseigoIchiran")
    private ShikakuFuseigoIchiranDiv ShikakuFuseigoIchiran;
    @JsonProperty("ShikakuShusei")
    private ShikakuShuseiDiv ShikakuShusei;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getShikakuFuseigoIchiran
     * @return ShikakuFuseigoIchiran
     */
    @JsonProperty("ShikakuFuseigoIchiran")
    public ShikakuFuseigoIchiranDiv getShikakuFuseigoIchiran() {
        return ShikakuFuseigoIchiran;
    }

    /*
     * setShikakuFuseigoIchiran
     * @param ShikakuFuseigoIchiran ShikakuFuseigoIchiran
     */
    @JsonProperty("ShikakuFuseigoIchiran")
    public void setShikakuFuseigoIchiran(ShikakuFuseigoIchiranDiv ShikakuFuseigoIchiran) {
        this.ShikakuFuseigoIchiran = ShikakuFuseigoIchiran;
    }

    /*
     * getShikakuShusei
     * @return ShikakuShusei
     */
    @JsonProperty("ShikakuShusei")
    public ShikakuShuseiDiv getShikakuShusei() {
        return ShikakuShusei;
    }

    /*
     * setShikakuShusei
     * @param ShikakuShusei ShikakuShusei
     */
    @JsonProperty("ShikakuShusei")
    public void setShikakuShusei(ShikakuShuseiDiv ShikakuShusei) {
        this.ShikakuShusei = ShikakuShusei;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public DropDownList getDdlDaichoShubetsu() {
        return this.getShikakuFuseigoIchiran().getDdlDaichoShubetsu();
    }

    @JsonIgnore
    public void  setDdlDaichoShubetsu(DropDownList ddlDaichoShubetsu) {
        this.getShikakuFuseigoIchiran().setDdlDaichoShubetsu(ddlDaichoShubetsu);
    }

    @JsonIgnore
    public TextBox getTxtShoriDateTime() {
        return this.getShikakuFuseigoIchiran().getTxtShoriDateTime();
    }

    @JsonIgnore
    public void  setTxtShoriDateTime(TextBox txtShoriDateTime) {
        this.getShikakuFuseigoIchiran().setTxtShoriDateTime(txtShoriDateTime);
    }

    @JsonIgnore
    public CheckBoxList getChkTaishoGaiHyoji() {
        return this.getShikakuFuseigoIchiran().getChkTaishoGaiHyoji();
    }

    @JsonIgnore
    public void  setChkTaishoGaiHyoji(CheckBoxList chkTaishoGaiHyoji) {
        this.getShikakuFuseigoIchiran().setChkTaishoGaiHyoji(chkTaishoGaiHyoji);
    }

    @JsonIgnore
    public DataGrid<dgShikakuFuseigoIchiran_Row> getDgShikakuFuseigoIchiran() {
        return this.getShikakuFuseigoIchiran().getDgShikakuFuseigoIchiran();
    }

    @JsonIgnore
    public void  setDgShikakuFuseigoIchiran(DataGrid<dgShikakuFuseigoIchiran_Row> dgShikakuFuseigoIchiran) {
        this.getShikakuFuseigoIchiran().setDgShikakuFuseigoIchiran(dgShikakuFuseigoIchiran);
    }

    @JsonIgnore
    public ShikakuShuseiTaishoDiv getShikakuShuseiTaisho() {
        return this.getShikakuShusei().getShikakuShuseiTaisho();
    }

    @JsonIgnore
    public void  setShikakuShuseiTaisho(ShikakuShuseiTaishoDiv ShikakuShuseiTaisho) {
        this.getShikakuShusei().setShikakuShuseiTaisho(ShikakuShuseiTaisho);
    }

    @JsonIgnore
    public CheckBoxList getChkToTaishoGai() {
        return this.getShikakuShusei().getShikakuShuseiTaisho().getChkToTaishoGai();
    }

    @JsonIgnore
    public void  setChkToTaishoGai(CheckBoxList chkToTaishoGai) {
        this.getShikakuShusei().getShikakuShuseiTaisho().setChkToTaishoGai(chkToTaishoGai);
    }

    @JsonIgnore
    public TextBox getTxtFusugoNaiyo() {
        return this.getShikakuShusei().getShikakuShuseiTaisho().getTxtFusugoNaiyo();
    }

    @JsonIgnore
    public void  setTxtFusugoNaiyo(TextBox txtFusugoNaiyo) {
        this.getShikakuShusei().getShikakuShuseiTaisho().setTxtFusugoNaiyo(txtFusugoNaiyo);
    }

    @JsonIgnore
    public TextBoxCode getTxtHihoNo() {
        return this.getShikakuShusei().getShikakuShuseiTaisho().getTxtHihoNo();
    }

    @JsonIgnore
    public void  setTxtHihoNo(TextBoxCode txtHihoNo) {
        this.getShikakuShusei().getShikakuShuseiTaisho().setTxtHihoNo(txtHihoNo);
    }

    @JsonIgnore
    public TextBoxCode getTxtShikibetsuCode() {
        return this.getShikakuShusei().getShikakuShuseiTaisho().getTxtShikibetsuCode();
    }

    @JsonIgnore
    public void  setTxtShikibetsuCode(TextBoxCode txtShikibetsuCode) {
        this.getShikakuShusei().getShikakuShuseiTaisho().setTxtShikibetsuCode(txtShikibetsuCode);
    }

    @JsonIgnore
    public TextBox getTxtJuminJotai() {
        return this.getShikakuShusei().getShikakuShuseiTaisho().getTxtJuminJotai();
    }

    @JsonIgnore
    public void  setTxtJuminJotai(TextBox txtJuminJotai) {
        this.getShikakuShusei().getShikakuShuseiTaisho().setTxtJuminJotai(txtJuminJotai);
    }

    @JsonIgnore
    public TextBox getTxtSeibetsu() {
        return this.getShikakuShusei().getShikakuShuseiTaisho().getTxtSeibetsu();
    }

    @JsonIgnore
    public void  setTxtSeibetsu(TextBox txtSeibetsu) {
        this.getShikakuShusei().getShikakuShuseiTaisho().setTxtSeibetsu(txtSeibetsu);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtUmareYmd() {
        return this.getShikakuShusei().getShikakuShuseiTaisho().getTxtUmareYmd();
    }

    @JsonIgnore
    public void  setTxtUmareYmd(TextBoxFlexibleDate txtUmareYmd) {
        this.getShikakuShusei().getShikakuShuseiTaisho().setTxtUmareYmd(txtUmareYmd);
    }

    @JsonIgnore
    public TextBox getTxtNenrei() {
        return this.getShikakuShusei().getShikakuShuseiTaisho().getTxtNenrei();
    }

    @JsonIgnore
    public void  setTxtNenrei(TextBox txtNenrei) {
        this.getShikakuShusei().getShikakuShuseiTaisho().setTxtNenrei(txtNenrei);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxt1goTotatsuYmd() {
        return this.getShikakuShusei().getShikakuShuseiTaisho().getTxt1goTotatsuYmd();
    }

    @JsonIgnore
    public void  setTxt1goTotatsuYmd(TextBoxFlexibleDate txt1goTotatsuYmd) {
        this.getShikakuShusei().getShikakuShuseiTaisho().setTxt1goTotatsuYmd(txt1goTotatsuYmd);
    }

    @JsonIgnore
    public TextBox getTxtShimei() {
        return this.getShikakuShusei().getShikakuShuseiTaisho().getTxtShimei();
    }

    @JsonIgnore
    public void  setTxtShimei(TextBox txtShimei) {
        this.getShikakuShusei().getShikakuShuseiTaisho().setTxtShimei(txtShimei);
    }

    @JsonIgnore
    public TextBox getTxtJukiTorokuJiyu() {
        return this.getShikakuShusei().getShikakuShuseiTaisho().getTxtJukiTorokuJiyu();
    }

    @JsonIgnore
    public void  setTxtJukiTorokuJiyu(TextBox txtJukiTorokuJiyu) {
        this.getShikakuShusei().getShikakuShuseiTaisho().setTxtJukiTorokuJiyu(txtJukiTorokuJiyu);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtTorokuIdoYmd() {
        return this.getShikakuShusei().getShikakuShuseiTaisho().getTxtTorokuIdoYmd();
    }

    @JsonIgnore
    public void  setTxtTorokuIdoYmd(TextBoxFlexibleDate txtTorokuIdoYmd) {
        this.getShikakuShusei().getShikakuShuseiTaisho().setTxtTorokuIdoYmd(txtTorokuIdoYmd);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtTorokuTodokedeYmd() {
        return this.getShikakuShusei().getShikakuShuseiTaisho().getTxtTorokuTodokedeYmd();
    }

    @JsonIgnore
    public void  setTxtTorokuTodokedeYmd(TextBoxFlexibleDate txtTorokuTodokedeYmd) {
        this.getShikakuShusei().getShikakuShuseiTaisho().setTxtTorokuTodokedeYmd(txtTorokuTodokedeYmd);
    }

    @JsonIgnore
    public SikakuShutokuDiv getSikakuShutoku() {
        return this.getShikakuShusei().getSikakuShutoku();
    }

    @JsonIgnore
    public void  setSikakuShutoku(SikakuShutokuDiv SikakuShutoku) {
        this.getShikakuShusei().setSikakuShutoku(SikakuShutoku);
    }

    @JsonIgnore
    public Label getLblGenzai01() {
        return this.getShikakuShusei().getSikakuShutoku().getLblGenzai01();
    }

    @JsonIgnore
    public void  setLblGenzai01(Label lblGenzai01) {
        this.getShikakuShusei().getSikakuShutoku().setLblGenzai01(lblGenzai01);
    }

    @JsonIgnore
    public TextBox getTxtCurrentShikakuShutokuJiyu() {
        return this.getShikakuShusei().getSikakuShutoku().getTxtCurrentShikakuShutokuJiyu();
    }

    @JsonIgnore
    public void  setTxtCurrentShikakuShutokuJiyu(TextBox txtCurrentShikakuShutokuJiyu) {
        this.getShikakuShusei().getSikakuShutoku().setTxtCurrentShikakuShutokuJiyu(txtCurrentShikakuShutokuJiyu);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtCurrentShikakuShutokuYmd() {
        return this.getShikakuShusei().getSikakuShutoku().getTxtCurrentShikakuShutokuYmd();
    }

    @JsonIgnore
    public void  setTxtCurrentShikakuShutokuYmd(TextBoxFlexibleDate txtCurrentShikakuShutokuYmd) {
        this.getShikakuShusei().getSikakuShutoku().setTxtCurrentShikakuShutokuYmd(txtCurrentShikakuShutokuYmd);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtCurrentShikakuShutokuTodokedeYmd() {
        return this.getShikakuShusei().getSikakuShutoku().getTxtCurrentShikakuShutokuTodokedeYmd();
    }

    @JsonIgnore
    public void  setTxtCurrentShikakuShutokuTodokedeYmd(TextBoxFlexibleDate txtCurrentShikakuShutokuTodokedeYmd) {
        this.getShikakuShusei().getSikakuShutoku().setTxtCurrentShikakuShutokuTodokedeYmd(txtCurrentShikakuShutokuTodokedeYmd);
    }

    @JsonIgnore
    public Label getLblShuseiGo01() {
        return this.getShikakuShusei().getSikakuShutoku().getLblShuseiGo01();
    }

    @JsonIgnore
    public void  setLblShuseiGo01(Label lblShuseiGo01) {
        this.getShikakuShusei().getSikakuShutoku().setLblShuseiGo01(lblShuseiGo01);
    }

    @JsonIgnore
    public DropDownList getDdlShikakuShutokuJiyu() {
        return this.getShikakuShusei().getSikakuShutoku().getDdlShikakuShutokuJiyu();
    }

    @JsonIgnore
    public void  setDdlShikakuShutokuJiyu(DropDownList ddlShikakuShutokuJiyu) {
        this.getShikakuShusei().getSikakuShutoku().setDdlShikakuShutokuJiyu(ddlShikakuShutokuJiyu);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtShikakuShutokuYmd() {
        return this.getShikakuShusei().getSikakuShutoku().getTxtShikakuShutokuYmd();
    }

    @JsonIgnore
    public void  setTxtShikakuShutokuYmd(TextBoxFlexibleDate txtShikakuShutokuYmd) {
        this.getShikakuShusei().getSikakuShutoku().setTxtShikakuShutokuYmd(txtShikakuShutokuYmd);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtShikakuShutokuTodokedeYmd() {
        return this.getShikakuShusei().getSikakuShutoku().getTxtShikakuShutokuTodokedeYmd();
    }

    @JsonIgnore
    public void  setTxtShikakuShutokuTodokedeYmd(TextBoxFlexibleDate txtShikakuShutokuTodokedeYmd) {
        this.getShikakuShusei().getSikakuShutoku().setTxtShikakuShutokuTodokedeYmd(txtShikakuShutokuTodokedeYmd);
    }

    @JsonIgnore
    public ShikakuHenkoDiv getShikakuHenko() {
        return this.getShikakuShusei().getShikakuHenko();
    }

    @JsonIgnore
    public void  setShikakuHenko(ShikakuHenkoDiv ShikakuHenko) {
        this.getShikakuShusei().setShikakuHenko(ShikakuHenko);
    }

    @JsonIgnore
    public Label getLblGenzai05() {
        return this.getShikakuShusei().getShikakuHenko().getLblGenzai05();
    }

    @JsonIgnore
    public void  setLblGenzai05(Label lblGenzai05) {
        this.getShikakuShusei().getShikakuHenko().setLblGenzai05(lblGenzai05);
    }

    @JsonIgnore
    public TextBox getTxtCurrentShikakuHenkoJiyu() {
        return this.getShikakuShusei().getShikakuHenko().getTxtCurrentShikakuHenkoJiyu();
    }

    @JsonIgnore
    public void  setTxtCurrentShikakuHenkoJiyu(TextBox txtCurrentShikakuHenkoJiyu) {
        this.getShikakuShusei().getShikakuHenko().setTxtCurrentShikakuHenkoJiyu(txtCurrentShikakuHenkoJiyu);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtCurrentShikakuHenkoYmd() {
        return this.getShikakuShusei().getShikakuHenko().getTxtCurrentShikakuHenkoYmd();
    }

    @JsonIgnore
    public void  setTxtCurrentShikakuHenkoYmd(TextBoxFlexibleDate txtCurrentShikakuHenkoYmd) {
        this.getShikakuShusei().getShikakuHenko().setTxtCurrentShikakuHenkoYmd(txtCurrentShikakuHenkoYmd);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtCurrentShikakuHenkoTodokedeYmd() {
        return this.getShikakuShusei().getShikakuHenko().getTxtCurrentShikakuHenkoTodokedeYmd();
    }

    @JsonIgnore
    public void  setTxtCurrentShikakuHenkoTodokedeYmd(TextBoxFlexibleDate txtCurrentShikakuHenkoTodokedeYmd) {
        this.getShikakuShusei().getShikakuHenko().setTxtCurrentShikakuHenkoTodokedeYmd(txtCurrentShikakuHenkoTodokedeYmd);
    }

    @JsonIgnore
    public Label getLblShuseiGo05() {
        return this.getShikakuShusei().getShikakuHenko().getLblShuseiGo05();
    }

    @JsonIgnore
    public void  setLblShuseiGo05(Label lblShuseiGo05) {
        this.getShikakuShusei().getShikakuHenko().setLblShuseiGo05(lblShuseiGo05);
    }

    @JsonIgnore
    public DropDownList getDdlShikakuHenkoJiyu() {
        return this.getShikakuShusei().getShikakuHenko().getDdlShikakuHenkoJiyu();
    }

    @JsonIgnore
    public void  setDdlShikakuHenkoJiyu(DropDownList ddlShikakuHenkoJiyu) {
        this.getShikakuShusei().getShikakuHenko().setDdlShikakuHenkoJiyu(ddlShikakuHenkoJiyu);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtShikakuHenkoYmd() {
        return this.getShikakuShusei().getShikakuHenko().getTxtShikakuHenkoYmd();
    }

    @JsonIgnore
    public void  setTxtShikakuHenkoYmd(TextBoxFlexibleDate txtShikakuHenkoYmd) {
        this.getShikakuShusei().getShikakuHenko().setTxtShikakuHenkoYmd(txtShikakuHenkoYmd);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtShikakuHenkoTodokedeYmd() {
        return this.getShikakuShusei().getShikakuHenko().getTxtShikakuHenkoTodokedeYmd();
    }

    @JsonIgnore
    public void  setTxtShikakuHenkoTodokedeYmd(TextBoxFlexibleDate txtShikakuHenkoTodokedeYmd) {
        this.getShikakuShusei().getShikakuHenko().setTxtShikakuHenkoTodokedeYmd(txtShikakuHenkoTodokedeYmd);
    }

    @JsonIgnore
    public JushochiTokureiTekiyoDiv getJushochiTokureiTekiyo() {
        return this.getShikakuShusei().getJushochiTokureiTekiyo();
    }

    @JsonIgnore
    public void  setJushochiTokureiTekiyo(JushochiTokureiTekiyoDiv JushochiTokureiTekiyo) {
        this.getShikakuShusei().setJushochiTokureiTekiyo(JushochiTokureiTekiyo);
    }

    @JsonIgnore
    public CheckBoxList getChkJutoku() {
        return this.getShikakuShusei().getJushochiTokureiTekiyo().getChkJutoku();
    }

    @JsonIgnore
    public void  setChkJutoku(CheckBoxList chkJutoku) {
        this.getShikakuShusei().getJushochiTokureiTekiyo().setChkJutoku(chkJutoku);
    }

    @JsonIgnore
    public Label getLblGenzai10() {
        return this.getShikakuShusei().getJushochiTokureiTekiyo().getLblGenzai10();
    }

    @JsonIgnore
    public void  setLblGenzai10(Label lblGenzai10) {
        this.getShikakuShusei().getJushochiTokureiTekiyo().setLblGenzai10(lblGenzai10);
    }

    @JsonIgnore
    public TextBox getTxtCurrentJutokuTekiyoJiyu() {
        return this.getShikakuShusei().getJushochiTokureiTekiyo().getTxtCurrentJutokuTekiyoJiyu();
    }

    @JsonIgnore
    public void  setTxtCurrentJutokuTekiyoJiyu(TextBox txtCurrentJutokuTekiyoJiyu) {
        this.getShikakuShusei().getJushochiTokureiTekiyo().setTxtCurrentJutokuTekiyoJiyu(txtCurrentJutokuTekiyoJiyu);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtCurrentJutokuTekiyoDate() {
        return this.getShikakuShusei().getJushochiTokureiTekiyo().getTxtCurrentJutokuTekiyoDate();
    }

    @JsonIgnore
    public void  setTxtCurrentJutokuTekiyoDate(TextBoxFlexibleDate txtCurrentJutokuTekiyoDate) {
        this.getShikakuShusei().getJushochiTokureiTekiyo().setTxtCurrentJutokuTekiyoDate(txtCurrentJutokuTekiyoDate);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtCurrentJutokuTekiyoTodokedeDate() {
        return this.getShikakuShusei().getJushochiTokureiTekiyo().getTxtCurrentJutokuTekiyoTodokedeDate();
    }

    @JsonIgnore
    public void  setTxtCurrentJutokuTekiyoTodokedeDate(TextBoxFlexibleDate txtCurrentJutokuTekiyoTodokedeDate) {
        this.getShikakuShusei().getJushochiTokureiTekiyo().setTxtCurrentJutokuTekiyoTodokedeDate(txtCurrentJutokuTekiyoTodokedeDate);
    }

    @JsonIgnore
    public Label getLblShuseiGo10() {
        return this.getShikakuShusei().getJushochiTokureiTekiyo().getLblShuseiGo10();
    }

    @JsonIgnore
    public void  setLblShuseiGo10(Label lblShuseiGo10) {
        this.getShikakuShusei().getJushochiTokureiTekiyo().setLblShuseiGo10(lblShuseiGo10);
    }

    @JsonIgnore
    public DropDownList getDdlJutokuTekiyoJiyu() {
        return this.getShikakuShusei().getJushochiTokureiTekiyo().getDdlJutokuTekiyoJiyu();
    }

    @JsonIgnore
    public void  setDdlJutokuTekiyoJiyu(DropDownList ddlJutokuTekiyoJiyu) {
        this.getShikakuShusei().getJushochiTokureiTekiyo().setDdlJutokuTekiyoJiyu(ddlJutokuTekiyoJiyu);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtJutokuTekiyoDate() {
        return this.getShikakuShusei().getJushochiTokureiTekiyo().getTxtJutokuTekiyoDate();
    }

    @JsonIgnore
    public void  setTxtJutokuTekiyoDate(TextBoxFlexibleDate txtJutokuTekiyoDate) {
        this.getShikakuShusei().getJushochiTokureiTekiyo().setTxtJutokuTekiyoDate(txtJutokuTekiyoDate);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtJutokuTekiyoTodokedeDate() {
        return this.getShikakuShusei().getJushochiTokureiTekiyo().getTxtJutokuTekiyoTodokedeDate();
    }

    @JsonIgnore
    public void  setTxtJutokuTekiyoTodokedeDate(TextBoxFlexibleDate txtJutokuTekiyoTodokedeDate) {
        this.getShikakuShusei().getJushochiTokureiTekiyo().setTxtJutokuTekiyoTodokedeDate(txtJutokuTekiyoTodokedeDate);
    }

    @JsonIgnore
    public ShikakuSoshitsuDiv getShikakuSoshitsu() {
        return this.getShikakuShusei().getShikakuSoshitsu();
    }

    @JsonIgnore
    public void  setShikakuSoshitsu(ShikakuSoshitsuDiv ShikakuSoshitsu) {
        this.getShikakuShusei().setShikakuSoshitsu(ShikakuSoshitsu);
    }

    @JsonIgnore
    public Label getLblGenzai06() {
        return this.getShikakuShusei().getShikakuSoshitsu().getLblGenzai06();
    }

    @JsonIgnore
    public void  setLblGenzai06(Label lblGenzai06) {
        this.getShikakuShusei().getShikakuSoshitsu().setLblGenzai06(lblGenzai06);
    }

    @JsonIgnore
    public TextBox getTxtCurrentShikakuSoshitsuJiyu() {
        return this.getShikakuShusei().getShikakuSoshitsu().getTxtCurrentShikakuSoshitsuJiyu();
    }

    @JsonIgnore
    public void  setTxtCurrentShikakuSoshitsuJiyu(TextBox txtCurrentShikakuSoshitsuJiyu) {
        this.getShikakuShusei().getShikakuSoshitsu().setTxtCurrentShikakuSoshitsuJiyu(txtCurrentShikakuSoshitsuJiyu);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtCurrentShikakuSoshitsuYmd() {
        return this.getShikakuShusei().getShikakuSoshitsu().getTxtCurrentShikakuSoshitsuYmd();
    }

    @JsonIgnore
    public void  setTxtCurrentShikakuSoshitsuYmd(TextBoxFlexibleDate txtCurrentShikakuSoshitsuYmd) {
        this.getShikakuShusei().getShikakuSoshitsu().setTxtCurrentShikakuSoshitsuYmd(txtCurrentShikakuSoshitsuYmd);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtCurrentShikakuSoshitsuTodokedeYmd() {
        return this.getShikakuShusei().getShikakuSoshitsu().getTxtCurrentShikakuSoshitsuTodokedeYmd();
    }

    @JsonIgnore
    public void  setTxtCurrentShikakuSoshitsuTodokedeYmd(TextBoxFlexibleDate txtCurrentShikakuSoshitsuTodokedeYmd) {
        this.getShikakuShusei().getShikakuSoshitsu().setTxtCurrentShikakuSoshitsuTodokedeYmd(txtCurrentShikakuSoshitsuTodokedeYmd);
    }

    @JsonIgnore
    public Label getLblShuseiGo06() {
        return this.getShikakuShusei().getShikakuSoshitsu().getLblShuseiGo06();
    }

    @JsonIgnore
    public void  setLblShuseiGo06(Label lblShuseiGo06) {
        this.getShikakuShusei().getShikakuSoshitsu().setLblShuseiGo06(lblShuseiGo06);
    }

    @JsonIgnore
    public DropDownList getDdlShikakuSoshitsuJiyu() {
        return this.getShikakuShusei().getShikakuSoshitsu().getDdlShikakuSoshitsuJiyu();
    }

    @JsonIgnore
    public void  setDdlShikakuSoshitsuJiyu(DropDownList ddlShikakuSoshitsuJiyu) {
        this.getShikakuShusei().getShikakuSoshitsu().setDdlShikakuSoshitsuJiyu(ddlShikakuSoshitsuJiyu);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtShikakuSoshitsuYmd() {
        return this.getShikakuShusei().getShikakuSoshitsu().getTxtShikakuSoshitsuYmd();
    }

    @JsonIgnore
    public void  setTxtShikakuSoshitsuYmd(TextBoxFlexibleDate txtShikakuSoshitsuYmd) {
        this.getShikakuShusei().getShikakuSoshitsu().setTxtShikakuSoshitsuYmd(txtShikakuSoshitsuYmd);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtShikakuSoshitsuTodokedeYmd() {
        return this.getShikakuShusei().getShikakuSoshitsu().getTxtShikakuSoshitsuTodokedeYmd();
    }

    @JsonIgnore
    public void  setTxtShikakuSoshitsuTodokedeYmd(TextBoxFlexibleDate txtShikakuSoshitsuTodokedeYmd) {
        this.getShikakuShusei().getShikakuSoshitsu().setTxtShikakuSoshitsuTodokedeYmd(txtShikakuSoshitsuTodokedeYmd);
    }

    @JsonIgnore
    public TatokuTekiyoDiv getTatokuTekiyo() {
        return this.getShikakuShusei().getTatokuTekiyo();
    }

    @JsonIgnore
    public void  setTatokuTekiyo(TatokuTekiyoDiv TatokuTekiyo) {
        this.getShikakuShusei().setTatokuTekiyo(TatokuTekiyo);
    }

    @JsonIgnore
    public Label getLblGenzai02() {
        return this.getShikakuShusei().getTatokuTekiyo().getLblGenzai02();
    }

    @JsonIgnore
    public void  setLblGenzai02(Label lblGenzai02) {
        this.getShikakuShusei().getTatokuTekiyo().setLblGenzai02(lblGenzai02);
    }

    @JsonIgnore
    public TextBox getTxtCurrentTatokuTekiyoJiyu() {
        return this.getShikakuShusei().getTatokuTekiyo().getTxtCurrentTatokuTekiyoJiyu();
    }

    @JsonIgnore
    public void  setTxtCurrentTatokuTekiyoJiyu(TextBox txtCurrentTatokuTekiyoJiyu) {
        this.getShikakuShusei().getTatokuTekiyo().setTxtCurrentTatokuTekiyoJiyu(txtCurrentTatokuTekiyoJiyu);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtCurrentTatokuTekiyoYmd() {
        return this.getShikakuShusei().getTatokuTekiyo().getTxtCurrentTatokuTekiyoYmd();
    }

    @JsonIgnore
    public void  setTxtCurrentTatokuTekiyoYmd(TextBoxFlexibleDate txtCurrentTatokuTekiyoYmd) {
        this.getShikakuShusei().getTatokuTekiyo().setTxtCurrentTatokuTekiyoYmd(txtCurrentTatokuTekiyoYmd);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtCurrentTatokuTekiyoTodokedeYmd() {
        return this.getShikakuShusei().getTatokuTekiyo().getTxtCurrentTatokuTekiyoTodokedeYmd();
    }

    @JsonIgnore
    public void  setTxtCurrentTatokuTekiyoTodokedeYmd(TextBoxFlexibleDate txtCurrentTatokuTekiyoTodokedeYmd) {
        this.getShikakuShusei().getTatokuTekiyo().setTxtCurrentTatokuTekiyoTodokedeYmd(txtCurrentTatokuTekiyoTodokedeYmd);
    }

    @JsonIgnore
    public Label getLblShuseiGo02() {
        return this.getShikakuShusei().getTatokuTekiyo().getLblShuseiGo02();
    }

    @JsonIgnore
    public void  setLblShuseiGo02(Label lblShuseiGo02) {
        this.getShikakuShusei().getTatokuTekiyo().setLblShuseiGo02(lblShuseiGo02);
    }

    @JsonIgnore
    public DropDownList getDdlTatokuTekiyoJiyu() {
        return this.getShikakuShusei().getTatokuTekiyo().getDdlTatokuTekiyoJiyu();
    }

    @JsonIgnore
    public void  setDdlTatokuTekiyoJiyu(DropDownList ddlTatokuTekiyoJiyu) {
        this.getShikakuShusei().getTatokuTekiyo().setDdlTatokuTekiyoJiyu(ddlTatokuTekiyoJiyu);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtTatokuTekiyoYmd() {
        return this.getShikakuShusei().getTatokuTekiyo().getTxtTatokuTekiyoYmd();
    }

    @JsonIgnore
    public void  setTxtTatokuTekiyoYmd(TextBoxFlexibleDate txtTatokuTekiyoYmd) {
        this.getShikakuShusei().getTatokuTekiyo().setTxtTatokuTekiyoYmd(txtTatokuTekiyoYmd);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtTatokuTekiyoTodokedeYmd() {
        return this.getShikakuShusei().getTatokuTekiyo().getTxtTatokuTekiyoTodokedeYmd();
    }

    @JsonIgnore
    public void  setTxtTatokuTekiyoTodokedeYmd(TextBoxFlexibleDate txtTatokuTekiyoTodokedeYmd) {
        this.getShikakuShusei().getTatokuTekiyo().setTxtTatokuTekiyoTodokedeYmd(txtTatokuTekiyoTodokedeYmd);
    }

    @JsonIgnore
    public TatokuKaijoDiv getTatokuKaijo() {
        return this.getShikakuShusei().getTatokuKaijo();
    }

    @JsonIgnore
    public void  setTatokuKaijo(TatokuKaijoDiv TatokuKaijo) {
        this.getShikakuShusei().setTatokuKaijo(TatokuKaijo);
    }

    @JsonIgnore
    public Label getLblGenzai07() {
        return this.getShikakuShusei().getTatokuKaijo().getLblGenzai07();
    }

    @JsonIgnore
    public void  setLblGenzai07(Label lblGenzai07) {
        this.getShikakuShusei().getTatokuKaijo().setLblGenzai07(lblGenzai07);
    }

    @JsonIgnore
    public TextBox getTxtCurrentTatokuKaijoJiyu() {
        return this.getShikakuShusei().getTatokuKaijo().getTxtCurrentTatokuKaijoJiyu();
    }

    @JsonIgnore
    public void  setTxtCurrentTatokuKaijoJiyu(TextBox txtCurrentTatokuKaijoJiyu) {
        this.getShikakuShusei().getTatokuKaijo().setTxtCurrentTatokuKaijoJiyu(txtCurrentTatokuKaijoJiyu);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtCurrentTatokuKaijoYmd() {
        return this.getShikakuShusei().getTatokuKaijo().getTxtCurrentTatokuKaijoYmd();
    }

    @JsonIgnore
    public void  setTxtCurrentTatokuKaijoYmd(TextBoxFlexibleDate txtCurrentTatokuKaijoYmd) {
        this.getShikakuShusei().getTatokuKaijo().setTxtCurrentTatokuKaijoYmd(txtCurrentTatokuKaijoYmd);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtCurrentTatokuKaijoTodokedeYmd() {
        return this.getShikakuShusei().getTatokuKaijo().getTxtCurrentTatokuKaijoTodokedeYmd();
    }

    @JsonIgnore
    public void  setTxtCurrentTatokuKaijoTodokedeYmd(TextBoxFlexibleDate txtCurrentTatokuKaijoTodokedeYmd) {
        this.getShikakuShusei().getTatokuKaijo().setTxtCurrentTatokuKaijoTodokedeYmd(txtCurrentTatokuKaijoTodokedeYmd);
    }

    @JsonIgnore
    public Label getLblShuseiGo07() {
        return this.getShikakuShusei().getTatokuKaijo().getLblShuseiGo07();
    }

    @JsonIgnore
    public void  setLblShuseiGo07(Label lblShuseiGo07) {
        this.getShikakuShusei().getTatokuKaijo().setLblShuseiGo07(lblShuseiGo07);
    }

    @JsonIgnore
    public DropDownList getDdlTatokuKaijoJiyu() {
        return this.getShikakuShusei().getTatokuKaijo().getDdlTatokuKaijoJiyu();
    }

    @JsonIgnore
    public void  setDdlTatokuKaijoJiyu(DropDownList ddlTatokuKaijoJiyu) {
        this.getShikakuShusei().getTatokuKaijo().setDdlTatokuKaijoJiyu(ddlTatokuKaijoJiyu);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtTatokuKaijoYmd() {
        return this.getShikakuShusei().getTatokuKaijo().getTxtTatokuKaijoYmd();
    }

    @JsonIgnore
    public void  setTxtTatokuKaijoYmd(TextBoxFlexibleDate txtTatokuKaijoYmd) {
        this.getShikakuShusei().getTatokuKaijo().setTxtTatokuKaijoYmd(txtTatokuKaijoYmd);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtTatokuKaijoTodokedeYmd() {
        return this.getShikakuShusei().getTatokuKaijo().getTxtTatokuKaijoTodokedeYmd();
    }

    @JsonIgnore
    public void  setTxtTatokuKaijoTodokedeYmd(TextBoxFlexibleDate txtTatokuKaijoTodokedeYmd) {
        this.getShikakuShusei().getTatokuKaijo().setTxtTatokuKaijoTodokedeYmd(txtTatokuKaijoTodokedeYmd);
    }

    @JsonIgnore
    public TekiyoJogaiTekiyoDiv getTekiyoJogaiTekiyo() {
        return this.getShikakuShusei().getTekiyoJogaiTekiyo();
    }

    @JsonIgnore
    public void  setTekiyoJogaiTekiyo(TekiyoJogaiTekiyoDiv TekiyoJogaiTekiyo) {
        this.getShikakuShusei().setTekiyoJogaiTekiyo(TekiyoJogaiTekiyo);
    }

    @JsonIgnore
    public Label getLblGenzai03() {
        return this.getShikakuShusei().getTekiyoJogaiTekiyo().getLblGenzai03();
    }

    @JsonIgnore
    public void  setLblGenzai03(Label lblGenzai03) {
        this.getShikakuShusei().getTekiyoJogaiTekiyo().setLblGenzai03(lblGenzai03);
    }

    @JsonIgnore
    public TextBox getTxtCurrentTekiyoJogaiTekiyoJiyu() {
        return this.getShikakuShusei().getTekiyoJogaiTekiyo().getTxtCurrentTekiyoJogaiTekiyoJiyu();
    }

    @JsonIgnore
    public void  setTxtCurrentTekiyoJogaiTekiyoJiyu(TextBox txtCurrentTekiyoJogaiTekiyoJiyu) {
        this.getShikakuShusei().getTekiyoJogaiTekiyo().setTxtCurrentTekiyoJogaiTekiyoJiyu(txtCurrentTekiyoJogaiTekiyoJiyu);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtCurrentTekiyoJogaiTekiyoYmd() {
        return this.getShikakuShusei().getTekiyoJogaiTekiyo().getTxtCurrentTekiyoJogaiTekiyoYmd();
    }

    @JsonIgnore
    public void  setTxtCurrentTekiyoJogaiTekiyoYmd(TextBoxFlexibleDate txtCurrentTekiyoJogaiTekiyoYmd) {
        this.getShikakuShusei().getTekiyoJogaiTekiyo().setTxtCurrentTekiyoJogaiTekiyoYmd(txtCurrentTekiyoJogaiTekiyoYmd);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtCurrentTekiyoJogaiTekiyoTodokedeYmd() {
        return this.getShikakuShusei().getTekiyoJogaiTekiyo().getTxtCurrentTekiyoJogaiTekiyoTodokedeYmd();
    }

    @JsonIgnore
    public void  setTxtCurrentTekiyoJogaiTekiyoTodokedeYmd(TextBoxFlexibleDate txtCurrentTekiyoJogaiTekiyoTodokedeYmd) {
        this.getShikakuShusei().getTekiyoJogaiTekiyo().setTxtCurrentTekiyoJogaiTekiyoTodokedeYmd(txtCurrentTekiyoJogaiTekiyoTodokedeYmd);
    }

    @JsonIgnore
    public Label getLblShuseiGo03() {
        return this.getShikakuShusei().getTekiyoJogaiTekiyo().getLblShuseiGo03();
    }

    @JsonIgnore
    public void  setLblShuseiGo03(Label lblShuseiGo03) {
        this.getShikakuShusei().getTekiyoJogaiTekiyo().setLblShuseiGo03(lblShuseiGo03);
    }

    @JsonIgnore
    public DropDownList getDdlTekiyoJogaiTekiyoJiyu() {
        return this.getShikakuShusei().getTekiyoJogaiTekiyo().getDdlTekiyoJogaiTekiyoJiyu();
    }

    @JsonIgnore
    public void  setDdlTekiyoJogaiTekiyoJiyu(DropDownList ddlTekiyoJogaiTekiyoJiyu) {
        this.getShikakuShusei().getTekiyoJogaiTekiyo().setDdlTekiyoJogaiTekiyoJiyu(ddlTekiyoJogaiTekiyoJiyu);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtTekiyoJogaiTekiyoYmd() {
        return this.getShikakuShusei().getTekiyoJogaiTekiyo().getTxtTekiyoJogaiTekiyoYmd();
    }

    @JsonIgnore
    public void  setTxtTekiyoJogaiTekiyoYmd(TextBoxFlexibleDate txtTekiyoJogaiTekiyoYmd) {
        this.getShikakuShusei().getTekiyoJogaiTekiyo().setTxtTekiyoJogaiTekiyoYmd(txtTekiyoJogaiTekiyoYmd);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtTekiyoJogaiTekiyoTodokedeYmd() {
        return this.getShikakuShusei().getTekiyoJogaiTekiyo().getTxtTekiyoJogaiTekiyoTodokedeYmd();
    }

    @JsonIgnore
    public void  setTxtTekiyoJogaiTekiyoTodokedeYmd(TextBoxFlexibleDate txtTekiyoJogaiTekiyoTodokedeYmd) {
        this.getShikakuShusei().getTekiyoJogaiTekiyo().setTxtTekiyoJogaiTekiyoTodokedeYmd(txtTekiyoJogaiTekiyoTodokedeYmd);
    }

    @JsonIgnore
    public TekiyoJogaiKaijoDiv getTekiyoJogaiKaijo() {
        return this.getShikakuShusei().getTekiyoJogaiKaijo();
    }

    @JsonIgnore
    public void  setTekiyoJogaiKaijo(TekiyoJogaiKaijoDiv TekiyoJogaiKaijo) {
        this.getShikakuShusei().setTekiyoJogaiKaijo(TekiyoJogaiKaijo);
    }

    @JsonIgnore
    public Label getLblGenzai08() {
        return this.getShikakuShusei().getTekiyoJogaiKaijo().getLblGenzai08();
    }

    @JsonIgnore
    public void  setLblGenzai08(Label lblGenzai08) {
        this.getShikakuShusei().getTekiyoJogaiKaijo().setLblGenzai08(lblGenzai08);
    }

    @JsonIgnore
    public TextBox getTxtCurrentTekiyoJogaiKaijoJiyu() {
        return this.getShikakuShusei().getTekiyoJogaiKaijo().getTxtCurrentTekiyoJogaiKaijoJiyu();
    }

    @JsonIgnore
    public void  setTxtCurrentTekiyoJogaiKaijoJiyu(TextBox txtCurrentTekiyoJogaiKaijoJiyu) {
        this.getShikakuShusei().getTekiyoJogaiKaijo().setTxtCurrentTekiyoJogaiKaijoJiyu(txtCurrentTekiyoJogaiKaijoJiyu);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtCurrentTekiyoJogaiKaijoYmd() {
        return this.getShikakuShusei().getTekiyoJogaiKaijo().getTxtCurrentTekiyoJogaiKaijoYmd();
    }

    @JsonIgnore
    public void  setTxtCurrentTekiyoJogaiKaijoYmd(TextBoxFlexibleDate txtCurrentTekiyoJogaiKaijoYmd) {
        this.getShikakuShusei().getTekiyoJogaiKaijo().setTxtCurrentTekiyoJogaiKaijoYmd(txtCurrentTekiyoJogaiKaijoYmd);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtCurrentTekiyoJogaiKaijoTodokedeYmd() {
        return this.getShikakuShusei().getTekiyoJogaiKaijo().getTxtCurrentTekiyoJogaiKaijoTodokedeYmd();
    }

    @JsonIgnore
    public void  setTxtCurrentTekiyoJogaiKaijoTodokedeYmd(TextBoxFlexibleDate txtCurrentTekiyoJogaiKaijoTodokedeYmd) {
        this.getShikakuShusei().getTekiyoJogaiKaijo().setTxtCurrentTekiyoJogaiKaijoTodokedeYmd(txtCurrentTekiyoJogaiKaijoTodokedeYmd);
    }

    @JsonIgnore
    public Label getLblShuseiGo08() {
        return this.getShikakuShusei().getTekiyoJogaiKaijo().getLblShuseiGo08();
    }

    @JsonIgnore
    public void  setLblShuseiGo08(Label lblShuseiGo08) {
        this.getShikakuShusei().getTekiyoJogaiKaijo().setLblShuseiGo08(lblShuseiGo08);
    }

    @JsonIgnore
    public DropDownList getDdlTekiyoJogaiKaijoJiyu() {
        return this.getShikakuShusei().getTekiyoJogaiKaijo().getDdlTekiyoJogaiKaijoJiyu();
    }

    @JsonIgnore
    public void  setDdlTekiyoJogaiKaijoJiyu(DropDownList ddlTekiyoJogaiKaijoJiyu) {
        this.getShikakuShusei().getTekiyoJogaiKaijo().setDdlTekiyoJogaiKaijoJiyu(ddlTekiyoJogaiKaijoJiyu);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtTekiyoJogaiKaijoYmd() {
        return this.getShikakuShusei().getTekiyoJogaiKaijo().getTxtTekiyoJogaiKaijoYmd();
    }

    @JsonIgnore
    public void  setTxtTekiyoJogaiKaijoYmd(TextBoxFlexibleDate txtTekiyoJogaiKaijoYmd) {
        this.getShikakuShusei().getTekiyoJogaiKaijo().setTxtTekiyoJogaiKaijoYmd(txtTekiyoJogaiKaijoYmd);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtTekiyoJogaiKaijoTodokedeYmd() {
        return this.getShikakuShusei().getTekiyoJogaiKaijo().getTxtTekiyoJogaiKaijoTodokedeYmd();
    }

    @JsonIgnore
    public void  setTxtTekiyoJogaiKaijoTodokedeYmd(TextBoxFlexibleDate txtTekiyoJogaiKaijoTodokedeYmd) {
        this.getShikakuShusei().getTekiyoJogaiKaijo().setTxtTekiyoJogaiKaijoTodokedeYmd(txtTekiyoJogaiKaijoTodokedeYmd);
    }

    @JsonIgnore
    public ShikakuShutokuJogaiSetteiDiv getShikakuShutokuJogaiSettei() {
        return this.getShikakuShusei().getShikakuShutokuJogaiSettei();
    }

    @JsonIgnore
    public void  setShikakuShutokuJogaiSettei(ShikakuShutokuJogaiSetteiDiv ShikakuShutokuJogaiSettei) {
        this.getShikakuShusei().setShikakuShutokuJogaiSettei(ShikakuShutokuJogaiSettei);
    }

    @JsonIgnore
    public CheckBoxList getChkShutokuJogai() {
        return this.getShikakuShusei().getShikakuShutokuJogaiSettei().getChkShutokuJogai();
    }

    @JsonIgnore
    public void  setChkShutokuJogai(CheckBoxList chkShutokuJogai) {
        this.getShikakuShusei().getShikakuShutokuJogaiSettei().setChkShutokuJogai(chkShutokuJogai);
    }

    @JsonIgnore
    public Label getLblShuseiGo04() {
        return this.getShikakuShusei().getShikakuShutokuJogaiSettei().getLblShuseiGo04();
    }

    @JsonIgnore
    public void  setLblShuseiGo04(Label lblShuseiGo04) {
        this.getShikakuShusei().getShikakuShutokuJogaiSettei().setLblShuseiGo04(lblShuseiGo04);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtShutokuJogaiYmd() {
        return this.getShikakuShusei().getShikakuShutokuJogaiSettei().getTxtShutokuJogaiYmd();
    }

    @JsonIgnore
    public void  setTxtShutokuJogaiYmd(TextBoxFlexibleDate txtShutokuJogaiYmd) {
        this.getShikakuShusei().getShikakuShutokuJogaiSettei().setTxtShutokuJogaiYmd(txtShutokuJogaiYmd);
    }

    @JsonIgnore
    public TextBox getTxtShutokuJogaiRiyu() {
        return this.getShikakuShusei().getShikakuShutokuJogaiSettei().getTxtShutokuJogaiRiyu();
    }

    @JsonIgnore
    public void  setTxtShutokuJogaiRiyu(TextBox txtShutokuJogaiRiyu) {
        this.getShikakuShusei().getShikakuShutokuJogaiSettei().setTxtShutokuJogaiRiyu(txtShutokuJogaiRiyu);
    }

    @JsonIgnore
    public JukiJohoDiv getJukiJoho() {
        return this.getShikakuShusei().getJukiJoho();
    }

    @JsonIgnore
    public void  setJukiJoho(JukiJohoDiv JukiJoho) {
        this.getShikakuShusei().setJukiJoho(JukiJoho);
    }

    @JsonIgnore
    public TextBox getTxtJukiShojoJiyu() {
        return this.getShikakuShusei().getJukiJoho().getTxtJukiShojoJiyu();
    }

    @JsonIgnore
    public void  setTxtJukiShojoJiyu(TextBox txtJukiShojoJiyu) {
        this.getShikakuShusei().getJukiJoho().setTxtJukiShojoJiyu(txtJukiShojoJiyu);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtShojoIdoYmd() {
        return this.getShikakuShusei().getJukiJoho().getTxtShojoIdoYmd();
    }

    @JsonIgnore
    public void  setTxtShojoIdoYmd(TextBoxFlexibleDate txtShojoIdoYmd) {
        this.getShikakuShusei().getJukiJoho().setTxtShojoIdoYmd(txtShojoIdoYmd);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtShojoTodokedeYmd() {
        return this.getShikakuShusei().getJukiJoho().getTxtShojoTodokedeYmd();
    }

    @JsonIgnore
    public void  setTxtShojoTodokedeYmd(TextBoxFlexibleDate txtShojoTodokedeYmd) {
        this.getShikakuShusei().getJukiJoho().setTxtShojoTodokedeYmd(txtShojoTodokedeYmd);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtTenshutsuYoteiYmd() {
        return this.getShikakuShusei().getJukiJoho().getTxtTenshutsuYoteiYmd();
    }

    @JsonIgnore
    public void  setTxtTenshutsuYoteiYmd(TextBoxFlexibleDate txtTenshutsuYoteiYmd) {
        this.getShikakuShusei().getJukiJoho().setTxtTenshutsuYoteiYmd(txtTenshutsuYoteiYmd);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtTenshutsuKakuteiYmd() {
        return this.getShikakuShusei().getJukiJoho().getTxtTenshutsuKakuteiYmd();
    }

    @JsonIgnore
    public void  setTxtTenshutsuKakuteiYmd(TextBoxFlexibleDate txtTenshutsuKakuteiYmd) {
        this.getShikakuShusei().getJukiJoho().setTxtTenshutsuKakuteiYmd(txtTenshutsuKakuteiYmd);
    }

    @JsonIgnore
    public Button getBtnCancel() {
        return this.getShikakuShusei().getBtnCancel();
    }

    @JsonIgnore
    public void  setBtnCancel(Button btnCancel) {
        this.getShikakuShusei().setBtnCancel(btnCancel);
    }

    @JsonIgnore
    public Button getBtnCommitDialog() {
        return this.getShikakuShusei().getBtnCommitDialog();
    }

    @JsonIgnore
    public void  setBtnCommitDialog(Button btnCommitDialog) {
        this.getShikakuShusei().setBtnCommitDialog(btnCommitDialog);
    }

    // </editor-fold>
}
