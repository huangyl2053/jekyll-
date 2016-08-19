/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.persistence.db.mapper.relate.yokaigoninteitsukibetsujukyushasujokyohyo;

import java.util.List;
import jp.co.ndensan.reams.db.dbd.definition.mybatisprm.dbd582001.YokaigoNinteiTsukibetsuJukyushaMybatisParameter;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd582001.YokaigoNinteiTsukibetsuJukyushaSuJokyohyoEntity;

/**
 * 要介護認定月別受給者数状況表（統計表）のマッパーインタフェースです。
 *
 * @reamsid_L DBD-1771-033 donghj
 */
public interface IYokaigoNinteiTsukibetsuJukyushaSuJokyohyoMapper {

    /**
     * 印刷対象を取得します．
     *
     * @param parameter パラメター
     * @return List<YokaigoNinteiTsukibetsuJukyushaSuJokyohyoEntity>
     */
    List<YokaigoNinteiTsukibetsuJukyushaSuJokyohyoEntity> get印刷対象(YokaigoNinteiTsukibetsuJukyushaMybatisParameter parameter);

}
