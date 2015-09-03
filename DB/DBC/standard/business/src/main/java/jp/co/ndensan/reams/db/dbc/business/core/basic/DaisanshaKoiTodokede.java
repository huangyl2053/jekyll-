/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.entity.basic.DbT3084DaisanshaKoiTodokedeEntity;
import jp.co.ndensan.reams.db.dbz.business.core.uzclasses.ModelBase;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 介護第三者行為届出を管理するクラスです。
 */
public class DaisanshaKoiTodokede extends ModelBase<DaisanshaKoiTodokedeIdentifier, DbT3084DaisanshaKoiTodokedeEntity, DaisanshaKoiTodokede> implements Serializable {

    private final DbT3084DaisanshaKoiTodokedeEntity entity;
    private final DaisanshaKoiTodokedeIdentifier id;

    /**
     * コンストラクタです。<br/>
     * 介護第三者行為届出の新規作成時に使用します。
     *
     * @param 被保険者番号 被保険者番号
     * @param 第三者行為届出管理番号 第三者行為届出管理番号
     * @param 履歴番号 履歴番号
     */
    public DaisanshaKoiTodokede(HihokenshaNo 被保険者番号,
            RString 第三者行為届出管理番号,
            Decimal 履歴番号) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(第三者行為届出管理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("第三者行為届出管理番号"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));
        this.entity = new DbT3084DaisanshaKoiTodokedeEntity();
        this.entity.setHihokenshaNo(被保険者番号);
        this.entity.setTodokedeKanriNo(第三者行為届出管理番号);
        this.entity.setRirekiNo(履歴番号);
        this.id = new DaisanshaKoiTodokedeIdentifier(
                被保険者番号,
                第三者行為届出管理番号,
                履歴番号
        );
    }

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link DbT3084DaisanshaKoiTodokedeEntity}より{@link DaisanshaKoiTodokede}を生成します。
     *
     * @param entity DBより取得した{@link DbT3084DaisanshaKoiTodokedeEntity}
     */
    public DaisanshaKoiTodokede(DbT3084DaisanshaKoiTodokedeEntity entity) {
        this.entity = requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("介護第三者行為届出"));
        this.id = new DaisanshaKoiTodokedeIdentifier(
                entity.getHihokenshaNo(),
                entity.getTodokedeKanriNo(),
                entity.getRirekiNo());
    }

    /**
     * シリアライズ、ビルダー用コンストラクタです。
     *
     * @param entity {@link DbT3084DaisanshaKoiTodokedeEntity}
     * @param id {@link DaisanshaKoiTodokedeIdentifier}
     */
    DaisanshaKoiTodokede(
            DbT3084DaisanshaKoiTodokedeEntity entity,
            DaisanshaKoiTodokedeIdentifier id
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
        return entity.getHihokenshaNo();
    }

    /**
     * 第三者行為届出管理番号を返します。
     *
     * @return 第三者行為届出管理番号
     */
    public RString get第三者行為届出管理番号() {
        return entity.getTodokedeKanriNo();
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
     * 届出年月日を返します。
     *
     * @return 届出年月日
     */
    public FlexibleDate get届出年月日() {
        return entity.getTodokedeYMD();
    }

    /**
     * 届出人郵便番号を返します。
     *
     * @return 届出人郵便番号
     */
    public YubinNo get届出人郵便番号() {
        return entity.getTodokedenin_YubinNo();
    }

    /**
     * 届出人住所を返します。
     *
     * @return 届出人住所
     */
    public RString get届出人住所() {
        return entity.getTodokedenin_Jusho();
    }

    /**
     * 届出人氏名カナを返します。
     *
     * @return 届出人氏名カナ
     */
    public AtenaKanaMeisho get届出人氏名カナ() {
        return entity.getTodokedenin_ShimeiKana();
    }

    /**
     * 届出人氏名を返します。
     *
     * @return 届出人氏名
     */
    public AtenaMeisho get届出人氏名() {
        return entity.getTodokedenin_Shimei();
    }

    /**
     * 届出人電話番号を返します。
     *
     * @return 届出人電話番号
     */
    public TelNo get届出人電話番号() {
        return entity.getTodokedenin_TelNo();
    }

    /**
     * 届出人との続柄を返します。
     *
     * @return 届出人との続柄
     */
    public RString get届出人との続柄() {
        return entity.getTodokedenin_Zokugara();
    }

    /**
     * 要介護状態区分を返します。
     *
     * @return 要介護状態区分
     */
    public Code get要介護状態区分() {
        return entity.getYokaigoJotaiKubun();
    }

    /**
     * 認定有効期間開始年月日を返します。
     *
     * @return 認定有効期間開始年月日
     */
    public FlexibleDate get認定有効期間開始年月日() {
        return entity.getNinteiYukoKaishiYMD();
    }

    /**
     * 認定有効期間終了年月日を返します。
     *
     * @return 認定有効期間終了年月日
     */
    public FlexibleDate get認定有効期間終了年月日() {
        return entity.getNinteiYukoShuryoYMD();
    }

    /**
     * 加害者郵便番号を返します。
     *
     * @return 加害者郵便番号
     */
    public YubinNo get加害者郵便番号() {
        return entity.getKagaisha_YubinNo();
    }

    /**
     * 加害者住所を返します。
     *
     * @return 加害者住所
     */
    public RString get加害者住所() {
        return entity.getKagaisha_Jusho();
    }

    /**
     * 加害者氏名カナを返します。
     *
     * @return 加害者氏名カナ
     */
    public AtenaKanaMeisho get加害者氏名カナ() {
        return entity.getKagaisha_ShimeiKana();
    }

    /**
     * 加害者氏名を返します。
     *
     * @return 加害者氏名
     */
    public AtenaMeisho get加害者氏名() {
        return entity.getKagansha_Shimei();
    }

    /**
     * 加害者生年月日を返します。
     *
     * @return 加害者生年月日
     */
    public FlexibleDate get加害者生年月日() {
        return entity.getKagaisha_UmareYMD();
    }

    /**
     * 加害者電話番号を返します。
     *
     * @return 加害者電話番号
     */
    public TelNo get加害者電話番号() {
        return entity.getKagaisha_TelNo();
    }

    /**
     * 加害者職業を返します。
     *
     * @return 加害者職業
     */
    public RString get加害者職業() {
        return entity.getKagaisha_Shokugyo();
    }

    /**
     * 使用者郵便番号を返します。
     *
     * @return 使用者郵便番号
     */
    public YubinNo get使用者郵便番号() {
        return entity.getShiyosha_YubinNo();
    }

    /**
     * 使用者住所を返します。
     *
     * @return 使用者住所
     */
    public RString get使用者住所() {
        return entity.getShiyosha_Jusho();
    }

    /**
     * 使用者氏名カナを返します。
     *
     * @return 使用者氏名カナ
     */
    public AtenaKanaMeisho get使用者氏名カナ() {
        return entity.getShiyosha_ShimeiKana();
    }

    /**
     * 使用者氏名を返します。
     *
     * @return 使用者氏名
     */
    public AtenaMeisho get使用者氏名() {
        return entity.getShiyosha_Shimei();
    }

    /**
     * 使用者生年月日を返します。
     *
     * @return 使用者生年月日
     */
    public FlexibleDate get使用者生年月日() {
        return entity.getShiyosha_UmareYMD();
    }

    /**
     * 使用者電話番号を返します。
     *
     * @return 使用者電話番号
     */
    public TelNo get使用者電話番号() {
        return entity.getShiyosha_TelNo();
    }

    /**
     * 使用者職業を返します。
     *
     * @return 使用者職業
     */
    public RString get使用者職業() {
        return entity.getShiyosha_Shokugyo();
    }

    /**
     * 負傷年月日を返します。
     *
     * @return 負傷年月日
     */
    public FlexibleDate get負傷年月日() {
        return entity.getFushoYMD();
    }

    /**
     * 負傷時間を返します。
     *
     * @return 負傷時間
     */
    public RString get負傷時間() {
        return entity.getFushoTime();
    }

    /**
     * 負傷時の場所を返します。
     *
     * @return 負傷時の場所
     */
    public RString get負傷時の場所() {
        return entity.getFushoJi_Basho();
    }

    /**
     * 発病原因・負傷時状況を返します。
     *
     * @return 発病原因・負傷時状況
     */
    public RString get発病原因_負傷時状況() {
        return entity.getHasshoGeiin_FushoJiJokyo();
    }

    /**
     * 自賠責保険契約会社名を返します。
     *
     * @return 自賠責保険契約会社名
     */
    public AtenaMeisho get自賠責保険契約会社名() {
        return entity.getJibaisekiHoken_KeiyakuKaishaMei();
    }

    /**
     * 自賠責保険証明書番号を返します。
     *
     * @return 自賠責保険証明書番号
     */
    public RString get自賠責保険証明書番号() {
        return entity.getJibaisekiHoken_ShomeishoNo();
    }

    /**
     * 自賠責保険契約者住所を返します。
     *
     * @return 自賠責保険契約者住所
     */
    public RString get自賠責保険契約者住所() {
        return entity.getJibaisekiHoken_KeiyakushaJusho();
    }

    /**
     * 所有者住所を返します。
     *
     * @return 所有者住所
     */
    public RString get所有者住所() {
        return entity.getShoyushaJusho();
    }

    /**
     * 所有者氏名を返します。
     *
     * @return 所有者氏名
     */
    public AtenaMeisho get所有者氏名() {
        return entity.getShoyushaShimei();
    }

    /**
     * 登録番号を返します。
     *
     * @return 登録番号
     */
    public RString get登録番号() {
        return entity.getTorokuNo();
    }

    /**
     * 車台番号を返します。
     *
     * @return 車台番号
     */
    public RString get車台番号() {
        return entity.getShadaiNo();
    }

    /**
     * 任意保険対人保障有無を返します。
     *
     * @return 任意保険対人保障有無
     */
    public RString get任意保険対人保障有無() {
        return entity.getNiniHoken_TaijinHoshoUmu();
    }

    /**
     * 任意保険対人保障保険契約会社名を返します。
     *
     * @return 任意保険対人保障保険契約会社名
     */
    public AtenaMeisho get任意保険対人保障保険契約会社名() {
        return entity.getNiniHoken_TaijinHoshoKaishaMei();
    }

    /**
     * 任意保険対人保障保険契約会社連絡先を返します。
     *
     * @return 任意保険対人保障保険契約会社連絡先
     */
    public TelNo get任意保険対人保障保険契約会社連絡先() {
        return entity.getNiniHoken_TaijinHoshoKaishaTelNo();
    }

    /**
     * 任意保険対人保障保険契約会社担当者を返します。
     *
     * @return 任意保険対人保障保険契約会社担当者
     */
    public AtenaMeisho get任意保険対人保障保険契約会社担当者() {
        return entity.getNiniHoken_TaijinHoshoKaishaTantosha();
    }

    /**
     * 示談成立有無を返します。
     *
     * @return 示談成立有無
     */
    public RString get示談成立有無() {
        return entity.getJidan_SeiritsuUmu();
    }

    /**
     * 示談成立年月日を返します。
     *
     * @return 示談成立年月日
     */
    public FlexibleDate get示談成立年月日() {
        return entity.getJidan_SeiritsuYMD();
    }

    /**
     * 損害賠償交渉経過を返します。
     *
     * @return 損害賠償交渉経過
     */
    public RString get損害賠償交渉経過() {
        return entity.getSongaiBaishoKoshoKeika();
    }

    /**
     * 事故発生状況報告書有無を返します。
     *
     * @return 事故発生状況報告書有無
     */
    public RString get事故発生状況報告書有無() {
        return entity.getJikoHasseiJokyoHokokushoUmu();
    }

    /**
     * 念書兼同意書有無を返します。
     *
     * @return 念書兼同意書有無
     */
    public RString get念書兼同意書有無() {
        return entity.getNensho_DoishoUmu();
    }

    /**
     * 誓約書有無を返します。
     *
     * @return 誓約書有無
     */
    public RString get誓約書有無() {
        return entity.getSeiyakushoUmu();
    }

    /**
     * 交通事故証明書有無を返します。
     *
     * @return 交通事故証明書有無
     */
    public RString get交通事故証明書有無() {
        return entity.getKotsuJikoShomeishoUmu();
    }

    /**
     * 人身事故証明書入手不能理由書有無を返します。
     *
     * @return 人身事故証明書入手不能理由書有無
     */
    public RString get人身事故証明書入手不能理由書有無() {
        return entity.getJinshinJikoShomeisho_NyushuFunoRiyushoUmu();
    }

    /**
     * 示談書写し有無を返します。
     *
     * @return 示談書写し有無
     */
    public RString get示談書写し有無() {
        return entity.getJidanshoUtsushiUmu();
    }

    /**
     * {@link DbT3084DaisanshaKoiTodokedeEntity}のクローンを返します。
     *
     * @return {@link DbT3084DaisanshaKoiTodokedeEntity}のクローン
     */
    @Override
    public DbT3084DaisanshaKoiTodokedeEntity toEntity() {
        return this.entity.clone();
    }

    /**
     * 介護第三者行為届出の識別子{@link DaisanshaKoiTodokedeIdentifier}を返します。
     *
     * @return 介護第三者行為届出の識別子{@link DaisanshaKoiTodokedeIdentifier}
     */
    @Override
    public DaisanshaKoiTodokedeIdentifier identifier() {
        return this.id;
    }

    /**
     * 保持する介護第三者行為届出を削除対象とします。<br/>
     * {@link DbT3084DaisanshaKoiTodokedeEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば削除状態にします。
     *
     * @return 削除対象処理実施後の{@link DaisanshaKoiTodokede}
     */
    @Override
    public DaisanshaKoiTodokede deleted() {
        DbT3084DaisanshaKoiTodokedeEntity deletedEntity = this.toEntity();
        if (deletedEntity.getState() != EntityDataState.Added) {
            deletedEntity.setState(EntityDataState.Deleted);
        } else {
            //TODO メッセージの検討
            throw new IllegalStateException(UrErrorMessages.不正.toString());
        }
        return new DaisanshaKoiTodokede(deletedEntity, id);
    }

    /**
     * {@link DaisanshaKoiTodokede}のシリアライズ形式を提供します。
     *
     * @return {@link DaisanshaKoiTodokede}のシリアライズ形式
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

        private final DbT3084DaisanshaKoiTodokedeEntity entity;
        private final DaisanshaKoiTodokedeIdentifier id;

        private _SerializationProxy(DbT3084DaisanshaKoiTodokedeEntity entity, DaisanshaKoiTodokedeIdentifier id) {
            this.entity = entity;
            this.id = id;
        }

        private Object readResolve() {
            return new DaisanshaKoiTodokede(this.entity, this.id);
        }
    }

    /**
     * このクラスの編集を行うBuilderを取得します。<br/>
     * 編集後のインスタンスを取得する場合は{@link SeishinTechoNini.createBuilderForEdit#build()}を使用してください。
     *
     * @return Builder
     */
    public DaisanshaKoiTodokedeBuilder createBuilderForEdit() {
        return new DaisanshaKoiTodokedeBuilder(entity, id);
    }

//TODO これはあくまでも雛形によるクラス生成です、必要な業務ロジックの追加、ValueObjectの導出を行う必要があります。
}
