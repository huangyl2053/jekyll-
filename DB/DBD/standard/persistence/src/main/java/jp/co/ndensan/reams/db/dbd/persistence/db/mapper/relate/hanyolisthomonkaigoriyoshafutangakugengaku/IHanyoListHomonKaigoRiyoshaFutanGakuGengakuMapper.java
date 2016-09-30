/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.persistence.db.mapper.relate.hanyolisthomonkaigoriyoshafutangakugengaku;

import java.util.List;
import jp.co.ndensan.reams.db.dbd.definition.mybatisprm.hanyolisthomonkaigoriyoshafutangakugengaku.HomonKaigoRiyoshaFutanGakuGengakuMybatisParameter;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.hanyolisthomonkaigoriyoshafutangakugengaku.HomonKaigoRiyoshaFutanGakuGengakuEntity;

/**
 *
 * 汎用リスト出力(訪問介護利用者負担額減額)のマッパーインタフェースです。
 *
 * @reamsid_L DBD-3940-030 panxiaobo
 */
public interface IHanyoListHomonKaigoRiyoshaFutanGakuGengakuMapper {

    /**
     * 汎用リスト情報を取得します。
     *
     * @param parameter パラメータク
     * @return List<HomonKaigoRiyoshaFutanGakuGengakuEntity>
     */
    List<HomonKaigoRiyoshaFutanGakuGengakuEntity> get汎用リスト(HomonKaigoRiyoshaFutanGakuGengakuMybatisParameter parameter);
}
