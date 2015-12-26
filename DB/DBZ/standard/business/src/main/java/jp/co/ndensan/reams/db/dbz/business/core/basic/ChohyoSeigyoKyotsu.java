/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import java.io.Serializable;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.business.core.uzclasses.ModelBase;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7065ChohyoSeigyoKyotsuEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 帳票制御共通を管理するクラスです。
 */
public class ChohyoSeigyoKyotsu extends
        ModelBase<ChohyoSeigyoKyotsuIdentifier, DbT7065ChohyoSeigyoKyotsuEntity, ChohyoSeigyoKyotsu>
        implements Serializable {

    private final DbT7065ChohyoSeigyoKyotsuEntity entity;
    private final ChohyoSeigyoKyotsuIdentifier id;

    /**
     * コンストラクタです。<br/>
     * 帳票制御共通の新規作成時に使用します。
     *
     * @param サブ業務コード サブ業務コード
     * @param 帳票分類ID 帳票分類ID
     */
    public ChohyoSeigyoKyotsu(SubGyomuCode サブ業務コード,
            ReportId 帳票分類ID) {
        requireNonNull(サブ業務コード, UrSystemErrorMessages.値がnull.getReplacedMessage("サブ業務コード"));
        requireNonNull(帳票分類ID, UrSystemErrorMessages.値がnull.getReplacedMessage("帳票分類ID"));
        this.entity = new DbT7065ChohyoSeigyoKyotsuEntity();
        this.entity.setSubGyomuCode(サブ業務コード);
        this.entity.setChohyoBunruiID(帳票分類ID);
        this.id = new ChohyoSeigyoKyotsuIdentifier(
                サブ業務コード,
                帳票分類ID
        );
    }

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link DbT7065ChohyoSeigyoKyotsuEntity}より{@link ChohyoSeigyoKyotsu}を生成します。
     *
     * @param entity DBより取得した{@link DbT7065ChohyoSeigyoKyotsuEntity}
     */
    public ChohyoSeigyoKyotsu(DbT7065ChohyoSeigyoKyotsuEntity entity) {
        this.entity = requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("帳票制御共通"));
        this.id = new ChohyoSeigyoKyotsuIdentifier(
                entity.getSubGyomuCode(),
                entity.getChohyoBunruiID());
    }

    /**
     * シリアライズ、ビルダー用コンストラクタです。
     *
     * @param entity {@link DbT7065ChohyoSeigyoKyotsuEntity}
     * @param id {@link ChohyoSeigyoKyotsuIdentifier}
     */
    ChohyoSeigyoKyotsu(
            DbT7065ChohyoSeigyoKyotsuEntity entity,
            ChohyoSeigyoKyotsuIdentifier id
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
     * 帳票分類名称を返します。
     *
     * @return 帳票分類名称
     */
    public RString get帳票分類名称() {
        return entity.getChohyoBunruiMeisho();
    }

    /**
     * 住所編集区分を返します。
     *
     * @return 住所編集区分
     */
    public RString get住所編集区分() {
        return entity.getJushoHenshuKubun();
    }

    /**
     * 住所編集都道府県名表示有無を返します。
     *
     * @return 住所編集都道府県名表示有無
     */
    public boolean is住所編集都道府県名表示有無() {
        return entity.getJushoHenshuTodoufukenMeiHyojiUmu();
    }

    /**
     * 住所編集郡名表示有無を返します。
     *
     * @return 住所編集郡名表示有無
     */
    public boolean is住所編集郡名表示有無() {
        return entity.getJushoHenshuGunMeiHyojiUmu();
    }

    /**
     * 住所編集市町村名表示有無を返します。
     *
     * @return 住所編集市町村名表示有無
     */
    public boolean is住所編集市町村名表示有無() {
        return entity.getJushoHenshuShichosonMeiHyojiUmu();
    }

    /**
     * 住所編集町域編集方法を返します。
     *
     * @return 住所編集町域編集方法
     */
    public RString is住所編集町域編集方法() {
        return entity.getJushoHenshuChoikiHenshuHoho();
    }

    /**
     * 住所編集方書表示有無を返します。
     *
     * @return 住所編集方書表示有無
     */
    public boolean is住所編集方書表示有無() {
        return entity.getJushoHenshuKatagakiHyojiUmu();
    }

    /**
     * 世帯主表示有無を返します。
     *
     * @return 世帯主表示有無
     */
    public boolean is世帯主表示有無() {
        return entity.getSetainushiHyojiUmu();
    }

    /**
     * カスタマバーコード使用有無を返します。
     *
     * @return カスタマバーコード使用有無
     */
    public boolean isカスタマバーコード使用有無() {
        return entity.getCustomerBarCodeShiyoUmu();
    }

    /**
     * カスタマバーコード変換エラー編集方法を返します。
     *
     * @return カスタマバーコード変換エラー編集方法
     */
    public RString getカスタマバーコード変換エラー編集方法() {
        return entity.getCustomerBarCodeHenkanErrHenshuHoho();
    }

    /**
     * 外部帳票文字切れ制御を返します。
     *
     * @return 外部帳票文字切れ制御
     */
    public RString get外部帳票文字切れ制御() {
        return entity.getGaibuChohyoMojigireSeigyo();
    }

    /**
     * 内部帳票文字切れ制御を返します。
     *
     * @return 内部帳票文字切れ制御
     */
    public RString get内部帳票文字切れ制御() {
        return entity.getNaibuChohyoMojigireSeigyo();
    }

    /**
     * 文字切れ分離制御を返します。
     *
     * @return 文字切れ分離制御
     */
    public RString get文字切れ分離制御() {
        return entity.getMojigireBunriSeigyo();
    }

    /**
     * 定型文文字サイズを返します。
     *
     * @return 定型文文字サイズ
     */
    public RString get定型文文字サイズ() {
        return entity.getTeikeibunMojiSize();
    }

    /**
     * 口座マスク有無を返します。
     *
     * @return 口座マスク有無
     */
    public boolean is口座マスク有無() {
        return entity.getKozaMaskUmu();
    }

    /**
     * 口座名義人カナ優先区分を返します。
     *
     * @return 口座名義人カナ優先区分
     */
    public RString get口座名義人カナ優先区分() {
        return entity.getKozaMeigininKanaYusenKubun();
    }

    /**
     * 代行プリント有無を返します。
     *
     * @return 代行プリント有無
     */
    public boolean is代行プリント有無() {
        return entity.getDaikoPrintUmu();
    }

    /**
     * 地区表示1を返します。
     *
     * @return 地区表示1
     */
    public RString get地区表示1() {
        return entity.getChikuHyoji1();
    }

    /**
     * 地区表示2を返します。
     *
     * @return 地区表示2
     */
    public RString get地区表示2() {
        return entity.getChikuHyoji2();
    }

    /**
     * 地区表示3を返します。
     *
     * @return 地区表示3
     */
    public RString get地区表示3() {
        return entity.getChikuHyoji3();
    }

    /**
     * {@link DbT7065ChohyoSeigyoKyotsuEntity}のクローンを返します。
     *
     * @return {@link DbT7065ChohyoSeigyoKyotsuEntity}のクローン
     */
    @Override
    public DbT7065ChohyoSeigyoKyotsuEntity toEntity() {
        return this.entity.clone();
    }

    /**
     * 帳票制御共通の識別子{@link ChohyoSeigyoKyotsuIdentifier}を返します。
     *
     * @return 帳票制御共通の識別子{@link ChohyoSeigyoKyotsuIdentifier}
     */
    @Override
    public ChohyoSeigyoKyotsuIdentifier identifier() {
        return this.id;
    }

    /**
     * 保持する帳票制御共通を削除対象とします。<br/>
     * {@link DbT7065ChohyoSeigyoKyotsuEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば削除状態にします。
     *
     * @return 削除対象処理実施後の{@link ChohyoSeigyoKyotsu}
     */
    @Override
    public ChohyoSeigyoKyotsu deleted() {
        DbT7065ChohyoSeigyoKyotsuEntity deletedEntity = this.toEntity();
        if (deletedEntity.getState() != EntityDataState.Added) {
            deletedEntity.setState(EntityDataState.Deleted);
        } else {
            //TODO メッセージの検討
            throw new IllegalStateException(UrErrorMessages.不正.toString());
        }
        return new ChohyoSeigyoKyotsu(deletedEntity, id);
    }

    /**
     * {@link ChohyoSeigyoKyotsu}のシリアライズ形式を提供します。
     *
     * @return {@link ChohyoSeigyoKyotsu}のシリアライズ形式
     */
    protected Object writeReplace() {
        return new _SerializationProxy(entity, id);

    }

    @Override
    public boolean hasChanged() {
        throw new UnsupportedOperationException(); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * modifiedModel
     *
     * @return ChohyoSeigyoKyotsu
     */
    public ChohyoSeigyoKyotsu modifiedModel() {
        throw new UnsupportedOperationException(); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * getChohyoSeigyoKyotsuControlList
     *
     * @return ChohyoSeigyoKyotsuControlリスト
     */
    public List<ChohyoSeigyoKyotsuControl> getChohyoSeigyoKyotsuControlList() {
        throw new UnsupportedOperationException(); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * getChohyoSeigyoHanyoList
     *
     * @return ChohyoSeigyoHanyoリスト
     */
    public List<ChohyoSeigyoHanyo> getChohyoSeigyoHanyoList() {
        throw new UnsupportedOperationException(); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * modified
     *
     * @return ChohyoSeigyoKyotsu
     */
    public ChohyoSeigyoKyotsu modified() {
        throw new UnsupportedOperationException(); //To change body of generated methods, choose Tools | Templates.
    }

    private static final class _SerializationProxy implements Serializable {

        private static final long serialVersionUID = 1L;

        private final DbT7065ChohyoSeigyoKyotsuEntity entity;
        private final ChohyoSeigyoKyotsuIdentifier id;

        private _SerializationProxy(DbT7065ChohyoSeigyoKyotsuEntity entity, ChohyoSeigyoKyotsuIdentifier id) {
            this.entity = entity;
            this.id = id;
        }

        private Object readResolve() {
            return new ChohyoSeigyoKyotsu(this.entity, this.id);
        }
    }

    /**
     * このクラスの編集を行うBuilderを取得します。<br/>
     * 編集後のインスタンスを取得する場合は{@link SeishinTechoNini.createBuilderForEdit#build()}を使用してください。
     *
     * @return Builder
     */
    public ChohyoSeigyoKyotsuBuilder createBuilderForEdit() {
        return new ChohyoSeigyoKyotsuBuilder(entity, id);
    }

//TODO これはあくまでも雛形によるクラス生成です、必要な業務ロジックの追加、ValueObjectの導出を行う必要があります。
}
