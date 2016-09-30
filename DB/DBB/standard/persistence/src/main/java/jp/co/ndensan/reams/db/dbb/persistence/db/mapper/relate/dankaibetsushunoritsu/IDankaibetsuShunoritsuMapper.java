/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.persistence.db.mapper.relate.dankaibetsushunoritsu;

import java.util.List;
import jp.co.ndensan.reams.db.dbb.definition.mybatisprm.dankaibetsushunoritsu.InsDankaibetsuShunoritsuTmpMybatisParamter;
import jp.co.ndensan.reams.db.dbb.definition.mybatisprm.dankaibetsushunoritsu.PrtDankaibetsuShunoritsuIchiranhyoMybatisParamter;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.dankaibetsushunoritsu.DankaibetsuShunoritsuDataEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.dankaibetsushunoritsu.DankaibetsuShunoritsuTempEntity;

/**
 * 保険料段階別収納率一覧表作成のマッピングクラスです。
 *
 * @reamsid_L DBB-1630-020 tianshuai
 */
public interface IDankaibetsuShunoritsuMapper {

    /**
     * 保険料段階別収納率一時を取得します。
     *
     * @param paramter paramter
     * @return 収納宛名データ
     */
    List<DankaibetsuShunoritsuDataEntity> get収納宛名データ(InsDankaibetsuShunoritsuTmpMybatisParamter paramter);

    /**
     * 保険料段階別収納率一時を取得します。
     *
     * @param paramter paramter
     * @return 保険料段階別収納率一時テーブル 保険料段階別収納率一時テーブル
     */
    List<DankaibetsuShunoritsuTempEntity> select保険料段階別収納率一覧表(
            PrtDankaibetsuShunoritsuIchiranhyoMybatisParamter paramter);
}
