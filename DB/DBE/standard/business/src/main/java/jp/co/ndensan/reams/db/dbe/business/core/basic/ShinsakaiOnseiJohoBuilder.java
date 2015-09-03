/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.basic;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5512ShinsakaiOnseiJohoEntity;
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

//TODO Key項目のsetterメソッドは削除してください。
//TODO 一緒に置換される値のまとまりで不変なクラスを作成し、その単位でsetterを作る様に見直してください。
    /**
     * 介護認定審査会開催番号を設定します。
     *
     * @param 介護認定審査会開催番号 介護認定審査会開催番号
     * @return {@link ShinsakaiOnseiJohoBuilder}
     */
    public ShinsakaiOnseiJohoBuilder set介護認定審査会開催番号(int 介護認定審査会開催番号) {
        requireNonNull(介護認定審査会開催番号, UrSystemErrorMessages.値がnull.getReplacedMessage("介護認定審査会開催番号"));
        entity.setShinsakaiKaisaiNo(介護認定審査会開催番号);
        return this;
    }

    /**
     * 連番を設定します。
     *
     * @param 連番 連番
     * @return {@link ShinsakaiOnseiJohoBuilder}
     */
    public ShinsakaiOnseiJohoBuilder set連番(int 連番) {
        requireNonNull(連番, UrSystemErrorMessages.値がnull.getReplacedMessage("連番"));
        entity.setRenban(連番);
        return this;
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
