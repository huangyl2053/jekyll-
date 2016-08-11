/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.db.mapper.basic;

import java.util.List;
import jp.co.ndensan.reams.db.dbz.definition.core.kaigojyuminhyokoukiu.KaiGoJuminHyokouKiuParameter;
import jp.co.ndensan.reams.db.dbz.definition.mybatisprm.hihokenshadaicho.HihokenshaDaichoSearchCondition;
import jp.co.ndensan.reams.db.dbz.definition.mybatisprm.juminidorendotennyu.JuminIdoRendoTennyuMybatisprm;
import jp.co.ndensan.reams.db.dbz.definition.mybatisprm.juminidorendotennyu.JuminIdoRendoTennyuParameter;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1001HihokenshaDaichoEntity;

/**
 *
 * @reamsid_L DBB-0630-020 chengsanyuan
 */
public interface IDbT1001HihokenshaDaichoMapper {

    /**
     * {@link DbT1001HihokenshaDaichoEntity}を取得します。
     *
     * @return {@link DbT1001HihokenshaDaichoEntity}
     * @deprecated マッピング検証用のメソッドであるため、テストコード以外から使用しないで下さい。
     */
    DbT1001HihokenshaDaichoEntity getEntity();

    /**
     *
     * 資格の情報を取得します。
     *
     * @param param HihokenshaDaichoSearchCondition
     * @return List<DbT1001HihokenshaDaichoEntity>
     */
    DbT1001HihokenshaDaichoEntity get資格の情報(HihokenshaDaichoSearchCondition param);

    /**
     *
     * 広域運用識別コード情報の取得処理。
     *
     * @param parameter KaiGoJuminHyokouKiuParameter
     * @return List<DbT1001HihokenshaDaichoEntity>
     */
    List<DbT1001HihokenshaDaichoEntity> ge広域運用識別コード情報の取得処理(KaiGoJuminHyokouKiuParameter parameter);

    /**
     *
     * 広域運用識別コード情報の取得処理。
     *
     * @param parameter KaiGoJuminHyokouKiuParameter
     * @return DbT1001HihokenshaDaichoEntity
     */
    DbT1001HihokenshaDaichoEntity ge直近被保データ(JuminIdoRendoTennyuParameter parameter);

    /**
     *
     * 処理対象者を情報の取得処理。
     *
     * @param parameter JuminIdoRendoTennyuMybatisprm
     * @return List<DbT1001HihokenshaDaichoEntity>
     */
    List<DbT1001HihokenshaDaichoEntity> get処理対象者(JuminIdoRendoTennyuMybatisprm parameter);

}
