/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3098TandokuJoseikinKyufuShinseiEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * {@link TandokuJoseikinKyufuShinsei}の編集を行うビルダークラスです。
 */
public class TandokuJoseikinKyufuShinseiBuilder {

    private final DbT3098TandokuJoseikinKyufuShinseiEntity entity;
    private final TandokuJoseikinKyufuShinseiIdentifier id;

    /**
     * {@link DbT3098TandokuJoseikinKyufuShinseiEntity}より{@link TandokuJoseikinKyufuShinsei}の編集用Builderクラスを生成します。
     *
     * @param entity {@link DbT3098TandokuJoseikinKyufuShinseiEntity}
     * @param id {@link TandokuJoseikinKyufuShinseiIdentifier}
     *
     */
    TandokuJoseikinKyufuShinseiBuilder(
            DbT3098TandokuJoseikinKyufuShinseiEntity entity,
            TandokuJoseikinKyufuShinseiIdentifier id
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
     * @return {@link TandokuJoseikinKyufuShinseiBuilder}
     */
    public TandokuJoseikinKyufuShinseiBuilder set被保険者番号(HihokenshaNo 被保険者番号) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        entity.setHihokenshaNo(被保険者番号);
        return this;
    }

    /**
     * 受付年月日を設定します。
     *
     * @param 受付年月日 受付年月日
     * @return {@link TandokuJoseikinKyufuShinseiBuilder}
     */
    public TandokuJoseikinKyufuShinseiBuilder set受付年月日(FlexibleDate 受付年月日) {
        requireNonNull(受付年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("受付年月日"));
        entity.setUketsukeYMD(受付年月日);
        return this;
    }

    /**
     * 履歴番号を設定します。
     *
     * @param 履歴番号 履歴番号
     * @return {@link TandokuJoseikinKyufuShinseiBuilder}
     */
    public TandokuJoseikinKyufuShinseiBuilder set履歴番号(Decimal 履歴番号) {
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));
        entity.setRirekiNo(履歴番号);
        return this;
    }

    /**
     * 申請年月日を設定します。
     *
     * @param 申請年月日 申請年月日
     * @return {@link TandokuJoseikinKyufuShinseiBuilder}
     */
    public TandokuJoseikinKyufuShinseiBuilder set申請年月日(FlexibleDate 申請年月日) {
        requireNonNull(申請年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("申請年月日"));
        entity.setShinseiYMD(申請年月日);
        return this;
    }

    /**
     * 申請者区分を設定します。
     *
     * @param 申請者区分 申請者区分
     * @return {@link TandokuJoseikinKyufuShinseiBuilder}
     */
    public TandokuJoseikinKyufuShinseiBuilder set申請者区分(RString 申請者区分) {
        requireNonNull(申請者区分, UrSystemErrorMessages.値がnull.getReplacedMessage("申請者区分"));
        entity.setShinseishaKubun(申請者区分);
        return this;
    }

    /**
     * 申請代行事業者番号を設定します。
     *
     * @param 申請代行事業者番号 申請代行事業者番号
     * @return {@link TandokuJoseikinKyufuShinseiBuilder}
     */
    public TandokuJoseikinKyufuShinseiBuilder set申請代行事業者番号(JigyoshaNo 申請代行事業者番号) {
        requireNonNull(申請代行事業者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("申請代行事業者番号"));
        entity.setDaikoJigyoshaNo(申請代行事業者番号);
        return this;
    }

    /**
     * 事業者区分を設定します。
     *
     * @param 事業者区分 事業者区分
     * @return {@link TandokuJoseikinKyufuShinseiBuilder}
     */
    public TandokuJoseikinKyufuShinseiBuilder set事業者区分(RString 事業者区分) {
        requireNonNull(事業者区分, UrSystemErrorMessages.値がnull.getReplacedMessage("事業者区分"));
        entity.setJigyoshaKubun(事業者区分);
        return this;
    }

    /**
     * 申請者郵便番号を設定します。
     *
     * @param 申請者郵便番号 申請者郵便番号
     * @return {@link TandokuJoseikinKyufuShinseiBuilder}
     */
    public TandokuJoseikinKyufuShinseiBuilder set申請者郵便番号(YubinNo 申請者郵便番号) {
        requireNonNull(申請者郵便番号, UrSystemErrorMessages.値がnull.getReplacedMessage("申請者郵便番号"));
        entity.setShinseishaYubinNo(申請者郵便番号);
        return this;
    }

    /**
     * 申請者住所を設定します。
     *
     * @param 申請者住所 申請者住所
     * @return {@link TandokuJoseikinKyufuShinseiBuilder}
     */
    public TandokuJoseikinKyufuShinseiBuilder set申請者住所(RString 申請者住所) {
        requireNonNull(申請者住所, UrSystemErrorMessages.値がnull.getReplacedMessage("申請者住所"));
        entity.setShinseishaJusho(申請者住所);
        return this;
    }

    /**
     * 申請者電話番号を設定します。
     *
     * @param 申請者電話番号 申請者電話番号
     * @return {@link TandokuJoseikinKyufuShinseiBuilder}
     */
    public TandokuJoseikinKyufuShinseiBuilder set申請者電話番号(TelNo 申請者電話番号) {
        requireNonNull(申請者電話番号, UrSystemErrorMessages.値がnull.getReplacedMessage("申請者電話番号"));
        entity.setShinseishaTelNo(申請者電話番号);
        return this;
    }

    /**
     * 申請理由を設定します。
     *
     * @param 申請理由 申請理由
     * @return {@link TandokuJoseikinKyufuShinseiBuilder}
     */
    public TandokuJoseikinKyufuShinseiBuilder set申請理由(RString 申請理由) {
        requireNonNull(申請理由, UrSystemErrorMessages.値がnull.getReplacedMessage("申請理由"));
        entity.setShinseiRiyu(申請理由);
        return this;
    }

    /**
     * 市町村単独助成種類を設定します。
     *
     * @param 市町村単独助成種類 市町村単独助成種類
     * @return {@link TandokuJoseikinKyufuShinseiBuilder}
     */
    public TandokuJoseikinKyufuShinseiBuilder set市町村単独助成種類(RString 市町村単独助成種類) {
        requireNonNull(市町村単独助成種類, UrSystemErrorMessages.値がnull.getReplacedMessage("市町村単独助成種類"));
        entity.setTandokuJoseiShuruiCode(市町村単独助成種類);
        return this;
    }

    /**
     * {@link TandokuJoseikinKyufuShinsei}のインスタンスを生成します。
     *
     * @return {@link TandokuJoseikinKyufuShinsei}のインスタンス
     */
    public TandokuJoseikinKyufuShinsei build() {
        return new TandokuJoseikinKyufuShinsei(entity, id);
    }

    public TandokuJoseikinKyufuShinseiBuilder setTandokuJoseikinKyufuKettei(TandokuJoseikinKyufuKettei createTandokuJoseikinKyufuKettei) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
