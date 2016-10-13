/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.core.basic;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT4035FutanGendogakuNinteiBatchEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * {@link FutanyikkatsuShoninList}の編集を行うビルダークラスです。
 */
public class FutanyikkatsuShoninListBuilder {

    private final DbT4035FutanGendogakuNinteiBatchEntity entity;
    private final FutanyikkatsuShoninListIdentifier id;

    /**
     * {@link DbT4035FutanGendogakuNinteiBatchEntity}より{@link FutanyikkatsuShoninList}の編集用Builderクラスを生成します。
     *
     * @param entity {@link DbT4035FutanGendogakuNinteiBatchEntity}
     * @param id {@link FutanyikkatsuShoninListIdentifier}
     *
     */
    FutanyikkatsuShoninListBuilder(
            DbT4035FutanGendogakuNinteiBatchEntity entity,
            FutanyikkatsuShoninListIdentifier id
    ) {
        this.entity = entity.clone();
        this.id = id;

    }

//TODO Key項目のsetterメソッドは削除してください。
//TODO 一緒に置換される値のまとまりで不変なクラスを作成し、その単位でsetterを作る様に見直してください。
    /**
     * Reamsコンフィグから読み取った団体(市町村)コードを設定します。
     *
     * @param Reamsコンフィグから読み取った団体市町村コード RString
     * @return {@link FutanyikkatsuShoninListBuilder}
     */
    public FutanyikkatsuShoninListBuilder setReamsコンフィグから読み取った団体市町村コード(
            RString Reamsコンフィグから読み取った団体市町村コード) {
        requireNonNull(Reamsコンフィグから読み取った団体市町村コード, UrSystemErrorMessages.値がnull.getReplacedMessage("Reamsコンフィグから読み取った団体(市町村)コード")
        );
        entity.setInsertDantaiCd(Reamsコンフィグから読み取った団体市町村コード
        );
        return this;
    }

    /**
     * 論理削除行であればtrueを設定します。
     *
     * @param 論理削除行であればtrue 論理削除行であればtrue
     * @return {@link FutanyikkatsuShoninListBuilder}
     */
    public FutanyikkatsuShoninListBuilder set論理削除行であればtrue(boolean 論理削除行であればtrue) {
        requireNonNull(論理削除行であればtrue, UrSystemErrorMessages.値がnull.getReplacedMessage("論理削除行であればtrue"));
        entity.setIsDeleted(論理削除行であればtrue);
        return this;
    }

    /**
     * 最後にupdateしたReamsログインidを設定します。
     *
     * @param 最後にupdateしたReamsログインid 最後にupdateしたReamsログインid
     * @return {@link FutanyikkatsuShoninListBuilder}
     */
    public FutanyikkatsuShoninListBuilder set最後にupdateしたReamsログインid(RString 最後にupdateしたReamsログインid) {
        requireNonNull(最後にupdateしたReamsログインid, UrSystemErrorMessages.値がnull.getReplacedMessage("最後にupdateしたReamsログインid"));
        entity.setLastUpdateReamsLoginId(最後にupdateしたReamsログインid);
        return this;
    }

    /**
     * 一括認定バッチ処理日時を設定します。
     *
     * @param 一括認定バッチ処理日時 一括認定バッチ処理日時
     * @return {@link FutanyikkatsuShoninListBuilder}
     */
    public FutanyikkatsuShoninListBuilder set一括認定バッチ処理日時(YMDHMS 一括認定バッチ処理日時) {
        requireNonNull(一括認定バッチ処理日時, UrSystemErrorMessages.値がnull.getReplacedMessage("一括認定バッチ処理日時"));
        entity.setNinteiBatchExecutedTimestamp(一括認定バッチ処理日時);
        return this;
    }

    /**
     * 作成年度を設定します。
     *
     * @param 作成年度 作成年度
     * @return {@link FutanyikkatsuShoninListBuilder}
     */
    public FutanyikkatsuShoninListBuilder set作成年度(FlexibleYear 作成年度) {
        requireNonNull(作成年度, UrSystemErrorMessages.値がnull.getReplacedMessage("作成年度"));
        entity.setSakuseiNendo(作成年度);
        return this;
    }

    /**
     * 決定日を設定します。
     *
     * @param 決定日 決定日
     * @return {@link FutanyikkatsuShoninListBuilder}
     */
    public FutanyikkatsuShoninListBuilder set決定日(FlexibleDate 決定日) {
        requireNonNull(決定日, UrSystemErrorMessages.値がnull.getReplacedMessage("決定日"));
        entity.setKetteiYmd(決定日);
        return this;
    }

    /**
     * テスト処理フラグを設定します。
     *
     * @param テスト処理フラグ テスト処理フラグ
     * @return {@link FutanyikkatsuShoninListBuilder}
     */
    public FutanyikkatsuShoninListBuilder setテスト処理フラグ(boolean テスト処理フラグ) {
        requireNonNull(テスト処理フラグ, UrSystemErrorMessages.値がnull.getReplacedMessage("テスト処理フラグ"));
        entity.setIsTest(テスト処理フラグ);
        return this;
    }

    /**
     * 承認済みフラグを設定します。
     *
     * @param 承認済みフラグ 承認済みフラグ
     * @return {@link FutanyikkatsuShoninListBuilder}
     */
    public FutanyikkatsuShoninListBuilder set承認済みフラグ(boolean 承認済みフラグ) {
        requireNonNull(承認済みフラグ, UrSystemErrorMessages.値がnull.getReplacedMessage("承認済みフラグ"));
        entity.setHadApproved(承認済みフラグ);
        return this;
    }

    /**
     * {@link FutanyikkatsuShoninList}のインスタンスを生成します。
     *
     * @return {@link FutanyikkatsuShoninList}のインスタンス
     */
    public FutanyikkatsuShoninList build() {
        return new FutanyikkatsuShoninList(entity, id);
    }
}
