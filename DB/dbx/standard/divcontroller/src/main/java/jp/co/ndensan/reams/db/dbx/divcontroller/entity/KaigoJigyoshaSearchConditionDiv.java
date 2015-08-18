package jp.co.ndensan.reams.db.dbx.divcontroller.entity;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import jp.co.ndensan.reams.db.dbx.divcontroller.entity.IKaigoJigyoshaSearchConditionDiv;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbx.divcontroller.entity.IJigyoshaSearchConditionCommonDiv;
import jp.co.ndensan.reams.db.dbx.divcontroller.entity.IJigyoshaSearchConditionOptionDiv;
import jp.co.ndensan.reams.db.dbx.divcontroller.entity.JigyoshaSearchConditionCommonDiv;
import jp.co.ndensan.reams.db.dbx.divcontroller.entity.JigyoshaSearchConditionOptionDiv;
import jp.co.ndensan.reams.db.dbx.divcontroller.entity.ServiceJigyoshaSearchConditionDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * KaigoJigyoshaSearchCondition のクラスファイル 
 * 
 * @author 自動生成
 * @jpName
 * @bizDomain 介護
 * @category DAメニュー
 * @subCategory 介護事業者登録
 * @mainClass
 * @reference
 */
public class KaigoJigyoshaSearchConditionDiv extends Panel implements IKaigoJigyoshaSearchConditionDiv {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ccdJigyoshaSearchConditionCommon")
    private JigyoshaSearchConditionCommonDiv ccdJigyoshaSearchConditionCommon;
    @JsonProperty("ServiceJigyoshaSearchCondition")
    private ServiceJigyoshaSearchConditionDiv ServiceJigyoshaSearchCondition;
    @JsonProperty("ccdJigyoshaSearchConditionOption")
    private JigyoshaSearchConditionOptionDiv ccdJigyoshaSearchConditionOption;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("ccdJigyoshaSearchConditionCommon")
    public IJigyoshaSearchConditionCommonDiv getCcdJigyoshaSearchConditionCommon() {
        return ccdJigyoshaSearchConditionCommon;
    }

    @JsonProperty("ServiceJigyoshaSearchCondition")
    public ServiceJigyoshaSearchConditionDiv getServiceJigyoshaSearchCondition() {
        return ServiceJigyoshaSearchCondition;
    }

    @JsonProperty("ServiceJigyoshaSearchCondition")
    public void setServiceJigyoshaSearchCondition(ServiceJigyoshaSearchConditionDiv ServiceJigyoshaSearchCondition) {
        this.ServiceJigyoshaSearchCondition=ServiceJigyoshaSearchCondition;
    }

    @JsonProperty("ccdJigyoshaSearchConditionOption")
    public IJigyoshaSearchConditionOptionDiv getCcdJigyoshaSearchConditionOption() {
        return ccdJigyoshaSearchConditionOption;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public DropDownList getDdlSearchPrefecturesCode() {
        return this.getServiceJigyoshaSearchCondition().getDdlSearchPrefecturesCode();
    }

    @JsonIgnore
    public void  setDdlSearchPrefecturesCode(DropDownList ddlSearchPrefecturesCode) {
        this.getServiceJigyoshaSearchCondition().setDdlSearchPrefecturesCode(ddlSearchPrefecturesCode);
    }

    @JsonIgnore
    public DropDownList getDdlSearchJigyoshaKubun() {
        return this.getServiceJigyoshaSearchCondition().getDdlSearchJigyoshaKubun();
    }

    @JsonIgnore
    public void  setDdlSearchJigyoshaKubun(DropDownList ddlSearchJigyoshaKubun) {
        this.getServiceJigyoshaSearchCondition().setDdlSearchJigyoshaKubun(ddlSearchJigyoshaKubun);
    }

    @JsonIgnore
    public DropDownList getDdlSearchToshiCode() {
        return this.getServiceJigyoshaSearchCondition().getDdlSearchToshiCode();
    }

    @JsonIgnore
    public void  setDdlSearchToshiCode(DropDownList ddlSearchToshiCode) {
        this.getServiceJigyoshaSearchCondition().setDdlSearchToshiCode(ddlSearchToshiCode);
    }

    @JsonIgnore
    public DropDownList getDdlSearchServiceType() {
        return this.getServiceJigyoshaSearchCondition().getDdlSearchServiceType();
    }

    @JsonIgnore
    public void  setDdlSearchServiceType(DropDownList ddlSearchServiceType) {
        this.getServiceJigyoshaSearchCondition().setDdlSearchServiceType(ddlSearchServiceType);
    }

    //--------------- この行より下にコードを追加してください -------------------

}
