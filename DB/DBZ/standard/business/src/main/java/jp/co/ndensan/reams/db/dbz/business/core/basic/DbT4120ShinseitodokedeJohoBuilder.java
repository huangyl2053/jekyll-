/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4120ShinseitodokedeJohoEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * {@link DbT4120ShinseitodokedeJoho}の編集を行うビルダークラスです。
 */
public class DbT4120ShinseitodokedeJohoBuilder {

    private final DbT4120ShinseitodokedeJohoEntity entity;
    private final DbT4120ShinseitodokedeJohoIdentifier id;

    /**
     * {@link DbT4120ShinseitodokedeJohoEntity}より{@link DbT4120ShinseitodokedeJoho}の編集用Builderクラスを生成します。
     *
     * @param entity {@link DbT4120ShinseitodokedeJohoEntity}
     * @param id {@link DbT4120ShinseitodokedeJohoIdentifier}
     *
     */
    DbT4120ShinseitodokedeJohoBuilder(
            DbT4120ShinseitodokedeJohoEntity entity,
            DbT4120ShinseitodokedeJohoIdentifier id
    ) {
        this.entity = entity.clone();
        this.id = id;

    }

    /**
     * 申請届出代行区分コードを設定します。
     *
     * @param 申請届出代行区分コード 申請届出代行区分コード
     * @return {@link DbT4120ShinseitodokedeJohoBuilder}
     */
    public DbT4120ShinseitodokedeJohoBuilder set申請届出代行区分コード(Code 申請届出代行区分コード) {
        requireNonNull(申請届出代行区分コード, UrSystemErrorMessages.値がnull.getReplacedMessage("申請届出代行区分コード"));
        entity.setShinseiTodokedeDaikoKubunCode(申請届出代行区分コード);
        return this;
    }

    /**
     * 申請届出者氏名を設定します。
     *
     * @param 申請届出者氏名 申請届出者氏名
     * @return {@link DbT4120ShinseitodokedeJohoBuilder}
     */
    public DbT4120ShinseitodokedeJohoBuilder set申請届出者氏名(RString 申請届出者氏名) {
        requireNonNull(申請届出者氏名, UrSystemErrorMessages.値がnull.getReplacedMessage("申請届出者氏名"));
        entity.setShinseiTodokedeshaShimei(申請届出者氏名);
        return this;
    }

    /**
     * 申請届出者氏名カナを設定します。
     *
     * @param 申請届出者氏名カナ 申請届出者氏名カナ
     * @return {@link DbT4120ShinseitodokedeJohoBuilder}
     */
    public DbT4120ShinseitodokedeJohoBuilder set申請届出者氏名カナ(RString 申請届出者氏名カナ) {
        requireNonNull(申請届出者氏名カナ, UrSystemErrorMessages.値がnull.getReplacedMessage("申請届出者氏名カナ"));
        entity.setShinseiTodokedeshaKanaShimei(申請届出者氏名カナ);
        return this;
    }

    /**
     * 申請届出者続柄を設定します。
     *
     * @param 申請届出者続柄 申請届出者続柄
     * @return {@link DbT4120ShinseitodokedeJohoBuilder}
     */
    public DbT4120ShinseitodokedeJohoBuilder set申請届出者続柄(RString 申請届出者続柄) {
        requireNonNull(申請届出者続柄, UrSystemErrorMessages.値がnull.getReplacedMessage("申請届出者続柄"));
        entity.setShinseiTodokedeshaTsuzukigara(申請届出者続柄);
        return this;
    }

    /**
     * 申請届出代行事業者番号を設定します。
     *
     * @param 申請届出代行事業者番号 申請届出代行事業者番号
     * @return {@link DbT4120ShinseitodokedeJohoBuilder}
     */
    public DbT4120ShinseitodokedeJohoBuilder set申請届出代行事業者番号(JigyoshaNo 申請届出代行事業者番号) {
        requireNonNull(申請届出代行事業者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("申請届出代行事業者番号"));
        entity.setShinseiTodokedeDaikoJigyoshaNo(申請届出代行事業者番号);
        return this;
    }

    /**
     * 事業者区分を設定します。
     *
     * @param 事業者区分 事業者区分
     * @return {@link DbT4120ShinseitodokedeJohoBuilder}
     */
    public DbT4120ShinseitodokedeJohoBuilder set事業者区分(RString 事業者区分) {
        requireNonNull(事業者区分, UrSystemErrorMessages.値がnull.getReplacedMessage("事業者区分"));
        entity.setJigyoshaKubun(事業者区分);
        return this;
    }

    /**
     * 申請届出者郵便番号を設定します。
     *
     * @param 申請届出者郵便番号 申請届出者郵便番号
     * @return {@link DbT4120ShinseitodokedeJohoBuilder}
     */
    public DbT4120ShinseitodokedeJohoBuilder set申請届出者郵便番号(YubinNo 申請届出者郵便番号) {
        requireNonNull(申請届出者郵便番号, UrSystemErrorMessages.値がnull.getReplacedMessage("申請届出者郵便番号"));
        entity.setShinseiTodokedeshaYubinNo(申請届出者郵便番号);
        return this;
    }

    /**
     * 申請届出者住所を設定します。
     *
     * @param 申請届出者住所 申請届出者住所
     * @return {@link DbT4120ShinseitodokedeJohoBuilder}
     */
    public DbT4120ShinseitodokedeJohoBuilder set申請届出者住所(RString 申請届出者住所) {
        requireNonNull(申請届出者住所, UrSystemErrorMessages.値がnull.getReplacedMessage("申請届出者住所"));
        entity.setShinseiTodokedeshaJusho(申請届出者住所);
        return this;
    }

    /**
     * 申請届出者電話番号を設定します。
     *
     * @param 申請届出者電話番号 申請届出者電話番号
     * @return {@link DbT4120ShinseitodokedeJohoBuilder}
     */
    public DbT4120ShinseitodokedeJohoBuilder set申請届出者電話番号(TelNo 申請届出者電話番号) {
        requireNonNull(申請届出者電話番号, UrSystemErrorMessages.値がnull.getReplacedMessage("申請届出者電話番号"));
        entity.setShinseiTodokedeshaTelNo(申請届出者電話番号);
        return this;
    }

    /**
     * {@link DbT4120ShinseitodokedeJoho}のインスタンスを生成します。
     *
     * @return {@link DbT4120ShinseitodokedeJoho}のインスタンス
     */
    public DbT4120ShinseitodokedeJoho build() {
        return new DbT4120ShinseitodokedeJoho(entity, id);
    }
}
