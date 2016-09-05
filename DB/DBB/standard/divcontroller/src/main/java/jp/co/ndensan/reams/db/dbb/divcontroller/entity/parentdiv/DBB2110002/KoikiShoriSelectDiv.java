package jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB2110002;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGrid;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * KoikiShoriSelect のクラスファイル
 *
 * @reamsid_L DBB-4240-010 chenhui
 */
public class KoikiShoriSelectDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("dgkoikiShoriSelect")
    private DataGrid<dgkoikiShoriSelect_Row> dgkoikiShoriSelect;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getdgkoikiShoriSelect
     * @return dgkoikiShoriSelect
     */
    @JsonProperty("dgkoikiShoriSelect")
    public DataGrid<dgkoikiShoriSelect_Row> getDgkoikiShoriSelect() {
        return dgkoikiShoriSelect;
    }

    /*
     * setdgkoikiShoriSelect
     * @param dgkoikiShoriSelect dgkoikiShoriSelect
     */
    @JsonProperty("dgkoikiShoriSelect")
    public void setDgkoikiShoriSelect(DataGrid<dgkoikiShoriSelect_Row> dgkoikiShoriSelect) {
        this.dgkoikiShoriSelect = dgkoikiShoriSelect;
    }

    // </editor-fold>
}
