/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3094JutakuKaishuRiyushoTesuryoKetteiEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * {@link JutakuKaishuRiyushoTesuryoKettei}の編集を行うビルダークラスです。
 */
public class JutakuKaishuRiyushoTesuryoKetteiBuilder {

    private final DbT3094JutakuKaishuRiyushoTesuryoKetteiEntity entity;
    private final JutakuKaishuRiyushoTesuryoKetteiIdentifier id;

    /**
     * {@link DbT3094JutakuKaishuRiyushoTesuryoKetteiEntity}より{@link JutakuKaishuRiyushoTesuryoKettei}の編集用Builderクラスを生成します。
     *
     * @param entity {@link DbT3094JutakuKaishuRiyushoTesuryoKetteiEntity}
     * @param id {@link JutakuKaishuRiyushoTesuryoKetteiIdentifier}
     *
     */
    JutakuKaishuRiyushoTesuryoKetteiBuilder(
            DbT3094JutakuKaishuRiyushoTesuryoKetteiEntity entity,
            JutakuKaishuRiyushoTesuryoKetteiIdentifier id
    ) {
        this.entity = entity.clone();
        this.id = id;

    }

//TODO Key項目のsetterメソッドは削除してください。
//TODO 一緒に置換される値のまとまりで不変なクラスを作成し、その単位でsetterを作る様に見直してください。
    /**
     * 介護住宅改修理由書作成事業者番号を設定します。
     *
     * @param 介護住宅改修理由書作成事業者番号 介護住宅改修理由書作成事業者番号
     * @return {@link JutakuKaishuRiyushoTesuryoKetteiBuilder}
     */
    public JutakuKaishuRiyushoTesuryoKetteiBuilder set介護住宅改修理由書作成事業者番号(JigyoshaNo 介護住宅改修理由書作成事業者番号) {
        requireNonNull(介護住宅改修理由書作成事業者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("介護住宅改修理由書作成事業者番号"));
        entity.setRiyushoSakuseiJigyoshaNo(介護住宅改修理由書作成事業者番号);
        return this;
    }

    /**
     * 決定年月日を設定します。
     *
     * @param 決定年月日 決定年月日
     * @return {@link JutakuKaishuRiyushoTesuryoKetteiBuilder}
     */
    public JutakuKaishuRiyushoTesuryoKetteiBuilder set決定年月日(FlexibleDate 決定年月日) {
        requireNonNull(決定年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("決定年月日"));
        entity.setKetteiYMD(決定年月日);
        return this;
    }

    /**
     * 履歴番号を設定します。
     *
     * @param 履歴番号 履歴番号
     * @return {@link JutakuKaishuRiyushoTesuryoKetteiBuilder}
     */
    public JutakuKaishuRiyushoTesuryoKetteiBuilder set履歴番号(Decimal 履歴番号) {
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));
        entity.setRirekiNo(履歴番号.intValue());
        return this;
    }

    /**
     * 支給_不支給決定年月日を設定します。
     *
     * @param 支給_不支給決定年月日 支給_不支給決定年月日
     * @return {@link JutakuKaishuRiyushoTesuryoKetteiBuilder}
     */
    public JutakuKaishuRiyushoTesuryoKetteiBuilder set支給_不支給決定年月日(FlexibleDate 支給_不支給決定年月日) {
        requireNonNull(支給_不支給決定年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("支給_不支給決定年月日"));
        entity.setShikyu_FushikyuKetteiYMD(支給_不支給決定年月日);
        return this;
    }

    /**
     * 支給_不支給区分を設定します。
     *
     * @param 支給_不支給区分 支給_不支給区分
     * @return {@link JutakuKaishuRiyushoTesuryoKetteiBuilder}
     */
    public JutakuKaishuRiyushoTesuryoKetteiBuilder set支給_不支給区分(RString 支給_不支給区分) {
        requireNonNull(支給_不支給区分, UrSystemErrorMessages.値がnull.getReplacedMessage("支給_不支給区分"));
        entity.setShikyu_FushikyuKubun(支給_不支給区分);
        return this;
    }

    /**
     * 償還不支給理由等を設定します。
     *
     * @param 償還不支給理由等 償還不支給理由等
     * @return {@link JutakuKaishuRiyushoTesuryoKetteiBuilder}
     */
    public JutakuKaishuRiyushoTesuryoKetteiBuilder set償還不支給理由等(RString 償還不支給理由等) {
        requireNonNull(償還不支給理由等, UrSystemErrorMessages.値がnull.getReplacedMessage("償還不支給理由等"));
        entity.setFushikyuRiyu(償還不支給理由等);
        return this;
    }

    /**
     * 住宅改修理由書作成手数料支払予定日を設定します。
     *
     * @param 住宅改修理由書作成手数料支払予定日 住宅改修理由書作成手数料支払予定日
     * @return {@link JutakuKaishuRiyushoTesuryoKetteiBuilder}
     */
    public JutakuKaishuRiyushoTesuryoKetteiBuilder set住宅改修理由書作成手数料支払予定日(FlexibleDate 住宅改修理由書作成手数料支払予定日) {
        requireNonNull(住宅改修理由書作成手数料支払予定日, UrSystemErrorMessages.値がnull.getReplacedMessage("住宅改修理由書作成手数料支払予定日"));
        entity.setTesuryoShiharaiYoteiYMD(住宅改修理由書作成手数料支払予定日);
        return this;
    }

    /**
     * {@link JutakuKaishuRiyushoTesuryoKettei}のインスタンスを生成します。
     *
     * @return {@link JutakuKaishuRiyushoTesuryoKettei}のインスタンス
     */
    public JutakuKaishuRiyushoTesuryoKettei build() {
        return new JutakuKaishuRiyushoTesuryoKettei(entity, id);
    }
}
