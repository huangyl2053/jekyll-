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
 * HokenjaJoho1 のクラスファイル 
 * 
 * @author 自動生成
 */
public class HokenjaJoho1Div extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-03-22_14-06-37">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtHokenjaCode")
    private TextBoxCode txtHokenjaCode;
    @JsonProperty("txtYubinNo")
    private TextBoxYubinNo txtYubinNo;
    @JsonProperty("txtTelNo")
    private TextBoxTelNo txtTelNo;
    @JsonProperty("ddlGaikokujinHyoji")
    private DropDownList ddlGaikokujinHyoji;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtHokenjaCode
     * @return txtHokenjaCode
     */
    @JsonProperty("txtHokenjaCode")
    public TextBoxCode getTxtHokenjaCode() {
        return txtHokenjaCode;
    }

    /*
     * settxtHokenjaCode
     * @param txtHokenjaCode txtHokenjaCode
     */
    @JsonProperty("txtHokenjaCode")
    public void setTxtHokenjaCode(TextBoxCode txtHokenjaCode) {
        this.txtHokenjaCode = txtHokenjaCode;
    }

    /*
     * gettxtYubinNo
     * @return txtYubinNo
     */
    @JsonProperty("txtYubinNo")
    public TextBoxYubinNo getTxtYubinNo() {
        return txtYubinNo;
    }

    /*
     * settxtYubinNo
     * @param txtYubinNo txtYubinNo
     */
    @JsonProperty("txtYubinNo")
    public void setTxtYubinNo(TextBoxYubinNo txtYubinNo) {
        this.txtYubinNo = txtYubinNo;
    }

    /*
     * gettxtTelNo
     * @return txtTelNo
     */
    @JsonProperty("txtTelNo")
    public TextBoxTelNo getTxtTelNo() {
        return txtTelNo;
    }

    /*
     * settxtTelNo
     * @param txtTelNo txtTelNo
     */
    @JsonProperty("txtTelNo")
    public void setTxtTelNo(TextBoxTelNo txtTelNo) {
        this.txtTelNo = txtTelNo;
    }

    /*
     * getddlGaikokujinHyoji
     * @return ddlGaikokujinHyoji
     */
    @JsonProperty("ddlGaikokujinHyoji")
    public DropDownList getDdlGaikokujinHyoji() {
        return ddlGaikokujinHyoji;
    }

    /*
     * setddlGaikokujinHyoji
     * @param ddlGaikokujinHyoji ddlGaikokujinHyoji
     */
    @JsonProperty("ddlGaikokujinHyoji")
    public void setDdlGaikokujinHyoji(DropDownList ddlGaikokujinHyoji) {
        this.ddlGaikokujinHyoji = ddlGaikokujinHyoji;
    }

    // </editor-fold>
}
