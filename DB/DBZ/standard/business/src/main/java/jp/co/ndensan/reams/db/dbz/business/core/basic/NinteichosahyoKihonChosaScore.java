/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.business.core.uzclasses.ParentModelBase;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT5204NinteichosahyoKihonChosaScoreEntity;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 認定調査票（基本調査素点）を管理するクラスです。
 */
public class NinteichosahyoKihonChosaScore extends ParentModelBase<NinteichosahyoKihonChosaScoreIdentifier, DbT5204NinteichosahyoKihonChosaScoreEntity, NinteichosahyoKihonChosaScore> implements Serializable {

    private final DbT5204NinteichosahyoKihonChosaScoreEntity entity;
    private final NinteichosahyoKihonChosaScoreIdentifier id;

    /**
     * コンストラクタです。<br/>
     * 認定調査票（基本調査素点）の新規作成時に使用します。
     *
     * @param 申請書管理番号 申請書管理番号
     * @param 要介護認定調査履歴番号 要介護認定調査履歴番号
     */
    public NinteichosahyoKihonChosaScore(ShinseishoKanriNo 申請書管理番号,
            int 要介護認定調査履歴番号) {
        requireNonNull(申請書管理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("申請書管理番号"));
        requireNonNull(要介護認定調査履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("要介護認定調査履歴番号"));
        this.entity = new DbT5204NinteichosahyoKihonChosaScoreEntity();
        this.entity.setShinseishoKanriNo(申請書管理番号);
        this.entity.setNinteichosaRirekiNo(要介護認定調査履歴番号);
        this.id = new NinteichosahyoKihonChosaScoreIdentifier(
                申請書管理番号,
                要介護認定調査履歴番号
        );
    }

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link DbT5204NinteichosahyoKihonChosaScoreEntity}より{@link NinteichosahyoKihonChosaScore}を生成します。
     *
     * @param entity DBより取得した{@link DbT5204NinteichosahyoKihonChosaScoreEntity}
     */
    public NinteichosahyoKihonChosaScore(DbT5204NinteichosahyoKihonChosaScoreEntity entity) {
        this.entity = requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("認定調査票（基本調査素点）"));
        this.id = new NinteichosahyoKihonChosaScoreIdentifier(
                entity.getShinseishoKanriNo(),
                entity.getNinteichosaRirekiNo());
    }

    /**
     * シリアライズ、ビルダー用コンストラクタです。
     *
     * @param entity {@link DbT5204NinteichosahyoKihonChosaScoreEntity}
     * @param id {@link NinteichosahyoKihonChosaScoreIdentifier}
     */
    NinteichosahyoKihonChosaScore(
            DbT5204NinteichosahyoKihonChosaScoreEntity entity,
            NinteichosahyoKihonChosaScoreIdentifier id
    ) {
        this.entity = entity;
        this.id = id;
    }

//TODO getterを見直してください。意味のある単位でValueObjectを作成して公開してください。
    /**
     * 申請書管理番号を返します。
     *
     * @return 申請書管理番号
     */
    public ShinseishoKanriNo get申請書管理番号() {
        return entity.getShinseishoKanriNo();
    }

    /**
     * 要介護認定調査履歴番号を返します。
     *
     * @return 要介護認定調査履歴番号
     */
    public int get要介護認定調査履歴番号() {
        return entity.getNinteichosaRirekiNo();
    }

    /**
     * 厚労省IF識別コードを返します。
     *
     * @return 厚労省IF識別コード
     */
    public Code get厚労省IF識別コード() {
        return entity.getKoroshoIfShikibetsuCode();
    }

    /**
     * 素点合計_第１郡を返します。
     *
     * @return 素点合計_第１郡
     */
    public int get素点合計_第１郡() {
        return entity.getTokutenTotal1gun();
    }

    /**
     * 素点合計_第２郡を返します。
     *
     * @return 素点合計_第２郡
     */
    public int get素点合計_第２郡() {
        return entity.getTokutenTotal2gun();
    }

    /**
     * 素点合計_第３郡を返します。
     *
     * @return 素点合計_第３郡
     */
    public int get素点合計_第３郡() {
        return entity.getTokutenTotal3gun();
    }

    /**
     * 素点合計_第４郡を返します。
     *
     * @return 素点合計_第４郡
     */
    public int get素点合計_第４郡() {
        return entity.getTokutenTotal4gun();
    }

    /**
     * 素点合計_第５郡を返します。
     *
     * @return 素点合計_第５郡
     */
    public int get素点合計_第５郡() {
        return entity.getTokutenTotal5gun();
    }

    /**
     * 素点合計_第６郡を返します。
     *
     * @return 素点合計_第６郡
     */
    public int get素点合計_第６郡() {
        return entity.getTokutenTotal6gun();
    }

    /**
     * 素点合計_第７郡を返します。
     *
     * @return 素点合計_第７郡
     */
    public int get素点合計_第７郡() {
        return entity.getTokutenTotal7gun();
    }

    /**
     * {@link DbT5204NinteichosahyoKihonChosaScoreEntity}のクローンを返します。
     *
     * @return {@link DbT5204NinteichosahyoKihonChosaScoreEntity}のクローン
     */
    @Override
    public DbT5204NinteichosahyoKihonChosaScoreEntity toEntity() {
        return this.entity.clone();
    }

    /**
     * 認定調査票（基本調査素点）の識別子{@link NinteichosahyoKihonChosaScoreIdentifier}を返します。
     *
     * @return 認定調査票（基本調査素点）の識別子{@link NinteichosahyoKihonChosaScoreIdentifier}
     */
    @Override
    public NinteichosahyoKihonChosaScoreIdentifier identifier() {
        return this.id;
    }

    /**
     * 認定調査票（基本調査素点）のみを変更対象とします。<br/>
     * {@link DbT5204NinteichosahyoKihonChosaScoreEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば変更状態にします。
     *
     * @return 変更対象処理実施後の{@link NinteichosahyoKihonChosaScore}
     */
    @Override
    public NinteichosahyoKihonChosaScore modifiedModel() {
        DbT5204NinteichosahyoKihonChosaScoreEntity modifiedEntity = this.toEntity();
        if (!modifiedEntity.getState().equals(EntityDataState.Added)) {
            modifiedEntity.setState(EntityDataState.Modified);
        }
        return new NinteichosahyoKihonChosaScore(
                modifiedEntity, id);
    }

    /**
     * 保持する認定調査票（基本調査素点）を削除対象とします。<br/>
     * {@link DbT5204NinteichosahyoKihonChosaScoreEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば削除状態にします。
     *
     * @return 削除対象処理実施後の{@link NinteichosahyoKihonChosaScore}
     */
    @Override
    public NinteichosahyoKihonChosaScore deleted() {
        DbT5204NinteichosahyoKihonChosaScoreEntity deletedEntity = this.toEntity();
        if (deletedEntity.getState() != EntityDataState.Added) {
            deletedEntity.setState(EntityDataState.Deleted);
        } else {
            //TODO メッセージの検討
            throw new IllegalStateException(UrErrorMessages.不正.toString());
        }
        return new NinteichosahyoKihonChosaScore(deletedEntity, id);
    }

    /**
     * {@link NinteichosahyoKihonChosaScore}のシリアライズ形式を提供します。
     *
     * @return {@link NinteichosahyoKihonChosaScore}のシリアライズ形式
     */
    protected Object writeReplace() {
        return new _SerializationProxy(entity, id);

    }

    @Override
    public boolean hasChanged() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private static final class _SerializationProxy implements Serializable {

        private static final long serialVersionUID = 1L;// TODO serialVersionUIDを生成してください
        private final DbT5204NinteichosahyoKihonChosaScoreEntity entity;
        private final NinteichosahyoKihonChosaScoreIdentifier id;

        private _SerializationProxy(DbT5204NinteichosahyoKihonChosaScoreEntity entity, NinteichosahyoKihonChosaScoreIdentifier id) {
            this.entity = entity;
            this.id = id;
        }

        private Object readResolve() {
            return new NinteichosahyoKihonChosaScore(this.entity, this.id);
        }
    }

    /**
     * このクラスの編集を行うBuilderを取得します。<br/>
     * 編集後のインスタンスを取得する場合は{@link SeishinTechoNini.createBuilderForEdit#build()}を使用してください。
     *
     * @return Builder
     */
    public NinteichosahyoKihonChosaScoreBuilder createBuilderForEdit() {
        return new NinteichosahyoKihonChosaScoreBuilder(entity, id);
    }

//TODO これはあくまでも雛形によるクラス生成です、必要な業務ロジックの追加、ValueObjectの導出を行う必要があります。
}
