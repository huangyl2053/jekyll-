package jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB0150001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGrid;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.RadioButton;

/**
 * KarisanteiIdoFukaKanriInfo のクラスファイル
 *
 * @reamsid_L DBB-0890-010 wangkanglei
 */
public class KarisanteiIdoFukaKanriInfoDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：バージョン情報無し">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("radChushutsuJoken")
    private RadioButton radChushutsuJoken;
    @JsonProperty("dgChushutsuKikan")
    private DataGrid<dgChushutsuKikan_Row> dgChushutsuKikan;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getradChushutsuJoken
     * @return radChushutsuJoken
     */
    @JsonProperty("radChushutsuJoken")
    public RadioButton getRadChushutsuJoken() {
        return radChushutsuJoken;
    }

    /*
     * setradChushutsuJoken
     * @param radChushutsuJoken radChushutsuJoken
     */
    @JsonProperty("radChushutsuJoken")
    public void setRadChushutsuJoken(RadioButton radChushutsuJoken) {
        this.radChushutsuJoken = radChushutsuJoken;
    }

    /*
     * getdgChushutsuKikan
     * @return dgChushutsuKikan
     */
    @JsonProperty("dgChushutsuKikan")
    public DataGrid<dgChushutsuKikan_Row> getDgChushutsuKikan() {
        return dgChushutsuKikan;
    }

    /*
     * setdgChushutsuKikan
     * @param dgChushutsuKikan dgChushutsuKikan
     */
    @JsonProperty("dgChushutsuKikan")
    public void setDgChushutsuKikan(DataGrid<dgChushutsuKikan_Row> dgChushutsuKikan) {
        this.dgChushutsuKikan = dgChushutsuKikan;
    }

    // </editor-fold>
}
