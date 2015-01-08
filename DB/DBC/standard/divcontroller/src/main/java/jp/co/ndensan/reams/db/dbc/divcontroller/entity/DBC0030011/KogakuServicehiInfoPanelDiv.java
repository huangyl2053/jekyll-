package jp.co.ndensan.reams.db.dbc.divcontroller.entity.DBC0030011;

/**
 * このコードはツールによって生成されました。 このファイルへの変更は、再生成時には損失するため 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.kaigoatenainfo.KaigoAtenaInfoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.kaigoshikakukihon.KaigoShikakuKihonDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.KogakuServicehiDetail.KogakuServicehiDetailDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * KogakuServicehiInfoPanel のクラスファイル
 *
 * @author 自動生成
 */
public class KogakuServicehiInfoPanelDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */

    @JsonProperty("CommonKogakuNushiJuminJohoChildDiv1")
    private KaigoAtenaInfoDiv CommonKogakuNushiJuminJohoChildDiv1;
    @JsonProperty("CommonKogakuKaigoJuminJohoChildDiv2")
    private KaigoShikakuKihonDiv CommonKogakuKaigoJuminJohoChildDiv2;
    @JsonProperty("HorizontalJuminLine1")
    private HorizontalLine HorizontalJuminLine1;
    @JsonProperty("btnShowSeteiJoho")
    private Button btnShowSeteiJoho;
    @JsonProperty("KogakuServiceDetail")
    private KogakuServicehiDetailDiv KogakuServiceDetail;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("CommonKogakuNushiJuminJohoChildDiv1")
    public KaigoAtenaInfoDiv getCommonKogakuNushiJuminJohoChildDiv1() {
        return CommonKogakuNushiJuminJohoChildDiv1;
    }

    @JsonProperty("CommonKogakuNushiJuminJohoChildDiv1")
    public void setCommonKogakuNushiJuminJohoChildDiv1(KaigoAtenaInfoDiv CommonKogakuNushiJuminJohoChildDiv1) {
        this.CommonKogakuNushiJuminJohoChildDiv1 = CommonKogakuNushiJuminJohoChildDiv1;
    }

    @JsonProperty("CommonKogakuKaigoJuminJohoChildDiv2")
    public KaigoShikakuKihonDiv getCommonKogakuKaigoJuminJohoChildDiv2() {
        return CommonKogakuKaigoJuminJohoChildDiv2;
    }

    @JsonProperty("CommonKogakuKaigoJuminJohoChildDiv2")
    public void setCommonKogakuKaigoJuminJohoChildDiv2(KaigoShikakuKihonDiv CommonKogakuKaigoJuminJohoChildDiv2) {
        this.CommonKogakuKaigoJuminJohoChildDiv2 = CommonKogakuKaigoJuminJohoChildDiv2;
    }

    @JsonProperty("HorizontalJuminLine1")
    public HorizontalLine getHorizontalJuminLine1() {
        return HorizontalJuminLine1;
    }

    @JsonProperty("HorizontalJuminLine1")
    public void setHorizontalJuminLine1(HorizontalLine HorizontalJuminLine1) {
        this.HorizontalJuminLine1 = HorizontalJuminLine1;
    }

    @JsonProperty("btnShowSeteiJoho")
    public Button getBtnShowSeteiJoho() {
        return btnShowSeteiJoho;
    }

    @JsonProperty("btnShowSeteiJoho")
    public void setBtnShowSeteiJoho(Button btnShowSeteiJoho) {
        this.btnShowSeteiJoho = btnShowSeteiJoho;
    }

    @JsonProperty("KogakuServiceDetail")
    public KogakuServicehiDetailDiv getKogakuServiceDetail() {
        return KogakuServiceDetail;
    }

    @JsonProperty("KogakuServiceDetail")
    public void setKogakuServiceDetail(KogakuServicehiDetailDiv KogakuServiceDetail) {
        this.KogakuServiceDetail = KogakuServiceDetail;
    }

}
