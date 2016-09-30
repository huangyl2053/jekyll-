package jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.ServiceRiyohyoInfo;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGrid;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * ServiceRiyohyoBeppyoList のクラスファイル
 *
 * @reamsid_L DBC-1930-050 cuilin
 */
public class ServiceRiyohyoBeppyoListDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
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
    /*
     * getbtnBeppyoMeisaiNew
     * @return btnBeppyoMeisaiNew
     */
    @JsonProperty("btnBeppyoMeisaiNew")
    public Button getBtnBeppyoMeisaiNew() {
        return btnBeppyoMeisaiNew;
    }

    /*
     * setbtnBeppyoMeisaiNew
     * @param btnBeppyoMeisaiNew btnBeppyoMeisaiNew
     */
    @JsonProperty("btnBeppyoMeisaiNew")
    public void setBtnBeppyoMeisaiNew(Button btnBeppyoMeisaiNew) {
        this.btnBeppyoMeisaiNew = btnBeppyoMeisaiNew;
    }

    /*
     * getbtnBeppyoGokeiNew
     * @return btnBeppyoGokeiNew
     */
    @JsonProperty("btnBeppyoGokeiNew")
    public Button getBtnBeppyoGokeiNew() {
        return btnBeppyoGokeiNew;
    }

    /*
     * setbtnBeppyoGokeiNew
     * @param btnBeppyoGokeiNew btnBeppyoGokeiNew
     */
    @JsonProperty("btnBeppyoGokeiNew")
    public void setBtnBeppyoGokeiNew(Button btnBeppyoGokeiNew) {
        this.btnBeppyoGokeiNew = btnBeppyoGokeiNew;
    }

    /*
     * getdgServiceRiyohyoBeppyoList
     * @return dgServiceRiyohyoBeppyoList
     */
    @JsonProperty("dgServiceRiyohyoBeppyoList")
    public DataGrid<dgServiceRiyohyoBeppyoList_Row> getDgServiceRiyohyoBeppyoList() {
        return dgServiceRiyohyoBeppyoList;
    }

    /*
     * setdgServiceRiyohyoBeppyoList
     * @param dgServiceRiyohyoBeppyoList dgServiceRiyohyoBeppyoList
     */
    @JsonProperty("dgServiceRiyohyoBeppyoList")
    public void setDgServiceRiyohyoBeppyoList(DataGrid<dgServiceRiyohyoBeppyoList_Row> dgServiceRiyohyoBeppyoList) {
        this.dgServiceRiyohyoBeppyoList = dgServiceRiyohyoBeppyoList;
    }

    // </editor-fold>
}
