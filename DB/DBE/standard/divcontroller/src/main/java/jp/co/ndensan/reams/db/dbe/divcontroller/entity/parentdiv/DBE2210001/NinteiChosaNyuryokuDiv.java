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
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.KihonChosaInput.KihonChosaInput.IKihonChosaInputDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.NinteiShinseiRenrakusakiKihon.NinteiShinseiRenrakusakiKihon.INinteiShinseiRenrakusakiKihonDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ninteishinseishakihoninfo.NinteiShinseishaKihonInfo.INinteiShinseishaKihonInfoDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * NinteiChosaNyuryoku のクラスファイル
 *
 * @author 自動生成
 */
public class NinteiChosaNyuryokuDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-01-15_09-59-03">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ChosaTaisho")
    private ChosaTaishoDiv ChosaTaisho;
    @JsonProperty("tabChosaShurui")
    private tabChosaShuruiDiv tabChosaShurui;
    @JsonProperty("ccdChosaJisshishaJoho")
    private ChosaJisshishaJohoDiv ccdChosaJisshishaJoho;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
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
     * getccdChosaJisshishaJoho
     * @return ccdChosaJisshishaJoho
     */
    @JsonProperty("ccdChosaJisshishaJoho")
    public IChosaJisshishaJohoDiv getCcdChosaJisshishaJoho() {
        return ccdChosaJisshishaJoho;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public INinteiShinseishaKihonInfoDiv getCcdNinteiShinseishaKihonInfo() {
        return this.getChosaTaisho().getCcdNinteiShinseishaKihonInfo();
    }

    @JsonIgnore
    public INinteiShinseiRenrakusakiKihonDiv getCcdNinteiShinseiRenrakusakiKihon() {
        return this.getChosaTaisho().getCcdNinteiShinseiRenrakusakiKihon();
    }

    @JsonIgnore
    public tplGaikyoChosaDiv getTplGaikyoChosa() {
        return this.getTabChosaShurui().getTplGaikyoChosa();
    }

    @JsonIgnore
    public void setTplGaikyoChosa(tplGaikyoChosaDiv tplGaikyoChosa) {
        this.getTabChosaShurui().setTplGaikyoChosa(tplGaikyoChosa);
    }

    @JsonIgnore
    public RadioButton getRadGenzaiservis() {
        return this.getTabChosaShurui().getTplGaikyoChosa().getRadGenzaiservis();
    }

    @JsonIgnore
    public void setRadGenzaiservis(RadioButton radGenzaiservis) {
        this.getTabChosaShurui().getTplGaikyoChosa().setRadGenzaiservis(radGenzaiservis);
    }

    @JsonIgnore
    public tabChosaBashoDiv getTabChosaBasho() {
        return this.getTabChosaShurui().getTplGaikyoChosa().getTabChosaBasho();
    }

    @JsonIgnore
    public void setTabChosaBasho(tabChosaBashoDiv tabChosaBasho) {
        this.getTabChosaShurui().getTplGaikyoChosa().setTabChosaBasho(tabChosaBasho);
    }

    @JsonIgnore
    public tplZaitakuDiv getTplZaitaku() {
        return this.getTabChosaShurui().getTplGaikyoChosa().getTabChosaBasho().getTplZaitaku();
    }

    @JsonIgnore
    public void setTplZaitaku(tplZaitakuDiv tplZaitaku) {
        this.getTabChosaShurui().getTplGaikyoChosa().getTabChosaBasho().setTplZaitaku(tplZaitaku);
    }

    @JsonIgnore
    public JutakuGaikyoChosaDiv getJutakuGaikyoChosa() {
        return this.getTabChosaShurui().getTplGaikyoChosa().getTabChosaBasho().getTplZaitaku().getJutakuGaikyoChosa();
    }

    @JsonIgnore
    public void setJutakuGaikyoChosa(JutakuGaikyoChosaDiv JutakuGaikyoChosa) {
        this.getTabChosaShurui().getTplGaikyoChosa().getTabChosaBasho().getTplZaitaku().setJutakuGaikyoChosa(JutakuGaikyoChosa);
    }

    @JsonIgnore
    public RadioButton getRadJutakuKaishu() {
        return this.getTabChosaShurui().getTplGaikyoChosa().getTabChosaBasho().getTplZaitaku().getJutakuGaikyoChosa().getRadJutakuKaishu();
    }

    @JsonIgnore
    public void setRadJutakuKaishu(RadioButton radJutakuKaishu) {
        this.getTabChosaShurui().getTplGaikyoChosa().getTabChosaBasho().getTplZaitaku().getJutakuGaikyoChosa().setRadJutakuKaishu(radJutakuKaishu);
    }

    @JsonIgnore
    public DataGrid<dgRiyoSerViceFirstHalf_Row> getDgRiyoSerViceFirstHalf() {
        return this.getTabChosaShurui().getTplGaikyoChosa().getTabChosaBasho().getTplZaitaku().getJutakuGaikyoChosa().getDgRiyoSerViceFirstHalf();
    }

    @JsonIgnore
    public void setDgRiyoSerViceFirstHalf(DataGrid<dgRiyoSerViceFirstHalf_Row> dgRiyoSerViceFirstHalf) {
        this.getTabChosaShurui().getTplGaikyoChosa().getTabChosaBasho().getTplZaitaku().getJutakuGaikyoChosa().setDgRiyoSerViceFirstHalf(dgRiyoSerViceFirstHalf);
    }

    @JsonIgnore
    public DataGrid<dgRiyoSerViceSecondHalf_Row> getDgRiyoSerViceSecondHalf() {
        return this.getTabChosaShurui().getTplGaikyoChosa().getTabChosaBasho().getTplZaitaku().getJutakuGaikyoChosa().getDgRiyoSerViceSecondHalf();
    }

    @JsonIgnore
    public void setDgRiyoSerViceSecondHalf(DataGrid<dgRiyoSerViceSecondHalf_Row> dgRiyoSerViceSecondHalf) {
        this.getTabChosaShurui().getTplGaikyoChosa().getTabChosaBasho().getTplZaitaku().getJutakuGaikyoChosa().setDgRiyoSerViceSecondHalf(dgRiyoSerViceSecondHalf);
    }

    @JsonIgnore
    public TextBox getTxtShichosonTokubetsuKyufu() {
        return this.getTabChosaShurui().getTplGaikyoChosa().getTabChosaBasho().getTplZaitaku().getJutakuGaikyoChosa().getTxtShichosonTokubetsuKyufu();
    }

    @JsonIgnore
    public void setTxtShichosonTokubetsuKyufu(TextBox txtShichosonTokubetsuKyufu) {
        this.getTabChosaShurui().getTplGaikyoChosa().getTabChosaBasho().getTplZaitaku().getJutakuGaikyoChosa().setTxtShichosonTokubetsuKyufu(txtShichosonTokubetsuKyufu);
    }

    @JsonIgnore
    public TextBox getTxtKyufuIgaiJutakuService() {
        return this.getTabChosaShurui().getTplGaikyoChosa().getTabChosaBasho().getTplZaitaku().getJutakuGaikyoChosa().getTxtKyufuIgaiJutakuService();
    }

    @JsonIgnore
    public void setTxtKyufuIgaiJutakuService(TextBox txtKyufuIgaiJutakuService) {
        this.getTabChosaShurui().getTplGaikyoChosa().getTabChosaBasho().getTplZaitaku().getJutakuGaikyoChosa().setTxtKyufuIgaiJutakuService(txtKyufuIgaiJutakuService);
    }

    @JsonIgnore
    public tplShisetsuDiv getTplShisetsu() {
        return this.getTabChosaShurui().getTplGaikyoChosa().getTabChosaBasho().getTplShisetsu();
    }

    @JsonIgnore
    public void setTplShisetsu(tplShisetsuDiv tplShisetsu) {
        this.getTabChosaShurui().getTplGaikyoChosa().getTabChosaBasho().setTplShisetsu(tplShisetsu);
    }

    @JsonIgnore
    public GaikyoTokkiShisetsuDiv getGaikyoTokkiShisetsu() {
        return this.getTabChosaShurui().getTplGaikyoChosa().getTabChosaBasho().getTplShisetsu().getGaikyoTokkiShisetsu();
    }

    @JsonIgnore
    public void setGaikyoTokkiShisetsu(GaikyoTokkiShisetsuDiv GaikyoTokkiShisetsu) {
        this.getTabChosaShurui().getTplGaikyoChosa().getTabChosaBasho().getTplShisetsu().setGaikyoTokkiShisetsu(GaikyoTokkiShisetsu);
    }

    @JsonIgnore
    public DataGrid<dgRiyoShisetsu_Row> getDgRiyoShisetsu() {
        return this.getTabChosaShurui().getTplGaikyoChosa().getTabChosaBasho().getTplShisetsu().getGaikyoTokkiShisetsu().getDgRiyoShisetsu();
    }

    @JsonIgnore
    public void setDgRiyoShisetsu(DataGrid<dgRiyoShisetsu_Row> dgRiyoShisetsu) {
        this.getTabChosaShurui().getTplGaikyoChosa().getTabChosaBasho().getTplShisetsu().getGaikyoTokkiShisetsu().setDgRiyoShisetsu(dgRiyoShisetsu);
    }

    @JsonIgnore
    public GaigyoShisetsuRenrakusakiDiv getGaigyoShisetsuRenrakusaki() {
        return this.getTabChosaShurui().getTplGaikyoChosa().getTabChosaBasho().getTplShisetsu().getGaigyoShisetsuRenrakusaki();
    }

    @JsonIgnore
    public void setGaigyoShisetsuRenrakusaki(GaigyoShisetsuRenrakusakiDiv GaigyoShisetsuRenrakusaki) {
        this.getTabChosaShurui().getTplGaikyoChosa().getTabChosaBasho().getTplShisetsu().setGaigyoShisetsuRenrakusaki(GaigyoShisetsuRenrakusaki);
    }

    @JsonIgnore
    public TextBox getTxtShisetsuMeisdho() {
        return this.getTabChosaShurui().getTplGaikyoChosa().getTabChosaBasho().getTplShisetsu().getGaigyoShisetsuRenrakusaki().getTxtShisetsuMeisdho();
    }

    @JsonIgnore
    public void setTxtShisetsuMeisdho(TextBox txtShisetsuMeisdho) {
        this.getTabChosaShurui().getTplGaikyoChosa().getTabChosaBasho().getTplShisetsu().getGaigyoShisetsuRenrakusaki().setTxtShisetsuMeisdho(txtShisetsuMeisdho);
    }

    @JsonIgnore
    public TextBoxYubinNo getTxtShisetsuYubinNo() {
        return this.getTabChosaShurui().getTplGaikyoChosa().getTabChosaBasho().getTplShisetsu().getGaigyoShisetsuRenrakusaki().getTxtShisetsuYubinNo();
    }

    @JsonIgnore
    public void setTxtShisetsuYubinNo(TextBoxYubinNo txtShisetsuYubinNo) {
        this.getTabChosaShurui().getTplGaikyoChosa().getTabChosaBasho().getTplShisetsu().getGaigyoShisetsuRenrakusaki().setTxtShisetsuYubinNo(txtShisetsuYubinNo);
    }

    @JsonIgnore
    public TextBoxJusho getTxtShisetsuJusho() {
        return this.getTabChosaShurui().getTplGaikyoChosa().getTabChosaBasho().getTplShisetsu().getGaigyoShisetsuRenrakusaki().getTxtShisetsuJusho();
    }

    @JsonIgnore
    public void setTxtShisetsuJusho(TextBoxJusho txtShisetsuJusho) {
        this.getTabChosaShurui().getTplGaikyoChosa().getTabChosaBasho().getTplShisetsu().getGaigyoShisetsuRenrakusaki().setTxtShisetsuJusho(txtShisetsuJusho);
    }

    @JsonIgnore
    public TextBoxTelNo getTxtTelNo() {
        return this.getTabChosaShurui().getTplGaikyoChosa().getTabChosaBasho().getTplShisetsu().getGaigyoShisetsuRenrakusaki().getTxtTelNo();
    }

    @JsonIgnore
    public void setTxtTelNo(TextBoxTelNo txtTelNo) {
        this.getTabChosaShurui().getTplGaikyoChosa().getTabChosaBasho().getTplShisetsu().getGaigyoShisetsuRenrakusaki().setTxtTelNo(txtTelNo);
    }

    @JsonIgnore
    public GaikyoTokkiInputDiv getGaikyoTokkiInput() {
        return this.getTabChosaShurui().getTplGaikyoChosa().getGaikyoTokkiInput();
    }

    @JsonIgnore
    public void setGaikyoTokkiInput(GaikyoTokkiInputDiv GaikyoTokkiInput) {
        this.getTabChosaShurui().getTplGaikyoChosa().setGaikyoTokkiInput(GaikyoTokkiInput);
    }

    @JsonIgnore
    public Label getLblGaigyoTokkiComment() {
        return this.getTabChosaShurui().getTplGaikyoChosa().getGaikyoTokkiInput().getLblGaigyoTokkiComment();
    }

    @JsonIgnore
    public void setLblGaigyoTokkiComment(Label lblGaigyoTokkiComment) {
        this.getTabChosaShurui().getTplGaikyoChosa().getGaikyoTokkiInput().setLblGaigyoTokkiComment(lblGaigyoTokkiComment);
    }

    @JsonIgnore
    public TextBoxMultiLine getTxtGaikyoTokkiNyuroku() {
        return this.getTabChosaShurui().getTplGaikyoChosa().getGaikyoTokkiInput().getTxtGaikyoTokkiNyuroku();
    }

    @JsonIgnore
    public void setTxtGaikyoTokkiNyuroku(TextBoxMultiLine txtGaikyoTokkiNyuroku) {
        this.getTabChosaShurui().getTplGaikyoChosa().getGaikyoTokkiInput().setTxtGaikyoTokkiNyuroku(txtGaikyoTokkiNyuroku);
    }

    @JsonIgnore
    public ButtonDialog getBtnTeikeibun() {
        return this.getTabChosaShurui().getTplGaikyoChosa().getGaikyoTokkiInput().getBtnTeikeibun();
    }

    @JsonIgnore
    public void setBtnTeikeibun(ButtonDialog btnTeikeibun) {
        this.getTabChosaShurui().getTplGaikyoChosa().getGaikyoTokkiInput().setBtnTeikeibun(btnTeikeibun);
    }

    @JsonIgnore
    public tplKihonChosaDiv getTplKihonChosa() {
        return this.getTabChosaShurui().getTplKihonChosa();
    }

    @JsonIgnore
    public void setTplKihonChosa(tplKihonChosaDiv tplKihonChosa) {
        this.getTabChosaShurui().setTplKihonChosa(tplKihonChosa);
    }

    @JsonIgnore
    public Button getBtnKiteichiSettei() {
        return this.getTabChosaShurui().getTplKihonChosa().getBtnKiteichiSettei();
    }

    @JsonIgnore
    public void setBtnKiteichiSettei(Button btnKiteichiSettei) {
        this.getTabChosaShurui().getTplKihonChosa().setBtnKiteichiSettei(btnKiteichiSettei);
    }

    @JsonIgnore
    public Button getBtnZenkaiCopy() {
        return this.getTabChosaShurui().getTplKihonChosa().getBtnZenkaiCopy();
    }

    @JsonIgnore
    public void setBtnZenkaiCopy(Button btnZenkaiCopy) {
        this.getTabChosaShurui().getTplKihonChosa().setBtnZenkaiCopy(btnZenkaiCopy);
    }

    @JsonIgnore
    public TextBox getTxtIchijiHanteiKekka() {
        return this.getTabChosaShurui().getTplKihonChosa().getTxtIchijiHanteiKekka();
    }

    @JsonIgnore
    public void setTxtIchijiHanteiKekka(TextBox txtIchijiHanteiKekka) {
        this.getTabChosaShurui().getTplKihonChosa().setTxtIchijiHanteiKekka(txtIchijiHanteiKekka);
    }

    @JsonIgnore
    public ButtonDialog getBtnIchiHanteiJisshi() {
        return this.getTabChosaShurui().getTplKihonChosa().getBtnIchiHanteiJisshi();
    }

    @JsonIgnore
    public void setBtnIchiHanteiJisshi(ButtonDialog btnIchiHanteiJisshi) {
        this.getTabChosaShurui().getTplKihonChosa().setBtnIchiHanteiJisshi(btnIchiHanteiJisshi);
    }

    @JsonIgnore
    public tabKihonChosaShuruiDiv getTabKihonChosaShurui() {
        return this.getTabChosaShurui().getTplKihonChosa().getTabKihonChosaShurui();
    }

    @JsonIgnore
    public void setTabKihonChosaShurui(tabKihonChosaShuruiDiv tabKihonChosaShurui) {
        this.getTabChosaShurui().getTplKihonChosa().setTabKihonChosaShurui(tabKihonChosaShurui);
    }

    @JsonIgnore
    public tplIchigunDiv getTplIchigun() {
        return this.getTabChosaShurui().getTplKihonChosa().getTabKihonChosaShurui().getTplIchigun();
    }

    @JsonIgnore
    public void setTplIchigun(tplIchigunDiv tplIchigun) {
        this.getTabChosaShurui().getTplKihonChosa().getTabKihonChosaShurui().setTplIchigun(tplIchigun);
    }

    @JsonIgnore
    public IKihonChosaInputDiv getCcdIchigunKihonChosa() {
        return this.getTabChosaShurui().getTplKihonChosa().getTabKihonChosaShurui().getTplIchigun().getCcdIchigunKihonChosa();
    }

    @JsonIgnore
    public tplNigunDiv getTplNigun() {
        return this.getTabChosaShurui().getTplKihonChosa().getTabKihonChosaShurui().getTplNigun();
    }

    @JsonIgnore
    public void setTplNigun(tplNigunDiv tplNigun) {
        this.getTabChosaShurui().getTplKihonChosa().getTabKihonChosaShurui().setTplNigun(tplNigun);
    }

    @JsonIgnore
    public IKihonChosaInputDiv getCcdNigunKihonChosa() {
        return this.getTabChosaShurui().getTplKihonChosa().getTabKihonChosaShurui().getTplNigun().getCcdNigunKihonChosa();
    }

    @JsonIgnore
    public tplSangunDiv getTplSangun() {
        return this.getTabChosaShurui().getTplKihonChosa().getTabKihonChosaShurui().getTplSangun();
    }

    @JsonIgnore
    public void setTplSangun(tplSangunDiv tplSangun) {
        this.getTabChosaShurui().getTplKihonChosa().getTabKihonChosaShurui().setTplSangun(tplSangun);
    }

    @JsonIgnore
    public IKihonChosaInputDiv getCcdSangunKihonChosa() {
        return this.getTabChosaShurui().getTplKihonChosa().getTabKihonChosaShurui().getTplSangun().getCcdSangunKihonChosa();
    }

    @JsonIgnore
    public tplYongunDiv getTplYongun() {
        return this.getTabChosaShurui().getTplKihonChosa().getTabKihonChosaShurui().getTplYongun();
    }

    @JsonIgnore
    public void setTplYongun(tplYongunDiv tplYongun) {
        this.getTabChosaShurui().getTplKihonChosa().getTabKihonChosaShurui().setTplYongun(tplYongun);
    }

    @JsonIgnore
    public IKihonChosaInputDiv getCcdYongunKihonChosa() {
        return this.getTabChosaShurui().getTplKihonChosa().getTabKihonChosaShurui().getTplYongun().getCcdYongunKihonChosa();
    }

    @JsonIgnore
    public tplGogunDiv getTplGogun() {
        return this.getTabChosaShurui().getTplKihonChosa().getTabKihonChosaShurui().getTplGogun();
    }

    @JsonIgnore
    public void setTplGogun(tplGogunDiv tplGogun) {
        this.getTabChosaShurui().getTplKihonChosa().getTabKihonChosaShurui().setTplGogun(tplGogun);
    }

    @JsonIgnore
    public IKihonChosaInputDiv getCcdGogun() {
        return this.getTabChosaShurui().getTplKihonChosa().getTabKihonChosaShurui().getTplGogun().getCcdGogun();
    }

    @JsonIgnore
    public tplTokubetsuIryoDiv getTplTokubetsuIryo() {
        return this.getTabChosaShurui().getTplKihonChosa().getTabKihonChosaShurui().getTplTokubetsuIryo();
    }

    @JsonIgnore
    public void setTplTokubetsuIryo(tplTokubetsuIryoDiv tplTokubetsuIryo) {
        this.getTabChosaShurui().getTplKihonChosa().getTabKihonChosaShurui().setTplTokubetsuIryo(tplTokubetsuIryo);
    }

    @JsonIgnore
    public IKihonChosaInputDiv getCcdTokubetsuIryoKihonChosa() {
        return this.getTabChosaShurui().getTplKihonChosa().getTabKihonChosaShurui().getTplTokubetsuIryo().getCcdTokubetsuIryoKihonChosa();
    }

    @JsonIgnore
    public tplSeikatsuJiritsudoDiv getTplSeikatsuJiritsudo() {
        return this.getTabChosaShurui().getTplKihonChosa().getTabKihonChosaShurui().getTplSeikatsuJiritsudo();
    }

    @JsonIgnore
    public void setTplSeikatsuJiritsudo(tplSeikatsuJiritsudoDiv tplSeikatsuJiritsudo) {
        this.getTabChosaShurui().getTplKihonChosa().getTabKihonChosaShurui().setTplSeikatsuJiritsudo(tplSeikatsuJiritsudo);
    }

    @JsonIgnore
    public IKihonChosaInputDiv getCcdSeikatsuJiritsudoKihonchosa() {
        return this.getTabChosaShurui().getTplKihonChosa().getTabKihonChosaShurui().getTplSeikatsuJiritsudo().getCcdSeikatsuJiritsudoKihonchosa();
    }

    // </editor-fold>
}
