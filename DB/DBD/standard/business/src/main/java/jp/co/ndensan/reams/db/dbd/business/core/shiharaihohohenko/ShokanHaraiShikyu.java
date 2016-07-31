/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.core.shiharaihohohenko;

import static java.util.Objects.requireNonNull;
import javax.annotation.CheckForNull;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT3034ShokanShinseiEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT3036ShokanHanteiKekkaEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT3053ShokanShukeiEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT4024ShiharaiHohoHenkoSashitomeEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.shiharaihohohenko.ShokanHaraiShikyuEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 償還払支給情報を管理するクラスです。
 *
 * @reamsid_L DBD-3620-070 xuyue
 */
public class ShokanHaraiShikyu {

    private final DbT3034ShokanShinseiEntity 償還払支給申請Entity;
    private final DbT3036ShokanHanteiKekkaEntity 償還払支給判定結果Entity;
    private final DbT3053ShokanShukeiEntity 償還払請求集計Entity;
    private final DbT4024ShiharaiHohoHenkoSashitomeEntity 支払方法変更差止Entity;

    /**
     * コンストラクタです。
     *
     * @param shokanHaraiShikyuEntity 償還払支給情報RelateEntityクラス
     */
    public ShokanHaraiShikyu(ShokanHaraiShikyuEntity shokanHaraiShikyuEntity) {
        requireNonNull(shokanHaraiShikyuEntity, UrSystemErrorMessages.値がnull.getReplacedMessage("償還払支給情報"));
        if (shokanHaraiShikyuEntity.get償還払支給申請Entity() != null) {
            this.償還払支給申請Entity = shokanHaraiShikyuEntity.get償還払支給申請Entity();
        } else {
            this.償還払支給申請Entity = new DbT3034ShokanShinseiEntity();
        }
        if (shokanHaraiShikyuEntity.get償還払支給判定結果Entity() != null) {
            this.償還払支給判定結果Entity = shokanHaraiShikyuEntity.get償還払支給判定結果Entity();
        } else {
            this.償還払支給判定結果Entity = new DbT3036ShokanHanteiKekkaEntity();
        }
        if (shokanHaraiShikyuEntity.get償還払請求集計Entity() != null) {
            this.償還払請求集計Entity = shokanHaraiShikyuEntity.get償還払請求集計Entity();
        } else {
            this.償還払請求集計Entity = new DbT3053ShokanShukeiEntity();
        }
        if (shokanHaraiShikyuEntity.get支払方法変更差止Entity() != null) {
            this.支払方法変更差止Entity = shokanHaraiShikyuEntity.get支払方法変更差止Entity();
        } else {
            this.支払方法変更差止Entity = new DbT4024ShiharaiHohoHenkoSashitomeEntity();
        }
    }

    /**
     * 被保険者番号のgetメソッドです。
     *
     * @return 被保険者番号
     */
    public HihokenshaNo get償還払支給申請_HiHokenshaNo() {
        return 償還払支給申請Entity.getHiHokenshaNo();
    }

    /**
     * サービス提供年月のgetメソッドです。
     *
     * @return サービス提供年月
     */
    public FlexibleYearMonth get償還払支給申請_ServiceTeikyoYM() {
        return 償還払支給申請Entity.getServiceTeikyoYM();
    }

    /**
     * 整理番号のgetメソッドです。
     *
     * @return 整理番号
     */
    public RString get償還払支給申請_SeiriNo() {
        return 償還払支給申請Entity.getSeiriNo();
    }

    /**
     * 証記載保険者番号のgetメソッドです。
     *
     * @return 証記載保険者番号
     */
    public ShoKisaiHokenshaNo get償還払支給申請_ShoKisaiHokenshaNo() {
        return 償還払支給申請Entity.getShoKisaiHokenshaNo();
    }

    /**
     * 受付年月日のgetメソッドです。
     *
     * @return 受付年月日
     */
    public FlexibleDate get償還払支給申請_UketsukeYMD() {
        return 償還払支給申請Entity.getUketsukeYMD();
    }

    /**
     * 申請年月日のgetメソッドです。
     *
     * @return 申請年月日
     */
    public FlexibleDate get償還払支給申請_ShinseiYMD() {
        return 償還払支給申請Entity.getShinseiYMD();
    }

    /**
     * 申請理由のgetメソッドです。
     *
     * @return 申請理由
     */
    public RString get償還払支給申請_ShinseiRiyu() {
        return 償還払支給申請Entity.getShinseiRiyu();
    }

    /**
     * 申請者区分のgetメソッドです。
     * <br/>
     * <br/>1:本人,2:代理人,3:受領委任事業者
     *
     * @return 申請者区分
     */
    public RString get償還払支給申請_ShinseishaKubun() {
        return 償還払支給申請Entity.getShinseishaKubun();
    }

    /**
     * 申請者氏名のgetメソッドです。
     *
     * @return 申請者氏名
     */
    public RString get償還払支給申請_ShinseishaNameKanji() {
        return 償還払支給申請Entity.getShinseishaNameKanji();
    }

    /**
     * 申請者氏名カナのgetメソッドです。
     *
     * @return 申請者氏名カナ
     */
    public RString get償還払支給申請_ShinseishaNameKana() {
        return 償還払支給申請Entity.getShinseishaNameKana();
    }

    /**
     * 申請者郵便番号のgetメソッドです。
     *
     * @return 申請者郵便番号
     */
    public YubinNo get償還払支給申請_ShinseishaYubinNo() {
        return 償還払支給申請Entity.getShinseishaYubinNo();
    }

    /**
     * 申請者住所のgetメソッドです。
     *
     * @return 申請者住所
     */
    public RString get償還払支給申請_ShinseishaAddress() {
        return 償還払支給申請Entity.getShinseishaAddress();
    }

    /**
     * 申請者電話番号のgetメソッドです。
     *
     * @return 申請者電話番号
     */
    public TelNo get償還払支給申請_ShinseishaTelNo() {
        return 償還払支給申請Entity.getShinseishaTelNo();
    }

    /**
     * 申請事業者番号のgetメソッドです。
     *
     * @return 申請事業者番号
     */
    public JigyoshaNo get償還払支給申請_ShinseiJigyoshaNo() {
        return 償還払支給申請Entity.getShinseiJigyoshaNo();
    }

    /**
     * 理由書作成日のgetメソッドです。
     *
     * @return 理由書作成日
     */
    public FlexibleDate get償還払支給申請_RiyushoSakuseiYMD() {
        return 償還払支給申請Entity.getRiyushoSakuseiYMD();
    }

    /**
     * 理由書作成者のgetメソッドです。
     *
     * @return 理由書作成者
     */
    public RString get償還払支給申請_RiyushoSakuseishaName() {
        return 償還払支給申請Entity.getRiyushoSakuseishaName();
    }

    /**
     * 理由書作成者カナのgetメソッドです。
     *
     * @return 理由書作成者カナ
     */
    public RString get償還払支給申請_RiyushoSakuseishaKanaName() {
        return 償還払支給申請Entity.getRiyushoSakuseishaKanaName();
    }

    /**
     * 理由書作成事業者番号のgetメソッドです。
     *
     * @return 理由書作成事業者番号
     */
    public JigyoshaNo get償還払支給申請_RiyushoSakuseiJigyoshaNo() {
        return 償還払支給申請Entity.getRiyushoSakuseiJigyoshaNo();
    }

    /**
     * 支払金額合計のgetメソッドです。
     *
     * @return 支払金額合計
     */
    public Decimal get償還払支給申請_ShiharaiKingakuTotal() {
        return 償還払支給申請Entity.getShiharaiKingakuTotal();
    }

    /**
     * 保険対象費用額のgetメソッドです。
     *
     * @return 保険対象費用額
     */
    public Decimal get償還払支給申請_HokenTaishoHiyogaku() {
        return 償還払支給申請Entity.getHokenTaishoHiyogaku();
    }

    /**
     * 保険給付額のgetメソッドです。
     *
     * @return 保険給付額
     */
    public int get償還払支給申請_HokenKyufugaku() {
        return 償還払支給申請Entity.getHokenKyufugaku();
    }

    /**
     * 利用者負担額のgetメソッドです。
     *
     * @return 利用者負担額
     */
    public int get償還払支給申請_RiyoshaFutangaku() {
        return 償還払支給申請Entity.getRiyoshaFutangaku();
    }

    /**
     * 支給申請審査区分のgetメソッドです。
     * <br/>
     * <br/>1:未審査、2:審査済み
     *
     * @return 支給申請審査区分
     */
    public RString get償還払支給申請_ShikyuShinseiShinsaKubun() {
        return 償還払支給申請Entity.getShikyuShinseiShinsaKubun();
    }

    /**
     * 審査方法区分のgetメソッドです。
     * <br/>
     * <br/>1:審査依頼,2:審査済み
     *
     * @return 審査方法区分
     */
    public RString get償還払支給申請_ShinsaHohoKubun() {
        return 償還払支給申請Entity.getShinsaHohoKubun();
    }

    /**
     * 送付区分のgetメソッドです。
     * <br/>
     * <br/>1:送付済（１回送付済になるとクリアされない）
     *
     * @return 送付区分
     */
    public RString get償還払支給申請_SofuKubun() {
        return 償還払支給申請Entity.getSofuKubun();
    }

    /**
     * 送付年月のgetメソッドです。
     *
     * @return 送付年月
     */
    public FlexibleYearMonth get償還払支給申請_SofuYM() {
        return 償還払支給申請Entity.getSofuYM();
    }

    /**
     * 国保連再送付フラグのgetメソッドです。
     * <br/>
     * <br/>True：再送付する、False：再送付しない
     *
     * @return 国保連再送付フラグ
     */
    public boolean is償還払支給申請_KokuhorenSaisofuFlag() {
        return 償還払支給申請Entity.getKokuhorenSaisofuFlag();
    }

    /**
     * 支払方法区分コードのgetメソッドです。
     *
     * @return 支払方法区分コード
     */
    public RString get償還払支給申請_ShiharaiHohoKubunCode() {
        return 償還払支給申請Entity.getShiharaiHohoKubunCode();
    }

    /**
     * 支払場所のgetメソッドです。
     *
     * @return 支払場所
     */
    public RString get償還払支給申請_ShiharaiBasho() {
        return 償還払支給申請Entity.getShiharaiBasho();
    }

    /**
     * 支払期間開始年月日のgetメソッドです。
     *
     * @return 支払期間開始年月日
     */
    public FlexibleDate get償還払支給申請_ShiharaiKaishiYMD() {
        return 償還払支給申請Entity.getShiharaiKaishiYMD();
    }

    /**
     * 支払期間終了年月日のgetメソッドです。
     *
     * @return 支払期間終了年月日
     */
    public FlexibleDate get償還払支給申請_ShiharaiShuryoYMD() {
        return 償還払支給申請Entity.getShiharaiShuryoYMD();
    }

    /**
     * 支払窓口開始時間のgetメソッドです。
     *
     * @return 支払窓口開始時間
     */
    public RString get償還払支給申請_ShiharaiKaishiTime() {
        return 償還払支給申請Entity.getShiharaiKaishiTime();
    }

    /**
     * 支払窓口終了時間のgetメソッドです。
     *
     * @return 支払窓口終了時間
     */
    public RString get償還払支給申請_ShiharaiShuryoTime() {
        return 償還払支給申請Entity.getShiharaiShuryoTime();
    }

    /**
     * 口座IDのgetメソッドです。
     *
     * @return 口座ID
     */
    public long get償還払支給申請_KozaID() {
        return 償還払支給申請Entity.getKozaID();
    }

    /**
     * 受領委任契約番号のgetメソッドです。
     *
     * @return 受領委任契約番号
     */
    public RString get償還払支給申請_JuryoininKeiyakuNo() {
        return 償還払支給申請Entity.getJuryoininKeiyakuNo();
    }

    /**
     * 住宅所有者のgetメソッドです。
     *
     * @return 住宅所有者
     */
    public RString get償還払支給申請_JutakuShoyusha() {
        return 償還払支給申請Entity.getJutakuShoyusha();
    }

    /**
     * 被保険者との関係のgetメソッドです。
     *
     * @return 被保険者との関係
     */
    public RString get償還払支給申請_HihokenshaKankei() {
        return 償還払支給申請Entity.getHihokenshaKankei();
    }

    /**
     * 要介護状態３段階変更のgetメソッドです。
     * <br/>
     * <br/>True：変更する、False：変更無し
     *
     * @return 要介護状態３段階変更
     */
    public boolean is償還払支給申請_Yokaigo3DankaiHenko() {
        return 償還払支給申請Entity.getYokaigo3DankaiHenko();
    }

    /**
     * 住宅住所変更のgetメソッドです。
     * <br/>
     * <br/>True：変更する、False：変更無し
     *
     * @return 住宅住所変更
     */
    public boolean is償還払支給申請_JutakuJushoHenko() {
        return 償還払支給申請Entity.getJutakuJushoHenko();
    }

    /**
     * 審査年月日のgetメソッドです。
     *
     * @return 審査年月日
     */
    public FlexibleDate get償還払支給申請_ShinsaYMD() {
        return 償還払支給申請Entity.getShinsaYMD();
    }

    /**
     * 審査結果のgetメソッドです。
     *
     * @return 審査結果
     */
    public RString get償還払支給申請_ShinsaKekka() {
        return 償還払支給申請Entity.getShinsaKekka();
    }

    /**
     * 事前申請サービス提供年月のgetメソッドです。
     *
     * @return 事前申請サービス提供年月
     */
    public FlexibleYearMonth get償還払支給申請_JizenServiceTeikyoYM() {
        return 償還払支給申請Entity.getJizenServiceTeikyoYM();
    }

    /**
     * 事前申請整理番号のgetメソッドです。
     *
     * @return 事前申請整理番号
     */
    public RString get償還払支給申請_JizenSeiriNo() {
        return 償還払支給申請Entity.getJizenSeiriNo();
    }

    /**
     * 住宅改修申請区分のgetメソッドです。
     * <br/>
     * <br/>(DBC)Enum住宅改修申請区分
     *
     * @return 住宅改修申請区分
     */
    public RString get償還払支給申請_KaishuShinseiKubun() {
        return 償還払支給申請Entity.getKaishuShinseiKubun();
    }

    /**
     * 住宅改修申請取消事由コードのgetメソッドです。
     * <br/>
     * <br/>(DBC)コードマスタ:0028
     *
     * @return 住宅改修申請取消事由コード
     */
    public RString get償還払支給申請_KaishuShinseiTorikeshijiyuCode() {
        return 償還払支給申請Entity.getKaishuShinseiTorikeshijiyuCode();
    }

    /**
     * 領収年月日のgetメソッドです。
     *
     * @return 領収年月日
     */
    public FlexibleDate get償還払支給申請_RyoshuYMD() {
        return 償還払支給申請Entity.getRyoshuYMD();
    }

    /**
     * 被保険者番号のgetメソッドです。
     *
     * @return 被保険者番号
     */
    public HihokenshaNo get償還払支給判定結果_HiHokenshaNo() {
        return 償還払支給判定結果Entity.getHiHokenshaNo();
    }

    /**
     * サービス提供年月のgetメソッドです。
     *
     * @return サービス提供年月
     */
    public FlexibleYearMonth get償還払支給判定結果_ServiceTeikyoYM() {
        return 償還払支給判定結果Entity.getServiceTeikyoYM();
    }

    /**
     * 整理番号のgetメソッドです。
     *
     * @return 整理番号
     */
    public RString get償還払支給判定結果_SeiriNo() {
        return 償還払支給判定結果Entity.getSeiriNo();
    }

    /**
     * 証記載保険者番号のgetメソッドです。
     *
     * @return 証記載保険者番号
     */
    public ShoKisaiHokenshaNo get償還払支給判定結果_ShoKisaiHokenshaNo() {
        return 償還払支給判定結果Entity.getShoKisaiHokenshaNo();
    }

    /**
     * 決定年月日のgetメソッドです。
     *
     * @return 決定年月日
     */
    public FlexibleDate get償還払支給判定結果_KetteiYMD() {
        return 償還払支給判定結果Entity.getKetteiYMD();
    }

    /**
     * 支給・不支給決定区分のgetメソッドです。
     *
     * @return 支給・不支給決定区分
     */
    public RString get償還払支給判定結果_ShikyuHushikyuKetteiKubun() {
        return 償還払支給判定結果Entity.getShikyuHushikyuKetteiKubun();
    }

    /**
     * 支払金額のgetメソッドです。
     *
     * @return 支払金額
     */
    public Decimal get償還払支給判定結果_ShiharaiKingaku() {
        return 償還払支給判定結果Entity.getShiharaiKingaku();
    }

    /**
     * 支払金額内訳・利用者分のgetメソッドです。
     *
     * @return 支払金額内訳・利用者分
     */
    public Decimal get償還払支給判定結果_ShiharaiKingakuUchiwakeRiyoshabun() {
        return 償還払支給判定結果Entity.getShiharaiKingakuUchiwakeRiyoshabun();
    }

    /**
     * 決定一覧取込年月のgetメソッドです。
     *
     * @return 決定一覧取込年月
     */
    public FlexibleYearMonth get償還払支給判定結果_KetteiIchiranTorikomiYM() {
        return 償還払支給判定結果Entity.getKetteiIchiranTorikomiYM();
    }

    /**
     * 前回支払金額のgetメソッドです。
     *
     * @return 前回支払金額
     */
    public Decimal get償還払支給判定結果_ZenkaiShiharaiKingaku() {
        return 償還払支給判定結果Entity.getZenkaiShiharaiKingaku();
    }

    /**
     * 差額金額合計のgetメソッドです。
     *
     * @return 差額金額合計
     */
    public Decimal get償還払支給判定結果_SagakuKingakuGokei() {
        return 償還払支給判定結果Entity.getSagakuKingakuGokei();
    }

    /**
     * 決定通知書作成年月日のgetメソッドです。
     *
     * @return 決定通知書作成年月日
     */
    public FlexibleDate get償還払支給判定結果_KetteiTsuchishoSakuseiYMD() {
        return 償還払支給判定結果Entity.getKetteiTsuchishoSakuseiYMD();
    }

    /**
     * 決定通知Noのgetメソッドです。
     *
     * @return 決定通知No
     */
    public RString get償還払支給判定結果_KetteiTsuchiNo() {
        return 償還払支給判定結果Entity.getKetteiTsuchiNo();
    }

    /**
     * 振込明細書作成年月日のgetメソッドです。
     *
     * @return 振込明細書作成年月日
     */
    public FlexibleDate get償還払支給判定結果_FurikomiMeisaishoSakuseiYMD() {
        return 償還払支給判定結果Entity.getFurikomiMeisaishoSakuseiYMD();
    }

    /**
     * 決定通知リアル発行区分のgetメソッドです。
     * <br/>
     * <br/>0:未発行、1:発行済
     *
     * @return 決定通知リアル発行区分
     */
    public RString get償還払支給判定結果_KetteiTsuchiHakkoKubun() {
        return 償還払支給判定結果Entity.getKetteiTsuchiHakkoKubun();
    }

    /**
     * 被保険者番号のgetメソッドです。
     *
     * @return 被保険者番号
     */
    public HihokenshaNo get償還払請求集計_HiHokenshaNo() {
        return 償還払請求集計Entity.getHiHokenshaNo();
    }

    /**
     * サービス提供年月のgetメソッドです。
     *
     * @return サービス提供年月
     */
    public FlexibleYearMonth get償還払請求集計_ServiceTeikyoYM() {
        return 償還払請求集計Entity.getServiceTeikyoYM();
    }

    /**
     * 整理番号のgetメソッドです。
     *
     * @return 整理番号
     */
    public RString get償還払請求集計_SeiriNo() {
        return 償還払請求集計Entity.getSeiriNo();
    }

    /**
     * 事業者番号のgetメソッドです。
     *
     * @return 事業者番号
     */
    public JigyoshaNo get償還払請求集計_JigyoshaNo() {
        return 償還払請求集計Entity.getJigyoshaNo();
    }

    /**
     * 様式番号のgetメソッドです。
     *
     * @return 様式番号
     */
    public RString get償還払請求集計_YoshikiNo() {
        return 償還払請求集計Entity.getYoshikiNo();
    }

    /**
     * 明細番号のgetメソッドです。
     * <br/>
     * <br/>複数レコード対応のため
     *
     * @return 明細番号
     */
    public RString get償還払請求集計_MeisaiNo() {
        return 償還払請求集計Entity.getMeisaiNo();
    }

    /**
     * 連番のgetメソッドです。
     *
     * @return 連番
     */
    public RString get償還払請求集計_Renban() {
        return 償還払請求集計Entity.getRenban();
    }

    /**
     * サービス種類コードのgetメソッドです。
     *
     * @return サービス種類コード
     */
    public ServiceShuruiCode get償還払請求集計_ServiceShuruiCode() {
        return 償還払請求集計Entity.getServiceShuruiCode();
    }

    /**
     * サービス実日数のgetメソッドです。
     *
     * @return サービス実日数
     */
    public int get償還払請求集計_ServiceJitsunissu() {
        return 償還払請求集計Entity.getServiceJitsunissu();
    }

    /**
     * 計画単位数のgetメソッドです。
     *
     * @return 計画単位数
     */
    public int get償還払請求集計_PlanTanisu() {
        return 償還払請求集計Entity.getPlanTanisu();
    }

    /**
     * 限度額管理対象単位数のgetメソッドです。
     *
     * @return 限度額管理対象単位数
     */
    public int get償還払請求集計_GendogakuKanriTaishoTanisu() {
        return 償還払請求集計Entity.getGendogakuKanriTaishoTanisu();
    }

    /**
     * 限度額管理対象外単位数のgetメソッドです。
     *
     * @return 限度額管理対象外単位数
     */
    public int get償還払請求集計_GendogakuKanriTaishogaiTanisu() {
        return 償還払請求集計Entity.getGendogakuKanriTaishogaiTanisu();
    }

    /**
     * 短期入所計画日数のgetメソッドです。
     *
     * @return 短期入所計画日数
     */
    public int get償還払請求集計_TankiNyushoPlanNissu() {
        return 償還払請求集計Entity.getTankiNyushoPlanNissu();
    }

    /**
     * 短期入所実日数のgetメソッドです。
     *
     * @return 短期入所実日数
     */
    public int get償還払請求集計_TankiNyushoJitsunissu() {
        return 償還払請求集計Entity.getTankiNyushoJitsunissu();
    }

    /**
     * 単位数合計のgetメソッドです。
     *
     * @return 単位数合計
     */
    public int get償還払請求集計_TanisuTotal() {
        return 償還払請求集計Entity.getTanisuTotal();
    }

    /**
     * 単位数単価のgetメソッドです。
     *
     * @return 単位数単価
     */
    public Decimal get償還払請求集計_TanisuTanka() {
        return 償還払請求集計Entity.getTanisuTanka();
    }

    /**
     * 請求額のgetメソッドです。
     *
     * @return 請求額
     */
    public Decimal get償還払請求集計_Seikyugaku() {
        return 償還払請求集計Entity.getSeikyugaku();
    }

    /**
     * 利用者負担額のgetメソッドです。
     *
     * @return 利用者負担額
     */
    public int get償還払請求集計_RiyoshaFutangaku() {
        return 償還払請求集計Entity.getRiyoshaFutangaku();
    }

    /**
     * 出来高医療費単位数合計のgetメソッドです。
     *
     * @return 出来高医療費単位数合計
     */
    public int get償還払請求集計_DekidakaIryohiTanisuTotal() {
        return 償還払請求集計Entity.getDekidakaIryohiTanisuTotal();
    }

    /**
     * 出来高医療費請求額のgetメソッドです。
     *
     * @return 出来高医療費請求額
     */
    public Decimal get償還払請求集計_DekidakaIryohiSeikyugaku() {
        return 償還払請求集計Entity.getDekidakaIryohiSeikyugaku();
    }

    /**
     * 出来高医療費利用者負担額のgetメソッドです。
     *
     * @return 出来高医療費利用者負担額
     */
    public Decimal get償還払請求集計_DekidakaIryohiRiyoshaFutangaku() {
        return 償還払請求集計Entity.getDekidakaIryohiRiyoshaFutangaku();
    }

    /**
     * 審査方法区分コードのgetメソッドです。
     *
     * @return 審査方法区分コード
     */
    public RString get償還払請求集計_ShinsaHohoKubunCode() {
        return 償還払請求集計Entity.getShinsaHohoKubunCode();
    }

    /**
     * 審査年月のgetメソッドです。
     *
     * @return 審査年月
     */
    public FlexibleYearMonth get償還払請求集計_ShinsaYM() {
        return 償還払請求集計Entity.getShinsaYM();
    }

    /**
     * 支給区分コードのgetメソッドです。
     *
     * @return 支給区分コード
     */
    public RString get償還払請求集計_ShikyuKubunCode() {
        return 償還払請求集計Entity.getShikyuKubunCode();
    }

    /**
     * 点数／金額のgetメソッドです。
     *
     * @return 点数／金額
     */
    public int get償還払請求集計_TensuKingaku() {
        return 償還払請求集計Entity.getTensuKingaku();
    }

    /**
     * 支払金額のgetメソッドです。
     *
     * @return 支払金額
     */
    public int get償還払請求集計_ShikyuKingaku() {
        return 償還払請求集計Entity.getShikyuKingaku();
    }

    /**
     * 増減点のgetメソッドです。
     *
     * @return 増減点
     */
    public int get償還払請求集計_Zougenten() {
        return 償還払請求集計Entity.getZougenten();
    }

    /**
     * 請求額差額金額のgetメソッドです。
     *
     * @return 請求額差額金額
     */
    public int get償還払請求集計_SeikyugakuSagakuKingaku() {
        return 償還払請求集計Entity.getSeikyugakuSagakuKingaku();
    }

    /**
     * 出来高請求額差額金額のgetメソッドです。
     *
     * @return 出来高請求額差額金額
     */
    public int get償還払請求集計_DekidakaSeikyugakuSagaku() {
        return 償還払請求集計Entity.getDekidakaSeikyugakuSagaku();
    }

    /**
     * 増減理由等のgetメソッドです。
     *
     * @return 増減理由等
     */
    public RString get償還払請求集計_ZougenRiyu() {
        return 償還払請求集計Entity.getZougenRiyu();
    }

    /**
     * 不支給理由等のgetメソッドです。
     *
     * @return 不支給理由等
     */
    public RString get償還払請求集計_HushikyuRiyu() {
        return 償還払請求集計Entity.getHushikyuRiyu();
    }

    /**
     * 購入・改修履歴等のgetメソッドです。
     *
     * @return 購入・改修履歴等
     */
    public RString get償還払請求集計_KounyuKaishuRireki() {
        return 償還払請求集計Entity.getKounyuKaishuRireki();
    }

    /**
     * 証記載保険者番号のgetメソッドです。
     *
     * @return 証記載保険者番号
     */
    public ShoKisaiHokenshaNo get支払方法変更差止_ShoKisaiHokenshaNo() {
        return 支払方法変更差止Entity.getShoKisaiHokenshaNo();
    }

    /**
     * 被保険者番号のgetメソッドです。
     *
     * @return 被保険者番号
     */
    public HihokenshaNo get支払方法変更差止_HihokenshaNo() {
        return 支払方法変更差止Entity.getHihokenshaNo();
    }

    /**
     * 管理区分のgetメソッドです。
     * <br/>
     * <br/>1：２号差止
     *
     * <br/>2：１号償還払い化
     *
     * <br/>3：１号給付額減額
     *
     * @return 管理区分
     */
    public RString get支払方法変更差止_KanriKubun() {
        return 支払方法変更差止Entity.getKanriKubun();
    }

    /**
     * 履歴番号のgetメソッドです。
     *
     * @return 履歴番号
     */
    public int get支払方法変更差止_RirekiNo() {
        return 支払方法変更差止Entity.getRirekiNo();
    }

    /**
     * 情報分類区分のgetメソッドです。
     * <br/>
     * <br/>1：差止情報、2：保険料控除情報
     *
     * @return 情報分類区分
     */
    public RString get支払方法変更差止_JohoBunruiKubun() {
        return 支払方法変更差止Entity.getJohoBunruiKubun();
    }

    /**
     * 連番のgetメソッドです。
     *
     * @return 連番
     */
    public int get支払方法変更差止_RenNo() {
        return 支払方法変更差止Entity.getRenNo();
    }

    /**
     * 差止控除状態区分のgetメソッドです。
     * <br/>
     * <br/>01：登録,99：解除
     *
     * @return 差止控除状態区分
     */
    @CheckForNull
    public RString get支払方法変更差止_SashitomeKojoJotaiKubun() {
        return 支払方法変更差止Entity.getSashitomeKojoJotaiKubun();
    }

    /**
     * 差止決定年月日のgetメソッドです。
     *
     * @return 差止決定年月日
     */
    @CheckForNull
    public FlexibleDate get支払方法変更差止_Sashitome_KetteiYMD() {
        return 支払方法変更差止Entity.getSashitome_KetteiYMD();
    }

    /**
     * 差止通知書発行年月日のgetメソッドです。
     *
     * @return 差止通知書発行年月日
     */
    @CheckForNull
    public FlexibleDate get支払方法変更差止_Sashitome_TsuchiHakkoYMD() {
        return 支払方法変更差止Entity.getSashitome_TsuchiHakkoYMD();
    }

    /**
     * 差止通知書再発行フラグのgetメソッドです。
     * <br/>
     * <br/>1：再発行対象,0：再発行対象外
     *
     * @return 差止通知書再発行フラグ
     */
    @CheckForNull
    public boolean is支払方法変更差止_Sashitome_TsuchiSaiHakkoFlag() {
        return 支払方法変更差止Entity.getSashitome_TsuchiSaiHakkoFlag();
    }

    /**
     * 差止控除番号のgetメソッドです。
     *
     * @return 差止控除番号
     */
    @CheckForNull
    public RString get支払方法変更差止_SashitomeKojoNo() {
        return 支払方法変更差止Entity.getSashitomeKojoNo();
    }

    /**
     * 差止納付期限のgetメソッドです。
     *
     * @return 差止納付期限
     */
    @CheckForNull
    public FlexibleDate get支払方法変更差止_Sashitome_NofuYMD() {
        return 支払方法変更差止Entity.getSashitome_NofuYMD();
    }

    /**
     * 差止解除年月日のgetメソッドです。
     *
     * @return 差止解除年月日
     */
    @CheckForNull
    public FlexibleDate get支払方法変更差止_Sashitome_KaijoYMD() {
        return 支払方法変更差止Entity.getSashitome_KaijoYMD();
    }

    /**
     * 差止サービス提供年月のgetメソッドです。
     *
     * @return 差止サービス提供年月
     */
    @CheckForNull
    public FlexibleYearMonth get支払方法変更差止_Sashitome_ServiceTeikyoYM() {
        return 支払方法変更差止Entity.getSashitome_ServiceTeikyoYM();
    }

    /**
     * 差止償還整理番号のgetメソッドです。
     *
     * @return 差止償還整理番号
     */
    @CheckForNull
    public RString get支払方法変更差止_Sashitome_ShokanSeiriNo() {
        return 支払方法変更差止Entity.getSashitome_ShokanSeiriNo();
    }

    /**
     * 控除決定年月日のgetメソッドです。
     *
     * @return 控除決定年月日
     */
    @CheckForNull
    public FlexibleDate get支払方法変更差止_Kojo_KetteiYMD() {
        return 支払方法変更差止Entity.getKojo_KetteiYMD();
    }

    /**
     * 控除通知書発行年月日のgetメソッドです。
     *
     * @return 控除通知書発行年月日
     */
    @CheckForNull
    public FlexibleDate get支払方法変更差止_Kojo_TsuchiHakkoYMD() {
        return 支払方法変更差止Entity.getKojo_TsuchiHakkoYMD();
    }

    /**
     * 控除通知書再発行フラグのgetメソッドです。
     * <br/>
     * <br/>1：再発行対象,0：再発行対象外
     *
     * @return 控除通知書再発行フラグ
     */
    @CheckForNull
    public boolean is支払方法変更差止_Kojo_TsuchiSaiHakkoFlag() {
        return 支払方法変更差止Entity.getKojo_TsuchiSaiHakkoFlag();
    }

    /**
     * 控除被保険者証提出期限のgetメソッドです。
     *
     * @return 控除被保険者証提出期限
     */
    @CheckForNull
    public FlexibleDate get支払方法変更差止_Kojo_ShoTeishutsuYMD() {
        return 支払方法変更差止Entity.getKojo_ShoTeishutsuYMD();
    }

    /**
     * 論理削除フラグのgetメソッドです。
     *
     * @return 論理削除フラグ
     */
    @CheckForNull
    public boolean is支払方法変更差止_LogicalDeletedFlag() {
        return 支払方法変更差止Entity.getLogicalDeletedFlag();
    }

}
