/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.jigyobunshikyugakukeisankekkarenrakuhyo;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.jigyobunshikyugakukeisankkarenrakuhyopanel.JigyobunShikyugakuPanelListParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.jigyobunshikyugakukeisankkarenrakuhyopanel.JigyobunShikyugakuKeisanPanelEntity;

/**
 * 事業高額合算・事業分支給額計算結果連絡票（単）のマッパーインタフェースです。
 *
 * @reamsid_L DBC-4840-010 lihang
 */
public interface IJigyobunShikyugakuKeisanPanelMapper {

    /**
     *
     * 対象データを取得します
     *
     * @param parameter JigyobunShikyugakuPanelListParameter
     * @return List<JigyobunShikyugakuKeisanPanelEntity>
     */
    List<JigyobunShikyugakuKeisanPanelEntity> get対象データ(JigyobunShikyugakuPanelListParameter parameter);

    /**
     *
     * 処理対象のデータを取得します
     *
     * @param parameter JigyobunShikyugakuPanelListParameter
     * @return List<JigyobunShikyugakuKeisanPanelEntity>
     */
    List<JigyobunShikyugakuKeisanPanelEntity> get処理対象データ(JigyobunShikyugakuPanelListParameter parameter);
}
