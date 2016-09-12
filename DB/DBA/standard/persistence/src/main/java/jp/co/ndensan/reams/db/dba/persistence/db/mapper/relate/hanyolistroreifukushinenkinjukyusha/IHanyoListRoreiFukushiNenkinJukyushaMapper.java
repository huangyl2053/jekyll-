/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.persistence.db.mapper.relate.hanyolistroreifukushinenkinjukyusha;

import java.util.List;
import jp.co.ndensan.reams.db.dba.definition.mybatisprm.hanyolistroreifukushinenkinjukyusha.HanyoListRoreiFukushiNenkinJukyushaMybatisParameter;
import jp.co.ndensan.reams.db.dba.entity.db.relate.hanyolistroreifukushinenkinjukyusha.HanyoListRoreiFukushiNenkinJukyushaRelateEntity;

/**
 * 汎用リスト_老齢福祉年金受給者のマッパーインタフェースです。
 *
 * @reamsid_L DBA-1620-030 yaodongsheng
 */
public interface IHanyoListRoreiFukushiNenkinJukyushaMapper {

    /**
     * 老齢福祉年金受給者情報を取得します。
     *
     * @param parameter パラメータク
     * @return List<HanyoListRoreiFukushiNenkinJukyushaMybatisParameter>
     */
    List<HanyoListRoreiFukushiNenkinJukyushaRelateEntity> getRoreiFukushiNenkinJukyusha(
            HanyoListRoreiFukushiNenkinJukyushaMybatisParameter parameter);
}
