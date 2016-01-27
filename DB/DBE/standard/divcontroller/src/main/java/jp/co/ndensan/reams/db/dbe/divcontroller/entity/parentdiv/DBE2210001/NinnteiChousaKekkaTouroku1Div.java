package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2210001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ChosaJisshishaJoho.ChosaJisshishaJoho.IChosaJisshishaJohoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.KaigoNinteiShinseishaInfo.KaigoNinteiShinseishaInfo.IKaigoNinteiShinseishaInfoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.KihonChosaInput.KihonChosaInput.IKihonChosaInputDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.NinteiShinseiRenrakusakiKihon.NinteiShinseiRenrakusakiKihon.INinteiShinseiRenrakusakiKihonDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.ui.binding.ButtonDialog;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGrid;
import jp.co.ndensan.reams.uz.uza.ui.binding.Label;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.RadioButton;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBox;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxMultiLine;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxYubinNo;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.TextBoxJusho;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.TextBoxTelNo;

/**
 * NinnteiChousaKekkaTouroku1 のクラスファイル
 *
 * @author 自動生成
 */
public class NinnteiChousaKekkaTouroku1Div extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2015-11-30_08-54-50">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("KanryoMessage")
    private KanryoMessageDiv KanryoMessage;
    @JsonProperty("NinteiChosaNyuryoku")
    private NinteiChosaNyuryokuDiv NinteiChosaNyuryoku;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getKanryoMessage
     * @return KanryoMessage
     */
    @JsonProperty("KanryoMessage")
    public KanryoMessageDiv getKanryoMessage() {
        return KanryoMessage;
    }

    /*
     * setKanryoMessage
     * @param KanryoMessage KanryoMessage
     */
    @JsonProperty("KanryoMessage")
    public void setKanryoMessage(KanryoMessageDiv KanryoMessage) {
        this.KanryoMessage = KanryoMessage;
    }

    /*
     * getNinteiChosaNyuryoku
     * @return NinteiChosaNyuryoku
     */
    @JsonProperty("NinteiChosaNyuryoku")
    public NinteiChosaNyuryokuDiv getNinteiChosaNyuryoku() {
        return NinteiChosaNyuryoku;
    }

    /*
     * setNinteiChosaNyuryoku
     * @param NinteiChosaNyuryoku NinteiChosaNyuryoku
     */
    @JsonProperty("NinteiChosaNyuryoku")
    public void setNinteiChosaNyuryoku(NinteiChosaNyuryokuDiv NinteiChosaNyuryoku) {
        this.NinteiChosaNyuryoku = NinteiChosaNyuryoku;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public ChosaTaishoDiv getChosaTaisho() {
        return this.getNinteiChosaNyuryoku().getChosaTaisho();
    }

    @JsonIgnore
    public void setChosaTaisho(ChosaTaishoDiv ChosaTaisho) {
        this.getNinteiChosaNyuryoku().setChosaTaisho(ChosaTaisho);
    }

    @JsonIgnore
    public INinteiShinseiRenrakusakiKihonDiv getCcdNinteiShinseiRenrakusakiKihon() {
        return this.getNinteiChosaNyuryoku().getChosaTaisho().getCcdNinteiShinseiRenrakusakiKihon();
    }

    @JsonIgnore
    public IKaigoNinteiShinseishaInfoDiv getCcdKaigoNinteiShinseishaInfo() {
        return this.getNinteiChosaNyuryoku().getChosaTaisho().getCcdKaigoNinteiShinseishaInfo();
    }

    @JsonIgnore
    public tabChosaShuruiDiv getTabChosaShurui() {
        return this.getNinteiChosaNyuryoku().getTabChosaShurui();
    }

    @JsonIgnore
    public void setTabChosaShurui(tabChosaShuruiDiv tabChosaShurui) {
        this.getNinteiChosaNyuryoku().setTabChosaShurui(tabChosaShurui);
    }

    @JsonIgnore
    public tplGaikyoChosaDiv getTplGaikyoChosa() {
        return this.getNinteiChosaNyuryoku().getTabChosaShurui().getTplGaikyoChosa();
    }

    @JsonIgnore
    public void setTplGaikyoChosa(tplGaikyoChosaDiv tplGaikyoChosa) {
        this.getNinteiChosaNyuryoku().getTabChosaShurui().setTplGaikyoChosa(tplGaikyoChosa);
    }

    @JsonIgnore
    public RadioButton getRadGenzaiservis() {
        return this.getNinteiChosaNyuryoku().getTabChosaShurui().getTplGaikyoChosa().getRadGenzaiservis();
    }

    @JsonIgnore
    public void setRadGenzaiservis(RadioButton radGenzaiservis) {
        this.getNinteiChosaNyuryoku().getTabChosaShurui().getTplGaikyoChosa().setRadGenzaiservis(radGenzaiservis);
    }

    @JsonIgnore
    public tabChosaBashoDiv getTabChosaBasho() {
        return this.getNinteiChosaNyuryoku().getTabChosaShurui().getTplGaikyoChosa().getTabChosaBasho();
    }

    @JsonIgnore
    public void setTabChosaBasho(tabChosaBashoDiv tabChosaBasho) {
        this.getNinteiChosaNyuryoku().getTabChosaShurui().getTplGaikyoChosa().setTabChosaBasho(tabChosaBasho);
    }

    @JsonIgnore
    public tplZaitakuDiv getTplZaitaku() {
        return this.getNinteiChosaNyuryoku().getTabChosaShurui().getTplGaikyoChosa().getTabChosaBasho().getTplZaitaku();
    }

    @JsonIgnore
    public void setTplZaitaku(tplZaitakuDiv tplZaitaku) {
        this.getNinteiChosaNyuryoku().getTabChosaShurui().getTplGaikyoChosa().getTabChosaBasho().setTplZaitaku(tplZaitaku);
    }

    @JsonIgnore
    public JutakuGaikyoChosaDiv getJutakuGaikyoChosa() {
        return this.getNinteiChosaNyuryoku().getTabChosaShurui().getTplGaikyoChosa().getTabChosaBasho().getTplZaitaku().getJutakuGaikyoChosa();
    }

    @JsonIgnore
    public void setJutakuGaikyoChosa(JutakuGaikyoChosaDiv JutakuGaikyoChosa) {
        this.getNinteiChosaNyuryoku().getTabChosaShurui().getTplGaikyoChosa().getTabChosaBasho().getTplZaitaku().setJutakuGaikyoChosa(JutakuGaikyoChosa);
    }

    @JsonIgnore
    public RadioButton getRadJutakuKaishu() {
        return this.getNinteiChosaNyuryoku().getTabChosaShurui().getTplGaikyoChosa().getTabChosaBasho().getTplZaitaku().getJutakuGaikyoChosa().getRadJutakuKaishu();
    }

    @JsonIgnore
    public void setRadJutakuKaishu(RadioButton radJutakuKaishu) {
        this.getNinteiChosaNyuryoku().getTabChosaShurui().getTplGaikyoChosa().getTabChosaBasho().getTplZaitaku().getJutakuGaikyoChosa().setRadJutakuKaishu(radJutakuKaishu);
    }

    @JsonIgnore
    public DataGrid<dgRiyoSerViceFirstHalf_Row> getDgRiyoSerViceFirstHalf() {
        return this.getNinteiChosaNyuryoku().getTabChosaShurui().getTplGaikyoChosa().getTabChosaBasho().getTplZaitaku().getJutakuGaikyoChosa().getDgRiyoSerViceFirstHalf();
    }

    @JsonIgnore
    public void setDgRiyoSerViceFirstHalf(DataGrid<dgRiyoSerViceFirstHalf_Row> dgRiyoSerViceFirstHalf) {
        this.getNinteiChosaNyuryoku().getTabChosaShurui().getTplGaikyoChosa().getTabChosaBasho().getTplZaitaku().getJutakuGaikyoChosa().setDgRiyoSerViceFirstHalf(dgRiyoSerViceFirstHalf);
    }

    @JsonIgnore
    public DataGrid<dgRiyoSerViceSecondHalf_Row> getDgRiyoSerViceSecondHalf() {
        return this.getNinteiChosaNyuryoku().getTabChosaShurui().getTplGaikyoChosa().getTabChosaBasho().getTplZaitaku().getJutakuGaikyoChosa().getDgRiyoSerViceSecondHalf();
    }

    @JsonIgnore
    public void setDgRiyoSerViceSecondHalf(DataGrid<dgRiyoSerViceSecondHalf_Row> dgRiyoSerViceSecondHalf) {
        this.getNinteiChosaNyuryoku().getTabChosaShurui().getTplGaikyoChosa().getTabChosaBasho().getTplZaitaku().getJutakuGaikyoChosa().setDgRiyoSerViceSecondHalf(dgRiyoSerViceSecondHalf);
    }

    @JsonIgnore
    public TextBox getTxtShichosonTokubetsuKyufu() {
        return this.getNinteiChosaNyuryoku().getTabChosaShurui().getTplGaikyoChosa().getTabChosaBasho().getTplZaitaku().getJutakuGaikyoChosa().getTxtShichosonTokubetsuKyufu();
    }

    @JsonIgnore
    public void setTxtShichosonTokubetsuKyufu(TextBox txtShichosonTokubetsuKyufu) {
        this.getNinteiChosaNyuryoku().getTabChosaShurui().getTplGaikyoChosa().getTabChosaBasho().getTplZaitaku().getJutakuGaikyoChosa().setTxtShichosonTokubetsuKyufu(txtShichosonTokubetsuKyufu);
    }

    @JsonIgnore
    public TextBox getTxtKyufuIgaiJutakuService() {
        return this.getNinteiChosaNyuryoku().getTabChosaShurui().getTplGaikyoChosa().getTabChosaBasho().getTplZaitaku().getJutakuGaikyoChosa().getTxtKyufuIgaiJutakuService();
    }

    @JsonIgnore
    public void setTxtKyufuIgaiJutakuService(TextBox txtKyufuIgaiJutakuService) {
        this.getNinteiChosaNyuryoku().getTabChosaShurui().getTplGaikyoChosa().getTabChosaBasho().getTplZaitaku().getJutakuGaikyoChosa().setTxtKyufuIgaiJutakuService(txtKyufuIgaiJutakuService);
    }

    @JsonIgnore
    public tplShisetsuDiv getTplShisetsu() {
        return this.getNinteiChosaNyuryoku().getTabChosaShurui().getTplGaikyoChosa().getTabChosaBasho().getTplShisetsu();
    }

    @JsonIgnore
    public void setTplShisetsu(tplShisetsuDiv tplShisetsu) {
        this.getNinteiChosaNyuryoku().getTabChosaShurui().getTplGaikyoChosa().getTabChosaBasho().setTplShisetsu(tplShisetsu);
    }

    @JsonIgnore
    public GaikyoTokkiShisetsuDiv getGaikyoTokkiShisetsu() {
        return this.getNinteiChosaNyuryoku().getTabChosaShurui().getTplGaikyoChosa().getTabChosaBasho().getTplShisetsu().getGaikyoTokkiShisetsu();
    }

    @JsonIgnore
    public void setGaikyoTokkiShisetsu(GaikyoTokkiShisetsuDiv GaikyoTokkiShisetsu) {
        this.getNinteiChosaNyuryoku().getTabChosaShurui().getTplGaikyoChosa().getTabChosaBasho().getTplShisetsu().setGaikyoTokkiShisetsu(GaikyoTokkiShisetsu);
    }

    @JsonIgnore
    public DataGrid<dgRiyoShisetsu_Row> getDgRiyoShisetsu() {
        return this.getNinteiChosaNyuryoku().getTabChosaShurui().getTplGaikyoChosa().getTabChosaBasho().getTplShisetsu().getGaikyoTokkiShisetsu().getDgRiyoShisetsu();
    }

    @JsonIgnore
    public void setDgRiyoShisetsu(DataGrid<dgRiyoShisetsu_Row> dgRiyoShisetsu) {
        this.getNinteiChosaNyuryoku().getTabChosaShurui().getTplGaikyoChosa().getTabChosaBasho().getTplShisetsu().getGaikyoTokkiShisetsu().setDgRiyoShisetsu(dgRiyoShisetsu);
    }

    @JsonIgnore
    public GaigyoShisetsuRenrakusakiDiv getGaigyoShisetsuRenrakusaki() {
        return this.getNinteiChosaNyuryoku().getTabChosaShurui().getTplGaikyoChosa().getTabChosaBasho().getTplShisetsu().getGaigyoShisetsuRenrakusaki();
    }

    @JsonIgnore
    public void setGaigyoShisetsuRenrakusaki(GaigyoShisetsuRenrakusakiDiv GaigyoShisetsuRenrakusaki) {
        this.getNinteiChosaNyuryoku().getTabChosaShurui().getTplGaikyoChosa().getTabChosaBasho().getTplShisetsu().setGaigyoShisetsuRenrakusaki(GaigyoShisetsuRenrakusaki);
    }

    @JsonIgnore
    public TextBox getTxtShisetsuMeisdho() {
        return this.getNinteiChosaNyuryoku().getTabChosaShurui().getTplGaikyoChosa().getTabChosaBasho().getTplShisetsu().getGaigyoShisetsuRenrakusaki().getTxtShisetsuMeisdho();
    }

    @JsonIgnore
    public void setTxtShisetsuMeisdho(TextBox txtShisetsuMeisdho) {
        this.getNinteiChosaNyuryoku().getTabChosaShurui().getTplGaikyoChosa().getTabChosaBasho().getTplShisetsu().getGaigyoShisetsuRenrakusaki().setTxtShisetsuMeisdho(txtShisetsuMeisdho);
    }

    @JsonIgnore
    public TextBoxYubinNo getTxtShisetsuYubinNo() {
        return this.getNinteiChosaNyuryoku().getTabChosaShurui().getTplGaikyoChosa().getTabChosaBasho().getTplShisetsu().getGaigyoShisetsuRenrakusaki().getTxtShisetsuYubinNo();
    }

    @JsonIgnore
    public void setTxtShisetsuYubinNo(TextBoxYubinNo txtShisetsuYubinNo) {
        this.getNinteiChosaNyuryoku().getTabChosaShurui().getTplGaikyoChosa().getTabChosaBasho().getTplShisetsu().getGaigyoShisetsuRenrakusaki().setTxtShisetsuYubinNo(txtShisetsuYubinNo);
    }

    @JsonIgnore
    public TextBoxJusho getTxtShisetsuJusho() {
        return this.getNinteiChosaNyuryoku().getTabChosaShurui().getTplGaikyoChosa().getTabChosaBasho().getTplShisetsu().getGaigyoShisetsuRenrakusaki().getTxtShisetsuJusho();
    }

    @JsonIgnore
    public void setTxtShisetsuJusho(TextBoxJusho txtShisetsuJusho) {
        this.getNinteiChosaNyuryoku().getTabChosaShurui().getTplGaikyoChosa().getTabChosaBasho().getTplShisetsu().getGaigyoShisetsuRenrakusaki().setTxtShisetsuJusho(txtShisetsuJusho);
    }

    @JsonIgnore
    public TextBoxTelNo getTxtTelNo() {
        return this.getNinteiChosaNyuryoku().getTabChosaShurui().getTplGaikyoChosa().getTabChosaBasho().getTplShisetsu().getGaigyoShisetsuRenrakusaki().getTxtTelNo();
    }

    @JsonIgnore
    public void setTxtTelNo(TextBoxTelNo txtTelNo) {
        this.getNinteiChosaNyuryoku().getTabChosaShurui().getTplGaikyoChosa().getTabChosaBasho().getTplShisetsu().getGaigyoShisetsuRenrakusaki().setTxtTelNo(txtTelNo);
    }

    @JsonIgnore
    public GaikyoTokkiInputDiv getGaikyoTokkiInput() {
        return this.getNinteiChosaNyuryoku().getTabChosaShurui().getTplGaikyoChosa().getGaikyoTokkiInput();
    }

    @JsonIgnore
    public void setGaikyoTokkiInput(GaikyoTokkiInputDiv GaikyoTokkiInput) {
        this.getNinteiChosaNyuryoku().getTabChosaShurui().getTplGaikyoChosa().setGaikyoTokkiInput(GaikyoTokkiInput);
    }

    @JsonIgnore
    public Label getLblGaigyoTokkiComment() {
        return this.getNinteiChosaNyuryoku().getTabChosaShurui().getTplGaikyoChosa().getGaikyoTokkiInput().getLblGaigyoTokkiComment();
    }

    @JsonIgnore
    public void setLblGaigyoTokkiComment(Label lblGaigyoTokkiComment) {
        this.getNinteiChosaNyuryoku().getTabChosaShurui().getTplGaikyoChosa().getGaikyoTokkiInput().setLblGaigyoTokkiComment(lblGaigyoTokkiComment);
    }

    @JsonIgnore
    public TextBoxMultiLine getTxtGaikyoTokkiNyuroku() {
        return this.getNinteiChosaNyuryoku().getTabChosaShurui().getTplGaikyoChosa().getGaikyoTokkiInput().getTxtGaikyoTokkiNyuroku();
    }

    @JsonIgnore
    public void setTxtGaikyoTokkiNyuroku(TextBoxMultiLine txtGaikyoTokkiNyuroku) {
        this.getNinteiChosaNyuryoku().getTabChosaShurui().getTplGaikyoChosa().getGaikyoTokkiInput().setTxtGaikyoTokkiNyuroku(txtGaikyoTokkiNyuroku);
    }

    @JsonIgnore
    public ButtonDialog getBtnTeikeibun() {
        return this.getNinteiChosaNyuryoku().getTabChosaShurui().getTplGaikyoChosa().getGaikyoTokkiInput().getBtnTeikeibun();
    }

    @JsonIgnore
    public void setBtnTeikeibun(ButtonDialog btnTeikeibun) {
        this.getNinteiChosaNyuryoku().getTabChosaShurui().getTplGaikyoChosa().getGaikyoTokkiInput().setBtnTeikeibun(btnTeikeibun);
    }

    @JsonIgnore
    public tplKihonChosaDiv getTplKihonChosa() {
        return this.getNinteiChosaNyuryoku().getTabChosaShurui().getTplKihonChosa();
    }

    @JsonIgnore
    public void setTplKihonChosa(tplKihonChosaDiv tplKihonChosa) {
        this.getNinteiChosaNyuryoku().getTabChosaShurui().setTplKihonChosa(tplKihonChosa);
    }

    @JsonIgnore
    public Button getBtnKiteichiSettei() {
        return this.getNinteiChosaNyuryoku().getTabChosaShurui().getTplKihonChosa().getBtnKiteichiSettei();
    }

    @JsonIgnore
    public void setBtnKiteichiSettei(Button btnKiteichiSettei) {
        this.getNinteiChosaNyuryoku().getTabChosaShurui().getTplKihonChosa().setBtnKiteichiSettei(btnKiteichiSettei);
    }

    @JsonIgnore
    public Button getBtnZenkaiCopy() {
        return this.getNinteiChosaNyuryoku().getTabChosaShurui().getTplKihonChosa().getBtnZenkaiCopy();
    }

    @JsonIgnore
    public void setBtnZenkaiCopy(Button btnZenkaiCopy) {
        this.getNinteiChosaNyuryoku().getTabChosaShurui().getTplKihonChosa().setBtnZenkaiCopy(btnZenkaiCopy);
    }

    @JsonIgnore
    public TextBox getTxtIchijiHanteiKekka() {
        return this.getNinteiChosaNyuryoku().getTabChosaShurui().getTplKihonChosa().getTxtIchijiHanteiKekka();
    }

    @JsonIgnore
    public void setTxtIchijiHanteiKekka(TextBox txtIchijiHanteiKekka) {
        this.getNinteiChosaNyuryoku().getTabChosaShurui().getTplKihonChosa().setTxtIchijiHanteiKekka(txtIchijiHanteiKekka);
    }

    @JsonIgnore
    public Button getBtnIchiHanteiJisshi() {
        return this.getNinteiChosaNyuryoku().getTabChosaShurui().getTplKihonChosa().getBtnIchiHanteiJisshi();
    }

    @JsonIgnore
    public void setBtnIchiHanteiJisshi(Button btnIchiHanteiJisshi) {
        this.getNinteiChosaNyuryoku().getTabChosaShurui().getTplKihonChosa().setBtnIchiHanteiJisshi(btnIchiHanteiJisshi);
    }

    @JsonIgnore
    public tabKihonChosaShuruiDiv getTabKihonChosaShurui() {
        return this.getNinteiChosaNyuryoku().getTabChosaShurui().getTplKihonChosa().getTabKihonChosaShurui();
    }

    @JsonIgnore
    public void setTabKihonChosaShurui(tabKihonChosaShuruiDiv tabKihonChosaShurui) {
        this.getNinteiChosaNyuryoku().getTabChosaShurui().getTplKihonChosa().setTabKihonChosaShurui(tabKihonChosaShurui);
    }

    @JsonIgnore
    public tplIchigunDiv getTplIchigun() {
        return this.getNinteiChosaNyuryoku().getTabChosaShurui().getTplKihonChosa().getTabKihonChosaShurui().getTplIchigun();
    }

    @JsonIgnore
    public void setTplIchigun(tplIchigunDiv tplIchigun) {
        this.getNinteiChosaNyuryoku().getTabChosaShurui().getTplKihonChosa().getTabKihonChosaShurui().setTplIchigun(tplIchigun);
    }

    @JsonIgnore
    public IKihonChosaInputDiv getCcdIchigunKihonChosa() {
        return this.getNinteiChosaNyuryoku().getTabChosaShurui().getTplKihonChosa().getTabKihonChosaShurui().getTplIchigun().getCcdIchigunKihonChosa();
    }

    @JsonIgnore
    public tplNigunDiv getTplNigun() {
        return this.getNinteiChosaNyuryoku().getTabChosaShurui().getTplKihonChosa().getTabKihonChosaShurui().getTplNigun();
    }

    @JsonIgnore
    public void setTplNigun(tplNigunDiv tplNigun) {
        this.getNinteiChosaNyuryoku().getTabChosaShurui().getTplKihonChosa().getTabKihonChosaShurui().setTplNigun(tplNigun);
    }

    @JsonIgnore
    public IKihonChosaInputDiv getCcdNigunKihonChosa() {
        return this.getNinteiChosaNyuryoku().getTabChosaShurui().getTplKihonChosa().getTabKihonChosaShurui().getTplNigun().getCcdNigunKihonChosa();
    }

    @JsonIgnore
    public tplSangunDiv getTplSangun() {
        return this.getNinteiChosaNyuryoku().getTabChosaShurui().getTplKihonChosa().getTabKihonChosaShurui().getTplSangun();
    }

    @JsonIgnore
    public void setTplSangun(tplSangunDiv tplSangun) {
        this.getNinteiChosaNyuryoku().getTabChosaShurui().getTplKihonChosa().getTabKihonChosaShurui().setTplSangun(tplSangun);
    }

    @JsonIgnore
    public IKihonChosaInputDiv getCcdSangunKihonChosa() {
        return this.getNinteiChosaNyuryoku().getTabChosaShurui().getTplKihonChosa().getTabKihonChosaShurui().getTplSangun().getCcdSangunKihonChosa();
    }

    @JsonIgnore
    public tplYongunDiv getTplYongun() {
        return this.getNinteiChosaNyuryoku().getTabChosaShurui().getTplKihonChosa().getTabKihonChosaShurui().getTplYongun();
    }

    @JsonIgnore
    public void setTplYongun(tplYongunDiv tplYongun) {
        this.getNinteiChosaNyuryoku().getTabChosaShurui().getTplKihonChosa().getTabKihonChosaShurui().setTplYongun(tplYongun);
    }

    @JsonIgnore
    public IKihonChosaInputDiv getCcdYongunKihonChosa() {
        return this.getNinteiChosaNyuryoku().getTabChosaShurui().getTplKihonChosa().getTabKihonChosaShurui().getTplYongun().getCcdYongunKihonChosa();
    }

    @JsonIgnore
    public tplGogunDiv getTplGogun() {
        return this.getNinteiChosaNyuryoku().getTabChosaShurui().getTplKihonChosa().getTabKihonChosaShurui().getTplGogun();
    }

    @JsonIgnore
    public void setTplGogun(tplGogunDiv tplGogun) {
        this.getNinteiChosaNyuryoku().getTabChosaShurui().getTplKihonChosa().getTabKihonChosaShurui().setTplGogun(tplGogun);
    }

    @JsonIgnore
    public IKihonChosaInputDiv getCcdGogun() {
        return this.getNinteiChosaNyuryoku().getTabChosaShurui().getTplKihonChosa().getTabKihonChosaShurui().getTplGogun().getCcdGogun();
    }

    @JsonIgnore
    public tplTokubetsuIryoDiv getTplTokubetsuIryo() {
        return this.getNinteiChosaNyuryoku().getTabChosaShurui().getTplKihonChosa().getTabKihonChosaShurui().getTplTokubetsuIryo();
    }

    @JsonIgnore
    public void setTplTokubetsuIryo(tplTokubetsuIryoDiv tplTokubetsuIryo) {
        this.getNinteiChosaNyuryoku().getTabChosaShurui().getTplKihonChosa().getTabKihonChosaShurui().setTplTokubetsuIryo(tplTokubetsuIryo);
    }

    @JsonIgnore
    public IKihonChosaInputDiv getCcdTokubetsuIryoKihonChosa() {
        return this.getNinteiChosaNyuryoku().getTabChosaShurui().getTplKihonChosa().getTabKihonChosaShurui().getTplTokubetsuIryo().getCcdTokubetsuIryoKihonChosa();
    }

    @JsonIgnore
    public tplSeikatsuJiritsudoDiv getTplSeikatsuJiritsudo() {
        return this.getNinteiChosaNyuryoku().getTabChosaShurui().getTplKihonChosa().getTabKihonChosaShurui().getTplSeikatsuJiritsudo();
    }

    @JsonIgnore
    public void setTplSeikatsuJiritsudo(tplSeikatsuJiritsudoDiv tplSeikatsuJiritsudo) {
        this.getNinteiChosaNyuryoku().getTabChosaShurui().getTplKihonChosa().getTabKihonChosaShurui().setTplSeikatsuJiritsudo(tplSeikatsuJiritsudo);
    }

    @JsonIgnore
    public IKihonChosaInputDiv getCcdSeikatsuJiritsudoKihonchosa() {
        return this.getNinteiChosaNyuryoku().getTabChosaShurui().getTplKihonChosa().getTabKihonChosaShurui().getTplSeikatsuJiritsudo().getCcdSeikatsuJiritsudoKihonchosa();
    }

    @JsonIgnore
    public IChosaJisshishaJohoDiv getCcdChosaJisshishaJoho() {
        return this.getNinteiChosaNyuryoku().getCcdChosaJisshishaJoho();
    }

    // </editor-fold>
}
