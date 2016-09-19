/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.saishinsamoshitatetouroku;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.business.core.basic.SaishinsaMoshitate;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3062SaishinsaMoshitateEntity;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3062SaishinsaMoshitateDac;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceKomokuCode;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 再審査申立を管理するクラスです。
 *
 * @reamsid_L DBC-2230-010 chenxiangyu
 */
public class SaishinsaMoshitateManager {

    private final DbT3062SaishinsaMoshitateDac dac;

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link DbT3062SaishinsaMoshitateDac}
     */
    public SaishinsaMoshitateManager(DbT3062SaishinsaMoshitateDac dac) {
        this.dac = dac;
    }

    /**
     * コンストラクタです。
     */
    public SaishinsaMoshitateManager() {
        dac = InstanceProvider.create(DbT3062SaishinsaMoshitateDac.class);
    }

    /**
     * 再審査申立{@link SaishinsaMoshitate}を保存します。
     *
     * @param 再審査申立 {@link SaishinsaMoshitate}
     * @return 更新結果
     */
    @Transaction
    public boolean addOrDelete再審査申立(SaishinsaMoshitate 再審査申立) {
        requireNonNull(再審査申立, UrSystemErrorMessages.値がnull.getReplacedMessage("再審査申立"));
        return 1 == dac.saveOrDeletePhysicalBy(再審査申立.toEntity());
    }

    /**
     * 再審査申立{@link SaishinsaMoshitate}を保存します。
     *
     * @param 再審査申立 {@link SaishinsaMoshitate}
     * @param サービス種類コード 更新のサービス種類コード
     * @param サービス項目コード 更新のサービス項目コード
     * @return 更新結果
     */
    @Transaction
    public boolean update再審査申立(
            SaishinsaMoshitate 再審査申立,
            ServiceShuruiCode サービス種類コード,
            ServiceKomokuCode サービス項目コード) {
        boolean successFlag = false;
        requireNonNull(再審査申立, UrSystemErrorMessages.値がnull.getReplacedMessage("再審査申立"));
        DbT3062SaishinsaMoshitateEntity 再審査申立Entity = 再審査申立.toEntity();
        再審査申立Entity.setState(EntityDataState.Deleted);
        if (1 == dac.saveOrDeletePhysicalBy(再審査申立Entity)) {
            再審査申立Entity.setServiceTeikyoShuruiCode(サービス種類コード);
            再審査申立Entity.setServiceKomokuCode(サービス項目コード);
            再審査申立Entity.setState(EntityDataState.Added);
            successFlag = (1 == dac.save(再審査申立Entity));
        }
        return successFlag;
    }
}
