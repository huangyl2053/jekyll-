/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.core.basic;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.choshuyuyo.DbT2006ChoshuYuyoEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.TsuchishoNo;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

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

//TODO Key項目のsetterメソッドは削除してください。
//TODO 一緒に置換される値のまとまりで不変なクラスを作成し、その単位でsetterを作る様に見直してください。
    /**
     * 調定年度を設定します。
     *
     * @param 調定年度 調定年度
     * @return {@link ChoshuYuyoBuilder}
     */
    public ChoshuYuyoBuilder set調定年度(FlexibleYear 調定年度) {
        requireNonNull(調定年度, UrSystemErrorMessages.値がnull.getReplacedMessage("調定年度"));
        entity.setChoteiNendo(調定年度);
        return this;
    }

    /**
     * 賦課年度を設定します。
     *
     * @param 賦課年度 賦課年度
     * @return {@link ChoshuYuyoBuilder}
     */
    public ChoshuYuyoBuilder set賦課年度(FlexibleYear 賦課年度) {
        requireNonNull(賦課年度, UrSystemErrorMessages.値がnull.getReplacedMessage("賦課年度"));
        entity.setFukaNendo(賦課年度);
        return this;
    }

    /**
     * 通知書番号を設定します。
     *
     * @param 通知書番号 通知書番号
     * @return {@link ChoshuYuyoBuilder}
     */
    public ChoshuYuyoBuilder set通知書番号(TsuchishoNo 通知書番号) {
        requireNonNull(通知書番号, UrSystemErrorMessages.値がnull.getReplacedMessage("通知書番号"));
        entity.setTsuchishoNo(通知書番号);
        return this;
    }

    /**
     * 履歴番号を設定します。
     *
     * @param 履歴番号 履歴番号
     * @return {@link ChoshuYuyoBuilder}
     */
    public ChoshuYuyoBuilder set履歴番号(Decimal 履歴番号) {
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));
        entity.setRirekiNo(履歴番号);
        return this;
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
