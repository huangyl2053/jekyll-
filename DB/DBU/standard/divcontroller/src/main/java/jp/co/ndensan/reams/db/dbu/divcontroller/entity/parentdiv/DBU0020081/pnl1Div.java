package jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0020081;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * pnl1 のクラスファイル 
 * 
 * @author 自動生成
 */
public class pnl1Div extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：バージョン情報無し">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("tabMain")
    private tabMainDiv tabMain;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettabMain
     * @return tabMain
     */
    @JsonProperty("tabMain")
    public tabMainDiv getTabMain() {
        return tabMain;
    }

    /*
     * settabMain
     * @param tabMain tabMain
     */
    @JsonProperty("tabMain")
    public void setTabMain(tabMainDiv tabMain) {
        this.tabMain = tabMain;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public tpl1Div getTpl1() {
        return this.getTabMain().getTpl1();
    }

    @JsonIgnore
    public void  setTpl1(tpl1Div tpl1) {
        this.getTabMain().setTpl1(tpl1);
    }

    @JsonIgnore
    public tbp1Div getTbp1() {
        return this.getTabMain().getTpl1().getTbp1();
    }

    @JsonIgnore
    public void  setTbp1(tbp1Div tbp1) {
        this.getTabMain().getTpl1().setTbp1(tbp1);
    }

    @JsonIgnore
    public tpl2Div getTpl2() {
        return this.getTabMain().getTpl2();
    }

    @JsonIgnore
    public void  setTpl2(tpl2Div tpl2) {
        this.getTabMain().setTpl2(tpl2);
    }

    @JsonIgnore
    public tbp2Div getTbp2() {
        return this.getTabMain().getTpl2().getTbp2();
    }

    @JsonIgnore
    public void  setTbp2(tbp2Div tbp2) {
        this.getTabMain().getTpl2().setTbp2(tbp2);
    }

    // </editor-fold>
}
