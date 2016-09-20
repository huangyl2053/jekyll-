package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1140011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.CheckBoxList;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGrid;
import jp.co.ndensan.reams.uz.uza.ui.binding.HorizontalLine;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * JikoFutangakuHoseiList のクラスファイル
 *
 * @reamsid_L DBC-2080-010 jiangzongyue
 */
public class JikoFutangakuHoseiListDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-07-28_11-34-20">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("linLine1")
    private HorizontalLine linLine1;
    @JsonProperty("chkRirekiHyouji")
    private CheckBoxList chkRirekiHyouji;
    @JsonProperty("dgJohoIchiran")
    private DataGrid<dgJohoIchiran_Row> dgJohoIchiran;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getlinLine1
     * @return linLine1
     */
    @JsonProperty("linLine1")
    public HorizontalLine getLinLine1() {
        return linLine1;
    }

    /*
     * setlinLine1
     * @param linLine1 linLine1
     */
    @JsonProperty("linLine1")
    public void setLinLine1(HorizontalLine linLine1) {
        this.linLine1 = linLine1;
    }

    /*
     * getchkRirekiHyouji
     * @return chkRirekiHyouji
     */
    @JsonProperty("chkRirekiHyouji")
    public CheckBoxList getChkRirekiHyouji() {
        return chkRirekiHyouji;
    }

    /*
     * setchkRirekiHyouji
     * @param chkRirekiHyouji chkRirekiHyouji
     */
    @JsonProperty("chkRirekiHyouji")
    public void setChkRirekiHyouji(CheckBoxList chkRirekiHyouji) {
        this.chkRirekiHyouji = chkRirekiHyouji;
    }

    /*
     * getdgJohoIchiran
     * @return dgJohoIchiran
     */
    @JsonProperty("dgJohoIchiran")
    public DataGrid<dgJohoIchiran_Row> getDgJohoIchiran() {
        return dgJohoIchiran;
    }

    /*
     * setdgJohoIchiran
     * @param dgJohoIchiran dgJohoIchiran
     */
    @JsonProperty("dgJohoIchiran")
    public void setDgJohoIchiran(DataGrid<dgJohoIchiran_Row> dgJohoIchiran) {
        this.dgJohoIchiran = dgJohoIchiran;
    }

    // </editor-fold>
}
