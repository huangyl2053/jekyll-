package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.NinteiChosaJokyo.NinteiChosaJokyo;
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
 * HomonChosasaki のクラスファイル 
 * 
 * @author 自動生成
 */
public class HomonChosasakiDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：Uz-master-57">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtChosasakiName")
    private TextBox txtChosasakiName;
    @JsonProperty("btnHomonChosaClear")
    private Button btnHomonChosaClear;
    @JsonProperty("txtChosasakiYubinNo")
    private TextBoxYubinNo txtChosasakiYubinNo;
    @JsonProperty("txtChosasakiJusho")
    private TextBoxJusho txtChosasakiJusho;
    @JsonProperty("txtChosasakiTelNo")
    private TextBoxTelNo txtChosasakiTelNo;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtChosasakiName
     * @return txtChosasakiName
     */
    @JsonProperty("txtChosasakiName")
    public TextBox getTxtChosasakiName() {
        return txtChosasakiName;
    }

    /*
     * settxtChosasakiName
     * @param txtChosasakiName txtChosasakiName
     */
    @JsonProperty("txtChosasakiName")
    public void setTxtChosasakiName(TextBox txtChosasakiName) {
        this.txtChosasakiName = txtChosasakiName;
    }

    /*
     * getbtnHomonChosaClear
     * @return btnHomonChosaClear
     */
    @JsonProperty("btnHomonChosaClear")
    public Button getBtnHomonChosaClear() {
        return btnHomonChosaClear;
    }

    /*
     * setbtnHomonChosaClear
     * @param btnHomonChosaClear btnHomonChosaClear
     */
    @JsonProperty("btnHomonChosaClear")
    public void setBtnHomonChosaClear(Button btnHomonChosaClear) {
        this.btnHomonChosaClear = btnHomonChosaClear;
    }

    /*
     * gettxtChosasakiYubinNo
     * @return txtChosasakiYubinNo
     */
    @JsonProperty("txtChosasakiYubinNo")
    public TextBoxYubinNo getTxtChosasakiYubinNo() {
        return txtChosasakiYubinNo;
    }

    /*
     * settxtChosasakiYubinNo
     * @param txtChosasakiYubinNo txtChosasakiYubinNo
     */
    @JsonProperty("txtChosasakiYubinNo")
    public void setTxtChosasakiYubinNo(TextBoxYubinNo txtChosasakiYubinNo) {
        this.txtChosasakiYubinNo = txtChosasakiYubinNo;
    }

    /*
     * gettxtChosasakiJusho
     * @return txtChosasakiJusho
     */
    @JsonProperty("txtChosasakiJusho")
    public TextBoxJusho getTxtChosasakiJusho() {
        return txtChosasakiJusho;
    }

    /*
     * settxtChosasakiJusho
     * @param txtChosasakiJusho txtChosasakiJusho
     */
    @JsonProperty("txtChosasakiJusho")
    public void setTxtChosasakiJusho(TextBoxJusho txtChosasakiJusho) {
        this.txtChosasakiJusho = txtChosasakiJusho;
    }

    /*
     * gettxtChosasakiTelNo
     * @return txtChosasakiTelNo
     */
    @JsonProperty("txtChosasakiTelNo")
    public TextBoxTelNo getTxtChosasakiTelNo() {
        return txtChosasakiTelNo;
    }

    /*
     * settxtChosasakiTelNo
     * @param txtChosasakiTelNo txtChosasakiTelNo
     */
    @JsonProperty("txtChosasakiTelNo")
    public void setTxtChosasakiTelNo(TextBoxTelNo txtChosasakiTelNo) {
        this.txtChosasakiTelNo = txtChosasakiTelNo;
    }

    // </editor-fold>
}
