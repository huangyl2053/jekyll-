/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3104KokuhorenInterfaceKanriEntity;
import jp.co.ndensan.reams.db.dbz.business.core.uzclasses.ModelBase;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 国保連インターフェース管理を管理するクラスです。
 */
public class KokuhorenInterfaceKanri extends
        ModelBase<KokuhorenInterfaceKanriIdentifier, DbT3104KokuhorenInterfaceKanriEntity, KokuhorenInterfaceKanri>
        implements Serializable {

    private final DbT3104KokuhorenInterfaceKanriEntity entity;
    private final KokuhorenInterfaceKanriIdentifier id;

    /**
     * コンストラクタです。<br/>
     * 国保連インターフェース管理の新規作成時に使用します。
     *
     * @param 処理年月 処理年月
     * @param 交換情報識別番号 交換情報識別番号
     */
    public KokuhorenInterfaceKanri(FlexibleYearMonth 処理年月,
            RString 交換情報識別番号) {
        requireNonNull(処理年月, UrSystemErrorMessages.値がnull.getReplacedMessage("処理年月"));
        requireNonNull(交換情報識別番号, UrSystemErrorMessages.値がnull.getReplacedMessage("交換情報識別番号"));
        this.entity = new DbT3104KokuhorenInterfaceKanriEntity();
        this.entity.setShoriYM(処理年月);
        this.entity.setKokanShikibetsuNo(交換情報識別番号);
        this.id = new KokuhorenInterfaceKanriIdentifier(
                処理年月,
                交換情報識別番号
        );
    }

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link DbT3104KokuhorenInterfaceKanriEntity}より{@link KokuhorenInterfaceKanri}を生成します。
     *
     * @param entity DBより取得した{@link DbT3104KokuhorenInterfaceKanriEntity}
     */
    public KokuhorenInterfaceKanri(DbT3104KokuhorenInterfaceKanriEntity entity) {
        this.entity = requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("国保連インターフェース管理"));
        this.id = new KokuhorenInterfaceKanriIdentifier(
                entity.getShoriYM(),
                entity.getKokanShikibetsuNo());
    }

    /**
     * シリアライズ、ビルダー用コンストラクタです。
     *
     * @param entity {@link DbT3104KokuhorenInterfaceKanriEntity}
     * @param id {@link KokuhorenInterfaceKanriIdentifier}
     */
    KokuhorenInterfaceKanri(
            DbT3104KokuhorenInterfaceKanriEntity entity,
            KokuhorenInterfaceKanriIdentifier id
    ) {
        this.entity = entity;
        this.id = id;
    }

//TODO getterを見直してください。意味のある単位でValueObjectを作成して公開してください。
    /**
     * 処理年月を返します。
     *
     * @return 処理年月
     */
    public FlexibleYearMonth get処理年月() {
        return entity.getShoriYM();
    }

    /**
     * 交換情報識別番号を返します。
     *
     * @return 交換情報識別番号
     */
    public RString get交換情報識別番号() {
        return entity.getKokanShikibetsuNo();
    }

    /**
     * 送付取込区分を返します。
     *
     * @return 送付取込区分
     */
    public RString get送付取込区分() {
        return entity.getSofuTorikomiKubun();
    }

    /**
     * 処理状態区分を返します。
     *
     * @return 処理状態区分
     */
    public RString get処理状態区分() {
        return entity.getShoriJotaiKubun();
    }

    /**
     * 処理実施日時を返します。
     *
     * @return 処理実施日時
     */
    public YMDHMS get処理実施日時() {
        return entity.getShoriJisshiTimestamp();
    }

    /**
     * 抽出開始日時を返します。
     *
     * @return 抽出開始日時
     */
    public YMDHMS get抽出開始日時() {
        return entity.getChushutsuKaishiTimestamp();
    }

    /**
     * 抽出終了日時を返します。
     *
     * @return 抽出終了日時
     */
    public YMDHMS get抽出終了日時() {
        return entity.getChushutsuShuryoTimestamp();
    }

    /**
     * 再処理可能区分を返します。
     *
     * @return 再処理可能区分
     */
    public boolean is再処理可能区分() {
        return entity.getSaiShoriKanoKubun();
    }

    /**
     * 処理実行回数を返します。
     *
     * @return 処理実行回数
     */
    public Decimal get処理実行回数() {
        return entity.getShoriJikkoKaisu();
    }

    /**
     * ファイル名称１を返します。
     *
     * @return ファイル名称１
     */
    public RString getファイル名称１() {
        return entity.getFileName1();
    }

    /**
     * ファイル名称２を返します。
     *
     * @return ファイル名称２
     */
    public RString getファイル名称２() {
        return entity.getFileName2();
    }

    /**
     * ファイル名称３を返します。
     *
     * @return ファイル名称３
     */
    public RString getファイル名称３() {
        return entity.getFileName3();
    }

    /**
     * ファイル名称４を返します。
     *
     * @return ファイル名称４
     */
    public RString getファイル名称４() {
        return entity.getFileName4();
    }

    /**
     * ファイル名称５を返します。
     *
     * @return ファイル名称５
     */
    public RString getファイル名称５() {
        return entity.getFileName5();
    }

    /**
     * ファイル件数１を返します。
     *
     * @return ファイル件数１
     */
    public int getファイル件数１() {
        return entity.getFileKensu1();
    }

    /**
     * ファイル件数２を返します。
     *
     * @return ファイル件数２
     */
    public int getファイル件数２() {
        return entity.getFileKensu2();
    }

    /**
     * ファイル件数３を返します。
     *
     * @return ファイル件数３
     */
    public int getファイル件数３() {
        return entity.getFileKensu3();
    }

    /**
     * ファイル件数４を返します。
     *
     * @return ファイル件数４
     */
    public int getファイル件数４() {
        return entity.getFileKensu4();
    }

    /**
     * ファイル件数５を返します。
     *
     * @return ファイル件数５
     */
    public int getファイル件数５() {
        return entity.getFileKensu5();
    }

    /**
     * 再処理設定不可区分を返します。
     *
     * @return 再処理設定不可区分
     */
    public boolean is再処理設定不可区分() {
        return entity.getSaiShoriFukaKubun();
    }

    /**
     * コントロール上レコード件数を返します。
     *
     * @return コントロール上レコード件数
     */
    public int getコントロール上レコード件数() {
        return entity.getCtrlRecordKensu();
    }

    /**
     * コントロール上処理年月を返します。
     *
     * @return コントロール上処理年月
     */
    public FlexibleYearMonth getコントロール上処理年月() {
        return entity.getCtrlShoriYM();
    }

    /**
     * 過誤コントロール上レコード件数を返します。
     *
     * @return 過誤コントロール上レコード件数
     */
    public int get過誤コントロール上レコード件数() {
        return entity.getKagoCtrlRecordKensu();
    }

    /**
     * 過誤コントロール上処理年月を返します。
     *
     * @return 過誤コントロール上処理年月
     */
    public FlexibleYearMonth get過誤コントロール上処理年月() {
        return entity.getKagoCtrlShoriYM();
    }

    /**
     * 実績データ上審査年月を返します。
     *
     * @return 実績データ上審査年月
     */
    public FlexibleYearMonth get実績データ上審査年月() {
        return entity.getJissekiDataShinsaYM();
    }

    /**
     * {@link DbT3104KokuhorenInterfaceKanriEntity}のクローンを返します。
     *
     * @return {@link DbT3104KokuhorenInterfaceKanriEntity}のクローン
     */
    @Override
    public DbT3104KokuhorenInterfaceKanriEntity toEntity() {
        return this.entity.clone();
    }

    /**
     * 国保連インターフェース管理の識別子{@link KokuhorenInterfaceKanriIdentifier}を返します。
     *
     * @return 国保連インターフェース管理の識別子{@link KokuhorenInterfaceKanriIdentifier}
     */
    @Override
    public KokuhorenInterfaceKanriIdentifier identifier() {
        return this.id;
    }

    /**
     * 保持する国保連インターフェース管理を削除対象とします。<br/>
     * {@link DbT3104KokuhorenInterfaceKanriEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば削除状態にします。
     *
     * @return 削除対象処理実施後の{@link KokuhorenInterfaceKanri}
     */
    @Override
    public KokuhorenInterfaceKanri deleted() {
        DbT3104KokuhorenInterfaceKanriEntity deletedEntity = this.toEntity();
        if (deletedEntity.getState() != EntityDataState.Added) {
            deletedEntity.setState(EntityDataState.Deleted);
        } else {
            //TODO メッセージの検討
            throw new IllegalStateException(UrErrorMessages.不正.toString());
        }
        return new KokuhorenInterfaceKanri(deletedEntity, id);
    }

    /**
     * 保持する国保連インターフェース管理を更新対象とします。<br/>
     * {@link DbT3104KokuhorenInterfaceKanriEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば更新状態にします。
     *
     * @return 更新対象処理実施後の{@link KokuhorenInterfaceKanri}
     */
    public KokuhorenInterfaceKanri modified() {
        DbT3104KokuhorenInterfaceKanriEntity deletedEntity = this.toEntity();
        deletedEntity.setState(EntityDataState.Modified);
        return new KokuhorenInterfaceKanri(deletedEntity, id);
    }

    /**
     * 保持する国保連インターフェース管理を追加対象とします。<br/>
     * {@link DbT3104KokuhorenInterfaceKanriEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば追加状態にします。
     *
     * @return 追加対象処理実施後の{@link KokuhorenInterfaceKanri}
     */
    public KokuhorenInterfaceKanri added() {
        DbT3104KokuhorenInterfaceKanriEntity deletedEntity = this.toEntity();
        deletedEntity.setState(EntityDataState.Added);
        return new KokuhorenInterfaceKanri(deletedEntity, id);
    }

    /**
     * {@link KokuhorenInterfaceKanri}のシリアライズ形式を提供します。
     *
     * @return {@link KokuhorenInterfaceKanri}のシリアライズ形式
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

        private final DbT3104KokuhorenInterfaceKanriEntity entity;
        private final KokuhorenInterfaceKanriIdentifier id;

        private _SerializationProxy(DbT3104KokuhorenInterfaceKanriEntity entity, KokuhorenInterfaceKanriIdentifier id) {
            this.entity = entity;
            this.id = id;
        }

        private Object readResolve() {
            return new KokuhorenInterfaceKanri(this.entity, this.id);
        }
    }

    /**
     * このクラスの編集を行うBuilderを取得します。<br/>
     * 編集後のインスタンスを取得する場合は{@link SeishinTechoNini.createBuilderForEdit#build()}を使用してください。
     *
     * @return Builder
     */
    public KokuhorenInterfaceKanriBuilder createBuilderForEdit() {
        return new KokuhorenInterfaceKanriBuilder(entity, id);
    }

//TODO これはあくまでも雛形によるクラス生成です、必要な業務ロジックの追加、ValueObjectの導出を行う必要があります。
}
