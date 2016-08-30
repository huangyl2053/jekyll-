/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.kaigokyufuhikagomositatetouroku;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.kaigokyufuhikagomositatetouroku.KaigoKyufuhiParamter;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kaigokyufuhikagomositatetouroku.KaigoKyufuhiKagoMositateTourokuEntity;

/**
 * 介護給付費過誤申立登録（事業分、経過措置分含む）の給付実績一覧検索クラスです。
 *
 * @reamsid_L DBC-2220-030 dongyabin
 */
public interface IKaigoKyufuhiKagoMositateTourokuMapper {

    /**
     * 給付実績一覧検索します。
     *
     * @param param 給付実績一覧検索パラメータ
     * @return List<KaigoKyufuhiKagoMositateTourokuEntity>
     */
    List<KaigoKyufuhiKagoMositateTourokuEntity> get給付実績一覧(KaigoKyufuhiParamter param);
}
