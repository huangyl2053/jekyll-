package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0440011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.KogakuServicehiDetail.IKogakuServicehiDetailDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.KogakuServicehiDetail.KogakuServicehiDetailDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.ui.binding.HorizontalLine;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * ShinseiTorokuPanel のクラスファイル
 *
 * @reamsid_L DBC-2020-040 quxiaodong
 */
public class ShinseiTorokuPanelDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("btnSetaiJohoHyoji")
    private Button btnSetaiJohoHyoji;
    @JsonProperty("lin2")
    private HorizontalLine lin2;
    @JsonProperty("ccdKogakuServicehiDetail")
    private KogakuServicehiDetailDiv ccdKogakuServicehiDetail;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getbtnSetaiJohoHyoji
     * @return btnSetaiJohoHyoji
     */
    @JsonProperty("btnSetaiJohoHyoji")
    public Button getBtnSetaiJohoHyoji() {
        return btnSetaiJohoHyoji;
    }

    /*
     * setbtnSetaiJohoHyoji
     * @param btnSetaiJohoHyoji btnSetaiJohoHyoji
     */
    @JsonProperty("btnSetaiJohoHyoji")
    public void setBtnSetaiJohoHyoji(Button btnSetaiJohoHyoji) {
        this.btnSetaiJohoHyoji = btnSetaiJohoHyoji;
    }

    /*
     * getlin2
     * @return lin2
     */
    @JsonProperty("lin2")
    public HorizontalLine getLin2() {
        return lin2;
    }

    /*
     * setlin2
     * @param lin2 lin2
     */
    @JsonProperty("lin2")
    public void setLin2(HorizontalLine lin2) {
        this.lin2 = lin2;
    }

    /*
     * getccdKogakuServicehiDetail
     * @return ccdKogakuServicehiDetail
     */
    @JsonProperty("ccdKogakuServicehiDetail")
    public IKogakuServicehiDetailDiv getCcdKogakuServicehiDetail() {
        return ccdKogakuServicehiDetail;
    }

    // </editor-fold>
}
