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
 * TokuChoKekka のクラスファイル 
 * 
 * @author 自動生成
 */
public class TokuChoKekkaDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：Uz-master-49">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("dgTokuchoKekka")
    private DataGrid<dgTokuchoKekka_Row> dgTokuchoKekka;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("dgTokuchoKekka")
    public DataGrid<dgTokuchoKekka_Row> getDgTokuchoKekka() {
        return dgTokuchoKekka;
    }

    @JsonProperty("dgTokuchoKekka")
    public void setDgTokuchoKekka(DataGrid<dgTokuchoKekka_Row> dgTokuchoKekka) {
        this.dgTokuchoKekka=dgTokuchoKekka;
    }

    // </editor-fold>
}
