package jp.co.ndensan.reams.db.dbe.divcontroller.entity.commonchilddiv.ChosaKekkaInfoGaikyo;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * ServiceJokyoPanel のクラスファイル 
 * 
 * @author 自動生成
 */
public class ServiceJokyoPanelDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("dgServiceJokyo")
    private DataGrid<dgServiceJokyo_Row> dgServiceJokyo;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getdgServiceJokyo
     * @return dgServiceJokyo
     */
    @JsonProperty("dgServiceJokyo")
    public DataGrid<dgServiceJokyo_Row> getDgServiceJokyo() {
        return dgServiceJokyo;
    }

    /*
     * setdgServiceJokyo
     * @param dgServiceJokyo dgServiceJokyo
     */
    @JsonProperty("dgServiceJokyo")
    public void setDgServiceJokyo(DataGrid<dgServiceJokyo_Row> dgServiceJokyo) {
        this.dgServiceJokyo = dgServiceJokyo;
    }

    // </editor-fold>
}
