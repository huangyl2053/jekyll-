package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC5140011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.CheckBoxList;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * ShutsuryokuTaisoDetail のクラスファイル
 *
 * @reamsid_L DBC-3330-010 lihang
 */
public class ShutsuryokuTaisoDetailDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-07-28_11-34-20">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("chkCsvEdit")
    private CheckBoxList chkCsvEdit;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getchkCsvEdit
     * @return chkCsvEdit
     */
    @JsonProperty("chkCsvEdit")
    public CheckBoxList getChkCsvEdit() {
        return chkCsvEdit;
    }

    /*
     * setchkCsvEdit
     * @param chkCsvEdit chkCsvEdit
     */
    @JsonProperty("chkCsvEdit")
    public void setChkCsvEdit(CheckBoxList chkCsvEdit) {
        this.chkCsvEdit = chkCsvEdit;
    }

    // </editor-fold>
}
