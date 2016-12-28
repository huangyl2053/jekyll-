package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5230001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * TaishoshaNashi のクラスファイル 
 * 
 * @author 自動生成
 */
public class TaishoshaNashiDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-10-31_12-59-50">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("icoTaishoshaNashi")
    private Icon icoTaishoshaNashi;
    @JsonProperty("lblTaishoshaNashi")
    private Label lblTaishoshaNashi;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * geticoTaishoshaNashi
     * @return icoTaishoshaNashi
     */
    @JsonProperty("icoTaishoshaNashi")
    public Icon getIcoTaishoshaNashi() {
        return icoTaishoshaNashi;
    }

    /*
     * seticoTaishoshaNashi
     * @param icoTaishoshaNashi icoTaishoshaNashi
     */
    @JsonProperty("icoTaishoshaNashi")
    public void setIcoTaishoshaNashi(Icon icoTaishoshaNashi) {
        this.icoTaishoshaNashi = icoTaishoshaNashi;
    }

    /*
     * getlblTaishoshaNashi
     * @return lblTaishoshaNashi
     */
    @JsonProperty("lblTaishoshaNashi")
    public Label getLblTaishoshaNashi() {
        return lblTaishoshaNashi;
    }

    /*
     * setlblTaishoshaNashi
     * @param lblTaishoshaNashi lblTaishoshaNashi
     */
    @JsonProperty("lblTaishoshaNashi")
    public void setLblTaishoshaNashi(Label lblTaishoshaNashi) {
        this.lblTaishoshaNashi = lblTaishoshaNashi;
    }

    // </editor-fold>
}
