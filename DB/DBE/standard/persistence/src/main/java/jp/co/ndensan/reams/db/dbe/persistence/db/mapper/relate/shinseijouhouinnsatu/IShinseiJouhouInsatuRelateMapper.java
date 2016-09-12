package jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.shinseijouhouinnsatu;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.shinseijouhouinnsatu.ShinseiJouhouInsatuMybatisParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shinseimonitor.ShinseiMonitorEntity;

/**
 * 申請情報印刷のマッパーインタフェースです。
 *
 * @reamsid_L DBE-1390-020 suguangjun
 */
public interface IShinseiJouhouInsatuRelateMapper {

    /**
     * 申請情報を取得します。
     *
     * @param parameter 申請情報印刷のパラメータ
     * @return List<ShinseiMonitorEntity>
     */
    List<ShinseiMonitorEntity> selectShinseiJouhou(ShinseiJouhouInsatuMybatisParameter parameter);

}
