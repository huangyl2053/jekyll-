/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.divcontroller.handler.parentdiv.DBA1090011;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dba.definition.reportid.ReportIdDBA;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.parentdiv.DBA1090011.MishorishaIchiranSakuseiDiv;
import jp.co.ndensan.reams.db.dbx.business.core.shichosonsecurityjoho.KoseiShichosonJoho;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.DonyuKeitaiCode;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;
import jp.co.ndensan.reams.db.dbx.service.core.shichosonsecurityjoho.ShichosonSecurityJoho;
import jp.co.ndensan.reams.ur.urz.business.UrControlDataFactory;
import jp.co.ndensan.reams.uz.uza.auth.valueobject.AuthorityItem;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;

/**
 * 転入・転出未登録一覧表のHandlerクラスです。
 *
 * @reamsid_L DBU-4110-010 yaodongsheng
 */
public class MishorishaIchiranSakuseiHandler {

    private static final RString KEY = new RString("000000");
    private static final RString VALUE = new RString("全市町村");
    private final MishorishaIchiranSakuseiDiv div;

    /**
     * コンストラクタです。
     *
     * @param div 転入・転出未登録一覧表Divのエンティティ
     */
    public MishorishaIchiranSakuseiHandler(MishorishaIchiranSakuseiDiv div) {
        this.div = div;
    }

    /**
     * 初期化です。
     */
    public void onLoad() {
        ShichosonSecurityJoho 市町村セキュリティ情報 = ShichosonSecurityJoho.getShichosonSecurityJoho(GyomuBunrui.介護事務);
        RString 導入形態コード = 市町村セキュリティ情報.get導入形態コード().value();
        setDivValue(導入形態コード);
    }

    private void setDivValue(RString 導入形態コード) {
        if (DonyuKeitaiCode.事務広域.getCode().equals(導入形態コード)) {
            List<KeyValueDataSource> list = new ArrayList<>();
            KeyValueDataSource dataSource = new KeyValueDataSource();
            dataSource.setKey(KEY);
            dataSource.setValue(setValue(KEY, VALUE));
            list.add(dataSource);
            div.getBatchParamterInfo().getDdlShichoson().setDisplayNone(false);
            div.getBatchParamterInfo().getLinShichosonShitei().setDisplayNone(false);
            List<AuthorityItem> authorityItemList = ShichosonSecurityJoho.getShichosonShikibetsuId(
                    UrControlDataFactory.createInstance().getLoginInfo().getUserId());
            for (AuthorityItem authorityItem : authorityItemList) {
                KoseiShichosonJoho 構成市町村情報 = ShichosonSecurityJoho.getKouseiShichosonJoho(authorityItem.getItemId());
                if (構成市町村情報 != null) {
                    KeyValueDataSource keyValue = new KeyValueDataSource();
                    keyValue.setKey(構成市町村情報.get市町村コード().value());
                    keyValue.setValue(setValue(構成市町村情報.get市町村コード().value(), 構成市町村情報.get市町村名称()));
                    list.add(keyValue);
                }
            }
            div.getBatchParamterInfo().getDdlShichoson().setDataSource(list);
        }
        div.getBatchParamterInfo().getCcdChohyoShutsuryokujun().load(SubGyomuCode.DBA介護資格, ReportIdDBA.DBA200014.getReportId());
    }

    private RString setValue(RString 市町村コード, RString 市町村名) {
        return new RStringBuilder().append(市町村コード).append(RString.HALF_SPACE).append(市町村名).toRString();
    }
}
