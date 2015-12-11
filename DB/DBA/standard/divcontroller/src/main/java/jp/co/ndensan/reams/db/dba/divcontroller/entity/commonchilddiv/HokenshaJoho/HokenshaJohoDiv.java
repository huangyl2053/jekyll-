package jp.co.ndensan.reams.db.dba.divcontroller.entity.commonchilddiv.HokenshaJoho;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * HokenshaJoho のクラスファイル 
 * 
 * @author 自動生成
 */
public class HokenshaJohoDiv extends Panel implements IHokenshaJohoDiv {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：バージョン情報無し">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtHokenshaNo")
    private TextBoxCode txtHokenshaNo;
    @JsonProperty("btnHokenshaSelect")
    private ButtonDialog btnHokenshaSelect;
    @JsonProperty("txtHokenshaMeisho")
    private TextBox txtHokenshaMeisho;
    @JsonProperty("HokenshaModel")
    private RString HokenshaModel;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtHokenshaNo
     * @return txtHokenshaNo
     */
    @JsonProperty("txtHokenshaNo")
    public TextBoxCode getTxtHokenshaNo() {
        return txtHokenshaNo;
    }

    /*
     * settxtHokenshaNo
     * @param txtHokenshaNo txtHokenshaNo
     */
    @JsonProperty("txtHokenshaNo")
    public void setTxtHokenshaNo(TextBoxCode txtHokenshaNo) {
        this.txtHokenshaNo = txtHokenshaNo;
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

    /*
     * getHokenshaModel
     * @return HokenshaModel
     */
    @JsonProperty("HokenshaModel")
    public RString getHokenshaModel() {
        return HokenshaModel;
    }

    /*
     * setHokenshaModel
     * @param HokenshaModel HokenshaModel
     */
    @JsonProperty("HokenshaModel")
    public void setHokenshaModel(RString HokenshaModel) {
        this.HokenshaModel = HokenshaModel;
    }

    // </editor-fold>
    //--------------- この行より下にコードを追加してください -------------------

}
