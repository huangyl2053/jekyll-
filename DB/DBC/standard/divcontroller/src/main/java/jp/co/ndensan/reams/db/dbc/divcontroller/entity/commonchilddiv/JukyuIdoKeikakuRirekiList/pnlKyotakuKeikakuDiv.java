package jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.JukyuIdoKeikakuRirekiList;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * pnlKyotakuKeikaku のクラスファイル 
 * 
 * @author 自動生成
 */
public class pnlKyotakuKeikakuDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-07-28_11-34-20">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("dgKyotakuKeikaku")
    private DataGrid<dgKyotakuKeikaku_Row> dgKyotakuKeikaku;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getdgKyotakuKeikaku
     * @return dgKyotakuKeikaku
     */
    @JsonProperty("dgKyotakuKeikaku")
    public DataGrid<dgKyotakuKeikaku_Row> getDgKyotakuKeikaku() {
        return dgKyotakuKeikaku;
    }

    /*
     * setdgKyotakuKeikaku
     * @param dgKyotakuKeikaku dgKyotakuKeikaku
     */
    @JsonProperty("dgKyotakuKeikaku")
    public void setDgKyotakuKeikaku(DataGrid<dgKyotakuKeikaku_Row> dgKyotakuKeikaku) {
        this.dgKyotakuKeikaku = dgKyotakuKeikaku;
    }

    // </editor-fold>
}
