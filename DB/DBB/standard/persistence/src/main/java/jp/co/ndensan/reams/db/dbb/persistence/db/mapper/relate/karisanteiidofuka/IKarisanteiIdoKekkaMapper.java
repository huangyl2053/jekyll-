/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.persistence.db.mapper.relate.karisanteiidofuka;

import java.util.List;
import jp.co.ndensan.reams.db.dbb.definition.mybatisprm.karisanteiidofuka.KariSanteiIdoFukaMybatisParameter;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.karisanteiidofuka.KarisanteiIdoKekkaEntity;

/**
 * ビジネス設計_DBBBZ36001_1_仮算定異動賦課（バッチ）のMapperインタフェースです。
 *
 * @reamsid_L DBB-0850-020 zhaowei
 */
public interface IKarisanteiIdoKekkaMapper {

    /**
     * 異動賦課情報テーブルの全項目取得する
     *
     * @param parameter 検索条件
     * @return List<KarisanteiIdoKekkaIchiranEntity> 仮算定異動賦課情報
     */
    List<KarisanteiIdoKekkaEntity> select仮算定異動賦課(KariSanteiIdoFukaMybatisParameter parameter);
}
