/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.service.core.tashichosonjushochitokureidaicho;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dba.business.core.tashichosonjushochitokureidaicho.OtherAddressLedgerBusiness;
import jp.co.ndensan.reams.db.dba.definition.mybatisprm.atena.OtherAddressInformationRecipientNameMybatisParam;
import jp.co.ndensan.reams.db.dba.definition.mybatisprm.otheraddressledger.OtherAddressInformationParameter;
import jp.co.ndensan.reams.db.dba.definition.mybatisprm.tajushochitokureisyakanri.TaJushochiTokureisyaKanriParameter;
import jp.co.ndensan.reams.db.dba.definition.reportid.ReportIdDBA;
import jp.co.ndensan.reams.db.dba.entity.db.relate.otheraddressledger.OtherAddressInfEntity;
import jp.co.ndensan.reams.db.dba.entity.db.relate.otheraddressledger.OtherAddressInfFromDBEntity;
import jp.co.ndensan.reams.db.dba.entity.db.relate.otheraddressledger.OtherAddressLedgerEntity;
import jp.co.ndensan.reams.db.dba.persistence.db.mapper.relate.otheraddressinformation.IOtherAddressInformationMapper;
import jp.co.ndensan.reams.db.dba.persistence.db.mapper.relate.tajushochitokureisyakanri.ITaJushochiTokureisyaKanriMapper;
import jp.co.ndensan.reams.db.dbx.definition.core.codeshubetsu.DBACodeShubetsu;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;
import jp.co.ndensan.reams.db.dbx.definition.core.util.ObjectUtil;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.service.core.shichosonsecurityjoho.ShichosonSecurityJoho;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChohyoSeigyoKyotsu;
import jp.co.ndensan.reams.db.dbz.business.core.kanri.JushoHenshu;
import jp.co.ndensan.reams.db.dbz.business.core.koikizenshichosonjoho.KoikiZenShichosonJoho;
import jp.co.ndensan.reams.db.dbz.definition.core.jigyoshashubetsu.JigyosyaType;
import jp.co.ndensan.reams.db.dbz.definition.core.shisetsushurui.ShisetsuType;
import jp.co.ndensan.reams.db.dbz.service.core.MapperProvider;
import jp.co.ndensan.reams.db.dbz.service.core.basic.ChohyoSeigyoKyotsuManager;
import jp.co.ndensan.reams.db.dbz.service.core.koikishichosonjoho.KoikiShichosonJohoFinder;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.IShikibetsuTaisho;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.ShikibetsuTaishoFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoPSMSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.KensakuYusenKubun;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.psm.DataShutokuKubun;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.IShikibetsuTaishoPSMSearchKey;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FillTypeFormatted;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.util.code.CodeMaster;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 他市町村住所地特例者台帳のクラスです。
 *
 * @reamsid_L DBA-0402-020 wangjie2
 */
public class TashichosonJushochiTokureiDaichoFinder {

    private static final int ONEPAGE = 1;
    private static final RString 住所 = new RString("住所");
    private static final RString 行政区 = new RString("行政区");
    private static final RString 前住所 = new RString("前住所");
    private static final RString 他住所地特例者 = new RString("他住所地特例者");
    private static final RString 連絡先 = new RString("連絡先");
    private static final RString 男 = new RString("男");
    private static final RString 女 = new RString("女");
    private static final RString HOUR = new RString("時");
    private static final RString MINUTE = new RString("分");
    private static final RString SECOND = new RString("秒");
    private static final RString SPACE = new RString("　");
    private static final int INT10 = 10;

    /**
     * 他市町村住所地特例者台帳の帳票出力用データを作成します。
     *
     * @param 識別コード 識別コード
     * @return 他市町村住所地特例者台帳Entityリスト
     */
    public List<OtherAddressLedgerBusiness> getTashichosonJushochiTokureiDaicho(ShikibetsuCode 識別コード) {
        List<OtherAddressLedgerEntity> otherAddressLedgerLst = new ArrayList<>();
        ShikibetsuTaishoPSMSearchKeyBuilder key = new ShikibetsuTaishoPSMSearchKeyBuilder(GyomuCode.DB介護保険, KensakuYusenKubun.住登外優先);
        key.setデータ取得区分(DataShutokuKubun.直近レコード);
        key.set識別コード(識別コード);
        IShikibetsuTaishoPSMSearchKey shikibetsuTaishoPSMSearchKey = key.build();
        OtherAddressInformationRecipientNameMybatisParam recipientNameMybatisParam
                = new OtherAddressInformationRecipientNameMybatisParam(shikibetsuTaishoPSMSearchKey);
        MapperProvider mapperProvider = InstanceProvider.create(MapperProvider.class);
        IOtherAddressInformationMapper otherAddressInfMapper = mapperProvider.create(IOtherAddressInformationMapper.class);
        List<UaFt200FindShikibetsuTaishoEntity> 宛名情報 = otherAddressInfMapper.get宛名識別対象(recipientNameMybatisParam);
        if (宛名情報.isEmpty()) {
            OtherAddressLedgerEntity otherAddressLedger = new OtherAddressLedgerEntity();
            otherAddressLedger.set印刷日時(dateTimeEdit(RDate.getNowDateTime()));
            otherAddressLedger.setページ目(ONEPAGE);
            otherAddressLedger.set状態(他住所地特例者);
            otherAddressLedgerLst.add(otherAddressLedger);
            return getOtherAddressLedgerBusinessList(otherAddressLedgerLst);
        }
        List<OtherAddressInfEntity> 他市町村住所地特例者情報 = get他市町村住所地特例者情報(識別コード);
        if (他市町村住所地特例者情報.isEmpty()) {
            OtherAddressLedgerEntity otherAddressLedger = new OtherAddressLedgerEntity();
            set他市町村住所地特例者台帳情報(otherAddressLedger, null, 宛名情報.get(0), null, null, ONEPAGE);
            OtherAddressLedgerBusiness otherAddressLedgerBusiness = new OtherAddressLedgerBusiness(otherAddressLedger);
            List<OtherAddressLedgerBusiness> otherAddressLedgerBusinessList = new ArrayList<>();
            otherAddressLedgerBusinessList.add(otherAddressLedgerBusiness);
            return otherAddressLedgerBusinessList;
        }
        LasdecCode 市町村コード = 他市町村住所地特例者情報.get(0).get市町村コード();
        RString 市町村名称 = get市町村名称(市町村コード);
        int pageNo = 1;
        for (OtherAddressInfEntity otherAddInfEntity : 他市町村住所地特例者情報) {
            OtherAddressLedgerEntity otherAddressLedger = new OtherAddressLedgerEntity();
            set他市町村住所地特例者台帳情報(otherAddressLedger, otherAddInfEntity, 宛名情報.get(0), 市町村名称, 市町村コード, pageNo);
            otherAddressLedgerLst.add(otherAddressLedger);
            pageNo++;
        }
        return getOtherAddressLedgerBusinessList(otherAddressLedgerLst);

    }

    private List<OtherAddressLedgerBusiness> getOtherAddressLedgerBusinessList(List<OtherAddressLedgerEntity> otherAddressLedgerLst) {
        List<OtherAddressLedgerBusiness> otherAddressLedgerList = new ArrayList<>();
        for (OtherAddressLedgerEntity otherAddressLedger : otherAddressLedgerLst) {
            OtherAddressLedgerBusiness otherAddressLedgerBusiness = new OtherAddressLedgerBusiness(otherAddressLedger);
            otherAddressLedgerList.add(otherAddressLedgerBusiness);
        }
        return otherAddressLedgerList;
    }

    /**
     * 他市町村住所地特例者台帳情報Entityを設定します。
     *
     * @param 他市町村住所地特例者台帳情報 他市町村住所地特例者台帳情報
     * @param 他市町村住所地特例者情報 他市町村住所地特例者情報
     * @param 宛名識別対象取得PSM 宛名識別対象取得PSM
     * @param 市町村名称 市町村名称
     * @param 市町村コード 市町村コード
     * @param ページ目 ページ目
     */
    private void set他市町村住所地特例者台帳情報(OtherAddressLedgerEntity 他市町村住所地特例者台帳情報,
            OtherAddressInfEntity 他市町村住所地特例者情報, UaFt200FindShikibetsuTaishoEntity 宛名識別対象取得PSM,
            RString 市町村名称, LasdecCode 市町村コード, int ページ目) {
        他市町村住所地特例者台帳情報.set印刷日時(dateTimeEdit(RDate.getNowDateTime()));
        他市町村住所地特例者台帳情報.setページ目(ページ目);
        if (市町村コード != null) {
            他市町村住所地特例者台帳情報.set市町村コード(市町村コード);
        }
        if (市町村名称 != null) {
            他市町村住所地特例者台帳情報.set市町村名称(市町村名称);
        }
        他市町村住所地特例者台帳情報.set状態(他住所地特例者);
        他市町村住所地特例者台帳情報.set電話番号タイトル(連絡先);
        他市町村住所地特例者台帳情報.set電話番号１(ObjectUtil.defaultIfNull(宛名識別対象取得PSM.getRenrakusaki1(), TelNo.EMPTY).getColumnValue());
        他市町村住所地特例者台帳情報.set電話番号２(RString.EMPTY);
        他市町村住所地特例者台帳情報.set生年月日(宛名識別対象取得PSM.getSeinengappiYMD());
        他市町村住所地特例者台帳情報.set性別(new RString("1").equals(宛名識別対象取得PSM.getSeibetsuCode()) ? 男 : 女);
        他市町村住所地特例者台帳情報.set世帯コード(宛名識別対象取得PSM.getSetaiCode());
        他市町村住所地特例者台帳情報.set識別コード(宛名識別対象取得PSM.getShikibetsuCode());
        他市町村住所地特例者台帳情報.set氏名カナ(宛名識別対象取得PSM.getKanaMeisho());
        他市町村住所地特例者台帳情報.set氏名(宛名識別対象取得PSM.getMeisho());
        他市町村住所地特例者台帳情報.set地区コード1(宛名識別対象取得PSM.getChikuCode1());
        他市町村住所地特例者台帳情報.set地区タイトル1(宛名識別対象取得PSM.getChikuName1());
        他市町村住所地特例者台帳情報.set地区コード2(宛名識別対象取得PSM.getChikuCode2());
        他市町村住所地特例者台帳情報.set地区タイトル2(宛名識別対象取得PSM.getChikuName2());
        他市町村住所地特例者台帳情報.set地区コード3(宛名識別対象取得PSM.getChikuCode3());
        他市町村住所地特例者台帳情報.set地区タイトル3(宛名識別対象取得PSM.getChikuName3());
        IShikibetsuTaisho 宛名情報 = ShikibetsuTaishoFactory.createShikibetsuTaisho(宛名識別対象取得PSM);
        ChohyoSeigyoKyotsu 帳票共通情報 = new ChohyoSeigyoKyotsuManager().get帳票制御共通(SubGyomuCode.DBA介護資格, ReportIdDBA.DBA100011.getReportId());
        他市町村住所地特例者台帳情報.set住所1(JushoHenshu.editJusho(帳票共通情報, 宛名情報, AssociationFinderFactory.createInstance().getAssociation()));
        他市町村住所地特例者台帳情報.set住所タイトル1(住所);
        他市町村住所地特例者台帳情報.set住所コード(JushoHenshu.get住所コード(宛名識別対象取得PSM));
        他市町村住所地特例者台帳情報.set行政区タイトル(行政区);
        他市町村住所地特例者台帳情報.set行政区コード(宛名識別対象取得PSM.getGyoseikuCode());
        他市町村住所地特例者台帳情報.set住所2(JushoHenshu.editJusho2(
                宛名識別対象取得PSM.getTennyumaeJusho(), 宛名識別対象取得PSM.getTennyumaeBanchi(), 宛名識別対象取得PSM.getTennyumaeKatagaki()));
        他市町村住所地特例者台帳情報.set住所タイトル2(前住所);
        他市町村住所地特例者台帳情報.set前住所コード(宛名識別対象取得PSM.getTennyumaeZenkokuJushoCode());
        他市町村住所地特例者台帳情報.set転入年月日(宛名識別対象取得PSM.getTorokuIdoYMD());
        if (宛名識別対象取得PSM.getTenshutsuKakuteiIdoYMD() != null) {
            他市町村住所地特例者台帳情報.set転出年月日(宛名識別対象取得PSM.getTenshutsuKakuteiIdoYMD());
        } else {
            他市町村住所地特例者台帳情報.set転出年月日(宛名識別対象取得PSM.getTenshutsuYoteiIdoYMD());
        }
        if (他市町村住所地特例者情報 != null) {
            他市町村住所地特例者台帳情報.setNo(他市町村住所地特例者情報.getNo());
            他市町村住所地特例者台帳情報.set適用年月日(flexibleDateToFillTypeFormatted(他市町村住所地特例者情報.get適用年月日()));
            他市町村住所地特例者台帳情報.set適用届出年月日(flexibleDateToFillTypeFormatted(他市町村住所地特例者情報.get適用届出年月日()));
            他市町村住所地特例者台帳情報.set他市町村住所地特例適用事由コード(他市町村住所地特例者情報.get適用事由コード());
            他市町村住所地特例者台帳情報.set他市町村住所地特例適用事由名称(他市町村住所地特例者情報.get適用事由名称());
            他市町村住所地特例者台帳情報.set入所年月日(flexibleDateToFillTypeFormatted(他市町村住所地特例者情報.get入所年月日()));
            他市町村住所地特例者台帳情報.set事業者名称(他市町村住所地特例者情報.get事業者名称());
            他市町村住所地特例者台帳情報.set電話番号(他市町村住所地特例者情報.get電話番号());
            他市町村住所地特例者台帳情報.set解除年月日(flexibleDateToFillTypeFormatted(他市町村住所地特例者情報.get解除年月日()));
            他市町村住所地特例者台帳情報.set解除届出年月日(flexibleDateToFillTypeFormatted(他市町村住所地特例者情報.get解除届出年月日()));
            他市町村住所地特例者台帳情報.set他市町村住所地特例解除事由コード(他市町村住所地特例者情報.get解除事由コード());
            他市町村住所地特例者台帳情報.set他市町村住所地特例解除事由名称(他市町村住所地特例者情報.get解除事由名称());
            他市町村住所地特例者台帳情報.set退所年月日(flexibleDateToFillTypeFormatted(他市町村住所地特例者情報.get退所年月日()));
            他市町村住所地特例者台帳情報.set事業者住所(他市町村住所地特例者情報.get事業者住所());
            他市町村住所地特例者台帳情報.set郵便番号(他市町村住所地特例者情報.get郵便番号());
            他市町村住所地特例者台帳情報.set保険者名称(他市町村住所地特例者情報.get保険者名称());
            他市町村住所地特例者台帳情報.set他被保番号(他市町村住所地特例者情報.get他被保番号());
        }
    }

    private FillTypeFormatted flexibleDateToFillTypeFormatted(FlexibleDate date) {
        return null == date ? FlexibleDate.EMPTY.
                wareki().eraType(EraType.KANJI_RYAKU).firstYear(FirstYear.GAN_NEN).separator(Separator.PERIOD).fillType(FillType.BLANK)
                : date.wareki().eraType(EraType.KANJI_RYAKU).firstYear(FirstYear.GAN_NEN).separator(Separator.PERIOD).fillType(FillType.BLANK);
    }

    /**
     * 日時を編集します。
     *
     * @param dateTime
     * @return システム日時（ggyy年mm月dd日　hh時mm分ss秒　作成)
     */
    private RString dateTimeEdit(RDateTime dateTime) {
        RString dateTimeEdit = new FlexibleDate(dateTime.getDate().toDateString()).seireki().separator(Separator.JAPANESE)
                .fillType(FillType.ZERO).toDateString();
        return dateTimeEdit.concat(SPACE).concat(intToRString(dateTime.getHour())).concat(HOUR).concat(intToRString(dateTime.getMinute()))
                .concat(MINUTE).concat(intToRString(dateTime.getSecond())).concat(SECOND).concat("　作成");
    }

    private RString intToRString(int number) {
        if (number < INT10) {
            return new RString("0").concat(String.valueOf(number));
        }
        return new RString(String.valueOf(number));
    }

    /**
     * 他市町村住所地特例者情報を取得します。
     *
     * @param 識別コード 識別コード
     * @return 他市町村住所地特例者情報Entityリスト
     */
    private List<OtherAddressInfEntity> get他市町村住所地特例者情報(ShikibetsuCode 識別コード) {
        RString 保険者種別 = new RString("08");
        OtherAddressInformationParameter 検索条件
                = OtherAddressInformationParameter.createParam_ServiceOtherAddressInformation(識別コード, 保険者種別);
        MapperProvider mapperProvider = InstanceProvider.create(MapperProvider.class);
        IOtherAddressInformationMapper otherAddressInfMapper = mapperProvider.create(IOtherAddressInformationMapper.class);
        List<OtherAddressInfFromDBEntity> 他市町村住所地特例者情報Lst = otherAddressInfMapper.get他市町村住所地特例者情報の取得処理(検索条件);
        List<OtherAddressInfEntity> otherAddressInfEntityLst = new ArrayList<>();
        int no = 1;
        ITaJushochiTokureisyaKanriMapper mapper = mapperProvider.create(ITaJushochiTokureisyaKanriMapper.class);
        for (OtherAddressInfFromDBEntity otherAddressInfFromDBEntity : 他市町村住所地特例者情報Lst) {
            JigyoshaNo 入所施設コード = otherAddressInfFromDBEntity.get入所施設コード();
            AtenaMeisho new事業者名称 = otherAddressInfFromDBEntity.get事業者名称();
            if (ShisetsuType.介護保険施設.getコード().equals(otherAddressInfFromDBEntity.get入所施設種類())) {
                TaJushochiTokureisyaKanriParameter iParameter
                        = TaJushochiTokureisyaKanriParameter.createParam_TaJushochi(
                                ShikibetsuCode.EMPTY, RString.EMPTY, RString.EMPTY, 入所施設コード, RString.EMPTY);
                OtherAddressInfFromDBEntity 事業者 = mapper.get事業者_介護保険施設(iParameter);
                if (事業者 != null) {
                    new事業者名称 = 事業者.get事業者名称();
                    otherAddressInfFromDBEntity.set事業者名称(事業者.get事業者名称());
                    otherAddressInfFromDBEntity.set事業者住所(事業者.get事業者住所());
                    otherAddressInfFromDBEntity.set事業者番号(事業者.get事業者番号());
                    otherAddressInfFromDBEntity.set事業者種別(事業者.get事業者種別());
                    otherAddressInfFromDBEntity.set郵便番号(事業者.get郵便番号());
                    otherAddressInfFromDBEntity.set電話番号(事業者.get電話番号());
                }
            } else if (ShisetsuType.住所地特例対象施設.getコード().equals(otherAddressInfFromDBEntity.get入所施設種類())) {
                TaJushochiTokureisyaKanriParameter iParameter = TaJushochiTokureisyaKanriParameter.createParam_TaJushochi(
                        ShikibetsuCode.EMPTY, RString.EMPTY, RString.EMPTY, 入所施設コード,
                        JigyosyaType.住所地特例対象施設.getコード());
                OtherAddressInfFromDBEntity 事業者 = mapper.get事業者_住所地特例対象施設(iParameter);
                if (事業者 != null) {
                    new事業者名称 = 事業者.get事業者名称();
                    otherAddressInfFromDBEntity.set事業者名称(事業者.get事業者名称());
                    otherAddressInfFromDBEntity.set事業者住所(事業者.get事業者住所());
                    otherAddressInfFromDBEntity.set事業者番号(事業者.get事業者番号());
//                    otherAddressInfFromDBEntity.set事業者種別(事業者.get事業者種別());
                    otherAddressInfFromDBEntity.set郵便番号(事業者.get郵便番号());
                    otherAddressInfFromDBEntity.set電話番号(事業者.get電話番号());
                }
            }
            RString 適用事由名称 = RString.EMPTY;
            RString 解除事由名称 = RString.EMPTY;
            if (otherAddressInfFromDBEntity.get他市町村住所地特例適用事由コード() != null) {
                適用事由名称 = CodeMaster.getCodeRyakusho(SubGyomuCode.DBA介護資格,
                        DBACodeShubetsu.介護資格適用事由_他特例者.getコード(),
                        new Code(otherAddressInfFromDBEntity.get他市町村住所地特例適用事由コード()),
                        new FlexibleDate(RDate.getNowDate().toDateString()));
            }
            if (otherAddressInfFromDBEntity.get他市町村住所地特例解除事由コード() != null) {
                解除事由名称 = CodeMaster.getCodeRyakusho(SubGyomuCode.DBA介護資格,
                        DBACodeShubetsu.介護資格解除事由_他特例者.getコード(),
                        new Code(otherAddressInfFromDBEntity.get他市町村住所地特例解除事由コード()),
                        new FlexibleDate(RDate.getNowDate().toDateString()));
            }
            if (null == 適用事由名称) {
                適用事由名称 = RString.EMPTY;
            }
            if (null == 解除事由名称) {
                解除事由名称 = RString.EMPTY;
            }
            OtherAddressInfEntity otherAddressInfEntity = new OtherAddressInfEntity();
            set他市町村住所地特例者情報(otherAddressInfEntity, otherAddressInfFromDBEntity, no, 適用事由名称, 解除事由名称, new事業者名称);
            otherAddressInfEntityLst.add(otherAddressInfEntity);
            no++;
        }
        return otherAddressInfEntityLst;
    }

    /**
     * 他市町村住所地特例者情報Entityを設定します。
     *
     * @param 他市町村住所地特例者情報 他市町村住所地特例者情報
     * @param otherAddressInfFromDBEntity otherAddressInfFromDBEntity
     * @param no no
     * @param 適用事由名称 適用事由名称
     * @param 解除事由名称 解除事由名称
     */
    private void set他市町村住所地特例者情報(OtherAddressInfEntity 他市町村住所地特例者情報, OtherAddressInfFromDBEntity otherAddressInfFromDBEntity,
            Integer no, RString 適用事由名称, RString 解除事由名称, AtenaMeisho new事業者名称) {
        他市町村住所地特例者情報.setNo(new RString(no.toString()));
        他市町村住所地特例者情報.set事業者住所(otherAddressInfFromDBEntity.get事業者住所());
        他市町村住所地特例者情報.set事業者名称(new事業者名称);
        他市町村住所地特例者情報.set他被保番号(otherAddressInfFromDBEntity.get措置被保険者番号());
        他市町村住所地特例者情報.set保険者名称(otherAddressInfFromDBEntity.get保険者名称());
        他市町村住所地特例者情報.set入所年月日(otherAddressInfFromDBEntity.get入所年月日());
        他市町村住所地特例者情報.set解除事由コード(otherAddressInfFromDBEntity.get他市町村住所地特例解除事由コード());
        他市町村住所地特例者情報.set解除事由名称(解除事由名称);
        他市町村住所地特例者情報.set解除届出年月日(otherAddressInfFromDBEntity.get解除届出年月日());
        他市町村住所地特例者情報.set解除年月日(otherAddressInfFromDBEntity.get解除年月日());
        他市町村住所地特例者情報.set退所年月日(otherAddressInfFromDBEntity.get退所年月日());
        他市町村住所地特例者情報.set適用事由コード(otherAddressInfFromDBEntity.get他市町村住所地特例適用事由コード());
        他市町村住所地特例者情報.set適用事由名称(適用事由名称);
        他市町村住所地特例者情報.set適用届出年月日(otherAddressInfFromDBEntity.get適用届出年月日());
        他市町村住所地特例者情報.set適用年月日(otherAddressInfFromDBEntity.get適用年月日());
        他市町村住所地特例者情報.set郵便番号(otherAddressInfFromDBEntity.get郵便番号());
        他市町村住所地特例者情報.set電話番号(otherAddressInfFromDBEntity.get電話番号());
        他市町村住所地特例者情報.set市町村コード(otherAddressInfFromDBEntity.get市町村コード());
    }

    /**
     * 市町村名称を取得します。
     *
     * @param 市町村コード 市町村コード
     * @return 市町村名称 導入形態コード取得できなかった場合、NULLを返却する
     */
    private RString get市町村名称(LasdecCode 市町村コード) {
        ShichosonSecurityJoho 市町村セキュリティ情報 = ShichosonSecurityJoho.getShichosonSecurityJoho(GyomuBunrui.介護事務);
        Code 導入形態コード = 市町村セキュリティ情報.get導入形態コード();
        if (導入形態コード.isEmpty()) {
            return null;
        }
        KoikiShichosonJohoFinder koikiShichosonJohoFinder = KoikiShichosonJohoFinder.createInstance();
        if ((new RString("11")).equals(導入形態コード.getColumnValue().substring(1, 2))) {
            List<KoikiZenShichosonJoho> koikiZenShichosonJohoLst = koikiShichosonJohoFinder.getGenShichosonJoho().records();
            for (KoikiZenShichosonJoho koikiZenShichosonJoho : koikiZenShichosonJohoLst) {
                if (市町村コード.equals(koikiZenShichosonJoho.get市町村コード())) {
                    return koikiZenShichosonJoho.get市町村名称();
                }
            }
        } else {
            List<KoikiZenShichosonJoho> koikiZenShichosonJohoLst = koikiShichosonJohoFinder.koseiShichosonJoho().records();
            return koikiZenShichosonJohoLst.get(0).get市町村名称();
        }
        return null;
    }

}
