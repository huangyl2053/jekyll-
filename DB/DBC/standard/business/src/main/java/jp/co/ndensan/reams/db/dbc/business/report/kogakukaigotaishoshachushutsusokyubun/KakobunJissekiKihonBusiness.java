/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.kogakukaigotaishoshachushutsusokyubun;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.kogakukaigotaishoshachushutsusokyubun.KogakukaigotaishoshachushutsusokyubunParameter;
import jp.co.ndensan.reams.db.dbc.definition.processprm.kogakukaigotaishoshachushutsusokyubun.KogakuKaigoTaishoProcessParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakukaigotaishoshachushutsusokyubun.HihokenshaNoFukaEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakukaigotaishoshachushutsusokyubun.ShiKaKuiDoDeTaEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakukaigotaishoshachushutsusokyubun.UaFt001FindEntity;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.ShoriName;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT2008ShotokuKanriEntity;
import jp.co.ndensan.reams.ua.uax.business.core.idoruiseki.ShikibetsuTaishoIdoSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.business.core.psm.UaFt200FindShikibetsuTaishoFunction;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoPSMSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.KensakuYusenKubun;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.idoruiseki.ShikibetsuTaishoIdoChushutsuKubun;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.IShikibetsuTaishoPSMSearchKey;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * バッチ設計_DBCMN41003_高額介護対象者抽出（遡及分）のProcessです。
 *
 * @reamsid_L DBC-5750-030 wanghui
 */
public class KakobunJissekiKihonBusiness {

    private List<UaFt001FindEntity> list;
    private List<ShiKaKuiDoDeTaEntity> shiKalist;
    private List<HihokenshaNoFukaEntity> hihokensha;
    private List<DbT2008ShotokuKanriEntity> dbt2008list;

    /**
     * コンストラクタです。
     *
     */
    public KakobunJissekiKihonBusiness() {
        list = new ArrayList<>();
        shiKalist = new ArrayList<>();
        hihokensha = new ArrayList<>();
        dbt2008list = new ArrayList<>();
    }

    /**
     *
     * @param entity UaFt001FindEntity
     */
    public void setList(UaFt001FindEntity entity) {
        list.add(entity);
    }

    /**
     *
     * @param entity ShiKaKuiDoDeTaEntity
     */
    public void setShiKalist(ShiKaKuiDoDeTaEntity entity) {
        shiKalist.add(entity);
    }

    /**
     *
     * @return shiKalist
     */
    public List<ShiKaKuiDoDeTaEntity> getShiKalist() {
        return shiKalist;
    }

    /**
     *
     * @return List<UaFt001FindEntity>
     */
    public List<UaFt001FindEntity> getList() {
        return list;

    }

    /**
     *
     * @param entity HihokenshaNoFukaEntity
     */
    public void setHihokensha(HihokenshaNoFukaEntity entity) {
        hihokensha.add(entity);
    }

    /**
     *
     * @return hihokensha
     */
    public List<HihokenshaNoFukaEntity> getHihokensha() {
        return hihokensha;

    }

    /**
     *
     * @param entity HihokenshaNoFukaEntity
     */
    public void setDbT2008list(DbT2008ShotokuKanriEntity entity) {
        dbt2008list.add(entity);
    }

    /**
     *
     * @return hihokensha
     */
    public List<DbT2008ShotokuKanriEntity> getDbT2008list() {
        return dbt2008list;
    }

    /**
     *
     * @param parameter KogakuKaigoTaishoProcessParameter
     * @param 団体コード RString
     * @param 出力順 RString
     * @return param
     */
    public KogakukaigotaishoshachushutsusokyubunParameter setparameter(KogakuKaigoTaishoProcessParameter parameter, RString 団体コード, RString 出力順) {
        ShikibetsuTaishoIdoSearchKeyBuilder keyBuilder = new ShikibetsuTaishoIdoSearchKeyBuilder(
                ShikibetsuTaishoIdoChushutsuKubun.異動処理日時で異動前後を抽出,
                parameter.get抽出期間開始日時(), parameter.get抽出期間終了日時());
        keyBuilder.set個人のみ取得区分(true);
        ShikibetsuTaishoPSMSearchKeyBuilder builder
                = new ShikibetsuTaishoPSMSearchKeyBuilder(GyomuCode.DB介護保険, KensakuYusenKubun.住登外優先);
        IShikibetsuTaishoPSMSearchKey key = builder.build();
        UaFt200FindShikibetsuTaishoFunction uaFt200Psm = new UaFt200FindShikibetsuTaishoFunction(key);
        RString 宛名識別対象 = new RString(uaFt200Psm.getParameterMap().get("psmShikibetsuTaisho").toString());
        RString 処理名 = ShoriName.高額介護対象者抽出_遡及分.get名称();
        KogakukaigotaishoshachushutsusokyubunParameter param
                = new KogakukaigotaishoshachushutsusokyubunParameter(parameter.get抽出期間開始日時(), parameter.get抽出期間終了日時(),
                        parameter.get開始年月日１(), parameter.get開始年月日１(),
                        宛名識別対象, parameter.get介護保険(), parameter.get処理年月日(),
                        出力順, 団体コード, 処理名, keyBuilder.build());
        return param;
    }
}
