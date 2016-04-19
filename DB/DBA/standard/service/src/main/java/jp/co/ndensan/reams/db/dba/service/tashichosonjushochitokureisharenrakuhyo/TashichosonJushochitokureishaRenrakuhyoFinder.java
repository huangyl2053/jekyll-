/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.service.tashichosonjushochitokureisharenrakuhyo;

import jp.co.ndensan.reams.db.dba.business.core.tatokukanrenchohyoshiji.TatokuKanrenChohyoShijiData;
import jp.co.ndensan.reams.db.dba.business.core.tatokukanrenchohyoshiji.TatokuKanrenChohyoSofusaki;
import jp.co.ndensan.reams.db.dba.definition.tatokukanrenchohyoshijidata.TatokuKanrenParameter;
import jp.co.ndensan.reams.db.dba.entity.TatokuKanrenChohyoShijiDataEntity;
import jp.co.ndensan.reams.db.dba.entity.db.relate.tatokukanrenchohyoshiji.TatokuKanrenChohyoSofusakiEntity;
import jp.co.ndensan.reams.db.dbz.service.util.report.ReportUtil;
import jp.co.ndensan.reams.ur.urz.definition.core.tashichosonsofusakimaintenance.SofusakiGroup;
import jp.co.ndensan.reams.ur.urz.service.core.chihokokyodantai.CityAtesakiService;
import jp.co.ndensan.reams.ur.urz.service.core.chihokokyodantai.ICityAtesakiFinder;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 他市町村住所地特例者関連帳票クラスです。
 *
 * @reamsid_L DBA-0380-030 houtianpeng
 */
public class TashichosonJushochitokureishaRenrakuhyoFinder {

    /**
     * {@link InstanceProvider#create}にて生成した{@link TashichosonJushochitokureishaRenrakuhyoFinder}のインスタンスを返します。
     *
     * @return
     * {@link InstanceProvider#create}にて生成した{@link TashichosonJushochitokureishaRenrakuhyoFinder}のインスタンス
     */
    public static TashichosonJushochitokureishaRenrakuhyoFinder createInstance() {
        return InstanceProvider.create(TashichosonJushochitokureishaRenrakuhyoFinder.class);
    }

    /**
     * 帳票発行指示データ作成。
     *
     * @param parameter TatokuKanrenParameter
     * @return TatokuKanrenChohyoShijiDataEntity
     */
    public TatokuKanrenChohyoShijiData setChohyoData(TatokuKanrenParameter parameter) {
        TatokuKanrenChohyoShijiDataEntity entity = new TatokuKanrenChohyoShijiDataEntity();
        entity.set保険者郵便番号(parameter.get郵便番号());
        entity.set文書番号(parameter.get文書番号());
        entity.set保険者住所(parameter.get住所());
        entity.set発行年月日(parameter.get発行日());
        entity.set保険者名(parameter.get役所名());
        entity.set保険者名敬称(parameter.get役所名敬称());
        entity.set担当部署名(parameter.get担当課名());
        entity.set担当部署名敬称(parameter.get担当部署名敬称());
        entity.set識別コード(parameter.get識別コード());
        entity.set被保険者番号(parameter.get被保険者番号());
        entity.setIdoYMD(parameter.get他市町村住所地特例異動日());
        entity.setEdaNo(parameter.get他市町村住所地特例枝番());
        entity.set入所年月日(parameter.get入所日());
        return new TatokuKanrenChohyoShijiData(entity);
    }

    /**
     * 画面初期値取得。
     *
     * @param 市町村コード 市町村コード
     * @param 遷移元メニューID 遷移元メニューID
     * @return TatokuKanrenChohyoSofusaki
     */
    public TatokuKanrenChohyoSofusaki getDefaultValue(RString 市町村コード, ReportId 遷移元メニューID) {

        TatokuKanrenChohyoSofusakiEntity entity = new TatokuKanrenChohyoSofusakiEntity();
        ICityAtesakiFinder finder = CityAtesakiService.createCityAtesakiFinder();
        entity.set郵便番号(finder.get市町村宛先(new LasdecCode(市町村コード == null ? RString.EMPTY : 市町村コード),
                SofusakiGroup.住基関連.getCode()).get郵便番号());
        entity.set住所(finder.get市町村宛先(new LasdecCode(市町村コード == null ? RString.EMPTY : 市町村コード),
                SofusakiGroup.住基関連.getCode()).get住所());
        entity.set役所名(finder.get市町村宛先(new LasdecCode(市町村コード == null ? RString.EMPTY : 市町村コード),
                SofusakiGroup.住基関連.getCode()).get名称());
//        TODO QA1036 entity.set役所名敬称(BusinessConfig);
//        介護資格業務コンフィグ.他住所地特例施設退所通知_送付先情報_役場・役所名敬称
//介護資格業務コンフィグ.他住所地特例施設退所通知_送付先情報_担当課名
//介護資格業務コンフィグ.他住所地特例施設退所通知_送付先情報_担当課名敬称
        entity.set発行日(FlexibleDate.getNowDate());
        entity.set文書番号(ReportUtil.get文書番号(SubGyomuCode.DBA介護資格, 遷移元メニューID, FlexibleDate.getNowDate()));
        return new TatokuKanrenChohyoSofusaki(entity);
    }
}
