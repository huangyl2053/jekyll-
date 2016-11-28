package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ChosaTokkiShokai.ChosaTokkiShokai;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.ArrayList;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.business.core.basic.Image;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteichosahyoTokkijiko;
import jp.co.ndensan.reams.db.dbz.definition.core.ninteichosatokkijikou.NinteiChosaTokkiJikou;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.GenponMaskKubun;
import jp.co.ndensan.reams.db.dbz.service.core.basic.ImageManager;
import jp.co.ndensan.reams.db.dbz.service.core.basic.NinteichosahyoTokkijikoManager;
import jp.co.ndensan.reams.db.dbz.service.core.chosatokkishokai.ChosaTokkiShokaiFinder;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.cooperation.FilesystemName;
import jp.co.ndensan.reams.uz.uza.cooperation.FilesystemPath;
import jp.co.ndensan.reams.uz.uza.cooperation.SharedFile;
import jp.co.ndensan.reams.uz.uza.cooperation.descriptor.ReadOnlySharedFileEntryDescriptor;
import jp.co.ndensan.reams.uz.uza.io.File;
import jp.co.ndensan.reams.uz.uza.io.Path;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.ui.binding.Label;
import jp.co.ndensan.reams.uz.uza.ui.binding.StaticImage;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBox;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxMultiLine;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxNum;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * ChosaTokkiShokai のクラスファイル
 *
 * @reamsid_L DBE-3000-200 liangbc
 */
public class ChosaTokkiShokaiDiv extends Panel implements IChosaTokkiShokaiDiv {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-10-31_08-44-29">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtTokkiJikouNo")
    private TextBox txtTokkiJikouNo;
    @JsonProperty("txtTokkiJikouName")
    private TextBox txtTokkiJikouName;
    @JsonProperty("lblTextGenpon")
    private Label lblTextGenpon;
    @JsonProperty("lblTextMask")
    private Label lblTextMask;
    @JsonProperty("txtTokkijikoNo1")
    private TextBox txtTokkijikoNo1;
    @JsonProperty("lbl1")
    private Label lbl1;
    @JsonProperty("txtRemban1")
    private TextBoxNum txtRemban1;
    @JsonProperty("txtTextGenpo1")
    private TextBoxMultiLine txtTextGenpo1;
    @JsonProperty("txtTextMask1")
    private TextBoxMultiLine txtTextMask1;
    @JsonProperty("txtTokkijikoNo2")
    private TextBox txtTokkijikoNo2;
    @JsonProperty("lbl2")
    private Label lbl2;
    @JsonProperty("txtRemban2")
    private TextBoxNum txtRemban2;
    @JsonProperty("txtTextGenpo2")
    private TextBoxMultiLine txtTextGenpo2;
    @JsonProperty("txtTextMask2")
    private TextBoxMultiLine txtTextMask2;
    @JsonProperty("txtTokkijikoNo3")
    private TextBox txtTokkijikoNo3;
    @JsonProperty("lbl3")
    private Label lbl3;
    @JsonProperty("txtRemban3")
    private TextBoxNum txtRemban3;
    @JsonProperty("txtTextGenpo3")
    private TextBoxMultiLine txtTextGenpo3;
    @JsonProperty("txtTextMask3")
    private TextBoxMultiLine txtTextMask3;
    @JsonProperty("txtTokkijikoNo4")
    private TextBox txtTokkijikoNo4;
    @JsonProperty("lbl4")
    private Label lbl4;
    @JsonProperty("txtRemban4")
    private TextBoxNum txtRemban4;
    @JsonProperty("txtTextGenpo4")
    private TextBoxMultiLine txtTextGenpo4;
    @JsonProperty("txtTextMask4")
    private TextBoxMultiLine txtTextMask4;
    @JsonProperty("txtTokkijikoNo5")
    private TextBox txtTokkijikoNo5;
    @JsonProperty("lbl5")
    private Label lbl5;
    @JsonProperty("txtRemban5")
    private TextBoxNum txtRemban5;
    @JsonProperty("txtTextGenpo5")
    private TextBoxMultiLine txtTextGenpo5;
    @JsonProperty("txtTextMask5")
    private TextBoxMultiLine txtTextMask5;
    @JsonProperty("txtTokkijikoNo6")
    private TextBox txtTokkijikoNo6;
    @JsonProperty("lbl6")
    private Label lbl6;
    @JsonProperty("txtRemban6")
    private TextBoxNum txtRemban6;
    @JsonProperty("txtTextGenpo6")
    private TextBoxMultiLine txtTextGenpo6;
    @JsonProperty("txtTextMask6")
    private TextBoxMultiLine txtTextMask6;
    @JsonProperty("txtTokkijikoNo7")
    private TextBox txtTokkijikoNo7;
    @JsonProperty("lbl7")
    private Label lbl7;
    @JsonProperty("txtRemban7")
    private TextBoxNum txtRemban7;
    @JsonProperty("txtTextGenpo7")
    private TextBoxMultiLine txtTextGenpo7;
    @JsonProperty("txtTextMask7")
    private TextBoxMultiLine txtTextMask7;
    @JsonProperty("txtTokkijikoNo8")
    private TextBox txtTokkijikoNo8;
    @JsonProperty("lbl8")
    private Label lbl8;
    @JsonProperty("txtRemban8")
    private TextBoxNum txtRemban8;
    @JsonProperty("txtTextGenpo8")
    private TextBoxMultiLine txtTextGenpo8;
    @JsonProperty("txtTextMask8")
    private TextBoxMultiLine txtTextMask8;
    @JsonProperty("txtTokkijikoNo9")
    private TextBox txtTokkijikoNo9;
    @JsonProperty("lbl9")
    private Label lbl9;
    @JsonProperty("txtRemban9")
    private TextBoxNum txtRemban9;
    @JsonProperty("txtTextGenpo9")
    private TextBoxMultiLine txtTextGenpo9;
    @JsonProperty("txtTextMask9")
    private TextBoxMultiLine txtTextMask9;
    @JsonProperty("txtTokkijikoNo10")
    private TextBox txtTokkijikoNo10;
    @JsonProperty("lbl10")
    private Label lbl10;
    @JsonProperty("txtRemban10")
    private TextBoxNum txtRemban10;
    @JsonProperty("txtTextGenpo10")
    private TextBoxMultiLine txtTextGenpo10;
    @JsonProperty("txtTextMask10")
    private TextBoxMultiLine txtTextMask10;
    @JsonProperty("txtTokkijikoNo11")
    private TextBox txtTokkijikoNo11;
    @JsonProperty("lbl11")
    private Label lbl11;
    @JsonProperty("txtRemban11")
    private TextBoxNum txtRemban11;
    @JsonProperty("imgGenpo1")
    private StaticImage imgGenpo1;
    @JsonProperty("imgMasking1")
    private StaticImage imgMasking1;
    @JsonProperty("txtTokkijikoNo12")
    private TextBox txtTokkijikoNo12;
    @JsonProperty("lbl12")
    private Label lbl12;
    @JsonProperty("txtRemban12")
    private TextBoxNum txtRemban12;
    @JsonProperty("imgGenpo2")
    private StaticImage imgGenpo2;
    @JsonProperty("imgMasking2")
    private StaticImage imgMasking2;
    @JsonProperty("txtTokkijikoNo13")
    private TextBox txtTokkijikoNo13;
    @JsonProperty("lbl13")
    private Label lbl13;
    @JsonProperty("txtRemban13")
    private TextBoxNum txtRemban13;
    @JsonProperty("imgGenpo3")
    private StaticImage imgGenpo3;
    @JsonProperty("imgMasking3")
    private StaticImage imgMasking3;
    @JsonProperty("txtTokkijikoNo14")
    private TextBox txtTokkijikoNo14;
    @JsonProperty("lbl14")
    private Label lbl14;
    @JsonProperty("txtRemban14")
    private TextBoxNum txtRemban14;
    @JsonProperty("imgGenpo4")
    private StaticImage imgGenpo4;
    @JsonProperty("imgMasking4")
    private StaticImage imgMasking4;
    @JsonProperty("txtTokkijikoNo15")
    private TextBox txtTokkijikoNo15;
    @JsonProperty("lbl15")
    private Label lbl15;
    @JsonProperty("txtRemban15")
    private TextBoxNum txtRemban15;
    @JsonProperty("imgGenpo5")
    private StaticImage imgGenpo5;
    @JsonProperty("imgMasking5")
    private StaticImage imgMasking5;
    @JsonProperty("txtTokkijikoNo16")
    private TextBox txtTokkijikoNo16;
    @JsonProperty("lbl16")
    private Label lbl16;
    @JsonProperty("txtRemban16")
    private TextBoxNum txtRemban16;
    @JsonProperty("imgGenpo6")
    private StaticImage imgGenpo6;
    @JsonProperty("imgMasking6")
    private StaticImage imgMasking6;
    @JsonProperty("txtTokkijikoNo17")
    private TextBox txtTokkijikoNo17;
    @JsonProperty("lbl17")
    private Label lbl17;
    @JsonProperty("txtRemban17")
    private TextBoxNum txtRemban17;
    @JsonProperty("imgGenpo7")
    private StaticImage imgGenpo7;
    @JsonProperty("imgMasking7")
    private StaticImage imgMasking7;
    @JsonProperty("txtTokkijikoNo18")
    private TextBox txtTokkijikoNo18;
    @JsonProperty("lbl18")
    private Label lbl18;
    @JsonProperty("txtRemban18")
    private TextBoxNum txtRemban18;
    @JsonProperty("imgGenpo8")
    private StaticImage imgGenpo8;
    @JsonProperty("imgMasking8")
    private StaticImage imgMasking8;
    @JsonProperty("txtTokkijikoNo19")
    private TextBox txtTokkijikoNo19;
    @JsonProperty("lbl19")
    private Label lbl19;
    @JsonProperty("txtRemban19")
    private TextBoxNum txtRemban19;
    @JsonProperty("imgGenpo9")
    private StaticImage imgGenpo9;
    @JsonProperty("imgMasking9")
    private StaticImage imgMasking9;
    @JsonProperty("txtTokkijikoNo20")
    private TextBox txtTokkijikoNo20;
    @JsonProperty("lbl20")
    private Label lbl20;
    @JsonProperty("txtRemban20")
    private TextBoxNum txtRemban20;
    @JsonProperty("imgGenpo10")
    private StaticImage imgGenpo10;
    @JsonProperty("imgMasking10")
    private StaticImage imgMasking10;
    @JsonProperty("btnReturn")
    private Button btnReturn;
    @JsonProperty("shinseishoKanriNo")
    private RString shinseishoKanriNo;
    @JsonProperty("maxRemban")
    private RString maxRemban;
    @JsonProperty("maxTokkijikoNo")
    private RString maxTokkijikoNo;
    @JsonProperty("minTokkijikoNo")
    private RString minTokkijikoNo;
    @JsonProperty("rembanPageNo")
    private RString rembanPageNo;
    @JsonProperty("tokkijikoNoPageNo")
    private RString tokkijikoNoPageNo;
    @JsonProperty("ninteichosaRirekiNo")
    private RString ninteichosaRirekiNo;
    @JsonProperty("ninteichosaTokkijikoNoList")
    private RString ninteichosaTokkijikoNoList;
    @JsonProperty("downLoadFilePath")
    private RString downLoadFilePath;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtTokkiJikouNo
     * @return txtTokkiJikouNo
     */
    @JsonProperty("txtTokkiJikouNo")
    public TextBox getTxtTokkiJikouNo() {
        return txtTokkiJikouNo;
    }

    /*
     * settxtTokkiJikouNo
     * @param txtTokkiJikouNo txtTokkiJikouNo
     */
    @JsonProperty("txtTokkiJikouNo")
    public void setTxtTokkiJikouNo(TextBox txtTokkiJikouNo) {
        this.txtTokkiJikouNo = txtTokkiJikouNo;
    }

    /*
     * gettxtTokkiJikouName
     * @return txtTokkiJikouName
     */
    @JsonProperty("txtTokkiJikouName")
    public TextBox getTxtTokkiJikouName() {
        return txtTokkiJikouName;
    }

    /*
     * settxtTokkiJikouName
     * @param txtTokkiJikouName txtTokkiJikouName
     */
    @JsonProperty("txtTokkiJikouName")
    public void setTxtTokkiJikouName(TextBox txtTokkiJikouName) {
        this.txtTokkiJikouName = txtTokkiJikouName;
    }

    /*
     * getlblTextGenpon
     * @return lblTextGenpon
     */
    @JsonProperty("lblTextGenpon")
    public Label getLblTextGenpon() {
        return lblTextGenpon;
    }

    /*
     * setlblTextGenpon
     * @param lblTextGenpon lblTextGenpon
     */
    @JsonProperty("lblTextGenpon")
    public void setLblTextGenpon(Label lblTextGenpon) {
        this.lblTextGenpon = lblTextGenpon;
    }

    /*
     * getlblTextMask
     * @return lblTextMask
     */
    @JsonProperty("lblTextMask")
    public Label getLblTextMask() {
        return lblTextMask;
    }

    /*
     * setlblTextMask
     * @param lblTextMask lblTextMask
     */
    @JsonProperty("lblTextMask")
    public void setLblTextMask(Label lblTextMask) {
        this.lblTextMask = lblTextMask;
    }

    /*
     * gettxtTokkijikoNo1
     * @return txtTokkijikoNo1
     */
    @JsonProperty("txtTokkijikoNo1")
    public TextBox getTxtTokkijikoNo1() {
        return txtTokkijikoNo1;
    }

    /*
     * settxtTokkijikoNo1
     * @param txtTokkijikoNo1 txtTokkijikoNo1
     */
    @JsonProperty("txtTokkijikoNo1")
    public void setTxtTokkijikoNo1(TextBox txtTokkijikoNo1) {
        this.txtTokkijikoNo1 = txtTokkijikoNo1;
    }

    /*
     * getlbl1
     * @return lbl1
     */
    @JsonProperty("lbl1")
    public Label getLbl1() {
        return lbl1;
    }

    /*
     * setlbl1
     * @param lbl1 lbl1
     */
    @JsonProperty("lbl1")
    public void setLbl1(Label lbl1) {
        this.lbl1 = lbl1;
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
     * gettxtTextGenpo1
     * @return txtTextGenpo1
     */
    @JsonProperty("txtTextGenpo1")
    public TextBoxMultiLine getTxtTextGenpo1() {
        return txtTextGenpo1;
    }

    /*
     * settxtTextGenpo1
     * @param txtTextGenpo1 txtTextGenpo1
     */
    @JsonProperty("txtTextGenpo1")
    public void setTxtTextGenpo1(TextBoxMultiLine txtTextGenpo1) {
        this.txtTextGenpo1 = txtTextGenpo1;
    }

    /*
     * gettxtTextMask1
     * @return txtTextMask1
     */
    @JsonProperty("txtTextMask1")
    public TextBoxMultiLine getTxtTextMask1() {
        return txtTextMask1;
    }

    /*
     * settxtTextMask1
     * @param txtTextMask1 txtTextMask1
     */
    @JsonProperty("txtTextMask1")
    public void setTxtTextMask1(TextBoxMultiLine txtTextMask1) {
        this.txtTextMask1 = txtTextMask1;
    }

    /*
     * gettxtTokkijikoNo2
     * @return txtTokkijikoNo2
     */
    @JsonProperty("txtTokkijikoNo2")
    public TextBox getTxtTokkijikoNo2() {
        return txtTokkijikoNo2;
    }

    /*
     * settxtTokkijikoNo2
     * @param txtTokkijikoNo2 txtTokkijikoNo2
     */
    @JsonProperty("txtTokkijikoNo2")
    public void setTxtTokkijikoNo2(TextBox txtTokkijikoNo2) {
        this.txtTokkijikoNo2 = txtTokkijikoNo2;
    }

    /*
     * getlbl2
     * @return lbl2
     */
    @JsonProperty("lbl2")
    public Label getLbl2() {
        return lbl2;
    }

    /*
     * setlbl2
     * @param lbl2 lbl2
     */
    @JsonProperty("lbl2")
    public void setLbl2(Label lbl2) {
        this.lbl2 = lbl2;
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
     * gettxtTextGenpo2
     * @return txtTextGenpo2
     */
    @JsonProperty("txtTextGenpo2")
    public TextBoxMultiLine getTxtTextGenpo2() {
        return txtTextGenpo2;
    }

    /*
     * settxtTextGenpo2
     * @param txtTextGenpo2 txtTextGenpo2
     */
    @JsonProperty("txtTextGenpo2")
    public void setTxtTextGenpo2(TextBoxMultiLine txtTextGenpo2) {
        this.txtTextGenpo2 = txtTextGenpo2;
    }

    /*
     * gettxtTextMask2
     * @return txtTextMask2
     */
    @JsonProperty("txtTextMask2")
    public TextBoxMultiLine getTxtTextMask2() {
        return txtTextMask2;
    }

    /*
     * settxtTextMask2
     * @param txtTextMask2 txtTextMask2
     */
    @JsonProperty("txtTextMask2")
    public void setTxtTextMask2(TextBoxMultiLine txtTextMask2) {
        this.txtTextMask2 = txtTextMask2;
    }

    /*
     * gettxtTokkijikoNo3
     * @return txtTokkijikoNo3
     */
    @JsonProperty("txtTokkijikoNo3")
    public TextBox getTxtTokkijikoNo3() {
        return txtTokkijikoNo3;
    }

    /*
     * settxtTokkijikoNo3
     * @param txtTokkijikoNo3 txtTokkijikoNo3
     */
    @JsonProperty("txtTokkijikoNo3")
    public void setTxtTokkijikoNo3(TextBox txtTokkijikoNo3) {
        this.txtTokkijikoNo3 = txtTokkijikoNo3;
    }

    /*
     * getlbl3
     * @return lbl3
     */
    @JsonProperty("lbl3")
    public Label getLbl3() {
        return lbl3;
    }

    /*
     * setlbl3
     * @param lbl3 lbl3
     */
    @JsonProperty("lbl3")
    public void setLbl3(Label lbl3) {
        this.lbl3 = lbl3;
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
     * gettxtTextGenpo3
     * @return txtTextGenpo3
     */
    @JsonProperty("txtTextGenpo3")
    public TextBoxMultiLine getTxtTextGenpo3() {
        return txtTextGenpo3;
    }

    /*
     * settxtTextGenpo3
     * @param txtTextGenpo3 txtTextGenpo3
     */
    @JsonProperty("txtTextGenpo3")
    public void setTxtTextGenpo3(TextBoxMultiLine txtTextGenpo3) {
        this.txtTextGenpo3 = txtTextGenpo3;
    }

    /*
     * gettxtTextMask3
     * @return txtTextMask3
     */
    @JsonProperty("txtTextMask3")
    public TextBoxMultiLine getTxtTextMask3() {
        return txtTextMask3;
    }

    /*
     * settxtTextMask3
     * @param txtTextMask3 txtTextMask3
     */
    @JsonProperty("txtTextMask3")
    public void setTxtTextMask3(TextBoxMultiLine txtTextMask3) {
        this.txtTextMask3 = txtTextMask3;
    }

    /*
     * gettxtTokkijikoNo4
     * @return txtTokkijikoNo4
     */
    @JsonProperty("txtTokkijikoNo4")
    public TextBox getTxtTokkijikoNo4() {
        return txtTokkijikoNo4;
    }

    /*
     * settxtTokkijikoNo4
     * @param txtTokkijikoNo4 txtTokkijikoNo4
     */
    @JsonProperty("txtTokkijikoNo4")
    public void setTxtTokkijikoNo4(TextBox txtTokkijikoNo4) {
        this.txtTokkijikoNo4 = txtTokkijikoNo4;
    }

    /*
     * getlbl4
     * @return lbl4
     */
    @JsonProperty("lbl4")
    public Label getLbl4() {
        return lbl4;
    }

    /*
     * setlbl4
     * @param lbl4 lbl4
     */
    @JsonProperty("lbl4")
    public void setLbl4(Label lbl4) {
        this.lbl4 = lbl4;
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
     * gettxtTextGenpo4
     * @return txtTextGenpo4
     */
    @JsonProperty("txtTextGenpo4")
    public TextBoxMultiLine getTxtTextGenpo4() {
        return txtTextGenpo4;
    }

    /*
     * settxtTextGenpo4
     * @param txtTextGenpo4 txtTextGenpo4
     */
    @JsonProperty("txtTextGenpo4")
    public void setTxtTextGenpo4(TextBoxMultiLine txtTextGenpo4) {
        this.txtTextGenpo4 = txtTextGenpo4;
    }

    /*
     * gettxtTextMask4
     * @return txtTextMask4
     */
    @JsonProperty("txtTextMask4")
    public TextBoxMultiLine getTxtTextMask4() {
        return txtTextMask4;
    }

    /*
     * settxtTextMask4
     * @param txtTextMask4 txtTextMask4
     */
    @JsonProperty("txtTextMask4")
    public void setTxtTextMask4(TextBoxMultiLine txtTextMask4) {
        this.txtTextMask4 = txtTextMask4;
    }

    /*
     * gettxtTokkijikoNo5
     * @return txtTokkijikoNo5
     */
    @JsonProperty("txtTokkijikoNo5")
    public TextBox getTxtTokkijikoNo5() {
        return txtTokkijikoNo5;
    }

    /*
     * settxtTokkijikoNo5
     * @param txtTokkijikoNo5 txtTokkijikoNo5
     */
    @JsonProperty("txtTokkijikoNo5")
    public void setTxtTokkijikoNo5(TextBox txtTokkijikoNo5) {
        this.txtTokkijikoNo5 = txtTokkijikoNo5;
    }

    /*
     * getlbl5
     * @return lbl5
     */
    @JsonProperty("lbl5")
    public Label getLbl5() {
        return lbl5;
    }

    /*
     * setlbl5
     * @param lbl5 lbl5
     */
    @JsonProperty("lbl5")
    public void setLbl5(Label lbl5) {
        this.lbl5 = lbl5;
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
     * gettxtTextGenpo5
     * @return txtTextGenpo5
     */
    @JsonProperty("txtTextGenpo5")
    public TextBoxMultiLine getTxtTextGenpo5() {
        return txtTextGenpo5;
    }

    /*
     * settxtTextGenpo5
     * @param txtTextGenpo5 txtTextGenpo5
     */
    @JsonProperty("txtTextGenpo5")
    public void setTxtTextGenpo5(TextBoxMultiLine txtTextGenpo5) {
        this.txtTextGenpo5 = txtTextGenpo5;
    }

    /*
     * gettxtTextMask5
     * @return txtTextMask5
     */
    @JsonProperty("txtTextMask5")
    public TextBoxMultiLine getTxtTextMask5() {
        return txtTextMask5;
    }

    /*
     * settxtTextMask5
     * @param txtTextMask5 txtTextMask5
     */
    @JsonProperty("txtTextMask5")
    public void setTxtTextMask5(TextBoxMultiLine txtTextMask5) {
        this.txtTextMask5 = txtTextMask5;
    }

    /*
     * gettxtTokkijikoNo6
     * @return txtTokkijikoNo6
     */
    @JsonProperty("txtTokkijikoNo6")
    public TextBox getTxtTokkijikoNo6() {
        return txtTokkijikoNo6;
    }

    /*
     * settxtTokkijikoNo6
     * @param txtTokkijikoNo6 txtTokkijikoNo6
     */
    @JsonProperty("txtTokkijikoNo6")
    public void setTxtTokkijikoNo6(TextBox txtTokkijikoNo6) {
        this.txtTokkijikoNo6 = txtTokkijikoNo6;
    }

    /*
     * getlbl6
     * @return lbl6
     */
    @JsonProperty("lbl6")
    public Label getLbl6() {
        return lbl6;
    }

    /*
     * setlbl6
     * @param lbl6 lbl6
     */
    @JsonProperty("lbl6")
    public void setLbl6(Label lbl6) {
        this.lbl6 = lbl6;
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
     * gettxtTextGenpo6
     * @return txtTextGenpo6
     */
    @JsonProperty("txtTextGenpo6")
    public TextBoxMultiLine getTxtTextGenpo6() {
        return txtTextGenpo6;
    }

    /*
     * settxtTextGenpo6
     * @param txtTextGenpo6 txtTextGenpo6
     */
    @JsonProperty("txtTextGenpo6")
    public void setTxtTextGenpo6(TextBoxMultiLine txtTextGenpo6) {
        this.txtTextGenpo6 = txtTextGenpo6;
    }

    /*
     * gettxtTextMask6
     * @return txtTextMask6
     */
    @JsonProperty("txtTextMask6")
    public TextBoxMultiLine getTxtTextMask6() {
        return txtTextMask6;
    }

    /*
     * settxtTextMask6
     * @param txtTextMask6 txtTextMask6
     */
    @JsonProperty("txtTextMask6")
    public void setTxtTextMask6(TextBoxMultiLine txtTextMask6) {
        this.txtTextMask6 = txtTextMask6;
    }

    /*
     * gettxtTokkijikoNo7
     * @return txtTokkijikoNo7
     */
    @JsonProperty("txtTokkijikoNo7")
    public TextBox getTxtTokkijikoNo7() {
        return txtTokkijikoNo7;
    }

    /*
     * settxtTokkijikoNo7
     * @param txtTokkijikoNo7 txtTokkijikoNo7
     */
    @JsonProperty("txtTokkijikoNo7")
    public void setTxtTokkijikoNo7(TextBox txtTokkijikoNo7) {
        this.txtTokkijikoNo7 = txtTokkijikoNo7;
    }

    /*
     * getlbl7
     * @return lbl7
     */
    @JsonProperty("lbl7")
    public Label getLbl7() {
        return lbl7;
    }

    /*
     * setlbl7
     * @param lbl7 lbl7
     */
    @JsonProperty("lbl7")
    public void setLbl7(Label lbl7) {
        this.lbl7 = lbl7;
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
     * gettxtTextGenpo7
     * @return txtTextGenpo7
     */
    @JsonProperty("txtTextGenpo7")
    public TextBoxMultiLine getTxtTextGenpo7() {
        return txtTextGenpo7;
    }

    /*
     * settxtTextGenpo7
     * @param txtTextGenpo7 txtTextGenpo7
     */
    @JsonProperty("txtTextGenpo7")
    public void setTxtTextGenpo7(TextBoxMultiLine txtTextGenpo7) {
        this.txtTextGenpo7 = txtTextGenpo7;
    }

    /*
     * gettxtTextMask7
     * @return txtTextMask7
     */
    @JsonProperty("txtTextMask7")
    public TextBoxMultiLine getTxtTextMask7() {
        return txtTextMask7;
    }

    /*
     * settxtTextMask7
     * @param txtTextMask7 txtTextMask7
     */
    @JsonProperty("txtTextMask7")
    public void setTxtTextMask7(TextBoxMultiLine txtTextMask7) {
        this.txtTextMask7 = txtTextMask7;
    }

    /*
     * gettxtTokkijikoNo8
     * @return txtTokkijikoNo8
     */
    @JsonProperty("txtTokkijikoNo8")
    public TextBox getTxtTokkijikoNo8() {
        return txtTokkijikoNo8;
    }

    /*
     * settxtTokkijikoNo8
     * @param txtTokkijikoNo8 txtTokkijikoNo8
     */
    @JsonProperty("txtTokkijikoNo8")
    public void setTxtTokkijikoNo8(TextBox txtTokkijikoNo8) {
        this.txtTokkijikoNo8 = txtTokkijikoNo8;
    }

    /*
     * getlbl8
     * @return lbl8
     */
    @JsonProperty("lbl8")
    public Label getLbl8() {
        return lbl8;
    }

    /*
     * setlbl8
     * @param lbl8 lbl8
     */
    @JsonProperty("lbl8")
    public void setLbl8(Label lbl8) {
        this.lbl8 = lbl8;
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
     * gettxtTextGenpo8
     * @return txtTextGenpo8
     */
    @JsonProperty("txtTextGenpo8")
    public TextBoxMultiLine getTxtTextGenpo8() {
        return txtTextGenpo8;
    }

    /*
     * settxtTextGenpo8
     * @param txtTextGenpo8 txtTextGenpo8
     */
    @JsonProperty("txtTextGenpo8")
    public void setTxtTextGenpo8(TextBoxMultiLine txtTextGenpo8) {
        this.txtTextGenpo8 = txtTextGenpo8;
    }

    /*
     * gettxtTextMask8
     * @return txtTextMask8
     */
    @JsonProperty("txtTextMask8")
    public TextBoxMultiLine getTxtTextMask8() {
        return txtTextMask8;
    }

    /*
     * settxtTextMask8
     * @param txtTextMask8 txtTextMask8
     */
    @JsonProperty("txtTextMask8")
    public void setTxtTextMask8(TextBoxMultiLine txtTextMask8) {
        this.txtTextMask8 = txtTextMask8;
    }

    /*
     * gettxtTokkijikoNo9
     * @return txtTokkijikoNo9
     */
    @JsonProperty("txtTokkijikoNo9")
    public TextBox getTxtTokkijikoNo9() {
        return txtTokkijikoNo9;
    }

    /*
     * settxtTokkijikoNo9
     * @param txtTokkijikoNo9 txtTokkijikoNo9
     */
    @JsonProperty("txtTokkijikoNo9")
    public void setTxtTokkijikoNo9(TextBox txtTokkijikoNo9) {
        this.txtTokkijikoNo9 = txtTokkijikoNo9;
    }

    /*
     * getlbl9
     * @return lbl9
     */
    @JsonProperty("lbl9")
    public Label getLbl9() {
        return lbl9;
    }

    /*
     * setlbl9
     * @param lbl9 lbl9
     */
    @JsonProperty("lbl9")
    public void setLbl9(Label lbl9) {
        this.lbl9 = lbl9;
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
     * gettxtTextGenpo9
     * @return txtTextGenpo9
     */
    @JsonProperty("txtTextGenpo9")
    public TextBoxMultiLine getTxtTextGenpo9() {
        return txtTextGenpo9;
    }

    /*
     * settxtTextGenpo9
     * @param txtTextGenpo9 txtTextGenpo9
     */
    @JsonProperty("txtTextGenpo9")
    public void setTxtTextGenpo9(TextBoxMultiLine txtTextGenpo9) {
        this.txtTextGenpo9 = txtTextGenpo9;
    }

    /*
     * gettxtTextMask9
     * @return txtTextMask9
     */
    @JsonProperty("txtTextMask9")
    public TextBoxMultiLine getTxtTextMask9() {
        return txtTextMask9;
    }

    /*
     * settxtTextMask9
     * @param txtTextMask9 txtTextMask9
     */
    @JsonProperty("txtTextMask9")
    public void setTxtTextMask9(TextBoxMultiLine txtTextMask9) {
        this.txtTextMask9 = txtTextMask9;
    }

    /*
     * gettxtTokkijikoNo10
     * @return txtTokkijikoNo10
     */
    @JsonProperty("txtTokkijikoNo10")
    public TextBox getTxtTokkijikoNo10() {
        return txtTokkijikoNo10;
    }

    /*
     * settxtTokkijikoNo10
     * @param txtTokkijikoNo10 txtTokkijikoNo10
     */
    @JsonProperty("txtTokkijikoNo10")
    public void setTxtTokkijikoNo10(TextBox txtTokkijikoNo10) {
        this.txtTokkijikoNo10 = txtTokkijikoNo10;
    }

    /*
     * getlbl10
     * @return lbl10
     */
    @JsonProperty("lbl10")
    public Label getLbl10() {
        return lbl10;
    }

    /*
     * setlbl10
     * @param lbl10 lbl10
     */
    @JsonProperty("lbl10")
    public void setLbl10(Label lbl10) {
        this.lbl10 = lbl10;
    }

    /*
     * gettxtRemban10
     * @return txtRemban10
     */
    @JsonProperty("txtRemban10")
    public TextBoxNum getTxtRemban10() {
        return txtRemban10;
    }

    /*
     * settxtRemban10
     * @param txtRemban10 txtRemban10
     */
    @JsonProperty("txtRemban10")
    public void setTxtRemban10(TextBoxNum txtRemban10) {
        this.txtRemban10 = txtRemban10;
    }

    /*
     * gettxtTextGenpo10
     * @return txtTextGenpo10
     */
    @JsonProperty("txtTextGenpo10")
    public TextBoxMultiLine getTxtTextGenpo10() {
        return txtTextGenpo10;
    }

    /*
     * settxtTextGenpo10
     * @param txtTextGenpo10 txtTextGenpo10
     */
    @JsonProperty("txtTextGenpo10")
    public void setTxtTextGenpo10(TextBoxMultiLine txtTextGenpo10) {
        this.txtTextGenpo10 = txtTextGenpo10;
    }

    /*
     * gettxtTextMask10
     * @return txtTextMask10
     */
    @JsonProperty("txtTextMask10")
    public TextBoxMultiLine getTxtTextMask10() {
        return txtTextMask10;
    }

    /*
     * settxtTextMask10
     * @param txtTextMask10 txtTextMask10
     */
    @JsonProperty("txtTextMask10")
    public void setTxtTextMask10(TextBoxMultiLine txtTextMask10) {
        this.txtTextMask10 = txtTextMask10;
    }

    /*
     * gettxtTokkijikoNo11
     * @return txtTokkijikoNo11
     */
    @JsonProperty("txtTokkijikoNo11")
    public TextBox getTxtTokkijikoNo11() {
        return txtTokkijikoNo11;
    }

    /*
     * settxtTokkijikoNo11
     * @param txtTokkijikoNo11 txtTokkijikoNo11
     */
    @JsonProperty("txtTokkijikoNo11")
    public void setTxtTokkijikoNo11(TextBox txtTokkijikoNo11) {
        this.txtTokkijikoNo11 = txtTokkijikoNo11;
    }

    /*
     * getlbl11
     * @return lbl11
     */
    @JsonProperty("lbl11")
    public Label getLbl11() {
        return lbl11;
    }

    /*
     * setlbl11
     * @param lbl11 lbl11
     */
    @JsonProperty("lbl11")
    public void setLbl11(Label lbl11) {
        this.lbl11 = lbl11;
    }

    /*
     * gettxtRemban11
     * @return txtRemban11
     */
    @JsonProperty("txtRemban11")
    public TextBoxNum getTxtRemban11() {
        return txtRemban11;
    }

    /*
     * settxtRemban11
     * @param txtRemban11 txtRemban11
     */
    @JsonProperty("txtRemban11")
    public void setTxtRemban11(TextBoxNum txtRemban11) {
        this.txtRemban11 = txtRemban11;
    }

    /*
     * getimgGenpo1
     * @return imgGenpo1
     */
    @JsonProperty("imgGenpo1")
    public StaticImage getImgGenpo1() {
        return imgGenpo1;
    }

    /*
     * setimgGenpo1
     * @param imgGenpo1 imgGenpo1
     */
    @JsonProperty("imgGenpo1")
    public void setImgGenpo1(StaticImage imgGenpo1) {
        this.imgGenpo1 = imgGenpo1;
    }

    /*
     * getimgMasking1
     * @return imgMasking1
     */
    @JsonProperty("imgMasking1")
    public StaticImage getImgMasking1() {
        return imgMasking1;
    }

    /*
     * setimgMasking1
     * @param imgMasking1 imgMasking1
     */
    @JsonProperty("imgMasking1")
    public void setImgMasking1(StaticImage imgMasking1) {
        this.imgMasking1 = imgMasking1;
    }

    /*
     * gettxtTokkijikoNo12
     * @return txtTokkijikoNo12
     */
    @JsonProperty("txtTokkijikoNo12")
    public TextBox getTxtTokkijikoNo12() {
        return txtTokkijikoNo12;
    }

    /*
     * settxtTokkijikoNo12
     * @param txtTokkijikoNo12 txtTokkijikoNo12
     */
    @JsonProperty("txtTokkijikoNo12")
    public void setTxtTokkijikoNo12(TextBox txtTokkijikoNo12) {
        this.txtTokkijikoNo12 = txtTokkijikoNo12;
    }

    /*
     * getlbl12
     * @return lbl12
     */
    @JsonProperty("lbl12")
    public Label getLbl12() {
        return lbl12;
    }

    /*
     * setlbl12
     * @param lbl12 lbl12
     */
    @JsonProperty("lbl12")
    public void setLbl12(Label lbl12) {
        this.lbl12 = lbl12;
    }

    /*
     * gettxtRemban12
     * @return txtRemban12
     */
    @JsonProperty("txtRemban12")
    public TextBoxNum getTxtRemban12() {
        return txtRemban12;
    }

    /*
     * settxtRemban12
     * @param txtRemban12 txtRemban12
     */
    @JsonProperty("txtRemban12")
    public void setTxtRemban12(TextBoxNum txtRemban12) {
        this.txtRemban12 = txtRemban12;
    }

    /*
     * getimgGenpo2
     * @return imgGenpo2
     */
    @JsonProperty("imgGenpo2")
    public StaticImage getImgGenpo2() {
        return imgGenpo2;
    }

    /*
     * setimgGenpo2
     * @param imgGenpo2 imgGenpo2
     */
    @JsonProperty("imgGenpo2")
    public void setImgGenpo2(StaticImage imgGenpo2) {
        this.imgGenpo2 = imgGenpo2;
    }

    /*
     * getimgMasking2
     * @return imgMasking2
     */
    @JsonProperty("imgMasking2")
    public StaticImage getImgMasking2() {
        return imgMasking2;
    }

    /*
     * setimgMasking2
     * @param imgMasking2 imgMasking2
     */
    @JsonProperty("imgMasking2")
    public void setImgMasking2(StaticImage imgMasking2) {
        this.imgMasking2 = imgMasking2;
    }

    /*
     * gettxtTokkijikoNo13
     * @return txtTokkijikoNo13
     */
    @JsonProperty("txtTokkijikoNo13")
    public TextBox getTxtTokkijikoNo13() {
        return txtTokkijikoNo13;
    }

    /*
     * settxtTokkijikoNo13
     * @param txtTokkijikoNo13 txtTokkijikoNo13
     */
    @JsonProperty("txtTokkijikoNo13")
    public void setTxtTokkijikoNo13(TextBox txtTokkijikoNo13) {
        this.txtTokkijikoNo13 = txtTokkijikoNo13;
    }

    /*
     * getlbl13
     * @return lbl13
     */
    @JsonProperty("lbl13")
    public Label getLbl13() {
        return lbl13;
    }

    /*
     * setlbl13
     * @param lbl13 lbl13
     */
    @JsonProperty("lbl13")
    public void setLbl13(Label lbl13) {
        this.lbl13 = lbl13;
    }

    /*
     * gettxtRemban13
     * @return txtRemban13
     */
    @JsonProperty("txtRemban13")
    public TextBoxNum getTxtRemban13() {
        return txtRemban13;
    }

    /*
     * settxtRemban13
     * @param txtRemban13 txtRemban13
     */
    @JsonProperty("txtRemban13")
    public void setTxtRemban13(TextBoxNum txtRemban13) {
        this.txtRemban13 = txtRemban13;
    }

    /*
     * getimgGenpo3
     * @return imgGenpo3
     */
    @JsonProperty("imgGenpo3")
    public StaticImage getImgGenpo3() {
        return imgGenpo3;
    }

    /*
     * setimgGenpo3
     * @param imgGenpo3 imgGenpo3
     */
    @JsonProperty("imgGenpo3")
    public void setImgGenpo3(StaticImage imgGenpo3) {
        this.imgGenpo3 = imgGenpo3;
    }

    /*
     * getimgMasking3
     * @return imgMasking3
     */
    @JsonProperty("imgMasking3")
    public StaticImage getImgMasking3() {
        return imgMasking3;
    }

    /*
     * setimgMasking3
     * @param imgMasking3 imgMasking3
     */
    @JsonProperty("imgMasking3")
    public void setImgMasking3(StaticImage imgMasking3) {
        this.imgMasking3 = imgMasking3;
    }

    /*
     * gettxtTokkijikoNo14
     * @return txtTokkijikoNo14
     */
    @JsonProperty("txtTokkijikoNo14")
    public TextBox getTxtTokkijikoNo14() {
        return txtTokkijikoNo14;
    }

    /*
     * settxtTokkijikoNo14
     * @param txtTokkijikoNo14 txtTokkijikoNo14
     */
    @JsonProperty("txtTokkijikoNo14")
    public void setTxtTokkijikoNo14(TextBox txtTokkijikoNo14) {
        this.txtTokkijikoNo14 = txtTokkijikoNo14;
    }

    /*
     * getlbl14
     * @return lbl14
     */
    @JsonProperty("lbl14")
    public Label getLbl14() {
        return lbl14;
    }

    /*
     * setlbl14
     * @param lbl14 lbl14
     */
    @JsonProperty("lbl14")
    public void setLbl14(Label lbl14) {
        this.lbl14 = lbl14;
    }

    /*
     * gettxtRemban14
     * @return txtRemban14
     */
    @JsonProperty("txtRemban14")
    public TextBoxNum getTxtRemban14() {
        return txtRemban14;
    }

    /*
     * settxtRemban14
     * @param txtRemban14 txtRemban14
     */
    @JsonProperty("txtRemban14")
    public void setTxtRemban14(TextBoxNum txtRemban14) {
        this.txtRemban14 = txtRemban14;
    }

    /*
     * getimgGenpo4
     * @return imgGenpo4
     */
    @JsonProperty("imgGenpo4")
    public StaticImage getImgGenpo4() {
        return imgGenpo4;
    }

    /*
     * setimgGenpo4
     * @param imgGenpo4 imgGenpo4
     */
    @JsonProperty("imgGenpo4")
    public void setImgGenpo4(StaticImage imgGenpo4) {
        this.imgGenpo4 = imgGenpo4;
    }

    /*
     * getimgMasking4
     * @return imgMasking4
     */
    @JsonProperty("imgMasking4")
    public StaticImage getImgMasking4() {
        return imgMasking4;
    }

    /*
     * setimgMasking4
     * @param imgMasking4 imgMasking4
     */
    @JsonProperty("imgMasking4")
    public void setImgMasking4(StaticImage imgMasking4) {
        this.imgMasking4 = imgMasking4;
    }

    /*
     * gettxtTokkijikoNo15
     * @return txtTokkijikoNo15
     */
    @JsonProperty("txtTokkijikoNo15")
    public TextBox getTxtTokkijikoNo15() {
        return txtTokkijikoNo15;
    }

    /*
     * settxtTokkijikoNo15
     * @param txtTokkijikoNo15 txtTokkijikoNo15
     */
    @JsonProperty("txtTokkijikoNo15")
    public void setTxtTokkijikoNo15(TextBox txtTokkijikoNo15) {
        this.txtTokkijikoNo15 = txtTokkijikoNo15;
    }

    /*
     * getlbl15
     * @return lbl15
     */
    @JsonProperty("lbl15")
    public Label getLbl15() {
        return lbl15;
    }

    /*
     * setlbl15
     * @param lbl15 lbl15
     */
    @JsonProperty("lbl15")
    public void setLbl15(Label lbl15) {
        this.lbl15 = lbl15;
    }

    /*
     * gettxtRemban15
     * @return txtRemban15
     */
    @JsonProperty("txtRemban15")
    public TextBoxNum getTxtRemban15() {
        return txtRemban15;
    }

    /*
     * settxtRemban15
     * @param txtRemban15 txtRemban15
     */
    @JsonProperty("txtRemban15")
    public void setTxtRemban15(TextBoxNum txtRemban15) {
        this.txtRemban15 = txtRemban15;
    }

    /*
     * getimgGenpo5
     * @return imgGenpo5
     */
    @JsonProperty("imgGenpo5")
    public StaticImage getImgGenpo5() {
        return imgGenpo5;
    }

    /*
     * setimgGenpo5
     * @param imgGenpo5 imgGenpo5
     */
    @JsonProperty("imgGenpo5")
    public void setImgGenpo5(StaticImage imgGenpo5) {
        this.imgGenpo5 = imgGenpo5;
    }

    /*
     * getimgMasking5
     * @return imgMasking5
     */
    @JsonProperty("imgMasking5")
    public StaticImage getImgMasking5() {
        return imgMasking5;
    }

    /*
     * setimgMasking5
     * @param imgMasking5 imgMasking5
     */
    @JsonProperty("imgMasking5")
    public void setImgMasking5(StaticImage imgMasking5) {
        this.imgMasking5 = imgMasking5;
    }

    /*
     * gettxtTokkijikoNo16
     * @return txtTokkijikoNo16
     */
    @JsonProperty("txtTokkijikoNo16")
    public TextBox getTxtTokkijikoNo16() {
        return txtTokkijikoNo16;
    }

    /*
     * settxtTokkijikoNo16
     * @param txtTokkijikoNo16 txtTokkijikoNo16
     */
    @JsonProperty("txtTokkijikoNo16")
    public void setTxtTokkijikoNo16(TextBox txtTokkijikoNo16) {
        this.txtTokkijikoNo16 = txtTokkijikoNo16;
    }

    /*
     * getlbl16
     * @return lbl16
     */
    @JsonProperty("lbl16")
    public Label getLbl16() {
        return lbl16;
    }

    /*
     * setlbl16
     * @param lbl16 lbl16
     */
    @JsonProperty("lbl16")
    public void setLbl16(Label lbl16) {
        this.lbl16 = lbl16;
    }

    /*
     * gettxtRemban16
     * @return txtRemban16
     */
    @JsonProperty("txtRemban16")
    public TextBoxNum getTxtRemban16() {
        return txtRemban16;
    }

    /*
     * settxtRemban16
     * @param txtRemban16 txtRemban16
     */
    @JsonProperty("txtRemban16")
    public void setTxtRemban16(TextBoxNum txtRemban16) {
        this.txtRemban16 = txtRemban16;
    }

    /*
     * getimgGenpo6
     * @return imgGenpo6
     */
    @JsonProperty("imgGenpo6")
    public StaticImage getImgGenpo6() {
        return imgGenpo6;
    }

    /*
     * setimgGenpo6
     * @param imgGenpo6 imgGenpo6
     */
    @JsonProperty("imgGenpo6")
    public void setImgGenpo6(StaticImage imgGenpo6) {
        this.imgGenpo6 = imgGenpo6;
    }

    /*
     * getimgMasking6
     * @return imgMasking6
     */
    @JsonProperty("imgMasking6")
    public StaticImage getImgMasking6() {
        return imgMasking6;
    }

    /*
     * setimgMasking6
     * @param imgMasking6 imgMasking6
     */
    @JsonProperty("imgMasking6")
    public void setImgMasking6(StaticImage imgMasking6) {
        this.imgMasking6 = imgMasking6;
    }

    /*
     * gettxtTokkijikoNo17
     * @return txtTokkijikoNo17
     */
    @JsonProperty("txtTokkijikoNo17")
    public TextBox getTxtTokkijikoNo17() {
        return txtTokkijikoNo17;
    }

    /*
     * settxtTokkijikoNo17
     * @param txtTokkijikoNo17 txtTokkijikoNo17
     */
    @JsonProperty("txtTokkijikoNo17")
    public void setTxtTokkijikoNo17(TextBox txtTokkijikoNo17) {
        this.txtTokkijikoNo17 = txtTokkijikoNo17;
    }

    /*
     * getlbl17
     * @return lbl17
     */
    @JsonProperty("lbl17")
    public Label getLbl17() {
        return lbl17;
    }

    /*
     * setlbl17
     * @param lbl17 lbl17
     */
    @JsonProperty("lbl17")
    public void setLbl17(Label lbl17) {
        this.lbl17 = lbl17;
    }

    /*
     * gettxtRemban17
     * @return txtRemban17
     */
    @JsonProperty("txtRemban17")
    public TextBoxNum getTxtRemban17() {
        return txtRemban17;
    }

    /*
     * settxtRemban17
     * @param txtRemban17 txtRemban17
     */
    @JsonProperty("txtRemban17")
    public void setTxtRemban17(TextBoxNum txtRemban17) {
        this.txtRemban17 = txtRemban17;
    }

    /*
     * getimgGenpo7
     * @return imgGenpo7
     */
    @JsonProperty("imgGenpo7")
    public StaticImage getImgGenpo7() {
        return imgGenpo7;
    }

    /*
     * setimgGenpo7
     * @param imgGenpo7 imgGenpo7
     */
    @JsonProperty("imgGenpo7")
    public void setImgGenpo7(StaticImage imgGenpo7) {
        this.imgGenpo7 = imgGenpo7;
    }

    /*
     * getimgMasking7
     * @return imgMasking7
     */
    @JsonProperty("imgMasking7")
    public StaticImage getImgMasking7() {
        return imgMasking7;
    }

    /*
     * setimgMasking7
     * @param imgMasking7 imgMasking7
     */
    @JsonProperty("imgMasking7")
    public void setImgMasking7(StaticImage imgMasking7) {
        this.imgMasking7 = imgMasking7;
    }

    /*
     * gettxtTokkijikoNo18
     * @return txtTokkijikoNo18
     */
    @JsonProperty("txtTokkijikoNo18")
    public TextBox getTxtTokkijikoNo18() {
        return txtTokkijikoNo18;
    }

    /*
     * settxtTokkijikoNo18
     * @param txtTokkijikoNo18 txtTokkijikoNo18
     */
    @JsonProperty("txtTokkijikoNo18")
    public void setTxtTokkijikoNo18(TextBox txtTokkijikoNo18) {
        this.txtTokkijikoNo18 = txtTokkijikoNo18;
    }

    /*
     * getlbl18
     * @return lbl18
     */
    @JsonProperty("lbl18")
    public Label getLbl18() {
        return lbl18;
    }

    /*
     * setlbl18
     * @param lbl18 lbl18
     */
    @JsonProperty("lbl18")
    public void setLbl18(Label lbl18) {
        this.lbl18 = lbl18;
    }

    /*
     * gettxtRemban18
     * @return txtRemban18
     */
    @JsonProperty("txtRemban18")
    public TextBoxNum getTxtRemban18() {
        return txtRemban18;
    }

    /*
     * settxtRemban18
     * @param txtRemban18 txtRemban18
     */
    @JsonProperty("txtRemban18")
    public void setTxtRemban18(TextBoxNum txtRemban18) {
        this.txtRemban18 = txtRemban18;
    }

    /*
     * getimgGenpo8
     * @return imgGenpo8
     */
    @JsonProperty("imgGenpo8")
    public StaticImage getImgGenpo8() {
        return imgGenpo8;
    }

    /*
     * setimgGenpo8
     * @param imgGenpo8 imgGenpo8
     */
    @JsonProperty("imgGenpo8")
    public void setImgGenpo8(StaticImage imgGenpo8) {
        this.imgGenpo8 = imgGenpo8;
    }

    /*
     * getimgMasking8
     * @return imgMasking8
     */
    @JsonProperty("imgMasking8")
    public StaticImage getImgMasking8() {
        return imgMasking8;
    }

    /*
     * setimgMasking8
     * @param imgMasking8 imgMasking8
     */
    @JsonProperty("imgMasking8")
    public void setImgMasking8(StaticImage imgMasking8) {
        this.imgMasking8 = imgMasking8;
    }

    /*
     * gettxtTokkijikoNo19
     * @return txtTokkijikoNo19
     */
    @JsonProperty("txtTokkijikoNo19")
    public TextBox getTxtTokkijikoNo19() {
        return txtTokkijikoNo19;
    }

    /*
     * settxtTokkijikoNo19
     * @param txtTokkijikoNo19 txtTokkijikoNo19
     */
    @JsonProperty("txtTokkijikoNo19")
    public void setTxtTokkijikoNo19(TextBox txtTokkijikoNo19) {
        this.txtTokkijikoNo19 = txtTokkijikoNo19;
    }

    /*
     * getlbl19
     * @return lbl19
     */
    @JsonProperty("lbl19")
    public Label getLbl19() {
        return lbl19;
    }

    /*
     * setlbl19
     * @param lbl19 lbl19
     */
    @JsonProperty("lbl19")
    public void setLbl19(Label lbl19) {
        this.lbl19 = lbl19;
    }

    /*
     * gettxtRemban19
     * @return txtRemban19
     */
    @JsonProperty("txtRemban19")
    public TextBoxNum getTxtRemban19() {
        return txtRemban19;
    }

    /*
     * settxtRemban19
     * @param txtRemban19 txtRemban19
     */
    @JsonProperty("txtRemban19")
    public void setTxtRemban19(TextBoxNum txtRemban19) {
        this.txtRemban19 = txtRemban19;
    }

    /*
     * getimgGenpo9
     * @return imgGenpo9
     */
    @JsonProperty("imgGenpo9")
    public StaticImage getImgGenpo9() {
        return imgGenpo9;
    }

    /*
     * setimgGenpo9
     * @param imgGenpo9 imgGenpo9
     */
    @JsonProperty("imgGenpo9")
    public void setImgGenpo9(StaticImage imgGenpo9) {
        this.imgGenpo9 = imgGenpo9;
    }

    /*
     * getimgMasking9
     * @return imgMasking9
     */
    @JsonProperty("imgMasking9")
    public StaticImage getImgMasking9() {
        return imgMasking9;
    }

    /*
     * setimgMasking9
     * @param imgMasking9 imgMasking9
     */
    @JsonProperty("imgMasking9")
    public void setImgMasking9(StaticImage imgMasking9) {
        this.imgMasking9 = imgMasking9;
    }

    /*
     * gettxtTokkijikoNo20
     * @return txtTokkijikoNo20
     */
    @JsonProperty("txtTokkijikoNo20")
    public TextBox getTxtTokkijikoNo20() {
        return txtTokkijikoNo20;
    }

    /*
     * settxtTokkijikoNo20
     * @param txtTokkijikoNo20 txtTokkijikoNo20
     */
    @JsonProperty("txtTokkijikoNo20")
    public void setTxtTokkijikoNo20(TextBox txtTokkijikoNo20) {
        this.txtTokkijikoNo20 = txtTokkijikoNo20;
    }

    /*
     * getlbl20
     * @return lbl20
     */
    @JsonProperty("lbl20")
    public Label getLbl20() {
        return lbl20;
    }

    /*
     * setlbl20
     * @param lbl20 lbl20
     */
    @JsonProperty("lbl20")
    public void setLbl20(Label lbl20) {
        this.lbl20 = lbl20;
    }

    /*
     * gettxtRemban20
     * @return txtRemban20
     */
    @JsonProperty("txtRemban20")
    public TextBoxNum getTxtRemban20() {
        return txtRemban20;
    }

    /*
     * settxtRemban20
     * @param txtRemban20 txtRemban20
     */
    @JsonProperty("txtRemban20")
    public void setTxtRemban20(TextBoxNum txtRemban20) {
        this.txtRemban20 = txtRemban20;
    }

    /*
     * getimgGenpo10
     * @return imgGenpo10
     */
    @JsonProperty("imgGenpo10")
    public StaticImage getImgGenpo10() {
        return imgGenpo10;
    }

    /*
     * setimgGenpo10
     * @param imgGenpo10 imgGenpo10
     */
    @JsonProperty("imgGenpo10")
    public void setImgGenpo10(StaticImage imgGenpo10) {
        this.imgGenpo10 = imgGenpo10;
    }

    /*
     * getimgMasking10
     * @return imgMasking10
     */
    @JsonProperty("imgMasking10")
    public StaticImage getImgMasking10() {
        return imgMasking10;
    }

    /*
     * setimgMasking10
     * @param imgMasking10 imgMasking10
     */
    @JsonProperty("imgMasking10")
    public void setImgMasking10(StaticImage imgMasking10) {
        this.imgMasking10 = imgMasking10;
    }

    /*
     * getbtnReturn
     * @return btnReturn
     */
    @JsonProperty("btnReturn")
    public Button getBtnReturn() {
        return btnReturn;
    }

    /*
     * setbtnReturn
     * @param btnReturn btnReturn
     */
    @JsonProperty("btnReturn")
    public void setBtnReturn(Button btnReturn) {
        this.btnReturn = btnReturn;
    }

    /*
     * getshinseishoKanriNo
     * @return shinseishoKanriNo
     */
    @JsonProperty("shinseishoKanriNo")
    public RString getShinseishoKanriNo() {
        return shinseishoKanriNo;
    }

    /*
     * setshinseishoKanriNo
     * @param shinseishoKanriNo shinseishoKanriNo
     */
    @JsonProperty("shinseishoKanriNo")
    public void setShinseishoKanriNo(RString shinseishoKanriNo) {
        this.shinseishoKanriNo = shinseishoKanriNo;
    }

    /*
     * getmaxRemban
     * @return maxRemban
     */
    @JsonProperty("maxRemban")
    public RString getMaxRemban() {
        return maxRemban;
    }

    /*
     * setmaxRemban
     * @param maxRemban maxRemban
     */
    @JsonProperty("maxRemban")
    public void setMaxRemban(RString maxRemban) {
        this.maxRemban = maxRemban;
    }

    /*
     * getmaxTokkijikoNo
     * @return maxTokkijikoNo
     */
    @JsonProperty("maxTokkijikoNo")
    public RString getMaxTokkijikoNo() {
        return maxTokkijikoNo;
    }

    /*
     * setmaxTokkijikoNo
     * @param maxTokkijikoNo maxTokkijikoNo
     */
    @JsonProperty("maxTokkijikoNo")
    public void setMaxTokkijikoNo(RString maxTokkijikoNo) {
        this.maxTokkijikoNo = maxTokkijikoNo;
    }

    /*
     * getminTokkijikoNo
     * @return minTokkijikoNo
     */
    @JsonProperty("minTokkijikoNo")
    public RString getMinTokkijikoNo() {
        return minTokkijikoNo;
    }

    /*
     * setminTokkijikoNo
     * @param minTokkijikoNo minTokkijikoNo
     */
    @JsonProperty("minTokkijikoNo")
    public void setMinTokkijikoNo(RString minTokkijikoNo) {
        this.minTokkijikoNo = minTokkijikoNo;
    }

    /*
     * getrembanPageNo
     * @return rembanPageNo
     */
    @JsonProperty("rembanPageNo")
    public RString getRembanPageNo() {
        return rembanPageNo;
    }

    /*
     * setrembanPageNo
     * @param rembanPageNo rembanPageNo
     */
    @JsonProperty("rembanPageNo")
    public void setRembanPageNo(RString rembanPageNo) {
        this.rembanPageNo = rembanPageNo;
    }

    /*
     * gettokkijikoNoPageNo
     * @return tokkijikoNoPageNo
     */
    @JsonProperty("tokkijikoNoPageNo")
    public RString getTokkijikoNoPageNo() {
        return tokkijikoNoPageNo;
    }

    /*
     * settokkijikoNoPageNo
     * @param tokkijikoNoPageNo tokkijikoNoPageNo
     */
    @JsonProperty("tokkijikoNoPageNo")
    public void setTokkijikoNoPageNo(RString tokkijikoNoPageNo) {
        this.tokkijikoNoPageNo = tokkijikoNoPageNo;
    }

    /*
     * getninteichosaRirekiNo
     * @return ninteichosaRirekiNo
     */
    @JsonProperty("ninteichosaRirekiNo")
    public RString getNinteichosaRirekiNo() {
        return ninteichosaRirekiNo;
    }

    /*
     * setninteichosaRirekiNo
     * @param ninteichosaRirekiNo ninteichosaRirekiNo
     */
    @JsonProperty("ninteichosaRirekiNo")
    public void setNinteichosaRirekiNo(RString ninteichosaRirekiNo) {
        this.ninteichosaRirekiNo = ninteichosaRirekiNo;
    }

    /*
     * getninteichosaTokkijikoNoList
     * @return ninteichosaTokkijikoNoList
     */
    @JsonProperty("ninteichosaTokkijikoNoList")
    public RString getNinteichosaTokkijikoNoList() {
        return ninteichosaTokkijikoNoList;
    }

    /*
     * setninteichosaTokkijikoNoList
     * @param ninteichosaTokkijikoNoList ninteichosaTokkijikoNoList
     */
    @JsonProperty("ninteichosaTokkijikoNoList")
    public void setNinteichosaTokkijikoNoList(RString ninteichosaTokkijikoNoList) {
        this.ninteichosaTokkijikoNoList = ninteichosaTokkijikoNoList;
    }

    /*
     * getdownLoadFilePath
     * @return downLoadFilePath
     */
    @JsonProperty("downLoadFilePath")
    public RString getDownLoadFilePath() {
        return downLoadFilePath;
    }

    /*
     * setdownLoadFilePath
     * @param downLoadFilePath downLoadFilePath
     */
    @JsonProperty("downLoadFilePath")
    public void setDownLoadFilePath(RString downLoadFilePath) {
        this.downLoadFilePath = downLoadFilePath;
    }

    // </editor-fold>
    //--------------- この行より下にコードを追加してください -------------------
    @Override
    @JsonIgnore
    public void onLoad(ShinseishoKanriNo 申請書管理番号, int 認定調査依頼履歴番号, ArrayList<RString> 認定調査特記事項番号List) {
        NinteichosahyoTokkijikoManager manager = InstanceProvider.create(NinteichosahyoTokkijikoManager.class);
        ArrayList<NinteichosahyoTokkijiko> list = manager.get調査特記事項(申請書管理番号, 認定調査依頼履歴番号, 認定調査特記事項番号List);
        if (list.isEmpty()) {
            throw new ApplicationException(UrErrorMessages.対象データなし.getMessage());
        }
        initializa(list, 認定調査特記事項番号List.get(0));
    }

    /**
     * 画面初期化
     *
     * @param 認定調査特記事項List ArrayList<NinteichosahyoTokkijiko>
     * @param 認定調査特記事項番号 RString
     */
    @JsonIgnore
    public void initializa(ArrayList<NinteichosahyoTokkijiko> 認定調査特記事項List, RString 認定調査特記事項番号) {
        clearValue();
        NinteiChosaTokkiJikou 認定調査特記事項マッピング
                = NinteiChosaTokkiJikou.getEnumByDbt5205認定調査特記事項番号(認定調査特記事項番号);

        this.txtTokkiJikouNo.setValue(認定調査特記事項マッピング.get画面表示用特記事項番号());
        this.txtTokkiJikouName.setValue(認定調査特記事項マッピング.get特記事項名());
        
        RString path原本 = RString.EMPTY;
        RString pathマスク = RString.EMPTY;
        ImageManager imageManager = InstanceProvider.create(ImageManager.class);
        ChosaTokkiShokaiFinder finder = InstanceProvider.create(ChosaTokkiShokaiFinder.class);
        Image イメージ情報 = imageManager.getイメージ情報(new ShinseishoKanriNo(shinseishoKanriNo));
        if (イメージ情報.getイメージ共有ファイルID() != null) {
            FilesystemName sharedFileName = finder.selectSharedFileNameByKey(new ShinseishoKanriNo(shinseishoKanriNo));
            downLoadFilePath = getDownLoadFilePath(イメージ情報.getイメージ共有ファイルID(), sharedFileName);
            
            path原本 = getImageSrc(Path.combinePath(downLoadFilePath, replaceShareFileName(
                    NinteiChosaTokkiJikou.getEnumBy画面認定調査特記事項番号(this.txtTokkiJikouNo.getValue()).getイメージファイル(),
                    1, true)));
            pathマスク = getImageSrc(Path.combinePath(downLoadFilePath, replaceShareFileName(
                    NinteiChosaTokkiJikou.getEnumBy画面認定調査特記事項番号(this.txtTokkiJikouNo.getValue()).getイメージファイル(),
                    1, false)));
        }

        if (File.exists(pathマスク) || File.exists(path原本)) {
            setGamenDisplay(false);
            for (NinteichosahyoTokkijiko 認定調査特記事項 : 認定調査特記事項List) {
                initializaイメージエリア(認定調査特記事項マッピング, 認定調査特記事項, 認定調査特記事項.get認定調査特記事項連番());
            }
        } else {
            setGamenDisplay(true);
            for (NinteichosahyoTokkijiko 認定調査特記事項 : 認定調査特記事項List) {
                initializaテキストエリア(認定調査特記事項マッピング, 認定調査特記事項, 認定調査特記事項.get認定調査特記事項連番());
            }
        }
    }

    private void clearValue() {
        this.txtTokkijikoNo1.setValue(RString.EMPTY);
        this.txtTokkijikoNo2.setValue(RString.EMPTY);
        this.txtTokkijikoNo3.setValue(RString.EMPTY);
        this.txtTokkijikoNo4.setValue(RString.EMPTY);
        this.txtTokkijikoNo5.setValue(RString.EMPTY);
        this.txtTokkijikoNo6.setValue(RString.EMPTY);
        this.txtTokkijikoNo7.setValue(RString.EMPTY);
        this.txtTokkijikoNo8.setValue(RString.EMPTY);
        this.txtTokkijikoNo9.setValue(RString.EMPTY);
        this.txtTokkijikoNo10.setValue(RString.EMPTY);
        this.txtTokkijikoNo11.setValue(RString.EMPTY);
        this.txtTokkijikoNo12.setValue(RString.EMPTY);
        this.txtTokkijikoNo13.setValue(RString.EMPTY);
        this.txtTokkijikoNo14.setValue(RString.EMPTY);
        this.txtTokkijikoNo15.setValue(RString.EMPTY);
        this.txtTokkijikoNo16.setValue(RString.EMPTY);
        this.txtTokkijikoNo17.setValue(RString.EMPTY);
        this.txtTokkijikoNo18.setValue(RString.EMPTY);
        this.txtTokkijikoNo19.setValue(RString.EMPTY);
        this.txtTokkijikoNo20.setValue(RString.EMPTY);
        
        this.txtRemban1.clearValue();
        this.txtRemban2.clearValue();
        this.txtRemban3.clearValue();
        this.txtRemban4.clearValue();
        this.txtRemban5.clearValue();
        this.txtRemban6.clearValue();
        this.txtRemban7.clearValue();
        this.txtRemban8.clearValue();
        this.txtRemban9.clearValue();
        this.txtRemban10.clearValue();
        this.txtRemban11.clearValue();
        this.txtRemban12.clearValue();
        this.txtRemban13.clearValue();
        this.txtRemban14.clearValue();
        this.txtRemban15.clearValue();
        this.txtRemban16.clearValue();
        this.txtRemban17.clearValue();
        this.txtRemban18.clearValue();
        this.txtRemban19.clearValue();
        this.txtRemban20.clearValue();
        
        this.txtTextGenpo1.setValue(RString.EMPTY);
        this.txtTextGenpo2.setValue(RString.EMPTY);
        this.txtTextGenpo3.setValue(RString.EMPTY);
        this.txtTextGenpo4.setValue(RString.EMPTY);
        this.txtTextGenpo5.setValue(RString.EMPTY);
        this.txtTextGenpo6.setValue(RString.EMPTY);
        this.txtTextGenpo7.setValue(RString.EMPTY);
        this.txtTextGenpo8.setValue(RString.EMPTY);
        this.txtTextGenpo9.setValue(RString.EMPTY);
        this.txtTextGenpo10.setValue(RString.EMPTY);
        this.txtTextMask1.setValue(RString.EMPTY);
        this.txtTextMask2.setValue(RString.EMPTY);
        this.txtTextMask3.setValue(RString.EMPTY);
        this.txtTextMask4.setValue(RString.EMPTY);
        this.txtTextMask5.setValue(RString.EMPTY);
        this.txtTextMask6.setValue(RString.EMPTY);
        this.txtTextMask7.setValue(RString.EMPTY);
        this.txtTextMask8.setValue(RString.EMPTY);
        this.txtTextMask9.setValue(RString.EMPTY);
        this.txtTextMask10.setValue(RString.EMPTY);
        
        this.imgGenpo1.setSrc(RString.EMPTY);
        this.imgGenpo2.setSrc(RString.EMPTY);
        this.imgGenpo3.setSrc(RString.EMPTY);
        this.imgGenpo4.setSrc(RString.EMPTY);
        this.imgGenpo5.setSrc(RString.EMPTY);
        this.imgGenpo6.setSrc(RString.EMPTY);
        this.imgGenpo7.setSrc(RString.EMPTY);
        this.imgGenpo8.setSrc(RString.EMPTY);
        this.imgGenpo9.setSrc(RString.EMPTY);
        this.imgGenpo10.setSrc(RString.EMPTY);
        this.imgMasking1.setSrc(RString.EMPTY);
        this.imgMasking2.setSrc(RString.EMPTY);
        this.imgMasking3.setSrc(RString.EMPTY);
        this.imgMasking4.setSrc(RString.EMPTY);
        this.imgMasking5.setSrc(RString.EMPTY);
        this.imgMasking6.setSrc(RString.EMPTY);
        this.imgMasking7.setSrc(RString.EMPTY);
        this.imgMasking8.setSrc(RString.EMPTY);
        this.imgMasking9.setSrc(RString.EMPTY);
        this.imgMasking10.setSrc(RString.EMPTY);
    }
    
    private void setGamenDisplay(boolean isテキスト) {
        this.txtTokkijikoNo1.setDisplayNone(!isテキスト);
        this.txtTokkijikoNo2.setDisplayNone(!isテキスト);
        this.txtTokkijikoNo3.setDisplayNone(!isテキスト);
        this.txtTokkijikoNo4.setDisplayNone(!isテキスト);
        this.txtTokkijikoNo5.setDisplayNone(!isテキスト);
        this.txtTokkijikoNo6.setDisplayNone(!isテキスト);
        this.txtTokkijikoNo7.setDisplayNone(!isテキスト);
        this.txtTokkijikoNo8.setDisplayNone(!isテキスト);
        this.txtTokkijikoNo9.setDisplayNone(!isテキスト);
        this.txtTokkijikoNo10.setDisplayNone(!isテキスト);
        this.txtTokkijikoNo11.setDisplayNone(isテキスト);
        this.txtTokkijikoNo12.setDisplayNone(isテキスト);
        this.txtTokkijikoNo13.setDisplayNone(isテキスト);
        this.txtTokkijikoNo14.setDisplayNone(isテキスト);
        this.txtTokkijikoNo15.setDisplayNone(isテキスト);
        this.txtTokkijikoNo16.setDisplayNone(isテキスト);
        this.txtTokkijikoNo17.setDisplayNone(isテキスト);
        this.txtTokkijikoNo18.setDisplayNone(isテキスト);
        this.txtTokkijikoNo19.setDisplayNone(isテキスト);
        this.txtTokkijikoNo20.setDisplayNone(isテキスト);
        
        this.lbl1.setDisplayNone(!isテキスト);
        this.lbl2.setDisplayNone(!isテキスト);
        this.lbl3.setDisplayNone(!isテキスト);
        this.lbl4.setDisplayNone(!isテキスト);
        this.lbl5.setDisplayNone(!isテキスト);
        this.lbl6.setDisplayNone(!isテキスト);
        this.lbl7.setDisplayNone(!isテキスト);
        this.lbl8.setDisplayNone(!isテキスト);
        this.lbl9.setDisplayNone(!isテキスト);
        this.lbl10.setDisplayNone(!isテキスト);
        this.lbl11.setDisplayNone(isテキスト);
        this.lbl12.setDisplayNone(isテキスト);
        this.lbl13.setDisplayNone(isテキスト);
        this.lbl14.setDisplayNone(isテキスト);
        this.lbl15.setDisplayNone(isテキスト);
        this.lbl16.setDisplayNone(isテキスト);
        this.lbl17.setDisplayNone(isテキスト);
        this.lbl18.setDisplayNone(isテキスト);
        this.lbl19.setDisplayNone(isテキスト);
        this.lbl20.setDisplayNone(isテキスト);
        
        this.txtRemban1.setDisplayNone(!isテキスト);
        this.txtRemban2.setDisplayNone(!isテキスト);
        this.txtRemban3.setDisplayNone(!isテキスト);
        this.txtRemban4.setDisplayNone(!isテキスト);
        this.txtRemban5.setDisplayNone(!isテキスト);
        this.txtRemban6.setDisplayNone(!isテキスト);
        this.txtRemban7.setDisplayNone(!isテキスト);
        this.txtRemban8.setDisplayNone(!isテキスト);
        this.txtRemban9.setDisplayNone(!isテキスト);
        this.txtRemban10.setDisplayNone(!isテキスト);
        this.txtRemban11.setDisplayNone(isテキスト);
        this.txtRemban12.setDisplayNone(isテキスト);
        this.txtRemban13.setDisplayNone(isテキスト);
        this.txtRemban14.setDisplayNone(isテキスト);
        this.txtRemban15.setDisplayNone(isテキスト);
        this.txtRemban16.setDisplayNone(isテキスト);
        this.txtRemban17.setDisplayNone(isテキスト);
        this.txtRemban18.setDisplayNone(isテキスト);
        this.txtRemban19.setDisplayNone(isテキスト);
        this.txtRemban20.setDisplayNone(isテキスト);
        
        this.txtTextGenpo1.setDisplayNone(!isテキスト);
        this.txtTextGenpo2.setDisplayNone(!isテキスト);
        this.txtTextGenpo3.setDisplayNone(!isテキスト);
        this.txtTextGenpo4.setDisplayNone(!isテキスト);
        this.txtTextGenpo5.setDisplayNone(!isテキスト);
        this.txtTextGenpo6.setDisplayNone(!isテキスト);
        this.txtTextGenpo7.setDisplayNone(!isテキスト);
        this.txtTextGenpo8.setDisplayNone(!isテキスト);
        this.txtTextGenpo9.setDisplayNone(!isテキスト);
        this.txtTextGenpo10.setDisplayNone(!isテキスト);
        this.txtTextMask1.setDisplayNone(!isテキスト);
        this.txtTextMask2.setDisplayNone(!isテキスト);
        this.txtTextMask3.setDisplayNone(!isテキスト);
        this.txtTextMask4.setDisplayNone(!isテキスト);
        this.txtTextMask5.setDisplayNone(!isテキスト);
        this.txtTextMask6.setDisplayNone(!isテキスト);
        this.txtTextMask7.setDisplayNone(!isテキスト);
        this.txtTextMask8.setDisplayNone(!isテキスト);
        this.txtTextMask9.setDisplayNone(!isテキスト);
        this.txtTextMask10.setDisplayNone(!isテキスト);
        
        this.imgGenpo1.setDisplayNone(isテキスト);
        this.imgGenpo2.setDisplayNone(isテキスト);
        this.imgGenpo3.setDisplayNone(isテキスト);
        this.imgGenpo4.setDisplayNone(isテキスト);
        this.imgGenpo5.setDisplayNone(isテキスト);
        this.imgGenpo6.setDisplayNone(isテキスト);
        this.imgGenpo7.setDisplayNone(isテキスト);
        this.imgGenpo8.setDisplayNone(isテキスト);
        this.imgGenpo9.setDisplayNone(isテキスト);
        this.imgGenpo10.setDisplayNone(isテキスト);
        this.imgMasking1.setDisplayNone(isテキスト);
        this.imgMasking2.setDisplayNone(isテキスト);
        this.imgMasking3.setDisplayNone(isテキスト);
        this.imgMasking4.setDisplayNone(isテキスト);
        this.imgMasking5.setDisplayNone(isテキスト);
        this.imgMasking6.setDisplayNone(isテキスト);
        this.imgMasking7.setDisplayNone(isテキスト);
        this.imgMasking8.setDisplayNone(isテキスト);
        this.imgMasking9.setDisplayNone(isテキスト);
        this.imgMasking10.setDisplayNone(isテキスト); 
    }
    
    @JsonIgnore
    private void initializaテキストエリア(NinteiChosaTokkiJikou 認定調査特記事項マッピング, NinteichosahyoTokkijiko 認定調査特記事項, int remban) {
        
        switch (remban) {
            case 1:
                this.txtTokkijikoNo1.setValue(認定調査特記事項マッピング.get画面表示用特記事項番号());
                this.txtRemban1.setValue(new Decimal(認定調査特記事項.get認定調査特記事項連番()));
                if (GenponMaskKubun.原本.getコード().equals(認定調査特記事項.get原本マスク区分().getColumnValue())) {
                    this.txtTextGenpo1.setValue(認定調査特記事項.get特記事項());
                } else {
                    this.txtTextMask1.setValue(認定調査特記事項.get特記事項());
                }
                break;
            case 2:
                this.txtTokkijikoNo2.setValue(認定調査特記事項マッピング.get画面表示用特記事項番号());
                this.txtRemban2.setValue(new Decimal(認定調査特記事項.get認定調査特記事項連番()));
                if (GenponMaskKubun.原本.getコード().equals(認定調査特記事項.get原本マスク区分().getColumnValue())) {
                    this.txtTextGenpo2.setValue(認定調査特記事項.get特記事項());
                } else {
                    this.txtTextMask2.setValue(認定調査特記事項.get特記事項());
                }
                break;
            case 3:
                this.txtTokkijikoNo3.setValue(認定調査特記事項マッピング.get画面表示用特記事項番号());
                this.txtRemban3.setValue(new Decimal(認定調査特記事項.get認定調査特記事項連番()));
                if (GenponMaskKubun.原本.getコード().equals(認定調査特記事項.get原本マスク区分().getColumnValue())) {
                    this.txtTextGenpo3.setValue(認定調査特記事項.get特記事項());
                } else {
                    this.txtTextMask3.setValue(認定調査特記事項.get特記事項());
                }
                break;
            case 4:
                this.txtTokkijikoNo4.setValue(認定調査特記事項マッピング.get画面表示用特記事項番号());
                this.txtRemban4.setValue(new Decimal(認定調査特記事項.get認定調査特記事項連番()));
                if (GenponMaskKubun.原本.getコード().equals(認定調査特記事項.get原本マスク区分().getColumnValue())) {
                    this.txtTextGenpo4.setValue(認定調査特記事項.get特記事項());
                } else {
                    this.txtTextMask4.setValue(認定調査特記事項.get特記事項());
                }
                break;
            case 5:
                this.txtTokkijikoNo5.setValue(認定調査特記事項マッピング.get画面表示用特記事項番号());
                this.txtRemban5.setValue(new Decimal(認定調査特記事項.get認定調査特記事項連番()));
                if (GenponMaskKubun.原本.getコード().equals(認定調査特記事項.get原本マスク区分().getColumnValue())) {
                    this.txtTextGenpo5.setValue(認定調査特記事項.get特記事項());
                } else {
                    this.txtTextMask5.setValue(認定調査特記事項.get特記事項());
                }
                break;
            case 6:
                this.txtTokkijikoNo6.setValue(認定調査特記事項マッピング.get画面表示用特記事項番号());
                this.txtRemban6.setValue(new Decimal(認定調査特記事項.get認定調査特記事項連番()));
                if (GenponMaskKubun.原本.getコード().equals(認定調査特記事項.get原本マスク区分().getColumnValue())) {
                    this.txtTextGenpo6.setValue(認定調査特記事項.get特記事項());
                } else {
                    this.txtTextMask6.setValue(認定調査特記事項.get特記事項());
                }
                break;
            case 7:
                this.txtTokkijikoNo7.setValue(認定調査特記事項マッピング.get画面表示用特記事項番号());
                this.txtRemban7.setValue(new Decimal(認定調査特記事項.get認定調査特記事項連番()));
                if (GenponMaskKubun.原本.getコード().equals(認定調査特記事項.get原本マスク区分().getColumnValue())) {
                    this.txtTextGenpo7.setValue(認定調査特記事項.get特記事項());
                } else {
                    this.txtTextMask7.setValue(認定調査特記事項.get特記事項());
                }
                break;
            case 8:
                this.txtTokkijikoNo8.setValue(認定調査特記事項マッピング.get画面表示用特記事項番号());
                this.txtRemban8.setValue(new Decimal(認定調査特記事項.get認定調査特記事項連番()));
                if (GenponMaskKubun.原本.getコード().equals(認定調査特記事項.get原本マスク区分().getColumnValue())) {
                    this.txtTextGenpo8.setValue(認定調査特記事項.get特記事項());
                } else {
                    this.txtTextMask8.setValue(認定調査特記事項.get特記事項());
                }
                break;
            case 9:
                this.txtTokkijikoNo9.setValue(認定調査特記事項マッピング.get画面表示用特記事項番号());
                this.txtRemban9.setValue(new Decimal(認定調査特記事項.get認定調査特記事項連番()));
                if (GenponMaskKubun.原本.getコード().equals(認定調査特記事項.get原本マスク区分().getColumnValue())) {
                    this.txtTextGenpo9.setValue(認定調査特記事項.get特記事項());
                } else {
                    this.txtTextMask9.setValue(認定調査特記事項.get特記事項());
                }
                break;
            case 10:
                this.txtTokkijikoNo10.setValue(認定調査特記事項マッピング.get画面表示用特記事項番号());
                this.txtRemban10.setValue(new Decimal(認定調査特記事項.get認定調査特記事項連番()));
                if (GenponMaskKubun.原本.getコード().equals(認定調査特記事項.get原本マスク区分().getColumnValue())) {
                    this.txtTextGenpo10.setValue(認定調査特記事項.get特記事項());
                } else {
                    this.txtTextMask10.setValue(認定調査特記事項.get特記事項());
                }
                break;
        }
    }

    @JsonIgnore
    private void initializaイメージエリア(NinteiChosaTokkiJikou 認定調査特記事項マッピング,  NinteichosahyoTokkijiko 認定調査特記事項, int remban) {
        RString path原本 = getImageSrc(Path.combinePath(downLoadFilePath, replaceShareFileName(
                NinteiChosaTokkiJikou.getEnumBy画面認定調査特記事項番号(this.txtTokkiJikouNo.getValue()).getイメージファイル(),
                remban, true)));
        RString pathマスク = getImageSrc(Path.combinePath(downLoadFilePath, replaceShareFileName(
                NinteiChosaTokkiJikou.getEnumBy画面認定調査特記事項番号(this.txtTokkiJikouNo.getValue()).getイメージファイル(),
                remban, false)));

        switch (remban) {
            case 1:
                this.txtTokkijikoNo11.setValue(認定調査特記事項マッピング.get画面表示用特記事項番号());
                this.txtRemban11.setValue(new Decimal(認定調査特記事項.get認定調査特記事項連番()));
                if (File.exists(pathマスク)) {
                    this.imgGenpo1.setSrc(pathマスク);
                    this.imgMasking1.setSrc(path原本);
                } else {
                    this.imgGenpo1.setSrc(path原本);
                }
                break;
            case 2:
                this.txtTokkijikoNo12.setValue(認定調査特記事項マッピング.get画面表示用特記事項番号());
                this.txtRemban12.setValue(new Decimal(認定調査特記事項.get認定調査特記事項連番()));
                if (File.exists(pathマスク)) {
                    this.imgGenpo2.setSrc(pathマスク);
                    this.imgMasking2.setSrc(path原本);
                } else {
                    this.imgGenpo2.setSrc(path原本);
                }
                break;
            case 3:
                this.txtTokkijikoNo13.setValue(認定調査特記事項マッピング.get画面表示用特記事項番号());
                this.txtRemban13.setValue(new Decimal(認定調査特記事項.get認定調査特記事項連番()));
                if (File.exists(pathマスク)) {
                    this.imgGenpo3.setSrc(pathマスク);
                    this.imgMasking3.setSrc(path原本);
                } else {
                    this.imgGenpo3.setSrc(path原本);
                }
                break;
            case 4:
                this.txtTokkijikoNo14.setValue(認定調査特記事項マッピング.get画面表示用特記事項番号());
                this.txtRemban14.setValue(new Decimal(認定調査特記事項.get認定調査特記事項連番()));
                if (File.exists(pathマスク)) {
                    this.imgGenpo4.setSrc(pathマスク);
                    this.imgMasking4.setSrc(path原本);
                } else {
                    this.imgGenpo4.setSrc(path原本);
                }
                break;
            case 5:
                this.txtTokkijikoNo15.setValue(認定調査特記事項マッピング.get画面表示用特記事項番号());
                this.txtRemban15.setValue(new Decimal(認定調査特記事項.get認定調査特記事項連番()));
                if (File.exists(pathマスク)) {
                    this.imgGenpo5.setSrc(pathマスク);
                    this.imgMasking5.setSrc(path原本);
                } else {
                    this.imgGenpo5.setSrc(path原本);
                }
                break;
            case 6:
                this.txtTokkijikoNo16.setValue(認定調査特記事項マッピング.get画面表示用特記事項番号());
                this.txtRemban16.setValue(new Decimal(認定調査特記事項.get認定調査特記事項連番()));
                if (File.exists(pathマスク)) {
                    this.imgGenpo6.setSrc(pathマスク);
                    this.imgMasking6.setSrc(path原本);
                } else {
                    this.imgGenpo6.setSrc(path原本);
                }
                break;
            case 7:
                this.txtTokkijikoNo17.setValue(認定調査特記事項マッピング.get画面表示用特記事項番号());
                this.txtRemban17.setValue(new Decimal(認定調査特記事項.get認定調査特記事項連番()));
                if (File.exists(pathマスク)) {
                    this.imgGenpo7.setSrc(pathマスク);
                    this.imgMasking7.setSrc(path原本);
                } else {
                    this.imgGenpo7.setSrc(path原本);
                }
                break;
            case 8:
                this.txtTokkijikoNo18.setValue(認定調査特記事項マッピング.get画面表示用特記事項番号());
                this.txtRemban18.setValue(new Decimal(認定調査特記事項.get認定調査特記事項連番()));
                if (File.exists(pathマスク)) {
                    this.imgGenpo8.setSrc(pathマスク);
                    this.imgMasking8.setSrc(path原本);
                } else {
                    this.imgGenpo8.setSrc(path原本);
                }
                break;
            case 9:
                this.txtTokkijikoNo19.setValue(認定調査特記事項マッピング.get画面表示用特記事項番号());
                this.txtRemban19.setValue(new Decimal(認定調査特記事項.get認定調査特記事項連番()));
                if (File.exists(pathマスク)) {
                    this.imgGenpo9.setSrc(pathマスク);
                    this.imgMasking9.setSrc(path原本);
                } else {
                    this.imgGenpo9.setSrc(path原本);
                }
                break;
            case 10:
                this.txtTokkijikoNo20.setValue(認定調査特記事項マッピング.get画面表示用特記事項番号());
                this.txtRemban20.setValue(new Decimal(認定調査特記事項.get認定調査特記事項連番()));
                if (File.exists(pathマスク)) {
                    this.imgGenpo10.setSrc(pathマスク);
                    this.imgMasking10.setSrc(path原本);
                } else {
                    this.imgGenpo10.setSrc(path原本);
                }
                break;
        }
    }

    private RString getImageSrc(RString path) {
        return Path.combinePath(new RString(File.separator + "db"), new RString("dbz"), path.substring(path.indexOf("image")));
    }

    @JsonIgnore
    private RString replaceShareFileName(RString sharedFileName, Integer remban, boolean isイメージ原本) {
        RString fileName = sharedFileName.replace("xx", new RString(remban.toString()).padZeroToLeft(2).toString());
        if (!isイメージ原本) {
            return fileName.replace(".png", "_BAK.png");
        }
        return fileName;
    }

    @JsonIgnore
    private RString getDownLoadFilePath(RDateTime sharedFileId, FilesystemName sharedFileName) {
        RString imagePath = Path.combinePath(Path.getUserHomePath(), new RString("app"), new RString("webapps"), new RString("db#dbz"),
                new RString("WEB-INF"), new RString("image"));
        ReadOnlySharedFileEntryDescriptor descriptor
                = new ReadOnlySharedFileEntryDescriptor(sharedFileName, sharedFileId);
        return SharedFile.copyToLocal(descriptor, new FilesystemPath(imagePath)).toRString();
    }

    /**
     * 認定調査特記事項照会用なViewStateKey
     */
    public static enum ChosaTokkiShokaiKey {

        /**
         * 認定調査特記事項List
         */
        認定調査特記事項List;
    }
}
