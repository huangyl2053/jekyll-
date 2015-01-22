package jp.co.ndensan.reams.db.dba.divcontroller.entity.DBA2010011;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * CommonShisetsuSearch のクラスファイル 
 * 
 * @author 自動生成
 */
public class CommonShisetsuSearchDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtSearchJigyoshaNo")
    private TextBoxCode txtSearchJigyoshaNo;
    @JsonProperty("txtSearchJigyoshaKaishiDate")
    private TextBoxFlexibleDate txtSearchJigyoshaKaishiDate;
    @JsonProperty("txtSearchJigyoshaHaishiDate")
    private TextBoxFlexibleDate txtSearchJigyoshaHaishiDate;
    @JsonProperty("txtSearchJigyoshaMeiOrKanaMeisho")
    private TextBox txtSearchJigyoshaMeiOrKanaMeisho;
    @JsonProperty("ddlSearchMeishoMatchCondition")
    private DropDownList ddlSearchMeishoMatchCondition;
    @JsonProperty("txtSearchYubinNo")
    private TextBoxYubinNo txtSearchYubinNo;
    @JsonProperty("txtSearchJusho")
    private TextBox txtSearchJusho;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("txtSearchJigyoshaNo")
    public TextBoxCode getTxtSearchJigyoshaNo() {
        return txtSearchJigyoshaNo;
    }

    @JsonProperty("txtSearchJigyoshaNo")
    public void setTxtSearchJigyoshaNo(TextBoxCode txtSearchJigyoshaNo) {
        this.txtSearchJigyoshaNo=txtSearchJigyoshaNo;
    }

    @JsonProperty("txtSearchJigyoshaKaishiDate")
    public TextBoxFlexibleDate getTxtSearchJigyoshaKaishiDate() {
        return txtSearchJigyoshaKaishiDate;
    }

    @JsonProperty("txtSearchJigyoshaKaishiDate")
    public void setTxtSearchJigyoshaKaishiDate(TextBoxFlexibleDate txtSearchJigyoshaKaishiDate) {
        this.txtSearchJigyoshaKaishiDate=txtSearchJigyoshaKaishiDate;
    }

    @JsonProperty("txtSearchJigyoshaHaishiDate")
    public TextBoxFlexibleDate getTxtSearchJigyoshaHaishiDate() {
        return txtSearchJigyoshaHaishiDate;
    }

    @JsonProperty("txtSearchJigyoshaHaishiDate")
    public void setTxtSearchJigyoshaHaishiDate(TextBoxFlexibleDate txtSearchJigyoshaHaishiDate) {
        this.txtSearchJigyoshaHaishiDate=txtSearchJigyoshaHaishiDate;
    }

    @JsonProperty("txtSearchJigyoshaMeiOrKanaMeisho")
    public TextBox getTxtSearchJigyoshaMeiOrKanaMeisho() {
        return txtSearchJigyoshaMeiOrKanaMeisho;
    }

    @JsonProperty("txtSearchJigyoshaMeiOrKanaMeisho")
    public void setTxtSearchJigyoshaMeiOrKanaMeisho(TextBox txtSearchJigyoshaMeiOrKanaMeisho) {
        this.txtSearchJigyoshaMeiOrKanaMeisho=txtSearchJigyoshaMeiOrKanaMeisho;
    }

    @JsonProperty("ddlSearchMeishoMatchCondition")
    public DropDownList getDdlSearchMeishoMatchCondition() {
        return ddlSearchMeishoMatchCondition;
    }

    @JsonProperty("ddlSearchMeishoMatchCondition")
    public void setDdlSearchMeishoMatchCondition(DropDownList ddlSearchMeishoMatchCondition) {
        this.ddlSearchMeishoMatchCondition=ddlSearchMeishoMatchCondition;
    }

    @JsonProperty("txtSearchYubinNo")
    public TextBoxYubinNo getTxtSearchYubinNo() {
        return txtSearchYubinNo;
    }

    @JsonProperty("txtSearchYubinNo")
    public void setTxtSearchYubinNo(TextBoxYubinNo txtSearchYubinNo) {
        this.txtSearchYubinNo=txtSearchYubinNo;
    }

    @JsonProperty("txtSearchJusho")
    public TextBox getTxtSearchJusho() {
        return txtSearchJusho;
    }

    @JsonProperty("txtSearchJusho")
    public void setTxtSearchJusho(TextBox txtSearchJusho) {
        this.txtSearchJusho=txtSearchJusho;
    }

}
