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
 * pnlSaikeiDaisan のクラスファイル 
 * 
 * @author 自動生成
 */
public class pnlSaikeiDaisanDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-01-15_09-59-03">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("tbp6")
    private tbp6Div tbp6;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettbp6
     * @return tbp6
     */
    @JsonProperty("tbp6")
    public tbp6Div getTbp6() {
        return tbp6;
    }

    /*
     * settbp6
     * @param tbp6 tbp6
     */
    @JsonProperty("tbp6")
    public void setTbp6(tbp6Div tbp6) {
        this.tbp6 = tbp6;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public TextBoxNum getTxtSaikeiRiyoshaDaisanKensu1() {
        return this.getTbp6().getTxtSaikeiRiyoshaDaisanKensu1();
    }

    @JsonIgnore
    public TextBoxNum getTxtSaikeiRiyoshaDaisanKensu2() {
        return this.getTbp6().getTxtSaikeiRiyoshaDaisanKensu2();
    }

    @JsonIgnore
    public TextBoxNum getTxtSaikeiRiyoshaDaisanKensu3() {
        return this.getTbp6().getTxtSaikeiRiyoshaDaisanKensu3();
    }

    @JsonIgnore
    public TextBoxNum getTxtSaikeiRiyoshaDaisanKyufugaku1() {
        return this.getTbp6().getTxtSaikeiRiyoshaDaisanKyufugaku1();
    }

    @JsonIgnore
    public TextBoxNum getTxtSaikeiRiyoshaDaisanKyufugaku2() {
        return this.getTbp6().getTxtSaikeiRiyoshaDaisanKyufugaku2();
    }

    @JsonIgnore
    public TextBoxNum getTxtSaikeiRiyoshaDaisanKyufugaku3() {
        return this.getTbp6().getTxtSaikeiRiyoshaDaisanKyufugaku3();
    }

    // </editor-fold>
}
