/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.mybatisprm.kyufuhigenmenjyouhouregister;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;

/**
 * ビジネス設計_DBCMN71001_給付費通知減免情報補正登録(減免補正情報の取得)Parameterクラスです。
 *
 * @reamsid_L DBC-2260-030 xuyongchao
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
public class KyufuhigenmenjyouhouregisterParameter implements IMyBatisParameter {

    private final HihokenshaNo hiHokenshaNo;
    private final FlexibleYearMonth serviceTeikyoKaisiYM;
    private final FlexibleYearMonth serviceTeikyoSyuryoYM;
    private final int maxCount;
    private final boolean kaisiFlag;
    private final boolean syuroFlag;

    /**
     * コンストラクタです。
     *
     * @param hiHokenshaNo 被保険者番号
     * @param serviceTeikyoKaisiYM サービス指定開始年月
     * @param serviceTeikyoSyuryoYM サービス指定終了年月
     * @param maxCount 最大取得件数
     * @param kaisiFlag kaisiFlag
     * @param syuroFlag syuroFlag
     */
    protected KyufuhigenmenjyouhouregisterParameter(HihokenshaNo hiHokenshaNo,
            FlexibleYearMonth serviceTeikyoKaisiYM,
            FlexibleYearMonth serviceTeikyoSyuryoYM,
            int maxCount,
            boolean kaisiFlag,
            boolean syuroFlag) {
        this.hiHokenshaNo = hiHokenshaNo;
        this.serviceTeikyoKaisiYM = serviceTeikyoKaisiYM;
        this.serviceTeikyoSyuryoYM = serviceTeikyoSyuryoYM;
        this.maxCount = maxCount;
        this.kaisiFlag = kaisiFlag;
        this.syuroFlag = syuroFlag;
    }

    /**
     * コンストラクタです。
     *
     * @param hiHokenshaNo 被保険者番号
     * @param serviceTeikyoKaisiYM サービス指定開始年月
     * @param serviceTeikyoSyuryoYM サービス指定終了年月
     * @param maxCount 最大取得件数
     * @return kyufuhigenmenjyouhouregisterParameter
     */
    public static KyufuhigenmenjyouhouregisterParameter createSelectByKeyParam(HihokenshaNo hiHokenshaNo,
            FlexibleYearMonth serviceTeikyoKaisiYM,
            FlexibleYearMonth serviceTeikyoSyuryoYM,
            int maxCount) {
        boolean kaisi = true;
        boolean syuro = true;
        if (null == serviceTeikyoKaisiYM || serviceTeikyoKaisiYM.isEmpty()) {
            kaisi = false;
        }
        if (null == serviceTeikyoSyuryoYM || serviceTeikyoSyuryoYM.isEmpty()) {
            syuro = false;
        }

        return new KyufuhigenmenjyouhouregisterParameter(hiHokenshaNo, serviceTeikyoKaisiYM,
                serviceTeikyoSyuryoYM, maxCount, kaisi, syuro);
    }

}
