/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.persistence.db.mapper.relate.hihokensha.hihokenshadaicho;

import jp.co.ndensan.reams.db.dba.definition.mybatis.param.hihokensha.hihokenshadaicho.HihokenshaDaichoMapperParameter;
import jp.co.ndensan.reams.db.dba.entity.db.relate.hihokensha.hihokenshadaicho.HihokenshaDaichoRelateEntity;

/**
 * 被保険者台帳管理のマッパーインタフェースです。
 */
public interface IHihokenshaDaichoMapper {

    /**
     * 被保険者台帳管理情報をキー検索で１件取得します。
     *
     * @param 被保険者台帳管理検索条件 被保険者台帳管理検索条件
     * @return HihokenshaDaichoEntity
     */
    HihokenshaDaichoRelateEntity select被保険者台帳管理ByKey(HihokenshaDaichoMapperParameter 被保険者台帳管理検索条件);
}
