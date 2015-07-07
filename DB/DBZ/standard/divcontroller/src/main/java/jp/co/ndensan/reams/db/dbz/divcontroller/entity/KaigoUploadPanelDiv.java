package jp.co.ndensan.reams.db.dbz.divcontroller.entity;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.IKaigoUploadPanelDiv;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * KaigoUploadPanel のクラスファイル 
 * 
 * @author 自動生成
 */
public class KaigoUploadPanelDiv extends Panel implements IKaigoUploadPanelDiv {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("uplUploadFile")
    private UploadPanel uplUploadFile;
    @JsonProperty("btnUpload")
    private Button btnUpload;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("uplUploadFile")
    public UploadPanel getUplUploadFile() {
        return uplUploadFile;
    }

    @JsonProperty("uplUploadFile")
    public void setUplUploadFile(UploadPanel uplUploadFile) {
        this.uplUploadFile=uplUploadFile;
    }

    @JsonProperty("btnUpload")
    public Button getBtnUpload() {
        return btnUpload;
    }

    @JsonProperty("btnUpload")
    public void setBtnUpload(Button btnUpload) {
        this.btnUpload=btnUpload;
    }

    //--------------- この行より下にコードを追加してください -------------------

}
