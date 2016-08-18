/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.definition.mybatisprm.dbd581001;

import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;

/**
 * バッチパラメタークラスです．
 *
 * @reamsid_L DBD-1771-020 chenxin
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class YokaigoJissiJyokyohyoHakkouMybatisParameter implements IMyBatisParameter {

    FlexibleDate 対象年月日From;
    FlexibleDate 対象年月日To;

    public YokaigoJissiJyokyohyoHakkouMybatisParameter(
            FlexibleDate 対象年月日From,
            FlexibleDate 対象年月日To) {
        this.対象年月日From = 対象年月日From;
        this.対象年月日To = 対象年月日To;
    }
}
