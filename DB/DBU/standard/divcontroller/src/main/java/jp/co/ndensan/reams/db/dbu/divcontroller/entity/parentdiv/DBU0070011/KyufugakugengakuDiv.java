package jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0070011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * Kyufugakugengaku のクラスファイル 
 * 
 * @author 自動生成
 */
public class KyufugakugengakuDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("radKyuhugakuGengakuUmu")
    private RadioButton radKyuhugakuGengakuUmu;
    @JsonProperty("txtKyufugakuGengaku")
    private TextBox txtKyufugakuGengaku;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getradKyuhugakuGengakuUmu
     * @return radKyuhugakuGengakuUmu
     */
    @JsonProperty("radKyuhugakuGengakuUmu")
    public RadioButton getRadKyuhugakuGengakuUmu() {
        return radKyuhugakuGengakuUmu;
    }

    /*
     * setradKyuhugakuGengakuUmu
     * @param radKyuhugakuGengakuUmu radKyuhugakuGengakuUmu
     */
    @JsonProperty("radKyuhugakuGengakuUmu")
    public void setRadKyuhugakuGengakuUmu(RadioButton radKyuhugakuGengakuUmu) {
        this.radKyuhugakuGengakuUmu = radKyuhugakuGengakuUmu;
    }

    /*
     * gettxtKyufugakuGengaku
     * @return txtKyufugakuGengaku
     */
    @JsonProperty("txtKyufugakuGengaku")
    public TextBox getTxtKyufugakuGengaku() {
        return txtKyufugakuGengaku;
    }

    /*
     * settxtKyufugakuGengaku
     * @param txtKyufugakuGengaku txtKyufugakuGengaku
     */
    @JsonProperty("txtKyufugakuGengaku")
    public void setTxtKyufugakuGengaku(TextBox txtKyufugakuGengaku) {
        this.txtKyufugakuGengaku = txtKyufugakuGengaku;
    }

    // </editor-fold>
}
