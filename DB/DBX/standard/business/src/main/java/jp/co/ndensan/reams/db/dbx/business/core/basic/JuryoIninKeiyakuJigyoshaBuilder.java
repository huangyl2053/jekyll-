/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.business.core.basic;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7061JuryoIninKeiyakuJigyoshaEntity;
import jp.co.ndensan.reams.ua.uax.definition.core.valueobject.ServiceShubetsuCode;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.KaigoJigyoshaNo;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * {@link JuryoIninKeiyakuJigyosha}の編集を行うビルダークラスです。
 */
public class JuryoIninKeiyakuJigyoshaBuilder {

    private final DbT7061JuryoIninKeiyakuJigyoshaEntity entity;
    private final JuryoIninKeiyakuJigyoshaIdentifier id;

    /**
     * {@link DbT7061JuryoIninKeiyakuJigyoshaEntity}より{@link JuryoIninKeiyakuJigyosha}の編集用Builderクラスを生成します。
     *
     * @param entity {@link DbT7061JuryoIninKeiyakuJigyoshaEntity}
     * @param id {@link JuryoIninKeiyakuJigyoshaIdentifier}
     *
     */
    JuryoIninKeiyakuJigyoshaBuilder(
            DbT7061JuryoIninKeiyakuJigyoshaEntity entity,
            JuryoIninKeiyakuJigyoshaIdentifier id
    ) {
        this.entity = entity.clone();
        this.id = id;

    }

//TODO Key項目のsetterメソッドは削除してください。
//TODO 一緒に置換される値のまとまりで不変なクラスを作成し、その単位でsetterを作る様に見直してください。
    /**
     * 受領委任契約事業者番号を設定します。
     *
     * @param 受領委任契約事業者番号 受領委任契約事業者番号
     * @return {@link JuryoIninKeiyakuJigyoshaBuilder}
     */
    public JuryoIninKeiyakuJigyoshaBuilder set受領委任契約事業者番号(KaigoJigyoshaNo 受領委任契約事業者番号) {
        requireNonNull(受領委任契約事業者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("受領委任契約事業者番号"));
        entity.setJigyoshaNo(受領委任契約事業者番号);
        return this;
    }

    /**
     * 受領委任契約開始日を設定します。
     *
     * @param 受領委任契約開始日 受領委任契約開始日
     * @return {@link JuryoIninKeiyakuJigyoshaBuilder}
     */
    public JuryoIninKeiyakuJigyoshaBuilder set受領委任契約開始日(FlexibleDate 受領委任契約開始日) {
        requireNonNull(受領委任契約開始日, UrSystemErrorMessages.値がnull.getReplacedMessage("受領委任契約開始日"));
        entity.setKeiyakuKaishiYMD(受領委任契約開始日);
        return this;
    }

    /**
     * 受領委任契約終了日を設定します。
     *
     * @param 受領委任契約終了日 受領委任契約終了日
     * @return {@link JuryoIninKeiyakuJigyoshaBuilder}
     */
    public JuryoIninKeiyakuJigyoshaBuilder set受領委任契約終了日(FlexibleDate 受領委任契約終了日) {
        requireNonNull(受領委任契約終了日, UrSystemErrorMessages.値がnull.getReplacedMessage("受領委任契約終了日"));
        entity.setKeiyakuShuryoYMD(受領委任契約終了日);
        return this;
    }

    /**
     * 契約サービス種別を設定します。
     *
     * @param 契約サービス種別 契約サービス種別
     * @return {@link JuryoIninKeiyakuJigyoshaBuilder}
     */
    public JuryoIninKeiyakuJigyoshaBuilder set契約サービス種別(RString 契約サービス種別) {
        requireNonNull(契約サービス種別, UrSystemErrorMessages.値がnull.getReplacedMessage("契約サービス種別"));
        entity.setServiceShubetsuCode(契約サービス種別);
        return this;
    }

    /**
     * 契約事業者郵便番号を設定します。
     *
     * @param 契約事業者郵便番号 契約事業者郵便番号
     * @return {@link JuryoIninKeiyakuJigyoshaBuilder}
     */
    public JuryoIninKeiyakuJigyoshaBuilder set契約事業者郵便番号(YubinNo 契約事業者郵便番号) {
        requireNonNull(契約事業者郵便番号, UrSystemErrorMessages.値がnull.getReplacedMessage("契約事業者郵便番号"));
        entity.setJigyoshaYubinNo(契約事業者郵便番号);
        return this;
    }

    /**
     * 契約事業者住所を設定します。
     *
     * @param 契約事業者住所 契約事業者住所
     * @return {@link JuryoIninKeiyakuJigyoshaBuilder}
     */
    public JuryoIninKeiyakuJigyoshaBuilder set契約事業者住所(AtenaJusho 契約事業者住所) {
        requireNonNull(契約事業者住所, UrSystemErrorMessages.値がnull.getReplacedMessage("契約事業者住所"));
        entity.setJigyoshaJusho(契約事業者住所);
        return this;
    }

    /**
     * 契約事業者電話番号を設定します。
     *
     * @param 契約事業者電話番号 契約事業者電話番号
     * @return {@link JuryoIninKeiyakuJigyoshaBuilder}
     */
    public JuryoIninKeiyakuJigyoshaBuilder set契約事業者電話番号(TelNo 契約事業者電話番号) {
        requireNonNull(契約事業者電話番号, UrSystemErrorMessages.値がnull.getReplacedMessage("契約事業者電話番号"));
        entity.setJigyoshaTelNo(契約事業者電話番号);
        return this;
    }

    /**
     * 契約事業者FAX番号を設定します。
     *
     * @param 契約事業者FAX番号 契約事業者FAX番号
     * @return {@link JuryoIninKeiyakuJigyoshaBuilder}
     */
    public JuryoIninKeiyakuJigyoshaBuilder set契約事業者FAX番号(TelNo 契約事業者FAX番号) {
        requireNonNull(契約事業者FAX番号, UrSystemErrorMessages.値がnull.getReplacedMessage("契約事業者FAX番号"));
        entity.setJigyoshaFaxNo(契約事業者FAX番号);
        return this;
    }

    /**
     * {@link JuryoIninKeiyakuJigyosha}のインスタンスを生成します。
     *
     * @return {@link JuryoIninKeiyakuJigyosha}のインスタンス
     */
    public JuryoIninKeiyakuJigyosha build() {
        return new JuryoIninKeiyakuJigyosha(entity, id);
    }
}
