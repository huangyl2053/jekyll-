/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.entity.basic.DbT7115UwanoseShokanShuruiShikyuGendoGakuEntity;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * {@link UwanoseShokanShuruiShikyuGendoGaku}の編集を行うビルダークラスです。
 */
public class UwanoseShokanShuruiShikyuGendoGakuBuilder {

    private final DbT7115UwanoseShokanShuruiShikyuGendoGakuEntity entity;
    private final UwanoseShokanShuruiShikyuGendoGakuIdentifier id;

    /**
     * {@link DbT7115UwanoseShokanShuruiShikyuGendoGakuEntity}より{@link UwanoseShokanShuruiShikyuGendoGaku}の編集用Builderクラスを生成します。
     *
     * @param entity {@link DbT7115UwanoseShokanShuruiShikyuGendoGakuEntity}
     * @param id {@link UwanoseShokanShuruiShikyuGendoGakuIdentifier}
     *
     */
    UwanoseShokanShuruiShikyuGendoGakuBuilder(
            DbT7115UwanoseShokanShuruiShikyuGendoGakuEntity entity,
            UwanoseShokanShuruiShikyuGendoGakuIdentifier id
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
     * @return {@link UwanoseShokanShuruiShikyuGendoGakuBuilder}
     */
    public UwanoseShokanShuruiShikyuGendoGakuBuilder setサービス種類コード(ServiceShuruiCode サービス種類コード) {
        requireNonNull(サービス種類コード, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス種類コード"));
        entity.setServiceShuruiCode(サービス種類コード);
        return this;
    }

    /**
     * 適用開始年月を設定します。
     *
     * @param 適用開始年月 適用開始年月
     * @return {@link UwanoseShokanShuruiShikyuGendoGakuBuilder}
     */
    public UwanoseShokanShuruiShikyuGendoGakuBuilder set適用開始年月(FlexibleYearMonth 適用開始年月) {
        requireNonNull(適用開始年月, UrSystemErrorMessages.値がnull.getReplacedMessage("適用開始年月"));
        entity.setTekiyoKaishiYM(適用開始年月);
        return this;
    }

    /**
     * 履歴番号を設定します。
     *
     * @param 履歴番号 履歴番号
     * @return {@link UwanoseShokanShuruiShikyuGendoGakuBuilder}
     */
    public UwanoseShokanShuruiShikyuGendoGakuBuilder set履歴番号(int 履歴番号) {
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));
        entity.setRirekiNo(履歴番号);
        return this;
    }

    /**
     * 適用終了年月を設定します。
     *
     * @param 適用終了年月 適用終了年月
     * @return {@link UwanoseShokanShuruiShikyuGendoGakuBuilder}
     */
    public UwanoseShokanShuruiShikyuGendoGakuBuilder set適用終了年月(FlexibleYearMonth 適用終了年月) {
        requireNonNull(適用終了年月, UrSystemErrorMessages.値がnull.getReplacedMessage("適用終了年月"));
        entity.setTekiyoShuryoYM(適用終了年月);
        return this;
    }

    /**
     * 支給限度単位数を設定します。
     *
     * @param 支給限度単位数 支給限度単位数
     * @return {@link UwanoseShokanShuruiShikyuGendoGakuBuilder}
     */
    public UwanoseShokanShuruiShikyuGendoGakuBuilder set支給限度単位数(Decimal 支給限度単位数) {
        requireNonNull(支給限度単位数, UrSystemErrorMessages.値がnull.getReplacedMessage("支給限度単位数"));
        entity.setShikyuGendoTaniSu(支給限度単位数);
        return this;
    }

    /**
     * {@link UwanoseShokanShuruiShikyuGendoGaku}のインスタンスを生成します。
     *
     * @return {@link UwanoseShokanShuruiShikyuGendoGaku}のインスタンス
     */
    public UwanoseShokanShuruiShikyuGendoGaku build() {
        return new UwanoseShokanShuruiShikyuGendoGaku(entity, id);
    }
}
