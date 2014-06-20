package jp.co.ndensan.reams.db.dbc.divcontroller.entity.ServiceRiyohyoInfo;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.ServiceRiyohyoInfo.dgServiceRiyohyoBeppyoList_Row;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * ServiceRiyohyoBeppyoList のクラスファイル 
 * 
 * @author 自動生成
 */
public class ServiceRiyohyoBeppyoListDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("btnBeppyoMeisaiNew")
    private Button btnBeppyoMeisaiNew;
    @JsonProperty("btnBeppyoGokeiNew")
    private Button btnBeppyoGokeiNew;
    @JsonProperty("dgServiceRiyohyoBeppyoList")
    private DataGrid<dgServiceRiyohyoBeppyoList_Row> dgServiceRiyohyoBeppyoList;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("btnBeppyoMeisaiNew")
    public Button getBtnBeppyoMeisaiNew() {
        return btnBeppyoMeisaiNew;
    }

    @JsonProperty("btnBeppyoMeisaiNew")
    public void setBtnBeppyoMeisaiNew(Button btnBeppyoMeisaiNew) {
        this.btnBeppyoMeisaiNew=btnBeppyoMeisaiNew;
    }

    @JsonProperty("btnBeppyoGokeiNew")
    public Button getBtnBeppyoGokeiNew() {
        return btnBeppyoGokeiNew;
    }

    @JsonProperty("btnBeppyoGokeiNew")
    public void setBtnBeppyoGokeiNew(Button btnBeppyoGokeiNew) {
        this.btnBeppyoGokeiNew=btnBeppyoGokeiNew;
    }

    @JsonProperty("dgServiceRiyohyoBeppyoList")
    public DataGrid<dgServiceRiyohyoBeppyoList_Row> getDgServiceRiyohyoBeppyoList() {
        return dgServiceRiyohyoBeppyoList;
    }

    @JsonProperty("dgServiceRiyohyoBeppyoList")
    public void setDgServiceRiyohyoBeppyoList(DataGrid<dgServiceRiyohyoBeppyoList_Row> dgServiceRiyohyoBeppyoList) {
        this.dgServiceRiyohyoBeppyoList=dgServiceRiyohyoBeppyoList;
    }

}
