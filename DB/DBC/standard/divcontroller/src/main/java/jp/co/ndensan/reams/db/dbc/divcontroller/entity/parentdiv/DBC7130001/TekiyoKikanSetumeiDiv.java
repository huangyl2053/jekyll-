package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC7130001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * TekiyoKikanSetumei のクラスファイル 
 * 
 * @author 自動生成
 */
public class TekiyoKikanSetumeiDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("Yohaku")
    private Space Yohaku;
    @JsonProperty("ｌｂｌTekiyoKikanSetumei")
    private Label ｌｂｌTekiyoKikanSetumei;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getYohaku
     * @return Yohaku
     */
    @JsonProperty("Yohaku")
    public Space getYohaku() {
        return Yohaku;
    }

    /*
     * setYohaku
     * @param Yohaku Yohaku
     */
    @JsonProperty("Yohaku")
    public void setYohaku(Space Yohaku) {
        this.Yohaku = Yohaku;
    }

    /*
     * getｌｂｌTekiyoKikanSetumei
     * @return ｌｂｌTekiyoKikanSetumei
     */
    @JsonProperty("ｌｂｌTekiyoKikanSetumei")
    public Label getＬｂｌTekiyoKikanSetumei() {
        return ｌｂｌTekiyoKikanSetumei;
    }

    /*
     * setｌｂｌTekiyoKikanSetumei
     * @param ｌｂｌTekiyoKikanSetumei ｌｂｌTekiyoKikanSetumei
     */
    @JsonProperty("ｌｂｌTekiyoKikanSetumei")
    public void setＬｂｌTekiyoKikanSetumei(Label ｌｂｌTekiyoKikanSetumei) {
        this.ｌｂｌTekiyoKikanSetumei = ｌｂｌTekiyoKikanSetumei;
    }

    // </editor-fold>
}
