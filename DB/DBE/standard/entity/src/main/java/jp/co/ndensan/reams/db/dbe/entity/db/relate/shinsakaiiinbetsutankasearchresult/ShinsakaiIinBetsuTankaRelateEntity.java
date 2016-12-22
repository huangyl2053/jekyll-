/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.db.relate.shinsakaiiinbetsutankasearchresult;

import jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5034ShinsakaiIinBetsuTankaEntity;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 介護認定審査会委員別単価RelateEntityクラスです。
 *
 * @reamsid_L BA-1280-010 Xiaoyh
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
@lombok.Setter
public class ShinsakaiIinBetsuTankaRelateEntity {

    private RString ShinsakaiIinCode;
    private FlexibleYearMonth kaishiYM;
    private FlexibleYearMonth shuryoYM;
    private DbT5034ShinsakaiIinBetsuTankaEntity 介護認定審査会委員別単価;
    private RString 氏名;
}
