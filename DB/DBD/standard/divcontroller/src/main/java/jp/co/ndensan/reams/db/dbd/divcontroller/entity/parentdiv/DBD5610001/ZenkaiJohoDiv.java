package jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD5610001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * ZenkaiJoho のクラスファイル 
 * 
 * @author 自動生成
 */
public class ZenkaiJohoDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-06-27_21-36-36">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtZenkaiShoriYukokikan")
    private TextBoxDate txtZenkaiShoriYukokikan;
    @JsonProperty("txtZenkaiShoriDate")
    private TextBoxDate txtZenkaiShoriDate;
    @JsonProperty("txtTaishoTsuki")
    private TextBoxDate txtTaishoTsuki;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtZenkaiShoriYukokikan
     * @return txtZenkaiShoriYukokikan
     */
    @JsonProperty("txtZenkaiShoriYukokikan")
    public TextBoxDate getTxtZenkaiShoriYukokikan() {
        return txtZenkaiShoriYukokikan;
    }

    /*
     * settxtZenkaiShoriYukokikan
     * @param txtZenkaiShoriYukokikan txtZenkaiShoriYukokikan
     */
    @JsonProperty("txtZenkaiShoriYukokikan")
    public void setTxtZenkaiShoriYukokikan(TextBoxDate txtZenkaiShoriYukokikan) {
        this.txtZenkaiShoriYukokikan = txtZenkaiShoriYukokikan;
    }

    /*
     * gettxtZenkaiShoriDate
     * @return txtZenkaiShoriDate
     */
    @JsonProperty("txtZenkaiShoriDate")
    public TextBoxDate getTxtZenkaiShoriDate() {
        return txtZenkaiShoriDate;
    }

    /*
     * settxtZenkaiShoriDate
     * @param txtZenkaiShoriDate txtZenkaiShoriDate
     */
    @JsonProperty("txtZenkaiShoriDate")
    public void setTxtZenkaiShoriDate(TextBoxDate txtZenkaiShoriDate) {
        this.txtZenkaiShoriDate = txtZenkaiShoriDate;
    }

    /*
     * gettxtTaishoTsuki
     * @return txtTaishoTsuki
     */
    @JsonProperty("txtTaishoTsuki")
    public TextBoxDate getTxtTaishoTsuki() {
        return txtTaishoTsuki;
    }

    /*
     * settxtTaishoTsuki
     * @param txtTaishoTsuki txtTaishoTsuki
     */
    @JsonProperty("txtTaishoTsuki")
    public void setTxtTaishoTsuki(TextBoxDate txtTaishoTsuki) {
        this.txtTaishoTsuki = txtTaishoTsuki;
    }

    // </editor-fold>
}
