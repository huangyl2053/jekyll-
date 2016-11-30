package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ChosaTokkiShiryoShokai.ChosaTokkiShiryoShokai;
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
 * ChosaTokkiShiryoShokai のクラスファイル 
 * 
 * @author 自動生成
 */
public class ChosaTokkiShiryoShokaiDiv extends Panel implements IChosaTokkiShiryoShokaiDiv {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-10-31_08-44-29">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("radGenpoMask")
    private RadioButton radGenpoMask;
    @JsonProperty("genpoTabContainer")
    private genpoTabContainerDiv genpoTabContainer;
    @JsonProperty("maskTabContainer")
    private maskTabContainerDiv maskTabContainer;
    @JsonProperty("imgGenpoPathList")
    private RString imgGenpoPathList;
    @JsonProperty("imgMaskPathList")
    private RString imgMaskPathList;
    @JsonProperty("genpoTitleList")
    private RString genpoTitleList;
    @JsonProperty("maskTitleList")
    private RString maskTitleList;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getradGenpoMask
     * @return radGenpoMask
     */
    @JsonProperty("radGenpoMask")
    public RadioButton getRadGenpoMask() {
        return radGenpoMask;
    }

    /*
     * setradGenpoMask
     * @param radGenpoMask radGenpoMask
     */
    @JsonProperty("radGenpoMask")
    public void setRadGenpoMask(RadioButton radGenpoMask) {
        this.radGenpoMask = radGenpoMask;
    }

    /*
     * getgenpoTabContainer
     * @return genpoTabContainer
     */
    @JsonProperty("genpoTabContainer")
    public genpoTabContainerDiv getGenpoTabContainer() {
        return genpoTabContainer;
    }

    /*
     * setgenpoTabContainer
     * @param genpoTabContainer genpoTabContainer
     */
    @JsonProperty("genpoTabContainer")
    public void setGenpoTabContainer(genpoTabContainerDiv genpoTabContainer) {
        this.genpoTabContainer = genpoTabContainer;
    }

    /*
     * getmaskTabContainer
     * @return maskTabContainer
     */
    @JsonProperty("maskTabContainer")
    public maskTabContainerDiv getMaskTabContainer() {
        return maskTabContainer;
    }

    /*
     * setmaskTabContainer
     * @param maskTabContainer maskTabContainer
     */
    @JsonProperty("maskTabContainer")
    public void setMaskTabContainer(maskTabContainerDiv maskTabContainer) {
        this.maskTabContainer = maskTabContainer;
    }

    /*
     * getimgGenpoPathList
     * @return imgGenpoPathList
     */
    @JsonProperty("imgGenpoPathList")
    public RString getImgGenpoPathList() {
        return imgGenpoPathList;
    }

    /*
     * setimgGenpoPathList
     * @param imgGenpoPathList imgGenpoPathList
     */
    @JsonProperty("imgGenpoPathList")
    public void setImgGenpoPathList(RString imgGenpoPathList) {
        this.imgGenpoPathList = imgGenpoPathList;
    }

    /*
     * getimgMaskPathList
     * @return imgMaskPathList
     */
    @JsonProperty("imgMaskPathList")
    public RString getImgMaskPathList() {
        return imgMaskPathList;
    }

    /*
     * setimgMaskPathList
     * @param imgMaskPathList imgMaskPathList
     */
    @JsonProperty("imgMaskPathList")
    public void setImgMaskPathList(RString imgMaskPathList) {
        this.imgMaskPathList = imgMaskPathList;
    }

    /*
     * getgenpoTitleList
     * @return genpoTitleList
     */
    @JsonProperty("genpoTitleList")
    public RString getGenpoTitleList() {
        return genpoTitleList;
    }

    /*
     * setgenpoTitleList
     * @param genpoTitleList genpoTitleList
     */
    @JsonProperty("genpoTitleList")
    public void setGenpoTitleList(RString genpoTitleList) {
        this.genpoTitleList = genpoTitleList;
    }

    /*
     * getmaskTitleList
     * @return maskTitleList
     */
    @JsonProperty("maskTitleList")
    public RString getMaskTitleList() {
        return maskTitleList;
    }

    /*
     * setmaskTitleList
     * @param maskTitleList maskTitleList
     */
    @JsonProperty("maskTitleList")
    public void setMaskTitleList(RString maskTitleList) {
        this.maskTitleList = maskTitleList;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public genpoTabPanel1Div getGenpoTabPanel1() {
        return this.getGenpoTabContainer().getGenpoTabPanel1();
    }

    @JsonIgnore
    public void  setGenpoTabPanel1(genpoTabPanel1Div genpoTabPanel1) {
        this.getGenpoTabContainer().setGenpoTabPanel1(genpoTabPanel1);
    }

    @JsonIgnore
    public StaticImage getImgGenpo1() {
        return this.getGenpoTabContainer().getGenpoTabPanel1().getImgGenpo1();
    }

    @JsonIgnore
    public void  setImgGenpo1(StaticImage imgGenpo1) {
        this.getGenpoTabContainer().getGenpoTabPanel1().setImgGenpo1(imgGenpo1);
    }

    @JsonIgnore
    public genpoTabPanel2Div getGenpoTabPanel2() {
        return this.getGenpoTabContainer().getGenpoTabPanel2();
    }

    @JsonIgnore
    public void  setGenpoTabPanel2(genpoTabPanel2Div genpoTabPanel2) {
        this.getGenpoTabContainer().setGenpoTabPanel2(genpoTabPanel2);
    }

    @JsonIgnore
    public StaticImage getImgGenpo2() {
        return this.getGenpoTabContainer().getGenpoTabPanel2().getImgGenpo2();
    }

    @JsonIgnore
    public void  setImgGenpo2(StaticImage imgGenpo2) {
        this.getGenpoTabContainer().getGenpoTabPanel2().setImgGenpo2(imgGenpo2);
    }

    @JsonIgnore
    public genpoTabPanel3Div getGenpoTabPanel3() {
        return this.getGenpoTabContainer().getGenpoTabPanel3();
    }

    @JsonIgnore
    public void  setGenpoTabPanel3(genpoTabPanel3Div genpoTabPanel3) {
        this.getGenpoTabContainer().setGenpoTabPanel3(genpoTabPanel3);
    }

    @JsonIgnore
    public StaticImage getImgGenpo3() {
        return this.getGenpoTabContainer().getGenpoTabPanel3().getImgGenpo3();
    }

    @JsonIgnore
    public void  setImgGenpo3(StaticImage imgGenpo3) {
        this.getGenpoTabContainer().getGenpoTabPanel3().setImgGenpo3(imgGenpo3);
    }

    @JsonIgnore
    public genpoTabPanel4Div getGenpoTabPanel4() {
        return this.getGenpoTabContainer().getGenpoTabPanel4();
    }

    @JsonIgnore
    public void  setGenpoTabPanel4(genpoTabPanel4Div genpoTabPanel4) {
        this.getGenpoTabContainer().setGenpoTabPanel4(genpoTabPanel4);
    }

    @JsonIgnore
    public StaticImage getImgGenpo4() {
        return this.getGenpoTabContainer().getGenpoTabPanel4().getImgGenpo4();
    }

    @JsonIgnore
    public void  setImgGenpo4(StaticImage imgGenpo4) {
        this.getGenpoTabContainer().getGenpoTabPanel4().setImgGenpo4(imgGenpo4);
    }

    @JsonIgnore
    public genpoTabPanel5Div getGenpoTabPanel5() {
        return this.getGenpoTabContainer().getGenpoTabPanel5();
    }

    @JsonIgnore
    public void  setGenpoTabPanel5(genpoTabPanel5Div genpoTabPanel5) {
        this.getGenpoTabContainer().setGenpoTabPanel5(genpoTabPanel5);
    }

    @JsonIgnore
    public StaticImage getImgGenpo5() {
        return this.getGenpoTabContainer().getGenpoTabPanel5().getImgGenpo5();
    }

    @JsonIgnore
    public void  setImgGenpo5(StaticImage imgGenpo5) {
        this.getGenpoTabContainer().getGenpoTabPanel5().setImgGenpo5(imgGenpo5);
    }

    @JsonIgnore
    public genpoTabPanel6Div getGenpoTabPanel6() {
        return this.getGenpoTabContainer().getGenpoTabPanel6();
    }

    @JsonIgnore
    public void  setGenpoTabPanel6(genpoTabPanel6Div genpoTabPanel6) {
        this.getGenpoTabContainer().setGenpoTabPanel6(genpoTabPanel6);
    }

    @JsonIgnore
    public StaticImage getImgGenpo6() {
        return this.getGenpoTabContainer().getGenpoTabPanel6().getImgGenpo6();
    }

    @JsonIgnore
    public void  setImgGenpo6(StaticImage imgGenpo6) {
        this.getGenpoTabContainer().getGenpoTabPanel6().setImgGenpo6(imgGenpo6);
    }

    @JsonIgnore
    public genpoTabPanel7Div getGenpoTabPanel7() {
        return this.getGenpoTabContainer().getGenpoTabPanel7();
    }

    @JsonIgnore
    public void  setGenpoTabPanel7(genpoTabPanel7Div genpoTabPanel7) {
        this.getGenpoTabContainer().setGenpoTabPanel7(genpoTabPanel7);
    }

    @JsonIgnore
    public StaticImage getImgGenpo7() {
        return this.getGenpoTabContainer().getGenpoTabPanel7().getImgGenpo7();
    }

    @JsonIgnore
    public void  setImgGenpo7(StaticImage imgGenpo7) {
        this.getGenpoTabContainer().getGenpoTabPanel7().setImgGenpo7(imgGenpo7);
    }

    @JsonIgnore
    public genpoTabPanel8Div getGenpoTabPanel8() {
        return this.getGenpoTabContainer().getGenpoTabPanel8();
    }

    @JsonIgnore
    public void  setGenpoTabPanel8(genpoTabPanel8Div genpoTabPanel8) {
        this.getGenpoTabContainer().setGenpoTabPanel8(genpoTabPanel8);
    }

    @JsonIgnore
    public StaticImage getImgGenpo8() {
        return this.getGenpoTabContainer().getGenpoTabPanel8().getImgGenpo8();
    }

    @JsonIgnore
    public void  setImgGenpo8(StaticImage imgGenpo8) {
        this.getGenpoTabContainer().getGenpoTabPanel8().setImgGenpo8(imgGenpo8);
    }

    @JsonIgnore
    public maskTabPanel1Div getMaskTabPanel1() {
        return this.getMaskTabContainer().getMaskTabPanel1();
    }

    @JsonIgnore
    public void  setMaskTabPanel1(maskTabPanel1Div maskTabPanel1) {
        this.getMaskTabContainer().setMaskTabPanel1(maskTabPanel1);
    }

    @JsonIgnore
    public StaticImage getImgMask1() {
        return this.getMaskTabContainer().getMaskTabPanel1().getImgMask1();
    }

    @JsonIgnore
    public void  setImgMask1(StaticImage imgMask1) {
        this.getMaskTabContainer().getMaskTabPanel1().setImgMask1(imgMask1);
    }

    @JsonIgnore
    public maskTabPanel2Div getMaskTabPanel2() {
        return this.getMaskTabContainer().getMaskTabPanel2();
    }

    @JsonIgnore
    public void  setMaskTabPanel2(maskTabPanel2Div maskTabPanel2) {
        this.getMaskTabContainer().setMaskTabPanel2(maskTabPanel2);
    }

    @JsonIgnore
    public StaticImage getImgMask2() {
        return this.getMaskTabContainer().getMaskTabPanel2().getImgMask2();
    }

    @JsonIgnore
    public void  setImgMask2(StaticImage imgMask2) {
        this.getMaskTabContainer().getMaskTabPanel2().setImgMask2(imgMask2);
    }

    @JsonIgnore
    public maskTabPanel3Div getMaskTabPanel3() {
        return this.getMaskTabContainer().getMaskTabPanel3();
    }

    @JsonIgnore
    public void  setMaskTabPanel3(maskTabPanel3Div maskTabPanel3) {
        this.getMaskTabContainer().setMaskTabPanel3(maskTabPanel3);
    }

    @JsonIgnore
    public StaticImage getImgMask3() {
        return this.getMaskTabContainer().getMaskTabPanel3().getImgMask3();
    }

    @JsonIgnore
    public void  setImgMask3(StaticImage imgMask3) {
        this.getMaskTabContainer().getMaskTabPanel3().setImgMask3(imgMask3);
    }

    @JsonIgnore
    public maskTabPanel4Div getMaskTabPanel4() {
        return this.getMaskTabContainer().getMaskTabPanel4();
    }

    @JsonIgnore
    public void  setMaskTabPanel4(maskTabPanel4Div maskTabPanel4) {
        this.getMaskTabContainer().setMaskTabPanel4(maskTabPanel4);
    }

    @JsonIgnore
    public StaticImage getImgMask4() {
        return this.getMaskTabContainer().getMaskTabPanel4().getImgMask4();
    }

    @JsonIgnore
    public void  setImgMask4(StaticImage imgMask4) {
        this.getMaskTabContainer().getMaskTabPanel4().setImgMask4(imgMask4);
    }

    @JsonIgnore
    public maskTabPanel5Div getMaskTabPanel5() {
        return this.getMaskTabContainer().getMaskTabPanel5();
    }

    @JsonIgnore
    public void  setMaskTabPanel5(maskTabPanel5Div maskTabPanel5) {
        this.getMaskTabContainer().setMaskTabPanel5(maskTabPanel5);
    }

    @JsonIgnore
    public StaticImage getImgMask5() {
        return this.getMaskTabContainer().getMaskTabPanel5().getImgMask5();
    }

    @JsonIgnore
    public void  setImgMask5(StaticImage imgMask5) {
        this.getMaskTabContainer().getMaskTabPanel5().setImgMask5(imgMask5);
    }

    @JsonIgnore
    public maskTabPanel6Div getMaskTabPanel6() {
        return this.getMaskTabContainer().getMaskTabPanel6();
    }

    @JsonIgnore
    public void  setMaskTabPanel6(maskTabPanel6Div maskTabPanel6) {
        this.getMaskTabContainer().setMaskTabPanel6(maskTabPanel6);
    }

    @JsonIgnore
    public StaticImage getImgMask6() {
        return this.getMaskTabContainer().getMaskTabPanel6().getImgMask6();
    }

    @JsonIgnore
    public void  setImgMask6(StaticImage imgMask6) {
        this.getMaskTabContainer().getMaskTabPanel6().setImgMask6(imgMask6);
    }

    @JsonIgnore
    public maskTabPanel7Div getMaskTabPanel7() {
        return this.getMaskTabContainer().getMaskTabPanel7();
    }

    @JsonIgnore
    public void  setMaskTabPanel7(maskTabPanel7Div maskTabPanel7) {
        this.getMaskTabContainer().setMaskTabPanel7(maskTabPanel7);
    }

    @JsonIgnore
    public StaticImage getImgMask7() {
        return this.getMaskTabContainer().getMaskTabPanel7().getImgMask7();
    }

    @JsonIgnore
    public void  setImgMask7(StaticImage imgMask7) {
        this.getMaskTabContainer().getMaskTabPanel7().setImgMask7(imgMask7);
    }

    @JsonIgnore
    public maskTabPanel8Div getMaskTabPanel8() {
        return this.getMaskTabContainer().getMaskTabPanel8();
    }

    @JsonIgnore
    public void  setMaskTabPanel8(maskTabPanel8Div maskTabPanel8) {
        this.getMaskTabContainer().setMaskTabPanel8(maskTabPanel8);
    }

    @JsonIgnore
    public StaticImage getImgMask8() {
        return this.getMaskTabContainer().getMaskTabPanel8().getImgMask8();
    }

    @JsonIgnore
    public void  setImgMask8(StaticImage imgMask8) {
        this.getMaskTabContainer().getMaskTabPanel8().setImgMask8(imgMask8);
    }

    // </editor-fold>
    //--------------- この行より下にコードを追加してください -------------------
}
