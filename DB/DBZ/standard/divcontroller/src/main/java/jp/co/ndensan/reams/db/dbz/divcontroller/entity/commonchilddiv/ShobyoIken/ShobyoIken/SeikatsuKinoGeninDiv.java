package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ShobyoIken.ShobyoIken;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * SeikatsuKinoGenin のクラスファイル 
 * 
 * @author 自動生成
 */
public class SeikatsuKinoGeninDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：Uz-master-49">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("lblChiryoNaiyo")
    private Label lblChiryoNaiyo;
    @JsonProperty("imgChiryoNaiyo")
    private StaticImage imgChiryoNaiyo;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("lblChiryoNaiyo")
    public Label getLblChiryoNaiyo() {
        return lblChiryoNaiyo;
    }

    @JsonProperty("lblChiryoNaiyo")
    public void setLblChiryoNaiyo(Label lblChiryoNaiyo) {
        this.lblChiryoNaiyo=lblChiryoNaiyo;
    }

    @JsonProperty("imgChiryoNaiyo")
    public StaticImage getImgChiryoNaiyo() {
        return imgChiryoNaiyo;
    }

    @JsonProperty("imgChiryoNaiyo")
    public void setImgChiryoNaiyo(StaticImage imgChiryoNaiyo) {
        this.imgChiryoNaiyo=imgChiryoNaiyo;
    }

    // </editor-fold>
}
