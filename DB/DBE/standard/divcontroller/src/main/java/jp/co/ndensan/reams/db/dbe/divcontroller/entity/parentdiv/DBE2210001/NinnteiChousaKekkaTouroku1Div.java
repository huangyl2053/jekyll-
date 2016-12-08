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
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * NinnteiChousaKekkaTouroku1 のクラスファイル 
 * 
 * @author 自動生成
 */
public class NinnteiChousaKekkaTouroku1Div extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-11-04_20-51-13">
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
    @JsonProperty("hidden登録業務コード")
    private RString hidden登録業務コード;
    @JsonProperty("hidden登録グループコード")
    private RString hidden登録グループコード;
    @JsonProperty("hiddenサンプル文書")
    private RString hiddenサンプル文書;
    @JsonProperty("shinseishoKanriNo")
    private RString shinseishoKanriNo;
    @JsonProperty("recordNumber")
    private RString recordNumber;
    @JsonProperty("モード")
    private RString モード;
    @JsonProperty("hiddenKihonChosaInput1Flag")
    private RString hiddenKihonChosaInput1Flag;
    @JsonProperty("hiddenKihonChosaInput2Flag")
    private RString hiddenKihonChosaInput2Flag;
    @JsonProperty("hiddenKihonChosaInput3Flag")
    private RString hiddenKihonChosaInput3Flag;
    @JsonProperty("hiddenKihonChosaInput4Flag")
    private RString hiddenKihonChosaInput4Flag;
    @JsonProperty("hiddenKihonChosaInput5Flag")
    private RString hiddenKihonChosaInput5Flag;
    @JsonProperty("hiddenKihonChosaInput7Flag")
    private RString hiddenKihonChosaInput7Flag;
    @JsonProperty("ichijiHanteiKekkaJoho")
    private RString ichijiHanteiKekkaJoho;

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
     * gethidden登録業務コード
     * @return hidden登録業務コード
     */
    @JsonProperty("hidden登録業務コード")
    public RString getHidden登録業務コード() {
        return hidden登録業務コード;
    }

    /*
     * sethidden登録業務コード
     * @param hidden登録業務コード hidden登録業務コード
     */
    @JsonProperty("hidden登録業務コード")
    public void setHidden登録業務コード(RString hidden登録業務コード) {
        this.hidden登録業務コード = hidden登録業務コード;
    }

    /*
     * gethidden登録グループコード
     * @return hidden登録グループコード
     */
    @JsonProperty("hidden登録グループコード")
    public RString getHidden登録グループコード() {
        return hidden登録グループコード;
    }

    /*
     * sethidden登録グループコード
     * @param hidden登録グループコード hidden登録グループコード
     */
    @JsonProperty("hidden登録グループコード")
    public void setHidden登録グループコード(RString hidden登録グループコード) {
        this.hidden登録グループコード = hidden登録グループコード;
    }

    /*
     * gethiddenサンプル文書
     * @return hiddenサンプル文書
     */
    @JsonProperty("hiddenサンプル文書")
    public RString getHiddenサンプル文書() {
        return hiddenサンプル文書;
    }

    /*
     * sethiddenサンプル文書
     * @param hiddenサンプル文書 hiddenサンプル文書
     */
    @JsonProperty("hiddenサンプル文書")
    public void setHiddenサンプル文書(RString hiddenサンプル文書) {
        this.hiddenサンプル文書 = hiddenサンプル文書;
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
     * getrecordNumber
     * @return recordNumber
     */
    @JsonProperty("recordNumber")
    public RString getRecordNumber() {
        return recordNumber;
    }

    /*
     * setrecordNumber
     * @param recordNumber recordNumber
     */
    @JsonProperty("recordNumber")
    public void setRecordNumber(RString recordNumber) {
        this.recordNumber = recordNumber;
    }

    /*
     * getモード
     * @return モード
     */
    @JsonProperty("モード")
    public RString getモード() {
        return モード;
    }

    /*
     * setモード
     * @param モード モード
     */
    @JsonProperty("モード")
    public void setモード(RString モード) {
        this.モード = モード;
    }

    /*
     * gethiddenKihonChosaInput1Flag
     * @return hiddenKihonChosaInput1Flag
     */
    @JsonProperty("hiddenKihonChosaInput1Flag")
    public RString getHiddenKihonChosaInput1Flag() {
        return hiddenKihonChosaInput1Flag;
    }

    /*
     * sethiddenKihonChosaInput1Flag
     * @param hiddenKihonChosaInput1Flag hiddenKihonChosaInput1Flag
     */
    @JsonProperty("hiddenKihonChosaInput1Flag")
    public void setHiddenKihonChosaInput1Flag(RString hiddenKihonChosaInput1Flag) {
        this.hiddenKihonChosaInput1Flag = hiddenKihonChosaInput1Flag;
    }

    /*
     * gethiddenKihonChosaInput2Flag
     * @return hiddenKihonChosaInput2Flag
     */
    @JsonProperty("hiddenKihonChosaInput2Flag")
    public RString getHiddenKihonChosaInput2Flag() {
        return hiddenKihonChosaInput2Flag;
    }

    /*
     * sethiddenKihonChosaInput2Flag
     * @param hiddenKihonChosaInput2Flag hiddenKihonChosaInput2Flag
     */
    @JsonProperty("hiddenKihonChosaInput2Flag")
    public void setHiddenKihonChosaInput2Flag(RString hiddenKihonChosaInput2Flag) {
        this.hiddenKihonChosaInput2Flag = hiddenKihonChosaInput2Flag;
    }

    /*
     * gethiddenKihonChosaInput3Flag
     * @return hiddenKihonChosaInput3Flag
     */
    @JsonProperty("hiddenKihonChosaInput3Flag")
    public RString getHiddenKihonChosaInput3Flag() {
        return hiddenKihonChosaInput3Flag;
    }

    /*
     * sethiddenKihonChosaInput3Flag
     * @param hiddenKihonChosaInput3Flag hiddenKihonChosaInput3Flag
     */
    @JsonProperty("hiddenKihonChosaInput3Flag")
    public void setHiddenKihonChosaInput3Flag(RString hiddenKihonChosaInput3Flag) {
        this.hiddenKihonChosaInput3Flag = hiddenKihonChosaInput3Flag;
    }

    /*
     * gethiddenKihonChosaInput4Flag
     * @return hiddenKihonChosaInput4Flag
     */
    @JsonProperty("hiddenKihonChosaInput4Flag")
    public RString getHiddenKihonChosaInput4Flag() {
        return hiddenKihonChosaInput4Flag;
    }

    /*
     * sethiddenKihonChosaInput4Flag
     * @param hiddenKihonChosaInput4Flag hiddenKihonChosaInput4Flag
     */
    @JsonProperty("hiddenKihonChosaInput4Flag")
    public void setHiddenKihonChosaInput4Flag(RString hiddenKihonChosaInput4Flag) {
        this.hiddenKihonChosaInput4Flag = hiddenKihonChosaInput4Flag;
    }

    /*
     * gethiddenKihonChosaInput5Flag
     * @return hiddenKihonChosaInput5Flag
     */
    @JsonProperty("hiddenKihonChosaInput5Flag")
    public RString getHiddenKihonChosaInput5Flag() {
        return hiddenKihonChosaInput5Flag;
    }

    /*
     * sethiddenKihonChosaInput5Flag
     * @param hiddenKihonChosaInput5Flag hiddenKihonChosaInput5Flag
     */
    @JsonProperty("hiddenKihonChosaInput5Flag")
    public void setHiddenKihonChosaInput5Flag(RString hiddenKihonChosaInput5Flag) {
        this.hiddenKihonChosaInput5Flag = hiddenKihonChosaInput5Flag;
    }

    /*
     * gethiddenKihonChosaInput7Flag
     * @return hiddenKihonChosaInput7Flag
     */
    @JsonProperty("hiddenKihonChosaInput7Flag")
    public RString getHiddenKihonChosaInput7Flag() {
        return hiddenKihonChosaInput7Flag;
    }

    /*
     * sethiddenKihonChosaInput7Flag
     * @param hiddenKihonChosaInput7Flag hiddenKihonChosaInput7Flag
     */
    @JsonProperty("hiddenKihonChosaInput7Flag")
    public void setHiddenKihonChosaInput7Flag(RString hiddenKihonChosaInput7Flag) {
        this.hiddenKihonChosaInput7Flag = hiddenKihonChosaInput7Flag;
    }

    /*
     * getichijiHanteiKekkaJoho
     * @return ichijiHanteiKekkaJoho
     */
    @JsonProperty("ichijiHanteiKekkaJoho")
    public RString getIchijiHanteiKekkaJoho() {
        return ichijiHanteiKekkaJoho;
    }

    /*
     * setichijiHanteiKekkaJoho
     * @param ichijiHanteiKekkaJoho ichijiHanteiKekkaJoho
     */
    @JsonProperty("ichijiHanteiKekkaJoho")
    public void setIchijiHanteiKekkaJoho(RString ichijiHanteiKekkaJoho) {
        this.ichijiHanteiKekkaJoho = ichijiHanteiKekkaJoho;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public ChosaTaishoDiv getChosaTaisho() {
        return this.getNinteiChosaNyuryoku().getChosaTaisho();
    }

    @JsonIgnore
    public void  setChosaTaisho(ChosaTaishoDiv ChosaTaisho) {
        this.getNinteiChosaNyuryoku().setChosaTaisho(ChosaTaisho);
    }

    @JsonIgnore
    public INinteiShinseiRenrakusakiKihonDiv getCcdNinteiShinseiRenrakusakiKihon() {
        return this.getNinteiChosaNyuryoku().getChosaTaisho().getCcdNinteiShinseiRenrakusakiKihon();
    }

    @JsonIgnore
    public INinteiShinseishaKihonInfoDiv getCcdNinteiShinseishaKihonInfo() {
        return this.getNinteiChosaNyuryoku().getChosaTaisho().getCcdNinteiShinseishaKihonInfo();
    }

    @JsonIgnore
    public ChosaJisshishaDiv getChosaJisshisha() {
        return this.getNinteiChosaNyuryoku().getChosaJisshisha();
    }

    @JsonIgnore
    public void  setChosaJisshisha(ChosaJisshishaDiv ChosaJisshisha) {
        this.getNinteiChosaNyuryoku().setChosaJisshisha(ChosaJisshisha);
    }

    @JsonIgnore
    public IChosaJisshishaJohoDiv getCcdChosaJisshishaJoho() {
        return this.getNinteiChosaNyuryoku().getChosaJisshisha().getCcdChosaJisshishaJoho();
    }

    @JsonIgnore
    public tabChosaShuruiDiv getTabChosaShurui() {
        return this.getNinteiChosaNyuryoku().getTabChosaShurui();
    }

    @JsonIgnore
    public void  setTabChosaShurui(tabChosaShuruiDiv tabChosaShurui) {
        this.getNinteiChosaNyuryoku().setTabChosaShurui(tabChosaShurui);
    }

    @JsonIgnore
    public tplGaikyoChosaDiv getTplGaikyoChosa() {
        return this.getNinteiChosaNyuryoku().getTabChosaShurui().getTplGaikyoChosa();
    }

    @JsonIgnore
    public void  setTplGaikyoChosa(tplGaikyoChosaDiv tplGaikyoChosa) {
        this.getNinteiChosaNyuryoku().getTabChosaShurui().setTplGaikyoChosa(tplGaikyoChosa);
    }

    @JsonIgnore
    public RadioButton getRadGenzaiservis() {
        return this.getNinteiChosaNyuryoku().getTabChosaShurui().getTplGaikyoChosa().getRadGenzaiservis();
    }

    @JsonIgnore
    public void  setRadGenzaiservis(RadioButton radGenzaiservis) {
        this.getNinteiChosaNyuryoku().getTabChosaShurui().getTplGaikyoChosa().setRadGenzaiservis(radGenzaiservis);
    }

    @JsonIgnore
    public tabChosaBashoDiv getTabChosaBasho() {
        return this.getNinteiChosaNyuryoku().getTabChosaShurui().getTplGaikyoChosa().getTabChosaBasho();
    }

    @JsonIgnore
    public void  setTabChosaBasho(tabChosaBashoDiv tabChosaBasho) {
        this.getNinteiChosaNyuryoku().getTabChosaShurui().getTplGaikyoChosa().setTabChosaBasho(tabChosaBasho);
    }

    @JsonIgnore
    public tplZaitakuDiv getTplZaitaku() {
        return this.getNinteiChosaNyuryoku().getTabChosaShurui().getTplGaikyoChosa().getTabChosaBasho().getTplZaitaku();
    }

    @JsonIgnore
    public void  setTplZaitaku(tplZaitakuDiv tplZaitaku) {
        this.getNinteiChosaNyuryoku().getTabChosaShurui().getTplGaikyoChosa().getTabChosaBasho().setTplZaitaku(tplZaitaku);
    }

    @JsonIgnore
    public RadioButton getRadJutakuKaishu() {
        return this.getNinteiChosaNyuryoku().getTabChosaShurui().getTplGaikyoChosa().getTabChosaBasho().getTplZaitaku().getRadJutakuKaishu();
    }

    @JsonIgnore
    public void  setRadJutakuKaishu(RadioButton radJutakuKaishu) {
        this.getNinteiChosaNyuryoku().getTabChosaShurui().getTplGaikyoChosa().getTabChosaBasho().getTplZaitaku().setRadJutakuKaishu(radJutakuKaishu);
    }

    @JsonIgnore
    public JutakuGaikyoChosaDiv getJutakuGaikyoChosa() {
        return this.getNinteiChosaNyuryoku().getTabChosaShurui().getTplGaikyoChosa().getTabChosaBasho().getTplZaitaku().getJutakuGaikyoChosa();
    }

    @JsonIgnore
    public void  setJutakuGaikyoChosa(JutakuGaikyoChosaDiv JutakuGaikyoChosa) {
        this.getNinteiChosaNyuryoku().getTabChosaShurui().getTplGaikyoChosa().getTabChosaBasho().getTplZaitaku().setJutakuGaikyoChosa(JutakuGaikyoChosa);
    }

    @JsonIgnore
    public DataGrid<dgRiyoServiceJyokyo_Row> getDgRiyoServiceJyokyo() {
        return this.getNinteiChosaNyuryoku().getTabChosaShurui().getTplGaikyoChosa().getTabChosaBasho().getTplZaitaku().getJutakuGaikyoChosa().getDgRiyoServiceJyokyo();
    }

    @JsonIgnore
    public void  setDgRiyoServiceJyokyo(DataGrid<dgRiyoServiceJyokyo_Row> dgRiyoServiceJyokyo) {
        this.getNinteiChosaNyuryoku().getTabChosaShurui().getTplGaikyoChosa().getTabChosaBasho().getTplZaitaku().getJutakuGaikyoChosa().setDgRiyoServiceJyokyo(dgRiyoServiceJyokyo);
    }

    @JsonIgnore
    public TextBoxMultiLine getTxtShichosonTokubetsuKyufu() {
        return this.getNinteiChosaNyuryoku().getTabChosaShurui().getTplGaikyoChosa().getTabChosaBasho().getTplZaitaku().getTxtShichosonTokubetsuKyufu();
    }

    @JsonIgnore
    public void  setTxtShichosonTokubetsuKyufu(TextBoxMultiLine txtShichosonTokubetsuKyufu) {
        this.getNinteiChosaNyuryoku().getTabChosaShurui().getTplGaikyoChosa().getTabChosaBasho().getTplZaitaku().setTxtShichosonTokubetsuKyufu(txtShichosonTokubetsuKyufu);
    }

    @JsonIgnore
    public TextBoxMultiLine getTxtKyufuIgaiJutakuService() {
        return this.getNinteiChosaNyuryoku().getTabChosaShurui().getTplGaikyoChosa().getTabChosaBasho().getTplZaitaku().getTxtKyufuIgaiJutakuService();
    }

    @JsonIgnore
    public void  setTxtKyufuIgaiJutakuService(TextBoxMultiLine txtKyufuIgaiJutakuService) {
        this.getNinteiChosaNyuryoku().getTabChosaShurui().getTplGaikyoChosa().getTabChosaBasho().getTplZaitaku().setTxtKyufuIgaiJutakuService(txtKyufuIgaiJutakuService);
    }

    @JsonIgnore
    public tplShisetsuDiv getTplShisetsu() {
        return this.getNinteiChosaNyuryoku().getTabChosaShurui().getTplGaikyoChosa().getTabChosaBasho().getTplShisetsu();
    }

    @JsonIgnore
    public void  setTplShisetsu(tplShisetsuDiv tplShisetsu) {
        this.getNinteiChosaNyuryoku().getTabChosaShurui().getTplGaikyoChosa().getTabChosaBasho().setTplShisetsu(tplShisetsu);
    }

    @JsonIgnore
    public GaikyoTokkiShisetsuDiv getGaikyoTokkiShisetsu() {
        return this.getNinteiChosaNyuryoku().getTabChosaShurui().getTplGaikyoChosa().getTabChosaBasho().getTplShisetsu().getGaikyoTokkiShisetsu();
    }

    @JsonIgnore
    public void  setGaikyoTokkiShisetsu(GaikyoTokkiShisetsuDiv GaikyoTokkiShisetsu) {
        this.getNinteiChosaNyuryoku().getTabChosaShurui().getTplGaikyoChosa().getTabChosaBasho().getTplShisetsu().setGaikyoTokkiShisetsu(GaikyoTokkiShisetsu);
    }

    @JsonIgnore
    public DataGrid<dgRiyoShisetsu_Row> getDgRiyoShisetsu() {
        return this.getNinteiChosaNyuryoku().getTabChosaShurui().getTplGaikyoChosa().getTabChosaBasho().getTplShisetsu().getGaikyoTokkiShisetsu().getDgRiyoShisetsu();
    }

    @JsonIgnore
    public void  setDgRiyoShisetsu(DataGrid<dgRiyoShisetsu_Row> dgRiyoShisetsu) {
        this.getNinteiChosaNyuryoku().getTabChosaShurui().getTplGaikyoChosa().getTabChosaBasho().getTplShisetsu().getGaikyoTokkiShisetsu().setDgRiyoShisetsu(dgRiyoShisetsu);
    }

    @JsonIgnore
    public GaigyoShisetsuRenrakusakiDiv getGaigyoShisetsuRenrakusaki() {
        return this.getNinteiChosaNyuryoku().getTabChosaShurui().getTplGaikyoChosa().getTabChosaBasho().getTplShisetsu().getGaigyoShisetsuRenrakusaki();
    }

    @JsonIgnore
    public void  setGaigyoShisetsuRenrakusaki(GaigyoShisetsuRenrakusakiDiv GaigyoShisetsuRenrakusaki) {
        this.getNinteiChosaNyuryoku().getTabChosaShurui().getTplGaikyoChosa().getTabChosaBasho().getTplShisetsu().setGaigyoShisetsuRenrakusaki(GaigyoShisetsuRenrakusaki);
    }

    @JsonIgnore
    public TextBox getTxtShisetsuMeisdho() {
        return this.getNinteiChosaNyuryoku().getTabChosaShurui().getTplGaikyoChosa().getTabChosaBasho().getTplShisetsu().getGaigyoShisetsuRenrakusaki().getTxtShisetsuMeisdho();
    }

    @JsonIgnore
    public void  setTxtShisetsuMeisdho(TextBox txtShisetsuMeisdho) {
        this.getNinteiChosaNyuryoku().getTabChosaShurui().getTplGaikyoChosa().getTabChosaBasho().getTplShisetsu().getGaigyoShisetsuRenrakusaki().setTxtShisetsuMeisdho(txtShisetsuMeisdho);
    }

    @JsonIgnore
    public TextBoxYubinNo getTxtShisetsuYubinNo() {
        return this.getNinteiChosaNyuryoku().getTabChosaShurui().getTplGaikyoChosa().getTabChosaBasho().getTplShisetsu().getGaigyoShisetsuRenrakusaki().getTxtShisetsuYubinNo();
    }

    @JsonIgnore
    public void  setTxtShisetsuYubinNo(TextBoxYubinNo txtShisetsuYubinNo) {
        this.getNinteiChosaNyuryoku().getTabChosaShurui().getTplGaikyoChosa().getTabChosaBasho().getTplShisetsu().getGaigyoShisetsuRenrakusaki().setTxtShisetsuYubinNo(txtShisetsuYubinNo);
    }

    @JsonIgnore
    public TextBoxJusho getTxtShisetsuJusho() {
        return this.getNinteiChosaNyuryoku().getTabChosaShurui().getTplGaikyoChosa().getTabChosaBasho().getTplShisetsu().getGaigyoShisetsuRenrakusaki().getTxtShisetsuJusho();
    }

    @JsonIgnore
    public void  setTxtShisetsuJusho(TextBoxJusho txtShisetsuJusho) {
        this.getNinteiChosaNyuryoku().getTabChosaShurui().getTplGaikyoChosa().getTabChosaBasho().getTplShisetsu().getGaigyoShisetsuRenrakusaki().setTxtShisetsuJusho(txtShisetsuJusho);
    }

    @JsonIgnore
    public TextBoxTelNo getTxtTelNo() {
        return this.getNinteiChosaNyuryoku().getTabChosaShurui().getTplGaikyoChosa().getTabChosaBasho().getTplShisetsu().getGaigyoShisetsuRenrakusaki().getTxtTelNo();
    }

    @JsonIgnore
    public void  setTxtTelNo(TextBoxTelNo txtTelNo) {
        this.getNinteiChosaNyuryoku().getTabChosaShurui().getTplGaikyoChosa().getTabChosaBasho().getTplShisetsu().getGaigyoShisetsuRenrakusaki().setTxtTelNo(txtTelNo);
    }

    @JsonIgnore
    public GaikyoTokkiInputDiv getGaikyoTokkiInput() {
        return this.getNinteiChosaNyuryoku().getTabChosaShurui().getTplGaikyoChosa().getGaikyoTokkiInput();
    }

    @JsonIgnore
    public void  setGaikyoTokkiInput(GaikyoTokkiInputDiv GaikyoTokkiInput) {
        this.getNinteiChosaNyuryoku().getTabChosaShurui().getTplGaikyoChosa().setGaikyoTokkiInput(GaikyoTokkiInput);
    }

    @JsonIgnore
    public Label getLblGaigyoTokkiComment() {
        return this.getNinteiChosaNyuryoku().getTabChosaShurui().getTplGaikyoChosa().getGaikyoTokkiInput().getLblGaigyoTokkiComment();
    }

    @JsonIgnore
    public void  setLblGaigyoTokkiComment(Label lblGaigyoTokkiComment) {
        this.getNinteiChosaNyuryoku().getTabChosaShurui().getTplGaikyoChosa().getGaikyoTokkiInput().setLblGaigyoTokkiComment(lblGaigyoTokkiComment);
    }

    @JsonIgnore
    public TextBoxMultiLine getTxtGaikyoTokkiNyuroku() {
        return this.getNinteiChosaNyuryoku().getTabChosaShurui().getTplGaikyoChosa().getGaikyoTokkiInput().getTxtGaikyoTokkiNyuroku();
    }

    @JsonIgnore
    public void  setTxtGaikyoTokkiNyuroku(TextBoxMultiLine txtGaikyoTokkiNyuroku) {
        this.getNinteiChosaNyuryoku().getTabChosaShurui().getTplGaikyoChosa().getGaikyoTokkiInput().setTxtGaikyoTokkiNyuroku(txtGaikyoTokkiNyuroku);
    }

    @JsonIgnore
    public ButtonDialog getBtnTeikeibun() {
        return this.getNinteiChosaNyuryoku().getTabChosaShurui().getTplGaikyoChosa().getGaikyoTokkiInput().getBtnTeikeibun();
    }

    @JsonIgnore
    public void  setBtnTeikeibun(ButtonDialog btnTeikeibun) {
        this.getNinteiChosaNyuryoku().getTabChosaShurui().getTplGaikyoChosa().getGaikyoTokkiInput().setBtnTeikeibun(btnTeikeibun);
    }

    @JsonIgnore
    public tplKihonChosaDiv getTplKihonChosa() {
        return this.getNinteiChosaNyuryoku().getTabChosaShurui().getTplKihonChosa();
    }

    @JsonIgnore
    public void  setTplKihonChosa(tplKihonChosaDiv tplKihonChosa) {
        this.getNinteiChosaNyuryoku().getTabChosaShurui().setTplKihonChosa(tplKihonChosa);
    }

    @JsonIgnore
    public Button getBtnKiteichiSettei() {
        return this.getNinteiChosaNyuryoku().getTabChosaShurui().getTplKihonChosa().getBtnKiteichiSettei();
    }

    @JsonIgnore
    public void  setBtnKiteichiSettei(Button btnKiteichiSettei) {
        this.getNinteiChosaNyuryoku().getTabChosaShurui().getTplKihonChosa().setBtnKiteichiSettei(btnKiteichiSettei);
    }

    @JsonIgnore
    public Button getBtnZenkaiCopy() {
        return this.getNinteiChosaNyuryoku().getTabChosaShurui().getTplKihonChosa().getBtnZenkaiCopy();
    }

    @JsonIgnore
    public void  setBtnZenkaiCopy(Button btnZenkaiCopy) {
        this.getNinteiChosaNyuryoku().getTabChosaShurui().getTplKihonChosa().setBtnZenkaiCopy(btnZenkaiCopy);
    }

    @JsonIgnore
    public TextBox getTxtIchijiHanteiKekka() {
        return this.getNinteiChosaNyuryoku().getTabChosaShurui().getTplKihonChosa().getTxtIchijiHanteiKekka();
    }

    @JsonIgnore
    public void  setTxtIchijiHanteiKekka(TextBox txtIchijiHanteiKekka) {
        this.getNinteiChosaNyuryoku().getTabChosaShurui().getTplKihonChosa().setTxtIchijiHanteiKekka(txtIchijiHanteiKekka);
    }

    @JsonIgnore
    public ButtonDialog getBtnIchiHanteiJisshi() {
        return this.getNinteiChosaNyuryoku().getTabChosaShurui().getTplKihonChosa().getBtnIchiHanteiJisshi();
    }

    @JsonIgnore
    public void  setBtnIchiHanteiJisshi(ButtonDialog btnIchiHanteiJisshi) {
        this.getNinteiChosaNyuryoku().getTabChosaShurui().getTplKihonChosa().setBtnIchiHanteiJisshi(btnIchiHanteiJisshi);
    }

    @JsonIgnore
    public kihonchosaSelectDiv getKihonchosaSelect() {
        return this.getNinteiChosaNyuryoku().getTabChosaShurui().getTplKihonChosa().getKihonchosaSelect();
    }

    @JsonIgnore
    public void  setKihonchosaSelect(kihonchosaSelectDiv kihonchosaSelect) {
        this.getNinteiChosaNyuryoku().getTabChosaShurui().getTplKihonChosa().setKihonchosaSelect(kihonchosaSelect);
    }

    @JsonIgnore
    public ButtonDialog getBtnKihonchosa1() {
        return this.getNinteiChosaNyuryoku().getTabChosaShurui().getTplKihonChosa().getKihonchosaSelect().getBtnKihonchosa1();
    }

    @JsonIgnore
    public void  setBtnKihonchosa1(ButtonDialog btnKihonchosa1) {
        this.getNinteiChosaNyuryoku().getTabChosaShurui().getTplKihonChosa().getKihonchosaSelect().setBtnKihonchosa1(btnKihonchosa1);
    }

    @JsonIgnore
    public ButtonDialog getBtnKihonchosa2() {
        return this.getNinteiChosaNyuryoku().getTabChosaShurui().getTplKihonChosa().getKihonchosaSelect().getBtnKihonchosa2();
    }

    @JsonIgnore
    public void  setBtnKihonchosa2(ButtonDialog btnKihonchosa2) {
        this.getNinteiChosaNyuryoku().getTabChosaShurui().getTplKihonChosa().getKihonchosaSelect().setBtnKihonchosa2(btnKihonchosa2);
    }

    @JsonIgnore
    public ButtonDialog getBtnKihonchosa3() {
        return this.getNinteiChosaNyuryoku().getTabChosaShurui().getTplKihonChosa().getKihonchosaSelect().getBtnKihonchosa3();
    }

    @JsonIgnore
    public void  setBtnKihonchosa3(ButtonDialog btnKihonchosa3) {
        this.getNinteiChosaNyuryoku().getTabChosaShurui().getTplKihonChosa().getKihonchosaSelect().setBtnKihonchosa3(btnKihonchosa3);
    }

    @JsonIgnore
    public ButtonDialog getBtnKihonchosa4() {
        return this.getNinteiChosaNyuryoku().getTabChosaShurui().getTplKihonChosa().getKihonchosaSelect().getBtnKihonchosa4();
    }

    @JsonIgnore
    public void  setBtnKihonchosa4(ButtonDialog btnKihonchosa4) {
        this.getNinteiChosaNyuryoku().getTabChosaShurui().getTplKihonChosa().getKihonchosaSelect().setBtnKihonchosa4(btnKihonchosa4);
    }

    @JsonIgnore
    public ButtonDialog getBtnKihonchosa5() {
        return this.getNinteiChosaNyuryoku().getTabChosaShurui().getTplKihonChosa().getKihonchosaSelect().getBtnKihonchosa5();
    }

    @JsonIgnore
    public void  setBtnKihonchosa5(ButtonDialog btnKihonchosa5) {
        this.getNinteiChosaNyuryoku().getTabChosaShurui().getTplKihonChosa().getKihonchosaSelect().setBtnKihonchosa5(btnKihonchosa5);
    }

    @JsonIgnore
    public ButtonDialog getBtnKihonchosa6() {
        return this.getNinteiChosaNyuryoku().getTabChosaShurui().getTplKihonChosa().getKihonchosaSelect().getBtnKihonchosa6();
    }

    @JsonIgnore
    public void  setBtnKihonchosa6(ButtonDialog btnKihonchosa6) {
        this.getNinteiChosaNyuryoku().getTabChosaShurui().getTplKihonChosa().getKihonchosaSelect().setBtnKihonchosa6(btnKihonchosa6);
    }

    @JsonIgnore
    public ButtonDialog getBtnKihonchosa7() {
        return this.getNinteiChosaNyuryoku().getTabChosaShurui().getTplKihonChosa().getKihonchosaSelect().getBtnKihonchosa7();
    }

    @JsonIgnore
    public void  setBtnKihonchosa7(ButtonDialog btnKihonchosa7) {
        this.getNinteiChosaNyuryoku().getTabChosaShurui().getTplKihonChosa().getKihonchosaSelect().setBtnKihonchosa7(btnKihonchosa7);
    }

    // </editor-fold>
}
