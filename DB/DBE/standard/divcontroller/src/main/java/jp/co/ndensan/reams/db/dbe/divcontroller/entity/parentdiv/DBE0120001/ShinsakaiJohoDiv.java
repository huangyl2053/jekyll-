package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE0120001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * ShinsakaiJoho のクラスファイル 
 * 
 * @author 自動生成
 */
public class ShinsakaiJohoDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ShinsakaiYoteiInfo")
    private ShinsakaiYoteiInfoDiv ShinsakaiYoteiInfo;
    @JsonProperty("ShinsakaiKekkaInfo")
    private ShinsakaiKekkaInfoDiv ShinsakaiKekkaInfo;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getShinsakaiYoteiInfo
     * @return ShinsakaiYoteiInfo
     */
    @JsonProperty("ShinsakaiYoteiInfo")
    public ShinsakaiYoteiInfoDiv getShinsakaiYoteiInfo() {
        return ShinsakaiYoteiInfo;
    }

    /*
     * setShinsakaiYoteiInfo
     * @param ShinsakaiYoteiInfo ShinsakaiYoteiInfo
     */
    @JsonProperty("ShinsakaiYoteiInfo")
    public void setShinsakaiYoteiInfo(ShinsakaiYoteiInfoDiv ShinsakaiYoteiInfo) {
        this.ShinsakaiYoteiInfo = ShinsakaiYoteiInfo;
    }

    /*
     * getShinsakaiKekkaInfo
     * @return ShinsakaiKekkaInfo
     */
    @JsonProperty("ShinsakaiKekkaInfo")
    public ShinsakaiKekkaInfoDiv getShinsakaiKekkaInfo() {
        return ShinsakaiKekkaInfo;
    }

    /*
     * setShinsakaiKekkaInfo
     * @param ShinsakaiKekkaInfo ShinsakaiKekkaInfo
     */
    @JsonProperty("ShinsakaiKekkaInfo")
    public void setShinsakaiKekkaInfo(ShinsakaiKekkaInfoDiv ShinsakaiKekkaInfo) {
        this.ShinsakaiKekkaInfo = ShinsakaiKekkaInfo;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public TextBox getTxtShinsakaiName() {
        return this.getShinsakaiYoteiInfo().getTxtShinsakaiName();
    }

    @JsonIgnore
    public void  setTxtShinsakaiName(TextBox txtShinsakaiName) {
        this.getShinsakaiYoteiInfo().setTxtShinsakaiName(txtShinsakaiName);
    }

    @JsonIgnore
    public TextBox getTxtGogitaiNumber() {
        return this.getShinsakaiYoteiInfo().getTxtGogitaiNumber();
    }

    @JsonIgnore
    public void  setTxtGogitaiNumber(TextBox txtGogitaiNumber) {
        this.getShinsakaiYoteiInfo().setTxtGogitaiNumber(txtGogitaiNumber);
    }

    @JsonIgnore
    public TextBoxNum getTxtYoteiTeiin() {
        return this.getShinsakaiYoteiInfo().getTxtYoteiTeiin();
    }

    @JsonIgnore
    public void  setTxtYoteiTeiin(TextBoxNum txtYoteiTeiin) {
        this.getShinsakaiYoteiInfo().setTxtYoteiTeiin(txtYoteiTeiin);
    }

    @JsonIgnore
    public TextBoxNum getTxtWaritsukeNinzu() {
        return this.getShinsakaiYoteiInfo().getTxtWaritsukeNinzu();
    }

    @JsonIgnore
    public void  setTxtWaritsukeNinzu(TextBoxNum txtWaritsukeNinzu) {
        this.getShinsakaiYoteiInfo().setTxtWaritsukeNinzu(txtWaritsukeNinzu);
    }

    @JsonIgnore
    public TextBox getTxtStatus() {
        return this.getShinsakaiYoteiInfo().getTxtStatus();
    }

    @JsonIgnore
    public void  setTxtStatus(TextBox txtStatus) {
        this.getShinsakaiYoteiInfo().setTxtStatus(txtStatus);
    }

    @JsonIgnore
    public TextBox getTxtShinsakaiKaijo() {
        return this.getShinsakaiYoteiInfo().getTxtShinsakaiKaijo();
    }

    @JsonIgnore
    public void  setTxtShinsakaiKaijo(TextBox txtShinsakaiKaijo) {
        this.getShinsakaiYoteiInfo().setTxtShinsakaiKaijo(txtShinsakaiKaijo);
    }

    @JsonIgnore
    public TextBox getTxtShinsakaiChiku() {
        return this.getShinsakaiYoteiInfo().getTxtShinsakaiChiku();
    }

    @JsonIgnore
    public void  setTxtShinsakaiChiku(TextBox txtShinsakaiChiku) {
        this.getShinsakaiYoteiInfo().setTxtShinsakaiChiku(txtShinsakaiChiku);
    }

    @JsonIgnore
    public TextBox getTxtShinsakauChikuName() {
        return this.getShinsakaiYoteiInfo().getTxtShinsakauChikuName();
    }

    @JsonIgnore
    public void  setTxtShinsakauChikuName(TextBox txtShinsakauChikuName) {
        this.getShinsakaiYoteiInfo().setTxtShinsakauChikuName(txtShinsakauChikuName);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtKaisaiDate() {
        return this.getShinsakaiYoteiInfo().getTxtKaisaiDate();
    }

    @JsonIgnore
    public void  setTxtKaisaiDate(TextBoxFlexibleDate txtKaisaiDate) {
        this.getShinsakaiYoteiInfo().setTxtKaisaiDate(txtKaisaiDate);
    }

    @JsonIgnore
    public TextBoxTime getTxtYoteiKaishiTime() {
        return this.getShinsakaiYoteiInfo().getTxtYoteiKaishiTime();
    }

    @JsonIgnore
    public void  setTxtYoteiKaishiTime(TextBoxTime txtYoteiKaishiTime) {
        this.getShinsakaiYoteiInfo().setTxtYoteiKaishiTime(txtYoteiKaishiTime);
    }

    @JsonIgnore
    public TextBoxTime getTxtYoteiShuryoTime() {
        return this.getShinsakaiYoteiInfo().getTxtYoteiShuryoTime();
    }

    @JsonIgnore
    public void  setTxtYoteiShuryoTime(TextBoxTime txtYoteiShuryoTime) {
        this.getShinsakaiYoteiInfo().setTxtYoteiShuryoTime(txtYoteiShuryoTime);
    }

    @JsonIgnore
    public CheckBoxList getChkNinchishoOnly() {
        return this.getShinsakaiYoteiInfo().getChkNinchishoOnly();
    }

    @JsonIgnore
    public void  setChkNinchishoOnly(CheckBoxList chkNinchishoOnly) {
        this.getShinsakaiYoteiInfo().setChkNinchishoOnly(chkNinchishoOnly);
    }

    @JsonIgnore
    public TextBox getTxtShinsakaiKaijoKekka() {
        return this.getShinsakaiKekkaInfo().getTxtShinsakaiKaijoKekka();
    }

    @JsonIgnore
    public void  setTxtShinsakaiKaijoKekka(TextBox txtShinsakaiKaijoKekka) {
        this.getShinsakaiKekkaInfo().setTxtShinsakaiKaijoKekka(txtShinsakaiKaijoKekka);
    }

    @JsonIgnore
    public TextBox getTxtShinsakaiChikuKekka() {
        return this.getShinsakaiKekkaInfo().getTxtShinsakaiChikuKekka();
    }

    @JsonIgnore
    public void  setTxtShinsakaiChikuKekka(TextBox txtShinsakaiChikuKekka) {
        this.getShinsakaiKekkaInfo().setTxtShinsakaiChikuKekka(txtShinsakaiChikuKekka);
    }

    @JsonIgnore
    public TextBox getTxtShinsakauChikuNameKekka() {
        return this.getShinsakaiKekkaInfo().getTxtShinsakauChikuNameKekka();
    }

    @JsonIgnore
    public void  setTxtShinsakauChikuNameKekka(TextBox txtShinsakauChikuNameKekka) {
        this.getShinsakaiKekkaInfo().setTxtShinsakauChikuNameKekka(txtShinsakauChikuNameKekka);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtKaisaiDateKekka() {
        return this.getShinsakaiKekkaInfo().getTxtKaisaiDateKekka();
    }

    @JsonIgnore
    public void  setTxtKaisaiDateKekka(TextBoxFlexibleDate txtKaisaiDateKekka) {
        this.getShinsakaiKekkaInfo().setTxtKaisaiDateKekka(txtKaisaiDateKekka);
    }

    @JsonIgnore
    public TextBoxTime getTxtKaishiTime() {
        return this.getShinsakaiKekkaInfo().getTxtKaishiTime();
    }

    @JsonIgnore
    public void  setTxtKaishiTime(TextBoxTime txtKaishiTime) {
        this.getShinsakaiKekkaInfo().setTxtKaishiTime(txtKaishiTime);
    }

    @JsonIgnore
    public TextBoxTime getTxtShuryoTime() {
        return this.getShinsakaiKekkaInfo().getTxtShuryoTime();
    }

    @JsonIgnore
    public void  setTxtShuryoTime(TextBoxTime txtShuryoTime) {
        this.getShinsakaiKekkaInfo().setTxtShuryoTime(txtShuryoTime);
    }

    @JsonIgnore
    public TextBoxNum getTxtShoyoTime() {
        return this.getShinsakaiKekkaInfo().getTxtShoyoTime();
    }

    @JsonIgnore
    public void  setTxtShoyoTime(TextBoxNum txtShoyoTime) {
        this.getShinsakaiKekkaInfo().setTxtShoyoTime(txtShoyoTime);
    }

    @JsonIgnore
    public TextBoxNum getTxtJissiNinzu() {
        return this.getShinsakaiKekkaInfo().getTxtJissiNinzu();
    }

    @JsonIgnore
    public void  setTxtJissiNinzu(TextBoxNum txtJissiNinzu) {
        this.getShinsakaiKekkaInfo().setTxtJissiNinzu(txtJissiNinzu);
    }

    // </editor-fold>
}
