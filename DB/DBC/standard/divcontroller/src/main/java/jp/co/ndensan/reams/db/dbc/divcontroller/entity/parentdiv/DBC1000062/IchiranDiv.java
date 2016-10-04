package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1000062;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.kaigoatenainfo.KaigoAtenaInfo.IKaigoAtenaInfoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.kaigoatenainfo.KaigoAtenaInfo.KaigoAtenaInfoDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGrid;
import jp.co.ndensan.reams.uz.uza.ui.binding.HorizontalLine;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * Ichiran のクラスファイル
 *
 * @reamsid_L DBC-4620-010 wangkanglei
 */
public class IchiranDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("lin1")
    private HorizontalLine lin1;
    @JsonProperty("btnAddIchiran")
    private Button btnAddIchiran;
    @JsonProperty("dgIchiran")
    private DataGrid<dgIchiran_Row> dgIchiran;
    @JsonProperty("ccdKaigoAtenaInfo")
    private KaigoAtenaInfoDiv ccdKaigoAtenaInfo;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getlin1
     * @return lin1
     */
    @JsonProperty("lin1")
    public HorizontalLine getLin1() {
        return lin1;
    }

    /*
     * setlin1
     * @param lin1 lin1
     */
    @JsonProperty("lin1")
    public void setLin1(HorizontalLine lin1) {
        this.lin1 = lin1;
    }

    /*
     * getbtnAddIchiran
     * @return btnAddIchiran
     */
    @JsonProperty("btnAddIchiran")
    public Button getBtnAddIchiran() {
        return btnAddIchiran;
    }

    /*
     * setbtnAddIchiran
     * @param btnAddIchiran btnAddIchiran
     */
    @JsonProperty("btnAddIchiran")
    public void setBtnAddIchiran(Button btnAddIchiran) {
        this.btnAddIchiran = btnAddIchiran;
    }

    /*
     * getdgIchiran
     * @return dgIchiran
     */
    @JsonProperty("dgIchiran")
    public DataGrid<dgIchiran_Row> getDgIchiran() {
        return dgIchiran;
    }

    /*
     * setdgIchiran
     * @param dgIchiran dgIchiran
     */
    @JsonProperty("dgIchiran")
    public void setDgIchiran(DataGrid<dgIchiran_Row> dgIchiran) {
        this.dgIchiran = dgIchiran;
    }

    /*
     * getccdKaigoAtenaInfo
     * @return ccdKaigoAtenaInfo
     */
    @JsonProperty("ccdKaigoAtenaInfo")
    public IKaigoAtenaInfoDiv getCcdKaigoAtenaInfo() {
        return ccdKaigoAtenaInfo;
    }

    // </editor-fold>
}
