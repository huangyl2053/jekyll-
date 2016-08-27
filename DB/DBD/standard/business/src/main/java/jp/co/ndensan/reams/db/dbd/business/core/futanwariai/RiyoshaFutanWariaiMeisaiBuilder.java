/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.core.futanwariai;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT3114RiyoshaFutanWariaiMeisaiEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.SetaiCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * {@link RiyoshaFutanWariaiMeisai}の編集を行うビルダークラスです。
 *
 * @reamsid_L DBC-5010-011 zhaowei
 */
public class RiyoshaFutanWariaiMeisaiBuilder {

    private final DbT3114RiyoshaFutanWariaiMeisaiEntity entity;
    private final RiyoshaFutanWariaiMeisaiIdentifier id;

    /**
     * {@link DbT3114RiyoshaFutanWariaiMeisaiEntity}より{@link RiyoshaFutanWariaiMeisai}の編集用Builderクラスを生成します。
     *
     * @param entity {@link DbT3114RiyoshaFutanWariaiMeisaiEntity}
     * @param id {@link RiyoshaFutanWariaiMeisaiIdentifier}
     *
     */
    RiyoshaFutanWariaiMeisaiBuilder(
            DbT3114RiyoshaFutanWariaiMeisaiEntity entity,
            RiyoshaFutanWariaiMeisaiIdentifier id
    ) {
        this.entity = entity.clone();
        this.id = id;

    }

//TODO Key項目のsetterメソッドは削除してください。
//TODO 一緒に置換される値のまとまりで不変なクラスを作成し、その単位でsetterを作る様に見直してください。
    /**
     * 年度を設定します。
     *
     * @param 年度 年度
     * @return {@link RiyoshaFutanWariaiMeisaiBuilder}
     */
    public RiyoshaFutanWariaiMeisaiBuilder set年度(FlexibleYear 年度) {
        requireNonNull(年度, UrSystemErrorMessages.値がnull.getReplacedMessage("年度"));
        entity.setNendo(年度);
        return this;
    }

    /**
     * 被保険者番号を設定します。
     *
     * @param 被保険者番号 被保険者番号
     * @return {@link RiyoshaFutanWariaiMeisaiBuilder}
     */
    public RiyoshaFutanWariaiMeisaiBuilder set被保険者番号(HihokenshaNo 被保険者番号) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        entity.setHihokenshaNo(被保険者番号);
        return this;
    }

    /**
     * 履歴番号を設定します。
     *
     * @param 履歴番号 履歴番号
     * @return {@link RiyoshaFutanWariaiMeisaiBuilder}
     */
    public RiyoshaFutanWariaiMeisaiBuilder set履歴番号(int 履歴番号) {
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));
        entity.setRirekiNo(履歴番号);
        return this;
    }

    /**
     * 枝番号を設定します。
     *
     * @param 枝番号 枝番号
     * @return {@link RiyoshaFutanWariaiMeisaiBuilder}
     */
    public RiyoshaFutanWariaiMeisaiBuilder set枝番号(int 枝番号) {
        requireNonNull(枝番号, UrSystemErrorMessages.値がnull.getReplacedMessage("枝番号"));
        entity.setEdaNo(枝番号);
        return this;
    }

    /**
     * 資格区分を設定します。
     *
     * @param 資格区分 資格区分
     * @return {@link RiyoshaFutanWariaiMeisaiBuilder}
     */
    public RiyoshaFutanWariaiMeisaiBuilder set資格区分(RString 資格区分) {
        requireNonNull(資格区分, UrSystemErrorMessages.値がnull.getReplacedMessage("資格区分"));
        entity.setShikakuKubun(資格区分);
        return this;
    }

    /**
     * 負担割合区分を設定します。
     *
     * @param 負担割合区分 負担割合区分
     * @return {@link RiyoshaFutanWariaiMeisaiBuilder}
     */
    public RiyoshaFutanWariaiMeisaiBuilder set負担割合区分(RString 負担割合区分) {
        requireNonNull(負担割合区分, UrSystemErrorMessages.値がnull.getReplacedMessage("負担割合区分"));
        entity.setFutanWariaiKubun(負担割合区分);
        return this;
    }

    /**
     * 有効開始日を設定します。
     *
     * @param 有効開始日 有効開始日
     * @return {@link RiyoshaFutanWariaiMeisaiBuilder}
     */
    public RiyoshaFutanWariaiMeisaiBuilder set有効開始日(FlexibleDate 有効開始日) {
        requireNonNull(有効開始日, UrSystemErrorMessages.値がnull.getReplacedMessage("有効開始日"));
        entity.setYukoKaishiYMD(有効開始日);
        return this;
    }

    /**
     * 有効終了日を設定します。
     *
     * @param 有効終了日 有効終了日
     * @return {@link RiyoshaFutanWariaiMeisaiBuilder}
     */
    public RiyoshaFutanWariaiMeisaiBuilder set有効終了日(FlexibleDate 有効終了日) {
        requireNonNull(有効終了日, UrSystemErrorMessages.値がnull.getReplacedMessage("有効終了日"));
        entity.setYukoShuryoYMD(有効終了日);
        return this;
    }

    /**
     * 本人合計所得金額を設定します。
     *
     * @param 本人合計所得金額 本人合計所得金額
     * @return {@link RiyoshaFutanWariaiMeisaiBuilder}
     */
    public RiyoshaFutanWariaiMeisaiBuilder set本人合計所得金額(Decimal 本人合計所得金額) {
        requireNonNull(本人合計所得金額, UrSystemErrorMessages.値がnull.getReplacedMessage("本人合計所得金額"));
        entity.setHonninGoukeiShotokuGaku(本人合計所得金額);
        return this;
    }

    /**
     * 世帯１号被保険者数を設定します。
     *
     * @param 世帯１号被保険者数 世帯１号被保険者数
     * @return {@link RiyoshaFutanWariaiMeisaiBuilder}
     */
    public RiyoshaFutanWariaiMeisaiBuilder set世帯１号被保険者数(int 世帯１号被保険者数) {
        requireNonNull(世帯１号被保険者数, UrSystemErrorMessages.値がnull.getReplacedMessage("世帯１号被保険者数"));
        entity.setSetaiIchigouHihokenshaSu(世帯１号被保険者数);
        return this;
    }

    /**
     * 年金収入合計を設定します。
     *
     * @param 年金収入合計 年金収入合計
     * @return {@link RiyoshaFutanWariaiMeisaiBuilder}
     */
    public RiyoshaFutanWariaiMeisaiBuilder set年金収入合計(Decimal 年金収入合計) {
        requireNonNull(年金収入合計, UrSystemErrorMessages.値がnull.getReplacedMessage("年金収入合計"));
        entity.setNenkinShunyuGoukei(年金収入合計);
        return this;
    }

    /**
     * その他の合計所得金額合計を設定します。
     *
     * @param その他の合計所得金額合計 その他の合計所得金額合計
     * @return {@link RiyoshaFutanWariaiMeisaiBuilder}
     */
    public RiyoshaFutanWariaiMeisaiBuilder setその他の合計所得金額合計(Decimal その他の合計所得金額合計) {
        requireNonNull(その他の合計所得金額合計, UrSystemErrorMessages.値がnull.getReplacedMessage("その他の合計所得金額合計"));
        entity.setSonotanoGoukeiShotokuKingakuGoukei(その他の合計所得金額合計);
        return this;
    }

    /**
     * 更正理由を設定します。
     *
     * @param 更正理由 更正理由
     * @return {@link RiyoshaFutanWariaiMeisaiBuilder}
     */
    public RiyoshaFutanWariaiMeisaiBuilder set更正理由(RString 更正理由) {
        requireNonNull(更正理由, UrSystemErrorMessages.値がnull.getReplacedMessage("更正理由"));
        entity.setKoseiRiyu(更正理由);
        return this;
    }

    /**
     * 世帯コードを設定します。
     *
     * @param 世帯コード 世帯コード
     * @return {@link RiyoshaFutanWariaiMeisaiBuilder}
     */
    public RiyoshaFutanWariaiMeisaiBuilder set世帯コード(SetaiCode 世帯コード) {
        requireNonNull(世帯コード, UrSystemErrorMessages.値がnull.getReplacedMessage("世帯コード"));
        entity.setSetaiCd(世帯コード);
        return this;
    }

    /**
     * 世帯コードを設定します。
     *
     * @param 論理削除フラグ 論理削除フラグ
     * @return {@link RiyoshaFutanWariaiMeisaiBuilder}
     */
    public RiyoshaFutanWariaiMeisaiBuilder set論理削除フラグ(boolean 論理削除フラグ) {
        entity.setLogicalDeletedFlag(論理削除フラグ);
        return this;
    }

    /**
     * {@link RiyoshaFutanWariaiMeisai}のインスタンスを生成します。
     *
     * @return {@link RiyoshaFutanWariaiMeisai}のインスタンス
     */
    public RiyoshaFutanWariaiMeisai build() {
        return new RiyoshaFutanWariaiMeisai(entity, id);
    }

    /**
     * setRiyoshaFutanWariaiKonkyo
     *
     * @param createRiyoshaFutanWariaiKonkyo RiyoshaFutanWariaiKonkyo
     * @return UnsupportedOperationException("Not supported yet.")
     */
    public RiyoshaFutanWariaiMeisaiBuilder setRiyoshaFutanWariaiKonkyo(RiyoshaFutanWariaiKonkyo createRiyoshaFutanWariaiKonkyo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
