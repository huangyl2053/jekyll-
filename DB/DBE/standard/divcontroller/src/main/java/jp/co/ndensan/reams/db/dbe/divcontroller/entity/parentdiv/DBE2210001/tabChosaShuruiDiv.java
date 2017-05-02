package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2210001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.TabContainer;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * tabChosaShurui のクラスファイル 
 * 
 * @author 自動生成
 */
public class tabChosaShuruiDiv extends TabContainer {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2017-02-23_13-41-30">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("tplGaikyoChosa")
    private tplGaikyoChosaDiv tplGaikyoChosa;
    @JsonProperty("tplKihonChosa")
    private tplKihonChosaDiv tplKihonChosa;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettplGaikyoChosa
     * @return tplGaikyoChosa
     */
    @JsonProperty("tplGaikyoChosa")
    public tplGaikyoChosaDiv getTplGaikyoChosa() {
        return tplGaikyoChosa;
    }

    /*
     * settplGaikyoChosa
     * @param tplGaikyoChosa tplGaikyoChosa
     */
    @JsonProperty("tplGaikyoChosa")
    public void setTplGaikyoChosa(tplGaikyoChosaDiv tplGaikyoChosa) {
        this.tplGaikyoChosa = tplGaikyoChosa;
    }

    /*
     * gettplKihonChosa
     * @return tplKihonChosa
     */
    @JsonProperty("tplKihonChosa")
    public tplKihonChosaDiv getTplKihonChosa() {
        return tplKihonChosa;
    }

    /*
     * settplKihonChosa
     * @param tplKihonChosa tplKihonChosa
     */
    @JsonProperty("tplKihonChosa")
    public void setTplKihonChosa(tplKihonChosaDiv tplKihonChosa) {
        this.tplKihonChosa = tplKihonChosa;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public RadioButton getRadGenzaiservis() {
        return this.getTplGaikyoChosa().getRadGenzaiservis();
    }

    @JsonIgnore
    public void  setRadGenzaiservis(RadioButton radGenzaiservis) {
        this.getTplGaikyoChosa().setRadGenzaiservis(radGenzaiservis);
    }

    @JsonIgnore
    public tabChosaBashoDiv getTabChosaBasho() {
        return this.getTplGaikyoChosa().getTabChosaBasho();
    }

    @JsonIgnore
    public void  setTabChosaBasho(tabChosaBashoDiv tabChosaBasho) {
        this.getTplGaikyoChosa().setTabChosaBasho(tabChosaBasho);
    }

    @JsonIgnore
    public tplZaitakuDiv getTplZaitaku() {
        return this.getTplGaikyoChosa().getTabChosaBasho().getTplZaitaku();
    }

    @JsonIgnore
    public void  setTplZaitaku(tplZaitakuDiv tplZaitaku) {
        this.getTplGaikyoChosa().getTabChosaBasho().setTplZaitaku(tplZaitaku);
    }

    @JsonIgnore
    public RadioButton getRadJutakuKaishu() {
        return this.getTplGaikyoChosa().getTabChosaBasho().getTplZaitaku().getRadJutakuKaishu();
    }

    @JsonIgnore
    public void  setRadJutakuKaishu(RadioButton radJutakuKaishu) {
        this.getTplGaikyoChosa().getTabChosaBasho().getTplZaitaku().setRadJutakuKaishu(radJutakuKaishu);
    }

    @JsonIgnore
    public JutakuGaikyoChosaDiv getJutakuGaikyoChosa() {
        return this.getTplGaikyoChosa().getTabChosaBasho().getTplZaitaku().getJutakuGaikyoChosa();
    }

    @JsonIgnore
    public void  setJutakuGaikyoChosa(JutakuGaikyoChosaDiv JutakuGaikyoChosa) {
        this.getTplGaikyoChosa().getTabChosaBasho().getTplZaitaku().setJutakuGaikyoChosa(JutakuGaikyoChosa);
    }

    @JsonIgnore
    public DataGrid<dgRiyoServiceJyokyo_Row> getDgRiyoServiceJyokyo() {
        return this.getTplGaikyoChosa().getTabChosaBasho().getTplZaitaku().getJutakuGaikyoChosa().getDgRiyoServiceJyokyo();
    }

    @JsonIgnore
    public void  setDgRiyoServiceJyokyo(DataGrid<dgRiyoServiceJyokyo_Row> dgRiyoServiceJyokyo) {
        this.getTplGaikyoChosa().getTabChosaBasho().getTplZaitaku().getJutakuGaikyoChosa().setDgRiyoServiceJyokyo(dgRiyoServiceJyokyo);
    }

    @JsonIgnore
    public ShichosonTokubetsuKyufuDiv getShichosonTokubetsuKyufu() {
        return this.getTplGaikyoChosa().getTabChosaBasho().getTplZaitaku().getShichosonTokubetsuKyufu();
    }

    @JsonIgnore
    public void  setShichosonTokubetsuKyufu(ShichosonTokubetsuKyufuDiv ShichosonTokubetsuKyufu) {
        this.getTplGaikyoChosa().getTabChosaBasho().getTplZaitaku().setShichosonTokubetsuKyufu(ShichosonTokubetsuKyufu);
    }

    @JsonIgnore
    public Label getLblShichosonTokubetsuKyufu() {
        return this.getTplGaikyoChosa().getTabChosaBasho().getTplZaitaku().getShichosonTokubetsuKyufu().getLblShichosonTokubetsuKyufu();
    }

    @JsonIgnore
    public void  setLblShichosonTokubetsuKyufu(Label lblShichosonTokubetsuKyufu) {
        this.getTplGaikyoChosa().getTabChosaBasho().getTplZaitaku().getShichosonTokubetsuKyufu().setLblShichosonTokubetsuKyufu(lblShichosonTokubetsuKyufu);
    }

    @JsonIgnore
    public DynamicImage getImgShichosonTokubetsuKyufu() {
        return this.getTplGaikyoChosa().getTabChosaBasho().getTplZaitaku().getShichosonTokubetsuKyufu().getImgShichosonTokubetsuKyufu();
    }

    @JsonIgnore
    public void  setImgShichosonTokubetsuKyufu(DynamicImage imgShichosonTokubetsuKyufu) {
        this.getTplGaikyoChosa().getTabChosaBasho().getTplZaitaku().getShichosonTokubetsuKyufu().setImgShichosonTokubetsuKyufu(imgShichosonTokubetsuKyufu);
    }

    @JsonIgnore
    public TextBoxMultiLine getTxtShichosonTokubetsuKyufu() {
        return this.getTplGaikyoChosa().getTabChosaBasho().getTplZaitaku().getTxtShichosonTokubetsuKyufu();
    }

    @JsonIgnore
    public void  setTxtShichosonTokubetsuKyufu(TextBoxMultiLine txtShichosonTokubetsuKyufu) {
        this.getTplGaikyoChosa().getTabChosaBasho().getTplZaitaku().setTxtShichosonTokubetsuKyufu(txtShichosonTokubetsuKyufu);
    }

    @JsonIgnore
    public TextBoxMultiLine getTxtKyufuIgaiJutakuService() {
        return this.getTplGaikyoChosa().getTabChosaBasho().getTplZaitaku().getTxtKyufuIgaiJutakuService();
    }

    @JsonIgnore
    public void  setTxtKyufuIgaiJutakuService(TextBoxMultiLine txtKyufuIgaiJutakuService) {
        this.getTplGaikyoChosa().getTabChosaBasho().getTplZaitaku().setTxtKyufuIgaiJutakuService(txtKyufuIgaiJutakuService);
    }

    @JsonIgnore
    public ZaitakuServiceDiv getZaitakuService() {
        return this.getTplGaikyoChosa().getTabChosaBasho().getTplZaitaku().getZaitakuService();
    }

    @JsonIgnore
    public void  setZaitakuService(ZaitakuServiceDiv ZaitakuService) {
        this.getTplGaikyoChosa().getTabChosaBasho().getTplZaitaku().setZaitakuService(ZaitakuService);
    }

    @JsonIgnore
    public Label getLblZaitakuService() {
        return this.getTplGaikyoChosa().getTabChosaBasho().getTplZaitaku().getZaitakuService().getLblZaitakuService();
    }

    @JsonIgnore
    public void  setLblZaitakuService(Label lblZaitakuService) {
        this.getTplGaikyoChosa().getTabChosaBasho().getTplZaitaku().getZaitakuService().setLblZaitakuService(lblZaitakuService);
    }

    @JsonIgnore
    public DynamicImage getImgZaitakuService() {
        return this.getTplGaikyoChosa().getTabChosaBasho().getTplZaitaku().getZaitakuService().getImgZaitakuService();
    }

    @JsonIgnore
    public void  setImgZaitakuService(DynamicImage imgZaitakuService) {
        this.getTplGaikyoChosa().getTabChosaBasho().getTplZaitaku().getZaitakuService().setImgZaitakuService(imgZaitakuService);
    }

    @JsonIgnore
    public tplShisetsuDiv getTplShisetsu() {
        return this.getTplGaikyoChosa().getTabChosaBasho().getTplShisetsu();
    }

    @JsonIgnore
    public void  setTplShisetsu(tplShisetsuDiv tplShisetsu) {
        this.getTplGaikyoChosa().getTabChosaBasho().setTplShisetsu(tplShisetsu);
    }

    @JsonIgnore
    public GaikyoTokkiShisetsuDiv getGaikyoTokkiShisetsu() {
        return this.getTplGaikyoChosa().getTabChosaBasho().getTplShisetsu().getGaikyoTokkiShisetsu();
    }

    @JsonIgnore
    public void  setGaikyoTokkiShisetsu(GaikyoTokkiShisetsuDiv GaikyoTokkiShisetsu) {
        this.getTplGaikyoChosa().getTabChosaBasho().getTplShisetsu().setGaikyoTokkiShisetsu(GaikyoTokkiShisetsu);
    }

    @JsonIgnore
    public DataGrid<dgRiyoShisetsu_Row> getDgRiyoShisetsu() {
        return this.getTplGaikyoChosa().getTabChosaBasho().getTplShisetsu().getGaikyoTokkiShisetsu().getDgRiyoShisetsu();
    }

    @JsonIgnore
    public void  setDgRiyoShisetsu(DataGrid<dgRiyoShisetsu_Row> dgRiyoShisetsu) {
        this.getTplGaikyoChosa().getTabChosaBasho().getTplShisetsu().getGaikyoTokkiShisetsu().setDgRiyoShisetsu(dgRiyoShisetsu);
    }

    @JsonIgnore
    public GaigyoShisetsuRenrakusakiDiv getGaigyoShisetsuRenrakusaki() {
        return this.getTplGaikyoChosa().getTabChosaBasho().getTplShisetsu().getGaigyoShisetsuRenrakusaki();
    }

    @JsonIgnore
    public void  setGaigyoShisetsuRenrakusaki(GaigyoShisetsuRenrakusakiDiv GaigyoShisetsuRenrakusaki) {
        this.getTplGaikyoChosa().getTabChosaBasho().getTplShisetsu().setGaigyoShisetsuRenrakusaki(GaigyoShisetsuRenrakusaki);
    }

    @JsonIgnore
    public TextBox getTxtShisetsuMeisdho() {
        return this.getTplGaikyoChosa().getTabChosaBasho().getTplShisetsu().getGaigyoShisetsuRenrakusaki().getTxtShisetsuMeisdho();
    }

    @JsonIgnore
    public void  setTxtShisetsuMeisdho(TextBox txtShisetsuMeisdho) {
        this.getTplGaikyoChosa().getTabChosaBasho().getTplShisetsu().getGaigyoShisetsuRenrakusaki().setTxtShisetsuMeisdho(txtShisetsuMeisdho);
    }

    @JsonIgnore
    public TextBoxYubinNo getTxtShisetsuYubinNo() {
        return this.getTplGaikyoChosa().getTabChosaBasho().getTplShisetsu().getGaigyoShisetsuRenrakusaki().getTxtShisetsuYubinNo();
    }

    @JsonIgnore
    public void  setTxtShisetsuYubinNo(TextBoxYubinNo txtShisetsuYubinNo) {
        this.getTplGaikyoChosa().getTabChosaBasho().getTplShisetsu().getGaigyoShisetsuRenrakusaki().setTxtShisetsuYubinNo(txtShisetsuYubinNo);
    }

    @JsonIgnore
    public TextBoxJusho getTxtShisetsuJusho() {
        return this.getTplGaikyoChosa().getTabChosaBasho().getTplShisetsu().getGaigyoShisetsuRenrakusaki().getTxtShisetsuJusho();
    }

    @JsonIgnore
    public void  setTxtShisetsuJusho(TextBoxJusho txtShisetsuJusho) {
        this.getTplGaikyoChosa().getTabChosaBasho().getTplShisetsu().getGaigyoShisetsuRenrakusaki().setTxtShisetsuJusho(txtShisetsuJusho);
    }

    @JsonIgnore
    public TextBoxTelNo getTxtTelNo() {
        return this.getTplGaikyoChosa().getTabChosaBasho().getTplShisetsu().getGaigyoShisetsuRenrakusaki().getTxtTelNo();
    }

    @JsonIgnore
    public void  setTxtTelNo(TextBoxTelNo txtTelNo) {
        this.getTplGaikyoChosa().getTabChosaBasho().getTplShisetsu().getGaigyoShisetsuRenrakusaki().setTxtTelNo(txtTelNo);
    }

    @JsonIgnore
    public ImageGaigyoShisetsuRenrakusakiDiv getImageGaigyoShisetsuRenrakusaki() {
        return this.getTplGaikyoChosa().getTabChosaBasho().getTplShisetsu().getImageGaigyoShisetsuRenrakusaki();
    }

    @JsonIgnore
    public void  setImageGaigyoShisetsuRenrakusaki(ImageGaigyoShisetsuRenrakusakiDiv ImageGaigyoShisetsuRenrakusaki) {
        this.getTplGaikyoChosa().getTabChosaBasho().getTplShisetsu().setImageGaigyoShisetsuRenrakusaki(ImageGaigyoShisetsuRenrakusaki);
    }

    @JsonIgnore
    public Label getLblShisetsuMeisho() {
        return this.getTplGaikyoChosa().getTabChosaBasho().getTplShisetsu().getImageGaigyoShisetsuRenrakusaki().getLblShisetsuMeisho();
    }

    @JsonIgnore
    public void  setLblShisetsuMeisho(Label lblShisetsuMeisho) {
        this.getTplGaikyoChosa().getTabChosaBasho().getTplShisetsu().getImageGaigyoShisetsuRenrakusaki().setLblShisetsuMeisho(lblShisetsuMeisho);
    }

    @JsonIgnore
    public DynamicImage getImgShisetsuMeisho() {
        return this.getTplGaikyoChosa().getTabChosaBasho().getTplShisetsu().getImageGaigyoShisetsuRenrakusaki().getImgShisetsuMeisho();
    }

    @JsonIgnore
    public void  setImgShisetsuMeisho(DynamicImage imgShisetsuMeisho) {
        this.getTplGaikyoChosa().getTabChosaBasho().getTplShisetsu().getImageGaigyoShisetsuRenrakusaki().setImgShisetsuMeisho(imgShisetsuMeisho);
    }

    @JsonIgnore
    public Label getLblJusho() {
        return this.getTplGaikyoChosa().getTabChosaBasho().getTplShisetsu().getImageGaigyoShisetsuRenrakusaki().getLblJusho();
    }

    @JsonIgnore
    public void  setLblJusho(Label lblJusho) {
        this.getTplGaikyoChosa().getTabChosaBasho().getTplShisetsu().getImageGaigyoShisetsuRenrakusaki().setLblJusho(lblJusho);
    }

    @JsonIgnore
    public DynamicImage getImgJusho() {
        return this.getTplGaikyoChosa().getTabChosaBasho().getTplShisetsu().getImageGaigyoShisetsuRenrakusaki().getImgJusho();
    }

    @JsonIgnore
    public void  setImgJusho(DynamicImage imgJusho) {
        this.getTplGaikyoChosa().getTabChosaBasho().getTplShisetsu().getImageGaigyoShisetsuRenrakusaki().setImgJusho(imgJusho);
    }

    @JsonIgnore
    public Label getLbTel() {
        return this.getTplGaikyoChosa().getTabChosaBasho().getTplShisetsu().getImageGaigyoShisetsuRenrakusaki().getLbTel();
    }

    @JsonIgnore
    public void  setLbTel(Label lbTel) {
        this.getTplGaikyoChosa().getTabChosaBasho().getTplShisetsu().getImageGaigyoShisetsuRenrakusaki().setLbTel(lbTel);
    }

    @JsonIgnore
    public DynamicImage getImgTel() {
        return this.getTplGaikyoChosa().getTabChosaBasho().getTplShisetsu().getImageGaigyoShisetsuRenrakusaki().getImgTel();
    }

    @JsonIgnore
    public void  setImgTel(DynamicImage imgTel) {
        this.getTplGaikyoChosa().getTabChosaBasho().getTplShisetsu().getImageGaigyoShisetsuRenrakusaki().setImgTel(imgTel);
    }

    @JsonIgnore
    public GaikyoTokkiInputDiv getGaikyoTokkiInput() {
        return this.getTplGaikyoChosa().getGaikyoTokkiInput();
    }

    @JsonIgnore
    public void  setGaikyoTokkiInput(GaikyoTokkiInputDiv GaikyoTokkiInput) {
        this.getTplGaikyoChosa().setGaikyoTokkiInput(GaikyoTokkiInput);
    }

    @JsonIgnore
    public Label getLblGaigyoTokkiComment() {
        return this.getTplGaikyoChosa().getGaikyoTokkiInput().getLblGaigyoTokkiComment();
    }

    @JsonIgnore
    public void  setLblGaigyoTokkiComment(Label lblGaigyoTokkiComment) {
        this.getTplGaikyoChosa().getGaikyoTokkiInput().setLblGaigyoTokkiComment(lblGaigyoTokkiComment);
    }

    @JsonIgnore
    public TextBoxMultiLine getTxtGaikyoTokkiNyuroku() {
        return this.getTplGaikyoChosa().getGaikyoTokkiInput().getTxtGaikyoTokkiNyuroku();
    }

    @JsonIgnore
    public void  setTxtGaikyoTokkiNyuroku(TextBoxMultiLine txtGaikyoTokkiNyuroku) {
        this.getTplGaikyoChosa().getGaikyoTokkiInput().setTxtGaikyoTokkiNyuroku(txtGaikyoTokkiNyuroku);
    }

    @JsonIgnore
    public TokkiDiv getTokki() {
        return this.getTplGaikyoChosa().getGaikyoTokkiInput().getTokki();
    }

    @JsonIgnore
    public void  setTokki(TokkiDiv Tokki) {
        this.getTplGaikyoChosa().getGaikyoTokkiInput().setTokki(Tokki);
    }

    @JsonIgnore
    public DynamicImage getImgTokkiJiko() {
        return this.getTplGaikyoChosa().getGaikyoTokkiInput().getTokki().getImgTokkiJiko();
    }

    @JsonIgnore
    public void  setImgTokkiJiko(DynamicImage imgTokkiJiko) {
        this.getTplGaikyoChosa().getGaikyoTokkiInput().getTokki().setImgTokkiJiko(imgTokkiJiko);
    }

    @JsonIgnore
    public ButtonDialog getBtnTeikeibun() {
        return this.getTplGaikyoChosa().getGaikyoTokkiInput().getBtnTeikeibun();
    }

    @JsonIgnore
    public void  setBtnTeikeibun(ButtonDialog btnTeikeibun) {
        this.getTplGaikyoChosa().getGaikyoTokkiInput().setBtnTeikeibun(btnTeikeibun);
    }

    @JsonIgnore
    public Button getBtnKiteichiSettei() {
        return this.getTplKihonChosa().getBtnKiteichiSettei();
    }

    @JsonIgnore
    public void  setBtnKiteichiSettei(Button btnKiteichiSettei) {
        this.getTplKihonChosa().setBtnKiteichiSettei(btnKiteichiSettei);
    }

    @JsonIgnore
    public Button getBtnZenkaiCopy() {
        return this.getTplKihonChosa().getBtnZenkaiCopy();
    }

    @JsonIgnore
    public void  setBtnZenkaiCopy(Button btnZenkaiCopy) {
        this.getTplKihonChosa().setBtnZenkaiCopy(btnZenkaiCopy);
    }

    @JsonIgnore
    public TextBox getTxtIchijiHanteiKekka() {
        return this.getTplKihonChosa().getTxtIchijiHanteiKekka();
    }

    @JsonIgnore
    public void  setTxtIchijiHanteiKekka(TextBox txtIchijiHanteiKekka) {
        this.getTplKihonChosa().setTxtIchijiHanteiKekka(txtIchijiHanteiKekka);
    }

    @JsonIgnore
    public ButtonDialog getBtnIchiHanteiJisshi() {
        return this.getTplKihonChosa().getBtnIchiHanteiJisshi();
    }

    @JsonIgnore
    public void  setBtnIchiHanteiJisshi(ButtonDialog btnIchiHanteiJisshi) {
        this.getTplKihonChosa().setBtnIchiHanteiJisshi(btnIchiHanteiJisshi);
    }

    @JsonIgnore
    public kihonchosaSelectDiv getKihonchosaSelect() {
        return this.getTplKihonChosa().getKihonchosaSelect();
    }

    @JsonIgnore
    public void  setKihonchosaSelect(kihonchosaSelectDiv kihonchosaSelect) {
        this.getTplKihonChosa().setKihonchosaSelect(kihonchosaSelect);
    }

    @JsonIgnore
    public ButtonDialog getBtnKihonchosa1() {
        return this.getTplKihonChosa().getKihonchosaSelect().getBtnKihonchosa1();
    }

    @JsonIgnore
    public void  setBtnKihonchosa1(ButtonDialog btnKihonchosa1) {
        this.getTplKihonChosa().getKihonchosaSelect().setBtnKihonchosa1(btnKihonchosa1);
    }

    @JsonIgnore
    public ButtonDialog getBtnKihonchosa2() {
        return this.getTplKihonChosa().getKihonchosaSelect().getBtnKihonchosa2();
    }

    @JsonIgnore
    public void  setBtnKihonchosa2(ButtonDialog btnKihonchosa2) {
        this.getTplKihonChosa().getKihonchosaSelect().setBtnKihonchosa2(btnKihonchosa2);
    }

    @JsonIgnore
    public ButtonDialog getBtnKihonchosa3() {
        return this.getTplKihonChosa().getKihonchosaSelect().getBtnKihonchosa3();
    }

    @JsonIgnore
    public void  setBtnKihonchosa3(ButtonDialog btnKihonchosa3) {
        this.getTplKihonChosa().getKihonchosaSelect().setBtnKihonchosa3(btnKihonchosa3);
    }

    @JsonIgnore
    public ButtonDialog getBtnKihonchosa4() {
        return this.getTplKihonChosa().getKihonchosaSelect().getBtnKihonchosa4();
    }

    @JsonIgnore
    public void  setBtnKihonchosa4(ButtonDialog btnKihonchosa4) {
        this.getTplKihonChosa().getKihonchosaSelect().setBtnKihonchosa4(btnKihonchosa4);
    }

    @JsonIgnore
    public ButtonDialog getBtnKihonchosa5() {
        return this.getTplKihonChosa().getKihonchosaSelect().getBtnKihonchosa5();
    }

    @JsonIgnore
    public void  setBtnKihonchosa5(ButtonDialog btnKihonchosa5) {
        this.getTplKihonChosa().getKihonchosaSelect().setBtnKihonchosa5(btnKihonchosa5);
    }

    @JsonIgnore
    public ButtonDialog getBtnKihonchosa6() {
        return this.getTplKihonChosa().getKihonchosaSelect().getBtnKihonchosa6();
    }

    @JsonIgnore
    public void  setBtnKihonchosa6(ButtonDialog btnKihonchosa6) {
        this.getTplKihonChosa().getKihonchosaSelect().setBtnKihonchosa6(btnKihonchosa6);
    }

    @JsonIgnore
    public ButtonDialog getBtnKihonchosa7() {
        return this.getTplKihonChosa().getKihonchosaSelect().getBtnKihonchosa7();
    }

    @JsonIgnore
    public void  setBtnKihonchosa7(ButtonDialog btnKihonchosa7) {
        this.getTplKihonChosa().getKihonchosaSelect().setBtnKihonchosa7(btnKihonchosa7);
    }

    @JsonIgnore
    public ButtonDialog getBtnTokkiJiko() {
        return this.getTplKihonChosa().getKihonchosaSelect().getBtnTokkiJiko();
    }

    @JsonIgnore
    public void  setBtnTokkiJiko(ButtonDialog btnTokkiJiko) {
        this.getTplKihonChosa().getKihonchosaSelect().setBtnTokkiJiko(btnTokkiJiko);
    }

    @JsonIgnore
    public ButtonDialog getBtnImageTokkiJiko() {
        return this.getTplKihonChosa().getKihonchosaSelect().getBtnImageTokkiJiko();
    }

    @JsonIgnore
    public void  setBtnImageTokkiJiko(ButtonDialog btnImageTokkiJiko) {
        this.getTplKihonChosa().getKihonchosaSelect().setBtnImageTokkiJiko(btnImageTokkiJiko);
    }

    // </editor-fold>
}
