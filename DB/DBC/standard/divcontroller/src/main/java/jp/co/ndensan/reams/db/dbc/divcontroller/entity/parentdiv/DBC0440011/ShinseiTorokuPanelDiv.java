package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0440011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.KogakuServicehiDetail.IKogakuServicehiDetailDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.KogakuServicehiDetail.KogakuServicehiDetailDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.SetaiShotokuIchiran.SetaiShotokuIchiran.ISetaiShotokuIchiranDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.ui.binding.HorizontalLine;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * ShinseiTorokuPanel のクラスファイル
 *
 * @reamsid_L DBC-2020-040 quxiaodong
 */
public class ShinseiTorokuPanelDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-10-07_19-12-57">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("btnSetaiJohoHyoji")
    private Button btnSetaiJohoHyoji;
    @JsonProperty("btnKogakuMeisaiHyoji")
    private Button btnKogakuMeisaiHyoji;
    @JsonProperty("lin2")
    private HorizontalLine lin2;
    @JsonProperty("SetaiJoho")
    private SetaiJohoDiv SetaiJoho;
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
     * getbtnKogakuMeisaiHyoji
     * @return btnKogakuMeisaiHyoji
     */
    @JsonProperty("btnKogakuMeisaiHyoji")
    public Button getBtnKogakuMeisaiHyoji() {
        return btnKogakuMeisaiHyoji;
    }

    /*
     * setbtnKogakuMeisaiHyoji
     * @param btnKogakuMeisaiHyoji btnKogakuMeisaiHyoji
     */
    @JsonProperty("btnKogakuMeisaiHyoji")
    public void setBtnKogakuMeisaiHyoji(Button btnKogakuMeisaiHyoji) {
        this.btnKogakuMeisaiHyoji = btnKogakuMeisaiHyoji;
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
     * getSetaiJoho
     * @return SetaiJoho
     */
    @JsonProperty("SetaiJoho")
    public SetaiJohoDiv getSetaiJoho() {
        return SetaiJoho;
    }

    /*
     * setSetaiJoho
     * @param SetaiJoho SetaiJoho
     */
    @JsonProperty("SetaiJoho")
    public void setSetaiJoho(SetaiJohoDiv SetaiJoho) {
        this.SetaiJoho = SetaiJoho;
    }

    /*
     * getccdKogakuServicehiDetail
     * @return ccdKogakuServicehiDetail
     */
    @JsonProperty("ccdKogakuServicehiDetail")
    public IKogakuServicehiDetailDiv getCcdKogakuServicehiDetail() {
        return ccdKogakuServicehiDetail;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public ISetaiShotokuIchiranDiv getCcdSetaiShotokuIchiran() {
        return this.getSetaiJoho().getCcdSetaiShotokuIchiran();
    }

    // </editor-fold>
}
