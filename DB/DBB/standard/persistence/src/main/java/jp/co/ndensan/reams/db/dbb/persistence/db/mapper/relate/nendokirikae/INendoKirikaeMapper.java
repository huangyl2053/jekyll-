/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.persistence.db.mapper.relate.nendokirikae;

import java.util.List;
import jp.co.ndensan.reams.db.dbb.definition.mybatisprm.nendokirikae.NendoKirikaeMybatisParameter;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbV2001ChoshuHohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7022ShoriDateKanriEntity;
import jp.co.ndensan.reams.uz.uza.util.config.entity.UzT0001StandardConfigEntity;

/**
 * 年度切替バッチのmapperのクラスです。
 *
 * @reamsid_L DBB-5722-030 xuhao
 */
public interface INendoKirikaeMapper {

    /**
     * 処理日付管理マスタを取得
     *
     * @param parameter NendoKirikaeMybatisParameter
     * @return 処理日付管理マスタList
     */
    List<DbT7022ShoriDateKanriEntity> select処理日付管理マスタ(NendoKirikaeMybatisParameter parameter);

    /**
     * 徴収方法Newestを取得
     *
     * @param parameter NendoKirikaeMybatisParameter
     * @return 徴収方法NewestList
     */
    List<DbV2001ChoshuHohoEntity> select徴収方法Newest(NendoKirikaeMybatisParameter parameter);

    /**
     * 業務コンフィグを取得
     *
     * @return 業務コンフィグList
     */
    List<UzT0001StandardConfigEntity> select業務コンフィグ();

    /**
     * 処理日付管理マスタを取得
     *
     * @param parameter NendoKirikaeMybatisParameter
     * @return 処理日付管理マスタList
     */
    List<DbT7022ShoriDateKanriEntity> select処理日付管理マスタ更新(NendoKirikaeMybatisParameter parameter);
}
