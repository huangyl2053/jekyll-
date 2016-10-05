package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1140012;
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
 * @reamsid_L DBC-2080-030 jianglaisheng
 */
public class JikoFutangakuHosei2aDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-07-28_11-34-20">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("tbl20Nendo")
    private tbl20NendoDiv tbl20Nendo;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettbl20Nendo
     * @return tbl20Nendo
     */
    @JsonProperty("tbl20Nendo")
    public tbl20NendoDiv getTbl20Nendo() {
        return tbl20Nendo;
    }

    /*
     * settbl20Nendo
     * @param tbl20Nendo tbl20Nendo
     */
    @JsonProperty("tbl20Nendo")
    public void setTbl20Nendo(tbl20NendoDiv tbl20Nendo) {
        this.tbl20Nendo = tbl20Nendo;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public Label getLbl20NendoTaishouTsukiMidashi1() {
        return this.getTbl20Nendo().getLbl20NendoTaishouTsukiMidashi1();
    }

    @JsonIgnore
    public Label getLbl20NendoJikofutangakuMidashi1() {
        return this.getTbl20Nendo().getLbl20NendoJikofutangakuMidashi1();
    }

    @JsonIgnore
    public Label getLbl20Nendo70Kara74FutangakuMidashi1() {
        return this.getTbl20Nendo().getLbl20Nendo70Kara74FutangakuMidashi1();
    }

    @JsonIgnore
    public Label getTxt20NendoKougakuKaigoServicehiMidashi1() {
        return this.getTbl20Nendo().getTxt20NendoKougakuKaigoServicehiMidashi1();
    }

    @JsonIgnore
    public Label getTxt20NendoJissaiJikofutangakuMidashi1() {
        return this.getTbl20Nendo().getTxt20NendoJissaiJikofutangakuMidashi1();
    }

    @JsonIgnore
    public Label getLbl20NendoTaishouTsukiMidashi2() {
        return this.getTbl20Nendo().getLbl20NendoTaishouTsukiMidashi2();
    }

    @JsonIgnore
    public Label getLbl20NendoJikofutangakuMidashi2() {
        return this.getTbl20Nendo().getLbl20NendoJikofutangakuMidashi2();
    }

    @JsonIgnore
    public Label getLbl20Nendo70Kara74FutangakuMidashi2() {
        return this.getTbl20Nendo().getLbl20Nendo70Kara74FutangakuMidashi2();
    }

    @JsonIgnore
    public Label getTxt20NendoKougakuKaigoServicehiMidashi2() {
        return this.getTbl20Nendo().getTxt20NendoKougakuKaigoServicehiMidashi2();
    }

    @JsonIgnore
    public Label getTxt20NendoJissaiJikofutangakuMidashi2() {
        return this.getTbl20Nendo().getTxt20NendoJissaiJikofutangakuMidashi2();
    }

    @JsonIgnore
    public Label getLbl20NendoTaishouTsuki4Gatsu() {
        return this.getTbl20Nendo().getLbl20NendoTaishouTsuki4Gatsu();
    }

    @JsonIgnore
    public TextBoxNum getTxt20NendoJikofutangaku4GatsuMae() {
        return this.getTbl20Nendo().getTxt20NendoJikofutangaku4GatsuMae();
    }

    @JsonIgnore
    public TextBoxNum getCel20NendoJikofutangaku4GatsuGo() {
        return this.getTbl20Nendo().getCel20NendoJikofutangaku4GatsuGo();
    }

    @JsonIgnore
    public TextBoxNum getTxt20Nendo70Kara74Futangaku4GatsuMae() {
        return this.getTbl20Nendo().getTxt20Nendo70Kara74Futangaku4GatsuMae();
    }

    @JsonIgnore
    public TextBoxNum getTxt20Nendo70Kara74Futangaku4GatsuGo() {
        return this.getTbl20Nendo().getTxt20Nendo70Kara74Futangaku4GatsuGo();
    }

    @JsonIgnore
    public TextBoxNum getTxt20NendoKougakuKaigoServicehi4GatsuMae() {
        return this.getTbl20Nendo().getTxt20NendoKougakuKaigoServicehi4GatsuMae();
    }

    @JsonIgnore
    public TextBoxNum getTxt20NendoKougakuKaigoServicehi4GatsuGo() {
        return this.getTbl20Nendo().getTxt20NendoKougakuKaigoServicehi4GatsuGo();
    }

    @JsonIgnore
    public TextBoxNum getTxt20NendoJissaiJikofutangaku4GatsuMae() {
        return this.getTbl20Nendo().getTxt20NendoJissaiJikofutangaku4GatsuMae();
    }

    @JsonIgnore
    public TextBoxNum getTxt20NendoJissaiJikofutangaku4GatsuGo() {
        return this.getTbl20Nendo().getTxt20NendoJissaiJikofutangaku4GatsuGo();
    }

    @JsonIgnore
    public Label getLbl20NendoTaishouTsukiYoku1Gatsu() {
        return this.getTbl20Nendo().getLbl20NendoTaishouTsukiYoku1Gatsu();
    }

    @JsonIgnore
    public TextBoxNum getTxt20NendoJikofutangakuYoku1GatsuMae() {
        return this.getTbl20Nendo().getTxt20NendoJikofutangakuYoku1GatsuMae();
    }

    @JsonIgnore
    public TextBoxNum getTxt20NendoJikofutangakuYoku1GatsuGo() {
        return this.getTbl20Nendo().getTxt20NendoJikofutangakuYoku1GatsuGo();
    }

    @JsonIgnore
    public TextBoxNum getTxt20Nendo70Kara74FutangakuYoku1GatsuMae() {
        return this.getTbl20Nendo().getTxt20Nendo70Kara74FutangakuYoku1GatsuMae();
    }

    @JsonIgnore
    public TextBoxNum getTxt20Nendo70Kara74FutangakuYoku1GatsuGo() {
        return this.getTbl20Nendo().getTxt20Nendo70Kara74FutangakuYoku1GatsuGo();
    }

    @JsonIgnore
    public TextBoxNum getTxt20NendoKougakuKaigoServicehiYoku1GatsuMae() {
        return this.getTbl20Nendo().getTxt20NendoKougakuKaigoServicehiYoku1GatsuMae();
    }

    @JsonIgnore
    public TextBoxNum getTxt20NendoKougakuKaigoServicehiYoku1GatsuGo() {
        return this.getTbl20Nendo().getTxt20NendoKougakuKaigoServicehiYoku1GatsuGo();
    }

    @JsonIgnore
    public TextBoxNum getTxt20NendoJissaiJikofutangakuYoku1GatsuMae() {
        return this.getTbl20Nendo().getTxt20NendoJissaiJikofutangakuYoku1GatsuMae();
    }

    @JsonIgnore
    public TextBoxNum getTxt20NendoJissaiJikofutangakuYoku1GatsuGo() {
        return this.getTbl20Nendo().getTxt20NendoJissaiJikofutangakuYoku1GatsuGo();
    }

    @JsonIgnore
    public Label getLbl20NendoTaishouTsuki5Gatsu() {
        return this.getTbl20Nendo().getLbl20NendoTaishouTsuki5Gatsu();
    }

    @JsonIgnore
    public TextBoxNum getTxt20NendoJikofutangaku5GatsuMae() {
        return this.getTbl20Nendo().getTxt20NendoJikofutangaku5GatsuMae();
    }

    @JsonIgnore
    public TextBoxNum getTxt20NendoJikofutangaku5GatsuGo() {
        return this.getTbl20Nendo().getTxt20NendoJikofutangaku5GatsuGo();
    }

    @JsonIgnore
    public TextBoxNum getTxt20Nendo70Kara74Futangaku5GatsuMae() {
        return this.getTbl20Nendo().getTxt20Nendo70Kara74Futangaku5GatsuMae();
    }

    @JsonIgnore
    public TextBoxNum getTxt20Nendo70Kara74Futangaku5GatsuGo() {
        return this.getTbl20Nendo().getTxt20Nendo70Kara74Futangaku5GatsuGo();
    }

    @JsonIgnore
    public TextBoxNum getTxt20NendoKougakuKaigoServicehi5GatsuMae() {
        return this.getTbl20Nendo().getTxt20NendoKougakuKaigoServicehi5GatsuMae();
    }

    @JsonIgnore
    public TextBoxNum getTxt20NendoKougakuKaigoServicehi5GatsuGo() {
        return this.getTbl20Nendo().getTxt20NendoKougakuKaigoServicehi5GatsuGo();
    }

    @JsonIgnore
    public TextBoxNum getTxt20NendoJissaiJikofutangaku5GatsuMae() {
        return this.getTbl20Nendo().getTxt20NendoJissaiJikofutangaku5GatsuMae();
    }

    @JsonIgnore
    public TextBoxNum getTxt20NendoJissaiJikofutangaku5GatsuGo() {
        return this.getTbl20Nendo().getTxt20NendoJissaiJikofutangaku5GatsuGo();
    }

    @JsonIgnore
    public Label getLbl20NendoTaishouTsukiYoku2Gatsu() {
        return this.getTbl20Nendo().getLbl20NendoTaishouTsukiYoku2Gatsu();
    }

    @JsonIgnore
    public TextBoxNum getTxt20NendoJikofutangakuYoku2GatsuMae() {
        return this.getTbl20Nendo().getTxt20NendoJikofutangakuYoku2GatsuMae();
    }

    @JsonIgnore
    public TextBoxNum getTxt20NendoJikofutangakuYoku2GatsuGo() {
        return this.getTbl20Nendo().getTxt20NendoJikofutangakuYoku2GatsuGo();
    }

    @JsonIgnore
    public TextBoxNum getTxt20Nendo70Kara74FutangakuYoku2GatsuMae() {
        return this.getTbl20Nendo().getTxt20Nendo70Kara74FutangakuYoku2GatsuMae();
    }

    @JsonIgnore
    public TextBoxNum getTxt20Nendo70Kara74FutangakuYoku2GatsuGo() {
        return this.getTbl20Nendo().getTxt20Nendo70Kara74FutangakuYoku2GatsuGo();
    }

    @JsonIgnore
    public TextBoxNum getTxt20NendoKougakuKaigoServicehiYoku2GatsuMae() {
        return this.getTbl20Nendo().getTxt20NendoKougakuKaigoServicehiYoku2GatsuMae();
    }

    @JsonIgnore
    public TextBoxNum getTxt20NendoKougakuKaigoServicehiYoku2GatsuGo() {
        return this.getTbl20Nendo().getTxt20NendoKougakuKaigoServicehiYoku2GatsuGo();
    }

    @JsonIgnore
    public TextBoxNum getTxt20NendoJissaiJikofutangakuYoku2GatsuMae() {
        return this.getTbl20Nendo().getTxt20NendoJissaiJikofutangakuYoku2GatsuMae();
    }

    @JsonIgnore
    public TextBoxNum getTxt20NendoJissaiJikofutangakuYoku2GatsuGo() {
        return this.getTbl20Nendo().getTxt20NendoJissaiJikofutangakuYoku2GatsuGo();
    }

    @JsonIgnore
    public Label getLbl20NendoTaishouTsuki6Gatsu() {
        return this.getTbl20Nendo().getLbl20NendoTaishouTsuki6Gatsu();
    }

    @JsonIgnore
    public TextBoxNum getTxt20NendoJikofutangaku6GatsuMae() {
        return this.getTbl20Nendo().getTxt20NendoJikofutangaku6GatsuMae();
    }

    @JsonIgnore
    public TextBoxNum getTxt20NendoJikofutangaku6GatsuGo() {
        return this.getTbl20Nendo().getTxt20NendoJikofutangaku6GatsuGo();
    }

    @JsonIgnore
    public TextBoxNum getTxt20Nendo70Kara74Futangaku6GatsuMae() {
        return this.getTbl20Nendo().getTxt20Nendo70Kara74Futangaku6GatsuMae();
    }

    @JsonIgnore
    public TextBoxNum getTxt20Nendo70Kara74Futangaku6GatsuGo() {
        return this.getTbl20Nendo().getTxt20Nendo70Kara74Futangaku6GatsuGo();
    }

    @JsonIgnore
    public TextBoxNum getTxt20NendoKougakuKaigoServicehi6GatsuMae() {
        return this.getTbl20Nendo().getTxt20NendoKougakuKaigoServicehi6GatsuMae();
    }

    @JsonIgnore
    public TextBoxNum getTxt20NendoKougakuKaigoServicehi6GatsuGo() {
        return this.getTbl20Nendo().getTxt20NendoKougakuKaigoServicehi6GatsuGo();
    }

    @JsonIgnore
    public TextBoxNum getTxt20NendoJissaiJikofutangaku6GatsuMae() {
        return this.getTbl20Nendo().getTxt20NendoJissaiJikofutangaku6GatsuMae();
    }

    @JsonIgnore
    public TextBoxNum getTxt20NendoJissaiJikofutangaku6GatsuGo() {
        return this.getTbl20Nendo().getTxt20NendoJissaiJikofutangaku6GatsuGo();
    }

    @JsonIgnore
    public Label getLbl20NendoTaishouTsukiYoku3Gatsu() {
        return this.getTbl20Nendo().getLbl20NendoTaishouTsukiYoku3Gatsu();
    }

    @JsonIgnore
    public TextBoxNum getTxt20NendoJikofutangakuYoku3GatsuMae() {
        return this.getTbl20Nendo().getTxt20NendoJikofutangakuYoku3GatsuMae();
    }

    @JsonIgnore
    public TextBoxNum getTxt20NendoJikofutangakuYoku3GatsuGo() {
        return this.getTbl20Nendo().getTxt20NendoJikofutangakuYoku3GatsuGo();
    }

    @JsonIgnore
    public TextBoxNum getTxt20Nendo70Kara74FutangakuYoku3GatsuMae() {
        return this.getTbl20Nendo().getTxt20Nendo70Kara74FutangakuYoku3GatsuMae();
    }

    @JsonIgnore
    public TextBoxNum getTxt20Nendo70Kara74FutangakuYoku3GatsuGo() {
        return this.getTbl20Nendo().getTxt20Nendo70Kara74FutangakuYoku3GatsuGo();
    }

    @JsonIgnore
    public TextBoxNum getTxt20NendoKougakuKaigoServicehiYoku3GatsuMae() {
        return this.getTbl20Nendo().getTxt20NendoKougakuKaigoServicehiYoku3GatsuMae();
    }

    @JsonIgnore
    public TextBoxNum getTxt20NendoKougakuKaigoServicehiYoku3GatsuGo() {
        return this.getTbl20Nendo().getTxt20NendoKougakuKaigoServicehiYoku3GatsuGo();
    }

    @JsonIgnore
    public TextBoxNum getTxt20NendoJissaiJikofutangakuYoku3GatsuMae() {
        return this.getTbl20Nendo().getTxt20NendoJissaiJikofutangakuYoku3GatsuMae();
    }

    @JsonIgnore
    public TextBoxNum getTxt20NendoJissaiJikofutangakuYoku3GatsuGo() {
        return this.getTbl20Nendo().getTxt20NendoJissaiJikofutangakuYoku3GatsuGo();
    }

    @JsonIgnore
    public Label getLbl20NendoTaishouTsuki7Gatsu() {
        return this.getTbl20Nendo().getLbl20NendoTaishouTsuki7Gatsu();
    }

    @JsonIgnore
    public TextBoxNum getTxt20NendoJikofutangaku7GatsuMae() {
        return this.getTbl20Nendo().getTxt20NendoJikofutangaku7GatsuMae();
    }

    @JsonIgnore
    public TextBoxNum getTxt20NendoJikofutangaku7GatsuGo() {
        return this.getTbl20Nendo().getTxt20NendoJikofutangaku7GatsuGo();
    }

    @JsonIgnore
    public TextBoxNum getTxt20Nendo70Kara74Futangaku7GatsuMae() {
        return this.getTbl20Nendo().getTxt20Nendo70Kara74Futangaku7GatsuMae();
    }

    @JsonIgnore
    public TextBoxNum getTxt20Nendo70Kara74Futangaku7GatsuGo() {
        return this.getTbl20Nendo().getTxt20Nendo70Kara74Futangaku7GatsuGo();
    }

    @JsonIgnore
    public TextBoxNum getTxt20NendoKougakuKaigoServicehi7GatsuMae() {
        return this.getTbl20Nendo().getTxt20NendoKougakuKaigoServicehi7GatsuMae();
    }

    @JsonIgnore
    public TextBoxNum getTxt20NendoKougakuKaigoServicehi7GatsuGo() {
        return this.getTbl20Nendo().getTxt20NendoKougakuKaigoServicehi7GatsuGo();
    }

    @JsonIgnore
    public TextBoxNum getTxt20NendoJissaiJikofutangaku7GatsuMae() {
        return this.getTbl20Nendo().getTxt20NendoJissaiJikofutangaku7GatsuMae();
    }

    @JsonIgnore
    public TextBoxNum getTxt20NendoJissaiJikofutangaku7GatsuGo() {
        return this.getTbl20Nendo().getTxt20NendoJissaiJikofutangaku7GatsuGo();
    }

    @JsonIgnore
    public Label getLbl20NendoTaishouTsukiYoku4Gatsu() {
        return this.getTbl20Nendo().getLbl20NendoTaishouTsukiYoku4Gatsu();
    }

    @JsonIgnore
    public TextBoxNum getTxt20NendoJikofutangakuYoku4GatsuMae() {
        return this.getTbl20Nendo().getTxt20NendoJikofutangakuYoku4GatsuMae();
    }

    @JsonIgnore
    public TextBoxNum getTxt20NendoJikofutangakuYoku4GatsuGo() {
        return this.getTbl20Nendo().getTxt20NendoJikofutangakuYoku4GatsuGo();
    }

    @JsonIgnore
    public TextBoxNum getTxt20Nendo70Kara74FutangakuYoku4GatsuMae() {
        return this.getTbl20Nendo().getTxt20Nendo70Kara74FutangakuYoku4GatsuMae();
    }

    @JsonIgnore
    public TextBoxNum getTxt20Nendo70Kara74FutangakuYoku4GatsuGo() {
        return this.getTbl20Nendo().getTxt20Nendo70Kara74FutangakuYoku4GatsuGo();
    }

    @JsonIgnore
    public TextBoxNum getTxt20NendoKougakuKaigoServicehiYoku4GatsuMae() {
        return this.getTbl20Nendo().getTxt20NendoKougakuKaigoServicehiYoku4GatsuMae();
    }

    @JsonIgnore
    public TextBoxNum getTxt20NendoKougakuKaigoServicehiYoku4GatsuGo() {
        return this.getTbl20Nendo().getTxt20NendoKougakuKaigoServicehiYoku4GatsuGo();
    }

    @JsonIgnore
    public TextBoxNum getTxt20NendoJissaiJikofutangakuYoku4GatsuMae() {
        return this.getTbl20Nendo().getTxt20NendoJissaiJikofutangakuYoku4GatsuMae();
    }

    @JsonIgnore
    public TextBoxNum getTxt20NendoJissaiJikofutangakuYoku4GatsuGo() {
        return this.getTbl20Nendo().getTxt20NendoJissaiJikofutangakuYoku4GatsuGo();
    }

    @JsonIgnore
    public Label getLbl20NendoTaishouTsuki8Gatsu() {
        return this.getTbl20Nendo().getLbl20NendoTaishouTsuki8Gatsu();
    }

    @JsonIgnore
    public TextBoxNum getTxt20NendoJikofutangaku8GatsuMae() {
        return this.getTbl20Nendo().getTxt20NendoJikofutangaku8GatsuMae();
    }

    @JsonIgnore
    public TextBoxNum getTxt20NendoJikofutangaku8GatsuGo() {
        return this.getTbl20Nendo().getTxt20NendoJikofutangaku8GatsuGo();
    }

    @JsonIgnore
    public TextBoxNum getTxt20Nendo70Kara74Futangaku8GatsuMae() {
        return this.getTbl20Nendo().getTxt20Nendo70Kara74Futangaku8GatsuMae();
    }

    @JsonIgnore
    public TextBoxNum getTxt20Nendo70Kara74Futangaku8GatsuGo() {
        return this.getTbl20Nendo().getTxt20Nendo70Kara74Futangaku8GatsuGo();
    }

    @JsonIgnore
    public TextBoxNum getTxt20NendoKougakuKaigoServicehi8GatsuMae() {
        return this.getTbl20Nendo().getTxt20NendoKougakuKaigoServicehi8GatsuMae();
    }

    @JsonIgnore
    public TextBoxNum getTxt20NendoKougakuKaigoServicehi8GatsuGo() {
        return this.getTbl20Nendo().getTxt20NendoKougakuKaigoServicehi8GatsuGo();
    }

    @JsonIgnore
    public TextBoxNum getTxt20NendoJissaiJikofutangaku8GatsuMae() {
        return this.getTbl20Nendo().getTxt20NendoJissaiJikofutangaku8GatsuMae();
    }

    @JsonIgnore
    public TextBoxNum getTxt20NendoJissaiJikofutangaku8GatsuGo() {
        return this.getTbl20Nendo().getTxt20NendoJissaiJikofutangaku8GatsuGo();
    }

    @JsonIgnore
    public Label getLbl20NendoTaishouTsukiYoku5Gatsu() {
        return this.getTbl20Nendo().getLbl20NendoTaishouTsukiYoku5Gatsu();
    }

    @JsonIgnore
    public TextBoxNum getTxt20NendoJikofutangakuYoku5GatsuMae() {
        return this.getTbl20Nendo().getTxt20NendoJikofutangakuYoku5GatsuMae();
    }

    @JsonIgnore
    public TextBoxNum getTxt20NendoJikofutangakuYoku5GatsuGo() {
        return this.getTbl20Nendo().getTxt20NendoJikofutangakuYoku5GatsuGo();
    }

    @JsonIgnore
    public TextBoxNum getTxt20Nendo70Kara74FutangakuYoku5GatsuMae() {
        return this.getTbl20Nendo().getTxt20Nendo70Kara74FutangakuYoku5GatsuMae();
    }

    @JsonIgnore
    public TextBoxNum getTxt20Nendo70Kara74FutangakuYoku5GatsuGo() {
        return this.getTbl20Nendo().getTxt20Nendo70Kara74FutangakuYoku5GatsuGo();
    }

    @JsonIgnore
    public TextBoxNum getTxt20NendoKougakuKaigoServicehiYoku5GatsuMae() {
        return this.getTbl20Nendo().getTxt20NendoKougakuKaigoServicehiYoku5GatsuMae();
    }

    @JsonIgnore
    public TextBoxNum getTxt20NendoKougakuKaigoServicehiYoku5GatsuGo() {
        return this.getTbl20Nendo().getTxt20NendoKougakuKaigoServicehiYoku5GatsuGo();
    }

    @JsonIgnore
    public TextBoxNum getTxt20NendoJissaiJikofutangakuYoku5GatsuMae() {
        return this.getTbl20Nendo().getTxt20NendoJissaiJikofutangakuYoku5GatsuMae();
    }

    @JsonIgnore
    public TextBoxNum getTxt20NendoJissaiJikofutangakuYoku5GatsuGo() {
        return this.getTbl20Nendo().getTxt20NendoJissaiJikofutangakuYoku5GatsuGo();
    }

    @JsonIgnore
    public Label getLbl20NendoTaishouTsuki9Gatsu() {
        return this.getTbl20Nendo().getLbl20NendoTaishouTsuki9Gatsu();
    }

    @JsonIgnore
    public TextBoxNum getTxt20NendoJikofutangaku9GatsuMae() {
        return this.getTbl20Nendo().getTxt20NendoJikofutangaku9GatsuMae();
    }

    @JsonIgnore
    public TextBoxNum getTxt20NendoJikofutangaku9GatsuGo() {
        return this.getTbl20Nendo().getTxt20NendoJikofutangaku9GatsuGo();
    }

    @JsonIgnore
    public TextBoxNum getTxt20Nendo70Kara74Futangaku9GatsuMae() {
        return this.getTbl20Nendo().getTxt20Nendo70Kara74Futangaku9GatsuMae();
    }

    @JsonIgnore
    public TextBoxNum getTxt20Nendo70Kara74Futangaku9GatsuGo() {
        return this.getTbl20Nendo().getTxt20Nendo70Kara74Futangaku9GatsuGo();
    }

    @JsonIgnore
    public TextBoxNum getTxt20NendoKougakuKaigoServicehi9GatsuMae() {
        return this.getTbl20Nendo().getTxt20NendoKougakuKaigoServicehi9GatsuMae();
    }

    @JsonIgnore
    public TextBoxNum getTxt20NendoKougakuKaigoServicehi9GatsuGo() {
        return this.getTbl20Nendo().getTxt20NendoKougakuKaigoServicehi9GatsuGo();
    }

    @JsonIgnore
    public TextBoxNum getTxt20NendoJissaiJikofutangaku9GatsuMae() {
        return this.getTbl20Nendo().getTxt20NendoJissaiJikofutangaku9GatsuMae();
    }

    @JsonIgnore
    public TextBoxNum getTxt20NendoJissaiJikofutangaku9GatsuGo() {
        return this.getTbl20Nendo().getTxt20NendoJissaiJikofutangaku9GatsuGo();
    }

    @JsonIgnore
    public Label getLbl20NendoTaishouTsukiYoku6Gatsu() {
        return this.getTbl20Nendo().getLbl20NendoTaishouTsukiYoku6Gatsu();
    }

    @JsonIgnore
    public TextBoxNum getTxt20NendoJikofutangakuYoku6GatsuMae() {
        return this.getTbl20Nendo().getTxt20NendoJikofutangakuYoku6GatsuMae();
    }

    @JsonIgnore
    public TextBoxNum getTxt20NendoJikofutangakuYoku6GatsuGo() {
        return this.getTbl20Nendo().getTxt20NendoJikofutangakuYoku6GatsuGo();
    }

    @JsonIgnore
    public TextBoxNum getTxt20Nendo70Kara74FutangakuYoku6GatsuMae() {
        return this.getTbl20Nendo().getTxt20Nendo70Kara74FutangakuYoku6GatsuMae();
    }

    @JsonIgnore
    public TextBoxNum getTxt20Nendo70Kara74FutangakuYoku6GatsuGo() {
        return this.getTbl20Nendo().getTxt20Nendo70Kara74FutangakuYoku6GatsuGo();
    }

    @JsonIgnore
    public TextBoxNum getTxt20NendoKougakuKaigoServicehiYoku6GatsuMae() {
        return this.getTbl20Nendo().getTxt20NendoKougakuKaigoServicehiYoku6GatsuMae();
    }

    @JsonIgnore
    public TextBoxNum getTxt20NendoKougakuKaigoServicehiYoku6GatsuGo() {
        return this.getTbl20Nendo().getTxt20NendoKougakuKaigoServicehiYoku6GatsuGo();
    }

    @JsonIgnore
    public TextBoxNum getTxt20NendoJissaiJikofutangakuYoku6GatsuMae() {
        return this.getTbl20Nendo().getTxt20NendoJissaiJikofutangakuYoku6GatsuMae();
    }

    @JsonIgnore
    public TextBoxNum getTxt20NendoJissaiJikofutangakuYoku6GatsuGo() {
        return this.getTbl20Nendo().getTxt20NendoJissaiJikofutangakuYoku6GatsuGo();
    }

    @JsonIgnore
    public Label getLbl20NendoTaishouTsuki10Gatsu() {
        return this.getTbl20Nendo().getLbl20NendoTaishouTsuki10Gatsu();
    }

    @JsonIgnore
    public TextBoxNum getTxt20NendoJikofutangaku10GatsuMae() {
        return this.getTbl20Nendo().getTxt20NendoJikofutangaku10GatsuMae();
    }

    @JsonIgnore
    public TextBoxNum getTxt20NendoJikofutangaku10GatsuGo() {
        return this.getTbl20Nendo().getTxt20NendoJikofutangaku10GatsuGo();
    }

    @JsonIgnore
    public TextBoxNum getTxt20Nendo70Kara74Futangaku10GatsuMae() {
        return this.getTbl20Nendo().getTxt20Nendo70Kara74Futangaku10GatsuMae();
    }

    @JsonIgnore
    public TextBoxNum getTxt20Nendo70Kara74Futangaku10GatsuGo() {
        return this.getTbl20Nendo().getTxt20Nendo70Kara74Futangaku10GatsuGo();
    }

    @JsonIgnore
    public TextBoxNum getTxt20NendoKougakuKaigoServicehi10GatsuMae() {
        return this.getTbl20Nendo().getTxt20NendoKougakuKaigoServicehi10GatsuMae();
    }

    @JsonIgnore
    public TextBoxNum getTxt20NendoKougakuKaigoServicehi10GatsuGo() {
        return this.getTbl20Nendo().getTxt20NendoKougakuKaigoServicehi10GatsuGo();
    }

    @JsonIgnore
    public TextBoxNum getTxt20NendoJissaiJikofutangaku10GatsuMae() {
        return this.getTbl20Nendo().getTxt20NendoJissaiJikofutangaku10GatsuMae();
    }

    @JsonIgnore
    public TextBoxNum getTxt20NendoJissaiJikofutangaku10GatsuGo() {
        return this.getTbl20Nendo().getTxt20NendoJissaiJikofutangaku10GatsuGo();
    }

    @JsonIgnore
    public Label getLbl20NendoTaishouTsukiYoku7Gatsu() {
        return this.getTbl20Nendo().getLbl20NendoTaishouTsukiYoku7Gatsu();
    }

    @JsonIgnore
    public TextBoxNum getTxt20NendoJikofutangakuYoku7GatsuMae() {
        return this.getTbl20Nendo().getTxt20NendoJikofutangakuYoku7GatsuMae();
    }

    @JsonIgnore
    public TextBoxNum getTxt20NendoJikofutangakuYoku7GatsuGo() {
        return this.getTbl20Nendo().getTxt20NendoJikofutangakuYoku7GatsuGo();
    }

    @JsonIgnore
    public TextBoxNum getTxt20Nendo70Kara74FutangakuYoku7GatsuMae() {
        return this.getTbl20Nendo().getTxt20Nendo70Kara74FutangakuYoku7GatsuMae();
    }

    @JsonIgnore
    public TextBoxNum getTxt20Nendo70Kara74FutangakuYoku7GatsuGo() {
        return this.getTbl20Nendo().getTxt20Nendo70Kara74FutangakuYoku7GatsuGo();
    }

    @JsonIgnore
    public TextBoxNum getTxt20NendoKougakuKaigoServicehiYoku7GatsuMae() {
        return this.getTbl20Nendo().getTxt20NendoKougakuKaigoServicehiYoku7GatsuMae();
    }

    @JsonIgnore
    public TextBoxNum getTxt20NendoKougakuKaigoServicehiYoku7GatsuGo() {
        return this.getTbl20Nendo().getTxt20NendoKougakuKaigoServicehiYoku7GatsuGo();
    }

    @JsonIgnore
    public TextBoxNum getTxt20NendoJissaiJikofutangakuYoku7GatsuMae() {
        return this.getTbl20Nendo().getTxt20NendoJissaiJikofutangakuYoku7GatsuMae();
    }

    @JsonIgnore
    public TextBoxNum getTxt20NendoJissaiJikofutangakuYoku7GatsuGo() {
        return this.getTbl20Nendo().getTxt20NendoJissaiJikofutangakuYoku7GatsuGo();
    }

    @JsonIgnore
    public Label getLbl20NendoTaishouTsuki11Gatsu() {
        return this.getTbl20Nendo().getLbl20NendoTaishouTsuki11Gatsu();
    }

    @JsonIgnore
    public TextBoxNum getTxt20NendoJikofutangaku11GatsuMae() {
        return this.getTbl20Nendo().getTxt20NendoJikofutangaku11GatsuMae();
    }

    @JsonIgnore
    public TextBoxNum getTxt20NendoJikofutangaku11GatsuGo() {
        return this.getTbl20Nendo().getTxt20NendoJikofutangaku11GatsuGo();
    }

    @JsonIgnore
    public TextBoxNum getTxt20Nendo70Kara74Futangaku11GatsuMae() {
        return this.getTbl20Nendo().getTxt20Nendo70Kara74Futangaku11GatsuMae();
    }

    @JsonIgnore
    public TextBoxNum getTxt20Nendo70Kara74Futangaku11GatsuGo() {
        return this.getTbl20Nendo().getTxt20Nendo70Kara74Futangaku11GatsuGo();
    }

    @JsonIgnore
    public TextBoxNum getTxt20NendoKougakuKaigoServicehi11GatsuMae() {
        return this.getTbl20Nendo().getTxt20NendoKougakuKaigoServicehi11GatsuMae();
    }

    @JsonIgnore
    public TextBoxNum getTxt20NendoKougakuKaigoServicehi11GatsuGo() {
        return this.getTbl20Nendo().getTxt20NendoKougakuKaigoServicehi11GatsuGo();
    }

    @JsonIgnore
    public TextBoxNum getTxt20NendoJissaiJikofutangaku11GatsuMae() {
        return this.getTbl20Nendo().getTxt20NendoJissaiJikofutangaku11GatsuMae();
    }

    @JsonIgnore
    public TextBoxNum getTxt20NendoJissaiJikofutangaku11GatsuGo() {
        return this.getTbl20Nendo().getTxt20NendoJissaiJikofutangaku11GatsuGo();
    }

    @JsonIgnore
    public Label getLbl20NendoTaishouTsuki12Gatsu() {
        return this.getTbl20Nendo().getLbl20NendoTaishouTsuki12Gatsu();
    }

    @JsonIgnore
    public TextBoxNum getTxt20NendoJikofutangaku12GatsuMae() {
        return this.getTbl20Nendo().getTxt20NendoJikofutangaku12GatsuMae();
    }

    @JsonIgnore
    public TextBoxNum getTxt20NendoJikofutangaku12GatsuGo() {
        return this.getTbl20Nendo().getTxt20NendoJikofutangaku12GatsuGo();
    }

    @JsonIgnore
    public TextBoxNum getTxt20Nendo70Kara74Futangaku12GatsuMae() {
        return this.getTbl20Nendo().getTxt20Nendo70Kara74Futangaku12GatsuMae();
    }

    @JsonIgnore
    public TextBoxNum getTxt20Nendo70Kara74Futangaku12GatsuGo() {
        return this.getTbl20Nendo().getTxt20Nendo70Kara74Futangaku12GatsuGo();
    }

    @JsonIgnore
    public TextBoxNum getTxt20NendoKougakuKaigoServicehi12GatsuMae() {
        return this.getTbl20Nendo().getTxt20NendoKougakuKaigoServicehi12GatsuMae();
    }

    @JsonIgnore
    public TextBoxNum getTxt20NendoKougakuKaigoServicehi12GatsuGo() {
        return this.getTbl20Nendo().getTxt20NendoKougakuKaigoServicehi12GatsuGo();
    }

    @JsonIgnore
    public TextBoxNum getTxt20NendoJissaiJikofutangaku12GatsuMae() {
        return this.getTbl20Nendo().getTxt20NendoJissaiJikofutangaku12GatsuMae();
    }

    @JsonIgnore
    public TextBoxNum getTxt20NendoJissaiJikofutangaku12GatsuGo() {
        return this.getTbl20Nendo().getTxt20NendoJissaiJikofutangaku12GatsuGo();
    }

    @JsonIgnore
    public Label getLbl20NendoTaishouTsukiGoukei() {
        return this.getTbl20Nendo().getLbl20NendoTaishouTsukiGoukei();
    }

    @JsonIgnore
    public TextBoxNum getTxt20NendoJikofutangakuGoukeiMae() {
        return this.getTbl20Nendo().getTxt20NendoJikofutangakuGoukeiMae();
    }

    @JsonIgnore
    public TextBoxNum getTxt20NendoJikofutangakuGoukeiGo() {
        return this.getTbl20Nendo().getTxt20NendoJikofutangakuGoukeiGo();
    }

    @JsonIgnore
    public TextBoxNum getTxt20Nendo70Kara74FutangakuGoukeiMae() {
        return this.getTbl20Nendo().getTxt20Nendo70Kara74FutangakuGoukeiMae();
    }

    @JsonIgnore
    public TextBoxNum getTxt20Nendo70Kara74FutangakuGoukeiGo() {
        return this.getTbl20Nendo().getTxt20Nendo70Kara74FutangakuGoukeiGo();
    }

    @JsonIgnore
    public TextBoxNum getTxt20NendoKougakuKaigoServicehiGoukeiMae() {
        return this.getTbl20Nendo().getTxt20NendoKougakuKaigoServicehiGoukeiMae();
    }

    @JsonIgnore
    public TextBoxNum getTxt20NendoKougakuKaigoServicehiGoukeiGo() {
        return this.getTbl20Nendo().getTxt20NendoKougakuKaigoServicehiGoukeiGo();
    }

    @JsonIgnore
    public TextBoxNum getTxt20NendoJissaiJikofutangakuGoukeiMae() {
        return this.getTbl20Nendo().getTxt20NendoJissaiJikofutangakuGoukeiMae();
    }

    @JsonIgnore
    public TextBoxNum getTxt20NendoJissaiJikofutangakuGoukeiGo() {
        return this.getTbl20Nendo().getTxt20NendoJissaiJikofutangakuGoukeiGo();
    }

    // </editor-fold>
}
