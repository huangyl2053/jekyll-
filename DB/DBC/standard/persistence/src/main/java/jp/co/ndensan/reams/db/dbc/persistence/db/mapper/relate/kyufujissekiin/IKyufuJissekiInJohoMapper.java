/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.kyufujissekiin;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.kokuhorenkyoutsuu.KokuhorenIchiranhyoMybatisParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kyufujissekikoshinin.JigyoshaMeisyoAndShikibetsuNoKanrenEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kyufujissekitorikomiichiran.KyufujissekiTorikomiIchiranEntity;

/**
 * 給付更新結果情報取込のMapperです。
 *
 * @reamsid_L DBC-2440-010 zhangrui
 */
public interface IKyufuJissekiInJohoMapper {

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
     * @return List<KyufujissekiTorikomiIchiranEntity>
     */
    List<KyufujissekiTorikomiIchiranEntity> get帳票出力対象データ(KokuhorenIchiranhyoMybatisParameter parameter);
}
