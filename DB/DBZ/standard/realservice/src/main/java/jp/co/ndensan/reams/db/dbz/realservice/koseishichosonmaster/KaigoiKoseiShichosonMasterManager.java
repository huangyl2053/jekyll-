/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.realservice.koseishichosonmaster;

import java.util.List;
import jp.co.ndensan.reams.db.dbz.business.koseishichosonmaster.IKoseiShichosonMaster;
import jp.co.ndensan.reams.db.dbz.business.koseishichosonmaster.KaigoKoseiShichosonMaster;
import jp.co.ndensan.reams.db.dbz.definition.util.itemlist.IItemList;
import jp.co.ndensan.reams.db.dbz.definition.util.itemlist.ItemList;
import jp.co.ndensan.reams.db.dbz.definition.util.optional.Optional;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7051KoseiShichosonMasterEntity;
import jp.co.ndensan.reams.db.dbz.entity.relate.IKoseiShichosonMasterEntity;
import jp.co.ndensan.reams.db.dbz.persistence.basic.DbT7051KoseiShichosonMasterDac;
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
     * 構成市町村マスタ情報を取得します。
     *
     * @param 市町村識別ID 市町村識別ID
     * @return 構成市町村マスタ情報
     */
    @Override
    public Optional<IKoseiShichosonMaster> find構成市町村(RString 市町村識別ID) {
        // TODO n8300姜 ビルドエラー回避のために暫定対応
        DbT7051KoseiShichosonMasterEntity t = dac.selectByKey(市町村識別ID);
        IKoseiShichosonMaster r = new KaigoKoseiShichosonMaster(t);
        return Optional.ofNullable(r);
//        return dac.selectByKey(市町村識別ID)
//                .map(new IFunction<DbT7051KoseiShichosonMasterEntity, IKoseiShichosonMaster>() {
//                    @Override
//                    public IKoseiShichosonMaster apply(DbT7051KoseiShichosonMasterEntity t) {
//                        return new KaigoKoseiShichosonMaster(t);
//                    }
//                });
    }

    /**
     * 構成市町村マスタ情報を取得します。
     *
     * @return 構成市町村マスタ情報
     */
    @Override
    public IItemList<IKoseiShichosonMaster> findAll構成市町村() {
        // TODO n8300姜 ビルドエラー回避のために暫定対応
        List<DbT7051KoseiShichosonMasterEntity> entitylist = dac.selectAll();
        IItemList<IKoseiShichosonMaster> iItemList = ItemList.empty();
        for (DbT7051KoseiShichosonMasterEntity entity : entitylist) {
            IKoseiShichosonMaster r = new KaigoKoseiShichosonMaster(entity);
            iItemList.added(r);

        }
        return iItemList;
//        return dac.selectAll()
//                .map(new IFunction<DbT7051KoseiShichosonMasterEntity, IKoseiShichosonMaster>() {
//                    @Override
//                    public IKoseiShichosonMaster apply(DbT7051KoseiShichosonMasterEntity t) {
//                        return new KaigoKoseiShichosonMaster(t);
//                    }
//                });
    }

    /**
     * 証記載保険者番号を市町村コードへ読み替える構成市町村マスタ情報を取得します。
     *
     * @param 証記載保険者番号 証記載保険者番号
     * @return 構成市町村マスタ情報
     */
    @Override
    public Optional<IKoseiShichosonMaster> find構成市町村by証記載保険者番号(ShoKisaiHokenshaNo 証記載保険者番号) {
        // TODO n8300姜 ビルドエラー回避のために暫定対応
        DbT7051KoseiShichosonMasterEntity t = dac.selectByKey(証記載保険者番号.value());
        IKoseiShichosonMaster r = new KaigoKoseiShichosonMaster(t);
        return Optional.ofNullable(r);
//        return dac.selectByKey(証記載保険者番号.value())
//                .map(new IFunction<DbT7051KoseiShichosonMasterEntity, IKoseiShichosonMaster>() {
//                    @Override
//                    public IKoseiShichosonMaster apply(DbT7051KoseiShichosonMasterEntity t) {
//                        return new KaigoKoseiShichosonMaster(t);
//                    }
//                });
    }

    /**
     * 市町村コードを証記載保険者番号へ読み替える構成市町村マスタ情報を取得します。
     *
     * @param 市町村コード 市町村コード
     * @return 構成市町村マスタ情報
     */
    @Override
    public Optional<IKoseiShichosonMaster> find構成市町村by市町村コード(LasdecCode 市町村コード) {
        // TODO n8300姜 ビルドエラー回避のために暫定対応
        DbT7051KoseiShichosonMasterEntity t = dac.selectByKey(市町村コード.value());
        IKoseiShichosonMaster r = new KaigoKoseiShichosonMaster(t);
        return Optional.ofNullable(r);
//        return dac.selectByKey(市町村コード.value())
//                .map(new IFunction<DbT7051KoseiShichosonMasterEntity, IKoseiShichosonMaster>() {
//                    @Override
//                    public IKoseiShichosonMaster apply(DbT7051KoseiShichosonMasterEntity t) {
//                        return new KaigoKoseiShichosonMaster(t);
//                    }
//                });
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

        // TODO n8300姜 save処理については再検討
        switch (構成市町村情報.getState()) {
            case Added:
//                return dac.insert(entity);
            case Modified:
//                return dac.update(entity);
            case Deleted:
//                return dac.delete(entity);
                return 1;
            default:
                return 0;
        }
    }

}
