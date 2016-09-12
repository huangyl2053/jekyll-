package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2410002;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * meireishoPanel のクラスファイル 
 * 
 * @author 自動生成
 */
public class meireishoPanelDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("radJyushin")
    private RadioButton radJyushin;
    @JsonProperty("txtJyushinymd")
    private TextBoxDate txtJyushinymd;
    @JsonProperty("txtJyushintime")
    private TextBoxTime txtJyushintime;
    @JsonProperty("txtJyushinKikan")
    private TextBoxDateRange txtJyushinKikan;
    @JsonProperty("txtJyushinbasho")
    private TextBox txtJyushinbasho;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getradJyushin
     * @return radJyushin
     */
    @JsonProperty("radJyushin")
    public RadioButton getRadJyushin() {
        return radJyushin;
    }

    /*
     * setradJyushin
     * @param radJyushin radJyushin
     */
    @JsonProperty("radJyushin")
    public void setRadJyushin(RadioButton radJyushin) {
        this.radJyushin = radJyushin;
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
     * gettxtJyushintime
     * @return txtJyushintime
     */
    @JsonProperty("txtJyushintime")
    public TextBoxTime getTxtJyushintime() {
        return txtJyushintime;
    }

    /*
     * settxtJyushintime
     * @param txtJyushintime txtJyushintime
     */
    @JsonProperty("txtJyushintime")
    public void setTxtJyushintime(TextBoxTime txtJyushintime) {
        this.txtJyushintime = txtJyushintime;
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
     * gettxtJyushinbasho
     * @return txtJyushinbasho
     */
    @JsonProperty("txtJyushinbasho")
    public TextBox getTxtJyushinbasho() {
        return txtJyushinbasho;
    }

    /*
     * settxtJyushinbasho
     * @param txtJyushinbasho txtJyushinbasho
     */
    @JsonProperty("txtJyushinbasho")
    public void setTxtJyushinbasho(TextBox txtJyushinbasho) {
        this.txtJyushinbasho = txtJyushinbasho;
    }

    // </editor-fold>
}
