/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3077JuryoininKeiyakuJigyoshaEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.KinyuKikanCode;
import jp.co.ndensan.reams.uz.uza.biz.KinyuKikanShitenCode;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * {@link JuryoininKeiyakuJigyosha}の編集を行うビルダークラスです。
 */
public class JuryoininKeiyakuJigyoshaBuilder {

    private final DbT3077JuryoininKeiyakuJigyoshaEntity entity;
    private final JuryoininKeiyakuJigyoshaIdentifier id;

    /**
     * {@link DbT3077JuryoininKeiyakuJigyoshaEntity}より{@link JuryoininKeiyakuJigyosha}の編集用Builderクラスを生成します。
     *
     * @param entity {@link DbT3077JuryoininKeiyakuJigyoshaEntity}
     * @param id {@link JuryoininKeiyakuJigyoshaIdentifier}
     *
     */
    JuryoininKeiyakuJigyoshaBuilder(
            DbT3077JuryoininKeiyakuJigyoshaEntity entity,
            JuryoininKeiyakuJigyoshaIdentifier id
    ) {
        this.entity = entity.clone();
        this.id = id;

    }

//TODO Key項目のsetterメソッドは削除してください。
//TODO 一緒に置換される値のまとまりで不変なクラスを作成し、その単位でsetterを作る様に見直してください。
    /**
     * 契約事業者番号を設定します。
     *
     * @param 契約事業者番号 契約事業者番号
     * @return {@link JuryoininKeiyakuJigyoshaBuilder}
     */
    public JuryoininKeiyakuJigyoshaBuilder set契約事業者番号(RString 契約事業者番号) {
        requireNonNull(契約事業者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("契約事業者番号"));
        entity.setKeiyakuJigyoshaNo(契約事業者番号);
        return this;
    }

    /**
     * 開始年月日を設定します。
     *
     * @param 開始年月日 開始年月日
     * @return {@link JuryoininKeiyakuJigyoshaBuilder}
     */
    public JuryoininKeiyakuJigyoshaBuilder set開始年月日(FlexibleDate 開始年月日) {
        requireNonNull(開始年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("開始年月日"));
        entity.setKaishiYMD(開始年月日);
        return this;
    }

    /**
     * 終了年月日を設定します。
     *
     * @param 終了年月日 終了年月日
     * @return {@link JuryoininKeiyakuJigyoshaBuilder}
     */
    public JuryoininKeiyakuJigyoshaBuilder set終了年月日(FlexibleDate 終了年月日) {
        requireNonNull(終了年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("終了年月日"));
        entity.setShuryoYMD(終了年月日);
        return this;
    }

    /**
     * 契約種類を設定します。
     *
     * @param 契約種類 契約種類
     * @return {@link JuryoininKeiyakuJigyoshaBuilder}
     */
    public JuryoininKeiyakuJigyoshaBuilder set契約種類(RString 契約種類) {
        requireNonNull(契約種類, UrSystemErrorMessages.値がnull.getReplacedMessage("契約種類"));
        entity.setKeiyakuShurui(契約種類);
        return this;
    }

    /**
     * 契約事業者名称を設定します。
     *
     * @param 契約事業者名称 契約事業者名称
     * @return {@link JuryoininKeiyakuJigyoshaBuilder}
     */
    public JuryoininKeiyakuJigyoshaBuilder set契約事業者名称(AtenaMeisho 契約事業者名称) {
        requireNonNull(契約事業者名称, UrSystemErrorMessages.値がnull.getReplacedMessage("契約事業者名称"));
        entity.setKeiyakuJigyoshaName(契約事業者名称);
        return this;
    }

    /**
     * 契約事業者カナ名称を設定します。
     *
     * @param 契約事業者カナ名称 契約事業者カナ名称
     * @return {@link JuryoininKeiyakuJigyoshaBuilder}
     */
    public JuryoininKeiyakuJigyoshaBuilder set契約事業者カナ名称(AtenaKanaMeisho 契約事業者カナ名称) {
        requireNonNull(契約事業者カナ名称, UrSystemErrorMessages.値がnull.getReplacedMessage("契約事業者カナ名称"));
        entity.setKeiyakuJigyoshaKanaName(契約事業者カナ名称);
        return this;
    }

    /**
     * 契約事業者郵便番号を設定します。
     *
     * @param 契約事業者郵便番号 契約事業者郵便番号
     * @return {@link JuryoininKeiyakuJigyoshaBuilder}
     */
    public JuryoininKeiyakuJigyoshaBuilder set届出者代表者氏名(YubinNo 契約事業者郵便番号) {
        requireNonNull(契約事業者郵便番号, UrSystemErrorMessages.値がnull.getReplacedMessage("契約事業者郵便番号"));
        entity.setKeiyakuJigyoshaYubinNo(契約事業者郵便番号);
        return this;
    }

    /**
     * 契約事業者住所を設定します。
     *
     * @param 契約事業者住所 契約事業者住所
     * @return {@link JuryoininKeiyakuJigyoshaBuilder}
     */
    public JuryoininKeiyakuJigyoshaBuilder set契約事業者住所(AtenaJusho 契約事業者住所) {
        requireNonNull(契約事業者住所, UrSystemErrorMessages.値がnull.getReplacedMessage("契約事業者住所"));
        entity.setKeiyakuJigyoshaJusho(契約事業者住所);
        return this;
    }

    /**
     * 契約代表者氏名を設定します。
     *
     * @param 契約代表者氏名 契約代表者氏名
     * @return {@link JuryoininKeiyakuJigyoshaBuilder}
     */
    public JuryoininKeiyakuJigyoshaBuilder set契約代表者氏名(AtenaMeisho 契約代表者氏名) {
        requireNonNull(契約代表者氏名, UrSystemErrorMessages.値がnull.getReplacedMessage("契約代表者氏名"));
        entity.setKeiyakuDaihyoshaName(契約代表者氏名);
        return this;
    }

    /**
     * 契約事業者電話番号を設定します。
     *
     * @param 契約代表者氏名 契約代表者氏名
     * @return {@link JuryoininKeiyakuJigyoshaBuilder}
     */
    public JuryoininKeiyakuJigyoshaBuilder set契約代表者氏名(TelNo 契約代表者氏名) {
        requireNonNull(契約代表者氏名, UrSystemErrorMessages.値がnull.getReplacedMessage("契約代表者氏名"));
        entity.setKeiyakuJigyoshaTelNo(契約代表者氏名);
        return this;
    }

    /**
     * 契約事業者FAX番号を設定します。
     *
     * @param 契約事業者FAX番号 契約事業者FAX番号
     * @return {@link JuryoininKeiyakuJigyoshaBuilder}
     */
    public JuryoininKeiyakuJigyoshaBuilder set契約事業者FAX番号(TelNo 契約事業者FAX番号) {
        requireNonNull(契約事業者FAX番号, UrSystemErrorMessages.値がnull.getReplacedMessage("契約事業者FAX番号"));
        entity.setKeiyakuJigyoshaFaxNo(契約事業者FAX番号);
        return this;
    }

    /**
     * 送付先郵便番号を設定します。
     *
     * @param 送付先郵便番号 送付先郵便番号
     * @return {@link JuryoininKeiyakuJigyoshaBuilder}
     */
    public JuryoininKeiyakuJigyoshaBuilder set契約事業者FAX番号(YubinNo 送付先郵便番号) {
        requireNonNull(送付先郵便番号, UrSystemErrorMessages.値がnull.getReplacedMessage("送付先郵便番号"));
        entity.setSofusakiYubinNo(送付先郵便番号);
        return this;
    }

    /**
     * 送付先住所を設定します。
     *
     * @param 送付先住所 送付先住所
     * @return {@link JuryoininKeiyakuJigyoshaBuilder}
     */
    public JuryoininKeiyakuJigyoshaBuilder set送付先住所(AtenaJusho 送付先住所) {
        requireNonNull(送付先住所, UrSystemErrorMessages.値がnull.getReplacedMessage("送付先住所"));
        entity.setSofusakiJusho(送付先住所);
        return this;
    }

    /**
     * 送付先部署を設定します。
     *
     * @param 送付先部署 送付先部署
     * @return {@link JuryoininKeiyakuJigyoshaBuilder}
     */
    public JuryoininKeiyakuJigyoshaBuilder set送付先部署(RString 送付先部署) {
        requireNonNull(送付先部署, UrSystemErrorMessages.値がnull.getReplacedMessage("送付先部署"));
        entity.setSofusakiBusho(送付先部署);
        return this;
    }

    /**
     * 送付先事業者名称を設定します。
     *
     * @param 送付先事業者名称 送付先事業者名称
     * @return {@link JuryoininKeiyakuJigyoshaBuilder}
     */
    public JuryoininKeiyakuJigyoshaBuilder set送付先事業者名称(AtenaMeisho 送付先事業者名称) {
        requireNonNull(送付先事業者名称, UrSystemErrorMessages.値がnull.getReplacedMessage("送付先事業者名称"));
        entity.setSofusakiJigyoshaName(送付先事業者名称);
        return this;
    }

    /**
     * 送付先事業者カナ名称を設定します。
     *
     * @param 送付先事業者カナ名称 送付先事業者カナ名称
     * @return {@link JuryoininKeiyakuJigyoshaBuilder}
     */
    public JuryoininKeiyakuJigyoshaBuilder set送付先事業者カナ名称(AtenaKanaMeisho 送付先事業者カナ名称) {
        requireNonNull(送付先事業者カナ名称, UrSystemErrorMessages.値がnull.getReplacedMessage("送付先事業者カナ名称"));
        entity.setSofusakiJigyoshaKanaName(送付先事業者カナ名称);
        return this;
    }

    /**
     * 金融機関コードを設定します。
     *
     * @param 金融機関コード 金融機関コード
     * @return {@link JuryoininKeiyakuJigyoshaBuilder}
     */
    public JuryoininKeiyakuJigyoshaBuilder set金融機関コード(KinyuKikanCode 金融機関コード) {
        requireNonNull(金融機関コード, UrSystemErrorMessages.値がnull.getReplacedMessage("金融機関コード"));
        entity.setKinyuKikanCode(金融機関コード);
        return this;
    }

    /**
     * 支店コードを設定します。
     *
     * @param 支店コード 支店コード
     * @return {@link JuryoininKeiyakuJigyoshaBuilder}
     */
    public JuryoininKeiyakuJigyoshaBuilder set支店コード(KinyuKikanShitenCode 支店コード) {
        requireNonNull(支店コード, UrSystemErrorMessages.値がnull.getReplacedMessage("支店コード"));
        entity.setShitenCode(支店コード);
        return this;
    }

    /**
     * 口座種別を設定します。
     *
     * @param 口座種別 口座種別
     * @return {@link JuryoininKeiyakuJigyoshaBuilder}
     */
    public JuryoininKeiyakuJigyoshaBuilder set口座種別(RString 口座種別) {
        requireNonNull(口座種別, UrSystemErrorMessages.値がnull.getReplacedMessage("口座種別"));
        entity.setKozaShubetsu(口座種別);
        return this;
    }

    /**
     * 口座番号を設定します。
     *
     * @param 口座番号 口座番号
     * @return {@link JuryoininKeiyakuJigyoshaBuilder}
     */
    public JuryoininKeiyakuJigyoshaBuilder set口座番号(RString 口座番号) {
        requireNonNull(口座番号, UrSystemErrorMessages.値がnull.getReplacedMessage("口座番号"));
        entity.setKozaNo(口座番号);
        return this;
    }

    /**
     * 口座名義人を設定します。
     *
     * @param 口座名義人 口座名義人
     * @return {@link JuryoininKeiyakuJigyoshaBuilder}
     */
    public JuryoininKeiyakuJigyoshaBuilder set口座名義人(AtenaMeisho 口座名義人) {
        requireNonNull(口座名義人, UrSystemErrorMessages.値がnull.getReplacedMessage("口座名義人"));
        entity.setKozaMeiginin(口座名義人);
        return this;
    }

    /**
     * 口座名義人カナを設定します。
     *
     * @param 口座名義人カナ 口座名義人カナ
     * @return {@link JuryoininKeiyakuJigyoshaBuilder}
     */
    public JuryoininKeiyakuJigyoshaBuilder set口座名義人カナ(AtenaKanaMeisho 口座名義人カナ) {
        requireNonNull(口座名義人カナ, UrSystemErrorMessages.値がnull.getReplacedMessage("口座名義人カナ"));
        entity.setKozaMeigininKana(口座名義人カナ);
        return this;
    }

    /**
     * 契約事業者郵便番号を設定します。
     *
     * @param 契約事業者郵便番号 契約事業者郵便番号
     * @return {@link JuryoininKeiyakuJigyoshaBuilder}
     */
    public JuryoininKeiyakuJigyoshaBuilder set契約事業者郵便番号(YubinNo 契約事業者郵便番号) {
        requireNonNull(契約事業者郵便番号, UrSystemErrorMessages.値がnull.getReplacedMessage("契約事業者郵便番号"));
        entity.setKeiyakuJigyoshaYubinNo(契約事業者郵便番号);
        return this;
    }

    /**
     * 契約事業者電話番号を設定します。
     *
     * @param 契約事業者電話番号 契約事業者電話番号
     * @return {@link JuryoininKeiyakuJigyoshaBuilder}
     */
    public JuryoininKeiyakuJigyoshaBuilder set契約事業者電話番号(TelNo 契約事業者電話番号) {
        requireNonNull(契約事業者電話番号, UrSystemErrorMessages.値がnull.getReplacedMessage("契約事業者電話番号"));
        entity.setKeiyakuJigyoshaTelNo(契約事業者電話番号);
        return this;
    }

    /**
     * 送付先郵便番号を設定します。
     *
     * @param 送付先郵便番号 送付先郵便番号
     * @return {@link JuryoininKeiyakuJigyoshaBuilder}
     */
    public JuryoininKeiyakuJigyoshaBuilder set送付先郵便番号(YubinNo 送付先郵便番号) {
        requireNonNull(送付先郵便番号, UrSystemErrorMessages.値がnull.getReplacedMessage("送付先郵便番号"));
        entity.setSofusakiYubinNo(送付先郵便番号);
        return this;
    }

    /**
     * {@link JuryoininKeiyakuJigyosha}のインスタンスを生成します。
     *
     * @return {@link JuryoininKeiyakuJigyosha}のインスタンス
     */
    public JuryoininKeiyakuJigyosha build() {
        return new JuryoininKeiyakuJigyosha(entity, id);
    }
}
