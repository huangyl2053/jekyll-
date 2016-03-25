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
 * pnlDaiyon のクラスファイル 
 * 
 * @author 自動生成
 */
public class pnlDaiyonDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-01-15_09-59-03">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("tbp1")
    private tbp1Div tbp1;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettbp1
     * @return tbp1
     */
    @JsonProperty("tbp1")
    public tbp1Div getTbp1() {
        return tbp1;
    }

    /*
     * settbp1
     * @param tbp1 tbp1
     */
    @JsonProperty("tbp1")
    public void setTbp1(tbp1Div tbp1) {
        this.tbp1 = tbp1;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public TextBoxNum getTxtRiyoshaDaiyonKensu1() {
        return this.getTbp1().getTxtRiyoshaDaiyonKensu1();
    }

    @JsonIgnore
    public TextBoxNum getTxtRiyoshaDaiyonKensu2() {
        return this.getTbp1().getTxtRiyoshaDaiyonKensu2();
    }

    @JsonIgnore
    public TextBoxNum getTxtRiyoshaDaiyonKensu3() {
        return this.getTbp1().getTxtRiyoshaDaiyonKensu3();
    }

    @JsonIgnore
    public TextBoxNum getTxtRiyoshaDaiyonKyufugaku1() {
        return this.getTbp1().getTxtRiyoshaDaiyonKyufugaku1();
    }

    @JsonIgnore
    public TextBoxNum getTxtRiyoshaDaiyonKyufugaku2() {
        return this.getTbp1().getTxtRiyoshaDaiyonKyufugaku2();
    }

    @JsonIgnore
    public TextBoxNum getTxtRiyoshaDaiyonKyufugaku3() {
        return this.getTbp1().getTxtRiyoshaDaiyonKyufugaku3();
    }

    // </editor-fold>
}
