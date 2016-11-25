/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.business.core.basic;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT2013HokenryoDankaiEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * {@link HokenryoDankai}の編集を行うビルダークラスです。
 */
public class HokenryoDankaiBuilder {

    private final DbT2013HokenryoDankaiEntity entity;
    private final HokenryoDankaiIdentifier id;

    /**
     * {@link DbT2013HokenryoDankaiEntity}より{@link HokenryoDankai}の編集用Builderクラスを生成します。
     *
     * @param entity {@link DbT2013HokenryoDankaiEntity}
     * @param id {@link HokenryoDankaiIdentifier}
     *
     */
    HokenryoDankaiBuilder(
            DbT2013HokenryoDankaiEntity entity,
            HokenryoDankaiIdentifier id
    ) {
        this.entity = entity.clone();
        this.id = id;

    }

//TODO Key項目のsetterメソッドは削除してください。
//TODO 一緒に置換される値のまとまりで不変なクラスを作成し、その単位でsetterを作る様に見直してください。
    /**
     * 賦課年度を設定します。
     *
     * @param 賦課年度 賦課年度
     * @return {@link HokenryoDankaiBuilder}
     */
    public HokenryoDankaiBuilder set賦課年度(FlexibleYear 賦課年度) {
        requireNonNull(賦課年度, UrSystemErrorMessages.値がnull.getReplacedMessage("賦課年度"));
        entity.setFukaNendo(賦課年度);
        return this;
    }

    /**
     * 段階インデックスを設定します。
     *
     * @param 段階インデックス 段階インデックス
     * @return {@link HokenryoDankaiBuilder}
     */
    public HokenryoDankaiBuilder set段階インデックス(RString 段階インデックス) {
        requireNonNull(段階インデックス, UrSystemErrorMessages.値がnull.getReplacedMessage("段階インデックス"));
        entity.setDankaiIndex(段階インデックス);
        return this;
    }

    /**
     * ランク区分を設定します。
     *
     * @param ランク区分 ランク区分
     * @return {@link HokenryoDankaiBuilder}
     */
    public HokenryoDankaiBuilder setランク区分(RString ランク区分) {
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
    public HokenryoDankaiBuilder set段階区分(RString 段階区分) {
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
    public HokenryoDankaiBuilder set保険料率(Decimal 保険料率) {
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
    public HokenryoDankaiBuilder set特例表記(RString 特例表記) {
        requireNonNull(特例表記, UrSystemErrorMessages.値がnull.getReplacedMessage("特例表記"));
        entity.setTokureiHyoki(特例表記);
        return this;
    }

    /**
     * {@link HokenryoDankai}のインスタンスを生成します。
     *
     * @return {@link HokenryoDankai}のインスタンス
     */
    public HokenryoDankai build() {
        return new HokenryoDankai(entity, id);
    }
}
