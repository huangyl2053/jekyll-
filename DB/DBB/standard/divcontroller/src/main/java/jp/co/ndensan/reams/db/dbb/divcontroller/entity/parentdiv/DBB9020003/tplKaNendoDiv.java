package jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB9020003;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGrid;
import jp.co.ndensan.reams.uz.uza.ui.binding.TabPanel;

/**
 * tplKaNendo のクラスファイル
 *
 * @reamsid_L DBB-1770-050 xupeng
 */
public class tplKaNendoDiv extends TabPanel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-03-22_14-06-37">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("KaNendo")
    private KaNendoDiv KaNendo;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getKaNendo
     * @return KaNendo
     */
    @JsonProperty("KaNendo")
    public KaNendoDiv getKaNendo() {
        return KaNendo;
    }

    /*
     * setKaNendo
     * @param KaNendo KaNendo
     */
    @JsonProperty("KaNendo")
    public void setKaNendo(KaNendoDiv KaNendo) {
        this.KaNendo = KaNendo;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public DataGrid<dgKaNendoKibetsuJoho_Row> getDgKaNendoKibetsuJoho() {
        return this.getKaNendo().getDgKaNendoKibetsuJoho();
    }

    @JsonIgnore
    public void setDgKaNendoKibetsuJoho(DataGrid<dgKaNendoKibetsuJoho_Row> dgKaNendoKibetsuJoho) {
        this.getKaNendo().setDgKaNendoKibetsuJoho(dgKaNendoKibetsuJoho);
    }

    // </editor-fold>
}
