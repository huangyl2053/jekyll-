/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.ninteischedule.ninteichosaschedule;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbe.business.core.ninteischedule.chikuninteichosain.ChikuNinteiChosain;
import jp.co.ndensan.reams.db.dbe.business.core.ninteischedule.chikuninteichosain.ChikuNinteiChosainIdentifier;
import jp.co.ndensan.reams.db.dbe.business.core.ninteischedule.ninteichosaschedulememo.NinteiChosaScheduleMemo;
import jp.co.ndensan.reams.db.dbe.business.core.ninteischedule.ninteichosaschedulememo.NinteiChosaScheduleMemoIdentifier;
import jp.co.ndensan.reams.db.dbe.business.core.ninteischedule.ninteishinseijoho.NinteiShinseiJoho;
import jp.co.ndensan.reams.db.dbe.business.core.ninteischedule.ninteishinseijoho.NinteiShinseiJohoIdentifier;
import jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5101NinteiShinseiJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.ninteischedule.chikuninteichosain.ChikuNinteiChosainEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.ninteischedule.ninteichosaschedule.NinteichosaScheduleEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5221NinteichosaScheduleEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5222NinteiChosaScheduleMemoEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.Models;
import jp.co.ndensan.reams.uz.uza.util.ParentModelBase;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 認定調査スケジュール情報を管理するクラスです。
 */
public class NinteichosaSchedule extends ParentModelBase<NinteichosaScheduleIdentifier, DbT5221NinteichosaScheduleEntity, NinteichosaSchedule> implements Serializable {

    private static final long serialVersionUID = -7680664538917615055L;

    private final DbT5221NinteichosaScheduleEntity entity;
    private final NinteichosaScheduleIdentifier id;
    private final Models<NinteiShinseiJohoIdentifier, NinteiShinseiJoho> ninteiShinseiJoho;
    private final Models<NinteiChosaScheduleMemoIdentifier, NinteiChosaScheduleMemo> ninteiChosaScheduleMemo;
    private final Models<ChikuNinteiChosainIdentifier, ChikuNinteiChosain> chikuNinteiChosain;

    /**
     * コンストラクタです。<br/>
     * 認定調査スケジュール情報の新規作成時に使用します。
     *
     * @param 認定調査予定年月日 認定調査予定年月日
     * @param 認定調査予定開始時間 認定調査予定開始時間
     * @param 認定調査予定終了時間 認定調査予定終了時間
     * @param 認定調査時間枠 認定調査時間枠
     * @param 調査地区コード 調査地区コード
     * @param 認定調査委託先コード 認定調査委託先コード
     * @param 認定調査員コード 認定調査員コード
     * @param 市町村コード 市町村コード
     */
    public NinteichosaSchedule(FlexibleDate 認定調査予定年月日,
            RString 認定調査予定開始時間,
            RString 認定調査予定終了時間,
            Code 認定調査時間枠,
            Code 調査地区コード,
            RString 認定調査委託先コード,
            RString 認定調査員コード,
            LasdecCode 市町村コード) {
        requireNonNull(認定調査予定年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("認定調査予定年月日"));
        requireNonNull(認定調査予定開始時間, UrSystemErrorMessages.値がnull.getReplacedMessage("認定調査予定開始時間"));
        requireNonNull(認定調査予定終了時間, UrSystemErrorMessages.値がnull.getReplacedMessage("認定調査予定終了時間"));
        requireNonNull(認定調査時間枠, UrSystemErrorMessages.値がnull.getReplacedMessage("認定調査時間枠"));
        requireNonNull(調査地区コード, UrSystemErrorMessages.値がnull.getReplacedMessage("調査地区コード"));
        requireNonNull(認定調査委託先コード, UrSystemErrorMessages.値がnull.getReplacedMessage("認定調査委託先コード"));
        requireNonNull(認定調査員コード, UrSystemErrorMessages.値がnull.getReplacedMessage("認定調査員コード"));
        requireNonNull(市町村コード, UrSystemErrorMessages.値がnull.getReplacedMessage("市町村コード"));
        this.entity = new DbT5221NinteichosaScheduleEntity();
        this.entity.setNinteiChosaYoteiYMD(認定調査予定年月日);
        this.entity.setNinteiChosaYoteiKaishiTime(認定調査予定開始時間);
        this.entity.setNinteiChosaYoteiShuryoTime(認定調査予定終了時間);
        this.entity.setNinteiChosaJikanWaku(認定調査時間枠);
        this.entity.setChosaChikuCode(調査地区コード);
        this.entity.setNinteiChosaItakusakiCode(認定調査委託先コード);
        this.entity.setNinteiChosainCode(認定調査員コード);
        this.entity.setShichosonCode(市町村コード);
        this.id = new NinteichosaScheduleIdentifier(
                認定調査予定年月日,
                認定調査予定開始時間,
                認定調査予定終了時間,
                認定調査時間枠,
                調査地区コード,
                認定調査委託先コード,
                認定調査員コード,
                市町村コード
        );
        this.ninteiShinseiJoho = Models.create(new ArrayList<NinteiShinseiJoho>());
        this.ninteiChosaScheduleMemo = Models.create(new ArrayList<NinteiChosaScheduleMemo>());
        this.chikuNinteiChosain = Models.create(new ArrayList<ChikuNinteiChosain>());
    }

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link DbT5221NinteichosaScheduleEntity}より{@link NinteichosaSchedule}を生成します。
     *
     * @param entity DBより取得した{@link DbT5221NinteichosaScheduleEntity}
     */
    public NinteichosaSchedule(NinteichosaScheduleEntity entity) {
        this.entity = requireNonNull(entity.get認定調査スケジュール情報Entity(), UrSystemErrorMessages.値がnull.getReplacedMessage("認定調査スケジュール情報"));
        this.id = new NinteichosaScheduleIdentifier(
                entity.get認定調査スケジュール情報Entity().getNinteiChosaYoteiYMD(),
                entity.get認定調査スケジュール情報Entity().getNinteiChosaYoteiKaishiTime(),
                entity.get認定調査スケジュール情報Entity().getNinteiChosaYoteiShuryoTime(),
                entity.get認定調査スケジュール情報Entity().getNinteiChosaJikanWaku(),
                entity.get認定調査スケジュール情報Entity().getChosaChikuCode(),
                entity.get認定調査スケジュール情報Entity().getNinteiChosaItakusakiCode(),
                entity.get認定調査スケジュール情報Entity().getNinteiChosainCode(),
                entity.get認定調査スケジュール情報Entity().getShichosonCode());
        List<NinteiShinseiJoho> ninteiShinseiJohoList = new ArrayList<>();
        for (DbT5101NinteiShinseiJohoEntity ninteiShinseiJohoEntity : entity.get要介護認定申請情報Entity()) {
            ninteiShinseiJohoList.add(new NinteiShinseiJoho(ninteiShinseiJohoEntity));
        }
        this.ninteiShinseiJoho = Models.create(ninteiShinseiJohoList);

        List<NinteiChosaScheduleMemo> ninteiChosaScheduleMemoList = new ArrayList<>();
        for (DbT5222NinteiChosaScheduleMemoEntity ninteiChosaScheduleMemoEntity : entity.get認定調査スケジュールメモ情報Entity()) {
            ninteiChosaScheduleMemoList.add(new NinteiChosaScheduleMemo(ninteiChosaScheduleMemoEntity));
        }
        this.ninteiChosaScheduleMemo = Models.create(ninteiChosaScheduleMemoList);
        List<ChikuNinteiChosain> chikuNinteiChosainList = new ArrayList<>();
        for (ChikuNinteiChosainEntity chikuNinteiChosainEntity : entity.get地区認定調査員Entity()) {
            chikuNinteiChosainList.add(new ChikuNinteiChosain(chikuNinteiChosainEntity));
        }
        this.chikuNinteiChosain = Models.create(chikuNinteiChosainList);
    }

    /**
     * シリアライズ、ビルダー用コンストラクタです。
     *
     * @param entity {@link DbT5221NinteichosaScheduleEntity}
     * @param id {@link NinteichosaScheduleIdentifier}
     */
    NinteichosaSchedule(
            DbT5221NinteichosaScheduleEntity entity,
            NinteichosaScheduleIdentifier id,
            Models<NinteiShinseiJohoIdentifier, NinteiShinseiJoho> ninteishinseijoho,
            Models<NinteiChosaScheduleMemoIdentifier, NinteiChosaScheduleMemo> ninteichosaschedulememo,
            Models<ChikuNinteiChosainIdentifier, ChikuNinteiChosain> chikuninteichosain) {
   
        this.entity = entity;
        this.id = id;
        this.ninteiShinseiJoho = ninteishinseijoho;
        this.ninteiChosaScheduleMemo = ninteichosaschedulememo;
        this.chikuNinteiChosain = chikuninteichosain;
    }

    /**
     * 認定調査予定年月日を返します。
     *
     * @return 認定調査予定年月日
     */
    public FlexibleDate get認定調査予定年月日() {
        return entity.getNinteiChosaYoteiYMD();
    }

    /**
     * 認定調査予定開始時間を返します。
     *
     * @return 認定調査予定開始時間
     */
    public RString get認定調査予定開始時間() {
        return entity.getNinteiChosaYoteiKaishiTime();
    }

    /**
     * 認定調査予定終了時間を返します。
     *
     * @return 認定調査予定終了時間
     */
    public RString get認定調査予定終了時間() {
        return entity.getNinteiChosaYoteiShuryoTime();
    }

    /**
     * 認定調査時間枠を返します。
     *
     * @return 認定調査時間枠
     */
    public Code get認定調査時間枠() {
        return entity.getNinteiChosaJikanWaku();
    }

    /**
     * 調査地区コードを返します。
     *
     * @return 調査地区コード
     */
    public Code get調査地区コード() {
        return entity.getChosaChikuCode();
    }

    /**
     * 認定調査委託先コードを返します。
     *
     * @return 認定調査委託先コード
     */
    public RString get認定調査委託先コード() {
        return entity.getNinteiChosaItakusakiCode();
    }

    /**
     * 認定調査員コードを返します。
     *
     * @return 認定調査員コード
     */
    public RString get認定調査員コード() {
        return entity.getNinteiChosainCode();
    }

    /**
     * 市町村コードを返します。
     *
     * @return 市町村コード
     */
    public LasdecCode get市町村コード() {
        return entity.getShichosonCode();
    }

    /**
     * 申請書管理番号を返します。
     *
     * @return 申請書管理番号
     */
    public ShinseishoKanriNo get申請書管理番号() {
        return entity.getShinseishoKanriNo();
    }

    /**
     * 予約状況を返します。
     *
     * @return 予約状況
     */
    public Code get予約状況() {
        return entity.getYoyakuJokyo();
    }

    /**
     * 予約可能フラグを返します。
     *
     * @return 予約可能フラグ
     */
    public boolean get予約可能フラグ() {
        return entity.getYoyakuKaoFlag();
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
     * 場所を返します。
     *
     * @return 場所
     */
    public RString get場所() {
        return entity.getBasho();
    }

    /**
     * 駐車場を返します。
     *
     * @return 駐車場
     */
    public RString get駐車場() {
        return entity.getChushajo();
    }

    /**
     * 立会人１を返します。
     *
     * @return 立会人１
     */
    public RString get立会人１() {
        return entity.getTachiainin1();
    }

    /**
     * 連絡先１を返します。
     *
     * @return 連絡先１
     */
    public TelNo get連絡先１() {
        return entity.getRenrakusaki1();
    }

    /**
     * 立会人２を返します。
     *
     * @return 立会人２
     */
    public RString get立会人２() {
        return entity.getTachiainin2();
    }

    /**
     * 連絡先２を返します。
     *
     * @return 連絡先２
     */
    public TelNo get連絡先２() {
        return entity.getRenrakusaki2();
    }

    /**
     * 対象者メモを返します。
     *
     * @return 対象者メモ
     */
    public RString get対象者メモ() {
        return entity.getTaishoshaMemo();
    }

    /**
     * {@link DbT5221NinteichosaScheduleEntity}のクローンを返します。
     *
     * @return {@link DbT5221NinteichosaScheduleEntity}のクローン
     */
    @Override
    public DbT5221NinteichosaScheduleEntity toEntity() {
        return this.entity.clone();
    }

    /**
     * 認定調査スケジュール情報の識別子{@link NinteichosaScheduleIdentifier}を返します。
     *
     * @return 認定調査スケジュール情報の識別子{@link NinteichosaScheduleIdentifier}
     */
    @Override
    public NinteichosaScheduleIdentifier identifier() {
        return this.id;
    }

    /**
     * 認定調査スケジュール情報配下の要素を削除対象とします。<br/>
     * {@link DbT5221NinteichosaScheduleEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば削除状態にします。
     * 認定調査スケジュール情報配下の要素である精神手帳任意項目情報の{@link Models#deleteOrRemoveAll() }を実行します。
     * 削除処理結果となる{@link NinteichosaSchedule}を返します。
     *
     * @return 削除対象処理実施後の{@link NinteichosaSchedule}
     * @throws IllegalStateException
     * DbT5221NinteichosaScheduleEntityのデータ状態が変更の場合
     */
    @Override
    public NinteichosaSchedule deleted() {
        DbT5221NinteichosaScheduleEntity deletedEntity = this.toEntity();
        if (!deletedEntity.getState().equals(EntityDataState.Added)) {
            deletedEntity.setState(EntityDataState.Deleted);
        } else {
            //TODO メッセージの検討
            throw new IllegalStateException(UrErrorMessages.不正.toString());
        }
        return new NinteichosaSchedule(
                deletedEntity, id, ninteiShinseiJoho, ninteiChosaScheduleMemo,chikuNinteiChosain);
    }

    @Override
    public boolean hasChanged() {
        return hasChangedEntity() || ninteiShinseiJoho.hasAnyChanged() || ninteiChosaScheduleMemo.hasAnyChanged() || chikuNinteiChosain.hasAnyChanged();
    }

    /**
     * 認定調査スケジュール情報のみを変更対象とします。<br/>
     * {@link DbT5221NinteichosaScheduleEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば変更状態にします。
     *
     * @return 変更対象処理実施後の{@link NinteichosaSchedule}
     */
    @Override
    public NinteichosaSchedule modifiedModel() {
        DbT5221NinteichosaScheduleEntity modifiedEntity = entity.clone();
        if (modifiedEntity.getState().equals(EntityDataState.Unchanged)) {
            modifiedEntity.setState(EntityDataState.Modified);
        }
        return new NinteichosaSchedule(
                modifiedEntity, id, ninteiShinseiJoho, ninteiChosaScheduleMemo,chikuNinteiChosain);
    }

    /**
     * 認定調査スケジュール情報が保持する精神手帳任意項目情報に対して、指定の識別子に該当する精神手帳任意項目情報を返します。
     *
     * @param id 要介護認定申請情報の識別子
     * @return 要介護認定申請情報
     * @throws IllegalStateException 指定の識別子に該当する精神手帳任意項目情報がない場合
     */
    public NinteiShinseiJoho getNinteiShinseiJoho(NinteiShinseiJohoIdentifier id) {
        if (ninteiShinseiJoho.contains(id)) {
            return ninteiShinseiJoho.clone().get(id);
        }
        //TODO メッセージの検討
        throw new IllegalArgumentException(UrErrorMessages.不正.toString());
    }

    /**
     * 認定調査スケジュール情報が保持する精神手帳任意項目情報をリストで返します。
     *
     * @return 要介護認定申請情報リスト
     */
    public List<NinteiShinseiJoho> getNinteiShinseiJohoList() {
        return new ArrayList<>(ninteiShinseiJoho.values());

    }

    /**
     * 認定調査スケジュール情報が保持する届出者情報に対して、指定の識別子に該当する届出者情報を返します。
     *
     * @param id  認定調査スケジュールメモ情報の識別子
     * @return 認定調査スケジュールメモ情報
     * @throws IllegalStateException 指定の識別子に該当する届出者情報がない場合
     */
    public NinteiChosaScheduleMemo getNinteiChosaScheduleMemo(NinteiChosaScheduleMemoIdentifier id) {
        if (ninteiChosaScheduleMemo.contains(id)) {
            return ninteiChosaScheduleMemo.clone().get(id);
        }
        //TODO メッセージの検討
        throw new IllegalArgumentException(UrErrorMessages.不正.toString());
    }

    /**
     * 認定調査スケジュール情報が保持する届出者情報をリストで返します。
     *
     * @return 認定調査スケジュールメモ情報リスト
     */
    public List<NinteiChosaScheduleMemo> getNinteiChosaScheduleMemoList() {
        return new ArrayList<>(ninteiChosaScheduleMemo.values());
    }

     /**
     * 認定調査スケジュール情報が保持する届出者情報に対して、指定の識別子に該当する届出者情報を返します。
     *
     * @param id  地区認定調査員の識別子
     * @return 地区認定調査員情報
     * @throws IllegalStateException 指定の識別子に該当する届出者情報がない場合
     */
    public ChikuNinteiChosain getChikuNinteiChosain(ChikuNinteiChosainIdentifier id) {
        if (chikuNinteiChosain.contains(id)) {
            return chikuNinteiChosain.clone().get(id);
        }
        //TODO メッセージの検討
        throw new IllegalArgumentException(UrErrorMessages.不正.toString());
    }

    /**
     * 認定調査スケジュール情報が保持する届出者情報をリストで返します。
     *
     * @return 地区認定調査員情報リスト
     */
    public List<ChikuNinteiChosain> getChikuNinteiChosainList() {
        return new ArrayList<>(chikuNinteiChosain.values());
    }
    
    /**
     * {@link NinteichosaSchedule}のシリアライズ形式を提供します。
     *
     * @return {@link NinteichosaSchedule}のシリアライズ形式
     */
    protected Object writeReplace() {
        return new _SerializationProxy(entity, id, ninteiShinseiJoho, ninteiChosaScheduleMemo,chikuNinteiChosain);
    }

    private static final class _SerializationProxy implements Serializable {

        private static final long serialVersionUID = -710031961519711799L;
        private final DbT5221NinteichosaScheduleEntity entity;
        private final NinteichosaScheduleIdentifier id;
        private final Models<NinteiShinseiJohoIdentifier, NinteiShinseiJoho> ninteiShinseiJoho;
        private final Models<NinteiChosaScheduleMemoIdentifier, NinteiChosaScheduleMemo> ninteiChosaScheduleMemo;
        private final Models<ChikuNinteiChosainIdentifier, ChikuNinteiChosain> chikuNinteiChosain;

        private _SerializationProxy(
                DbT5221NinteichosaScheduleEntity entity,
                NinteichosaScheduleIdentifier id,
                Models<NinteiShinseiJohoIdentifier, NinteiShinseiJoho> ninteishinseijoho,
                Models<NinteiChosaScheduleMemoIdentifier, NinteiChosaScheduleMemo> ninteichosaschedulememo,
                Models<ChikuNinteiChosainIdentifier, ChikuNinteiChosain> chikuninteichosain) {
        
            this.entity = entity;
            this.id = id;
            this.ninteiShinseiJoho = ninteishinseijoho;
            this.ninteiChosaScheduleMemo = ninteichosaschedulememo;
            this.chikuNinteiChosain = chikuninteichosain;
        }

        private Object readResolve() {
            return new NinteichosaSchedule(this.entity, this.id, this.ninteiShinseiJoho, this.ninteiChosaScheduleMemo,this.chikuNinteiChosain);
        }
    }

    /**
     * このクラスの編集を行うBuilderを取得します。<br/>
     * 編集後のインスタンスを取得する場合は{@link NinteichosaScheduleBuilder#build()}を使用してください。
     *
     * @return {@link NinteichosaScheduleBuilder}
     */
    public NinteichosaScheduleBuilder createBuilderForEdit() {
        return new NinteichosaScheduleBuilder(entity, id, ninteiShinseiJoho, ninteiChosaScheduleMemo,chikuNinteiChosain);
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
        final NinteichosaSchedule other = (NinteichosaSchedule) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
}
