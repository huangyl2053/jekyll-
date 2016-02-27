/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.persistence.db.mapper.basic.choteibo;

import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbb.definition.core.choteibo.DankaiChoteigakuShokei;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.choteibo.ChoteigakuGokeiEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.choteibo.DanKaiEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.choteibo.DangatsuDankaiDataEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.choteibo.DankaiDataEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.choteibo.DankaiGokeiEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.choteibo.DankaiKensuEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.choteibo.DankaiShokeiEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.choteibo.DankaiTksaiToFusaiKensuEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.choteibo.GenmenEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.choteibo.GokeiBubunEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.choteibo.GokeiBubunSoukeiEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.choteibo.KibetsuBubunDataEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.choteibo.KibetsuDataEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.choteibo.KibetsuEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.choteibo.KibetsuGokeiEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.choteibo.KibetsuShokeiEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.choteibo.KibetsuShokeiGokeiEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.choteibo.NaiheisyaKensuEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.choteibo.SaishutsuKampuEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.choteibo.SonotaBubunDataEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.choteibo.TokuchoKibetusDataEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.choteibo.ZengatsuDankaiDataEntity;

/**
 * 調定簿作成のマッパーインタフェースです。
 */
public interface IChoteiboSakuseiMapper {

    /**
     * 期別のデータをキー検索で取得します。
     *
     * @param parameter 検索条件
     * @return List<KibetsuDataEntity>
     */
    List<KibetsuDataEntity> get期別のデータ(Map<String, Object> parameter);

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
    List<DankaiDataEntity> get当月末の段階データ(Map<String, Object> parameter);

    /**
     * 前月末の段階データをキー検索で取得します。
     *
     * @param parameter 検索条件
     * @return List<DankaiDataEntity>
     */
    List<DankaiDataEntity> get前月末の段階データ(Map<String, Object> parameter);

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
    List<DankaiKensuEntity> get所得段階の件数(Map<String, Object> parameter);

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
    List<NaiheisyaKensuEntity> get内併徴者数(Map<String, Object> parameter);

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
     * 増の全部調定額の合計の計算
     *
     * @param parameter 検索条件
     * @return List<ChoteigakuGokeiEntity>
     */
    List<ChoteigakuGokeiEntity> get増の全部調定額の合計(Map<String, Object> parameter);

    /**
     * 減の全部調定額の合計の計算
     *
     * @param parameter 検索条件
     * @return List<ChoteigakuGokeiEntity>
     */
    List<ChoteigakuGokeiEntity> get減の全部調定額の合計(Map<String, Object> parameter);

    /**
     * 段階合計一時テーブルに増の調定額の合計の更新します。
     *
     * @param choteigakuGokeiEntity 段階合計一時テーブル更新データ
     */
    void update増の調定額の合計(ChoteigakuGokeiEntity choteigakuGokeiEntity);

    /**
     * 段階合計一時テーブルに減の調定額の合計の更新します。
     *
     * @param choteigakuGokeiEntity 段階合計一時テーブル更新データ
     */
    void update減の調定額の合計(ChoteigakuGokeiEntity choteigakuGokeiEntity);

    /**
     * 減免の件数と減免額の計算
     *
     * @param parameter 検索条件
     * @return List<GenmenEntity>
     */
    List<GenmenEntity> get減免の件数と減免額(Map<String, Object> parameter);

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
    List<SaishutsuKampuEntity> get特徴歳出還付情報(Map<String, Object> parameter);

    /**
     * 普徴歳出還付情報を取得します。
     *
     * @param parameter 検索条件
     * @return List<SaishutsuKampuEntity>
     */
    List<SaishutsuKampuEntity> get普徴歳出還付情報(Map<String, Object> parameter);

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
    List<TokuchoKibetusDataEntity> get特徴期別のデータ(Map<String, Object> parameter);

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
    List<KibetsuShokeiEntity> get普徴期別小計情報(Map<String, Object> parameter);

    /**
     * 徴収方法が「普通徴収」の場合、期別小計の合計情報を取得します。
     *
     * @param parameter 検索条件
     * @return List<KibetsuShokeiGokeiEntity>
     */
    List<KibetsuShokeiGokeiEntity> get期別小計の合計情報(Map<String, Object> parameter);

    /**
     * 当月末の段階のデータの取得します。
     *
     * @param parameter 検索条件
     * @return List<DangatsuDankaiDataEntity>
     */
    List<DangatsuDankaiDataEntity> get当月末の段階のデータ(Map<String, Object> parameter);

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
    List<ZengatsuDankaiDataEntity> get前月末の段階のデータ(Map<String, Object> parameter);

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
    List<DankaiTksaiToFusaiKensuEntity> get段階の特徴と普徴者数(Map<String, Object> parameter);

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
    List<KibetsuBubunDataEntity> get期別部分のデータ(Map<String, Object> parameter);

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
    List<SonotaBubunDataEntity> getその他部分のデータ(Map<String, Object> parameter);

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
