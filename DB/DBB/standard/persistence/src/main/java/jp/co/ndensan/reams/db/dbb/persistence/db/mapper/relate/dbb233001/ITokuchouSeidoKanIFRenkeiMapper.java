/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.persistence.db.mapper.relate.dbb233001;

import java.util.List;
import jp.co.ndensan.reams.db.dbb.definition.mybatisprm.dbb233001.TokuchouSeidoKanIFRenkeiMyBatisParameter;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.dbb233001.TokuchouSeidoKanIFRenkeiEntity;

/**
 * バッチ設計_DBB233001_特徴制度間Ｉ／Ｆ連携　の作成です。
 *
 * @reamsid_L DBB-1810-040 dengjiajia
 */
public interface ITokuchouSeidoKanIFRenkeiMapper {

    /**
     * 連携ファイル用データ取得です。
     *
     * @param parameter TokuchouSeidoKanIFRenkeiMyBatisParameter
     * @return List<TokuchouSeidoKanIFRenkeiEntity>
     */
    List<TokuchouSeidoKanIFRenkeiEntity> select連携ファイル用(TokuchouSeidoKanIFRenkeiMyBatisParameter parameter);

}
