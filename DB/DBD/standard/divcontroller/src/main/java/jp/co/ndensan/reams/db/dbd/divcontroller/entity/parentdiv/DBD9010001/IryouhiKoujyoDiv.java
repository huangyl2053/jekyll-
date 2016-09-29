package jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD9010001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.KaigoKanryoMessage.KaigoKanryoMessage.IKaigoKanryoMessageDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.KaigoKanryoMessage.KaigoKanryoMessage.KaigoKanryoMessageDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.kaigoatenainfo.KaigoAtenaInfo.IKaigoAtenaInfoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.kaigoatenainfo.KaigoAtenaInfo.KaigoAtenaInfoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.kaigoshikakukihon.KaigoShikakuKihon.IKaigoShikakuKihonDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.kaigoshikakukihon.KaigoShikakuKihon.KaigoShikakuKihonDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * IryouhiKoujyo のクラスファイル 
 * 
 * @author 自動生成
 */
public class IryouhiKoujyoDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("IryohiKojyoToroku")
    private IryohiKojyoTorokuDiv IryohiKojyoToroku;
    @JsonProperty("IryohiKojyoItiran")
    private IryohiKojyoItiranDiv IryohiKojyoItiran;
    @JsonProperty("IryohiKojyoSyosai")
    private IryohiKojyoSyosaiDiv IryohiKojyoSyosai;
    @JsonProperty("KaigoKanryo")
    private KaigoKanryoDiv KaigoKanryo;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getIryohiKojyoToroku
     * @return IryohiKojyoToroku
     */
    @JsonProperty("IryohiKojyoToroku")
    public IryohiKojyoTorokuDiv getIryohiKojyoToroku() {
        return IryohiKojyoToroku;
    }

    /*
     * setIryohiKojyoToroku
     * @param IryohiKojyoToroku IryohiKojyoToroku
     */
    @JsonProperty("IryohiKojyoToroku")
    public void setIryohiKojyoToroku(IryohiKojyoTorokuDiv IryohiKojyoToroku) {
        this.IryohiKojyoToroku = IryohiKojyoToroku;
    }

    /*
     * getIryohiKojyoItiran
     * @return IryohiKojyoItiran
     */
    @JsonProperty("IryohiKojyoItiran")
    public IryohiKojyoItiranDiv getIryohiKojyoItiran() {
        return IryohiKojyoItiran;
    }

    /*
     * setIryohiKojyoItiran
     * @param IryohiKojyoItiran IryohiKojyoItiran
     */
    @JsonProperty("IryohiKojyoItiran")
    public void setIryohiKojyoItiran(IryohiKojyoItiranDiv IryohiKojyoItiran) {
        this.IryohiKojyoItiran = IryohiKojyoItiran;
    }

    /*
     * getIryohiKojyoSyosai
     * @return IryohiKojyoSyosai
     */
    @JsonProperty("IryohiKojyoSyosai")
    public IryohiKojyoSyosaiDiv getIryohiKojyoSyosai() {
        return IryohiKojyoSyosai;
    }

    /*
     * setIryohiKojyoSyosai
     * @param IryohiKojyoSyosai IryohiKojyoSyosai
     */
    @JsonProperty("IryohiKojyoSyosai")
    public void setIryohiKojyoSyosai(IryohiKojyoSyosaiDiv IryohiKojyoSyosai) {
        this.IryohiKojyoSyosai = IryohiKojyoSyosai;
    }

    /*
     * getKaigoKanryo
     * @return KaigoKanryo
     */
    @JsonProperty("KaigoKanryo")
    public KaigoKanryoDiv getKaigoKanryo() {
        return KaigoKanryo;
    }

    /*
     * setKaigoKanryo
     * @param KaigoKanryo KaigoKanryo
     */
    @JsonProperty("KaigoKanryo")
    public void setKaigoKanryo(KaigoKanryoDiv KaigoKanryo) {
        this.KaigoKanryo = KaigoKanryo;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public IKaigoShikakuKihonDiv getKaigoShikakuKihonChildDiv() {
        return this.getIryohiKojyoToroku().getKaigoShikakuKihonChildDiv();
    }

    @JsonIgnore
    public IKaigoAtenaInfoDiv getKaigoAtenaInfoChildDiv() {
        return this.getIryohiKojyoToroku().getKaigoAtenaInfoChildDiv();
    }

    @JsonIgnore
    public Button getAddButton() {
        return this.getIryohiKojyoItiran().getAddButton();
    }

    @JsonIgnore
    public void  setAddButton(Button AddButton) {
        this.getIryohiKojyoItiran().setAddButton(AddButton);
    }

    @JsonIgnore
    public Button getClearButton() {
        return this.getIryohiKojyoItiran().getClearButton();
    }

    @JsonIgnore
    public void  setClearButton(Button ClearButton) {
        this.getIryohiKojyoItiran().setClearButton(ClearButton);
    }

    @JsonIgnore
    public DataGrid<IryohiKojyoItiranDataGrid_Row> getIryohiKojyoItiranDataGrid() {
        return this.getIryohiKojyoItiran().getIryohiKojyoItiranDataGrid();
    }

    @JsonIgnore
    public void  setIryohiKojyoItiranDataGrid(DataGrid<IryohiKojyoItiranDataGrid_Row> IryohiKojyoItiranDataGrid) {
        this.getIryohiKojyoItiran().setIryohiKojyoItiranDataGrid(IryohiKojyoItiranDataGrid);
    }

    @JsonIgnore
    public SyosaiPanel1Div getSyosaiPanel1() {
        return this.getIryohiKojyoSyosai().getSyosaiPanel1();
    }

    @JsonIgnore
    public void  setSyosaiPanel1(SyosaiPanel1Div SyosaiPanel1) {
        this.getIryohiKojyoSyosai().setSyosaiPanel1(SyosaiPanel1);
    }

    @JsonIgnore
    public RadioButton getKubunRadioButton() {
        return this.getIryohiKojyoSyosai().getSyosaiPanel1().getKubunRadioButton();
    }

    @JsonIgnore
    public void  setKubunRadioButton(RadioButton KubunRadioButton) {
        this.getIryohiKojyoSyosai().getSyosaiPanel1().setKubunRadioButton(KubunRadioButton);
    }

    @JsonIgnore
    public TextBoxDate getSinseYYMMDD() {
        return this.getIryohiKojyoSyosai().getSyosaiPanel1().getSinseYYMMDD();
    }

    @JsonIgnore
    public void  setSinseYYMMDD(TextBoxDate sinseYYMMDD) {
        this.getIryohiKojyoSyosai().getSyosaiPanel1().setSinseYYMMDD(sinseYYMMDD);
    }

    @JsonIgnore
    public TextBoxDate getTorokuYYMMDD() {
        return this.getIryohiKojyoSyosai().getSyosaiPanel1().getTorokuYYMMDD();
    }

    @JsonIgnore
    public void  setTorokuYYMMDD(TextBoxDate torokuYYMMDD) {
        this.getIryohiKojyoSyosai().getSyosaiPanel1().setTorokuYYMMDD(torokuYYMMDD);
    }

    @JsonIgnore
    public TextBoxDate getTaisyoYY() {
        return this.getIryohiKojyoSyosai().getSyosaiPanel1().getTaisyoYY();
    }

    @JsonIgnore
    public void  setTaisyoYY(TextBoxDate TaisyoYY) {
        this.getIryohiKojyoSyosai().getSyosaiPanel1().setTaisyoYY(TaisyoYY);
    }

    @JsonIgnore
    public SyosaiPanel2Div getSyosaiPanel2() {
        return this.getIryohiKojyoSyosai().getSyosaiPanel2();
    }

    @JsonIgnore
    public void  setSyosaiPanel2(SyosaiPanel2Div SyosaiPanel2) {
        this.getIryohiKojyoSyosai().setSyosaiPanel2(SyosaiPanel2);
    }

    @JsonIgnore
    public TextBoxDate getSakuseYYMMDD() {
        return this.getIryohiKojyoSyosai().getSyosaiPanel2().getSakuseYYMMDD();
    }

    @JsonIgnore
    public void  setSakuseYYMMDD(TextBoxDate SakuseYYMMDD) {
        this.getIryohiKojyoSyosai().getSyosaiPanel2().setSakuseYYMMDD(SakuseYYMMDD);
    }

    @JsonIgnore
    public TextBoxDate getNinteFromYYMMDD() {
        return this.getIryohiKojyoSyosai().getSyosaiPanel2().getNinteFromYYMMDD();
    }

    @JsonIgnore
    public void  setNinteFromYYMMDD(TextBoxDate NinteFromYYMMDD) {
        this.getIryohiKojyoSyosai().getSyosaiPanel2().setNinteFromYYMMDD(NinteFromYYMMDD);
    }

    @JsonIgnore
    public Label getNinnteiTo() {
        return this.getIryohiKojyoSyosai().getSyosaiPanel2().getNinnteiTo();
    }

    @JsonIgnore
    public void  setNinnteiTo(Label NinnteiTo) {
        this.getIryohiKojyoSyosai().getSyosaiPanel2().setNinnteiTo(NinnteiTo);
    }

    @JsonIgnore
    public TextBoxDate getNinteEndYYMMDD() {
        return this.getIryohiKojyoSyosai().getSyosaiPanel2().getNinteEndYYMMDD();
    }

    @JsonIgnore
    public void  setNinteEndYYMMDD(TextBoxDate NinteEndYYMMDD) {
        this.getIryohiKojyoSyosai().getSyosaiPanel2().setNinteEndYYMMDD(NinteEndYYMMDD);
    }

    @JsonIgnore
    public RadioButton getNitijyoSekatuJiritudo() {
        return this.getIryohiKojyoSyosai().getSyosaiPanel2().getNitijyoSekatuJiritudo();
    }

    @JsonIgnore
    public void  setNitijyoSekatuJiritudo(RadioButton NitijyoSekatuJiritudo) {
        this.getIryohiKojyoSyosai().getSyosaiPanel2().setNitijyoSekatuJiritudo(NitijyoSekatuJiritudo);
    }

    @JsonIgnore
    public RadioButton getNyosikin() {
        return this.getIryohiKojyoSyosai().getSyosaiPanel2().getNyosikin();
    }

    @JsonIgnore
    public void  setNyosikin(RadioButton Nyosikin) {
        this.getIryohiKojyoSyosai().getSyosaiPanel2().setNyosikin(Nyosikin);
    }

    @JsonIgnore
    public Button getKakuteButton() {
        return this.getIryohiKojyoSyosai().getKakuteButton();
    }

    @JsonIgnore
    public void  setKakuteButton(Button KakuteButton) {
        this.getIryohiKojyoSyosai().setKakuteButton(KakuteButton);
    }

    @JsonIgnore
    public Button getCancleButton() {
        return this.getIryohiKojyoSyosai().getCancleButton();
    }

    @JsonIgnore
    public void  setCancleButton(Button CancleButton) {
        this.getIryohiKojyoSyosai().setCancleButton(CancleButton);
    }

    @JsonIgnore
    public IKaigoKanryoMessageDiv getKaigoKanryoMessageChildDiv() {
        return this.getKaigoKanryo().getKaigoKanryoMessageChildDiv();
    }

    // </editor-fold>
}
