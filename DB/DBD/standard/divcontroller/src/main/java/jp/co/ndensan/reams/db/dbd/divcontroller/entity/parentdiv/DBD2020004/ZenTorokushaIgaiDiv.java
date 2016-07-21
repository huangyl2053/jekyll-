package jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD2020004;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * ZenTorokushaIgai のクラスファイル 
 * 
 * @author 自動生成
 */
public class ZenTorokushaIgaiDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-03-22_14-06-37">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("chkTsuchishoMihakko")
    private CheckBoxList chkTsuchishoMihakko;
    @JsonProperty("chkGengakuTekiyochuSha")
    private CheckBoxList chkGengakuTekiyochuSha;
    @JsonProperty("txtGengakuTekiyoChushaKijunDate")
    private TextBoxDate txtGengakuTekiyoChushaKijunDate;
    @JsonProperty("chkGengakuShuryoDate")
    private CheckBoxList chkGengakuShuryoDate;
    @JsonProperty("txtGengakuShuryoRange")
    private TextBoxDateRange txtGengakuShuryoRange;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getchkTsuchishoMihakko
     * @return chkTsuchishoMihakko
     */
    @JsonProperty("chkTsuchishoMihakko")
    public CheckBoxList getChkTsuchishoMihakko() {
        return chkTsuchishoMihakko;
    }

    /*
     * setchkTsuchishoMihakko
     * @param chkTsuchishoMihakko chkTsuchishoMihakko
     */
    @JsonProperty("chkTsuchishoMihakko")
    public void setChkTsuchishoMihakko(CheckBoxList chkTsuchishoMihakko) {
        this.chkTsuchishoMihakko = chkTsuchishoMihakko;
    }

    /*
     * getchkGengakuTekiyochuSha
     * @return chkGengakuTekiyochuSha
     */
    @JsonProperty("chkGengakuTekiyochuSha")
    public CheckBoxList getChkGengakuTekiyochuSha() {
        return chkGengakuTekiyochuSha;
    }

    /*
     * setchkGengakuTekiyochuSha
     * @param chkGengakuTekiyochuSha chkGengakuTekiyochuSha
     */
    @JsonProperty("chkGengakuTekiyochuSha")
    public void setChkGengakuTekiyochuSha(CheckBoxList chkGengakuTekiyochuSha) {
        this.chkGengakuTekiyochuSha = chkGengakuTekiyochuSha;
    }

    /*
     * gettxtGengakuTekiyoChushaKijunDate
     * @return txtGengakuTekiyoChushaKijunDate
     */
    @JsonProperty("txtGengakuTekiyoChushaKijunDate")
    public TextBoxDate getTxtGengakuTekiyoChushaKijunDate() {
        return txtGengakuTekiyoChushaKijunDate;
    }

    /*
     * settxtGengakuTekiyoChushaKijunDate
     * @param txtGengakuTekiyoChushaKijunDate txtGengakuTekiyoChushaKijunDate
     */
    @JsonProperty("txtGengakuTekiyoChushaKijunDate")
    public void setTxtGengakuTekiyoChushaKijunDate(TextBoxDate txtGengakuTekiyoChushaKijunDate) {
        this.txtGengakuTekiyoChushaKijunDate = txtGengakuTekiyoChushaKijunDate;
    }

    /*
     * getchkGengakuShuryoDate
     * @return chkGengakuShuryoDate
     */
    @JsonProperty("chkGengakuShuryoDate")
    public CheckBoxList getChkGengakuShuryoDate() {
        return chkGengakuShuryoDate;
    }

    /*
     * setchkGengakuShuryoDate
     * @param chkGengakuShuryoDate chkGengakuShuryoDate
     */
    @JsonProperty("chkGengakuShuryoDate")
    public void setChkGengakuShuryoDate(CheckBoxList chkGengakuShuryoDate) {
        this.chkGengakuShuryoDate = chkGengakuShuryoDate;
    }

    /*
     * gettxtGengakuShuryoRange
     * @return txtGengakuShuryoRange
     */
    @JsonProperty("txtGengakuShuryoRange")
    public TextBoxDateRange getTxtGengakuShuryoRange() {
        return txtGengakuShuryoRange;
    }

    /*
     * settxtGengakuShuryoRange
     * @param txtGengakuShuryoRange txtGengakuShuryoRange
     */
    @JsonProperty("txtGengakuShuryoRange")
    public void setTxtGengakuShuryoRange(TextBoxDateRange txtGengakuShuryoRange) {
        this.txtGengakuShuryoRange = txtGengakuShuryoRange;
    }

    // </editor-fold>
}
