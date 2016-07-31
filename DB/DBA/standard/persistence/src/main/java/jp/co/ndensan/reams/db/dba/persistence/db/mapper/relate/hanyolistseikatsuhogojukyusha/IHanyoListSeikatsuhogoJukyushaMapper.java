/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.persistence.db.mapper.relate.hanyolistseikatsuhogojukyusha;

import java.util.List;
import jp.co.ndensan.reams.db.dba.definition.mybatisprm.hanyolistseikatsuhogojukyusha.SeikatsuhogoJukyushaMybatisParameter;
import jp.co.ndensan.reams.db.dba.entity.db.relate.hanyolistseikatsuhogojukyusha.SeikatsuhogoJukyushaRelateEntity;

/**
 * 汎用リスト_生活保護受給者のマッパーインタフェースです。
 *
 * @reamsid_L DBA-1580-030 xuyannan
 */
public interface IHanyoListSeikatsuhogoJukyushaMapper {

    /**
     * 生活保護受給者情報を取得します。
     *
     * @param parameter パラメータク
     * @return List<SeikatsuhogoJukyushaMybatisParameter>
     */
    List<SeikatsuhogoJukyushaRelateEntity> getSeikatsuHogoJukyusha(SeikatsuhogoJukyushaMybatisParameter parameter);
}
