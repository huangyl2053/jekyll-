/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.persistence.db.mapper.relate.honnsanteifuka;

import java.util.List;
import jp.co.ndensan.reams.db.dbb.definition.core.honnsanteifuka.CaluculateFukaParameter;
import jp.co.ndensan.reams.db.dbb.definition.core.honnsanteifuka.HonsenteiKeisangojohoParameter;
import jp.co.ndensan.reams.db.dbb.definition.core.honnsanteifuka.KeisanTaishoshaParameter;
import jp.co.ndensan.reams.db.dbb.definition.mybatisprm.honnsanteifuka.HonsanteiTokuchoChushishaParameter;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT2013HokenryoDankaiEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.honnsanteifuka.CaluculateFukaEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.honnsanteifuka.FukaCalculateEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.honnsanteifuka.HonsenteiKeisangojohoEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.honnsanteifuka.KeisanTaishoshaEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.honnsanteifuka.SetaiHaakuShuturyokuEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT2001ChoshuHohoEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7022ShoriDateKanriEntity;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;

/**
 * 本算定賦課のインタフェースです。
 *
 * @reamsid_L DBB-0730-020 lijunjun
 */
public interface IHonnSanteiFukaMapper {

    /**
     * 本算定抽出Tempの検索
     *
     * @return List<SetaiHaakuShuturyokuEntity>
     */
    List<SetaiHaakuShuturyokuEntity> select世帯員把握();

    /**
     * select本算定計算後賦課情報has徴収方法
     *
     * @param param HonsenteiKeisangojohoParameter
     * @return List<HonsenteiKeisangojohoEntity>
     */
    List<HonsenteiKeisangojohoEntity> select本算定計算後賦課情報has徴収方法(HonsenteiKeisangojohoParameter param);

    /**
     * select本算定計算後賦課情報hasnot徴収方法
     *
     * @param param HonsenteiKeisangojohoParameter
     * @return List<HonsenteiKeisangojohoEntity>
     */
    List<HonsenteiKeisangojohoEntity> select本算定計算後賦課情報hasnot徴収方法(HonsenteiKeisangojohoParameter param);

    /**
     * 徴収方法情報を取得メソッドです。
     *
     * @param param HonsanteiTokuchoChushishaParameter
     * @return List<DbT2001ChoshuHohoEntity>
     */
    List<DbT2001ChoshuHohoEntity> select徴収方法情報(HonsanteiTokuchoChushishaParameter param);

    /**
     * 計算対象者抽出を取得メソッドです。
     *
     * @param param KeisanTaishoshaParameter
     * @return List<KeisanTaishoshaEntity>
     */
    List<KeisanTaishoshaEntity> select計算対象者抽出(KeisanTaishoshaParameter param);

    /**
     * 賦課計算中間一時データを取得メソッドです。
     *
     * @param param CaluculateFukaParameter
     * @return List<FukaCalculateEntity>
     */
    List<FukaCalculateEntity> select賦課計算中間一時(CaluculateFukaParameter param);

    /**
     * 生活保護、老齢福祉年金受給者、境界層を取得のメソッドです。
     *
     * @return List<CaluculateFukaEntity>
     */
    List<CaluculateFukaEntity> select生活老齢境界();

    /**
     * 世帯員を取得のメソッドです。
     *
     * @return List<CaluculateFukaEntity>
     */
    List<CaluculateFukaEntity> select世帯員();

    /**
     * 年額保険料を取得のメソッドです。
     *
     * @param 賦課年度 FlexibleYear
     * @return List<DbT2013HokenryoDankaiEntity>
     */
    List<DbT2013HokenryoDankaiEntity> select年額保険料(FlexibleYear 賦課年度);

    /**
     * 処理状況を取得のメソッドです。
     *
     * @return DbT7022ShoriDateKanriEntity
     */
    DbT7022ShoriDateKanriEntity select処理状況();
}
