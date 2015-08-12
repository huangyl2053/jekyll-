/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT5223ChikuNinteiChosainEntity;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * {@link ChikuNinteiChosain}の編集を行うビルダークラスです。
 */
public class ChikuNinteiChosainBuilder {

    private final DbT5223ChikuNinteiChosainEntity entity;
    private final ChikuNinteiChosainIdentifier id;

    /**
     * {@link DbT5223ChikuNinteiChosainEntity}より{@link ChikuNinteiChosain}の編集用Builderクラスを生成します。
     *
     * @param entity {@link DbT5223ChikuNinteiChosainEntity}
     * @param id {@link ChikuNinteiChosainIdentifier}
     *
     */
    ChikuNinteiChosainBuilder(
            DbT5223ChikuNinteiChosainEntity entity,
            ChikuNinteiChosainIdentifier id
    ) {
        this.entity = entity.clone();
        this.id = id;

    }

//TODO Key項目のsetterメソッドは削除してください。
//TODO 一緒に置換される値のまとまりで不変なクラスを作成し、その単位でsetterを作る様に見直してください。
    /**
     * 調査地区コードを設定します。
     *
     * @param 調査地区コード 調査地区コード
     * @return {@link ChikuNinteiChosainBuilder}
     */
    public ChikuNinteiChosainBuilder set調査地区コード(Code 調査地区コード) {
        requireNonNull(調査地区コード, UrSystemErrorMessages.値がnull.getReplacedMessage("調査地区コード"));
        entity.setChosaChikuCode(調査地区コード);
        return this;
    }

    /**
     * 認定調査委託先コードを設定します。
     *
     * @param 認定調査委託先コード 認定調査委託先コード
     * @return {@link ChikuNinteiChosainBuilder}
     */
    public ChikuNinteiChosainBuilder set認定調査委託先コード(RString 認定調査委託先コード) {
        requireNonNull(認定調査委託先コード, UrSystemErrorMessages.値がnull.getReplacedMessage("認定調査委託先コード"));
        entity.setNinteiChosaItakusakiCode(認定調査委託先コード);
        return this;
    }

    /**
     * 認定調査員コードを設定します。
     *
     * @param 認定調査員コード 認定調査員コード
     * @return {@link ChikuNinteiChosainBuilder}
     */
    public ChikuNinteiChosainBuilder set認定調査員コード(RString 認定調査員コード) {
        requireNonNull(認定調査員コード, UrSystemErrorMessages.値がnull.getReplacedMessage("認定調査員コード"));
        entity.setNinteiChosainCode(認定調査員コード);
        return this;
    }

    /**
     * 市町村コードを設定します。
     *
     * @param 市町村コード 市町村コード
     * @return {@link ChikuNinteiChosainBuilder}
     */
    public ChikuNinteiChosainBuilder set市町村コード(LasdecCode 市町村コード) {
        requireNonNull(市町村コード, UrSystemErrorMessages.値がnull.getReplacedMessage("市町村コード"));
        entity.setShichosonCode(市町村コード);
        return this;
    }

    /**
     * 優先番号を設定します。
     *
     * @param 優先番号 優先番号
     * @return {@link ChikuNinteiChosainBuilder}
     */
    public ChikuNinteiChosainBuilder set優先番号(int 優先番号) {
        requireNonNull(優先番号, UrSystemErrorMessages.値がnull.getReplacedMessage("優先番号"));
        entity.setYusenNo(優先番号);
        return this;
    }

    /**
     * 備考を設定します。
     *
     * @param 備考 備考
     * @return {@link ChikuNinteiChosainBuilder}
     */
    public ChikuNinteiChosainBuilder set備考(RString 備考) {
        requireNonNull(備考, UrSystemErrorMessages.値がnull.getReplacedMessage("備考"));
        entity.setBiko(備考);
        return this;
    }

    /**
     * {@link ChikuNinteiChosain}のインスタンスを生成します。
     *
     * @return {@link ChikuNinteiChosain}のインスタンス
     */
    public ChikuNinteiChosain build() {
        return new ChikuNinteiChosain(entity, id);
    }
}
