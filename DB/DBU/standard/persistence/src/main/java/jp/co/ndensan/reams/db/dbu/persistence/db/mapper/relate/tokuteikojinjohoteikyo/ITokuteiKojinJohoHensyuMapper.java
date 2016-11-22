/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.persistence.db.mapper.relate.tokuteikojinjohoteikyo;

import java.util.List;
import jp.co.ndensan.reams.db.dbu.definition.mybatisprm.tokuteikojinjohoteikyo.TokuteiKojinJohoHensyuMybatisParamater;
import jp.co.ndensan.reams.db.dbu.entity.db.relate.tokuteikojinjohoteikyo.TeikyoKihonJohoNNTempEntity;

/**
 * 特定個人情報提供編集(標準)のmapperクラスです。
 *
 * @reamsid_L DBU-4880-100 dingyi
 */
public interface ITokuteiKojinJohoHensyuMapper {

    /**
     * 中間DB提供基本情報を取得します。
     *
     * @param paramater パラメータ
     * @return 中間DB提供基本情報
     */
    List<TeikyoKihonJohoNNTempEntity> get中間DB提供基本情報(TokuteiKojinJohoHensyuMybatisParamater paramater);

}
