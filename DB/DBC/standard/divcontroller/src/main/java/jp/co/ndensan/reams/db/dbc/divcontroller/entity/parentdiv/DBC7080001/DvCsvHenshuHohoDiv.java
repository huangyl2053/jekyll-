package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC7080001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.CheckBoxList;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * DvCsvHenshuHoho のクラスファイル
 *
 * @reamsid_L DBC-3096-010 zhengshenlei
 */
public class DvCsvHenshuHohoDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("chkCsvHenshuHoho")
    private CheckBoxList chkCsvHenshuHoho;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getchkCsvHenshuHoho
     * @return chkCsvHenshuHoho
     */
    @JsonProperty("chkCsvHenshuHoho")
    public CheckBoxList getChkCsvHenshuHoho() {
        return chkCsvHenshuHoho;
    }

    /*
     * setchkCsvHenshuHoho
     * @param chkCsvHenshuHoho chkCsvHenshuHoho
     */
    @JsonProperty("chkCsvHenshuHoho")
    public void setChkCsvHenshuHoho(CheckBoxList chkCsvHenshuHoho) {
        this.chkCsvHenshuHoho = chkCsvHenshuHoho;
    }

    // </editor-fold>
}
