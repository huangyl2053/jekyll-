/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.core.choshuyuyo;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.choshuyuyo.DbT2006ChoshuYuyoEntity;
import jp.co.ndensan.reams.db.dbz.business.core.uzclasses.Models;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * {@link ChoshuYuyo}の編集を行うビルダークラスです。
 */
public class ChoshuYuyoBuilder {

    private final DbT2006ChoshuYuyoEntity entity;
    private final ChoshuYuyoIdentifier id;
    private final Models<KibetsuChoshuYuyoIdentifier, KibetsuChoshuYuyo> kibetsuChoshuYuyo;

    /**
     * {@link DbT2006ChoshuYuyoEntity}より{@link ChoshuYuyo}の編集用Builderクラスを生成します。
     *
     * @param entity {@link DbT2006ChoshuYuyoEntity}
     * @param id {@link ChoshuYuyoIdentifier}
     * @param seishinTechoNini {@link Models}
     * @param todokedesha {@link Models}
     *
     */
    ChoshuYuyoBuilder(
            DbT2006ChoshuYuyoEntity entity,
            ChoshuYuyoIdentifier id,
            Models<KibetsuChoshuYuyoIdentifier, KibetsuChoshuYuyo> kibetsuChoshuYuyo
    ) {
        this.entity = entity.clone();
        this.id = id;
        this.kibetsuChoshuYuyo = kibetsuChoshuYuyo.clone();

    }

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
     * 徴収猶予種類コードを設定します。
     *
     * @param 徴収猶予種類コード 徴収猶予種類コード
     * @return {@link ChoshuYuyoBuilder}
     */
    public ChoshuYuyoBuilder set徴収猶予種類コード(Code 徴収猶予種類コード) {
        requireNonNull(徴収猶予種類コード, UrSystemErrorMessages.値がnull.getReplacedMessage("徴収猶予種類コード"));
        entity.setYuyoJiyuCode(徴収猶予種類コード);
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
     * 徴収猶予取消種類コードを設定します。
     *
     * @param 徴収猶予取消種類コード 徴収猶予取消種類コード
     * @return {@link ChoshuYuyoBuilder}
     */
    public ChoshuYuyoBuilder set徴収猶予取消種類コード(Code 徴収猶予取消種類コード) {
        requireNonNull(徴収猶予取消種類コード, UrSystemErrorMessages.値がnull.getReplacedMessage("徴収猶予取消種類コード"));
        entity.setYuyoTorikeshiJiyuCode(徴収猶予取消種類コード);
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
     * 介護期別徴収猶予情報のキー情報について判定します。<br>
     * 介護賦課徴収猶予に関連できる介護期別徴収猶予である場合、下記の処理に遷移します。<br>
     * キーが一致する場合は介護期別徴収猶予リストに介護期別徴収猶予{@link KibetsuChoshuYuyo}をセットします。<br>
     * キーが一致しない場合、新たに追加します。<br>
     *
     * @param 介護期別徴収猶予 {@link KibetsuChoshuYuyo}
     * @return {@link ChoshuYuyoBuilder}
     * @throws IllegalStateException キーが一致しない場合
     */
    public ChoshuYuyoBuilder setKibetsuChoshuYuyo(KibetsuChoshuYuyo 介護期別徴収猶予) {
        if (hasSameIdentifier(介護期別徴収猶予.identifier())) {
            kibetsuChoshuYuyo.add(介護期別徴収猶予);
            return this;
        }
        throw new IllegalArgumentException(UrErrorMessages.不正.toString());
    }

    private boolean hasSameIdentifier(KibetsuChoshuYuyoIdentifier 介護期別徴収猶予識別子) {
        return (id.get調定年度().equals(介護期別徴収猶予識別子.get調定年度())
                && id.get賦課年度().equals(介護期別徴収猶予識別子.get調定年度())
                && id.get通知書番号().equals(介護期別徴収猶予識別子.get通知書番号())
                && id.get履歴番号().equals(介護期別徴収猶予識別子.get履歴番号()));
    }

    /**
     * {@link ChoshuYuyo}のインスタンスを生成します。
     *
     * @return {@link ChoshuYuyo}のインスタンス
     */
    public ChoshuYuyo build() {
        return new ChoshuYuyo(entity, id, kibetsuChoshuYuyo);
    }
}
