/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.business.core.fdz.uzclasskoho.IModel;
import jp.co.ndensan.reams.db.dbc.business.core.fdz.uzclasskoho.Models;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.dbc.DbT3038ShokanKihonEntity;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 償還払請求基本を管理するクラスです。
 */
public class ShokanKihon extends ParentModelBase<ShokanKihonIdentifier, DbT3038ShokanKihonEntity, ShokanKihon> implements Serializable {

    private final DbT3038ShokanKihonEntity entity;
    private final ShokanKihonIdentifier id;

    /**
     * コンストラクタです。<br/>
     * 償還払請求基本の新規作成時に使用します。
     *
     * @param 被保険者番号 被保険者番号
     * @param サービス提供年月 サービス提供年月
     * @param 整理番号 整理番号
     * @param 事業者番号 事業者番号
     * @param 様式番号 様式番号
     * @param 履歴番号 履歴番号
     */
    public ShokanKihon(HihokenshaNo 被保険者番号,
FlexibleYearMonth サービス提供年月,
RString 整理番号,
JigyoshaNo 事業者番号,
RString 様式番号,
Decimal 履歴番号) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(サービス提供年月, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス提供年月"));
        requireNonNull(整理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("整理番号"));
        requireNonNull(事業者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("事業者番号"));
        requireNonNull(様式番号, UrSystemErrorMessages.値がnull.getReplacedMessage("様式番号"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));
        this.entity = new DbT3038ShokanKihonEntity();
        this.entity.setHiHokenshaNo(被保険者番号);
        this.entity.setServiceTeikyoYM(サービス提供年月);
        this.entity.setSeiriNp(整理番号);
        this.entity.setJigyoshaNo(事業者番号);
        this.entity.setYoshikiNo(様式番号);
        this.entity.setRirekiNo(履歴番号);
        this.id = new ShokanKihonIdentifier(
        被保険者番号,
        サービス提供年月,
        整理番号,
        事業者番号,
        様式番号,
        履歴番号
                );
    }

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link DbT3038ShokanKihonEntity}より{@link ShokanKihon}を生成します。
     *
     * @param entity DBより取得した{@link DbT3038ShokanKihonEntity}
     */
    public ShokanKihon(DbT3038ShokanKihonEntity entity) {
        this.entity = requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("償還払請求基本"));
        this.id = new ShokanKihonIdentifier(
                entity.getHiHokenshaNo(),
                entity.getServiceTeikyoYM(),
                entity.getSeiriNp(),
                entity.getJigyoshaNo(),
                entity.getYoshikiNo(),
                entity.getRirekiNo());
    }

    /**
     * シリアライズ、ビルダー用コンストラクタです。
     *
     * @param entity {@link DbT3038ShokanKihonEntity}
     * @param id {@link ShokanKihonIdentifier}
     */
    ShokanKihon(
            DbT3038ShokanKihonEntity entity,
            ShokanKihonIdentifier id
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
        return entity.getHiHokenshaNo();
    }

    /**
     * サービス提供年月を返します。
     *
     * @return サービス提供年月
     */
    public FlexibleYearMonth getサービス提供年月() {
        return entity.getServiceTeikyoYM();
    }

    /**
     * 整理番号を返します。
     *
     * @return 整理番号
     */
    public RString get整理番号() {
        return entity.getSeiriNp();
    }

    /**
     * 事業者番号を返します。
     *
     * @return 事業者番号
     */
    public JigyoshaNo get事業者番号() {
        return entity.getJigyoshaNo();
    }

    /**
     * 様式番号を返します。
     *
     * @return 様式番号
     */
    public RString get様式番号() {
        return entity.getYoshikiNo();
    }

    /**
     * 履歴番号を返します。
     *
     * @return 履歴番号
     */
    public Decimal get履歴番号() {
        return entity.getRirekiNo();
    }

    /**
     * 旧措置入所者特例コードを返します。
     *
     * @return 旧措置入所者特例コード
     */
    public RString get旧措置入所者特例コード() {
        return entity.getKyuSochiNyushoshaTokureiCode();
    }

    /**
     * 居宅サービス計画作成区分コードを返します。
     *
     * @return 居宅サービス計画作成区分コード
     */
    public RString get居宅サービス計画作成区分コード() {
        return entity.getKyotakuServiceSakuseiKubunCode();
    }

    /**
     * 居宅サービス計画事業者番号を返します。
     *
     * @return 居宅サービス計画事業者番号
     */
    public JigyoshaNo get居宅サービス計画事業者番号() {
        return entity.getKyotakuserviceJigyoshaNo();
    }

    /**
     * 開始年月日を返します。
     *
     * @return 開始年月日
     */
    public FlexibleDate get開始年月日() {
        return entity.getKaishiYMD();
    }

    /**
     * 中止年月日を返します。
     *
     * @return 中止年月日
     */
    public FlexibleDate get中止年月日() {
        return entity.getChushiYMD();
    }

    /**
     * 中止理由・入所（院）前の状況コードを返します。
     *
     * @return 中止理由・入所（院）前の状況コード
     */
    public RString get中止理由・入所（院）前の状況コード() {
        return entity.getChushiRiyuNyushomaeJyokyoCode();
    }

    /**
     * 入所（院）年月日を返します。
     *
     * @return 入所（院）年月日
     */
    public FlexibleDate get入所（院）年月日() {
        return entity.getNyushoYMD();
    }

    /**
     * 退所（院）年月日を返します。
     *
     * @return 退所（院）年月日
     */
    public FlexibleDate get退所（院）年月日() {
        return entity.getTaishoYMD();
    }

    /**
     * 入所（院）実日数を返します。
     *
     * @return 入所（院）実日数
     */
    public Decimal get入所（院）実日数() {
        return entity.getNyushoJitsuNissu();
    }

    /**
     * 外泊日数を返します。
     *
     * @return 外泊日数
     */
    public Decimal get外泊日数() {
        return entity.getGaihakuNissu();
    }

    /**
     * 退所（院）後の状態コードを返します。
     *
     * @return 退所（院）後の状態コード
     */
    public RString get退所（院）後の状態コード() {
        return entity.getTaishogoJotaiCode();
    }

    /**
     * 保険給付率を返します。
     *
     * @return 保険給付率
     */
    public HokenKyufuRitsu get保険給付率() {
        return entity.getHokenKyufuritsu();
    }

    /**
     * サービス単位数を返します。
     *
     * @return サービス単位数
     */
    public int getサービス単位数() {
        return entity.getServiceTanisu();
    }

    /**
     * 保険請求額を返します。
     *
     * @return 保険請求額
     */
    public Decimal get保険請求額() {
        return entity.getHokenSeikyugaku();
    }

    /**
     * 利用者負担額を返します。
     *
     * @return 利用者負担額
     */
    public int get利用者負担額() {
        return entity.getRiyoshaFutangaku();
    }

    /**
     * 緊急時施設療養費請求額を返します。
     *
     * @return 緊急時施設療養費請求額
     */
    public Decimal get緊急時施設療養費請求額() {
        return entity.getKinkyuShisetsuRyoyoSeikyugaku();
    }

    /**
     * 特定診療費請求額を返します。
     *
     * @return 特定診療費請求額
     */
    public Decimal get特定診療費請求額() {
        return entity.getTokuteiShinryoSeikyugaku();
    }

    /**
     * 特定入所者介護サービス費等請求額を返します。
     *
     * @return 特定入所者介護サービス費等請求額
     */
    public int get特定入所者介護サービス費等請求額() {
        return entity.getTokuteiNyushoshaKaigoServiceSeikyugaku();
    }

    /**
     * {@link DbT3038ShokanKihonEntity}のクローンを返します。
     *
     * @return {@link DbT3038ShokanKihonEntity}のクローン
     */
    @Override
    public DbT3038ShokanKihonEntity toEntity() {
        return this.entity.clone();
    }

    /**
     * 償還払請求基本の識別子{@link ShokanKihonIdentifier}を返します。
     *
     * @return 償還払請求基本の識別子{@link ShokanKihonIdentifier}
     */
    @Override
    public ShokanKihonIdentifier identifier() {
        return this.id;
    }

    /**
     * 償還払請求基本のみを変更対象とします。<br/>
     * {@link DbT3038ShokanKihonEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば変更状態にします。
     *
     * @return 変更対象処理実施後の{@link ShokanKihon}
     */
    @Override
    public ShokanKihon modifiedModel() {
        DbT3038ShokanKihonEntity modifiedEntity = this.toEntity();
        if (!modifiedEntity.getState().equals(EntityDataState.Added)) {
            modifiedEntity.setState(EntityDataState.Modified);
        }
        return new ShokanKihon(
                modifiedEntity, id);
    }

    /**
     * 保持する償還払請求基本を削除対象とします。<br/>
     * {@link DbT3038ShokanKihonEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば削除状態にします。
     *
     * @return 削除対象処理実施後の{@link ShokanKihon}
     */
    @Override
    public ShokanKihon deleted() {
        DbT3038ShokanKihonEntity deletedEntity = this.toEntity();
        if (deletedEntity.getState() != EntityDataState.Added) {
            deletedEntity.setState(EntityDataState.Deleted);
        } else {
            //TODO メッセージの検討
            throw new IllegalStateException(UrErrorMessages.不正.toString());
        }
        return new ShokanKihon(deletedEntity, id);
    }
    /**
     * {@link ShokanKihon}のシリアライズ形式を提供します。
     *
     * @return {@link ShokanKihon}のシリアライズ形式
     */
    protected Object writeReplace() {
        return new _SerializationProxy(entity, id);

    }

    private static final class _SerializationProxy implements Serializable {

        private static final long serialVersionUID = // TODO serialVersionUIDを生成してください
        private final DbT3038ShokanKihonEntity entity;
        private final ShokanKihonIdentifier id;

        private _SerializationProxy(DbT3038ShokanKihonEntity entity,ShokanKihonIdentifier id) {
            this.entity = entity;
            this.id = id;
        }

        private Object readResolve() {
            return new ShokanKihon(this.entity, this.id);
        }
    }

    /**
     * このクラスの編集を行うBuilderを取得します。<br/>
     * 編集後のインスタンスを取得する場合は{@link SeishinTechoNini.createBuilderForEdit#build()}を使用してください。
     *
     * @return Builder
     */
    public ShokanKihonBuilder createBuilderForEdit() {
        return new ShokanKihonBuilder(entity, id);
    }

//TODO これはあくまでも雛形によるクラス生成です、必要な業務ロジックの追加、ValueObjectの導出を行う必要があります。
}
