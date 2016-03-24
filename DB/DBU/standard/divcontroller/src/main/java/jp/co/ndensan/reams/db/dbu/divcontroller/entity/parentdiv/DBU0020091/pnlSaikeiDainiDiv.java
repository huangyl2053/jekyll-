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
 * pnlSaikeiDaini のクラスファイル 
 * 
 * @author 自動生成
 */
public class pnlSaikeiDainiDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-01-15_09-59-03">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("tbp7")
    private tbp7Div tbp7;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettbp7
     * @return tbp7
     */
    @JsonProperty("tbp7")
    public tbp7Div getTbp7() {
        return tbp7;
    }

    /*
     * settbp7
     * @param tbp7 tbp7
     */
    @JsonProperty("tbp7")
    public void setTbp7(tbp7Div tbp7) {
        this.tbp7 = tbp7;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public TextBoxNum getTxtSaikeiRiyoshaDainiKensu1() {
        return this.getTbp7().getTxtSaikeiRiyoshaDainiKensu1();
    }

    @JsonIgnore
    public TextBoxNum getTxtSaikeiRiyoshaDainiKensu2() {
        return this.getTbp7().getTxtSaikeiRiyoshaDainiKensu2();
    }

    @JsonIgnore
    public TextBoxNum getTxtSaikeiRiyoshaDainiKensu3() {
        return this.getTbp7().getTxtSaikeiRiyoshaDainiKensu3();
    }

    @JsonIgnore
    public TextBoxNum getTxtSaikeiRiyoshaDainiKyufugaku1() {
        return this.getTbp7().getTxtSaikeiRiyoshaDainiKyufugaku1();
    }

    @JsonIgnore
    public TextBoxNum getTxtSaikeiRiyoshaDainiKyufugaku2() {
        return this.getTbp7().getTxtSaikeiRiyoshaDainiKyufugaku2();
    }

    @JsonIgnore
    public TextBoxNum getTxtSaikeiRiyoshaDainiKyufugaku3() {
        return this.getTbp7().getTxtSaikeiRiyoshaDainiKyufugaku3();
    }

    // </editor-fold>
}
