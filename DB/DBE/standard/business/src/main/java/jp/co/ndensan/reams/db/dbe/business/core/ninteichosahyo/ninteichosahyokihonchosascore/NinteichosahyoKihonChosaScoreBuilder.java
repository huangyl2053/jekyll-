/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.ninteichosahyo.ninteichosahyokihonchosascore;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbe.business.core.ninteichosahyo.ninteichosahyokihonchosascoreitem.NinteichosahyoKihonChosaScoreItem;
import jp.co.ndensan.reams.db.dbe.business.core.ninteichosahyo.ninteichosahyokihonchosascoreitem.NinteichosahyoKihonChosaScoreItemIdentifier;
import jp.co.ndensan.reams.uz.uza.util.Models;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5204NinteichosahyoKihonChosaScoreEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;

/**
 * {@link NinteichosahyoKihonChosaScore}の編集を行うビルダークラスです。
 */
public class NinteichosahyoKihonChosaScoreBuilder {

    private final DbT5204NinteichosahyoKihonChosaScoreEntity entity;
    private final NinteichosahyoKihonChosaScoreIdentifier id;
    private final Models<NinteichosahyoKihonChosaScoreItemIdentifier, NinteichosahyoKihonChosaScoreItem> ninteichosahyoKihonChosaScoreItem;

    /**
     * {@link DbT5204NinteichosahyoKihonChosaScoreEntity}より{@link NinteichosahyoKihonChosaScore}の編集用Builderクラスを生成します。
     *
     * @param entity {@link DbT5204NinteichosahyoKihonChosaScoreEntity}
     * @param id {@link NinteichosahyoKihonChosaScoreIdentifier}
     * @param seishinTechoNini {@link Models}
     * @param todokedesha {@link Models}
     *
     */
    NinteichosahyoKihonChosaScoreBuilder(
            DbT5204NinteichosahyoKihonChosaScoreEntity entity,
            NinteichosahyoKihonChosaScoreIdentifier id,
            Models<NinteichosahyoKihonChosaScoreItemIdentifier, NinteichosahyoKihonChosaScoreItem> ninteichosahyoKihonChosaScoreItem
    ) {
        this.entity = entity.clone();
        this.id = id;
        this.ninteichosahyoKihonChosaScoreItem = ninteichosahyoKihonChosaScoreItem.clone();

    }

    /**
     * 厚労省IF識別コードを設定します。
     *
     * @param 厚労省IF識別コード 厚労省IF識別コード
     * @return {@link NinteichosahyoKihonChosaScoreBuilder}
     */
    public NinteichosahyoKihonChosaScoreBuilder set厚労省IF識別コード(Code 厚労省IF識別コード) {
        requireNonNull(厚労省IF識別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("厚労省IF識別コード"));
        entity.setKoroshoIfShikibetsuCode(厚労省IF識別コード);
        return this;
    }

    /**
     * 素点合計　第１郡を設定します。
     *
     * @param 素点合計_第１郡 素点合計_第１郡
     * @return {@link NinteichosahyoKihonChosaScoreBuilder}
     */
    public NinteichosahyoKihonChosaScoreBuilder set素点合計_第１郡(int 素点合計_第１郡) {
        requireNonNull(素点合計_第１郡, UrSystemErrorMessages.値がnull.getReplacedMessage("素点合計　第１郡"));
        entity.setTokutenTotal1gun(素点合計_第１郡);
        return this;
    }

    /**
     * 素点合計　第２郡を設定します。
     *
     * @param 素点合計_第２郡 素点合計_第２郡
     * @return {@link NinteichosahyoKihonChosaScoreBuilder}
     */
    public NinteichosahyoKihonChosaScoreBuilder set素点合計_第２郡(int 素点合計_第２郡) {
        requireNonNull(素点合計_第２郡, UrSystemErrorMessages.値がnull.getReplacedMessage("素点合計　第２郡"));
        entity.setTokutenTotal2gun(素点合計_第２郡);
        return this;
    }

    /**
     * 素点合計　第３郡を設定します。
     *
     * @param 素点合計_第３郡 素点合計_第３郡
     * @return {@link NinteichosahyoKihonChosaScoreBuilder}
     */
    public NinteichosahyoKihonChosaScoreBuilder set素点合計_第３郡(int 素点合計_第３郡) {
        requireNonNull(素点合計_第３郡, UrSystemErrorMessages.値がnull.getReplacedMessage("素点合計　第３郡"));
        entity.setTokutenTotal3gun(素点合計_第３郡);
        return this;
    }

    /**
     * 素点合計　第４郡を設定します。
     *
     * @param 素点合計_第４郡 素点合計_第４郡
     * @return {@link NinteichosahyoKihonChosaScoreBuilder}
     */
    public NinteichosahyoKihonChosaScoreBuilder set素点合計_第４郡(int 素点合計_第４郡) {
        requireNonNull(素点合計_第４郡, UrSystemErrorMessages.値がnull.getReplacedMessage("素点合計　第４郡"));
        entity.setTokutenTotal4gun(素点合計_第４郡);
        return this;
    }

    /**
     * 素点合計　第５郡を設定します。
     *
     * @param 素点合計_第５郡 素点合計_第５郡
     * @return {@link NinteichosahyoKihonChosaScoreBuilder}
     */
    public NinteichosahyoKihonChosaScoreBuilder set素点合計_第５郡(int 素点合計_第５郡) {
        requireNonNull(素点合計_第５郡, UrSystemErrorMessages.値がnull.getReplacedMessage("素点合計　第５郡"));
        entity.setTokutenTotal5gun(素点合計_第５郡);
        return this;
    }

    /**
     * 素点合計　第６郡を設定します。
     *
     * @param 素点合計_第６郡 素点合計_第６郡
     * @return {@link NinteichosahyoKihonChosaScoreBuilder}
     */
    public NinteichosahyoKihonChosaScoreBuilder set素点合計_第６郡(int 素点合計_第６郡) {
        requireNonNull(素点合計_第６郡, UrSystemErrorMessages.値がnull.getReplacedMessage("素点合計　第６郡"));
        entity.setTokutenTotal6gun(素点合計_第６郡);
        return this;
    }

    /**
     * 素点合計　第７郡を設定します。
     *
     * @param 素点合計_第７郡 素点合計_第７郡
     * @return {@link NinteichosahyoKihonChosaScoreBuilder}
     */
    public NinteichosahyoKihonChosaScoreBuilder set素点合計_第７郡(int 素点合計_第７郡) {
        requireNonNull(素点合計_第７郡, UrSystemErrorMessages.値がnull.getReplacedMessage("素点合計　第７郡"));
        entity.setTokutenTotal7gun(素点合計_第７郡);
        return this;
    }

    /**
     * 認定調査票（基本調査素点項目）情報のキー情報について判定します。<br>
     * 認定調査票（基本調査素点）情報に関連できる認定調査票（基本調査素点項目）情報である場合、下記の処理に遷移します。<br>
     * キーが一致する場合は認定調査票（基本調査素点項目）情報リストに認定調査票（基本調査素点項目）情報{@link SeishinTechoNini}をセットします。<br>
     * キーが一致しない場合、新たに追加します。<br>
     *
     * @param 認定調査票_基本調査素点項目情報 {@link NinteichosahyoKihonChosaScoreItem}
     * @return {@link NinteichosahyoKihonChosaScoreBuilder}
     * @throws IllegalStateException キーが一致しない場合
     */
    public NinteichosahyoKihonChosaScoreBuilder setSeishinTechoNini(NinteichosahyoKihonChosaScoreItem 認定調査票_基本調査素点項目情報) {
        if (hasSameIdentifier(認定調査票_基本調査素点項目情報.identifier())) {
            ninteichosahyoKihonChosaScoreItem.add(認定調査票_基本調査素点項目情報);
            return this;
        }
        throw new IllegalArgumentException(UrErrorMessages.不正.toString());
    }

    private boolean hasSameIdentifier(NinteichosahyoKihonChosaScoreItemIdentifier 認定調査票_基本調査素点項目情報識別子) {
        return (id.get申請書管理番号().equals(認定調査票_基本調査素点項目情報識別子.get申請書管理番号())
                && id.get要介護認定調査履歴番号() == 認定調査票_基本調査素点項目情報識別子.get要介護認定調査履歴番号());
    }

    /**
     * {@link NinteichosahyoKihonChosaScore}のインスタンスを生成します。
     *
     * @return {@link NinteichosahyoKihonChosaScore}のインスタンス
     */
    public NinteichosahyoKihonChosaScore build() {
        return new NinteichosahyoKihonChosaScore(entity, id, ninteichosahyoKihonChosaScoreItem);
    }

}
