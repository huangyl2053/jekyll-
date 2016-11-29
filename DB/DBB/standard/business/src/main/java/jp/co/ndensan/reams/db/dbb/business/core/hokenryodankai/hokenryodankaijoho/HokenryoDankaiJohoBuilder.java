/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.core.hokenryodankai.hokenryodankaijoho;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbb.business.core.hokenryodankai.rankjoho.RankJoho;
import jp.co.ndensan.reams.db.dbb.business.core.hokenryodankai.rankjoho.RankJohoIdentifier;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT2013HokenryoDankaiEntity;
import jp.co.ndensan.reams.db.dbz.business.core.uzclasses.Models;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * {@link HokenryoDankaiJoho}の編集を行うビルダークラスです。
 *
 * @reamsid_L DBB-9999-013 huangh
 */
public class HokenryoDankaiJohoBuilder {

    private final DbT2013HokenryoDankaiEntity entity;
    private final HokenryoDankaiJohoIdentifier id;
    private final jp.co.ndensan.reams.uz.uza.util.Models<RankJohoIdentifier, RankJoho> rankJoho;

    /**
     * {@link DbT2013HokenryoDankaiEntity}より{@link HokenryoDankaiJoho}の編集用Builderクラスを生成します。
     *
     * @param entity {@link DbT2013HokenryoDankaiEntity}
     * @param id {@link HokenryoDankaiJohoIdentifier}
     * @param seishinTechoNini {@link Models}
     * @param todokedesha {@link Models}
     *
     */
    HokenryoDankaiJohoBuilder(
            DbT2013HokenryoDankaiEntity entity,
            HokenryoDankaiJohoIdentifier id,
            jp.co.ndensan.reams.uz.uza.util.Models<RankJohoIdentifier, RankJoho> rankJoho
    ) {
        this.entity = entity.clone();
        this.id = id;
        this.rankJoho = rankJoho.clone();

    }

    /**
     * ランク区分を設定します。
     *
     * @param ランク区分 ランク区分
     * @return {@link HokenryoDankaiBuilder}
     */
    public HokenryoDankaiJohoBuilder setランク区分(RString ランク区分) {
        requireNonNull(ランク区分, UrSystemErrorMessages.値がnull.getReplacedMessage("ランク区分"));
        entity.setRankuKubun(ランク区分);
        return this;
    }

    /**
     * 段階区分を設定します。
     *
     * @param 段階区分 段階区分
     * @return {@link HokenryoDankaiBuilder}
     */
    public HokenryoDankaiJohoBuilder set段階区分(RString 段階区分) {
        requireNonNull(段階区分, UrSystemErrorMessages.値がnull.getReplacedMessage("段階区分"));
        entity.setDankaiKubun(段階区分);
        return this;
    }

    /**
     * 保険料率を設定します。
     *
     * @param 保険料率 保険料率
     * @return {@link HokenryoDankaiBuilder}
     */
    public HokenryoDankaiJohoBuilder set保険料率(Decimal 保険料率) {
        requireNonNull(保険料率, UrSystemErrorMessages.値がnull.getReplacedMessage("保険料率"));
        entity.setHokenryoRitsu(保険料率);
        return this;
    }

    /**
     * 特例表記を設定します。
     *
     * @param 特例表記 特例表記
     * @return {@link HokenryoDankaiBuilder}
     */
    public HokenryoDankaiJohoBuilder set特例表記(RString 特例表記) {
        requireNonNull(特例表記, UrSystemErrorMessages.値がnull.getReplacedMessage("特例表記"));
        entity.setTokureiHyoki(特例表記);
        return this;
    }

    /**
     * 精神手帳任意項目情報のキー情報について判定します。<br>
     * 精神手帳情報に関連できるランク情報である場合、下記の処理に遷移します。<br>
     * キーが一致する場合はランク情報リストにランク情報情報{@link RankJoho}をセットします。<br>
     * キーが一致しない場合、新たに追加します。<br>
     *
     * @param ランク情報 {@link RankJoho}
     * @return {@link HokenryoDankaiJohoBuilder}
     * @throws IllegalStateException キーが一致しない場合
     */
    public HokenryoDankaiJohoBuilder setRankJoho(RankJoho ランク情報) {
        if (hasSameIdentifier(ランク情報.identifier())) {
            rankJoho.add(ランク情報);
            return this;
        }
        throw new IllegalArgumentException(UrErrorMessages.不正.toString());
    }

    private boolean hasSameIdentifier(RankJohoIdentifier ランク情報識別子) {
        return (id.get賦課年度().equals(ランク情報識別子.get賦課年度())
                && id.getランク区分() == ランク情報識別子.getランク区分());
    }

    /**
     * {@link HokenryoDankaiJoho}のインスタンスを生成します。
     *
     * @return {@link HokenryoDankaiJoho}のインスタンス
     */
    public HokenryoDankaiJoho build() {
        return new HokenryoDankaiJoho(entity, id, rankJoho);
    }
}
