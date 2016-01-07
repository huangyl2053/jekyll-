/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5912ShujiiJohoEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * {@link ShujiiJoho}の編集を行うビルダークラスです。
 */
public class ShujiiJohoBuilder {

    private final DbT5912ShujiiJohoEntity entity;
    private final ShujiiJohoIdentifier id;

    /**
     * {@link DbT5912ShujiiJohoEntity}より{@link ShujiiJoho}の編集用Builderクラスを生成します。
     *
     * @param entity {@link DbT5912ShujiiJohoEntity}
     * @param id {@link ShujiiJohoIdentifier}
     *
     */
    ShujiiJohoBuilder(
            DbT5912ShujiiJohoEntity entity,
            ShujiiJohoIdentifier id
    ) {
        this.entity = entity.clone();
        this.id = id;

    }

    /**
     * 主治医氏名を設定します。
     *
     * @param 主治医氏名 主治医氏名
     * @return {@link ShujiiJohoBuilder}
     */
    public ShujiiJohoBuilder set主治医氏名(AtenaMeisho 主治医氏名) {
        requireNonNull(主治医氏名, UrSystemErrorMessages.値がnull.getReplacedMessage("主治医氏名"));
        entity.setShujiiName(主治医氏名);
        return this;
    }

    /**
     * 主治医カナを設定します。
     *
     * @param 主治医カナ 主治医カナ
     * @return {@link ShujiiJohoBuilder}
     */
    public ShujiiJohoBuilder set主治医カナ(AtenaKanaMeisho 主治医カナ) {
        requireNonNull(主治医カナ, UrSystemErrorMessages.値がnull.getReplacedMessage("主治医カナ"));
        entity.setShujiiKana(主治医カナ);
        return this;
    }

    /**
     * 郵便番号を設定します。
     *
     * @param 郵便番号 郵便番号
     * @return {@link ShujiiJohoBuilder}
     */
    public ShujiiJohoBuilder set郵便番号(YubinNo 郵便番号) {
        requireNonNull(郵便番号, UrSystemErrorMessages.値がnull.getReplacedMessage("郵便番号"));
        entity.setYubinNo(郵便番号);
        return this;
    }

    /**
     * 住所を設定します。
     *
     * @param 住所 住所
     * @return {@link ShujiiJohoBuilder}
     */
    public ShujiiJohoBuilder set住所(AtenaJusho 住所) {
        requireNonNull(住所, UrSystemErrorMessages.値がnull.getReplacedMessage("住所"));
        entity.setJusho(住所);
        return this;
    }

    /**
     * 電話番号を設定します。
     *
     * @param 電話番号 電話番号
     * @return {@link ShujiiJohoBuilder}
     */
    public ShujiiJohoBuilder set電話番号(TelNo 電話番号) {
        requireNonNull(電話番号, UrSystemErrorMessages.値がnull.getReplacedMessage("電話番号"));
        entity.setTelNo(電話番号);
        return this;
    }

    /**
     * FAX番号を設定します。
     *
     * @param fax番号 fax番号
     * @return {@link ShujiiJohoBuilder}
     */
    public ShujiiJohoBuilder setFax番号(TelNo fax番号) {
        requireNonNull(fax番号, UrSystemErrorMessages.値がnull.getReplacedMessage("FAX番号"));
        entity.setFaxNo(fax番号);
        return this;
    }

    /**
     * 診療科名称を設定します。
     *
     * @param 診療科名称 診療科名称
     * @return {@link ShujiiJohoBuilder}
     */
    public ShujiiJohoBuilder set診療科名称(RString 診療科名称) {
        requireNonNull(診療科名称, UrSystemErrorMessages.値がnull.getReplacedMessage("診療科名称"));
        entity.setShinryokaName(診療科名称);
        return this;
    }

    /**
     * 指定医フラグを設定します。
     *
     * @param 指定医フラグ 指定医フラグ
     * @return {@link ShujiiJohoBuilder}
     */
    public ShujiiJohoBuilder set指定医フラグ(boolean 指定医フラグ) {
        requireNonNull(指定医フラグ, UrSystemErrorMessages.値がnull.getReplacedMessage("指定医フラグ"));
        entity.setShiteiiFlag(指定医フラグ);
        return this;
    }

    /**
     * 状況フラグを設定します。
     *
     * @param 状況フラグ 状況フラグ
     * @return {@link ShujiiJohoBuilder}
     */
    public ShujiiJohoBuilder set状況フラグ(boolean 状況フラグ) {
        requireNonNull(状況フラグ, UrSystemErrorMessages.値がnull.getReplacedMessage("状況フラグ"));
        entity.setJokyoFlag(状況フラグ);
        return this;
    }

    /**
     * {@link ShujiiJoho}のインスタンスを生成します。
     *
     * @return {@link ShujiiJoho}のインスタンス
     */
    public ShujiiJoho build() {
        return new ShujiiJoho(entity, id);
    }
}
