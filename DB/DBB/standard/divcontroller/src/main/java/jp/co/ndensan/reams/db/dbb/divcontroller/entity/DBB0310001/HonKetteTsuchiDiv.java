package jp.co.ndensan.reams.db.dbb.divcontroller.entity.DBB0310001;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.PanelPublish;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * HonKetteTsuchi のクラスファイル 
 * 
 * @author 自動生成
 */
public class HonKetteTsuchiDiv extends PanelPublish {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtKetteTsuchiHakkoYMD")
    private TextBoxDate txtKetteTsuchiHakkoYMD;
    @JsonProperty("btnKetteiTsuchiYousikiSettei")
    private ButtonDialog btnKetteiTsuchiYousikiSettei;
    @JsonProperty("txtKetteTsuchiBunshoNo")
    private TextBox txtKetteTsuchiBunshoNo;
    @JsonProperty("ShutsuryokuJunHonKetteTsuchi")
    private ChohyoShutsuryokujunDiv ShutsuryokuJunHonKetteTsuchi;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("txtKetteTsuchiHakkoYMD")
    public TextBoxDate getTxtKetteTsuchiHakkoYMD() {
        return txtKetteTsuchiHakkoYMD;
    }

    @JsonProperty("txtKetteTsuchiHakkoYMD")
    public void setTxtKetteTsuchiHakkoYMD(TextBoxDate txtKetteTsuchiHakkoYMD) {
        this.txtKetteTsuchiHakkoYMD=txtKetteTsuchiHakkoYMD;
    }

    @JsonProperty("btnKetteiTsuchiYousikiSettei")
    public ButtonDialog getBtnKetteiTsuchiYousikiSettei() {
        return btnKetteiTsuchiYousikiSettei;
    }

    @JsonProperty("btnKetteiTsuchiYousikiSettei")
    public void setBtnKetteiTsuchiYousikiSettei(ButtonDialog btnKetteiTsuchiYousikiSettei) {
        this.btnKetteiTsuchiYousikiSettei=btnKetteiTsuchiYousikiSettei;
    }

    @JsonProperty("txtKetteTsuchiBunshoNo")
    public TextBox getTxtKetteTsuchiBunshoNo() {
        return txtKetteTsuchiBunshoNo;
    }

    @JsonProperty("txtKetteTsuchiBunshoNo")
    public void setTxtKetteTsuchiBunshoNo(TextBox txtKetteTsuchiBunshoNo) {
        this.txtKetteTsuchiBunshoNo=txtKetteTsuchiBunshoNo;
    }

    @JsonProperty("ShutsuryokuJunHonKetteTsuchi")
    public ChohyoShutsuryokujunDiv getShutsuryokuJunHonKetteTsuchi() {
        return ShutsuryokuJunHonKetteTsuchi;
    }

    @JsonProperty("ShutsuryokuJunHonKetteTsuchi")
    public void setShutsuryokuJunHonKetteTsuchi(ChohyoShutsuryokujunDiv ShutsuryokuJunHonKetteTsuchi) {
        this.ShutsuryokuJunHonKetteTsuchi=ShutsuryokuJunHonKetteTsuchi;
    }

}
