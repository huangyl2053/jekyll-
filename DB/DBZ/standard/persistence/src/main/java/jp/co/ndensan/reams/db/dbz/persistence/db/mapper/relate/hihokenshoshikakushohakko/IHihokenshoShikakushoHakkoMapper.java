/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.db.mapper.relate.hihokenshoshikakushohakko;

import java.util.List;
import jp.co.ndensan.reams.db.dbz.definition.core.hihokenshoshikakushohakko.HihokenshoShikakushoHakkoMapperParameter;
import jp.co.ndensan.reams.db.dbz.entity.db.hihokenshoshikakushohakko.HihokenshoShikakushoHakkoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.hihokenshoshikakushohakko.KaigoHokenShisetsuNyutaishoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.hihokenshoshikakushohakko.KyotakuKeikakuTodokedeEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.hihokenshoshikakushohakko.ShiharaiHohoHenkoEntity;

/**
 * 被保険者証資格証発行情報取得。
 *
 */
public interface IHihokenshoShikakushoHakkoMapper {

    HihokenshoShikakushoHakkoEntity 被保険者証資格証発行情報取得(HihokenshoShikakushoHakkoMapperParameter parameter);

    HihokenshoShikakushoHakkoEntity 限度額データ取得(HihokenshoShikakushoHakkoMapperParameter parameter);

    List<ShiharaiHohoHenkoEntity> 支払方法変更の情報取得();

    List<KyotakuKeikakuTodokedeEntity> 居宅給付計画届出情報取得();

    List<KaigoHokenShisetsuNyutaishoEntity> 介護保険施設入退所の情報取得();

}
