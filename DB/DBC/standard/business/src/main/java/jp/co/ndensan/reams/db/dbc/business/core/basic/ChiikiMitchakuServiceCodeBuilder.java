/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.entity.basic.DbT7121ChiikiMitchakuServiceCodeEntity;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.ServiceKomokuCode;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * {@link ChiikiMitchakuServiceCode}の編集を行うビルダークラスです。
 */
public class ChiikiMitchakuServiceCodeBuilder {

    private final DbT7121ChiikiMitchakuServiceCodeEntity entity;
    private final ChiikiMitchakuServiceCodeIdentifier id;

    /**
     * {@link DbT7121ChiikiMitchakuServiceCodeEntity}より{@link ChiikiMitchakuServiceCode}の編集用Builderクラスを生成します。
     *
     * @param entity {@link DbT7121ChiikiMitchakuServiceCodeEntity}
     * @param id {@link ChiikiMitchakuServiceCodeIdentifier}
     *
     */
    ChiikiMitchakuServiceCodeBuilder(
            DbT7121ChiikiMitchakuServiceCodeEntity entity,
            ChiikiMitchakuServiceCodeIdentifier id
    ) {
        this.entity = entity.clone();
        this.id = id;

    }

//TODO Key項目のsetterメソッドは削除してください。
//TODO 一緒に置換される値のまとまりで不変なクラスを作成し、その単位でsetterを作る様に見直してください。
    /**
     * サービス種類コードを設定します。
     *
     * @param サービス種類コード サービス種類コード
     * @return {@link ChiikiMitchakuServiceCodeBuilder}
     */
    public ChiikiMitchakuServiceCodeBuilder setサービス種類コード(ServiceShuruiCode サービス種類コード) {
        requireNonNull(サービス種類コード, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス種類コード"));
        entity.setServiceShuruiCode(サービス種類コード);
        return this;
    }

    /**
     * サービス項目コードを設定します。
     *
     * @param サービス項目コード サービス項目コード
     * @return {@link ChiikiMitchakuServiceCodeBuilder}
     */
    public ChiikiMitchakuServiceCodeBuilder setサービス項目コード(ServiceKomokuCode サービス項目コード) {
        requireNonNull(サービス項目コード, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス項目コード"));
        entity.setServiceKomokuCode(サービス項目コード);
        return this;
    }

    /**
     * 適用開始年月を設定します。
     *
     * @param 適用開始年月 適用開始年月
     * @return {@link ChiikiMitchakuServiceCodeBuilder}
     */
    public ChiikiMitchakuServiceCodeBuilder set適用開始年月(FlexibleYearMonth 適用開始年月) {
        requireNonNull(適用開始年月, UrSystemErrorMessages.値がnull.getReplacedMessage("適用開始年月"));
        entity.setTekiyoKaishiYM(適用開始年月);
        return this;
    }

    /**
     * 履歴番号を設定します。
     *
     * @param 履歴番号 履歴番号
     * @return {@link ChiikiMitchakuServiceCodeBuilder}
     */
    public ChiikiMitchakuServiceCodeBuilder set履歴番号(int 履歴番号) {
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));
        entity.setRirekiNo(履歴番号);
        return this;
    }

    /**
     * 適用終了年月を設定します。
     *
     * @param 適用終了年月 適用終了年月
     * @return {@link ChiikiMitchakuServiceCodeBuilder}
     */
    public ChiikiMitchakuServiceCodeBuilder set適用終了年月(FlexibleYearMonth 適用終了年月) {
        requireNonNull(適用終了年月, UrSystemErrorMessages.値がnull.getReplacedMessage("適用終了年月"));
        entity.setTekiyoShuryoYM(適用終了年月);
        return this;
    }

    /**
     * サービス名称を設定します。
     *
     * @param サービス名称 サービス名称
     * @return {@link ChiikiMitchakuServiceCodeBuilder}
     */
    public ChiikiMitchakuServiceCodeBuilder setサービス名称(RString サービス名称) {
        requireNonNull(サービス名称, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス名称"));
        entity.setServiceMeisho(サービス名称);
        return this;
    }

    /**
     * 単位数を設定します。
     *
     * @param 単位数 単位数
     * @return {@link ChiikiMitchakuServiceCodeBuilder}
     */
    public ChiikiMitchakuServiceCodeBuilder set単位数(Decimal 単位数) {
        requireNonNull(単位数, UrSystemErrorMessages.値がnull.getReplacedMessage("単位数"));
        entity.setTaniSu(単位数);
        return this;
    }

    /**
     * {@link ChiikiMitchakuServiceCode}のインスタンスを生成します。
     *
     * @return {@link ChiikiMitchakuServiceCode}のインスタンス
     */
    public ChiikiMitchakuServiceCode build() {
        return new ChiikiMitchakuServiceCode(entity, id);
    }
}
