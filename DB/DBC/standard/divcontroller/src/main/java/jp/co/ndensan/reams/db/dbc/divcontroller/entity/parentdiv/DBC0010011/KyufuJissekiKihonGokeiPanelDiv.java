package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0010011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * KyufuJissekiKihonGokeiPanel のクラスファイル 
 * 
 * @author 自動生成
 */
public class KyufuJissekiKihonGokeiPanelDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-06-27_21-36-36">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("tblKihonGokei")
    private tblKihonGokeiDiv tblKihonGokei;
    @JsonProperty("btnKyufuJissekiKihonGokeiClose")
    private Button btnKyufuJissekiKihonGokeiClose;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettblKihonGokei
     * @return tblKihonGokei
     */
    @JsonProperty("tblKihonGokei")
    public tblKihonGokeiDiv getTblKihonGokei() {
        return tblKihonGokei;
    }

    /*
     * settblKihonGokei
     * @param tblKihonGokei tblKihonGokei
     */
    @JsonProperty("tblKihonGokei")
    public void setTblKihonGokei(tblKihonGokeiDiv tblKihonGokei) {
        this.tblKihonGokei = tblKihonGokei;
    }

    /*
     * getbtnKyufuJissekiKihonGokeiClose
     * @return btnKyufuJissekiKihonGokeiClose
     */
    @JsonProperty("btnKyufuJissekiKihonGokeiClose")
    public Button getBtnKyufuJissekiKihonGokeiClose() {
        return btnKyufuJissekiKihonGokeiClose;
    }

    /*
     * setbtnKyufuJissekiKihonGokeiClose
     * @param btnKyufuJissekiKihonGokeiClose btnKyufuJissekiKihonGokeiClose
     */
    @JsonProperty("btnKyufuJissekiKihonGokeiClose")
    public void setBtnKyufuJissekiKihonGokeiClose(Button btnKyufuJissekiKihonGokeiClose) {
        this.btnKyufuJissekiKihonGokeiClose = btnKyufuJissekiKihonGokeiClose;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public Label getLblHoken() {
        return this.getTblKihonGokei().getLblHoken();
    }

    @JsonIgnore
    public Label getLblKohi1() {
        return this.getTblKihonGokei().getLblKohi1();
    }

    @JsonIgnore
    public Label getLblKohi2() {
        return this.getTblKihonGokei().getLblKohi2();
    }

    @JsonIgnore
    public Label getLblKohi3() {
        return this.getTblKihonGokei().getLblKohi3();
    }

    @JsonIgnore
    public Label getLblHokenKetteiMae() {
        return this.getTblKihonGokei().getLblHokenKetteiMae();
    }

    @JsonIgnore
    public Label getLblHokenKetteiGo() {
        return this.getTblKihonGokei().getLblHokenKetteiGo();
    }

    @JsonIgnore
    public Label getLblKohi1KetteiMae() {
        return this.getTblKihonGokei().getLblKohi1KetteiMae();
    }

    @JsonIgnore
    public Label getLblKohi1KetteiGo() {
        return this.getTblKihonGokei().getLblKohi1KetteiGo();
    }

    @JsonIgnore
    public Label getLblKohi2KetteiMae() {
        return this.getTblKihonGokei().getLblKohi2KetteiMae();
    }

    @JsonIgnore
    public Label getLblKohi1Ketteigo() {
        return this.getTblKihonGokei().getLblKohi1Ketteigo();
    }

    @JsonIgnore
    public Label getLblKohi3KetteiMae() {
        return this.getTblKihonGokei().getLblKohi3KetteiMae();
    }

    @JsonIgnore
    public Label getLblKohi3KetteiGo() {
        return this.getTblKihonGokei().getLblKohi3KetteiGo();
    }

    @JsonIgnore
    public Label getLblServiceTankasu() {
        return this.getTblKihonGokei().getLblServiceTankasu();
    }

    @JsonIgnore
    public Label getLblHokenryoSeikyuGaku() {
        return this.getTblKihonGokei().getLblHokenryoSeikyuGaku();
    }

    @JsonIgnore
    public Label getLblRiyoshaFutanGaku() {
        return this.getTblKihonGokei().getLblRiyoshaFutanGaku();
    }

    @JsonIgnore
    public Label getLblKinkyujiShisetsuRyoyohiHokenSeikyubunGokei() {
        return this.getTblKihonGokei().getLblKinkyujiShisetsuRyoyohiHokenSeikyubunGokei();
    }

    @JsonIgnore
    public Label getLblTokuteiShinryohiKohiSeikyubunGokei() {
        return this.getTblKihonGokei().getLblTokuteiShinryohiKohiSeikyubunGokei();
    }

    @JsonIgnore
    public Label getLblTokuteiNyushoshaKaigoto() {
        return this.getTblKihonGokei().getLblTokuteiNyushoshaKaigoto();
    }

    // </editor-fold>
}
