package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5200001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * JizenShinsaKekkaTorikomi のクラスファイル 
 * 
 * @author 自動生成
 */
public class JizenShinsaKekkaTorikomiDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2017-02-23_13-41-30">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("uplJizanShinsaKekka")
    private UploadPanel uplJizanShinsaKekka;
    @JsonProperty("btnGetResult")
    private Button btnGetResult;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getuplJizanShinsaKekka
     * @return uplJizanShinsaKekka
     */
    @JsonProperty("uplJizanShinsaKekka")
    public UploadPanel getUplJizanShinsaKekka() {
        return uplJizanShinsaKekka;
    }

    /*
     * setuplJizanShinsaKekka
     * @param uplJizanShinsaKekka uplJizanShinsaKekka
     */
    @JsonProperty("uplJizanShinsaKekka")
    public void setUplJizanShinsaKekka(UploadPanel uplJizanShinsaKekka) {
        this.uplJizanShinsaKekka = uplJizanShinsaKekka;
    }

    /*
     * getbtnGetResult
     * @return btnGetResult
     */
    @JsonProperty("btnGetResult")
    public Button getBtnGetResult() {
        return btnGetResult;
    }

    /*
     * setbtnGetResult
     * @param btnGetResult btnGetResult
     */
    @JsonProperty("btnGetResult")
    public void setBtnGetResult(Button btnGetResult) {
        this.btnGetResult = btnGetResult;
    }

    // </editor-fold>
}
