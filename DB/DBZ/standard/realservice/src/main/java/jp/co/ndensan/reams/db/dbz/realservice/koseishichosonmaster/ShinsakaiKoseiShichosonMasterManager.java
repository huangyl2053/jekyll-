/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.realservice.koseishichosonmaster;

import jp.co.ndensan.reams.db.dbz.business.koseishichosonmaster.IKoseiShichosonMaster;
import jp.co.ndensan.reams.db.dbz.business.koseishichosonmaster.ShinsakaiKoseiShichosonMaster;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT5051KoseiShichosonMasterEntity;
import jp.co.ndensan.reams.db.dbz.persistence.basic.DbT5051KoseiShichosonMasterDac;
import jp.co.ndensan.reams.db.dbz.definition.util.function.IFunction;
import jp.co.ndensan.reams.db.dbz.definition.util.itemlist.IItemList;
import jp.co.ndensan.reams.db.dbz.definition.util.optional.Optional;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.relate.IKoseiShichosonMasterEntity;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 構成市町村マスタ情報を作成するクラスです。
 *
 * @author n8223　朴義一
 */
public class ShinsakaiKoseiShichosonMasterManager extends KoseiShichosonMasterManagerBase {

    private final DbT5051KoseiShichosonMasterDac dac;

    /**
     * コンストラクタです。
     *
     */
    public ShinsakaiKoseiShichosonMasterManager() {
        this.dac = InstanceProvider.create(DbT5051KoseiShichosonMasterDac.class);
    }

    /**
     * 単体テスト用のコンストラクタです。
     */
    ShinsakaiKoseiShichosonMasterManager(DbT5051KoseiShichosonMasterDac dac) {
        this.dac = dac;
    }

    /**
     * 構成市町村マスタ情報を取得します。
     *
     * @param 市町村識別ID 市町村識別ID
     * @return 構成市町村マスタ情報
     */
    @Override
    public Optional<IKoseiShichosonMaster> find構成市町村(RString 市町村識別ID) {
        return dac.selectByKey(市町村識別ID)
                .map(new IFunction<DbT5051KoseiShichosonMasterEntity, IKoseiShichosonMaster>() {
                    @Override
                    public IKoseiShichosonMaster apply(DbT5051KoseiShichosonMasterEntity t) {
                        return new ShinsakaiKoseiShichosonMaster(t);
                    }
                });
    }

    /**
     * 構成市町村マスタ情報を取得します。
     *
     * @return 構成市町村マスタ情報
     */
    @Override
    public IItemList<IKoseiShichosonMaster> findAll構成市町村() {
        return dac.selectAll()
                .map(new IFunction<DbT5051KoseiShichosonMasterEntity, IKoseiShichosonMaster>() {
                    @Override
                    public IKoseiShichosonMaster apply(DbT5051KoseiShichosonMasterEntity t) {
                        return new ShinsakaiKoseiShichosonMaster(t);
                    }
                });
    }

    /**
     * 証記載保険者番号を市町村コードへ読み替える構成市町村マスタ情報を取得します。
     *
     * @param 証記載保険者番号 証記載保険者番号
     * @return 構成市町村マスタ情報
     */
    @Override
    public Optional<IKoseiShichosonMaster> find構成市町村by証記載保険者番号(ShoKisaiHokenshaNo 証記載保険者番号) {
        return dac.selectByKey(証記載保険者番号)
                .map(new IFunction<DbT5051KoseiShichosonMasterEntity, IKoseiShichosonMaster>() {
                    @Override
                    public IKoseiShichosonMaster apply(DbT5051KoseiShichosonMasterEntity t) {
                        return new ShinsakaiKoseiShichosonMaster(t);
                    }
                });
    }

    /**
     * 市町村コードを証記載保険者番号へ読み替える構成市町村マスタ情報を取得します。
     *
     * @param 市町村コード 市町村コード
     * @return 構成市町村マスタ情報
     */
    @Override
    public Optional<IKoseiShichosonMaster> find構成市町村by市町村コード(LasdecCode 市町村コード) {
        return dac.selectByKey(市町村コード)
                .map(new IFunction<DbT5051KoseiShichosonMasterEntity, IKoseiShichosonMaster>() {
                    @Override
                    public IKoseiShichosonMaster apply(DbT5051KoseiShichosonMasterEntity t) {
                        return new ShinsakaiKoseiShichosonMaster(t);
                    }
                });
    }

    /**
     * 構成市町村マスタ情報を登録します。
     *
     * @param 構成市町村情報 構成市町村情報
     * @return 登録件数
     */
    @Override
    public int save構成市町村(IKoseiShichosonMaster 構成市町村情報) {

        IKoseiShichosonMasterEntity entity = 構成市町村情報.getEntity();

        switch (構成市町村情報.getState()) {
            case Added:
                return dac.insert(entity);
            case Modified:
                return dac.update(entity);
            case Deleted:
                return dac.delete(entity);
            default:
                return 0;
        }
    }

}
