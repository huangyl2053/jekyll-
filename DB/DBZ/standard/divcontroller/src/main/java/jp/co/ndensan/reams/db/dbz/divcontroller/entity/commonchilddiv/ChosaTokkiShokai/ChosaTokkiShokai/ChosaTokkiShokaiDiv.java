package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ChosaTokkiShokai.ChosaTokkiShokai;
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
import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteichosahyoTokkijiko;
import jp.co.ndensan.reams.db.dbz.definition.core.ninteichosatokkijikou.NinteiChosaTokkiJikou;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.GenponMaskKubun;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.TokkijikoTextImageKubun;
import jp.co.ndensan.reams.db.dbz.service.core.basic.ImageManager;
import jp.co.ndensan.reams.db.dbz.service.core.basic.NinteichosahyoTokkijikoManager;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.cooperation.FilesystemName;
import jp.co.ndensan.reams.uz.uza.cooperation.FilesystemPath;
import jp.co.ndensan.reams.uz.uza.cooperation.SharedFile;
import jp.co.ndensan.reams.uz.uza.cooperation.descriptor.ReadOnlySharedFileEntryDescriptor;
import jp.co.ndensan.reams.uz.uza.io.Directory;
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
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * ChosaTokkiShokai のクラスファイル
 *
 * @author 自動生成
 */
public class ChosaTokkiShokaiDiv extends Panel implements IChosaTokkiShokaiDiv {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-01-15_09-59-03">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("TestTokki")
    private TestTokkiDiv TestTokki;
    @JsonProperty("lblImageTokkiJikoTitle")
    private Label lblImageTokkiJikoTitle;
    @JsonProperty("ImageTokki")
    private ImageTokkiDiv ImageTokki;
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

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getTestTokki
     * @return TestTokki
     */
    @JsonProperty("TestTokki")
    public TestTokkiDiv getTestTokki() {
        return TestTokki;
    }

    /*
     * setTestTokki
     * @param TestTokki TestTokki
     */
    @JsonProperty("TestTokki")
    public void setTestTokki(TestTokkiDiv TestTokki) {
        this.TestTokki = TestTokki;
    }

    /*
     * getlblImageTokkiJikoTitle
     * @return lblImageTokkiJikoTitle
     */
    @JsonProperty("lblImageTokkiJikoTitle")
    public Label getLblImageTokkiJikoTitle() {
        return lblImageTokkiJikoTitle;
    }

    /*
     * setlblImageTokkiJikoTitle
     * @param lblImageTokkiJikoTitle lblImageTokkiJikoTitle
     */
    @JsonProperty("lblImageTokkiJikoTitle")
    public void setLblImageTokkiJikoTitle(Label lblImageTokkiJikoTitle) {
        this.lblImageTokkiJikoTitle = lblImageTokkiJikoTitle;
    }

    /*
     * getImageTokki
     * @return ImageTokki
     */
    @JsonProperty("ImageTokki")
    public ImageTokkiDiv getImageTokki() {
        return ImageTokki;
    }

    /*
     * setImageTokki
     * @param ImageTokki ImageTokki
     */
    @JsonProperty("ImageTokki")
    public void setImageTokki(ImageTokkiDiv ImageTokki) {
        this.ImageTokki = ImageTokki;
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
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public Label getLblTextTokkiJikoTitle() {
        return this.getTestTokki().getLblTextTokkiJikoTitle();
    }

    @JsonIgnore
    public void  setLblTextTokkiJikoTitle(Label lblTextTokkiJikoTitle) {
        this.getTestTokki().setLblTextTokkiJikoTitle(lblTextTokkiJikoTitle);
    }

    @JsonIgnore
    public TextBox getTxtTokkiJikouNo() {
        return this.getTestTokki().getTxtTokkiJikouNo();
    }

    @JsonIgnore
    public void  setTxtTokkiJikouNo(TextBox txtTokkiJikouNo) {
        this.getTestTokki().setTxtTokkiJikouNo(txtTokkiJikouNo);
    }

    @JsonIgnore
    public Label getLblTextTokkiJikoHyphen() {
        return this.getTestTokki().getLblTextTokkiJikoHyphen();
    }

    @JsonIgnore
    public void  setLblTextTokkiJikoHyphen(Label lblTextTokkiJikoHyphen) {
        this.getTestTokki().setLblTextTokkiJikoHyphen(lblTextTokkiJikoHyphen);
    }

    @JsonIgnore
    public TextBoxNum getTxtTokkiJikoNoText() {
        return this.getTestTokki().getTxtTokkiJikoNoText();
    }

    @JsonIgnore
    public void  setTxtTokkiJikoNoText(TextBoxNum txtTokkiJikoNoText) {
        this.getTestTokki().setTxtTokkiJikoNoText(txtTokkiJikoNoText);
    }

    @JsonIgnore
    public TextBox getTxtTokkiJikouName() {
        return this.getTestTokki().getTxtTokkiJikouName();
    }

    @JsonIgnore
    public void  setTxtTokkiJikouName(TextBox txtTokkiJikouName) {
        this.getTestTokki().setTxtTokkiJikouName(txtTokkiJikouName);
    }

    @JsonIgnore
    public Label getLblTextGenpon() {
        return this.getTestTokki().getLblTextGenpon();
    }

    @JsonIgnore
    public void  setLblTextGenpon(Label lblTextGenpon) {
        this.getTestTokki().setLblTextGenpon(lblTextGenpon);
    }

    @JsonIgnore
    public TextBoxMultiLine getTxtTokkijikoInputGenpo() {
        return this.getTestTokki().getTxtTokkijikoInputGenpo();
    }

    @JsonIgnore
    public void  setTxtTokkijikoInputGenpo(TextBoxMultiLine txtTokkijikoInputGenpo) {
        this.getTestTokki().setTxtTokkijikoInputGenpo(txtTokkijikoInputGenpo);
    }

    @JsonIgnore
    public Label getLblTextMask() {
        return this.getTestTokki().getLblTextMask();
    }

    @JsonIgnore
    public void  setLblTextMask(Label lblTextMask) {
        this.getTestTokki().setLblTextMask(lblTextMask);
    }

    @JsonIgnore
    public TextBoxMultiLine getTxtTokkijikoInputMask() {
        return this.getTestTokki().getTxtTokkijikoInputMask();
    }

    @JsonIgnore
    public void  setTxtTokkijikoInputMask(TextBoxMultiLine txtTokkijikoInputMask) {
        this.getTestTokki().setTxtTokkijikoInputMask(txtTokkijikoInputMask);
    }

    @JsonIgnore
    public Button getBtnBeforeTextTokkiJiko() {
        return this.getTestTokki().getBtnBeforeTextTokkiJiko();
    }

    @JsonIgnore
    public void  setBtnBeforeTextTokkiJiko(Button btnBeforeTextTokkiJiko) {
        this.getTestTokki().setBtnBeforeTextTokkiJiko(btnBeforeTextTokkiJiko);
    }

    @JsonIgnore
    public Button getBtnAfterTextTokkiJiko() {
        return this.getTestTokki().getBtnAfterTextTokkiJiko();
    }

    @JsonIgnore
    public void  setBtnAfterTextTokkiJiko(Button btnAfterTextTokkiJiko) {
        this.getTestTokki().setBtnAfterTextTokkiJiko(btnAfterTextTokkiJiko);
    }

    @JsonIgnore
    public Button getBtnBeforeTokkiJikoNoText() {
        return this.getTestTokki().getBtnBeforeTokkiJikoNoText();
    }

    @JsonIgnore
    public void  setBtnBeforeTokkiJikoNoText(Button btnBeforeTokkiJikoNoText) {
        this.getTestTokki().setBtnBeforeTokkiJikoNoText(btnBeforeTokkiJikoNoText);
    }

    @JsonIgnore
    public Button getBtnAfterTokkiJikoNoText() {
        return this.getTestTokki().getBtnAfterTokkiJikoNoText();
    }

    @JsonIgnore
    public void  setBtnAfterTokkiJikoNoText(Button btnAfterTokkiJikoNoText) {
        this.getTestTokki().setBtnAfterTokkiJikoNoText(btnAfterTokkiJikoNoText);
    }

    @JsonIgnore
    public TextBox getTxtTokkiJikouNoImage() {
        return this.getImageTokki().getTxtTokkiJikouNoImage();
    }

    @JsonIgnore
    public void  setTxtTokkiJikouNoImage(TextBox txtTokkiJikouNoImage) {
        this.getImageTokki().setTxtTokkiJikouNoImage(txtTokkiJikouNoImage);
    }

    @JsonIgnore
    public Label getLblTokkiJikoHyphenImage() {
        return this.getImageTokki().getLblTokkiJikoHyphenImage();
    }

    @JsonIgnore
    public void  setLblTokkiJikoHyphenImage(Label lblTokkiJikoHyphenImage) {
        this.getImageTokki().setLblTokkiJikoHyphenImage(lblTokkiJikoHyphenImage);
    }

    @JsonIgnore
    public TextBoxNum getTxtTokkiJikoNoImage() {
        return this.getImageTokki().getTxtTokkiJikoNoImage();
    }

    @JsonIgnore
    public void  setTxtTokkiJikoNoImage(TextBoxNum txtTokkiJikoNoImage) {
        this.getImageTokki().setTxtTokkiJikoNoImage(txtTokkiJikoNoImage);
    }

    @JsonIgnore
    public TextBox getTxtTokkiJikouNameImage() {
        return this.getImageTokki().getTxtTokkiJikouNameImage();
    }

    @JsonIgnore
    public void  setTxtTokkiJikouNameImage(TextBox txtTokkiJikouNameImage) {
        this.getImageTokki().setTxtTokkiJikouNameImage(txtTokkiJikouNameImage);
    }

    @JsonIgnore
    public Label getLblMsgGenpon() {
        return this.getImageTokki().getLblMsgGenpon();
    }

    @JsonIgnore
    public void  setLblMsgGenpon(Label lblMsgGenpon) {
        this.getImageTokki().setLblMsgGenpon(lblMsgGenpon);
    }

    @JsonIgnore
    public StaticImage getImgGenpoImage() {
        return this.getImageTokki().getImgGenpoImage();
    }

    @JsonIgnore
    public void  setImgGenpoImage(StaticImage imgGenpoImage) {
        this.getImageTokki().setImgGenpoImage(imgGenpoImage);
    }

    @JsonIgnore
    public Label getLblMsgMask() {
        return this.getImageTokki().getLblMsgMask();
    }

    @JsonIgnore
    public void  setLblMsgMask(Label lblMsgMask) {
        this.getImageTokki().setLblMsgMask(lblMsgMask);
    }

    @JsonIgnore
    public StaticImage getImgMaskingImage() {
        return this.getImageTokki().getImgMaskingImage();
    }

    @JsonIgnore
    public void  setImgMaskingImage(StaticImage imgMaskingImage) {
        this.getImageTokki().setImgMaskingImage(imgMaskingImage);
    }

    @JsonIgnore
    public Button getBtnBeforeImageTokkiJiko() {
        return this.getImageTokki().getBtnBeforeImageTokkiJiko();
    }

    @JsonIgnore
    public void  setBtnBeforeImageTokkiJiko(Button btnBeforeImageTokkiJiko) {
        this.getImageTokki().setBtnBeforeImageTokkiJiko(btnBeforeImageTokkiJiko);
    }

    @JsonIgnore
    public Button getBtnAfterImageTokkiJiko() {
        return this.getImageTokki().getBtnAfterImageTokkiJiko();
    }

    @JsonIgnore
    public void  setBtnAfterImageTokkiJiko(Button btnAfterImageTokkiJiko) {
        this.getImageTokki().setBtnAfterImageTokkiJiko(btnAfterImageTokkiJiko);
    }

    @JsonIgnore
    public Button getBtnBeforeTokkiJikoNoImg() {
        return this.getImageTokki().getBtnBeforeTokkiJikoNoImg();
    }

    @JsonIgnore
    public void  setBtnBeforeTokkiJikoNoImg(Button btnBeforeTokkiJikoNoImg) {
        this.getImageTokki().setBtnBeforeTokkiJikoNoImg(btnBeforeTokkiJikoNoImg);
    }

    @JsonIgnore
    public Button getBtnAfterTokkiJikoNoImg() {
        return this.getImageTokki().getBtnAfterTokkiJikoNoImg();
    }

    @JsonIgnore
    public void  setBtnAfterTokkiJikoNoImg(Button btnAfterTokkiJikoNoImg) {
        this.getImageTokki().setBtnAfterTokkiJikoNoImg(btnAfterTokkiJikoNoImg);
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
        ArrayList<ArrayList<NinteichosahyoTokkijiko>> 認定調査特記事項List = new ArrayList<>();
        if (認定調査特記事項番号List.size() == 1) {
            認定調査特記事項List.add(list);
        } else if (認定調査特記事項番号List.size() > 1) {
            認定調査特記事項List = create認定調査特記事項List(list);
        }
        maxTokkijikoNo = list.get(list.size() - 1).get認定調査特記事項番号();
        minTokkijikoNo = list.get(0).get認定調査特記事項番号();
        maxRemban = new RString(認定調査特記事項List.get(0).get(認定調査特記事項List.get(0).size() - 1).get認定調査特記事項連番().toString());
        rembanPageNo = new RString("0");
        tokkijikoNoPageNo = new RString("0");
        ViewStateHolder.put(ChosaTokkiShokaiKey.認定調査特記事項List, 認定調査特記事項List);
        initializa(list.get(0));
    }

    /**
     * 画面初期化
     *
     * @param 認定調査特記事項 認定調査特記事項
     */
    @JsonIgnore
    public void initializa(NinteichosahyoTokkijiko 認定調査特記事項) {
        clearValue();
        NinteiChosaTokkiJikou 認定調査特記事項マッピング = NinteiChosaTokkiJikou.getEnumByDbt5205認定調査特記事項番号(認定調査特記事項.get認定調査特記事項番号());
        boolean is特記事項テキスト_イメージ区分がテキスト
                = is特記事項テキスト_イメージ区分がテキスト(認定調査特記事項.get特記事項テキスト_イメージ区分());
        boolean is原本マスク区分が原本
                = is原本マスク区分が原本(認定調査特記事項.get原本マスク区分().getColumnValue());
        initializaテキストエリア(認定調査特記事項マッピング, 認定調査特記事項, is特記事項テキスト_イメージ区分がテキスト, is原本マスク区分が原本);
        initializaイメージエリア(認定調査特記事項マッピング, 認定調査特記事項, is特記事項テキスト_イメージ区分がテキスト, is原本マスク区分が原本);
        setButtonsDisable(is原本マスク区分が原本);
    }

    private void clearValue() {
        getTxtTokkiJikouNo().setValue(RString.EMPTY);
        getTxtTokkiJikoNoText().setValue(Decimal.ZERO);
        getTxtTokkijikoInputGenpo().setValue(RString.EMPTY);
        getTxtTokkijikoInputMask().setValue(RString.EMPTY);
        getTxtTokkiJikouNoImage().setValue(RString.EMPTY);
        getTxtTokkiJikoNoImage().setValue(Decimal.ZERO);
        getImgGenpoImage().setSrc(RString.EMPTY);
        getImgMaskingImage().setSrc(RString.EMPTY);
    }

    @JsonIgnore
    private void initializaテキストエリア(NinteiChosaTokkiJikou 認定調査特記事項マッピング, NinteichosahyoTokkijiko 認定調査特記事項,
            boolean is特記事項テキスト_イメージ区分がテキスト, boolean is原本マスク区分が原本) {
        this.TestTokki.getTxtTokkiJikouNo().setValue(認定調査特記事項マッピング.get画面表示用特記事項番号());
        this.TestTokki.getTxtTokkiJikoNoText().setValue(new Decimal(認定調査特記事項.get認定調査特記事項連番()));
        this.TestTokki.getTxtTokkiJikouName().setValue(認定調査特記事項マッピング.get特記事項名());
        if (is特記事項テキスト_イメージ区分がテキスト && is原本マスク区分が原本) {
            this.TestTokki.getTxtTokkijikoInputGenpo().setValue(認定調査特記事項.get特記事項());
        } else if (is特記事項テキスト_イメージ区分がテキスト && !is原本マスク区分が原本) {
            this.TestTokki.getTxtTokkijikoInputMask().setValue(認定調査特記事項.get特記事項());
        }
    }

    @JsonIgnore
    private void initializaイメージエリア(NinteiChosaTokkiJikou 認定調査特記事項マッピング, NinteichosahyoTokkijiko 認定調査特記事項,
            boolean is特記事項テキスト_イメージ区分がテキスト, boolean is原本マスク区分が原本) {
        this.ImageTokki.getTxtTokkiJikouNoImage().setValue(認定調査特記事項マッピング.get画面表示用特記事項番号());
        this.ImageTokki.getTxtTokkiJikoNoImage().setValue(new Decimal(認定調査特記事項.get認定調査特記事項連番()));
        this.ImageTokki.getTxtTokkiJikouNameImage().setValue(認定調査特記事項マッピング.get特記事項名());
        getImage(認定調査特記事項, is特記事項テキスト_イメージ区分がテキスト, is原本マスク区分が原本);
    }

    @JsonIgnore
    private void getImage(NinteichosahyoTokkijiko 認定調査特記事項, boolean is特記事項テキスト_イメージ区分がテキスト, boolean is原本マスク区分が原本) {
        if (TokkijikoTextImageKubun.イメージ.getコード().equals(認定調査特記事項.get特記事項テキスト_イメージ区分())) {
            ImageManager imageManager = InstanceProvider.create(ImageManager.class);
            RDateTime sharedFileId = imageManager.getイメージ情報(new ShinseishoKanriNo(shinseishoKanriNo)).getイメージ共有ファイルID();
            if (sharedFileId != null) {
                if (!is特記事項テキスト_イメージ区分がテキスト && is原本マスク区分が原本) {
                    RString sharedFileName = replaceShareFileName(
                            NinteiChosaTokkiJikou.getEnumByDbt5205認定調査特記事項番号(TestTokki.getTxtTokkiJikouNo().getValue()).getイメージファイル(),
                            認定調査特記事項.get認定調査特記事項連番(), !is特記事項テキスト_イメージ区分がテキスト && true);
                    ImageTokki.getImgGenpoImage().setSrc(getFilePath(sharedFileId, sharedFileName).toRString());
                } else if (!is特記事項テキスト_イメージ区分がテキスト && !is原本マスク区分が原本) {
                    RString sharedFileName = replaceShareFileName(
                            NinteiChosaTokkiJikou.getEnumByDbt5205認定調査特記事項番号(TestTokki.getTxtTokkiJikouNo().getValue()).getイメージファイル(),
                            認定調査特記事項.get認定調査特記事項連番(), false);
                    ImageTokki.getImgMaskingImage().setSrc(getFilePath(sharedFileId, sharedFileName).toRString());
                }
            }
        }
    }

    @JsonIgnore
    private void setButtonsDisable(boolean isテキスト) {
        int 連番 = TestTokki.getTxtTokkiJikoNoText().getValue().intValue();
        RString 特記事項番号 = NinteiChosaTokkiJikou.getEnumBy画面認定調査特記事項番号(TestTokki.getTxtTokkiJikouNo().getValue())
                .get認定調査票_特記情報_認定調査特記事項番号();
        setテキスト前へDisable(isテキスト, 連番);
        setテキスト次へDisable(isテキスト, 連番);
        setテキスト前へ_特記事項番号Disable(isテキスト, 特記事項番号);
        setテキスト次へ_特記事項番号Disable(isテキスト, 特記事項番号);
        setイメージ前へDisable(isテキスト, 連番);
        setイメージ次へDisable(isテキスト, 連番);
        setイメージ前へ_特記事項番号Disable(isテキスト, 特記事項番号);
        setイメージ次へ_特記事項番号Disable(isテキスト, 特記事項番号);
    }

    @JsonIgnore
    private void setテキスト前へDisable(boolean isテキスト, int 連番) {
        boolean isDisable = !isテキスト || 連番 == 1;
        TestTokki.getBtnBeforeTextTokkiJiko().setDisabled(isDisable);
    }

    @JsonIgnore
    private void setテキスト次へDisable(boolean isテキスト, int 連番) {
        boolean isDisable = !isテキスト || 連番 == Integer.parseInt(maxRemban.toString());
        TestTokki.getBtnAfterTextTokkiJiko().setDisabled(isDisable);
    }

    @JsonIgnore
    private void setテキスト前へ_特記事項番号Disable(boolean isテキスト, RString 特記事項番号) {
        boolean isDisable = !isテキスト || 特記事項番号.equals(minTokkijikoNo);
        TestTokki.getBtnBeforeTokkiJikoNoText().setDisabled(isDisable);
    }

    @JsonIgnore
    private void setテキスト次へ_特記事項番号Disable(boolean isテキスト, RString 特記事項番号) {
        boolean isDisable = !isテキスト || 特記事項番号.equals(maxTokkijikoNo);
        TestTokki.getBtnAfterTokkiJikoNoText().setDisabled(isDisable);
    }

    @JsonIgnore
    private void setイメージ前へDisable(boolean isテキスト, int 連番) {
        boolean isDisable = isテキスト || 連番 == 1;
        ImageTokki.getBtnBeforeImageTokkiJiko().setDisabled(isDisable);
    }

    @JsonIgnore
    private void setイメージ次へDisable(boolean isテキスト, int 連番) {
        boolean isDisable = isテキスト || 連番 == Integer.parseInt(maxRemban.toString());
        ImageTokki.getBtnAfterImageTokkiJiko().setDisabled(isDisable);
    }

    @JsonIgnore
    private void setイメージ前へ_特記事項番号Disable(boolean isテキスト, RString 特記事項番号) {
        boolean isDisable = isテキスト || 特記事項番号.equals(minTokkijikoNo);
        ImageTokki.getBtnBeforeTokkiJikoNoImg().setDisabled(isDisable);
    }

    @JsonIgnore
    private void setイメージ次へ_特記事項番号Disable(boolean isテキスト, RString 特記事項番号) {
        boolean isDisable = isテキスト || 特記事項番号.equals(maxTokkijikoNo);
        ImageTokki.getBtnAfterTokkiJikoNoImg().setDisabled(isDisable);
    }

    @JsonIgnore
    private boolean is特記事項テキスト_イメージ区分がテキスト(RString 区分) {
        return TokkijikoTextImageKubun.テキスト.getコード().equals(区分);
    }

    @JsonIgnore
    private boolean is原本マスク区分が原本(RString 区分) {
        return GenponMaskKubun.原本.getコード().equals(区分);
    }

    @JsonIgnore
    private RString replaceShareFileName(RString sharedFileName, Integer remban, boolean isイメージ原本) {
        RString fileName = sharedFileName.replace("xx", remban.toString());
        if (!isイメージ原本) {
            return fileName.replace(".png", "_BAK.png");
        }
        return fileName;
    }

    @JsonIgnore
    private FilesystemPath getFilePath(RDateTime sharedFileId, RString sharedFileName) {
        RString tmpPath = Path.combinePath(Directory.createTmpDirectory(), sharedFileName);
        ReadOnlySharedFileEntryDescriptor descriptor
                = new ReadOnlySharedFileEntryDescriptor(new FilesystemName(sharedFileName),
                        sharedFileId);
        return SharedFile.copyToLocal(descriptor, new FilesystemPath(tmpPath));
    }

    @JsonIgnore
    private ArrayList<ArrayList<NinteichosahyoTokkijiko>> create認定調査特記事項List(List<NinteichosahyoTokkijiko> list) {
        ArrayList<ArrayList<NinteichosahyoTokkijiko>> 認定調査特記事項List = new ArrayList<>();
        RString 特記事項番号 = RString.EMPTY;
        ArrayList<NinteichosahyoTokkijiko> tokkijikos = new ArrayList<>();
        for (NinteichosahyoTokkijiko tokkijiko : list) {
            if (!特記事項番号.equals(tokkijiko.get認定調査特記事項番号()) && !tokkijikos.isEmpty()) {
                認定調査特記事項List.add(tokkijikos);
                tokkijikos = new ArrayList<>();
            }
            特記事項番号 = tokkijiko.get認定調査特記事項番号();
            tokkijikos.add(tokkijiko);
        }
        if (!tokkijikos.isEmpty()) {
            認定調査特記事項List.add(tokkijikos);
        }
        return 認定調査特記事項List;
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
