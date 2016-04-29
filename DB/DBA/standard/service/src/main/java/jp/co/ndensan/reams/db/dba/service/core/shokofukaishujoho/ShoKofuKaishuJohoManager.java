/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.service.core.shokofukaishujoho;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ShoKofuKaishu;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7037ShoKofuKaishuEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT7037ShoKofuKaishuDac;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 証交付回収情報の取得処理です。
 *
 * @reamsid_L DBA-1070-020 lizhuoxuan
 */
public class ShoKofuKaishuJohoManager {

    private final DbT7037ShoKofuKaishuDac 証交付回収情報dac;

    /**
     * コンストラクタ
     */
    ShoKofuKaishuJohoManager() {
        this.証交付回収情報dac = InstanceProvider.create(DbT7037ShoKofuKaishuDac.class);
    }

    /**
     * 単体テスト用のコンストラクタです。
     *
     * @param mapperProvider mapperProvider
     * @param 証交付回収情報dac 証交付回収情報dac
     */
    ShoKofuKaishuJohoManager(
            DbT7037ShoKofuKaishuDac 証交付回収情報dac
    ) {
        this.証交付回収情報dac = 証交付回収情報dac;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link ShoKofuKaishuJohoManager}のインスタンスを返します。
     *
     * @return
     * {@link InstanceProvider#create}にて生成した{@link ShoKofuKaishuJohoManager}のインスタンス
     */
    public static ShoKofuKaishuJohoManager createInstance() {
        return InstanceProvider.create(ShoKofuKaishuJohoManager.class);
    }

    /**
     * 証交付回収情報データを返します。
     *
     * @param 被保険者番号 HihokenshaNo
     * @param 論理削除フラグ boolean
     * @return SearchResult<ShoKofuKaishu>
     */
    @Transaction
    public SearchResult<ShoKofuKaishu> getShoKofuKaishuJohoList(HihokenshaNo 被保険者番号, boolean 論理削除フラグ) {
        List<ShoKofuKaishu> businessList = new ArrayList<>();
        List<DbT7037ShoKofuKaishuEntity> dbT7037ShoKofuKaishuEntity = 証交付回収情報dac.select一覧取得(被保険者番号, 論理削除フラグ);
        for (DbT7037ShoKofuKaishuEntity shoKofuKaishuEntity : dbT7037ShoKofuKaishuEntity) {
            businessList.add(new ShoKofuKaishu(shoKofuKaishuEntity));
        }
        return SearchResult.of(businessList, 0, false);
    }

    /**
     * 証交付回収情報{@link ShoKofuKaishu}を追加します。
     *
     * @param 証交付回収情報 {@link ShoKofuKaishu}
     * @return 追加件数 追加結果の件数を返します。
     */
    @Transaction
    public boolean 証交付回収情報の追加(ShoKofuKaishu 証交付回収情報) {
        requireNonNull(証交付回収情報,
                UrSystemErrorMessages.値がnull.getReplacedMessage("証交付回収情報"));
        if (!証交付回収情報.hasChanged()) {
            return false;
        }
        DbT7037ShoKofuKaishuEntity dbT7037Entity = 証交付回収情報.toEntity();
        dbT7037Entity.setState(EntityDataState.Added);
        return 1 == 証交付回収情報dac.save(dbT7037Entity);
    }

    /**
     * 証交付回収情報{@link ShoKofuKaishu}を削除します。
     *
     * @param 証交付回収情報 {@link ShoKofuKaishu}
     * @return 削除件数 削除結果の件数を返します。
     */
    @Transaction
    public boolean 証交付回収情報の削除(ShoKofuKaishu 証交付回収情報) {
        requireNonNull(証交付回収情報,
                UrSystemErrorMessages.値がnull.getReplacedMessage("証交付回収情報"));
        DbT7037ShoKofuKaishuEntity dbT7037Entity = 証交付回収情報.toEntity();
        dbT7037Entity.setState(EntityDataState.Deleted);
        return 1 == 証交付回収情報dac.save(dbT7037Entity);
    }

    /**
     * 証交付回収情報{@link ShoKofuKaishu}を更新します。
     *
     * @param 証交付回収情報 {@link ShoKofuKaishu}
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public boolean 証交付回収情報の更新(ShoKofuKaishu 証交付回収情報) {
        requireNonNull(証交付回収情報,
                UrSystemErrorMessages.値がnull.getReplacedMessage("証交付回収情報"));
        if (!証交付回収情報.hasChanged()) {
            return false;
        }
        DbT7037ShoKofuKaishuEntity dbT7037Entity = 証交付回収情報.toEntity();
        dbT7037Entity.setState(EntityDataState.Modified);
        return 1 == 証交付回収情報dac.save(dbT7037Entity);
    }
}
