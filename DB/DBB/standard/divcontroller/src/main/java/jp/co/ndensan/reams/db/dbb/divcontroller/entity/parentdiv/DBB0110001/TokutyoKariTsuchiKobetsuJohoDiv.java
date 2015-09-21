package jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB0110001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * TokutyoKariTsuchiKobetsuJoho のクラスファイル 
 * 
 * @author 自動生成
 */
public class TokutyoKariTsuchiKobetsuJohoDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：Uz-master-49">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("lblTokuKaishiTsuchi")
    private Label lblTokuKaishiTsuchi;
    @JsonProperty("radTokuKaishiTsuchiTaisho2")
    private RadioButton radTokuKaishiTsuchiTaisho2;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("lblTokuKaishiTsuchi")
    public Label getLblTokuKaishiTsuchi() {
        return lblTokuKaishiTsuchi;
    }

    @JsonProperty("lblTokuKaishiTsuchi")
    public void setLblTokuKaishiTsuchi(Label lblTokuKaishiTsuchi) {
        this.lblTokuKaishiTsuchi=lblTokuKaishiTsuchi;
    }

    @JsonProperty("radTokuKaishiTsuchiTaisho2")
    public RadioButton getRadTokuKaishiTsuchiTaisho2() {
        return radTokuKaishiTsuchiTaisho2;
    }

    @JsonProperty("radTokuKaishiTsuchiTaisho2")
    public void setRadTokuKaishiTsuchiTaisho2(RadioButton radTokuKaishiTsuchiTaisho2) {
        this.radTokuKaishiTsuchiTaisho2=radTokuKaishiTsuchiTaisho2;
    }

    // </editor-fold>
}
