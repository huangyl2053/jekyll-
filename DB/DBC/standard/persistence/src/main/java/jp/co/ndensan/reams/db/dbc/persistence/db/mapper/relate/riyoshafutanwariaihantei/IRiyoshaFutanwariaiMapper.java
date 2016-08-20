/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.riyoshafutanwariaihantei;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.dbc180020.DBC180020MyBatisParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.riyoshafutanwariaihantei.DbT3115SakuseiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.riyoshafutanwariaihantei.FutanWariaiHanteiJohoEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.riyoshafutanwariaihantei.FutanWariaiRelateEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.riyoshafutanwariaihantei.HanteiTaishoshaDaichoEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.riyoshafutanwariaihantei.HihokenshaNoEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.riyoshafutanwariaihantei.TsukibetsuHanteiTaishoshaDaichoEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.riyoshafutanwariaihantei.temptables.HanteiTaishoshaTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.riyoshafutanwariaihantei.temptables.KonkaiRiyoshaFutanWariaiJohoTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.riyoshafutanwariaihantei.temptables.RiyoshaFutanWariaiMeisaiTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.riyoshafutanwariaihantei.temptables.SeikatsuHogoGaitoJohoTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.riyoshafutanwariaihantei.temptables.SetaiHaakuEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.riyoshafutanwariaihantei.temptables.SetaiShotokuEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.riyoshafutanwariaihantei.temptables.SetainJohoTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.riyoshafutanwariaihantei.temptables.TsukibetsuFutanWariaiTempEntity;

/**
 * 利用者負担割合DB検索用のエンティティです。
 *
 * @reamsid_L DBC-4950-030 liuyang
 */
public interface IRiyoshaFutanwariaiMapper {

    /**
     * 世帯員把握入力Tempの作成。<br/ >
     * 処理詳細2(1)世帯員把握入力の作成
     *
     * @param parameter DBC180020MyBatisParameter
     *
     * @return 世帯員把握入力Temp
     */
    List<SetaiHaakuEntity> select世帯員把握入力(DBC180020MyBatisParameter parameter);

    /**
     * 世帯員情報Tempの作成。<br/ >
     * 処理詳細2(3)世帯員情報Tempの作成
     *
     * @param parameter DBC180020MyBatisParameter
     * @return 世帯員把握入力Temp
     */
    List<SetainJohoTempEntity> select世帯員情報(DBC180020MyBatisParameter parameter);

    /**
     * 世帯員情報Tempの作成。<br/ >
     * 処理詳細2(4)世帯員（利用者負担割合・本人）追加
     *
     * @param parameter DBC180020MyBatisParameter
     * @return 世帯員把握入力Temp
     */
    List<SetainJohoTempEntity> select世帯員追加(DBC180020MyBatisParameter parameter);

    /**
     * 判定対象者の追加。<br/ >
     * 処理詳細3判定対象者Tempの追加
     *
     * @param parameter DBC180020MyBatisParameter
     * @return List<HanteiTaishoshaDaichoEntity>
     */
    List<HanteiTaishoshaDaichoEntity> select判定対象者追加(DBC180020MyBatisParameter parameter);

    /**
     * 生活保護該当情報の作成<br/ >
     * 処理詳細5生活保護該当情報Tempの作成
     *
     * @param parameter DBC180020MyBatisParameter
     * @return List<SeikatsuHogoGaitoJohoTempEntity>
     */
    List<SeikatsuHogoGaitoJohoTempEntity> select生活保護該当情報作成(DBC180020MyBatisParameter parameter);

    /**
     * 月別判定対象者Tempの作成<br/ >
     * 処理詳細4(4)月別判定対象者Tempの作成
     *
     * @param parameter DBC180020MyBatisParameter
     * @return List<TsukibetsuHanteiTaishoshaDaichoEntity>
     */
    List<TsukibetsuHanteiTaishoshaDaichoEntity> select月別判定対象者作成(DBC180020MyBatisParameter parameter);

    /**
     * 月別判定対象者Tempの作成二回目<br/ >
     * 処理詳細4(4)月別判定対象者Tempの作成二回目
     *
     * @param parameter DBC180020MyBatisParameter
     * @return List<TsukibetsuHanteiTaishoshaDaichoEntity>
     */
    List<TsukibetsuHanteiTaishoshaDaichoEntity> select月別判定対象者作成二回目(DBC180020MyBatisParameter parameter);

    /**
     * 負担割合判定年次の作成<br/ >
     * 処理詳細6負担割合判定（年次）
     *
     * @param parameter DBC180020MyBatisParameter
     * @return List<FutanWariaiHanteiJohoEntity>
     */
    List<FutanWariaiHanteiJohoEntity> select負担割合判定年次(DBC180020MyBatisParameter parameter);

    /**
     * 負担割合判定月次の作成<br/ >
     * 処理詳細7負担割合判定（月次）
     *
     * @param parameter DBC180020MyBatisParameter
     * @return List<FutanWariaiHanteiJohoEntity>
     */
    List<FutanWariaiHanteiJohoEntity> select負担割合判定月次(DBC180020MyBatisParameter parameter);

    /**
     * 負担割合判定マージの作成<br/ >
     * 処理詳細8負担割合判定マージ
     *
     * @param parameter DBC180020MyBatisParameter
     * @return List<RiyoshaFutanWariaiMeisaiTempEntity>
     */
    List<RiyoshaFutanWariaiMeisaiTempEntity> select負担割合判定マージ(DBC180020MyBatisParameter parameter);

    /**
     * 月別負担割合作成新の作成<br/ >
     * 処理詳細9 月別負担割合（新）Tempの作成
     *
     * @param parameter DBC180020MyBatisParameter
     * @return List<TsukibetsuFutanWariaiTempEntity>
     */
    List<TsukibetsuFutanWariaiTempEntity> select月別負担割合作成新(DBC180020MyBatisParameter parameter);

    /**
     * 月別負担割合作成現の作成<br/ >
     * 処理詳細10 月別負担割合（現）Tempの作成
     *
     * @param parameter DBC180020MyBatisParameter
     * @return List<TsukibetsuFutanWariaiTempEntity>
     */
    List<TsukibetsuFutanWariaiTempEntity> select月別負担割合作成現(DBC180020MyBatisParameter parameter);

    /**
     * 負担割合と明細の作成<br/ >
     * 処理詳細11(1)利用者負担割合、利用者負担割合明細
     *
     * @param parameter DBC180020MyBatisParameter
     * @return List<FutanWariaiRelateEntity>
     */
    List<FutanWariaiRelateEntity> select負担割合と明細(DBC180020MyBatisParameter parameter);

    /**
     * 負担割合根拠の作成<br/ >
     * 処理詳細12 利用者負担割合根拠の登録
     *
     * @param parameter DBC180020MyBatisParameter
     * @return List<DbT3115SakuseiEntity>
     */
    List<DbT3115SakuseiEntity> select負担割合根拠(DBC180020MyBatisParameter parameter);

    /**
     * selectAllのメソッドです。<br/ >
     *
     * @return List<SetaiinJohoTempEntity>
     */
    List<SetainJohoTempEntity> select世帯員情報Temp();

    /**
     * selectAllのメソッドです。<br/ >
     *
     * @return List<SetaiinJohoTempEntity>
     */
    List<SetainJohoTempEntity> select追加判定対象者Temp();

    /**
     * selectAllのメソッドです。<br/ >
     *
     * @return List<SetaiHaakuEntity>
     */
    List<SetaiHaakuEntity> select世帯員把握入力Temp();

    /**
     * selectAllのメソッドです。<br/ >
     *
     * @return List<HanteiTaishoshaTempEntity>
     */
    List<HanteiTaishoshaTempEntity> select月別判定対象者Temp();

    /**
     * selectAllのメソッドです。<br/ >
     *
     * @return List<SeikatsuHogoGaitoJohoTempEntity>
     */
    List<SeikatsuHogoGaitoJohoTempEntity> select生活保護該当情報Temp();

    /**
     * selectAllのメソッドです。<br/ >
     *
     * @return List<RiyoshaFutanWariaiMeisaiTempEntity>
     */
    List<RiyoshaFutanWariaiMeisaiTempEntity> select利用者負担割合明細08Temp();

    /**
     * selectAllのメソッドです。<br/ >
     *
     * @return List<RiyoshaFutanWariaiMeisaiTempEntity>
     */
    List<RiyoshaFutanWariaiMeisaiTempEntity> select利用者負担割合明細09Temp();

    /**
     * selectAllのメソッドです。<br/ >
     *
     * @return List<RiyoshaFutanWariaiMeisaiTempEntity>
     */
    List<RiyoshaFutanWariaiMeisaiTempEntity> select利用者負担割合明細10Temp();

    /**
     * selectAllのメソッドです。<br/ >
     *
     * @return List<RiyoshaFutanWariaiMeisaiTempEntity>
     */
    List<RiyoshaFutanWariaiMeisaiTempEntity> select利用者負担割合明細11Temp();

    /**
     * selectAllのメソッドです。<br/ >
     *
     * @return List<RiyoshaFutanWariaiMeisaiTempEntity>
     */
    List<RiyoshaFutanWariaiMeisaiTempEntity> select利用者負担割合明細12Temp();

    /**
     * selectAllのメソッドです。<br/ >
     *
     * @return List<RiyoshaFutanWariaiMeisaiTempEntity>
     */
    List<RiyoshaFutanWariaiMeisaiTempEntity> select利用者負担割合明細01Temp();

    /**
     * selectAllのメソッドです。<br/ >
     *
     * @return List<RiyoshaFutanWariaiMeisaiTempEntity>
     */
    List<RiyoshaFutanWariaiMeisaiTempEntity> select利用者負担割合明細02Temp();

    /**
     * selectAllのメソッドです。<br/ >
     *
     * @return List<RiyoshaFutanWariaiMeisaiTempEntity>
     */
    List<RiyoshaFutanWariaiMeisaiTempEntity> select利用者負担割合明細03Temp();

    /**
     * selectAllのメソッドです。<br/ >
     *
     * @return List<RiyoshaFutanWariaiMeisaiTempEntity>
     */
    List<RiyoshaFutanWariaiMeisaiTempEntity> select利用者負担割合明細04Temp();

    /**
     * selectAllのメソッドです。<br/ >
     *
     * @return List<RiyoshaFutanWariaiMeisaiTempEntity>
     */
    List<RiyoshaFutanWariaiMeisaiTempEntity> select利用者負担割合明細05Temp();

    /**
     * selectAllのメソッドです。<br/ >
     *
     * @return List<RiyoshaFutanWariaiMeisaiTempEntity>
     */
    List<RiyoshaFutanWariaiMeisaiTempEntity> select利用者負担割合明細06Temp();

    /**
     * selectAllのメソッドです。<br/ >
     *
     * @return List<RiyoshaFutanWariaiMeisaiTempEntity>
     */
    List<RiyoshaFutanWariaiMeisaiTempEntity> select利用者負担割合明細07Temp();

    /**
     * selectAllのメソッドです。<br/ >
     *
     * @return List<RiyoshaFutanWariaiMeisaiTempEntity>
     */
    List<RiyoshaFutanWariaiMeisaiTempEntity> select利用者負担割合明細Temp();

    /**
     * selectAllのメソッドです。<br/ >
     *
     * @return List<TsukibetsuFutanWariaiTempEntity>
     */
    List<TsukibetsuFutanWariaiTempEntity> select月別負担割合新Temp();

    /**
     * selectAllのメソッドです。<br/ >
     *
     * @return List<TsukibetsuFutanWariaiTempEntity>
     */
    List<TsukibetsuFutanWariaiTempEntity> select月別負担割合現Temp();

    /**
     * selectAllのメソッドです。<br/ >
     *
     * @return List<KonkaiRiyoshaFutanWariaiJohoTempEntity>
     */
    List<KonkaiRiyoshaFutanWariaiJohoTempEntity> select今回利用者負担割合情報Temp();

    /**
     * selectAllのメソッドです。<br/ >
     *
     * @return List<HihokenshaNoEntity>
     */
    List<HihokenshaNoEntity> select被保険者番号Temp();

    /**
     * selectAllのメソッドです。<br/ >
     *
     * @return List<HihokenshaNoEntity>
     */
    List<SetaiShotokuEntity> select世帯員所得情報Temp();

}
