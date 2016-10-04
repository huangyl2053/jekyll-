/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.nenreikaikyuriyojokyo;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.nenreikaikyuriyojokyo.NenreikaikyuRiyojokyoMybatisParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.nenreikaikyuriyojokyo.NenreikaikyuRiyojokyoRelateEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.nenreikaikyuriyojokyo.SyorikekkatempTblEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.nenreikaikyuriyojokyo.TmpKyufujissekiRelateEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.nenreikaikyuriyojokyo.TmpSyuturyokuYoRelateEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.nenreikaikyuriyojokyo.UpdateParameterEntity;

/**
 *
 * 年齢階級別利用状況作成インタフェースクラスです。
 *
 * @reamsid_L DBC-3470-030 xuyongchao
 */
public interface INenreikaikyuRiyojokyoMapper {

    /**
     * 給付実績居宅サービス計画費データ取得
     *
     * @param parameter NenreikaikyuRiyojokyoMybatisParameter
     * @return List<NenreikaikyuRiyojokyoRelateEntity>
     */
    List<NenreikaikyuRiyojokyoRelateEntity> getKyufujissekiKyotaku(NenreikaikyuRiyojokyoMybatisParameter parameter);

    /**
     * 給付実績集計データ取得
     *
     * @param parameter NenreikaikyuRiyojokyoMybatisParameter
     * @return List<NenreikaikyuRiyojokyoRelateEntity>
     */
    List<NenreikaikyuRiyojokyoRelateEntity> getKyufujissekiShukei(NenreikaikyuRiyojokyoMybatisParameter parameter);

    /**
     * 給付実績データ取得処理
     *
     * @return List<NenreikaikyuRiyojokyoRelateEntity>
     */
    List<TmpKyufujissekiRelateEntity> getKyufujissekiTemp();

    /**
     * get処理結果確認リスト
     *
     * @return List<SyorikekkatempTblEntity>
     */
    List<SyorikekkatempTblEntity> get処理結果確認リスト作成();

    /**
     * get出力用一時TBL
     *
     * @return List<SyorikekkatempTblEntity>
     */
    List<TmpSyuturyokuYoRelateEntity> get出力用一時TBL();

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
    void update出力用一時TBL(UpdateParameterEntity entity);
}
