/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.core.basic;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT4401IryohiKojoEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 医療費控除のビルダークラスです。
 *
 * @reamsid_L DBD-5780-010 tz_chengpeng
 *
 */
public class IryohiKojoBuilder {

    private final DbT4401IryohiKojoEntity entity;
    private final IryohiKojoIdentifier id;

    /**
     * {@link DbT4401IryohiKojoEntity}より{@link IryohiKojo}の編集用Builderクラスを生成します。
     *
     * @param entity {@link DbT4401IryohiKojoEntity}
     * @param id {@link IryohiKojoIdentifier}
     *
     */
    IryohiKojoBuilder(
            DbT4401IryohiKojoEntity entity,
            IryohiKojoIdentifier id
    ) {
        this.entity = entity.clone();
        this.id = id;

    }

    /**
     * 登録年月日を設定します。
     *
     * @param 登録年月日 登録年月日
     * @return {@link IryohiKojoBuilder}
     */
    public IryohiKojoBuilder set登録年月日(FlexibleDate 登録年月日) {
        requireNonNull(登録年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("登録年月日"));
        entity.setTorokuYMD(登録年月日);
        return this;
    }

    /**
     * 申請年月日を設定します。
     *
     * @param 申請年月日 申請年月日
     * @return {@link IryohiKojoBuilder}
     */
    public IryohiKojoBuilder set申請年月日(FlexibleDate 申請年月日) {
        requireNonNull(申請年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("申請年月日"));
        entity.setShinseiYMD(申請年月日);
        return this;
    }

    /**
     * 認定有効期間開始年月日を設定します。
     *
     * @param 認定有効期間開始年月日 認定有効期間開始年月日
     * @return {@link IryohiKojoBuilder}
     */
    public IryohiKojoBuilder set認定有効期間開始年月日(FlexibleDate 認定有効期間開始年月日) {
        requireNonNull(認定有効期間開始年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("認定有効期間開始年月日"));
        entity.setNinteiYukoKikanKaishiYMD(認定有効期間開始年月日);
        return this;
    }

    /**
     * 認定有効期間終了年月日を設定します。
     *
     * @param 認定有効期間終了年月日 認定有効期間終了年月日
     * @return {@link IryohiKojoBuilder}
     */
    public IryohiKojoBuilder set認定有効期間終了年月日(FlexibleDate 認定有効期間終了年月日) {
        requireNonNull(認定有効期間終了年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("認定有効期間終了年月日"));
        entity.setNinteiYukoKikanShuryoYMD(認定有効期間終了年月日);
        return this;
    }

    /**
     * 主治医意見書受領年月日を設定します。
     *
     * @param 主治医意見書受領年月日 主治医意見書受領年月日
     * @return {@link IryohiKojoBuilder}
     */
    public IryohiKojoBuilder set主治医意見書受領年月日(FlexibleDate 主治医意見書受領年月日) {
        requireNonNull(主治医意見書受領年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("主治医意見書受領年月日"));
        entity.setShujiiIkenshoJuryoYMD(主治医意見書受領年月日);
        return this;
    }

    /**
     * 日常生活自立度を設定します。
     *
     * @param 日常生活自立度 日常生活自立度
     * @return {@link IryohiKojoBuilder}
     */
    public IryohiKojoBuilder set日常生活自立度(RString 日常生活自立度) {
        requireNonNull(日常生活自立度, UrSystemErrorMessages.値がnull.getReplacedMessage("日常生活自立度"));
        entity.setNichijoSeikatsuJiritsudo(日常生活自立度);
        return this;
    }

    /**
     * 尿失禁の発生を設定します。
     *
     * @param 尿失禁の発生 尿失禁の発生
     * @return {@link IryohiKojoBuilder}
     */
    public IryohiKojoBuilder set尿失禁の発生(boolean 尿失禁の発生) {
        requireNonNull(尿失禁の発生, UrSystemErrorMessages.値がnull.getReplacedMessage("尿失禁の発生"));
        entity.setNyoshikkinHassei(尿失禁の発生);
        return this;
    }

    /**
     * 発行年月日を設定します。
     *
     * @param 発行年月日 時効起算年月日
     * @return {@link IryohiKojoBuilder}
     */
    public IryohiKojoBuilder set発行年月日(FlexibleDate 発行年月日) {
        requireNonNull(発行年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("発行年月日"));
        entity.setHakkoYMD(発行年月日);
        return this;
    }

    /**
     * 論理削除フラグを設定します。
     *
     * @param 論理削除フラグ 論理削除フラグ
     * @return {@link IryohiKojoBuilder}
     */
    public IryohiKojoBuilder set論理削除フラグ(boolean 論理削除フラグ) {
        requireNonNull(論理削除フラグ, UrSystemErrorMessages.値がnull.getReplacedMessage("論理削除フラグ"));
        entity.setLogicalDeletedFlag(論理削除フラグ);
        return this;
    }

    /**
     * {@link IryohiKojo}のインスタンスを生成します。
     *
     * @return {@link IryohiKojo}のインスタンス
     */
    public IryohiKojo build() {
        return new IryohiKojo(entity, id);
    }
}
