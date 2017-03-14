package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2210001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ChosaJisshishaJoho.ChosaJisshishaJoho.ChosaJisshishaJohoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ChosaJisshishaJoho.ChosaJisshishaJoho.IChosaJisshishaJohoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.NinteiShinseiRenrakusakiKihon.NinteiShinseiRenrakusakiKihon.INinteiShinseiRenrakusakiKihonDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.NinteiShinseiRenrakusakiKihon.NinteiShinseiRenrakusakiKihon.NinteiShinseiRenrakusakiKihonDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ninteishinseishakihoninfo.NinteiShinseishaKihonInfo.INinteiShinseishaKihonInfoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ninteishinseishakihoninfo.NinteiShinseishaKihonInfo.NinteiShinseishaKihonInfoDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * NinteiChosaNyuryoku のクラスファイル 
 * 
 * @author 自動生成
 */
public class NinteiChosaNyuryokuDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2017-02-23_06-32-36">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("radUpdateKind")
    private RadioButton radUpdateKind;
    @JsonProperty("ChosaTaisho")
    private ChosaTaishoDiv ChosaTaisho;
    @JsonProperty("ChosaJisshisha")
    private ChosaJisshishaDiv ChosaJisshisha;
    @JsonProperty("tabChosaShurui")
    private tabChosaShuruiDiv tabChosaShurui;
    @JsonProperty("btnClear")
    private Button btnClear;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getradUpdateKind
     * @return radUpdateKind
     */
    @JsonProperty("radUpdateKind")
    public RadioButton getRadUpdateKind() {
        return radUpdateKind;
    }

    /*
     * setradUpdateKind
     * @param radUpdateKind radUpdateKind
     */
    @JsonProperty("radUpdateKind")
    public void setRadUpdateKind(RadioButton radUpdateKind) {
        this.radUpdateKind = radUpdateKind;
    }

    /*
     * getChosaTaisho
     * @return ChosaTaisho
     */
    @JsonProperty("ChosaTaisho")
    public ChosaTaishoDiv getChosaTaisho() {
        return ChosaTaisho;
    }

    /*
     * setChosaTaisho
     * @param ChosaTaisho ChosaTaisho
     */
    @JsonProperty("ChosaTaisho")
    public void setChosaTaisho(ChosaTaishoDiv ChosaTaisho) {
        this.ChosaTaisho = ChosaTaisho;
    }

    /*
     * getChosaJisshisha
     * @return ChosaJisshisha
     */
    @JsonProperty("ChosaJisshisha")
    public ChosaJisshishaDiv getChosaJisshisha() {
        return ChosaJisshisha;
    }

    /*
     * setChosaJisshisha
     * @param ChosaJisshisha ChosaJisshisha
     */
    @JsonProperty("ChosaJisshisha")
    public void setChosaJisshisha(ChosaJisshishaDiv ChosaJisshisha) {
        this.ChosaJisshisha = ChosaJisshisha;
    }

    /*
     * gettabChosaShurui
     * @return tabChosaShurui
     */
    @JsonProperty("tabChosaShurui")
    public tabChosaShuruiDiv getTabChosaShurui() {
        return tabChosaShurui;
    }

    /*
     * settabChosaShurui
     * @param tabChosaShurui tabChosaShurui
     */
    @JsonProperty("tabChosaShurui")
    public void setTabChosaShurui(tabChosaShuruiDiv tabChosaShurui) {
        this.tabChosaShurui = tabChosaShurui;
    }

    /*
     * getbtnClear
     * @return btnClear
     */
    @JsonProperty("btnClear")
    public Button getBtnClear() {
        return btnClear;
    }

    /*
     * setbtnClear
     * @param btnClear btnClear
     */
    @JsonProperty("btnClear")
    public void setBtnClear(Button btnClear) {
        this.btnClear = btnClear;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public INinteiShinseiRenrakusakiKihonDiv getCcdNinteiShinseiRenrakusakiKihon() {
        return this.getChosaTaisho().getCcdNinteiShinseiRenrakusakiKihon();
    }

    @JsonIgnore
    public INinteiShinseishaKihonInfoDiv getCcdNinteiShinseishaKihonInfo() {
        return this.getChosaTaisho().getCcdNinteiShinseishaKihonInfo();
    }

    @JsonIgnore
    public IChosaJisshishaJohoDiv getCcdChosaJisshishaJoho() {
        return this.getChosaJisshisha().getCcdChosaJisshishaJoho();
    }

    @JsonIgnore
    public tplGaikyoChosaDiv getTplGaikyoChosa() {
        return this.getTabChosaShurui().getTplGaikyoChosa();
    }

    @JsonIgnore
    public void  setTplGaikyoChosa(tplGaikyoChosaDiv tplGaikyoChosa) {
        this.getTabChosaShurui().setTplGaikyoChosa(tplGaikyoChosa);
    }

    @JsonIgnore
    public RadioButton getRadGenzaiservis() {
        return this.getTabChosaShurui().getTplGaikyoChosa().getRadGenzaiservis();
    }

    @JsonIgnore
    public void  setRadGenzaiservis(RadioButton radGenzaiservis) {
        this.getTabChosaShurui().getTplGaikyoChosa().setRadGenzaiservis(radGenzaiservis);
    }

    @JsonIgnore
    public tabChosaBashoDiv getTabChosaBasho() {
        return this.getTabChosaShurui().getTplGaikyoChosa().getTabChosaBasho();
    }

    @JsonIgnore
    public void  setTabChosaBasho(tabChosaBashoDiv tabChosaBasho) {
        this.getTabChosaShurui().getTplGaikyoChosa().setTabChosaBasho(tabChosaBasho);
    }

    @JsonIgnore
    public tplZaitakuDiv getTplZaitaku() {
        return this.getTabChosaShurui().getTplGaikyoChosa().getTabChosaBasho().getTplZaitaku();
    }

    @JsonIgnore
    public void  setTplZaitaku(tplZaitakuDiv tplZaitaku) {
        this.getTabChosaShurui().getTplGaikyoChosa().getTabChosaBasho().setTplZaitaku(tplZaitaku);
    }

    @JsonIgnore
    public RadioButton getRadJutakuKaishu() {
        return this.getTabChosaShurui().getTplGaikyoChosa().getTabChosaBasho().getTplZaitaku().getRadJutakuKaishu();
    }

    @JsonIgnore
    public void  setRadJutakuKaishu(RadioButton radJutakuKaishu) {
        this.getTabChosaShurui().getTplGaikyoChosa().getTabChosaBasho().getTplZaitaku().setRadJutakuKaishu(radJutakuKaishu);
    }

    @JsonIgnore
    public JutakuGaikyoChosaDiv getJutakuGaikyoChosa() {
        return this.getTabChosaShurui().getTplGaikyoChosa().getTabChosaBasho().getTplZaitaku().getJutakuGaikyoChosa();
    }

    @JsonIgnore
    public void  setJutakuGaikyoChosa(JutakuGaikyoChosaDiv JutakuGaikyoChosa) {
        this.getTabChosaShurui().getTplGaikyoChosa().getTabChosaBasho().getTplZaitaku().setJutakuGaikyoChosa(JutakuGaikyoChosa);
    }

    @JsonIgnore
    public DataGrid<dgRiyoServiceJyokyo_Row> getDgRiyoServiceJyokyo() {
        return this.getTabChosaShurui().getTplGaikyoChosa().getTabChosaBasho().getTplZaitaku().getJutakuGaikyoChosa().getDgRiyoServiceJyokyo();
    }

    @JsonIgnore
    public void  setDgRiyoServiceJyokyo(DataGrid<dgRiyoServiceJyokyo_Row> dgRiyoServiceJyokyo) {
        this.getTabChosaShurui().getTplGaikyoChosa().getTabChosaBasho().getTplZaitaku().getJutakuGaikyoChosa().setDgRiyoServiceJyokyo(dgRiyoServiceJyokyo);
    }

    @JsonIgnore
    public ShichosonTokubetsuKyufuDiv getShichosonTokubetsuKyufu() {
        return this.getTabChosaShurui().getTplGaikyoChosa().getTabChosaBasho().getTplZaitaku().getShichosonTokubetsuKyufu();
    }

    @JsonIgnore
    public void  setShichosonTokubetsuKyufu(ShichosonTokubetsuKyufuDiv ShichosonTokubetsuKyufu) {
        this.getTabChosaShurui().getTplGaikyoChosa().getTabChosaBasho().getTplZaitaku().setShichosonTokubetsuKyufu(ShichosonTokubetsuKyufu);
    }

    @JsonIgnore
    public Label getLblShichosonTokubetsuKyufu() {
        return this.getTabChosaShurui().getTplGaikyoChosa().getTabChosaBasho().getTplZaitaku().getShichosonTokubetsuKyufu().getLblShichosonTokubetsuKyufu();
    }

    @JsonIgnore
    public void  setLblShichosonTokubetsuKyufu(Label lblShichosonTokubetsuKyufu) {
        this.getTabChosaShurui().getTplGaikyoChosa().getTabChosaBasho().getTplZaitaku().getShichosonTokubetsuKyufu().setLblShichosonTokubetsuKyufu(lblShichosonTokubetsuKyufu);
    }

    @JsonIgnore
    public DynamicImage getImgShichosonTokubetsuKyufu() {
        return this.getTabChosaShurui().getTplGaikyoChosa().getTabChosaBasho().getTplZaitaku().getShichosonTokubetsuKyufu().getImgShichosonTokubetsuKyufu();
    }

    @JsonIgnore
    public void  setImgShichosonTokubetsuKyufu(DynamicImage imgShichosonTokubetsuKyufu) {
        this.getTabChosaShurui().getTplGaikyoChosa().getTabChosaBasho().getTplZaitaku().getShichosonTokubetsuKyufu().setImgShichosonTokubetsuKyufu(imgShichosonTokubetsuKyufu);
    }

    @JsonIgnore
    public TextBoxMultiLine getTxtShichosonTokubetsuKyufu() {
        return this.getTabChosaShurui().getTplGaikyoChosa().getTabChosaBasho().getTplZaitaku().getTxtShichosonTokubetsuKyufu();
    }

    @JsonIgnore
    public void  setTxtShichosonTokubetsuKyufu(TextBoxMultiLine txtShichosonTokubetsuKyufu) {
        this.getTabChosaShurui().getTplGaikyoChosa().getTabChosaBasho().getTplZaitaku().setTxtShichosonTokubetsuKyufu(txtShichosonTokubetsuKyufu);
    }

    @JsonIgnore
    public TextBoxMultiLine getTxtKyufuIgaiJutakuService() {
        return this.getTabChosaShurui().getTplGaikyoChosa().getTabChosaBasho().getTplZaitaku().getTxtKyufuIgaiJutakuService();
    }

    @JsonIgnore
    public void  setTxtKyufuIgaiJutakuService(TextBoxMultiLine txtKyufuIgaiJutakuService) {
        this.getTabChosaShurui().getTplGaikyoChosa().getTabChosaBasho().getTplZaitaku().setTxtKyufuIgaiJutakuService(txtKyufuIgaiJutakuService);
    }

    @JsonIgnore
    public ZaitakuServiceDiv getZaitakuService() {
        return this.getTabChosaShurui().getTplGaikyoChosa().getTabChosaBasho().getTplZaitaku().getZaitakuService();
    }

    @JsonIgnore
    public void  setZaitakuService(ZaitakuServiceDiv ZaitakuService) {
        this.getTabChosaShurui().getTplGaikyoChosa().getTabChosaBasho().getTplZaitaku().setZaitakuService(ZaitakuService);
    }

    @JsonIgnore
    public Label getLblZaitakuService() {
        return this.getTabChosaShurui().getTplGaikyoChosa().getTabChosaBasho().getTplZaitaku().getZaitakuService().getLblZaitakuService();
    }

    @JsonIgnore
    public void  setLblZaitakuService(Label lblZaitakuService) {
        this.getTabChosaShurui().getTplGaikyoChosa().getTabChosaBasho().getTplZaitaku().getZaitakuService().setLblZaitakuService(lblZaitakuService);
    }

    @JsonIgnore
    public DynamicImage getImgZaitakuService() {
        return this.getTabChosaShurui().getTplGaikyoChosa().getTabChosaBasho().getTplZaitaku().getZaitakuService().getImgZaitakuService();
    }

    @JsonIgnore
    public void  setImgZaitakuService(DynamicImage imgZaitakuService) {
        this.getTabChosaShurui().getTplGaikyoChosa().getTabChosaBasho().getTplZaitaku().getZaitakuService().setImgZaitakuService(imgZaitakuService);
    }

    @JsonIgnore
    public tplShisetsuDiv getTplShisetsu() {
        return this.getTabChosaShurui().getTplGaikyoChosa().getTabChosaBasho().getTplShisetsu();
    }

    @JsonIgnore
    public void  setTplShisetsu(tplShisetsuDiv tplShisetsu) {
        this.getTabChosaShurui().getTplGaikyoChosa().getTabChosaBasho().setTplShisetsu(tplShisetsu);
    }

    @JsonIgnore
    public GaikyoTokkiShisetsuDiv getGaikyoTokkiShisetsu() {
        return this.getTabChosaShurui().getTplGaikyoChosa().getTabChosaBasho().getTplShisetsu().getGaikyoTokkiShisetsu();
    }

    @JsonIgnore
    public void  setGaikyoTokkiShisetsu(GaikyoTokkiShisetsuDiv GaikyoTokkiShisetsu) {
        this.getTabChosaShurui().getTplGaikyoChosa().getTabChosaBasho().getTplShisetsu().setGaikyoTokkiShisetsu(GaikyoTokkiShisetsu);
    }

    @JsonIgnore
    public DataGrid<dgRiyoShisetsu_Row> getDgRiyoShisetsu() {
        return this.getTabChosaShurui().getTplGaikyoChosa().getTabChosaBasho().getTplShisetsu().getGaikyoTokkiShisetsu().getDgRiyoShisetsu();
    }

    @JsonIgnore
    public void  setDgRiyoShisetsu(DataGrid<dgRiyoShisetsu_Row> dgRiyoShisetsu) {
        this.getTabChosaShurui().getTplGaikyoChosa().getTabChosaBasho().getTplShisetsu().getGaikyoTokkiShisetsu().setDgRiyoShisetsu(dgRiyoShisetsu);
    }

    @JsonIgnore
    public GaigyoShisetsuRenrakusakiDiv getGaigyoShisetsuRenrakusaki() {
        return this.getTabChosaShurui().getTplGaikyoChosa().getTabChosaBasho().getTplShisetsu().getGaigyoShisetsuRenrakusaki();
    }

    @JsonIgnore
    public void  setGaigyoShisetsuRenrakusaki(GaigyoShisetsuRenrakusakiDiv GaigyoShisetsuRenrakusaki) {
        this.getTabChosaShurui().getTplGaikyoChosa().getTabChosaBasho().getTplShisetsu().setGaigyoShisetsuRenrakusaki(GaigyoShisetsuRenrakusaki);
    }

    @JsonIgnore
    public TextBox getTxtShisetsuMeisdho() {
        return this.getTabChosaShurui().getTplGaikyoChosa().getTabChosaBasho().getTplShisetsu().getGaigyoShisetsuRenrakusaki().getTxtShisetsuMeisdho();
    }

    @JsonIgnore
    public void  setTxtShisetsuMeisdho(TextBox txtShisetsuMeisdho) {
        this.getTabChosaShurui().getTplGaikyoChosa().getTabChosaBasho().getTplShisetsu().getGaigyoShisetsuRenrakusaki().setTxtShisetsuMeisdho(txtShisetsuMeisdho);
    }

    @JsonIgnore
    public TextBoxYubinNo getTxtShisetsuYubinNo() {
        return this.getTabChosaShurui().getTplGaikyoChosa().getTabChosaBasho().getTplShisetsu().getGaigyoShisetsuRenrakusaki().getTxtShisetsuYubinNo();
    }

    @JsonIgnore
    public void  setTxtShisetsuYubinNo(TextBoxYubinNo txtShisetsuYubinNo) {
        this.getTabChosaShurui().getTplGaikyoChosa().getTabChosaBasho().getTplShisetsu().getGaigyoShisetsuRenrakusaki().setTxtShisetsuYubinNo(txtShisetsuYubinNo);
    }

    @JsonIgnore
    public TextBoxJusho getTxtShisetsuJusho() {
        return this.getTabChosaShurui().getTplGaikyoChosa().getTabChosaBasho().getTplShisetsu().getGaigyoShisetsuRenrakusaki().getTxtShisetsuJusho();
    }

    @JsonIgnore
    public void  setTxtShisetsuJusho(TextBoxJusho txtShisetsuJusho) {
        this.getTabChosaShurui().getTplGaikyoChosa().getTabChosaBasho().getTplShisetsu().getGaigyoShisetsuRenrakusaki().setTxtShisetsuJusho(txtShisetsuJusho);
    }

    @JsonIgnore
    public TextBoxTelNo getTxtTelNo() {
        return this.getTabChosaShurui().getTplGaikyoChosa().getTabChosaBasho().getTplShisetsu().getGaigyoShisetsuRenrakusaki().getTxtTelNo();
    }

    @JsonIgnore
    public void  setTxtTelNo(TextBoxTelNo txtTelNo) {
        this.getTabChosaShurui().getTplGaikyoChosa().getTabChosaBasho().getTplShisetsu().getGaigyoShisetsuRenrakusaki().setTxtTelNo(txtTelNo);
    }

    @JsonIgnore
    public ImageGaigyoShisetsuRenrakusakiDiv getImageGaigyoShisetsuRenrakusaki() {
        return this.getTabChosaShurui().getTplGaikyoChosa().getTabChosaBasho().getTplShisetsu().getImageGaigyoShisetsuRenrakusaki();
    }

    @JsonIgnore
    public void  setImageGaigyoShisetsuRenrakusaki(ImageGaigyoShisetsuRenrakusakiDiv ImageGaigyoShisetsuRenrakusaki) {
        this.getTabChosaShurui().getTplGaikyoChosa().getTabChosaBasho().getTplShisetsu().setImageGaigyoShisetsuRenrakusaki(ImageGaigyoShisetsuRenrakusaki);
    }

    @JsonIgnore
    public Label getLblShisetsuMeisho() {
        return this.getTabChosaShurui().getTplGaikyoChosa().getTabChosaBasho().getTplShisetsu().getImageGaigyoShisetsuRenrakusaki().getLblShisetsuMeisho();
    }

    @JsonIgnore
    public void  setLblShisetsuMeisho(Label lblShisetsuMeisho) {
        this.getTabChosaShurui().getTplGaikyoChosa().getTabChosaBasho().getTplShisetsu().getImageGaigyoShisetsuRenrakusaki().setLblShisetsuMeisho(lblShisetsuMeisho);
    }

    @JsonIgnore
    public DynamicImage getImgShisetsuMeisho() {
        return this.getTabChosaShurui().getTplGaikyoChosa().getTabChosaBasho().getTplShisetsu().getImageGaigyoShisetsuRenrakusaki().getImgShisetsuMeisho();
    }

    @JsonIgnore
    public void  setImgShisetsuMeisho(DynamicImage imgShisetsuMeisho) {
        this.getTabChosaShurui().getTplGaikyoChosa().getTabChosaBasho().getTplShisetsu().getImageGaigyoShisetsuRenrakusaki().setImgShisetsuMeisho(imgShisetsuMeisho);
    }

    @JsonIgnore
    public Label getLblJusho() {
        return this.getTabChosaShurui().getTplGaikyoChosa().getTabChosaBasho().getTplShisetsu().getImageGaigyoShisetsuRenrakusaki().getLblJusho();
    }

    @JsonIgnore
    public void  setLblJusho(Label lblJusho) {
        this.getTabChosaShurui().getTplGaikyoChosa().getTabChosaBasho().getTplShisetsu().getImageGaigyoShisetsuRenrakusaki().setLblJusho(lblJusho);
    }

    @JsonIgnore
    public DynamicImage getImgJusho() {
        return this.getTabChosaShurui().getTplGaikyoChosa().getTabChosaBasho().getTplShisetsu().getImageGaigyoShisetsuRenrakusaki().getImgJusho();
    }

    @JsonIgnore
    public void  setImgJusho(DynamicImage imgJusho) {
        this.getTabChosaShurui().getTplGaikyoChosa().getTabChosaBasho().getTplShisetsu().getImageGaigyoShisetsuRenrakusaki().setImgJusho(imgJusho);
    }

    @JsonIgnore
    public Label getLbTel() {
        return this.getTabChosaShurui().getTplGaikyoChosa().getTabChosaBasho().getTplShisetsu().getImageGaigyoShisetsuRenrakusaki().getLbTel();
    }

    @JsonIgnore
    public void  setLbTel(Label lbTel) {
        this.getTabChosaShurui().getTplGaikyoChosa().getTabChosaBasho().getTplShisetsu().getImageGaigyoShisetsuRenrakusaki().setLbTel(lbTel);
    }

    @JsonIgnore
    public DynamicImage getImgTel() {
        return this.getTabChosaShurui().getTplGaikyoChosa().getTabChosaBasho().getTplShisetsu().getImageGaigyoShisetsuRenrakusaki().getImgTel();
    }

    @JsonIgnore
    public void  setImgTel(DynamicImage imgTel) {
        this.getTabChosaShurui().getTplGaikyoChosa().getTabChosaBasho().getTplShisetsu().getImageGaigyoShisetsuRenrakusaki().setImgTel(imgTel);
    }

    @JsonIgnore
    public GaikyoTokkiInputDiv getGaikyoTokkiInput() {
        return this.getTabChosaShurui().getTplGaikyoChosa().getGaikyoTokkiInput();
    }

    @JsonIgnore
    public void  setGaikyoTokkiInput(GaikyoTokkiInputDiv GaikyoTokkiInput) {
        this.getTabChosaShurui().getTplGaikyoChosa().setGaikyoTokkiInput(GaikyoTokkiInput);
    }

    @JsonIgnore
    public Label getLblGaigyoTokkiComment() {
        return this.getTabChosaShurui().getTplGaikyoChosa().getGaikyoTokkiInput().getLblGaigyoTokkiComment();
    }

    @JsonIgnore
    public void  setLblGaigyoTokkiComment(Label lblGaigyoTokkiComment) {
        this.getTabChosaShurui().getTplGaikyoChosa().getGaikyoTokkiInput().setLblGaigyoTokkiComment(lblGaigyoTokkiComment);
    }

    @JsonIgnore
    public TextBoxMultiLine getTxtGaikyoTokkiNyuroku() {
        return this.getTabChosaShurui().getTplGaikyoChosa().getGaikyoTokkiInput().getTxtGaikyoTokkiNyuroku();
    }

    @JsonIgnore
    public void  setTxtGaikyoTokkiNyuroku(TextBoxMultiLine txtGaikyoTokkiNyuroku) {
        this.getTabChosaShurui().getTplGaikyoChosa().getGaikyoTokkiInput().setTxtGaikyoTokkiNyuroku(txtGaikyoTokkiNyuroku);
    }

    @JsonIgnore
    public TokkiDiv getTokki() {
        return this.getTabChosaShurui().getTplGaikyoChosa().getGaikyoTokkiInput().getTokki();
    }

    @JsonIgnore
    public void  setTokki(TokkiDiv Tokki) {
        this.getTabChosaShurui().getTplGaikyoChosa().getGaikyoTokkiInput().setTokki(Tokki);
    }

    @JsonIgnore
    public DynamicImage getImgTokkiJiko() {
        return this.getTabChosaShurui().getTplGaikyoChosa().getGaikyoTokkiInput().getTokki().getImgTokkiJiko();
    }

    @JsonIgnore
    public void  setImgTokkiJiko(DynamicImage imgTokkiJiko) {
        this.getTabChosaShurui().getTplGaikyoChosa().getGaikyoTokkiInput().getTokki().setImgTokkiJiko(imgTokkiJiko);
    }

    @JsonIgnore
    public ButtonDialog getBtnTeikeibun() {
        return this.getTabChosaShurui().getTplGaikyoChosa().getGaikyoTokkiInput().getBtnTeikeibun();
    }

    @JsonIgnore
    public void  setBtnTeikeibun(ButtonDialog btnTeikeibun) {
        this.getTabChosaShurui().getTplGaikyoChosa().getGaikyoTokkiInput().setBtnTeikeibun(btnTeikeibun);
    }

    @JsonIgnore
    public tplKihonChosaDiv getTplKihonChosa() {
        return this.getTabChosaShurui().getTplKihonChosa();
    }

    @JsonIgnore
    public void  setTplKihonChosa(tplKihonChosaDiv tplKihonChosa) {
        this.getTabChosaShurui().setTplKihonChosa(tplKihonChosa);
    }

    @JsonIgnore
    public Button getBtnKiteichiSettei() {
        return this.getTabChosaShurui().getTplKihonChosa().getBtnKiteichiSettei();
    }

    @JsonIgnore
    public void  setBtnKiteichiSettei(Button btnKiteichiSettei) {
        this.getTabChosaShurui().getTplKihonChosa().setBtnKiteichiSettei(btnKiteichiSettei);
    }

    @JsonIgnore
    public Button getBtnZenkaiCopy() {
        return this.getTabChosaShurui().getTplKihonChosa().getBtnZenkaiCopy();
    }

    @JsonIgnore
    public void  setBtnZenkaiCopy(Button btnZenkaiCopy) {
        this.getTabChosaShurui().getTplKihonChosa().setBtnZenkaiCopy(btnZenkaiCopy);
    }

    @JsonIgnore
    public TextBox getTxtIchijiHanteiKekka() {
        return this.getTabChosaShurui().getTplKihonChosa().getTxtIchijiHanteiKekka();
    }

    @JsonIgnore
    public void  setTxtIchijiHanteiKekka(TextBox txtIchijiHanteiKekka) {
        this.getTabChosaShurui().getTplKihonChosa().setTxtIchijiHanteiKekka(txtIchijiHanteiKekka);
    }

    @JsonIgnore
    public ButtonDialog getBtnIchiHanteiJisshi() {
        return this.getTabChosaShurui().getTplKihonChosa().getBtnIchiHanteiJisshi();
    }

    @JsonIgnore
    public void  setBtnIchiHanteiJisshi(ButtonDialog btnIchiHanteiJisshi) {
        this.getTabChosaShurui().getTplKihonChosa().setBtnIchiHanteiJisshi(btnIchiHanteiJisshi);
    }

    @JsonIgnore
    public kihonchosaSelectDiv getKihonchosaSelect() {
        return this.getTabChosaShurui().getTplKihonChosa().getKihonchosaSelect();
    }

    @JsonIgnore
    public void  setKihonchosaSelect(kihonchosaSelectDiv kihonchosaSelect) {
        this.getTabChosaShurui().getTplKihonChosa().setKihonchosaSelect(kihonchosaSelect);
    }

    @JsonIgnore
    public ButtonDialog getBtnKihonchosa1() {
        return this.getTabChosaShurui().getTplKihonChosa().getKihonchosaSelect().getBtnKihonchosa1();
    }

    @JsonIgnore
    public void  setBtnKihonchosa1(ButtonDialog btnKihonchosa1) {
        this.getTabChosaShurui().getTplKihonChosa().getKihonchosaSelect().setBtnKihonchosa1(btnKihonchosa1);
    }

    @JsonIgnore
    public ButtonDialog getBtnKihonchosa2() {
        return this.getTabChosaShurui().getTplKihonChosa().getKihonchosaSelect().getBtnKihonchosa2();
    }

    @JsonIgnore
    public void  setBtnKihonchosa2(ButtonDialog btnKihonchosa2) {
        this.getTabChosaShurui().getTplKihonChosa().getKihonchosaSelect().setBtnKihonchosa2(btnKihonchosa2);
    }

    @JsonIgnore
    public ButtonDialog getBtnKihonchosa3() {
        return this.getTabChosaShurui().getTplKihonChosa().getKihonchosaSelect().getBtnKihonchosa3();
    }

    @JsonIgnore
    public void  setBtnKihonchosa3(ButtonDialog btnKihonchosa3) {
        this.getTabChosaShurui().getTplKihonChosa().getKihonchosaSelect().setBtnKihonchosa3(btnKihonchosa3);
    }

    @JsonIgnore
    public ButtonDialog getBtnKihonchosa4() {
        return this.getTabChosaShurui().getTplKihonChosa().getKihonchosaSelect().getBtnKihonchosa4();
    }

    @JsonIgnore
    public void  setBtnKihonchosa4(ButtonDialog btnKihonchosa4) {
        this.getTabChosaShurui().getTplKihonChosa().getKihonchosaSelect().setBtnKihonchosa4(btnKihonchosa4);
    }

    @JsonIgnore
    public ButtonDialog getBtnKihonchosa5() {
        return this.getTabChosaShurui().getTplKihonChosa().getKihonchosaSelect().getBtnKihonchosa5();
    }

    @JsonIgnore
    public void  setBtnKihonchosa5(ButtonDialog btnKihonchosa5) {
        this.getTabChosaShurui().getTplKihonChosa().getKihonchosaSelect().setBtnKihonchosa5(btnKihonchosa5);
    }

    @JsonIgnore
    public ButtonDialog getBtnKihonchosa6() {
        return this.getTabChosaShurui().getTplKihonChosa().getKihonchosaSelect().getBtnKihonchosa6();
    }

    @JsonIgnore
    public void  setBtnKihonchosa6(ButtonDialog btnKihonchosa6) {
        this.getTabChosaShurui().getTplKihonChosa().getKihonchosaSelect().setBtnKihonchosa6(btnKihonchosa6);
    }

    @JsonIgnore
    public ButtonDialog getBtnKihonchosa7() {
        return this.getTabChosaShurui().getTplKihonChosa().getKihonchosaSelect().getBtnKihonchosa7();
    }

    @JsonIgnore
    public void  setBtnKihonchosa7(ButtonDialog btnKihonchosa7) {
        this.getTabChosaShurui().getTplKihonChosa().getKihonchosaSelect().setBtnKihonchosa7(btnKihonchosa7);
    }

    @JsonIgnore
    public ButtonDialog getBtnTokkiJiko() {
        return this.getTabChosaShurui().getTplKihonChosa().getKihonchosaSelect().getBtnTokkiJiko();
    }

    @JsonIgnore
    public void  setBtnTokkiJiko(ButtonDialog btnTokkiJiko) {
        this.getTabChosaShurui().getTplKihonChosa().getKihonchosaSelect().setBtnTokkiJiko(btnTokkiJiko);
    }

    @JsonIgnore
    public ButtonDialog getBtnImageTokkiJiko() {
        return this.getTabChosaShurui().getTplKihonChosa().getKihonchosaSelect().getBtnImageTokkiJiko();
    }

    @JsonIgnore
    public void  setBtnImageTokkiJiko(ButtonDialog btnImageTokkiJiko) {
        this.getTabChosaShurui().getTplKihonChosa().getKihonchosaSelect().setBtnImageTokkiJiko(btnImageTokkiJiko);
    }

    // </editor-fold>
}
