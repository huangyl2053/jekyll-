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
public interface IIdoDateTyuushutuKyoutsuuMapper {

    /**
     * 受給者台帳の異動データ抽出です。
     *
     * @param parameter パラメータ
     * @return {@link List<IdoRiyoshaDateEntity>}
     */
    List<IdoRiyoshaDateEntity> select受給者台帳異動(IdoDateTyuushutuKyoutsuuMyBatisParameter parameter);

    /**
     * 総合事業対象者の異動データ抽出です。
     *
     * @param parameter パラメータ
     * @return {@link List<IdoRiyoshaDateEntity>}
     */
    List<IdoRiyoshaDateEntity> select総合事業対象者異動(IdoDateTyuushutuKyoutsuuMyBatisParameter parameter);

    /**
     * 被保険者台帳の異動データ抽出です。
     *
     * @param parameter パラメータ
     * @return {@link List<IdoRiyoshaDateEntity>}
     */
    List<IdoRiyoshaDateEntity> select被保険者台帳異動(IdoDateTyuushutuKyoutsuuMyBatisParameter parameter);

    /**
     * 介護所得の異動データ抽出です。
     *
     * @param parameter パラメータ
     * @return {@link List<IdoRiyoshaDateEntity>}
     */
    List<IdoRiyoshaDateEntity> select介護所得異動(IdoDateTyuushutuKyoutsuuMyBatisParameter parameter);

    /**
     * 宛名識別対象の異動データ抽出です。
     *
     * @param parameter パラメータ
     * @return {@link List<IdoRiyoshaDateEntity>}
     */
    List<IdoRiyoshaDateEntity> select宛名識別対象異動(IdoDateTyuushutuKyoutsuuMyBatisParameter parameter);

    /**
     * 生活保護受給者の異動データ抽出です。
     *
     * @param parameter パラメータ
     * @return {@link List<IdoRiyoshaDateEntity>}
     */
    List<IdoRiyoshaDateEntity> select生活保護受給者異動(IdoDateTyuushutuKyoutsuuMyBatisParameter parameter);
}
