/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5202NinteichosahyoGaikyoChosaEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.ModelBase;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 認定調査票（概況調査）（子）を管理するクラスです。
 */
public class NinteichosahyoGaikyoChosa extends
        ModelBase<NinteichosahyoGaikyoChosaIdentifier, DbT5202NinteichosahyoGaikyoChosaEntity, NinteichosahyoGaikyoChosa>
        implements Serializable {

    private final DbT5202NinteichosahyoGaikyoChosaEntity entity;
    private final NinteichosahyoGaikyoChosaIdentifier id;

    /**
     * コンストラクタです。<br/>
     * 認定調査票（概況調査）（子）の新規作成時に使用します。
     *
     * @param 申請書管理番号 申請書管理番号
     * @param 認定調査依頼履歴番号 認定調査依頼履歴番号
     * @param 概況調査テキストイメージ区分 概況調査テキストイメージ区分
     */
    public NinteichosahyoGaikyoChosa(ShinseishoKanriNo 申請書管理番号,
            int 認定調査依頼履歴番号,
            RString 概況調査テキストイメージ区分) {
        requireNonNull(申請書管理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("申請書管理番号"));
        requireNonNull(概況調査テキストイメージ区分, UrSystemErrorMessages.値がnull.getReplacedMessage("概況調査テキストイメージ区分"));
        this.entity = new DbT5202NinteichosahyoGaikyoChosaEntity();
        this.entity.setShinseishoKanriNo(申請書管理番号);
        this.entity.setNinteichosaRirekiNo(認定調査依頼履歴番号);
        this.entity.setGaikyoChosaTextImageKubun(概況調査テキストイメージ区分);
        this.id = new NinteichosahyoGaikyoChosaIdentifier(
                申請書管理番号,
                認定調査依頼履歴番号,
                概況調査テキストイメージ区分
        );
    }

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link DbT5202NinteichosahyoGaikyoChosaEntity}より{@link NinteichosahyoGaikyoChosa}を生成します。
     *
     * @param entity DBより取得した{@link DbT5202NinteichosahyoGaikyoChosaEntity}
     */
    public NinteichosahyoGaikyoChosa(DbT5202NinteichosahyoGaikyoChosaEntity entity) {
        this.entity = requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("認定調査票（概況調査）（子）"));
        this.id = new NinteichosahyoGaikyoChosaIdentifier(
                entity.getShinseishoKanriNo(),
                entity.getNinteichosaRirekiNo(),
                entity.getGaikyoChosaTextImageKubun());
    }

    /**
     * シリアライズ、ビルダー用コンストラクタです。
     *
     * @param entity {@link DbT5202NinteichosahyoGaikyoChosaEntity}
     * @param id {@link NinteichosahyoGaikyoChosaIdentifier}
     */
    NinteichosahyoGaikyoChosa(
            DbT5202NinteichosahyoGaikyoChosaEntity entity,
            NinteichosahyoGaikyoChosaIdentifier id
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
     * 認定調査依頼履歴番号を返します。
     *
     * @return 認定調査依頼履歴番号
     */
    public int get認定調査依頼履歴番号() {
        return entity.getNinteichosaRirekiNo();
    }

    /**
     * 概況調査テキストイメージ区分を返します。
     *
     * @return 概況調査テキストイメージ区分
     */
    public RString get概況調査テキストイメージ区分() {
        return entity.getGaikyoChosaTextImageKubun();
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
     * 認定調査依頼区分コードを返します。
     *
     * @return 認定調査依頼区分コード
     */
    public Code get認定調査依頼区分コード() {
        return entity.getNinteichousaIraiKubunCode();
    }

    /**
     * 認定調査回数を返します。
     *
     * @return 認定調査回数
     */
    public int get認定調査回数() {
        return entity.getNinteichosaIraiKaisu();
    }

    /**
     * 認定調査実施年月日を返します。
     *
     * @return 認定調査実施年月日
     */
    public FlexibleDate get認定調査実施年月日() {
        return entity.getNinteichosaJisshiYMD();
    }

    /**
     * 認定調査受領年月日を返します。
     *
     * @return 認定調査受領年月日
     */
    public FlexibleDate get認定調査受領年月日() {
        return entity.getNinteichosaJuryoYMD();
    }

    /**
     * 認定調査区分コードを返します。
     *
     * @return 認定調査区分コード
     */
    public Code get認定調査区分コード() {
        return entity.getNinteiChosaKubunCode();
    }

    /**
     * 認定調査委託先コードを返します。
     *
     * @return 認定調査委託先コード
     */
    public JigyoshaNo get認定調査委託先コード() {
        return entity.getChosaItakusakiCode();
    }

    /**
     * 認定調査員コードを返します。
     *
     * @return 認定調査員コード
     */
    public RString get認定調査員コード() {
        return entity.getChosainCode();
    }

    /**
     * 認定調査実施場所コードを返します。
     *
     * @return 認定調査実施場所コード
     */
    public Code get認定調査実施場所コード() {
        return entity.getChosaJisshiBashoCode();
    }

    /**
     * 認定調査実施場所名称を返します。
     *
     * @return 認定調査実施場所名称
     */
    public RString get認定調査実施場所名称() {
        return entity.getChosaJisshiBashoMeisho();
    }

    /**
     * 認定調査_サービス区分コードを返します。
     *
     * @return 認定調査_サービス区分コード
     */
    public Code get認定調査_サービス区分コード() {
        return entity.getServiceKubunCode();
    }

    /**
     * 利用施設名を返します。
     *
     * @return 利用施設名
     */
    public RString get利用施設名() {
        return entity.getRiyoShisetsuShimei();
    }

    /**
     * 利用施設住所を返します。
     *
     * @return 利用施設住所
     */
    public AtenaJusho get利用施設住所() {
        return new AtenaJusho(entity.getRiyoShisetsuJusho());
    }

    /**
     * 利用施設電話番号を返します。
     *
     * @return 利用施設電話番号
     */
    public TelNo get利用施設電話番号() {
        return new TelNo(entity.getRiyoShisetsuTelNo());
    }

    /**
     * 利用施設郵便番号を返します。
     *
     * @return 利用施設郵便番号
     */
    public YubinNo get利用施設郵便番号() {
        return entity.getRiyoShisetsuYubinNo();
    }

    /**
     * 特記を返します。
     *
     * @return 特記
     */
    public RString get特記() {
        return entity.getTokki();
    }

    /**
     * 認定調査特記事項受付年月日を返します。
     *
     * @return 認定調査特記事項受付年月日
     */
    public FlexibleDate get認定調査特記事項受付年月日() {
        return entity.getTokkijikoUketsukeYMD();
    }

    /**
     * 認定調査特記事項受領年月日を返します。
     *
     * @return 認定調査特記事項受領年月日
     */
    public FlexibleDate get認定調査特記事項受領年月日() {
        return entity.getTokkijikoJuryoYMD();
    }

    /**
     * {@link DbT5202NinteichosahyoGaikyoChosaEntity}のクローンを返します。
     *
     * @return {@link DbT5202NinteichosahyoGaikyoChosaEntity}のクローン
     */
    @Override
    public DbT5202NinteichosahyoGaikyoChosaEntity toEntity() {
        return this.entity.clone();
    }

    /**
     * 認定調査票（概況調査）（子）の識別子{@link NinteichosahyoGaikyoChosaIdentifier}を返します。
     *
     * @return 認定調査票（概況調査）（子）の識別子{@link NinteichosahyoGaikyoChosaIdentifier}
     */
    @Override
    public NinteichosahyoGaikyoChosaIdentifier identifier() {
        return this.id;
    }

    /**
     * 認定調査票（概況調査）（子）のみを変更対象とします。<br/>
     * {@link DbT5202NinteichosahyoGaikyoChosaEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば変更状態にします。
     *
     * @return 変更対象処理実施後の{@link NinteichosahyoGaikyoChosa}
     */
    public NinteichosahyoGaikyoChosa modifiedModel() {
        DbT5202NinteichosahyoGaikyoChosaEntity modifiedEntity = this.toEntity();
        if (!modifiedEntity.getState().equals(EntityDataState.Added)) {
            modifiedEntity.setState(EntityDataState.Modified);
        }
        return new NinteichosahyoGaikyoChosa(
                modifiedEntity, id);
    }

    /**
     * 保持する認定調査票（概況調査）（子）を削除対象とします。<br/>
     * {@link DbT5202NinteichosahyoGaikyoChosaEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば削除状態にします。
     *
     * @return 削除対象処理実施後の{@link NinteichosahyoGaikyoChosa}
     */
    @Override
    public NinteichosahyoGaikyoChosa deleted() {
        DbT5202NinteichosahyoGaikyoChosaEntity deletedEntity = this.toEntity();
        if (deletedEntity.getState() != EntityDataState.Added) {
            deletedEntity.setState(EntityDataState.Deleted);
        } else {
            //TODO メッセージの検討
            throw new IllegalStateException(UrErrorMessages.不正.toString());
        }
        return new NinteichosahyoGaikyoChosa(deletedEntity, id);
    }

    /**
     * {@link NinteichosahyoGaikyoChosa}のシリアライズ形式を提供します。
     *
     * @return {@link NinteichosahyoGaikyoChosa}のシリアライズ形式
     */
    protected Object writeReplace() {
        return new _SerializationProxy(entity, id);

    }

    @Override
    public boolean hasChanged() {
        return hasChangedEntity();
    }

    private static final class _SerializationProxy implements Serializable {

        private static final long serialVersionUID = 1L;
        private final DbT5202NinteichosahyoGaikyoChosaEntity entity;
        private final NinteichosahyoGaikyoChosaIdentifier id;

        private _SerializationProxy(DbT5202NinteichosahyoGaikyoChosaEntity entity, NinteichosahyoGaikyoChosaIdentifier id) {
            this.entity = entity;
            this.id = id;
        }

        private Object readResolve() {
            return new NinteichosahyoGaikyoChosa(this.entity, this.id);
        }
    }

    /**
     * このクラスの編集を行うBuilderを取得します。<br/>
     * 編集後のインスタンスを取得する場合は{@link SeishinTechoNini.createBuilderForEdit#build()}を使用してください。
     *
     * @return Builder
     */
    public NinteichosahyoGaikyoChosaBuilder createBuilderForEdit() {
        return new NinteichosahyoGaikyoChosaBuilder(entity, id);
    }

//TODO これはあくまでも雛形によるクラス生成です、必要な業務ロジックの追加、ValueObjectの導出を行う必要があります。
}
