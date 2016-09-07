package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0030012;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.KogakuServicehiDetail.IKogakuServicehiDetailDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.KogakuServicehiDetail.KogakuServicehiDetailDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.kaigoatenainfo.KaigoAtenaInfo.IKaigoAtenaInfoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.kaigoatenainfo.KaigoAtenaInfo.KaigoAtenaInfoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.kaigoshikakukihon.KaigoShikakuKihon.IKaigoShikakuKihonDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.kaigoshikakukihon.KaigoShikakuKihon.KaigoShikakuKihonDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.ui.binding.HorizontalLine;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.Space;

/**
 * KogakuServicehiInfoPanel のクラスファイル
 *
 * @reamsid_L DBC-3000-030 gongliang
 */
public class KogakuServicehiInfoPanelDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("lin1")
    private HorizontalLine lin1;
    @JsonProperty("btnShowSeteiJoho")
    private Button btnShowSeteiJoho;
    @JsonProperty("spc01")
    private Space spc01;
    @JsonProperty("ccdKaigoAtenaInfo")
    private KaigoAtenaInfoDiv ccdKaigoAtenaInfo;
    @JsonProperty("ccdKaigoShikakuKihon")
    private KaigoShikakuKihonDiv ccdKaigoShikakuKihon;
    @JsonProperty("ccdKogakuServiceDetail")
    private KogakuServicehiDetailDiv ccdKogakuServiceDetail;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getlin1
     * @return lin1
     */
    @JsonProperty("lin1")
    public HorizontalLine getLin1() {
        return lin1;
    }

    /*
     * setlin1
     * @param lin1 lin1
     */
    @JsonProperty("lin1")
    public void setLin1(HorizontalLine lin1) {
        this.lin1 = lin1;
    }

    /*
     * getbtnShowSeteiJoho
     * @return btnShowSeteiJoho
     */
    @JsonProperty("btnShowSeteiJoho")
    public Button getBtnShowSeteiJoho() {
        return btnShowSeteiJoho;
    }

    /*
     * setbtnShowSeteiJoho
     * @param btnShowSeteiJoho btnShowSeteiJoho
     */
    @JsonProperty("btnShowSeteiJoho")
    public void setBtnShowSeteiJoho(Button btnShowSeteiJoho) {
        this.btnShowSeteiJoho = btnShowSeteiJoho;
    }

    /*
     * getspc01
     * @return spc01
     */
    @JsonProperty("spc01")
    public Space getSpc01() {
        return spc01;
    }

    /*
     * setspc01
     * @param spc01 spc01
     */
    @JsonProperty("spc01")
    public void setSpc01(Space spc01) {
        this.spc01 = spc01;
    }

    /*
     * getccdKaigoAtenaInfo
     * @return ccdKaigoAtenaInfo
     */
    @JsonProperty("ccdKaigoAtenaInfo")
    public IKaigoAtenaInfoDiv getCcdKaigoAtenaInfo() {
        return ccdKaigoAtenaInfo;
    }

    /*
     * getccdKaigoShikakuKihon
     * @return ccdKaigoShikakuKihon
     */
    @JsonProperty("ccdKaigoShikakuKihon")
    public IKaigoShikakuKihonDiv getCcdKaigoShikakuKihon() {
        return ccdKaigoShikakuKihon;
    }

    /*
     * getccdKogakuServiceDetail
     * @return ccdKogakuServiceDetail
     */
    @JsonProperty("ccdKogakuServiceDetail")
    public IKogakuServicehiDetailDiv getCcdKogakuServiceDetail() {
        return ccdKogakuServiceDetail;
    }

    // </editor-fold>
}
