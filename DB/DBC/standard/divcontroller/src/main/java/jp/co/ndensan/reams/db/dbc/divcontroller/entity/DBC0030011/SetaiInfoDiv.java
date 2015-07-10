package jp.co.ndensan.reams.db.dbc.divcontroller.entity.DBC0030011;

/**
 * このコードはツールによって生成されました。 このファイルへの変更は、再生成時には損失するため 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.kaigoatenainfo.KaigoAtenaInfoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.kaigoshikakukihon.KaigoShikakuKihonDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.SetaiShotokuIchiran.SetaiShotokuIchiranDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * SetaiInfo のクラスファイル
 *
 * @author 自動生成
 */
public class SetaiInfoDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */

    @JsonProperty("CommonKaigAtenChildDiv1")
    private KaigoAtenaInfoDiv CommonKaigAtenChildDiv1;
    @JsonProperty("CommonKaigoShiChildDiv2")
    private KaigoShikakuKihonDiv CommonKaigoShiChildDiv2;
    @JsonProperty("KagiKHonHorizontalLine1")
    private HorizontalLine KagiKHonHorizontalLine1;
    @JsonProperty("SetaiinShotoku")
    private SetaiShotokuIchiranDiv SetaiinShotoku;
    @JsonProperty("txtBtn")
    private Button txtBtn;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("CommonKaigAtenChildDiv1")
    public KaigoAtenaInfoDiv getCommonKaigAtenChildDiv1() {
        return CommonKaigAtenChildDiv1;
    }

    @JsonProperty("CommonKaigAtenChildDiv1")
    public void setCommonKaigAtenChildDiv1(KaigoAtenaInfoDiv CommonKaigAtenChildDiv1) {
        this.CommonKaigAtenChildDiv1 = CommonKaigAtenChildDiv1;
    }

    @JsonProperty("CommonKaigoShiChildDiv2")
    public KaigoShikakuKihonDiv getCommonKaigoShiChildDiv2() {
        return CommonKaigoShiChildDiv2;
    }

    @JsonProperty("CommonKaigoShiChildDiv2")
    public void setCommonKaigoShiChildDiv2(KaigoShikakuKihonDiv CommonKaigoShiChildDiv2) {
        this.CommonKaigoShiChildDiv2 = CommonKaigoShiChildDiv2;
    }

    @JsonProperty("KagiKHonHorizontalLine1")
    public HorizontalLine getKagiKHonHorizontalLine1() {
        return KagiKHonHorizontalLine1;
    }

    @JsonProperty("KagiKHonHorizontalLine1")
    public void setKagiKHonHorizontalLine1(HorizontalLine KagiKHonHorizontalLine1) {
        this.KagiKHonHorizontalLine1 = KagiKHonHorizontalLine1;
    }

    @JsonProperty("SetaiinShotoku")
    public SetaiShotokuIchiranDiv getSetaiinShotoku() {
        return SetaiinShotoku;
    }

    @JsonProperty("SetaiinShotoku")
    public void setSetaiinShotoku(SetaiShotokuIchiranDiv SetaiinShotoku) {
        this.SetaiinShotoku = SetaiinShotoku;
    }

    @JsonProperty("txtBtn")
    public Button getTxtBtn() {
        return txtBtn;
    }

    @JsonProperty("txtBtn")
    public void setTxtBtn(Button txtBtn) {
        this.txtBtn = txtBtn;
    }

}
