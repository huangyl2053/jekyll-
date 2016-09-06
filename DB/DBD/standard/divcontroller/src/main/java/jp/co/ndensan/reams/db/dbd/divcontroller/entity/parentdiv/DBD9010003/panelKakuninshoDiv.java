package jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD9010003;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.KaigoKanryoMessage.KaigoKanryoMessage.IKaigoKanryoMessageDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.KaigoKanryoMessage.KaigoKanryoMessage.KaigoKanryoMessageDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.bunshobangoinput.BunshoBangoInput.BunshoBangoInputDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.bunshobangoinput.BunshoBangoInput.IBunshoBangoInputDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.kaigoatenainfo.KaigoAtenaInfo.IKaigoAtenaInfoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.kaigoatenainfo.KaigoAtenaInfo.KaigoAtenaInfoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.kaigoshikakukihon.KaigoShikakuKihon.IKaigoShikakuKihonDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.kaigoshikakukihon.KaigoShikakuKihon.KaigoShikakuKihonDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * panelKakuninsho のクラスファイル 
 * 
 * @author 自動生成
 */
public class panelKakuninshoDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-21_20-30-14">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ccdKaigoShikakuKihon")
    private KaigoShikakuKihonDiv ccdKaigoShikakuKihon;
    @JsonProperty("ccdKaigoKanryoMessage")
    private KaigoKanryoMessageDiv ccdKaigoKanryoMessage;
    @JsonProperty("panelShosaiEria")
    private panelShosaiEriaDiv panelShosaiEria;
    @JsonProperty("ccdKaigoAtenaInfo")
    private KaigoAtenaInfoDiv ccdKaigoAtenaInfo;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getccdKaigoShikakuKihon
     * @return ccdKaigoShikakuKihon
     */
    @JsonProperty("ccdKaigoShikakuKihon")
    public IKaigoShikakuKihonDiv getCcdKaigoShikakuKihon() {
        return ccdKaigoShikakuKihon;
    }

    /*
     * getccdKaigoKanryoMessage
     * @return ccdKaigoKanryoMessage
     */
    @JsonProperty("ccdKaigoKanryoMessage")
    public IKaigoKanryoMessageDiv getCcdKaigoKanryoMessage() {
        return ccdKaigoKanryoMessage;
    }

    /*
     * getpanelShosaiEria
     * @return panelShosaiEria
     */
    @JsonProperty("panelShosaiEria")
    public panelShosaiEriaDiv getPanelShosaiEria() {
        return panelShosaiEria;
    }

    /*
     * setpanelShosaiEria
     * @param panelShosaiEria panelShosaiEria
     */
    @JsonProperty("panelShosaiEria")
    public void setPanelShosaiEria(panelShosaiEriaDiv panelShosaiEria) {
        this.panelShosaiEria = panelShosaiEria;
    }

    /*
     * getccdKaigoAtenaInfo
     * @return ccdKaigoAtenaInfo
     */
    @JsonProperty("ccdKaigoAtenaInfo")
    public IKaigoAtenaInfoDiv getCcdKaigoAtenaInfo() {
        return ccdKaigoAtenaInfo;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public TextBox getTxtCyouhyou() {
        return this.getPanelShosaiEria().getTxtCyouhyou();
    }

    @JsonIgnore
    public void  setTxtCyouhyou(TextBox txtCyouhyou) {
        this.getPanelShosaiEria().setTxtCyouhyou(txtCyouhyou);
    }

    @JsonIgnore
    public TextBoxDate getTxtSakuseiBi() {
        return this.getPanelShosaiEria().getTxtSakuseiBi();
    }

    @JsonIgnore
    public void  setTxtSakuseiBi(TextBoxDate txtSakuseiBi) {
        this.getPanelShosaiEria().setTxtSakuseiBi(txtSakuseiBi);
    }

    @JsonIgnore
    public TextBoxDate getTxtZenkaiHakkouBi() {
        return this.getPanelShosaiEria().getTxtZenkaiHakkouBi();
    }

    @JsonIgnore
    public void  setTxtZenkaiHakkouBi(TextBoxDate txtZenkaiHakkouBi) {
        this.getPanelShosaiEria().setTxtZenkaiHakkouBi(txtZenkaiHakkouBi);
    }

    @JsonIgnore
    public DropDownList getDdlTaishonen() {
        return this.getPanelShosaiEria().getDdlTaishonen();
    }

    @JsonIgnore
    public void  setDdlTaishonen(DropDownList ddlTaishonen) {
        this.getPanelShosaiEria().setDdlTaishonen(ddlTaishonen);
    }

    @JsonIgnore
    public TextBoxDate getTxtShinseiBi() {
        return this.getPanelShosaiEria().getTxtShinseiBi();
    }

    @JsonIgnore
    public void  setTxtShinseiBi(TextBoxDate txtShinseiBi) {
        this.getPanelShosaiEria().setTxtShinseiBi(txtShinseiBi);
    }

    @JsonIgnore
    public TextBoxDate getTxtDateIkensyoSakuseiBi() {
        return this.getPanelShosaiEria().getTxtDateIkensyoSakuseiBi();
    }

    @JsonIgnore
    public void  setTxtDateIkensyoSakuseiBi(TextBoxDate txtDateIkensyoSakuseiBi) {
        this.getPanelShosaiEria().setTxtDateIkensyoSakuseiBi(txtDateIkensyoSakuseiBi);
    }

    @JsonIgnore
    public TextBoxDateRange getTxtNinteiKikan() {
        return this.getPanelShosaiEria().getTxtNinteiKikan();
    }

    @JsonIgnore
    public void  setTxtNinteiKikan(TextBoxDateRange txtNinteiKikan) {
        this.getPanelShosaiEria().setTxtNinteiKikan(txtNinteiKikan);
    }

    @JsonIgnore
    public TextBox getTxtZiritudo() {
        return this.getPanelShosaiEria().getTxtZiritudo();
    }

    @JsonIgnore
    public void  setTxtZiritudo(TextBox txtZiritudo) {
        this.getPanelShosaiEria().setTxtZiritudo(txtZiritudo);
    }

    @JsonIgnore
    public TextBox getTxtNyoushikkin() {
        return this.getPanelShosaiEria().getTxtNyoushikkin();
    }

    @JsonIgnore
    public void  setTxtNyoushikkin(TextBox txtNyoushikkin) {
        this.getPanelShosaiEria().setTxtNyoushikkin(txtNyoushikkin);
    }

    @JsonIgnore
    public IBunshoBangoInputDiv getCcdBunshoBangoInput() {
        return this.getPanelShosaiEria().getCcdBunshoBangoInput();
    }

    // </editor-fold>
}
