/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.core.basic;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.DbT2004GemmenEntity;
import jp.co.ndensan.reams.db.dbz.definition.core.valueobject.code.kyotsu.HokenryoGemmenShurui;
import jp.co.ndensan.reams.db.dbz.definition.core.valueobject.code.kyotsu.HokenryoGemmenTorikeshiShurui;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * {@link Gemmen}の編集を行うビルダークラスです。
 */
public class GemmenBuilder {

    private final DbT2004GemmenEntity entity;
    private final GemmenIdentifier id;

    /**
     * {@link DbT2004GemmenEntity}より{@link Gemmen}の編集用Builderクラスを生成します。
     *
     * @param entity {@link DbT2004GemmenEntity}
     * @param id {@link GemmenIdentifier}
     *
     */
    GemmenBuilder(
            DbT2004GemmenEntity entity,
            GemmenIdentifier id
    ) {
        this.entity = entity.clone();
        this.id = id;

    }

//TODO 一緒に置換される値のまとまりで不変なクラスを作成し、その単位でsetterを作る様に見直してください。
    /**
     * 減免申請日を設定します。
     *
     * @param 減免申請日 減免申請日
     * @return {@link GemmenBuilder}
     */
    public GemmenBuilder set減免申請日(FlexibleDate 減免申請日) {
        requireNonNull(減免申請日, UrSystemErrorMessages.値がnull.getReplacedMessage("減免申請日"));
        entity.setShinseiYMD(減免申請日);
        return this;
    }

    /**
     * 減免決定日を設定します。
     *
     * @param 減免決定日 減免決定日
     * @return {@link GemmenBuilder}
     */
    public GemmenBuilder set減免決定日(FlexibleDate 減免決定日) {
        requireNonNull(減免決定日, UrSystemErrorMessages.値がnull.getReplacedMessage("減免決定日"));
        entity.setKetteiYMD(減免決定日);
        return this;
    }

    /**
     * 減免取消日を設定します。
     *
     * @param 減免取消日 減免取消日
     * @return {@link GemmenBuilder}
     */
    public GemmenBuilder set減免取消日(FlexibleDate 減免取消日) {
        requireNonNull(減免取消日, UrSystemErrorMessages.値がnull.getReplacedMessage("減免取消日"));
        entity.setTorikeshiYMD(減免取消日);
        return this;
    }

    /**
     * 減免状態区分を設定します。
     *
     * @param 減免状態区分 減免状態区分
     * @return {@link GemmenBuilder}
     */
    public GemmenBuilder set減免状態区分(RString 減免状態区分) {
        requireNonNull(減免状態区分, UrSystemErrorMessages.値がnull.getReplacedMessage("減免状態区分"));
        entity.setJotaiKubun(減免状態区分);
        return this;
    }

    /**
     * 減免作成区分を設定します。
     *
     * @param 減免作成区分 減免作成区分
     * @return {@link GemmenBuilder}
     */
    public GemmenBuilder set減免作成区分(RString 減免作成区分) {
        requireNonNull(減免作成区分, UrSystemErrorMessages.値がnull.getReplacedMessage("減免作成区分"));
        entity.setSakuseiKubun(減免作成区分);
        return this;
    }

    /**
     * 申請事由を設定します。
     *
     * @param 申請事由 申請事由
     * @return {@link GemmenBuilder}
     */
    public GemmenBuilder set申請事由(RString 申請事由) {
        requireNonNull(申請事由, UrSystemErrorMessages.値がnull.getReplacedMessage("申請事由"));
        entity.setShinseiJiyu(申請事由);
        return this;
    }

    /**
     * 減免種類を設定します。
     *
     * @param 減免種類 減免種類
     * @return {@link GemmenBuilder}
     */
    public GemmenBuilder set減免種類(HokenryoGemmenShurui 減免種類) {
        requireNonNull(減免種類, UrSystemErrorMessages.値がnull.getReplacedMessage("減免種類"));
        entity.setGemmenJiyuCode(減免種類.value());
        return this;
    }

    /**
     * 減免事由を設定します。
     *
     * @param 減免事由 減免事由
     * @return {@link GemmenBuilder}
     */
    public GemmenBuilder set減免事由(RString 減免事由) {
        requireNonNull(減免事由, UrSystemErrorMessages.値がnull.getReplacedMessage("減免事由"));
        entity.setGemmenJiyu(減免事由);
        return this;
    }

    /**
     * 減免取消種類を設定します。
     *
     * @param 減免取消種類 減免取消種類
     * @return {@link GemmenBuilder}
     */
    public GemmenBuilder set減免取消種類(HokenryoGemmenTorikeshiShurui 減免取消種類) {
        requireNonNull(減免取消種類, UrSystemErrorMessages.値がnull.getReplacedMessage("減免取消種類"));
        entity.setGemmenTorikeshiJiyuCode(減免取消種類.value());
        return this;
    }

    /**
     * 減免取消事由を設定します。
     *
     * @param 減免取消事由 減免取消事由
     * @return {@link GemmenBuilder}
     */
    public GemmenBuilder set減免取消事由(RString 減免取消事由) {
        requireNonNull(減免取消事由, UrSystemErrorMessages.値がnull.getReplacedMessage("減免取消事由"));
        entity.setGemmenTorikeshiJiyu(減免取消事由);
        return this;
    }

    /**
     * 減免種類コードを設定します。
     *
     * @param 減免種類コード 減免種類コード
     * @return {@link GemmenBuilder}
     */
    public GemmenBuilder set減免種類コード(Code 減免種類コード) {
        requireNonNull(減免種類コード, UrSystemErrorMessages.値がnull.getReplacedMessage("減免種類コード"));
        entity.setGemmenJiyuCode(減免種類コード);
        return this;
    }

    /**
     * 申請減免額を設定します。
     *
     * @param 申請減免額 申請減免額
     * @return {@link GemmenBuilder}
     */
    public GemmenBuilder set申請減免額(Decimal 申請減免額) {
        requireNonNull(申請減免額, UrSystemErrorMessages.値がnull.getReplacedMessage("申請減免額"));
        entity.setShinseiGemmenGaku(申請減免額);
        return this;
    }

    /**
     * 決定減免額を設定します。
     *
     * @param 決定減免額 決定減免額
     * @return {@link GemmenBuilder}
     */
    public GemmenBuilder set決定減免額(Decimal 決定減免額) {
        requireNonNull(決定減免額, UrSystemErrorMessages.値がnull.getReplacedMessage("決定減免額"));
        entity.setKetteiGemmenGaku(決定減免額);
        return this;
    }

    /**
     * 取消減免額を設定します。
     *
     * @param 取消減免額 取消減免額
     * @return {@link GemmenBuilder}
     */
    public GemmenBuilder set取消減免額(Decimal 取消減免額) {
        requireNonNull(取消減免額, UrSystemErrorMessages.値がnull.getReplacedMessage("取消減免額"));
        entity.setTorikeshiGemmenGaku(取消減免額);
        return this;
    }

    /**
     * {@link Gemmen}のインスタンスを生成します。
     *
     * @return {@link Gemmen}のインスタンス
     */
    public Gemmen build() {
        return new Gemmen(entity, id);
    }
}
