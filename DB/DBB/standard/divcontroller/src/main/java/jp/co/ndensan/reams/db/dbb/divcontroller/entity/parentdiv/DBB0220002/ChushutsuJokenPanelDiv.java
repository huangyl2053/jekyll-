package jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB0220002;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.CheckBoxList;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDateRange;

/**
 * ChushutsuJokenPanel のクラスファイル
 *
 * @reamsid_L DBB-1901-010 surun
 */
public class ChushutsuJokenPanelDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtChushutsuKikan")
    private TextBoxDateRange txtChushutsuKikan;
    @JsonProperty("chkKazeiKubunGenmenMae")
    private CheckBoxList chkKazeiKubunGenmenMae;
    @JsonProperty("chkKazeiKubunGenmenGo")
    private CheckBoxList chkKazeiKubunGenmenGo;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtChushutsuKikan
     * @return txtChushutsuKikan
     */
    @JsonProperty("txtChushutsuKikan")
    public TextBoxDateRange getTxtChushutsuKikan() {
        return txtChushutsuKikan;
    }

    /*
     * settxtChushutsuKikan
     * @param txtChushutsuKikan txtChushutsuKikan
     */
    @JsonProperty("txtChushutsuKikan")
    public void setTxtChushutsuKikan(TextBoxDateRange txtChushutsuKikan) {
        this.txtChushutsuKikan = txtChushutsuKikan;
    }

    /*
     * getchkKazeiKubunGenmenMae
     * @return chkKazeiKubunGenmenMae
     */
    @JsonProperty("chkKazeiKubunGenmenMae")
    public CheckBoxList getChkKazeiKubunGenmenMae() {
        return chkKazeiKubunGenmenMae;
    }

    /*
     * setchkKazeiKubunGenmenMae
     * @param chkKazeiKubunGenmenMae chkKazeiKubunGenmenMae
     */
    @JsonProperty("chkKazeiKubunGenmenMae")
    public void setChkKazeiKubunGenmenMae(CheckBoxList chkKazeiKubunGenmenMae) {
        this.chkKazeiKubunGenmenMae = chkKazeiKubunGenmenMae;
    }

    /*
     * getchkKazeiKubunGenmenGo
     * @return chkKazeiKubunGenmenGo
     */
    @JsonProperty("chkKazeiKubunGenmenGo")
    public CheckBoxList getChkKazeiKubunGenmenGo() {
        return chkKazeiKubunGenmenGo;
    }

    /*
     * setchkKazeiKubunGenmenGo
     * @param chkKazeiKubunGenmenGo chkKazeiKubunGenmenGo
     */
    @JsonProperty("chkKazeiKubunGenmenGo")
    public void setChkKazeiKubunGenmenGo(CheckBoxList chkKazeiKubunGenmenGo) {
        this.chkKazeiKubunGenmenGo = chkKazeiKubunGenmenGo;
    }

    // </editor-fold>
}
