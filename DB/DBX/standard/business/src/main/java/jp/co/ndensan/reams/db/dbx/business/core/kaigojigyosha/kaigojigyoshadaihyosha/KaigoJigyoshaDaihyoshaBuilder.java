/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.business.core.kaigojigyosha.kaigojigyoshadaihyosha;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.kaigojigyosha.DbT7062KaigoJigyoshaDaihyoshaEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * {@link KaigoJigyoshaDaihyosha}の編集を行うビルダークラスです。
 */
public class KaigoJigyoshaDaihyoshaBuilder {

    private final DbT7062KaigoJigyoshaDaihyoshaEntity entity;
    private final KaigoJigyoshaDaihyoshaIdentifier id;

    /**
     * {@link DbT7062KaigoJigyoshaDaihyoshaEntity}より{@link KaigoJigyoshaDaihyosha}の編集用Builderクラスを生成します。
     *
     * @param entity {@link DbT7062KaigoJigyoshaDaihyoshaEntity}
     * @param id {@link KaigoJigyoshaDaihyoshaIdentifier}
     *
     */
    KaigoJigyoshaDaihyoshaBuilder(
            DbT7062KaigoJigyoshaDaihyoshaEntity entity,
            KaigoJigyoshaDaihyoshaIdentifier id
    ) {
        this.entity = entity.clone();
        this.id = id;

    }

    /**
     * 代表者名を設定します。
     *
     * @param 代表者名 代表者名
     * @return {@link KaigoJigyoshaDaihyoshaBuilder}
     */
    public KaigoJigyoshaDaihyoshaBuilder set代表者名(AtenaMeisho 代表者名) {
        requireNonNull(代表者名, UrSystemErrorMessages.値がnull.getReplacedMessage("代表者名"));
        entity.setDaihyoshaShimei(代表者名);
        return this;
    }

    /**
     * 代表者名カナを設定します。
     *
     * @param 代表者名カナ 代表者名カナ
     * @return {@link KaigoJigyoshaDaihyoshaBuilder}
     */
    public KaigoJigyoshaDaihyoshaBuilder set代表者名カナ(AtenaKanaMeisho 代表者名カナ) {
        requireNonNull(代表者名カナ, UrSystemErrorMessages.値がnull.getReplacedMessage("代表者名カナ"));
        entity.setDaihyoshaKanaShimei(代表者名カナ);
        return this;
    }

    /**
     * 代表者郵便番号を設定します。
     *
     * @param 代表者郵便番号 代表者郵便番号
     * @return {@link KaigoJigyoshaDaihyoshaBuilder}
     */
    public KaigoJigyoshaDaihyoshaBuilder set代表者郵便番号(YubinNo 代表者郵便番号) {
        requireNonNull(代表者郵便番号, UrSystemErrorMessages.値がnull.getReplacedMessage("代表者郵便番号"));
        entity.setDaihyoshaYubinNo(代表者郵便番号);
        return this;
    }

    /**
     * 代表者住所を設定します。
     *
     * @param 代表者住所 代表者住所
     * @return {@link KaigoJigyoshaDaihyoshaBuilder}
     */
    public KaigoJigyoshaDaihyoshaBuilder set代表者住所(AtenaJusho 代表者住所) {
        requireNonNull(代表者住所, UrSystemErrorMessages.値がnull.getReplacedMessage("代表者住所"));
        entity.setDaihyoshaJusho(代表者住所);
        return this;
    }

    /**
     * 代表者住所カナを設定します。
     *
     * @param 代表者住所カナ 代表者住所カナ
     * @return {@link KaigoJigyoshaDaihyoshaBuilder}
     */
    public KaigoJigyoshaDaihyoshaBuilder set代表者住所カナ(RString 代表者住所カナ) {
        requireNonNull(代表者住所カナ, UrSystemErrorMessages.値がnull.getReplacedMessage("代表者住所カナ"));
        entity.setDaihyoshaKanaJusho(代表者住所カナ);
        return this;
    }

    /**
     * 代表者役職名を設定します。
     *
     * @param 代表者役職名 代表者役職名
     * @return {@link KaigoJigyoshaDaihyoshaBuilder}
     */
    public KaigoJigyoshaDaihyoshaBuilder set代表者役職名(RString 代表者役職名) {
        requireNonNull(代表者役職名, UrSystemErrorMessages.値がnull.getReplacedMessage("代表者役職名"));
        entity.setDaihyoshaYakushokuMei(代表者役職名);
        return this;
    }

    /**
     * 開設者名称を設定します。
     *
     * @param 開設者名称 開設者名称
     * @return {@link KaigoJigyoshaDaihyoshaBuilder}
     */
    public KaigoJigyoshaDaihyoshaBuilder set開設者名称(AtenaMeisho 開設者名称) {
        requireNonNull(開設者名称, UrSystemErrorMessages.値がnull.getReplacedMessage("開設者名称"));
        entity.setKaisetsushaShimei(開設者名称);
        return this;
    }

    /**
     * 開設者名称カナを設定します。
     *
     * @param 開設者名称カナ 開設者名称カナ
     * @return {@link KaigoJigyoshaDaihyoshaBuilder}
     */
    public KaigoJigyoshaDaihyoshaBuilder set開設者名称カナ(AtenaKanaMeisho 開設者名称カナ) {
        requireNonNull(開設者名称カナ, UrSystemErrorMessages.値がnull.getReplacedMessage("開設者名称カナ"));
        entity.setKaisetsushaKanaShimei(開設者名称カナ);
        return this;
    }

    /**
     * 開設者郵便番号を設定します。
     *
     * @param 開設者郵便番号 開設者郵便番号
     * @return {@link KaigoJigyoshaDaihyoshaBuilder}
     */
    public KaigoJigyoshaDaihyoshaBuilder set開設者郵便番号(YubinNo 開設者郵便番号) {
        requireNonNull(開設者郵便番号, UrSystemErrorMessages.値がnull.getReplacedMessage("開設者郵便番号"));
        entity.setKaisetsushaYubinNo(開設者郵便番号);
        return this;
    }

    /**
     * 開設者住所を設定します。
     *
     * @param 開設者住所 開設者住所
     * @return {@link KaigoJigyoshaDaihyoshaBuilder}
     */
    public KaigoJigyoshaDaihyoshaBuilder set開設者住所(AtenaJusho 開設者住所) {
        requireNonNull(開設者住所, UrSystemErrorMessages.値がnull.getReplacedMessage("開設者住所"));
        entity.setKaisetsushaJusho(開設者住所);
        return this;
    }

    /**
     * 開設者住所カナを設定します。
     *
     * @param 開設者住所カナ 開設者住所カナ
     * @return {@link KaigoJigyoshaDaihyoshaBuilder}
     */
    public KaigoJigyoshaDaihyoshaBuilder set開設者住所カナ(RString 開設者住所カナ) {
        requireNonNull(開設者住所カナ, UrSystemErrorMessages.値がnull.getReplacedMessage("開設者住所カナ"));
        entity.setKaisetsushaKanaJusho(開設者住所カナ);
        return this;
    }

    /**
     * 開設者電話番号を設定します。
     *
     * @param 開設者電話番号 開設者電話番号
     * @return {@link KaigoJigyoshaDaihyoshaBuilder}
     */
    public KaigoJigyoshaDaihyoshaBuilder set開設者電話番号(TelNo 開設者電話番号) {
        requireNonNull(開設者電話番号, UrSystemErrorMessages.値がnull.getReplacedMessage("開設者電話番号"));
        entity.setKaisetsushaTelNo(開設者電話番号);
        return this;
    }

    /**
     * 開設者ＦＡＸ番号を設定します。
     *
     * @param 開設者ＦＡＸ番号 開設者ＦＡＸ番号
     * @return {@link KaigoJigyoshaDaihyoshaBuilder}
     */
    public KaigoJigyoshaDaihyoshaBuilder set開設者ＦＡＸ番号(TelNo 開設者ＦＡＸ番号) {
        requireNonNull(開設者ＦＡＸ番号, UrSystemErrorMessages.値がnull.getReplacedMessage("開設者ＦＡＸ番号"));
        entity.setKaisetsushaFaxNo(開設者ＦＡＸ番号);
        return this;
    }

    /**
     * {@link KaigoJigyoshaDaihyosha}のインスタンスを生成します。
     *
     * @return {@link KaigoJigyoshaDaihyosha}のインスタンス
     */
    public KaigoJigyoshaDaihyosha build() {
        return new KaigoJigyoshaDaihyosha(entity, id);
    }
}
