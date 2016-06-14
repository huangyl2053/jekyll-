package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE0120001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * ShinsakaiTaishosha のクラスファイル 
 * 
 * @author 自動生成
 */
public class ShinsakaiTaishoshaDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ShinsakaiJoho")
    private ShinsakaiJohoDiv ShinsakaiJoho;
    @JsonProperty("ShinsakaiTaishoshaIchiran")
    private ShinsakaiTaishoshaIchiranDiv ShinsakaiTaishoshaIchiran;
    @JsonProperty("KaigoNinteiShinsakaiKaisaiNo")
    private RString KaigoNinteiShinsakaiKaisaiNo;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getShinsakaiJoho
     * @return ShinsakaiJoho
     */
    @JsonProperty("ShinsakaiJoho")
    public ShinsakaiJohoDiv getShinsakaiJoho() {
        return ShinsakaiJoho;
    }

    /*
     * setShinsakaiJoho
     * @param ShinsakaiJoho ShinsakaiJoho
     */
    @JsonProperty("ShinsakaiJoho")
    public void setShinsakaiJoho(ShinsakaiJohoDiv ShinsakaiJoho) {
        this.ShinsakaiJoho = ShinsakaiJoho;
    }

    /*
     * getShinsakaiTaishoshaIchiran
     * @return ShinsakaiTaishoshaIchiran
     */
    @JsonProperty("ShinsakaiTaishoshaIchiran")
    public ShinsakaiTaishoshaIchiranDiv getShinsakaiTaishoshaIchiran() {
        return ShinsakaiTaishoshaIchiran;
    }

    /*
     * setShinsakaiTaishoshaIchiran
     * @param ShinsakaiTaishoshaIchiran ShinsakaiTaishoshaIchiran
     */
    @JsonProperty("ShinsakaiTaishoshaIchiran")
    public void setShinsakaiTaishoshaIchiran(ShinsakaiTaishoshaIchiranDiv ShinsakaiTaishoshaIchiran) {
        this.ShinsakaiTaishoshaIchiran = ShinsakaiTaishoshaIchiran;
    }

    /*
     * getKaigoNinteiShinsakaiKaisaiNo
     * @return KaigoNinteiShinsakaiKaisaiNo
     */
    @JsonProperty("KaigoNinteiShinsakaiKaisaiNo")
    public RString getKaigoNinteiShinsakaiKaisaiNo() {
        return KaigoNinteiShinsakaiKaisaiNo;
    }

    /*
     * setKaigoNinteiShinsakaiKaisaiNo
     * @param KaigoNinteiShinsakaiKaisaiNo KaigoNinteiShinsakaiKaisaiNo
     */
    @JsonProperty("KaigoNinteiShinsakaiKaisaiNo")
    public void setKaigoNinteiShinsakaiKaisaiNo(RString KaigoNinteiShinsakaiKaisaiNo) {
        this.KaigoNinteiShinsakaiKaisaiNo = KaigoNinteiShinsakaiKaisaiNo;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public ShinsakaiYoteiInfoDiv getShinsakaiYoteiInfo() {
        return this.getShinsakaiJoho().getShinsakaiYoteiInfo();
    }

    @JsonIgnore
    public void  setShinsakaiYoteiInfo(ShinsakaiYoteiInfoDiv ShinsakaiYoteiInfo) {
        this.getShinsakaiJoho().setShinsakaiYoteiInfo(ShinsakaiYoteiInfo);
    }

    @JsonIgnore
    public TextBox getTxtShinsakaiName() {
        return this.getShinsakaiJoho().getShinsakaiYoteiInfo().getTxtShinsakaiName();
    }

    @JsonIgnore
    public void  setTxtShinsakaiName(TextBox txtShinsakaiName) {
        this.getShinsakaiJoho().getShinsakaiYoteiInfo().setTxtShinsakaiName(txtShinsakaiName);
    }

    @JsonIgnore
    public TextBox getTxtGogitaiNumber() {
        return this.getShinsakaiJoho().getShinsakaiYoteiInfo().getTxtGogitaiNumber();
    }

    @JsonIgnore
    public void  setTxtGogitaiNumber(TextBox txtGogitaiNumber) {
        this.getShinsakaiJoho().getShinsakaiYoteiInfo().setTxtGogitaiNumber(txtGogitaiNumber);
    }

    @JsonIgnore
    public TextBoxNum getTxtYoteiTeiin() {
        return this.getShinsakaiJoho().getShinsakaiYoteiInfo().getTxtYoteiTeiin();
    }

    @JsonIgnore
    public void  setTxtYoteiTeiin(TextBoxNum txtYoteiTeiin) {
        this.getShinsakaiJoho().getShinsakaiYoteiInfo().setTxtYoteiTeiin(txtYoteiTeiin);
    }

    @JsonIgnore
    public TextBoxNum getTxtWaritsukeNinzu() {
        return this.getShinsakaiJoho().getShinsakaiYoteiInfo().getTxtWaritsukeNinzu();
    }

    @JsonIgnore
    public void  setTxtWaritsukeNinzu(TextBoxNum txtWaritsukeNinzu) {
        this.getShinsakaiJoho().getShinsakaiYoteiInfo().setTxtWaritsukeNinzu(txtWaritsukeNinzu);
    }

    @JsonIgnore
    public TextBox getTxtStatus() {
        return this.getShinsakaiJoho().getShinsakaiYoteiInfo().getTxtStatus();
    }

    @JsonIgnore
    public void  setTxtStatus(TextBox txtStatus) {
        this.getShinsakaiJoho().getShinsakaiYoteiInfo().setTxtStatus(txtStatus);
    }

    @JsonIgnore
    public TextBox getTxtShinsakaiKaijo() {
        return this.getShinsakaiJoho().getShinsakaiYoteiInfo().getTxtShinsakaiKaijo();
    }

    @JsonIgnore
    public void  setTxtShinsakaiKaijo(TextBox txtShinsakaiKaijo) {
        this.getShinsakaiJoho().getShinsakaiYoteiInfo().setTxtShinsakaiKaijo(txtShinsakaiKaijo);
    }

    @JsonIgnore
    public TextBox getTxtShinsakaiChiku() {
        return this.getShinsakaiJoho().getShinsakaiYoteiInfo().getTxtShinsakaiChiku();
    }

    @JsonIgnore
    public void  setTxtShinsakaiChiku(TextBox txtShinsakaiChiku) {
        this.getShinsakaiJoho().getShinsakaiYoteiInfo().setTxtShinsakaiChiku(txtShinsakaiChiku);
    }

    @JsonIgnore
    public TextBox getTxtShinsakauChikuName() {
        return this.getShinsakaiJoho().getShinsakaiYoteiInfo().getTxtShinsakauChikuName();
    }

    @JsonIgnore
    public void  setTxtShinsakauChikuName(TextBox txtShinsakauChikuName) {
        this.getShinsakaiJoho().getShinsakaiYoteiInfo().setTxtShinsakauChikuName(txtShinsakauChikuName);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtKaisaiDate() {
        return this.getShinsakaiJoho().getShinsakaiYoteiInfo().getTxtKaisaiDate();
    }

    @JsonIgnore
    public void  setTxtKaisaiDate(TextBoxFlexibleDate txtKaisaiDate) {
        this.getShinsakaiJoho().getShinsakaiYoteiInfo().setTxtKaisaiDate(txtKaisaiDate);
    }

    @JsonIgnore
    public TextBoxTime getTxtYoteiKaishiTime() {
        return this.getShinsakaiJoho().getShinsakaiYoteiInfo().getTxtYoteiKaishiTime();
    }

    @JsonIgnore
    public void  setTxtYoteiKaishiTime(TextBoxTime txtYoteiKaishiTime) {
        this.getShinsakaiJoho().getShinsakaiYoteiInfo().setTxtYoteiKaishiTime(txtYoteiKaishiTime);
    }

    @JsonIgnore
    public TextBoxTime getTxtYoteiShuryoTime() {
        return this.getShinsakaiJoho().getShinsakaiYoteiInfo().getTxtYoteiShuryoTime();
    }

    @JsonIgnore
    public void  setTxtYoteiShuryoTime(TextBoxTime txtYoteiShuryoTime) {
        this.getShinsakaiJoho().getShinsakaiYoteiInfo().setTxtYoteiShuryoTime(txtYoteiShuryoTime);
    }

    @JsonIgnore
    public CheckBoxList getChkNinchishoOnly() {
        return this.getShinsakaiJoho().getShinsakaiYoteiInfo().getChkNinchishoOnly();
    }

    @JsonIgnore
    public void  setChkNinchishoOnly(CheckBoxList chkNinchishoOnly) {
        this.getShinsakaiJoho().getShinsakaiYoteiInfo().setChkNinchishoOnly(chkNinchishoOnly);
    }

    @JsonIgnore
    public ShinsakaiKekkaInfoDiv getShinsakaiKekkaInfo() {
        return this.getShinsakaiJoho().getShinsakaiKekkaInfo();
    }

    @JsonIgnore
    public void  setShinsakaiKekkaInfo(ShinsakaiKekkaInfoDiv ShinsakaiKekkaInfo) {
        this.getShinsakaiJoho().setShinsakaiKekkaInfo(ShinsakaiKekkaInfo);
    }

    @JsonIgnore
    public TextBox getTxtShinsakaiKaijoKekka() {
        return this.getShinsakaiJoho().getShinsakaiKekkaInfo().getTxtShinsakaiKaijoKekka();
    }

    @JsonIgnore
    public void  setTxtShinsakaiKaijoKekka(TextBox txtShinsakaiKaijoKekka) {
        this.getShinsakaiJoho().getShinsakaiKekkaInfo().setTxtShinsakaiKaijoKekka(txtShinsakaiKaijoKekka);
    }

    @JsonIgnore
    public TextBox getTxtShinsakaiChikuKekka() {
        return this.getShinsakaiJoho().getShinsakaiKekkaInfo().getTxtShinsakaiChikuKekka();
    }

    @JsonIgnore
    public void  setTxtShinsakaiChikuKekka(TextBox txtShinsakaiChikuKekka) {
        this.getShinsakaiJoho().getShinsakaiKekkaInfo().setTxtShinsakaiChikuKekka(txtShinsakaiChikuKekka);
    }

    @JsonIgnore
    public TextBox getTxtShinsakauChikuNameKekka() {
        return this.getShinsakaiJoho().getShinsakaiKekkaInfo().getTxtShinsakauChikuNameKekka();
    }

    @JsonIgnore
    public void  setTxtShinsakauChikuNameKekka(TextBox txtShinsakauChikuNameKekka) {
        this.getShinsakaiJoho().getShinsakaiKekkaInfo().setTxtShinsakauChikuNameKekka(txtShinsakauChikuNameKekka);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtKaisaiDateKekka() {
        return this.getShinsakaiJoho().getShinsakaiKekkaInfo().getTxtKaisaiDateKekka();
    }

    @JsonIgnore
    public void  setTxtKaisaiDateKekka(TextBoxFlexibleDate txtKaisaiDateKekka) {
        this.getShinsakaiJoho().getShinsakaiKekkaInfo().setTxtKaisaiDateKekka(txtKaisaiDateKekka);
    }

    @JsonIgnore
    public TextBoxTime getTxtKaishiTime() {
        return this.getShinsakaiJoho().getShinsakaiKekkaInfo().getTxtKaishiTime();
    }

    @JsonIgnore
    public void  setTxtKaishiTime(TextBoxTime txtKaishiTime) {
        this.getShinsakaiJoho().getShinsakaiKekkaInfo().setTxtKaishiTime(txtKaishiTime);
    }

    @JsonIgnore
    public TextBoxTime getTxtShuryoTime() {
        return this.getShinsakaiJoho().getShinsakaiKekkaInfo().getTxtShuryoTime();
    }

    @JsonIgnore
    public void  setTxtShuryoTime(TextBoxTime txtShuryoTime) {
        this.getShinsakaiJoho().getShinsakaiKekkaInfo().setTxtShuryoTime(txtShuryoTime);
    }

    @JsonIgnore
    public TextBoxNum getTxtShoyoTime() {
        return this.getShinsakaiJoho().getShinsakaiKekkaInfo().getTxtShoyoTime();
    }

    @JsonIgnore
    public void  setTxtShoyoTime(TextBoxNum txtShoyoTime) {
        this.getShinsakaiJoho().getShinsakaiKekkaInfo().setTxtShoyoTime(txtShoyoTime);
    }

    @JsonIgnore
    public TextBoxNum getTxtJissiNinzu() {
        return this.getShinsakaiJoho().getShinsakaiKekkaInfo().getTxtJissiNinzu();
    }

    @JsonIgnore
    public void  setTxtJissiNinzu(TextBoxNum txtJissiNinzu) {
        this.getShinsakaiJoho().getShinsakaiKekkaInfo().setTxtJissiNinzu(txtJissiNinzu);
    }

    @JsonIgnore
    public DataGrid<dgTaishoshaIchiran_Row> getDgTaishoshaIchiran() {
        return this.getShinsakaiTaishoshaIchiran().getDgTaishoshaIchiran();
    }

    @JsonIgnore
    public void  setDgTaishoshaIchiran(DataGrid<dgTaishoshaIchiran_Row> dgTaishoshaIchiran) {
        this.getShinsakaiTaishoshaIchiran().setDgTaishoshaIchiran(dgTaishoshaIchiran);
    }

    // </editor-fold>
}
