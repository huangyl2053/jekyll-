/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD9010002;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbd.business.core.basic.IryohiKojo;
import jp.co.ndensan.reams.db.dbd.business.core.basic.IryohiKojoBuilder;
import jp.co.ndensan.reams.db.dbd.business.core.iryohikojokakuninsinsei.IryohiKojoEntityResult;
import jp.co.ndensan.reams.db.dbd.business.core.iryohikojokakuninsinsei.OmutsusiyoSyomeishoEntity;
import jp.co.ndensan.reams.db.dbd.definition.core.iryohikojo.IryoHiKojoNaiyo;
import jp.co.ndensan.reams.db.dbd.definition.message.DbdErrorMessages;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD9010002.OmutsusiyoSyomeishoDiv;
import jp.co.ndensan.reams.db.dbd.service.core.basic.IryohiKojoManager;
import jp.co.ndensan.reams.db.dbd.service.core.iryohikojokakuninsinsei.IryoHiKojoKakuninSinsei;
import jp.co.ndensan.reams.db.dbd.service.report.dbd100029.OmutsuShoumeishoPrintService;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.service.TaishoshaKey;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.exclusion.LockingKey;
import jp.co.ndensan.reams.uz.uza.exclusion.RealInitialLocker;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RYear;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogType;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogger;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.PersonalData;
import jp.co.ndensan.reams.uz.uza.report.SourceDataCollection;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;
import jp.co.ndensan.reams.uz.uza.ui.servlets.CommonButtonHolder;

/**
 * おむつ使用証明書画面のHandlerです。
 *
 * @reamsid_L DBD-5780-010 tz_chengpeng
 */
public class OmutsusiyoSyomeishoHandler {

    private final OmutsusiyoSyomeishoDiv div;

    /**
     * コンストラクタです。
     *
     * @param div OmutsusiyoSyomeishoDiv
     */
    public OmutsusiyoSyomeishoHandler(OmutsusiyoSyomeishoDiv div) {
        this.div = div;
    }

    /**
     * 画面初期化
     *
     * @param 引き継ぎEntity 引き継ぎEntity
     * @return List<IryohiKojoEntity>
     */
    public List<IryohiKojoEntityResult> onLoad(TaishoshaKey 引き継ぎEntity) {
        div.getTxtCyouhyou().setValue(new RString("おむつ使用証明書"));
        RString 被保険者番号 = 引き継ぎEntity.get被保険者番号().value();
        IryoHiKojoKakuninSinsei iryoHiKojoKakuninSinsei = IryoHiKojoKakuninSinsei.createIntance();
        if (!iryoHiKojoKakuninSinsei.checkuJukyusha(被保険者番号)) {
            throw new ApplicationException(DbdErrorMessages.受給共通_受給者登録なし.getMessage());
        }
        List<IryohiKojoEntityResult> 医療費控除リスト = iryoHiKojoKakuninSinsei.getIryohikojyo_Chohyo(被保険者番号, IryoHiKojoNaiyo.おむつ使用証明書.getコード());
        if (医療費控除リスト.isEmpty()) {
            CommonButtonHolder.setDisabledByCommonButtonFieldName(new RString("reportPublishi"), true);
            throw new ApplicationException(UrErrorMessages.対象データなし_追加メッセージあり.getMessage().replace("おむつ使用証明書"));
        }

        div.getPanelKakuninsho().getCcdKaigoAtenaInfo().initialize(引き継ぎEntity.get識別コード());
        div.getPanelKakuninsho().getCcdKaigoShikakuKihon().initialize(引き継ぎEntity.get被保険者番号());
        RealInitialLocker.lock(new LockingKey(new RString("DB").concat(被保険者番号.concat(new RString("IryohiKojyoSyomeisho")))));
        AccessLogger.log(AccessLogType.照会, PersonalData.of(引き継ぎEntity.get識別コード(),
                ExpandedInformation.newBuilder().code(new Code("003")).name(new RString("被保険者番号")).value(被保険者番号).build()));
        List<KeyValueDataSource> 年度DDLデータ = new ArrayList<>();
        for (IryohiKojoEntityResult 医療費控除 : 医療費控除リスト) {
            KeyValueDataSource data = new KeyValueDataSource();
            RYear 控除対象年 = new RYear(医療費控除.get控除対象年());
            data.setKey(控除対象年.toDateString());
            data.setValue(控除対象年.wareki().toDateString());
            年度DDLデータ.add(data);
        }
        div.getPanelShosaiEria().getDdlTaishonen().setDataSource(年度DDLデータ);
        return 医療費控除リスト;
    }

    /**
     * 対象年DDLonChange
     *
     * @param 医療費控除リスト 医療費控除リスト
     */
    public void onChange対象年(List<IryohiKojoEntityResult> 医療費控除リスト) {
        RString 控除対象年 = div.getPanelShosaiEria().getDdlTaishonen().getSelectedKey();
        IryohiKojoEntityResult 表示対象データ = null;
        for (IryohiKojoEntityResult 医療費控除 : 医療費控除リスト) {
            if (控除対象年.equals(医療費控除.get控除対象年())) {
                表示対象データ = 医療費控除;
                break;
            }
        }
        if (表示対象データ != null) {
            div.getPanelShosaiEria().getTxtZenkaiHakkouBi()
                    .setValue((表示対象データ.get発行年月日() != null && !表示対象データ.get発行年月日().isEmpty())
                            ? new RDate(表示対象データ.get発行年月日().toString()) : null);
            div.getPanelShosaiEria().getTxtShinseiBi()
                    .setValue((表示対象データ.get申請年月日() != null && !表示対象データ.get申請年月日().isEmpty())
                            ? new RDate(表示対象データ.get申請年月日().toString()) : null);
        }
    }

    /**
     * 「発行する」ボタンonClick
     *
     * @param 引き継ぎEntity 引き継ぎEntity
     * @param 医療費控除リスト 医療費控除リスト
     * @return SourceDataCollection
     */
    public SourceDataCollection publishReport(TaishoshaKey 引き継ぎEntity, List<IryohiKojoEntityResult> 医療費控除リスト) {
        ShikibetsuCode 識別コード = 引き継ぎEntity.get識別コード();
        HihokenshaNo 被保険者番号 = 引き継ぎEntity.get被保険者番号();
        OmutsusiyoSyomeishoEntity おむつ使用証明書Entity = IryoHiKojoKakuninSinsei.createIntance()
                .editomutsusiyoSyomeisho(識別コード, new RString("DBD100029_OmutsuShoumeisho"));
        OmutsuShoumeishoPrintService printService = new OmutsuShoumeishoPrintService();
        SourceDataCollection collection = printService.printSingle(おむつ使用証明書Entity);
        AccessLogger.log(AccessLogType.更新, PersonalData.of(識別コード,
                ExpandedInformation.newBuilder().code(new Code("003")).name(new RString("被保険者番号"))
                .value(被保険者番号).build()));
        IryohiKojoManager manager = new IryohiKojoManager();
        IryohiKojoEntityResult 表示対象データ = new IryohiKojoEntityResult();
        RString 控除対象年 = div.getPanelShosaiEria().getDdlTaishonen().getSelectedKey();
        for (IryohiKojoEntityResult 医療費控除 : 医療費控除リスト) {
            if (控除対象年.equals(医療費控除.get控除対象年())) {
                表示対象データ = 医療費控除;
                break;
            }
        }
        IryohiKojo 医療費控除 = manager.get医療費控除(被保険者番号,
                new FlexibleYear(控除対象年),
                表示対象データ.getデータ区分());
        IryohiKojoBuilder builder = 医療費控除.createBuilderForEdit();
        builder.set発行年月日(new FlexibleDate(div.getPanelShosaiEria().getTxtSakuseiBi().getValue().toDateString()));
        manager.save医療費控除(builder.build());
        return collection;
    }
}
