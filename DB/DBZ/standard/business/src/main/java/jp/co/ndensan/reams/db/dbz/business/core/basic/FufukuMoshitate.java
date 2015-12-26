/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import java.io.Serializable;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbz.business.core.uzclasses.ParentModelBase;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7001FufukuMoshitateEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 不服審査申立情報を管理するクラスです。
 */
public class FufukuMoshitate extends
        ParentModelBase<FufukuMoshitateIdentifier, DbT7001FufukuMoshitateEntity, FufukuMoshitate> implements Serializable {

    private final DbT7001FufukuMoshitateEntity entity;
    private final FufukuMoshitateIdentifier id;

    /**
     * コンストラクタです。<br/>
     * 不服審査申立情報の新規作成時に使用します。
     *
     * @param 証記載保険者番号 証記載保険者番号
     * @param 識別コード 識別コード
     * @param 原処分被保険者番号 原処分被保険者番号
     * @param 審査請求届出日 審査請求届出日
     */
    public FufukuMoshitate(ShoKisaiHokenshaNo 証記載保険者番号,
            ShikibetsuCode 識別コード,
            HihokenshaNo 原処分被保険者番号,
            FlexibleDate 審査請求届出日) {
        requireNonNull(証記載保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("証記載保険者番号"));
        requireNonNull(識別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("識別コード"));
        requireNonNull(原処分被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("原処分被保険者番号"));
        requireNonNull(審査請求届出日, UrSystemErrorMessages.値がnull.getReplacedMessage("審査請求届出日"));
        this.entity = new DbT7001FufukuMoshitateEntity();
       // this.entity.setShoKisaiHokenshaNo(証記載保険者番号);
        this.entity.setShikibetsuCode(識別コード);
        this.entity.setGenshobunsHihokennshaNo(原処分被保険者番号);
        this.entity.setShinsaSeikyuTodokedeYMD(審査請求届出日);
        this.id = new FufukuMoshitateIdentifier(
                証記載保険者番号,
                識別コード,
                原処分被保険者番号,
                審査請求届出日
        );
    }

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link DbT7001FufukuMoshitateEntity}より{@link FufukuMoshitate}を生成します。
     *
     * @param entity DBより取得した{@link DbT7001FufukuMoshitateEntity}
     */
    public FufukuMoshitate(DbT7001FufukuMoshitateEntity entity) {
        this.entity = requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("不服審査申立情報"));
        this.id = new FufukuMoshitateIdentifier(
                new ShoKisaiHokenshaNo(""),
                entity.getShikibetsuCode(),
                entity.getGenshobunsHihokennshaNo(),
                entity.getShinsaSeikyuTodokedeYMD());
    }

    /**
     * シリアライズ、ビルダー用コンストラクタです。
     *
     * @param entity {@link DbT7001FufukuMoshitateEntity}
     * @param id {@link FufukuMoshitateIdentifier}
     */
    FufukuMoshitate(
            DbT7001FufukuMoshitateEntity entity,
            FufukuMoshitateIdentifier id
    ) {
        this.entity = entity;
        this.id = id;
    }

//TODO getterを見直してください。意味のある単位でValueObjectを作成して公開してください。
    /**
     * 証記載保険者番号を返します。
     *
     * @return 証記載保険者番号
     */
//    public ShoKisaiHokenshaNo get証記載保険者番号() {
//        return entity.getShoKisaiHokenshaNo();
//    }

    /**
     * 識別コードを返します。
     *
     * @return 識別コード
     */
    public ShikibetsuCode get識別コード() {
        return entity.getShikibetsuCode();
    }

    /**
     * 原処分被保険者番号を返します。
     *
     * @return 原処分被保険者番号
     */
    public HihokenshaNo get原処分被保険者番号() {
        return entity.getGenshobunsHihokennshaNo();
    }

    /**
     * 審査請求届出日を返します。
     *
     * @return 審査請求届出日
     */
    public FlexibleDate get審査請求届出日() {
        return entity.getShinsaSeikyuTodokedeYMD();
    }

    /**
     * 原処分被保険者郵便番号を返します。
     *
     * @return 原処分被保険者郵便番号
     */
//    public YubinNo get原処分被保険者郵便番号() {
//        return entity.getGenshobunHihokenshaYubinNo();
//    }
//
//    /**
//     * 原処分被保険者住所を返します。
//     *
//     * @return 原処分被保険者住所
//     */
//    public AtenaJusho get原処分被保険者住所() {
//        return entity.getGenshobunHihokenshaJusho();
//    }

    /**
     * 原処分被保険者氏名を返します。
     *
     * @return 原処分被保険者氏名
     */
//    public AtenaMeisho get原処分被保険者氏名() {
//        return entity.getGenshobunHihokenshaShimei();
//    }

    /**
     * 原処分被保険者電話番号を返します。
     *
     * @return 原処分被保険者電話番号
     */
//    public TelNo get原処分被保険者電話番号() {
//        return entity.getGenshobunHihokenshaTelNo();
//    }

    /**
     * 原処分被保険者生年月日を返します。
     *
     * @return 原処分被保険者生年月日
     */
//    public FlexibleDate get原処分被保険者生年月日() {
//        return entity.getGenshobunHihokenshaBirthYMD();
//    }

    /**
     * 審査請求人郵便番号を返します。
     *
     * @return 審査請求人郵便番号
     */
    public YubinNo get審査請求人郵便番号() {
        return entity.getShinsaSeikyuninYubinNo();
    }

    /**
     * 審査請求人住所を返します。
     *
     * @return 審査請求人住所
     */
    public AtenaJusho get審査請求人住所() {
        return entity.getShinsaSeikyuninJusho();
    }

    /**
     * 審査請求人氏名を返します。
     *
     * @return 審査請求人氏名
     */
    public AtenaMeisho get審査請求人氏名() {
        return entity.getShinsaSeikyuninShimei();
    }

    /**
     * 審査請求人電話番号を返します。
     *
     * @return 審査請求人電話番号
     */
    public TelNo get審査請求人電話番号() {
        return entity.getShinsaSeikyuninTelNo();
    }

    /**
     * 被保険者との関係コードを返します。
     *
     * @return 被保険者との関係コード
     */
//    public Code get被保険者との関係コード() {
//        return entity.getHihokenshaTonoKankeiCode();
//    }

    /**
     * 代理人郵便番号を返します。
     *
     * @return 代理人郵便番号
     */
    public YubinNo get代理人郵便番号() {
        return entity.getDairininYubinNo();
    }

    /**
     * 代理人住所を返します。
     *
     * @return 代理人住所
     */
    public AtenaJusho get代理人住所() {
        return entity.getDairininJusho();
    }

    /**
     * 代理人氏名を返します。
     *
     * @return 代理人氏名
     */
    public AtenaMeisho get代理人氏名() {
        return entity.getDairininShimei();
    }

    /**
     * 代理人電話番号を返します。
     *
     * @return 代理人電話番号
     */
    public TelNo get代理人電話番号() {
        return entity.getDairininTelNo();
    }

    /**
     * 処分庁を返します。
     *
     * @return 処分庁
     */
    public RString get処分庁() {
        return entity.getShobunCho();
    }

    /**
     * 処分日を返します。
     *
     * @return 処分日
     */
    public FlexibleDate get処分日() {
        return entity.getShobunYMD();
    }

    /**
     * 処分種類コードを返します。
     *
     * @return 処分種類コード
     */
//    public Code get処分種類コード() {
//        return entity.getShobunShuruiCode();
//    }

    /**
     * 処分があったことを知った日を返します。
     *
     * @return 処分があったことを知った日
     */
    public FlexibleDate get処分があったことを知った日() {
        return entity.getShobunKakuninYMD();
    }

    /**
     * 審査請求の理由を返します。
     *
     * @return 審査請求の理由
     */
    public RString get審査請求の理由() {
        return entity.getShinsaSeikyuRiyu();
    }

    /**
     * 処分庁教示の有無及び教示の内容を返します。
     *
     * @return 処分庁教示の有無及び教示の内容
     */
    public RString get処分庁教示の有無及び教示の内容() {
        return entity.getShobunChoKyojiNaiyo();
    }

    /**
     * 添付書類等を返します。
     *
     * @return 添付書類等
     */
    public boolean is添付書類等() {
        return entity.getTempuShoruiTo();
    }

    /**
     * 審査請求取下日を返します。
     *
     * @return 審査請求取下日
     */
    public FlexibleDate get審査請求取下日() {
        return entity.getShinsaSeikyuTorisageYMD();
    }

    /**
     * 弁明書登録フラグを返します。
     *
     * @return 弁明書登録フラグ
     */
    public boolean is弁明書登録フラグ() {
        return entity.getBemmeishoTorokuFlag();
    }

    /**
     * 弁明書作成日を返します。
     *
     * @return 弁明書作成日
     */
    public FlexibleDate get弁明書作成日() {
        return entity.getBemmeishoSakuseiYMD();
    }

    /**
     * 裁決日を返します。
     *
     * @return 裁決日
     */
    public FlexibleDate get裁決日() {
        return entity.getSaiketsuYMD();
    }

    /**
     * 裁決結果を返します。
     *
     * @return 裁決結果
     */
    public RString get裁決結果() {
        return entity.getSaiketsuKekka();
    }

    /**
     * 裁決理由を返します。
     *
     * @return 裁決理由
     */
    public RString get裁決理由() {
        return entity.getSaiketsuRiyu();
    }

    /**
     * {@link DbT7001FufukuMoshitateEntity}のクローンを返します。
     *
     * @return {@link DbT7001FufukuMoshitateEntity}のクローン
     */
    @Override
    public DbT7001FufukuMoshitateEntity toEntity() {
        return this.entity.clone();
    }

    /**
     * 不服審査申立情報の識別子{@link FufukuMoshitateIdentifier}を返します。
     *
     * @return 不服審査申立情報の識別子{@link FufukuMoshitateIdentifier}
     */
    @Override
    public FufukuMoshitateIdentifier identifier() {
        return this.id;
    }

    /**
     * 不服審査申立情報のみを変更対象とします。<br/>
     * {@link DbT7001FufukuMoshitateEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば変更状態にします。
     *
     * @return 変更対象処理実施後の{@link FufukuMoshitate}
     */
    @Override
    public FufukuMoshitate modifiedModel() {
        DbT7001FufukuMoshitateEntity modifiedEntity = this.toEntity();
        if (!modifiedEntity.getState().equals(EntityDataState.Added)) {
            modifiedEntity.setState(EntityDataState.Modified);
        }
        return new FufukuMoshitate(
                modifiedEntity, id);
    }

    /**
     * 保持する不服審査申立情報を削除対象とします。<br/>
     * {@link DbT7001FufukuMoshitateEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば削除状態にします。
     *
     * @return 削除対象処理実施後の{@link FufukuMoshitate}
     */
    @Override
    public FufukuMoshitate deleted() {
        DbT7001FufukuMoshitateEntity deletedEntity = this.toEntity();
        if (deletedEntity.getState() != EntityDataState.Added) {
            deletedEntity.setState(EntityDataState.Deleted);
        } else {
            //TODO メッセージの検討
            throw new IllegalStateException(UrErrorMessages.不正.toString());
        }
        return new FufukuMoshitate(deletedEntity, id);
    }

    /**
     * {@link FufukuMoshitate}のシリアライズ形式を提供します。
     *
     * @return {@link FufukuMoshitate}のシリアライズ形式
     */
    protected Object writeReplace() {
        return new _SerializationProxy(entity, id);

    }

    @Override
    public boolean hasChanged() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * getBemmeiNaiyoList
     *
     * @return BemmeiNaiyoリスト
     */
    public List<BemmeiNaiyo> getBemmeiNaiyoList() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * modified
     *
     * @return FufukuMoshitate
     */
    public FufukuMoshitate modified() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private static final class _SerializationProxy implements Serializable {

        private static final long serialVersionUID = 1L;

        private final DbT7001FufukuMoshitateEntity entity;
        private final FufukuMoshitateIdentifier id;

        private _SerializationProxy(DbT7001FufukuMoshitateEntity entity, FufukuMoshitateIdentifier id) {
            this.entity = entity;
            this.id = id;
        }

        private Object readResolve() {
            return new FufukuMoshitate(this.entity, this.id);
        }
    }

    /**
     * このクラスの編集を行うBuilderを取得します。<br/>
     * 編集後のインスタンスを取得する場合は{@link SeishinTechoNini.createBuilderForEdit#build()}を使用してください。
     *
     * @return Builder
     */
    public FufukuMoshitateBuilder createBuilderForEdit() {
        return new FufukuMoshitateBuilder(entity, id);
    }

//TODO これはあくまでも雛形によるクラス生成です、必要な業務ロジックの追加、ValueObjectの導出を行う必要があります。
}
