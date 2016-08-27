/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.persistence.db.mapper.relate.honsanteiidokanendotsuchishoikkatsuhakko;

import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbb.definition.mybatisprm.honsanteiidokanendotsuchishoikkatsuhakko.IdoFukaJohoParameter;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.honsanteitsuchishoikkatsuhakko.HonsanteiTsuchishoTempEntity;

/**
 * 本算定異動（過年度）通知書一括発行（バッチ）用マッパーです。
 *
 * @reamsid_L DBB-0920-040 huzongcheng
 */
public interface IKanendoTsuchishoIkkatsuHakkoMapper {

    /**
     * creat異動賦課情報一時テーブルメソッドです。
     */
    void creat賦課情報一時テーブル();

    /**
     * 賦課情報一時テーブルのデータをクリアする。
     */
    void clear賦課情報一時テーブル();

    /**
     * 賦課異動の更新後データを抽出し、異動賦課情報一時テーブルに登録する。
     *
     * @param parameter 検索条件
     */
    void insert賦課情報一時FROM計算後情報(IdoFukaJohoParameter parameter);

    /**
     * 計算後情報テーブルの更新前後区分が「1：更正前」のデータにより、<br/>
     * 異動賦課情報一時テーブルの「更正前」計算後情報を更新する。
     *
     */
    void update異動賦課情報一時テーブルFROM計算後情報();

    /**
     * 賦課異動の更新後データを抽出し、異動賦課情報一時テーブルに登録する。
     *
     * @param parameter 検索条件
     */
    void insert賦課情報一時FROM計算後情報FLAGTRUE(IdoFukaJohoParameter parameter);

    /**
     * 計算後情報テーブルの更新前後区分が「1：更正前」のデータにより、<br/>
     * 異動賦課情報一時テーブルの「更正前」計算後情報を更新する。
     *
     */
    void update異動賦課情報一時テーブルFROM計算後情報一時FLAGTRUE();

    /**
     * 異動賦課情報一時テーブルの「更正前」対象者情報を更新する。
     *
     * @param parameter 検索条件
     */
    void update異動賦課情報一時テーブル更正前対象者情報(IdoFukaJohoParameter parameter);

    /**
     * 異動賦課情報一時テーブルの生活保護区分を更新する。
     *
     */
    void update異動賦課情報一時テーブル生活保護区分();

    /**
     * 異動賦課情報一時抽出です。
     *
     * @param parameter Map<String, Object>
     *
     * @return List<HonsanteiTsuchishoTempEntity> 異動賦課情報一時
     */
    List<HonsanteiTsuchishoTempEntity> select異動賦課情報一時(Map<String, Object> parameter);

    /**
     * 通知書発行後異動者抽出です。
     *
     * @param parameter Map<String, Object>
     *
     * @return List<HonsanteiTsuchishoTempEntity> 異動賦課情報一時
     */
    List<HonsanteiTsuchishoTempEntity> select通知書発行後異動者(Map<String, Object> parameter);

    /**
     * 異動賦課情報一時変更抽出です。
     *
     * @param parameter Map<String, Object>
     *
     * @return List<HonsanteiTsuchishoTempEntity> 異動賦課情報一時
     */
    List<HonsanteiTsuchishoTempEntity> select異動賦課情報一時変更(Map<String, Object> parameter);

    /**
     * 変更通知書発行後異動者抽出です。
     *
     * @param parameter Map<String, Object>
     *
     * @return List<HonsanteiTsuchishoTempEntity> 異動賦課情報一時
     */
    List<HonsanteiTsuchishoTempEntity> select変更通知書発行後異動者(Map<String, Object> parameter);

    /**
     * 異動賦課情報一時納入抽出です。
     *
     * @param parameter Map<String, Object>
     *
     * @return List<HonsanteiTsuchishoTempEntity> 異動賦課情報一時
     */
    List<HonsanteiTsuchishoTempEntity> select異動賦課情報一時納入(Map<String, Object> parameter);

    /**
     * 納入通知書発行後異動者抽出です。
     *
     * @param parameter Map<String, Object>
     *
     * @return List<HonsanteiTsuchishoTempEntity> 異動賦課情報一時
     */
    List<HonsanteiTsuchishoTempEntity> select納入通知書発行後異動者(Map<String, Object> parameter);

    /**
     * 計算後情報一時を削除する。
     */
    void drop計算後情報一時();

    /**
     * 計算中間一時を削除する。
     */
    void drop計算中間一時();
}
