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
 * pnlDaiitu のクラスファイル 
 * 
 * @author 自動生成
 */
public class pnlDaiituDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-01-15_09-59-03">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("tbp4")
    private tbp4Div tbp4;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettbp4
     * @return tbp4
     */
    @JsonProperty("tbp4")
    public tbp4Div getTbp4() {
        return tbp4;
    }

    /*
     * settbp4
     * @param tbp4 tbp4
     */
    @JsonProperty("tbp4")
    public void setTbp4(tbp4Div tbp4) {
        this.tbp4 = tbp4;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public TextBoxNum getTxtRiyoshaDaiichiKensu1() {
        return this.getTbp4().getTxtRiyoshaDaiichiKensu1();
    }

    @JsonIgnore
    public TextBoxNum getTxtRiyoshaDaiichiKensu2() {
        return this.getTbp4().getTxtRiyoshaDaiichiKensu2();
    }

    @JsonIgnore
    public TextBoxNum getTxtRiyoshaDaiichiKensu3() {
        return this.getTbp4().getTxtRiyoshaDaiichiKensu3();
    }

    @JsonIgnore
    public TextBoxNum getTxtRiyoshaDaiichiKyufugaku1() {
        return this.getTbp4().getTxtRiyoshaDaiichiKyufugaku1();
    }

    @JsonIgnore
    public TextBoxNum getTxtRiyoshaDaiichiKyufugaku2() {
        return this.getTbp4().getTxtRiyoshaDaiichiKyufugaku2();
    }

    @JsonIgnore
    public TextBoxNum getTxtRiyoshaDaiichiKyufugaku3() {
        return this.getTbp4().getTxtRiyoshaDaiichiKyufugaku3();
    }

    // </editor-fold>
}
