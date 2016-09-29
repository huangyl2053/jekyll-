package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC4100011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.CheckBoxList;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.RadioButton;
import jp.co.ndensan.reams.uz.uza.ui.binding.Space;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBox;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;

/**
 * ShoriNaiyoDiv_サービスコード異動連絡票作成のクラスです。
 *
 * @reamsid_L DBC-4740-010 liuxiaoyu
 */
public class ShoriNaiyoDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("radShoriSentaku")
    private RadioButton radShoriSentaku;
    @JsonProperty("txtFuairuMei")
    private TextBox txtFuairuMei;
    @JsonProperty("txtShoriTaishoNengetsu")
    private TextBoxDate txtShoriTaishoNengetsu;
    @JsonProperty("Yohaku")
    private Space Yohaku;
    @JsonProperty("chkTogetsuSofuZumiFukumeru")
    private CheckBoxList chkTogetsuSofuZumiFukumeru;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getradShoriSentaku
     * @return radShoriSentaku
     */
    @JsonProperty("radShoriSentaku")
    public RadioButton getRadShoriSentaku() {
        return radShoriSentaku;
    }

    /*
     * setradShoriSentaku
     * @param radShoriSentaku radShoriSentaku
     */
    @JsonProperty("radShoriSentaku")
    public void setRadShoriSentaku(RadioButton radShoriSentaku) {
        this.radShoriSentaku = radShoriSentaku;
    }

    /*
     * gettxtFuairuMei
     * @return txtFuairuMei
     */
    @JsonProperty("txtFuairuMei")
    public TextBox getTxtFuairuMei() {
        return txtFuairuMei;
    }

    /*
     * settxtFuairuMei
     * @param txtFuairuMei txtFuairuMei
     */
    @JsonProperty("txtFuairuMei")
    public void setTxtFuairuMei(TextBox txtFuairuMei) {
        this.txtFuairuMei = txtFuairuMei;
    }

    /*
     * gettxtShoriTaishoNengetsu
     * @return txtShoriTaishoNengetsu
     */
    @JsonProperty("txtShoriTaishoNengetsu")
    public TextBoxDate getTxtShoriTaishoNengetsu() {
        return txtShoriTaishoNengetsu;
    }

    /*
     * settxtShoriTaishoNengetsu
     * @param txtShoriTaishoNengetsu txtShoriTaishoNengetsu
     */
    @JsonProperty("txtShoriTaishoNengetsu")
    public void setTxtShoriTaishoNengetsu(TextBoxDate txtShoriTaishoNengetsu) {
        this.txtShoriTaishoNengetsu = txtShoriTaishoNengetsu;
    }

    /*
     * getYohaku
     * @return Yohaku
     */
    @JsonProperty("Yohaku")
    public Space getYohaku() {
        return Yohaku;
    }

    /*
     * setYohaku
     * @param Yohaku Yohaku
     */
    @JsonProperty("Yohaku")
    public void setYohaku(Space Yohaku) {
        this.Yohaku = Yohaku;
    }

    /*
     * getchkTogetsuSofuZumiFukumeru
     * @return chkTogetsuSofuZumiFukumeru
     */
    @JsonProperty("chkTogetsuSofuZumiFukumeru")
    public CheckBoxList getChkTogetsuSofuZumiFukumeru() {
        return chkTogetsuSofuZumiFukumeru;
    }

    /*
     * setchkTogetsuSofuZumiFukumeru
     * @param chkTogetsuSofuZumiFukumeru chkTogetsuSofuZumiFukumeru
     */
    @JsonProperty("chkTogetsuSofuZumiFukumeru")
    public void setChkTogetsuSofuZumiFukumeru(CheckBoxList chkTogetsuSofuZumiFukumeru) {
        this.chkTogetsuSofuZumiFukumeru = chkTogetsuSofuZumiFukumeru;
    }

    // </editor-fold>
}
