package jp.co.ndensan.reams.db.dbe.divcontroller.entity.commonchilddiv.ShujiiIkenshoIraiShokai.ShujiiIkenshoIraiShokai;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.parentdiv.kaigoshikakukihon.IKaigoShikakuKihonDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.parentdiv.kaigoshikakukihon.KaigoShikakuKihonDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGrid;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * ShujiiIkenshoIraiShokai のクラスファイル
 *
 * @author 自動生成
 */
public class ShujiiIkenshoIraiShokaiDiv extends Panel implements IShujiiIkenshoIraiShokaiDiv {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：バージョン情報無し">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ccdKaigoShikakuKihon")
    private KaigoShikakuKihonDiv ccdKaigoShikakuKihon;
    @JsonProperty("dgIkenshoIraiIchiran")
    private DataGrid<dgIkenshoIraiIchiran_Row> dgIkenshoIraiIchiran;
    @JsonProperty("btnModoru")
    private Button btnModoru;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getccdKaigoShikakuKihon
     * @return ccdKaigoShikakuKihon
     */
    @JsonProperty("ccdKaigoShikakuKihon")
    public IKaigoShikakuKihonDiv getCcdKaigoShikakuKihon() {
        return ccdKaigoShikakuKihon;
    }

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

    // </editor-fold>
    //--------------- この行より下にコードを追加してください -------------------
    @Override
    public void loadInitialize(HihokenshaNo hihokenshano) {
        createHandlerOf(this).initialize(hihokenshano);
    }

    private ShujiiIkenshoIraiHandler createHandlerOf(ShujiiIkenshoIraiShokaiDiv requestDiv) {
        return new ShujiiIkenshoIraiHandler(requestDiv);
    }
}
