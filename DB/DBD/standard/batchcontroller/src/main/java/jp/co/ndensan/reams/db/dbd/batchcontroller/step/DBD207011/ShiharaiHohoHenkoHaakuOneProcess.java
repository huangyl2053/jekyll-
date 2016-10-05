/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.batchcontroller.step.DBD207011;

import jp.co.ndensan.reams.db.dbd.definition.processprm.dbd207010.ShiharaiHohoHenkoHaakuOneProcessParameter;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd207010.ShiharaiHohoHenkoHaakuOneEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd207010.temptable.ShiharaiHohoHenkoTempTableEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd207010.temptable.ShunoStatusTempTableEntity;
import jp.co.ndensan.reams.db.dbz.definition.core.taino.MinoKannoKubun;
import jp.co.ndensan.reams.ua.uax.business.core.psm.UaFt200FindShikibetsuTaishoFunction;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.ShikibetsuTaishoFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.kojin.IKojin;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoGyomuHanteiKeyFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.KensakuYusenKubun;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.psm.DataShutokuKubun;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriterBuilders;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * DBDMN32001_2_支払方法変更滞納者把握リスト作成_バッチプロセス１クラスです．
 *
 * @reamsid_L DBD-3650-050 x_lilh
 */
public class ShiharaiHohoHenkoHaakuOneProcess extends BatchProcessBase<ShiharaiHohoHenkoHaakuOneEntity> {

    private static final RString 申請中 = new RString("申請中");

    private static final RString 未来納期 = new RString("未来納期");
    private static final RString 完納_未納区分_0円 = new RString("0円");
    private static final RString 完納 = new RString("完納");
    private static final RString 過納 = new RString("過納");
    private static final RString 未納あり = new RString("未納あり");

    private static final RString 時効到来 = new RString("時効到来");
    private static final RString 時効未到来 = new RString("時効未到来");

//    private static final RString 時効成立 = new RString("時効成立");
//    private static final RString 納期限未到来 = new RString("納期限未到来");
//    private static final RString 滞納期 = new RString("滞納期");
//    private boolean is時効起算日;
//    private boolean is督促状発行年月日;
//    private boolean is納期限の翌日;
//    private boolean is収入年月日;
    private FlexibleDate 時効成立日;
//    private RString 滞納区分;
//    private RString 時効起算事由;
    private ShiharaiHohoHenkoHaakuOneProcessParameter processParamter;

    private static final RString MYBATIS_SELECT_ID = new RString(
            "jp.co.ndensan.reams.db.dbd.persistence.db.mapper.relate.shiharaihohohenkohaakuichiran."
            + "IShiharaiHohoHenkoHakuListMainMapper.find支払方法変更情報");

    @BatchWriter
    private BatchEntityCreatedTempTableWriter tmpTableWriter;

    @BatchWriter
    private BatchEntityCreatedTempTableWriter shiharaiHohoWriter;

    @Override
    protected IBatchReader createReader() {
        ShikibetsuTaishoSearchKeyBuilder key = new ShikibetsuTaishoSearchKeyBuilder(
                ShikibetsuTaishoGyomuHanteiKeyFactory.createInstance(GyomuCode.DB介護保険, KensakuYusenKubun.住登外優先), true);
        key.setデータ取得区分(DataShutokuKubun.直近レコード);
        UaFt200FindShikibetsuTaishoFunction uaFt200Psm = new UaFt200FindShikibetsuTaishoFunction(key.getPSM検索キー());
        RString psmShikibetsuTaisho = new RString(uaFt200Psm.getParameterMap().get("psmShikibetsuTaisho").toString());
        return new BatchDbReader(MYBATIS_SELECT_ID, processParamter.toShiharaiHohoHenkoHakuListMainMybatisParameter(psmShikibetsuTaisho));
    }

    @Override
    protected void createWriter() {
        shiharaiHohoWriter = BatchEntityCreatedTempTableWriterBuilders.createBuilder(ShiharaiHohoHenkoTempTableEntity.class)
                .tempTableName(ShiharaiHohoHenkoTempTableEntity.TABLE_NAME).build();

        tmpTableWriter = BatchEntityCreatedTempTableWriterBuilders.createBuilder(ShunoStatusTempTableEntity.class)
                .tempTableName(ShunoStatusTempTableEntity.TABLE_NAME).build();
    }

    @Override
    protected void process(ShiharaiHohoHenkoHaakuOneEntity t) {
        shiharaiHohoWriter.insert(create支払方法変更情報一時テーブルEntity(t));

        ShunoStatusTempTableEntity tempTableEntity = create収納状況一時テーブル(t);
        tmpTableWriter.insert(tempTableEntity);
    }

    private ShiharaiHohoHenkoTempTableEntity create支払方法変更情報一時テーブルEntity(ShiharaiHohoHenkoHaakuOneEntity t) {
        ShiharaiHohoHenkoTempTableEntity data = new ShiharaiHohoHenkoTempTableEntity();
        set資格情報について(data, t);
        set認定情報(data, t);
        set賦課について(data, t);
        set介護期別(data, t);
        set調定共通_介護継承について(data, t);
        set時効について(data, t);
        set収入について(data, t);
        set督促状発行履歴(data, t);
        set宛名について(data, t);

        data.setSeikatsuHogoJukyushaShikibetsuCode(edit生保(t.get資格情報_識別コード()));
        data.setReqProcess(edit認定情報の申請中(t.get認定情報_認定年月日()));
        return data;
    }

    private ShunoStatusTempTableEntity create収納状況一時テーブル(ShiharaiHohoHenkoHaakuOneEntity t) {
        ShunoStatusTempTableEntity data = new ShunoStatusTempTableEntity();

        data.setChoteiNendo(t.get介護期別_調定年度());
        data.setFukaNendo(t.get賦課_賦課年度());
        data.setTsuchishoNo(t.get賦課_通知書番号());
        data.setKi(t.get介護期別_期());
        // TODO 調定共通（介護継承）.被保険者番号
        data.setHihokenshaNo(t.get賦課_被保険者番号());
        data.setShikibetsuCode(t.get賦課_識別コード());
        data.setNokigenYMD(t.get調定共通_介護継承_納期限());
        data.setChoteigaku(t.get調定共通_介護継承_調定額());

        // TODO
        data.setShunyuYMD(時効成立日);
        data.setShunyuGaku(Decimal.ZERO);

        data.setDunningHakkoYMD(t.get督促状発行履歴_督促状発行年月日());
        data.setJikoKisambiYMD(FlexibleDate.EMPTY);

        FlexibleDate 調定共通_介護継承_納期限 = FlexibleDate.EMPTY;
        if (t.get調定共通_介護継承_納期限() != null) {
            調定共通_介護継承_納期限 = new FlexibleDate(t.get調定共通_介護継承_納期限().toDateString());
        }
        data.setFinshNoKubun(edit完納_未納区分(processParamter.get基準日(),
                調定共通_介護継承_納期限, t.get調定共通_介護継承_調定額(), Decimal.ZERO));

        data.setMiNoGaku(Decimal.ONE);
        data.setJikoKisambiJiyu(申請中);

        data.setJikoKubun(edit時効区分(data.getFinshNoKubun(), data.getJikoKisambiYMD(), processParamter.get基準日()));
        return data;
    }

    private void set資格情報について(ShiharaiHohoHenkoTempTableEntity data, ShiharaiHohoHenkoHaakuOneEntity t) {
        data.setTaisyo_hihokenshaNo(t.get対象者情報_被保険者番号());
        data.setDbT1001_hihokenshaNo(t.get資格情報_資格情報険者番号());
        data.setDbT1001_idoYMD(t.get資格情報_異動日());
        data.setDbT1001_edaNo(t.get資格情報_枝番());
        data.setDbT1001_idoJiyuCode(t.get資格情報_異動事由コード());
        data.setDbT1001_shichosonCode(t.get資格情報_市町村コード());
        data.setDbT1001_shikibetsuCode(t.get資格情報_識別コード());
        data.setDbT1001_shikakuShutokuJiyuCode(t.get資格情報_資格取得事由コード());
        data.setDbT1001_shikakuShutokuYMD(t.get資格情報_資格取得年月日());
        data.setDbT1001_shikakuShutokuTodokedeYMD(t.get資格情報_資格取得届出年月日());
        data.setDbT1001_ichigoShikakuShutokuYMD(t.get資格情報_第1号資格取得年月日());
        data.setDbT1001_hihokennshaKubunCode(t.get資格情報_資格情報険者区分コード());
        data.setDbT1001_shikakuSoshitsuJiyuCode(t.get資格情報_資格喪失事由コード());
        data.setDbT1001_shikakuSoshitsuYMD(t.get資格情報_資格喪失年月日());
        data.setDbT1001_shikakuSoshitsuTodokedeYMD(t.get資格情報_資格喪失届出年月日());
        data.setDbT1001_shikakuHenkoJiyuCode(t.get資格情報_資格変更事由コード());
        data.setDbT1001_shikakuHenkoYMD(t.get資格情報_資格変更年月日());
        data.setDbT1001_shikakuHenkoTodokedeYMD(t.get資格情報_資格変更届出年月日());
        data.setDbT1001_jushochitokureiTekiyoJiyuCode(t.get資格情報_住所地特例適用事由コード());
        data.setDbT1001_jushochitokureiTekiyoYMD(t.get資格情報_適用年月日());
        data.setDbT1001_jushochitokureiTekiyoTodokedeYMD(t.get資格情報_適用届出年月日());
        data.setDbT1001_jushochitokureiKaijoJiyuCode(t.get資格情報_住所地特例解除事由コード());
        data.setDbT1001_jushochitokureiKaijoYMD(t.get資格情報_解除年月日());
        data.setDbT1001_jushochitokureiKaijoTodokedeYMD(t.get資格情報_解除届出年月日());
        data.setDbT1001_jushochiTokureiFlag(t.get資格情報_住所地特例フラグ());
        data.setDbT1001_koikinaiJushochiTokureiFlag(t.get資格情報_広域内住所地特例フラグ());
        data.setDbT1001_koikinaiTokureiSochimotoShichosonCode(t.get資格情報_広住特措置元市町村コード());
        data.setDbT1001_kyuShichosonCode(t.get資格情報_旧市町村コード());
        data.setDbT1001_logicalDeletedFlag(t.is資格情報_論理削除フラグ());
    }

    private void set認定情報(ShiharaiHohoHenkoTempTableEntity data, ShiharaiHohoHenkoHaakuOneEntity t) {
        data.setDbT4001_shichosonCode(t.get認定情報_市町村コード());
        data.setDbT4001_hihokenshaNo(t.get認定情報_被保険者番号());
        data.setDbT4001_rirekiNo(t.get認定情報_履歴番号());
        data.setDbT4001_edaban(t.get認定情報_枝番());
        data.setDbT4001_shinseishoKanriNo(t.get認定情報_申請書管理番号());
        data.setDbT4001_shinseiJokyoKubun(t.get認定情報_申請状況区分());
        data.setDbT4001_shishoCode(t.get認定情報_支所コード());
        data.setDbT4001_chokkinFlag(t.is認定情報_直近フラグ());
        data.setDbT4001_shikibetsuCode(t.get認定情報_識別コード());
        data.setDbT4001_jukyuShinseiJiyu(t.get認定情報_受給申請事由());
        data.setDbT4001_shinseiRiyu(t.get認定情報_申請理由());
        data.setDbT4001_shinseishaKankeiCode(t.get認定情報_届出者_申請者関係コード());
        data.setDbT4001_homninKankei(t.get認定情報_届出者_本人との関係());
        data.setDbT4001_jukyuShinseiYMD(t.get認定情報_受給申請年月日());
        data.setDbT4001_nigoTokuteiShippeiCode(t.get認定情報_２号特定疾病コード());
        data.setDbT4001_shinsakaiIraiYMD(t.get認定情報_審査会依頼年月日());
        data.setDbT4001_yokaigoJotaiKubunCode(t.get認定情報_要介護認定状態区分コード());
        data.setDbT4001_ninteiYukoKikanKaishiYMD(t.get認定情報_認定有効期間開始年月日());
        data.setDbT4001_ninteiYukoKikanShuryoYMD(t.get認定情報_認定有効期間終了年月日());
        data.setDbT4001_ninteiYMD(t.get認定情報_認定年月日());
        data.setDbT4001_minashiCode(t.get認定情報_みなし要介護区分コード());
        data.setDbT4001_shiteiServiceShurui01(t.get認定情報_指定サービス種類01());
        data.setDbT4001_shiteiServiceShurui02(t.get認定情報_指定サービス種類02());
        data.setDbT4001_shiteiServiceShurui03(t.get認定情報_指定サービス種類03());
        data.setDbT4001_shiteiServiceShurui04(t.get認定情報_指定サービス種類04());
        data.setDbT4001_shiteiServiceShurui05(t.get認定情報_指定サービス種類05());
        data.setDbT4001_shiteiServiceShurui06(t.get認定情報_指定サービス種類06());
        data.setDbT4001_shiteiServiceShurui07(t.get認定情報_指定サービス種類07());
        data.setDbT4001_shiteiServiceShurui08(t.get認定情報_指定サービス種類08());
        data.setDbT4001_shiteiServiceShurui09(t.get認定情報_指定サービス種類09());
        data.setDbT4001_shiteiServiceShurui10(t.get認定情報_指定サービス種類10());
        data.setDbT4001_shiteiServiceShurui11(t.get認定情報_指定サービス種類11());
        data.setDbT4001_shiteiServiceShurui12(t.get認定情報_指定サービス種類12());
        data.setDbT4001_shiteiServiceShurui13(t.get認定情報_指定サービス種類13());
        data.setDbT4001_shiteiServiceShurui14(t.get認定情報_指定サービス種類14());
        data.setDbT4001_shiteiServiceShurui15(t.get認定情報_指定サービス種類15());
        data.setDbT4001_shiteiServiceShurui16(t.get認定情報_指定サービス種類16());
        data.setDbT4001_shiteiServiceShurui17(t.get認定情報_指定サービス種類17());
        data.setDbT4001_shiteiServiceShurui18(t.get認定情報_指定サービス種類18());
        data.setDbT4001_shiteiServiceShurui19(t.get認定情報_指定サービス種類19());
        data.setDbT4001_shiteiServiceShurui20(t.get認定情報_指定サービス種類20());
        data.setDbT4001_shiteiServiceShurui21(t.get認定情報_指定サービス種類21());
        data.setDbT4001_shiteiServiceShurui22(t.get認定情報_指定サービス種類22());
        data.setDbT4001_shiteiServiceShurui23(t.get認定情報_指定サービス種類23());
        data.setDbT4001_shiteiServiceShurui24(t.get認定情報_指定サービス種類24());
        data.setDbT4001_shiteiServiceShurui25(t.get認定情報_指定サービス種類25());
        data.setDbT4001_shiteiServiceShurui26(t.get認定情報_指定サービス種類26());
        data.setDbT4001_shiteiServiceShurui27(t.get認定情報_指定サービス種類27());
        data.setDbT4001_shiteiServiceShurui28(t.get認定情報_指定サービス種類28());
        data.setDbT4001_shiteiServiceShurui29(t.get認定情報_指定サービス種類29());
        data.setDbT4001_shiteiServiceShurui30(t.get認定情報_指定サービス種類30());
        data.setDbT4001_soshitsuYMD(t.get認定情報_喪失年月日());
        data.setDbT4001_chokkinIdoYMD(t.get認定情報_直近異動年月日());
        data.setDbT4001_chokkinIdoJiyuCode(t.get認定情報_直近異動事由コード());
        data.setDbT4001_yukoMukoKubun(t.get認定情報_有効無効区分());
        data.setDbT4001_dataKubun(t.get認定情報_データ区分());
        data.setDbT4001_remban(t.get認定情報_同一連番());
        data.setDbT4001_idoRiyu(t.get認定情報_異動理由());
        data.setDbT4001_shinseishoKubun(t.get認定情報_申請書区分());
        data.setDbT4001_sakujoJiyuCode(t.get認定情報_削除事由コード());
        data.setDbT4001_yoshienshaNinteiShinseiFlag(t.is認定情報_要支援者認定申請区分());
        data.setDbT4001_shikyuGendoTanisu(t.get認定情報_支給限度単位数());
        data.setDbT4001_shikyuGendoKaishiYMD(t.get認定情報_支給限度有効開始年月日());
        data.setDbT4001_shikyuGendoShuryoYMD(t.get認定情報_支給限度有効終了年月日());
        data.setDbT4001_tankiSikyuGendoNissu(t.get認定情報_短期入所支給限度日数());
        data.setDbT4001_tankiShikyuGendoKaishiYMD(t.get認定情報_短期入所支給限度開始年月日());
        data.setDbT4001_tankiShikyuGendoShuryoYMD(t.get認定情報_短期入所支給限度終了年月日());
        data.setDbT4001_toshoNinteiYukoKaishiYMD(t.get認定情報_当初認定有効開始年月日());
        data.setDbT4001_toshoNinteiYukoShuryoYMD(t.get認定情報_当初認定有効終了年月日());
        data.setDbT4001_jukyuShikakuShomeishoHakkoYMD1(t.get認定情報_受給資格証明書発行年月日１());
        data.setDbT4001_jukyuShikakuShomeishoHakkoYMD2(t.get認定情報_受給資格証明書発行年月日２());
        data.setDbT4001_shindanMeireishoHakkoYMD(t.get認定情報_診断命令書発行年月日());
        data.setDbT4001_nigoShinseiJuriTsuchishoHakkoYMD(t.get認定情報_２号申請受理通知書発行年月日());
        data.setDbT4001_kubunHenkoTsuchishoHakkoYMD(t.get認定情報_認定結果通知書発行年月日());
        data.setDbT4001_serviceHenkoTsuchishoHakkoYMD(t.get認定情報_区分変更通知書発行年月日());
        data.setDbT4001_ninteiKyakkaTsuchishoHakkoYMD(t.get認定情報_サービス変更通知書発行年月日());
        data.setDbT4001_ninteiTorikeshiTsuchishoHakkoYMD(t.get認定情報_認定取消通知書発行年月日());
        data.setDbT4001_shikakuShutokuMaeShinseiFlag(t.is認定情報_資格取得前申請フラグ());
        data.setDbT4001_kyuSochishaFlag(t.is認定情報_旧措置者フラグ());
        data.setDbT4001_logicalDeletedFlag(t.is認定情報_論理削除フラグ());
    }

    private void set賦課について(ShiharaiHohoHenkoTempTableEntity data, ShiharaiHohoHenkoHaakuOneEntity t) {
        data.setDbT2002_choteiNendo(t.get賦課_調定年度());
        data.setDbT2002_fukaNendo(t.get賦課_賦課年度());
        data.setDbT2002_tsuchishoNo(t.get賦課_通知書番号());
        data.setDbT2002_rirekiNo(t.get賦課_履歴番号());
        data.setDbT2002_hihokenshaNo(t.get賦課_被保険者番号());
        data.setDbT2002_shikibetsuCode(t.get賦課_識別コード());
        data.setDbT2002_setaiCode(t.get賦課_世帯コード());
        data.setDbT2002_setaiInsu(t.get賦課_世帯員数());
        data.setDbT2002_shikakuShutokuYMD(t.get賦課_資格取得日());
        data.setDbT2002_shikakuShutokuJiyu(t.get賦課_資格取得事由());
        data.setDbT2002_shikakuSoshitsuYMD(t.get賦課_資格喪失日());
        data.setDbT2002_shikakuSoshitsuJiyu(t.get賦課_資格喪失事由());
        data.setDbT2002_seihofujoShurui(t.get賦課_生活保護扶助種類());
        data.setDbT2002_seihoKaishiYMD(t.get賦課_生保開始日());
        data.setDbT2002_seihoHaishiYMD(t.get賦課_生保廃止日());
        data.setDbT2002_ronenKaishiYMD(t.get賦課_老年開始日());
        data.setDbT2002_ronenHaishiYMD(t.get賦課_老年廃止日());
        data.setDbT2002_fukaYMD(t.get賦課_賦課期日());
        data.setDbT2002_kazeiKubun(t.get賦課_課税区分());
        data.setDbT2002_setaikazeiKubun(t.get賦課_世帯課税区分());
        data.setDbT2002_gokeiShotokuGaku(t.get賦課_合計所得金額());
        data.setDbT2002_nenkinShunyuGaku(t.get賦課_公的年金収入額());
        data.setDbT2002_hokenryoDankai(t.get賦課_保険料段階());
        data.setDbT2002_hokenryoDankai1(t.get賦課_保険料算定段階1());
        data.setDbT2002_nengakuHokenryo1(t.get賦課_算定年額保険料1());
        data.setDbT2002_tsukiwariStartYM1(t.get賦課_月割開始年月1());
        data.setDbT2002_tsukiwariEndYM1(t.get賦課_月割終了年月1());
        data.setDbT2002_hokenryoDankai2(t.get賦課_保険料算定段階2());
        data.setDbT2002_nengakuHokenryo2(t.get賦課_算定年額保険料2());
        data.setDbT2002_tsukiwariStartYM2(t.get賦課_月割開始年月2());
        data.setDbT2002_tsukiwariEndYM2(t.get賦課_月割終了年月2());
        data.setDbT2002_choteiNichiji(t.get賦課_調定日時());
        data.setDbT2002_choteiJiyu1(t.get賦課_調定事由1());
        data.setDbT2002_choteiJiyu2(t.get賦課_調定事由2());
        data.setDbT2002_choteiJiyu3(t.get賦課_調定事由3());
        data.setDbT2002_choteiJiyu4(t.get賦課_調定事由4());
        data.setDbT2002_koseiM(t.get賦課_更正月());
        data.setDbT2002_gemmenMaeHokenryo(t.get賦課_減免前介護保険料_年額());
        data.setDbT2002_gemmenGaku(t.get賦課_減免額());
        data.setDbT2002_kakuteiHokenryo(t.get賦課_確定介護保険料年額());
        data.setDbT2002_hokenryoDankaiKarisanntei(t.get賦課_保険料段階_仮算定時());
        data.setDbT2002_choshuHohoRirekiNo(t.get賦課_徴収方法履歴番号());
        data.setDbT2002_idoKijunNichiji(t.get賦課_異動基準日時());
        data.setDbT2002_kozaKubun(t.get賦課_口座区分());
        data.setDbT2002_kyokaisoKubun(t.get賦課_境界層区分());
        data.setDbT2002_shokkenKubun(t.get賦課_職権区分());
        data.setDbT2002_fukaShichosonCode(t.get賦課_賦課市町村コード());
        data.setDbT2002_tkSaishutsuKampuGaku(t.get賦課_特徴歳出還付額());
        data.setDbT2002_fuSaishutsuKampuGaku(t.get賦課_普徴歳出還付額());
    }

    private void set介護期別(ShiharaiHohoHenkoTempTableEntity data, ShiharaiHohoHenkoHaakuOneEntity t) {
        data.setDbT2003_choteiNendo(t.get介護期別_調定年度());
        data.setDbT2003_fukaNendo(t.get介護期別_賦課年度());
        data.setDbT2003_tsuchishoNo(t.get介護期別_通知書番号());
        data.setDbT2003_rirekiNo(t.get介護期別_履歴番号());
        data.setDbT2003_choshuHouhou(t.get介護期別_徴収方法());
        data.setDbT2003_ki(t.get介護期別_期());
        data.setDbT2003_choteiId(t.get介護期別_調定ID());
    }

    private void set調定共通_介護継承について(ShiharaiHohoHenkoTempTableEntity data, ShiharaiHohoHenkoHaakuOneEntity t) {
        data.setUrT0705_choteiId(t.get調定共通_介護継承_調定ID());
        data.setUrT0705_shunoId(t.get調定共通_介護継承_収納ID());
        data.setUrT0705_kaikeiNendo(t.get調定共通_介護継承_会計年度());
        data.setUrT0705_shoriNendo(t.get調定共通_介護継承_処理年度());
        data.setUrT0705_shoriNo(t.get調定共通_介護継承_処理番号());
        data.setUrT0705_koseiKaisu(t.get調定共通_介護継承_更正回数());
        data.setUrT0705_choteiJiyuCode(t.get調定共通_介護継承_調定事由コード());
        data.setUrT0705_choteiYMD(t.get調定共通_介護継承_調定年月日());
        data.setUrT0705_choteigaku(t.get調定共通_介護継承_調定額());
        data.setUrT0705_shohizei(t.get調定共通_介護継承_消費税額());
        data.setUrT0705_nokigenYMD(t.get調定共通_介護継承_納期限());
        data.setUrT0705_hoteiNokigenToYMD(t.get調定共通_介護継承_法定納期限等());
        data.setUrT0705_fukaShoriJokyo(t.is調定共通_介護継承_賦課処理状況());
    }

    private void set時効について(ShiharaiHohoHenkoTempTableEntity data, ShiharaiHohoHenkoHaakuOneEntity t) {
        data.setDbT4023_shoKisaiHokenshaNo(t.get時効_証記載保険者番号());
        data.setDbT4023_hihokenshaNo(t.get時効_被保険者番号());
        data.setDbT4023_choteiNendo(t.get時効_調定年度());
        data.setDbT4023_fukaNendo(t.get時効_賦課年度());
        data.setDbT4023_tokucho_FuchoKubun(t.get時効_特徴_普徴区分());
        data.setDbT4023_tsuchishoNo(t.get時効_通知書番号());
        data.setDbT4023_shuno_Ki_Tsuki(t.get時効_収納期_月());
        data.setDbT4023_rirekiNo(t.get時効_履歴番号());
        data.setDbT4023_jikoKisanYMD(t.get時効_時効起算年月日());
        data.setDbT4023_jikoKisanYMDKubun(t.get時効_時効起算日区分());
        data.setDbT4023_logicalDeletedFlag(t.is時効_論理削除フラグ());
    }

    private void set収入について(ShiharaiHohoHenkoTempTableEntity data, ShiharaiHohoHenkoHaakuOneEntity t) {
        data.setCaTshunyuId(t.get収入ID());
        data.setCaTshunoId(t.get収納ID());
        data.setCaTshunyugaku(t.get収入額());
        data.setCaTshunyuYMD(t.get収入日());
    }

    private void set督促状発行履歴(ShiharaiHohoHenkoTempTableEntity data, ShiharaiHohoHenkoHaakuOneEntity t) {
        data.setShunoId(t.get督促状発行履歴_収納ID());
        data.setTokusokujoHakkoYMD(t.get督促状発行履歴_督促状発行年月日());
    }

    private void set宛名について(ShiharaiHohoHenkoTempTableEntity data, ShiharaiHohoHenkoHaakuOneEntity t) {
        if (t.getPsmEntity() != null) {
            IKojin kojin = ShikibetsuTaishoFactory.createKojin(t.getPsmEntity());
            data.setUaFt200_shikibetsuCode(kojin.get識別コード());
            data.setUaFt200_kanaMeisho(kojin.get名称().getKana());
            data.setUaFt200_meisho(kojin.get名称().getName());
            data.setUaFt200_yubinNo(kojin.get住所().get郵便番号());
            data.setUaFt200_gyoseikuCode(kojin.get行政区画().getGyoseiku().getコード());
            data.setUaFt200_gyoseikuName(kojin.get行政区画().getGyoseiku().get名称());
            data.setUaFt200_idoJiyuCode(kojin.get異動事由().get異動事由略称());
            // data.setUaFt200_jusho(kojin.get住所().get住所());
            data.setUaFt200_setaiCode(kojin.get世帯コード());

        }
    }

    private RString edit生保(ShikibetsuCode 識別コード) {
        if (識別コード != null && !識別コード.isEmpty()) {
            return 申請中;
        }
        return RString.EMPTY;
    }

    private RString edit認定情報の申請中(FlexibleDate 認定年月日) {
        if (認定年月日 == null || FlexibleDate.EMPTY.equals(認定年月日)) {
            return 申請中;
        }
        return RString.EMPTY;
    }

//    private FlexibleDate edit仮の時効起算日(FlexibleDate 時効起算日, FlexibleDate 督促状発行年月日, FlexibleDate 納期限の翌日) {
//
//        if ((時効起算日 == null || FlexibleDate.EMPTY.equals(時効起算日)) && (督促状発行年月日 == null || FlexibleDate.EMPTY.equals(督促状発行年月日))
//                && (納期限の翌日 == null || FlexibleDate.EMPTY.equals(納期限の翌日))) {
//            return FlexibleDate.EMPTY;
//        }
//
//        if (時効起算日 != null && !FlexibleDate.EMPTY.equals(時効起算日)) {
//            is時効起算日 = true;
//            return 時効起算日;
//        }
//        if (督促状発行年月日 != null && !FlexibleDate.EMPTY.equals(督促状発行年月日)) {
//            is督促状発行年月日 = true;
//            return 督促状発行年月日;
//        }
//        if (納期限の翌日 != null && !FlexibleDate.EMPTY.equals(納期限の翌日)) {
//            is納期限の翌日 = true;
//            return 納期限の翌日;
//        }
//        return FlexibleDate.EMPTY;
//    }
//
//    private void edit時効起算事由() {
//
//        if (is収入年月日) {
//            時効起算事由 = JikoKisanbiKubun.収入日.get名称();
//        } else if (is時効起算日) {
//            //TODO
//            時効起算事由 = JikoKisanbiKubun.収入日.get名称();
//        } else if (is督促状発行年月日) {
//            時効起算事由 = JikoKisanbiKubun.督促状発行日.get名称();
//        } else if (is納期限の翌日) {
//            時効起算事由 = JikoKisanbiKubun.納期限翌日.get名称();
//        }
//    }
    private RString edit完納_未納区分(FlexibleDate 基準日, FlexibleDate 納期限, Decimal 調定額, Decimal 収入額) {
        if (基準日.isBeforeOrEquals(納期限)) {
            return 未来納期;
        }
        if (Decimal.ZERO == 調定額 && Decimal.ZERO == 収入額) {
            return 完納_未納区分_0円;
        }
        if (Decimal.ZERO != 調定額 && Decimal.ZERO == 収入額) {
            return 完納;
        }

        if (調定額.compareTo(収入額) < 0) {
            return 過納;
        }
        if (調定額.compareTo(収入額) > 0) {
            return 未納あり;
        }
        return RString.EMPTY;
    }

    private RString edit時効区分(RString 完納_未納区分, FlexibleDate 時効起算日, FlexibleDate 基準日) {

        // todo
        //FlexibleDate 時効起算日2年後 = FlexibleDate.MAX;
        if (MinoKannoKubun.未納あり.getコード().equals(完納_未納区分) && 時効起算日.isBeforeOrEquals(基準日)) {
            return 時効到来;
        }
        return 時効未到来;
    }

//    private void edit以前未納情報(RString 完納_未納区分, RString 時効区分, Decimal 未納額, FlexibleDate 時効起算日, FlexibleDate 基準日) {
//
//        Decimal 以前滞納額 = Decimal.ZERO;
//        RString 以前滞納区分 = RString.EMPTY;
//
//        if (未納あり.equals(完納_未納区分) && 時効未到来.equals(時効区分)) {
//            以前滞納額 = 以前滞納額.add(未納額);
//        }
//        if (時効起算日 != null && !FlexibleDate.EMPTY.equals(時効起算日)) {
//            時効成立日 = 時効起算日.plusYear(2);
//        }
//
//        if (時効成立日.isBeforeOrEquals(基準日)) {
//            以前滞納区分 = 時効成立;
//        } else {
//            以前滞納区分 = 滞納期;
//        }
//    }
//    private void edit以降未納情報(RString 収納状況_期別, Decimal 調定額, Decimal 収納状況_納期限, Decimal 未納額, FlexibleDate 収納状況_時効起算日,
//            RString 収納状況_時効起算事由, FlexibleYear 賦課年度, FlexibleYear 調定年度, RString 完納_未納区分) {
//
//        RString 期別 = 収納状況_期別;
//        Decimal 保険料額 = 調定額;
//        Decimal 納期限 = 収納状況_納期限;
//        Decimal 滞納額 = 未納額;
//        RString 滞納区分 = RString.EMPTY;
//        FlexibleDate 時効起算日 = 収納状況_時効起算日;
//        RString 時効起算事由 = 収納状況_時効起算事由;
//
//        Decimal 調定額合計 = Decimal.ZERO;
//        Decimal 滞納額合計 = Decimal.ZERO;
//
//        if (賦課年度.equals(調定年度)) {
//            if (Decimal.ZERO != 調定額) {
//                調定額合計 = 調定額合計.add(調定額);
//            }
//
//            if (Decimal.ZERO != 未納額) {
//                滞納額合計 = 滞納額合計.add(未納額);
//            }
//        } else {
//            if (収納状況_時効起算日 != null && !FlexibleDate.EMPTY.equals(収納状況_時効起算日)) {
//                時効成立日 = 収納状況_時効起算日.plusYear(2);
//            }
//
//            if (processParamter.get基準日().isBefore(時効成立日)) {
//                if (未納あり.equals(完納_未納区分)) {
//    //TODO
//                }
////TODO
//            }
//        }
//    }
//    private void edit滞納区分(FlexibleDate 納期限, FlexibleDate 時効起算日, Decimal 滞納額) {
//        if (processParamter.get基準日().isBeforeOrEquals(納期限)) {
//            滞納区分 = 納期限未到来;
//        }
//
//        if (時効起算日 != null && !FlexibleDate.EMPTY.equals(時効起算日)) {
//            時効成立日 = 時効起算日.plusYear(2);
//            if (時効成立日.isBeforeOrEquals(processParamter.get基準日())) {
//                滞納区分 = 時効成立;
//            }
//        }
//        滞納区分 = 滞納期;
//
//        if (納期限 == null || 納期限.isEmpty()) {
//            滞納区分 = RString.EMPTY;
//        }
//        if (Decimal.ZERO == 滞納額) {
//            // 時効起算日 TODO
//            時効起算事由 = RString.EMPTY;
//        }
//        if (納期限未到来.equals(滞納区分)) {
//            // 時効起算日 TODO
//            時効起算事由 = RString.EMPTY;
//            //滞納額 TODO
//        }
//    }
}
