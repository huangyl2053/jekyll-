/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.dbc120920;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.kokuhorenkyoutsuu.KokuhorenIchiranhyoMybatisParameter;
import jp.co.ndensan.reams.db.dbc.entity.csv.dbc120920.SogojigyohiShinsaKetteiSeikyumeisaiInEntity;

/**
 * 総合事業費審査決定請求明細表情報取込のMapperです。
 *
 * @reamsid_L DBC-2500-012 jiangxiaolong
 */
public interface ISogojigyohiShinsaKetteiSeikyumeisaiInDoIchiranhyoSakuseiMapper {

    /**
     * 帳票出力対象データを取得する。
     *
     * @param parameter KokuhorenIchiranhyoMybatisParameter
     * @return List<KagoKetteiKohifutanshaInItem>
     */
    List<SogojigyohiShinsaKetteiSeikyumeisaiInEntity> get帳票出力対象データ(KokuhorenIchiranhyoMybatisParameter parameter);
}
