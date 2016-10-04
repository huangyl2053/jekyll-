package jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD1320001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * ChushutsuShosaiB25 のクラスファイル 
 * 
 * @author 自動生成
 */
public class ChushutsuShosaiB25Div extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-07-28_11-34-20">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtChushutsuHani")
    private TextBoxDateRange txtChushutsuHani;
    @JsonProperty("chkChokkinNomi2")
    private CheckBoxList chkChokkinNomi2;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtChushutsuHani
     * @return txtChushutsuHani
     */
    @JsonProperty("txtChushutsuHani")
    public TextBoxDateRange getTxtChushutsuHani() {
        return txtChushutsuHani;
    }

    /*
     * settxtChushutsuHani
     * @param txtChushutsuHani txtChushutsuHani
     */
    @JsonProperty("txtChushutsuHani")
    public void setTxtChushutsuHani(TextBoxDateRange txtChushutsuHani) {
        this.txtChushutsuHani = txtChushutsuHani;
    }

    /*
     * getchkChokkinNomi2
     * @return chkChokkinNomi2
     */
    @JsonProperty("chkChokkinNomi2")
    public CheckBoxList getChkChokkinNomi2() {
        return chkChokkinNomi2;
    }

    /*
     * setchkChokkinNomi2
     * @param chkChokkinNomi2 chkChokkinNomi2
     */
    @JsonProperty("chkChokkinNomi2")
    public void setChkChokkinNomi2(CheckBoxList chkChokkinNomi2) {
        this.chkChokkinNomi2 = chkChokkinNomi2;
    }

    // </editor-fold>
}
