/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.persistence.db.mapper.relate.nenreitotatsushikakuido;

import java.util.List;
import jp.co.ndensan.reams.db.dba.definition.mybatisprm.nenreitotatsushikakuido.NenreiIdoHanteiMybatisParameter;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1001HihokenshaDaichoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1002TekiyoJogaishaEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1003TashichosonJushochiTokureiEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1009ShikakuShutokuJogaishaEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1010TennyushutsuHoryuTaishoshaEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7022ShoriDateKanriEntity;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;

/**
 * ６５歳年齢到達資格異動のマッパーインタフェースです。
 *
 * @reamsid_L DBA-0330-010 xuyue
 */
public interface INenreitotatsuShikakuIdoRelateMapper {

    /**
     * 通常運用時（スケジューラ機能による毎朝一日１回の起動）、バッチ内で抽出条件を生成します。
     *
     * @return 処理日付管理マスタテーブルのエンティティ
     */
    DbT7022ShoriDateKanriEntity selectバッチ内で抽出条件();

    /**
     * 被保険者台帳管理By論理削除フラグAnd識別コードを取得します。
     *
     * @param 識別コード 識別コード
     * @return 被保険者台帳管理テーブルのエンティティ
     */
    DbT1001HihokenshaDaichoEntity select被保険者台帳管理By論理削除フラグAnd識別コード(ShikibetsuCode 識別コード);

    /**
     * 他市町村住所地特例のデータを取得します。
     *
     * @param sqlParam 検索パラメータ
     * @return 他市町村住所地特例のデータ
     */
    List<DbT1003TashichosonJushochiTokureiEntity> select他市町村住所地特例(NenreiIdoHanteiMybatisParameter sqlParam);

    /**
     * 適用除外者のデータを取得します。
     *
     * @param sqlParam 検索パラメータ
     * @return 適用除外者のデータ
     */
    List<DbT1002TekiyoJogaishaEntity> select適用除外者(NenreiIdoHanteiMybatisParameter sqlParam);

    /**
     * 資格取得除外者のデータを取得します。
     *
     * @param sqlParam 検索パラメータ
     * @return 資格取得除外者のデータ
     */
    List<DbT1009ShikakuShutokuJogaishaEntity> select資格取得除外者(NenreiIdoHanteiMybatisParameter sqlParam);

    /**
     * 転入保留対象者のデータを取得します。
     *
     * @param sqlParam 検索パラメータ
     * @return 転入保留対象者のデータ
     */
    List<DbT1010TennyushutsuHoryuTaishoshaEntity> select転入保留対象者(NenreiIdoHanteiMybatisParameter sqlParam);

}
