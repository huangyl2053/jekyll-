/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.kyodojukyushataishosha;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.kyodojukyushataishosha.KyodoIdoRenrakuhyoTaishoshaKensakuParameter;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.kyodojukyushataishosha.KyodoJukyushaTaishoshaParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3002KyodoShoriyoJukyushaIdoKihonSofuEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3003KyodoShoriyoJukyushaIdoShokanSofuEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3004KyodoShoriyoJukyushaIdoKogakuSofuEntity;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;

/**
 * 共同処理用受給者訂正連絡票登録（対象者検索）のMapperクラスです。
 *
 * @reamsid_L DBC-1951-050 chenaoqi
 */
public interface IKyodoJukyushaTaishoshaFinderMapper {

    /**
     * 共同処理用受給者異動基本送付情報テーブルより対象者一覧を検索する
     *
     * @param parameter KyodoJukyushaTaishoshaParameter
     * @return 基本送付情報
     */
    List<DbT3002KyodoShoriyoJukyushaIdoKihonSofuEntity> get基本送付情報(KyodoJukyushaTaishoshaParameter parameter);

    /**
     * 共同処理用受給者異動償還送付情報テーブルより対象者一覧を検索する
     *
     * @param parameter KyodoJukyushaTaishoshaParameter
     * @return 償還送付情報
     */
    List<DbT3003KyodoShoriyoJukyushaIdoShokanSofuEntity> get償還送付情報(KyodoJukyushaTaishoshaParameter parameter);

    /**
     * 共同処理用受給者異動高額送付テーブルより対象者一覧を検索する
     *
     * @param parameter KyodoJukyushaTaishoshaParameter
     * @return 高額送付情報
     */
    List<DbT3004KyodoShoriyoJukyushaIdoKogakuSofuEntity> get高額送付情報(KyodoJukyushaTaishoshaParameter parameter);

    /**
     * 被保険者氏名直近の基本送付情報より取得する。
     *
     * @param parameter KyodoJukyushaTaishoshaParameter
     * @return 基本送付情報
     */
    List<DbT3002KyodoShoriyoJukyushaIdoKihonSofuEntity> get被保険者氏名(KyodoJukyushaTaishoshaParameter parameter);

    /**
     * 被保険者情報取得する。
     *
     * @param parameter KyodoIdoRenrakuhyoTaishoshaKensakuParameter
     * @return 被保険者情報
     */
    List<UaFt200FindShikibetsuTaishoEntity> get被保険者情報(KyodoIdoRenrakuhyoTaishoshaKensakuParameter parameter);
}
