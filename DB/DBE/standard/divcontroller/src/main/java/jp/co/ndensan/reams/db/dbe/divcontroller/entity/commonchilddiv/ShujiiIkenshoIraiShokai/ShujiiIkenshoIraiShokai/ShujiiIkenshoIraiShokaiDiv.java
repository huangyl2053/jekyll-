package jp.co.ndensan.reams.db.dbe.divcontroller.entity.commonchilddiv.ShujiiIkenshoIraiShokai.ShujiiIkenshoIraiShokai;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.kaigoshikakukihon.KaigoShikakuKihon.IKaigoShikakuKihonDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.kaigoshikakukihon.KaigoShikakuKihon.KaigoShikakuKihonDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGrid;

/**
 * ShujiiIkenshoIraiShokai のクラスファイル
 *
 * @reamsid_L DBE-0200-030 zhangzhiming
 */
public class ShujiiIkenshoIraiShokaiDiv extends Panel implements IShujiiIkenshoIraiShokaiDiv {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("dgIkenshoIraiIchiran")
    private DataGrid<dgIkenshoIraiIchiran_Row> dgIkenshoIraiIchiran;
    @JsonProperty("btnModoru")
    private Button btnModoru;
    @JsonProperty("hihokenshano")
    private RString hihokenshano;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getdgIkenshoIraiIchiran
     * @return dgIkenshoIraiIchiran
     */
    @JsonProperty("dgIkenshoIraiIchiran")
    public DataGrid<dgIkenshoIraiIchiran_Row> getDgIkenshoIraiIchiran() {
        return dgIkenshoIraiIchiran;
    }

    /*
     * setdgIkenshoIraiIchiran
     * @param dgIkenshoIraiIchiran dgIkenshoIraiIchiran
     */
    @JsonProperty("dgIkenshoIraiIchiran")
    public void setDgIkenshoIraiIchiran(DataGrid<dgIkenshoIraiIchiran_Row> dgIkenshoIraiIchiran) {
        this.dgIkenshoIraiIchiran = dgIkenshoIraiIchiran;
    }

    /*
     * getbtnModoru
     * @return btnModoru
     */
    @JsonProperty("btnModoru")
    public Button getBtnModoru() {
        return btnModoru;
    }

    /*
     * setbtnModoru
     * @param btnModoru btnModoru
     */
    @JsonProperty("btnModoru")
    public void setBtnModoru(Button btnModoru) {
        this.btnModoru = btnModoru;
    }

    /*
     * gethihokenshano
     * @return hihokenshano
     */
    @JsonProperty("hihokenshano")
    public RString getHihokenshano() {
        return hihokenshano;
    }

    /*
     * sethihokenshano
     * @param hihokenshano hihokenshano
     */
    @JsonProperty("hihokenshano")
    public void setHihokenshano(RString hihokenshano) {
        this.hihokenshano = hihokenshano;
    }

    // </editor-fold>
    //--------------- この行より下にコードを追加してください -------------------

}
