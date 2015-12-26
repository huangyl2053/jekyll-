/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.ninteishinseijoho.shinseitodokedejoho;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5120ShinseitodokedeJohoEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * {@link ShinseitodokedeJoho}の編集を行うビルダークラスです。
 */
public class ShinseitodokedeJohoBuilder {

    private final DbT5120ShinseitodokedeJohoEntity entity;
    private final ShinseitodokedeJohoIdentifier id;

    /**
     * {@link DbT5120ShinseitodokedeJohoEntity}より{@link ShinseitodokedeJoho}の編集用Builderクラスを生成します。
     *
     * @param entity {@link DbT5120ShinseitodokedeJohoEntity}
     * @param id {@link ShinseitodokedeJohoIdentifier}
     *
     */
    ShinseitodokedeJohoBuilder(
            DbT5120ShinseitodokedeJohoEntity entity,
            ShinseitodokedeJohoIdentifier id
    ) {
        this.entity = entity.clone();
        this.id = id;

    }

    /**
     * 申請届出代行区分コードを設定します。
     *
     * @param 申請届出代行区分コード 申請届出代行区分コード
     * @return {@link ShinseitodokedeJohoBuilder}
     */
    public ShinseitodokedeJohoBuilder set申請届出代行区分コード(Code 申請届出代行区分コード) {
        requireNonNull(申請届出代行区分コード, UrSystemErrorMessages.値がnull.getReplacedMessage("申請届出代行区分コード"));
        entity.setShinseiTodokedeDaikoKubunCode(申請届出代行区分コード);
        return this;
    }

    /**
     * 申請届出者氏名を設定します。
     *
     * @param 申請届出者氏名 申請届出者氏名
     * @return {@link ShinseitodokedeJohoBuilder}
     */
    public ShinseitodokedeJohoBuilder set申請届出者氏名(RString 申請届出者氏名) {
        requireNonNull(申請届出者氏名, UrSystemErrorMessages.値がnull.getReplacedMessage("申請届出者氏名"));
        entity.setShinseiTodokedeshaShimei(申請届出者氏名);
        return this;
    }

    /**
     * 申請届出者氏名カナを設定します。
     *
     * @param 申請届出者氏名カナ 申請届出者氏名カナ
     * @return {@link ShinseitodokedeJohoBuilder}
     */
    public ShinseitodokedeJohoBuilder set申請届出者氏名カナ(RString 申請届出者氏名カナ) {
        requireNonNull(申請届出者氏名カナ, UrSystemErrorMessages.値がnull.getReplacedMessage("申請届出者氏名カナ"));
        entity.setShinseiTodokedeshaKanaShimei(申請届出者氏名カナ);
        return this;
    }

    /**
     * 申請届出者続柄コードを設定します。
     *
     * @param 申請届出者続柄コード 申請届出者続柄コード
     * @return {@link ShinseitodokedeJohoBuilder}
     */
    public ShinseitodokedeJohoBuilder set申請届出者続柄コード(RString 申請届出者続柄コード) {
        requireNonNull(申請届出者続柄コード, UrSystemErrorMessages.値がnull.getReplacedMessage("申請届出者続柄コード"));
        entity.setShinseiTodokedeshaTsuzukigara(申請届出者続柄コード);
        return this;
    }

    /**
     * 申請届出代行事業者番号を設定します。
     *
     * @param 申請届出代行事業者番号 申請届出代行事業者番号
     * @return {@link ShinseitodokedeJohoBuilder}
     */
    public ShinseitodokedeJohoBuilder set申請届出代行事業者番号(JigyoshaNo 申請届出代行事業者番号) {
        requireNonNull(申請届出代行事業者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("申請届出代行事業者番号"));
        entity.setShinseiTodokedeDaikoJigyoshaNo(申請届出代行事業者番号);
        return this;
    }

    /**
     * 事業者区分を設定します。
     *
     * @param 事業者区分 事業者区分
     * @return {@link ShinseitodokedeJohoBuilder}
     */
    public ShinseitodokedeJohoBuilder set事業者区分(RString 事業者区分) {
        requireNonNull(事業者区分, UrSystemErrorMessages.値がnull.getReplacedMessage("事業者区分"));
        entity.setJigyoshaKubun(事業者区分);
        return this;
    }

    /**
     * 申請届出者郵便番号を設定します。
     *
     * @param 申請届出者郵便番号 申請届出者郵便番号
     * @return {@link ShinseitodokedeJohoBuilder}
     */
    public ShinseitodokedeJohoBuilder set申請届出者郵便番号(YubinNo 申請届出者郵便番号) {
        requireNonNull(申請届出者郵便番号, UrSystemErrorMessages.値がnull.getReplacedMessage("申請届出者郵便番号"));
        entity.setShinseiTodokedeshaYubinNo(申請届出者郵便番号);
        return this;
    }

    /**
     * 申請届出者住所を設定します。
     *
     * @param 申請届出者住所 申請届出者住所
     * @return {@link ShinseitodokedeJohoBuilder}
     */
    public ShinseitodokedeJohoBuilder set申請届出者住所(RString 申請届出者住所) {
        requireNonNull(申請届出者住所, UrSystemErrorMessages.値がnull.getReplacedMessage("申請届出者住所"));
        entity.setShinseiTodokedeshaJusho(申請届出者住所);
        return this;
    }

    /**
     * 申請届出者電話番号を設定します。
     *
     * @param 申請届出者電話番号 申請届出者電話番号
     * @return {@link ShinseitodokedeJohoBuilder}
     */
    public ShinseitodokedeJohoBuilder set申請届出者電話番号(TelNo 申請届出者電話番号) {
        requireNonNull(申請届出者電話番号, UrSystemErrorMessages.値がnull.getReplacedMessage("申請届出者電話番号"));
        entity.setShinseiTodokedeshaTelNo(申請届出者電話番号);
        return this;
    }

    /**
     * {@link ShinseitodokedeJoho}のインスタンスを生成します。
     *
     * @return {@link ShinseitodokedeJoho}のインスタンス
     */
    public ShinseitodokedeJoho build() {
        return new ShinseitodokedeJoho(entity, id);
    }
}
