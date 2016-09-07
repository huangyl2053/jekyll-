/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.persistence.db.mapper.relate.gemmengengaku.riyoshafutangengaku;

import java.util.List;
import jp.co.ndensan.reams.db.dbd.definition.mybatisprm.gemmengengaku.ninteishoketteitsuchishokobetsuhakko.NinteiJohoParameter;
import jp.co.ndensan.reams.db.dbd.definition.mybatisprm.gemmengengaku.riyoshafutangengaku.RiyoshaFutangakuGengakuMapperParameter;
import jp.co.ndensan.reams.db.dbd.definition.mybatisprm.gemmengengaku.riyoshafutangengaku.RiyoshaFutangakuGengakuServiceMapperParameter;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.gemmengengaku.riyoshafutangengaku.RiyoshaFutangakuGengakuEntity;

/**
 * 利用者負担額減額のマッパーインタフェースです。
 *
 * @reamsid_L DBD-9999-011 sunhaidi
 */
public interface IRiyoshaFutangakuGengakuMapper {

    /**
     * 利用者負担額減額情報をキー検索で１件取得します。
     *
     * @param 利用者負担額減額検索条件 利用者負担額減額検索条件
     * @return RiyoshaFutangakuGengakuEntity
     */
    RiyoshaFutangakuGengakuEntity select利用者負担額減額ByKey(RiyoshaFutangakuGengakuMapperParameter 利用者負担額減額検索条件);

    /**
     * 主キー1に合致する利用者負担額減額のリストを取得します。
     *
     * @param 利用者負担額減額検索条件 利用者負担額減額検索条件
     * @return RiyoshaFutangakuGengakuEntityの{@code list}
     */
    List<RiyoshaFutangakuGengakuEntity> select利用者負担額減額リストBy主キー1(RiyoshaFutangakuGengakuMapperParameter 利用者負担額減額検索条件);

    /**
     * 利用者負担額減額の情報を取得します。
     *
     * @param parameter 利用者負担額減額検索条件
     * @return List<RiyoshaFutangakuGengakuEntity>
     */
    List<RiyoshaFutangakuGengakuEntity> select利用者負担額減額情報By被保険者番号(RiyoshaFutangakuGengakuServiceMapperParameter parameter);

    /**
     * 利用者負担額減額の情報を取得します。
     *
     * @param parameter 利用者負担額減額検索条件
     * @return List<RiyoshaFutangakuGengakuEntity>
     */
    List<RiyoshaFutangakuGengakuEntity> selectBy被保険者番号And減免減額種類(RiyoshaFutangakuGengakuServiceMapperParameter parameter);

    /**
     * 被保険者番号、減免減額種類、履歴番号により、利用者負担額減額の情報を取得します。
     *
     * @param parameter 利用者負担額減額検索条件
     * @return RiyoshaFutangakuGengakuEntity
     */
    RiyoshaFutangakuGengakuEntity select利用者負担額減額(NinteiJohoParameter parameter);
}
