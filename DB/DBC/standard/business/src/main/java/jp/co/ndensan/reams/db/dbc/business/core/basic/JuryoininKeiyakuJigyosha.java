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
import jp.co.ndensan.reams.db.dbc.entity.db.basic.dbc.DbT3077JuryoininKeiyakuJigyoshaEntity;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 受領委任契約事業者を管理するクラスです。
 */
public class JuryoininKeiyakuJigyosha extends ParentModelBase<JuryoininKeiyakuJigyoshaIdentifier, DbT3077JuryoininKeiyakuJigyoshaEntity, JuryoininKeiyakuJigyosha> implements Serializable {

    private final DbT3077JuryoininKeiyakuJigyoshaEntity entity;
    private final JuryoininKeiyakuJigyoshaIdentifier id;

    /**
     * コンストラクタです。<br/>
     * 受領委任契約事業者の新規作成時に使用します。
     *
     * @param 事業者契約番号 事業者契約番号
     * @param 開始年月日 開始年月日
     * @param 履歴番号 履歴番号
     */
    public JuryoininKeiyakuJigyosha(RString 事業者契約番号,
FlexibleDate 開始年月日,
Decimal 履歴番号) {
        requireNonNull(事業者契約番号, UrSystemErrorMessages.値がnull.getReplacedMessage("事業者契約番号"));
        requireNonNull(開始年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("開始年月日"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));
        this.entity = new DbT3077JuryoininKeiyakuJigyoshaEntity();
        this.entity.setJigyoshaKeiyakuNo(事業者契約番号);
        this.entity.setKaishiYMD(開始年月日);
        this.entity.setRirekiNo(履歴番号);
        this.id = new JuryoininKeiyakuJigyoshaIdentifier(
        事業者契約番号,
        開始年月日,
        履歴番号
                );
    }

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link DbT3077JuryoininKeiyakuJigyoshaEntity}より{@link JuryoininKeiyakuJigyosha}を生成します。
     *
     * @param entity DBより取得した{@link DbT3077JuryoininKeiyakuJigyoshaEntity}
     */
    public JuryoininKeiyakuJigyosha(DbT3077JuryoininKeiyakuJigyoshaEntity entity) {
        this.entity = requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("受領委任契約事業者"));
        this.id = new JuryoininKeiyakuJigyoshaIdentifier(
                entity.getJigyoshaKeiyakuNo(),
                entity.getKaishiYMD(),
                entity.getRirekiNo());
    }

    /**
     * シリアライズ、ビルダー用コンストラクタです。
     *
     * @param entity {@link DbT3077JuryoininKeiyakuJigyoshaEntity}
     * @param id {@link JuryoininKeiyakuJigyoshaIdentifier}
     */
    JuryoininKeiyakuJigyosha(
            DbT3077JuryoininKeiyakuJigyoshaEntity entity,
            JuryoininKeiyakuJigyoshaIdentifier id
    ) {
        this.entity = entity;
        this.id = id;
    }

//TODO getterを見直してください。意味のある単位でValueObjectを作成して公開してください。
    /**
     * 事業者契約番号を返します。
     *
     * @return 事業者契約番号
     */
    public RString get事業者契約番号() {
        return entity.getJigyoshaKeiyakuNo();
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
     * 履歴番号を返します。
     *
     * @return 履歴番号
     */
    public Decimal get履歴番号() {
        return entity.getRirekiNo();
    }

    /**
     * 終了年月日を返します。
     *
     * @return 終了年月日
     */
    public FlexibleDate get終了年月日() {
        return entity.getShuryoYMD();
    }

    /**
     * 届出年月日を返します。
     *
     * @return 届出年月日
     */
    public FlexibleDate get届出年月日() {
        return entity.getTodokedeYMD();
    }

    /**
     * 届出者住所を返します。
     *
     * @return 届出者住所
     */
    public RString get届出者住所() {
        return entity.getTodokedeAddress();
    }

    /**
     * 届出者事業者名称を返します。
     *
     * @return 届出者事業者名称
     */
    public RString get届出者事業者名称() {
        return entity.getTodokedeJigyoshaName();
    }

    /**
     * 届出者代表者氏名を返します。
     *
     * @return 届出者代表者氏名
     */
    public RString get届出者代表者氏名() {
        return entity.getTodokedeDaihyoshaName();
    }

    /**
     * 金融機関コードを返します。
     *
     * @return 金融機関コード
     */
    public KinyuKikanCode get金融機関コード() {
        return entity.getKinyuKikanCode();
    }

    /**
     * 支店コードを返します。
     *
     * @return 支店コード
     */
    public KinyuKikanShitenCode get支店コード() {
        return entity.getShitenCode();
    }

    /**
     * 口座種別を返します。
     *
     * @return 口座種別
     */
    public RString get口座種別() {
        return entity.getKozaShubetsu();
    }

    /**
     * 口座番号を返します。
     *
     * @return 口座番号
     */
    public RString get口座番号() {
        return entity.getKozaNo();
    }

    /**
     * 通帳記号を返します。
     *
     * @return 通帳記号
     */
    public RString get通帳記号() {
        return entity.getTsuchoKigo();
    }

    /**
     * 通帳番号を返します。
     *
     * @return 通帳番号
     */
    public RString get通帳番号() {
        return entity.getTsuchoNo();
    }

    /**
     * 口座名義人を返します。
     *
     * @return 口座名義人
     */
    public AtenaKanaMeisho get口座名義人() {
        return entity.getKozaMeiginin();
    }

    /**
     * 口座名義人漢字を返します。
     *
     * @return 口座名義人漢字
     */
    public AtenaMeisho get口座名義人漢字() {
        return entity.getKozaMeigininKanji();
    }

    /**
     * 事業者FAX番号を返します。
     *
     * @return 事業者FAX番号
     */
    public TelNo get事業者FAX番号() {
        return entity.getJigyoshaFaxNo();
    }

    /**
     * 契約登録年月日を返します。
     *
     * @return 契約登録年月日
     */
    public FlexibleDate get契約登録年月日() {
        return entity.getKeiyakuTorokuYMD();
    }

    /**
     * 送付先部署を返します。
     *
     * @return 送付先部署
     */
    public RString get送付先部署() {
        return entity.getSofusakiBusho();
    }

    /**
     * 営業形態を返します。
     *
     * @return 営業形態
     */
    public RString get営業形態() {
        return entity.getEigyoKeitai();
    }

    /**
     * 住宅改修契約有無を返します。
     *
     * @return 住宅改修契約有無
     */
    public boolean get住宅改修契約有無() {
        return entity.getJutakuKaishuKeiyakuUmu();
    }

    /**
     * 特定福祉用具販売契約有無を返します。
     *
     * @return 特定福祉用具販売契約有無
     */
    public boolean get特定福祉用具販売契約有無() {
        return entity.getTokuteiFukushiYoguHanbaiKeiyakuUmu();
    }

    /**
     * 償還払給付契約有無を返します。
     *
     * @return 償還払給付契約有無
     */
    public boolean get償還払給付契約有無() {
        return entity.getShokanbaraiKyufuKeiyakuUmu();
    }

    /**
     * 高額給付契約有無を返します。
     *
     * @return 高額給付契約有無
     */
    public boolean get高額給付契約有無() {
        return entity.getKogakuKyufuKeiyakuUmu();
    }

    /**
     * 契約事業者番号を返します。
     *
     * @return 契約事業者番号
     */
    public JigyoshaNo get契約事業者番号() {
        return entity.getKeiyakuJigyoshaNo();
    }

    /**
     * 取扱確約書有無を返します。
     *
     * @return 取扱確約書有無
     */
    public boolean get取扱確約書有無() {
        return entity.getToriatsukaiKakuyakushoUmu();
    }

    /**
     * {@link DbT3077JuryoininKeiyakuJigyoshaEntity}のクローンを返します。
     *
     * @return {@link DbT3077JuryoininKeiyakuJigyoshaEntity}のクローン
     */
    @Override
    public DbT3077JuryoininKeiyakuJigyoshaEntity toEntity() {
        return this.entity.clone();
    }

    /**
     * 受領委任契約事業者の識別子{@link JuryoininKeiyakuJigyoshaIdentifier}を返します。
     *
     * @return 受領委任契約事業者の識別子{@link JuryoininKeiyakuJigyoshaIdentifier}
     */
    @Override
    public JuryoininKeiyakuJigyoshaIdentifier identifier() {
        return this.id;
    }

    /**
     * 受領委任契約事業者のみを変更対象とします。<br/>
     * {@link DbT3077JuryoininKeiyakuJigyoshaEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば変更状態にします。
     *
     * @return 変更対象処理実施後の{@link JuryoininKeiyakuJigyosha}
     */
    @Override
    public JuryoininKeiyakuJigyosha modifiedModel() {
        DbT3077JuryoininKeiyakuJigyoshaEntity modifiedEntity = this.toEntity();
        if (!modifiedEntity.getState().equals(EntityDataState.Added)) {
            modifiedEntity.setState(EntityDataState.Modified);
        }
        return new JuryoininKeiyakuJigyosha(
                modifiedEntity, id);
    }

    /**
     * 保持する受領委任契約事業者を削除対象とします。<br/>
     * {@link DbT3077JuryoininKeiyakuJigyoshaEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば削除状態にします。
     *
     * @return 削除対象処理実施後の{@link JuryoininKeiyakuJigyosha}
     */
    @Override
    public JuryoininKeiyakuJigyosha deleted() {
        DbT3077JuryoininKeiyakuJigyoshaEntity deletedEntity = this.toEntity();
        if (deletedEntity.getState() != EntityDataState.Added) {
            deletedEntity.setState(EntityDataState.Deleted);
        } else {
            //TODO メッセージの検討
            throw new IllegalStateException(UrErrorMessages.不正.toString());
        }
        return new JuryoininKeiyakuJigyosha(deletedEntity, id);
    }
    /**
     * {@link JuryoininKeiyakuJigyosha}のシリアライズ形式を提供します。
     *
     * @return {@link JuryoininKeiyakuJigyosha}のシリアライズ形式
     */
    protected Object writeReplace() {
        return new _SerializationProxy(entity, id);

    }

    private static final class _SerializationProxy implements Serializable {

        private static final long serialVersionUID = // TODO serialVersionUIDを生成してください
        private final DbT3077JuryoininKeiyakuJigyoshaEntity entity;
        private final JuryoininKeiyakuJigyoshaIdentifier id;

        private _SerializationProxy(DbT3077JuryoininKeiyakuJigyoshaEntity entity,JuryoininKeiyakuJigyoshaIdentifier id) {
            this.entity = entity;
            this.id = id;
        }

        private Object readResolve() {
            return new JuryoininKeiyakuJigyosha(this.entity, this.id);
        }
    }

    /**
     * このクラスの編集を行うBuilderを取得します。<br/>
     * 編集後のインスタンスを取得する場合は{@link SeishinTechoNini.createBuilderForEdit#build()}を使用してください。
     *
     * @return Builder
     */
    public JuryoininKeiyakuJigyoshaBuilder createBuilderForEdit() {
        return new JuryoininKeiyakuJigyoshaBuilder(entity, id);
    }

//TODO これはあくまでも雛形によるクラス生成です、必要な業務ロジックの追加、ValueObjectの導出を行う必要があります。
}
