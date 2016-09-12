/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.core.gemmengengaku.riyoshafutangengaku;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbd.business.core.gemmengengaku.shinsei.GemmenGengakuShinsei;
import jp.co.ndensan.reams.db.dbd.business.core.gemmengengaku.shinsei.GemmenGengakuShinseiIdentifier;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT4014RiyoshaFutangakuGengakuEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenKyufuRitsu;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.Models;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * {@link RiyoshaFutangakuGengaku}の編集を行うビルダークラスです。
 *
 * @reamsid_L DBD-9999-011 sunhaidi
 */
public class RiyoshaFutangakuGengakuBuilder {

    private final DbT4014RiyoshaFutangakuGengakuEntity entity;
    private final RiyoshaFutangakuGengakuIdentifier id;
    private final Models<GemmenGengakuShinseiIdentifier, GemmenGengakuShinsei> gemmenGengakuShinsei;

    /**
     * {@link DbT4014RiyoshaFutangakuGengakuEntity}より{@link RiyoshaFutangakuGengaku}の編集用Builderクラスを生成します。
     *
     * @param entity {@link DbT4014RiyoshaFutangakuGengakuEntity}
     * @param id {@link RiyoshaFutangakuGengakuIdentifier}
     * @param gemmenGengakuShinsei {@link GemmenGengakuShinsei}
     */
    RiyoshaFutangakuGengakuBuilder(
            DbT4014RiyoshaFutangakuGengakuEntity entity,
            RiyoshaFutangakuGengakuIdentifier id,
            Models<GemmenGengakuShinseiIdentifier, GemmenGengakuShinsei> gemmenGengakuShinsei
    ) {
        this.entity = entity.clone();
        this.id = id;
        this.gemmenGengakuShinsei = gemmenGengakuShinsei;
    }

    /**
     * EntityDataStateを設定します
     *
     * @param state EntityDataState
     * @return {@link RiyoshaFutangakuGengakuBuilder}
     */
    public RiyoshaFutangakuGengakuBuilder setState(EntityDataState state) {
        requireNonNull(state, UrSystemErrorMessages.値がnull.getReplacedMessage("EntityDataState"));
        entity.setState(state);
        return this;
    }

    /**
     * 履歴番号を設定します。
     *
     * @param 履歴番号 履歴番号
     * @return {@link RiyoshaFutangakuGengakuBuilder}
     */
    public RiyoshaFutangakuGengakuBuilder set履歴番号(int 履歴番号) {
        entity.setRirekiNo(履歴番号);
        return this;
    }

    /**
     * 旧措置者有無を設定します。
     *
     * @param 旧措置者有無 旧措置者有無
     * @return {@link RiyoshaFutangakuGengakuBuilder}
     */
    public RiyoshaFutangakuGengakuBuilder set旧措置者有無(boolean 旧措置者有無) {
        entity.setKyuSochishaUmu(旧措置者有無);
        return this;
    }

    /**
     * 申請事由を設定します。
     *
     * @param 申請事由 申請事由
     * @return {@link RiyoshaFutangakuGengakuBuilder}
     */
    public RiyoshaFutangakuGengakuBuilder set申請事由(RString 申請事由) {
        requireNonNull(申請事由, UrSystemErrorMessages.値がnull.getReplacedMessage("申請事由"));
        entity.setShinseiJiyu(申請事由);
        return this;
    }

    /**
     * 給付率を設定します。
     *
     * @param 給付率 給付率
     * @return {@link RiyoshaFutangakuGengakuBuilder}
     */
    public RiyoshaFutangakuGengakuBuilder set給付率(HokenKyufuRitsu 給付率) {
        requireNonNull(給付率, UrSystemErrorMessages.値がnull.getReplacedMessage("給付率"));
        entity.setKyuhuritsu(給付率);
        return this;
    }

    /**
     * 申請年月日を設定します。
     *
     * @param 申請年月日 申請年月日
     * @return {@link RiyoshaFutangakuGengakuBuilder}
     */
    public RiyoshaFutangakuGengakuBuilder set申請年月日(FlexibleDate 申請年月日) {
        requireNonNull(申請年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("申請年月日"));
        entity.setShinseiYMD(申請年月日);
        return this;
    }

    /**
     * 決定年月日を設定します。
     *
     * @param 決定年月日 決定年月日
     * @return {@link RiyoshaFutangakuGengakuBuilder}
     */
    public RiyoshaFutangakuGengakuBuilder set決定年月日(FlexibleDate 決定年月日) {
        requireNonNull(決定年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("決定年月日"));
        entity.setKetteiYMD(決定年月日);
        return this;
    }

    /**
     * 適用開始年月日を設定します。
     *
     * @param 適用開始年月日 適用開始年月日
     * @return {@link RiyoshaFutangakuGengakuBuilder}
     */
    public RiyoshaFutangakuGengakuBuilder set適用開始年月日(FlexibleDate 適用開始年月日) {
        requireNonNull(適用開始年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("適用開始年月日"));
        entity.setTekiyoKaishiYMD(適用開始年月日);
        return this;
    }

    /**
     * 適用終了年月日を設定します。
     *
     * @param 適用終了年月日 適用終了年月日
     * @return {@link RiyoshaFutangakuGengakuBuilder}
     */
    public RiyoshaFutangakuGengakuBuilder set適用終了年月日(FlexibleDate 適用終了年月日) {
        requireNonNull(適用終了年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("適用終了年月日"));
        entity.setTekiyoShuryoYMD(適用終了年月日);
        return this;
    }

    /**
     * 決定区分を設定します。
     *
     * @param 決定区分 決定区分
     * @return {@link RiyoshaFutangakuGengakuBuilder}
     */
    public RiyoshaFutangakuGengakuBuilder set決定区分(RString 決定区分) {
        requireNonNull(決定区分, UrSystemErrorMessages.値がnull.getReplacedMessage("決定区分"));
        entity.setKetteiKubun(決定区分);
        return this;
    }

    /**
     * 非承認理由を設定します。
     *
     * @param 非承認理由 非承認理由
     * @return {@link RiyoshaFutangakuGengakuBuilder}
     */
    public RiyoshaFutangakuGengakuBuilder set非承認理由(RString 非承認理由) {
        requireNonNull(非承認理由, UrSystemErrorMessages.値がnull.getReplacedMessage("非承認理由"));
        entity.setHiShoninRiyu(非承認理由);
        return this;
    }

    /**
     * 減免減額申請情報のキー情報について判定します。<br>
     * 利用者負担額減額に関連できる減免減額申請情報である場合、下記の処理に遷移します。<br>
     * キーが一致する場合は合減免減額申請情報リストに減免減額申請情報{@link GemmenGengakuShinsei}をセットします。<br>
     * キーが一致しない場合、新たに追加します。<br>
     *
     * @param 減免減額申請情報 {@link GemmenGengakuShinsei}
     * @return {@link GogitaiJohoBuilder}
     * @throws IllegalStateException キーが一致しない場合
     */
    public RiyoshaFutangakuGengakuBuilder setGemmenGengakuShinsei(GemmenGengakuShinsei 減免減額申請情報) {
        if (hasSameIdentifier(減免減額申請情報.identifier())) {
            gemmenGengakuShinsei.add(減免減額申請情報);
            return this;
        }
        throw new IllegalArgumentException(UrErrorMessages.不正.toString());
    }

    private boolean hasSameIdentifier(GemmenGengakuShinseiIdentifier 減免減額申請識別子) {
        return (id.get履歴番号() == 減免減額申請識別子.get履歴番号())
                && id.get被保険者番号().equals(減免減額申請識別子.get被保険者番号())
                && id.get証記載保険者番号().equals(減免減額申請識別子.get証記載保険者番号());
    }

    /**
     * {@link RiyoshaFutangakuGengaku}のインスタンスを生成します。
     *
     * @return {@link RiyoshaFutangakuGengaku}のインスタンス
     */
    public RiyoshaFutangakuGengaku build() {
        return new RiyoshaFutangakuGengaku(entity, id, gemmenGengakuShinsei);
    }
}
