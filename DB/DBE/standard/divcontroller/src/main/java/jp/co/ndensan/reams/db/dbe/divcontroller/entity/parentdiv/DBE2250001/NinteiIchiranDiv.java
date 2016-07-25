package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2250001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * NinteiIchiran のクラスファイル 
 * 
 * @author 自動生成
 */
public class NinteiIchiranDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtNinzu")
    private TextBox txtNinzu;
    @JsonProperty("dgNinteiChosaData")
    private DataGrid<dgNinteiChosaData_Row> dgNinteiChosaData;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtNinzu
     * @return txtNinzu
     */
    @JsonProperty("txtNinzu")
    public TextBox getTxtNinzu() {
        return txtNinzu;
    }

    /*
     * settxtNinzu
     * @param txtNinzu txtNinzu
     */
    @JsonProperty("txtNinzu")
    public void setTxtNinzu(TextBox txtNinzu) {
        this.txtNinzu = txtNinzu;
    }

    /*
     * getdgNinteiChosaData
     * @return dgNinteiChosaData
     */
    @JsonProperty("dgNinteiChosaData")
    public DataGrid<dgNinteiChosaData_Row> getDgNinteiChosaData() {
        return dgNinteiChosaData;
    }

    /*
     * setdgNinteiChosaData
     * @param dgNinteiChosaData dgNinteiChosaData
     */
    @JsonProperty("dgNinteiChosaData")
    public void setDgNinteiChosaData(DataGrid<dgNinteiChosaData_Row> dgNinteiChosaData) {
        this.dgNinteiChosaData = dgNinteiChosaData;
    }

    // </editor-fold>
}
