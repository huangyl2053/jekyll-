/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.core.basic;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT4401IryohiKojoEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;

/**
 * 医療費控除のビルダークラスです。
 *
 * @reamsid_L DBD-5780-010 tz_chengpeng
 *
 */
public class IryohiKojoBuilder {

    private final DbT4401IryohiKojoEntity entity;
    private final IryohiKojoIdentifier id;

    /**
     * {@link DbT4401IryohiKojoEntity}より{@link IryohiKojo}の編集用Builderクラスを生成します。
     *
     * @param entity {@link DbT4401IryohiKojoEntity}
     * @param id {@link IryohiKojoIdentifier}
     *
     */
    IryohiKojoBuilder(
            DbT4401IryohiKojoEntity entity,
            IryohiKojoIdentifier id
    ) {
        this.entity = entity.clone();
        this.id = id;

    }

    /**
     * 発行年月日を設定します。
     *
     * @param 発行年月日 時効起算年月日
     * @return {@link IryohiKojoBuilder}
     */
    public IryohiKojoBuilder set発行年月日(FlexibleDate 発行年月日) {
        requireNonNull(発行年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("発行年月日"));
        entity.setHakkoYMD(発行年月日);
        return this;
    }

    /**
     * 論理削除フラグを設定します。
     *
     * @param 論理削除フラグ 論理削除フラグ
     * @return {@link IryohiKojoBuilder}
     */
    public IryohiKojoBuilder set論理削除フラグ(boolean 論理削除フラグ) {
        requireNonNull(論理削除フラグ, UrSystemErrorMessages.値がnull.getReplacedMessage("論理削除フラグ"));
        entity.setLogicalDeletedFlag(論理削除フラグ);
        return this;
    }

    /**
     * {@link IryohiKojo}のインスタンスを生成します。
     *
     * @return {@link IryohiKojo}のインスタンス
     */
    public IryohiKojo build() {
        return new IryohiKojo(entity, id);
    }
}
