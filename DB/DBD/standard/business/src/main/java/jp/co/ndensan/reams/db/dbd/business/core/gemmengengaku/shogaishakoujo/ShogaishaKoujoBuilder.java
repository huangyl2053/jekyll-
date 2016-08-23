/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.core.gemmengengaku.shogaishakoujo;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbd.business.core.gemmengengaku.shinsei.GemmenGengakuShinsei;
import jp.co.ndensan.reams.db.dbd.business.core.gemmengengaku.shinsei.GemmenGengakuShinseiIdentifier;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT4038ShogaishaKoujoEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenKyufuRitsu;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.Models;

/**
 * {@link ShogaishaKoujo}の編集を行うビルダークラスです。
 *
 * @reamsid_L DBD-3840-010 wangjie2
 */
public class ShogaishaKoujoBuilder {

    private final DbT4038ShogaishaKoujoEntity entity;
    private final ShogaishaKoujoIdentifier id;
    private final Models<GemmenGengakuShinseiIdentifier, GemmenGengakuShinsei> gemmenGengakuShinsei;

    /**
     * {@link DbT4038ShogaishaKoujoEntity}より{@link ShogaishaKoujo}の編集用Builderクラスを生成します。
     *
     * @param entity {@link DbT4038ShogaishaKoujoEntity}
     * @param id {@link GemmenGengakuShinseiIdentifier}
     *
     */
    ShogaishaKoujoBuilder(
            DbT4038ShogaishaKoujoEntity entity,
            ShogaishaKoujoIdentifier id,
            Models<GemmenGengakuShinseiIdentifier, GemmenGengakuShinsei> gemmenGengakuShinsei
    ) {
        this.entity = entity.clone();
        this.id = id;
        this.gemmenGengakuShinsei = gemmenGengakuShinsei;
    }

    /**
     * 履歴番号を設定します。
     *
     * @param 履歴番号 履歴番号
     * @return {@link ShogaishaKoujoBuilder}
     */
    public ShogaishaKoujoBuilder set履歴番号(int 履歴番号) {
        entity.setRirekiNo(履歴番号);
        return this;
    }

    /**
     * 申請事由を設定します。
     *
     * @param 申請事由 申請事由
     * @return {@link ShogaishaKoujoBuilder}
     */
    public ShogaishaKoujoBuilder set申請事由(RString 申請事由) {
        entity.setShinseiJiyu(申請事由);
        return this;
    }

    /**
     * 給付率を設定します。
     *
     * @param 給付率 給付率
     * @return {@link ShogaishaKoujoBuilder}
     */
    public ShogaishaKoujoBuilder set給付率(HokenKyufuRitsu 給付率) {
        entity.setKyufuritsu(給付率);
        return this;
    }

    /**
     * 申請年月日を設定します。
     *
     * @param 申請年月日 申請年月日
     * @return {@link ShogaishaKoujoBuilder}
     */
    public ShogaishaKoujoBuilder set申請年月日(FlexibleDate 申請年月日) {
        requireNonNull(申請年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("申請年月日"));
        entity.setShinseiYMD(申請年月日);
        return this;
    }

    /**
     * 決定年月日を設定します。
     *
     * @param 決定年月日 決定年月日
     * @return {@link ShogaishaKoujoBuilder}
     */
    public ShogaishaKoujoBuilder set決定年月日(FlexibleDate 決定年月日) {
        entity.setKetteiYMD(決定年月日);
        return this;
    }

    /**
     * 適用開始年月日を設定します。
     *
     * @param 適用開始年月日 適用開始年月日
     * @return {@link ShogaishaKoujoBuilder}
     */
    public ShogaishaKoujoBuilder set適用開始年月日(FlexibleDate 適用開始年月日) {
        entity.setTekiyoKaishiYMD(適用開始年月日);
        return this;
    }

    /**
     * 適用終了年月日を設定します。
     *
     * @param 適用終了年月日 適用終了年月日
     * @return {@link ShogaishaKoujoBuilder}
     */
    public ShogaishaKoujoBuilder set適用終了年月日(FlexibleDate 適用終了年月日) {
        entity.setTekiyoShuryoYMD(適用終了年月日);
        return this;
    }

    /**
     * 決定区分を設定します。
     *
     * @param 決定区分 決定区分
     * @return {@link ShogaishaKoujoBuilder}
     */
    public ShogaishaKoujoBuilder set決定区分(RString 決定区分) {
        entity.setKetteiKubun(決定区分);
        return this;
    }

    /**
     * 非承認理由を設定します。
     *
     * @param 非承認理由 非承認理由
     * @return {@link ShogaishaKoujoBuilder}
     */
    public ShogaishaKoujoBuilder set非承認理由(RString 非承認理由) {
        entity.setHiShoninRiyu(非承認理由);
        return this;
    }

    /**
     * 認定区分を設定します。
     *
     * @param 認定区分 認定区分
     * @return {@link ShogaishaKoujoBuilder}
     */
    public ShogaishaKoujoBuilder set認定区分(RString 認定区分) {
        entity.setNinteiKubun(認定区分);
        return this;
    }

    /**
     * 認定内容を設定します。
     *
     * @param 認定内容 認定内容
     * @return {@link ShogaishaKoujoBuilder}
     */
    public ShogaishaKoujoBuilder set認定内容(RString 認定内容) {
        entity.setNinteiNaiyo(認定内容);
        return this;
    }

    /**
     * 給付率を設定します。
     *
     * @param 給付率 給付率
     * @return {@link ShogaishaKoujoBuilder}
     */
    public ShogaishaKoujoBuilder set給付率(Decimal 給付率) {
        entity.setKyufuritsu(new HokenKyufuRitsu(給付率));
        return this;
    }

    /**
     * 認知症高齢者の日常生活自立度コードを設定します。
     *
     * @param 認知症高齢者の日常生活自立度コード 認知症高齢者の日常生活自立度コード
     * @return {@link ShogaishaKoujoBuilder}
     */
    public ShogaishaKoujoBuilder set認知症高齢者の日常生活自立度コード(Code 認知症高齢者の日常生活自立度コード) {
        entity.setNinchishoNichijoSeikatsuJiritsudoCode(認知症高齢者の日常生活自立度コード);
        return this;
    }

    /**
     * 障がい高齢者の日常生活自立度コードを設定します。
     *
     * @param 障がい高齢者の日常生活自立度コード 障がい高齢者の日常生活自立度コード
     * @return {@link ShogaishaKoujoBuilder}
     */
    public ShogaishaKoujoBuilder set障がい高齢者の日常生活自立度コード(Code 障がい高齢者の日常生活自立度コード) {
        entity.setShogaiNichijoSeikatsuJiritsudoCode(障がい高齢者の日常生活自立度コード);
        return this;
    }

    /**
     * 障がい者手帳有無を設定します。
     *
     * @param 障がい者手帳有無 障がい者手帳有無
     * @return {@link ShogaishaKoujoBuilder}
     */
    public ShogaishaKoujoBuilder set障がい者手帳有無(boolean 障がい者手帳有無) {
        entity.setShogaishaTechoUmu(障がい者手帳有無);
        return this;
    }

    /**
     * 資格喪失事由コードを設定します。
     *
     * @param 資格喪失事由コード 資格喪失事由コード
     * @return {@link ShogaishaKoujoBuilder}
     */
    public ShogaishaKoujoBuilder set資格喪失事由コード(RString 資格喪失事由コード) {
        entity.setShikakuSoshitsuJiyuCode(資格喪失事由コード);
        return this;
    }

    /**
     * 資格喪失年月日を設定します。
     *
     * @param 資格喪失年月日 資格喪失年月日
     * @return {@link ShogaishaKoujoBuilder}
     */
    public ShogaishaKoujoBuilder set資格喪失年月日(FlexibleDate 資格喪失年月日) {
        entity.setShikakuSoshitsuYMD(資格喪失年月日);
        return this;
    }

    /**
     * 対象年度を設定します。
     *
     * @param 対象年度 対象年度
     * @return {@link ShogaishaKoujoBuilder}
     */
    public ShogaishaKoujoBuilder set対象年度(FlexibleYear 対象年度) {
        entity.setTaishoNendo(対象年度);
        return this;
    }

    /**
     * 基準日を設定します。
     *
     * @param 基準日 基準日
     * @return {@link ShogaishaKoujoBuilder}
     */
    public ShogaishaKoujoBuilder set基準日(FlexibleDate 基準日) {
        entity.setKijunYMD(基準日);
        return this;
    }

    /**
     * 把握日を設定します。
     *
     * @param 把握日 把握日
     * @return {@link ShogaishaKoujoBuilder}
     */
    public ShogaishaKoujoBuilder set把握日(FlexibleDate 把握日) {
        entity.setHaakuYMD(把握日);
        return this;
    }

    /**
     * 認定証発行対象外フラグを設定します。
     *
     * @param 認定証発行対象外フラグ 認定証発行対象外フラグ
     * @return {@link ShogaishaKoujoBuilder}
     */
    public ShogaishaKoujoBuilder set認定証発行対象外フラグ(boolean 認定証発行対象外フラグ) {
        requireNonNull(認定証発行対象外フラグ, UrSystemErrorMessages.値がnull.getReplacedMessage("認定証発行対象外フラグ"));
        entity.setNinteishoHakkoTaishogai(認定証発行対象外フラグ);
        return this;
    }

    /**
     * 減免減額申請情報のキー情報について判定します。<br>
     * 障がい書控除に関連できる減免減額申請情報である場合、下記の処理に遷移します。<br>
     * キーが一致する場合は合減免減額申請情報リストに減免減額申請情報{@link GemmenGengakuShinsei}をセットします。<br>
     * キーが一致しない場合、新たに追加します。<br>
     *
     * @param 減免減額申請情報 {@link GemmenGengakuShinsei}
     * @return {@link GogitaiJohoBuilder}
     * @throws IllegalStateException キーが一致しない場合
     */
    public ShogaishaKoujoBuilder setGemmenGengakuShinsei(GemmenGengakuShinsei 減免減額申請情報) {
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
     * {@link ShogaishaKoujo}のインスタンスを生成します。
     *
     * @return {@link ShogaishaKoujo}のインスタンス
     */
    public ShogaishaKoujo build() {
        return new ShogaishaKoujo(entity, id, gemmenGengakuShinsei);
    }
}
