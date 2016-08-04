package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2300001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * meireisho のクラスファイル 
 * 
 * @author 自動生成
 */
public class meireishoDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("radjyushin")
    private RadioButton radjyushin;
    @JsonProperty("txtjyushinymd")
    private TextBoxDate txtjyushinymd;
    @JsonProperty("txtjyushintime")
    private TextBoxTime txtjyushintime;
    @JsonProperty("spSpace1")
    private Space spSpace1;
    @JsonProperty("spSpace2")
    private Space spSpace2;
    @JsonProperty("txtJyushinKikan")
    private TextBoxDateRange txtJyushinKikan;
    @JsonProperty("txtjyushinbasho")
    private TextBox txtjyushinbasho;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getradjyushin
     * @return radjyushin
     */
    @JsonProperty("radjyushin")
    public RadioButton getRadjyushin() {
        return radjyushin;
    }

    /*
     * setradjyushin
     * @param radjyushin radjyushin
     */
    @JsonProperty("radjyushin")
    public void setRadjyushin(RadioButton radjyushin) {
        this.radjyushin = radjyushin;
    }

    /*
     * gettxtjyushinymd
     * @return txtjyushinymd
     */
    @JsonProperty("txtjyushinymd")
    public TextBoxDate getTxtjyushinymd() {
        return txtjyushinymd;
    }

    /*
     * settxtjyushinymd
     * @param txtjyushinymd txtjyushinymd
     */
    @JsonProperty("txtjyushinymd")
    public void setTxtjyushinymd(TextBoxDate txtjyushinymd) {
        this.txtjyushinymd = txtjyushinymd;
    }

    /*
     * gettxtjyushintime
     * @return txtjyushintime
     */
    @JsonProperty("txtjyushintime")
    public TextBoxTime getTxtjyushintime() {
        return txtjyushintime;
    }

    /*
     * settxtjyushintime
     * @param txtjyushintime txtjyushintime
     */
    @JsonProperty("txtjyushintime")
    public void setTxtjyushintime(TextBoxTime txtjyushintime) {
        this.txtjyushintime = txtjyushintime;
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
     * getspSpace2
     * @return spSpace2
     */
    @JsonProperty("spSpace2")
    public Space getSpSpace2() {
        return spSpace2;
    }

    /*
     * setspSpace2
     * @param spSpace2 spSpace2
     */
    @JsonProperty("spSpace2")
    public void setSpSpace2(Space spSpace2) {
        this.spSpace2 = spSpace2;
    }

    /*
     * gettxtJyushinKikan
     * @return txtJyushinKikan
     */
    @JsonProperty("txtJyushinKikan")
    public TextBoxDateRange getTxtJyushinKikan() {
        return txtJyushinKikan;
    }

    /*
     * settxtJyushinKikan
     * @param txtJyushinKikan txtJyushinKikan
     */
    @JsonProperty("txtJyushinKikan")
    public void setTxtJyushinKikan(TextBoxDateRange txtJyushinKikan) {
        this.txtJyushinKikan = txtJyushinKikan;
    }

    /*
     * gettxtjyushinbasho
     * @return txtjyushinbasho
     */
    @JsonProperty("txtjyushinbasho")
    public TextBox getTxtjyushinbasho() {
        return txtjyushinbasho;
    }

    /*
     * settxtjyushinbasho
     * @param txtjyushinbasho txtjyushinbasho
     */
    @JsonProperty("txtjyushinbasho")
    public void setTxtjyushinbasho(TextBox txtjyushinbasho) {
        this.txtjyushinbasho = txtjyushinbasho;
    }

    // </editor-fold>
}
