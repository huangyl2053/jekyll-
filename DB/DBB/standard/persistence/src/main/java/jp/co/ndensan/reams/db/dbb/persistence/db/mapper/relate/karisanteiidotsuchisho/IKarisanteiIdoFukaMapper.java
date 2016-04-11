/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.persistence.db.mapper.relate.karisanteiidotsuchisho;

import java.util.Map;
import jp.co.ndensan.reams.db.dbb.definition.mybatisprm.karisanteiidotsuchisho.IdoOrZenkenFukaSelectParameter;
import jp.co.ndensan.reams.db.dbb.definition.mybatisprm.karisanteiidotsuchisho.IdofukaJohoTempParameter;
import jp.co.ndensan.reams.db.dbb.definition.mybatisprm.karisanteiidotsuchisho.IdofukaKoseimaeParameter;
import jp.co.ndensan.reams.db.dbb.definition.mybatisprm.karisanteiidotsuchisho.TsuchishoHakkogoIdoshaParameter;

/**
 * ビジネス_仮算定異動通知書一括発行（バッチ）のMapperインタフェースです。
 *
 * @reamsid_L DBB-0890-040 zhangrui
 */
public interface IKarisanteiIdoFukaMapper {

    /**
     * 異動賦課情報一時テーブルのデータをクリアする。
     */
    void delete異動賦課情報一時テーブル();

    /**
     * 賦課異動の更新後データを抽出し、異動賦課情報一時テーブルに登録する。
     *
     * @param parameter 検索条件
     */
    void insert異動賦課情報一時テーブルFROM計算後情報(IdofukaJohoTempParameter parameter);

    /**
     * 賦課異動の更新後データを抽出し、異動賦課情報一時テーブルに登録する。
     *
     * @param parameter 検索条件
     */
    void insert異動賦課情報一時テーブルFROM計算後情報一時(IdofukaJohoTempParameter parameter);

    /**
     * 計算後情報テーブルの更新前後区分が「1：更正前」のデータにより、<br/>
     * 異動賦課情報一時テーブルの「更正前」計算後情報を更新する。
     *
     * @param parameter 更新条件
     */
    void update異動賦課情報一時テーブルFROM計算後情報(IdofukaKoseimaeParameter parameter);

    /**
     * 計算後情報一時テーブルの更新前後区分が「1：更正前」のデータにより、<br/>
     * 異動賦課情報一時テーブルの「更正前」計算後情報を更新する。
     *
     * @param parameter 更新条件
     */
    void update異動賦課情報一時テーブルFROM計算後情報一時(IdofukaKoseimaeParameter parameter);

    /**
     * 異動賦課情報一時テーブルの「更正前」対象者（追加含む）情報を更新する。
     *
     * @param parameter 更新する条件
     */
    void update異動賦課情報一時テーブル更正前対象者情報(IdofukaJohoTempParameter parameter);

    /**
     * 異動賦課情報一時テーブルの生活保護区分を更新する。
     *
     * @param parameter 更新する条件
     */
    void update異動賦課情報一時テーブル生活保護区分(Map<String, Object> parameter);

    /**
     * 全件賦課情報一時テーブルのデータをクリアする。
     */
    void delete全件賦課情報一時テーブル();

    /**
     * 計算後情報一時テーブルからデータを抽出し、全件賦課情報一時テーブルに登録する。
     *
     * @param parameter 検索条件
     */
    void insert全件賦課情報一時テーブルFROM計算後情報一時(IdofukaJohoTempParameter parameter);

    /**
     * 計算後情報一時テーブルの更新前後区分が「1：更正前」のデータにより、 <br/>
     * 全件賦課情報一時テーブルの「更正前」計算後情報を更新する。
     *
     * @param parameter 更新条件
     */
    void update全件賦課情報一時テーブルFROM計算後情報一時(IdofukaKoseimaeParameter parameter);

    /**
     * 全件賦課情報一時テーブルの更正前対象者（追加含む）情報を更新する。
     *
     * @param parameter 更新条件
     */
    void update全件賦課情報一時テーブル更正前対象者情報(IdofukaJohoTempParameter parameter);

    /**
     * 全件賦課情報一時テーブルの生活保護区分を更新する。
     *
     * @param parameter 更新条件
     */
    void update全件賦課情報一時テーブル生活保護区分(Map<String, Object> parameter);

    /**
     * 異動賦課情報一時テーブルのデータ件数を取得する。
     *
     * @return 異動賦課情報一時テーブルのデータ件数
     */
    int selectCount異動賦課情報一時テーブル();

    /**
     * 異動賦課情報一時テーブル．全項目の抽出です。
     *
     * @return 異動賦課情報一時テーブル．全項目
     */
    int selectAll異動賦課情報一時テーブル();

    /**
     * 出力対象データを抽出し、通知書発行後異動者テーブルに登録する。
     *
     * @param parameter 検索条件
     */
    void insert通知書発行後異動者(TsuchishoHakkogoIdoshaParameter parameter);

    /**
     * 全件賦課情報一時テーブルのデータ件数を取得する。
     *
     * @return 全件賦課情報一時テーブルのデータ件数
     */
    int selectCount全件賦課情報一時テーブル();

    /**
     * 全件賦課情報一時テーブルの全項目取得する
     *
     * @param parameter 検索条件
     */
    void select全項目From全件賦課情報一時テーブル(IdoOrZenkenFukaSelectParameter parameter);

    /**
     * 異動賦課情報一時テーブルの全項目取得する
     *
     * @param parameter 検索条件
     */
    void select全項目From異動賦課情報一時テーブル(IdoOrZenkenFukaSelectParameter parameter);
}
