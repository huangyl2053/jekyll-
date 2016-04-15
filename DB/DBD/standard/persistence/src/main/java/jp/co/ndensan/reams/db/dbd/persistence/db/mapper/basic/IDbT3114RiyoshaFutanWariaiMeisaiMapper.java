/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.persistence.db.mapper.basic;

import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT3114RiyoshaFutanWariaiMeisaiEntity;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * {@link jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3114RiyoshaFutanWariaiMeisaiEntity}のマッパーIFです。
 *
 * @reamsid_L DBD-3600-030 xuyue
 */
public interface IDbT3114RiyoshaFutanWariaiMeisaiMapper {

    /**
     * 指定した被保険者番号を持つ被保険者の指定日時点の利用者負担割合明細を返却します。
     *
     * @param 被保険者番号 被保険者番号
     * @param 基準日 基準日
     * @return 利用者負担割合明細
     */
    DbT3114RiyoshaFutanWariaiMeisaiEntity notExists_maxRirekiNo(RString 被保険者番号, RString 基準日);

}
