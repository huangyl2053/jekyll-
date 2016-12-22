package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2200001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * MiwaritsukeShinseisha のクラスファイル 
 * 
 * @author 自動生成
 */
public class MiwaritsukeShinseishaDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-12-02_08-19-39">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("dgMiwaritsukeShinseishaIchiran")
    private DataGrid<dgMiwaritsukeShinseishaIchiran_Row> dgMiwaritsukeShinseishaIchiran;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getdgMiwaritsukeShinseishaIchiran
     * @return dgMiwaritsukeShinseishaIchiran
     */
    @JsonProperty("dgMiwaritsukeShinseishaIchiran")
    public DataGrid<dgMiwaritsukeShinseishaIchiran_Row> getDgMiwaritsukeShinseishaIchiran() {
        return dgMiwaritsukeShinseishaIchiran;
    }

    /*
     * setdgMiwaritsukeShinseishaIchiran
     * @param dgMiwaritsukeShinseishaIchiran dgMiwaritsukeShinseishaIchiran
     */
    @JsonProperty("dgMiwaritsukeShinseishaIchiran")
    public void setDgMiwaritsukeShinseishaIchiran(DataGrid<dgMiwaritsukeShinseishaIchiran_Row> dgMiwaritsukeShinseishaIchiran) {
        this.dgMiwaritsukeShinseishaIchiran = dgMiwaritsukeShinseishaIchiran;
    }

    // </editor-fold>
}
