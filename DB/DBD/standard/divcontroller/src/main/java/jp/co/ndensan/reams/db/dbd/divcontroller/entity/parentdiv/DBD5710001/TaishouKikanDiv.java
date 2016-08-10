package jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD5710001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * TaishouKikan のクラスファイル 
 * 
 * @author 自動生成
 */
public class TaishouKikanDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-07-28_11-34-20">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtZenkaiymdtime")
    private TextBoxDateTimeRange txtZenkaiymdtime;
    @JsonProperty("txtKonkaiymdtime")
    private TextBoxDateTimeRange txtKonkaiymdtime;
    @JsonProperty("lblMemo")
    private Label lblMemo;
    @JsonProperty("chkIdouChushutsuTaishou")
    private CheckBoxList chkIdouChushutsuTaishou;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtZenkaiymdtime
     * @return txtZenkaiymdtime
     */
    @JsonProperty("txtZenkaiymdtime")
    public TextBoxDateTimeRange getTxtZenkaiymdtime() {
        return txtZenkaiymdtime;
    }

    /*
     * settxtZenkaiymdtime
     * @param txtZenkaiymdtime txtZenkaiymdtime
     */
    @JsonProperty("txtZenkaiymdtime")
    public void setTxtZenkaiymdtime(TextBoxDateTimeRange txtZenkaiymdtime) {
        this.txtZenkaiymdtime = txtZenkaiymdtime;
    }

    /*
     * gettxtKonkaiymdtime
     * @return txtKonkaiymdtime
     */
    @JsonProperty("txtKonkaiymdtime")
    public TextBoxDateTimeRange getTxtKonkaiymdtime() {
        return txtKonkaiymdtime;
    }

    /*
     * settxtKonkaiymdtime
     * @param txtKonkaiymdtime txtKonkaiymdtime
     */
    @JsonProperty("txtKonkaiymdtime")
    public void setTxtKonkaiymdtime(TextBoxDateTimeRange txtKonkaiymdtime) {
        this.txtKonkaiymdtime = txtKonkaiymdtime;
    }

    /*
     * getlblMemo
     * @return lblMemo
     */
    @JsonProperty("lblMemo")
    public Label getLblMemo() {
        return lblMemo;
    }

    /*
     * setlblMemo
     * @param lblMemo lblMemo
     */
    @JsonProperty("lblMemo")
    public void setLblMemo(Label lblMemo) {
        this.lblMemo = lblMemo;
    }

    /*
     * getchkIdouChushutsuTaishou
     * @return chkIdouChushutsuTaishou
     */
    @JsonProperty("chkIdouChushutsuTaishou")
    public CheckBoxList getChkIdouChushutsuTaishou() {
        return chkIdouChushutsuTaishou;
    }

    /*
     * setchkIdouChushutsuTaishou
     * @param chkIdouChushutsuTaishou chkIdouChushutsuTaishou
     */
    @JsonProperty("chkIdouChushutsuTaishou")
    public void setChkIdouChushutsuTaishou(CheckBoxList chkIdouChushutsuTaishou) {
        this.chkIdouChushutsuTaishou = chkIdouChushutsuTaishou;
    }

    // </editor-fold>
}
