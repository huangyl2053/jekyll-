/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.core.basic;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.DbT2014TsuchishoUchiwakeJokenEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.ModelBase;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 通知書打ち分け条件を管理するクラスです。
 */
public class TsuchishoUchiwakeJoken
        extends ModelBase<TsuchishoUchiwakeJokenIdentifier, DbT2014TsuchishoUchiwakeJokenEntity, TsuchishoUchiwakeJoken>
        implements Serializable {

    private final DbT2014TsuchishoUchiwakeJokenEntity entity;
    private final TsuchishoUchiwakeJokenIdentifier id;

    /**
     * コンストラクタです。<br/>
     * 通知書打ち分け条件の新規作成時に使用します。
     *
     * @param 打ち分け条件 打ち分け条件
     * @param 保存日時 保存日時
     * @param 賦課処理区分 賦課処理区分
     */
    public TsuchishoUchiwakeJoken(RString 打ち分け条件,
            RDateTime 保存日時,
            RString 賦課処理区分) {
        requireNonNull(打ち分け条件, UrSystemErrorMessages.値がnull.getReplacedMessage("打ち分け条件"));
        requireNonNull(保存日時, UrSystemErrorMessages.値がnull.getReplacedMessage("保存日時"));
        requireNonNull(賦課処理区分, UrSystemErrorMessages.値がnull.getReplacedMessage("賦課処理区分"));
        this.entity = new DbT2014TsuchishoUchiwakeJokenEntity();
        this.entity.setUchiwakeJoken(打ち分け条件);
        this.entity.setHozonDateTime(保存日時);
        this.entity.setFukaShoriKubun(賦課処理区分);
        this.id = new TsuchishoUchiwakeJokenIdentifier(
                打ち分け条件,
                保存日時,
                賦課処理区分
        );
    }

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link DbT2014TsuchishoUchiwakeJokenEntity}より{@link TsuchishoUchiwakeJoken}を生成します。
     *
     * @param entity DBより取得した{@link DbT2014TsuchishoUchiwakeJokenEntity}
     */
    public TsuchishoUchiwakeJoken(DbT2014TsuchishoUchiwakeJokenEntity entity) {
        this.entity = requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("通知書打ち分け条件"));
        this.id = new TsuchishoUchiwakeJokenIdentifier(
                entity.getUchiwakeJoken(),
                entity.getHozonDateTime(),
                entity.getFukaShoriKubun());
    }

    /**
     * シリアライズ、ビルダー用コンストラクタです。
     *
     * @param entity {@link DbT2014TsuchishoUchiwakeJokenEntity}
     * @param id {@link TsuchishoUchiwakeJokenIdentifier}
     */
    TsuchishoUchiwakeJoken(
            DbT2014TsuchishoUchiwakeJokenEntity entity,
            TsuchishoUchiwakeJokenIdentifier id
    ) {
        this.entity = entity;
        this.id = id;
    }

//TODO getterを見直してください。意味のある単位でValueObjectを作成して公開してください。
    /**
     * 打ち分け条件を返します。
     *
     * @return 打ち分け条件
     */
    public RString get打ち分け条件() {
        return entity.getUchiwakeJoken();
    }

    /**
     * 保存日時を返します。
     *
     * @return 保存日時
     */
    public RDateTime get保存日時() {
        return entity.getHozonDateTime();
    }

    /**
     * 賦課処理区分を返します。
     *
     * @return 賦課処理区分
     */
    public RString get賦課処理区分() {
        return entity.getFukaShoriKubun();
    }

    /**
     * 選択通知書01を返します。
     *
     * @return 選択通知書01
     */
    public RString get選択通知書01() {
        return entity.getSelectTsuchisho01();
    }

    /**
     * 選択現金口座01を返します。
     *
     * @return 選択現金口座01
     */
    public RString get選択現金口座01() {
        return entity.getSelectGenkinKoza01();
    }

    /**
     * 出力順グループ名01を返します。
     *
     * @return 出力順グループ名01
     */
    public RString get出力順グループ名01() {
        return entity.getSortGroupName01();
    }

    /**
     * 選択通知書02を返します。
     *
     * @return 選択通知書02
     */
    public RString get選択通知書02() {
        return entity.getSelectTsuchisho02();
    }

    /**
     * 選択現金口座02を返します。
     *
     * @return 選択現金口座02
     */
    public RString get選択現金口座02() {
        return entity.getSelectGenkinKoza02();
    }

    /**
     * 出力順グループ名02を返します。
     *
     * @return 出力順グループ名02
     */
    public RString get出力順グループ名02() {
        return entity.getSortGroupName02();
    }

    /**
     * 選択通知書03を返します。
     *
     * @return 選択通知書03
     */
    public RString get選択通知書03() {
        return entity.getSelectTsuchisho03();
    }

    /**
     * 選択現金口座03を返します。
     *
     * @return 選択現金口座03
     */
    public RString get選択現金口座03() {
        return entity.getSelectGenkinKoza03();
    }

    /**
     * 出力順グループ名03を返します。
     *
     * @return 出力順グループ名03
     */
    public RString get出力順グループ名03() {
        return entity.getSortGroupName03();
    }

    /**
     * 選択通知書04を返します。
     *
     * @return 選択通知書04
     */
    public RString get選択通知書04() {
        return entity.getSelectTsuchisho04();
    }

    /**
     * 選択現金口座04を返します。
     *
     * @return 選択現金口座04
     */
    public RString get選択現金口座04() {
        return entity.getSelectGenkinKoza04();
    }

    /**
     * 出力順グループ名04を返します。
     *
     * @return 出力順グループ名04
     */
    public RString get出力順グループ名04() {
        return entity.getSortGroupName04();
    }

    /**
     * 選択通知書05を返します。
     *
     * @return 選択通知書05
     */
    public RString get選択通知書05() {
        return entity.getSelectTsuchisho05();
    }

    /**
     * 選択現金口座05を返します。
     *
     * @return 選択現金口座05
     */
    public RString get選択現金口座05() {
        return entity.getSelectGenkinKoza05();
    }

    /**
     * 出力順グループ名05を返します。
     *
     * @return 出力順グループ名05
     */
    public RString get出力順グループ名05() {
        return entity.getSortGroupName05();
    }

    /**
     * 選択通知書06を返します。
     *
     * @return 選択通知書06
     */
    public RString get選択通知書06() {
        return entity.getSelectTsuchisho06();
    }

    /**
     * 選択現金口座06を返します。
     *
     * @return 選択現金口座06
     */
    public RString get選択現金口座06() {
        return entity.getSelectGenkinKoza06();
    }

    /**
     * 出力順グループ名06を返します。
     *
     * @return 出力順グループ名06
     */
    public RString get出力順グループ名06() {
        return entity.getSortGroupName06();
    }

    /**
     * 選択通知書07を返します。
     *
     * @return 選択通知書07
     */
    public RString get選択通知書07() {
        return entity.getSelectTsuchisho07();
    }

    /**
     * 選択現金口座07を返します。
     *
     * @return 選択現金口座07
     */
    public RString get選択現金口座07() {
        return entity.getSelectGenkinKoza07();
    }

    /**
     * 出力順グループ名07を返します。
     *
     * @return 出力順グループ名07
     */
    public RString get出力順グループ名07() {
        return entity.getSortGroupName07();
    }

    /**
     * 選択通知書08を返します。
     *
     * @return 選択通知書08
     */
    public RString get選択通知書08() {
        return entity.getSelectTsuchisho08();
    }

    /**
     * 選択現金口座08を返します。
     *
     * @return 選択現金口座08
     */
    public RString get選択現金口座08() {
        return entity.getSelectGenkinKoza08();
    }

    /**
     * 出力順グループ名08を返します。
     *
     * @return 出力順グループ名08
     */
    public RString get出力順グループ名08() {
        return entity.getSortGroupName08();
    }

    /**
     * 選択通知書09を返します。
     *
     * @return 選択通知書09
     */
    public RString get選択通知書09() {
        return entity.getSelectTsuchisho09();
    }

    /**
     * 選択現金口座09を返します。
     *
     * @return 選択現金口座09
     */
    public RString get選択現金口座09() {
        return entity.getSelectGenkinKoza09();
    }

    /**
     * 出力順グループ名09を返します。
     *
     * @return 出力順グループ名09
     */
    public RString get出力順グループ名09() {
        return entity.getSortGroupName09();
    }

    /**
     * 選択通知書10を返します。
     *
     * @return 選択通知書10
     */
    public RString get選択通知書10() {
        return entity.getSelectTsuchisho10();
    }

    /**
     * 選択現金口座10を返します。
     *
     * @return 選択現金口座10
     */
    public RString get選択現金口座10() {
        return entity.getSelectGenkinKoza10();
    }

    /**
     * 出力順グループ名10を返します。
     *
     * @return 出力順グループ名10
     */
    public RString get出力順グループ名10() {
        return entity.getSortGroupName10();
    }

    /**
     * 選択通知書11を返します。
     *
     * @return 選択通知書11
     */
    public RString get選択通知書11() {
        return entity.getSelectTsuchisho11();
    }

    /**
     * 選択現金口座11を返します。
     *
     * @return 選択現金口座11
     */
    public RString get選択現金口座11() {
        return entity.getSelectGenkinKoza11();
    }

    /**
     * 出力順グループ名11を返します。
     *
     * @return 出力順グループ名11
     */
    public RString get出力順グループ名11() {
        return entity.getSortGroupName11();
    }

    /**
     * 選択通知書12を返します。
     *
     * @return 選択通知書12
     */
    public RString get選択通知書12() {
        return entity.getSelectTsuchisho12();
    }

    /**
     * 選択現金口座12を返します。
     *
     * @return 選択現金口座12
     */
    public RString get選択現金口座12() {
        return entity.getSelectGenkinKoza12();
    }

    /**
     * 出力順グループ名12を返します。
     *
     * @return 出力順グループ名12
     */
    public RString get出力順グループ名12() {
        return entity.getSortGroupName12();
    }

    /**
     * 選択通知書13を返します。
     *
     * @return 選択通知書13
     */
    public RString get選択通知書13() {
        return entity.getSelectTsuchisho13();
    }

    /**
     * 選択現金口座13を返します。
     *
     * @return 選択現金口座13
     */
    public RString get選択現金口座13() {
        return entity.getSelectGenkinKoza13();
    }

    /**
     * 出力順グループ名13を返します。
     *
     * @return 出力順グループ名13
     */
    public RString get出力順グループ名13() {
        return entity.getSortGroupName13();
    }

    /**
     * 選択通知書14を返します。
     *
     * @return 選択通知書14
     */
    public RString get選択通知書14() {
        return entity.getSelectTsuchisho14();
    }

    /**
     * 選択現金口座14を返します。
     *
     * @return 選択現金口座14
     */
    public RString get選択現金口座14() {
        return entity.getSelectGenkinKoza14();
    }

    /**
     * 出力順グループ名14を返します。
     *
     * @return 出力順グループ名14
     */
    public RString get出力順グループ名14() {
        return entity.getSortGroupName14();
    }

    /**
     * 選択通知書15を返します。
     *
     * @return 選択通知書15
     */
    public RString get選択通知書15() {
        return entity.getSelectTsuchisho15();
    }

    /**
     * 選択現金口座15を返します。
     *
     * @return 選択現金口座15
     */
    public RString get選択現金口座15() {
        return entity.getSelectGenkinKoza15();
    }

    /**
     * 出力順グループ名15を返します。
     *
     * @return 出力順グループ名15
     */
    public RString get出力順グループ名15() {
        return entity.getSortGroupName15();
    }

    /**
     * {@link DbT2014TsuchishoUchiwakeJokenEntity}のクローンを返します。
     *
     * @return {@link DbT2014TsuchishoUchiwakeJokenEntity}のクローン
     */
    @Override
    public DbT2014TsuchishoUchiwakeJokenEntity toEntity() {
        return this.entity.clone();
    }

    /**
     * 通知書打ち分け条件の識別子{@link TsuchishoUchiwakeJokenIdentifier}を返します。
     *
     * @return 通知書打ち分け条件の識別子{@link TsuchishoUchiwakeJokenIdentifier}
     */
    @Override
    public TsuchishoUchiwakeJokenIdentifier identifier() {
        return this.id;
    }

    /**
     * 保持する通知書打ち分け条件を削除対象とします。<br/>
     * {@link DbT2014TsuchishoUchiwakeJokenEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば削除状態にします。
     *
     * @return 削除対象処理実施後の{@link TsuchishoUchiwakeJoken}
     */
    @Override
    public TsuchishoUchiwakeJoken deleted() {
        DbT2014TsuchishoUchiwakeJokenEntity deletedEntity = this.toEntity();
        if (deletedEntity.getState() != EntityDataState.Added) {
            deletedEntity.setState(EntityDataState.Deleted);
        } else {
            //TODO メッセージの検討
            throw new IllegalStateException(UrErrorMessages.不正.toString());
        }
        return new TsuchishoUchiwakeJoken(deletedEntity, id);
    }

    /**
     * {@link TsuchishoUchiwakeJoken}のシリアライズ形式を提供します。
     *
     * @return {@link TsuchishoUchiwakeJoken}のシリアライズ形式
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
        private final DbT2014TsuchishoUchiwakeJokenEntity entity;
        private final TsuchishoUchiwakeJokenIdentifier id;

        private _SerializationProxy(DbT2014TsuchishoUchiwakeJokenEntity entity, TsuchishoUchiwakeJokenIdentifier id) {
            this.entity = entity;
            this.id = id;
        }

        private Object readResolve() {
            return new TsuchishoUchiwakeJoken(this.entity, this.id);
        }
    }

    /**
     * このクラスの編集を行うBuilderを取得します。<br/>
     * 編集後のインスタンスを取得する場合は{@link SeishinTechoNini.createBuilderForEdit#build()}を使用してください。
     *
     * @return Builder
     */
    public TsuchishoUchiwakeJokenBuilder createBuilderForEdit() {
        return new TsuchishoUchiwakeJokenBuilder(entity, id);
    }

//TODO これはあくまでも雛形によるクラス生成です、必要な業務ロジックの追加、ValueObjectの導出を行う必要があります。
}
