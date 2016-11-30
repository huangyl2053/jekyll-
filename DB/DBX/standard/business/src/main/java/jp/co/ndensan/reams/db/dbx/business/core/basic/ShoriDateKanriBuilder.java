/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.business.core.basic;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7022ShoriDateKanriEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * {@link ShoriDateKanri}の編集を行うビルダークラスです。
 */
public class ShoriDateKanriBuilder {

    private final DbT7022ShoriDateKanriEntity entity;
    private final ShoriDateKanriIdentifier id;

    /**
     * {@link DbT7022ShoriDateKanriEntity}より{@link ShoriDateKanri}の編集用Builderクラスを生成します。
     *
     * @param entity {@link DbT7022ShoriDateKanriEntity}
     * @param id {@link ShoriDateKanriIdentifier}
     *
     */
    ShoriDateKanriBuilder(
            DbT7022ShoriDateKanriEntity entity,
            ShoriDateKanriIdentifier id
    ) {
        this.entity = entity.clone();
        this.id = id;

    }

//TODO Key項目のsetterメソッドは削除してください。
//TODO 一緒に置換される値のまとまりで不変なクラスを作成し、その単位でsetterを作る様に見直してください。
    /**
     * サブ業務コードを設定します。
     *
     * @param サブ業務コード サブ業務コード
     * @return {@link ShoriDateKanriBuilder}
     */
    public ShoriDateKanriBuilder setサブ業務コード(SubGyomuCode サブ業務コード) {
        requireNonNull(サブ業務コード, UrSystemErrorMessages.値がnull.getReplacedMessage("サブ業務コード"));
        entity.setSubGyomuCode(サブ業務コード);
        return this;
    }

    /**
     * 市町村コードを設定します。
     *
     * @param 市町村コード 市町村コード
     * @return {@link ShoriDateKanriBuilder}
     */
    public ShoriDateKanriBuilder set市町村コード(LasdecCode 市町村コード) {
        requireNonNull(市町村コード, UrSystemErrorMessages.値がnull.getReplacedMessage("市町村コード"));
        entity.setShichosonCode(市町村コード);
        return this;
    }

    /**
     * 処理名を設定します。
     *
     * @param 処理名 処理名
     * @return {@link ShoriDateKanriBuilder}
     */
    public ShoriDateKanriBuilder set処理名(RString 処理名) {
        requireNonNull(処理名, UrSystemErrorMessages.値がnull.getReplacedMessage("処理名"));
        entity.setShoriName(処理名);
        return this;
    }

    /**
     * 処理枝番を設定します。
     *
     * @param 処理枝番 処理枝番
     * @return {@link ShoriDateKanriBuilder}
     */
    public ShoriDateKanriBuilder set処理枝番(RString 処理枝番) {
        requireNonNull(処理枝番, UrSystemErrorMessages.値がnull.getReplacedMessage("処理枝番"));
        entity.setShoriEdaban(処理枝番);
        return this;
    }

    /**
     * 年度を設定します。
     *
     * @param 年度 年度
     * @return {@link ShoriDateKanriBuilder}
     */
    public ShoriDateKanriBuilder set年度(FlexibleYear 年度) {
        requireNonNull(年度, UrSystemErrorMessages.値がnull.getReplacedMessage("年度"));
        entity.setNendo(年度);
        return this;
    }

    /**
     * 年度内連番を設定します。
     *
     * @param 年度内連番 年度内連番
     * @return {@link ShoriDateKanriBuilder}
     */
    public ShoriDateKanriBuilder set年度内連番(RString 年度内連番) {
        requireNonNull(年度内連番, UrSystemErrorMessages.値がnull.getReplacedMessage("年度内連番"));
        entity.setNendoNaiRenban(年度内連番);
        return this;
    }

    /**
     * 基準年月日を設定します。
     *
     * @param 基準年月日 基準年月日
     * @return {@link ShoriDateKanriBuilder}
     */
    public ShoriDateKanriBuilder set基準年月日(FlexibleDate 基準年月日) {
        requireNonNull(基準年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("基準年月日"));
        entity.setKijunYMD(基準年月日);
        return this;
    }

    /**
     * 基準日時を設定します。
     *
     * @param 基準日時 基準日時
     * @return {@link ShoriDateKanriBuilder}
     */
    public ShoriDateKanriBuilder set基準日時(YMDHMS 基準日時) {
        requireNonNull(基準日時, UrSystemErrorMessages.値がnull.getReplacedMessage("基準日時"));
        entity.setKijunTimestamp(基準日時);
        return this;
    }

    /**
     * 対象開始年月日を設定します。
     *
     * @param 対象開始年月日 対象開始年月日
     * @return {@link ShoriDateKanriBuilder}
     */
    public ShoriDateKanriBuilder set対象開始年月日(FlexibleDate 対象開始年月日) {
        requireNonNull(対象開始年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("対象開始年月日"));
        entity.setTaishoKaishiYMD(対象開始年月日);
        return this;
    }

    /**
     * 対象終了年月日を設定します。
     *
     * @param 対象終了年月日 対象終了年月日
     * @return {@link ShoriDateKanriBuilder}
     */
    public ShoriDateKanriBuilder set対象終了年月日(FlexibleDate 対象終了年月日) {
        requireNonNull(対象終了年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("対象終了年月日"));
        entity.setTaishoShuryoYMD(対象終了年月日);
        return this;
    }

    /**
     * 対象開始日時を設定します。
     *
     * @param 対象開始日時 対象開始日時
     * @return {@link ShoriDateKanriBuilder}
     */
    public ShoriDateKanriBuilder set対象開始日時(YMDHMS 対象開始日時) {
        requireNonNull(対象開始日時, UrSystemErrorMessages.値がnull.getReplacedMessage("対象開始日時"));
        entity.setTaishoKaishiTimestamp(対象開始日時);
        return this;
    }

    /**
     * 対象終了日時を設定します。
     *
     * @param 対象終了日時 対象終了日時
     * @return {@link ShoriDateKanriBuilder}
     */
    public ShoriDateKanriBuilder set対象終了日時(YMDHMS 対象終了日時) {
        requireNonNull(対象終了日時, UrSystemErrorMessages.値がnull.getReplacedMessage("対象終了日時"));
        entity.setTaishoShuryoTimestamp(対象終了日時);
        return this;
    }

    /**
     * {@link ShoriDateKanri}のインスタンスを生成します。
     *
     * @return {@link ShoriDateKanri}のインスタンス
     */
    public ShoriDateKanri build() {
        return new ShoriDateKanri(entity, id);
    }
}
