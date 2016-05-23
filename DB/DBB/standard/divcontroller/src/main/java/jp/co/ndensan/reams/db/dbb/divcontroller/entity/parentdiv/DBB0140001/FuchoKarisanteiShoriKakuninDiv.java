package jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB0140001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGrid;
import jp.co.ndensan.reams.uz.uza.ui.binding.Label;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * FuchoKarisanteiShoriKakunin のクラスファイル
 *
 * @reamsid_L DBB-0710-010 gongliang
 */
public class FuchoKarisanteiShoriKakuninDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-03-22_14-06-37">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("dgFuchoKarisanteiShoriKakunin")
    private DataGrid<dgFuchoKarisanteiShoriKakunin_Row> dgFuchoKarisanteiShoriKakunin;
    @JsonProperty("lblFuchoKarisanteiShoriKakunin")
    private Label lblFuchoKarisanteiShoriKakunin;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getdgFuchoKarisanteiShoriKakunin
     * @return dgFuchoKarisanteiShoriKakunin
     */
    @JsonProperty("dgFuchoKarisanteiShoriKakunin")
    public DataGrid<dgFuchoKarisanteiShoriKakunin_Row> getDgFuchoKarisanteiShoriKakunin() {
        return dgFuchoKarisanteiShoriKakunin;
    }

    /*
     * setdgFuchoKarisanteiShoriKakunin
     * @param dgFuchoKarisanteiShoriKakunin dgFuchoKarisanteiShoriKakunin
     */
    @JsonProperty("dgFuchoKarisanteiShoriKakunin")
    public void setDgFuchoKarisanteiShoriKakunin(DataGrid<dgFuchoKarisanteiShoriKakunin_Row> dgFuchoKarisanteiShoriKakunin) {
        this.dgFuchoKarisanteiShoriKakunin = dgFuchoKarisanteiShoriKakunin;
    }

    /*
     * getlblFuchoKarisanteiShoriKakunin
     * @return lblFuchoKarisanteiShoriKakunin
     */
    @JsonProperty("lblFuchoKarisanteiShoriKakunin")
    public Label getLblFuchoKarisanteiShoriKakunin() {
        return lblFuchoKarisanteiShoriKakunin;
    }

    /*
     * setlblFuchoKarisanteiShoriKakunin
     * @param lblFuchoKarisanteiShoriKakunin lblFuchoKarisanteiShoriKakunin
     */
    @JsonProperty("lblFuchoKarisanteiShoriKakunin")
    public void setLblFuchoKarisanteiShoriKakunin(Label lblFuchoKarisanteiShoriKakunin) {
        this.lblFuchoKarisanteiShoriKakunin = lblFuchoKarisanteiShoriKakunin;
    }

    // </editor-fold>
}
