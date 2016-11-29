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
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-11-04_20-51-13">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("tblKihonGokei")
    private tblKihonGokeiDiv tblKihonGokei;

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
    public TextBoxNum getTxtMaeHokenServiceTanisu() {
        return this.getTblKihonGokei().getTxtMaeHokenServiceTanisu();
    }

    @JsonIgnore
    public TextBoxNum getTxtGoHokenServiceTanisu() {
        return this.getTblKihonGokei().getTxtGoHokenServiceTanisu();
    }

    @JsonIgnore
    public TextBoxNum getTxtMaeKohi1ServiceTanisu() {
        return this.getTblKihonGokei().getTxtMaeKohi1ServiceTanisu();
    }

    @JsonIgnore
    public TextBoxNum getTxtGoKohi1ServiceTanisu() {
        return this.getTblKihonGokei().getTxtGoKohi1ServiceTanisu();
    }

    @JsonIgnore
    public TextBoxNum getTxtMaeKohi2ServiceTanisu() {
        return this.getTblKihonGokei().getTxtMaeKohi2ServiceTanisu();
    }

    @JsonIgnore
    public TextBoxNum getTxtGoKohi2ServiceTanisu() {
        return this.getTblKihonGokei().getTxtGoKohi2ServiceTanisu();
    }

    @JsonIgnore
    public TextBoxNum getTxtMaeKohi3ServiceTanisu() {
        return this.getTblKihonGokei().getTxtMaeKohi3ServiceTanisu();
    }

    @JsonIgnore
    public TextBoxNum getTxtGoKohi3ServiceTanisu() {
        return this.getTblKihonGokei().getTxtGoKohi3ServiceTanisu();
    }

    @JsonIgnore
    public Label getLblHokenryoSeikyuGaku() {
        return this.getTblKihonGokei().getLblHokenryoSeikyuGaku();
    }

    @JsonIgnore
    public TextBoxNum getTxtMaeHokenHokenSeikyugaku() {
        return this.getTblKihonGokei().getTxtMaeHokenHokenSeikyugaku();
    }

    @JsonIgnore
    public TextBoxNum getTxtGoHokenHokenSeikyugaku() {
        return this.getTblKihonGokei().getTxtGoHokenHokenSeikyugaku();
    }

    @JsonIgnore
    public TextBoxNum getTxtMaeKohi1HokenSeikyugaku() {
        return this.getTblKihonGokei().getTxtMaeKohi1HokenSeikyugaku();
    }

    @JsonIgnore
    public TextBoxNum getTxtGoKohi1HokenSeikyugaku() {
        return this.getTblKihonGokei().getTxtGoKohi1HokenSeikyugaku();
    }

    @JsonIgnore
    public TextBoxNum getTxtMaeKohi2HokenSeikyugaku() {
        return this.getTblKihonGokei().getTxtMaeKohi2HokenSeikyugaku();
    }

    @JsonIgnore
    public TextBoxNum getTxtGoKohi2HokenSeikyugaku() {
        return this.getTblKihonGokei().getTxtGoKohi2HokenSeikyugaku();
    }

    @JsonIgnore
    public TextBoxNum getTxtMaeKohi3HokenSeikyugaku() {
        return this.getTblKihonGokei().getTxtMaeKohi3HokenSeikyugaku();
    }

    @JsonIgnore
    public TextBoxNum getTxtGoKohi3HokenSeikyugaku() {
        return this.getTblKihonGokei().getTxtGoKohi3HokenSeikyugaku();
    }

    @JsonIgnore
    public Label getLblRiyoshaFutanGaku() {
        return this.getTblKihonGokei().getLblRiyoshaFutanGaku();
    }

    @JsonIgnore
    public TextBoxNum getTxtMaeHokenRiyoshaFutangaku() {
        return this.getTblKihonGokei().getTxtMaeHokenRiyoshaFutangaku();
    }

    @JsonIgnore
    public TextBoxNum getTxtGoHokenRiyoshaFutangaku() {
        return this.getTblKihonGokei().getTxtGoHokenRiyoshaFutangaku();
    }

    @JsonIgnore
    public TextBoxNum getTxtMaeKohi1RiyoshaFutangaku() {
        return this.getTblKihonGokei().getTxtMaeKohi1RiyoshaFutangaku();
    }

    @JsonIgnore
    public TextBoxNum getTxtGoKohi1RiyoshaFutangaku() {
        return this.getTblKihonGokei().getTxtGoKohi1RiyoshaFutangaku();
    }

    @JsonIgnore
    public TextBoxNum getTxtMaeKohi2RiyoshaFutangaku() {
        return this.getTblKihonGokei().getTxtMaeKohi2RiyoshaFutangaku();
    }

    @JsonIgnore
    public TextBoxNum getTxtGoKohi2RiyoshaFutangaku() {
        return this.getTblKihonGokei().getTxtGoKohi2RiyoshaFutangaku();
    }

    @JsonIgnore
    public TextBoxNum getTxtMaeKohi3RiyoshaFutangaku() {
        return this.getTblKihonGokei().getTxtMaeKohi3RiyoshaFutangaku();
    }

    @JsonIgnore
    public TextBoxNum getTxtGoKohi3RiyoshaFutangaku() {
        return this.getTblKihonGokei().getTxtGoKohi3RiyoshaFutangaku();
    }

    @JsonIgnore
    public Label getLblKinkyujiShisetsuRyoyohiHokenSeikyubunGokei() {
        return this.getTblKihonGokei().getLblKinkyujiShisetsuRyoyohiHokenSeikyubunGokei();
    }

    @JsonIgnore
    public TextBoxNum getTxtMaeHokenKinkyujiShisetsuRyoyohi() {
        return this.getTblKihonGokei().getTxtMaeHokenKinkyujiShisetsuRyoyohi();
    }

    @JsonIgnore
    public TextBoxNum getTxtGoHokenKinkyujiShisetsuRyoyohi() {
        return this.getTblKihonGokei().getTxtGoHokenKinkyujiShisetsuRyoyohi();
    }

    @JsonIgnore
    public TextBoxNum getTxtMaeKohi1KinkyujiShisetsuRyoyohi() {
        return this.getTblKihonGokei().getTxtMaeKohi1KinkyujiShisetsuRyoyohi();
    }

    @JsonIgnore
    public TextBoxNum getTxtGoKohi1KinkyujiShisetsuRyoyohi() {
        return this.getTblKihonGokei().getTxtGoKohi1KinkyujiShisetsuRyoyohi();
    }

    @JsonIgnore
    public TextBoxNum getTxtMaeKohi2KinkyujiShisetsuRyoyohi() {
        return this.getTblKihonGokei().getTxtMaeKohi2KinkyujiShisetsuRyoyohi();
    }

    @JsonIgnore
    public TextBoxNum getTxtGoKohi2KinkyujiShisetsuRyoyohi() {
        return this.getTblKihonGokei().getTxtGoKohi2KinkyujiShisetsuRyoyohi();
    }

    @JsonIgnore
    public TextBoxNum getTxtMaeKohi3KinkyujiShisetsuRyoyohi() {
        return this.getTblKihonGokei().getTxtMaeKohi3KinkyujiShisetsuRyoyohi();
    }

    @JsonIgnore
    public TextBoxNum getTxtGoKohi3KinkyujiShisetsuRyoyohi() {
        return this.getTblKihonGokei().getTxtGoKohi3KinkyujiShisetsuRyoyohi();
    }

    @JsonIgnore
    public Label getLblTokuteiShinryohiKohiSeikyubunGokei() {
        return this.getTblKihonGokei().getLblTokuteiShinryohiKohiSeikyubunGokei();
    }

    @JsonIgnore
    public TextBoxNum getTxtMaeHokenTokuteiShinryohi() {
        return this.getTblKihonGokei().getTxtMaeHokenTokuteiShinryohi();
    }

    @JsonIgnore
    public TextBoxNum getTxtGoHokenTokuteiShinryohi() {
        return this.getTblKihonGokei().getTxtGoHokenTokuteiShinryohi();
    }

    @JsonIgnore
    public TextBoxNum getTxtMaeKohi1TokuteiShinryohi() {
        return this.getTblKihonGokei().getTxtMaeKohi1TokuteiShinryohi();
    }

    @JsonIgnore
    public TextBoxNum getTxtGoKohi1TokuteiShinryohi() {
        return this.getTblKihonGokei().getTxtGoKohi1TokuteiShinryohi();
    }

    @JsonIgnore
    public TextBoxNum getTxtMaeKohi2TokuteiShinryohi() {
        return this.getTblKihonGokei().getTxtMaeKohi2TokuteiShinryohi();
    }

    @JsonIgnore
    public TextBoxNum getTxtGoKohi2TokuteiShinryohi() {
        return this.getTblKihonGokei().getTxtGoKohi2TokuteiShinryohi();
    }

    @JsonIgnore
    public TextBoxNum getTxtMaeKohi3TokuteiShinryohi() {
        return this.getTblKihonGokei().getTxtMaeKohi3TokuteiShinryohi();
    }

    @JsonIgnore
    public TextBoxNum getTxtGoKohi3TokuteiShinryohi() {
        return this.getTblKihonGokei().getTxtGoKohi3TokuteiShinryohi();
    }

    @JsonIgnore
    public Label getLblTokuteiNyushoshaKaigoto() {
        return this.getTblKihonGokei().getLblTokuteiNyushoshaKaigoto();
    }

    @JsonIgnore
    public TextBoxNum getTxtMaeHokenTokuteiNyushosha() {
        return this.getTblKihonGokei().getTxtMaeHokenTokuteiNyushosha();
    }

    @JsonIgnore
    public TextBoxNum getTxtGoHokenTokuteiNyushosha() {
        return this.getTblKihonGokei().getTxtGoHokenTokuteiNyushosha();
    }

    @JsonIgnore
    public TextBoxNum getTxtMaeKohi1TokuteiNyushosha() {
        return this.getTblKihonGokei().getTxtMaeKohi1TokuteiNyushosha();
    }

    @JsonIgnore
    public TextBoxNum getTxtGoKohi1TokuteiNyushosha() {
        return this.getTblKihonGokei().getTxtGoKohi1TokuteiNyushosha();
    }

    @JsonIgnore
    public TextBoxNum getTxtMaeKohi2TokuteiNyushosha() {
        return this.getTblKihonGokei().getTxtMaeKohi2TokuteiNyushosha();
    }

    @JsonIgnore
    public TextBoxNum getTxtGoKohi2TokuteiNyushosha() {
        return this.getTblKihonGokei().getTxtGoKohi2TokuteiNyushosha();
    }

    @JsonIgnore
    public TextBoxNum getTxtMaeKohi3TokuteiNyushosha() {
        return this.getTblKihonGokei().getTxtMaeKohi3TokuteiNyushosha();
    }

    @JsonIgnore
    public TextBoxNum getTxtGoKohi3TokuteiNyushosha() {
        return this.getTblKihonGokei().getTxtGoKohi3TokuteiNyushosha();
    }

    // </editor-fold>
}
