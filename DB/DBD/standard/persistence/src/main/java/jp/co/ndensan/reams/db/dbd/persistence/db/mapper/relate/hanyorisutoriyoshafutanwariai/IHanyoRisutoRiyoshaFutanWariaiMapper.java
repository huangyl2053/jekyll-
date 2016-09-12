/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.persistence.db.mapper.relate.hanyorisutoriyoshafutanwariai;

import java.util.List;
import jp.co.ndensan.reams.db.dbd.definition.mybatisprm.hanyorisutoriyoshafutanwariai.HanyoRisutoRiyoshaFutanWariaiMybatisParameter;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.hanyorisutoriyoshafutanwariai.HanyoRisutoRiyoshaFutanWariaiEntity;

/**
 * 汎用リスト出力(利用者負担割合)のマッパーインタフェースです。
 *
 * @reamsid_L DBD-5810-030 mawy
 */
public interface IHanyoRisutoRiyoshaFutanWariaiMapper {

    /**
     * 汎用リスト情報を取得します。
     *
     * @param parameter パラメータク
     * @return List<HanyoRisutoRiyoshaFutanWariaiEntity>
     */
    List<HanyoRisutoRiyoshaFutanWariaiEntity> get汎用リスト(HanyoRisutoRiyoshaFutanWariaiMybatisParameter parameter);
}
