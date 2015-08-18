/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.business.core.uzclasses.ModelBase;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT1005KaigoJogaiTokureiTaishoShisetsuEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 介護除外住所地特例対象施設を管理するクラスです。
 */
public class KaigoJogaiTokureiTaishoShisetsu extends ModelBase<KaigoJogaiTokureiTaishoShisetsuIdentifier, DbT1005KaigoJogaiTokureiTaishoShisetsuEntity, KaigoJogaiTokureiTaishoShisetsu> implements Serializable {

    private final DbT1005KaigoJogaiTokureiTaishoShisetsuEntity entity;
    private final KaigoJogaiTokureiTaishoShisetsuIdentifier id;

    /**
     * コンストラクタです。<br/>
     * 介護除外住所地特例対象施設の新規作成時に使用します。
     *
     * @param 事業者種別 事業者種別
     * @param 事業者番号 事業者番号
     * @param 有効開始年月日 有効開始年月日
     */
    public KaigoJogaiTokureiTaishoShisetsu(RString 事業者種別,
            RString 事業者番号,
            FlexibleDate 有効開始年月日) {
        requireNonNull(事業者種別, UrSystemErrorMessages.値がnull.getReplacedMessage("事業者種別"));
        requireNonNull(事業者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("事業者番号"));
        requireNonNull(有効開始年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("有効開始年月日"));
        this.entity = new DbT1005KaigoJogaiTokureiTaishoShisetsuEntity();
        this.entity.setJigyoshaShubetsu(事業者種別);
        this.entity.setJigyoshaNo(事業者番号);
        this.entity.setYukoKaishiYMD(有効開始年月日);
        this.id = new KaigoJogaiTokureiTaishoShisetsuIdentifier(
                事業者種別,
                事業者番号,
                有効開始年月日
        );
    }

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link DbT1005KaigoJogaiTokureiTaishoShisetsuEntity}より{@link KaigoJogaiTokureiTaishoShisetsu}を生成します。
     *
     * @param entity
     * DBより取得した{@link DbT1005KaigoJogaiTokureiTaishoShisetsuEntity}
     */
    public KaigoJogaiTokureiTaishoShisetsu(DbT1005KaigoJogaiTokureiTaishoShisetsuEntity entity) {
        this.entity = requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("介護除外住所地特例対象施設"));
        this.id = new KaigoJogaiTokureiTaishoShisetsuIdentifier(
                entity.getJigyoshaShubetsu(),
                entity.getJigyoshaNo(),
                entity.getYukoKaishiYMD());
    }

    /**
     * シリアライズ、ビルダー用コンストラクタです。
     *
     * @param entity {@link DbT1005KaigoJogaiTokureiTaishoShisetsuEntity}
     * @param id {@link KaigoJogaiTokureiTaishoShisetsuIdentifier}
     */
    KaigoJogaiTokureiTaishoShisetsu(
            DbT1005KaigoJogaiTokureiTaishoShisetsuEntity entity,
            KaigoJogaiTokureiTaishoShisetsuIdentifier id
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
     * @return 管内/管外区分
     */
    public RString get管内_管外区分() {
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
     * {@link DbT1005KaigoJogaiTokureiTaishoShisetsuEntity}のクローンを返します。
     *
     * @return {@link DbT1005KaigoJogaiTokureiTaishoShisetsuEntity}のクローン
     */
    @Override
    public DbT1005KaigoJogaiTokureiTaishoShisetsuEntity toEntity() {
        return this.entity.clone();
    }

    /**
     * 介護除外住所地特例対象施設の識別子{@link KaigoJogaiTokureiTaishoShisetsuIdentifier}を返します。
     *
     * @return
     * 介護除外住所地特例対象施設の識別子{@link KaigoJogaiTokureiTaishoShisetsuIdentifier}
     */
    @Override
    public KaigoJogaiTokureiTaishoShisetsuIdentifier identifier() {
        return this.id;
    }

    /**
     * {@link KaigoJogaiTokureiTaishoShisetsu}のシリアライズ形式を提供します。
     *
     * @return {@link KaigoJogaiTokureiTaishoShisetsu}のシリアライズ形式
     */
    protected Object writeReplace() {
        return new _SerializationProxy(entity, id);

    }

    @Override
    public boolean hasChanged() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public KaigoJogaiTokureiTaishoShisetsu deleted() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private static final class _SerializationProxy implements Serializable {

        private static final long serialVersionUID = 1L;

        private final DbT1005KaigoJogaiTokureiTaishoShisetsuEntity entity;
        private final KaigoJogaiTokureiTaishoShisetsuIdentifier id;

        private _SerializationProxy(DbT1005KaigoJogaiTokureiTaishoShisetsuEntity entity, KaigoJogaiTokureiTaishoShisetsuIdentifier id) {
            this.entity = entity;
            this.id = id;
        }

        private Object readResolve() {
            return new KaigoJogaiTokureiTaishoShisetsu(this.entity, this.id);
        }
    }

    /**
     * このクラスの編集を行うBuilderを取得します。<br/>
     * 編集後のインスタンスを取得する場合は{@link SeishinTechoNini.createBuilderForEdit#build()}を使用してください。
     *
     * @return Builder
     */
    public KaigoJogaiTokureiTaishoShisetsuBuilder createBuilderForEdit() {
        return new KaigoJogaiTokureiTaishoShisetsuBuilder(entity, id);
    }

//TODO これはあくまでも雛形によるクラス生成です、必要な業務ロジックの追加、ValueObjectの導出を行う必要があります。
}
