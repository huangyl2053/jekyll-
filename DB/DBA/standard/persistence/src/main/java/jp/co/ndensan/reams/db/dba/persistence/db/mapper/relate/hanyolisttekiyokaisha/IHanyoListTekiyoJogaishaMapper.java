/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.persistence.db.mapper.relate.hanyolisttekiyokaisha;

import java.util.List;
import jp.co.ndensan.reams.db.dba.definition.mybatisprm.hanyolisttekiyojogaisha.HanyoListTekiyoJogaishaMybatisParameter;
import jp.co.ndensan.reams.db.dba.entity.db.relate.hanyolisttekiyojogaisha.HanyoListTekiyoJogaishaRelateEntity;

/**
 * 汎用リスト_適用除外者のマッパーインタフェースです。
 *
 * @reamsid_L DBA-1600-030 yaodongsheng
 */
public interface IHanyoListTekiyoJogaishaMapper {

    /**
     * 適用除外者情報を取得します。
     *
     * @param parameter HanyoListTekiyoJogaishaMybatisParameter
     * @return List<HanyoListTekiyoJogaishaRelateEntity>
     */
    List<HanyoListTekiyoJogaishaRelateEntity> getTekiyoKaisha(HanyoListTekiyoJogaishaMybatisParameter parameter);
}
