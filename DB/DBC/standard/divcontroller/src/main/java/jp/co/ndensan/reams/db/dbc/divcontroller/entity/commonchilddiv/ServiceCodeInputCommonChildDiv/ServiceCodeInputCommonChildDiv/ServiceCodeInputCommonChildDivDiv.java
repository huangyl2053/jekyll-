package jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.ServiceCodeInputCommonChildDiv.ServiceCodeInputCommonChildDiv;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.ButtonDialog;
import jp.co.ndensan.reams.uz.uza.ui.binding.Label;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBox;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxCode;

/**
 * ServiceCodeInputCommonChildDiv のクラスファイル
 *
 * @reamsid_L DBA-0060-010 dongyabin
 * @author 自動生成
 */
public class ServiceCodeInputCommonChildDivDiv extends Panel implements IServiceCodeInputCommonChildDiv {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-01-15_09-59-03">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("lblServiceCode")
    private Label lblServiceCode;
    @JsonProperty("txtServiceCode1")
    private TextBoxCode txtServiceCode1;
    @JsonProperty("txtServiceCode2")
    private TextBoxCode txtServiceCode2;
    @JsonProperty("btnKensaku")
    private ButtonDialog btnKensaku;
    @JsonProperty("txtServiceCodeName")
    private TextBox txtServiceCodeName;
    @JsonProperty("ServiceCodeModel")
    private RString ServiceCodeModel;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getlblServiceCode
     * @return lblServiceCode
     */
    @JsonProperty("lblServiceCode")
    public Label getLblServiceCode() {
        return lblServiceCode;
    }

    /*
     * setlblServiceCode
     * @param lblServiceCode lblServiceCode
     */
    @JsonProperty("lblServiceCode")
    public void setLblServiceCode(Label lblServiceCode) {
        this.lblServiceCode = lblServiceCode;
    }

    /*
     * gettxtServiceCode1
     * @return txtServiceCode1
     */
    @JsonProperty("txtServiceCode1")
    public TextBoxCode getTxtServiceCode1() {
        return txtServiceCode1;
    }

    /*
     * settxtServiceCode1
     * @param txtServiceCode1 txtServiceCode1
     */
    @JsonProperty("txtServiceCode1")
    public void setTxtServiceCode1(TextBoxCode txtServiceCode1) {
        this.txtServiceCode1 = txtServiceCode1;
    }

    /*
     * gettxtServiceCode2
     * @return txtServiceCode2
     */
    @JsonProperty("txtServiceCode2")
    public TextBoxCode getTxtServiceCode2() {
        return txtServiceCode2;
    }

    /*
     * settxtServiceCode2
     * @param txtServiceCode2 txtServiceCode2
     */
    @JsonProperty("txtServiceCode2")
    public void setTxtServiceCode2(TextBoxCode txtServiceCode2) {
        this.txtServiceCode2 = txtServiceCode2;
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
     * gettxtServiceCodeName
     * @return txtServiceCodeName
     */
    @JsonProperty("txtServiceCodeName")
    public TextBox getTxtServiceCodeName() {
        return txtServiceCodeName;
    }

    /*
     * settxtServiceCodeName
     * @param txtServiceCodeName txtServiceCodeName
     */
    @JsonProperty("txtServiceCodeName")
    public void setTxtServiceCodeName(TextBox txtServiceCodeName) {
        this.txtServiceCodeName = txtServiceCodeName;
    }

    /*
     * getServiceCodeModel
     * @return ServiceCodeModel
     */
    @JsonProperty("ServiceCodeModel")
    public RString getServiceCodeModel() {
        return ServiceCodeModel;
    }

    /*
     * setServiceCodeModel
     * @param ServiceCodeModel ServiceCodeModel
     */
    @JsonProperty("ServiceCodeModel")
    public void setServiceCodeModel(RString ServiceCodeModel) {
        this.ServiceCodeModel = ServiceCodeModel;
    }

    // </editor-fold>
    //--------------- この行より下にコードを追加してください -------------------
    /**
     * 画面を画面初期化します。
     */
    @Override
    public void initialize() {
        this.getTxtServiceCodeName().setDisabled(true);
    }

    /**
     * サービスコード1を返します。
     *
     * @return サービスコード1
     */
    @Override
    public RString getサービスコード1() {
        return this.getTxtServiceCode1().getValue();
    }

    /**
     * サービスコード2を返します。
     *
     * @return サービスコード2
     */
    @Override
    public RString getサービスコード2() {
        return this.getTxtServiceCode2().getValue();
    }

    /**
     * サービス名称を返します。
     *
     * @return サービス名称
     */
    @Override
    public RString getサービス名称() {
        return this.getTxtServiceCodeName().getValue();
    }

    /**
     * サービス種類コードを返します。
     *
     * @param サービス種類コード RString
     */
    @Override
    public void setサービス種類コード(RString サービス種類コード) {
        this.getTxtServiceCode1().setValue(サービス種類コード);
    }

    /**
     * サービス項目コードを返します。
     *
     * @param サービス項目コード RString
     */
    @Override
    public void setサービス項目コード(RString サービス項目コード) {
        this.getTxtServiceCode2().setValue(サービス項目コード);
    }

    /**
     * サービス名称を返します。
     *
     * @param サービス名称 RString
     */
    @Override
    public void setサービス名称(RString サービス名称) {
        this.getTxtServiceCodeName().setValue(サービス名称);
    }

    /**
     * サービス名称を返します。
     *
     * @param サービス名称 RString
     */
    @Override
    public void clear() {
        this.getTxtServiceCode1().clearValue();
        this.getTxtServiceCode2().clearValue();
        this.getTxtServiceCodeName().clearValue();
    }

}
