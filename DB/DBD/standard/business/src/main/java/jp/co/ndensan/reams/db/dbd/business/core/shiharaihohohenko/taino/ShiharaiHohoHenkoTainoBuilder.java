/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.core.shiharaihohohenko.taino;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT4022ShiharaiHohoHenkoTainoEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * {@link ShiharaiHohoHenkoTaino}の編集を行うビルダークラスです。
 *
 * @reamsid_L DBB-9999-013 huangh
 */
public class ShiharaiHohoHenkoTainoBuilder {

    private final DbT4022ShiharaiHohoHenkoTainoEntity entity;
    private final ShiharaiHohoHenkoTainoIdentifier id;

    /**
     * {@link DbT4022ShiharaiHohoHenkoTainoEntity}より{@link ShiharaiHohoHenkoTaino}の編集用Builderクラスを生成します。
     *
     * @param entity {@link DbT4022ShiharaiHohoHenkoTainoEntity}
     * @param id {@link ShiharaiHohoHenkoTainoIdentifier}
     * @param seishinTechoNini {@link Models}
     * @param todokedesha {@link Models}
     *
     */
    ShiharaiHohoHenkoTainoBuilder(
            DbT4022ShiharaiHohoHenkoTainoEntity entity,
            ShiharaiHohoHenkoTainoIdentifier id
    ) {
        this.entity = entity.clone();
        this.id = id;
    }

    /**
     * 滞納判定年月日を設定します。
     *
     * @param 滞納判定年月日 滞納判定年月日
     * @return {@link ShiharaiHohoHenkoTainoBuilder}
     */
    public ShiharaiHohoHenkoTainoBuilder set滞納判定年月日(FlexibleDate 滞納判定年月日) {
        requireNonNull(滞納判定年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("滞納判定年月日"));
        entity.setTainoHanteiYMD(滞納判定年月日);
        return this;
    }

    /**
     * 判定基準年月日を設定します。
     *
     * @param 判定基準年月日 判定基準年月日
     * @return {@link ShiharaiHohoHenkoTainoBuilder}
     */
    public ShiharaiHohoHenkoTainoBuilder set判定基準年月日(FlexibleDate 判定基準年月日) {
        requireNonNull(判定基準年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("判定基準年月日"));
        entity.setHanteiKijunYMD(判定基準年月日);
        return this;
    }

    /**
     * 時効起算年月日を設定します。
     *
     * @param 時効起算年月日 時効起算年月日
     * @return {@link ShiharaiHohoHenkoTainoBuilder}
     */
    public ShiharaiHohoHenkoTainoBuilder set時効起算年月日(FlexibleDate 時効起算年月日) {
        requireNonNull(時効起算年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("時効起算年月日"));
        entity.setJikoKisanYMD(時効起算年月日);
        return this;
    }

    /**
     * 時効起算日区分を設定します。
     *
     * @param 時効起算日区分 時効起算日区分
     * @return {@link ShiharaiHohoHenkoTainoBuilder}
     */
    public ShiharaiHohoHenkoTainoBuilder set時効起算日区分(RString 時効起算日区分) {
        requireNonNull(時効起算日区分, UrSystemErrorMessages.値がnull.getReplacedMessage("時効起算日区分"));
        entity.setJikoKisanKubun(時効起算日区分);
        return this;
    }

    /**
     * 完納_未納区分を設定します。
     *
     * @param 完納_未納区分 完納_未納区分
     * @return {@link ShiharaiHohoHenkoTainoBuilder}
     */
    public ShiharaiHohoHenkoTainoBuilder set完納_未納区分(RString 完納_未納区分) {
        requireNonNull(完納_未納区分, UrSystemErrorMessages.値がnull.getReplacedMessage("完納_未納区分")
        );
        entity.setKanno_MinoKubun(完納_未納区分
        );
        return this;
    }

    /**
     * 時効区分を設定します。
     *
     * @param 時効区分 時効区分
     * @return {@link ShiharaiHohoHenkoTainoBuilder}
     */
    public ShiharaiHohoHenkoTainoBuilder set時効区分(RString 時効区分) {
        requireNonNull(時効区分, UrSystemErrorMessages.値がnull.getReplacedMessage("時効区分"));
        entity.setJikoKubun(時効区分);
        return this;
    }

    /**
     * 時効後収入区分を設定します。
     *
     * @param 時効後収入区分 時効後収入区分
     * @return {@link ShiharaiHohoHenkoTainoBuilder}
     */
    public ShiharaiHohoHenkoTainoBuilder set時効後収入区分(RString 時効後収入区分) {
        requireNonNull(時効後収入区分, UrSystemErrorMessages.値がnull.getReplacedMessage("時効後収入区分"));
        entity.setJikoAtoShunyuKubun(時効後収入区分);
        return this;
    }

    /**
     * 対象管理区分を設定します。
     *
     * @param 対象管理区分 対象管理区分
     * @return {@link ShiharaiHohoHenkoTainoBuilder}
     */
    public ShiharaiHohoHenkoTainoBuilder set対象管理区分(RString 対象管理区分) {
        requireNonNull(対象管理区分, UrSystemErrorMessages.値がnull.getReplacedMessage("対象管理区分"));
        entity.setTaishoKanriKubun(対象管理区分);
        return this;
    }

    /**
     * 調定額を設定します。
     *
     * @param 調定額 調定額
     * @return {@link ShiharaiHohoHenkoTainoBuilder}
     */
    public ShiharaiHohoHenkoTainoBuilder set調定額(Decimal 調定額) {
        requireNonNull(調定額, UrSystemErrorMessages.値がnull.getReplacedMessage("調定額"));
        entity.setChoteigaku(調定額);
        return this;
    }

    /**
     * 納期限を設定します。
     *
     * @param 納期限 納期限
     * @return {@link ShiharaiHohoHenkoTainoBuilder}
     */
    public ShiharaiHohoHenkoTainoBuilder set納期限(FlexibleDate 納期限) {
        requireNonNull(納期限, UrSystemErrorMessages.値がnull.getReplacedMessage("納期限"));
        entity.setNokigen(納期限);
        return this;
    }

    /**
     * 滞納額を設定します。
     *
     * @param 滞納額 滞納額
     * @return {@link ShiharaiHohoHenkoTainoBuilder}
     */
    public ShiharaiHohoHenkoTainoBuilder set滞納額(Decimal 滞納額) {
        requireNonNull(滞納額, UrSystemErrorMessages.値がnull.getReplacedMessage("滞納額"));
        entity.setTainoGaku(滞納額);
        return this;
    }

    /**
     * 控除額を設定します。
     *
     * @param 控除額 控除額
     * @return {@link ShiharaiHohoHenkoTainoBuilder}
     */
    public ShiharaiHohoHenkoTainoBuilder set控除額(Decimal 控除額) {
        requireNonNull(控除額, UrSystemErrorMessages.値がnull.getReplacedMessage("控除額"));
        entity.setKojoGaku(控除額);
        return this;
    }

    /**
     * 論理削除フラグを設定します。
     *
     * @param 論理削除フラグ 論理削除フラグ
     * @return {@link ShiharaiHohoHenkoTainoBuilder}
     */
    public ShiharaiHohoHenkoTainoBuilder set論理削除フラグ(boolean 論理削除フラグ) {
        requireNonNull(論理削除フラグ, UrSystemErrorMessages.値がnull.getReplacedMessage("論理削除フラグ"));
        entity.setLogicalDeletedFlag(論理削除フラグ);
        return this;
    }

    /**
     * {@link ShiharaiHohoHenkoTaino}のインスタンスを生成します。
     *
     * @return {@link ShiharaiHohoHenkoTaino}のインスタンス
     */
    public ShiharaiHohoHenkoTaino build() {
        return new ShiharaiHohoHenkoTaino(entity, id);
    }
}
