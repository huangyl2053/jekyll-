package jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD2030001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * TainoKeikokuInitial のクラスファイル 
 * 
 * @author 自動生成
 */
public class TainoKeikokuInitialDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("lblInitial")
    private Label lblInitial;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getlblInitial
     * @return lblInitial
     */
    @JsonProperty("lblInitial")
    public Label getLblInitial() {
        return lblInitial;
    }

    /*
     * setlblInitial
     * @param lblInitial lblInitial
     */
    @JsonProperty("lblInitial")
    public void setLblInitial(Label lblInitial) {
        this.lblInitial = lblInitial;
    }

    // </editor-fold>
}
