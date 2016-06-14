/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.shinsakai.shinsakaionseijoho;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5512ShinsakaiOnseiJohoEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;

/**
 * {@link ShinsakaiOnseiJoho2}の編集を行うビルダークラスです。
 *
 * @reamsid_L DBE-9999-011 sunhaidi
 */
public class ShinsakaiOnseiJoho2Builder {

    private final DbT5512ShinsakaiOnseiJohoEntity entity;
    private final ShinsakaiOnseiJoho2Identifier id;

    /**
     * {@link DbT5512ShinsakaiOnseiJohoEntity}より{@link ShinsakaiOnseiJoho2}の編集用Builderクラスを生成します。
     *
     * @param entity {@link DbT5512ShinsakaiOnseiJohoEntity}
     * @param id {@link ShinsakaiOnseiJoho2Identifier}
     *
     */
    ShinsakaiOnseiJoho2Builder(
            DbT5512ShinsakaiOnseiJohoEntity entity,
            ShinsakaiOnseiJoho2Identifier id
    ) {
        this.entity = entity.clone();
        this.id = id;

    }

    /**
     * 審査会音声ファイルを設定します。
     *
     * @param 審査会音声ファイル 審査会音声ファイル
     * @return {@link ShinsakaiOnseiJoho2Builder}
     */
    @SuppressWarnings("checkstyle:illegaltoken")
    public ShinsakaiOnseiJoho2Builder set審査会音声ファイル(byte[] 審査会音声ファイル) {
        requireNonNull(審査会音声ファイル, UrSystemErrorMessages.値がnull.getReplacedMessage("審査会音声ファイル"));
        entity.setShinsakaiOnseiFile(審査会音声ファイル);
        return this;
    }

    /**
     * {@link ShinsakaiOnseiJoho2}のインスタンスを生成します。
     *
     * @return {@link ShinsakaiOnseiJoho2}のインスタンス
     */
    public ShinsakaiOnseiJoho2 build() {
        return new ShinsakaiOnseiJoho2(entity, id);
    }
}
