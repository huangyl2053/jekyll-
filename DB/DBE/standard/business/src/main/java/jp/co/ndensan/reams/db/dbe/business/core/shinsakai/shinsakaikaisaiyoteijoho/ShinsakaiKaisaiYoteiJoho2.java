/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.shinsakai.shinsakaikaisaiyoteijoho;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbe.business.core.shinsakai.shinsakaikaisaikekkajoho.ShinsakaiKaisaiKekkaJoho2;
import jp.co.ndensan.reams.db.dbe.business.core.shinsakai.shinsakaikaisaikekkajoho.ShinsakaiKaisaiKekkaJoho2Identifier;
import jp.co.ndensan.reams.db.dbe.business.core.shinsakai.shinsakaionseijoho.ShinsakaiOnseiJoho2;
import jp.co.ndensan.reams.db.dbe.business.core.shinsakai.shinsakaionseijoho.ShinsakaiOnseiJoho2Identifier;
import jp.co.ndensan.reams.db.dbe.business.core.shinsakai.shinsakaiwariateiinjoho.ShinsakaiWariateIinJoho2;
import jp.co.ndensan.reams.db.dbe.business.core.shinsakai.shinsakaiwariateiinjoho.ShinsakaiWariateIinJoho2Identifier;
import jp.co.ndensan.reams.db.dbe.business.core.shinsakai.shinsakaiwariatejoho.ShinsakaiWariateJoho2;
import jp.co.ndensan.reams.db.dbe.business.core.shinsakai.shinsakaiwariatejoho.ShinsakaiWariateJoho2Identifier;
import jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5501ShinsakaiKaisaiYoteiJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5512ShinsakaiOnseiJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shinsakai.shinsakaikaisaiyoteijoho.ShinsakaiKaisaiYoteiJohoRelateEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shinsakai.shinsakaiwariateiinjoho.ShinsakaiWariateIinJohoRelateEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shinsakai.shinsakaiwariatejoho.ShinsakaiWariateJohoRelateEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5511ShinsakaiKaisaiKekkaJohoEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.Models;
import jp.co.ndensan.reams.uz.uza.util.ParentModelBase;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 介護認定審査会開催予定情報を管理するクラスです。
 *
 * @reamsid_L DBE-9999-011 sunhaidi
 */
public class ShinsakaiKaisaiYoteiJoho2
        extends ParentModelBase<ShinsakaiKaisaiYoteiJoho2Identifier, DbT5501ShinsakaiKaisaiYoteiJohoEntity, ShinsakaiKaisaiYoteiJoho2>
        implements Serializable {

    private final DbT5501ShinsakaiKaisaiYoteiJohoEntity entity;
    private final ShinsakaiKaisaiYoteiJoho2Identifier id;
    private final Models<ShinsakaiWariateJoho2Identifier, ShinsakaiWariateJoho2> shinsakaiWariateJoho;
    private final Models<ShinsakaiWariateIinJoho2Identifier, ShinsakaiWariateIinJoho2> shinsakaiWariateIinJoho;
    private final Models<ShinsakaiOnseiJoho2Identifier, ShinsakaiOnseiJoho2> shinsakaiOnseiJoho;
    private final Models<ShinsakaiKaisaiKekkaJoho2Identifier, ShinsakaiKaisaiKekkaJoho2> shinsakaiKaisaiKekkaJoho;

    /**
     * コンストラクタです。<br/>
     * 介護認定審査会開催予定情報の新規作成時に使用します。
     *
     * @param 介護認定審査会開催番号 介護認定審査会開催番号
     */
    public ShinsakaiKaisaiYoteiJoho2(RString 介護認定審査会開催番号) {
        requireNonNull(介護認定審査会開催番号, UrSystemErrorMessages.値がnull.getReplacedMessage("介護認定審査会開催番号"));
        this.entity = new DbT5501ShinsakaiKaisaiYoteiJohoEntity();
        this.entity.setShinsakaiKaisaiNo(介護認定審査会開催番号);
        this.id = new ShinsakaiKaisaiYoteiJoho2Identifier(
                介護認定審査会開催番号
        );
        this.shinsakaiWariateJoho = Models.create(new ArrayList<ShinsakaiWariateJoho2>());
        this.shinsakaiWariateIinJoho = Models.create(new ArrayList<ShinsakaiWariateIinJoho2>());
        this.shinsakaiOnseiJoho = Models.create(new ArrayList<ShinsakaiOnseiJoho2>());
        this.shinsakaiKaisaiKekkaJoho = Models.create(new ArrayList<ShinsakaiKaisaiKekkaJoho2>());
    }

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link DbT5501ShinsakaiKaisaiYoteiJohoEntity}より{@link ShinsakaiKaisaiYoteiJoho2}を生成します。
     *
     * @param entity DBより取得した{@link DbT5501ShinsakaiKaisaiYoteiJohoEntity}
     */
    public ShinsakaiKaisaiYoteiJoho2(ShinsakaiKaisaiYoteiJohoRelateEntity entity) {
        this.entity = requireNonNull(entity.get介護認定審査会開催予定情報Entity(), UrSystemErrorMessages.値がnull.getReplacedMessage("介護認定審査会開催予定情報"));
        this.id = new ShinsakaiKaisaiYoteiJoho2Identifier(
                entity.get介護認定審査会開催予定情報Entity().getShinsakaiKaisaiNo());

        List<ShinsakaiWariateJoho2> shinsakaiWariateJohoList = new ArrayList<>();
        for (ShinsakaiWariateJohoRelateEntity shinsakaiWariateJohoEntity : entity.get介護認定審査会割当情報RelateEntity()) {
            shinsakaiWariateJohoList.add(new ShinsakaiWariateJoho2(shinsakaiWariateJohoEntity));
        }
        this.shinsakaiWariateJoho = Models.create(shinsakaiWariateJohoList);

        List<ShinsakaiWariateIinJoho2> shinsakaiWariateIinJohoList = new ArrayList<>();
        for (ShinsakaiWariateIinJohoRelateEntity shinsakaiWariateIinJohoEntity : entity.get介護認定審査会割当委員情報RelateEntity()) {
            shinsakaiWariateIinJohoList.add(new ShinsakaiWariateIinJoho2(shinsakaiWariateIinJohoEntity));
        }
        this.shinsakaiWariateIinJoho = Models.create(shinsakaiWariateIinJohoList);

        List<ShinsakaiOnseiJoho2> shinsakaiOnseiJohoList = new ArrayList<>();
        for (DbT5512ShinsakaiOnseiJohoEntity shinsakaiOnseiJohoListEntity : entity.get介護認定審査会音声情報Entity()) {
            shinsakaiOnseiJohoList.add(new ShinsakaiOnseiJoho2(shinsakaiOnseiJohoListEntity));
        }
        this.shinsakaiOnseiJoho = Models.create(shinsakaiOnseiJohoList);

        List<ShinsakaiKaisaiKekkaJoho2> shinsakaiKaisaiKekkaJohoList = new ArrayList<>();
        for (DbT5511ShinsakaiKaisaiKekkaJohoEntity shinsakaiKaisaiKekkaJohoEntity : entity.get介護認定審査会開催結果情報Entity()) {
            shinsakaiKaisaiKekkaJohoList.add(new ShinsakaiKaisaiKekkaJoho2(shinsakaiKaisaiKekkaJohoEntity));
        }
        this.shinsakaiKaisaiKekkaJoho = Models.create(shinsakaiKaisaiKekkaJohoList);
    }

    /**
     * シリアライズ、ビルダー用コンストラクタです。
     *
     * @param entity {@link DbT5501ShinsakaiKaisaiYoteiJohoEntity}
     * @param id {@link ShinsakaiKaisaiYoteiJoho2Identifier}
     */
    ShinsakaiKaisaiYoteiJoho2(
            DbT5501ShinsakaiKaisaiYoteiJohoEntity entity,
            ShinsakaiKaisaiYoteiJoho2Identifier id,
            Models<ShinsakaiWariateJoho2Identifier, ShinsakaiWariateJoho2> shinsakaiWariateJoho,
            Models<ShinsakaiWariateIinJoho2Identifier, ShinsakaiWariateIinJoho2> shinsakaiWariateIinJoho,
            Models<ShinsakaiOnseiJoho2Identifier, ShinsakaiOnseiJoho2> shinsakaiOnseiJoho,
            Models<ShinsakaiKaisaiKekkaJoho2Identifier, ShinsakaiKaisaiKekkaJoho2> shinsakaiKaisaiKekkaJoho
    ) {
        this.entity = entity;
        this.id = id;
        this.shinsakaiWariateJoho = shinsakaiWariateJoho;
        this.shinsakaiWariateIinJoho = shinsakaiWariateIinJoho;
        this.shinsakaiOnseiJoho = shinsakaiOnseiJoho;
        this.shinsakaiKaisaiKekkaJoho = shinsakaiKaisaiKekkaJoho;
    }

    /**
     * 介護認定審査会開催番号を返します。
     *
     * @return 介護認定審査会開催番号
     */
    public RString get介護認定審査会開催番号() {
        return entity.getShinsakaiKaisaiNo();
    }

    /**
     * 介護認定審査会開催予定年月日を返します。
     *
     * @return 介護認定審査会開催予定年月日
     */
    public FlexibleDate get介護認定審査会開催予定年月日() {
        return entity.getShinsakaiKaisaiYoteiYMD();
    }

    /**
     * 介護認定審査会開始予定時刻を返します。
     *
     * @return 介護認定審査会開始予定時刻
     */
    public RString get介護認定審査会開始予定時刻() {
        return entity.getShinsakaiKaishiYoteiTime();
    }

    /**
     * 介護認定審査会終了予定時刻を返します。
     *
     * @return 介護認定審査会終了予定時刻
     */
    public RString get介護認定審査会終了予定時刻() {
        return entity.getShinsakaiShuryoYoteiTime();
    }

    /**
     * 介護認定審査会開催予定場所コードを返します。
     *
     * @return 介護認定審査会開催予定場所コード
     */
    public RString get介護認定審査会開催予定場所コード() {
        return entity.getShinsakaiKaisaiYoteiBashoCode();
    }

    /**
     * 合議体番号を返します。
     *
     * @return 合議体番号
     */
    public int get合議体番号() {
        return entity.getGogitaiNo();
    }

    /**
     * 介護認定審査会予定定員を返します。
     *
     * @return 介護認定審査会予定定員
     */
    public int get介護認定審査会予定定員() {
        return entity.getShinsakaiYoteiTeiin();
    }

    /**
     * 介護認定審査会最大定員を返します。
     *
     * @return 介護認定審査会最大定員
     */
    public int get介護認定審査会最大定員() {
        return entity.getShinsakaiSaidaiTeiin();
    }

    /**
     * 介護認定審査会自動割当定員を返します。
     *
     * @return 介護認定審査会自動割当定員
     */
    public int get介護認定審査会自動割当定員() {
        return entity.getShinsakaiJidoWariateTeiin();
    }

    /**
     * 介護認定審査会委員定員を返します。
     *
     * @return 介護認定審査会委員定員
     */
    public int get介護認定審査会委員定員() {
        return entity.getShinsakaiIinTeiin();
    }

    /**
     * 介護認定審査会資料作成年月日を返します。
     *
     * @return 介護認定審査会資料作成年月日
     */
    public FlexibleDate get介護認定審査会資料作成年月日() {
        return entity.getShinsakaiShiryoSakuseiYMD();
    }

    /**
     * 介護認定審査会進捗状況を返します。
     *
     * @return 介護認定審査会進捗状況
     */
    public Code get介護認定審査会進捗状況() {
        return entity.getShinsakaiShinchokuJokyo();
    }

    /**
     * 介護認定審査会割当済み人数を返します。
     *
     * @return 介護認定審査会割当済み人数
     */
    public int get介護認定審査会割当済み人数() {
        return entity.getShinsakaiWariateZumiNinzu();
    }

    /**
     * 資料作成済フラグを返します。
     *
     * @return 資料作成済フラグ
     */
    public boolean is資料作成済フラグ() {
        return entity.getShiryoSakuseiZumiFlag();
    }

    /**
     * モバイルデータ出力年月日を返します。
     *
     * @return モバイルデータ出力年月日
     */
    public FlexibleDate getモバイルデータ出力年月日() {
        return entity.getMobileDataOutputYMD();
    }

    /**
     * {@link DbT5501ShinsakaiKaisaiYoteiJohoEntity}のクローンを返します。
     *
     * @return {@link DbT5501ShinsakaiKaisaiYoteiJohoEntity}のクローン
     */
    @Override
    public DbT5501ShinsakaiKaisaiYoteiJohoEntity toEntity() {
        return this.entity.clone();
    }

    /**
     * 介護認定審査会開催予定情報の識別子{@link ShinsakaiKaisaiYoteiJoho2Identifier}を返します。
     *
     * @return 介護認定審査会開催予定情報の識別子{@link ShinsakaiKaisaiYoteiJoho2Identifier}
     */
    @Override
    public ShinsakaiKaisaiYoteiJoho2Identifier identifier() {
        return this.id;
    }

    /**
     * 介護認定審査会開催予定情報配下の要素を削除対象とします。<br/>
     * {@link DbT5501ShinsakaiKaisaiYoteiJohoEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば削除状態にします。
     * 介護認定審査会開催予定情報配下の要素である精神手帳任意項目情報の{@link Models#deleteOrRemoveAll() }を実行します。
     * 削除処理結果となる{@link ShinsakaiKaisaiYoteiJoho2}を返します。
     *
     * @return 削除対象処理実施後の{@link ShinsakaiKaisaiYoteiJoho2}
     * @throws IllegalStateException
     * DbT5501ShinsakaiKaisaiYoteiJohoEntityのデータ状態が変更の場合
     */
    @Override
    public ShinsakaiKaisaiYoteiJoho2 deleted() {
        DbT5501ShinsakaiKaisaiYoteiJohoEntity deletedEntity = this.toEntity();
        if (!deletedEntity.getState().equals(EntityDataState.Added)) {
            deletedEntity.setState(EntityDataState.Deleted);
        } else {
            //TODO メッセージの検討
            throw new IllegalStateException(UrErrorMessages.不正.toString());
        }
        return new ShinsakaiKaisaiYoteiJoho2(
                deletedEntity, id, shinsakaiWariateJoho.deleted(),
                shinsakaiWariateIinJoho.deleted(), shinsakaiOnseiJoho.deleted(), shinsakaiKaisaiKekkaJoho.deleted());
    }

    @Override
    public boolean hasChanged() {

        return hasChangedEntity()
                || shinsakaiWariateJoho.hasAnyChanged()
                || shinsakaiWariateIinJoho.hasAnyChanged()
                || shinsakaiOnseiJoho.hasAnyChanged() || shinsakaiKaisaiKekkaJoho.hasAnyChanged();

    }

    /**
     * 介護認定審査会開催予定情報のみを変更対象とします。<br/>
     * {@link DbT5501ShinsakaiKaisaiYoteiJohoEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば変更状態にします。
     *
     * @return 変更対象処理実施後の{@link ShinsakaiKaisaiYoteiJoho2}
     */
    @Override
    public ShinsakaiKaisaiYoteiJoho2 modifiedModel() {
        DbT5501ShinsakaiKaisaiYoteiJohoEntity modifiedEntity = entity.clone();
        if (modifiedEntity.getState().equals(EntityDataState.Unchanged)) {
            modifiedEntity.setState(EntityDataState.Modified);
        }
        return new ShinsakaiKaisaiYoteiJoho2(
                modifiedEntity, id, shinsakaiWariateJoho, shinsakaiWariateIinJoho, shinsakaiOnseiJoho, shinsakaiKaisaiKekkaJoho);
    }

    /**
     * 介護認定審査会開催予定情報が保持する精神手帳任意項目情報に対して、指定の識別子に該当する精神手帳任意項目情報を返します。
     *
     * @param id 精神手帳任意項目情報の識別子
     * @return 精神手帳任意項目情報
     * @throws IllegalStateException 指定の識別子に該当する精神手帳任意項目情報がない場合
     */
    public ShinsakaiWariateJoho2 getShinsakaiWariateJoho2(ShinsakaiWariateJoho2Identifier id) {
        if (shinsakaiWariateJoho.contains(id)) {
            return shinsakaiWariateJoho.clone().get(id);
        }
        //TODO メッセージの検討
        throw new IllegalArgumentException(UrErrorMessages.不正.toString());
    }

    /**
     * 介護認定審査会開催予定情報が保持する精神手帳任意項目情報をリストで返します。
     *
     * @return 精神手帳任意項目情報リスト
     */
    public List<ShinsakaiWariateJoho2> getShinsakaiWariateJoho2List() {
        return new ArrayList<>(shinsakaiWariateJoho.values());

    }

    /**
     * 介護認定審査会開催予定情報が保持する介護認定審査会割当委員情報を返します。
     *
     * @param id 介護認定審査会割当委員情報の識別子
     * @return 介護認定審査会割当委員情報
     */
    public ShinsakaiWariateIinJoho2 getShinsakaiWariateIinJoho2(ShinsakaiWariateIinJoho2Identifier id) {
        if (shinsakaiWariateIinJoho.contains(id)) {
            return shinsakaiWariateIinJoho.clone().get(id);
        }
        //TODO メッセージの検討
        throw new IllegalArgumentException(UrErrorMessages.不正.toString());
    }

    /**
     * 介護認定審査会開催予定情報が保持する介護認定審査会割当委員情報をリストで返します。
     *
     * @return 介護認定審査会割当委員情報リスト
     */
    public List<ShinsakaiWariateIinJoho2> getShinsakaiWariateIinJoho2List() {
        return new ArrayList<>(shinsakaiWariateIinJoho.values());
    }

    /**
     * 介護認定審査会開催予定情報が保持する介護認定審査会音声情報を返します。
     *
     * @param id 介護認定審査会音声情報の識別子
     * @return 介護認定審査会音声情報
     */
    public ShinsakaiOnseiJoho2 getShinsakaiOnseiJoho(ShinsakaiOnseiJoho2Identifier id) {
        if (shinsakaiOnseiJoho.contains(id)) {
            return shinsakaiOnseiJoho.clone().get(id);
        }
        //TODO メッセージの検討
        throw new IllegalArgumentException(UrErrorMessages.不正.toString());
    }

    /**
     * 介護認定審査会開催予定情報が保持する介護認定審査会音声情報をリストで返します。
     *
     * @return 介護認定審査会音声情報リスト
     */
    public List<ShinsakaiOnseiJoho2> getShinsakaiOnseiJohoList() {
        return new ArrayList<>(shinsakaiOnseiJoho.values());
    }

    /**
     * 介護認定審査会開催予定情報が保持する介護認定審査会開催結果情報を返します。
     *
     * @param id 介護認定審査会開催結果情報の識別子
     * @return 介護認定審査会開催結果情報
     */
    public ShinsakaiKaisaiKekkaJoho2 getShinsakaiKaisaiKekkaJoho(ShinsakaiKaisaiKekkaJoho2Identifier id) {
        if (shinsakaiKaisaiKekkaJoho.contains(id)) {
            return shinsakaiKaisaiKekkaJoho.clone().get(id);
        }
        //TODO メッセージの検討
        throw new IllegalArgumentException(UrErrorMessages.不正.toString());
    }

    /**
     * 介護認定審査会開催予定情報が保持する介護認定審査会開催結果情報をリストで返します。
     *
     * @return 介護認定審査会開催結果情報リスト
     */
    public List<ShinsakaiKaisaiKekkaJoho2> getShinsakaiKaisaiKekkaJohoList() {
        return new ArrayList<>(shinsakaiKaisaiKekkaJoho.values());
    }

    /**
     * {@link ShinsakaiKaisaiYoteiJoho2}のシリアライズ形式を提供します。
     *
     * @return {@link ShinsakaiKaisaiYoteiJoho2}のシリアライズ形式
     */
    protected Object writeReplace() {
        return new _SerializationProxy(entity, id, shinsakaiWariateJoho, shinsakaiWariateIinJoho, shinsakaiOnseiJoho, shinsakaiKaisaiKekkaJoho);
    }

    private static final class _SerializationProxy implements Serializable {

        private static final long serialVersionUID = -710031961519711799L;
        private final DbT5501ShinsakaiKaisaiYoteiJohoEntity entity;
        private final ShinsakaiKaisaiYoteiJoho2Identifier id;
        private final Models<ShinsakaiWariateJoho2Identifier, ShinsakaiWariateJoho2> shinsakaiWariateJoho;
        private final Models<ShinsakaiWariateIinJoho2Identifier, ShinsakaiWariateIinJoho2> shinsakaiWariateIinJoho;
        private final Models<ShinsakaiOnseiJoho2Identifier, ShinsakaiOnseiJoho2> shinsakaiOnseiJoho;
        private final Models<ShinsakaiKaisaiKekkaJoho2Identifier, ShinsakaiKaisaiKekkaJoho2> shinsakaiKaisaiKekkaJoho;

        private _SerializationProxy(
                DbT5501ShinsakaiKaisaiYoteiJohoEntity entity,
                ShinsakaiKaisaiYoteiJoho2Identifier id,
                Models<ShinsakaiWariateJoho2Identifier, ShinsakaiWariateJoho2> shinsakaiWariateJoho,
                Models<ShinsakaiWariateIinJoho2Identifier, ShinsakaiWariateIinJoho2> shinsakaiWariateIinJoho,
                Models<ShinsakaiOnseiJoho2Identifier, ShinsakaiOnseiJoho2> shinsakaiOnseiJoho,
                Models<ShinsakaiKaisaiKekkaJoho2Identifier, ShinsakaiKaisaiKekkaJoho2> shinsakaiKaisaiKekkaJoho
        ) {
            this.entity = entity;
            this.id = id;
            this.shinsakaiWariateJoho = shinsakaiWariateJoho;
            this.shinsakaiWariateIinJoho = shinsakaiWariateIinJoho;
            this.shinsakaiOnseiJoho = shinsakaiOnseiJoho;
            this.shinsakaiKaisaiKekkaJoho = shinsakaiKaisaiKekkaJoho;
        }

        private Object readResolve() {
            return new ShinsakaiKaisaiYoteiJoho2(this.entity,
                    this.id, this.shinsakaiWariateJoho,
                    this.shinsakaiWariateIinJoho,
                    this.shinsakaiOnseiJoho, this.shinsakaiKaisaiKekkaJoho);
        }
    }

    /**
     * このクラスの編集を行うBuilderを取得します。<br/>
     * 編集後のインスタンスを取得する場合は{@link ShinsakaiKaisaiYoteiJoho2Builder#build()}を使用してください。
     *
     * @return {@link ShinsakaiKaisaiYoteiJoho2Builder}
     */
    public ShinsakaiKaisaiYoteiJoho2Builder createBuilderForEdit() {
        return new ShinsakaiKaisaiYoteiJoho2Builder(entity, id,
                shinsakaiWariateJoho, shinsakaiWariateIinJoho,
                shinsakaiOnseiJoho, shinsakaiKaisaiKekkaJoho);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.id);
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
        final ShinsakaiKaisaiYoteiJoho2 other = (ShinsakaiKaisaiYoteiJoho2) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
}
