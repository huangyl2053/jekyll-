/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbd.entity.basic.DbT4001JukyushaDaichoEntity;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import java.util.Objects;

/**
 * 受給者台帳のビジネスクラスです。
 *
 * @author n8235 船山洋介
 */
public class JukyushaDaicho implements Serializable {

    private DbT4001JukyushaDaichoEntity entity;

    /**
     * コンストラクタです。
     */
    public JukyushaDaicho() {
        entity = new DbT4001JukyushaDaichoEntity();
    }

    /**
     * コンストラクタです。
     *
     * @param entity DbT4001JukyushaDaichoEntity
     */
    public JukyushaDaicho(DbT4001JukyushaDaichoEntity entity) {
        this.entity = entity;
    }

    /**
     * DbT4001JukyushaDaichoEntityを返します。
     *
     * @return DbT4001JukyushaDaichoEntity
     */
    public DbT4001JukyushaDaichoEntity getEntity() {
        return entity;
    }

    /**
     * DbT4001JukyushaDaichoEntityを設定します。
     *
     * @param entity DbT4001JukyushaDaichoEntity
     */
    public void setEntity(DbT4001JukyushaDaichoEntity entity) {
        this.entity = entity;
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
     * 届出者_申請者関係コードを返します。
     *
     * @return 届出者_申請者関係コード
     */
    public Code get届出者_申請者関係コード() {
        return entity.getShinseishaKankeiCode();
    }

    /**
     * 届出者_本人との関係を返します。
     *
     * @return 届出者_本人との関係
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
     * 二号特定疾病コードを返します。
     *
     * @return 二号特定疾病コード
     */
    public Code get二号特定疾病コード() {
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
     * 二号申請受理通知書発行年月日を返します。
     *
     * @return 二号申請受理通知書発行年月日
     */
    public FlexibleDate get二号申請受理通知書発行年月日() {
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
     * 市町村コードを設定します。
     *
     * @param 市町村コード 市町村コード
     */
    public void set市町村コード(LasdecCode 市町村コード) {
        requireNonNull(市町村コード, UrSystemErrorMessages.値がnull.getReplacedMessage("市町村コード"));
        entity.setShichosonCode(市町村コード);
    }

    /**
     * 被保険者番号を設定します。
     *
     * @param 被保険者番号 被保険者番号
     */
    public void set被保険者番号(HihokenshaNo 被保険者番号) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        entity.setHihokenshaNo(被保険者番号);
    }

    /**
     * 履歴番号を設定します。
     *
     * @param 履歴番号 履歴番号
     */
    public void set履歴番号(RString 履歴番号) {
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));
        entity.setRirekiNo(履歴番号);
    }

    /**
     * 枝番を設定します。
     *
     * @param 枝番 枝番
     */
    public void set枝番(RString 枝番) {
        requireNonNull(枝番, UrSystemErrorMessages.値がnull.getReplacedMessage("枝番"));
        entity.setEdaban(枝番);
    }

    /**
     * 申請書管理番号を設定します。
     *
     * @param 申請書管理番号 申請書管理番号
     */
    public void set申請書管理番号(ShinseishoKanriNo 申請書管理番号) {
        requireNonNull(申請書管理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("申請書管理番号"));
        entity.setShinseishoKanriNo(申請書管理番号);
    }

    /**
     * 申請状況区分を設定します。
     *
     * @param 申請状況区分 申請状況区分
     */
    public void set申請状況区分(RString 申請状況区分) {
        requireNonNull(申請状況区分, UrSystemErrorMessages.値がnull.getReplacedMessage("申請状況区分"));
        entity.setShinseiJokyoKubun(申請状況区分);
    }

    /**
     * 支所コードを設定します。
     *
     * @param 支所コード 支所コード
     */
    public void set支所コード(RString 支所コード) {
        requireNonNull(支所コード, UrSystemErrorMessages.値がnull.getReplacedMessage("支所コード"));
        entity.setShishoCode(支所コード);
    }

    /**
     * 直近フラグを設定します。
     *
     * @param 直近フラグ 直近フラグ
     */
    public void set直近フラグ(boolean 直近フラグ) {
        requireNonNull(直近フラグ, UrSystemErrorMessages.値がnull.getReplacedMessage("直近フラグ"));
        entity.setChokkinFlag(直近フラグ);
    }

    /**
     * 識別コードを設定します。
     *
     * @param 識別コード 識別コード
     */
    public void set識別コード(ShikibetsuCode 識別コード) {
        requireNonNull(識別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("識別コード"));
        entity.setShikibetsuCode(識別コード);
    }

    /**
     * 受給申請事由を設定します。
     *
     * @param 受給申請事由 受給申請事由
     */
    public void set受給申請事由(Code 受給申請事由) {
        requireNonNull(受給申請事由, UrSystemErrorMessages.値がnull.getReplacedMessage("受給申請事由"));
        entity.setJukyuShinseiJiyu(受給申請事由);
    }

    /**
     * 申請理由を設定します。
     *
     * @param 申請理由 申請理由
     */
    public void set申請理由(RString 申請理由) {
        requireNonNull(申請理由, UrSystemErrorMessages.値がnull.getReplacedMessage("申請理由"));
        entity.setShinseiRiyu(申請理由);
    }

    /**
     * 届出者_申請者関係コードを設定します。
     *
     * @param 届出者_申請者関係コード 届出者_申請者関係コード
     */
    public void set届出者_申請者関係コード(Code 届出者_申請者関係コード) {
        requireNonNull(届出者_申請者関係コード, UrSystemErrorMessages.値がnull.getReplacedMessage("届出者_申請者関係コード"));
        entity.setShinseishaKankeiCode(届出者_申請者関係コード);
    }

    /**
     * 届出者_本人との関係を設定します。
     *
     * @param 届出者_本人との関係 届出者_本人との関係
     */
    public void set届出者_本人との関係(RString 届出者_本人との関係) {
        requireNonNull(届出者_本人との関係, UrSystemErrorMessages.値がnull.getReplacedMessage("届出者_本人との関係"));
        entity.setHomninKankei(届出者_本人との関係);
    }

    /**
     * 受給申請年月日を設定します。
     *
     * @param 受給申請年月日 受給申請年月日
     */
    public void set受給申請年月日(FlexibleDate 受給申請年月日) {
        requireNonNull(受給申請年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("受給申請年月日"));
        entity.setJukyuShinseiYMD(受給申請年月日);
    }

    /**
     * 二号特定疾病コードを設定します。
     *
     * @param 二号特定疾病コード 二号特定疾病コード
     */
    public void set二号特定疾病コード(Code 二号特定疾病コード) {
        requireNonNull(二号特定疾病コード, UrSystemErrorMessages.値がnull.getReplacedMessage("二号特定疾病コード"));
        entity.setNigoTokuteiShippeiCode(二号特定疾病コード);
    }

    /**
     * 審査会依頼年月日を設定します。
     *
     * @param 審査会依頼年月日 審査会依頼年月日
     */
    public void set審査会依頼年月日(FlexibleDate 審査会依頼年月日) {
        requireNonNull(審査会依頼年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("審査会依頼年月日"));
        entity.setShinsakaiIraiYMD(審査会依頼年月日);
    }

    /**
     * 要介護認定状態区分コードを設定します。
     *
     * @param 要介護認定状態区分コード 要介護認定状態区分コード
     */
    public void set要介護認定状態区分コード(Code 要介護認定状態区分コード) {
        requireNonNull(要介護認定状態区分コード, UrSystemErrorMessages.値がnull.getReplacedMessage("要介護認定状態区分コード"));
        entity.setYokaigoJotaiKubunCode(要介護認定状態区分コード);
    }

    /**
     * 認定有効期間開始年月日を設定します。
     *
     * @param 認定有効期間開始年月日 認定有効期間開始年月日
     */
    public void set認定有効期間開始年月日(FlexibleDate 認定有効期間開始年月日) {
        requireNonNull(認定有効期間開始年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("認定有効期間開始年月日"));
        entity.setNinteiYukoKikanKaishiYMD(認定有効期間開始年月日);
    }

    /**
     * 認定有効期間終了年月日を設定します。
     *
     * @param 認定有効期間終了年月日 認定有効期間終了年月日
     */
    public void set認定有効期間終了年月日(FlexibleDate 認定有効期間終了年月日) {
        requireNonNull(認定有効期間終了年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("認定有効期間終了年月日"));
        entity.setNinteiYukoKikanShuryoYMD(認定有効期間終了年月日);
    }

    /**
     * 認定年月日を設定します。
     *
     * @param 認定年月日 認定年月日
     */
    public void set認定年月日(FlexibleDate 認定年月日) {
        requireNonNull(認定年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("認定年月日"));
        entity.setNinteiYMD(認定年月日);
    }

    /**
     * 指定サービス種類01を設定します。
     *
     * @param 指定サービス種類01 指定サービス種類01
     */
    public void set指定サービス種類01(ServiceShuruiCode 指定サービス種類01) {
        requireNonNull(指定サービス種類01, UrSystemErrorMessages.値がnull.getReplacedMessage("指定サービス種類01"));
        entity.setShiteiServiceShurui01(指定サービス種類01);
    }

    /**
     * 指定サービス種類02を設定します。
     *
     * @param 指定サービス種類02 指定サービス種類02
     */
    public void set指定サービス種類02(ServiceShuruiCode 指定サービス種類02) {
        requireNonNull(指定サービス種類02, UrSystemErrorMessages.値がnull.getReplacedMessage("指定サービス種類02"));
        entity.setShiteiServiceShurui02(指定サービス種類02);
    }

    /**
     * 指定サービス種類03を設定します。
     *
     * @param 指定サービス種類03 指定サービス種類03
     */
    public void set指定サービス種類03(ServiceShuruiCode 指定サービス種類03) {
        requireNonNull(指定サービス種類03, UrSystemErrorMessages.値がnull.getReplacedMessage("指定サービス種類03"));
        entity.setShiteiServiceShurui03(指定サービス種類03);
    }

    /**
     * 指定サービス種類04を設定します。
     *
     * @param 指定サービス種類04 指定サービス種類04
     */
    public void set指定サービス種類04(ServiceShuruiCode 指定サービス種類04) {
        requireNonNull(指定サービス種類04, UrSystemErrorMessages.値がnull.getReplacedMessage("指定サービス種類04"));
        entity.setShiteiServiceShurui04(指定サービス種類04);
    }

    /**
     * 指定サービス種類05を設定します。
     *
     * @param 指定サービス種類05 指定サービス種類05
     */
    public void set指定サービス種類05(ServiceShuruiCode 指定サービス種類05) {
        requireNonNull(指定サービス種類05, UrSystemErrorMessages.値がnull.getReplacedMessage("指定サービス種類05"));
        entity.setShiteiServiceShurui05(指定サービス種類05);
    }

    /**
     * 指定サービス種類06を設定します。
     *
     * @param 指定サービス種類06 指定サービス種類06
     */
    public void set指定サービス種類06(ServiceShuruiCode 指定サービス種類06) {
        requireNonNull(指定サービス種類06, UrSystemErrorMessages.値がnull.getReplacedMessage("指定サービス種類06"));
        entity.setShiteiServiceShurui06(指定サービス種類06);
    }

    /**
     * 指定サービス種類07を設定します。
     *
     * @param 指定サービス種類07 指定サービス種類07
     */
    public void set指定サービス種類07(ServiceShuruiCode 指定サービス種類07) {
        requireNonNull(指定サービス種類07, UrSystemErrorMessages.値がnull.getReplacedMessage("指定サービス種類07"));
        entity.setShiteiServiceShurui07(指定サービス種類07);
    }

    /**
     * 指定サービス種類08を設定します。
     *
     * @param 指定サービス種類08 指定サービス種類08
     */
    public void set指定サービス種類08(ServiceShuruiCode 指定サービス種類08) {
        requireNonNull(指定サービス種類08, UrSystemErrorMessages.値がnull.getReplacedMessage("指定サービス種類08"));
        entity.setShiteiServiceShurui08(指定サービス種類08);
    }

    /**
     * 指定サービス種類09を設定します。
     *
     * @param 指定サービス種類09 指定サービス種類09
     */
    public void set指定サービス種類09(ServiceShuruiCode 指定サービス種類09) {
        requireNonNull(指定サービス種類09, UrSystemErrorMessages.値がnull.getReplacedMessage("指定サービス種類09"));
        entity.setShiteiServiceShurui09(指定サービス種類09);
    }

    /**
     * 指定サービス種類10を設定します。
     *
     * @param 指定サービス種類10 指定サービス種類10
     */
    public void set指定サービス種類10(ServiceShuruiCode 指定サービス種類10) {
        requireNonNull(指定サービス種類10, UrSystemErrorMessages.値がnull.getReplacedMessage("指定サービス種類10"));
        entity.setShiteiServiceShurui10(指定サービス種類10);
    }

    /**
     * 指定サービス種類11を設定します。
     *
     * @param 指定サービス種類11 指定サービス種類11
     */
    public void set指定サービス種類11(ServiceShuruiCode 指定サービス種類11) {
        requireNonNull(指定サービス種類11, UrSystemErrorMessages.値がnull.getReplacedMessage("指定サービス種類11"));
        entity.setShiteiServiceShurui11(指定サービス種類11);
    }

    /**
     * 指定サービス種類12を設定します。
     *
     * @param 指定サービス種類12 指定サービス種類12
     */
    public void set指定サービス種類12(ServiceShuruiCode 指定サービス種類12) {
        requireNonNull(指定サービス種類12, UrSystemErrorMessages.値がnull.getReplacedMessage("指定サービス種類12"));
        entity.setShiteiServiceShurui12(指定サービス種類12);
    }

    /**
     * 指定サービス種類13を設定します。
     *
     * @param 指定サービス種類13 指定サービス種類13
     */
    public void set指定サービス種類13(ServiceShuruiCode 指定サービス種類13) {
        requireNonNull(指定サービス種類13, UrSystemErrorMessages.値がnull.getReplacedMessage("指定サービス種類13"));
        entity.setShiteiServiceShurui13(指定サービス種類13);
    }

    /**
     * 指定サービス種類14を設定します。
     *
     * @param 指定サービス種類14 指定サービス種類14
     */
    public void set指定サービス種類14(ServiceShuruiCode 指定サービス種類14) {
        requireNonNull(指定サービス種類14, UrSystemErrorMessages.値がnull.getReplacedMessage("指定サービス種類14"));
        entity.setShiteiServiceShurui14(指定サービス種類14);
    }

    /**
     * 指定サービス種類15を設定します。
     *
     * @param 指定サービス種類15 指定サービス種類15
     */
    public void set指定サービス種類15(ServiceShuruiCode 指定サービス種類15) {
        requireNonNull(指定サービス種類15, UrSystemErrorMessages.値がnull.getReplacedMessage("指定サービス種類15"));
        entity.setShiteiServiceShurui15(指定サービス種類15);
    }

    /**
     * 指定サービス種類16を設定します。
     *
     * @param 指定サービス種類16 指定サービス種類16
     */
    public void set指定サービス種類16(ServiceShuruiCode 指定サービス種類16) {
        requireNonNull(指定サービス種類16, UrSystemErrorMessages.値がnull.getReplacedMessage("指定サービス種類16"));
        entity.setShiteiServiceShurui16(指定サービス種類16);
    }

    /**
     * 指定サービス種類17を設定します。
     *
     * @param 指定サービス種類17 指定サービス種類17
     */
    public void set指定サービス種類17(ServiceShuruiCode 指定サービス種類17) {
        requireNonNull(指定サービス種類17, UrSystemErrorMessages.値がnull.getReplacedMessage("指定サービス種類17"));
        entity.setShiteiServiceShurui17(指定サービス種類17);
    }

    /**
     * 指定サービス種類18を設定します。
     *
     * @param 指定サービス種類18 指定サービス種類18
     */
    public void set指定サービス種類18(ServiceShuruiCode 指定サービス種類18) {
        requireNonNull(指定サービス種類18, UrSystemErrorMessages.値がnull.getReplacedMessage("指定サービス種類18"));
        entity.setShiteiServiceShurui18(指定サービス種類18);
    }

    /**
     * 指定サービス種類19を設定します。
     *
     * @param 指定サービス種類19 指定サービス種類19
     */
    public void set指定サービス種類19(ServiceShuruiCode 指定サービス種類19) {
        requireNonNull(指定サービス種類19, UrSystemErrorMessages.値がnull.getReplacedMessage("指定サービス種類19"));
        entity.setShiteiServiceShurui19(指定サービス種類19);
    }

    /**
     * 指定サービス種類20を設定します。
     *
     * @param 指定サービス種類20 指定サービス種類20
     */
    public void set指定サービス種類20(ServiceShuruiCode 指定サービス種類20) {
        requireNonNull(指定サービス種類20, UrSystemErrorMessages.値がnull.getReplacedMessage("指定サービス種類20"));
        entity.setShiteiServiceShurui20(指定サービス種類20);
    }

    /**
     * 指定サービス種類21を設定します。
     *
     * @param 指定サービス種類21 指定サービス種類21
     */
    public void set指定サービス種類21(ServiceShuruiCode 指定サービス種類21) {
        requireNonNull(指定サービス種類21, UrSystemErrorMessages.値がnull.getReplacedMessage("指定サービス種類21"));
        entity.setShiteiServiceShurui21(指定サービス種類21);
    }

    /**
     * 指定サービス種類22を設定します。
     *
     * @param 指定サービス種類22 指定サービス種類22
     */
    public void set指定サービス種類22(ServiceShuruiCode 指定サービス種類22) {
        requireNonNull(指定サービス種類22, UrSystemErrorMessages.値がnull.getReplacedMessage("指定サービス種類22"));
        entity.setShiteiServiceShurui22(指定サービス種類22);
    }

    /**
     * 指定サービス種類23を設定します。
     *
     * @param 指定サービス種類23 指定サービス種類23
     */
    public void set指定サービス種類23(ServiceShuruiCode 指定サービス種類23) {
        requireNonNull(指定サービス種類23, UrSystemErrorMessages.値がnull.getReplacedMessage("指定サービス種類23"));
        entity.setShiteiServiceShurui23(指定サービス種類23);
    }

    /**
     * 指定サービス種類24を設定します。
     *
     * @param 指定サービス種類24 指定サービス種類24
     */
    public void set指定サービス種類24(ServiceShuruiCode 指定サービス種類24) {
        requireNonNull(指定サービス種類24, UrSystemErrorMessages.値がnull.getReplacedMessage("指定サービス種類24"));
        entity.setShiteiServiceShurui24(指定サービス種類24);
    }

    /**
     * 指定サービス種類25を設定します。
     *
     * @param 指定サービス種類25 指定サービス種類25
     */
    public void set指定サービス種類25(ServiceShuruiCode 指定サービス種類25) {
        requireNonNull(指定サービス種類25, UrSystemErrorMessages.値がnull.getReplacedMessage("指定サービス種類25"));
        entity.setShiteiServiceShurui25(指定サービス種類25);
    }

    /**
     * 指定サービス種類26を設定します。
     *
     * @param 指定サービス種類26 指定サービス種類26
     */
    public void set指定サービス種類26(ServiceShuruiCode 指定サービス種類26) {
        requireNonNull(指定サービス種類26, UrSystemErrorMessages.値がnull.getReplacedMessage("指定サービス種類26"));
        entity.setShiteiServiceShurui26(指定サービス種類26);
    }

    /**
     * 指定サービス種類27を設定します。
     *
     * @param 指定サービス種類27 指定サービス種類27
     */
    public void set指定サービス種類27(ServiceShuruiCode 指定サービス種類27) {
        requireNonNull(指定サービス種類27, UrSystemErrorMessages.値がnull.getReplacedMessage("指定サービス種類27"));
        entity.setShiteiServiceShurui27(指定サービス種類27);
    }

    /**
     * 指定サービス種類28を設定します。
     *
     * @param 指定サービス種類28 指定サービス種類28
     */
    public void set指定サービス種類28(ServiceShuruiCode 指定サービス種類28) {
        requireNonNull(指定サービス種類28, UrSystemErrorMessages.値がnull.getReplacedMessage("指定サービス種類28"));
        entity.setShiteiServiceShurui28(指定サービス種類28);
    }

    /**
     * 指定サービス種類29を設定します。
     *
     * @param 指定サービス種類29 指定サービス種類29
     */
    public void set指定サービス種類29(ServiceShuruiCode 指定サービス種類29) {
        requireNonNull(指定サービス種類29, UrSystemErrorMessages.値がnull.getReplacedMessage("指定サービス種類29"));
        entity.setShiteiServiceShurui29(指定サービス種類29);
    }

    /**
     * 指定サービス種類30を設定します。
     *
     * @param 指定サービス種類30 指定サービス種類30
     */
    public void set指定サービス種類30(ServiceShuruiCode 指定サービス種類30) {
        requireNonNull(指定サービス種類30, UrSystemErrorMessages.値がnull.getReplacedMessage("指定サービス種類30"));
        entity.setShiteiServiceShurui30(指定サービス種類30);
    }

    /**
     * 喪失年月日を設定します。
     *
     * @param 喪失年月日 喪失年月日
     */
    public void set喪失年月日(FlexibleDate 喪失年月日) {
        requireNonNull(喪失年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("喪失年月日"));
        entity.setSoshitsuYMD(喪失年月日);
    }

    /**
     * 直近異動年月日を設定します。
     *
     * @param 直近異動年月日 直近異動年月日
     */
    public void set直近異動年月日(FlexibleDate 直近異動年月日) {
        requireNonNull(直近異動年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("直近異動年月日"));
        entity.setChokkinIdoYMD(直近異動年月日);
    }

    /**
     * 直近異動事由コードを設定します。
     *
     * @param 直近異動事由コード 直近異動事由コード
     */
    public void set直近異動事由コード(Code 直近異動事由コード) {
        requireNonNull(直近異動事由コード, UrSystemErrorMessages.値がnull.getReplacedMessage("直近異動事由コード"));
        entity.setChokkinIdoJiyuCode(直近異動事由コード);
    }

    /**
     * 有効無効区分を設定します。
     *
     * @param 有効無効区分 有効無効区分
     */
    public void set有効無効区分(Code 有効無効区分) {
        requireNonNull(有効無効区分, UrSystemErrorMessages.値がnull.getReplacedMessage("有効無効区分"));
        entity.setYukoMukoKubun(有効無効区分);
    }

    /**
     * データ区分を設定します。
     *
     * @param データ区分 データ区分
     */
    public void setデータ区分(Code データ区分) {
        requireNonNull(データ区分, UrSystemErrorMessages.値がnull.getReplacedMessage("データ区分"));
        entity.setDataKubun(データ区分);
    }

    /**
     * 同一連番を設定します。
     *
     * @param 同一連番 同一連番
     */
    public void set同一連番(RString 同一連番) {
        requireNonNull(同一連番, UrSystemErrorMessages.値がnull.getReplacedMessage("同一連番"));
        entity.setRemban(同一連番);
    }

    /**
     * 異動理由を設定します。
     *
     * @param 異動理由 異動理由
     */
    public void set異動理由(RString 異動理由) {
        requireNonNull(異動理由, UrSystemErrorMessages.値がnull.getReplacedMessage("異動理由"));
        entity.setIdoRiyu(異動理由);
    }

    /**
     * 申請書区分を設定します。
     *
     * @param 申請書区分 申請書区分
     */
    public void set申請書区分(Code 申請書区分) {
        requireNonNull(申請書区分, UrSystemErrorMessages.値がnull.getReplacedMessage("申請書区分"));
        entity.setShinseishoKubun(申請書区分);
    }

    /**
     * 削除事由コードを設定します。
     *
     * @param 削除事由コード 削除事由コード
     */
    public void set削除事由コード(Code 削除事由コード) {
        requireNonNull(削除事由コード, UrSystemErrorMessages.値がnull.getReplacedMessage("削除事由コード"));
        entity.setSakujoJiyuCode(削除事由コード);
    }

    /**
     * 要支援者認定申請区分を設定します。
     *
     * @param 要支援者認定申請区分 要支援者認定申請区分
     */
    public void set要支援者認定申請区分(boolean 要支援者認定申請区分) {
        requireNonNull(要支援者認定申請区分, UrSystemErrorMessages.値がnull.getReplacedMessage("要支援者認定申請区分"));
        entity.setYoshienshaNinteiShinseiFlag(要支援者認定申請区分);
    }

    /**
     * 支給限度単位数を設定します。
     *
     * @param 支給限度単位数 支給限度単位数
     */
    public void set支給限度単位数(Decimal 支給限度単位数) {
        requireNonNull(支給限度単位数, UrSystemErrorMessages.値がnull.getReplacedMessage("支給限度単位数"));
        entity.setShikyuGendoTanisu(支給限度単位数);
    }

    /**
     * 支給限度有効開始年月日を設定します。
     *
     * @param 支給限度有効開始年月日 支給限度有効開始年月日
     */
    public void set支給限度有効開始年月日(FlexibleDate 支給限度有効開始年月日) {
        requireNonNull(支給限度有効開始年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("支給限度有効開始年月日"));
        entity.setShikyuGendoKaishiYMD(支給限度有効開始年月日);
    }

    /**
     * 支給限度有効終了年月日を設定します。
     *
     * @param 支給限度有効終了年月日 支給限度有効終了年月日
     */
    public void set支給限度有効終了年月日(FlexibleDate 支給限度有効終了年月日) {
        requireNonNull(支給限度有効終了年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("支給限度有効終了年月日"));
        entity.setShikyuGendoShuryoYMD(支給限度有効終了年月日);
    }

    /**
     * 短期入所支給限度日数を設定します。
     *
     * @param 短期入所支給限度日数 短期入所支給限度日数
     */
    public void set短期入所支給限度日数(int 短期入所支給限度日数) {
        requireNonNull(短期入所支給限度日数, UrSystemErrorMessages.値がnull.getReplacedMessage("短期入所支給限度日数"));
        entity.setTankiSikyuGendoNissu(短期入所支給限度日数);
    }

    /**
     * 短期入所支給限度開始年月日を設定します。
     *
     * @param 短期入所支給限度開始年月日 短期入所支給限度開始年月日
     */
    public void set短期入所支給限度開始年月日(FlexibleDate 短期入所支給限度開始年月日) {
        requireNonNull(短期入所支給限度開始年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("短期入所支給限度開始年月日"));
        entity.setTankiShikyuGendoKaishiYMD(短期入所支給限度開始年月日);
    }

    /**
     * 短期入所支給限度終了年月日を設定します。
     *
     * @param 短期入所支給限度終了年月日 短期入所支給限度終了年月日
     */
    public void set短期入所支給限度終了年月日(FlexibleDate 短期入所支給限度終了年月日) {
        requireNonNull(短期入所支給限度終了年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("短期入所支給限度終了年月日"));
        entity.setTankiShikyuGendoShuryoYMD(短期入所支給限度終了年月日);
    }

    /**
     * 当初認定有効開始年月日を設定します。
     *
     * @param 当初認定有効開始年月日 当初認定有効開始年月日
     */
    public void set当初認定有効開始年月日(FlexibleDate 当初認定有効開始年月日) {
        requireNonNull(当初認定有効開始年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("当初認定有効開始年月日"));
        entity.setToshoNinteiYukoKaishiYMD(当初認定有効開始年月日);
    }

    /**
     * 当初認定有効終了年月日を設定します。
     *
     * @param 当初認定有効終了年月日 当初認定有効終了年月日
     */
    public void set当初認定有効終了年月日(FlexibleDate 当初認定有効終了年月日) {
        requireNonNull(当初認定有効終了年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("当初認定有効終了年月日"));
        entity.setToshoNinteiYukoShuryoYMD(当初認定有効終了年月日);
    }

    /**
     * 受給資格証明書発行年月日１を設定します。
     *
     * @param 受給資格証明書発行年月日１ 受給資格証明書発行年月日１
     */
    public void set受給資格証明書発行年月日１(FlexibleDate 受給資格証明書発行年月日１) {
        requireNonNull(受給資格証明書発行年月日１, UrSystemErrorMessages.値がnull.getReplacedMessage("受給資格証明書発行年月日１"));
        entity.setJukyuShikakuShomeishoHakkoYMD1(受給資格証明書発行年月日１);
    }

    /**
     * 受給資格証明書発行年月日２を設定します。
     *
     * @param 受給資格証明書発行年月日２ 受給資格証明書発行年月日２
     */
    public void set受給資格証明書発行年月日２(FlexibleDate 受給資格証明書発行年月日２) {
        requireNonNull(受給資格証明書発行年月日２, UrSystemErrorMessages.値がnull.getReplacedMessage("受給資格証明書発行年月日２"));
        entity.setJukyuShikakuShomeishoHakkoYMD2(受給資格証明書発行年月日２);
    }

    /**
     * 診断命令書発行年月日を設定します。
     *
     * @param 診断命令書発行年月日 診断命令書発行年月日
     */
    public void set診断命令書発行年月日(FlexibleDate 診断命令書発行年月日) {
        requireNonNull(診断命令書発行年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("診断命令書発行年月日"));
        entity.setShindanMeireishoHakkoYMD(診断命令書発行年月日);
    }

    /**
     * 二号申請受理通知書発行年月日を設定します。
     *
     * @param 二号申請受理通知書発行年月日 二号申請受理通知書発行年月日
     */
    public void set二号申請受理通知書発行年月日(FlexibleDate 二号申請受理通知書発行年月日) {
        requireNonNull(二号申請受理通知書発行年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("二号申請受理通知書発行年月日"));
        entity.setNigoShinseiJuriTsuchishoHakkoYMD(二号申請受理通知書発行年月日);
    }

    /**
     * 認定結果通知書発行年月日を設定します。
     *
     * @param 認定結果通知書発行年月日 認定結果通知書発行年月日
     */
    public void set認定結果通知書発行年月日(FlexibleDate 認定結果通知書発行年月日) {
        requireNonNull(認定結果通知書発行年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("認定結果通知書発行年月日"));
        entity.setNinteiKekkaTsuchishoHakkoYMD(認定結果通知書発行年月日);
    }

    /**
     * 区分変更通知書発行年月日を設定します。
     *
     * @param 区分変更通知書発行年月日 区分変更通知書発行年月日
     */
    public void set区分変更通知書発行年月日(FlexibleDate 区分変更通知書発行年月日) {
        requireNonNull(区分変更通知書発行年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("区分変更通知書発行年月日"));
        entity.setKubunHenkoTsuchishoHakkoYMD(区分変更通知書発行年月日);
    }

    /**
     * サービス変更通知書発行年月日を設定します。
     *
     * @param サービス変更通知書発行年月日 サービス変更通知書発行年月日
     */
    public void setサービス変更通知書発行年月日(FlexibleDate サービス変更通知書発行年月日) {
        requireNonNull(サービス変更通知書発行年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス変更通知書発行年月日"));
        entity.setServiceHenkoTsuchishoHakkoYMD(サービス変更通知書発行年月日);
    }

    /**
     * 認定却下通知書発行年月日を設定します。
     *
     * @param 認定却下通知書発行年月日 認定却下通知書発行年月日
     */
    public void set認定却下通知書発行年月日(FlexibleDate 認定却下通知書発行年月日) {
        requireNonNull(認定却下通知書発行年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("認定却下通知書発行年月日"));
        entity.setNinteiKyakkaTsuchishoHakkoYMD(認定却下通知書発行年月日);
    }

    /**
     * 認定取消通知書発行年月日を設定します。
     *
     * @param 認定取消通知書発行年月日 認定取消通知書発行年月日
     */
    public void set認定取消通知書発行年月日(FlexibleDate 認定取消通知書発行年月日) {
        requireNonNull(認定取消通知書発行年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("認定取消通知書発行年月日"));
        entity.setNinteiTorikeshiTsuchishoHakkoYMD(認定取消通知書発行年月日);
    }

    /**
     * 資格取得前申請フラグを設定します。
     *
     * @param 資格取得前申請フラグ 資格取得前申請フラグ
     */
    public void set資格取得前申請フラグ(boolean 資格取得前申請フラグ) {
        requireNonNull(資格取得前申請フラグ, UrSystemErrorMessages.値がnull.getReplacedMessage("資格取得前申請フラグ"));
        entity.setShikakuShutokuMaeShinseiFlag(資格取得前申請フラグ);
    }

    /**
     * 旧措置者フラグを設定します。
     *
     * @param 旧措置者フラグ 旧措置者フラグ
     */
    public void set旧措置者フラグ(boolean 旧措置者フラグ) {
        requireNonNull(旧措置者フラグ, UrSystemErrorMessages.値がnull.getReplacedMessage("旧措置者フラグ"));
        entity.setKyuSochishaFlag(旧措置者フラグ);
    }

    /**
     * 論理削除フラグを設定します。
     *
     * @param 論理削除フラグ 論理削除フラグ
     */
    public void set論理削除フラグ(boolean 論理削除フラグ) {
        requireNonNull(論理削除フラグ, UrSystemErrorMessages.値がnull.getReplacedMessage("論理削除フラグ"));
        entity.setLogicalDeletedFlag(論理削除フラグ);
    }

    /**
     * 状態に削除を設定します。
     *
     * @param deleteFlag deleteFlag
     */
    public void setDeletedState(boolean deleteFlag) {
        if (deleteFlag) {
            entity.setState(EntityDataState.Deleted);
        } else {
            entity.unsetState();
        }
    }

    /**
     * stateを返します。
     *
     * @return EntityDataState
     */
    public EntityDataState getState() {
        return entity.getState();
    }

    private JukyushaDaicho(Builder builder) {
        this.entity = builder.entity;
    }

    /**
     * 編集用のビルダーを返します。
     *
     * @return ビルダー
     */
    public Builder createBuilderForEdit() {
        return new Builder(this);
    }

    /**
     * 新しい{@link JukyushaDaicho}を生成するためのビルダーを返します。
     *
     * @return ビルダー
     */
    public static Builder newBuilder() {
        return new Builder();
    }

    /**
     * {@link JukyushaDaicho}を生成するためのビルダーです。
     */
    public static final class Builder {

        private DbT4001JukyushaDaichoEntity entity;

        Builder() {
            this.entity = new DbT4001JukyushaDaichoEntity();

        }

        Builder(JukyushaDaicho jukyushaDaicho) {
            this.entity = jukyushaDaicho.entity.clone();
        }

        /**
         * insertDantaiCdを設定します。
         *
         * @param insertDantaiCd
         * @return builder
         */
        public Builder setInsertDantaiCd(RString insertDantaiCd) {
            Objects.requireNonNull(insertDantaiCd);
            this.entity.setInsertDantaiCd(insertDantaiCd);
            return this;
        }

        /**
         * isDeletedを設定します。
         *
         * @param isDeleted
         * @return builder
         */
        public Builder setIsDeleted(boolean isDeleted) {
            this.entity.setIsDeleted(isDeleted);
            return this;
        }

        /**
         * lastUpdateReamsLoginIdを設定します。
         *
         * @param lastUpdateReamsLoginId
         * @return builder
         */
        public Builder setLastUpdateReamsLoginId(RString lastUpdateReamsLoginId) {
            Objects.requireNonNull(lastUpdateReamsLoginId);
            this.entity.setLastUpdateReamsLoginId(lastUpdateReamsLoginId);
            return this;
        }

        /**
         * shichosonCodeを設定します。
         *
         * @param shichosonCode
         * @return builder
         */
        public Builder setShichosonCode(LasdecCode shichosonCode) {
            Objects.requireNonNull(shichosonCode);
            this.entity.setShichosonCode(shichosonCode);
            return this;
        }

        /**
         * hihokenshaNoを設定します。
         *
         * @param hihokenshaNo
         * @return builder
         */
        public Builder setHihokenshaNo(HihokenshaNo hihokenshaNo) {
            Objects.requireNonNull(hihokenshaNo);
            this.entity.setHihokenshaNo(hihokenshaNo);
            return this;
        }

        /**
         * rirekiNoを設定します。
         *
         * @param rirekiNo
         * @return builder
         */
        public Builder setRirekiNo(RString rirekiNo) {
            Objects.requireNonNull(rirekiNo);
            this.entity.setRirekiNo(rirekiNo);
            return this;
        }

        /**
         * edabanを設定します。
         *
         * @param edaban
         * @return builder
         */
        public Builder setEdaban(RString edaban) {
            Objects.requireNonNull(edaban);
            this.entity.setEdaban(edaban);
            return this;
        }

        /**
         * shinseishoKanriNoを設定します。
         *
         * @param shinseishoKanriNo
         * @return builder
         */
        public Builder setShinseishoKanriNo(ShinseishoKanriNo shinseishoKanriNo) {
            Objects.requireNonNull(shinseishoKanriNo);
            this.entity.setShinseishoKanriNo(shinseishoKanriNo);
            return this;
        }

        /**
         * shinseiJokyoKubunを設定します。
         *
         * @param shinseiJokyoKubun
         * @return builder
         */
        public Builder setShinseiJokyoKubun(RString shinseiJokyoKubun) {
            Objects.requireNonNull(shinseiJokyoKubun);
            this.entity.setShinseiJokyoKubun(shinseiJokyoKubun);
            return this;
        }

        /**
         * shishoCodeを設定します。
         *
         * @param shishoCode
         * @return builder
         */
        public Builder setShishoCode(RString shishoCode) {
            Objects.requireNonNull(shishoCode);
            this.entity.setShishoCode(shishoCode);
            return this;
        }

        /**
         * chokkinFlagを設定します。
         *
         * @param chokkinFlag
         * @return builder
         */
        public Builder setChokkinFlag(boolean chokkinFlag) {
            this.entity.setChokkinFlag(chokkinFlag);
            return this;
        }

        /**
         * shikibetsuCodeを設定します。
         *
         * @param shikibetsuCode
         * @return builder
         */
        public Builder setShikibetsuCode(ShikibetsuCode shikibetsuCode) {
            Objects.requireNonNull(shikibetsuCode);
            this.entity.setShikibetsuCode(shikibetsuCode);
            return this;
        }

        /**
         * jukyuShinseiJiyuを設定します。
         *
         * @param jukyuShinseiJiyu
         * @return builder
         */
        public Builder setJukyuShinseiJiyu(Code jukyuShinseiJiyu) {
            Objects.requireNonNull(jukyuShinseiJiyu);
            this.entity.setJukyuShinseiJiyu(jukyuShinseiJiyu);
            return this;
        }

        /**
         * shinseiRiyuを設定します。
         *
         * @param shinseiRiyu
         * @return builder
         */
        public Builder setShinseiRiyu(RString shinseiRiyu) {
            Objects.requireNonNull(shinseiRiyu);
            this.entity.setShinseiRiyu(shinseiRiyu);
            return this;
        }

        /**
         * shinseishaKankeiCodeを設定します。
         *
         * @param shinseishaKankeiCode
         * @return builder
         */
        public Builder setShinseishaKankeiCode(Code shinseishaKankeiCode) {
            Objects.requireNonNull(shinseishaKankeiCode);
            this.entity.setShinseishaKankeiCode(shinseishaKankeiCode);
            return this;
        }

        /**
         * homninKankeiを設定します。
         *
         * @param homninKankei
         * @return builder
         */
        public Builder setHomninKankei(RString homninKankei) {
            Objects.requireNonNull(homninKankei);
            this.entity.setHomninKankei(homninKankei);
            return this;
        }

        /**
         * jukyuShinseiYMDを設定します。
         *
         * @param jukyuShinseiYMD
         * @return builder
         */
        public Builder setJukyuShinseiYMD(FlexibleDate jukyuShinseiYMD) {
            Objects.requireNonNull(jukyuShinseiYMD);
            this.entity.setJukyuShinseiYMD(jukyuShinseiYMD);
            return this;
        }

        /**
         * nigoTokuteiShippeiCodeを設定します。
         *
         * @param nigoTokuteiShippeiCode
         * @return builder
         */
        public Builder setNigoTokuteiShippeiCode(Code nigoTokuteiShippeiCode) {
            Objects.requireNonNull(nigoTokuteiShippeiCode);
            this.entity.setNigoTokuteiShippeiCode(nigoTokuteiShippeiCode);
            return this;
        }

        /**
         * shinsakaiIraiYMDを設定します。
         *
         * @param shinsakaiIraiYMD
         * @return builder
         */
        public Builder setShinsakaiIraiYMD(FlexibleDate shinsakaiIraiYMD) {
            Objects.requireNonNull(shinsakaiIraiYMD);
            this.entity.setShinsakaiIraiYMD(shinsakaiIraiYMD);
            return this;
        }

        /**
         * yokaigoJotaiKubunCodeを設定します。
         *
         * @param yokaigoJotaiKubunCode
         * @return builder
         */
        public Builder setYokaigoJotaiKubunCode(Code yokaigoJotaiKubunCode) {
            Objects.requireNonNull(yokaigoJotaiKubunCode);
            this.entity.setYokaigoJotaiKubunCode(yokaigoJotaiKubunCode);
            return this;
        }

        /**
         * ninteiYukoKikanKaishiYMDを設定します。
         *
         * @param ninteiYukoKikanKaishiYMD
         * @return builder
         */
        public Builder setNinteiYukoKikanKaishiYMD(FlexibleDate ninteiYukoKikanKaishiYMD) {
            Objects.requireNonNull(ninteiYukoKikanKaishiYMD);
            this.entity.setNinteiYukoKikanKaishiYMD(ninteiYukoKikanKaishiYMD);
            return this;
        }

        /**
         * ninteiYukoKikanShuryoYMDを設定します。
         *
         * @param ninteiYukoKikanShuryoYMD
         * @return builder
         */
        public Builder setNinteiYukoKikanShuryoYMD(FlexibleDate ninteiYukoKikanShuryoYMD) {
            Objects.requireNonNull(ninteiYukoKikanShuryoYMD);
            this.entity.setNinteiYukoKikanShuryoYMD(ninteiYukoKikanShuryoYMD);
            return this;
        }

        /**
         * ninteiYMDを設定します。
         *
         * @param ninteiYMD
         * @return builder
         */
        public Builder setNinteiYMD(FlexibleDate ninteiYMD) {
            Objects.requireNonNull(ninteiYMD);
            this.entity.setNinteiYMD(ninteiYMD);
            return this;
        }

        /**
         * shiteiServiceShurui01を設定します。
         *
         * @param shiteiServiceShurui01
         * @return builder
         */
        public Builder setShiteiServiceShurui01(ServiceShuruiCode shiteiServiceShurui01) {
            Objects.requireNonNull(shiteiServiceShurui01);
            this.entity.setShiteiServiceShurui01(shiteiServiceShurui01);
            return this;
        }

        /**
         * shiteiServiceShurui02を設定します。
         *
         * @param shiteiServiceShurui02
         * @return builder
         */
        public Builder setShiteiServiceShurui02(ServiceShuruiCode shiteiServiceShurui02) {
            Objects.requireNonNull(shiteiServiceShurui02);
            this.entity.setShiteiServiceShurui02(shiteiServiceShurui02);
            return this;
        }

        /**
         * shiteiServiceShurui03を設定します。
         *
         * @param shiteiServiceShurui03
         * @return builder
         */
        public Builder setShiteiServiceShurui03(ServiceShuruiCode shiteiServiceShurui03) {
            Objects.requireNonNull(shiteiServiceShurui03);
            this.entity.setShiteiServiceShurui03(shiteiServiceShurui03);
            return this;
        }

        /**
         * shiteiServiceShurui04を設定します。
         *
         * @param shiteiServiceShurui04
         * @return builder
         */
        public Builder setShiteiServiceShurui04(ServiceShuruiCode shiteiServiceShurui04) {
            Objects.requireNonNull(shiteiServiceShurui04);
            this.entity.setShiteiServiceShurui04(shiteiServiceShurui04);
            return this;
        }

        /**
         * shiteiServiceShurui05を設定します。
         *
         * @param shiteiServiceShurui05
         * @return builder
         */
        public Builder setShiteiServiceShurui05(ServiceShuruiCode shiteiServiceShurui05) {
            Objects.requireNonNull(shiteiServiceShurui05);
            this.entity.setShiteiServiceShurui05(shiteiServiceShurui05);
            return this;
        }

        /**
         * shiteiServiceShurui06を設定します。
         *
         * @param shiteiServiceShurui06
         * @return builder
         */
        public Builder setShiteiServiceShurui06(ServiceShuruiCode shiteiServiceShurui06) {
            Objects.requireNonNull(shiteiServiceShurui06);
            this.entity.setShiteiServiceShurui06(shiteiServiceShurui06);
            return this;
        }

        /**
         * shiteiServiceShurui07を設定します。
         *
         * @param shiteiServiceShurui07
         * @return builder
         */
        public Builder setShiteiServiceShurui07(ServiceShuruiCode shiteiServiceShurui07) {
            Objects.requireNonNull(shiteiServiceShurui07);
            this.entity.setShiteiServiceShurui07(shiteiServiceShurui07);
            return this;
        }

        /**
         * shiteiServiceShurui08を設定します。
         *
         * @param shiteiServiceShurui08
         * @return builder
         */
        public Builder setShiteiServiceShurui08(ServiceShuruiCode shiteiServiceShurui08) {
            Objects.requireNonNull(shiteiServiceShurui08);
            this.entity.setShiteiServiceShurui08(shiteiServiceShurui08);
            return this;
        }

        /**
         * shiteiServiceShurui09を設定します。
         *
         * @param shiteiServiceShurui09
         * @return builder
         */
        public Builder setShiteiServiceShurui09(ServiceShuruiCode shiteiServiceShurui09) {
            Objects.requireNonNull(shiteiServiceShurui09);
            this.entity.setShiteiServiceShurui09(shiteiServiceShurui09);
            return this;
        }

        /**
         * shiteiServiceShurui10を設定します。
         *
         * @param shiteiServiceShurui10
         * @return builder
         */
        public Builder setShiteiServiceShurui10(ServiceShuruiCode shiteiServiceShurui10) {
            Objects.requireNonNull(shiteiServiceShurui10);
            this.entity.setShiteiServiceShurui10(shiteiServiceShurui10);
            return this;
        }

        /**
         * shiteiServiceShurui11を設定します。
         *
         * @param shiteiServiceShurui11
         * @return builder
         */
        public Builder setShiteiServiceShurui11(ServiceShuruiCode shiteiServiceShurui11) {
            Objects.requireNonNull(shiteiServiceShurui11);
            this.entity.setShiteiServiceShurui11(shiteiServiceShurui11);
            return this;
        }

        /**
         * shiteiServiceShurui12を設定します。
         *
         * @param shiteiServiceShurui12
         * @return builder
         */
        public Builder setShiteiServiceShurui12(ServiceShuruiCode shiteiServiceShurui12) {
            Objects.requireNonNull(shiteiServiceShurui12);
            this.entity.setShiteiServiceShurui12(shiteiServiceShurui12);
            return this;
        }

        /**
         * shiteiServiceShurui13を設定します。
         *
         * @param shiteiServiceShurui13
         * @return builder
         */
        public Builder setShiteiServiceShurui13(ServiceShuruiCode shiteiServiceShurui13) {
            Objects.requireNonNull(shiteiServiceShurui13);
            this.entity.setShiteiServiceShurui13(shiteiServiceShurui13);
            return this;
        }

        /**
         * shiteiServiceShurui14を設定します。
         *
         * @param shiteiServiceShurui14
         * @return builder
         */
        public Builder setShiteiServiceShurui14(ServiceShuruiCode shiteiServiceShurui14) {
            Objects.requireNonNull(shiteiServiceShurui14);
            this.entity.setShiteiServiceShurui14(shiteiServiceShurui14);
            return this;
        }

        /**
         * shiteiServiceShurui15を設定します。
         *
         * @param shiteiServiceShurui15
         * @return builder
         */
        public Builder setShiteiServiceShurui15(ServiceShuruiCode shiteiServiceShurui15) {
            Objects.requireNonNull(shiteiServiceShurui15);
            this.entity.setShiteiServiceShurui15(shiteiServiceShurui15);
            return this;
        }

        /**
         * shiteiServiceShurui16を設定します。
         *
         * @param shiteiServiceShurui16
         * @return builder
         */
        public Builder setShiteiServiceShurui16(ServiceShuruiCode shiteiServiceShurui16) {
            Objects.requireNonNull(shiteiServiceShurui16);
            this.entity.setShiteiServiceShurui16(shiteiServiceShurui16);
            return this;
        }

        /**
         * shiteiServiceShurui17を設定します。
         *
         * @param shiteiServiceShurui17
         * @return builder
         */
        public Builder setShiteiServiceShurui17(ServiceShuruiCode shiteiServiceShurui17) {
            Objects.requireNonNull(shiteiServiceShurui17);
            this.entity.setShiteiServiceShurui17(shiteiServiceShurui17);
            return this;
        }

        /**
         * shiteiServiceShurui18を設定します。
         *
         * @param shiteiServiceShurui18
         * @return builder
         */
        public Builder setShiteiServiceShurui18(ServiceShuruiCode shiteiServiceShurui18) {
            Objects.requireNonNull(shiteiServiceShurui18);
            this.entity.setShiteiServiceShurui18(shiteiServiceShurui18);
            return this;
        }

        /**
         * shiteiServiceShurui19を設定します。
         *
         * @param shiteiServiceShurui19
         * @return builder
         */
        public Builder setShiteiServiceShurui19(ServiceShuruiCode shiteiServiceShurui19) {
            Objects.requireNonNull(shiteiServiceShurui19);
            this.entity.setShiteiServiceShurui19(shiteiServiceShurui19);
            return this;
        }

        /**
         * shiteiServiceShurui20を設定します。
         *
         * @param shiteiServiceShurui20
         * @return builder
         */
        public Builder setShiteiServiceShurui20(ServiceShuruiCode shiteiServiceShurui20) {
            Objects.requireNonNull(shiteiServiceShurui20);
            this.entity.setShiteiServiceShurui20(shiteiServiceShurui20);
            return this;
        }

        /**
         * shiteiServiceShurui21を設定します。
         *
         * @param shiteiServiceShurui21
         * @return builder
         */
        public Builder setShiteiServiceShurui21(ServiceShuruiCode shiteiServiceShurui21) {
            Objects.requireNonNull(shiteiServiceShurui21);
            this.entity.setShiteiServiceShurui21(shiteiServiceShurui21);
            return this;
        }

        /**
         * shiteiServiceShurui22を設定します。
         *
         * @param shiteiServiceShurui22
         * @return builder
         */
        public Builder setShiteiServiceShurui22(ServiceShuruiCode shiteiServiceShurui22) {
            Objects.requireNonNull(shiteiServiceShurui22);
            this.entity.setShiteiServiceShurui22(shiteiServiceShurui22);
            return this;
        }

        /**
         * shiteiServiceShurui23を設定します。
         *
         * @param shiteiServiceShurui23
         * @return builder
         */
        public Builder setShiteiServiceShurui23(ServiceShuruiCode shiteiServiceShurui23) {
            Objects.requireNonNull(shiteiServiceShurui23);
            this.entity.setShiteiServiceShurui23(shiteiServiceShurui23);
            return this;
        }

        /**
         * shiteiServiceShurui24を設定します。
         *
         * @param shiteiServiceShurui24
         * @return builder
         */
        public Builder setShiteiServiceShurui24(ServiceShuruiCode shiteiServiceShurui24) {
            Objects.requireNonNull(shiteiServiceShurui24);
            this.entity.setShiteiServiceShurui24(shiteiServiceShurui24);
            return this;
        }

        /**
         * shiteiServiceShurui25を設定します。
         *
         * @param shiteiServiceShurui25
         * @return builder
         */
        public Builder setShiteiServiceShurui25(ServiceShuruiCode shiteiServiceShurui25) {
            Objects.requireNonNull(shiteiServiceShurui25);
            this.entity.setShiteiServiceShurui25(shiteiServiceShurui25);
            return this;
        }

        /**
         * shiteiServiceShurui26を設定します。
         *
         * @param shiteiServiceShurui26
         * @return builder
         */
        public Builder setShiteiServiceShurui26(ServiceShuruiCode shiteiServiceShurui26) {
            Objects.requireNonNull(shiteiServiceShurui26);
            this.entity.setShiteiServiceShurui26(shiteiServiceShurui26);
            return this;
        }

        /**
         * shiteiServiceShurui27を設定します。
         *
         * @param shiteiServiceShurui27
         * @return builder
         */
        public Builder setShiteiServiceShurui27(ServiceShuruiCode shiteiServiceShurui27) {
            Objects.requireNonNull(shiteiServiceShurui27);
            this.entity.setShiteiServiceShurui27(shiteiServiceShurui27);
            return this;
        }

        /**
         * shiteiServiceShurui28を設定します。
         *
         * @param shiteiServiceShurui28
         * @return builder
         */
        public Builder setShiteiServiceShurui28(ServiceShuruiCode shiteiServiceShurui28) {
            Objects.requireNonNull(shiteiServiceShurui28);
            this.entity.setShiteiServiceShurui28(shiteiServiceShurui28);
            return this;
        }

        /**
         * shiteiServiceShurui29を設定します。
         *
         * @param shiteiServiceShurui29
         * @return builder
         */
        public Builder setShiteiServiceShurui29(ServiceShuruiCode shiteiServiceShurui29) {
            Objects.requireNonNull(shiteiServiceShurui29);
            this.entity.setShiteiServiceShurui29(shiteiServiceShurui29);
            return this;
        }

        /**
         * shiteiServiceShurui30を設定します。
         *
         * @param shiteiServiceShurui30
         * @return builder
         */
        public Builder setShiteiServiceShurui30(ServiceShuruiCode shiteiServiceShurui30) {
            Objects.requireNonNull(shiteiServiceShurui30);
            this.entity.setShiteiServiceShurui30(shiteiServiceShurui30);
            return this;
        }

        /**
         * soshitsuYMDを設定します。
         *
         * @param soshitsuYMD
         * @return builder
         */
        public Builder setSoshitsuYMD(FlexibleDate soshitsuYMD) {
            Objects.requireNonNull(soshitsuYMD);
            this.entity.setSoshitsuYMD(soshitsuYMD);
            return this;
        }

        /**
         * chokkinIdoYMDを設定します。
         *
         * @param chokkinIdoYMD
         * @return builder
         */
        public Builder setChokkinIdoYMD(FlexibleDate chokkinIdoYMD) {
            Objects.requireNonNull(chokkinIdoYMD);
            this.entity.setChokkinIdoYMD(chokkinIdoYMD);
            return this;
        }

        /**
         * chokkinIdoJiyuCodeを設定します。
         *
         * @param chokkinIdoJiyuCode
         * @return builder
         */
        public Builder setChokkinIdoJiyuCode(Code chokkinIdoJiyuCode) {
            Objects.requireNonNull(chokkinIdoJiyuCode);
            this.entity.setChokkinIdoJiyuCode(chokkinIdoJiyuCode);
            return this;
        }

        /**
         * yukoMukoKubunを設定します。
         *
         * @param yukoMukoKubun
         * @return builder
         */
        public Builder setYukoMukoKubun(Code yukoMukoKubun) {
            Objects.requireNonNull(yukoMukoKubun);
            this.entity.setYukoMukoKubun(yukoMukoKubun);
            return this;
        }

        /**
         * dataKubunを設定します。
         *
         * @param dataKubun
         * @return builder
         */
        public Builder setDataKubun(Code dataKubun) {
            Objects.requireNonNull(dataKubun);
            this.entity.setDataKubun(dataKubun);
            return this;
        }

        /**
         * rembanを設定します。
         *
         * @param remban
         * @return builder
         */
        public Builder setRemban(RString remban) {
            Objects.requireNonNull(remban);
            this.entity.setRemban(remban);
            return this;
        }

        /**
         * idoRiyuを設定します。
         *
         * @param idoRiyu
         * @return builder
         */
        public Builder setIdoRiyu(RString idoRiyu) {
            Objects.requireNonNull(idoRiyu);
            this.entity.setIdoRiyu(idoRiyu);
            return this;
        }

        /**
         * shinseishoKubunを設定します。
         *
         * @param shinseishoKubun
         * @return builder
         */
        public Builder setShinseishoKubun(Code shinseishoKubun) {
            Objects.requireNonNull(shinseishoKubun);
            this.entity.setShinseishoKubun(shinseishoKubun);
            return this;
        }

        /**
         * sakujoJiyuCodeを設定します。
         *
         * @param sakujoJiyuCode
         * @return builder
         */
        public Builder setSakujoJiyuCode(Code sakujoJiyuCode) {
            Objects.requireNonNull(sakujoJiyuCode);
            this.entity.setSakujoJiyuCode(sakujoJiyuCode);
            return this;
        }

        /**
         * yoshienshaNinteiShinseiFlagを設定します。
         *
         * @param yoshienshaNinteiShinseiFlag
         * @return builder
         */
        public Builder setYoshienshaNinteiShinseiFlag(boolean yoshienshaNinteiShinseiFlag) {
            this.entity.setYoshienshaNinteiShinseiFlag(yoshienshaNinteiShinseiFlag);
            return this;
        }

        /**
         * shikyuGendoTanisuを設定します。
         *
         * @param shikyuGendoTanisu
         * @return builder
         */
        public Builder setShikyuGendoTanisu(Decimal shikyuGendoTanisu) {
            Objects.requireNonNull(shikyuGendoTanisu);
            this.entity.setShikyuGendoTanisu(shikyuGendoTanisu);
            return this;
        }

        /**
         * shikyuGendoKaishiYMDを設定します。
         *
         * @param shikyuGendoKaishiYMD
         * @return builder
         */
        public Builder setShikyuGendoKaishiYMD(FlexibleDate shikyuGendoKaishiYMD) {
            Objects.requireNonNull(shikyuGendoKaishiYMD);
            this.entity.setShikyuGendoKaishiYMD(shikyuGendoKaishiYMD);
            return this;
        }

        /**
         * shikyuGendoShuryoYMDを設定します。
         *
         * @param shikyuGendoShuryoYMD
         * @return builder
         */
        public Builder setShikyuGendoShuryoYMD(FlexibleDate shikyuGendoShuryoYMD) {
            Objects.requireNonNull(shikyuGendoShuryoYMD);
            this.entity.setShikyuGendoShuryoYMD(shikyuGendoShuryoYMD);
            return this;
        }

        /**
         * tankiSikyuGendoNissuを設定します。
         *
         * @param tankiSikyuGendoNissu
         * @return builder
         */
        public Builder setTankiSikyuGendoNissu(int tankiSikyuGendoNissu) {
            this.entity.setTankiSikyuGendoNissu(tankiSikyuGendoNissu);
            return this;
        }

        /**
         * tankiShikyuGendoKaishiYMDを設定します。
         *
         * @param tankiShikyuGendoKaishiYMD
         * @return builder
         */
        public Builder setTankiShikyuGendoKaishiYMD(FlexibleDate tankiShikyuGendoKaishiYMD) {
            Objects.requireNonNull(tankiShikyuGendoKaishiYMD);
            this.entity.setTankiShikyuGendoKaishiYMD(tankiShikyuGendoKaishiYMD);
            return this;
        }

        /**
         * tankiShikyuGendoShuryoYMDを設定します。
         *
         * @param tankiShikyuGendoShuryoYMD
         * @return builder
         */
        public Builder setTankiShikyuGendoShuryoYMD(FlexibleDate tankiShikyuGendoShuryoYMD) {
            Objects.requireNonNull(tankiShikyuGendoShuryoYMD);
            this.entity.setTankiShikyuGendoShuryoYMD(tankiShikyuGendoShuryoYMD);
            return this;
        }

        /**
         * toshoNinteiYukoKaishiYMDを設定します。
         *
         * @param toshoNinteiYukoKaishiYMD
         * @return builder
         */
        public Builder setToshoNinteiYukoKaishiYMD(FlexibleDate toshoNinteiYukoKaishiYMD) {
            Objects.requireNonNull(toshoNinteiYukoKaishiYMD);
            this.entity.setToshoNinteiYukoKaishiYMD(toshoNinteiYukoKaishiYMD);
            return this;
        }

        /**
         * toshoNinteiYukoShuryoYMDを設定します。
         *
         * @param toshoNinteiYukoShuryoYMD
         * @return builder
         */
        public Builder setToshoNinteiYukoShuryoYMD(FlexibleDate toshoNinteiYukoShuryoYMD) {
            Objects.requireNonNull(toshoNinteiYukoShuryoYMD);
            this.entity.setToshoNinteiYukoShuryoYMD(toshoNinteiYukoShuryoYMD);
            return this;
        }

        /**
         * jukyuShikakuShomeishoHakkoYMD1を設定します。
         *
         * @param jukyuShikakuShomeishoHakkoYMD1
         * @return builder
         */
        public Builder setJukyuShikakuShomeishoHakkoYMD1(FlexibleDate jukyuShikakuShomeishoHakkoYMD1) {
            Objects.requireNonNull(jukyuShikakuShomeishoHakkoYMD1);
            this.entity.setJukyuShikakuShomeishoHakkoYMD1(jukyuShikakuShomeishoHakkoYMD1);
            return this;
        }

        /**
         * jukyuShikakuShomeishoHakkoYMD2を設定します。
         *
         * @param jukyuShikakuShomeishoHakkoYMD2
         * @return builder
         */
        public Builder setJukyuShikakuShomeishoHakkoYMD2(FlexibleDate jukyuShikakuShomeishoHakkoYMD2) {
            Objects.requireNonNull(jukyuShikakuShomeishoHakkoYMD2);
            this.entity.setJukyuShikakuShomeishoHakkoYMD2(jukyuShikakuShomeishoHakkoYMD2);
            return this;
        }

        /**
         * shindanMeireishoHakkoYMDを設定します。
         *
         * @param shindanMeireishoHakkoYMD
         * @return builder
         */
        public Builder setShindanMeireishoHakkoYMD(FlexibleDate shindanMeireishoHakkoYMD) {
            Objects.requireNonNull(shindanMeireishoHakkoYMD);
            this.entity.setShindanMeireishoHakkoYMD(shindanMeireishoHakkoYMD);
            return this;
        }

        /**
         * nigoShinseiJuriTsuchishoHakkoYMDを設定します。
         *
         * @param nigoShinseiJuriTsuchishoHakkoYMD
         * @return builder
         */
        public Builder setNigoShinseiJuriTsuchishoHakkoYMD(FlexibleDate nigoShinseiJuriTsuchishoHakkoYMD) {
            Objects.requireNonNull(nigoShinseiJuriTsuchishoHakkoYMD);
            this.entity.setNigoShinseiJuriTsuchishoHakkoYMD(nigoShinseiJuriTsuchishoHakkoYMD);
            return this;
        }

        /**
         * ninteiKekkaTsuchishoHakkoYMDを設定します。
         *
         * @param ninteiKekkaTsuchishoHakkoYMD
         * @return builder
         */
        public Builder setNinteiKekkaTsuchishoHakkoYMD(FlexibleDate ninteiKekkaTsuchishoHakkoYMD) {
            Objects.requireNonNull(ninteiKekkaTsuchishoHakkoYMD);
            this.entity.setNinteiKekkaTsuchishoHakkoYMD(ninteiKekkaTsuchishoHakkoYMD);
            return this;
        }

        /**
         * kubunHenkoTsuchishoHakkoYMDを設定します。
         *
         * @param kubunHenkoTsuchishoHakkoYMD
         * @return builder
         */
        public Builder setKubunHenkoTsuchishoHakkoYMD(FlexibleDate kubunHenkoTsuchishoHakkoYMD) {
            Objects.requireNonNull(kubunHenkoTsuchishoHakkoYMD);
            this.entity.setKubunHenkoTsuchishoHakkoYMD(kubunHenkoTsuchishoHakkoYMD);
            return this;
        }

        /**
         * serviceHenkoTsuchishoHakkoYMDを設定します。
         *
         * @param serviceHenkoTsuchishoHakkoYMD
         * @return builder
         */
        public Builder setServiceHenkoTsuchishoHakkoYMD(FlexibleDate serviceHenkoTsuchishoHakkoYMD) {
            Objects.requireNonNull(serviceHenkoTsuchishoHakkoYMD);
            this.entity.setServiceHenkoTsuchishoHakkoYMD(serviceHenkoTsuchishoHakkoYMD);
            return this;
        }

        /**
         * ninteiKyakkaTsuchishoHakkoYMDを設定します。
         *
         * @param ninteiKyakkaTsuchishoHakkoYMD
         * @return builder
         */
        public Builder setNinteiKyakkaTsuchishoHakkoYMD(FlexibleDate ninteiKyakkaTsuchishoHakkoYMD) {
            Objects.requireNonNull(ninteiKyakkaTsuchishoHakkoYMD);
            this.entity.setNinteiKyakkaTsuchishoHakkoYMD(ninteiKyakkaTsuchishoHakkoYMD);
            return this;
        }

        /**
         * ninteiTorikeshiTsuchishoHakkoYMDを設定します。
         *
         * @param ninteiTorikeshiTsuchishoHakkoYMD
         * @return builder
         */
        public Builder setNinteiTorikeshiTsuchishoHakkoYMD(FlexibleDate ninteiTorikeshiTsuchishoHakkoYMD) {
            Objects.requireNonNull(ninteiTorikeshiTsuchishoHakkoYMD);
            this.entity.setNinteiTorikeshiTsuchishoHakkoYMD(ninteiTorikeshiTsuchishoHakkoYMD);
            return this;
        }

        /**
         * shikakuShutokuMaeShinseiFlagを設定します。
         *
         * @param shikakuShutokuMaeShinseiFlag
         * @return builder
         */
        public Builder setShikakuShutokuMaeShinseiFlag(boolean shikakuShutokuMaeShinseiFlag) {
            this.entity.setShikakuShutokuMaeShinseiFlag(shikakuShutokuMaeShinseiFlag);
            return this;
        }

        /**
         * kyuSochishaFlagを設定します。
         *
         * @param kyuSochishaFlag
         * @return builder
         */
        public Builder setKyuSochishaFlag(boolean kyuSochishaFlag) {
            this.entity.setKyuSochishaFlag(kyuSochishaFlag);
            return this;
        }

        /**
         * logicalDeletedFlagを設定します。
         *
         * @param logicalDeletedFlag
         * @return builder
         */
        public Builder setLogicalDeletedFlag(boolean logicalDeletedFlag) {
            this.entity.setLogicalDeletedFlag(logicalDeletedFlag);
            return this;
        }

        /**
         * {@link JukyushaDaicho}を生成します。
         *
         * @return {@link JukyushaDaicho}
         */
        public JukyushaDaicho build() {
            return new JukyushaDaicho(this);
        }
    }

    /**
     * このオブジェクトのシリアライズ形式を提供します。
     * 戻り値である{@link Serializable}のインスタンスは、デシリアライズ時に、このオブジェクトを生成します。
     *
     * @return このオブジェクトのシリアライズ形式
     */
    public Serializable serialize() {
        return new _SerializationProxy(this);
    }

    private static final class _SerializationProxy implements Serializable {

        private static final long serialVersionUID = 3003223727974097014L;

        private final DbT4001JukyushaDaichoEntity entity;

        private _SerializationProxy(JukyushaDaicho jukyushaDaicho) {
            this.entity = jukyushaDaicho.entity;
        }

        private Object readResolve() {
            return new JukyushaDaicho(entity);
        }
    }
}
