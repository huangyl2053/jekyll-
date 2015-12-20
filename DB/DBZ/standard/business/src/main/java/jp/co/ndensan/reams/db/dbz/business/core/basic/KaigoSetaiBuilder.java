/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7014KaigoSetaiEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
//import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
//import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * {@link KaigoSetai}の編集を行うビルダークラスです。
 */
public class KaigoSetaiBuilder {

    private final DbT7014KaigoSetaiEntity entity;
    private final KaigoSetaiIdentifier id;

    /**
     * {@link DbT7014KaigoSetaiEntity}より{@link KaigoSetai}の編集用Builderクラスを生成します。
     *
     * @param entity {@link DbT7014KaigoSetaiEntity}
     * @param id {@link KaigoSetaiIdentifier}
     *
     */
    KaigoSetaiBuilder(
            DbT7014KaigoSetaiEntity entity,
            KaigoSetaiIdentifier id
    ) {
        this.entity = entity.clone();
        this.id = id;

    }

//TODO Key項目のsetterメソッドは削除してください。
//TODO 一緒に置換される値のまとまりで不変なクラスを作成し、その単位でsetterを作る様に見直してください。
    /**
     * 被保険者番号を設定します。
     *
     * @param 被保険者番号 被保険者番号
     * @return {@link KaigoSetaiBuilder}
     */
    public KaigoSetaiBuilder set被保険者番号(HihokenshaNo 被保険者番号) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        entity.setHihokenshaNo(被保険者番号);
        return this;
    }

    /**
     * 管理識別区分を設定します。
     *
     * @param 管理識別区分 管理識別区分
     * @return {@link KaigoSetaiBuilder}
     */
    public KaigoSetaiBuilder set管理識別区分(RString 管理識別区分) {
        requireNonNull(管理識別区分, UrSystemErrorMessages.値がnull.getReplacedMessage("管理識別区分"));
        entity.setKanriShikibetsuKubun(管理識別区分);
        return this;
    }

    /**
     * 世帯把握基準年月日を設定します。
     *
     * @param 世帯把握基準年月日 世帯把握基準年月日
     * @return {@link KaigoSetaiBuilder}
     */
    public KaigoSetaiBuilder set世帯把握基準年月日(FlexibleDate 世帯把握基準年月日) {
        requireNonNull(世帯把握基準年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("世帯把握基準年月日"));
        entity.setSetaiHaakuKijunYMD(世帯把握基準年月日);
        return this;
    }

    /**
     * 世帯員管理連番を設定します。
     *
     * @param 世帯員管理連番 世帯員管理連番
     * @return {@link KaigoSetaiBuilder}
     */
    public KaigoSetaiBuilder set世帯員管理連番(int 世帯員管理連番) {
        requireNonNull(世帯員管理連番, UrSystemErrorMessages.値がnull.getReplacedMessage("世帯員管理連番"));
        entity.setSetaiInkanriRenban(世帯員管理連番);
        return this;
    }

    /**
     * 世帯員識別コードを設定します。
     *
     * @param 世帯員識別コード 世帯員識別コード
     * @return {@link KaigoSetaiBuilder}
     */
    public KaigoSetaiBuilder set世帯員識別コード(ShikibetsuCode 世帯員識別コード) {
        requireNonNull(世帯員識別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("世帯員識別コード"));
        entity.setSetaiInshikibetsuCode(世帯員識別コード);
        return this;
    }

    /**
     * 本人区分を設定します。
     *
     * @param 本人区分 本人区分
     * @return {@link KaigoSetaiBuilder}
     */
    public KaigoSetaiBuilder set本人区分(RString 本人区分) {
        requireNonNull(本人区分, UrSystemErrorMessages.値がnull.getReplacedMessage("本人区分"));
        entity.setHonninKubun(本人区分);
        return this;
    }

    /**
     * {@link KaigoSetai}のインスタンスを生成します。
     *
     * @return {@link KaigoSetai}のインスタンス
     */
    public KaigoSetai build() {
        return new KaigoSetai(entity, id);
    }
}
