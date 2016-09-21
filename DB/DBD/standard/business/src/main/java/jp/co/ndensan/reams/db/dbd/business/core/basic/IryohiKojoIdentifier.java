/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.core.basic;

import java.io.Serializable;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 医療費控除の識別子です。
 *
 * @reamsid_L DBD-5780-010 tz_chengpeng
 *
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Value
public class IryohiKojoIdentifier implements Serializable {

    private final HihokenshaNo 被保険者番号;
    private final FlexibleYear 控除対象年;
    private final RString データ区分;

    /**
     * コンストラクタです。
     *
     * @param 被保険者番号 被保険者番号
     * @param 控除対象年 控除対象年
     * @param データ区分 データ区分
     */
    public IryohiKojoIdentifier(
            HihokenshaNo 被保険者番号,
            FlexibleYear 控除対象年,
            RString データ区分) {
        this.被保険者番号 = 被保険者番号;
        this.控除対象年 = 控除対象年;
        this.データ区分 = データ区分;
    }
}
