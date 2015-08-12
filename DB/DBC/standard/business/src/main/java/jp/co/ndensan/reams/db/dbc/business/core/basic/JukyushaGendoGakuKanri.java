/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.entity.basic.DbT7116JukyushaGendoGakuKanriEntity;
import jp.co.ndensan.reams.db.dbz.business.core.uzclasses.ParentModelBase;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 受給者限度額管理を管理するクラスです。
 */
public class JukyushaGendoGakuKanri extends ParentModelBase<JukyushaGendoGakuKanriIdentifier, DbT7116JukyushaGendoGakuKanriEntity, JukyushaGendoGakuKanri> implements Serializable {

    private final DbT7116JukyushaGendoGakuKanriEntity entity;
    private final JukyushaGendoGakuKanriIdentifier id;

    /**
     * コンストラクタです。<br/>
     * 受給者限度額管理の新規作成時に使用します。
     *
     * @param 被保険者番号 被保険者番号
     * @param 識別区分 識別区分
     * @param 有効開始年月 有効開始年月
     * @param 履歴番号 履歴番号
     */
    public JukyushaGendoGakuKanri(HihokenshaNo 被保険者番号,
            RString 識別区分,
            FlexibleYearMonth 有効開始年月,
            int 履歴番号) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(識別区分, UrSystemErrorMessages.値がnull.getReplacedMessage("識別区分"));
        requireNonNull(有効開始年月, UrSystemErrorMessages.値がnull.getReplacedMessage("有効開始年月"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));
        this.entity = new DbT7116JukyushaGendoGakuKanriEntity();
        this.entity.setHihokenshaNo(被保険者番号);
        this.entity.setShikibetsuKubun(識別区分);
        this.entity.setYukoKaishiYM(有効開始年月);
        this.entity.setRirekiNo(履歴番号);
        this.id = new JukyushaGendoGakuKanriIdentifier(
                被保険者番号,
                識別区分,
                有効開始年月,
                履歴番号
        );
    }

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link DbT7116JukyushaGendoGakuKanriEntity}より{@link JukyushaGendoGakuKanri}を生成します。
     *
     * @param entity DBより取得した{@link DbT7116JukyushaGendoGakuKanriEntity}
     */
    public JukyushaGendoGakuKanri(DbT7116JukyushaGendoGakuKanriEntity entity) {
        this.entity = requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("受給者限度額管理"));
        this.id = new JukyushaGendoGakuKanriIdentifier(
                entity.getHihokenshaNo(),
                entity.getShikibetsuKubun(),
                entity.getYukoKaishiYM(),
                entity.getRirekiNo());
    }

    /**
     * シリアライズ、ビルダー用コンストラクタです。
     *
     * @param entity {@link DbT7116JukyushaGendoGakuKanriEntity}
     * @param id {@link JukyushaGendoGakuKanriIdentifier}
     */
    JukyushaGendoGakuKanri(
            DbT7116JukyushaGendoGakuKanriEntity entity,
            JukyushaGendoGakuKanriIdentifier id
    ) {
        this.entity = entity;
        this.id = id;
    }

//TODO getterを見直してください。意味のある単位でValueObjectを作成して公開してください。
    /**
     * 被保険者番号を返します。
     *
     * @return 被保険者番号
     */
    public HihokenshaNo get被保険者番号() {
        return entity.getHihokenshaNo();
    }

    /**
     * 識別区分を返します。
     *
     * @return 識別区分
     */
    public RString get識別区分() {
        return entity.getShikibetsuKubun();
    }

    /**
     * 有効開始年月を返します。
     *
     * @return 有効開始年月
     */
    public FlexibleYearMonth get有効開始年月() {
        return entity.getYukoKaishiYM();
    }

    /**
     * 履歴番号を返します。
     *
     * @return 履歴番号
     */
    public int get履歴番号() {
        return entity.getRirekiNo();
    }

    /**
     * 有効終了年月を返します。
     *
     * @return 有効終了年月
     */
    public FlexibleYearMonth get有効終了年月() {
        return entity.getYukoShuryoYM();
    }

    /**
     * 要介護状態区分を返します。
     *
     * @return 要介護状態区分
     */
    public RString get要介護状態区分() {
        return entity.getYoKaigoJotaiKubun();
    }

    /**
     * 拡大倍数を返します。
     *
     * @return 拡大倍数
     */
    public RString get拡大倍数() {
        return entity.getKakudaiBaisu();
    }

    /**
     * 切り分け単位数を返します。
     *
     * @return 切り分け単位数
     */
    public Decimal get切り分け単位数() {
        return entity.getKiriwakeTaniSu();
    }

    /**
     * 登録年月日を返します。
     *
     * @return 登録年月日
     */
    public FlexibleDate get登録年月日() {
        return entity.getTorokuYMD();
    }

    /**
     * 変更年月日を返します。
     *
     * @return 変更年月日
     */
    public FlexibleDate get変更年月日() {
        return entity.getHenkoYMD();
    }

    /**
     * 限度額管理期間数を返します。
     *
     * @return 限度額管理期間数
     */
    public RString get限度額管理期間数() {
        return entity.getGendoGakuKanriKikanSu();
    }

    /**
     * 新体系管理区分を返します。
     *
     * @return 新体系管理区分
     */
    public RString get新体系管理区分() {
        return entity.getShinTaikeiKanriKubun();
    }

    /**
     * 新体系拡大適用有無を返します。
     *
     * @return 新体系拡大適用有無
     */
    public RString get新体系拡大適用有無() {
        return entity.getShinTaikeiKakudaiTekiyoUmu();
    }

    /**
     * {@link DbT7116JukyushaGendoGakuKanriEntity}のクローンを返します。
     *
     * @return {@link DbT7116JukyushaGendoGakuKanriEntity}のクローン
     */
    @Override
    public DbT7116JukyushaGendoGakuKanriEntity toEntity() {
        return this.entity.clone();
    }

    /**
     * 受給者限度額管理の識別子{@link JukyushaGendoGakuKanriIdentifier}を返します。
     *
     * @return 受給者限度額管理の識別子{@link JukyushaGendoGakuKanriIdentifier}
     */
    @Override
    public JukyushaGendoGakuKanriIdentifier identifier() {
        return this.id;
    }

    /**
     * 受給者限度額管理のみを変更対象とします。<br/>
     * {@link DbT7116JukyushaGendoGakuKanriEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば変更状態にします。
     *
     * @return 変更対象処理実施後の{@link JukyushaGendoGakuKanri}
     */
    @Override
    public JukyushaGendoGakuKanri modifiedModel() {
        DbT7116JukyushaGendoGakuKanriEntity modifiedEntity = this.toEntity();
        if (!modifiedEntity.getState().equals(EntityDataState.Added)) {
            modifiedEntity.setState(EntityDataState.Modified);
        }
        return new JukyushaGendoGakuKanri(
                modifiedEntity, id);
    }

    /**
     * 保持する受給者限度額管理を削除対象とします。<br/>
     * {@link DbT7116JukyushaGendoGakuKanriEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば削除状態にします。
     *
     * @return 削除対象処理実施後の{@link JukyushaGendoGakuKanri}
     */
    @Override
    public JukyushaGendoGakuKanri deleted() {
        DbT7116JukyushaGendoGakuKanriEntity deletedEntity = this.toEntity();
        if (deletedEntity.getState() != EntityDataState.Added) {
            deletedEntity.setState(EntityDataState.Deleted);
        } else {
            //TODO メッセージの検討
            throw new IllegalStateException(UrErrorMessages.不正.toString());
        }
        return new JukyushaGendoGakuKanri(deletedEntity, id);
    }

    /**
     * {@link JukyushaGendoGakuKanri}のシリアライズ形式を提供します。
     *
     * @return {@link JukyushaGendoGakuKanri}のシリアライズ形式
     */
    protected Object writeReplace() {
        return new _SerializationProxy(entity, id);

    }

    private static final class _SerializationProxy implements Serializable {

        private static final long serialVersionUID = // TODO serialVersionUIDを生成してください
        private final DbT7116JukyushaGendoGakuKanriEntity entity;
        private final JukyushaGendoGakuKanriIdentifier id;

        private _SerializationProxy(DbT7116JukyushaGendoGakuKanriEntity entity, JukyushaGendoGakuKanriIdentifier id) {
            this.entity = entity;
            this.id = id;
        }

        private Object readResolve() {
            return new JukyushaGendoGakuKanri(this.entity, this.id);
        }
    }

    /**
     * このクラスの編集を行うBuilderを取得します。<br/>
     * 編集後のインスタンスを取得する場合は{@link SeishinTechoNini.createBuilderForEdit#build()}を使用してください。
     *
     * @return Builder
     */
    public JukyushaGendoGakuKanriBuilder createBuilderForEdit() {
        return new JukyushaGendoGakuKanriBuilder(entity, id);
    }

//TODO これはあくまでも雛形によるクラス生成です、必要な業務ロジックの追加、ValueObjectの導出を行う必要があります。
}
