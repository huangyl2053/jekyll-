/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.persistence.db.mapper.relate.shotokushokaihyo;

import java.util.List;
import jp.co.ndensan.reams.db.dbb.definition.core.shotokushokaihyo.JukyuusyaTyuushutuParameter;
import jp.co.ndensan.reams.db.dbb.definition.core.shotokushokaihyo.SaihaqkouTaishoupParameter;
import jp.co.ndensan.reams.db.dbb.definition.core.shotokushokaihyo.ShotokuNendoParameter;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.shotokushokaihyo.FukaKijunSetaiEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.shotokushokaihyo.HihokenshaDaichoEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.shotokushokaihyo.JukyuusyaEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.shotokushokaihyo.KouhoshaTenyuEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.shotokushokaihyo.SaihaqkouTaishouTempEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.shotokushokaihyo.SetaiShotokuTempEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.shotokushokaihyo.SetaiSudeTempEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.shotokushokaihyo.ShotokuJouhouEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.shotokushokaihyo.ShotokuShoukaiDataTempEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.shotokushokaihyo.ShotokuShoukaiKouhoshaTempEntity;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 所得照会票一括発行（バッチ）のMapper
 *
 * @reamsid_L DBB-1720-050 lijunjun
 */
public interface IShotokushokaihyoMapper {

    /**
     * select被保険者台帳管理
     *
     * @param par ShotokuNendoParameter
     * @return List<DbT1001HihokenshaDaichoEntity>
     */
    List<HihokenshaDaichoEntity> select被保険者台帳管理(ShotokuNendoParameter par);

    /**
     * select年齢到達予定者
     *
     * @param par ShotokuNendoParameter
     * @return List<NenreitToutatsuyoTeimonoEntity> 年齢到達予定者
     */
    List<HihokenshaDaichoEntity> select年齢到達予定者(ShotokuNendoParameter par);

    /**
     * set年度内有資格者Temp
     *
     * @param 被保険者台帳Entity HihokenshaDaichoEntity
     */
    void insert年度内有資格者Temp(HihokenshaDaichoEntity 被保険者台帳Entity);

    /**
     * 年度内有資格者Tempを作成する。
     */
    void creat年度内有資格者Temp();

    /**
     * 受給者を抽出します。
     *
     * @param par ShotokuNendoParameter
     * @return List<JukyuusyaTyuushutuEntity>
     */
    List<JukyuusyaEntity> select受給者抽出(ShotokuNendoParameter par);

    /**
     * insert世帯員把握入力Temp
     *
     * @param 世帯員把握Par JukyuusyaTyuushutuParameter
     */
    void insert世帯員把握入力Temp(JukyuusyaTyuushutuParameter 世帯員把握Par);

    /**
     * 候補者（転入者）を取得する
     *
     * @param 処理年度Para ShotokuNendoParameter
     * @return List<KouhoshaTenyuEntity>
     */
    List<KouhoshaTenyuEntity> select候補者転入者(ShotokuNendoParameter 処理年度Para);

    /**
     * select候補者住特情報
     *
     * @param 処理年度Para ShotokuNendoParameter
     * @return List<KouhoshaJyutokuJouhouEntity>
     */
    List<KouhoshaTenyuEntity> select候補者住特情報(ShotokuNendoParameter 処理年度Para);

    /**
     * insert所得照会候補者Temp
     *
     * @param 所得照会候補者entity KouhoshaTenyuEntity
     */
    void insert所得照会候補者Temp(KouhoshaTenyuEntity 所得照会候補者entity);

    /**
     * 除外の住民を取得する。
     *
     * @param 処理年度Para ShotokuNendoParameter
     * @return 識別コード
     */
    List<ShikibetsuCode> select除外の住民(ShotokuNendoParameter 処理年度Para);

    /**
     * 住民情報を削除する
     *
     * @param 識別コード ShikibetsuCode
     */
    void delete住民情報(ShikibetsuCode 識別コード);

    /**
     * select所得情報
     *
     * @param 処理年度 FlexibleYear
     * @return List<ShotokuJouhouEntity>
     */
    List<ShotokuJouhouEntity> select所得情報(FlexibleYear 処理年度);

    /**
     * 所得情報を削除する
     *
     * @param 識別コード ShikibetsuCode
     */
    void delete所得情報(ShikibetsuCode 識別コード);

    /**
     * select再発行対象者Temp
     *
     * @param param SaihaqkouTaishoupParameter
     * @return List<SaihaqkouTaishouEntity>
     */
    List<SaihaqkouTaishouTempEntity> select再発行対象者Temp(SaihaqkouTaishoupParameter param);

    /**
     * 再発行対象者Tempを作成する。
     */
    void creat再発行対象者Temp();

    /**
     * 再発行対象者Tempへ出力する。
     *
     * @param entity SaihaqkouTaishouTempEntity
     */
    void insert再発行対象者Temp(SaihaqkouTaishouTempEntity entity);

    /**
     * 所得照会票データTempを作成する。
     */
    void creat所得照会票データTemp();

    /**
     * 所得照会候補者Tempを創建します。
     */
    void creat所得照会候補者Temp();

    /**
     * 所得照会票データTempへ出力する。
     *
     * @param entity ShotokuShoukaiDataTempEntity
     */
    void insert所得照会票データ(ShotokuShoukaiDataTempEntity entity);

    /**
     * 所得照会票データTempへ出力する。
     *
     * @param entity SetaiSudeTempEntity
     */
    void insert所得照会票データTemp(SetaiSudeTempEntity entity);

    /**
     * 所得照会票データTemp_2を取得する。
     *
     * @return List<ShotokuShoukaiDataTempEntity>
     */
    List<ShotokuShoukaiDataTempEntity> select所得照会票データ再発行();

    /**
     * select所得照会票データfromTemp3。
     *
     * @return List<ShotokuShoukaiDataTempEntity>
     */
    List<ShotokuShoukaiDataTempEntity> select所得照会票データfromTemp3();

    /**
     * select所得照会票データfromTemp2。
     *
     * @return List<ShotokuShoukaiDataTempEntity>
     */
    List<ShotokuShoukaiDataTempEntity> select所得照会票データfromTemp2();

    /**
     * select所得照会票データfromTemp1。
     *
     * @return List<ShotokuShoukaiDataTempEntity>
     */
    List<ShotokuShoukaiDataTempEntity> select所得照会票データfromTemp1();

    /**
     * 賦課基準日時点の世帯員を取得します。
     *
     * @return List<FukaKijunSetaiEntity>
     */
    List<FukaKijunSetaiEntity> select賦課基準日時点の世帯員();

    /**
     * 世帯員把握入力Tempを出力します。
     *
     * @param 所得年度 FlexibleYear
     */
    void insert世帯員把握入力Temp(FlexibleYear 所得年度);

    /**
     * 世帯員所得_年度内有資格者を取得します。
     *
     * @return List<SetaiShotokuTempEntity>
     */
    List<SetaiShotokuTempEntity> select世帯員所得_年度内有資格者();

    /**
     * 世帯員所得情報Tempを出力します。
     *
     * @param entity SetaiShotokuTempEntity
     */
    void insert世帯員所得情報Temp1(SetaiShotokuTempEntity entity);

    /**
     * 世帯員所得情報Tempを出力します。
     *
     * @param entity SetaiShotokuTempEntity
     */
    void insert世帯員所得情報Temp2(SetaiShotokuTempEntity entity);

    /**
     * 世帯員所得情報Tempを出力します。
     *
     * @param entity SetaiShotokuTempEntity
     */
    void insert世帯員所得情報Temp3(SetaiSudeTempEntity entity);

    /**
     * 世帯員所得_受給者Tempを取得します。
     *
     * @return List<SetaiShotokuTempEntity>
     */
    List<SetaiShotokuTempEntity> select世帯員所得_受給者Temp();

    /**
     * 受給者抽出Tempを出力します。
     *
     * @param entity JukyuusyaEntity
     */
    void insert受給者抽出Temp(JukyuusyaEntity entity);

    /**
     * 世帯員所得情報を取得します。
     *
     * @return List<SetaiSudeTempEntity>
     */
    List<SetaiSudeTempEntity> select世帯員所得情報_2();

    /**
     * 世帯員所得情報を取得します。
     *
     * @return List<SetaiSudeTempEntity>
     */
    List<SetaiSudeTempEntity> select世帯員所得情報fromTemp1();

    /**
     * 世帯員所得情報を取得します。
     *
     * @return List<SetaiSudeTempEntity>
     */
    List<SetaiSudeTempEntity> select世帯員所得情報fromTemp2();

    /**
     * 世帯員所得情報を取得します。
     *
     * @return List<SetaiSudeTempEntity>
     */
    List<SetaiSudeTempEntity> select世帯員所得情報_1();

    /**
     * 世帯員所得情報を取得します。
     *
     * @return List<SetaiSudeTempEntity>
     */
    List<SetaiSudeTempEntity> select世帯員所得情報_3();

    /**
     * 住民情報を取得します。
     *
     * @return List<ShotokuShoukaiKouhoshaTempEntity>
     */
    List<ShotokuShoukaiKouhoshaTempEntity> select住民情報();

    /**
     * 世帯員所得情報Tempを出力します。
     *
     * @param entity SetaiSudeTempEntity
     */
    void insert世帯員所得情報Temp(SetaiSudeTempEntity entity);

    /**
     * 所得照会票データTempを全件検索
     *
     * @return List<ShotokuShoukaiDataTempEntity>
     */
    List<ShotokuShoukaiDataTempEntity> selectAll所得照会票();

    /**
     * 出力順をソート順として,所得照会票データTempを全件検索
     *
     * @param 出力順 RString
     * @return List<ShotokuShoukaiDataTempEntity>
     */
    List<ShotokuShoukaiDataTempEntity> selectAll所得照会票OrderBy出力順(RString 出力順);
}
