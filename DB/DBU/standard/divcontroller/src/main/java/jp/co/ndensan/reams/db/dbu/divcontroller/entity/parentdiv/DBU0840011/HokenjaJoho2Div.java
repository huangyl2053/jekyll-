package jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0840011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * HokenjaJoho2 のクラスファイル 
 * 
 * @author 自動生成
 */
public class HokenjaJoho2Div extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-03-22_14-06-37">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtHokenjaName")
    private TextBox txtHokenjaName;
    @JsonProperty("txtJusho")
    private TextBoxJusho txtJusho;
    @JsonProperty("ddlChikuCode")
    private DropDownList ddlChikuCode;
    @JsonProperty("ddlGaikokujinBirthdayHyoji")
    private DropDownList ddlGaikokujinBirthdayHyoji;
    @JsonProperty("txtRojinHokenShichosonNo")
    private TextBoxCode txtRojinHokenShichosonNo;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtHokenjaName
     * @return txtHokenjaName
     */
    @JsonProperty("txtHokenjaName")
    public TextBox getTxtHokenjaName() {
        return txtHokenjaName;
    }

    /*
     * settxtHokenjaName
     * @param txtHokenjaName txtHokenjaName
     */
    @JsonProperty("txtHokenjaName")
    public void setTxtHokenjaName(TextBox txtHokenjaName) {
        this.txtHokenjaName = txtHokenjaName;
    }

    /*
     * gettxtJusho
     * @return txtJusho
     */
    @JsonProperty("txtJusho")
    public TextBoxJusho getTxtJusho() {
        return txtJusho;
    }

    /*
     * settxtJusho
     * @param txtJusho txtJusho
     */
    @JsonProperty("txtJusho")
    public void setTxtJusho(TextBoxJusho txtJusho) {
        this.txtJusho = txtJusho;
    }

    /*
     * getddlChikuCode
     * @return ddlChikuCode
     */
    @JsonProperty("ddlChikuCode")
    public DropDownList getDdlChikuCode() {
        return ddlChikuCode;
    }

    /*
     * setddlChikuCode
     * @param ddlChikuCode ddlChikuCode
     */
    @JsonProperty("ddlChikuCode")
    public void setDdlChikuCode(DropDownList ddlChikuCode) {
        this.ddlChikuCode = ddlChikuCode;
    }

    /*
     * getddlGaikokujinBirthdayHyoji
     * @return ddlGaikokujinBirthdayHyoji
     */
    @JsonProperty("ddlGaikokujinBirthdayHyoji")
    public DropDownList getDdlGaikokujinBirthdayHyoji() {
        return ddlGaikokujinBirthdayHyoji;
    }

    /*
     * setddlGaikokujinBirthdayHyoji
     * @param ddlGaikokujinBirthdayHyoji ddlGaikokujinBirthdayHyoji
     */
    @JsonProperty("ddlGaikokujinBirthdayHyoji")
    public void setDdlGaikokujinBirthdayHyoji(DropDownList ddlGaikokujinBirthdayHyoji) {
        this.ddlGaikokujinBirthdayHyoji = ddlGaikokujinBirthdayHyoji;
    }

    /*
     * gettxtRojinHokenShichosonNo
     * @return txtRojinHokenShichosonNo
     */
    @JsonProperty("txtRojinHokenShichosonNo")
    public TextBoxCode getTxtRojinHokenShichosonNo() {
        return txtRojinHokenShichosonNo;
    }

    /*
     * settxtRojinHokenShichosonNo
     * @param txtRojinHokenShichosonNo txtRojinHokenShichosonNo
     */
    @JsonProperty("txtRojinHokenShichosonNo")
    public void setTxtRojinHokenShichosonNo(TextBoxCode txtRojinHokenShichosonNo) {
        this.txtRojinHokenShichosonNo = txtRojinHokenShichosonNo;
    }

    // </editor-fold>
}
