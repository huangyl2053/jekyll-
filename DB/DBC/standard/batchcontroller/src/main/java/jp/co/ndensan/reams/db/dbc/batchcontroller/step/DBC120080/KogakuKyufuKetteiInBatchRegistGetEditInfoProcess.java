/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC120080;

import jp.co.ndensan.reams.db.dbc.definition.core.kogakuserviceketteijohotorikomidatahenshu.HihokenshaNoDataParameter;
import jp.co.ndensan.reams.db.dbc.definition.core.kogakuserviceketteijohotorikomidatahenshu.SinBangoTempParameter;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.kagoketteikohifutanshain.PSMParameter;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.kagoketteikohifutanshain.ShichosonHihokenshaParameter;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.kagoketteikohifutanshain.ShikibetsuCodeTempParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakukyufuketteiin.KogakuKyufuKetteiInTempTableEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakukyufuketteiin.PSMEntity;
import jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.kogakuserviceketteijohotorikomidatahenshu.IKogakuServiceKetteiJohoTorikomiDataHenshuMapper;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1001HihokenshaDaichoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7026ShinKyuHihokenshaNoHenkanEntity;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoPSMSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.KensakuYusenKubun;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.psm.DataShutokuKubun;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.IShikibetsuTaishoPSMSearchKey;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.CodeShubetsu;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.code.CodeMaster;
import jp.co.ndensan.reams.uz.uza.util.code.entity.UzT0007CodeEntity;

/**
 * 一時テーブルにデータの編集
 */
public class KogakuKyufuKetteiInBatchRegistGetEditInfoProcess extends BatchProcessBase<KogakuKyufuKetteiInTempTableEntity> {

    private static final RString READ_DATA_ID = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper."
            + "relate.kogakuserviceketteijohotorikomidatahenshu."
            + "IKogakuServiceKetteiJohoTorikomiDataHenshuMapper.select被保険者番号");

    private IKogakuServiceKetteiJohoTorikomiDataHenshuMapper mapper;

    @Override
    protected void initialize() {
        super.initialize();
        mapper = getMapper(IKogakuServiceKetteiJohoTorikomiDataHenshuMapper.class);
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(READ_DATA_ID);
    }

    @Override
    protected void process(KogakuKyufuKetteiInTempTableEntity entity) {
        HihokenshaNo 被保険者番号 = entity.get被保険者番号();
        ShichosonHihokenshaParameter parameter1 = ShichosonHihokenshaParameter.createParameter(被保険者番号);
        DbT1001HihokenshaDaichoEntity 被保険者台帳管理 = mapper.select市町村コード(parameter1);
        if (null != 被保険者台帳管理) {
            LasdecCode 市町村コード = 被保険者台帳管理.getShichosonCode();
            ShichosonHihokenshaParameter parameter2 = ShichosonHihokenshaParameter
                    .createParameter(被保険者番号, 市町村コード);
            DbT7026ShinKyuHihokenshaNoHenkanEntity henkanEntity = mapper.select新番号(parameter2);
            if (henkanEntity != null) {
                RString 新番号 = henkanEntity.getShinNo();
                RString 旧番号 = henkanEntity.getKyuNo();
                SinBangoTempParameter parameter3 = SinBangoTempParameter.createParameter(新番号, 旧番号);
                mapper.update高額サービス費決定情報一時TBL1(parameter3);
            }
        }
        DbT1001HihokenshaDaichoEntity 被保険者台帳管理1 = mapper.select被保険者情報();
        if (被保険者台帳管理1 != null) {
            HihokenshaNo 被保険者番号_New = 被保険者台帳管理1.getHihokenshaNo();
            ShikibetsuCode 識別コード = 被保険者台帳管理1.getShikibetsuCode();
            RDate date = RDate.getNowDate();
            UzT0007CodeEntity 資格喪失事由コード = CodeMaster.getCode(SubGyomuCode.DBA介護資格,
                    new CodeShubetsu(new RString("0010")), new Code(被保険者台帳管理1.getShikakuSoshitsuJiyuCode()),
                    new FlexibleDate(date.toDateString()));
//            RString 資格喪失事由コード = 被保険者台帳管理1.getShikakuSoshitsuJiyuCode();
            FlexibleDate 資格喪失年月日 = 被保険者台帳管理1.getShikakuSoshitsuYMD();
            HihokenshaNoDataParameter parmeter4 = HihokenshaNoDataParameter
                    .creatParmeter(被保険者番号_New, 識別コード, new RString(資格喪失事由コード.toString()), 資格喪失年月日);
            mapper.update高額サービス費決定情報一時TBL2(parmeter4);
            KogakuKyufuKetteiInTempTableEntity 一時デーブルから識別コード = mapper.select一時デーブルから識別コード();
            ShikibetsuTaishoPSMSearchKeyBuilder builder
                    = new ShikibetsuTaishoPSMSearchKeyBuilder(GyomuCode.DB介護保険, KensakuYusenKubun.住登外優先);
            builder.setデータ取得区分(DataShutokuKubun.直近レコード);
            builder.set識別コード(識別コード);
            IShikibetsuTaishoPSMSearchKey key = builder.build();
            PSMParameter parameter5 = new PSMParameter(key);
            PSMEntity 宛名識別対象PSM = mapper.select宛名識別対象PSM(parameter5);
            ShikibetsuCodeTempParameter parameter6 = ShikibetsuCodeTempParameter.createParameter(
                    一時デーブルから識別コード.get識別コード(),
                    宛名識別対象PSM.get全国住所コード(),
                    宛名識別対象PSM.get郵便番号(),
                    宛名識別対象PSM.get住所(),
                    宛名識別対象PSM.get行政区コード(),
                    宛名識別対象PSM.get行政区名(),
                    宛名識別対象PSM.getカナ名称(),
                    宛名識別対象PSM.get名称());
            mapper.update高額サービス費決定情報一時TBL3(parameter6);
        }
    }
}
