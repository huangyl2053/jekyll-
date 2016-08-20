/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC1310011;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.batchprm.DBC060010.DBC060010_KyufuhiTsuchiGenmenHoseiIchiranhyoParameter;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1310011.KyufuTsuchiGenmenHoseiDiv;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.DonyuKeitaiCode;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbx.service.core.shichosonsecurityjoho.ShichosonSecurityJoho;
import jp.co.ndensan.reams.db.dbz.business.core.koikizenshichosonjoho.KoikiZenShichosonJoho;
import jp.co.ndensan.reams.db.dbz.service.core.koikishichosonjoho.KoikiShichosonJohoFinder;
import jp.co.ndensan.reams.ur.urz.business.UrControlDataFactory;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.uz.uza.ILoginInfo;
import jp.co.ndensan.reams.uz.uza.auth.valueobject.AuthorityItem;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;

/**
 * 給付費通知減免補正一覧表作成のHandlerクラスです。
 *
 * @reamsid_L DBC-2270-010 lijia
 */
public class KyufuTsuchiGenmenHoseiHandler {

    private final KyufuTsuchiGenmenHoseiDiv div;
    private static final RString 市町村識別ID = new RString("00");

    /**
     * コンストラクタです。
     *
     * @param div JigyobunKogakuGassanFurikomiMeisaishoBatchParamDiv
     */
    public KyufuTsuchiGenmenHoseiHandler(KyufuTsuchiGenmenHoseiDiv div) {
        this.div = div;
    }

    /**
     * 画面初期化のメソッドです。
     */
    public void initialize() {
        if (is広域()) {
            div.getKyufuTsuchiGenmenHoseiListSakusei().getDdlShichoson().setDisplayNone(false);
        } else {
            div.getKyufuTsuchiGenmenHoseiListSakusei().getDdlShichoson().setDisplayNone(true);
        }
        ILoginInfo iLoginInfo = UrControlDataFactory.createInstance().getLoginInfo();
        RString userId = iLoginInfo.getUserId();

        List<AuthorityItem> 市町村識別IDList = ShichosonSecurityJoho.getShichosonShikibetsuId(userId);

        List<KeyValueDataSource> 市町村DDL = new ArrayList<>();
        KeyValueDataSource source1 = new KeyValueDataSource();
        source1.setKey(new RString("000000"));
        source1.setValue(new RString("000000 全市町村"));
        市町村DDL.add(source1);
        for (AuthorityItem item : 市町村識別IDList) {
            if (市町村識別ID.equals(item.getItemId())) {
                市町村DDL = get現市町村情報();
            } else {
                KeyValueDataSource source = new KeyValueDataSource();
                source.setKey(item.getItemId());
                StringBuilder strBuilder = new StringBuilder();
                strBuilder.append(item.getItemId());
                strBuilder.append(RString.HALF_SPACE);
                strBuilder.append(item.getItemName());
                source.setValue(new RString(strBuilder.toString()));
                市町村DDL.add(source);
            }
        }
        div.getKyufuTsuchiGenmenHoseiListSakusei().getDdlShichoson().setDataSource(市町村DDL);
        //TODO 帳票出力順共有子(URZ.ChohyoShutsuryokujun)
        div.getCcdChohyoShutsuryokujun().load(SubGyomuCode.DBC介護給付, new ReportId(new RString("DBC200043_KyufuhiTuchiGenmenhoseiIchiran")));
    }

    /**
     * 給付費通知減免補正一覧表のバッチ用パラメータです。
     *
     * @return DBC060010_KyufuhiTsuchiGenmenHoseiIchiranhyoParameter 給付費通知減免補正一覧表のバッチ用パラメータ
     */
    public DBC060010_KyufuhiTsuchiGenmenHoseiIchiranhyoParameter btnPulish() {
        DBC060010_KyufuhiTsuchiGenmenHoseiIchiranhyoParameter paramter = new DBC060010_KyufuhiTsuchiGenmenHoseiIchiranhyoParameter();
        RString サービス開始年月 = div.getKyufuTsuchiGenmenHoseiListSakusei().getTxtServiceYM().getFromValue().getYearMonth().toDateString();
        RString サービス終了年月 = div.getKyufuTsuchiGenmenHoseiListSakusei().getTxtServiceYM().getToValue().getYearMonth().toDateString();
        List<HokenshaNo> 保険者番号List = new ArrayList<>();
        if (is広域()) {
            RString value = div.getKyufuTsuchiGenmenHoseiListSakusei().getDdlShichoson().getSelectedValue();
            if (value.contains("全市町村")) {
                List<KeyValueDataSource> 市町村コードList = div.getKyufuTsuchiGenmenHoseiListSakusei().getDdlShichoson().getDataSource();
                for (KeyValueDataSource source : 市町村コードList) {
                    保険者番号List.add(new HokenshaNo(source.getKey()));
                }
            } else {
                RString key = div.getKyufuTsuchiGenmenHoseiListSakusei().getDdlShichoson().getSelectedKey();
                保険者番号List.add(new HokenshaNo(key));
            }
        }
        if (is単一()) {
            LasdecCode 市町村コード = AssociationFinderFactory.createInstance().getAssociation().getLasdecCode_();
            保険者番号List.add(new HokenshaNo(市町村コード.value()));
        }
        paramter.setサービス開始年月(new FlexibleYearMonth(サービス開始年月));
        paramter.setサービス終了年月(new FlexibleYearMonth(サービス終了年月));
        paramter.set市町村コードList(保険者番号List);
        paramter.set帳票出力順ID(RString.EMPTY);
        return paramter;
    }

    private boolean is単一() {
        return DonyuKeitaiCode.事務単一.getCode()
                .equals(ShichosonSecurityJoho.getShichosonSecurityJoho(GyomuBunrui.介護事務).get導入形態コード().value());
    }

    private boolean is広域() {
        return DonyuKeitaiCode.事務広域.getCode()
                .equals(ShichosonSecurityJoho.getShichosonSecurityJoho(GyomuBunrui.介護事務).get導入形態コード().value());
    }

    private List<KeyValueDataSource> get現市町村情報() {
        List<KeyValueDataSource> 市町村DDL = new ArrayList<>();
        KeyValueDataSource source1 = new KeyValueDataSource();
        source1.setKey(new RString("000000"));
        source1.setValue(new RString("000000 全市町村"));
        市町村DDL.add(source1);
        KoikiShichosonJohoFinder finder = KoikiShichosonJohoFinder.createInstance();
        List<KoikiZenShichosonJoho> 現市町村情報list = finder.getGenShichosonJoho().records();
        for (KoikiZenShichosonJoho business : 現市町村情報list) {
            KeyValueDataSource source = new KeyValueDataSource();
            source.setKey(business.get市町村コード().value());
            StringBuilder strBuilder = new StringBuilder();
            strBuilder.append(business.get市町村コード().value());
            strBuilder.append(RString.HALF_SPACE);
            strBuilder.append(business.get市町村名称());
            source.setValue(new RString(strBuilder.toString()));
            市町村DDL.add(source);
        }
        return 市町村DDL;
    }
}
