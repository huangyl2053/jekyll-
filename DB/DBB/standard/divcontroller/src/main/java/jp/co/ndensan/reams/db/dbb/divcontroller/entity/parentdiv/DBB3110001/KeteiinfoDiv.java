package jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB3110001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.RadioButton;
import jp.co.ndensan.reams.uz.uza.ui.binding.Space;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxFlexibleDate;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxMultiLine;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxNum;

/**
 * Keteiinfo のクラスファイル
 *
 * @reamsid_L DBB-1660-010 gongliang
 */
public class KeteiinfoDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-07-28_11-34-20">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtKetteiYMD")
    private TextBoxFlexibleDate txtKetteiYMD;
    @JsonProperty("txtZenkaiGemmengaku")
    private TextBoxNum txtZenkaiGemmengaku;
    @JsonProperty("radKetteiKubun")
    private RadioButton radKetteiKubun;
    @JsonProperty("txtKetteiRiyu")
    private TextBoxMultiLine txtKetteiRiyu;
    @JsonProperty("spaKetteiJoho")
    private Space spaKetteiJoho;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtKetteiYMD
     * @return txtKetteiYMD
     */
    @JsonProperty("txtKetteiYMD")
    public TextBoxFlexibleDate getTxtKetteiYMD() {
        return txtKetteiYMD;
    }

    /*
     * settxtKetteiYMD
     * @param txtKetteiYMD txtKetteiYMD
     */
    @JsonProperty("txtKetteiYMD")
    public void setTxtKetteiYMD(TextBoxFlexibleDate txtKetteiYMD) {
        this.txtKetteiYMD = txtKetteiYMD;
    }

    /*
     * gettxtZenkaiGemmengaku
     * @return txtZenkaiGemmengaku
     */
    @JsonProperty("txtZenkaiGemmengaku")
    public TextBoxNum getTxtZenkaiGemmengaku() {
        return txtZenkaiGemmengaku;
    }

    /*
     * settxtZenkaiGemmengaku
     * @param txtZenkaiGemmengaku txtZenkaiGemmengaku
     */
    @JsonProperty("txtZenkaiGemmengaku")
    public void setTxtZenkaiGemmengaku(TextBoxNum txtZenkaiGemmengaku) {
        this.txtZenkaiGemmengaku = txtZenkaiGemmengaku;
    }

    /*
     * getradKetteiKubun
     * @return radKetteiKubun
     */
    @JsonProperty("radKetteiKubun")
    public RadioButton getRadKetteiKubun() {
        return radKetteiKubun;
    }

    /*
     * setradKetteiKubun
     * @param radKetteiKubun radKetteiKubun
     */
    @JsonProperty("radKetteiKubun")
    public void setRadKetteiKubun(RadioButton radKetteiKubun) {
        this.radKetteiKubun = radKetteiKubun;
    }

    /*
     * gettxtKetteiRiyu
     * @return txtKetteiRiyu
     */
    @JsonProperty("txtKetteiRiyu")
    public TextBoxMultiLine getTxtKetteiRiyu() {
        return txtKetteiRiyu;
    }

    /*
     * settxtKetteiRiyu
     * @param txtKetteiRiyu txtKetteiRiyu
     */
    @JsonProperty("txtKetteiRiyu")
    public void setTxtKetteiRiyu(TextBoxMultiLine txtKetteiRiyu) {
        this.txtKetteiRiyu = txtKetteiRiyu;
    }

    /*
     * getspaKetteiJoho
     * @return spaKetteiJoho
     */
    @JsonProperty("spaKetteiJoho")
    public Space getSpaKetteiJoho() {
        return spaKetteiJoho;
    }

    /*
     * setspaKetteiJoho
     * @param spaKetteiJoho spaKetteiJoho
     */
    @JsonProperty("spaKetteiJoho")
    public void setSpaKetteiJoho(Space spaKetteiJoho) {
        this.spaKetteiJoho = spaKetteiJoho;
    }

    // </editor-fold>
}
