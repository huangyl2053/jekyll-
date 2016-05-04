/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.service.core.futangendogakunintei;

import jp.co.ndensan.reams.db.dbd.entity.db.relate.futangendogakunintei.JukyushaDaichoEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
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

    private static final RString コード = new RString("003");
    private static final RString TXT被保険者番号 = new RString("被保険者番号");

    /**
     * コンストラクタです。
     */
    FutanGendogakuNinteiKanshoTsuchisho() {
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
     * アクセスログの記録。
     *
     * @param 被保険者番号 被保険者番号
     * @param 識別コード 識別コード
     */
    public void setAccessLogger(HihokenshaNo 被保険者番号, ShikibetsuCode 識別コード) {

        JukyushaDaichoEntity jukyushaDaicho = new JukyushaDaichoEntity();
        jukyushaDaicho.setコード(new Code(コード));
        jukyushaDaicho.setName(TXT被保険者番号);
        jukyushaDaicho.setValue(被保険者番号.value());
        jukyushaDaicho.set識別コード(識別コード);
        PersonalData personalData = toPersonalData(jukyushaDaicho);
        AccessLogger.log(AccessLogType.照会, personalData);
    }

    private PersonalData toPersonalData(JukyushaDaichoEntity jukyushaDaicho) {
        ExpandedInformation expandedInfo = new ExpandedInformation(
                new Code(コード), TXT被保険者番号, new RString(jukyushaDaicho.getValue().toString()));
        return PersonalData.of(jukyushaDaicho.get識別コード(), expandedInfo);
    }
}
