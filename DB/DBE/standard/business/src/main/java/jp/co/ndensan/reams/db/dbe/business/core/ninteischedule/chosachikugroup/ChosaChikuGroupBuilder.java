/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.ninteischedule.chosachikugroup;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5225ChosaChikuGroupEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * {@link ChosaChikuGroup}の編集を行うビルダークラスです。
 */
public class ChosaChikuGroupBuilder {

    private final DbT5225ChosaChikuGroupEntity entity;
    private final ChosaChikuGroupIdentifier id;

    /**
     * {@link DbT5225ChosaChikuGroupEntity}より{@link ChosaChikuGroup}の編集用Builderクラスを生成します。
     *
     * @param entity {@link DbT5225ChosaChikuGroupEntity}
     * @param id {@link ChosaChikuGroupIdentifier}
     *
     */
    ChosaChikuGroupBuilder(
            DbT5225ChosaChikuGroupEntity entity,
            ChosaChikuGroupIdentifier id
    ) {
        this.entity = entity.clone();
        this.id = id;

    }

    /**
     * 調査地区グループコードを設定します。
     *
     * @param 調査地区グループコード 調査地区グループコード
     * @return {@link ChosaChikuGroupBuilder}
     */
    public ChosaChikuGroupBuilder set調査地区グループコード(Code 調査地区グループコード) {
        requireNonNull(調査地区グループコード, UrSystemErrorMessages.値がnull.getReplacedMessage("調査地区グループコード"));
        entity.setChosaChikuGroupCode(調査地区グループコード);
        return this;
    }

    /**
     * 調査地区コードを設定します。
     *
     * @param 調査地区コード 調査地区コード
     * @return {@link ChosaChikuGroupBuilder}
     */
    public ChosaChikuGroupBuilder set調査地区コード(Code 調査地区コード) {
        requireNonNull(調査地区コード, UrSystemErrorMessages.値がnull.getReplacedMessage("調査地区コード"));
        entity.setChosachikucode(調査地区コード);
        return this;
    }

    /**
     * 市町村コードを設定します。
     *
     * @param 市町村コード 市町村コード
     * @return {@link ChosaChikuGroupBuilder}
     */
    public ChosaChikuGroupBuilder set市町村コード(LasdecCode 市町村コード) {
        requireNonNull(市町村コード, UrSystemErrorMessages.値がnull.getReplacedMessage("市町村コード"));
        entity.setShichosonCode(市町村コード);
        return this;
    }

    /**
     * 調査地区グループ名称を設定します。
     *
     * @param 調査地区グループ名称 調査地区グループ名称
     * @return {@link ChosaChikuGroupBuilder}
     */
    public ChosaChikuGroupBuilder set調査地区グループ名称(RString 調査地区グループ名称) {
        requireNonNull(調査地区グループ名称, UrSystemErrorMessages.値がnull.getReplacedMessage("調査地区グループ名称"));
        entity.setChosachikugroupname(調査地区グループ名称);
        return this;
    }

    /**
     * 優先番号を設定します。
     *
     * @param 優先番号 優先番号
     * @return {@link ChosaChikuGroupBuilder}
     */
    public ChosaChikuGroupBuilder set優先番号(int 優先番号) {
        requireNonNull(優先番号, UrSystemErrorMessages.値がnull.getReplacedMessage("優先番号"));
        entity.setYusenNo(優先番号);
        return this;
    }

    /**
     * {@link ChosaChikuGroup}のインスタンスを生成します。
     *
     * @return {@link ChosaChikuGroup}のインスタンス
     */
    public ChosaChikuGroup build() {
        return new ChosaChikuGroup(entity, id);
    }
}
