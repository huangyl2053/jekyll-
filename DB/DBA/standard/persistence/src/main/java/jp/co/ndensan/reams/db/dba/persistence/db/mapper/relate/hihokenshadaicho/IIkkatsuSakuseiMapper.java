package jp.co.ndensan.reams.db.dba.persistence.db.mapper.relate.hihokenshadaicho;

import java.util.List;
import jp.co.ndensan.reams.db.dba.definition.mybatisprm.hihokenshadaicho.IkkatsuSakuseiMybatisParameter;
import jp.co.ndensan.reams.db.dba.entity.db.hihokenshadaichosakusei.HihokenshaEntity;
import jp.co.ndensan.reams.db.dba.entity.db.hihokenshadaichosakusei.ShisetsuNyutaishoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1001HihokenshaDaichoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1008IryohokenKanyuJokyoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7006RoreiFukushiNenkinJukyushaEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7037ShoKofuKaishuEntity;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;

/**
 *
 * 被保険者台帳一括作成のマッパーインタフェースです。
 */
public interface IIkkatsuSakuseiMapper {

    /**
     * 被保険者台帳管理テーブルの情報を取得します。
     *
     * @param 検索条件 検索条件
     * @return {@link DbT1001HihokenshaDaichoEntity}
     */
    List<DbT1001HihokenshaDaichoEntity> get被保険者台帳管理情報(IkkatsuSakuseiMybatisParameter 検索条件);

    /**
     * 生活保護受給者テーブルの情報を取得します。
     *
     * @param 検索条件 検索条件
     * @return {@link ShisetsuNyutaishoEntity}
     */
    List<ShisetsuNyutaishoEntity> get生活保護受給者(IkkatsuSakuseiMybatisParameter 検索条件);

    /**
     * 老齢福祉年金受給者テーブルの情報を取得します。
     *
     * @param 検索条件 検索条件
     * @return {@link DbT7006RoreiFukushiNenkinJukyushaEntity}
     */
    List<DbT7006RoreiFukushiNenkinJukyushaEntity> get老齢福祉年金受給者(IkkatsuSakuseiMybatisParameter 検索条件);

    /**
     * 証交付回収テーブルの情報を取得します。
     *
     * @param 検索条件 検索条件
     * @return {@link DbT7037ShoKofuKaishuEntity}
     */
    List<DbT7037ShoKofuKaishuEntity> get証交付回収(IkkatsuSakuseiMybatisParameter 検索条件);

    /**
     * 市町村名称を取得します。
     *
     * @param 検索条件 検索条件
     * @return {@link HihokenshaEntity}
     */
    HihokenshaEntity get市町村名称(IkkatsuSakuseiMybatisParameter 検索条件);

    /**
     * 宛名識別対象を取得します。
     *
     * @param 検索条件 検索条件
     * @return {@link UaFt200FindShikibetsuTaishoEntity}
     */
    UaFt200FindShikibetsuTaishoEntity get識別対象(IkkatsuSakuseiMybatisParameter 検索条件);

    /**
     * 入所施設情報を取得します。
     *
     * @param 検索条件 検索条件
     * @return {@link ShisetsuNyutaishoEntity}
     */
    ShisetsuNyutaishoEntity get入所施設(IkkatsuSakuseiMybatisParameter 検索条件);

    /**
     * 介護保険医療保険加入状況情報を取得します。
     *
     * @param 検索条件 検索条件
     * @return {@link DbT1008IryohokenKanyuJokyoEntity}
     */
    DbT1008IryohokenKanyuJokyoEntity get介護保険医療保険加入状況(IkkatsuSakuseiMybatisParameter 検索条件);

}
