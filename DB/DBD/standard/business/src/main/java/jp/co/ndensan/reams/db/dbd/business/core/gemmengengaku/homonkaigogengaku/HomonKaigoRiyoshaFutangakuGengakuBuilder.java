/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.core.gemmengengaku.homonkaigogengaku;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbd.business.core.gemmengengaku.shinsei.GemmenGengakuShinsei;
import jp.co.ndensan.reams.db.dbd.business.core.gemmengengaku.shinsei.GemmenGengakuShinseiIdentifier;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT4016HomonKaigoRiyoshaFutangakuGengakuEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenKyufuRitsu;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.Models;

/**
 * {@link HomonKaigoRiyoshaFutangakuGengaku}の編集を行うビルダークラスです。
 *
 * @reamsid_L DBD-9999-013 huangh
 */
public class HomonKaigoRiyoshaFutangakuGengakuBuilder {

    private final DbT4016HomonKaigoRiyoshaFutangakuGengakuEntity entity;
    private final HomonKaigoRiyoshaFutangakuGengakuIdentifier id;
    private final Models<GemmenGengakuShinseiIdentifier, GemmenGengakuShinsei> gemmenGengakuShinsei;

    /**
     * {@link DbT4016HomonKaigoRiyoshaFutangakuGengakuEntity}より{@link HomonKaigoRiyoshaFutangakuGengaku}の編集用Builderクラスを生成します。
     *
     * @param entity {@link DbT4016HomonKaigoRiyoshaFutangakuGengakuEntity}
     * @param id {@link HomonKaigoRiyoshaFutangakuGengakuIdentifier}
     * @param seishinTechoNini {@link Models}
     * @param todokedesha {@link Models}
     *
     */
    HomonKaigoRiyoshaFutangakuGengakuBuilder(
            DbT4016HomonKaigoRiyoshaFutangakuGengakuEntity entity,
            HomonKaigoRiyoshaFutangakuGengakuIdentifier id,
            Models<GemmenGengakuShinseiIdentifier, GemmenGengakuShinsei> gemmenGengakuShinsei
    ) {
        this.entity = entity.clone();
        this.id = id;
        this.gemmenGengakuShinsei = gemmenGengakuShinsei.clone();

    }

    /**
     * 法別区分を設定します。
     *
     * @param 法別区分 法別区分
     * @return {@link HomonKaigoRiyoshaFutangakuGengakuBuilder}
     */
    public HomonKaigoRiyoshaFutangakuGengakuBuilder set法別区分(RString 法別区分) {
        requireNonNull(法別区分, UrSystemErrorMessages.値がnull.getReplacedMessage("法別区分"));
        entity.setHobetsuKubun(法別区分);
        return this;
    }

    /**
     * 障害者手帳有無を設定します。
     *
     * @param 障害者手帳有無 障害者手帳有無
     * @return {@link HomonKaigoRiyoshaFutangakuGengakuBuilder}
     */
    public HomonKaigoRiyoshaFutangakuGengakuBuilder set障害者手帳有無(boolean 障害者手帳有無) {
        entity.setShogaishaTechoUmu(障害者手帳有無);
        return this;
    }

    /**
     * 障害者手帳等級を設定します。
     *
     * @param 障害者手帳等級 障害者手帳等級
     * @return {@link HomonKaigoRiyoshaFutangakuGengakuBuilder}
     */
    public HomonKaigoRiyoshaFutangakuGengakuBuilder set障害者手帳等級(RString 障害者手帳等級) {
        requireNonNull(障害者手帳等級, UrSystemErrorMessages.値がnull.getReplacedMessage("障害者手帳等級"));
        entity.setShogaishaTechoTokyu(障害者手帳等級);
        return this;
    }

    /**
     * 障害者手帳番号を設定します。
     *
     * @param 障害者手帳番号 障害者手帳番号
     * @return {@link HomonKaigoRiyoshaFutangakuGengakuBuilder}
     */
    public HomonKaigoRiyoshaFutangakuGengakuBuilder set障害者手帳番号(RString 障害者手帳番号) {
        requireNonNull(障害者手帳番号, UrSystemErrorMessages.値がnull.getReplacedMessage("障害者手帳番号"));
        entity.setShogaishaTechoNo(障害者手帳番号);
        return this;
    }

    /**
     * 障害者手帳交付年月日を設定します。
     *
     * @param 障害者手帳交付年月日 障害者手帳交付年月日
     * @return {@link HomonKaigoRiyoshaFutangakuGengakuBuilder}
     */
    public HomonKaigoRiyoshaFutangakuGengakuBuilder set障害者手帳交付年月日(FlexibleDate 障害者手帳交付年月日) {
        requireNonNull(障害者手帳交付年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("障害者手帳交付年月日"));
        entity.setShogaishaTechoKofuYMD(障害者手帳交付年月日);
        return this;
    }

    /**
     * 申請事由を設定します。
     *
     * @param 申請事由 申請事由
     * @return {@link HomonKaigoRiyoshaFutangakuGengakuBuilder}
     */
    public HomonKaigoRiyoshaFutangakuGengakuBuilder set申請事由(RString 申請事由) {
        requireNonNull(申請事由, UrSystemErrorMessages.値がnull.getReplacedMessage("申請事由"));
        entity.setShinseiJiyu(申請事由);
        return this;
    }

    /**
     * 給付率を設定します。
     *
     * @param 給付率 給付率
     * @return {@link HomonKaigoRiyoshaFutangakuGengakuBuilder}
     */
    public HomonKaigoRiyoshaFutangakuGengakuBuilder set給付率(HokenKyufuRitsu 給付率) {
        entity.setKyufuritsu(給付率);
        return this;
    }

    /**
     * 公費負担者番号を設定します。
     *
     * @param 公費負担者番号 公費負担者番号
     * @return {@link HomonKaigoRiyoshaFutangakuGengakuBuilder}
     */
    public HomonKaigoRiyoshaFutangakuGengakuBuilder set公費負担者番号(RString 公費負担者番号) {
        requireNonNull(公費負担者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("公費負担者番号"));
        entity.setKohiFutanshaNo(公費負担者番号);
        return this;
    }

    /**
     * 公費受給者番号を設定します。
     *
     * @param 公費受給者番号 公費受給者番号
     * @return {@link HomonKaigoRiyoshaFutangakuGengakuBuilder}
     */
    public HomonKaigoRiyoshaFutangakuGengakuBuilder set公費受給者番号(RString 公費受給者番号) {
        requireNonNull(公費受給者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("公費受給者番号"));
        entity.setKohiJukyushaNo(公費受給者番号);
        return this;
    }

    /**
     * 申請年月日を設定します。
     *
     * @param 申請年月日 申請年月日
     * @return {@link HomonKaigoRiyoshaFutangakuGengakuBuilder}
     */
    public HomonKaigoRiyoshaFutangakuGengakuBuilder set申請年月日(FlexibleDate 申請年月日) {
        requireNonNull(申請年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("申請年月日"));
        entity.setShinseiYMD(申請年月日);
        return this;
    }

    /**
     * 決定年月日を設定します。
     *
     * @param 決定年月日 決定年月日
     * @return {@link HomonKaigoRiyoshaFutangakuGengakuBuilder}
     */
    public HomonKaigoRiyoshaFutangakuGengakuBuilder set決定年月日(FlexibleDate 決定年月日) {
        requireNonNull(決定年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("決定年月日"));
        entity.setKetteiYMD(決定年月日);
        return this;
    }

    /**
     * 適用開始年月日を設定します。
     *
     * @param 適用開始年月日 適用開始年月日
     * @return {@link HomonKaigoRiyoshaFutangakuGengakuBuilder}
     */
    public HomonKaigoRiyoshaFutangakuGengakuBuilder set適用開始年月日(FlexibleDate 適用開始年月日) {
        requireNonNull(適用開始年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("適用開始年月日"));
        entity.setTekiyoKaishiYMD(適用開始年月日);
        return this;
    }

    /**
     * 適用終了年月日を設定します。
     *
     * @param 適用終了年月日 適用終了年月日
     * @return {@link HomonKaigoRiyoshaFutangakuGengakuBuilder}
     */
    public HomonKaigoRiyoshaFutangakuGengakuBuilder set適用終了年月日(FlexibleDate 適用終了年月日) {
        requireNonNull(適用終了年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("適用終了年月日"));
        entity.setTekiyoShuryoYMD(適用終了年月日);
        return this;
    }

    /**
     * 決定区分を設定します。
     *
     * @param 決定区分 決定区分
     * @return {@link HomonKaigoRiyoshaFutangakuGengakuBuilder}
     */
    public HomonKaigoRiyoshaFutangakuGengakuBuilder set決定区分(RString 決定区分) {
        requireNonNull(決定区分, UrSystemErrorMessages.値がnull.getReplacedMessage("決定区分"));
        entity.setKetteiKubun(決定区分);
        return this;
    }

    /**
     * 非承認理由を設定します。
     *
     * @param 非承認理由 非承認理由
     * @return {@link HomonKaigoRiyoshaFutangakuGengakuBuilder}
     */
    public HomonKaigoRiyoshaFutangakuGengakuBuilder set非承認理由(RString 非承認理由) {
        requireNonNull(非承認理由, UrSystemErrorMessages.値がnull.getReplacedMessage("非承認理由"));
        entity.setHiShoninRiyu(非承認理由);
        return this;
    }

    /**
     * 精神手帳任意項目情報のキー情報について判定します。<br>
     * 精神手帳情報に関連できる減免減額申請情報である場合、下記の処理に遷移します。<br>
     * キーが一致する場合は精神手帳任意項目情報リストに減免減額申請情報{@link GemmenGengakuShinsei}をセットします。<br>
     * キーが一致しない場合、新たに追加します。<br>
     *
     * @param 減免減額申請情報 {@link GemmenGengakuShinsei}
     * @return {@link HomonKaigoRiyoshaFutangakuGengakuBuilder}
     * @throws IllegalStateException キーが一致しない場合
     */
    public HomonKaigoRiyoshaFutangakuGengakuBuilder setGemmenGengakuShinsei(GemmenGengakuShinsei 減免減額申請情報) {
        if (hasSameIdentifier(減免減額申請情報.identifier())) {
            gemmenGengakuShinsei.add(減免減額申請情報);
            return this;
        }
        throw new IllegalArgumentException(UrErrorMessages.不正.toString());
    }

    private boolean hasSameIdentifier(GemmenGengakuShinseiIdentifier 減免減額申請情報識別子) {
        return (id.get被保険者番号().equals(減免減額申請情報識別子.get被保険者番号())
                && id.get履歴番号() == 減免減額申請情報識別子.get履歴番号());
    }

    /**
     * {@link HomonKaigoRiyoshaFutangakuGengaku}のインスタンスを生成します。
     *
     * @return {@link HomonKaigoRiyoshaFutangakuGengaku}のインスタンス
     */
    public HomonKaigoRiyoshaFutangakuGengaku build() {
        return new HomonKaigoRiyoshaFutangakuGengaku(entity, id, gemmenGengakuShinsei);
    }
    // </editor-fold>
}
