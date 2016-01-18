/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.core.basic;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.DbT2006ChoshuYuyoEntity;
import jp.co.ndensan.reams.db.dbz.definition.core.valueobject.code.kyotsu.HokenryoChoshuYuyoShurui;
import jp.co.ndensan.reams.db.dbz.definition.core.valueobject.code.kyotsu.HokenryoChoshuYuyoTorikeshiShurui;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * {@link ChoshuYuyo}の編集を行うビルダークラスです。
 */
public class ChoshuYuyoBuilder {

    private final DbT2006ChoshuYuyoEntity entity;
    private final ChoshuYuyoIdentifier id;

    /**
     * {@link DbT2006ChoshuYuyoEntity}より{@link ChoshuYuyo}の編集用Builderクラスを生成します。
     *
     * @param entity {@link DbT2006ChoshuYuyoEntity}
     * @param id {@link ChoshuYuyoIdentifier}
     *
     */
    ChoshuYuyoBuilder(
            DbT2006ChoshuYuyoEntity entity,
            ChoshuYuyoIdentifier id
    ) {
        this.entity = entity.clone();
        this.id = id;

    }

//TODO 一緒に置換される値のまとまりで不変なクラスを作成し、その単位でsetterを作る様に見直してください。
    /**
     * 徴収猶予申請年月日を設定します。
     *
     * @param 徴収猶予申請年月日 徴収猶予申請年月日
     * @return {@link ChoshuYuyoBuilder}
     */
    public ChoshuYuyoBuilder set徴収猶予申請年月日(FlexibleDate 徴収猶予申請年月日) {
        requireNonNull(徴収猶予申請年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("徴収猶予申請年月日"));
        entity.setShinseiYMD(徴収猶予申請年月日);
        return this;
    }

    /**
     * 徴収猶予決定年月日を設定します。
     *
     * @param 徴収猶予決定年月日 徴収猶予決定年月日
     * @return {@link ChoshuYuyoBuilder}
     */
    public ChoshuYuyoBuilder set徴収猶予決定年月日(FlexibleDate 徴収猶予決定年月日) {
        requireNonNull(徴収猶予決定年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("徴収猶予決定年月日"));
        entity.setKetteiYMD(徴収猶予決定年月日);
        return this;
    }

    /**
     * 徴収猶予取消年月日を設定します。
     *
     * @param 徴収猶予取消年月日 徴収猶予取消年月日
     * @return {@link ChoshuYuyoBuilder}
     */
    public ChoshuYuyoBuilder set徴収猶予取消年月日(FlexibleDate 徴収猶予取消年月日) {
        requireNonNull(徴収猶予取消年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("徴収猶予取消年月日"));
        entity.setTorikeshiYMD(徴収猶予取消年月日);
        return this;
    }

    /**
     * 徴収猶予状態区分を設定します。
     *
     * @param 徴収猶予状態区分 徴収猶予状態区分
     * @return {@link ChoshuYuyoBuilder}
     */
    public ChoshuYuyoBuilder set徴収猶予状態区分(RString 徴収猶予状態区分) {
        requireNonNull(徴収猶予状態区分, UrSystemErrorMessages.値がnull.getReplacedMessage("徴収猶予状態区分"));
        entity.setJotaiKubun(徴収猶予状態区分);
        return this;
    }

    /**
     * 徴収猶予作成区分を設定します。
     *
     * @param 徴収猶予作成区分 徴収猶予作成区分
     * @return {@link ChoshuYuyoBuilder}
     */
    public ChoshuYuyoBuilder set徴収猶予作成区分(RString 徴収猶予作成区分) {
        requireNonNull(徴収猶予作成区分, UrSystemErrorMessages.値がnull.getReplacedMessage("徴収猶予作成区分"));
        entity.setSakuseiKubun(徴収猶予作成区分);
        return this;
    }

    /**
     * 申請事由を設定します。
     *
     * @param 申請事由 申請事由
     * @return {@link ChoshuYuyoBuilder}
     */
    public ChoshuYuyoBuilder set申請事由(RString 申請事由) {
        requireNonNull(申請事由, UrSystemErrorMessages.値がnull.getReplacedMessage("申請事由"));
        entity.setShinseiJiyu(申請事由);
        return this;
    }

    /**
     * 徴収猶予種類を設定します。
     *
     * @param 徴収猶予種類 徴収猶予種類
     * @return {@link ChoshuYuyoBuilder}
     */
    public ChoshuYuyoBuilder set徴収猶予種類(HokenryoChoshuYuyoShurui 徴収猶予種類) {
        requireNonNull(徴収猶予種類, UrSystemErrorMessages.値がnull.getReplacedMessage("徴収猶予種類"));
        entity.setYuyoJiyuCode(徴収猶予種類.value());
        return this;
    }

    /**
     * 徴収猶予事由を設定します。
     *
     * @param 徴収猶予事由 徴収猶予事由
     * @return {@link ChoshuYuyoBuilder}
     */
    public ChoshuYuyoBuilder set徴収猶予事由(RString 徴収猶予事由) {
        requireNonNull(徴収猶予事由, UrSystemErrorMessages.値がnull.getReplacedMessage("徴収猶予事由"));
        entity.setYuyoJiyu(徴収猶予事由);
        return this;
    }

    /**
     * 徴収猶予取消種類を設定します。
     *
     * @param 徴収猶予取消種類 徴収猶予取消種類
     * @return {@link ChoshuYuyoBuilder}
     */
    public ChoshuYuyoBuilder set徴収猶予取消種類(HokenryoChoshuYuyoTorikeshiShurui 徴収猶予取消種類) {
        requireNonNull(徴収猶予取消種類, UrSystemErrorMessages.値がnull.getReplacedMessage("徴収猶予取消種類"));
        entity.setYuyoTorikeshiJiyuCode(徴収猶予取消種類.value());
        return this;
    }

    /**
     * 徴収猶予取消事由を設定します。
     *
     * @param 徴収猶予取消事由 徴収猶予取消事由
     * @return {@link ChoshuYuyoBuilder}
     */
    public ChoshuYuyoBuilder set徴収猶予取消事由(RString 徴収猶予取消事由) {
        requireNonNull(徴収猶予取消事由, UrSystemErrorMessages.値がnull.getReplacedMessage("徴収猶予取消事由"));
        entity.setYuyoTorikeshiJiyu(徴収猶予取消事由);
        return this;
    }

    /**
     * {@link ChoshuYuyo}のインスタンスを生成します。
     *
     * @return {@link ChoshuYuyo}のインスタンス
     */
    public ChoshuYuyo build() {
        return new ChoshuYuyo(entity, id);
    }

    public ChoshuYuyoBuilder setKibetsuChoshuYuyo(KibetsuChoshuYuyo createKibetsuChoshuYuyo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
