/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.persistence.db.mapper.relate.gennendohonsanteiidou;

import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbb.definition.mybatisprm.gennendohonsanteiidou.CalculateFukaParameter;
import jp.co.ndensan.reams.db.dbb.definition.mybatisprm.gennendohonsanteiidou.HonsanteiIdoKekkaParameter;
import jp.co.ndensan.reams.db.dbb.definition.mybatisprm.gennendohonsanteiidou.IdoParameter;
import jp.co.ndensan.reams.db.dbb.definition.mybatisprm.gennendohonsanteiidou.TokuchoIraikin4gatsuKaishiParameter;
import jp.co.ndensan.reams.db.dbb.definition.mybatisprm.gennendohonsanteiidou.TsuchishoNoCreateParameter;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.fuka.SetaiHaakuEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.fukajoho.fukajoho.FukaJohoRelateEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.gennendohonsanteiidou.CalculateFukaEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.gennendohonsanteiidou.CozaIdoEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.gennendohonsanteiidou.FukaJouhouEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.gennendohonsanteiidou.HonsanteiEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.gennendohonsanteiidou.HonsanteiIdoKekkaEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.gennendohonsanteiidou.IdoEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.gennendohonsanteiidou.IdoTriggerEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.gennendohonsanteiidou.ShotokuEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.gennendohonsanteiidou.ShotokuIdoEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.gennendohonsanteiidou.ShukiEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.gennendohonsanteiidou.ShukiIdoEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.gennendohonsanteiidou.TokuChoKaishiEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.gennendohonsanteiidou.TokuKarisanteiEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.gennendohonsanteiidou.TokuchoIraikin4gatsuKaishiEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.gennendohonsanteiidou.TsukibetsuRankuEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1001HihokenshaDaichoEntity;

/**
 * 本算定賦課・本算定異動（現年度）（バッチ）のマッパーインタフェースです。
 *
 * @reamsid_L DBB-0930-020 cuilin
 */
public interface IGenNendoHonsanteiIdouMapper {

    /**
     * 特徴開始一時テーブルを作成します。
     */
    void createTmpTokuChoKaishi();

    /**
     * データに特徴開始一時テーブルを登録します。
     *
     * @param entity TokuChoKaishiEntity
     */
    void insertTmpTokuChoKaishi(TokuChoKaishiEntity entity);

    /**
     * 特徴仮算定抽出一時テーブルを作成します。
     */
    void createTmpTokuKarisantei();

    /**
     * データに特徴仮算定抽出一時テーブルを登録します。
     *
     * @param entity TokuKarisanteiEntity
     */
    void insertTmpTokuKarisantei(TokuKarisanteiEntity entity);

    /**
     * 特徴4月開始者の特徴仮算定対象データを一括で取得する。
     *
     * @param map Map<String, Object>
     * @return List<TokuKarisanteiEntity>
     */
    List<TokuKarisanteiEntity> get特徴4月開始者の特徴仮算定対象データ(Map<String, Object> map);

    /**
     * 住基抽出一時テーブルを作成します。
     */
    void createTmpShuki();

    /**
     * データに住基抽出一時テーブルを登録します。
     *
     * @param entity ShukiEntity
     */
    void insertTmpShuki(ShukiEntity entity);

    /**
     * 住基異動一時テーブルを作成します。
     */
    void createTmpShukiIdo();

    /**
     * データに住基異動一時テーブルを登録します。
     *
     * @param entity ShukiIdoEntity
     */
    void insertTmpShukiIdo(ShukiIdoEntity entity);

    /**
     * 住基（宛名）異動の取得に被保険者本人異動の判断
     *
     * @param param IdoParameter
     * @return List<ShukiIdoEntity>
     */
    List<ShukiIdoEntity> get住基異動_被保険者本人異動(IdoParameter param);

    /**
     * 住基（宛名）異動の取得に本人の情報の削除
     */
    void delete住基異動_本人の情報の削除();

    /**
     * 異動一時テーブルを作成します。
     */
    void createTmpIdo();

    /**
     * データに異動一時テーブルを登録します。
     *
     * @param entity IdoEntity
     */
    void insertTmpIdo(IdoEntity entity);

    /**
     * 住基（宛名）異動の取得に本人以外の異動情報の判断
     *
     * @param map Map<String, Object>
     * @return List<IdoEntity>
     */
    List<IdoEntity> get住基異動_本人以外の異動情報(Map<String, Object> map);

    /**
     * 住基（宛名）異動の取得に本人の異動を「異動Temp」に追加する
     *
     * @return List<IdoEntity>
     */
    List<IdoEntity> get住基異動_本人の異動情報();

    /**
     * 所得抽出一時テーブルを作成します。
     */
    void createTmpShotoku();

    /**
     * データに所得抽出一時テーブルを登録します。
     *
     * @param entity ShotokuEntity
     */
    void insertTmpShotoku(ShotokuEntity entity);

    /**
     * 所得異動データを取得します。
     *
     * @param param IdoParameter
     * @return List<ShotokuEntity>
     */
    List<ShotokuEntity> get所得異動データ(IdoParameter param);

    /**
     * 所得異動一時テーブルを作成します。
     */
    void createTmpShotokuIdo();

    /**
     * データに所得異動一時テーブルを登録します。
     *
     * @param entity ShotokuIdoEntity
     */
    void insertTmpShotokuIdo(ShotokuIdoEntity entity);

    /**
     * 所得異動の取得に被保険者本人異動の判断
     *
     * @return List<ShotokuIdoEntity>
     */
    List<ShotokuIdoEntity> get所得異動_被保険者本人異動();

    /**
     * 所得異動の取得に本人の情報の削除
     */
    void delete所得異動_本人の情報の削除();

    /**
     * 所得異動の取得に本人以外の異動情報の判断
     *
     * @param map Map<String, Object>
     * @return List<IdoEntity>
     */
    List<IdoEntity> get所得異動_本人以外の異動情報(Map<String, Object> map);

    /**
     * 所得異動の取得に本人の異動を「異動Temp」に追加する
     *
     * @return List<IdoEntity>
     */
    List<IdoEntity> get所得異動_本人の異動情報();

    /**
     * 資格の異動の取得
     *
     * @param param IdoParameter
     * @return List<IdoEntity>
     */
    List<IdoEntity> get資格の異動(IdoParameter param);

    /**
     * 生保の異動の取得
     *
     * @param param IdoParameter
     * @return List<IdoEntity>
     */
    List<IdoEntity> get生保の異動(IdoParameter param);

    /**
     * 老齢の異動の取得
     *
     * @param param IdoParameter
     * @return List<IdoEntity>
     */
    List<IdoEntity> get老齢の異動(IdoParameter param);

    /**
     * 境界層の異動の取得
     *
     * @param param IdoParameter
     * @return List<IdoEntity>
     */
    List<IdoEntity> get境界層の異動(IdoParameter param);

    /**
     * 徴収方法の異動の取得
     *
     * @param param IdoParameter
     * @return List<IdoEntity>
     */
    List<IdoEntity> get徴収方法の異動(IdoParameter param);

    /**
     * 賦課情報一時テーブルを作成します。
     */
    void createTmpFukaJouhou();

    /**
     * データに賦課情報一時テーブルを登録します。
     *
     * @param entity FukaJouhouEntity
     */
    void insertTmpFukaJouhou(FukaJouhouEntity entity);

    /**
     * 賦課情報一時の作成
     *
     * @param param IdoParameter
     * @return List<FukaJouhouEntity>
     */
    List<FukaJouhouEntity> get賦課情報一時(IdoParameter param);

    /**
     * 口座異動一時テーブルを作成します。
     */
    void createTmpCozaIdo();

    /**
     * データに口座異動一時テーブルを登録します。
     *
     * @param entity CozaIdoEntity
     */
    void insertTmpCozaIdo(CozaIdoEntity entity);

    /**
     * 口座の異動の取得します。
     *
     * @param param IdoParameter
     * @return List<CozaIdoEntity>
     */
    List<CozaIdoEntity> get口座の異動(IdoParameter param);

    /**
     * 現金の異動の取得します。
     *
     * @param param IdoParameter
     * @return List<CozaIdoEntity>
     */
    List<CozaIdoEntity> get現金の異動(IdoParameter param);

    /**
     * 異動トリガー一時テーブルを作成します。
     */
    void createTmpIdoTrigger();

    /**
     * データに異動トリガー一時テーブルを登録します。
     *
     * @param entity IdoTriggerEntity
     */
    void insertTmpIdoTrigger(IdoTriggerEntity entity);

    /**
     * 特徴依頼金計算をしない月、異動Tempと口座異動Tempをマージ（union）
     */
    void insert異動Tempと口座異動Tempをマージ();

    /**
     * 通常の異動賦課に含めて計算する
     */
    void insert通常の異動賦課に含めて計算する();

    /**
     * 特徴捕捉対象者のみを計算する
     */
    void insert特徴捕捉対象者のみを計算する();

    /**
     * 資格の情報として取得
     *
     * @param param TsuchishoNoCreateParameter
     * @return List<DbT1001HihokenshaDaichoEntity>
     */
    List<DbT1001HihokenshaDaichoEntity> get資格の情報(TsuchishoNoCreateParameter param);

    /**
     * 賦課の情報として取得
     *
     * @param param TsuchishoNoCreateParameter
     * @return List<FukaJohoRelateEntity>
     */
    List<FukaJohoRelateEntity> get賦課の情報(TsuchishoNoCreateParameter param);

    /**
     * 本算定抽出一時テーブルを作成します。
     */
    void createTmpHonsantei();

    /**
     * データに本算定抽出一時テーブルを登録します。
     *
     * @param entity HonsanteiEntity
     */
    void insertTmpHonsantei(HonsanteiEntity entity);

    /**
     * 月別ランク一時テーブルを作成します。
     */
    void createTmpTsukibetsuRanku();

    /**
     * データに月別ランク一時テーブルを登録します。
     *
     * @param entity TsukibetsuRankuEntity
     */
    void insertTmpTsukibetsuRanku(TsukibetsuRankuEntity entity);

    /**
     * 世帯員把握入力一時テーブルを作成します。
     */
    void createTmpSetaiHaaku();

    /**
     * データに世帯員把握入力一時テーブルを登録します。
     *
     * @param entity SetaiHaakuEntity
     */
    void insertTmpSetaiHaaku(SetaiHaakuEntity entity);

    /**
     * 本算定抽出Tempから世帯員把握の呼出しに必要な情報を取得する。
     *
     * @return List<SetaiHaakuEntity>
     */
    List<SetaiHaakuEntity> get世帯員把握情報();

    /**
     * 賦課計算の情報の取得します。
     *
     * @param param CalculateFukaParameter
     * @return List<CalculateFukaEntity>
     */
    List<CalculateFukaEntity> get賦課計算の情報(CalculateFukaParameter param);

    /**
     * 特徴依頼金計算の情報を取得します。
     *
     * @param param TokuchoIraikin4gatsuKaishiParameter
     * @return List<TokuchoIraikin4gatsuKaishiEntity>
     */
    List<TokuchoIraikin4gatsuKaishiEntity> get特徴依頼金情報(TokuchoIraikin4gatsuKaishiParameter param);

    /**
     * 本算定異動情報を取得します。
     *
     * @param param HonsanteiIdoKekkaParameter
     * @return List<HonsanteiIdoKekkaEntity>
     */
    List<HonsanteiIdoKekkaEntity> get本算定異動情報(HonsanteiIdoKekkaParameter param);
}
