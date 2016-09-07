package jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB0550001;
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
 * ShoriKakunin のクラスファイル
 *
 * @reamsid_L DBB-0920-010 quxiaodong
 */
public class ShoriKakuninDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-03-22_14-06-37">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("dgShoriKakunin")
    private DataGrid<dgShoriKakunin_Row> dgShoriKakunin;
    @JsonProperty("lblShoriKakunin")
    private Label lblShoriKakunin;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getdgShoriKakunin
     * @return dgShoriKakunin
     */
    @JsonProperty("dgShoriKakunin")
    public DataGrid<dgShoriKakunin_Row> getDgShoriKakunin() {
        return dgShoriKakunin;
    }

    /*
     * setdgShoriKakunin
     * @param dgShoriKakunin dgShoriKakunin
     */
    @JsonProperty("dgShoriKakunin")
    public void setDgShoriKakunin(DataGrid<dgShoriKakunin_Row> dgShoriKakunin) {
        this.dgShoriKakunin = dgShoriKakunin;
    }

    /*
     * getlblShoriKakunin
     * @return lblShoriKakunin
     */
    @JsonProperty("lblShoriKakunin")
    public Label getLblShoriKakunin() {
        return lblShoriKakunin;
    }

    /*
     * setlblShoriKakunin
     * @param lblShoriKakunin lblShoriKakunin
     */
    @JsonProperty("lblShoriKakunin")
    public void setLblShoriKakunin(Label lblShoriKakunin) {
        this.lblShoriKakunin = lblShoriKakunin;
    }

    // </editor-fold>
}
