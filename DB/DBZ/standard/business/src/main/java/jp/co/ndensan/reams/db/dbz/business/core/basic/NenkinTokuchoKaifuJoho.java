/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import java.io.Serializable;
import java.util.Objects;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.business.core.uzclasses.ParentModelBase;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.UeT0511NenkinTokuchoKaifuJohoEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.SetaiCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 年金特徴回付情報（介護継承）を管理するクラスです。
 *
 * @reamsid_L DBZ-9999-012 yangchenbing
 */
public class NenkinTokuchoKaifuJoho extends ParentModelBase<NenkinTokuchoKaifuJohoIdentifier, UeT0511NenkinTokuchoKaifuJohoEntity,
        NenkinTokuchoKaifuJoho> implements Serializable {

//TODO NetBeansの機能を使って必ずequalsとhashCodeを追加してください。
    private final UeT0511NenkinTokuchoKaifuJohoEntity entity;
    private final NenkinTokuchoKaifuJohoIdentifier id;

    /**
     * コンストラクタです。<br/>
     * 年金特徴回付情報（介護継承）の新規作成時に使用します。
     *
     * @param 業務コード GyomuCode
     * @param 処理年度 FlexibleYear
     * @param 通知内容コード RString
     * @param 処理対象年月 FlexibleYearMonth
     * @param 基礎年金番号 RString
     * @param 年金コード RString
     * @param 構成市町村コード RString
     * @param 連番 int
     */
    public NenkinTokuchoKaifuJoho(GyomuCode 業務コード,
            FlexibleYear 処理年度,
            RString 通知内容コード,
            FlexibleYearMonth 処理対象年月,
            RString 基礎年金番号,
            RString 年金コード,
            RString 構成市町村コード,
            int 連番) {
        requireNonNull(業務コード, jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages.値がnull.getReplacedMessage("業務コード"));
        requireNonNull(処理年度, jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages.値がnull.getReplacedMessage("処理年度"));
        requireNonNull(通知内容コード, jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages.値がnull.getReplacedMessage("通知内容コード"));
        requireNonNull(処理対象年月, jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages.値がnull.getReplacedMessage("処理対象年月"));
        requireNonNull(基礎年金番号, jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages.値がnull.getReplacedMessage("基礎年金番号"));
        requireNonNull(年金コード, jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages.値がnull.getReplacedMessage("年金コード"));
        requireNonNull(構成市町村コード, jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages.値がnull.getReplacedMessage("構成市町村コード"));
        this.entity = new UeT0511NenkinTokuchoKaifuJohoEntity();
        this.entity.setGyomuCode(業務コード);
        this.entity.setShoriNendo(処理年度);
        this.entity.setTsuchiNaiyoCode(通知内容コード);
        this.entity.setKisoNenkinNo(基礎年金番号);
        this.entity.setNenkinCode(年金コード);
        this.entity.setKoseiCityCode(構成市町村コード);
        this.entity.setRenban(連番);
        this.id = new NenkinTokuchoKaifuJohoIdentifier(業務コード, 処理年度, 通知内容コード, 処理対象年月, 基礎年金番号, 年金コード,
                構成市町村コード, 連番);
    }

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link UeT0511NenkinTokuchoKaifuJohoEntity}より{@link NenkinTokuchoKaifuJoho}を生成します。
     *
     * @param entity DBより取得した{@link UeT0511NenkinTokuchoKaifuJohoEntity}
     */
    public NenkinTokuchoKaifuJoho(UeT0511NenkinTokuchoKaifuJohoEntity entity) {
        this.entity = requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("年金特徴回付情報（介護継承）"));
        this.id = new NenkinTokuchoKaifuJohoIdentifier(
                entity.getGyomuCode(),
                entity.getShoriNendo(),
                entity.getTsuchiNaiyoCode(),
                entity.getShoriTaishoYM(),
                entity.getKisoNenkinNo(),
                entity.getNenkinCode(),
                entity.getKoseiCityCode(),
                entity.getRenban());
    }

    /**
     * シリアライズ、ビルダー用コンストラクタです。
     *
     * @param entity {@link UeT0511NenkinTokuchoKaifuJohoEntity}
     * @param id {@link NenkinTokuchoKaifuJohoIdentifier}
     */
    NenkinTokuchoKaifuJoho(
            UeT0511NenkinTokuchoKaifuJohoEntity entity,
            NenkinTokuchoKaifuJohoIdentifier id
    ) {
        this.entity = entity;
        this.id = id;
    }

//TODO getterを見直してください。意味のある単位でValueObjectを作成して公開してください。
    /**
     * 業務コードを返します。
     *
     * @return 業務コード
     */
    public GyomuCode get業務コード() {
        return entity.getGyomuCode();
    }

    /**
     * 処理年度を返します。
     *
     * @return 処理年度
     */
    public FlexibleYear get処理年度() {
        return entity.getShoriNendo();
    }

    /**
     * 通知内容コードを返します。
     *
     * @return 通知内容コード
     */
    public RString get通知内容コード() {
        return entity.getTsuchiNaiyoCode();
    }

    /**
     * 処理対象年月を返します。
     *
     * @return 処理対象年月
     */
    public FlexibleYearMonth get処理対象年月() {
        return entity.getShoriTaishoYM();
    }

    /**
     * 基礎年金番号を返します。
     *
     * @return 基礎年金番号
     */
    public RString get基礎年金番号() {
        return entity.getKisoNenkinNo();
    }

    /**
     * 年金コードを返します。
     *
     * @return 年金コード
     */
    public RString get年金コード() {
        return entity.getNenkinCode();
    }

    /**
     * 構成市町村コードを返します。
     *
     * @return 構成市町村コード
     */
    public RString get構成市町村コード() {
        return entity.getKoseiCityCode();
    }

    /**
     * 連番を返します。
     *
     * @return 連番
     */
    public int get連番() {
        return entity.getRenban();
    }

    /**
     * 処理日時を返します。
     *
     * @return 処理日時
     */
    public RDateTime get処理日時() {
        return entity.getShoriTimestamp();
    }

    /**
     * 連携種別を返します。
     *
     * @return 連携種別
     */
    public RString get連携種別() {
        return entity.getRenkeiShubetsu();
    }

    /**
     * 捕捉月を返します。
     *
     * @return 捕捉月
     */
    public RString get捕捉月() {
        return entity.getHosokuTsuki();
    }

    /**
     * 天引月を返します。
     *
     * @return 天引月
     */
    public RString get天引月() {
        return entity.getTenbikiTsuki();
    }

    /**
     * DT市町村コードを返します。
     *
     * @return DT市町村コード
     */
    public RString getDT市町村コード() {
        return entity.getDtCityCode();
    }

    /**
     * DT特別徴収義務者コードを返します。
     *
     * @return DT特別徴収義務者コード
     */
    public Code getDT特別徴収義務者コード() {
        return entity.getDtTokubetsuChoshuGimushaCode();
    }

    /**
     * DT通知内容コードを返します。
     *
     * @return DT通知内容コード
     */
    public RString getDT通知内容コード() {
        return entity.getDtTsuchiNaiyoCode();
    }

    /**
     * DT媒体コードを返します。
     *
     * @return DT媒体コード
     */
    public RString getDT媒体コード() {
        return entity.getDtBaitaiCode();
    }

    /**
     * DT特別徴収制度コードを返します。
     *
     * @return DT特別徴収制度コード
     */
    public RString getDT特別徴収制度コード() {
        return entity.getDtTokubetsuChoshuSeidoCode();
    }

    /**
     * DT作成年月日を返します。
     *
     * @return DT作成年月日
     */
    public RString getDT作成年月日() {
        return entity.getDtSakuseiYMD();
    }

    /**
     * DT基礎年金番号を返します。
     *
     * @return DT基礎年金番号
     */
    public RString getDT基礎年金番号() {
        return entity.getDtKisoNenkinNo();
    }

    /**
     * DT年金コードを返します。
     *
     * @return DT年金コード
     */
    public RString getDT年金コード() {
        return entity.getDtNenkinCode();
    }

    /**
     * DT予備１を返します。
     *
     * @return DT予備１
     */
    public RString getDT予備１() {
        return entity.getDtYobi1();
    }

    /**
     * DT生年月日を返します。
     *
     * @return DT生年月日
     */
    public RString getDT生年月日() {
        return entity.getDtBirthDay();
    }

    /**
     * DT性別を返します。
     *
     * @return DT性別
     */
    public RString getDT性別() {
        return entity.getDtSeibetsu();
    }

    /**
     * DTカナ氏名を返します。
     *
     * @return DTカナ氏名
     */
    public RString getDTカナ氏名() {
        return entity.getDtKanaShimei();
    }

    /**
     * DTシフトコード１を返します。
     *
     * @return DTシフトコード１
     */
    public RString getDTシフトコード１() {
        return entity.getDtShiftCode1();
    }

    /**
     * DT漢字氏名を返します。
     *
     * @return DT漢字氏名
     */
    public RString getDT漢字氏名() {
        return entity.getDtKanjiShimei();
    }

    /**
     * DTシフトコード２を返します。
     *
     * @return DTシフトコード２
     */
    public RString getDTシフトコード２() {
        return entity.getDtShiftCode2();
    }

    /**
     * DT郵便番号を返します。
     *
     * @return DT郵便番号
     */
    public RString getDT郵便番号() {
        return entity.getDtYubinNo();
    }

    /**
     * DTカナ住所を返します。
     *
     * @return DTカナ住所
     */
    public RString getDTカナ住所() {
        return entity.getDtKanaJusho();
    }

    /**
     * DTシフトコード３を返します。
     *
     * @return DTシフトコード３
     */
    public RString getDTシフトコード３() {
        return entity.getDtShiftCode3();
    }

    /**
     * DT漢字住所を返します。
     *
     * @return DT漢字住所
     */
    public RString getDT漢字住所() {
        return entity.getDtKanjiJusho();
    }

    /**
     * DTシフトコード４を返します。
     *
     * @return DTシフトコード４
     */
    public RString getDTシフトコード４() {
        return entity.getDtShiftCode4();
    }

    /**
     * DT各種区分を返します。
     *
     * @return DT各種区分
     */
    public RString getDT各種区分() {
        return entity.getDtKakushuKubun();
    }

    /**
     * DT処理結果を返します。
     *
     * @return DT処理結果
     */
    public RString getDT処理結果() {
        return entity.getDtShoriKekka();
    }

    /**
     * DT後期移管コードを返します。
     *
     * @return DT後期移管コード
     */
    public RString getDT後期移管コード() {
        return entity.getDtKokiIkanCode();
    }

    /**
     * DT各種年月日を返します。
     *
     * @return DT各種年月日
     */
    public RString getDT各種年月日() {
        return entity.getDtKakushuYMD();
    }

    /**
     * DT各種金額欄１を返します。
     *
     * @return DT各種金額欄１
     */
    public RString getDT各種金額欄１() {
        return entity.getDtKakushuKingaku1();
    }

    /**
     * DT各種金額欄２を返します。
     *
     * @return DT各種金額欄２
     */
    public RString getDT各種金額欄２() {
        return entity.getDtKakushuKingaku2();
    }

    /**
     * DT各種金額欄３を返します。
     *
     * @return DT各種金額欄３
     */
    public RString getDT各種金額欄３() {
        return entity.getDtKakushuKingaku3();
    }

    /**
     * DT予備２を返します。
     *
     * @return DT予備２
     */
    public RString getDT予備２() {
        return entity.getDtYobi2();
    }

    /**
     * DT共済年金証書記号番号を返します。
     *
     * @return DT共済年金証書記号番号
     */
    public RString getDT共済年金証書記号番号() {
        return entity.getDtKyosaiNenkinshoshoKigoNo();
    }

    /**
     * 識別コードを返します。
     *
     * @return 識別コード
     */
    public ShikibetsuCode get識別コード() {
        return entity.getShikibetsuCode();
    }

    /**
     * 被保険者番号を返します。
     *
     * @return 被保険者番号
     */
    public RString get被保険者番号() {
        return entity.getHihokenshaNo();
    }

    /**
     * 国保世帯コードを返します。
     *
     * @return 国保世帯コード
     */
    public SetaiCode get国保世帯コード() {
        return entity.getKokuhoSetaiCode();
    }

    /**
     * DT各種金額欄４を返します。
     *
     * @return DT各種金額欄４
     */
    public RString getDT各種金額欄４() {
        return entity.getDtKakushuKingaku4();
    }

    /**
     * DT各種金額欄５を返します。
     *
     * @return DT各種金額欄５
     */
    public RString getDT各種金額欄５() {
        return entity.getDtKakushuKingaku5();
    }

    /**
     * DT各種金額欄６を返します。
     *
     * @return DT各種金額欄６
     */
    public RString getDT各種金額欄６() {
        return entity.getDtKakushuKingaku6();
    }

    /**
     * DT各種金額欄７を返します。
     *
     * @return DT各種金額欄７
     */
    public RString getDT各種金額欄７() {
        return entity.getDtKakushuKingaku7();
    }

    /**
     * DT各種金額欄８を返します。
     *
     * @return DT各種金額欄８
     */
    public RString getDT各種金額欄８() {
        return entity.getDtKakushuKingaku8();
    }

    /**
     * DT停止年月を返します。
     *
     * @return DT停止年月
     */
    public RString getDT停止年月() {
        return entity.getDtTeishiYM();
    }

    /**
     * DT予備４住民税を返します。
     *
     * @return DT予備４住民税
     */
    public RString getDT予備４住民税() {
        return entity.getDtYobi4Juminzei();
    }

    /**
     * DT個人番号を返します。
     *
     * @return DT個人番号
     */
    public RString getDT個人番号() {
        return entity.getDtKojinNo();
    }

    /**
     * 国保予定喪失区分を返します。
     *
     * @return 国保予定喪失区分
     */
    public RString get国保予定喪失区分() {
        return entity.getKokuhoYoteiSoshitsuKubun();
    }

    /**
     * {@link UeT0511NenkinTokuchoKaifuJohoEntity}のクローンを返します。
     *
     * @return {@link UeT0511NenkinTokuchoKaifuJohoEntity}のクローン
     */
    @Override
    public UeT0511NenkinTokuchoKaifuJohoEntity toEntity() {
        return this.entity.clone();
    }

    /**
     * 年金特徴回付情報（介護継承）の識別子{@link NenkinTokuchoKaifuJohoIdentifier}を返します。
     *
     * @return 年金特徴回付情報（介護継承）の識別子{@link NenkinTokuchoKaifuJohoIdentifier}
     */
    @Override
    public NenkinTokuchoKaifuJohoIdentifier identifier() {
        return this.id;
    }

    /**
     * 年金特徴回付情報（介護継承）のみを変更対象とします。<br/>
     * {@link UeT0511NenkinTokuchoKaifuJohoEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば変更状態にします。
     *
     * @return 変更対象処理実施後の{@link NenkinTokuchoKaifuJoho}
     */
    @Override
    public NenkinTokuchoKaifuJoho modifiedModel() {
        UeT0511NenkinTokuchoKaifuJohoEntity modifiedEntity = entity.clone();
        if (modifiedEntity.getState().equals(EntityDataState.Unchanged)) {
            modifiedEntity.setState(EntityDataState.Modified);
        }
        return new NenkinTokuchoKaifuJoho(
                modifiedEntity, id);
    }

    /**
     * 保持する年金特徴回付情報（介護継承）を削除対象とします。<br/>
     * {@link UeT0511NenkinTokuchoKaifuJohoEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば削除状態にします。
     *
     * @return 削除対象処理実施後の{@link NenkinTokuchoKaifuJoho}
     */
    @Override
    public NenkinTokuchoKaifuJoho deleted() {
        UeT0511NenkinTokuchoKaifuJohoEntity deletedEntity = this.toEntity();
        if (deletedEntity.getState() != EntityDataState.Added) {
            deletedEntity.setState(EntityDataState.Deleted);
        } else {
            //TODO メッセージの検討
            throw new IllegalStateException(UrErrorMessages.不正.toString());
        }
        return new NenkinTokuchoKaifuJoho(deletedEntity, id);
    }

    /**
     * {@link NenkinTokuchoKaifuJoho}のシリアライズ形式を提供します。
     *
     * @return {@link NenkinTokuchoKaifuJoho}のシリアライズ形式
     */
    protected Object writeReplace() {
        return new _SerializationProxy(entity, id);

    }

    @Override
    public boolean hasChanged() {
        return hasChangedEntity(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int hashCode() {
        int hash = 11;
        hash = 47 * hash + Objects.hashCode(this.entity);
        hash = 47 * hash + Objects.hashCode(this.id);
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
        final NenkinTokuchoKaifuJoho other = (NenkinTokuchoKaifuJoho) obj;
        if (!Objects.equals(this.entity, other.entity)) {
            return false;
        }
        return Objects.equals(this.id, other.id);
    }

    private static final class _SerializationProxy implements Serializable {

        private static final long serialVersionUID = 4127676261599029868L; // TODO serialVersionUIDを生成してください
        private final UeT0511NenkinTokuchoKaifuJohoEntity entity;
        private final NenkinTokuchoKaifuJohoIdentifier id;

        private _SerializationProxy(UeT0511NenkinTokuchoKaifuJohoEntity entity, NenkinTokuchoKaifuJohoIdentifier id) {
            this.entity = entity;
            this.id = id;
        }

        private Object readResolve() {
            return new NenkinTokuchoKaifuJoho(this.entity, this.id);
        }
    }

    /**
     * このクラスの編集を行うBuilderを取得します。<br/>
     * 編集後のインスタンスを取得する場合は{@link SeishinTechoNini.createBuilderForEdit#build()}を使用してください。
     *
     * @return Builder
     */
    public NenkinTokuchoKaifuJohoBuilder createBuilderForEdit() {
        return new NenkinTokuchoKaifuJohoBuilder(entity, id);
    }

//TODO これはあくまでも雛形によるクラス生成です、必要な業務ロジックの追加、ValueObjectの導出を行う必要があります。
    private static final long serialVersionUID = -333908934955031386L;
}
