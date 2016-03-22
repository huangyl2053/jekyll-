package jp.co.ndensan.reams.db.dbd.divcontroller.entity.commonchilddiv.gemmemgengakushinsei.GemmenGengakuShinsei;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * ShinseiDaikoJigyosha のクラスファイル 
 * 
 * @author 自動生成
 */
public class ShinseiDaikoJigyoshaDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-01-15_09-59-03">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtJigyoshaCode")
    private TextBoxCode txtJigyoshaCode;
    @JsonProperty("btnOpenJigyoshaGuide")
    private ButtonDialog btnOpenJigyoshaGuide;
    @JsonProperty("txtJigyoshaName")
    private TextBox txtJigyoshaName;
    @JsonProperty("ddlJigyoshaKubun")
    private DropDownList ddlJigyoshaKubun;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtJigyoshaCode
     * @return txtJigyoshaCode
     */
    @JsonProperty("txtJigyoshaCode")
    public TextBoxCode getTxtJigyoshaCode() {
        return txtJigyoshaCode;
    }

    /*
     * settxtJigyoshaCode
     * @param txtJigyoshaCode txtJigyoshaCode
     */
    @JsonProperty("txtJigyoshaCode")
    public void setTxtJigyoshaCode(TextBoxCode txtJigyoshaCode) {
        this.txtJigyoshaCode = txtJigyoshaCode;
    }

    /*
     * getbtnOpenJigyoshaGuide
     * @return btnOpenJigyoshaGuide
     */
    @JsonProperty("btnOpenJigyoshaGuide")
    public ButtonDialog getBtnOpenJigyoshaGuide() {
        return btnOpenJigyoshaGuide;
    }

    /*
     * setbtnOpenJigyoshaGuide
     * @param btnOpenJigyoshaGuide btnOpenJigyoshaGuide
     */
    @JsonProperty("btnOpenJigyoshaGuide")
    public void setBtnOpenJigyoshaGuide(ButtonDialog btnOpenJigyoshaGuide) {
        this.btnOpenJigyoshaGuide = btnOpenJigyoshaGuide;
    }

    /*
     * gettxtJigyoshaName
     * @return txtJigyoshaName
     */
    @JsonProperty("txtJigyoshaName")
    public TextBox getTxtJigyoshaName() {
        return txtJigyoshaName;
    }

    /*
     * settxtJigyoshaName
     * @param txtJigyoshaName txtJigyoshaName
     */
    @JsonProperty("txtJigyoshaName")
    public void setTxtJigyoshaName(TextBox txtJigyoshaName) {
        this.txtJigyoshaName = txtJigyoshaName;
    }

    /*
     * getddlJigyoshaKubun
     * @return ddlJigyoshaKubun
     */
    @JsonProperty("ddlJigyoshaKubun")
    public DropDownList getDdlJigyoshaKubun() {
        return ddlJigyoshaKubun;
    }

    /*
     * setddlJigyoshaKubun
     * @param ddlJigyoshaKubun ddlJigyoshaKubun
     */
    @JsonProperty("ddlJigyoshaKubun")
    public void setDdlJigyoshaKubun(DropDownList ddlJigyoshaKubun) {
        this.ddlJigyoshaKubun = ddlJigyoshaKubun;
    }

    // </editor-fold>
}
