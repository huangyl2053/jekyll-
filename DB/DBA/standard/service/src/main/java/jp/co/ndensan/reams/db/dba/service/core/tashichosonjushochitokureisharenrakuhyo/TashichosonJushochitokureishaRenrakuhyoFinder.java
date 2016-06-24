/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.service.core.tashichosonjushochitokureisharenrakuhyo;

import jp.co.ndensan.reams.db.dba.business.core.tatokukanrenchohyoshiji.TatokuKanrenChohyoShijiData;
import jp.co.ndensan.reams.db.dba.definition.mybatisprm.tatokukanrenchohyoshijidata.TatokuKanrenParameter;
import jp.co.ndensan.reams.db.dba.entity.db.relate.tashihenkotsuchisho.TatokuKanrenChohyoShijiDataEntity;
import jp.co.ndensan.reams.ur.urz.business.core.bunshono.BunshoNo;
import jp.co.ndensan.reams.ur.urz.service.core.bunshono.BunshoNoFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.bunshono.IBunshoNoFinder;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
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
        entity.set担当部署名敬称(parameter.get担当課名敬称());
        entity.set識別コード(parameter.get識別コード());
        entity.set被保険者番号(parameter.get措置被保険者番号());
        entity.setIdoYMD(parameter.get異動日());
        entity.setEdaNo(parameter.get枝番());
        entity.set入所年月日(parameter.get入所年月日());
        entity.set住所出力不要フラグ(parameter.is住所出力不要フラグ());
        return new TatokuKanrenChohyoShijiData(entity);
    }

    /**
     * 文書番号取得。
     *
     * @param 帳票ID 帳票ID
     * @return BunshoNo
     */
    public BunshoNo get文書番号取得(ReportId 帳票ID) {

        IBunshoNoFinder bushoFineder = BunshoNoFinderFactory.createInstance();
        return bushoFineder.get文書番号管理(帳票ID, FlexibleDate.getNowDate());
    }
}
