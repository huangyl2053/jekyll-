package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.kaigotoiawasesaki.KaigoToiawasesaki;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * Detail1 のクラスファイル 
 * 
 * @author 自動生成
 */
public class Detail1Div extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：バージョン情報無し">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtYubinNo")
    private TextBoxYubinNo txtYubinNo;
    @JsonProperty("txtShozaichi")
    private TextBoxMultiLine txtShozaichi;
    @JsonProperty("txtChoshaName")
    private TextBox txtChoshaName;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
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
     * gettxtShozaichi
     * @return txtShozaichi
     */
    @JsonProperty("txtShozaichi")
    public TextBoxMultiLine getTxtShozaichi() {
        return txtShozaichi;
    }

    /*
     * settxtShozaichi
     * @param txtShozaichi txtShozaichi
     */
    @JsonProperty("txtShozaichi")
    public void setTxtShozaichi(TextBoxMultiLine txtShozaichi) {
        this.txtShozaichi = txtShozaichi;
    }

    /*
     * gettxtChoshaName
     * @return txtChoshaName
     */
    @JsonProperty("txtChoshaName")
    public TextBox getTxtChoshaName() {
        return txtChoshaName;
    }

    /*
     * settxtChoshaName
     * @param txtChoshaName txtChoshaName
     */
    @JsonProperty("txtChoshaName")
    public void setTxtChoshaName(TextBox txtChoshaName) {
        this.txtChoshaName = txtChoshaName;
    }

    // </editor-fold>
}
