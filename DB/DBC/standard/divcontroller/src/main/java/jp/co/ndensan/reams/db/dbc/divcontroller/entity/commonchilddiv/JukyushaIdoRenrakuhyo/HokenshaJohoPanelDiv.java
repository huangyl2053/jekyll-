package jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.JukyushaIdoRenrakuhyo;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * HokenshaJohoPanel のクラスファイル 
 * 
 * @author 自動生成
 */
public class HokenshaJohoPanelDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-01-15_09-59-03">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtShisetsuShozaiHokenjaNo")
    private TextBoxCode txtShisetsuShozaiHokenjaNo;
    @JsonProperty("btnHokenshaSelect")
    private ButtonDialog btnHokenshaSelect;
    @JsonProperty("txtHokenshaMeisho")
    private TextBox txtHokenshaMeisho;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtShisetsuShozaiHokenjaNo
     * @return txtShisetsuShozaiHokenjaNo
     */
    @JsonProperty("txtShisetsuShozaiHokenjaNo")
    public TextBoxCode getTxtShisetsuShozaiHokenjaNo() {
        return txtShisetsuShozaiHokenjaNo;
    }

    /*
     * settxtShisetsuShozaiHokenjaNo
     * @param txtShisetsuShozaiHokenjaNo txtShisetsuShozaiHokenjaNo
     */
    @JsonProperty("txtShisetsuShozaiHokenjaNo")
    public void setTxtShisetsuShozaiHokenjaNo(TextBoxCode txtShisetsuShozaiHokenjaNo) {
        this.txtShisetsuShozaiHokenjaNo = txtShisetsuShozaiHokenjaNo;
    }

    /*
     * getbtnHokenshaSelect
     * @return btnHokenshaSelect
     */
    @JsonProperty("btnHokenshaSelect")
    public ButtonDialog getBtnHokenshaSelect() {
        return btnHokenshaSelect;
    }

    /*
     * setbtnHokenshaSelect
     * @param btnHokenshaSelect btnHokenshaSelect
     */
    @JsonProperty("btnHokenshaSelect")
    public void setBtnHokenshaSelect(ButtonDialog btnHokenshaSelect) {
        this.btnHokenshaSelect = btnHokenshaSelect;
    }

    /*
     * gettxtHokenshaMeisho
     * @return txtHokenshaMeisho
     */
    @JsonProperty("txtHokenshaMeisho")
    public TextBox getTxtHokenshaMeisho() {
        return txtHokenshaMeisho;
    }

    /*
     * settxtHokenshaMeisho
     * @param txtHokenshaMeisho txtHokenshaMeisho
     */
    @JsonProperty("txtHokenshaMeisho")
    public void setTxtHokenshaMeisho(TextBox txtHokenshaMeisho) {
        this.txtHokenshaMeisho = txtHokenshaMeisho;
    }

    // </editor-fold>
}
