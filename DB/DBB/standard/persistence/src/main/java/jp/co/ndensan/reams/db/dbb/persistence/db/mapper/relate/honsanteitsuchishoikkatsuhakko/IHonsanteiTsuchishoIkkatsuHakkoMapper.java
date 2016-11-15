/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.persistence.db.mapper.relate.honsanteitsuchishoikkatsuhakko;

import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbb.definition.mybatisprm.honsanteitsuchishoikkatsuhakko.DecideKetteiHenkoTsuchishoParameter;
import jp.co.ndensan.reams.db.dbb.definition.mybatisprm.honsanteitsuchishoikkatsuhakko.HonsanteiTsuchishoIkkatsuHakkoParameter;
import jp.co.ndensan.reams.db.dbb.definition.mybatisprm.honsanteitsuchishoikkatsuhakko.PrtKetteiTsuchishoParameter;
import jp.co.ndensan.reams.db.dbb.definition.mybatisprm.honsanteitsuchishoikkatsuhakko.PrtNonyuTsuchishoParameter;
import jp.co.ndensan.reams.db.dbb.definition.mybatisprm.honsanteitsuchishoikkatsuhakko.PrtTokuchoKaishiTsuchishoHonsanteiParameter;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.DbT2014TsuchishoUchiwakeJokenEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.honsanteitsuchishoikkatsuhakko.HonsanteiTsuchishoTempEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7022ShoriDateKanriEntity;

/**
 * 本算定通知書一括発行（バッチ）クラスです。
 *
 * @reamsid_L DBB-0780-060 xicongwang
 */
public interface IHonsanteiTsuchishoIkkatsuHakkoMapper {

    /**
     * 最新調定日時を取得するメソッドです。
     *
     * @param parameter Map<String, Object>
     * @return DbT7022ShoriDateKanriEntity 処理日付管理
     */
    DbT7022ShoriDateKanriEntity select最新調定日時(Map<String, Object> parameter);

    /**
     * 計算後情報一時テーブルからデータを抽出するメソッドです。
     *
     * @param parameter HonsanteiTsuchishoIkkatsuHakkoParameter
     * @return HonsanteiTsuchishoTempEntity 計算後情報一時テーブルから抽出したデータ
     */
    HonsanteiTsuchishoTempEntity select計算後情報一時(HonsanteiTsuchishoIkkatsuHakkoParameter parameter);

    /**
     * 計算後情報テーブルからデータを抽出するメソッドです。
     *
     * @param parameter HonsanteiTsuchishoIkkatsuHakkoParameter
     * @return HonsanteiTsuchishoTempEntity 計算後情報一時テーブルから抽出したデータ
     */
    HonsanteiTsuchishoTempEntity select計算後情報(HonsanteiTsuchishoIkkatsuHakkoParameter parameter);

    /**
     * 通知書打ち分け条件を取得するメソッドです。
     *
     * @param parameter Map<String, Object>
     * @return DbT2014TsuchishoUchiwakeJokenEntity 通知書打ち分け条件
     */
    DbT2014TsuchishoUchiwakeJokenEntity select通知書打ち分け条件情報(Map<String, Object> parameter);

    /**
     * 計算後情報中間一時テーブル削除メソッドです。
     */
    void drop計算後情報中間一時();

    /**
     * 本算定通知書一時テーブルをクリアするメソッドです。
     */
    void clear本算定通知書一時();

    /**
     * 計算後情報一時テーブル削除メソッドです。
     */
    void drop計算後情報一時();

    /**
     * 計算後情報を利用するが、計算後情報テーブルの更新前後区分が「更正前」のデータにより、計算後情報「更正前」情報を更新するメソッドです。
     */
    void update本算定通知書一時_計算後情報更正前();

    /**
     * 計算後情報一時を利用するが、計算後情報テーブルの更新前後区分が「更正前」のデータにより、計算後情報「更正前」情報を更新するメソッドです。
     */
    void update本算定通知書一時_計算後情報更正前_一時();

    /**
     * 更正前の対象者（追加含む）情報を更新するメソッドです。
     *
     * @param parameter Map<String, Object>
     */
    void update本算定通知書一時_対象者仮徴収更正前(Map<String, Object> parameter);

    /**
     * 更正前の対象者（追加含む）情報を更新するメソッドです。
     *
     * @param parameter Map<String, Object>
     */
    void update本算定通知書一時_対象者本徴収更正前(Map<String, Object> parameter);

    /**
     * 生活保護区分を更新するメソッドです。
     *
     */
    void update本算定通知書一時_生活保護区分();

    /**
     * 対象データを抽出するメソッドです。
     *
     * @param parameter PrtTokuchoKaishiTsuchishoHonsanteiParameter
     * @return List<HonsanteiTsuchishoTempEntity> 対象データ
     */
    List<HonsanteiTsuchishoTempEntity> select特徴開始通知書(PrtTokuchoKaishiTsuchishoHonsanteiParameter parameter);

    /**
     * 対象データを抽出するメソッドです。
     *
     * @param parameter PrtKetteiTsuchishoParameter
     * @return List<HonsanteiTsuchishoTempEntity> 対象データ
     */
    List<HonsanteiTsuchishoTempEntity> select決定変更通知書(PrtKetteiTsuchishoParameter parameter);

    /**
     * 対象データを抽出するメソッドです。
     *
     * @return List<HonsanteiTsuchishoTempEntity> 対象データ
     */
    List<HonsanteiTsuchishoTempEntity> select本算定通知書all();

    /**
     * 本算定通知書一時テーブルを更新するメソッドです。
     *
     * @param parameter DecideKetteiHenkoTsuchishoParameter
     *
     */
    void update本算定通知書一時(DecideKetteiHenkoTsuchishoParameter parameter);

    /**
     * 対象データを抽出するメソッドです。
     *
     * @param parameter PrtNonyuTsuchishoParameter
     * @return List<HonsanteiTsuchishoTempEntity> 対象データ
     */
    List<HonsanteiTsuchishoTempEntity> select納入通知書(PrtNonyuTsuchishoParameter parameter);

    /**
     * 特徴8月開始者区分を更新するメソッドです。
     *
     */
    void update特徴8月開始者区分();

    /**
     * 特徴10月開始者区分を更新するメソッドです。
     *
     */
    void update特徴10月開始者区分();

}
