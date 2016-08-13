/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.service.core.kouhoushajoho;

import java.util.UUID;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT4032ShinseishoIkkatsuHakkoBatchEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT4033ShinseishoHakkoTaishoshasEntity;
import jp.co.ndensan.reams.db.dbd.persistence.db.basic.DbT4032ShinseishoIkkatsuHakkoBatchDac;
import jp.co.ndensan.reams.db.dbd.persistence.db.basic.DbT4033ShinseishoHakkoTaishoDac;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * DB出力です。
 *
 * @reamsid_L DBD-3530-060 liuyl
 */
public class ShinseishoIkkatsuHakkoService {

    private final DbT4032ShinseishoIkkatsuHakkoBatchDac dbT4032Dac;
    private final DbT4033ShinseishoHakkoTaishoDac dbT4033Dac;

    /**
     * コンストラクタです。
     */
    public ShinseishoIkkatsuHakkoService() {
        this.dbT4032Dac = InstanceProvider.create(DbT4032ShinseishoIkkatsuHakkoBatchDac.class);
        this.dbT4033Dac = InstanceProvider.create(DbT4033ShinseishoHakkoTaishoDac.class);
    }

    /**
     * DB出力(申請書一括発行)。
     *
     * @param 把握処理ID UUID
     * @param 発行処理ID UUID
     */
    @Transaction
    public void insertDbT4032(UUID 把握処理ID, UUID 発行処理ID) {
        DbT4032ShinseishoIkkatsuHakkoBatchEntity entity = new DbT4032ShinseishoIkkatsuHakkoBatchEntity();
        entity.setHakkoShoriID(発行処理ID);
        entity.setHaakuShoriId(把握処理ID);
        dbT4032Dac.save(entity);
    }

    /**
     * DB出力(申請書発行対象) 。
     *
     * @param 被保険者番号 HihokenshaNo
     * @param 発行処理ID UUID
     */
    @Transaction
    public void insertDbT4033(HihokenshaNo 被保険者番号, UUID 発行処理ID) {
        DbT4033ShinseishoHakkoTaishoshasEntity entity = new DbT4033ShinseishoHakkoTaishoshasEntity();
        entity.setHihokenshaNo(被保険者番号);
        entity.setHakkoShoriID(発行処理ID);
        dbT4033Dac.save(entity);
    }
}
