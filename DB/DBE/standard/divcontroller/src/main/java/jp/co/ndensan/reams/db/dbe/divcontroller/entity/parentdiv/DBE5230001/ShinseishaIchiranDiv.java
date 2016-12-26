package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5230001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * ShinseishaIchiran のクラスファイル 
 * 
 * @author 自動生成
 */
public class ShinseishaIchiranDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-10-31_12-59-50">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("lblTaishosha")
    private Label lblTaishosha;
    @JsonProperty("dgTaishoshaIchiran")
    private DataGrid<dgTaishoshaIchiran_Row> dgTaishoshaIchiran;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getlblTaishosha
     * @return lblTaishosha
     */
    @JsonProperty("lblTaishosha")
    public Label getLblTaishosha() {
        return lblTaishosha;
    }

    /*
     * setlblTaishosha
     * @param lblTaishosha lblTaishosha
     */
    @JsonProperty("lblTaishosha")
    public void setLblTaishosha(Label lblTaishosha) {
        this.lblTaishosha = lblTaishosha;
    }

    /*
     * getdgTaishoshaIchiran
     * @return dgTaishoshaIchiran
     */
    @JsonProperty("dgTaishoshaIchiran")
    public DataGrid<dgTaishoshaIchiran_Row> getDgTaishoshaIchiran() {
        return dgTaishoshaIchiran;
    }

    /*
     * setdgTaishoshaIchiran
     * @param dgTaishoshaIchiran dgTaishoshaIchiran
     */
    @JsonProperty("dgTaishoshaIchiran")
    public void setDgTaishoshaIchiran(DataGrid<dgTaishoshaIchiran_Row> dgTaishoshaIchiran) {
        this.dgTaishoshaIchiran = dgTaishoshaIchiran;
    }

    // </editor-fold>
}
