/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.definition.mybatisprm.taino;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 滞納状況取得のパラメータです。
 *
 * @reamsid_L DBD-3620-060 liangbc
 */
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public final class TainoJokyoMapperParameter {

    private final RDate 基準日;
    private final RDateTime 基準日時;
    private final HihokenshaNo 被保険者番号;
    private final FlexibleYear 賦課年度;
    private final FlexibleYear 賦課年度十年前;
    private static final int 十年前 = 10;

    private TainoJokyoMapperParameter(RDate 基準日, HihokenshaNo 被保険者番号, FlexibleYear 賦課年度) {
        this.基準日 = 基準日;
        this.基準日時 = RDateTime.of(new RString(基準日.plusDay(1).toString()), RString.EMPTY);
        this.被保険者番号 = 被保険者番号;
        this.賦課年度 = 賦課年度;
        this.賦課年度十年前 = 賦課年度.minusYear(十年前);
    }

    /**
     * 滞納状況取得のパラメータを作成
     *
     * @param 基準日 基準日
     * @param 被保険者番号 被保険者番号
     * @param 賦課年度 賦課年度
     * @return 滞納状況取得のパラメータ
     */
    public static TainoJokyoMapperParameter createParameter(RDate 基準日, HihokenshaNo 被保険者番号, FlexibleYear 賦課年度) {
        return new TainoJokyoMapperParameter(基準日, 被保険者番号, 賦課年度);
    }

}
