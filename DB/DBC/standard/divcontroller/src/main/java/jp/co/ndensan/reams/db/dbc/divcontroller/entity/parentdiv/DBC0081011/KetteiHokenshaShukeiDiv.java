package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0081011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.TableCell;
import jp.co.ndensan.reams.uz.uza.ui.binding.TablePanel;

/**
 * KetteiHokenshaShukei のクラスファイル 
 * 
 * @author 自動生成
 */
public class KetteiHokenshaShukeiDiv extends TablePanel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("tbrCellHokenshaShukei")
    private tbrCellHokenshaShukeiAtKetteiHokenshaShukei tbrCellHokenshaShukei;
    @JsonProperty("tbrCellSeikyuKensuu")
    private tbrCellSeikyuKensuuAtKetteiHokenshaShukei tbrCellSeikyuKensuu;
    @JsonProperty("tbrCellKeteiKensuu")
    private tbrCellKeteiKensuuAtKetteiHokenshaShukei tbrCellKeteiKensuu;
    @JsonProperty("tbrCellTyoseiKensuu")
    private tbrCellTyoseiKensuuAtKetteiHokenshaShukei tbrCellTyoseiKensuu;
    @JsonProperty("tbrCellSeikyuTani")
    private tbrCellSeikyuTaniAtKetteiHokenshaShukei tbrCellSeikyuTani;
    @JsonProperty("tbrCellKeteiTani")
    private tbrCellKeteiTaniAtKetteiHokenshaShukei tbrCellKeteiTani;
    @JsonProperty("tbrCellTyoseiTani")
    private tbrCellTyoseiTaniAtKetteiHokenshaShukei tbrCellTyoseiTani;
    @JsonProperty("tbrCellSeikyuFutangaku")
    private tbrCellSeikyuFutangakuAtKetteiHokenshaShukei tbrCellSeikyuFutangaku;
    @JsonProperty("tbrCellKeteiFutangaku")
    private tbrCellKeteiFutangakuAtKetteiHokenshaShukei tbrCellKeteiFutangaku;
    @JsonProperty("tbrCellTyoseiFutangaku")
    private tbrCellTyoseiFutangakuAtKetteiHokenshaShukei tbrCellTyoseiFutangaku;
    @JsonProperty("tbrCellHokenshaKyufuhi")
    private tbrCellHokenshaKyufuhiAtKetteiHokenshaShukei tbrCellHokenshaKyufuhi;
    @JsonProperty("tbrCellKaigoSeikyuKensuu")
    private tbrCellKaigoSeikyuKensuuAtKetteiHokenshaShukei tbrCellKaigoSeikyuKensuu;
    @JsonProperty("tbrCellKaigoKeteikensuu")
    private tbrCellKaigoKeteikensuuAtKetteiHokenshaShukei tbrCellKaigoKeteikensuu;
    @JsonProperty("tbrCellKaigoTyoseikensuu")
    private tbrCellKaigoTyoseikensuuAtKetteiHokenshaShukei tbrCellKaigoTyoseikensuu;
    @JsonProperty("tbrCellKiagoSeikyuTani")
    private tbrCellKiagoSeikyuTaniAtKetteiHokenshaShukei tbrCellKiagoSeikyuTani;
    @JsonProperty("tbrCellKaigoKeteiTani")
    private tbrCellKaigoKeteiTaniAtKetteiHokenshaShukei tbrCellKaigoKeteiTani;
    @JsonProperty("tbrCellKaigoTyouseiTani")
    private tbrCellKaigoTyouseiTaniAtKetteiHokenshaShukei tbrCellKaigoTyouseiTani;
    @JsonProperty("tbrCellKaigoSeikyuFutangaku")
    private tbrCellKaigoSeikyuFutangakuAtKetteiHokenshaShukei tbrCellKaigoSeikyuFutangaku;
    @JsonProperty("tbrCellKaigoKeteiFutangaku")
    private tbrCellKaigoKeteiFutangakuAtKetteiHokenshaShukei tbrCellKaigoKeteiFutangaku;
    @JsonProperty("tbrCellKaigoTyoseiFutangaku")
    private tbrCellKaigoTyoseiFutangakuAtKetteiHokenshaShukei tbrCellKaigoTyoseiFutangaku;
    @JsonProperty("tbrCellHokenshaKogakuServicehi")
    private tbrCellHokenshaKogakuServicehiAtKetteiHokenshaShukei tbrCellHokenshaKogakuServicehi;
    @JsonProperty("tbrCellKogakuSeikyuKensuu")
    private tbrCellKogakuSeikyuKensuuAtKetteiHokenshaShukei tbrCellKogakuSeikyuKensuu;
    @JsonProperty("tbrCellKougakuKeteiKensuu")
    private tbrCellKougakuKeteiKensuuAtKetteiHokenshaShukei tbrCellKougakuKeteiKensuu;
    @JsonProperty("tbrCellKougakuTyoseiKensuu")
    private tbrCellKougakuTyoseiKensuuAtKetteiHokenshaShukei tbrCellKougakuTyoseiKensuu;
    @JsonProperty("tbrCellKougakuSeikyuTani")
    private tbrCellKougakuSeikyuTaniAtKetteiHokenshaShukei tbrCellKougakuSeikyuTani;
    @JsonProperty("tbrCellKougakuKeteiTani")
    private tbrCellKougakuKeteiTaniAtKetteiHokenshaShukei tbrCellKougakuKeteiTani;
    @JsonProperty("tbrCellKougakuTyosaiTani")
    private tbrCellKougakuTyosaiTaniAtKetteiHokenshaShukei tbrCellKougakuTyosaiTani;
    @JsonProperty("tbrCellKougakuSeikyuFutangaku")
    private tbrCellKougakuSeikyuFutangakuAtKetteiHokenshaShukei tbrCellKougakuSeikyuFutangaku;
    @JsonProperty("tbrCellKogakuKeteiFutangaku")
    private tbrCellKogakuKeteiFutangakuAtKetteiHokenshaShukei tbrCellKogakuKeteiFutangaku;
    @JsonProperty("tbrCellKougakuTyoseiFutangaku")
    private tbrCellKougakuTyoseiFutangakuAtKetteiHokenshaShukei tbrCellKougakuTyoseiFutangaku;

    /*
     * [ Helperの作成 ]
     * TablePanelコントロールに特化したヘルパーメソッドを作成
     */
    @JsonIgnore
    public Space getSpaceKuhaku1() {
        return this.tbrCellHokenshaShukei.getSpaceKuhaku1();
    }

    @JsonIgnore
    public Label getLblKetteihokenshaKensu() {
        return this.tbrCellSeikyuKensuu.getLblKetteihokenshaKensu();
    }

    @JsonIgnore
    public Label getLblKetteihokenshaTanisuHiyogaku() {
        return this.tbrCellKeteiKensuu.getLblKetteihokenshaTanisuHiyogaku();
    }

    @JsonIgnore
    public Label getLblKetteihokenshaHokenshaFutangaku() {
        return this.tbrCellTyoseiKensuu.getLblKetteihokenshaHokenshaFutangaku();
    }

    @JsonIgnore
    public Space getSpaceKuhaku2() {
        return this.tbrCellSeikyuTani.getSpaceKuhaku2();
    }

    @JsonIgnore
    public Label getLblSeikyuTani() {
        return this.tbrCellSeikyuTani.getLblSeikyuTani();
    }

    @JsonIgnore
    public Space getSpaceKuhaku4() {
        return this.tbrCellSeikyuTani.getSpaceKuhaku4();
    }

    @JsonIgnore
    public Space getSpaceKuhaku5() {
        return this.tbrCellKeteiTani.getSpaceKuhaku5();
    }

    @JsonIgnore
    public Label getLblKeteiTani() {
        return this.tbrCellKeteiTani.getLblKeteiTani();
    }

    @JsonIgnore
    public Space getSpaceKuhaku6() {
        return this.tbrCellKeteiTani.getSpaceKuhaku6();
    }

    @JsonIgnore
    public Space getSpaceKuhaku8() {
        return this.tbrCellTyoseiTani.getSpaceKuhaku8();
    }

    @JsonIgnore
    public Label getLblTyoseiTani() {
        return this.tbrCellTyoseiTani.getLblTyoseiTani();
    }

    @JsonIgnore
    public Space getSpaceKuhaku7() {
        return this.tbrCellTyoseiTani.getSpaceKuhaku7();
    }

    @JsonIgnore
    public Label getLblSeikyuFutangaku() {
        return this.tbrCellSeikyuFutangaku.getLblSeikyuFutangaku();
    }

    @JsonIgnore
    public Label getLblKeteiFutangaku() {
        return this.tbrCellKeteiFutangaku.getLblKeteiFutangaku();
    }

    @JsonIgnore
    public Label getLblTyouseiFutangaku() {
        return this.tbrCellTyoseiFutangaku.getLblTyouseiFutangaku();
    }

    @JsonIgnore
    public Label getLblKetteihokenshaKaigokyuhuhi() {
        return this.tbrCellHokenshaKyufuhi.getLblKetteihokenshaKaigokyuhuhi();
    }

    @JsonIgnore
    public TextBoxNum getTxtKaigoSeikyuKensu() {
        return this.tbrCellKaigoSeikyuKensuu.getTxtKaigoSeikyuKensu();
    }

    @JsonIgnore
    public TextBoxNum getTxtKaigoKeiteKensu() {
        return this.tbrCellKaigoKeteikensuu.getTxtKaigoKeiteKensu();
    }

    @JsonIgnore
    public TextBoxNum getTxtKaigoYouseiKensu() {
        return this.tbrCellKaigoTyoseikensuu.getTxtKaigoYouseiKensu();
    }

    @JsonIgnore
    public TextBoxNum getTxtKaigoSeikyuTani() {
        return this.tbrCellKiagoSeikyuTani.getTxtKaigoSeikyuTani();
    }

    @JsonIgnore
    public TextBoxNum getTxtKaigoKeteiTani() {
        return this.tbrCellKaigoKeteiTani.getTxtKaigoKeteiTani();
    }

    @JsonIgnore
    public TextBoxNum getTxtKaigoTyoseiTani() {
        return this.tbrCellKaigoTyouseiTani.getTxtKaigoTyoseiTani();
    }

    @JsonIgnore
    public TextBoxNum getTxtKaigoSeikyuFutangaku() {
        return this.tbrCellKaigoSeikyuFutangaku.getTxtKaigoSeikyuFutangaku();
    }

    @JsonIgnore
    public TextBoxNum getTxtKaigoKeteiFutangaku() {
        return this.tbrCellKaigoKeteiFutangaku.getTxtKaigoKeteiFutangaku();
    }

    @JsonIgnore
    public TextBoxNum getTxtKaigoTyoseiFutangaku() {
        return this.tbrCellKaigoTyoseiFutangaku.getTxtKaigoTyoseiFutangaku();
    }

    @JsonIgnore
    public Label getLblKetteihokenshaKogakuServiceHi() {
        return this.tbrCellHokenshaKogakuServicehi.getLblKetteihokenshaKogakuServiceHi();
    }

    @JsonIgnore
    public TextBoxNum getTxtKougakuSeikyuKensu() {
        return this.tbrCellKogakuSeikyuKensuu.getTxtKougakuSeikyuKensu();
    }

    @JsonIgnore
    public TextBoxNum getTxtKougakuKeiteKensu() {
        return this.tbrCellKougakuKeteiKensuu.getTxtKougakuKeiteKensu();
    }

    @JsonIgnore
    public TextBoxNum getTxtKougakuYouseiKensu() {
        return this.tbrCellKougakuTyoseiKensuu.getTxtKougakuYouseiKensu();
    }

    @JsonIgnore
    public TextBoxNum getTxtkougakuSeikyuTani() {
        return this.tbrCellKougakuSeikyuTani.getTxtkougakuSeikyuTani();
    }

    @JsonIgnore
    public TextBoxNum getTxtKougakuKeteiTani() {
        return this.tbrCellKougakuKeteiTani.getTxtKougakuKeteiTani();
    }

    @JsonIgnore
    public TextBoxNum getTxtKougakuTyoseiTani() {
        return this.tbrCellKougakuTyosaiTani.getTxtKougakuTyoseiTani();
    }

    @JsonIgnore
    public TextBoxNum getTxtKougakuSeikyuFutangaku() {
        return this.tbrCellKougakuSeikyuFutangaku.getTxtKougakuSeikyuFutangaku();
    }

    @JsonIgnore
    public TextBoxNum getTxtKougakuKeteiFutangaku() {
        return this.tbrCellKogakuKeteiFutangaku.getTxtKougakuKeteiFutangaku();
    }

    @JsonIgnore
    public TextBoxNum getTxtKougakuTyoseiFutangaku() {
        return this.tbrCellKougakuTyoseiFutangaku.getTxtKougakuTyoseiFutangaku();
    }

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettbrCellHokenshaShukei
     * @return tbrCellHokenshaShukei
     */
    @JsonProperty("tbrCellHokenshaShukei")
    private tbrCellHokenshaShukeiAtKetteiHokenshaShukei getTbrCellHokenshaShukei() {
        return tbrCellHokenshaShukei;
    }

    /*
     * settbrCellHokenshaShukei
     * @param tbrCellHokenshaShukei tbrCellHokenshaShukei
     */
    @JsonProperty("tbrCellHokenshaShukei")
    private void setTbrCellHokenshaShukei(tbrCellHokenshaShukeiAtKetteiHokenshaShukei tbrCellHokenshaShukei) {
        this.tbrCellHokenshaShukei = tbrCellHokenshaShukei;
    }

    /*
     * gettbrCellSeikyuKensuu
     * @return tbrCellSeikyuKensuu
     */
    @JsonProperty("tbrCellSeikyuKensuu")
    private tbrCellSeikyuKensuuAtKetteiHokenshaShukei getTbrCellSeikyuKensuu() {
        return tbrCellSeikyuKensuu;
    }

    /*
     * settbrCellSeikyuKensuu
     * @param tbrCellSeikyuKensuu tbrCellSeikyuKensuu
     */
    @JsonProperty("tbrCellSeikyuKensuu")
    private void setTbrCellSeikyuKensuu(tbrCellSeikyuKensuuAtKetteiHokenshaShukei tbrCellSeikyuKensuu) {
        this.tbrCellSeikyuKensuu = tbrCellSeikyuKensuu;
    }

    /*
     * gettbrCellKeteiKensuu
     * @return tbrCellKeteiKensuu
     */
    @JsonProperty("tbrCellKeteiKensuu")
    private tbrCellKeteiKensuuAtKetteiHokenshaShukei getTbrCellKeteiKensuu() {
        return tbrCellKeteiKensuu;
    }

    /*
     * settbrCellKeteiKensuu
     * @param tbrCellKeteiKensuu tbrCellKeteiKensuu
     */
    @JsonProperty("tbrCellKeteiKensuu")
    private void setTbrCellKeteiKensuu(tbrCellKeteiKensuuAtKetteiHokenshaShukei tbrCellKeteiKensuu) {
        this.tbrCellKeteiKensuu = tbrCellKeteiKensuu;
    }

    /*
     * gettbrCellTyoseiKensuu
     * @return tbrCellTyoseiKensuu
     */
    @JsonProperty("tbrCellTyoseiKensuu")
    private tbrCellTyoseiKensuuAtKetteiHokenshaShukei getTbrCellTyoseiKensuu() {
        return tbrCellTyoseiKensuu;
    }

    /*
     * settbrCellTyoseiKensuu
     * @param tbrCellTyoseiKensuu tbrCellTyoseiKensuu
     */
    @JsonProperty("tbrCellTyoseiKensuu")
    private void setTbrCellTyoseiKensuu(tbrCellTyoseiKensuuAtKetteiHokenshaShukei tbrCellTyoseiKensuu) {
        this.tbrCellTyoseiKensuu = tbrCellTyoseiKensuu;
    }

    /*
     * gettbrCellSeikyuTani
     * @return tbrCellSeikyuTani
     */
    @JsonProperty("tbrCellSeikyuTani")
    private tbrCellSeikyuTaniAtKetteiHokenshaShukei getTbrCellSeikyuTani() {
        return tbrCellSeikyuTani;
    }

    /*
     * settbrCellSeikyuTani
     * @param tbrCellSeikyuTani tbrCellSeikyuTani
     */
    @JsonProperty("tbrCellSeikyuTani")
    private void setTbrCellSeikyuTani(tbrCellSeikyuTaniAtKetteiHokenshaShukei tbrCellSeikyuTani) {
        this.tbrCellSeikyuTani = tbrCellSeikyuTani;
    }

    /*
     * gettbrCellKeteiTani
     * @return tbrCellKeteiTani
     */
    @JsonProperty("tbrCellKeteiTani")
    private tbrCellKeteiTaniAtKetteiHokenshaShukei getTbrCellKeteiTani() {
        return tbrCellKeteiTani;
    }

    /*
     * settbrCellKeteiTani
     * @param tbrCellKeteiTani tbrCellKeteiTani
     */
    @JsonProperty("tbrCellKeteiTani")
    private void setTbrCellKeteiTani(tbrCellKeteiTaniAtKetteiHokenshaShukei tbrCellKeteiTani) {
        this.tbrCellKeteiTani = tbrCellKeteiTani;
    }

    /*
     * gettbrCellTyoseiTani
     * @return tbrCellTyoseiTani
     */
    @JsonProperty("tbrCellTyoseiTani")
    private tbrCellTyoseiTaniAtKetteiHokenshaShukei getTbrCellTyoseiTani() {
        return tbrCellTyoseiTani;
    }

    /*
     * settbrCellTyoseiTani
     * @param tbrCellTyoseiTani tbrCellTyoseiTani
     */
    @JsonProperty("tbrCellTyoseiTani")
    private void setTbrCellTyoseiTani(tbrCellTyoseiTaniAtKetteiHokenshaShukei tbrCellTyoseiTani) {
        this.tbrCellTyoseiTani = tbrCellTyoseiTani;
    }

    /*
     * gettbrCellSeikyuFutangaku
     * @return tbrCellSeikyuFutangaku
     */
    @JsonProperty("tbrCellSeikyuFutangaku")
    private tbrCellSeikyuFutangakuAtKetteiHokenshaShukei getTbrCellSeikyuFutangaku() {
        return tbrCellSeikyuFutangaku;
    }

    /*
     * settbrCellSeikyuFutangaku
     * @param tbrCellSeikyuFutangaku tbrCellSeikyuFutangaku
     */
    @JsonProperty("tbrCellSeikyuFutangaku")
    private void setTbrCellSeikyuFutangaku(tbrCellSeikyuFutangakuAtKetteiHokenshaShukei tbrCellSeikyuFutangaku) {
        this.tbrCellSeikyuFutangaku = tbrCellSeikyuFutangaku;
    }

    /*
     * gettbrCellKeteiFutangaku
     * @return tbrCellKeteiFutangaku
     */
    @JsonProperty("tbrCellKeteiFutangaku")
    private tbrCellKeteiFutangakuAtKetteiHokenshaShukei getTbrCellKeteiFutangaku() {
        return tbrCellKeteiFutangaku;
    }

    /*
     * settbrCellKeteiFutangaku
     * @param tbrCellKeteiFutangaku tbrCellKeteiFutangaku
     */
    @JsonProperty("tbrCellKeteiFutangaku")
    private void setTbrCellKeteiFutangaku(tbrCellKeteiFutangakuAtKetteiHokenshaShukei tbrCellKeteiFutangaku) {
        this.tbrCellKeteiFutangaku = tbrCellKeteiFutangaku;
    }

    /*
     * gettbrCellTyoseiFutangaku
     * @return tbrCellTyoseiFutangaku
     */
    @JsonProperty("tbrCellTyoseiFutangaku")
    private tbrCellTyoseiFutangakuAtKetteiHokenshaShukei getTbrCellTyoseiFutangaku() {
        return tbrCellTyoseiFutangaku;
    }

    /*
     * settbrCellTyoseiFutangaku
     * @param tbrCellTyoseiFutangaku tbrCellTyoseiFutangaku
     */
    @JsonProperty("tbrCellTyoseiFutangaku")
    private void setTbrCellTyoseiFutangaku(tbrCellTyoseiFutangakuAtKetteiHokenshaShukei tbrCellTyoseiFutangaku) {
        this.tbrCellTyoseiFutangaku = tbrCellTyoseiFutangaku;
    }

    /*
     * gettbrCellHokenshaKyufuhi
     * @return tbrCellHokenshaKyufuhi
     */
    @JsonProperty("tbrCellHokenshaKyufuhi")
    private tbrCellHokenshaKyufuhiAtKetteiHokenshaShukei getTbrCellHokenshaKyufuhi() {
        return tbrCellHokenshaKyufuhi;
    }

    /*
     * settbrCellHokenshaKyufuhi
     * @param tbrCellHokenshaKyufuhi tbrCellHokenshaKyufuhi
     */
    @JsonProperty("tbrCellHokenshaKyufuhi")
    private void setTbrCellHokenshaKyufuhi(tbrCellHokenshaKyufuhiAtKetteiHokenshaShukei tbrCellHokenshaKyufuhi) {
        this.tbrCellHokenshaKyufuhi = tbrCellHokenshaKyufuhi;
    }

    /*
     * gettbrCellKaigoSeikyuKensuu
     * @return tbrCellKaigoSeikyuKensuu
     */
    @JsonProperty("tbrCellKaigoSeikyuKensuu")
    private tbrCellKaigoSeikyuKensuuAtKetteiHokenshaShukei getTbrCellKaigoSeikyuKensuu() {
        return tbrCellKaigoSeikyuKensuu;
    }

    /*
     * settbrCellKaigoSeikyuKensuu
     * @param tbrCellKaigoSeikyuKensuu tbrCellKaigoSeikyuKensuu
     */
    @JsonProperty("tbrCellKaigoSeikyuKensuu")
    private void setTbrCellKaigoSeikyuKensuu(tbrCellKaigoSeikyuKensuuAtKetteiHokenshaShukei tbrCellKaigoSeikyuKensuu) {
        this.tbrCellKaigoSeikyuKensuu = tbrCellKaigoSeikyuKensuu;
    }

    /*
     * gettbrCellKaigoKeteikensuu
     * @return tbrCellKaigoKeteikensuu
     */
    @JsonProperty("tbrCellKaigoKeteikensuu")
    private tbrCellKaigoKeteikensuuAtKetteiHokenshaShukei getTbrCellKaigoKeteikensuu() {
        return tbrCellKaigoKeteikensuu;
    }

    /*
     * settbrCellKaigoKeteikensuu
     * @param tbrCellKaigoKeteikensuu tbrCellKaigoKeteikensuu
     */
    @JsonProperty("tbrCellKaigoKeteikensuu")
    private void setTbrCellKaigoKeteikensuu(tbrCellKaigoKeteikensuuAtKetteiHokenshaShukei tbrCellKaigoKeteikensuu) {
        this.tbrCellKaigoKeteikensuu = tbrCellKaigoKeteikensuu;
    }

    /*
     * gettbrCellKaigoTyoseikensuu
     * @return tbrCellKaigoTyoseikensuu
     */
    @JsonProperty("tbrCellKaigoTyoseikensuu")
    private tbrCellKaigoTyoseikensuuAtKetteiHokenshaShukei getTbrCellKaigoTyoseikensuu() {
        return tbrCellKaigoTyoseikensuu;
    }

    /*
     * settbrCellKaigoTyoseikensuu
     * @param tbrCellKaigoTyoseikensuu tbrCellKaigoTyoseikensuu
     */
    @JsonProperty("tbrCellKaigoTyoseikensuu")
    private void setTbrCellKaigoTyoseikensuu(tbrCellKaigoTyoseikensuuAtKetteiHokenshaShukei tbrCellKaigoTyoseikensuu) {
        this.tbrCellKaigoTyoseikensuu = tbrCellKaigoTyoseikensuu;
    }

    /*
     * gettbrCellKiagoSeikyuTani
     * @return tbrCellKiagoSeikyuTani
     */
    @JsonProperty("tbrCellKiagoSeikyuTani")
    private tbrCellKiagoSeikyuTaniAtKetteiHokenshaShukei getTbrCellKiagoSeikyuTani() {
        return tbrCellKiagoSeikyuTani;
    }

    /*
     * settbrCellKiagoSeikyuTani
     * @param tbrCellKiagoSeikyuTani tbrCellKiagoSeikyuTani
     */
    @JsonProperty("tbrCellKiagoSeikyuTani")
    private void setTbrCellKiagoSeikyuTani(tbrCellKiagoSeikyuTaniAtKetteiHokenshaShukei tbrCellKiagoSeikyuTani) {
        this.tbrCellKiagoSeikyuTani = tbrCellKiagoSeikyuTani;
    }

    /*
     * gettbrCellKaigoKeteiTani
     * @return tbrCellKaigoKeteiTani
     */
    @JsonProperty("tbrCellKaigoKeteiTani")
    private tbrCellKaigoKeteiTaniAtKetteiHokenshaShukei getTbrCellKaigoKeteiTani() {
        return tbrCellKaigoKeteiTani;
    }

    /*
     * settbrCellKaigoKeteiTani
     * @param tbrCellKaigoKeteiTani tbrCellKaigoKeteiTani
     */
    @JsonProperty("tbrCellKaigoKeteiTani")
    private void setTbrCellKaigoKeteiTani(tbrCellKaigoKeteiTaniAtKetteiHokenshaShukei tbrCellKaigoKeteiTani) {
        this.tbrCellKaigoKeteiTani = tbrCellKaigoKeteiTani;
    }

    /*
     * gettbrCellKaigoTyouseiTani
     * @return tbrCellKaigoTyouseiTani
     */
    @JsonProperty("tbrCellKaigoTyouseiTani")
    private tbrCellKaigoTyouseiTaniAtKetteiHokenshaShukei getTbrCellKaigoTyouseiTani() {
        return tbrCellKaigoTyouseiTani;
    }

    /*
     * settbrCellKaigoTyouseiTani
     * @param tbrCellKaigoTyouseiTani tbrCellKaigoTyouseiTani
     */
    @JsonProperty("tbrCellKaigoTyouseiTani")
    private void setTbrCellKaigoTyouseiTani(tbrCellKaigoTyouseiTaniAtKetteiHokenshaShukei tbrCellKaigoTyouseiTani) {
        this.tbrCellKaigoTyouseiTani = tbrCellKaigoTyouseiTani;
    }

    /*
     * gettbrCellKaigoSeikyuFutangaku
     * @return tbrCellKaigoSeikyuFutangaku
     */
    @JsonProperty("tbrCellKaigoSeikyuFutangaku")
    private tbrCellKaigoSeikyuFutangakuAtKetteiHokenshaShukei getTbrCellKaigoSeikyuFutangaku() {
        return tbrCellKaigoSeikyuFutangaku;
    }

    /*
     * settbrCellKaigoSeikyuFutangaku
     * @param tbrCellKaigoSeikyuFutangaku tbrCellKaigoSeikyuFutangaku
     */
    @JsonProperty("tbrCellKaigoSeikyuFutangaku")
    private void setTbrCellKaigoSeikyuFutangaku(tbrCellKaigoSeikyuFutangakuAtKetteiHokenshaShukei tbrCellKaigoSeikyuFutangaku) {
        this.tbrCellKaigoSeikyuFutangaku = tbrCellKaigoSeikyuFutangaku;
    }

    /*
     * gettbrCellKaigoKeteiFutangaku
     * @return tbrCellKaigoKeteiFutangaku
     */
    @JsonProperty("tbrCellKaigoKeteiFutangaku")
    private tbrCellKaigoKeteiFutangakuAtKetteiHokenshaShukei getTbrCellKaigoKeteiFutangaku() {
        return tbrCellKaigoKeteiFutangaku;
    }

    /*
     * settbrCellKaigoKeteiFutangaku
     * @param tbrCellKaigoKeteiFutangaku tbrCellKaigoKeteiFutangaku
     */
    @JsonProperty("tbrCellKaigoKeteiFutangaku")
    private void setTbrCellKaigoKeteiFutangaku(tbrCellKaigoKeteiFutangakuAtKetteiHokenshaShukei tbrCellKaigoKeteiFutangaku) {
        this.tbrCellKaigoKeteiFutangaku = tbrCellKaigoKeteiFutangaku;
    }

    /*
     * gettbrCellKaigoTyoseiFutangaku
     * @return tbrCellKaigoTyoseiFutangaku
     */
    @JsonProperty("tbrCellKaigoTyoseiFutangaku")
    private tbrCellKaigoTyoseiFutangakuAtKetteiHokenshaShukei getTbrCellKaigoTyoseiFutangaku() {
        return tbrCellKaigoTyoseiFutangaku;
    }

    /*
     * settbrCellKaigoTyoseiFutangaku
     * @param tbrCellKaigoTyoseiFutangaku tbrCellKaigoTyoseiFutangaku
     */
    @JsonProperty("tbrCellKaigoTyoseiFutangaku")
    private void setTbrCellKaigoTyoseiFutangaku(tbrCellKaigoTyoseiFutangakuAtKetteiHokenshaShukei tbrCellKaigoTyoseiFutangaku) {
        this.tbrCellKaigoTyoseiFutangaku = tbrCellKaigoTyoseiFutangaku;
    }

    /*
     * gettbrCellHokenshaKogakuServicehi
     * @return tbrCellHokenshaKogakuServicehi
     */
    @JsonProperty("tbrCellHokenshaKogakuServicehi")
    private tbrCellHokenshaKogakuServicehiAtKetteiHokenshaShukei getTbrCellHokenshaKogakuServicehi() {
        return tbrCellHokenshaKogakuServicehi;
    }

    /*
     * settbrCellHokenshaKogakuServicehi
     * @param tbrCellHokenshaKogakuServicehi tbrCellHokenshaKogakuServicehi
     */
    @JsonProperty("tbrCellHokenshaKogakuServicehi")
    private void setTbrCellHokenshaKogakuServicehi(tbrCellHokenshaKogakuServicehiAtKetteiHokenshaShukei tbrCellHokenshaKogakuServicehi) {
        this.tbrCellHokenshaKogakuServicehi = tbrCellHokenshaKogakuServicehi;
    }

    /*
     * gettbrCellKogakuSeikyuKensuu
     * @return tbrCellKogakuSeikyuKensuu
     */
    @JsonProperty("tbrCellKogakuSeikyuKensuu")
    private tbrCellKogakuSeikyuKensuuAtKetteiHokenshaShukei getTbrCellKogakuSeikyuKensuu() {
        return tbrCellKogakuSeikyuKensuu;
    }

    /*
     * settbrCellKogakuSeikyuKensuu
     * @param tbrCellKogakuSeikyuKensuu tbrCellKogakuSeikyuKensuu
     */
    @JsonProperty("tbrCellKogakuSeikyuKensuu")
    private void setTbrCellKogakuSeikyuKensuu(tbrCellKogakuSeikyuKensuuAtKetteiHokenshaShukei tbrCellKogakuSeikyuKensuu) {
        this.tbrCellKogakuSeikyuKensuu = tbrCellKogakuSeikyuKensuu;
    }

    /*
     * gettbrCellKougakuKeteiKensuu
     * @return tbrCellKougakuKeteiKensuu
     */
    @JsonProperty("tbrCellKougakuKeteiKensuu")
    private tbrCellKougakuKeteiKensuuAtKetteiHokenshaShukei getTbrCellKougakuKeteiKensuu() {
        return tbrCellKougakuKeteiKensuu;
    }

    /*
     * settbrCellKougakuKeteiKensuu
     * @param tbrCellKougakuKeteiKensuu tbrCellKougakuKeteiKensuu
     */
    @JsonProperty("tbrCellKougakuKeteiKensuu")
    private void setTbrCellKougakuKeteiKensuu(tbrCellKougakuKeteiKensuuAtKetteiHokenshaShukei tbrCellKougakuKeteiKensuu) {
        this.tbrCellKougakuKeteiKensuu = tbrCellKougakuKeteiKensuu;
    }

    /*
     * gettbrCellKougakuTyoseiKensuu
     * @return tbrCellKougakuTyoseiKensuu
     */
    @JsonProperty("tbrCellKougakuTyoseiKensuu")
    private tbrCellKougakuTyoseiKensuuAtKetteiHokenshaShukei getTbrCellKougakuTyoseiKensuu() {
        return tbrCellKougakuTyoseiKensuu;
    }

    /*
     * settbrCellKougakuTyoseiKensuu
     * @param tbrCellKougakuTyoseiKensuu tbrCellKougakuTyoseiKensuu
     */
    @JsonProperty("tbrCellKougakuTyoseiKensuu")
    private void setTbrCellKougakuTyoseiKensuu(tbrCellKougakuTyoseiKensuuAtKetteiHokenshaShukei tbrCellKougakuTyoseiKensuu) {
        this.tbrCellKougakuTyoseiKensuu = tbrCellKougakuTyoseiKensuu;
    }

    /*
     * gettbrCellKougakuSeikyuTani
     * @return tbrCellKougakuSeikyuTani
     */
    @JsonProperty("tbrCellKougakuSeikyuTani")
    private tbrCellKougakuSeikyuTaniAtKetteiHokenshaShukei getTbrCellKougakuSeikyuTani() {
        return tbrCellKougakuSeikyuTani;
    }

    /*
     * settbrCellKougakuSeikyuTani
     * @param tbrCellKougakuSeikyuTani tbrCellKougakuSeikyuTani
     */
    @JsonProperty("tbrCellKougakuSeikyuTani")
    private void setTbrCellKougakuSeikyuTani(tbrCellKougakuSeikyuTaniAtKetteiHokenshaShukei tbrCellKougakuSeikyuTani) {
        this.tbrCellKougakuSeikyuTani = tbrCellKougakuSeikyuTani;
    }

    /*
     * gettbrCellKougakuKeteiTani
     * @return tbrCellKougakuKeteiTani
     */
    @JsonProperty("tbrCellKougakuKeteiTani")
    private tbrCellKougakuKeteiTaniAtKetteiHokenshaShukei getTbrCellKougakuKeteiTani() {
        return tbrCellKougakuKeteiTani;
    }

    /*
     * settbrCellKougakuKeteiTani
     * @param tbrCellKougakuKeteiTani tbrCellKougakuKeteiTani
     */
    @JsonProperty("tbrCellKougakuKeteiTani")
    private void setTbrCellKougakuKeteiTani(tbrCellKougakuKeteiTaniAtKetteiHokenshaShukei tbrCellKougakuKeteiTani) {
        this.tbrCellKougakuKeteiTani = tbrCellKougakuKeteiTani;
    }

    /*
     * gettbrCellKougakuTyosaiTani
     * @return tbrCellKougakuTyosaiTani
     */
    @JsonProperty("tbrCellKougakuTyosaiTani")
    private tbrCellKougakuTyosaiTaniAtKetteiHokenshaShukei getTbrCellKougakuTyosaiTani() {
        return tbrCellKougakuTyosaiTani;
    }

    /*
     * settbrCellKougakuTyosaiTani
     * @param tbrCellKougakuTyosaiTani tbrCellKougakuTyosaiTani
     */
    @JsonProperty("tbrCellKougakuTyosaiTani")
    private void setTbrCellKougakuTyosaiTani(tbrCellKougakuTyosaiTaniAtKetteiHokenshaShukei tbrCellKougakuTyosaiTani) {
        this.tbrCellKougakuTyosaiTani = tbrCellKougakuTyosaiTani;
    }

    /*
     * gettbrCellKougakuSeikyuFutangaku
     * @return tbrCellKougakuSeikyuFutangaku
     */
    @JsonProperty("tbrCellKougakuSeikyuFutangaku")
    private tbrCellKougakuSeikyuFutangakuAtKetteiHokenshaShukei getTbrCellKougakuSeikyuFutangaku() {
        return tbrCellKougakuSeikyuFutangaku;
    }

    /*
     * settbrCellKougakuSeikyuFutangaku
     * @param tbrCellKougakuSeikyuFutangaku tbrCellKougakuSeikyuFutangaku
     */
    @JsonProperty("tbrCellKougakuSeikyuFutangaku")
    private void setTbrCellKougakuSeikyuFutangaku(tbrCellKougakuSeikyuFutangakuAtKetteiHokenshaShukei tbrCellKougakuSeikyuFutangaku) {
        this.tbrCellKougakuSeikyuFutangaku = tbrCellKougakuSeikyuFutangaku;
    }

    /*
     * gettbrCellKogakuKeteiFutangaku
     * @return tbrCellKogakuKeteiFutangaku
     */
    @JsonProperty("tbrCellKogakuKeteiFutangaku")
    private tbrCellKogakuKeteiFutangakuAtKetteiHokenshaShukei getTbrCellKogakuKeteiFutangaku() {
        return tbrCellKogakuKeteiFutangaku;
    }

    /*
     * settbrCellKogakuKeteiFutangaku
     * @param tbrCellKogakuKeteiFutangaku tbrCellKogakuKeteiFutangaku
     */
    @JsonProperty("tbrCellKogakuKeteiFutangaku")
    private void setTbrCellKogakuKeteiFutangaku(tbrCellKogakuKeteiFutangakuAtKetteiHokenshaShukei tbrCellKogakuKeteiFutangaku) {
        this.tbrCellKogakuKeteiFutangaku = tbrCellKogakuKeteiFutangaku;
    }

    /*
     * gettbrCellKougakuTyoseiFutangaku
     * @return tbrCellKougakuTyoseiFutangaku
     */
    @JsonProperty("tbrCellKougakuTyoseiFutangaku")
    private tbrCellKougakuTyoseiFutangakuAtKetteiHokenshaShukei getTbrCellKougakuTyoseiFutangaku() {
        return tbrCellKougakuTyoseiFutangaku;
    }

    /*
     * settbrCellKougakuTyoseiFutangaku
     * @param tbrCellKougakuTyoseiFutangaku tbrCellKougakuTyoseiFutangaku
     */
    @JsonProperty("tbrCellKougakuTyoseiFutangaku")
    private void setTbrCellKougakuTyoseiFutangaku(tbrCellKougakuTyoseiFutangakuAtKetteiHokenshaShukei tbrCellKougakuTyoseiFutangaku) {
        this.tbrCellKougakuTyoseiFutangaku = tbrCellKougakuTyoseiFutangaku;
    }

    // </editor-fold>
}
/**
 * tbrCellHokenshaShukei のクラスファイル 
 * 
 * @author 自動生成
 */
class tbrCellHokenshaShukeiAtKetteiHokenshaShukei extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    @JsonProperty("SpaceKuhaku1")
    private Space SpaceKuhaku1;

    /*
     * getSpaceKuhaku1
     * @return SpaceKuhaku1
     */
    @JsonProperty("SpaceKuhaku1")
    public Space getSpaceKuhaku1() {
        return SpaceKuhaku1;
    }

    /*
     * setSpaceKuhaku1
     * @param SpaceKuhaku1 SpaceKuhaku1
     */
    @JsonProperty("SpaceKuhaku1")
    public void setSpaceKuhaku1(Space SpaceKuhaku1) {
        this.SpaceKuhaku1 = SpaceKuhaku1;
    }

    // </editor-fold>
}
/**
 * tbrCellSeikyuKensuu のクラスファイル 
 * 
 * @author 自動生成
 */
class tbrCellSeikyuKensuuAtKetteiHokenshaShukei extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    @JsonProperty("lblKetteihokenshaKensu")
    private Label lblKetteihokenshaKensu;

    /*
     * getlblKetteihokenshaKensu
     * @return lblKetteihokenshaKensu
     */
    @JsonProperty("lblKetteihokenshaKensu")
    public Label getLblKetteihokenshaKensu() {
        return lblKetteihokenshaKensu;
    }

    /*
     * setlblKetteihokenshaKensu
     * @param lblKetteihokenshaKensu lblKetteihokenshaKensu
     */
    @JsonProperty("lblKetteihokenshaKensu")
    public void setLblKetteihokenshaKensu(Label lblKetteihokenshaKensu) {
        this.lblKetteihokenshaKensu = lblKetteihokenshaKensu;
    }

    // </editor-fold>
}
/**
 * tbrCellKeteiKensuu のクラスファイル 
 * 
 * @author 自動生成
 */
class tbrCellKeteiKensuuAtKetteiHokenshaShukei extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    @JsonProperty("lblKetteihokenshaTanisuHiyogaku")
    private Label lblKetteihokenshaTanisuHiyogaku;

    /*
     * getlblKetteihokenshaTanisuHiyogaku
     * @return lblKetteihokenshaTanisuHiyogaku
     */
    @JsonProperty("lblKetteihokenshaTanisuHiyogaku")
    public Label getLblKetteihokenshaTanisuHiyogaku() {
        return lblKetteihokenshaTanisuHiyogaku;
    }

    /*
     * setlblKetteihokenshaTanisuHiyogaku
     * @param lblKetteihokenshaTanisuHiyogaku lblKetteihokenshaTanisuHiyogaku
     */
    @JsonProperty("lblKetteihokenshaTanisuHiyogaku")
    public void setLblKetteihokenshaTanisuHiyogaku(Label lblKetteihokenshaTanisuHiyogaku) {
        this.lblKetteihokenshaTanisuHiyogaku = lblKetteihokenshaTanisuHiyogaku;
    }

    // </editor-fold>
}
/**
 * tbrCellTyoseiKensuu のクラスファイル 
 * 
 * @author 自動生成
 */
class tbrCellTyoseiKensuuAtKetteiHokenshaShukei extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    @JsonProperty("lblKetteihokenshaHokenshaFutangaku")
    private Label lblKetteihokenshaHokenshaFutangaku;

    /*
     * getlblKetteihokenshaHokenshaFutangaku
     * @return lblKetteihokenshaHokenshaFutangaku
     */
    @JsonProperty("lblKetteihokenshaHokenshaFutangaku")
    public Label getLblKetteihokenshaHokenshaFutangaku() {
        return lblKetteihokenshaHokenshaFutangaku;
    }

    /*
     * setlblKetteihokenshaHokenshaFutangaku
     * @param lblKetteihokenshaHokenshaFutangaku lblKetteihokenshaHokenshaFutangaku
     */
    @JsonProperty("lblKetteihokenshaHokenshaFutangaku")
    public void setLblKetteihokenshaHokenshaFutangaku(Label lblKetteihokenshaHokenshaFutangaku) {
        this.lblKetteihokenshaHokenshaFutangaku = lblKetteihokenshaHokenshaFutangaku;
    }

    // </editor-fold>
}
/**
 * tbrCellSeikyuTani のクラスファイル 
 * 
 * @author 自動生成
 */
class tbrCellSeikyuTaniAtKetteiHokenshaShukei extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    @JsonProperty("SpaceKuhaku2")
    private Space SpaceKuhaku2;
    @JsonProperty("lblSeikyuTani")
    private Label lblSeikyuTani;
    @JsonProperty("SpaceKuhaku4")
    private Space SpaceKuhaku4;

    /*
     * getSpaceKuhaku2
     * @return SpaceKuhaku2
     */
    @JsonProperty("SpaceKuhaku2")
    public Space getSpaceKuhaku2() {
        return SpaceKuhaku2;
    }

    /*
     * setSpaceKuhaku2
     * @param SpaceKuhaku2 SpaceKuhaku2
     */
    @JsonProperty("SpaceKuhaku2")
    public void setSpaceKuhaku2(Space SpaceKuhaku2) {
        this.SpaceKuhaku2 = SpaceKuhaku2;
    }

    /*
     * getlblSeikyuTani
     * @return lblSeikyuTani
     */
    @JsonProperty("lblSeikyuTani")
    public Label getLblSeikyuTani() {
        return lblSeikyuTani;
    }

    /*
     * setlblSeikyuTani
     * @param lblSeikyuTani lblSeikyuTani
     */
    @JsonProperty("lblSeikyuTani")
    public void setLblSeikyuTani(Label lblSeikyuTani) {
        this.lblSeikyuTani = lblSeikyuTani;
    }

    /*
     * getSpaceKuhaku4
     * @return SpaceKuhaku4
     */
    @JsonProperty("SpaceKuhaku4")
    public Space getSpaceKuhaku4() {
        return SpaceKuhaku4;
    }

    /*
     * setSpaceKuhaku4
     * @param SpaceKuhaku4 SpaceKuhaku4
     */
    @JsonProperty("SpaceKuhaku4")
    public void setSpaceKuhaku4(Space SpaceKuhaku4) {
        this.SpaceKuhaku4 = SpaceKuhaku4;
    }

    // </editor-fold>
}
/**
 * tbrCellKeteiTani のクラスファイル 
 * 
 * @author 自動生成
 */
class tbrCellKeteiTaniAtKetteiHokenshaShukei extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    @JsonProperty("SpaceKuhaku5")
    private Space SpaceKuhaku5;
    @JsonProperty("lblKeteiTani")
    private Label lblKeteiTani;
    @JsonProperty("SpaceKuhaku6")
    private Space SpaceKuhaku6;

    /*
     * getSpaceKuhaku5
     * @return SpaceKuhaku5
     */
    @JsonProperty("SpaceKuhaku5")
    public Space getSpaceKuhaku5() {
        return SpaceKuhaku5;
    }

    /*
     * setSpaceKuhaku5
     * @param SpaceKuhaku5 SpaceKuhaku5
     */
    @JsonProperty("SpaceKuhaku5")
    public void setSpaceKuhaku5(Space SpaceKuhaku5) {
        this.SpaceKuhaku5 = SpaceKuhaku5;
    }

    /*
     * getlblKeteiTani
     * @return lblKeteiTani
     */
    @JsonProperty("lblKeteiTani")
    public Label getLblKeteiTani() {
        return lblKeteiTani;
    }

    /*
     * setlblKeteiTani
     * @param lblKeteiTani lblKeteiTani
     */
    @JsonProperty("lblKeteiTani")
    public void setLblKeteiTani(Label lblKeteiTani) {
        this.lblKeteiTani = lblKeteiTani;
    }

    /*
     * getSpaceKuhaku6
     * @return SpaceKuhaku6
     */
    @JsonProperty("SpaceKuhaku6")
    public Space getSpaceKuhaku6() {
        return SpaceKuhaku6;
    }

    /*
     * setSpaceKuhaku6
     * @param SpaceKuhaku6 SpaceKuhaku6
     */
    @JsonProperty("SpaceKuhaku6")
    public void setSpaceKuhaku6(Space SpaceKuhaku6) {
        this.SpaceKuhaku6 = SpaceKuhaku6;
    }

    // </editor-fold>
}
/**
 * tbrCellTyoseiTani のクラスファイル 
 * 
 * @author 自動生成
 */
class tbrCellTyoseiTaniAtKetteiHokenshaShukei extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    @JsonProperty("SpaceKuhaku8")
    private Space SpaceKuhaku8;
    @JsonProperty("lblTyoseiTani")
    private Label lblTyoseiTani;
    @JsonProperty("SpaceKuhaku7")
    private Space SpaceKuhaku7;

    /*
     * getSpaceKuhaku8
     * @return SpaceKuhaku8
     */
    @JsonProperty("SpaceKuhaku8")
    public Space getSpaceKuhaku8() {
        return SpaceKuhaku8;
    }

    /*
     * setSpaceKuhaku8
     * @param SpaceKuhaku8 SpaceKuhaku8
     */
    @JsonProperty("SpaceKuhaku8")
    public void setSpaceKuhaku8(Space SpaceKuhaku8) {
        this.SpaceKuhaku8 = SpaceKuhaku8;
    }

    /*
     * getlblTyoseiTani
     * @return lblTyoseiTani
     */
    @JsonProperty("lblTyoseiTani")
    public Label getLblTyoseiTani() {
        return lblTyoseiTani;
    }

    /*
     * setlblTyoseiTani
     * @param lblTyoseiTani lblTyoseiTani
     */
    @JsonProperty("lblTyoseiTani")
    public void setLblTyoseiTani(Label lblTyoseiTani) {
        this.lblTyoseiTani = lblTyoseiTani;
    }

    /*
     * getSpaceKuhaku7
     * @return SpaceKuhaku7
     */
    @JsonProperty("SpaceKuhaku7")
    public Space getSpaceKuhaku7() {
        return SpaceKuhaku7;
    }

    /*
     * setSpaceKuhaku7
     * @param SpaceKuhaku7 SpaceKuhaku7
     */
    @JsonProperty("SpaceKuhaku7")
    public void setSpaceKuhaku7(Space SpaceKuhaku7) {
        this.SpaceKuhaku7 = SpaceKuhaku7;
    }

    // </editor-fold>
}
/**
 * tbrCellSeikyuFutangaku のクラスファイル 
 * 
 * @author 自動生成
 */
class tbrCellSeikyuFutangakuAtKetteiHokenshaShukei extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    @JsonProperty("lblSeikyuFutangaku")
    private Label lblSeikyuFutangaku;

    /*
     * getlblSeikyuFutangaku
     * @return lblSeikyuFutangaku
     */
    @JsonProperty("lblSeikyuFutangaku")
    public Label getLblSeikyuFutangaku() {
        return lblSeikyuFutangaku;
    }

    /*
     * setlblSeikyuFutangaku
     * @param lblSeikyuFutangaku lblSeikyuFutangaku
     */
    @JsonProperty("lblSeikyuFutangaku")
    public void setLblSeikyuFutangaku(Label lblSeikyuFutangaku) {
        this.lblSeikyuFutangaku = lblSeikyuFutangaku;
    }

    // </editor-fold>
}
/**
 * tbrCellKeteiFutangaku のクラスファイル 
 * 
 * @author 自動生成
 */
class tbrCellKeteiFutangakuAtKetteiHokenshaShukei extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    @JsonProperty("lblKeteiFutangaku")
    private Label lblKeteiFutangaku;

    /*
     * getlblKeteiFutangaku
     * @return lblKeteiFutangaku
     */
    @JsonProperty("lblKeteiFutangaku")
    public Label getLblKeteiFutangaku() {
        return lblKeteiFutangaku;
    }

    /*
     * setlblKeteiFutangaku
     * @param lblKeteiFutangaku lblKeteiFutangaku
     */
    @JsonProperty("lblKeteiFutangaku")
    public void setLblKeteiFutangaku(Label lblKeteiFutangaku) {
        this.lblKeteiFutangaku = lblKeteiFutangaku;
    }

    // </editor-fold>
}
/**
 * tbrCellTyoseiFutangaku のクラスファイル 
 * 
 * @author 自動生成
 */
class tbrCellTyoseiFutangakuAtKetteiHokenshaShukei extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    @JsonProperty("lblTyouseiFutangaku")
    private Label lblTyouseiFutangaku;

    /*
     * getlblTyouseiFutangaku
     * @return lblTyouseiFutangaku
     */
    @JsonProperty("lblTyouseiFutangaku")
    public Label getLblTyouseiFutangaku() {
        return lblTyouseiFutangaku;
    }

    /*
     * setlblTyouseiFutangaku
     * @param lblTyouseiFutangaku lblTyouseiFutangaku
     */
    @JsonProperty("lblTyouseiFutangaku")
    public void setLblTyouseiFutangaku(Label lblTyouseiFutangaku) {
        this.lblTyouseiFutangaku = lblTyouseiFutangaku;
    }

    // </editor-fold>
}
/**
 * tbrCellHokenshaKyufuhi のクラスファイル 
 * 
 * @author 自動生成
 */
class tbrCellHokenshaKyufuhiAtKetteiHokenshaShukei extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    @JsonProperty("lblKetteihokenshaKaigokyuhuhi")
    private Label lblKetteihokenshaKaigokyuhuhi;

    /*
     * getlblKetteihokenshaKaigokyuhuhi
     * @return lblKetteihokenshaKaigokyuhuhi
     */
    @JsonProperty("lblKetteihokenshaKaigokyuhuhi")
    public Label getLblKetteihokenshaKaigokyuhuhi() {
        return lblKetteihokenshaKaigokyuhuhi;
    }

    /*
     * setlblKetteihokenshaKaigokyuhuhi
     * @param lblKetteihokenshaKaigokyuhuhi lblKetteihokenshaKaigokyuhuhi
     */
    @JsonProperty("lblKetteihokenshaKaigokyuhuhi")
    public void setLblKetteihokenshaKaigokyuhuhi(Label lblKetteihokenshaKaigokyuhuhi) {
        this.lblKetteihokenshaKaigokyuhuhi = lblKetteihokenshaKaigokyuhuhi;
    }

    // </editor-fold>
}
/**
 * tbrCellKaigoSeikyuKensuu のクラスファイル 
 * 
 * @author 自動生成
 */
class tbrCellKaigoSeikyuKensuuAtKetteiHokenshaShukei extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    @JsonProperty("txtKaigoSeikyuKensu")
    private TextBoxNum txtKaigoSeikyuKensu;

    /*
     * gettxtKaigoSeikyuKensu
     * @return txtKaigoSeikyuKensu
     */
    @JsonProperty("txtKaigoSeikyuKensu")
    public TextBoxNum getTxtKaigoSeikyuKensu() {
        return txtKaigoSeikyuKensu;
    }

    /*
     * settxtKaigoSeikyuKensu
     * @param txtKaigoSeikyuKensu txtKaigoSeikyuKensu
     */
    @JsonProperty("txtKaigoSeikyuKensu")
    public void setTxtKaigoSeikyuKensu(TextBoxNum txtKaigoSeikyuKensu) {
        this.txtKaigoSeikyuKensu = txtKaigoSeikyuKensu;
    }

    // </editor-fold>
}
/**
 * tbrCellKaigoKeteikensuu のクラスファイル 
 * 
 * @author 自動生成
 */
class tbrCellKaigoKeteikensuuAtKetteiHokenshaShukei extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    @JsonProperty("txtKaigoKeiteKensu")
    private TextBoxNum txtKaigoKeiteKensu;

    /*
     * gettxtKaigoKeiteKensu
     * @return txtKaigoKeiteKensu
     */
    @JsonProperty("txtKaigoKeiteKensu")
    public TextBoxNum getTxtKaigoKeiteKensu() {
        return txtKaigoKeiteKensu;
    }

    /*
     * settxtKaigoKeiteKensu
     * @param txtKaigoKeiteKensu txtKaigoKeiteKensu
     */
    @JsonProperty("txtKaigoKeiteKensu")
    public void setTxtKaigoKeiteKensu(TextBoxNum txtKaigoKeiteKensu) {
        this.txtKaigoKeiteKensu = txtKaigoKeiteKensu;
    }

    // </editor-fold>
}
/**
 * tbrCellKaigoTyoseikensuu のクラスファイル 
 * 
 * @author 自動生成
 */
class tbrCellKaigoTyoseikensuuAtKetteiHokenshaShukei extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    @JsonProperty("txtKaigoYouseiKensu")
    private TextBoxNum txtKaigoYouseiKensu;

    /*
     * gettxtKaigoYouseiKensu
     * @return txtKaigoYouseiKensu
     */
    @JsonProperty("txtKaigoYouseiKensu")
    public TextBoxNum getTxtKaigoYouseiKensu() {
        return txtKaigoYouseiKensu;
    }

    /*
     * settxtKaigoYouseiKensu
     * @param txtKaigoYouseiKensu txtKaigoYouseiKensu
     */
    @JsonProperty("txtKaigoYouseiKensu")
    public void setTxtKaigoYouseiKensu(TextBoxNum txtKaigoYouseiKensu) {
        this.txtKaigoYouseiKensu = txtKaigoYouseiKensu;
    }

    // </editor-fold>
}
/**
 * tbrCellKiagoSeikyuTani のクラスファイル 
 * 
 * @author 自動生成
 */
class tbrCellKiagoSeikyuTaniAtKetteiHokenshaShukei extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    @JsonProperty("txtKaigoSeikyuTani")
    private TextBoxNum txtKaigoSeikyuTani;

    /*
     * gettxtKaigoSeikyuTani
     * @return txtKaigoSeikyuTani
     */
    @JsonProperty("txtKaigoSeikyuTani")
    public TextBoxNum getTxtKaigoSeikyuTani() {
        return txtKaigoSeikyuTani;
    }

    /*
     * settxtKaigoSeikyuTani
     * @param txtKaigoSeikyuTani txtKaigoSeikyuTani
     */
    @JsonProperty("txtKaigoSeikyuTani")
    public void setTxtKaigoSeikyuTani(TextBoxNum txtKaigoSeikyuTani) {
        this.txtKaigoSeikyuTani = txtKaigoSeikyuTani;
    }

    // </editor-fold>
}
/**
 * tbrCellKaigoKeteiTani のクラスファイル 
 * 
 * @author 自動生成
 */
class tbrCellKaigoKeteiTaniAtKetteiHokenshaShukei extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    @JsonProperty("txtKaigoKeteiTani")
    private TextBoxNum txtKaigoKeteiTani;

    /*
     * gettxtKaigoKeteiTani
     * @return txtKaigoKeteiTani
     */
    @JsonProperty("txtKaigoKeteiTani")
    public TextBoxNum getTxtKaigoKeteiTani() {
        return txtKaigoKeteiTani;
    }

    /*
     * settxtKaigoKeteiTani
     * @param txtKaigoKeteiTani txtKaigoKeteiTani
     */
    @JsonProperty("txtKaigoKeteiTani")
    public void setTxtKaigoKeteiTani(TextBoxNum txtKaigoKeteiTani) {
        this.txtKaigoKeteiTani = txtKaigoKeteiTani;
    }

    // </editor-fold>
}
/**
 * tbrCellKaigoTyouseiTani のクラスファイル 
 * 
 * @author 自動生成
 */
class tbrCellKaigoTyouseiTaniAtKetteiHokenshaShukei extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    @JsonProperty("txtKaigoTyoseiTani")
    private TextBoxNum txtKaigoTyoseiTani;

    /*
     * gettxtKaigoTyoseiTani
     * @return txtKaigoTyoseiTani
     */
    @JsonProperty("txtKaigoTyoseiTani")
    public TextBoxNum getTxtKaigoTyoseiTani() {
        return txtKaigoTyoseiTani;
    }

    /*
     * settxtKaigoTyoseiTani
     * @param txtKaigoTyoseiTani txtKaigoTyoseiTani
     */
    @JsonProperty("txtKaigoTyoseiTani")
    public void setTxtKaigoTyoseiTani(TextBoxNum txtKaigoTyoseiTani) {
        this.txtKaigoTyoseiTani = txtKaigoTyoseiTani;
    }

    // </editor-fold>
}
/**
 * tbrCellKaigoSeikyuFutangaku のクラスファイル 
 * 
 * @author 自動生成
 */
class tbrCellKaigoSeikyuFutangakuAtKetteiHokenshaShukei extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    @JsonProperty("txtKaigoSeikyuFutangaku")
    private TextBoxNum txtKaigoSeikyuFutangaku;

    /*
     * gettxtKaigoSeikyuFutangaku
     * @return txtKaigoSeikyuFutangaku
     */
    @JsonProperty("txtKaigoSeikyuFutangaku")
    public TextBoxNum getTxtKaigoSeikyuFutangaku() {
        return txtKaigoSeikyuFutangaku;
    }

    /*
     * settxtKaigoSeikyuFutangaku
     * @param txtKaigoSeikyuFutangaku txtKaigoSeikyuFutangaku
     */
    @JsonProperty("txtKaigoSeikyuFutangaku")
    public void setTxtKaigoSeikyuFutangaku(TextBoxNum txtKaigoSeikyuFutangaku) {
        this.txtKaigoSeikyuFutangaku = txtKaigoSeikyuFutangaku;
    }

    // </editor-fold>
}
/**
 * tbrCellKaigoKeteiFutangaku のクラスファイル 
 * 
 * @author 自動生成
 */
class tbrCellKaigoKeteiFutangakuAtKetteiHokenshaShukei extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    @JsonProperty("txtKaigoKeteiFutangaku")
    private TextBoxNum txtKaigoKeteiFutangaku;

    /*
     * gettxtKaigoKeteiFutangaku
     * @return txtKaigoKeteiFutangaku
     */
    @JsonProperty("txtKaigoKeteiFutangaku")
    public TextBoxNum getTxtKaigoKeteiFutangaku() {
        return txtKaigoKeteiFutangaku;
    }

    /*
     * settxtKaigoKeteiFutangaku
     * @param txtKaigoKeteiFutangaku txtKaigoKeteiFutangaku
     */
    @JsonProperty("txtKaigoKeteiFutangaku")
    public void setTxtKaigoKeteiFutangaku(TextBoxNum txtKaigoKeteiFutangaku) {
        this.txtKaigoKeteiFutangaku = txtKaigoKeteiFutangaku;
    }

    // </editor-fold>
}
/**
 * tbrCellKaigoTyoseiFutangaku のクラスファイル 
 * 
 * @author 自動生成
 */
class tbrCellKaigoTyoseiFutangakuAtKetteiHokenshaShukei extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    @JsonProperty("txtKaigoTyoseiFutangaku")
    private TextBoxNum txtKaigoTyoseiFutangaku;

    /*
     * gettxtKaigoTyoseiFutangaku
     * @return txtKaigoTyoseiFutangaku
     */
    @JsonProperty("txtKaigoTyoseiFutangaku")
    public TextBoxNum getTxtKaigoTyoseiFutangaku() {
        return txtKaigoTyoseiFutangaku;
    }

    /*
     * settxtKaigoTyoseiFutangaku
     * @param txtKaigoTyoseiFutangaku txtKaigoTyoseiFutangaku
     */
    @JsonProperty("txtKaigoTyoseiFutangaku")
    public void setTxtKaigoTyoseiFutangaku(TextBoxNum txtKaigoTyoseiFutangaku) {
        this.txtKaigoTyoseiFutangaku = txtKaigoTyoseiFutangaku;
    }

    // </editor-fold>
}
/**
 * tbrCellHokenshaKogakuServicehi のクラスファイル 
 * 
 * @author 自動生成
 */
class tbrCellHokenshaKogakuServicehiAtKetteiHokenshaShukei extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    @JsonProperty("lblKetteihokenshaKogakuServiceHi")
    private Label lblKetteihokenshaKogakuServiceHi;

    /*
     * getlblKetteihokenshaKogakuServiceHi
     * @return lblKetteihokenshaKogakuServiceHi
     */
    @JsonProperty("lblKetteihokenshaKogakuServiceHi")
    public Label getLblKetteihokenshaKogakuServiceHi() {
        return lblKetteihokenshaKogakuServiceHi;
    }

    /*
     * setlblKetteihokenshaKogakuServiceHi
     * @param lblKetteihokenshaKogakuServiceHi lblKetteihokenshaKogakuServiceHi
     */
    @JsonProperty("lblKetteihokenshaKogakuServiceHi")
    public void setLblKetteihokenshaKogakuServiceHi(Label lblKetteihokenshaKogakuServiceHi) {
        this.lblKetteihokenshaKogakuServiceHi = lblKetteihokenshaKogakuServiceHi;
    }

    // </editor-fold>
}
/**
 * tbrCellKogakuSeikyuKensuu のクラスファイル 
 * 
 * @author 自動生成
 */
class tbrCellKogakuSeikyuKensuuAtKetteiHokenshaShukei extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    @JsonProperty("txtKougakuSeikyuKensu")
    private TextBoxNum txtKougakuSeikyuKensu;

    /*
     * gettxtKougakuSeikyuKensu
     * @return txtKougakuSeikyuKensu
     */
    @JsonProperty("txtKougakuSeikyuKensu")
    public TextBoxNum getTxtKougakuSeikyuKensu() {
        return txtKougakuSeikyuKensu;
    }

    /*
     * settxtKougakuSeikyuKensu
     * @param txtKougakuSeikyuKensu txtKougakuSeikyuKensu
     */
    @JsonProperty("txtKougakuSeikyuKensu")
    public void setTxtKougakuSeikyuKensu(TextBoxNum txtKougakuSeikyuKensu) {
        this.txtKougakuSeikyuKensu = txtKougakuSeikyuKensu;
    }

    // </editor-fold>
}
/**
 * tbrCellKougakuKeteiKensuu のクラスファイル 
 * 
 * @author 自動生成
 */
class tbrCellKougakuKeteiKensuuAtKetteiHokenshaShukei extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    @JsonProperty("txtKougakuKeiteKensu")
    private TextBoxNum txtKougakuKeiteKensu;

    /*
     * gettxtKougakuKeiteKensu
     * @return txtKougakuKeiteKensu
     */
    @JsonProperty("txtKougakuKeiteKensu")
    public TextBoxNum getTxtKougakuKeiteKensu() {
        return txtKougakuKeiteKensu;
    }

    /*
     * settxtKougakuKeiteKensu
     * @param txtKougakuKeiteKensu txtKougakuKeiteKensu
     */
    @JsonProperty("txtKougakuKeiteKensu")
    public void setTxtKougakuKeiteKensu(TextBoxNum txtKougakuKeiteKensu) {
        this.txtKougakuKeiteKensu = txtKougakuKeiteKensu;
    }

    // </editor-fold>
}
/**
 * tbrCellKougakuTyoseiKensuu のクラスファイル 
 * 
 * @author 自動生成
 */
class tbrCellKougakuTyoseiKensuuAtKetteiHokenshaShukei extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    @JsonProperty("txtKougakuYouseiKensu")
    private TextBoxNum txtKougakuYouseiKensu;

    /*
     * gettxtKougakuYouseiKensu
     * @return txtKougakuYouseiKensu
     */
    @JsonProperty("txtKougakuYouseiKensu")
    public TextBoxNum getTxtKougakuYouseiKensu() {
        return txtKougakuYouseiKensu;
    }

    /*
     * settxtKougakuYouseiKensu
     * @param txtKougakuYouseiKensu txtKougakuYouseiKensu
     */
    @JsonProperty("txtKougakuYouseiKensu")
    public void setTxtKougakuYouseiKensu(TextBoxNum txtKougakuYouseiKensu) {
        this.txtKougakuYouseiKensu = txtKougakuYouseiKensu;
    }

    // </editor-fold>
}
/**
 * tbrCellKougakuSeikyuTani のクラスファイル 
 * 
 * @author 自動生成
 */
class tbrCellKougakuSeikyuTaniAtKetteiHokenshaShukei extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    @JsonProperty("txtkougakuSeikyuTani")
    private TextBoxNum txtkougakuSeikyuTani;

    /*
     * gettxtkougakuSeikyuTani
     * @return txtkougakuSeikyuTani
     */
    @JsonProperty("txtkougakuSeikyuTani")
    public TextBoxNum getTxtkougakuSeikyuTani() {
        return txtkougakuSeikyuTani;
    }

    /*
     * settxtkougakuSeikyuTani
     * @param txtkougakuSeikyuTani txtkougakuSeikyuTani
     */
    @JsonProperty("txtkougakuSeikyuTani")
    public void setTxtkougakuSeikyuTani(TextBoxNum txtkougakuSeikyuTani) {
        this.txtkougakuSeikyuTani = txtkougakuSeikyuTani;
    }

    // </editor-fold>
}
/**
 * tbrCellKougakuKeteiTani のクラスファイル 
 * 
 * @author 自動生成
 */
class tbrCellKougakuKeteiTaniAtKetteiHokenshaShukei extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    @JsonProperty("txtKougakuKeteiTani")
    private TextBoxNum txtKougakuKeteiTani;

    /*
     * gettxtKougakuKeteiTani
     * @return txtKougakuKeteiTani
     */
    @JsonProperty("txtKougakuKeteiTani")
    public TextBoxNum getTxtKougakuKeteiTani() {
        return txtKougakuKeteiTani;
    }

    /*
     * settxtKougakuKeteiTani
     * @param txtKougakuKeteiTani txtKougakuKeteiTani
     */
    @JsonProperty("txtKougakuKeteiTani")
    public void setTxtKougakuKeteiTani(TextBoxNum txtKougakuKeteiTani) {
        this.txtKougakuKeteiTani = txtKougakuKeteiTani;
    }

    // </editor-fold>
}
/**
 * tbrCellKougakuTyosaiTani のクラスファイル 
 * 
 * @author 自動生成
 */
class tbrCellKougakuTyosaiTaniAtKetteiHokenshaShukei extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    @JsonProperty("txtKougakuTyoseiTani")
    private TextBoxNum txtKougakuTyoseiTani;

    /*
     * gettxtKougakuTyoseiTani
     * @return txtKougakuTyoseiTani
     */
    @JsonProperty("txtKougakuTyoseiTani")
    public TextBoxNum getTxtKougakuTyoseiTani() {
        return txtKougakuTyoseiTani;
    }

    /*
     * settxtKougakuTyoseiTani
     * @param txtKougakuTyoseiTani txtKougakuTyoseiTani
     */
    @JsonProperty("txtKougakuTyoseiTani")
    public void setTxtKougakuTyoseiTani(TextBoxNum txtKougakuTyoseiTani) {
        this.txtKougakuTyoseiTani = txtKougakuTyoseiTani;
    }

    // </editor-fold>
}
/**
 * tbrCellKougakuSeikyuFutangaku のクラスファイル 
 * 
 * @author 自動生成
 */
class tbrCellKougakuSeikyuFutangakuAtKetteiHokenshaShukei extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    @JsonProperty("txtKougakuSeikyuFutangaku")
    private TextBoxNum txtKougakuSeikyuFutangaku;

    /*
     * gettxtKougakuSeikyuFutangaku
     * @return txtKougakuSeikyuFutangaku
     */
    @JsonProperty("txtKougakuSeikyuFutangaku")
    public TextBoxNum getTxtKougakuSeikyuFutangaku() {
        return txtKougakuSeikyuFutangaku;
    }

    /*
     * settxtKougakuSeikyuFutangaku
     * @param txtKougakuSeikyuFutangaku txtKougakuSeikyuFutangaku
     */
    @JsonProperty("txtKougakuSeikyuFutangaku")
    public void setTxtKougakuSeikyuFutangaku(TextBoxNum txtKougakuSeikyuFutangaku) {
        this.txtKougakuSeikyuFutangaku = txtKougakuSeikyuFutangaku;
    }

    // </editor-fold>
}
/**
 * tbrCellKogakuKeteiFutangaku のクラスファイル 
 * 
 * @author 自動生成
 */
class tbrCellKogakuKeteiFutangakuAtKetteiHokenshaShukei extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    @JsonProperty("txtKougakuKeteiFutangaku")
    private TextBoxNum txtKougakuKeteiFutangaku;

    /*
     * gettxtKougakuKeteiFutangaku
     * @return txtKougakuKeteiFutangaku
     */
    @JsonProperty("txtKougakuKeteiFutangaku")
    public TextBoxNum getTxtKougakuKeteiFutangaku() {
        return txtKougakuKeteiFutangaku;
    }

    /*
     * settxtKougakuKeteiFutangaku
     * @param txtKougakuKeteiFutangaku txtKougakuKeteiFutangaku
     */
    @JsonProperty("txtKougakuKeteiFutangaku")
    public void setTxtKougakuKeteiFutangaku(TextBoxNum txtKougakuKeteiFutangaku) {
        this.txtKougakuKeteiFutangaku = txtKougakuKeteiFutangaku;
    }

    // </editor-fold>
}
/**
 * tbrCellKougakuTyoseiFutangaku のクラスファイル 
 * 
 * @author 自動生成
 */
class tbrCellKougakuTyoseiFutangakuAtKetteiHokenshaShukei extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    @JsonProperty("txtKougakuTyoseiFutangaku")
    private TextBoxNum txtKougakuTyoseiFutangaku;

    /*
     * gettxtKougakuTyoseiFutangaku
     * @return txtKougakuTyoseiFutangaku
     */
    @JsonProperty("txtKougakuTyoseiFutangaku")
    public TextBoxNum getTxtKougakuTyoseiFutangaku() {
        return txtKougakuTyoseiFutangaku;
    }

    /*
     * settxtKougakuTyoseiFutangaku
     * @param txtKougakuTyoseiFutangaku txtKougakuTyoseiFutangaku
     */
    @JsonProperty("txtKougakuTyoseiFutangaku")
    public void setTxtKougakuTyoseiFutangaku(TextBoxNum txtKougakuTyoseiFutangaku) {
        this.txtKougakuTyoseiFutangaku = txtKougakuTyoseiFutangaku;
    }

    // </editor-fold>
}
