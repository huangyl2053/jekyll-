/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.business.core.uzclasses.ModelBase;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7066ChohyoSeigyoKyotsuControlEntity;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 帳票制御共通コントロールを管理するクラスです。
 */
public class ChohyoSeigyoKyotsuControl extends ModelBase<ChohyoSeigyoKyotsuControlIdentifier, DbT7066ChohyoSeigyoKyotsuControlEntity, ChohyoSeigyoKyotsuControl> implements Serializable {

    private final DbT7066ChohyoSeigyoKyotsuControlEntity entity;
    private final ChohyoSeigyoKyotsuControlIdentifier id;

    /**
     * コンストラクタです。<br/>
     * 帳票制御共通コントロールの新規作成時に使用します。
     *
     * @param サブ業務コード サブ業務コード
     * @param 帳票分類ID 帳票分類ID
     */
    public ChohyoSeigyoKyotsuControl(SubGyomuCode サブ業務コード,
            ReportId 帳票分類ID) {
        requireNonNull(サブ業務コード, UrSystemErrorMessages.値がnull.getReplacedMessage("サブ業務コード"));
        requireNonNull(帳票分類ID, UrSystemErrorMessages.値がnull.getReplacedMessage("帳票分類ID"));
        this.entity = new DbT7066ChohyoSeigyoKyotsuControlEntity();
        this.entity.setSubGyomuCode(サブ業務コード);
        this.entity.setChohyoBunruiID(帳票分類ID);
        this.id = new ChohyoSeigyoKyotsuControlIdentifier(
                サブ業務コード,
                帳票分類ID
        );
    }

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link DbT7066ChohyoSeigyoKyotsuControlEntity}より{@link ChohyoSeigyoKyotsuControl}を生成します。
     *
     * @param entity DBより取得した{@link DbT7066ChohyoSeigyoKyotsuControlEntity}
     */
    public ChohyoSeigyoKyotsuControl(DbT7066ChohyoSeigyoKyotsuControlEntity entity) {
        this.entity = requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("帳票制御共通コントロール"));
        this.id = new ChohyoSeigyoKyotsuControlIdentifier(
                entity.getSubGyomuCode(),
                entity.getChohyoBunruiID());
    }

    /**
     * シリアライズ、ビルダー用コンストラクタです。
     *
     * @param entity {@link DbT7066ChohyoSeigyoKyotsuControlEntity}
     * @param id {@link ChohyoSeigyoKyotsuControlIdentifier}
     */
    ChohyoSeigyoKyotsuControl(
            DbT7066ChohyoSeigyoKyotsuControlEntity entity,
            ChohyoSeigyoKyotsuControlIdentifier id
    ) {
        this.entity = entity;
        this.id = id;
    }

//TODO getterを見直してください。意味のある単位でValueObjectを作成して公開してください。
    /**
     * サブ業務コードを返します。
     *
     * @return サブ業務コード
     */
    public SubGyomuCode getサブ業務コード() {
        return entity.getSubGyomuCode();
    }

    /**
     * 帳票分類IDを返します。
     *
     * @return 帳票分類ID
     */
    public ReportId get帳票分類ID() {
        return entity.getChohyoBunruiID();
    }

    /**
     * 共通画面使用有無を返します。
     *
     * @return 共通画面使用有無
     */
    public boolean get共通画面使用有無() {
        return entity.getKyotsuGamenShiyoUmu();
    }

    /**
     * 文書番号使用区分を返します。
     *
     * @return 文書番号使用区分
     */
    public RString get文書番号使用区分() {
        return entity.getBunshoNoShiyoKubun();
    }

    /**
     * 通知書定型文使用区分を返します。
     *
     * @return 通知書定型文使用区分
     */
    public RString get通知書定型文使用区分() {
        return entity.getTsuchishoTeikeibunShiyoKubun();
    }

    /**
     * 認証者使用区分を返します。
     *
     * @return 認証者使用区分
     */
    public RString get認証者使用区分() {
        return entity.getNinshoshaShiyoKubun();
    }

    /**
     * 帳票出力順使用区分を返します。
     *
     * @return 帳票出力順使用区分
     */
    public RString get帳票出力順使用区分() {
        return entity.getChohyoShuturyokujunShiyoKubun();
    }

    /**
     * 帳票出力順表示方法を返します。
     *
     * @return 帳票出力順表示方法
     */
    public RString get帳票出力順表示方法() {
        return entity.getChohyoShuturyokujunHyojiHohho();
    }

    /**
     * 介護問合せ先使用区分を返します。
     *
     * @return 介護問合せ先使用区分
     */
    public RString get介護問合せ先使用区分() {
        return entity.getKaigoToiawasesakiShiyoKubun();
    }

    /**
     * 住所編集使用区分を返します。
     *
     * @return 住所編集使用区分
     */
    public RString get住所編集使用区分() {
        return entity.getJushoHenshuShiyoKubun();
    }

    /**
     * 世帯主表示使用区分を返します。
     *
     * @return 世帯主表示使用区分
     */
    public RString get世帯主表示使用区分() {
        return entity.getSetainushiHyojiShiyoKubun();
    }

    /**
     * カスタマバーコード使用区分を返します。
     *
     * @return カスタマバーコード使用区分
     */
    public RString getカスタマバーコード使用区分() {
        return entity.getCustomerBarCodeShiyoKubun();
    }

    /**
     * 外部帳票文字切れ制御使用区分を返します。
     *
     * @return 外部帳票文字切れ制御使用区分
     */
    public RString get外部帳票文字切れ制御使用区分() {
        return entity.getGaibuChohyoMojigireSeigyoShiyoKubun();
    }

    /**
     * 内部帳票文字切れ制御使用区分を返します。
     *
     * @return 内部帳票文字切れ制御使用区分
     */
    public RString get内部帳票文字切れ制御使用区分() {
        return entity.getNaibuChohyoMojigireSeigyoShiyoKubun();
    }

    /**
     * 文字切れ分離制御使用区分を返します。
     *
     * @return 文字切れ分離制御使用区分
     */
    public RString get文字切れ分離制御使用区分() {
        return entity.getMojigireBunriSeigyoShiyoKubun();
    }

    /**
     * 定型文文字サイズ使用区分を返します。
     *
     * @return 定型文文字サイズ使用区分
     */
    public RString get定型文文字サイズ使用区分() {
        return entity.getTeikeibunMojiSizeShiyoKubun();
    }

    /**
     * 口座マスク使用区分を返します。
     *
     * @return 口座マスク使用区分
     */
    public RString get口座マスク使用区分() {
        return entity.getKozaMaskShiyoKubun();
    }

    /**
     * 口座名義人カナ優先使用区分を返します。
     *
     * @return 口座名義人カナ優先使用区分
     */
    public RString get口座名義人カナ優先使用区分() {
        return entity.getKozaMeigininKanaYusenShiyoKubun();
    }

    /**
     * 代行プリント使用区分を返します。
     *
     * @return 代行プリント使用区分
     */
    public RString get代行プリント使用区分() {
        return entity.getDaikoPrintShiyoKubun();
    }

    /**
     * 地区表示使用区分を返します。
     *
     * @return 地区表示使用区分
     */
    public RString get地区表示使用区分() {
        return entity.getChikuhyojiShiyoKubun();
    }

    /**
     * {@link DbT7066ChohyoSeigyoKyotsuControlEntity}のクローンを返します。
     *
     * @return {@link DbT7066ChohyoSeigyoKyotsuControlEntity}のクローン
     */
    @Override
    public DbT7066ChohyoSeigyoKyotsuControlEntity toEntity() {
        return this.entity.clone();
    }

    /**
     * 帳票制御共通コントロールの識別子{@link ChohyoSeigyoKyotsuControlIdentifier}を返します。
     *
     * @return 帳票制御共通コントロールの識別子{@link ChohyoSeigyoKyotsuControlIdentifier}
     */
    @Override
    public ChohyoSeigyoKyotsuControlIdentifier identifier() {
        return this.id;
    }

    /**
     * 帳票制御共通コントロールのみを変更対象とします。<br/>
     * {@link DbT7066ChohyoSeigyoKyotsuControlEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば変更状態にします。
     *
     * @return 変更対象処理実施後の{@link ChohyoSeigyoKyotsuControl}
     */
    @Override
    public ChohyoSeigyoKyotsuControl modifiedModel() {
        DbT7066ChohyoSeigyoKyotsuControlEntity modifiedEntity = this.toEntity();
        if (!modifiedEntity.getState().equals(EntityDataState.Added)) {
            modifiedEntity.setState(EntityDataState.Modified);
        }
        return new ChohyoSeigyoKyotsuControl(
                modifiedEntity, id);
    }

    /**
     * 保持する帳票制御共通コントロールを削除対象とします。<br/>
     * {@link DbT7066ChohyoSeigyoKyotsuControlEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば削除状態にします。
     *
     * @return 削除対象処理実施後の{@link ChohyoSeigyoKyotsuControl}
     */
    @Override
    public ChohyoSeigyoKyotsuControl deleted() {
        DbT7066ChohyoSeigyoKyotsuControlEntity deletedEntity = this.toEntity();
        if (deletedEntity.getState() != EntityDataState.Added) {
            deletedEntity.setState(EntityDataState.Deleted);
        } else {
            //TODO メッセージの検討
            throw new IllegalStateException(UrErrorMessages.不正.toString());
        }
        return new ChohyoSeigyoKyotsuControl(deletedEntity, id);
    }

    /**
     * {@link ChohyoSeigyoKyotsuControl}のシリアライズ形式を提供します。
     *
     * @return {@link ChohyoSeigyoKyotsuControl}のシリアライズ形式
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

        private final DbT7066ChohyoSeigyoKyotsuControlEntity entity;
        private final ChohyoSeigyoKyotsuControlIdentifier id;

        private _SerializationProxy(DbT7066ChohyoSeigyoKyotsuControlEntity entity, ChohyoSeigyoKyotsuControlIdentifier id) {
            this.entity = entity;
            this.id = id;
        }

        private Object readResolve() {
            return new ChohyoSeigyoKyotsuControl(this.entity, this.id);
        }
    }

    /**
     * このクラスの編集を行うBuilderを取得します。<br/>
     * 編集後のインスタンスを取得する場合は{@link SeishinTechoNini.createBuilderForEdit#build()}を使用してください。
     *
     * @return Builder
     */
    public ChohyoSeigyoKyotsuControlBuilder createBuilderForEdit() {
        return new ChohyoSeigyoKyotsuControlBuilder(entity, id);
    }

//TODO これはあくまでも雛形によるクラス生成です、必要な業務ロジックの追加、ValueObjectの導出を行う必要があります。
}
