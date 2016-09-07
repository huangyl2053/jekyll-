/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3118ShikibetsuNoKanriEntity;
import jp.co.ndensan.reams.db.dbz.business.core.uzclasses.ModelBase;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 識別番号管理を管理するクラスです。
 *
 * @reamsid_L DBC-9999-012 xicongwang
 */
public class ShikibetsuNoKanri extends ModelBase<ShikibetsuNoKanriIdentifier, DbT3118ShikibetsuNoKanriEntity, ShikibetsuNoKanri>
        implements Serializable {

    private final DbT3118ShikibetsuNoKanriEntity entity;
    private final ShikibetsuNoKanriIdentifier id;

    /**
     * コンストラクタです。<br/>
     * 識別番号管理の新規作成時に使用します。
     *
     * @param 識別番号 識別番号
     * @param 適用開始年月 適用開始年月
     */
    public ShikibetsuNoKanri(RString 識別番号,
            FlexibleYearMonth 適用開始年月) {
        requireNonNull(識別番号, UrSystemErrorMessages.値がnull.getReplacedMessage("識別番号"));
        requireNonNull(適用開始年月, UrSystemErrorMessages.値がnull.getReplacedMessage("適用開始年月"));
        this.entity = new DbT3118ShikibetsuNoKanriEntity();
        this.entity.setShikibetsuNo(識別番号);
        this.entity.setTekiyoKaishiYM(適用開始年月);
        this.id = new ShikibetsuNoKanriIdentifier(
                識別番号,
                適用開始年月
        );
    }

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link DbT3118ShikibetsuNoKanriEntity}より{@link ShikibetsuNoKanri}を生成します。
     *
     * @param entity DBより取得した{@link DbT3118ShikibetsuNoKanriEntity}
     */
    public ShikibetsuNoKanri(DbT3118ShikibetsuNoKanriEntity entity) {
        this.entity = requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("識別番号管理"));
        this.id = new ShikibetsuNoKanriIdentifier(
                entity.getShikibetsuNo(),
                entity.getTekiyoKaishiYM());
    }

    /**
     * シリアライズ、ビルダー用コンストラクタです。
     *
     * @param entity {@link DbT3118ShikibetsuNoKanriEntity}
     * @param id {@link ShikibetsuNoKanriIdentifier}
     */
    ShikibetsuNoKanri(
            DbT3118ShikibetsuNoKanriEntity entity,
            ShikibetsuNoKanriIdentifier id
    ) {
        this.entity = entity;
        this.id = id;
    }

//TODO getterを見直してください。意味のある単位でValueObjectを作成して公開してください。
    /**
     * 識別番号を返します。
     *
     * @return 識別番号
     */
    public RString get識別番号() {
        return entity.getShikibetsuNo();
    }

    /**
     * 適用開始年月を返します。
     *
     * @return 適用開始年月
     */
    public FlexibleYearMonth get適用開始年月() {
        return entity.getTekiyoKaishiYM();
    }

    /**
     * 適用終了年月を返します。
     *
     * @return 適用終了年月
     */
    public FlexibleYearMonth get適用終了年月() {
        return entity.getTekiyoShuryoYM();
    }

    /**
     * 名称を返します。
     *
     * @return 名称
     */
    public RString get名称() {
        return entity.getMeisho();
    }

    /**
     * 略称を返します。
     *
     * @return 略称
     */
    public RString get略称() {
        return entity.getRyakusho();
    }

    /**
     * 名称２を返します。
     *
     * @return 名称２
     */
    public RString get名称２() {
        return entity.getMeisho2();
    }

    /**
     * 識別番号区分を返します。
     *
     * @return 識別番号区分
     */
    public RString get識別番号区分() {
        return entity.getShikibetsuNoKubon();
    }

    /**
     * 給付実績区分を返します。
     *
     * @return 給付実績区分
     */
    public RString get給付実績区分() {
        return entity.getKyufujissekiKubun();
    }

    /**
     * 給付分類区分を返します。
     *
     * @return 給付分類区分
     */
    public RString get給付分類区分() {
        return entity.getKyufuBunruiKubun();
    }

    /**
     * 選択可能サービス種類コード01を返します。
     *
     * @return 選択可能サービス種類コード01
     */
    public RString get選択可能サービス種類コード01() {
        return entity.getSentakuKanoShuruiCode01();
    }

    /**
     * 選択可能サービス種類コード02を返します。
     *
     * @return 選択可能サービス種類コード02
     */
    public RString get選択可能サービス種類コード02() {
        return entity.getSentakuKanoShuruiCode02();
    }

    /**
     * 選択可能サービス種類コード03を返します。
     *
     * @return 選択可能サービス種類コード03
     */
    public RString get選択可能サービス種類コード03() {
        return entity.getSentakuKanoShuruiCode03();
    }

    /**
     * 選択可能サービス種類コード04を返します。
     *
     * @return 選択可能サービス種類コード04
     */
    public RString get選択可能サービス種類コード04() {
        return entity.getSentakuKanoShuruiCode04();
    }

    /**
     * 選択可能サービス種類コード05を返します。
     *
     * @return 選択可能サービス種類コード05
     */
    public RString get選択可能サービス種類コード05() {
        return entity.getSentakuKanoShuruiCode05();
    }

    /**
     * 選択可能サービス種類コード06を返します。
     *
     * @return 選択可能サービス種類コード06
     */
    public RString get選択可能サービス種類コード06() {
        return entity.getSentakuKanoShuruiCode06();
    }

    /**
     * 選択可能サービス種類コード07を返します。
     *
     * @return 選択可能サービス種類コード07
     */
    public RString get選択可能サービス種類コード07() {
        return entity.getSentakuKanoShuruiCode07();
    }

    /**
     * 選択可能サービス種類コード08を返します。
     *
     * @return 選択可能サービス種類コード08
     */
    public RString get選択可能サービス種類コード08() {
        return entity.getSentakuKanoShuruiCode08();
    }

    /**
     * 選択可能サービス種類コード09を返します。
     *
     * @return 選択可能サービス種類コード09
     */
    public RString get選択可能サービス種類コード09() {
        return entity.getSentakuKanoShuruiCode09();
    }

    /**
     * 選択可能サービス種類コード10を返します。
     *
     * @return 選択可能サービス種類コード10
     */
    public RString get選択可能サービス種類コード10() {
        return entity.getSentakuKanoShuruiCode10();
    }

    /**
     * 選択可能サービス種類コード11を返します。
     *
     * @return 選択可能サービス種類コード11
     */
    public RString get選択可能サービス種類コード11() {
        return entity.getSentakuKanoShuruiCode11();
    }

    /**
     * 選択可能サービス種類コード12を返します。
     *
     * @return 選択可能サービス種類コード12
     */
    public RString get選択可能サービス種類コード12() {
        return entity.getSentakuKanoShuruiCode12();
    }

    /**
     * 選択可能サービス種類コード13を返します。
     *
     * @return 選択可能サービス種類コード13
     */
    public RString get選択可能サービス種類コード13() {
        return entity.getSentakuKanoShuruiCode13();
    }

    /**
     * 選択可能サービス種類コード14を返します。
     *
     * @return 選択可能サービス種類コード14
     */
    public RString get選択可能サービス種類コード14() {
        return entity.getSentakuKanoShuruiCode14();
    }

    /**
     * 選択可能サービス種類コード15を返します。
     *
     * @return 選択可能サービス種類コード15
     */
    public RString get選択可能サービス種類コード15() {
        return entity.getSentakuKanoShuruiCode15();
    }

    /**
     * 選択可能サービス種類コード16を返します。
     *
     * @return 選択可能サービス種類コード16
     */
    public RString get選択可能サービス種類コード16() {
        return entity.getSentakuKanoShuruiCode16();
    }

    /**
     * 選択可能サービス種類コード17を返します。
     *
     * @return 選択可能サービス種類コード17
     */
    public RString get選択可能サービス種類コード17() {
        return entity.getSentakuKanoShuruiCode17();
    }

    /**
     * 選択可能サービス種類コード18を返します。
     *
     * @return 選択可能サービス種類コード18
     */
    public RString get選択可能サービス種類コード18() {
        return entity.getSentakuKanoShuruiCode18();
    }

    /**
     * 選択可能サービス種類コード19を返します。
     *
     * @return 選択可能サービス種類コード19
     */
    public RString get選択可能サービス種類コード19() {
        return entity.getSentakuKanoShuruiCode19();
    }

    /**
     * 選択可能サービス種類コード20を返します。
     *
     * @return 選択可能サービス種類コード20
     */
    public RString get選択可能サービス種類コード20() {
        return entity.getSentakuKanoShuruiCode20();
    }

    /**
     * 社福選択可能種類コード01を返します。
     *
     * @return 社福選択可能種類コード01
     */
    public RString get社福選択可能種類コード01() {
        return entity.getShafukuSentakuKanoShuruiCode01();
    }

    /**
     * 社福選択可能種類コード02を返します。
     *
     * @return 社福選択可能種類コード02
     */
    public RString get社福選択可能種類コード02() {
        return entity.getShafukuSentakuKanoShuruiCode02();
    }

    /**
     * 社福選択可能種類コード03を返します。
     *
     * @return 社福選択可能種類コード03
     */
    public RString get社福選択可能種類コード03() {
        return entity.getShafukuSentakuKanoShuruiCode03();
    }

    /**
     * 社福選択可能種類コード04を返します。
     *
     * @return 社福選択可能種類コード04
     */
    public RString get社福選択可能種類コード04() {
        return entity.getShafukuSentakuKanoShuruiCode04();
    }

    /**
     * 社福選択可能種類コード05を返します。
     *
     * @return 社福選択可能種類コード05
     */
    public RString get社福選択可能種類コード05() {
        return entity.getShafukuSentakuKanoShuruiCode05();
    }

    /**
     * 社福選択可能種類コード06を返します。
     *
     * @return 社福選択可能種類コード06
     */
    public RString get社福選択可能種類コード06() {
        return entity.getShafukuSentakuKanoShuruiCode06();
    }

    /**
     * 社福選択可能種類コード07を返します。
     *
     * @return 社福選択可能種類コード07
     */
    public RString get社福選択可能種類コード07() {
        return entity.getShafukuSentakuKanoShuruiCode07();
    }

    /**
     * 社福選択可能種類コード08を返します。
     *
     * @return 社福選択可能種類コード08
     */
    public RString get社福選択可能種類コード08() {
        return entity.getShafukuSentakuKanoShuruiCode08();
    }

    /**
     * 社福選択可能種類コード09を返します。
     *
     * @return 社福選択可能種類コード09
     */
    public RString get社福選択可能種類コード09() {
        return entity.getShafukuSentakuKanoShuruiCode09();
    }

    /**
     * 社福選択可能種類コード10を返します。
     *
     * @return 社福選択可能種類コード10
     */
    public RString get社福選択可能種類コード10() {
        return entity.getShafukuSentakuKanoShuruiCode10();
    }

    /**
     * 基本設定区分を返します。
     *
     * @return 基本設定区分
     */
    public RString get基本設定区分() {
        return entity.getKihonSetteiKubun();
    }

    /**
     * 明細設定区分を返します。
     *
     * @return 明細設定区分
     */
    public RString get明細設定区分() {
        return entity.getMeisaiSetteiKubun();
    }

    /**
     * 緊急時施設療養設定区分を返します。
     *
     * @return 緊急時施設療養設定区分
     */
    public RString get緊急時施設療養設定区分() {
        return entity.getKinkyuShisetsuRyoyoSetteiKubun();
    }

    /**
     * 特定診療費設定区分を返します。
     *
     * @return 特定診療費設定区分
     */
    public RString get特定診療費設定区分() {
        return entity.getTokuteiShinryoSetteiKubun();
    }

    /**
     * 食事費用設定区分を返します。
     *
     * @return 食事費用設定区分
     */
    public RString get食事費用設定区分() {
        return entity.getShokujiHiyosetteiKubun();
    }

    /**
     * 居宅計画費設定区分を返します。
     *
     * @return 居宅計画費設定区分
     */
    public RString get居宅計画費設定区分() {
        return entity.getKyotakuKeikakuSetteiKubun();
    }

    /**
     * 福祉用具購入費設定区分を返します。
     *
     * @return 福祉用具購入費設定区分
     */
    public RString get福祉用具購入費設定区分() {
        return entity.getFukushoyouguKonyuSetteiKubun();
    }

    /**
     * 住宅改修費設定区分を返します。
     *
     * @return 住宅改修費設定区分
     */
    public RString get住宅改修費設定区分() {
        return entity.getJutakukaishuSetteiKubun();
    }

    /**
     * 高額介護サービス費設定区分を返します。
     *
     * @return 高額介護サービス費設定区分
     */
    public RString get高額介護サービス費設定区分() {
        return entity.getKogakuKaigoSetteiKubun();
    }

    /**
     * 特定診療特別療養設定区分を返します。
     *
     * @return 特定診療特別療養設定区分
     */
    public RString get特定診療特別療養設定区分() {
        return entity.getTokuteishinryoTokubetsuryoyoSetteiKubun();
    }

    /**
     * 特定入所者設定区分を返します。
     *
     * @return 特定入所者設定区分
     */
    public RString get特定入所者設定区分() {
        return entity.getTokuteinyushoshaSetteiKubun();
    }

    /**
     * 社会福祉法人軽減設定区分を返します。
     *
     * @return 社会福祉法人軽減設定区分
     */
    public RString get社会福祉法人軽減設定区分() {
        return entity.getShakaifukushiKeigenSetteiKubun();
    }

    /**
     * ケアマネジメント設定区分を返します。
     *
     * @return ケアマネジメント設定区分
     */
    public RString getケアマネジメント設定区分() {
        return entity.getCareManagementSetteiKubun();
    }

    /**
     * 特定疾患施設療養設定区分を返します。
     *
     * @return 特定疾患施設療養設定区分
     */
    public RString get所定疾患施設療養設定区分() {
        return entity.getShoteiShikkanSetteiKubun();
    }

    /**
     * 明細住所地特例設定区分を返します。
     *
     * @return 明細住所地特例設定区分
     */
    public RString get明細住所地特例設定区分() {
        return entity.getMeisaiJushochitokureiSetteiKubun();
    }

    /**
     * 集計設定区分を返します。
     *
     * @return 集計設定区分
     */
    public RString get集計設定区分() {
        return entity.getShukeiSetteiKubun();
    }

    /**
     * 表示順を返します。
     *
     * @return 表示順
     */
    public int get表示順() {
        return entity.getHyoujiJun();
    }

    /**
     * 過誤申立様式番号を返します。
     *
     * @return 過誤申立様式番号
     */
    public RString get過誤申立様式番号() {
        return entity.getKagoMoshitateYoshikiNo();
    }

    /**
     * {@link DbT3118ShikibetsuNoKanriEntity}のクローンを返します。
     *
     * @return {@link DbT3118ShikibetsuNoKanriEntity}のクローン
     */
    @Override
    public DbT3118ShikibetsuNoKanriEntity toEntity() {
        return this.entity.clone();
    }

    /**
     * 識別番号管理の識別子{@link ShikibetsuNoKanriIdentifier}を返します。
     *
     * @return 識別番号管理の識別子{@link ShikibetsuNoKanriIdentifier}
     */
    @Override
    public ShikibetsuNoKanriIdentifier identifier() {
        return this.id;
    }

    /**
     * 保持する識別番号管理を削除対象とします。<br/>
     * {@link DbT3118ShikibetsuNoKanriEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば削除状態にします。
     *
     * @return 削除対象処理実施後の{@link ShikibetsuNoKanri}
     */
    @Override
    public ShikibetsuNoKanri deleted() {
        DbT3118ShikibetsuNoKanriEntity deletedEntity = this.toEntity();
        if (deletedEntity.getState() != EntityDataState.Added) {
            deletedEntity.setState(EntityDataState.Deleted);
        } else {
            //TODO メッセージの検討
            throw new IllegalStateException(UrErrorMessages.不正.toString());
        }
        return new ShikibetsuNoKanri(deletedEntity, id);
    }

    /**
     * {@link ShikibetsuNoKanri}のシリアライズ形式を提供します。
     *
     * @return {@link ShikibetsuNoKanri}のシリアライズ形式
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

        private final DbT3118ShikibetsuNoKanriEntity entity;
        private final ShikibetsuNoKanriIdentifier id;

        private _SerializationProxy(DbT3118ShikibetsuNoKanriEntity entity, ShikibetsuNoKanriIdentifier id) {
            this.entity = entity;
            this.id = id;
        }

        private Object readResolve() {
            return new ShikibetsuNoKanri(this.entity, this.id);
        }
    }

    /**
     * このクラスの編集を行うBuilderを取得します。<br/>
     * 編集後のインスタンスを取得する場合は{@link SeishinTechoNini.createBuilderForEdit#build()}を使用してください。
     *
     * @return Builder
     */
    public ShikibetsuNoKanriBuilder createBuilderForEdit() {
        return new ShikibetsuNoKanriBuilder(entity, id);
    }

//TODO これはあくまでも雛形によるクラス生成です、必要な業務ロジックの追加、ValueObjectの導出を行う必要があります。
}
