package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC4520011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGrid;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * KaigoShienSenmoninIchiran のクラスファイル
 *
 * @reamsid_L DBC-3370-010 yuqingzhang
 */
public class KaigoShienSenmoninIchiranDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("btnTuika")
    private Button btnTuika;
    @JsonProperty("dgKaigoShienSenmoninIchiran")
    private DataGrid<dgKaigoShienSenmoninIchiran_Row> dgKaigoShienSenmoninIchiran;
    @JsonProperty("btnSaiKensaku")
    private Button btnSaiKensaku;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getbtnTuika
     * @return btnTuika
     */
    @JsonProperty("btnTuika")
    public Button getBtnTuika() {
        return btnTuika;
    }

    /*
     * setbtnTuika
     * @param btnTuika btnTuika
     */
    @JsonProperty("btnTuika")
    public void setBtnTuika(Button btnTuika) {
        this.btnTuika = btnTuika;
    }

    /*
     * getdgKaigoShienSenmoninIchiran
     * @return dgKaigoShienSenmoninIchiran
     */
    @JsonProperty("dgKaigoShienSenmoninIchiran")
    public DataGrid<dgKaigoShienSenmoninIchiran_Row> getDgKaigoShienSenmoninIchiran() {
        return dgKaigoShienSenmoninIchiran;
    }

    /*
     * setdgKaigoShienSenmoninIchiran
     * @param dgKaigoShienSenmoninIchiran dgKaigoShienSenmoninIchiran
     */
    @JsonProperty("dgKaigoShienSenmoninIchiran")
    public void setDgKaigoShienSenmoninIchiran(DataGrid<dgKaigoShienSenmoninIchiran_Row> dgKaigoShienSenmoninIchiran) {
        this.dgKaigoShienSenmoninIchiran = dgKaigoShienSenmoninIchiran;
    }

    /*
     * getbtnSaiKensaku
     * @return btnSaiKensaku
     */
    @JsonProperty("btnSaiKensaku")
    public Button getBtnSaiKensaku() {
        return btnSaiKensaku;
    }

    /*
     * setbtnSaiKensaku
     * @param btnSaiKensaku btnSaiKensaku
     */
    @JsonProperty("btnSaiKensaku")
    public void setBtnSaiKensaku(Button btnSaiKensaku) {
        this.btnSaiKensaku = btnSaiKensaku;
    }

    // </editor-fold>
}
