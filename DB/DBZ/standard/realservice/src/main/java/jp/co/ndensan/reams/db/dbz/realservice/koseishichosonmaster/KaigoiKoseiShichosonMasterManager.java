/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.realservice.koseishichosonmaster;

import jp.co.ndensan.reams.db.dbz.business.koseishichosonmaster.IKoseiShichosonMaster;
import jp.co.ndensan.reams.db.dbz.business.koseishichosonmaster.KaigoKoseiShichosonMaster;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7051KoseiShichosonMasterEntity;
import jp.co.ndensan.reams.db.dbz.persistence.basic.DbT7051KoseiShichosonMasterDac;
import jp.co.ndensan.reams.db.dbz.definition.util.function.IFunction;
import jp.co.ndensan.reams.db.dbz.definition.util.optional.Optional;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 構成市町村マスタ情報を管理するクラスです。
 *
 * @author n8223　朴義一
 */
public class KaigoiKoseiShichosonMasterManager extends KoseiShichosonMasterManagerBase {

    private final DbT7051KoseiShichosonMasterDac dac;

    /**
     * コンストラクタです。
     */
    public KaigoiKoseiShichosonMasterManager() {
        this.dac = InstanceProvider.create(DbT7051KoseiShichosonMasterDac.class);
    }

    /**
     * 単体テスト用のコンストラクタです。
     */
    KaigoiKoseiShichosonMasterManager(DbT7051KoseiShichosonMasterDac dac) {
        this.dac = dac;
    }

    /**
     * 市町村識別IDより構成市町村マスタ情報を取得します。
     *
     * @param 市町村識別ID 市町村識別ID
     * @return 構成市町村マスタ情報
     */
    @Override
    public Optional<IKoseiShichosonMaster> find構成市町村(RString 市町村識別ID) {
        return dac.selectByKey(市町村識別ID)
                .map(new IFunction<DbT7051KoseiShichosonMasterEntity, IKoseiShichosonMaster>() {
                    @Override
                    public IKoseiShichosonMaster apply(DbT7051KoseiShichosonMasterEntity t) {
                        return new KaigoKoseiShichosonMaster(t);
                    }
                });
    }

    /**
     * 証記載保険者番号より構成市町村マスタ情報を取得します。
     *
     * @param 証記載保険者番号 証記載保険者番号
     * @return 構成市町村マスタ情報
     */
    @Override
    public Optional<IKoseiShichosonMaster> find構成市町村(ShoKisaiHokenshaNo 証記載保険者番号) {
        return dac.selectByKey(証記載保険者番号)
                .map(new IFunction<DbT7051KoseiShichosonMasterEntity, IKoseiShichosonMaster>() {
                    @Override
                    public IKoseiShichosonMaster apply(DbT7051KoseiShichosonMasterEntity t) {
                        return new KaigoKoseiShichosonMaster(t);
                    }
                });
    }

    /**
     * 証記載保険者番号より構成市町村マスタ情報を取得します。
     *
     * @param 市町村コード 市町村コード
     * @return 構成市町村マスタ情報
     */
    @Override
    public Optional<IKoseiShichosonMaster> find構成市町村(LasdecCode 市町村コード) {
        return dac.selectByKey(市町村コード)
                .map(new IFunction<DbT7051KoseiShichosonMasterEntity, IKoseiShichosonMaster>() {
                    @Override
                    public IKoseiShichosonMaster apply(DbT7051KoseiShichosonMasterEntity t) {
                        return new KaigoKoseiShichosonMaster(t);
                    }
                });
    }

}
