package jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0020041;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * hihokenshabango のクラスファイル 
 * 
 * @author 自動生成
 */
public class hihokenshabangoDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2015-11-16_12-38-19">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txthokokuYM")
    private TextBoxFlexibleDate txthokokuYM;
    @JsonProperty("txtShukeiYM")
    private TextBoxFlexibleDate txtShukeiYM;
    @JsonProperty("txtHihokenshabango")
    private TextBoxCode txtHihokenshabango;
    @JsonProperty("txthihokenshamei")
    private TextBox txthihokenshamei;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxthokokuYM
     * @return txthokokuYM
     */
    @JsonProperty("txthokokuYM")
    public TextBoxFlexibleDate getTxthokokuYM() {
        return txthokokuYM;
    }

    /*
     * settxthokokuYM
     * @param txthokokuYM txthokokuYM
     */
    @JsonProperty("txthokokuYM")
    public void setTxthokokuYM(TextBoxFlexibleDate txthokokuYM) {
        this.txthokokuYM = txthokokuYM;
    }

    /*
     * gettxtShukeiYM
     * @return txtShukeiYM
     */
    @JsonProperty("txtShukeiYM")
    public TextBoxFlexibleDate getTxtShukeiYM() {
        return txtShukeiYM;
    }

    /*
     * settxtShukeiYM
     * @param txtShukeiYM txtShukeiYM
     */
    @JsonProperty("txtShukeiYM")
    public void setTxtShukeiYM(TextBoxFlexibleDate txtShukeiYM) {
        this.txtShukeiYM = txtShukeiYM;
    }

    /*
     * gettxtHihokenshabango
     * @return txtHihokenshabango
     */
    @JsonProperty("txtHihokenshabango")
    public TextBoxCode getTxtHihokenshabango() {
        return txtHihokenshabango;
    }

    /*
     * settxtHihokenshabango
     * @param txtHihokenshabango txtHihokenshabango
     */
    @JsonProperty("txtHihokenshabango")
    public void setTxtHihokenshabango(TextBoxCode txtHihokenshabango) {
        this.txtHihokenshabango = txtHihokenshabango;
    }

    /*
     * gettxthihokenshamei
     * @return txthihokenshamei
     */
    @JsonProperty("txthihokenshamei")
    public TextBox getTxthihokenshamei() {
        return txthihokenshamei;
    }

    /*
     * settxthihokenshamei
     * @param txthihokenshamei txthihokenshamei
     */
    @JsonProperty("txthihokenshamei")
    public void setTxthihokenshamei(TextBox txthihokenshamei) {
        this.txthihokenshamei = txthihokenshamei;
    }

    // </editor-fold>
}
