package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2020002;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGrid;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * NchosainScheduleIchiran のクラスファイル
 *
 * @reamsid_L DBE-0020-020 lishengli
 */
public class NchosainScheduleIchiranDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-03-22_14-06-37">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("dgNinteiChosaSchedule")
    private DataGrid<dgNinteiChosaSchedule_Row> dgNinteiChosaSchedule;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getdgNinteiChosaSchedule
     * @return dgNinteiChosaSchedule
     */
    @JsonProperty("dgNinteiChosaSchedule")
    public DataGrid<dgNinteiChosaSchedule_Row> getDgNinteiChosaSchedule() {
        return dgNinteiChosaSchedule;
    }

    /*
     * setdgNinteiChosaSchedule
     * @param dgNinteiChosaSchedule dgNinteiChosaSchedule
     */
    @JsonProperty("dgNinteiChosaSchedule")
    public void setDgNinteiChosaSchedule(DataGrid<dgNinteiChosaSchedule_Row> dgNinteiChosaSchedule) {
        this.dgNinteiChosaSchedule = dgNinteiChosaSchedule;
    }

    // </editor-fold>
}
