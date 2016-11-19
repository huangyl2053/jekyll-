/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.kogakugassan;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.business.core.basic.KogakuGassanShikyugakuKeisanKekkaMeisai;
import jp.co.ndensan.reams.db.dbc.business.core.kogaku.KogakuGassanShikyuGakuKeisanKekkaRelate;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3072KogakuGassanShikyuGakuKeisanKekkaEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3073KogakuGassanShikyugakuKeisanKekkaMeisaiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc110070.KogakuGassanShikyuGakuKeisanKekkaRelateEntity;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3072KogakuGassanShikyuGakuKeisanKekkaDac;
import jp.co.ndensan.reams.db.dbc.service.core.basic.KogakuGassanShikyugakuKeisanKekkaMeisaiManager;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 高額合算支給額計算結果登録のクラスです。
 *
 * @reamsid_L DBC-2040-010 huzongcheng
 */
public class KogakuGassanShikyuShinseiTorokuManager {

    private final DbT3072KogakuGassanShikyuGakuKeisanKekkaDac 高額合算支給額計算結果Dac;
    private final KogakuGassanShikyugakuKeisanKekkaMeisaiManager 高額合算支給額計算結果明細Manager;

    /**
     * コンストラクタです。
     */
    KogakuGassanShikyuShinseiTorokuManager() {
        this.高額合算支給額計算結果Dac = InstanceProvider.create(DbT3072KogakuGassanShikyuGakuKeisanKekkaDac.class);
        this.高額合算支給額計算結果明細Manager = InstanceProvider.create(KogakuGassanShikyugakuKeisanKekkaMeisaiManager.class);
    }

    /**
     * 単体テスト用のコンストラクタです。
     *
     * @param 高額合算支給額計算結果Dac 高額合算支給額計算結果Dac
     * @param 高額合算支給額計算結果明細Manager 高額合算支給額計算結果明細Manager
     */
    KogakuGassanShikyuShinseiTorokuManager(
            DbT3072KogakuGassanShikyuGakuKeisanKekkaDac 高額合算支給額計算結果Dac,
            KogakuGassanShikyugakuKeisanKekkaMeisaiManager 高額合算支給額計算結果明細Manager
    ) {
        this.高額合算支給額計算結果Dac = 高額合算支給額計算結果Dac;
        this.高額合算支給額計算結果明細Manager = 高額合算支給額計算結果明細Manager;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link KogakuGassanShikyuShinseiTorokuManager}のインスタンスを返します。
     *
     * @return
     * {@link InstanceProvider#create}にて生成した{@link KogakuGassanShikyuShinseiTorokuManager}のインスタンス
     */
    public static KogakuGassanShikyuShinseiTorokuManager createInstance() {
        return InstanceProvider.create(KogakuGassanShikyuShinseiTorokuManager.class);
    }

    /**
     * 追加処理を保存します。
     *
     * @param 高額合算支給額計算結果情報 KogakuGassanShikyuGakuKeisanKekkaRelate
     */
    @Transaction
    public void saveAdd(KogakuGassanShikyuGakuKeisanKekkaRelate 高額合算支給額計算結果情報) {
        requireNonNull(高額合算支給額計算結果情報, UrSystemErrorMessages.値がnull.getReplacedMessage("高額合算支給額計算結果情報"));
        if (!高額合算支給額計算結果情報.hasChanged()) {
            return;
        }
        if (高額合算支給額計算結果情報.get高額合算支給額計算結果list() != null) {
            for (KogakuGassanShikyugakuKeisanKekkaMeisai 明細 : 高額合算支給額計算結果情報.get高額合算支給額計算結果list()) {
                高額合算支給額計算結果明細Manager.save高額合算支給額計算結果明細(明細);
            }
        }
        高額合算支給額計算結果Dac.save(高額合算支給額計算結果情報.toEntity());
    }

    /**
     * 修正処理を保存します。
     *
     * @param 高額合算支給額計算結果情報 KogakuGassanShikyuGakuKeisanKekkaRelate
     */
    @Transaction
    public void saveModify(KogakuGassanShikyuGakuKeisanKekkaRelate 高額合算支給額計算結果情報) {
        requireNonNull(高額合算支給額計算結果情報, UrSystemErrorMessages.値がnull.getReplacedMessage("高額合算支給額計算結果情報"));
        if (高額合算支給額計算結果情報.get高額合算支給額計算結果list() != null) {
            for (KogakuGassanShikyugakuKeisanKekkaMeisai 明細 : 高額合算支給額計算結果情報.get高額合算支給額計算結果list()) {
                高額合算支給額計算結果明細Manager.save高額合算支給額計算結果明細(明細.deleted());
            }
        }
        高額合算支給額計算結果Dac.save(高額合算支給額計算結果情報.deleted().toEntity());
        DbT3072KogakuGassanShikyuGakuKeisanKekkaEntity 計算結果Entity = 高額合算支給額計算結果情報.toEntity();
        計算結果Entity.setRirekiNo(計算結果Entity.getRirekiNo() + 1);
        計算結果Entity.setState(EntityDataState.Added);
        高額合算支給額計算結果Dac.save(計算結果Entity);
        if (高額合算支給額計算結果情報.get高額合算支給額計算結果list() != null) {
            int 明細番号 = 1;
            for (KogakuGassanShikyugakuKeisanKekkaMeisai 明細 : 高額合算支給額計算結果情報.get高額合算支給額計算結果list()) {
                if (!EntityDataState.Deleted.equals(明細.toEntity().getState())) {
                    DbT3073KogakuGassanShikyugakuKeisanKekkaMeisaiEntity 明細Entity = 明細.toEntity();
                    明細Entity.setRirekiNo(明細Entity.getRirekiNo().add(Decimal.ONE));
                    明細Entity.setMeisanNo(new RString(明細番号));
                    明細Entity.setState(EntityDataState.Added);
                    高額合算支給額計算結果明細Manager.save高額合算支給額計算結果明細(new KogakuGassanShikyugakuKeisanKekkaMeisai(明細Entity));
                    明細番号++;
                }
            }
        }
    }

    /**
     * 削除処理を保存します。
     *
     * @param 高額合算支給額計算結果情報 KogakuGassanShikyuGakuKeisanKekkaRelate
     */
    @Transaction
    public void saveDelete(KogakuGassanShikyuGakuKeisanKekkaRelate 高額合算支給額計算結果情報) {
        requireNonNull(高額合算支給額計算結果情報, UrSystemErrorMessages.値がnull.getReplacedMessage("高額合算支給額計算結果情報"));
        if (高額合算支給額計算結果情報.get高額合算支給額計算結果list() != null) {
            for (KogakuGassanShikyugakuKeisanKekkaMeisai 明細 : 高額合算支給額計算結果情報.get高額合算支給額計算結果list()) {
                高額合算支給額計算結果明細Manager.save高額合算支給額計算結果明細(明細.deleted());
            }
        }
        高額合算支給額計算結果Dac.save(高額合算支給額計算結果情報.deleted().toEntity());
    }

    /**
     * get高額合算支給額計算結果追加情報。
     *
     * @param 支給額計算結果明細 KogakuGassanShikyugakuKeisanKekkaMeisai
     * @param 支給額計算結果 KogakuGassanShikyuGakuKeisanKekkaRelate
     *
     * @return 高額合算支給額計算結果追加情報
     */
    public KogakuGassanShikyuGakuKeisanKekkaRelate get高額合算支給額計算結果追加情報(KogakuGassanShikyugakuKeisanKekkaMeisai 支給額計算結果明細,
            KogakuGassanShikyuGakuKeisanKekkaRelate 支給額計算結果) {
        List<DbT3073KogakuGassanShikyugakuKeisanKekkaMeisaiEntity> 高額合算支給額計算結果明細リスト = new ArrayList();
        高額合算支給額計算結果明細リスト.add(支給額計算結果明細.toEntity());
        KogakuGassanShikyuGakuKeisanKekkaRelateEntity entity = new KogakuGassanShikyuGakuKeisanKekkaRelateEntity();
        entity.set高額合算支給額計算結果(支給額計算結果.toEntity());
        entity.set高額合算支給額計算結果明細リスト(高額合算支給額計算結果明細リスト);
        支給額計算結果 = new KogakuGassanShikyuGakuKeisanKekkaRelate(entity);
        return 支給額計算結果;
    }
}
