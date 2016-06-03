/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.chikuninteichosain;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5221NinteichosaScheduleEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;

/**
 * 認定調査スケジュール情報を管理するクラスです。
 *
 * @reamsid_L DBE-0020-020 lishengli
 */
public class NinteichosaSchedule implements Serializable {

    private final DbT5221NinteichosaScheduleEntity entity;

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link DbT5221NinteichosaScheduleEntity}より{@link NinteichosaSchedule}を生成します。
     *
     * @param entity DBより取得した{@link DbT5221NinteichosaScheduleEntity}
     */
    public NinteichosaSchedule(DbT5221NinteichosaScheduleEntity entity) {
        this.entity = requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("保険者"));
    }

    /**
     * 申請書管理番号を返します。
     *
     * @return 申請書管理番号
     */
    public ShinseishoKanriNo get申請書管理番号() {
        return entity.getShinseishoKanriNo();
    }
}
