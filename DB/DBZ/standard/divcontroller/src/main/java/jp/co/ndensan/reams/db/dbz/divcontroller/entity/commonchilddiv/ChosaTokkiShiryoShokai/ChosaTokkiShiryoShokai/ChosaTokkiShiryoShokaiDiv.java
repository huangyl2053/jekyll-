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
import java.util.List;

/**
 * ChosaTokkiShiryoShokai のクラスファイル
 *
 * @author 自動生成
 */
public class ChosaTokkiShiryoShokaiDiv extends Panel implements IChosaTokkiShiryoShokaiDiv {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-11-29_19-09-25">
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
    @JsonProperty("imgGenponPathList")
    private RString imgGenponPathList;
    @JsonProperty("imgMaskPathList")
    private RString imgMaskPathList;
    @JsonProperty("genponTitleList")
    private RString genponTitleList;
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
     * getimgGenponPathList
     * @return imgGenponPathList
     */
    @JsonProperty("imgGenponPathList")
    public RString getImgGenponPathList() {
        return imgGenponPathList;
    }

    /*
     * setimgGenponPathList
     * @param imgGenponPathList imgGenponPathList
     */
    @JsonProperty("imgGenponPathList")
    public void setImgGenponPathList(RString imgGenponPathList) {
        this.imgGenponPathList = imgGenponPathList;
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
     * getgenponTitleList
     * @return genponTitleList
     */
    @JsonProperty("genponTitleList")
    public RString getGenponTitleList() {
        return genponTitleList;
    }

    /*
     * setgenponTitleList
     * @param genponTitleList genponTitleList
     */
    @JsonProperty("genponTitleList")
    public void setGenponTitleList(RString genponTitleList) {
        this.genponTitleList = genponTitleList;
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
    public void setGenpoTabPanel1(genpoTabPanel1Div genpoTabPanel1) {
        this.getGenpoTabContainer().setGenpoTabPanel1(genpoTabPanel1);
    }

    @JsonIgnore
    public StaticImage getImgGenpo1() {
        return this.getGenpoTabContainer().getGenpoTabPanel1().getImgGenpo1();
    }

    @JsonIgnore
    public void setImgGenpo1(StaticImage imgGenpo1) {
        this.getGenpoTabContainer().getGenpoTabPanel1().setImgGenpo1(imgGenpo1);
    }

    @JsonIgnore
    public genpoTabPanel2Div getGenpoTabPanel2() {
        return this.getGenpoTabContainer().getGenpoTabPanel2();
    }

    @JsonIgnore
    public void setGenpoTabPanel2(genpoTabPanel2Div genpoTabPanel2) {
        this.getGenpoTabContainer().setGenpoTabPanel2(genpoTabPanel2);
    }

    @JsonIgnore
    public StaticImage getImgGenpo2() {
        return this.getGenpoTabContainer().getGenpoTabPanel2().getImgGenpo2();
    }

    @JsonIgnore
    public void setImgGenpo2(StaticImage imgGenpo2) {
        this.getGenpoTabContainer().getGenpoTabPanel2().setImgGenpo2(imgGenpo2);
    }

    @JsonIgnore
    public genpoTabPanel3Div getGenpoTabPanel3() {
        return this.getGenpoTabContainer().getGenpoTabPanel3();
    }

    @JsonIgnore
    public void setGenpoTabPanel3(genpoTabPanel3Div genpoTabPanel3) {
        this.getGenpoTabContainer().setGenpoTabPanel3(genpoTabPanel3);
    }

    @JsonIgnore
    public StaticImage getImgGenpo3() {
        return this.getGenpoTabContainer().getGenpoTabPanel3().getImgGenpo3();
    }

    @JsonIgnore
    public void setImgGenpo3(StaticImage imgGenpo3) {
        this.getGenpoTabContainer().getGenpoTabPanel3().setImgGenpo3(imgGenpo3);
    }

    @JsonIgnore
    public genpoTabPanel4Div getGenpoTabPanel4() {
        return this.getGenpoTabContainer().getGenpoTabPanel4();
    }

    @JsonIgnore
    public void setGenpoTabPanel4(genpoTabPanel4Div genpoTabPanel4) {
        this.getGenpoTabContainer().setGenpoTabPanel4(genpoTabPanel4);
    }

    @JsonIgnore
    public StaticImage getImgGenpo4() {
        return this.getGenpoTabContainer().getGenpoTabPanel4().getImgGenpo4();
    }

    @JsonIgnore
    public void setImgGenpo4(StaticImage imgGenpo4) {
        this.getGenpoTabContainer().getGenpoTabPanel4().setImgGenpo4(imgGenpo4);
    }

    @JsonIgnore
    public genpoTabPanel5Div getGenpoTabPanel5() {
        return this.getGenpoTabContainer().getGenpoTabPanel5();
    }

    @JsonIgnore
    public void setGenpoTabPanel5(genpoTabPanel5Div genpoTabPanel5) {
        this.getGenpoTabContainer().setGenpoTabPanel5(genpoTabPanel5);
    }

    @JsonIgnore
    public StaticImage getImgGenpo5() {
        return this.getGenpoTabContainer().getGenpoTabPanel5().getImgGenpo5();
    }

    @JsonIgnore
    public void setImgGenpo5(StaticImage imgGenpo5) {
        this.getGenpoTabContainer().getGenpoTabPanel5().setImgGenpo5(imgGenpo5);
    }

    @JsonIgnore
    public genpoTabPanel6Div getGenpoTabPanel6() {
        return this.getGenpoTabContainer().getGenpoTabPanel6();
    }

    @JsonIgnore
    public void setGenpoTabPanel6(genpoTabPanel6Div genpoTabPanel6) {
        this.getGenpoTabContainer().setGenpoTabPanel6(genpoTabPanel6);
    }

    @JsonIgnore
    public StaticImage getImgGenpo6() {
        return this.getGenpoTabContainer().getGenpoTabPanel6().getImgGenpo6();
    }

    @JsonIgnore
    public void setImgGenpo6(StaticImage imgGenpo6) {
        this.getGenpoTabContainer().getGenpoTabPanel6().setImgGenpo6(imgGenpo6);
    }

    @JsonIgnore
    public genpoTabPanel7Div getGenpoTabPanel7() {
        return this.getGenpoTabContainer().getGenpoTabPanel7();
    }

    @JsonIgnore
    public void setGenpoTabPanel7(genpoTabPanel7Div genpoTabPanel7) {
        this.getGenpoTabContainer().setGenpoTabPanel7(genpoTabPanel7);
    }

    @JsonIgnore
    public StaticImage getImgGenpo7() {
        return this.getGenpoTabContainer().getGenpoTabPanel7().getImgGenpo7();
    }

    @JsonIgnore
    public void setImgGenpo7(StaticImage imgGenpo7) {
        this.getGenpoTabContainer().getGenpoTabPanel7().setImgGenpo7(imgGenpo7);
    }

    @JsonIgnore
    public genpoTabPanel8Div getGenpoTabPanel8() {
        return this.getGenpoTabContainer().getGenpoTabPanel8();
    }

    @JsonIgnore
    public void setGenpoTabPanel8(genpoTabPanel8Div genpoTabPanel8) {
        this.getGenpoTabContainer().setGenpoTabPanel8(genpoTabPanel8);
    }

    @JsonIgnore
    public StaticImage getImgGenpo8() {
        return this.getGenpoTabContainer().getGenpoTabPanel8().getImgGenpo8();
    }

    @JsonIgnore
    public void setImgGenpo8(StaticImage imgGenpo8) {
        this.getGenpoTabContainer().getGenpoTabPanel8().setImgGenpo8(imgGenpo8);
    }

    @JsonIgnore
    public maskTabPanel1Div getMaskTabPanel1() {
        return this.getMaskTabContainer().getMaskTabPanel1();
    }

    @JsonIgnore
    public void setMaskTabPanel1(maskTabPanel1Div maskTabPanel1) {
        this.getMaskTabContainer().setMaskTabPanel1(maskTabPanel1);
    }

    @JsonIgnore
    public StaticImage getImgMask1() {
        return this.getMaskTabContainer().getMaskTabPanel1().getImgMask1();
    }

    @JsonIgnore
    public void setImgMask1(StaticImage imgMask1) {
        this.getMaskTabContainer().getMaskTabPanel1().setImgMask1(imgMask1);
    }

    @JsonIgnore
    public maskTabPanel2Div getMaskTabPanel2() {
        return this.getMaskTabContainer().getMaskTabPanel2();
    }

    @JsonIgnore
    public void setMaskTabPanel2(maskTabPanel2Div maskTabPanel2) {
        this.getMaskTabContainer().setMaskTabPanel2(maskTabPanel2);
    }

    @JsonIgnore
    public StaticImage getImgMask2() {
        return this.getMaskTabContainer().getMaskTabPanel2().getImgMask2();
    }

    @JsonIgnore
    public void setImgMask2(StaticImage imgMask2) {
        this.getMaskTabContainer().getMaskTabPanel2().setImgMask2(imgMask2);
    }

    @JsonIgnore
    public maskTabPanel3Div getMaskTabPanel3() {
        return this.getMaskTabContainer().getMaskTabPanel3();
    }

    @JsonIgnore
    public void setMaskTabPanel3(maskTabPanel3Div maskTabPanel3) {
        this.getMaskTabContainer().setMaskTabPanel3(maskTabPanel3);
    }

    @JsonIgnore
    public StaticImage getImgMask3() {
        return this.getMaskTabContainer().getMaskTabPanel3().getImgMask3();
    }

    @JsonIgnore
    public void setImgMask3(StaticImage imgMask3) {
        this.getMaskTabContainer().getMaskTabPanel3().setImgMask3(imgMask3);
    }

    @JsonIgnore
    public maskTabPanel4Div getMaskTabPanel4() {
        return this.getMaskTabContainer().getMaskTabPanel4();
    }

    @JsonIgnore
    public void setMaskTabPanel4(maskTabPanel4Div maskTabPanel4) {
        this.getMaskTabContainer().setMaskTabPanel4(maskTabPanel4);
    }

    @JsonIgnore
    public StaticImage getImgMask4() {
        return this.getMaskTabContainer().getMaskTabPanel4().getImgMask4();
    }

    @JsonIgnore
    public void setImgMask4(StaticImage imgMask4) {
        this.getMaskTabContainer().getMaskTabPanel4().setImgMask4(imgMask4);
    }

    @JsonIgnore
    public maskTabPanel5Div getMaskTabPanel5() {
        return this.getMaskTabContainer().getMaskTabPanel5();
    }

    @JsonIgnore
    public void setMaskTabPanel5(maskTabPanel5Div maskTabPanel5) {
        this.getMaskTabContainer().setMaskTabPanel5(maskTabPanel5);
    }

    @JsonIgnore
    public StaticImage getImgMask5() {
        return this.getMaskTabContainer().getMaskTabPanel5().getImgMask5();
    }

    @JsonIgnore
    public void setImgMask5(StaticImage imgMask5) {
        this.getMaskTabContainer().getMaskTabPanel5().setImgMask5(imgMask5);
    }

    @JsonIgnore
    public maskTabPanel6Div getMaskTabPanel6() {
        return this.getMaskTabContainer().getMaskTabPanel6();
    }

    @JsonIgnore
    public void setMaskTabPanel6(maskTabPanel6Div maskTabPanel6) {
        this.getMaskTabContainer().setMaskTabPanel6(maskTabPanel6);
    }

    @JsonIgnore
    public StaticImage getImgMask6() {
        return this.getMaskTabContainer().getMaskTabPanel6().getImgMask6();
    }

    @JsonIgnore
    public void setImgMask6(StaticImage imgMask6) {
        this.getMaskTabContainer().getMaskTabPanel6().setImgMask6(imgMask6);
    }

    @JsonIgnore
    public maskTabPanel7Div getMaskTabPanel7() {
        return this.getMaskTabContainer().getMaskTabPanel7();
    }

    @JsonIgnore
    public void setMaskTabPanel7(maskTabPanel7Div maskTabPanel7) {
        this.getMaskTabContainer().setMaskTabPanel7(maskTabPanel7);
    }

    @JsonIgnore
    public StaticImage getImgMask7() {
        return this.getMaskTabContainer().getMaskTabPanel7().getImgMask7();
    }

    @JsonIgnore
    public void setImgMask7(StaticImage imgMask7) {
        this.getMaskTabContainer().getMaskTabPanel7().setImgMask7(imgMask7);
    }

    @JsonIgnore
    public maskTabPanel8Div getMaskTabPanel8() {
        return this.getMaskTabContainer().getMaskTabPanel8();
    }

    @JsonIgnore
    public void setMaskTabPanel8(maskTabPanel8Div maskTabPanel8) {
        this.getMaskTabContainer().setMaskTabPanel8(maskTabPanel8);
    }

    @JsonIgnore
    public StaticImage getImgMask8() {
        return this.getMaskTabContainer().getMaskTabPanel8().getImgMask8();
    }

    @JsonIgnore
    public void setImgMask8(StaticImage imgMask8) {
        this.getMaskTabContainer().getMaskTabPanel8().setImgMask8(imgMask8);
    }

    // </editor-fold>
    //--------------- この行より下にコードを追加してください -------------------
    /**
     * 画面初期化
     *
     * @param imgGneponPathList
     * @param imgMaskPathList
     * @param genponTitleList
     * @param maskTitleList
     */
    @Override
    public void initialize(List<RString> imgGneponPathList, List<RString> imgMaskPathList,
            List<RString> genponTitleList, List<RString> maskTitleList) {
        // 引数保存例
        // パスのリスト:imgPath1,imgPath12,RString.Empty,imgPath14...(イメージがない場合、RString.Emptyを設定する)
        // タイトルリストのItem数はパスリストのItem数と一致してください。

        if (!imgGneponPathList.isEmpty()) {
            if (imgGneponPathList.size() >= 1) {
                getGenpoTabContainer().getGenpoTabPanel1().setVisible(true);
                getGenpoTabContainer().getGenpoTabPanel1().setTitle(genponTitleList.get(0));
                getGenpoTabContainer().getGenpoTabPanel1().getImgGenpo1().setSrc(imgGneponPathList.get(0));
                if (RString.isNullOrEmpty(imgGneponPathList.get(0))) {
                    getGenpoTabContainer().getGenpoTabPanel1().setDisabled(true);
                }
            }
            if (imgGneponPathList.size() >= 2) {
                getGenpoTabContainer().getGenpoTabPanel2().setVisible(true);
                getGenpoTabContainer().getGenpoTabPanel2().setTitle(genponTitleList.get(1));
                getGenpoTabContainer().getGenpoTabPanel2().getImgGenpo2().setSrc(imgGneponPathList.get(1));
                if (RString.isNullOrEmpty(imgGneponPathList.get(1))) {
                    getGenpoTabContainer().getGenpoTabPanel2().setDisabled(true);
                }
            }
            if (imgGneponPathList.size() >= 3) {
                getGenpoTabContainer().getGenpoTabPanel3().setVisible(true);
                getGenpoTabContainer().getGenpoTabPanel3().setTitle(genponTitleList.get(2));
                getGenpoTabContainer().getGenpoTabPanel3().getImgGenpo3().setSrc(imgGneponPathList.get(2));
                if (RString.isNullOrEmpty(imgGneponPathList.get(2))) {
                    getGenpoTabContainer().getGenpoTabPanel3().setDisabled(true);
                }
            }
            if (imgGneponPathList.size() >= 4) {
                getGenpoTabContainer().getGenpoTabPanel4().setVisible(true);
                getGenpoTabContainer().getGenpoTabPanel4().setTitle(genponTitleList.get(3));
                getGenpoTabContainer().getGenpoTabPanel4().getImgGenpo4().setSrc(imgGneponPathList.get(3));
                if (RString.isNullOrEmpty(imgGneponPathList.get(3))) {
                    getGenpoTabContainer().getGenpoTabPanel4().setDisabled(true);
                }
            }
            if (imgGneponPathList.size() >= 5) {
                getGenpoTabContainer().getGenpoTabPanel5().setVisible(true);
                getGenpoTabContainer().getGenpoTabPanel5().setTitle(genponTitleList.get(4));
                getGenpoTabContainer().getGenpoTabPanel5().getImgGenpo5().setSrc(imgGneponPathList.get(4));
                if (RString.isNullOrEmpty(imgGneponPathList.get(4))) {
                    getGenpoTabContainer().getGenpoTabPanel5().setDisabled(true);
                }
            }
            if (imgGneponPathList.size() >= 6) {
                getGenpoTabContainer().getGenpoTabPanel6().setVisible(true);
                getGenpoTabContainer().getGenpoTabPanel6().setTitle(genponTitleList.get(5));
                getGenpoTabContainer().getGenpoTabPanel6().getImgGenpo6().setSrc(imgGneponPathList.get(5));
                if (RString.isNullOrEmpty(imgGneponPathList.get(5))) {
                    getGenpoTabContainer().getGenpoTabPanel6().setDisabled(true);
                }
            }
            if (imgGneponPathList.size() >= 7) {
                getGenpoTabContainer().getGenpoTabPanel7().setVisible(true);
                getGenpoTabContainer().getGenpoTabPanel7().setTitle(genponTitleList.get(6));
                getGenpoTabContainer().getGenpoTabPanel7().getImgGenpo7().setSrc(imgGneponPathList.get(6));
                if (RString.isNullOrEmpty(imgGneponPathList.get(6))) {
                    getGenpoTabContainer().getGenpoTabPanel7().setDisabled(true);
                }
            }
            if (imgGneponPathList.size() >= 8) {
                getGenpoTabContainer().getGenpoTabPanel8().setVisible(true);
                getGenpoTabContainer().getGenpoTabPanel8().setTitle(genponTitleList.get(7));
                getGenpoTabContainer().getGenpoTabPanel8().getImgGenpo8().setSrc(imgGneponPathList.get(7));
                if (RString.isNullOrEmpty(imgGneponPathList.get(7))) {
                    getGenpoTabContainer().getGenpoTabPanel8().setDisabled(true);
                }
            }
        }

        if (!imgMaskPathList.isEmpty()) {
            if (imgMaskPathList.size() >= 1) {
                getMaskTabContainer().getMaskTabPanel1().setVisible(true);
                getMaskTabContainer().getMaskTabPanel1().setTitle(maskTitleList.get(0));
                if (!RString.isNullOrEmpty(imgMaskPathList.get(0))) {
                    getMaskTabContainer().getMaskTabPanel1().getImgMask1().setSrc(imgMaskPathList.get(0));
                } else {
                    getMaskTabContainer().getMaskTabPanel1().setDisabled(true);
                }
            }
            if (imgMaskPathList.size() >= 2) {
                getMaskTabContainer().getMaskTabPanel2().setVisible(true);
                getMaskTabContainer().getMaskTabPanel2().setTitle(maskTitleList.get(1));
                getMaskTabContainer().getMaskTabPanel2().getImgMask2().setSrc(imgMaskPathList.get(1));
                if (RString.isNullOrEmpty(imgMaskPathList.get(1))) {
                    getMaskTabContainer().getMaskTabPanel2().setDisabled(true);
                }
            }
            if (imgMaskPathList.size() >= 3) {
                getMaskTabContainer().getMaskTabPanel3().setVisible(true);
                getMaskTabContainer().getMaskTabPanel3().setTitle(maskTitleList.get(2));
                getMaskTabContainer().getMaskTabPanel3().getImgMask3().setSrc(imgMaskPathList.get(2));
                if (RString.isNullOrEmpty(imgMaskPathList.get(2))) {
                    getMaskTabContainer().getMaskTabPanel3().setDisabled(true);
                }
            }
            if (imgMaskPathList.size() >= 4) {
                getMaskTabContainer().getMaskTabPanel4().setVisible(true);
                getMaskTabContainer().getMaskTabPanel4().setTitle(maskTitleList.get(3));
                getMaskTabContainer().getMaskTabPanel4().getImgMask4().setSrc(imgMaskPathList.get(3));
                if (RString.isNullOrEmpty(imgMaskPathList.get(3))) {
                    getMaskTabContainer().getMaskTabPanel4().setDisabled(true);
                }
            }
            if (imgMaskPathList.size() >= 5) {
                getMaskTabContainer().getMaskTabPanel5().setVisible(true);
                getMaskTabContainer().getMaskTabPanel5().setTitle(maskTitleList.get(4));
                getMaskTabContainer().getMaskTabPanel5().getImgMask5().setSrc(imgMaskPathList.get(4));
                if (RString.isNullOrEmpty(imgMaskPathList.get(4))) {
                    getMaskTabContainer().getMaskTabPanel5().setDisabled(true);
                }
            }
            if (imgMaskPathList.size() >= 6) {
                getMaskTabContainer().getMaskTabPanel6().setVisible(true);
                getMaskTabContainer().getMaskTabPanel6().setTitle(maskTitleList.get(5));
                getMaskTabContainer().getMaskTabPanel6().getImgMask6().setSrc(imgMaskPathList.get(5));
                if (RString.isNullOrEmpty(imgMaskPathList.get(5))) {
                    getMaskTabContainer().getMaskTabPanel6().setDisabled(true);
                }
            }
            if (imgMaskPathList.size() >= 7) {
                getMaskTabContainer().getMaskTabPanel7().setVisible(true);
                getMaskTabContainer().getMaskTabPanel7().setTitle(maskTitleList.get(6));
                getMaskTabContainer().getMaskTabPanel7().getImgMask7().setSrc(imgMaskPathList.get(6));
                if (RString.isNullOrEmpty(imgMaskPathList.get(6))) {
                    getMaskTabContainer().getMaskTabPanel7().setDisabled(true);
                }
            }
            if (imgMaskPathList.size() >= 8) {
                getMaskTabContainer().getMaskTabPanel8().setVisible(true);
                getMaskTabContainer().getMaskTabPanel8().setTitle(maskTitleList.get(7));
                getMaskTabContainer().getMaskTabPanel8().getImgMask8().setSrc(imgMaskPathList.get(7));
                if (RString.isNullOrEmpty(imgMaskPathList.get(7))) {
                    getMaskTabContainer().getMaskTabPanel8().setDisabled(true);
                }
            }
        }
    }
}
