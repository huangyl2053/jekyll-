package jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD2010001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.kaigoatenainfo.KaigoAtenaInfo.IKaigoAtenaInfoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.kaigoatenainfo.KaigoAtenaInfo.KaigoAtenaInfoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.kaigoshikakukihon.KaigoShikakuKihon.IKaigoShikakuKihonDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.kaigoshikakukihon.KaigoShikakuKihon.KaigoShikakuKihonDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * ShiharaiHohoHenkoKanriMain のクラスファイル 
 * 
 * @author 自動生成
 */
public class ShiharaiHohoHenkoKanriMainDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("lin1")
    private HorizontalLine lin1;
    @JsonProperty("btnJukyuJohoDialog")
    private ButtonDialog btnJukyuJohoDialog;
    @JsonProperty("dgShiharaiHohoHenkoRireki")
    private DataGrid<dgShiharaiHohoHenkoRireki_Row> dgShiharaiHohoHenkoRireki;
    @JsonProperty("space")
    private Space space;
    @JsonProperty("lblIchigoShokanBarai")
    private Label lblIchigoShokanBarai;
    @JsonProperty("btnIchigoYokokushaToroku1")
    private ButtonDialog btnIchigoYokokushaToroku1;
    @JsonProperty("btnIchigoBemmeishoJuri")
    private ButtonDialog btnIchigoBemmeishoJuri;
    @JsonProperty("btnShokanBaraikaToroku")
    private ButtonDialog btnShokanBaraikaToroku;
    @JsonProperty("btnShokanBaraikaShuryoShinsei")
    private ButtonDialog btnShokanBaraikaShuryoShinsei;
    @JsonProperty("btnKyufuIchijiSashitomeToroku")
    private ButtonDialog btnKyufuIchijiSashitomeToroku;
    @JsonProperty("btnHokenryoKojoToroku")
    private ButtonDialog btnHokenryoKojoToroku;
    @JsonProperty("lblIchigoKyufugakuGengaku")
    private Label lblIchigoKyufugakuGengaku;
    @JsonProperty("btnKyufugakuGengakuToroku")
    private ButtonDialog btnKyufugakuGengakuToroku;
    @JsonProperty("btnGengakuMenjoShinsei")
    private ButtonDialog btnGengakuMenjoShinsei;
    @JsonProperty("btnMenjoKaijoAndSaitennyu")
    private ButtonDialog btnMenjoKaijoAndSaitennyu;
    @JsonProperty("lblNigoIchijiSashitome")
    private Label lblNigoIchijiSashitome;
    @JsonProperty("btnNigoYokokushaToroku")
    private ButtonDialog btnNigoYokokushaToroku;
    @JsonProperty("btnNigoBemmeishoJuri")
    private ButtonDialog btnNigoBemmeishoJuri;
    @JsonProperty("btnNigoIchijiSashitomeToroku")
    private ButtonDialog btnNigoIchijiSashitomeToroku;
    @JsonProperty("btnNigoIchijiSashitomeKaijo")
    private ButtonDialog btnNigoIchijiSashitomeKaijo;
    @JsonProperty("ccdShikakuKihon")
    private KaigoShikakuKihonDiv ccdShikakuKihon;
    @JsonProperty("ccdTaishoshaInfo")
    private KaigoAtenaInfoDiv ccdTaishoshaInfo;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getlin1
     * @return lin1
     */
    @JsonProperty("lin1")
    public HorizontalLine getLin1() {
        return lin1;
    }

    /*
     * setlin1
     * @param lin1 lin1
     */
    @JsonProperty("lin1")
    public void setLin1(HorizontalLine lin1) {
        this.lin1 = lin1;
    }

    /*
     * getbtnJukyuJohoDialog
     * @return btnJukyuJohoDialog
     */
    @JsonProperty("btnJukyuJohoDialog")
    public ButtonDialog getBtnJukyuJohoDialog() {
        return btnJukyuJohoDialog;
    }

    /*
     * setbtnJukyuJohoDialog
     * @param btnJukyuJohoDialog btnJukyuJohoDialog
     */
    @JsonProperty("btnJukyuJohoDialog")
    public void setBtnJukyuJohoDialog(ButtonDialog btnJukyuJohoDialog) {
        this.btnJukyuJohoDialog = btnJukyuJohoDialog;
    }

    /*
     * getdgShiharaiHohoHenkoRireki
     * @return dgShiharaiHohoHenkoRireki
     */
    @JsonProperty("dgShiharaiHohoHenkoRireki")
    public DataGrid<dgShiharaiHohoHenkoRireki_Row> getDgShiharaiHohoHenkoRireki() {
        return dgShiharaiHohoHenkoRireki;
    }

    /*
     * setdgShiharaiHohoHenkoRireki
     * @param dgShiharaiHohoHenkoRireki dgShiharaiHohoHenkoRireki
     */
    @JsonProperty("dgShiharaiHohoHenkoRireki")
    public void setDgShiharaiHohoHenkoRireki(DataGrid<dgShiharaiHohoHenkoRireki_Row> dgShiharaiHohoHenkoRireki) {
        this.dgShiharaiHohoHenkoRireki = dgShiharaiHohoHenkoRireki;
    }

    /*
     * getspace
     * @return space
     */
    @JsonProperty("space")
    public Space getSpace() {
        return space;
    }

    /*
     * setspace
     * @param space space
     */
    @JsonProperty("space")
    public void setSpace(Space space) {
        this.space = space;
    }

    /*
     * getlblIchigoShokanBarai
     * @return lblIchigoShokanBarai
     */
    @JsonProperty("lblIchigoShokanBarai")
    public Label getLblIchigoShokanBarai() {
        return lblIchigoShokanBarai;
    }

    /*
     * setlblIchigoShokanBarai
     * @param lblIchigoShokanBarai lblIchigoShokanBarai
     */
    @JsonProperty("lblIchigoShokanBarai")
    public void setLblIchigoShokanBarai(Label lblIchigoShokanBarai) {
        this.lblIchigoShokanBarai = lblIchigoShokanBarai;
    }

    /*
     * getbtnIchigoYokokushaToroku1
     * @return btnIchigoYokokushaToroku1
     */
    @JsonProperty("btnIchigoYokokushaToroku1")
    public ButtonDialog getBtnIchigoYokokushaToroku1() {
        return btnIchigoYokokushaToroku1;
    }

    /*
     * setbtnIchigoYokokushaToroku1
     * @param btnIchigoYokokushaToroku1 btnIchigoYokokushaToroku1
     */
    @JsonProperty("btnIchigoYokokushaToroku1")
    public void setBtnIchigoYokokushaToroku1(ButtonDialog btnIchigoYokokushaToroku1) {
        this.btnIchigoYokokushaToroku1 = btnIchigoYokokushaToroku1;
    }

    /*
     * getbtnIchigoBemmeishoJuri
     * @return btnIchigoBemmeishoJuri
     */
    @JsonProperty("btnIchigoBemmeishoJuri")
    public ButtonDialog getBtnIchigoBemmeishoJuri() {
        return btnIchigoBemmeishoJuri;
    }

    /*
     * setbtnIchigoBemmeishoJuri
     * @param btnIchigoBemmeishoJuri btnIchigoBemmeishoJuri
     */
    @JsonProperty("btnIchigoBemmeishoJuri")
    public void setBtnIchigoBemmeishoJuri(ButtonDialog btnIchigoBemmeishoJuri) {
        this.btnIchigoBemmeishoJuri = btnIchigoBemmeishoJuri;
    }

    /*
     * getbtnShokanBaraikaToroku
     * @return btnShokanBaraikaToroku
     */
    @JsonProperty("btnShokanBaraikaToroku")
    public ButtonDialog getBtnShokanBaraikaToroku() {
        return btnShokanBaraikaToroku;
    }

    /*
     * setbtnShokanBaraikaToroku
     * @param btnShokanBaraikaToroku btnShokanBaraikaToroku
     */
    @JsonProperty("btnShokanBaraikaToroku")
    public void setBtnShokanBaraikaToroku(ButtonDialog btnShokanBaraikaToroku) {
        this.btnShokanBaraikaToroku = btnShokanBaraikaToroku;
    }

    /*
     * getbtnShokanBaraikaShuryoShinsei
     * @return btnShokanBaraikaShuryoShinsei
     */
    @JsonProperty("btnShokanBaraikaShuryoShinsei")
    public ButtonDialog getBtnShokanBaraikaShuryoShinsei() {
        return btnShokanBaraikaShuryoShinsei;
    }

    /*
     * setbtnShokanBaraikaShuryoShinsei
     * @param btnShokanBaraikaShuryoShinsei btnShokanBaraikaShuryoShinsei
     */
    @JsonProperty("btnShokanBaraikaShuryoShinsei")
    public void setBtnShokanBaraikaShuryoShinsei(ButtonDialog btnShokanBaraikaShuryoShinsei) {
        this.btnShokanBaraikaShuryoShinsei = btnShokanBaraikaShuryoShinsei;
    }

    /*
     * getbtnKyufuIchijiSashitomeToroku
     * @return btnKyufuIchijiSashitomeToroku
     */
    @JsonProperty("btnKyufuIchijiSashitomeToroku")
    public ButtonDialog getBtnKyufuIchijiSashitomeToroku() {
        return btnKyufuIchijiSashitomeToroku;
    }

    /*
     * setbtnKyufuIchijiSashitomeToroku
     * @param btnKyufuIchijiSashitomeToroku btnKyufuIchijiSashitomeToroku
     */
    @JsonProperty("btnKyufuIchijiSashitomeToroku")
    public void setBtnKyufuIchijiSashitomeToroku(ButtonDialog btnKyufuIchijiSashitomeToroku) {
        this.btnKyufuIchijiSashitomeToroku = btnKyufuIchijiSashitomeToroku;
    }

    /*
     * getbtnHokenryoKojoToroku
     * @return btnHokenryoKojoToroku
     */
    @JsonProperty("btnHokenryoKojoToroku")
    public ButtonDialog getBtnHokenryoKojoToroku() {
        return btnHokenryoKojoToroku;
    }

    /*
     * setbtnHokenryoKojoToroku
     * @param btnHokenryoKojoToroku btnHokenryoKojoToroku
     */
    @JsonProperty("btnHokenryoKojoToroku")
    public void setBtnHokenryoKojoToroku(ButtonDialog btnHokenryoKojoToroku) {
        this.btnHokenryoKojoToroku = btnHokenryoKojoToroku;
    }

    /*
     * getlblIchigoKyufugakuGengaku
     * @return lblIchigoKyufugakuGengaku
     */
    @JsonProperty("lblIchigoKyufugakuGengaku")
    public Label getLblIchigoKyufugakuGengaku() {
        return lblIchigoKyufugakuGengaku;
    }

    /*
     * setlblIchigoKyufugakuGengaku
     * @param lblIchigoKyufugakuGengaku lblIchigoKyufugakuGengaku
     */
    @JsonProperty("lblIchigoKyufugakuGengaku")
    public void setLblIchigoKyufugakuGengaku(Label lblIchigoKyufugakuGengaku) {
        this.lblIchigoKyufugakuGengaku = lblIchigoKyufugakuGengaku;
    }

    /*
     * getbtnKyufugakuGengakuToroku
     * @return btnKyufugakuGengakuToroku
     */
    @JsonProperty("btnKyufugakuGengakuToroku")
    public ButtonDialog getBtnKyufugakuGengakuToroku() {
        return btnKyufugakuGengakuToroku;
    }

    /*
     * setbtnKyufugakuGengakuToroku
     * @param btnKyufugakuGengakuToroku btnKyufugakuGengakuToroku
     */
    @JsonProperty("btnKyufugakuGengakuToroku")
    public void setBtnKyufugakuGengakuToroku(ButtonDialog btnKyufugakuGengakuToroku) {
        this.btnKyufugakuGengakuToroku = btnKyufugakuGengakuToroku;
    }

    /*
     * getbtnGengakuMenjoShinsei
     * @return btnGengakuMenjoShinsei
     */
    @JsonProperty("btnGengakuMenjoShinsei")
    public ButtonDialog getBtnGengakuMenjoShinsei() {
        return btnGengakuMenjoShinsei;
    }

    /*
     * setbtnGengakuMenjoShinsei
     * @param btnGengakuMenjoShinsei btnGengakuMenjoShinsei
     */
    @JsonProperty("btnGengakuMenjoShinsei")
    public void setBtnGengakuMenjoShinsei(ButtonDialog btnGengakuMenjoShinsei) {
        this.btnGengakuMenjoShinsei = btnGengakuMenjoShinsei;
    }

    /*
     * getbtnMenjoKaijoAndSaitennyu
     * @return btnMenjoKaijoAndSaitennyu
     */
    @JsonProperty("btnMenjoKaijoAndSaitennyu")
    public ButtonDialog getBtnMenjoKaijoAndSaitennyu() {
        return btnMenjoKaijoAndSaitennyu;
    }

    /*
     * setbtnMenjoKaijoAndSaitennyu
     * @param btnMenjoKaijoAndSaitennyu btnMenjoKaijoAndSaitennyu
     */
    @JsonProperty("btnMenjoKaijoAndSaitennyu")
    public void setBtnMenjoKaijoAndSaitennyu(ButtonDialog btnMenjoKaijoAndSaitennyu) {
        this.btnMenjoKaijoAndSaitennyu = btnMenjoKaijoAndSaitennyu;
    }

    /*
     * getlblNigoIchijiSashitome
     * @return lblNigoIchijiSashitome
     */
    @JsonProperty("lblNigoIchijiSashitome")
    public Label getLblNigoIchijiSashitome() {
        return lblNigoIchijiSashitome;
    }

    /*
     * setlblNigoIchijiSashitome
     * @param lblNigoIchijiSashitome lblNigoIchijiSashitome
     */
    @JsonProperty("lblNigoIchijiSashitome")
    public void setLblNigoIchijiSashitome(Label lblNigoIchijiSashitome) {
        this.lblNigoIchijiSashitome = lblNigoIchijiSashitome;
    }

    /*
     * getbtnNigoYokokushaToroku
     * @return btnNigoYokokushaToroku
     */
    @JsonProperty("btnNigoYokokushaToroku")
    public ButtonDialog getBtnNigoYokokushaToroku() {
        return btnNigoYokokushaToroku;
    }

    /*
     * setbtnNigoYokokushaToroku
     * @param btnNigoYokokushaToroku btnNigoYokokushaToroku
     */
    @JsonProperty("btnNigoYokokushaToroku")
    public void setBtnNigoYokokushaToroku(ButtonDialog btnNigoYokokushaToroku) {
        this.btnNigoYokokushaToroku = btnNigoYokokushaToroku;
    }

    /*
     * getbtnNigoBemmeishoJuri
     * @return btnNigoBemmeishoJuri
     */
    @JsonProperty("btnNigoBemmeishoJuri")
    public ButtonDialog getBtnNigoBemmeishoJuri() {
        return btnNigoBemmeishoJuri;
    }

    /*
     * setbtnNigoBemmeishoJuri
     * @param btnNigoBemmeishoJuri btnNigoBemmeishoJuri
     */
    @JsonProperty("btnNigoBemmeishoJuri")
    public void setBtnNigoBemmeishoJuri(ButtonDialog btnNigoBemmeishoJuri) {
        this.btnNigoBemmeishoJuri = btnNigoBemmeishoJuri;
    }

    /*
     * getbtnNigoIchijiSashitomeToroku
     * @return btnNigoIchijiSashitomeToroku
     */
    @JsonProperty("btnNigoIchijiSashitomeToroku")
    public ButtonDialog getBtnNigoIchijiSashitomeToroku() {
        return btnNigoIchijiSashitomeToroku;
    }

    /*
     * setbtnNigoIchijiSashitomeToroku
     * @param btnNigoIchijiSashitomeToroku btnNigoIchijiSashitomeToroku
     */
    @JsonProperty("btnNigoIchijiSashitomeToroku")
    public void setBtnNigoIchijiSashitomeToroku(ButtonDialog btnNigoIchijiSashitomeToroku) {
        this.btnNigoIchijiSashitomeToroku = btnNigoIchijiSashitomeToroku;
    }

    /*
     * getbtnNigoIchijiSashitomeKaijo
     * @return btnNigoIchijiSashitomeKaijo
     */
    @JsonProperty("btnNigoIchijiSashitomeKaijo")
    public ButtonDialog getBtnNigoIchijiSashitomeKaijo() {
        return btnNigoIchijiSashitomeKaijo;
    }

    /*
     * setbtnNigoIchijiSashitomeKaijo
     * @param btnNigoIchijiSashitomeKaijo btnNigoIchijiSashitomeKaijo
     */
    @JsonProperty("btnNigoIchijiSashitomeKaijo")
    public void setBtnNigoIchijiSashitomeKaijo(ButtonDialog btnNigoIchijiSashitomeKaijo) {
        this.btnNigoIchijiSashitomeKaijo = btnNigoIchijiSashitomeKaijo;
    }

    /*
     * getccdShikakuKihon
     * @return ccdShikakuKihon
     */
    @JsonProperty("ccdShikakuKihon")
    public IKaigoShikakuKihonDiv getCcdShikakuKihon() {
        return ccdShikakuKihon;
    }

    /*
     * getccdTaishoshaInfo
     * @return ccdTaishoshaInfo
     */
    @JsonProperty("ccdTaishoshaInfo")
    public IKaigoAtenaInfoDiv getCcdTaishoshaInfo() {
        return ccdTaishoshaInfo;
    }

    // </editor-fold>
}
