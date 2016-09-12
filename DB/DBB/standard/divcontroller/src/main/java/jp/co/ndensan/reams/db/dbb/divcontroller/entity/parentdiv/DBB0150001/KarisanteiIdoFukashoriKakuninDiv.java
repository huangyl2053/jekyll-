package jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB0150001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGrid;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * KarisanteiIdoFukashoriKakunin のクラスファイル
 *
 * @reamsid_L DBB-0890-010 wangkanglei
 */
public class KarisanteiIdoFukashoriKakuninDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：バージョン情報無し">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("dgKarisanteiIdoshoriKakunin")
    private DataGrid<dgKarisanteiIdoshoriKakunin_Row> dgKarisanteiIdoshoriKakunin;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getdgKarisanteiIdoshoriKakunin
     * @return dgKarisanteiIdoshoriKakunin
     */
    @JsonProperty("dgKarisanteiIdoshoriKakunin")
    public DataGrid<dgKarisanteiIdoshoriKakunin_Row> getDgKarisanteiIdoshoriKakunin() {
        return dgKarisanteiIdoshoriKakunin;
    }

    /*
     * setdgKarisanteiIdoshoriKakunin
     * @param dgKarisanteiIdoshoriKakunin dgKarisanteiIdoshoriKakunin
     */
    @JsonProperty("dgKarisanteiIdoshoriKakunin")
    public void setDgKarisanteiIdoshoriKakunin(DataGrid<dgKarisanteiIdoshoriKakunin_Row> dgKarisanteiIdoshoriKakunin) {
        this.dgKarisanteiIdoshoriKakunin = dgKarisanteiIdoshoriKakunin;
    }

    // </editor-fold>
}
