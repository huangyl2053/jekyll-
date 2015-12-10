///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package jp.co.ndensan.reams.db.dbz.business.core.basic;
//
//import java.io.Serializable;
//import static java.util.Objects.requireNonNull;
//import jp.co.ndensan.reams.db.dbz.business.core.uzclasses.ParentModelBase;
//import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
//import jp.co.ndensan.reams.db.dbz.definition.core.valueobject.ninteishinsei.ChosaItakusakiCode;
//import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5910NinteichosaItakusakiJohoEntity;
//import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
//import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
//import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
//import jp.co.ndensan.reams.uz.uza.biz.ChikuCode;
//import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
//import jp.co.ndensan.reams.uz.uza.biz.TelNo;
//import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
//import jp.co.ndensan.reams.uz.uza.lang.RString;
//import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
//
///**
// * 認定調査委託先情報を管理するクラスです。
// */
//public class NinteichosaItakusakiJoho extends
//        ParentModelBase<NinteichosaItakusakiJohoIdentifier, DbT5910NinteichosaItakusakiJohoEntity, NinteichosaItakusakiJoho>
//        implements Serializable {
//
//    private final DbT5910NinteichosaItakusakiJohoEntity entity;
//    private final NinteichosaItakusakiJohoIdentifier id;
//
//    /**
//     * コンストラクタです。<br/>
//     * 認定調査委託先情報の新規作成時に使用します。
//     *
//     * @param 市町村コード 市町村コード
//     * @param 認定調査委託先コード 認定調査委託先コード
//     */
//    public NinteichosaItakusakiJoho(LasdecCode 市町村コード,
//            ChosaItakusakiCode 認定調査委託先コード) {
//        requireNonNull(市町村コード, UrSystemErrorMessages.値がnull.getReplacedMessage("市町村コード"));
//        requireNonNull(認定調査委託先コード, UrSystemErrorMessages.値がnull.getReplacedMessage("認定調査委託先コード"));
//        this.entity = new DbT5910NinteichosaItakusakiJohoEntity();
//        this.entity.setShichosonCode(市町村コード);
//        this.entity.setNinteichosaItakusakiCode(認定調査委託先コード);
//        this.id = new NinteichosaItakusakiJohoIdentifier(
//                市町村コード,
//                認定調査委託先コード
//        );
//    }
//
//    /**
//     * コンストラクタです。<br/>
//     * DBより取得した{@link DbT5910NinteichosaItakusakiJohoEntity}より{@link NinteichosaItakusakiJoho}を生成します。
//     *
//     * @param entity DBより取得した{@link DbT5910NinteichosaItakusakiJohoEntity}
//     */
//    public NinteichosaItakusakiJoho(DbT5910NinteichosaItakusakiJohoEntity entity) {
//        this.entity = requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("認定調査委託先情報"));
//        this.id = new NinteichosaItakusakiJohoIdentifier(
//                entity.getShichosonCode(),
//                entity.getNinteichosaItakusakiCode());
//    }
//
//    /**
//     * シリアライズ、ビルダー用コンストラクタです。
//     *
//     * @param entity {@link DbT5910NinteichosaItakusakiJohoEntity}
//     * @param id {@link NinteichosaItakusakiJohoIdentifier}
//     */
//    NinteichosaItakusakiJoho(
//            DbT5910NinteichosaItakusakiJohoEntity entity,
//            NinteichosaItakusakiJohoIdentifier id
//    ) {
//        this.entity = entity;
//        this.id = id;
//    }
//
////TODO getterを見直してください。意味のある単位でValueObjectを作成して公開してください。
//    /**
//     * 市町村コードを返します。
//     *
//     * @return 市町村コード
//     */
//    public LasdecCode get市町村コード() {
//        return entity.getShichosonCode();
//    }
//
//    /**
//     * 認定調査委託先コードを返します。
//     *
//     * @return 認定調査委託先コード
//     */
//    public ChosaItakusakiCode get認定調査委託先コード() {
//        return entity.getNinteichosaItakusakiCode();
//    }
//
//    /**
//     * 事業者番号を返します。
//     *
//     * @return 事業者番号
//     */
//    public JigyoshaNo get事業者番号() {
//        return entity.getJigyoshaNo();
//    }
//
//    /**
//     * 事業者名称を返します。
//     *
//     * @return 事業者名称
//     */
//    public RString get事業者名称() {
//        return entity.getJigyoshaMeisho();
//    }
//
//    /**
//     * 事業者名称カナを返します。
//     *
//     * @return 事業者名称カナ
//     */
//    public RString get事業者名称カナ() {
//        return entity.getJigyoshaMeishoKana();
//    }
//
//    /**
//     * 郵便番号を返します。
//     *
//     * @return 郵便番号
//     */
//    public YubinNo get郵便番号() {
//        return entity.getYubinNo();
//    }
//
//    /**
//     * 住所を返します。
//     *
//     * @return 住所
//     */
//    public RString get住所() {
//        return entity.getJusho();
//    }
//
//    /**
//     * 電話番号を返します。
//     *
//     * @return 電話番号
//     */
//    public TelNo get電話番号() {
//        return entity.getTelNo();
//    }
//
//    /**
//     * FAX番号を返します。
//     *
//     * @return FAX番号
//     */
//    public TelNo getFAX番号() {
//        return entity.getFaxNo();
//    }
//
//    /**
//     * 代表者名を返します。
//     *
//     * @return 代表者名
//     */
//    public AtenaMeisho get代表者名() {
//        return entity.getDaihyoshaName();
//    }
//
//    /**
//     * 調査委託区分を返します。
//     *
//     * @return 調査委託区分
//     */
//    public RString get調査委託区分() {
//        return entity.getChosaItakuKubun();
//    }
//
//    /**
//     * 割付定員を返します。
//     *
//     * @return 割付定員
//     */
//    public int get割付定員() {
//        return entity.getWaritsukeTeiin();
//    }
//
//    /**
//     * 割付地区を返します。
//     *
//     * @return 割付地区
//     */
//    public ChikuCode get割付地区() {
//        return entity.getWaritsukeChiku();
//    }
//
//    /**
//     * 自動割付フラグを返します。
//     *
//     * @return 自動割付フラグ
//     */
//    public boolean is自動割付フラグ() {
//        return entity.getAutoWaritsukeFlag();
//    }
//
//    /**
//     * 機関の区分を返します。
//     *
//     * @return 機関の区分
//     */
//    public RString get機関の区分() {
//        return entity.getKikanKubun();
//    }
//
//    /**
//     * 状況フラグを返します。
//     *
//     * @return 状況フラグ
//     */
//    public boolean is状況フラグ() {
//        return entity.getJokyoFlag();
//    }
//
//    /**
//     * {@link DbT5910NinteichosaItakusakiJohoEntity}のクローンを返します。
//     *
//     * @return {@link DbT5910NinteichosaItakusakiJohoEntity}のクローン
//     */
//    @Override
//    public DbT5910NinteichosaItakusakiJohoEntity toEntity() {
//        return this.entity.clone();
//    }
//
//    /**
//     * 認定調査委託先情報の識別子{@link NinteichosaItakusakiJohoIdentifier}を返します。
//     *
//     * @return 認定調査委託先情報の識別子{@link NinteichosaItakusakiJohoIdentifier}
//     */
//    @Override
//    public NinteichosaItakusakiJohoIdentifier identifier() {
//        return this.id;
//    }
//
//    /**
//     * 認定調査委託先情報のみを変更対象とします。<br/>
//     * {@link DbT5910NinteichosaItakusakiJohoEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば変更状態にします。
//     *
//     * @return 変更対象処理実施後の{@link NinteichosaItakusakiJoho}
//     */
//    @Override
//    public NinteichosaItakusakiJoho modifiedModel() {
//        DbT5910NinteichosaItakusakiJohoEntity modifiedEntity = this.toEntity();
//        if (!modifiedEntity.getState().equals(EntityDataState.Added)) {
//            modifiedEntity.setState(EntityDataState.Modified);
//        }
//        return new NinteichosaItakusakiJoho(
//                modifiedEntity, id);
//    }
//
//    /**
//     * 保持する認定調査委託先情報を削除対象とします。<br/>
//     * {@link DbT5910NinteichosaItakusakiJohoEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば削除状態にします。
//     *
//     * @return 削除対象処理実施後の{@link NinteichosaItakusakiJoho}
//     */
//    @Override
//    public NinteichosaItakusakiJoho deleted() {
//        DbT5910NinteichosaItakusakiJohoEntity deletedEntity = this.toEntity();
//        if (deletedEntity.getState() != EntityDataState.Added) {
//            deletedEntity.setState(EntityDataState.Deleted);
//        } else {
//            //TODO メッセージの検討
//            throw new IllegalStateException(UrErrorMessages.不正.toString());
//        }
//        return new NinteichosaItakusakiJoho(deletedEntity, id);
//    }
//
//    /**
//     * {@link NinteichosaItakusakiJoho}のシリアライズ形式を提供します。
//     *
//     * @return {@link NinteichosaItakusakiJoho}のシリアライズ形式
//     */
//    protected Object writeReplace() {
//        return new _SerializationProxy(entity, id);
//
//    }
//
//    @Override
//    public boolean hasChanged() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    private static final class _SerializationProxy implements Serializable {
//
//        private static final long serialVersionUID = 1L;
//        private final DbT5910NinteichosaItakusakiJohoEntity entity;
//        private final NinteichosaItakusakiJohoIdentifier id;
//
//        private _SerializationProxy(DbT5910NinteichosaItakusakiJohoEntity entity, NinteichosaItakusakiJohoIdentifier id) {
//            this.entity = entity;
//            this.id = id;
//        }
//
//        private Object readResolve() {
//            return new NinteichosaItakusakiJoho(this.entity, this.id);
//        }
//    }
//
//    /**
//     * このクラスの編集を行うBuilderを取得します。<br/>
//     * 編集後のインスタンスを取得する場合は{@link SeishinTechoNini.createBuilderForEdit#build()}を使用してください。
//     *
//     * @return Builder
//     */
//    public NinteichosaItakusakiJohoBuilder createBuilderForEdit() {
//        return new NinteichosaItakusakiJohoBuilder(entity, id);
//    }
//
////TODO これはあくまでも雛形によるクラス生成です、必要な業務ロジックの追加、ValueObjectの導出を行う必要があります。
//}
