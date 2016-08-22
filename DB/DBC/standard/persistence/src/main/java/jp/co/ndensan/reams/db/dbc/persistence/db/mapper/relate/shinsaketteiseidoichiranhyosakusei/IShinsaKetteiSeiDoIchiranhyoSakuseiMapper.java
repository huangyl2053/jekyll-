/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.shinsaketteiseidoichiranhyosakusei;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.report.kyufuhishinsaketteiseikyumeisaihyo.KyufuhiShinsaKetteiSeikyuMeisaihyoEntity;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.kokuhorenkyoutsuu.KokuhorenIchiranhyoMybatisParameter;

/**
 * 介護給付費等審査決定請求明細表情報取込の一覧表作成を実行のDB操作インターフェースです。。
 *
 * @reamsid_L DBC-2500-010 jiangxiaolong
 */
public interface IShinsaKetteiSeiDoIchiranhyoSakuseiMapper {

    /**
     * 帳票出力対象データを取得する。
     *
     * @param parameter KokuhorenIchiranhyoMybatisParameter
     * @return List<KyufuhiShinsaKetteiSeikyuMeisaihyoEntity>
     */
    List<KyufuhiShinsaKetteiSeikyuMeisaihyoEntity> select帳票出力対象データ(KokuhorenIchiranhyoMybatisParameter parameter);

}
