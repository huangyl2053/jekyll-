/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.basic;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5601NinteiChosaHoshuJissekiJohoEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * {@link NinteiChosaHoshuJissekiJoho}の編集を行うビルダークラスです。
 *
 * @reamsid_L DBE-9999-011 wanghui
 */
public class NinteiChosaHoshuJissekiJohoBuilder {

    private final DbT5601NinteiChosaHoshuJissekiJohoEntity entity;
    private final NinteiChosaHoshuJissekiJohoIdentifier id;

    /**
     * {@link DbT5601NinteiChosaHoshuJissekiJohoEntity}より{@link NinteiChosaHoshuJissekiJoho}の編集用Builderクラスを生成します。
     *
     * @param entity {@link DbT5601NinteiChosaHoshuJissekiJohoEntity}
     * @param id {@link NinteiChosaHoshuJissekiJohoIdentifier}
     *
     */
    NinteiChosaHoshuJissekiJohoBuilder(
            DbT5601NinteiChosaHoshuJissekiJohoEntity entity,
            NinteiChosaHoshuJissekiJohoIdentifier id
    ) {
        this.entity = entity.clone();
        this.id = id;

    }

//TODO Key項目のsetterメソッドは削除してください。
//TODO 一緒に置換される値のまとまりで不変なクラスを作成し、その単位でsetterを作る様に見直してください。
    /**
     * 認定調査委託先コードを設定します。
     *
     * @param 認定調査委託先コード 認定調査委託先コード
     * @return {@link NinteiChosaHoshuJissekiJohoBuilder}
     */
    public NinteiChosaHoshuJissekiJohoBuilder set認定調査委託先コード(RString 認定調査委託先コード) {
        requireNonNull(認定調査委託先コード, UrSystemErrorMessages.値がnull.getReplacedMessage("認定調査委託先コード"));
        entity.setNinteichosaItakusakiCode(認定調査委託先コード);
        return this;
    }

    /**
     * 認定調査員コードを設定します。
     *
     * @param 認定調査員コード 認定調査員コード
     * @return {@link NinteiChosaHoshuJissekiJohoBuilder}
     */
    public NinteiChosaHoshuJissekiJohoBuilder set認定調査員コード(RString 認定調査員コード) {
        requireNonNull(認定調査員コード, UrSystemErrorMessages.値がnull.getReplacedMessage("認定調査員コード"));
        entity.setNinteichosainCode(認定調査員コード);
        return this;
    }

    /**
     * 申請書管理番号を設定します。
     *
     * @param 申請書管理番号 申請書管理番号
     * @return {@link NinteiChosaHoshuJissekiJohoBuilder}
     */
    public NinteiChosaHoshuJissekiJohoBuilder set申請書管理番号(ShinseishoKanriNo 申請書管理番号) {
        requireNonNull(申請書管理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("申請書管理番号"));
        entity.setShinseishoKanriNo(申請書管理番号);
        return this;
    }

    /**
     * 認定調査依頼履歴番号を設定します。
     *
     * @param 認定調査依頼履歴番号 認定調査依頼履歴番号
     * @return {@link NinteiChosaHoshuJissekiJohoBuilder}
     */
    public NinteiChosaHoshuJissekiJohoBuilder set認定調査依頼履歴番号(int 認定調査依頼履歴番号) {
        requireNonNull(認定調査依頼履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("認定調査依頼履歴番号"));
        entity.setNinteichosaIraiRirekiNo(認定調査依頼履歴番号);
        return this;
    }

    /**
     * 認定調査委託料を設定します。
     *
     * @param 認定調査委託料 認定調査委託料
     * @return {@link NinteiChosaHoshuJissekiJohoBuilder}
     */
    public NinteiChosaHoshuJissekiJohoBuilder set認定調査委託料(int 認定調査委託料) {
        requireNonNull(認定調査委託料, UrSystemErrorMessages.値がnull.getReplacedMessage("認定調査委託料"));
        entity.setChosaItakuryo(認定調査委託料);
        return this;
    }

    /**
     * 認定調査委託料支払年月日を設定します。
     *
     * @param 認定調査委託料支払年月日 認定調査委託料支払年月日
     * @return {@link NinteiChosaHoshuJissekiJohoBuilder}
     */
    public NinteiChosaHoshuJissekiJohoBuilder set認定調査委託料支払年月日(FlexibleDate 認定調査委託料支払年月日) {
        requireNonNull(認定調査委託料支払年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("認定調査委託料支払年月日"));
        entity.setChosaItakuryoShiharaiYMD(認定調査委託料支払年月日);
        return this;
    }

    /**
     * 認定調査委託料支払メモを設定します。
     *
     * @param 認定調査委託料支払メモ 認定調査委託料支払メモ
     * @return {@link NinteiChosaHoshuJissekiJohoBuilder}
     */
    public NinteiChosaHoshuJissekiJohoBuilder set認定調査委託料支払メモ(RString 認定調査委託料支払メモ) {
        requireNonNull(認定調査委託料支払メモ, UrSystemErrorMessages.値がnull.getReplacedMessage("認定調査委託料支払メモ"));
        entity.setChosaItakuryoShiharaiMemo(認定調査委託料支払メモ);
        return this;
    }

    /**
     * 銀行振込出力フラグを設定します。
     *
     * @param 銀行振込出力フラグ 銀行振込出力フラグ
     * @return {@link NinteiChosaHoshuJissekiJohoBuilder}
     */
    public NinteiChosaHoshuJissekiJohoBuilder set銀行振込出力フラグ(boolean 銀行振込出力フラグ) {
        requireNonNull(銀行振込出力フラグ, UrSystemErrorMessages.値がnull.getReplacedMessage("銀行振込出力フラグ"));
        entity.setIsGinkoFurikomiShutsuryoku(銀行振込出力フラグ);
        return this;
    }

    /**
     * {@link NinteiChosaHoshuJissekiJoho}のインスタンスを生成します。
     *
     * @return {@link NinteiChosaHoshuJissekiJoho}のインスタンス
     */
    public NinteiChosaHoshuJissekiJoho build() {
        return new NinteiChosaHoshuJissekiJoho(entity, id);
    }
}
