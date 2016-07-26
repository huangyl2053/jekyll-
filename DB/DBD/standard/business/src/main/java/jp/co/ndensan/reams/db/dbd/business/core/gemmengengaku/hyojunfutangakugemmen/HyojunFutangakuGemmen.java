/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.core.gemmengengaku.hyojunfutangakugemmen;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT4012HyojunFutangakuGemmenEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxFlexibleDate;
import jp.co.ndensan.reams.uz.uza.util.ParentModelBase;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 標準負担額減免を管理するクラスです。
 */
public class HyojunFutangakuGemmen extends ParentModelBase<HyojunFutangakuGemmenIdentifier, DbT4012HyojunFutangakuGemmenEntity, HyojunFutangakuGemmen> implements Serializable {

//TODO NetBeansの機能を使って必ずequalsとhashCodeを追加してください。
    private final DbT4012HyojunFutangakuGemmenEntity entity;
    private final HyojunFutangakuGemmenIdentifier id;

    /**
     * コンストラクタです。<br/>
     * 標準負担額減免の新規作成時に使用します。
     *
     * @param shoKisaiHokenshaNo shoKisaiHokenshaNo
     * @param hihokenshaNo hihokenshaNo
     * @param rirekiNo rirekiNo
     * @param shinseiJiyu shinseiJiyu
     * @param gengakuKubun gengakuKubun
     * @param gengakugoKingaku gengakugoKingaku
     * @param hyojunFutanKubun hyojunFutanKubun
     * @param shinseiYMD shinseiYMD
     * @param ketteiKubun ketteiKubun
     * @param ketteiYMD ketteiYMD
     * @param tekiyoKaishiYMD tekiyoKaishiYMD
     * @param tekiyoShuryoYMD tekiyoShuryoYMD
     * @param hiShoninRiyu hiShoninRiyu
     */
    public HyojunFutangakuGemmen(ShoKisaiHokenshaNo shoKisaiHokenshaNo,
            HihokenshaNo hihokenshaNo,
            int rirekiNo,
            RString shinseiJiyu,
            RString gengakuKubun,
            Decimal gengakugoKingaku,
            RString hyojunFutanKubun,
            FlexibleDate shinseiYMD,
            RString ketteiKubun,
            FlexibleDate ketteiYMD,
            FlexibleDate tekiyoKaishiYMD,
            FlexibleDate tekiyoShuryoYMD,
            RString hiShoninRiyu) {
        requireNonNull(shoKisaiHokenshaNo, UrSystemErrorMessages.値がnull.getReplacedMessage("shoKisaiHokenshaNo"));
        requireNonNull(hihokenshaNo, UrSystemErrorMessages.値がnull.getReplacedMessage("hihokenshaNo"));
        requireNonNull(rirekiNo, UrSystemErrorMessages.値がnull.getReplacedMessage("rirekiNo"));
        requireNonNull(shinseiJiyu, UrSystemErrorMessages.値がnull.getReplacedMessage("shinseiJiyu"));
        requireNonNull(gengakuKubun, UrSystemErrorMessages.値がnull.getReplacedMessage("gengakuKubun"));
        requireNonNull(gengakugoKingaku, UrSystemErrorMessages.値がnull.getReplacedMessage("gengakugoKingaku"));
        requireNonNull(hyojunFutanKubun, UrSystemErrorMessages.値がnull.getReplacedMessage("hyojunFutanKubun"));
        requireNonNull(shinseiYMD, UrSystemErrorMessages.値がnull.getReplacedMessage("shinseiYMD"));
        requireNonNull(ketteiKubun, UrSystemErrorMessages.値がnull.getReplacedMessage("ketteiKubun"));
        requireNonNull(ketteiYMD, UrSystemErrorMessages.値がnull.getReplacedMessage("ketteiYMD"));
        requireNonNull(tekiyoKaishiYMD, UrSystemErrorMessages.値がnull.getReplacedMessage("tekiyoKaishiYMD"));
        requireNonNull(tekiyoShuryoYMD, UrSystemErrorMessages.値がnull.getReplacedMessage("tekiyoShuryoYMD"));
        requireNonNull(hiShoninRiyu, UrSystemErrorMessages.値がnull.getReplacedMessage("hiShoninRiyu"));
        this.entity = new DbT4012HyojunFutangakuGemmenEntity();
        this.entity.setShoKisaiHokenshaNo(shoKisaiHokenshaNo);
        this.entity.setHihokenshaNo(hihokenshaNo);
        this.entity.setRirekiNo(rirekiNo);
        this.entity.setShinseiJiyu(shinseiJiyu);
        this.entity.setGengakuKubun(gengakuKubun);
        this.entity.setGengakugoKingaku(gengakugoKingaku);
        this.entity.setHyojunFutanKubun(hyojunFutanKubun);
        this.entity.setShinseiYMD(shinseiYMD);
        this.entity.setKetteiKubun(ketteiKubun);
        this.entity.setKetteiYMD(ketteiYMD);
        this.entity.setTekiyoKaishiYMD(tekiyoKaishiYMD);
        this.entity.setTekiyoShuryoYMD(tekiyoShuryoYMD);
        this.entity.setHiShoninRiyu(hiShoninRiyu);
        this.id = new HyojunFutangakuGemmenIdentifier(
                shoKisaiHokenshaNo,
                hihokenshaNo,
                rirekiNo,
                shinseiJiyu,
                gengakuKubun,
                gengakugoKingaku,
                hyojunFutanKubun,
                shinseiYMD,
                ketteiKubun,
                ketteiYMD,
                tekiyoKaishiYMD,
                tekiyoShuryoYMD,
                hiShoninRiyu
        );
    }

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link DbT4012HyojunFutangakuGemmenEntity}より{@link HyojunFutangakuGemmen}を生成します。
     *
     * @param entity DBより取得した{@link DbT4012HyojunFutangakuGemmenEntity}
     */
    public HyojunFutangakuGemmen(DbT4012HyojunFutangakuGemmenEntity entity) {
        this.entity = requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("標準負担額減免"));
        this.id = new HyojunFutangakuGemmenIdentifier(
                entity.getShoKisaiHokenshaNo(),
                entity.getHihokenshaNo(),
                entity.getRirekiNo(),
                entity.getShinseiJiyu(),
                entity.getGengakuKubun(),
                entity.getGengakugoKingaku(),
                entity.getHyojunFutanKubun(),
                entity.getShinseiYMD(),
                entity.getKetteiKubun(),
                entity.getKetteiYMD(),
                entity.getTekiyoKaishiYMD(),
                entity.getTekiyoShuryoYMD(),
                entity.getHiShoninRiyu());
    }

    /**
     * シリアライズ、ビルダー用コンストラクタです。
     *
     * @param entity {@link DbT4012HyojunFutangakuGemmenEntity}
     * @param id {@link HyojunFutangakuGemmenIdentifier}
     */
    HyojunFutangakuGemmen(
            DbT4012HyojunFutangakuGemmenEntity entity,
            HyojunFutangakuGemmenIdentifier id
    ) {
        this.entity = entity;
        this.id = id;
    }

    /**
     * 論理削除行であればtrueを返します。
     *
     * @return 論理削除行であればtrue
     */
    public boolean get論理削除行であればtrue() {
        return entity.getIsDeleted();
    }

    /**
     * 証記載保険者番号を返します。
     *
     * @return 証記載保険者番号
     */
    public ShoKisaiHokenshaNo get証記載保険者番号() {
        return entity.getShoKisaiHokenshaNo();
    }

    /**
     * 被保険者番号を返します。
     *
     * @return 被保険者番号
     */
    public HihokenshaNo get被保険者番号() {
        return entity.getHihokenshaNo();
    }

    /**
     * 履歴番号を返します。
     *
     * @return 履歴番号
     */
    public int get履歴番号() {
        return entity.getRirekiNo();
    }

    /**
     * 申請事由を返します。
     *
     * @return 申請事由
     */
    public RString get申請事由() {
        return entity.getShinseiJiyu();
    }

    /**
     * 減額区分を返します。
     *
     * @return 減額区分
     */
    public RString get減額区分() {
        return entity.getGengakuKubun();
    }

    /**
     * 減額後金額を返します。
     *
     * @return 減額後金額
     */
    public Decimal get減額後金額() {
        return entity.getGengakugoKingaku();
    }

    public RString get減額後金額RString() {
        if (entity.getGengakugoKingaku() == null) {
            return RString.EMPTY;
        }
        return new RString(entity.getGengakugoKingaku().toString());
    }

    /**
     * 標準負担区分を返します。
     *
     * @return 標準負担区分
     */
    public RString get標準負担区分() {
        return entity.getHyojunFutanKubun();
    }

    /**
     * 申請年月日を返します。
     *
     * @return 申請年月日
     */
    public FlexibleDate get申請年月日() {
        return entity.getShinseiYMD();
    }

    public RString get申請年月日RString() {
        if (entity.getShinseiYMD() == null || entity.getShinseiYMD().isEmpty()) {
            return RString.EMPTY;
        }
        return new RString(entity.getShinseiYMD().toString());
    }

    /**
     * 決定区分を返します。
     *
     * @return 決定区分
     */
    public RString get決定区分() {
        return entity.getKetteiKubun();
    }

    /**
     * 決定年月日を返します。
     *
     * @return 決定年月日
     */
    public FlexibleDate get決定年月日() {
        return entity.getKetteiYMD();
    }

    public TextBoxFlexibleDate get決定年月日TextBox() {
        TextBoxFlexibleDate textBoxFlexibleDate = new TextBoxFlexibleDate();
        if (entity.getKetteiYMD().isEmpty()) {
            return null;
        }
        textBoxFlexibleDate.setValue(entity.getKetteiYMD());
        return textBoxFlexibleDate;
    }

    /**
     * 適用開始年月日を返します。
     *
     * @return 適用開始年月日
     */
    public FlexibleDate get適用開始年月日() {
        return entity.getTekiyoKaishiYMD();
    }

    public TextBoxFlexibleDate get適用開始年月日TextBox() {
        TextBoxFlexibleDate textBoxFlexibleDate = new TextBoxFlexibleDate();
        if (entity.getTekiyoKaishiYMD().isEmpty()) {
            return null;
        }
        textBoxFlexibleDate.setValue(entity.getTekiyoKaishiYMD());
        return textBoxFlexibleDate;
    }

    /**
     * 適用終了年月日を返します。
     *
     * @return 適用終了年月日
     */
    public FlexibleDate get適用終了年月日() {
        return entity.getTekiyoShuryoYMD();
    }

    public TextBoxFlexibleDate get適用終了年月日TextBox() {
        TextBoxFlexibleDate textBoxFlexibleDate = new TextBoxFlexibleDate();
        if (entity.getTekiyoShuryoYMD().isEmpty()) {
            return null;
        }
        textBoxFlexibleDate.setValue(entity.getTekiyoShuryoYMD());
        return textBoxFlexibleDate;
    }

    /**
     * 非承認理由を返します。
     *
     * @return 非承認理由
     */
    public RString get非承認理由() {
        return entity.getHiShoninRiyu();
    }

    /**
     * {@link DbT4012HyojunFutangakuGemmenEntity}のクローンを返します。
     *
     * @return {@link DbT4012HyojunFutangakuGemmenEntity}のクローン
     */
    @Override
    public DbT4012HyojunFutangakuGemmenEntity toEntity() {
        return this.entity.clone();
    }

    /**
     * 標準負担額減免の識別子{@link HyojunFutangakuGemmenIdentifier}を返します。
     *
     * @return 標準負担額減免の識別子{@link HyojunFutangakuGemmenIdentifier}
     */
    @Override
    public HyojunFutangakuGemmenIdentifier identifier() {
        return this.id;
    }

    /**
     * 標準負担額減免のみを変更対象とします。<br/>
     * {@link DbT4012HyojunFutangakuGemmenEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば変更状態にします。
     *
     * @return 変更対象処理実施後の{@link HyojunFutangakuGemmen}
     */
    @Override
    public HyojunFutangakuGemmen modifiedModel() {
        DbT4012HyojunFutangakuGemmenEntity modifiedEntity = entity.clone();
        if (modifiedEntity.getState().equals(EntityDataState.Unchanged)) {
            modifiedEntity.setState(EntityDataState.Modified);
        }
        return new HyojunFutangakuGemmen(
                modifiedEntity, id);
    }

    /**
     * 保持する標準負担額減免を削除対象とします。<br/>
     * {@link DbT4012HyojunFutangakuGemmenEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば削除状態にします。
     *
     * @return 削除対象処理実施後の{@link HyojunFutangakuGemmen}
     */
    @Override
    public HyojunFutangakuGemmen deleted() {
        DbT4012HyojunFutangakuGemmenEntity deletedEntity = this.toEntity();
        if (deletedEntity.getState() != EntityDataState.Added) {
            deletedEntity.setState(EntityDataState.Deleted);
        } else {
            //TODO メッセージの検討
            throw new IllegalStateException(UrErrorMessages.不正.toString());
        }
        return new HyojunFutangakuGemmen(deletedEntity, id);
    }

    /**
     * {@link HyojunFutangakuGemmen}のシリアライズ形式を提供します。
     *
     * @return {@link HyojunFutangakuGemmen}のシリアライズ形式
     */
    protected Object writeReplace() {
        return new _SerializationProxy(entity, id);

    }

    @Override
    public boolean hasChanged() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private static final class _SerializationProxy implements Serializable {

        private static final long serialVersionUID = -710031961519711798L;
        private final DbT4012HyojunFutangakuGemmenEntity entity;
        private final HyojunFutangakuGemmenIdentifier id;

        private _SerializationProxy(DbT4012HyojunFutangakuGemmenEntity entity, HyojunFutangakuGemmenIdentifier id) {
            this.entity = entity;
            this.id = id;
        }

        private Object readResolve() {
            return new HyojunFutangakuGemmen(this.entity, this.id);
        }
    }

    /**
     * このクラスの編集を行うBuilderを取得します。<br/>
     * 編集後のインスタンスを取得する場合は{@link SeishinTechoNini.createBuilderForEdit#build()}を使用してください。
     *
     * @return Builder
     */
    public HyojunFutangakuGemmenBuilder createBuilderForEdit() {
        return new HyojunFutangakuGemmenBuilder(entity, id);
    }

//TODO これはあくまでも雛形によるクラス生成です、必要な業務ロジックの追加、ValueObjectの導出を行う必要があります。
}
