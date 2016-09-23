/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.core.hikazeinenkintaishosha;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbd.definition.core.hikazeinenkin.KakushuKubun;
import jp.co.ndensan.reams.db.dbd.definition.core.hikazeinenkin.ShoriKekka;
import jp.co.ndensan.reams.db.dbd.definition.core.hikazeinenkin.TeiseiHyoji;
import jp.co.ndensan.reams.db.dbd.definition.core.hikazeinenkin.TorokuKubun;
import jp.co.ndensan.reams.db.dbd.definition.core.hikazeinenkin.TsuchiNaiyoCode;
import jp.co.ndensan.reams.db.dbd.definition.mybatisprm.hikazeinenkintaishosha.HikazeiNenkinTaishoshaMybatisParameter;
import jp.co.ndensan.reams.db.dbd.definition.processprm.hikazeinenkintaishosha.HikazeiNenkinTaishoshaProcessParameter;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.hanyolisthikazeinenkintaishosha.HikazeiNenkinTaishoshaEntity;
import jp.co.ndensan.reams.db.dbd.entity.euc.hikazeinenkintaishosha.HikazeiNenkinTaishoshaReibanAriEUCEntity;
import jp.co.ndensan.reams.db.dbd.entity.euc.hikazeinenkintaishosha.HikazeiNenkinTaishoshaReibanNashiEUCEntity;
import jp.co.ndensan.reams.db.dbx.business.core.koseishichoson.KoseiShichosonMaster;
import jp.co.ndensan.reams.ua.uax.business.core.atesaki.AtesakiFactory;
import jp.co.ndensan.reams.ua.uax.business.core.atesaki.IAtesaki;
import jp.co.ndensan.reams.ua.uax.business.core.psm.UaFt200FindShikibetsuTaishoFunction;
import jp.co.ndensan.reams.ua.uax.business.core.psm.UaFt250FindAtesakiFunction;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.IShikibetsuTaisho;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.ShikibetsuTaishoFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.kojin.IKojin;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.AtenaSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.AtesakiGyomuHanteiKeyFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoGyomuHanteiKeyFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.KensakuYusenKubun;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.psm.DataShutokuKubun;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt250FindAtesakiEntity;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.core.jusho.banchi.Banchi;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.Katagaki;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.PersonalData;
import jp.co.ndensan.reams.ue.uex.definition.core.SeibetsuCodeNenkinTokuchoType;
import jp.co.ndensan.reams.ur.urz.business.config.jushoinput.IJushoNyuryokuConfig;
import jp.co.ndensan.reams.ur.urz.business.config.jushoinput.JushoNyuryokuConfigFactory;
import jp.co.ndensan.reams.ur.urz.definition.core.config.jushoinput.ConfigKeysCodeName;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.JuminJotai;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.JuminShubetsu;
import jp.co.ndensan.reams.uz.uza.biz.ChikuCode;
import jp.co.ndensan.reams.uz.uza.biz.ChoikiCode;
import jp.co.ndensan.reams.uz.uza.biz.GyoseikuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogger;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.uuid.AccessLogUUID;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.spool.entities.UzUDE0835SpoolOutputType;
import jp.co.ndensan.reams.uz.uza.util.editor.DecimalFormatter;
import lombok.Getter;
import lombok.Setter;

/**
 * 汎用リスト出力(非課税年金対象者)ビジネスのクラスです
 *
 * @reamsid_L DBD-5820-030 zhengsongling
 */
@Getter
@Setter
public class HikazeiNenkinTaishosha {

    private static final RString 年度 = new RString("年度");
    private static final RString 拡張情報_NAME = new RString("被保険者番号");
    private static final Code 拡張情報_CODE = new Code("0003");
    private static final RString 金額_ZERO = new RString("0");
    private static final RString RHKAKKO = new RString("）");
    private static final RString LFKAKKO = new RString("（");
    private static final RString EMPTY = new RString("　");
    private static final RString TILDE = new RString("　～　");
    private static final RString KORUN = new RString(":");
    private static final RString 空白 = new RString(" ");
    private static final RString 抽出対象者 = new RString("【抽出対象者】");
    private static final RString 市町村コード = new RString("000000");
    private static final RString 保険者 = new RString("保険者：");
    private static final RString 市 = new RString("市");
    private static final RString 年指定_年度 = new RString("11");
    private static final RString 年指定_年 = new RString("12");
    private static final RString 登録年度 = new RString("取込・登録年度：");
    private static final RString 非課税年金受給年 = new RString("非課税年金受給年：");
    private static final RString 最新情報 = new RString("（最新情報）");
    private static final RString 被保険者抽出_被保険者のみ = new RString("1");
    private static final RString 被保険者抽出_被保険者以外のみ = new RString("2");
    private static final RString 抽出対象 = new RString("抽出対象：");
    private static final RString 被保険者のみ = new RString("被保険者のみ");
    private static final RString 被保険者以外のみ = new RString("被保険者以外のみ");
    private static final RString 年齢 = new RString("年齢：");
    private static final RString 歳 = new RString("歳");
    private static final RString 年齢_年齢基準日 = new RString("　　（年齢基準日：");
    private static final RString 生年月日 = new RString("生年月日：");
    private static final RString 町域 = new RString("町域：");
    private static final RString 行政区 = new RString("行政区：");
    private final HikazeiNenkinTaishoshaProcessParameter processParameter;
    private List<PersonalData> personalDataList;

    /**
     * コンストラクタです。
     *
     * @param processParameter processParameter
     */
    public HikazeiNenkinTaishosha(HikazeiNenkinTaishoshaProcessParameter processParameter) {
        this.processParameter = processParameter;
        personalDataList = new ArrayList<>();
    }

    /**
     * MybatisParameterを設定するメッソドです。
     *
     * @return KijunShunyugakuTekiyoMybatisParameter
     */
    public HikazeiNenkinTaishoshaMybatisParameter createMybatisParameter() {
        ShikibetsuTaishoSearchKeyBuilder key = new ShikibetsuTaishoSearchKeyBuilder(
                ShikibetsuTaishoGyomuHanteiKeyFactory.createInstance(GyomuCode.DB介護保険, KensakuYusenKubun.住登外優先), true);
        key.setデータ取得区分(DataShutokuKubun.直近レコード);
        List<JuminShubetsu> 住民種別 = new ArrayList<>();
        住民種別.add(JuminShubetsu.日本人);
        住民種別.add(JuminShubetsu.外国人);
        住民種別.add(JuminShubetsu.住登外個人_日本人);
        住民種別.add(JuminShubetsu.住登外個人_外国人);
        List<JuminJotai> 住民状態 = new ArrayList<>();
        住民状態.add(JuminJotai.住登外);
        住民状態.add(JuminJotai.消除者);
        住民状態.add(JuminJotai.転出者);
        住民状態.add(JuminJotai.死亡者);
        key.set住民種別(住民種別);
        key.set住民状態(住民状態);
        key.set町域コード開始値(get町域コード(processParameter.get宛名抽出条件().getJusho_From()));
        key.set町域コード終了値(get町域コード(processParameter.get宛名抽出条件().getJusho_To()));
        key.set行政区コード開始値(get行政区コード(processParameter.get宛名抽出条件().getGyoseiku_From()));
        key.set行政区コード終了値(get行政区コード(processParameter.get宛名抽出条件().getGyoseiku_To()));
        key.set地区コード1開始値(get地区コード(processParameter.get宛名抽出条件().getChiku1_From()));
        key.set地区コード1終了値(get地区コード(processParameter.get宛名抽出条件().getChiku1_To()));
        key.set地区コード2開始値(get地区コード(processParameter.get宛名抽出条件().getChiku2_From()));
        key.set地区コード2終了値(get地区コード(processParameter.get宛名抽出条件().getChiku2_To()));
        key.set地区コード3開始値(get地区コード(processParameter.get宛名抽出条件().getChiku3_From()));
        key.set地区コード3終了値(get地区コード(processParameter.get宛名抽出条件().getChiku3_To()));
        UaFt200FindShikibetsuTaishoFunction uaFt200Psm = new UaFt200FindShikibetsuTaishoFunction(key.getPSM検索キー());
        AtenaSearchKeyBuilder atenaSearchKeyBuilder = new AtenaSearchKeyBuilder(
                KensakuYusenKubun.住登外優先, AtesakiGyomuHanteiKeyFactory.createInstace(GyomuCode.DB介護保険, SubGyomuCode.DBD介護受給));
        UaFt250FindAtesakiFunction uaFt250Psm = new UaFt250FindAtesakiFunction(atenaSearchKeyBuilder.build().get宛先検索キー());
        RString psmAtesaki = new RString(uaFt250Psm.getParameterMap().get("psmAtesaki").toString());
        RString psmShikibetsuTaisho = new RString(uaFt200Psm.getParameterMap().get("psmShikibetsuTaisho").toString());
        return HikazeiNenkinTaishoshaMybatisParameter.createMybatisParameter(
                processParameter.get抽出方法(),
                processParameter.get被保険者抽出方法(),
                processParameter.get宛名抽出条件(),
                processParameter.is最新情報(),
                processParameter.get抽出年度(),
                processParameter.getDate(),
                psmShikibetsuTaisho,
                psmAtesaki);
    }

    private ChikuCode get地区コード(RString value) {
        if (RString.isNullOrEmpty(value)) {
            return ChikuCode.EMPTY;
        } else {
            return new ChikuCode(value);
        }
    }

    private GyoseikuCode get行政区コード(RString value) {
        if (RString.isNullOrEmpty(value)) {
            return GyoseikuCode.EMPTY;
        } else {
            return new GyoseikuCode(value);
        }
    }

    private ChoikiCode get町域コード(RString value) {
        if (RString.isNullOrEmpty(value)) {
            return ChoikiCode.EMPTY;
        } else {
            return new ChoikiCode(value);
        }
    }

    /**
     * HikazeiNenkinTaishoshaReibanAriEUCEntityの設定クラスです。
     *
     * @param entity entity
     * @param 連番 連番
     * @param 市町村名MasterMap 市町村名MasterMap
     * @param association association
     * @return HikazeiNenkinTaishoshaReibanAriEUCEntity
     */
    public HikazeiNenkinTaishoshaReibanAriEUCEntity set連番ありEUCEntity(HikazeiNenkinTaishoshaEntity entity, int 連番,
            Map<RString, KoseiShichosonMaster> 市町村名MasterMap, Association association) {
        HikazeiNenkinTaishoshaReibanAriEUCEntity eucEntity = new HikazeiNenkinTaishoshaReibanAriEUCEntity();
        UaFt200FindShikibetsuTaishoEntity 宛名Entity = entity.getPsmEntity();
        if (宛名Entity != null) {
            IShikibetsuTaisho iShikibetsuTaisho = ShikibetsuTaishoFactory.createKojin(宛名Entity);
            IKojin iKojin = iShikibetsuTaisho.to個人();
            personalDataList.add(toPersonalData(entity.get被保険者番号(), iKojin.get識別コード()));
            eucEntity.set連番(new RString(連番));
            eucEntity.set識別コード(iKojin.get識別コード());
            eucEntity.set住民種別(iKojin.get住民種別());
            eucEntity.set氏名(iKojin.get名称().getName());
            eucEntity.set氏名カナ(iKojin.get名称().getKana());
            eucEntity.set生年月日(set日付編集(iKojin.get生年月日().toFlexibleDate()));
            eucEntity.set年齢(iKojin.get年齢算出().get年齢());
            eucEntity.set性別(iKojin.get性別().getName().getShortJapanese());
            eucEntity.set続柄コード(iKojin.get続柄コードリスト().toTsuzukigaraCode());
            eucEntity.set世帯コード(iKojin.get世帯コード());
            eucEntity.set世帯主名(iKojin.get世帯主名());
            eucEntity.set住所コード(iKojin.get住所().get全国住所コード());
            eucEntity.set郵便番号(iKojin.get住所().get郵便番号().getEditedYubinNo());
            eucEntity.set住所_番地_方書(get住所_番地_方書(iKojin.get住所().get住所(), get番地(iKojin.get住所().get番地()),
                    get方書(iKojin.get住所().get方書())));
            eucEntity.set住所(iKojin.get住所().get住所());
            eucEntity.set番地(get番地(iKojin.get住所().get番地()));
            eucEntity.set方書(get方書(iKojin.get住所().get方書()));
            eucEntity.set行政区コード(iKojin.get行政区画().getGyoseiku().getコード());
            eucEntity.set行政区名(iKojin.get行政区画().getGyoseiku().get名称());
            eucEntity.set地区１(iKojin.get行政区画().getChiku1().getコード());
            eucEntity.set地区２(iKojin.get行政区画().getChiku2().getコード());
            eucEntity.set地区３(iKojin.get行政区画().getChiku3().getコード());
            eucEntity.set連絡先１(iKojin.get連絡先１());
            eucEntity.set連絡先２(iKojin.get連絡先２());
            eucEntity.set登録異動日(set日付編集(iKojin.get登録異動年月日()));
            eucEntity.set登録事由(iKojin.get登録事由());
            eucEntity.set登録届出日(set日付編集(iKojin.get登録届出年月日()));
            eucEntity.set住定異動日(set日付編集(iKojin.get住定異動年月日()));
            eucEntity.set住定事由(iKojin.get住定事由());
            eucEntity.set住定届出日(set日付編集(iKojin.get住定届出年月日()));
            eucEntity.set消除異動日(set日付編集(iKojin.get住定異動年月日()));
            eucEntity.set消除事由(iKojin.get消除事由());
            eucEntity.set消除届出日(set日付編集(iKojin.get住定届出年月日()));
            eucEntity.set転出入理由(RString.EMPTY);
            eucEntity.set前住所郵便番号(iKojin.get転入前().get郵便番号());
            eucEntity.set前住所_番地_方書(get住所_番地_方書(iKojin.get転入前().get住所(), get番地(iKojin.get転入前().get番地()),
                    get方書(iKojin.get転入前().get方書())));
            eucEntity.set前住所(iKojin.get転入前().get住所());
            eucEntity.set前住所番地(get番地(iKojin.get転入前().get番地()));
            eucEntity.set前住所方書(get方書(iKojin.get転入前().get方書()));
        }
        eucEntity.set市町村コード(entity.get市町村コード());
        if (市町村名MasterMap != null && !市町村名MasterMap.isEmpty()) {
            eucEntity.set市町村名(市町村名MasterMap.get(entity.get市町村コード()).get市町村名称());
        }
        eucEntity.set保険者コード(association.get地方公共団体コード());
        eucEntity.set保険者名(association.get市町村名());
        eucEntity.set空白(空白);
        UaFt250FindAtesakiEntity 宛先Entity = entity.getAtesakiEntity();
        if (宛先Entity != null) {
            IAtesaki iAtesaki = AtesakiFactory.createInstance(宛先Entity);
            eucEntity.set送付先氏名(iAtesaki.get宛先名称().getName());
            eucEntity.set送付先氏名カナ(iAtesaki.get宛先名称().getKana());
            eucEntity.set送付先住所コード(iAtesaki.get宛先住所().get全国住所コード());
            eucEntity.set送付先郵便番号(iAtesaki.get宛先住所().get郵便番号().getEditedYubinNo());
            eucEntity.set送付先住所_番地_方書(get住所_番地_方書(iAtesaki.get宛先住所().get住所(), get番地(iAtesaki.get宛先住所().get番地()),
                    get方書(iAtesaki.get宛先住所().get方書())));
            eucEntity.set送付先住所(iAtesaki.get宛先住所().get住所());
            eucEntity.set送付先番地(get番地(iAtesaki.get宛先住所().get番地()));
            eucEntity.set送付先方書(get方書(iAtesaki.get宛先住所().get方書()));
            eucEntity.set送付先行政区コード(iAtesaki.get宛先行政区().getコード());
            eucEntity.set送付先行政区名(iAtesaki.get宛先行政区().get名称());
        }
        eucEntity.set被保険者番号(entity.get被保険者番号());
        eucEntity.set年度(get年度(entity.get年度()));
        //eucEntity.set処理区分(RString.EMPTY); Enum存在しない。
        eucEntity.set対象月(entity.get対象月());
        eucEntity.set基礎年金番号(entity.get基礎年金番号());
        eucEntity.set現基礎年金番号(entity.get現基礎年金番号());
        eucEntity.set年金コード(entity.get年金コード());
        eucEntity.setIf市町村コード(entity.getIf市町村コード());
        eucEntity.setIf年金保険者コード(entity.getIf年金保険者コード());
        eucEntity.setIf通知内容コード(TsuchiNaiyoCode.toValue(entity.getIf通知内容コード()).get名称());
        eucEntity.setIf作成年月日(entity.getIf作成年月日());
        eucEntity.setIf性別(SeibetsuCodeNenkinTokuchoType.toValue(entity.getIf性別()).get性別名称());
        eucEntity.setIfカナ氏名(entity.getIfカナ氏名());
        eucEntity.setIf漢字氏名(entity.getIf漢字氏名());
        eucEntity.setIf郵便番号(entity.getIf郵便番号());
        eucEntity.setIfカナ住所(entity.getIfカナ住所());
        eucEntity.setIf漢字住所(entity.getIf漢字住所());
        eucEntity.setIf対象年(get対象年(entity.getIf対象年()));
        eucEntity.setIf訂正表示(TeiseiHyoji.toValue(entity.getIf訂正表示()).get名称());
        eucEntity.setIf各種区分(KakushuKubun.toValue(entity.getIf各種区分()).get名称());
        eucEntity.setIf処理結果(ShoriKekka.toValue(entity.getIf処理結果()).get名称());
        eucEntity.setIf金額１(toDecimal(entity.getIf金額１()));
        eucEntity.set登録区分(TorokuKubun.toValue(entity.get登録区分()).get名称());
        return eucEntity;
    }

    /**
     * HikazeiNenkinTaishoshaReibanAriEUCEntityの設定クラスです。
     *
     * @return HikazeiNenkinTaishoshaReibanAriEUCEntity
     */
    public HikazeiNenkinTaishoshaReibanAriEUCEntity set連番ありEUCEntity() {
        HikazeiNenkinTaishoshaReibanAriEUCEntity eucEntity = new HikazeiNenkinTaishoshaReibanAriEUCEntity();
        eucEntity.set連番(null);
        eucEntity.set識別コード(null);
        eucEntity.set住民種別(null);
        eucEntity.set氏名(null);
        eucEntity.set氏名カナ(null);
        eucEntity.set生年月日(null);
        eucEntity.set年齢(null);
        eucEntity.set性別(null);
        eucEntity.set続柄コード(null);
        eucEntity.set世帯コード(null);
        eucEntity.set世帯主名(null);
        eucEntity.set住所コード(null);
        eucEntity.set郵便番号(null);
        eucEntity.set住所_番地_方書(null);
        eucEntity.set住所(null);
        eucEntity.set番地(null);
        eucEntity.set方書(null);
        eucEntity.set行政区コード(null);
        eucEntity.set行政区名(null);
        eucEntity.set地区１(null);
        eucEntity.set地区２(null);
        eucEntity.set地区３(null);
        eucEntity.set連絡先１(null);
        eucEntity.set連絡先２(null);
        eucEntity.set登録異動日(null);
        eucEntity.set登録事由(null);
        eucEntity.set登録届出日(null);
        eucEntity.set住定異動日(null);
        eucEntity.set住定事由(null);
        eucEntity.set住定届出日(null);
        eucEntity.set消除異動日(null);
        eucEntity.set消除事由(null);
        eucEntity.set消除届出日(null);
        eucEntity.set転出入理由(null);
        eucEntity.set前住所郵便番号(null);
        eucEntity.set前住所_番地_方書(null);
        eucEntity.set前住所(null);
        eucEntity.set前住所番地(null);
        eucEntity.set前住所方書(null);
        eucEntity.set市町村コード(null);
        eucEntity.set市町村名(null);
        eucEntity.set保険者コード(null);
        eucEntity.set保険者名(null);
        eucEntity.set空白(null);
        eucEntity.set送付先氏名(null);
        eucEntity.set送付先氏名カナ(null);
        eucEntity.set送付先住所コード(null);
        eucEntity.set送付先郵便番号(null);
        eucEntity.set送付先住所_番地_方書(null);
        eucEntity.set送付先住所(null);
        eucEntity.set送付先番地(null);
        eucEntity.set送付先方書(null);
        eucEntity.set送付先行政区コード(null);
        eucEntity.set送付先行政区名(null);
        eucEntity.set被保険者番号(null);
        eucEntity.set年度(null);
        eucEntity.set処理区分(null);
        eucEntity.set対象月(null);
        eucEntity.set基礎年金番号(null);
        eucEntity.set現基礎年金番号(null);
        eucEntity.set年金コード(null);
        eucEntity.setIf市町村コード(null);
        eucEntity.setIf年金保険者コード(null);
        eucEntity.setIf通知内容コード(null);
        eucEntity.setIf作成年月日(null);
        eucEntity.setIf性別(null);
        eucEntity.setIfカナ氏名(null);
        eucEntity.setIf漢字氏名(null);
        eucEntity.setIf郵便番号(null);
        eucEntity.setIfカナ住所(null);
        eucEntity.setIf漢字住所(null);
        eucEntity.setIf対象年(null);
        eucEntity.setIf訂正表示(null);
        eucEntity.setIf各種区分(null);
        eucEntity.setIf処理結果(null);
        eucEntity.setIf金額１(null);
        eucEntity.set登録区分(null);
        return eucEntity;
    }

    /**
     * HikazeiNenkinTaishoshaReibanNashiEUCEntityの設定クラスです。
     *
     * @param entity entity
     * @param 市町村名MasterMap 市町村名MasterMap
     * @param association association
     * @return HikazeiNenkinTaishoshaReibanNashiEUCEntity
     */
    public HikazeiNenkinTaishoshaReibanNashiEUCEntity set連番なしEUCEntity(HikazeiNenkinTaishoshaEntity entity,
            Map<RString, KoseiShichosonMaster> 市町村名MasterMap, Association association) {
        HikazeiNenkinTaishoshaReibanNashiEUCEntity eucEntity = new HikazeiNenkinTaishoshaReibanNashiEUCEntity();
        UaFt200FindShikibetsuTaishoEntity 宛名Entity = entity.getPsmEntity();
        if (宛名Entity != null) {
            IShikibetsuTaisho iShikibetsuTaisho = ShikibetsuTaishoFactory.createKojin(宛名Entity);
            IKojin iKojin = iShikibetsuTaisho.to個人();
            personalDataList.add(toPersonalData(entity.get被保険者番号(), iKojin.get識別コード()));
            eucEntity.set識別コード(iKojin.get識別コード());
            eucEntity.set住民種別(iKojin.get住民種別());
            eucEntity.set氏名(iKojin.get名称().getName());
            eucEntity.set氏名カナ(iKojin.get名称().getKana());
            eucEntity.set生年月日(set日付編集(iKojin.get生年月日().toFlexibleDate()));
            eucEntity.set年齢(iKojin.get年齢算出().get年齢());
            eucEntity.set性別(iKojin.get性別().getName().getShortJapanese());
            eucEntity.set続柄コード(iKojin.get続柄コードリスト().toTsuzukigaraCode());
            eucEntity.set世帯コード(iKojin.get世帯コード());
            eucEntity.set世帯主名(iKojin.get世帯主名());
            eucEntity.set住所コード(iKojin.get住所().get全国住所コード());
            eucEntity.set郵便番号(iKojin.get住所().get郵便番号().getEditedYubinNo());
            eucEntity.set住所_番地_方書(get住所_番地_方書(iKojin.get住所().get住所(), get番地(iKojin.get住所().get番地()),
                    get方書(iKojin.get住所().get方書())));
            eucEntity.set住所(iKojin.get住所().get住所());
            eucEntity.set番地(get番地(iKojin.get住所().get番地()));
            eucEntity.set方書(get方書(iKojin.get住所().get方書()));
            eucEntity.set行政区コード(iKojin.get行政区画().getGyoseiku().getコード());
            eucEntity.set行政区名(iKojin.get行政区画().getGyoseiku().get名称());
            eucEntity.set地区１(iKojin.get行政区画().getChiku1().getコード());
            eucEntity.set地区２(iKojin.get行政区画().getChiku2().getコード());
            eucEntity.set地区３(iKojin.get行政区画().getChiku3().getコード());
            eucEntity.set連絡先１(iKojin.get連絡先１());
            eucEntity.set連絡先２(iKojin.get連絡先２());
            eucEntity.set登録異動日(set日付編集(iKojin.get登録異動年月日()));
            eucEntity.set登録事由(iKojin.get登録事由());
            eucEntity.set登録届出日(set日付編集(iKojin.get登録届出年月日()));
            eucEntity.set住定異動日(set日付編集(iKojin.get住定異動年月日()));
            eucEntity.set住定事由(iKojin.get住定事由());
            eucEntity.set住定届出日(set日付編集(iKojin.get住定届出年月日()));
            eucEntity.set消除異動日(set日付編集(iKojin.get住定異動年月日()));
            eucEntity.set消除事由(iKojin.get消除事由());
            eucEntity.set消除届出日(set日付編集(iKojin.get住定届出年月日()));
            eucEntity.set転出入理由(RString.EMPTY);
            eucEntity.set前住所郵便番号(iKojin.get転入前().get郵便番号());
            eucEntity.set前住所_番地_方書(get住所_番地_方書(iKojin.get転入前().get住所(), get番地(iKojin.get転入前().get番地()),
                    get方書(iKojin.get転入前().get方書())));
            eucEntity.set前住所(iKojin.get転入前().get住所());
            eucEntity.set前住所番地(get番地(iKojin.get転入前().get番地()));
            eucEntity.set前住所方書(get方書(iKojin.get転入前().get方書()));
        }
        eucEntity.set市町村コード(entity.get市町村コード());
        if (市町村名MasterMap != null && !市町村名MasterMap.isEmpty()) {
            eucEntity.set市町村名(市町村名MasterMap.get(entity.get市町村コード()).get市町村名称());
        }
        eucEntity.set保険者コード(association.get地方公共団体コード());
        eucEntity.set保険者名(association.get市町村名());
        eucEntity.set空白(空白);
        UaFt250FindAtesakiEntity 宛先Entity = entity.getAtesakiEntity();
        if (宛先Entity != null) {
            IAtesaki iAtesaki = AtesakiFactory.createInstance(宛先Entity);
            eucEntity.set送付先氏名(iAtesaki.get宛先名称().getName());
            eucEntity.set送付先氏名カナ(iAtesaki.get宛先名称().getKana());
            eucEntity.set送付先住所コード(iAtesaki.get宛先住所().get全国住所コード());
            eucEntity.set送付先郵便番号(iAtesaki.get宛先住所().get郵便番号().getEditedYubinNo());
            eucEntity.set送付先住所_番地_方書(get住所_番地_方書(iAtesaki.get宛先住所().get住所(), get番地(iAtesaki.get宛先住所().get番地()),
                    get方書(iAtesaki.get宛先住所().get方書())));
            eucEntity.set送付先住所(iAtesaki.get宛先住所().get住所());
            eucEntity.set送付先番地(get番地(iAtesaki.get宛先住所().get番地()));
            eucEntity.set送付先方書(get方書(iAtesaki.get宛先住所().get方書()));
            eucEntity.set送付先行政区コード(iAtesaki.get宛先行政区().getコード());
            eucEntity.set送付先行政区名(iAtesaki.get宛先行政区().get名称());
        }
        eucEntity.set被保険者番号(entity.get被保険者番号());
        eucEntity.set年度(get年度(entity.get年度()));
        //eucEntity.set処理区分(RString.EMPTY); Enum存在しない。
        eucEntity.set対象月(entity.get対象月());
        eucEntity.set基礎年金番号(entity.get基礎年金番号());
        eucEntity.set現基礎年金番号(entity.get現基礎年金番号());
        eucEntity.set年金コード(entity.get年金コード());
        eucEntity.setIf市町村コード(entity.getIf市町村コード());
        eucEntity.setIf年金保険者コード(entity.getIf年金保険者コード());
        eucEntity.setIf通知内容コード(TsuchiNaiyoCode.toValue(entity.getIf通知内容コード()).get名称());
        eucEntity.setIf作成年月日(entity.getIf作成年月日());
        eucEntity.setIf性別(SeibetsuCodeNenkinTokuchoType.toValue(entity.getIf性別()).get性別名称());
        eucEntity.setIfカナ氏名(entity.getIfカナ氏名());
        eucEntity.setIf漢字氏名(entity.getIf漢字氏名());
        eucEntity.setIf郵便番号(entity.getIf郵便番号());
        eucEntity.setIfカナ住所(entity.getIfカナ住所());
        eucEntity.setIf漢字住所(entity.getIf漢字住所());
        eucEntity.setIf対象年(get対象年(entity.getIf対象年()));
        eucEntity.setIf訂正表示(TeiseiHyoji.toValue(entity.getIf訂正表示()).get名称());
        eucEntity.setIf各種区分(KakushuKubun.toValue(entity.getIf各種区分()).get名称());
        eucEntity.setIf処理結果(ShoriKekka.toValue(entity.getIf処理結果()).get名称());
        eucEntity.setIf金額１(toDecimal(entity.getIf金額１()));
        eucEntity.set登録区分(TorokuKubun.toValue(entity.get登録区分()).get名称());
        return eucEntity;
    }

    /**
     * HikazeiNenkinTaishoshaReibanNashiEUCEntityの設定クラスです。
     *
     * @return HikazeiNenkinTaishoshaReibanNashiEUCEntity
     */
    public HikazeiNenkinTaishoshaReibanNashiEUCEntity set連番なしEUCEntity() {
        HikazeiNenkinTaishoshaReibanNashiEUCEntity eucEntity = new HikazeiNenkinTaishoshaReibanNashiEUCEntity();
        eucEntity.set識別コード(null);
        eucEntity.set住民種別(null);
        eucEntity.set氏名(null);
        eucEntity.set氏名カナ(null);
        eucEntity.set生年月日(null);
        eucEntity.set年齢(null);
        eucEntity.set性別(null);
        eucEntity.set続柄コード(null);
        eucEntity.set世帯コード(null);
        eucEntity.set世帯主名(null);
        eucEntity.set住所コード(null);
        eucEntity.set郵便番号(null);
        eucEntity.set住所_番地_方書(null);
        eucEntity.set住所(null);
        eucEntity.set番地(null);
        eucEntity.set方書(null);
        eucEntity.set行政区コード(null);
        eucEntity.set行政区名(null);
        eucEntity.set地区１(null);
        eucEntity.set地区２(null);
        eucEntity.set地区３(null);
        eucEntity.set連絡先１(null);
        eucEntity.set連絡先２(null);
        eucEntity.set登録異動日(null);
        eucEntity.set登録事由(null);
        eucEntity.set登録届出日(null);
        eucEntity.set住定異動日(null);
        eucEntity.set住定事由(null);
        eucEntity.set住定届出日(null);
        eucEntity.set消除異動日(null);
        eucEntity.set消除事由(null);
        eucEntity.set消除届出日(null);
        eucEntity.set転出入理由(null);
        eucEntity.set前住所郵便番号(null);
        eucEntity.set前住所_番地_方書(null);
        eucEntity.set前住所(null);
        eucEntity.set前住所番地(null);
        eucEntity.set前住所方書(null);
        eucEntity.set市町村コード(null);
        eucEntity.set市町村名(null);
        eucEntity.set保険者コード(null);
        eucEntity.set保険者名(null);
        eucEntity.set空白(null);
        eucEntity.set送付先氏名(null);
        eucEntity.set送付先氏名カナ(null);
        eucEntity.set送付先住所コード(null);
        eucEntity.set送付先郵便番号(null);
        eucEntity.set送付先住所_番地_方書(null);
        eucEntity.set送付先住所(null);
        eucEntity.set送付先番地(null);
        eucEntity.set送付先方書(null);
        eucEntity.set送付先行政区コード(null);
        eucEntity.set送付先行政区名(null);
        eucEntity.set被保険者番号(null);
        eucEntity.set年度(null);
        eucEntity.set処理区分(null);
        eucEntity.set対象月(null);
        eucEntity.set基礎年金番号(null);
        eucEntity.set現基礎年金番号(null);
        eucEntity.set年金コード(null);
        eucEntity.setIf市町村コード(null);
        eucEntity.setIf年金保険者コード(null);
        eucEntity.setIf通知内容コード(null);
        eucEntity.setIf作成年月日(null);
        eucEntity.setIf性別(null);
        eucEntity.setIfカナ氏名(null);
        eucEntity.setIf漢字氏名(null);
        eucEntity.setIf郵便番号(null);
        eucEntity.setIfカナ住所(null);
        eucEntity.setIf漢字住所(null);
        eucEntity.setIf対象年(null);
        eucEntity.setIf訂正表示(null);
        eucEntity.setIf各種区分(null);
        eucEntity.setIf処理結果(null);
        eucEntity.setIf金額１(null);
        eucEntity.set登録区分(null);
        return eucEntity;
    }

    /**
     * アクセスログを出力するメッソドです。
     *
     * @return AccessLogUUID
     */
    public AccessLogUUID getアクセスログ() {
        return AccessLogger.logEUC(UzUDE0835SpoolOutputType.EucOther, personalDataList);
    }

    /**
     * 出力条件を作成するメッソドです。
     *
     * @param 市町村名 市町村名
     * @return List<RString>
     */
    public List<RString> set出力条件(RString 市町村名) {
        List<RString> 出力条件List = new ArrayList<>();
        RStringBuilder jokenBuilder = new RStringBuilder();
        jokenBuilder.append(抽出対象者);
        出力条件List.add(jokenBuilder.toRString());
        if (!RString.EMPTY.equals(processParameter.get宛名抽出条件().getShichoson_Code().value())
                && !市町村コード.equals(processParameter.get宛名抽出条件().getShichoson_Code().value())) {
            jokenBuilder = new RStringBuilder();
            jokenBuilder.append(保険者);
            jokenBuilder.append(市町村名);
            jokenBuilder.append(市);
            出力条件List.add(jokenBuilder.toRString());
        }
        if (年指定_年度.equals(processParameter.get抽出方法())) {
            jokenBuilder = new RStringBuilder();
            jokenBuilder.append(登録年度);
            jokenBuilder.append(get年度(processParameter.get抽出年度()));
            出力条件List.add(jokenBuilder.toRString());
        } else if (年指定_年.equals(processParameter.get抽出方法())) {
            jokenBuilder = new RStringBuilder();
            jokenBuilder.append(非課税年金受給年);
            if (processParameter.is最新情報()) {
                jokenBuilder.append(get非課税年金受給年(processParameter.get抽出年度()));
                jokenBuilder.append(最新情報);
            } else {
                jokenBuilder.append(get非課税年金受給年(processParameter.get抽出年度()));
            }
            出力条件List.add(jokenBuilder.toRString());
        }
        if (被保険者抽出_被保険者のみ.equals(processParameter.get被保険者抽出方法())) {
            jokenBuilder = new RStringBuilder();
            jokenBuilder.append(抽出対象);
            jokenBuilder.append(被保険者のみ);
            出力条件List.add(jokenBuilder.toRString());
        } else if (被保険者抽出_被保険者以外のみ.equals(processParameter.get被保険者抽出方法())) {
            jokenBuilder = new RStringBuilder();
            jokenBuilder.append(抽出対象);
            jokenBuilder.append(被保険者以外のみ);
            出力条件List.add(jokenBuilder.toRString());
        }
        set年齢_生年月日(jokenBuilder, 出力条件List);
        set町域_行政区(jokenBuilder, 出力条件List);
        set地区(jokenBuilder, 出力条件List);
        return 出力条件List;
    }

    private void set年齢_生年月日(RStringBuilder jokenBuilder, List<RString> 出力条件List) {
        RDate 年齢基準日 = processParameter.get宛名抽出条件().getNenreiKijunbi();
        if (年齢基準日 != null && !年齢基準日.toDateString().isNullOrEmpty()) {
            jokenBuilder = new RStringBuilder();
            jokenBuilder.append(年齢);
            RString 年齢From = get年齢(processParameter.get宛名抽出条件().getNenreiRange().getFrom());
            RString 年齢To = get年齢(processParameter.get宛名抽出条件().getNenreiRange().getTo());
            if (!年齢From.isNullOrEmpty() && !年齢To.isNullOrEmpty()) {
                jokenBuilder.append(年齢From.padLeft(2));
                jokenBuilder.append(歳);
                jokenBuilder.append(TILDE);
                jokenBuilder.append(年齢To.padLeft(2));
                jokenBuilder.append(歳);
            } else if (!年齢From.isNullOrEmpty() && 年齢To.isNullOrEmpty()) {
                jokenBuilder.append(年齢From.padLeft(2));
                jokenBuilder.append(歳);
                jokenBuilder.append(TILDE);
            } else if (年齢From.isNullOrEmpty() && !年齢To.isNullOrEmpty()) {
                jokenBuilder.append(TILDE);
                jokenBuilder.append(年齢To.padLeft(2));
                jokenBuilder.append(歳);
            }
            jokenBuilder.append(年齢_年齢基準日);
            jokenBuilder.append(年齢基準日.wareki().eraType(EraType.KANJI).firstYear(FirstYear.ICHI_NEN).
                    separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString());
            jokenBuilder.append(RHKAKKO);
            出力条件List.add(jokenBuilder.toRString());
        }
        RDate 生年月日From = processParameter.get宛名抽出条件().getSeinengappiRange().getFrom();
        RDate 生年月日To = processParameter.get宛名抽出条件().getSeinengappiRange().getTo();
        if (!isNullorEmpty(生年月日From) && !isNullorEmpty(生年月日To)) {
            jokenBuilder = new RStringBuilder();
            jokenBuilder.append(生年月日);
            jokenBuilder.append(生年月日From.wareki().eraType(EraType.KANJI).firstYear(FirstYear.ICHI_NEN).
                    separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString());
            jokenBuilder.append(TILDE);
            jokenBuilder.append(生年月日To.wareki().eraType(EraType.KANJI).firstYear(FirstYear.ICHI_NEN).
                    separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString());
            出力条件List.add(jokenBuilder.toRString());
        } else if (!isNullorEmpty(生年月日From) && isNullorEmpty(生年月日To)) {
            jokenBuilder = new RStringBuilder();
            jokenBuilder.append(生年月日);
            jokenBuilder.append(生年月日From.wareki().eraType(EraType.KANJI).firstYear(FirstYear.ICHI_NEN).
                    separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString());
            jokenBuilder.append(TILDE);
            出力条件List.add(jokenBuilder.toRString());
        } else if (isNullorEmpty(生年月日From) && !isNullorEmpty(生年月日To)) {
            jokenBuilder = new RStringBuilder();
            jokenBuilder.append(生年月日);
            jokenBuilder.append(TILDE);
            jokenBuilder.append(生年月日To.wareki().eraType(EraType.KANJI).firstYear(FirstYear.ICHI_NEN).
                    separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString());
            出力条件List.add(jokenBuilder.toRString());
        }
    }

    private void set町域_行政区(RStringBuilder jokenBuilder, List<RString> 出力条件List) {
        RString 町域From = processParameter.get宛名抽出条件().getJusho_From();
        RString 町域To = processParameter.get宛名抽出条件().getJusho_To();
        RString 町域From名称 = processParameter.get宛名抽出条件().getJusho_FromMesho();
        RString 町域To名称 = processParameter.get宛名抽出条件().getJusho_ToMesho();
        if (!RString.isNullOrEmpty(町域From) && !RString.isNullOrEmpty(町域To)) {
            jokenBuilder = new RStringBuilder();
            jokenBuilder.append(町域);
            jokenBuilder.append(LFKAKKO);
            jokenBuilder.append(町域From);
            jokenBuilder.append(RHKAKKO);
            jokenBuilder.append(町域From名称);
            jokenBuilder.append(TILDE);
            jokenBuilder.append(LFKAKKO);
            jokenBuilder.append(町域To);
            jokenBuilder.append(RHKAKKO);
            jokenBuilder.append(町域To名称);
            出力条件List.add(jokenBuilder.toRString());
        } else if (!RString.isNullOrEmpty(町域From) && RString.isNullOrEmpty(町域To)) {
            jokenBuilder = new RStringBuilder();
            jokenBuilder.append(町域);
            jokenBuilder.append(LFKAKKO);
            jokenBuilder.append(町域From);
            jokenBuilder.append(RHKAKKO);
            jokenBuilder.append(町域From名称);
            jokenBuilder.append(TILDE);
            出力条件List.add(jokenBuilder.toRString());
        } else if (RString.isNullOrEmpty(町域From) && !RString.isNullOrEmpty(町域To)) {
            jokenBuilder = new RStringBuilder();
            jokenBuilder.append(町域);
            jokenBuilder.append(TILDE);
            jokenBuilder.append(LFKAKKO);
            jokenBuilder.append(町域To);
            jokenBuilder.append(RHKAKKO);
            jokenBuilder.append(町域To名称);
            出力条件List.add(jokenBuilder.toRString());
        }
        RString 行政区From = processParameter.get宛名抽出条件().getGyoseiku_From();
        RString 行政区To = processParameter.get宛名抽出条件().getGyoseiku_To();
        RString 行政区From名称 = processParameter.get宛名抽出条件().getGyoseiku_FromMesho();
        RString 行政区To名称 = processParameter.get宛名抽出条件().getGyoseiku_ToMesho();
        if (!RString.isNullOrEmpty(行政区From) && !RString.isNullOrEmpty(行政区To)) {
            jokenBuilder = new RStringBuilder();
            jokenBuilder.append(行政区);
            jokenBuilder.append(LFKAKKO);
            jokenBuilder.append(行政区From);
            jokenBuilder.append(RHKAKKO);
            jokenBuilder.append(行政区From名称);
            jokenBuilder.append(TILDE);
            jokenBuilder.append(LFKAKKO);
            jokenBuilder.append(行政区To);
            jokenBuilder.append(RHKAKKO);
            jokenBuilder.append(行政区To名称);
            出力条件List.add(jokenBuilder.toRString());
        } else if (!RString.isNullOrEmpty(行政区From) && RString.isNullOrEmpty(行政区To)) {
            jokenBuilder = new RStringBuilder();
            jokenBuilder.append(行政区);
            jokenBuilder.append(LFKAKKO);
            jokenBuilder.append(行政区From);
            jokenBuilder.append(RHKAKKO);
            jokenBuilder.append(行政区From名称);
            jokenBuilder.append(TILDE);
            出力条件List.add(jokenBuilder.toRString());
        } else if (RString.isNullOrEmpty(行政区From) && !RString.isNullOrEmpty(行政区To)) {
            jokenBuilder = new RStringBuilder();
            jokenBuilder.append(行政区);
            jokenBuilder.append(TILDE);
            jokenBuilder.append(LFKAKKO);
            jokenBuilder.append(行政区To);
            jokenBuilder.append(RHKAKKO);
            jokenBuilder.append(行政区To名称);
            出力条件List.add(jokenBuilder.toRString());
        }
    }

    private void set地区(RStringBuilder jokenBuilder, List<RString> 出力条件List) {
        RString 地区１From = processParameter.get宛名抽出条件().getChiku1_From();
        RString 地区１To = processParameter.get宛名抽出条件().getChiku1_To();
        RString 地区１From名称 = processParameter.get宛名抽出条件().getChiku1_FromMesho();
        RString 地区１To名称 = processParameter.get宛名抽出条件().getChiku1_ToMesho();
        IJushoNyuryokuConfig config = JushoNyuryokuConfigFactory.createInstance();
        RString 名称_地区１ = config.getコード名称(ConfigKeysCodeName.コード名称_地区の分類１);
        if (!RString.isNullOrEmpty(地区１From) && !RString.isNullOrEmpty(地区１To)) {
            jokenBuilder = new RStringBuilder();
            jokenBuilder.append(名称_地区１);
            jokenBuilder.append(KORUN);
            jokenBuilder.append(LFKAKKO);
            jokenBuilder.append(地区１From);
            jokenBuilder.append(RHKAKKO);
            jokenBuilder.append(地区１From名称);
            jokenBuilder.append(TILDE);
            jokenBuilder.append(LFKAKKO);
            jokenBuilder.append(地区１To);
            jokenBuilder.append(RHKAKKO);
            jokenBuilder.append(地区１To名称);
            出力条件List.add(jokenBuilder.toRString());
        } else if (!RString.isNullOrEmpty(地区１From) && RString.isNullOrEmpty(地区１To)) {
            jokenBuilder = new RStringBuilder();
            jokenBuilder.append(名称_地区１);
            jokenBuilder.append(KORUN);
            jokenBuilder.append(LFKAKKO);
            jokenBuilder.append(地区１From);
            jokenBuilder.append(RHKAKKO);
            jokenBuilder.append(地区１From名称);
            jokenBuilder.append(TILDE);
            出力条件List.add(jokenBuilder.toRString());
        } else if (RString.isNullOrEmpty(地区１From) && !RString.isNullOrEmpty(地区１To)) {
            jokenBuilder = new RStringBuilder();
            jokenBuilder.append(名称_地区１);
            jokenBuilder.append(KORUN);
            jokenBuilder.append(TILDE);
            jokenBuilder.append(LFKAKKO);
            jokenBuilder.append(地区１To);
            jokenBuilder.append(RHKAKKO);
            jokenBuilder.append(地区１To名称);
            出力条件List.add(jokenBuilder.toRString());
        }
        RString 地区２From = processParameter.get宛名抽出条件().getChiku2_From();
        RString 地区２To = processParameter.get宛名抽出条件().getChiku2_To();
        RString 地区２From名称 = processParameter.get宛名抽出条件().getChiku2_FromMesho();
        RString 地区２To名称 = processParameter.get宛名抽出条件().getChiku2_ToMesho();
        RString 名称_地区２ = config.getコード名称(ConfigKeysCodeName.コード名称_地区の分類２);
        if (!RString.isNullOrEmpty(地区２From) && !RString.isNullOrEmpty(地区２To)) {
            jokenBuilder = new RStringBuilder();
            jokenBuilder.append(名称_地区２);
            jokenBuilder.append(KORUN);
            jokenBuilder.append(LFKAKKO);
            jokenBuilder.append(地区２From);
            jokenBuilder.append(RHKAKKO);
            jokenBuilder.append(地区２From名称);
            jokenBuilder.append(TILDE);
            jokenBuilder.append(LFKAKKO);
            jokenBuilder.append(地区２To);
            jokenBuilder.append(RHKAKKO);
            jokenBuilder.append(地区２To名称);
            出力条件List.add(jokenBuilder.toRString());
        } else if (!RString.isNullOrEmpty(地区２From) && RString.isNullOrEmpty(地区２To)) {
            jokenBuilder = new RStringBuilder();
            jokenBuilder.append(名称_地区２);
            jokenBuilder.append(KORUN);
            jokenBuilder.append(LFKAKKO);
            jokenBuilder.append(地区２From);
            jokenBuilder.append(RHKAKKO);
            jokenBuilder.append(地区２From名称);
            jokenBuilder.append(TILDE);
            出力条件List.add(jokenBuilder.toRString());
        } else if (RString.isNullOrEmpty(地区２From) && !RString.isNullOrEmpty(地区２To)) {
            jokenBuilder = new RStringBuilder();
            jokenBuilder.append(名称_地区２);
            jokenBuilder.append(KORUN);
            jokenBuilder.append(TILDE);
            jokenBuilder.append(LFKAKKO);
            jokenBuilder.append(地区２To);
            jokenBuilder.append(RHKAKKO);
            jokenBuilder.append(地区２To名称);
            出力条件List.add(jokenBuilder.toRString());
        }
        RString 地区３From = processParameter.get宛名抽出条件().getChiku3_From();
        RString 地区３To = processParameter.get宛名抽出条件().getChiku3_To();
        RString 地区３From名称 = processParameter.get宛名抽出条件().getChiku3_FromMesho();
        RString 地区３To名称 = processParameter.get宛名抽出条件().getChiku3_ToMesho();
        RString 名称_地区３ = config.getコード名称(ConfigKeysCodeName.コード名称_地区の分類３);
        if (!RString.isNullOrEmpty(地区３From) && !RString.isNullOrEmpty(地区３To)) {
            jokenBuilder = new RStringBuilder();
            jokenBuilder.append(名称_地区３);
            jokenBuilder.append(KORUN);
            jokenBuilder.append(LFKAKKO);
            jokenBuilder.append(地区３From);
            jokenBuilder.append(RHKAKKO);
            jokenBuilder.append(地区３From名称);
            jokenBuilder.append(TILDE);
            jokenBuilder.append(LFKAKKO);
            jokenBuilder.append(地区３To);
            jokenBuilder.append(RHKAKKO);
            jokenBuilder.append(地区３To名称);
            出力条件List.add(jokenBuilder.toRString());
        } else if (!RString.isNullOrEmpty(地区３From) && RString.isNullOrEmpty(地区３To)) {
            jokenBuilder = new RStringBuilder();
            jokenBuilder.append(名称_地区３);
            jokenBuilder.append(KORUN);
            jokenBuilder.append(LFKAKKO);
            jokenBuilder.append(地区３From);
            jokenBuilder.append(RHKAKKO);
            jokenBuilder.append(地区３From名称);
            jokenBuilder.append(TILDE);
            出力条件List.add(jokenBuilder.toRString());
        } else if (RString.isNullOrEmpty(地区３From) && !RString.isNullOrEmpty(地区３To)) {
            jokenBuilder = new RStringBuilder();
            jokenBuilder.append(名称_地区３);
            jokenBuilder.append(KORUN);
            jokenBuilder.append(TILDE);
            jokenBuilder.append(LFKAKKO);
            jokenBuilder.append(地区３To);
            jokenBuilder.append(RHKAKKO);
            jokenBuilder.append(地区３To名称);
            出力条件List.add(jokenBuilder.toRString());
        }
    }

    private boolean isNullorEmpty(RDate value) {
        if (value == null) {
            return true;
        } else {
            return value.toDateString().isEmpty();
        }
    }

    private RString get年齢(Decimal value) {
        if (value == null) {
            return RString.EMPTY;
        } else {
            return new RString(value.toString());
        }
    }

    private RString get非課税年金受給年(RString value) {
        if (RString.isNullOrEmpty(value)) {
            return RString.EMPTY;
        } else {
            return new FlexibleDate(value).wareki().eraType(EraType.KANJI).
                    firstYear(FirstYear.ICHI_NEN).separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
        }
    }

    private RString get対象年(RString value) {
        if (RString.isNullOrEmpty(value)) {
            return RString.EMPTY;
        } else {
            return new FlexibleYear(value).wareki().eraType(EraType.KANJI).firstYear(FirstYear.ICHI_NEN).toDateString();
        }
    }

    private RString toDecimal(RString obj) {
        if (RString.isNullOrEmpty(obj)) {
            return 金額_ZERO;
        } else {
            return DecimalFormatter.toコンマ区切りRString(new Decimal(obj.toString()), 0);
        }
    }

    private RString get年度(RString value) {
        if (RString.isNullOrEmpty(value)) {
            return RString.EMPTY;
        } else {
            return new FlexibleYear(value).wareki().eraType(EraType.KANJI).toDateString().concat(年度);
        }
    }

    private PersonalData toPersonalData(RString 被保険者番号, ShikibetsuCode 識別コード) {
        ExpandedInformation expandedInfo = new ExpandedInformation(拡張情報_CODE, 拡張情報_NAME, 被保険者番号);
        return PersonalData.of(識別コード, expandedInfo);
    }

    private RString set日付編集(FlexibleDate value) {
        RString 日付 = RString.EMPTY;
        if (value != null && !value.isEmpty()) {
            if (processParameter.is日付編集()) {
                日付 = value.seireki().separator(Separator.SLASH).fillType(FillType.ZERO).toDateString();
            } else {
                日付 = new RString(value.toString());
            }
        }
        return 日付;
    }

    private RString get番地(Banchi banchi) {
        RString 番地 = RString.EMPTY;
        if (banchi != null) {
            番地 = banchi.getBanchi().value();
        }
        return 番地;
    }

    private RString get方書(Katagaki katagaki) {
        RString 方書 = RString.EMPTY;
        if (katagaki != null) {
            方書 = katagaki.value();
        }
        return 方書;
    }

    private RString get住所_番地_方書(RString 住所, RString 番地, RString 方書) {
        RStringBuilder builder = new RStringBuilder();
        builder.append(住所);
        builder.append(番地);
        builder.append(EMPTY);
        builder.append(方書);
        return builder.toRString();
    }

}
