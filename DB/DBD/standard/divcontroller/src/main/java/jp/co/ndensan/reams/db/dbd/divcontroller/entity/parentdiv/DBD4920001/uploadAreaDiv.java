package jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD4920001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * uploadArea のクラスファイル 
 * 
 * @author 自動生成
 */
public class uploadAreaDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("UploadTool")
    private UploadPanel UploadTool;
    @JsonProperty("BtnDataInput")
    private Button BtnDataInput;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getUploadTool
     * @return UploadTool
     */
    @JsonProperty("UploadTool")
    public UploadPanel getUploadTool() {
        return UploadTool;
    }

    /*
     * setUploadTool
     * @param UploadTool UploadTool
     */
    @JsonProperty("UploadTool")
    public void setUploadTool(UploadPanel UploadTool) {
        this.UploadTool = UploadTool;
    }

    /*
     * getBtnDataInput
     * @return BtnDataInput
     */
    @JsonProperty("BtnDataInput")
    public Button getBtnDataInput() {
        return BtnDataInput;
    }

    /*
     * setBtnDataInput
     * @param BtnDataInput BtnDataInput
     */
    @JsonProperty("BtnDataInput")
    public void setBtnDataInput(Button BtnDataInput) {
        this.BtnDataInput = BtnDataInput;
    }

    // </editor-fold>
}
