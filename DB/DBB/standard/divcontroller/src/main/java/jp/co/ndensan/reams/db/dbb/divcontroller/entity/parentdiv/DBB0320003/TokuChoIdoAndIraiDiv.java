package jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB0320003;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * TokuChoIdoAndIrai のクラスファイル 
 * 
 * @author 自動生成
 */
public class TokuChoIdoAndIraiDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：Uz-master-63">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("dgTokuChoIdoAndIrai")
    private DataGrid<dgTokuChoIdoAndIrai_Row> dgTokuChoIdoAndIrai;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getdgTokuChoIdoAndIrai
     * @return dgTokuChoIdoAndIrai
     */
    @JsonProperty("dgTokuChoIdoAndIrai")
    public DataGrid<dgTokuChoIdoAndIrai_Row> getDgTokuChoIdoAndIrai() {
        return dgTokuChoIdoAndIrai;
    }

    /*
     * setdgTokuChoIdoAndIrai
     * @param dgTokuChoIdoAndIrai dgTokuChoIdoAndIrai
     */
    @JsonProperty("dgTokuChoIdoAndIrai")
    public void setDgTokuChoIdoAndIrai(DataGrid<dgTokuChoIdoAndIrai_Row> dgTokuChoIdoAndIrai) {
        this.dgTokuChoIdoAndIrai = dgTokuChoIdoAndIrai;
    }

    // </editor-fold>
}
