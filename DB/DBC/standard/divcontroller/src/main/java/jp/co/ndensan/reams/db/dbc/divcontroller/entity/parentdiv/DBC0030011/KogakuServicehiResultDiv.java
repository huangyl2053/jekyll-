package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0030011;
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
 * KogakuServicehiResult のクラスファイル
 *
 * @reamsid_L DBC-3000-010 gongliang
 */
public class KogakuServicehiResultDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("dgKogakuServicehiRireki")
    private DataGrid<dgKogakuServicehiRireki_Row> dgKogakuServicehiRireki;
    @JsonProperty("btnResearch")
    private Button btnResearch;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getdgKogakuServicehiRireki
     * @return dgKogakuServicehiRireki
     */
    @JsonProperty("dgKogakuServicehiRireki")
    public DataGrid<dgKogakuServicehiRireki_Row> getDgKogakuServicehiRireki() {
        return dgKogakuServicehiRireki;
    }

    /*
     * setdgKogakuServicehiRireki
     * @param dgKogakuServicehiRireki dgKogakuServicehiRireki
     */
    @JsonProperty("dgKogakuServicehiRireki")
    public void setDgKogakuServicehiRireki(DataGrid<dgKogakuServicehiRireki_Row> dgKogakuServicehiRireki) {
        this.dgKogakuServicehiRireki = dgKogakuServicehiRireki;
    }

    /*
     * getbtnResearch
     * @return btnResearch
     */
    @JsonProperty("btnResearch")
    public Button getBtnResearch() {
        return btnResearch;
    }

    /*
     * setbtnResearch
     * @param btnResearch btnResearch
     */
    @JsonProperty("btnResearch")
    public void setBtnResearch(Button btnResearch) {
        this.btnResearch = btnResearch;
    }

    // </editor-fold>
}
