/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.persistence.db.mapper.relate.hihokenshadaicho;

import java.util.List;
import jp.co.ndensan.reams.db.dba.definition.mybatis.param.hihokenshadaicho.HihokenshaShikakuShutokuMapperParameter;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1001HihokenshaDaichoEntity;

/**
 *
 * 被保険者台帳管理（資格取得）のMapperクラスです。
 *
 * @reamsid_L DBA-0520-010 lishengli
 */
public interface IHihokenshaShikakuShutokuMapper {

    /**
     * 被保険者台帳管理（資格取得）情報を取得します。
     *
     * @param parameter 被保険者台帳管理（資格取得）検索条件
     * @return List<DbT1001HihokenshaDaichoEntity> 被保険者台帳管理テーブルのエンティティリスト
     */
    List<DbT1001HihokenshaDaichoEntity> getHihokenshaShutokuJyoho(HihokenshaShikakuShutokuMapperParameter parameter);

    /**
     * 最大枝番を取得します。
     *
     * @param parameter 被保険者台帳管理のパラメータ
     * @return DbT1001HihokenshaDaichoEntity
     */
    DbT1001HihokenshaDaichoEntity getSaidaiEdaban(HihokenshaShikakuShutokuMapperParameter parameter);

    /**
     * 最新データ情報を取得します。
     *
     * @param parameter 被保険者台帳管理のパラメータ
     * @return DbT1001HihokenshaDaichoEntity
     */
    DbT1001HihokenshaDaichoEntity getSaishinDeta(HihokenshaShikakuShutokuMapperParameter parameter);

}
