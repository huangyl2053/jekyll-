package jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB0320001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * FukaRirekiPanel のクラスファイル 
 * 
 * @author 自動生成
 */
public class FukaRirekiPanelDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtFukaNendoFukaRireki")
    private TextBoxFlexibleYear txtFukaNendoFukaRireki;
    @JsonProperty("dgFukaRirekiFukaRireki")
    private DataGrid<dgFukaRirekiFukaRireki_Row> dgFukaRirekiFukaRireki;
    @JsonProperty("mode")
    private RString mode;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtFukaNendoFukaRireki
     * @return txtFukaNendoFukaRireki
     */
    @JsonProperty("txtFukaNendoFukaRireki")
    public TextBoxFlexibleYear getTxtFukaNendoFukaRireki() {
        return txtFukaNendoFukaRireki;
    }

    /*
     * settxtFukaNendoFukaRireki
     * @param txtFukaNendoFukaRireki txtFukaNendoFukaRireki
     */
    @JsonProperty("txtFukaNendoFukaRireki")
    public void setTxtFukaNendoFukaRireki(TextBoxFlexibleYear txtFukaNendoFukaRireki) {
        this.txtFukaNendoFukaRireki = txtFukaNendoFukaRireki;
    }

    /*
     * getdgFukaRirekiFukaRireki
     * @return dgFukaRirekiFukaRireki
     */
    @JsonProperty("dgFukaRirekiFukaRireki")
    public DataGrid<dgFukaRirekiFukaRireki_Row> getDgFukaRirekiFukaRireki() {
        return dgFukaRirekiFukaRireki;
    }

    /*
     * setdgFukaRirekiFukaRireki
     * @param dgFukaRirekiFukaRireki dgFukaRirekiFukaRireki
     */
    @JsonProperty("dgFukaRirekiFukaRireki")
    public void setDgFukaRirekiFukaRireki(DataGrid<dgFukaRirekiFukaRireki_Row> dgFukaRirekiFukaRireki) {
        this.dgFukaRirekiFukaRireki = dgFukaRirekiFukaRireki;
    }

    /*
     * getmode
     * @return mode
     */
    @JsonProperty("mode")
    public RString getMode() {
        return mode;
    }

    /*
     * setmode
     * @param mode mode
     */
    @JsonProperty("mode")
    public void setMode(RString mode) {
        this.mode = mode;
    }

    // </editor-fold>
}
