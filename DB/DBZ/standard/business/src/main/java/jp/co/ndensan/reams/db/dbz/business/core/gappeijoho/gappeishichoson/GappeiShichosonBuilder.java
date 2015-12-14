/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.gappeijoho.gappeishichoson;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7056GappeiShichosonEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * {@link GappeiShichoson}の編集を行うビルダークラスです。
 */
public class GappeiShichosonBuilder {

    private final DbT7056GappeiShichosonEntity entity;
    private final GappeiShichosonIdentifier id;

    /**
     * {@link DbT7056GappeiShichosonEntity}より{@link GappeiShichoson}の編集用Builderクラスを生成します。
     *
     * @param entity {@link DbT7056GappeiShichosonEntity}
     * @param id {@link GappeiShichosonIdentifier}
     *
     */
    GappeiShichosonBuilder(
            DbT7056GappeiShichosonEntity entity,
            GappeiShichosonIdentifier id
    ) {
        this.entity = entity.clone();
        this.id = id;

    }

    /**
     * 運用開始年月日を設定します。
     *
     * @param 運用開始年月日 運用開始年月日
     * @return {@link GappeiShichosonBuilder}
     */
    public GappeiShichosonBuilder set運用開始年月日(FlexibleDate 運用開始年月日) {
        requireNonNull(運用開始年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("運用開始年月日"));
        entity.setUnyoKaishiYMD(運用開始年月日);
        return this;
    }

    /**
     * 運用終了年月日を設定します。
     *
     * @param 運用終了年月日 運用終了年月日
     * @return {@link GappeiShichosonBuilder}
     */
    public GappeiShichosonBuilder set運用終了年月日(FlexibleDate 運用終了年月日) {
        requireNonNull(運用終了年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("運用終了年月日"));
        entity.setUnyoShuryoYMD(運用終了年月日);
        return this;
    }

    /**
     * 旧保険者番号を設定します。
     *
     * @param 旧保険者番号 旧保険者番号
     * @return {@link GappeiShichosonBuilder}
     */
    public GappeiShichosonBuilder set旧保険者番号(HokenshaNo 旧保険者番号) {
        requireNonNull(旧保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("旧保険者番号"));
        entity.setKyuHokenshaNo(旧保険者番号);
        return this;
    }

    /**
     * 旧市町村名称を設定します。
     *
     * @param 旧市町村名称 旧市町村名称
     * @return {@link GappeiShichosonBuilder}
     */
    public GappeiShichosonBuilder set旧市町村名称(RString 旧市町村名称) {
        requireNonNull(旧市町村名称, UrSystemErrorMessages.値がnull.getReplacedMessage("旧市町村名称"));
        entity.setKyuShichosonMeisho(旧市町村名称);
        return this;
    }

    /**
     * 都道府県名称を設定します。
     *
     * @param 都道府県名称 都道府県名称
     * @return {@link GappeiShichosonBuilder}
     */
    public GappeiShichosonBuilder set都道府県名称(RString 都道府県名称) {
        requireNonNull(都道府県名称, UrSystemErrorMessages.値がnull.getReplacedMessage("都道府県名称"));
        entity.setTodofukenMeisho(都道府県名称);
        return this;
    }

    /**
     * 郡名称を設定します。
     *
     * @param 郡名称 郡名称
     * @return {@link GappeiShichosonBuilder}
     */
    public GappeiShichosonBuilder set郡名称(RString 郡名称) {
        requireNonNull(郡名称, UrSystemErrorMessages.値がnull.getReplacedMessage("郡名称"));
        entity.setGunMeisho(郡名称);
        return this;
    }

    /**
     * 郵便番号を設定します。
     *
     * @param 郵便番号 郵便番号
     * @return {@link GappeiShichosonBuilder}
     */
    public GappeiShichosonBuilder set郵便番号(YubinNo 郵便番号) {
        requireNonNull(郵便番号, UrSystemErrorMessages.値がnull.getReplacedMessage("郵便番号"));
        entity.setYubinNo(郵便番号);
        return this;
    }

    /**
     * 電話番号を設定します。
     *
     * @param 電話番号 電話番号
     * @return {@link GappeiShichosonBuilder}
     */
    public GappeiShichosonBuilder set電話番号(TelNo 電話番号) {
        requireNonNull(電話番号, UrSystemErrorMessages.値がnull.getReplacedMessage("電話番号"));
        entity.setTelNo(電話番号);
        return this;
    }

    /**
     * 老人保健市町村番号を設定します。
     *
     * @param 老人保健市町村番号 老人保健市町村番号
     * @return {@link GappeiShichosonBuilder}
     */
    public GappeiShichosonBuilder set老人保健市町村番号(RString 老人保健市町村番号) {
        requireNonNull(老人保健市町村番号, UrSystemErrorMessages.値がnull.getReplacedMessage("老人保健市町村番号"));
        entity.setRojinhokenShichosonNo(老人保健市町村番号);
        return this;
    }

    /**
     * 老人保健受給者番号体系を設定します。
     *
     * @param 老人保健受給者番号体系 老人保健受給者番号体系
     * @return {@link GappeiShichosonBuilder}
     */
    public GappeiShichosonBuilder set老人保健受給者番号体系(RString 老人保健受給者番号体系) {
        requireNonNull(老人保健受給者番号体系, UrSystemErrorMessages.値がnull.getReplacedMessage("老人保健受給者番号体系"));
        entity.setRokenJukyushaNoTaikei(老人保健受給者番号体系);
        return this;
    }

    /**
     * 表示有無を設定します。
     *
     * @param 表示有無 表示有無
     * @return {@link GappeiShichosonBuilder}
     */
    public GappeiShichosonBuilder set表示有無(RString 表示有無) {
        requireNonNull(表示有無, UrSystemErrorMessages.値がnull.getReplacedMessage("表示有無"));
        entity.setHyojiUmu(表示有無);
        return this;
    }

    /**
     * {@link GappeiShichoson}のインスタンスを生成します。
     *
     * @return {@link GappeiShichoson}のインスタンス
     */
    public GappeiShichoson build() {
        return new GappeiShichoson(entity, id);
    }
}
