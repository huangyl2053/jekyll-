/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7123KokuhoShikakuInfoEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 国保資格詳細情報
 *
 * @reamsid_L DBD-5730-010 tianyh
 */
public class KokuhoShikakuInfoBuilder {

    private final DbT7123KokuhoShikakuInfoEntity entity;
    private final KokuhoShikakuInfoIdentifier id;

    /**
     * {@link DbT7123KokuhoShikakuInfoEntity}より{@link KokuhoShikakuInfoIdentifier}の編集用Builderクラスを生成します。
     *
     * @param entity {@link DbT7123KokuhoShikakuInfoEntity}
     * @param id {@link KokuhoShikakuInfoIdentifier}
     *
     */
    KokuhoShikakuInfoBuilder(
            DbT7123KokuhoShikakuInfoEntity entity,
            KokuhoShikakuInfoIdentifier id
    ) {
        this.entity = entity.clone();
        this.id = id;

    }
    //TODO Key項目のsetterメソッドは削除してください。
//TODO 一緒に置換される値のまとまりで不変なクラスを作成し、その単位でsetterを作る様に見直してください。
    /**
     * 履歴番号を設定します。
     *
     * @param 履歴番号 履歴番号
     * @return {@link KokuhoShikakuInfoBuilder}
     */
    public KokuhoShikakuInfoBuilder set履歴番号(RString 履歴番号) {
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));
        entity.setRirekiNo(履歴番号);
        return this;
    }

    /**
     * 識別コードを設定します。
     *
     * @param 識別コード 識別コード
     * @return {@link KokuhoShikakuInfoBuilder}
     */
    public KokuhoShikakuInfoBuilder set識別コード(ShikibetsuCode 識別コード) {
        requireNonNull(識別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("識別コード"));
        entity.setShikibetsuCode(識別コード);
        return this;
    }

    /**
     * 国保番号を設定します。
     *
     * @param 国保番号 国保番号
     * @return {@link KokuhoShikakuInfoBuilder}
     */
    public KokuhoShikakuInfoBuilder set国保番号(RString 国保番号) {
        requireNonNull(国保番号, UrSystemErrorMessages.値がnull.getReplacedMessage("国保番号"));
        entity.setKokuhoNo(国保番号);
        return this;
    }

    /**
     * 国保保険者番号を設定します。
     *
     * @param 国保保険者番号 国保保険者番号
     * @return {@link KokuhoShikakuInfoBuilder}
     */
    public KokuhoShikakuInfoBuilder set国保保険者番号(RString 国保保険者番号) {
        entity.setKokuhoHokenshaNo(国保保険者番号);
        return this;
    }

    /**
     * 国保保険者番号を設定します。
     *
     * @param 国保保険証番号 国保保険証番号
     * @return {@link KokuhoShikakuInfoBuilder}
     */
    public KokuhoShikakuInfoBuilder set国保保険証番号(RString 国保保険証番号) {
        entity.setKokuhoHokenshoNo(国保保険証番号);
        return this;
    }

    /**
     * 国保個人番号を設定します。
     *
     * @param 国保個人番号 国保個人番号
     * @return {@link KokuhoShikakuInfoBuilder}
     */
    public KokuhoShikakuInfoBuilder set国保個人番号(RString 国保個人番号) {
        entity.setKokuhoKojinNo(国保個人番号);
        return this;
    }

    /**
     * 資格取得日を設定します。
     *
     * @param 資格取得日 資格取得日
     * @return {@link KokuhoShikakuInfoBuilder}
     */
    public KokuhoShikakuInfoBuilder set資格取得日(RString 資格取得日) {
        entity.setShikakuShutokuYMD(資格取得日);
        return this;
    }

    /**
     * 資格喪失日を設定します。
     *
     * @param 資格喪失日 資格喪失日
     * @return {@link KokuhoShikakuInfoBuilder}
     */
    public KokuhoShikakuInfoBuilder set資格喪失日(RString 資格喪失日) {
        entity.setShikakuSoshitsuYMD(資格喪失日);
        return this;
    }

    /**
     * 退職該当日を設定します。
     *
     * @param 退職該当日 退職該当日
     * @return {@link KokuhoShikakuInfoBuilder}
     */
    public KokuhoShikakuInfoBuilder set退職該当日(RString 退職該当日) {
        entity.setTaishokuGaitoYMD(退職該当日);
        return this;
    }

    /**
     * 退職非該当日を設定します。
     *
     * @param 退職非該当日 退職非該当日
     * @return {@link KokuhoShikakuInfoBuilder}
     */
    public KokuhoShikakuInfoBuilder set退職非該当日(RString 退職非該当日) {
        entity.setTaishokuHigaitoYMD(退職非該当日);
        return this;
    }

    /**
     * 退職非該当日を設定します。
     *
     * @param 個人区分コード 個人区分コード
     * @return {@link KokuhoShikakuInfoBuilder}
     */
    public KokuhoShikakuInfoBuilder set個人区分コード(RString 個人区分コード) {
        entity.setKojinKubunCode(個人区分コード);
        return this;
    }

    /**
     * 登録区分を設定します。
     *
     * @param 登録区分 登録区分
     * @return {@link KokuhoShikakuInfoBuilder}
     */
    public KokuhoShikakuInfoBuilder set登録区分(RString 登録区分) {
        entity.setTorokuKubun(登録区分);
        return this;
    }

    /**
     * {@link KokuhoShikakuInfo}のインスタンスを生成します。
     *
     * @return {@link KokuhoShikakuInfo}のインスタンス
     */
    public KokuhoShikakuInfo build() {
        return new KokuhoShikakuInfo(entity, id);
    }
}
