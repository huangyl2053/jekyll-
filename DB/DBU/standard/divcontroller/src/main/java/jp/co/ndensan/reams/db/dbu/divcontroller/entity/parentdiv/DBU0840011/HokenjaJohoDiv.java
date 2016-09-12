package jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0840011;
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
 * HokenjaJoho のクラスファイル 
 * 
 * @author 自動生成
 */
public class HokenjaJohoDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-03-22_14-06-37">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("HokenjaJoho1")
    private HokenjaJoho1Div HokenjaJoho1;
    @JsonProperty("HokenjaJoho2")
    private HokenjaJoho2Div HokenjaJoho2;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getHokenjaJoho1
     * @return HokenjaJoho1
     */
    @JsonProperty("HokenjaJoho1")
    public HokenjaJoho1Div getHokenjaJoho1() {
        return HokenjaJoho1;
    }

    /*
     * setHokenjaJoho1
     * @param HokenjaJoho1 HokenjaJoho1
     */
    @JsonProperty("HokenjaJoho1")
    public void setHokenjaJoho1(HokenjaJoho1Div HokenjaJoho1) {
        this.HokenjaJoho1 = HokenjaJoho1;
    }

    /*
     * getHokenjaJoho2
     * @return HokenjaJoho2
     */
    @JsonProperty("HokenjaJoho2")
    public HokenjaJoho2Div getHokenjaJoho2() {
        return HokenjaJoho2;
    }

    /*
     * setHokenjaJoho2
     * @param HokenjaJoho2 HokenjaJoho2
     */
    @JsonProperty("HokenjaJoho2")
    public void setHokenjaJoho2(HokenjaJoho2Div HokenjaJoho2) {
        this.HokenjaJoho2 = HokenjaJoho2;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public TextBoxCode getTxtHokenjaCode() {
        return this.getHokenjaJoho1().getTxtHokenjaCode();
    }

    @JsonIgnore
    public void  setTxtHokenjaCode(TextBoxCode txtHokenjaCode) {
        this.getHokenjaJoho1().setTxtHokenjaCode(txtHokenjaCode);
    }

    @JsonIgnore
    public TextBoxYubinNo getTxtYubinNo() {
        return this.getHokenjaJoho1().getTxtYubinNo();
    }

    @JsonIgnore
    public void  setTxtYubinNo(TextBoxYubinNo txtYubinNo) {
        this.getHokenjaJoho1().setTxtYubinNo(txtYubinNo);
    }

    @JsonIgnore
    public TextBoxTelNo getTxtTelNo() {
        return this.getHokenjaJoho1().getTxtTelNo();
    }

    @JsonIgnore
    public void  setTxtTelNo(TextBoxTelNo txtTelNo) {
        this.getHokenjaJoho1().setTxtTelNo(txtTelNo);
    }

    @JsonIgnore
    public DropDownList getDdlGaikokujinHyoji() {
        return this.getHokenjaJoho1().getDdlGaikokujinHyoji();
    }

    @JsonIgnore
    public void  setDdlGaikokujinHyoji(DropDownList ddlGaikokujinHyoji) {
        this.getHokenjaJoho1().setDdlGaikokujinHyoji(ddlGaikokujinHyoji);
    }

    @JsonIgnore
    public TextBox getTxtHokenjaName() {
        return this.getHokenjaJoho2().getTxtHokenjaName();
    }

    @JsonIgnore
    public void  setTxtHokenjaName(TextBox txtHokenjaName) {
        this.getHokenjaJoho2().setTxtHokenjaName(txtHokenjaName);
    }

    @JsonIgnore
    public TextBoxJusho getTxtJusho() {
        return this.getHokenjaJoho2().getTxtJusho();
    }

    @JsonIgnore
    public void  setTxtJusho(TextBoxJusho txtJusho) {
        this.getHokenjaJoho2().setTxtJusho(txtJusho);
    }

    @JsonIgnore
    public DropDownList getDdlChikuCode() {
        return this.getHokenjaJoho2().getDdlChikuCode();
    }

    @JsonIgnore
    public void  setDdlChikuCode(DropDownList ddlChikuCode) {
        this.getHokenjaJoho2().setDdlChikuCode(ddlChikuCode);
    }

    @JsonIgnore
    public DropDownList getDdlGaikokujinBirthdayHyoji() {
        return this.getHokenjaJoho2().getDdlGaikokujinBirthdayHyoji();
    }

    @JsonIgnore
    public void  setDdlGaikokujinBirthdayHyoji(DropDownList ddlGaikokujinBirthdayHyoji) {
        this.getHokenjaJoho2().setDdlGaikokujinBirthdayHyoji(ddlGaikokujinBirthdayHyoji);
    }

    @JsonIgnore
    public TextBoxCode getTxtRojinHokenShichosonNo() {
        return this.getHokenjaJoho2().getTxtRojinHokenShichosonNo();
    }

    @JsonIgnore
    public void  setTxtRojinHokenShichosonNo(TextBoxCode txtRojinHokenShichosonNo) {
        this.getHokenjaJoho2().setTxtRojinHokenShichosonNo(txtRojinHokenShichosonNo);
    }

    // </editor-fold>
}
