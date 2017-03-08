package jp.co.ndensan.reams.db.dbe.divcontroller.entity.commonchilddiv.tokkiimages.TokkiImagesPerKomoku;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.db.dbe.business.core.tokkiimages.TokkiRembanRenumberingResult;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.commonchilddiv.tokkiimages.Operation;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteichosahyoTokkijikos;
import jp.co.ndensan.reams.db.dbz.definition.core.ninteichosatokkijikou.NinteiChosaTokkiJikou;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.TypeSafeKey;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.ui.session.PanelSessionAccessor;

/**
 * TokkiImagesPerKomoku のクラスファイル
 *
 * @author 自動生成
 */
public class TokkiImagesPerKomokuDiv extends Panel implements ITokkiImagesPerKomokuDiv {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2017-02-23_13-41-30">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtNo1")
    private TextBox txtNo1;
    @JsonProperty("txtRemban1")
    private TextBoxNum txtRemban1;
    @JsonProperty("ImageTokki1")
    private ImageTokki1Div ImageTokki1;
    @JsonProperty("txtNewRemban1")
    private TextBoxNum txtNewRemban1;
    @JsonProperty("lin2")
    private HorizontalLine lin2;
    @JsonProperty("txtNo2")
    private TextBox txtNo2;
    @JsonProperty("txtRemban2")
    private TextBoxNum txtRemban2;
    @JsonProperty("ImageTokki2")
    private ImageTokki2Div ImageTokki2;
    @JsonProperty("txtNewRemban2")
    private TextBoxNum txtNewRemban2;
    @JsonProperty("lin3")
    private HorizontalLine lin3;
    @JsonProperty("txtNo3")
    private TextBox txtNo3;
    @JsonProperty("txtRemban3")
    private TextBoxNum txtRemban3;
    @JsonProperty("ImageTokki3")
    private ImageTokki3Div ImageTokki3;
    @JsonProperty("txtNewRemban3")
    private TextBoxNum txtNewRemban3;
    @JsonProperty("lin4")
    private HorizontalLine lin4;
    @JsonProperty("txtNo4")
    private TextBox txtNo4;
    @JsonProperty("txtRemban4")
    private TextBoxNum txtRemban4;
    @JsonProperty("ImageTokki4")
    private ImageTokki4Div ImageTokki4;
    @JsonProperty("txtNewRemban4")
    private TextBoxNum txtNewRemban4;
    @JsonProperty("lin5")
    private HorizontalLine lin5;
    @JsonProperty("txtNo5")
    private TextBox txtNo5;
    @JsonProperty("txtRemban5")
    private TextBoxNum txtRemban5;
    @JsonProperty("ImageTokki5")
    private ImageTokki5Div ImageTokki5;
    @JsonProperty("txtNewRemban5")
    private TextBoxNum txtNewRemban5;
    @JsonProperty("lin6")
    private HorizontalLine lin6;
    @JsonProperty("txtNo6")
    private TextBox txtNo6;
    @JsonProperty("txtRemban6")
    private TextBoxNum txtRemban6;
    @JsonProperty("ImageTokki6")
    private ImageTokki6Div ImageTokki6;
    @JsonProperty("txtNewRemban6")
    private TextBoxNum txtNewRemban6;
    @JsonProperty("lin7")
    private HorizontalLine lin7;
    @JsonProperty("txtNo7")
    private TextBox txtNo7;
    @JsonProperty("txtRemban7")
    private TextBoxNum txtRemban7;
    @JsonProperty("ImageTokki7")
    private ImageTokki7Div ImageTokki7;
    @JsonProperty("txtNewRemban7")
    private TextBoxNum txtNewRemban7;
    @JsonProperty("lin8")
    private HorizontalLine lin8;
    @JsonProperty("txtNo8")
    private TextBox txtNo8;
    @JsonProperty("txtRemban8")
    private TextBoxNum txtRemban8;
    @JsonProperty("ImageTokki8")
    private ImageTokki8Div ImageTokki8;
    @JsonProperty("txtNewRemban8")
    private TextBoxNum txtNewRemban8;
    @JsonProperty("lin9")
    private HorizontalLine lin9;
    @JsonProperty("txtNo9")
    private TextBox txtNo9;
    @JsonProperty("txtRemban9")
    private TextBoxNum txtRemban9;
    @JsonProperty("ImageTokki9")
    private ImageTokki9Div ImageTokki9;
    @JsonProperty("txtNewRemban9")
    private TextBoxNum txtNewRemban9;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtNo1
     * @return txtNo1
     */
    @JsonProperty("txtNo1")
    public TextBox getTxtNo1() {
        return txtNo1;
    }

    /*
     * settxtNo1
     * @param txtNo1 txtNo1
     */
    @JsonProperty("txtNo1")
    public void setTxtNo1(TextBox txtNo1) {
        this.txtNo1 = txtNo1;
    }

    /*
     * gettxtRemban1
     * @return txtRemban1
     */
    @JsonProperty("txtRemban1")
    public TextBoxNum getTxtRemban1() {
        return txtRemban1;
    }

    /*
     * settxtRemban1
     * @param txtRemban1 txtRemban1
     */
    @JsonProperty("txtRemban1")
    public void setTxtRemban1(TextBoxNum txtRemban1) {
        this.txtRemban1 = txtRemban1;
    }

    /*
     * getImageTokki1
     * @return ImageTokki1
     */
    @JsonProperty("ImageTokki1")
    public ImageTokki1Div getImageTokki1() {
        return ImageTokki1;
    }

    /*
     * setImageTokki1
     * @param ImageTokki1 ImageTokki1
     */
    @JsonProperty("ImageTokki1")
    public void setImageTokki1(ImageTokki1Div ImageTokki1) {
        this.ImageTokki1 = ImageTokki1;
    }

    /*
     * gettxtNewRemban1
     * @return txtNewRemban1
     */
    @JsonProperty("txtNewRemban1")
    public TextBoxNum getTxtNewRemban1() {
        return txtNewRemban1;
    }

    /*
     * settxtNewRemban1
     * @param txtNewRemban1 txtNewRemban1
     */
    @JsonProperty("txtNewRemban1")
    public void setTxtNewRemban1(TextBoxNum txtNewRemban1) {
        this.txtNewRemban1 = txtNewRemban1;
    }

    /*
     * getlin2
     * @return lin2
     */
    @JsonProperty("lin2")
    public HorizontalLine getLin2() {
        return lin2;
    }

    /*
     * setlin2
     * @param lin2 lin2
     */
    @JsonProperty("lin2")
    public void setLin2(HorizontalLine lin2) {
        this.lin2 = lin2;
    }

    /*
     * gettxtNo2
     * @return txtNo2
     */
    @JsonProperty("txtNo2")
    public TextBox getTxtNo2() {
        return txtNo2;
    }

    /*
     * settxtNo2
     * @param txtNo2 txtNo2
     */
    @JsonProperty("txtNo2")
    public void setTxtNo2(TextBox txtNo2) {
        this.txtNo2 = txtNo2;
    }

    /*
     * gettxtRemban2
     * @return txtRemban2
     */
    @JsonProperty("txtRemban2")
    public TextBoxNum getTxtRemban2() {
        return txtRemban2;
    }

    /*
     * settxtRemban2
     * @param txtRemban2 txtRemban2
     */
    @JsonProperty("txtRemban2")
    public void setTxtRemban2(TextBoxNum txtRemban2) {
        this.txtRemban2 = txtRemban2;
    }

    /*
     * getImageTokki2
     * @return ImageTokki2
     */
    @JsonProperty("ImageTokki2")
    public ImageTokki2Div getImageTokki2() {
        return ImageTokki2;
    }

    /*
     * setImageTokki2
     * @param ImageTokki2 ImageTokki2
     */
    @JsonProperty("ImageTokki2")
    public void setImageTokki2(ImageTokki2Div ImageTokki2) {
        this.ImageTokki2 = ImageTokki2;
    }

    /*
     * gettxtNewRemban2
     * @return txtNewRemban2
     */
    @JsonProperty("txtNewRemban2")
    public TextBoxNum getTxtNewRemban2() {
        return txtNewRemban2;
    }

    /*
     * settxtNewRemban2
     * @param txtNewRemban2 txtNewRemban2
     */
    @JsonProperty("txtNewRemban2")
    public void setTxtNewRemban2(TextBoxNum txtNewRemban2) {
        this.txtNewRemban2 = txtNewRemban2;
    }

    /*
     * getlin3
     * @return lin3
     */
    @JsonProperty("lin3")
    public HorizontalLine getLin3() {
        return lin3;
    }

    /*
     * setlin3
     * @param lin3 lin3
     */
    @JsonProperty("lin3")
    public void setLin3(HorizontalLine lin3) {
        this.lin3 = lin3;
    }

    /*
     * gettxtNo3
     * @return txtNo3
     */
    @JsonProperty("txtNo3")
    public TextBox getTxtNo3() {
        return txtNo3;
    }

    /*
     * settxtNo3
     * @param txtNo3 txtNo3
     */
    @JsonProperty("txtNo3")
    public void setTxtNo3(TextBox txtNo3) {
        this.txtNo3 = txtNo3;
    }

    /*
     * gettxtRemban3
     * @return txtRemban3
     */
    @JsonProperty("txtRemban3")
    public TextBoxNum getTxtRemban3() {
        return txtRemban3;
    }

    /*
     * settxtRemban3
     * @param txtRemban3 txtRemban3
     */
    @JsonProperty("txtRemban3")
    public void setTxtRemban3(TextBoxNum txtRemban3) {
        this.txtRemban3 = txtRemban3;
    }

    /*
     * getImageTokki3
     * @return ImageTokki3
     */
    @JsonProperty("ImageTokki3")
    public ImageTokki3Div getImageTokki3() {
        return ImageTokki3;
    }

    /*
     * setImageTokki3
     * @param ImageTokki3 ImageTokki3
     */
    @JsonProperty("ImageTokki3")
    public void setImageTokki3(ImageTokki3Div ImageTokki3) {
        this.ImageTokki3 = ImageTokki3;
    }

    /*
     * gettxtNewRemban3
     * @return txtNewRemban3
     */
    @JsonProperty("txtNewRemban3")
    public TextBoxNum getTxtNewRemban3() {
        return txtNewRemban3;
    }

    /*
     * settxtNewRemban3
     * @param txtNewRemban3 txtNewRemban3
     */
    @JsonProperty("txtNewRemban3")
    public void setTxtNewRemban3(TextBoxNum txtNewRemban3) {
        this.txtNewRemban3 = txtNewRemban3;
    }

    /*
     * getlin4
     * @return lin4
     */
    @JsonProperty("lin4")
    public HorizontalLine getLin4() {
        return lin4;
    }

    /*
     * setlin4
     * @param lin4 lin4
     */
    @JsonProperty("lin4")
    public void setLin4(HorizontalLine lin4) {
        this.lin4 = lin4;
    }

    /*
     * gettxtNo4
     * @return txtNo4
     */
    @JsonProperty("txtNo4")
    public TextBox getTxtNo4() {
        return txtNo4;
    }

    /*
     * settxtNo4
     * @param txtNo4 txtNo4
     */
    @JsonProperty("txtNo4")
    public void setTxtNo4(TextBox txtNo4) {
        this.txtNo4 = txtNo4;
    }

    /*
     * gettxtRemban4
     * @return txtRemban4
     */
    @JsonProperty("txtRemban4")
    public TextBoxNum getTxtRemban4() {
        return txtRemban4;
    }

    /*
     * settxtRemban4
     * @param txtRemban4 txtRemban4
     */
    @JsonProperty("txtRemban4")
    public void setTxtRemban4(TextBoxNum txtRemban4) {
        this.txtRemban4 = txtRemban4;
    }

    /*
     * getImageTokki4
     * @return ImageTokki4
     */
    @JsonProperty("ImageTokki4")
    public ImageTokki4Div getImageTokki4() {
        return ImageTokki4;
    }

    /*
     * setImageTokki4
     * @param ImageTokki4 ImageTokki4
     */
    @JsonProperty("ImageTokki4")
    public void setImageTokki4(ImageTokki4Div ImageTokki4) {
        this.ImageTokki4 = ImageTokki4;
    }

    /*
     * gettxtNewRemban4
     * @return txtNewRemban4
     */
    @JsonProperty("txtNewRemban4")
    public TextBoxNum getTxtNewRemban4() {
        return txtNewRemban4;
    }

    /*
     * settxtNewRemban4
     * @param txtNewRemban4 txtNewRemban4
     */
    @JsonProperty("txtNewRemban4")
    public void setTxtNewRemban4(TextBoxNum txtNewRemban4) {
        this.txtNewRemban4 = txtNewRemban4;
    }

    /*
     * getlin5
     * @return lin5
     */
    @JsonProperty("lin5")
    public HorizontalLine getLin5() {
        return lin5;
    }

    /*
     * setlin5
     * @param lin5 lin5
     */
    @JsonProperty("lin5")
    public void setLin5(HorizontalLine lin5) {
        this.lin5 = lin5;
    }

    /*
     * gettxtNo5
     * @return txtNo5
     */
    @JsonProperty("txtNo5")
    public TextBox getTxtNo5() {
        return txtNo5;
    }

    /*
     * settxtNo5
     * @param txtNo5 txtNo5
     */
    @JsonProperty("txtNo5")
    public void setTxtNo5(TextBox txtNo5) {
        this.txtNo5 = txtNo5;
    }

    /*
     * gettxtRemban5
     * @return txtRemban5
     */
    @JsonProperty("txtRemban5")
    public TextBoxNum getTxtRemban5() {
        return txtRemban5;
    }

    /*
     * settxtRemban5
     * @param txtRemban5 txtRemban5
     */
    @JsonProperty("txtRemban5")
    public void setTxtRemban5(TextBoxNum txtRemban5) {
        this.txtRemban5 = txtRemban5;
    }

    /*
     * getImageTokki5
     * @return ImageTokki5
     */
    @JsonProperty("ImageTokki5")
    public ImageTokki5Div getImageTokki5() {
        return ImageTokki5;
    }

    /*
     * setImageTokki5
     * @param ImageTokki5 ImageTokki5
     */
    @JsonProperty("ImageTokki5")
    public void setImageTokki5(ImageTokki5Div ImageTokki5) {
        this.ImageTokki5 = ImageTokki5;
    }

    /*
     * gettxtNewRemban5
     * @return txtNewRemban5
     */
    @JsonProperty("txtNewRemban5")
    public TextBoxNum getTxtNewRemban5() {
        return txtNewRemban5;
    }

    /*
     * settxtNewRemban5
     * @param txtNewRemban5 txtNewRemban5
     */
    @JsonProperty("txtNewRemban5")
    public void setTxtNewRemban5(TextBoxNum txtNewRemban5) {
        this.txtNewRemban5 = txtNewRemban5;
    }

    /*
     * getlin6
     * @return lin6
     */
    @JsonProperty("lin6")
    public HorizontalLine getLin6() {
        return lin6;
    }

    /*
     * setlin6
     * @param lin6 lin6
     */
    @JsonProperty("lin6")
    public void setLin6(HorizontalLine lin6) {
        this.lin6 = lin6;
    }

    /*
     * gettxtNo6
     * @return txtNo6
     */
    @JsonProperty("txtNo6")
    public TextBox getTxtNo6() {
        return txtNo6;
    }

    /*
     * settxtNo6
     * @param txtNo6 txtNo6
     */
    @JsonProperty("txtNo6")
    public void setTxtNo6(TextBox txtNo6) {
        this.txtNo6 = txtNo6;
    }

    /*
     * gettxtRemban6
     * @return txtRemban6
     */
    @JsonProperty("txtRemban6")
    public TextBoxNum getTxtRemban6() {
        return txtRemban6;
    }

    /*
     * settxtRemban6
     * @param txtRemban6 txtRemban6
     */
    @JsonProperty("txtRemban6")
    public void setTxtRemban6(TextBoxNum txtRemban6) {
        this.txtRemban6 = txtRemban6;
    }

    /*
     * getImageTokki6
     * @return ImageTokki6
     */
    @JsonProperty("ImageTokki6")
    public ImageTokki6Div getImageTokki6() {
        return ImageTokki6;
    }

    /*
     * setImageTokki6
     * @param ImageTokki6 ImageTokki6
     */
    @JsonProperty("ImageTokki6")
    public void setImageTokki6(ImageTokki6Div ImageTokki6) {
        this.ImageTokki6 = ImageTokki6;
    }

    /*
     * gettxtNewRemban6
     * @return txtNewRemban6
     */
    @JsonProperty("txtNewRemban6")
    public TextBoxNum getTxtNewRemban6() {
        return txtNewRemban6;
    }

    /*
     * settxtNewRemban6
     * @param txtNewRemban6 txtNewRemban6
     */
    @JsonProperty("txtNewRemban6")
    public void setTxtNewRemban6(TextBoxNum txtNewRemban6) {
        this.txtNewRemban6 = txtNewRemban6;
    }

    /*
     * getlin7
     * @return lin7
     */
    @JsonProperty("lin7")
    public HorizontalLine getLin7() {
        return lin7;
    }

    /*
     * setlin7
     * @param lin7 lin7
     */
    @JsonProperty("lin7")
    public void setLin7(HorizontalLine lin7) {
        this.lin7 = lin7;
    }

    /*
     * gettxtNo7
     * @return txtNo7
     */
    @JsonProperty("txtNo7")
    public TextBox getTxtNo7() {
        return txtNo7;
    }

    /*
     * settxtNo7
     * @param txtNo7 txtNo7
     */
    @JsonProperty("txtNo7")
    public void setTxtNo7(TextBox txtNo7) {
        this.txtNo7 = txtNo7;
    }

    /*
     * gettxtRemban7
     * @return txtRemban7
     */
    @JsonProperty("txtRemban7")
    public TextBoxNum getTxtRemban7() {
        return txtRemban7;
    }

    /*
     * settxtRemban7
     * @param txtRemban7 txtRemban7
     */
    @JsonProperty("txtRemban7")
    public void setTxtRemban7(TextBoxNum txtRemban7) {
        this.txtRemban7 = txtRemban7;
    }

    /*
     * getImageTokki7
     * @return ImageTokki7
     */
    @JsonProperty("ImageTokki7")
    public ImageTokki7Div getImageTokki7() {
        return ImageTokki7;
    }

    /*
     * setImageTokki7
     * @param ImageTokki7 ImageTokki7
     */
    @JsonProperty("ImageTokki7")
    public void setImageTokki7(ImageTokki7Div ImageTokki7) {
        this.ImageTokki7 = ImageTokki7;
    }

    /*
     * gettxtNewRemban7
     * @return txtNewRemban7
     */
    @JsonProperty("txtNewRemban7")
    public TextBoxNum getTxtNewRemban7() {
        return txtNewRemban7;
    }

    /*
     * settxtNewRemban7
     * @param txtNewRemban7 txtNewRemban7
     */
    @JsonProperty("txtNewRemban7")
    public void setTxtNewRemban7(TextBoxNum txtNewRemban7) {
        this.txtNewRemban7 = txtNewRemban7;
    }

    /*
     * getlin8
     * @return lin8
     */
    @JsonProperty("lin8")
    public HorizontalLine getLin8() {
        return lin8;
    }

    /*
     * setlin8
     * @param lin8 lin8
     */
    @JsonProperty("lin8")
    public void setLin8(HorizontalLine lin8) {
        this.lin8 = lin8;
    }

    /*
     * gettxtNo8
     * @return txtNo8
     */
    @JsonProperty("txtNo8")
    public TextBox getTxtNo8() {
        return txtNo8;
    }

    /*
     * settxtNo8
     * @param txtNo8 txtNo8
     */
    @JsonProperty("txtNo8")
    public void setTxtNo8(TextBox txtNo8) {
        this.txtNo8 = txtNo8;
    }

    /*
     * gettxtRemban8
     * @return txtRemban8
     */
    @JsonProperty("txtRemban8")
    public TextBoxNum getTxtRemban8() {
        return txtRemban8;
    }

    /*
     * settxtRemban8
     * @param txtRemban8 txtRemban8
     */
    @JsonProperty("txtRemban8")
    public void setTxtRemban8(TextBoxNum txtRemban8) {
        this.txtRemban8 = txtRemban8;
    }

    /*
     * getImageTokki8
     * @return ImageTokki8
     */
    @JsonProperty("ImageTokki8")
    public ImageTokki8Div getImageTokki8() {
        return ImageTokki8;
    }

    /*
     * setImageTokki8
     * @param ImageTokki8 ImageTokki8
     */
    @JsonProperty("ImageTokki8")
    public void setImageTokki8(ImageTokki8Div ImageTokki8) {
        this.ImageTokki8 = ImageTokki8;
    }

    /*
     * gettxtNewRemban8
     * @return txtNewRemban8
     */
    @JsonProperty("txtNewRemban8")
    public TextBoxNum getTxtNewRemban8() {
        return txtNewRemban8;
    }

    /*
     * settxtNewRemban8
     * @param txtNewRemban8 txtNewRemban8
     */
    @JsonProperty("txtNewRemban8")
    public void setTxtNewRemban8(TextBoxNum txtNewRemban8) {
        this.txtNewRemban8 = txtNewRemban8;
    }

    /*
     * getlin9
     * @return lin9
     */
    @JsonProperty("lin9")
    public HorizontalLine getLin9() {
        return lin9;
    }

    /*
     * setlin9
     * @param lin9 lin9
     */
    @JsonProperty("lin9")
    public void setLin9(HorizontalLine lin9) {
        this.lin9 = lin9;
    }

    /*
     * gettxtNo9
     * @return txtNo9
     */
    @JsonProperty("txtNo9")
    public TextBox getTxtNo9() {
        return txtNo9;
    }

    /*
     * settxtNo9
     * @param txtNo9 txtNo9
     */
    @JsonProperty("txtNo9")
    public void setTxtNo9(TextBox txtNo9) {
        this.txtNo9 = txtNo9;
    }

    /*
     * gettxtRemban9
     * @return txtRemban9
     */
    @JsonProperty("txtRemban9")
    public TextBoxNum getTxtRemban9() {
        return txtRemban9;
    }

    /*
     * settxtRemban9
     * @param txtRemban9 txtRemban9
     */
    @JsonProperty("txtRemban9")
    public void setTxtRemban9(TextBoxNum txtRemban9) {
        this.txtRemban9 = txtRemban9;
    }

    /*
     * getImageTokki9
     * @return ImageTokki9
     */
    @JsonProperty("ImageTokki9")
    public ImageTokki9Div getImageTokki9() {
        return ImageTokki9;
    }

    /*
     * setImageTokki9
     * @param ImageTokki9 ImageTokki9
     */
    @JsonProperty("ImageTokki9")
    public void setImageTokki9(ImageTokki9Div ImageTokki9) {
        this.ImageTokki9 = ImageTokki9;
    }

    /*
     * gettxtNewRemban9
     * @return txtNewRemban9
     */
    @JsonProperty("txtNewRemban9")
    public TextBoxNum getTxtNewRemban9() {
        return txtNewRemban9;
    }

    /*
     * settxtNewRemban9
     * @param txtNewRemban9 txtNewRemban9
     */
    @JsonProperty("txtNewRemban9")
    public void setTxtNewRemban9(TextBoxNum txtNewRemban9) {
        this.txtNewRemban9 = txtNewRemban9;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public DynamicImage getImgTokki1() {
        return this.getImageTokki1().getImgTokki1();
    }

    @JsonIgnore
    public void setImgTokki1(DynamicImage imgTokki1) {
        this.getImageTokki1().setImgTokki1(imgTokki1);
    }

    @JsonIgnore
    public DynamicImage getImgTokki2() {
        return this.getImageTokki2().getImgTokki2();
    }

    @JsonIgnore
    public void setImgTokki2(DynamicImage imgTokki2) {
        this.getImageTokki2().setImgTokki2(imgTokki2);
    }

    @JsonIgnore
    public DynamicImage getImgTokki3() {
        return this.getImageTokki3().getImgTokki3();
    }

    @JsonIgnore
    public void setImgTokki3(DynamicImage imgTokki3) {
        this.getImageTokki3().setImgTokki3(imgTokki3);
    }

    @JsonIgnore
    public DynamicImage getImgTokki4() {
        return this.getImageTokki4().getImgTokki4();
    }

    @JsonIgnore
    public void setImgTokki4(DynamicImage imgTokki4) {
        this.getImageTokki4().setImgTokki4(imgTokki4);
    }

    @JsonIgnore
    public DynamicImage getImgTokki5() {
        return this.getImageTokki5().getImgTokki5();
    }

    @JsonIgnore
    public void setImgTokki5(DynamicImage imgTokki5) {
        this.getImageTokki5().setImgTokki5(imgTokki5);
    }

    @JsonIgnore
    public DynamicImage getImgTokki6() {
        return this.getImageTokki6().getImgTokki6();
    }

    @JsonIgnore
    public void setImgTokki6(DynamicImage imgTokki6) {
        this.getImageTokki6().setImgTokki6(imgTokki6);
    }

    @JsonIgnore
    public DynamicImage getImgTokki7() {
        return this.getImageTokki7().getImgTokki7();
    }

    @JsonIgnore
    public void setImgTokki7(DynamicImage imgTokki7) {
        this.getImageTokki7().setImgTokki7(imgTokki7);
    }

    @JsonIgnore
    public DynamicImage getImgTokki8() {
        return this.getImageTokki8().getImgTokki8();
    }

    @JsonIgnore
    public void setImgTokki8(DynamicImage imgTokki8) {
        this.getImageTokki8().setImgTokki8(imgTokki8);
    }

    @JsonIgnore
    public DynamicImage getImgTokki9() {
        return this.getImageTokki9().getImgTokki9();
    }

    @JsonIgnore
    public void setImgTokki9(DynamicImage imgTokki9) {
        this.getImageTokki9().setImgTokki9(imgTokki9);
    }

    // </editor-fold>
    //--------------- この行より下にコードを追加してください -------------------
    @Override
    public void initialize(RString directoryPath, NinteichosahyoTokkijikos nts, NinteiChosaTokkiJikou tokkiJiko, Operation op) {
        newHandler(this).initialize(directoryPath, nts, tokkiJiko, op);
    }

    @Override
    public void refresh(RString directoryPath, NinteichosahyoTokkijikos nts, Operation op) {
        newHandler(this).refresh(directoryPath, nts, op);
    }

    @Override
    public boolean isDirty() {
        return newHandler(this).isDirty();
    }

    @Override
    public TokkiRembanRenumberingResult asRenumberingResult() {
        return newHandler(this).createRenumberingResult();
    }

    private static final TypeSafeKey<NinteichosahyoTokkijikos> TOKKIJIKO_KEY
            = TypeSafeKey.create(NinteichosahyoTokkijikos.class, "tokkiJiko");

    /**
     * この共有子Divで扱う「特記事項」の種類を設定します。
     *
     * @param tokkiJiko 特記事項
     */
    void setTokkijiko(NinteichosahyoTokkijikos tokkiJiko) {
        PanelSessionAccessor.put(this, TOKKIJIKO_KEY.value(), tokkiJiko);
    }

    NinteichosahyoTokkijikos getTokkijiko() {
        return PanelSessionAccessor.get(this, TOKKIJIKO_KEY.value(), TOKKIJIKO_KEY.type());
    }

    @Override
    public ValidationMessageControlPairs validate() {
        return newHandler(this).validate();
    }

    private static TokkiImagesPerKomokuDivHandler newHandler(TokkiImagesPerKomokuDiv div) {
        return new TokkiImagesPerKomokuDivHandler(div);
    }
}
