package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE6030001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * NinteiChosaJisseki のクラスファイル 
 * 
 * @author 自動生成
 */
public class NinteiChosaJissekiDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("dgNinteiChosaJisseki")
    private DataGrid<dgNinteiChosaJisseki_Row> dgNinteiChosaJisseki;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getdgNinteiChosaJisseki
     * @return dgNinteiChosaJisseki
     */
    @JsonProperty("dgNinteiChosaJisseki")
    public DataGrid<dgNinteiChosaJisseki_Row> getDgNinteiChosaJisseki() {
        return dgNinteiChosaJisseki;
    }

    /*
     * setdgNinteiChosaJisseki
     * @param dgNinteiChosaJisseki dgNinteiChosaJisseki
     */
    @JsonProperty("dgNinteiChosaJisseki")
    public void setDgNinteiChosaJisseki(DataGrid<dgNinteiChosaJisseki_Row> dgNinteiChosaJisseki) {
        this.dgNinteiChosaJisseki = dgNinteiChosaJisseki;
    }

    // </editor-fold>
}
