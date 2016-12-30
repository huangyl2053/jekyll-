/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.shinsakaitaishosha;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.shinsakaitaishosha.ShinsakaiTaishoshaMapperParameter;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.shinsakaitaishosha.TaishoshaIchiranMapperParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shinsakaitaishosha.ShinsakaiTaishoshaRelateEntity;

/**
 * 「審査会個人別状況照会」画面のMapperです。
 *
 * @reamsid_L DBE-1380-010 jinjue
 */
public interface IShinsakaiTaishoshaRelateMapper {

    /**
     * 初期化の予定情報と結果情報の検索です。
     *
     * @param param ShinsakaiTaishoshaMapperParameter
     * @return List<ShinsakaiTaishoshaRelateEntity>
     */
    List<ShinsakaiTaishoshaRelateEntity> get予定情報と結果情報(ShinsakaiTaishoshaMapperParameter param);

    /**
     * 初期化の審査会対象者一覧の検索です。
     *
     * @param param TaishoshaIchiranMapperParameter
     * @return List<ShinsakaiTaishoshaRelateEntity>
     */
    List<ShinsakaiTaishoshaRelateEntity> get情報(TaishoshaIchiranMapperParameter param);

}
