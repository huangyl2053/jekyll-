/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.definition.mybatisprm.dbd8100201;

import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 処理日付管理マスタ更新SQLのパラメータクラスです．
 *
 * @reamsid_L DBD-4910-030 x_lilh
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class SyoriHidukeKanriMasterUpdateMybatisParameter implements IMyBatisParameter {

    private RString 保険者情報_保険者番号;
    private RString 処理名;
    private FlexibleYear 処理年度;
    private RString 処理区分_対象月;

    /**
     * DB出力(処理日付管理マスタ)
     *
     * @param 保険者情報_保険者番号 保険者情報_保険者番号
     * @param 処理名 処理名
     * @param 処理年度 処理年度
     * @param 処理区分 処理区分
     * @param 対象月 対象月
     */
    public SyoriHidukeKanriMasterUpdateMybatisParameter(RString 保険者情報_保険者番号,
            RString 処理名, FlexibleYear 処理年度, RString 処理区分, RString 対象月) {
        this.保険者情報_保険者番号 = 保険者情報_保険者番号;
        this.処理名 = 処理名;
        this.処理年度 = 処理年度;
        edit処理区分_対象月(処理区分, 対象月);
    }

    private void edit処理区分_対象月(RString 処理区分, RString 対象月) {

        if (!処理区分.isNullOrEmpty() && !対象月.isNullOrEmpty()) {
            処理区分_対象月 = 処理区分.concat(対象月);
        }
    }
}
