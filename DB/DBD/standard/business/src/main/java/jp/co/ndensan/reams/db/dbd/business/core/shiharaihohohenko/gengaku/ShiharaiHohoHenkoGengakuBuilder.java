/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.core.shiharaihohohenko.gengaku;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbd.business.core.shiharaihohohenko.gengaku.meisai.ShiharaiHohoHenkoGengakuMeisai;
import jp.co.ndensan.reams.db.dbd.business.core.shiharaihohohenko.gengaku.meisai.ShiharaiHohoHenkoGengakuMeisaiIdentifier;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT4025ShiharaiHohoHenkoGengakuEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.Models;

/**
 * {@link ShiharaiHohoHenkoGengaku}の編集を行うビルダークラスです。
 *
 * @reamsid_L DBB-9999-013 huangh
 */
public class ShiharaiHohoHenkoGengakuBuilder {

    private final DbT4025ShiharaiHohoHenkoGengakuEntity entity;
    private final ShiharaiHohoHenkoGengakuIdentifier id;
    private final Models<ShiharaiHohoHenkoGengakuMeisaiIdentifier, ShiharaiHohoHenkoGengakuMeisai> shiharaiHohoHenkoGengakuMeisai;

    /**
     * {@link DbT4025ShiharaiHohoHenkoGengakuEntity}より{@link ShiharaiHohoHenkoGengaku}の編集用Builderクラスを生成します。
     *
     * @param entity {@link DbT4025ShiharaiHohoHenkoGengakuEntity}
     * @param id {@link ShiharaiHohoHenkoGengakuIdentifier}
     * @param shiharaiHohoHenkoGengakuMeisai {@link Models}
     *
     */
    ShiharaiHohoHenkoGengakuBuilder(
            DbT4025ShiharaiHohoHenkoGengakuEntity entity,
            ShiharaiHohoHenkoGengakuIdentifier id,
            Models<ShiharaiHohoHenkoGengakuMeisaiIdentifier, ShiharaiHohoHenkoGengakuMeisai> shiharaiHohoHenkoGengakuMeisai
    ) {
        this.entity = entity.clone();
        this.id = id;
        this.shiharaiHohoHenkoGengakuMeisai = shiharaiHohoHenkoGengakuMeisai.clone();

    }

    /**
     * 滞納判定年月日を設定します。
     *
     * @param 滞納判定年月日 滞納判定年月日
     * @return {@link ShiharaiHohoHenkoGengakuBuilder}
     */
    public ShiharaiHohoHenkoGengakuBuilder set滞納判定年月日(FlexibleDate 滞納判定年月日) {
        requireNonNull(滞納判定年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("滞納判定年月日"));
        entity.setTainoHanteiYMD(滞納判定年月日);
        return this;
    }

    /**
     * 判定基準年月日を設定します。
     *
     * @param 判定基準年月日 判定基準年月日
     * @return {@link ShiharaiHohoHenkoGengakuBuilder}
     */
    public ShiharaiHohoHenkoGengakuBuilder set判定基準年月日(FlexibleDate 判定基準年月日) {
        requireNonNull(判定基準年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("判定基準年月日"));
        entity.setHanteiKijunYMD(判定基準年月日);
        return this;
    }

    /**
     * 徴収権消滅期間を設定します。
     *
     * @param 徴収権消滅期間 徴収権消滅期間
     * @return {@link ShiharaiHohoHenkoGengakuBuilder}
     */
    public ShiharaiHohoHenkoGengakuBuilder set徴収権消滅期間(Decimal 徴収権消滅期間) {
        requireNonNull(徴収権消滅期間, UrSystemErrorMessages.値がnull.getReplacedMessage("徴収権消滅期間"));
        entity.setChoshukenShometsuKikan(徴収権消滅期間);
        return this;
    }

    /**
     * 納付済期間を設定します。
     *
     * @param 納付済期間 納付済期間
     * @return {@link ShiharaiHohoHenkoGengakuBuilder}
     */
    public ShiharaiHohoHenkoGengakuBuilder set納付済期間(Decimal 納付済期間) {
        requireNonNull(納付済期間, UrSystemErrorMessages.値がnull.getReplacedMessage("納付済期間"));
        entity.setNofusumiKikan(納付済期間);
        return this;
    }

    /**
     * 納付済減額期間を設定します。
     *
     * @param 納付済減額期間 納付済減額期間
     * @return {@link ShiharaiHohoHenkoGengakuBuilder}
     */
    public ShiharaiHohoHenkoGengakuBuilder set納付済減額期間(Decimal 納付済減額期間) {
        requireNonNull(納付済減額期間, UrSystemErrorMessages.値がnull.getReplacedMessage("納付済減額期間"));
        entity.setNofusumiGengakuKikan(納付済減額期間);
        return this;
    }

    /**
     * 確定減額期間開始年月日を設定します。
     *
     * @param 確定減額期間開始年月日 確定減額期間開始年月日
     * @return {@link ShiharaiHohoHenkoGengakuBuilder}
     */
    public ShiharaiHohoHenkoGengakuBuilder set確定減額期間開始年月日(FlexibleDate 確定減額期間開始年月日) {
        requireNonNull(確定減額期間開始年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("確定減額期間開始年月日"));
        entity.setKakutei_GengakuKaishiYMD(確定減額期間開始年月日);
        return this;
    }

    /**
     * 確定減額期間終了年月日を設定します。
     *
     * @param 確定減額期間終了年月日 確定減額期間終了年月日
     * @return {@link ShiharaiHohoHenkoGengakuBuilder}
     */
    public ShiharaiHohoHenkoGengakuBuilder set確定減額期間終了年月日(FlexibleDate 確定減額期間終了年月日) {
        requireNonNull(確定減額期間終了年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("確定減額期間終了年月日"));
        entity.setKakutei_GengakuShuryoYMD(確定減額期間終了年月日);
        return this;
    }

    /**
     * 論理削除フラグを設定します。
     *
     * @param 論理削除フラグ 論理削除フラグ
     * @return {@link ShiharaiHohoHenkoGengakuBuilder}
     */
    public ShiharaiHohoHenkoGengakuBuilder set論理削除フラグ(boolean 論理削除フラグ) {
        requireNonNull(論理削除フラグ, UrSystemErrorMessages.値がnull.getReplacedMessage("論理削除フラグ"));
        entity.setLogicalDeletedFlag(論理削除フラグ);
        return this;
    }

    /**
     * 支払方法変更減額明細情報のキー情報について判定します。<br>
     * 精神手帳情報に関連できる支払方法変更減額明細情報である場合、下記の処理に遷移します。<br>
     * キーが一致する場合は支払方法変更減額明細情報リストに支払方法変更減額明細情報{@link SeishinTechoNini}をセットします。<br>
     * キーが一致しない場合、新たに追加します。<br>
     *
     * @param 支払方法変更減額明細情報 {@link SeishinTechoNini}
     * @return {@link SeishinTechoBuilder}
     * @throws IllegalStateException キーが一致しない場合
     */
    public ShiharaiHohoHenkoGengakuBuilder setShiharaiHohoHenkoGengakuMeisai(ShiharaiHohoHenkoGengakuMeisai 支払方法変更減額明細情報) {
        if (hasSameIdentifier(支払方法変更減額明細情報.identifier())) {
            shiharaiHohoHenkoGengakuMeisai.add(支払方法変更減額明細情報);
            return this;
        }
        throw new IllegalArgumentException(UrErrorMessages.不正.toString());
    }

    private boolean hasSameIdentifier(ShiharaiHohoHenkoGengakuMeisaiIdentifier 支払方法変更減額明細情報識別子) {
        return (id.get被保険者番号().equals(支払方法変更減額明細情報識別子.get被保険者番号())
                && id.get管理区分().equals(支払方法変更減額明細情報識別子.get管理区分())
                && id.get履歴番号() == 支払方法変更減額明細情報識別子.get履歴番号());
    }

    /**
     * {@link ShiharaiHohoHenkoGengaku}のインスタンスを生成します。
     *
     * @return {@link ShiharaiHohoHenkoGengaku}のインスタンス
     */
    public ShiharaiHohoHenkoGengaku build() {
        return new ShiharaiHohoHenkoGengaku(entity, id, shiharaiHohoHenkoGengakuMeisai);
    }
}
