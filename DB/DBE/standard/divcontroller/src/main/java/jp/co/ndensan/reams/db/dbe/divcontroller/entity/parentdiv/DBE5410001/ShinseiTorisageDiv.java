package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5410001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * ShinseiTorisage のクラスファイル 
 * 
 * @author 自動生成
 */
public class ShinseiTorisageDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2017-02-23_06-32-36">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtTorisageJiyuCode")
    private TextBox txtTorisageJiyuCode;
    @JsonProperty("txtTorisageDate")
    private TextBoxFlexibleDate txtTorisageDate;
    @JsonProperty("txtTorisageJiyu")
    private TextBox txtTorisageJiyu;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtTorisageJiyuCode
     * @return txtTorisageJiyuCode
     */
    @JsonProperty("txtTorisageJiyuCode")
    public TextBox getTxtTorisageJiyuCode() {
        return txtTorisageJiyuCode;
    }

    /*
     * settxtTorisageJiyuCode
     * @param txtTorisageJiyuCode txtTorisageJiyuCode
     */
    @JsonProperty("txtTorisageJiyuCode")
    public void setTxtTorisageJiyuCode(TextBox txtTorisageJiyuCode) {
        this.txtTorisageJiyuCode = txtTorisageJiyuCode;
    }

    /*
     * gettxtTorisageDate
     * @return txtTorisageDate
     */
    @JsonProperty("txtTorisageDate")
    public TextBoxFlexibleDate getTxtTorisageDate() {
        return txtTorisageDate;
    }

    /*
     * settxtTorisageDate
     * @param txtTorisageDate txtTorisageDate
     */
    @JsonProperty("txtTorisageDate")
    public void setTxtTorisageDate(TextBoxFlexibleDate txtTorisageDate) {
        this.txtTorisageDate = txtTorisageDate;
    }

    /*
     * gettxtTorisageJiyu
     * @return txtTorisageJiyu
     */
    @JsonProperty("txtTorisageJiyu")
    public TextBox getTxtTorisageJiyu() {
        return txtTorisageJiyu;
    }

    /*
     * settxtTorisageJiyu
     * @param txtTorisageJiyu txtTorisageJiyu
     */
    @JsonProperty("txtTorisageJiyu")
    public void setTxtTorisageJiyu(TextBox txtTorisageJiyu) {
        this.txtTorisageJiyu = txtTorisageJiyu;
    }

    // </editor-fold>
}
