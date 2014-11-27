package jp.co.ndensan.reams.db.dbz.divcontroller.entity;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.ShuruiShikyuGendoKijungakuDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.tblJigyoshaDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.tblKyuhuSeigenDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.tblShisetsuNyutaishoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.tplGendoGakuDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.tplKyufuSeigenDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.tplShienJigyoshaDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.tplShinsakaiIkenDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.tplShisetsuNyutaishoDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.TabContainer;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * tabHihokenshaShikakuShosai のクラスファイル 
 * 
 * @author 自動生成
 */
public class tabHihokenshaShikakuShosaiDiv extends TabContainer {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("tplGendoGaku")
    private tplGendoGakuDiv tplGendoGaku;
    @JsonProperty("tplShinsakaiIken")
    private tplShinsakaiIkenDiv tplShinsakaiIken;
    @JsonProperty("tplKyufuSeigen")
    private tplKyufuSeigenDiv tplKyufuSeigen;
    @JsonProperty("tplShienJigyosha")
    private tplShienJigyoshaDiv tplShienJigyosha;
    @JsonProperty("tplShisetsuNyutaisho")
    private tplShisetsuNyutaishoDiv tplShisetsuNyutaisho;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("tplGendoGaku")
    public tplGendoGakuDiv getTplGendoGaku() {
        return tplGendoGaku;
    }

    @JsonProperty("tplGendoGaku")
    public void setTplGendoGaku(tplGendoGakuDiv tplGendoGaku) {
        this.tplGendoGaku=tplGendoGaku;
    }

    @JsonProperty("tplShinsakaiIken")
    public tplShinsakaiIkenDiv getTplShinsakaiIken() {
        return tplShinsakaiIken;
    }

    @JsonProperty("tplShinsakaiIken")
    public void setTplShinsakaiIken(tplShinsakaiIkenDiv tplShinsakaiIken) {
        this.tplShinsakaiIken=tplShinsakaiIken;
    }

    @JsonProperty("tplKyufuSeigen")
    public tplKyufuSeigenDiv getTplKyufuSeigen() {
        return tplKyufuSeigen;
    }

    @JsonProperty("tplKyufuSeigen")
    public void setTplKyufuSeigen(tplKyufuSeigenDiv tplKyufuSeigen) {
        this.tplKyufuSeigen=tplKyufuSeigen;
    }

    @JsonProperty("tplShienJigyosha")
    public tplShienJigyoshaDiv getTplShienJigyosha() {
        return tplShienJigyosha;
    }

    @JsonProperty("tplShienJigyosha")
    public void setTplShienJigyosha(tplShienJigyoshaDiv tplShienJigyosha) {
        this.tplShienJigyosha=tplShienJigyosha;
    }

    @JsonProperty("tplShisetsuNyutaisho")
    public tplShisetsuNyutaishoDiv getTplShisetsuNyutaisho() {
        return tplShisetsuNyutaisho;
    }

    @JsonProperty("tplShisetsuNyutaisho")
    public void setTplShisetsuNyutaisho(tplShisetsuNyutaishoDiv tplShisetsuNyutaisho) {
        this.tplShisetsuNyutaisho=tplShisetsuNyutaisho;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public Label getLblKubunShikyuGendoGaku() {
        return this.getTplGendoGaku().getLblKubunShikyuGendoGaku();
    }

    @JsonIgnore
    public void  setLblKubunShikyuGendoGaku(Label lblKubunShikyuGendoGaku) {
        this.getTplGendoGaku().setLblKubunShikyuGendoGaku(lblKubunShikyuGendoGaku);
    }

    @JsonIgnore
    public TextBoxNum getTxtKubunShikyuGendoKijunGaku() {
        return this.getTplGendoGaku().getTxtKubunShikyuGendoKijunGaku();
    }

    @JsonIgnore
    public void  setTxtKubunShikyuGendoKijunGaku(TextBoxNum txtKubunShikyuGendoKijunGaku) {
        this.getTplGendoGaku().setTxtKubunShikyuGendoKijunGaku(txtKubunShikyuGendoKijunGaku);
    }

    @JsonIgnore
    public TextBoxDateRange getTxtKyuhuYukoKikan() {
        return this.getTplGendoGaku().getTxtKyuhuYukoKikan();
    }

    @JsonIgnore
    public void  setTxtKyuhuYukoKikan(TextBoxDateRange txtKyuhuYukoKikan) {
        this.getTplGendoGaku().setTxtKyuhuYukoKikan(txtKyuhuYukoKikan);
    }

    @JsonIgnore
    public ShuruiShikyuGendoKijungakuDiv getShuruiShikyuGendoKijungaku() {
        return this.getTplGendoGaku().getShuruiShikyuGendoKijungaku();
    }

    @JsonIgnore
    public void  setShuruiShikyuGendoKijungaku(ShuruiShikyuGendoKijungakuDiv ShuruiShikyuGendoKijungaku) {
        this.getTplGendoGaku().setShuruiShikyuGendoKijungaku(ShuruiShikyuGendoKijungaku);
    }

    @JsonIgnore
    public Label getLblShinsakaiIken() {
        return this.getTplShinsakaiIken().getLblShinsakaiIken();
    }

    @JsonIgnore
    public void  setLblShinsakaiIken(Label lblShinsakaiIken) {
        this.getTplShinsakaiIken().setLblShinsakaiIken(lblShinsakaiIken);
    }

    @JsonIgnore
    public TextBoxMultiLine getTxtShinsakaiIken() {
        return this.getTplShinsakaiIken().getTxtShinsakaiIken();
    }

    @JsonIgnore
    public void  setTxtShinsakaiIken(TextBoxMultiLine txtShinsakaiIken) {
        this.getTplShinsakaiIken().setTxtShinsakaiIken(txtShinsakaiIken);
    }

    @JsonIgnore
    public Label getLblKyufuSeigen() {
        return this.getTplKyufuSeigen().getLblKyufuSeigen();
    }

    @JsonIgnore
    public void  setLblKyufuSeigen(Label lblKyufuSeigen) {
        this.getTplKyufuSeigen().setLblKyufuSeigen(lblKyufuSeigen);
    }

    @JsonIgnore
    public tblKyuhuSeigenDiv getTblKyuhuSeigen() {
        return this.getTplKyufuSeigen().getTblKyuhuSeigen();
    }

    @JsonIgnore
    public void  setTblKyuhuSeigen(tblKyuhuSeigenDiv tblKyuhuSeigen) {
        this.getTplKyufuSeigen().setTblKyuhuSeigen(tblKyuhuSeigen);
    }

    @JsonIgnore
    public Label getLblKyufuSeigenNaiyo() {
        return this.getTplKyufuSeigen().getTblKyuhuSeigen().getLblKyufuSeigenNaiyo();
    }

    @JsonIgnore
    public Label getLblKyufuSeigenKikan() {
        return this.getTplKyufuSeigen().getTblKyuhuSeigen().getLblKyufuSeigenKikan();
    }

    @JsonIgnore
    public TextBox getTxtKyufuSeigenNaiyo1() {
        return this.getTplKyufuSeigen().getTblKyuhuSeigen().getTxtKyufuSeigenNaiyo1();
    }

    @JsonIgnore
    public TextBoxDateRange getTxtKyufuSeigenKikan1() {
        return this.getTplKyufuSeigen().getTblKyuhuSeigen().getTxtKyufuSeigenKikan1();
    }

    @JsonIgnore
    public TextBox getTxtKyufuSeigenNaiyo2() {
        return this.getTplKyufuSeigen().getTblKyuhuSeigen().getTxtKyufuSeigenNaiyo2();
    }

    @JsonIgnore
    public TextBoxDateRange getTxtKyufuSeigenKikan2() {
        return this.getTplKyufuSeigen().getTblKyuhuSeigen().getTxtKyufuSeigenKikan2();
    }

    @JsonIgnore
    public TextBox getTxtKyufuSeigenNaiyo3() {
        return this.getTplKyufuSeigen().getTblKyuhuSeigen().getTxtKyufuSeigenNaiyo3();
    }

    @JsonIgnore
    public TextBoxDateRange getTxtKyufuSeigenKikan3() {
        return this.getTplKyufuSeigen().getTblKyuhuSeigen().getTxtKyufuSeigenKikan3();
    }

    @JsonIgnore
    public Label getLblShienJigyosha() {
        return this.getTplShienJigyosha().getLblShienJigyosha();
    }

    @JsonIgnore
    public void  setLblShienJigyosha(Label lblShienJigyosha) {
        this.getTplShienJigyosha().setLblShienJigyosha(lblShienJigyosha);
    }

    @JsonIgnore
    public tblJigyoshaDiv getTblJigyosha() {
        return this.getTplShienJigyosha().getTblJigyosha();
    }

    @JsonIgnore
    public void  setTblJigyosha(tblJigyoshaDiv tblJigyosha) {
        this.getTplShienJigyosha().setTblJigyosha(tblJigyosha);
    }

    @JsonIgnore
    public Label getLblJigyosha() {
        return this.getTplShienJigyosha().getTblJigyosha().getLblJigyosha();
    }

    @JsonIgnore
    public Label getLblTodokedeDate() {
        return this.getTplShienJigyosha().getTblJigyosha().getLblTodokedeDate();
    }

    @JsonIgnore
    public TextBox getTxtJigyosha1() {
        return this.getTplShienJigyosha().getTblJigyosha().getTxtJigyosha1();
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtTodokedeDate1() {
        return this.getTplShienJigyosha().getTblJigyosha().getTxtTodokedeDate1();
    }

    @JsonIgnore
    public TextBox getTxtJigyosha2() {
        return this.getTplShienJigyosha().getTblJigyosha().getTxtJigyosha2();
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtTodokedeDate2() {
        return this.getTplShienJigyosha().getTblJigyosha().getTxtTodokedeDate2();
    }

    @JsonIgnore
    public TextBox getTxtJigyosha3() {
        return this.getTplShienJigyosha().getTblJigyosha().getTxtJigyosha3();
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtTodokedeDate3() {
        return this.getTplShienJigyosha().getTblJigyosha().getTxtTodokedeDate3();
    }

    @JsonIgnore
    public Label getLblKaigoHokensha() {
        return this.getTplShisetsuNyutaisho().getLblKaigoHokensha();
    }

    @JsonIgnore
    public void  setLblKaigoHokensha(Label lblKaigoHokensha) {
        this.getTplShisetsuNyutaisho().setLblKaigoHokensha(lblKaigoHokensha);
    }

    @JsonIgnore
    public tblShisetsuNyutaishoDiv getTblShisetsuNyutaisho() {
        return this.getTplShisetsuNyutaisho().getTblShisetsuNyutaisho();
    }

    @JsonIgnore
    public void  setTblShisetsuNyutaisho(tblShisetsuNyutaishoDiv tblShisetsuNyutaisho) {
        this.getTplShisetsuNyutaisho().setTblShisetsuNyutaisho(tblShisetsuNyutaisho);
    }

    @JsonIgnore
    public Label getLblShisetsuShurui() {
        return this.getTplShisetsuNyutaisho().getTblShisetsuNyutaisho().getLblShisetsuShurui();
    }

    @JsonIgnore
    public Label getLblNyushoShisetsu() {
        return this.getTplShisetsuNyutaisho().getTblShisetsuNyutaisho().getLblNyushoShisetsu();
    }

    @JsonIgnore
    public Label getLblShisetsuNyushoDate() {
        return this.getTplShisetsuNyutaisho().getTblShisetsuNyutaisho().getLblShisetsuNyushoDate();
    }

    @JsonIgnore
    public Label getLblShisetsuTaishoDate() {
        return this.getTplShisetsuNyutaisho().getTblShisetsuNyutaisho().getLblShisetsuTaishoDate();
    }

    @JsonIgnore
    public TextBox getTxtShisetsuShurui1() {
        return this.getTplShisetsuNyutaisho().getTblShisetsuNyutaisho().getTxtShisetsuShurui1();
    }

    @JsonIgnore
    public TextBox getTxtNyushoShisetsu1() {
        return this.getTplShisetsuNyutaisho().getTblShisetsuNyutaisho().getTxtNyushoShisetsu1();
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtShisetsuNyushoDate1() {
        return this.getTplShisetsuNyutaisho().getTblShisetsuNyutaisho().getTxtShisetsuNyushoDate1();
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtShisetsuTaishoDate1() {
        return this.getTplShisetsuNyutaisho().getTblShisetsuNyutaisho().getTxtShisetsuTaishoDate1();
    }

    @JsonIgnore
    public TextBox getTxtShisetsuShurui2() {
        return this.getTplShisetsuNyutaisho().getTblShisetsuNyutaisho().getTxtShisetsuShurui2();
    }

    @JsonIgnore
    public TextBox getTxtNyushoShisetsu2() {
        return this.getTplShisetsuNyutaisho().getTblShisetsuNyutaisho().getTxtNyushoShisetsu2();
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtShisetsuNyushoDate2() {
        return this.getTplShisetsuNyutaisho().getTblShisetsuNyutaisho().getTxtShisetsuNyushoDate2();
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtShisetsuTaishoDate2() {
        return this.getTplShisetsuNyutaisho().getTblShisetsuNyutaisho().getTxtShisetsuTaishoDate2();
    }

    @JsonIgnore
    public TextBox getTxtShisetsuShurui3() {
        return this.getTplShisetsuNyutaisho().getTblShisetsuNyutaisho().getTxtShisetsuShurui3();
    }

    @JsonIgnore
    public TextBox getTxtNyushoShisetsu3() {
        return this.getTplShisetsuNyutaisho().getTblShisetsuNyutaisho().getTxtNyushoShisetsu3();
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtShisetsuNyushoDate3() {
        return this.getTplShisetsuNyutaisho().getTblShisetsuNyutaisho().getTxtShisetsuNyushoDate3();
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtShisetsuTaishoDate3() {
        return this.getTplShisetsuNyutaisho().getTblShisetsuNyutaisho().getTxtShisetsuTaishoDate3();
    }

}
