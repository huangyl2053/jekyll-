/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.core.basic;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.fukaerr.DbT2010FukaErrorListEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.TsuchishoNo;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * {@link FukaErrorList}の編集を行うビルダークラスです。
 */
public class FukaErrorListBuilder {

    private final DbT2010FukaErrorListEntity entity;
    private final FukaErrorListIdentifier id;

    /**
     * {@link DbT2010FukaErrorListEntity}より{@link FukaErrorList}の編集用Builderクラスを生成します。
     *
     * @param entity {@link DbT2010FukaErrorListEntity}
     * @param id {@link FukaErrorListIdentifier}
     *
     */
    FukaErrorListBuilder(
            DbT2010FukaErrorListEntity entity,
            FukaErrorListIdentifier id
    ) {
        this.entity = entity.clone();
        this.id = id;

    }

//TODO Key項目のsetterメソッドは削除してください。
//TODO 一緒に置換される値のまとまりで不変なクラスを作成し、その単位でsetterを作る様に見直してください。
    /**
     * サブ業務コードを設定します。
     *
     * @param サブ業務コード サブ業務コード
     * @return {@link FukaErrorListBuilder}
     */
    public FukaErrorListBuilder setサブ業務コード(SubGyomuCode サブ業務コード) {
        requireNonNull(サブ業務コード, UrSystemErrorMessages.値がnull.getReplacedMessage("サブ業務コード"));
        entity.setSubGyomuCode(サブ業務コード);
        return this;
    }

    /**
     * 内部帳票IDを設定します。
     *
     * @param 内部帳票ID 内部帳票ID
     * @return {@link FukaErrorListBuilder}
     */
    public FukaErrorListBuilder set内部帳票ID(RString 内部帳票ID) {
        requireNonNull(内部帳票ID, UrSystemErrorMessages.値がnull.getReplacedMessage("内部帳票ID"));
        entity.setInternalReportId(内部帳票ID);
        return this;
    }

    /**
     * 賦課年度を設定します。
     *
     * @param 賦課年度 賦課年度
     * @return {@link FukaErrorListBuilder}
     */
    public FukaErrorListBuilder set賦課年度(FlexibleYear 賦課年度) {
        requireNonNull(賦課年度, UrSystemErrorMessages.値がnull.getReplacedMessage("賦課年度"));
        entity.setFukaNendo(賦課年度);
        return this;
    }

    /**
     * 通知書番号を設定します。
     *
     * @param 通知書番号 通知書番号
     * @return {@link FukaErrorListBuilder}
     */
    public FukaErrorListBuilder set通知書番号(TsuchishoNo 通知書番号) {
        requireNonNull(通知書番号, UrSystemErrorMessages.値がnull.getReplacedMessage("通知書番号"));
        entity.setTsuchishoNo(通知書番号);
        return this;
    }

    /**
     * 内部帳票作成日時を設定します。
     *
     * @param 内部帳票作成日時 内部帳票作成日時
     * @return {@link FukaErrorListBuilder}
     */
    public FukaErrorListBuilder set内部帳票作成日時(RDateTime 内部帳票作成日時) {
        requireNonNull(内部帳票作成日時, UrSystemErrorMessages.値がnull.getReplacedMessage("内部帳票作成日時"));
        entity.setInternalReportCreationDateTime(内部帳票作成日時);
        return this;
    }

    /**
     * バッチIDを設定します。
     *
     * @param バッチID バッチID
     * @return {@link FukaErrorListBuilder}
     */
    public FukaErrorListBuilder setバッチID(RString バッチID) {
        requireNonNull(バッチID, UrSystemErrorMessages.値がnull.getReplacedMessage("バッチID"));
        entity.setBatchId(バッチID);
        return this;
    }

    /**
     * バッチ起動日時を設定します。
     *
     * @param バッチ起動日時 バッチ起動日時
     * @return {@link FukaErrorListBuilder}
     */
    public FukaErrorListBuilder setバッチ起動日時(RDateTime バッチ起動日時) {
        requireNonNull(バッチ起動日時, UrSystemErrorMessages.値がnull.getReplacedMessage("バッチ起動日時"));
        entity.setBatchStartingDateTime(バッチ起動日時);
        return this;
    }

    /**
     * エラーコードを設定します。
     *
     * @param エラーコード エラーコード
     * @return {@link FukaErrorListBuilder}
     */
    public FukaErrorListBuilder setエラーコード(Code エラーコード) {
        requireNonNull(エラーコード, UrSystemErrorMessages.値がnull.getReplacedMessage("エラーコード"));
        entity.setErrorCode(エラーコード);
        return this;
    }

    /**
     * 被保険者番号を設定します。
     *
     * @param 被保険者番号 被保険者番号
     * @return {@link FukaErrorListBuilder}
     */
    public FukaErrorListBuilder set被保険者番号(HihokenshaNo 被保険者番号) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        entity.setHihokenshaNo(被保険者番号);
        return this;
    }

    /**
     * 識別コードを設定します。
     *
     * @param 識別コード 識別コード
     * @return {@link FukaErrorListBuilder}
     */
    public FukaErrorListBuilder set識別コード(ShikibetsuCode 識別コード) {
        requireNonNull(識別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("識別コード"));
        entity.setShikibetsuCode(識別コード);
        return this;
    }

    /**
     * 処理区分コードを設定します。
     *
     * @param 処理区分コード 処理区分コード
     * @return {@link FukaErrorListBuilder}
     */
    public FukaErrorListBuilder set処理区分コード(Code 処理区分コード) {
        requireNonNull(処理区分コード, UrSystemErrorMessages.値がnull.getReplacedMessage("処理区分コード"));
        entity.setShoriKubunCode(処理区分コード);
        return this;
    }

    /**
     * {@link FukaErrorList}のインスタンスを生成します。
     *
     * @return {@link FukaErrorList}のインスタンス
     */
    public FukaErrorList build() {
        return new FukaErrorList(entity, id);
    }
}
