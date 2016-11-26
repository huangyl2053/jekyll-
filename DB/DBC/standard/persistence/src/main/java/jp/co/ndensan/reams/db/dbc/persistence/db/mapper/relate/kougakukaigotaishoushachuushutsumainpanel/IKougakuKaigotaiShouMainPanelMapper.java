/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.kougakukaigotaishoushachuushutsumainpanel;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.kougakukaigotaishoumainpanel.KougakuKaigotaiShouMainPanelMapperParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3104KokuhorenInterfaceKanriEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7022ShoriDateKanriEntity;

/**
 *
 * 画面設計_DBCMN41003_高額介護対象者抽出（遡及分）のマッパーインタフェースです。
 *
 * @reamsid_L DBC-5750-010 zhengsongling
 */
public interface IKougakuKaigotaiShouMainPanelMapper {

    /**
     * 処理日付管理マスタ情報取得します。
     *
     * @param param param
     * @return DbT7022ShoriDateKanriEntity 審処理日付管理マスタ情報RelateEntityクラスです。
     */
    List<DbT7022ShoriDateKanriEntity> get処理日付管理(KougakuKaigotaiShouMainPanelMapperParameter param);

    /**
     * 国保連インターフェース管理情報取得します。
     *
     * @param param param
     * @return DbT7022ShoriDateKanriEntity 国保連インターフェース管理情報RelateEntityクラスです。
     */
    List<DbT3104KokuhorenInterfaceKanriEntity> get国保連インターフェース管理(KougakuKaigotaiShouMainPanelMapperParameter param);
}
