/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3118ShikibetsuNoKanriEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * {@link ShikibetsuNoKanri}の編集を行うビルダークラスです。
 *
 * @reamsid_L DBC-9999-012 xicongwang
 */
public class ShikibetsuNoKanriBuilder {

    private final DbT3118ShikibetsuNoKanriEntity entity;
    private final ShikibetsuNoKanriIdentifier id;

    /**
     * {@link DbT3118ShikibetsuNoKanriEntity}より{@link ShikibetsuNoKanri}の編集用Builderクラスを生成します。
     *
     * @param entity {@link DbT3118ShikibetsuNoKanriEntity}
     * @param id {@link ShikibetsuNoKanriIdentifier}
     *
     */
    ShikibetsuNoKanriBuilder(
            DbT3118ShikibetsuNoKanriEntity entity,
            ShikibetsuNoKanriIdentifier id
    ) {
        this.entity = entity.clone();
        this.id = id;

    }

//TODO Key項目のsetterメソッドは削除してください。
//TODO 一緒に置換される値のまとまりで不変なクラスを作成し、その単位でsetterを作る様に見直してください。
    /**
     * 識別番号を設定します。
     *
     * @param 識別番号 識別番号
     * @return {@link ShikibetsuNoKanriBuilder}
     */
    public ShikibetsuNoKanriBuilder set識別番号(RString 識別番号) {
        requireNonNull(識別番号, UrSystemErrorMessages.値がnull.getReplacedMessage("識別番号"));
        entity.setShikibetsuNo(識別番号);
        return this;
    }

    /**
     * 適用開始年月を設定します。
     *
     * @param 適用開始年月 適用開始年月
     * @return {@link ShikibetsuNoKanriBuilder}
     */
    public ShikibetsuNoKanriBuilder set適用開始年月(FlexibleYearMonth 適用開始年月) {
        requireNonNull(適用開始年月, UrSystemErrorMessages.値がnull.getReplacedMessage("適用開始年月"));
        entity.setTekiyoKaishiYM(適用開始年月);
        return this;
    }

    /**
     * 適用終了年月を設定します。
     *
     * @param 適用終了年月 適用終了年月
     * @return {@link ShikibetsuNoKanriBuilder}
     */
    public ShikibetsuNoKanriBuilder set適用終了年月(FlexibleYearMonth 適用終了年月) {
        requireNonNull(適用終了年月, UrSystemErrorMessages.値がnull.getReplacedMessage("適用終了年月"));
        entity.setTekiyoShuryoYM(適用終了年月);
        return this;
    }

    /**
     * 名称を設定します。
     *
     * @param 名称 名称
     * @return {@link ShikibetsuNoKanriBuilder}
     */
    public ShikibetsuNoKanriBuilder set名称(RString 名称) {
        requireNonNull(名称, UrSystemErrorMessages.値がnull.getReplacedMessage("名称"));
        entity.setMeisho(名称);
        return this;
    }

    /**
     * 略称を設定します。
     *
     * @param 略称 略称
     * @return {@link ShikibetsuNoKanriBuilder}
     */
    public ShikibetsuNoKanriBuilder set略称(RString 略称) {
        requireNonNull(略称, UrSystemErrorMessages.値がnull.getReplacedMessage("略称"));
        entity.setRyakusho(略称);
        return this;
    }

    /**
     * 名称２を設定します。
     *
     * @param 名称２ 名称２
     * @return {@link ShikibetsuNoKanriBuilder}
     */
    public ShikibetsuNoKanriBuilder set名称２(RString 名称２) {
        requireNonNull(名称２, UrSystemErrorMessages.値がnull.getReplacedMessage("名称２"));
        entity.setMeisho2(名称２);
        return this;
    }

    /**
     * 識別番号区分を設定します。
     *
     * @param 識別番号区分 識別番号区分
     * @return {@link ShikibetsuNoKanriBuilder}
     */
    public ShikibetsuNoKanriBuilder set識別番号区分(RString 識別番号区分) {
        requireNonNull(識別番号区分, UrSystemErrorMessages.値がnull.getReplacedMessage("識別番号区分"));
        entity.setShikibetsuNoKubon(識別番号区分);
        return this;
    }

    /**
     * 給付実績区分を設定します。
     *
     * @param 給付実績区分 給付実績区分
     * @return {@link ShikibetsuNoKanriBuilder}
     */
    public ShikibetsuNoKanriBuilder set給付実績区分(RString 給付実績区分) {
        requireNonNull(給付実績区分, UrSystemErrorMessages.値がnull.getReplacedMessage("給付実績区分"));
        entity.setKyufujissekiKubun(給付実績区分);
        return this;
    }

    /**
     * 給付分類区分を設定します。
     *
     * @param 給付分類区分 給付分類区分
     * @return {@link ShikibetsuNoKanriBuilder}
     */
    public ShikibetsuNoKanriBuilder set給付分類区分(RString 給付分類区分) {
        requireNonNull(給付分類区分, UrSystemErrorMessages.値がnull.getReplacedMessage("給付分類区分"));
        entity.setKyufuBunruiKubun(給付分類区分);
        return this;
    }

    /**
     * 選択可能サービス種類コード01を設定します。
     *
     * @param 選択可能サービス種類コード01 選択可能サービス種類コード01
     * @return {@link ShikibetsuNoKanriBuilder}
     */
    public ShikibetsuNoKanriBuilder set選択可能サービス種類コード01(RString 選択可能サービス種類コード01) {
        requireNonNull(選択可能サービス種類コード01, UrSystemErrorMessages.値がnull.getReplacedMessage("選択可能サービス種類コード01"));
        entity.setSentakuKanoShuruiCode01(選択可能サービス種類コード01);
        return this;
    }

    /**
     * 選択可能サービス種類コード02を設定します。
     *
     * @param 選択可能サービス種類コード02 選択可能サービス種類コード02
     * @return {@link ShikibetsuNoKanriBuilder}
     */
    public ShikibetsuNoKanriBuilder set選択可能サービス種類コード02(RString 選択可能サービス種類コード02) {
        requireNonNull(選択可能サービス種類コード02, UrSystemErrorMessages.値がnull.getReplacedMessage("選択可能サービス種類コード02"));
        entity.setSentakuKanoShuruiCode02(選択可能サービス種類コード02);
        return this;
    }

    /**
     * 選択可能サービス種類コード03を設定します。
     *
     * @param 選択可能サービス種類コード03 選択可能サービス種類コード03
     * @return {@link ShikibetsuNoKanriBuilder}
     */
    public ShikibetsuNoKanriBuilder set選択可能サービス種類コード03(RString 選択可能サービス種類コード03) {
        requireNonNull(選択可能サービス種類コード03, UrSystemErrorMessages.値がnull.getReplacedMessage("選択可能サービス種類コード03"));
        entity.setSentakuKanoShuruiCode03(選択可能サービス種類コード03);
        return this;
    }

    /**
     * 選択可能サービス種類コード04を設定します。
     *
     * @param 選択可能サービス種類コード04 選択可能サービス種類コード04
     * @return {@link ShikibetsuNoKanriBuilder}
     */
    public ShikibetsuNoKanriBuilder set選択可能サービス種類コード04(RString 選択可能サービス種類コード04) {
        requireNonNull(選択可能サービス種類コード04, UrSystemErrorMessages.値がnull.getReplacedMessage("選択可能サービス種類コード04"));
        entity.setSentakuKanoShuruiCode04(選択可能サービス種類コード04);
        return this;
    }

    /**
     * 選択可能サービス種類コード05を設定します。
     *
     * @param 選択可能サービス種類コード05 選択可能サービス種類コード05
     * @return {@link ShikibetsuNoKanriBuilder}
     */
    public ShikibetsuNoKanriBuilder set選択可能サービス種類コード05(RString 選択可能サービス種類コード05) {
        requireNonNull(選択可能サービス種類コード05, UrSystemErrorMessages.値がnull.getReplacedMessage("選択可能サービス種類コード05"));
        entity.setSentakuKanoShuruiCode05(選択可能サービス種類コード05);
        return this;
    }

    /**
     * 選択可能サービス種類コード06を設定します。
     *
     * @param 選択可能サービス種類コード06 選択可能サービス種類コード06
     * @return {@link ShikibetsuNoKanriBuilder}
     */
    public ShikibetsuNoKanriBuilder set選択可能サービス種類コード06(RString 選択可能サービス種類コード06) {
        requireNonNull(選択可能サービス種類コード06, UrSystemErrorMessages.値がnull.getReplacedMessage("選択可能サービス種類コード06"));
        entity.setSentakuKanoShuruiCode06(選択可能サービス種類コード06);
        return this;
    }

    /**
     * 選択可能サービス種類コード07を設定します。
     *
     * @param 選択可能サービス種類コード07 選択可能サービス種類コード07
     * @return {@link ShikibetsuNoKanriBuilder}
     */
    public ShikibetsuNoKanriBuilder set選択可能サービス種類コード07(RString 選択可能サービス種類コード07) {
        requireNonNull(選択可能サービス種類コード07, UrSystemErrorMessages.値がnull.getReplacedMessage("選択可能サービス種類コード07"));
        entity.setSentakuKanoShuruiCode07(選択可能サービス種類コード07);
        return this;
    }

    /**
     * 選択可能サービス種類コード08を設定します。
     *
     * @param 選択可能サービス種類コード08 選択可能サービス種類コード08
     * @return {@link ShikibetsuNoKanriBuilder}
     */
    public ShikibetsuNoKanriBuilder set選択可能サービス種類コード08(RString 選択可能サービス種類コード08) {
        requireNonNull(選択可能サービス種類コード08, UrSystemErrorMessages.値がnull.getReplacedMessage("選択可能サービス種類コード08"));
        entity.setSentakuKanoShuruiCode08(選択可能サービス種類コード08);
        return this;
    }

    /**
     * 選択可能サービス種類コード09を設定します。
     *
     * @param 選択可能サービス種類コード09 選択可能サービス種類コード09
     * @return {@link ShikibetsuNoKanriBuilder}
     */
    public ShikibetsuNoKanriBuilder set選択可能サービス種類コード09(RString 選択可能サービス種類コード09) {
        requireNonNull(選択可能サービス種類コード09, UrSystemErrorMessages.値がnull.getReplacedMessage("選択可能サービス種類コード09"));
        entity.setSentakuKanoShuruiCode09(選択可能サービス種類コード09);
        return this;
    }

    /**
     * 選択可能サービス種類コード10を設定します。
     *
     * @param 選択可能サービス種類コード10 選択可能サービス種類コード10
     * @return {@link ShikibetsuNoKanriBuilder}
     */
    public ShikibetsuNoKanriBuilder set選択可能サービス種類コード10(RString 選択可能サービス種類コード10) {
        requireNonNull(選択可能サービス種類コード10, UrSystemErrorMessages.値がnull.getReplacedMessage("選択可能サービス種類コード10"));
        entity.setSentakuKanoShuruiCode10(選択可能サービス種類コード10);
        return this;
    }

    /**
     * 選択可能サービス種類コード11を設定します。
     *
     * @param 選択可能サービス種類コード11 選択可能サービス種類コード11
     * @return {@link ShikibetsuNoKanriBuilder}
     */
    public ShikibetsuNoKanriBuilder set選択可能サービス種類コード11(RString 選択可能サービス種類コード11) {
        requireNonNull(選択可能サービス種類コード11, UrSystemErrorMessages.値がnull.getReplacedMessage("選択可能サービス種類コード11"));
        entity.setSentakuKanoShuruiCode11(選択可能サービス種類コード11);
        return this;
    }

    /**
     * 選択可能サービス種類コード12を設定します。
     *
     * @param 選択可能サービス種類コード12 選択可能サービス種類コード12
     * @return {@link ShikibetsuNoKanriBuilder}
     */
    public ShikibetsuNoKanriBuilder set選択可能サービス種類コード12(RString 選択可能サービス種類コード12) {
        requireNonNull(選択可能サービス種類コード12, UrSystemErrorMessages.値がnull.getReplacedMessage("選択可能サービス種類コード12"));
        entity.setSentakuKanoShuruiCode12(選択可能サービス種類コード12);
        return this;
    }

    /**
     * 選択可能サービス種類コード13を設定します。
     *
     * @param 選択可能サービス種類コード13 選択可能サービス種類コード13
     * @return {@link ShikibetsuNoKanriBuilder}
     */
    public ShikibetsuNoKanriBuilder set選択可能サービス種類コード13(RString 選択可能サービス種類コード13) {
        requireNonNull(選択可能サービス種類コード13, UrSystemErrorMessages.値がnull.getReplacedMessage("選択可能サービス種類コード13"));
        entity.setSentakuKanoShuruiCode13(選択可能サービス種類コード13);
        return this;
    }

    /**
     * 選択可能サービス種類コード14を設定します。
     *
     * @param 選択可能サービス種類コード14 選択可能サービス種類コード14
     * @return {@link ShikibetsuNoKanriBuilder}
     */
    public ShikibetsuNoKanriBuilder set選択可能サービス種類コード14(RString 選択可能サービス種類コード14) {
        requireNonNull(選択可能サービス種類コード14, UrSystemErrorMessages.値がnull.getReplacedMessage("選択可能サービス種類コード14"));
        entity.setSentakuKanoShuruiCode14(選択可能サービス種類コード14);
        return this;
    }

    /**
     * 選択可能サービス種類コード15を設定します。
     *
     * @param 選択可能サービス種類コード15 選択可能サービス種類コード15
     * @return {@link ShikibetsuNoKanriBuilder}
     */
    public ShikibetsuNoKanriBuilder set選択可能サービス種類コード15(RString 選択可能サービス種類コード15) {
        requireNonNull(選択可能サービス種類コード15, UrSystemErrorMessages.値がnull.getReplacedMessage("選択可能サービス種類コード15"));
        entity.setSentakuKanoShuruiCode15(選択可能サービス種類コード15);
        return this;
    }

    /**
     * 選択可能サービス種類コード16を設定します。
     *
     * @param 選択可能サービス種類コード16 選択可能サービス種類コード16
     * @return {@link ShikibetsuNoKanriBuilder}
     */
    public ShikibetsuNoKanriBuilder set選択可能サービス種類コード16(RString 選択可能サービス種類コード16) {
        requireNonNull(選択可能サービス種類コード16, UrSystemErrorMessages.値がnull.getReplacedMessage("選択可能サービス種類コード16"));
        entity.setSentakuKanoShuruiCode16(選択可能サービス種類コード16);
        return this;
    }

    /**
     * 選択可能サービス種類コード17を設定します。
     *
     * @param 選択可能サービス種類コード17 選択可能サービス種類コード17
     * @return {@link ShikibetsuNoKanriBuilder}
     */
    public ShikibetsuNoKanriBuilder set選択可能サービス種類コード17(RString 選択可能サービス種類コード17) {
        requireNonNull(選択可能サービス種類コード17, UrSystemErrorMessages.値がnull.getReplacedMessage("選択可能サービス種類コード17"));
        entity.setSentakuKanoShuruiCode17(選択可能サービス種類コード17);
        return this;
    }

    /**
     * 選択可能サービス種類コード18を設定します。
     *
     * @param 選択可能サービス種類コード18 選択可能サービス種類コード18
     * @return {@link ShikibetsuNoKanriBuilder}
     */
    public ShikibetsuNoKanriBuilder set選択可能サービス種類コード18(RString 選択可能サービス種類コード18) {
        requireNonNull(選択可能サービス種類コード18, UrSystemErrorMessages.値がnull.getReplacedMessage("選択可能サービス種類コード18"));
        entity.setSentakuKanoShuruiCode18(選択可能サービス種類コード18);
        return this;
    }

    /**
     * 選択可能サービス種類コード19を設定します。
     *
     * @param 選択可能サービス種類コード19 選択可能サービス種類コード19
     * @return {@link ShikibetsuNoKanriBuilder}
     */
    public ShikibetsuNoKanriBuilder set選択可能サービス種類コード19(RString 選択可能サービス種類コード19) {
        requireNonNull(選択可能サービス種類コード19, UrSystemErrorMessages.値がnull.getReplacedMessage("選択可能サービス種類コード19"));
        entity.setSentakuKanoShuruiCode19(選択可能サービス種類コード19);
        return this;
    }

    /**
     * 選択可能サービス種類コード20を設定します。
     *
     * @param 選択可能サービス種類コード20 選択可能サービス種類コード20
     * @return {@link ShikibetsuNoKanriBuilder}
     */
    public ShikibetsuNoKanriBuilder set選択可能サービス種類コード20(RString 選択可能サービス種類コード20) {
        requireNonNull(選択可能サービス種類コード20, UrSystemErrorMessages.値がnull.getReplacedMessage("選択可能サービス種類コード20"));
        entity.setSentakuKanoShuruiCode20(選択可能サービス種類コード20);
        return this;
    }

    /**
     * 社福選択可能種類コード01を設定します。
     *
     * @param 社福選択可能種類コード01 社福選択可能種類コード01
     * @return {@link ShikibetsuNoKanriBuilder}
     */
    public ShikibetsuNoKanriBuilder set社福選択可能種類コード01(RString 社福選択可能種類コード01) {
        requireNonNull(社福選択可能種類コード01, UrSystemErrorMessages.値がnull.getReplacedMessage("社福選択可能種類コード01"));
        entity.setShafukuSentakuKanoShuruiCode01(社福選択可能種類コード01);
        return this;
    }

    /**
     * 社福選択可能種類コード02を設定します。
     *
     * @param 社福選択可能種類コード02 社福選択可能種類コード02
     * @return {@link ShikibetsuNoKanriBuilder}
     */
    public ShikibetsuNoKanriBuilder set社福選択可能種類コード02(RString 社福選択可能種類コード02) {
        requireNonNull(社福選択可能種類コード02, UrSystemErrorMessages.値がnull.getReplacedMessage("社福選択可能種類コード02"));
        entity.setShafukuSentakuKanoShuruiCode02(社福選択可能種類コード02);
        return this;
    }

    /**
     * 社福選択可能種類コード03を設定します。
     *
     * @param 社福選択可能種類コード03 社福選択可能種類コード03
     * @return {@link ShikibetsuNoKanriBuilder}
     */
    public ShikibetsuNoKanriBuilder set社福選択可能種類コード03(RString 社福選択可能種類コード03) {
        requireNonNull(社福選択可能種類コード03, UrSystemErrorMessages.値がnull.getReplacedMessage("社福選択可能種類コード03"));
        entity.setShafukuSentakuKanoShuruiCode03(社福選択可能種類コード03);
        return this;
    }

    /**
     * 社福選択可能種類コード04を設定します。
     *
     * @param 社福選択可能種類コード04 社福選択可能種類コード04
     * @return {@link ShikibetsuNoKanriBuilder}
     */
    public ShikibetsuNoKanriBuilder set社福選択可能種類コード04(RString 社福選択可能種類コード04) {
        requireNonNull(社福選択可能種類コード04, UrSystemErrorMessages.値がnull.getReplacedMessage("社福選択可能種類コード04"));
        entity.setShafukuSentakuKanoShuruiCode04(社福選択可能種類コード04);
        return this;
    }

    /**
     * 社福選択可能種類コード05を設定します。
     *
     * @param 社福選択可能種類コード05 社福選択可能種類コード05
     * @return {@link ShikibetsuNoKanriBuilder}
     */
    public ShikibetsuNoKanriBuilder set社福選択可能種類コード05(RString 社福選択可能種類コード05) {
        requireNonNull(社福選択可能種類コード05, UrSystemErrorMessages.値がnull.getReplacedMessage("社福選択可能種類コード05"));
        entity.setShafukuSentakuKanoShuruiCode05(社福選択可能種類コード05);
        return this;
    }

    /**
     * 社福選択可能種類コード06を設定します。
     *
     * @param 社福選択可能種類コード06 社福選択可能種類コード06
     * @return {@link ShikibetsuNoKanriBuilder}
     */
    public ShikibetsuNoKanriBuilder set社福選択可能種類コード06(RString 社福選択可能種類コード06) {
        requireNonNull(社福選択可能種類コード06, UrSystemErrorMessages.値がnull.getReplacedMessage("社福選択可能種類コード06"));
        entity.setShafukuSentakuKanoShuruiCode06(社福選択可能種類コード06);
        return this;
    }

    /**
     * 社福選択可能種類コード07を設定します。
     *
     * @param 社福選択可能種類コード07 社福選択可能種類コード07
     * @return {@link ShikibetsuNoKanriBuilder}
     */
    public ShikibetsuNoKanriBuilder set社福選択可能種類コード07(RString 社福選択可能種類コード07) {
        requireNonNull(社福選択可能種類コード07, UrSystemErrorMessages.値がnull.getReplacedMessage("社福選択可能種類コード07"));
        entity.setShafukuSentakuKanoShuruiCode07(社福選択可能種類コード07);
        return this;
    }

    /**
     * 社福選択可能種類コード08を設定します。
     *
     * @param 社福選択可能種類コード08 社福選択可能種類コード08
     * @return {@link ShikibetsuNoKanriBuilder}
     */
    public ShikibetsuNoKanriBuilder set社福選択可能種類コード08(RString 社福選択可能種類コード08) {
        requireNonNull(社福選択可能種類コード08, UrSystemErrorMessages.値がnull.getReplacedMessage("社福選択可能種類コード08"));
        entity.setShafukuSentakuKanoShuruiCode08(社福選択可能種類コード08);
        return this;
    }

    /**
     * 社福選択可能種類コード09を設定します。
     *
     * @param 社福選択可能種類コード09 社福選択可能種類コード09
     * @return {@link ShikibetsuNoKanriBuilder}
     */
    public ShikibetsuNoKanriBuilder set社福選択可能種類コード09(RString 社福選択可能種類コード09) {
        requireNonNull(社福選択可能種類コード09, UrSystemErrorMessages.値がnull.getReplacedMessage("社福選択可能種類コード09"));
        entity.setShafukuSentakuKanoShuruiCode09(社福選択可能種類コード09);
        return this;
    }

    /**
     * 社福選択可能種類コード10を設定します。
     *
     * @param 社福選択可能種類コード10 社福選択可能種類コード10
     * @return {@link ShikibetsuNoKanriBuilder}
     */
    public ShikibetsuNoKanriBuilder set社福選択可能種類コード10(RString 社福選択可能種類コード10) {
        requireNonNull(社福選択可能種類コード10, UrSystemErrorMessages.値がnull.getReplacedMessage("社福選択可能種類コード10"));
        entity.setShafukuSentakuKanoShuruiCode10(社福選択可能種類コード10);
        return this;
    }

    /**
     * 基本設定区分を設定します。
     *
     * @param 基本設定区分 基本設定区分
     * @return {@link ShikibetsuNoKanriBuilder}
     */
    public ShikibetsuNoKanriBuilder set基本設定区分(RString 基本設定区分) {
        requireNonNull(基本設定区分, UrSystemErrorMessages.値がnull.getReplacedMessage("基本設定区分"));
        entity.setKihonSetteiKubun(基本設定区分);
        return this;
    }

    /**
     * 明細設定区分を設定します。
     *
     * @param 明細設定区分 明細設定区分
     * @return {@link ShikibetsuNoKanriBuilder}
     */
    public ShikibetsuNoKanriBuilder set明細設定区分(RString 明細設定区分) {
        requireNonNull(明細設定区分, UrSystemErrorMessages.値がnull.getReplacedMessage("明細設定区分"));
        entity.setMeisaiSetteiKubun(明細設定区分);
        return this;
    }

    /**
     * 緊急時施設療養設定区分を設定します。
     *
     * @param 緊急時施設療養設定区分 緊急時施設療養設定区分
     * @return {@link ShikibetsuNoKanriBuilder}
     */
    public ShikibetsuNoKanriBuilder set緊急時施設療養設定区分(RString 緊急時施設療養設定区分) {
        requireNonNull(緊急時施設療養設定区分, UrSystemErrorMessages.値がnull.getReplacedMessage("緊急時施設療養設定区分"));
        entity.setKinkyuShisetsuRyoyoSetteiKubun(緊急時施設療養設定区分);
        return this;
    }

    /**
     * 特定診療費設定区分を設定します。
     *
     * @param 特定診療費設定区分 特定診療費設定区分
     * @return {@link ShikibetsuNoKanriBuilder}
     */
    public ShikibetsuNoKanriBuilder set特定診療費設定区分(RString 特定診療費設定区分) {
        requireNonNull(特定診療費設定区分, UrSystemErrorMessages.値がnull.getReplacedMessage("特定診療費設定区分"));
        entity.setTokuteiShinryoSetteiKubun(特定診療費設定区分);
        return this;
    }

    /**
     * 食事費用設定区分を設定します。
     *
     * @param 食事費用設定区分 食事費用設定区分
     * @return {@link ShikibetsuNoKanriBuilder}
     */
    public ShikibetsuNoKanriBuilder set食事費用設定区分(RString 食事費用設定区分) {
        requireNonNull(食事費用設定区分, UrSystemErrorMessages.値がnull.getReplacedMessage("食事費用設定区分"));
        entity.setShokujiHiyosetteiKubun(食事費用設定区分);
        return this;
    }

    /**
     * 居宅計画費設定区分を設定します。
     *
     * @param 居宅計画費設定区分 居宅計画費設定区分
     * @return {@link ShikibetsuNoKanriBuilder}
     */
    public ShikibetsuNoKanriBuilder set居宅計画費設定区分(RString 居宅計画費設定区分) {
        requireNonNull(居宅計画費設定区分, UrSystemErrorMessages.値がnull.getReplacedMessage("居宅計画費設定区分"));
        entity.setKyotakuKeikakuSetteiKubun(居宅計画費設定区分);
        return this;
    }

    /**
     * 福祉用具購入費設定区分を設定します。
     *
     * @param 福祉用具購入費設定区分 福祉用具購入費設定区分
     * @return {@link ShikibetsuNoKanriBuilder}
     */
    public ShikibetsuNoKanriBuilder set福祉用具購入費設定区分(RString 福祉用具購入費設定区分) {
        requireNonNull(福祉用具購入費設定区分, UrSystemErrorMessages.値がnull.getReplacedMessage("福祉用具購入費設定区分"));
        entity.setFukushoyouguKonyuSetteiKubun(福祉用具購入費設定区分);
        return this;
    }

    /**
     * 住宅改修費設定区分を設定します。
     *
     * @param 住宅改修費設定区分 住宅改修費設定区分
     * @return {@link ShikibetsuNoKanriBuilder}
     */
    public ShikibetsuNoKanriBuilder set住宅改修費設定区分(RString 住宅改修費設定区分) {
        requireNonNull(住宅改修費設定区分, UrSystemErrorMessages.値がnull.getReplacedMessage("住宅改修費設定区分"));
        entity.setJutakukaishuSetteiKubun(住宅改修費設定区分);
        return this;
    }

    /**
     * 高額介護サービス費設定区分を設定します。
     *
     * @param 高額介護サービス費設定区分 高額介護サービス費設定区分
     * @return {@link ShikibetsuNoKanriBuilder}
     */
    public ShikibetsuNoKanriBuilder set高額介護サービス費設定区分(RString 高額介護サービス費設定区分) {
        requireNonNull(高額介護サービス費設定区分, UrSystemErrorMessages.値がnull.getReplacedMessage("高額介護サービス費設定区分"));
        entity.setKogakuKaigoSetteiKubun(高額介護サービス費設定区分);
        return this;
    }

    /**
     * 特定診療特別療養設定区分を設定します。
     *
     * @param 特定診療特別療養設定区分 特定診療特別療養設定区分
     * @return {@link ShikibetsuNoKanriBuilder}
     */
    public ShikibetsuNoKanriBuilder set特定診療特別療養設定区分(RString 特定診療特別療養設定区分) {
        requireNonNull(特定診療特別療養設定区分, UrSystemErrorMessages.値がnull.getReplacedMessage("特定診療特別療養設定区分"));
        entity.setTokuteishinryoTokubetsuryoyoSetteiKubun(特定診療特別療養設定区分);
        return this;
    }

    /**
     * 特定入所者設定区分を設定します。
     *
     * @param 特定入所者設定区分 特定入所者設定区分
     * @return {@link ShikibetsuNoKanriBuilder}
     */
    public ShikibetsuNoKanriBuilder set特定入所者設定区分(RString 特定入所者設定区分) {
        requireNonNull(特定入所者設定区分, UrSystemErrorMessages.値がnull.getReplacedMessage("特定入所者設定区分"));
        entity.setTokuteinyushoshaSetteiKubun(特定入所者設定区分);
        return this;
    }

    /**
     * 社会福祉法人軽減設定区分を設定します。
     *
     * @param 社会福祉法人軽減設定区分 社会福祉法人軽減設定区分
     * @return {@link ShikibetsuNoKanriBuilder}
     */
    public ShikibetsuNoKanriBuilder set社会福祉法人軽減設定区分(RString 社会福祉法人軽減設定区分) {
        requireNonNull(社会福祉法人軽減設定区分, UrSystemErrorMessages.値がnull.getReplacedMessage("社会福祉法人軽減設定区分"));
        entity.setShakaifukushiKeigenSetteiKubun(社会福祉法人軽減設定区分);
        return this;
    }

    /**
     * ケアマネジメント設定区分を設定します。
     *
     * @param ケアマネジメント設定区分 ケアマネジメント設定区分
     * @return {@link ShikibetsuNoKanriBuilder}
     */
    public ShikibetsuNoKanriBuilder setケアマネジメント設定区分(RString ケアマネジメント設定区分) {
        requireNonNull(ケアマネジメント設定区分, UrSystemErrorMessages.値がnull.getReplacedMessage("ケアマネジメント設定区分"));
        entity.setCareManagementSetteiKubun(ケアマネジメント設定区分);
        return this;
    }

    /**
     * 特定疾患施設療養設定区分を設定します。
     *
     * @param 特定疾患施設療養設定区分 特定疾患施設療養設定区分
     * @return {@link ShikibetsuNoKanriBuilder}
     */
    public ShikibetsuNoKanriBuilder set特定疾患施設療養設定区分(RString 特定疾患施設療養設定区分) {
        requireNonNull(特定疾患施設療養設定区分, UrSystemErrorMessages.値がnull.getReplacedMessage("特定疾患施設療養設定区分"));
        entity.setTokuteiShikkanSetteiKubun(特定疾患施設療養設定区分);
        return this;
    }

    /**
     * 明細住所地特例設定区分を設定します。
     *
     * @param 明細住所地特例設定区分 明細住所地特例設定区分
     * @return {@link ShikibetsuNoKanriBuilder}
     */
    public ShikibetsuNoKanriBuilder set明細住所地特例設定区分(RString 明細住所地特例設定区分) {
        requireNonNull(明細住所地特例設定区分, UrSystemErrorMessages.値がnull.getReplacedMessage("明細住所地特例設定区分"));
        entity.setMeisaiJushochitokureiSetteiKubun(明細住所地特例設定区分);
        return this;
    }

    /**
     * 集計設定区分を設定します。
     *
     * @param 集計設定区分 集計設定区分
     * @return {@link ShikibetsuNoKanriBuilder}
     */
    public ShikibetsuNoKanriBuilder set集計設定区分(RString 集計設定区分) {
        requireNonNull(集計設定区分, UrSystemErrorMessages.値がnull.getReplacedMessage("集計設定区分"));
        entity.setShukeiSetteiKubun(集計設定区分);
        return this;
    }

    /**
     * 表示順を設定します。
     *
     * @param 表示順 表示順
     * @return {@link ShikibetsuNoKanriBuilder}
     */
    public ShikibetsuNoKanriBuilder set表示順(int 表示順) {
        requireNonNull(表示順, UrSystemErrorMessages.値がnull.getReplacedMessage("表示順"));
        entity.setHyoujiJun(表示順);
        return this;
    }

    /**
     * 過誤申立様式番号を設定します。
     *
     * @param 過誤申立様式番号 過誤申立様式番号
     * @return {@link ShikibetsuNoKanriBuilder}
     */
    public ShikibetsuNoKanriBuilder set過誤申立様式番号(RString 過誤申立様式番号) {
        requireNonNull(過誤申立様式番号, UrSystemErrorMessages.値がnull.getReplacedMessage("過誤申立様式番号"));
        entity.setKagoMoshitateYoshikiNo(過誤申立様式番号);
        return this;
    }

    /**
     * {@link ShikibetsuNoKanri}のインスタンスを生成します。
     *
     * @return {@link ShikibetsuNoKanri}のインスタンス
     */
    public ShikibetsuNoKanri build() {
        return new ShikibetsuNoKanri(entity, id);
    }
}
