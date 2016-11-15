/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.jukyushakyufujissekidaicho;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.jukyushakyufujissekidaicho.CareManagementEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.jukyushakyufujissekidaicho.HukushiYouguEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.jukyushakyufujissekidaicho.JuutakuKaishuuEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.jukyushakyufujissekidaicho.KeikakuHiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.jukyushakyufujissekidaicho.KihonEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.jukyushakyufujissekidaicho.KinkyuuziShisetuRyouyouEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.jukyushakyufujissekidaicho.MeisaiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.jukyushakyufujissekidaicho.ShakaiHukushiHouzinKeigenEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.jukyushakyufujissekidaicho.ShoteiShikkanEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.jukyushakyufujissekidaicho.ShuukeiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.jukyushakyufujissekidaicho.TokuteiServiceHiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.jukyushakyufujissekidaicho.TokuteiShinryouHiEntity;

/**
 * 受給者給付実績台帳インタフェースクラスです。。
 *
 * @reamsid_L DBC-3080-030 dongyabin
 */
public interface IJukyushaTmpMapper {

    /**
     * 基本取得です。
     *
     * @return List<KihonEntity>
     */
    List<KihonEntity> get基本();

    /**
     * 明細取得です。
     *
     * @return List<MeisaiEntity>
     */
    List<MeisaiEntity> get明細();

    /**
     * 緊急時施設療養取得です。
     *
     * @return List<KinkyuuziShisetuRyouyouEntity>
     */
    List<KinkyuuziShisetuRyouyouEntity> get施設療養();

    /**
     * 特定診療費・特別療養費取得です。
     *
     * @return List<TokuteiShinryouHiEntity>
     */
    List<TokuteiShinryouHiEntity> get特別療養();

    /**
     * 計画費取得です。
     *
     * @return List<KeikakuHiEntity>
     */
    List<KeikakuHiEntity> get計画費();

    /**
     * 福祉用具取得です。
     *
     * @return List<HukushiYouguEntity>
     */
    List<HukushiYouguEntity> get福祉用具();

    /**
     * 住宅改修取得です。
     *
     * @return List<JuutakuKaishuuEntity>
     */
    List<JuutakuKaishuuEntity> get住宅改修();

    /**
     * 特定入所者介護サービス費用取得です。
     *
     * @return List<TokuteiServiceHiEntity>
     */
    List<TokuteiServiceHiEntity> get特定入所者介護サービス費用();

    /**
     * 社会福祉法人軽減額取得です。
     *
     * @return List<ShakaiHukushiHouzinKeigenEntity>
     */
    List<ShakaiHukushiHouzinKeigenEntity> get社会福祉法人軽減額();

    /**
     * ケアマネジメント費取得です。
     *
     * @return List<CareManagementEntity>
     */
    List<CareManagementEntity> getケアマネジメント費();

    /**
     * 所定疾患施設療養費取得です。
     *
     * @return List<ShoteiShikkanEntity>
     */
    List<ShoteiShikkanEntity> get所定疾患施設療養費();

    /**
     * 集計取得です。
     *
     * @return List<ShuukeiEntity>
     */
    List<ShuukeiEntity> get集計();

    /**
     * 給付実績高額取得です。
     *
     * @return List<KihonEntity>
     */
    List<KihonEntity> get給付実績高額();
}
