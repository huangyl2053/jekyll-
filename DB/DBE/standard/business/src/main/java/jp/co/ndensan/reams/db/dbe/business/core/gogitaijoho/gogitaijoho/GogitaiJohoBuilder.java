/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.gogitaijoho.gogitaijoho;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbe.business.core.gogitaijoho.gogitaiwariateiinjoho.GogitaiWariateIinJoho;
import jp.co.ndensan.reams.db.dbe.business.core.gogitaijoho.gogitaiwariateiinjoho.GogitaiWariateIinJohoIdentifier;
import jp.co.ndensan.reams.db.dbe.business.core.gogitaijoho.shinsakaikaisaibashojoho.ShinsakaiKaisaiBashoJoho;
import jp.co.ndensan.reams.db.dbe.business.core.gogitaijoho.shinsakaikaisaibashojoho.ShinsakaiKaisaiBashoJohoIdentifier;
import jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5591GogitaiJohoEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.Models;

/**
 * {@link GogitaiJoho}の編集を行うビルダークラスです。
 */
public class GogitaiJohoBuilder {

    private final DbT5591GogitaiJohoEntity entity;
    private final GogitaiJohoIdentifier id;
    private final Models<GogitaiWariateIinJohoIdentifier, GogitaiWariateIinJoho> gogitaiWariateIinJoho;
    private final Models<ShinsakaiKaisaiBashoJohoIdentifier, ShinsakaiKaisaiBashoJoho> shinsakaiKaisaiBashoJoho;

    /**
     * {@link DbT5591GogitaiJohoEntity}より{@link GogitaiJoho}の編集用Builderクラスを生成します。
     *
     * @param entity {@link DbT5591GogitaiJohoEntity}
     * @param id {@link GogitaiJohoIdentifier}
     * @param seishinTechoNini {@link Models}
     * @param todokedesha {@link Models}
     *
     */
    GogitaiJohoBuilder(
            DbT5591GogitaiJohoEntity entity,
            GogitaiJohoIdentifier id,
            Models<GogitaiWariateIinJohoIdentifier, GogitaiWariateIinJoho> gogitaiWariateIinJoho,
            Models<ShinsakaiKaisaiBashoJohoIdentifier, ShinsakaiKaisaiBashoJoho> shinsakaiKaisaiBashoJoho
    ) {
        this.entity = entity.clone();
        this.id = id;
        this.gogitaiWariateIinJoho = gogitaiWariateIinJoho;
        this.shinsakaiKaisaiBashoJoho = shinsakaiKaisaiBashoJoho;

    }

    /**
     * 合議体名称を設定します。
     *
     * @param 合議体名称 合議体名称
     * @return {@link GogitaiJohoBuilder}
     */
    public GogitaiJohoBuilder set合議体名称(RString 合議体名称) {
        requireNonNull(合議体名称, UrSystemErrorMessages.値がnull.getReplacedMessage("合議体名称"));
        entity.setGogitaiMei(合議体名称);
        return this;
    }

    /**
     * 合議体有効期間終了年月日を設定します。
     *
     * @param 合議体有効期間終了年月日 合議体有効期間終了年月日
     * @return {@link GogitaiJohoBuilder}
     */
    public GogitaiJohoBuilder set合議体有効期間終了年月日(FlexibleDate 合議体有効期間終了年月日) {
        requireNonNull(合議体有効期間終了年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("合議体有効期間終了年月日"));
        entity.setGogitaiYukoKikanShuryoYMD(合議体有効期間終了年月日);
        return this;
    }

    /**
     * 合議体開始予定時刻を設定します。
     *
     * @param 合議体開始予定時刻 合議体開始予定時刻
     * @return {@link GogitaiJohoBuilder}
     */
    public GogitaiJohoBuilder set合議体開始予定時刻(RString 合議体開始予定時刻) {
        requireNonNull(合議体開始予定時刻, UrSystemErrorMessages.値がnull.getReplacedMessage("合議体開始予定時刻"));
        entity.setGogitaiKaishiYoteiTime(合議体開始予定時刻);
        return this;
    }

    /**
     * 合議体終了予定時刻を設定します。
     *
     * @param 合議体終了予定時刻 合議体終了予定時刻
     * @return {@link GogitaiJohoBuilder}
     */
    public GogitaiJohoBuilder set合議体終了予定時刻(RString 合議体終了予定時刻) {
        requireNonNull(合議体終了予定時刻, UrSystemErrorMessages.値がnull.getReplacedMessage("合議体終了予定時刻"));
        entity.setGogitaiShuryoYoteiTime(合議体終了予定時刻);
        return this;
    }

    /**
     * 介護認定審査会開催場所コードを設定します。
     *
     * @param 介護認定審査会開催場所コード 介護認定審査会開催場所コード
     * @return {@link GogitaiJohoBuilder}
     */
    public GogitaiJohoBuilder set介護認定審査会開催場所コード(RString 介護認定審査会開催場所コード) {
        requireNonNull(介護認定審査会開催場所コード, UrSystemErrorMessages.値がnull.getReplacedMessage("介護認定審査会開催場所コード"));
        entity.setShinsakaiKaisaiBashoCode(介護認定審査会開催場所コード);
        return this;
    }

    /**
     * 介護認定審査会予定定員を設定します。
     *
     * @param 介護認定審査会予定定員 介護認定審査会予定定員
     * @return {@link GogitaiJohoBuilder}
     */
    public GogitaiJohoBuilder set介護認定審査会予定定員(int 介護認定審査会予定定員) {
        requireNonNull(介護認定審査会予定定員, UrSystemErrorMessages.値がnull.getReplacedMessage("介護認定審査会予定定員"));
        entity.setShinsakaiYoteiTeiin(介護認定審査会予定定員);
        return this;
    }

    /**
     * 介護認定審査会自動割当定員を設定します。
     *
     * @param 介護認定審査会自動割当定員 介護認定審査会自動割当定員
     * @return {@link GogitaiJohoBuilder}
     */
    public GogitaiJohoBuilder set介護認定審査会自動割当定員(int 介護認定審査会自動割当定員) {
        requireNonNull(介護認定審査会自動割当定員, UrSystemErrorMessages.値がnull.getReplacedMessage("介護認定審査会自動割当定員"));
        entity.setShinsakaiJidoWariateTeiin(介護認定審査会自動割当定員);
        return this;
    }

    /**
     * 介護認定審査会委員定員を設定します。
     *
     * @param 介護認定審査会委員定員 介護認定審査会委員定員
     * @return {@link GogitaiJohoBuilder}
     */
    public GogitaiJohoBuilder set介護認定審査会委員定員(int 介護認定審査会委員定員) {
        requireNonNull(介護認定審査会委員定員, UrSystemErrorMessages.値がnull.getReplacedMessage("介護認定審査会委員定員"));
        entity.setShinsakaiIinTeiin(介護認定審査会委員定員);
        return this;
    }

    /**
     * 合議体精神科医存在フラグを設定します。
     *
     * @param 合議体精神科医存在フラグ 合議体精神科医存在フラグ
     * @return {@link GogitaiJohoBuilder}
     */
    public GogitaiJohoBuilder set合議体精神科医存在フラグ(boolean 合議体精神科医存在フラグ) {
        requireNonNull(合議体精神科医存在フラグ, UrSystemErrorMessages.値がnull.getReplacedMessage("合議体精神科医存在フラグ"));
        entity.setGogitaiSeishinkaSonzaiFlag(合議体精神科医存在フラグ);
        return this;
    }

    /**
     * 合議体ダミーフラグを設定します。
     *
     * @param 合議体ダミーフラグ 合議体ダミーフラグ
     * @return {@link GogitaiJohoBuilder}
     */
    public GogitaiJohoBuilder set合議体ダミーフラグ(boolean 合議体ダミーフラグ) {
        requireNonNull(合議体ダミーフラグ, UrSystemErrorMessages.値がnull.getReplacedMessage("合議体ダミーフラグ"));
        entity.setGogitaiDummyFlag(合議体ダミーフラグ);
        return this;
    }

    /**
     * 合議体割当委員情報のキー情報について判定します。<br>
     * 合議体情報に関連できる合議体割当委員情報である場合、下記の処理に遷移します。<br>
     * キーが一致する場合は合議体割当委員情報リストに合議体割当委員情報{@link SeishinTechoNini}をセットします。<br>
     * キーが一致しない場合、新たに追加します。<br>
     *
     * @param 合議体割当委員情報 {@link GogitaiWariateIinJoho}
     * @return {@link GogitaiJohoBuilder}
     * @throws IllegalStateException キーが一致しない場合
     */
    public GogitaiJohoBuilder setGogitaiWariateIinJoho(GogitaiWariateIinJoho 合議体割当委員情報) {
        if (hasSameIdentifier(合議体割当委員情報.identifier())) {
            gogitaiWariateIinJoho.add(合議体割当委員情報);
            return this;
        }
        throw new IllegalArgumentException(UrErrorMessages.不正.toString());
    }

    private boolean hasSameIdentifier(GogitaiWariateIinJohoIdentifier 合議体割当委員情報識別子) {
        return (id.get合議体番号() == 合議体割当委員情報識別子.get合議体番号())
                && id.get合議体有効期間開始年月日().equals(合議体割当委員情報識別子.get合議体有効期間開始年月日());
    }

    /**
     * 介護認定審査会開催場所情報のキー情報について判定します。<br>
     * 合議体情報に関連できる介護認定審査会開催場所情報である場合、下記の処理に遷移します。<br>
     * キーが一致する場合は介護認定審査会開催場所情報リストに介護認定審査会開催場所情報{@link Todokedesha}をセットします。<br>
     * キーが一致しない場合、新たに追加します。<br>
     *
     * @param 介護認定審査会開催場所情報 {@link Todokedesha}
     * @return Builder
     * @throws IllegalStateException キーが一致しない場合
     */
    public GogitaiJohoBuilder setTodokedesha(ShinsakaiKaisaiBashoJoho 介護認定審査会開催場所情報) {
        if (hasSameIdentifier(介護認定審査会開催場所情報.identifier())) {
            shinsakaiKaisaiBashoJoho.add(介護認定審査会開催場所情報);
            return this;
        }
        throw new IllegalArgumentException(UrErrorMessages.不正.toString());
    }

    private boolean hasSameIdentifier(ShinsakaiKaisaiBashoJohoIdentifier 介護認定審査会開催場所情報識別子) {
        return entity.getShinsakaiKaisaiBashoCode().equals(介護認定審査会開催場所情報識別子.get介護認定審査会開催場所コード());
    }

    /**
     * {@link GogitaiJoho}のインスタンスを生成します。
     *
     * @return {@link GogitaiJoho}のインスタンス
     */
    public GogitaiJoho build() {
        return new GogitaiJoho(entity, id, gogitaiWariateIinJoho, shinsakaiKaisaiBashoJoho);
    }
}
