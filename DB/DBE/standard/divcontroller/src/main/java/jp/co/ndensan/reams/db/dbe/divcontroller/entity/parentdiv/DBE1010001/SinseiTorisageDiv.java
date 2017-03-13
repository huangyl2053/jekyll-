package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE1010001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * SinseiTorisage のクラスファイル 
 * 
 * @author 自動生成
 */
public class SinseiTorisageDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2017-02-23_06-32-36">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ddlTorisageJiyu")
    private DropDownList ddlTorisageJiyu;
    @JsonProperty("txtTorisageDate")
    private TextBoxDate txtTorisageDate;
    @JsonProperty("txtTorisageJiyu")
    private TextBox txtTorisageJiyu;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getddlTorisageJiyu
     * @return ddlTorisageJiyu
     */
    @JsonProperty("ddlTorisageJiyu")
    public DropDownList getDdlTorisageJiyu() {
        return ddlTorisageJiyu;
    }

    /*
     * setddlTorisageJiyu
     * @param ddlTorisageJiyu ddlTorisageJiyu
     */
    @JsonProperty("ddlTorisageJiyu")
    public void setDdlTorisageJiyu(DropDownList ddlTorisageJiyu) {
        this.ddlTorisageJiyu = ddlTorisageJiyu;
    }

    /*
     * gettxtTorisageDate
     * @return txtTorisageDate
     */
    @JsonProperty("txtTorisageDate")
    public TextBoxDate getTxtTorisageDate() {
        return txtTorisageDate;
    }

    /*
     * settxtTorisageDate
     * @param txtTorisageDate txtTorisageDate
     */
    @JsonProperty("txtTorisageDate")
    public void setTxtTorisageDate(TextBoxDate txtTorisageDate) {
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
