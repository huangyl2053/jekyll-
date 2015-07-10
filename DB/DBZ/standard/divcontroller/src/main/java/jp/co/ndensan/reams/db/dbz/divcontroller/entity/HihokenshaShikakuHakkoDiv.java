package jp.co.ndensan.reams.db.dbz.divcontroller.entity;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.IHihokenshaShikakuHakkoDiv;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.ShuruiShikyuGendoKijungakuDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.tabHihokenshaShikakuShosaiDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.tblJigyoshaDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.tblKyuhuSeigenDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.tblShisetsuNyutaishoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.tplGendoGakuDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.tplKyufuSeigenDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.tplShienJigyoshaDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.tplShinsakaiIkenDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.tplShisetsuNyutaishoDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * HihokenshaShikakuHakko のクラスファイル 
 * 
 * @author 自動生成
 */
public class HihokenshaShikakuHakkoDiv extends Panel implements IHihokenshaShikakuHakkoDiv {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("radInjiIchi")
    private RadioButton radInjiIchi;
    @JsonProperty("txtKofuDate")
    private TextBoxFlexibleDate txtKofuDate;
    @JsonProperty("ddlKofuJiyu")
    private DropDownList ddlKofuJiyu;
    @JsonProperty("txtYukoKigen")
    private TextBoxFlexibleDate txtYukoKigen;
    @JsonProperty("txtHokensha")
    private TextBox txtHokensha;
    @JsonProperty("txtYokaigodo")
    private TextBox txtYokaigodo;
    @JsonProperty("txtNinteiYukoKikan")
    private TextBoxDateRange txtNinteiYukoKikan;
    @JsonProperty("txtShinseiDate")
    private TextBoxFlexibleDate txtShinseiDate;
    @JsonProperty("tabHihokenshaShikakuShosai")
    private tabHihokenshaShikakuShosaiDiv tabHihokenshaShikakuShosai;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("radInjiIchi")
    public RadioButton getRadInjiIchi() {
        return radInjiIchi;
    }

    @JsonProperty("radInjiIchi")
    public void setRadInjiIchi(RadioButton radInjiIchi) {
        this.radInjiIchi=radInjiIchi;
    }

    @JsonProperty("txtKofuDate")
    public TextBoxFlexibleDate getTxtKofuDate() {
        return txtKofuDate;
    }

    @JsonProperty("txtKofuDate")
    public void setTxtKofuDate(TextBoxFlexibleDate txtKofuDate) {
        this.txtKofuDate=txtKofuDate;
    }

    @JsonProperty("ddlKofuJiyu")
    public DropDownList getDdlKofuJiyu() {
        return ddlKofuJiyu;
    }

    @JsonProperty("ddlKofuJiyu")
    public void setDdlKofuJiyu(DropDownList ddlKofuJiyu) {
        this.ddlKofuJiyu=ddlKofuJiyu;
    }

    @JsonProperty("txtYukoKigen")
    public TextBoxFlexibleDate getTxtYukoKigen() {
        return txtYukoKigen;
    }

    @JsonProperty("txtYukoKigen")
    public void setTxtYukoKigen(TextBoxFlexibleDate txtYukoKigen) {
        this.txtYukoKigen=txtYukoKigen;
    }

    @JsonProperty("txtHokensha")
    public TextBox getTxtHokensha() {
        return txtHokensha;
    }

    @JsonProperty("txtHokensha")
    public void setTxtHokensha(TextBox txtHokensha) {
        this.txtHokensha=txtHokensha;
    }

    @JsonProperty("txtYokaigodo")
    public TextBox getTxtYokaigodo() {
        return txtYokaigodo;
    }

    @JsonProperty("txtYokaigodo")
    public void setTxtYokaigodo(TextBox txtYokaigodo) {
        this.txtYokaigodo=txtYokaigodo;
    }

    @JsonProperty("txtNinteiYukoKikan")
    public TextBoxDateRange getTxtNinteiYukoKikan() {
        return txtNinteiYukoKikan;
    }

    @JsonProperty("txtNinteiYukoKikan")
    public void setTxtNinteiYukoKikan(TextBoxDateRange txtNinteiYukoKikan) {
        this.txtNinteiYukoKikan=txtNinteiYukoKikan;
    }

    @JsonProperty("txtShinseiDate")
    public TextBoxFlexibleDate getTxtShinseiDate() {
        return txtShinseiDate;
    }

    @JsonProperty("txtShinseiDate")
    public void setTxtShinseiDate(TextBoxFlexibleDate txtShinseiDate) {
        this.txtShinseiDate=txtShinseiDate;
    }

    @JsonProperty("tabHihokenshaShikakuShosai")
    public tabHihokenshaShikakuShosaiDiv getTabHihokenshaShikakuShosai() {
        return tabHihokenshaShikakuShosai;
    }

    @JsonProperty("tabHihokenshaShikakuShosai")
    public void setTabHihokenshaShikakuShosai(tabHihokenshaShikakuShosaiDiv tabHihokenshaShikakuShosai) {
        this.tabHihokenshaShikakuShosai=tabHihokenshaShikakuShosai;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public tplGendoGakuDiv getTplGendoGaku() {
        return this.getTabHihokenshaShikakuShosai().getTplGendoGaku();
    }

    @JsonIgnore
    public void  setTplGendoGaku(tplGendoGakuDiv tplGendoGaku) {
        this.getTabHihokenshaShikakuShosai().setTplGendoGaku(tplGendoGaku);
    }

    @JsonIgnore
    public Label getLblKubunShikyuGendoGaku() {
        return this.getTabHihokenshaShikakuShosai().getTplGendoGaku().getLblKubunShikyuGendoGaku();
    }

    @JsonIgnore
    public void  setLblKubunShikyuGendoGaku(Label lblKubunShikyuGendoGaku) {
        this.getTabHihokenshaShikakuShosai().getTplGendoGaku().setLblKubunShikyuGendoGaku(lblKubunShikyuGendoGaku);
    }

    @JsonIgnore
    public TextBoxNum getTxtKubunShikyuGendoKijunGaku() {
        return this.getTabHihokenshaShikakuShosai().getTplGendoGaku().getTxtKubunShikyuGendoKijunGaku();
    }

    @JsonIgnore
    public void  setTxtKubunShikyuGendoKijunGaku(TextBoxNum txtKubunShikyuGendoKijunGaku) {
        this.getTabHihokenshaShikakuShosai().getTplGendoGaku().setTxtKubunShikyuGendoKijunGaku(txtKubunShikyuGendoKijunGaku);
    }

    @JsonIgnore
    public TextBoxDateRange getTxtKyuhuYukoKikan() {
        return this.getTabHihokenshaShikakuShosai().getTplGendoGaku().getTxtKyuhuYukoKikan();
    }

    @JsonIgnore
    public void  setTxtKyuhuYukoKikan(TextBoxDateRange txtKyuhuYukoKikan) {
        this.getTabHihokenshaShikakuShosai().getTplGendoGaku().setTxtKyuhuYukoKikan(txtKyuhuYukoKikan);
    }

    @JsonIgnore
    public ShuruiShikyuGendoKijungakuDiv getShuruiShikyuGendoKijungaku() {
        return this.getTabHihokenshaShikakuShosai().getTplGendoGaku().getShuruiShikyuGendoKijungaku();
    }

    @JsonIgnore
    public void  setShuruiShikyuGendoKijungaku(ShuruiShikyuGendoKijungakuDiv ShuruiShikyuGendoKijungaku) {
        this.getTabHihokenshaShikakuShosai().getTplGendoGaku().setShuruiShikyuGendoKijungaku(ShuruiShikyuGendoKijungaku);
    }

    @JsonIgnore
    public tplShinsakaiIkenDiv getTplShinsakaiIken() {
        return this.getTabHihokenshaShikakuShosai().getTplShinsakaiIken();
    }

    @JsonIgnore
    public void  setTplShinsakaiIken(tplShinsakaiIkenDiv tplShinsakaiIken) {
        this.getTabHihokenshaShikakuShosai().setTplShinsakaiIken(tplShinsakaiIken);
    }

    @JsonIgnore
    public Label getLblShinsakaiIken() {
        return this.getTabHihokenshaShikakuShosai().getTplShinsakaiIken().getLblShinsakaiIken();
    }

    @JsonIgnore
    public void  setLblShinsakaiIken(Label lblShinsakaiIken) {
        this.getTabHihokenshaShikakuShosai().getTplShinsakaiIken().setLblShinsakaiIken(lblShinsakaiIken);
    }

    @JsonIgnore
    public TextBoxMultiLine getTxtShinsakaiIken() {
        return this.getTabHihokenshaShikakuShosai().getTplShinsakaiIken().getTxtShinsakaiIken();
    }

    @JsonIgnore
    public void  setTxtShinsakaiIken(TextBoxMultiLine txtShinsakaiIken) {
        this.getTabHihokenshaShikakuShosai().getTplShinsakaiIken().setTxtShinsakaiIken(txtShinsakaiIken);
    }

    @JsonIgnore
    public tplKyufuSeigenDiv getTplKyufuSeigen() {
        return this.getTabHihokenshaShikakuShosai().getTplKyufuSeigen();
    }

    @JsonIgnore
    public void  setTplKyufuSeigen(tplKyufuSeigenDiv tplKyufuSeigen) {
        this.getTabHihokenshaShikakuShosai().setTplKyufuSeigen(tplKyufuSeigen);
    }

    @JsonIgnore
    public Label getLblKyufuSeigen() {
        return this.getTabHihokenshaShikakuShosai().getTplKyufuSeigen().getLblKyufuSeigen();
    }

    @JsonIgnore
    public void  setLblKyufuSeigen(Label lblKyufuSeigen) {
        this.getTabHihokenshaShikakuShosai().getTplKyufuSeigen().setLblKyufuSeigen(lblKyufuSeigen);
    }

    @JsonIgnore
    public tblKyuhuSeigenDiv getTblKyuhuSeigen() {
        return this.getTabHihokenshaShikakuShosai().getTplKyufuSeigen().getTblKyuhuSeigen();
    }

    @JsonIgnore
    public void  setTblKyuhuSeigen(tblKyuhuSeigenDiv tblKyuhuSeigen) {
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
    public void  setTplShienJigyosha(tplShienJigyoshaDiv tplShienJigyosha) {
        this.getTabHihokenshaShikakuShosai().setTplShienJigyosha(tplShienJigyosha);
    }

    @JsonIgnore
    public Label getLblShienJigyosha() {
        return this.getTabHihokenshaShikakuShosai().getTplShienJigyosha().getLblShienJigyosha();
    }

    @JsonIgnore
    public void  setLblShienJigyosha(Label lblShienJigyosha) {
        this.getTabHihokenshaShikakuShosai().getTplShienJigyosha().setLblShienJigyosha(lblShienJigyosha);
    }

    @JsonIgnore
    public tblJigyoshaDiv getTblJigyosha() {
        return this.getTabHihokenshaShikakuShosai().getTplShienJigyosha().getTblJigyosha();
    }

    @JsonIgnore
    public void  setTblJigyosha(tblJigyoshaDiv tblJigyosha) {
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
    public TextBox getTxtJigyosha1() {
        return this.getTabHihokenshaShikakuShosai().getTplShienJigyosha().getTblJigyosha().getTxtJigyosha1();
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtTodokedeDate1() {
        return this.getTabHihokenshaShikakuShosai().getTplShienJigyosha().getTblJigyosha().getTxtTodokedeDate1();
    }

    @JsonIgnore
    public TextBox getTxtJigyosha2() {
        return this.getTabHihokenshaShikakuShosai().getTplShienJigyosha().getTblJigyosha().getTxtJigyosha2();
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtTodokedeDate2() {
        return this.getTabHihokenshaShikakuShosai().getTplShienJigyosha().getTblJigyosha().getTxtTodokedeDate2();
    }

    @JsonIgnore
    public TextBox getTxtJigyosha3() {
        return this.getTabHihokenshaShikakuShosai().getTplShienJigyosha().getTblJigyosha().getTxtJigyosha3();
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtTodokedeDate3() {
        return this.getTabHihokenshaShikakuShosai().getTplShienJigyosha().getTblJigyosha().getTxtTodokedeDate3();
    }

    @JsonIgnore
    public tplShisetsuNyutaishoDiv getTplShisetsuNyutaisho() {
        return this.getTabHihokenshaShikakuShosai().getTplShisetsuNyutaisho();
    }

    @JsonIgnore
    public void  setTplShisetsuNyutaisho(tplShisetsuNyutaishoDiv tplShisetsuNyutaisho) {
        this.getTabHihokenshaShikakuShosai().setTplShisetsuNyutaisho(tplShisetsuNyutaisho);
    }

    @JsonIgnore
    public Label getLblKaigoHokensha() {
        return this.getTabHihokenshaShikakuShosai().getTplShisetsuNyutaisho().getLblKaigoHokensha();
    }

    @JsonIgnore
    public void  setLblKaigoHokensha(Label lblKaigoHokensha) {
        this.getTabHihokenshaShikakuShosai().getTplShisetsuNyutaisho().setLblKaigoHokensha(lblKaigoHokensha);
    }

    @JsonIgnore
    public tblShisetsuNyutaishoDiv getTblShisetsuNyutaisho() {
        return this.getTabHihokenshaShikakuShosai().getTplShisetsuNyutaisho().getTblShisetsuNyutaisho();
    }

    @JsonIgnore
    public void  setTblShisetsuNyutaisho(tblShisetsuNyutaishoDiv tblShisetsuNyutaisho) {
        this.getTabHihokenshaShikakuShosai().getTplShisetsuNyutaisho().setTblShisetsuNyutaisho(tblShisetsuNyutaisho);
    }

    @JsonIgnore
    public Label getLblShisetsuShurui() {
        return this.getTabHihokenshaShikakuShosai().getTplShisetsuNyutaisho().getTblShisetsuNyutaisho().getLblShisetsuShurui();
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
    public TextBox getTxtShisetsuShurui1() {
        return this.getTabHihokenshaShikakuShosai().getTplShisetsuNyutaisho().getTblShisetsuNyutaisho().getTxtShisetsuShurui1();
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
    public TextBox getTxtShisetsuShurui2() {
        return this.getTabHihokenshaShikakuShosai().getTplShisetsuNyutaisho().getTblShisetsuNyutaisho().getTxtShisetsuShurui2();
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
    public TextBox getTxtShisetsuShurui3() {
        return this.getTabHihokenshaShikakuShosai().getTplShisetsuNyutaisho().getTblShisetsuNyutaisho().getTxtShisetsuShurui3();
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

    //--------------- この行より下にコードを追加してください -------------------

}
