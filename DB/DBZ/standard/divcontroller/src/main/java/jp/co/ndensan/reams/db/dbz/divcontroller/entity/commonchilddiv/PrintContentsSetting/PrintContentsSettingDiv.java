package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.PrintContentsSetting;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;

/**
 * PrintContentsSetting のクラスファイル
 *
 * @reamsid_L DBZ-4500-010 chengsanyuan
 */
public class PrintContentsSettingDiv extends Panel implements IPrintContentsSettingDiv {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-01-15_09-59-03">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtIssueDate")
    private TextBoxDate txtIssueDate;
    @JsonProperty("txtSendDate")
    private TextBoxDate txtSendDate;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtIssueDate
     * @return txtIssueDate
     */
    @JsonProperty("txtIssueDate")
    public TextBoxDate getTxtIssueDate() {
        return txtIssueDate;
    }

    /*
     * settxtIssueDate
     * @param txtIssueDate txtIssueDate
     */
    @JsonProperty("txtIssueDate")
    public void setTxtIssueDate(TextBoxDate txtIssueDate) {
        this.txtIssueDate = txtIssueDate;
    }

    /*
     * gettxtSendDate
     * @return txtSendDate
     */
    @JsonProperty("txtSendDate")
    public TextBoxDate getTxtSendDate() {
        return txtSendDate;
    }

    /*
     * settxtSendDate
     * @param txtSendDate txtSendDate
     */
    @JsonProperty("txtSendDate")
    public void setTxtSendDate(TextBoxDate txtSendDate) {
        this.txtSendDate = txtSendDate;
    }

    // </editor-fold>
    //--------------- この行より下にコードを追加してください -------------------
    /**
     * 印刷設定に初期化を設定します。
     *
     * @param 発行日表示有無 boolean
     * @param 発行日初期表示日付 RDate
     * @param 発行日システム日付有無 boolean
     * @param 送付日表示有無 boolean
     * @param 送付日初期表示日付 RDate
     * @param 送付日システム日付有無 boolean
     */
    @Override
    @JsonIgnore
    public void initialize(boolean 発行日表示有無, RDate 発行日初期表示日付,
            boolean 発行日システム日付有無, boolean 送付日表示有無,
            RDate 送付日初期表示日付, boolean 送付日システム日付有無) {
        createHandler().initialize(発行日表示有無, 発行日初期表示日付,
                発行日システム日付有無, 送付日表示有無,
                送付日初期表示日付, 送付日システム日付有無);
    }

    @JsonIgnore
    private PrintContentsSettingHandler createHandler() {
        return new PrintContentsSettingHandler(this);
    }

    /**
     * 発行日を取得します。
     *
     * @return RDate
     */
    @Override
    public RDate getIssueDate() {
        return this.getTxtIssueDate().getValue();
    }

    /**
     * 送付日を取得します。
     *
     * @return RDate
     */
    @Override
    public RDate getSendDate() {
        return this.getTxtSendDate().getValue();
    }

    /**
     * 送付日の活性を設します。
     *
     * @param flag True:非活性　False:活性
     */
    @Override
    public void setSendDateDisable(boolean flag) {
        this.getTxtSendDate().setDisabled(flag);
    }
}
