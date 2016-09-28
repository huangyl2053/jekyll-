package jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD1010001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * YochokinJoho のクラスファイル 
 * 
 * @author 自動生成
 */
public class YochokinJohoDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("chkYochokinKijunIka")
    private CheckBoxList chkYochokinKijunIka;
    @JsonProperty("txtYochokinGaku")
    private TextBoxNum txtYochokinGaku;
    @JsonProperty("txtYukaShoken")
    private TextBoxNum txtYukaShoken;
    @JsonProperty("txtSonota")
    private TextBoxNum txtSonota;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getchkYochokinKijunIka
     * @return chkYochokinKijunIka
     */
    @JsonProperty("chkYochokinKijunIka")
    public CheckBoxList getChkYochokinKijunIka() {
        return chkYochokinKijunIka;
    }

    /*
     * setchkYochokinKijunIka
     * @param chkYochokinKijunIka chkYochokinKijunIka
     */
    @JsonProperty("chkYochokinKijunIka")
    public void setChkYochokinKijunIka(CheckBoxList chkYochokinKijunIka) {
        this.chkYochokinKijunIka = chkYochokinKijunIka;
    }

    /*
     * gettxtYochokinGaku
     * @return txtYochokinGaku
     */
    @JsonProperty("txtYochokinGaku")
    public TextBoxNum getTxtYochokinGaku() {
        return txtYochokinGaku;
    }

    /*
     * settxtYochokinGaku
     * @param txtYochokinGaku txtYochokinGaku
     */
    @JsonProperty("txtYochokinGaku")
    public void setTxtYochokinGaku(TextBoxNum txtYochokinGaku) {
        this.txtYochokinGaku = txtYochokinGaku;
    }

    /*
     * gettxtYukaShoken
     * @return txtYukaShoken
     */
    @JsonProperty("txtYukaShoken")
    public TextBoxNum getTxtYukaShoken() {
        return txtYukaShoken;
    }

    /*
     * settxtYukaShoken
     * @param txtYukaShoken txtYukaShoken
     */
    @JsonProperty("txtYukaShoken")
    public void setTxtYukaShoken(TextBoxNum txtYukaShoken) {
        this.txtYukaShoken = txtYukaShoken;
    }

    /*
     * gettxtSonota
     * @return txtSonota
     */
    @JsonProperty("txtSonota")
    public TextBoxNum getTxtSonota() {
        return txtSonota;
    }

    /*
     * settxtSonota
     * @param txtSonota txtSonota
     */
    @JsonProperty("txtSonota")
    public void setTxtSonota(TextBoxNum txtSonota) {
        this.txtSonota = txtSonota;
    }

    // </editor-fold>
}
