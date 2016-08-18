/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC2000023;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.report.futanwariaisho.FutanWariaiShoDivParameter;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC2000023.RiyoshaFutanWariaiKoushiConfDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.viewbox.dbc2000022.FutanWariaiSokujiKouseiServiceData;
import jp.co.ndensan.reams.db.dbc.service.core.futanwariai.RiyoshaFutanWariaiSokujiKouseiManager;
import jp.co.ndensan.reams.db.dbc.service.core.futanwariaisho.FutanWariaisho;
import jp.co.ndensan.reams.db.dbc.service.core.riyoshafutanwariaihantei.RiyoshaFutanWariaiHantei;
import jp.co.ndensan.reams.db.dbd.business.core.futanwariai.RiyoshaFutanWariai;
import jp.co.ndensan.reams.db.dbd.business.core.futanwariai.RiyoshaFutanWariaiMeisai;
import jp.co.ndensan.reams.db.dbx.definition.core.codeshubetsu.DBCCodeShubetsu;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ShoKofuKaishu;
import jp.co.ndensan.reams.db.dbz.definition.core.futanwariai.FutanwariaiKubun;
import jp.co.ndensan.reams.db.dbz.service.TaishoshaKey;
import jp.co.ndensan.reams.db.dbz.service.core.basic.ShoKofuKaishuManager;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrInformationMessages;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogType;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogger;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.PersonalData;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;
import jp.co.ndensan.reams.uz.uza.ui.servlets.CommonButtonHolder;
import jp.co.ndensan.reams.uz.uza.util.code.CodeMaster;
import jp.co.ndensan.reams.uz.uza.util.code.entity.UzT0007CodeEntity;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 画面設計_DBCMNK2001_利用者負担割合即時更正_更新結果確認のHandlerクラスです。
 *
 * @reamsid_L DBC-5010-012 lijian
 */
public class RiyoshaFutanWariaiKoushiConfHandler {

    private final RiyoshaFutanWariaiKoushiConfDiv div;
    private static final int INT_1 = 1;
    private static final boolean TRUE = true;
    private static final boolean FALSE = false;
    private static final RString 発行する = new RString("btnPrint");
    private static final RString 定数_被保険者番号 = new RString("被保険者番号");
    private static final RString コード種別 = new RString("0016");
    private static final RString 単票発行で発行済み = new RString("2");
    private static final RString パラメータ = new RString("2");
    private static final RString 交付証種類 = new RString("003");
    private static final RString INFOCODE = new RString("0003");

    /**
     * コンストラクタです。
     *
     * @param div RiyoshaFutanWariaiKoushiConfDiv
     */
    public RiyoshaFutanWariaiKoushiConfHandler(RiyoshaFutanWariaiKoushiConfDiv div) {
        this.div = div;
    }

    /**
     * 画面初期化のメソッドます。
     *
     * @param 引継ぎデータ RiyoshaFutanWariaiKoushiConfData
     * @param 資格対象者 TaishoshaKey
     */
    public void initialize(FutanWariaiSokujiKouseiServiceData 引継ぎデータ, TaishoshaKey 資格対象者) {

        RiyoshaFutanWariai 利用者負担割合 = 引継ぎデータ.get利用者負担割合();

        boolean 登録結果 = 引継ぎデータ.is登録結果();
        List<RiyoshaFutanWariaiMeisai> 利用者負担割合明細list = 引継ぎデータ.get利用者負担割合明細list();

        if (登録結果) {
            div.getCcdKaigoKanryoMessage().
                    setMessage(UrInformationMessages.保存終了, 利用者負担割合.get被保険者番号().value(),
                            引継ぎデータ.get漢字氏名(), true);
        } else {

            throw new ApplicationException(UrErrorMessages.異常終了.getMessage());
        }

        if (利用者負担割合.get論理削除フラグ()) {
            div.getPanelHakko().getTxtHakkobi().clearValue();
            div.getPanelHakko().getTxtHakkobi().setDisabled(true);
            div.getPanelHakko().getTxtKofubi().clearValue();
            div.getPanelHakko().getTxtKofubi().setDisabled(true);
            List<KeyValueDataSource> list = new ArrayList<>();
            div.getPanelHakko().getDdlKofuJiyu().setDataSource(list);
            div.getPanelHakko().getDdlKofuJiyu().setDisabled(true);
            div.getPanelShutsuryokuNaiyo().getLbl2wari().setText(RString.EMPTY);
            div.getPanelShutsuryokuNaiyo().getLbl2wariKaishiYmd().setText(RString.EMPTY);
            div.getPanelShutsuryokuNaiyo().getLbl2wariShuryoYmd().setText(RString.EMPTY);
            div.getPanelShutsuryokuNaiyo().getLbl1wari().setText(RString.EMPTY);
            div.getPanelShutsuryokuNaiyo().getLbl1wariKaishiYmd().setText(RString.EMPTY);
            div.getPanelShutsuryokuNaiyo().getLbl1wariShuryoYmd().setText(RString.EMPTY);
            CommonButtonHolder.setDisabledByCommonButtonFieldName(発行する, true);
        } else {

            RiyoshaFutanWariaiHantei source = new RiyoshaFutanWariaiHantei();
            List<RiyoshaFutanWariaiMeisai> 利用者負担割合明細後list
                    = source.riyoshaFutanWariaiMeisaiMergeGamen(利用者負担割合明細list);
            div.getPanelHakko().getTxtHakkobi().setValue(RDate.getNowDate());
            div.getPanelHakko().getTxtKofubi().setValue(RDate.getNowDate());
            List<KeyValueDataSource> dataSourceList = get交付事由();
            div.getPanelHakko().getDdlKofuJiyu().setDataSource(dataSourceList);

            if (INT_1 < 利用者負担割合明細後list.size()) {

                RiyoshaFutanWariaiMeisai 利用者負担割合明細one = 利用者負担割合明細後list.get(利用者負担割合明細後list.size() - 2);
                div.getPanelShutsuryokuNaiyo().getLbl2wari().setText(FutanwariaiKubun.toValue(利用者負担割合明細one.get負担割合区分()).get名称());
                div.getPanelShutsuryokuNaiyo().getLbl2wariKaishiYmd().setText(new RString(利用者負担割合明細one.get有効開始日().toString()));
                div.getPanelShutsuryokuNaiyo().getLbl2wariShuryoYmd().setText(new RString(利用者負担割合明細one.get有効終了日().toString()));

                RiyoshaFutanWariaiMeisai 利用者負担割合明細two = 利用者負担割合明細後list.get(利用者負担割合明細後list.size() - 1);
                div.getPanelShutsuryokuNaiyo().getLbl1wari().setText(FutanwariaiKubun.toValue(利用者負担割合明細two.get負担割合区分()).get名称());
                div.getPanelShutsuryokuNaiyo().getLbl1wariKaishiYmd().setText(new RString(利用者負担割合明細two.get有効開始日().toString()));
                div.getPanelShutsuryokuNaiyo().getLbl1wariShuryoYmd().setText(new RString(利用者負担割合明細two.get有効終了日().toString()));
            } else if (利用者負担割合明細後list.size() == INT_1) {
                RiyoshaFutanWariaiMeisai 利用者負担割合明細 = 利用者負担割合明細後list.get(0);
                div.getPanelShutsuryokuNaiyo().getLbl2wari().setText(FutanwariaiKubun.toValue(利用者負担割合明細.get負担割合区分()).get名称());
                div.getPanelShutsuryokuNaiyo().getLbl2wariKaishiYmd().setText(new RString(利用者負担割合明細.get有効開始日().toString()));
                div.getPanelShutsuryokuNaiyo().getLbl2wariShuryoYmd().setText(new RString(利用者負担割合明細.get有効終了日().toString()));
                div.getPanelShutsuryokuNaiyo().getLbl1wari().setText(RString.EMPTY);
                div.getPanelShutsuryokuNaiyo().getLbl1wariKaishiYmd().setText(RString.EMPTY);
                div.getPanelShutsuryokuNaiyo().getLbl1wariShuryoYmd().setText(RString.EMPTY);
            }
        }

        AccessLogger.log(AccessLogType.照会, toPersonalData(資格対象者.get識別コード(), 利用者負担割合.get被保険者番号().getColumnValue()));
    }

    private PersonalData toPersonalData(ShikibetsuCode 識別コード, RString 被保険者番号) {

        ExpandedInformation expandedInfo3 = new ExpandedInformation(new Code(INFOCODE), 定数_被保険者番号, 被保険者番号);
        return PersonalData.of(識別コード, expandedInfo3);
    }

    /**
     * 交付事由
     *
     * @return dataSourceList
     */
    public List<KeyValueDataSource> get交付事由() {
        List<KeyValueDataSource> dataSourceList = new ArrayList<>();
        KeyValueDataSource dataSourceBlank = new KeyValueDataSource();
        dataSourceList.add(dataSourceBlank);
        List<UzT0007CodeEntity> costlist = CodeMaster.getCode(
                SubGyomuCode.DBC介護給付, DBCCodeShubetsu.過誤申立事由_上２桁_様式番号.getコード(), FlexibleDate.getNowDate());
        for (UzT0007CodeEntity list : costlist) {
            KeyValueDataSource dataSource = new KeyValueDataSource(list.getコード().value(), list.getコード名称());
            dataSourceList.add(dataSource);
        }
        return dataSourceList;
    }

    /**
     * 利用者負担割合の更新。
     *
     * @param div RiyoshaFutanWariaiKoushiConfDiv
     * @param 引継ぎデータ RiyoshaFutanWariaiKoushiConfData
     */
    public void updateDB(RiyoshaFutanWariaiKoushiConfDiv div, FutanWariaiSokujiKouseiServiceData 引継ぎデータ) {

        RiyoshaFutanWariai riyoshaFutanWariai = 引継ぎデータ.get利用者負担割合();

        riyoshaFutanWariai.createBuilderForEdit().set発行区分(単票発行で発行済み)
                .set発行日(new FlexibleDate(div.getPanelHakko().getTxtHakkobi().getValue().toDateString()))
                .set交付日(new FlexibleDate(div.getPanelHakko().getTxtKofubi().getValue().toDateString()))
                .build();

        riyoshaFutanWariai.toEntity().setState(EntityDataState.Modified);
        RiyoshaFutanWariaiSokujiKouseiManager manage = RiyoshaFutanWariaiSokujiKouseiManager.createInstance();
        manage.save(riyoshaFutanWariai, null, null);

    }

    /**
     * 証交付改修の登録（insert）
     *
     * @param div RiyoshaFutanWariaiKoushiConfDiv
     * @param 引継ぎデータ RiyoshaFutanWariaiKoushiConfData
     * @param 資格対象者 TaishoshaKey
     */
    public void insertDB(RiyoshaFutanWariaiKoushiConfDiv div,
            FutanWariaiSokujiKouseiServiceData 引継ぎデータ,
            TaishoshaKey 資格対象者) {

        ShoKofuKaishuManager manage = new ShoKofuKaishuManager();
        int 履歴番号 = manage.get証交付回収(資格対象者.get被保険者番号(), 交付証種類).get履歴番号();
        ShoKofuKaishu shoKofuKaishu = new ShoKofuKaishu(資格対象者.get被保険者番号(), 交付証種類, 履歴番号);

        shoKofuKaishu.createBuilderForEdit().set被保険者番号(資格対象者.get被保険者番号()).set交付証種類(交付証種類)
                .set交付証種類(コード種別).set履歴番号(shoKofuKaishu.get履歴番号() + 1)
                .set市町村コード(AssociationFinderFactory.createInstance().getAssociation().get地方公共団体コード())
                .set識別コード(資格対象者.get識別コード())
                .set交付年月日(new FlexibleDate(div.getPanelHakko().getTxtKofubi().getValue().toDateString()))
                .set有効期限(new FlexibleDate(div.getPanelShutsuryokuNaiyo().getLbl1wariShuryoYmd().getText()))
                .set交付事由(div.getPanelHakko().getDdlKofuJiyu().getSelectedValue())
                .set交付理由(RString.EMPTY)
                .set回収年月日(new FlexibleDate(RString.EMPTY))
                .set回収事由(RString.EMPTY)
                .set単票発行有無フラグ(TRUE)
                .set発行処理日時(new YMDHMS(RDate.getNowDate().toDateString()))
                .set新様式印書済区分コード(RString.EMPTY)
                .set証様式区分コード(RString.EMPTY)
                .set論理削除フラグ(FALSE)
                .build();

        shoKofuKaishu.toEntity().setState(EntityDataState.Added);

        manage.save証交付回収(shoKofuKaishu);

    }

    /**
     * 負担割合証のソースデータ取得
     *
     * @param div RiyoshaFutanWariaiKoushiConfDiv
     * @param 引継ぎデータ RiyoshaFutanWariaiKoushiConfData
     * @param 資格対象者 TaishoshaKey
     */
    public void getソースデータ取得(RiyoshaFutanWariaiKoushiConfDiv div,
            FutanWariaiSokujiKouseiServiceData 引継ぎデータ,
            TaishoshaKey 資格対象者) {
        FutanWariaisho futanWariaisho;
        futanWariaisho = FutanWariaisho.createInstance();
        ShikibetsuCode 識別コード;
        識別コード = 資格対象者.get識別コード();
        HihokenshaNo 被保険者番号 = 資格対象者.get被保険者番号();
        FutanWariaiShoDivParameter parameter = new FutanWariaiShoDivParameter();

        parameter.set負担割合上段(div.getPanelShutsuryokuNaiyo().getLbl2wari().getText());
        parameter.set適用期間開始日上段(new FlexibleDate(div.getPanelShutsuryokuNaiyo().getLbl2wariKaishiYmd().getText()));
        parameter.set適用期間終了日上段(new FlexibleDate(div.getPanelShutsuryokuNaiyo().getLbl2wariShuryoYmd().getText()));
        parameter.set負担割合下段(div.getPanelShutsuryokuNaiyo().getLbl1wari().getText());
        parameter.set適用期間開始日下段(new FlexibleDate(div.getPanelShutsuryokuNaiyo().getLbl1wariKaishiYmd().getText()));
        parameter.set適用期間終了日下段(new FlexibleDate(div.getPanelShutsuryokuNaiyo().getLbl1wariShuryoYmd().getText()));

        futanWariaisho.getSourceData(識別コード, 被保険者番号, parameter, パラメータ);
    }
}
