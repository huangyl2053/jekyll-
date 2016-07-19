/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.core.shiharaihohohenko.sashitome;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT4024ShiharaiHohoHenkoSashitomeEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * {@link ShiharaiHohoHenkoSashitome}の編集を行うビルダークラスです。
 *
 * @reamsid_L DBB-9999-013 huangh
 */
public class ShiharaiHohoHenkoSashitomeBuilder {

    private final DbT4024ShiharaiHohoHenkoSashitomeEntity entity;
    private final ShiharaiHohoHenkoSashitomeIdentifier id;

    /**
     * {@link DbT4024ShiharaiHohoHenkoSashitomeEntity}より{@link ShiharaiHohoHenkoSashitome}の編集用Builderクラスを生成します。
     *
     * @param entity {@link DbT4024ShiharaiHohoHenkoSashitomeEntity}
     * @param id {@link ShiharaiHohoHenkoSashitomeIdentifier}
     * @param seishinTechoNini {@link Models}
     * @param todokedesha {@link Models}
     *
     */
    ShiharaiHohoHenkoSashitomeBuilder(
            DbT4024ShiharaiHohoHenkoSashitomeEntity entity,
            ShiharaiHohoHenkoSashitomeIdentifier id
    ) {
        this.entity = entity.clone();
        this.id = id;
    }

    /**
     * 差止控除状態区分を設定します。
     *
     * @param 差止控除状態区分 差止控除状態区分
     * @return {@link ShiharaiHohoHenkoSashitomeBuilder}
     */
    public ShiharaiHohoHenkoSashitomeBuilder set差止控除状態区分(RString 差止控除状態区分) {
        requireNonNull(差止控除状態区分, UrSystemErrorMessages.値がnull.getReplacedMessage("差止控除状態区分"));
        entity.setSashitomeKojoJotaiKubun(差止控除状態区分);
        return this;
    }

    /**
     * 差止決定年月日を設定します。
     *
     * @param 差止決定年月日 差止決定年月日
     * @return {@link ShiharaiHohoHenkoSashitomeBuilder}
     */
    public ShiharaiHohoHenkoSashitomeBuilder set差止決定年月日(FlexibleDate 差止決定年月日) {
        requireNonNull(差止決定年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("差止決定年月日"));
        entity.setSashitome_KetteiYMD(差止決定年月日);
        return this;
    }

    /**
     * 差止通知書発行年月日を設定します。
     *
     * @param 差止通知書発行年月日 差止通知書発行年月日
     * @return {@link ShiharaiHohoHenkoSashitomeBuilder}
     */
    public ShiharaiHohoHenkoSashitomeBuilder set差止通知書発行年月日(FlexibleDate 差止通知書発行年月日) {
        requireNonNull(差止通知書発行年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("差止通知書発行年月日"));
        entity.setSashitome_TsuchiHakkoYMD(差止通知書発行年月日);
        return this;
    }

    /**
     * 差止通知書再発行フラグを設定します。
     *
     * @param 差止通知書再発行フラグ 差止通知書再発行フラグ
     * @return {@link ShiharaiHohoHenkoSashitomeBuilder}
     */
    public ShiharaiHohoHenkoSashitomeBuilder set差止通知書再発行フラグ(boolean 差止通知書再発行フラグ) {
        requireNonNull(差止通知書再発行フラグ, UrSystemErrorMessages.値がnull.getReplacedMessage("差止通知書再発行フラグ"));
        entity.setSashitome_TsuchiSaiHakkoFlag(差止通知書再発行フラグ);
        return this;
    }

    /**
     * 差止控除番号を設定します。
     *
     * @param 差止控除番号 差止控除番号
     * @return {@link ShiharaiHohoHenkoSashitomeBuilder}
     */
    public ShiharaiHohoHenkoSashitomeBuilder set差止控除番号(RString 差止控除番号) {
        requireNonNull(差止控除番号, UrSystemErrorMessages.値がnull.getReplacedMessage("差止控除番号"));
        entity.setSashitomeKojoNo(差止控除番号);
        return this;
    }

    /**
     * 差止納付期限を設定します。
     *
     * @param 差止納付期限 差止納付期限
     * @return {@link ShiharaiHohoHenkoSashitomeBuilder}
     */
    public ShiharaiHohoHenkoSashitomeBuilder set差止納付期限(FlexibleDate 差止納付期限) {
        requireNonNull(差止納付期限, UrSystemErrorMessages.値がnull.getReplacedMessage("差止納付期限"));
        entity.setSashitome_NofuYMD(差止納付期限);
        return this;
    }

    /**
     * 差止解除年月日を設定します。
     *
     * @param 差止解除年月日 差止解除年月日
     * @return {@link ShiharaiHohoHenkoSashitomeBuilder}
     */
    public ShiharaiHohoHenkoSashitomeBuilder set差止解除年月日(FlexibleDate 差止解除年月日) {
        requireNonNull(差止解除年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("差止解除年月日"));
        entity.setSashitome_KaijoYMD(差止解除年月日);
        return this;
    }

    /**
     * 差止サービス提供年月を設定します。
     *
     * @param 差止サービス提供年月 差止サービス提供年月
     * @return {@link ShiharaiHohoHenkoSashitomeBuilder}
     */
    public ShiharaiHohoHenkoSashitomeBuilder set差止サービス提供年月(FlexibleYearMonth 差止サービス提供年月) {
        requireNonNull(差止サービス提供年月, UrSystemErrorMessages.値がnull.getReplacedMessage("差止サービス提供年月"));
        entity.setSashitome_ServiceTeikyoYM(差止サービス提供年月);
        return this;
    }

    /**
     * 差止償還整理番号を設定します。
     *
     * @param 差止償還整理番号 差止償還整理番号
     * @return {@link ShiharaiHohoHenkoSashitomeBuilder}
     */
    public ShiharaiHohoHenkoSashitomeBuilder set差止償還整理番号(RString 差止償還整理番号) {
        requireNonNull(差止償還整理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("差止償還整理番号"));
        entity.setSashitome_ShokanSeiriNo(差止償還整理番号);
        return this;
    }

    /**
     * 控除決定年月日を設定します。
     *
     * @param 控除決定年月日 控除決定年月日
     * @return {@link ShiharaiHohoHenkoSashitomeBuilder}
     */
    public ShiharaiHohoHenkoSashitomeBuilder set控除決定年月日(FlexibleDate 控除決定年月日) {
        requireNonNull(控除決定年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("控除決定年月日"));
        entity.setKojo_KetteiYMD(控除決定年月日);
        return this;
    }

    /**
     * 控除通知書発行年月日を設定します。
     *
     * @param 控除通知書発行年月日 控除通知書発行年月日
     * @return {@link ShiharaiHohoHenkoSashitomeBuilder}
     */
    public ShiharaiHohoHenkoSashitomeBuilder set控除通知書発行年月日(FlexibleDate 控除通知書発行年月日) {
        requireNonNull(控除通知書発行年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("控除通知書発行年月日"));
        entity.setKojo_TsuchiHakkoYMD(控除通知書発行年月日);
        return this;
    }

    /**
     * 控除通知書再発行フラグを設定します。
     *
     * @param 控除通知書再発行フラグ 控除通知書再発行フラグ
     * @return {@link ShiharaiHohoHenkoSashitomeBuilder}
     */
    public ShiharaiHohoHenkoSashitomeBuilder set控除通知書再発行フラグ(boolean 控除通知書再発行フラグ) {
        requireNonNull(控除通知書再発行フラグ, UrSystemErrorMessages.値がnull.getReplacedMessage("控除通知書再発行フラグ"));
        entity.setKojo_TsuchiSaiHakkoFlag(控除通知書再発行フラグ);
        return this;
    }

    /**
     * 控除被保険者証提出期限を設定します。
     *
     * @param 控除被保険者証提出期限 控除被保険者証提出期限
     * @return {@link ShiharaiHohoHenkoSashitomeBuilder}
     */
    public ShiharaiHohoHenkoSashitomeBuilder set控除被保険者証提出期限(FlexibleDate 控除被保険者証提出期限) {
        requireNonNull(控除被保険者証提出期限, UrSystemErrorMessages.値がnull.getReplacedMessage("控除被保険者証提出期限"));
        entity.setKojo_ShoTeishutsuYMD(控除被保険者証提出期限);
        return this;
    }

    /**
     * 論理削除フラグを設定します。
     *
     * @param 論理削除フラグ 論理削除フラグ
     * @return {@link ShiharaiHohoHenkoSashitomeBuilder}
     */
    public ShiharaiHohoHenkoSashitomeBuilder set論理削除フラグ(boolean 論理削除フラグ) {
        requireNonNull(論理削除フラグ, UrSystemErrorMessages.値がnull.getReplacedMessage("論理削除フラグ"));
        entity.setLogicalDeletedFlag(論理削除フラグ);
        return this;
    }

    // <editor-fold defaultstate="collapsed" desc="無しの場合">
    /**
     * {@link ShiharaiHohoHenkoSashitome}のインスタンスを生成します。
     *
     * @return {@link ShiharaiHohoHenkoSashitome}のインスタンス
     */
    public ShiharaiHohoHenkoSashitome build() {
        return new ShiharaiHohoHenkoSashitome(entity, id);
    }
}
