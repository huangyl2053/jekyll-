package jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB5140001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGrid;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * KoikiShori のクラスファイル
 *
 * @reamsid_L DBB-1890-010 chenhui
 */
public class KoikiShoriDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("dgKoikiShoriTaishoSelect")
    private DataGrid<dgKoikiShoriTaishoSelect_Row> dgKoikiShoriTaishoSelect;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getdgKoikiShoriTaishoSelect
     * @return dgKoikiShoriTaishoSelect
     */
    @JsonProperty("dgKoikiShoriTaishoSelect")
    public DataGrid<dgKoikiShoriTaishoSelect_Row> getDgKoikiShoriTaishoSelect() {
        return dgKoikiShoriTaishoSelect;
    }

    /*
     * setdgKoikiShoriTaishoSelect
     * @param dgKoikiShoriTaishoSelect dgKoikiShoriTaishoSelect
     */
    @JsonProperty("dgKoikiShoriTaishoSelect")
    public void setDgKoikiShoriTaishoSelect(DataGrid<dgKoikiShoriTaishoSelect_Row> dgKoikiShoriTaishoSelect) {
        this.dgKoikiShoriTaishoSelect = dgKoikiShoriTaishoSelect;
    }

    // </editor-fold>
}
