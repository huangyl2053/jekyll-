package jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB0140001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGrid;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * FuchoKarisanteiKanrijoho のクラスファイル
 *
 * @reamsid_L DBB-0710-010 gongliang
 */
public class FuchoKarisanteiKanrijohoDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-03-22_14-06-37">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("dgKanrijoho2")
    private DataGrid<dgKanrijoho2_Row> dgKanrijoho2;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getdgKanrijoho2
     * @return dgKanrijoho2
     */
    @JsonProperty("dgKanrijoho2")
    public DataGrid<dgKanrijoho2_Row> getDgKanrijoho2() {
        return dgKanrijoho2;
    }

    /*
     * setdgKanrijoho2
     * @param dgKanrijoho2 dgKanrijoho2
     */
    @JsonProperty("dgKanrijoho2")
    public void setDgKanrijoho2(DataGrid<dgKanrijoho2_Row> dgKanrijoho2) {
        this.dgKanrijoho2 = dgKanrijoho2;
    }

    // </editor-fold>
}
