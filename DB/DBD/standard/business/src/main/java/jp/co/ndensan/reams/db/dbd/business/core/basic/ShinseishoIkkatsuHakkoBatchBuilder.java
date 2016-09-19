/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.core.basic;

import static java.util.Objects.requireNonNull;
import java.util.UUID;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT4032ShinseishoIkkatsuHakkoBatchEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;

/**
 * {@link ShinseishoIkkatsuHakkoBatch}の編集を行うビルダークラスです。
 *
 * @reamsid_L DBD-3530-060 liuyl
 */
public class ShinseishoIkkatsuHakkoBatchBuilder {

    private final DbT4032ShinseishoIkkatsuHakkoBatchEntity entity;
    private final ShinseishoIkkatsuHakkoBatchIdentifier id;

    /**
     * コンストラクタです。
     *
     * @param entity DbT4032ShinseishoIkkatsuHakkoBatchEntity
     * @param id ShinseishoIkkatsuHakkoBatchIdentifier
     */
    ShinseishoIkkatsuHakkoBatchBuilder(DbT4032ShinseishoIkkatsuHakkoBatchEntity entity, ShinseishoIkkatsuHakkoBatchIdentifier id) {
        this.entity = entity;
        this.id = id;
    }

    /**
     * 発行処理IDを設定します。
     *
     * @param 発行処理ID UUID
     * @return ShinseishoIkkatsuHakkoBatchBuilder
     */
    public ShinseishoIkkatsuHakkoBatchBuilder set発行処理ID(UUID 発行処理ID) {
        requireNonNull(発行処理ID, UrSystemErrorMessages.値がnull.getReplacedMessage("発行処理ID"));
        entity.setHakkoShoriID(発行処理ID);
        return this;
    }

    /**
     * 把握処理IDを設定します。
     *
     * @param 把握処理ID UUID
     * @return ShinseishoIkkatsuHakkoBatchBuilder
     */
    public ShinseishoIkkatsuHakkoBatchBuilder set把握処理ID(UUID 把握処理ID) {
        requireNonNull(把握処理ID, UrSystemErrorMessages.値がnull.getReplacedMessage("把握処理ID"));
        entity.setHaakuShoriId(把握処理ID);
        return this;
    }

    /**
     * {@link ShinseishoIkkatsuHakkoBatch}のインスタンスを生成します。
     *
     * @return {@link ShinseishoIkkatsuHakkoBatch}のインスタンス
     */
    public ShinseishoIkkatsuHakkoBatch build() {
        return new ShinseishoIkkatsuHakkoBatch(entity, id);
    }
}
