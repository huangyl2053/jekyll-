package jp.co.ndensan.reams.db.dbe.divcontroller.entity.commonchilddiv.ChosaIraishoAndChosahyoAndIkenshoPrint;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * ShindanMeirei のクラスファイル 
 * 
 * @author 自動生成
 */
public class ShindanMeireiDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("radJyushinKikan")
    private RadioButton radJyushinKikan;
    @JsonProperty("txtJyushinymd")
    private TextBoxDate txtJyushinymd;
    @JsonProperty("txtJushinTime")
    private TextBoxTime txtJushinTime;
    @JsonProperty("spSpace1")
    private Space spSpace1;
    @JsonProperty("txtJushinKikan")
    private TextBoxDateRange txtJushinKikan;
    @JsonProperty("spSpace3")
    private Space spSpace3;
    @JsonProperty("txtJushinBasho")
    private TextBox txtJushinBasho;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getradJyushinKikan
     * @return radJyushinKikan
     */
    @JsonProperty("radJyushinKikan")
    public RadioButton getRadJyushinKikan() {
        return radJyushinKikan;
    }

    /*
     * setradJyushinKikan
     * @param radJyushinKikan radJyushinKikan
     */
    @JsonProperty("radJyushinKikan")
    public void setRadJyushinKikan(RadioButton radJyushinKikan) {
        this.radJyushinKikan = radJyushinKikan;
    }

    /*
     * gettxtJyushinymd
     * @return txtJyushinymd
     */
    @JsonProperty("txtJyushinymd")
    public TextBoxDate getTxtJyushinymd() {
        return txtJyushinymd;
    }

    /*
     * settxtJyushinymd
     * @param txtJyushinymd txtJyushinymd
     */
    @JsonProperty("txtJyushinymd")
    public void setTxtJyushinymd(TextBoxDate txtJyushinymd) {
        this.txtJyushinymd = txtJyushinymd;
    }

    /*
     * gettxtJushinTime
     * @return txtJushinTime
     */
    @JsonProperty("txtJushinTime")
    public TextBoxTime getTxtJushinTime() {
        return txtJushinTime;
    }

    /*
     * settxtJushinTime
     * @param txtJushinTime txtJushinTime
     */
    @JsonProperty("txtJushinTime")
    public void setTxtJushinTime(TextBoxTime txtJushinTime) {
        this.txtJushinTime = txtJushinTime;
    }

    /*
     * getspSpace1
     * @return spSpace1
     */
    @JsonProperty("spSpace1")
    public Space getSpSpace1() {
        return spSpace1;
    }

    /*
     * setspSpace1
     * @param spSpace1 spSpace1
     */
    @JsonProperty("spSpace1")
    public void setSpSpace1(Space spSpace1) {
        this.spSpace1 = spSpace1;
    }

    /*
     * gettxtJushinKikan
     * @return txtJushinKikan
     */
    @JsonProperty("txtJushinKikan")
    public TextBoxDateRange getTxtJushinKikan() {
        return txtJushinKikan;
    }

    /*
     * settxtJushinKikan
     * @param txtJushinKikan txtJushinKikan
     */
    @JsonProperty("txtJushinKikan")
    public void setTxtJushinKikan(TextBoxDateRange txtJushinKikan) {
        this.txtJushinKikan = txtJushinKikan;
    }

    /*
     * getspSpace3
     * @return spSpace3
     */
    @JsonProperty("spSpace3")
    public Space getSpSpace3() {
        return spSpace3;
    }

    /*
     * setspSpace3
     * @param spSpace3 spSpace3
     */
    @JsonProperty("spSpace3")
    public void setSpSpace3(Space spSpace3) {
        this.spSpace3 = spSpace3;
    }

    /*
     * gettxtJushinBasho
     * @return txtJushinBasho
     */
    @JsonProperty("txtJushinBasho")
    public TextBox getTxtJushinBasho() {
        return txtJushinBasho;
    }

    /*
     * settxtJushinBasho
     * @param txtJushinBasho txtJushinBasho
     */
    @JsonProperty("txtJushinBasho")
    public void setTxtJushinBasho(TextBox txtJushinBasho) {
        this.txtJushinBasho = txtJushinBasho;
    }

    // </editor-fold>
}
