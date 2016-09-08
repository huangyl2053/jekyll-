/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.dbc120160;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.kokuhorenkyoutsuu.KokuhorenIchiranhyoMybatisParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc120160.KagoKetteiHokenshaChohyoEntity;

/**
 * 過誤決定通知書情報取込一覧表（保険者分）帳票出力対象データ取得
 *
 * @reamsid_L DBC-0980-300 zhangrui
 */
public interface IKagoKetteiHokenshaChohyoMapper {

    /**
     * 帳票出力対象データを取得する。
     *
     * @param parameter KokuhorenIchiranhyoMybatisParameter
     * @return List<KagoKetteiHokenshaChohyoEntity>
     */
    List<KagoKetteiHokenshaChohyoEntity> get帳票出力対象データ(KokuhorenIchiranhyoMybatisParameter parameter);

}
