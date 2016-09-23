package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1140011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * dgJohoIchiranPanel のクラスファイル 
 * 
 * @author 自動生成
 */
public class dgJohoIchiranPanelDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
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
