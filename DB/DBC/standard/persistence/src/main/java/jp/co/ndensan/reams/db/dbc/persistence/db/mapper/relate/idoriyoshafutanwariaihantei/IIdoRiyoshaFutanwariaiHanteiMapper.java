/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.idoriyoshafutanwariaihantei;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.dbc180020.IdoDateTyuushutuKyoutsuuMyBatisParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.idoriyoshafutanwariaihantei.IdoRiyoshaDateEntity;

/**
 * 異動データ抽出のMapperクラスです。
 *
 * @reamsid_L DBC-4950-033 pengxingyi
 */
public interface IIdoRiyoshaFutanwariaiHanteiMapper {

    List<IdoRiyoshaDateEntity> select受給者台帳異動(IdoDateTyuushutuKyoutsuuMyBatisParameter parameter);

    List<IdoRiyoshaDateEntity> select総合事業対象者異動(IdoDateTyuushutuKyoutsuuMyBatisParameter parameter);
}
