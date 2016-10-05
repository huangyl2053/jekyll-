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
 * JikoFutangakuHosei2b のクラスファイル
 *
 * @reamsid_L DBC-2080-030 jianglaisheng
 */
public class JikoFutangakuHosei2bDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-07-28_11-34-20">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("tbl20Igai")
    private tbl20IgaiDiv tbl20Igai;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettbl20Igai
     * @return tbl20Igai
     */
    @JsonProperty("tbl20Igai")
    public tbl20IgaiDiv getTbl20Igai() {
        return tbl20Igai;
    }

    /*
     * settbl20Igai
     * @param tbl20Igai tbl20Igai
     */
    @JsonProperty("tbl20Igai")
    public void setTbl20Igai(tbl20IgaiDiv tbl20Igai) {
        this.tbl20Igai = tbl20Igai;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public Label getLbl20IgaiTaishouTsukiMidashi1() {
        return this.getTbl20Igai().getLbl20IgaiTaishouTsukiMidashi1();
    }

    @JsonIgnore
    public Label getLbl20IgaiJikofutangakuMidashi1() {
        return this.getTbl20Igai().getLbl20IgaiJikofutangakuMidashi1();
    }

    @JsonIgnore
    public Label getLbl20Igai70Kara74FutangakuMidashi1() {
        return this.getTbl20Igai().getLbl20Igai70Kara74FutangakuMidashi1();
    }

    @JsonIgnore
    public Label getLbl20IgaiKougakuKaigoServicehiMidashi1() {
        return this.getTbl20Igai().getLbl20IgaiKougakuKaigoServicehiMidashi1();
    }

    @JsonIgnore
    public Label getLbl20IgaiJissaiJikofutangakuMidashi1() {
        return this.getTbl20Igai().getLbl20IgaiJissaiJikofutangakuMidashi1();
    }

    @JsonIgnore
    public Label getLbl20IgaiTaishouTsukiMidashi2() {
        return this.getTbl20Igai().getLbl20IgaiTaishouTsukiMidashi2();
    }

    @JsonIgnore
    public Label getLbl20IgaiJikofutangakuMidashi2() {
        return this.getTbl20Igai().getLbl20IgaiJikofutangakuMidashi2();
    }

    @JsonIgnore
    public Label getLbl20Igai70Kara74FutangakuMidashi2() {
        return this.getTbl20Igai().getLbl20Igai70Kara74FutangakuMidashi2();
    }

    @JsonIgnore
    public Label getLbl20IgaiKougakuKaigoServicehiMidashi2() {
        return this.getTbl20Igai().getLbl20IgaiKougakuKaigoServicehiMidashi2();
    }

    @JsonIgnore
    public Label getLbl20IgaiJissaiJikofutangakuMidashi2() {
        return this.getTbl20Igai().getLbl20IgaiJissaiJikofutangakuMidashi2();
    }

    @JsonIgnore
    public Label getLbl20IgaiTaishouTsuki8Gatsu() {
        return this.getTbl20Igai().getLbl20IgaiTaishouTsuki8Gatsu();
    }

    @JsonIgnore
    public TextBoxNum getTxt20IgaiJikofutangaku8GatsuMae() {
        return this.getTbl20Igai().getTxt20IgaiJikofutangaku8GatsuMae();
    }

    @JsonIgnore
    public TextBoxNum getTxt20IgaiJikofutangaku8GatsuGo() {
        return this.getTbl20Igai().getTxt20IgaiJikofutangaku8GatsuGo();
    }

    @JsonIgnore
    public TextBoxNum getTxt20Igai70Kara74Futangaku8GatsuMae() {
        return this.getTbl20Igai().getTxt20Igai70Kara74Futangaku8GatsuMae();
    }

    @JsonIgnore
    public TextBoxNum getTxt20Igai70Kara74Futangaku8GatsuGo() {
        return this.getTbl20Igai().getTxt20Igai70Kara74Futangaku8GatsuGo();
    }

    @JsonIgnore
    public TextBoxNum getTxt20IgaiKougakuKaigoServicehi8GatsuMae() {
        return this.getTbl20Igai().getTxt20IgaiKougakuKaigoServicehi8GatsuMae();
    }

    @JsonIgnore
    public TextBoxNum getTxt20IgaiKougakuKaigoServicehi8GatsuGo() {
        return this.getTbl20Igai().getTxt20IgaiKougakuKaigoServicehi8GatsuGo();
    }

    @JsonIgnore
    public TextBoxNum getTxt20IgaiJissaiJikofutangaku8GatsuMae() {
        return this.getTbl20Igai().getTxt20IgaiJissaiJikofutangaku8GatsuMae();
    }

    @JsonIgnore
    public TextBoxNum getTxt20IgaiJissaiJikofutangaku8GatsuGo() {
        return this.getTbl20Igai().getTxt20IgaiJissaiJikofutangaku8GatsuGo();
    }

    @JsonIgnore
    public Label getLbl20IgaiTaishouTsukiYoku2Gatsu() {
        return this.getTbl20Igai().getLbl20IgaiTaishouTsukiYoku2Gatsu();
    }

    @JsonIgnore
    public TextBoxNum getTxt20IgaiJikofutangakuYoku2GatsuMae() {
        return this.getTbl20Igai().getTxt20IgaiJikofutangakuYoku2GatsuMae();
    }

    @JsonIgnore
    public TextBoxNum getTxt20IgaiJikofutangakuYoku2GatsuGo() {
        return this.getTbl20Igai().getTxt20IgaiJikofutangakuYoku2GatsuGo();
    }

    @JsonIgnore
    public TextBoxNum getTxt20Igai70Kara74FutangakuYoku2GatsuMae() {
        return this.getTbl20Igai().getTxt20Igai70Kara74FutangakuYoku2GatsuMae();
    }

    @JsonIgnore
    public TextBoxNum getTxt20Igai70Kara74FutangakuYoku2GatsuGo() {
        return this.getTbl20Igai().getTxt20Igai70Kara74FutangakuYoku2GatsuGo();
    }

    @JsonIgnore
    public TextBoxNum getTxt20IgaiKougakuKaigoServicehiYoku2GatsuMae() {
        return this.getTbl20Igai().getTxt20IgaiKougakuKaigoServicehiYoku2GatsuMae();
    }

    @JsonIgnore
    public TextBoxNum getTxt20IgaiKougakuKaigoServicehiYoku2GatsuGo() {
        return this.getTbl20Igai().getTxt20IgaiKougakuKaigoServicehiYoku2GatsuGo();
    }

    @JsonIgnore
    public TextBoxNum getTxt20IgaiJissaiJikofutangakuYoku2GatsuMae() {
        return this.getTbl20Igai().getTxt20IgaiJissaiJikofutangakuYoku2GatsuMae();
    }

    @JsonIgnore
    public TextBoxNum getTxt20IgaiJissaiJikofutangakuYoku2GatsuGo() {
        return this.getTbl20Igai().getTxt20IgaiJissaiJikofutangakuYoku2GatsuGo();
    }

    @JsonIgnore
    public Label getLbl20IgaiTaishouTsuki9Gatsu() {
        return this.getTbl20Igai().getLbl20IgaiTaishouTsuki9Gatsu();
    }

    @JsonIgnore
    public TextBoxNum getTxt20IgaiJikofutangaku9GatsuMae() {
        return this.getTbl20Igai().getTxt20IgaiJikofutangaku9GatsuMae();
    }

    @JsonIgnore
    public TextBoxNum getTxt20IgaiJikofutangaku9GatsuGo() {
        return this.getTbl20Igai().getTxt20IgaiJikofutangaku9GatsuGo();
    }

    @JsonIgnore
    public TextBoxNum getTxt20Igai70Kara74Futangaku9GatsuMae() {
        return this.getTbl20Igai().getTxt20Igai70Kara74Futangaku9GatsuMae();
    }

    @JsonIgnore
    public TextBoxNum getTxt20Igai70Kara74Futangaku9GatsuGo() {
        return this.getTbl20Igai().getTxt20Igai70Kara74Futangaku9GatsuGo();
    }

    @JsonIgnore
    public TextBoxNum getTxt20IgaiKougakuKaigoServicehi9GatsuMae() {
        return this.getTbl20Igai().getTxt20IgaiKougakuKaigoServicehi9GatsuMae();
    }

    @JsonIgnore
    public TextBoxNum getTxt20IgaiKougakuKaigoServicehi9GatsuGo() {
        return this.getTbl20Igai().getTxt20IgaiKougakuKaigoServicehi9GatsuGo();
    }

    @JsonIgnore
    public TextBoxNum getTxt20IgaiJissaiJikofutangaku9GatsuMae() {
        return this.getTbl20Igai().getTxt20IgaiJissaiJikofutangaku9GatsuMae();
    }

    @JsonIgnore
    public TextBoxNum getTxt20IgaiJissaiJikofutangaku9GatsuGo() {
        return this.getTbl20Igai().getTxt20IgaiJissaiJikofutangaku9GatsuGo();
    }

    @JsonIgnore
    public Label getLbl20IgaiTaishouTsukiYoku3Gatsu() {
        return this.getTbl20Igai().getLbl20IgaiTaishouTsukiYoku3Gatsu();
    }

    @JsonIgnore
    public TextBoxNum getTxt20IgaiJikofutangakuYoku3GatsuMae() {
        return this.getTbl20Igai().getTxt20IgaiJikofutangakuYoku3GatsuMae();
    }

    @JsonIgnore
    public TextBoxNum getTxt20IgaiJikofutangakuYoku3GatsuGo() {
        return this.getTbl20Igai().getTxt20IgaiJikofutangakuYoku3GatsuGo();
    }

    @JsonIgnore
    public TextBoxNum getTxt20Igai70Kara74FutangakuYoku3GatsuMae() {
        return this.getTbl20Igai().getTxt20Igai70Kara74FutangakuYoku3GatsuMae();
    }

    @JsonIgnore
    public TextBoxNum getTxt20Igai70Kara74FutangakuYoku3GatsuGo() {
        return this.getTbl20Igai().getTxt20Igai70Kara74FutangakuYoku3GatsuGo();
    }

    @JsonIgnore
    public TextBoxNum getTxt20IgaiKougakuKaigoServicehiYoku3GatsuMae() {
        return this.getTbl20Igai().getTxt20IgaiKougakuKaigoServicehiYoku3GatsuMae();
    }

    @JsonIgnore
    public TextBoxNum getTxt20IgaiKougakuKaigoServicehiYoku3GatsuGo() {
        return this.getTbl20Igai().getTxt20IgaiKougakuKaigoServicehiYoku3GatsuGo();
    }

    @JsonIgnore
    public TextBoxNum getTxt20IgaiJissaiJikofutangakuYoku3GatsuMae() {
        return this.getTbl20Igai().getTxt20IgaiJissaiJikofutangakuYoku3GatsuMae();
    }

    @JsonIgnore
    public TextBoxNum getTxt20IgaiJissaiJikofutangakuYoku3GatsuGo() {
        return this.getTbl20Igai().getTxt20IgaiJissaiJikofutangakuYoku3GatsuGo();
    }

    @JsonIgnore
    public Label getLbl20IgaiTaishouTsuki10Gatsu() {
        return this.getTbl20Igai().getLbl20IgaiTaishouTsuki10Gatsu();
    }

    @JsonIgnore
    public TextBoxNum getTxt20IgaiJikofutangaku10GatsuMae() {
        return this.getTbl20Igai().getTxt20IgaiJikofutangaku10GatsuMae();
    }

    @JsonIgnore
    public TextBoxNum getTxt20IgaiJikofutangaku10GatsuGo() {
        return this.getTbl20Igai().getTxt20IgaiJikofutangaku10GatsuGo();
    }

    @JsonIgnore
    public TextBoxNum getTxt20Igai70Kara74Futangaku10GatsuMae() {
        return this.getTbl20Igai().getTxt20Igai70Kara74Futangaku10GatsuMae();
    }

    @JsonIgnore
    public TextBoxNum getTxt20Igai70Kara74Futangaku10GatsuGo() {
        return this.getTbl20Igai().getTxt20Igai70Kara74Futangaku10GatsuGo();
    }

    @JsonIgnore
    public TextBoxNum getTxt20IgaiKougakuKaigoServicehi10GatsuMae() {
        return this.getTbl20Igai().getTxt20IgaiKougakuKaigoServicehi10GatsuMae();
    }

    @JsonIgnore
    public TextBoxNum getTxt20IgaiKougakuKaigoServicehi10GatsuGo() {
        return this.getTbl20Igai().getTxt20IgaiKougakuKaigoServicehi10GatsuGo();
    }

    @JsonIgnore
    public TextBoxNum getTxt20IgaiJissaiJikofutangaku10GatsuMae() {
        return this.getTbl20Igai().getTxt20IgaiJissaiJikofutangaku10GatsuMae();
    }

    @JsonIgnore
    public TextBoxNum getTxt20IgaiJissaiJikofutangaku10GatsuGo() {
        return this.getTbl20Igai().getTxt20IgaiJissaiJikofutangaku10GatsuGo();
    }

    @JsonIgnore
    public Label getLbl20IgaiTaishouTsukiYoku4Gatsu() {
        return this.getTbl20Igai().getLbl20IgaiTaishouTsukiYoku4Gatsu();
    }

    @JsonIgnore
    public TextBoxNum getTxt20IgaiJikofutangakuYoku4GatsuMae() {
        return this.getTbl20Igai().getTxt20IgaiJikofutangakuYoku4GatsuMae();
    }

    @JsonIgnore
    public TextBoxNum getTxt20IgaiJikofutangakuYoku4GatsuGo() {
        return this.getTbl20Igai().getTxt20IgaiJikofutangakuYoku4GatsuGo();
    }

    @JsonIgnore
    public TextBoxNum getTxt20Igai70Kara74FutangakuYoku4GatsuMae() {
        return this.getTbl20Igai().getTxt20Igai70Kara74FutangakuYoku4GatsuMae();
    }

    @JsonIgnore
    public TextBoxNum getTxt20Igai70Kara74FutangakuYoku4GatsuGo() {
        return this.getTbl20Igai().getTxt20Igai70Kara74FutangakuYoku4GatsuGo();
    }

    @JsonIgnore
    public TextBoxNum getTxt20IgaiKougakuKaigoServicehiYoku4GatsuMae() {
        return this.getTbl20Igai().getTxt20IgaiKougakuKaigoServicehiYoku4GatsuMae();
    }

    @JsonIgnore
    public TextBoxNum getTxt20IgaiKougakuKaigoServicehiYoku4GatsuGo() {
        return this.getTbl20Igai().getTxt20IgaiKougakuKaigoServicehiYoku4GatsuGo();
    }

    @JsonIgnore
    public TextBoxNum getTxt20IgaiJissaiJikofutangakuYoku4GatsuMae() {
        return this.getTbl20Igai().getTxt20IgaiJissaiJikofutangakuYoku4GatsuMae();
    }

    @JsonIgnore
    public TextBoxNum getTxt20IgaiJissaiJikofutangakuYoku4GatsuGo() {
        return this.getTbl20Igai().getTxt20IgaiJissaiJikofutangakuYoku4GatsuGo();
    }

    @JsonIgnore
    public Label getLbl20IgaiTaishouTsuki11Gatsu() {
        return this.getTbl20Igai().getLbl20IgaiTaishouTsuki11Gatsu();
    }

    @JsonIgnore
    public TextBoxNum getTxt20IgaiJikofutangaku11GatsuMae() {
        return this.getTbl20Igai().getTxt20IgaiJikofutangaku11GatsuMae();
    }

    @JsonIgnore
    public TextBoxNum getTxt20IgaiJikofutangaku11GatsuGo() {
        return this.getTbl20Igai().getTxt20IgaiJikofutangaku11GatsuGo();
    }

    @JsonIgnore
    public TextBoxNum getTxt20Igai70Kara74Futangaku11GatsuMae() {
        return this.getTbl20Igai().getTxt20Igai70Kara74Futangaku11GatsuMae();
    }

    @JsonIgnore
    public TextBoxNum getTxt20Igai70Kara74Futangaku11GatsuGo() {
        return this.getTbl20Igai().getTxt20Igai70Kara74Futangaku11GatsuGo();
    }

    @JsonIgnore
    public TextBoxNum getTxt20IgaiKougakuKaigoServicehi11GatsuMae() {
        return this.getTbl20Igai().getTxt20IgaiKougakuKaigoServicehi11GatsuMae();
    }

    @JsonIgnore
    public TextBoxNum getTxt20IgaiKougakuKaigoServicehi11GatsuGo() {
        return this.getTbl20Igai().getTxt20IgaiKougakuKaigoServicehi11GatsuGo();
    }

    @JsonIgnore
    public TextBoxNum getTxt20IgaiJissaiJikofutangaku11GatsuMae() {
        return this.getTbl20Igai().getTxt20IgaiJissaiJikofutangaku11GatsuMae();
    }

    @JsonIgnore
    public TextBoxNum getTxt20IgaiJissaiJikofutangaku11GatsuGo() {
        return this.getTbl20Igai().getTxt20IgaiJissaiJikofutangaku11GatsuGo();
    }

    @JsonIgnore
    public Label getLbl20IgaiTaishouTsukiYoku5Gatsu() {
        return this.getTbl20Igai().getLbl20IgaiTaishouTsukiYoku5Gatsu();
    }

    @JsonIgnore
    public TextBoxNum getTxt20IgaiJikofutangakuYoku5GatsuMae() {
        return this.getTbl20Igai().getTxt20IgaiJikofutangakuYoku5GatsuMae();
    }

    @JsonIgnore
    public TextBoxNum getTxt20IgaiJikofutangakuYoku5GatsuGo() {
        return this.getTbl20Igai().getTxt20IgaiJikofutangakuYoku5GatsuGo();
    }

    @JsonIgnore
    public TextBoxNum getTxt20Igai70Kara74FutangakuYoku5GatsuMae() {
        return this.getTbl20Igai().getTxt20Igai70Kara74FutangakuYoku5GatsuMae();
    }

    @JsonIgnore
    public TextBoxNum getTxt20Igai70Kara74FutangakuYoku5GatsuGo() {
        return this.getTbl20Igai().getTxt20Igai70Kara74FutangakuYoku5GatsuGo();
    }

    @JsonIgnore
    public TextBoxNum getTxt20IgaiKougakuKaigoServicehiYoku5GatsuMae() {
        return this.getTbl20Igai().getTxt20IgaiKougakuKaigoServicehiYoku5GatsuMae();
    }

    @JsonIgnore
    public TextBoxNum getTxt20IgaiKougakuKaigoServicehiYoku5GatsuGo() {
        return this.getTbl20Igai().getTxt20IgaiKougakuKaigoServicehiYoku5GatsuGo();
    }

    @JsonIgnore
    public TextBoxNum getTxt20IgaiJissaiJikofutangakuYoku5GatsuMae() {
        return this.getTbl20Igai().getTxt20IgaiJissaiJikofutangakuYoku5GatsuMae();
    }

    @JsonIgnore
    public TextBoxNum getTxt20IgaiJissaiJikofutangakuYoku5GatsuGo() {
        return this.getTbl20Igai().getTxt20IgaiJissaiJikofutangakuYoku5GatsuGo();
    }

    @JsonIgnore
    public Label getLbl20IgaiTaishouTsuki12Gatsu() {
        return this.getTbl20Igai().getLbl20IgaiTaishouTsuki12Gatsu();
    }

    @JsonIgnore
    public TextBoxNum getTxt20IgaiJikofutangaku12GatsuMae() {
        return this.getTbl20Igai().getTxt20IgaiJikofutangaku12GatsuMae();
    }

    @JsonIgnore
    public TextBoxNum getTxt20IgaiJikofutangaku12GatsuGo() {
        return this.getTbl20Igai().getTxt20IgaiJikofutangaku12GatsuGo();
    }

    @JsonIgnore
    public TextBoxNum getTxt20Igai70Kara74Futangaku12GatsuMae() {
        return this.getTbl20Igai().getTxt20Igai70Kara74Futangaku12GatsuMae();
    }

    @JsonIgnore
    public TextBoxNum getTxt20Igai70Kara74Futangaku12GatsuGo() {
        return this.getTbl20Igai().getTxt20Igai70Kara74Futangaku12GatsuGo();
    }

    @JsonIgnore
    public TextBoxNum getTxt20IgaiKougakuKaigoServicehi12GatsuMae() {
        return this.getTbl20Igai().getTxt20IgaiKougakuKaigoServicehi12GatsuMae();
    }

    @JsonIgnore
    public TextBoxNum getTxt20IgaiKougakuKaigoServicehi12GatsuGo() {
        return this.getTbl20Igai().getTxt20IgaiKougakuKaigoServicehi12GatsuGo();
    }

    @JsonIgnore
    public TextBoxNum getTxt20IgaiJissaiJikofutangaku12GatsuMae() {
        return this.getTbl20Igai().getTxt20IgaiJissaiJikofutangaku12GatsuMae();
    }

    @JsonIgnore
    public TextBoxNum getTxt20IgaiJissaiJikofutangaku12GatsuGo() {
        return this.getTbl20Igai().getTxt20IgaiJissaiJikofutangaku12GatsuGo();
    }

    @JsonIgnore
    public Label getLbl20IgaiTaishouTsukiYoku6Gatsu() {
        return this.getTbl20Igai().getLbl20IgaiTaishouTsukiYoku6Gatsu();
    }

    @JsonIgnore
    public TextBoxNum getTxt20IgaiJikofutangakuYoku6GatsuMae() {
        return this.getTbl20Igai().getTxt20IgaiJikofutangakuYoku6GatsuMae();
    }

    @JsonIgnore
    public TextBoxNum getTxt20IgaiJikofutangakuYoku6GatsuGo() {
        return this.getTbl20Igai().getTxt20IgaiJikofutangakuYoku6GatsuGo();
    }

    @JsonIgnore
    public TextBoxNum getTxt20Igai70Kara74FutangakuYoku6GatsuMae() {
        return this.getTbl20Igai().getTxt20Igai70Kara74FutangakuYoku6GatsuMae();
    }

    @JsonIgnore
    public TextBoxNum getTxt20Igai70Kara74FutangakuYoku6GatsuGo() {
        return this.getTbl20Igai().getTxt20Igai70Kara74FutangakuYoku6GatsuGo();
    }

    @JsonIgnore
    public TextBoxNum getTxt20IgaiKougakuKaigoServicehiYoku6GatsuMae() {
        return this.getTbl20Igai().getTxt20IgaiKougakuKaigoServicehiYoku6GatsuMae();
    }

    @JsonIgnore
    public TextBoxNum getTxt20IgaiKougakuKaigoServicehiYoku6GatsuGo() {
        return this.getTbl20Igai().getTxt20IgaiKougakuKaigoServicehiYoku6GatsuGo();
    }

    @JsonIgnore
    public TextBoxNum getTxt20IgaiJissaiJikofutangakuYoku6GatsuMae() {
        return this.getTbl20Igai().getTxt20IgaiJissaiJikofutangakuYoku6GatsuMae();
    }

    @JsonIgnore
    public TextBoxNum getTxt20IgaiJissaiJikofutangakuYoku6GatsuGo() {
        return this.getTbl20Igai().getTxt20IgaiJissaiJikofutangakuYoku6GatsuGo();
    }

    @JsonIgnore
    public Label getLbl20IgaiTaishouTsukiYoku1Gatsu() {
        return this.getTbl20Igai().getLbl20IgaiTaishouTsukiYoku1Gatsu();
    }

    @JsonIgnore
    public TextBoxNum getTxt20IgaiJikofutangakuYoku1GatsuMae() {
        return this.getTbl20Igai().getTxt20IgaiJikofutangakuYoku1GatsuMae();
    }

    @JsonIgnore
    public TextBoxNum getTxt20IgaiJikofutangakuYoku1GatsuGo() {
        return this.getTbl20Igai().getTxt20IgaiJikofutangakuYoku1GatsuGo();
    }

    @JsonIgnore
    public TextBoxNum getTxt20Igai70Kara74FutangakuYoku1GatsuMae() {
        return this.getTbl20Igai().getTxt20Igai70Kara74FutangakuYoku1GatsuMae();
    }

    @JsonIgnore
    public TextBoxNum getTxt20Igai70Kara74FutangakuYoku1GatsuGo() {
        return this.getTbl20Igai().getTxt20Igai70Kara74FutangakuYoku1GatsuGo();
    }

    @JsonIgnore
    public TextBoxNum getTxt20IgaiKougakuKaigoServicehiYoku1GatsuMae() {
        return this.getTbl20Igai().getTxt20IgaiKougakuKaigoServicehiYoku1GatsuMae();
    }

    @JsonIgnore
    public TextBoxNum getTxt20IgaiKougakuKaigoServicehiYoku1GatsuGo() {
        return this.getTbl20Igai().getTxt20IgaiKougakuKaigoServicehiYoku1GatsuGo();
    }

    @JsonIgnore
    public TextBoxNum getTxt20IgaiJissaiJikofutangakuYoku1GatsuMae() {
        return this.getTbl20Igai().getTxt20IgaiJissaiJikofutangakuYoku1GatsuMae();
    }

    @JsonIgnore
    public TextBoxNum getTxt20IgaiJissaiJikofutangakuYoku1GatsuGo() {
        return this.getTbl20Igai().getTxt20IgaiJissaiJikofutangakuYoku1GatsuGo();
    }

    @JsonIgnore
    public Label getLbl20IgaiTaishouTsukiYoku7Gatsu() {
        return this.getTbl20Igai().getLbl20IgaiTaishouTsukiYoku7Gatsu();
    }

    @JsonIgnore
    public TextBoxNum getTxt20IgaiJikofutangakuYoku7GatsuMae() {
        return this.getTbl20Igai().getTxt20IgaiJikofutangakuYoku7GatsuMae();
    }

    @JsonIgnore
    public TextBoxNum getTxt20IgaiJikofutangakuYoku7GatsuGo() {
        return this.getTbl20Igai().getTxt20IgaiJikofutangakuYoku7GatsuGo();
    }

    @JsonIgnore
    public TextBoxNum getTxt20Igai70Kara74FutangakuYoku7GatsuMae() {
        return this.getTbl20Igai().getTxt20Igai70Kara74FutangakuYoku7GatsuMae();
    }

    @JsonIgnore
    public TextBoxNum getTxt20Igai70Kara74FutangakuYoku7GatsuGo() {
        return this.getTbl20Igai().getTxt20Igai70Kara74FutangakuYoku7GatsuGo();
    }

    @JsonIgnore
    public TextBoxNum getTxt20IgaiKougakuKaigoServicehiYoku7GatsuMae() {
        return this.getTbl20Igai().getTxt20IgaiKougakuKaigoServicehiYoku7GatsuMae();
    }

    @JsonIgnore
    public TextBoxNum getTxt20IgaiKougakuKaigoServicehiYoku7GatsuGo() {
        return this.getTbl20Igai().getTxt20IgaiKougakuKaigoServicehiYoku7GatsuGo();
    }

    @JsonIgnore
    public TextBoxNum getTxt20IgaiJissaiJikofutangakuYoku7GatsuMae() {
        return this.getTbl20Igai().getTxt20IgaiJissaiJikofutangakuYoku7GatsuMae();
    }

    @JsonIgnore
    public TextBoxNum getTxt20IgaiJissaiJikofutangakuYoku7GatsuGo() {
        return this.getTbl20Igai().getTxt20IgaiJissaiJikofutangakuYoku7GatsuGo();
    }

    @JsonIgnore
    public Label getLbl20IgaiTaishouTsukiGoukei() {
        return this.getTbl20Igai().getLbl20IgaiTaishouTsukiGoukei();
    }

    @JsonIgnore
    public TextBoxNum getTxt20IgaiJikofutangakuGoukeiMae() {
        return this.getTbl20Igai().getTxt20IgaiJikofutangakuGoukeiMae();
    }

    @JsonIgnore
    public TextBoxNum getTxt20IgaiJikofutangakuGoukeiGo() {
        return this.getTbl20Igai().getTxt20IgaiJikofutangakuGoukeiGo();
    }

    @JsonIgnore
    public TextBoxNum getTxt20Igai70Kara74FutangakuGoukeiMae() {
        return this.getTbl20Igai().getTxt20Igai70Kara74FutangakuGoukeiMae();
    }

    @JsonIgnore
    public TextBoxNum getTxt20Igai70Kara74FutangakuGoukeiGo() {
        return this.getTbl20Igai().getTxt20Igai70Kara74FutangakuGoukeiGo();
    }

    @JsonIgnore
    public TextBoxNum getTxt20IgaiKougakuKaigoServicehiGoukeiMae() {
        return this.getTbl20Igai().getTxt20IgaiKougakuKaigoServicehiGoukeiMae();
    }

    @JsonIgnore
    public TextBoxNum getTxt20IgaiKougakuKaigoServicehiGoukeiGo() {
        return this.getTbl20Igai().getTxt20IgaiKougakuKaigoServicehiGoukeiGo();
    }

    @JsonIgnore
    public TextBoxNum getTxt20IgaiJissaiJikofutangakuGoukeiMae() {
        return this.getTbl20Igai().getTxt20IgaiJissaiJikofutangakuGoukeiMae();
    }

    @JsonIgnore
    public TextBoxNum getTxt20IgaiJissaiJikofutangakuGoukeiGo() {
        return this.getTbl20Igai().getTxt20IgaiJissaiJikofutangakuGoukeiGo();
    }

    // </editor-fold>
}
