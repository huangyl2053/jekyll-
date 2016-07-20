/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.persistence.db.mapper.relate.renrakuhyodatacreator;

import jp.co.ndensan.reams.db.dbu.definition.mybatisprm.renrakuhyodatacreator.FutangakuGengakuMybatisParameter;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 介護保険連絡票作成のマッパーインタフェースです。
 *
 * @reamsid_L DBA-1290-020 linghuhang
 */
public interface IRenrakuhyoDataCreatorMapper {

    /**
     * 利用者負担額を取得する。
     *
     * @param parameter FutangakuGengakuMybatisParameter
     * @return RiyoshaFutangakuRelateEntity
     */
    Decimal get利用者負担額(FutangakuGengakuMybatisParameter parameter);

}
