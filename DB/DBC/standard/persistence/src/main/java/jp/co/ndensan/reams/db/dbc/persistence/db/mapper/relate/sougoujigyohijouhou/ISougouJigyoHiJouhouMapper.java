/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.sougoujigyohijouhou;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.sougoujigyohijouhou.SougouJigyoHiJouhouParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.sougoujigyohijouhou.SougouJigyoHiJouhouEntity;

/**
 * 汎用リスト出力(総合事業費情報)のMapperです。
 *
 * @reamsid_L DBC-3107-010 wanghuafeng
 */
public interface ISougouJigyoHiJouhouMapper {

    /**
     * サービス種類データを取得します。
     *
     * @param parameter SougouJigyoHiJouhouParameter
     * @return List<SogojigyoShuruiEntity>
     */
    List<SougouJigyoHiJouhouEntity> getサービス種類(SougouJigyoHiJouhouParameter parameter);

}
