/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.definition.mybatisprm.renrakuhyodatacreator;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;

/**
 * 介護保険連絡票作成のMyBatis用パラメータクラスです。
 *
 * @reamsid_L DBA-1290-020 linghuhang
 */
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public final class FutangakuGengakuMybatisParameter {

    private final HihokenshaNo hokenshaNo;
    private final FlexibleYearMonth serviceTeikyoYM;

    /**
     * コンストラクタです。
     *
     * @param hihokenshaNo 被保険者番号
     * @param kijunbi 基準日
     */
    private FutangakuGengakuMybatisParameter(
            HihokenshaNo hokenshaNo,
            FlexibleYearMonth serviceTeikyoYM) {
        this.hokenshaNo = hokenshaNo;
        this.serviceTeikyoYM = serviceTeikyoYM;
    }

    /**
     * 利用者負担額取得のパラメータを生成します。
     *
     * @param hokenshaNo 被保険者番号
     * @param serviceTeikyoYM 基準日
     * @return FutangakuGengakuMybatisParameter
     */
    public static FutangakuGengakuMybatisParameter createParam_Futangaku(
            HihokenshaNo hokenshaNo,
            FlexibleYearMonth serviceTeikyoYM) {
        return new FutangakuGengakuMybatisParameter(hokenshaNo, serviceTeikyoYM);
    }
}
