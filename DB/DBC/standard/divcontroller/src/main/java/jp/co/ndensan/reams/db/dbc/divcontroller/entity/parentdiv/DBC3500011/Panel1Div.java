package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC3500011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * Panel1 のクラスファイル 
 * 
 * @author 自動生成
 */
public class Panel1Div extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-07-28_11-34-20">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("UploadPanel1")
    private UploadPanel UploadPanel1;
    @JsonProperty("Button1")
    private Button Button1;
    @JsonProperty("Button2")
    private Button Button2;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getUploadPanel1
     * @return UploadPanel1
     */
    @JsonProperty("UploadPanel1")
    public UploadPanel getUploadPanel1() {
        return UploadPanel1;
    }

    /*
     * setUploadPanel1
     * @param UploadPanel1 UploadPanel1
     */
    @JsonProperty("UploadPanel1")
    public void setUploadPanel1(UploadPanel UploadPanel1) {
        this.UploadPanel1 = UploadPanel1;
    }

    /*
     * getButton1
     * @return Button1
     */
    @JsonProperty("Button1")
    public Button getButton1() {
        return Button1;
    }

    /*
     * setButton1
     * @param Button1 Button1
     */
    @JsonProperty("Button1")
    public void setButton1(Button Button1) {
        this.Button1 = Button1;
    }

    /*
     * getButton2
     * @return Button2
     */
    @JsonProperty("Button2")
    public Button getButton2() {
        return Button2;
    }

    /*
     * setButton2
     * @param Button2 Button2
     */
    @JsonProperty("Button2")
    public void setButton2(Button Button2) {
        this.Button2 = Button2;
    }

    // </editor-fold>
}
