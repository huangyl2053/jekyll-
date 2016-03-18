/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.service.report.tsuchishohakkogoidosha;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbb.business.core.tsuchishohakkogoidosha.PublishedReportInfo;
import jp.co.ndensan.reams.db.dbb.definition.tsuchishohakkogoidosha.ThreeParamter;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.DbT2017TsuchishoHakkogoIdoshaEntity;
import jp.co.ndensan.reams.db.dbb.entity.tsuchishohakkogoidosha.DbT2017Uaft200EntityResult;
import jp.co.ndensan.reams.db.dbb.persistence.db.basic.DbT2017TsuchishoHakkogoIdoshaDac;
import jp.co.ndensan.reams.db.dbb.persistence.db.mapper.relate.tsuchishohakkogoidohaaku.ITsuchiShoHakkogoIdoHaakuMapper;
import jp.co.ndensan.reams.db.dbb.service.core.MapperProvider;
import jp.co.ndensan.reams.ua.uax.business.core.idoruiseki.ShikibetsuTaishoIdoJoho;
import jp.co.ndensan.reams.ua.uax.business.core.idoruiseki.ShikibetsuTaishoIdoSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.idoruiseki.ShikibetsuTaishoIdoChushutsuKubun;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.idoruiseki.ShikibetsuTaishoIdoSearchKey;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt001FindIdoEntity;
import jp.co.ndensan.reams.ua.uax.service.core.idoruiseki.ShikibetsuTaishoIdoFinder;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.JuminJotai;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.JuminShubetsu;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.idojiyu.JukiIdoJiyu;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.idojiyu.JutogaiIdoJiyu;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.api.ReportInfo;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 通知書発行後異動把握
 */
public class TsuchiShoHakkogoIdoHaaku {

    private final DbT2017TsuchishoHakkogoIdoshaDac dac;
    private final MapperProvider mapperProvider;
    private static final List<JukiIdoJiyu> 空のコード = new ArrayList<>();
    private static final List<JutogaiIdoJiyu> 空のコード2 = new ArrayList<>();
    private static final List<JuminShubetsu> 空のコード3 = new ArrayList<>();
    private static final List<JuminJotai> 空のコード4 = new ArrayList<>();

    public TsuchiShoHakkogoIdoHaaku() {
        dac = InstanceProvider.create(DbT2017TsuchishoHakkogoIdoshaDac.class);
        mapperProvider = InstanceProvider.create(MapperProvider.class);
    }

    TsuchiShoHakkogoIdoHaaku(DbT2017TsuchishoHakkogoIdoshaDac dac,
            MapperProvider mapperProvider) {
        this.dac = dac;
        this.mapperProvider = mapperProvider;
    }

    /**
     * TsuchiShoHakkogoIdoHaaku
     *
     * @return TsuchiShoHakkogoIdoHaaku
     */
    public static TsuchiShoHakkogoIdoHaaku createInstance() {
        return InstanceProvider.create(TsuchiShoHakkogoIdoHaaku.class);
    }

    /**
     * get帳票情報
     *
     * @return publishedReportInfoList
     */
    public List<PublishedReportInfo> get帳票情報() {
        List<DbT2017TsuchishoHakkogoIdoshaEntity> entityList = dac.select発行帳票情報();
        List<PublishedReportInfo> publishedReportInfoList = new ArrayList<>();
        for (DbT2017TsuchishoHakkogoIdoshaEntity entity : entityList) {
            PublishedReportInfo publishedReportInfo = new PublishedReportInfo();
            publishedReportInfo.set帳票ID(entity.getReportID());
            publishedReportInfo.set帳票作成日時(entity.getChohyosakuseiTimestamp());
            publishedReportInfoList.add(publishedReportInfo);
        }
        return publishedReportInfoList;
    }

    /**
     * get通知書名称
     *
     * @param 発行帳票情報 発行帳票情報
     * @return 帳票名Map
     */
    public Map<RString, RString> get通知書名称(List<PublishedReportInfo> 発行帳票情報) {
        Map<RString, RString> 帳票名Map = new HashMap<>();
        for (PublishedReportInfo entity : 発行帳票情報) {
            if (!帳票名Map.containsKey(entity.get帳票ID().getColumnValue())) {
                RString 帳票名 = ReportInfo.getReportName(SubGyomuCode.DBB介護賦課, entity.get帳票ID().getColumnValue());
                帳票名 = new RString(帳票名.toString().replaceAll("\\【.*?\\】", ""));
                帳票名Map.put(entity.get帳票ID().getColumnValue(), 帳票名);
            }
        }
        return 帳票名Map;
    }

    /**
     * 作成日時の設定
     *
     * @param 発行帳票情報 発行帳票情報
     * @return 発行日時Map
     */
    public Map<ReportId, List<YMDHMS>> get作成日時(List<PublishedReportInfo> 発行帳票情報) {
        Map<ReportId, List<YMDHMS>> 発行日時Map = new HashMap<>();
        for (PublishedReportInfo entity : 発行帳票情報) {
            if (発行日時Map.containsKey(entity.get帳票ID())) {
                発行日時Map.get(entity.get帳票ID()).add(entity.get帳票作成日時());
            } else {
                List<YMDHMS> nullList = new ArrayList<>();
                発行日時Map.put(entity.get帳票ID(), nullList);
                発行日時Map.get(entity.get帳票ID()).add(entity.get帳票作成日時());
            }
        }
        return 発行日時Map;
    }

    /**
     * get計算処理日時
     *
     * @param 帳票ID 帳票ID
     * @param 帳票作成日時 帳票作成日時
     * @return 計算処理日時
     */
    public YMDHMS get計算処理日時(ReportId 帳票ID, YMDHMS 帳票作成日時) {
        DbT2017TsuchishoHakkogoIdoshaEntity entity = dac.getMAX計算処理日時(帳票ID, 帳票作成日時);
        return entity.getKeisanTimestamp();
    }

    public List<DbT2017Uaft200EntityResult> get異動者チェック情報(ReportId 帳票ID, YMDHMS 帳票作成日時) {
        ShikibetsuTaishoIdoSearchKeyBuilder builder = new ShikibetsuTaishoIdoSearchKeyBuilder(
                ShikibetsuTaishoIdoChushutsuKubun.異動処理日時で異動後のみ抽出,
                帳票作成日時.getRDateTime(), RDate.getNowDateTime());
        builder.set個人のみ取得区分(true);
        ShikibetsuTaishoIdoSearchKey searchKey = builder.build();
        ShikibetsuTaishoIdoFinder finder = ShikibetsuTaishoIdoFinder.createInstance();
        List<ShikibetsuTaishoIdoJoho> idoJohos = finder.get宛名識別対象異動(searchKey);
//        ShikibetsuTaishoIdoSearchKeyBuilder builder = new ShikibetsuTaishoIdoSearchKeyBuilder(ShikibetsuTaishoIdoChushutsuKubun.異動処理日時と異動事由で異動前後を抽出,
//                帳票作成日時.getRDateTime(), RDate.getNowDateTime());
//        builder.set個人のみ取得区分(true);
//        ShikibetsuTaishoIdoSearchKey searchKey = builder.build();
//        TsuchishohakkogoidoshaParamter paramter = TsuchishohakkogoidoshaParamter.createSelectByKeyParam(searchKey, 帳票ID, 帳票作成日時);
        ITsuchiShoHakkogoIdoHaakuMapper mapper = mapperProvider.create(ITsuchiShoHakkogoIdoHaakuMapper.class);
//        List<DbT2017EntityResult> dbt2017Result = mapper.get対象データ(paramter);
//        if (dbt2017Result == null || dbt2017Result.isEmpty()) {
//            dbt2017Result = new ArrayList<>();
//        }
//
//        UaFt001FindIdoEntity 異動前PSM結果 = new UaFt001FindIdoEntity();
//        UaFt001FindIdoEntity 異動後PSM結果 = new UaFt001FindIdoEntity();
//        for (DbT2017EntityResult entity : dbt2017Result) {
//            if (new RString("1").equals(entity.getUaFt001Entity().getIdoZengoKubun())) {
//                異動前PSM結果 = entity.getUaFt001Entity();
//            }
//            if (new RString("2").equals(entity.getUaFt001Entity().getIdoZengoKubun())) {
//                異動後PSM結果 = entity.getUaFt001Entity();
//            }
//        }
//        boolean 住所変更 = get住所変更(異動前PSM結果, 異動後PSM結果);
//        boolean 氏名変更 = get氏名変更(異動前PSM結果, 異動後PSM結果);
//
//        if (住所変更 || 氏名変更) {
//            int a = 1;
//            //通知書発行後異動者テーブルを更新する
//        }
//
//        // 2.　資格の異動
//        YMDHMS 最大計算処理日時 = get計算処理日時(帳票ID, 帳票作成日時);
//        TwoParamter twoParamter = TwoParamter.createSelectByKeyParam(帳票ID, 帳票作成日時, 最大計算処理日時);
//        List<DBV2001EntityResult> dbv2001EntityList = mapper.get対象データTwo(twoParamter);
//        if (dbv2001EntityList != null && !dbv2001EntityList.isEmpty()) {
//            for (DBV2001EntityResult entity : dbv2001EntityList) {
//                DbT2017TsuchishoHakkogoIdoshaEntity dbt2017Entity = entity.getDbT2017Entity();
//                DbV2001ChoshuHohoEntity dbv2001Entity = entity.getDbv2001Entity();
//                // 通知書発行後異動者.異動年月日=徴収方法Newest．更新日時の年月日
////                dbt2017Entity.getIdoYMD() = dbv2001Entity.;
////                dbt2017Entity.getIdoNaiyo() = Enum.valueOf(null, null)
//                dbt2017Entity.setIdoAriFlag(true);
//                dbt2017Entity.setState(EntityDataState.Modified);
//                dac.save(dbt2017Entity);
//            }
//            int b = 2;
//            // 通知書発行後異動者テーブルの更新
//        }

        ThreeParamter threeParamter = ThreeParamter.createSelectByKeyParam(帳票ID, 帳票作成日時);
        List<DbT2017Uaft200EntityResult> entityList = mapper.get異動者情報(threeParamter);
        return entityList;
    }

    private boolean get住所変更(UaFt001FindIdoEntity 異動前PSM結果, UaFt001FindIdoEntity 異動後PSM結果) {
        boolean flag = false;
        if (異動前PSM結果.getYubinNo().equals(異動後PSM結果.getYubinNo())) {
            flag = true;
        }
        if (異動前PSM結果.getJusho().equals(異動後PSM結果.getJusho())) {
            flag = true;
        }
        if (異動前PSM結果.getBanchi().equals(異動後PSM結果.getBanchi())) {
            flag = true;
        }
        if (異動前PSM結果.getKatagaki().equals(異動後PSM結果.getKatagaki())) {
            flag = true;
        }
        return flag;
    }

    private boolean get氏名変更(UaFt001FindIdoEntity 異動前PSM結果, UaFt001FindIdoEntity 異動後PSM結果) {
        boolean flag = false;
        if (異動前PSM結果.getKanjiShimei().equals(異動後PSM結果.getKanjiShimei())) {
            flag = true;
        }
        if (異動前PSM結果.getKanaShimei().equals(異動後PSM結果.getKanaShimei())) {
            flag = true;
        }
        if (異動前PSM結果.getGaikokujinShimei().equals(異動後PSM結果.getGaikokujinShimei())) {
            flag = true;
        }
        if (異動前PSM結果.getGaikokujinHeikimei().equals(異動後PSM結果.getGaikokujinHeikimei())) {
            flag = true;
        }
        if (異動前PSM結果.getGaikokujinKanaShimei().equals(異動後PSM結果.getGaikokujinKanaShimei())) {
            flag = true;
        }
        if (異動前PSM結果.getTsushomei().equals(異動後PSM結果.getTsushomei())) {
            flag = true;
        }
        if (異動前PSM結果.getKanaTsushomei().equals(異動後PSM結果.getKanaTsushomei())) {
            flag = true;
        }
        return flag;
    }
}
