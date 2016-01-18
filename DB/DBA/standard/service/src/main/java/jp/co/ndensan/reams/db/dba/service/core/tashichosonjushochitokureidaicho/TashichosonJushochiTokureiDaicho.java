/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.service.core.tashichosonjushochitokureidaicho;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dba.definition.mybatisprm.atena.OtherAddressInformationRecipientNameMybatisParam;
import jp.co.ndensan.reams.db.dba.definition.otheraddressledger.OtherAddressInformationParameter;
import jp.co.ndensan.reams.db.dba.entity.db.otheraddressledger.OtherAddressInfEntity;
import jp.co.ndensan.reams.db.dba.entity.db.otheraddressledger.OtherAddressInfFromDBEntity;
import jp.co.ndensan.reams.db.dba.entity.db.otheraddressledger.OtherAddressInformationRecipientNameMybatisEntity;
import jp.co.ndensan.reams.db.dba.entity.db.otheraddressledger.OtherAddressLedgerEntity;
import jp.co.ndensan.reams.db.dba.persistence.mapper.otheraddressinformation.IOtherAddressInformationMapper;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;
import jp.co.ndensan.reams.db.dbx.service.ShichosonSecurityJoho;
import jp.co.ndensan.reams.db.dbz.business.core.koikizenshichosonjoho.KoikiZenShichosonJoho;
import jp.co.ndensan.reams.db.dbz.service.core.MapperProvider;
import jp.co.ndensan.reams.db.dbz.service.core.basic.koikishichosonjoho.KoikiShichosonJohoFinder;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoPSMSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.KensakuYusenKubun;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.psm.DataShutokuKubun;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.IShikibetsuTaishoPSMSearchKey;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.CodeShubetsu;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
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
 */
public class TashichosonJushochiTokureiDaicho {

    private static final int ONEPAGE = 1;
    private static final RString 住所 = new RString("住所");
    private static final RString 行政区 = new RString("行政区");
    private static final RString 前住所 = new RString("前住所");
    private static final RString 他住所地特例者 = new RString("他住所地特例者");
    private static final RString 連絡先 = new RString("連絡先");
    private static final RString 男 = new RString("男");
    private static final RString 女 = new RString("女");
    private static final RString CHANGE_LINE = new RString("\n");
    private static final RString HOUR = new RString("時");
    private static final RString MINUTE = new RString("分");
    private static final RString SECOND = new RString("秒");
    private static final RString SPACE = new RString("　");

    /**
     * 他市町村住所地特例者台帳の帳票出力用データを作成します。
     *
     * @param 識別コード 識別コード
     * @return 他市町村住所地特例者台帳Entityリスト
     */
    public List<OtherAddressLedgerEntity> getTashichosonJushochiTokureiDaicho(ShikibetsuCode 識別コード) {
        List<OtherAddressLedgerEntity> otherAddressLedgerLst = new ArrayList<>();
        ShikibetsuTaishoPSMSearchKeyBuilder key = new ShikibetsuTaishoPSMSearchKeyBuilder(GyomuCode.DB介護保険, KensakuYusenKubun.住登外優先);
        key.setデータ取得区分(DataShutokuKubun.直近レコード);
        key.set識別コード(識別コード);
        IShikibetsuTaishoPSMSearchKey shikibetsuTaishoPSMSearchKey = key.build();
        OtherAddressInformationRecipientNameMybatisParam recipientNameMybatisParam
                = new OtherAddressInformationRecipientNameMybatisParam(shikibetsuTaishoPSMSearchKey);
        MapperProvider mapperProvider = InstanceProvider.create(MapperProvider.class);
        IOtherAddressInformationMapper otherAddressInfMapper = mapperProvider.create(IOtherAddressInformationMapper.class);
        List<OtherAddressInformationRecipientNameMybatisEntity> 宛名情報 = otherAddressInfMapper.get宛名識別対象(recipientNameMybatisParam);
        if (宛名情報.isEmpty()) {
            OtherAddressLedgerEntity otherAddressLedger = new OtherAddressLedgerEntity();
            otherAddressLedger.set印刷日時(dateTimeEdit(RDate.getNowDateTime()));
            otherAddressLedger.setページ目(ONEPAGE);
            otherAddressLedger.set状態(他住所地特例者);
            otherAddressLedgerLst.add(otherAddressLedger);
            return otherAddressLedgerLst;
        }
        List<OtherAddressInfEntity> 他市町村住所地特例者情報 = get他市町村住所地特例者情報(識別コード);
        LasdecCode 市町村コード = 他市町村住所地特例者情報.get(0).get市町村コード();
        RString 市町村名称 = get市町村名称(市町村コード);
        int pageNo = ONEPAGE;
        for (OtherAddressInfEntity otherAddInfEntity : 他市町村住所地特例者情報) {
            OtherAddressLedgerEntity otherAddressLedger = new OtherAddressLedgerEntity();
            set他市町村住所地特例者台帳情報(otherAddressLedger, otherAddInfEntity, 宛名情報.get(0), 市町村名称, 市町村コード, pageNo);
            otherAddressLedgerLst.add(otherAddressLedger);
            pageNo++;
        }
        return otherAddressLedgerLst;

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
            OtherAddressInfEntity 他市町村住所地特例者情報, OtherAddressInformationRecipientNameMybatisEntity 宛名識別対象取得PSM,
            RString 市町村名称, LasdecCode 市町村コード, int ページ目) {
        他市町村住所地特例者台帳情報.set印刷日時(dateTimeEdit(RDate.getNowDateTime()));
        他市町村住所地特例者台帳情報.setページ目(ページ目);
        他市町村住所地特例者台帳情報.set市町村コード(市町村コード);
        他市町村住所地特例者台帳情報.set市町村名称(市町村名称);
        他市町村住所地特例者台帳情報.set状態(他住所地特例者);
        他市町村住所地特例者台帳情報.set電話番号タイトル(連絡先);
        他市町村住所地特例者台帳情報.set電話番号１(宛名識別対象取得PSM.get連絡先());
        他市町村住所地特例者台帳情報.set電話番号２(RString.EMPTY);
        他市町村住所地特例者台帳情報.set生年月日(宛名識別対象取得PSM.get生年月日());
        他市町村住所地特例者台帳情報.set性別(new RString("1").equals(宛名識別対象取得PSM.get性別コード()) ? 男 : 女);
        他市町村住所地特例者台帳情報.set世帯コード(宛名識別対象取得PSM.get世帯コード());
        他市町村住所地特例者台帳情報.set識別コード(宛名識別対象取得PSM.get識別コード());
        他市町村住所地特例者台帳情報.set氏名カナ(宛名識別対象取得PSM.getカナ名称());
        他市町村住所地特例者台帳情報.set氏名(宛名識別対象取得PSM.get氏名());
        他市町村住所地特例者台帳情報.set地区コード1(宛名識別対象取得PSM.get地区コード１());
        他市町村住所地特例者台帳情報.set地区タイトル1(宛名識別対象取得PSM.get地区名１());
        他市町村住所地特例者台帳情報.set地区コード2(宛名識別対象取得PSM.get地区コード２());
        他市町村住所地特例者台帳情報.set地区タイトル2(宛名識別対象取得PSM.get地区名２());
        他市町村住所地特例者台帳情報.set地区コード3(宛名識別対象取得PSM.get地区コード３());
        他市町村住所地特例者台帳情報.set地区タイトル3(宛名識別対象取得PSM.get地区名３());
        他市町村住所地特例者台帳情報.set住所1(atenaJushoToRString(宛名識別対象取得PSM.get住所()));
        他市町村住所地特例者台帳情報.set住所タイトル1(住所);
        他市町村住所地特例者台帳情報.set住所コード(宛名識別対象取得PSM.get住所コード());
        他市町村住所地特例者台帳情報.set行政区タイトル(行政区);
        他市町村住所地特例者台帳情報.set行政区コード(宛名識別対象取得PSM.get行政区コード());
        他市町村住所地特例者台帳情報.set住所2(atenaJushoToRString(宛名識別対象取得PSM.get前住所()));
        他市町村住所地特例者台帳情報.set住所タイトル2(前住所);
        他市町村住所地特例者台帳情報.set前住所コード(宛名識別対象取得PSM.get前住所コード());
        他市町村住所地特例者台帳情報.set転入年月日(宛名識別対象取得PSM.get転入年月日());
        他市町村住所地特例者台帳情報.set転出年月日(宛名識別対象取得PSM.get転出年月日());
        他市町村住所地特例者台帳情報.setNO(他市町村住所地特例者情報.getNO());
        他市町村住所地特例者台帳情報.set適用年月日(flexibleDateToFillTypeFormatted(他市町村住所地特例者情報.get適用年月日()));
        他市町村住所地特例者台帳情報.set適用届出年月日(flexibleDateToFillTypeFormatted(他市町村住所地特例者情報.get適用届出年月日()));
        他市町村住所地特例者台帳情報.set他市町村住所地特例適用事由コード(他市町村住所地特例者情報.get適用事由名称());
        他市町村住所地特例者台帳情報.set他市町村住所地特例適用事由名称(他市町村住所地特例者情報.get適用事由名称());
        他市町村住所地特例者台帳情報.set入所年月日(flexibleDateToFillTypeFormatted(他市町村住所地特例者情報.get入所年月日()));
        他市町村住所地特例者台帳情報.set事業者名称(他市町村住所地特例者情報.get事業者名称());
        他市町村住所地特例者台帳情報.set電話番号(他市町村住所地特例者情報.get電話番号());
        他市町村住所地特例者台帳情報.set解除年月日(flexibleDateToFillTypeFormatted(他市町村住所地特例者情報.get解除年月日()));
        他市町村住所地特例者台帳情報.set解除届出年月日(flexibleDateToFillTypeFormatted(他市町村住所地特例者情報.get解除届出年月日()));
        他市町村住所地特例者台帳情報.set他市町村住所地特例解除事由コード(他市町村住所地特例者情報.get解除事由名称());
        他市町村住所地特例者台帳情報.set他市町村住所地特例解除事由名称(他市町村住所地特例者情報.get解除事由名称());
        他市町村住所地特例者台帳情報.set退所年月日(flexibleDateToFillTypeFormatted(他市町村住所地特例者情報.get退所年月日()));
        他市町村住所地特例者台帳情報.set事業者住所(他市町村住所地特例者情報.get事業者住所());
        他市町村住所地特例者台帳情報.set郵便番号(他市町村住所地特例者情報.get郵便番号());
        他市町村住所地特例者台帳情報.set保険者名称(他市町村住所地特例者情報.get保険者名称());
        他市町村住所地特例者台帳情報.set他被保番号(他市町村住所地特例者情報.get他被保番号());
    }

    private FillTypeFormatted flexibleDateToFillTypeFormatted(FlexibleDate date) {
        return null == date ? FlexibleDate.EMPTY.
                wareki().eraType(EraType.KANJI_RYAKU).firstYear(FirstYear.GAN_NEN).separator(Separator.PERIOD).fillType(FillType.BLANK)
                : date.wareki().eraType(EraType.KANJI_RYAKU).firstYear(FirstYear.GAN_NEN).separator(Separator.PERIOD).fillType(FillType.BLANK);
    }

    /**
     * 住所を編集します。
     *
     * @param dateTime
     * @return システム日時（ggyy年mm月dd日　hh時mm分ss秒　作成)
     */
    private RString dateTimeEdit(RDateTime dateTime) {
        RString dateTimeEdit = new FlexibleDate(dateTime.getDate().toDateString()).seireki().separator(Separator.JAPANESE)
                .fillType(FillType.ZERO).toDateString();
        dateTimeEdit.concat(SPACE).concat(intToRString(dateTime.getHour())).concat(HOUR).concat(intToRString(dateTime.getMinute()))
                .concat(MINUTE).concat(intToRString(dateTime.getSecond())).concat(SECOND);
        return dateTimeEdit;
    }

    private RString intToRString(int number) {
        return new RString((new Integer(number)).toString());
    }

    /**
     * 住所を編集します。
     *
     * @param jusho jusho
     * @return 編集後住所
     */
    private RString atenaJushoToRString(AtenaJusho jusho) {
        RString jushoRString = jusho.getColumnValue();
        RString jushoEdit;
        int length = jushoRString.length();
        if (length > 0 && length <= 40) {
            jushoEdit = jushoRString;
        } else if (length > 40 && length <= 80) {
            jushoEdit = jushoRString.substring(0, 39).concat(CHANGE_LINE).concat(jushoRString.substring(40, length - 1));
        } else if (length > 80 && length <= 120) {
            jushoEdit = jushoRString.substring(0, 39).concat(CHANGE_LINE).concat(jushoRString.substring(40, 79))
                    .concat(CHANGE_LINE).concat(jushoRString.substring(80, length - 1));
        } else if (length > 120) {
            jushoEdit = jushoRString.substring(0, 39).concat(CHANGE_LINE).concat(jushoRString.substring(40, 79))
                    .concat(CHANGE_LINE).concat(jushoRString.substring(80, 119));
        } else {
            jushoEdit = RString.EMPTY;
        }
        return jushoEdit;
    }

    /**
     * 他市町村住所地特例者情報を取得します。
     *
     * @param 識別コード 識別コード
     * @return 他市町村住所地特例者情報Entityリスト
     */
    private List<OtherAddressInfEntity> get他市町村住所地特例者情報(ShikibetsuCode 識別コード) {
        OtherAddressInformationParameter 検索条件 = OtherAddressInformationParameter.createParam_ServiceOtherAddressInformation(識別コード);
        MapperProvider mapperProvider = InstanceProvider.create(MapperProvider.class);
        IOtherAddressInformationMapper otherAddressInfMapper = mapperProvider.create(IOtherAddressInformationMapper.class);
        List<OtherAddressInfFromDBEntity> 他市町村住所地特例者情報Lst = otherAddressInfMapper.get他市町村住所地特例者情報の取得処理(検索条件);
        List<OtherAddressInfEntity> otherAddressInfEntityLst = new ArrayList<>();
        int no = 1;
        for (OtherAddressInfFromDBEntity otherAddressInfFromDBEntity : 他市町村住所地特例者情報Lst) {
            RString 適用事由名称 = CodeMaster.getCodeMeisho(SubGyomuCode.DBA介護資格, new CodeShubetsu("0008"),
                    new Code(otherAddressInfFromDBEntity.get他市町村住所地特例適用事由コード()));
            RString 解除事由名称 = CodeMaster.getCodeMeisho(SubGyomuCode.DBA介護資格, new CodeShubetsu("0011"),
                    new Code(otherAddressInfFromDBEntity.get他市町村住所地特例解除事由コード()));
            OtherAddressInfEntity otherAddressInfEntity = new OtherAddressInfEntity();
            set他市町村住所地特例者情報(otherAddressInfEntity, otherAddressInfFromDBEntity, no, 適用事由名称, 解除事由名称);
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
            Integer no, RString 適用事由名称, RString 解除事由名称) {
        他市町村住所地特例者情報.setNO(new RString(no.toString()));
        他市町村住所地特例者情報.set事業者住所(otherAddressInfFromDBEntity.get事業者住所());
        他市町村住所地特例者情報.set事業者名称(otherAddressInfFromDBEntity.get事業者名称());
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
