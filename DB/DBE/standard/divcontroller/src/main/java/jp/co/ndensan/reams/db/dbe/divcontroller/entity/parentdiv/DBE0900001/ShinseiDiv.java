package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE0900001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * Shinsei のクラスファイル 
 * 
 * @author 自動生成
 */
public class ShinseiDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-10-24_17-05-14">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtShinseibi")
    private TextBoxDate txtShinseibi;
    @JsonProperty("txtShinseiKubunShin")
    private TextBox txtShinseiKubunShin;
    @JsonProperty("txtShinseiKubun")
    private TextBox txtShinseiKubun;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtShinseibi
     * @return txtShinseibi
     */
    @JsonProperty("txtShinseibi")
    public TextBoxDate getTxtShinseibi() {
        return txtShinseibi;
    }

    /*
     * settxtShinseibi
     * @param txtShinseibi txtShinseibi
     */
    @JsonProperty("txtShinseibi")
    public void setTxtShinseibi(TextBoxDate txtShinseibi) {
        this.txtShinseibi = txtShinseibi;
    }

    /*
     * gettxtShinseiKubunShin
     * @return txtShinseiKubunShin
     */
    @JsonProperty("txtShinseiKubunShin")
    public TextBox getTxtShinseiKubunShin() {
        return txtShinseiKubunShin;
    }

    /*
     * settxtShinseiKubunShin
     * @param txtShinseiKubunShin txtShinseiKubunShin
     */
    @JsonProperty("txtShinseiKubunShin")
    public void setTxtShinseiKubunShin(TextBox txtShinseiKubunShin) {
        this.txtShinseiKubunShin = txtShinseiKubunShin;
    }

    /*
     * gettxtShinseiKubun
     * @return txtShinseiKubun
     */
    @JsonProperty("txtShinseiKubun")
    public TextBox getTxtShinseiKubun() {
        return txtShinseiKubun;
    }

    /*
     * settxtShinseiKubun
     * @param txtShinseiKubun txtShinseiKubun
     */
    @JsonProperty("txtShinseiKubun")
    public void setTxtShinseiKubun(TextBox txtShinseiKubun) {
        this.txtShinseiKubun = txtShinseiKubun;
    }

    // </editor-fold>
}
