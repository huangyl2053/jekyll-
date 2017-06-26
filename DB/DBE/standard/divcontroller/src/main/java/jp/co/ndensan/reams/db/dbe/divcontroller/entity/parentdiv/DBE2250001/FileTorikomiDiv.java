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
 * FileTorikomi のクラスファイル 
 * 
 * @author 自動生成
 */
public class FileTorikomiDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2017-03-02_13-24-25">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("radIchijiHanteiZumi")
    private RadioButton radIchijiHanteiZumi;
    @JsonProperty("uplFileTorikomi")
    private UploadPanel uplFileTorikomi;
    @JsonProperty("btnUpload")
    private Button btnUpload;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getradIchijiHanteiZumi
     * @return radIchijiHanteiZumi
     */
    @JsonProperty("radIchijiHanteiZumi")
    public RadioButton getRadIchijiHanteiZumi() {
        return radIchijiHanteiZumi;
    }

    /*
     * setradIchijiHanteiZumi
     * @param radIchijiHanteiZumi radIchijiHanteiZumi
     */
    @JsonProperty("radIchijiHanteiZumi")
    public void setRadIchijiHanteiZumi(RadioButton radIchijiHanteiZumi) {
        this.radIchijiHanteiZumi = radIchijiHanteiZumi;
    }

    /*
     * getuplFileTorikomi
     * @return uplFileTorikomi
     */
    @JsonProperty("uplFileTorikomi")
    public UploadPanel getUplFileTorikomi() {
        return uplFileTorikomi;
    }

    /*
     * setuplFileTorikomi
     * @param uplFileTorikomi uplFileTorikomi
     */
    @JsonProperty("uplFileTorikomi")
    public void setUplFileTorikomi(UploadPanel uplFileTorikomi) {
        this.uplFileTorikomi = uplFileTorikomi;
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
