package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.hanyolistatenaselect.HanyoListAtenaSelect;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * dvKensakuJoken のクラスファイル 
 * 
 * @author 自動生成
 */
public class dvKensakuJokenDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-06-27_21-36-36">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtNenrei")
    private TextBoxNumRange txtNenrei;
    @JsonProperty("txtNenreiKijunbi")
    private TextBoxDate txtNenreiKijunbi;
    @JsonProperty("txtSeinengappi")
    private TextBoxDateRange txtSeinengappi;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtNenrei
     * @return txtNenrei
     */
    @JsonProperty("txtNenrei")
    public TextBoxNumRange getTxtNenrei() {
        return txtNenrei;
    }

    /*
     * settxtNenrei
     * @param txtNenrei txtNenrei
     */
    @JsonProperty("txtNenrei")
    public void setTxtNenrei(TextBoxNumRange txtNenrei) {
        this.txtNenrei = txtNenrei;
    }

    /*
     * gettxtNenreiKijunbi
     * @return txtNenreiKijunbi
     */
    @JsonProperty("txtNenreiKijunbi")
    public TextBoxDate getTxtNenreiKijunbi() {
        return txtNenreiKijunbi;
    }

    /*
     * settxtNenreiKijunbi
     * @param txtNenreiKijunbi txtNenreiKijunbi
     */
    @JsonProperty("txtNenreiKijunbi")
    public void setTxtNenreiKijunbi(TextBoxDate txtNenreiKijunbi) {
        this.txtNenreiKijunbi = txtNenreiKijunbi;
    }

    /*
     * gettxtSeinengappi
     * @return txtSeinengappi
     */
    @JsonProperty("txtSeinengappi")
    public TextBoxDateRange getTxtSeinengappi() {
        return txtSeinengappi;
    }

    /*
     * settxtSeinengappi
     * @param txtSeinengappi txtSeinengappi
     */
    @JsonProperty("txtSeinengappi")
    public void setTxtSeinengappi(TextBoxDateRange txtSeinengappi) {
        this.txtSeinengappi = txtSeinengappi;
    }

    // </editor-fold>
}
