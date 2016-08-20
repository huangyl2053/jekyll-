/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.kyufujissekikoshinin;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.kokuhorenkyoutsuu.KokuhorenIchiranhyoMybatisParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.chohyoshutsuryokutaishodate.ChohyoShutsuryokuTaishoDateEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kyufujissekikoshinin.JigyoshaMeisyoAndShikibetsuNoKanrenEntity;

/**
 * 給付実績更新結果情報取込のMapperです。
 *
 * @reamsid_L DBC-2470-010 liuhui
 */
public interface IKyufuJissekiKoshinJohoMapper {

    /**
     * 介護事業者TBLと給付実績一時TBLからデータを取ります。
     *
     * @return List<JigyosyaMeisyoKanrenEntity>
     */
    List<JigyoshaMeisyoAndShikibetsuNoKanrenEntity> select事業者名称関連リスト();

    /**
     * 識別番号管理TBLと給付実績一時TBLからデータを取ります。
     *
     * @return List<JigyosyaMeisyoKanrenEntity>
     */
    List<JigyoshaMeisyoAndShikibetsuNoKanrenEntity> select入力識別名称関連リスト();

    /**
     * 帳票出力対象データを取得する。
     *
     * @param parameter Map<String, Object>
     * @return List<ChohyoShutsuryokuTaishoDateEntity>
     */
    List<ChohyoShutsuryokuTaishoDateEntity> get帳票出力対象データ(KokuhorenIchiranhyoMybatisParameter parameter);
}
