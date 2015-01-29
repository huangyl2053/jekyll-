/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.mappers;

import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbc.entity.basic.DbTKyufukanrihyoDataTempTableEntity;

/**
 *
 * 給付管理票取込一時データエンティティのマッパーインタフェースです。
 *
 * @author N8156 宮本 康
 */
public interface IKyufukanrihyoDataTempTableMapper {

    /**
     * 被保険者番号変更用市町村コードを更新します。<br />
     * チェック1
     *
     * @param param パラメーター
     */
    void updateHihoNoHenkanShichosonCode1(Map<String, Object> param);

    /**
     * 被保険者番号変更用市町村コードを更新します。<br />
     * チェック2
     *
     * @param param パラメーター
     */
    void updateHihoNoHenkanShichosonCode2(Map<String, Object> param);

    /**
     * 被保険者番号変更用市町村コードを更新します。<br />
     * チェック3
     *
     * @param param パラメーター
     */
    void updateHihoNoHenkanShichosonCode3(Map<String, Object> param);

    /**
     * 被保険者番号変更用市町村コードを更新します。<br />
     * チェック4
     *
     * @param param パラメーター
     */
    void updateHihoNoHenkanShichosonCode4(Map<String, Object> param);

    /**
     * 新被保険者番号を更新します。<br />
     * 新旧被保険者番号変換テーブルからの付与
     *
     * @param param パラメーター
     */
    void updateShinHihokenshaNo1(Map<String, Object> param);

    /**
     * 新被保険者番号を更新します。<br />
     * 一時テーブル上の被保険者番号をそのまま付与
     *
     * @param param パラメーター
     */
    void updateShinHihokenshaNo2(Map<String, Object> param);

    /**
     * 事業所名称を更新します。<br />
     * 居宅介護支援事業者名称の取得更新
     *
     * @param param パラメーター
     */
    void updateJigyoshoMeisho1(Map<String, Object> param);

    /**
     * 事業所名称を更新します。<br />
     * 居宅介護支援事業者名称が取得できなかったデータの初期化
     *
     * @param param パラメーター
     */
    void updateJigyoshoMeisho2(Map<String, Object> param);

    /**
     * 識別コードを更新します。<br />
     * 被保険者台帳最新Viewの識別コードを設定
     *
     * @param param パラメーター
     */
    void updateShikibetsuCode1(Map<String, Object> param);

    /**
     * 識別コードを更新します。<br />
     * 識別コードが取得できなかったデータの識別コードを初期化
     *
     * @param param パラメーター
     */
    void updateShikibetsuCode2(Map<String, Object> param);

    /**
     * 漢字氏名を更新します。
     *
     * @param param パラメーター
     */
    void updateKanjiMeisho(Map<String, Object> param);

    /**
     * 市町村コードを更新します。<br />
     * 被保険者台帳最新Viewの市町村コードを設定
     *
     * @param param パラメーター
     */
    void updateShichosonCode1(Map<String, Object> param);

    /**
     * 市町村コードを更新します。<br />
     * 市町村コードが取得できなかったデータの市町村コードを初期化
     *
     * @param param パラメーター
     */
    void updateShichosonCode2(Map<String, Object> param);

    /**
     * 一時データを取得します。
     *
     * @param param パラメーター
     * @return DbTKyufukanrihyoDataTempTableEntity
     */
    List<DbTKyufukanrihyoDataTempTableEntity> getTempData(Map<String, Object> param);

	//select
    List<DbTKyufukanrihyoDataTempTableEntity> selectAll();
}
