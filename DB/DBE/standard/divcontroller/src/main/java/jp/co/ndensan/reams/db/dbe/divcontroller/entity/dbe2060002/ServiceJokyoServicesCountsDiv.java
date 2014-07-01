package jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe2060002;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.serviceWithCountCom.ServiceWithCountCom;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * ServiceJokyoServicesCounts のクラスファイル 
 * 
 * @author 自動生成
 */
public class ServiceJokyoServicesCountsDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("comCountTankiSeikatsuKaigo")
    private ServiceWithCountCom comCountTankiSeikatsuKaigo;
    @JsonProperty("comCountHomeHelp")
    private ServiceWithCountCom comCountHomeHelp;
    @JsonProperty("comCountTankiRyoyoKaigo")
    private ServiceWithCountCom comCountTankiRyoyoKaigo;
    @JsonProperty("comCountHomonKango")
    private ServiceWithCountCom comCountHomonKango;
    @JsonProperty("comCountTokuteiSeikatsuKaigo")
    private ServiceWithCountCom comCountTokuteiSeikatsuKaigo;
    @JsonProperty("comCountHomonRehabilitation")
    private ServiceWithCountCom comCountHomonRehabilitation;
    @JsonProperty("comCountNinchishoTsushoKaigo")
    private ServiceWithCountCom comCountNinchishoTsushoKaigo;
    @JsonProperty("comCountHomonBathing")
    private ServiceWithCountCom comCountHomonBathing;
    @JsonProperty("comCountNinchishoKyodoKaigo")
    private ServiceWithCountCom comCountNinchishoKyodoKaigo;
    @JsonProperty("comCountDayService")
    private ServiceWithCountCom comCountDayService;
    @JsonProperty("comCountSmallTakinoKaigo")
    private ServiceWithCountCom comCountSmallTakinoKaigo;
    @JsonProperty("comCountTsushoRehabilitation")
    private ServiceWithCountCom comCountTsushoRehabilitation;
    @JsonProperty("comCountTeikiJunkaiHomonKaigo")
    private ServiceWithCountCom comCountTeikiJunkaiHomonKaigo;
    @JsonProperty("comCountRyoyoKanriShido")
    private ServiceWithCountCom comCountRyoyoKanriShido;
    @JsonProperty("comCountYakanHomonKaigo")
    private ServiceWithCountCom comCountYakanHomonKaigo;
    @JsonProperty("comCountFukushiyoguHanbai")
    private ServiceWithCountCom comCountFukushiyoguHanbai;
    @JsonProperty("comCountChiikiTokuteiShisetsuKaigo")
    private ServiceWithCountCom comCountChiikiTokuteiShisetsuKaigo;
    @JsonProperty("comCountFukushiyoguTaiyo")
    private ServiceWithCountCom comCountFukushiyoguTaiyo;
    @JsonProperty("comCountChiikiRojinFukushiShisetsuKaigo")
    private ServiceWithCountCom comCountChiikiRojinFukushiShisetsuKaigo;
    @JsonProperty("lblJutakuKaishu")
    private Label lblJutakuKaishu;
    @JsonProperty("radJutakuKaishu")
    private RadioButton radJutakuKaishu;
    @JsonProperty("linServicesCounts")
    private HorizontalLine linServicesCounts;
    @JsonProperty("txtShichosonTokubetsuKyufu")
    private TextBox txtShichosonTokubetsuKyufu;
    @JsonProperty("txtZaitakuSeriviceOutsideKaigoKyufu")
    private TextBox txtZaitakuSeriviceOutsideKaigoKyufu;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("comCountTankiSeikatsuKaigo")
    public ServiceWithCountCom getComCountTankiSeikatsuKaigo() {
        return comCountTankiSeikatsuKaigo;
    }

    @JsonProperty("comCountTankiSeikatsuKaigo")
    public void setComCountTankiSeikatsuKaigo(ServiceWithCountCom comCountTankiSeikatsuKaigo) {
        this.comCountTankiSeikatsuKaigo=comCountTankiSeikatsuKaigo;
    }

    @JsonProperty("comCountHomeHelp")
    public ServiceWithCountCom getComCountHomeHelp() {
        return comCountHomeHelp;
    }

    @JsonProperty("comCountHomeHelp")
    public void setComCountHomeHelp(ServiceWithCountCom comCountHomeHelp) {
        this.comCountHomeHelp=comCountHomeHelp;
    }

    @JsonProperty("comCountTankiRyoyoKaigo")
    public ServiceWithCountCom getComCountTankiRyoyoKaigo() {
        return comCountTankiRyoyoKaigo;
    }

    @JsonProperty("comCountTankiRyoyoKaigo")
    public void setComCountTankiRyoyoKaigo(ServiceWithCountCom comCountTankiRyoyoKaigo) {
        this.comCountTankiRyoyoKaigo=comCountTankiRyoyoKaigo;
    }

    @JsonProperty("comCountHomonKango")
    public ServiceWithCountCom getComCountHomonKango() {
        return comCountHomonKango;
    }

    @JsonProperty("comCountHomonKango")
    public void setComCountHomonKango(ServiceWithCountCom comCountHomonKango) {
        this.comCountHomonKango=comCountHomonKango;
    }

    @JsonProperty("comCountTokuteiSeikatsuKaigo")
    public ServiceWithCountCom getComCountTokuteiSeikatsuKaigo() {
        return comCountTokuteiSeikatsuKaigo;
    }

    @JsonProperty("comCountTokuteiSeikatsuKaigo")
    public void setComCountTokuteiSeikatsuKaigo(ServiceWithCountCom comCountTokuteiSeikatsuKaigo) {
        this.comCountTokuteiSeikatsuKaigo=comCountTokuteiSeikatsuKaigo;
    }

    @JsonProperty("comCountHomonRehabilitation")
    public ServiceWithCountCom getComCountHomonRehabilitation() {
        return comCountHomonRehabilitation;
    }

    @JsonProperty("comCountHomonRehabilitation")
    public void setComCountHomonRehabilitation(ServiceWithCountCom comCountHomonRehabilitation) {
        this.comCountHomonRehabilitation=comCountHomonRehabilitation;
    }

    @JsonProperty("comCountNinchishoTsushoKaigo")
    public ServiceWithCountCom getComCountNinchishoTsushoKaigo() {
        return comCountNinchishoTsushoKaigo;
    }

    @JsonProperty("comCountNinchishoTsushoKaigo")
    public void setComCountNinchishoTsushoKaigo(ServiceWithCountCom comCountNinchishoTsushoKaigo) {
        this.comCountNinchishoTsushoKaigo=comCountNinchishoTsushoKaigo;
    }

    @JsonProperty("comCountHomonBathing")
    public ServiceWithCountCom getComCountHomonBathing() {
        return comCountHomonBathing;
    }

    @JsonProperty("comCountHomonBathing")
    public void setComCountHomonBathing(ServiceWithCountCom comCountHomonBathing) {
        this.comCountHomonBathing=comCountHomonBathing;
    }

    @JsonProperty("comCountNinchishoKyodoKaigo")
    public ServiceWithCountCom getComCountNinchishoKyodoKaigo() {
        return comCountNinchishoKyodoKaigo;
    }

    @JsonProperty("comCountNinchishoKyodoKaigo")
    public void setComCountNinchishoKyodoKaigo(ServiceWithCountCom comCountNinchishoKyodoKaigo) {
        this.comCountNinchishoKyodoKaigo=comCountNinchishoKyodoKaigo;
    }

    @JsonProperty("comCountDayService")
    public ServiceWithCountCom getComCountDayService() {
        return comCountDayService;
    }

    @JsonProperty("comCountDayService")
    public void setComCountDayService(ServiceWithCountCom comCountDayService) {
        this.comCountDayService=comCountDayService;
    }

    @JsonProperty("comCountSmallTakinoKaigo")
    public ServiceWithCountCom getComCountSmallTakinoKaigo() {
        return comCountSmallTakinoKaigo;
    }

    @JsonProperty("comCountSmallTakinoKaigo")
    public void setComCountSmallTakinoKaigo(ServiceWithCountCom comCountSmallTakinoKaigo) {
        this.comCountSmallTakinoKaigo=comCountSmallTakinoKaigo;
    }

    @JsonProperty("comCountTsushoRehabilitation")
    public ServiceWithCountCom getComCountTsushoRehabilitation() {
        return comCountTsushoRehabilitation;
    }

    @JsonProperty("comCountTsushoRehabilitation")
    public void setComCountTsushoRehabilitation(ServiceWithCountCom comCountTsushoRehabilitation) {
        this.comCountTsushoRehabilitation=comCountTsushoRehabilitation;
    }

    @JsonProperty("comCountTeikiJunkaiHomonKaigo")
    public ServiceWithCountCom getComCountTeikiJunkaiHomonKaigo() {
        return comCountTeikiJunkaiHomonKaigo;
    }

    @JsonProperty("comCountTeikiJunkaiHomonKaigo")
    public void setComCountTeikiJunkaiHomonKaigo(ServiceWithCountCom comCountTeikiJunkaiHomonKaigo) {
        this.comCountTeikiJunkaiHomonKaigo=comCountTeikiJunkaiHomonKaigo;
    }

    @JsonProperty("comCountRyoyoKanriShido")
    public ServiceWithCountCom getComCountRyoyoKanriShido() {
        return comCountRyoyoKanriShido;
    }

    @JsonProperty("comCountRyoyoKanriShido")
    public void setComCountRyoyoKanriShido(ServiceWithCountCom comCountRyoyoKanriShido) {
        this.comCountRyoyoKanriShido=comCountRyoyoKanriShido;
    }

    @JsonProperty("comCountYakanHomonKaigo")
    public ServiceWithCountCom getComCountYakanHomonKaigo() {
        return comCountYakanHomonKaigo;
    }

    @JsonProperty("comCountYakanHomonKaigo")
    public void setComCountYakanHomonKaigo(ServiceWithCountCom comCountYakanHomonKaigo) {
        this.comCountYakanHomonKaigo=comCountYakanHomonKaigo;
    }

    @JsonProperty("comCountFukushiyoguHanbai")
    public ServiceWithCountCom getComCountFukushiyoguHanbai() {
        return comCountFukushiyoguHanbai;
    }

    @JsonProperty("comCountFukushiyoguHanbai")
    public void setComCountFukushiyoguHanbai(ServiceWithCountCom comCountFukushiyoguHanbai) {
        this.comCountFukushiyoguHanbai=comCountFukushiyoguHanbai;
    }

    @JsonProperty("comCountChiikiTokuteiShisetsuKaigo")
    public ServiceWithCountCom getComCountChiikiTokuteiShisetsuKaigo() {
        return comCountChiikiTokuteiShisetsuKaigo;
    }

    @JsonProperty("comCountChiikiTokuteiShisetsuKaigo")
    public void setComCountChiikiTokuteiShisetsuKaigo(ServiceWithCountCom comCountChiikiTokuteiShisetsuKaigo) {
        this.comCountChiikiTokuteiShisetsuKaigo=comCountChiikiTokuteiShisetsuKaigo;
    }

    @JsonProperty("comCountFukushiyoguTaiyo")
    public ServiceWithCountCom getComCountFukushiyoguTaiyo() {
        return comCountFukushiyoguTaiyo;
    }

    @JsonProperty("comCountFukushiyoguTaiyo")
    public void setComCountFukushiyoguTaiyo(ServiceWithCountCom comCountFukushiyoguTaiyo) {
        this.comCountFukushiyoguTaiyo=comCountFukushiyoguTaiyo;
    }

    @JsonProperty("comCountChiikiRojinFukushiShisetsuKaigo")
    public ServiceWithCountCom getComCountChiikiRojinFukushiShisetsuKaigo() {
        return comCountChiikiRojinFukushiShisetsuKaigo;
    }

    @JsonProperty("comCountChiikiRojinFukushiShisetsuKaigo")
    public void setComCountChiikiRojinFukushiShisetsuKaigo(ServiceWithCountCom comCountChiikiRojinFukushiShisetsuKaigo) {
        this.comCountChiikiRojinFukushiShisetsuKaigo=comCountChiikiRojinFukushiShisetsuKaigo;
    }

    @JsonProperty("lblJutakuKaishu")
    public Label getLblJutakuKaishu() {
        return lblJutakuKaishu;
    }

    @JsonProperty("lblJutakuKaishu")
    public void setLblJutakuKaishu(Label lblJutakuKaishu) {
        this.lblJutakuKaishu=lblJutakuKaishu;
    }

    @JsonProperty("radJutakuKaishu")
    public RadioButton getRadJutakuKaishu() {
        return radJutakuKaishu;
    }

    @JsonProperty("radJutakuKaishu")
    public void setRadJutakuKaishu(RadioButton radJutakuKaishu) {
        this.radJutakuKaishu=radJutakuKaishu;
    }

    @JsonProperty("linServicesCounts")
    public HorizontalLine getLinServicesCounts() {
        return linServicesCounts;
    }

    @JsonProperty("linServicesCounts")
    public void setLinServicesCounts(HorizontalLine linServicesCounts) {
        this.linServicesCounts=linServicesCounts;
    }

    @JsonProperty("txtShichosonTokubetsuKyufu")
    public TextBox getTxtShichosonTokubetsuKyufu() {
        return txtShichosonTokubetsuKyufu;
    }

    @JsonProperty("txtShichosonTokubetsuKyufu")
    public void setTxtShichosonTokubetsuKyufu(TextBox txtShichosonTokubetsuKyufu) {
        this.txtShichosonTokubetsuKyufu=txtShichosonTokubetsuKyufu;
    }

    @JsonProperty("txtZaitakuSeriviceOutsideKaigoKyufu")
    public TextBox getTxtZaitakuSeriviceOutsideKaigoKyufu() {
        return txtZaitakuSeriviceOutsideKaigoKyufu;
    }

    @JsonProperty("txtZaitakuSeriviceOutsideKaigoKyufu")
    public void setTxtZaitakuSeriviceOutsideKaigoKyufu(TextBox txtZaitakuSeriviceOutsideKaigoKyufu) {
        this.txtZaitakuSeriviceOutsideKaigoKyufu=txtZaitakuSeriviceOutsideKaigoKyufu;
    }

}
