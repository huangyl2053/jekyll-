/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.core.basic.tokuchomidoteijoho;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.DbT2019TokuchoMidoteiJohoEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * {@link TokuchoMidoteiJoho}の編集を行うビルダークラスです。
 *
 * @reamsid_L DBB-9999-012 zhangrui
 */
public class TokuchoMidoteiJohoBuilder {

    private final DbT2019TokuchoMidoteiJohoEntity entity;
    private final TokuchoMidoteiJohoIdentifier id;

    /**
     * {@link DbT2019TokuchoMidoteiJohoEntity}より{@link TokuchoMidoteiJoho}の編集用Builderクラスを生成します。
     *
     * @param entity {@link DbT2019TokuchoMidoteiJohoEntity}
     * @param id {@link TokuchoMidoteiJohoIdentifier}
     *
     */
    TokuchoMidoteiJohoBuilder(
            DbT2019TokuchoMidoteiJohoEntity entity,
            TokuchoMidoteiJohoIdentifier id
    ) {
        this.entity = entity.clone();
        this.id = id;

    }

//TODO Key項目のsetterメソッドは削除してください。
//TODO 一緒に置換される値のまとまりで不変なクラスを作成し、その単位でsetterを作る様に見直してください。
    /**
     * 処理年度を設定します。
     *
     * @param 処理年度 処理年度
     * @return {@link TokuchoMidoteiJohoBuilder}
     */
    public TokuchoMidoteiJohoBuilder set処理年度(FlexibleYear 処理年度) {
        requireNonNull(処理年度, UrSystemErrorMessages.値がnull.getReplacedMessage("処理年度"));
        entity.setShoriNendo(処理年度);
        return this;
    }

    /**
     * 基礎年金番号を設定します。
     *
     * @param 基礎年金番号 基礎年金番号
     * @return {@link TokuchoMidoteiJohoBuilder}
     */
    public TokuchoMidoteiJohoBuilder set基礎年金番号(RString 基礎年金番号) {
        requireNonNull(基礎年金番号, UrSystemErrorMessages.値がnull.getReplacedMessage("基礎年金番号"));
        entity.setKisoNenkinNo(基礎年金番号);
        return this;
    }

    /**
     * 年金コードを設定します。
     *
     * @param 年金コード 年金コード
     * @return {@link TokuchoMidoteiJohoBuilder}
     */
    public TokuchoMidoteiJohoBuilder set年金コード(RString 年金コード) {
        requireNonNull(年金コード, UrSystemErrorMessages.値がnull.getReplacedMessage("年金コード"));
        entity.setNenkinCode(年金コード);
        return this;
    }

    /**
     * 捕捉月を設定します。
     *
     * @param 捕捉月 捕捉月
     * @return {@link TokuchoMidoteiJohoBuilder}
     */
    public TokuchoMidoteiJohoBuilder set捕捉月(RString 捕捉月) {
        requireNonNull(捕捉月, UrSystemErrorMessages.値がnull.getReplacedMessage("捕捉月"));
        entity.setHosokuM(捕捉月);
        return this;
    }

    /**
     * 識別コードを設定します。
     *
     * @param 識別コード 識別コード
     * @return {@link TokuchoMidoteiJohoBuilder}
     */
    public TokuchoMidoteiJohoBuilder set識別コード(ShikibetsuCode 識別コード) {
        requireNonNull(識別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("識別コード"));
        entity.setShikibetsuCode(識別コード);
        return this;
    }

    /**
     * 開始月を設定します。
     *
     * @param 開始月 開始月
     * @return {@link TokuchoMidoteiJohoBuilder}
     */
    public TokuchoMidoteiJohoBuilder set開始月(RString 開始月) {
        requireNonNull(開始月, UrSystemErrorMessages.値がnull.getReplacedMessage("開始月"));
        entity.setKaishiM(開始月);
        return this;
    }

    /**
     * 不一致理由コードを設定します。
     *
     * @param 不一致理由コード 不一致理由コード
     * @return {@link TokuchoMidoteiJohoBuilder}
     */
    public TokuchoMidoteiJohoBuilder set不一致理由コード(RString 不一致理由コード) {
        requireNonNull(不一致理由コード, UrSystemErrorMessages.値がnull.getReplacedMessage("不一致理由コード"));
        entity.setFuichiRiyuCode(不一致理由コード);
        return this;
    }

    /**
     * 確認状況区分を設定します。
     *
     * @param 確認状況区分 確認状況区分
     * @return {@link TokuchoMidoteiJohoBuilder}
     */
    public TokuchoMidoteiJohoBuilder set確認状況区分(RString 確認状況区分) {
        requireNonNull(確認状況区分, UrSystemErrorMessages.値がnull.getReplacedMessage("確認状況区分"));
        entity.setKakuninJokyoKbn(確認状況区分);
        return this;
    }

    /**
     * {@link TokuchoMidoteiJoho}のインスタンスを生成します。
     *
     * @return {@link TokuchoMidoteiJoho}のインスタンス
     */
    public TokuchoMidoteiJoho build() {
        return new TokuchoMidoteiJoho(entity, id);
    }
}
