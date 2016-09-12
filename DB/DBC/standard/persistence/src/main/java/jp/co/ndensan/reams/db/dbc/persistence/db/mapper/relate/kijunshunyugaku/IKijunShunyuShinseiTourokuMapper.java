/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.kijunshunyugaku;

import java.util.Map;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1001HihokenshaDaichoEntity;

/**
 * 基準収入額適用申請登録mapperクラスです。
 *
 * @reamsid_L DBC-4620-010 wangkanglei
 */
public interface IKijunShunyuShinseiTourokuMapper {

    /**
     * 被保険者番号に一致する最新のレコードを取得のメソッドです。
     *
     * @param parameter Map
     * @return 被保険者台帳管理
     */
    DbT1001HihokenshaDaichoEntity get被保険者台帳(Map<String, Object> parameter);
}
