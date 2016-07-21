package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5090001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * txtShinseiNintei のクラスファイル 
 * 
 * @author 自動生成
 */
public class txtShinseiNinteiDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtShinseiYMD")
    private TextBoxDateRange txtShinseiYMD;
    @JsonProperty("NinteiYMD")
    private TextBoxDateRange NinteiYMD;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtShinseiYMD
     * @return txtShinseiYMD
     */
    @JsonProperty("txtShinseiYMD")
    public TextBoxDateRange getTxtShinseiYMD() {
        return txtShinseiYMD;
    }

    /*
     * settxtShinseiYMD
     * @param txtShinseiYMD txtShinseiYMD
     */
    @JsonProperty("txtShinseiYMD")
    public void setTxtShinseiYMD(TextBoxDateRange txtShinseiYMD) {
        this.txtShinseiYMD = txtShinseiYMD;
    }

    /*
     * getNinteiYMD
     * @return NinteiYMD
     */
    @JsonProperty("NinteiYMD")
    public TextBoxDateRange getNinteiYMD() {
        return NinteiYMD;
    }

    /*
     * setNinteiYMD
     * @param NinteiYMD NinteiYMD
     */
    @JsonProperty("NinteiYMD")
    public void setNinteiYMD(TextBoxDateRange NinteiYMD) {
        this.NinteiYMD = NinteiYMD;
    }

    // </editor-fold>
}
