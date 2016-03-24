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
 * pnlU のクラスファイル 
 * 
 * @author 自動生成
 */
public class pnlUDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-01-15_09-59-03">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("tbpU")
    private tbpUDiv tbpU;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettbpU
     * @return tbpU
     */
    @JsonProperty("tbpU")
    public tbpUDiv getTbpU() {
        return tbpU;
    }

    /*
     * settbpU
     * @param tbpU tbpU
     */
    @JsonProperty("tbpU")
    public void setTbpU(tbpUDiv tbpU) {
        this.tbpU = tbpU;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public TextBoxNum getTxtTeishotokushaIIKensu() {
        return this.getTbpU().getTxtTeishotokushaIIKensu();
    }

    @JsonIgnore
    public TextBoxNum getTxtTeishotokushaIIKyufugaku() {
        return this.getTbpU().getTxtTeishotokushaIIKyufugaku();
    }

    // </editor-fold>
}
