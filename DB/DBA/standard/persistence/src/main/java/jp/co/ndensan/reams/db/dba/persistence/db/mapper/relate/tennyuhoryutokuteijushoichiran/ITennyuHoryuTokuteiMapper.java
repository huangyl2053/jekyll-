/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.persistence.db.mapper.relate.tennyuhoryutokuteijushoichiran;

import java.util.List;
import jp.co.ndensan.reams.db.dba.entity.db.relate.tennyuhoryutokuteijushoichiran.TennyuHoryuTokuteiEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7023RendoHoryuTokuteiJushoEntity;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 転入保留特定住所登録のMapperクラスです。
 *
 * @reamsid_L DBA-0480-020 zhangzhiming
 */
public interface ITennyuHoryuTokuteiMapper {

    /**
     * 転入保留特定住所一覧のデータを取得します。
     *
     * @return List<TennyuHoryuTokuteiEntity>
     */
    List<TennyuHoryuTokuteiEntity> getTennyuHoryuTokuteiJushoIchiran();

    /**
     * 転入保留特定住所一覧のデータを取得します。
     *
     * @return List<DbT7023RendoHoryuTokuteiJushoEntity>
     */
    List<DbT7023RendoHoryuTokuteiJushoEntity> get連動保留特定住所();

    /**
     * 管理番号を取得します。
     *
     * @return 管理番号
     */
    RString getKanriNo();
}
