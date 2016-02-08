/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.ninteichosahyo.ninteichosahyokihonchosa;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbe.business.core.ninteichosahyo.ninteichosahyochosaitem.NinteichosahyoChosaItem;
import jp.co.ndensan.reams.db.dbe.business.core.ninteichosahyo.ninteichosahyochosaitem.NinteichosahyoChosaItemIdentifier;
import jp.co.ndensan.reams.db.dbe.business.core.ninteichosahyo.ninteichosahyokihonchosascore.NinteichosahyoKihonChosaScore;
import jp.co.ndensan.reams.db.dbe.business.core.ninteichosahyo.ninteichosahyokihonchosascore.NinteichosahyoKihonChosaScoreIdentifier;
import jp.co.ndensan.reams.uz.uza.util.Models;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5203NinteichosahyoKihonChosaEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;

/**
 * {@link NinteichosahyoKihonChosa}の編集を行うビルダークラスです。
 */
public class NinteichosahyoKihonChosaBuilder {

    private final DbT5203NinteichosahyoKihonChosaEntity entity;
    private final NinteichosahyoKihonChosaIdentifier id;
    private final Models<NinteichosahyoChosaItemIdentifier, NinteichosahyoChosaItem> ninteichosahyoChosaItem;
    private final Models<NinteichosahyoKihonChosaScoreIdentifier, NinteichosahyoKihonChosaScore> ninteichosahyoKihonChosaScore;

    /**
     * {@link DbT5203NinteichosahyoKihonChosaEntity}より{@link NinteichosahyoKihonChosa}の編集用Builderクラスを生成します。
     *
     * @param entity {@link DbT5203NinteichosahyoKihonChosaEntity}
     * @param id {@link NinteichosahyoKihonChosaIdentifier}
     * @param ninteichosahyoChosaItem {@link Models}
     * @param ninteichosahyoKihonChosaScore {@link Models}
     *
     */
    NinteichosahyoKihonChosaBuilder(
            DbT5203NinteichosahyoKihonChosaEntity entity,
            NinteichosahyoKihonChosaIdentifier id,
            Models<NinteichosahyoChosaItemIdentifier, NinteichosahyoChosaItem> ninteichosahyoChosaItem,
            Models<NinteichosahyoKihonChosaScoreIdentifier, NinteichosahyoKihonChosaScore> ninteichosahyoKihonChosaScore
    ) {
        this.entity = entity.clone();
        this.id = id;
        this.ninteichosahyoChosaItem = ninteichosahyoChosaItem.clone();
        this.ninteichosahyoKihonChosaScore = ninteichosahyoKihonChosaScore.clone();

    }

    /**
     * 厚労省IF識別コードを設定します。
     *
     * @param 厚労省IF識別コード 厚労省IF識別コード
     * @return {@link NinteichosahyoKihonChosaBuilder}
     */
    public NinteichosahyoKihonChosaBuilder set厚労省IF識別コード(Code 厚労省IF識別コード) {
        requireNonNull(厚労省IF識別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("厚労省IF識別コード"));
        entity.setKoroshoIfShikibetsuCode(厚労省IF識別コード);
        return this;
    }

    /**
     * 認定調査・認知症高齢者の日常生活自立度コードを設定します。
     *
     * @param 認定調査_認知症高齢者の日常生活自立度コード 認定調査_認知症高齢者の日常生活自立度コード
     * @return {@link NinteichosahyoKihonChosaBuilder}
     */
    public NinteichosahyoKihonChosaBuilder set認定調査_認知症高齢者の日常生活自立度コード(Code 認定調査_認知症高齢者の日常生活自立度コード) {
        requireNonNull(認定調査_認知症高齢者の日常生活自立度コード, UrSystemErrorMessages.値がnull.getReplacedMessage("認定調査・認知症高齢者の日常生活自立度コード"));
        entity.setNinchishoNichijoSeikatsuJiritsudoCode(認定調査_認知症高齢者の日常生活自立度コード);
        return this;
    }

    /**
     * 認定調査・障害高齢者の日常生活自立度コードを設定します。
     *
     * @param 認定調査_障害高齢者の日常生活自立度コード 認定調査_障害高齢者の日常生活自立度コード
     * @return {@link NinteichosahyoKihonChosaBuilder}
     */
    public NinteichosahyoKihonChosaBuilder set認定調査_障害高齢者の日常生活自立度コード(Code 認定調査_障害高齢者の日常生活自立度コード) {
        requireNonNull(認定調査_障害高齢者の日常生活自立度コード, UrSystemErrorMessages.値がnull.getReplacedMessage("認定調査・障害高齢者の日常生活自立度コード"));
        entity.setShogaiNichijoSeikatsuJiritsudoCode(認定調査_障害高齢者の日常生活自立度コード);
        return this;
    }

    /**
     * 認定調査票_基本調査素点_項目情報のキー情報について判定します。<br>
     * 認定調査票_基本調査_情報に関連できる認定調査票_基本調査素点_項目情報である場合、下記の処理に遷移します。<br>
     * キーが一致する場合は認定調査票_基本調査素点_項目情報リストに認定調査票_基本調査素点_項目情報{@link NinteichosahyoKihonChosaScore}をセットします。<br>
     * キーが一致しない場合、新たに追加します。<br>
     *
     * @param 認定調査票_基本調査素点_項目情報 {@link NinteichosahyoKihonChosaScore}
     * @return {@link NinteichosahyoKihonChosaBuilder}
     * @throws IllegalStateException キーが一致しない場合
     */
    public NinteichosahyoKihonChosaBuilder setNinteichosahyoKihonChosaScore(NinteichosahyoKihonChosaScore 認定調査票_基本調査素点_項目情報) {
        if (hasSameIdentifier(認定調査票_基本調査素点_項目情報.identifier())) {
            ninteichosahyoKihonChosaScore.add(認定調査票_基本調査素点_項目情報);
            return this;
        }
        throw new IllegalArgumentException(UrErrorMessages.不正.toString());
    }

    private boolean hasSameIdentifier(NinteichosahyoKihonChosaScoreIdentifier 認定調査票_基本調査素点_項目情報識別子) {
        return (id.get申請書管理番号().equals(認定調査票_基本調査素点_項目情報識別子.get申請書管理番号())
                && id.get要介護認定調査履歴番号() == 認定調査票_基本調査素点_項目情報識別子.get要介護認定調査履歴番号());
    }

    /**
     * 認定調査票_基本調査_調査項目情報のキー情報について判定します。<br>
     * 認定調査票_基本調査_情報に関連できる認定調査票_基本調査_調査項目情報である場合、下記の処理に遷移します。<br>
     * キーが一致する場合は認定調査票_基本調査_調査項目情報リストに認定調査票_基本調査_調査項目情報{@link NinteichosahyoChosaItem}をセットします。<br>
     * キーが一致しない場合、新たに追加します。<br>
     *
     * @param 認定調査票_基本調査_調査項目情報 {@link NinteichosahyoChosaItem}
     * @return {@link NinteichosahyoKihonChosaBuilder}
     * @throws IllegalStateException キーが一致しない場合
     */
    public NinteichosahyoKihonChosaBuilder setTodokedesha(NinteichosahyoChosaItem 認定調査票_基本調査_調査項目情報) {
        if (hasSameIdentifier(認定調査票_基本調査_調査項目情報.identifier())) {
            ninteichosahyoChosaItem.add(認定調査票_基本調査_調査項目情報);
            return this;
        }
        throw new IllegalArgumentException(UrErrorMessages.不正.toString());
    }

    private boolean hasSameIdentifier(NinteichosahyoChosaItemIdentifier 認定調査票_基本調査_調査項目情報識別子) {
        return (id.get申請書管理番号().equals(認定調査票_基本調査_調査項目情報識別子.get申請書管理番号())
                && id.get要介護認定調査履歴番号() == 認定調査票_基本調査_調査項目情報識別子.get要介護認定調査履歴番号());
    }

    /**
     * {@link NinteichosahyoKihonChosa}のインスタンスを生成します。
     *
     * @return {@link NinteichosahyoKihonChosa}のインスタンス
     */
    public NinteichosahyoKihonChosa build() {
        return new NinteichosahyoKihonChosa(entity, id, ninteichosahyoChosaItem, ninteichosahyoKihonChosaScore);
    }
}
