/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.persistence.mapper.relate.jukyushikakushomeisho;

import jp.co.ndensan.reams.db.dbu.definition.mybatisprm.jukyushikakushomeisho.JukyuShikakuShomeishoMyBatisParameter;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1001HihokenshaDaichoEntity;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;

/**
 *
 * 受給資格証明書データ作成 Mapper
 */
public interface JukyuShikakuShomeishoMapper {

    DbT1001HihokenshaDaichoEntity get被保険者台帳管理情報(HihokenshaNo 被保番号);

    UaFt200FindShikibetsuTaishoEntity get宛名識別対象PSM(JukyuShikakuShomeishoMyBatisParameter searchkey);

}
