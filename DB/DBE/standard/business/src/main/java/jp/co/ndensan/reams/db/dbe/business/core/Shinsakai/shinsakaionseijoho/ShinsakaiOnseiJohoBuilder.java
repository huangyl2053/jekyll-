/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.Shinsakai.shinsakaionseijoho;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5512ShinsakaiOnseiJohoEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;

/**
 * {@link ShinsakaiOnseiJoho}の編集を行うビルダークラスです。
 */
public class ShinsakaiOnseiJohoBuilder {

    private final DbT5512ShinsakaiOnseiJohoEntity entity;
    private final ShinsakaiOnseiJohoIdentifier id;

    /**
     * {@link DbT5512ShinsakaiOnseiJohoEntity}より{@link ShinsakaiOnseiJoho}の編集用Builderクラスを生成します。
     *
     * @param entity {@link DbT5512ShinsakaiOnseiJohoEntity}
     * @param id {@link ShinsakaiOnseiJohoIdentifier}
     *
     */
    ShinsakaiOnseiJohoBuilder(
            DbT5512ShinsakaiOnseiJohoEntity entity,
            ShinsakaiOnseiJohoIdentifier id
    ) {
        this.entity = entity.clone();
        this.id = id;

    }

    /**
     * 審査会音声ファイルを設定します。
     *
     * @param 審査会音声ファイル 審査会音声ファイル
     * @return {@link ShinsakaiOnseiJohoBuilder}
     */
    public ShinsakaiOnseiJohoBuilder set審査会音声ファイル(byte[] 審査会音声ファイル) {
        requireNonNull(審査会音声ファイル, UrSystemErrorMessages.値がnull.getReplacedMessage("審査会音声ファイル"));
        entity.setShinsakaiOnseiFile(審査会音声ファイル);
        return this;
    }

    /**
     * {@link ShinsakaiOnseiJoho}のインスタンスを生成します。
     *
     * @return {@link ShinsakaiOnseiJoho}のインスタンス
     */
    public ShinsakaiOnseiJoho build() {
        return new ShinsakaiOnseiJoho(entity, id);
    }
}
