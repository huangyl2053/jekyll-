/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.ShisetsuType;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ShisetsuCode;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Range;

/**
 * 介護除外・住所地特例対象施設を扱うクラスです。
 *
 * @author N3317 塚田 萌
 */
public class JogaiJushochitokureiTaishoShisetsu {

    private final ShisetsuType 施設種類;
    private final ShisetsuCode 施設コード;
    private final RDateTime 処理日時;
    private final Range<FlexibleDate> 有効期間;
    private final ShikibetsuCode 識別コード;
    private final RString 施設略称;
    private final RString 施設略称カナ;
    private final RString 施設住所カナ;
    private final RString 異動事由コード;
    private final FlexibleDate 異動年月日;
    private final RString 法人種別コード;
    private final FlexibleDate 施設開始年月日;
    private final FlexibleDate 施設休止年月日;
    private final FlexibleDate 施設廃止年月日;
    private final FlexibleDate 施設再開年月日;

    /**
     * コンストラクタです。
     *
     * @param 施設種類 施設種類
     * @param 施設コード 施設コード
     * @param 処理日時 処理日時
     * @param 有効期間 有効期間
     * @param 識別コード 識別コード
     * @param 施設略称 施設略称
     * @param 施設略称カナ 施設略称カナ
     * @param 施設住所カナ 施設住所カナ
     * @param 異動事由コード 異動事由コード
     * @param 異動年月日 異動年月日
     * @param 法人種別コード 法人種別コード
     * @param 施設開始年月日 施設開始年月日
     * @param 施設休止年月日 施設休止年月日
     * @param 施設廃止年月日 施設廃止年月日
     * @param 施設再開年月日 施設再開年月日
     */
    public JogaiJushochitokureiTaishoShisetsu(
            ShisetsuType 施設種類, ShisetsuCode 施設コード, RDateTime 処理日時,
            Range<FlexibleDate> 有効期間, ShikibetsuCode 識別コード,
            RString 施設略称, RString 施設略称カナ, RString 施設住所カナ,
            RString 異動事由コード, FlexibleDate 異動年月日, RString 法人種別コード,
            FlexibleDate 施設開始年月日, FlexibleDate 施設休止年月日,
            FlexibleDate 施設廃止年月日, FlexibleDate 施設再開年月日) {

        this.施設種類 = requireNonNull(施設種類, UrSystemErrorMessages.値がnull.getReplacedMessage("施設種類"));
        this.施設コード = requireNonNull(施設コード, UrSystemErrorMessages.値がnull.getReplacedMessage("施設コード"));
        this.処理日時 = requireNonNull(処理日時, UrSystemErrorMessages.値がnull.getReplacedMessage("処理日時"));
        this.有効期間 = requireNonNull(有効期間, UrSystemErrorMessages.値がnull.getReplacedMessage("有効期間"));
        this.識別コード = requireNonNull(識別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("識別コード"));
        this.施設略称 = 施設略称;
        this.施設略称カナ = 施設略称カナ;
        this.施設住所カナ = 施設住所カナ;
        this.異動事由コード = 異動事由コード;
        this.異動年月日 = 異動年月日;
        this.法人種別コード = 法人種別コード;
        this.施設開始年月日 = 施設開始年月日;
        this.施設休止年月日 = 施設休止年月日;
        this.施設廃止年月日 = 施設廃止年月日;
        this.施設再開年月日 = 施設再開年月日;
    }

    /**
     * 施設種類を返します。
     *
     * @return 施設種類
     */
    public ShisetsuType get施設種類() {
        return 施設種類;
    }

    /**
     * 施設コードを返します。
     *
     * @return 施設コード
     */
    public ShisetsuCode get施設コード() {
        return 施設コード;
    }

    /**
     * 処理日時を返します。
     *
     * @return 処理日時
     */
    public RDateTime get処理日時() {
        return 処理日時;
    }

    /**
     * 有効期間を返します。
     *
     * @return 有効期間
     */
    public Range<FlexibleDate> get有効期間() {
        return 有効期間;
    }

    /**
     * 識別コードを返します。
     *
     * @return 識別コード
     */
    public ShikibetsuCode get識別コード() {
        return 識別コード;
    }

    /**
     * 施設略称を返します。
     *
     * @return 施設略称
     */
    public RString get施設略称() {
        return 施設略称;
    }

    /**
     * 施設カナ略称を返します。
     *
     * @return 施設略称カナ
     */
    public RString get施設略称カナ() {
        return 施設略称カナ;
    }

    /**
     * 施設カナ住所を返します。
     *
     * @return 施設住所カナ
     */
    public RString get施設住所カナ() {
        return 施設住所カナ;
    }

    /**
     * 異動事由コードを返します。
     *
     * @return 異動事由コード
     */
    public RString get異動事由コード() {
        return 異動事由コード;
    }

    /**
     * 異動年月日を返します。
     *
     * @return 異動年月日
     */
    public FlexibleDate get異動年月日() {
        return 異動年月日;
    }

    /**
     * 法人種別コードを返します。
     *
     * @return 法人種別コード
     */
    public RString get法人種別コード() {
        return 法人種別コード;
    }

    /**
     * 施設開始年月日を返します。
     *
     * @return 施設開始年月日
     */
    public FlexibleDate get施設開始年月日() {
        return 施設開始年月日;
    }

    /**
     * 施設休止年月日を返します。
     *
     * @return 施設休止年月日
     */
    public FlexibleDate get施設休止年月日() {
        return 施設休止年月日;
    }

    /**
     * 施設廃止年月日を返します。
     *
     * @return 施設廃止年月日
     */
    public FlexibleDate get施設廃止年月日() {
        return 施設廃止年月日;
    }

    /**
     * 施設再開年月日を返します。
     *
     * @return 施設再開年月日
     */
    public FlexibleDate get施設再開年月日() {
        return 施設再開年月日;
    }
}
