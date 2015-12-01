/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.business.core.uzclasses.ParentModelBase;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5221NinteichosaScheduleEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 認定調査スケジュール情報を管理するクラスです。
 */
public class NinteichosaSchedule extends
        ParentModelBase<NinteichosaScheduleIdentifier, DbT5221NinteichosaScheduleEntity, NinteichosaSchedule> implements Serializable {

    private final DbT5221NinteichosaScheduleEntity entity;
    private final NinteichosaScheduleIdentifier id;

    /**
     * コンストラクタです。<br/>
     * 認定調査スケジュール情報の新規作成時に使用します。
     *
     * @param 認定調査予定年月日 認定調査予定年月日
     * @param 認定調査予定開始時間 認定調査予定開始時間
     * @param 認定調査予定終了時間 認定調査予定終了時間
     * @param 認定調査時間枠 認定調査時間枠
     * @param 認定調査委託先コード 認定調査委託先コード
     * @param 認定調査員コード 認定調査員コード
     */
    public NinteichosaSchedule(FlexibleDate 認定調査予定年月日,
            RString 認定調査予定開始時間,
            RString 認定調査予定終了時間,
            Code 認定調査時間枠,
            RString 認定調査委託先コード,
            RString 認定調査員コード) {
        requireNonNull(認定調査予定年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("認定調査予定年月日"));
        requireNonNull(認定調査予定開始時間, UrSystemErrorMessages.値がnull.getReplacedMessage("認定調査予定開始時間"));
        requireNonNull(認定調査予定終了時間, UrSystemErrorMessages.値がnull.getReplacedMessage("認定調査予定終了時間"));
        requireNonNull(認定調査時間枠, UrSystemErrorMessages.値がnull.getReplacedMessage("認定調査時間枠"));
        requireNonNull(認定調査委託先コード, UrSystemErrorMessages.値がnull.getReplacedMessage("認定調査委託先コード"));
        requireNonNull(認定調査員コード, UrSystemErrorMessages.値がnull.getReplacedMessage("認定調査員コード"));
        this.entity = new DbT5221NinteichosaScheduleEntity();
        this.entity.setNinteiChosaYoteiYMD(認定調査予定年月日);
        this.entity.setNinteiChosaYoteiKaishiTime(認定調査予定開始時間);
        this.entity.setNinteiChosaYoteiShuryoTime(認定調査予定終了時間);
        this.entity.setNinteiChosaJikanWaku(認定調査時間枠);
//        this.entity.setNinteichosaItakusakiCode(認定調査委託先コード);
//        this.entity.setNinteiChosainNo(認定調査員コード);
        this.id = new NinteichosaScheduleIdentifier(
                認定調査予定年月日,
                認定調査予定開始時間,
                認定調査予定終了時間,
                認定調査時間枠,
                認定調査委託先コード,
                認定調査員コード
        );
    }

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link DbT5221NinteichosaScheduleEntity}より{@link NinteichosaSchedule}を生成します。
     *
     * @param entity DBより取得した{@link DbT5221NinteichosaScheduleEntity}
     */
//    public NinteichosaSchedule(DbT5221NinteichosaScheduleEntity entity) {
//        this.entity = requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("認定調査スケジュール情報"));
//        this.id = new NinteichosaScheduleIdentifier(
//                entity.getNinteiChosaYoteiYMD(),
//                entity.getNinteiChosaYoteiKaishiTime(),
//                entity.getNinteiChosaYoteiShuryoTime(),
//                entity.getNinteiChosaJikanWaku(),
//                entity.getNinteichosaItakusakiCode(),
//                entity.getNinteiChosainNo());
//    }

    /**
     * シリアライズ、ビルダー用コンストラクタです。
     *
     * @param entity {@link DbT5221NinteichosaScheduleEntity}
     * @param id {@link NinteichosaScheduleIdentifier}
     */
    NinteichosaSchedule(
            DbT5221NinteichosaScheduleEntity entity,
            NinteichosaScheduleIdentifier id
    ) {
        this.entity = entity;
        this.id = id;
    }

//TODO getterを見直してください。意味のある単位でValueObjectを作成して公開してください。
    /**
     * 認定調査予定年月日を返します。
     *
     * @return 認定調査予定年月日
     */
    public FlexibleDate get認定調査予定年月日() {
        return entity.getNinteiChosaYoteiYMD();
    }

    /**
     * 認定調査予定開始時間を返します。
     *
     * @return 認定調査予定開始時間
     */
    public RString get認定調査予定開始時間() {
        return entity.getNinteiChosaYoteiKaishiTime();
    }

    /**
     * 認定調査予定終了時間を返します。
     *
     * @return 認定調査予定終了時間
     */
    public RString get認定調査予定終了時間() {
        return entity.getNinteiChosaYoteiShuryoTime();
    }

    /**
     * 認定調査時間枠を返します。
     *
     * @return 認定調査時間枠
     */
    public Code get認定調査時間枠() {
        return entity.getNinteiChosaJikanWaku();
    }

    /**
     * 調査地区コードを返します。
     *
     * @return 調査地区コード
     */
    public Code get調査地区コード() {
        return entity.getChosaChikuCode();
    }

//    /**
//     * 認定調査委託先コードを返します。
//     *
//     * @return 認定調査委託先コード
//     */
//    public RString get認定調査委託先コード() {
//        return entity.getNinteichosaItakusakiCode();
//    }
//
//    /**
//     * 認定調査員コードを返します。
//     *
//     * @return 認定調査員コード
//     */
//    public RString get認定調査員コード() {
//        return entity.getNinteiChosainNo();
//    }

    /**
     * 市町村コードを返します。
     *
     * @return 市町村コード
     */
    public LasdecCode get市町村コード() {
        return entity.getShichosonCode();
    }

    /**
     * 申請書管理番号を返します。
     *
     * @return 申請書管理番号
     */
    public ShinseishoKanriNo get申請書管理番号() {
        return entity.getShinseishoKanriNo();
    }

    /**
     * 予約状況を返します。
     *
     * @return 予約状況
     */
    public Code get予約状況() {
        return entity.getYoyakuJokyo();
    }

    /**
     * 予約可能フラグを返します。
     *
     * @return 予約可能フラグ
     */
    public boolean is予約可能フラグ() {
        return entity.getYoyakuKaoFlag();
    }

    /**
     * 備考を返します。
     *
     * @return 備考
     */
    public RString get備考() {
        return entity.getBiko();
    }

    /**
     * 場所を返します。
     *
     * @return 場所
     */
    public RString get場所() {
        return entity.getBasho();
    }

    /**
     * 駐車場を返します。
     *
     * @return 駐車場
     */
    public RString get駐車場() {
        return entity.getChushajo();
    }

    /**
     * 立会人１を返します。
     *
     * @return 立会人１
     */
    public RString get立会人１() {
        return entity.getTachiainin1();
    }

    /**
     * 連絡先１を返します。
     *
     * @return 連絡先１
     */
    public TelNo get連絡先１() {
        return entity.getRenrakusaki1();
    }

    /**
     * 立会人２を返します。
     *
     * @return 立会人２
     */
    public RString get立会人２() {
        return entity.getTachiainin2();
    }

    /**
     * 連絡先２を返します。
     *
     * @return 連絡先２
     */
    public TelNo get連絡先２() {
        return entity.getRenrakusaki2();
    }

    /**
     * 対象者メモを返します。
     *
     * @return 対象者メモ
     */
    public RString get対象者メモ() {
        return entity.getTaishoshaMemo();
    }

    /**
     * {@link DbT5221NinteichosaScheduleEntity}のクローンを返します。
     *
     * @return {@link DbT5221NinteichosaScheduleEntity}のクローン
     */
    @Override
    public DbT5221NinteichosaScheduleEntity toEntity() {
        return this.entity.clone();
    }

    /**
     * 認定調査スケジュール情報の識別子{@link NinteichosaScheduleIdentifier}を返します。
     *
     * @return 認定調査スケジュール情報の識別子{@link NinteichosaScheduleIdentifier}
     */
    @Override
    public NinteichosaScheduleIdentifier identifier() {
        return this.id;
    }

    /**
     * 認定調査スケジュール情報のみを変更対象とします。<br/>
     * {@link DbT5221NinteichosaScheduleEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば変更状態にします。
     *
     * @return 変更対象処理実施後の{@link NinteichosaSchedule}
     */
    @Override
    public NinteichosaSchedule modifiedModel() {
        DbT5221NinteichosaScheduleEntity modifiedEntity = this.toEntity();
        if (!modifiedEntity.getState().equals(EntityDataState.Added)) {
            modifiedEntity.setState(EntityDataState.Modified);
        }
        return new NinteichosaSchedule(
                modifiedEntity, id);
    }

    /**
     * 保持する認定調査スケジュール情報を削除対象とします。<br/>
     * {@link DbT5221NinteichosaScheduleEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば削除状態にします。
     *
     * @return 削除対象処理実施後の{@link NinteichosaSchedule}
     */
    @Override
    public NinteichosaSchedule deleted() {
        DbT5221NinteichosaScheduleEntity deletedEntity = this.toEntity();
        if (deletedEntity.getState() != EntityDataState.Added) {
            deletedEntity.setState(EntityDataState.Deleted);
        } else {
            //TODO メッセージの検討
            throw new IllegalStateException(UrErrorMessages.不正.toString());
        }
        return new NinteichosaSchedule(deletedEntity, id);
    }

    /**
     * {@link NinteichosaSchedule}のシリアライズ形式を提供します。
     *
     * @return {@link NinteichosaSchedule}のシリアライズ形式
     */
    protected Object writeReplace() {
        return new _SerializationProxy(entity, id);

    }

    @Override
    public boolean hasChanged() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private static final class _SerializationProxy implements Serializable {

        private static final long serialVersionUID = 1L;
        private final DbT5221NinteichosaScheduleEntity entity;
        private final NinteichosaScheduleIdentifier id;

        private _SerializationProxy(DbT5221NinteichosaScheduleEntity entity, NinteichosaScheduleIdentifier id) {
            this.entity = entity;
            this.id = id;
        }

        private Object readResolve() {
            return new NinteichosaSchedule(this.entity, this.id);
        }
    }

    /**
     * このクラスの編集を行うBuilderを取得します。<br/>
     * 編集後のインスタンスを取得する場合は{@link SeishinTechoNini.createBuilderForEdit#build()}を使用してください。
     *
     * @return Builder
     */
    public NinteichosaScheduleBuilder createBuilderForEdit() {
        return new NinteichosaScheduleBuilder(entity, id);
    }

//TODO これはあくまでも雛形によるクラス生成です、必要な業務ロジックの追加、ValueObjectの導出を行う必要があります。
}
