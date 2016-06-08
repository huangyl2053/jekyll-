/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3079DaisanshaKoiSongaiBaishoKinJuryoEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * {@link DaisanshaKoiSongaiBaishoKinJuryo}の編集を行うビルダークラスです。
 */
public class DaisanshaKoiSongaiBaishoKinJuryoBuilder {

    private final DbT3079DaisanshaKoiSongaiBaishoKinJuryoEntity entity;
    private final DaisanshaKoiSongaiBaishoKinJuryoIdentifier id;

    /**
     * {@link DbT3079DaisanshaKoiSongaiBaishoKinJuryoEntity}より{@link DaisanshaKoiSongaiBaishoKinJuryo}の編集用Builderクラスを生成します。
     *
     * @param entity {@link DbT3079DaisanshaKoiSongaiBaishoKinJuryoEntity}
     * @param id {@link DaisanshaKoiSongaiBaishoKinJuryoIdentifier}
     *
     */
    DaisanshaKoiSongaiBaishoKinJuryoBuilder(
            DbT3079DaisanshaKoiSongaiBaishoKinJuryoEntity entity,
            DaisanshaKoiSongaiBaishoKinJuryoIdentifier id
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
     * @return {@link DaisanshaKoiSongaiBaishoKinJuryoBuilder}
     */
    public DaisanshaKoiSongaiBaishoKinJuryoBuilder set被保険者番号(HihokenshaNo 被保険者番号) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        entity.setHihokenshaNo(被保険者番号);
        return this;
    }

    /**
     * 第三者行為届出管理番号を設定します。
     *
     * @param 第三者行為届出管理番号 第三者行為届出管理番号
     * @return {@link DaisanshaKoiSongaiBaishoKinJuryoBuilder}
     */
    public DaisanshaKoiSongaiBaishoKinJuryoBuilder set第三者行為届出管理番号(RString 第三者行為届出管理番号) {
        requireNonNull(第三者行為届出管理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("第三者行為届出管理番号"));
        entity.setTodokedeKanriNo(第三者行為届出管理番号);
        return this;
    }

    /**
     * 第三者行為求償請求番号を設定します。
     *
     * @param 第三者行為求償請求番号 第三者行為求償請求番号
     * @return {@link DaisanshaKoiSongaiBaishoKinJuryoBuilder}
     */
    public DaisanshaKoiSongaiBaishoKinJuryoBuilder set第三者行為求償請求番号(RString 第三者行為求償請求番号) {
        requireNonNull(第三者行為求償請求番号, UrSystemErrorMessages.値がnull.getReplacedMessage("第三者行為求償請求番号"));
        entity.setKyushoSeikyuNo(第三者行為求償請求番号);
        return this;
    }

    /**
     * 履歴番号を設定します。
     *
     * @param 履歴番号 履歴番号
     * @return {@link DaisanshaKoiSongaiBaishoKinJuryoBuilder}
     */
    public DaisanshaKoiSongaiBaishoKinJuryoBuilder set履歴番号(Decimal 履歴番号) {
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));
        entity.setRirekiNo(履歴番号);
        return this;
    }

    /**
     * 入金確認年月日を設定します。
     *
     * @param 入金確認年月日 入金確認年月日
     * @return {@link DaisanshaKoiSongaiBaishoKinJuryoBuilder}
     */
    public DaisanshaKoiSongaiBaishoKinJuryoBuilder set入金確認年月日(FlexibleDate 入金確認年月日) {
        requireNonNull(入金確認年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("入金確認年月日"));
        entity.setNyukinKakuninYMD(入金確認年月日);
        return this;
    }

    /**
     * 領収年月日を設定します。
     *
     * @param 領収年月日 領収年月日
     * @return {@link DaisanshaKoiSongaiBaishoKinJuryoBuilder}
     */
    public DaisanshaKoiSongaiBaishoKinJuryoBuilder set領収年月日(FlexibleDate 領収年月日) {
        requireNonNull(領収年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("領収年月日"));
        entity.setRyoshuYMD(領収年月日);
        return this;
    }

    /**
     * 領収金額を設定します。
     *
     * @param 領収金額 領収金額
     * @return {@link DaisanshaKoiSongaiBaishoKinJuryoBuilder}
     */
    public DaisanshaKoiSongaiBaishoKinJuryoBuilder set領収金額(Decimal 領収金額) {
        requireNonNull(領収金額, UrSystemErrorMessages.値がnull.getReplacedMessage("領収金額"));
        entity.setRyoshuKingaku(領収金額);
        return this;
    }

    /**
     * 過不足金有無を設定します。
     *
     * @param 過不足金有無 過不足金有無
     * @return {@link DaisanshaKoiSongaiBaishoKinJuryoBuilder}
     */
    public DaisanshaKoiSongaiBaishoKinJuryoBuilder set過不足金有無(RString 過不足金有無) {
        requireNonNull(過不足金有無, UrSystemErrorMessages.値がnull.getReplacedMessage("過不足金有無"));
        entity.setMabusokuKinUMU(過不足金有無);
        return this;
    }

    /**
     * 過不足額を設定します。
     *
     * @param 過不足額 過不足額
     * @return {@link DaisanshaKoiSongaiBaishoKinJuryoBuilder}
     */
    public DaisanshaKoiSongaiBaishoKinJuryoBuilder set過不足額(Decimal 過不足額) {
        requireNonNull(過不足額, UrSystemErrorMessages.値がnull.getReplacedMessage("過不足額"));
        entity.setKabusokuGaku(過不足額);
        return this;
    }

    /**
     * {@link DaisanshaKoiSongaiBaishoKinJuryo}のインスタンスを生成します。
     *
     * @return {@link DaisanshaKoiSongaiBaishoKinJuryo}のインスタンス
     */
    public DaisanshaKoiSongaiBaishoKinJuryo build() {
        return new DaisanshaKoiSongaiBaishoKinJuryo(entity, id);
    }
}
