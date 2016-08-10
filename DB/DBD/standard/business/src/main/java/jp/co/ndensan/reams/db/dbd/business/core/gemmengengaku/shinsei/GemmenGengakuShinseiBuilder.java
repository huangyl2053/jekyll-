/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.core.gemmengengaku.shinsei;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT4010GemmenGengakuShinseiEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * {@link GemmenGengakuShinsei}の編集を行うビルダークラスです。
 *
 * @reamsid_L DBD-9999-011 sunhaidi
 */
public class GemmenGengakuShinseiBuilder {

    private final DbT4010GemmenGengakuShinseiEntity entity;
    private final GemmenGengakuShinseiIdentifier id;

    /**
     * {@link DbT4010GemmenGengakuShinseiEntity}より{@link GemmenGengakuShinsei}の編集用Builderクラスを生成します。
     *
     * @param entity {@link DbT4010GemmenGengakuShinseiEntity}
     * @param id {@link GemmenGengakuShinseiIdentifier}
     *
     */
    GemmenGengakuShinseiBuilder(
            DbT4010GemmenGengakuShinseiEntity entity,
            GemmenGengakuShinseiIdentifier id
    ) {
        this.entity = entity.clone();
        this.id = id;

    }

    /**
     * EntityDataStateを設定します
     *
     * @param state EntityDataState
     * @return {@link GemmenGengakuShinseiBuilder}
     */
    public GemmenGengakuShinseiBuilder setState(EntityDataState state) {
        requireNonNull(state, UrSystemErrorMessages.値がnull.getReplacedMessage("EntityDataState"));
        entity.setState(state);
        return this;
    }

    /**
     * 履歴番号を設定します。
     *
     * @param 履歴番号 履歴番号
     * @return {@link GemmenGengakuShinseiBuilder}
     */
    public GemmenGengakuShinseiBuilder set履歴番号(int 履歴番号) {
        entity.setShinseiRirekiNo(履歴番号);
        return this;
    }

    /**
     * 申請届出代行区分を設定します。
     *
     * @param 申請届出代行区分 申請届出代行区分
     * @return {@link GemmenGengakuShinseiBuilder}
     */
    public GemmenGengakuShinseiBuilder set申請届出代行区分(RString 申請届出代行区分) {
        requireNonNull(申請届出代行区分, UrSystemErrorMessages.値がnull.getReplacedMessage("申請届出代行区分"));
        entity.setShinseiTodokedeDaikoKubun(申請届出代行区分);
        return this;
    }

    /**
     * 申請届出者氏名を設定します。
     *
     * @param 申請届出者氏名 申請届出者氏名
     * @return {@link GemmenGengakuShinseiBuilder}
     */
    public GemmenGengakuShinseiBuilder set申請届出者氏名(AtenaMeisho 申請届出者氏名) {
        requireNonNull(申請届出者氏名, UrSystemErrorMessages.値がnull.getReplacedMessage("申請届出者氏名"));
        entity.setShinseiTodokedeshaShimei(申請届出者氏名);
        return this;
    }

    /**
     * 申請届出者氏名カナを設定します。
     *
     * @param 申請届出者氏名カナ 申請届出者氏名カナ
     * @return {@link GemmenGengakuShinseiBuilder}
     */
    public GemmenGengakuShinseiBuilder set申請届出者氏名カナ(AtenaKanaMeisho 申請届出者氏名カナ) {
        requireNonNull(申請届出者氏名カナ, UrSystemErrorMessages.値がnull.getReplacedMessage("申請届出者氏名カナ"));
        entity.setShinseiTodokedeshaKanaShimei(申請届出者氏名カナ);
        return this;
    }

    /**
     * 申請届出者続柄を設定します。
     *
     * @param 申請届出者続柄 申請届出者続柄
     * @return {@link GemmenGengakuShinseiBuilder}
     */
    public GemmenGengakuShinseiBuilder set申請届出者続柄(RString 申請届出者続柄) {
        requireNonNull(申請届出者続柄, UrSystemErrorMessages.値がnull.getReplacedMessage("申請届出者続柄"));
        entity.setShinseiTodokedeshaTsuzukigara(申請届出者続柄);
        return this;
    }

    /**
     * 申請届出代行事業者番号を設定します。
     *
     * @param 申請届出代行事業者番号 申請届出代行事業者番号
     * @return {@link GemmenGengakuShinseiBuilder}
     */
    public GemmenGengakuShinseiBuilder set申請届出代行事業者番号(JigyoshaNo 申請届出代行事業者番号) {
        requireNonNull(申請届出代行事業者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("申請届出代行事業者番号"));
        entity.setShinseiTodokedeDaikoJigyoshaNo(申請届出代行事業者番号);
        return this;
    }

    /**
     * 事業者区分を設定します。
     *
     * @param 事業者区分 事業者区分
     * @return {@link GemmenGengakuShinseiBuilder}
     */
    public GemmenGengakuShinseiBuilder set事業者区分(RString 事業者区分) {
        requireNonNull(事業者区分, UrSystemErrorMessages.値がnull.getReplacedMessage("事業者区分"));
        entity.setJigyoshaKubun(事業者区分);
        return this;
    }

    /**
     * 申請届出者郵便番号を設定します。
     *
     * @param 申請届出者郵便番号 申請届出者郵便番号
     * @return {@link GemmenGengakuShinseiBuilder}
     */
    public GemmenGengakuShinseiBuilder set申請届出者郵便番号(YubinNo 申請届出者郵便番号) {
        requireNonNull(申請届出者郵便番号, UrSystemErrorMessages.値がnull.getReplacedMessage("申請届出者郵便番号"));
        entity.setShinseiTodokedeshaYubinNo(申請届出者郵便番号);
        return this;
    }

    /**
     * 申請届出者住所を設定します。
     *
     * @param 申請届出者住所 申請届出者住所
     * @return {@link GemmenGengakuShinseiBuilder}
     */
    public GemmenGengakuShinseiBuilder set申請届出者住所(AtenaJusho 申請届出者住所) {
        requireNonNull(申請届出者住所, UrSystemErrorMessages.値がnull.getReplacedMessage("申請届出者住所"));
        entity.setShinseiTodokedeshaJusho(申請届出者住所);
        return this;
    }

    /**
     * 申請届出者電話番号を設定します。
     *
     * @param 申請届出者電話番号 申請届出者電話番号
     * @return {@link GemmenGengakuShinseiBuilder}
     */
    public GemmenGengakuShinseiBuilder set申請届出者電話番号(TelNo 申請届出者電話番号) {
        requireNonNull(申請届出者電話番号, UrSystemErrorMessages.値がnull.getReplacedMessage("申請届出者電話番号"));
        entity.setShinseiTodokedeshaTelNo(申請届出者電話番号);
        return this;
    }

    /**
     * {@link GemmenGengakuShinsei}のインスタンスを生成します。
     *
     * @return {@link GemmenGengakuShinsei}のインスタンス
     */
    public GemmenGengakuShinsei build() {
        return new GemmenGengakuShinsei(entity, id);
    }
}
