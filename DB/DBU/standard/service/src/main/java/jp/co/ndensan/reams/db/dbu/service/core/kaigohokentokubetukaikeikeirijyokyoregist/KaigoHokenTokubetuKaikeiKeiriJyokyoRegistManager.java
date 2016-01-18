/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.service.core.kaigohokentokubetukaikeikeirijyokyoregist;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import jp.co.ndensan.reams.db.dba.definition.message.DbaErrorMessages;
import jp.co.ndensan.reams.db.dbu.entity.kaigohokentokubetukaikeikeirijyokyoregist.KaigoHokenJigyoHokokuNenpoEntity;
import jp.co.ndensan.reams.db.dbu.entity.kaigohokentokubetukaikeikeirijyokyoregist.ShichosonEntity;
import jp.co.ndensan.reams.db.dbu.entity.kaigohokentokubetukaikeikeirijyokyoregist.KaigoHokenShoriDateKanriEntity;
import jp.co.ndensan.reams.db.dbu.entity.db.basic.DbT7021JigyoHokokuTokeiDataEntity;
import jp.co.ndensan.reams.db.dbu.persistence.db.basic.DbT7021JigyoHokokuTokeiDataDac;
import jp.co.ndensan.reams.db.dbx.business.shichosonsecurityjoho.KoseiShichosonJoho;
import jp.co.ndensan.reams.db.dbx.definition.core.enumeratedtype.DonyukeitaiCode;
import jp.co.ndensan.reams.db.dbx.definition.core.hokensha.TokeiTaishoKubun;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7051KoseiShichosonMasterEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7056GappeiShichosonEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.relate.gappeijoho.KyuShichosonCodeJohoRelateEntity;
import jp.co.ndensan.reams.db.dbx.service.ShichosonSecurityJoho;
import jp.co.ndensan.reams.db.dbx.service.core.gappeijoho.KyuShichosonCodeFinder;
import jp.co.ndensan.reams.db.dbx.service.core.koseishichoson.KoikiShichosonJohoFinder;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.kyotsu.JigyoHokokuNenpoShoriName;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7022ShoriDateKanriEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT7022ShoriDateKanriDac;
import jp.co.ndensan.reams.db.dbz.service.core.gappeijoho.gappeijoho.GappeiCityJohoBFinder;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 *
 * 介護保険特別会計経理状況登録Managerクラスです。
 */
public class KaigoHokenTokubetuKaikeiKeiriJyokyoRegistManager {

    /**
     * コンストラクタです。
     *
     */
    public KaigoHokenTokubetuKaikeiKeiriJyokyoRegistManager() {
    }

    /**
     * 市町村のリスト取得
     *
     * @return 市町村Entiyリスト
     * @throws ApplicationException ①　市町村セキュリティ情報を取得できなかった場合（URZErrMesage．存在しない：市町村セキュリティ情報が存在しません。）
     * @throws ApplicationException ②　合併情報区分を取得できなかった場合（URZErrMesage．存在しない：合併情報区分が存在しません。）
     * @throws ApplicationException ③　現市町村情報取得できなかった場合（URZErrMesage．存在しない：現市町村情報が存在しません。）
     * @throws ApplicationException ④　全市町村情報取得できなかった場合（URZErrMesage．存在しない：全市町村情報が存在しません。）
     * @throws ApplicationException ⑤　旧市町村コード情報取得できなかった場合（URZErrMesage．存在しない：旧市町村コード情報が存在しません。）
     * @throws ApplicationException ⑥　広域、市町村識別ID＝「00以外」の場合（DBAE00026：広域構成市町村からの補正処理は行えません。）
     *
     */
    public List<ShichosonEntity> getShichosonCodeNameList() {
        ShichosonSecurityJoho shichosonsecurityjoho = ShichosonSecurityJoho.getShichosonSecurityJoho(GyomuBunrui.介護事務);
        Code 導入形態コード = Code.EMPTY;
        KoseiShichosonJoho 市町村情報 = new KoseiShichosonJoho();
        if (shichosonsecurityjoho != null) {
            導入形態コード = shichosonsecurityjoho.get導入形態コード();
            市町村情報 = shichosonsecurityjoho.get市町村情報();
        } else {
            throw new ApplicationException(UrErrorMessages.存在しない.getMessage().replace("市町村セキュリティ情報"));
        }

        GappeiCityJohoBFinder gappeicityjohobfinder = GappeiCityJohoBFinder.createInstance();
        RString 合併情報区分 = gappeicityjohobfinder.getGappeijohokubun();
        if (合併情報区分 == null) {
            throw new ApplicationException(UrErrorMessages.存在しない.getMessage().replace("合併情報区分"));
        }

        ShichosonEntity shichosonEntity = new ShichosonEntity();
        List<ShichosonEntity> shichosonEntitylist = new ArrayList<>();
        if (DonyukeitaiCode.事務広域.toString().equals(導入形態コード.toString())
                || DonyukeitaiCode.認定広域.toString().equals(導入形態コード.toString())) {
            if (new RString("0").equals(合併情報区分)) {
                if (new RString("00").equals(市町村情報.get市町村識別ID())) {
                    shichosonEntity.set市町村コード(市町村情報.get市町村コード());
                    shichosonEntity.set市町村名称(市町村情報.get市町村名称());
                    shichosonEntity.set保険者コード(市町村情報.get証記載保険者番号());
                    shichosonEntity.set保険者区分(TokeiTaishoKubun.保険者分);
                    shichosonEntitylist.add(shichosonEntity);

                    KoikiShichosonJohoFinder koikishichosonjohofinder = KoikiShichosonJohoFinder.createInstance();
                    List<DbT7051KoseiShichosonMasterEntity> koseiShichosonMasterEntityList = koikishichosonjohofinder.getGenShichosonJoho();
                    if (koseiShichosonMasterEntityList == null || koseiShichosonMasterEntityList.isEmpty()) {
                        throw new ApplicationException(UrErrorMessages.存在しない.getMessage().replace("現市町村情報"));
                    } else {
                        Iterator<DbT7051KoseiShichosonMasterEntity> dbT7051KoseiShichosonMasterEntity = koseiShichosonMasterEntityList.iterator();
                        while (dbT7051KoseiShichosonMasterEntity.hasNext()) {
                            shichosonEntity.set市町村コード(dbT7051KoseiShichosonMasterEntity.next().getShichosonCode());
                            shichosonEntity.set市町村名称(dbT7051KoseiShichosonMasterEntity.next().getShichosonMeisho());
                            shichosonEntity.set保険者コード(dbT7051KoseiShichosonMasterEntity.next().getShoKisaiHokenshaNo());
                            shichosonEntity.set保険者区分(TokeiTaishoKubun.構成市町村分);
                            shichosonEntitylist.add(shichosonEntity);
                        }
                    }
                    return shichosonEntitylist;
                } else {
                    // TODO
                    throw new ApplicationException(DbaErrorMessages.該当資格異動情報なし.getMessage().replace("広域構成市町村からの補正処理は行えません。"));
                }
            } else if (new RString("1").equals(合併情報区分)) {
                if (new RString("00").equals(市町村情報.get市町村識別ID())) {
                    shichosonEntity.set市町村コード(市町村情報.get市町村コード());
                    shichosonEntity.set市町村名称(市町村情報.get市町村名称());
                    shichosonEntity.set保険者コード(市町村情報.get証記載保険者番号());
                    shichosonEntity.set保険者区分(TokeiTaishoKubun.保険者分);
                    shichosonEntitylist.add(shichosonEntity);

                    KoikiShichosonJohoFinder koikishichosonjohofinder = KoikiShichosonJohoFinder.createInstance();
                    List<DbT7051KoseiShichosonMasterEntity> DbT7051KoseiShichosonMasterEntitylist = koikishichosonjohofinder.getZenShichosonJoho();
                    if (DbT7051KoseiShichosonMasterEntitylist == null || DbT7051KoseiShichosonMasterEntitylist.isEmpty()) {
                        throw new ApplicationException(UrErrorMessages.存在しない.getMessage().replace("全市町村情報"));
                    } else {
                        Iterator<DbT7051KoseiShichosonMasterEntity> dbT7051KoseiShichosonMasterEntity = DbT7051KoseiShichosonMasterEntitylist.iterator();
                        while (dbT7051KoseiShichosonMasterEntity.hasNext()) {
                            shichosonEntity.set市町村コード(dbT7051KoseiShichosonMasterEntity.next().getShichosonCode());
                            shichosonEntity.set市町村名称(dbT7051KoseiShichosonMasterEntity.next().getShichosonMeisho());
                            shichosonEntity.set保険者コード(dbT7051KoseiShichosonMasterEntity.next().getShoKisaiHokenshaNo());
                            if (new RString("0").equals(dbT7051KoseiShichosonMasterEntity.next().getGappeiKyuShichosonKubun())) {
                                shichosonEntity.set保険者区分(TokeiTaishoKubun.構成市町村分);
                            } else if (new RString("1").equals(dbT7051KoseiShichosonMasterEntity.next().getGappeiKyuShichosonKubun())) {
                                shichosonEntity.set保険者区分(TokeiTaishoKubun.旧市町村分);
                            }
                        }
                    }
                    return shichosonEntitylist;
                } else {
                    // TODO
                    throw new ApplicationException(DbaErrorMessages.該当資格異動情報なし.getMessage().replace("広域構成市町村からの補正処理は行えません。"));
                }
            }
        } else {
            if (new RString("0").equals(合併情報区分)) {
                shichosonEntity.set市町村コード(市町村情報.get市町村コード());
                shichosonEntity.set市町村名称(市町村情報.get市町村名称());
                shichosonEntity.set保険者コード(市町村情報.get証記載保険者番号());
                shichosonEntity.set保険者区分(TokeiTaishoKubun.保険者分);
                shichosonEntitylist.add(shichosonEntity);
            } else if (new RString("1").equals(合併情報区分)) {
                shichosonEntity.set市町村コード(市町村情報.get市町村コード());
                shichosonEntity.set市町村名称(市町村情報.get市町村名称());
                shichosonEntity.set保険者コード(市町村情報.get証記載保険者番号());
                shichosonEntity.set保険者区分(TokeiTaishoKubun.保険者分);
                shichosonEntitylist.add(shichosonEntity);

                KyuShichosonCodeFinder kyuShichosonCodeFinder = KyuShichosonCodeFinder.createInstance();
                KyuShichosonCodeJohoRelateEntity kyuShichosonCodeJohoRelateEntity = kyuShichosonCodeFinder.getKyuShichosonCodeJoho(市町村情報.get市町村コード(),
                        DonyukeitaiCode.toValue(shichosonsecurityjoho.get導入形態コード().getColumnValue()));
                if (kyuShichosonCodeJohoRelateEntity == null) {
                    throw new ApplicationException(UrErrorMessages.存在しない.getMessage().replace("旧市町村コード情報"));
                } else {
                    Iterator<DbT7056GappeiShichosonEntity> dbT7056GappeiShichosonEntity = kyuShichosonCodeJohoRelateEntity.getEntitys().iterator();
                    while (dbT7056GappeiShichosonEntity.hasNext()) {
                        shichosonEntity.set市町村コード(dbT7056GappeiShichosonEntity.next().getKyuShichosonCode());
                        shichosonEntity.set市町村名称(dbT7056GappeiShichosonEntity.next().getKyuShichosonMeisho());
                        // TODO
                        //shichosonEntity.setHokenshaCode(it.next().getKyuHokenshaNo());
                        shichosonEntity.set保険者区分(TokeiTaishoKubun.旧市町村分);
                        shichosonEntitylist.add(shichosonEntity);
                    }
                }
            }
        }
        return shichosonEntitylist;
    }

    /**
     * 保険者情報取得
     *
     * @param 市町村コード 市町村コード
     * @return 市町村Entiy
     */
    public ShichosonEntity getHokenshaJoho(LasdecCode 市町村コード) {
        List<ShichosonEntity> shichosonEntitylist = getShichosonCodeNameList();
        Iterator<ShichosonEntity> shichosonEntity = shichosonEntitylist.iterator();
        while (shichosonEntity.hasNext()) {
            if (市町村コード.equals(shichosonEntity.next().get市町村コード())) {
                return shichosonEntity.next();
            }
        }
        return null;
    }

    /**
     * 介護保険特別会計経理状況一覧データの取得
     *
     * @param 年度 年度
     * @param 市町村コード 市町村コード
     * @param 保険者区分 保険者区分
     * @return 事業報告集計一覧データEntityリスト
     */
    public List<KaigoHokenJigyoHokokuNenpoEntity> getJigyoHokokuNenpoList(FlexibleYear 年度, LasdecCode 市町村コード, TokeiTaishoKubun 保険者区分) {

        List<KaigoHokenJigyoHokokuNenpoEntity> kaigoHokenJigyoHokokuNenpoEntityList = new ArrayList<>();
        if (!年度.isEmpty() || (保険者区分 != null && !保険者区分.getコード().isEmpty()) || !市町村コード.isEmpty()) {
            DbT7021JigyoHokokuTokeiDataDac dbT7021Dac = InstanceProvider.create(DbT7021JigyoHokokuTokeiDataDac.class);
            List<DbT7021JigyoHokokuTokeiDataEntity> dbT7021EntityList = dbT7021Dac.selectKaigoHokenTokeiDataList(年度, 市町村コード, 保険者区分);
            for (DbT7021JigyoHokokuTokeiDataEntity jigyoHokokuTokeiDataEntity : dbT7021EntityList) {
                KaigoHokenJigyoHokokuNenpoEntity kaigoHokenJigyoHokokuNenpoEntity = new KaigoHokenJigyoHokokuNenpoEntity();
                kaigoHokenJigyoHokokuNenpoEntity.set報告年(jigyoHokokuTokeiDataEntity.getHokokuYSeireki());
                kaigoHokenJigyoHokokuNenpoEntity.set報告月(jigyoHokokuTokeiDataEntity.getHokokuM());
                kaigoHokenJigyoHokokuNenpoEntity.set集計対象年(jigyoHokokuTokeiDataEntity.getShukeiTaishoYSeireki());
                kaigoHokenJigyoHokokuNenpoEntity.set集計対象月(jigyoHokokuTokeiDataEntity.getShukeiTaishoM());
                kaigoHokenJigyoHokokuNenpoEntity.set統計対象区分(jigyoHokokuTokeiDataEntity.getToukeiTaishoKubun());
                kaigoHokenJigyoHokokuNenpoEntity.set市町村コード(jigyoHokokuTokeiDataEntity.getShichosonCode());
                kaigoHokenJigyoHokokuNenpoEntity.set表番号(jigyoHokokuTokeiDataEntity.getHyoNo());
                kaigoHokenJigyoHokokuNenpoEntity.set集計番号(jigyoHokokuTokeiDataEntity.getShukeiNo());
                kaigoHokenJigyoHokokuNenpoEntity.set集計単位(jigyoHokokuTokeiDataEntity.getShukeiTani());
                kaigoHokenJigyoHokokuNenpoEntity.set縦番号(jigyoHokokuTokeiDataEntity.getTateNo());
                kaigoHokenJigyoHokokuNenpoEntity.set横番号(jigyoHokokuTokeiDataEntity.getYokoNo());
                kaigoHokenJigyoHokokuNenpoEntity.set集計結果値(jigyoHokokuTokeiDataEntity.getShukeiKekkaAtai());
                kaigoHokenJigyoHokokuNenpoEntity.set集計項目名称(jigyoHokokuTokeiDataEntity.getShukeiKomokuMeisho());
                kaigoHokenJigyoHokokuNenpoEntity.set縦項目コード(jigyoHokokuTokeiDataEntity.getTateKomokuCode());
                kaigoHokenJigyoHokokuNenpoEntity.set横項目コード(jigyoHokokuTokeiDataEntity.getYokoKomokuCode());
                kaigoHokenJigyoHokokuNenpoEntityList.add(kaigoHokenJigyoHokokuNenpoEntity);
            }
        }
        return kaigoHokenJigyoHokokuNenpoEntityList;
    }

    /**
     * 介護保険特別会計経理状況詳細データの取得
     *
     * @param 報告年 報告年
     * @param 集計対象年 集計対象年
     * @param 統計対象区分 統計対象区分
     * @param 市町村コード 市町村コード
     * @param 集計番号 集計番号
     * @return 事業報告集計一覧データEntityリスト
     */
    public List<KaigoHokenJigyoHokokuNenpoEntity> getJigyoHokokuNenpoDetal(FlexibleYear 報告年, RString 集計対象年, RString 統計対象区分,
            LasdecCode 市町村コード, RString 集計番号) {

        List<KaigoHokenJigyoHokokuNenpoEntity> kaigoHokenJigyoHokokuNenpoEntityList = new ArrayList<>();
        DbT7021JigyoHokokuTokeiDataDac dbT7021dac = InstanceProvider.create(DbT7021JigyoHokokuTokeiDataDac.class);
        List<DbT7021JigyoHokokuTokeiDataEntity> dbT7021EntityList = dbT7021dac.selectKaigoHokenTokeiData(報告年, 集計対象年, 統計対象区分, 市町村コード, 集計番号);
        for (DbT7021JigyoHokokuTokeiDataEntity jigyoHokokuTokeiDataEntity : dbT7021EntityList) {
            KaigoHokenJigyoHokokuNenpoEntity kaigoHokenJigyoHokokuNenpoEntity = new KaigoHokenJigyoHokokuNenpoEntity();
            kaigoHokenJigyoHokokuNenpoEntity.set報告年(jigyoHokokuTokeiDataEntity.getHokokuYSeireki());
            kaigoHokenJigyoHokokuNenpoEntity.set報告月(jigyoHokokuTokeiDataEntity.getHokokuM());
            kaigoHokenJigyoHokokuNenpoEntity.set集計対象年(jigyoHokokuTokeiDataEntity.getShukeiTaishoYSeireki());
            kaigoHokenJigyoHokokuNenpoEntity.set集計対象月(jigyoHokokuTokeiDataEntity.getShukeiTaishoM());
            kaigoHokenJigyoHokokuNenpoEntity.set統計対象区分(jigyoHokokuTokeiDataEntity.getToukeiTaishoKubun());
            kaigoHokenJigyoHokokuNenpoEntity.set市町村コード(jigyoHokokuTokeiDataEntity.getShichosonCode());
            kaigoHokenJigyoHokokuNenpoEntity.set表番号(jigyoHokokuTokeiDataEntity.getHyoNo());
            kaigoHokenJigyoHokokuNenpoEntity.set集計番号(jigyoHokokuTokeiDataEntity.getShukeiNo());
            kaigoHokenJigyoHokokuNenpoEntity.set集計単位(jigyoHokokuTokeiDataEntity.getShukeiTani());
            kaigoHokenJigyoHokokuNenpoEntity.set縦番号(jigyoHokokuTokeiDataEntity.getTateNo());
            kaigoHokenJigyoHokokuNenpoEntity.set横番号(jigyoHokokuTokeiDataEntity.getYokoNo());
            kaigoHokenJigyoHokokuNenpoEntity.set集計結果値(jigyoHokokuTokeiDataEntity.getShukeiKekkaAtai());
            kaigoHokenJigyoHokokuNenpoEntity.set集計項目名称(jigyoHokokuTokeiDataEntity.getShukeiKomokuMeisho());
            kaigoHokenJigyoHokokuNenpoEntity.set縦項目コード(jigyoHokokuTokeiDataEntity.getTateKomokuCode());
            kaigoHokenJigyoHokokuNenpoEntity.set横項目コード(jigyoHokokuTokeiDataEntity.getYokoKomokuCode());
            kaigoHokenJigyoHokokuNenpoEntityList.add(kaigoHokenJigyoHokokuNenpoEntity);
        }
        return kaigoHokenJigyoHokokuNenpoEntityList;
    }

    /**
     * 介護保険特別会計経理状況詳細データの新規
     *
     * @param kaigoHokenJigyoHokokuNenpoEntityList 事業報告集計一覧データEntityリスト
     * @return 新規件数
     */
    public int regKaigoHokenTokubetuKaikeiKeiriJyokyo(List<KaigoHokenJigyoHokokuNenpoEntity> kaigoHokenJigyoHokokuNenpoEntityList) {

        int 新規件数 = insertJigyoHokokuNenpoData(kaigoHokenJigyoHokokuNenpoEntityList);

        KaigoHokenShoriDateKanriEntity kaigoHokenShoriDateKanriEntity = new KaigoHokenShoriDateKanriEntity();
        kaigoHokenShoriDateKanriEntity.setサブ業務コード(SubGyomuCode.DBU介護統計報告);
        kaigoHokenShoriDateKanriEntity.set市町村コード(kaigoHokenJigyoHokokuNenpoEntityList.get(0).get市町村コード());
        kaigoHokenShoriDateKanriEntity.set処理名(JigyoHokokuNenpoShoriName.事業状況報告資料_年報_作成特別会計経理状況);
        kaigoHokenShoriDateKanriEntity.set処理枝番(new RString("00"));
        kaigoHokenShoriDateKanriEntity.set年度(kaigoHokenJigyoHokokuNenpoEntityList.get(0).get集計対象年());
        kaigoHokenShoriDateKanriEntity.set年度内連番(new RString("00"));
        kaigoHokenShoriDateKanriEntity.set基準日時(RDate.getNowDateTime());
        kaigoHokenShoriDateKanriEntity.set対象開始年月日(new FlexibleDate(kaigoHokenJigyoHokokuNenpoEntityList.get(0).get集計対象年().getYearValue(), 04, 01));
        kaigoHokenShoriDateKanriEntity.set対象終了年月日(new FlexibleDate(kaigoHokenJigyoHokokuNenpoEntityList.get(0).get集計対象年().getYearValue() + 1, 03, 31));

        新規件数 = 新規件数 + insertShoriDateKanri(kaigoHokenShoriDateKanriEntity);
        return 新規件数;
    }

    /**
     * 介護保険特別会計経理状況詳細データの修正新規
     *
     * @param kaigoHokenJigyoHokokuNenpoEntityList 事業報告集計一覧データEntityリスト
     * @return 処理件数
     */
    public int regUpdKaigoHokenTokubetuKaikeiKeiriJyokyo(List<KaigoHokenJigyoHokokuNenpoEntity> kaigoHokenJigyoHokokuNenpoEntityList) {

        int 処理件数 = insertJigyoHokokuNenpoData(kaigoHokenJigyoHokokuNenpoEntityList);

        KaigoHokenShoriDateKanriEntity kaigoHokenShoriDateKanriEntity = new KaigoHokenShoriDateKanriEntity();
        kaigoHokenShoriDateKanriEntity.setサブ業務コード(SubGyomuCode.DBU介護統計報告);
        kaigoHokenShoriDateKanriEntity.set市町村コード(kaigoHokenJigyoHokokuNenpoEntityList.get(0).get市町村コード());
        kaigoHokenShoriDateKanriEntity.set処理名(JigyoHokokuNenpoShoriName.事業状況報告資料_年報_作成特別会計経理状況);
        kaigoHokenShoriDateKanriEntity.set処理枝番(new RString("00"));
        kaigoHokenShoriDateKanriEntity.set年度(kaigoHokenJigyoHokokuNenpoEntityList.get(0).get集計対象年());
        kaigoHokenShoriDateKanriEntity.set年度内連番(new RString("00"));
        kaigoHokenShoriDateKanriEntity.set基準日時(RDate.getNowDateTime());

        処理件数 = 処理件数 + updateShoriDateKanri(kaigoHokenShoriDateKanriEntity);
        return 処理件数;
    }

    /**
     * 介護保険特別会計経理状況詳細データの更新
     *
     * @param kaigoHokenJigyoHokokuNenpoEntityList 事業報告集計一覧データEntityリスト
     * @return 更新件数
     */
    public int updKaigoHokenTokubetuKaikeiKeiriJyokyo(List<KaigoHokenJigyoHokokuNenpoEntity> kaigoHokenJigyoHokokuNenpoEntityList) {

        int 更新件数 = updateJigyoHokokuNenpoData(kaigoHokenJigyoHokokuNenpoEntityList);

        KaigoHokenShoriDateKanriEntity kaigoHokenShoriDateKanriEntity = new KaigoHokenShoriDateKanriEntity();
        kaigoHokenShoriDateKanriEntity.setサブ業務コード(SubGyomuCode.DBU介護統計報告);
        kaigoHokenShoriDateKanriEntity.set市町村コード(kaigoHokenJigyoHokokuNenpoEntityList.get(0).get市町村コード());
        kaigoHokenShoriDateKanriEntity.set処理名(JigyoHokokuNenpoShoriName.事業状況報告資料_年報_作成特別会計経理状況);
        kaigoHokenShoriDateKanriEntity.set処理枝番(new RString("00"));
        kaigoHokenShoriDateKanriEntity.set年度(kaigoHokenJigyoHokokuNenpoEntityList.get(0).get集計対象年());
        kaigoHokenShoriDateKanriEntity.set年度内連番(new RString("00"));
        kaigoHokenShoriDateKanriEntity.set基準日時(RDate.getNowDateTime());
        更新件数 = 更新件数 + updateShoriDateKanri(kaigoHokenShoriDateKanriEntity);
        return 更新件数;
    }

    /**
     * 介護保険特別会計経理状況詳細データの削除
     *
     * @param 報告年 報告年
     * @param 集計対象年 集計対象年
     * @param 統計対象区分 統計対象区分
     * @param 市町村コード 市町村コード
     * @param 表番号 表番号
     * @param 集計番号 集計番号
     * @return 削除件数
     */
    public int delKaigoHokenTokubetuKaikeiKeiriJyokyo(FlexibleYear 報告年, FlexibleYear 集計対象年, RString 統計対象区分,
            LasdecCode 市町村コード, Code 表番号, Code 集計番号) {

        // TODO １.　事業報告年報の削除処理
        int 削除件数 = 0;
        KaigoHokenShoriDateKanriEntity kaigoHokenShoriDateKanriEntity = new KaigoHokenShoriDateKanriEntity();
        kaigoHokenShoriDateKanriEntity.setサブ業務コード(SubGyomuCode.DBU介護統計報告);
        kaigoHokenShoriDateKanriEntity.set市町村コード(市町村コード);
        kaigoHokenShoriDateKanriEntity.set処理名(JigyoHokokuNenpoShoriName.事業状況報告資料_年報_作成特別会計経理状況);
        kaigoHokenShoriDateKanriEntity.set処理枝番(new RString("00"));
        kaigoHokenShoriDateKanriEntity.set年度(集計対象年);
        kaigoHokenShoriDateKanriEntity.set年度内連番(new RString("00"));
        kaigoHokenShoriDateKanriEntity.set基準日時(RDate.getNowDateTime());

        削除件数 = 削除件数 + updateShoriDateKanri(kaigoHokenShoriDateKanriEntity);
        return 削除件数;
    }

    /**
     * 事業報告年報集計データ登録処理
     *
     * @param kaigoHokenJigyoHokokuNenpoEntityList 事業報告集計一覧データEntityリスト
     * @return 新規件数
     */
    public int insertJigyoHokokuNenpoData(List<KaigoHokenJigyoHokokuNenpoEntity> kaigoHokenJigyoHokokuNenpoEntityList) {
        DbT7021JigyoHokokuTokeiDataDac dbT7021Dac = InstanceProvider.create(DbT7021JigyoHokokuTokeiDataDac.class);
        for (KaigoHokenJigyoHokokuNenpoEntity kaigoHokenJigyoHokokuNenpoEntity : kaigoHokenJigyoHokokuNenpoEntityList) {
            DbT7021JigyoHokokuTokeiDataEntity dbT7021JigyoHokokuTokeiDataEntity = new DbT7021JigyoHokokuTokeiDataEntity();
            dbT7021JigyoHokokuTokeiDataEntity.setHokokuYSeireki(kaigoHokenJigyoHokokuNenpoEntity.get報告年());
            dbT7021JigyoHokokuTokeiDataEntity.setHokokuM(new RString("00"));
            dbT7021JigyoHokokuTokeiDataEntity.setShukeiTaishoYSeireki(kaigoHokenJigyoHokokuNenpoEntity.get集計対象年());
            dbT7021JigyoHokokuTokeiDataEntity.setShukeiTaishoM(new RString("00"));
            dbT7021JigyoHokokuTokeiDataEntity.setToukeiTaishoKubun(kaigoHokenJigyoHokokuNenpoEntity.get統計対象区分());
            dbT7021JigyoHokokuTokeiDataEntity.setShichosonCode(kaigoHokenJigyoHokokuNenpoEntity.get市町村コード());
            dbT7021JigyoHokokuTokeiDataEntity.setHyoNo(new Code("09"));
            dbT7021JigyoHokokuTokeiDataEntity.setShukeiNo(new Code("0100"));
            dbT7021JigyoHokokuTokeiDataEntity.setShukeiTani(new Code("1"));
            // TODO  項目定義シートの詳細データエリア参照  画面側に合わせて
            dbT7021JigyoHokokuTokeiDataEntity.setTateNo(kaigoHokenJigyoHokokuNenpoEntity.get縦番号());
            // TODO  項目定義シートの詳細データエリア参照  画面側に合わせて
            dbT7021JigyoHokokuTokeiDataEntity.setYokoNo(kaigoHokenJigyoHokokuNenpoEntity.get横番号());
            // TODO  画面詳細データエリア各項目．集計結果値  画面側に合わせて
            dbT7021JigyoHokokuTokeiDataEntity.setShukeiKekkaAtai(kaigoHokenJigyoHokokuNenpoEntity.get集計結果値());

            dbT7021JigyoHokokuTokeiDataEntity.setState(EntityDataState.Added);
            dbT7021Dac.save(dbT7021JigyoHokokuTokeiDataEntity);
        }
        return kaigoHokenJigyoHokokuNenpoEntityList.size();
    }

    /**
     * 事業報告年報集計データ更新処理
     *
     * @param kaigoHokenJigyoHokokuNenpoEntityList 事業報告集計一覧データEntityリスト
     * @return 更新件数
     */
    public int updateJigyoHokokuNenpoData(List<KaigoHokenJigyoHokokuNenpoEntity> kaigoHokenJigyoHokokuNenpoEntityList) {
        DbT7021JigyoHokokuTokeiDataDac jigyoHokokuTokeiDataDac = InstanceProvider.create(DbT7021JigyoHokokuTokeiDataDac.class);
        for (KaigoHokenJigyoHokokuNenpoEntity kaigoHokenJigyoHokokuNenpoEntity : kaigoHokenJigyoHokokuNenpoEntityList) {
            DbT7021JigyoHokokuTokeiDataEntity dbT7021JigyoHokokuTokeiDataEntity = jigyoHokokuTokeiDataDac.selectByKey(kaigoHokenJigyoHokokuNenpoEntity.get報告年(), kaigoHokenJigyoHokokuNenpoEntity.get報告月(),
                    kaigoHokenJigyoHokokuNenpoEntity.get集計対象年(), kaigoHokenJigyoHokokuNenpoEntity.get集計対象月(),
                    kaigoHokenJigyoHokokuNenpoEntity.get統計対象区分(), kaigoHokenJigyoHokokuNenpoEntity.get市町村コード(),
                    kaigoHokenJigyoHokokuNenpoEntity.get表番号(), kaigoHokenJigyoHokokuNenpoEntity.get集計番号(),
                    kaigoHokenJigyoHokokuNenpoEntity.get集計単位(), kaigoHokenJigyoHokokuNenpoEntity.get縦番号(),
                    kaigoHokenJigyoHokokuNenpoEntity.get横番号());

            dbT7021JigyoHokokuTokeiDataEntity.setShukeiKekkaAtai(kaigoHokenJigyoHokokuNenpoEntity.get集計結果値());

            dbT7021JigyoHokokuTokeiDataEntity.setState(EntityDataState.Modified);
            jigyoHokokuTokeiDataDac.save(dbT7021JigyoHokokuTokeiDataEntity);
        }
        return kaigoHokenJigyoHokokuNenpoEntityList.size();
    }

    /**
     * 事業報告年報集計データ削除処理
     *
     * @param 報告年 報告年
     * @param 集計対象年 集計対象年
     * @param 統計対象区分 統計対象区分
     * @param 市町村コード 市町村コード
     * @param 表番号 表番号
     * @param 集計番号list 集計番号list
     * @return 削除件数
     */
    public int deleteJigyoHokokuNenpoData(FlexibleYear 報告年, FlexibleYear 集計対象年, RString 統計対象区分,
            LasdecCode 市町村コード, Code 表番号, List<Code> 集計番号list) {
        int 削除件数 = 0;
        Iterator<Code> it = 集計番号list.iterator();
        DbT7021JigyoHokokuTokeiDataDac dbT7021JigyoHokokuTokeiDataDac = InstanceProvider.create(DbT7021JigyoHokokuTokeiDataDac.class);
        while (it.hasNext()) {
            DbT7021JigyoHokokuTokeiDataEntity dbT7021JigyoHokokuTokeiDataEntity = new DbT7021JigyoHokokuTokeiDataEntity();
            dbT7021JigyoHokokuTokeiDataEntity.setHokokuYSeireki(報告年);
            dbT7021JigyoHokokuTokeiDataEntity.setHokokuM(new RString("00"));
            dbT7021JigyoHokokuTokeiDataEntity.setShukeiTaishoYSeireki(集計対象年);
            dbT7021JigyoHokokuTokeiDataEntity.setShukeiTaishoM(new RString("00"));
            dbT7021JigyoHokokuTokeiDataEntity.setToukeiTaishoKubun(統計対象区分);
            dbT7021JigyoHokokuTokeiDataEntity.setShichosonCode(市町村コード);
            dbT7021JigyoHokokuTokeiDataEntity.setHyoNo(表番号);
            dbT7021JigyoHokokuTokeiDataEntity.setShukeiNo(it.next());
            dbT7021JigyoHokokuTokeiDataEntity.setState(EntityDataState.Deleted);
            削除件数 = 削除件数 + dbT7021JigyoHokokuTokeiDataDac.save(dbT7021JigyoHokokuTokeiDataEntity);
        }
        return 削除件数;
    }

    /**
     * 処理日付管理マスタ登録処理
     *
     * @param kaigoHokenShoriDateKanriEntity 処理日付管理マスタEntity
     * @return 新規件数
     */
    public int insertShoriDateKanri(KaigoHokenShoriDateKanriEntity kaigoHokenShoriDateKanriEntity) {

        DbT7022ShoriDateKanriEntity dbT7022ShoriDateKanriEntity = new DbT7022ShoriDateKanriEntity();
        dbT7022ShoriDateKanriEntity.setSubGyomuCode(kaigoHokenShoriDateKanriEntity.getサブ業務コード());
        dbT7022ShoriDateKanriEntity.setShichosonCode(kaigoHokenShoriDateKanriEntity.get市町村コード());
        dbT7022ShoriDateKanriEntity.setShoriName(new RString(kaigoHokenShoriDateKanriEntity.get処理名().toString()));
        dbT7022ShoriDateKanriEntity.setShoriEdaban(kaigoHokenShoriDateKanriEntity.get処理枝番());
        dbT7022ShoriDateKanriEntity.setNendo(kaigoHokenShoriDateKanriEntity.get年度());
        dbT7022ShoriDateKanriEntity.setNendoNaiRenban(kaigoHokenShoriDateKanriEntity.get年度内連番());
        dbT7022ShoriDateKanriEntity.setKijunTimestamp(new YMDHMS(kaigoHokenShoriDateKanriEntity.get基準日時()));
        dbT7022ShoriDateKanriEntity.setTaishoKaishiYMD(kaigoHokenShoriDateKanriEntity.get対象開始年月日());
        dbT7022ShoriDateKanriEntity.setTaishoShuryoYMD(kaigoHokenShoriDateKanriEntity.get対象終了年月日());
        dbT7022ShoriDateKanriEntity.setTaishoKaishiTimestamp(kaigoHokenShoriDateKanriEntity.get対象開始日時());
        dbT7022ShoriDateKanriEntity.setTaishoShuryoTimestamp(kaigoHokenShoriDateKanriEntity.get対象終了日時());
        DbT7022ShoriDateKanriDac horiDateKanriDac = InstanceProvider.create(DbT7022ShoriDateKanriDac.class);
        dbT7022ShoriDateKanriEntity.setState(EntityDataState.Added);
        int 新規件数 = horiDateKanriDac.save(dbT7022ShoriDateKanriEntity);
        return 新規件数;
    }

    /**
     * 処理日付管理マスタ更新処理
     *
     * @param kaigoHokenShoriDateKanriEntity 処理日付管理マスタEntity
     * @return 新規件数
     */
    public int updateShoriDateKanri(KaigoHokenShoriDateKanriEntity kaigoHokenShoriDateKanriEntity) {
        DbT7022ShoriDateKanriDac horiDateKanriDac = InstanceProvider.create(DbT7022ShoriDateKanriDac.class);
        DbT7022ShoriDateKanriEntity dbT7022ShoriDateKanriEntity = horiDateKanriDac.selectByKey(kaigoHokenShoriDateKanriEntity.getサブ業務コード(),
                kaigoHokenShoriDateKanriEntity.get市町村コード(), new RString(kaigoHokenShoriDateKanriEntity.get処理名().toString()),
                kaigoHokenShoriDateKanriEntity.get処理枝番(), kaigoHokenShoriDateKanriEntity.get年度(), kaigoHokenShoriDateKanriEntity.get年度内連番());

        dbT7022ShoriDateKanriEntity.setKijunTimestamp(new YMDHMS(kaigoHokenShoriDateKanriEntity.get基準日時()));

        dbT7022ShoriDateKanriEntity.setState(EntityDataState.Modified);
        int 新規件数 = horiDateKanriDac.save(dbT7022ShoriDateKanriEntity);
        return 新規件数;
    }
}
