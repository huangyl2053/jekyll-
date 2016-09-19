package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1230011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.ShiharaiHohoJyoho.ShiharaiHohoJyoho.IShiharaiHohoJyohoDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.ShiharaiHohoJyoho.ShiharaiHohoJyoho.ShiharaiHohoJyohoDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.TabPanel;

/**
 * tplShiharai のクラスファイル
 *
 * @reamsid_L DBC-2290-010 quxiaodong
 */
public class tplShiharaiDiv extends TabPanel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ccdShiharaiHohoJoho")
    private ShiharaiHohoJyohoDiv ccdShiharaiHohoJoho;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getccdShiharaiHohoJoho
     * @return ccdShiharaiHohoJoho
     */
    @JsonProperty("ccdShiharaiHohoJoho")
    public IShiharaiHohoJyohoDiv getCcdShiharaiHohoJoho() {
        return ccdShiharaiHohoJoho;
    }

    // </editor-fold>
}
