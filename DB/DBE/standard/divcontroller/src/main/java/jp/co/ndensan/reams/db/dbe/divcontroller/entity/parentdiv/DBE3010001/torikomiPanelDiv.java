package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE3010001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * torikomiPanel のクラスファイル 
 * 
 * @author 自動生成
 */
public class torikomiPanelDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-11-04_20-51-13">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("uplHanteiKekka")
    private UploadPanel uplHanteiKekka;
    @JsonProperty("uploadButton")
    private Button uploadButton;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getuplHanteiKekka
     * @return uplHanteiKekka
     */
    @JsonProperty("uplHanteiKekka")
    public UploadPanel getUplHanteiKekka() {
        return uplHanteiKekka;
    }

    /*
     * setuplHanteiKekka
     * @param uplHanteiKekka uplHanteiKekka
     */
    @JsonProperty("uplHanteiKekka")
    public void setUplHanteiKekka(UploadPanel uplHanteiKekka) {
        this.uplHanteiKekka = uplHanteiKekka;
    }

    /*
     * getuploadButton
     * @return uploadButton
     */
    @JsonProperty("uploadButton")
    public Button getUploadButton() {
        return uploadButton;
    }

    /*
     * setuploadButton
     * @param uploadButton uploadButton
     */
    @JsonProperty("uploadButton")
    public void setUploadButton(Button uploadButton) {
        this.uploadButton = uploadButton;
    }

    // </editor-fold>
}
