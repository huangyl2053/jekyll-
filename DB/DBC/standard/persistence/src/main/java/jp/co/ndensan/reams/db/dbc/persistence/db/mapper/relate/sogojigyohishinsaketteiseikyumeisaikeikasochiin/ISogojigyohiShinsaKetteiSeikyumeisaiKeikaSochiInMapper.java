/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.sogojigyohishinsaketteiseikyumeisaikeikasochiin;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.kokuhorenkyoutsuu.KokuhorenIchiranhyoMybatisParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.sogojigyohishinsaketteiseikyumeisaihyo.SogojigyohiShinsaKetteiSeikyumeisaihyoEntity;

/**
 * 総合事業費（経過措置）審査決定請求明細表情報取込のバッチのDB操作クラスです
 *
 * @reamsid_L DBC-2500-011 jiangwenkai
 */
public interface ISogojigyohiShinsaKetteiSeikyumeisaiKeikaSochiInMapper {

    /**
     * 総合事業費（経過措置）審査決定請求明細表情報取込の帳票出力対象データを取りメソッドです。
     *
     * @param parameter KokuhorenIchiranhyoMybatisParameter
     * @return List<SogojigyohiShinsaKetteiSeikyumeisaihyoEntity>
     */
    List<SogojigyohiShinsaKetteiSeikyumeisaihyoEntity> get帳票出力対象データ(KokuhorenIchiranhyoMybatisParameter parameter);

}
