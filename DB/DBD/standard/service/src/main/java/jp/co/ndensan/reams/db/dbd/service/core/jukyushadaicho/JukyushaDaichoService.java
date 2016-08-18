/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.service.core.jukyushadaicho;

import jp.co.ndensan.reams.db.dbd.business.core.basic.JukyushaDaicho;
import jp.co.ndensan.reams.db.dbd.definition.mybatisprm.jukyushajaicho.JukyushaDaichoParameter;
import jp.co.ndensan.reams.db.dbd.persistence.db.mapper.relate.jukyushadaicho.IJukyushaDaichoMapper;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4001JukyushaDaichoEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT4001JukyushaDaichoDac;
import jp.co.ndensan.reams.db.dbz.service.core.MapperProvider;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 受給者台帳情報を取得とDB出力(受給者台帳)。
 *
 * @reamsid_L DBD-1440-010 liuyl
 */
public class JukyushaDaichoService {

    private final MapperProvider mapperProvider;
    private final DbT4001JukyushaDaichoDac dac;

    /**
     * コンストラクタです。
     */
    JukyushaDaichoService() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
        this.dac = InstanceProvider.create(DbT4001JukyushaDaichoDac.class);
    }

    /**
     * JukyushaDaichoServiceのIntanceを作成します。
     *
     * @return JukyushaDaichoService
     */
    public static JukyushaDaichoService createJukyushaDaichoService() {
        return InstanceProvider.create(JukyushaDaichoService.class);
    }

    /**
     * 受給者台帳情報を取得。
     *
     * @param parameter JukyushaDaichoParameter
     * @return JukyushaDaicho
     */
    @Transaction
    public JukyushaDaicho get受給者台帳(JukyushaDaichoParameter parameter) {
        IJukyushaDaichoMapper mapper = mapperProvider.create(IJukyushaDaichoMapper.class);
        DbT4001JukyushaDaichoEntity entity = mapper.get受給者台帳(parameter);
        if (entity == null) {
            return null;
        } else {
            return new JukyushaDaicho(entity);
        }
    }

    /**
     * DB出力(受給者台帳)。
     *
     * @param daicho JukyushaDaicho
     * @param riYu RString
     * @param 区分コード RString
     * @param fromDate FlexibleDate
     * @param toDate FlexibleDate
     * @param 作成日 FlexibleDate
     */
    @Transaction
    public void insert(JukyushaDaicho daicho, RString riYu, RString 区分コード, FlexibleDate fromDate, FlexibleDate toDate, FlexibleDate 作成日) {
        DbT4001JukyushaDaichoEntity entity = new DbT4001JukyushaDaichoEntity();
        entity.setShichosonCode(daicho.get市町村コード());
        entity.setHihokenshaNo(daicho.get被保険者番号());
        Long 履歴番号 = Long.parseLong(daicho.get履歴番号().toString()) + 1;
        entity.setRirekiNo(new RString(String.format("%04d", 履歴番号)));
        entity.setEdaban(daicho.get枝番());
        entity.setShinseishoKanriNo(daicho.get申請書管理番号());
        entity.setShinseiJokyoKubun(daicho.get申請状況区分());
        entity.setShishoCode(daicho.get支所コード());
        entity.setChokkinFlag(daicho.is直近フラグ());
        entity.setShikibetsuCode(daicho.get識別コード());
        entity.setJukyuShinseiJiyu(daicho.get受給申請事由());
        entity.setShinseiRiyu(daicho.get申請理由());
        entity.setShinseishaKankeiCode(daicho.get届出者_申請者関係コード());
        entity.setHomninKankei(daicho.get届出者_本人との関係());
        entity.setJukyuShinseiYMD(daicho.get受給申請年月日());
        entity.setNigoTokuteiShippeiCode(daicho.get２号特定疾病コード());
        entity.setShinsakaiIraiYMD(daicho.get審査会依頼年月日());
        entity.setYokaigoJotaiKubunCode(new Code(区分コード));
        entity.setNinteiYukoKikanKaishiYMD(fromDate);
        entity.setNinteiYukoKikanShuryoYMD(toDate);
        entity.setNinteiYMD(daicho.get認定年月日());
        entity.setMinashiCode(daicho.getみなし要介護区分コード());
        entity.setShiteiServiceShurui01(daicho.get指定サービス種類01());
        entity.setShiteiServiceShurui02(daicho.get指定サービス種類02());
        entity.setShiteiServiceShurui03(daicho.get指定サービス種類03());
        entity.setShiteiServiceShurui04(daicho.get指定サービス種類04());
        entity.setShiteiServiceShurui05(daicho.get指定サービス種類05());
        entity.setShiteiServiceShurui06(daicho.get指定サービス種類06());
        entity.setShiteiServiceShurui07(daicho.get指定サービス種類07());
        entity.setShiteiServiceShurui08(daicho.get指定サービス種類08());
        entity.setShiteiServiceShurui09(daicho.get指定サービス種類09());
        entity.setShiteiServiceShurui10(daicho.get指定サービス種類10());
        entity.setShiteiServiceShurui11(daicho.get指定サービス種類11());
        entity.setShiteiServiceShurui12(daicho.get指定サービス種類12());
        entity.setShiteiServiceShurui13(daicho.get指定サービス種類13());
        entity.setShiteiServiceShurui14(daicho.get指定サービス種類14());
        entity.setShiteiServiceShurui15(daicho.get指定サービス種類15());
        entity.setShiteiServiceShurui16(daicho.get指定サービス種類16());
        entity.setShiteiServiceShurui17(daicho.get指定サービス種類17());
        entity.setShiteiServiceShurui18(daicho.get指定サービス種類18());
        entity.setShiteiServiceShurui19(daicho.get指定サービス種類19());
        entity.setShiteiServiceShurui20(daicho.get指定サービス種類20());
        entity.setShiteiServiceShurui21(daicho.get指定サービス種類21());
        entity.setShiteiServiceShurui22(daicho.get指定サービス種類22());
        entity.setShiteiServiceShurui23(daicho.get指定サービス種類23());
        entity.setShiteiServiceShurui24(daicho.get指定サービス種類24());
        entity.setShiteiServiceShurui25(daicho.get指定サービス種類25());
        entity.setShiteiServiceShurui26(daicho.get指定サービス種類26());
        entity.setShiteiServiceShurui27(daicho.get指定サービス種類27());
        entity.setShiteiServiceShurui28(daicho.get指定サービス種類28());
        entity.setShiteiServiceShurui29(daicho.get指定サービス種類29());
        entity.setShiteiServiceShurui30(daicho.get指定サービス種類30());
        entity.setSoshitsuYMD(daicho.get喪失年月日());
        entity.setChokkinIdoYMD(daicho.get直近異動年月日());
        entity.setChokkinIdoJiyuCode(daicho.get直近異動事由コード());
        entity.setYukoMukoKubun(daicho.get有効無効区分());
        entity.setDataKubun(daicho.getデータ区分());
        entity.setRemban(daicho.get同一連番());
        entity.setIdoRiyu(riYu);
        entity.setShinseishoKubun(daicho.get申請書区分());
        entity.setSakujoJiyuCode(daicho.get削除事由コード());
        entity.setYoshienshaNinteiShinseiFlag(daicho.is要支援者認定申請区分());
        entity.setShikyuGendoTanisu(daicho.get支給限度単位数());
        entity.setShikyuGendoKaishiYMD(daicho.get支給限度有効開始年月日());
        entity.setShikyuGendoShuryoYMD(daicho.get支給限度有効終了年月日());
        entity.setTankiSikyuGendoNissu(daicho.get短期入所支給限度日数());
        entity.setTankiShikyuGendoKaishiYMD(daicho.get短期入所支給限度開始年月日());
        entity.setTankiShikyuGendoShuryoYMD(daicho.get短期入所支給限度終了年月日());
        entity.setToshoNinteiYukoKaishiYMD(daicho.get当初認定有効開始年月日());
        entity.setToshoNinteiYukoShuryoYMD(daicho.get当初認定有効終了年月日());
        entity.setJukyuShikakuShomeishoHakkoYMD1(daicho.get受給資格証明書発行年月日１());
        entity.setJukyuShikakuShomeishoHakkoYMD2(daicho.get受給資格証明書発行年月日２());
        entity.setShindanMeireishoHakkoYMD(daicho.get診断命令書発行年月日());
        entity.setNigoShinseiJuriTsuchishoHakkoYMD(daicho.get２号申請受理通知書発行年月日());
        entity.setNinteiKekkaTsuchishoHakkoYMD(daicho.get認定結果通知書発行年月日());
        entity.setKubunHenkoTsuchishoHakkoYMD(daicho.get区分変更通知書発行年月日());
        entity.setServiceHenkoTsuchishoHakkoYMD(daicho.getサービス変更通知書発行年月日());
        entity.setNinteiKyakkaTsuchishoHakkoYMD(daicho.get認定却下通知書発行年月日());
        entity.setNinteiTorikeshiTsuchishoHakkoYMD(作成日);
        entity.setShikakuShutokuMaeShinseiFlag(daicho.is資格取得前申請フラグ());
        entity.setKyuSochishaFlag(daicho.is旧措置者フラグ());
        entity.setLogicalDeletedFlag(daicho.is論理削除フラグ());
        dac.save(entity);

    }
}
