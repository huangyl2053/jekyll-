package jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB0110001;
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
 * TokuchoKarisanteiShoriKakunin のクラスファイル
 *
 * @reamsid_L DBB-0790-010 yangchenbing
 */
public class TokuchoKarisanteiShoriKakuninDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-03-22_14-06-37">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("dgTokutyoKariSanteiShoriKakunin")
    private DataGrid<dgTokutyoKariSanteiShoriKakunin_Row> dgTokutyoKariSanteiShoriKakunin;
    @JsonProperty("lblonsanteiShoriKakunin")
    private Label lblonsanteiShoriKakunin;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getdgTokutyoKariSanteiShoriKakunin
     * @return dgTokutyoKariSanteiShoriKakunin
     */
    @JsonProperty("dgTokutyoKariSanteiShoriKakunin")
    public DataGrid<dgTokutyoKariSanteiShoriKakunin_Row> getDgTokutyoKariSanteiShoriKakunin() {
        return dgTokutyoKariSanteiShoriKakunin;
    }

    /*
     * setdgTokutyoKariSanteiShoriKakunin
     * @param dgTokutyoKariSanteiShoriKakunin dgTokutyoKariSanteiShoriKakunin
     */
    @JsonProperty("dgTokutyoKariSanteiShoriKakunin")
    public void setDgTokutyoKariSanteiShoriKakunin(DataGrid<dgTokutyoKariSanteiShoriKakunin_Row> dgTokutyoKariSanteiShoriKakunin) {
        this.dgTokutyoKariSanteiShoriKakunin = dgTokutyoKariSanteiShoriKakunin;
    }

    /*
     * getlblonsanteiShoriKakunin
     * @return lblonsanteiShoriKakunin
     */
    @JsonProperty("lblonsanteiShoriKakunin")
    public Label getLblonsanteiShoriKakunin() {
        return lblonsanteiShoriKakunin;
    }

    /*
     * setlblonsanteiShoriKakunin
     * @param lblonsanteiShoriKakunin lblonsanteiShoriKakunin
     */
    @JsonProperty("lblonsanteiShoriKakunin")
    public void setLblonsanteiShoriKakunin(Label lblonsanteiShoriKakunin) {
        this.lblonsanteiShoriKakunin = lblonsanteiShoriKakunin;
    }

    // </editor-fold>
}
