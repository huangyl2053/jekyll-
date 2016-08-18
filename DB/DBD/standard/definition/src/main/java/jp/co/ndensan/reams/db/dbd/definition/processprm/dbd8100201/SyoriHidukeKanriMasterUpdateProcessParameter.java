/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.definition.processprm.dbd8100201;

import jp.co.ndensan.reams.db.dbd.definition.mybatisprm.dbd8100201.SyoriHidukeKanriMasterUpdateMybatisParameter;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 処理日付管理マスタ更新_ProcessParameter
 *
 * @reamsid_L DBD-4910-030 x_xuliang
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class SyoriHidukeKanriMasterUpdateProcessParameter implements IBatchProcessParameter {

    private FlexibleYear 処理年度;
    private RString 処理区分;
    private RString 対象月;
    private FlexibleDate 処理年月日;
    private YMDHMS 処理日時;

    /**
     * 処理日付管理マスタ更新SQLのパラメターを取得します．
     *
     * @param 保険者情報_保険者番号 保険者情報_保険者番号
     * @param 処理名 処理名
     * @return 処理日付管理マスタ更新SQLのパラメター
     */
    public SyoriHidukeKanriMasterUpdateMybatisParameter toSyoriHidukeKanriMasterUpdateMybatisParameter(LasdecCode 保険者情報_保険者番号,
            RString 処理名) {
        return new SyoriHidukeKanriMasterUpdateMybatisParameter(保険者情報_保険者番号, 処理名, 処理年度, 処理区分, 対象月);
    }
}
