package jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0020061;
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
 * YoshikiIchiBesshiIchi のクラスファイル 
 * 
 * @author 自動生成
 */
public class YoshikiIchiBesshiIchiDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-01-15_09-59-03">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("tblYoshikiIchiBesshiIchi")
    private tblYoshikiIchiBesshiIchiDiv tblYoshikiIchiBesshiIchi;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettblYoshikiIchiBesshiIchi
     * @return tblYoshikiIchiBesshiIchi
     */
    @JsonProperty("tblYoshikiIchiBesshiIchi")
    public tblYoshikiIchiBesshiIchiDiv getTblYoshikiIchiBesshiIchi() {
        return tblYoshikiIchiBesshiIchi;
    }

    /*
     * settblYoshikiIchiBesshiIchi
     * @param tblYoshikiIchiBesshiIchi tblYoshikiIchiBesshiIchi
     */
    @JsonProperty("tblYoshikiIchiBesshiIchi")
    public void setTblYoshikiIchiBesshiIchi(tblYoshikiIchiBesshiIchiDiv tblYoshikiIchiBesshiIchi) {
        this.tblYoshikiIchiBesshiIchi = tblYoshikiIchiBesshiIchi;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public Label getLblZengetsumatsugenzai() {
        return this.getTblYoshikiIchiBesshiIchi().getLblZengetsumatsugenzai();
    }

    @JsonIgnore
    public Label getLblTogetsuChuzo() {
        return this.getTblYoshikiIchiBesshiIchi().getLblTogetsuChuzo();
    }

    @JsonIgnore
    public Label getLblTogetsuChugen() {
        return this.getTblYoshikiIchiBesshiIchi().getLblTogetsuChugen();
    }

    @JsonIgnore
    public Label getLblTogetsumatsugenzai() {
        return this.getTblYoshikiIchiBesshiIchi().getLblTogetsumatsugenzai();
    }

    @JsonIgnore
    public Label getLblkei() {
        return this.getTblYoshikiIchiBesshiIchi().getLblkei();
    }

    @JsonIgnore
    public TextBoxNum getTxtZengetsumatsugenzai() {
        return this.getTblYoshikiIchiBesshiIchi().getTxtZengetsumatsugenzai();
    }

    @JsonIgnore
    public TextBoxNum getTxtTogetsuChuzo() {
        return this.getTblYoshikiIchiBesshiIchi().getTxtTogetsuChuzo();
    }

    @JsonIgnore
    public TextBoxNum getTxtTogetsuChugen() {
        return this.getTblYoshikiIchiBesshiIchi().getTxtTogetsuChugen();
    }

    @JsonIgnore
    public TextBoxNum getTxtTogetsumatsugenzai() {
        return this.getTblYoshikiIchiBesshiIchi().getTxtTogetsumatsugenzai();
    }

    // </editor-fold>
}
