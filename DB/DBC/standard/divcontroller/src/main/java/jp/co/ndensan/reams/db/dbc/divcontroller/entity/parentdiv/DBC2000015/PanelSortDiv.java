package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC2000015;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.RadioButton;

/**
 * PanelSort のクラスファイル
 *
 * @reamsid_L DBC-4960-010 dongqianjing
 */
public class PanelSortDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("radSort")
    private RadioButton radSort;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getradSort
     * @return radSort
     */
    @JsonProperty("radSort")
    public RadioButton getRadSort() {
        return radSort;
    }

    /*
     * setradSort
     * @param radSort radSort
     */
    @JsonProperty("radSort")
    public void setRadSort(RadioButton radSort) {
        this.radSort = radSort;
    }

    // </editor-fold>
}
