/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT5209NinteichosahyoKinyuItemEntity;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * {@link NinteichosahyoKinyuItem}の編集を行うビルダークラスです。
 */
public class NinteichosahyoKinyuItemBuilder {

    private final DbT5209NinteichosahyoKinyuItemEntity entity;
    private final NinteichosahyoKinyuItemIdentifier id;

    /**
     * {@link DbT5209NinteichosahyoKinyuItemEntity}より{@link NinteichosahyoKinyuItem}の編集用Builderクラスを生成します。
     *
     * @param entity {@link DbT5209NinteichosahyoKinyuItemEntity}
     * @param id {@link NinteichosahyoKinyuItemIdentifier}
     *
     */
    NinteichosahyoKinyuItemBuilder(
            DbT5209NinteichosahyoKinyuItemEntity entity,
            NinteichosahyoKinyuItemIdentifier id
    ) {
        this.entity = entity.clone();
        this.id = id;

    }

//TODO Key項目のsetterメソッドは削除してください。
//TODO 一緒に置換される値のまとまりで不変なクラスを作成し、その単位でsetterを作る様に見直してください。
    /**
     * 申請書管理番号を設定します。
     *
     * @param 申請書管理番号 申請書管理番号
     * @return {@link NinteichosahyoKinyuItemBuilder}
     */
    public NinteichosahyoKinyuItemBuilder set申請書管理番号(ShinseishoKanriNo 申請書管理番号) {
        requireNonNull(申請書管理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("申請書管理番号"));
        entity.setShinseishoKanriNo(申請書管理番号);
        return this;
    }

    /**
     * 認定調査依頼履歴番号を設定します。
     *
     * @param 認定調査依頼履歴番号 認定調査依頼履歴番号
     * @return {@link NinteichosahyoKinyuItemBuilder}
     */
    public NinteichosahyoKinyuItemBuilder set認定調査依頼履歴番号(int 認定調査依頼履歴番号) {
        requireNonNull(認定調査依頼履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("認定調査依頼履歴番号"));
        entity.setNinteichosaRirekiNo(認定調査依頼履歴番号);
        return this;
    }

    /**
     * 連番を設定します。
     *
     * @param 連番 連番
     * @return {@link NinteichosahyoKinyuItemBuilder}
     */
    public NinteichosahyoKinyuItemBuilder set連番(int 連番) {
        requireNonNull(連番, UrSystemErrorMessages.値がnull.getReplacedMessage("連番"));
        entity.setRemban(連番);
        return this;
    }

    /**
     * 厚労省IF識別コードを設定します。
     *
     * @param 厚労省IF識別コード 厚労省IF識別コード
     * @return {@link NinteichosahyoKinyuItemBuilder}
     */
    public NinteichosahyoKinyuItemBuilder set厚労省IF識別コード(Code 厚労省IF識別コード) {
        requireNonNull(厚労省IF識別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("厚労省IF識別コード"));
        entity.setKoroshoIfShikibetsuCode(厚労省IF識別コード);
        return this;
    }

    /**
     * サービスの状況記入を設定します。
     *
     * @param サービスの状況記入 サービスの状況記入
     * @return {@link NinteichosahyoKinyuItemBuilder}
     */
    public NinteichosahyoKinyuItemBuilder setサービスの状況記入(RString サービスの状況記入) {
        requireNonNull(サービスの状況記入, UrSystemErrorMessages.値がnull.getReplacedMessage("サービスの状況記入"));
        entity.setServiceJokyoKinyu(サービスの状況記入);
        return this;
    }

    /**
     * サービスの状況イメージ共有ファイルIDを設定します。
     *
     * @param サービスの状況イメージ共有ファイルID サービスの状況イメージ共有ファイルID
     * @return {@link NinteichosahyoKinyuItemBuilder}
     */
    public NinteichosahyoKinyuItemBuilder setサービスの状況イメージ共有ファイルID(RDateTime サービスの状況イメージ共有ファイルID) {
        requireNonNull(サービスの状況イメージ共有ファイルID, UrSystemErrorMessages.値がnull.getReplacedMessage("サービスの状況イメージ共有ファイルID"));
        entity.setServiceJokyoImageSharedFileId(サービスの状況イメージ共有ファイルID);
        return this;
    }

    /**
     * {@link NinteichosahyoKinyuItem}のインスタンスを生成します。
     *
     * @return {@link NinteichosahyoKinyuItem}のインスタンス
     */
    public NinteichosahyoKinyuItem build() {
        return new NinteichosahyoKinyuItem(entity, id);
    }
}
