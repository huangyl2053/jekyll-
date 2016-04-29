/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.syokanbaraihishikyushinseikette;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.syokanbaraihishikyushinseikette.KyufujissekiKihonParameter;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.syokanbaraihishikyushinseikette.ShafukukeigenServiceParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.syokanbaraihishikyushinseikette.KyufujissekiKihonEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.syokanbaraihishikyushinseikette.ShafukukeigenServiceEntity;

/**
 * 社福軽減額サービス種類のマッパーインタフェースです。
 *
 * @reamsid_L DBC-1030-200 xicongwang
 */
public interface ISyokanbaraihiShikyuShinseiKetteMapper {

    /**
     * 社福軽減額サービス種類情報取得メソッドです。
     *
     * @param parameter parameter
     * @return List<ShafukukeigenServiceEntity>
     */
    List<ShafukukeigenServiceEntity> get社福軽減額サービス種類(ShafukukeigenServiceParameter parameter);

    /**
     * 給付実績基本情報リスト取得メソッドです。
     *
     * @param parameter parameter
     * @return List<KyufujissekiKihonEntity>
     */
    List<KyufujissekiKihonEntity> get給付実績基本情報(KyufujissekiKihonParameter parameter);
}
