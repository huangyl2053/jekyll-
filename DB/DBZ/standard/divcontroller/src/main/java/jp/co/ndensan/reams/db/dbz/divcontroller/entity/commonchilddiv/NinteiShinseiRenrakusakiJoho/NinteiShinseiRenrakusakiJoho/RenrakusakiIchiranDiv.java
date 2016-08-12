package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.NinteiShinseiRenrakusakiJoho.NinteiShinseiRenrakusakiJoho;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * RenrakusakiIchiran のクラスファイル
 *
 * @reamsid_L DBZ-1300-100 dongyabin
 */
public class RenrakusakiIchiranDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("btnShinkiTsuika")
    private Button btnShinkiTsuika;
    @JsonProperty("btnFukushaTsuika")
    private Button btnFukushaTsuika;
    @JsonProperty("btnZenkaiFukusha")
    private Button btnZenkaiFukusha;
    @JsonProperty("dgRenrakusakiIchiran")
    private DataGrid<dgRenrakusakiIchiran_Row> dgRenrakusakiIchiran;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getbtnShinkiTsuika
     * @return btnShinkiTsuika
     */
    @JsonProperty("btnShinkiTsuika")
    public Button getBtnShinkiTsuika() {
        return btnShinkiTsuika;
    }

    /*
     * setbtnShinkiTsuika
     * @param btnShinkiTsuika btnShinkiTsuika
     */
    @JsonProperty("btnShinkiTsuika")
    public void setBtnShinkiTsuika(Button btnShinkiTsuika) {
        this.btnShinkiTsuika = btnShinkiTsuika;
    }

    /*
     * getbtnFukushaTsuika
     * @return btnFukushaTsuika
     */
    @JsonProperty("btnFukushaTsuika")
    public Button getBtnFukushaTsuika() {
        return btnFukushaTsuika;
    }

    /*
     * setbtnFukushaTsuika
     * @param btnFukushaTsuika btnFukushaTsuika
     */
    @JsonProperty("btnFukushaTsuika")
    public void setBtnFukushaTsuika(Button btnFukushaTsuika) {
        this.btnFukushaTsuika = btnFukushaTsuika;
    }

    /*
     * getbtnZenkaiFukusha
     * @return btnZenkaiFukusha
     */
    @JsonProperty("btnZenkaiFukusha")
    public Button getBtnZenkaiFukusha() {
        return btnZenkaiFukusha;
    }

    /*
     * setbtnZenkaiFukusha
     * @param btnZenkaiFukusha btnZenkaiFukusha
     */
    @JsonProperty("btnZenkaiFukusha")
    public void setBtnZenkaiFukusha(Button btnZenkaiFukusha) {
        this.btnZenkaiFukusha = btnZenkaiFukusha;
    }

    /*
     * getdgRenrakusakiIchiran
     * @return dgRenrakusakiIchiran
     */
    @JsonProperty("dgRenrakusakiIchiran")
    public DataGrid<dgRenrakusakiIchiran_Row> getDgRenrakusakiIchiran() {
        return dgRenrakusakiIchiran;
    }

    /*
     * setdgRenrakusakiIchiran
     * @param dgRenrakusakiIchiran dgRenrakusakiIchiran
     */
    @JsonProperty("dgRenrakusakiIchiran")
    public void setDgRenrakusakiIchiran(DataGrid<dgRenrakusakiIchiran_Row> dgRenrakusakiIchiran) {
        this.dgRenrakusakiIchiran = dgRenrakusakiIchiran;
    }

    // </editor-fold>
}
