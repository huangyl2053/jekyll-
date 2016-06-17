/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.entity.commonchilddiv.ShisetsuIdoJoho.ShisetsuIdoJoho;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbd.business.core.shisetsuidojoho.ShisetsuIdoJoho;
import jp.co.ndensan.reams.db.dbd.service.core.shisetsuidojoho.ShisetsuIdoJohoFinder;
import jp.co.ndensan.reams.db.dbz.definition.core.shisetsushurui.ShisetsuType;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxFlexibleDate;

/**
 * 【共有子Div】 施設入退ハンドラクラスです。
 *
 * @reamsid_L DBD-3560-120 wangjie2
 */
public class ShisetsuIdoJohoHandler {

    private final ShisetsuIdoJohoDiv div;

    /**
     * コンストラクタです。
     *
     * @param div 【共有子Div】施設入退Div
     */
    public ShisetsuIdoJohoHandler(ShisetsuIdoJohoDiv div) {
        this.div = div;
    }

    /**
     * 画面初期化処理です。
     *
     * @param 識別コード 識別コード
     * @return is識別コード取得ある
     */
    public boolean initializa(ShikibetsuCode 識別コード) {
        ShisetsuIdoJohoFinder finder = ShisetsuIdoJohoFinder.createIntance();
        List<ShisetsuIdoJoho> 介護施設入退所情報List = finder.get介護施設入退所情報(識別コード);
        div.getDgShisetsuIdoJoho().setDataSource(getDataSource(介護施設入退所情報List));
        return true;
    }

    private List<dgShisetsuIdoJoho_Row> getDataSource(List<ShisetsuIdoJoho> 介護施設入退所情報List) {
        List<dgShisetsuIdoJoho_Row> dataSourceList = new ArrayList<>();
        for (ShisetsuIdoJoho 介護施設入退所情報 : 介護施設入退所情報List) {
            dgShisetsuIdoJoho_Row dataSource = new dgShisetsuIdoJoho_Row();
            if (介護施設入退所情報.get入所年月日() != null) {
                TextBoxFlexibleDate 入所日 = new TextBoxFlexibleDate();
                入所日.setValue(介護施設入退所情報.get入所年月日());
                dataSource.setNyushoDate(入所日);
            }
            if (介護施設入退所情報.get退所年月日() != null) {
                TextBoxFlexibleDate 退所日 = new TextBoxFlexibleDate();
                退所日.setValue(介護施設入退所情報.get退所年月日());
                dataSource.setTaishoDate(退所日);
            }
            dataSource.setJigyoshaName(介護施設入退所情報.get事業者名称());
            dataSource.setJigyoshaCode(介護施設入退所情報.get入所施設コード());
            //TODO 転出先保険者番号 法改正関連項目。テーブル未修正のため、TODOとする。
            dataSource.setTenshutsusakiHokenshaNo(RString.EMPTY);
            if (介護施設入退所情報.get入所施設種類() != null) {
                dataSource.setShisetsuShurui(ShisetsuType.toValue(介護施設入退所情報.get入所施設種類()).get名称());
            }
            dataSourceList.add(dataSource);
        }
        return dataSourceList;
    }

}
