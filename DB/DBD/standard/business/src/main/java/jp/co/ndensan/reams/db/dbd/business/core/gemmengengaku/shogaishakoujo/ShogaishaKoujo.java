/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.core.gemmengengaku.shogaishakoujo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbd.business.core.gemmengengaku.shinsei.GemmenGengakuShinsei;
import jp.co.ndensan.reams.db.dbd.business.core.gemmengengaku.shinsei.GemmenGengakuShinseiIdentifier;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT4010GemmenGengakuShinseiEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT4038ShogaishaKoujoEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.gemmengengaku.shogaishakoujo.ShogaishaKoujoEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenKyufuRitsu;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.Models;
import jp.co.ndensan.reams.uz.uza.util.ParentModelBase;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 障がい書控除を管理するクラスです。
 *
 * @reamsid_L DBD-3840-010 wangjie2
 */
public class ShogaishaKoujo extends ParentModelBase<ShogaishaKoujoIdentifier, DbT4038ShogaishaKoujoEntity, ShogaishaKoujo>
        implements Serializable {

    private final DbT4038ShogaishaKoujoEntity entity;
    private final ShogaishaKoujoIdentifier id;
    private final Models<GemmenGengakuShinseiIdentifier, GemmenGengakuShinsei> gemmenGengakuShinsei;

    /**
     * コンストラクタです。<br/>
     * 社会福祉法人等利用者負担軽減の新規作成時に使用します。
     *
     * @param 証記載保険者番号 証記載保険者番号
     * @param 被保険者番号 被保険者番号
     * @param 履歴番号 履歴番号
     */
    public ShogaishaKoujo(ShoKisaiHokenshaNo 証記載保険者番号,
            HihokenshaNo 被保険者番号,
            int 履歴番号) {
        requireNonNull(証記載保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("証記載保険者番号"));
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));
        this.entity = new DbT4038ShogaishaKoujoEntity();
        this.entity.setShoKisaiHokenshaNo(証記載保険者番号);
        this.entity.setHihokenshaNo(被保険者番号);
        this.entity.setRirekiNo(履歴番号);
        this.id = new ShogaishaKoujoIdentifier(
                証記載保険者番号,
                被保険者番号,
                履歴番号
        );
        this.gemmenGengakuShinsei = Models.create(new ArrayList<GemmenGengakuShinsei>());
    }

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link ShogaishaKoujoEntity}より{@link ShogaishaKoujo}を生成します。
     *
     * @param entity DBより取得した{@link ShogaishaKoujo}
     */
    public ShogaishaKoujo(ShogaishaKoujoEntity entity) {
        this.entity = requireNonNull(entity.get障がい書控除Entity(),
                UrSystemErrorMessages.値がnull.getReplacedMessage("障がい書控除"));
        this.id = new ShogaishaKoujoIdentifier(
                entity.get障がい書控除Entity().getShoKisaiHokenshaNo(),
                entity.get障がい書控除Entity().getHihokenshaNo(),
                entity.get障がい書控除Entity().getRirekiNo());

        List<GemmenGengakuShinsei> gemmenGengakuShinseiList = new ArrayList<>();
        for (DbT4010GemmenGengakuShinseiEntity shinseiEntity : entity.get減免減額申請Entity()) {
            gemmenGengakuShinseiList.add(new GemmenGengakuShinsei(shinseiEntity));
        }
        this.gemmenGengakuShinsei = Models.create(gemmenGengakuShinseiList);
    }

    /**
     * シリアライズ、ビルダー用コンストラクタです。
     *
     * @param entity {@link ShogaishaKoujo}
     * @param id {@link ShogaishaKoujoIdentifier}
     * @param gemmenGengakuShinsei {@link GemmenGengakuShinsei}
     */
    ShogaishaKoujo(
            DbT4038ShogaishaKoujoEntity entity,
            ShogaishaKoujoIdentifier id,
            Models<GemmenGengakuShinseiIdentifier, GemmenGengakuShinsei> gemmenGengakuShinsei
    ) {
        this.entity = entity;
        this.id = id;
        this.gemmenGengakuShinsei = gemmenGengakuShinsei;
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
     * 申請年月日を返します。
     *
     * @return 申請年月日
     */
    public FlexibleDate get申請年月日() {
        return entity.getShinseiYMD();
    }

    /**
     * 決定年月日を返します。
     *
     * @return 決定年月日
     */
    public FlexibleDate get決定年月日() {
        return entity.getKetteiYMD();
    }

    /**
     * 適用開始年月日を返します。
     *
     * @return 適用開始年月日
     */
    public FlexibleDate get適用開始年月日() {
        return entity.getTekiyoKaishiYMD();
    }

    /**
     * 適用終了年月日を返します。
     *
     * @return 適用終了年月日
     */
    public FlexibleDate get適用終了年月日() {
        return entity.getTekiyoShuryoYMD();
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
     * 非承認理由を返します。
     *
     * @return 非承認理由
     */
    public RString get非承認理由() {
        return entity.getHiShoninRiyu();
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
     * 対象年度を返します。
     *
     * @return 対象年度
     */
    public FlexibleYear get対象年度() {
        return entity.getTaishoNendo();
    }

    /**
     * 基準日を返します。
     *
     * @return 基準日
     */
    public FlexibleDate get基準日() {
        return entity.getKijunYMD();
    }

    /**
     * 把握日を返します。
     *
     * @return 把握日
     */
    public FlexibleDate get把握日() {
        return entity.getHaakuYMD();
    }

    /**
     * 認定区分を返します。
     *
     * @return 認定区分
     */
    public RString get認定区分() {
        return entity.getNinteiKubun();
    }

    /**
     * 認定内容を返します。
     *
     * @return 認定内容
     */
    public RString get認定内容() {
        return entity.getNinteiNaiyo();
    }

    /**
     * 給付率を返します。
     *
     * @return 給付率
     */
    public HokenKyufuRitsu get給付率() {
        return entity.getKyufuritsu();
    }

    /**
     * 認知症高齢者の日常生活自立度コードを返します。
     *
     * @return 認知症高齢者の日常生活自立度コード
     */
    public Code get認知症高齢者の日常生活自立度コード() {
        return entity.getNinchishoNichijoSeikatsuJiritsudoCode();
    }

    /**
     * 障がい高齢者の日常生活自立度コードを返します。
     *
     * @return 障がい高齢者の日常生活自立度コード
     */
    public Code get障がい高齢者の日常生活自立度コード() {
        return entity.getShogaiNichijoSeikatsuJiritsudoCode();
    }

    /**
     * 障がい者手帳有無を返します。
     *
     * @return 障がい者手帳有無
     */
    public boolean is障がい者手帳有無() {
        return entity.getShogaishaTechoUmu();
    }

    /**
     * 資格喪失事由コードを返します。
     *
     * @return 資格喪失事由コード
     */
    public RString get資格喪失事由コード() {
        return entity.getShikakuSoshitsuJiyuCode();
    }

    /**
     * 資格喪失年月日を返します。
     *
     * @return 資格喪失年月日
     */
    public FlexibleDate get資格喪失年月日() {
        return entity.getShikakuSoshitsuYMD();
    }

    /**
     * 認定証発行対象外フラグを返します。
     *
     * @return 認定証発行対象外フラグ
     */
    public boolean is認定証発行対象外フラグ() {
        return entity.getNinteishoHakkoTaishogai();
    }

    /**
     * {@link DbT4038ShogaishaKoujoEntity}のクローンを返します。
     *
     * @return {@link DbT4038ShogaishaKoujoEntity}のクローン
     */
    @Override
    public DbT4038ShogaishaKoujoEntity toEntity() {
        return this.entity.clone();
    }

    /**
     * 障がい書控除のみを変更対象とします。<br/> {@link DbT4038ShogaishaKoujoEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば変更状態にします。
     *
     * @return 変更対象処理実施後の{@link ShogaishaKoujo}
     */
    @Override
    public ShogaishaKoujo modifiedModel() {
        DbT4038ShogaishaKoujoEntity modifiedEntity = entity.clone();
        if (modifiedEntity.getState().equals(EntityDataState.Unchanged)) {
            modifiedEntity.setState(EntityDataState.Modified);
        }
        return new ShogaishaKoujo(
                modifiedEntity, id, gemmenGengakuShinsei);
    }

    /**
     * 障がい書控除を削除対象とします。<br/> {@link DbT4038ShogaishaKoujoEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば削除状態にします。
     *
     * @return 削除対象処理実施後の{@link ShogaishaKoujo}
     */
    @Override
    public ShogaishaKoujo deleted() {
        DbT4038ShogaishaKoujoEntity deletedEntity = this.toEntity();
        if (deletedEntity.getState() != EntityDataState.Added) {
            deletedEntity.setState(EntityDataState.Deleted);
        } else {
            throw new IllegalStateException(UrErrorMessages.不正.toString());
        }
        return new ShogaishaKoujo(deletedEntity, id, gemmenGengakuShinsei);
    }

    @Override
    public boolean hasChanged() {
        return hasChangedEntity() || gemmenGengakuShinsei.hasAnyChanged();
    }

    /**
     * 障がい書控除の識別子{@link ShogaishaKoujoIdentifier}を返します。
     *
     * @return 障がい書控除の識別子{@link ShogaishaKoujoIdentifier}
     */
    @Override
    public ShogaishaKoujoIdentifier identifier() {
        return this.id;
    }

    /**
     * 社障がい書控除が保持する減免減額申請に対して、指定の識別子に該当する減免減額申請を返します。
     *
     * @param id 減免減額申請の識別子
     * @return 減免減額申請
     * @throws IllegalStateException 指定の識別子に該当する減免減額申請がない場合
     */
    public GemmenGengakuShinsei getGemmenGengakuShinsei(GemmenGengakuShinseiIdentifier id) {
        if (gemmenGengakuShinsei.contains(id)) {
            return gemmenGengakuShinsei.clone().get(id);
        }
        throw new IllegalArgumentException(UrErrorMessages.不正.toString());
    }

    /**
     * 社障がい書控除が保持する減免減額申請をリストで返します。
     *
     * @return 減免減額申請リスト
     */
    public List<GemmenGengakuShinsei> getGemmenGengakuShinseiList() {
        return new ArrayList<>(gemmenGengakuShinsei.values());
    }

    /**
     * このクラスの編集を行うBuilderを取得します。<br/>
     * 編集後のインスタンスを取得する場合は{@link SeishinTechoNini.createBuilderForEdit#build()}を使用してください。
     *
     * @return Builder
     */
    public ShogaishaKoujoBuilder createBuilderForEdit() {
        return new ShogaishaKoujoBuilder(entity, id, gemmenGengakuShinsei);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ShogaishaKoujo other = (ShogaishaKoujo) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

}
