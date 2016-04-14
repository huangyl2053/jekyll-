/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.service.core.futangendogakunintei;

import java.util.List;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT4018KaigoHokenFutanGendogakuNinteiEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.futangendogakunintei.JukyushaDaichoEntity;
import jp.co.ndensan.reams.db.dbd.persistence.db.basic.DbT4018KaigoHokenFutanGendogakuNinteiDac;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.service.core.MapperProvider;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogType;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogger;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.PersonalData;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 負担限度額認定更新のお知らせ通知書個別発行のサービスです。
 *
 * @reamsid_L DBD-3570-010 wangchao
 */
public class FutanGendogakuNinteiKanshoTsuchisho {

    private final MapperProvider mapperProvider;
    private final DbT4018KaigoHokenFutanGendogakuNinteiDac 介護保険負担限度額認定Dac;

    /**
     * コンストラクタです。
     */
    FutanGendogakuNinteiKanshoTsuchisho() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
        this.介護保険負担限度額認定Dac = InstanceProvider.create(DbT4018KaigoHokenFutanGendogakuNinteiDac.class);
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link RiyoshaFutanWariaiManager}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link RiyoshaFutanWariaiManager}のインスタンス
     */
    public static FutanGendogakuNinteiKanshoTsuchisho createInstance() {
        return InstanceProvider.create(FutanGendogakuNinteiKanshoTsuchisho.class);
    }

    /**
     * 負担限度額認定更新のお知らせ通知書が発行可能かどうかを判断する。
     *
     * @param 被保険者番号 被保険者番号
     * @param 識別コード 識別コード
     * @return 介護保険負担限度額認定の検索結果
     */
    public List selectCount(HihokenshaNo 被保険者番号, ShikibetsuCode 識別コード) {

        //アクセスログの記録
        JukyushaDaichoEntity jukyushaDaicho = new JukyushaDaichoEntity();
        jukyushaDaicho.setコード(new Code("003"));
        jukyushaDaicho.setName(new RString("被保険者番号"));
        jukyushaDaicho.setValue(被保険者番号);
        jukyushaDaicho.set識別コード(識別コード);
        PersonalData personalData = toPersonalData(jukyushaDaicho);
        AccessLogger.log(AccessLogType.照会, personalData);

        List<DbT4018KaigoHokenFutanGendogakuNinteiEntity> dbT4018EntityList
                = 介護保険負担限度額認定Dac.selectCount(被保険者番号);
        return dbT4018EntityList;
    }

    private PersonalData toPersonalData(JukyushaDaichoEntity jukyushaDaicho) {
        ExpandedInformation expandedInfo = new ExpandedInformation(
                new Code("0003"), new RString("被保険者番号"), new RString(jukyushaDaicho.getValue().toString()));
        return PersonalData.of(jukyushaDaicho.get識別コード(), expandedInfo);
    }
}
