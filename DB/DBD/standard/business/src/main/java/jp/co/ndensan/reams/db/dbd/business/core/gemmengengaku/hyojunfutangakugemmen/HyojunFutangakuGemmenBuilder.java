/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.core.gemmengengaku.hyojunfutangakugemmen;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT4012HyojunFutangakuGemmenEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * {@link HyojunFutangakuGemmen}の編集を行うビルダークラスです。
 *
 * @reamsid_L DBD-9999-023 wangchao
 */
public class HyojunFutangakuGemmenBuilder {

    private final DbT4012HyojunFutangakuGemmenEntity entity;
    private final HyojunFutangakuGemmenIdentifier id;

    /**
     * {@link DbT4012HyojunFutangakuGemmenEntity}より{@link HyojunFutangakuGemmen}の編集用Builderクラスを生成します。
     *
     * @param entity {@link DbT4012HyojunFutangakuGemmenEntity}
     * @param id {@link HyojunFutangakuGemmenIdentifier}
     *
     */
    HyojunFutangakuGemmenBuilder(
            DbT4012HyojunFutangakuGemmenEntity entity,
            HyojunFutangakuGemmenIdentifier id
    ) {
        this.entity = entity.clone();
        this.id = id;

    }

    /**
     * 論理削除行であればtrueを設定します。
     *
     * @param 論理削除行であればtrue 論理削除行であればtrue
     * @return {@link HyojunFutangakuGemmenBuilder}
     */
    public HyojunFutangakuGemmenBuilder set論理削除行であればtrue(boolean 論理削除行であればtrue) {
        requireNonNull(論理削除行であればtrue, UrSystemErrorMessages.値がnull.getReplacedMessage("論理削除行であればtrue"));
        entity.setIsDeleted(論理削除行であればtrue);
        return this;
    }

    /**
     * 最後にupdateしたReamsログインidを設定します。
     *
     * @param 最後にupdateしたReamsログインid 最後にupdateしたReamsログインid
     * @return {@link HyojunFutangakuGemmenBuilder}
     */
    public HyojunFutangakuGemmenBuilder set最後にupdateしたReamsログインid(RString 最後にupdateしたReamsログインid) {
        requireNonNull(最後にupdateしたReamsログインid, UrSystemErrorMessages.値がnull.getReplacedMessage("最後にupdateしたReamsログインid"));
        entity.setLastUpdateReamsLoginId(最後にupdateしたReamsログインid);
        return this;
    }

    /**
     * 証記載保険者番号を設定します。
     *
     * @param 証記載保険者番号 証記載保険者番号
     * @return {@link HyojunFutangakuGemmenBuilder}
     */
    public HyojunFutangakuGemmenBuilder set証記載保険者番号(ShoKisaiHokenshaNo 証記載保険者番号) {
        requireNonNull(証記載保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("証記載保険者番号"));
        entity.setShoKisaiHokenshaNo(証記載保険者番号);
        return this;
    }

    /**
     * 被保険者番号を設定します。
     *
     * @param 被保険者番号 被保険者番号
     * @return {@link HyojunFutangakuGemmenBuilder}
     */
    public HyojunFutangakuGemmenBuilder set被保険者番号(HihokenshaNo 被保険者番号) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        entity.setHihokenshaNo(被保険者番号);
        return this;
    }

    /**
     * 履歴番号を設定します。
     *
     * @param 履歴番号 履歴番号
     * @return {@link HyojunFutangakuGemmenBuilder}
     */
    public HyojunFutangakuGemmenBuilder set履歴番号(int 履歴番号) {
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));
        entity.setRirekiNo(履歴番号);
        return this;
    }

    /**
     * 申請事由を設定します。
     *
     * @param 申請事由 申請事由
     * @return {@link HyojunFutangakuGemmenBuilder}
     */
    public HyojunFutangakuGemmenBuilder set申請事由(RString 申請事由) {
        requireNonNull(申請事由, UrSystemErrorMessages.値がnull.getReplacedMessage("申請事由"));
        entity.setShinseiJiyu(申請事由);
        return this;
    }

    /**
     * 減額区分を設定します。
     *
     * @param 減額区分 減額区分
     * @return {@link HyojunFutangakuGemmenBuilder}
     */
    public HyojunFutangakuGemmenBuilder set減額区分(RString 減額区分) {
        requireNonNull(減額区分, UrSystemErrorMessages.値がnull.getReplacedMessage("減額区分"));
        entity.setGengakuKubun(減額区分);
        return this;
    }

    /**
     * 減額後金額を設定します。
     *
     * @param 減額後金額 減額後金額
     * @return {@link HyojunFutangakuGemmenBuilder}
     */
    public HyojunFutangakuGemmenBuilder set減額後金額(Decimal 減額後金額) {
        requireNonNull(減額後金額, UrSystemErrorMessages.値がnull.getReplacedMessage("減額後金額"));
        entity.setGengakugoKingaku(減額後金額);
        return this;
    }

    /**
     * 標準負担区分を設定します。
     *
     * @param 標準負担区分 標準負担区分
     * @return {@link HyojunFutangakuGemmenBuilder}
     */
    public HyojunFutangakuGemmenBuilder set標準負担区分(RString 標準負担区分) {
        requireNonNull(標準負担区分, UrSystemErrorMessages.値がnull.getReplacedMessage("標準負担区分"));
        entity.setHyojunFutanKubun(標準負担区分);
        return this;
    }

    /**
     * 申請年月日を設定します。
     *
     * @param 申請年月日 申請年月日
     * @return {@link HyojunFutangakuGemmenBuilder}
     */
    public HyojunFutangakuGemmenBuilder set申請年月日(FlexibleDate 申請年月日) {
        requireNonNull(申請年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("申請年月日"));
        entity.setShinseiYMD(申請年月日);
        return this;
    }

    /**
     * 決定区分を設定します。
     *
     * @param 決定区分 決定区分
     * @return {@link HyojunFutangakuGemmenBuilder}
     */
    public HyojunFutangakuGemmenBuilder set決定区分(RString 決定区分) {
        requireNonNull(決定区分, UrSystemErrorMessages.値がnull.getReplacedMessage("決定区分"));
        entity.setKetteiKubun(決定区分);
        return this;
    }

    /**
     * 決定年月日を設定します。
     *
     * @param 決定年月日 決定年月日
     * @return {@link HyojunFutangakuGemmenBuilder}
     */
    public HyojunFutangakuGemmenBuilder set決定年月日(FlexibleDate 決定年月日) {
        requireNonNull(決定年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("決定年月日"));
        entity.setKetteiYMD(決定年月日);
        return this;
    }

    /**
     * 適用開始年月日を設定します。
     *
     * @param 適用開始年月日 適用開始年月日
     * @return {@link HyojunFutangakuGemmenBuilder}
     */
    public HyojunFutangakuGemmenBuilder set適用開始年月日(FlexibleDate 適用開始年月日) {
        requireNonNull(適用開始年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("適用開始年月日"));
        entity.setTekiyoKaishiYMD(適用開始年月日);
        return this;
    }

    /**
     * 適用終了年月日を設定します。
     *
     * @param 適用終了年月日 適用終了年月日
     * @return {@link HyojunFutangakuGemmenBuilder}
     */
    public HyojunFutangakuGemmenBuilder set適用終了年月日(FlexibleDate 適用終了年月日) {
        requireNonNull(適用終了年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("適用終了年月日"));
        entity.setTekiyoShuryoYMD(適用終了年月日);
        return this;
    }

    /**
     * 非承認理由を設定します。
     *
     * @param 非承認理由 非承認理由
     * @return {@link HyojunFutangakuGemmenBuilder}
     */
    public HyojunFutangakuGemmenBuilder set非承認理由(RString 非承認理由) {
        requireNonNull(非承認理由, UrSystemErrorMessages.値がnull.getReplacedMessage("非承認理由"));
        entity.setHiShoninRiyu(非承認理由);
        return this;
    }

    /**
     * {@link HyojunFutangakuGemmen}のインスタンスを生成します。
     *
     * @return {@link HyojunFutangakuGemmen}のインスタンス
     */
    public HyojunFutangakuGemmen build() {
        return new HyojunFutangakuGemmen(entity, id);
    }
}
