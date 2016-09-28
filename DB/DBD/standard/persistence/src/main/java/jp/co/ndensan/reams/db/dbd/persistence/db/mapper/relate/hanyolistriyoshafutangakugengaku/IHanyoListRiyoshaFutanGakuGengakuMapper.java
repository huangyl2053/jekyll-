/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.persistence.db.mapper.relate.hanyolistriyoshafutangakugengaku;

import java.util.List;
import jp.co.ndensan.reams.db.dbd.definition.mybatisprm.hanyolistriyoshafutangakugengaku.RiyoshaFutanGakuGengakuMybatisParameter;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.hanyolistriyoshafutangakugengaku.RiyoshaFutanGakuGengakuEntity;

/**
 *
 * 汎用リスト出力(利用者負担額減免)のマッパーインタフェースです。
 *
 * @reamsid_L DBD-3950-030 panxiaobo
 */
public interface IHanyoListRiyoshaFutanGakuGengakuMapper {

    /**
     * 汎用リスト情報を取得します。
     *
     * @param parameter パラメータク
     * @return List<RiyoshaFutanGakuGengakuEntity>
     */
    List<RiyoshaFutanGakuGengakuEntity> get汎用リスト(RiyoshaFutanGakuGengakuMybatisParameter parameter);
}
