package jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD5130001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * ZenkaiShinseiNaiyo のクラスファイル 
 * 
 * @author 自動生成
 */
public class ZenkaiShinseiNaiyoDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-06-27_21-36-36">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtZenkaiShinseiDate")
    private TextBoxDate txtZenkaiShinseiDate;
    @JsonProperty("txtShinseiKubunShinseiji")
    private TextBox txtShinseiKubunShinseiji;
    @JsonProperty("txtShinseiKubunHorei")
    private TextBox txtShinseiKubunHorei;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtZenkaiShinseiDate
     * @return txtZenkaiShinseiDate
     */
    @JsonProperty("txtZenkaiShinseiDate")
    public TextBoxDate getTxtZenkaiShinseiDate() {
        return txtZenkaiShinseiDate;
    }

    /*
     * settxtZenkaiShinseiDate
     * @param txtZenkaiShinseiDate txtZenkaiShinseiDate
     */
    @JsonProperty("txtZenkaiShinseiDate")
    public void setTxtZenkaiShinseiDate(TextBoxDate txtZenkaiShinseiDate) {
        this.txtZenkaiShinseiDate = txtZenkaiShinseiDate;
    }

    /*
     * gettxtShinseiKubunShinseiji
     * @return txtShinseiKubunShinseiji
     */
    @JsonProperty("txtShinseiKubunShinseiji")
    public TextBox getTxtShinseiKubunShinseiji() {
        return txtShinseiKubunShinseiji;
    }

    /*
     * settxtShinseiKubunShinseiji
     * @param txtShinseiKubunShinseiji txtShinseiKubunShinseiji
     */
    @JsonProperty("txtShinseiKubunShinseiji")
    public void setTxtShinseiKubunShinseiji(TextBox txtShinseiKubunShinseiji) {
        this.txtShinseiKubunShinseiji = txtShinseiKubunShinseiji;
    }

    /*
     * gettxtShinseiKubunHorei
     * @return txtShinseiKubunHorei
     */
    @JsonProperty("txtShinseiKubunHorei")
    public TextBox getTxtShinseiKubunHorei() {
        return txtShinseiKubunHorei;
    }

    /*
     * settxtShinseiKubunHorei
     * @param txtShinseiKubunHorei txtShinseiKubunHorei
     */
    @JsonProperty("txtShinseiKubunHorei")
    public void setTxtShinseiKubunHorei(TextBox txtShinseiKubunHorei) {
        this.txtShinseiKubunHorei = txtShinseiKubunHorei;
    }

    // </editor-fold>
}
