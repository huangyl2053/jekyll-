/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.service.core.hihousyosai;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dba.definition.core.shikakukubun.HihousyosaiFinderParameter;
import jp.co.ndensan.reams.db.dba.definition.core.shikakukubun.ShikakuKubun;
import jp.co.ndensan.reams.db.dbz.business.core.HihokenshaDaicho;
import jp.co.ndensan.reams.db.dbz.business.core.koseishichosonmaster.koseishichosonmaster.KoseiShichosonMaster;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1001HihokenshaDaichoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7051KoseiShichosonMasterEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT1001HihokenshaDaichoDac;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT7051KoseiShichosonMasterDac;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 被保詳細のクラスです。
 */
public class HihousyosaiFinder {

    private final DbT7051KoseiShichosonMasterDac dbT7051Dac;
    private final DbT1001HihokenshaDaichoDac dbT1001Dac;

    public HihousyosaiFinder() {
        dbT7051Dac = InstanceProvider.create(DbT7051KoseiShichosonMasterDac.class);
        dbT1001Dac = InstanceProvider.create(DbT1001HihokenshaDaichoDac.class);
    }

    HihousyosaiFinder(
            DbT7051KoseiShichosonMasterDac dbT7051Dac,
            DbT1001HihokenshaDaichoDac dbT1001dac
    ) {
        this.dbT7051Dac = dbT7051Dac;
        this.dbT1001Dac = dbT1001dac;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link HihousyosaiFinder}のインスタンスを返します。
     *
     * @return{@link InstanceProvider#create}にて生成した{@link HihousyosaiFinder}のインスタンス
     */
    public static HihousyosaiFinder createInstance() {
        return InstanceProvider.create(HihousyosaiFinder.class);
    }

    /**
     * 所在保険者リスト情報取得。
     *
     * @param systemDate RDate
     * @return List<KoseiShichosonMaster>
     */
    @Transaction
    public List<KoseiShichosonMaster> getKoseiShichosonMasterList(RDate systemDate) {

        List<KoseiShichosonMaster> businessList = new ArrayList<>();

        List<DbT7051KoseiShichosonMasterEntity> entityList = dbT7051Dac.selectByGappeiKyuShichosonKubun(systemDate);
        if (entityList.isEmpty()) {
            return new ArrayList<>();
        }
        businessList.add((KoseiShichosonMaster) entityList);
        return businessList;
    }

    /**
     * 旧保険者リスト情報取得します。
     *
     * @return List<Shichoson>
     */
    //TODO 袁献辉 20151118,12月対応対象
//    @Transaction
//    public List<Shichoson> getGappeiShichosonList(RString 市町村コード) {
//        return null;
//    }
    /**
     * 得喪情報取得。
     *
     * @param paramenter
     * @param 被保険者番号 hihokenshaNo
     * @param 異動日 idoYMD
     * @param 枝番 edaNo
     * @return 被保険者台帳管理オブジェクト HihokenshaDaicho
     */
    @Transaction
    public HihokenshaDaicho getTokusouJoho(HihousyosaiFinderParameter paramenter) {
        DbT1001HihokenshaDaichoEntity entity = dbT1001Dac.selectByHihokenshaNo(
                paramenter.getHihokenshaNo(),
                paramenter.getIdoYMD(),
                paramenter.getEdaNo());
        if (entity == null) {
            return null;
        }

        return new HihokenshaDaicho(entity);
    }

    /**
     * 被保区分リスト情報取得。
     *
     * @param 被保険者番号 hihokenshaNo
     *
     * @return List<ShikakuKubun>
     */
    @Transaction
    public List<ShikakuKubun> getHihokubunList(RString code) {
        List<ShikakuKubun> list = new ArrayList<>();
        ShikakuKubun enumList = ShikakuKubun.toValue(code);
        list.add(enumList);
        return list;
    }
}
