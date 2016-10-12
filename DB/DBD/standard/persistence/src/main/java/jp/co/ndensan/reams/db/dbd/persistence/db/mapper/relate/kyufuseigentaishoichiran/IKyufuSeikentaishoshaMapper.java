/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.persistence.db.mapper.relate.kyufuseigentaishoichiran;

import java.util.List;
import jp.co.ndensan.reams.db.dbd.definition.mybatisprm.dbd210010.DBD210010MybatisParameter;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd210010.KyufuSeikentaishoshaEntity;

/**
 * 給付制限対象者一覧CSVの情報取得のMapperです。
 *
 * @reamsid_L DBD-4300-030 liuwei2
 */
public interface IKyufuSeikentaishoshaMapper {

    /**
     * 給付制限対象者一覧CSV情報を取得します。
     *
     * @param parameter DBD2020005MybatisParameter
     * @return List<KyufuSeikentaishoshaEntity>
     */
    List<KyufuSeikentaishoshaEntity> get給付制限対象者一覧CSV情報(DBD210010MybatisParameter parameter);
}
