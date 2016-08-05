package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC8130012;
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
 * JikoFutangakuHosei2a のクラスファイル 
 * 
 * @author 自動生成
 */
public class JikoFutangakuHosei2aDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("tblNendo")
    private tblNendoDiv tblNendo;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettblNendo
     * @return tblNendo
     */
    @JsonProperty("tblNendo")
    public tblNendoDiv getTblNendo() {
        return tblNendo;
    }

    /*
     * settblNendo
     * @param tblNendo tblNendo
     */
    @JsonProperty("tblNendo")
    public void setTblNendo(tblNendoDiv tblNendo) {
        this.tblNendo = tblNendo;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public Label getLblTaishouTsukiMidashi1() {
        return this.getTblNendo().getLblTaishouTsukiMidashi1();
    }

    @JsonIgnore
    public Label getLblJikofutangakuMidashi1() {
        return this.getTblNendo().getLblJikofutangakuMidashi1();
    }

    @JsonIgnore
    public Label getLbl70Kara74FutangakuMidashi1() {
        return this.getTblNendo().getLbl70Kara74FutangakuMidashi1();
    }

    @JsonIgnore
    public Label getTxtKougakuSogoJigyoServicehiMidashi1() {
        return this.getTblNendo().getTxtKougakuSogoJigyoServicehiMidashi1();
    }

    @JsonIgnore
    public Label getTxtJissaiJikofutangakuMidashi1() {
        return this.getTblNendo().getTxtJissaiJikofutangakuMidashi1();
    }

    @JsonIgnore
    public Label getLblTaishouTsukiMidashi2() {
        return this.getTblNendo().getLblTaishouTsukiMidashi2();
    }

    @JsonIgnore
    public Label getLblJikofutangakuMidashi2() {
        return this.getTblNendo().getLblJikofutangakuMidashi2();
    }

    @JsonIgnore
    public Label getLbl70Kara74FutangakuMidashi2() {
        return this.getTblNendo().getLbl70Kara74FutangakuMidashi2();
    }

    @JsonIgnore
    public Label getTxtKougakuSogoJigyoServicehiMidashi2() {
        return this.getTblNendo().getTxtKougakuSogoJigyoServicehiMidashi2();
    }

    @JsonIgnore
    public Label getTxtJissaiJikofutangakuMidashi2() {
        return this.getTblNendo().getTxtJissaiJikofutangakuMidashi2();
    }

    @JsonIgnore
    public Label getLblTaishouTsuki8Gatsu() {
        return this.getTblNendo().getLblTaishouTsuki8Gatsu();
    }

    @JsonIgnore
    public TextBoxNum getTxtJikofutangaku8GatsuMae() {
        return this.getTblNendo().getTxtJikofutangaku8GatsuMae();
    }

    @JsonIgnore
    public TextBoxNum getCelJikofutangaku8GatsuGo() {
        return this.getTblNendo().getCelJikofutangaku8GatsuGo();
    }

    @JsonIgnore
    public TextBoxNum getTxt70Kara74Futangaku8GatsuMae() {
        return this.getTblNendo().getTxt70Kara74Futangaku8GatsuMae();
    }

    @JsonIgnore
    public TextBoxNum getTxt70Kara74Futangaku8GatsuGo() {
        return this.getTblNendo().getTxt70Kara74Futangaku8GatsuGo();
    }

    @JsonIgnore
    public TextBoxNum getTxtKougakuSogoJigyoServicehi8GatsuMae() {
        return this.getTblNendo().getTxtKougakuSogoJigyoServicehi8GatsuMae();
    }

    @JsonIgnore
    public TextBoxNum getTxtKougakuSogoJigyoServicehi8GatsuGo() {
        return this.getTblNendo().getTxtKougakuSogoJigyoServicehi8GatsuGo();
    }

    @JsonIgnore
    public TextBoxNum getTxtJissaiJikofutangaku8GatsuMae() {
        return this.getTblNendo().getTxtJissaiJikofutangaku8GatsuMae();
    }

    @JsonIgnore
    public TextBoxNum getTxtJissaiJikofutangaku8GatsuGo() {
        return this.getTblNendo().getTxtJissaiJikofutangaku8GatsuGo();
    }

    @JsonIgnore
    public Label getLblTaishouTsukiYoku2Gatsu() {
        return this.getTblNendo().getLblTaishouTsukiYoku2Gatsu();
    }

    @JsonIgnore
    public TextBoxNum getTxtJikofutangakuYoku2GatsuMae() {
        return this.getTblNendo().getTxtJikofutangakuYoku2GatsuMae();
    }

    @JsonIgnore
    public TextBoxNum getTxtJikofutangakuYoku2GatsuGo() {
        return this.getTblNendo().getTxtJikofutangakuYoku2GatsuGo();
    }

    @JsonIgnore
    public TextBoxNum getTxt70Kara74FutangakuYoku2GatsuMae() {
        return this.getTblNendo().getTxt70Kara74FutangakuYoku2GatsuMae();
    }

    @JsonIgnore
    public TextBoxNum getTxt70Kara74FutangakuYoku2GatsuGo() {
        return this.getTblNendo().getTxt70Kara74FutangakuYoku2GatsuGo();
    }

    @JsonIgnore
    public TextBoxNum getTxtKougakuSogoJigyoServicehiYoku2GatsuMae() {
        return this.getTblNendo().getTxtKougakuSogoJigyoServicehiYoku2GatsuMae();
    }

    @JsonIgnore
    public TextBoxNum getTxtKougakuSogoJigyoServicehiYoku2GatsuGo() {
        return this.getTblNendo().getTxtKougakuSogoJigyoServicehiYoku2GatsuGo();
    }

    @JsonIgnore
    public TextBoxNum getTxtJissaiJikofutangakuYoku2GatsuMae() {
        return this.getTblNendo().getTxtJissaiJikofutangakuYoku2GatsuMae();
    }

    @JsonIgnore
    public TextBoxNum getTxtJissaiJikofutangakuYoku2GatsuGo() {
        return this.getTblNendo().getTxtJissaiJikofutangakuYoku2GatsuGo();
    }

    @JsonIgnore
    public Label getLblTaishouTsuki9Gatsu() {
        return this.getTblNendo().getLblTaishouTsuki9Gatsu();
    }

    @JsonIgnore
    public TextBoxNum getTxtJikofutangaku9GatsuMae() {
        return this.getTblNendo().getTxtJikofutangaku9GatsuMae();
    }

    @JsonIgnore
    public TextBoxNum getTxtJikofutangaku9GatsuGo() {
        return this.getTblNendo().getTxtJikofutangaku9GatsuGo();
    }

    @JsonIgnore
    public TextBoxNum getTxt70Kara74Futangaku9GatsuMae() {
        return this.getTblNendo().getTxt70Kara74Futangaku9GatsuMae();
    }

    @JsonIgnore
    public TextBoxNum getTxt70Kara74Futangaku9GatsuGo() {
        return this.getTblNendo().getTxt70Kara74Futangaku9GatsuGo();
    }

    @JsonIgnore
    public TextBoxNum getTxtKougakuSogoJigyoServicehi9GatsuMae() {
        return this.getTblNendo().getTxtKougakuSogoJigyoServicehi9GatsuMae();
    }

    @JsonIgnore
    public TextBoxNum getTxtKougakuSogoJigyoServicehi9GatsuGo() {
        return this.getTblNendo().getTxtKougakuSogoJigyoServicehi9GatsuGo();
    }

    @JsonIgnore
    public TextBoxNum getTxtJissaiJikofutangaku9GatsuMae() {
        return this.getTblNendo().getTxtJissaiJikofutangaku9GatsuMae();
    }

    @JsonIgnore
    public TextBoxNum getTxtJissaiJikofutangaku9GatsuGo() {
        return this.getTblNendo().getTxtJissaiJikofutangaku9GatsuGo();
    }

    @JsonIgnore
    public Label getLblTaishouTsukiYoku3Gatsu() {
        return this.getTblNendo().getLblTaishouTsukiYoku3Gatsu();
    }

    @JsonIgnore
    public TextBoxNum getTxtJikofutangakuYoku3GatsuMae() {
        return this.getTblNendo().getTxtJikofutangakuYoku3GatsuMae();
    }

    @JsonIgnore
    public TextBoxNum getTxtJikofutangakuYoku3GatsuGo() {
        return this.getTblNendo().getTxtJikofutangakuYoku3GatsuGo();
    }

    @JsonIgnore
    public TextBoxNum getTxt70Kara74FutangakuYoku3GatsuMae() {
        return this.getTblNendo().getTxt70Kara74FutangakuYoku3GatsuMae();
    }

    @JsonIgnore
    public TextBoxNum getTxt70Kara74FutangakuYoku3GatsuGo() {
        return this.getTblNendo().getTxt70Kara74FutangakuYoku3GatsuGo();
    }

    @JsonIgnore
    public TextBoxNum getTxtKougakuSogoJigyoServicehiYoku3GatsuMae() {
        return this.getTblNendo().getTxtKougakuSogoJigyoServicehiYoku3GatsuMae();
    }

    @JsonIgnore
    public TextBoxNum getTxtKougakuSogoJigyoServicehiYoku3GatsuGo() {
        return this.getTblNendo().getTxtKougakuSogoJigyoServicehiYoku3GatsuGo();
    }

    @JsonIgnore
    public TextBoxNum getTxtJissaiJikofutangakuYoku3GatsuMae() {
        return this.getTblNendo().getTxtJissaiJikofutangakuYoku3GatsuMae();
    }

    @JsonIgnore
    public TextBoxNum getTxtJissaiJikofutangakuYoku3GatsuGo() {
        return this.getTblNendo().getTxtJissaiJikofutangakuYoku3GatsuGo();
    }

    @JsonIgnore
    public Label getLblTaishouTsuki10Gatsu() {
        return this.getTblNendo().getLblTaishouTsuki10Gatsu();
    }

    @JsonIgnore
    public TextBoxNum getTxtJikofutangaku10GatsuMae() {
        return this.getTblNendo().getTxtJikofutangaku10GatsuMae();
    }

    @JsonIgnore
    public TextBoxNum getTxtJikofutangaku10GatsuGo() {
        return this.getTblNendo().getTxtJikofutangaku10GatsuGo();
    }

    @JsonIgnore
    public TextBoxNum getTxt70Kara74Futangaku10GatsuMae() {
        return this.getTblNendo().getTxt70Kara74Futangaku10GatsuMae();
    }

    @JsonIgnore
    public TextBoxNum getTxt70Kara74Futangaku10GatsuGo() {
        return this.getTblNendo().getTxt70Kara74Futangaku10GatsuGo();
    }

    @JsonIgnore
    public TextBoxNum getTxtKougakuSogoJigyoServicehi10GatsuMae() {
        return this.getTblNendo().getTxtKougakuSogoJigyoServicehi10GatsuMae();
    }

    @JsonIgnore
    public TextBoxNum getTxtKougakuSogoJigyoServicehi10GatsuGo() {
        return this.getTblNendo().getTxtKougakuSogoJigyoServicehi10GatsuGo();
    }

    @JsonIgnore
    public TextBoxNum getTxtJissaiJikofutangaku10GatsuMae() {
        return this.getTblNendo().getTxtJissaiJikofutangaku10GatsuMae();
    }

    @JsonIgnore
    public TextBoxNum getTxtJissaiJikofutangaku10GatsuGo() {
        return this.getTblNendo().getTxtJissaiJikofutangaku10GatsuGo();
    }

    @JsonIgnore
    public Label getLblTaishouTsukiYoku4Gatsu() {
        return this.getTblNendo().getLblTaishouTsukiYoku4Gatsu();
    }

    @JsonIgnore
    public TextBoxNum getTxtJikofutangakuYoku4GatsuMae() {
        return this.getTblNendo().getTxtJikofutangakuYoku4GatsuMae();
    }

    @JsonIgnore
    public TextBoxNum getTxtJikofutangakuYoku4GatsuGo() {
        return this.getTblNendo().getTxtJikofutangakuYoku4GatsuGo();
    }

    @JsonIgnore
    public TextBoxNum getTxt70Kara74FutangakuYoku4GatsuMae() {
        return this.getTblNendo().getTxt70Kara74FutangakuYoku4GatsuMae();
    }

    @JsonIgnore
    public TextBoxNum getTxt70Kara74FutangakuYoku4GatsuGo() {
        return this.getTblNendo().getTxt70Kara74FutangakuYoku4GatsuGo();
    }

    @JsonIgnore
    public TextBoxNum getTxtKougakuSogoJigyoServicehiYoku4GatsuMae() {
        return this.getTblNendo().getTxtKougakuSogoJigyoServicehiYoku4GatsuMae();
    }

    @JsonIgnore
    public TextBoxNum getTxtKougakuSogoJigyoServicehiYoku4GatsuGo() {
        return this.getTblNendo().getTxtKougakuSogoJigyoServicehiYoku4GatsuGo();
    }

    @JsonIgnore
    public TextBoxNum getTxtJissaiJikofutangakuYoku4GatsuMae() {
        return this.getTblNendo().getTxtJissaiJikofutangakuYoku4GatsuMae();
    }

    @JsonIgnore
    public TextBoxNum getTxtJissaiJikofutangakuYoku4GatsuGo() {
        return this.getTblNendo().getTxtJissaiJikofutangakuYoku4GatsuGo();
    }

    @JsonIgnore
    public Label getLblTaishouTsuki11Gatsu() {
        return this.getTblNendo().getLblTaishouTsuki11Gatsu();
    }

    @JsonIgnore
    public TextBoxNum getTxtJikofutangaku11GatsuMae() {
        return this.getTblNendo().getTxtJikofutangaku11GatsuMae();
    }

    @JsonIgnore
    public TextBoxNum getTxtJikofutangaku11GatsuGo() {
        return this.getTblNendo().getTxtJikofutangaku11GatsuGo();
    }

    @JsonIgnore
    public TextBoxNum getTxt70Kara74Futangaku11GatsuMae() {
        return this.getTblNendo().getTxt70Kara74Futangaku11GatsuMae();
    }

    @JsonIgnore
    public TextBoxNum getTxt70Kara74Futangaku11GatsuGo() {
        return this.getTblNendo().getTxt70Kara74Futangaku11GatsuGo();
    }

    @JsonIgnore
    public TextBoxNum getTxtKougakuSogoJigyoServicehi11GatsuMae() {
        return this.getTblNendo().getTxtKougakuSogoJigyoServicehi11GatsuMae();
    }

    @JsonIgnore
    public TextBoxNum getTxtKougakuSogoJigyoServicehi11GatsuGo() {
        return this.getTblNendo().getTxtKougakuSogoJigyoServicehi11GatsuGo();
    }

    @JsonIgnore
    public TextBoxNum getTxtJissaiJikofutangaku11GatsuMae() {
        return this.getTblNendo().getTxtJissaiJikofutangaku11GatsuMae();
    }

    @JsonIgnore
    public TextBoxNum getTxtJissaiJikofutangaku11GatsuGo() {
        return this.getTblNendo().getTxtJissaiJikofutangaku11GatsuGo();
    }

    @JsonIgnore
    public Label getLblTaishouTsukiYoku5Gatsu() {
        return this.getTblNendo().getLblTaishouTsukiYoku5Gatsu();
    }

    @JsonIgnore
    public TextBoxNum getTxtJikofutangakuYoku5GatsuMae() {
        return this.getTblNendo().getTxtJikofutangakuYoku5GatsuMae();
    }

    @JsonIgnore
    public TextBoxNum getTxtJikofutangakuYoku5GatsuGo() {
        return this.getTblNendo().getTxtJikofutangakuYoku5GatsuGo();
    }

    @JsonIgnore
    public TextBoxNum getTxt70Kara74FutangakuYoku5GatsuMae() {
        return this.getTblNendo().getTxt70Kara74FutangakuYoku5GatsuMae();
    }

    @JsonIgnore
    public TextBoxNum getTxt70Kara74FutangakuYoku5GatsuGo() {
        return this.getTblNendo().getTxt70Kara74FutangakuYoku5GatsuGo();
    }

    @JsonIgnore
    public TextBoxNum getTxtKougakuSogoJigyoServicehiYoku5GatsuMae() {
        return this.getTblNendo().getTxtKougakuSogoJigyoServicehiYoku5GatsuMae();
    }

    @JsonIgnore
    public TextBoxNum getTxtKougakuSogoJigyoServicehiYoku5GatsuGo() {
        return this.getTblNendo().getTxtKougakuSogoJigyoServicehiYoku5GatsuGo();
    }

    @JsonIgnore
    public TextBoxNum getTxtJissaiJikofutangakuYoku5GatsuMae() {
        return this.getTblNendo().getTxtJissaiJikofutangakuYoku5GatsuMae();
    }

    @JsonIgnore
    public TextBoxNum getTxtJissaiJikofutangakuYoku5GatsuGo() {
        return this.getTblNendo().getTxtJissaiJikofutangakuYoku5GatsuGo();
    }

    @JsonIgnore
    public Label getLblTaishouTsuki12Gatsu() {
        return this.getTblNendo().getLblTaishouTsuki12Gatsu();
    }

    @JsonIgnore
    public TextBoxNum getTxtJikofutangaku12GatsuMae() {
        return this.getTblNendo().getTxtJikofutangaku12GatsuMae();
    }

    @JsonIgnore
    public TextBoxNum getTxtJikofutangaku12GatsuGo() {
        return this.getTblNendo().getTxtJikofutangaku12GatsuGo();
    }

    @JsonIgnore
    public TextBoxNum getTxt70Kara74Futangaku12GatsuMae() {
        return this.getTblNendo().getTxt70Kara74Futangaku12GatsuMae();
    }

    @JsonIgnore
    public TextBoxNum getTxt70Kara74Futangaku12GatsuGo() {
        return this.getTblNendo().getTxt70Kara74Futangaku12GatsuGo();
    }

    @JsonIgnore
    public TextBoxNum getTxtKougakuSogoJigyoServicehi12GatsuMae() {
        return this.getTblNendo().getTxtKougakuSogoJigyoServicehi12GatsuMae();
    }

    @JsonIgnore
    public TextBoxNum getTxtKougakuSogoJigyoServicehi12GatsuGo() {
        return this.getTblNendo().getTxtKougakuSogoJigyoServicehi12GatsuGo();
    }

    @JsonIgnore
    public TextBoxNum getTxtJissaiJikofutangaku12GatsuMae() {
        return this.getTblNendo().getTxtJissaiJikofutangaku12GatsuMae();
    }

    @JsonIgnore
    public TextBoxNum getTxtJissaiJikofutangaku12GatsuGo() {
        return this.getTblNendo().getTxtJissaiJikofutangaku12GatsuGo();
    }

    @JsonIgnore
    public Label getLblTaishouTsukiYoku6Gatsu() {
        return this.getTblNendo().getLblTaishouTsukiYoku6Gatsu();
    }

    @JsonIgnore
    public TextBoxNum getTxtJikofutangakuYoku6GatsuMae() {
        return this.getTblNendo().getTxtJikofutangakuYoku6GatsuMae();
    }

    @JsonIgnore
    public TextBoxNum getTxtJikofutangakuYoku6GatsuGo() {
        return this.getTblNendo().getTxtJikofutangakuYoku6GatsuGo();
    }

    @JsonIgnore
    public TextBoxNum getTxt70Kara74FutangakuYoku6GatsuMae() {
        return this.getTblNendo().getTxt70Kara74FutangakuYoku6GatsuMae();
    }

    @JsonIgnore
    public TextBoxNum getTxt70Kara74FutangakuYoku6GatsuGo() {
        return this.getTblNendo().getTxt70Kara74FutangakuYoku6GatsuGo();
    }

    @JsonIgnore
    public TextBoxNum getTxtKougakuSogoJigyoServicehiYoku6GatsuMae() {
        return this.getTblNendo().getTxtKougakuSogoJigyoServicehiYoku6GatsuMae();
    }

    @JsonIgnore
    public TextBoxNum getTxtKougakuSogoJigyoServicehiYoku6GatsuGo() {
        return this.getTblNendo().getTxtKougakuSogoJigyoServicehiYoku6GatsuGo();
    }

    @JsonIgnore
    public TextBoxNum getTxtJissaiJikofutangakuYoku6GatsuMae() {
        return this.getTblNendo().getTxtJissaiJikofutangakuYoku6GatsuMae();
    }

    @JsonIgnore
    public TextBoxNum getTxtJissaiJikofutangakuYoku6GatsuGo() {
        return this.getTblNendo().getTxtJissaiJikofutangakuYoku6GatsuGo();
    }

    @JsonIgnore
    public Label getLblTaishouTsukiYoku1Gatsu() {
        return this.getTblNendo().getLblTaishouTsukiYoku1Gatsu();
    }

    @JsonIgnore
    public TextBoxNum getTxtJikofutangakuYoku1GatsuMae() {
        return this.getTblNendo().getTxtJikofutangakuYoku1GatsuMae();
    }

    @JsonIgnore
    public TextBoxNum getTxtJikofutangakuYoku1GatsuGo() {
        return this.getTblNendo().getTxtJikofutangakuYoku1GatsuGo();
    }

    @JsonIgnore
    public TextBoxNum getTxt70Kara74FutangakuYoku1GatsuMae() {
        return this.getTblNendo().getTxt70Kara74FutangakuYoku1GatsuMae();
    }

    @JsonIgnore
    public TextBoxNum getTxt70Kara74FutangakuYoku1GatsuGo() {
        return this.getTblNendo().getTxt70Kara74FutangakuYoku1GatsuGo();
    }

    @JsonIgnore
    public TextBoxNum getTxtKougakuSogoJigyoServicehiYoku1GatsuMae() {
        return this.getTblNendo().getTxtKougakuSogoJigyoServicehiYoku1GatsuMae();
    }

    @JsonIgnore
    public TextBoxNum getTxtKougakuSogoJigyoServicehiYoku1GatsuGo() {
        return this.getTblNendo().getTxtKougakuSogoJigyoServicehiYoku1GatsuGo();
    }

    @JsonIgnore
    public TextBoxNum getTxtJissaiJikofutangakuYoku1GatsuMae() {
        return this.getTblNendo().getTxtJissaiJikofutangakuYoku1GatsuMae();
    }

    @JsonIgnore
    public TextBoxNum getTxtJissaiJikofutangakuYoku1GatsuGo() {
        return this.getTblNendo().getTxtJissaiJikofutangakuYoku1GatsuGo();
    }

    @JsonIgnore
    public Label getLblTaishouTsukiYoku7Gatsu() {
        return this.getTblNendo().getLblTaishouTsukiYoku7Gatsu();
    }

    @JsonIgnore
    public TextBoxNum getTxtJikofutangakuYoku7GatsuMae() {
        return this.getTblNendo().getTxtJikofutangakuYoku7GatsuMae();
    }

    @JsonIgnore
    public TextBoxNum getTxtJikofutangakuYoku7GatsuGo() {
        return this.getTblNendo().getTxtJikofutangakuYoku7GatsuGo();
    }

    @JsonIgnore
    public TextBoxNum getTxt70Kara74FutangakuYoku7GatsuMae() {
        return this.getTblNendo().getTxt70Kara74FutangakuYoku7GatsuMae();
    }

    @JsonIgnore
    public TextBoxNum getTxt70Kara74FutangakuYoku7GatsuGo() {
        return this.getTblNendo().getTxt70Kara74FutangakuYoku7GatsuGo();
    }

    @JsonIgnore
    public TextBoxNum getTxtKougakuSogoJigyoServicehiYoku7GatsuMae() {
        return this.getTblNendo().getTxtKougakuSogoJigyoServicehiYoku7GatsuMae();
    }

    @JsonIgnore
    public TextBoxNum getTxtKougakuSogoJigyoServicehiYoku7GatsuGo() {
        return this.getTblNendo().getTxtKougakuSogoJigyoServicehiYoku7GatsuGo();
    }

    @JsonIgnore
    public TextBoxNum getTxtJissaiJikofutangakuYoku7GatsuMae() {
        return this.getTblNendo().getTxtJissaiJikofutangakuYoku7GatsuMae();
    }

    @JsonIgnore
    public TextBoxNum getTxtJissaiJikofutangakuYoku7GatsuGo() {
        return this.getTblNendo().getTxtJissaiJikofutangakuYoku7GatsuGo();
    }

    @JsonIgnore
    public Label getLblTaishouTsukiGoukei() {
        return this.getTblNendo().getLblTaishouTsukiGoukei();
    }

    @JsonIgnore
    public TextBoxNum getTxtJikofutangakuGoukeiMae() {
        return this.getTblNendo().getTxtJikofutangakuGoukeiMae();
    }

    @JsonIgnore
    public TextBoxNum getTxtJikofutangakuGoukeiGo() {
        return this.getTblNendo().getTxtJikofutangakuGoukeiGo();
    }

    @JsonIgnore
    public TextBoxNum getTxt70Kara74FutangakuGoukeiMae() {
        return this.getTblNendo().getTxt70Kara74FutangakuGoukeiMae();
    }

    @JsonIgnore
    public TextBoxNum getTxt70Kara74FutangakuGoukeiGo() {
        return this.getTblNendo().getTxt70Kara74FutangakuGoukeiGo();
    }

    @JsonIgnore
    public TextBoxNum getTxtKougakuSogoJigyoServicehiGoukeiMae() {
        return this.getTblNendo().getTxtKougakuSogoJigyoServicehiGoukeiMae();
    }

    @JsonIgnore
    public TextBoxNum getTxtKougakuSogoJigyoServicehiGoukeiGo() {
        return this.getTblNendo().getTxtKougakuSogoJigyoServicehiGoukeiGo();
    }

    @JsonIgnore
    public TextBoxNum getTxtJissaiJikofutangakuGoukeiMae() {
        return this.getTblNendo().getTxtJissaiJikofutangakuGoukeiMae();
    }

    @JsonIgnore
    public TextBoxNum getTxtJissaiJikofutangakuGoukeiGo() {
        return this.getTblNendo().getTxtJissaiJikofutangakuGoukeiGo();
    }

    // </editor-fold>
}
