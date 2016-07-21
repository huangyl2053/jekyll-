/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.persistence.db.mapper.relate.honsanteiidokanendofuka;

import java.util.List;
import jp.co.ndensan.reams.db.dbb.definition.mybatisprm.honsanteiidokanendofuka.CalculateFukaParameter;
import jp.co.ndensan.reams.db.dbb.definition.mybatisprm.honsanteiidokanendofuka.KanendoFukaParameter;
import jp.co.ndensan.reams.db.dbb.definition.mybatisprm.honsanteiidokanendofuka.KeisangojohoToKozaParameter;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.fuka.SetaiHaakuEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.fuka.SetaiShotokuEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.fukajoho.fukajoho.FukaJohoRelateEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.honsanteiidokanendofuka.CalculateFukaEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.honsanteiidokanendofuka.CalculateFukaTmpEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.honsanteiidokanendofuka.HonsanteiShotokuTmpEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.honsanteiidokanendofuka.IdoTmpEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.honsanteiidokanendofuka.KeisangojohoToKozaEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.honsanteiidokanendofuka.ShotokuIdoTmpEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.honsanteiidokanendofuka.TsukibetsuRankuTmpEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1001HihokenshaDaichoEntity;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;

/**
 * 本算定異動（過年度）（バッチ）のMapperクラスです。
 *
 * @reamsid_L DBB-0910-020 zhujun
 */
public interface IHonSanteiIdoKanendoFukaMapper {

    /**
     * 住基抽出Tempを作成します。
     */
    void createJukiChushutsuTmp();

    /**
     * 住基抽出Tempを登録します。
     *
     * @param entity テーブルデータ
     */
    void insertJukiChushutsuTmp(ShotokuIdoTmpEntity entity);

    /**
     * 住基異動Tempを作成します。
     */
    void createJukiIdoTmp();

    /**
     * 住基異動Tempを登録します。
     *
     * @param entity テーブルデータ
     */
    void insertJukiIdoTmp(ShotokuIdoTmpEntity entity);

    /**
     * 所得抽出Tempを作成します。
     */
    void createShotokuChushutsuTmp();

    /**
     * 所得抽出Tempを登録します。
     *
     * @param entity テーブルデータ
     */
    void insertShotokuChushutsuTmp(ShotokuIdoTmpEntity entity);

    /**
     * 所得異動Tempを作成します。
     */
    void createShotokuIdoTmp();

    /**
     * 所得異動Tempを登録します。
     *
     * @param entity テーブルデータ
     */
    void insertShotokuIdoTmp(ShotokuIdoTmpEntity entity);

    /**
     * 異動Tempを作成します。
     */
    void createIdoTmp();

    /**
     * 異動Tempを登録します。
     *
     * @param entity テーブルデータ
     */
    void insertIdoTmp(IdoTmpEntity entity);

    /**
     * 月別ランクTempを作成します。
     */
    void createTsukibetsuRankuTmp();

    /**
     * 月別ランクTempを登録します。
     *
     * @param entity テーブルデータ
     */
    void insertTsukibetsuRankuTmp(TsukibetsuRankuTmpEntity entity);

    /**
     * 過年度本算定抽出Tempを作成します。
     */
    void createKanendoHonSanteiChushutsuTmp();

    /**
     * 過年度本算定抽出Tempを登録します。
     *
     * @param entity テーブルデータ
     */
    void insertKanendoHonSanteiChushutsuTmp(HonsanteiShotokuTmpEntity entity);

    /**
     * 世帯員把握入力Tmpを作成します。
     */
    void createTmpSetaiHaaku();

    /**
     * 世帯員把握入力Tmpを登録します。
     *
     * @param entity テーブルデータ
     */
    void insertTmpSetaiHaaku(SetaiHaakuEntity entity);

    /**
     * 賦課計算用Tempを作成します。
     */
    void createCalculateFukaTmp();

    /**
     * 賦課計算用Tempを登録します。
     *
     * @param entity テーブルデータ
     */
    void insertCalculateFukaTmp(CalculateFukaTmpEntity entity);

    /**
     * 被保険者本人異動を取得します。
     *
     * @param param パラメータ
     * @return 被保険者本人異動情報
     */
    List<ShotokuIdoTmpEntity> select住基異動_被保険者本人異動(KanendoFukaParameter param);

    /**
     * 本人情報を削除します。
     */
    void delete本人情報の削除();

    /**
     * 本人以外の異動情報を取得します。
     *
     * @param choteiNendoYMD 調定年度
     * @return 異動情報
     */
    List<IdoTmpEntity> select住基異動_本人以外の異動情報(FlexibleDate choteiNendoYMD);

    /**
     * 住基異動_本人の異動情報を取得します。
     *
     * @return 異動情報
     */
    List<IdoTmpEntity> select住基異動_本人の異動情報();

    /**
     * 介護取得から異動データを取得します。
     *
     * @param param パラメータ
     * @return 異動データ
     */
    List<ShotokuIdoTmpEntity> select所得異動_介護所得から異動データ(KanendoFukaParameter param);

    /**
     * 介護取得に被保険者本人異動を取得します。
     *
     * @return 異動データ
     */
    List<ShotokuIdoTmpEntity> select所得異動_被保険者本人異動();

    /**
     * 本人情報を削除します。
     */
    void delete所得異動_本人の情報の削除();

    /**
     * 所得異動_本人以外の異動情報を取得します。
     *
     * @param choteiNendoYMD 調定年度
     * @return 異動情報
     */
    List<IdoTmpEntity> select所得異動_本人以外の異動情報(FlexibleDate choteiNendoYMD);

    /**
     * 所得異動_本人の異動情報を取得します。
     *
     * @return 異動情報
     */
    List<IdoTmpEntity> select所得異動_本人の異動情報();

    /**
     * 資格の異動を取得します。
     *
     * @param param パラメータ
     * @return 異動情報
     */
    List<IdoTmpEntity> select資格の異動(KanendoFukaParameter param);

    /**
     * 生保の異動を取得します。
     *
     * @param param パラメータ
     * @return 異動情報
     */
    List<IdoTmpEntity> select生保の異動(KanendoFukaParameter param);

    /**
     * 老齢の異動を取得します。
     *
     * @param param パラメータ
     * @return 異動情報
     */
    List<IdoTmpEntity> select老齢の異動(KanendoFukaParameter param);

    /**
     * 境界層の異動を取得します。
     *
     * @param param パラメータ
     * @return 異動情報
     */
    List<IdoTmpEntity> select境界層の異動(KanendoFukaParameter param);

    /**
     * 徴収方法の異動を取得します。
     *
     * @param param パラメータ
     * @return 異動情報
     */
    List<IdoTmpEntity> select徴収方法の異動(KanendoFukaParameter param);

    /**
     * 通知書番号発番に、資格情報を取得します。
     *
     * @param param パラメータ
     * @return 資格情報
     */
    List<DbT1001HihokenshaDaichoEntity> select資格情報(KanendoFukaParameter param);

    /**
     * 通知書番号発番に、賦課情報を取得します。
     *
     * @param param パラメータ
     * @return 賦課情報
     */
    List<FukaJohoRelateEntity> select賦課情報(KanendoFukaParameter param);

    /**
     * 世帯員把握情報を取得します。
     *
     * @return 世帯員把握情報
     */
    List<SetaiHaakuEntity> select世帯員把握情報();

    /**
     * 賦課計算用データを取得します。
     *
     * @param param パラメータ
     * @return 賦課計算用データ
     */
    List<CalculateFukaTmpEntity> select賦課計算用データ(CalculateFukaParameter param);

    /**
     * 賦課計算データを取得します。
     *
     * @param param パラメータ
     * @return 賦課計算データ
     */
    List<CalculateFukaEntity> select賦課計算(CalculateFukaParameter param);

    //----------------------------------------------------------------------------------------------
    /**
     *
     * @return ShotokuIdoTmpEntity
     */
    List<ShotokuIdoTmpEntity> selectJukiChushutsuTmp();

    /**
     *
     * @return ShotokuIdoTmpEntity
     */
    List<ShotokuIdoTmpEntity> selectJukiIdoTmp();

    /**
     *
     * @return ShotokuIdoTmpEntity
     */
    List<ShotokuIdoTmpEntity> selectShotokuChushutsuTmp();

    /**
     *
     * @return ShotokuIdoTmpEntity
     */
    List<ShotokuIdoTmpEntity> selectShotokuIdoTmp();

    /**
     *
     * @return IdoTmpEntity
     */
    List<IdoTmpEntity> selectIdoTmp();

    /**
     *
     * @return TsukibetsuRankuTmpEntity
     */
    List<TsukibetsuRankuTmpEntity> selectTsukibetsuRankuTmp();

    /**
     *
     * @return HonsanteiShotokuTmpEntity
     */
    List<HonsanteiShotokuTmpEntity> selectKanendoHonSanteiChushutsuTmp();

    /**
     *
     * @return SetaiHaakuEntity
     */
    List<SetaiHaakuEntity> selectTmpSetaiHaaku();

    /**
     *
     * @return CalculateFukaTmpEntity
     */
    List<CalculateFukaTmpEntity> selectCalculateFukaTmp();

    /**
     * 計算後情報と宛名識別対象PSM、口座情報取得PSMを取得する。
     *
     * @param param KeisangojohoToKozaParameter
     * @return 計算後情報と宛名識別対象PSM、口座情報取得PSM
     */
    List<KeisangojohoToKozaEntity> select計算後情報と宛名と口座(KeisangojohoToKozaParameter param);

    /**
     *
     * @return sd
     */
    List<SetaiShotokuEntity> select世帯員所得情報();
}
