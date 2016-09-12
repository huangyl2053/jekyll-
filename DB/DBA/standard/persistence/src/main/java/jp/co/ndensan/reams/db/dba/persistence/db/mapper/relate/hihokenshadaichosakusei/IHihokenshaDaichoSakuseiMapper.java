/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.persistence.db.mapper.relate.hihokenshadaichosakusei;

import java.util.List;
import jp.co.ndensan.reams.db.dba.definition.mybatisprm.hihokenshadaichosakusei.HihokenshaDaichoSakuseiParameter;
import jp.co.ndensan.reams.db.dba.entity.db.relate.hihokenshadaichosakusei.ShisetsuNyutaishoEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7060KaigoJigyoshaEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1001HihokenshaDaichoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1004ShisetsuNyutaishoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1005KaigoJogaiTokureiTaishoShisetsuEntity;

/**
 * 被保険者台帳のマッパーインタフェースです。
 *
 * @reamsid_L DBA-0500-010 suguangjun
 */
public interface IHihokenshaDaichoSakuseiMapper {

    /**
     * ShisetsuNyutaishoEntity 入所施設のエンティティ
     *
     * @param parameter 被保険者台帳パラメータ
     * @return ShisetsuNyutaishoEntity 検索結果の{@link ShisetsuNyutaishoEntity}
     */
    DbT1004ShisetsuNyutaishoEntity getShisetsuNyutaisho(HihokenshaDaichoSakuseiParameter parameter);

    /**
     * DbT7060KaigoJigyoshaEntity 介護事業者テーブルのエンティティ
     *
     * @param parameter 被保険者台帳パラメータ
     * @return DbT7060KaigoJigyoshaEntity 検索結果の{@link DbT7060KaigoJigyoshaEntity}
     */
    DbT1005KaigoJogaiTokureiTaishoShisetsuEntity getKaigoJogaiTokureiTaisho(HihokenshaDaichoSakuseiParameter parameter);

    /**
     * DbT7060KaigoJigyoshaEntity 介護事業者テーブルのエンティティ
     *
     * @param parameter 被保険者台帳パラメータ
     * @return DbT7060KaigoJigyoshaEntity 検索結果の{@link DbT7060KaigoJigyoshaEntity}
     */
    DbT7060KaigoJigyoshaEntity getKaigoJigyosha(HihokenshaDaichoSakuseiParameter parameter);

    /**
     * ShisetsuNyutaishoEntity 入所施設のエンティティ
     *
     * @param parameter 被保険者台帳パラメータ
     * @return ShisetsuNyutaishoEntity 検索結果の{@link ShisetsuNyutaishoEntity}
     */
    List<ShisetsuNyutaishoEntity> getSeikatsuHogoJukyusha(HihokenshaDaichoSakuseiParameter parameter);

    /**
     * DbT1001HihokenshaDaichoEntity 被保険者台帳管理情報のエンティティ
     *
     * @param parameter 被保険者台帳パラメータ
     * @return DbT1001HihokenshaDaichoEntity 検索結果の{@link DbT1001HihokenshaDaichoEntity}
     */
    List<DbT1001HihokenshaDaichoEntity> getHihokenshaDaicho(HihokenshaDaichoSakuseiParameter parameter);
}
