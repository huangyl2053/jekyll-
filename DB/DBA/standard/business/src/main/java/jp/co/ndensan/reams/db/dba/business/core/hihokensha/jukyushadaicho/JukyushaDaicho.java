/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.core.hihokensha.jukyushadaicho;

import java.io.Serializable;
import java.util.Objects;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4001JukyushaDaichoEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.ModelBase;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 受給者台帳を管理するクラスです。
 */
public class JukyushaDaicho extends ModelBase<JukyushaDaichoIdentifier, DbT4001JukyushaDaichoEntity, JukyushaDaicho> implements Serializable {

    private final DbT4001JukyushaDaichoEntity entity;
    private final JukyushaDaichoIdentifier id;

    /**
     * コンストラクタです。<br/>
     * 受給者台帳の新規作成時に使用します。
     *
     * @param 市町村コード 市町村コード
     * @param 被保険者番号 被保険者番号
     * @param 履歴番号 履歴番号
     * @param 枝番 枝番
     * @param 受給申請事由 受給申請事由
     */
    public JukyushaDaicho(LasdecCode 市町村コード,
            HihokenshaNo 被保険者番号,
            RString 履歴番号,
            RString 枝番,
            Code 受給申請事由) {
        requireNonNull(市町村コード, UrSystemErrorMessages.値がnull.getReplacedMessage("市町村コード"));
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));
        requireNonNull(枝番, UrSystemErrorMessages.値がnull.getReplacedMessage("枝番"));
        requireNonNull(受給申請事由, UrSystemErrorMessages.値がnull.getReplacedMessage("受給申請事由"));
        this.entity = new DbT4001JukyushaDaichoEntity();
        this.entity.setShichosonCode(市町村コード);
        this.entity.setHihokenshaNo(被保険者番号);
        this.entity.setRirekiNo(履歴番号);
        this.entity.setEdaban(枝番);
        this.entity.setJukyuShinseiJiyu(受給申請事由);
        this.id = new JukyushaDaichoIdentifier(
                市町村コード,
                被保険者番号,
                履歴番号,
                枝番,
                受給申請事由
        );
    }

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link DbT4001JukyushaDaichoEntity}より{@link JukyushaDaicho}を生成します。
     *
     * @param entity DBより取得した{@link DbT4001JukyushaDaichoEntity}
     */
    public JukyushaDaicho(DbT4001JukyushaDaichoEntity entity) {
        this.entity = requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("受給者台帳"));
        this.id = new JukyushaDaichoIdentifier(
                entity.getShichosonCode(),
                entity.getHihokenshaNo(),
                entity.getRirekiNo(),
                entity.getEdaban(),
                entity.getJukyuShinseiJiyu());
    }

    /**
     * シリアライズ、ビルダー用コンストラクタです。
     *
     * @param entity {@link DbT4001JukyushaDaichoEntity}
     * @param id {@link JukyushaDaichoIdentifier}
     */
    JukyushaDaicho(
            DbT4001JukyushaDaichoEntity entity,
            JukyushaDaichoIdentifier id
    ) {
        this.entity = entity;
        this.id = id;
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
    public RString get履歴番号() {
        return entity.getRirekiNo();
    }

    /**
     * 枝番を返します。
     *
     * @return 枝番
     */
    public RString get枝番() {
        return entity.getEdaban();
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
     * 申請状況区分を返します。
     *
     * @return 申請状況区分
     */
    public RString get申請状況区分() {
        return entity.getShinseiJokyoKubun();
    }

    /**
     * 支所コードを返します。
     *
     * @return 支所コード
     */
    public RString get支所コード() {
        return entity.getShishoCode();
    }

    /**
     * 直近フラグを返します。
     *
     * @return 直近フラグ
     */
    public boolean get直近フラグ() {
        return entity.getChokkinFlag();
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
     * 受給申請事由を返します。
     *
     * @return 受給申請事由
     */
    public Code get受給申請事由() {
        return entity.getJukyuShinseiJiyu();
    }

    /**
     * 申請理由を返します。
     *
     * @return 申請理由
     */
    public RString get申請理由() {
        return entity.getShinseiRiyu();
    }

    /**
     * （届出者）申請者関係コードを返します。
     *
     * @return （届出者）申請者関係コード
     */
    public Code get届出者_申請者関係コード() {
        return entity.getShinseishaKankeiCode();
    }

    /**
     * （届出者）本人との関係を返します。
     *
     * @return （届出者）本人との関係
     */
    public RString get届出者_本人との関係() {
        return entity.getHomninKankei();
    }

    /**
     * 受給申請年月日を返します。
     *
     * @return 受給申請年月日
     */
    public FlexibleDate get受給申請年月日() {
        return entity.getJukyuShinseiYMD();
    }

    /**
     * ２号特定疾病コードを返します。
     *
     * @return ２号特定疾病コード
     */
    public Code get２号特定疾病コード() {
        return entity.getNigoTokuteiShippeiCode();
    }

    /**
     * 審査会依頼年月日を返します。
     *
     * @return 審査会依頼年月日
     */
    public FlexibleDate get審査会依頼年月日() {
        return entity.getShinsakaiIraiYMD();
    }

    /**
     * 要介護認定状態区分コードを返します。
     *
     * @return 要介護認定状態区分コード
     */
    public Code get要介護認定状態区分コード() {
        return entity.getYokaigoJotaiKubunCode();
    }

    /**
     * 認定有効期間開始年月日を返します。
     *
     * @return 認定有効期間開始年月日
     */
    public FlexibleDate get認定有効期間開始年月日() {
        return entity.getNinteiYukoKikanKaishiYMD();
    }

    /**
     * 認定有効期間終了年月日を返します。
     *
     * @return 認定有効期間終了年月日
     */
    public FlexibleDate get認定有効期間終了年月日() {
        return entity.getNinteiYukoKikanShuryoYMD();
    }

    /**
     * 認定年月日を返します。
     *
     * @return 認定年月日
     */
    public FlexibleDate get認定年月日() {
        return entity.getNinteiYMD();
    }

    /**
     * みなし要介護区分コードを返します。
     *
     * @return みなし要介護区分コード
     */
    public Code getみなし要介護区分コード() {
        return entity.getMinashiCode();
    }

    /**
     * 指定サービス種類01を返します。
     *
     * @return 指定サービス種類01
     */
    public ServiceShuruiCode get指定サービス種類01() {
        return entity.getShiteiServiceShurui01();
    }

    /**
     * 指定サービス種類02を返します。
     *
     * @return 指定サービス種類02
     */
    public ServiceShuruiCode get指定サービス種類02() {
        return entity.getShiteiServiceShurui02();
    }

    /**
     * 指定サービス種類03を返します。
     *
     * @return 指定サービス種類03
     */
    public ServiceShuruiCode get指定サービス種類03() {
        return entity.getShiteiServiceShurui03();
    }

    /**
     * 指定サービス種類04を返します。
     *
     * @return 指定サービス種類04
     */
    public ServiceShuruiCode get指定サービス種類04() {
        return entity.getShiteiServiceShurui04();
    }

    /**
     * 指定サービス種類05を返します。
     *
     * @return 指定サービス種類05
     */
    public ServiceShuruiCode get指定サービス種類05() {
        return entity.getShiteiServiceShurui05();
    }

    /**
     * 指定サービス種類06を返します。
     *
     * @return 指定サービス種類06
     */
    public ServiceShuruiCode get指定サービス種類06() {
        return entity.getShiteiServiceShurui06();
    }

    /**
     * 指定サービス種類07を返します。
     *
     * @return 指定サービス種類07
     */
    public ServiceShuruiCode get指定サービス種類07() {
        return entity.getShiteiServiceShurui07();
    }

    /**
     * 指定サービス種類08を返します。
     *
     * @return 指定サービス種類08
     */
    public ServiceShuruiCode get指定サービス種類08() {
        return entity.getShiteiServiceShurui08();
    }

    /**
     * 指定サービス種類09を返します。
     *
     * @return 指定サービス種類09
     */
    public ServiceShuruiCode get指定サービス種類09() {
        return entity.getShiteiServiceShurui09();
    }

    /**
     * 指定サービス種類10を返します。
     *
     * @return 指定サービス種類10
     */
    public ServiceShuruiCode get指定サービス種類10() {
        return entity.getShiteiServiceShurui10();
    }

    /**
     * 指定サービス種類11を返します。
     *
     * @return 指定サービス種類11
     */
    public ServiceShuruiCode get指定サービス種類11() {
        return entity.getShiteiServiceShurui11();
    }

    /**
     * 指定サービス種類12を返します。
     *
     * @return 指定サービス種類12
     */
    public ServiceShuruiCode get指定サービス種類12() {
        return entity.getShiteiServiceShurui12();
    }

    /**
     * 指定サービス種類13を返します。
     *
     * @return 指定サービス種類13
     */
    public ServiceShuruiCode get指定サービス種類13() {
        return entity.getShiteiServiceShurui13();
    }

    /**
     * 指定サービス種類14を返します。
     *
     * @return 指定サービス種類14
     */
    public ServiceShuruiCode get指定サービス種類14() {
        return entity.getShiteiServiceShurui14();
    }

    /**
     * 指定サービス種類15を返します。
     *
     * @return 指定サービス種類15
     */
    public ServiceShuruiCode get指定サービス種類15() {
        return entity.getShiteiServiceShurui15();
    }

    /**
     * 指定サービス種類16を返します。
     *
     * @return 指定サービス種類16
     */
    public ServiceShuruiCode get指定サービス種類16() {
        return entity.getShiteiServiceShurui16();
    }

    /**
     * 指定サービス種類17を返します。
     *
     * @return 指定サービス種類17
     */
    public ServiceShuruiCode get指定サービス種類17() {
        return entity.getShiteiServiceShurui17();
    }

    /**
     * 指定サービス種類18を返します。
     *
     * @return 指定サービス種類18
     */
    public ServiceShuruiCode get指定サービス種類18() {
        return entity.getShiteiServiceShurui18();
    }

    /**
     * 指定サービス種類19を返します。
     *
     * @return 指定サービス種類19
     */
    public ServiceShuruiCode get指定サービス種類19() {
        return entity.getShiteiServiceShurui19();
    }

    /**
     * 指定サービス種類20を返します。
     *
     * @return 指定サービス種類20
     */
    public ServiceShuruiCode get指定サービス種類20() {
        return entity.getShiteiServiceShurui20();
    }

    /**
     * 指定サービス種類21を返します。
     *
     * @return 指定サービス種類21
     */
    public ServiceShuruiCode get指定サービス種類21() {
        return entity.getShiteiServiceShurui21();
    }

    /**
     * 指定サービス種類22を返します。
     *
     * @return 指定サービス種類22
     */
    public ServiceShuruiCode get指定サービス種類22() {
        return entity.getShiteiServiceShurui22();
    }

    /**
     * 指定サービス種類23を返します。
     *
     * @return 指定サービス種類23
     */
    public ServiceShuruiCode get指定サービス種類23() {
        return entity.getShiteiServiceShurui23();
    }

    /**
     * 指定サービス種類24を返します。
     *
     * @return 指定サービス種類24
     */
    public ServiceShuruiCode get指定サービス種類24() {
        return entity.getShiteiServiceShurui24();
    }

    /**
     * 指定サービス種類25を返します。
     *
     * @return 指定サービス種類25
     */
    public ServiceShuruiCode get指定サービス種類25() {
        return entity.getShiteiServiceShurui25();
    }

    /**
     * 指定サービス種類26を返します。
     *
     * @return 指定サービス種類26
     */
    public ServiceShuruiCode get指定サービス種類26() {
        return entity.getShiteiServiceShurui26();
    }

    /**
     * 指定サービス種類27を返します。
     *
     * @return 指定サービス種類27
     */
    public ServiceShuruiCode get指定サービス種類27() {
        return entity.getShiteiServiceShurui27();
    }

    /**
     * 指定サービス種類28を返します。
     *
     * @return 指定サービス種類28
     */
    public ServiceShuruiCode get指定サービス種類28() {
        return entity.getShiteiServiceShurui28();
    }

    /**
     * 指定サービス種類29を返します。
     *
     * @return 指定サービス種類29
     */
    public ServiceShuruiCode get指定サービス種類29() {
        return entity.getShiteiServiceShurui29();
    }

    /**
     * 指定サービス種類30を返します。
     *
     * @return 指定サービス種類30
     */
    public ServiceShuruiCode get指定サービス種類30() {
        return entity.getShiteiServiceShurui30();
    }

    /**
     * 喪失年月日を返します。
     *
     * @return 喪失年月日
     */
    public FlexibleDate get喪失年月日() {
        return entity.getSoshitsuYMD();
    }

    /**
     * 直近異動年月日を返します。
     *
     * @return 直近異動年月日
     */
    public FlexibleDate get直近異動年月日() {
        return entity.getChokkinIdoYMD();
    }

    /**
     * 直近異動事由コードを返します。
     *
     * @return 直近異動事由コード
     */
    public Code get直近異動事由コード() {
        return entity.getChokkinIdoJiyuCode();
    }

    /**
     * 有効無効区分を返します。
     *
     * @return 有効無効区分
     */
    public Code get有効無効区分() {
        return entity.getYukoMukoKubun();
    }

    /**
     * データ区分を返します。
     *
     * @return データ区分
     */
    public Code getデータ区分() {
        return entity.getDataKubun();
    }

    /**
     * 同一連番を返します。
     *
     * @return 同一連番
     */
    public RString get同一連番() {
        return entity.getRemban();
    }

    /**
     * 異動理由を返します。
     *
     * @return 異動理由
     */
    public RString get異動理由() {
        return entity.getIdoRiyu();
    }

    /**
     * 申請書区分を返します。
     *
     * @return 申請書区分
     */
    public Code get申請書区分() {
        return entity.getShinseishoKubun();
    }

    /**
     * 削除事由コードを返します。
     *
     * @return 削除事由コード
     */
    public Code get削除事由コード() {
        return entity.getSakujoJiyuCode();
    }

    /**
     * 要支援者認定申請区分を返します。
     *
     * @return 要支援者認定申請区分
     */
    public boolean get要支援者認定申請区分() {
        return entity.getYoshienshaNinteiShinseiFlag();
    }

    /**
     * 支給限度単位数を返します。
     *
     * @return 支給限度単位数
     */
    public Decimal get支給限度単位数() {
        return entity.getShikyuGendoTanisu();
    }

    /**
     * 支給限度有効開始年月日を返します。
     *
     * @return 支給限度有効開始年月日
     */
    public FlexibleDate get支給限度有効開始年月日() {
        return entity.getShikyuGendoKaishiYMD();
    }

    /**
     * 支給限度有効終了年月日を返します。
     *
     * @return 支給限度有効終了年月日
     */
    public FlexibleDate get支給限度有効終了年月日() {
        return entity.getShikyuGendoShuryoYMD();
    }

    /**
     * 短期入所支給限度日数を返します。
     *
     * @return 短期入所支給限度日数
     */
    public int get短期入所支給限度日数() {
        return entity.getTankiSikyuGendoNissu();
    }

    /**
     * 短期入所支給限度開始年月日を返します。
     *
     * @return 短期入所支給限度開始年月日
     */
    public FlexibleDate get短期入所支給限度開始年月日() {
        return entity.getTankiShikyuGendoKaishiYMD();
    }

    /**
     * 短期入所支給限度終了年月日を返します。
     *
     * @return 短期入所支給限度終了年月日
     */
    public FlexibleDate get短期入所支給限度終了年月日() {
        return entity.getTankiShikyuGendoShuryoYMD();
    }

    /**
     * 当初認定有効開始年月日を返します。
     *
     * @return 当初認定有効開始年月日
     */
    public FlexibleDate get当初認定有効開始年月日() {
        return entity.getToshoNinteiYukoKaishiYMD();
    }

    /**
     * 当初認定有効終了年月日を返します。
     *
     * @return 当初認定有効終了年月日
     */
    public FlexibleDate get当初認定有効終了年月日() {
        return entity.getToshoNinteiYukoShuryoYMD();
    }

    /**
     * 受給資格証明書発行年月日１を返します。
     *
     * @return 受給資格証明書発行年月日１
     */
    public FlexibleDate get受給資格証明書発行年月日１() {
        return entity.getJukyuShikakuShomeishoHakkoYMD1();
    }

    /**
     * 受給資格証明書発行年月日２を返します。
     *
     * @return 受給資格証明書発行年月日２
     */
    public FlexibleDate get受給資格証明書発行年月日２() {
        return entity.getJukyuShikakuShomeishoHakkoYMD2();
    }

    /**
     * 診断命令書発行年月日を返します。
     *
     * @return 診断命令書発行年月日
     */
    public FlexibleDate get診断命令書発行年月日() {
        return entity.getShindanMeireishoHakkoYMD();
    }

    /**
     * ２号申請受理通知書発行年月日を返します。
     *
     * @return ２号申請受理通知書発行年月日
     */
    public FlexibleDate get２号申請受理通知書発行年月日() {
        return entity.getNigoShinseiJuriTsuchishoHakkoYMD();
    }

    /**
     * 認定結果通知書発行年月日を返します。
     *
     * @return 認定結果通知書発行年月日
     */
    public FlexibleDate get認定結果通知書発行年月日() {
        return entity.getNinteiKekkaTsuchishoHakkoYMD();
    }

    /**
     * 区分変更通知書発行年月日を返します。
     *
     * @return 区分変更通知書発行年月日
     */
    public FlexibleDate get区分変更通知書発行年月日() {
        return entity.getKubunHenkoTsuchishoHakkoYMD();
    }

    /**
     * サービス変更通知書発行年月日を返します。
     *
     * @return サービス変更通知書発行年月日
     */
    public FlexibleDate getサービス変更通知書発行年月日() {
        return entity.getServiceHenkoTsuchishoHakkoYMD();
    }

    /**
     * 認定却下通知書発行年月日を返します。
     *
     * @return 認定却下通知書発行年月日
     */
    public FlexibleDate get認定却下通知書発行年月日() {
        return entity.getNinteiKyakkaTsuchishoHakkoYMD();
    }

    /**
     * 認定取消通知書発行年月日を返します。
     *
     * @return 認定取消通知書発行年月日
     */
    public FlexibleDate get認定取消通知書発行年月日() {
        return entity.getNinteiTorikeshiTsuchishoHakkoYMD();
    }

    /**
     * 資格取得前申請フラグを返します。
     *
     * @return 資格取得前申請フラグ
     */
    public boolean get資格取得前申請フラグ() {
        return entity.getShikakuShutokuMaeShinseiFlag();
    }

    /**
     * 旧措置者フラグを返します。
     *
     * @return 旧措置者フラグ
     */
    public boolean get旧措置者フラグ() {
        return entity.getKyuSochishaFlag();
    }

    /**
     * 論理削除フラグを返します。
     *
     * @return 論理削除フラグ
     */
    public boolean get論理削除フラグ() {
        return entity.getLogicalDeletedFlag();
    }

    /**
     * {@link DbT4001JukyushaDaichoEntity}のクローンを返します。
     *
     * @return {@link DbT4001JukyushaDaichoEntity}のクローン
     */
    @Override
    public DbT4001JukyushaDaichoEntity toEntity() {
        return this.entity.clone();
    }

    /**
     * 受給者台帳の識別子{@link JukyushaDaichoIdentifier}を返します。
     *
     * @return 受給者台帳の識別子{@link JukyushaDaichoIdentifier}
     */
    @Override
    public JukyushaDaichoIdentifier identifier() {
        return this.id;
    }

    /**
     * 受給者台帳のみを変更対象とします。<br/>
     * {@link DbT4001JukyushaDaichoEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば変更状態にします。
     *
     * @return 変更対象処理実施後の{@link JukyushaDaicho}
     */
    public JukyushaDaicho modifiedModel() {
        DbT4001JukyushaDaichoEntity modifiedEntity = entity.clone();
        if (modifiedEntity.getState().equals(EntityDataState.Unchanged)) {
            modifiedEntity.setState(EntityDataState.Modified);
        }
        return new JukyushaDaicho(
                modifiedEntity, id);
    }

    /**
     * 保持する受給者台帳を削除対象とします。<br/>
     * {@link DbT4001JukyushaDaichoEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば削除状態にします。
     *
     * @return 削除対象処理実施後の{@link JukyushaDaicho}
     */
    @Override
    public JukyushaDaicho deleted() {
        DbT4001JukyushaDaichoEntity deletedEntity = this.toEntity();
        if (deletedEntity.getState() != EntityDataState.Added) {
            deletedEntity.setState(EntityDataState.Deleted);
        } else {
            //TODO メッセージの検討
            throw new IllegalStateException(UrErrorMessages.不正.toString());
        }
        return new JukyushaDaicho(deletedEntity, id);
    }

    /**
     * {@link JukyushaDaicho}のシリアライズ形式を提供します。
     *
     * @return {@link JukyushaDaicho}のシリアライズ形式
     */
    protected Object writeReplace() {
        return new _SerializationProxy(entity, id);

    }

    @Override
    public boolean hasChanged() {
        return hasChangedEntity();
    }

    private static final class _SerializationProxy implements Serializable {

        private static final long serialVersionUID = 2320811530302560809L;
        private final DbT4001JukyushaDaichoEntity entity;
        private final JukyushaDaichoIdentifier id;

        private _SerializationProxy(DbT4001JukyushaDaichoEntity entity, JukyushaDaichoIdentifier id) {
            this.entity = entity;
            this.id = id;
        }

        private Object readResolve() {
            return new JukyushaDaicho(this.entity, this.id);
        }
    }

    /**
     * このクラスの編集を行うBuilderを取得します。<br/>
     * 編集後のインスタンスを取得する場合は{@link SeishinTechoNini.createBuilderForEdit#build()}を使用してください。
     *
     * @return Builder
     */
    public JukyushaDaichoBuilder createBuilderForEdit() {
        return new JukyushaDaichoBuilder(entity, id);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.id);
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
        final JukyushaDaicho other = (JukyushaDaicho) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
}
