package jp.co.ndensan.reams.db.dbd.divcontroller.entity.commonchilddiv.gemmemgengakushinsei.GemmenGengakuShinsei;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ShisetsuJohoCommonChildDiv.IShisetsuJohoCommonChildDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ShisetsuJohoCommonChildDiv.ShisetsuJohoCommonChildDivDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * ShinseiDaikoJigyosha のクラスファイル 
 * 
 * @author 自動生成
 */
public class ShinseiDaikoJigyoshaDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ccdShisetsuJoho")
    private ShisetsuJohoCommonChildDivDiv ccdShisetsuJoho;
    @JsonProperty("ddlJigyoshaKubun")
    private DropDownList ddlJigyoshaKubun;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getccdShisetsuJoho
     * @return ccdShisetsuJoho
     */
    @JsonProperty("ccdShisetsuJoho")
    public IShisetsuJohoCommonChildDiv getCcdShisetsuJoho() {
        return ccdShisetsuJoho;
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

    // </editor-fold>
}
