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
import jp.co.ndensan.reams.db.dbb.entity.db.relate.fukajoho.fukajoho.FukaJohoRelateEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.honnsanteifuka.HonSanJonTyuShutuTempEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.honnsanteifuka.HonsenteiKeisangojohoEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.honnsanteifuka.KakuShugyoumuJouHouEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.honnsanteifuka.KuBunnGaTsurakuTempEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.honnsanteifuka.SetaiHaakuShuturyokuEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1001HihokenshaDaichoEntity;

/**
 * 本算定賦課のインタフェースです。
 *
 * @reamsid_L DBB-0730-020 lijunjun
 */
public interface IHonnSanteiFukaMapper {

    /**
     * 資格情報 被保険者台帳管理の全項目
     *
     * @param parameter KeisanTaishoshaParameter
     * @return List<DbT1001HihokenshaDaichoEntity>
     */
    List<DbT1001HihokenshaDaichoEntity> select資格の情報(KeisanTaishoshaParameter parameter);

    /**
     * select賦課情報のメソッド
     *
     * @param parameter KeisanTaishoshaParameter
     * @return 賦課Newestの全項目
     */
    List<FukaJohoRelateEntity> select賦課の情報(KeisanTaishoshaParameter parameter);

    /**
     * 月別ランクTempのCreate
     */
    void create月別ランクTemp();

    /**
     * insert月別ランクTemp
     *
     * @param entity KuBunnGaTsurakuTempEntity
     */
    void insert月別ランクTemp(KuBunnGaTsurakuTempEntity entity);

    /**
     * 本算定抽出TempのCreate
     */
    void creat本算定抽出Temp();

    /**
     * 本算定抽出Tempの検索
     *
     * @return List<SetaiHaakuShuturyokuEntity>
     */
    List<SetaiHaakuShuturyokuEntity> select世帯員把握();

    /**
     * DB出力(世帯員把握入力テーブル)
     *
     * @param entity SetaiHaakuShuturyokuEntity
     */
    void insert世帯員把握入力テーブル(SetaiHaakuShuturyokuEntity entity);

    /**
     * 世帯員把握入力テーブルのcreat
     */
    void create世帯員把握入力テーブル();

    /**
     * create世帯員所得情報Temp
     */
    void create世帯員所得情報Temp();

    /**
     * insert本算定抽出Temp
     *
     * @param entity HonSanJonTyuShutuTempEntity
     */
    void insert本算定抽出Temp(HonSanJonTyuShutuTempEntity entity);

    /**
     * get賦課計算情報
     *
     * @param parameter CaluculateFukaParameter
     * @return List<KakuShugyoumuJouHouEntity>
     */
    List<KakuShugyoumuJouHouEntity> get賦課計算情報(CaluculateFukaParameter parameter);

    /**
     * select本算定計算後賦課情報
     *
     * @param param HonsenteiKeisangojohoParameter
     * @return List<HonsenteiKeisangojohoEntity>
     */
    List<HonsenteiKeisangojohoEntity> select本算定計算後賦課情報(HonsenteiKeisangojohoParameter param);
}
