/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.core.choshuyuyo.choteikyotsu;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.UrT0705ChoteiKyotsuEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RYear;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * {@link ChoteiKyotsu}の編集を行うビルダークラスです。
 *
 * @reamsid_L DBB-9999-013 huangh
 */
public class ChoteiKyotsuBuilder {

    private final UrT0705ChoteiKyotsuEntity entity;
    private final ChoteiKyotsuIdentifier id;

    /**
     * {@link UrT0705ChoteiKyotsuEntity}より{@link ChoteiKyotsu}の編集用Builderクラスを生成します。
     *
     * @param entity {@link UrT0705ChoteiKyotsuEntity}
     * @param id {@link ChoteiKyotsuIdentifier}
     *
     */
    ChoteiKyotsuBuilder(
            UrT0705ChoteiKyotsuEntity entity,
            ChoteiKyotsuIdentifier id
    ) {
        this.entity = entity.clone();
        this.id = id;

    }

    /**
     * 収納IDを設定します。
     *
     * @param 収納ID 収納ID
     * @return {@link ChoteiKyotsuBuilder}
     */
    public ChoteiKyotsuBuilder set収納ID(Long 収納ID) {
        requireNonNull(収納ID, UrSystemErrorMessages.値がnull.getReplacedMessage("収納ID"));
        entity.setShunoId(収納ID);
        return this;
    }

    /**
     * 会計年度を設定します。
     *
     * @param 会計年度 会計年度
     * @return {@link ChoteiKyotsuBuilder}
     */
    public ChoteiKyotsuBuilder set会計年度(RYear 会計年度) {
        requireNonNull(会計年度, UrSystemErrorMessages.値がnull.getReplacedMessage("会計年度"));
        entity.setKaikeiNendo(会計年度);
        return this;
    }

    /**
     * 処理年度を設定します。
     *
     * @param 処理年度 処理年度
     * @return {@link ChoteiKyotsuBuilder}
     */
    public ChoteiKyotsuBuilder set処理年度(RYear 処理年度) {
        requireNonNull(処理年度, UrSystemErrorMessages.値がnull.getReplacedMessage("処理年度"));
        entity.setShoriNendo(処理年度);
        return this;
    }

    /**
     * 処理番号を設定します。
     *
     * @param 処理番号 処理番号
     * @return {@link ChoteiKyotsuBuilder}
     */
    public ChoteiKyotsuBuilder set処理番号(int 処理番号) {
        requireNonNull(処理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("処理番号"));
        entity.setShoriNo(処理番号);
        return this;
    }

    /**
     * 更正回数を設定します。
     *
     * @param 更正回数 更正回数
     * @return {@link ChoteiKyotsuBuilder}
     */
    public ChoteiKyotsuBuilder set更正回数(int 更正回数) {
        requireNonNull(更正回数, UrSystemErrorMessages.値がnull.getReplacedMessage("更正回数"));
        entity.setKoseiKaisu(更正回数);
        return this;
    }

    /**
     * 調定事由コードを設定します。
     *
     * @param 調定事由コード 調定事由コード
     * @return {@link ChoteiKyotsuBuilder}
     */
    public ChoteiKyotsuBuilder set調定事由コード(RString 調定事由コード) {
        requireNonNull(調定事由コード, UrSystemErrorMessages.値がnull.getReplacedMessage("調定事由コード"));
        entity.setChoteiJiyuCode(調定事由コード);
        return this;
    }

    /**
     * 調定年月日を設定します。
     *
     * @param 調定年月日 調定年月日
     * @return {@link ChoteiKyotsuBuilder}
     */
    public ChoteiKyotsuBuilder set調定年月日(RDate 調定年月日) {
        requireNonNull(調定年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("調定年月日"));
        entity.setChoteiYMD(調定年月日);
        return this;
    }

    /**
     * 調定額を設定します。
     *
     * @param 調定額 調定額
     * @return {@link ChoteiKyotsuBuilder}
     */
    public ChoteiKyotsuBuilder set調定額(Decimal 調定額) {
        requireNonNull(調定額, UrSystemErrorMessages.値がnull.getReplacedMessage("調定額"));
        entity.setChoteigaku(調定額);
        return this;
    }

    /**
     * 消費税額を設定します。
     *
     * @param 消費税額 消費税額
     * @return {@link ChoteiKyotsuBuilder}
     */
    public ChoteiKyotsuBuilder set消費税額(Decimal 消費税額) {
        requireNonNull(消費税額, UrSystemErrorMessages.値がnull.getReplacedMessage("消費税額"));
        entity.setShohizei(消費税額);
        return this;
    }

    /**
     * 納期限を設定します。
     *
     * @param 納期限 納期限
     * @return {@link ChoteiKyotsuBuilder}
     */
    public ChoteiKyotsuBuilder set納期限(RDate 納期限) {
        requireNonNull(納期限, UrSystemErrorMessages.値がnull.getReplacedMessage("納期限"));
        entity.setNokigenYMD(納期限);
        return this;
    }

    /**
     * 法定納期限等を設定します。
     *
     * @param 法定納期限等 法定納期限等
     * @return {@link ChoteiKyotsuBuilder}
     */
    public ChoteiKyotsuBuilder set法定納期限等(RDate 法定納期限等) {
        requireNonNull(法定納期限等, UrSystemErrorMessages.値がnull.getReplacedMessage("法定納期限等"));
        entity.setHoteiNokigenToYMD(法定納期限等);
        return this;
    }

    /**
     * 賦課処理状況を設定します。
     *
     * @param 賦課処理状況 賦課処理状況
     * @return {@link ChoteiKyotsuBuilder}
     */
    public ChoteiKyotsuBuilder set賦課処理状況(boolean 賦課処理状況) {
        requireNonNull(賦課処理状況, UrSystemErrorMessages.値がnull.getReplacedMessage("賦課処理状況"));
        entity.setFukaShoriJokyo(賦課処理状況);
        return this;
    }

    /**
     * {@link ChoteiKyotsu}のインスタンスを生成します。
     *
     * @return {@link ChoteiKyotsu}のインスタンス
     */
    public ChoteiKyotsu build() {
        return new ChoteiKyotsu(entity, id);
    }
}
