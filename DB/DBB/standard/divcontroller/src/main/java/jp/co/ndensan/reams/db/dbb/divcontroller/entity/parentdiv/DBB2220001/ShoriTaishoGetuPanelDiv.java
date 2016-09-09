package jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB2220001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGrid;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * ShoriTaishoGetuPanel のクラスファイル
 *
 * @reamsid_L DBB-5670-010 chenhui
 */
public class ShoriTaishoGetuPanelDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("dgShichosonShoriSelect")
    private DataGrid<dgShichosonShoriSelect_Row> dgShichosonShoriSelect;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getdgShichosonShoriSelect
     * @return dgShichosonShoriSelect
     */
    @JsonProperty("dgShichosonShoriSelect")
    public DataGrid<dgShichosonShoriSelect_Row> getDgShichosonShoriSelect() {
        return dgShichosonShoriSelect;
    }

    /*
     * setdgShichosonShoriSelect
     * @param dgShichosonShoriSelect dgShichosonShoriSelect
     */
    @JsonProperty("dgShichosonShoriSelect")
    public void setDgShichosonShoriSelect(DataGrid<dgShichosonShoriSelect_Row> dgShichosonShoriSelect) {
        this.dgShichosonShoriSelect = dgShichosonShoriSelect;
    }

    // </editor-fold>
}
