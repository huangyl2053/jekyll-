/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.persistence.db.mapper.relate.karisanteiidotsuchisho;

import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbb.definition.mybatisprm.karisanteiidotsuchisho.IdoOrZenkenFukaSelectParameter;
import jp.co.ndensan.reams.db.dbb.definition.mybatisprm.karisanteiidotsuchisho.IdofukaJohoTempParameter;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.honsanteitsuchishoikkatsuhakko.HonsanteiTsuchishoTempEntity;

/**
 * ビジネス_仮算定異動通知書一括発行（バッチ）のMapperインタフェースです。
 *
 * @reamsid_L DBB-0890-040 xicongwang
 */
public interface IKarisanteiIdoFukaMapper {

    /**
     * 計算後情報中間一時テーブル削除メソッドです。
     */
    void drop計算後情報中間一時();

    /**
     * 計算後情報一時テーブル削除メソッドです。
     */
    void drop計算後情報一時();

    /**
     * creat異動賦課情報一時テーブルメソッドです。
     */
    void creat賦課情報一時();

    /**
     * 賦課情報一時テーブルのデータをクリアする。
     */
    void clear賦課情報一時テーブル();

    /**
     * 賦課異動の更新後データを抽出し、異動賦課情報一時テーブルに登録する。
     *
     * @param parameter 検索条件
     */
    void insert賦課情報一時FROM計算後情報(IdofukaJohoTempParameter parameter);

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
     */
    void update異動賦課情報一時テーブルFROM計算後情報();

    /**
     * 計算後情報一時テーブルの更新前後区分が「1：更正前」のデータにより、<br/>
     * 異動賦課情報一時テーブルの「更正前」計算後情報を更新する。
     *
     */
    void update異動賦課情報一時テーブルFROM計算後情報一時();

    /**
     * 異動賦課情報一時テーブルの「更正前」対象者（追加含む）情報を更新する。
     *
     * @param parameter 更新する条件
     */
    void update異動賦課情報一時テーブル更正前対象者情報(IdofukaJohoTempParameter parameter);

    /**
     * 異動賦課情報一時テーブルの生活保護区分を更新する。
     *
     */
    void update異動賦課情報一時テーブル生活保護区分();

    /**
     * 全件賦課情報の抽出です。
     *
     * @param parameter Map<String, Object>
     *
     * @return List<HonsanteiTsuchishoTempEntity> 全件賦課情報
     */
    List<HonsanteiTsuchishoTempEntity> select全件賦課情報(Map<String, Object> parameter);

    /**
     * 全件賦課情報の抽出です。
     *
     * @param parameter Map<String, Object>
     *
     * @return List<HonsanteiTsuchishoTempEntity> 全件賦課情報
     */
    List<HonsanteiTsuchishoTempEntity> select全件賦課情報_変更(Map<String, Object> parameter);

    /**
     * 異動賦課情報一時テーブルの全項目取得する
     *
     * @param parameter 検索条件
     * @return List<HonsanteiTsuchishoTempEntity> 全件賦課情報
     */
    List<HonsanteiTsuchishoTempEntity> select全件賦課情報_納入(IdoOrZenkenFukaSelectParameter parameter);
}
