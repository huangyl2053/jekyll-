/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.futanwariai;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbd.business.core.futanwariai.RiyoshaFutanWariai;
import jp.co.ndensan.reams.db.dbd.business.core.futanwariai.RiyoshaFutanWariaiKonkyo;
import jp.co.ndensan.reams.db.dbd.business.core.futanwariai.RiyoshaFutanWariaiMeisai;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT3113RiyoshaFutanWariaiEntity;
import jp.co.ndensan.reams.db.dbd.persistence.db.basic.DbT3113RiyoshaFutanWariaiDac;
import jp.co.ndensan.reams.db.dbd.persistence.db.basic.DbT3114RiyoshaFutanWariaiMeisaiDac;
import jp.co.ndensan.reams.db.dbd.persistence.db.basic.DbT3115RiyoshaFutanWariaiKonkyoDac;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 利用者負担割合のデータアクセスクラスです。
 *
 * @reamsid_L DBC-5010-011 zhaowei
 */
public class RiyoshaFutanWariaiSokujiKouseiManager {

    private final DbT3113RiyoshaFutanWariaiDac 利用者負担割合Dac;
    private final DbT3114RiyoshaFutanWariaiMeisaiDac 利用者負担割合明細Dac;
    private final DbT3115RiyoshaFutanWariaiKonkyoDac 利用者負担割合根拠Dac;

    /**
     * コンストラクタです。
     */
    RiyoshaFutanWariaiSokujiKouseiManager() {
        this.利用者負担割合Dac = InstanceProvider.create(DbT3113RiyoshaFutanWariaiDac.class);
        this.利用者負担割合明細Dac = InstanceProvider.create(DbT3114RiyoshaFutanWariaiMeisaiDac.class);
        this.利用者負担割合根拠Dac = InstanceProvider.create(DbT3115RiyoshaFutanWariaiKonkyoDac.class);
    }

    /**
     * 単体テスト用のコンストラクタです。
     *
     * @param 利用者負担割合Dac 利用者負担割合Dac
     * @param 利用者負担割合明細Dac 利用者負担割合明細Dac
     * @param 利用者負担割合根拠Dac 利用者負担割合根拠Dac
     */
    RiyoshaFutanWariaiSokujiKouseiManager(
            DbT3113RiyoshaFutanWariaiDac 利用者負担割合Dac,
            DbT3114RiyoshaFutanWariaiMeisaiDac 利用者負担割合明細Dac,
            DbT3115RiyoshaFutanWariaiKonkyoDac 利用者負担割合根拠Dac
    ) {
        this.利用者負担割合Dac = 利用者負担割合Dac;
        this.利用者負担割合明細Dac = 利用者負担割合明細Dac;
        this.利用者負担割合根拠Dac = 利用者負担割合根拠Dac;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link RiyoshaFutanWariaiSokujiKouseiManager}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link RiyoshaFutanWariaiSokujiKouseiManager}のインスタンス
     */
    public static RiyoshaFutanWariaiSokujiKouseiManager createInstance() {
        return InstanceProvider.create(RiyoshaFutanWariaiSokujiKouseiManager.class);
    }

    /**
     * Max履歴番号を取得します。
     *
     * @param 年度 Nendo
     * @param 被保険者番号 HihokenshaNo
     *
     * @return RiyoshaFutanWariai
     */
    public RiyoshaFutanWariai selectMax履歴番号(FlexibleYear 年度, HihokenshaNo 被保険者番号) {
        return new RiyoshaFutanWariai(利用者負担割合Dac.selectMax履歴番号(年度, 被保険者番号));
    }

    /**
     * Max履歴番号を取得します。
     *
     * @param 年度 Nendo
     * @param 被保険者番号 HihokenshaNo
     *
     * @return List<DbT3113RiyoshaFutanWariaiEntity>
     */
    public List<RiyoshaFutanWariai> selectBy年度と被保険者番号(FlexibleYear 年度, HihokenshaNo 被保険者番号) {
        List<DbT3113RiyoshaFutanWariaiEntity> list = 利用者負担割合Dac.selectBy年度と被保険者番号(年度, 被保険者番号);
        List<RiyoshaFutanWariai> resultList = new ArrayList<>();
        for (DbT3113RiyoshaFutanWariaiEntity entity : list) {
            resultList.add(new RiyoshaFutanWariai(entity));
        }
        return resultList;
    }

    /**
     * 利用者負担割合と利用者負担割合明細一覧と利用者負担割合根拠一覧を保存します。
     *
     * @param 利用者負担割合 RiyoshaFutanWariai
     * @param 利用者負担割合明細一覧 List<RiyoshaFutanWariaiMeisai>
     * @param 利用者負担割合根拠一覧 List<RiyoshaFutanWariaiKonkyo>
     */
    @Transaction
    public void save(RiyoshaFutanWariai 利用者負担割合,
            List<RiyoshaFutanWariaiMeisai> 利用者負担割合明細一覧,
            List<RiyoshaFutanWariaiKonkyo> 利用者負担割合根拠一覧) {
        requireNonNull(利用者負担割合, UrSystemErrorMessages.値がnull.getReplacedMessage("利用者負担割合"));
        利用者負担割合Dac.save(利用者負担割合.toEntity());
        if (利用者負担割合明細一覧 != null && !利用者負担割合明細一覧.isEmpty()) {
            for (RiyoshaFutanWariaiMeisai 利用者負担割合明細 : 利用者負担割合明細一覧) {
                利用者負担割合明細Dac.save(利用者負担割合明細.toEntity());
            }
        }
        if (利用者負担割合根拠一覧 != null && !利用者負担割合根拠一覧.isEmpty()) {
            for (RiyoshaFutanWariaiKonkyo 利用者負担割合根拠 : 利用者負担割合根拠一覧) {
                利用者負担割合根拠Dac.save(利用者負担割合根拠.toEntity());
            }
        }
    }
}
