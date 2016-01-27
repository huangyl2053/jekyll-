package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5160001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * ShinsakaiJoho のクラスファイル 
 * 
 * @author 自動生成
 */
public class ShinsakaiJohoDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2015-11-30_08-54-50">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtShinsakaiName")
    private TextBox txtShinsakaiName;
    @JsonProperty("txtGogitaiNumber")
    private TextBox txtGogitaiNumber;
    @JsonProperty("txtYoteiTeiin")
    private TextBoxNum txtYoteiTeiin;
    @JsonProperty("txtWaritsukeNinzu")
    private TextBoxNum txtWaritsukeNinzu;
    @JsonProperty("txtStatus")
    private TextBox txtStatus;
    @JsonProperty("txtShinsakaiKaijo")
    private TextBox txtShinsakaiKaijo;
    @JsonProperty("txtShinsakaiChiku")
    private TextBox txtShinsakaiChiku;
    @JsonProperty("txtShinsakauChikuName")
    private TextBox txtShinsakauChikuName;
    @JsonProperty("txtKaisaiDate")
    private TextBoxFlexibleDate txtKaisaiDate;
    @JsonProperty("txtYoteiKaishiTime")
    private TextBoxTime txtYoteiKaishiTime;
    @JsonProperty("txtYoteiShuryoTime")
    private TextBoxTime txtYoteiShuryoTime;
    @JsonProperty("chkNinchishoOnly")
    private CheckBoxList chkNinchishoOnly;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtShinsakaiName
     * @return txtShinsakaiName
     */
    @JsonProperty("txtShinsakaiName")
    public TextBox getTxtShinsakaiName() {
        return txtShinsakaiName;
    }

    /*
     * settxtShinsakaiName
     * @param txtShinsakaiName txtShinsakaiName
     */
    @JsonProperty("txtShinsakaiName")
    public void setTxtShinsakaiName(TextBox txtShinsakaiName) {
        this.txtShinsakaiName = txtShinsakaiName;
    }

    /*
     * gettxtGogitaiNumber
     * @return txtGogitaiNumber
     */
    @JsonProperty("txtGogitaiNumber")
    public TextBox getTxtGogitaiNumber() {
        return txtGogitaiNumber;
    }

    /*
     * settxtGogitaiNumber
     * @param txtGogitaiNumber txtGogitaiNumber
     */
    @JsonProperty("txtGogitaiNumber")
    public void setTxtGogitaiNumber(TextBox txtGogitaiNumber) {
        this.txtGogitaiNumber = txtGogitaiNumber;
    }

    /*
     * gettxtYoteiTeiin
     * @return txtYoteiTeiin
     */
    @JsonProperty("txtYoteiTeiin")
    public TextBoxNum getTxtYoteiTeiin() {
        return txtYoteiTeiin;
    }

    /*
     * settxtYoteiTeiin
     * @param txtYoteiTeiin txtYoteiTeiin
     */
    @JsonProperty("txtYoteiTeiin")
    public void setTxtYoteiTeiin(TextBoxNum txtYoteiTeiin) {
        this.txtYoteiTeiin = txtYoteiTeiin;
    }

    /*
     * gettxtWaritsukeNinzu
     * @return txtWaritsukeNinzu
     */
    @JsonProperty("txtWaritsukeNinzu")
    public TextBoxNum getTxtWaritsukeNinzu() {
        return txtWaritsukeNinzu;
    }

    /*
     * settxtWaritsukeNinzu
     * @param txtWaritsukeNinzu txtWaritsukeNinzu
     */
    @JsonProperty("txtWaritsukeNinzu")
    public void setTxtWaritsukeNinzu(TextBoxNum txtWaritsukeNinzu) {
        this.txtWaritsukeNinzu = txtWaritsukeNinzu;
    }

    /*
     * gettxtStatus
     * @return txtStatus
     */
    @JsonProperty("txtStatus")
    public TextBox getTxtStatus() {
        return txtStatus;
    }

    /*
     * settxtStatus
     * @param txtStatus txtStatus
     */
    @JsonProperty("txtStatus")
    public void setTxtStatus(TextBox txtStatus) {
        this.txtStatus = txtStatus;
    }

    /*
     * gettxtShinsakaiKaijo
     * @return txtShinsakaiKaijo
     */
    @JsonProperty("txtShinsakaiKaijo")
    public TextBox getTxtShinsakaiKaijo() {
        return txtShinsakaiKaijo;
    }

    /*
     * settxtShinsakaiKaijo
     * @param txtShinsakaiKaijo txtShinsakaiKaijo
     */
    @JsonProperty("txtShinsakaiKaijo")
    public void setTxtShinsakaiKaijo(TextBox txtShinsakaiKaijo) {
        this.txtShinsakaiKaijo = txtShinsakaiKaijo;
    }

    /*
     * gettxtShinsakaiChiku
     * @return txtShinsakaiChiku
     */
    @JsonProperty("txtShinsakaiChiku")
    public TextBox getTxtShinsakaiChiku() {
        return txtShinsakaiChiku;
    }

    /*
     * settxtShinsakaiChiku
     * @param txtShinsakaiChiku txtShinsakaiChiku
     */
    @JsonProperty("txtShinsakaiChiku")
    public void setTxtShinsakaiChiku(TextBox txtShinsakaiChiku) {
        this.txtShinsakaiChiku = txtShinsakaiChiku;
    }

    /*
     * gettxtShinsakauChikuName
     * @return txtShinsakauChikuName
     */
    @JsonProperty("txtShinsakauChikuName")
    public TextBox getTxtShinsakauChikuName() {
        return txtShinsakauChikuName;
    }

    /*
     * settxtShinsakauChikuName
     * @param txtShinsakauChikuName txtShinsakauChikuName
     */
    @JsonProperty("txtShinsakauChikuName")
    public void setTxtShinsakauChikuName(TextBox txtShinsakauChikuName) {
        this.txtShinsakauChikuName = txtShinsakauChikuName;
    }

    /*
     * gettxtKaisaiDate
     * @return txtKaisaiDate
     */
    @JsonProperty("txtKaisaiDate")
    public TextBoxFlexibleDate getTxtKaisaiDate() {
        return txtKaisaiDate;
    }

    /*
     * settxtKaisaiDate
     * @param txtKaisaiDate txtKaisaiDate
     */
    @JsonProperty("txtKaisaiDate")
    public void setTxtKaisaiDate(TextBoxFlexibleDate txtKaisaiDate) {
        this.txtKaisaiDate = txtKaisaiDate;
    }

    /*
     * gettxtYoteiKaishiTime
     * @return txtYoteiKaishiTime
     */
    @JsonProperty("txtYoteiKaishiTime")
    public TextBoxTime getTxtYoteiKaishiTime() {
        return txtYoteiKaishiTime;
    }

    /*
     * settxtYoteiKaishiTime
     * @param txtYoteiKaishiTime txtYoteiKaishiTime
     */
    @JsonProperty("txtYoteiKaishiTime")
    public void setTxtYoteiKaishiTime(TextBoxTime txtYoteiKaishiTime) {
        this.txtYoteiKaishiTime = txtYoteiKaishiTime;
    }

    /*
     * gettxtYoteiShuryoTime
     * @return txtYoteiShuryoTime
     */
    @JsonProperty("txtYoteiShuryoTime")
    public TextBoxTime getTxtYoteiShuryoTime() {
        return txtYoteiShuryoTime;
    }

    /*
     * settxtYoteiShuryoTime
     * @param txtYoteiShuryoTime txtYoteiShuryoTime
     */
    @JsonProperty("txtYoteiShuryoTime")
    public void setTxtYoteiShuryoTime(TextBoxTime txtYoteiShuryoTime) {
        this.txtYoteiShuryoTime = txtYoteiShuryoTime;
    }

    /*
     * getchkNinchishoOnly
     * @return chkNinchishoOnly
     */
    @JsonProperty("chkNinchishoOnly")
    public CheckBoxList getChkNinchishoOnly() {
        return chkNinchishoOnly;
    }

    /*
     * setchkNinchishoOnly
     * @param chkNinchishoOnly chkNinchishoOnly
     */
    @JsonProperty("chkNinchishoOnly")
    public void setChkNinchishoOnly(CheckBoxList chkNinchishoOnly) {
        this.chkNinchishoOnly = chkNinchishoOnly;
    }

    // </editor-fold>
}
