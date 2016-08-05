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
 * PublicationResult のクラスファイル 
 * 
 * @author 自動生成
 */
public class PublicationResultDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("DgBeforeShinsakaiResult")
    private DataGrid<DgBeforeShinsakaiResult_Row> DgBeforeShinsakaiResult;
    @JsonProperty("btnGetResult")
    private Button btnGetResult;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getDgBeforeShinsakaiResult
     * @return DgBeforeShinsakaiResult
     */
    @JsonProperty("DgBeforeShinsakaiResult")
    public DataGrid<DgBeforeShinsakaiResult_Row> getDgBeforeShinsakaiResult() {
        return DgBeforeShinsakaiResult;
    }

    /*
     * setDgBeforeShinsakaiResult
     * @param DgBeforeShinsakaiResult DgBeforeShinsakaiResult
     */
    @JsonProperty("DgBeforeShinsakaiResult")
    public void setDgBeforeShinsakaiResult(DataGrid<DgBeforeShinsakaiResult_Row> DgBeforeShinsakaiResult) {
        this.DgBeforeShinsakaiResult = DgBeforeShinsakaiResult;
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
