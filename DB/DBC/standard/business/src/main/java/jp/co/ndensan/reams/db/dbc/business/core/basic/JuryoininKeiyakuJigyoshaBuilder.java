/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3077JuryoininKeiyakuJigyoshaEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.KinyuKikanCode;
import jp.co.ndensan.reams.uz.uza.biz.KinyuKikanShitenCode;
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
     * 事業者契約番号を設定します。
     *
     * @param 事業者契約番号 事業者契約番号
     * @return {@link JuryoininKeiyakuJigyoshaBuilder}
     */
    public JuryoininKeiyakuJigyoshaBuilder set事業者契約番号(RString 事業者契約番号) {
        requireNonNull(事業者契約番号, UrSystemErrorMessages.値がnull.getReplacedMessage("事業者契約番号"));
        entity.setKeiyakuJigyoshaNo(事業者契約番号);
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
    public JuryoininKeiyakuJigyoshaBuilder set口座名義人(AtenaKanaMeisho 口座名義人カナ) {
        requireNonNull(口座名義人カナ, UrSystemErrorMessages.値がnull.getReplacedMessage("口座名義人カナ"));
        entity.setKozaMeigininKana(口座名義人カナ);
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
     * {@link JuryoininKeiyakuJigyosha}のインスタンスを生成します。
     *
     * @return {@link JuryoininKeiyakuJigyosha}のインスタンス
     */
    public JuryoininKeiyakuJigyosha build() {
        return new JuryoininKeiyakuJigyosha(entity, id);
    }
}
