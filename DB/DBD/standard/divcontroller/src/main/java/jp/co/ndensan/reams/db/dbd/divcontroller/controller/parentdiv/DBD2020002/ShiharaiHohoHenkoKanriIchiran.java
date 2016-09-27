/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.controller.parentdiv.DBD2020002;

import jp.co.ndensan.reams.db.dbd.definition.batchprm.DBD207012.DBD207012_ShiharaiHohoHenkoKanriListParameter;
import jp.co.ndensan.reams.db.dbd.definition.core.shiharaihohokanrilist.ShiharaiHohoKanriListData;
import jp.co.ndensan.reams.db.dbd.definition.reportid.ReportIdDBD;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD2020002.ShiharaiHohoKanriListMainDiv;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;

/**
 * 支払方法変更管理リスト（画面）のビジネスクラス
 *
 * @reamsid_L DBD-3630-030 liangbc
 */
public class ShiharaiHohoHenkoKanriIchiran {

    private final ShiharaiHohoKanriListMainDiv div;

    /**
     * コンストラクタです。
     *
     * @param div PtnTotalDiv
     */
    public ShiharaiHohoHenkoKanriIchiran(ShiharaiHohoKanriListMainDiv div) {
        this.div = div;
    }

    /**
     * バッチ用パラメータを作成します。
     *
     * @return CreateShiharaiHohoListBatchParameter 支払方法変更管理リスト_バッチ用のパラメータ
     */
    public DBD207012_ShiharaiHohoHenkoKanriListParameter createShiharaiHohoHenkoKanriIchiranParameter() {
        ShiharaiHohoKanriListData tempData = new ShiharaiHohoKanriListData();
        tempData.set基準日(div.getChushutsuJoken().getTxtKijunYMD().getValue());
        tempData.set登録者選択(div.getRadTorokusha().getSelectedKey());
        tempData.set差止予告登録者の選択(div.getChushutsuJoken().getDdl2GoSashitomeYokoku().getSelectedKey());
        tempData.set差止登録者の選択(div.getChushutsuJoken().getDdlGoSashitomeToroku().getSelectedKey());
        tempData.set償還予告登録者の選択(div.getChushutsuJoken().getDdl2GoShokanYokoku().getSelectedKey());
        tempData.set償還決定登録者の選択(div.getChushutsuJoken().getDdl1GoShokanKettei().getSelectedKey());
        tempData.set償還決定登録者1の選択(div.getChushutsuJoken().getDdl1GoShokanKetteiSashitomeAriOnly().getSelectedKey());
        tempData.set償還決定登録者2の選択(div.getChushutsuJoken().getDdl1GoShokanKetteiKojoAriOnly().getSelectedKey());
        tempData.set改頁出力順ID(div.getCcdChohyoShutsuryokujun().get出力順ID());
        tempData.set帳票ID(ReportIdDBD.DBD200007.getReportId());
        tempData.set帳票分類ID(ReportIdDBD.DBD200007.getReportId());
        tempData.set帳票作成日時(RDateTime.now());
        DBD207012_ShiharaiHohoHenkoKanriListParameter batchParameter = new DBD207012_ShiharaiHohoHenkoKanriListParameter();
        batchParameter.toDbd207010BatchParameter(tempData);
        return batchParameter;
    }
}
