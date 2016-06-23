/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.db.mapper.relate.hihokenshoshikakushohakko;

import java.util.List;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.core.hihokenshoshikakushohakko.HihokenshoShikakushoHakkoMapperParameter;
import jp.co.ndensan.reams.db.dbz.entity.db.relate.hihokenshoshikakushohakko.HihokenshoShikakushoHakkoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.relate.hihokenshoshikakushohakko.KyotakuKeikakuTodokedeEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.relate.hihokenshoshikakushohakko.ServiceTypeListEntity;

/**
 * 被保険者証資格証発行情報取得。
 *
 * @reamsid_L DBA-1090-021 huangh
 */
public interface IHihokenshoShikakushoHakkoMapper {

    /**
     * 被保険者証資格証発行情報取得します。
     *
     * @param parameter HihokenshoShikakushoHakkoMapperParameter
     * @return HihokenshoShikakushoHakkoEntity
     */
    HihokenshoShikakushoHakkoEntity 被保険者証資格証発行情報取得(HihokenshoShikakushoHakkoMapperParameter parameter);

    /**
     * 限度額データ取得します。
     *
     * @param parameter HihokenshoShikakushoHakkoMapperParameter
     * @return List<ServiceTypeListEntity>
     */
    List<ServiceTypeListEntity> 限度額データ取得(HihokenshoShikakushoHakkoMapperParameter parameter);

    /**
     * 居宅給付計画届出情報取得します。
     *
     * @param 被保険者番号 HihokenshaNo
     * @return List<KyotakuKeikakuTodokedeEntity>
     */
    List<KyotakuKeikakuTodokedeEntity> 居宅給付計画届出情報取得(HihokenshaNo 被保険者番号);
}
