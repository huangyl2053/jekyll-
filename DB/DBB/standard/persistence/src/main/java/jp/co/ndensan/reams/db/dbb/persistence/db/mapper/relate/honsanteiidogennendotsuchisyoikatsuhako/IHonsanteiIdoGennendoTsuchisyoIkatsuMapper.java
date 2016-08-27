/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.persistence.db.mapper.relate.honsanteiidogennendotsuchisyoikatsuhako;

import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbb.definition.mybatisprm.honsanteiidogennendotsuchisyoikatsuhako.IdoFukaJohoInfoParameter;
import jp.co.ndensan.reams.db.dbb.definition.mybatisprm.honsanteiidogennendotsuchisyoikatsuhako.IdoGennendoKarisanteiParameter;
import jp.co.ndensan.reams.db.dbb.definition.mybatisprm.honsanteiidogennendotsuchisyoikatsuhako.IdoNonyuTsuchishoParameter;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.honsanteiidogennendotsuchisyoikatsuhako.TmpIdoGennendoKarisanteiEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.honsanteitsuchishoikkatsuhakko.HonsanteiTsuchishoTempEntity;

/**
 * ビジネス_本算定異動（現年度）通知書一括発行（バッチ）のMapperインタフェースです。
 *
 * @reamsid_L DBB-0880-040 xicongwang
 */
public interface IHonsanteiIdoGennendoTsuchisyoIkatsuMapper {

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
     * 賦課異動の更新後データを抽出し、異動賦課情報一時テーブルに登録するメソッドです。
     *
     * @param parameter 検索条件
     */
    void insert賦課情報一時FROM計算後情報(IdoFukaJohoInfoParameter parameter);

    /**
     * 賦課異動の更新後データを抽出し、異動賦課情報一時テーブルに登録するメソッドです。
     *
     * @param parameter 検索条件
     */
    void insert異動賦課情報一時テーブルFROM計算後情報一時(IdoFukaJohoInfoParameter parameter);

    /**
     * 計算後情報テーブルの更新前後区分が「1：更正前」のデータにより、<br/>
     * 異動賦課情報一時テーブルの「更正前」計算後情報を更新するメソッドです。
     *
     */
    void update異動賦課情報一時テーブルFROM計算後情報();

    /**
     * 計算後情報一時テーブルの更新前後区分が「1：更正前」のデータにより、<br/>
     * 異動賦課情報一時テーブルの「更正前」計算後情報を更新するメソッドです。
     *
     */
    void update異動賦課情報一時テーブルFROM計算後情報一時();

    /**
     * 異動賦課情報一時テーブルの「更正前」対象者（追加含む）情報を更新するメソッドです。
     *
     * @param parameter Map<String, Object>
     */
    void update異動賦課情報一時テーブル更正前対象者情報(Map<String, Object> parameter);

    /**
     * 異動賦課情報一時テーブルの生活保護区分を更新するメソッドです。
     *
     */
    void update異動賦課情報一時テーブル生活保護区分();

    /**
     * 全件賦課情報の抽出メソッドです。
     *
     * @param parameter Map<String, Object>
     *
     * @return List<HonsanteiTsuchishoTempEntity> 全件賦課情報
     */
    List<HonsanteiTsuchishoTempEntity> select全件賦課情報(Map<String, Object> parameter);

    /**
     * creat特徴仮算定一時テーブルメソッドです。
     */
    void creat特徴仮算定一時();

    /**
     * 特徴仮算定一時テーブルのデータをクリアメソッドです。
     */
    void clear特徴仮算定一時();

    /**
     * 特徴仮算定一時情報登録するメソッドです。
     *
     * @param parameter IdoGennendoKarisanteiParameter
     */
    void insert特徴仮算定一時(IdoGennendoKarisanteiParameter parameter);

    /**
     * 特徴仮算定一時情報の抽出ですメソッドです。
     *
     * @param parameter Map<String, Object>
     *
     * @return List<TmpIdoGennendoKarisanteiEntity> 特徴仮算定一時情報
     */
    List<TmpIdoGennendoKarisanteiEntity> select特徴仮算定一時(Map<String, Object> parameter);

    /**
     * 全件賦課情報の抽出ですメソッドです。
     *
     * @param parameter Map<String, Object>
     *
     * @return List<HonsanteiTsuchishoTempEntity> 全件賦課情報
     */
    List<HonsanteiTsuchishoTempEntity> select全件賦課情報_決定(Map<String, Object> parameter);

    /**
     * 全件賦課情報の抽出ですメソッドです。
     *
     * @param parameter Map<String, Object>
     *
     * @return List<HonsanteiTsuchishoTempEntity> 全件賦課情報
     */
    List<HonsanteiTsuchishoTempEntity> select全件賦課情報_変更(Map<String, Object> parameter);

    /**
     * 異動賦課情報一時テーブルの全項目取得するメソッドです。
     *
     * @param parameter 検索条件
     * @return List<HonsanteiTsuchishoTempEntity> 全件賦課情報
     */
    List<HonsanteiTsuchishoTempEntity> select全件賦課情報_納入(IdoNonyuTsuchishoParameter parameter);
}
