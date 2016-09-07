package jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB0130001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * Heijunka8KeisanHohoPanel のクラスファイル 
 * 
 * @author 自動生成
 */
public class Heijunka8KeisanHohoPanelDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtKeisanHohoZougaku")
    private TextBox txtKeisanHohoZougaku;
    @JsonProperty("txtKeisanHohoGengaku")
    private TextBox txtKeisanHohoGengaku;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtKeisanHohoZougaku
     * @return txtKeisanHohoZougaku
     */
    @JsonProperty("txtKeisanHohoZougaku")
    public TextBox getTxtKeisanHohoZougaku() {
        return txtKeisanHohoZougaku;
    }

    /*
     * settxtKeisanHohoZougaku
     * @param txtKeisanHohoZougaku txtKeisanHohoZougaku
     */
    @JsonProperty("txtKeisanHohoZougaku")
    public void setTxtKeisanHohoZougaku(TextBox txtKeisanHohoZougaku) {
        this.txtKeisanHohoZougaku = txtKeisanHohoZougaku;
    }

    /*
     * gettxtKeisanHohoGengaku
     * @return txtKeisanHohoGengaku
     */
    @JsonProperty("txtKeisanHohoGengaku")
    public TextBox getTxtKeisanHohoGengaku() {
        return txtKeisanHohoGengaku;
    }

    /*
     * settxtKeisanHohoGengaku
     * @param txtKeisanHohoGengaku txtKeisanHohoGengaku
     */
    @JsonProperty("txtKeisanHohoGengaku")
    public void setTxtKeisanHohoGengaku(TextBox txtKeisanHohoGengaku) {
        this.txtKeisanHohoGengaku = txtKeisanHohoGengaku;
    }

    // </editor-fold>
}
