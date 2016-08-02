package jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD5610001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.PanelBatchParameter;

/**
 * KoshinTaishoshaKanri のクラスファイル 
 * 
 * @author 自動生成
 */
public class KoshinTaishoshaKanriDiv extends PanelBatchParameter {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-06-27_21-36-36">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("SelectJoken")
    private SelectJokenDiv SelectJoken;
    @JsonProperty("ZenkaiJoho")
    private ZenkaiJohoDiv ZenkaiJoho;
    @JsonProperty("YukoKikanSelect")
    private YukoKikanSelectDiv YukoKikanSelect;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getSelectJoken
     * @return SelectJoken
     */
    @JsonProperty("SelectJoken")
    public SelectJokenDiv getSelectJoken() {
        return SelectJoken;
    }

    /*
     * setSelectJoken
     * @param SelectJoken SelectJoken
     */
    @JsonProperty("SelectJoken")
    public void setSelectJoken(SelectJokenDiv SelectJoken) {
        this.SelectJoken = SelectJoken;
    }

    /*
     * getZenkaiJoho
     * @return ZenkaiJoho
     */
    @JsonProperty("ZenkaiJoho")
    public ZenkaiJohoDiv getZenkaiJoho() {
        return ZenkaiJoho;
    }

    /*
     * setZenkaiJoho
     * @param ZenkaiJoho ZenkaiJoho
     */
    @JsonProperty("ZenkaiJoho")
    public void setZenkaiJoho(ZenkaiJohoDiv ZenkaiJoho) {
        this.ZenkaiJoho = ZenkaiJoho;
    }

    /*
     * getYukoKikanSelect
     * @return YukoKikanSelect
     */
    @JsonProperty("YukoKikanSelect")
    public YukoKikanSelectDiv getYukoKikanSelect() {
        return YukoKikanSelect;
    }

    /*
     * setYukoKikanSelect
     * @param YukoKikanSelect YukoKikanSelect
     */
    @JsonProperty("YukoKikanSelect")
    public void setYukoKikanSelect(YukoKikanSelectDiv YukoKikanSelect) {
        this.YukoKikanSelect = YukoKikanSelect;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public TextBoxDateRange getTxtYukokikanSelect() {
        return this.getYukoKikanSelect().getTxtYukokikanSelect();
    }

    @JsonIgnore
    public void  setTxtYukokikanSelect(TextBoxDateRange txtYukokikanSelect) {
        this.getYukoKikanSelect().setTxtYukokikanSelect(txtYukokikanSelect);
    }

    // </editor-fold>
}
