/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.service.core.basic.kaigoninteishikakuinfo;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.persistence.db.basic.DbT7051KoseiShichosonMasterDac;
import jp.co.ndensan.reams.db.dbz.business.core.kaigoninteishikakuinfo.KaigoNinteiShikakuInfoBusiness;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1001HihokenshaDaichoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4001JukyushaDaichoEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT1001HihokenshaDaichoDac;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT4001JukyushaDaichoDac;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 介護認定資格情報を管理するクラスです。
 */
public class KaigoNinteiShikakuInfoFinder {

    private final DbT7051KoseiShichosonMasterDac dbt7051dac;
    private final DbT4001JukyushaDaichoDac dbt4001dac;
    private final DbT1001HihokenshaDaichoDac dbt1001dac;

    /**
     * コンストラクタです。
     */
    KaigoNinteiShikakuInfoFinder() {
        this.dbt7051dac = InstanceProvider.create(DbT7051KoseiShichosonMasterDac.class);
        this.dbt4001dac = InstanceProvider.create(DbT4001JukyushaDaichoDac.class);
        this.dbt1001dac = InstanceProvider.create(DbT1001HihokenshaDaichoDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param DbT7051KoseiShichosonMasterDac
     * @param DbT4001JukyushaDaichoDac
     * @param DbT1001HihokenshaDaichoDac
     */
    KaigoNinteiShikakuInfoFinder(
            DbT7051KoseiShichosonMasterDac dbt7051dac,
            DbT4001JukyushaDaichoDac dbt4001dac,
            DbT1001HihokenshaDaichoDac dbt1001dac) {
        this.dbt7051dac = dbt7051dac;
        this.dbt4001dac = dbt4001dac;
        this.dbt1001dac = dbt1001dac;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link KaigoNinteiShikakuInfoFinder}のインスタンスを返します。
     *
     * @return
     * {@link InstanceProvider#create}にて生成した{@link KaigoNinteiShikakuInfoFinder}のインスタンス
     */
    public static KaigoNinteiShikakuInfoFinder createInstance() {
        return InstanceProvider.create(KaigoNinteiShikakuInfoFinder.class);
    }

    /**
     * 被保険者台帳情報を取得します。
     *
     * @param hihokenshaNo 被保険者番号
     * @param shichosonCode 市町村コード
     * @return SearchResult<KaigoNinteiShikakuInfoBusiness> 介護認定資格情報
     */
    public KaigoNinteiShikakuInfoBusiness getKaigoNinteiShikakuInfo(HihokenshaNo hihokenshaNo, LasdecCode shichosonCode) {
        DbT1001HihokenshaDaichoEntity dbT1001HihokenshaDaichoEntity = dbt1001dac.selectByHihokensha(hihokenshaNo);
        DbT4001JukyushaDaichoEntity dbT4001JukyushaDaichoEntity = dbt4001dac.selectByHihokenshaNo(hihokenshaNo, shichosonCode);
        KaigoNinteiShikakuInfoBusiness business = new KaigoNinteiShikakuInfoBusiness(dbT4001JukyushaDaichoEntity, dbT1001HihokenshaDaichoEntity);
        return business;
    }
}
