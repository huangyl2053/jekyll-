package jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB1120003;
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
 * UploadPanel のクラスファイル
 *
 * 画面設計_DBBGM51005_所得情報アップロード
 *
 * @reamsid_L DBB-1730-010 yangchenbing
 */
public class UploadPanelDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ccdUpload")
    private UploadPanel ccdUpload;
    @JsonProperty("btnUpload")
    private Button btnUpload;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getccdUpload
     * @return ccdUpload
     */
    @JsonProperty("ccdUpload")
    public UploadPanel getCcdUpload() {
        return ccdUpload;
    }

    /*
     * setccdUpload
     * @param ccdUpload ccdUpload
     */
    @JsonProperty("ccdUpload")
    public void setCcdUpload(UploadPanel ccdUpload) {
        this.ccdUpload = ccdUpload;
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
