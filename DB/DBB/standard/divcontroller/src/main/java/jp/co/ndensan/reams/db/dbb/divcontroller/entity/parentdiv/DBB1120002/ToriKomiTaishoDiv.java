package jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB1120002;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.UploadPanel;

/**
 * ToriKomiTaisho のクラスファイル
 *
 * @reamsid_L DBB-1690-030 sunhui
 */
public class ToriKomiTaishoDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("uplUpload")
    private UploadPanel uplUpload;
    @JsonProperty("btnUpload")
    private Button btnUpload;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getuplUpload
     * @return uplUpload
     */
    @JsonProperty("uplUpload")
    public UploadPanel getUplUpload() {
        return uplUpload;
    }

    /*
     * setuplUpload
     * @param uplUpload uplUpload
     */
    @JsonProperty("uplUpload")
    public void setUplUpload(UploadPanel uplUpload) {
        this.uplUpload = uplUpload;
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
