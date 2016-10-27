/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.saishinsamoshitatetouroku;

import java.util.List;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBU;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.DonyuKeitaiCode;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7051KoseiShichosonMasterEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7056GappeiShichosonEntity;
import jp.co.ndensan.reams.db.dbx.persistence.db.basic.DbT7051KoseiShichosonMasterDac;
import jp.co.ndensan.reams.db.dbx.persistence.db.basic.DbT7056GappeiShichosonDac;
import jp.co.ndensan.reams.db.dbx.service.core.shichosonsecurityjoho.ShichosonSecurityJoho;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 証記載保険者名の取得クラスです。
 *
 * @reamsid_L DBC-2230-010 chenxiangyu
 */
public class ShoKisaiHokenshameiFinder {

    private final DbT7051KoseiShichosonMasterDac dbt7051Dac;
    private final DbT7056GappeiShichosonDac dbt7056Dac;
    private static final int ZERO = 0;

    /**
     * コンストラクタです。
     */
    public ShoKisaiHokenshameiFinder() {
        this.dbt7051Dac = InstanceProvider.create(DbT7051KoseiShichosonMasterDac.class);
        this.dbt7056Dac = InstanceProvider.create(DbT7056GappeiShichosonDac.class);
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link ShoKisaiHokenshameiFinder}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link ShoKisaiHokenshameiFinder}のインスタンス
     */
    public static ShoKisaiHokenshameiFinder createInstance() {
        return InstanceProvider.create(ShoKisaiHokenshameiFinder.class);
    }

    /**
     * 証記載保険者名を取得します。
     *
     * @param 保険者番号 保険者番号
     * @return 証記載保険者名
     */
    public RString get名称(RString 保険者番号) {
        if (RString.isNullOrEmpty(保険者番号)) {
            return RString.EMPTY;
        }
        RString 証記載保険者名 = RString.EMPTY;
        RString 導入形態コード = ShichosonSecurityJoho
                .getShichosonSecurityJoho(GyomuBunrui.介護事務).get導入形態コード().value();
        if (DonyuKeitaiCode.事務単一.getCode().equals(導入形態コード)) {
            if (保険者番号.equals(DbBusinessConfig.get(
                    ConfigNameDBU.保険者情報_保険者番号, RDate.getNowDate(), SubGyomuCode.DBU介護統計報告))) {
                return DbBusinessConfig.get(
                        ConfigNameDBU.保険者情報_保険者名称, RDate.getNowDate(), SubGyomuCode.DBU介護統計報告);
            }
            List<DbT7056GappeiShichosonEntity> 旧市町村 = dbt7056Dac.get旧市町村名称(保険者番号);
            if (旧市町村 != null && !旧市町村.isEmpty()) {
                証記載保険者名 = 旧市町村.get(ZERO).getKyuShichosonMeisho();
            }
        } else if (DonyuKeitaiCode.事務広域.getCode().equals(導入形態コード)) {
            List<DbT7051KoseiShichosonMasterEntity> 旧市町村 = dbt7051Dac.get市町村情報(保険者番号);
            if (旧市町村 != null && !旧市町村.isEmpty()) {
                証記載保険者名 = 旧市町村.get(ZERO).getShichosonMeisho();
            }
        }
        return 証記載保険者名;
    }
}
