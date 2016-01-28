/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.ninteischedule.ninteichosaschedulememo;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5222NinteiChosaScheduleMemoEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * {@link NinteiChosaScheduleMemo}の編集を行うビルダークラスです。
 */
public class NinteiChosaScheduleMemoBuilder {

    private final DbT5222NinteiChosaScheduleMemoEntity entity;
    private final NinteiChosaScheduleMemoIdentifier id;

    /**
     * {@link DbT5222NinteiChosaScheduleMemoEntity}より{@link NinteiChosaScheduleMemo}の編集用Builderクラスを生成します。
     *
     * @param entity {@link DbT5222NinteiChosaScheduleMemoEntity}
     * @param id {@link NinteiChosaScheduleMemoIdentifier}
     *
     */
    NinteiChosaScheduleMemoBuilder(
            DbT5222NinteiChosaScheduleMemoEntity entity,
            NinteiChosaScheduleMemoIdentifier id
    ) {
        this.entity = entity.clone();
        this.id = id;

    }
    /**
     * メモ指定調査地区コードを設定します。
     *
     * @param メモ指定調査地区コード メモ指定調査地区コード
     * @return {@link NinteiChosaScheduleMemoBuilder}
     */
    public NinteiChosaScheduleMemoBuilder setメモ指定調査地区コード(Code メモ指定調査地区コード) {
        requireNonNull(メモ指定調査地区コード, UrSystemErrorMessages.値がnull.getReplacedMessage("メモ指定調査地区コード"));
        entity.setMemoShiteiChosaChikuCode(メモ指定調査地区コード);
        return this;
    }

    /**
     * 作成者を設定します。
     *
     * @param 作成者 作成者
     * @return {@link NinteiChosaScheduleMemoBuilder}
     */
    public NinteiChosaScheduleMemoBuilder set作成者(RString 作成者) {
        requireNonNull(作成者, UrSystemErrorMessages.値がnull.getReplacedMessage("作成者"));
        entity.setSakuseisha(作成者);
        return this;
    }

    /**
     * メモ重要度を設定します。
     *
     * @param メモ重要度 メモ重要度
     * @return {@link NinteiChosaScheduleMemoBuilder}
     */
    public NinteiChosaScheduleMemoBuilder setメモ重要度(Code メモ重要度) {
        requireNonNull(メモ重要度, UrSystemErrorMessages.値がnull.getReplacedMessage("メモ重要度"));
        entity.setMemoPriority(メモ重要度);
        return this;
    }

    /**
     * メモ内容を設定します。
     *
     * @param メモ内容 メモ内容
     * @return {@link NinteiChosaScheduleMemoBuilder}
     */
    public NinteiChosaScheduleMemoBuilder setメモ内容(RString メモ内容) {
        requireNonNull(メモ内容, UrSystemErrorMessages.値がnull.getReplacedMessage("メモ内容"));
        entity.setMemoNaiyo(メモ内容);
        return this;
    }

    /**
     * {@link NinteiChosaScheduleMemo}のインスタンスを生成します。
     *
     * @return {@link NinteiChosaScheduleMemo}のインスタンス
     */
    public NinteiChosaScheduleMemo build() {
        return new NinteiChosaScheduleMemo(entity, id);
    }
}
