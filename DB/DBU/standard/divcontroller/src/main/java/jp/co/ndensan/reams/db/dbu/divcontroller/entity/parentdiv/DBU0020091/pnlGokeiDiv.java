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
 * pnlGokei のクラスファイル 
 * 
 * @author 自動生成
 */
public class pnlGokeiDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-01-15_09-59-03">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("tbp5")
    private tbp5Div tbp5;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettbp5
     * @return tbp5
     */
    @JsonProperty("tbp5")
    public tbp5Div getTbp5() {
        return tbp5;
    }

    /*
     * settbp5
     * @param tbp5 tbp5
     */
    @JsonProperty("tbp5")
    public void setTbp5(tbp5Div tbp5) {
        this.tbp5 = tbp5;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public TextBoxNum getTxtGokeiKensu1() {
        return this.getTbp5().getTxtGokeiKensu1();
    }

    @JsonIgnore
    public TextBoxNum getTxtGokeiKensu2() {
        return this.getTbp5().getTxtGokeiKensu2();
    }

    @JsonIgnore
    public TextBoxNum getTxtGokeiKensu3() {
        return this.getTbp5().getTxtGokeiKensu3();
    }

    @JsonIgnore
    public TextBoxNum getTxtGokeiKyufugaku1() {
        return this.getTbp5().getTxtGokeiKyufugaku1();
    }

    @JsonIgnore
    public TextBoxNum getTxtGokeiKyufugaku2() {
        return this.getTbp5().getTxtGokeiKyufugaku2();
    }

    @JsonIgnore
    public TextBoxNum getTxtGokeiKyufugaku3() {
        return this.getTbp5().getTxtGokeiKyufugaku3();
    }

    // </editor-fold>
}
