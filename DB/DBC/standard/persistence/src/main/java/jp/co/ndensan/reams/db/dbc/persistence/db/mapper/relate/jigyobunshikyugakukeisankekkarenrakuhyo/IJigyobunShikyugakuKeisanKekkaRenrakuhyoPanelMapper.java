/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.jigyobunshikyugakukeisankekkarenrakuhyo;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.jigyobunshikyugakukeisankkarenrakuhyopanel.JigyobunShikyugakuKeisanKekkaRenrakuhyoPanelEntity;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.jigyobunshikyugakukeisankkarenrakuhyopanel.JigyobunShikyugakuKeisanKekkaRenrakuhyoPanelListParameter;

/**
 * 事業高額合算・事業分支給額計算結果連絡票（単）のマッパーインタフェースです。
 *
 * @reamsid_L DBC-4840-010 lihang
 */
public interface IJigyobunShikyugakuKeisanKekkaRenrakuhyoPanelMapper {

    /**
     *
     * 対象データを取得します
     *
     * @param parameter
     * JigyobunShikyugakuKeisanKekkaRenrakuhyoPanelListParameter
     * @return List<JigyobunShikyugakuKeisanKekkaRenrakuhyoPanelEntity>
     */
    List<JigyobunShikyugakuKeisanKekkaRenrakuhyoPanelEntity> get対象データ(JigyobunShikyugakuKeisanKekkaRenrakuhyoPanelListParameter parameter);

    /**
     *
     * 処理対象のデータを取得します
     *
     * @param parameter
     * JigyobunShikyugakuKeisanKekkaRenrakuhyoPanelListParameter
     * @return List<JigyobunShikyugakuKeisanKekkaRenrakuhyoPanelEntity>
     */
    List<JigyobunShikyugakuKeisanKekkaRenrakuhyoPanelEntity> get処理対象データ(JigyobunShikyugakuKeisanKekkaRenrakuhyoPanelListParameter parameter);
}
