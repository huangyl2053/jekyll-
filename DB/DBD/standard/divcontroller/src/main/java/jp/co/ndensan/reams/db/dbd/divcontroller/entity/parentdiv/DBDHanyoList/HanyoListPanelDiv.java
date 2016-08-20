package jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBDHanyoList;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.chohyoshutsuryokujun.ChohyoShutsuryokujun.ChohyoShutsuryokujunDiv;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.chohyoshutsuryokujun.ChohyoShutsuryokujun.IChohyoShutsuryokujunDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * HanyoListPanel のクラスファイル 
 * 
 * @author 自動生成
 */
public class HanyoListPanelDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("HanyoListShisetsuNyutaisho")
    private HanyoListShisetsuNyutaishoDiv HanyoListShisetsuNyutaisho;
    @JsonProperty("HanyoListRiyoshaFutanGakuGengaku")
    private HanyoListRiyoshaFutanGakuGengakuDiv HanyoListRiyoshaFutanGakuGengaku;
    @JsonProperty("HanyoListHomonKaigoRiyoshaFutanGakuGengaku")
    private HanyoListHomonKaigoRiyoshaFutanGakuGengakuDiv HanyoListHomonKaigoRiyoshaFutanGakuGengaku;
    @JsonProperty("HanyoListShakaiFukushiHojinKeigen")
    private HanyoListShakaiFukushiHojinKeigenDiv HanyoListShakaiFukushiHojinKeigen;
    @JsonProperty("HanyoListTokubetsuChiikiKasanGemmen")
    private HanyoListTokubetsuChiikiKasanGemmenDiv HanyoListTokubetsuChiikiKasanGemmen;
    @JsonProperty("HanyoListFutanGendoGakuNintei")
    private HanyoListFutanGendoGakuNinteiDiv HanyoListFutanGendoGakuNintei;
    @JsonProperty("HanyoListKokuho")
    private HanyoListKokuhoDiv HanyoListKokuho;
    @JsonProperty("HanyoListKokiKoreisha")
    private HanyoListKokiKoreishaDiv HanyoListKokiKoreisha;
    @JsonProperty("HanyoListJigyoTaishosha")
    private HanyoListJigyoTaishoshaDiv HanyoListJigyoTaishosha;
    @JsonProperty("HanyoListRiyoshaFutanwariai")
    private HanyoListRiyoshaFutanwariaiDiv HanyoListRiyoshaFutanwariai;
    @JsonProperty("ChushutsuJoken")
    private ChushutsuJokenDiv ChushutsuJoken;
    @JsonProperty("btnShutsuryokujun")
    private Button btnShutsuryokujun;
    @JsonProperty("ccdShutsuryokujun")
    private ChohyoShutsuryokujunDiv ccdShutsuryokujun;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getHanyoListShisetsuNyutaisho
     * @return HanyoListShisetsuNyutaisho
     */
    @JsonProperty("HanyoListShisetsuNyutaisho")
    public HanyoListShisetsuNyutaishoDiv getHanyoListShisetsuNyutaisho() {
        return HanyoListShisetsuNyutaisho;
    }

    /*
     * setHanyoListShisetsuNyutaisho
     * @param HanyoListShisetsuNyutaisho HanyoListShisetsuNyutaisho
     */
    @JsonProperty("HanyoListShisetsuNyutaisho")
    public void setHanyoListShisetsuNyutaisho(HanyoListShisetsuNyutaishoDiv HanyoListShisetsuNyutaisho) {
        this.HanyoListShisetsuNyutaisho = HanyoListShisetsuNyutaisho;
    }

    /*
     * getHanyoListRiyoshaFutanGakuGengaku
     * @return HanyoListRiyoshaFutanGakuGengaku
     */
    @JsonProperty("HanyoListRiyoshaFutanGakuGengaku")
    public HanyoListRiyoshaFutanGakuGengakuDiv getHanyoListRiyoshaFutanGakuGengaku() {
        return HanyoListRiyoshaFutanGakuGengaku;
    }

    /*
     * setHanyoListRiyoshaFutanGakuGengaku
     * @param HanyoListRiyoshaFutanGakuGengaku HanyoListRiyoshaFutanGakuGengaku
     */
    @JsonProperty("HanyoListRiyoshaFutanGakuGengaku")
    public void setHanyoListRiyoshaFutanGakuGengaku(HanyoListRiyoshaFutanGakuGengakuDiv HanyoListRiyoshaFutanGakuGengaku) {
        this.HanyoListRiyoshaFutanGakuGengaku = HanyoListRiyoshaFutanGakuGengaku;
    }

    /*
     * getHanyoListHomonKaigoRiyoshaFutanGakuGengaku
     * @return HanyoListHomonKaigoRiyoshaFutanGakuGengaku
     */
    @JsonProperty("HanyoListHomonKaigoRiyoshaFutanGakuGengaku")
    public HanyoListHomonKaigoRiyoshaFutanGakuGengakuDiv getHanyoListHomonKaigoRiyoshaFutanGakuGengaku() {
        return HanyoListHomonKaigoRiyoshaFutanGakuGengaku;
    }

    /*
     * setHanyoListHomonKaigoRiyoshaFutanGakuGengaku
     * @param HanyoListHomonKaigoRiyoshaFutanGakuGengaku HanyoListHomonKaigoRiyoshaFutanGakuGengaku
     */
    @JsonProperty("HanyoListHomonKaigoRiyoshaFutanGakuGengaku")
    public void setHanyoListHomonKaigoRiyoshaFutanGakuGengaku(HanyoListHomonKaigoRiyoshaFutanGakuGengakuDiv HanyoListHomonKaigoRiyoshaFutanGakuGengaku) {
        this.HanyoListHomonKaigoRiyoshaFutanGakuGengaku = HanyoListHomonKaigoRiyoshaFutanGakuGengaku;
    }

    /*
     * getHanyoListShakaiFukushiHojinKeigen
     * @return HanyoListShakaiFukushiHojinKeigen
     */
    @JsonProperty("HanyoListShakaiFukushiHojinKeigen")
    public HanyoListShakaiFukushiHojinKeigenDiv getHanyoListShakaiFukushiHojinKeigen() {
        return HanyoListShakaiFukushiHojinKeigen;
    }

    /*
     * setHanyoListShakaiFukushiHojinKeigen
     * @param HanyoListShakaiFukushiHojinKeigen HanyoListShakaiFukushiHojinKeigen
     */
    @JsonProperty("HanyoListShakaiFukushiHojinKeigen")
    public void setHanyoListShakaiFukushiHojinKeigen(HanyoListShakaiFukushiHojinKeigenDiv HanyoListShakaiFukushiHojinKeigen) {
        this.HanyoListShakaiFukushiHojinKeigen = HanyoListShakaiFukushiHojinKeigen;
    }

    /*
     * getHanyoListTokubetsuChiikiKasanGemmen
     * @return HanyoListTokubetsuChiikiKasanGemmen
     */
    @JsonProperty("HanyoListTokubetsuChiikiKasanGemmen")
    public HanyoListTokubetsuChiikiKasanGemmenDiv getHanyoListTokubetsuChiikiKasanGemmen() {
        return HanyoListTokubetsuChiikiKasanGemmen;
    }

    /*
     * setHanyoListTokubetsuChiikiKasanGemmen
     * @param HanyoListTokubetsuChiikiKasanGemmen HanyoListTokubetsuChiikiKasanGemmen
     */
    @JsonProperty("HanyoListTokubetsuChiikiKasanGemmen")
    public void setHanyoListTokubetsuChiikiKasanGemmen(HanyoListTokubetsuChiikiKasanGemmenDiv HanyoListTokubetsuChiikiKasanGemmen) {
        this.HanyoListTokubetsuChiikiKasanGemmen = HanyoListTokubetsuChiikiKasanGemmen;
    }

    /*
     * getHanyoListFutanGendoGakuNintei
     * @return HanyoListFutanGendoGakuNintei
     */
    @JsonProperty("HanyoListFutanGendoGakuNintei")
    public HanyoListFutanGendoGakuNinteiDiv getHanyoListFutanGendoGakuNintei() {
        return HanyoListFutanGendoGakuNintei;
    }

    /*
     * setHanyoListFutanGendoGakuNintei
     * @param HanyoListFutanGendoGakuNintei HanyoListFutanGendoGakuNintei
     */
    @JsonProperty("HanyoListFutanGendoGakuNintei")
    public void setHanyoListFutanGendoGakuNintei(HanyoListFutanGendoGakuNinteiDiv HanyoListFutanGendoGakuNintei) {
        this.HanyoListFutanGendoGakuNintei = HanyoListFutanGendoGakuNintei;
    }

    /*
     * getHanyoListKokuho
     * @return HanyoListKokuho
     */
    @JsonProperty("HanyoListKokuho")
    public HanyoListKokuhoDiv getHanyoListKokuho() {
        return HanyoListKokuho;
    }

    /*
     * setHanyoListKokuho
     * @param HanyoListKokuho HanyoListKokuho
     */
    @JsonProperty("HanyoListKokuho")
    public void setHanyoListKokuho(HanyoListKokuhoDiv HanyoListKokuho) {
        this.HanyoListKokuho = HanyoListKokuho;
    }

    /*
     * getHanyoListKokiKoreisha
     * @return HanyoListKokiKoreisha
     */
    @JsonProperty("HanyoListKokiKoreisha")
    public HanyoListKokiKoreishaDiv getHanyoListKokiKoreisha() {
        return HanyoListKokiKoreisha;
    }

    /*
     * setHanyoListKokiKoreisha
     * @param HanyoListKokiKoreisha HanyoListKokiKoreisha
     */
    @JsonProperty("HanyoListKokiKoreisha")
    public void setHanyoListKokiKoreisha(HanyoListKokiKoreishaDiv HanyoListKokiKoreisha) {
        this.HanyoListKokiKoreisha = HanyoListKokiKoreisha;
    }

    /*
     * getHanyoListJigyoTaishosha
     * @return HanyoListJigyoTaishosha
     */
    @JsonProperty("HanyoListJigyoTaishosha")
    public HanyoListJigyoTaishoshaDiv getHanyoListJigyoTaishosha() {
        return HanyoListJigyoTaishosha;
    }

    /*
     * setHanyoListJigyoTaishosha
     * @param HanyoListJigyoTaishosha HanyoListJigyoTaishosha
     */
    @JsonProperty("HanyoListJigyoTaishosha")
    public void setHanyoListJigyoTaishosha(HanyoListJigyoTaishoshaDiv HanyoListJigyoTaishosha) {
        this.HanyoListJigyoTaishosha = HanyoListJigyoTaishosha;
    }

    /*
     * getHanyoListRiyoshaFutanwariai
     * @return HanyoListRiyoshaFutanwariai
     */
    @JsonProperty("HanyoListRiyoshaFutanwariai")
    public HanyoListRiyoshaFutanwariaiDiv getHanyoListRiyoshaFutanwariai() {
        return HanyoListRiyoshaFutanwariai;
    }

    /*
     * setHanyoListRiyoshaFutanwariai
     * @param HanyoListRiyoshaFutanwariai HanyoListRiyoshaFutanwariai
     */
    @JsonProperty("HanyoListRiyoshaFutanwariai")
    public void setHanyoListRiyoshaFutanwariai(HanyoListRiyoshaFutanwariaiDiv HanyoListRiyoshaFutanwariai) {
        this.HanyoListRiyoshaFutanwariai = HanyoListRiyoshaFutanwariai;
    }

    /*
     * getChushutsuJoken
     * @return ChushutsuJoken
     */
    @JsonProperty("ChushutsuJoken")
    public ChushutsuJokenDiv getChushutsuJoken() {
        return ChushutsuJoken;
    }

    /*
     * setChushutsuJoken
     * @param ChushutsuJoken ChushutsuJoken
     */
    @JsonProperty("ChushutsuJoken")
    public void setChushutsuJoken(ChushutsuJokenDiv ChushutsuJoken) {
        this.ChushutsuJoken = ChushutsuJoken;
    }

    /*
     * getbtnShutsuryokujun
     * @return btnShutsuryokujun
     */
    @JsonProperty("btnShutsuryokujun")
    public Button getBtnShutsuryokujun() {
        return btnShutsuryokujun;
    }

    /*
     * setbtnShutsuryokujun
     * @param btnShutsuryokujun btnShutsuryokujun
     */
    @JsonProperty("btnShutsuryokujun")
    public void setBtnShutsuryokujun(Button btnShutsuryokujun) {
        this.btnShutsuryokujun = btnShutsuryokujun;
    }

    /*
     * getccdShutsuryokujun
     * @return ccdShutsuryokujun
     */
    @JsonProperty("ccdShutsuryokujun")
    public IChohyoShutsuryokujunDiv getCcdShutsuryokujun() {
        return ccdShutsuryokujun;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public DropDownList getDdlCyusyutsuhohokubun1() {
        return this.getHanyoListShisetsuNyutaisho().getDdlCyusyutsuhohokubun1();
    }

    @JsonIgnore
    public void  setDdlCyusyutsuhohokubun1(DropDownList ddlCyusyutsuhohokubun1) {
        this.getHanyoListShisetsuNyutaisho().setDdlCyusyutsuhohokubun1(ddlCyusyutsuhohokubun1);
    }

    @JsonIgnore
    public TextBox getTxtCyusyutsukomokukubun1() {
        return this.getHanyoListShisetsuNyutaisho().getTxtCyusyutsukomokukubun1();
    }

    @JsonIgnore
    public void  setTxtCyusyutsukomokukubun1(TextBox txtCyusyutsukomokukubun1) {
        this.getHanyoListShisetsuNyutaisho().setTxtCyusyutsukomokukubun1(txtCyusyutsukomokukubun1);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtKizyunnichi1() {
        return this.getHanyoListShisetsuNyutaisho().getTxtKizyunnichi1();
    }

    @JsonIgnore
    public void  setTxtKizyunnichi1(TextBoxFlexibleDate txtKizyunnichi1) {
        this.getHanyoListShisetsuNyutaisho().setTxtKizyunnichi1(txtKizyunnichi1);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtHitsukehanifrom1() {
        return this.getHanyoListShisetsuNyutaisho().getTxtHitsukehanifrom1();
    }

    @JsonIgnore
    public void  setTxtHitsukehanifrom1(TextBoxFlexibleDate txtHitsukehanifrom1) {
        this.getHanyoListShisetsuNyutaisho().setTxtHitsukehanifrom1(txtHitsukehanifrom1);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtHitsukehanito1() {
        return this.getHanyoListShisetsuNyutaisho().getTxtHitsukehanito1();
    }

    @JsonIgnore
    public void  setTxtHitsukehanito1(TextBoxFlexibleDate txtHitsukehanito1) {
        this.getHanyoListShisetsuNyutaisho().setTxtHitsukehanito1(txtHitsukehanito1);
    }

    @JsonIgnore
    public DropDownList getDdlChokindatacyusyutsu1() {
        return this.getHanyoListShisetsuNyutaisho().getDdlChokindatacyusyutsu1();
    }

    @JsonIgnore
    public void  setDdlChokindatacyusyutsu1(DropDownList ddlChokindatacyusyutsu1) {
        this.getHanyoListShisetsuNyutaisho().setDdlChokindatacyusyutsu1(ddlChokindatacyusyutsu1);
    }

    @JsonIgnore
    public DropDownList getDdlSoshitsukubun1() {
        return this.getHanyoListShisetsuNyutaisho().getDdlSoshitsukubun1();
    }

    @JsonIgnore
    public void  setDdlSoshitsukubun1(DropDownList ddlSoshitsukubun1) {
        this.getHanyoListShisetsuNyutaisho().setDdlSoshitsukubun1(ddlSoshitsukubun1);
    }

    @JsonIgnore
    public DropDownList getDdlIsCsvkomokumeifuka1() {
        return this.getHanyoListShisetsuNyutaisho().getDdlIsCsvkomokumeifuka1();
    }

    @JsonIgnore
    public void  setDdlIsCsvkomokumeifuka1(DropDownList ddlIsCsvkomokumeifuka1) {
        this.getHanyoListShisetsuNyutaisho().setDdlIsCsvkomokumeifuka1(ddlIsCsvkomokumeifuka1);
    }

    @JsonIgnore
    public DropDownList getDdlIsCsvrenbanfuka1() {
        return this.getHanyoListShisetsuNyutaisho().getDdlIsCsvrenbanfuka1();
    }

    @JsonIgnore
    public void  setDdlIsCsvrenbanfuka1(DropDownList ddlIsCsvrenbanfuka1) {
        this.getHanyoListShisetsuNyutaisho().setDdlIsCsvrenbanfuka1(ddlIsCsvrenbanfuka1);
    }

    @JsonIgnore
    public DropDownList getDdlIsCsvhitsukesurasyuhensyu1() {
        return this.getHanyoListShisetsuNyutaisho().getDdlIsCsvhitsukesurasyuhensyu1();
    }

    @JsonIgnore
    public void  setDdlIsCsvhitsukesurasyuhensyu1(DropDownList ddlIsCsvhitsukesurasyuhensyu1) {
        this.getHanyoListShisetsuNyutaisho().setDdlIsCsvhitsukesurasyuhensyu1(ddlIsCsvhitsukesurasyuhensyu1);
    }

    @JsonIgnore
    public TextBox getTxtCyohyoid1() {
        return this.getHanyoListShisetsuNyutaisho().getTxtCyohyoid1();
    }

    @JsonIgnore
    public void  setTxtCyohyoid1(TextBox txtCyohyoid1) {
        this.getHanyoListShisetsuNyutaisho().setTxtCyohyoid1(txtCyohyoid1);
    }

    @JsonIgnore
    public TextBox getTxtSyutsuryokukomoku1() {
        return this.getHanyoListShisetsuNyutaisho().getTxtSyutsuryokukomoku1();
    }

    @JsonIgnore
    public void  setTxtSyutsuryokukomoku1(TextBox txtSyutsuryokukomoku1) {
        this.getHanyoListShisetsuNyutaisho().setTxtSyutsuryokukomoku1(txtSyutsuryokukomoku1);
    }

    @JsonIgnore
    public Label getLbl1() {
        return this.getHanyoListRiyoshaFutanGakuGengaku().getLbl1();
    }

    @JsonIgnore
    public void  setLbl1(Label lbl1) {
        this.getHanyoListRiyoshaFutanGakuGengaku().setLbl1(lbl1);
    }

    @JsonIgnore
    public Label getLbl2() {
        return this.getHanyoListHomonKaigoRiyoshaFutanGakuGengaku().getLbl2();
    }

    @JsonIgnore
    public void  setLbl2(Label lbl2) {
        this.getHanyoListHomonKaigoRiyoshaFutanGakuGengaku().setLbl2(lbl2);
    }

    @JsonIgnore
    public TextBox getTxtHyoudai4() {
        return this.getHanyoListShakaiFukushiHojinKeigen().getTxtHyoudai4();
    }

    @JsonIgnore
    public void  setTxtHyoudai4(TextBox txtHyoudai4) {
        this.getHanyoListShakaiFukushiHojinKeigen().setTxtHyoudai4(txtHyoudai4);
    }

    @JsonIgnore
    public DropDownList getDdlCyusyutsuhohokubun4() {
        return this.getHanyoListShakaiFukushiHojinKeigen().getDdlCyusyutsuhohokubun4();
    }

    @JsonIgnore
    public void  setDdlCyusyutsuhohokubun4(DropDownList ddlCyusyutsuhohokubun4) {
        this.getHanyoListShakaiFukushiHojinKeigen().setDdlCyusyutsuhohokubun4(ddlCyusyutsuhohokubun4);
    }

    @JsonIgnore
    public TextBox getTxtCyusyutsukomokukubun4() {
        return this.getHanyoListShakaiFukushiHojinKeigen().getTxtCyusyutsukomokukubun4();
    }

    @JsonIgnore
    public void  setTxtCyusyutsukomokukubun4(TextBox txtCyusyutsukomokukubun4) {
        this.getHanyoListShakaiFukushiHojinKeigen().setTxtCyusyutsukomokukubun4(txtCyusyutsukomokukubun4);
    }

    @JsonIgnore
    public TextBoxFlexibleYear getTxtNendo4() {
        return this.getHanyoListShakaiFukushiHojinKeigen().getTxtNendo4();
    }

    @JsonIgnore
    public void  setTxtNendo4(TextBoxFlexibleYear txtNendo4) {
        this.getHanyoListShakaiFukushiHojinKeigen().setTxtNendo4(txtNendo4);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtKizyunnichi4() {
        return this.getHanyoListShakaiFukushiHojinKeigen().getTxtKizyunnichi4();
    }

    @JsonIgnore
    public void  setTxtKizyunnichi4(TextBoxFlexibleDate txtKizyunnichi4) {
        this.getHanyoListShakaiFukushiHojinKeigen().setTxtKizyunnichi4(txtKizyunnichi4);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtHitsukehanifrom4() {
        return this.getHanyoListShakaiFukushiHojinKeigen().getTxtHitsukehanifrom4();
    }

    @JsonIgnore
    public void  setTxtHitsukehanifrom4(TextBoxFlexibleDate txtHitsukehanifrom4) {
        this.getHanyoListShakaiFukushiHojinKeigen().setTxtHitsukehanifrom4(txtHitsukehanifrom4);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtHitsukehanito4() {
        return this.getHanyoListShakaiFukushiHojinKeigen().getTxtHitsukehanito4();
    }

    @JsonIgnore
    public void  setTxtHitsukehanito4(TextBoxFlexibleDate txtHitsukehanito4) {
        this.getHanyoListShakaiFukushiHojinKeigen().setTxtHitsukehanito4(txtHitsukehanito4);
    }

    @JsonIgnore
    public DropDownList getDdlIsNendochokindatacyusyutsu4() {
        return this.getHanyoListShakaiFukushiHojinKeigen().getDdlIsNendochokindatacyusyutsu4();
    }

    @JsonIgnore
    public void  setDdlIsNendochokindatacyusyutsu4(DropDownList ddlIsNendochokindatacyusyutsu4) {
        this.getHanyoListShakaiFukushiHojinKeigen().setDdlIsNendochokindatacyusyutsu4(ddlIsNendochokindatacyusyutsu4);
    }

    @JsonIgnore
    public DropDownList getDdlChokindatacyusyutsu4() {
        return this.getHanyoListShakaiFukushiHojinKeigen().getDdlChokindatacyusyutsu4();
    }

    @JsonIgnore
    public void  setDdlChokindatacyusyutsu4(DropDownList ddlChokindatacyusyutsu4) {
        this.getHanyoListShakaiFukushiHojinKeigen().setDdlChokindatacyusyutsu4(ddlChokindatacyusyutsu4);
    }

    @JsonIgnore
    public Label getLbl3() {
        return this.getHanyoListTokubetsuChiikiKasanGemmen().getLbl3();
    }

    @JsonIgnore
    public void  setLbl3(Label lbl3) {
        this.getHanyoListTokubetsuChiikiKasanGemmen().setLbl3(lbl3);
    }

    @JsonIgnore
    public Label getLbl4() {
        return this.getHanyoListFutanGendoGakuNintei().getLbl4();
    }

    @JsonIgnore
    public void  setLbl4(Label lbl4) {
        this.getHanyoListFutanGendoGakuNintei().setLbl4(lbl4);
    }

    @JsonIgnore
    public DropDownList getDdlCyusyutsuhohokubun7() {
        return this.getHanyoListKokuho().getDdlCyusyutsuhohokubun7();
    }

    @JsonIgnore
    public void  setDdlCyusyutsuhohokubun7(DropDownList ddlCyusyutsuhohokubun7) {
        this.getHanyoListKokuho().setDdlCyusyutsuhohokubun7(ddlCyusyutsuhohokubun7);
    }

    @JsonIgnore
    public TextBox getTxtCyusyutsukomokukubun7() {
        return this.getHanyoListKokuho().getTxtCyusyutsukomokukubun7();
    }

    @JsonIgnore
    public void  setTxtCyusyutsukomokukubun7(TextBox txtCyusyutsukomokukubun7) {
        this.getHanyoListKokuho().setTxtCyusyutsukomokukubun7(txtCyusyutsukomokukubun7);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtKizyunnichi7() {
        return this.getHanyoListKokuho().getTxtKizyunnichi7();
    }

    @JsonIgnore
    public void  setTxtKizyunnichi7(TextBoxFlexibleDate txtKizyunnichi7) {
        this.getHanyoListKokuho().setTxtKizyunnichi7(txtKizyunnichi7);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtHitsukehanifrom7() {
        return this.getHanyoListKokuho().getTxtHitsukehanifrom7();
    }

    @JsonIgnore
    public void  setTxtHitsukehanifrom7(TextBoxFlexibleDate txtHitsukehanifrom7) {
        this.getHanyoListKokuho().setTxtHitsukehanifrom7(txtHitsukehanifrom7);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtHitsukehanito7() {
        return this.getHanyoListKokuho().getTxtHitsukehanito7();
    }

    @JsonIgnore
    public void  setTxtHitsukehanito7(TextBoxFlexibleDate txtHitsukehanito7) {
        this.getHanyoListKokuho().setTxtHitsukehanito7(txtHitsukehanito7);
    }

    @JsonIgnore
    public DropDownList getDdlChokindatacyusyutsu7() {
        return this.getHanyoListKokuho().getDdlChokindatacyusyutsu7();
    }

    @JsonIgnore
    public void  setDdlChokindatacyusyutsu7(DropDownList ddlChokindatacyusyutsu7) {
        this.getHanyoListKokuho().setDdlChokindatacyusyutsu7(ddlChokindatacyusyutsu7);
    }

    @JsonIgnore
    public DropDownList getDdlSoshitsukubun7() {
        return this.getHanyoListKokuho().getDdlSoshitsukubun7();
    }

    @JsonIgnore
    public void  setDdlSoshitsukubun7(DropDownList ddlSoshitsukubun7) {
        this.getHanyoListKokuho().setDdlSoshitsukubun7(ddlSoshitsukubun7);
    }

    @JsonIgnore
    public DropDownList getDdlIsCsvkomokumeifuka7() {
        return this.getHanyoListKokuho().getDdlIsCsvkomokumeifuka7();
    }

    @JsonIgnore
    public void  setDdlIsCsvkomokumeifuka7(DropDownList ddlIsCsvkomokumeifuka7) {
        this.getHanyoListKokuho().setDdlIsCsvkomokumeifuka7(ddlIsCsvkomokumeifuka7);
    }

    @JsonIgnore
    public DropDownList getDdlIsCsvrenbanfuka7() {
        return this.getHanyoListKokuho().getDdlIsCsvrenbanfuka7();
    }

    @JsonIgnore
    public void  setDdlIsCsvrenbanfuka7(DropDownList ddlIsCsvrenbanfuka7) {
        this.getHanyoListKokuho().setDdlIsCsvrenbanfuka7(ddlIsCsvrenbanfuka7);
    }

    @JsonIgnore
    public DropDownList getDdlIsCsvhitsukesurasyuhensyu7() {
        return this.getHanyoListKokuho().getDdlIsCsvhitsukesurasyuhensyu7();
    }

    @JsonIgnore
    public void  setDdlIsCsvhitsukesurasyuhensyu7(DropDownList ddlIsCsvhitsukesurasyuhensyu7) {
        this.getHanyoListKokuho().setDdlIsCsvhitsukesurasyuhensyu7(ddlIsCsvhitsukesurasyuhensyu7);
    }

    @JsonIgnore
    public TextBox getTxtCyohyoid7() {
        return this.getHanyoListKokuho().getTxtCyohyoid7();
    }

    @JsonIgnore
    public void  setTxtCyohyoid7(TextBox txtCyohyoid7) {
        this.getHanyoListKokuho().setTxtCyohyoid7(txtCyohyoid7);
    }

    @JsonIgnore
    public TextBox getTxtSyutsuryokukomoku7() {
        return this.getHanyoListKokuho().getTxtSyutsuryokukomoku7();
    }

    @JsonIgnore
    public void  setTxtSyutsuryokukomoku7(TextBox txtSyutsuryokukomoku7) {
        this.getHanyoListKokuho().setTxtSyutsuryokukomoku7(txtSyutsuryokukomoku7);
    }

    @JsonIgnore
    public DropDownList getDdlCyusyutsuhohokubun8() {
        return this.getHanyoListKokiKoreisha().getDdlCyusyutsuhohokubun8();
    }

    @JsonIgnore
    public void  setDdlCyusyutsuhohokubun8(DropDownList ddlCyusyutsuhohokubun8) {
        this.getHanyoListKokiKoreisha().setDdlCyusyutsuhohokubun8(ddlCyusyutsuhohokubun8);
    }

    @JsonIgnore
    public TextBox getTxtCyusyutsukomokukubun8() {
        return this.getHanyoListKokiKoreisha().getTxtCyusyutsukomokukubun8();
    }

    @JsonIgnore
    public void  setTxtCyusyutsukomokukubun8(TextBox txtCyusyutsukomokukubun8) {
        this.getHanyoListKokiKoreisha().setTxtCyusyutsukomokukubun8(txtCyusyutsukomokukubun8);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtKizyunnichi8() {
        return this.getHanyoListKokiKoreisha().getTxtKizyunnichi8();
    }

    @JsonIgnore
    public void  setTxtKizyunnichi8(TextBoxFlexibleDate txtKizyunnichi8) {
        this.getHanyoListKokiKoreisha().setTxtKizyunnichi8(txtKizyunnichi8);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtHitsukehanifrom8() {
        return this.getHanyoListKokiKoreisha().getTxtHitsukehanifrom8();
    }

    @JsonIgnore
    public void  setTxtHitsukehanifrom8(TextBoxFlexibleDate txtHitsukehanifrom8) {
        this.getHanyoListKokiKoreisha().setTxtHitsukehanifrom8(txtHitsukehanifrom8);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtHitsukehanito8() {
        return this.getHanyoListKokiKoreisha().getTxtHitsukehanito8();
    }

    @JsonIgnore
    public void  setTxtHitsukehanito8(TextBoxFlexibleDate txtHitsukehanito8) {
        this.getHanyoListKokiKoreisha().setTxtHitsukehanito8(txtHitsukehanito8);
    }

    @JsonIgnore
    public DropDownList getDdlChokindatacyusyutsu8() {
        return this.getHanyoListKokiKoreisha().getDdlChokindatacyusyutsu8();
    }

    @JsonIgnore
    public void  setDdlChokindatacyusyutsu8(DropDownList ddlChokindatacyusyutsu8) {
        this.getHanyoListKokiKoreisha().setDdlChokindatacyusyutsu8(ddlChokindatacyusyutsu8);
    }

    @JsonIgnore
    public DropDownList getDdlSoshitsukubun8() {
        return this.getHanyoListKokiKoreisha().getDdlSoshitsukubun8();
    }

    @JsonIgnore
    public void  setDdlSoshitsukubun8(DropDownList ddlSoshitsukubun8) {
        this.getHanyoListKokiKoreisha().setDdlSoshitsukubun8(ddlSoshitsukubun8);
    }

    @JsonIgnore
    public DropDownList getDdlIsCsvkomokumeifuka8() {
        return this.getHanyoListKokiKoreisha().getDdlIsCsvkomokumeifuka8();
    }

    @JsonIgnore
    public void  setDdlIsCsvkomokumeifuka8(DropDownList ddlIsCsvkomokumeifuka8) {
        this.getHanyoListKokiKoreisha().setDdlIsCsvkomokumeifuka8(ddlIsCsvkomokumeifuka8);
    }

    @JsonIgnore
    public DropDownList getDdlIsCsvrenbanfuka8() {
        return this.getHanyoListKokiKoreisha().getDdlIsCsvrenbanfuka8();
    }

    @JsonIgnore
    public void  setDdlIsCsvrenbanfuka8(DropDownList ddlIsCsvrenbanfuka8) {
        this.getHanyoListKokiKoreisha().setDdlIsCsvrenbanfuka8(ddlIsCsvrenbanfuka8);
    }

    @JsonIgnore
    public DropDownList getDdlIsCsvhitsukesurasyuhensyu8() {
        return this.getHanyoListKokiKoreisha().getDdlIsCsvhitsukesurasyuhensyu8();
    }

    @JsonIgnore
    public void  setDdlIsCsvhitsukesurasyuhensyu8(DropDownList ddlIsCsvhitsukesurasyuhensyu8) {
        this.getHanyoListKokiKoreisha().setDdlIsCsvhitsukesurasyuhensyu8(ddlIsCsvhitsukesurasyuhensyu8);
    }

    @JsonIgnore
    public TextBox getTxtCyohyoid8() {
        return this.getHanyoListKokiKoreisha().getTxtCyohyoid8();
    }

    @JsonIgnore
    public void  setTxtCyohyoid8(TextBox txtCyohyoid8) {
        this.getHanyoListKokiKoreisha().setTxtCyohyoid8(txtCyohyoid8);
    }

    @JsonIgnore
    public TextBox getTxtSyutsuryokukomoku8() {
        return this.getHanyoListKokiKoreisha().getTxtSyutsuryokukomoku8();
    }

    @JsonIgnore
    public void  setTxtSyutsuryokukomoku8(TextBox txtSyutsuryokukomoku8) {
        this.getHanyoListKokiKoreisha().setTxtSyutsuryokukomoku8(txtSyutsuryokukomoku8);
    }

    @JsonIgnore
    public DropDownList getDdlCyusyutsuhohokubun9() {
        return this.getHanyoListJigyoTaishosha().getDdlCyusyutsuhohokubun9();
    }

    @JsonIgnore
    public void  setDdlCyusyutsuhohokubun9(DropDownList ddlCyusyutsuhohokubun9) {
        this.getHanyoListJigyoTaishosha().setDdlCyusyutsuhohokubun9(ddlCyusyutsuhohokubun9);
    }

    @JsonIgnore
    public TextBox getTxtCyusyutsukomokukubun9() {
        return this.getHanyoListJigyoTaishosha().getTxtCyusyutsukomokukubun9();
    }

    @JsonIgnore
    public void  setTxtCyusyutsukomokukubun9(TextBox txtCyusyutsukomokukubun9) {
        this.getHanyoListJigyoTaishosha().setTxtCyusyutsukomokukubun9(txtCyusyutsukomokukubun9);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtKizyunnichi9() {
        return this.getHanyoListJigyoTaishosha().getTxtKizyunnichi9();
    }

    @JsonIgnore
    public void  setTxtKizyunnichi9(TextBoxFlexibleDate txtKizyunnichi9) {
        this.getHanyoListJigyoTaishosha().setTxtKizyunnichi9(txtKizyunnichi9);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtHitsukehanifrom9() {
        return this.getHanyoListJigyoTaishosha().getTxtHitsukehanifrom9();
    }

    @JsonIgnore
    public void  setTxtHitsukehanifrom9(TextBoxFlexibleDate txtHitsukehanifrom9) {
        this.getHanyoListJigyoTaishosha().setTxtHitsukehanifrom9(txtHitsukehanifrom9);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtHitsukehanito9() {
        return this.getHanyoListJigyoTaishosha().getTxtHitsukehanito9();
    }

    @JsonIgnore
    public void  setTxtHitsukehanito9(TextBoxFlexibleDate txtHitsukehanito9) {
        this.getHanyoListJigyoTaishosha().setTxtHitsukehanito9(txtHitsukehanito9);
    }

    @JsonIgnore
    public DropDownList getDdlIsJigyotaishoshacyusyutsu9() {
        return this.getHanyoListJigyoTaishosha().getDdlIsJigyotaishoshacyusyutsu9();
    }

    @JsonIgnore
    public void  setDdlIsJigyotaishoshacyusyutsu9(DropDownList ddlIsJigyotaishoshacyusyutsu9) {
        this.getHanyoListJigyoTaishosha().setDdlIsJigyotaishoshacyusyutsu9(ddlIsJigyotaishoshacyusyutsu9);
    }

    @JsonIgnore
    public DropDownList getDdlSoshitsukubun9() {
        return this.getHanyoListJigyoTaishosha().getDdlSoshitsukubun9();
    }

    @JsonIgnore
    public void  setDdlSoshitsukubun9(DropDownList ddlSoshitsukubun9) {
        this.getHanyoListJigyoTaishosha().setDdlSoshitsukubun9(ddlSoshitsukubun9);
    }

    @JsonIgnore
    public DropDownList getDdlIsCsvkomokumeifuka9() {
        return this.getHanyoListJigyoTaishosha().getDdlIsCsvkomokumeifuka9();
    }

    @JsonIgnore
    public void  setDdlIsCsvkomokumeifuka9(DropDownList ddlIsCsvkomokumeifuka9) {
        this.getHanyoListJigyoTaishosha().setDdlIsCsvkomokumeifuka9(ddlIsCsvkomokumeifuka9);
    }

    @JsonIgnore
    public DropDownList getDdlIsCsvrenbanfuka9() {
        return this.getHanyoListJigyoTaishosha().getDdlIsCsvrenbanfuka9();
    }

    @JsonIgnore
    public void  setDdlIsCsvrenbanfuka9(DropDownList ddlIsCsvrenbanfuka9) {
        this.getHanyoListJigyoTaishosha().setDdlIsCsvrenbanfuka9(ddlIsCsvrenbanfuka9);
    }

    @JsonIgnore
    public DropDownList getDdlIsCsvhitsukesurasyuhensyu9() {
        return this.getHanyoListJigyoTaishosha().getDdlIsCsvhitsukesurasyuhensyu9();
    }

    @JsonIgnore
    public void  setDdlIsCsvhitsukesurasyuhensyu9(DropDownList ddlIsCsvhitsukesurasyuhensyu9) {
        this.getHanyoListJigyoTaishosha().setDdlIsCsvhitsukesurasyuhensyu9(ddlIsCsvhitsukesurasyuhensyu9);
    }

    @JsonIgnore
    public TextBox getTxtCyohyoid9() {
        return this.getHanyoListJigyoTaishosha().getTxtCyohyoid9();
    }

    @JsonIgnore
    public void  setTxtCyohyoid9(TextBox txtCyohyoid9) {
        this.getHanyoListJigyoTaishosha().setTxtCyohyoid9(txtCyohyoid9);
    }

    @JsonIgnore
    public TextBox getTxtSyutsuryokukomoku9() {
        return this.getHanyoListJigyoTaishosha().getTxtSyutsuryokukomoku9();
    }

    @JsonIgnore
    public void  setTxtSyutsuryokukomoku9(TextBox txtSyutsuryokukomoku9) {
        this.getHanyoListJigyoTaishosha().setTxtSyutsuryokukomoku9(txtSyutsuryokukomoku9);
    }

    @JsonIgnore
    public DropDownList getDdlCyusyutsuhohokubun10() {
        return this.getHanyoListRiyoshaFutanwariai().getDdlCyusyutsuhohokubun10();
    }

    @JsonIgnore
    public void  setDdlCyusyutsuhohokubun10(DropDownList ddlCyusyutsuhohokubun10) {
        this.getHanyoListRiyoshaFutanwariai().setDdlCyusyutsuhohokubun10(ddlCyusyutsuhohokubun10);
    }

    @JsonIgnore
    public TextBoxFlexibleYear getTxtNendo10() {
        return this.getHanyoListRiyoshaFutanwariai().getTxtNendo10();
    }

    @JsonIgnore
    public void  setTxtNendo10(TextBoxFlexibleYear txtNendo10) {
        this.getHanyoListRiyoshaFutanwariai().setTxtNendo10(txtNendo10);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtKizyunnichi10() {
        return this.getHanyoListRiyoshaFutanwariai().getTxtKizyunnichi10();
    }

    @JsonIgnore
    public void  setTxtKizyunnichi10(TextBoxFlexibleDate txtKizyunnichi10) {
        this.getHanyoListRiyoshaFutanwariai().setTxtKizyunnichi10(txtKizyunnichi10);
    }

    @JsonIgnore
    public DropDownList getDdlIsNendochokindatacyusyutsu10() {
        return this.getHanyoListRiyoshaFutanwariai().getDdlIsNendochokindatacyusyutsu10();
    }

    @JsonIgnore
    public void  setDdlIsNendochokindatacyusyutsu10(DropDownList ddlIsNendochokindatacyusyutsu10) {
        this.getHanyoListRiyoshaFutanwariai().setDdlIsNendochokindatacyusyutsu10(ddlIsNendochokindatacyusyutsu10);
    }

    @JsonIgnore
    public DropDownList getDdlIsJigyotaishoshafutanichiwari10() {
        return this.getHanyoListRiyoshaFutanwariai().getDdlIsJigyotaishoshafutanichiwari10();
    }

    @JsonIgnore
    public void  setDdlIsJigyotaishoshafutanichiwari10(DropDownList ddlIsJigyotaishoshafutanichiwari10) {
        this.getHanyoListRiyoshaFutanwariai().setDdlIsJigyotaishoshafutanichiwari10(ddlIsJigyotaishoshafutanichiwari10);
    }

    @JsonIgnore
    public DropDownList getDdlIsJigyotaishoshafutanniwari10() {
        return this.getHanyoListRiyoshaFutanwariai().getDdlIsJigyotaishoshafutanniwari10();
    }

    @JsonIgnore
    public void  setDdlIsJigyotaishoshafutanniwari10(DropDownList ddlIsJigyotaishoshafutanniwari10) {
        this.getHanyoListRiyoshaFutanwariai().setDdlIsJigyotaishoshafutanniwari10(ddlIsJigyotaishoshafutanniwari10);
    }

    @JsonIgnore
    public DropDownList getDdlIsCsvkomokumeifuka10() {
        return this.getHanyoListRiyoshaFutanwariai().getDdlIsCsvkomokumeifuka10();
    }

    @JsonIgnore
    public void  setDdlIsCsvkomokumeifuka10(DropDownList ddlIsCsvkomokumeifuka10) {
        this.getHanyoListRiyoshaFutanwariai().setDdlIsCsvkomokumeifuka10(ddlIsCsvkomokumeifuka10);
    }

    @JsonIgnore
    public DropDownList getDdlIsCsvrenbanfuka10() {
        return this.getHanyoListRiyoshaFutanwariai().getDdlIsCsvrenbanfuka10();
    }

    @JsonIgnore
    public void  setDdlIsCsvrenbanfuka10(DropDownList ddlIsCsvrenbanfuka10) {
        this.getHanyoListRiyoshaFutanwariai().setDdlIsCsvrenbanfuka10(ddlIsCsvrenbanfuka10);
    }

    @JsonIgnore
    public DropDownList getDdlIsCsvhitsukesurasyuhensyu10() {
        return this.getHanyoListRiyoshaFutanwariai().getDdlIsCsvhitsukesurasyuhensyu10();
    }

    @JsonIgnore
    public void  setDdlIsCsvhitsukesurasyuhensyu10(DropDownList ddlIsCsvhitsukesurasyuhensyu10) {
        this.getHanyoListRiyoshaFutanwariai().setDdlIsCsvhitsukesurasyuhensyu10(ddlIsCsvhitsukesurasyuhensyu10);
    }

    @JsonIgnore
    public TextBox getTxtCyohyoid10() {
        return this.getHanyoListRiyoshaFutanwariai().getTxtCyohyoid10();
    }

    @JsonIgnore
    public void  setTxtCyohyoid10(TextBox txtCyohyoid10) {
        this.getHanyoListRiyoshaFutanwariai().setTxtCyohyoid10(txtCyohyoid10);
    }

    @JsonIgnore
    public TextBox getTxtSyutsuryokukomoku10() {
        return this.getHanyoListRiyoshaFutanwariai().getTxtSyutsuryokukomoku10();
    }

    @JsonIgnore
    public void  setTxtSyutsuryokukomoku10(TextBox txtSyutsuryokukomoku10) {
        this.getHanyoListRiyoshaFutanwariai().setTxtSyutsuryokukomoku10(txtSyutsuryokukomoku10);
    }

    @JsonIgnore
    public DropDownList getDdlAgeSelectKijun() {
        return this.getChushutsuJoken().getDdlAgeSelectKijun();
    }

    @JsonIgnore
    public void  setDdlAgeSelectKijun(DropDownList ddlAgeSelectKijun) {
        this.getChushutsuJoken().setDdlAgeSelectKijun(ddlAgeSelectKijun);
    }

    @JsonIgnore
    public TextBoxNumRange getTxtNenreiRange() {
        return this.getChushutsuJoken().getTxtNenreiRange();
    }

    @JsonIgnore
    public void  setTxtNenreiRange(TextBoxNumRange txtNenreiRange) {
        this.getChushutsuJoken().setTxtNenreiRange(txtNenreiRange);
    }

    @JsonIgnore
    public TextBoxDate getTxtNenreiKijunbi() {
        return this.getChushutsuJoken().getTxtNenreiKijunbi();
    }

    @JsonIgnore
    public void  setTxtNenreiKijunbi(TextBoxDate txtNenreiKijunbi) {
        this.getChushutsuJoken().setTxtNenreiKijunbi(txtNenreiKijunbi);
    }

    @JsonIgnore
    public TextBoxDateRange getTxtSeinengappiRange() {
        return this.getChushutsuJoken().getTxtSeinengappiRange();
    }

    @JsonIgnore
    public void  setTxtSeinengappiRange(TextBoxDateRange txtSeinengappiRange) {
        this.getChushutsuJoken().setTxtSeinengappiRange(txtSeinengappiRange);
    }

    @JsonIgnore
    public TextBoxCode getTxtShichosonCode() {
        return this.getChushutsuJoken().getTxtShichosonCode();
    }

    @JsonIgnore
    public void  setTxtShichosonCode(TextBoxCode txtShichosonCode) {
        this.getChushutsuJoken().setTxtShichosonCode(txtShichosonCode);
    }

    @JsonIgnore
    public TextBox getTxtShichosonMesho() {
        return this.getChushutsuJoken().getTxtShichosonMesho();
    }

    @JsonIgnore
    public void  setTxtShichosonMesho(TextBox txtShichosonMesho) {
        this.getChushutsuJoken().setTxtShichosonMesho(txtShichosonMesho);
    }

    @JsonIgnore
    public DropDownList getDdlChikuKubun() {
        return this.getChushutsuJoken().getDdlChikuKubun();
    }

    @JsonIgnore
    public void  setDdlChikuKubun(DropDownList ddlChikuKubun) {
        this.getChushutsuJoken().setDdlChikuKubun(ddlChikuKubun);
    }

    @JsonIgnore
    public TextBox getTxtJushoFrom() {
        return this.getChushutsuJoken().getTxtJushoFrom();
    }

    @JsonIgnore
    public void  setTxtJushoFrom(TextBox txtJushoFrom) {
        this.getChushutsuJoken().setTxtJushoFrom(txtJushoFrom);
    }

    @JsonIgnore
    public TextBox getTxtJushoFromMesho() {
        return this.getChushutsuJoken().getTxtJushoFromMesho();
    }

    @JsonIgnore
    public void  setTxtJushoFromMesho(TextBox txtJushoFromMesho) {
        this.getChushutsuJoken().setTxtJushoFromMesho(txtJushoFromMesho);
    }

    @JsonIgnore
    public TextBox getTxtJushoTo() {
        return this.getChushutsuJoken().getTxtJushoTo();
    }

    @JsonIgnore
    public void  setTxtJushoTo(TextBox txtJushoTo) {
        this.getChushutsuJoken().setTxtJushoTo(txtJushoTo);
    }

    @JsonIgnore
    public TextBox getTxtJushoToMesho() {
        return this.getChushutsuJoken().getTxtJushoToMesho();
    }

    @JsonIgnore
    public void  setTxtJushoToMesho(TextBox txtJushoToMesho) {
        this.getChushutsuJoken().setTxtJushoToMesho(txtJushoToMesho);
    }

    @JsonIgnore
    public TextBox getTxtGyoseikuFrom() {
        return this.getChushutsuJoken().getTxtGyoseikuFrom();
    }

    @JsonIgnore
    public void  setTxtGyoseikuFrom(TextBox txtGyoseikuFrom) {
        this.getChushutsuJoken().setTxtGyoseikuFrom(txtGyoseikuFrom);
    }

    @JsonIgnore
    public TextBox getTxtGyoseikuFromMesho() {
        return this.getChushutsuJoken().getTxtGyoseikuFromMesho();
    }

    @JsonIgnore
    public void  setTxtGyoseikuFromMesho(TextBox txtGyoseikuFromMesho) {
        this.getChushutsuJoken().setTxtGyoseikuFromMesho(txtGyoseikuFromMesho);
    }

    @JsonIgnore
    public TextBox getTxtGyoseikuTo() {
        return this.getChushutsuJoken().getTxtGyoseikuTo();
    }

    @JsonIgnore
    public void  setTxtGyoseikuTo(TextBox txtGyoseikuTo) {
        this.getChushutsuJoken().setTxtGyoseikuTo(txtGyoseikuTo);
    }

    @JsonIgnore
    public TextBox getTxtGyoseikuToMesho() {
        return this.getChushutsuJoken().getTxtGyoseikuToMesho();
    }

    @JsonIgnore
    public void  setTxtGyoseikuToMesho(TextBox txtGyoseikuToMesho) {
        this.getChushutsuJoken().setTxtGyoseikuToMesho(txtGyoseikuToMesho);
    }

    @JsonIgnore
    public TextBox getTxtChiku1From() {
        return this.getChushutsuJoken().getTxtChiku1From();
    }

    @JsonIgnore
    public void  setTxtChiku1From(TextBox txtChiku1From) {
        this.getChushutsuJoken().setTxtChiku1From(txtChiku1From);
    }

    @JsonIgnore
    public TextBox getTxtChiku1FromMesho() {
        return this.getChushutsuJoken().getTxtChiku1FromMesho();
    }

    @JsonIgnore
    public void  setTxtChiku1FromMesho(TextBox txtChiku1FromMesho) {
        this.getChushutsuJoken().setTxtChiku1FromMesho(txtChiku1FromMesho);
    }

    @JsonIgnore
    public TextBox getTxtChiku1To() {
        return this.getChushutsuJoken().getTxtChiku1To();
    }

    @JsonIgnore
    public void  setTxtChiku1To(TextBox txtChiku1To) {
        this.getChushutsuJoken().setTxtChiku1To(txtChiku1To);
    }

    @JsonIgnore
    public TextBox getTxtChiku1ToMesho() {
        return this.getChushutsuJoken().getTxtChiku1ToMesho();
    }

    @JsonIgnore
    public void  setTxtChiku1ToMesho(TextBox txtChiku1ToMesho) {
        this.getChushutsuJoken().setTxtChiku1ToMesho(txtChiku1ToMesho);
    }

    @JsonIgnore
    public TextBox getTxtChiku2From() {
        return this.getChushutsuJoken().getTxtChiku2From();
    }

    @JsonIgnore
    public void  setTxtChiku2From(TextBox txtChiku2From) {
        this.getChushutsuJoken().setTxtChiku2From(txtChiku2From);
    }

    @JsonIgnore
    public TextBox getTxtChiku2FromMesho() {
        return this.getChushutsuJoken().getTxtChiku2FromMesho();
    }

    @JsonIgnore
    public void  setTxtChiku2FromMesho(TextBox txtChiku2FromMesho) {
        this.getChushutsuJoken().setTxtChiku2FromMesho(txtChiku2FromMesho);
    }

    @JsonIgnore
    public TextBox getTxtChiku2To() {
        return this.getChushutsuJoken().getTxtChiku2To();
    }

    @JsonIgnore
    public void  setTxtChiku2To(TextBox txtChiku2To) {
        this.getChushutsuJoken().setTxtChiku2To(txtChiku2To);
    }

    @JsonIgnore
    public TextBox getTxtChiku2ToMesho() {
        return this.getChushutsuJoken().getTxtChiku2ToMesho();
    }

    @JsonIgnore
    public void  setTxtChiku2ToMesho(TextBox txtChiku2ToMesho) {
        this.getChushutsuJoken().setTxtChiku2ToMesho(txtChiku2ToMesho);
    }

    @JsonIgnore
    public TextBox getTxtChiku3From() {
        return this.getChushutsuJoken().getTxtChiku3From();
    }

    @JsonIgnore
    public void  setTxtChiku3From(TextBox txtChiku3From) {
        this.getChushutsuJoken().setTxtChiku3From(txtChiku3From);
    }

    @JsonIgnore
    public TextBox getTxtChiku3FromMesho() {
        return this.getChushutsuJoken().getTxtChiku3FromMesho();
    }

    @JsonIgnore
    public void  setTxtChiku3FromMesho(TextBox txtChiku3FromMesho) {
        this.getChushutsuJoken().setTxtChiku3FromMesho(txtChiku3FromMesho);
    }

    @JsonIgnore
    public TextBox getTxtChiku3To() {
        return this.getChushutsuJoken().getTxtChiku3To();
    }

    @JsonIgnore
    public void  setTxtChiku3To(TextBox txtChiku3To) {
        this.getChushutsuJoken().setTxtChiku3To(txtChiku3To);
    }

    @JsonIgnore
    public TextBox getTxtChiku3ToMesho() {
        return this.getChushutsuJoken().getTxtChiku3ToMesho();
    }

    @JsonIgnore
    public void  setTxtChiku3ToMesho(TextBox txtChiku3ToMesho) {
        this.getChushutsuJoken().setTxtChiku3ToMesho(txtChiku3ToMesho);
    }

    // </editor-fold>
}
