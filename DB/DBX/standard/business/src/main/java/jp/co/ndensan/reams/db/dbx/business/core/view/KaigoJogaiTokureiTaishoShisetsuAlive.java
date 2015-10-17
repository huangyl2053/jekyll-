/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.business.core.view;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbx.business.core.uzclasses.ModelBase;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbV1005KaigoJogaiTokureiTaishoShisetsuEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 他市町村住所地特例者台帳管理Aliveを管理するクラスです。
 */
public class KaigoJogaiTokureiTaishoShisetsuAlive extends ModelBase<KaigoJogaiTokureiTaishoShisetsuAliveIdentifier, DbV1005KaigoJogaiTokureiTaishoShisetsuEntity, KaigoJogaiTokureiTaishoShisetsuAlive> implements Serializable {

    private final DbV1005KaigoJogaiTokureiTaishoShisetsuEntity entity;
    private final KaigoJogaiTokureiTaishoShisetsuAliveIdentifier id;

    /**
     * コンストラクタです。<br/>
     * 他市町村住所地特例者台帳管理Aliveの新規作成時に使用します。
     *
     * @param 事業者種別 事業者種別
     * @param 事業者番号 事業者番号
     * @param 有効開始年月日 有効開始年月日
     */
    public KaigoJogaiTokureiTaishoShisetsuAlive(RString 事業者種別,
            RString 事業者番号,
            FlexibleDate 有効開始年月日) {
        requireNonNull(事業者種別, UrSystemErrorMessages.値がnull.getReplacedMessage("事業者種別"));
        requireNonNull(事業者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("事業者番号"));
        requireNonNull(有効開始年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("有効開始年月日"));
        this.entity = new DbV1005KaigoJogaiTokureiTaishoShisetsuEntity();
        this.entity.setJigyoshaShubetsu(事業者種別);
        this.entity.setJigyoshaNo(事業者番号);
        this.entity.setYukoKaishiYMD(有効開始年月日);
        this.id = new KaigoJogaiTokureiTaishoShisetsuAliveIdentifier(
                事業者種別,
                事業者番号,
                有効開始年月日
        );
    }

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link DbV1005KaigoJogaiTokureiTaishoShisetsuEntity}より{@link KaigoJogaiTokureiTaishoShisetsuAlive}を生成します。
     *
     * @param entity
     * DBより取得した{@link DbV1005KaigoJogaiTokureiTaishoShisetsuEntity}
     */
    public KaigoJogaiTokureiTaishoShisetsuAlive(DbV1005KaigoJogaiTokureiTaishoShisetsuEntity entity) {
        this.entity = requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("他市町村住所地特例者台帳管理Alive"));
        this.id = new KaigoJogaiTokureiTaishoShisetsuAliveIdentifier(
                entity.getJigyoshaShubetsu(),
                entity.getJigyoshaNo(),
                entity.getYukoKaishiYMD());
    }

    /**
     * シリアライズ、ビルダー用コンストラクタです。
     *
     * @param entity {@link DbV1005KaigoJogaiTokureiTaishoShisetsuEntity}
     * @param id {@link KaigoJogaiTokureiTaishoShisetsuAliveIdentifier}
     */
    KaigoJogaiTokureiTaishoShisetsuAlive(
            DbV1005KaigoJogaiTokureiTaishoShisetsuEntity entity,
            KaigoJogaiTokureiTaishoShisetsuAliveIdentifier id
    ) {
        this.entity = entity;
        this.id = id;
    }

//TODO getterを見直してください。意味のある単位でValueObjectを作成して公開してください。
    /**
     * 事業者種別を返します。
     *
     * @return 事業者種別
     */
    public RString get事業者種別() {
        return entity.getJigyoshaShubetsu();
    }

    /**
     * 事業者番号を返します。
     *
     * @return 事業者番号
     */
    public RString get事業者番号() {
        return entity.getJigyoshaNo();
    }

    /**
     * 有効開始年月日を返します。
     *
     * @return 有効開始年月日
     */
    public FlexibleDate get有効開始年月日() {
        return entity.getYukoKaishiYMD();
    }

    /**
     * 有効終了年月日を返します。
     *
     * @return 有効終了年月日
     */
    public FlexibleDate get有効終了年月日() {
        return entity.getYukoShuryoYMD();
    }

    /**
     * 管内・管外区分を返します。
     *
     * @return 管内・管外区分
     */
    public RString get管内管外区分() {
        return entity.getKannaiKangaiKubun();
    }

    /**
     * 事業者名称を返します。
     *
     * @return 事業者名称
     */
    public AtenaMeisho get事業者名称() {
        return entity.getJigyoshaMeisho();
    }

    /**
     * 事業者名称カナを返します。
     *
     * @return 事業者名称カナ
     */
    public AtenaKanaMeisho get事業者名称カナ() {
        return entity.getJigyoshaKanaMeisho();
    }

    /**
     * 郵便番号を返します。
     *
     * @return 郵便番号
     */
    public YubinNo get郵便番号() {
        return entity.getYubinNo();
    }

    /**
     * 事業者住所を返します。
     *
     * @return 事業者住所
     */
    public RString get事業者住所() {
        return entity.getJigyoshaJusho();
    }

    /**
     * 事業者住所カナを返します。
     *
     * @return 事業者住所カナ
     */
    public RString get事業者住所カナ() {
        return entity.getJigyoshaKanaJusho();
    }

    /**
     * 電話番号を返します。
     *
     * @return 電話番号
     */
    public TelNo get電話番号() {
        return entity.getTelNo();
    }

    /**
     * FAX番号を返します。
     *
     * @return FAX番号
     */
    public TelNo getFAX番号() {
        return entity.getFaxNo();
    }

    /**
     * 異動事由を返します。
     *
     * @return 異動事由
     */
    public RString get異動事由() {
        return entity.getIdoJiyuCode();
    }

    /**
     * 異動年月日を返します。
     *
     * @return 異動年月日
     */
    public FlexibleDate get異動年月日() {
        return entity.getIdoYMD();
    }

    /**
     * 代表者名称を返します。
     *
     * @return 代表者名称
     */
    public AtenaMeisho get代表者名称() {
        return entity.getDaihyoshaMeisho();
    }

    /**
     * 代表者名称カナを返します。
     *
     * @return 代表者名称カナ
     */
    public AtenaKanaMeisho get代表者名称カナ() {
        return entity.getDaihyoshaKanaMeisho();
    }

    /**
     * 役職を返します。
     *
     * @return 役職
     */
    public RString get役職() {
        return entity.getYakushoku();
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
     * 事業開始年月日を返します。
     *
     * @return 事業開始年月日
     */
    public FlexibleDate get事業開始年月日() {
        return entity.getJigyoKaishiYMD();
    }

    /**
     * 事業休止年月日を返します。
     *
     * @return 事業休止年月日
     */
    public FlexibleDate get事業休止年月日() {
        return entity.getJigyoKyushiYMD();
    }

    /**
     * 事業廃止年月日を返します。
     *
     * @return 事業廃止年月日
     */
    public FlexibleDate get事業廃止年月日() {
        return entity.getJigyoHaishiYMD();
    }

    /**
     * 事業再開年月日を返します。
     *
     * @return 事業再開年月日
     */
    public FlexibleDate get事業再開年月日() {
        return entity.getJigyoSaikaiYMD();
    }

    /**
     * {@link DbV1005KaigoJogaiTokureiTaishoShisetsuEntity}のクローンを返します。
     *
     * @return {@link DbV1005KaigoJogaiTokureiTaishoShisetsuEntity}のクローン
     */
    @Override
    public DbV1005KaigoJogaiTokureiTaishoShisetsuEntity toEntity() {
        return this.entity.clone();
    }

    /**
     * 他市町村住所地特例者台帳管理Aliveの識別子{@link KaigoJogaiTokureiTaishoShisetsuAliveIdentifier}を返します。
     *
     * @return
     * 他市町村住所地特例者台帳管理Aliveの識別子{@link KaigoJogaiTokureiTaishoShisetsuAliveIdentifier}
     */
    @Override
    public KaigoJogaiTokureiTaishoShisetsuAliveIdentifier identifier() {
        return this.id;
    }

    /**
     * 保持する他市町村住所地特例者台帳管理Aliveを削除対象とします。<br/>
     * {@link DbV1005KaigoJogaiTokureiTaishoShisetsuEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば削除状態にします。
     *
     * @return 削除対象処理実施後の{@link KaigoJogaiTokureiTaishoShisetsuAlive}
     */
    @Override
    public KaigoJogaiTokureiTaishoShisetsuAlive deleted() {
        DbV1005KaigoJogaiTokureiTaishoShisetsuEntity deletedEntity = this.toEntity();
        if (deletedEntity.getState() != EntityDataState.Added) {
            deletedEntity.setState(EntityDataState.Deleted);
        } else {
            //TODO メッセージの検討
            throw new IllegalStateException(UrErrorMessages.不正.toString());
        }
        return new KaigoJogaiTokureiTaishoShisetsuAlive(deletedEntity, id);
    }

    /**
     * {@link KaigoJogaiTokureiTaishoShisetsuAlive}のシリアライズ形式を提供します。
     *
     * @return {@link KaigoJogaiTokureiTaishoShisetsuAlive}のシリアライズ形式
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

        private final DbV1005KaigoJogaiTokureiTaishoShisetsuEntity entity;
        private final KaigoJogaiTokureiTaishoShisetsuAliveIdentifier id;

        private _SerializationProxy(DbV1005KaigoJogaiTokureiTaishoShisetsuEntity entity, KaigoJogaiTokureiTaishoShisetsuAliveIdentifier id) {
            this.entity = entity;
            this.id = id;
        }

        private Object readResolve() {
            return new KaigoJogaiTokureiTaishoShisetsuAlive(this.entity, this.id);
        }
    }

    /**
     * このクラスの編集を行うBuilderを取得します。<br/>
     * 編集後のインスタンスを取得する場合は{@link SeishinTechoNini.createBuilderForEdit#build()}を使用してください。
     *
     * @return Builder
     */
    public KaigoJogaiTokureiTaishoShisetsuAliveBuilder createBuilderForEdit() {
        return new KaigoJogaiTokureiTaishoShisetsuAliveBuilder(entity, id);
    }

//TODO これはあくまでも雛形によるクラス生成です、必要な業務ロジックの追加、ValueObjectの導出を行う必要があります。
}
