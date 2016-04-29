package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE7010001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * CsvKenHokokuShiryoSakusei のクラスファイル 
 * 
 * @author 自動生成
 */
public class CsvKenHokokuShiryoSakuseiDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-03-22_14-06-37">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("chkCsvShutsuryoku")
    private CheckBoxList chkCsvShutsuryoku;
    @JsonProperty("txtShuturyokuSaki")
    private TextBox txtShuturyokuSaki;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getchkCsvShutsuryoku
     * @return chkCsvShutsuryoku
     */
    @JsonProperty("chkCsvShutsuryoku")
    public CheckBoxList getChkCsvShutsuryoku() {
        return chkCsvShutsuryoku;
    }

    /*
     * setchkCsvShutsuryoku
     * @param chkCsvShutsuryoku chkCsvShutsuryoku
     */
    @JsonProperty("chkCsvShutsuryoku")
    public void setChkCsvShutsuryoku(CheckBoxList chkCsvShutsuryoku) {
        this.chkCsvShutsuryoku = chkCsvShutsuryoku;
    }

    /*
     * gettxtShuturyokuSaki
     * @return txtShuturyokuSaki
     */
    @JsonProperty("txtShuturyokuSaki")
    public TextBox getTxtShuturyokuSaki() {
        return txtShuturyokuSaki;
    }

    /*
     * settxtShuturyokuSaki
     * @param txtShuturyokuSaki txtShuturyokuSaki
     */
    @JsonProperty("txtShuturyokuSaki")
    public void setTxtShuturyokuSaki(TextBox txtShuturyokuSaki) {
        this.txtShuturyokuSaki = txtShuturyokuSaki;
    }

    // </editor-fold>
}
