/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.mapper.basic;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3104KokuhorenInterfaceKanriEntity;

/**
 * {@link jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3104KokuhorenInterfaceKanriEntity}のマッパーIFです。
 *
 * @author n1070 久保裕是
 */
public interface IDbT3104KokuhorenInterfaceKanriMapper {

    /**
     * 国保連連携スケジュール設定のスケジュール履歴情報初期_送付取得返します。
     *
     * @return List<DbT3104KokuhorenInterfaceKanriEntity>
     */
    List<DbT3104KokuhorenInterfaceKanriEntity> getスケジュール履歴情報初期_送付();

    /**
     * 国保連連携スケジュール設定のスケジュール履歴情報初期_取込取得返します。
     *
     * @return List<DbT3104KokuhorenInterfaceKanriEntity>
     */
    List<DbT3104KokuhorenInterfaceKanriEntity> getスケジュール履歴情報初期_取込();
}
