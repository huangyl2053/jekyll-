package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC2210011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.TabContainer;

/**
 * tabTokubetsuKyufuJigyoshaDetail のクラスファイル 
 * 
 * @author 自動生成
 */
public class tabTokubetsuKyufuJigyoshaDetailDiv extends TabContainer {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-21_20-30-14">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("tplShinsei")
    private tplShinseiDiv tplShinsei;
    @JsonProperty("tplService")
    private tplServiceDiv tplService;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettplShinsei
     * @return tplShinsei
     */
    @JsonProperty("tplShinsei")
    public tplShinseiDiv getTplShinsei() {
        return tplShinsei;
    }

    /*
     * settplShinsei
     * @param tplShinsei tplShinsei
     */
    @JsonProperty("tplShinsei")
    public void setTplShinsei(tplShinseiDiv tplShinsei) {
        this.tplShinsei = tplShinsei;
    }

    /*
     * gettplService
     * @return tplService
     */
    @JsonProperty("tplService")
    public tplServiceDiv getTplService() {
        return tplService;
    }

    /*
     * settplService
     * @param tplService tplService
     */
    @JsonProperty("tplService")
    public void setTplService(tplServiceDiv tplService) {
        this.tplService = tplService;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public TokubetsuKyufuJigyoshaDetailShinseishaDiv getTokubetsuKyufuJigyoshaDetailShinseisha() {
        return this.getTplShinsei().getTokubetsuKyufuJigyoshaDetailShinseisha();
    }

    @JsonIgnore
    public void  setTokubetsuKyufuJigyoshaDetailShinseisha(TokubetsuKyufuJigyoshaDetailShinseishaDiv TokubetsuKyufuJigyoshaDetailShinseisha) {
        this.getTplShinsei().setTokubetsuKyufuJigyoshaDetailShinseisha(TokubetsuKyufuJigyoshaDetailShinseisha);
    }

    @JsonIgnore
    public TokubetsuKyufuJigyoshaDetailDaihyoshaDiv getTokubetsuKyufuJigyoshaDetailDaihyosha() {
        return this.getTplShinsei().getTokubetsuKyufuJigyoshaDetailDaihyosha();
    }

    @JsonIgnore
    public void  setTokubetsuKyufuJigyoshaDetailDaihyosha(TokubetsuKyufuJigyoshaDetailDaihyoshaDiv TokubetsuKyufuJigyoshaDetailDaihyosha) {
        this.getTplShinsei().setTokubetsuKyufuJigyoshaDetailDaihyosha(TokubetsuKyufuJigyoshaDetailDaihyosha);
    }

    @JsonIgnore
    public TokubetsuKyufuJigyoshaDetailServiceListDiv getTokubetsuKyufuJigyoshaDetailServiceList() {
        return this.getTplService().getTokubetsuKyufuJigyoshaDetailServiceList();
    }

    @JsonIgnore
    public void  setTokubetsuKyufuJigyoshaDetailServiceList(TokubetsuKyufuJigyoshaDetailServiceListDiv TokubetsuKyufuJigyoshaDetailServiceList) {
        this.getTplService().setTokubetsuKyufuJigyoshaDetailServiceList(TokubetsuKyufuJigyoshaDetailServiceList);
    }

    @JsonIgnore
    public TokubetsuKyufuJigyoshaDetailServiceInfoDiv getTokubetsuKyufuJigyoshaDetailServiceInfo() {
        return this.getTplService().getTokubetsuKyufuJigyoshaDetailServiceInfo();
    }

    @JsonIgnore
    public void  setTokubetsuKyufuJigyoshaDetailServiceInfo(TokubetsuKyufuJigyoshaDetailServiceInfoDiv TokubetsuKyufuJigyoshaDetailServiceInfo) {
        this.getTplService().setTokubetsuKyufuJigyoshaDetailServiceInfo(TokubetsuKyufuJigyoshaDetailServiceInfo);
    }

    // </editor-fold>
}
