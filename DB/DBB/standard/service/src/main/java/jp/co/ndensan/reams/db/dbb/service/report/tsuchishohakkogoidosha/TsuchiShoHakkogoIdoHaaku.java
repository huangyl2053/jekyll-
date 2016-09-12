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
import jp.co.ndensan.reams.db.dbb.business.core.tsuchishohakkogoidosha.DbT2017EntityResult;
import jp.co.ndensan.reams.db.dbb.business.core.tsuchishohakkogoidosha.PublishedReportInfo;
import jp.co.ndensan.reams.db.dbb.business.core.tsuchishohakkogoidosha.TsuchiShoHakkoGoIdosha;
import jp.co.ndensan.reams.db.dbb.definition.core.tsuchishohakkogoido.IdoNaiyo;
import jp.co.ndensan.reams.db.dbb.definition.mybatisprm.tsuchishohakkogoidosha.IdoshaParamter;
import jp.co.ndensan.reams.db.dbb.definition.mybatisprm.tsuchishohakkogoidosha.QualificationsParamter;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.DbT2017TsuchishoHakkogoIdoshaEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.tsuchishohakkogoidosha.DbT2017Uaft200EntityResult;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.tsuchishohakkogoidosha.Dbv2001EntityResult;
import jp.co.ndensan.reams.db.dbb.persistence.db.basic.DbT2017TsuchishoHakkogoIdoshaDac;
import jp.co.ndensan.reams.db.dbb.persistence.db.mapper.relate.tsuchishohakkogoidohaaku.ITsuchiShoHakkogoIdoHaakuMapper;
import jp.co.ndensan.reams.db.dbb.service.core.MapperProvider;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbV2001ChoshuHohoEntity;
import jp.co.ndensan.reams.ua.uax.business.core.idoruiseki.ShikibetsuTaishoIdoJoho;
import jp.co.ndensan.reams.ua.uax.business.core.idoruiseki.ShikibetsuTaishoIdoSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.idoruiseki.ShikibetsuTaishoIdoChushutsuKubun;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.idoruiseki.ShikibetsuTaishoIdoSearchKey;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt001FindIdoEntity;
import jp.co.ndensan.reams.ua.uax.service.core.idoruiseki.ShikibetsuTaishoIdoFinder;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.IName;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RYear;
import jp.co.ndensan.reams.uz.uza.report.api.ReportInfo;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 通知書発行後異動把握
 *
 * @reamsid_L DBB-0690-020 xuhao
 */
public class TsuchiShoHakkogoIdoHaaku {

    private final DbT2017TsuchishoHakkogoIdoshaDac dac;
    private final MapperProvider mapperProvider;

    /**
     * TsuchiShoHakkogoIdoHaaku
     */
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
        if (entityList == null || entityList.isEmpty()) {
            return publishedReportInfoList;
        }
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
        if (発行帳票情報 == null || 発行帳票情報.isEmpty()) {
            return 帳票名Map;
        }
        for (PublishedReportInfo entity : 発行帳票情報) {
            if (!帳票名Map.containsKey(entity.get帳票ID().getColumnValue())) {
                RString 帳票名 = ReportInfo.getReportName(SubGyomuCode.DBB介護賦課, entity.get帳票ID().getColumnValue());
                帳票名 = new RString(帳票名.toString().replaceAll("\\【.*?\\】", "").trim());
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
        if (発行帳票情報 == null || 発行帳票情報.isEmpty()) {
            return 発行日時Map;
        }
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

    /**
     * get異動者チェック情報
     *
     * @param 帳票ID 帳票ID
     * @param 帳票作成日時 帳票作成日時
     * @return List
     */
    public List<TsuchiShoHakkoGoIdosha> get異動者チェック情報(ReportId 帳票ID, YMDHMS 帳票作成日時) {
        ShikibetsuTaishoIdoSearchKeyBuilder builder = new ShikibetsuTaishoIdoSearchKeyBuilder(
                ShikibetsuTaishoIdoChushutsuKubun.異動処理日時で異動前後を抽出,
                帳票作成日時.getRDateTime(), RDate.getNowDateTime());
        builder.set個人のみ取得区分(true);
        ShikibetsuTaishoIdoSearchKey searchKey = builder.build();
        ShikibetsuTaishoIdoFinder finder = ShikibetsuTaishoIdoFinder.createInstance();
        List<ShikibetsuTaishoIdoJoho> idoJohosList = finder.get宛名識別対象異動(searchKey);
        List<DbT2017TsuchishoHakkogoIdoshaEntity> dbt2017EntityList = dac.selectByTwoPar(帳票ID, 帳票作成日時);
        List<DbT2017EntityResult> entityResultList = new ArrayList<>();

        for (DbT2017TsuchishoHakkogoIdoshaEntity dbt2017Entity : dbt2017EntityList) {
            for (ShikibetsuTaishoIdoJoho idoJoho : idoJohosList) {
                if (dbt2017Entity.getShikibetsuCode().equals(idoJoho.get識別コード())) {
                    DbT2017EntityResult entityResult = new DbT2017EntityResult(dbt2017Entity, idoJoho);
                    entityResultList.add(entityResult);
                }
            }
        }

        List<DbT2017TsuchishoHakkogoIdoshaEntity> updateEntityList = new ArrayList<>();
        for (DbT2017EntityResult entity : entityResultList) {
            if (!updateEntityList.contains(entity.getDbT2017Entity())) {
                updateEntityList.add(entity.getDbT2017Entity());
            }
        }

        for (DbT2017TsuchishoHakkogoIdoshaEntity updateEntity : updateEntityList) {
            UaFt001FindIdoEntity uaftentity = new UaFt001FindIdoEntity();
            ShikibetsuTaishoIdoJoho 異動前PSM結果 = new ShikibetsuTaishoIdoJoho(uaftentity);
            ShikibetsuTaishoIdoJoho 異動後PSM結果 = new ShikibetsuTaishoIdoJoho(uaftentity);
            for (DbT2017EntityResult entity : entityResultList) {
                if (entity.getDbT2017Entity().equals(updateEntity)
                        && entity.getUaFt001Entity().get異動前後区分().equals(new RString("1"))) {
                    異動前PSM結果 = entity.getUaFt001Entity();
                }
                if (entity.getDbT2017Entity().equals(updateEntity)
                        && entity.getUaFt001Entity().get異動前後区分().equals(new RString("2"))) {
                    異動後PSM結果 = entity.getUaFt001Entity();
                }
            }
            update住基異動(異動前PSM結果, 異動後PSM結果, updateEntity);
        }

        YMDHMS 最大計算処理日時 = get計算処理日時(帳票ID, 帳票作成日時);
        QualificationsParamter twoParamter = QualificationsParamter.createSelectByKeyParam(帳票ID, 帳票作成日時, 最大計算処理日時);
        ITsuchiShoHakkogoIdoHaakuMapper mapper = mapperProvider.create(ITsuchiShoHakkogoIdoHaakuMapper.class);
        List<Dbv2001EntityResult> dbv2001EntityList = mapper.get対象データTwo(twoParamter);
        if (dbv2001EntityList != null && !dbv2001EntityList.isEmpty()) {
            for (Dbv2001EntityResult entity : dbv2001EntityList) {
                DbT2017TsuchishoHakkogoIdoshaEntity dbt2017Entity = entity.getDbT2017Entity();
                DbV2001ChoshuHohoEntity dbv2001Entity = entity.getDbv2001Entity();
                dbt2017Entity = set資格異動(dbt2017Entity, dbv2001Entity);
                dac.save(dbt2017Entity);
            }
        }

        IdoshaParamter threeParamter = IdoshaParamter.createSelectByKeyParam(帳票ID, 帳票作成日時);
        List<DbT2017Uaft200EntityResult> dbt2017Uaf200entityList = mapper.get異動者情報(threeParamter);
        List<TsuchiShoHakkoGoIdosha> entityList = new ArrayList<>();
        for (final DbT2017Uaft200EntityResult entity : dbt2017Uaf200entityList) {
            TsuchiShoHakkoGoIdosha idosha = new TsuchiShoHakkoGoIdosha();
            idosha.set帳票ID(entity.getDbT2017Entity().getReportID());
            idosha.set帳票作成日時(entity.getDbT2017Entity().getChohyosakuseiTimestamp());
            idosha.set通知書番号(entity.getDbT2017Entity().getTsuchishoNo());
            idosha.set被保険者番号(entity.getDbT2017Entity().getHihokenshaNo());
            idosha.set該当連番(entity.getDbT2017Entity().getGaitoRemban());
            idosha.set異動日(entity.getDbT2017Entity().getIdoYMD());
            idosha.set異動内容(IdoNaiyo.toValue(entity.getDbT2017Entity().getIdoNaiyo()));
            idosha.set計算処理日時(entity.getDbT2017Entity().getKeisanTimestamp());
            IName in = new IName() {
                @Override
                public AtenaMeisho getName() {
                    return entity.get名称();
                }

                @Override
                public AtenaKanaMeisho getKana() {
                    throw new UnsupportedOperationException("Not supported yet.");
                }
            };
            idosha.set氏名(in);
            idosha.set識別コード(entity.getDbT2017Entity().getShikibetsuCode());
            idosha.set賦課年度(new RYear(entity.getDbT2017Entity().getFukaNendo().toString()));
            entityList.add(idosha);
        }
        return entityList;
    }

    private boolean get住所変更(ShikibetsuTaishoIdoJoho 異動前PSM結果, ShikibetsuTaishoIdoJoho 異動後PSM結果) {
        boolean flag = false;
        boolean 郵便番号flag = get郵便番号(異動前PSM結果, 異動後PSM結果, flag);
        boolean 住所flag = get住所(異動前PSM結果, 異動後PSM結果, flag);
        boolean 番地flag = get番地(異動前PSM結果, 異動後PSM結果, flag);
        boolean 方書flag = get方書(異動前PSM結果, 異動後PSM結果, flag);
        if (郵便番号flag || 住所flag || 番地flag || 方書flag) {
            flag = true;
        }
        return flag;
    }

    private boolean get方書(ShikibetsuTaishoIdoJoho 異動前PSM結果, ShikibetsuTaishoIdoJoho 異動後PSM結果, boolean flag) {
        if ((異動前PSM結果.get方書() == null && 異動後PSM結果.get方書() != null)
                || (異動前PSM結果.get方書() != null && 異動後PSM結果.get方書() == null)) {
            flag = true;
        }
        if ((異動前PSM結果.get方書() != null && 異動後PSM結果.get方書() != null)
                && (!異動前PSM結果.get方書().equals(異動後PSM結果.get方書()))) {
            flag = true;
        }
        return flag;
    }

    private boolean get番地(ShikibetsuTaishoIdoJoho 異動前PSM結果, ShikibetsuTaishoIdoJoho 異動後PSM結果, boolean flag) {
        if ((異動前PSM結果.get番地() == null && 異動後PSM結果.get番地() != null)
                || (異動前PSM結果.get番地() != null && 異動後PSM結果.get番地() == null)) {
            flag = true;
        }
        if ((異動前PSM結果.get番地() != null && 異動後PSM結果.get番地() != null)
                && (!異動前PSM結果.get番地().equals(異動後PSM結果.get番地()))) {
            flag = true;
        }
        return flag;
    }

    private boolean get住所(ShikibetsuTaishoIdoJoho 異動前PSM結果, ShikibetsuTaishoIdoJoho 異動後PSM結果, boolean flag) {
        if ((異動前PSM結果.get住所() == null && 異動後PSM結果.get住所() != null)
                || (異動前PSM結果.get住所() != null && 異動後PSM結果.get住所() == null)) {
            flag = true;
        }
        if ((異動前PSM結果.get住所() != null && 異動後PSM結果.get住所() != null)
                && (!異動前PSM結果.get住所().equals(異動後PSM結果.get住所()))) {
            flag = true;
        }
        return flag;
    }

    private boolean get郵便番号(ShikibetsuTaishoIdoJoho 異動前PSM結果, ShikibetsuTaishoIdoJoho 異動後PSM結果, boolean flag) {
        if ((異動前PSM結果.get郵便番号() == null && 異動後PSM結果.get郵便番号() != null)
                || (異動前PSM結果.get郵便番号() != null && 異動後PSM結果.get郵便番号() == null)) {
            flag = true;
        }
        if (異動前PSM結果.get郵便番号() != null && 異動後PSM結果.get郵便番号() != null
                && (!異動前PSM結果.get郵便番号().equals(異動後PSM結果.get郵便番号()))) {
            flag = true;
        }
        return flag;
    }

    private boolean get氏名変更(ShikibetsuTaishoIdoJoho 異動前PSM結果, ShikibetsuTaishoIdoJoho 異動後PSM結果) {
        boolean flag = false;
        boolean flagOne = get漢字氏名(異動前PSM結果, 異動後PSM結果, flag);
        boolean flagTwo = getカナ氏名(異動前PSM結果, 異動後PSM結果, flag);
        boolean flagThree = get外国人氏名(異動前PSM結果, 異動後PSM結果, flag);
        boolean flagFour = get外国人併記名(異動前PSM結果, 異動後PSM結果, flag);
        boolean flagFive = get外国人カナ氏名(異動前PSM結果, 異動後PSM結果, flag);
        boolean flagSix = get通称名(異動前PSM結果, 異動後PSM結果, flag);
        boolean flagSeven = getカナ通称名(異動前PSM結果, 異動後PSM結果, flag);
        if (flagOne || flagTwo || flagThree || flagFour || flagFive || flagSix || flagSeven) {
            flag = true;
        }
        return flag;
    }

    private boolean getカナ通称名(ShikibetsuTaishoIdoJoho 異動前PSM結果, ShikibetsuTaishoIdoJoho 異動後PSM結果, boolean flag) {
        if ((異動前PSM結果.getカナ通称名() == null && 異動後PSM結果.getカナ通称名() != null)
                || (異動前PSM結果.getカナ通称名() != null && 異動後PSM結果.getカナ通称名() == null)) {
            flag = true;
        }
        if ((異動前PSM結果.getカナ通称名() != null && 異動後PSM結果.getカナ通称名() != null)
                && (!異動前PSM結果.getカナ通称名().equals(異動後PSM結果.getカナ通称名()))) {
            flag = true;
        }
        return flag;
    }

    private boolean get通称名(ShikibetsuTaishoIdoJoho 異動前PSM結果, ShikibetsuTaishoIdoJoho 異動後PSM結果, boolean flag) {
        if ((異動前PSM結果.get通称名() == null && 異動後PSM結果.get通称名() != null)
                || (異動前PSM結果.get通称名() != null && 異動後PSM結果.get通称名() == null)) {
            flag = true;
        }
        if ((異動前PSM結果.get通称名() != null && 異動後PSM結果.get通称名() != null)
                && (!異動前PSM結果.get通称名().equals(異動後PSM結果.get通称名()))) {
            flag = true;
        }
        return flag;
    }

    private boolean get外国人カナ氏名(ShikibetsuTaishoIdoJoho 異動前PSM結果, ShikibetsuTaishoIdoJoho 異動後PSM結果, boolean flag) {
        if ((異動前PSM結果.get外国人カナ氏名() == null && 異動後PSM結果.get外国人カナ氏名() != null)
                || (異動前PSM結果.get外国人カナ氏名() != null && 異動後PSM結果.get外国人カナ氏名() == null)) {
            flag = true;
        }
        if ((異動前PSM結果.get外国人カナ氏名() != null && 異動後PSM結果.get外国人カナ氏名() != null)
                && (!異動前PSM結果.get外国人カナ氏名().equals(異動後PSM結果.get外国人カナ氏名()))) {
            flag = true;
        }
        return flag;
    }

    private boolean get外国人併記名(ShikibetsuTaishoIdoJoho 異動前PSM結果, ShikibetsuTaishoIdoJoho 異動後PSM結果, boolean flag) {
        if ((異動前PSM結果.get外国人併記名() == null && 異動後PSM結果.get外国人併記名() != null)
                || (異動前PSM結果.get外国人併記名() != null && 異動後PSM結果.get外国人併記名() == null)) {
            flag = true;
        }
        if ((異動前PSM結果.get外国人併記名() != null && 異動後PSM結果.get外国人併記名() != null)
                && (!異動前PSM結果.get外国人併記名().equals(異動後PSM結果.get外国人併記名()))) {
            flag = true;
        }
        return flag;
    }

    private boolean get外国人氏名(ShikibetsuTaishoIdoJoho 異動前PSM結果, ShikibetsuTaishoIdoJoho 異動後PSM結果, boolean flag) {
        if ((異動前PSM結果.get外国人氏名() == null && 異動後PSM結果.get外国人氏名() != null)
                || (異動前PSM結果.get外国人氏名() != null && 異動後PSM結果.get外国人氏名() == null)) {
            flag = true;
        }
        if ((異動前PSM結果.get外国人氏名() != null && 異動後PSM結果.get外国人氏名() != null)
                && (!異動前PSM結果.get外国人氏名().equals(異動後PSM結果.get外国人氏名()))) {
            flag = true;
        }
        return flag;
    }

    private boolean getカナ氏名(ShikibetsuTaishoIdoJoho 異動前PSM結果, ShikibetsuTaishoIdoJoho 異動後PSM結果, boolean flag) {
        if ((異動前PSM結果.getカナ氏名() == null && 異動後PSM結果.getカナ氏名() != null)
                || (異動前PSM結果.getカナ氏名() != null && 異動後PSM結果.getカナ氏名() == null)) {
            flag = true;
        }
        if ((異動前PSM結果.getカナ氏名() != null && 異動後PSM結果.getカナ氏名() != null)
                && (!異動前PSM結果.getカナ氏名().equals(異動後PSM結果.getカナ氏名()))) {
            flag = true;
        }
        return flag;
    }

    private boolean get漢字氏名(ShikibetsuTaishoIdoJoho 異動前PSM結果, ShikibetsuTaishoIdoJoho 異動後PSM結果, boolean flag) {
        if ((異動前PSM結果.get漢字氏名() == null && 異動後PSM結果.get漢字氏名() != null)
                || (異動前PSM結果.get漢字氏名() != null && 異動後PSM結果.get漢字氏名() == null)) {
            flag = true;
        }
        if ((異動前PSM結果.get漢字氏名() != null && 異動後PSM結果.get漢字氏名() != null)
                && (!異動前PSM結果.get漢字氏名().equals(異動後PSM結果.get漢字氏名()))) {
            flag = true;
        }
        return flag;
    }

    private DbT2017TsuchishoHakkogoIdoshaEntity set住基異動(
            DbT2017TsuchishoHakkogoIdoshaEntity dbt2017Entity, ShikibetsuTaishoIdoJoho 異動後PSM結果,
            boolean 氏名変更flag) {
        dbt2017Entity.setIdoYMD(new FlexibleDate(異動後PSM結果.get異動処理日時().getDate().toString()));
        if (氏名変更flag) {
            dbt2017Entity.setIdoNaiyo(IdoNaiyo.氏名の変更.getコード());
        } else {
            dbt2017Entity.setIdoNaiyo(IdoNaiyo.本人住所の変更.getコード());
        }
        dbt2017Entity.setIdoAriFlag(true);
        dbt2017Entity.setState(EntityDataState.Modified);
        return dbt2017Entity;
    }

    private DbT2017TsuchishoHakkogoIdoshaEntity set資格異動(
            DbT2017TsuchishoHakkogoIdoshaEntity dbt2017Entity, DbV2001ChoshuHohoEntity dbv2001Entity) {
        RDateTime time = dbv2001Entity.getLastUpdateTimestamp();
        if (time != null && time.getDate() != null) {
            dbt2017Entity.setIdoYMD(new FlexibleDate(time.getDate().toString()));
        }
        dbt2017Entity.setIdoNaiyo(IdoNaiyo.資格の異動.getコード());
        dbt2017Entity.setIdoAriFlag(true);
        dbt2017Entity.setState(EntityDataState.Modified);
        return dbt2017Entity;
    }

    private void update住基異動(ShikibetsuTaishoIdoJoho 異動前PSM, ShikibetsuTaishoIdoJoho 異動後PSM,
            DbT2017TsuchishoHakkogoIdoshaEntity updateEntity) {
        ShikibetsuTaishoIdoJoho 異動前PSM結果 = 異動前PSM;
        ShikibetsuTaishoIdoJoho 異動後PSM結果 = 異動後PSM;
        boolean 住所変更flag = get住所変更(異動前PSM結果, 異動後PSM結果);
        boolean 氏名変更flag = get氏名変更(異動前PSM結果, 異動後PSM結果);
        if (住所変更flag || 氏名変更flag) {
            DbT2017TsuchishoHakkogoIdoshaEntity dbt2017EntityNew = set住基異動(updateEntity,
                    異動後PSM結果, 氏名変更flag);
            dac.save(dbt2017EntityNew);
        }
    }
}
