package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC8120012;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.kaigoatenainfo.KaigoAtenaInfo.IKaigoAtenaInfoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.kaigoatenainfo.KaigoAtenaInfo.KaigoAtenaInfoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.kaigoshikakukihon.KaigoShikakuKihon.IKaigoShikakuKihonDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.kaigoshikakukihon.KaigoShikakuKihon.KaigoShikakuKihonDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.PanelBatchParameter;

/**
 * JigyobunShikyugakuKeisanKekkaRenrakuhyoPanel のクラスファイル 
 * 
 * @author 自動生成
 */
public class JigyobunShikyugakuKeisanKekkaRenrakuhyoPanelDiv extends PanelBatchParameter {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-07-28_11-34-20">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("SakuseiPanel")
    private SakuseiPanelDiv SakuseiPanel;
    @JsonProperty("ccdKaigoShikakuKihon")
    private KaigoShikakuKihonDiv ccdKaigoShikakuKihon;
    @JsonProperty("cclKaigoAtenaInfo")
    private KaigoAtenaInfoDiv cclKaigoAtenaInfo;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getSakuseiPanel
     * @return SakuseiPanel
     */
    @JsonProperty("SakuseiPanel")
    public SakuseiPanelDiv getSakuseiPanel() {
        return SakuseiPanel;
    }

    /*
     * setSakuseiPanel
     * @param SakuseiPanel SakuseiPanel
     */
    @JsonProperty("SakuseiPanel")
    public void setSakuseiPanel(SakuseiPanelDiv SakuseiPanel) {
        this.SakuseiPanel = SakuseiPanel;
    }

    /*
     * getccdKaigoShikakuKihon
     * @return ccdKaigoShikakuKihon
     */
    @JsonProperty("ccdKaigoShikakuKihon")
    public IKaigoShikakuKihonDiv getCcdKaigoShikakuKihon() {
        return ccdKaigoShikakuKihon;
    }

    /*
     * getcclKaigoAtenaInfo
     * @return cclKaigoAtenaInfo
     */
    @JsonProperty("cclKaigoAtenaInfo")
    public IKaigoAtenaInfoDiv getCclKaigoAtenaInfo() {
        return cclKaigoAtenaInfo;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public DropDownList getDdlTaishoNendo() {
        return this.getSakuseiPanel().getDdlTaishoNendo();
    }

    @JsonIgnore
    public void  setDdlTaishoNendo(DropDownList ddlTaishoNendo) {
        this.getSakuseiPanel().setDdlTaishoNendo(ddlTaishoNendo);
    }

    @JsonIgnore
    public DropDownList getDdlShikyuShinseishoSeiriNo() {
        return this.getSakuseiPanel().getDdlShikyuShinseishoSeiriNo();
    }

    @JsonIgnore
    public void  setDdlShikyuShinseishoSeiriNo(DropDownList ddlShikyuShinseishoSeiriNo) {
        this.getSakuseiPanel().setDdlShikyuShinseishoSeiriNo(ddlShikyuShinseishoSeiriNo);
    }

    @JsonIgnore
    public DropDownList getDdlShoKisaiHokenshaNo() {
        return this.getSakuseiPanel().getDdlShoKisaiHokenshaNo();
    }

    @JsonIgnore
    public void  setDdlShoKisaiHokenshaNo(DropDownList ddlShoKisaiHokenshaNo) {
        this.getSakuseiPanel().setDdlShoKisaiHokenshaNo(ddlShoKisaiHokenshaNo);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtSakuseiYMD() {
        return this.getSakuseiPanel().getTxtSakuseiYMD();
    }

    @JsonIgnore
    public void  setTxtSakuseiYMD(TextBoxFlexibleDate txtSakuseiYMD) {
        this.getSakuseiPanel().setTxtSakuseiYMD(txtSakuseiYMD);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtZenkaiSakuseiYMD() {
        return this.getSakuseiPanel().getTxtZenkaiSakuseiYMD();
    }

    @JsonIgnore
    public void  setTxtZenkaiSakuseiYMD(TextBoxFlexibleDate txtZenkaiSakuseiYMD) {
        this.getSakuseiPanel().setTxtZenkaiSakuseiYMD(txtZenkaiSakuseiYMD);
    }

    // </editor-fold>
}
