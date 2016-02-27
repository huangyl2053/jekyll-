/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.persistence.db.basic.mapper.kyokaisogaitosha;

import java.util.List;
import jp.co.ndensan.reams.db.dbu.definition.mybatisprm.kyokaisogaitosha.KyokaisoGaitoshaMybatisParameter;
import jp.co.ndensan.reams.db.dbu.entity.db.relate.kyokaisogaitosha.KyokaisogGaitoshaRelateEntity;

/**
 *
 * 境界層管理マスタリストMapperクラスです。
 */
public interface IKkyokaisoGaitoshaMapper {

    /**
     * 境界層管理マスタリストMapper。
     *
     * @param parameter 境界層該当者一覧情報パラメータ
     * @return List<KyokaisoGaitoshaRelateEntity>
     */
    List<KyokaisogGaitoshaRelateEntity> getKyokaisoKanriMasterList(KyokaisoGaitoshaMybatisParameter parameter);

}
