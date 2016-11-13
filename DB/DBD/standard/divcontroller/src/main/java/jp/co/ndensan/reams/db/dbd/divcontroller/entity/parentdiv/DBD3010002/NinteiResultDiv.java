package jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD3010002;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * NinteiResult のクラスファイル 
 * 
 * @author 自動生成
 */
public class NinteiResultDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-10-17_21-01-54">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("TxtToshoYukokikan")
    private TextBoxDateRange TxtToshoYukokikan;
    @JsonProperty("txtHakkoDate1")
    private TextBoxFlexibleDate txtHakkoDate1;
    @JsonProperty("txtHakkoDate2")
    private TextBoxFlexibleDate txtHakkoDate2;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getTxtToshoYukokikan
     * @return TxtToshoYukokikan
     */
    @JsonProperty("TxtToshoYukokikan")
    public TextBoxDateRange getTxtToshoYukokikan() {
        return TxtToshoYukokikan;
    }

    /*
     * setTxtToshoYukokikan
     * @param TxtToshoYukokikan TxtToshoYukokikan
     */
    @JsonProperty("TxtToshoYukokikan")
    public void setTxtToshoYukokikan(TextBoxDateRange TxtToshoYukokikan) {
        this.TxtToshoYukokikan = TxtToshoYukokikan;
    }

    /*
     * gettxtHakkoDate1
     * @return txtHakkoDate1
     */
    @JsonProperty("txtHakkoDate1")
    public TextBoxFlexibleDate getTxtHakkoDate1() {
        return txtHakkoDate1;
    }

    /*
     * settxtHakkoDate1
     * @param txtHakkoDate1 txtHakkoDate1
     */
    @JsonProperty("txtHakkoDate1")
    public void setTxtHakkoDate1(TextBoxFlexibleDate txtHakkoDate1) {
        this.txtHakkoDate1 = txtHakkoDate1;
    }

    /*
     * gettxtHakkoDate2
     * @return txtHakkoDate2
     */
    @JsonProperty("txtHakkoDate2")
    public TextBoxFlexibleDate getTxtHakkoDate2() {
        return txtHakkoDate2;
    }

    /*
     * settxtHakkoDate2
     * @param txtHakkoDate2 txtHakkoDate2
     */
    @JsonProperty("txtHakkoDate2")
    public void setTxtHakkoDate2(TextBoxFlexibleDate txtHakkoDate2) {
        this.txtHakkoDate2 = txtHakkoDate2;
    }

    // </editor-fold>
}
