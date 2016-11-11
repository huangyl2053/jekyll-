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
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakukaigotaishoshachushutsusokyubun.KakobunJissekiKihonTempTableEntity;
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

    /**
     *
     * @param entity ShiKaKuiDoDeTaEntity
     * @return temoTableEntity
     */
    public KakobunJissekiKihonTempTableEntity settabentity(ShiKaKuiDoDeTaEntity entity) {
        KakobunJissekiKihonTempTableEntity temoTableEntity = new KakobunJissekiKihonTempTableEntity();
        temoTableEntity.setShikibetsuCode(entity.get識別コード());
        temoTableEntity.setHihokenshaNo(entity.get被保険者番号());
        temoTableEntity.setShotsicode(entity.get世帯コード());
        temoTableEntity.setNendo(entity.get賦課年度());
        temoTableEntity.setNengetsu(entity.get年月());
        temoTableEntity.setNengetsuymd(entity.get年月日());
        temoTableEntity.setChusyutsumaster1(entity.get抽出_マスタ1());
        temoTableEntity.setChusyutsumaster2(entity.get抽出_マスタ2());
        temoTableEntity.setChusyutsumaster3(entity.get抽出_マスタ3());
        temoTableEntity.setChusyutsumaster4(entity.get抽出_マスタ4());
        temoTableEntity.setChusyutsumaster5(entity.get抽出_マスタ5());
        temoTableEntity.setChusyutsumaster6(entity.get抽出_マスタ6());
        temoTableEntity.setChusyutsumaster7(entity.get抽出_マスタ7());
        temoTableEntity.setChusyutsumaster8(entity.get抽出_マスタ8());
        temoTableEntity.setChusyutsumaster9(entity.get抽出_マスタ9());
        temoTableEntity.setChusyutsumaster10(entity.get抽出_マスタ10());
        temoTableEntity.setChusyutsujiyu1(entity.get抽出_事由1());
        temoTableEntity.setChusyutsujiyu2(entity.get抽出_事由2());
        temoTableEntity.setChusyutsujiyu3(entity.get抽出_事由3());
        temoTableEntity.setChusyutsujiyu4(entity.get抽出_事由4());
        temoTableEntity.setChusyutsujiyu5(entity.get抽出_事由5());
        temoTableEntity.setChusyutsujiyu6(entity.get抽出_事由6());
        temoTableEntity.setChusyutsujiyu7(entity.get抽出_事由7());
        temoTableEntity.setChusyutsujiyu8(entity.get抽出_事由8());
        temoTableEntity.setChusyutsujiyu9(entity.get抽出_事由9());
        temoTableEntity.setChusyutsujiyu10(entity.get抽出_事由10());
        temoTableEntity.setChusyutsushikibetsu1(entity.get抽出_識別コード1());
        temoTableEntity.setChusyutsushikibetsu2(entity.get抽出_識別コード2());
        temoTableEntity.setChusyutsushikibetsu3(entity.get抽出_識別コード3());
        temoTableEntity.setChusyutsushikibetsu4(entity.get抽出_識別コード4());
        temoTableEntity.setChusyutsushikibetsu5(entity.get抽出_識別コード5());
        temoTableEntity.setChusyutsushikibetsu6(entity.get抽出_識別コード6());
        temoTableEntity.setChusyutsushikibetsu7(entity.get抽出_識別コード7());
        temoTableEntity.setChusyutsushikibetsu8(entity.get抽出_識別コード8());
        temoTableEntity.setChusyutsushikibetsu9(entity.get抽出_識別コード9());
        temoTableEntity.setChusyutsushikibetsu10(entity.get抽出_識別コード10());
        return temoTableEntity;
    }

    /**
     *
     * @param entity HihokenshaNoFukaEntity
     * @return temoTableEntity
     */
    public KakobunJissekiKihonTempTableEntity setprocess4(HihokenshaNoFukaEntity entity) {
        KakobunJissekiKihonTempTableEntity temoTableEntity = new KakobunJissekiKihonTempTableEntity();
        temoTableEntity.setShikibetsuCode(entity.get識別コード());
        temoTableEntity.setHihokenshaNo(entity.get被保険者番号());
        temoTableEntity.setShotsicode(entity.get世帯コード());
        temoTableEntity.setNendo(entity.get賦課年度());
        temoTableEntity.setNengetsu(entity.get年月());
        temoTableEntity.setNengetsuymd(entity.get年月日());
        temoTableEntity.setChusyutsumaster1(entity.get抽出_マスタ1());
        temoTableEntity.setChusyutsumaster2(entity.get抽出_マスタ2());
        temoTableEntity.setChusyutsumaster3(entity.get抽出_マスタ3());
        temoTableEntity.setChusyutsumaster4(entity.get抽出_マスタ4());
        temoTableEntity.setChusyutsumaster5(entity.get抽出_マスタ5());
        temoTableEntity.setChusyutsumaster6(entity.get抽出_マスタ6());
        temoTableEntity.setChusyutsumaster7(entity.get抽出_マスタ7());
        temoTableEntity.setChusyutsumaster8(entity.get抽出_マスタ8());
        temoTableEntity.setChusyutsumaster9(entity.get抽出_マスタ9());
        temoTableEntity.setChusyutsumaster10(entity.get抽出_マスタ10());
        temoTableEntity.setChusyutsujiyu1(entity.get抽出_事由1());
        temoTableEntity.setChusyutsujiyu2(entity.get抽出_事由2());
        temoTableEntity.setChusyutsujiyu3(entity.get抽出_事由3());
        temoTableEntity.setChusyutsujiyu4(entity.get抽出_事由4());
        temoTableEntity.setChusyutsujiyu5(entity.get抽出_事由5());
        temoTableEntity.setChusyutsujiyu6(entity.get抽出_事由6());
        temoTableEntity.setChusyutsujiyu7(entity.get抽出_事由7());
        temoTableEntity.setChusyutsujiyu8(entity.get抽出_事由8());
        temoTableEntity.setChusyutsujiyu9(entity.get抽出_事由9());
        temoTableEntity.setChusyutsujiyu10(entity.get抽出_事由10());
        temoTableEntity.setChusyutsushikibetsu1(entity.get抽出_識別コード1());
        temoTableEntity.setChusyutsushikibetsu2(entity.get抽出_識別コード2());
        temoTableEntity.setChusyutsushikibetsu3(entity.get抽出_識別コード3());
        temoTableEntity.setChusyutsushikibetsu4(entity.get抽出_識別コード4());
        temoTableEntity.setChusyutsushikibetsu5(entity.get抽出_識別コード5());
        temoTableEntity.setChusyutsushikibetsu6(entity.get抽出_識別コード6());
        temoTableEntity.setChusyutsushikibetsu7(entity.get抽出_識別コード7());
        temoTableEntity.setChusyutsushikibetsu8(entity.get抽出_識別コード8());
        temoTableEntity.setChusyutsushikibetsu9(entity.get抽出_識別コード9());
        temoTableEntity.setChusyutsushikibetsu10(entity.get抽出_識別コード10());
        return temoTableEntity;
    }
}
