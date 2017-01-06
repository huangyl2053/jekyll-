package jp.co.ndensan.reams.db.dbe.divcontroller.entity.commonchilddiv.OnseiFileOperator.OnseiFileOperator;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * OnseiFileDeleted のクラスファイル 
 * 
 * @author 自動生成
 */
public class OnseiFileDeletedDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-10-31_12-59-50">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("icoOnseiFileDeleted")
    private Icon icoOnseiFileDeleted;
    @JsonProperty("lblOnseiFileDeleted")
    private Label lblOnseiFileDeleted;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * geticoOnseiFileDeleted
     * @return icoOnseiFileDeleted
     */
    @JsonProperty("icoOnseiFileDeleted")
    public Icon getIcoOnseiFileDeleted() {
        return icoOnseiFileDeleted;
    }

    /*
     * seticoOnseiFileDeleted
     * @param icoOnseiFileDeleted icoOnseiFileDeleted
     */
    @JsonProperty("icoOnseiFileDeleted")
    public void setIcoOnseiFileDeleted(Icon icoOnseiFileDeleted) {
        this.icoOnseiFileDeleted = icoOnseiFileDeleted;
    }

    /*
     * getlblOnseiFileDeleted
     * @return lblOnseiFileDeleted
     */
    @JsonProperty("lblOnseiFileDeleted")
    public Label getLblOnseiFileDeleted() {
        return lblOnseiFileDeleted;
    }

    /*
     * setlblOnseiFileDeleted
     * @param lblOnseiFileDeleted lblOnseiFileDeleted
     */
    @JsonProperty("lblOnseiFileDeleted")
    public void setLblOnseiFileDeleted(Label lblOnseiFileDeleted) {
        this.lblOnseiFileDeleted = lblOnseiFileDeleted;
    }

    // </editor-fold>
}
