/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.hekinriyogakutokehyo;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.heikinriyogakuyokeihyo.HeikinriyogakuTokeihyoMybatisParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kyufujissekidatatemptbl.KyufujissekiTempTblEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kyufujissekidatatemptbl.ShikakutempTblEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kyufujissekidatatemptbl.ShukeinaiyouEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kyufujissekidatatemptbl.SyorikekkatempTblEntity;

/**
 * 平均利用額統計表作成のマッパーインタフェースです。
 *
 * @reamsid_L DBC-3490-050 yaoyahui
 */
public interface IHekinRiyoGakuTokehyoMapper {

    /**
     * データの取得
     *
     * @param parameter parameter
     * @return KyufujissekiDataTempTblEntityList
     */
    List<KyufujissekiTempTblEntity> get給付実績データ一時(HeikinriyogakuTokeihyoMybatisParameter parameter);

    /**
     * データの取得
     *
     * @return KyufujisDataTempTblEntity
     */
    List<KyufujissekiTempTblEntity> get給付実績データ一時に更新();

    /**
     * get給付実績データ取得処理
     *
     * @return List<KyufujissekiTempTblEntity>
     */
    List<KyufujissekiTempTblEntity> get給付実績データ取得処理();

    /**
     * get処理結果確認リスト
     *
     * @return List<SyorikekkatempTblEntity>
     */
    List<SyorikekkatempTblEntity> get処理結果確認リスト作成();

    /**
     * insert処理結果リスト一時TBL
     *
     * @param entity SyorikekkatempTblEntity
     */
    void insert処理結果リスト一時TBL(SyorikekkatempTblEntity entity);

    /**
     * updateDB出力出力用一時TBL
     *
     * @param entity ShukeinaiyouEntity
     */
    void updateDB出力出力用一時TBL人数(ShukeinaiyouEntity entity);

    /**
     * updateDB出力出力用一時TBL
     *
     * @param entity ShukeinaiyouEntity
     */
    void updateDB出力出力用一時TBL費用総額(ShukeinaiyouEntity entity);

    /**
     *
     * @return ShikakutempTblEntityList
     */
    List<ShikakutempTblEntity> get平均利用額統計Entity();

}
