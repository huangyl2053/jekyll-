package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.JigyoshaNyuryokuGudieCommonChildDiv;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * ServiceJigyosha のクラスファイル 
 * 
 * @reamsid_L DBA-0140-010 houtianpeng
 */
public class ServiceJigyoshaDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-07-28_11-34-20">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ddlKennCode")
    private DropDownList ddlKennCode;
    @JsonProperty("ddlJigyoshaKubun")
    private DropDownList ddlJigyoshaKubun;
    @JsonProperty("ddlGunshiCode")
    private DropDownList ddlGunshiCode;
    @JsonProperty("ddlServiceShurui")
    private DropDownList ddlServiceShurui;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getddlKennCode
     * @return ddlKennCode
     */
    @JsonProperty("ddlKennCode")
    public DropDownList getDdlKennCode() {
        return ddlKennCode;
    }

    /*
     * setddlKennCode
     * @param ddlKennCode ddlKennCode
     */
    @JsonProperty("ddlKennCode")
    public void setDdlKennCode(DropDownList ddlKennCode) {
        this.ddlKennCode = ddlKennCode;
    }

    /*
     * getddlJigyoshaKubun
     * @return ddlJigyoshaKubun
     */
    @JsonProperty("ddlJigyoshaKubun")
    public DropDownList getDdlJigyoshaKubun() {
        return ddlJigyoshaKubun;
    }

    /*
     * setddlJigyoshaKubun
     * @param ddlJigyoshaKubun ddlJigyoshaKubun
     */
    @JsonProperty("ddlJigyoshaKubun")
    public void setDdlJigyoshaKubun(DropDownList ddlJigyoshaKubun) {
        this.ddlJigyoshaKubun = ddlJigyoshaKubun;
    }

    /*
     * getddlGunshiCode
     * @return ddlGunshiCode
     */
    @JsonProperty("ddlGunshiCode")
    public DropDownList getDdlGunshiCode() {
        return ddlGunshiCode;
    }

    /*
     * setddlGunshiCode
     * @param ddlGunshiCode ddlGunshiCode
     */
    @JsonProperty("ddlGunshiCode")
    public void setDdlGunshiCode(DropDownList ddlGunshiCode) {
        this.ddlGunshiCode = ddlGunshiCode;
    }

    /*
     * getddlServiceShurui
     * @return ddlServiceShurui
     */
    @JsonProperty("ddlServiceShurui")
    public DropDownList getDdlServiceShurui() {
        return ddlServiceShurui;
    }

    /*
     * setddlServiceShurui
     * @param ddlServiceShurui ddlServiceShurui
     */
    @JsonProperty("ddlServiceShurui")
    public void setDdlServiceShurui(DropDownList ddlServiceShurui) {
        this.ddlServiceShurui = ddlServiceShurui;
    }

    // </editor-fold>
}
