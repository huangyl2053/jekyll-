package jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0020091;
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
 * pnlDaisan のクラスファイル 
 * 
 * @author 自動生成
 */
public class pnlDaisanDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-01-15_09-59-03">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("tbp2")
    private tbp2Div tbp2;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettbp2
     * @return tbp2
     */
    @JsonProperty("tbp2")
    public tbp2Div getTbp2() {
        return tbp2;
    }

    /*
     * settbp2
     * @param tbp2 tbp2
     */
    @JsonProperty("tbp2")
    public void setTbp2(tbp2Div tbp2) {
        this.tbp2 = tbp2;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public TextBoxNum getTxtRiyoshaDaisanKensu1() {
        return this.getTbp2().getTxtRiyoshaDaisanKensu1();
    }

    @JsonIgnore
    public TextBoxNum getTxtRiyoshaDaisanKensu2() {
        return this.getTbp2().getTxtRiyoshaDaisanKensu2();
    }

    @JsonIgnore
    public TextBoxNum getTxtRiyoshaDaisanKensu3() {
        return this.getTbp2().getTxtRiyoshaDaisanKensu3();
    }

    @JsonIgnore
    public TextBoxNum getTxtRiyoshaDaisanKyufugaku1() {
        return this.getTbp2().getTxtRiyoshaDaisanKyufugaku1();
    }

    @JsonIgnore
    public TextBoxNum getTxtRiyoshaDaisanKyufugaku2() {
        return this.getTbp2().getTxtRiyoshaDaisanKyufugaku2();
    }

    @JsonIgnore
    public TextBoxNum getTxtRiyoshaDaisanKyufugaku3() {
        return this.getTbp2().getTxtRiyoshaDaisanKyufugaku3();
    }

    // </editor-fold>
}
