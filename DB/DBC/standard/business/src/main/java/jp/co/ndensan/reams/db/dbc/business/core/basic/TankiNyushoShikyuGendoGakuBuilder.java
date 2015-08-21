/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.entity.basic.DbT7110TankiNyushoShikyuGendoGakuEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * {@link TankiNyushoShikyuGendoGaku}の編集を行うビルダークラスです。
 */
public class TankiNyushoShikyuGendoGakuBuilder {

    private final DbT7110TankiNyushoShikyuGendoGakuEntity entity;
    private final TankiNyushoShikyuGendoGakuIdentifier id;

    /**
     * {@link DbT7110TankiNyushoShikyuGendoGakuEntity}より{@link TankiNyushoShikyuGendoGaku}の編集用Builderクラスを生成します。
     *
     * @param entity {@link DbT7110TankiNyushoShikyuGendoGakuEntity}
     * @param id {@link TankiNyushoShikyuGendoGakuIdentifier}
     *
     */
    TankiNyushoShikyuGendoGakuBuilder(
            DbT7110TankiNyushoShikyuGendoGakuEntity entity,
            TankiNyushoShikyuGendoGakuIdentifier id
    ) {
        this.entity = entity.clone();
        this.id = id;

    }

//TODO Key項目のsetterメソッドは削除してください。
//TODO 一緒に置換される値のまとまりで不変なクラスを作成し、その単位でsetterを作る様に見直してください。
    /**
     * 要介護状態区分を設定します。
     *
     * @param 要介護状態区分 要介護状態区分
     * @return {@link TankiNyushoShikyuGendoGakuBuilder}
     */
    public TankiNyushoShikyuGendoGakuBuilder set要介護状態区分(RString 要介護状態区分) {
        requireNonNull(要介護状態区分, UrSystemErrorMessages.値がnull.getReplacedMessage("要介護状態区分"));
        entity.setYoKaigoJotaiKubun(要介護状態区分);
        return this;
    }

    /**
     * 適用開始年月を設定します。
     *
     * @param 適用開始年月 適用開始年月
     * @return {@link TankiNyushoShikyuGendoGakuBuilder}
     */
    public TankiNyushoShikyuGendoGakuBuilder set適用開始年月(FlexibleYearMonth 適用開始年月) {
        requireNonNull(適用開始年月, UrSystemErrorMessages.値がnull.getReplacedMessage("適用開始年月"));
        entity.setTekiyoKaishiYM(適用開始年月);
        return this;
    }

    /**
     * 履歴番号を設定します。
     *
     * @param 履歴番号 履歴番号
     * @return {@link TankiNyushoShikyuGendoGakuBuilder}
     */
    public TankiNyushoShikyuGendoGakuBuilder set履歴番号(int 履歴番号) {
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));
        entity.setRirekiNo(履歴番号);
        return this;
    }

    /**
     * 適用終了年月を設定します。
     *
     * @param 適用終了年月 適用終了年月
     * @return {@link TankiNyushoShikyuGendoGakuBuilder}
     */
    public TankiNyushoShikyuGendoGakuBuilder set適用終了年月(FlexibleYearMonth 適用終了年月) {
        requireNonNull(適用終了年月, UrSystemErrorMessages.値がnull.getReplacedMessage("適用終了年月"));
        entity.setTekiyoShuryoYM(適用終了年月);
        return this;
    }

    /**
     * 支給限度単位数を設定します。
     *
     * @param 支給限度単位数 支給限度単位数
     * @return {@link TankiNyushoShikyuGendoGakuBuilder}
     */
    public TankiNyushoShikyuGendoGakuBuilder set支給限度単位数(Decimal 支給限度単位数) {
        requireNonNull(支給限度単位数, UrSystemErrorMessages.値がnull.getReplacedMessage("支給限度単位数"));
        entity.setShikyuGendoNissu(支給限度単位数);
        return this;
    }

    /**
     * {@link TankiNyushoShikyuGendoGaku}のインスタンスを生成します。
     *
     * @return {@link TankiNyushoShikyuGendoGaku}のインスタンス
     */
    public TankiNyushoShikyuGendoGaku build() {
        return new TankiNyushoShikyuGendoGaku(entity, id);
    }
}
