/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.service.core.kouhoushajoho;

import static java.util.Objects.requireNonNull;
import java.util.UUID;
import jp.co.ndensan.reams.db.dbd.business.core.basic.ShinseishoHakkoTaishoshas;
import jp.co.ndensan.reams.db.dbd.business.core.basic.ShinseishoIkkatsuHakkoBatch;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT4033ShinseishoHakkoTaishoshasEntity;
import jp.co.ndensan.reams.db.dbd.persistence.db.basic.DbT4032ShinseishoIkkatsuHakkoBatchDac;
import jp.co.ndensan.reams.db.dbd.persistence.db.basic.DbT4033ShinseishoHakkoTaishoDac;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
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
     * @param shinseishoIkkatsuHakkoBatch ShinseishoIkkatsuHakkoBatch
     * @return boolean
     */
    @Transaction
    public boolean insertDbT4032(ShinseishoIkkatsuHakkoBatch shinseishoIkkatsuHakkoBatch) {
        requireNonNull(shinseishoIkkatsuHakkoBatch, UrSystemErrorMessages.値がnull.getReplacedMessage("申請書一括発行"));
        if (!shinseishoIkkatsuHakkoBatch.hasChanged()) {
            return false;
        }
        return 1 == dbT4032Dac.save(shinseishoIkkatsuHakkoBatch.toEntity());

    }

    /**
     * DB出力(申請書発行対象) 。
     *
     * @param shinseishoHakkoTaishoshas ShinseishoHakkoTaishoshas
     * @return boolean
     */
    @Transaction
    public boolean insertDbT4033(ShinseishoHakkoTaishoshas shinseishoHakkoTaishoshas) {
        requireNonNull(shinseishoHakkoTaishoshas, UrSystemErrorMessages.値がnull.getReplacedMessage("申請書発行対象"));
        if (!shinseishoHakkoTaishoshas.hasChanged()) {
            return false;
        }
        return 1 == dbT4033Dac.save(shinseishoHakkoTaishoshas.toEntity());
    }

    /**
     * 申請書発行対象を取得します。
     *
     * @param 発行処理ID UUID
     * @param 被保険者番号 HihokenshaNo
     * @return 申請書発行対象
     */
    @Transaction
    public ShinseishoHakkoTaishoshas select申請書発行対象(UUID 発行処理ID, HihokenshaNo 被保険者番号) {
        DbT4033ShinseishoHakkoTaishoshasEntity entity = dbT4033Dac.selectByKey(発行処理ID, 被保険者番号);
        if (entity == null) {
            return null;
        } else {
            return new ShinseishoHakkoTaishoshas(entity);
        }
    }
}
