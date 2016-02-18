package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0700011;
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
 * JutakuKaishuJizenShinseiReason のクラスファイル 
 * 
 * @author 自動生成
 */
public class JutakuKaishuJizenShinseiReasonDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：バージョン情報無し">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtCreateYMD")
    private TextBoxDate txtCreateYMD;
    @JsonProperty("txtCreatorKanaName")
    private TextBoxAtenaKanaMeisho txtCreatorKanaName;
    @JsonProperty("txtCreatorName")
    private TextBoxAtenaMeisho txtCreatorName;
    @JsonProperty("txtCreationJigyoshaNo")
    private TextBoxCode txtCreationJigyoshaNo;
    @JsonProperty("btnJigyoshaInputGuide")
    private ButtonDialog btnJigyoshaInputGuide;
    @JsonProperty("txtCreationJigyoshaName")
    private TextBox txtCreationJigyoshaName;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtCreateYMD
     * @return txtCreateYMD
     */
    @JsonProperty("txtCreateYMD")
    public TextBoxDate getTxtCreateYMD() {
        return txtCreateYMD;
    }

    /*
     * settxtCreateYMD
     * @param txtCreateYMD txtCreateYMD
     */
    @JsonProperty("txtCreateYMD")
    public void setTxtCreateYMD(TextBoxDate txtCreateYMD) {
        this.txtCreateYMD = txtCreateYMD;
    }

    /*
     * gettxtCreatorKanaName
     * @return txtCreatorKanaName
     */
    @JsonProperty("txtCreatorKanaName")
    public TextBoxAtenaKanaMeisho getTxtCreatorKanaName() {
        return txtCreatorKanaName;
    }

    /*
     * settxtCreatorKanaName
     * @param txtCreatorKanaName txtCreatorKanaName
     */
    @JsonProperty("txtCreatorKanaName")
    public void setTxtCreatorKanaName(TextBoxAtenaKanaMeisho txtCreatorKanaName) {
        this.txtCreatorKanaName = txtCreatorKanaName;
    }

    /*
     * gettxtCreatorName
     * @return txtCreatorName
     */
    @JsonProperty("txtCreatorName")
    public TextBoxAtenaMeisho getTxtCreatorName() {
        return txtCreatorName;
    }

    /*
     * settxtCreatorName
     * @param txtCreatorName txtCreatorName
     */
    @JsonProperty("txtCreatorName")
    public void setTxtCreatorName(TextBoxAtenaMeisho txtCreatorName) {
        this.txtCreatorName = txtCreatorName;
    }

    /*
     * gettxtCreationJigyoshaNo
     * @return txtCreationJigyoshaNo
     */
    @JsonProperty("txtCreationJigyoshaNo")
    public TextBoxCode getTxtCreationJigyoshaNo() {
        return txtCreationJigyoshaNo;
    }

    /*
     * settxtCreationJigyoshaNo
     * @param txtCreationJigyoshaNo txtCreationJigyoshaNo
     */
    @JsonProperty("txtCreationJigyoshaNo")
    public void setTxtCreationJigyoshaNo(TextBoxCode txtCreationJigyoshaNo) {
        this.txtCreationJigyoshaNo = txtCreationJigyoshaNo;
    }

    /*
     * getbtnJigyoshaInputGuide
     * @return btnJigyoshaInputGuide
     */
    @JsonProperty("btnJigyoshaInputGuide")
    public ButtonDialog getBtnJigyoshaInputGuide() {
        return btnJigyoshaInputGuide;
    }

    /*
     * setbtnJigyoshaInputGuide
     * @param btnJigyoshaInputGuide btnJigyoshaInputGuide
     */
    @JsonProperty("btnJigyoshaInputGuide")
    public void setBtnJigyoshaInputGuide(ButtonDialog btnJigyoshaInputGuide) {
        this.btnJigyoshaInputGuide = btnJigyoshaInputGuide;
    }

    /*
     * gettxtCreationJigyoshaName
     * @return txtCreationJigyoshaName
     */
    @JsonProperty("txtCreationJigyoshaName")
    public TextBox getTxtCreationJigyoshaName() {
        return txtCreationJigyoshaName;
    }

    /*
     * settxtCreationJigyoshaName
     * @param txtCreationJigyoshaName txtCreationJigyoshaName
     */
    @JsonProperty("txtCreationJigyoshaName")
    public void setTxtCreationJigyoshaName(TextBox txtCreationJigyoshaName) {
        this.txtCreationJigyoshaName = txtCreationJigyoshaName;
    }

    // </editor-fold>
}
