package jp.co.ndensan.reams.db.dba.persistence.db.mapper.relate.hihokenshadaicho;

import java.util.List;
import jp.co.ndensan.reams.db.dba.definition.mybatisprm.hihokenshadaicho.IkkatsuSakuseiMybatisParameter;
import jp.co.ndensan.reams.db.dba.entity.db.relate.hihokenshadaichosakusei.ShisetsuNyutaishoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1001HihokenshaDaichoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7006RoreiFukushiNenkinJukyushaEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7037ShoKofuKaishuEntity;

/**
 *
 * 被保険者台帳一括作成のマッパーインタフェースです。
 *
 * @reamsid_L DBA-0510-010 duanzhanli
 *
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
     * @return {@link ShisetsuNyutaishoEntity}
     */
    List<ShisetsuNyutaishoEntity> get生活保護受給者();

    /**
     * 老齢福祉年金受給者テーブルの情報を取得します。
     *
     * @return {@link DbT7006RoreiFukushiNenkinJukyushaEntity}
     */
    List<DbT7006RoreiFukushiNenkinJukyushaEntity> get老齢福祉年金受給者();

    /**
     * 証交付回収テーブルの情報を取得します。
     *
     * @return {@link DbT7037ShoKofuKaishuEntity}
     */
    List<DbT7037ShoKofuKaishuEntity> get証交付回収();

}
