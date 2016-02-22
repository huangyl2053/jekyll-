/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.persistence.mapper.tokuteifutangendogakushinseisho;

import jp.co.ndensan.reams.db.dba.definition.core.tokuteifutangendogakushinseisho.PsmTokuteifutanGendogakudoMybatisParameter;
import jp.co.ndensan.reams.db.dba.definition.core.tokuteifutangendogakushinseisho.TokuteifutanGendogakuShinseishoMybatisParameter;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1001HihokenshaDaichoEntity;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * 申請書_共通クラス部分Mapperクラスです。
 */
public interface ITokuteifutanGendogakuShinseishoMapper {

    /**
     * 最新異動日データの取得処理です。
     *
     * @param parameter 申請書_共通クラス部分パラメータ。
     * @return DbT1001HihokenshaDaichoEntity 被保険者台帳管理
     */
    DbT1001HihokenshaDaichoEntity get最新異動日データ(TokuteifutanGendogakuShinseishoMybatisParameter parameter);

    /**
     * 宛名識別対象を取得します。
     *
     * @param parameter 宛名識別対象PSM用パラメータ
     * @return UaFt200FindShikibetsuTaishoEntity
     */
    UaFt200FindShikibetsuTaishoEntity getPsm(PsmTokuteifutanGendogakudoMybatisParameter parameter);

    /**
     * 保険者名称を取得します。
     *
     * @param 証記載保険者番号 証記載保険者番号
     * @return 保険者名称
     */
    RString get保険者名称(HokenshaNo 証記載保険者番号);
}
