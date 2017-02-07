package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2240001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * NinteiChosaOCRTorikomiFile のクラスファイル 
 * 
 * @author 自動生成
 */
public class NinteiChosaOCRTorikomiFileDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：Uz-master-47">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("uplOCRData")
    private UploadPanel uplOCRData;
    @JsonProperty("btnUpload")
    private Button btnUpload;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getuplOCRData
     * @return uplOCRData
     */
    @JsonProperty("uplOCRData")
    public UploadPanel getUplOCRData() {
        return uplOCRData;
    }

    /*
     * setuplOCRData
     * @param uplOCRData uplOCRData
     */
    @JsonProperty("uplOCRData")
    public void setUplOCRData(UploadPanel uplOCRData) {
        this.uplOCRData = uplOCRData;
    }

    /*
     * getbtnUpload
     * @return btnUpload
     */
    @JsonProperty("btnUpload")
    public Button getBtnUpload() {
        return btnUpload;
    }

    /*
     * setbtnUpload
     * @param btnUpload btnUpload
     */
    @JsonProperty("btnUpload")
    public void setBtnUpload(Button btnUpload) {
        this.btnUpload = btnUpload;
    }

    // </editor-fold>
}
