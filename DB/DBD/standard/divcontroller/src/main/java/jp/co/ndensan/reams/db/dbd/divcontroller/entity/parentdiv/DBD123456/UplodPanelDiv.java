package jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD123456;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * UplodPanel のクラスファイル 
 * 
 * @author 自動生成
 */
public class UplodPanelDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-10-07_19-12-57">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("upload")
    private Button upload;
    @JsonProperty("TextBoxUrl")
    private TextBox TextBoxUrl;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getupload
     * @return upload
     */
    @JsonProperty("upload")
    public Button getUpload() {
        return upload;
    }

    /*
     * setupload
     * @param upload upload
     */
    @JsonProperty("upload")
    public void setUpload(Button upload) {
        this.upload = upload;
    }

    /*
     * getTextBoxUrl
     * @return TextBoxUrl
     */
    @JsonProperty("TextBoxUrl")
    public TextBox getTextBoxUrl() {
        return TextBoxUrl;
    }

    /*
     * setTextBoxUrl
     * @param TextBoxUrl TextBoxUrl
     */
    @JsonProperty("TextBoxUrl")
    public void setTextBoxUrl(TextBox TextBoxUrl) {
        this.TextBoxUrl = TextBoxUrl;
    }

    // </editor-fold>
}
