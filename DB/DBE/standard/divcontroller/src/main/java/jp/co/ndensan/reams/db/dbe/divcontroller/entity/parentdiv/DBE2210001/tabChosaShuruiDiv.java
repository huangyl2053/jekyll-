package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2210001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.KihonChosaInput.KihonChosaInput.IKihonChosaInputDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.TabContainer;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * tabChosaShurui のクラスファイル
 *
 * @author 自動生成
 */
public class tabChosaShuruiDiv extends TabContainer {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-01-15_09-59-03">
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
    public void setRadGenzaiservis(RadioButton radGenzaiservis) {
        this.getTplGaikyoChosa().setRadGenzaiservis(radGenzaiservis);
    }

    @JsonIgnore
    public tabChosaBashoDiv getTabChosaBasho() {
        return this.getTplGaikyoChosa().getTabChosaBasho();
    }

    @JsonIgnore
    public void setTabChosaBasho(tabChosaBashoDiv tabChosaBasho) {
        this.getTplGaikyoChosa().setTabChosaBasho(tabChosaBasho);
    }

    @JsonIgnore
    public tplZaitakuDiv getTplZaitaku() {
        return this.getTplGaikyoChosa().getTabChosaBasho().getTplZaitaku();
    }

    @JsonIgnore
    public void setTplZaitaku(tplZaitakuDiv tplZaitaku) {
        this.getTplGaikyoChosa().getTabChosaBasho().setTplZaitaku(tplZaitaku);
    }

    @JsonIgnore
    public JutakuGaikyoChosaDiv getJutakuGaikyoChosa() {
        return this.getTplGaikyoChosa().getTabChosaBasho().getTplZaitaku().getJutakuGaikyoChosa();
    }

    @JsonIgnore
    public void setJutakuGaikyoChosa(JutakuGaikyoChosaDiv JutakuGaikyoChosa) {
        this.getTplGaikyoChosa().getTabChosaBasho().getTplZaitaku().setJutakuGaikyoChosa(JutakuGaikyoChosa);
    }

    @JsonIgnore
    public RadioButton getRadJutakuKaishu() {
        return this.getTplGaikyoChosa().getTabChosaBasho().getTplZaitaku().getJutakuGaikyoChosa().getRadJutakuKaishu();
    }

    @JsonIgnore
    public void setRadJutakuKaishu(RadioButton radJutakuKaishu) {
        this.getTplGaikyoChosa().getTabChosaBasho().getTplZaitaku().getJutakuGaikyoChosa().setRadJutakuKaishu(radJutakuKaishu);
    }

    @JsonIgnore
    public DataGrid<dgRiyoSerViceFirstHalf_Row> getDgRiyoSerViceFirstHalf() {
        return this.getTplGaikyoChosa().getTabChosaBasho().getTplZaitaku().getJutakuGaikyoChosa().getDgRiyoSerViceFirstHalf();
    }

    @JsonIgnore
    public void setDgRiyoSerViceFirstHalf(DataGrid<dgRiyoSerViceFirstHalf_Row> dgRiyoSerViceFirstHalf) {
        this.getTplGaikyoChosa().getTabChosaBasho().getTplZaitaku().getJutakuGaikyoChosa().setDgRiyoSerViceFirstHalf(dgRiyoSerViceFirstHalf);
    }

    @JsonIgnore
    public DataGrid<dgRiyoSerViceSecondHalf_Row> getDgRiyoSerViceSecondHalf() {
        return this.getTplGaikyoChosa().getTabChosaBasho().getTplZaitaku().getJutakuGaikyoChosa().getDgRiyoSerViceSecondHalf();
    }

    @JsonIgnore
    public void setDgRiyoSerViceSecondHalf(DataGrid<dgRiyoSerViceSecondHalf_Row> dgRiyoSerViceSecondHalf) {
        this.getTplGaikyoChosa().getTabChosaBasho().getTplZaitaku().getJutakuGaikyoChosa().setDgRiyoSerViceSecondHalf(dgRiyoSerViceSecondHalf);
    }

    @JsonIgnore
    public TextBox getTxtShichosonTokubetsuKyufu() {
        return this.getTplGaikyoChosa().getTabChosaBasho().getTplZaitaku().getJutakuGaikyoChosa().getTxtShichosonTokubetsuKyufu();
    }

    @JsonIgnore
    public void setTxtShichosonTokubetsuKyufu(TextBox txtShichosonTokubetsuKyufu) {
        this.getTplGaikyoChosa().getTabChosaBasho().getTplZaitaku().getJutakuGaikyoChosa().setTxtShichosonTokubetsuKyufu(txtShichosonTokubetsuKyufu);
    }

    @JsonIgnore
    public TextBox getTxtKyufuIgaiJutakuService() {
        return this.getTplGaikyoChosa().getTabChosaBasho().getTplZaitaku().getJutakuGaikyoChosa().getTxtKyufuIgaiJutakuService();
    }

    @JsonIgnore
    public void setTxtKyufuIgaiJutakuService(TextBox txtKyufuIgaiJutakuService) {
        this.getTplGaikyoChosa().getTabChosaBasho().getTplZaitaku().getJutakuGaikyoChosa().setTxtKyufuIgaiJutakuService(txtKyufuIgaiJutakuService);
    }

    @JsonIgnore
    public tplShisetsuDiv getTplShisetsu() {
        return this.getTplGaikyoChosa().getTabChosaBasho().getTplShisetsu();
    }

    @JsonIgnore
    public void setTplShisetsu(tplShisetsuDiv tplShisetsu) {
        this.getTplGaikyoChosa().getTabChosaBasho().setTplShisetsu(tplShisetsu);
    }

    @JsonIgnore
    public GaikyoTokkiShisetsuDiv getGaikyoTokkiShisetsu() {
        return this.getTplGaikyoChosa().getTabChosaBasho().getTplShisetsu().getGaikyoTokkiShisetsu();
    }

    @JsonIgnore
    public void setGaikyoTokkiShisetsu(GaikyoTokkiShisetsuDiv GaikyoTokkiShisetsu) {
        this.getTplGaikyoChosa().getTabChosaBasho().getTplShisetsu().setGaikyoTokkiShisetsu(GaikyoTokkiShisetsu);
    }

    @JsonIgnore
    public DataGrid<dgRiyoShisetsu_Row> getDgRiyoShisetsu() {
        return this.getTplGaikyoChosa().getTabChosaBasho().getTplShisetsu().getGaikyoTokkiShisetsu().getDgRiyoShisetsu();
    }

    @JsonIgnore
    public void setDgRiyoShisetsu(DataGrid<dgRiyoShisetsu_Row> dgRiyoShisetsu) {
        this.getTplGaikyoChosa().getTabChosaBasho().getTplShisetsu().getGaikyoTokkiShisetsu().setDgRiyoShisetsu(dgRiyoShisetsu);
    }

    @JsonIgnore
    public GaigyoShisetsuRenrakusakiDiv getGaigyoShisetsuRenrakusaki() {
        return this.getTplGaikyoChosa().getTabChosaBasho().getTplShisetsu().getGaigyoShisetsuRenrakusaki();
    }

    @JsonIgnore
    public void setGaigyoShisetsuRenrakusaki(GaigyoShisetsuRenrakusakiDiv GaigyoShisetsuRenrakusaki) {
        this.getTplGaikyoChosa().getTabChosaBasho().getTplShisetsu().setGaigyoShisetsuRenrakusaki(GaigyoShisetsuRenrakusaki);
    }

    @JsonIgnore
    public TextBox getTxtShisetsuMeisdho() {
        return this.getTplGaikyoChosa().getTabChosaBasho().getTplShisetsu().getGaigyoShisetsuRenrakusaki().getTxtShisetsuMeisdho();
    }

    @JsonIgnore
    public void setTxtShisetsuMeisdho(TextBox txtShisetsuMeisdho) {
        this.getTplGaikyoChosa().getTabChosaBasho().getTplShisetsu().getGaigyoShisetsuRenrakusaki().setTxtShisetsuMeisdho(txtShisetsuMeisdho);
    }

    @JsonIgnore
    public TextBoxYubinNo getTxtShisetsuYubinNo() {
        return this.getTplGaikyoChosa().getTabChosaBasho().getTplShisetsu().getGaigyoShisetsuRenrakusaki().getTxtShisetsuYubinNo();
    }

    @JsonIgnore
    public void setTxtShisetsuYubinNo(TextBoxYubinNo txtShisetsuYubinNo) {
        this.getTplGaikyoChosa().getTabChosaBasho().getTplShisetsu().getGaigyoShisetsuRenrakusaki().setTxtShisetsuYubinNo(txtShisetsuYubinNo);
    }

    @JsonIgnore
    public TextBoxJusho getTxtShisetsuJusho() {
        return this.getTplGaikyoChosa().getTabChosaBasho().getTplShisetsu().getGaigyoShisetsuRenrakusaki().getTxtShisetsuJusho();
    }

    @JsonIgnore
    public void setTxtShisetsuJusho(TextBoxJusho txtShisetsuJusho) {
        this.getTplGaikyoChosa().getTabChosaBasho().getTplShisetsu().getGaigyoShisetsuRenrakusaki().setTxtShisetsuJusho(txtShisetsuJusho);
    }

    @JsonIgnore
    public TextBoxTelNo getTxtTelNo() {
        return this.getTplGaikyoChosa().getTabChosaBasho().getTplShisetsu().getGaigyoShisetsuRenrakusaki().getTxtTelNo();
    }

    @JsonIgnore
    public void setTxtTelNo(TextBoxTelNo txtTelNo) {
        this.getTplGaikyoChosa().getTabChosaBasho().getTplShisetsu().getGaigyoShisetsuRenrakusaki().setTxtTelNo(txtTelNo);
    }

    @JsonIgnore
    public GaikyoTokkiInputDiv getGaikyoTokkiInput() {
        return this.getTplGaikyoChosa().getGaikyoTokkiInput();
    }

    @JsonIgnore
    public void setGaikyoTokkiInput(GaikyoTokkiInputDiv GaikyoTokkiInput) {
        this.getTplGaikyoChosa().setGaikyoTokkiInput(GaikyoTokkiInput);
    }

    @JsonIgnore
    public Label getLblGaigyoTokkiComment() {
        return this.getTplGaikyoChosa().getGaikyoTokkiInput().getLblGaigyoTokkiComment();
    }

    @JsonIgnore
    public void setLblGaigyoTokkiComment(Label lblGaigyoTokkiComment) {
        this.getTplGaikyoChosa().getGaikyoTokkiInput().setLblGaigyoTokkiComment(lblGaigyoTokkiComment);
    }

    @JsonIgnore
    public TextBoxMultiLine getTxtGaikyoTokkiNyuroku() {
        return this.getTplGaikyoChosa().getGaikyoTokkiInput().getTxtGaikyoTokkiNyuroku();
    }

    @JsonIgnore
    public void setTxtGaikyoTokkiNyuroku(TextBoxMultiLine txtGaikyoTokkiNyuroku) {
        this.getTplGaikyoChosa().getGaikyoTokkiInput().setTxtGaikyoTokkiNyuroku(txtGaikyoTokkiNyuroku);
    }

    @JsonIgnore
    public ButtonDialog getBtnTeikeibun() {
        return this.getTplGaikyoChosa().getGaikyoTokkiInput().getBtnTeikeibun();
    }

    @JsonIgnore
    public void setBtnTeikeibun(ButtonDialog btnTeikeibun) {
        this.getTplGaikyoChosa().getGaikyoTokkiInput().setBtnTeikeibun(btnTeikeibun);
    }

    @JsonIgnore
    public Button getBtnKiteichiSettei() {
        return this.getTplKihonChosa().getBtnKiteichiSettei();
    }

    @JsonIgnore
    public void setBtnKiteichiSettei(Button btnKiteichiSettei) {
        this.getTplKihonChosa().setBtnKiteichiSettei(btnKiteichiSettei);
    }

    @JsonIgnore
    public Button getBtnZenkaiCopy() {
        return this.getTplKihonChosa().getBtnZenkaiCopy();
    }

    @JsonIgnore
    public void setBtnZenkaiCopy(Button btnZenkaiCopy) {
        this.getTplKihonChosa().setBtnZenkaiCopy(btnZenkaiCopy);
    }

    @JsonIgnore
    public TextBox getTxtIchijiHanteiKekka() {
        return this.getTplKihonChosa().getTxtIchijiHanteiKekka();
    }

    @JsonIgnore
    public void setTxtIchijiHanteiKekka(TextBox txtIchijiHanteiKekka) {
        this.getTplKihonChosa().setTxtIchijiHanteiKekka(txtIchijiHanteiKekka);
    }

    @JsonIgnore
    public ButtonDialog getBtnIchiHanteiJisshi() {
        return this.getTplKihonChosa().getBtnIchiHanteiJisshi();
    }

    @JsonIgnore
    public void setBtnIchiHanteiJisshi(ButtonDialog btnIchiHanteiJisshi) {
        this.getTplKihonChosa().setBtnIchiHanteiJisshi(btnIchiHanteiJisshi);
    }

    @JsonIgnore
    public tabKihonChosaShuruiDiv getTabKihonChosaShurui() {
        return this.getTplKihonChosa().getTabKihonChosaShurui();
    }

    @JsonIgnore
    public void setTabKihonChosaShurui(tabKihonChosaShuruiDiv tabKihonChosaShurui) {
        this.getTplKihonChosa().setTabKihonChosaShurui(tabKihonChosaShurui);
    }

    @JsonIgnore
    public tplIchigunDiv getTplIchigun() {
        return this.getTplKihonChosa().getTabKihonChosaShurui().getTplIchigun();
    }

    @JsonIgnore
    public void setTplIchigun(tplIchigunDiv tplIchigun) {
        this.getTplKihonChosa().getTabKihonChosaShurui().setTplIchigun(tplIchigun);
    }

    @JsonIgnore
    public IKihonChosaInputDiv getCcdIchigunKihonChosa() {
        return this.getTplKihonChosa().getTabKihonChosaShurui().getTplIchigun().getCcdIchigunKihonChosa();
    }

    @JsonIgnore
    public tplNigunDiv getTplNigun() {
        return this.getTplKihonChosa().getTabKihonChosaShurui().getTplNigun();
    }

    @JsonIgnore
    public void setTplNigun(tplNigunDiv tplNigun) {
        this.getTplKihonChosa().getTabKihonChosaShurui().setTplNigun(tplNigun);
    }

    @JsonIgnore
    public IKihonChosaInputDiv getCcdNigunKihonChosa() {
        return this.getTplKihonChosa().getTabKihonChosaShurui().getTplNigun().getCcdNigunKihonChosa();
    }

    @JsonIgnore
    public tplSangunDiv getTplSangun() {
        return this.getTplKihonChosa().getTabKihonChosaShurui().getTplSangun();
    }

    @JsonIgnore
    public void setTplSangun(tplSangunDiv tplSangun) {
        this.getTplKihonChosa().getTabKihonChosaShurui().setTplSangun(tplSangun);
    }

    @JsonIgnore
    public IKihonChosaInputDiv getCcdSangunKihonChosa() {
        return this.getTplKihonChosa().getTabKihonChosaShurui().getTplSangun().getCcdSangunKihonChosa();
    }

    @JsonIgnore
    public tplYongunDiv getTplYongun() {
        return this.getTplKihonChosa().getTabKihonChosaShurui().getTplYongun();
    }

    @JsonIgnore
    public void setTplYongun(tplYongunDiv tplYongun) {
        this.getTplKihonChosa().getTabKihonChosaShurui().setTplYongun(tplYongun);
    }

    @JsonIgnore
    public IKihonChosaInputDiv getCcdYongunKihonChosa() {
        return this.getTplKihonChosa().getTabKihonChosaShurui().getTplYongun().getCcdYongunKihonChosa();
    }

    @JsonIgnore
    public tplGogunDiv getTplGogun() {
        return this.getTplKihonChosa().getTabKihonChosaShurui().getTplGogun();
    }

    @JsonIgnore
    public void setTplGogun(tplGogunDiv tplGogun) {
        this.getTplKihonChosa().getTabKihonChosaShurui().setTplGogun(tplGogun);
    }

    @JsonIgnore
    public IKihonChosaInputDiv getCcdGogun() {
        return this.getTplKihonChosa().getTabKihonChosaShurui().getTplGogun().getCcdGogun();
    }

    @JsonIgnore
    public tplTokubetsuIryoDiv getTplTokubetsuIryo() {
        return this.getTplKihonChosa().getTabKihonChosaShurui().getTplTokubetsuIryo();
    }

    @JsonIgnore
    public void setTplTokubetsuIryo(tplTokubetsuIryoDiv tplTokubetsuIryo) {
        this.getTplKihonChosa().getTabKihonChosaShurui().setTplTokubetsuIryo(tplTokubetsuIryo);
    }

    @JsonIgnore
    public IKihonChosaInputDiv getCcdTokubetsuIryoKihonChosa() {
        return this.getTplKihonChosa().getTabKihonChosaShurui().getTplTokubetsuIryo().getCcdTokubetsuIryoKihonChosa();
    }

    @JsonIgnore
    public tplSeikatsuJiritsudoDiv getTplSeikatsuJiritsudo() {
        return this.getTplKihonChosa().getTabKihonChosaShurui().getTplSeikatsuJiritsudo();
    }

    @JsonIgnore
    public void setTplSeikatsuJiritsudo(tplSeikatsuJiritsudoDiv tplSeikatsuJiritsudo) {
        this.getTplKihonChosa().getTabKihonChosaShurui().setTplSeikatsuJiritsudo(tplSeikatsuJiritsudo);
    }

    @JsonIgnore
    public IKihonChosaInputDiv getCcdSeikatsuJiritsudoKihonchosa() {
        return this.getTplKihonChosa().getTabKihonChosaShurui().getTplSeikatsuJiritsudo().getCcdSeikatsuJiritsudoKihonchosa();
    }

    // </editor-fold>
}
