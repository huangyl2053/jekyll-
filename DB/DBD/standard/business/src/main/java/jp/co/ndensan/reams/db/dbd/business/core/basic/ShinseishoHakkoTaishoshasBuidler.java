/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.core.basic;

import static java.util.Objects.requireNonNull;
import java.util.UUID;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT4033ShinseishoHakkoTaishoshasEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;

/**
 * {@link ShinseishoHakkoTaishoshasBuidler}の編集を行うビルダークラスです。
 *
 * @reamsid_L DBD-3530-060 liuyl
 */
public class ShinseishoHakkoTaishoshasBuidler {

    private final DbT4033ShinseishoHakkoTaishoshasEntity entity;
    private final ShinseishoHakkoTaishoshasIdentifier id;

    /**
     * コンストラクタです。
     *
     * @param entity DbT4033ShinseishoHakkoTaishoshasEntity
     * @param id ShinseishoHakkoTaishoshasIdentifier
     */
    ShinseishoHakkoTaishoshasBuidler(DbT4033ShinseishoHakkoTaishoshasEntity entity, ShinseishoHakkoTaishoshasIdentifier id) {
        this.entity = entity;
        this.id = id;
    }

    /**
     * 発行処理IDを設定します。
     *
     * @param 発行処理ID UUID
     * @return ShinseishoHakkoTaishoshasBuidler
     */
    public ShinseishoHakkoTaishoshasBuidler set発行処理ID(UUID 発行処理ID) {
        requireNonNull(発行処理ID, UrSystemErrorMessages.値がnull.getReplacedMessage("発行処理ID"));
        this.entity.setHakkoShoriID(発行処理ID);
        return this;
    }

    /**
     * 被保険者番号を設定します。
     *
     * @param 被保険者番号 HihokenshaNo
     * @return ShinseishoHakkoTaishoshasBuidler
     */
    public ShinseishoHakkoTaishoshasBuidler set被保険者番号(HihokenshaNo 被保険者番号) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        this.entity.setHihokenshaNo(被保険者番号);
        return this;
    }

    /**
     * {@link ShinseishoHakkoTaishoshas}のインスタンスを生成します。
     *
     * @return {@link ShinseishoHakkoTaishoshas}のインスタンス
     */
    public ShinseishoHakkoTaishoshas build() {
        return new ShinseishoHakkoTaishoshas(entity, id);
    }
}
