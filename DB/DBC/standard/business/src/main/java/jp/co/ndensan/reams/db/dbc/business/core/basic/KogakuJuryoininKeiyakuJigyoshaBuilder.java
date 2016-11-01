/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3076KogakuJuryoininKeiyakuJigyoshaEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 高額受領委任契約事業者を管理のBuilderです。
 *
 * @reamsid_L DBC-9999-012 yuqingzhang
 */
public class KogakuJuryoininKeiyakuJigyoshaBuilder {

    private final DbT3076KogakuJuryoininKeiyakuJigyoshaEntity entity;
    private final KogakuJuryoininKeiyakuJigyoshaIdentifier id;

    /**
     * {@link DbT3076KogakuJuryoininKeiyakuJigyoshaEntity}より{@link KogakuJuryoininKeiyakuJigyosha}の編集用Builderクラスを生成します。
     *
     * @param entity {@link DbT3076KogakuJuryoininKeiyakuJigyoshaEntity}
     * @param id {@link KogakuJuryoininKeiyakuJigyoshaIdentifier}
     *
     */
    KogakuJuryoininKeiyakuJigyoshaBuilder(
            DbT3076KogakuJuryoininKeiyakuJigyoshaEntity entity,
            KogakuJuryoininKeiyakuJigyoshaIdentifier id
    ) {
        this.entity = entity.clone();
        this.id = id;

    }

//TODO Key項目のsetterメソッドは削除してください。
//TODO 一緒に置換される値のまとまりで不変なクラスを作成し、その単位でsetterを作る様に見直してください。
    /**
     * 被保険者番号を設定します。
     *
     * @param 被保険者番号 被保険者番号
     * @return {@link KogakuJuryoininKeiyakuJigyoshaBuilder}
     */
    public KogakuJuryoininKeiyakuJigyoshaBuilder set被保険者番号(HihokenshaNo 被保険者番号) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        entity.setHihokenshaNo(被保険者番号);
        return this;
    }

    /**
     * 受付年月日を設定します。
     *
     * @param 受付年月日 受付年月日
     * @return {@link KogakuJuryoininKeiyakuJigyoshaBuilder}
     */
    public KogakuJuryoininKeiyakuJigyoshaBuilder set受付年月日(FlexibleDate 受付年月日) {
        requireNonNull(受付年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("受付年月日"));
        entity.setUketsukeYMD(受付年月日);
        return this;
    }

    /**
     * 履歴番号を設定します。
     *
     * @param 履歴番号 履歴番号
     * @return {@link KogakuJuryoininKeiyakuJigyoshaBuilder}
     */
    public KogakuJuryoininKeiyakuJigyoshaBuilder set履歴番号(int 履歴番号) {
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));
        entity.setRirekiNo(履歴番号);
        return this;
    }

    /**
     * 申請年月日を設定します。
     *
     * @param 申請年月日 申請年月日
     * @return {@link KogakuJuryoininKeiyakuJigyoshaBuilder}
     */
    public KogakuJuryoininKeiyakuJigyoshaBuilder set申請年月日(FlexibleDate 申請年月日) {
        requireNonNull(申請年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("申請年月日"));
        entity.setShinseiYMD(申請年月日);
        return this;
    }

    /**
     * 事業者番号を設定します。
     *
     * @param 事業者番号 事業者番号
     * @return {@link KogakuJuryoininKeiyakuJigyoshaBuilder}
     */
    public KogakuJuryoininKeiyakuJigyoshaBuilder set事業者番号(JigyoshaNo 事業者番号) {
        requireNonNull(事業者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("事業者番号"));
        entity.setJigyoshaNo(事業者番号);
        return this;
    }

    /**
     * 決定年月日を設定します。
     *
     * @param 決定年月日 決定年月日
     * @return {@link KogakuJuryoininKeiyakuJigyoshaBuilder}
     */
    public KogakuJuryoininKeiyakuJigyoshaBuilder set決定年月日(FlexibleDate 決定年月日) {
        requireNonNull(決定年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("決定年月日"));
        entity.setKetteiYMD(決定年月日);
        return this;
    }

    /**
     * 承認結果区分を設定します。
     *
     * @param 承認結果区分 承認結果区分
     * @return {@link KogakuJuryoininKeiyakuJigyoshaBuilder}
     */
    public KogakuJuryoininKeiyakuJigyoshaBuilder set承認結果区分(RString 承認結果区分) {
        requireNonNull(承認結果区分, UrSystemErrorMessages.値がnull.getReplacedMessage("承認結果区分"));
        entity.setShoninKekkaKubun(承認結果区分);
        return this;
    }

    /**
     * 受領委任払適用開始年月日を設定します。
     *
     * @param 受領委任払適用開始年月日 受領委任払適用開始年月日
     * @return {@link KogakuJuryoininKeiyakuJigyoshaBuilder}
     */
    public KogakuJuryoininKeiyakuJigyoshaBuilder set受領委任払適用開始年月日(FlexibleDate 受領委任払適用開始年月日) {
        requireNonNull(受領委任払適用開始年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("受領委任払適用開始年月日"));
        entity.setJuryoininKaishiYMD(受領委任払適用開始年月日);
        return this;
    }

    /**
     * 受領委任払適用終了年月日を設定します。
     *
     * @param 受領委任払適用終了年月日 受領委任払適用終了年月日
     * @return {@link KogakuJuryoininKeiyakuJigyoshaBuilder}
     */
    public KogakuJuryoininKeiyakuJigyoshaBuilder set受領委任払適用終了年月日(FlexibleDate 受領委任払適用終了年月日) {
        requireNonNull(受領委任払適用終了年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("受領委任払適用終了年月日"));
        entity.setJuryoininShuryoYMD(受領委任払適用終了年月日);
        return this;
    }

    /**
     * 契約番号を設定します。
     *
     * @param 契約番号 契約番号
     * @return {@link KogakuJuryoininKeiyakuJigyoshaBuilder}
     */
    public KogakuJuryoininKeiyakuJigyoshaBuilder set契約番号(RString 契約番号) {
        requireNonNull(契約番号, UrSystemErrorMessages.値がnull.getReplacedMessage("契約番号"));
        entity.setKeiyakuNo(契約番号);
        return this;
    }

    /**
     * 不承認理由を設定します。
     *
     * @param 不承認理由 不承認理由
     * @return {@link KogakuJuryoininKeiyakuJigyoshaBuilder}
     */
    public KogakuJuryoininKeiyakuJigyoshaBuilder set不承認理由(RString 不承認理由) {
        requireNonNull(不承認理由, UrSystemErrorMessages.値がnull.getReplacedMessage("不承認理由"));
        entity.setFuShoninRiyu(不承認理由);
        return this;
    }

    /**
     * 利用者負担上限額を設定します。
     *
     * @param 利用者負担上限額 利用者負担上限額
     * @return {@link KogakuJuryoininKeiyakuJigyoshaBuilder}
     */
    public KogakuJuryoininKeiyakuJigyoshaBuilder set利用者負担上限額(Decimal 利用者負担上限額) {
        entity.setRiyoshaFutanJogenGaku(利用者負担上限額);
        return this;
    }

    /**
     * 承認結果通知書作成日を設定します。
     *
     * @param 承認結果通知書作成日 承認結果通知書作成日
     * @return {@link KogakuJuryoininKeiyakuJigyoshaBuilder}
     */
    public KogakuJuryoininKeiyakuJigyoshaBuilder set承認結果通知書作成日(FlexibleDate 承認結果通知書作成日) {
        requireNonNull(承認結果通知書作成日, UrSystemErrorMessages.値がnull.getReplacedMessage("承認結果通知書作成日"));
        entity.setShoninKekkaTsuchiSakuseiYMD(承認結果通知書作成日);
        return this;
    }

    /**
     * 承認結果通知書再発行区分を設定します。
     *
     * @param 承認結果通知書再発行区分 承認結果通知書再発行区分
     * @return {@link KogakuJuryoininKeiyakuJigyoshaBuilder}
     */
    public KogakuJuryoininKeiyakuJigyoshaBuilder set承認結果通知書再発行区分(RString 承認結果通知書再発行区分) {
        requireNonNull(承認結果通知書再発行区分, UrSystemErrorMessages.値がnull.getReplacedMessage("承認結果通知書再発行区分"));
        entity.setShoninKekkaTsuchiSaiHakkoKubun(承認結果通知書再発行区分);
        return this;
    }

    /**
     * {@link KogakuJuryoininKeiyakuJigyosha}のインスタンスを生成します。
     *
     * @return {@link KogakuJuryoininKeiyakuJigyosha}のインスタンス
     */
    public KogakuJuryoininKeiyakuJigyosha build() {
        return new KogakuJuryoininKeiyakuJigyosha(entity, id);
    }
}
