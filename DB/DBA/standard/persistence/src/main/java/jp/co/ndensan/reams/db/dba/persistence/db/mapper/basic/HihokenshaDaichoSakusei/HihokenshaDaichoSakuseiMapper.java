/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.persistence.db.mapper.basic.HihokenshaDaichoSakusei;

import jp.co.ndensan.reams.db.dba.definition.mybatis.param.hihokenshadaichosakusei.HihokenshaDaichoSakuseiParameter;
import jp.co.ndensan.reams.db.dba.entity.db.HihokenshaDaichoSakusei.ShisetsuNyutaishoEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.kaigojigyosha.DbT7060KaigoJigyoshaEntity;

/**
 *
 * @author soft863
 */
public interface HihokenshaDaichoSakuseiMapper {

    /**
     * ShisetsuNyutaishoEntity。
     *
     * @param parameter
     * @return ShisetsuNyutaishoEntity 検索結果の{@link ShisetsuNyutaishoEntity}
     */
    ShisetsuNyutaishoEntity getShisetsuNyutaisho(HihokenshaDaichoSakuseiParameter parameter);

    /**
     * ShisetsuNyutaishoEntity。
     *
     * @param parameter
     * @return ShisetsuNyutaishoEntity 検索結果の{@link ShisetsuNyutaishoEntity}
     */
    DbT7060KaigoJigyoshaEntity getKaigoJigyosha(HihokenshaDaichoSakuseiParameter parameter);

}
