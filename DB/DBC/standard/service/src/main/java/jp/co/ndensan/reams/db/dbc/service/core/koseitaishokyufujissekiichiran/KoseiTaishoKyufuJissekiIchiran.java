/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.koseitaishokyufujissekiichiran;

import jp.co.ndensan.reams.db.dbc.definition.batchprm.koseitaishokyufujissekiichiran.KoseiTaishoKyufuJissekiIchiranBatchParameter;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBC;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 更正対象給付実績一覧のビジネス
 *
 * @reamsid_L DBC-4960-031 dongqianjing
 */
public class KoseiTaishoKyufuJissekiIchiran {

    /**
     * にて生成した{@link KoseiTaishoKyufuJissekiIchiran}のインスタンスを返します。
     *
     * @return KoseiTaishoKyufuJissekiIchiran
     */
    public static KoseiTaishoKyufuJissekiIchiran createInstance() {
        return InstanceProvider.create(KoseiTaishoKyufuJissekiIchiran.class);
    }

    /**
     * バッチパラメータの取得のメソッドます。
     *
     * @param 今回抽出期間開始日時 YMDHMS
     * @param 今回抽出期間終了日時 YMDHMS
     * @param 出力順ID RString
     * @return KoseiTaishoKyufuJissekiIchiranBatchParameter
     */
    public KoseiTaishoKyufuJissekiIchiranBatchParameter getBatchiParameter(
            YMDHMS 今回抽出期間開始日時, YMDHMS 今回抽出期間終了日時, RString 出力順ID) {
        KoseiTaishoKyufuJissekiIchiranBatchParameter parameter = new KoseiTaishoKyufuJissekiIchiranBatchParameter();
        parameter.set年度(new FlexibleYear(DbBusinessConfig.get(ConfigNameDBC.利用者負担割合判定管理_年次負担割合処理済年度, RDate.getNowDate(), SubGyomuCode.DBC介護給付)));
        parameter.set抽出期間開始日時(今回抽出期間開始日時);
        parameter.set抽出期間終了日時(今回抽出期間終了日時);
        parameter.set出力順ID(出力順ID);
        return parameter;
    }
}
