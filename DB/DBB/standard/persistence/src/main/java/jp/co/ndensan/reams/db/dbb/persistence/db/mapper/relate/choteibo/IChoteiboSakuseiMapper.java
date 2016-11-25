/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.persistence.db.mapper.relate.choteibo;

import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbb.definition.core.choteibo.DankaiChoteigakuShokei;
import jp.co.ndensan.reams.db.dbb.definition.mybatisprm.choteibo.ChoteiboShoriHizukeMyBatisParameter;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.choteibo.DanKaiEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.choteibo.DangatsuDankaiDataEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.choteibo.DankaiDataEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.choteibo.DankaiGokeiEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.choteibo.DankaiKensuEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.choteibo.DankaiShokeiEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.choteibo.DankaiTksaiToFusaiKensuEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.choteibo.GenmenEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.choteibo.GokeiBubunEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.choteibo.GokeiBubunSoukeiEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.choteibo.KibetsuBubunDataEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.choteibo.KibetsuDataEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.choteibo.KibetsuEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.choteibo.KibetsuGokeiEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.choteibo.KibetsuShokeiEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.choteibo.KibetsuShokeiGokeiEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.choteibo.NaiheisyaKensuEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.choteibo.SaishutsuKampuEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.choteibo.SonotaBubunDataEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.choteibo.TokuchoKibetusDataEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.choteibo.ZengatsuDankaiDataEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7022ShoriDateKanriEntity;

/**
 * 調定簿作成のマッパーインタフェースです。
 *
 * @reamsid_L DBB-0770-030 zhangrui
 */
public interface IChoteiboSakuseiMapper {

    /**
     * 期別のデータをキー検索で取得します。
     *
     * @param parameter 検索条件
     * @return List<KibetsuDataEntity>
     */
    List<KibetsuDataEntity> select期別のデータ(Map<String, Object> parameter);

    /**
     * 期別情報一時テーブルを作成します。
     */
    void createTmpKibetsu();

    /**
     * 期別情報一時テーブルに登録します。
     *
     * @param kibetsuEntity 期別情報一時テーブル更新データ
     */
    void insertTmpKibetsu(KibetsuEntity kibetsuEntity);

    /**
     * 当月末の段階データをキー検索で取得します。
     *
     * @param parameter 検索条件
     * @return List<DankaiDataEntity>
     */
    List<DankaiDataEntity> select当月末の段階データ(Map<String, Object> parameter);

    /**
     * 前月末の段階データをキー検索で取得します。
     *
     * @param parameter 検索条件
     * @return List<DankaiDataEntity>
     */
    List<DankaiDataEntity> select前月末の段階データ(Map<String, Object> parameter);

    /**
     * 段階情報一時テーブルを作成します。
     */
    void createTmpDankai();

    /**
     * 段階情報一時テーブルに登録します。
     *
     * @param danKaiEntity 段階情報一時テーブル更新データ
     */
    void insertTmpDankai(DanKaiEntity danKaiEntity);

    /**
     * 段階の件数を取得します。
     *
     * @param parameter 検索条件
     ** @return List<DankaiKensuEntity>
     */
    List<DankaiKensuEntity> select所得段階の件数(Map<String, Object> parameter);

    /**
     * 段階小計一時テーブルを作成します。
     */
    void createTmpDankaiShokei();

    /**
     * 段階小計一時テーブルに登録します。
     *
     * @param dankaiShokeiEntity 段階小計一時テーブル更新データ
     */
    void insertTmpDankaiShokei(DankaiShokeiEntity dankaiShokeiEntity);

    /**
     *
     * 内併徴者数を取得します。
     *
     * @param parameter 検索条件
     * @return List<NaiheisyaKensuEntity>
     */
    List<NaiheisyaKensuEntity> select内併徴者数(Map<String, Object> parameter);

    /**
     * 段階小計一時テーブルに内併徴者数を更新します
     *
     * @param naiheisyaKensuEntity 段階小計一時テーブル更新データ
     */
    void update内併徴者数(NaiheisyaKensuEntity naiheisyaKensuEntity);

    /**
     * 期別情報を取得します。
     *
     * @param parameter 検索条件
     * @return List<KibetsuEntity>
     */
    List<KibetsuEntity> select期別情報(Map<String, Object> parameter);

    /**
     * 期別情報を取得します。
     *
     * @param parameter 検索条件
     * @return List<DankaiEntity>
     */
    List<DanKaiEntity> select段階情報(Map<String, Object> parameter);

    /**
     * 期別小計一時テーブルを作成します。
     */
    void createTmpKibetsuShokei();

    /**
     * 期別小計一時テーブルに登録します。
     *
     * @param kibetsuShokeiEntity 期別小計一時テーブル更新データ
     */
    void insertTmpKibetsuShokei(KibetsuShokeiEntity kibetsuShokeiEntity);

    /**
     * 段階小計一時テーブルに調定額の小計を更新します。
     *
     * @param dankaiChoteigakuShokei 段階小計一時テーブル更新データ
     */
    void update調定額の小計(DankaiChoteigakuShokei dankaiChoteigakuShokei);

    /**
     * 段階小計情報を取得します。
     *
     * @param parameter 検索条件
     * @return List<DankaiShokeiEntity>
     */
    List<DankaiShokeiEntity> select段階小計情報(Map<String, Object> parameter);

    /**
     * 期別小計情報を取得します。
     *
     * @param parameter 検索条件
     * @return List<DankaiShokeiEntity>
     */
    List<KibetsuShokeiEntity> select期別小計情報(Map<String, Object> parameter);

    /**
     * 期別合計一時テーブルを作成します。
     */
    void createTmpKibetsuGokei();

    /**
     * 期別合計一時テーブルに登録します。
     *
     * @param kibetsuGokeiEntity 期別合計一時テーブル更新データ
     */
    void insertTmpKibetsuGokei(KibetsuGokeiEntity kibetsuGokeiEntity);

    /**
     * 段階合計一時テーブルを作成します。
     */
    void createTmpDankaiGokei();

    /**
     * 段階合計一時テーブルに登録します。
     *
     * @param dankaiGokeiEntity 段階合計一時テーブル更新データ
     */
    void insertTmpDankaiGokei(DankaiGokeiEntity dankaiGokeiEntity);

    /**
     * 該当する段階の増の調定額の小計を検索する。
     *
     * @param parameter 検索条件
     * @return List<ChoteigakuGokeiEntity>
     */
    List<DankaiShokeiEntity> select増の調定額の小計(Map<String, Object> parameter);

    /**
     * 該当する段階の減の調定額の小計を検索する。
     *
     * @param parameter 検索条件
     * @return List<ChoteigakuGokeiEntity>
     */
    List<DankaiShokeiEntity> select減の調定額の小計(Map<String, Object> parameter);

    /**
     * 減免の件数と減免額の計算
     *
     * @param parameter 検索条件
     * @return List<GenmenEntity>
     */
    List<GenmenEntity> select減免の件数と減免額(Map<String, Object> parameter);

    /**
     * 期別合計一時テーブルに減免の件数と減免額の更新します。
     *
     * @param genmenEntity 期別合計一時テーブル更新データ
     */
    void update減免の件数と減免額(GenmenEntity genmenEntity);

    /**
     * 特徴歳出還付情報を取得します。
     *
     * @param parameter 検索条件
     * @return List<SaishutsuKampuEntity>
     */
    List<SaishutsuKampuEntity> select特徴歳出還付情報(Map<String, Object> parameter);

    /**
     * 普徴歳出還付情報を取得します。
     *
     * @param parameter 検索条件
     * @return List<SaishutsuKampuEntity>
     */
    List<SaishutsuKampuEntity> select普徴歳出還付情報(Map<String, Object> parameter);

    /**
     * 期別合計一時テーブルに特徴歳出還付の件数と特徴歳出還付の調定額の更新します。
     *
     * @param saishutsuKampuEntity 期別合計一時テーブル更新データ
     */
    void update特徴歳出還付(SaishutsuKampuEntity saishutsuKampuEntity);

    /**
     * 期別合計一時テーブルに普徴歳出還付の件数と普徴歳出還付の調定額の更新します。
     *
     * @param saishutsuKampuEntity 期別合計一時テーブル更新データ
     */
    void update普徴歳出還付(SaishutsuKampuEntity saishutsuKampuEntity);

    /**
     * 徴収方法が「特別徴収」の場合、期別のデータの取得します。
     *
     * @param parameter 検索条件
     * @return List<TokuchoKibetusDataEntity>
     */
    List<TokuchoKibetusDataEntity> select特徴期別のデータ(Map<String, Object> parameter);

    /**
     * 合計部分一時テーブルを作成します。
     */
    void createTmpGokeiBubun();

    /**
     * 合計部分一時テーブルを登録します。
     *
     * @param gokeiBubunEntity 合計部分一時テーブル更新データ
     */
    void insertTmpGokeiBubun(GokeiBubunEntity gokeiBubunEntity);

    /**
     * 徴収方法が「普通徴収」の場合、期別小計情報を取得します。
     *
     * @param parameter 検索条件
     * @return List<KibetsuShokeiEntity>
     */
    List<KibetsuShokeiEntity> select普徴期別小計情報(Map<String, Object> parameter);

    /**
     * 徴収方法が「普通徴収」の場合、期別小計の合計情報を取得します。
     *
     * @param parameter 検索条件
     * @return List<KibetsuShokeiGokeiEntity>
     */
    List<KibetsuShokeiGokeiEntity> select期別小計の合計情報(Map<String, Object> parameter);

    /**
     * 当月末の段階のデータの取得します。
     *
     * @param parameter 検索条件
     * @return List<DangatsuDankaiDataEntity>
     */
    List<DangatsuDankaiDataEntity> select当月末の段階のデータ(Map<String, Object> parameter);

    /**
     * 当月末の段階のデータに合計部分一時テーブルを更新します。
     *
     * @param dangatsuDankaiDataEntity 当月末の段階のデータ
     */
    void update当月末の段階のデータ(DangatsuDankaiDataEntity dangatsuDankaiDataEntity);

    /**
     * 前月末の段階のデータの取得します。
     *
     * @param parameter 検索条件
     * @return List<ZengatsuDankaiDataEntity>
     */
    List<ZengatsuDankaiDataEntity> select前月末の段階のデータ(Map<String, Object> parameter);

    /**
     * 前月末の段階のデータに合計部分一時テーブルを更新します。
     *
     * @param zengatsuDankaiDataEntity 前月末の段階のデータ
     */
    void update前月末の段階のデータ(ZengatsuDankaiDataEntity zengatsuDankaiDataEntity);

    /**
     * 所得段階の特徴/普徴者数の取得します。
     *
     * @param parameter 検索条件
     * @return List<DankaiTksaiToFusaiKensuEntity>
     */
    List<DankaiTksaiToFusaiKensuEntity> select段階の特徴と普徴者数(Map<String, Object> parameter);

    /**
     * 所得段階の特徴/普徴者数の集計に合計部分一時テーブルを更新します。
     *
     * @param dankaiTksaiToFusaiKensuEntity 所得段階の特徴/普徴者数の集計に合計部分データ
     */
    void update段階の特徴と普徴者数(DankaiTksaiToFusaiKensuEntity dankaiTksaiToFusaiKensuEntity);

    /**
     * 期別部分のデータを取得します。
     *
     * @param parameter 検索条件
     * @return List<KibetsuBubunDataEntity>
     */
    List<KibetsuBubunDataEntity> select期別部分のデータ(Map<String, Object> parameter);

    /**
     * 合計部分総計一時テーブルを作成します。
     */
    void createTmpGokeiBubunSoukei();

    /**
     * 合計部分総計一時テーブルを登録します。
     *
     * @param gokeiBubunSoukeiEntity 合計部分総計一時テーブル更新データ
     */
    void insertTmpGokeiBubunSoukei(GokeiBubunSoukeiEntity gokeiBubunSoukeiEntity);

    /**
     * その他部分のデータを取得します。
     *
     * @param parameter 検索条件
     * @return List<SonotaBubunDataEntity>
     */
    List<SonotaBubunDataEntity> selectその他部分のデータ(Map<String, Object> parameter);

    /**
     * その他部分のデータに合計部分総計一時テーブルを更新します。
     *
     * @param donotaBubunDataEntity その他部分のデータに合計部分総計データ
     */
    void updateその他部分のデータ(SonotaBubunDataEntity donotaBubunDataEntity);

    /**
     * 期別合計情報を取得します。
     *
     * @param parameter 検索条件
     * @return List<KibetsuGokeiEntity>
     */
    List<KibetsuGokeiEntity> select期別合計情報(Map<String, Object> parameter);

    /**
     * 段階合計情報を取得します。
     *
     * @param parameter 検索条件
     * @return List<DankaiGokeiEntity>
     */
    List<DankaiGokeiEntity> select段階合計情報(Map<String, Object> parameter);

    /**
     * 合計部分一時テーブル全部データ取得する。
     *
     * @return List<GokeiBubunEntity>
     */
    List<GokeiBubunEntity> selectAll合計部分情報();

    /**
     * 合計部分総計一時テーブル全部データ取得する。
     *
     * @return List<GokeiBubunSoukeiEntity>
     */
    List<GokeiBubunSoukeiEntity> selectAll合計部分総計情報();

    /**
     * 段階小計一時テーブルから、合計を求める
     *
     * @param parameter 検索条件
     * @return List<DankaiGokeiEntity>
     */
    List<DankaiGokeiEntity> select段階合計From段階小計一時テーブル(Map<String, Object> parameter);

    /**
     * 「段階合計一時テーブル」にデータを更新する。
     *
     * @param entity 更新するデータ
     */
    void update段階合計情報(DankaiGokeiEntity entity);

    /**
     * 該当する段階の増の調定額の小計の更新する。
     *
     * @param entity entity
     */
    void update増の調定額の小計(DankaiShokeiEntity entity);

    /**
     * 該当する段階の減の調定額の小計の更新する。
     *
     * @param entity entity
     */
    void update減の調定額の小計(DankaiShokeiEntity entity);

    /**
     * 処理日付管理マスタから処理日付を取得する。
     *
     * @param parameter 検索条件
     * @return DbT7022ShoriDateKanriEntity
     */
    DbT7022ShoriDateKanriEntity select処理日付(ChoteiboShoriHizukeMyBatisParameter parameter);

    /**
     * 期別情報一時テーブルを削除します。
     */
    void dropTmpKibetsu();

    /**
     * 段階情報一時テーブルを削除します。
     */
    void dropTmpDankai();

    /**
     * 期別小計一時テーブルを削除します。
     */
    void dropTmpKibetsuShokei();

    /**
     * 段階小計一時テーブルを削除します。
     */
    void dropTmpDankaiShokei();

    /**
     * 期別合計一時テーブルを削除します。
     */
    void dropTmpKibetsuGokei();

    /**
     * 段階合計一時テーブルを削除します。
     */
    void dropTmpDankaiGokei();

    /**
     * 合計部分一時テーブルを削除します。
     */
    void dropTmpGokeiBubun();

    /**
     * 合計部分総計一時テーブルを削除します。
     */
    void dropTmpGokeiBubunSoukei();
}
