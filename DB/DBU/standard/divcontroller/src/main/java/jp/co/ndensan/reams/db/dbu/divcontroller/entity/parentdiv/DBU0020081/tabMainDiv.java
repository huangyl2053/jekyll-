package jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0020081;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.TabContainer;

/**
 * tabMain のクラスファイル 
 * 
 * @author 自動生成
 */
public class tabMainDiv extends TabContainer {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：バージョン情報無し">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("tpl1")
    private tpl1Div tpl1;
    @JsonProperty("tpl2")
    private tpl2Div tpl2;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettpl1
     * @return tpl1
     */
    @JsonProperty("tpl1")
    public tpl1Div getTpl1() {
        return tpl1;
    }

    /*
     * settpl1
     * @param tpl1 tpl1
     */
    @JsonProperty("tpl1")
    public void setTpl1(tpl1Div tpl1) {
        this.tpl1 = tpl1;
    }

    /*
     * gettpl2
     * @return tpl2
     */
    @JsonProperty("tpl2")
    public tpl2Div getTpl2() {
        return tpl2;
    }

    /*
     * settpl2
     * @param tpl2 tpl2
     */
    @JsonProperty("tpl2")
    public void setTpl2(tpl2Div tpl2) {
        this.tpl2 = tpl2;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public tbp1Div getTbp1() {
        return this.getTpl1().getTbp1();
    }

    @JsonIgnore
    public void  setTbp1(tbp1Div tbp1) {
        this.getTpl1().setTbp1(tbp1);
    }

    @JsonIgnore
    public tbp2Div getTbp2() {
        return this.getTpl2().getTbp2();
    }

    @JsonIgnore
    public void  setTbp2(tbp2Div tbp2) {
        this.getTpl2().setTbp2(tbp2);
    }

    // </editor-fold>
}
