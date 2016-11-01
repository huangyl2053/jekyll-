/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.kogakukaigotaishoshachushutsusokyubun;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.kogakukaigotaishoshachushutsusokyubun.KogakukaigotaishoshachushutsusokyubunParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakukaigotaishoshachushutsusokyubun.HihokenshaNoFukaEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakukaigotaishoshachushutsusokyubun.ShiKaKuiDoDeTaEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakukaigotaishoshachushutsusokyubun.UaFt001FindEntity;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.idoruiseki.ShikibetsuTaishoIdoSearchKey;

/**
 * 高額介護対象者抽出（遡及分）
 *
 * @reamsid_L DBC-5750-050 houtianpeng
 */
public interface IKogakuKaigoTaishoshaChushutsuSokyubunMapper {

    /**
     * 過去分実績基本抽出３(資格異動データ抽出)
     *
     * @param param KogakukaigotaishoshachushutsusokyubunParameter
     * @return List<ShiKaKuiDoDeTaEntity>
     */
    List<ShiKaKuiDoDeTaEntity> get資格異動データ抽出(KogakukaigotaishoshachushutsusokyubunParameter param);

    /**
     * 過去分実績基本抽出８(給付実績基本データ抽出)
     *
     * @param parameter KogakukaigotaishoshachushutsusokyubunParameter
     * @return List<ShiKaKuiDoDeTaEntity>
     */
    List<ShiKaKuiDoDeTaEntity> get給付実績基本TBLデータ(KogakukaigotaishoshachushutsusokyubunParameter parameter);

    /**
     * 過去分実績基本抽出２(宛名データ抽出)
     *
     * @param param param
     * @return List<UaFt001FindEntity>
     */
    List<UaFt001FindEntity> get宛名データ抽出(ShikibetsuTaishoIdoSearchKey param);

    /**
     * 過去分実績基本抽出７(被保険者番号付加)
     *
     * @return List<HihokenshaNoFukaEntity>
     */
    List<HihokenshaNoFukaEntity> get被保険者番号付加();

    /**
     * 過去分実績基本抽出６(レコードの丸めこみ)処理区分1
     *
     * @return List<HihokenshaNoFukaEntity>
     */
    List<HihokenshaNoFukaEntity> get処理区分1();

    /**
     * 過去分実績基本抽出６(レコードの丸めこみ)処理区分2
     *
     * @return List<HihokenshaNoFukaEntity>
     */
    List<HihokenshaNoFukaEntity> get処理区分2();

    /**
     * 過去分実績基本抽出４(世帯情報取得)
     *
     * @return List<HihokenshaNoFukaEntity>
     */
    List<HihokenshaNoFukaEntity> get世帯情報取得();

}
