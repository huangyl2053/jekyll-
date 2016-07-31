/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.batchcontroller.flow.shiharaihohohenkolist;

import jp.co.ndensan.reams.db.dbd.batchcontroller.step.shiharaihohohenkolist.CreateTaishoshaJohoTempTableProcess;
import jp.co.ndensan.reams.db.dbd.definition.batchprm.shiharaihohohenkolist.ShiharaiHohoHenkoListFlowParameter;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;

/**
 * 支払方法変更管理リスト作成_バッチフロークラスです。
 *
 * @reamsid_L DBD-3630-040 zhulx
 */
public class ShiharaiHohoHenkoListFlow extends BatchFlowBase<ShiharaiHohoHenkoListFlowParameter> {

//    private RDateTime バッチ起動時処理日時;
//    private RString 支払方法変更_支払方法変更期限;
//    private RString 支払方法変更_支払一時差止期限;
//    private RString 日付関連_調定年度;
    @Override
    protected void prepareConfigData() {
//        バッチ起動時処理日時 = RDate.getNowDateTime();
//        支払方法変更_支払方法変更期限 = DbBusinessConfig.get(
//                ConfigNameDBD.支払方法変更_支払方法変更期限, バッチ起動時処理日時.getDate(), SubGyomuCode.DBD介護受給);
//        支払方法変更_支払一時差止期限 = DbBusinessConfig.get(
//                ConfigNameDBD.支払方法変更_支払一時差止期限, バッチ起動時処理日時.getDate(), SubGyomuCode.DBD介護受給);
//        日付関連_調定年度 = DbBusinessConfig.get(ConfigNameDBB.日付関連_調定年度, バッチ起動時処理日時.getDate(), SubGyomuCode.DBB介護賦課);
    }

    @Override
    protected void defineFlow() {
        executeStep(支払方法変更管理リスト発行);
    }

    private static final String 支払方法変更管理リスト発行 = "set支払方法変更管理リスト";

    /**
     * 支払方法変更管理リスト発行を行います。
     *
     * @return バッチコマンド
     */
    @Step(支払方法変更管理リスト発行)
    protected IBatchFlowCommand set支払方法変更管理リスト() {
        return loopBatch(CreateTaishoshaJohoTempTableProcess.class)
                .arguments(getParameter().toShiharaiHohoKanriListProcessParameter())
                .define();
    }

}
