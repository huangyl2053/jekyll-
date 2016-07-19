/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.persistence.db.mapper.relate.karisanteiidofuka;

import java.util.List;
import jp.co.ndensan.reams.db.dbb.definition.mybatisprm.karisanteiidofuka.KariSanteiIdoFukaMybatisParameter;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.karisanteiidofuka.ShikakuFukaRelateEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.karisanteiidofuka.ShikakuFukaResultEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.karisanteiidofuka.ShikakuShutokuTempEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.karisanteiidofuka.TokubetuTyoushuuKaisiTempEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.karisanteiidofuka.TokutyouKariSannteiRelateEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbV2001ChoshuHohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1001HihokenshaDaichoEntity;

/**
 * 仮算定異動賦課のマッパーインタフェースです
 *
 * @reamsid_L DBB-0850-020 chenaoqi
 */
public interface IKariSanteiIdoFukaBatchMapper {

    /**
     * 資格喪失Temp一時テーブルを作成します
     */
    void create資格喪失Temp();

    /**
     * 世帯員把握Temp一時テーブルを作成します
     */
    void create世帯員把握Temp();

    /**
     * insert資格喪失Temp一時テーブル
     *
     * @param entity 被保険者台帳管理
     */
    void insert資格喪失Temp(DbT1001HihokenshaDaichoEntity entity);

    /**
     * 資格取得Temp一時テーブルを作成します
     */
    void create資格取得Temp();

    /**
     * insert資格取得Temp一時テーブル
     *
     * @param entity 被保険者台帳管理
     */
    void insert資格取得Temp(DbT1001HihokenshaDaichoEntity entity);

    /**
     * 特別徴収開始Temp一時テーブルを作成します
     */
    void create特別徴収開始Temp();

    /**
     * insert特別徴収開始Temp一時テーブル
     *
     * @param entity 介護徴収方法
     */
    void insert特別徴収開始Temp(DbV2001ChoshuHohoEntity entity);

    /**
     * 特別徴収開始Temp取得します
     *
     * @return TokubetuTyoushuuKaisiTempEntity
     */
    TokubetuTyoushuuKaisiTempEntity select特別徴収開始Temp();

    /**
     * 特徴仮算定抽出Temp一時テーブルを作成します
     */
    void create特徴仮算定抽出Temp();

    /**
     * insert特徴仮算定抽出Temp一時テーブル
     *
     * @param entity 特徴仮算定抽出TempEntity
     */
    void insert特徴仮算定抽出Temp_1(TokubetuTyoushuuKaisiTempEntity entity);

    /**
     * insert特徴仮算定抽出Temp一時テーブル
     *
     * @param entity 特徴仮算定抽出TempEntity
     */
    void insert特徴仮算定抽出Temp_2(TokubetuTyoushuuKaisiTempEntity entity);

    /**
     * 特別徴収停止Temp一時テーブルを作成します
     */
    void create特別徴収停止Temp();

    /**
     * 特別徴収停止者取得します
     *
     * @param parameter 仮算定異動賦課Parameter
     */
    void insert特別徴収停止者(KariSanteiIdoFukaMybatisParameter parameter);

    /**
     * 賦課情報Temp一時テーブルを作成します
     */
    void create賦課情報Temp();

    /**
     * insert賦課情報Temp一時テーブル
     *
     * @param parameter 仮算定異動賦課Parameter
     */
    void insert賦課情報Temp(KariSanteiIdoFukaMybatisParameter parameter);

    /**
     * 口座異動Temp一時テーブルを作成します
     */
    void create口座異動Temp();

    /**
     * insert口座の異動
     *
     * @param parameter 仮算定異動賦課Parameter
     */
    void insert口座の異動(KariSanteiIdoFukaMybatisParameter parameter);

    /**
     * insert現金の異動
     *
     * @param parameter 仮算定異動賦課Parameter
     */
    void insert現金の異動(KariSanteiIdoFukaMybatisParameter parameter);

    /**
     * select資格賦課情報
     *
     * @param parameter KariSanteiIdoFukaMybatisParameter
     * @return 資格賦課情報
     */
    List<ShikakuFukaRelateEntity> select資格賦課情報(KariSanteiIdoFukaMybatisParameter parameter);

    /**
     * update資格取得Temp
     *
     * @param insEntity ShikakuShutokuTempEntity
     */
    void update資格取得Temp(ShikakuShutokuTempEntity insEntity);

    /**
     * 世帯員把握 select資格取得情報
     *
     * @return List<ShikakuShutokuTempEntity>
     */
    List<ShikakuShutokuTempEntity> select資格取得情報();

    /**
     * insert世帯員把握入力
     *
     * @param 資格情報Entity ShikakuShutokuTempEntity
     */
    void insert世帯員把握入力(ShikakuShutokuTempEntity 資格情報Entity);

    /**
     * select資格喪失情報
     *
     * @param parameter KariSanteiIdoFukaMybatisParameter
     * @return List<ShikakuFukaResultEntity>
     */
    List<ShikakuFukaResultEntity> select資格喪失情報(KariSanteiIdoFukaMybatisParameter parameter);

    /**
     * select特別徴収停止
     *
     * @param parameter KariSanteiIdoFukaMybatisParameter
     * @return List<ShikakuFukaResultEntity>
     */
    List<ShikakuFukaResultEntity> select特別徴収停止(KariSanteiIdoFukaMybatisParameter parameter);

    /**
     * select特別徴収停止
     *
     * @param parameter KariSanteiIdoFukaMybatisParameter
     * @return List<ShikakuFukaResultEntity>
     */
    List<ShikakuFukaResultEntity> select資格取得(KariSanteiIdoFukaMybatisParameter parameter);

    /**
     * select口座異動
     *
     * @param parameter KariSanteiIdoFukaMybatisParameter
     * @return List<ShikakuFukaResultEntity>
     */
    List<ShikakuFukaResultEntity> select口座異動(KariSanteiIdoFukaMybatisParameter parameter);

    /**
     * select8月特徴開始
     *
     * @param parameter KariSanteiIdoFukaMybatisParameter
     * @return List<TokutyouKariSannteiRelateEntity>
     */
    List<TokutyouKariSannteiRelateEntity> select8月特徴開始(KariSanteiIdoFukaMybatisParameter parameter);
}
