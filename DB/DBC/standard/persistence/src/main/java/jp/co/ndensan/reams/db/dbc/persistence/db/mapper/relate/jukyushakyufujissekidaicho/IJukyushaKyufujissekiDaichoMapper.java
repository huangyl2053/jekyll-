/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.jukyushakyufujissekidaicho;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.jukyushakyufujissekidaicho.JukyushaKyufujissekiDaichoMybatisParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.jukyushakyufujissekidaicho.CareManagementRelateEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.jukyushakyufujissekidaicho.HukushiYouguRelateEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.jukyushakyufujissekidaicho.JuutakuKaishuuRelateEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.jukyushakyufujissekidaicho.KeikakuHiRelateEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.jukyushakyufujissekidaicho.KihonRelateEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.jukyushakyufujissekidaicho.KinkyuuziShisetuRyouyouRelateEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.jukyushakyufujissekidaicho.KyuuhuZissekiKougakuRelateEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.jukyushakyufujissekidaicho.MeisaiJuushoRelateEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.jukyushakyufujissekidaicho.MeisaiRelateEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.jukyushakyufujissekidaicho.ShakaiHukushiHouzinKeigenRelateEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.jukyushakyufujissekidaicho.ShoteiShikkanRelateEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.jukyushakyufujissekidaicho.ShuukeiRelateEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.jukyushakyufujissekidaicho.TokuteiServiceHiRelateEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.jukyushakyufujissekidaicho.TokuteiShinryouHiRelateEntity;

/**
 * 受給者給付実績台帳インタフェースクラスです。
 *
 * @reamsid_L DBC-3080-030 dongyabin
 */
public interface IJukyushaKyufujissekiDaichoMapper {

    /**
     * 基本取得です
     *
     * @param parameter parameter
     * @return List<KihonRelateEntity>
     */
    List<KihonRelateEntity> get基本(JukyushaKyufujissekiDaichoMybatisParameter parameter);

    /**
     * 明細取得です
     *
     * @param parameter parameter
     * @return List<MeisaiRelateEntity>
     */
    List<MeisaiRelateEntity> get明細(JukyushaKyufujissekiDaichoMybatisParameter parameter);

    /**
     * 緊急時施設療養取得です
     *
     * @param parameter parameter
     * @return List<KinkyuuziShisetuRyouyouRelateEntity>
     */
    List<KinkyuuziShisetuRyouyouRelateEntity> get緊急時施設療養(JukyushaKyufujissekiDaichoMybatisParameter parameter);

    /**
     * 特定診療費・特別療養費取得です
     *
     * @param parameter parameter
     * @return List<TokuteiShinryouHiRelateEntity>
     */
    List<TokuteiShinryouHiRelateEntity> get特定診療費(JukyushaKyufujissekiDaichoMybatisParameter parameter);

    /**
     * 計画費取得です
     *
     * @param parameter parameter
     * @return List<KeikakuHiRelateEntity>
     */
    List<KeikakuHiRelateEntity> get計画費(JukyushaKyufujissekiDaichoMybatisParameter parameter);

    /**
     * 福祉用具取得です
     *
     * @param parameter parameter
     * @return List<HukushiYouguRelateEntity>
     */
    List<HukushiYouguRelateEntity> get福祉用具(JukyushaKyufujissekiDaichoMybatisParameter parameter);

    /**
     * 住宅改修取得です
     *
     * @param parameter parameter
     * @return List<JuutakuKaishuuRelateEntity>
     */
    List<JuutakuKaishuuRelateEntity> get住宅改修(JukyushaKyufujissekiDaichoMybatisParameter parameter);

    /**
     * 特定入所者介護サービス費用取得です
     *
     * @param parameter parameter
     * @return List<TokuteiServiceHiRelateEntity>
     */
    List<TokuteiServiceHiRelateEntity> get特定入所者介護サービス費用(JukyushaKyufujissekiDaichoMybatisParameter parameter);

    /**
     * 社会福祉法人軽減額取得です
     *
     * @param parameter parameter
     * @return List<ShakaiHukushiHouzinKeigenRelateEntity>
     */
    List<ShakaiHukushiHouzinKeigenRelateEntity> get社会福祉法人軽減額(JukyushaKyufujissekiDaichoMybatisParameter parameter);

    /**
     * ケアマネジメント費取得です
     *
     * @param parameter parameter
     * @return List<CareManagementRelateEntity>
     */
    List<CareManagementRelateEntity> getケアマネジメント費(JukyushaKyufujissekiDaichoMybatisParameter parameter);

    /**
     * 所定疾患施設療養費取得です
     *
     * @param parameter parameter
     * @return List<ShoteiShikkanRelateEntity>
     */
    List<ShoteiShikkanRelateEntity> get所定疾患施設療養費(JukyushaKyufujissekiDaichoMybatisParameter parameter);

    /**
     * 明細・住所地特例取得です
     *
     * @param parameter parameter
     * @return List<MeisaiJuushoRelateEntity>
     */
    List<MeisaiJuushoRelateEntity> get明細住所地特例(JukyushaKyufujissekiDaichoMybatisParameter parameter);

    /**
     * 集計取得です
     *
     * @param parameter parameter
     * @return List<ShuukeiRelateEntity>
     */
    List<ShuukeiRelateEntity> get集計(JukyushaKyufujissekiDaichoMybatisParameter parameter);

    /**
     * 給付実績高額取得です
     *
     * @param parameter parameter
     * @return List<KyuuhuZissekiKougakuRelateEntity>
     */
    List<KyuuhuZissekiKougakuRelateEntity> get給付実績高額(JukyushaKyufujissekiDaichoMybatisParameter parameter);

}
