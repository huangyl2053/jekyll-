package jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0060031;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGrid;
import jp.co.ndensan.reams.uz.uza.ui.binding.TabPanel;

/**
 * tabChiikimitchakuyobosabisujukyuInput のクラスファイル
 *
 * @reamsid_L DBU-1060-030 zhengshukai
 */
public class tabChiikimitchakuyobosabisujukyuInputDiv extends TabPanel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2015-11-30_08-54-50">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("dgChiikimitchakuyobosabisujukyu")
    private DataGrid<dgChiikimitchakuyobosabisujukyu_Row> dgChiikimitchakuyobosabisujukyu;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getdgChiikimitchakuyobosabisujukyu
     * @return dgChiikimitchakuyobosabisujukyu
     */
    @JsonProperty("dgChiikimitchakuyobosabisujukyu")
    public DataGrid<dgChiikimitchakuyobosabisujukyu_Row> getDgChiikimitchakuyobosabisujukyu() {
        return dgChiikimitchakuyobosabisujukyu;
    }

    /*
     * setdgChiikimitchakuyobosabisujukyu
     * @param dgChiikimitchakuyobosabisujukyu dgChiikimitchakuyobosabisujukyu
     */
    @JsonProperty("dgChiikimitchakuyobosabisujukyu")
    public void setDgChiikimitchakuyobosabisujukyu(DataGrid<dgChiikimitchakuyobosabisujukyu_Row> dgChiikimitchakuyobosabisujukyu) {
        this.dgChiikimitchakuyobosabisujukyu = dgChiikimitchakuyobosabisujukyu;
    }

    // </editor-fold>
}
