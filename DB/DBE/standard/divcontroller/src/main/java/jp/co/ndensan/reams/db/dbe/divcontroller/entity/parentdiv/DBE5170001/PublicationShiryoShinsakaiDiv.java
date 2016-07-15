package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5170001;
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
 * PublicationShiryoShinsakai のクラスファイル 
 * 
 * @author 自動生成
 */
public class PublicationShiryoShinsakaiDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("PublicationTargetShinsakai")
    private PublicationTargetShinsakaiDiv PublicationTargetShinsakai;
    @JsonProperty("LatestPublication")
    private LatestPublicationDiv LatestPublication;
    @JsonProperty("PublishingCondition")
    private PublishingConditionDiv PublishingCondition;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getPublicationTargetShinsakai
     * @return PublicationTargetShinsakai
     */
    @JsonProperty("PublicationTargetShinsakai")
    public PublicationTargetShinsakaiDiv getPublicationTargetShinsakai() {
        return PublicationTargetShinsakai;
    }

    /*
     * setPublicationTargetShinsakai
     * @param PublicationTargetShinsakai PublicationTargetShinsakai
     */
    @JsonProperty("PublicationTargetShinsakai")
    public void setPublicationTargetShinsakai(PublicationTargetShinsakaiDiv PublicationTargetShinsakai) {
        this.PublicationTargetShinsakai = PublicationTargetShinsakai;
    }

    /*
     * getLatestPublication
     * @return LatestPublication
     */
    @JsonProperty("LatestPublication")
    public LatestPublicationDiv getLatestPublication() {
        return LatestPublication;
    }

    /*
     * setLatestPublication
     * @param LatestPublication LatestPublication
     */
    @JsonProperty("LatestPublication")
    public void setLatestPublication(LatestPublicationDiv LatestPublication) {
        this.LatestPublication = LatestPublication;
    }

    /*
     * getPublishingCondition
     * @return PublishingCondition
     */
    @JsonProperty("PublishingCondition")
    public PublishingConditionDiv getPublishingCondition() {
        return PublishingCondition;
    }

    /*
     * setPublishingCondition
     * @param PublishingCondition PublishingCondition
     */
    @JsonProperty("PublishingCondition")
    public void setPublishingCondition(PublishingConditionDiv PublishingCondition) {
        this.PublishingCondition = PublishingCondition;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public TextBoxCode getTxtShinsakaiKaisaiNo() {
        return this.getPublicationTargetShinsakai().getTxtShinsakaiKaisaiNo();
    }

    @JsonIgnore
    public void  setTxtShinsakaiKaisaiNo(TextBoxCode txtShinsakaiKaisaiNo) {
        this.getPublicationTargetShinsakai().setTxtShinsakaiKaisaiNo(txtShinsakaiKaisaiNo);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtShinsakaiYoteiDate() {
        return this.getPublicationTargetShinsakai().getTxtShinsakaiYoteiDate();
    }

    @JsonIgnore
    public void  setTxtShinsakaiYoteiDate(TextBoxFlexibleDate txtShinsakaiYoteiDate) {
        this.getPublicationTargetShinsakai().setTxtShinsakaiYoteiDate(txtShinsakaiYoteiDate);
    }

    @JsonIgnore
    public TextBox getTxtShinsakaiKaijo() {
        return this.getPublicationTargetShinsakai().getTxtShinsakaiKaijo();
    }

    @JsonIgnore
    public void  setTxtShinsakaiKaijo(TextBox txtShinsakaiKaijo) {
        this.getPublicationTargetShinsakai().setTxtShinsakaiKaijo(txtShinsakaiKaijo);
    }

    @JsonIgnore
    public TextBoxTime getTxtShinsakaiKaishiYoteiTime() {
        return this.getPublicationTargetShinsakai().getTxtShinsakaiKaishiYoteiTime();
    }

    @JsonIgnore
    public void  setTxtShinsakaiKaishiYoteiTime(TextBoxTime txtShinsakaiKaishiYoteiTime) {
        this.getPublicationTargetShinsakai().setTxtShinsakaiKaishiYoteiTime(txtShinsakaiKaishiYoteiTime);
    }

    @JsonIgnore
    public TextBox getTxtShiryoSakusei() {
        return this.getPublicationTargetShinsakai().getTxtShiryoSakusei();
    }

    @JsonIgnore
    public void  setTxtShiryoSakusei(TextBox txtShiryoSakusei) {
        this.getPublicationTargetShinsakai().setTxtShiryoSakusei(txtShiryoSakusei);
    }

    @JsonIgnore
    public TextBoxCode getTxtGogitaiNo() {
        return this.getPublicationTargetShinsakai().getTxtGogitaiNo();
    }

    @JsonIgnore
    public void  setTxtGogitaiNo(TextBoxCode txtGogitaiNo) {
        this.getPublicationTargetShinsakai().setTxtGogitaiNo(txtGogitaiNo);
    }

    @JsonIgnore
    public TextBox getTxtGogitaiName() {
        return this.getPublicationTargetShinsakai().getTxtGogitaiName();
    }

    @JsonIgnore
    public void  setTxtGogitaiName(TextBox txtGogitaiName) {
        this.getPublicationTargetShinsakai().setTxtGogitaiName(txtGogitaiName);
    }

    @JsonIgnore
    public TextBoxNum getTxtYoteiTeiin() {
        return this.getPublicationTargetShinsakai().getTxtYoteiTeiin();
    }

    @JsonIgnore
    public void  setTxtYoteiTeiin(TextBoxNum txtYoteiTeiin) {
        this.getPublicationTargetShinsakai().setTxtYoteiTeiin(txtYoteiTeiin);
    }

    @JsonIgnore
    public TextBoxNum getTxtWariateNinzu() {
        return this.getPublicationTargetShinsakai().getTxtWariateNinzu();
    }

    @JsonIgnore
    public void  setTxtWariateNinzu(TextBoxNum txtWariateNinzu) {
        this.getPublicationTargetShinsakai().setTxtWariateNinzu(txtWariateNinzu);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtOperationDate() {
        return this.getLatestPublication().getTxtOperationDate();
    }

    @JsonIgnore
    public void  setTxtOperationDate(TextBoxFlexibleDate txtOperationDate) {
        this.getLatestPublication().setTxtOperationDate(txtOperationDate);
    }

    @JsonIgnore
    public TextBox getTxtShutsuryokuJun() {
        return this.getPublishingCondition().getTxtShutsuryokuJun();
    }

    @JsonIgnore
    public void  setTxtShutsuryokuJun(TextBox txtShutsuryokuJun) {
        this.getPublishingCondition().setTxtShutsuryokuJun(txtShutsuryokuJun);
    }

    @JsonIgnore
    public DropDownList getDdlShutsuryokuStyleZenken() {
        return this.getPublishingCondition().getDdlShutsuryokuStyleZenken();
    }

    @JsonIgnore
    public void  setDdlShutsuryokuStyleZenken(DropDownList ddlShutsuryokuStyleZenken) {
        this.getPublishingCondition().setDdlShutsuryokuStyleZenken(ddlShutsuryokuStyleZenken);
    }

    @JsonIgnore
    public RadioButton getRadShutsuryokuStyleZenken() {
        return this.getPublishingCondition().getRadShutsuryokuStyleZenken();
    }

    @JsonIgnore
    public void  setRadShutsuryokuStyleZenken(RadioButton radShutsuryokuStyleZenken) {
        this.getPublishingCondition().setRadShutsuryokuStyleZenken(radShutsuryokuStyleZenken);
    }

    @JsonIgnore
    public RadioButton getRadSakuseiJokenType() {
        return this.getPublishingCondition().getRadSakuseiJokenType();
    }

    @JsonIgnore
    public void  setRadSakuseiJokenType(RadioButton radSakuseiJokenType) {
        this.getPublishingCondition().setRadSakuseiJokenType(radSakuseiJokenType);
    }

    @JsonIgnore
    public TextBoxNum getTxtShiryoNoStart() {
        return this.getPublishingCondition().getTxtShiryoNoStart();
    }

    @JsonIgnore
    public void  setTxtShiryoNoStart(TextBoxNum txtShiryoNoStart) {
        this.getPublishingCondition().setTxtShiryoNoStart(txtShiryoNoStart);
    }

    @JsonIgnore
    public TextBoxNum getTxtSiryoNoEnd() {
        return this.getPublishingCondition().getTxtSiryoNoEnd();
    }

    @JsonIgnore
    public void  setTxtSiryoNoEnd(TextBoxNum txtSiryoNoEnd) {
        this.getPublishingCondition().setTxtSiryoNoEnd(txtSiryoNoEnd);
    }

    @JsonIgnore
    public PublishingConditionForJimukyokuDiv getPublishingConditionForJimukyoku() {
        return this.getPublishingCondition().getPublishingConditionForJimukyoku();
    }

    @JsonIgnore
    public void  setPublishingConditionForJimukyoku(PublishingConditionForJimukyokuDiv PublishingConditionForJimukyoku) {
        this.getPublishingCondition().setPublishingConditionForJimukyoku(PublishingConditionForJimukyoku);
    }

    @JsonIgnore
    public CheckBoxList getChkPrintChoyoJimu() {
        return this.getPublishingCondition().getPublishingConditionForJimukyoku().getChkPrintChoyoJimu();
    }

    @JsonIgnore
    public void  setChkPrintChoyoJimu(CheckBoxList chkPrintChoyoJimu) {
        this.getPublishingCondition().getPublishingConditionForJimukyoku().setChkPrintChoyoJimu(chkPrintChoyoJimu);
    }

    @JsonIgnore
    public Space getSpSpace1() {
        return this.getPublishingCondition().getPublishingConditionForJimukyoku().getSpSpace1();
    }

    @JsonIgnore
    public void  setSpSpace1(Space spSpace1) {
        this.getPublishingCondition().getPublishingConditionForJimukyoku().setSpSpace1(spSpace1);
    }

    @JsonIgnore
    public CheckBoxList getChkPrintChohyoShinsakaiJimu() {
        return this.getPublishingCondition().getPublishingConditionForJimukyoku().getChkPrintChohyoShinsakaiJimu();
    }

    @JsonIgnore
    public void  setChkPrintChohyoShinsakaiJimu(CheckBoxList chkPrintChohyoShinsakaiJimu) {
        this.getPublishingCondition().getPublishingConditionForJimukyoku().setChkPrintChohyoShinsakaiJimu(chkPrintChohyoShinsakaiJimu);
    }

    @JsonIgnore
    public Space getSpSpace3() {
        return this.getPublishingCondition().getPublishingConditionForJimukyoku().getSpSpace3();
    }

    @JsonIgnore
    public void  setSpSpace3(Space spSpace3) {
        this.getPublishingCondition().getPublishingConditionForJimukyoku().setSpSpace3(spSpace3);
    }

    @JsonIgnore
    public CheckBoxList getChkPrintChoyoJimu2() {
        return this.getPublishingCondition().getPublishingConditionForJimukyoku().getChkPrintChoyoJimu2();
    }

    @JsonIgnore
    public void  setChkPrintChoyoJimu2(CheckBoxList chkPrintChoyoJimu2) {
        this.getPublishingCondition().getPublishingConditionForJimukyoku().setChkPrintChoyoJimu2(chkPrintChoyoJimu2);
    }

    @JsonIgnore
    public PublishingConditionForShinsakaiIinDiv getPublishingConditionForShinsakaiIin() {
        return this.getPublishingCondition().getPublishingConditionForShinsakaiIin();
    }

    @JsonIgnore
    public void  setPublishingConditionForShinsakaiIin(PublishingConditionForShinsakaiIinDiv PublishingConditionForShinsakaiIin) {
        this.getPublishingCondition().setPublishingConditionForShinsakaiIin(PublishingConditionForShinsakaiIin);
    }

    @JsonIgnore
    public CheckBoxList getChkPrintChohyoIin() {
        return this.getPublishingCondition().getPublishingConditionForShinsakaiIin().getChkPrintChohyoIin();
    }

    @JsonIgnore
    public void  setChkPrintChohyoIin(CheckBoxList chkPrintChohyoIin) {
        this.getPublishingCondition().getPublishingConditionForShinsakaiIin().setChkPrintChohyoIin(chkPrintChohyoIin);
    }

    @JsonIgnore
    public Space getSpSpace2() {
        return this.getPublishingCondition().getPublishingConditionForShinsakaiIin().getSpSpace2();
    }

    @JsonIgnore
    public void  setSpSpace2(Space spSpace2) {
        this.getPublishingCondition().getPublishingConditionForShinsakaiIin().setSpSpace2(spSpace2);
    }

    @JsonIgnore
    public CheckBoxList getChkPrintChohyoShinsakaiIin() {
        return this.getPublishingCondition().getPublishingConditionForShinsakaiIin().getChkPrintChohyoShinsakaiIin();
    }

    @JsonIgnore
    public void  setChkPrintChohyoShinsakaiIin(CheckBoxList chkPrintChohyoShinsakaiIin) {
        this.getPublishingCondition().getPublishingConditionForShinsakaiIin().setChkPrintChohyoShinsakaiIin(chkPrintChohyoShinsakaiIin);
    }

    @JsonIgnore
    public Space getSpSpace4() {
        return this.getPublishingCondition().getPublishingConditionForShinsakaiIin().getSpSpace4();
    }

    @JsonIgnore
    public void  setSpSpace4(Space spSpace4) {
        this.getPublishingCondition().getPublishingConditionForShinsakaiIin().setSpSpace4(spSpace4);
    }

    @JsonIgnore
    public CheckBoxList getChkPrintChohyoIin2() {
        return this.getPublishingCondition().getPublishingConditionForShinsakaiIin().getChkPrintChohyoIin2();
    }

    @JsonIgnore
    public void  setChkPrintChohyoIin2(CheckBoxList chkPrintChohyoIin2) {
        this.getPublishingCondition().getPublishingConditionForShinsakaiIin().setChkPrintChohyoIin2(chkPrintChohyoIin2);
    }

    // </editor-fold>
}
