package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0230011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGrid;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * IdoReanrakuhyoEraTeisei のクラスファイル
 *
 * @reamsid_L DBC-2720-010 liuxiaoyu
 */
public class IdoReanrakuhyoEraTeiseiDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("dgIdoReanrakuhyoEraTeisei")
    private DataGrid<dgIdoReanrakuhyoEraTeisei_Row> dgIdoReanrakuhyoEraTeisei;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getdgIdoReanrakuhyoEraTeisei
     * @return dgIdoReanrakuhyoEraTeisei
     */
    @JsonProperty("dgIdoReanrakuhyoEraTeisei")
    public DataGrid<dgIdoReanrakuhyoEraTeisei_Row> getDgIdoReanrakuhyoEraTeisei() {
        return dgIdoReanrakuhyoEraTeisei;
    }

    /*
     * setdgIdoReanrakuhyoEraTeisei
     * @param dgIdoReanrakuhyoEraTeisei dgIdoReanrakuhyoEraTeisei
     */
    @JsonProperty("dgIdoReanrakuhyoEraTeisei")
    public void setDgIdoReanrakuhyoEraTeisei(DataGrid<dgIdoReanrakuhyoEraTeisei_Row> dgIdoReanrakuhyoEraTeisei) {
        this.dgIdoReanrakuhyoEraTeisei = dgIdoReanrakuhyoEraTeisei;
    }

    // </editor-fold>
}
