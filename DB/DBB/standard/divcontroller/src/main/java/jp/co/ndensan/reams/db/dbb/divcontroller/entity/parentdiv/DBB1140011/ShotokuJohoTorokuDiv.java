package jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB1140011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.ui.binding.DropDownList;
import jp.co.ndensan.reams.uz.uza.ui.binding.Label;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxNum;

/**
 * ShotokuJohoToroku のクラスファイル
 *
 * @reamsid_L DBB-1750-010 zhangrui
 */
public class ShotokuJohoTorokuDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-03-22_14-06-37">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("lblJuminZeiHikazeiKbn")
    private Label lblJuminZeiHikazeiKbn;
    @JsonProperty("ddlJuminzeiGenmenMae")
    private DropDownList ddlJuminzeiGenmenMae;
    @JsonProperty("ddlJuminzeiGenmenAto")
    private DropDownList ddlJuminzeiGenmenAto;
    @JsonProperty("ddlJuminzei")
    private DropDownList ddlJuminzei;
    @JsonProperty("ddlGekihenKanwa")
    private DropDownList ddlGekihenKanwa;
    @JsonProperty("txtGokeiShotokuGaku")
    private TextBoxNum txtGokeiShotokuGaku;
    @JsonProperty("txtNenkinShunyuGaku")
    private TextBoxNum txtNenkinShunyuGaku;
    @JsonProperty("txtNenkinShotokuGaku")
    private TextBoxNum txtNenkinShotokuGaku;
    @JsonProperty("txtKazeiShotokuGaku")
    private TextBoxNum txtKazeiShotokuGaku;
    @JsonProperty("btnKakutei")
    private Button btnKakutei;
    @JsonProperty("btnTorikeshi")
    private Button btnTorikeshi;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getlblJuminZeiHikazeiKbn
     * @return lblJuminZeiHikazeiKbn
     */
    @JsonProperty("lblJuminZeiHikazeiKbn")
    public Label getLblJuminZeiHikazeiKbn() {
        return lblJuminZeiHikazeiKbn;
    }

    /*
     * setlblJuminZeiHikazeiKbn
     * @param lblJuminZeiHikazeiKbn lblJuminZeiHikazeiKbn
     */
    @JsonProperty("lblJuminZeiHikazeiKbn")
    public void setLblJuminZeiHikazeiKbn(Label lblJuminZeiHikazeiKbn) {
        this.lblJuminZeiHikazeiKbn = lblJuminZeiHikazeiKbn;
    }

    /*
     * getddlJuminzeiGenmenMae
     * @return ddlJuminzeiGenmenMae
     */
    @JsonProperty("ddlJuminzeiGenmenMae")
    public DropDownList getDdlJuminzeiGenmenMae() {
        return ddlJuminzeiGenmenMae;
    }

    /*
     * setddlJuminzeiGenmenMae
     * @param ddlJuminzeiGenmenMae ddlJuminzeiGenmenMae
     */
    @JsonProperty("ddlJuminzeiGenmenMae")
    public void setDdlJuminzeiGenmenMae(DropDownList ddlJuminzeiGenmenMae) {
        this.ddlJuminzeiGenmenMae = ddlJuminzeiGenmenMae;
    }

    /*
     * getddlJuminzeiGenmenAto
     * @return ddlJuminzeiGenmenAto
     */
    @JsonProperty("ddlJuminzeiGenmenAto")
    public DropDownList getDdlJuminzeiGenmenAto() {
        return ddlJuminzeiGenmenAto;
    }

    /*
     * setddlJuminzeiGenmenAto
     * @param ddlJuminzeiGenmenAto ddlJuminzeiGenmenAto
     */
    @JsonProperty("ddlJuminzeiGenmenAto")
    public void setDdlJuminzeiGenmenAto(DropDownList ddlJuminzeiGenmenAto) {
        this.ddlJuminzeiGenmenAto = ddlJuminzeiGenmenAto;
    }

    /*
     * getddlJuminzei
     * @return ddlJuminzei
     */
    @JsonProperty("ddlJuminzei")
    public DropDownList getDdlJuminzei() {
        return ddlJuminzei;
    }

    /*
     * setddlJuminzei
     * @param ddlJuminzei ddlJuminzei
     */
    @JsonProperty("ddlJuminzei")
    public void setDdlJuminzei(DropDownList ddlJuminzei) {
        this.ddlJuminzei = ddlJuminzei;
    }

    /*
     * getddlGekihenKanwa
     * @return ddlGekihenKanwa
     */
    @JsonProperty("ddlGekihenKanwa")
    public DropDownList getDdlGekihenKanwa() {
        return ddlGekihenKanwa;
    }

    /*
     * setddlGekihenKanwa
     * @param ddlGekihenKanwa ddlGekihenKanwa
     */
    @JsonProperty("ddlGekihenKanwa")
    public void setDdlGekihenKanwa(DropDownList ddlGekihenKanwa) {
        this.ddlGekihenKanwa = ddlGekihenKanwa;
    }

    /*
     * gettxtGokeiShotokuGaku
     * @return txtGokeiShotokuGaku
     */
    @JsonProperty("txtGokeiShotokuGaku")
    public TextBoxNum getTxtGokeiShotokuGaku() {
        return txtGokeiShotokuGaku;
    }

    /*
     * settxtGokeiShotokuGaku
     * @param txtGokeiShotokuGaku txtGokeiShotokuGaku
     */
    @JsonProperty("txtGokeiShotokuGaku")
    public void setTxtGokeiShotokuGaku(TextBoxNum txtGokeiShotokuGaku) {
        this.txtGokeiShotokuGaku = txtGokeiShotokuGaku;
    }

    /*
     * gettxtNenkinShunyuGaku
     * @return txtNenkinShunyuGaku
     */
    @JsonProperty("txtNenkinShunyuGaku")
    public TextBoxNum getTxtNenkinShunyuGaku() {
        return txtNenkinShunyuGaku;
    }

    /*
     * settxtNenkinShunyuGaku
     * @param txtNenkinShunyuGaku txtNenkinShunyuGaku
     */
    @JsonProperty("txtNenkinShunyuGaku")
    public void setTxtNenkinShunyuGaku(TextBoxNum txtNenkinShunyuGaku) {
        this.txtNenkinShunyuGaku = txtNenkinShunyuGaku;
    }

    /*
     * gettxtNenkinShotokuGaku
     * @return txtNenkinShotokuGaku
     */
    @JsonProperty("txtNenkinShotokuGaku")
    public TextBoxNum getTxtNenkinShotokuGaku() {
        return txtNenkinShotokuGaku;
    }

    /*
     * settxtNenkinShotokuGaku
     * @param txtNenkinShotokuGaku txtNenkinShotokuGaku
     */
    @JsonProperty("txtNenkinShotokuGaku")
    public void setTxtNenkinShotokuGaku(TextBoxNum txtNenkinShotokuGaku) {
        this.txtNenkinShotokuGaku = txtNenkinShotokuGaku;
    }

    /*
     * gettxtKazeiShotokuGaku
     * @return txtKazeiShotokuGaku
     */
    @JsonProperty("txtKazeiShotokuGaku")
    public TextBoxNum getTxtKazeiShotokuGaku() {
        return txtKazeiShotokuGaku;
    }

    /*
     * settxtKazeiShotokuGaku
     * @param txtKazeiShotokuGaku txtKazeiShotokuGaku
     */
    @JsonProperty("txtKazeiShotokuGaku")
    public void setTxtKazeiShotokuGaku(TextBoxNum txtKazeiShotokuGaku) {
        this.txtKazeiShotokuGaku = txtKazeiShotokuGaku;
    }

    /*
     * getbtnKakutei
     * @return btnKakutei
     */
    @JsonProperty("btnKakutei")
    public Button getBtnKakutei() {
        return btnKakutei;
    }

    /*
     * setbtnKakutei
     * @param btnKakutei btnKakutei
     */
    @JsonProperty("btnKakutei")
    public void setBtnKakutei(Button btnKakutei) {
        this.btnKakutei = btnKakutei;
    }

    /*
     * getbtnTorikeshi
     * @return btnTorikeshi
     */
    @JsonProperty("btnTorikeshi")
    public Button getBtnTorikeshi() {
        return btnTorikeshi;
    }

    /*
     * setbtnTorikeshi
     * @param btnTorikeshi btnTorikeshi
     */
    @JsonProperty("btnTorikeshi")
    public void setBtnTorikeshi(Button btnTorikeshi) {
        this.btnTorikeshi = btnTorikeshi;
    }

    // </editor-fold>
}
