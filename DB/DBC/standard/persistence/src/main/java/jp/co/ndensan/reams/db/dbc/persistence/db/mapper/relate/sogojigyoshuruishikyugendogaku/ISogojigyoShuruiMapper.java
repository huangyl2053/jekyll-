/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.sogojigyoshuruishikyugendogaku;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.sogojigyoshuruishikyugendogaku.SogojigyoShuruiEntity;

/**
 * 総合事業種類支給限度額登録のマッパーインタフェースです。
 *
 * @reamsid_L DBC-3364-010 xuxin
 */
public interface ISogojigyoShuruiMapper {

    /**
     * 総合事業種類情報を全件取得します。
     *
     * @return List<SogojigyoShuruiEntity>
     */
    List<SogojigyoShuruiEntity> get総合事業種類情報();
}
