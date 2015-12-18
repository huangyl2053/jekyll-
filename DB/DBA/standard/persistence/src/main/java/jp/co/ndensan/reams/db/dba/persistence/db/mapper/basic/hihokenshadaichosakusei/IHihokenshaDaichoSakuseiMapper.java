/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.persistence.db.mapper.basic.hihokenshadaichosakusei;

import jp.co.ndensan.reams.db.dba.definition.mybatis.param.hihokenshadaichosakusei.HihokenshaDaichoSakuseiParameter;
import jp.co.ndensan.reams.db.dba.entity.db.hihokenshadaichosakusei.ShisetsuNyutaishoEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.kaigojigyosha.DbT7060KaigoJigyoshaEntity;

/**
 * 被保険者台帳のマッパーインタフェースです。
 *
 */
public interface IHihokenshaDaichoSakuseiMapper {

    /**
     * ShisetsuNyutaishoEntity 入所施設のエンティティ
     *
     * @param parameter 被保険者台帳パラメータ
     * @return ShisetsuNyutaishoEntity 検索結果の{@link ShisetsuNyutaishoEntity}
     */
    ShisetsuNyutaishoEntity getShisetsuNyutaisho(HihokenshaDaichoSakuseiParameter parameter);

    /**
     * DbT7060KaigoJigyoshaEntity 介護事業者テーブルのエンティティ
     *
     * @param parameter 被保険者台帳パラメータ
     * @return DbT7060KaigoJigyoshaEntity 検索結果の{@link DbT7060KaigoJigyoshaEntity}
     */
    DbT7060KaigoJigyoshaEntity getKaigoJigyosha(HihokenshaDaichoSakuseiParameter parameter);
}
