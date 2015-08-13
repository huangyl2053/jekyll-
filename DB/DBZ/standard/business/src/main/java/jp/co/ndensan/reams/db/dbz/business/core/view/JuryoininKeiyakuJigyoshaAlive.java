/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.view;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.business.core.uzclasses.ParentModelBase;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbV3077JuryoininKeiyakuJigyoshaEntity;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 受領委任事業者Aliveを管理するクラスです。
 */
public class JuryoininKeiyakuJigyoshaAlive extends ParentModelBase<JuryoininKeiyakuJigyoshaAliveIdentifier, DbV3077JuryoininKeiyakuJigyoshaEntity, JuryoininKeiyakuJigyoshaAlive> implements Serializable {

    private final DbV3077JuryoininKeiyakuJigyoshaEntity entity;
    private final JuryoininKeiyakuJigyoshaAliveIdentifier id;

    /**
     * コンストラクタです。<br/>
     * 受領委任事業者Aliveの新規作成時に使用します。
     *
     * @param 事業者契約番号 事業者契約番号
     * @param 開始年月日 開始年月日
     * @param 履歴番号 履歴番号
     */
    public JuryoininKeiyakuJigyoshaAlive(RString 事業者契約番号,
            FlexibleDate 開始年月日,
            int 履歴番号) {
        requireNonNull(事業者契約番号, UrSystemErrorMessages.値がnull.getReplacedMessage("事業者契約番号"));
        requireNonNull(開始年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("開始年月日"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));
        this.entity = new DbV3077JuryoininKeiyakuJigyoshaEntity();
        this.entity.setJigyoshaKeiyakuNo(事業者契約番号);
        this.entity.setKaishiYMD(開始年月日);
        this.entity.setRirekiNo(履歴番号);
        this.id = new JuryoininKeiyakuJigyoshaAliveIdentifier(
                事業者契約番号,
                開始年月日,
                履歴番号
        );
    }

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link DbV3077JuryoininKeiyakuJigyoshaEntity}より{@link JuryoininKeiyakuJigyoshaAlive}を生成します。
     *
     * @param entity DBより取得した{@link DbV3077JuryoininKeiyakuJigyoshaEntity}
     */
    public JuryoininKeiyakuJigyoshaAlive(DbV3077JuryoininKeiyakuJigyoshaEntity entity) {
        this.entity = requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("受領委任事業者Alive"));
        this.id = new JuryoininKeiyakuJigyoshaAliveIdentifier(
                entity.getJigyoshaKeiyakuNo(),
                entity.getKaishiYMD(),
                entity.getRirekiNo());
    }

    /**
     * シリアライズ、ビルダー用コンストラクタです。
     *
     * @param entity {@link DbV3077JuryoininKeiyakuJigyoshaEntity}
     * @param id {@link JuryoininKeiyakuJigyoshaAliveIdentifier}
     */
    JuryoininKeiyakuJigyoshaAlive(
            DbV3077JuryoininKeiyakuJigyoshaEntity entity,
            JuryoininKeiyakuJigyoshaAliveIdentifier id
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
    public int get履歴番号() {
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
     * {@link DbV3077JuryoininKeiyakuJigyoshaEntity}のクローンを返します。
     *
     * @return {@link DbV3077JuryoininKeiyakuJigyoshaEntity}のクローン
     */
    @Override
    public DbV3077JuryoininKeiyakuJigyoshaEntity toEntity() {
        return this.entity.clone();
    }

    /**
     * 受領委任事業者Aliveの識別子{@link JuryoininKeiyakuJigyoshaAliveIdentifier}を返します。
     *
     * @return 受領委任事業者Aliveの識別子{@link JuryoininKeiyakuJigyoshaAliveIdentifier}
     */
    @Override
    public JuryoininKeiyakuJigyoshaAliveIdentifier identifier() {
        return this.id;
    }

    /**
     * 受領委任事業者Aliveのみを変更対象とします。<br/>
     * {@link DbV3077JuryoininKeiyakuJigyoshaEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば変更状態にします。
     *
     * @return 変更対象処理実施後の{@link JuryoininKeiyakuJigyoshaAlive}
     */
    @Override
    public JuryoininKeiyakuJigyoshaAlive modifiedModel() {
        DbV3077JuryoininKeiyakuJigyoshaEntity modifiedEntity = entity.clone();
        if (modifiedEntity.getState().equals(EntityDataState.Unchanged)) {
            modifiedEntity.setState(EntityDataState.Modified);
        }
        return new JuryoininKeiyakuJigyoshaAlive(
                modifiedEntity, id);
    }

    /**
     * 保持する受領委任事業者Aliveを削除対象とします。<br/>
     * {@link DbV3077JuryoininKeiyakuJigyoshaEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば削除状態にします。
     *
     * @return 削除対象処理実施後の{@link JuryoininKeiyakuJigyoshaAlive}
     */
    @Override
    public JuryoininKeiyakuJigyoshaAlive deleted() {
        DbV3077JuryoininKeiyakuJigyoshaEntity deletedEntity = this.toEntity();
        if (deletedEntity.getState() != EntityDataState.Added) {
            deletedEntity.setState(EntityDataState.Deleted);
        } else {
            //TODO メッセージの検討
            throw new IllegalStateException(UrErrorMessages.不正.toString());
        }
        return new JuryoininKeiyakuJigyoshaAlive(deletedEntity, id);
    }

    /**
     * {@link JuryoininKeiyakuJigyoshaAlive}のシリアライズ形式を提供します。
     *
     * @return {@link JuryoininKeiyakuJigyoshaAlive}のシリアライズ形式
     */
    protected Object writeReplace() {
        return new _SerializationProxy(entity, id);

    }

    @Override
    public boolean hasChanged() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private static final class _SerializationProxy implements Serializable {

        private static final long serialVersionUID = 1L;// TODO serialVersionUIDを生成してください
        private final DbV3077JuryoininKeiyakuJigyoshaEntity entity;
        private final JuryoininKeiyakuJigyoshaAliveIdentifier id;

        private _SerializationProxy(DbV3077JuryoininKeiyakuJigyoshaEntity entity, JuryoininKeiyakuJigyoshaAliveIdentifier id) {
            this.entity = entity;
            this.id = id;
        }

        private Object readResolve() {
            return new JuryoininKeiyakuJigyoshaAlive(this.entity, this.id);
        }
    }

    /**
     * このクラスの編集を行うBuilderを取得します。<br/>
     * 編集後のインスタンスを取得する場合は{@link SeishinTechoNini.createBuilderForEdit#build()}を使用してください。
     *
     * @return Builder
     */
    public JuryoininKeiyakuJigyoshaAliveBuilder createBuilderForEdit() {
        return new JuryoininKeiyakuJigyoshaAliveBuilder(entity, id);
    }

//TODO これはあくまでも雛形によるクラス生成です、必要な業務ロジックの追加、ValueObjectの導出を行う必要があります。
}
