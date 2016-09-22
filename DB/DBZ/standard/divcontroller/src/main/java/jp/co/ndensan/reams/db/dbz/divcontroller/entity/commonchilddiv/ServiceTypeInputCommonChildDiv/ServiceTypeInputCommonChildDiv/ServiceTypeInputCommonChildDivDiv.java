package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ServiceTypeInputCommonChildDiv.ServiceTypeInputCommonChildDiv;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.business.core.servicetype.ServiceTypeModel;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.ButtonDialog;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBox;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxCode;
import jp.co.ndensan.reams.uz.uza.util.serialization.DataPassingConverter;

/**
 * ServiceTypeInputCommonChildDiv のクラスファイル
 *
 * @reamsid_L DBA-0070-010 chengsanyuan
 */
public class ServiceTypeInputCommonChildDivDiv extends Panel implements IServiceTypeInputCommonChildDiv {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtServiceType")
    private TextBoxCode txtServiceType;
    @JsonProperty("btnKensaku")
    private ButtonDialog btnKensaku;
    @JsonProperty("txtServiceTypeName")
    private TextBox txtServiceTypeName;
    @JsonProperty("hdnServiceRyakusho")
    private RString hdnServiceRyakusho;
    @JsonProperty("hdnServiceModel")
    private RString hdnServiceModel;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtServiceType
     * @return txtServiceType
     */
    @JsonProperty("txtServiceType")
    public TextBoxCode getTxtServiceType() {
        return txtServiceType;
    }

    /*
     * settxtServiceType
     * @param txtServiceType txtServiceType
     */
    @JsonProperty("txtServiceType")
    public void setTxtServiceType(TextBoxCode txtServiceType) {
        this.txtServiceType = txtServiceType;
    }

    /*
     * getbtnKensaku
     * @return btnKensaku
     */
    @JsonProperty("btnKensaku")
    public ButtonDialog getBtnKensaku() {
        return btnKensaku;
    }

    /*
     * setbtnKensaku
     * @param btnKensaku btnKensaku
     */
    @JsonProperty("btnKensaku")
    public void setBtnKensaku(ButtonDialog btnKensaku) {
        this.btnKensaku = btnKensaku;
    }

    /*
     * gettxtServiceTypeName
     * @return txtServiceTypeName
     */
    @JsonProperty("txtServiceTypeName")
    public TextBox getTxtServiceTypeName() {
        return txtServiceTypeName;
    }

    /*
     * settxtServiceTypeName
     * @param txtServiceTypeName txtServiceTypeName
     */
    @JsonProperty("txtServiceTypeName")
    public void setTxtServiceTypeName(TextBox txtServiceTypeName) {
        this.txtServiceTypeName = txtServiceTypeName;
    }

    /*
     * gethdnServiceRyakusho
     * @return hdnServiceRyakusho
     */
    @JsonProperty("hdnServiceRyakusho")
    public RString getHdnServiceRyakusho() {
        return hdnServiceRyakusho;
    }

    /*
     * sethdnServiceRyakusho
     * @param hdnServiceRyakusho hdnServiceRyakusho
     */
    @JsonProperty("hdnServiceRyakusho")
    public void setHdnServiceRyakusho(RString hdnServiceRyakusho) {
        this.hdnServiceRyakusho = hdnServiceRyakusho;
    }

    /*
     * gethdnServiceModel
     * @return hdnServiceModel
     */
    @JsonProperty("hdnServiceModel")
    public RString getHdnServiceModel() {
        return hdnServiceModel;
    }

    /*
     * sethdnServiceModel
     * @param hdnServiceModel hdnServiceModel
     */
    @JsonProperty("hdnServiceModel")
    public void setHdnServiceModel(RString hdnServiceModel) {
        this.hdnServiceModel = hdnServiceModel;
    }

    // </editor-fold>
    //--------------- この行より下にコードを追加してください -------------------
    @Override
    public void initialize() {
        getHandler().initialize();
    }

    @Override
    public void initialize(RString serviceTypeCode) {
        getHandler().initialize(serviceTypeCode);
    }

    /**
     * 画面を画面初期化します。
     *
     * @param 基準年月 基準年月
     * @param サービス種類リスト サービス種類リスト
     * @param サービス分類リスト サービス分類リスト
     * @param 抽出パターン 抽出パターン
     */
    @Override
    public void initialize(FlexibleYearMonth 基準年月, List<RString> サービス種類リスト, List<RString> サービス分類リスト, RString 抽出パターン) {
        ServiceTypeModel model = new ServiceTypeModel();
        model.set基準年月(基準年月);
        model.setサービス分類リスト(サービス分類リスト);
        model.setサービス種類リスト(サービス種類リスト);
        model.set抽出パターン(抽出パターン);
        this.setHdnServiceModel(DataPassingConverter.serialize(model));
    }

    @Override
    public void clear() {
        getHandler().clear();
    }

    @Override
    public RString getサービス種類コード() {
        return this.getTxtServiceType().getValue();
    }

    @Override
    public RString getサービス種類名称() {
        return this.getTxtServiceTypeName().getValue();
    }

    @Override
    public RString getサービス種類略称() {
        return this.getHdnServiceRyakusho();
    }

    @JsonIgnore
    private ServiceTypeInputCommonChildHandler getHandler() {
        return new ServiceTypeInputCommonChildHandler(this);
    }
}
