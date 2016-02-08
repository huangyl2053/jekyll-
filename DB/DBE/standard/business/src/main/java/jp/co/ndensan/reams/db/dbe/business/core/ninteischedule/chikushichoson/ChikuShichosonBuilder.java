/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.ninteischedule.chikushichoson;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbe.business.core.ninteischedule.chosachikugroup.ChosaChikuGroup;
import jp.co.ndensan.reams.db.dbe.business.core.ninteischedule.chosachikugroup.ChosaChikuGroupIdentifier;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5224ChikuShichosonEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.util.Models;

/**
 * {@link ChikuShichoson}の編集を行うビルダークラスです。
 */
public class ChikuShichosonBuilder {

    private final DbT5224ChikuShichosonEntity entity;
    private final ChikuShichosonIdentifier id;
    private final Models<ChosaChikuGroupIdentifier, ChosaChikuGroup> chosaChikuGroup;

    /**
     * {@link DbT5224ChikuShichosonEntity}より{@link ChikuShichoson}の編集用Builderクラスを生成します。
     *
     * @param entity {@link DbT5224ChikuShichosonEntity}
     * @param id {@link ChikuShichosonIdentifier}
     * @param seishinTechoNini {@link Models}
     * @param todokedesha {@link Models}
     *
     */
    ChikuShichosonBuilder(
            DbT5224ChikuShichosonEntity entity,
            ChikuShichosonIdentifier id,
            Models<ChosaChikuGroupIdentifier, ChosaChikuGroup> chosachikugroup
    ) {
        this.entity = entity.clone();
        this.id = id;
        this.chosaChikuGroup = chosachikugroup.clone();

    }

    /**
     * 調査地区コードを設定します。
     *
     * @param 調査地区コード 調査地区コード
     * @return {@link ChikuShichosonBuilder}
     */
    public ChikuShichosonBuilder set調査地区コード(Code 調査地区コード) {
        requireNonNull(調査地区コード, UrSystemErrorMessages.値がnull.getReplacedMessage("調査地区コード"));
        entity.setChosaChikuCode(調査地区コード);
        return this;
    }

    /**
     * 市町村コードを設定します。
     *
     * @param 市町村コード 市町村コード
     * @return {@link ChikuShichosonBuilder}
     */
    public ChikuShichosonBuilder set市町村コード(LasdecCode 市町村コード) {
        requireNonNull(市町村コード, UrSystemErrorMessages.値がnull.getReplacedMessage("市町村コード"));
        entity.setShichosonCode(市町村コード);
        return this;
    }

    /**
     * 優先番号を設定します。
     *
     * @param 優先番号 優先番号
     * @return {@link ChikuShichosonBuilder}
     */
    public ChikuShichosonBuilder set優先番号(int 優先番号) {
        requireNonNull(優先番号, UrSystemErrorMessages.値がnull.getReplacedMessage("優先番号"));
        entity.setYusenNo(優先番号);
        return this;
    }

    /**
     * 自地区フラグを設定します。
     *
     * @param 自地区フラグ 自地区フラグ
     * @return {@link ChikuShichosonBuilder}
     */
    public ChikuShichosonBuilder set自地区フラグ(boolean 自地区フラグ) {
        requireNonNull(自地区フラグ, UrSystemErrorMessages.値がnull.getReplacedMessage("自地区フラグ"));
        entity.setJiChikuFlag(自地区フラグ);
        return this;
    }

    /**
     * 精神手帳任意項目情報のキー情報について判定します。<br>
     * 精神手帳情報に関連できる精神手帳任意項目情報である場合、下記の処理に遷移します。<br>
     * キーが一致する場合は精神手帳任意項目情報リストに精神手帳任意項目情報{@link SeishinTechoNini}をセットします。<br>
     * キーが一致しない場合、新たに追加します。<br>
     *
     * @param 調査地区グループマスタ {@link ChosaChikuGroup}
     * @return {@link ChikuShichosonBuilder}
     * @throws IllegalStateException キーが一致しない場合
     */
    public ChikuShichosonBuilder setChosaChikuGroupIdentifier(ChosaChikuGroup  調査地区グループマスタ) {
        if (hasSameIdentifier(調査地区グループマスタ.identifier())) {
            chosaChikuGroup.add(調査地区グループマスタ);
            return this;
        }
        throw new IllegalArgumentException(UrErrorMessages.不正.toString());
    }

    private boolean hasSameIdentifier(ChosaChikuGroupIdentifier 調査地区グループマスタの識別子) {
        return (id.get市町村コード().equals(調査地区グループマスタの識別子.get市町村コード())
                && id.get調査地区コード().equals(調査地区グループマスタの識別子.get調査地区コード()));
    }
    /**
     * {@link ChikuShichoson}のインスタンスを生成します。
     *
     * @return {@link ChikuShichoson}のインスタンス
     */
    public ChikuShichoson build() {
        return new ChikuShichoson(entity, id, chosaChikuGroup);
    }
}
