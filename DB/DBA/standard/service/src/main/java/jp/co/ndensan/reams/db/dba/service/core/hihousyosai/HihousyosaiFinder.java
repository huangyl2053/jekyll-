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
import jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5051KoseiShichosonMasterEntity;
import jp.co.ndensan.reams.db.dbe.persistence.db.basic.DbT5051KoseiShichosonMasterDac;
import jp.co.ndensan.reams.db.dbz.business.core.HihokenshaDaicho;
import jp.co.ndensan.reams.db.dbz.business.core.koseishichosonmaster.koseishichosonmaster.KoseiShichosonMaster;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1001HihokenshaDaichoEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT1001HihokenshaDaichoDac;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 被保詳細クラスです。
 */
public class HihousyosaiFinder {

    private final DbT5051KoseiShichosonMasterDac dbT5051Dac;
    private final DbT1001HihokenshaDaichoDac dbT1001Dac;

    public HihousyosaiFinder() {
        dbT5051Dac = InstanceProvider.create(DbT5051KoseiShichosonMasterDac.class);
        dbT1001Dac = InstanceProvider.create(DbT1001HihokenshaDaichoDac.class);
    }

    HihousyosaiFinder(DbT5051KoseiShichosonMasterDac dbT5051Dac,
            DbT1001HihokenshaDaichoDac dbT1001dac
    ) {
        this.dbT5051Dac = dbT5051Dac;
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
    //TODO 袁献辉 20151120, QA未回復
    @Transaction
    public List<KoseiShichosonMaster> getKoseiShichosonMasterList(RDate systemDate) {

        List<KoseiShichosonMaster> businessList = new ArrayList<>();

        List<DbT5051KoseiShichosonMasterEntity> entityList = dbT5051Dac.selectByGappeiKyuShichosonKubun(systemDate);
        if (entityList.isEmpty()) {
            return new ArrayList<>();
        }
        for (DbT5051KoseiShichosonMasterEntity entity : entityList) {
            businessList.add((KoseiShichosonMaster) entityList);
        }

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
