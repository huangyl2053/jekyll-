package jp.co.ndensan.reams.db.dbu.divcontroller.entity.DBU0500011;
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
 * SearchShoKaishuKanri のクラスファイル 
 * 
 * @author 自動生成
 */
public class SearchShoKaishuKanriDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtSearchHihokenshaNo")
    private TextBoxCode txtSearchHihokenshaNo;
    @JsonProperty("btnHihokenshaInputGuide")
    private ButtonDialog btnHihokenshaInputGuide;
    @JsonProperty("txtSearchHihokenshaMeisho")
    private TextBox txtSearchHihokenshaMeisho;
    @JsonProperty("radSearchKohushoShurui")
    private RadioButton radSearchKohushoShurui;
    @JsonProperty("txtSearchKofuKikan")
    private TextBoxDateRange txtSearchKofuKikan;
    @JsonProperty("chkKaishuKirokuZumi")
    private CheckBoxList chkKaishuKirokuZumi;
    @JsonProperty("btnSearchShoKaishuKanri")
    private Button btnSearchShoKaishuKanri;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("txtSearchHihokenshaNo")
    public TextBoxCode getTxtSearchHihokenshaNo() {
        return txtSearchHihokenshaNo;
    }

    @JsonProperty("txtSearchHihokenshaNo")
    public void setTxtSearchHihokenshaNo(TextBoxCode txtSearchHihokenshaNo) {
        this.txtSearchHihokenshaNo=txtSearchHihokenshaNo;
    }

    @JsonProperty("btnHihokenshaInputGuide")
    public ButtonDialog getBtnHihokenshaInputGuide() {
        return btnHihokenshaInputGuide;
    }

    @JsonProperty("btnHihokenshaInputGuide")
    public void setBtnHihokenshaInputGuide(ButtonDialog btnHihokenshaInputGuide) {
        this.btnHihokenshaInputGuide=btnHihokenshaInputGuide;
    }

    @JsonProperty("txtSearchHihokenshaMeisho")
    public TextBox getTxtSearchHihokenshaMeisho() {
        return txtSearchHihokenshaMeisho;
    }

    @JsonProperty("txtSearchHihokenshaMeisho")
    public void setTxtSearchHihokenshaMeisho(TextBox txtSearchHihokenshaMeisho) {
        this.txtSearchHihokenshaMeisho=txtSearchHihokenshaMeisho;
    }

    @JsonProperty("radSearchKohushoShurui")
    public RadioButton getRadSearchKohushoShurui() {
        return radSearchKohushoShurui;
    }

    @JsonProperty("radSearchKohushoShurui")
    public void setRadSearchKohushoShurui(RadioButton radSearchKohushoShurui) {
        this.radSearchKohushoShurui=radSearchKohushoShurui;
    }

    @JsonProperty("txtSearchKofuKikan")
    public TextBoxDateRange getTxtSearchKofuKikan() {
        return txtSearchKofuKikan;
    }

    @JsonProperty("txtSearchKofuKikan")
    public void setTxtSearchKofuKikan(TextBoxDateRange txtSearchKofuKikan) {
        this.txtSearchKofuKikan=txtSearchKofuKikan;
    }

    @JsonProperty("chkKaishuKirokuZumi")
    public CheckBoxList getChkKaishuKirokuZumi() {
        return chkKaishuKirokuZumi;
    }

    @JsonProperty("chkKaishuKirokuZumi")
    public void setChkKaishuKirokuZumi(CheckBoxList chkKaishuKirokuZumi) {
        this.chkKaishuKirokuZumi=chkKaishuKirokuZumi;
    }

    @JsonProperty("btnSearchShoKaishuKanri")
    public Button getBtnSearchShoKaishuKanri() {
        return btnSearchShoKaishuKanri;
    }

    @JsonProperty("btnSearchShoKaishuKanri")
    public void setBtnSearchShoKaishuKanri(Button btnSearchShoKaishuKanri) {
        this.btnSearchShoKaishuKanri=btnSearchShoKaishuKanri;
    }

}
