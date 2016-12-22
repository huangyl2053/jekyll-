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
 * WaritsukeZumiTaishosha のクラスファイル 
 * 
 * @author 自動生成
 */
public class WaritsukeZumiTaishoshaDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-12-02_08-19-39">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("dgWaritsukeZumiShinseishaIchiran")
    private DataGrid<dgWaritsukeZumiShinseishaIchiran_Row> dgWaritsukeZumiShinseishaIchiran;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getdgWaritsukeZumiShinseishaIchiran
     * @return dgWaritsukeZumiShinseishaIchiran
     */
    @JsonProperty("dgWaritsukeZumiShinseishaIchiran")
    public DataGrid<dgWaritsukeZumiShinseishaIchiran_Row> getDgWaritsukeZumiShinseishaIchiran() {
        return dgWaritsukeZumiShinseishaIchiran;
    }

    /*
     * setdgWaritsukeZumiShinseishaIchiran
     * @param dgWaritsukeZumiShinseishaIchiran dgWaritsukeZumiShinseishaIchiran
     */
    @JsonProperty("dgWaritsukeZumiShinseishaIchiran")
    public void setDgWaritsukeZumiShinseishaIchiran(DataGrid<dgWaritsukeZumiShinseishaIchiran_Row> dgWaritsukeZumiShinseishaIchiran) {
        this.dgWaritsukeZumiShinseishaIchiran = dgWaritsukeZumiShinseishaIchiran;
    }

    // </editor-fold>
}
