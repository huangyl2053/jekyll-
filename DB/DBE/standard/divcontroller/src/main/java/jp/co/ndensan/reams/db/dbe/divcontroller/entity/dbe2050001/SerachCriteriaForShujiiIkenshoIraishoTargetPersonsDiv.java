package jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe2050001;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * SerachCriteriaForShujiiIkenshoIraishoTargetPersons のクラスファイル 
 * 
 * @author 自動生成
 */
public class SerachCriteriaForShujiiIkenshoIraishoTargetPersonsDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtSakuseiIraiDateRange")
    private TextBoxDateRange txtSakuseiIraiDateRange;
    @JsonProperty("txtShinseiDateRangeOfIkensho")
    private TextBoxDateRange txtShinseiDateRangeOfIkensho;
    @JsonProperty("chkIkenshoIraishoHakkoExistence")
    private CheckBoxList chkIkenshoIraishoHakkoExistence;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("txtSakuseiIraiDateRange")
    public TextBoxDateRange getTxtSakuseiIraiDateRange() {
        return txtSakuseiIraiDateRange;
    }

    @JsonProperty("txtSakuseiIraiDateRange")
    public void setTxtSakuseiIraiDateRange(TextBoxDateRange txtSakuseiIraiDateRange) {
        this.txtSakuseiIraiDateRange=txtSakuseiIraiDateRange;
    }

    @JsonProperty("txtShinseiDateRangeOfIkensho")
    public TextBoxDateRange getTxtShinseiDateRangeOfIkensho() {
        return txtShinseiDateRangeOfIkensho;
    }

    @JsonProperty("txtShinseiDateRangeOfIkensho")
    public void setTxtShinseiDateRangeOfIkensho(TextBoxDateRange txtShinseiDateRangeOfIkensho) {
        this.txtShinseiDateRangeOfIkensho=txtShinseiDateRangeOfIkensho;
    }

    @JsonProperty("chkIkenshoIraishoHakkoExistence")
    public CheckBoxList getChkIkenshoIraishoHakkoExistence() {
        return chkIkenshoIraishoHakkoExistence;
    }

    @JsonProperty("chkIkenshoIraishoHakkoExistence")
    public void setChkIkenshoIraishoHakkoExistence(CheckBoxList chkIkenshoIraishoHakkoExistence) {
        this.chkIkenshoIraishoHakkoExistence=chkIkenshoIraishoHakkoExistence;
    }

}
