/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.core.basic;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT4023JikoKisambiKanriEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 時効起算日管理のビルダークラスです。
 *
 * @reamsid_L DBD-9999-013 huangh
 *
 */
public class JikoKisambiKanriBuilder {

    private final DbT4023JikoKisambiKanriEntity entity;
    private final JikoKisambiKanriIdentifier id;

    /**
     * {@link DbT4023JikoKisambiKanriEntity}より{@link JikoKisambiKanri}の編集用Builderクラスを生成します。
     *
     * @param entity {@link DbT4023JikoKisambiKanriEntity}
     * @param id {@link JikoKisambiKanriIdentifier}
     *
     */
    JikoKisambiKanriBuilder(
            DbT4023JikoKisambiKanriEntity entity,
            JikoKisambiKanriIdentifier id
    ) {
        this.entity = entity.clone();
        this.id = id;

    }

    /**
     * 時効起算年月日を設定します。
     *
     * @param 時効起算年月日 時効起算年月日
     * @return {@link JikoKisambiKanriBuilder}
     */
    public JikoKisambiKanriBuilder set時効起算年月日(FlexibleDate 時効起算年月日) {
        requireNonNull(時効起算年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("時効起算年月日"));
        entity.setJikoKisanYMD(時効起算年月日);
        return this;
    }

    /**
     * 時効起算日区分を設定します。
     *
     * @param 時効起算日区分 時効起算日区分
     * @return {@link JikoKisambiKanriBuilder}
     */
    public JikoKisambiKanriBuilder set時効起算日区分(RString 時効起算日区分) {
        requireNonNull(時効起算日区分, UrSystemErrorMessages.値がnull.getReplacedMessage("時効起算日区分"));
        entity.setJikoKisanYMDKubun(時効起算日区分);
        return this;
    }

    /**
     * 論理削除フラグを設定します。
     *
     * @param 論理削除フラグ 論理削除フラグ
     * @return {@link JikoKisambiKanriBuilder}
     */
    public JikoKisambiKanriBuilder set論理削除フラグ(boolean 論理削除フラグ) {
        requireNonNull(論理削除フラグ, UrSystemErrorMessages.値がnull.getReplacedMessage("論理削除フラグ"));
        entity.setLogicalDeletedFlag(論理削除フラグ);
        return this;
    }

    /**
     * {@link JikoKisambiKanri}のインスタンスを生成します。
     *
     * @return {@link JikoKisambiKanri}のインスタンス
     */
    public JikoKisambiKanri build() {
        return new JikoKisambiKanri(entity, id);
    }
}
