package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.kaigotoiawasesaki.KaigoToiawasesaki;
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
 * Detail2 のクラスファイル 
 * 
 * @author 自動生成
 */
public class Detail2Div extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：バージョン情報無し">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtTelNo")
    private TextBoxTelNo txtTelNo;
    @JsonProperty("txtNaisenNo")
    private TextBox txtNaisenNo;
    @JsonProperty("txtBushoName")
    private TextBoxMultiLine txtBushoName;
    @JsonProperty("txtTantoshaName")
    private TextBox txtTantoshaName;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
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
     * gettxtNaisenNo
     * @return txtNaisenNo
     */
    @JsonProperty("txtNaisenNo")
    public TextBox getTxtNaisenNo() {
        return txtNaisenNo;
    }

    /*
     * settxtNaisenNo
     * @param txtNaisenNo txtNaisenNo
     */
    @JsonProperty("txtNaisenNo")
    public void setTxtNaisenNo(TextBox txtNaisenNo) {
        this.txtNaisenNo = txtNaisenNo;
    }

    /*
     * gettxtBushoName
     * @return txtBushoName
     */
    @JsonProperty("txtBushoName")
    public TextBoxMultiLine getTxtBushoName() {
        return txtBushoName;
    }

    /*
     * settxtBushoName
     * @param txtBushoName txtBushoName
     */
    @JsonProperty("txtBushoName")
    public void setTxtBushoName(TextBoxMultiLine txtBushoName) {
        this.txtBushoName = txtBushoName;
    }

    /*
     * gettxtTantoshaName
     * @return txtTantoshaName
     */
    @JsonProperty("txtTantoshaName")
    public TextBox getTxtTantoshaName() {
        return txtTantoshaName;
    }

    /*
     * settxtTantoshaName
     * @param txtTantoshaName txtTantoshaName
     */
    @JsonProperty("txtTantoshaName")
    public void setTxtTantoshaName(TextBox txtTantoshaName) {
        this.txtTantoshaName = txtTantoshaName;
    }

    // </editor-fold>
}
